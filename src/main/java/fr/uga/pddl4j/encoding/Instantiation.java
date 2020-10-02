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

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * This class contains the methods needed to instantiate the actions and the method.
 * <p>
 * Revisions:
 * <ul>
 * <li>30/03/2020: Add method instantiation.</li>
 * <li>15/06/2020: allow operator instantiation with same parameter.</li>
 * </ul>
 * </p>
 *
 * @author D. Pellier
 * @version 1.1 - 07.04.2010
 */
final class Instantiation implements Serializable {

    /**
     * The default constructor with a private access to prevent instance creation.
     */
    private Instantiation() {
    }

    /**
     * Instantiates a specified list of actions.
     *
     * @param actions the list of actions to instantiate.
     * @return the list of instantiated actions.
     */
    static List<IntAction> instantiateActions(final List<IntAction> actions) {
        final List<IntAction> instActions = new ArrayList<>(Constants.DEFAULT_ACTION_TABLE_SIZE);
        for (IntAction a : actions) {
            // If an action has a parameter with a empty domain the action must be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < a.arity() && toInstantiate) {
                toInstantiate = !Encoder.tableOfDomains.get(a.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (toInstantiate) {
                instActions.addAll(Instantiation.instantiate(a));
            }
        }
        return instActions;
    }

    /**
     * Instantiates a specified action.
     *
     * @param action the action to instantiate.
     * @param bound  the bound of actions to instantiate.
     * @return the list of actions instantiated corresponding the specified action.
     */
    static List<IntAction> instantiate(final IntAction action, final int bound) {
        final List<IntAction> instOps = new ArrayList<>(100);
        Instantiation.expandQuantifiedExpression(action.getPreconditions());
        Instantiation.simplify(action.getPreconditions());
        if (!action.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
            Instantiation.expandQuantifiedExpression(action.getEffects());
            Instantiation.simplify(action.getEffects());
            if (!action.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                Instantiation.instantiate(action, 0, bound, instOps);
            }
        }
        return instOps;
    }

    /**
     * Instantiates a specified action.
     *
     * @param action the action to instantiate.
     * @return the list of actions instantiated corresponding the specified action.
     */
    static List<IntAction> instantiate(final IntAction action) {
        return Instantiation.instantiate(action, Integer.MAX_VALUE);
    }


    /**
     * Instantiates a specified action.
     * <p>
     * The assumption is made that different action parameters are instantiated with different
     * constants, i.e., the planner never generates actions like move(a,a) because we consider this
     * as a bad domain representation that should be revised. In fact, in actions with identical
     * constant parameters, all but one of the constants are superfluous and can be skipped from the
     * representation without loss of information. Warning this assumption make the process no-sound.
     * </p>
     *
     * @param action  the action.
     * @param index   the index of the parameter to instantiate.
     * @param bound   the bound of actions to instantiate.
     * @param actions the list of actions already instantiated.
     * @see IntAction
     */
    private static void instantiate(final IntAction action, final int index, final int bound,
                                    final List<IntAction> actions) {
        if (bound == actions.size()) {
            return;
        }
        final int arity = action.arity();
        if (index == arity) {
            final IntExpression precond = action.getPreconditions();
            Instantiation.simplify(precond);
            if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                final IntExpression effect = action.getEffects();
                Instantiation.simplify(effect);
                if (!effect.getConnective().equals(PDDLConnective.FALSE)) {
                    actions.add(action);
                }
            }
        } else {
            final Set<Integer> values = Encoder.tableOfDomains.get(action.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntExpression precond = new IntExpression(action.getPreconditions());
                Instantiation.substitute(precond, varIndex, value);
                if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntExpression effects = new IntExpression(action.getEffects());
                    Instantiation.substitute(effects, varIndex, value);
                    if (!effects.getConnective().equals(PDDLConnective.FALSE)) {
                        final IntAction copy = new IntAction(action.getName(), arity);
                        copy.setPreconditions(precond);
                        copy.setEffects(effects);
                        for (int i = 0; i < arity; i++) {
                            copy.setTypeOfParameter(i, action.getTypeOfParameters(i));
                        }
                        for (int i = 0; i < index; i++) {
                            copy.setValueOfParameter(i, action.getValueOfParameter(i));
                        }
                        copy.setValueOfParameter(index, value);
                        Instantiation.instantiate(copy, index + 1, bound, actions);
                    }
                }
            }
        }
    }

    /**
     * Instantiates a specified task network.
     *
     * @param network the task network to instantiate.
     * @return the list of task netwok instantiated corresponding the specified network.
     */
    static List<IntTaskNetwork> instantiate(final IntTaskNetwork network) {
        final List<IntTaskNetwork> instNetwork = new ArrayList<>(100);
        Instantiation.instantiate(network, 0, instNetwork);
        return instNetwork;
    }

    /**
     * Instantiates a specified task network.
     *
     * @param network  the action.
     * @param index   the index of the parameter to instantiate.
     * @param networks the list of tasknetwork already instantiated.
     * @see IntAction
     */
    private static void instantiate(final IntTaskNetwork network, final int index,
                                    final List<IntTaskNetwork> networks) {

        final int arity = network.arity();
        if (index == arity) {
             networks.add(network);
        } else {
            final Set<Integer> values = Encoder.tableOfDomains.get(network.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntTaskNetwork copy = new IntTaskNetwork(arity);
                copy.setOrderingConstraints(new IntExpression(network.getOrderingConstraints()));

                final IntExpression tasksCopy = new IntExpression(network.getTasks());
                Instantiation.substitute(tasksCopy, varIndex, value);
                copy.setTasks(tasksCopy);

                for (int i = 0; i < arity; i++) {
                    copy.setTypeOfParameter(i, network.getTypeOfParameters(i));
                }
                for (int i = 0; i < arity; i++) {
                    copy.setValueOfParameter(i, network.getValueOfParameter(i));
                }

                copy.setValueOfParameter(index, value);
                Instantiation.instantiate(copy, index + 1, networks);
            }
        }
    }


    /**
     * Instantiates a specified method. This method used brut force.
     * <p>
     * The assumption is made that different method parameters are instantiated with different
     * constants, i.e., the planner never generates methods like move(a,a) because we consider this
     * as a bad domain representation that should be revised. In fact, in methods with identical
     * constant parameters, all but one of the constants are superfluous and can be skipped from the
     * representation without loss of information. Warning this assumption make the process no-sound.
     * </p>
     *
     * @param method  the method.
     * @param index   the index of the parameter to instantiate.
     * @param bound   the bound of methods to instantiate.
     * @param methods the list of methods already instantiated.
     * @see IntMethod
     */
    private static void instantiate(final IntMethod method, final int index, final int bound,
                                    final List<IntMethod> methods) {
        if (bound == methods.size()) {
            return;
        }
        final int arity = method.arity();
        if (index == arity) {
            final IntExpression precond = method.getPreconditions();
            Instantiation.simplify(precond);
            if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                methods.add(method);
            }
        } else if (method.getValueOfParameter(index) >= 0) {
            Instantiation.instantiate(method, index + 1, bound, methods);
        } else {
            final Set<Integer> values = Encoder.tableOfDomains.get(method.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntExpression preconditionCopy = new IntExpression(method.getPreconditions());

                Instantiation.substitute(preconditionCopy, varIndex, value);
                if (!preconditionCopy.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntMethod copy = new IntMethod(method.getName(), arity);
                    copy.setPreconditions(preconditionCopy);
                    copy.setOrderingConstraints(new IntExpression(method.getOrderingConstraints()));

                    final IntExpression taskCopy = new IntExpression(method.getTask());
                    Instantiation.substitute(taskCopy, varIndex, value);
                    copy.setTask(taskCopy);

                    final IntExpression subTasksCopy = new IntExpression(method.getSubTasks());
                    Instantiation.substitute(subTasksCopy, varIndex, value);
                    copy.setSubTasks(subTasksCopy);

                    for (int i = 0; i < arity; i++) {
                        copy.setTypeOfParameter(i, method.getTypeOfParameters(i));
                    }
                    for (int i = 0; i < arity; i++) {
                        copy.setValueOfParameter(i, method.getValueOfParameter(i));
                    }

                    copy.setValueOfParameter(index, value);
                    Instantiation.instantiate(copy, index + 1, bound, methods);
                }
            }
        }
    }

    /**
     * Make the preinstantion of a method based on the argument used in the tasks accomplish by the method.
     *
     * @param method the method to instantiate.
     * @param index  the index of the parameter to instantiate. Initially, the index is set to 0.
     * @param bound  a bound on the number of methods to instantiate.
     * @param task   the tasks that accomplish the method.
     */
    private static void instantiate(final IntMethod method, final int index, final int bound,
                                    final List<IntMethod> methods, final IntExpression task) {
        final IntExpression t = method.getTask();
        final IntMethod copy = new IntMethod(method);
        for (int i = 0; i < t.getArguments().length; i++) {
            final int var = t.getArguments()[i];
            final int cons = task.getArguments()[i];
            Instantiation.substitute(copy.getPreconditions(), var, cons);
            Instantiation.substitute(copy.getTask(), var, cons);
            Instantiation.substitute(copy.getSubTasks(), var, cons);
            copy.setValueOfParameter((-var - 1), cons);
        }
        // This case may occur when variables are identical in the tasks
        if (copy.getTask().equals(task)) {
            Instantiation.instantiate(copy, index, bound, methods);
        }
    }

    /**
     * Make the instantiation of a list of methods.
     *
     * @param methods             the method to instantiate.
     * @param initialTasksNetwork the initial tasks network.
     * @param actions             the list of action already instantiate.
     */
    static List<IntMethod> instantiateMethods(List<IntMethod> methods, IntTaskNetwork initialTasksNetwork,
                                              List<IntAction> actions) {

        // Init the list of instantiated methods or ground methods
        final List<IntMethod> instMethods = new ArrayList<>(Constants.DEFAULT_METHOD_TABLE_SIZE);

        // Init the set used to store the compound tasks
        final Set<IntExpression> compound = new LinkedHashSet<>();

        // Init the set used to store the primtive tasks
        final Set<IntExpression> primtive = new LinkedHashSet<>();

        // Init the table used to store for each task the list of methods that are relevant
        Encoder.relevantMethods = new ArrayList<List<Integer>>();

        // Init the list of methods to instantiate
        List<IntMethod> meths = new ArrayList<>();
        for (IntMethod m : methods) {
            // If a method has a parameter with a empty domain the method must be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < m.arity() && toInstantiate) {
                toInstantiate = !Encoder.tableOfDomains.get(m.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (toInstantiate) {
                meths.add(m);
            }
        }

        // Filter methods with a parameter with an empty domain
        Instantiation.filterMethodWithEmptyDomainParameter(methods);

        // Expand the quantified expression contains in the the method precondition
        Instantiation.expandQuantifiedExpressionAndSimplyMethods(meths);

        // Compute the set of primitive task from the action already instantiated
        LinkedHashSet<IntExpression> primitiveTaskSet = Instantiation.computePrimitiveTaskSet(actions);

        // TInit the list of pending tasks to decompose
        final LinkedList<IntExpression> tasks = new LinkedList<>();

        // Add the task of the initial task network with the compound tasks
        for (IntExpression subtasks : initialTasksNetwork.getTasks().getChildren()) {
            if (!tasks.contains(subtasks)) {
                if (!subtasks.isPrimtive()) {
                    tasks.add(subtasks);
                    compound.add(subtasks);
                } else {
                    primtive.add(subtasks);
                }
            }
        }

        // Start exploring the task tree
        int indexMethod = 0;
        while (!tasks.isEmpty()) {
            final IntExpression task = tasks.pop();
            final List<IntMethod> relevant = new ArrayList<>();
            final List<Integer> relevantIndex = new ArrayList<>();
            for (IntMethod method : meths) {
                if (method.getTask().getPredicate() == task.getPredicate()) {
                    final List<IntMethod> instantiated = new ArrayList<>(100);
                    Instantiation.instantiate(method, 0, Integer.MAX_VALUE, instantiated, task);
                    for (IntMethod instance : instantiated) {
                        final Iterator<IntExpression> i = instance.getSubTasks().getChildren().iterator();
                        final Set<IntExpression> primitiveSet = new LinkedHashSet<>();
                        final Set<IntExpression> compoundSet = new LinkedHashSet<>();
                        boolean stop = false;
                        while (i.hasNext() && !stop) {
                            final IntExpression subtask = i.next();
                            if (subtask.isPrimtive()) {
                                if (!primitiveTaskSet.contains(subtask)) {
                                    stop = true;
                                } else {
                                    primitiveSet.add(subtask);
                                }
                            } else {
                                if (!compound.contains(subtask)) {
                                    compoundSet.add(subtask);
                                }
                            }
                        }
                        if (!stop) {
                            primtive.addAll(primitiveSet);
                            tasks.addAll(compoundSet);
                            compound.addAll(compoundSet);
                            relevant.add(instance);
                            relevantIndex.add(indexMethod);
                            indexMethod++;
                        }
                    }
                }
            }

            Encoder.relevantMethods.add(relevantIndex);
            instMethods.addAll(relevant);
        }

        // Initialize the table of relevant methods for each compund task and the table of relevant compound tasks
        Encoder.tableOfRelevantCompundTasks = new ArrayList<>(compound.size());
        Encoder.tableOfRelevantCompundTasks.addAll(compound);

        // Initialize the table of relevant actions for each primitive task and the table of relevant primitive tasks
        Encoder.relevantActions = new ArrayList<Integer>(primitiveTaskSet.size());
        Encoder.tableOfRelevantPrimitiveTasks = new ArrayList<>(primitiveTaskSet.size());
        int index = 0;
        Iterator<IntExpression> i = primitiveTaskSet.iterator();
        while (i.hasNext()) {
            // The action at index i can be remove because it not reachable from the initial task network.
            IntExpression primitiveTask = i.next();
            if (!primtive.contains(primitiveTask)) {
                actions.remove(index);
                i.remove();
            } else {
                Encoder.relevantActions.add(index);
                Encoder.tableOfRelevantPrimitiveTasks.add(primitiveTask);
                index++;
            }
        }

        return instMethods;
    }

    /**
     * Computes the list of possible primitive tasks from the action already instantiated.
     *
     * @param actions the list of actions altready instantiated.
     * @return the list of possible primitive tasks from the action already instantiated.
     */
    private static LinkedHashSet<IntExpression> computePrimitiveTaskSet(List<IntAction> actions) {
        LinkedHashSet<IntExpression> tasks = new LinkedHashSet<>();
        for (IntAction a : actions) {
            IntExpression task = new IntExpression(PDDLConnective.TASK);
            task.setPrimtive(true);
            task.setPredicate(Encoder.tableOfTasks.indexOf(a.getName()));
            task.setArguments(a.getInstantiations());
            tasks.add(task);
        }
        return tasks;

    }

    /**
     * Expands the quantified expression contained in the preconditions of the methods in parameter and simplify the
     * their precondition. If the preconditions can be simplied to false, the method simplified is removed.
     *
     * @param methods the list of methods to process.
     */
    private static void expandQuantifiedExpressionAndSimplyMethods(List<IntMethod> methods) {
        final Iterator<IntMethod> i = methods.iterator();
        while (i.hasNext()) {
            final IntMethod method = i.next();
            Instantiation.expandQuantifiedExpression(method.getPreconditions());
            Instantiation.simplify(method.getPreconditions());
            if (method.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                i.remove();
            }
        }
    }

    /**
     * Filter methods with a parameter with a empty domain.
     *
     * @param methods the list of methods to filter.
     */
    private static void filterMethodWithEmptyDomainParameter(List<IntMethod> methods) {
        Iterator<IntMethod> it = methods.iterator();
        while (it.hasNext()) {
            final IntMethod method = it.next();
            // If an method has a parameter with a empty domain the method can be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < method.arity() && toInstantiate) {
                toInstantiate = !Encoder.tableOfDomains.get(method.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (!toInstantiate) {
                it.remove();
            }
        }
    }

    /**
     * Expands the quantified expressions contained in a specified expression.
     *
     * @param exp the expression.
     */
    static void expandQuantifiedExpression(final IntExpression exp) {
        switch (exp.getConnective()) {
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    // Remove quantified expression where the domain of the quantified variable is empty
                    if ((ei.getConnective().equals(PDDLConnective.FORALL)
                        || ei.getConnective().equals(PDDLConnective.EXISTS))
                        && Encoder.tableOfDomains.get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    Instantiation.expandQuantifiedExpression(ei);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
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
                        && Encoder.tableOfDomains.get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    Instantiation.expandQuantifiedExpression(ei);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case FORALL:
                Set<Integer> constants = Encoder.tableOfDomains.get(exp.getType());
                IntExpression qExp = exp.getChildren().get(0);
                int var = exp.getVariable();
                exp.setConnective(PDDLConnective.AND);
                exp.getChildren().clear();
                Iterator<Integer> it = constants.iterator();
                while (it.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    int cons = it.next();
                    IntExpression copy = new IntExpression(qExp);
                    Instantiation.substitute(copy, var, cons);
                    exp.getChildren().add(copy);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (copy.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    }
                }
                Instantiation.expandQuantifiedExpression(exp);
                break;
            case EXISTS:
                constants = Encoder.tableOfDomains.get(exp.getType());
                qExp = exp.getChildren().get(0);
                var = exp.getVariable();
                exp.setConnective(PDDLConnective.OR);
                exp.getChildren().clear();
                it = constants.iterator();
                while (it.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    int cons = it.next();
                    IntExpression copy = new IntExpression(qExp);
                    Instantiation.substitute(copy, var, cons);
                    exp.getChildren().add(copy);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    if (copy.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                Instantiation.expandQuantifiedExpression(exp);
                break;

            case AT_START:
            case AT_END:
            case NOT:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(0));
                break;
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case WHEN:
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(0));
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(1));
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(0));
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(1));
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(3));
                break;
            case ATOM:
                Instantiation.simplyAtom(exp);
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
    private static void simplify(final IntExpression exp) {
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
                    Instantiation.simplify(ei);
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
                    Instantiation.simplify(ei);
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
                Instantiation.simplify(exp.getChildren().get(0));
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                Instantiation.simplify(neg);
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
            case F_EXP:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
                Instantiation.simplify(exp.getChildren().get(0));
                Instantiation.simplify(exp.getChildren().get(1));
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    Instantiation.simplify(exp.getChildren().get(0));
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                Instantiation.simplify(exp.getChildren().get(0));
                Instantiation.simplify(exp.getChildren().get(1));
                Instantiation.simplify(exp.getChildren().get(3));
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
     * Substitutes all occurrence of a specified variable into an expression by a constant.
     *
     * @param exp  the expression.
     * @param var  the variable.
     * @param cons the constant.
     */
    private static void substitute(final IntExpression exp, final int var, final int cons) {
        switch (exp.getConnective()) {
            case ATOM:
                boolean updated = false;
                int[] args = exp.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                        updated = true;
                    }
                }
                if (updated) {
                    Instantiation.simplyAtom(exp);
                }
                break;
            case TASK:
                args = exp.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                        updated = true;
                    }
                }
                break;
            case FN_HEAD:
                args = exp.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                    }
                }
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
                    Instantiation.substitute(ei, var, cons);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    }
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    Instantiation.substitute(ei, var, cons);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                Instantiation.substitute(neg, var, cons);
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
            case F_EXP:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
                Instantiation.substitute(exp.getChildren().get(0), var, cons);
                Instantiation.substitute(exp.getChildren().get(1), var, cons);
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
                Instantiation.substitute(exp.getChildren().get(0), var, cons);
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    Instantiation.substitute(exp.getChildren().get(0), var, cons);
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                Instantiation.substitute(exp.getChildren().get(0), var, cons);
                Instantiation.substitute(exp.getChildren().get(1), var, cons);
                Instantiation.substitute(exp.getChildren().get(3), var, cons);
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
    private static void simplyAtom(final IntExpression exp) {
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
        final List<Integer> predArg = Encoder.tableOfTypedPredicates.get(predicate);
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 0) {
                max *= Encoder.tableOfDomains.get(predArg.get(i)).size();
            } else {
                index[j] = args[i];
                j++;
            }

        }
        // Get the number of unifying ground instances of the specified expression that are
        // contained in the initial state.
        final int n = Encoder.predicatesTables.get(predicate).get(PreInstantiation.toInt(mask)).get(index);
        // CASE 1: If the expression is a positive inertia and the number of unifying ground
        // instances of the specified expression that are contained in the initial state is equal to
        // 0 then the expression is simplified to FALSE.
        final Inertia inertia = Encoder.tableOfInertia.get(predicate);
        if ((inertia.equals(Inertia.POSITIVE) || inertia.equals(Inertia.INERTIA)) && n == 0) {
            exp.setConnective(PDDLConnective.FALSE);
        } else if ((inertia.equals(Inertia.NEGATIVE) || inertia.equals(Inertia.INERTIA)) && max == n) {
            // CASE 2: If the expression is a negative inertia and then the number of all possible
            // type-consistent ground instances of the specified expression then the expression is
            // simplified to TRUE.
            exp.setConnective(PDDLConnective.TRUE);
        }
    }

}
