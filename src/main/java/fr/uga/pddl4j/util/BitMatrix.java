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
import java.util.*;

/**
 * This class implements a bit matrix.
 *
 * <p>
 * Revisions:
 * <ul>
 *     <li>31.03.2020: Add a deep copy constructor.</li>
 * </ul>
 * </p>
 *
 * @author D. Pellier
 * @version 1.0 - 30.08.2010
 */
public final class BitMatrix implements Serializable {

    /**
     * The number of rows.
     */
    public int rows;

    /**
     * The number of columns.
     */
    public int columns;

    /**
     * The array of bit set used to to store the matrix.
     */
    private List<BitVector> bitsets;

    /**
     * Creates a new bit matrix with a specified number of rows and columns.
     *
     * @param rows    The number of rows of the matrix.
     * @param columns The number of column of the matrix.
     */
    public BitMatrix(final int rows, final int columns) {
        this.rows = rows;
        this.columns = columns;
        this.bitsets = new ArrayList<BitVector>(this.rows);
        for (int i = 0; i < this.rows; i++) {
            this.bitsets.add(new BitVector(this.columns));
        }
    }

    /**
     * Creates a deep copy from an other matrix.
     *
     * @param other    The other matrix.
     */
    public BitMatrix(final BitMatrix other) {
        this.rows = other.rows();
        this.columns = other.columns();
        this.bitsets = new ArrayList<BitVector>(this.rows);
        for (int i = 0; i < this.rows; i++) {
            BitVector row = new BitVector();
            row.or(other.getRow(i));
            this.bitsets.add(row);
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
    public final void set(final int row, final int col) {
        this.bitsets.get(row).set(col);
    }

    /**
     * Sets the bit at a specified row and column position to a specified value.
     *
     * @param row the row position.
     * @param col the column position.
     * @param value the value to set.
     */
    public final void set(final int row, final int col, final boolean value) {
        this.bitsets.get(row).set(col, value);
    }

    /**
     * Sets the bit at a specified row and column position to false.
     *
     * @param row the row position.
     * @param col the column position.
     */
    public final void clear(final int row, final int col) {
        this.bitsets.get(row).clear(col);
    }

    /**
     * Returns the ith row of the matrix.
     *
     * @param row the index of the row.
     * @return the ith row of the matrix.
     */
    public final BitVector getRow(final int row) {
        return this.bitsets.get(row);
    }

    /**
     * Remove the jth row of the matrix.
     *
     * @param row the index of the row to remove.
     */
    public final void removeRow(final int row) {
        this.bitsets.remove(row);
        this.rows--;
    }

    /**
     *
     */
    public void addRow(BitVector row) {
        this.bitsets.add(row);
    }

    /**
     *
     */
    public void addRow(final int index, final BitVector row) {
        this.bitsets.add(index, row);
    }


    /**
     * Returns the jth column of the matrix.
     *
     * @param col the index of the column.
     * @return the jth column of the matrix.
     */
    public final BitVector getColumn(final int col) {
        final BitVector column = new BitVector(this.rows);
        for (int i = 0; i < this.rows; i++) {
            column.set(i, this.bitsets.get(i).get(col));
        }
        return column;
    }

    /**
     * Remove a column of the matrix.
     *
     * @param column the index of the column to remove.
     */
    public final void removeColumn(final int column) {
        for (int i = 0; i < this.rows; i++) {
            final BitVector row = this.getRow(i);
            final BitVector rest = new BitVector(row);
            rest.clear(0, column);
            rest.shiftLeft(1);
            row.clear(column, this.columns);
            row.or(rest);
        }
        this.columns--;
    }

    /**
     * Returns the value of the bit at a specific position in the matrix.
     *
     * @param row The row of the bit.
     * @param col The column of the bit.
     * @return the value of the bit at a specific position in the matrix.
     */
    public final boolean get(final int row, final int col) {
        return this.bitsets.get(row).get(col);
    }

    /**
     * Returns the cardinality of the matrix, i.e., the number of bits set to 1
     * in the matrix.
     *
     * @return Returns the cardinality of the matrix.
     */
    public final int cardinality() {
        int cardinality = 0;
        for (int i = 0; i < this.rows; i++) {
            cardinality += this.bitsets.get(i).cardinality();
        }
        return cardinality;
    }

    /**
     * Returns the number of columns of the matrix.
     *
     * @return the number of columns of the matrix.
     */
    public final int columns() {
        return this.columns;
    }

    /**
     * Returns the number of rows of the matrix.
     *
     * @return the number of rows of the matrix.
     */
    public final int rows() {
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
            return this.bitsets.equals(other.bitsets);
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
        return this.bitsets.hashCode();
    }

    /**
     * Returns a string representation of the matrix.
     *
     * @return a string representation of the matrix.
     */
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < this.rows; i++) {
            str.append(i);
            str.append(" ");
            str.append(this.getRow(i).toString());
            str.append("\n");
        }
        return str.toString();
    }

    public String toBitString() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < this.rows; i++) {
            str.append(i + ": ");
            for (int j = 0; j < this.columns; j++) {
                if (this.get(i, j)) {
                    str.append("1 ");
                } else {
                    str.append("0 ");
                }
            }
            str.append("\n");
        }
        return str.toString();
    }
}
