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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class AStar {

    /**
     * Creates a new planner.
     */
    private AStar() {
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
        return AStar.astar(planner, pb);
    }

    /**
     * Solves the planning problem and returns the first solution search found.
     *
     * @param planner the planner used to solve the problem
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     */
    private static Node astar(final AbstractStateBasedPlanner planner, final CodedProblem problem) {
        Objects.requireNonNull(problem);
        final long begin = System.currentTimeMillis();
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(planner.getHeuristicType(), problem);
        // Get the initial state from the planning problem
        final BitState init = new BitState(problem.getInit());
        // Initialize the closed list of nodes (store the nodes explored)
        final Map<BitState, Node> closeSet = new HashMap<>();
        final Map<BitState, Node> openSet = new HashMap<>();
        // Initialize the opened list (store the pending node)
        final double currWeight = planner.getWeight();
        // The list stores the node ordered according to the A* (getFValue = g + h) function
        final PriorityQueue<Node> open = new PriorityQueue<>(100, new NodeComparator(currWeight));
        // Creates the root node of the tree search
        final Node root = new Node(init, null, -1, 0, heuristic.estimate(init, problem.getGoal()));
        // Adds the root to the list of pending nodes
        open.add(root);
        openSet.put(init, root);
        Node solutionNode = null;

        final int timeout = planner.getTimeout();
        long time = 0;
        // Start of the search
        while (!open.isEmpty() && solutionNode == null && time < timeout) {
            // Pop the first node in the pending list open
            final Node current = open.poll();
            openSet.remove(current);
            closeSet.put(current, current);
            // If the goal is satisfy in the current node then extract the search and return it
            if (current.satisfy(problem.getGoal())) {
                solutionNode = current;
            } else {
                // Try to apply the operators of the problem to this node
                int index = 0;
                for (BitOp op : problem.getOperators()) {
                    // Test if a specified operator is applicable in the current state
                    if (op.isApplicable(current)) {
                        Node state = new Node(current);
                        // Apply the effect of the applicable operator
                        // Test if the condition of the effect is satisfied in the current state
                        // Apply the effect to the successor node
                        op.getCondEffects().stream().filter(ce -> current.satisfy(ce.getCondition())).forEach(ce ->
                            // Apply the effect to the successor node
                            state.apply(ce.getEffects())
                        );
                        final double g = current.getCost() + 1;
                        Node result = openSet.get(state);
                        if (result == null) {
                            result = closeSet.get(state);
                            if (result != null) {
                                if (g < result.getCost()) {
                                    result.setCost(g);
                                    result.setParent(current);
                                    result.setOperator(index);
                                    open.add(result);
                                    openSet.put(result, result);
                                    closeSet.remove(result);
                                }
                            } else {
                                state.setCost(g);
                                state.setParent(current);
                                state.setOperator(index);
                                state.setHeuristic(heuristic.estimate(state, problem.getGoal()));
                                open.add(state);
                                openSet.put(state, state);
                            }
                        } else if (g < result.getCost()) {
                            result.setCost(g);
                            result.setParent(current);
                            result.setOperator(index);
                        }

                    }
                    index++;
                }
            }
            // Compute the searching time
            time = System.currentTimeMillis() - begin;
        }

        if (planner.isSaveState()) {
            planner.getStatistics().setTimeToSearch(time);
            if (PlannerFactory.isMemoryAgent()) {
                // Compute the memory used by the search
                try {
                    planner.getStatistics().setMemoryUsedToSearch(MemoryAgent.deepSizeOf(closeSet)
                        + MemoryAgent.deepSizeOf(openSet));
                } catch (IllegalStateException ilException) {
                    AbstractPlanner.getLogger().error(ilException);
                }
            }
        }
        // return the search computed or null if no search was found
        return solutionNode;
    }
}
