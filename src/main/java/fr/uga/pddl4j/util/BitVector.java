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

import java.util.BitSet;

/**
 * This class implements a bit vector.
 *
 * @author D. Pellier
 * @version 1.1 - 13.04.2010
 */
public class BitVector extends BitSet {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new <code>BitVector</code> with a specific size.
     *
     * @param size the size of the bit vector.
     */
    public BitVector(final int size) {
        super(size);
    }

    /**
     * Creates a new <code>BitVector</code>.
     */
    public BitVector() {
        super();
    }

    /**
     * Creates a new <code>BitVector</code> from a specified <code>BitExp</code>.
     *
     * @param exp the <code>BitExp</code> that represents <code>BitVector</code>.
     */
    public BitVector(final BitExp exp) {
        this();
        if (exp == null) {
            throw new NullPointerException("exp == null");
        }
        this.or(exp.getPositive());
        this.andNot(exp.getNegative());
    }

    /**
     * Creates a new <code>BitVector</code> from an other state. This constructor is the copy
     * constructor.
     *
     * @param vector the other <code>BitVector</code> to copy
     */
    public BitVector(final BitVector vector) {
        this();
        if (vector == null) {
            throw new NullPointerException("state == null");
        }
        this.or(vector);
    }

    /**
     * Returns <code>true</code> if this bit vector includes an other specified
     * <code>BitVector</code>. In other word, this method returns <code>true</code> if all the
     * bits set to 1 in the specified vector are also set to 1 in this vector.
     *
     * @param vector the other bit vector.
     * @return <code>true</code> if this bit vector includes an other specified
     * <code>BitVector</code>; <code>false</code> otherwise.
     */
    public final boolean include(final BitVector vector) {
        return this.getIntersection(vector).equals(vector);
    }

    /**
     * Returns <code>true</code> if this bit vector excludes an other specified
     * <code>BitVector</code>. In other word, this method returns <code>true</code> if all the
     * bits set to 1 in the specified vector are set to 0 in this vector.
     *
     * @param vector the other bit vector.
     * @return <code>true</code> if this bit vector is included a other specified
     * <code>BitVector</code>; <code>false</code> otherwise.
     */
    public final boolean exclude(final BitVector vector) {
        return !this.intersects(vector);
    }

    /**
     * Return a bit vector that represents the intersection of this bit vector with an other.
     *
     * @param vector the other bit vector.
     * @return Return a bit vector that represents the intersection of this bit vector with an other.
     */
    public final BitVector getIntersection(final BitVector vector) {
        final BitVector other = new BitVector(this);
        other.and(vector);
        return other;
    }
}
