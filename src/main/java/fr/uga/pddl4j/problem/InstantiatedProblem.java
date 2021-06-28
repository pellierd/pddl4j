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
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.problem.operator.Constants;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.IntExpression;
import fr.uga.pddl4j.problem.operator.IntMethod;
import fr.uga.pddl4j.problem.operator.IntTaskNetwork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This class contains all the methods needed to the instantiate the actions and the metods of a problem.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public abstract class InstantiatedProblem extends PreInstantiatedProblem {

    /**
     * The list of relevant methods for a specific task.
     */
    private List<List<Integer>> relevantMethods;

    /**
     * The list of relevant primitive tasks.
     */
    private List<IntExpression> relevantPrimitiveTasks;

    /**
     * The list of relevant compund tasks.
     */
    private List<IntExpression> relevantCompundTasks;

    /**
     * The list of relevant action for a specific task.
     */
    private List<Integer> relevantActions;

    /**
     * Creates a new problem from a domain and problem.
     *
     * @param problem the problem.
     */
    public InstantiatedProblem(final ParsedProblem problem) {
        super(problem);
    }

    /**
     * Returns the list of relevant primitive tasks. A primitive task is relevant if it can be reach by decomposing the
     * initial tasks of the problem.
     *
     * @return the list of relevant primitive tasks.
     */
    protected List<IntExpression> getRelevantPrimitiveTasks() {
        return relevantPrimitiveTasks;
    }

    /**
     * Return the list of relevant compund tasks of the problem. A compund task is relevant if it can be reach by
     * decomposing the initial tasks of the problem.
     *
     * @return the list of relevant compund tasks of the problem.
     */
    protected List<IntExpression> getRelevantCompundTasks() {
        return relevantCompundTasks;
    }

    /**
     * Returns the list of relevant actions of the problem.
     *
     * @return the list of relevant actions of the problem.
     */
    protected List<Integer> getRelevantActions() {
        return relevantActions;
    }

    /**
     * Returns the list of relevant methods of the problem.
     *
     * @return the list of relevant methods of the problem.
     */
    protected List<List<Integer>> getRelevantMethods() {
        return relevantMethods;
    }

    /**
     * Instantiates the actions of the problem.
     */
    protected void instantiateActions() {
        final List<IntAction> instActions = new ArrayList<>(Constants.DEFAULT_ACTION_TABLE_SIZE);
        for (IntAction a : this.getIntActions()) {
            // If an action has a parameter with a empty domain the action must be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < a.arity() && toInstantiate) {
                toInstantiate = !this.getDomains().get(a.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (toInstantiate) {
                instActions.addAll(this.instantiate(a));
            }
        }
        this.getIntActions().clear();
        this.getIntActions().addAll(instActions);
    }

    /**
     * Instantiates a specified action.
     *
     * @param action the action to instantiate.
     * @param bound  the bound of actions to instantiate.
     * @return the list of actions instantiated corresponding the specified action.
     */
    private List<IntAction> instantiate(final IntAction action, final int bound) {
        final List<IntAction> instOps = new ArrayList<>(100);
        this.expandQuantifiedExpression(action.getPreconditions(), true);
        this.simplify(action.getPreconditions());
        if (!action.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
            this.expandQuantifiedExpression(action.getEffects(), true);
            this.simplify(action.getEffects());
            if (!action.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                this.instantiate(action, 0, bound, instOps);
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
    private List<IntAction> instantiate(final IntAction action) {
        return this.instantiate(action, Integer.MAX_VALUE);
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
    private void instantiate(final IntAction action, final int index, final int bound,
                                    final List<IntAction> actions) {
        if (bound == actions.size()) {
            return;
        }
        final int arity = action.arity();
        if (index == arity) {
            final IntExpression precond = action.getPreconditions();
            this.simplify(precond);
            if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                final IntExpression effect = action.getEffects();
                this.simplify(effect);
                if (!effect.getConnective().equals(PDDLConnective.FALSE)) {
                    actions.add(action);
                }
            }
        } else {
            final Set<Integer> values = this.getDomains().get(action.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntExpression precond = new IntExpression(action.getPreconditions());
                this.substitute(precond, varIndex, value, true);
                if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntExpression effects = new IntExpression(action.getEffects());
                    this.substitute(effects, varIndex, value, true);
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
                        if (action.isDurative()) {
                            final IntExpression duration = new IntExpression(action.getDuration());
                            this.substitute(duration, varIndex, value, true);
                            copy.setDuration(duration);
                        }
                        copy.setValueOfParameter(index, value);
                        this.instantiate(copy, index + 1, bound, actions);
                    }
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
    private void instantiate(final IntMethod method, final int index, final int bound,
                             final List<IntMethod> methods, final IntExpression task) {
        final IntExpression t = method.getTask();
        final IntMethod copy = new IntMethod(method);
        boolean instantiable = true;
        int i = 0;
        while (i < t.getArguments().length && instantiable) {
            final int var = t.getArguments()[i];
            final int cons = task.getArguments()[i];
            final int type = copy.getTypeOfParameters((-var - 1));
            final Set<Integer> domain = this.getDomains().get(type);
            if (domain.contains(cons)) {
                this.substitute(copy.getPreconditions(), var, cons, true);
                this.substitute(copy.getTask(), var, cons, true);
                this.substitute(copy.getSubTasks(), var, cons, true);
                copy.setValueOfParameter((-var - 1), cons);
            } else {
                instantiable = false;
            }
            i++;
        }
        // This case may occur when variables are identical in the tasks
        if (copy.getTask().equals(task) && instantiable) {
            this.instantiate(copy, index, bound, methods);
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
    private void instantiate(final IntMethod method, final int index, final int bound,
                             final List<IntMethod> methods) {
        if (bound == methods.size()) {
            return;
        }
        final int arity = method.arity();
        if (index == arity) {
            final IntExpression precond = method.getPreconditions();
            this.simplify(precond);
            if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                methods.add(method);
            }
        } else if (method.getValueOfParameter(index) >= 0) {
            this.instantiate(method, index + 1, bound, methods);
        } else {
            final Set<Integer> values = this.getDomains().get(method.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntExpression preconditionCopy = new IntExpression(method.getPreconditions());

                this.substitute(preconditionCopy, varIndex, value, true);
                if (!preconditionCopy.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntMethod copy = new IntMethod(method.getName(), arity);
                    copy.setPreconditions(preconditionCopy);
                    copy.setOrderingConstraints(new IntExpression(method.getOrderingConstraints()));

                    final IntExpression taskCopy = new IntExpression(method.getTask());
                    this.substitute(taskCopy, varIndex, value, true);
                    copy.setTask(taskCopy);

                    final IntExpression subTasksCopy = new IntExpression(method.getSubTasks());
                    this.substitute(subTasksCopy, varIndex, value, true);
                    copy.setSubTasks(subTasksCopy);

                    for (int i = 0; i < arity; i++) {
                        copy.setTypeOfParameter(i, method.getTypeOfParameters(i));
                    }
                    for (int i = 0; i < arity; i++) {
                        copy.setValueOfParameter(i, method.getValueOfParameter(i));
                    }

                    copy.setValueOfParameter(index, value);
                    this.instantiate(copy, index + 1, bound, methods);
                }
            }
        }
    }

    /**
     * Instantiates a specified task network.
     *
     * @param network  the action.
     * @param index   the index of the parameter to instantiate.
     * @param networks the list of tasknetwork already instantiated.
     * @see IntAction
     */
    private void instantiate(final IntTaskNetwork network, final int index, final List<IntTaskNetwork> networks) {

        final int arity = network.arity();
        if (index == arity) {
            networks.add(network);
        } else {
            final Set<Integer> values = this.getDomains().get(network.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntTaskNetwork copy = new IntTaskNetwork(arity);
                copy.setOrderingConstraints(new IntExpression(network.getOrderingConstraints()));

                final IntExpression tasksCopy = new IntExpression(network.getTasks());
                this.substitute(tasksCopy, varIndex, value, true);
                copy.setTasks(tasksCopy);

                for (int i = 0; i < arity; i++) {
                    copy.setTypeOfParameter(i, network.getTypeOfParameters(i));
                }
                for (int i = 0; i < arity; i++) {
                    copy.setValueOfParameter(i, network.getValueOfParameter(i));
                }

                copy.setValueOfParameter(index, value);
                this.instantiate(copy, index + 1, networks);
            }
        }
    }

    /**
     * Instantiates a specified task network.
     *
     * @param network the task network to instantiate.
     * @return the list of task netwok instantiated corresponding the specified network.
     */
    private List<IntTaskNetwork> instantiate(final IntTaskNetwork network) {
        final List<IntTaskNetwork> instNetwork = new ArrayList<>(100);
        this.instantiate(network, 0, instNetwork);
        return instNetwork;
    }

    /**
     * Instantiate the goal.
     */
    protected void instantiateGoal() {
        // Expand the quantified expression in the goal
        this.expandQuantifiedExpression(this.getIntGoal(), true);
    }

    /**
     * Instantiates the initial task network.
     */
    protected void instantiateInitialTaskNetwork() {
        final List<IntTaskNetwork> taskNetworks = this.instantiate(this.getIntInitialTaskNetwork());
        if (taskNetworks.size() > 1) {
            IntExpression root = new IntExpression(PDDLConnective.TASK);
            root.setPredicate(this.getTaskSymbols().size());
            this.getTaskSymbols().add("__top");
            this.getCompoundTaskSymbols().add("__top");
            root.setPrimtive(false);
            int index = 0;
            for (IntTaskNetwork tn : taskNetworks) {
                IntMethod method = new IntMethod("__to_method_" + index, tn.arity());
                for (int i = 0; i < tn.arity(); i++) {
                    method.setTypeOfParameter(i, tn.getTypeOfParameters(i));
                }
                for (int i = 0; i < tn.arity(); i++) {
                    method.setValueOfParameter(i, tn.getValueOfParameter(i));
                }
                method.setTask(new IntExpression(root));
                method.setPreconditions(new IntExpression(PDDLConnective.AND));
                method.setTaskNetwork(tn);
                this.getIntMethods().add(method);
                index++;
            }

            // Creates the abstract initial task network
            IntTaskNetwork newTaskNetwork = new IntTaskNetwork();
            newTaskNetwork.getTasks().addChild(new IntExpression(root));
            this.setIntInitialTaskNetwork(newTaskNetwork);
        } else {
            this.setIntInitialTaskNetwork(taskNetworks.get(0));
        }
    }

    /**
     * Instantiate the methods of the problem.
     */
    protected void instantiateMethods() {

        // Init the list of instantiated methods or ground methods
        final List<IntMethod> instMethods = new ArrayList<>(Constants.DEFAULT_METHOD_TABLE_SIZE);

        // Init the set used to store the compound tasks
        final Set<IntExpression> compound = new LinkedHashSet<>();

        // Init the set used to store the primtive tasks
        final Set<IntExpression> primtive = new LinkedHashSet<>();

        // Init the table used to store for each task the list of methods that are relevant
        this.relevantMethods = new ArrayList<List<Integer>>();

        // Init the list of methods to instantiate
        List<IntMethod> meths = new ArrayList<>();
        for (IntMethod m : this.getIntMethods()) {
            // If a method has a parameter with a empty domain the method must be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < m.arity() && toInstantiate) {
                toInstantiate = !this.getDomains().get(m.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (toInstantiate) {
                meths.add(m);
            }
        }

        // Expand the quantified expression contains in the the method precondition
        this.expandQuantifiedExpressionAndSimplyMethods(meths);

        // Compute the set of primitive task from the action already instantiated
        LinkedHashSet<IntExpression> primitiveTaskSet = this.computePrimitiveTaskSet(this.getIntActions());

        // TInit the list of pending tasks to decompose
        final LinkedList<IntExpression> tasks = new LinkedList<>();

        // Add the task of the initial task network with the compound tasks
        for (IntExpression subtasks : this.getIntInitialTaskNetwork().getTasks().getChildren()) {
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
                if (method.getTask().getPredicate() == task.getPredicate()
                    && method.getTask().getArguments().length == task.getArguments().length) {
                    final List<IntMethod> instantiated = new ArrayList<>(100);
                    this.instantiate(method, 0, Integer.MAX_VALUE, instantiated, task);
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

            this.relevantMethods.add(relevantIndex);
            instMethods.addAll(relevant);
        }

        // Initialize the table of relevant methods for each compund task and the table of relevant compound tasks
        this.relevantCompundTasks = new ArrayList<>(compound.size());
        this.relevantCompundTasks.addAll(compound);

        // Initialize the table of relevant actions for each primitive task and the table of relevant primitive tasks
        this.relevantActions = new ArrayList<Integer>(primitiveTaskSet.size());
        this.relevantPrimitiveTasks = new ArrayList<>(primitiveTaskSet.size());
        int index = 0;
        Iterator<IntExpression> i = primitiveTaskSet.iterator();
        while (i.hasNext()) {
            // The action at index i can be remove because it not reachable from the initial task network.
            IntExpression primitiveTask = i.next();
            if (!primtive.contains(primitiveTask)) {
                this.getIntActions().remove(index);
                i.remove();
            } else {
                this.relevantActions.add(index);
                this.relevantPrimitiveTasks.add(primitiveTask);
                index++;
            }
        }
        this.getIntMethods().clear();
        this.getIntMethods().addAll(instMethods);
    }

    /**
     * Filter methods with a parameter with a empty domain.
     *
     * @param methods the list of methods to filter.
     */
    private void filterMethodWithEmptyDomainParameter(List<IntMethod> methods) {
        Iterator<IntMethod> it = methods.iterator();
        while (it.hasNext()) {
            final IntMethod method = it.next();
            // If an method has a parameter with a empty domain the method can be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < method.arity() && toInstantiate) {
                toInstantiate = !this.getDomains().get(method.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (!toInstantiate) {
                it.remove();
            }
        }
    }

    /**
     * Expands the quantified expression contained in the preconditions of the methods in parameter and simplify the
     * their precondition. If the preconditions can be simplied to false, the method simplified is removed.
     *
     * @param methods the list of methods to process.
     */
    private void expandQuantifiedExpressionAndSimplyMethods(List<IntMethod> methods) {
        final Iterator<IntMethod> i = methods.iterator();
        while (i.hasNext()) {
            final IntMethod method = i.next();
            this.expandQuantifiedExpression(method.getPreconditions(), true);
            this.simplify(method.getPreconditions());
            if (method.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                i.remove();
            }
        }
    }

    /**
     * Computes the list of possible primitive tasks from the action already instantiated.
     *
     * @param actions the list of actions already instantiated.
     * @return the list of possible primitive tasks from the action already instantiated.
     */
    private LinkedHashSet<IntExpression> computePrimitiveTaskSet(List<IntAction> actions) {
        LinkedHashSet<IntExpression> tasks = new LinkedHashSet<>();
        for (IntAction a : actions) {
            IntExpression task = new IntExpression(PDDLConnective.TASK);
            task.setPrimtive(true);
            task.setPredicate(this.getTaskSymbols().indexOf(a.getName()));
            task.setArguments(a.getInstantiations());
            tasks.add(task);
        }
        return tasks;

    }
}
