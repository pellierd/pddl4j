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

package fr.uga.pddl4j.planners;

import org.apache.logging.log4j.Level;

/**
 * This enumeration is used to define all settings to build a planner.
 *
 * @author D. Pellier
 * @version 1.0 - 18.06.2020
 * @since 4.0
 */
public enum Setting {

    /**
     * The planner setting to create.
     */
    PLANNER,
    /**
     * The domain setting, i.e., the path to the domain file.
     */
    DOMAIN,
    /**
     * The problem setting, i.e., the path to the domain file.
     */
    PROBLEM,
    /**
     * The timeout setting, i.e., the time in seconds allocated to the solve a problem.
     */
    TIMEOUT,
    /**
     * The heuristic setting, i.e., the heuristic to use to solve a problem.
     */
    HEURISTIC,
    /**
     * The heuristic weight setting, i.e., the weight of heuristic to use to solve a problem.
     */
    HEURISTIC_WEIGHT,
    /**
     * The search strategy setting, i.e., the search strategy to use to solve a problem.
     */
    SEARCH_STRATEGY,
    /**
     * The trace level setting, i.e., the trace level used by the planner.
     */
    TRACE_LEVEL;

    /**
     * The default value of the planner setting (NONE).
     */
    public static final Setting.Planner DEFAULT_PLANNER = Setting.Planner.NONE;

    /**
     * the default value of the domain setting (NONE).
     */
    public static final String DEFAULT_DOMAIN = "NONE";

    /**
     * The default value of the problem setting (NONE).
     */
    public static final String DEFAULT_PROBLEM = "NONE";

    /**
     * The default value of the timeout setting in ms.
     */
    public static final int DEFAULT_TIMEOUT = 600 * 1000;

    /**
     * The default value of the heuristic setting (NONE).
     */
    public static final Setting.Heuristic DEFAULT_HEURISTIC = Setting.Heuristic.NONE;

    /**
     * The default value of the heuristic weight setting (1.0).
     */
    public static final double DEFAULT_HEURISTIC_WEIGHT = 1.0;

    /**
     * The default value of the search strategy setting (NONE).
     */
    public static final Setting.SearchStrategy DEFAULT_SEARCH_STRATEGY = Setting.SearchStrategy.NONE;

    /**
     * The default value of the trace level setting (INFO).
     */
    public static final Level DEFAULT_TRACE_LEVEL = Level.INFO;

    /**
     * This enumeration defines all the planners that could be built.
     *
     * @author D. Pellier
     * @version 1.0 - 18.06.2020
     * @since 4.0
     */
    public enum Planner  {
        /**
         * The HSP (Heuristic Search Planner).
         */
        HSP,
        /**
         * The FF (Fast Forward Planner).
         */
        FF,
        /**
         * The TFD (Total Fast Downward) HTN Planner
         */
        TFD,
        /**
         * The PFD (Partial Fast Downward) HTN Planner
         */
        PFD,
        /**
         * Used to indicate that no planner is specified.
         */
        NONE,
    }

    /**
     * This enumeration defines all the search strategies available.
     *
     * @author D. Pellier
     * @version 1.0 - 18.06.2020
     * @since 4.0
     */
    public enum SearchStrategy {
        /**
         * The A* search strategy.
         */
        ASTAR,
        /**
         * The Enforce Hill Climbing search strategy.
         */
        ENFORCE_HILL_CLIMBING,
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
        /**
         * Used to indicate that no search strategy is specified.
         */
        NONE,
    }

    /**
     * This enumeration defines all the heuristics available.
     *
     * @author D. Pellier
     * @version 1.0 - 18.06.2020
     * @since 4.0
     */
    public enum Heuristic {
        /**
         * The type for the <code>AdjustedSum</code> heuristic.
         */
        AJUSTED_SUM,
        /**
         * The type for the <code>AdjustedSum2</code> heuristic.
         */
        AJUSTED_SUM2,
        /**
         * The type for the <code>AdjustedSum2M</code> heuristic.
         */
        AJUSTED_SUM2M,
        /**
         * The type for the <code>Combo</code> heuristic.
         */
        COMBO,
        /**
         * The type for the <code>Max</code> heuristic.
         */
        MAX,
        /**
         * The type for the <code>FF</code> heuristic.
         */
        FAST_FORWARD,
        /**
         * The type for the <code>SetLevel</code> heuristic.
         */
        SET_LEVEL,
        /**
         * The type for the <code>Sum</code> heuristic.
         */
        SUM,
        /**
         * The type for the <code>SumMutex</code> heuristic.
         */
        SUM_MUTEX,
        /**
         * Used to indicate that no heuristic is specified.
         */
        NONE,
    }
}
