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

package fr.uga.pddl4j.problem.time;

import fr.uga.pddl4j.problem.operator.DurativeMethod;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class implements a temporal task network.
 *
 * @author D. Pellier
 * @version 1.0 - 04.06.2023
 * @since 4.0
 */
public final class TemporalTaskNetwork implements Serializable {

    /**
     * The array that defined the list of tasks of task network. Each task is defined as an integer. The integer
     * indicates the index of the task in the task table of the planning problem.
     */
    private LinkedList<Integer> tasks;

    /**
     * The represents the ordering constraints of the task network.
     */
    private SimpleTemporalNetwork temporalNetwork;

    /**
     * Create a new task network. The list of task is set to an empty set with no ordering constraints and not totally
     * ordered.
     */
    public TemporalTaskNetwork() {
        super();
        this.setTasks(new LinkedList<Integer>());
        this.setOrderingConstraints(new SimpleTemporalNetwork());
    }

    /**
     * Create a new method from a specified task network. This constructor create a deep copy of the
     * specified task network.
     *
     * @param other the other task network.
     */
    public TemporalTaskNetwork(final TemporalTaskNetwork other) {
        super();
        this.tasks = new LinkedList<Integer>(other.getTasks());
        this.temporalNetwork = new SimpleTemporalNetwork(other.getOrderingConstraints());
    }

    /**
     * Create a new task network with a set of tasks and a set of of orderings constraints. The transitive closure on
     * the ordering constraints is done by the constructor. Moreover, if the ordering constraints specified a totally
     * ordered set of tasks. The list of tasks of the task network are ordered to reflect this implicit order.
     * Warning, the constructor does not check that the ordering constraints are not cyclic.
     *
     * @param tasks       the tasks of the task network.
     * @param network the orderings constraints of the task network.
     */
    public TemporalTaskNetwork(final List<Integer> tasks, final SimpleTemporalNetwork network) {
        super();
        this.setTasks(new LinkedList<Integer>(tasks));
        this.setOrderingConstraints(network);
        this.transitiveClosure();

        // Set the tasks in the good order
        /*if (this.isTotallyOrdered()) {
            LinkedList<Integer> orderedTasks = new LinkedList<>();
            List<Integer> numberOfConstraints = new ArrayList<>();
            for (int i = 0; i < constraints.rows(); i++) {
                numberOfConstraints.add(constraints.getRow(i).cardinality());
                constraints.getRow(i).clear(0, i + 1);
                constraints.getRow(i).set(i + 1, constraints.columns());
            }
            for (int i = 0; i < numberOfConstraints.size(); i++) {
                orderedTasks.add(0, this.tasks.get(numberOfConstraints.indexOf(i)));
            }
            this.tasks = orderedTasks;
        }*/
    }

    /**
     * Returns the size of the task network, i.e., its number of tasks.
     *
     * @return the size of the task network.
     */
    public final int size() {
        return this.tasks.size();
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
        this.tasks = new LinkedList<>(tasks);
    }

    /**
     * Returns if the task network is empty, i.e., contains not tasks.
     *
     * @return <code>true</code> if the task network is empty, <code>false</code> otherwise.
     */
    public final boolean isEmpty() {
        return this.tasks.isEmpty();
    }

    /**
     * Returns the simple temporal network of this temporal task network.
     *
     * @return the simple temporal networks of this temporal task network.
     */
    public final SimpleTemporalNetwork getOrderingConstraints() {
        return this.temporalNetwork;
    }

    /**
     * Sets the new simple temporal network of the temporal task network.
     *
     * @param network the simple temporal networks to set.
     */
    public final void setOrderingConstraints(final SimpleTemporalNetwork network) {
        this.temporalNetwork = network;
    }

    /**
     * Decompose a tasks of the network with a specific method.
     *
     * @param task   the task to decompose.
     * @param method the method to be used to decompose.
     */
    public void decompose(final int task, final DurativeMethod method) {
        /*final int numberOfSubtasks = method.getSubTasks().size();
        final int newSize = this.tasks.size() - 1 + numberOfSubtasks;
        // Make a copy of the constraints of the task to remove
        final BitVector row = new BitVector(this.getSimpleTemporalNetwork().getRow(task));
        // Remove the task to replace
        this.removeTask(task);
        // Resize the matrix to add the contraints for the method subtasks
        this.getSimpleTemporalNetwork().resize(newSize, newSize);
        // Add the subtasks contraints to the tasknetwork
        for (int i = 0; i < method.getOrderingConstraints().rows(); i++) {
            final BitVector cti = method.getOrderingConstraints().getRow(i);
            final BitVector ri = this.getSimpleTemporalNetwork().getRow(this.tasks.size() + i);
            ri.or(cti);
            ri.shiftRight(this.getTasks().size());
        }
        // Shifts constraints on added subtasks
        for (int i = row.nextSetBit(0); i >= 0; i = row.nextSetBit(i + 1)) {
            final int rowIndex = i < task ? i : i - 1;
            for (int j = this.size(); j < newSize; j++) {
                this.getSimpleTemporalNetwork().set(j, rowIndex);
            }
        }
        // Update the list of task of the task network
        this.tasks.addAll(method.getSubTasks());*/
    }

    /**
     * Remove a task for the task network.
     *
     * @param task the index of the task to remove.
     */
    public final void removeTask(final int task) {
        this.getTasks().remove(task);
        this.getOrderingConstraints().removeRow(task);
        this.getOrderingConstraints().removeColumn(task);
    }

    /**
     * Returns <code>true</code> if the temporal task network is totally ordered. The return value is computed from the
     * ordering constraints of the temporal task network. A temporal task network with an empty set of constraints or
     * only one constraint is totally ordered.
     *
     * @return <code>true</code> if the task network is totally ordered.
     */
    public final boolean isTotallyOrdered() {
        return this.getOrderingConstraints().isTotallyOrdered();
    }

    /**
     * Returns if this task network contains cyclic ordering constraints.
     *
     * @return <code>true</code> if the task network contains acyclic ordering constraints, <code>false</code>
     *      otherwise.
     */
    public final boolean isAcyclic() {
        return this.getOrderingConstraints().isAcyclic();
    }

    /**
     * Compute the transitive closure of the ordering constraints. The computation of the transitive closure is based
     * on Warshall algorithm. The complexity is O(n^3) where n is the number of tasks of the task network.
     */
    public final void transitiveClosure() {
        this.getOrderingConstraints().transitiveClosure();
    }

    /**
     * Returns the list of tasks with no successors. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     *
     * @return the  list of tasks with no successors.
     */
    public final List<Integer> getTasksWithNosSuccessors() {
        return this.getOrderingConstraints().getTasksWithNoSuccessors();
    }

    /**
     * Returns the list of tasks with no predecessors.  The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no predecessors.
     */
    public final List<Integer> getTasksWithNoPredecessors() {
        return this.getOrderingConstraints().getTasksWithNoPredecessors();
    }

    /**
     * Returns <code>true</code> if this temporal task network is equal to an object. This
     * method returns <code>true</code> if the object is a not null instance
     * of the class <code>TemporalTaskNetwork</code> and both temporal task network have the same
     * set of tasks and simple task network.
     *
     * @param obj the object to be compared.
     * @return <code>true</code> if this temporal task network is equal to an object;
     * <code>false</code> otherwise.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (obj != null && obj instanceof TemporalTaskNetwork) {
            final TemporalTaskNetwork other = (TemporalTaskNetwork) obj;
            return Objects.equals(this.getTasks(), other.getTasks())
                && Objects.equals(this.getOrderingConstraints(), other.getOrderingConstraints());
        }
        return false;
    }

    /**
     * Returns a hash code value for this temporal task network. This method is supported
     * for the benefit of hash tables such as those provided by
     * <code>java.util.Hashtable</code>.
     *
     * @return a hash code value for this task network.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.getTasks(), this.getOrderingConstraints());
    }
}
