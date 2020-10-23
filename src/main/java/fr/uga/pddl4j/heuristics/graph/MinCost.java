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

package fr.uga.pddl4j.heuristics.graph;

import fr.uga.pddl4j.heuristics.AbstractGoalCostHeuristic;
import fr.uga.pddl4j.planners.statespace.search.Node;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.ClosedWorldState;
import fr.uga.pddl4j.problem.GoalDescription;
import fr.uga.pddl4j.problem.Problem;

import java.util.LinkedList;

/**
 *
 *
 * <b>Warning:</b> The Min Cost heuristic is not admissible.
 *
 * @author E. Hermellin
 * @author D. Pellier
 * @version 1.0 - 19.02.2018
 */
public class MinCost extends AbstractGoalCostHeuristic implements PlanningGraphHeuristic {

    /**
     * Creates a new <code>Min Cost</code> heuristic for a specified planning problem.
     *
     * @param problem the coded problem of the specified planning problem.
     * @throws NullPointerException if <code>problem == null</code>.
     */
    public MinCost(final Problem problem) {
        super(problem);
        super.setAdmissible(false);
    }

    /**
     * Return the estimated distance to the goal to reach the specified state. If the return value is
     * <code>Integer.MAX_VALUE</code>, it means that the goal is unreachable from the specified
     * state.
     *
     * @param state the state from which the distance to the goal must be estimated.
     * @param goal  the goal expression.
     * @return the distance to the goal state from the specified state.
     * @throws NullPointerException if <code>state == null &#38;&#38; goal == null</code>.
     */
    @Override
    public int estimate(final ClosedWorldState state, final GoalDescription goal) {
        return (int) estimateCost(new Node(state), goal);
    }

    /**
     * Return the estimated distance to the goal to reach the specified state. If the return value is
     * <code>DOUBLE.MAX_VALUE</code>, it means that the goal is unreachable from the specified
     * state.
     *
     * @param node the state from which the distance to the goal must be estimated.
     * @param goal the goal expression.
     * @return the distance to the goal state from the specified state.
     */
    @Override
    public double estimate(final Node node, final GoalDescription goal) {
        return estimateCost(node, goal);
    }

    /**
     * Return the estimated distance to the goal to reach the specified state. If the return value is
     * <code>Double.MAX_VALUE</code>, it means that the goal is unreachable from the specified
     * state.
     *
     * @param node the node from which the distance to the goal must be estimated.
     * @param goal the goal to reach.
     * @return the distance to the goal state from the specified node.
     */
    public double estimateCost(final Node node, final GoalDescription goal) {
        final LinkedList<Node> openList = new LinkedList<>();

        openList.add(node);
        Node solution = null;

        while (solution == null) {

            final Node current = openList.pop();
            openList.remove(current);

            int index = 0;
            Node nextNode = null;
            double cost = Double.MAX_VALUE;

            for (Action op : getActions()) {
                if (op.isApplicable(current)) {
                    if (op.getCost() <= cost) { //TODO take into account = or not
                        final ClosedWorldState nextState = new ClosedWorldState(current);

                        op.getConditionalEffects().stream().filter(ce -> current.satisfy(ce.getCondition()))
                            .forEach(ce -> nextState.apply(ce.getEffects())
                        );


                        final Node successor = new Node(nextState);
                        successor.setCost(current.getCost() + op.getCost());
                        successor.setParent(current);
                        successor.setAction(index);
                        successor.setDepth(current.getDepth() + 1);

                        cost = op.getCost();
                        nextNode = successor;
                    }
                }
                index++;
            }

            if (nextNode != null) {
                if (nextNode.satisfy(goal)) {
                    solution = nextNode;
                } else {
                    openList.add(nextNode);
                }
            } else {
                return Double.MAX_VALUE;
            }
        }
        return solution.getCost();
    }

}
