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

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.planners.statespace.AbstractStateSpacePlannerAnytime;
import fr.uga.pddl4j.planners.statespace.search.strategy.EnforcedHillClimbing;
import fr.uga.pddl4j.planners.statespace.search.strategy.GreedyBestFirstSearchAnytime;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.util.Plan;
import fr.uga.pddl4j.util.SequentialPlan;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Vector;

/**
 * This class implements Fast Forward planner based on Enforced Hill Climbing Algorithm.
 *
 * @author Samuel Aaron Boyd
 * @author E. Hermellin
 * @version 2.0 - 24.01.2018
 */
public final class FFAnytime extends AbstractStateSpacePlannerAnytime {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The Enforced Hill Climbing strategy.
     */
    private EnforcedHillClimbing enforcedHillClimbing;

    /**
     * The Greedy Best First Search Anytime strategy.
     */
    private GreedyBestFirstSearchAnytime greedyBestFirstSearchAnytime;

    /**
     * Returns the list containing all solution nodes found.
     *
     * @return the list containing all solution nodes found.
     */
    @Override
    public Vector<Node> getSolutionNodes() {
        return greedyBestFirstSearchAnytime.getSolutionNodes();
    }

    /**
     * Returns the list containing all solution plans found.
     *
     * @return the list containing all solution plans found.
     */
    @Override
    public Vector<Plan> getSolutionPlans(final CodedProblem codedProblem) {
        Objects.requireNonNull(codedProblem);
        return greedyBestFirstSearchAnytime.getSolutionPlans(codedProblem);
    }

    /**
     * Creates a new planner with default parameters.
     *
     */
    public FFAnytime() {
        super();

        enforcedHillClimbing = new EnforcedHillClimbing();
        greedyBestFirstSearchAnytime = new GreedyBestFirstSearchAnytime();

        this.getStateSpaceStrategies().add(enforcedHillClimbing);
        this.getStateSpaceStrategies().add(greedyBestFirstSearchAnytime);
    }

    /**
     * Creates a new planner with default parameters for search strategy.
     *
     * @param statisticState the statistics generation value.
     * @param traceLevel     the trace level of the planner.
     */
    public FFAnytime(final boolean statisticState, final int traceLevel) {
        super(statisticState, traceLevel);

        enforcedHillClimbing = new EnforcedHillClimbing();
        greedyBestFirstSearchAnytime = new GreedyBestFirstSearchAnytime();

        this.getStateSpaceStrategies().add(enforcedHillClimbing);
        this.getStateSpaceStrategies().add(greedyBestFirstSearchAnytime);
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
    public FFAnytime(final int timeout, final Heuristic.Type heuristicType, final double weight,
                     final boolean statisticState, final int traceLevel) {
        super(statisticState, traceLevel);

        enforcedHillClimbing = new EnforcedHillClimbing(timeout, heuristicType, weight);
        greedyBestFirstSearchAnytime = new GreedyBestFirstSearchAnytime(timeout, heuristicType, weight);

        this.getStateSpaceStrategies().add(enforcedHillClimbing);
        this.getStateSpaceStrategies().add(greedyBestFirstSearchAnytime);
    }

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param pb the problem to solve.
     */
    @Override
    public SequentialPlan search(final CodedProblem pb) {
        final Logger logger = this.getLogger();
        Objects.requireNonNull(pb);

        logger.trace("* starting enforced hill climbing\n");
        final Node firstSolutionNode = enforcedHillClimbing.searchSolutionNode(pb);

        greedyBestFirstSearchAnytime.getSolutionNodes().clear();

        if (firstSolutionNode != null) {
            logger.trace("* enforced hill climbing succeeded\n");
            logger.trace("* starting greedy best first search anytime (optimized)\n");
            final SequentialPlan solutionPlan = enforcedHillClimbing.extractPlan(firstSolutionNode, pb);

            greedyBestFirstSearchAnytime.setBoundCost(solutionPlan.cost());
            greedyBestFirstSearchAnytime.setBoundDepth(solutionPlan.size());
            final Node solutionNode = greedyBestFirstSearchAnytime.searchSolutionNode(pb);

            if (solutionNode != null) {
                logger.trace("* greedy best first search anytime succeeded\n");
                if (isSaveState()) {
                    this.getStatistics().setTimeToSearch(greedyBestFirstSearchAnytime.getSearchingTime());
                    this.getStatistics().setMemoryUsedToSearch(greedyBestFirstSearchAnytime.getMemoryUsed());
                }
                return greedyBestFirstSearchAnytime.extractPlan(solutionNode, pb);
            } else {
                logger.trace("* greedy best first search anytime failed\n");
                if (isSaveState()) {
                    this.getStatistics().setTimeToSearch(enforcedHillClimbing.getSearchingTime());
                    this.getStatistics().setMemoryUsedToSearch(enforcedHillClimbing.getMemoryUsed());
                }
                return enforcedHillClimbing.extractPlan(firstSolutionNode, pb);
            }
        } else {
            logger.trace("* enforced hill climbing failed\n");
            logger.trace("* starting greedy best first search anytime\n");
            greedyBestFirstSearchAnytime.setBoundCost(Double.MAX_VALUE);
            greedyBestFirstSearchAnytime.setBoundDepth(Double.MAX_VALUE);
            final Node solutionNode = greedyBestFirstSearchAnytime.searchSolutionNode(pb);

            if (solutionNode != null) {
                logger.trace("* greedy best first search anytime succeeded\n");
                if (isSaveState()) {
                    this.getStatistics().setTimeToSearch(greedyBestFirstSearchAnytime.getSearchingTime());
                    this.getStatistics().setMemoryUsedToSearch(greedyBestFirstSearchAnytime.getMemoryUsed());
                }
                return greedyBestFirstSearchAnytime.extractPlan(solutionNode, pb);
            } else {
                logger.trace("* greedy best first search anytime failed\n");
                return null;
            }
        }
    }
}
