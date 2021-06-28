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

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLSymbol;
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.plan.Hierarchy;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.problem.numeric.ArithmeticExpression;
import fr.uga.pddl4j.problem.numeric.ArithmeticOperator;
import fr.uga.pddl4j.problem.numeric.NumericAssignment;
import fr.uga.pddl4j.problem.numeric.NumericConstraint;
import fr.uga.pddl4j.problem.numeric.NumericFluent;
import fr.uga.pddl4j.problem.numeric.NumericVariable;
import fr.uga.pddl4j.problem.operator.AbstractGroundOperator;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Condition;
import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.problem.operator.Constants;
import fr.uga.pddl4j.problem.operator.Effect;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.IntExpression;
import fr.uga.pddl4j.problem.operator.IntMethod;
import fr.uga.pddl4j.problem.operator.IntTaskNetwork;
import fr.uga.pddl4j.problem.operator.Method;
import fr.uga.pddl4j.problem.operator.OrderingConstraintSet;
import fr.uga.pddl4j.problem.operator.TaskNetwork;
import fr.uga.pddl4j.util.BitMatrix;
import fr.uga.pddl4j.util.BitSet;
import fr.uga.pddl4j.util.BitVector;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class contains all the methods needed to post instantiation process of a planning problem. In particular, this
 * class contains the methods necessary to compactly encode the problem in susing compact bit set representation.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public abstract class FinalizedProblem extends PostInstantiatedProblem {

    /**
     * The list of instantiated actions encoded into bit sets.
     */
    private List<Action> actions;

    /**
     * The list of relevant fluents.
     */
    private List<Fluent> fluents;

    /**
     * The list of numeric fluents.
     */
    private List<NumericFluent> numericFluents;

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
    private List<IntExpression> intExpFluents;

    /**
     * The map used to encode fluents into bit set representation.
     */
    private Map<IntExpression, Integer> mapOfFluentIndex;

    /**
     * The table of the relevant numeric fluent in the form of <code>IntExpression</code>.
     */
    private List<IntExpression> intExpNumericFluents;

    /**
     * The map used to encode numeric fluents into bit set representation.
     */
    private Map<IntExpression, Integer> mapOfNumericFluentIndex;

    /**
     * Returns the map used to encode the task into integer.
     */
    private Map<IntExpression, Integer> mapOfTasksIndex;

    /**
     * The initial task network.
     */
    private TaskNetwork initialTaskNetwork;

    /**
     * The list containing for each relevant task at a specified the set of resolvers, i.e., action or methods.
     */
    private List<List<Integer>> taskResolvers;

    /**
     * The list of instantiated methods encoded into bit sets.
     */
    private List<Method> methods;

    /**
     * The list of relevant tasks of the problem.
     */
    private List<Task> tasks;

    /**
     * Creates a new problem from a domain and problem.
     *
     * @param problem the problem.
     */
    public FinalizedProblem(final ParsedProblem problem) {
        super(problem);
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
    public final List<Fluent> getFluents() {
        return this.fluents;
    }

    /**
     * Returns the list of relevant numeric fluents of the problem.
     *
     * @return the list of relevant numeric fluents of the problem.
     */
    public final List<NumericFluent> getNumericFluents() {
        return this.numericFluents;
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
    private List<IntExpression> getIntExpFluents() {
        return this.intExpFluents;
    }

    /**
     * Returns the map used to encode fluents into bit set representation.
     *
     *
     * @return the map used to encode fluents into bit set representation.
     */
    private Map<IntExpression, Integer> getMapOfFluentIndex() {
        return this.mapOfFluentIndex;
    }

    /**
     * Returns the list of relevant numeric fluents of the problem in the form of <code>IntExpression</code>.
     *
     * @return the list of relevant numericfluents of the problem in the form of <code>IntExpression</code>.
     */
    private List<IntExpression> getIntExpNumericFluents() {
        return this.intExpNumericFluents;
    }

    /**
     * Returns the map used to encode numeric fluents into bit set representation.
     *
     * @return the map used to encode numeric fluents into bit set representation.
     */
    private Map<IntExpression, Integer> getMapOfNumericFluentIndex() {
        return this.mapOfNumericFluentIndex;
    }

    /**
     * Returns the map used to encode the task into integer.
     *
     * @return the map used to encode the task into integer.
     */
    private Map<IntExpression, Integer> getMapOfTasksIndex() {
        return this.mapOfTasksIndex;
    }

    /**
     * Returns the relevant operators for a task.
     *
     * @return the relevant operators for a task.
     */
    protected List<List<Integer>> getTaskResolvers() {
        return taskResolvers;
    }

    /**
     * Returns the initial task network of the problem.
     *
     * @return the initial task network of the problem.
     */
    protected TaskNetwork getInitialTaskNetwork() {
        return initialTaskNetwork;
    }

    /**
     * The list of relevant tasks of the problem.
     *
     * @return the list of relevant tasks of the problem.
     */
    protected List<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Returns the list of instantiated methods of the problem.
     *
     * @return the list of instantiated methods of the problem.
     */
    protected List<Method> getMethods() {
        return this.methods;
    }

    /**
     * Extracts the relevant fluents from the instantiated actions. A fluents is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fact and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fact and not a positive ground inertia.</li>
     * </ul>
     *
     */
    protected void extractRelevantFluents() {
        final Set<IntExpression> facts = new LinkedHashSet<>(10000);
        for (IntAction a : this.getIntActions()) {
            extractRelevantFluents(a.getPreconditions(), facts);
            extractRelevantFluents(a.getEffects(), facts);
        }
        for (IntExpression p : this.getIntInitialState()) {
            Inertia inertia = this.getGroundInertia().get(p);
            if (inertia == null) {
                inertia = Inertia.INERTIA;
            }
            if (this.getIntInitialState().contains(p) && !inertia.equals(Inertia.NEGATIVE)) {
                facts.add(p);
            }
        }

        this.intExpFluents = new ArrayList<>(facts.size());
        this.fluents = new ArrayList<>(facts.size());
        for (IntExpression exp : facts) {
            final IntExpression relevant = new IntExpression(exp);
            this.intExpFluents.add(relevant);
            this.fluents.add(new Fluent(exp.getPredicate(), exp.getArguments()));
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
    protected void extractRelevantFluents(final IntExpression exp, final Set<IntExpression> facts) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = this.getGroundInertia().get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                if ((this.getIntInitialState().contains(exp) && !inertia.equals(Inertia.NEGATIVE))
                    || (!this.getIntInitialState().contains(exp) && !inertia.equals(Inertia.POSITIVE))) {
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
                    this.extractRelevantFluents(e, facts);
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
                extractRelevantFluents(exp.getChildren().get(0), facts);
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
                extractRelevantFluents(exp.getChildren().get(0), facts);
                extractRelevantFluents(exp.getChildren().get(1), facts);
                break;
            case F_EXP_T:
            case F_EXP:
                if (!exp.getChildren().isEmpty()) {
                    extractRelevantFluents(exp.getChildren().get(0), facts);
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                extractRelevantFluents(exp.getChildren().get(0), facts);
                extractRelevantFluents(exp.getChildren().get(1), facts);
                extractRelevantFluents(exp.getChildren().get(3), facts);
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
     **/
    protected void extractRelevantNumericFluents() {
        final Set<IntExpression> fluents = new LinkedHashSet<>(100);
        for (IntAction a : this.getIntActions()) {
            if (a.isDurative()) {
                this.extractRelevantNumericFluents(a.getDuration(), fluents);
            }
            this.extractRelevantNumericFluents(a.getPreconditions(), fluents);
            this.extractRelevantNumericFluents(a.getEffects(), fluents);
        }
        this.intExpNumericFluents = new ArrayList<>(fluents.size());
        this.numericFluents = new ArrayList<>(fluents.size());
        for (IntExpression exp : fluents) {
            final IntExpression relevant = new IntExpression(exp);
            this.intExpNumericFluents.add(relevant);
            this.numericFluents.add(new NumericFluent(exp.getPredicate(), exp.getArguments()));
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

    /**
     * Initializes the map that store for each relevant fluent its index to speedup the bit set encoding of the action.
     */
    protected void initOfMapFluentIndex() {
        // Create a map of the relevant fluents with their index to speedup the bit set encoding of the actions
        this.mapOfFluentIndex = new LinkedHashMap<>(this.getIntExpFluents().size());
        int index = 0;
        for (IntExpression fluent : this.getIntExpFluents()) {
            this.mapOfFluentIndex.put(fluent, index);
            index++;
        }
    }

    /**
     * Create a map of the relevant numeric fluents with their index to speedup the bit set encoding of the actions.
     */
    protected void initMapOfNumericFluentIndex() {
        this.mapOfNumericFluentIndex = new LinkedHashMap<>(this.getIntExpNumericFluents().size());
        int index = 0;
        for (IntExpression fluent : this.getIntExpNumericFluents()) {
            this.mapOfNumericFluentIndex.put(fluent, index);
        }
    }

    /**
     * Encode a list of specified actions into <code>BitSet</code> representation. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     */
    protected void finalizeActions()
        throws UnexpectedExpressionException {
        this.actions = new ArrayList<>(this.getIntActions().size());
        final List<Action> addedActions = new ArrayList<>();
        int actionIndex = 0;
        for (IntAction intAction : this.getIntActions()) {
            List<IntAction> normalized = this.normalizeAction(intAction);
            this.actions.add(this.finalizeAction(normalized.get(0)));
            for (int i  = 1; i < normalized.size(); i++) {
                // update the index of the relevant action must push in the HTN problem class
                if (this.getTaskResolvers() != null) {
                    this.getTaskResolvers().get(actionIndex).add(actions.size() + addedActions.size());
                }
                addedActions.add(this.finalizeAction(normalized.get(i)));
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
    private Effect finalizeEffect(final IntExpression exp) throws UnexpectedExpressionException {
        final Effect effect = new Effect();
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
                            NumericAssignment assignment = this.finalizeNumericAssignment(ei);
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
                NumericAssignment assignment = this.finalizeNumericAssignment(exp);
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
        final IntExpression precond = new IntExpression(action.getPreconditions());
        this.toDNF(precond);
        if (precond.getChildren().size() > 1) {
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
    private NumericAssignment finalizeNumericAssignment(final IntExpression exp) {

        final NumericVariable fluent = new NumericVariable(this.mapOfNumericFluentIndex.get(exp.getChildren().get(0)));
        final ArithmeticExpression arithmeticExpression = this.finalizeArithmeticExpression(exp.getChildren().get(1));
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
    private Action finalizeAction(final IntAction action) {
        final int arity = action.arity();
        final Action encoded = new Action(action.getName(), arity);
        encoded.setCost(new NumericVariable(-1, action.getCost()));

        // Initialize the parameters of the action
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, action.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, action.getTypeOfParameters(i));
        }

        if (action.isDurative()) {
            List<NumericConstraint> duration = this.finalizeNumericConstraints(action.getDuration());
            encoded.setDurationConstraints(duration);
        }

        // Initialize the preconditions of the action
        encoded.setPrecondition(this.finalizeCondition(action.getPreconditions()));

        // Initialize the effects of the action
        final LinkedList<IntExpression> effects = new LinkedList<>();
        if (action.getEffects().getConnective().equals(PDDLConnective.ATOM)) {
            effects.add(action.getEffects());
        } else {
            effects.addAll(action.getEffects().getChildren());
        }

        //System.out.println(this.toString(action));
        final ConditionalEffect unCondEffects = new ConditionalEffect();
        boolean hasUnConditionalEffects = false;
        while (!effects.isEmpty()) { //for (IntExpression ei : effects) {
            IntExpression ei = effects.poll();
            final PDDLConnective connective = ei.getConnective();
            final List<IntExpression> children = ei.getChildren();
            //System.out.println("EXP " + this.toString(ei));
            switch (connective) {
                case WHEN:
                    // NumericAssignement not encoded in conditional effect.
                    final ConditionalEffect condBitExp = new ConditionalEffect();
                    condBitExp.setCondition(this.finalizeCondition(children.get(0)));
                    condBitExp.setEffect(this.finalizeEffect(children.get(1)));
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
                    NumericAssignment assignment = this.finalizeNumericAssignment(ei);
                    unCondEffects.getEffect().addNumericAssignment(assignment);
                    break;
                case AND:
                    effects.addAll(ei.getChildren());
                    break;
                default:
                    throw new UnexpectedExpressionException(this.toString(ei));
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
     */
    protected void finalizeGoal() {

        if (this.getIntGoal().getConnective().equals(PDDLConnective.FALSE)) {
            this.goal = null;
        } else {
            this.toDNF(this.getIntGoal());
            List<Goal> goals = new ArrayList<>(this.getIntGoal().getChildren().size());
            for (IntExpression exp : this.getIntGoal().getChildren()) {
                if (exp.getConnective().equals(PDDLConnective.ATOM)) {
                    IntExpression and = new IntExpression(PDDLConnective.AND);
                    and.getChildren().add(exp);
                    goals.add(new Goal(this.finalizeCondition(and)));
                } else {
                    goals.add(new Goal(this.finalizeCondition(exp)));
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
                final int dummyGoalIndex = this.getIntExpFluents().size();
                this.getIntExpFluents().add(dummyGoal);
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
     * Encode an specified <code>IntExpression</code> that represents a condition in its <code>BitExp</code>
     * representation. The map of fluent index is used to speed-up the encoding.
     *
     * @param exp the <code>IntExpression</code>.
     * @return the condition encoded.
     */
    protected Condition finalizeCondition(final IntExpression exp) throws UnexpectedExpressionException {
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
                    Condition ce = this.finalizeCondition(e);
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
    private List<NumericConstraint> finalizeNumericConstraints(final IntExpression exp)
        throws UnexpectedExpressionException {

        final List<NumericConstraint> constraints = new ArrayList<>();
        switch (exp.getConnective()) {
            case AND:
                for (IntExpression e : exp.getChildren()) {
                    constraints.addAll(this.finalizeNumericConstraints(e));
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
     *
     * @param exp the exp to encode.
     */
    private NumericConstraint encodeNumericConstraint(final IntExpression exp) {

        ArithmeticExpression left = this.finalizeArithmeticExpression(exp.getChildren().get(0));
        ArithmeticExpression right = this.finalizeArithmeticExpression(exp.getChildren().get(1));
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
    private ArithmeticExpression finalizeArithmeticExpression(final IntExpression exp) {
        ArithmeticExpression arithmeticExpression;
        ArithmeticExpression left;
        ArithmeticExpression right;
        switch (exp.getConnective()) {
            case PLUS:
                left = this.finalizeArithmeticExpression(exp.getChildren().get(0));
                right = this.finalizeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.PLUS, left, right);
                break;
            case MINUS:
                left = this.finalizeArithmeticExpression(exp.getChildren().get(0));
                right = this.finalizeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.MINUS, left, right);
                break;
            case UMINUS:
                left = this.finalizeArithmeticExpression(exp.getChildren().get(0));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.UMINUS, left, null);
                break;
            case DIV:
                left = this.finalizeArithmeticExpression(exp.getChildren().get(0));
                right = this.finalizeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.DIV, left, right);
                break;
            case MUL:
                left = this.finalizeArithmeticExpression(exp.getChildren().get(0));
                right = this.finalizeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.MUL, left, right);
                break;
            case NUMBER:
                arithmeticExpression = new ArithmeticExpression(exp.getValue());
                break;
            case F_EXP:
                arithmeticExpression = this.finalizeArithmeticExpression(exp.getChildren().get(0));
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
     * Encode a specified initial state in it bit compact representation. The map of the fluent index is used to speedup
     * the encoding.
     */
    protected void finalizeInitialState() {
        this.initialState = new InitialState();
        for (final IntExpression fact : this.getIntInitialState()) {
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
                default:
                    throw new UnexpectedExpressionException(this.toString(fact));
            }
        }
    }

    /**
     * Encode the numeric fluent of the initial state.
     */
    protected void finalizeInitialNumericFluent() {
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
            final String type = this.getTypes().get(action.getTypeOfParameters(i));
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
            str.append(this.toString(this.getFluents().get(j)));
            str.append("\n");
        }
        final BitSet negative = state.getNegativeFluents();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append(" (not ");
            str.append(this.toString(this.getFluents().get(i)));
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
            str.append(this.toString(this.getFluents().get(j)));
            str.append("\n");
        }
        final BitSet negative = state.getNegativeFluents();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append(" (not ");
            str.append(this.toString(this.getFluents().get(i)));
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
            str.append(this.toString(this.getFluents().get(i)));
            str.append("\n");
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a initial state.
     *
     * @param state the state.
     * @return a string representation of the specified expression.
     */
    public String toString(final InitialState state) {
        final StringBuilder str = new StringBuilder("(and");
        final BitVector positive = state.getPositiveFluents();
        for (int i = positive.nextSetBit(0); i >= 0; i = positive.nextSetBit(i + 1)) {
            str.append(" ");
            str.append(this.toString(this.getFluents().get(i)));
            str.append("\n");
        }
        final BitVector negative = state.getNegativeFluents();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append(" ");
            str.append(this.toString(this.getFluents().get(i)));
            str.append("\n");
        }
        for (NumericVariable var : state.getNumericVariables()) {
            str.append(" ");
            str.append(this.toString(var));
            str.append("\n");
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a fluent.
     *
     * @param fluent the fluent.
     * @return a string representation of the specified fluent.
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
     * Returns a string representation of a numeric fluent.
     *
     * @param fluent the numeric fluent.
     * @return a string representation of the specified numeric fluent.
     */
    public String toString(final NumericFluent fluent) {
        final StringBuffer str = new StringBuffer();
        str.append("(");
        str.append(this.getFunctions().get(fluent.getSymbol()));
        for (Integer arg : fluent.getArguments()) {
            str.append(" ");
            str.append(this.getConstantSymbols().get(arg));
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a numeric variable.
     *
     * @param variable the numeric variable.
     * @return a string representation of the specified numeric variable.
     */
    public String toString(final NumericVariable variable) {
        final StringBuffer str = new StringBuffer();
        str.append("(");
        str.append(variable.getArithmeticOperator());
        str.append(" ");
        str.append(this.toString(this.getNumericFluents().get(variable.getNumericFluent())));
        str.append(" ");
        str.append(variable.getValue());
        str.append(")");
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

    /**
     * Returns a string representation of the specified method.
     *
     * @param method the method.
     * @return a string representation of the specified method.
     */
    public final String toString(final Method method) {
        final StringBuilder str = new StringBuilder();
        str.append("Method ");
        str.append(method.getName());
        str.append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < method.arity(); i++) {
            final int index = method.getValueOfParameter(i);
            final String type = this.getTypes().get(method.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i).append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(this.getConstantSymbols().get(index));
                str.append(" \n");
            }
        }
        str.append("Task: " + this.toString(this.getTasks().get(method.getTask())) + "\n");
        str.append("Preconditions:\n");
        str.append(this.toString(method.getPrecondition()));
        str.append("\n");
        str.append(this.toString(method.getTaskNetwork()));
        return str.toString();
    }

    /**
     * Returns a string representation of the specified task network.
     *
     * @param tasknetwork the task network.
     * @return a string representation of the specified task network.
     */
    public final String toString(final TaskNetwork tasknetwork) {
        final StringBuilder str = new StringBuilder();
        str.append("Tasks:\n");
        if (tasknetwork.getTasks().isEmpty()) {
            str.append(" ()\n");
        } else {
            for (int i = 0; i < tasknetwork.getTasks().size(); i++) {
                str.append(" " + PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + i + ": ");
                str.append(this.toString(this.getTasks().get(tasknetwork.getTasks().get(i))));
                str.append("\n");
            }
        }
        str.append("Ordering constraints:\n");
        if (tasknetwork.getOrderingConstraints().cardinality() == 0) {
            str.append(" ()");
        } else {
            BitMatrix constraints = tasknetwork.getOrderingConstraints();
            int index = 0;
            for (int r = 0; r < constraints.rows(); r++) {
                BitSet row = constraints.getRow(r);
                for (int c = row.nextSetBit(0); c >= 0; c = row.nextSetBit(c + 1)) {
                    str.append(" C");
                    str.append(index);
                    str.append(": ");
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + r);
                    str.append(" ");
                    str.append(PDDLConnective.LESS_ORDERING_CONSTRAINT.getImage());
                    str.append(" ");
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + c);
                    str.append("\n");
                    index++;
                }
            }
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a task.
     *
     * @param task the formula.
     * @return a string representation of the specified expression.
     */
    public String toString(final Task task) {
        final StringBuffer str = new StringBuffer();
        str.append("(");
        str.append(this.getTaskSymbols().get(task.getSymbol()));
        for (Integer arg : task.getArguments()) {
            str.append(" ");
            str.append(this.getConstantSymbols().get(arg));
        }
        str.append(")");
        return str.toString();
    }


    /**
     * Returns a string representation of a hierarchical decomposition of plan.
     *
     * @param hierarchy the hierarchical decomposition to convert into string represention.
     * @return the string representation of the he hierarchical decomposition in parameter.
     */
    public String toString(final Hierarchy hierarchy) {
        StringBuilder str = new StringBuilder();
        str.append("==>\n");
        for (Map.Entry<Integer, Action> a : hierarchy.getPrimtiveTasks().entrySet()) {
            str.append(a.getKey());
            str.append(" ");
            str.append(this.toShortString(a.getValue()));
            str.append("\n");
        }
        str.append("root");
        for (Integer rootTask : hierarchy.getRootTasks()) {
            str.append(" ");
            str.append(rootTask);
        }
        str.append("\n");
        for (Map.Entry<Integer, Method> m : hierarchy.getCounpoudTasks().entrySet()) {
            str.append(m.getKey());
            str.append(" ");
            str.append(this.toString(this.getTasks().get(m.getValue().getTask())));
            str.append(" -> ");
            str.append(m.getValue().getName());
            for (Integer t : hierarchy.getDecomposition().get(m.getKey())) {
                str.append(" ");
                str.append(t);
            }
            str.append("\n");
        }
        str.append("<==\n");
        return str.toString();

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
            case FLUENTS:
                int index = 0;
                for (Fluent fluent : this.getFluents()) {
                    str.append(index);
                    str.append(": ");
                    str.append(this.toString(fluent));
                    str.append(System.lineSeparator());
                    index++;
                }
                break;
            case NUMERIC_FLUENTS:
                index = 0;
                for (NumericFluent fluent : this.getNumericFluents()) {
                    str.append(index);
                    str.append(": ");
                    str.append(this.toString(fluent));
                    str.append(System.lineSeparator());
                    index++;
                }
                break;
            case ACTIONS:
                for (Action action : this.getActions()) {
                    str.append(this.toString(action));
                    str.append(System.lineSeparator());
                }
                break;
            case METHODS:
                for (Method method : this.getMethods()) {
                    str.append(this.toString(method));
                    str.append(System.lineSeparator());
                }
                break;
            case GOAL:
                str.append(this.toString(this.getGoal()));
                str.append(System.lineSeparator());
                break;
            case INITIAL_STATE:
                str.append(this.toString(this.getInitialState()));
                str.append(System.lineSeparator());
                break;
            case INITIAL_TASK_NETWORK:
                str.append(this.toString(this.getInitialTaskNetwork()));
                str.append(System.lineSeparator());
                break;
            case TASKS:
                index = 0;
                for (Task task : this.getTasks()) {
                    str.append(index);
                    str.append(": ");
                    str.append(this.toString(task));
                    if (task.isPrimtive()) {
                        str.append(" : primitive");
                    } else {
                        str.append(" : compound");
                    }
                    str.append(System.lineSeparator());
                    index++;
                }
                break;
            case TASK_RESOLVERS:
                for (int i = 0; i < this.getTaskResolvers().size(); i++) {
                    str.append(i).append(": ");
                    str.append(this.toString(this.getTasks().get(i)));
                    str.append(":");
                    List<Integer> resolvers = this.getTaskResolvers().get(i);
                    for (int j = 0; j < resolvers.size(); j++) {
                        str.append(" ").append(resolvers.get(j));
                    }
                    str.append("\n");
                }
                break;
            default:
                return super.toString(data);
        }
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

    //------------------------------------------------------------------------------------------------------------------
    // Methods added to deal with HDDL problem.
    //

    /**
     * Extract all the relevant task of the problem from the list of primitive and compund tasks of the problem.
     */
    protected void extractRelevantTasks() {
        this.tasks = new ArrayList<>();
        for (IntExpression task : this.getRelevantPrimitiveTasks()) {
            this.tasks.add(new Task(task.getPredicate(), task.getArguments(), true));
        }
        for (IntExpression task : this.getRelevantCompundTasks()) {
            this.tasks.add(new Task(task.getPredicate(), task.getArguments(), false));
        }
    }

    /**
     * Creates the map index for the task.
     */
    protected void initMapOfTaskIndex() {
        List<IntExpression> tasks = new ArrayList<>();
        tasks.addAll(this.getRelevantPrimitiveTasks());
        tasks.addAll(this.getRelevantCompundTasks());

        // Create a map of the relevant tasks with their index to speedup the bit set encoding of the methods
        this.mapOfTasksIndex = new LinkedHashMap<>(tasks.size());
        int index = 0;
        for (IntExpression task : tasks) {
            this.mapOfTasksIndex.put(task, index);
            index++;
        }
    }

    /**
     * Init the resolvers for each tasks.
     */
    protected void initTaskResolvers() {
        this.taskResolvers = new ArrayList<>();
        for (Integer a : this.getRelevantActions()) {
            List<Integer> l = new ArrayList<>(1);
            l.add(a);
            this.taskResolvers.add(l);
        }
        this.taskResolvers.addAll(this.getRelevantMethods());
    }

    /**
     * Encode the initial task networl into its compact bit set representation.
     */
    protected void finalizeInitialTaskNetwork() {
        this.initialTaskNetwork = this.finalizeTaskNetwork(this.getIntInitialTaskNetwork());
    }

    /**
     * Encode a list of specified methods into the final compact representation. The specified
     * maps are used to speed-up the search by mapping the an expression to this index.
     */
    protected void finalizeMethods() throws UnexpectedExpressionException {
        this.methods = new ArrayList<>(this.getIntMethods().size());
        final List<Method> addedMethods = new ArrayList<>();
        int methodIndex = this.getRelevantActions().size();
        for (IntMethod intMethod : this.getIntMethods()) {
            List<IntMethod> normalized = this.normalizeMethod(intMethod);
            this.methods.add(this.finalizeMethod(normalized.get(0), this.getMapOfFluentIndex(), this.mapOfTasksIndex));
            for (int i  = 1; i < normalized.size(); i++) {
                if (this.getTaskResolvers() != null) {
                    this.getTaskResolvers().get(methodIndex).add(methods.size() + addedMethods.size());
                }
                this.methods.add(this.finalizeMethod(normalized.get(i), this.getMapOfFluentIndex(),
                    this.mapOfTasksIndex));
            }
            methodIndex++;
        }
        this.methods.addAll(addedMethods);
    }

    /**
     * Encode a list of specified methods into the final compact representation. The specified
     * maps are used to speed-up the search by mapping the an expression to this index.
     *
     * @param method the list of methods to encode.
     * @param factMap the map that associates at a specified fact its index in the table of relevant fluents.
     * @param taskMap the map that associates at a specified task its index in the table of relevant tasks.
     * @return the list of methods encoded into final compact representation.
     */
    private Method finalizeMethod(final IntMethod method, final Map<IntExpression, Integer> factMap,
                                    final Map<IntExpression, Integer> taskMap) throws UnexpectedExpressionException {

        final int arity = method.arity();
        final Method encoded = new Method(method.getName(), arity);
        // Initialize the parameters of the method
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, method.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, method.getTypeOfParameters(i));
        }
        // Encode the task carried out by the method
        encoded.setTask(taskMap.get(method.getTask()));
        // Encode the preconditions of the method
        encoded.setPrecondition(this.finalizeCondition(method.getPreconditions()));
        // Encode the task network of the method
        encoded.setTaskNetwork(this.finalizeTaskNetwork(method.getTaskNetwork()));
        return encoded;
    }

    /**
     * Encode a specified task network.
     *
     * @param taskNetwork the tasknetwork to encode.
     * @return the task network into its final bit set representation.
     * @see TaskNetwork
     */
    private TaskNetwork finalizeTaskNetwork(IntTaskNetwork taskNetwork) {
        // We encode first the tasks
        final List<Integer> tasks = new ArrayList<Integer>();
        this.encodeTasks(taskNetwork.getTasks(), tasks);
        // We encode then the ordering constraints
        final OrderingConstraintSet constraints = new OrderingConstraintSet(tasks.size());
        for (IntExpression c : taskNetwork.getOrderingConstraints().getChildren()) {
            constraints.set(c.getChildren().get(0).getTaskID(), c.getChildren().get(1).getTaskID());
        }
        final TaskNetwork tn = new TaskNetwork(tasks, constraints);
        tn.transitiveClosure();
        return tn;
    }

    /**
     * Normalize the methods, i.e, put in disjunctive normal form (DNF) the preconditions. If a method has
     * disjunctive preconditions, a new method is created such all methods after normalization have only conjunctive
     * precondition.
     *
     * @param method the list of methods to normalized.
     */
    private List<IntMethod> normalizeMethod(final IntMethod method) throws UnexpectedExpressionException {
        final List<IntMethod> normalisedMethods = new ArrayList<>();
        final IntExpression precond = new IntExpression(method.getPreconditions());
        this.toDNF(precond);
        if (precond.getChildren().size() > 1) {
            for (final IntExpression ei : precond.getChildren()) {
                final String name = method.getName();
                final int arity = method.arity();
                final IntMethod newMethod = new IntMethod(name, arity);
                for (int i = 0; i < arity; i++) {
                    newMethod.setTypeOfParameter(i, method.getTypeOfParameters(i));
                }
                for (int i = 0; i < arity; i++) {
                    newMethod.setValueOfParameter(i, method.getValueOfParameter(i));
                }
                newMethod.setPreconditions(ei);
                newMethod.setTask(new IntExpression(method.getTask()));
                newMethod.setTaskNetwork(new IntTaskNetwork(method.getTaskNetwork()));
                normalisedMethods.add(newMethod);
            }
        } else {
            normalisedMethods.add(method);
        }
        return normalisedMethods;
    }

    /**
     * Encode the list of tasks expressed as an IntExpression into a list of integer.
     *
     * @param exp   the list of tasks expressed as an IntExpression.
     * @param tasks the list of task encoded as integer.
     */
    private void encodeTasks(IntExpression exp, List<Integer> tasks) {
        switch (exp.getConnective()) {
            case TASK:
                tasks.add(this.mapOfTasksIndex.get(exp));
                break;
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    this.encodeTasks(e, tasks);
                }
                break;
            default:
                // Do nothing
        }
    }
}
