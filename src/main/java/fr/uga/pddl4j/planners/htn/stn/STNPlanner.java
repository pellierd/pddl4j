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

package fr.uga.pddl4j.planners.htn.stn;

import fr.uga.pddl4j.planners.htn.HTNPlanner;
import fr.uga.pddl4j.problem.Problem;

/**
 * This interface defines the main methods to access the STN planners.
 *
 * @author D. Pellier
 * @version 1.0 - 24,11,2021
 * @since 4,0
 */
public interface STNPlanner<T extends Problem> extends HTNPlanner<T> {

    /**
     * The INTERACTIVE_MODE setting for the configuration of the planner.
     */
    public static final String INTERACTIVE_MODE_SETTING = "INTERACTIVE_MODE";

    /**
     * The Default value for th INTERACTIVE_MODE of the planner.
     */
    public static final boolean DEFAULT_INTERACTIVE_MODE = false;

}
