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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Properties;

/**
 * This interface defines the main methods of to access a planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public interface Planner extends Serializable {

    /**
     * The logger of the class.
     */
    Logger LOGGER = LogManager.getLogger(Planner.class);

    /**
     * The planner key for properties.
     */
    String PLANNER = "PLANNER";

    /**
     * The default planner.
     */
    Name DEFAULT_PLANNER = Name.HSP;

    /**
     * The domain key for properties.
     */
    String DOMAIN = "DOMAIN";

    /**
     * The problem key for properties.
     */
    String PROBLEM = "PROBLEM";

    /**
     * The timeout key for properties.
     */
    String TIMEOUT = "TIMEOUT";

    /**
     * The default CPU time allocated to the search in seconds.
     */
    int DEFAULT_TIMEOUT = 600;

    /**
     * The trace level key for properties.
     */
    String TRACE_LEVEL = "TRACE_LEVEL";

    /**
     * The default trace level.
     */
    int DEFAULT_TRACE_LEVEL = 1;

    /**
     * The statistics key for properties.
     */
    String STATISTICS = "STATISTICS";

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
        /**
         * The FF Anytime (Fast Forward Anytime Planner).
         */
        FFAnytime,
        /**
         * The HC Anytime (Hill Climbing Anytime Planner).
         */
        HCAnytime
    }

    /**
     * Returns the LOGGER of the Planner class.
     *
     * @return the Planner class.
     */
    static Logger getLogger() {
        return LOGGER;
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

    /**
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     */
    static Properties getDefaultArguments() {
        final Properties options = new Properties();
        options.put(Planner.TIMEOUT, Planner.DEFAULT_TIMEOUT * 1000);
        options.put(Planner.TRACE_LEVEL, Planner.DEFAULT_TRACE_LEVEL);
        options.put(Planner.STATISTICS, Planner.DEFAULT_STATISTICS);
        return options;
    }
}
