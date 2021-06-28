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
 * This class implements an arithmetic expression.
 *
 * @author D. Pellier
 * @version 1.0 - 26.10.2020
 * @since 4.0
 */
public class ArithmeticExpression extends AbstractNumericExpression {

    /**
     * The default numeric fluent index.
     */
    public static final int DEFAULT_NUMERIC_FLUENT = -1;

    /**
     * The default value of the arithmetic expression.
     */
    public static final double DEFAULT_VALUE = 0.0;

    /**
     * The type of the arithmetic operators.
     */
    public enum Type {
        /**
         * The type operator.
         */
        OPERATOR,
        /**
         * The type number.
         */
        NUMBER,
        /**
         * The type variable.
         */
        VARIABLE;
    }

    /**
     * The type of the arithmetic expression.
     */
    private Type type;

    /**
     * The index of the numeric fluents of this arithmetic expression.
     */
    private int numericFluents;

    /**
     * The value of the arithmetic expression.
     */
    private double value;

    /**
     * The operator of the arithmetic expression.
     */
    private ArithmeticOperator operator;

    /**
     * Creates a deep copy of arithmetic expression from an other.
     *
     * @param other the other arithmetic expression.
     */
    public ArithmeticExpression(final ArithmeticExpression other) {
        super(other);
        this.setType(other.getType());
        this.setArithmeticOpertor(other.getArithmeticOperator());
        this.setValue(other.getValue());
        this.setNumericFluents(other.getNumericFluent());
        if (other.getLeftExpression() != null) {
            this.setLeftExpression(new ArithmeticExpression(other.getLeftExpression()));
        }
        if (other.getRightExpression() != null) {
            this.setRightExpression(new ArithmeticExpression(other.getRightExpression()));
        }
    }

    /**
     * Creates an arithmetic expression of type number with a specified value.
     *
     * @param value the value of this arithmetic expression of type number.
     */
    public ArithmeticExpression(final double value) {
        super(null, null);
        this.setType(Type.NUMBER);
        this.setArithmeticOpertor(null);
        this.setValue(value);
        this.setNumericFluents(ArithmeticExpression.DEFAULT_NUMERIC_FLUENT);
    }

    /**
     * Creates an arithmetic expression of type variable with for a specified numeric fluent.
     *
     * @param index the index of this numeric fluent that represents this variable.
     */
    public ArithmeticExpression(final int index) {
        super(null, null);
        this.setType(Type.VARIABLE);
        this.setArithmeticOpertor(null);
        this.setValue(ArithmeticExpression.DEFAULT_VALUE);
        this.setNumericFluents(index);
    }

    /**
     * Creates an arithmetic expression of type variable with for a specified numeric fluent and value.
     *
     * @param index the index of this numeric fluent that represents this variable.
     * @param value of this arithmetic expression.
     */
    public ArithmeticExpression(final int index, final double value) {
        super(null, null);
        this.setType(Type.VARIABLE);
        this.setArithmeticOpertor(null);
        this.setValue(value);
        this.setNumericFluents(index);
    }


    /**
     * Creates an arithmetic expression of type operator.
     *
     * @param operator the operator of the arithmetic expression.
     * @param left the left expression of the arithmetic expression.
     * @param right the left expression of the arithmetic expression.
     */
    public ArithmeticExpression(final ArithmeticOperator operator, final ArithmeticExpression left,
                                final ArithmeticExpression right) {
        super(left, right);
        this.setType(Type.OPERATOR);
        this.setArithmeticOpertor(operator);
        this.setValue(ArithmeticExpression.DEFAULT_VALUE);
        this.setNumericFluents(ArithmeticExpression.DEFAULT_NUMERIC_FLUENT);
        this.setLeftExpression(left);
        this.setRightExpression(right);
    }

    /**
     * Returns the type of the arithmetic expression.
     *
     * @return he type of the arithmetic expression.
     */
    public final Type getType() {
        return this.type;
    }

    /**
     * Sets the type of this arithmetic expression.
     *
     * @param type the type of this arithmetic expression.
     */
    public final void setType(final Type type) {
        this.type = type;
    }

    /**
     * Returns the index of the numeric fluent of this arithmetic expression.
     *
     * @return the index of the numeric fluent of this arithmetic expression.
     */
    public final int getNumericFluent() {
        return this.numericFluents;
    }

    /**
     * Sets the index of the numeric fluent of this arithmetic expression.
     *
     * @param index the index of the numeric fluent of this arithmetic expression.
     */
    public final void setNumericFluents(final int index) {
        this.numericFluents = index;
    }

    /**
     * Returns the value of the arithmetic expression. The value is used when the arithmetic expression is of type
     * NUMBER.
     *
     * @return the value of the arithmetic expression.
     */
    public final double getValue() {
        return this.value;
    }

    /**
     * Sets the value of this arithmetic expression.
     *
     * @param value the value to set.
     */
    public final void setValue(final double value) {
        this.value = value;
    }

    /**
     * Returns the operator of this arithmetic expression. The operator is not null if the arithmetic expression is of
     * type operator.
     *
     * @return the operator of this arithmetic expression.
     */
    public final ArithmeticOperator getArithmeticOperator() {
        return this.operator;
    }

    /**
     * Sets the operator of this arithmetic expression.
     *
     * @param operator the operator to set.
     */
    public final void setArithmeticOpertor(final ArithmeticOperator operator) {
        this.operator = operator;
    }

    /**
     * Evaluates an arithmetic expression and returns the result of its evaluation.
     *
     * @param context the context of the evaluation, i.e., the numeric variables and their respectives values.
     * @return the result of the evaluation of this arithmetic expression.
     */
    public final double evaluate(List<NumericVariable> context) {
        Double value = Double.NaN;
        switch (this.getType()) {
            case NUMBER:
                value = this.getValue();
                break;
            case VARIABLE:
                value = context.get(this.getNumericFluent()).getValue();
                break;
            case OPERATOR:
                switch (this.getArithmeticOperator()) {
                    case PLUS:
                        value = this.getLeftExpression().evaluate(context)
                            + this.getRightExpression().evaluate(context);
                        break;
                    case MINUS:
                        value = this.getLeftExpression().evaluate(context)
                            - this.getRightExpression().evaluate(context);
                        break;
                    case DIV:
                        value = this.getLeftExpression().evaluate(context)
                            / this.getRightExpression().evaluate(context);
                        break;
                    case MUL:
                        value = this.getLeftExpression().evaluate(context)
                            * this.getRightExpression().evaluate(context);
                        break;
                    case UMINUS:
                        value = -this.getLeftExpression().evaluate(context);
                        break;
                    default:
                        // do nothing
                        break;
                }
                break;
            default:
                // do nothing
                break;
        }
        return value;
    }

    /**
     * Returns if an object if equal to this arithmetic expression. The object is equal iff it is an instance of the
     * class <code>ArithmeticExpression</code> and it has the same type. For number, both arithmetic expression must
     * have the same value. For variable, both arithmetic expression must have the same numeric fluent. Finally, for
     * arithmetic operator expression, both expression must have the same operator and left and right expressions.
     *
     * @param object the object to be compared.
     * @return <code>true</code> if the object in parameter is equal to this arithmetic expression; <code>false</code>
     *      otherwise.
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ArithmeticExpression)) {
            return false;
        }
        final ArithmeticExpression other = (ArithmeticExpression) object;
        if (this.getType().equals(other.getType())) {
            switch (this.getType()) {
                case NUMBER:
                    return Double.compare(other.getValue(), getValue()) == 0;
                case VARIABLE:
                    return this.getNumericFluent() == other.getNumericFluent()
                        && Double.compare(other.getValue(), getValue()) == 0;
                case OPERATOR:
                    return this.getArithmeticOperator() == other.getArithmeticOperator()
                        && Objects.equals(this.getLeftExpression(), other.getLeftExpression())
                        && Objects.equals(this.getRightExpression(), other.getRightExpression());
                default:
                    // do nothing
                    break;
            }
        }
        return false;
    }

    /**
     * Returns the hash code value of this arithmetic expression.
     *
     * @return the hash code value of this arithmetic expression.
     */
    @Override
    public int hashCode() {
        int hashcode = 0;
        switch (this.getType()) {
            case NUMBER:
                hashcode = Objects.hash(this.getType(),this.getValue());
                break;
            case VARIABLE:
                hashcode = Objects.hash(this.getType(),this.getNumericFluent());
                break;
            case OPERATOR:
                hashcode = Objects.hash(this.getType(),this.getArithmeticOperator(), this.getLeftExpression(),
                    this.getRightExpression());
                break;
            default:
                // do nothing
                break;
        }
        return hashcode;
    }

    /**
     * Returns a string representation of this arithmetic expression.
     *
     * @return a string representation of this arithmetic expression.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        switch (this.getType()) {
            case NUMBER:
                str.append(this.getValue());
                break;
            case VARIABLE:
                str.append("X");
                str.append(this.getNumericFluent());
                str.append("[");
                str.append(this.getValue());
                str.append("]");
                break;
            case OPERATOR:
                switch (this.getArithmeticOperator()) {
                    case UMINUS:
                        str.append("(");
                        str.append(this.getArithmeticOperator().getImage());
                        str.append(" ");
                        str.append(this.getLeftExpression().toString());
                        str.append(")");
                        break;
                    case PLUS:
                    case DIV:
                    case MUL:
                    case MINUS:
                        str.append("(");
                        str.append(this.getArithmeticOperator().getImage());
                        str.append(" ");
                        str.append(this.getLeftExpression().toString());
                        str.append(" ");
                        str.append(this.getRightExpression().toString());
                        str.append(")");
                        break;
                    default:
                        // do nothing
                        break;
                }
                break;
            default:
                // do nothing
                break;
        }
        return str.toString();
    }
}
