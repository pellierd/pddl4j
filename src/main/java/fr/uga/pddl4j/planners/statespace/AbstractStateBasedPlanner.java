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
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Properties;

/**
 * This abstract class defines the main methods to access a state based planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public abstract class AbstractStateBasedPlanner extends AbstractPlanner {

    /**
     * The enumeration of the arguments of the planner.
     */
    public enum StateBasedArgument {
        /**
         * The heuristic to use.
         */
        HEURISTIC,
        /**
         * The weight of the heuristic.
         */
        WEIGHT
    }

    /**
     * The default anytime value.
     */
    private static boolean DEFAULT_ANYTIME = false;

    /**
     * The default heuristicType.
     */
    private static Heuristic.Type DEFAULT_HEURISTIC = Heuristic.Type.FAST_FORWARD;

    /**
     * The default weight of the heuristic.
     */
    private static double DEFAULT_WEIGHT = 1.0;

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
    public AbstractStateBasedPlanner() {
        super();
        this.heuristic = AbstractStateBasedPlanner.DEFAULT_HEURISTIC;
        this.weight = AbstractStateBasedPlanner.DEFAULT_WEIGHT;
        this.anytime = AbstractStateBasedPlanner.DEFAULT_ANYTIME;
    }

    /**
     * Returns the heuristicType to use to solve the planning problem.
     *
     * @return the heuristicType to use to solve the planning problem.
     */
    public final Heuristic.Type getHeuristicType() {
        return this.heuristic;
    }

    /**
     * Sets the heuristicType to use to solved the problem.
     *
     * @param heuristicType the heuristicType to use to solved the problem. The heuristicType cannot be null.
     */
    public final void setHeuristicType(final Heuristic.Type heuristicType) {
        Objects.requireNonNull(heuristicType);
        this.heuristic = heuristicType;
    }

    /**
     * Returns the weight set to the heuristic.
     *
     * @return the weight set to the heuristic.
     */
    public final double getWeight() {
        return this.weight;
    }

    /**
     * Sets the wight of the heuristic.
     *
     * @param weight the weight of the heuristic. The weight must be positive.
     */
    public final void setWeight(final double weight) {
        this.weight = weight;
    }

    /**
     * Set the anytime state value.
     *
     * @param anytimeState the anytime state value
     */
    public void setAnytimeState(boolean anytimeState) {
        this.anytime = anytimeState;
    }

    /**
     * Is planner anytime or not.
     *
     * @return true if planner is anytime, false otherwise
     */
    public boolean isAnytime() {
        return anytime;
    }

    /**
     * Returns the LOGGER of the AbstractPlanner class.
     *
     * @return the AbstractPlanner class.
     */
    public static Logger getLogger() {
        return AbstractPlanner.getLogger();
    }

    /**
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     */
    public static Properties getDefaultArguments() {
        final Properties options = AbstractPlanner.getDefaultArguments();
        options.put(AbstractStateBasedPlanner.Argument.PLANNER, Name.HSP);
        options.put(AbstractStateBasedPlanner.StateBasedArgument.HEURISTIC,
            AbstractStateBasedPlanner.DEFAULT_HEURISTIC);
        options.put(AbstractStateBasedPlanner.StateBasedArgument.WEIGHT,
            AbstractStateBasedPlanner.DEFAULT_WEIGHT);
        return options;
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
    public void setupPlanner(Heuristic.Type heuristic, int timeout,
                             double weight, boolean statisticState, int traceLevel) {
        this.setHeuristicType(heuristic);
        this.setTimeOut(timeout);
        this.setWeight(weight);
        this.setSaveState(statisticState);
        this.setTraceLevel(traceLevel);
    }

}
