/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.PDDLSymbol;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.problem.numeric.ArithmeticExpression;
import fr.uga.pddl4j.problem.numeric.ArithmeticOperator;
import fr.uga.pddl4j.problem.numeric.NumericAssignment;
import fr.uga.pddl4j.problem.numeric.NumericConstraint;
import fr.uga.pddl4j.problem.numeric.NumericVariable;
import fr.uga.pddl4j.problem.operator.AbstractGroundOperator;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Condition;
import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.problem.operator.Constants;
import fr.uga.pddl4j.problem.operator.Effect;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.IntExpression;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * This class contains all the methods needed to final bit encoding of the problem.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public abstract class PostInstantiatedProblem extends InstantiatedProblem {

    /**
     * The list of instantiated actions encoded into bit sets.
     */
    private List<Action> actions;

    /**
     * The list of relevant fluents.
     */
    protected List<Fluent> relevantFluents;

    /**
     * The initial state of the problem encoded in its final bit set representation.
     */
    private InitialState initialState;

    /**
     * The goal of the problem encoded in its final bit set representation.
     */
    private Goal goal;

    /**
     * The table of the relevant fluents in the form of <code>IntExpression</code>.
     */
    protected List<IntExpression> intExpRelevantFluents;

    /**
     * The map used to encode fluents into bit set representation.
     */
    private Map<IntExpression, Integer> mapOfFluentIndex;

    /**
     * The table of the relevant numeric fluent in the form of <code>IntExpression</code>.
     */
    private List<IntExpression> intExpRelevantNumericFluents;

    /**
     * The map used to encode numeric fluents into bit set representation.
     */
    private Map<IntExpression, Integer> mapOfNumericFluentIndex;

    /**
     * Creates a new problem from a domain and problem.
     *
     * @param domain the domain.
     * @param problem the problem.
     */
    public PostInstantiatedProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }

    /**
     * Returns the list of actions of the problem.
     *
     * @return the list of actions of the problem.
     */
    public final List<Action> getActions() {
        return this.actions;
    }

    /**
     * Returns the list of relevant fluents of the problem.
     *
     * @return the list of relevant fluents of the problem.
     */
    public final List<Fluent> getRelevantFluents() {
        return this.relevantFluents;
    }

    /**
     * Returns the initial state of the problem.
     *
     * @return the initial state of the problem.
     */
    public final InitialState getInitialState() {
        return this.initialState;
    }

    /**
     * Returns the goal of the problem.
     *
     * @return the goal of the problem.
     */
    public final Goal getGoal() {
        return this.goal;
    }

    /**
     * Returns the list of relevant fluents of the problem in the form of <code>IntExpression</code>.
     *
     * @return the list of relevant fluents of the problem in the form of <code>IntExpression</code>.
     */
    protected List<IntExpression> getRelevantIntExpFluents() {
        return this.intExpRelevantFluents;
    }

    /**
     * Returns the map used to encode fluents into bit set representation.
     *
     *
     * @return the map used to encode fluents into bit set representation.
     */
    protected Map<IntExpression, Integer> getMapOfFluentIndex() {
        return this.mapOfFluentIndex;
    }

    /**
     * Returns the list of relevant numeric fluents of the problem in the form of <code>IntExpression</code>.
     *
     * @return the list of relevant numericfluents of the problem in the form of <code>IntExpression</code>.
     */
    protected List<IntExpression> getIntExpRelevantNumericFluents() {
        return this.intExpRelevantNumericFluents;
    }

    /**
     * Returns the map used to encode numeric fluents into bit set representation.
     *
     * @return the map used to encode numeric fluents into bit set representation.
     */
    protected Map<IntExpression, Integer> getMapOfNumericFluentIndex() {
        return this.mapOfNumericFluentIndex;
    }


    /**
     * Extracts the relevant facts from the instantiated actions. A ground fact is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fact and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fact and not a positive ground inertia.</li>
     * </ul>
     *
     */
    protected void extractRelevantFacts() {
        final Set<IntExpression> facts = new LinkedHashSet<>(10000);
        for (IntAction a : this.getIntActions()) {
            extractRelevantFacts(a.getPreconditions(), facts);
            extractRelevantFacts(a.getEffects(), facts);
        }
        for (IntExpression p : this.getIntInitPredicates()) {
            Inertia inertia = this.getGroundInertia().get(p);
            if (inertia == null) {
                inertia = Inertia.INERTIA;
            }
            if (this.getIntInitPredicates().contains(p) && !inertia.equals(Inertia.NEGATIVE)) {
                facts.add(p);
            }
        }
        this.intExpRelevantFluents = new ArrayList<>(facts.size());
        this.relevantFluents = new ArrayList<>(facts.size());
        for (IntExpression exp : facts) {
            final IntExpression relevant = new IntExpression(exp);
            this.intExpRelevantFluents.add(relevant);
            this.relevantFluents.add(new Fluent(exp.getPredicate(), exp.getArguments()));
        }
    }

    /**
     * Extracts the relevant facts from a specified expression. A ground fact is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fact and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fact and not a positive ground inertia.</li>
     * </ul>
     *
     * @param exp   the expression.
     * @param facts the set of relevant facts.
     */
    protected void extractRelevantFacts(final IntExpression exp, final Set<IntExpression> facts) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = this.getGroundInertia().get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                if ((this.getIntInitPredicates().contains(exp) && !inertia.equals(Inertia.NEGATIVE))
                    || (!this.getIntInitPredicates().contains(exp) && !inertia.equals(Inertia.POSITIVE))) {
                    facts.add(exp);
                }
                break;
            case FN_HEAD:
                break;
            case EQUAL_ATOM:
                break;
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    this.extractRelevantFacts(e, facts);
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
            case NOT:
                extractRelevantFacts(exp.getChildren().get(0), facts);
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
                extractRelevantFacts(exp.getChildren().get(0), facts);
                extractRelevantFacts(exp.getChildren().get(1), facts);
                break;
            case F_EXP_T:
            case F_EXP:
                if (!exp.getChildren().isEmpty()) {
                    extractRelevantFacts(exp.getChildren().get(0), facts);
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                extractRelevantFacts(exp.getChildren().get(0), facts);
                extractRelevantFacts(exp.getChildren().get(1), facts);
                extractRelevantFacts(exp.getChildren().get(3), facts);
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
     * Extracts the relevant numeric fluents.
     *
     * @param actions the list of instantiated actions.
     */
    protected void extractRelevantNumericFluents(final List<IntAction> actions) {
        final Set<IntExpression> fluents = new LinkedHashSet<>(100);
        for (IntAction a : actions) {
            if (a.isDurative()) {
                this.extractRelevantNumericFluents(a.getDuration(), fluents);
            }
            this.extractRelevantNumericFluents(a.getPreconditions(), fluents);
            this.extractRelevantNumericFluents(a.getEffects(), fluents);
        }
        this.intExpRelevantNumericFluents = new ArrayList<>(fluents.size());
        for (IntExpression exp : fluents) {
            final IntExpression relevant = new IntExpression(exp);
            this.intExpRelevantNumericFluents.add(relevant);
        }
    }

    /**
     * Extracts the relevant facts from a specified expression. A ground fact is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fact and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fact and not a positive ground inertia.</li>
     * </ul>
     *
     * @param exp   the expression.
     * @param fluents the set of relevant facts.
     */
    private void extractRelevantNumericFluents(final IntExpression exp, final Set<IntExpression> fluents) {
        switch (exp.getConnective()) {
            case FN_HEAD:
                fluents.add(exp);
                break;
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    this.extractRelevantNumericFluents(e, fluents);
                }
                break;
            case UMINUS:
            case NOT:
                this.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                break;
            case WHEN:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                this.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                this.extractRelevantNumericFluents(exp.getChildren().get(1), fluents);
                break;
            case F_EXP:
                this.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                break;
            case TIME_VAR:
            case NUMBER:
            case ATOM:
            case TRUE:
            case FALSE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());

        }
    }



    protected void initOfMapFluentIndex() {
        // Create a map of the relevant fluents with their index to speedup the bit set encoding of the actions
        this.mapOfFluentIndex = new LinkedHashMap<>(this.getRelevantIntExpFluents().size());
        int index = 0;
        for (IntExpression fluent : this.getRelevantIntExpFluents()) {
            this.mapOfFluentIndex.put(fluent, index);
            index++;
        }
    }



    /**
     * Create a map of the relevant numeric fluents with their index to speedup the bit set encoding of the actions
     */
    protected void initMapOfNumericFluentIndex() {
        this.mapOfNumericFluentIndex = new LinkedHashMap<>(this.getIntExpRelevantNumericFluents().size());
        int index = 0;
        for (IntExpression fluent : this.getIntExpRelevantNumericFluents()) {
            this.mapOfNumericFluentIndex.put(fluent, index);
        }
    }



    /**
     * Encode a list of specified actions into <code>BitSet</code> representation. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     */
    protected void encodeActions()
        throws UnexpectedExpressionException {
        this.actions = new ArrayList<>(this.getIntActions().size());
        final List<Action> addedActions = new ArrayList<>();
        int actionIndex = 0;
        for (IntAction intAction : this.getIntActions()) {
            List<IntAction> normalized = this.normalizeAction(intAction);
            if (normalized.size() > 1) System.out.println("ERREUR Disjunction Preconditions in encoding ");
            this.actions.add(this.encodeAction(normalized.get(0)));
            for (int i  = 1; i < normalized.size(); i++) {
                // update the index of the relevant action must push in the HTN problem class
                //if (this.getRelevantOperators() != null) {
                //    this.getRelevantOperators().get(actionIndex).add(actions.size() + addedActions.size());
                //}
                addedActions.add(this.encodeAction(normalized.get(i)));
            }
            actionIndex++;
        }
        this.actions.addAll(addedActions);
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @return the expression in bit set representation.
     */
    private Effect encodeEffect(final IntExpression exp) throws UnexpectedExpressionException {
        final Effect effect = new Effect();
        System.out.println("EXP " + this.toString(exp));
        switch (exp.getConnective()) {
            case ATOM:
                Integer index = this.mapOfFluentIndex.get(exp);
                if (index != null) {
                    effect.getPositiveFluents().set(index);
                } else {
                    System.out.println(this.toString(exp) + " not found");
                }
                break;
            case NOT:
                index = this.mapOfFluentIndex.get(exp.getChildren().get(0));
                if (index != null) {
                    effect.getNegativeFluents().set(index);
                }
                break;
            case AND:
                final List<IntExpression> children = exp.getChildren();
                for (IntExpression ei : children) {
                    switch (ei.getConnective()) {
                        case ATOM:
                            index = this.mapOfFluentIndex.get(ei);
                            if (index != null) {
                                effect.getPositiveFluents().set(index);
                            }
                            break;
                        case NOT:
                            index = this.mapOfFluentIndex.get(ei.getChildren().get(0));
                            if (index != null) {
                                effect.getNegativeFluents().set(index);
                            }
                            break;
                        case TRUE:
                            // do nothing
                            break;
                        case ASSIGN:
                        case INCREASE:
                        case DECREASE:
                        case SCALE_UP:
                        case SCALE_DOWN:
                            NumericAssignment assignment = this.encodeNumericAssignment(ei);
                            effect.addNumericAssignment(assignment);
                            break;
                        default:
                            throw new UnexpectedExpressionException(ei.getConnective().toString());
                    }
                }
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                NumericAssignment assignment = this.encodeNumericAssignment(exp);
                effect.addNumericAssignment(assignment);
                break;
            case TRUE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
        return effect;
    }

    /**
     * Normalize an action, i.e, put in disjunctive normal form (DNF) for preconditions and put
     * in conjunctive normal form (CNF) for effects. If an action has disjunctive preconditions, a
     * new operator is created such all actions after normalization have only conjunctive
     * precondition.
     *
     * @param action the action to normalize.
     */
    private List<IntAction> normalizeAction(final IntAction action) {
        final List<IntAction> normalisedActions = new ArrayList<>();
        this.toCNF(action.getEffects());
        this.simplify(action.getEffects());
        final IntExpression precond = action.getPreconditions();
        this.toDNF(precond);
        if (precond.getChildren().size() > 0) {
            for (final IntExpression ei : precond.getChildren()) {
                final String name = action.getName();
                final int arity = action.arity();
                final IntAction newAction = new IntAction(name, arity);
                newAction.setCost(action.getCost());
                for (int i = 0; i < arity; i++) {
                    newAction.setTypeOfParameter(i, action.getTypeOfParameters(i));
                }
                for (int i = 0; i < arity; i++) {
                    newAction.setValueOfParameter(i, action.getValueOfParameter(i));
                }
                if (action.isDurative()) {
                    newAction.setDuration(new IntExpression(action.getDuration()));
                }
                newAction.setPreconditions(ei);

                newAction.setEffects(new IntExpression(action.getEffects()));
                normalisedActions.add(newAction);
            }
        } else {
            normalisedActions.add(action);
        }
        return normalisedActions;
    }

    /**
     * Encodes a numeric assignment.
     */
    protected NumericAssignment encodeNumericAssignment(final IntExpression exp) {

        final NumericVariable fluent = new NumericVariable(this.mapOfNumericFluentIndex.get(exp.getChildren().get(0)));
        final ArithmeticExpression arithmeticExpression = this.encodeArithmeticExpression(exp.getChildren().get(1));
        NumericAssignment assignment = null;
        switch (exp.getConnective()) {
            case ASSIGN:
                assignment = new NumericAssignment(NumericAssignment.Operator.ASSIGN, fluent, arithmeticExpression);
                break;
            case INCREASE:
                assignment = new NumericAssignment(NumericAssignment.Operator.INCREASE, fluent, arithmeticExpression);
                break;
            case DECREASE:
                assignment = new NumericAssignment(NumericAssignment.Operator.DECREASE, fluent, arithmeticExpression);
                break;
            case SCALE_UP:
                assignment = new NumericAssignment(NumericAssignment.Operator.SCALE_UP, fluent, arithmeticExpression);
                break;
            case SCALE_DOWN:
                assignment = new NumericAssignment(NumericAssignment.Operator.SCALE_DOWN, fluent, arithmeticExpression);
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
        return assignment;
    }

    /**
     * Encodes a specified action.
     *
     * @param action the action to be encoded. The precondition of the action must be a simple conjunction of atomic
     *               formulas
     * @return the action encoded.
     */
    private Action encodeAction(final IntAction action) {
        final int arity = action.arity();
        final Action encoded = new Action(action.getName(), arity);
        encoded.setCost(new NumericVariable(-1, action.getCost()));

        // Initialize the parameters of the action
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, action.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, action.getTypeOfParameters(i));
        }

        if (action.isDurative()) {
            List<NumericConstraint> duration = this.encodeNumericConstraints(action.getDuration());
            encoded.setDurationConstraints(duration);
        }

        // Initialize the preconditions of the action
        encoded.setPrecondition(this.encodeCondition(action.getPreconditions()));

        // Initialize the effects of the action
        final List<IntExpression> effects = new ArrayList<>();
        if (action.getEffects().getConnective().equals(PDDLConnective.ATOM)) {
            effects.add(action.getEffects());
        } else {
            effects.addAll(action.getEffects().getChildren());
        }

        //System.out.println(this.toString(action));
        final ConditionalEffect unCondEffects = new ConditionalEffect();
        boolean hasUnConditionalEffects = false;
        for (IntExpression ei : effects) {
            final PDDLConnective connective = ei.getConnective();
            final List<IntExpression> children = ei.getChildren();
            //System.out.println("EXP " + this.toString(ei));
            switch (connective) {
                case WHEN:
                    // NumericAssignement not encoded in conditional effect.
                    final ConditionalEffect condBitExp = new ConditionalEffect();
                    condBitExp.setCondition(this.encodeCondition(children.get(0)));
                    condBitExp.setEffect(this.encodeEffect(children.get(1)));
                    encoded.getConditionalEffects().add(condBitExp);
                    break;
                case ATOM:
                    Integer index = this.mapOfFluentIndex.get(ei);
                    if (index != null) {
                        unCondEffects.getEffect().getPositiveFluents().set(index);
                        hasUnConditionalEffects = true;
                    } else {
                        //System.out.println(this.toString(ei) + " not found");
                    }
                    break;
                case NOT:
                    index = this.mapOfFluentIndex.get(children.get(0));
                    if (index != null) {
                        unCondEffects.getEffect().getNegativeFluents().set(index);
                        hasUnConditionalEffects = true;
                    }
                    break;
                case TRUE:
                    // do nothing
                    break;
                case ASSIGN:
                case SCALE_DOWN:
                case SCALE_UP:
                case INCREASE:
                case DECREASE:
                    NumericAssignment assignment = this.encodeNumericAssignment(ei);
                    unCondEffects.getEffect().addNumericAssignment(assignment);
                    break;
                default:
                    throw new UnexpectedExpressionException(ei.getConnective().toString());
            }
        }
        if (hasUnConditionalEffects) {
            encoded.getConditionalEffects().add(unCondEffects);
        }
        /*try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return encoded;
    }

    /**
     * Encode a specified goal in a disjunction of <code>BitExp</code>. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @return a list of <code>BitExp</code> that represents the goal as a disjunction of
     * <code>BitExp</code>.
     */
    protected void encodeGoal() {

        if (this.getIntGoal().getConnective().equals(PDDLConnective.FALSE)) {
            this.goal = null;
        } else {
            this.toDNF(this.getIntGoal());
            List<Goal> goals = new ArrayList<>(this.getIntGoal().getChildren().size());
            for (IntExpression exp : this.getIntGoal().getChildren()) {
                if (exp.getConnective().equals(PDDLConnective.ATOM)) {
                    IntExpression and = new IntExpression(PDDLConnective.AND);
                    and.getChildren().add(exp);
                    goals.add(new Goal(this.encodeCondition(and)));
                } else {
                    goals.add(new Goal(this.encodeCondition(exp)));
                }
            }
            if (goals.size() > 1) {
                // Create a new dummy fact to encode the goal
                final int dummyPredicateIndex = this.getPredicateSymbols().size();
                this.getPredicateSymbols().add(Constants.DUMMY_GOAL);
                this.getPredicateSignatures().add(new ArrayList<>());
                IntExpression dummyGoal = new IntExpression(PDDLConnective.ATOM);
                dummyGoal.setPredicate(dummyPredicateIndex);
                dummyGoal.setArguments(new int[0]);
                final int dummyGoalIndex = this.getRelevantIntExpFluents().size();
                this.getRelevantIntExpFluents().add(dummyGoal);
                this.mapOfNumericFluentIndex.put(dummyGoal, dummyGoalIndex);
                Effect effect = new Effect();
                effect.getPositiveFluents().set(dummyGoalIndex);
                this.goal = new Goal();
                effect.getPositiveFluents().set(dummyGoalIndex);
                final ConditionalEffect condEffect = new ConditionalEffect(effect);
                // for each disjunction create a dummy action
                for (Condition dis : goals) {
                    final Action op = new Action(Constants.DUMMY_OPERATOR, 0);
                    op.setDummy(true);
                    op.setPrecondition(dis);
                    op.getConditionalEffects().add(condEffect);
                    this.getActions().add(op);
                }
            } else {
                this.goal = goals.get(0);
            }
        }
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     */
    protected Condition encodeCondition(final IntExpression exp) throws UnexpectedExpressionException {
        final Condition condition = new Condition();
        switch (exp.getConnective()) {
            case ATOM:
                condition.getPositiveFluents().set(this.getMapOfFluentIndex().get(exp));
                break;
            case NOT:
                condition.getNegativeFluents().set(this.getMapOfFluentIndex().get(exp.getChildren().get(0)));
                break;
            case AND:
                for (IntExpression e : exp.getChildren()) {
                    Condition ce = this.encodeCondition(e);
                    condition.getPositiveFluents().or(ce.getPositiveFluents());
                    condition.getNegativeFluents().or(ce.getNegativeFluents());
                    condition.getNumericConstraints().addAll(ce.getNumericConstraints());
                }
                break;
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
                condition.getNumericConstraints().add(this.encodeNumericConstraint(exp));
                break;
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
        return condition;
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @return the expression in bit set representation.
     */
    private List<NumericConstraint> encodeNumericConstraints(final IntExpression exp)
        throws UnexpectedExpressionException {

        final List<NumericConstraint> constraints = new ArrayList<>();
        switch (exp.getConnective()) {
            case AND:
                for (IntExpression e : exp.getChildren()) {
                    constraints.addAll(this.encodeNumericConstraints(e));
                }
                break;
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
                constraints.add(this.encodeNumericConstraint(exp));
                break;
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
        return constraints;
    }

    /**
     * Encodes a numeric constraint.
     */
    private NumericConstraint encodeNumericConstraint(final IntExpression exp) {

        ArithmeticExpression left = this.encodeArithmeticExpression(exp.getChildren().get(0));
        ArithmeticExpression right = this.encodeArithmeticExpression(exp.getChildren().get(1));
        NumericConstraint constraint;
        switch (exp.getConnective()) {
            case EQUAL:
                constraint = new NumericConstraint(NumericConstraint.Comparator.EQUAL, left, right);
                break;
            case LESS:
                constraint = new NumericConstraint(NumericConstraint.Comparator.LESS, left, right);
                break;
            case LESS_OR_EQUAL:
                constraint = new NumericConstraint(NumericConstraint.Comparator.LESS_OR_EQUAL, left, right);
                break;
            case GREATER:
                constraint = new NumericConstraint(NumericConstraint.Comparator.GREATER, left, right);
                break;
            case GREATER_OR_EQUAL:
                constraint = new NumericConstraint(NumericConstraint.Comparator.GREATER_OR_EQUAL, left, right);
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
        return constraint;
    }
    /**
     * Encodes an arithmetic expression.
     *
     * @param exp the expression to encode.
     */
    private ArithmeticExpression encodeArithmeticExpression(final IntExpression exp) {

        ArithmeticExpression arithmeticExpression;
        ArithmeticExpression left;
        ArithmeticExpression right;
        switch (exp.getConnective()) {
            case PLUS:
                left = this.encodeArithmeticExpression(exp.getChildren().get(0));
                right = this.encodeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.PLUS, left, right);
                break;
            case MINUS:
                left = this.encodeArithmeticExpression(exp.getChildren().get(0));
                right = this.encodeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.MINUS, left, right);
                break;
            case UMINUS:
                left = this.encodeArithmeticExpression(exp.getChildren().get(0));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.UMINUS, left, null);
                break;
            case DIV:
                left = this.encodeArithmeticExpression(exp.getChildren().get(0));
                right = this.encodeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.DIV, left, right);
                break;
            case MUL:
                left = this.encodeArithmeticExpression(exp.getChildren().get(0));
                right = this.encodeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.MUL, left, right);
                break;
            case NUMBER:
                arithmeticExpression = new ArithmeticExpression(exp.getValue());
                break;
            case F_EXP:
                arithmeticExpression = this.encodeArithmeticExpression(exp.getChildren().get(0));
                break;
            case FN_HEAD:
                arithmeticExpression = new NumericVariable(this.getMapOfNumericFluentIndex().get(exp));
                break;
            case TIME_VAR:
                arithmeticExpression = new NumericVariable(NumericVariable.DURATION);
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
        return arithmeticExpression;
    }








    /**
     * Encode a specified initial state in it <code>BitExp</code> representation. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @return the <code>BitExp</code> that represents the initial encoded.
     */
    protected void encodeInit() {
        this.initialState = new InitialState();
        for (final IntExpression fact : this.getIntInitPredicates()) {
            switch (fact.getConnective()) {
                case ATOM:
                    Integer i = this.mapOfFluentIndex.get(fact);
                    if (i != null) {
                        this.initialState.getPositiveFluents().set(i);
                    }
                    break;
                case NOT:
                    i = this.mapOfFluentIndex.get(fact.getChildren().get(0));
                    if (i != null) {
                        this.initialState.getNegativeFluents().set(i);
                    }
                    break;
            }
        }
    }

    /**
     * Encode the numeric fluent of the initial state.
     */
    protected void encodeInitNumericFluent() {
        for (Map.Entry<IntExpression, Integer> e : this.mapOfNumericFluentIndex.entrySet()) {
            int index = e.getValue();
            double value = this.getIntInitFunctionCost().get(e.getKey());
            NumericVariable fluent = new NumericVariable(index, value);
            this.initialState.addNumericFluent(fluent);
        }
    }


    /**
     * Returns a string representation of a specified operator.
     *
     * @param action     the action.
     * @return a string representation of the specified operator.
     */
    public final String toString(final Action action) {
        StringBuilder str = new StringBuilder();
        str.append("Action ").append(action.getName()).append("\n").append("Instantiations:\n");
        for (int i = 0; i < action.arity(); i++) {
            final int index = action.getValueOfParameter(i);
            final String type = this.getTypeSymbols().get(action.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(this.getConstantSymbols().get(index));
                str.append(" \n");
            }
        }
        str.append("Preconditions:\n");
        str.append(this.toString(action.getPrecondition()));
        str.append("\n");
        str.append("Effects:\n");
        for (ConditionalEffect condExp : action.getConditionalEffects()) {
            str.append(this.toString(condExp));
            str.append("\n");
        }
        return str.toString();
    }



    /**
     * Returns a string representation of a state.
     *
     * @param state the state.
     * @return a string representation of the state.
     */
    public final String toString(final Condition state) {
        final StringBuilder str = new StringBuilder("(and");
        final BitSet positive = state.getPositiveFluents();
        for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
            str.append(" ");
            str.append(this.toString(this.getRelevantFluents().get(j)));
            str.append("\n");
        }
        final BitSet negative = state.getNegativeFluents();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append(" (not ");
            str.append(this.toString(this.getRelevantFluents().get(i)));
            str.append(")\n");
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a conditional effect.
     *
     * @param ceffect  the conditional effect.
     * @return a string representation of the specified condition effect.
     */
    public final String toString(final ConditionalEffect ceffect) {
        StringBuilder str = new StringBuilder();
        if (ceffect.getCondition().isEmpty()) {
            str.append(this.toString(ceffect.getEffect()));
        } else {
            str.append("(when ");
            str.append(this.toString(ceffect.getCondition()));
            str.append("\n");
            str.append(this.toString(ceffect.getEffect()));
            str.append(")");
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a state.
     *
     * @param state the state.
     * @return a string representation of the state.
     */
    public final String toString(final Effect state) {
        final StringBuilder str = new StringBuilder("(and");
        final BitSet positive = state.getPositiveFluents();
        for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
            str.append(" ");
            str.append(this.toString(this.getRelevantFluents().get(j)));
            str.append("\n");
        }
        final BitSet negative = state.getNegativeFluents();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append(" (not ");
            str.append(this.toString(this.getRelevantFluents().get(i)));
            str.append(")\n");
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a closed world state.
     *
     * @param state the state.
     * @return a string representation of the specified expression.
     */
    public final String toString(final State state) {
        final StringBuilder str = new StringBuilder("(and");
        for (int i = state.nextSetBit(0); i >= 0; i = state.nextSetBit(i + 1)) {
            str.append(" ");
            str.append(this.toString(this.getRelevantFluents().get(i)));
            str.append("\n");
        }
        str.append(")");
        return str.toString();
    }



    /**
     * Returns a string representation of a fluent.
     *
     * @param fluent the formula.
     * @return a string representation of the specified expression.
     */
    public String toString(final Fluent fluent) {
        final StringBuffer str = new StringBuffer();
        str.append("(");
        str.append(this.getPredicateSymbols().get(fluent.getSymbol()));
        for (Integer arg : fluent.getArguments()) {
            str.append(" ");
            str.append(this.getConstantSymbols().get(arg));
        }
        str.append(")");
        return str.toString();
    }



    /**
     * Returns a short string representation of the specified operator, i.e., its name and its
     * instantiated parameters. This method can be used for actions and methods.
     *
     * @param operator  the operator.
     * @return a string representation of the specified operator.
     */
    public final String toShortString(final AbstractGroundOperator operator) {
        final StringBuilder str = new StringBuilder();
        str.append(operator.getName());
        for (int i = 0; i < operator.arity(); i++) {
            final int index = operator.getValueOfParameter(i);
            if (index == -1) {
                str.append(" ?");
            } else {
                str.append(" ");
                str.append(this.getConstantSymbols().get(index));
            }
        }
        return str.toString();
    }

    /**
     * Return a detailed string representation of a search. Not compatible with VAL.
     *
     * @param plan the search.
     * @return a string representation of the specified search.
     */
    public final String toStringCost(final Plan plan) {
        int max = Integer.MIN_VALUE;
        for (Integer t : plan.timeSpecifiers()) {
            for (Action a : plan.getActionSet(t)) {
                int length = this.toShortString(a).length();
                if (max < length) {
                    max = length;
                }
            }
        }
        final int actionSize = max;
        final int timeSpecifierSize = (int) Math.log10(plan.timeSpecifiers().size()) + 1;

        final StringBuilder str = new StringBuilder();
        plan.timeSpecifiers().forEach(time ->
            plan.getActionSet(time).forEach(a ->
                str.append(String.format("%0" + timeSpecifierSize + "d: (%" + actionSize + "s) [%4.2f]%n",
                    time, this.toShortString(a), ((float) a.getCost().getValue())))));
        return str.toString();
    }

    /**
     * Return a string representation of a search.
     *
     * @param plan the search.
     * @return a string representation of the specified search.
     */
    public final String toString(final Plan plan) {
        int max = Integer.MIN_VALUE;
        for (Integer t : plan.timeSpecifiers()) {
            for (Action a : plan.getActionSet(t)) {
                int length = this.toShortString(a).length();
                if (max < length) {
                    max = length;
                }
            }
        }
        final int actionSize = max;
        final int timeSpecifierSize = (int) Math.log10(plan.timeSpecifiers().size()) + 1;

        final StringBuilder str = new StringBuilder();
        plan.timeSpecifiers().forEach(time ->
            plan.getActionSet(time).forEach(a ->
                str.append(String.format("%0" + timeSpecifierSize + "d: (%" + actionSize + "s) [%d]%n",
                    time, this.toShortString(a), (int) a.getDuration().getValue()))));
        return str.toString();
    }

}
