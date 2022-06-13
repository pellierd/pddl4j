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

package fr.uga.pddl4j.problem.operator;

import fr.uga.pddl4j.parser.Connector;
import fr.uga.pddl4j.parser.Expression;

/**
 * This class implements an method. This class is used to store compact representation of method
 * during the instantiation process.
 *
 * @author D. Pellier
 * @version 1.0 - 14.02.2020
 */
public final class IntMethod extends AbstractIntOperator {

    /**
     * The task carries out by this method.
     */
    private Expression<Integer> task;

    /**
     * The task network of the methode.
     */
    private IntTaskNetwork taskNetwork;

    /**
     * Create a new method from a specified method. This constructor create a deep copy of the
     * specified method.
     *
     * @param other the other method.
     */
    public IntMethod(final IntMethod other) {
        super(other);
        this.task = new Expression<>(other.getTask());
        this.taskNetwork = new IntTaskNetwork(other.taskNetwork);
    }

    /**
     * Create a new method with a specified name. The task is set to a empty expression with TASK as connective and
     * the task network is set to an empty task network.
     *
     * @param name  the name of the method.
     * @param arity the arity of the method. The arity must be greater than 0.
     */
    public IntMethod(final String name, final int arity) {
        super(name, arity);
        this.task = new Expression<>(Connector.TASK);
        this.taskNetwork = new IntTaskNetwork();
    }

    /**
     * Return the task that is carried out by the method.
     *
     * @return the task carried out by the method.
     */
    public final Expression<Integer> getTask() {
        return this.task;
    }

    /**
     * Set the task carried out by the method.
     *
     * @param task the task the carried out by the method.
     */
    public final void setTask(final Expression<Integer> task) {
        this.task = task;
    }

    /**
     * Return the subtasks of the method.
     *
     * @return the subtasks of the method.
     */
    public final Expression<Integer> getSubTasks() {
        return this.taskNetwork.getTasks();
    }

    /**
     * Set the subtasks of the method.
     *
     * @param tasks the subtasks to set.
     */
    public final void setSubTasks(final Expression<Integer> tasks) {
        this.taskNetwork.setTasks(tasks);
    }

    /**
     * Return the ordering constraints of the method.
     *
     * @return the ordering constraints of the method.
     */
    public final Expression<Integer> getOrderingConstraints() {
        return this.taskNetwork.getOrderingConstraints();
    }

    /**
     * Set the new ordering constraints of the method.
     *
     * @param ordering the orderings constraints to set
     */
    public final void setOrderingConstraints(final Expression<Integer> ordering) {
        this.taskNetwork.setOrderingConstraints(ordering);
    }

    /**
     * Returns the logical constraints between the tasks of the task network.
     *
     * @return the logical constraints of the task network.
     */
    public final Expression<Integer> getConstraints() {
        return this.taskNetwork.getConstraints();
    }

    /**
     *  Sets the logical constraints between the tasks of the task network.
     *
     *  @param constraints The constraints to set.
     */
    public final void setConstraints(final Expression<Integer> constraints) {
        this.taskNetwork.setConstraints(constraints);
    }

    /**
     * Returns the task network of this method.
     *
     * @return the task network of this method.
     */
    public final IntTaskNetwork getTaskNetwork() {
        return this.taskNetwork;
    }

    /**
     * Set the task network of this method.
     *
     * @param taskNetwork the task network to set.
     */
    public final void setTaskNetwork(final IntTaskNetwork taskNetwork) {
        this.taskNetwork = taskNetwork;
    }

}
