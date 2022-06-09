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

import java.util.Arrays;

/**
 * This abstract class implements the common part of an ground operator (action or method) what ever its representation,
 * i.e., integer or bit set.
 *
 * @author D. Pellier
 * @version 1.0 - 07.06.2010
 */
public abstract class AbstractInstantiatedOperator implements Operator {

    /**
     * The name of the operator.
     */
    private String name;

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
     * The flag used to indicate if the operator is dummy. By default, an operator is not dummy.
     */
    private boolean dummy;

    /**
     * Creates a new operator.
     */
    private AbstractInstantiatedOperator() {
        super();
    }

    /**
     * Creates a new operator from an other.
     *
     * @param other the other operator.
     */
    protected AbstractInstantiatedOperator(final Operator other) {
        super();
        this.setName(other.getName());
        this.parameters = new int[other.arity()];
        System.arraycopy(other.getParameters(), 0, this.parameters, 0, other.arity());
        this.instantiations = new int[other.arity()];
        System.arraycopy(other.getInstantiations(), 0, this.instantiations, 0, other.arity());
        this.dummy = other.isDummy();
    }

    /**
     * Creates a new operator. The parameters and instantiation are initialized with 0.
     *
     * @param name     the name of the operator.
     * @param arity    the arity of the operator.
     */
    protected AbstractInstantiatedOperator(final String name, final int arity) {
        this(name, new int[arity], new int[arity]);
        Arrays.fill(this.parameters, -1);
        Arrays.fill(this.instantiations, -1);
        this.dummy = false;

    }

    /**
     * Creates a new operator. The length of the parameters and the length of instantiations must be the same.
     *
     * @param name           the name of the operator.
     * @param parameters     the types of the parameters.
     * @param instantiations the values of the parameters.
     */
    protected AbstractInstantiatedOperator(final String name, final int[] parameters, final int[] instantiations) {
        super();
        this.name = name;
        this.parameters = parameters;
        this.instantiations = instantiations;
        this.dummy = false;
    }

    /**
     * Return the name of this operator.
     *
     * @return the name of this operator
     */
    @Override
    public final String getName() {
        return this.name;
    }

    /**
     * Set the name of the operator.
     *
     * @param name the name to set.
     */
    @Override
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns the type of the parameter at the specified index.
     *
     * @param index the index of the parameter.
     * @return the type of the parameter at the specified index.
     */
    @Override
    public final int getTypeOfParameters(final int index) {
        return this.parameters[index];
    }

    /**
     * Set a new type the parameter at a specified index.
     *
     * @param index the index of the parameter. The index must be in [0,arity[.
     * @param type  the type to set.
     */
    @Override
    public final void setTypeOfParameter(final int index, final int type) {
        this.parameters[index] = type;
    }

    /**
     * Returns the value of the parameter at a specified index.
     *
     * @param index the index. The index must be in [0,arity[.
     * @return the value of the parameter.
     */
    @Override
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
    @Override
    public final void setValueOfParameter(final int index, final int value) {
        this.instantiations[index] = value;
    }

    /**
     * Returns the arity of the operator.
     *
     * @return the arity of the operator.
     */
    @Override
    public final int arity() {
        return this.parameters.length;
    }

    /**
     * Returns <code>true</code> if the operator is dummy.
     *
     * @return <code>true</code> if the operator is dummy; <code>false</code> otherwise.
     */
    public final boolean isDummy() {
        return this.dummy;
    }

    /**
     * Sets the dummy flag of the operator to a specified value.
     *
     * @param dummy the value of the dummy flag of the operator to set.
     */
    public final void setDummy(boolean dummy) {
        this.dummy = dummy;
    }

    /**
     * Returns the list of parameters of the operator.
     *
     * @return the list of parameters of the operator.
     */
    @Override
    public final int[] getParameters() {
        return Arrays.copyOf(parameters, parameters.length);
    }

    /**
     * Returns the values that represents the instantiated parameters of the operator.
     *
     * @return the values that represents the instantiated parameters of the operator.
     */
    @Override
    public int[] getInstantiations() {
        return Arrays.copyOf(instantiations, instantiations.length);
    }

    /**
     * Return if the operator is already instantiated with the specified value.
     *
     * @param value the value.
     * @return <code>true</code> if the operator is already instantiated with the specified value; <code>false</code>
     *          otherwise.
     */
    public final boolean isAlreadyInstantiatedWith(final int value) {
        int i = 0;
        boolean instantiated = false;
        while (i < this.instantiations.length && !instantiated) {
            if (this.instantiations[i] == value) {
                instantiated = true;
            }
            i++;
        }
        return instantiated;
    }

    /**
     * Returns <code>true</code> if this operator is equal to an object. This
     * method returns <code>true</code> if the object is a not null instance
     * of the class <code>AssignementOperator</code> and both operator have the same name.
     *
     * @param obj the object to be compared.
     * @return <code>true</code> if this operator is equal to an object;
     * <code>false</code> otherwise.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (obj != null && obj instanceof Operator) {
            final Operator other = (Operator) obj;
            return this.getName().equals(other.getName())
                && Arrays.equals(this.getInstantiations(), ((Operator) obj).getInstantiations());
        }
        return false;
    }

    /**
     * Returns a hash code value for this operator. This method is supported
     * for the benefit of hash tables such as those provided by
     * <code>java.util.Hashtable</code>.
     *
     * @return a hash code value for this operator.
     */
    @Override
    public final int hashCode() {
        return this.getName().hashCode();
    }

}
