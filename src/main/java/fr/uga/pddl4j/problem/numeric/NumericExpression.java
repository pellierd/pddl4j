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

import java.io.Serializable;

/**
 * This interface defines the methods of the numeric expression.
 *
 * @author D. Pellier
 * @version 1.0 - 27.10.2020
 * @since 4.0
 */
public interface NumericExpression extends Serializable {

    /**
     * Returns the right arithmetic expression of the numeric expression.
     *
     * @return the right arithmetic expression of the numeric expression.
     */
    ArithmeticExpression getRightExpression();

    /**
     * Sets the right arithmetic expression of the numeric expression.
     *
     * @param rightExpression the right arithmetic expression of the numeric expression.
     */
    void setRightExpression(final ArithmeticExpression rightExpression);

    /**
     * Returns the left arithmetic expression of the numeric expression.
     *
     * @return the left arithmetic expression of the numeric expression.
     */
    ArithmeticExpression getLeftExpression();

}
