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

package fr.uga.pddl4j.planners.statespace.hsp;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.planners.statespace.AbstractStateSpacePlanner;
import fr.uga.pddl4j.planners.statespace.search.strategy.AStar;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.planners.statespace.search.strategy.StateSpaceStrategy;
import fr.uga.pddl4j.util.SequentialPlan;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * This class implements a simple forward planner based on A* algorithm.
 *
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 */
public final class HSP extends AbstractStateSpacePlanner {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The A* strategy.
     */
    private final StateSpaceStrategy astar;

    /**
     * Creates a new planner with default parameters.
     */
    public HSP() {
        astar = new AStar();
        this.getStateSpaceStrategies().add(astar);
    }

    /**
     * Creates a new planner with default parameters for search strategy.
     *
     * @param statisticState the statistics generation value.
     * @param traceLevel     the trace level of the planner.
     */
    public HSP(final boolean statisticState, final int traceLevel) {
        super(statisticState, traceLevel);

        astar = new AStar();
        this.getStateSpaceStrategies().add(astar);
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
    public HSP(final int timeout, final Heuristic.Type heuristicType, final double weight,
               final boolean statisticState, final int traceLevel) {
        super(statisticState, traceLevel);

        astar = new AStar(timeout, heuristicType, weight);
        this.getStateSpaceStrategies().add(astar);
    }

    /**
     * Solves the planning problem and returns the first solution search found.
     *
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     */
    @Override
    public SequentialPlan search(final CodedProblem problem) {
        final Logger logger = this.getLogger();
        Objects.requireNonNull(problem);

        logger.trace("* starting A*\n");
        final Node solutionNode = astar.searchSolutionNode(problem);
        if (isSaveState()) {
            this.getStatistics().setTimeToSearch(astar.getSearchingTime());
            this.getStatistics().setMemoryUsedToSearch(astar.getMemoryUsed());
        }
        if (solutionNode != null) {
            logger.trace("* A* succeeded\n");
            return (SequentialPlan) astar.extractPlan(solutionNode, problem);
        } else {
            logger.trace("* A* failed\n");
            return null;
        }
    }
}
