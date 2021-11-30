/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.  If not, see
 * <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.planners;

import java.io.Serializable;

/**
 * This interface is used to define all the common methods of the search strategies.
 *
 * @author D. Pellier
 * @version 1.0 - 18.06.2020
 * @since 4.0
 */
public interface SearchStrategy extends Serializable {

    /**
     * The name of the search strategy.
     *
     */
    enum Name {
        /**
         * The A* search strategy.
         */
        ASTAR,
        /**
         * The enforced hill climbing search strategy.
         */
        ENFORCED_HILL_CLIMBING,
        /**
         * The breadth first search strategy.
         */
        BREADTH_FIRST,
        /**
         * The greedy first search strategy.
         */
        GREEDY_BEST_FIRST,
        /**
         * The depth first search strategy.
         */
        DEPTH_FIRST,
        /**
         * The hill climbing first search strategy.
         */
        HILL_CLIMBING,
    }

}
