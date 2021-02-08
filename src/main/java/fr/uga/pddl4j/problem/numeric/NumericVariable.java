/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.problem.numeric;

/**
 * This class defines the methods to manipulate a numeric variable.
 *
 * @author D. Pellier
 * @version 1.0 - 26.10.2020
 * @since 4.0
 */
public class NumericVariable extends ArithmeticExpression {

    /**
     * The index of the duration variable.
     */
    public static final int DURATION = -1;

    /**
     * Create a new numeric variable from an other. This constructor creates a deep copy of the object in parameter.
     *
     * @param other the other numeric variable to be copied.
     */
    public NumericVariable(final NumericVariable other) {
        super(other);
    }

    /**
     * Create a new numeric variable.
     *
     * @param index the index of this numeric fluent that represents this variable.
     */
    public NumericVariable(final int index) {
        super(index);
    }

    /**
     * Creates a new numeric variable for a specified numeric fluent and value.
     *
     * @param index the index of this numeric fluent that represents this variable.
     * @param value the value of the numeric variable.
     */
    public NumericVariable(final int index, final double value) {
        super(index, value);
    }

}
