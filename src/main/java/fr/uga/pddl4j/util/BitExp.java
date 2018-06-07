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

import java.io.Serializable;

/**
 * This class implements an bit set expression. A bit set expression is used to encode preconditions
 * (negative and positive) but also effects of the instantiated operators.
 *
 * @author D. Pellier
 * @version 1.0 - 07.06.2010
 */
public class BitExp implements Serializable {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The bit state used to store the positive facts of the expression.
     */
    private BitVector positive;

    /**
     * The bit set used to store the positive facts of the expression.
     */
    private BitVector negative;

    /**
     * Creates a new bit set expression. By default the expression has no positive and no negative
     * fact.
     */
    public BitExp() {
        this(new BitVector(), new BitVector());
    }

    /**
     * Creates a new bit expression from an other one.
     *
     * @param other the other one.
     */
    public BitExp(final BitExp other) {
        this();
        if (other == null) {
            throw new NullPointerException("other == null");
        }
        this.positive.or(other.positive);
        this.negative.or(other.negative);
    }

    /**
     * Creates a new bit expression from a specified positive and negative bit set that represent
     * respectively the positive and the negative fact of the expression.
     *
     * @param positive the bit set that represents the positive facts of the expression.
     * @param negative the bit set that represents the negative facts of the expression.
     */
    public BitExp(BitVector positive, BitVector negative) {
        if (positive == null || negative == null) {
            throw new NullPointerException("positive == null || negative == null");
        }
        this.positive = positive;
        this.negative = negative;
    }

    /**
     * Returns the bit set that represents the positive facts of the expression.
     *
     * @return the bit set that represents the positive facts of the expression.
     */
    public final BitVector getPositive() {
        return this.positive;
    }

    /**
     * Returns the bit set that represents the negative facts of the expression.
     *
     * @return the bit set that represents the negative facts of the expression.
     */
    public final BitVector getNegative() {
        return negative;
    }

    /**
     * Returns if the expression is empty, i.e., the expression has no positive and no negative
     * facts. Such an expression is always true.
     *
     * @return <code>true</code> if the expression is empty; <code>false</code> otherwise.
     */
    public final boolean isEmpty() {
        return this.positive.isEmpty() && this.negative.isEmpty();
    }

    /**
     * Returns the cardinality of the bit expression, i.e., the number of propositions contained in
     * the expression.
     *
     * @return the cardinality of the bit expression.
     */
    public final int cardinality() {
        return this.positive.cardinality() + this.negative.cardinality();
    }

    /**
     * Returns the hash code value of the expression.
     *
     * @return the hash code value of the expression.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.negative.hashCode();
        result = prime * result + this.positive.hashCode();
        return result;
    }

    /**
     * Return if a specified object is equals to this expression. The specified object is equal to
     * the expression if and only if the object is an instance of the class <code>BitExp</code>
     * and it has the same positive and negative facts.
     *
     * @param obj the specified object to compared.
     * @return <code>true</code> if the specified object is equal to the expression;
     * <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof BitExp) {
            BitExp other = (BitExp) obj;
            return this.positive.equals(other.positive) && this.negative.equals(other.negative);
        }
        return false;
    }

}
