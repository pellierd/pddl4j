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

package fr.uga.pddl4j.planners.ff;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.heuristics.relaxation.HeuristicToolKit;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.hc.EHC;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.MemoryAgent;
import fr.uga.pddl4j.util.SequentialPlan;

import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * This class implements Fast Forward planner based on Enforced Hill Climbing Algorithm and
 * Gready Best First Search.
 *
 * @author Samuel Aaron Boyd
 * @author E. Hermellin
 * @version 2.0 - 24.01.2018
 */
public final class FF extends AbstractPlanner {

    /**
     * The time needed to search a solution plan.
     */
    private long searchingTime;

    /**
     * Creates a new planner.
     */
    public FF() {
        super();
        this.setHeuristicType(FF.DEFAULT_HEURISTIC);
        this.setWeight(FF.DEFAULT_WEIGHT);
        this.setTimeOut(FF.DEFAULT_TIMEOUT);
        this.setSaveState(FF.DEFAULT_STATISTICS);
    }

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param pb the problem to solve.
     */
    @Override
    public SequentialPlan search(final CodedProblem pb) {
        final Logger logger = AbstractPlanner.getLogger();
        Objects.requireNonNull(pb);
        searchingTime = 0;

        final EHC ehc = new EHC(this.getHeuristicType(), this.getWeight(),
            this.getTimeout(), this.isSaveState());

        SequentialPlan solutionPlan = ehc.search(pb);

        if (solutionPlan != null) {
            logger.trace("\nstarting enforced hill climbing");
            return solutionPlan;
        } else {
            logger.trace("\nenforced hill climbing failed\n");
            logger.trace("starting greedy best first search\n");
            final Node solutionNode = this.greedyBestFirstSearch(pb);

            if (solutionNode == null) {
                logger.trace("\ngreedy best first search failed\n");
                return null;
            } else {
                return extract(solutionNode, pb);
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
        Node n = node;
        final SequentialPlan plan = new SequentialPlan();
        while (n.getParent() != null) {
            final BitOp op = problem.getOperators().get(n.getOperator());
            plan.add(0, op);
            n = n.getParent();
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
    private Node greedyBestFirstSearch(final CodedProblem problem) {
        final long begin = System.currentTimeMillis();
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(this.getHeuristicType(), problem);
        final Set<Node> closeSet = new HashSet<>();
        final Set<Node> openSet = new HashSet<>();
        final int timeout = this.getTimeout() * 1000;
        Node solution = null;

        BitState init = new BitState(problem.getInit());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, problem.getGoal()));
        root.setDepth(0);
        openSet.add(root);

        while (!openSet.isEmpty() && solution == null && searchingTime < timeout) {
            // Pop the first node in the pending list open
            final Node current = this.popPriorityNode(openSet);

            if (current.satisfy(problem.getGoal())) {
                solution = current;
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
                        successor.setCost(current.getCost() + op.getCost());
                        successor.setHeuristic(heuristic.estimate(nextState, problem.getGoal()));
                        successor.setParent(current);
                        successor.setOperator(index);
                        successor.setDepth(current.getDepth() + 1);
                        openSet.add(successor);
                    }
                    index++;
                }
            }
            // Take time to compute the searching time
            long end = System.currentTimeMillis();
            searchingTime = end - begin;
        }

        if (isSaveState()) {
            // Compute the searching time
            this.getStatistics().setTimeToSearch(searchingTime);
            // Compute the memory used by the search
            this.getStatistics().setMemoryUsedToSearch(MemoryAgent.deepSizeOf(closeSet)
                + MemoryAgent.deepSizeOf(openSet) + MemoryAgent.deepSizeOf(heuristic));
        }

        return solution;
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
