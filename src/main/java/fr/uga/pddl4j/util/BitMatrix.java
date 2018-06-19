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
import java.util.Arrays;
import java.util.BitSet;

/**
 * This class implements a bit matrix.
 *
 * @author D. Pellier
 * @version 1.0 - 30.08.2010
 */
public final class BitMatrix implements Serializable {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The number of rows.
     */
    private int rows;

    /**
     * The number of columns.
     */
    private int columns;

    /**
     * The array of bit set used to to store the matrix.
     */
    private BitSet[] bitsets;

    /**
     * Creates a new bit matrix with a specified number of rows and columns.
     *
     * @param rows    The number of rows of the matrix.
     * @param columns The number of column of the matrix.
     */
    public BitMatrix(final int rows, final int columns) {
        this.rows = rows;
        this.columns = columns;
        this.bitsets = new BitSet[this.rows];
        for (int i = 0; i < this.rows; i++) {
            this.bitsets[i] = new BitSet(this.columns);
        }
    }

    /**
     * Creates a new squared matrix of a specific size.
     *
     * @param size the size of the squared matrix.
     */
    public BitMatrix(final int size) {
        this(size, size);
    }

    /**
     * Sets the bit at a specified row and column position to true.
     *
     * @param row the row position.
     * @param col the column position.
     */
    public void set(final int row, final int col) {
        this.bitsets[row].set(col);
    }

    /**
     * Sets the bit at a specified row and column position to false.
     *
     * @param row the row position.
     * @param col the column position.
     */
    public void clear(final int row, final int col) {
        this.bitsets[row].clear(col);
    }

    /**
     * Returns the ith row of the matrix.
     *
     * @param row the index of the row.
     * @return the ith row of the matrix.
     */
    public BitSet getRow(final int row) {
        return this.bitsets[row];
    }

    /**
     * Returns the jth column of the matrix.
     *
     * @param col the index of the column.
     * @return the jth column of the matrix.
     */
    public BitSet getColumn(final int col) {
        final BitSet column = new BitSet(this.rows);
        for (int i = 0; i < this.rows; i++) {
            column.set(i, this.bitsets[i].get(col));
        }
        return column;
    }

    /**
     * Returns the value of the bit at a specific position in the matrix.
     *
     * @param row The row of the bit.
     * @param col The column of the bit.
     * @return the value of the bit at a specific position in the matrix.
     */
    public boolean get(final int row, final int col) {
        return this.bitsets[row].get(col);
    }

    /**
     * Returns the cardinality of the matrix, i.e., the number of bits set to 1
     * in the matrix.
     *
     * @return Returns the cardinality of the matrix.
     */
    public int cardinality() {
        int cardinality = 0;
        for (int i = 0; i < this.rows; i++) {
            cardinality += this.bitsets[i].cardinality();
        }
        return cardinality;
    }

    /**
     * Returns the number of columns of the matrix.
     *
     * @return the number of columns of the matrix.
     */
    public int columns() {
        return this.columns;
    }

    /**
     * Returns the number of rows of the matrix.
     *
     * @return the number of rows of the matrix.
     */
    public int rows() {
        return this.rows;
    }

    /**
     * Returns <code>true</code> if this matrix is equals to an other object.
     *
     * @param obj the object to compared.
     * @return <code>true</code> if this matrix is equals to an other object;
     * <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj.getClass().equals(this.getClass())) {
            final BitMatrix other = (BitMatrix) obj;
            return Arrays.equals(this.bitsets, other.bitsets);
        }
        return false;
    }

    /**
     * Returns the hash code value of this matrix.
     *
     * @return the hash code value of this matrix.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.bitsets);
    }

    /**
     * Returns a string representation of the matrix.
     *
     * @return a string representation of the matrix.
     */
    @Override
    public String toString() {
        return Arrays.toString(this.bitsets);
    }
}
