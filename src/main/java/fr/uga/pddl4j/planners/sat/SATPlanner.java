/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.planners.sat;

import fr.uga.pddl4j.planners.Planner;

import java.io.Serializable;

/**
 * Implements a planner using a SAT encoding and a SAT solver.
 */
public interface SATPlanner extends Planner, Serializable {
    /**
     * The configuration property used to specify the SAT encoding.
     */
    String SAT_ENCODING_SETTING = "SAT_ENCODING";

    /**
     * The name of the default SAT encoding.
     */
    String DEFAULT_SAT_ENCODING_NAME = "DEFAULT";

    /**
     * The configuration property used to specify the SAT solver.
     */
    String SAT_SOLVER_SETTING = "SAT_SOLVER";

    /**
     * The name of the default SAT solver.
     */
    String DEFAULT_SAT_SOLVER_NAME = "MERGESAT";

    /**
     * The configuration property used to specify the maximum length of a plan (that is, its number of actions).
     */
    String  MAX_PLAN_LENGTH_SETTING = "MAX_PLAN_LENGTH";

    /**
     * The default maximum plan length.
     */
    int DEFAULT_MAX_PLAN_LENGTH = 1000;
}
