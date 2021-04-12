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
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a bit matrix. This class introspection mechanism not more allowed with jre version superior
 * to 1.8.
 * <br>
 * Revisions:
 * <ul>
 * <li>31.03.2020: Add a deep copy constructor.</li>
 * <li>26.06.2020: Change for bit vector intern representation.</li>
 * </ul>
 *
 * @author D. Pellier
 * @version 1.0 - 09.09.2020
 */
public class BitMatrix implements Serializable {

    /**
     * The number of columns.
     */
    public int columns;

    /**
     * The array of bit set used to to store the matrix.
     */
    private List<BitVector> matrix;

    /**
     * Creates a new bit matrix with a specified number of rows and columns.
     *
     * @param rows    The number of rows of the matrix.
     * @param columns The number of column of the matrix.
     */
    public BitMatrix(final int rows, final int columns) {
        this.columns = columns;
        this.matrix = new ArrayList<BitVector>(rows);
        for (int i = 0; i < rows; i++) {
            this.matrix.add(new BitVector(this.columns));
        }
    }

    /**
     * Creates a deep copy from an other matrix.
     *
     * @param other The other matrix.
     */
    public BitMatrix(final BitMatrix other) {
        this.columns = other.columns();
        this.matrix = new ArrayList<BitVector>(other.rows());
        for (int i = 0; i < other.rows(); i++) {
            this.matrix.add(new BitVector((other.getRow(i))));
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
        this.matrix.get(row).set(col);
    }

    /**
     * Sets the bit at a specified row and column position to a specified value.
     *
     * @param row   the row position.
     * @param col   the column position.
     * @param value the value to set.
     */
    public final void set(final int row, final int col, final boolean value) {
        this.matrix.get(row).set(col, value);
    }

    /**
     * Sets the bit at a specified row and column position to false.
     *
     * @param row the row position.
     * @param col the column position.
     */
    public final void clear(final int row, final int col) {
        this.matrix.get(row).clear(col);
    }

    /**
     * Returns the ith row of the matrix.
     *
     * @param row the index of the row.
     * @return the ith row of the matrix.
     */
    public final BitVector getRow(final int row) {
        return this.matrix.get(row);
    }

    /**
     * Remove the jth row of the matrix.
     *
     * @param row the index of the row to remove.
     */
    public final void removeRow(final int row) {
        this.matrix.remove(row);
    }

    /**
     * Adds a row at the end of the matrix.
     *
     * @param row the row to add.
     */
    public final void addRow(BitVector row) {
        this.matrix.add(row);
    }

    /**
     * Adds a row at a specified index in the matrix.
     *
     * @param index the index where the row must be added.
     * @param row   the row to add.
     */
    public void addRow(final int index, final BitVector row) {
        this.matrix.add(index, row);
    }

    /**
     * Returns the jth column of the matrix.
     *
     * @param col the index of the column.
     * @return the jth column of the matrix.
     */
    public final BitVector getColumn(final int col) {
        final BitVector column = new BitVector(this.rows());
        for (int i = 0; i < this.rows(); i++) {
            column.set(i, this.matrix.get(i).get(col));
        }
        return column;
    }

    /**
     * Remove a column of the matrix.
     *
     * @param column the index of the column to remove.
     */
    public final void removeColumn(final int column) {
        for (int i = 0; i < this.rows(); i++) {
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
        return this.matrix.get(row).get(col);
    }

    /**
     * Returns the cardinality of the matrix, i.e., the number of bits set to 1
     * in the matrix.
     *
     * @return Returns the cardinality of the matrix.
     */
    public final int cardinality() {
        int cardinality = 0;
        for (int i = 0; i < this.rows(); i++) {
            cardinality += this.matrix.get(i).cardinality();
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
        return this.matrix.size();
    }

    /**
     * Resizes the matrix.
     *
     * @param rows    the new number of rows.
     * @param columns the new number of columns.
     */
    public final void resize(final int rows, final int columns) {
        if (rows < this.rows()) {
            while (rows < this.rows()) {
                this.matrix.remove(this.rows() - 1);
            }
        } else if (rows > this.rows()) {
            while (rows > this.rows()) {
                this.matrix.add(new BitVector());
            }
        }
        if (columns < this.columns) {
            for (BitVector row : this.matrix) {
                row.clear(columns, this.columns);
            }
        }
        this.columns = columns;
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
            return this.matrix.equals(other.matrix);
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
        return this.matrix.hashCode();
    }

    /**
     * Returns a string representation of the matrix based on the bit vector representation.
     *
     * @return a string representation of the matrix.
     * @see BitVector#toString()
     */
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < this.rows(); i++) {
            str.append(i);
            str.append(" ");
            str.append(this.getRow(i).toString());
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * Returns a string representation of the matrix based on bit representation.
     *
     * @return a string representation of the matrix.
     */
    public String toBitString() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < this.rows(); i++) {
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
