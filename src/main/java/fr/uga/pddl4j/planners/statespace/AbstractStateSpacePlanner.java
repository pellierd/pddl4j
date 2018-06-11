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
import fr.uga.pddl4j.planners.AbstractPlanner;

import java.util.Objects;

/**
 * This abstract class defines the main methods to access a state based planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public abstract class AbstractStateSpacePlanner extends AbstractPlanner implements StateSpacePlanner {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The heuristic of the planner.
     */
    private Heuristic.Type heuristic;

    /**
     * The heuristic weight.
     */
    private double weight;

    /**
     * The anytime state of the planner.
     */
    private boolean anytime;

    /**
     * Creates a new planner.
     */
    public AbstractStateSpacePlanner() {
        super();
        this.heuristic = StateSpacePlanner.DEFAULT_HEURISTIC;
        this.weight = StateSpacePlanner.DEFAULT_WEIGHT;
        this.anytime = StateSpacePlanner.DEFAULT_ANYTIME;
    }

    /**
     * Returns the heuristicType to use to solve the planning problem.
     *
     * @return the heuristicType to use to solve the planning problem.
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
     * Set the anytime state value.
     *
     * @param anytimeState the anytime state value
     */
    @Override
    public void setAnytimeState(boolean anytimeState) {
        this.anytime = anytimeState;
    }

    /**
     * Is planner anytime or not.
     *
     * @return true if planner is anytime, false otherwise
     */
    @Override
    public boolean isAnytime() {
        return anytime;
    }

    /**
     * Setup the planner.
     *
     * @param heuristic      the heuristicType to use to solve the planning problem.
     * @param timeout        the time out of the planner.
     * @param weight         the weight set to the heuristic.
     * @param statisticState the statistics generation value.
     * @param traceLevel     the trace level of the planner.
     */
    public void init(Heuristic.Type heuristic, int timeout,
                     double weight, boolean statisticState, int traceLevel) {
        this.setHeuristicType(heuristic);
        this.setTimeOut(timeout);
        this.setWeight(weight);
        this.setSaveState(statisticState);
        this.setTraceLevel(traceLevel);
    }
}
