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

/**
 * This class implements a numeric comparator used in numeric constraints.
 *
 * @author D. Pellier
 * @version 1.0 - 09.06.2022
 * @since 4.0
 */
public enum NumericComparator {

    /**
     * The comparator equal.
     */
    EQUAL("="),
    /**
     * The comparator less.
     */
    LESS("<"),
    /**
     * The comparator less or equal.
     */
    LESS_OR_EQUAL("<="),
    /**
     * The comparator greater.
     */
    GREATER(">"),
    /**
     * The comparator greater or equal.
     */
    GREATER_OR_EQUAL(">=");

    /**
     * The image associate to the numeric comparator.
     */
    private String image;

    /**
     * Create a new numeric comparator with a specific image.
     *
     * @param image the image of the numeric comparator. The image of the numeric comparator must be not null.
     */
    NumericComparator(String image) {
        this.image = image;
    }

    /**
     * Returns the image of this numeric comparator.
     *
     * @return the image of this numeric comparator.
     */
    public String getImage() {
        return this.image;
    }

}
