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

import fr.uga.pddl4j.problem.operator.Condition;

import java.lang.reflect.Field;
import java.util.BitSet;

/**
 * This class implements a bit vector.
 * <p>
 * Revisions:
 * <ul>
 * <li>26.06.2020: Add shift methods.</li>
 * </ul>
 * </p>
 *
 * @author D. Pellier
 * @version 1.2 - 13.04.2010
 */
public class BitVector extends BitSet {

    /**
     * The words used to store bitset.
     */
    private long[] words;

    /**
     * The worlds field used to store the value of bit vector.
     */
    private static Field wordsField;

    static {
        try {
            BitVector.wordsField = BitSet.class.getDeclaredField("words");
        } catch (NoSuchFieldException e) {
            throw new IllegalStateException(e);
        }
        BitVector.wordsField.setAccessible(true);
    }

    /**
     * Creates a new <code>BitVector</code> with a specific size.
     *
     * @param size the size of the bit vector.
     */
    public BitVector(final int size) {
        super(size);
        try {
            this.words = (long[]) this.wordsField.get(this);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Creates a new <code>BitVector</code>.
     */
    public BitVector() {
        super();
        try {
            this.words = (long[]) this.wordsField.get(this);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Creates a new <code>BitVector</code> from a specified <code>BitExp</code>.
     *
     * @param exp the <code>BitExp</code> that represents <code>BitVector</code>.
     */
    public BitVector(final Condition exp) {
        this();
        this.or(exp.getPositiveFluents());
        this.andNot(exp.getNegativeFluents());
    }

    /**
     * Creates a new <code>BitVector</code> from an other state. This constructor is the copy
     * constructor.
     *
     * @param vector the other <code>BitVector</code> to copy
     */
    public BitVector(final BitVector vector) {
        this();
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
        final BitVector copy = new BitVector(this);
        copy.or(vector);
        return copy.equals(this);
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

    /**
     * Shifts right the bit vector of n bits.
     *
     * @param n the number of bit to shift. n must greater or equal 0.
     */
    public final void shiftRight(int n) {
        final int shift = n / 63;
        for (int i = 0; i < shift; i++) {
            this.primitiveShiftRight(63);
        }
        this.primitiveShiftRight(n % 63);
    }

    /**
     * Shifts right the bit vector of n bits.
     *
     * @param n the number of bit to shift. n must greater or equal 0 and less than 64.
     */
    private void primitiveShiftRight(int n) {
        if (this.words.length > 0) {
            this.ensureCapacity(n);
            // Do the shift
            for (int i = this.words.length - 1; i > 0; i--) {
                this.words[i] <<= n; // Shift current word
                this.words[i] |= this.words[i - 1] >>> (64 - n); // Do the carry
            }
            this.words[0] <<= n; // shift [0] separately, since no carry
        }
    }

    /**
     * Shifts left the bit vector of n bits.
     *
     * @param n the number of bit to shift. n must greater of equal to 0.
     */
    public final void shiftLeft(int n) {
        final int shift = n / 63;
        for (int i = 0; i < shift; i++) {
            this.primitiveShiftLeft(63);
        }
        this.primitiveShiftLeft(n % 63);
    }

    /**
     * Shifts left the bit vector of n bits.
     *
     * @param n the number of bit to shift. n must greater or equal 0 and less than 64.
     */
    private final void primitiveShiftLeft(int n) {
        if (this.words.length > 0) {
            this.ensureCapacity(n);
            // Do the shift
            for (int i = 0; i < this.words.length - 1; i++) {
                this.words[i] >>>= n; // Shift current word
                this.words[i] |= this.words[i + 1] << (64 - n); // Do the carry
            }
            this.words[this.words.length - 1] >>>= n; // shift [words.length-1] separately, since no carry
        }
    }

    /**
     * Updates the capacity of the bit vector of n bits.
     *
     * @param n the number of bits to increase.
     */
    private void ensureCapacity(final int n) {
        if (this.words[words.length - 1] >>> n > 0) {
            final long[] tmp = new long[this.words.length + 3];
            System.arraycopy(this.words, 0, tmp, 0, this.words.length);
            this.words = tmp;
            try {
                this.wordsField.set(this, tmp);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
