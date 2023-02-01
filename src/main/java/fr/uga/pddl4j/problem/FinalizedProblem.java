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
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.parser.Symbol;
import fr.uga.pddl4j.parser.SymbolType;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.plan.Hierarchy;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.problem.numeric.ArithmeticExpression;
import fr.uga.pddl4j.problem.numeric.ArithmeticOperator;
import fr.uga.pddl4j.problem.numeric.AssignmentOperator;
import fr.uga.pddl4j.problem.numeric.NumericAssignment;
import fr.uga.pddl4j.problem.numeric.NumericComparator;
import fr.uga.pddl4j.problem.numeric.NumericConstraint;
import fr.uga.pddl4j.problem.numeric.NumericFluent;
import fr.uga.pddl4j.problem.numeric.NumericVariable;
import fr.uga.pddl4j.problem.operator.AbstractInstantiatedOperator;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Condition;
import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.problem.operator.Constants;
import fr.uga.pddl4j.problem.operator.DefaultOrderingConstraintNetwork;
import fr.uga.pddl4j.problem.operator.DurativeAction;
import fr.uga.pddl4j.problem.operator.DurativeMethod;
import fr.uga.pddl4j.problem.operator.Effect;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.IntMethod;
import fr.uga.pddl4j.problem.operator.IntTaskNetwork;
import fr.uga.pddl4j.problem.operator.Method;
import fr.uga.pddl4j.problem.operator.Operator;
import fr.uga.pddl4j.problem.operator.TaskNetwork;
import fr.uga.pddl4j.problem.time.TemporalCondition;
import fr.uga.pddl4j.problem.time.TemporalConditionalEffect;
import fr.uga.pddl4j.problem.time.TemporalEffect;
import fr.uga.pddl4j.problem.time.TemporalOrderingConstraintNetwork;
import fr.uga.pddl4j.problem.time.TemporalRelation;
import fr.uga.pddl4j.util.BitSet;
import fr.uga.pddl4j.util.BitVector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class contains all the methods needed to post instantiation process of a planning problem. In particular, this
 * class contains the methods necessary to compactly encode the problem using compact bit set representation.
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
     * The list of instantiated durative actions encoded into bit sets.
     */
    private List<DurativeAction> durativeActions;

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
     * The table of the relevant fluents in the form of {@code Expression}.
     */
    private List<Expression<Integer>> intExpFluents;

    /**
     * The map used to encode fluents into bit set representation.
     */
    private Map<Expression<Integer>, Integer> mapOfFluentIndex;

    /**
     * The table of the relevant numeric fluent in the form of {@code Expression}.
     */
    private List<Expression<Integer>> intExpNumericFluents;

    /**
     * The map used to encode numeric fluents into bit set representation.
     */
    private Map<Expression<Integer>, Integer> mapOfNumericFluentIndex;

    /**
     * Returns the map used to encode the task into integer.
     */
    private Map<Expression<Integer>, Integer> mapOfTasksIndex;

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
     * The list of instantiated durative methods encoded into bit sets.
     */
    private List<DurativeMethod> durativeMethods;

    /**
     * The list of relevant tasks of the problem.
     */
    private List<Task> tasks;

    /**
     * Creates a new problem from a domain and problem.
     *
     * @param problem the problem.
     */
    public FinalizedProblem(final DefaultParsedProblem problem) {
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
     * Returns the list of instantiated durative actions of the problem.
     *
     * @return the list of instantiated durative actions of the problem.
     */
    public final List<DurativeAction> getDurativeActions() {
        return this.durativeActions;
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
     * Returns the list of relevant fluents of the problem in the form of <code>Expression</code>.
     *
     * @return the list of relevant fluents of the problem in the form of <code>Expression</code>.
     */
    private List<Expression<Integer>> getIntExpFluents() {
        return this.intExpFluents;
    }

    /**
     * Returns the map used to encode fluents into bit set representation.
     *
     *
     * @return the map used to encode fluents into bit set representation.
     */
    private Map<Expression<Integer>, Integer> getMapOfFluentIndex() {
        return this.mapOfFluentIndex;
    }

    /**
     * Returns the list of relevant numeric fluents of the problem in the form of <code>Expression</code>.
     *
     * @return the list of relevant numericfluents of the problem in the form of <code>Expression</code>.
     */
    private List<Expression<Integer>> getIntExpNumericFluents() {
        return this.intExpNumericFluents;
    }

    /**
     * Returns the map used to encode numeric fluents into bit set representation.
     *
     * @return the map used to encode numeric fluents into bit set representation.
     */
    private Map<Expression<Integer>, Integer> getMapOfNumericFluentIndex() {
        return this.mapOfNumericFluentIndex;
    }

    /**
     * Returns the map used to encode the task into integer.
     *
     * @return the map used to encode the task into integer.
     */
    private Map<Expression<Integer>, Integer> getMapOfTasksIndex() {
        return this.mapOfTasksIndex;
    }

    /**
     * Returns the relevant operators for the tasks of the problem. The method return {@code null} if the problem is
     * not hierarchical.
     * <p>
     *     Warning a task may have many resolvers event primitives tasks.
     * </p>
     * The resolvers returned are indexes of operators. To get the list of resolvers of a specific task {@code t} just
     * write:
     * <pre>{@code
     *     List<Integer> resolvers = problem.getTaskResolvers().get(t)
     * }</pre>
     * Two case must be considered.
     * <ul>
     * <li> If the task {@code t} is primitive, i.e., {@code problem.getTask(t).isPrimtive()}
     * returns true, the list of resolvers contains either indexes of actions either indexes of durative actions.
     * If the index is positive the index represents an action. To get the corresponding action just use
     * {@code problem.getActions(index)}. If the index is negative the index represents a durative action.
     * To get the corresponding durative action just use {@code problem.getDurativeActions(-index - 1)}.</li>
     * <li>Symmetrically, if the task {@code t} is compound, i.e., {@code problem.getTask(t).isCompound()}
     * returns true, the list of resolvers contains either indexes of method either indexes of durative methods.
     * If the index is positive the index represents a method. To get the corresponding method just use
     * {@code problem.getMethods(index)}. If the index is negative the index represents a durative method.
     * To get the corresponding durative method just use {@code problem.getDurativeMethods(-index - 1)}.</li>
     * </ul>
     * @return the relevant operators for a task.
     */
    public List<List<Integer>> getTaskResolvers() {
        return taskResolvers;
    }

    /**
     * Returns the initial task network of the problem.
     *
     * @return the initial task network of the problem.
     */
    public TaskNetwork getInitialTaskNetwork() {
        return initialTaskNetwork;
    }

    /**
     * The list of relevant tasks of the problem.
     *
     * @return the list of relevant tasks of the problem.
     */
    public List<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Returns the list of instantiated methods of the problem.
     *
     * @return the list of instantiated methods of the problem.
     */
    public List<Method> getMethods() {
        return this.methods;
    }

    /**
     * Returns the list of instantiated durative methods of the problem.
     *
     * @return the list of instantiated durative methods of the problem.
     */
    public final List<DurativeMethod> getDurativeMethods() {
        return this.durativeMethods;
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
        final Set<Expression<Integer>> fluents = new LinkedHashSet<>(10000);
        // Add relevant fluents from actions
        for (IntAction a : this.getIntActions()) {
            extractRelevantFluents(a.getPreconditions(), fluents);
            extractRelevantFluents(a.getEffects(), fluents);
        }
        // Add relevant fluents from the initial state
        for (Expression<Integer> p : this.getIntInitialState()) {
            Inertia inertia = this.getGroundInertia().get(p);
            if (inertia == null) {
                inertia = Inertia.INERTIA;
            }
            if (this.getIntInitialState().contains(p) && !inertia.equals(Inertia.NEGATIVE)) {
                fluents.add(p);
            }
        }
        // Add relevant fluents from the goal
        //for (Expression<Integer> p : this.getIntGoal().getChildren()) {
        //    fluents.add(p);
        //}

        this.intExpFluents = new ArrayList<>(fluents.size());
        this.fluents = new ArrayList<>(fluents.size());
        for (Expression<Integer> exp : fluents) {
            final Expression<Integer> relevant = new Expression<>(exp);
            this.intExpFluents.add(relevant);
            int[] arguments = new int[exp.getArguments().size()];
            for (int i = 0; i < exp.getArguments().size(); i++) {
                arguments[i] = exp.getArguments().get(i).getValue();
            }
            this.fluents.add(new Fluent(exp.getSymbol().getValue(), arguments));
        }
    }

    /**
     * Extracts the relevant fluents from a specified expression. A fluent is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fluent and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fact and not a positive ground inertia.</li>
     * </ul>
     *
     * @param exp   the expression.
     * @param fluents the set of relevant fluents.
     */
    protected void extractRelevantFluents(final Expression<Integer> exp, final Set<Expression<Integer>> fluents) {
        switch (exp.getConnector()) {
            case ATOM:
                Inertia inertia = this.getGroundInertia().get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                if ((this.getIntInitialState().contains(exp) && !inertia.equals(Inertia.NEGATIVE))
                    || (!this.getIntInitialState().contains(exp) && !inertia.equals(Inertia.POSITIVE))) {
                    fluents.add(exp);
                }
                break;
            case FN_HEAD:
                break;
            case EQUAL_ATOM:
                break;
            case AND:
            case OR:
                for (Expression<Integer> e : exp.getChildren()) {
                    this.extractRelevantFluents(e, fluents);
                }
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case UMINUS:
            case ALWAYS_CONSTRAINT:
            case OVER_ALL:
            case SOMETIME_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case NOT:
                this.extractRelevantFluents(exp.getChildren().get(0), fluents);
                break;
            case WHEN:
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
                extractRelevantFluents(exp.getChildren().get(0), fluents);
                extractRelevantFluents(exp.getChildren().get(1), fluents);
                break;
            case F_EXP_T:
            case F_EXP:
                if (!exp.getChildren().isEmpty()) {
                    extractRelevantFluents(exp.getChildren().get(0), fluents);
                }
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
            case HOLD_DURING_CONSTRAINT:
                extractRelevantFluents(exp.getChildren().get(0), fluents);
                extractRelevantFluents(exp.getChildren().get(1), fluents);
                extractRelevantFluents(exp.getChildren().get(3), fluents);
                break;
            case FN_ATOM:
            case NUMBER:
            case TIMED_LITERAL:
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
        final Set<Expression<Integer>> fluents = new LinkedHashSet<>(100);
        for (IntAction a : this.getIntActions()) {
            if (a.isDurative()) {
                this.extractRelevantNumericFluents(a.getDuration(), fluents);
            }
            this.extractRelevantNumericFluents(a.getPreconditions(), fluents);
            this.extractRelevantNumericFluents(a.getEffects(), fluents);
        }
        this.intExpNumericFluents = new ArrayList<>(fluents.size());
        this.numericFluents = new ArrayList<>(fluents.size());
        for (Expression<Integer> exp : fluents) {
            final Expression<Integer> relevant = new Expression<>(exp);
            this.intExpNumericFluents.add(relevant);
            int[] arguments = new int[exp.getArguments().size()];
            for (int i = 0; i < exp.getArguments().size(); i++) {
                arguments[i] = exp.getArguments().get(i).getValue();
            }
            this.numericFluents.add(new NumericFluent(exp.getSymbol().getValue(), arguments));
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
    private void extractRelevantNumericFluents(final Expression<Integer> exp, final Set<Expression<Integer>> fluents) {
        switch (exp.getConnector()) {
            case FN_HEAD:
                fluents.add(exp);
                break;
            case AND:
            case OR:
                for (Expression<Integer> e : exp.getChildren()) {
                    this.extractRelevantNumericFluents(e, fluents);
                }
                break;
            case UMINUS:
            case NOT:
                this.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                break;
            case WHEN:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case MULTIPLICATION:
            case DIVISION:
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
            case AT_START:
            case AT_END:
            case OVER_ALL:
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
                throw new UnexpectedExpressionException(exp.getConnector().toString());

        }
    }

    /**
     * Initializes the map that store for each relevant fluent its index to speedup the bit set encoding of the action.
     */
    protected void initOfMapFluentIndex() {
        // Create a map of the relevant fluents with their index to speedup the bit set encoding of the actions
        this.mapOfFluentIndex = new LinkedHashMap<>(this.getIntExpFluents().size());
        int index = 0;
        for (Expression<Integer> fluent : this.getIntExpFluents()) {
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
        for (Expression<Integer> fluent : this.getIntExpNumericFluents()) {
            this.mapOfNumericFluentIndex.put(fluent, index);
        }
    }

    /**
     * Encode a list of specified actions into <code>BitSet</code> representation. Several specified
     * map is used to speed-up the search by mapping the an expression to this index.
     */
    protected void finalizeActions()  throws UnexpectedExpressionException {
        this.actions = new ArrayList<>(this.getIntActions().size());
        this.durativeActions = new ArrayList<>(this.getIntActions().size());
        // The index of the primitive task is index of the action
        // This index is used to update the resolvers of the primitive task in the case of HTN problem.
        int task = 0;
        for (IntAction action : this.getIntActions()) {
            // We split action precondition to have only actions with disjunctive precondition
            List<IntAction> normalizedActionList = this.normalizeAction(action);
            for (IntAction normalizedAction : normalizedActionList) {
                if (!normalizedAction.isDurative()) {
                    // update the resolvers of the primitive task only for hierarchical problem
                    if (this.taskResolvers != null) {
                        this.getTaskResolvers().get(task).add(this.actions.size());
                    }
                    this.actions.add(this.finalizeAction(normalizedAction));
                } else {
                    // update the resolvers of the primitive task only for hierarchical problem
                    if (this.taskResolvers != null) {
                        this.getTaskResolvers().get(task).add(-this.durativeActions.size() - 1);
                    }
                    this.durativeActions.add(this.finalizeDurativeAction(normalizedAction));
                }
            }
            task++;
        }
    }

    /**
     * Encode an specified <code>Expression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @return the expression in bit set representation.
     */
    private Effect finalizeEffect(final Expression<Integer> exp) throws UnexpectedExpressionException {
        final Effect effect = new Effect();
        switch (exp.getConnector()) {
            case ATOM:
                Integer index = this.mapOfFluentIndex.get(exp);
                if (index != null) {
                    effect.getPositiveFluents().set(index);
                }
                break;
            case NOT:
                index = this.mapOfFluentIndex.get(exp.getChildren().get(0));
                if (index != null) {
                    effect.getNegativeFluents().set(index);
                }
                break;
            case AND:
                final List<Expression<Integer>> children = exp.getChildren();
                for (Expression<Integer> ei : children) {
                    switch (ei.getConnector()) {
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
                            throw new UnexpectedExpressionException(ei.getConnector().toString());
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
                throw new UnexpectedExpressionException(exp.getConnector().toString());
        }
        return effect;
    }


    /**
     * Encode an specified <code>Expression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @return the expression in bit set representation.
     */
    private TemporalEffect finalizeTimeEffect(final Expression<Integer> exp) throws UnexpectedExpressionException {
        final TemporalEffect temporalEffect = new TemporalEffect();
        switch (exp.getConnector()) {
            case AT_START:
            case AT_END:
            case OVER_ALL:
                Effect effect =  null;
                if (exp.getConnector().equals(Connector.AT_START)) {
                    effect = temporalEffect.getAtStartEffect();
                } else if (exp.getConnector().equals(Connector.AT_END)) {
                    effect = temporalEffect.getAtEndEffect();
                } else {
                    effect = temporalEffect.getOverallEffect();
                }
                Expression<Integer> sub = exp.getChildren().get(0);
                switch (sub.getConnector()) {
                    case ATOM:
                        effect.getPositiveFluents().set(this.getMapOfFluentIndex().get(sub));
                        break;
                    case NOT:
                        effect.getNegativeFluents().set(this.getMapOfFluentIndex().get(sub.getChildren().get(0)));
                        break;
                    case ASSIGN:
                    case INCREASE:
                    case DECREASE:
                    case SCALE_UP:
                    case SCALE_DOWN:
                        NumericAssignment assignment = this.finalizeNumericAssignment(sub);
                        effect.addNumericAssignment(assignment);
                        break;
                    default:
                        throw new UnexpectedExpressionException(sub.getConnector().toString());
                }
                break;
            case AND:
                for (Expression<Integer> e : exp.getChildren()) {
                    TemporalEffect te = this.finalizeTimeEffect(e);
                    temporalEffect.getAtStartEffect().getPositiveFluents()
                        .or(te.getAtStartEffect().getPositiveFluents());
                    temporalEffect.getAtStartEffect().getNegativeFluents()
                        .or(te.getAtStartEffect().getNegativeFluents());
                    temporalEffect.getAtStartEffect().getNumericAssignments()
                        .addAll(te.getAtStartEffect().getNumericAssignments());
                    temporalEffect.getAtEndEffect().getPositiveFluents()
                        .or(te.getAtEndEffect().getPositiveFluents());
                    temporalEffect.getAtEndEffect().getNegativeFluents()
                        .or(te.getAtEndEffect().getNegativeFluents());
                    temporalEffect.getAtEndEffect().getNumericAssignments()
                        .addAll(te.getAtEndEffect().getNumericAssignments());
                    temporalEffect.getOverallEffect().getPositiveFluents()
                        .or(te.getOverallEffect().getPositiveFluents());
                    temporalEffect.getOverallEffect().getNegativeFluents()
                        .or(te.getOverallEffect().getNegativeFluents());
                    temporalEffect.getOverallEffect().getNumericAssignments()
                        .addAll(te.getOverallEffect().getNumericAssignments());
                }
                break;
            case TRUE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnector().toString());
        }
        return temporalEffect;
    }


    /**
     * Encode an specified <code>Expression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @return the expression in bit set representation.
     */
    private List<TemporalConditionalEffect> finalizeTimeConditionalEffect(final Expression<Integer> exp)
            throws UnexpectedExpressionException {
        final List<TemporalConditionalEffect> effects = new ArrayList<>();
        switch (exp.getConnector()) {
            case WHEN:
                TemporalConditionalEffect tce = new TemporalConditionalEffect();
                tce.setCondition(this.finalizeTimeCondition(exp.getChildren().get(0)));
                tce.setEffect(this.finalizeTimeEffect(exp.getChildren().get(1)));
                effects.add(tce);
                break;
            case AT_START:
            case AT_END:
            case OVER_ALL:
                tce = new TemporalConditionalEffect();
                tce.setEffect(this.finalizeTimeEffect(exp));
                effects.add(tce);
                break;
            case AND:
                for (Expression<Integer> e : exp.getChildren()) {
                    effects.addAll(this.finalizeTimeConditionalEffect(e));
                }
                break;
            case TRUE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnector().toString());
        }
        final TemporalConditionalEffect utce = new TemporalConditionalEffect();
        Iterator<TemporalConditionalEffect> it = effects.iterator();
        boolean exist = false;
        while (it.hasNext()) {
            TemporalConditionalEffect tcei = it.next();
            if (tcei.getCondition().isEmpty()) {
                utce.getEffect().getAtStartEffect().getPositiveFluents()
                    .or(tcei.getEffect().getAtStartEffect().getPositiveFluents());
                utce.getEffect().getAtStartEffect().getNegativeFluents()
                    .or(tcei.getEffect().getAtStartEffect().getNegativeFluents());
                utce.getEffect().getAtStartEffect().getNumericAssignments()
                    .addAll(tcei.getEffect().getAtStartEffect().getNumericAssignments());
                utce.getEffect().getAtEndEffect().getPositiveFluents()
                    .or(tcei.getEffect().getAtEndEffect().getPositiveFluents());
                utce.getEffect().getAtEndEffect().getNegativeFluents()
                    .or(tcei.getEffect().getAtEndEffect().getNegativeFluents());
                utce.getEffect().getAtEndEffect().getNumericAssignments()
                    .addAll(tcei.getEffect().getAtEndEffect().getNumericAssignments());
                utce.getEffect().getOverallEffect().getPositiveFluents()
                    .or(tcei.getEffect().getOverallEffect().getPositiveFluents());
                utce.getEffect().getOverallEffect().getNegativeFluents()
                    .or(tcei.getEffect().getOverallEffect().getNegativeFluents());
                utce.getEffect().getOverallEffect().getNumericAssignments()
                    .addAll(tcei.getEffect().getOverallEffect().getNumericAssignments());
                it.remove();
                exist = true;
            }
        }
        if (exist) {
            effects.add(utce);
        }
        return effects;
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
        action.getEffects().toCNF();
        action.getEffects().simplify();
        final Expression<Integer> precond = new Expression<>(action.getPreconditions());
        precond.toDNF();
        if (precond.getChildren().size() > 1) {
            for (final Expression<Integer> ei : precond.getChildren()) {
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
                    newAction.setDuration(new Expression<>(action.getDuration()));
                }
                newAction.setPreconditions(ei);

                newAction.setEffects(new Expression<>(action.getEffects()));
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
    private NumericAssignment finalizeNumericAssignment(final Expression<Integer> exp) {

        final NumericVariable fluent = new NumericVariable(this.mapOfNumericFluentIndex.get(exp.getChildren().get(0)));
        final ArithmeticExpression arithmeticExpression = this.finalizeArithmeticExpression(exp.getChildren().get(1));
        NumericAssignment assignment = null;
        switch (exp.getConnector()) {
            case ASSIGN:
                assignment = new NumericAssignment(AssignmentOperator.ASSIGN, fluent, arithmeticExpression);
                break;
            case INCREASE:
                assignment = new NumericAssignment(AssignmentOperator.INCREASE, fluent, arithmeticExpression);
                break;
            case DECREASE:
                assignment = new NumericAssignment(AssignmentOperator.DECREASE, fluent, arithmeticExpression);
                break;
            case SCALE_UP:
                assignment = new NumericAssignment(AssignmentOperator.SCALE_UP, fluent, arithmeticExpression);
                break;
            case SCALE_DOWN:
                assignment = new NumericAssignment(AssignmentOperator.SCALE_DOWN, fluent, arithmeticExpression);
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnector().toString());
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
        final LinkedList<Expression<Integer>> effects = new LinkedList<>();
        if (action.getEffects().getConnector().equals(Connector.ATOM)) {
            effects.add(action.getEffects());
        } else {
            effects.addAll(action.getEffects().getChildren());
        }

        //System.out.println(this.toString(action));
        final ConditionalEffect unCondEffects = new ConditionalEffect();
        boolean hasUnConditionalEffects = false;
        while (!effects.isEmpty()) { //for (Expression ei : effects) {
            Expression<Integer> ei = effects.poll();
            final Connector connective = ei.getConnector();
            final List<Expression<Integer>> children = ei.getChildren();
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
     * Encodes a specified action.
     *
     * @param action the action to be encoded. The precondition of the action must be a simple conjunction of atomic
     *               formulas
     * @return the action encoded.
     */
    private DurativeAction finalizeDurativeAction(final IntAction action) {
        final int arity = action.arity();
        final DurativeAction encoded = new DurativeAction(action.getName(), arity);

        // Initialize the parameters of the action
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, action.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, action.getTypeOfParameters(i));
        }

        encoded.setDuration(this.finalizeDuration(action.getDuration()));
        encoded.setPrecondition(this.finalizeTimeCondition(action.getPreconditions()));
        encoded.setConditionalEffects(this.finalizeTimeConditionalEffect(action.getEffects()));

        return encoded;
    }

    /**
     * Encode a specified goal in a disjunction of <code>BitExp</code>. The specified
     * map is used to speed-up the search by mapping an expression to this index.
     * The goal of the problem is set to null if it can be simplified to false.
     */
    protected void finalizeGoal() {

        if (this.getIntGoal().getConnector().equals(Connector.FALSE)) {
            this.goal = null;
        } else {
            this.getIntGoal().toDNF();
            List<Goal> goals = new ArrayList<>(this.getIntGoal().getChildren().size());
            for (Expression<Integer> exp : this.getIntGoal().getChildren()) {
                if (exp.getConnector().equals(Connector.ATOM)) {
                    Expression<Integer> and = new Expression<>(Connector.AND);
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
                Expression<Integer> dummyGoal = new Expression<>(Connector.ATOM);
                dummyGoal.setSymbol(new Symbol<>(SymbolType.PREDICATE, dummyPredicateIndex));
                dummyGoal.setArguments(new ArrayList<>(0));
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
     * Encode an specified <code>Expression</code> that represents a condition in its <code>BitExp</code>
     * representation. The map of fluent index is used to speed-up the encoding.
     *
     * @param exp the <code>Expression</code>.
     * @return the condition encoded.
     */
    protected Condition finalizeCondition(final Expression<Integer> exp) throws UnexpectedExpressionException {
        final Condition condition = new Condition();
        switch (exp.getConnector()) {
            case ATOM:
                condition.getPositiveFluents().set(this.getMapOfFluentIndex().get(exp));
                break;
            case NOT:
                condition.getNegativeFluents().set(this.getMapOfFluentIndex().get(exp.getChildren().get(0)));
                break;
            case AND:
                for (Expression<Integer> e : exp.getChildren()) {
                    Condition ce = this.finalizeCondition(e);
                    condition.getPositiveFluents().or(ce.getPositiveFluents());
                    condition.getNegativeFluents().or(ce.getNegativeFluents());
                    condition.getNumericConstraints().addAll(ce.getNumericConstraints());
                }
                break;
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case EQUAL_COMPARISON:
                condition.getNumericConstraints().add(this.encodeNumericConstraint(exp));
                break;
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnector().toString());
        }
        return condition;
    }

    /**
     * Encode an specified <code>Expression</code> that represents a condition in its <code>BitExp</code>
     * representation. The map of fluent index is used to speed-up the encoding.
     *
     * @param exp the <code>Expression</code>.
     * @return the condition encoded.
     */
    protected TemporalCondition finalizeTimeCondition(final Expression<Integer> exp)
            throws UnexpectedExpressionException {
        final TemporalCondition temporalCondition = new TemporalCondition();
        switch (exp.getConnector()) {
            case AT_START:
            case AT_END:
            case OVER_ALL:
                Condition condition = null;
                if (exp.getConnector().equals(Connector.AT_START)) {
                    condition = temporalCondition.getAtStartCondition();
                } else if (exp.getConnector().equals(Connector.AT_END)) {
                    condition = temporalCondition.getAtEndCondition();
                } else {
                    condition = temporalCondition.getOverallCondition();
                }
                Expression<Integer> sub = exp.getChildren().get(0);
                switch (sub.getConnector()) {
                    case ATOM:
                        condition.getPositiveFluents().set(this.getMapOfFluentIndex().get(sub));
                        break;
                    case NOT:
                        condition.getNegativeFluents().set(this.getMapOfFluentIndex().get(sub.getChildren().get(0)));
                        break;
                    case LESS_COMPARISON:
                    case LESS_OR_EQUAL_COMPARISON:
                    case GREATER_COMPARISON:
                    case GREATER_OR_EQUAL_COMPARISON:
                    case EQUAL_COMPARISON:
                        condition.getNumericConstraints().add(this.encodeNumericConstraint(sub));
                        break;
                    default:
                        throw new UnexpectedExpressionException(sub.getConnector().getImage());
                }
                break;
            case AND:
                for (Expression<Integer> e : exp.getChildren()) {
                    TemporalCondition ce = this.finalizeTimeCondition(e);
                    temporalCondition.getAtStartCondition().getPositiveFluents()
                        .or(ce.getAtStartCondition().getPositiveFluents());
                    temporalCondition.getAtStartCondition().getNegativeFluents()
                        .or(ce.getAtStartCondition().getNegativeFluents());
                    temporalCondition.getAtStartCondition().getNumericConstraints()
                        .addAll(ce.getAtStartCondition().getNumericConstraints());
                    temporalCondition.getAtEndCondition().getPositiveFluents()
                        .or(ce.getAtEndCondition().getPositiveFluents());
                    temporalCondition.getAtEndCondition().getNegativeFluents()
                        .or(ce.getAtEndCondition().getNegativeFluents());
                    temporalCondition.getAtEndCondition().getNumericConstraints()
                        .addAll(ce.getAtEndCondition().getNumericConstraints());
                    temporalCondition.getOverallCondition().getPositiveFluents()
                        .or(ce.getOverallCondition().getPositiveFluents());
                    temporalCondition.getOverallCondition().getNegativeFluents()
                        .or(ce.getOverallCondition().getNegativeFluents());
                    temporalCondition.getOverallCondition().getNumericConstraints()
                        .addAll(ce.getOverallCondition().getNumericConstraints());
                }
                break;
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(this.toString(exp));
        }
        return temporalCondition;
    }

    /**
     * Encode an specified <code>Expression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>Expression</code>.
     * @return the expression in bit set representation.
     */
    private List<NumericConstraint> finalizeNumericConstraints(final Expression<Integer> exp)
        throws UnexpectedExpressionException {

        final List<NumericConstraint> constraints = new ArrayList<>();
        switch (exp.getConnector()) {
            case AND:
                for (Expression<Integer> e : exp.getChildren()) {
                    constraints.addAll(this.finalizeNumericConstraints(e));
                }
                break;
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case EQUAL_COMPARISON:
                constraints.add(this.encodeNumericConstraint(exp));
                break;
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnector().toString());
        }
        return constraints;
    }

    /**
     * Encodes a numeric constraint.
     *
     * @param exp the exp to encode.
     */
    private NumericConstraint encodeNumericConstraint(final Expression<Integer> exp) {

        ArithmeticExpression left = this.finalizeArithmeticExpression(exp.getChildren().get(0));
        ArithmeticExpression right = this.finalizeArithmeticExpression(exp.getChildren().get(1));
        NumericConstraint constraint;
        switch (exp.getConnector()) {
            case EQUAL_COMPARISON:
                constraint = new NumericConstraint(NumericComparator.EQUAL, left, right);
                break;
            case LESS_COMPARISON:
                constraint = new NumericConstraint(NumericComparator.LESS, left, right);
                break;
            case LESS_OR_EQUAL_COMPARISON:
                constraint = new NumericConstraint(NumericComparator.LESS_OR_EQUAL, left, right);
                break;
            case GREATER_COMPARISON:
                constraint = new NumericConstraint(NumericComparator.GREATER, left, right);
                break;
            case GREATER_OR_EQUAL_COMPARISON:
                constraint = new NumericConstraint(NumericComparator.GREATER_OR_EQUAL, left, right);
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnector().toString());
        }
        return constraint;
    }

    /**
     * Encodes the duration of an action or a method.
     *
     * @param exp the expression to encode.
     */
    private NumericVariable finalizeDuration(final Expression<Integer> exp) {
        this.toString(exp);
        NumericVariable duration = new NumericVariable(NumericVariable.DURATION);
        if (exp.getConnector().equals(Connector.EQUAL_COMPARISON)
                && exp.getChildren().size() == 2
                && exp.getChildren().get(0).getConnector().equals(Connector.TIME_VAR)
                && exp.getChildren().get(1).getConnector().equals(Connector.NUMBER)) {
            duration.setValue(exp.getChildren().get(1).getValue());
        } else {
            throw new UnexpectedExpressionException(exp.getConnector().toString());
        }
        return duration;
    }

    /**
     * Encodes an arithmetic expression.
     *
     * @param exp the expression to encode.
     */
    private ArithmeticExpression finalizeArithmeticExpression(final Expression<Integer> exp) {
        ArithmeticExpression arithmeticExpression;
        ArithmeticExpression left;
        ArithmeticExpression right;
        switch (exp.getConnector()) {
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
            case DIVISION:
                left = this.finalizeArithmeticExpression(exp.getChildren().get(0));
                right = this.finalizeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.DIV, left, right);
                break;
            case MULTIPLICATION:
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
                throw new UnexpectedExpressionException(exp.getConnector().toString());
        }
        return arithmeticExpression;
    }

    /**
     * Encode a specified initial state in it bit compact representation. The map of the fluent index is used to speedup
     * the encoding.
     */
    protected void finalizeInitialState() {
        this.initialState = new InitialState();
        for (final Expression<Integer> fact : this.getIntInitialState()) {
            switch (fact.getConnector()) {
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
        for (final Expression<Integer> fluent : this.getIntInitFunctions()) {
            Integer index = this.mapOfNumericFluentIndex.get(fluent);
            if (index != null) {
                Double value = this.getIntInitFunctionCost().get(fluent);
                NumericVariable var = new NumericVariable(index, value);
                this.initialState.addNumericFluent(var);
            }
        }
        /*for (Map.Entry<Expression<Integer>, Integer> e : this.mapOfNumericFluentIndex.entrySet()) {
            int index = e.getValue();
            Double value = this.getIntInitFunctionCost().get(e.getKey());
            NumericVariable fluent = new NumericVariable(index, value);
            this.initialState.addNumericFluent(fluent);
        }*/
    }


    /**
     * Returns a string representation of a specified operator.
     *
     * @param action     the action.
     * @return a string representation of the specified operator.
     */
    public final String toString(final Action action) {
        StringBuilder str = new StringBuilder();
        str.append("Action ");
        str.append(action.getName());
        str.append("\nInstantiations:\n");
        str.append(this.toStringInstantiations(action));
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
     * Returns a string representation of a specified operator.
     *
     * @param action     the action.
     * @return a string representation of the specified operator.
     */
    public final String toString(final DurativeAction action) {
        StringBuilder str = new StringBuilder();
        str.append("Durative Action ");
        str.append(action.getName());
        str.append("\nInstantiations:\n");
        str.append(this.toStringInstantiations(action));
        str.append("Duration:\n");
        str.append(this.toString(action.getDuration()));
        str.append("\nDuration constraints:");
        if (action.getDurationConstraints().isEmpty()) {
            str.append("()\n");
        } else {
            for (NumericConstraint constraints : action.getDurationConstraints()) {
                str.append("  ");
                str.append(this.toString(constraints));
                str.append("\n");
            }
        }
        str.append("Condition:\n");
        str.append(this.toString(action.getPrecondition()));
        str.append("\n");
        str.append("Effects:\n");
        if (action.getConditionalEffects().isEmpty()) {
            str.append("(and )");
        } else {
            for (TemporalConditionalEffect effect : action.getConditionalEffects()) {
                str.append(this.toString(effect));
                str.append("\n");
            }
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
        if (state.isEmpty()) {
            return "()";
        }
        boolean printed = false;
        final StringBuilder str = new StringBuilder("(and ");

        final BitSet positive = state.getPositiveFluents();
        for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
            str.append(this.toString(this.getFluents().get(j)));
            str.append("\n  ");
            printed = true;
        }
        final BitSet negative = state.getNegativeFluents();

        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append("(not ");
            str.append(this.toString(this.getFluents().get(i)));
            str.append("\n              ");
            printed = true;
        }
        if (printed) {
            str.setLength(str.length() - 3);
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a temporal condition.
     *
     * @param condition the condition.
     * @return a string representation of the specified temporal condition.
     */
    public final String toString(final TemporalCondition condition) {
        final StringBuilder str = new StringBuilder("(and\n");
        final Condition atStart = condition.getAtStartCondition();
        if (!atStart.isEmpty()) {
            str.append(" (at start ");
            str.append(this.toString(atStart));
            str.append(")\n");
        }
        final Condition atEnd = condition.getAtEndCondition();
        if (!atEnd.isEmpty()) {
            str.append(" (at end ");
            str.append(this.toString(atEnd));
            str.append(")\n");
        }
        final Condition overall = condition.getOverallCondition();
        if (!overall.isEmpty()) {
            str.append(" (overall ");
            str.append(this.toString(overall));
            str.append(")\n");
        }
        str.append(")");
        return str.toString();

    }

    /**
     * Returns a string representation of a conditional effect.
     *
     * @param effect  the conditional effect.
     * @return a string representation of the specified condition effect.
     */
    public final String toString(final ConditionalEffect effect) {
        StringBuilder str = new StringBuilder();
        if (effect.getCondition().isEmpty()) {
            str.append(this.toString(effect.getEffect()));
        } else {
            str.append("(when ");
            str.append(this.toString(effect.getCondition()));
            str.append("\n");
            str.append(this.toString(effect.getEffect()));
            str.append(")");
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a temporal conditional effect.
     *
     * @param effect  the temporal conditional effect.
     * @return a string representation of the specified temporal condition effect.
     */
    public final String toString(final TemporalConditionalEffect effect) {
        StringBuilder str = new StringBuilder();
        if (effect.getCondition().isEmpty()) {
            str.append(this.toString(effect.getEffect()));
        } else {
            str.append("(when ");
            str.append(this.toString(effect.getCondition()));
            str.append("\n");
            str.append(this.toString(effect.getEffect()));
            str.append(")");
        }
        return str.toString();
    }

    /**
     * Returns a string representation of the effect of an action.
     *
     * @param effect the effect.
     * @return a string representation of the effect.
     */
    public final String toString(final Effect effect) {
        boolean printed = false;
        final StringBuilder str = new StringBuilder("(and ");
        final BitSet positive = effect.getPositiveFluents();
        for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
            str.append(this.toString(this.getFluents().get(j)));
            str.append("\n  ");
            printed = true;
        }
        final BitSet negative = effect.getNegativeFluents();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append("(not ");
            str.append(this.toString(this.getFluents().get(i)));
            str.append("\n  ");
            printed = true;
        }
        for (NumericAssignment assignment : effect.getNumericAssignments()) {
            str.append(this.toString(assignment));
            str.append("\n  ");
            printed = true;
        }
        if (printed) {
            str.setLength(str.length() - 3);
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a temporal effect.
     *
     * @param effect the effect.
     * @return a string representation of the effect.
     */
    public final String toString(final TemporalEffect effect) {
        final StringBuilder str = new StringBuilder("(and\n");
        if (!effect.getAtStartEffect().isEmpty()) {
            str.append(" (at start ");
            str.append(this.toString(effect.getAtStartEffect()));
            str.append(")\n");
        }
        if (!effect.getAtEndEffect().isEmpty()) {
            str.append(" (at end ");
            str.append(this.toString(effect.getAtEndEffect()));
            str.append(")\n");
        }
        if (!effect.getOverallEffect().isEmpty()) {
            str.append(" (overall ");
            str.append(this.toString(effect.getOverallEffect()));
            str.append(")\n");
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a numeric assignment.
     *
     * @param assignment the assignment.
     * @return a string representation of a numeric assignment.
     */
    public final String toString(final NumericAssignment assignment) {
        final StringBuilder str = new StringBuilder();
        final ArithmeticExpression left = assignment.getLeftExpression();
        final ArithmeticExpression right = assignment.getRightExpression();
        str.append("(");
        str.append(assignment.getOperator().getImage());
        str.append(" ");
        str.append(this.toString(left));
        str.append(" ");
        str.append(this.toString(right));
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
        str.append("(= ");
        if (variable.getNumericFluent() == NumericVariable.DURATION) {
            str.append("?duration");
        } else {
            str.append(this.toString(this.getNumericFluents().get(variable.getNumericFluent())));
        }
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
        str.append("\nInstantiations:\n");
        str.append(this.toStringInstantiations(method));
        str.append("Task: " + this.toString(this.getTasks().get(method.getTask())) + "\n");
        str.append("Preconditions:\n");
        str.append(this.toString(method.getPrecondition()));
        str.append("\n");
        str.append("Ordering constraints:\n");
        str.append(method.getOrderingConstraints().toString());
        str.append("\n");
        str.append("Before constraints:\n");
        for (Integer task : method.getSubTasks()) {
            Condition condition = method.getBeforeConstraints(task);
            final BitSet positive = condition.getPositiveFluents();
            for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
                str.append("(hold-before ");
                str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task + " ");
                str.append(this.toString(this.getFluents().get(j)));
                str.append(")\n");
            }
            final BitSet negative = condition.getNegativeFluents();
            for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
                str.append(" (not (hold-before ");
                str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task + " ");
                str.append(this.toString(this.getFluents().get(i)));
                str.append("))\n");
            }
        }
        str.append("After constraints:\n");
        for (Integer task : method.getSubTasks()) {
            Condition condition = method.getAfterConstraints(task);
            final BitSet positive = condition.getPositiveFluents();
            for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
                str.append("(hold-after ");
                str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task + " ");
                str.append(this.toString(this.getFluents().get(j)));
                str.append(")\n");
            }
            final BitSet negative = condition.getNegativeFluents();
            for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
                str.append(" (not (hold-after ");
                str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task + " ");
                str.append(this.toString(this.getFluents().get(i)));
                str.append("))\n");
            }
        }
        str.append("Between constraints:\n");
        for (Integer task1 : method.getSubTasks()) {
            for (Integer task2 : method.getSubTasks()) {
                Condition condition = method.getBetweenConstraints(task1, task2);
                final BitSet positive = condition.getPositiveFluents();
                for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
                    str.append("(hold-between ");
                    str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task1 + " ");
                    str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task2 + " ");
                    str.append(this.toString(this.getFluents().get(j)));
                    str.append(")\n");
                }
                final BitSet negative = condition.getNegativeFluents();
                for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
                    str.append(" (not (hold-between ");
                    str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task1 + " ");
                    str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task2 + " ");
                    str.append(this.toString(this.getFluents().get(i)));
                    str.append("))\n");
                }
            }
        }
        return str.toString();
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param method the method.
     * @return a string representation of the specified method.
     */
    public final String toString(final DurativeMethod method) {
        final StringBuilder str = new StringBuilder();
        str.append("Method ");
        str.append(method.getName());
        str.append("\nInstantiations:\n");
        str.append(this.toStringInstantiations(method));
        str.append("Task: " + this.toString(this.getTasks().get(method.getTask())) + "\n");
        str.append("Duration constraints: ");
        for (NumericConstraint constraints : method.getDurationConstraints()) {
            str.append("  ");
            str.append(this.toString(constraints));
            str.append("\n");
        }
        str.append("Condition:\n");
        str.append(this.toString(method.getPrecondition()));
        str.append("Ordering:\n");
        str.append(method.getOrderingConstraints().toString());
        str.append("\n");
        str.append("Constraints:\n");
        str.append("Before constraints:\n");
        for (Integer task : method.getSubTasks()) {
            Condition condition = method.getBeforeConstraints(task);
            final BitSet positive = condition.getPositiveFluents();
            for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
                str.append("(hold-before ");
                str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task + " ");
                str.append(this.toString(this.getFluents().get(j)));
                str.append(")\n");
            }
            final BitSet negative = condition.getNegativeFluents();
            for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
                str.append(" (not (hold-before ");
                str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task + " ");
                str.append(this.toString(this.getFluents().get(i)));
                str.append("))\n");
            }
        }
        str.append("After constraints:\n");
        for (Integer task : method.getSubTasks()) {
            Condition condition = method.getAfterConstraints(task);
            final BitSet positive = condition.getPositiveFluents();
            for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
                str.append("(hold-after ");
                str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task + " ");
                str.append(this.toString(this.getFluents().get(j)));
                str.append(")\n");
            }
            final BitSet negative = condition.getNegativeFluents();
            for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
                str.append(" (not (hold-after ");
                str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task + " ");
                str.append(this.toString(this.getFluents().get(i)));
                str.append("))\n");
            }
        }
        str.append("Between constraints:\n");
        for (Integer task1 : method.getSubTasks()) {
            for (Integer task2 : method.getSubTasks()) {
                Condition condition = method.getBetweenConstraints(task1, task2);
                final BitSet positive = condition.getPositiveFluents();
                for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
                    str.append("(hold-between ");
                    str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task1 + " ");
                    str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task2 + " ");
                    str.append(this.toString(this.getFluents().get(j)));
                    str.append(")\n");
                }
                final BitSet negative = condition.getNegativeFluents();
                for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
                    str.append(" (not (hold-between ");
                    str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task1 + " ");
                    str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + task2 + " ");
                    str.append(this.toString(this.getFluents().get(i)));
                    str.append("))\n");
                }
            }
        }
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
                str.append(" " + Symbol.DEFAULT_TASK_ID_SYMBOL + i + ": ");
                if (tasknetwork.getTasks().get(i) != null) {
                    str.append(this.toString(this.getTasks().get(tasknetwork.getTasks().get(i))));
                } else {
                    str.append("unreachable");
                }
                str.append("\n");
            }
        }
        str.append("Ordering constraints:\n");
        str.append(tasknetwork.getOrderingConstraints().toString());
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
     * Returns a string representation of a numeric constraints.
     *
     * @param constraint the numeric constraints.
     * @return the string representation of the specified numeric constraint.
     */
    public String toString(final NumericConstraint constraint) {
        final StringBuilder str = new StringBuilder();
        final ArithmeticExpression left = constraint.getLeftExpression();
        final ArithmeticExpression right = constraint.getRightExpression();
        str.append("(");
        str.append(constraint.getComparator().getImage());
        str.append(" ");
        str.append(this.toString(left));
        str.append(" ");
        str.append(this.toString(right));
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a numeric expression.
     *
     * @param expression the numeric expression.
     * @return the string representation of the specified numeric expression.
     */
    public String toString(final ArithmeticExpression expression) {
        StringBuilder str = new StringBuilder();
        switch (expression.getType()) {
            case NUMBER:
                str.append(expression.getValue());
                break;
            case VARIABLE:
                str.append("(= ");
                if (expression.getNumericFluent() == NumericVariable.DURATION) {
                    str.append("?duration");
                } else  {
                    str.append(this.getNumericFluents().get(expression.getNumericFluent()));
                }
                str.append(" ");
                str.append(expression.getValue());
                str.append(")");
                break;
            case OPERATOR:
                switch (expression.getArithmeticOperator()) {
                    case UMINUS:
                        str.append("(");
                        str.append(expression.getArithmeticOperator().getImage());
                        str.append(" ");
                        str.append(this.toString(expression.getLeftExpression()));
                        str.append(")");
                        break;
                    case PLUS:
                    case DIV:
                    case MUL:
                    case MINUS:
                        str.append("(");
                        str.append(expression.getArithmeticOperator().getImage());
                        str.append(" ");
                        str.append(this.toString(expression.getLeftExpression()));
                        str.append(" ");
                        str.append(this.toString(expression.getRightExpression()));
                        str.append(")");
                        break;
                    default:
                        throw new UnexpectedExpressionException(expression.getArithmeticOperator().toString());
                }
                break;
            default:
                throw new UnexpectedExpressionException(expression.getType().toString());
        }

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
                str.append("**********************************\n");
                str.append("* Actions                        *\n");
                str.append("**********************************\n\n");
                if (this.getActions().isEmpty()) {
                    str.append("no actions");
                    str.append(System.lineSeparator());
                } else {
                    for (Action action : this.getActions()) {
                        str.append(this.toString(action));
                        str.append(System.lineSeparator());
                    }
                }
                break;
            case DURATIVE_ACTIONS:
                str.append("**********************************\n");
                str.append("* Durative Actions               *\n");
                str.append("**********************************\n\n");
                if (this.getDurativeActions().isEmpty()) {
                    str.append("no durative actions");
                    str.append(System.lineSeparator());
                } else {
                    for (DurativeAction action : this.getDurativeActions()) {
                        str.append(this.toString(action));
                        str.append(System.lineSeparator());
                    }
                }
                break;
            case METHODS:
                str.append("**********************************\n");
                str.append("* Methods                        *\n");
                str.append("**********************************\n\n");
                if (this.getMethods().isEmpty()) {
                    str.append("no methods");
                    str.append(System.lineSeparator());
                } else {
                    for (Method method : this.getMethods()) {
                        str.append(this.toString(method));
                        str.append(System.lineSeparator());
                    }
                }
                break;
            case DURATIVE_METHODS:
                str.append("**********************************\n");
                str.append("* Durative Methods               *\n");
                str.append("**********************************\n\n");
                if (this.getDurativeMethods().isEmpty()) {
                    str.append("no durative methods");
                    str.append(System.lineSeparator());
                } else {
                    for (DurativeMethod method : this.getDurativeMethods()) {
                        str.append(this.toString(method));
                        str.append(System.lineSeparator());
                    }
                }
                break;
            case GOAL:
                if (this.getGoal() == null) {
                    str.append("never reachable");
                } else if (this.getGoal().isEmpty()) {
                    str.append("always reachable");
                } else {
                    str.append(this.toString(this.getGoal()));
                    str.append(System.lineSeparator());
                }
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
     * Returns a string representation of a the instantiation of an operator.
     *
     * @param operator the operator.
     * @return a string representation of the instantiation of the specified operator.
     */
    private final String toStringInstantiations(final Operator operator) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < operator.arity(); i++) {
            final int index = operator.getValueOfParameter(i);
            final String type = this.getTypes().get(operator.getTypeOfParameters(i));
            if (index == -1) {
                str.append(Symbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(Symbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(this.getConstantSymbols().get(index));
                str.append(" \n");
            }
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
    public final String toShortString(final AbstractInstantiatedOperator operator) {
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
        for (Expression<Integer> task : this.getRelevantPrimitiveTasks()) {
            int[] arguments = new int[task.getArguments().size()];
            for (int i = 0; i < task.getArguments().size(); i++) {
                arguments[i] = task.getArguments().get(i).getValue();
            }
            this.tasks.add(new Task(task.getSymbol().getValue(), arguments, true));
        }
        for (Expression<Integer> task : this.getRelevantCompoundTasks()) {
            int[] arguments = new int[task.getArguments().size()];
            for (int i = 0; i < task.getArguments().size(); i++) {
                arguments[i] = task.getArguments().get(i).getValue();
            }
            this.tasks.add(new Task(task.getSymbol().getValue(), arguments, false));
        }
    }

    /**
     * Creates the map index for the task.
     */
    protected void initMapOfTaskIndex() {
        List<Expression<Integer>> tasks = new ArrayList<>();
        tasks.addAll(this.getRelevantPrimitiveTasks());
        tasks.addAll(this.getRelevantCompoundTasks());

        // Create a map of the relevant tasks with their index to speedup the bit set encoding of the methods
        this.mapOfTasksIndex = new LinkedHashMap<>(tasks.size());
        int index = 0;
        for (Expression<Integer> task : tasks) {
            this.mapOfTasksIndex.put(task, index);
            index++;
        }
    }

    /**
     * Init the resolvers for each task.
     */
    protected void initTaskResolvers() {
        final int numberOfTasks = this.getRelevantPrimitiveTasks().size() + this.getRelevantCompoundTasks().size();
        this.taskResolvers = new ArrayList<>(numberOfTasks);
        for (int i = 0; i < numberOfTasks; i++) {
            this.taskResolvers.add(new ArrayList<>());
        }
    }

    /**
     * Encode the initial task networl into its compact bit set representation.
     */
    protected void finalizeInitialTaskNetwork() {
        this.initialTaskNetwork = this.finalizeTaskNetwork(this.getIntInitialTaskNetwork());
    }

    /**
     * Encode a list of specified methods into the final compact representation. Several specified
     * maps are used to speed-up the search by mapping an expression to this index.
     */
    protected void finalizeMethods() {
        this.methods = new ArrayList<>(this.getIntMethods().size());
        this.durativeMethods = new ArrayList<>(this.getIntMethods().size());
        // For each instantiated methods
        for (IntMethod method : this.getIntMethods()) {
            // Normalize the methods, i.e., split methods to have only methods with conjunctive preconditions
            final List<IntMethod> normalizedMethods = this.normalizeMethod(method);
            // The task resolvers of current method to finalize
            final List<Integer> resolvers = this.getTaskResolvers().get(this.mapOfTasksIndex.get(method.getTask()));
            // For each normalized method we finalize it and update the resolvers of the tasks
            // If a resolver has an index including in 0 to +infinity, the resolver is a method.
            // If a resolver has an index including in -1 to -infinity, the resolver is durative method.
            for (IntMethod normalizedMethod : normalizedMethods) {
                if (!normalizedMethod.isDurative()) {
                    resolvers.add(this.methods.size());
                    this.methods.add(this.finalizeMethod(normalizedMethod));
                } else {
                    resolvers.add(-this.durativeMethods.size() - 1);
                    this.durativeMethods.add(this.finalizeDurativeMethod(normalizedMethod));
                }
            }
        }
    }

    /**
     * Encode a list of specified methods into the final compact representation.
     *
     * @param method the list of methods to encode.
     * @return the list of methods encoded into final compact representation.
     */
    private Method finalizeMethod(final IntMethod method) throws UnexpectedExpressionException {
        final int arity = method.arity();
        final Method encoded = new Method(method.getName(), arity);
        // Initialize the parameters of the method
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, method.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, method.getTypeOfParameters(i));
        }
        // Encode the task carried out by the method
        encoded.setTask(this.mapOfTasksIndex.get(method.getTask()));
        // Encode the preconditions of the method
        encoded.setPrecondition(this.finalizeCondition(method.getPreconditions()));
        // Encode the task network of the method
        encoded.setTaskNetwork(this.finalizeTaskNetwork(method.getTaskNetwork()));
        return encoded;
    }

    /**
     * Encode a list of specified methods into the final compact representation.
     *
     * @param method the list of methods to encode.
     * @return the list of methods encoded into final compact representation.
     */
    private DurativeMethod finalizeDurativeMethod(final IntMethod method) throws UnexpectedExpressionException {

        final int arity = method.arity();
        final DurativeMethod encoded = new DurativeMethod(method.getName(), arity);
        // Initialize the parameters of the method
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, method.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, method.getTypeOfParameters(i));
        }
        // Encode the duration constrains of the method
        encoded.setDuration(this.finalizeDuration(method.getDuration()));
        // Encode the task carried out by the method
        encoded.setTask(this.mapOfTasksIndex.get(method.getTask()));
        // Encode the preconditions of the method
        encoded.setPrecondition(this.finalizeTimeCondition(method.getPreconditions()));
        // Encode the task network of the method
        encoded.setTaskNetwork(this.finalizeTemporalTaskNetwork(method.getTaskNetwork()));
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
        final DefaultOrderingConstraintNetwork ordering = new DefaultOrderingConstraintNetwork(tasks.size());
        for (Expression<Integer> c : taskNetwork.getOrderingConstraints().getChildren()) {
            ordering.set(c.getChildren().get(0).getTaskID().getValue(),
                c.getChildren().get(1).getTaskID().getValue());
        }
        ordering.transitiveClosure();
        final TaskNetwork tn = new TaskNetwork(tasks, ordering);

        for (Expression<Integer> e: taskNetwork.getConstraints()) {
            if (e.getConnector().equals(Connector.HOLD_BEFORE_METHOD_CONSTRAINT)) {
                final Symbol<Integer> task = e.getChildren().get(0).getTaskID();
                final Condition before = tn.getBeforeConstraints(task.getValue());
                final Expression<Integer> se = e.getChildren().get(1);
                if (se.getConnector().equals(Connector.NOT)) {
                    before.getNegativeFluents().set(this.mapOfFluentIndex.get(se.getChildren().get(0)));
                } else {
                    before.getPositiveFluents().set(this.mapOfFluentIndex.get(se));
                }
            } else if (e.getConnector().equals(Connector.HOLD_AFTER_METHOD_CONSTRAINT)) {
                final Symbol<Integer> task = e.getChildren().get(0).getTaskID();
                final Condition after = tn.getAfterConstraints(task.getValue());
                final Expression<Integer> se = e.getChildren().get(1);
                if (se.getConnector().equals(Connector.NOT)) {
                    after.getNegativeFluents().set(this.mapOfFluentIndex.get(se.getChildren().get(0)));
                } else {
                    after.getPositiveFluents().set(this.mapOfFluentIndex.get(se));
                }
            } else if (e.getConnector().equals(Connector.HOLD_BETWEEN_METHOD_CONSTRAINT)) {
                final Symbol<Integer> task1 = e.getChildren().get(0).getTaskID();
                final Symbol<Integer> task2 = e.getChildren().get(1).getTaskID();
                final Condition between = tn.getBetweenConstraints(task1.getValue(), task2.getValue());
                final Expression<Integer> se = e.getChildren().get(2);
                if (se.getConnector().equals(Connector.NOT)) {
                    between.getNegativeFluents().set(this.mapOfFluentIndex.get(se.getChildren().get(0)));
                } else {
                    between.getPositiveFluents().set(this.mapOfFluentIndex.get(se));
                }
            }
        }

        return tn;
    }

    /**
     * Encode a specified task network.
     *
     * @param taskNetwork the tasknetwork to encode.
     * @return the task network into its final bit set representation.
     * @see TaskNetwork
     */
    private TaskNetwork finalizeTemporalTaskNetwork(IntTaskNetwork taskNetwork) {
        // We encode first the tasks
        final List<Integer> tasks = new ArrayList<Integer>();
        this.encodeTasks(taskNetwork.getTasks(), tasks);
        // We encode then the ordering constraints
        final TemporalOrderingConstraintNetwork stn = new TemporalOrderingConstraintNetwork(tasks.size());

        for (Expression<Integer> tc : taskNetwork.getOrderingConstraints().getChildren()) {
            if (tc.equals(Connector.LESS_ORDERING_CONSTRAINT)) {
                Integer task1 = tc.getChildren().get(0).getTaskID().getValue();
                Integer task2 = tc.getChildren().get(1).getTaskID().getValue();
                stn.set(task1, task2, TemporalRelation.LESS);
            } else if (tc.equals(Connector.LESS_OR_EQUAL_ORDERING_CONSTRAINT)) {
                Integer task1 = tc.getChildren().get(0).getTaskID().getValue();
                Integer task2 = tc.getChildren().get(1).getTaskID().getValue();
                stn.set(task1, task2, TemporalRelation.LEQ);
            } else if (tc.equals(Connector.GREATER_ORDERING_CONSTRAINT)) {
                Integer task1 = tc.getChildren().get(0).getTaskID().getValue();
                Integer task2 = tc.getChildren().get(1).getTaskID().getValue();
                stn.set(task1, task2, TemporalRelation.GREATER);
            } else if (tc.equals(Connector.GREATER_OR_EQUAL_ORDERING_CONSTRAINT)) {
                Integer task1 = tc.getChildren().get(0).getTaskID().getValue();
                Integer task2 = tc.getChildren().get(1).getTaskID().getValue();
                stn.set(task1, task2, TemporalRelation.GEQ);
            } else if (tc.equals(Connector.EQUAL_ORDERING_CONSTRAINT)) {
                Integer task1 = tc.getChildren().get(0).getTaskID().getValue();
                Integer task2 = tc.getChildren().get(1).getTaskID().getValue();
                stn.set(task1, task2, TemporalRelation.EQUAL);
            } else if (tc.equals(Connector.NOT)) {
                Expression<Integer> neg = tc.getChildren().get(0);
                Integer task1 = neg.getChildren().get(0).getTaskID().getValue();
                Integer task2 = neg.getChildren().get(1).getTaskID().getValue();
                stn.set(task1, task2, TemporalRelation.DIFFERENT);
            }
        }
        stn.transitiveClosure();
        final TaskNetwork tn = new TaskNetwork(tasks, stn);

        for (Expression<Integer> e: taskNetwork.getConstraints()) {
            if (e.getConnector().equals(Connector.HOLD_BEFORE_METHOD_CONSTRAINT)) {
                final Symbol<Integer> task = e.getChildren().get(0).getTaskID();
                final Condition before = tn.getBeforeConstraints(task.getValue());
                final Expression<Integer> se = e.getChildren().get(1);
                if (se.getConnector().equals(Connector.NOT)) {
                    before.getNegativeFluents().set(this.mapOfFluentIndex.get(se.getChildren().get(0)));
                } else {
                    before.getPositiveFluents().set(this.mapOfFluentIndex.get(se));
                }
            } else if (e.getConnector().equals(Connector.HOLD_AFTER_METHOD_CONSTRAINT)) {
                final Symbol<Integer> task = e.getChildren().get(0).getTaskID();
                final Condition after = tn.getAfterConstraints(task.getValue());
                final Expression<Integer> se = e.getChildren().get(1);
                if (se.getConnector().equals(Connector.NOT)) {
                    after.getNegativeFluents().set(this.mapOfFluentIndex.get(se.getChildren().get(0)));
                } else {
                    after.getPositiveFluents().set(this.mapOfFluentIndex.get(se));
                }
            } else { // Between
                final Symbol<Integer> task1 = e.getChildren().get(0).getTaskID();
                final Symbol<Integer> task2 = e.getChildren().get(1).getTaskID();
                final Condition between = tn.getBetweenConstraints(task1.getValue(), task2.getValue());
                final Expression<Integer> se = e.getChildren().get(2);
                if (se.getConnector().equals(Connector.NOT)) {
                    between.getNegativeFluents().set(this.mapOfFluentIndex.get(se.getChildren().get(0)));
                } else {
                    between.getPositiveFluents().set(this.mapOfFluentIndex.get(se));
                }
            }
        }

        return tn;
    }

    /**
     * Normalize the methods, i.e, put in disjunctive normal form (DNF) the preconditions. If a method has
     * disjunctive preconditions, a new method is created such all methods after normalization have only conjunctive
     * precondition.
     * TO DO remove disjunctive expression in contraints.
     *
     * @param method the list of methods to normalized.
     */
    private List<IntMethod> normalizeMethod(final IntMethod method) throws UnexpectedExpressionException {
        final List<IntMethod> normalisedMethods = new ArrayList<>();
        final Expression<Integer> precond = new Expression<Integer>(method.getPreconditions());
        precond.toDNF();
        if (precond.getChildren().size() > 1) {
            for (final Expression<Integer> ei : precond.getChildren()) {
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
                newMethod.setTask(new Expression<Integer>(method.getTask()));
                newMethod.setTaskNetwork(new IntTaskNetwork(method.getTaskNetwork()));
                normalisedMethods.add(newMethod);
            }
        } else {
            normalisedMethods.add(method);
        }
        return normalisedMethods;
    }

    /**
     * Encode the list of tasks expressed as an expression into a list of integer.
     *
     * @param exp   the list of tasks expressed as an expression.
     * @param tasks the list of task encoded as integer.
     */
    private void encodeTasks(Expression<Integer> exp, List<Integer> tasks) {
        switch (exp.getConnector()) {
            case TASK:
                tasks.add(this.mapOfTasksIndex.get(exp));
                break;
            case AND:
            case OR:
                for (Expression<Integer> e : exp.getChildren()) {
                    this.encodeTasks(e, tasks);
                }
                break;
            default:
                // Do nothing
        }
    }
}
