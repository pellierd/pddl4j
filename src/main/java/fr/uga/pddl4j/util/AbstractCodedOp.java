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

package fr.uga.pddl4j.util;

import java.util.Arrays;

/**
 * This abstract class implements the common part of an operator what ever its representation,
 * i.e., integer or bit set.
 *
 * @author D. Pellier
 * @version 1.0 - 07.06.2010
 */
public abstract class AbstractCodedOp implements CodedOp {

    /**
     * The name of the operator.
     */
    protected String name;

    /**
     * The list of parameters of the operator. The integer value correspond to the type of the
     * parameters.
     */
    protected int[] parameters;

    /**
     * The values that represents the instantiated parameters of the operator.
     */
    protected int[] instantiations;

    /**
     * The flag used to indicate if the operator is dummy. By default, an operator is not dummy.
     */
    private boolean dummy;

    /**
     * The cost of the operator.
     */
    private double cost;

    /**
     * The duration of the operator.
     */
    private double duration;

    /**
     * Creates a new operator from an other.
     *
     * @param other the other operator.
     * @throws NullPointerException if <code>other == null</code>.
     */
    protected AbstractCodedOp(final BitOp other) {
        if (other == null) {
            throw new NullPointerException("other == null");
        }
        this.setName(other.getName());
        this.parameters = new int[other.getArity()];
        System.arraycopy(other.parameters, 0, this.parameters, 0, other.getArity());
        this.instantiations = new int[other.getArity()];
        System.arraycopy(other.instantiations, 0, this.instantiations, 0, other.getArity());
        this.dummy = other.isDummy();
        this.duration = other.getDuration();
        this.cost = other.getCost();
    }

    /**
     * Creates a new operator with a default cost and duration set to 1.0.
     *
     * @param name     the name of the operator.
     * @param arity    the arity of the operator.
     * @param duration the duration ot the operator.
     * @param cost     the cost of the operator.
     * @throws NullPointerException if <code>name == null</code>.
     */
    protected AbstractCodedOp(final String name, final int arity, final double duration, final double cost) {
        this.setName(name);
        this.parameters = new int[arity];
        this.instantiations = new int[arity];
        this.duration = duration;
        this.cost = cost;
        this.dummy = false;
    }

    /**
     * Creates a new operator with a default cost and duration set to 1.0.
     *
     * @param name  the name of the operator.
     * @param arity the arity of the operator.
     * @throws NullPointerException if <code>name == null</code>.
     */
    protected AbstractCodedOp(final String name, final int arity) {
        this(name, arity, CodedOp.DEFAULT_DURATION, CodedOp.DEFAULT_COST);
    }

    /**
     * Creates a new operator. The default cost and duration of the operator is set to 1.0.
     *
     * @param name           the name of the operator.
     * @param parameters     the types of the parameters.
     * @param instantiations the values of the parameters.
     * @throws NullPointerException     if
     *                                  <code>name == null || parameters == null || instantiations == null</code>.
     * @throws IllegalArgumentException if <code>parameters.length != instantiations.length</code>.
     */
    protected AbstractCodedOp(final String name, final int[] parameters, final int[] instantiations) {
        if (name == null || parameters == null || instantiations == null) {
            throw new NullPointerException("name == null || parameters == null || instantiations == null");
        }

        if (parameters.length != instantiations.length) {
            throw new IllegalArgumentException("parameters.length != instantiations.length");
        }

        this.name = name;
        this.parameters = parameters;
        this.instantiations = instantiations;
        this.cost = CodedOp.DEFAULT_COST;
        this.duration = CodedOp.DEFAULT_DURATION;
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
     * @throws NullPointerException if <code>name == null</code>.
     */
    @Override
    public final void setName(final String name) {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
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
     * @param index the index of the parameter.
     * @param type  the type to set.
     * @throws IllegalArgumentException if type &#60; 0.
     */
    @Override
    public final void setTypeOfParameter(final int index, final int type) {
        if (type < 0) {
            throw new IllegalArgumentException("type < 0");
        }
        this.parameters[index] = type;
    }

    /**
     * Returns the value of the parameter at a specified index.
     *
     * @param index the index.
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
     * as a bad domain representation that should be revised. In fact, in operators with identical
     * constant parameters, all but one of the constants are superfluous and can be skipped from the
     * representation without loss of information.
     * </p>
     *
     * @param index the index of the parameter to instantiate.
     * @param value the value of instantiation.
     * @throws IllegalArgumentException if value &#60; 0.
     */
    @Override
    public final void setValueOfParameter(final int index, final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value < 0");
        }
        this.instantiations[index] = value;
    }

    /**
     * Returns the arity of the operator.
     *
     * @return the arity of the operator.
     */
    @Override
    public final int getArity() {
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
     * Returns the duration of the operator.
     *
     * @return the duration of the operator.
     */
    @Override
    public final double getDuration() {
        return this.duration;
    }

    /**
     * Sets the duration of the operator.
     *
     * @param duration the duration to set.
     */
    @Override
    public final void setDuration(final double duration) {
        this.duration = duration;
    }

    /**
     * Returns the cost of the operator.
     *
     * @return the cost of the operator.
     */
    @Override
    public final double getCost() {
        return this.cost;
    }

    /**
     * Sets the cost of the operator.
     *
     * @param cost the cost to set.
     */
    @Override
    public final void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns the list of parameters of the operator.
     *
     * @return the list of parameters of the operator.
     */
    @Override
    public int[] getParameters() {
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
     * Returns <code>true</code> if this operator is equal to an object. This
     * method returns <code>true</code> if the object is a not null instance
     * of the class <code>CodedOp</code> and both operator have the same name.
     *
     * @param obj the object to be compared.
     * @return <code>true</code> if this operator is equal to an object;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof CodedOp) {
            final CodedOp other = (CodedOp) obj;
            return this.getName().equals(other.getName())
                && Arrays.equals(this.getInstantiations(), ((CodedOp) obj).getInstantiations());
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
    public int hashCode() {
        return this.getName().hashCode();
    }

}
