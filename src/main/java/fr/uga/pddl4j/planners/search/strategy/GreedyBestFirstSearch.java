package fr.uga.pddl4j.planners.search.strategy;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.heuristics.relaxation.HeuristicToolKit;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerFactory;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.MemoryAgent;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class GreedyBestFirstSearch {

    /**
     * The time needed to search a solution node.
     */
    private static long searchingTime;

    /**
     * Creates a new planner.
     */
    private GreedyBestFirstSearch() {
    }

    /**
     * Search a solution node to a specified domain and problem.
     *
     * @param planner the planner used to solve the problem
     * @param pb      the problem to solve.
     * @return the solution node.
     */
    public static Node searchSolutionNode(final Planner planner, final CodedProblem pb) {
        Objects.requireNonNull(pb);
        searchingTime = 0;
        return GreedyBestFirstSearch.greedyBestFirstSearch(planner, pb);
    }

    /**
     * The greedy best first search algorithm. Solves the planning problem and returns the first solution plan found.
     * This method must be completed.
     *
     * @param planner the planner used to solve the problem
     * @param problem the coded planning problem to solve.
     * @return a solution plan or null if it does not exist.
     */
    private static Node greedyBestFirstSearch(final Planner planner, final CodedProblem problem) {
        final long begin = System.currentTimeMillis();
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(planner.getHeuristicType(), problem);
        final Set<Node> closeSet = new HashSet<>();
        final Set<Node> openSet = new HashSet<>();
        final int timeout = planner.getTimeout();
        Node solution = null;

        BitState init = new BitState(problem.getInit());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, problem.getGoal()));
        root.setDepth(0);
        openSet.add(root);

        while (!openSet.isEmpty() && solution == null && searchingTime < timeout) {
            // Pop the first node in the pending list open
            final Node current = GreedyBestFirstSearch.popPriorityNode(openSet);

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

        if (planner.isSaveState()) {
            // Compute the searching time
            planner.getStatistics().setTimeToSearch(searchingTime);
            if (PlannerFactory.isMemoryAgent()) {
                // Compute the memory used by the search
                planner.getStatistics().setMemoryUsedToSearch(MemoryAgent.deepSizeOf(closeSet)
                    + MemoryAgent.deepSizeOf(openSet) + MemoryAgent.deepSizeOf(heuristic));
            }
        }

        return solution;
    }

    /**
     * Get a node from a list of nodes.
     *
     * @param states the list of nodes (successors).
     * @return the node from the list.
     */
    private static Node popPriorityNode(Collection<Node> states) {
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
