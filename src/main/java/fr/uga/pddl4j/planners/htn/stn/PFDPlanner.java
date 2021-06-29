/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.planners.htn.stn;

import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.Setting;
import fr.uga.pddl4j.problem.HTNProblem;
import fr.uga.pddl4j.problem.State;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Method;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This class implement a simple task network planner enable to deal with partial ordered htn representation. The
 * search method is an implementation of the partial order STN procedure describes in the book of Automated Planning of
 * Ghallab and al. page 243.
 *
 * <pre>
 * Usage of PFDPlanner:
 *
 * OPTIONS   DESCRIPTIONS
 *
 * -o <i>str</i>   the path to the domain
 * -f <i>str</i>   the path to the problem
 * -t <i>num</i>   specifies the maximum CPU-time in seconds (preset: 600)
 * -v <i>level</i> the trace level: ALL, DEBUG, INFO, WARN, ERROR, FATAL, OFF (preset: INFO)
 *
 * </pre>
 *
 * <p>Commande line example:</p>
 * <pre>
 *     java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.htn.stn.PFDPlanner
 *          -o src/test/resources/benchmarks/hddl/ipc2020/rover/domain.hddl
 *          -f src/test/resources/benchmarks/hddl/ipc2020/rover/pb01.hddl
 * </pre>
 *
 * @author D. Pellier
 * @version 1.0 - 15.04.2020
 * @since 4.0
 *
 * @see fr.uga.pddl4j.planners.PlannerConfiguration
 */
public final class PFDPlanner extends AbstractSTNPlanner {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(PFDPlanner.class.getName());

    /**
     * Creates a new partial order STN planner with the default parameters.
     *
     * @param config the configuration of the planner.
     */
    public PFDPlanner(final PlannerConfiguration config) {
        super(config);
    }

    /**
     * Solves the planning problem and returns the first solution search found. The search method is an implementation
     * of the partial order STN procedure describes in the book of Automated Planning of Ghallab and al. page 243.
     *
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     */
    @Override
    public Plan solve(final HTNProblem problem) {
        // Create the list of pending nodes to explore
        final PriorityQueue<PFDNode> open = new PriorityQueue<>(1000, new Comparator<PFDNode>() {
            public int compare(PFDNode n1, PFDNode n2) {
                return n1.getTaskNetwork().getTasks().size() - n2.getTaskNetwork().getTasks().size();
            }
        });
        // Create the root node of the search space
        final State init = new State(problem.getInitialState());
        final PFDNode root = new PFDNode(init, problem.getInitialTaskNetwork());

        // Create the root node of the search space
        //root.getState().getNegative().set(0, problem.getFluents().size());
        //root.getState().getNegative().andNot(root.getState().getPositive());

        // Add the root node to the list of the pending nodes to explore.
        open.add(root);

        // Declare the plan used to store the result of the exploration
        Plan plan = null;

        // Get the timeout for searching
        final int timeout = this.getConfiguration().getTimeout();
        final long start = System.currentTimeMillis();
        long elapsedTime = 0;

        boolean debug = false;

        // Start exploring the search space
        while (!open.isEmpty() && plan == null && elapsedTime < timeout) {
            // Get and remove the first node of the pending list of nodes.
            final PFDNode currentNode = open.poll();

            if (debug) {
                System.out.println("=========> Pop a new node <=========\n");
                System.out.println("=> Current state:");
                System.out.println(problem.toString(currentNode.getState()));
                System.out.println("\n=> Tasks to be executed:");
                System.out.println(problem.toString(currentNode.getTaskNetwork()));

                System.out.println(currentNode.getTaskNetwork().getOrderingConstraints().toBitString());
            }

            // If the task network has no more task, a solution is found
            if (currentNode.getTaskNetwork().isEmpty()) {
                if (currentNode.getState().satisfy(problem.getGoal())) {
                    return super.extractPlan(currentNode, problem);
                }  else {
                    if (LOGGER.isDebugEnabled()) {
                        Plan p = super.extractPlan(currentNode, problem);
                        System.out.println("\nFound plan as follows:\n" + problem.toString(p));
                        System.out.println(" But plan does does not reach the goal:\n");
                        System.out.println(problem.toString(problem.getGoal()) + "\n");
                    }
                }
            } else {
                // Get the list of tasks of the current node with no predecessors
                currentNode.getTaskNetwork().transitiveClosure();
                final List<Integer> tasks = currentNode.getTaskNetwork().getTasksWithNoPredecessors();

                // Get the current state of the search
                final State state = currentNode.getState();
                // For each task with no predecessors
                for (Integer task : tasks) {
                    int taskIndex = currentNode.getTaskNetwork().getTasks().get(task);
                    final List<Integer> relevantOperators = problem.getTaskResolvers().get(taskIndex);
                    // Case of primitive tasks
                    if (problem.getTasks().get(taskIndex).isPrimtive()) {
                        for (Integer operator : relevantOperators) {
                            final Action action = problem.getActions().get(operator);
                            if (debug) {
                                System.out.println("\n======> Try to decompose primitive tasks "
                                    + problem.toString(problem.getTasks().get(taskIndex)) + " with \n\n"
                                    + problem.toString(action));

                                System.out.println("=> Current state:");
                                System.out.println(problem.toString(currentNode.getState()));
                            }
                            if (state.satisfy(action.getPrecondition())) {
                                final PFDNode childNode = new PFDNode(currentNode);
                                childNode.setParent(currentNode);
                                childNode.setOperator(operator);
                                childNode.getState().apply(action.getConditionalEffects());
                                childNode.getTaskNetwork().removeTask(task);
                                childNode.setTask(taskIndex);
                                open.add(childNode);
                                if (debug) {
                                    System.out.println("=====> Decomposition succeeded push node:");
                                    System.out.println(problem.toString(childNode.getState()));
                                    System.out.println(problem.toString(problem.getTasks().get(childNode.getTask())));
                                    for (int t : childNode.getTaskNetwork().getTasks()) {
                                        System.out.println(problem.toString(problem.getTasks().get(t)));
                                    }
                                    System.out.println("=> New state:");
                                    System.out.println(problem.toString(childNode.getState()));
                                }
                            } else {
                                if (debug) {
                                    System.out.println("=====> Decomposition failed");
                                }
                            }
                            if (debug) {
                                try {
                                    System.in.read();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else { // Case of compund tasks
                        for (Integer operator : relevantOperators) {
                            final Method method = problem.getMethods().get(operator);
                            if (debug) {
                                System.out.println("\n======> Try to decompose compound tasks "
                                    + problem.toString(problem.getTasks().get(taskIndex)) + " with\n\n"
                                    + problem.toString(method));
                            }
                            if (state.satisfy(method.getPrecondition())) {
                                final PFDNode childNode = new PFDNode(currentNode);
                                childNode.setParent(currentNode);
                                childNode.setOperator(problem.getActions().size() + operator);
                                childNode.getTaskNetwork().decompose(task, method);
                                childNode.setTask(taskIndex);
                                open.add(childNode);
                                if (debug) {
                                    System.out.println("=====> Decomposition succeeded push node:");
                                    System.out.println(problem.toString(childNode.getTaskNetwork()));
                                    System.out.println(problem.toString(problem.getTasks().get(childNode.getTask())));
                                }
                            } else {
                                if (debug) {
                                    System.out.println("=====> Decomposition failed");
                                }
                            }
                            if (debug) {
                                try {
                                    System.in.read();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                elapsedTime = System.currentTimeMillis() - start;
            }
        }
        return plan;
    }

    /**
     * Returns the configuration by default of the planner.
     *
     * @return the configuration by default of the planner.
     */
    public static PlannerConfiguration getDefaultConfiguration() {
        PlannerConfiguration config = new PlannerConfiguration();
        config.setPlanner(Setting.Planner.PFD);
        config.setDomain(Setting.DEFAULT_DOMAIN);
        config.setProblem(Setting.DEFAULT_PROBLEM);
        config.setTimeout(Setting.DEFAULT_TIMEOUT);
        config.setHeuristic(Setting.Heuristic.NONE);
        config.setHeuristicWeight(Setting.DEFAULT_HEURISTIC_WEIGHT);
        config.setSearchStrategy(Setting.SearchStrategy.DEPTH_FIRST);
        config.setTraceLevel(Level.INFO);
        return config;
    }

    /**
     * The main method of the <code>PFDPlanner</code> example. The command line syntax is as
     * follow:
     *
     * <pre>
     * usage of PFDPlanner:
     *
     * OPTIONS   DESCRIPTIONS
     *
     * -o <i>str</i>   the path to the domain
     * -f <i>str</i>   the path to the problem
     * -t <i>num</i>   specifies the maximum CPU-time in seconds (preset: 600)
     * -v <i>level</i> the trace level: ALL, DEBUG, INFO, WARN, ERROR, FATAL, OFF (preset: INFO)
     * </pre>
     *
     * <p>Commande line example:</p>
     * <pre>
     *     java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.htn.stn.PFDPlanner
     *          -o src/test/resources/benchmarks/hddl/ipc2020/rover/domain.hddl
     *          -f src/test/resources/benchmarks/hddl/ipc2020/rover/pb01.hddl
     * </pre>
     *
     * @param args the arguments of the command line.
     */
    public static void main(final String[] args) {
        try {
            final PlannerConfiguration config = new PlannerConfiguration(args, PFDPlanner.getDefaultConfiguration());
            final PFDPlanner planner = new PFDPlanner(config);
            planner.solve();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }  catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
