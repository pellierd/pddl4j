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

package fr.uga.pddl4j.planners.htn.stn.tfd;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.htn.stn.AbstractSTNPlanner;
import fr.uga.pddl4j.planners.htn.stn.YetAOtherHDDLCertificate;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.ClosedWorldState;
import fr.uga.pddl4j.problem.Method;
import fr.uga.pddl4j.problem.Problem;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Properties;

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
     * Creates a new abstract STN planner with the default parameters.
     *
     * @param arguments the arguments of the planner.
     */
    public TFDPlanner(final Properties arguments) {
        super(arguments);
    }

    /**
     * Solves the planning problem and returns the first solution search found. The search method is an implementation
     * of the total order STN procedure describes in the book of Automated Planning of Ghallab and al. page 239.
     *
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     */
    @Override
    public Plan search(final Problem problem) {
        // Create the list of pending nodes to explore
        final PriorityQueue<TFDNode> open = new PriorityQueue<>(1000, new Comparator<TFDNode>() {
            public int compare(TFDNode n1, TFDNode n2) {
                return n1.getTasks().size() - n2.getTasks().size();
            }
        });
        // Create the root node of the search space
        final ClosedWorldState init = new ClosedWorldState(problem.getInitialState());
        final TFDNode root = new TFDNode(init, problem.getInitialTaskNetwork().getTasks());
        //root.getState().getNegative().set(0, problem.getRelevantFluents().size());
        //root.getState().getNegative().andNot(root.getState().getPositive());

        // Add the root node to the list of the pending nodes to explore.
        open.add(root);

        // Declare the plan used to store the result of the exploration
        Plan plan = null;

        // Get the timeout for searching
        final int timeout = (int) super.getArguments().get(Planner.TIMEOUT);
        final long start = System.currentTimeMillis();
        long elapsedTime = 0;

        boolean debug = false;

        // Start exploring the search space
        while (!open.isEmpty() && plan == null && elapsedTime < timeout) {
            // Get and remove the first node of the pending list of nodes.
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
                plan = this.extractPlan(currentNode, problem);
                System.out.println(super.createHdDDLCertificate(currentNode, problem));
                new YetAOtherHDDLCertificate(currentNode, problem);
            } else {
                // Get and remove the fist task of the task network
                //System.out.println(currentNode);
                int task = currentNode.popTask();
                // Get the current state of the search
                final ClosedWorldState state = currentNode.getState();
                // Get the relevant operators, i.e., action or method that are relevant for this task.
                final List<Integer> relevantOperators = problem.getRelevantOperators().get(task);
                // Case of primitive task
                if (problem.getTasks().get(task).isPrimtive()) {
                    for (Integer operator : relevantOperators) {
                        final Action action = problem.getActions().get(operator);
                        if (debug) {
                            System.out.println("\n======> Try to decompose primitive tasks "
                                + problem.toString(problem.getTasks().get(task)) + " with \n\n"
                                + problem.toString(action));
                        }
                        if (state.satisfy(action.getPreconditions())) {
                            final TFDNode childNode = new TFDNode(currentNode);
                            childNode.setParent(currentNode);
                            childNode.setOperator(operator);
                            childNode.getState().apply(action.getCondEffects());
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
                        if (state.satisfy(method.getPreconditions())) {
                            final TFDNode childNode = new TFDNode(currentNode);
                            childNode.setParent(currentNode);
                            childNode.setOperator(problem.getActions().size() + operator);
                            childNode.pushAllTasks(method.getSubTasks());
                            childNode.setTask(task);
                            open.add(childNode);
                            if (debug) {
                                System.out.println("=====> Decomposition succeeded push node:");
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
     * The main method of the <code>TFDPlanner</code> example. The command line syntax is as
     * follow:
     * <p>
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
     * </p>
     * <p>
     * Commande line example:
     * <code>java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.htn.stn.tfd.TFDPlanner</code><br>
     * <code>  -d src/test/resources/benchmarks/rover_total_ordered/domain.hddl</code><br>
     * <code>  -p src/test/resources/benchmarks/rover_total_ordered/pb01.hddl</code><br>
     * </p>
     *
     * @param args the arguments of the command line.
     */
    public static void main(final String[] args) {

        // Parse the commande line and initialize the arguments of the planner.
        final Properties arguments = AbstractSTNPlanner.parseCommandLine(args);
        if (arguments == null) {
            AbstractSTNPlanner.printUsage();
            System.exit(0);
        }

        // Create an instance of the problem factory to parse and encode the domain and problem file
        final ProblemFactory factory = ProblemFactory.getInstance();

        // Get the domain file and problem file and parse the hddl files.
        File domain = (File) arguments.get(Planner.DOMAIN);
        File problem = (File) arguments.get(Planner.PROBLEM);
        ErrorManager errorManager = null;
        try {
            errorManager = factory.parse(domain, problem);
        } catch (IOException e) {
            System.out.println("\nunexpected error when parsing the PDDL planning problem description.");
            System.exit(0);
        }

        // Print the syntax errors if detected
        if (!errorManager.isEmpty()) {
            errorManager.printAll();
            System.exit(0);
        }

        System.out.println("\nParsing domain (" + domain.getName()
            + ") and problem (" + problem.getName() + ") done successfully");

        // Encode the problem into compact representation
        final int traceLevel = (Integer) arguments.get(Planner.TRACE_LEVEL);
        factory.setTraceLevel(traceLevel - 1);
        long start = System.currentTimeMillis();
        final Problem pb = factory.encode();
        long end = System.currentTimeMillis();
        final double encodingTime = (end - start) / 1000.0;
        System.out.println("\nEncoding problem done successfully ("
            + pb.getActions().size() + " actions, "
            + pb.getMethods().size() + " methods, "
            + pb.getRelevantFluents().size() + " fluents, "
            + pb.getTasks().size() + " tasks)\n");

        if (pb.isSolvable()) {
            try {
                System.out.println("Searching a solution plan....\n");
                start = System.currentTimeMillis();
                // Create an instance of the TFDPlanner Planner
                final AbstractSTNPlanner planner = new TFDPlanner(arguments);
                final Plan plan = planner.search(pb);
                end = System.currentTimeMillis();
                final double searchTime = (end - start) / 1000.0;
                if (plan != null) {
                    // Print plan information
                    System.out.println("\nFound plan as follows:\n" + pb.toString(plan));
                    System.out.println(String.format("Plan total cost      : %4.2f", plan.cost()));
                    System.out.println(String.format("Encoding time        : %4.3fs", encodingTime));
                    System.out.println(String.format("Searching time       : %4.3fs", searchTime));
                    System.out.println(String.format("Total time           : %4.3fs%n", searchTime + encodingTime));

                } else {
                    System.out.println(String.format(String.format("\n%nno plan found%n%n")));
                    System.out.println(String.format("Encoding time        : %4.3fs", encodingTime));
                    System.out.println(String.format("Searching time       : %4.3fs", searchTime));
                    System.out.println(String.format("Total time           : %4.3fs%n", searchTime + encodingTime));
                }
            } catch (OutOfMemoryError err) {
                System.out.println("Out of memory !");
                System.exit(0);
            }
        } else {
            System.out.println(String.format(String.format("\n%nproblem with no solution plan found%n%n")));
            System.out.println(String.format("Encoding time        : %4.3fs", encodingTime));
            System.out.println(String.format("Searching time       : %4.3fs", 0.0));
            System.out.println(String.format("Total time           : %4.3fs%n", encodingTime));
        }
    }
}
