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

package fr.uga.pddl4j.planners.statespace.ff;

import fr.uga.pddl4j.heuristics.relaxation.RelaxationHeuristic;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.statespace.AbstractStateSpacePlanner;
import fr.uga.pddl4j.planners.statespace.search.strategy.AStar;
import fr.uga.pddl4j.planners.statespace.search.strategy.EnforcedHillClimbing;
import fr.uga.pddl4j.planners.statespace.search.strategy.GreedyBestFirstSearch;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.planners.statespace.search.strategy.StateSpaceStrategy;
import fr.uga.pddl4j.problem.Problem;

import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * This class implements Fast Forward planner based on Enforced Hill Climbing Algorithm and
 * Greedy Best First Search.
 *
 * @author Samuel Aaron Boyd
 * @author E. Hermellin
 * @author D. Pellier
 * @version 2.0 - 24.01.2018
 */
public final class FF extends AbstractStateSpacePlanner {

    /**
     * The Enforced Hill Climbing strategy.
     */
    private final StateSpaceStrategy enforcedHillClimbing;

    /**
     * The Greedy Best First Search strategy.
     */
    private final StateSpaceStrategy astar;

    /**
     * Creates a new planner with default parameters.
     */
    public FF() {
        super();

        this.enforcedHillClimbing = new EnforcedHillClimbing();
        this.astar = new AStar();

        this.getStateSpaceStrategies().add(this.enforcedHillClimbing);
        this.getStateSpaceStrategies().add(this.astar);
    }

    /**
     * Creates a new planner with default parameters for search strategy.
     *
     * @param statisticState the statistics generation value.
     * @param traceLevel     the trace level of the planner.
     */
    public FF(final boolean statisticState, final int traceLevel) {
        super(statisticState, traceLevel);

        this.enforcedHillClimbing = new EnforcedHillClimbing();
        this.astar = new AStar();

        this.getStateSpaceStrategies().add(this.enforcedHillClimbing);
        this.getStateSpaceStrategies().add(this.astar);
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
    public FF(final int timeout, final RelaxationHeuristic.Type heuristicType, final double weight,
              final boolean statisticState, final int traceLevel) {
        super();
        this.setSaveState(statisticState);
        this.setTraceLevel(traceLevel);

        this.enforcedHillClimbing = new EnforcedHillClimbing(timeout, heuristicType, weight);
        this.astar = new GreedyBestFirstSearch(timeout, heuristicType, weight);

        this.getStateSpaceStrategies().add(this.enforcedHillClimbing);
        this.getStateSpaceStrategies().add(this.astar);
    }

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param pb the problem to solve.
     */
    @Override
    public Plan search(final Problem pb) {
        final Logger logger = this.getLogger();
        Objects.requireNonNull(pb);

        logger.trace("* starting enforced hill climbing\n");
        Node solutionNode = this.enforcedHillClimbing.searchSolutionNode(pb);

        if (solutionNode != null) {
            logger.trace("* enforced hill climbing succeeded\n");
            if (isSaveState()) {
                this.getStatistics().setTimeToSearch(this.enforcedHillClimbing.getSearchingTime());
                this.getStatistics().setMemoryUsedToSearch(this.enforcedHillClimbing.getMemoryUsed());
            }
            return (SequentialPlan) this.enforcedHillClimbing.extractPlan(solutionNode, pb);
        } else {
            logger.trace("* enforced hill climbing failed\n");
            logger.trace("* starting greedy best first search\n");
            solutionNode = astar.searchSolutionNode(pb);
            if (isSaveState()) {
                this.getStatistics().setTimeToSearch(this.astar.getSearchingTime());
                this.getStatistics().setMemoryUsedToSearch(this.astar.getMemoryUsed());
            }
            if (solutionNode == null) {
                logger.trace("* greedy best first search failed\n");
                return null;
            } else {
                logger.trace("* greedy best first search succeeded\n");
                return (SequentialPlan) this.astar.extractPlan(solutionNode, pb);
            }
        }
    }
}
