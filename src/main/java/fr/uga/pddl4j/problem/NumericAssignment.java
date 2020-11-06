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


import java.util.Objects;

/**
 * This class implements a numeric assignement. This class is used to specified numeric assignement in the effect of an
 * action.
 *
 * @author D. Pellier
 * @version 1.0 - 27.10.2020
 * @since 4.0
 */
public final class NumericAssignment extends AbstractNumericExpression {

    /**
     * The assignment that can be used in a numeric assignment.
     */
    public enum Operator {
        ASSIGN,
        INCREASE,
        DECREASE,
        SCALE_UP,
        SCALE_DOWN;
    }

    /**
     * The operator of the assignment expression.
     */
    private Operator operator;

    /**
     * Creates a deep copy of numeric assignment.
     *
     * @param other the numeric assignment to be copied.
     */
    public NumericAssignment(final NumericAssignment other) {
        super(other);
        this.setOperator(other.getOperator());
    }

    /**
     * Creates a new numeric assignement with a specified operator, left and right expression.
     *
     * @param operator the operator the numeric assignment.
     * @param left the left expression of the numeric assignment.
     * @param right the right expression of the numeric assignment.
     */
    public NumericAssignment(final Operator operator, final ArithmeticExpression left,
                             final ArithmeticExpression right) {
        super(left, right);
        this.setOperator(operator);
    }

    /**
     * Sets the operator of this numeric assignment.
     *
     * @param operator the operator to set.
     */
    public final void setOperator(final Operator operator) {
        this.operator = operator;
    }

    /**
     * Returns the operator of the numeric assignment.
     *
     * @return the operator of the numeric assignment.
     */
    public final Operator getOperator() {
        return this.operator;
    }

    /**
     * Returns if the numeric assignment is equal to an other object. The object is an instance of the class
     * <code>NumericAssignment</code> and has the same operator and left and right expressions.
     *
     * @param object the object to be compared.
     * @return <code>true</code> if the object in parameter is equal to this numeric assignmennt; <code>false</code>
     *      otherwise.
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof NumericAssignment)) {
            return false;
        }
        final NumericAssignment other = (NumericAssignment) object;
        return this.getOperator() == other.getOperator()
            && super.getLeftExpression().equals(other.getLeftExpression())
            && super.getRightExpression().equals(other.getRightExpression());
    }
    /**
     * Returns the value assigned.
     *
     * @return the value assigned.
     */
    public double getAssignedValue() {
        final ArithmeticExpression left = super.getLeftExpression();
        final ArithmeticExpression right = super.getRightExpression();
        switch (this.getOperator()) {
            case ASSIGN:
                left.setValue(right.evaluate());
                break;
            case INCREASE:
                left.setValue(left.getValue() + right.evaluate());
                break;
            case DECREASE:
                left.setValue(left.getValue() - right.evaluate());
                break;
            case SCALE_UP:
                left.setValue(left.getValue() * right.evaluate());
                break;
            case SCALE_DOWN:
                left.setValue(left.getValue() / right.evaluate());
                break;
        }
        return left.getValue();
    }

    /**
     * Returns the hash code value of this numeric assignment.
     *
     * @return the hash code value of this numeric assignment.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getOperator(), super.getLeftExpression(), super.getRightExpression());
    }

    /**
     * Returns a string representation of this numeric assignment.
     *
     * @return a string representation of this numeric assignment.
     */
    public String toString() {
        final StringBuilder str = new StringBuilder();
        if (this.isDurative()) {
            str.append("(");
            str.append(super.getTimeSpecifier().getImage());
            str.append(" ");
        }
        final ArithmeticExpression left = super.getLeftExpression();
        final ArithmeticExpression right = super.getRightExpression();
        switch (this.getOperator()) {
            case ASSIGN:
                str.append("(assign ");
                str.append(left);
                str.append(" ");
                str.append(right);
                str.append(")");
                break;
            case INCREASE:
                str.append("(increase ");
                str.append(left);
                str.append(" ");
                str.append(right);
                str.append(")");
                break;
            case DECREASE:
                str.append("(decrease ");
                str.append(left);
                str.append(" ");
                str.append(right);
                str.append(")");
                break;
            case SCALE_UP:
                str.append("(scale-up ");
                str.append(left);
                str.append(" ");
                str.append(right);
                str.append(")");
                break;
            case SCALE_DOWN:
                str.append("(scale-down ");
                str.append(left);
                str.append(" ");
                str.append(right);
                str.append(")");
                break;
        }
        return str.toString();
    }
}

