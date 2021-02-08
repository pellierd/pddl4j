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
 * This class defines the methods common to all numerical expressions.
 *
 * @author D. Pellier
 * @version 1.0 - 27.10.2020
 * @since 4.0
 */
public abstract class AbstractNumericExpression implements NumericExpression {

    /**
     * The right expression of the numeric expression.
     */
    private ArithmeticExpression rightExpression;

    /**
     * The left expression of the numeric expression.
     */
    private ArithmeticExpression leftExpression;

    /**
     * Creates a deep copy of numeric expression.
     *
     * @param other the numeric expression to be copied.
     */
    protected AbstractNumericExpression(AbstractNumericExpression other) {
        if (other.getLeftExpression() != null) {
            this.setLeftExpression(new ArithmeticExpression(other.getLeftExpression()));
        }
        if (other.getRightExpression() != null) {
            this.setRightExpression(new ArithmeticExpression(other.getRightExpression()));
        }
    }

    /**
     * Creates a new numeric expression with a specified left and right expression and no time specifier.
     *
     * @param left the left expression of the numeric expression.
     * @param right the right expression of the numeric expression.
     */
    protected AbstractNumericExpression(final ArithmeticExpression left, final ArithmeticExpression right) {
        super();
        this.setLeftExpression(left);
        this.setRightExpression(right);
    }

    /**
     * Returns the right arithmetic expression of the numeric expression.
     *
     * @return the right arithmetic expression of the numeric expression.
     */
    public final ArithmeticExpression getRightExpression() {
        return this.rightExpression;
    }

    /**
     * Sets the right arithmetic expression of the numeric expression.
     *
     * @param right the right arithmetic expression of the numeric expression.
     */
    public final void setRightExpression(final ArithmeticExpression right) {
        this.rightExpression = right;
    }

    /**
     * Returns the left arithmetic expression of the numeric expression.
     *
     * @return the left arithmetic expression of the numeric expression.
     */
    public final ArithmeticExpression getLeftExpression() {
        return this.leftExpression;
    }

    /**
     * Sets the left arithmetic expression of the numeric expression.
     *
     * @param left the left arithmetic expression of the numeric expression.
     */
    public final void setLeftExpression(final ArithmeticExpression left) {
        this.leftExpression = left;
    }

}
