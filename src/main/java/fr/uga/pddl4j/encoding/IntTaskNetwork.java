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

package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.Connective;

import java.io.Serializable;

/**
 * This class implements an task network. This class is used to store compact representation of a task network
 * during the instantiation process.
 *
 * @author D. Pellier
 * @version 1.0 - 25.03.2020
 */
public final class IntTaskNetwork implements Serializable {

    /**
     * The expression that represents the list of tasks of the task network.
     */
    private IntExp tasks;

    /**
     * The expression that represents the ordering constraints of the task network.
     */
    private IntExp orderingConstraints;

    /**
     * A boolean flag to indicate if the task network is totally ordered or not.
     */
    private boolean isTotallyOrdered;

    /**
     * Create a new task network. The tasks and the ordering constraints are empty and expression.
     */
    public IntTaskNetwork() {
        this.tasks = new IntExp(Connective.AND);
        this.orderingConstraints = new IntExp(Connective.AND);
    }

    /**
     * Create a new method from a specified task network. This constructor create a deep copy of the
     * specified task network.
     *
     * @param other the other tasknetwork.
     */
    public IntTaskNetwork(final IntTaskNetwork other) {
        super();
        this.tasks = new IntExp(other.getTasks());
        this.orderingConstraints = new IntExp(other.getOrderingConstraints());
    }

    /**
     * Create a new task network with a set of tasks and orderings constraints. Warning the method does not check if
     * the ordering constraints given in parameter are consistent with boolean flag that indicates that the task network
     * is totally ordered.
     *
     * @param tasks  the tasks of the task network.
     * @param orderingConstraints the orderings constraints of the task network.
     * @param totallyOrdered the boolean flag to indicate if the task network is totally ordered or not.
     */
    public IntTaskNetwork(final IntExp tasks, final IntExp orderingConstraints, final boolean totallyOrdered) {
        super();
        this.tasks = tasks;
        this.orderingConstraints = orderingConstraints;
        this.isTotallyOrdered = totallyOrdered;
    }

    /**
     * Return the tasks of the method.
     *
     * @return the tasks of the method.
     */
    public final IntExp getTasks() {
        return this.tasks;
    }

    /**
     * Set the tasks of the method.
     *
     * @param tasks the tasks to set.
     */
    public final void setTasks(final IntExp tasks) {

        this.tasks = tasks;
    }

    /**
     * Return the ordering constraints of the method.
     *
     * @return the ordering constraints of the method.
     */
    public final IntExp getOrderingConstraints() {
        return this.orderingConstraints;
    }

    /**
     * Set the new ordering constraints of the method.
     *
     * @param ordering the orderings constraints to set
     */
    public final void setOrderingConstraints(final IntExp ordering) {
        this.orderingConstraints = ordering;
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
        if (obj != null && obj instanceof IntTaskNetwork) {
            final IntTaskNetwork other = (IntTaskNetwork) obj;
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
