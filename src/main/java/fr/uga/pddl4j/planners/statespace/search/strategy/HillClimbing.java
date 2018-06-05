package fr.uga.pddl4j.planners.statespace.search.strategy;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.heuristics.relaxation.HeuristicToolKit;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.statespace.AbstractStateBasedPlanner;
import fr.uga.pddl4j.planners.statespace.PlannerFactory;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.MemoryAgent;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class HillClimbing {

    /**
     * Creates a new planner.
     */
    private HillClimbing() {
    }

    /**
     * Search a solution node to a specified domain and problem.
     *
     * @param planner the planner used to solve the problem
     * @param pb      the problem to solve.
     * @return the solution node.
     */
    public static Node searchSolutionNode(final AbstractStateBasedPlanner planner, final CodedProblem pb) {
        Objects.requireNonNull(pb);
        return HillClimbing.hillClimbing(planner, pb);
    }

    /**
     * The hill climbing algorithm. Solves the planning problem and returns the solution's node.
     *
     * @param planner the planner used to solve the problem
     * @param pb      the problem to solve.
     * @return the solution node.
     */
    private static Node hillClimbing(final AbstractStateBasedPlanner planner, final CodedProblem pb) {
        final LinkedList<Node> openList = new LinkedList<>();
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(planner.getHeuristicType(), pb);
        long searchingTime = 0;
        double bestHeuristic = Integer.MAX_VALUE;

        BitState init = new BitState(pb.getInit());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, pb.getGoal()));
        openList.add(root);

        Node solution = null;
        boolean deadEndFree = true;

        final int timeout = planner.getTimeout();
        final long begin = System.currentTimeMillis();
        while (!openList.isEmpty() && solution == null
            && deadEndFree && searchingTime < timeout) {

            final Node currentState = openList.pop();
            final LinkedList<Node> successors = HillClimbing.getSuccessors(currentState, pb, heuristic);
            deadEndFree = !successors.isEmpty();

            final Node successor = HillClimbing.popBestNode(successors, bestHeuristic);
            if (successor.satisfy(pb.getGoal())) {
                solution = successor;
            } else {
                successors.clear();
                openList.clear();
                openList.addLast(successor);
                if (successor.getHeuristic() <= bestHeuristic) {
                    bestHeuristic = successor.getHeuristic();
                }
            }

            long end = System.currentTimeMillis();
            searchingTime = end - begin;
        }

        if (planner.isSaveState()) {
            // Compute the searching time
            planner.getStatistics().setTimeToSearch(searchingTime);
            if (PlannerFactory.isMemoryAgent()) {
                // Compute the memory used by the search
                try {
                    planner.getStatistics().setMemoryUsedToSearch(MemoryAgent.deepSizeOf(openList)
                        + MemoryAgent.deepSizeOf(heuristic));
                } catch (IllegalStateException ilException) {
                    AbstractPlanner.getLogger().error(ilException);
                }
            }
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
    private static LinkedList<Node> getSuccessors(final Node parent, final CodedProblem problem,
                                                  final Heuristic heuristic) {
        final LinkedList<Node> successors = new LinkedList<>();

        int index = 0;
        for (BitOp op : problem.getOperators()) {
            if (op.isApplicable(parent)) {
                final BitState nextState = new BitState(parent);
                nextState.or(op.getCondEffects().get(0).getEffects().getPositive());
                nextState.andNot(op.getCondEffects().get(0).getEffects().getNegative());

                // Apply the effect of the applicable operator
                final Node successor = new Node(nextState);
                successor.setCost(parent.getCost() + op.getCost());
                successor.setHeuristic(heuristic.estimate(nextState, problem.getGoal()));
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
    private static Node popBestNode(final Collection<Node> nodes, final double bestHeuristic) {
        Node node = null;
        if (!nodes.isEmpty()) {
            final Iterator<Node> i = nodes.iterator();
            node = i.next();
            while (i.hasNext()) {
                final Node next = i.next();
                if (next.getHeuristic() < bestHeuristic) {
                    node = next;
                }
            }
            nodes.remove(node);
        }
        return node;
    }
}
