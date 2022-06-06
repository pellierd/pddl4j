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

import fr.uga.pddl4j.heuristics.state.StateHeuristic;
import fr.uga.pddl4j.planners.Planner;

import fr.uga.pddl4j.planners.SearchStrategy;
import fr.uga.pddl4j.problem.Problem;

import java.util.Arrays;
import java.util.List;

/**
 * This interface defines the main methods to access a state space planner.
 *
 * @author E. Hermellin
 * @version 1.0 - 07.06.2016
 * @since 3.6
 */
public interface StateSpacePlanner extends Planner {

    /**
     * The search strategies setting used for planner configuration.
     */
    static final String SEARCH_STRATEGIES_SETTING = "SEARCH_STRATEGIES";

    /**
     * The default value of the SEARCH_STRATEGIES setting used for planner configuration.
     */
    static final List<SearchStrategy.Name> DEFAULT_SEARCH_STRATEGIES = Arrays.asList(SearchStrategy.Name.ASTAR);

    /**
     * The HEURISTIC property used for planner configuration.
     */
    static final String HEURISTIC_SETTING = "HEURISTIC";

    /**
     * The default value of the HEURISTIC property used for planner configuration.
     */
    static final StateHeuristic.Name DEFAULT_HEURISTIC = StateHeuristic.Name.FAST_FORWARD;

    /**
     * The WEIGHT_HEURISTIC property used for planner configuration.
     */
    static final String WEIGHT_HEURISTIC_SETTING = "WEIGHT_HEURISTIC";

    /**
     * The default value of the WEIGHT_HEURISTIC property used for planner configuration.
     */
    static final double DEFAULT_WEIGHT_HEURISTIC = 1.0;

}
