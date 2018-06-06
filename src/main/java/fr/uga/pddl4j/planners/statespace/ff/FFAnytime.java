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
import fr.uga.pddl4j.heuristics.relaxation.HeuristicToolKit;
import fr.uga.pddl4j.planners.statespace.AbstractStateSpacePlannerAnytime;
import fr.uga.pddl4j.planners.statespace.StateSpacePlannerFactory;
import fr.uga.pddl4j.planners.statespace.search.strategy.EnforcedHillClimbing;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.planners.statespace.search.strategy.NodeComparator;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.MemoryAgent;
import fr.uga.pddl4j.util.Plan;
import fr.uga.pddl4j.util.SequentialPlan;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * This class implements Fast Forward planner based on Enforced Hill Climbing Algorithm.
 *
 * @author Samuel Aaron Boyd
 * @author E. Hermellin
 * @version 2.0 - 24.01.2018
 */
public final class FFAnytime extends AbstractStateSpacePlannerAnytime {

    /**
     * The time needed to search a solution plan.
     */
    private long searchingTime;

    /**
     * Creates a new planner.
     */
    public FFAnytime() {
        super();
        this.searchingTime = 0;
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
        final Node firstSolutionNode = EnforcedHillClimbing.searchSolutionNode(this, pb);

        if (firstSolutionNode != null) {
            logger.trace("* enforced hill climbing succeeded\n");
            logger.trace("* starting greedy best first search anytime (optimized)\n");
            searchingTime = 0;
            final SequentialPlan solutionPlan = extract(firstSolutionNode, pb);
            final Node solutionNode = greedyBestFirstSearch(pb, solutionPlan.cost(), solutionPlan.size());

            this.getSolutionNodes().clear();

            if (solutionNode != null) {
                logger.trace("* greedy best first search anytime succeeded\n");
                return extract(solutionNode, pb);
            } else {
                logger.trace("* greedy best first search anytime failed\n");
                return extract(firstSolutionNode, pb);
            }
        } else {
            logger.trace("* enforced hill climbing failed\n");
            logger.trace("* starting greedy best first search anytime\n");
            searchingTime = 0;
            final Node  solutionNode = this.greedyBestFirstSearch(pb, Double.MAX_VALUE, Integer.MAX_VALUE);

            this.getSolutionNodes().clear();

            if (solutionNode != null) {
                logger.trace("* greedy best first search anytime succeeded\n");
                return extract(solutionNode, pb);
            } else {
                logger.trace("* greedy best first search anytime failed\n");
                return null;
            }
        }
    }

    /**
     * Extracts a search from a specified node.
     *
     * @param node    the node.
     * @param problem the problem.
     * @return the search extracted from the specified node.
     */
    private SequentialPlan extract(final Node node, final CodedProblem problem) {
        final SequentialPlan plan = new SequentialPlan();
        if (node != null) {
            Node n = node;
            while (n.getParent() != null) {
                final BitOp op = problem.getOperators().get(n.getOperator());
                plan.add(0, op);
                n = n.getParent();
            }
        }
        return plan;
    }

    /**
     * The greedy best first search algorithm. Solves the planning problem and returns the first solution plan found.
     * This method must be completed.
     *
     * @param problem the coded planning problem to solve.
     * @return a solution plan or null if it does not exist.
     */
    private Node greedyBestFirstSearch(final CodedProblem problem, double boundCost, int boundDepth) {
        final Logger logger = this.getLogger();
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

        Node solution = null;

        final int timeout = this.getTimeout();

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

                final Plan p = extract(solution, problem);
                nodeComparator.setWeight((p.cost() / boundCost) * this.getWeight());
                this.setWeight((p.cost() / boundCost) * this.getWeight());

                boundCost = solution.getCost();
                boundDepth = solution.getDepth();
                logger.trace("* " + this.getSolutionNodes().size() + " solutions found. Best cost: "
                    + boundCost + "\n");
            } else {
                // Try to apply the operators of the problem to this node
                int index = 0;
                for (BitOp op : problem.getOperators()) {
                    // Test if a specified operator is applicable in the current state
                    if (op.isApplicable(current)) {
                        Node state = new Node(current);
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

        searchingTime = System.currentTimeMillis() - begin;

        if (isSaveState()) {
            // Compute the searching time
            this.getStatistics().setTimeToSearch(searchingTime);
            if (StateSpacePlannerFactory.isMemoryAgent()) {
                // Compute the memory used by the search
                try {
                    this.getStatistics().setMemoryUsedToSearch(MemoryAgent.deepSizeOf(closeSet)
                        + MemoryAgent.deepSizeOf(openSet) + MemoryAgent.deepSizeOf(heuristic));
                } catch (IllegalStateException ilException) {
                    this.getLogger().error(ilException);
                }
            }
        }

        return solution;
    }
}
