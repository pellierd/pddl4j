/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.parser.Connector;
import fr.uga.pddl4j.parser.DefaultParsedProblem;
import fr.uga.pddl4j.parser.Expression;
import fr.uga.pddl4j.parser.Symbol;
import fr.uga.pddl4j.parser.SymbolType;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.util.IntMatrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This class contains all the methods needed to the pre-treatments carried out before the instantiation of a problem:
 * type inference for non-typed domains and inertia extraction to speed up the instantiation process.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public abstract class PreInstantiatedProblem extends AbstractProblem {

    /**
     * The table that defines for each predicates its type of inertia.
     */
    private List<Inertia> inertia;

    /**
     * The table that defines for each numeric fluents its type of inertia.
     */
    private List<Inertia> numericInertia;

    /**
     * The table of inferred domains based on unary inertia encoding.
     */
    private List<Set<Symbol<Integer>>> inferredDomains;

    /**
     * The list of predicates tables used to count the occurrence of a specified predicate in the
     * initial state.
     */
    private List<List<IntMatrix>> predicatesTables;

    /**
     * Creates a new problem from a specific domain and problem.
     *
     * @param problem the problem.
     */
    public PreInstantiatedProblem(final DefaultParsedProblem problem) {
        super(problem);
    }

    /**
     * Returns the list of inertia contained in the problem.
     *
     * @return the list of inertia contained in the problem.
     */
    protected List<Inertia> getInertia() {
        return this.inertia;
    }

    /**
     * Returns the list of numeric inertia contained in the problem.
     *
     * @return the list of numeric inertia contained in the problem.
     */
    protected List<Inertia> getNumericInertia() {
        return this.numericInertia;
    }

    /**
     * Returns the list of domains inferred from unary predicate.
     *
     * @return the list of domains inferred from unary predicate.
     */
    private List<Set<Symbol<Integer>>> getInferredDomains() {
        return this.inferredDomains;
    }

    /**
     * Returns the predicates table.
     *
     * @return  the predicated tables.
     */
    private List<List<IntMatrix>> getPredicatesTables() {
        return this.predicatesTables;
    }

    /**
     * This method proceeds over the actions of the domain and checks for all atom which kind of
     * inertia it is. For each atom it checks if it satisfies one of the following definitions:
     * <p>
     * <i>Definition:</i> A relation is a positive inertia iff it does not occur positively in an
     * unconditional effect or the consequent of a conditional effect of an action.
     * </p>
     * <p>
     * <i>Definition:</i> A relation is a negative inertia iff it does not occur negatively in an
     * unconditional effect or the consequent of a conditional effect of an action.
     * </p>
     * <p>
     * Relations, which are positive as well as negative inertia, are simply called inertia.
     * Relations, which are neither positive nor negative inertia, are called fluents. The detection
     * of inertia and fluents is easy because in ADL, effects are restricted to conjunctions of
     * literals. Furthermore, this information can be obtained with a single pass over the domain
     * description, which takes almost no time at all.
     * </p>
     * <p>
     * Note: before calling this method the domain must be encode into integer and the negation must
     * be move inward the expression.
     * </p>
     *
     */
    protected void extractInertia() {
        final int nbPredicates = this.getPredicateSymbols().size();
        this.inertia = new ArrayList<>(nbPredicates);
        for (int i = 0; i < nbPredicates; i++) {
            this.inertia.add(Inertia.INERTIA);
        }
        for (final IntAction action : this.getIntActions()) {
            this.extract(action.getEffects());
        }

    }

    /**
     * Do a pass over the effects of an action and update the inertia table.
     *
     * @param exp the effect.
     */
    private void extract(final Expression<Integer> exp) {
        switch (exp.getConnector()) {
            case ATOM:
                int predicate = exp.getSymbol().getValue();
                switch (this.inertia.get(predicate)) {
                    case INERTIA:
                        this.inertia.set(predicate, Inertia.NEGATIVE);
                        break;
                    case POSITIVE:
                        this.inertia.set(predicate, Inertia.FLUENT);
                        break;
                    default:
                        // do nothing
                }
                break;
            case AND:
            case OR:
                exp.getChildren().forEach(this::extract);
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
                this.extract(exp.getChildren().get(0));
                break;
            case WHEN:
                this.extract(exp.getChildren().get(1));
                break;
            case NOT:
                final Expression<Integer> neg = exp.getChildren().get(0);
                if (neg.getConnector().equals(Connector.ATOM)) {
                    predicate = neg.getSymbol().getValue();
                    switch (this.inertia.get(predicate)) {
                        case INERTIA:
                            this.inertia.set(predicate, Inertia.POSITIVE);
                            break;
                        case NEGATIVE:
                            this.inertia.set(predicate, Inertia.FLUENT);
                            break;
                        default:
                            // do nothing
                    }
                }
                break;
            case F_EXP_T:
            case EQUAL_ATOM:
            case FN_HEAD:
            case FN_ATOM:
            case TIMED_LITERAL:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MULTIPLICATION:
            case DIVISION:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER_CONSTRAINT:
            case SOMETIME_BEFORE_CONSTRAINT:
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
            case ALWAYS_WITHIN_CONSTRAINT:
            case HOLD_DURING_CONSTRAINT:
            case TIME_VAR:
            case IS_VIOLATED:
            case NUMBER:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case ALWAYS_CONSTRAINT:
            case SOMETIME_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case F_EXP:
                // do nothing
                break;
            default:
                // do nothing
        }
    }

    /**
     * Extract the numeric inertia from the list of actions. A numeric fluent is a inertia iff it never appears in the
     * effect of an action.
     */
    protected void extractNumericInertia() {
        final int nbFunctions = this.getFunctions().size();
        this.numericInertia = new ArrayList<>(nbFunctions);
        for (int i = 0; i < nbFunctions; i++) {
            this.numericInertia.add(Inertia.INERTIA);
        }
        for (final IntAction a : super.getIntActions()) {
            this.extractNumericInertia(a.getEffects());
        }

    }

    /**
     * Do a pass over the effects of an action and update the numeric inertia table.
     * A numeric inertia is a function that is never change by any action of the problem.
     *
     * @param exp the effect.
     */
    private void extractNumericInertia(final Expression<Integer> exp) {
        switch (exp.getConnector()) {
            case AND:
                exp.getChildren().forEach(this::extractNumericInertia);
                break;
            case WHEN:
                extractNumericInertia(exp.getChildren().get(1));
                break;
            case NOT:
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
                this.extractNumericInertia(exp.getChildren().get(0));
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                this.numericInertia.set(exp.getChildren().get(0).getSymbol().getValue(), Inertia.FLUENT);
                break;
            case ATOM:
            case TRUE:
            case FALSE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnector().toString());
        }
    }

    /**
     * Infer type from unary inertia contained in the initial state.
     */
    protected void inferTypesFromInertia() {
        this.inferredDomains = new ArrayList<>(this.getPredicateSymbols().size());
        for (int i = 0; i < this.getPredicateSymbols().size(); i++) {
            if (this.getPredicateSignatures().get(i).size() == 1
                && this.getInertia().get(i).equals(Inertia.INERTIA)) {
                final Set<Symbol<Integer>> newTypeDomain = new LinkedHashSet<>();
                for (Expression<Integer> fluent : this.getIntInitialState()) {
                    if (fluent.getConnector().equals(Connector.NOT)) {
                        fluent = fluent.getChildren().get(0);
                    }
                    if (fluent.getSymbol().getValue() == i) {
                        newTypeDomain.add(new Symbol<>(fluent.getArguments().get(0)));
                    }
                }
                this.inferredDomains.add(newTypeDomain);
            } else {
                this.inferredDomains.add(null);
            }
        }
    }

    /**
     * AtomicFormulaSimplifier the actions with the inferred types.
     */
    protected void simplifyActionsWithInferredTypes() {
        final List<IntAction> actions = new LinkedList<>();
        for (final IntAction action : super.getIntActions()) {
            actions.addAll(this.simplifyActionsWithInferredTypes(action));
        }
        super.getIntActions().clear();
        super.getIntActions().addAll(actions);
    }

    private List<IntAction> simplifyActionsWithInferredTypes(final IntAction action) {
        final List<Expression<Integer>> unaryInertia = new ArrayList<>();
        unaryInertia.addAll(this.collectUnaryInertia(action.getPreconditions()));
        unaryInertia.addAll(this.collectUnaryInertia(action.getEffects()));

        List<IntAction> actions = new LinkedList<>();
        actions.add(action);

        if (action.arity() == 0) {
            return actions;
        }

        for (final Expression<Integer> inertia : unaryInertia) {
            final List<IntAction> newActions = new ArrayList<>();
            for (final IntAction o : actions) {
                if (o.arity() > 0) {

                    int index = -inertia.getArguments().get(0).getValue() - 1;
                    // Hack add for constant in predicate
                    //if (index < 0) {
                    //    break;
                    //}

                    final int dtIndex = action.getTypeOfParameters(index);

                    final String declaredType = this.getTypes().get(dtIndex);
                    final int itIndex = inertia.getSymbol().getValue();
                    final String inertiaType = this.getPredicateSymbols().get(itIndex);

                    final String sti = declaredType + "^" + inertiaType;
                    int ti = this.getTypes().indexOf(sti);
                    if (ti == -1) {
                        ti = this.getTypes().size();
                        this.getTypes().add(sti);
                        final Set<Symbol<Integer>> dt1 = new LinkedHashSet<>(this.getDomains().get(dtIndex));
                        dt1.retainAll(this.getInferredDomains().get(itIndex));
                        this.getDomains().put(ti, dt1);
                    }

                    final String sts = declaredType + "\\" + inertiaType;
                    int ts = this.getTypes().indexOf(sts);
                    if (ts == -1) {
                        ts = this.getTypes().size();
                        this.getTypes().add(sts);
                        final Set<Symbol<Integer>> dt2 = new LinkedHashSet<>(this.getDomains().get(dtIndex));
                        dt2.removeAll(this.getInferredDomains().get(itIndex));
                        this.getDomains().put(ts, dt2);
                    }
                    final IntAction op1 = new IntAction(o);
                    op1.setTypeOfParameter(index, ti);
                    this.replace(op1.getPreconditions(), inertia, Connector.TRUE, ti, ts);
                    this.replace(op1.getEffects(), inertia, Connector.TRUE, ti, ts);
                    if (!op1.getPreconditions().getConnector().equals(Connector.FALSE)
                        && !op1.getEffects().getConnector().equals(Connector.FALSE)) {
                        newActions.add(op1);
                    }

                    final IntAction op2 = new IntAction(o);
                    op2.setTypeOfParameter(index, ts);
                    this.replace(op2.getPreconditions(), inertia, Connector.FALSE, ti, ts);
                    this.replace(op2.getEffects(), inertia, Connector.FALSE, ti, ts);

                    if (!op2.getPreconditions().getConnector().equals(Connector.FALSE)
                        && !op2.getEffects().getConnector().equals(Connector.FALSE)) {
                        newActions.add(op2);
                    }
                }
            }
            actions.clear();
            actions.addAll(newActions);
        }
        return actions;
    }

    /**
     * Replace all the occurrences of a specified unary inertia contained in the specified
     * expression by <code>TRUE</code> or <code>FALSE</code>.
     *
     * @param exp        the expression.
     * @param inertia    the unary inertia.
     * @param connective the connective.
     * @param ti         the type intersection.
     * @param ts         the type substract.
     */
    private void replace(final Expression<Integer> exp, final Expression<Integer> inertia, final Connector connective,
                         final int ti, final int ts) {
        switch (exp.getConnector()) {
            case ATOM:
                if (exp.equals(inertia)) {
                    exp.setConnector(connective);
                }
                break;
            case AND:
                Iterator<Expression<Integer>> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnector().equals(Connector.AND)) {
                    final Expression<Integer> ei = i.next();
                    this.replace(ei, inertia, connective, ti, ts);
                    if (ei.getConnector().equals(Connector.FALSE)) {
                        exp.setConnector(Connector.FALSE);
                    } else if (ei.getConnector().equals(Connector.TRUE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().isEmpty()) {
                    exp.setConnector(Connector.TRUE);
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnector().equals(Connector.OR)) {
                    final Expression<Integer> ei = i.next();
                    this.replace(ei, inertia, connective, ti, ts);
                    if (ei.getConnector().equals(Connector.TRUE)) {
                        exp.setConnector(Connector.TRUE);
                    } else if (ei.getConnector().equals(Connector.FALSE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().isEmpty()) {
                    exp.setConnector(Connector.FALSE);
                }
                break;
            case FORALL:
            case EXISTS:
                if (inertia.getArguments().get(0).equals(exp.getQuantifiedVariables().get(0).getValue())) {
                    final Expression<Integer> ei = new Expression<>(exp);
                    //ei.setType(ti);
                    ei.getQuantifiedVariables().get(0).addType(new Symbol<>(SymbolType.TYPE, ti));
                    this.replace(ei, inertia, Connector.TRUE, ti, ts);
                    final Expression<Integer> es = new Expression<>(exp);
                    es.getQuantifiedVariables().get(0).addType(new Symbol<>(SymbolType.TYPE, ts));
                    this.replace(es, inertia, Connector.FALSE, ti, ts);
                    exp.getChildren().clear();
                    if (exp.getConnector().equals(Connector.FORALL)) {
                        exp.setConnector(Connector.AND);
                    } else {
                        exp.setConnector(Connector.OR);
                    }
                    exp.getChildren().add(ei);
                    exp.getChildren().add(es);
                } else {
                    this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                }
                break;
            case NOT:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                if (exp.getChildren().get(0).getConnector().equals(Connector.TRUE)) {
                    exp.setConnector(Connector.FALSE);
                } else {
                    exp.setConnector(Connector.TRUE);
                }
                break;
            case AT_START:
            case AT_END:
            case ALWAYS_CONSTRAINT:
            case OVER_ALL:
            case SOMETIME_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case SOMETIME_AFTER_CONSTRAINT:
            case SOMETIME_BEFORE_CONSTRAINT:
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
            case WHEN:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
            case HOLD_DURING_CONSTRAINT:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                this.replace(exp.getChildren().get(1), inertia, connective, ti, ts);
                this.replace(exp.getChildren().get(2), inertia, connective, ti, ts);
                break;
            case EQUAL_ATOM:
            case FN_HEAD:
            case FN_ATOM:
            case TIMED_LITERAL:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MULTIPLICATION:
            case DIVISION:
            case MINUS:
            case PLUS:
            case F_EXP_T:
            case NUMBER:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case F_EXP:
            case TIME_VAR:
            case IS_VIOLATED:
                // do nothing
                break;
            default:
                // do nothing
        }
    }

    /**
     * Collect all unary inertia from a specified expression.
     *
     * @param exp the expression.
     * @return the list of unary inertia expression collected.
     */
    private List<Expression<Integer>> collectUnaryInertia(final Expression<Integer> exp) {
        final List<Expression<Integer>> unaryInertia = new ArrayList<>();
        switch (exp.getConnector()) {
            case ATOM:
                if (this.getInferredDomains().get(exp.getSymbol().getValue()) != null) {
                    unaryInertia.add(exp);
                }
                break;
            case AND:
            case OR:
                for (final Expression<Integer> ei : exp.getChildren()) {
                    unaryInertia.addAll(this.collectUnaryInertia(ei));
                }
                break;
            case FORALL:
            case EXISTS:
                final Expression<Integer> qExp = exp.getChildren().get(0);
                unaryInertia.addAll(this.collectUnaryInertia(qExp));
                break;
            case AT_START:
            case AT_END:
            case NOT:
            case ALWAYS_CONSTRAINT:
            case OVER_ALL:
            case SOMETIME_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case SOMETIME_AFTER_CONSTRAINT:
            case SOMETIME_BEFORE_CONSTRAINT:
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
            case WHEN:
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(0)));
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
            case HOLD_DURING_CONSTRAINT:
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(0)));
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(1)));
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(3)));
                break;
            case EQUAL_ATOM:
            case FN_HEAD:
            case FN_ATOM:
            case TIMED_LITERAL:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MULTIPLICATION:
            case DIVISION:
            case MINUS:
            case PLUS:
            case F_EXP_T:
            case NUMBER:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case F_EXP:
            case TIME_VAR:
            case IS_VIOLATED:
                // do nothing
                break;
            default:
                // do nothing
        }
        return unaryInertia;
    }

    /**
     * This method creates the predicate tables used to simplify atomic expression.
     */
    protected void createPredicatesTables() {
        final int tableSize = this.getConstantSymbols().size();
        final int nbPredicate = this.getPredicateSymbols().size();
        this.predicatesTables = new ArrayList<>(nbPredicate);
        for (final List<Symbol<Integer>> arguments : this.getPredicateSignatures()) {
            final int arity = arguments.size();
            final int nbTables = (int) Math.pow(2, arity);
            final List<IntMatrix> pTables = new ArrayList<>(nbTables);
            for (int j = 0; j < nbTables; j++) {
                final int dimension = Integer.bitCount(j);
                pTables.add(new IntMatrix(tableSize, dimension));
            }
            this.predicatesTables.add(pTables);
        }

        for (Expression<Integer> fluent : this.getIntInitialState()) {
            if (fluent.getConnector().equals(Connector.NOT)) {
                fluent = fluent.getChildren().get(0);
            }
            final int arity = this.getPredicateSignatures().get(fluent.getSymbol().getValue()).size();
            final List<IntMatrix> pTables = this.predicatesTables.get(fluent.getSymbol().getValue());
            final int[] set = new int[arity];
            final List<Symbol<Integer>> arguments = fluent.getArguments();
            for (final IntMatrix intMatrix : pTables) {
                int indexSize = 0;
                for (int aSet : set) {
                    if (aSet == 1) {
                        indexSize++;
                    }
                }
                final int[] index = new int[indexSize];
                int j = 0;
                for (int i = 0; i < set.length; i++) {
                    if (set[i] == 1) {
                        index[j] = arguments.get(i).getValue();
                        j++;
                    }
                }
                intMatrix.increment(index);
                this.incrementMask(set);
            }
        }
    }

    /**
     * Return an integer representation of the specified array of integer. For example, if
     * <code>mask = [0, 1, 1]</code> then the method will return 3.
     *
     * @param mask an array of integer that can only contain 0 or 1.
     * @return the integer representation of the specified array.
     */
    private int toInt(final int[] mask) {
        final int len = mask.length;
        if (len > 0) {
            int res = mask[0];
            for (int i = 1; i < len; i++) {
                res = res << 1 | mask[i];
            }
            return res;
        }
        return 0;
    }

    private int[] incrementMask(final int[] set) {
        boolean overflow = false;
        for (int i = set.length - 1; i >= 0; i--) {
            if (set[i] == 0) {
                set[i] = 1;
                break;
            } else {
                set[i] = 0;
                overflow = i == 0;
            }
        }
        return overflow ? null : set;
    }

    /**
     * Print the predicates tables.
     *
     * @param tables predicates tables.
     */
    protected void printPredicatesTables(final List<List<IntMatrix>> tables) {
        for (int predicate = 0; predicate < tables.size(); predicate++) {
            final List<IntMatrix> pTables = tables.get(predicate);
            final int arity = this.getPredicateSignatures().get(predicate).size();
            final int[] mask = new int[arity];
            for (int i = 0; i < pTables.size(); i++) {
                this.print(predicate, arity, mask, new int[0], tables);
                this.incrementMask(mask);
            }
        }
    }

    /**
     * Print a specified predicate table.
     *
     * @param predicate the predicate.
     * @param arity     the arity of the predicate.
     * @param mask      the mask that indicate where the constants are.
     * @param index     the index in construction.
     * @param tables    the predicates tables.
     */
    private void print(final int predicate, final int arity, final int[] mask, final int[] index,
                       final List<List<IntMatrix>> tables) {
        if (index.length == arity) {
            final StringBuilder str = new StringBuilder();
            str.append("(");
            str.append(this.getPredicateSymbols().get(predicate));
            int var = 0;
            int realIndexSize = 0;
            for (int anIndex : index) {
                if (anIndex == -1) {
                    str.append(" X").append(var);
                    var++;
                } else {
                    realIndexSize++;
                    str.append(" ").append(this.getConstantSymbols().get(anIndex));
                }
            }
            str.append(")");
            final int[] realIndex = new int[realIndexSize];
            int j = 0;
            for (int anIndex : index) {
                if (anIndex != -1) {
                    realIndex[j] = anIndex;
                    j++;
                }
            }
            final int counter = tables.get(predicate).get(this.toInt(mask)).get(realIndex);
            if (counter != 0) {
                str.append(" : ").append(counter);
            }
        } else if (mask[index.length] == 0) {
            final int[] newIndex = new int[index.length + 1];
            System.arraycopy(index, 0, newIndex, 0, index.length);
            newIndex[index.length] = -1;
            this.print(predicate, arity, mask, newIndex, tables);
        } else {
            for (int i = 0; i < this.getConstantSymbols().size(); i++) {
                final int[] newIndex = new int[index.length + 1];
                System.arraycopy(index, 0, newIndex, 0, index.length);
                newIndex[index.length] = i;
                this.print(predicate, arity, mask, newIndex, tables);
            }
        }
    }

    /**
     * This method simplifies an atomic specified expression. Two cased must be considered:
     * <ul>
     * <li>1. If the expression is a positive inertia and the number of unifying ground instances of
     * the specified expression that are contained in the initial state is equal to 0 then the
     * expression is simplified to FALSE.</li>
     * <li>2. If the expression is a negative inertia and then the number of all possible
     * type-consistent ground instances of the specified expression then the expression is
     * simplified to TRUE.
     * </ul>
     *
     * @param exp the atomic expression to simplify.
     * @return if the atomic expression was simply or not.
     */
    public boolean simplify(final Expression<Integer> exp) {
        if (!exp.getConnector().equals(Connector.ATOM)) {
            return false;
        }
        final int predicate = exp.getSymbol().getValue();
        // Compute the mask i.e., the vector used to indicate where the constant are located in the
        // atomic expression.
        int indexSize = 0;
        final List<Symbol<Integer>> arguments = exp.getArguments();
        final int[] mask = new int[arguments.size()];
        for (int i = 0; i < arguments.size(); i++) {
            if (arguments.get(i).getValue() >= 0) {
                mask[i] = 1;
                indexSize++;
            }
        }
        // Compute the index to access to the predicates table and compute the product (max) of the
        // tableOfDomains of the non instantiated arguments of the atomic expression.
        int j = 0;
        int max = 1;
        final int[] index = new int[indexSize];
        final List<Symbol<Integer>> predArg = this.getPredicateSignatures().get(predicate);
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 0) {
                max *= this.getDomains().get(predArg.get(i).getValue()).size();
            } else {
                index[j] = arguments.get(i).getValue();
                j++;
            }

        }
        // Get the number of unifying ground instances of the specified expression that are
        // contained in the initial state.
        final int n = this.getPredicatesTables().get(predicate).get(this.toInt(mask)).get(index);
        // CASE 1: If the expression is a positive inertia and the number of unifying ground
        // instances of the specified expression that are contained in the initial state is equal to
        // 0 then the expression is simplified to FALSE.
        final Inertia inertia = this.getInertia().get(predicate);
        if ((inertia.equals(Inertia.POSITIVE) || inertia.equals(Inertia.INERTIA)) && n == 0) {
            exp.setConnector(Connector.FALSE);
            return true;
        } else if ((inertia.equals(Inertia.NEGATIVE) || inertia.equals(Inertia.INERTIA)) && max == n) {
            // CASE 2: If the expression is a negative inertia and then the number of all possible
            // type-consistent ground instances of the specified expression then the expression is
            // simplified to TRUE.
            exp.setConnector(Connector.TRUE);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a string representation of the internal data structure used during instantiation process.
     *
     * @param data the internal data structure.
     * @return a string representation of the internal data structure used during instantiation process.
     */
    protected String toString(final Data data) {
        final StringBuilder str = new StringBuilder();
        switch (data) {
            case INERTIA:
                for (int i = 0; i < this.getPredicateSymbols().size(); i++) {
                    String predicate = this.getPredicateSymbols().get(i);
                    str.append(i);
                    str.append(": ");
                    str.append(predicate);
                    str.append(" : ");
                    str.append(this.getInertia().get(i));
                    str.append("\n");
                }
                break;
            case NUMERIC_INERTIA:
                for (int i = 0; i < this.getFunctions().size(); i++) {
                    String function = this.getFunctions().get(i);
                    str.append(i);
                    str.append(": ");
                    str.append(function);
                    str.append(" : ");
                    str.append(this.getNumericInertia().get(i));
                    str.append("\n");
                }
                break;
            default:
                return super.toString(data);
        }
        return str.toString();
    }
}
