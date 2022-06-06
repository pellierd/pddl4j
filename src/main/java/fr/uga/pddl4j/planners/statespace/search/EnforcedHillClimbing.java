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

package fr.uga.pddl4j.planners.statespace.search;

import fr.uga.pddl4j.heuristics.state.StateHeuristic;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.State;
import fr.uga.pddl4j.problem.operator.Action;
import org.openjdk.jol.info.GraphLayout;

import java.util.LinkedList;
import java.util.Objects;

/**
 * This class implements Enforced Hill Climbing search strategy.
 *
 * @author Samuel Aaron Boyd
 * @author E. Hermellin
 * @version 2.0 - 24.01.2018
 */
public final class EnforcedHillClimbing extends AbstractStateSpaceSearch {

    /**
     * Creates a new Enforced Hill Climbing search strategy with default parameters.
     *
     */
    public EnforcedHillClimbing() {
        super();
    }

    /**
     * Creates a new Enforced Hill Climbing search strategy.
     *
     * @param timeout   the time out of the planner.
     * @param heuristic the heuristic to use to solve the planning problem.
     * @param weight    the weight set to the heuristic.
     */
    public EnforcedHillClimbing(int timeout, StateHeuristic.Name heuristic, double weight) {
        super(timeout, heuristic, weight);
    }

    /**
     * The enforced hill climbing algorithm. Solves the planning problem and returns the solution's node.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return the solution node or null.
     */
    public Node search(final Problem codedProblem) {
        Objects.requireNonNull(codedProblem);
        final long begin = System.currentTimeMillis();

        final StateHeuristic heuristic = StateHeuristic.getInstance(this.getHeuristic(), codedProblem);
        final LinkedList<Node> openList = new LinkedList<>();
        final long timeout = this.getTimeout() * 1000;

        State init = new State(codedProblem.getInitialState());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, codedProblem.getGoal()));
        openList.add(root);

        double bestHeuristic = root.getHeuristic();

        Node solution = null;
        boolean deadEndFree = true;

        this.resetNodesStatistics();
        long searchingTime = 0;
        while (!openList.isEmpty() && solution == null && deadEndFree && searchingTime < timeout) {
            final Node currentState = openList.pop();
            final LinkedList<Node> successors = getSuccessors(currentState, codedProblem, heuristic);
            deadEndFree = !successors.isEmpty();

            while (!successors.isEmpty() && solution == null) {
                final Node successor = successors.pop();
                this.setExploredNodes(this.getExploredNodes() + 1);
                final double heuristicSuccessor = successor.getHeuristic();
                if (heuristicSuccessor == 0.0) {
                    solution = successor;
                }
                if (heuristicSuccessor < bestHeuristic) {
                    successors.clear();
                    openList.clear();
                    bestHeuristic = heuristicSuccessor;
                }
                openList.addLast(successor);
            }

            // Take time to compute the searching time
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
    private LinkedList<Node> getSuccessors(Node parent, Problem problem, StateHeuristic heuristic) {
        final LinkedList<Node> successors = new LinkedList<>();

        int index = 0;
        for (Action op : problem.getActions()) {
            // Test if a specified operator is applicable in the current state
            if (op.isApplicable(parent)) {
                final State nextState = new State(parent);
                op.getConditionalEffects().stream().filter(ce -> parent.satisfy(ce.getCondition())).forEach(ce ->
                        // Apply the effect to the successor node
                        nextState.apply(ce.getEffect())
                );
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
}
