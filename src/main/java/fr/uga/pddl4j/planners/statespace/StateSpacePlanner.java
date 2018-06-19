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

import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.statespace.search.strategy.StateSpaceStrategy;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Properties;

/**
 * This interface defines the main methods to access a state space planner.
 *
 * @author E. Hermellin
 * @version 1.0 - 07.06.2016
 * @since 3.6
 */
public interface StateSpacePlanner extends Planner {

    /**
     * The default planner.
     */
    Name DEFAULT_STATE_SPACE_PLANNER = Name.HSP;

    /**
     * The heuristic key for properties.
     */
    String HEURISTIC = "HEURISTIC";

    /**
     * The default heuristicType.
     */
    Heuristic.Type DEFAULT_HEURISTIC = Heuristic.Type.FAST_FORWARD;

    /**
     * The weight key for properties.
     */
    String WEIGHT = "WEIGHT";

    /**
     * The default weight of the heuristic.
     */
    double DEFAULT_WEIGHT = 1.0;

    /**
     * The default anytime value.
     */
    boolean DEFAULT_ANYTIME = false;

    /**
     * Returns the LOGGER of the Planner class.
     *
     * @return the Planner class
     */
    static Logger getLogger() {
        return Planner.getLogger();
    }

    /**
     * Returns the state space strategies used in the planner.
     *
     * @return the state space strategies used in the planner
     */
    List<StateSpaceStrategy> getStateSpaceStrategies();

    /**
     * Is planner anytime or not.
     *
     * @return true if planner is anytime, false otherwise
     */
    boolean isAnytime();

    /**
     * Set the anytime state value.
     *
     * @param anytimeState the anytime state value
     */
    void setAnytime(final boolean anytimeState);

    /**
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner
     */
    static Properties getDefaultArguments() {
        final Properties options = Planner.getDefaultArguments();
        options.put(StateSpacePlanner.PLANNER, StateSpacePlanner.DEFAULT_STATE_SPACE_PLANNER);
        options.put(StateSpacePlanner.HEURISTIC, StateSpacePlanner.DEFAULT_HEURISTIC);
        options.put(StateSpacePlanner.WEIGHT, StateSpacePlanner.DEFAULT_WEIGHT);
        return options;
    }
}
