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

package fr.uga.pddl4j.planners.statespace.search;

import fr.uga.pddl4j.heuristics.state.StateHeuristic;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.SearchStrategy;
import fr.uga.pddl4j.problem.ADLProblem;

/**
 * This interface defines the main methods for search strategies.
 *
 * @author E. Hermellin, D. Pellier
 * @version 1.0 - 11.06.2018
 * @since 3.6
 */
public interface StateSpaceSearch extends SearchStrategy {

    /**
     * The default heuristic used (FAST_FORWARD).
     */
    static final StateHeuristic.Name DEFAULT_HEURISTIC = StateHeuristic.Name.FAST_FORWARD;

    /**
     * The default weight of the heuristic (1.0).
     */
    static final double DEFAULT_HEURISTIC_WEIGHT = 1.0;

    /**
     * The default time out (600s).
     */
    static final int DEFAULT_TIMEOUT = 600;

    /**
     * Returns the heuristic to use to solve the planning problem.
     *
     * @return the heuristic to use to solve the planning problem.
     */
    StateHeuristic.Name getHeuristic();

    /**
     * Sets the heuristic to use to solved the problem.
     *
     * @param heuristic the heuristic to use to solved the problem. The heuristic cannot be null.
     */
    void setHeuristic(final StateHeuristic.Name heuristic);

    /**
     * Returns the weight set to the heuristic.
     *
     * @return the weight set to the heuristic.
     */
    double getWeight();

    /**
     * Sets the wight of the heuristic.
     *
     * @param weight the weight of the heuristic. The weight must be positive.
     */
    void setWeight(final double weight);

    /**
     * Sets the time out of the planner.
     *
     * @param timeout the time allocated to the search in second.
     */
    void setTimeOut(final int timeout);

    /**
     * Returns the time out of the planner.
     *
     * @return the time out of the planner, i.e., the time allocated to the search in second.
     */
    int getTimeout();

    /**
     * Returns the time spend to find a solution.
     *
     * @return the time spend to find a solution.
     */
    long getSearchingTime();

    /**
     * Sets the time spend to find a solution.
     *
     * @param searchingTime the time spend to find a solution.
     */
    void setSearchingTime(final long searchingTime);

    /**
     * Returns the amount of memory used for the search.
     *
     * @return the amount of memory used for the search.
     */
    long getMemoryUsed();

    /**
     * Sets the amount of memory used for the search.
     *
     * @param memoryUsed the amount of memory used for the search.
     */
    void setMemoryUsed(final long memoryUsed);

    /**
     * Returns the number of explored nodes.
     *
     * @return the number of explored nodes.
     */
    int getExploredNodes();

    /**
     * Sets the number of explored nodes.
     *
     * @param exploredNodes the number of explored nodes.
     */
    void setExploredNodes(final int exploredNodes);

    /**
     * Returns the number of pending nodes.
     *
     * @return the number of pending nodes.
     */
    int getPendingNodes();

    /**
     * Sets the number of pending nodes.
     *
     * @param pendingNodes the number of pending nodes.
     */
    void setPendingNodes(final int pendingNodes);

    /**
     * Returns the number of created nodes.
     *
     * @return the number of created nodes.
     */
    int getCreatedNodes();

    /**
     * Sets the number of created nodes.
     *
     * @param createdNodes the number of created nodes.
     */
    void setCreatedNodes(final int createdNodes);

    /**
     * Solves the planning problem and returns the first solution node found.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return a solution search or null if it does not exist.
     */
    Node search(final ADLProblem codedProblem);

    /**
     * Search a solution node to a specified domain and problem.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return the solution node or null.
     */
    Node searchSolutionNode(final ADLProblem codedProblem);

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return the solution plan or null.
     */
    Plan searchPlan(final ADLProblem codedProblem);

    /**
     * Extract a plan from a solution node for the specified planning problem.
     *
     * @param solutionNode the solution node.
     * @param codedProblem the problem to be solved.
     * @return the solution plan or null is no solution was found.
     */
    Plan extractPlan(final Node solutionNode, final ADLProblem codedProblem);

    /**
     * Returns an instance of a specified search strategy with the default heuristic, weight and timeout.
     *
     * @param name the name of the search strategy.
     * @return the search strategy.
     */
    static StateSpaceSearch getInstance(final SearchStrategy.Name name) {
        return StateSpaceSearch.getInstance(name, StateSpaceSearch.DEFAULT_HEURISTIC);
    }

    /**
     * Returns an instance of a specified search strategy withe the default weight and timeout.
     *
     * @param name the name of the search strategy.
     * @param heuristic the heuristic to used bt the search strategy.
     * @return the search strategy.
     */
    static StateSpaceSearch getInstance(final SearchStrategy.Name name, final StateHeuristic.Name heuristic) {
        return StateSpaceSearch.getInstance(name, heuristic, StateSpaceSearch.DEFAULT_HEURISTIC_WEIGHT);
    }

    /**
     * Returns an instance of a specified search strategy with ethe default timeout.
     *
     * @param name the name of the search strategy.
     * @param heuristic the heuristic to used bt the search strategy.
     * @param weight the weight of the heuristic to used of the search strategy.
     * @return the search strategy.
     */
    static StateSpaceSearch getInstance(final SearchStrategy.Name name, final StateHeuristic.Name heuristic,
                                        final double weight) {
        return StateSpaceSearch.getInstance(name, heuristic, weight, StateSpaceSearch.DEFAULT_TIMEOUT);
    }

    /**
     * Returns an instance of a specified search strategy.
     *
     * @param name the name of the search strategy.
     * @param heuristic the heuristic to used bt the search strategy.
     * @param weight the weight of the heuristic to used of the search strategy.
     * @param timeout the timeout of the search strategy.
     * @return the search strategy.
     */
    static StateSpaceSearch getInstance(final SearchStrategy.Name name, final StateHeuristic.Name heuristic,
                                        final double weight, final int timeout) {
        switch (name) {
            case ASTAR:
                return new AStar(timeout, heuristic, weight);
            case BREADTH_FIRST:
                return new BreadthFirstSearch(timeout);
            case DEPTH_FIRST:
                return new DepthFirstSearch(timeout);
            case ENFORCED_HILL_CLIMBING:
                return new EnforcedHillClimbing(timeout, heuristic, weight);
            case GREEDY_BEST_FIRST:
                return new GreedyBestFirstSearch(timeout, heuristic, weight);
            case HILL_CLIMBING:
                return new HillClimbing(timeout, heuristic, weight);
            default:
                return null;
        }
    }
}
