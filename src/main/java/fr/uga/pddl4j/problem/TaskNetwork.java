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

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.util.BitMatrix;

import java.io.Serializable;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class implements an task network. This class is used to store compact representation of a task network
 * in a planning problem.
 *
 * @author D. Pellier
 * @version 1.0 - 01.03.2020
 * @since 4.0
 */
public final class TaskNetwork implements Serializable {

    /**
     * The array that defined the list of task of task network. Each task is defined as an integer. The integer
     * indicates the index of the task in the task table of the planning problem.
     */
    private LinkedList<Integer> tasks;

    /**
     * The represents the ordering constraints of the task network.
     */
    private BitMatrix orderingConstraints;

    /**
     * Create a new task network. The list of task is set to an empty set with no ordering constraints and not totally
     * ordered.
     */
    public TaskNetwork() {
        super();
        this.tasks = new LinkedList<Integer>();
        this.orderingConstraints = new BitMatrix(0, 0);
    }

    /**
     * Create a new method from a specified task network. This constructor create a deep copy of the
     * specified task network.
     *
     * @param other the other task network.
     */
    public TaskNetwork(final TaskNetwork other) {
        super();
        this.tasks = new LinkedList<Integer>(other.getTasks());
        this.orderingConstraints = new BitMatrix(other.getOrderingConstraints());
    }

    /**
     * Create a new task network with a set of tasks and orderings constraints.
     *
     * @param tasks          the tasks of the task network.
     * @param constraints    the orderings constraints of the task network.
     */
    public TaskNetwork(final List<Integer> tasks, final BitMatrix constraints) {
        super();
        this.tasks = new LinkedList<Integer>(tasks);
        this.orderingConstraints = constraints;
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
    public final  List<Integer> getTasks() {
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
     * Returns the ordering constraints of the method.
     *
     * @return the ordering constraints of the method.
     */
    public final BitMatrix getOrderingConstraints() {
        return this.orderingConstraints;
    }

    /**
     * Sets the new ordering constraints of the method.
     *
     * @param constraints the orderings constraints to set
     */
    public final void setOrderingConstraints(final BitMatrix constraints) {
        this.orderingConstraints = constraints;
    }

    /**
     * Decompose a tasks of the network with a specific method.
     *
     * @param task the task to decompose.
     * @param method the method to be used to decompose.
     */
    public void decompose(final int task, final Method method) {
        final int indexNewConstraints = this.size() - 1;
        final int sizeNewMatrix = this.size() - 1 + method.getSubTasks().size();
        BitMatrix newOrderingConstraints = new BitMatrix(sizeNewMatrix);
        for (int i =  0; i < this.orderingConstraints.rows() ; i++) {
            BitSet row = this.orderingConstraints.getRow(i);
            for (int j = row.nextSetBit(0); j >= 0; j = row.nextSetBit( j + 1)) {
                if (i != task) {
                    if (j < task) {
                        newOrderingConstraints.set(i, j);
                    } else if (j == task) {
                        for (int k = indexNewConstraints; k < newOrderingConstraints.rows(); k++) {
                            newOrderingConstraints.set(i, k);
                        }
                    } else {
                        newOrderingConstraints.set(i, j - 1);
                    }
                } else {
                    for (int k = indexNewConstraints; k < newOrderingConstraints.rows(); k++) {
                        if (j < task) {
                            newOrderingConstraints.set(k, j);
                        } else if (j > task) {
                            newOrderingConstraints.set(k, j - 1);
                        }
                    }
                }
            }
        }
        for (int i =  0; i < method.getOrderingConstraints().rows() ; i++) {
            BitSet row = method.getOrderingConstraints().getRow(i);
            for (int j = row.nextSetBit(0); j >= 0; j = row.nextSetBit( j + 1)) {
                newOrderingConstraints.set(i + indexNewConstraints, j + indexNewConstraints);
            }
        }
        this.orderingConstraints = newOrderingConstraints;
        this.tasks.remove(task);
        this.tasks.addAll(method.getSubTasks());
    }

    /**
     * Decompose a tasks of the network with a specific action.
     *
     * @param task the task to decompose.
     * @param action the action to be used to decompose.
     */
    public void decompose(final int task, final Action action) {
        final int sizeNewMatrix = this.size() - 1;
        BitMatrix newOrderingConstraints = new BitMatrix(sizeNewMatrix);
        for (int i =  0; i < this.orderingConstraints.rows() ; i++) {
            BitSet row = this.orderingConstraints.getRow(i);
            for (int j = row.nextSetBit(0); j >= 0; j = row.nextSetBit( j + 1)) {
                if (i < task) {
                    if (j < task) {
                        newOrderingConstraints.set(i, j);
                    } else if (j > task){
                        newOrderingConstraints.set(i, j - 1);
                    }
                } else if (i > task){
                    if (j < task) {
                      newOrderingConstraints.set(i - 1, j);
                    } else if (j > task) {
                        newOrderingConstraints.set(i - 1, j - 1);
                    }
                }
            }
        }
        this.orderingConstraints = newOrderingConstraints;
        this.tasks.remove(task);
    }

    /**
     * Returns <code>true</code> if the task network is totally ordered. The return value is computed from the ordering
     * constraints of the task network.
     *
     * @return <code>true</code> if the task network is totally ordered.
     */
    public final boolean isTotallyOrdered() {
        boolean ordered = true;
        int i = 1;
        while (i < this.tasks.size() && ordered) {
            ordered = this.orderingConstraints.get(i - 1, i);
        }
        return ordered;
    }

    /**
     * Returns if this task network contains cyclic ordering constraints.
     *
     * @return <code>true</code> if the task network contains acyclic ordering constraints, <code>false</code>
     *      otherwise.
     */
    public final boolean isAcyclic() {
        this.transitiveClosure();
        final int size = this.orderingConstraints.rows();
        boolean acyclic = true;
        int i = 0;
        while (i < size && acyclic) {
            acyclic &= !this.getOrderingConstraints().get(i, i);
            i++;
        }
        return acyclic;
    }

    /**
     * Compute the transitive closure of the ordering constraints. The computation of the transitive closure is based
     * on Warshall algorithm. The complexity is O(n) where n is the number of tasks of the task network.
     */
    public final void transitiveClosure() {
        final int size = this.orderingConstraints.rows();
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!this.getOrderingConstraints().get(i, j)
                            || (!this.getOrderingConstraints().get(i, k)
                                && !this.getOrderingConstraints().get(k, i))) {
                        this.orderingConstraints.set(i, j);
                    } else {
                        this.orderingConstraints.clear(i, j);
                    }
                }
            }
        }
    }

    /**
     * Returns the list of tasks with no predecessors.
     *
     * @return the  list of tasks with no predecessors.
     */
    public final List<Integer> getTasksWithNoPredecessors() {
        this.transitiveClosure();
        final List<Integer> tasks = new LinkedList<>();
        for (int i = 0; i < this.getOrderingConstraints().columns(); i++) {
            if (this.getOrderingConstraints().getColumn(i).cardinality() == 0) {
                tasks.add(i);
            }
        }
        return tasks;
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
    @Override
    public final boolean equals(final Object obj) {
        if (obj != null && obj instanceof TaskNetwork) {
            final TaskNetwork other = (TaskNetwork) obj;
            return this.getTasks().equals(other.getTasks())
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
    @Override
    public final int hashCode() {
        return Objects.hash(this.getTasks(), this.getOrderingConstraints());
    }
}
