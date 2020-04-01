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

package fr.uga.pddl4j.operators;

import fr.uga.pddl4j.util.BitMatrix;

import java.io.Serializable;

/**
 * This class implements an task network. This class is used to store compact representation of a task network
 * in a planning problem.
 *
 * @author D. Pellier
 * @version 1.0 - 01.03.2020
 */
public final class TaskNetwork implements Serializable {

    /**
     * The array that defined the list of task of task network. Each task is defined as an integer. The integer
     * indicates the index of the task in the task table of the planning problem.
     */
    private int[] tasks;

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
        this.tasks = new int[0];
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
        this.tasks = new int[other.size()];
        this.orderingConstraints = new BitMatrix(other.getOrderingConstraints());
    }

    /**
     * Create a new task network with a set of tasks and orderings constraints.
     *
     * @param tasks          the tasks of the task network.
     * @param constraints    the orderings constraints of the task network.
     */
    public TaskNetwork(final int[] tasks, final BitMatrix constraints) {
        super();
        this.tasks = tasks;
        this.orderingConstraints = constraints;
    }

    /**
     * Returns the size of the task network, i.e., its number of tasks.
     *
     * @return the size of the task network.
     */
    public final int size() {
        return this.tasks.length;
    }
    /**
     * Returns the tasks of the method.
     *
     * @return the tasks of the method.
     */
    public final int[] getTasks() {
        return this.tasks;
    }

    /**
     * Set the tasks of the method.
     *
     * @param tasks the tasks to set.
     */
    public final void setTasks(final int[] tasks) {
        this.tasks = tasks;
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
     * Set the new ordering constraints of the method.
     *
     * @param constraints the orderings constraints to set
     */
    public final void setOrderingConstraints(final BitMatrix constraints) {
        this.orderingConstraints = constraints;
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
        while (i < this.tasks.length && ordered) {
            ordered = this.orderingConstraints.get(i - 1, i);
        }
        return ordered;
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
        return this.getTasks().hashCode() + this.getOrderingConstraints().hashCode();
    }
}
