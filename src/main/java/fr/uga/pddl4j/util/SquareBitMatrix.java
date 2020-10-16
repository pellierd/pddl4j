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

package fr.uga.pddl4j.util;

/**
 * This class implements a square bit matrix.
 * <p>
 * This class introspection mechanism not more allowed with jre version superior to 1.8.
 * </p>
 *
 * @author D. Pellier
 * @version 1.0 - 09.09.2020
 */
public class SquareBitMatrix extends BitMatrix {

    /**
     * Creates a deep copy from an other Square Bit Matrix.
     *
     * @param other The other matrix.
     */
    public SquareBitMatrix(final SquareBitMatrix other) {
        super(other);
    }

    /**
     * Creates a new squared matrix of a specific size.
     *
     * @param size the size of the squared matrix.
     */
    public SquareBitMatrix(final int size) {
        super(size, size);
    }

    /**
     * Compute the transitive closure of the ordering constraints. The computation of the transitive closure is based
     * on Warshall algorithm. The complexity is O(n^3) where n is the number of tasks of the task network.
     */
    public final void transitiveClosure() {
        for (int k = 0; k < this.rows(); k++) {
            for (int i = 0; i < this.rows(); i++) {
                if (this.get(i, k)) {
                    for (int j = 0; j < this.rows(); j++) {
                        if (this.get(k, j)) {
                            this.set(i, j);
                        }
                    }
                }
            }
        }
    }
}
