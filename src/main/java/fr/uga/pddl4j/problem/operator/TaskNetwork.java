/*
 * Copyright (c) 2022 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.problem.operator;

import fr.uga.pddl4j.problem.time.TemporalOrderingConstraintNetwork;
import fr.uga.pddl4j.util.BitVector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class implements a task network. This class is used to store compact representation of a task network
 * in a planning problem. This is the first level of implementation of the interface <code>TaskNetwork</code>.
 *
 * @author D. Pellier
 * @version 1.0 - 07.06.2010
 */
public class TaskNetwork implements Serializable {

    /**
     * The array that defined the list of task of the task network. Each task is defined as an integer. The integer
     * indicates the index of the task in the task table of the planning problem.
     */
    private List<Integer> tasks;

    /**
     * The list of before constraints.
     */
    private Map<Integer, Condition> beforeConstraints;

    /**
     * The list of after constraints.
     */
    private Map<Integer, Condition> afterConstraints;

    /**
     * The list of between constraints.
     */
    private Map<Integer, Map<Integer, Condition>> betweenConstraints;

    /**
     * The represents the ordering constraints of the task network.
     */
    private DefaultOrderingConstraintNetwork orderingConstraints;

    /**
     * The represents the ordering constraints of the task network.
     */
    private TemporalOrderingConstraintNetwork temporalOrderingConstraints;

    /**
     * The flag used to indicate that the task network is durative.
     */
    private boolean durative;

    /**
     * Create a new not durative task network. The list of task is set to an empty set with no ordering constraints.
     */
    public TaskNetwork() {
        this(false);
    }

    /**
     * Create a new task network. The list of task is set to an empty set with no ordering constraints.
     *
     * @param durative the flag to indicate if the task network is durative or not.
     */
    public TaskNetwork(final boolean durative) {
        super();
        this.setTasks(new LinkedList<Integer>());
        this.beforeConstraints = new LinkedHashMap<>();
        this.afterConstraints = new LinkedHashMap<>();
        this.betweenConstraints = new LinkedHashMap<>();
        this.setDurative(durative);
        if (this.isDurative()) {
            this.setTemporalOrderingConstraints(new TemporalOrderingConstraintNetwork());
            this.setOrderingConstraints(null);
        } else {
            this.setOrderingConstraints(new DefaultOrderingConstraintNetwork(0));
            this.setTemporalOrderingConstraints(null);
        }
    }

    /**
     * Create a new method from a specified task network. This constructor create a deep copy of the
     * specified task network.
     *
     * @param other the other task network.
     */
    public TaskNetwork(final TaskNetwork other) {
        super();
        this.setTasks(new LinkedList<Integer>(other.getTasks()));
        this.beforeConstraints = new LinkedHashMap<>();
        for (Map.Entry<Integer, Condition> e : other.getBeforeConstraints().entrySet()) {
            this.beforeConstraints.put(e.getKey(), new Condition(e.getValue()));
        }
        this.afterConstraints = new LinkedHashMap<>();
        for (Map.Entry<Integer, Condition> e : other.getAfterConstraints().entrySet()) {
            this.afterConstraints.put(e.getKey(), new Condition(e.getValue()));
        }
        this.betweenConstraints = new LinkedHashMap<>();
        for (Map.Entry<Integer, Map<Integer, Condition>> ei : other.getBetweenConstraints().entrySet()) {
            Map<Integer, Condition> map = new LinkedHashMap<>();
            for (Map.Entry<Integer, Condition> ej : ei.getValue().entrySet()) {
                map.put(ej.getKey(), new Condition(ej.getValue()));
            }
            this.getBetweenConstraints().put(ei.getKey(), map);
        }
        this.setDurative(other.isDurative());
        if (other.getOrderingConstraints() != null) {
            this.setOrderingConstraints(new DefaultOrderingConstraintNetwork(other.getOrderingConstraints()));
        }
        if (other.getTemporalOrderingConstraints() != null) {
            this.setTemporalOrderingConstraints(new TemporalOrderingConstraintNetwork(
                other.getTemporalOrderingConstraints()));
        }
    }

    /**
     * Create a new task network with a set of tasks and a set of orderings constraints. The transitive closure on
     * the ordering constraints is done by the constructor. Moreover, if the ordering constraints specified a totally
     * ordered set of tasks. The list of tasks of the task network are ordered to reflect this implicit order.
     * Warning, the constructor does not check that the ordering constraints are not cyclic.
     *
     * @param tasks       the tasks of the task network.
     * @param constraints the orderings constraints of the task network.
     */
    public TaskNetwork(final List<Integer> tasks, final DefaultOrderingConstraintNetwork constraints) {
        this(false);
        this.setTasks(tasks);

        this.setOrderingConstraints(constraints);
        this.getOrderingConstraints().transitiveClosure();
        if (this.isTotallyOrdered()) {
            LinkedList<Integer> orderedTasks = new LinkedList<>();
            List<Integer> numberOfConstraints = new ArrayList<>();
            for (int i = 0; i < constraints.size(); i++) {
                numberOfConstraints.add(constraints.getTaskOrderedAfter(i).cardinality());
                constraints.getTaskOrderedAfter(i).clear(0, i + 1);
                constraints.getTaskOrderedAfter(i).set(i + 1, constraints.size());
            }
            for (int i = 0; i < numberOfConstraints.size(); i++) {
                orderedTasks.add(0, this.getTasks().get(numberOfConstraints.indexOf(i)));
            }
            this.setTasks(orderedTasks);
        }
    }

    /**
     * Create a new task network with a set of tasks and a set of temporal orderings constraints. The transitive closure
     * onthe ordering constraints is done by the constructor.
     *
     * @param tasks       the tasks of the task network.
     * @param constraints the temporal orderings constraints of the task network.
     */
    public TaskNetwork(final List<Integer> tasks, final TemporalOrderingConstraintNetwork constraints) {
        this(true);
        this.setTasks(tasks);
        this.setTemporalOrderingConstraints(constraints);
        this.getTemporalOrderingConstraints().transitiveClosure();
    }

    /**
     * Returns the condition that must hold before a specific task of the task network.
     *
     * @param task the task.
     * @return the condition that must hold before a task or null if the task is not a task of the task network.
     */
    public Condition getBeforeConstraints(int task) {
        Condition condition = null;
        if (this.getTasks().contains(task)) {
            condition = this.getBeforeConstraints().get(task);
            if (condition == null) {
                condition = new Condition();
                this.getBeforeConstraints().put(task, condition);
            }
        }
        return condition;
    }

    /**
     * Returns the before constraints of task network.
     *
     * @return the before constraints of task network.
     */
    protected Map<Integer, Condition> getBeforeConstraints() {
        return this.beforeConstraints;
    }

    /**
     * Returns the condition that must hold after a specific task of the task network.
     *
     * @param task the task.
     * @return the condition that must hold after a task or null if the task is not a task of the task network.
     */
    public Condition getAfterConstraints(int task) {
        Condition condition = null;
        if (this.getTasks().contains(task)) {
            condition = this.getAfterConstraints().get(task);
            if (condition == null) {
                condition = new Condition();
                this.getAfterConstraints().put(task, condition);
            }
        }
        return condition;
    }

    /**
     * Returns the after constraints of task network.
     *
     * @return the after constraints of task network.
     */
    protected Map<Integer, Condition> getAfterConstraints() {
        return this.afterConstraints;
    }

    /**
     * Returns the condition that must hold between two specific tasks of the task network.
     *
     * @param task1 the first task.
     * @param task2 the second task.
     * @return the condition that must hold between two tasks or null if t1 or t2 task is not a task of the task
     *         network.
     */
    public Condition getBetweenConstraints(int task1, int task2) {
        Condition condition = null;
        if (this.getTasks().contains(task1) && this.getTasks().contains(task2)) {
            Map<Integer, Condition> map1 = this.getBetweenConstraints().get(task1);
            if (map1 == null) {
                map1 = new LinkedHashMap<>();
                condition = new Condition();
                map1.put(task2, condition);
                this.getBetweenConstraints().put(task1, map1);
            } else {
                condition = map1.get(task1);
                if (condition == null) {
                    condition = new Condition();
                    map1.put(task2, condition);
                }
            }
        }
        return condition;
    }

    /**
     * Returns the between constraints of task network.
     *
     * @return the between constraints of task network.
     */
    protected Map<Integer, Map<Integer, Condition>> getBetweenConstraints() {
        return this.betweenConstraints;
    }

    /**
     * Returns the size of the task network, i.e., its number of tasks.
     *
     * @return the size of the task network.
     */
    public final int size() {
        return this.getTasks().size();
    }

    /**
     * Returns the tasks of the task network.
     *
     * @return the tasks of the task network.
     */
    public final List<Integer> getTasks() {
        return this.tasks;
    }

    /**
     * Sets the tasks of the task network.
     *
     * @param tasks the tasks to set.
     */
    public final void setTasks(final List<Integer> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns if the task network is empty, i.e., contains not tasks.
     *
     * @return <code>true</code> if the task network is empty, <code>false</code> otherwise.
     */
    public final boolean isEmpty() {
        return this.getTasks().isEmpty();
    }

    /**
     * Returns the ordering constraints of the method.
     *
     * @return the ordering constraints of the method.
     */
    public final DefaultOrderingConstraintNetwork getOrderingConstraints() {
        return this.orderingConstraints;
    }

    /**
     * Sets the new ordering constraints of the method.
     *
     * @param constraints the orderings constraints to set
     */
    public final void setOrderingConstraints(final DefaultOrderingConstraintNetwork constraints) {
        this.orderingConstraints = constraints;
    }

    /**
     * Returns the temporal ordering constraints of this temporal task network.
     *
     * @return the temporal ordering constraints of this temporal task network.
     */
    public final TemporalOrderingConstraintNetwork getTemporalOrderingConstraints() {
        return this.temporalOrderingConstraints;
    }

    /**
     * Sets the temporal ordering constraints of the temporal task network.
     *
     * @param constraints the temporal ordering constraints to set.
     */
    public final void setTemporalOrderingConstraints(final TemporalOrderingConstraintNetwork constraints) {
        this.temporalOrderingConstraints = constraints;
    }

    /**
     * Returns if the task network is durative or not. If a task network is durative, it means that ordering constraints
     * will use a temporal representation.
     *
     * @return {@code true} if the task network is durative; {@code false} otherwise.
     */
    public boolean isDurative() {
        return this.durative;
    }

    /**
     * Set the boolean flag to indicate if a task network is durative or not.
     *
     * @param durative {@code true} if the task network is durative; {@code false} otherwise.
     */
    public void setDurative(final boolean durative) {
        this.durative = durative;
    }

    /**
     * Decompose a tasks of the network with a specific method.
     *
     * @param task   the task to decompose.
     * @param method the method to be used to decompose.
     */
    public void decompose(final int task, final Method method) {
        final int numberOfSubtasks = method.getSubTasks().size();
        final int newSize = this.size() - 1 + numberOfSubtasks;
        // Make a copy of the constraints of the task to remove
        final BitVector row = new BitVector(this.getOrderingConstraints().getTaskOrderedAfter(task));
        // Remove the task to replace
        this.removeTask(task);
        // Resize the matrix to add the constraints for the method subtasks
        this.getOrderingConstraints().resize(newSize);
        // Add the subtasks constraints to the task network
        for (int i = 0; i < method.getOrderingConstraints().size(); i++) {
            final BitVector cti = method.getOrderingConstraints().getTaskOrderedAfter(i);
            final BitVector ri = this.getOrderingConstraints().getTaskOrderedAfter(this.size() + i);
            ri.or(cti);
            ri.shiftRight(this.size());
        }
        // Shifts constraints on added subtasks
        for (int i = row.nextSetBit(0); i >= 0; i = row.nextSetBit(i + 1)) {
            final int rowIndex = i < task ? i : i - 1;
            for (int j = this.size(); j < newSize; j++) {
                this.getOrderingConstraints().set(j, rowIndex);
            }
        }
        // Update the list of task of the task network
        this.getTasks().addAll(method.getSubTasks());
    }

    /**
     * Remove a task for the task network.
     *
     * @param task the index of the task to remove.
     */
    public final void removeTask(final int task) {
        this.tasks.remove(task);
        if (this.isDurative()) {
            this.getTemporalOrderingConstraints().removeTask(task);
        } else {
            this.orderingConstraints.removeTask(task);
        }
    }

    /**
     * Returns <code>true</code> if the task network is totally ordered.
     *
     * @return <code>true</code> if the  task network  is totally ordered; <code>false</code> otherwise.
     */
    public boolean isTotallyOrdered() {
        return this.isDurative() ? this.getTemporalOrderingConstraints().isTotallyOrdered() :
            this.getOrderingConstraints().isTotallyOrdered();
    }

    /**
     * Returns if this task network has a consistent ordering constraints network.
     *
     * @return <code>true</code> if this task network has a consistent ordering constraints networks, <code>false</code>
     *      otherwise.
     */
    public final boolean isConsistent() {
        return this.isDurative() ? this.getTemporalOrderingConstraints().isConsistent() :
            this.getOrderingConstraints().isConsistent();
    }

    /**
     * Returns the list of tasks with no successors. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     *
     * @return the  list of tasks with no successors.
     */
    public final List<Integer> getTasksWithNosSuccessors() {
        return this.isDurative() ? this.getTemporalOrderingConstraints().getTasksWithNoSuccessors() :
            this.getOrderingConstraints().getTasksWithNoSuccessors();
    }

    /**
     * Returns the list of tasks with no predecessors.  The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no predecessors.
     */
    public final List<Integer> getTasksWithNoPredecessors() {
        return this.isDurative() ? this.getTemporalOrderingConstraints().getTasksWithNoPredecessors() :
            this.getOrderingConstraints().getTasksWithNoPredecessors();
    }

    /**
     * Returns <code>true</code> if this task network is equal to an object. This
     * method returns <code>true</code> if the object is a not null instance
     * of the class <code>AbstactTaskNetwork</code> and both task network have the same
     * set of tasks and before, after and between constraints?
     *
     * @param obj the object to be compared.
     * @return <code>true</code> if this task network is equal to an object;
     * <code>false</code> otherwise.
     */
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof TaskNetwork) {
            final TaskNetwork other = (TaskNetwork) obj;
            return Objects.equals(this.isDurative(), other.isDurative())
                && Objects.equals(this.getTasks(), other.getTasks())
                && Objects.equals(this.getBeforeConstraints(), other.getBeforeConstraints())
                && Objects.equals(this.getAfterConstraints(), other.getAfterConstraints())
                && Objects.equals(this.getBetweenConstraints(), other.getBetweenConstraints())
                && Objects.equals(this.getOrderingConstraints(), other.getOrderingConstraints())
                && Objects.equals(this.getTemporalOrderingConstraints(), other.getTemporalOrderingConstraints());
        }
        return false;
    }

    /**
     * Returns a hash code value for this task network. This method is supported
     * for the benefit of hash tables such as those provided by
     * <code>java.util.Hashtable</code>.
     *
     * @return a hash code value for this task network.
     */
    public int hashCode() {
        return Objects.hash(this.isDurative(), this.getTasks(), this.getBeforeConstraints(), this.getAfterConstraints(),
            this.getBetweenConstraints(), this.getOrderingConstraints(), this.getTemporalOrderingConstraints());
    }

}
