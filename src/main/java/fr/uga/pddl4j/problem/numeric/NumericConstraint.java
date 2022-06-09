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

import java.util.List;
import java.util.Objects;

/**
 * This class implements a numeric constraint.
 *
 * @author D. Pellier
 * @version 1.0 - 26.10.2020
 * @since 4.0
 */
public final class NumericConstraint extends AbstractNumericExpression {

    /**
     * The comparator of the numeric constraints.
     */
    private NumericComparator comparator;

    /**
     * Creates a deep copy of numeric constraints.
     *
     * @param other the numeric constraint to be copied.
     */
    public NumericConstraint(NumericConstraint other) {
        super(other);
        this.setComparator(other.getComparator());
    }

    /**
     * Creates a new numeric constraints with a specified comparator, left and right expression. The numeric constraint
     * is created with no specific time specifier.
     *
     * @param comparator the comparator the numeric constraint.
     * @param left the left expression of the numeric constraint.
     * @param right the right expression of the numeric constraint.
     */
    public NumericConstraint(final NumericComparator comparator, final ArithmeticExpression left,
                             final ArithmeticExpression right) {
        super(left, right);
        this.setComparator(comparator);
    }

    /**
     * Returns the comparator of the numeric constraint.
     *
     * @return the comparator of the numeric constraint.
     */
    public final NumericComparator getComparator() {
        return this.comparator;
    }

    /**
     * Sets the comparator of the numeric constraint.
     *
     * @param comparator the comparator to set.
     */
    public void setComparator(final NumericComparator comparator) {
        this.comparator = comparator;
    }


    /**
     * Returns the result of the evaluation of the numeric constraint.
     *
     * @param context the context of the evaluation, i.e., the numeric variables and their values needed to complete the
     *                evalution.
     * @return <code>true</code> if the numeric constraint is evaluated to true; <code>false</code> otherwise.
     */
    public boolean evaluate(final List<NumericVariable> context) {
        final double left = super.getLeftExpression().evaluate(context);
        final double right = super.getRightExpression().evaluate(context);
        boolean eval = false;
        switch (this.getComparator()) {
            case EQUAL:
                eval = left == right;
                break;
            case LESS:
                eval = left < right;
                break;
            case LESS_OR_EQUAL:
                eval = left <= right;
                break;
            case GREATER:
                eval = left > right;
                break;
            case GREATER_OR_EQUAL:
                eval = left >= right;
                break;
            default:
                // do nothing
                break;
        }
        return eval;
    }

    /**
     * Returns if a object is equal to this numeric constraint. A object is equal to this numeric constraints iff the
     * object is an instance of the class <code>NumericConstraint</code> and has the same comparator and left and right
     * exprssion.
     *
     * @param object the object to be compared.
     * @return <code>true</code> if the object in parameter is equal to this numeric constraint; <code>false</code>
     *      otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof NumericConstraint)) {
            return false;
        }
        final NumericConstraint other = (NumericConstraint) object;
        return this.getComparator() == other.getComparator()
            && Objects.equals(super.getRightExpression(), other.getRightExpression())
            && Objects.equals(super.getLeftExpression(), other.getLeftExpression());
    }

    /**
     * Returns the hash code value of this numeric constraint.
     *
     * @return the hash code value of this numeric constraint.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getComparator(), super.getRightExpression(),
            super.getLeftExpression());
    }

    /**
     * Returns a string representation of this numeric constraints.
     *
     * @return a string representation of this numeric constraints.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        final ArithmeticExpression left = super.getLeftExpression();
        final ArithmeticExpression right = super.getRightExpression();
        str.append("(");
        str.append(this.getComparator().getImage());
        str.append(" ");
        str.append(left);
        str.append(" ");
        str.append(right);
        str.append(")");
        return str.toString();
    }

}
