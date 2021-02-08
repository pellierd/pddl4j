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
 * This enum defines the arithmetic operators.
 *
 * @author D. Pellier
 * @version 1.0 - 27.10.2020
 * @since 4.0
 */
public enum ArithmeticOperator {

    /**
     * The addition arithmetic operator.
     */
    PLUS("+"),

    /**
     * The binary subtraction arithmetic operator.
     */
    MINUS("-"),

    /**
     * The unary subtraction arithmetic operator.
     */
    UMINUS("-"),

    /**
     * The arithmetic operator of division.
     */
    DIV("/"),

    /**
     * The arithmetic operator of multiplication.
     */
    MUL("*");

    /**
     * The image associate to the time specifier.
     */
    private String image;

    /**
     * Create a new arithmetic operator with a specific image.
     *
     * @param image the image of the arithmetic operator. The image of the arithmetic operator must be not null.
     */
    ArithmeticOperator(final String image) {
        this.image = image;
    }

    /**
     * Returns the image of this arithmetic operator.
     *
     * @return the image of this arithmetic operator.
     */
    public String getImage() {
        return this.image;
    }

}
