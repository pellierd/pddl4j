/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.planners.statespace.hc;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.planners.statespace.AbstractStateSpacePlannerAnytime;
import fr.uga.pddl4j.planners.statespace.search.strategy.HillClimbingAnytime;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.util.SequentialPlan;

import org.apache.logging.log4j.Logger;

public class HCAnytime extends AbstractStateSpacePlannerAnytime {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The Enforced Hill Climbing strategy.
     */
    private HillClimbingAnytime hillClimbingAnytime;

    /**
     * Creates a new planner with default parameters.
     */
    public HCAnytime() {
        super();

        hillClimbingAnytime = new HillClimbingAnytime();

        this.getStateSpaceStrategies().add(hillClimbingAnytime);
    }

    /**
     * Creates a new planner with default parameters for search strategy.
     *
     * @param statisticState the statistics generation value.
     * @param traceLevel     the trace level of the planner.
     */
    public HCAnytime(final boolean statisticState, final int traceLevel) {
        super(statisticState, traceLevel);

        hillClimbingAnytime = new HillClimbingAnytime();

        this.getStateSpaceStrategies().add(hillClimbingAnytime);
    }

    /**
     * Creates a new planner.
     *
     * @param timeout        the time out of the planner.
     * @param heuristicType  the heuristicType to use to solve the planning problem.
     * @param weight         the weight set to the heuristic.
     * @param statisticState the statistics generation value.
     * @param traceLevel     the trace level of the planner.
     */
    public HCAnytime(final int timeout, final Heuristic.Type heuristicType, final double weight,
                     final boolean statisticState, final int traceLevel) {
        super(statisticState, traceLevel);

        hillClimbingAnytime = new HillClimbingAnytime(timeout, heuristicType, weight);

        this.getStateSpaceStrategies().add(hillClimbingAnytime);
    }

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param problem the problem to solve.
     */
    @Override
    public SequentialPlan search(final CodedProblem problem) {
        final Logger logger = this.getLogger();

        logger.trace("* starting hill climbing anytime search\n");
        hillClimbingAnytime.getSolutionNodes().clear();

        final Node solution = hillClimbingAnytime.searchSolutionNode(problem);

        if (solution == null) {
            logger.trace("* hill climbing anytime search failed\n");
            return null;
        } else {
            logger.trace("* hill climbing anytime search succeeded\n");
            if (isSaveState()) {
                this.getStatistics().setTimeToSearch(hillClimbingAnytime.getSearchingTime());
                this.getStatistics().setMemoryUsedToSearch(hillClimbingAnytime.getMemoryUsed());
            }
            return hillClimbingAnytime.extractPlan(solution, problem);
        }
    }
}
