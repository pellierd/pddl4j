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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class implements a task network.
 *
 * @author D. Pellier
 * @version 1.0 - 20.12.2019
 */
public class PDDLTaskNetwork implements Serializable {

    /**
     * The parameter of the task network.
     */
    private List<PDDLTypedSymbol> parameters;

    /**
     * The tasks of the task network.
     */
    private PDDLExpression tasks;

    /**
     * The ordering constraints of the task network.
     */
    private PDDLExpression orderingConstraints;

    /**
     * The constraints of the task network.
     */
    private PDDLExpression logicalConstraints;

    /**
     * A boolean flag to indicate if the task network is totally ordered or not.
     */
    private boolean isTotallyOrdered;

    /**
     * Create a new task network.
     */
    protected PDDLTaskNetwork() {
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
    public PDDLTaskNetwork(final PDDLTaskNetwork other) {
        this.parameters = new ArrayList<>();
        for (PDDLTypedSymbol param : other.getParameters()) {
            this.parameters.add(new PDDLTypedSymbol(param));
        }
        this.tasks = new PDDLExpression(other.getTasks());
        this.orderingConstraints = new PDDLExpression(other.getOrderingConstraints());
        this.logicalConstraints = new PDDLExpression(other.getLogicalConstraints());
        this.isTotallyOrdered = other.isTotallyOrdered();
    }

    /**
     * Creates a task network with a specified list of parameters, list of tasks, ordering and logicial constraints.
     *
     * @param tasks The tasks of the task network.
     * @param ordering The ordering constraints between the tasks of the task network.
     * @param logical The logicial constraint between the tasks of the task network.
     * @param ordered The flag to indicate if the tasks of the task network are totally ordered or not.
     * @throws NullPointerException if one of the specified parameter except the precondition is null.
     */
    public PDDLTaskNetwork(final PDDLExpression tasks,
                           final PDDLExpression ordering, final PDDLExpression logical, final boolean ordered) {
        super();
        this.setParameters(new ArrayList<>());
        this.setTasks(tasks);
        this.setOrderingConstraints(ordering);
        this.setLogicalConstraints(logical);
        this.setTotallyOrdered(ordered);
    }

    /**
     * Creates a task network with a specified list of parameters, list of tasks, ordering and logicial constraints.
     *
     * @param parameters the parameters of the task network.
     * @param tasks The tasks of the task network.
     * @param ordering The ordering constraints between the tasks of the task network.
     * @param logical The logicial constraint between the tasks of the task network.
     * @param ordered The flag to indicate if the tasks of the task network are totally ordered or not.
     * @throws NullPointerException if one of the specified parameter except the precondition is null.
     */
    public PDDLTaskNetwork(final List<PDDLTypedSymbol> parameters, final PDDLExpression tasks,
                           final PDDLExpression ordering, final PDDLExpression logical, final boolean ordered) {
        super();
        this.setParameters(parameters);
        this.setTasks(tasks);
        this.setOrderingConstraints(ordering);
        this.setLogicalConstraints(logical);
        this.setTotallyOrdered(ordered);
    }

    /**
     * Returns the parameters of the task network.
     *
     * @return the parameters of the task network.
     */
    public final List<PDDLTypedSymbol> getParameters() {
        return this.parameters;
    }

    /**
     * Sets the parameters of the task network.
     *
     * @param parameters the parameters to set.
     */
    public void setParameters(List<PDDLTypedSymbol> parameters) {
        this.parameters = parameters;
    }

    /**
     * Returns the tasks of the task network.
     *
     * @return the tasks of the task network.
     */
    public final PDDLExpression getTasks() {
        return this.tasks;
    }

    /**
     *  Sets the tasks of the task network.
     *
     *  @param tasks The tasks to set.
     */
    public final void setTasks(final PDDLExpression tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the ordering constraints between the tasks of the task network.
     *
     *
     * @return the ordering constraints of the task network.
     */
    public final PDDLExpression getOrderingConstraints() {
        return this.orderingConstraints;
    }

    /**
     *  Sets the ordering constraints between the tasks of the task network.
     *
     *  @param constraints The constraints to set.
     */
    public final void setOrderingConstraints(final PDDLExpression constraints) {
        this.orderingConstraints = constraints;
    }

    /**
     * Returns the logicial constraints between the tasks of the task network.
     *
     * @return the logical constraints of the task network.
     */
    public final PDDLExpression getLogicalConstraints() {
        return this.logicalConstraints;
    }

    /**
     *  Sets the logical constraints between the tasks of the task network.
     *
     *  @param constraints The constraints to set.
     */
    public final void setLogicalConstraints(final PDDLExpression constraints) {
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
        return Objects.hash(this.tasks, this.orderingConstraints, this.logicalConstraints, this.isTotallyOrdered);
    }

    /**
     * Return if this task networl is equals to another object.
     *
     * @param object the other object.
     * @return <code>true</code> if <code>object</code> is not <code>null</code>, is an instance of
     *          the class <code>Action</code>, and has the same attributs; otherwise it returns <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object.getClass().equals(this.getClass())) {
            final PDDLTaskNetwork other = (PDDLTaskNetwork) object;
            return this.getTasks().equals(other.getTasks())
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
        str.append("   :parameters (");
        for (int i = 0; i < this.getParameters().size() - 1; i++) {
            str.append(this.getParameters().get(i)).append(" ");
        }
        if (!this.getParameters().isEmpty()) {
            str.append(this.getParameters().get(this.getParameters().size() - 1).toString());
        }
        str.append(")\n");
        if (this.isTotallyOrdered()) {
            str.append("  :ordered-tasks\n  ");
        } else {
            str.append("  :subtasks\n  ");
        }
        if (!this.getTasks().getChildren().isEmpty()) {
            str.append(this.getTasks().toString("  "));
        } else {
            str.append("()\n");
        }
        if (!this.getOrderingConstraints().getChildren().isEmpty()) {
            str.append("\n  :ordering\n  ");
            str.append(this.getOrderingConstraints().toString("  "));
        }
        if (!this.getLogicalConstraints().getChildren().isEmpty()) {
            str.append("\n  :constraints\n  ");
            str.append(this.getLogicalConstraints().toString("  "));
        }
        return str.toString();
    }
}
