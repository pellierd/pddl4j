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
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.operator.Action;

import java.util.Objects;

/**
 * This abstract class defines the main methods for search strategies.
 *
 * @author E. Hermellin, D. Pellier
 * @version 1.0 - 11.06.2018
 * @since 3.6
 */
public abstract class AbstractStateSpaceSearch implements StateSpaceSearch {

    /**
     * The heuristic of the planner.
     */
    private StateHeuristic.Name heuristic;

    /**
     * The heuristic weight.
     */
    private double weight;

    /**
     * The timeout for the search in second.
     */
    private int timeout;

    /**
     * The time spend to find a solution.
     */
    private long searchingTime;

    /**
     * The amount of memory used for the search.
     */
    private long memoryUsed;

    /**
     * The number of explored nodes.
     */
    private int exploredNodes;

    /**
     * The number of pending nodes.
     */
    private int pendingNodes;

    /**
     * The number of created nodes.
     */
    private int createdNodes;

    /**
     * Returns the heuristic to use to solve the planning problem.
     *
     * @return the heuristic to use to solve the planning problem.
     */
    @Override
    public final StateHeuristic.Name getHeuristic() {
        return this.heuristic;
    }

    /**
     * Sets the heuristic to use to solved the problem.
     *
     * @param heuristic the heuristic to use to solved the problem. The heuristic cannot be null.
     */
    @Override
    public final void setHeuristic(final StateHeuristic.Name heuristic) {
        Objects.requireNonNull(heuristic);
        this.heuristic = heuristic;
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
     * Sets the time out of the planner in second.
     *
     * @param timeout the time allocated to the search in second. Timeout must be positive.
     */
    @Override
    public final void setTimeOut(final int timeout) {
        this.timeout = timeout;
    }

    /**
     * Returns the time out of the planner in second.
     *
     * @return the time out of the planner, i.e., the time allocated to the search in second.
     */
    @Override
    public int getTimeout() {
        return this.timeout;
    }

    /**
     * Returns the time spend to find a solution.
     *
     * @return the time spend to find a solution.
     */
    @Override
    public long getSearchingTime() {
        return searchingTime;
    }

    /**
     * Sets the time out of the planner.
     *
     * @param searchingTime the time allocated to the search in second. Timeout mus be positive.
     */
    @Override
    public void setSearchingTime(final long searchingTime) {
        this.searchingTime = searchingTime;
    }

    /**
     * Returns the amount of memory used for the search.
     *
     * @return the amount of memory used for the search.
     */
    @Override
    public long getMemoryUsed() {
        return this.memoryUsed;
    }

    /**
     * Sets the amount of memory used for the search.
     *
     * @param memoryUsed the amount of memory used for the search.
     */
    @Override
    public void setMemoryUsed(final long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    /**
     * Returns the number of explored nodes.
     *
     * @return the number of explored nodes.
     */
    @Override
    public int getExploredNodes() {
        return this.exploredNodes;
    }

    /**
     * Sets the number of explored nodes.
     *
     * @param exploredNodes the number of explored nodes.
     */
    @Override
    public void setExploredNodes(final int exploredNodes) {
        this.exploredNodes = exploredNodes;
    }

    /**
     * Returns the number of pending nodes.
     *
     * @return the number of pending nodes.
     */
    @Override
    public int getPendingNodes() {
        return this.pendingNodes;
    }

    /**
     * Sets the number of pending nodes.
     *
     * @param pendingNodes the number of pending nodes.
     */
    @Override
    public void setPendingNodes(final int pendingNodes) {
        this.pendingNodes = pendingNodes;
    }

    /**
     * Returns the number of created nodes.
     *
     * @return the number of created nodes.
     */
    @Override
    public int getCreatedNodes() {
        return this.createdNodes;
    }

    /**
     * Sets the number of created nodes.
     *
     * @param createdNodes the number of created nodes.
     */
    @Override
    public void setCreatedNodes(final int createdNodes) {
        this.createdNodes = createdNodes;
    }

    /**
     * Create a new search strategy.
     */
    public AbstractStateSpaceSearch() {
        this(StateSpaceSearch.DEFAULT_TIMEOUT, StateSpaceSearch.DEFAULT_HEURISTIC,
            StateSpaceSearch.DEFAULT_HEURISTIC_WEIGHT);
    }

    /**
     * Create a new search strategy.
     *
     * @param timeout   the time out of the planner in seconds.
     */
    public AbstractStateSpaceSearch(int timeout) {
        this(timeout, StateSpaceSearch.DEFAULT_HEURISTIC, StateSpaceSearch.DEFAULT_HEURISTIC_WEIGHT);
    }

    /**
     * Create a new search strategy.
     *
     * @param timeout   the time out of the planner in seconds.
     * @param heuristic the heuristicType to use to solve the planning problem.
     * @param weight    the weight set to the heuristic.
     */
    public AbstractStateSpaceSearch(int timeout, StateHeuristic.Name heuristic, double weight) {
        super();
        this.timeout = timeout;
        this.heuristic = heuristic;
        this.weight = weight;
        this.searchingTime = 0;
        this.memoryUsed = 0;
        resetNodesStatistics();
    }

    /**
     * Search a solution node to a specified domain and problem.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return the solution node or null.
     */
    @Override
    public Node searchSolutionNode(final Problem codedProblem) {
        Objects.requireNonNull(codedProblem);
        return search(codedProblem);
    }

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return the solution plan or null.
     */
    @Override
    public Plan searchPlan(final Problem codedProblem) {
        Objects.requireNonNull(codedProblem);
        final Node solutionNode = search(codedProblem);
        if (solutionNode != null) {
            return extractPlan(solutionNode, codedProblem);
        } else {
            return null;
        }
    }

    /**
     * Extract a plan from a solution node for the specified planning problem.
     *
     * @param node    the solution node.
     * @param problem the problem to be solved.
     * @return the solution plan or null is no solution was found.
     */
    @Override
    public SequentialPlan extractPlan(final Node node, final Problem problem) {
        if (node != null) {
            Node n = node;
            final SequentialPlan plan = new SequentialPlan();
            while (n.getParent() != null) {
                final Action op = problem.getActions().get(n.getAction());
                plan.add(0, op);
                n = n.getParent();
            }
            return plan;
        } else {
            return null;
        }
    }

    /**
     * Reset Nodes statistics.
     */
    protected void resetNodesStatistics() {
        this.exploredNodes = 0;
        this.pendingNodes = 0;
        this.createdNodes = 0;
    }

}
