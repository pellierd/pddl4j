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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * This class implements Greedy Best First Anytime Search strategy.
 *
 * @author E. Hermellin
 * @version 1.0 - 23.11.2018
 */
public final class GreedyBestFirstSearchAnytime extends AbstractStateSpaceStrategyAnytime {

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
    public GreedyBestFirstSearchAnytime() {
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
    public GreedyBestFirstSearchAnytime(int timeout, Heuristic.Type heuristic, double weight) {
        super(timeout, heuristic, weight);
        this.boundCost = Double.MAX_VALUE;
        this.boundDepth = Double.MAX_VALUE;
    }

    /**
     * Creates a new Greedy Best First Search search strategy.
     *
     * @param timeout    the time out of the planner.
     * @param heuristic  the heuristicType to use to solve the planning problem.
     * @param weight     the weight set to the heuristic.
     * @param boundCost  the cost bound for the search.
     * @param boundDepth the depth bound for the search.
     */
    public GreedyBestFirstSearchAnytime(int timeout, Heuristic.Type heuristic, double weight,
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

        final Heuristic heuristic = HeuristicToolKit.createHeuristic(getHeuristicType(), problem);
        final Set<Node> closeSet = new HashSet<>();
        final Set<Node> openSet = new HashSet<>();
        final int timeout = getTimeout();

        BitState init = new BitState(problem.getInit());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, problem.getGoal()));
        root.setDepth(0);
        openSet.add(root);

        this.resetNodesStatistics();
        this.clearResults();
        Node solution = null;
        long searchingTime = 0;

        while (!openSet.isEmpty() && searchingTime < timeout) {
            // Pop the first node in the pending list open
            final Node current = popPriorityNode(openSet);

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
                closeSet.add(current);
                int index = 0;
                for (BitOp op : problem.getOperators()) {

                    // Test if a specified operator is applicable in the current state
                    if (op.isApplicable(current)) {
                        final BitState nextState = new BitState(current);
                        nextState.or(op.getCondEffects().get(0).getEffects().getPositive());
                        nextState.andNot(op.getCondEffects().get(0).getEffects().getNegative());

                        // Apply the effect of the applicable operator
                        final Node successor = new Node(nextState);
                        this.setCreatedNodes(this.getCreatedNodes() + 1);
                        successor.setCost(current.getCost() + op.getCost());
                        successor.setHeuristic(heuristic.estimate(nextState, problem.getGoal()));
                        successor.setParent(current);
                        successor.setOperator(index);
                        successor.setDepth(current.getDepth() + 1);
                        if (successor.getCost() < boundCost && successor.getDepth() <= boundDepth) {
                            openSet.add(successor);
                        }
                    }
                    index++;
                }
            }
            // Take time to compute the searching time
            long end = System.currentTimeMillis();
            searchingTime = end - begin;
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

    /**
     * Get a node from a list of nodes.
     *
     * @param states the list of nodes (successors).
     * @return the node from the list.
     */
    private Node popPriorityNode(Collection<Node> states) {
        Node state = null;
        if (!states.isEmpty()) {
            final Iterator<Node> i = states.iterator();
            state = i.next();
            while (i.hasNext()) {
                final Node next = i.next();
                if (next.getHeuristic() < state.getHeuristic()) {
                    state = next;
                }
            }
            states.remove(state);
        }
        return state;
    }
}
