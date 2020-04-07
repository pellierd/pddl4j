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

import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.problem.*;
import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.util.BitMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    static List<Action> encodeActions(final List<IntAction> actions, final Map<IntExpression, Integer> map)
        throws UnexpectedExpressionException {

        // Normalize the actions
        BitEncoding.normalizeActions(actions);

        final List<Action> encodedActions = new ArrayList<>(actions.size());
        for (IntAction intAction : actions) {
            final int arity = intAction.getArity();
            final Action a = new Action(intAction.getName(), arity);
            a.setCost(intAction.getCost());

            // Initialize the parameters of the action
            for (int i = 0; i < arity; i++) {
                a.setValueOfParameter(i, intAction.getValueOfParameter(i));
                a.setTypeOfParameter(i, intAction.getTypeOfParameters(i));
            }

            // Initialize the preconditions of the action
            a.setPreconditions(BitEncoding.encode(intAction.getPreconditions(), map));

            // Initialize the effects of the action
            final List<IntExpression> effects = intAction.getEffects().getChildren();

            final ConditionalEffect unCondEffects = new ConditionalEffect();
            boolean hasUnConditionalEffects = false;
            for (IntExpression ei : effects) {
                final PDDLConnective connective = ei.getConnective();
                final List<IntExpression> children = ei.getChildren();
                if (connective.equals(PDDLConnective.WHEN)) {
                    final ConditionalEffect condBitExp = new ConditionalEffect();
                    condBitExp.setCondition(BitEncoding.encode(children.get(0), map));
                    condBitExp.setEffects(BitEncoding.encode(children.get(1), map));
                    a.getCondEffects().add(condBitExp);
                } else if (connective.equals(PDDLConnective.ATOM)) {
                    final Integer index = map.get(ei);
                    if (index != null) {
                        unCondEffects.getEffects().getPositive().set(index);
                        hasUnConditionalEffects = true;
                    }
                } else if (connective.equals(PDDLConnective.TRUE)) {
                    // do nothing
                } else if (connective.equals(PDDLConnective.NOT)) {
                    final Integer index = map.get(children.get(0));
                    if (index != null) {
                        unCondEffects.getEffects().getNegative().set(index);
                        hasUnConditionalEffects = true;
                    }
                } else {
                    throw new UnexpectedExpressionException(Encoder.toString(ei));
                }
            }
            if (hasUnConditionalEffects) {
                a.getCondEffects().add(unCondEffects);
            }
            encodedActions.add(a);
        }
        return encodedActions;
    }

    /**
     * Encode a list of specified methods into the final compact representation. The specified
     * maps are used to speed-up the search by mapping the an expression to this index.
     *
     * @param methods the list of methods to encode.
     * @param factMap       the map that associates at a specified fact its index in the table of relevant facts.
     * @param taskMap       the map that associates at a specified task its index in the table of relevant tasks.
     * @return the list of methods encoded into final compact representation.
     */
    static List<Method> encodeMethods(final List<IntMethod> methods, final Map<IntExpression, Integer> factMap,
                                      final Map<IntExpression, Integer> taskMap) throws UnexpectedExpressionException {

        // Normalize the methods
        BitEncoding.normalizeMethods(methods);
        // Start encoding
        final List<Method> encodedMethods = new ArrayList<>(methods.size());
        for (IntMethod intMethod : methods) {
            final int arity = intMethod.getArity();
            final Method m = new Method(intMethod.getName(), arity);
            // Initialize the parameters of the method
            for (int i = 0; i < arity; i++) {
                m.setValueOfParameter(i, intMethod.getValueOfParameter(i));
                m.setTypeOfParameter(i, intMethod.getTypeOfParameters(i));
            }
            // Encode the task carried out by the method
            m.setTask(taskMap.get(intMethod.getTask()));
            // Encode the preconditions of the method
            m.setPreconditions(BitEncoding.encode(intMethod.getPreconditions(), factMap));
            // Encode the task network of the method
            m.setTaskNetwork(BitEncoding.encodeTaskNetwork(intMethod.getTaskNetwork(), taskMap));
            encodedMethods.add(m);
        }
        return encodedMethods;
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
    static State encodeGoal(IntExpression goal, final Map<IntExpression, Integer> map) throws UnexpectedExpressionException {
        if (goal.getConnective().equals(PDDLConnective.FALSE)) {
            return null;
        }

        State newGoal;
        BitEncoding.toDNF(goal);
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
            final int dummyGoalIndex = Encoder.tableOfRelevantFacts.size();
            Encoder.tableOfRelevantFacts.add(dummyGoal);
            map.put(dummyGoal, dummyGoalIndex);
            newGoal = new State();
            newGoal.getPositive().set(dummyGoalIndex);
            final ConditionalEffect condEffect = new ConditionalEffect(newGoal);
            // for each disjunction create a dummy action
            for (State dis : Encoder.codedGoal) {
                final Action op = new Action(Constants.DUMMY_OPERATOR, 0);
                op.setDummy(true);
                op.setPreconditions(dis);
                op.getCondEffects().add(condEffect);
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
     * @param map  the map that associates to a specified expression its index.
     * @return a list of <code>BitExp</code> that represents the goal as a disjunction of
     * <code>BitExp</code>.
     */
    static TaskNetwork encodeTaskNetwork(IntTaskNetwork taskNetwork, final Map<IntExpression, Integer> map) {
        // We encode first the tasks
        List<Integer> encodedTasks = new ArrayList<Integer>();
        BitEncoding.encodeTasks(taskNetwork.getTasks(), map, encodedTasks);
        int[] tasks = new int[encodedTasks.size()];
        for (int i = 0 ; i < encodedTasks.size(); i++) {
            tasks[i] = encodedTasks.get(i);
        }
        // We encode then the ordering constraints
        BitMatrix constraints = new BitMatrix(tasks.length, tasks.length);
        for (IntExpression c : taskNetwork.getOrderingConstraints().getChildren()) {
            constraints.set(c.getChildren().get(0).getTaskID(), c.getChildren().get(1).getTaskID());
            //constraints.set(c.getChildren().get(1).getTaskID(), c.getChildren().get(0).getTaskID());
        }
        return new TaskNetwork(tasks, constraints);
    }

    /**
     * Encode the list of tasks expressed as an IntExpression into a list of integer.
     *
     * @param exp the list of tasks expressed as an IntExpression.
     * @param map the map containing the index associated to the tasks.
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
        final State bitExp = new State();
        if (exp.getConnective().equals(PDDLConnective.ATOM)) {
            final Integer index = map.get(exp);
            if (index != null) {
                bitExp.getPositive().set(index);
            }
        } else if (exp.getConnective().equals(PDDLConnective.NOT)) {
            final Integer index = map.get(exp.getChildren().get(0));
            if (index != null) {
                bitExp.getNegative().set(index);
            }
        } else if (exp.getConnective().equals(PDDLConnective.AND)) {
            final List<IntExpression> children = exp.getChildren();
            for (IntExpression ei : children) {
                if (ei.getConnective().equals(PDDLConnective.ATOM)) {
                    final Integer index = map.get(ei);
                    if (index != null) {
                        bitExp.getPositive().set(index);
                    }
                } else if (ei.getConnective().equals(PDDLConnective.NOT)) {
                    final Integer index = map.get(ei.getChildren().get(0));
                    if (index != null) {
                        bitExp.getNegative().set(index);
                    }
                } else if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                    // do nothing
                } else {
                    throw new UnexpectedExpressionException(Encoder.toString(exp));
                }
            }
        } else {
            LOGGER.error(Encoder.toString(exp));
            throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return bitExp;
    }

    /**
     * Normalize the actions, i.e, put in disjunctive normal form (DNF) for preconditions and put
     * in conjunctive normal form (CNF) for effects. If an action has disjunctive preconditions, a
     * new operator is created such all actions after normalization have only conjunctive
     * precondition.
     *
     * @param actions the list of actions to normalizeActions.
     */
    private static void normalizeActions(final List<IntAction> actions){
        final List<IntAction> normalisedActions = new ArrayList<>(actions.size() + 100);
        for (IntAction a : actions) {
            BitEncoding.toCNF(a.getEffects());
            BitEncoding.simplify(a.getEffects());
            final IntExpression precond = a.getPreconditions();
            BitEncoding.toDNF(precond);
            if (precond.getChildren().size() > 0) {
                for (final IntExpression ei : precond.getChildren()) {
                    final String name = a.getName();
                    final int arity = a.getArity();
                    final IntAction newAction = new IntAction(name, arity);
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
                    final int arity = m.getArity();
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
