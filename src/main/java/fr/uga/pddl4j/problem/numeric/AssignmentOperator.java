/*
 * Copyright (c) 2022 by Damien Pellier <Damien.Pellier@imag.fr>.
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
 * The assignment operator are used in numeric assignment in action effects.
 *
 * @author D. Pellier
 * @version 1.0 - 09.06.2022
 * @since 4.0
 */
public enum AssignmentOperator {
    /**
     * The operator assign.
     */
    ASSIGN("assign"),
    /**
     * The operator increase.
     */
    INCREASE("increase"),
    /**
     * The operator decrease.
     */
    DECREASE("decrease"),
    /**
     * The operator scale-up.
     */
    SCALE_UP("scale-up"),
    /**
     * The operator scale-down.
     */
    SCALE_DOWN("scale-down");

    /**
     * The image associate to the assignment operator.
     */
    private String image;

    /**
     * Create a new assignment operator with a specific image.
     *
     * @param image the image of the assignment operator. The image of the assignment operator must be not null.
     */
    AssignmentOperator(String image) {
        this.image = image;
    }

    /**
     * Returns the image of this assignment operator.
     *
     * @return the image of this assignment operator.
     */
    public String getImage() {
        return this.image;
    }
}
