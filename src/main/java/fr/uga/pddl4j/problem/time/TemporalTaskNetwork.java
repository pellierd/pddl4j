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

import fr.uga.pddl4j.problem.operator.AbstractTaskNetwork;
import fr.uga.pddl4j.problem.operator.Condition;
import fr.uga.pddl4j.problem.operator.DurativeMethod;
import fr.uga.pddl4j.problem.operator.Method;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class implements a temporal task network.
 *
 * @author D. Pellier
 * @version 1.0 - 04.06.2023
 * @since 4.0
 */
public final class TemporalTaskNetwork extends AbstractTaskNetwork {

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
        this.setOrderingConstraints(new SimpleTemporalNetwork());
    }

    /**
     * Create a new method from a specified task network. This constructor create a deep copy of the
     * specified task network.
     *
     * @param other the other task network.
     */
    public TemporalTaskNetwork(final TemporalTaskNetwork other) {
        super(other);
        this.setOrderingConstraints(new SimpleTemporalNetwork(other.getOrderingConstraints()));
    }

    /**
     * Create a new task network with a set of tasks and a set of of orderings constraints.
     *
     * @param tasks       the tasks of the task network.
     * @param network the orderings constraints of the task network.
     */
    public TemporalTaskNetwork(final List<Integer> tasks, final SimpleTemporalNetwork network) {
        super();
        this.setTasks(new LinkedList<Integer>(tasks));
        this.setOrderingConstraints(network);
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
     * Remove a task for the task network.
     *
     * @param task the index of the task to remove.
     */
    public final void removeTask(final int task) {
        super.getTasks();
        this.getOrderingConstraints().removeTask(task);
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
     * Returns if this task network has a consistent ordering constraints network.
     *
     * @return <code>true</code> iif this task network has a consistent ordering constraints network, <code>false</code>
     *      otherwise.
     */
    public final boolean isConsistent() {
        return this.getOrderingConstraints().isConsistent();
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
            return super.equals(other)
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
        return Objects.hash(super.hashCode(), this.getOrderingConstraints());
    }
}
