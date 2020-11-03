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

package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.problem.*;

import fr.uga.pddl4j.problem.Precondition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * This class contains methods to encodePrecondition actions, goal and initial state into <code>BitSet</code>
 * representation.
 * </p>
 * <p>
 * Before encoding, every expression is normalized, i.e., put in disjunctive normal form (DNF) for
 * preconditions and put in conjunctive normal form (CNF) for effects. If an operator has disjunctive
 * preconditions, a new operator is created such all actions after normalization have only
 * conjunctive precondition.
 * </p>
 * <p>
 * <b>Notes:</b>
 * </p>
 * <ul>
 * <li> the problem of converting a well form formula of the first order-logic into DNF of CNF is
 * exponential. </li>
 * <li>The method does not compute the shorter DNF or CNF formula. If you want it have a look to
 * the Quine and McCluskey algorithm.</li>
 * </ul>
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
final class BitEncoding implements Serializable {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(BitEncoding.class);

    /**
     * The default constructor with a private access to prevent instance creation.
     */
    private BitEncoding() {
    }

    /**
     * Encode a list of specified actions into <code>BitSet</code> representation. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param actions the list of actions to encodePrecondition.
     * @param fluentIndex the map that associates to a specified fluent its index.
     * @param numericFluentIndex the map that associates to a specified numeric fluent its index.
     * @return the list of actions encoded into bit set.
     */
    static List<Action> encodeActions(final List<IntAction> actions, final Map<IntExpression, Integer> fluentIndex,
            final Map<IntExpression, Integer> numericFluentIndex)  throws UnexpectedExpressionException {

        final List<Action> encodedActions = new ArrayList<>(actions.size());
        final List<Action> addedActions = new ArrayList<>();
        int actionIndex = 0;
        for (IntAction intAction : actions) {
            List<IntAction> normalized = BitEncoding.normalizeAction(intAction);
            encodedActions.add(BitEncoding.encodeAction(normalized.get(0), fluentIndex, numericFluentIndex));
            for (int i  = 1; i < normalized.size(); i++) {
                if (Encoder.tableOfRelevantActions != null) {
                    Encoder.tableOfRelevantActions.get(actionIndex).add(actions.size() + addedActions.size());
                }
                addedActions.add(BitEncoding.encodeAction(normalized.get(i), fluentIndex, numericFluentIndex));
            }
            actionIndex++;
        }
        encodedActions.addAll(addedActions);
        return encodedActions;
    }

    /**
     * Encodes a specified action.
     *
     * @param action the action to be encoded. The precondition of the action must be a simple conjunction of atomic
     *               formulas
     * @param fluents the map that associates to a specified fluent its index.
     * @param numericFluents the map that associates to a specified numeric fluent its index.
     * @return the action encoded.
     */
    private static Action encodeAction(final IntAction action, final Map<IntExpression, Integer> fluents,
            final Map<IntExpression, Integer> numericFluents) {

        System.out.println(Encoder.toString(action));

        final int arity = action.arity();
        final Action encoded = new Action(action.getName(), arity);

        // Initialize the parameters of the action
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, action.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, action.getTypeOfParameters(i));
        }

        // Initialize the numeric variables of the action
        final List<IntExpression> actionNumericfluents = BitEncoding.extractNumericFluents(action);
        final Map<IntExpression, NumericVariable> numericVariableIndex = new HashMap<>();
        final List<NumericVariable> variables = new ArrayList<>();
        for (IntExpression fluent : actionNumericfluents) {
            final NumericVariable variable = new NumericVariable(numericFluents.get(fluent));
            variables.add(variable);
            numericVariableIndex.put(fluent, variable);
            switch (fluent.getConnective()) {
                case TIME_VAR:
                    encoded.setDuration(variable);
                    break;
                case TOTAL_COST_VAR:
                    encoded.setCost(variable);
                    break;
            }

        }
        encoded.setNumericVariables(variables);

        // Initialize the duration of the action
        if (action.isDurative()) {
            encoded.setDurationConstraints(BitEncoding.encodeDurationConstraints(action.getDuration(), numericVariableIndex));
        }

        // Initialize the preconditions of the action
        encoded.setPreconditions(BitEncoding.encodePrecondition(action.getPreconditions(), fluents, numericVariableIndex));

        // Initialize the effects of the action
        encoded.setConditionalEffects(BitEncoding.encodeEffects(action.getEffects(), fluents, numericVariableIndex));

        System.out.println(Encoder.toString(encoded));

        return encoded;
    }

    /**
     * Extract numeric fluents from an action.
     *
     * @param action the action.
     */
    private static List<IntExpression> extractNumericFluents(final IntAction action) {
        final Set<IntExpression> fluents = new HashSet<>();
        PostInstantiation.extractRelevantNumericFluents(action.getDuration(), fluents);
        PostInstantiation.extractRelevantNumericFluents(action.getPreconditions(), fluents);
        PostInstantiation.extractRelevantNumericFluents(action.getEffects(), fluents);
        return new ArrayList<>(fluents);
    }

    /**
     * Extract numeric fluents from a expression.
     *
     * @param exp the expression.
     */
    private static List<IntExpression> extractNumericFluents(final IntExpression exp) {
        final Set<IntExpression> fluents = new HashSet<>();
        PostInstantiation.extractRelevantNumericFluents(exp, fluents);
        return new ArrayList<>(fluents);
    }

    /**
     * Extract numeric fluents from a method.
     *
     * @param method the method.
     */
    private static List<IntExpression> extractNumericFluents(final IntMethod method) {
        Set<IntExpression> fluents = new HashSet<>();
        PostInstantiation.extractRelevantNumericFluents(method.getPreconditions(), fluents);
        return new ArrayList<>(fluents);
    }

    /**
     * Encode the duration constraints of the action. The expression in parameter must be a conjunction of simple
     * numeric constraints.
     *
     * @param exp the expression that represents the duration constraints.
     * @param numericVariables the map that associates to a specified numeric fluent its numeric variable.
     *
     */
    static List<NumericConstraint> encodeDurationConstraints(final IntExpression exp,
            final Map<IntExpression, NumericVariable> numericVariables) {

        List<NumericConstraint> constraints = new ArrayList<>();
        for (IntExpression constraint: exp.getChildren()) {
            constraints.add(BitEncoding.encodeNumericConstraint(constraint, numericVariables));
        }
        return constraints;
    }

    /**
     * Encodes a numeric constraint.
     *
     * @param numericVariables the map that associates to a specified numeric fluent its numeric variable.
     */
    static NumericConstraint encodeNumericConstraint(final IntExpression exp,
            final Map<IntExpression, NumericVariable> numericVariables) {

        ArithmeticExpression left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), numericVariables);
        ArithmeticExpression right = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), numericVariables);
        NumericConstraint constraint = null;
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
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return constraint;
    }

    /**
     * Encodes an arithmetic expression.
     *
     * @param numericVariableIndex the map that associates to a specified numeric fluent its numeric variable.
     */
    static ArithmeticExpression encodeArithmeticExpression(final IntExpression exp,
            final Map<IntExpression, NumericVariable> numericVariableIndex) {

        ArithmeticExpression arithmeticExpression;
        ArithmeticExpression left;
        ArithmeticExpression right;
        switch (exp.getConnective()) {
            case PLUS:
                left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), numericVariableIndex);
                right = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), numericVariableIndex);
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.PLUS, left, right);
                break;
            case MINUS:
                left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), numericVariableIndex);
                right = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), numericVariableIndex);
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.MINUS, left, right);
                break;
            case UMINUS:
                left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), numericVariableIndex);
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.UMINUS, left, null);
                break;
            case DIV:
                left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), numericVariableIndex);
                right = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), numericVariableIndex);
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.DIV, left, right);
                break;
            case MUL:
                left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), numericVariableIndex);
                right = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), numericVariableIndex);
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.MUL, left, right);
                break;
            case NUMBER:
                arithmeticExpression = new ArithmeticExpression(exp.getValue());
                break;
            case F_EXP:
                arithmeticExpression = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), numericVariableIndex);
                break;
            case FN_HEAD:
            case TIME_VAR:
            case TOTAL_COST_VAR:
            case AT_START:
            case AT_END:
                arithmeticExpression = new ArithmeticExpression(numericVariableIndex.get(exp));
                break;
            default:
                System.out.println(exp.getConnective());
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return arithmeticExpression;
    }

    /**
     * Encode a list of specified methods into the final compact representation. The specified
     * maps are used to speed-up the search by mapping the an expression to this index.
     *
     * @param methods the list of methods to encodePrecondition.
     * @param fluents the map that associates at a specified fluent its index in the table of relevant fluents.
     * @param numericFluents the map that associates at a specified numeric fluent its index in the table of
     *                           relevant numeric fluents table.
     * @param tasks the map that associates at a specified task its index in the table of relevant tasks.
     * @return the list of methods encoded into final compact representation.
     */
    static List<Method> encodeMethods(final List<IntMethod> methods,
                                      final Map<IntExpression, Integer> fluents,
                                      final Map<IntExpression, Integer> numericFluents,
                                      final Map<IntExpression, Integer> tasks) throws UnexpectedExpressionException {

        final List<Method> encodedMethods = new ArrayList<>(methods.size());
        final List<Method> addedMethods = new ArrayList<>();
        int methodIndex = Encoder.relevantActions.size();
        for (IntMethod intMethod : methods) {
            List<IntMethod> normalized = BitEncoding.normalizeMethod(intMethod);
            encodedMethods.add(BitEncoding.encodeMethod(normalized.get(0), fluents, numericFluents, tasks));
            for (int i  = 1; i < normalized.size(); i++) {
                if (Encoder.tableOfRelevantActions != null) {
                    Encoder.tableOfRelevantActions.get(methodIndex).add(methods.size() + addedMethods.size());
                }
                encodedMethods.add(BitEncoding.encodeMethod(normalized.get(i), fluents, numericFluents, tasks));
            }
            methodIndex++;
        }
        encodedMethods.addAll(addedMethods);
        return encodedMethods;
    }

    /**
     * Encode a list of specified methods into the final compact representation. The specified
     * maps are used to speed-up the search by mapping the an expression to this index.
     *
     * @param method the list of methods to encodePrecondition.
     * @param fluents the map that associates at a specified fluent its index in the table of relevant fluents.
     * @param numericFluents the map that associates at a specified numeric fluent its index in the table of
     *                           relevant numeric fluents table.
     * @param tasks the map that associates at a specified task its index in the table of relevant tasks.
     *
     *
     * numericFluentIndex
     * @return the list of methods encoded into final compact representation.
     */
    static Method encodeMethod(final IntMethod method, final Map<IntExpression, Integer> fluents,
            final Map<IntExpression, Integer> numericFluents,
            final Map<IntExpression, Integer> tasks) throws UnexpectedExpressionException {

        final int arity = method.arity();
        final Method encoded = new Method(method.getName(), arity);
        // Initialize the parameters of the method
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, method.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, method.getTypeOfParameters(i));
        }

        // Initialize the numeric variables of the action
        final List<IntExpression> methodNumericFluents = BitEncoding.extractNumericFluents(method);
        final Map<IntExpression, NumericVariable> numericVariables = new HashMap<>();
        final List<NumericVariable> variables = new ArrayList<>();
        for (IntExpression fluent : methodNumericFluents) {
            final NumericVariable variable = new NumericVariable(numericFluents.get(fluent));
            variables.add(variable);
            numericVariables.put(fluent, variable);
        }
        encoded.setNumericVariables(variables);

        // Encode the task carried out by the method
        encoded.setTask(tasks.get(method.getTask()));
        // Encode the preconditions of the method
        encoded.setPreconditions(BitEncoding.encodePrecondition(method.getPreconditions(), fluents, numericVariables));
        // Encode the task network of the method
        encoded.setTaskNetwork(BitEncoding.encodeTaskNetwork(method.getTaskNetwork(), tasks));
        return encoded;
    }

    /**
     * Encode a specified goal in a disjunction of <code>Precondition</code>. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param goalExp the goal to encodePrecondition.
     * @param fluentIndex  the map that associates to a specified fluent its index.
     *
     * @return a list of <code>BitExp</code> that represents the goal as a disjunction of
     * <code>BitExp</code>.
     */
    static Goal encodeGoal(IntExpression goalExp, final Map<IntExpression, Integer> fluentIndex,
                                   final Map<IntExpression, Integer> numericFluentIndex)
        throws UnexpectedExpressionException {

        // If the goal is simplified to fals
        if (goalExp.getConnective().equals(PDDLConnective.FALSE)) {
            return null;
        }

        // Convert the goal in disjunctive normal form.
        BitEncoding.toDNF(goalExp);
        // Create the list of goals. Each goal is in a conjunctive form.
        List<Goal> goals = new ArrayList<>(goalExp.getChildren().size());

        for (IntExpression conjunctiveGoalExp : goalExp.getChildren()) {
            // Create a empty goal.
            final Goal goal = new Goal();
            // Initialize the numeric variables of the goal
            final List<IntExpression> goalNumericFluents = BitEncoding.extractNumericFluents(conjunctiveGoalExp);
            final Map<IntExpression, NumericVariable> numericVariables = new HashMap<>();
            final List<NumericVariable> variables = new ArrayList<>();
            for (IntExpression fluent : goalNumericFluents) {
                final NumericVariable variable = new NumericVariable(numericFluentIndex.get(fluent));
                variables.add(variable);
                numericVariables.put(fluent, variable);
            }
            goal.setNumericVariables(variables);

            // Encode the fluents of the goal
            BitEncoding.encodePrecondition(conjunctiveGoalExp, goal, fluentIndex, numericVariables);
            // Add the goal to the list of goal to reach
            goals.add(goal);
        }

        // We have a disjunctive goal
        Goal encodedGoal = null;
        if (goals.size() == 1) {
            encodedGoal = goals.get(0);
        } else {
            // Create a new dummy fact to encodePrecondition the goal
            final int dummyPredicateIndex = Encoder.tableOfPredicates.size();
            Encoder.tableOfPredicates.add(Constants.DUMMY_GOAL);
            Encoder.tableOfTypedPredicates.add(new ArrayList<>());
            final IntExpression dummyGoal = new IntExpression(PDDLConnective.ATOM);
            dummyGoal.setPredicate(dummyPredicateIndex);
            dummyGoal.setArguments(new int[0]);
            final int dummyGoalIndex = Encoder.tableOfRelevantFluents.size();
            Encoder.tableOfRelevantFluents.add(dummyGoal);
            fluentIndex.put(dummyGoal, dummyGoalIndex);
            final Effect effect = new Effect();
            effect.getPositiveFluents().set(dummyGoalIndex);
            final ConditionalEffect condEffect = new ConditionalEffect(effect);
            encodedGoal = new Goal();
            encodedGoal.getPositiveFluents().set(dummyGoalIndex);
            // for each disjunction create a dummy action
            for (Precondition p : goals) {
                final Action action = new Action(Constants.DUMMY_OPERATOR, 0);
                action.setDummy(true);
                action.setPreconditions(p);
                action.getConditionalEffects().add(condEffect);
                Encoder.actions.add(action);
            }
        }
        return encodedGoal;
    }

    /**
     * Encode a specified task network.
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param taskNetwork the tasknetwork to encodePrecondition.
     * @param map         the map that associates to a specified expression its index.
     * @return a list of <code>BitExp</code> that represents the goal as a disjunction of
     * <code>BitExp</code>.
     */
    static TaskNetwork encodeTaskNetwork(IntTaskNetwork taskNetwork, final Map<IntExpression, Integer> map) {
        // We encodePrecondition first the tasks
        final List<Integer> tasks = new ArrayList<Integer>();
        BitEncoding.encodeTasks(taskNetwork.getTasks(), map, tasks);
        // We encodePrecondition then the ordering constraints
        final OrderingConstraintSet constraints = new OrderingConstraintSet(tasks.size());
        for (IntExpression c : taskNetwork.getOrderingConstraints().getChildren()) {
            constraints.set(c.getChildren().get(0).getTaskID(), c.getChildren().get(1).getTaskID());
        }
        final TaskNetwork tn = new TaskNetwork(tasks, constraints);
        tn.transitiveClosure();
        return tn;
    }

    /**
     * Encode the list of tasks expressed as an IntExpression into a list of integer.
     *
     * @param exp   the list of tasks expressed as an IntExpression.
     * @param map   the map containing the index associated to the tasks.
     * @param tasks the list of task encoded as integer.
     */
    static void encodeTasks(IntExpression exp, final Map<IntExpression, Integer> map, List<Integer> tasks) {
        switch (exp.getConnective()) {
            case TASK:
                tasks.add(map.get(exp));
                break;
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    encodeTasks(e, map, tasks);
                }
                break;
            default:
                // Do nothing
        }
    }

    /**
     * Encode a specified initial state in it <code>BitExp</code> representation. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param init the initial state to encodePrecondition.
     * @param map  the map that associates to a specified expression its index.
     * @return the <code>BitExp</code> that represents the initial encoded.
     */
    static Precondition encodeInit(final Set<IntExpression> init, final Map<IntExpression, Integer> map) {
        final Precondition bitInit = new Precondition();
        for (final IntExpression fact : init) {
            if (fact.getConnective().equals(PDDLConnective.ATOM)) {
                final Integer i = map.get(fact);
                if (i != null) {
                    bitInit.getPositiveFluents().set(i);
                }
            } else {
                final Integer i = map.get(fact.getChildren().get(0));
                if (i != null) {
                    bitInit.getNegativeFluents().set(i);
                }
            }
        }
        return bitInit;
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>Precondition</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @param fluents the map that associate to a specified expression its index.
     * @param variables the map that associate to a specified expression its numeric variable.
     * @return the expression in bit set representation.
     */
    private static Precondition encodePrecondition(final IntExpression exp, final Map<IntExpression, Integer> fluents,
            final Map<IntExpression, NumericVariable> variables) throws UnexpectedExpressionException {
        final Precondition precondition = new Precondition();
        return BitEncoding.encodePrecondition(exp, precondition, fluents, variables);

    }
    /**
     * Encode an specified <code>IntExpression</code> in its <code>Precondition</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @param precondition the precondition to encode.
     * @param fluents the map that associate to a specified expression its index.
     * @param variables the map that associate to a specified expression its numeric variable.
     * @return the expression in bit set representation.
     */
    private static Precondition encodePrecondition(final IntExpression exp, final Precondition precondition,
            final Map<IntExpression, Integer> fluents, final Map<IntExpression, NumericVariable> variables)
                throws UnexpectedExpressionException {

        switch (exp.getConnective()) {
            case AND:
                final List<IntExpression> children = exp.getChildren();
                for (IntExpression child : children) {
                    BitEncoding.encodePrecondition(child, precondition, fluents, variables);
                }
                break;
            case ATOM:
                Integer index = fluents.get(exp);
                precondition.getPositiveFluents().set(index);
                break;
            case NOT:
                IntExpression neg = exp.getChildren().get(0);
                switch (neg.getConnective()) {
                    case ATOM:
                        index = fluents.get(neg);
                        precondition.getNegativeFluents().set(index);
                        break;
                    case FALSE:
                        // do nothing
                        break;
                    default:
                        throw new UnexpectedExpressionException(Encoder.toString(exp));
                }
                break;
            case AT_START:
                IntExpression c = exp.getChildren().get(0);
                switch (c.getConnective()) {
                    case ATOM:
                        index = fluents.get(c);
                        precondition.getPositiveTimedGoalDescription().getAtStartFluents().set(index);
                        break;
                    case NOT:
                        index = fluents.get(c.getChildren().get(0));
                        precondition.getNegativeTimedGoalDescription().getAtStartFluents().set(index);
                        break;
                    case EQUAL:
                    case LESS:
                    case LESS_OR_EQUAL:
                    case GREATER:
                    case GREATER_OR_EQUAL:
                        final NumericConstraint constraint = BitEncoding.encodeNumericConstraint(c, variables);
                        constraint.setTimeSpecifier(TimeSpecifier.AT_START);
                        precondition.addNumericConstraint(constraint);
                        break;
                    default:
                        LOGGER.error(Encoder.toString(exp));
                        throw new UnexpectedExpressionException(Encoder.toString(c));
                }
                break;
            case OVER_ALL:
                c = exp.getChildren().get(0);
                switch (c.getConnective()) {
                    case ATOM:
                        index = fluents.get(c);
                        precondition.getPositiveTimedGoalDescription().getOverAllFluents().set(index);
                        break;
                    case NOT:
                        index = fluents.get(c.getChildren().get(0));
                        precondition.getNegativeTimedGoalDescription().getOverAllFluents().set(index);
                        break;
                    default:
                        LOGGER.error(Encoder.toString(exp));
                        throw new UnexpectedExpressionException(Encoder.toString(c));
                }
                break;
            case AT_END:
                c = exp.getChildren().get(0);
                switch (c.getConnective()) {
                    case ATOM:
                        index = fluents.get(c);
                        precondition.getPositiveTimedGoalDescription().getAtEndFluents().set(index);
                        break;
                    case NOT:
                        index = fluents.get(c.getChildren().get(0));
                        precondition.getNegativeTimedGoalDescription().getAtEndFluents().set(index);
                        break;
                    case EQUAL:
                    case LESS:
                    case LESS_OR_EQUAL:
                    case GREATER:
                    case GREATER_OR_EQUAL:
                        final NumericConstraint constraint = BitEncoding.encodeNumericConstraint(c, variables);
                        constraint.setTimeSpecifier(TimeSpecifier.AT_END);
                        precondition.addNumericConstraint(constraint);
                        break;
                    default:
                        LOGGER.error(Encoder.toString(exp));
                        throw new UnexpectedExpressionException(Encoder.toString(c));
                }
                break;
            case TRUE:
                // do nothing
                break;
            case EQUAL:
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
                precondition.addNumericConstraint(BitEncoding.encodeNumericConstraint(exp, variables));
                break;
            default:
                LOGGER.error(Encoder.toString(exp));
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return precondition;
    }



    /**
     * Encodes the effects of an action.
     *
     * @param exp the expression that represents the effects of the action.
     * @return the list of conditional effects that represents the effects of the action
     */
    private static List<ConditionalEffect> encodeEffects(final IntExpression exp,
                                                         final Map<IntExpression, Integer> fluents,
                                                         final Map<IntExpression, NumericVariable> numericVariables) {

        final List<ConditionalEffect> effects = new ArrayList<>();
        final ConditionalEffect unCondEffects = new ConditionalEffect();
        boolean hasUnConditionalEffects = false;
        for (IntExpression effect : exp.getChildren()) {
            final PDDLConnective connective = effect.getConnective();
            final List<IntExpression> children = effect.getChildren();
            switch (connective) {
                case WHEN:
                    final ConditionalEffect condBitExp = new ConditionalEffect();
                    condBitExp.setCondition(BitEncoding.encodePrecondition(children.get(0), fluents, numericVariables));
                    condBitExp.setEffect(BitEncoding.encodeEffect(children.get(1), fluents, numericVariables));
                    effects.add(condBitExp);
                    break;
                case ATOM:
                    Integer index = fluents.get(effect);
                    unCondEffects.getEffect().getPositiveFluents().set(index);
                    hasUnConditionalEffects = true;
                    break;
                case AT_START:
                    switch (effect.getChildren().get(0).getConnective()) {
                        case ATOM:
                            index = fluents.get(effect.getChildren().get(0));
                            unCondEffects.getEffect().getPositiveTimedGoalDescription().getAtStartFluents().set(index);
                            break;
                        case NOT:
                            index = fluents.get(effect.getChildren().get(0).getChildren().get(0));
                            unCondEffects.getEffect().getNegativeTimedGoalDescription().getAtStartFluents().set(index);
                            break;
                        case ASSIGN:
                        case INCREASE:
                        case DECREASE:
                        case SCALE_UP:
                        case SCALE_DOWN:
                            final NumericAssignment assignment = BitEncoding.encodeNumericAssignment(
                                effect.getChildren().get(0), numericVariables);
                            assignment.setTimeSpecifier(TimeSpecifier.AT_START);
                            unCondEffects.getEffect().addNumericAssignment(assignment);
                            break;
                        default:
                            throw new UnexpectedExpressionException(Encoder.toString(effect));
                    }
                    hasUnConditionalEffects = true;
                    break;
                case OVER_ALL:
                    switch (effect.getChildren().get(0).getConnective()) {
                        case ATOM:
                            index = fluents.get(effect.getChildren().get(0));
                            unCondEffects.getEffect().getPositiveTimedGoalDescription().getOverAllFluents().set(index);
                            break;
                        case NOT:
                            index = fluents.get(effect.getChildren().get(0).getChildren().get(0));
                            unCondEffects.getEffect().getNegativeTimedGoalDescription().getOverAllFluents().set(index);
                            break;
                        default:
                            throw new UnexpectedExpressionException(Encoder.toString(effect));
                    }
                    hasUnConditionalEffects = true;
                    break;
                case AT_END:
                    switch (effect.getChildren().get(0).getConnective()) {
                        case ATOM:
                            index = fluents.get(effect.getChildren().get(0));
                            unCondEffects.getEffect().getPositiveTimedGoalDescription().getAtEndFluents().set(index);
                            break;
                        case NOT:
                            index = fluents.get(effect.getChildren().get(0).getChildren().get(0));
                            unCondEffects.getEffect().getNegativeTimedGoalDescription().getAtEndFluents().set(index);
                            break;
                        case ASSIGN:
                        case INCREASE:
                        case DECREASE:
                        case SCALE_UP:
                        case SCALE_DOWN:
                            final NumericAssignment assignment = BitEncoding.encodeNumericAssignment(
                                effect.getChildren().get(0), numericVariables);
                            assignment.setTimeSpecifier(TimeSpecifier.AT_END);
                            unCondEffects.getEffect().addNumericAssignment(assignment);
                            break;
                        default:
                            throw new UnexpectedExpressionException(Encoder.toString(effect));
                    }
                    hasUnConditionalEffects = true;
                    break;
                case TRUE:
                    // do nothing
                    break;
                case NOT:
                    index = fluents.get(children.get(0));
                    unCondEffects.getEffect().getNegativeFluents().set(index);
                    hasUnConditionalEffects = true;
                    break;
                default:
                    throw new UnexpectedExpressionException(Encoder.toString(effect));
            }
        }
        if (hasUnConditionalEffects) {
            effects.add(unCondEffects);
        }

        return effects;
    }

    /**
     * Encodes the effect of an action.
     *
     * @param exp the expression that represents the effects of the action.
     * @return the list of conditional effects that represents the effects of the action
     */
    private static Effect encodeEffect(final IntExpression exp,
                                                         final Map<IntExpression, Integer> fluents,
                                                         final Map<IntExpression, NumericVariable> numericVariables) {

        final Effect effect = new Effect();
        switch (exp.getConnective()) {
            case ATOM:
                Integer index = fluents.get(exp);
                effect.getPositiveFluents().set(index);
                break;
            case AT_START:
                switch (exp.getChildren().get(0).getConnective()) {
                    case ATOM:
                        index = fluents.get(exp.getChildren().get(0));
                        effect.getPositiveTimedGoalDescription().getAtStartFluents().set(index);
                        break;
                    case NOT:
                        index = fluents.get(exp.getChildren().get(0).getChildren().get(0));
                        effect.getNegativeTimedGoalDescription().getAtStartFluents().set(index);
                        break;
                    case ASSIGN:
                    case INCREASE:
                    case DECREASE:
                    case SCALE_UP:
                    case SCALE_DOWN:
                        final NumericAssignment assignment = BitEncoding.encodeNumericAssignment(
                            exp.getChildren().get(0), numericVariables);
                        assignment.setTimeSpecifier(TimeSpecifier.AT_START);
                        effect.addNumericAssignment(assignment);
                        break;
                    default:
                        throw new UnexpectedExpressionException(Encoder.toString(exp));
                }
                break;
            case OVER_ALL:
                switch (exp.getChildren().get(0).getConnective()) {
                    case ATOM:
                        index = fluents.get(exp.getChildren().get(0));
                        effect.getPositiveTimedGoalDescription().getOverAllFluents().set(index);
                        break;
                    case NOT:
                        index = fluents.get(exp.getChildren().get(0).getChildren().get(0));
                        effect.getNegativeTimedGoalDescription().getOverAllFluents().set(index);
                        break;
                    default:
                        throw new UnexpectedExpressionException(Encoder.toString(exp));
                }
                break;
            case AT_END:
                switch (exp.getChildren().get(0).getConnective()) {
                    case ATOM:
                        index = fluents.get(exp.getChildren().get(0));
                        effect.getPositiveTimedGoalDescription().getAtEndFluents().set(index);
                        break;
                    case NOT:
                        index = fluents.get(exp.getChildren().get(0).getChildren().get(0));
                        effect.getNegativeTimedGoalDescription().getAtEndFluents().set(index);
                        break;
                    case ASSIGN:
                    case INCREASE:
                    case DECREASE:
                    case SCALE_UP:
                    case SCALE_DOWN:
                        final NumericAssignment assignment = BitEncoding.encodeNumericAssignment(
                            exp.getChildren().get(0), numericVariables);
                        assignment.setTimeSpecifier(TimeSpecifier.AT_END);
                        effect.addNumericAssignment(assignment);
                        break;
                    default:
                        throw new UnexpectedExpressionException(Encoder.toString(exp));
                }
                break;
            case TRUE:
                // do nothing
                break;
            case NOT:
                index = fluents.get(exp.getChildren().get(0));
                effect.getNegativeFluents().set(index);
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return effect;
    }

    /**
     * Encodes a numeric assignment.
     *
     * @param numericVariableIndex the map that associates to a specified numeric fluent its numeric variable.
     */
    static NumericAssignment encodeNumericAssignment(final IntExpression exp,
            final Map<IntExpression, NumericVariable> numericVariableIndex) {

        final ArithmeticExpression left = BitEncoding.encodeArithmeticExpression(
            exp.getChildren().get(0), numericVariableIndex);
        final ArithmeticExpression right = BitEncoding.encodeArithmeticExpression(
            exp.getChildren().get(1), numericVariableIndex);
        NumericAssignment assignment = null;
        switch (exp.getConnective()) {
            case ASSIGN:
                assignment = new NumericAssignment(NumericAssignment.Operator.ASSIGN, left, right);
                break;
            case INCREASE:
                assignment = new NumericAssignment(NumericAssignment.Operator.INCREASE, left, right);
                break;
            case DECREASE:
                assignment = new NumericAssignment(NumericAssignment.Operator.DECREASE, left, right);
                break;
            case SCALE_UP:
                assignment = new NumericAssignment(NumericAssignment.Operator.SCALE_UP, left, right);
                break;
            case SCALE_DOWN:
                assignment = new NumericAssignment(NumericAssignment.Operator.SCALE_DOWN, left, right);
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return assignment;
    }

    /**
     * Normalize the actions, i.e, put in disjunctive normal form (DNF) for preconditions and put
     * in conjunctive normal form (CNF) for effects. If an action has disjunctive preconditions, a
     * new operator is created such all actions after normalization have only conjunctive
     * precondition.
     *
     * @param actions the list of actions to normalizeActions.
     */
    private static void normalizeActions(final List<IntAction> actions) {
        final List<IntAction> normalisedActions = new ArrayList<>(actions.size() + 100);
        for (IntAction a : actions) {
            BitEncoding.toCNF(a.getEffects());
            BitEncoding.simplify(a.getEffects());
            final IntExpression precond = a.getPreconditions();
            BitEncoding.toDNF(precond);
            if (precond.getChildren().size() > 0) {
                for (final IntExpression ei : precond.getChildren()) {
                    final String name = a.getName();
                    final int arity = a.arity();
                    final IntAction newAction = new IntAction(name, arity);
                    if (a.isDurative()) {
                        newAction.setDuration(new IntExpression(a.getDuration()));
                    }
                    newAction.setCost(a.getCost());
                    for (int i = 0; i < arity; i++) {
                        newAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                    }
                    for (int i = 0; i < arity; i++) {
                        newAction.setValueOfParameter(i, a.getValueOfParameter(i));
                    }
                    newAction.setPreconditions(ei);

                    newAction.setEffects(new IntExpression(a.getEffects()));
                    normalisedActions.add(newAction);
                }
            } else {
                normalisedActions.add(a);
            }

        }
        actions.clear();
        actions.addAll(normalisedActions);
    }

    /**
     * Normalize an action, i.e, put in disjunctive normal form (DNF) for preconditions and put
     * in conjunctive normal form (CNF) for effects. If an action has disjunctive preconditions, a
     * new operator is created such all actions after normalization have only conjunctive
     * precondition.
     *
     * @param action the action to normalize.
     */
    private static List<IntAction> normalizeAction(final IntAction action) {
        final List<IntAction> normalisedActions = new ArrayList<>();
        BitEncoding.toCNF(action.getEffects());
        BitEncoding.simplify(action.getEffects());
        final IntExpression precond = action.getPreconditions();
        BitEncoding.toDNF(precond);
        if (precond.getChildren().size() > 0) {
            for (final IntExpression ei : precond.getChildren()) {
                final String name = action.getName();
                final int arity = action.arity();
                final IntAction newAction = new IntAction(name, arity);
                if (action.isDurative()) {
                    newAction.setDuration(new IntExpression(action.getDuration()));
                }
                newAction.setCost(action.getCost());
                for (int i = 0; i < arity; i++) {
                    newAction.setTypeOfParameter(i, action.getTypeOfParameters(i));
                }
                for (int i = 0; i < arity; i++) {
                    newAction.setValueOfParameter(i, action.getValueOfParameter(i));
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
     * Normalize the methods, i.e, put in disjunctive normal form (DNF) the preconditions. If a method has
     * disjunctive preconditions, a new method is created such all methods after normalization have only conjunctive
     * precondition.
     *
     * @param methods the list of methods to normalizeActions.
     */
    private static void normalizeMethods(final List<IntMethod> methods) throws UnexpectedExpressionException {
        final List<IntMethod> normalisedMethods = new ArrayList<>(methods.size() + 100);
        for (IntMethod m : methods) {
            final IntExpression precond = m.getPreconditions();
            BitEncoding.toDNF(precond);
            if (precond.getChildren().size() > 0) {
                for (final IntExpression ei : precond.getChildren()) {
                    final String name = m.getName();
                    final int arity = m.arity();
                    final IntMethod newMethod = new IntMethod(name, arity);
                    for (int i = 0; i < arity; i++) {
                        newMethod.setTypeOfParameter(i, m.getTypeOfParameters(i));
                    }
                    for (int i = 0; i < arity; i++) {
                        newMethod.setValueOfParameter(i, m.getValueOfParameter(i));
                    }
                    newMethod.setPreconditions(ei);
                    newMethod.setTask(new IntExpression(m.getTask()));
                    newMethod.setTaskNetwork(new IntTaskNetwork(m.getTaskNetwork()));
                    normalisedMethods.add(newMethod);
                }
            } else {
                normalisedMethods.add(m);
            }

        }
        methods.clear();
        methods.addAll(normalisedMethods);
    }

    /**
     * Normalize the methods, i.e, put in disjunctive normal form (DNF) the preconditions. If a method has
     * disjunctive preconditions, a new method is created such all methods after normalization have only conjunctive
     * precondition.
     *
     * @param method the list of methods to normalizeActions.
     */
    private static List<IntMethod> normalizeMethod(final IntMethod method) throws UnexpectedExpressionException {
        final List<IntMethod> normalisedMethods = new ArrayList<>();
        final IntExpression precond = method.getPreconditions();
        BitEncoding.toDNF(precond);
        if (precond.getChildren().size() > 0) {
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
     * Remove overlapped expression from a specified expression.
     *
     * @param exp the expression.
     */
    private static void simplify(IntExpression exp) {
        boolean simplified;
        int i = 0;
        do {
            simplified = false;
            final List<IntExpression> children = exp.getChildren();
            while (i < children.size()) {
                final IntExpression ei = children.get(i);
                if (ei.getConnective().equals(PDDLConnective.AND)
                    || ei.getConnective().equals(PDDLConnective.OR)) {
                    simplified = true;
                    children.remove(i);
                    for (IntExpression ej : ei.getChildren()) {
                        children.add(i, ej);
                        i++;
                    }
                } else {
                    i++;
                }
            }
        } while (simplified);
    }

    /**
     * Convert an expression in conjunctive normal form (CNF).
     *
     * @param exp the expression to transform in CNF.
     */
    private static void toCNF(final IntExpression exp) throws UnexpectedExpressionException {
        switch (exp.getConnective()) {
            case WHEN:
                final IntExpression antecedent = exp.getChildren().get(0);
                final IntExpression consequence = exp.getChildren().get(1);
                BitEncoding.toDNF(antecedent);
                exp.setConnective(PDDLConnective.AND);
                exp.getChildren().clear();
                for (IntExpression ei : antecedent.getChildren()) {
                    final IntExpression newWhen = new IntExpression(PDDLConnective.WHEN);
                    newWhen.getChildren().add(ei);
                    newWhen.getChildren().add(consequence);
                    exp.getChildren().add(newWhen);
                }
                break;
            case AND:
                final List<IntExpression> children = exp.getChildren();
                int i = 0;
                while (i < children.size()) {
                    final IntExpression ei = children.get(i);
                    BitEncoding.toCNF(ei);
                    exp.getChildren().remove(i);
                    for (IntExpression ej : ei.getChildren()) {
                        exp.getChildren().add(i, ej);
                        i++;
                    }
                }
                break;
            case ATOM:
            case NOT:
            case TRUE:
            case AT_START:
            case AT_END:
            case OVER_ALL:
                IntExpression copy = new IntExpression(exp);
                exp.setConnective(PDDLConnective.AND);
                exp.getChildren().clear();
                exp.getChildren().add(copy);
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
    }

    /**
     * Convert an expression in disjunctive normal form (DNF).
     *
     * @param exp the expression to transform in DNF.
     */
    private static void toDNF(final IntExpression exp) throws UnexpectedExpressionException {
        switch (exp.getConnective()) {
            case OR:
                List<IntExpression> children = exp.getChildren();
                int index = 0;
                while (index < children.size()) {
                    final IntExpression ei = children.get(index);
                    BitEncoding.toDNF(ei);
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
                    BitEncoding.toDNF(child);
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
            case TRUE:
            case AT_START:
            case AT_END:
            case OVER_ALL:
                IntExpression and = new IntExpression(PDDLConnective.AND);
                and.getChildren().add(new IntExpression(exp));
                exp.setConnective(PDDLConnective.OR);
                exp.getChildren().clear();
                exp.getChildren().add(and);
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
    }
}
