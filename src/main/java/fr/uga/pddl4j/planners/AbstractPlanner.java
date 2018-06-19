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

import org.apache.logging.log4j.Logger;

/**
 * This abstract class defines the main methods to access a planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public abstract class AbstractPlanner implements Planner {

    /**
     * The trace level.
     */
    private int traceLevel;

    /**
     * The statistics of the planner.
     */
    private Statistics statistics;

    /**
     * The state to save the statistics of the planner.
     */
    private boolean saveState;

    /**
     * Creates a new planner.
     */
    public AbstractPlanner() {
        super();
        this.traceLevel = Planner.DEFAULT_TRACE_LEVEL;
        this.saveState = Planner.DEFAULT_STATISTICS;
        this.statistics = new Statistics();
    }

    /**
     * Creates a new planner.
     *
     * @param statisticState the statistics generation value.
     * @param traceLevel     the trace level of the planner.
     */
    public AbstractPlanner(final boolean statisticState, final int traceLevel) {
        super();
        this.traceLevel = traceLevel;
        this.saveState = statisticState;
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
     * Set the statistics generation value.
     *
     * @param saveState the new statistics computation value
     */
    @Override
    public void setSaveState(boolean saveState) {
        this.saveState = saveState;
    }

    /**
     * Is statistics generate or not.
     *
     * @return true if statistics are compute and save, false otherwise
     */
    @Override
    public boolean isSaveState() {
        return saveState;
    }

    /**
     * Returns the LOGGER of the Planner class.
     *
     * @return the Planner class.
     */
    public Logger getLogger() {
        return Planner.getLogger();
    }
}
