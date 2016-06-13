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
     * The parser of the planner.
     */
    //private Parser parser; useless ?

    /**
     * Creates a new planner.
     */
    public AbstractPlanner() {
        super();
        //this.parser = new Parser();
        this.timeout = Planner.DEFAULT_TIMEOUT;
        this.traceLevel = Planner.DEFAULT_TRACE_LEVEL;
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

}
