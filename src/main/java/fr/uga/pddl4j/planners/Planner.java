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

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.util.Plan;

/**
 * This interface defines the main methods of to access a planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public interface Planner {

    /**
     * The default CPU time allocated to the search in seconds.
     */
    int DEFAULT_TIMEOUT = 600;

    /**
     * The default trace level.
     */
    int DEFAULT_TRACE_LEVEL = 1;

    /**
     * The default statistics value.
     */
    boolean DEFAULT_STATISTICS = true;

    /**
     * This enumeration used to specified the name of the planner implemented in the library.
     */
    enum Name {
        /**
         * The HSP (Heuristic Search Planner).
         */
        HSP,
        /**
         * The FF (Fast Forward Planner).
         */
        FF,
    }

    /**
     * Search a plan for the specified planning problem.
     *
     * @param problem the problem to be solved. The problem cannot be null.
     * @return the solution plan or null is no solution was found.
     */
    Plan search(final CodedProblem problem);

    /**
     * Returns the statistics of the planner.
     *
     * @return the statistics of the planner.
     * @see Statistics
     */
    Statistics getStatistics();

    /**
     * Sets the time out of the planner.
     *
     * @param timeout the time allocated to the search in second.
     */
    void setTimeOut(final int timeout);

    /**
     * Returns the time out of the planner.
     *
     * @return the time out of the planner, i.e., the time allocated to the search in second.
     */
    int getTimeout();

    /**
     * Sets the trace level of the planner.
     *
     * @param level the trace level of the planner.
     */
    void setTraceLevel(final int level);

    /**
     * Returns the trace level of the planner.
     *
     * @return the trace level of the planner.
     */
    int getTraceLevel();

    /**
     * Set the statistics generation value.
     *
     * @param saveState the new statistics computation value
     */
    void setSaveState(boolean saveState);

    /**
     * Is statistics generate or not.
     *
     * @return true if statistics are compute and save, false otherwise
     */
    boolean isSaveState();
}
