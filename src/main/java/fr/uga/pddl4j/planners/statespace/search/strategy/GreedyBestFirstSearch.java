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

import fr.uga.pddl4j.heuristics.relaxation.RelaxationHeuristic;
import fr.uga.pddl4j.heuristics.relaxation.RelaxationHeuristicToolKit;
import fr.uga.pddl4j.planners.SolutionEvent;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.ClosedWorldState;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.util.MemoryAgent;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * This class implements Greedy Best First Search strategy.
 *
 * @author E. Hermellin
 * @version 1.0 - 01.06.2018
 */
public final class GreedyBestFirstSearch extends AbstractStateSpaceStrategy {

    /**
     * Creates a new Greedy best First Search search strategy with default parameters.
     *
     */
    public GreedyBestFirstSearch() {
        super();
    }

    /**
     * Creates a new Greedy best First Search search strategy.
     *
     * @param timeout   the time out of the planner.
     * @param heuristic the heuristicType to use to solve the planning problem.
     * @param weight    the weight set to the heuristic.
     */
    public GreedyBestFirstSearch(int timeout, RelaxationHeuristic.Type heuristic, double weight) {
        super(timeout, heuristic, weight);
    }

    /**
     * The greedy best first search algorithm. Solves the planning problem and returns the first solution plan found.
     * This method must be completed.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return a solution plan or null if it does not exist.
     */
    public Node search(final Problem codedProblem) {
        Objects.requireNonNull(codedProblem);
        final long begin = System.currentTimeMillis();

        final RelaxationHeuristic heuristic = RelaxationHeuristicToolKit.createHeuristic(
            getHeuristicType(), codedProblem);
        final Set<Node> closeSet = new HashSet<>();
        final Set<Node> openSet = new HashSet<>();
        final int timeout = getTimeout();

        ClosedWorldState init = new ClosedWorldState(codedProblem.getInitialState());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, codedProblem.getGoal()));
        root.setDepth(0);
        openSet.add(root);

        this.resetNodesStatistics();
        Node solution = null;
        long searchingTime = 0;
        while (!openSet.isEmpty() && solution == null && searchingTime < timeout) {
            // Pop the first node in the pending list open
            final Node current = popPriorityNode(openSet);

            if (current.satisfy(codedProblem.getGoal())) {
                solution = current;
                fireSolution(new SolutionEvent(this, solution, codedProblem));
            } else {
                closeSet.add(current);
                int index = 0;
                for (Action op : codedProblem.getActions()) {

                    // Test if a specified operator is applicable in the current state
                    if (op.isApplicable(current)) {
                        final ClosedWorldState nextState = new ClosedWorldState(current);

                        op.getCondEffects().stream().filter(ce -> current.satisfy(ce.getCondition())).forEach(ce ->
                                // Apply the effect to the successor node
                                nextState.apply(ce.getEffects())
                        );

                        // Apply the effect of the applicable operator
                        final Node successor = new Node(nextState);
                        this.setCreatedNodes(this.getCreatedNodes() + 1);
                        successor.setCost(current.getCost() + op.getCost());
                        successor.setHeuristic(heuristic.estimate(nextState, codedProblem.getGoal()));
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

        this.setExploredNodes(closeSet.size());
        this.setPendingNodes(openSet.size());
        this.setMemoryUsed(MemoryAgent.getDeepSizeOf(closeSet) + MemoryAgent.getDeepSizeOf(openSet)
            + MemoryAgent.getDeepSizeOf(heuristic));
        this.setSearchingTime(searchingTime);

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
