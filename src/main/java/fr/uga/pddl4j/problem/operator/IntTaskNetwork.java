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

import fr.uga.pddl4j.parser.PDDLConnective;

import java.io.Serializable;
import java.util.Arrays;

/**
 * This class implements an task network. This class is used to store compact representation of a task network
 * during the instantiation process.
 *
 * @author D. Pellier
 * @version 1.0 - 25.03.2020
 */
public final class IntTaskNetwork implements Serializable {

    /**
     * The list of parameters of the operator. The integer value correspond to the type of the
     * parameters.
     */
    private int[] parameters;

    /**
     * The values that represents the instantiated parameters of the operator.
     */
    private int[] instantiations;

    /**
     * The expression that represents the list of tasks of the task network.
     */
    private IntExpression tasks;

    /**
     * The expression that represents the ordering constraints of the task network.
     */
    private IntExpression orderingConstraints;

    /**
     * A boolean flag to indicate if the task network is totally ordered or not.
     */
    private boolean isTotallyOrdered;

    /**
     * Create a new task network. The tasks and the ordering constraints are empty and expression.
     *
     */
    public IntTaskNetwork() {
        this(0);
    }

    /**
     * Create a new task network. The tasks and the ordering constraints are empty and expression.
     *
     * @param arity the arity of the task network.
     */
    public IntTaskNetwork(final int arity) {
        this.tasks = new IntExpression(PDDLConnective.AND);
        this.orderingConstraints = new IntExpression(PDDLConnective.AND);
        this.parameters =  new int[arity];
        Arrays.fill(this.parameters, -1);
        this.instantiations = new int[arity];
        Arrays.fill(this.instantiations, -1);
    }

    /**
     * Create a new method from a specified task network. This constructor create a deep copy of the
     * specified task network.
     *
     * @param other the other tasknetwork.
     */
    public IntTaskNetwork(final IntTaskNetwork other) {
        super();
        this.tasks = new IntExpression(other.getTasks());
        this.orderingConstraints = new IntExpression(other.getOrderingConstraints());
        this.isTotallyOrdered = other.isTotallyOrdered;
        this.parameters = new int[other.arity()];
        System.arraycopy(other.getParameters(), 0, this.parameters, 0, other.arity());
        this.instantiations = new int[other.arity()];
        System.arraycopy(other.getInstantiations(), 0, this.instantiations, 0, other.arity());
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
    public IntTaskNetwork(final IntExpression tasks, final IntExpression orderingConstraints,
                          final boolean totallyOrdered) {
        super();
        this.tasks = tasks;
        this.orderingConstraints = orderingConstraints;
        this.isTotallyOrdered = totallyOrdered;
        this.parameters =  new int[0];
        this.instantiations = new int[0];
    }

    /**
     * Return the tasks of the method.
     *
     * @return the tasks of the method.
     */
    public final IntExpression getTasks() {
        return this.tasks;
    }

    /**
     * Set the tasks of the method.
     *
     * @param tasks the tasks to set.
     */
    public final void setTasks(final IntExpression tasks) {
        this.tasks = tasks;
    }

    /**
     * Return the ordering constraints of the method.
     *
     * @return the ordering constraints of the method.
     */
    public final IntExpression getOrderingConstraints() {
        return this.orderingConstraints;
    }

    /**
     * Set the new ordering constraints of the method.
     *
     * @param ordering the orderings constraints to set
     */
    public final void setOrderingConstraints(final IntExpression ordering) {
        this.orderingConstraints = ordering;
    }

    /**
     * Returns <code>true</code> if the task network is totally ordered.
     *
     * @return <code>true</code> if the task network is totally ordered, <code>false</code> otherwise.
     */
    public final boolean isTotallyOrdered() {
        return this.isTotallyOrdered;
    }

    /**
     * Set this task network totally ordered.
     *
     * @param flag the flag used to indicated that this task network is totally ordered.
     */
    public final void setTotallyOrdered(final boolean flag) {
        this.isTotallyOrdered = flag;
    }

    /**
     * Returns the list of parameters of the task network.
     *
     * @return the list of parameters of the task network.
     */
    public final int[] getParameters() {
        return Arrays.copyOf(parameters, parameters.length);
    }

    /**
     * Returns the values that represents the instantiated parameters of the task network.
     *
     * @return the values that represents the instantiated parameters of the task network.
     */
    public int[] getInstantiations() {
        return Arrays.copyOf(instantiations, instantiations.length);
    }

    /**
     * Returns the arity of the task network.
     *
     * @return the arity of the task network.
     */
    public final int arity() {
        return this.parameters.length;
    }

    /**
        * Returns the type of the parameter at the specified index.
        *
        * @param index the index of the parameter.
        * @return the type of the parameter at the specified index.
    */
    public final int getTypeOfParameters(final int index) {
        return this.parameters[index];
    }

    /**
     * Set a new type the parameter at a specified index.
     *
     * @param index the index of the parameter. The index must be in [0,arity[.
     * @param type  the type to set.
     */
    public final void setTypeOfParameter(final int index, final int type) {
        this.parameters[index] = type;
    }

    /**
     * Returns the value of the parameter at a specified index.
     *
     * @param index the index. The index must be in [0,arity[.
     * @return the value of the parameter.
     */
    public final int getValueOfParameter(final int index) {
        return this.instantiations[index];
    }

    /**
     * Instantiate a parameter of the operator at a specified index with a value.
     * <p>
     * The assumption is made that different operator parameters are instantiated with different
     * constants, i.e., the planner never generates actions like move(a,a) because we consider this
     * as a bad domain representation that should be revised. In fact, in actions with identical
     * constant parameters, all but one of the constants are superfluous and can be skipped from the
     * representation without loss of information.
     * </p>
     *
     * @param index the index of the parameter to instantiate. The index must be in [0,arity[.
     * @param value the value of instantiation.
     */
    public final void setValueOfParameter(final int index, final int value) {
        this.instantiations[index] = value;
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
