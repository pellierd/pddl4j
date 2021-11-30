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

package fr.uga.pddl4j.planners.htn;

import fr.uga.pddl4j.planners.AbstractPlanner;

import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.problem.Problem;

/**
 * This abstract class defines the commun methods of all HTN planners.
 *
 * @author D. Pellier
 * @version 1.0 - 24.11.2021
 * @since 4,0
 */

public abstract class AbstractHTNPlanner<T extends Problem> extends AbstractPlanner<T>  implements HTNPlanner<T> {

    /**
     * Creates a new planner with a default configuration.
     */
    public AbstractHTNPlanner() {
        this(Planner.getDefaultConfiguration());
    }

    /**
     * Creates a new planner with a specific configuration.
     *
     * @param configuration the configuration of the planner.
     */
    public AbstractHTNPlanner(final PlannerConfiguration configuration) {
        super(configuration);
    }
}
