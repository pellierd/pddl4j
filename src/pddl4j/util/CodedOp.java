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

import java.io.Serializable;

/**
 * This interface defines the main methods of to access to an operator whatever its representation.
 * 
 * @author D. Pellier
 * @version 1.0 - 07.06.2010 
 */
public interface CodedOp extends Serializable {

	/**
	 * Return the name of this operator.
	 * 
	 * @return the name of this operator
	 */
	public String getName();

	/**
	 * Set the name of the operator.
	 * 
	 * @param name the name to set.
	 * @throws NullPointerException if <code>name == null</code>.
	 */
	public void setName(final String name) throws NullPointerException;

	/**
	 * Returns the type of the parameter at the specified index.
	 * 
	 * @param index the index of the parameter.
	 * @return the type of the parameter at the specified index.
	 * @throws ArrayIndexOutOfBoundsException if 0 <= index < arity does not hold. 
	 */
	public int getTypeOfParameters(final int index) throws ArrayIndexOutOfBoundsException;

	/**
	 * Set a new type the parameter at a specified index.
	 * 
	 * @param index the index of the parameter.
	 * @param type the type to set.
	 * @throws ArrayIndexOutOfBoundsException if 0 <= index < arity does not hold.
	 * @throws IllegalArgumentException if type < 0.
	 */
	public void setTypeOfParameter(final int index, final int type)
			throws ArrayIndexOutOfBoundsException, IllegalArgumentException;

	/**
	 * Returns the value of the parameter at a specified index.
	 * 
	 * @param index the index.
	 * @return the value of the parameter.
	 * @throws ArrayIndexOutOfBoundsException if 0 <= index < arity does not hold. 
	 */
	public int getValueOfParameter(final int index) throws ArrayIndexOutOfBoundsException;

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
	public void setValueOfParameter(final int index, final int value)
			throws ArrayIndexOutOfBoundsException, IllegalArgumentException;

	/**
	 * Returns the arity of the operator.
	 * 
	 * @return the arity of the operator.
	 */
	public int getArity();

}
