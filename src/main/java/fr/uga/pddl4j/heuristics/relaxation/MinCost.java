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

package fr.uga.pddl4j.heuristics.relaxation;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.util.BitExp;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;

import java.util.LinkedList;

/**
 * <b>Warning:</b> The Min Cost heuristic is not admissible.
 *
 * @author E. Hermellin
 * @version 1.0 - 19.02.2018
 */
public class MinCost extends AbstractHeuristic {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new <code>Min Cost</code> heuristic for a specified planning problem.
     *
     * @param problem the coded problem of the specified planning problem.
     * @throws NullPointerException if <code>problem == null</code>.
     */
    public MinCost(final CodedProblem problem) {
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
    public int estimate(final BitState state, final BitExp goal) {
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
    public double estimate(final Node node, final BitExp goal) {
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
    public double estimateCost(final Node node, final BitExp goal) {
        final LinkedList<Node> openList = new LinkedList<>();

        openList.add(node);
        Node solution = null;

        while (solution == null) {

            final Node current = openList.pop();
            openList.remove(current);

            int index = 0;
            Node nextNode = null;
            double cost = Double.MAX_VALUE;

            for (BitOp op : getOperators()) {
                if (op.isApplicable(current)) {
                    if (op.getCost() <= cost) { //TODO take into account = or not
                        final BitState nextState = new BitState(current);
                        nextState.or(op.getCondEffects().get(0).getEffects().getPositive());
                        nextState.andNot(op.getCondEffects().get(0).getEffects().getNegative());

                        final Node successor = new Node(nextState);
                        successor.setCost(current.getCost() + op.getCost());
                        successor.setParent(current);
                        successor.setOperator(index);
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
