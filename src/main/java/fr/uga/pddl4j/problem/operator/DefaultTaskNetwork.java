/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
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

import fr.uga.pddl4j.util.BitVector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class implements a default task network. This class is used to store compact representation of a task network
 * in a planning problem and method.
 *
 * @author D. Pellier
 * @version 1.0 - 01.03.2020
 * @since 4.0
 */
public final class DefaultTaskNetwork extends AbstractTaskNetwork {

    /**
     * The represents the ordering constraints of the task network.
     */
    private DefaultOrderingConstraintNetwork orderingConstraints;

    /**
     * Create a new task network. The list of task is set to an empty set with no ordering constraints and not totally
     * ordered.
     */
    public DefaultTaskNetwork() {
        super();
        this.orderingConstraints = new DefaultOrderingConstraintNetwork(0);
    }

    /**
     * Create a new method from a specified task network. This constructor create a deep copy of the
     * specified task network.
     *
     * @param other the other task network.
     */
    public DefaultTaskNetwork(final DefaultTaskNetwork other) {
        super(other);
        this.orderingConstraints = new DefaultOrderingConstraintNetwork(other.getOrderingConstraints());
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
    public DefaultTaskNetwork(final List<Integer> tasks, final DefaultOrderingConstraintNetwork constraints) {
        super();
        this.setTasks(tasks);
        this.setOrderingConstraints(constraints);
        this.getOrderingConstraints().transitiveClosure();

        if (this.getOrderingConstraints().isTotallyOrdered()) {
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
        super.removeTask(task);
        this.orderingConstraints.removeTask(task);
    }


    /**
     * Returns <code>true</code> if the task network is totally ordered.
     *
     * @return <code>true</code> if the  task network  is totally ordered; <code>false</code> otherwise.
     */
    public boolean isTotallyOrdered() {
        return this.getOrderingConstraints().isTotallyOrdered();
    }

    /**
     * Returns if this task network has a consistent ordering constraints network.
     *
     * @return <code>true</code> if this task network has a consistent ordering constraints networks, <code>false</code>
     *      otherwise.
     */
    public final boolean isConsistent() {
        return this.orderingConstraints.isConsistent();
    }

    /**
     * Returns the list of tasks with no successors. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     *
     * @return the  list of tasks with no successors.
     */
    public final List<Integer> getTasksWithNosSuccessors() {
        return this.orderingConstraints.getTasksWithNoSuccessors();
    }

    /**
     * Returns the list of tasks with no predecessors.  The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no predecessors.
     */
    public final List<Integer> getTasksWithNoPredecessors() {
        return this.orderingConstraints.getTasksWithNoPredecessors();
    }

    /**
     * Returns <code>true</code> if this task network is equal to an object. This
     * method returns <code>true</code> if the object is a not null instance
     * of the class <code>IntTaskNetwork</code> and both task network have the same
     * set of tasks, ordering constraints expression.
     *
     * @param obj the object to be compared.
     * @return <code>true</code> if this task network is equal to an object;
     * <code>false</code> otherwise.
     */
    public final boolean equals(final Object obj) {
        if (obj != null && obj instanceof DefaultTaskNetwork) {
            final DefaultTaskNetwork other = (DefaultTaskNetwork) obj;
            return super.equals(other)
                && this.getOrderingConstraints().equals(other.getOrderingConstraints());
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
    public final int hashCode() {
        return Objects.hash(super.hashCode(), this.getOrderingConstraints());
    }
}
