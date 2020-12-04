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

import java.io.Serializable;

/**
 * This interface defines the main methods of to access to an operator whatever its representation.
 *
 * @author D. Pellier
 * @version 1.0 - 07.06.2010
 */
public interface GroundOperator extends Serializable {

    /**
     * Return the name of this operator.
     *
     * @return the name of this operator
     */
    String getName();

    /**
     * Set the name of the operator.
     *
     * @param name the name to set.
     */
    void setName(final String name);

    /**
     * Returns the type of the parameter at the specified index.
     *
     * @param index the index of the parameter. The index must be in [0, arity].
     * @return the type of the parameter at the specified index.
     */
    int getTypeOfParameters(final int index);

    /**
     * Set a new type the parameter at a specified index.
     *
     * @param index the index of the parameter. The index must be in [0, arity].
     * @param type  the type to set.
     */
    void setTypeOfParameter(final int index, final int type);

    /**
     * Returns the value of the parameter at a specified index.
     *
     * @param index the index. The index must be in [0, arity].
     * @return the value of the parameter.
     */
    int getValueOfParameter(final int index);

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
     * @param index the index of the parameter to instantiate. The index must be in [0, arity].
     * @param value the value of instantiation.
     */
    void setValueOfParameter(final int index, final int value);

    /**
     * Returns the arity of the operator.
     *
     * @return the arity of the operator.
     */
    int arity();

    /**
     * Returns the list of parameters of the operator.
     *
     * @return the list of parameters of the operator.
     */
    int[] getParameters();

    /**
     * Returns the values that represents the instantiated parameters of the operator.
     *
     * @return the values that represents the instantiated parameters of the operator.
     */
    int[] getInstantiations();

    /**
     * Return if the operator is already instantiated with the specified value.
     *
     * @param value the value.
     * @return <code>true</code> if the operator is already instantiated with the specified value; <code>false</code>
     *          otherwise.
     */
    boolean isAlreadyInstantiatedWith(final int value);

    /**
     * Returns <code>true</code> if the operator is dummy.
     *
     * @return <code>true</code> if the operator is dummy; <code>false</code> otherwise.
     */
    boolean isDummy();

    /**
     * Sets the dummy flag of the operator to a specified value.
     *
     * @param dummy the value of the dummy flag of the operator to set.
     */
    void setDummy(boolean dummy);

}
