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

package fr.uga.pddl4j.planners.htn.tfd;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.Method;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.State;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * This class implements a node for the TFDPlanner planner of the PDDL4J library.
 *
 * @author D. Pellier
 * @version 1.0 - 15.04.2020
 * @since 4.0
 */
public final class TFDPlanner extends AbstractPlanner {

    /*
     * The arguments of the planner.
     */
    private Properties arguments;

    /**
     * Creates a new total order STN planner with the default parameters.
     *
     * @param arguments the arguments of the planner.
     */
    public TFDPlanner(final Properties arguments) {
        super();
        this.arguments = arguments;
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
        final PriorityQueue<TFDNode> open = new PriorityQueue<>();
        // Create the root node of the search space
        final TFDNode root = new TFDNode(problem.getInitialState(), problem.getInitialTaskNetwork().getTasks());
        root.getState().getNegative().set(0, problem.getRelevantFluents().size());
        root.getState().getNegative().andNot(root.getState().getPositive());

        // Add the root node to the list of the pending nodes to explore.
        open.add(root);

        // Declare the plan used to store the result of the exploration
        Plan plan = null;

        // Get the timeout for searching
        final int timeout = (int) arguments.get(Planner.TIMEOUT);
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
                for (int i = 0 ; i< currentNode.getTasks().size(); i++) {

                    System.out.println(problem.toString(problem.getTasks().get(currentNode.getTasks().get(i))));
                }
            }

            // If the task network is empty we've got a solution
            if (currentNode.getTasks().isEmpty()) {
                plan = this.extractPlan(currentNode, problem);
            } else {
                // Get and remove the fist task of the task network
                //System.out.println(currentNode);
                int task = currentNode.popTask();
                // Get the current state of the search
                final State state = currentNode.getState();
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
                //currentNode.setState(null);
                //currentNode.getTasks().clear();
            }
            elapsedTime = System.currentTimeMillis() - start;
        }
        return plan;
    }

    /**
     * Extract a plan from a solution node for the specified planning problem.
     *
     * @param node    the solution node.
     * @param problem the problem to be solved.
     * @return the solution plan or null is no solution was found.
     */
    private SequentialPlan extractPlan(final TFDNode node, final Problem problem) {
        TFDNode n = node;
        final SequentialPlan plan = new SequentialPlan();
        while (n.getParent() != null) {
            if (n.getOperator() < problem.getActions().size()) {
                final Action a = problem.getActions().get(n.getOperator());
                plan.add(0, a);
            }
            n = n.getParent();
        }
        return plan;
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
     * <code>java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.htn.tfd.TFDPlanner</code><br>
     * <code>  -d src/test/resources/benchmarks/rover_total_ordered/domain.hddl</code><br>
     * <code>  -p src/test/resources/benchmarks/rover_total_ordered/pb01.hddl</code><br>
     * </p>
     * @param args the arguments of the command line.
     */
    public static void main(final String[] args) {

        // Parse the commande line and initialize the arguments of the planner.
        final Properties arguments = TFDPlanner.parseCommandLine(args);
        if (arguments == null) {
            TFDPlanner.printUsage();
            System.exit(0);
        }

        // Create an instance of the TFDPlanner Planner
        final TFDPlanner planner = new TFDPlanner(arguments);

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
        factory.setTraceLevel(0);
        long start = System.currentTimeMillis();
        final Problem pb = factory.encode();
        long end = System.currentTimeMillis();
        final double encodingTime = (end - start) / 1000.0;
        System.out.println("\nEncoding problem done successfully ("
                + pb.getActions().size() + " actions, "
                + pb.getMethods().size() + " methods, "
                + pb.getRelevantFluents().size() + " fluents, "
                + pb.getTasks().size() + " tasks)\n");

        try {
            System.out.println("Searching a solution plan....\n");
            start = System.currentTimeMillis();

            final Plan plan = planner.search(pb);
            end = System.currentTimeMillis();
            final double searchTime = (end - start) / 1000.0;
            if (plan != null) {
                // Print plan information
                System.out.println("Found plan as follows:\n" + pb.toString(plan));
                System.out.println(String.format("Plan total cost      : %4.2f", plan.cost()));
                System.out.println(String.format("Encoding time        : %4.3fs", encodingTime));
                System.out.println(String.format("Searching time       : %4.3fs", searchTime));
                System.out.println(String.format("Total time           : %4.3fs%n", searchTime + encodingTime));

            } else {
                System.out.println(String.format(String.format("%nno plan found%n%n")));
                System.out.println(String.format("Encoding time        : %4.3fs", encodingTime));
                System.out.println(String.format("Searching time       : %4.3fs", searchTime));
                System.out.println(String.format("Total time           : %4.3fs%n", searchTime + encodingTime));
            }
        } catch (OutOfMemoryError err) {
            System.out.println("Out of memory !");
            System.exit(0);
        }
    }

    /**
     * Print the usage of the TFDPlanner planner.
     */
    private static void printUsage() {
        final StringBuilder strb = new StringBuilder();
        strb.append("\nusage of TFDPlanner:\n")
                .append("OPTIONS   DESCRIPTIONS\n")
                .append("-d <str>    hddl domain file name\n")
                .append("-p <str>    hddl problem file name\n")
                .append("-l <num>    trace level\n")
                .append("-t <num>    specifies the maximum CPU-time in seconds (preset: 300)\n")
                .append("-h          print this message\n\n");
        Planner.getLogger().trace(strb.toString());
    }

    /**
     * Parse the command line and return the planner's arguments.
     *
     * @param args the command line.
     * @return the planner arguments or null if an invalid argument is encountered.
     */
    private static Properties parseCommandLine(String[] args) {

        // Get the default arguments from the super class
        final Properties arguments = Planner.getDefaultArguments();

        // Parse the command line and update the default argument value
        for (int i = 0; i < args.length; i += 2) {
            if ("-d".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                if (!new File(args[i + 1]).exists()) {
                    return null;
                }
                arguments.put(Planner.DOMAIN, new File(args[i + 1]));
            } else if ("-p".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                if (!new File(args[i + 1]).exists()) {
                    return null;
                }
                arguments.put(Planner.PROBLEM, new File(args[i + 1]));
            } else if ("-t".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                final int timeout = Integer.parseInt(args[i + 1]) * 1000;
                if (timeout < 0) {
                    return null;
                }
                arguments.put(Planner.TIMEOUT, timeout);
            } else if ("-l".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                final int level = Integer.parseInt(args[i + 1]);
                arguments.put(Planner.TRACE_LEVEL, level);
            } else {
                return null;
            }
        }
        // Return null if the domain or the problem was not specified
        return (arguments.get(Planner.DOMAIN) == null
                || arguments.get(Planner.PROBLEM) == null) ? null : arguments;
    }
}
