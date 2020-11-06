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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * <p>
 * This class contains methods to encode actions, goal and initial state into <code>BitSet</code>
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
     * @param actions the list of actions to encode.
     * @param map     the map that associates to a specified expression its index.
     * @return the list of actions encoded into bit set.
     */
    static List<Action> encodeActions(final List<IntAction> actions, final Map<IntExpression, Integer> map, final Map<IntExpression, Integer> numericFluents)
        throws UnexpectedExpressionException {

        final List<Action> encodedActions = new ArrayList<>(actions.size());
        final List<Action> addedActions = new ArrayList<>();
        int actionIndex = 0;
        for (IntAction intAction : actions) {
            List<IntAction> normalized = BitEncoding.normalizeAction(intAction);
            encodedActions.add(BitEncoding.encodeAction(normalized.get(0), map, numericFluents));
            for (int i  = 1; i < normalized.size(); i++) {
                if (Encoder.tableOfRelevantOperators != null) {
                    Encoder.tableOfRelevantOperators.get(actionIndex).add(actions.size() + addedActions.size());
                }
                addedActions.add(BitEncoding.encodeAction(normalized.get(i), map, numericFluents));
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
     * @param map the map that associates to a specified expression its index.
     * @return the action encoded.
     */
    private static Action encodeAction(final IntAction action, final Map<IntExpression, Integer> map, final Map<IntExpression, Integer> numericFluents) {

        final int arity = action.arity();
        final Action encoded = new Action(action.getName(), arity);
        //encoded.setCost(action.getCost());

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
                //case TOTAL_COST_VAR:
                //    encoded.setCost(variable);
                //    break;
            }
        }
        encoded.setNumericVariables(variables);

        // Initialize the duration of the action
        if (action.isDurative()) {
            encoded.setDurationConstraints(BitEncoding.encodeDurationConstraints(action.getDuration(), numericVariableIndex));
        }

        // Initialize the preconditions of the action
        encoded.setPreconditions(BitEncoding.encode(action.getPreconditions(), map));
        encoded.setNumericConstraints(BitEncoding.encodeNumericConstraints(action.getPreconditions(), numericVariableIndex));
        /*System.out.println(Encoder.toString(action));*/

        // Initialize the effects of the action
        // Les functions numeric ne fonctionne pas avec les effects conditionel.
        final List<IntExpression> effects = action.getEffects().getChildren();

        final ConditionalEffect unCondEffects = new ConditionalEffect();
        boolean hasUnConditionalEffects = false;
        for (IntExpression ei : effects) {
            final List<IntExpression> children = ei.getChildren();
            switch (ei.getConnective()) {
                case WHEN:
                    final ConditionalEffect condBitExp = new ConditionalEffect();
                    condBitExp.setCondition(BitEncoding.encode(children.get(0), map));
                    condBitExp.setEffects(BitEncoding.encode(children.get(1), map));
                    encoded.getConditionalEffects().add(condBitExp);
                    break;
                case ATOM:
                    unCondEffects.getEffects().getPositive().set(map.get(ei));
                    hasUnConditionalEffects = true;
                    break;
                case TRUE:
                    // do nothing
                    break;
                case NOT:
                    unCondEffects.getEffects().getNegative().set(map.get(children.get(0)));
                    hasUnConditionalEffects = true;
                    break;
                case ASSIGN:
                case INCREASE:
                case DECREASE:
                case SCALE_DOWN:
                case SCALE_UP:
                    if (encoded.getNumericAssignments() == null) {
                        encoded.setNumericAssignments(new ArrayList<>());
                    }
                    NumericAssignment assignment = BitEncoding.encodeNumericAssignment(ei, numericVariableIndex);
                    //System.out.println(Encoder.toString(assignment));
                    encoded.getNumericAssignments().add(assignment);
                    break;
                default:
                    throw new UnexpectedExpressionException(Encoder.toString(ei));
            }
        }
        if (hasUnConditionalEffects) {
            encoded.getConditionalEffects().add(unCondEffects);
        }
     /*   System.out.println(Encoder.toString(encoded));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return encoded;
    }


    /**
     * Extract numeric fluents from an action.
     *
     * @param action the action.
     */
    private static List<IntExpression> extractNumericFluents(final IntAction action) {
        final Set<IntExpression> fluents = new HashSet<>();
        if (action.isDurative()) {
            PostInstantiation.extractRelevantNumericFluents(action.getDuration(), fluents);
        }
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
            //case TOTAL_COST_VAR:
            case AT_START:
            case AT_END:
                arithmeticExpression = new ArithmeticExpression(numericVariableIndex.get(exp));
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return arithmeticExpression;
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
     * Encode a list of specified methods into the final compact representation. The specified
     * maps are used to speed-up the search by mapping the an expression to this index.
     *
     * @param methods the list of methods to encode.
     * @param factMap the map that associates at a specified fact its index in the table of relevant fluents.
     * @param taskMap the map that associates at a specified task its index in the table of relevant tasks.
     * @return the list of methods encoded into final compact representation.
     */
    static List<Method> encodeMethods(final List<IntMethod> methods, final Map<IntExpression, Integer> factMap,
                                      final Map<IntExpression, Integer> taskMap) throws UnexpectedExpressionException {


        final List<Method> encodedMethods = new ArrayList<>(methods.size());
        final List<Method> addedMethods = new ArrayList<>();
        int methodIndex = Encoder.relevantActions.size();
        for (IntMethod intMethod : methods) {
            List<IntMethod> normalized = BitEncoding.normalizeMethod(intMethod);
            encodedMethods.add(BitEncoding.encodeMethod(normalized.get(0), factMap, taskMap));
            for (int i  = 1; i < normalized.size(); i++) {
                if (Encoder.tableOfRelevantOperators != null) {
                    Encoder.tableOfRelevantOperators.get(methodIndex).add(methods.size() + addedMethods.size());
                }
                encodedMethods.add(BitEncoding.encodeMethod(normalized.get(i), factMap, taskMap));
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
     * @param method the list of methods to encode.
     * @param factMap the map that associates at a specified fact its index in the table of relevant fluents.
     * @param taskMap the map that associates at a specified task its index in the table of relevant tasks.
     * @return the list of methods encoded into final compact representation.
     */
    static Method encodeMethod(final IntMethod method, final Map<IntExpression, Integer> factMap,
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
        encoded.setPreconditions(BitEncoding.encode(method.getPreconditions(), factMap));
        // Encode the task network of the method
        encoded.setTaskNetwork(BitEncoding.encodeTaskNetwork(method.getTaskNetwork(), taskMap));
        return encoded;
    }

    /**
     * Encode a specified goal in a disjunction of <code>BitExp</code>. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param goal the goal to encode.
     * @param map  the map that associates to a specified expression its index.
     * @return a list of <code>BitExp</code> that represents the goal as a disjunction of
     * <code>BitExp</code>.
     */
    static State encodeGoal(IntExpression goal, final Map<IntExpression, Integer> map)
        throws UnexpectedExpressionException {

        if (goal.getConnective().equals(PDDLConnective.FALSE)) {
            return null;
        }

        State newGoal;
        goal.toDNF();
        Encoder.codedGoal = new ArrayList<>(goal.getChildren().size());
        for (IntExpression exp : goal.getChildren()) {
            if (exp.getConnective().equals(PDDLConnective.ATOM)) {
                IntExpression and = new IntExpression(PDDLConnective.AND);
                and.getChildren().add(exp);
                Encoder.codedGoal.add(BitEncoding.encode(and, map));
            } else {
                Encoder.codedGoal.add(BitEncoding.encode(exp, map));
            }
        }
        if (Encoder.codedGoal.size() > 1) {
            // Create a new dummy fact to encode the goal
            final int dummyPredicateIndex = Encoder.tableOfPredicates.size();
            Encoder.tableOfPredicates.add(Constants.DUMMY_GOAL);
            Encoder.tableOfTypedPredicates.add(new ArrayList<>());
            IntExpression dummyGoal = new IntExpression(PDDLConnective.ATOM);
            dummyGoal.setPredicate(dummyPredicateIndex);
            dummyGoal.setArguments(new int[0]);
            final int dummyGoalIndex = Encoder.tableOfRelevantFluents.size();
            Encoder.tableOfRelevantFluents.add(dummyGoal);
            map.put(dummyGoal, dummyGoalIndex);
            newGoal = new State();
            newGoal.getPositive().set(dummyGoalIndex);
            final ConditionalEffect condEffect = new ConditionalEffect(newGoal);
            // for each disjunction create a dummy action
            for (State dis : Encoder.codedGoal) {
                final Action op = new Action(Constants.DUMMY_OPERATOR, 0);
                op.setDummy(true);
                op.setPreconditions(dis);
                op.getConditionalEffects().add(condEffect);
                Encoder.actions.add(op);
            }
        } else {
            newGoal = Encoder.codedGoal.get(0);
        }
        return newGoal;
    }

    /**
     * Encode a specified task network.
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param taskNetwork the tasknetwork to encode.
     * @param map         the map that associates to a specified expression its index.
     * @return a list of <code>BitExp</code> that represents the goal as a disjunction of
     * <code>BitExp</code>.
     */
    static TaskNetwork encodeTaskNetwork(IntTaskNetwork taskNetwork, final Map<IntExpression, Integer> map) {
        // We encode first the tasks
        final List<Integer> tasks = new ArrayList<Integer>();
        BitEncoding.encodeTasks(taskNetwork.getTasks(), map, tasks);
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
     * @param init the initial state to encode.
     * @param map  the map that associates to a specified expression its index.
     * @return the <code>BitExp</code> that represents the initial encoded.
     */
    static State encodeInit(final Set<IntExpression> init, final Map<IntExpression, Integer> map) {
        final State bitInit = new State();
        for (final IntExpression fact : init) {
            if (fact.getConnective().equals(PDDLConnective.ATOM)) {
                final Integer i = map.get(fact);
                if (i != null) {
                    bitInit.getPositive().set(i);
                }
            } else {
                final Integer i = map.get(fact.getChildren().get(0));
                if (i != null) {
                    bitInit.getNegative().set(i);
                }
            }
        }
        return bitInit;
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @param map the map that associate to a specified expression its index.
     * @return the expression in bit set representation.
     */
    private static State encode(final IntExpression exp, final Map<IntExpression, Integer> map)
        throws UnexpectedExpressionException {

        final State state = new State();
        switch (exp.getConnective()) {
            case ATOM:
                state.getPositive().set(map.get(exp));
                break;
            case NOT:
                state.getNegative().set(map.get(exp.getChildren().get(0)));
                break;
            case AND:
                final List<IntExpression> children = exp.getChildren();
                for (IntExpression ei : children) {
                    State s = BitEncoding.encode(ei, map);
                    state.getPositive().or(s.getPositive());
                    state.getNegative().or(s.getNegative());
                }
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return state;
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @return the expression in bit set representation.
     */
    private static List<NumericConstraint> encodeNumericConstraints(final IntExpression exp, Map<IntExpression, NumericVariable> variables)
        throws UnexpectedExpressionException {

        final List<NumericConstraint> constraints = new ArrayList<>();
        final State state = new State();
        switch (exp.getConnective()) {
            case AND:
                for (IntExpression e : exp.getChildren()) {
                    constraints.addAll(BitEncoding.encodeNumericConstraints(e, variables));
                }
                break;
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
                constraints.add(BitEncoding.encodeNumericConstraint(exp, variables));
                break;
            case ATOM:
            case NOT:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return constraints;
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @return the expression in bit set representation.
     */
    private static List<NumericAssignment> encodeNumericAssignments(final IntExpression exp, Map<IntExpression, NumericVariable> variables)
        throws UnexpectedExpressionException {

        final List<NumericAssignment> constraints = new ArrayList<>();
        final State state = new State();
        switch (exp.getConnective()) {
            case AND:
                for (IntExpression e : exp.getChildren()) {
                    constraints.addAll(BitEncoding.encodeNumericAssignments(e, variables));
                }
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                constraints.add(BitEncoding.encodeNumericAssignment(exp, variables));
                break;
            case ATOM:
            case NOT:
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return constraints;
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
            normalisedActions.addAll(BitEncoding.normalizeAction(a));
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
        action.getEffects().toCNF();
        BitEncoding.simplify(action.getEffects());
        final IntExpression precond = action.getPreconditions();
        precond.toDNF();
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
            precond.toDNF();
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
        precond.toDNF();
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


}
