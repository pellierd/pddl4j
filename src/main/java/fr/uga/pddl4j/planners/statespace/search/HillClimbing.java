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
import fr.uga.pddl4j.problem.ADLProblem;
import fr.uga.pddl4j.problem.State;
import fr.uga.pddl4j.problem.operator.Action;
import org.openjdk.jol.info.GraphLayout;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * This class implements Hill Climnbing search strategy.
 *
 * @author E. Hermellin
 * @version 1.0 - 01.06.2018
 */
public final class HillClimbing extends AbstractStateSpaceSearch {

    /**
     * Creates a new Hill Climbing search with default parameters.
     *
     */
    public HillClimbing() {
        super();
    }

    /**
     * Creates a new Hill Climbing search strategy.
     *
     * @param timeout   the time out of the planner.
     * @param heuristic the heuristic to use to solve the planning problem.
     * @param weight    the weight set to the heuristic.
     */
    public HillClimbing(int timeout, StateHeuristic.Name heuristic, double weight) {
        super(timeout, heuristic, weight);
    }

    /**
     * The hill climbing algorithm. Solves the planning problem and returns the solution's node.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return the solution node.
     */
    public Node search(final ADLProblem codedProblem) {
        Objects.requireNonNull(codedProblem);
        final LinkedList<Node> openList = new LinkedList<>();
        final StateHeuristic heuristic = StateHeuristic.getInstance(this.getHeuristic(), codedProblem);

        State init = new State(codedProblem.getInitialState());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, codedProblem.getGoal()));
        openList.add(root);

        Node solution = null;
        boolean deadEndFree = true;

        this.resetNodesStatistics();
        final long timeout = this.getTimeout() * 1000;
        final long begin = System.currentTimeMillis();
        long searchingTime = 0;
        while (!openList.isEmpty() && solution == null
            && deadEndFree && searchingTime < timeout) {

            final Node currentState = openList.pop();
            final LinkedList<Node> successors = getSuccessors(currentState, codedProblem, heuristic);
            deadEndFree = !successors.isEmpty();

            if (deadEndFree) {
                final Node successor = popBestNode(successors);
                this.setExploredNodes(this.getExploredNodes() + 1);
                if (successor.satisfy(codedProblem.getGoal())) {
                    solution = successor;
                } else {
                    successors.clear();
                    openList.clear();
                    openList.addLast(successor);
                }
            }

            long end = System.currentTimeMillis();
            searchingTime = end - begin;
        }

        this.setMemoryUsed(GraphLayout.parseInstance(openList).totalSize());
        this.setSearchingTime(searchingTime);

        return solution;
    }

    /**
     * Get the successors from a node.
     *
     * @param parent    the parent node.
     * @param problem   the coded problem to solve.
     * @param heuristic the heuristic used.
     * @return the list of successors from the parent node.
     */
    private LinkedList<Node> getSuccessors(final Node parent, final ADLProblem problem,
                                           final StateHeuristic heuristic) {
        final LinkedList<Node> successors = new LinkedList<>();

        int index = 0;
        for (Action op : problem.getActions()) {
            if (op.isApplicable(parent)) {
                final State nextState = new State(parent);
                op.getConditionalEffects().stream().filter(ce -> parent.satisfy(ce.getCondition()))
                    .forEach(ce -> nextState.apply(ce.getEffect()));
                // Apply the effect of the applicable operator
                final Node successor = new Node(nextState);
                this.setCreatedNodes(this.getCreatedNodes() + 1);
                successor.setCost(parent.getCost() + op.getCost().getValue());
                successor.setHeuristic(heuristic.estimate(nextState, problem.getGoal()));
                successor.setParent(parent);
                successor.setAction(index);
                successor.setDepth(parent.getDepth() + 1);
                successors.add(successor);
            }
            index++;
        }

        return successors;
    }

    /**
     * Return the best node from a list according to the heuristic value.
     *
     * @param nodes the list containing nodes.
     * @return the best node from the nodes' list.
     */
    private Node popBestNode(Collection<Node> nodes) {
        Node node = null;
        if (!nodes.isEmpty()) {
            final Iterator<Node> i = nodes.iterator();
            node = i.next();
            while (i.hasNext()) {
                final Node next = i.next();
                if (next.getHeuristic() < node.getHeuristic()) {
                    node = next;
                }
            }
            nodes.remove(node);
        }
        return node;
    }
}
