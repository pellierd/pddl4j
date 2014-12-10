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
 * This class implements a logical state.
 * 
 * @author D. Pellier
 * @version 1.1 - 13.04.2010
 */
public class BitState extends BitVector {

	/**
	 * Creates a new state.
	 */
	public BitState() {
		super();
	}

	/**
	 * Creates a new state from a specified <code>BitExp</code>.
	 * 
	 * @param exp the <code>BitExp</code> that represents the logical state.
	 * @throws NullPointerException if <code>exp == null</code>.
	 */
	public BitState(final BitExp exp) throws NullPointerException {
		this();
		if (exp == null)
			throw new NullPointerException("exp == null");
		this.or(exp.getPositive());
		this.andNot(exp.getNegative());
	}

	/**
	 * Creates a new state from an other state. This constructor is the copy constructor.
	 * 
	 * @param state the other state to copy.
	 * @throws NullPointerException if <code>state == null</code>.
	 */
	public BitState(final BitState state) throws NullPointerException {
		this();
		if (state == null)
			throw new NullPointerException("state == null");
		this.or(state);
	}

	/**
	 * Applies a specified <code>BitExp</code> to this state. In other word, the positive facts of
	 * the specified expression are added to this state and the negative ones are delete.
	 * 
	 * @param exp the expression to apply.
	 * @throws NullPointerException if <code>exp == null</code>.
	 */
	public final void apply(final BitExp exp) throws NullPointerException {
		if (exp == null)
			throw new NullPointerException("exp == null");
		this.or(exp.getPositive());
		this.andNot(exp.getNegative());
	}

	/**
	 * Returns <code>true</code> if this state satisfy a specified expression.
	 * 
	 * @param exp the expression to be tested.
	 * @return <code>true</code> if this state satisfy a specified expression; <code>false</code>
	 *         otherwise.
	 * @throws NullPointerException if <code>exp == null</code>.
	 */
	public final boolean satisfy(final BitExp exp) throws NullPointerException {
		if (exp == null)
			throw new NullPointerException("exp == null");		
		return this.include(exp.getPositive()) && this.exclude(exp.getNegative());
	
	}

}
