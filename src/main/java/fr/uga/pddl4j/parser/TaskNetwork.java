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

package fr.uga.pddl4j.parser;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class implements a task network.
 *
 * @author D. Pellier
 * @version 1.0 - 20.12.2019
 */
public class TaskNetwork implements Serializable {

    /**
     * The list of parameters of the method.
     */
    private List<TypedSymbol> parameters;

    /**
     * The tasks of the task network.
     */
    private Exp tasks;

    /**
     * The ordering constraints of the task network.
     */
    private Exp orderingConstraints;

    /**
     * The constraints of the task network.
     */
    private Exp logicalConstraints;

    /**
     * A boolean flag to indicate if the task network is totally ordered or not.
     */
    private boolean isTotallyOrdered;

    /**
     * Create a new task network.
     */
    private TaskNetwork() {
        super();
        this.parameters = null;
        this.tasks = null;
        this.orderingConstraints = null;
        this.logicalConstraints = null;
        this.isTotallyOrdered = false;
    }

    /**
     * Create a new task network from another.
     *
     * @param other the other task network.
     */
    public TaskNetwork(final TaskNetwork other) {
        if (other == null) {
            throw new NullPointerException();
        }
        this.parameters = new LinkedList<>();
        this.parameters.addAll(other.getParameters().stream().map(TypedSymbol::new).collect(Collectors.toList()));
        this.tasks = new Exp(other.getTasks());
        this.orderingConstraints = new Exp(other.getOrderingConstraints());
        this.logicalConstraints = new  Exp(other.getLogicalConstraints());
        this.isTotallyOrdered = other.isTotallyOrdered();
    }

    /**
     * Creates a task network with a specified list of parameters, list of tasks, ordering and logicial constraints.
     *
     * @param parameters The list of the parameters of the task network. The list of parameters can be empty.
     * @param tasks The tasks of the task network.
     * @param ordering The ordering constraints between the tasks of the task network.
     * @param logical The logicial constraint between the tasks of the task network.
     * @param ordered The flag to indicate if the tasks of the task network are totally ordered or not.
     * @throws NullPointerException if one of the specified parameter except the precondition is null.
     */
    public TaskNetwork(final List<TypedSymbol> parameters, final Exp tasks, final Exp ordering,
                  final Exp logical, final boolean ordered) {
        this();
        this.setParameters(parameters);
        this.setTasks(tasks);
        this.setOrderingConstraints(ordering);
        this.setLogicalConstraints(logical);
        this.setTotallyOrdered(ordered);
    }

    /**
     * Returns the list of parameters of the task network.
     *
     * @return the list of parameters of the task network.
     */
    public final List<TypedSymbol> getParameters() {
        return this.parameters;
    }

    /**
     * Returns the parameter of the task network that has a specified symbol.
     *
     * @param symbol The symbol.
     * @return the parameter of the tasknetwork that has a specified symbol or <code>null</code> if the
     *          method has no such parameter.
     */
    public final TypedSymbol getParameter(final Symbol symbol) {
        final int index = this.parameters.indexOf(symbol);
        return (index == -1) ? null : this.parameters.get(index);
    }

    /**
     * Sets a new list of parameters to this task network.
     *
     * @param parameters The list of parameters to set.
     * @throws NullPointerException if the specified parameters is null.
     */
    public final void setParameters(final List<TypedSymbol> parameters) {
        if (parameters == null) {
            throw new NullPointerException();
        }
        this.parameters = parameters;
    }

    /**
     * Returns the tasks of the task network.
     *
     * @return the tasks of the task network.
     */
    public final Exp getTasks() {
        return this.tasks;
    }

    /**
     *  Sets the tasks of the task network.
     *
     *  @param tasks The tasks to set.
     *  @throws NullPointerException if the specified parameters is null.
     */
    public final void setTasks(final Exp tasks) {
        if (tasks == null) {
            throw new NullPointerException();
        }
        this.tasks = tasks;
    }

    /**
     * Returns the ordering constraints between the tasks of the task network.
     *
     *
     * @return the ordering constraints of the task network.
     */
    public final Exp getOrderingConstraints() {
        return this.orderingConstraints;
    }

    /**
     *  Sets the ordering constraints between the tasks of the task network.
     *
     *  @param constraints The constraints to set.
     *  @throws NullPointerException if the specified parameters is null.
     */
    public final void setOrderingConstraints(final Exp constraints) {
        if (constraints == null) {
            throw new NullPointerException();
        }
        this.orderingConstraints = constraints;
    }

    /**
     * Returns the logicial constraints between the tasks of the task network.
     *
     * @return the logical constraints of the task network.
     */
    public final Exp getLogicalConstraints() {
        return this.logicalConstraints;
    }

    /**
     *  Sets the logical constraints between the tasks of the task network.
     *
     *  @param constraints The constraints to set.
     *  @throws NullPointerException if the specified parameters is null.
     */
    public final void setLogicalConstraints(final Exp constraints) {
        if (constraints == null) {
            throw new NullPointerException();
        }
        this.logicalConstraints = constraints;
    }

    /**
     * Returns if the task network is total ordered or not.
     *
     * @return true the method is total ordered or not, false otherwise.
     */
    public final boolean isTotallyOrdered() {
        return this.isTotallyOrdered;
    }

    /**
     * Set the boolean totally ordered flag of the task network to a specified value.
     *
     * @param flag The flag to set.
     */
    public final void setTotallyOrdered(final boolean flag) {
        this.isTotallyOrdered = flag;
    }

    /**
     * Returns the hash code value of the task network.
     *
     * @return the hash code value of the task network.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(parameters, tasks, orderingConstraints, logicalConstraints, isTotallyOrdered);
    }

    /**
     * Return if this task networl is equals to another object.
     *
     * @param object the other object.
     * @return <code>true</code> if <code>object</code> is not <code>null</code>, is an instance of
     *          the class <code>Op</code>, and has the same attributs; otherwise it returns <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object.getClass().equals(this.getClass())) {
            final TaskNetwork other = (TaskNetwork) object;
            return this.getParameters().equals(other.getParameters())
                && this.getTasks().equals(other.getTasks())
                && this.getOrderingConstraints().equals(other.getOrderingConstraints())
                && this.getLogicalConstraints().equals(other.getLogicalConstraints())
                && this.isTotallyOrdered() == other.isTotallyOrdered();
        }
        return false;
    }

    /**
     * Returns a PDDL string representation of the method.
     *
     * @return a string PDDL representation of the method.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        if (!this.parameters.isEmpty()) {
            str.append("  :parameters (");
            for (int i = 0; i < this.parameters.size() - 1; i++) {
                str.append(this.parameters.get(i)).append(" ");
            }
            str.append(this.parameters.get(this.parameters.size() - 1).toString());
        }

        if (this.isTotallyOrdered()) {
            str.append("  :ordered-tasks\n  ");
        } else {
            str.append("  :tasks\n  ");
        }
        if (!this.getTasks().getChildren().isEmpty()) {
            str.append(this.getTasks().toString("  ") + "\n");
        } else {
            str.append("()\n");
        }
        if (!this.getOrderingConstraints().getChildren().isEmpty()) {
            str.append("  :ordering\n  ");
            str.append(this.getOrderingConstraints().toString("  ") + "\n");
        }
        if (!this.getLogicalConstraints().getChildren().isEmpty()) {
            str.append("  :constraints\n  ");
            str.append(this.getLogicalConstraints().toString("  ") + "\n");
        }
        return str.toString();
    }
}
