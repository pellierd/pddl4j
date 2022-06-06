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

import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.State;
import fr.uga.pddl4j.problem.operator.Action;
import org.openjdk.jol.info.GraphLayout;

import java.util.LinkedList;
import java.util.Objects;

/**
 * This class implements Depth First Search strategy.
 *
 * @author E. Hermellin
 * @version 1.0 - 22.06.2018
 */
public final class DepthFirstSearch extends AbstractStateSpaceSearch {

    /**
     * Creates a new Greedy best First Search search strategy with default parameters.
     */
    public DepthFirstSearch() {
        super();
    }

    /**
     * Creates a new Greedy best First Search search strategy.
     *
     * @param timeout the time out of the planner.
     */
    public DepthFirstSearch(int timeout) {
        super(timeout);
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

        final LinkedList<Node> closeSet = new LinkedList<>();
        final LinkedList<Node> openSet = new LinkedList<>();
        final long timeout = this.getTimeout() * 1000;

        State init = new State(codedProblem.getInitialState());
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
            } else {
                closeSet.add(current);
                int index = 0;
                for (Action op : codedProblem.getActions()) {

                    // Test if a specified operator is applicable in the current state
                    if (op.isApplicable(current)) {
                        final State nextState = new State(current);
                        //nextState.or(op.getConditionalEffects().get(0).getEffect().getPositive());
                        //nextState.andNot(op.getConditionalEffects().get(0).getEffect().getNegative());

                        op.getConditionalEffects().stream().filter(ce -> current.satisfy(ce.getCondition()))
                            .forEach(ce -> nextState.apply(ce.getEffect()));

                        // Apply the effect of the applicable operator
                        final Node successor = new Node(nextState);
                        this.setCreatedNodes(this.getCreatedNodes() + 1);
                        successor.setCost(current.getCost() + op.getCost().getValue());
                        successor.setHeuristic(0);
                        successor.setParent(current);
                        successor.setAction(index);
                        successor.setDepth(current.getDepth() + 1);

                        if (!closeSet.contains(successor) && !openSet.contains(successor)) {
                            openSet.addFirst(successor);
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
        this.setMemoryUsed(GraphLayout.parseInstance(closeSet).totalSize()
            + GraphLayout.parseInstance(openSet).totalSize());
        this.setSearchingTime(searchingTime);

        return solution;
    }
}
