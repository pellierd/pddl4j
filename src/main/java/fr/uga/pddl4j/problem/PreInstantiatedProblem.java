package fr.uga.pddl4j.problem;
/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.IntExpression;
import fr.uga.pddl4j.util.IntMatrix;
import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This class contains all the methods needed to the pre-treatments carried out before the insertion of the problem:
 * type inference for non-typed domains and inertia extraction to speed up the instantiation process.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public abstract class PreInstantiatedProblem extends IntProblem {

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
    private List<Set<Integer>> inferredDomains;

    /**
     * The list of predicates tables used to count the occurrence of a specified predicate in the
     * initial state.
     */
    private List<List<IntMatrix>> predicatesTables;

    /**
     * Creates a new problem from a specific domain and problem.
     *
     * @param domain the domain.
     * @param problem the problem.
     */
    public PreInstantiatedProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
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
    private List<Set<Integer>> getInferredDomains() {
        return this.inferredDomains;
    }

    /**
     * Returns the predicates tables.
     *
     * @return
     */
    private List<List<IntMatrix>> getPredicatesTables() {
        return predicatesTables;
    }

    /*
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
     * @param actions the list of actions to simplified.
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
    private void extract(final IntExpression exp) {
        switch (exp.getConnective()) {
            case ATOM:
                int predicate = exp.getPredicate();
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
                final IntExpression neg = exp.getChildren().get(0);
                if (neg.getConnective().equals(PDDLConnective.ATOM)) {
                    predicate = neg.getPredicate();
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
            case DURATION_ATOM:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case ALWAYS_WITHIN:
            case HOLD_DURING:
            case TIME_VAR:
            case IS_VIOLATED:
            case NUMBER:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
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
        final int nbFunctions = this.getFunctionSymbols().size();
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
    private void extractNumericInertia(final IntExpression exp) {
        switch (exp.getConnective()) {
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
                this.numericInertia.set(exp.getChildren().get(0).getPredicate(), Inertia.FLUENT);
                break;
            case ATOM:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
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
                final Set<Integer> newTypeDomain = new LinkedHashSet<>();
                for (IntExpression fact : this.getIntInitPredicates()) {
                    if (fact.getConnective().equals(PDDLConnective.NOT)) {
                        fact = fact.getChildren().get(0);
                    }
                    if (fact.getPredicate() == i) {
                        newTypeDomain.add(fact.getArguments()[0]);
                    }
                }
                this.inferredDomains.add(newTypeDomain);
            } else {
                this.inferredDomains.add(null);
            }
        }
    }

    /**
     * Symplify the actions with the infered types.
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
        final List<IntExpression> unaryInertia = new ArrayList<>();
        unaryInertia.addAll(this.collectUnaryInertia(action.getPreconditions()));
        unaryInertia.addAll(this.collectUnaryInertia(action.getEffects()));

        List<IntAction> actions = new LinkedList<>();
        actions.add(action);

        if (action.arity() == 0) {
            return actions;
        }

        for (final IntExpression inertia : unaryInertia) {
            final List<IntAction> newActions = new ArrayList<>();
            for (final IntAction o : actions) {
                if (o.arity() > 0) {

                    int index = -inertia.getArguments()[0] - 1;
                    // Hack add for constant in predicate
                    //if (index < 0) {
                    //    break;
                    //}

                    final int dtIndex = action.getTypeOfParameters(index);

                    final String declaredType = this.getTypeSymbols().get(dtIndex);
                    final int itIndex = inertia.getPredicate();
                    final String inertiaType = this.getPredicateSymbols().get(itIndex);

                    final String sti = declaredType + "^" + inertiaType;
                    int ti = this.getTypeSymbols().indexOf(sti);
                    if (ti == -1) {
                        ti = this.getTypeSymbols().size();
                        this.getTypeSymbols().add(sti);
                        final Set<Integer> dt1 = new LinkedHashSet<>(this.getDomains().get(dtIndex));
                        dt1.retainAll(this.getInferredDomains().get(itIndex));
                        this.getDomains().add(dt1);
                    }

                    final String sts = declaredType + "\\" + inertiaType;
                    int ts = this.getTypeSymbols().indexOf(sts);
                    if (ts == -1) {
                        ts = this.getTypeSymbols().size();
                        this.getTypeSymbols().add(sts);
                        final Set<Integer> dt2 = new LinkedHashSet<>(this.getDomains().get(dtIndex));
                        dt2.removeAll(this.getInferredDomains().get(itIndex));
                        this.getDomains().add(dt2);
                    }
                    final IntAction op1 = new IntAction(o);
                    op1.setTypeOfParameter(index, ti);
                    this.replace(op1.getPreconditions(), inertia, PDDLConnective.TRUE, ti, ts);
                    this.replace(op1.getEffects(), inertia, PDDLConnective.TRUE, ti, ts);
                    if (!op1.getPreconditions().getConnective().equals(PDDLConnective.FALSE)
                        && !op1.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                        newActions.add(op1);
                    }

                    final IntAction op2 = new IntAction(o);
                    op2.setTypeOfParameter(index, ts);
                    this.replace(op2.getPreconditions(), inertia, PDDLConnective.FALSE, ti, ts);
                    this.replace(op2.getEffects(), inertia, PDDLConnective.FALSE, ti, ts);

                    if (!op2.getPreconditions().getConnective().equals(PDDLConnective.FALSE)
                        && !op2.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
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
     * Replace all the occurrences of a specified unary inertia contained in the a specified
     * expression by <code>TRUE</code> or <code>FALSE</code>.
     *
     * @param exp        the expression.
     * @param inertia    the unary inertia.
     * @param connective the connective.
     * @param ti         the type intersection.
     * @param ts         the type substract.
     */
    private void replace(final IntExpression exp, final IntExpression inertia, final PDDLConnective connective,
                         final int ti, final int ts) {
        switch (exp.getConnective()) {
            case ATOM:
                if (exp.equals(inertia)) {
                    exp.setConnective(connective);
                }
                break;
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    this.replace(ei, inertia, connective, ti, ts);
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(PDDLConnective.TRUE);
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    this.replace(ei, inertia, connective, ti, ts);
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    } else if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(PDDLConnective.FALSE);
                }
                break;
            case FORALL:
            case EXISTS:
                if (inertia.getArguments()[0] == exp.getVariable()) {
                    final IntExpression ei = new IntExpression(exp);
                    ei.setType(ti);
                    this.replace(ei, inertia, PDDLConnective.TRUE, ti, ts);
                    final IntExpression es = new IntExpression(exp);
                    es.setType(ts);
                    this.replace(es, inertia, PDDLConnective.FALSE, ti, ts);
                    exp.getChildren().clear();
                    if (exp.getConnective().equals(PDDLConnective.FORALL)) {
                        exp.setConnective(PDDLConnective.AND);
                    } else {
                        exp.setConnective(PDDLConnective.OR);
                    }
                    exp.getChildren().add(ei);
                    exp.getChildren().add(es);
                } else {
                    this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                }
                break;
            case NOT:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                if (exp.getChildren().get(0).getConnective().equals(PDDLConnective.TRUE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                } else {
                    exp.setConnective(PDDLConnective.TRUE);
                }
                break;
            case AT_START:
            case AT_END:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case WHEN:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                this.replace(exp.getChildren().get(1), inertia, connective, ti, ts);
                this.replace(exp.getChildren().get(3), inertia, connective, ti, ts);
                break;
            case EQUAL_ATOM:
            case FN_HEAD:
            case FN_ATOM:
            case DURATION_ATOM:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
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
    private List<IntExpression> collectUnaryInertia(final IntExpression exp) {
        final List<IntExpression> unaryInertia = new ArrayList<>();
        switch (exp.getConnective()) {
            case ATOM:
                if (this.getInferredDomains().get(exp.getPredicate()) != null) {
                    unaryInertia.add(exp);
                }
                break;
            case AND:
            case OR:
                for (final IntExpression ei : exp.getChildren()) {
                    unaryInertia.addAll(this.collectUnaryInertia(ei));
                }
                break;
            case FORALL:
            case EXISTS:
                final IntExpression qExp = exp.getChildren().get(0);
                unaryInertia.addAll(this.collectUnaryInertia(qExp));
                break;
            case AT_START:
            case AT_END:
            case NOT:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case WHEN:
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(0)));
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(0)));
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(1)));
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(3)));
                break;
            case EQUAL_ATOM:
            case FN_HEAD:
            case FN_ATOM:
            case DURATION_ATOM:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
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
     * This method creates the predicates predicatesTables used to simplify atomic expression.
     */
    protected void createPredicatesTables() {
        final int tableSize = this.getConstantSymbols().size();
        final int nbPredicate = this.getPredicateSymbols().size();
        this.predicatesTables = new ArrayList<>(nbPredicate);
        for (final List<Integer> arguments : this.getPredicateSignatures()) {
            final int arity = arguments.size();
            final int nbTables = (int) Math.pow(2, arity);
            final List<IntMatrix> pTables = new ArrayList<>(nbTables);
            for (int j = 0; j < nbTables; j++) {
                final int dimension = Integer.bitCount(j);
                pTables.add(new IntMatrix(tableSize, dimension));
            }
            this.predicatesTables.add(pTables);
        }

        for (IntExpression fact : this.getIntInitPredicates()) {
            if (fact.getConnective().equals(PDDLConnective.NOT)) {
                fact = fact.getChildren().get(0);
            }
            final int arity = this.getPredicateSignatures().get(fact.getPredicate()).size();
            final List<IntMatrix> pTables = this.predicatesTables.get(fact.getPredicate());
            final int[] set = new int[arity];
            final int[] args = fact.getArguments();
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
                        index[j] = args[i];
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
    protected int toInt(final int[] mask) {
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
    void printPredicatesTables(final List<List<IntMatrix>> tables) {
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
     * Expands the quantified expressions contained in a specified expression.
     *
     * @param exp the expression.
     * @param simplify the flag to indicate if logical simplifications must be done during the expansion.
     */
    protected void expandQuantifiedExpression(final IntExpression exp, boolean simplify) {
        switch (exp.getConnective()) {
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    // Remove quantified expression where the domain of the quantified variable is empty
                    if ((ei.getConnective().equals(PDDLConnective.FORALL)
                        || ei.getConnective().equals(PDDLConnective.EXISTS))
                        && this.getDomains().get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    this.expandQuantifiedExpression(ei, simplify);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (simplify && ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    }
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    // Remove quantified expression where the domain of the quantified variable is empty
                    if ((ei.getConnective().equals(PDDLConnective.FORALL)
                        || ei.getConnective().equals(PDDLConnective.EXISTS))
                        && this.getDomains().get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    this.expandQuantifiedExpression(ei, simplify);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    if (simplify && ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case FORALL:
                Set<Integer> constants = this.getDomains().get(exp.getType());
                IntExpression qExp = exp.getChildren().get(0);
                int var = exp.getVariable();
                exp.setConnective(PDDLConnective.AND);
                exp.getChildren().clear();
                Iterator<Integer> it = constants.iterator();
                while (it.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    int cons = it.next();
                    IntExpression copy = new IntExpression(qExp);
                    this.substitute(copy, var, cons, simplify);
                    exp.getChildren().add(copy);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (simplify && copy.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    }
                }
                this.expandQuantifiedExpression(exp, simplify);
                break;
            case EXISTS:
                constants = this.getDomains().get(exp.getType());
                qExp = exp.getChildren().get(0);
                var = exp.getVariable();
                exp.setConnective(PDDLConnective.OR);
                exp.getChildren().clear();
                it = constants.iterator();
                while (it.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    int cons = it.next();
                    IntExpression copy = new IntExpression(qExp);
                    this.substitute(copy, var, cons, simplify);
                    exp.getChildren().add(copy);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    if (simplify && copy.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                this.expandQuantifiedExpression(exp, simplify);
                break;

            case AT_START:
            case AT_END:
            case NOT:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
                this.expandQuantifiedExpression(exp.getChildren().get(0), simplify);
                break;
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case WHEN:
                this.expandQuantifiedExpression(exp.getChildren().get(0), simplify);
                this.expandQuantifiedExpression(exp.getChildren().get(1), simplify);
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.expandQuantifiedExpression(exp.getChildren().get(0), simplify);
                this.expandQuantifiedExpression(exp.getChildren().get(1), simplify);
                this.expandQuantifiedExpression(exp.getChildren().get(3), simplify);
                break;
            case ATOM:
                this.simplyAtom(exp);
                break;
            case EQUAL_ATOM:
            case FN_HEAD:
            case FN_ATOM:
            case DURATION_ATOM:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
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
     */
    private void simplyAtom(final IntExpression exp) {
        final int predicate = exp.getPredicate();
        // Compute the mask i.e., the vector used to indicate where the constant are located in the
        // atomic expression.
        int indexSize = 0;
        final int[] args = exp.getArguments();
        final int[] mask = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] >= 0) {
                mask[i] = 1;
                indexSize++;
            }
        }
        // Compute the index to access to the predicates table and compute the product (max) of the
        // tableOfDomains of the non instantiated arguments of the atomic expression.
        int j = 0;
        int max = 1;
        final int[] index = new int[indexSize];
        final List<Integer> predArg = this.getPredicateSignatures().get(predicate);
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 0) {
                max *= this.getDomains().get(predArg.get(i)).size();
            } else {
                index[j] = args[i];
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
            exp.setConnective(PDDLConnective.FALSE);
        } else if ((inertia.equals(Inertia.NEGATIVE) || inertia.equals(Inertia.INERTIA)) && max == n) {
            // CASE 2: If the expression is a negative inertia and then the number of all possible
            // type-consistent ground instances of the specified expression then the expression is
            // simplified to TRUE.
            exp.setConnective(PDDLConnective.TRUE);
        }
    }

    /**
     * Substitutes all occurrence of a specified variable into an expression by a constant.
     *
     * @param exp  the expression.
     * @param var  the variable.
     * @param cons the constant.
     */
    protected void substitute(final IntExpression exp, final int var, final int cons, boolean simplify) {
        boolean updated = false;
        switch (exp.getConnective()) {
            case ATOM:
                int[] args = exp.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                        updated = true;
                    }
                }
                if (updated) {
                    this.simplyAtom(exp);
                }
                break;
            case TASK:
                args = exp.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                    }
                }
                break;
            case FN_HEAD:
                args = exp.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                        updated = true;
                    }
                }
                //if (updated) {
                //    Instantiation.simplyFunction(exp);
                //}
                break;
            case EQUAL_ATOM:
                args = exp.getArguments();
                // Get and substitute the first argument
                final int arg1 = args[0];
                if (arg1 == var) {
                    args[0] = cons;
                }
                // Get and substitute the second argument
                final int arg2 = args[1];
                if (arg2 == var) {
                    args[1] = cons;
                }
                // The equality is TRUE: arg1 and arg2 are the same variable or the same constant
                if (arg1 == arg2) {
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (arg1 >= 0 && arg2 >= 0) {
                    // The equality is ground and the equality is FALSE because arg1 != arg2
                    exp.setConnective(PDDLConnective.FALSE);
                }
                break;
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    this.substitute(ei, var, cons, simplify);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (simplify && ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    }
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    this.substitute(ei, var, cons, simplify);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (simplify && ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                this.substitute(neg, var, cons, simplify);
                if (simplify && neg.getConnective().equals(PDDLConnective.TRUE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                } else if (simplify && neg.getConnective().equals(PDDLConnective.FALSE)) {
                    exp.setConnective(PDDLConnective.TRUE);
                }
                break;
            case WHEN:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
                this.substitute(exp.getChildren().get(0), var, cons, simplify);
                this.substitute(exp.getChildren().get(1), var, cons, simplify);
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case UMINUS:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case F_EXP:
                this.substitute(exp.getChildren().get(0), var, cons, simplify);
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    this.substitute(exp.getChildren().get(0), var, cons, simplify);
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.substitute(exp.getChildren().get(0), var, cons, simplify);
                this.substitute(exp.getChildren().get(1), var, cons, simplify);
                this.substitute(exp.getChildren().get(3), var, cons, simplify);
                break;
            case FN_ATOM:
            case NUMBER:
            case DURATION_ATOM:
            case TIME_VAR:
            case IS_VIOLATED:
            case MINIMIZE:
            case MAXIMIZE:
                break;
            default:
                // do nothing
        }
    }

    /**
     * This method simplify a specified expression. The rules of simplification are as below:
     * <ul>
     * <li> not true eqv false </li>
     * <li> true ^ phi eqv phi </li>
     * <li> false ^ phi eqv false </li>
     * <li> true v phi eqv true </li>
     * <li> false v phi eqv false </li>
     * <li> not false eqv true </li>
     * <li> phi ^ phi eqv phi </li>
     * <li> phi v phi eqv phi </li>
     * <li> phi ^ not phi eqv false </li>
     * <li> phi v not phi eqv true </li>
     * <li> x = x eqv true </li>
     * <li> x = y eqv false </li>
     * </ul>
     *
     * @param exp the expression to simplify.
     */
    protected void simplify(final IntExpression exp) {
        switch (exp.getConnective()) {
            case ATOM:
                break;
            case FN_HEAD:
                break;
            case EQUAL_ATOM:
                int[] args = exp.getArguments();
                // Get and substitute the first argument
                final int arg1 = args[0];
                // Get and substitute the second argument
                final int arg2 = args[1];
                if (arg1 == arg2) {
                    // The equality is TRUE: arg1 and arg2 are the same variable or the same constant
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (arg1 >= 0 && arg2 >= 0) {
                    // The equality is ground and the equality is FALSE because arg1 != arg2
                    exp.setConnective(PDDLConnective.FALSE);
                }
                break;
            case AND:
                int i = 0;
                while (i < exp.getChildren().size() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = exp.getChildren().get(i);
                    this.simplify(ei);
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        // If a child expression is FALSE, the whole conjunction becomes FALSE.
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        // If a child expression is TRUE, we can remove the child expression.
                        exp.getChildren().remove(i);
                    } else if (ei.getConnective().equals(PDDLConnective.AND)) {
                        // If the child expression to add is a conjunction, we can simplify the expression by
                        exp.getChildren().remove(i); // removing the inner conjunction.
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size() && exp.getConnective().equals(PDDLConnective.AND)) {
                            final IntExpression ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(PDDLConnective.FALSE)) {
                                exp.setConnective(PDDLConnective.FALSE);
                            } else if (!ej.getConnective().equals(PDDLConnective.TRUE)) {
                                exp.getChildren().add(i + added, ej);
                                added++;
                            }
                            j++;
                        }
                        i += added + 1;
                    } else if (ei.getConnective().equals(PDDLConnective.WHEN)) {
                        // Simplification of the conditional expression.
                        final IntExpression antecedent = ei.getChildren().get(0);
                        final IntExpression consequent = ei.getChildren().get(1);
                        // If the antecedent of a conditional effect becomes FALSE , the conditional
                        // effect is removed from the action. In this case, the effect is never applicable
                        // because it requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(PDDLConnective.FALSE)) {
                            exp.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional
                            // effect becomes unconditional.
                            if (consequent.getConnective().equals(PDDLConnective.AND)) {
                                exp.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && exp.getConnective().equals(PDDLConnective.AND)) {

                                    final IntExpression ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(PDDLConnective.FALSE)) {
                                        exp.setConnective(PDDLConnective.FALSE);
                                    } else if (!ej.getConnective().equals(PDDLConnective.TRUE)) {
                                        exp.getChildren().add(i + added, ej);
                                        added++;
                                    }
                                    j++;
                                }
                                i += added + 1;
                            } else {
                                exp.getChildren().set(i, consequent);
                                i++;
                            }
                        } else if (consequent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the consequent of a conditional effect becomes TRUE, the conditional
                            // effect is removed because it does not lead to any state transition.
                            exp.getChildren().remove(i);
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                }
                // Finally, if the conjunction is empty, the expression becomes TRUE.
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            case OR:
                i = 0;
                while (i < exp.getChildren().size() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = exp.getChildren().get(i);
                    this.simplify(ei);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    } else if (ei.getConnective().equals(PDDLConnective.OR)) {
                        // If the child expression to add is a disjunction, we can simplify the expression by
                        // removing the inner disjunction.
                        exp.getChildren().remove(i);
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size() && exp.getConnective().equals(PDDLConnective.OR)) {
                            final IntExpression ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(PDDLConnective.TRUE)) {
                                exp.setConnective(PDDLConnective.TRUE);
                            } else if (!ej.getConnective().equals(PDDLConnective.FALSE)) {
                                exp.getChildren().add(i + added, ej);
                                added++;
                            }
                            j++;
                        }
                        i += added + 1;
                    } else if (ei.getConnective().equals(PDDLConnective.WHEN)) {
                        // Simplification of the conditional expression.
                        final IntExpression antecedent = ei.getChildren().get(0);
                        final IntExpression consequent = ei.getChildren().get(1);
                        // If the antecedent of a conditional effect becomes FALSE , the conditional effect is
                        // removed from the action. In this case, the effect is never applicable because it
                        // requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(PDDLConnective.FALSE)) {
                            exp.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional effect
                            // becomes unconditional.
                            if (consequent.getConnective().equals(PDDLConnective.OR)) {
                                exp.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && exp.getConnective().equals(PDDLConnective.OR)) {

                                    final IntExpression ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(PDDLConnective.TRUE)) {
                                        exp.setConnective(PDDLConnective.TRUE);
                                    } else if (!ej.getConnective().equals(PDDLConnective.FALSE)) {
                                        exp.getChildren().add(i + added, ej);
                                        added++;
                                    }
                                    j++;
                                }
                                i += added + 1;
                            } else {
                                exp.getChildren().set(i, consequent);
                                i++;
                            }
                        } else if (consequent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the consequent of a conditional effect becomes TRUE, the conditional
                            // effect is removed because it does not lead to any state transition.
                            exp.getChildren().remove(i);
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                }
                // Finally, if the disjunction is empty, the expression becomes TRUE.
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                } else {
                    final Iterator<IntExpression> it = exp.getChildren().iterator();
                    while (it.hasNext()) {
                        if (it.next().getConnective().equals(PDDLConnective.FALSE)) {
                            it.remove();
                        }
                    }
                    if (exp.getChildren().isEmpty()) {
                        exp.setConnective(PDDLConnective.FALSE);
                    }
                }
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case UMINUS:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
                this.simplify(exp.getChildren().get(0));
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                this.simplify(neg);
                if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                    exp.setConnective(PDDLConnective.TRUE);
                }
                break;
            case WHEN:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
                this.simplify(exp.getChildren().get(0));
                this.simplify(exp.getChildren().get(1));
                break;
            case F_EXP_T:
            case F_EXP:
                this.simplify(exp.getChildren().get(0));
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.simplify(exp.getChildren().get(0));
                this.simplify(exp.getChildren().get(1));
                this.simplify(exp.getChildren().get(3));
                break;
            case FN_ATOM:
            case NUMBER:
            case DURATION_ATOM:
            case TIME_VAR:
            case IS_VIOLATED:
            case MINIMIZE:
            case MAXIMIZE:
                break;
            default:
                // do nothing
        }
    }

    /**
     * Convert an expression in conjunctive normal form (CNF).
     *
     * @param exp the expression to transform in CNF.
     */
    protected void toCNF(final IntExpression exp) throws UnexpectedExpressionException {
        switch (exp.getConnective()) {
            case WHEN:
                final IntExpression antecedent = exp.getChildren().get(0);
                final IntExpression consequence = exp.getChildren().get(1);
                this.toDNF(antecedent);
                exp.setConnective(PDDLConnective.AND);
                exp.getChildren().clear();
                for (IntExpression ei : antecedent.getChildren()) {
                    final IntExpression newWhen = new IntExpression(PDDLConnective.WHEN);
                    newWhen.getChildren().add(ei);
                    newWhen.getChildren().add(new IntExpression(consequence));
                    exp.getChildren().add(newWhen);
                }
                break;
            case AND:
                final List<IntExpression> children = exp.getChildren();
                int i = 0;
                while (i < children.size()) {
                    final IntExpression ei = children.get(i);
                    this.toCNF(ei);
                    exp.getChildren().remove(i);
                    for (IntExpression ej : ei.getChildren()) {
                        exp.getChildren().add(i, ej);
                        i++;
                    }
                }
                break;
            case ATOM:
            case AT_END:
            case AT_START:
            case OVER_ALL:
            case INCREASE:
            case DECREASE:
            case ASSIGN:
            case SCALE_UP:
            case SCALE_DOWN:
            case NOT:
            case TRUE:
                IntExpression copy = new IntExpression(exp);
                exp.setConnective(PDDLConnective.AND);
                exp.getChildren().clear();
                exp.getChildren().add(copy);
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
    }
    /**
     * Convert an expression in disjunctive normal form (DNF).
     *
     * @param exp the expression to transform in DNF.
     */
    protected void toDNF(final IntExpression exp) throws UnexpectedExpressionException {
        switch (exp.getConnective()) {
            case OR:
                List<IntExpression> children = exp.getChildren();
                int index = 0;
                while (index < children.size()) {
                    final IntExpression ei = children.get(index);
                    this.toDNF(ei);
                    if (ei.getConnective().equals(PDDLConnective.OR)) {
                        children.remove(index);
                        for (IntExpression ej : ei.getChildren()) {
                            children.add(index, ej);
                            index++;
                        }
                    }
                }
                break;
            case AND:
                children = exp.getChildren();
                for (IntExpression child : children) {
                    this.toDNF(child);
                }
                IntExpression dnf = exp.getChildren().get(0);
                for (int i = 1; i < exp.getChildren().size(); i++) {
                    final IntExpression orExp = exp.getChildren().get(i);
                    final IntExpression newOr = new IntExpression(PDDLConnective.OR);
                    for (IntExpression newAnd : dnf.getChildren()) {
                        for (IntExpression ek : orExp.getChildren()) {
                            ek.getChildren().stream().filter(el -> !newAnd.getChildren().contains(el)).forEach(el -> {
                                if (el.getConnective().equals(PDDLConnective.OR)
                                    || el.getConnective().equals(PDDLConnective.AND)
                                    && el.getChildren().size() == 1) {
                                    newAnd.getChildren().add(el.getChildren().get(0));
                                } else {
                                    newAnd.getChildren().add(el);
                                }
                            });
                            boolean add = true;
                            for (IntExpression el : newAnd.getChildren()) {
                                if (el.getConnective().equals(PDDLConnective.FALSE)) {
                                    add = false;
                                    break;
                                }
                            }
                            if (add) {
                                if (newAnd.getChildren().size() == 1) {
                                    newOr.getChildren().add(newAnd.getChildren().get(0));
                                } else {
                                    newOr.getChildren().add(newAnd);
                                }
                            }
                        }
                    }
                    dnf = newOr;
                }
                exp.affect(dnf);
                break;
            case ATOM:
            case NOT:
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
            case EQUAL_ATOM:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case AT_END:
            case AT_START:
            case OVER_ALL:
            case FALSE:
            case TRUE:
                IntExpression and = new IntExpression(PDDLConnective.AND);
                and.getChildren().add(new IntExpression(exp));
                exp.setConnective(PDDLConnective.OR);
                exp.getChildren().clear();
                exp.getChildren().add(and);
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
    }

    /**
     * Expands the temporal actions.
     */
    protected void expandTemporalActions(List<IntAction> actions) {
        List<IntAction> expandedActions = new ArrayList<>();

        for (IntAction a : actions) {
            // System.out.println("******************************************************");
            //System.out.println(Encoder.toString(a));

            this.expandQuantifiedExpression(a.getPreconditions(), false);
            a.getPreconditions().moveTimeSpecifierInward();
            a.getPreconditions().moveNegationInward();

            //System.out.println("*** Precondition ***");
            //System.out.println(Encoder.toString(a.getPreconditions()));

            final IntExpression startPrecondition = new IntExpression(a.getPreconditions());
            this.extract(startPrecondition, PDDLConnective.AT_START);
            //System.out.println("*** At start precondition ***");
            //System.out.println(Encoder.toString(startPrecondition));
            this.simplify(startPrecondition);
            //System.out.println("*** At start precondition ***");
            //System.out.println(Encoder.toString(startPrecondition));
            this.toDNF(startPrecondition);

            //System.out.println("*** At start precondition ***");
            //System.out.println(Encoder.toString(startPrecondition));

            final IntExpression endPrecondition = new IntExpression(a.getPreconditions());
            this.extract(endPrecondition, PDDLConnective.AT_END);
            this.simplify(endPrecondition);
            this.toDNF(endPrecondition);

            //System.out.println("*** At end precondition ***");
            //System.out.println(Encoder.toString(endPrecondition));

            final IntExpression overAllPrecondition = new IntExpression(a.getPreconditions());
            this.extract(overAllPrecondition, PDDLConnective.OVER_ALL);
            //System.out.println("*** Over all precondition AV Simplify ***");
            //System.out.println(Encoder.toString(overAllPrecondition));
            this.simplify(overAllPrecondition);
            this.toDNF(overAllPrecondition);

            //System.out.println("*** Over all precondition ***");
            //System.out.println(Encoder.toString(overAllPrecondition));


            // Expands the quantified expression on the effect of the action
            this.expandQuantifiedExpression(a.getEffects(), false);
            a.getEffects().moveTimeSpecifierInward();
            a.getEffects().moveNegationInward();
            this.toCNF(a.getEffects());
            //this.simplify(a.getEffects());

            //System.out.println("*** EFFECT ***");
            //System.out.println(Encoder.toString(a.getEffects()));

            //try {
            //    System.out.println("Press enter...");
            //    System.in.read();
            //} catch (IOException e) {
            //    e.printStackTrace();
            //}
            // The list of monitoring action need to deal with over all condition in conditional effect
            final List<IntAction> monitoringActions = new ArrayList<>();
            // The effect of the start action
            final IntExpression startEffect = new IntExpression(PDDLConnective.AND);
            // The effect of the end action
            final IntExpression endEffect = new IntExpression(PDDLConnective.AND);

            // Iterate over the effect of the action the action to initialize the start and end effect and the list of
            // monitoring actions needed to deal with over all condition in conditional effects.
            // We suppose that the effect is a conjunction of at_start or at_end or when.
            for (IntExpression effect : a.getEffects().getChildren()) {
                //System.out.println("EFFECT : "+ this.toString(effect));
                switch (effect.getConnective()) {
                    case AT_START:
                        startEffect.addChild(effect.getChildren().get(0));
                        break;
                    case AT_END:
                        endEffect.addChild(effect.getChildren().get(0));
                        break;
                    case WHEN:
                        // Extract the start effect condition of the conditional effect
                        final IntExpression ps = new IntExpression(effect.getChildren().get(0));
                        this.extract(ps, PDDLConnective.AT_START);
                        // Extract the end effect condition of the conditional effect
                        final IntExpression pe = new IntExpression(effect.getChildren().get(0));
                        this.extract(pe, PDDLConnective.AT_END);
                        // Extract the overall effect condition of the conditional effect
                        final IntExpression pi = new IntExpression(effect.getChildren().get(0));
                        this.extract(pi, PDDLConnective.OVER_ALL);
                        // Extract the start effect of the conditional effect
                        final IntExpression qs = new IntExpression(effect.getChildren().get(1));
                        this.extract(qs, PDDLConnective.AT_START);
                        // Extract the end effect of the conditional effect
                        final IntExpression qe = new IntExpression(effect.getChildren().get(1));
                        this.extract(qe, PDDLConnective.AT_END);


                        // CASE at start only in condition and at start only in effects
                        // We add the condition of the effect to the start action and the effect to the start action.
                        if (!ps.getChildren().isEmpty()
                            && pe.getChildren().isEmpty()
                            && pi.getChildren().isEmpty()
                            && !qs.getChildren().isEmpty()
                            && qe.getChildren().isEmpty()) {

                            IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            when.addChild(ps);
                            when.addChild(ps);
                            startEffect.addChild(when);
                        }

                        // CASE at end only in condition and at end only in effects
                        // We add the condition of the effect to the end action and the effect to the end action.
                        else if (ps.getChildren().isEmpty()
                            && !pe.getChildren().isEmpty()
                            && pi.getChildren().isEmpty()
                            && qs.getChildren().isEmpty()
                            && !qe.getChildren().isEmpty()) {

                            IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            when.addChild(pe);
                            when.addChild(qe);
                            endEffect.addChild(when);
                        }

                        // CASE at star and possibly at end but no overall in condition and at end in effects
                        else if (!ps.getChildren().isEmpty()
                            && pi.getChildren().isEmpty()
                            && !qe.getChildren().isEmpty()) {

                            // Create the conditional effect for the start action
                            final IntExpression startWhen = new IntExpression(PDDLConnective.WHEN);
                            startWhen.addChild(ps);
                            // Create the dummy predicate to memorize the effect at end
                            final IntExpression mps = this.createDummyPredicate();
                            startWhen.addChild(mps);
                            startEffect.addChild(startWhen);

                            // Create the conditional effect for the end action
                            final IntExpression endWhen = new IntExpression(PDDLConnective.WHEN);
                            if (pe.getChildren().isEmpty()) {
                                endWhen.addChild(mps);
                            } else {
                                final IntExpression and = new IntExpression(PDDLConnective.AND);
                                and.addChild(pe);
                                and.addChild(mps);
                                endWhen.addChild(and);
                            }
                            endWhen.addChild(endEffect);
                            endEffect.addChild(endWhen);
                        }

                        // CASE overall in condition with possibly no at start and no at end and at end in effect
                        // (when (and (at start ps) (over all pi) (at end pe)) (at end q))
                        else if (!pi.getChildren().isEmpty()
                            && qe.getChildren().isEmpty()) {

                            // Create the monitoring action with no precondition but effects of the form
                            // (when (and (Mpi) (not pi)) (not (Mpi)))
                            final IntAction monitoring = this.createMonitoringAction();
                            final IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            IntExpression and = new IntExpression(PDDLConnective.AND);
                            final IntExpression mpi = this.createDummyPredicate();
                            and.addChild(mpi);
                            final IntExpression notPi = new IntExpression(PDDLConnective.NOT);
                            notPi.addChild(pi);
                            notPi.moveNegationInward();
                            and.addChild(notPi);
                            when.addChild(and);
                            final IntExpression notMpi = new IntExpression(PDDLConnective.NOT);
                            notMpi.addChild(mpi);
                            when.addChild(notMpi);
                            monitoring.getEffects().addChild(when);
                            monitoringActions.add(monitoring);

                            // Create the start effect: (when ps (Mps))
                            IntExpression mps = this.createDummyPredicate();
                            if (!ps.getChildren().isEmpty()) {
                                IntExpression startWhen = new IntExpression(PDDLConnective.WHEN);
                                startWhen.addChild(ps);
                                startWhen.addChild(mps);
                                startEffect.addChild(startWhen);
                            } else {
                                startEffect.addChild(mps);
                            }

                            // Create the start effect: (when (and (Mps) (Mpi) pe) q).
                            IntExpression endWhen = new IntExpression(PDDLConnective.WHEN);
                            and = new IntExpression(PDDLConnective.AND);
                            and.addChild(mps);
                            and.addChild(mpi);
                            if (!pe.getChildren().isEmpty()) {
                                and.addChild(pe);
                            }
                            endWhen.addChild(and);
                            endWhen.addChild(qe);
                            endEffect.addChild(endWhen);
                        }
                    default:
                        // Do nothing
                }
            }
            //System.out.println("START PRECOND AVANT  SIM: ");
            //System.out.println(this.toString(startPrecondition));
            //this.simplify(startPrecondition);
            //System.out.println("START PRECOND APRES  SIM: ");
            //System.out.println(this.toString(startPrecondition));
            //start.

            //this.simplify(endPrecondition);
            //this.simplify(overallPrecondition);

            //System.out.println("START EFFECT AVANT  SIM: ");
            //System.out.println(Encoder.toString(startEffect));
            this.simplify(startEffect);
            //startEffect.toConjunctiveNormalForm(this);
            //System.out.println("START EFFECT APRES SIM: ");
            //System.out.println(Encoder.toString(startEffect));

            //System.out.println("END EFFECT AVANT  SIM: ");
            //System.out.println(Encoder.toString(endEffect));
            this.simplify(endEffect);
            //endEffect.toConjunctiveNormalForm(this);
            //System.out.println("END EFFECT APRES  SIM: ");
            //System.out.println(Encoder.toString(endEffect));

            // Create a start action for each conjunction of the start precondition
            for (IntExpression precondition : startPrecondition.getChildren()) {
                IntAction startAction = new IntAction(a.getName() + "_" + "start", a.arity());
                startAction.setCost(a.getCost());
                startAction.setDuration(new IntExpression(a.getDuration()));
                for (int i = 0; i < a.arity(); i++) {
                    startAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                }
                for (int i = 0; i < a.arity(); i++) {
                    startAction.setValueOfParameter(i, a.getValueOfParameter(i));
                }
                startAction.setPreconditions(precondition);
                startAction.setEffects(new IntExpression(startEffect));
                expandedActions.add(startAction);

                //System.out.println("*"+Encoder.toString(startAction));
                //try {
                //    System.out.println("Press enter...");
                //    System.in.read();
                //} catch (IOException e) {
                //    e.printStackTrace();
                //}
            }

            for (IntExpression precondition : endPrecondition.getChildren()) {
                IntAction endAction = new IntAction(a.getName() + "_" + "end", a.arity());
                endAction.setCost(a.getCost());
                endAction.setDuration(new IntExpression(a.getDuration()));
                for (int i = 0; i < a.arity(); i++) {
                    endAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                }
                for (int i = 0; i < a.arity(); i++) {
                    endAction.setValueOfParameter(i, a.getValueOfParameter(i));
                }
                endAction.setPreconditions(precondition);
                endAction.setEffects(new IntExpression(endEffect));
                expandedActions.add(endAction);

                /*System.out.println("*"+Encoder.toString(endAction));
                try {
                    System.out.println("Press enter...");
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
            //System.out.println(Encoder.toString(overAllPrecondition));
            for (IntExpression precondition : overAllPrecondition.getChildren()) {
                if (!precondition.getConnective().equals(PDDLConnective.FALSE)) {
                    IntAction invAction = new IntAction(a.getName() + "_" + "inv", a.arity());
                    invAction.setCost(a.getCost());
                    invAction.setDuration(new IntExpression(a.getDuration()));
                    for (int i = 0; i < a.arity(); i++) {
                        invAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                    }
                    for (int i = 0; i < a.arity(); i++) {
                        invAction.setValueOfParameter(i, a.getValueOfParameter(i));
                    }
                    invAction.setPreconditions(precondition);
                    expandedActions.add(invAction);
                    /*System.out.println("*" + Encoder.toString(invAction));
                    try {
                        System.out.println("Press enter...");
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                }
            }

            // Add the monitoring actions
            for (IntAction m : monitoringActions) {
                expandedActions.add(m);
                /*
                System.out.println(this.toString(m));
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }

        }
        actions.clear();
        actions.addAll(expandedActions);

    }


    /**
     * Extract the subexpression having the timespecifier.
     *
     * Warning the time specidier must be move inward
     */
    private void extract(IntExpression exp, PDDLConnective timeSpecifier) {
        switch (exp.getConnective()) {
            case OR:
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext()) {
                    IntExpression e = i.next();
                    this.extract(e, timeSpecifier);
                    if (e.getConnective().equals(PDDLConnective.AND)
                        && e.getChildren().isEmpty()) {
                        i.remove();
                    }
                }
                break;
            case AT_END:
            case AT_START:
            case OVER_ALL:
                if (!exp.getConnective().equals(timeSpecifier)) {
                    exp.setConnective(PDDLConnective.AND);
                    exp.getChildren().clear();
                } else {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            default:

        }

    }

    private int dummyPredicateCounter = 0;
    private IntExpression createDummyPredicate() {
        this.getPredicateSymbols().add("^M" + this.dummyPredicateCounter);
        this.dummyPredicateCounter++;
        final IntExpression atom = new IntExpression(PDDLConnective.ATOM);
        atom.setPredicate(this.getPredicateSymbols().size() - 1);
        return atom;

    }

    private int monitoringActionCounter = 0;

    private IntAction createMonitoringAction() {
        IntAction monitoring = new IntAction("monitoring_action" + this.monitoringActionCounter, 0);
        this.monitoringActionCounter++;
        return monitoring;
    }

}
