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

package fr.uga.pddl4j.util;

import fr.uga.pddl4j.parser.Connective;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used to encode expressions in compact encoding, i.e., with integer representation.
 *
 * @author D. Pellier
 * @version 1.0 - 07.04.2010
 */
public class IntExp implements Serializable {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The constant used to encode the specific predicate equal.
     */
    public static final int EQUAL_PREDICATE = -1;

    /**
     * The connective of the expression.
     */
    private Connective connective;

    /**
     * The integer representation of the predicate.
     */
    private int predicate;

    /**
     * The list of arguments of the expression. This attribute is used to store the argument of the
     * atomic expression.
     */
    private int[] arguments;

    /**
     * The children of the expression.
     */
    private List<IntExp> children;

    /**
     * The variable is used by quantified expression.
     */
    private int variable;

    /**
     * The type of the variable used by a quantified expression.
     */
    private int type;

    /**
     * The value of the expression. This attribute is used to store value of number expression.
     */
    private double value;

    /**
     * Create a new expression from an other one. This constructor make a deep copy of the specified
     * expression.
     *
     * @param other the expression.
     */
    public IntExp(final IntExp other) {
        this.connective = other.getConnective();
        this.predicate = other.getPredicate();
        this.arguments = other.getArguments();
        if (this.arguments != null) {
            this.arguments = Arrays.copyOf(other.getArguments(), other.getArguments().length);
        }
        List<IntExp> otherChildren = other.getChildren();
        this.children = new ArrayList<>(otherChildren.size());
        this.children.addAll(otherChildren.stream().map(IntExp::new).collect(Collectors.toList()));
        this.variable = other.getVariable();
        this.type = other.getType();
        this.value = other.getValue();
    }

    /**
     * Create a new expression with a specified connective.
     *
     * @param connective the connective of the expression.
     */
    public IntExp(final Connective connective) {
        this.connective = connective;
        this.arguments = null;
        this.children = new ArrayList<>();
    }

    /**
     * Return the connective of the expression.
     *
     * @return the connective of the expression.
     */
    public final Connective getConnective() {
        return this.connective;
    }

    /**
     * Set a new connective to this expression.
     *
     * @param connective the new connective to set.
     */
    public final void setConnective(final Connective connective) {
        if (connective == null) {
            throw new NullPointerException("connective == null");
        }
        this.connective = connective;
    }

    /**
     * Return the list of children of this expression.
     *
     * @return the list of children of this expression.
     */
    public final List<IntExp> getChildren() {
        return this.children;
    }

    /**
     * Return the predicate of this expression.
     *
     * @return the predicate
     */
    public final int getPredicate() {
        return predicate;
    }

    /**
     * Set a new predicate to this expression.
     *
     * @param predicate the new predicate to set
     */
    public final void setPredicate(int predicate) {
        this.predicate = predicate;
    }

    /**
     * Returns the list of argument of this expression.
     *
     * @return the arguments the list of arguments of this expression.
     */
    public final int[] getArguments() {
        return this.arguments;
    }

    /**
     * Set the arguments of the expression.
     *
     * @param args the arguments to set.
     */
    public final void setArguments(final int[] args) {
        this.arguments = args;
    }

    /**
     * Return the variable of the expression.
     *
     * @return the variable of the expression.
     */
    public final int getVariable() {
        return this.variable;
    }

    /**
     * Set a new quantified variable to the expression.
     *
     * @param variable the new quantified variable to set
     */
    public final void setVariable(final int variable) {
        this.variable = variable;
    }

    /**
     * Returns the type of the quantified variable of the expression.
     *
     * @return the type of the quantified variable of the expression.
     */
    public final int getType() {
        return this.type;
    }

    /**
     * Set a new type to the quantified variable of the expression.
     *
     * @param type the type to the quantified variable to set.
     */
    public final void setType(final int type) {
        this.type = type;
    }

    /**
     * Returns the value of this expression.
     *
     * @return the value of this expression.
     */
    public final double getValue() {
        return this.value;
    }

    /**
     * Set a new value to the expression.
     *
     * @param value the new value to set
     */
    public final void setValue(double value) {
        this.value = value;
    }

    /**
     * Affect this expression to an other. After affectation this expression and the other are
     * equal. No copy of the content of the other expression is done.
     *
     * @param other expression.
     */
    public final void affect(final IntExp other) {
        this.connective = other.getConnective();
        this.predicate = other.getPredicate();
        this.arguments = other.getArguments();
        this.children = other.getChildren();
        this.variable = other.getVariable();
        this.type = other.getType();
        this.value = other.getValue();
    }

    /**
     * Return if the expression is equal to an other object.
     *
     * @param object the other object.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof IntExp) {
            final IntExp other = (IntExp) object;
            return this.connective.equals(other.connective)
                && this.predicate == other.predicate
                && Arrays.equals(this.arguments, other.arguments)
                && Double.compare(this.value, other.value) == 0
                && this.variable == other.variable
                && this.type == other.type
                && this.children.equals(other.children);
        }
        return false;
    }

    /**
     * Return the hash code value of the expression.
     *
     * @return the hash code value of the expression.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.arguments);
        result = prime * result + this.children.hashCode();
        result = prime * result + this.connective.hashCode();
        result = prime * result + this.predicate;
        result = prime * result + this.type;
        long temp;
        temp = Double.doubleToLongBits(this.value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + this.variable;
        return result;
    }

}
