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
import fr.uga.pddl4j.util.SolutionEvent;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * This class implements Hill Climnbing search strategy.
 *
 * @author D. Pellier
 * @version 1.0 - 01.06.2018
 */
public final class HillClimbingAnytime extends AbstractStateSpaceStrategyAnytime {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The list containing the nodes on which it is interesting to restart hill climbing.
     */
    private LinkedList<Node> restartList;

    /**
     * The list containing the nodes of hill climbing search.
     */
    private final LinkedList<Node> openList;

    /**
     * Creates a new Hill Climbing anytime search strategy with default parameters.
     */
    public HillClimbingAnytime() {
        super();
        restartList = new LinkedList<>();
        openList = new LinkedList<>();
    }

    /**
     * Creates a new Hill Climbing anytime search strategy.
     *
     * @param timeout   the time out of the planner.
     * @param heuristic the heuristicType to use to solve the planning problem.
     * @param weight    the weight set to the heuristic.
     */
    public HillClimbingAnytime(int timeout, Heuristic.Type heuristic, double weight) {
        super(timeout, heuristic, weight);
        restartList = new LinkedList<>();
        openList = new LinkedList<>();
    }

    /**
     * The hill climbing anytime algorithm. Solves the planning problem and returns the solution's node.
     *
     * @param problem the problem to be solved. The problem cannot be null.
     * @return the solution node.
     */
    public Node search(final CodedProblem problem) {
        final Logger logger = Planner.getLogger();
        Objects.requireNonNull(problem);

        final Heuristic heuristic = HeuristicToolKit.createHeuristic(this.getHeuristicType(), problem);

        BitState init = new BitState(problem.getInit());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, problem.getGoal()));
        root.setHeuristic(heuristic.estimate(root, problem.getGoal()));
        restartList.add(root);
        Node solution = null;

        double bound = Double.MAX_VALUE;
        final int timeout = this.getTimeout();
        long searchingTime = 0;
        while (!restartList.isEmpty() && searchingTime < timeout) {
            final Node node = restartList.getFirst();
            restartList.remove(node);

            final long begin = System.currentTimeMillis();
            final Node returnedSolution = hillClimbingAnytime(problem, node, heuristic, searchingTime);
            final long end = System.currentTimeMillis();

            searchingTime += (end - begin);

            if (returnedSolution != null && returnedSolution.getCost() < bound) {
                this.getSolutionNodes().add(new Node(returnedSolution, returnedSolution.getParent(), 0,
                    returnedSolution.getCost(), returnedSolution.getDepth(), returnedSolution.getHeuristic()));
                bound = returnedSolution.getCost();
                solution = returnedSolution;
                fireSolution(new SolutionEvent(this, solution, problem));
                logger.trace("* " + this.getSolutionNodes().size() + " solution(s) found. Best cost: " + bound + "\n");
            }
        }

        this.setPendingNodes(restartList.size());
        this.setMemoryUsed(MemoryAgent.getDeepSizeOf(openList) + MemoryAgent.getDeepSizeOf(heuristic)
            + MemoryAgent.getDeepSizeOf(restartList));
        this.setSearchingTime(searchingTime);

        return solution;
    }

    /**
     * The hill climbing algorithm. Solves the planning problem and returns the solution's node.
     *
     * @param problem   the coded problem to solve.
     * @param node      the root node for the hill climbing.
     * @param heuristic the heuristic used in hill climbing.
     * @return the solution node or null.
     */
    private Node hillClimbingAnytime(CodedProblem problem, Node node, Heuristic heuristic, long searchingTime) {
        openList.clear();

        Node root = node;
        if (node == null) {
            BitState init = new BitState(problem.getInit());
            root = new Node(init, null, 0, 0, heuristic.estimate(init, problem.getGoal()));
            root.setHeuristic(heuristic.estimate(root, problem.getGoal()));
            openList.add(root);
        } else {
            openList.add(root);
        }

        Node solution = null;
        boolean deadEndFree = true;

        final int timeout = this.getTimeout();
        final long begin = System.currentTimeMillis();
        long hillClimbingSearchingTime = 0;
        while (!openList.isEmpty() && solution == null
            && deadEndFree && (hillClimbingSearchingTime + searchingTime) < timeout) {

            final Node currentState = openList.pop();
            final LinkedList<Node> successors = this.getSuccessors(currentState, problem, heuristic);
            deadEndFree = !successors.isEmpty();

            if (deadEndFree) {
                final Node successor = popBestNode(successors);
                this.setExploredNodes(this.getExploredNodes() + 1);
                if (successor.satisfy(problem.getGoal())) {
                    solution = successor;
                    fireSolution(new SolutionEvent(this, solution, problem));
                } else {
                    successors.clear();
                    openList.clear();
                    openList.addLast(successor);
                }
            }

            long end = System.currentTimeMillis();
            hillClimbingSearchingTime = end - begin;
        }
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
    private LinkedList<Node> getSuccessors(Node parent, CodedProblem problem, Heuristic heuristic) {
        final LinkedList<Node> successors = new LinkedList<>();

        int index = 0;
        for (BitOp op : problem.getOperators()) {
            if (op.isApplicable(parent)) {
                final BitState nextState = new BitState(parent);
                nextState.or(op.getCondEffects().get(0).getEffects().getPositive());
                nextState.andNot(op.getCondEffects().get(0).getEffects().getNegative());

                // Apply the effect of the applicable operator
                final Node successor = new Node(nextState);
                this.setCreatedNodes(this.getCreatedNodes() + 1);
                successor.setCost(parent.getCost() + op.getCost());
                successor.setHeuristic(heuristic.estimate(successor, problem.getGoal()));
                successor.setParent(parent);
                successor.setOperator(index);
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
                } else if (Math.abs(next.getHeuristic() - node.getHeuristic()) < .001 && !restartList.contains(next)) {
                    restartList.addLast(next);
                }
            }
            nodes.remove(node);
        }
        return node;
    }
}
