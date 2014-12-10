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

package pddl4j.util;

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
	 * Creates a new operator from an other.
	 * 
	 * @param other the other operator.
	 * @throws NullPointerException if <code>other == null</code>.
	 */
	protected AbstractCodedOp(final BitOp other) throws NullPointerException {
		if (other == null)
			throw new NullPointerException("other == null");
		this.setName(other.getName());
		this.parameters = new int[other.getArity()];
		for (int i = 0; i < other.getArity(); i++) {
			this.parameters[i] = other.parameters[i];
		}
		this.instantiations = new int[other.getArity()];
		for (int i = 0; i < other.getArity(); i++) {
			this.instantiations[i] = other.instantiations[i];
		}
		this.dummy = other.isDummy();
	}
	
	/**
	 * Creates a new operator.
	 * 
	 * @param name the name of the operator.
	 * @param arity the arity of the operator.
	 * @throws NullPointerException if <code>name == null</code>.
	 */
	protected AbstractCodedOp(final String name, final int arity) throws NullPointerException {
		this.setName(name);
		this.parameters = new int[arity];
		this.instantiations = new int[arity];
		this.dummy = false;
	}

	/**
	 * Creates a new operator.
	 * 
	 * @param name the name of the operator.
	 * @param parameters the types of the parameters.
	 * @param instantiations the values of the parameters.
	 * @throws NullPointerException if
	 *             <code>name == null || parameters == null || instantiations == null</code>.
	 * @throws IllegalArgumentException if <code>parameters.length != instantiations.length</code>.
	 */
	protected AbstractCodedOp(final String name, final int[] parameters, final int[] instantiations) {
		if (parameters.length != instantiations.length)
			throw new IllegalArgumentException("parameters.length != instantiations.length");
		if (name == null || parameters == null || instantiations == null)
			throw new NullPointerException(
					"name == null || parameters == null || instantiations == null");
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
	public final String getName() {
		return this.name;
	}

	/**
	 * Set the name of the operator.
	 * 
	 * @param name the name to set.
	 * @throws NullPointerException if <code>name == null</code>.
	 */
	public final void setName(final String name) throws NullPointerException {
		if (name == null)
			throw new NullPointerException("name == null");
		this.name = name;
	}

	/**
	 * Returns the type of the parameter at the specified index.
	 * 
	 * @param index the index of the parameter.
	 * @return the type of the parameter at the specified index.
	 * @throws ArrayIndexOutOfBoundsException if 0 <= index < arity does not hold. 
	 */
	public final int getTypeOfParameters(final int index) throws ArrayIndexOutOfBoundsException {
		return this.parameters[index];
	}

	/**
	 * Set a new type the parameter at a specified index.
	 * 
	 * @param index the index of the parameter.
	 * @param type the type to set.
	 * @throws ArrayIndexOutOfBoundsException if 0 <= index < arity does not hold.
	 * @throws IllegalArgumentException if type < 0.
	 */
	public final void setTypeOfParameter(final int index, final int type)
			throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
		if (type < 0)
			throw new IllegalArgumentException("type < 0");
		this.parameters[index] = type;
	}

	/**
	 * Returns the value of the parameter at a specified index.
	 * 
	 * @param index the index.
	 * @return the value of the parameter.
	 * @throws ArrayIndexOutOfBoundsException if 0 <= index < arity does not hold. 
	 */
	public final int getValueOfParameter(final int index) throws ArrayIndexOutOfBoundsException {
		return this.instantiations[index];
	}

	/**
	 * Instantiate a parameter of the operator at a specified index with a value.
	 * 
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
	 * @throws ArrayIndexOutOfBoundsException if 0 <= index < arity does not hold.
	 * @throws IllegalArgumentException if value < 0.
	 */
	public final void setValueOfParameter(final int index, final int value)
			throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
		if (value < 0)
			throw new IllegalArgumentException("value < 0");
		this.instantiations[index] = value;
	}

	/**
	 * Returns the arity of the operator.
	 * 
	 * @return the arity of the operator.
	 */
	public final int getArity() {
		return this.parameters.length;
	}
	
	/**
	 * Returns <code>true</code> if the operator is dummy.
	 * 
	 * @return <code>true</code> if the operator is dummy; <code<false</code> otherwise.
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
	 * Returns <code>true</code> if this operator is equal to an object. This
	 * method returns <code>true</code> if the object is a not null instance
	 * of the class <code>CodedOp</code> and both operator have the same name.
	 *
	 * @param obj the object to be compared.
	 * @return <code>true</code> if this operator is equal to an object;
	 *         <code>false</code> otherwise.
	 */
	public boolean equals(final Object obj) {
		if (obj != null && obj instanceof CodedOp) {
			final CodedOp other = (CodedOp) obj;
			return this.getName().equals(other.getName());
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
	public int hashCode() {
		return this.getName().hashCode();
	}

}
