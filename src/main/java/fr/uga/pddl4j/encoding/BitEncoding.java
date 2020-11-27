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
    static List<Action> encodeActions(final List<IntAction> actions,
                                      final Map<IntExpression, Integer> map,
                                      final Map<IntExpression, Integer> numericFluentIndexMap)
                                            throws UnexpectedExpressionException {

        final List<Action> encodedActions = new ArrayList<>(actions.size());
        final List<Action> addedActions = new ArrayList<>();
        int actionIndex = 0;
        for (IntAction intAction : actions) {
            List<IntAction> normalized = BitEncoding.normalizeAction(intAction);
            encodedActions.add(BitEncoding.encodeAction(normalized.get(0), map, numericFluentIndexMap));
            for (int i  = 1; i < normalized.size(); i++) {
                if (Encoder.tableOfRelevantOperators != null) {
                    Encoder.tableOfRelevantOperators.get(actionIndex).add(actions.size() + addedActions.size());
                }
                addedActions.add(BitEncoding.encodeAction(normalized.get(i), map, numericFluentIndexMap));
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
     * @param fluents the map that associates to a specified expression its index.
     * @return the action encoded.
     */
    private static Action encodeAction(final IntAction action,
                                       final Map<IntExpression, Integer> fluents,
                                       final Map<IntExpression, Integer> numeric) {
        final int arity = action.arity();
        final Action encoded = new Action(action.getName(), arity);
        encoded.setCost(new NumericVariable(-1, action.getCost()));

        // Initialize the parameters of the action
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, action.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, action.getTypeOfParameters(i));
        }

        if (action.isDurative()) {
            List<NumericConstraint> duration = BitEncoding.encodeNumericConstraints(action.getDuration(), numeric);
            encoded.setDurationConstraints(duration);
        }

        // Initialize the preconditions of the action
        encoded.setPrecondition(BitEncoding.encodeCondition(action.getPreconditions(), fluents, numeric));

        // Initialize the effects of the action
        final List<IntExpression> effects = action.getEffects().getChildren();

        final ConditionalEffect unCondEffects = new ConditionalEffect();
        boolean hasUnConditionalEffects = false;
        for (IntExpression ei : effects) {
            final PDDLConnective connective = ei.getConnective();
            final List<IntExpression> children = ei.getChildren();
            switch (connective) {
                case WHEN:
                    // NumericAssignement not encoded in conditional effect.
                    final ConditionalEffect condBitExp = new ConditionalEffect();
                    condBitExp.setCondition(BitEncoding.encodeCondition(children.get(0), fluents, numeric));
                    condBitExp.setEffect(BitEncoding.encodeEffect(children.get(1), fluents, numeric));
                    encoded.getConditionalEffects().add(condBitExp);
                    break;
                case ATOM:
                    Integer index = fluents.get(ei);
                    if (index != null) {
                        unCondEffects.getEffect().getPositiveFluents().set(index);
                        hasUnConditionalEffects = true;
                    }
                break;
                case NOT:
                    index = fluents.get(children.get(0));
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
                    NumericAssignment assignment = BitEncoding.encodeNumericAssignment(ei, numeric);
                    unCondEffects.getEffect().addNumericAssignment(assignment);
                    break;
                default:
                    throw new UnexpectedExpressionException(Encoder.toString(ei));
            }
        }
        if (hasUnConditionalEffects) {
            encoded.getConditionalEffects().add(unCondEffects);
        }
        return encoded;
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
        encoded.setPrecondition(BitEncoding.encodeCondition(method.getPreconditions(), factMap, new HashMap<>()));
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
    static Goal encodeGoal(IntExpression goal, final Map<IntExpression, Integer> map)
        throws UnexpectedExpressionException {

        if (goal.getConnective().equals(PDDLConnective.FALSE)) {
            return null;
        }

        Goal newGoal;
        BitEncoding.toDNF(goal);
        Encoder.codedGoal = new ArrayList<>(goal.getChildren().size());
        for (IntExpression exp : goal.getChildren()) {
            if (exp.getConnective().equals(PDDLConnective.ATOM)) {
                IntExpression and = new IntExpression(PDDLConnective.AND);
                and.getChildren().add(exp);
                Encoder.codedGoal.add(new Goal(BitEncoding.encodeCondition(and, map, new HashMap<>())));
            } else {
                Encoder.codedGoal.add(new Goal(BitEncoding.encodeCondition(exp, map, new HashMap<>())));
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
            Effect effect = new Effect();
            effect.getPositiveFluents().set(dummyGoalIndex);
            newGoal = new Goal();
            effect.getPositiveFluents().set(dummyGoalIndex);
            final ConditionalEffect condEffect = new ConditionalEffect(effect);
            // for each disjunction create a dummy action
            for (Condition dis : Encoder.codedGoal) {
                final Action op = new Action(Constants.DUMMY_OPERATOR, 0);
                op.setDummy(true);
                op.setPrecondition(dis);
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
     * @param fluentMap  the map that associates to a specified expression its index.
     * @return the <code>BitExp</code> that represents the initial encoded.
     */
    static InitialState encodeInit(final Set<IntExpression> init, final Map<IntExpression, Integer> fluentMap) {
        final InitialState bitInit = new InitialState();
        for (final IntExpression fact : init) {
            switch (fact.getConnective()) {
                case ATOM:
                    Integer i = fluentMap.get(fact);
                    if (i != null) {
                        bitInit.getPositiveFluents().set(i);
                    }
                    break;
                case NOT:
                    i = fluentMap.get(fact.getChildren().get(0));
                    if (i != null) {
                        bitInit.getNegativeFluents().set(i);
                    }
                    break;
            }
        }

        return bitInit;
    }

    /**
     *
     */
    static void encodeInitNumericFluent(InitialState init, final Map<IntExpression, Integer> numericFluentMap,
                                        final Map<IntExpression, Double> initValue) {
        for (Map.Entry<IntExpression, Integer> e : numericFluentMap.entrySet()) {
            int index = e.getValue();
            double value = initValue.get(e.getKey());
            NumericVariable fluent = new NumericVariable(index, value);
            init.addNumericFluent(fluent);
        }
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @param map the map that associate to a specified expression its index.
     * @return the expression in bit set representation.
     */
    private static Condition encodeCondition(final IntExpression exp,
                                             final Map<IntExpression, Integer> map,
                                             final Map<IntExpression, Integer> numeric)
        throws UnexpectedExpressionException {
        final Condition condition = new Condition();
        switch (exp.getConnective()) {
            case ATOM:
                condition.getPositiveFluents().set(map.get(exp));
                break;
            case NOT:
                condition.getNegativeFluents().set(map.get(exp.getChildren().get(0)));
                break;
            case AND:
                for (IntExpression e : exp.getChildren()) {
                    Condition ce = BitEncoding.encodeCondition(e, map, numeric);
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
                condition.getNumericConstraints().add(BitEncoding.encodeNumericConstraint(exp, numeric));
                break;
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return condition;
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @param map the map that associate to a specified expression its index.
     * @return the expression in bit set representation.
     */
    private static Effect encodeEffect(final IntExpression exp, final Map<IntExpression, Integer> map, final Map<IntExpression, Integer> numericIndex)
        throws UnexpectedExpressionException {
        final Effect effect = new Effect();
        switch (exp.getConnective()) {
            case ATOM:
                Integer index = map.get(exp);
                if (index != null) {
                    effect.getPositiveFluents().set(index);
                }
                break;
            case NOT:
                index = map.get(exp.getChildren().get(0));
                if (index != null) {
                    effect.getNegativeFluents().set(index);
                }
                break;
            case AND:
                final List<IntExpression> children = exp.getChildren();
                for (IntExpression ei : children) {
                    switch (ei.getConnective()) {
                        case ATOM:
                        index = map.get(ei);
                            if (index != null) {
                                effect.getPositiveFluents().set(index);
                            }
                            break;
                        case NOT:
                            index = map.get(ei.getChildren().get(0));
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
                            NumericAssignment assignment = BitEncoding.encodeNumericAssignment(ei, numericIndex);
                            effect.addNumericAssignment(assignment);
                            break;
                        default:
                            throw new UnexpectedExpressionException(Encoder.toString(exp));
                    }
                }
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                NumericAssignment assignment = BitEncoding.encodeNumericAssignment(exp, numericIndex);
                effect.addNumericAssignment(assignment);
                break;
            case TRUE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
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
     static void toCNF(final IntExpression exp) throws UnexpectedExpressionException {
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
                    newWhen.getChildren().add(new IntExpression(consequence));
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
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
    }

    /**
     * Convert an expression in disjunctive normal form (DNF).
     *
     * @param exp the expression to transform in DNF.
     */
     static void toDNF(final IntExpression exp) throws UnexpectedExpressionException {
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
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @return the expression in bit set representation.
     */
    static List<NumericConstraint> encodeNumericConstraints(final IntExpression exp, final Map<IntExpression, Integer> indexMap)
        throws UnexpectedExpressionException {

        final List<NumericConstraint> constraints = new ArrayList<>();
        switch (exp.getConnective()) {
            case AND:
                for (IntExpression e : exp.getChildren()) {
                    constraints.addAll(BitEncoding.encodeNumericConstraints(e, indexMap));
                }
                break;
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
                constraints.add(BitEncoding.encodeNumericConstraint(exp, indexMap));
                break;
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return constraints;
    }

    /**
     * Encodes a numeric constraint.
     */
    static NumericConstraint encodeNumericConstraint(final IntExpression exp,
                                                     final Map<IntExpression, Integer> indexMap) {

        ArithmeticExpression left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), indexMap);
        ArithmeticExpression right = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), indexMap);
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
     * @param exp the expression to encode.
     */
    static ArithmeticExpression encodeArithmeticExpression(final IntExpression exp,
                                                           final Map<IntExpression, Integer> indexMap) {

        ArithmeticExpression arithmeticExpression;
        ArithmeticExpression left;
        ArithmeticExpression right;
        switch (exp.getConnective()) {
            case PLUS:
                left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), indexMap);
                right = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), indexMap);
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.PLUS, left, right);
                break;
            case MINUS:
                left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), indexMap);
                right = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), indexMap);
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.MINUS, left, right);
                break;
            case UMINUS:
                left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), indexMap);
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.UMINUS, left, null);
                break;
            case DIV:
                left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), indexMap);
                right = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), indexMap);
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.DIV, left, right);
                break;
            case MUL:
                left = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), indexMap);
                right = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), indexMap);
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.MUL, left, right);
                break;
            case NUMBER:
                arithmeticExpression = new ArithmeticExpression(exp.getValue());
                break;
            case F_EXP:
                arithmeticExpression = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(0), indexMap);
                break;
            case FN_HEAD:
                arithmeticExpression = new NumericVariable(indexMap.get(exp));
                break;
            case TIME_VAR:
                arithmeticExpression = new NumericVariable(NumericVariable.DURATION);
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return arithmeticExpression;
    }

    /**
     * Encodes a numeric assignment.
     */
    static NumericAssignment encodeNumericAssignment(final IntExpression exp, Map<IntExpression, Integer> numericIndex) {

        final NumericVariable fluent = new NumericVariable(numericIndex.get(exp.getChildren().get(0)));
        final ArithmeticExpression arithmeticExpression = BitEncoding.encodeArithmeticExpression(exp.getChildren().get(1), numericIndex);
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
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return assignment;
    }
}
