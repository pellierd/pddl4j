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
import fr.uga.pddl4j.planners.Configuration;
import fr.uga.pddl4j.planners.Setting;
import fr.uga.pddl4j.problem.HTNProblem;
import fr.uga.pddl4j.problem.State;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Method;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This class implements the code of the total ordered simple task network planner. The search method is an
 * implementation of the total order STN procedure describes in the book of Automated Planning of Ghallab and al.
 * page 239.
 *
 * @author D. Pellier
 * @version 1.0 - 15.04.2020
 * @since 4.0
 */
public final class TFDPlanner extends AbstractSTNPlanner {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(TFDPlanner.class.getName());

    /**
     * Creates a new abstract STN planner with the default configuration.
     *
     * @param configuration the configuration of the planner.
     */
    public TFDPlanner(final Configuration configuration) {
        super(configuration);
    }

    /**
     * Solves the planning problem and returns the first solution search found. The search method is an implementation
     * of the total order STN procedure describes in the book of Automated Planning of Ghallab and al. page 239.
     *
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     */
    @Override
    public Plan solve(final HTNProblem problem) {
        // Create the list of pending nodes to explore
        final PriorityQueue<TFDNode> open = new PriorityQueue<>(1000, new Comparator<TFDNode>() {
            public int compare(TFDNode n1, TFDNode n2) {
                return n1.getTasks().size() - n2.getTasks().size();
            }
        });
        // Create the root node of the search space
        final State init = new State(problem.getInitialState());
        final TFDNode root = new TFDNode(init, problem.getInitialTaskNetwork().getTasks());
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
            //final TFDNode currentNode = open.poll();
            final TFDNode currentNode = open.poll();

            if (debug) {
                System.out.println("=========> Pop a new node <=========\n");
                System.out.println("=> Current state:");
                System.out.println(problem.toString(currentNode.getState()));
                System.out.println("\n=> Tasks to be excuted:");
                System.out.println(currentNode.getTasks());
                for (int i = 0; i < currentNode.getTasks().size(); i++) {
                    System.out.println(problem.toString(problem.getTasks().get(currentNode.getTasks().get(i))));
                }
            }
            // If the task network is empty we've got a solution
            if (currentNode.getTasks().isEmpty()) {
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
                // Get and remove the fist task of the task network
                //System.out.println(currentNode);
                int task = currentNode.popTask();
                // Get the current state of the search
                final State state = currentNode.getState();
                // Get the relevant operators, i.e., action or method that are relevant for this task.
                final List<Integer> relevantOperators = problem.getTaskResolvers().get(task);
                // Case of primitive task
                if (problem.getTasks().get(task).isPrimtive()) {
                    for (Integer operator : relevantOperators) {
                        final Action action = problem.getActions().get(operator);
                        if (debug) {
                            System.out.println("\n======> Try to decompose primitive tasks "
                                + problem.toString(problem.getTasks().get(task)) + " with \n\n"
                                + problem.toString(action));
                        }
                        if (state.satisfy(action.getPrecondition())) {
                            final TFDNode childNode = new TFDNode(currentNode);
                            childNode.setParent(currentNode);
                            childNode.setOperator(operator);
                            childNode.getState().apply(action.getConditionalEffects());
                            childNode.setTask(task);
                            open.add(childNode);
                            if (debug) {
                                System.out.println("=====> Decomposition succeeded push node:");
                                System.out.println(problem.toString(childNode.getState()));
                                for (int t : childNode.getTasks()) {
                                    System.out.println(problem.toString(problem.getTasks().get(t)));
                                }
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
                } else { // Case of the compound task
                    for (Integer operator : relevantOperators) {
                        final Method method = problem.getMethods().get(operator);
                        if (debug) {
                            System.out.println("\n======> Try to decompose compound tasks "
                                + problem.toString(problem.getTasks().get(task)) + " with\n\n"
                                + problem.toString(method));
                        }
                        if (state.satisfy(method.getPrecondition())) {
                            final TFDNode childNode = new TFDNode(currentNode);
                            childNode.setParent(currentNode);
                            childNode.setOperator(problem.getActions().size() + operator);
                            childNode.pushAllTasks(method.getSubTasks());
                            childNode.setTask(task);
                            open.add(childNode);
                            if (debug) {
                                System.out.println("=====> Decomposition succeeded push node:");
                                System.out.println("=====>\n" + problem.toString(childNode.getState()));
                                System.out.println("=====>\n");
                                for (int t : childNode.getTasks()) {
                                    System.out.println(problem.toString(problem.getTasks().get(t)));
                                }
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
        return plan;
    }


    /**
     * Returns the configuration by default of the planner.
     *
     * @return the configuration by default of the planner.
     */
    public static Configuration getDefaultConfiguration() {
        Configuration config = new Configuration();
        config.setPlanner(Setting.Planner.TFD);
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
     * The main method of the <code>TFDPlanner</code> example. The command line syntax is as
     * follow:
     *
     * <pre>
     * usage of TFDPlanner:
     *
     * OPTIONS   DESCRIPTIONS
     *
     * -d <i>str</i>   operator file name
     * -p <i>str</i>   fact file name
     * -t <i>num</i>   specifies the maximum CPU-time in seconds (preset: 300)
     * -h              print this message
     *
     * </pre>
     *
     * <p>
     * Commande line example:
     * <code>java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.htn.stn.tfd.TFDPlanner</code><br>
     * <code>  -d src/test/resources/benchmarks/hddl/ipc2020/rover/domain.hddl</code><br>
     * <code>  -p src/test/resources/benchmarks/hddl/ipc2020/rover/pb01.hddl</code><br>
     * </p>
     *
     * @param args the arguments of the command line.
     */
    public static void main(final String[] args) {
        try {
            final Configuration config = new Configuration(args, TFDPlanner.getDefaultConfiguration());
            final TFDPlanner planner = new TFDPlanner(config);
            planner.solve();
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }
}
