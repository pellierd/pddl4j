/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.problem;

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
     * The time specifier of this numeric cosntraints.
     */
    private TimeSpecifier timeSpecifier;

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
        this.setTimeSpecifier(other.getTimeSpecifier());
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
        this.setTimeSpecifier(TimeSpecifier.NO_TIME_SPECIFIER);
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

    /**
     * Returns the time specifier of this numeric constraint.
     *
     * @return the time specifier of this numeric constraint.
     */
    public final TimeSpecifier getTimeSpecifier() {
        return this.timeSpecifier;
    }

    /**
     * Sets the time specifier of this numeric constraint.
     *
     * @param timeSpecifier the time specifier of this constraint.
     */
    public final void setTimeSpecifier(final TimeSpecifier timeSpecifier) {
        this.timeSpecifier = timeSpecifier;
    }

    /**
     * Returns if this numeric expression is durative. A numeric expression is durative if its time specifier is
     * <code>AT_START</code> or <code>AT_END</code>.
     *
     * @return <code>true</code> if the numeric expression is durative.
     */
    public final boolean isDurative() {
        return this.getTimeSpecifier() != TimeSpecifier.NO_TIME_SPECIFIER;
    }
}
