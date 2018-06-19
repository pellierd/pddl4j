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

package fr.uga.pddl4j.encoding;

import java.io.Serializable;

/**
 * This class implements a matrix at n-dimension. This class is used to store the predicates tables.
 *
 * @author D. Pellier
 * @version 1.0 - 07.04.2010
 */
final class IntMatrix implements Serializable {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The integer array used to store the matrix.
     */
    private int[] matrix;

    /**
     * The dimension of the matrix.
     */
    private int dimension;

    /**
     * The size of the matrix.
     */
    private int size;

    /**
     * Create a new n-dimensional matrix with a specified size and dimension.
     *
     * @param size      the size of the matrix.
     * @param dimension the dimension of the matrix.
     * @throws IllegalArgumentException if size <= 0.
     */
    public IntMatrix(final int size, final int dimension) {
        if (size < 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.matrix = new int[(int) Math.pow(size, dimension)];
        this.dimension = dimension;
        this.size = size;
    }

    /**
     * Get the integer at the specified index.
     *
     * @param index the index.
     * @return the integer contained in the matrix at the specified index or null if no element is
     *          at the specified index.
     * @throws ArrayIndexOutOfBoundsException if index.length != dimension and for all i 0 <=
     *                                        index[i] < size does not hold.
     */
    public final int get(final int[] index) {
        return this.matrix[index(index)];
    }

    /**
     * Put a new value at a specified index.
     *
     * @param index the index.
     * @param value the integer value to put.
     * @throws ArrayIndexOutOfBoundsException if index.length != dimension and for all i 0 <=
     *                                        index[i] < size does not hold.
     */
    public final void put(final int[] index, final int value) {
        this.matrix[index(index)] = value;
    }

    /**
     * Increment the value at a specified index.
     *
     * @param index the index.
     * @throws ArrayIndexOutOfBoundsException if index.length != dimension and for all i 0 <=
     *                                        index[i] < size does not hold.
     */
    public final void increment(final int[] index) {
        this.matrix[index(index)]++;
    }

    /**
     * Set all the value of the matrix to 0.
     */
    public final void zero() {
        for (int i = this.matrix.length - 1; i >= 0; i--) {
            this.matrix[i] = 0;
        }
    }

    /**
     * Return the dimension of the matrix.
     *
     * @return the dimension of the matrix.
     */
    public int getDimension() {
        return this.dimension;
    }

    /**
     * Return the size of the matrix.
     *
     * @return size the size of the matrix.
     */
    public final int getSize() {
        return this.size;
    }

    /**
     * Return from the a specified index the index in the internal representation.
     *
     * @param index the index to convert.
     * @return the index in the internal representation.
     * @throws ArrayIndexOutOfBoundsException if index.length != dimension and for all i 0 <=
     *                                        index[i] < size does not hold.
     */
    private final int index(final int[] index) {
        if (index.length != this.dimension) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < dimension; i++) {
            if ((index[i] < 0) || (index[i] > size)) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
        // conversion E(i * t^r)
        int acces = 0;
        for (int i = index.length; i > 0; i--) {
            acces += index[i - 1] * (int) Math.pow(size, (double) dimension - i);
        }
        return acces;
    }
}
