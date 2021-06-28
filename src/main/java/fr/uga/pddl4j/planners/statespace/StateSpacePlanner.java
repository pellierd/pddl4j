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

package fr.uga.pddl4j.planners.statespace;

import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.Setting;
import fr.uga.pddl4j.planners.statespace.search.StateSpaceStrategy;

import fr.uga.pddl4j.problem.Problem;
import org.apache.logging.log4j.Level;

import java.util.List;

/**
 * This interface defines the main methods to access a state space planner.
 *
 * @author E. Hermellin
 * @version 1.0 - 07.06.2016
 * @since 3.6
 */
public interface StateSpacePlanner<T extends Problem> extends Planner<T> {

    /**
     * Returns the state space strategies used in the planner.
     *
     * @return the state space strategies used in the planner
     */
    List<StateSpaceStrategy> getStateSpaceStrategies();

    /**
     * This method return the default configuration of the planner. The default configuration is as follow:
     * <ul>
     *     <li>Planner: HSP</li>
     *     <li>Heuristic: Fast Forward</li>
     *     <li>Heuristic weight: 1.0</li>
     *     <li>Trace level: INFO</li>
     * </ul>
     *
     * @return the default configuration of the planner.
     */
    static PlannerConfiguration getDefaultConfiguration() {
        final PlannerConfiguration config = Planner.getDefaultConfiguration();
        config.setPlanner(Setting.Planner.HSP);
        config.setHeuristic(Setting.Heuristic.FAST_FORWARD);
        config.setHeuristicWeight(1.0);
        config.setTraceLevel(Level.INFO);
        return config;
    }
}
