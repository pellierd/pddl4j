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
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.MemoryAgent;
import fr.uga.pddl4j.util.SolutionEvent;

import java.util.LinkedList;
import java.util.Objects;

/**
 * This class implements Breadth First Search strategy.
 *
 * @author E. Hermellin
 * @version 1.0 - 22.06.2018
 */
public final class BreadthFirstSearch extends AbstractStateSpaceStrategy {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new Greedy best First Search search strategy with default parameters.
     */
    public BreadthFirstSearch() {
        super();
    }

    /**
     * Creates a new Greedy best First Search search strategy.
     *
     * @param timeout the time out of the planner.
     */
    public BreadthFirstSearch(int timeout) {
        super(timeout);
    }

    /**
     * The greedy best first search algorithm. Solves the planning problem and returns the first solution plan found.
     * This method must be completed.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return a solution plan or null if it does not exist.
     */
    public Node search(final CodedProblem codedProblem) {
        Objects.requireNonNull(codedProblem);
        final long begin = System.currentTimeMillis();

        final LinkedList<Node> closeSet = new LinkedList<>();
        final LinkedList<Node> openSet = new LinkedList<>();
        final int timeout = getTimeout();

        BitState init = new BitState(codedProblem.getInit());
        Node root = new Node(init, null, 0, 0, 0);
        root.setDepth(0);
        openSet.add(root);

        this.resetNodesStatistics();
        Node solution = null;
        long searchingTime = 0;
        while (!openSet.isEmpty() && solution == null && searchingTime < timeout) {
            // Pop the first node in the pending list open
            final Node current = openSet.pollFirst();

            if (current.satisfy(codedProblem.getGoal())) {
                solution = current;
                fireSolution(new SolutionEvent(this, solution, codedProblem));
            } else {
                closeSet.add(current);
                int index = 0;
                for (BitOp op : codedProblem.getOperators()) {

                    // Test if a specified operator is applicable in the current state
                    if (op.isApplicable(current)) {
                        final BitState nextState = new BitState(current);
                        nextState.or(op.getCondEffects().get(0).getEffects().getPositive());
                        nextState.andNot(op.getCondEffects().get(0).getEffects().getNegative());

                        // Apply the effect of the applicable operator
                        final Node successor = new Node(nextState);
                        this.setCreatedNodes(this.getCreatedNodes() + 1);
                        successor.setCost(current.getCost() + op.getCost());
                        successor.setHeuristic(0);
                        successor.setParent(current);
                        successor.setOperator(index);
                        successor.setDepth(current.getDepth() + 1);

                        if (!closeSet.contains(successor) && !openSet.contains(successor)) {
                            openSet.addLast(successor);
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
        this.setMemoryUsed(MemoryAgent.getDeepSizeOf(closeSet) + MemoryAgent.getDeepSizeOf(openSet));
        this.setSearchingTime(searchingTime);

        return solution;
    }
}
