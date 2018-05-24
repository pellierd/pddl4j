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

import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Properties;

/**
 * This abstract class defines the main methods of to access a planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 *
 * @since 3.0
 */
public abstract class AbstractPlanner implements Planner {

    /**
     * The enumeration of the arguments of the planner.
     */
    public enum Argument {
        /**
         * The planner to use.
         */
        PLANNER,
        /**
         * The planning domain.
         */
        DOMAIN,
        /**
         * The planning problem.
         */
        PROBLEM,
        /**
         * The heuristic to use.
         */
        HEURISTIC,
        /**
         * The weight of the heuristic.
         */
        WEIGHT,
        /**
         * The global time slot allocated to the search.
         */
        TIMEOUT,
        /**
         * The trace level.
         */
        TRACE_LEVEL,
        /**
         * Generate statistics or not.
         */
        STATISTICS
    }

    /**
     * The timeout for the search in second.
     */
    private int timeout;

    /**
     * The trace level.
     */
    private int traceLevel;

    /**
     * The statistics of the planner.
     */
    private Statistics statistics;

    /**
     * The heuristic of the planner.
     */
    private Heuristic.Type heuristic;

    /**
     * The heuristic weight.
     */
    private double weight;

    /**
     * The state to save the statistics of the planner.
     */
    private boolean saveState;

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(AbstractPlanner.class);

    /**
     * Creates a new planner.
     */
    public AbstractPlanner() {
        super();
        this.timeout = Planner.DEFAULT_TIMEOUT;
        this.traceLevel = Planner.DEFAULT_TRACE_LEVEL;
        this.heuristic = Planner.DEFAULT_HEURISTIC;
        this.weight = Planner.DEFAULT_WEIGHT;
        this.saveState = Planner.DEFAULT_STATISTICS;
        this.statistics = new Statistics();
    }

    /**
     * Returns the statistics of the planner.
     *
     * @return the statistics of the planner or null if no problem was solved.
     * @see Statistics
     */
    @Override
    public final Statistics getStatistics() {
        return this.statistics;
    }

    /**
     * Sets the time out of the planner.
     *
     * @param timeout the time allocated to the search in second. Timeout mus be positive.
     */
    @Override
    public final void setTimeOut(final int timeout) {
        this.timeout = timeout;
    }

    /**
     * Returns the time out of the planner.
     *
     * @return the time out of the planner, i.e., the time allocated to the search in second.
     */
    @Override
    public int getTimeout() {
        return this.timeout;
    }

    /**
     * Sets the trace level of the planner.
     *
     * @param level the trace level of the planner. Trace level must be positive.
     */
    @Override
    public final void setTraceLevel(final int level) {
        this.traceLevel = level;
    }

    /**
     * Returns the trace level of the planner.
     *
     * @return the trace level of the planner.
     */
    @Override
    public final int getTraceLevel() {
        return this.traceLevel;
    }

    /**
     * Returns the heuristicType to use to solve the planning problem.
     *
     * @return the heuristicType to use to solve the planning problem.
     * @see fr.uga.pddl4j.heuristics.relaxation.Heuristic.Type
     */
    @Override
    public final Heuristic.Type getHeuristicType() {
        return this.heuristic;
    }

    /**
     * Sets the heuristicType to use to solved the problem.
     *
     * @param heuristicType the heuristicType to use to solved the problem. The heuristicType cannot be null.
     */
    @Override
    public final void setHeuristicType(final Heuristic.Type heuristicType) {
        Objects.requireNonNull(heuristicType);
        this.heuristic = heuristicType;
    }

    /**
     * Returns the weight set to the heuristic.
     *
     * @return the weight set to the heuristic.
     */
    @Override
    public final double getWeight() {
        return this.weight;
    }

    /**
     * Sets the wight of the heuristic.
     *
     * @param weight the weight of the heuristic. The weight must be positive.
     */
    @Override
    public final void setWeight(final double weight) {
        this.weight = weight;
    }

    /**
     * Set the statistics generation value.
     * @param saveState the new statistics computation value
     */
    @Override
    public void setSaveState(boolean saveState) {
        this.saveState = saveState;
    }

    /**
     * Is statistics generate or not.
     * @return true if statistics are compute and save, false otherwise
     */
    @Override
    public boolean isSaveState() {
        return saveState;
    }

    /**
     * Returns the LOGGER of the AbstractPlanner class.
     *
     * @return the AbstractPlanner class.
     */
    public static Logger getLogger() {
        return LOGGER;
    }

    /**
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     */
    static Properties getDefaultArguments() {
        final Properties options = new Properties();
        options.put(AbstractPlanner.Argument.PLANNER, Name.HSP);
        options.put(AbstractPlanner.Argument.HEURISTIC, AbstractPlanner.DEFAULT_HEURISTIC);
        options.put(AbstractPlanner.Argument.WEIGHT, AbstractPlanner.DEFAULT_WEIGHT);
        options.put(AbstractPlanner.Argument.TIMEOUT, AbstractPlanner.DEFAULT_TIMEOUT * 1000);
        options.put(AbstractPlanner.Argument.TRACE_LEVEL, AbstractPlanner.DEFAULT_TRACE_LEVEL);
        options.put(AbstractPlanner.Argument.STATISTICS, AbstractPlanner.DEFAULT_STATISTICS);
        return options;
    }

}
