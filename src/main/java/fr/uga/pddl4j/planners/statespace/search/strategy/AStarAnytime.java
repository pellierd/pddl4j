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

package fr.uga.pddl4j.planners.statespace.search.strategy;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.heuristics.relaxation.HeuristicToolKit;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.MemoryAgent;
import fr.uga.pddl4j.util.Plan;
import fr.uga.pddl4j.util.SolutionEvent;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * This class implements A* Anytime Search strategy.
 *
 * @author E. Hermellin
 * @version 1.0 - 01.06.2018
 */
public final class AStarAnytime extends AbstractStateSpaceStrategyAnytime {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The bound cost for strategy search.
     */
    private double boundCost;

    /**
     * The The bound cost for strategy search.
     */
    private double boundDepth;

    /**
     * Sets the bound cost for strategy search.
     *
     * @param boundCost the bound cost for strategy search
     */
    public void setBoundCost(double boundCost) {
        this.boundCost = boundCost;
    }

    /**
     * Sets the bound depth for strategy search.
     *
     * @param boundDepth the bound depth for strategy search
     */
    public void setBoundDepth(double boundDepth) {
        this.boundDepth = boundDepth;
    }

    /**
     * Creates a new Greedy Best First Search search strategy with default parameters.
     */
    public AStarAnytime() {
        super();
        this.boundCost = Double.MAX_VALUE;
        this.boundDepth = Double.MAX_VALUE;
    }

    /**
     * Creates a new Greedy Best First Search search strategy.
     *
     * @param timeout   the time out of the planner.
     * @param heuristic the heuristicType to use to solve the planning problem.
     * @param weight    the weight set to the heuristic.
     */
    public AStarAnytime(int timeout, Heuristic.Type heuristic, double weight) {
        super(timeout, heuristic, weight);
        this.boundCost = Double.MAX_VALUE;
        this.boundDepth = Double.MAX_VALUE;
    }

    /**
     * Creates a new Greedy Best First Search search strategy.
     *
     * @param timeout   the time out of the planner.
     * @param heuristic the heuristicType to use to solve the planning problem.
     * @param weight    the weight set to the heuristic.
     * @param boundCost  the cost bound for the search.
     * @param boundDepth the depth bound for the search.
     */
    public AStarAnytime(int timeout, Heuristic.Type heuristic, double weight,
                        double boundCost, double boundDepth) {
        super(timeout, heuristic, weight);
        this.boundCost = boundCost;
        this.boundDepth = boundDepth;
    }

    /**
     * The greedy best first search algorithm. Solves the planning problem and returns the first solution plan found.
     * This method must be completed.
     *
     * @param problem the problem to be solved. The problem cannot be null.
     * @return a solution plan or null if it does not exist.
     */
    public Node search(final CodedProblem problem) {
        final Logger logger = Planner.getLogger();
        Objects.requireNonNull(problem);

        final long begin = System.currentTimeMillis();
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(this.getHeuristicType(), problem);
        // Get the initial state from the planning problem
        final BitState init = new BitState(problem.getInit());
        // Initialize the closed list of nodes (store the nodes explored)
        final Map<BitState, Node> closeSet = new HashMap<>();
        // Initialize the opened list (store the pending node)
        final Map<BitState, Node> openSet = new HashMap<>();
        // Initialize the weight to use
        final double currWeight = this.getWeight();
        // Initialize the node comparator
        NodeComparator nodeComparator = new NodeComparator(currWeight);
        // The list stores the node ordered according to the A* (getFValue = g + h) function
        final PriorityQueue<Node> open = new PriorityQueue<>(100, nodeComparator);
        // Creates the root node of the tree search
        final Node root = new Node(init, null, -1, 0.0, 0, heuristic.estimate(init, problem.getGoal()));
        // Adds the root to the list of pending nodes
        open.add(root);
        openSet.put(init, root);

        this.resetNodesStatistics();
        this.clearResults();
        Node solution = null;

        final int timeout = this.getTimeout();
        long searchingTime = 0;
        // Start of the search
        while (!openSet.isEmpty() && searchingTime < timeout) {

            // Pop the first node in the pending list open
            final Node current = open.poll();
            openSet.remove(current);
            closeSet.put(current, current);

            if (current.satisfy(problem.getGoal())) {
                this.getSolutionNodes().add(new Node(current, current.getParent(), 0,
                    current.getCost(), current.getDepth(), current.getHeuristic()));
                solution = current;
                fireSolution(new SolutionEvent(this, solution, problem));

                final Plan p = extractPlan(solution, problem);

                boundCost = p.cost();
                boundDepth = p.size();
                logger.trace("* " + this.getSolutionNodes().size() + " solution(s) found. Best cost: "
                    + boundCost + "\n");
            } else {
                // Try to apply the operators of the problem to this node
                int index = 0;
                for (BitOp op : problem.getOperators()) {
                    // Test if a specified operator is applicable in the current state
                    if (op.isApplicable(current)) {
                        Node state = new Node(current);
                        this.setCreatedNodes(this.getCreatedNodes() + 1);
                        // Apply the effect of the applicable operator
                        // Test if the condition of the effect is satisfied in the current state
                        // Apply the effect to the successor node
                        op.getCondEffects().stream().filter(ce -> current.satisfy(ce.getCondition())).forEach(ce ->
                            // Apply the effect to the successor node
                            state.apply(ce.getEffects())
                        );
                        final double g = current.getCost() + op.getCost();
                        Node result = openSet.get(state);
                        if (result == null) {
                            result = closeSet.get(state);
                            if (result != null) {
                                if (g < result.getCost()) {
                                    result.setCost(g);
                                    result.setParent(current);
                                    result.setOperator(index);
                                    result.setDepth(current.getDepth() + 1);
                                    if (result.getCost() < boundCost && result.getDepth() <= boundDepth) {
                                        open.add(result);
                                        openSet.put(result, result);
                                        closeSet.remove(result);
                                    }
                                }
                            } else {
                                state.setCost(g);
                                state.setParent(current);
                                state.setOperator(index);
                                state.setHeuristic(heuristic.estimate(state, problem.getGoal()));
                                state.setDepth(current.getDepth() + 1);
                                if (state.getCost() < boundCost && state.getDepth() <= boundDepth) {
                                    open.add(state);
                                    openSet.put(state, state);
                                }
                            }
                        } else if (g < result.getCost()) {
                            result.setCost(g);
                            result.setParent(current);
                            result.setOperator(index);
                            result.setDepth(current.getDepth() + 1);
                        }

                    }
                    index++;
                }
            }

            // Take time to compute the searching time
            searchingTime = System.currentTimeMillis() - begin;
        }

        this.setExploredNodes(closeSet.size());
        this.setPendingNodes(openSet.size());
        this.setMemoryUsed(MemoryAgent.getDeepSizeOf(closeSet) + MemoryAgent.getDeepSizeOf(openSet)
            + MemoryAgent.getDeepSizeOf(heuristic));
        this.setSearchingTime(searchingTime);

        this.clearBounds();

        return solution;
    }

    /**
     * Clear boundaries at the end of the computation.
     */
    private void clearBounds() {
        this.boundCost = Double.MAX_VALUE;
        this.boundDepth = Double.MAX_VALUE;
    }
}
