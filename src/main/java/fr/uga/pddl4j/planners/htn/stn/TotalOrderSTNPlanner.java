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

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.Method;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.State;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * This class implements a node for the TotalOrderSTNPlanner planner of the PDDL4J library.
 *
 * @author D. Pellier
 * @version 1.0 - 15.04.2020
 * @since 4.0
 */
final public class TotalOrderSTNPlanner extends AbstractPlanner {

    /*
     * The arguments of the planner.
     */
    private Properties arguments;

    /**
     * Creates a new total order STN planner with the default parameters.
     *
     * @param arguments the arguments of the planner.
     */
    public TotalOrderSTNPlanner(final Properties arguments) {
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

        // No task have to be done in the probmem thus the empty plan is returned as solution.
        if (problem.getInitialTaskNetwork().getTasks().isEmpty()) {
            return new SequentialPlan();
        }

        // Create the list of pending nodes to explore
        LinkedList<STNNode> open = new LinkedList<STNNode>();
        // Create the root node of the search space
        STNNode root = new STNNode(problem.getInitialState(), problem.getInitialTaskNetwork());
        root.setParent(null);
        // Add the root node to the list of the pending nodes to explore.
        open.add(root);

        // Declare the plan used to store the result of the exploration
        Plan plan = null;

        // Start exploring the search space
        while (!open.isEmpty() && plan == null) {
            STNNode currentNode = open.poll();
            //System.out.println("*******************************************************");
            //System.out.println(problem.toString(currentNode.getTaskNetwork()));
            //System.out.println(problem.toString(currentNode.getState()));


            if (currentNode.getTaskNetwork().getTasks().isEmpty()) {
                plan = this.extractPlan(currentNode, problem);
            } else {
                int task = currentNode.getTaskNetwork().getTasks().get(0);
                State state = currentNode.getState();
                List<Integer> resolvers = problem.getTasksResolvers().get(task);
                if (problem.getRelevantTasks().get(task).isPrimtive()) {
                    //System.out.println("PRIMITIVE TASK:");
                    //System.out.println(problem.toString(problem.getRelevantTasks().get(task)));
                    for (Integer resolver : resolvers) {
                        final Action action = problem.getActions().get(resolver);
                        if (state.satisfy(action.getPreconditions())) {
                            //System.out.println("ACTION:");
                            //System.out.println(problem.toString(action));
                            STNNode childNode = new STNNode(currentNode);
                            childNode.setParent(currentNode);
                            childNode.setOperator(resolver);
                            childNode.getTaskNetwork().getTasks().remove(0);
                            action.getCondEffects().stream().filter(ce -> state.satisfy(ce.getCondition())).forEach(ce ->
                                childNode.getState().apply(ce.getEffects())
                            );
                            open.push(childNode);
                            //System.out.println("NEW NODE:");
                            //System.out.println(problem.toString(childNode.getTaskNetwork()));
                            //System.out.println(problem.toString(childNode.getState()));
                            /*try {
                                System.in.read();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }*/
                        }

                    }
                } else {
                    //System.out.println("COMPOUND TASK:");
                    //System.out.println(problem.toString(problem.getRelevantTasks().get(task)));
                    for (Integer resolver : resolvers) {
                        final Method method = problem.getMethods().get(resolver);
                        if (state.satisfy(method.getPreconditions())) {
                            //System.out.println("METHOD:");
                            //System.out.println(problem.toString(method));

                            STNNode childNode = new STNNode(currentNode);
                            childNode.setParent(currentNode);

                            childNode.setOperator(problem.getActions().size()+resolver);
                            childNode.getTaskNetwork().getTasks().remove(0);
                            childNode.getTaskNetwork().getTasks().addAll(0, method.getSubTasks());
                            open.push(childNode);
                            //System.out.println("NEW NODE:");
                            //System.out.println(problem.toString(childNode.getTaskNetwork()));
                            //System.out.println(problem.toString(childNode.getState()));
                            /*try {
                                System.in.read();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }*/
                        }
                    }

                }
            }
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
    private SequentialPlan extractPlan(final STNNode node, final Problem problem) {
        if (node != null) {
            STNNode n = node;
            final SequentialPlan plan = new SequentialPlan();
            while (n.getParent() != null) {
                if (n.getOperator() < problem.getActions().size()) {
                    final Action a = problem.getActions().get(n.getOperator());
                    plan.add(0, a);
                }
                n = n.getParent();
            }
            return plan;
        } else {
            return null;
        }
    }


    /**
     * The main method of the <code>TotalOrderSTNPlanner</code> example. The command line syntax is as
     * follow:
     * <p>
     * <pre>
     * usage of TotalOrderSTNPlanner:
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
     *
     * Commande line example:
     * <code>java -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.TotalOrderSTNPlanner</code><br>
     * <code><span>-d src/test/resources/parser/hddl/HDDL-Total-Ordered/rover/domain.hddl</code><br>
     * <code><span>-p src/test/resources/parser/hddl/HDDL-Total-Ordered/rover/pb01.hddl</code><br>
     *
     * @param args the arguments of the command line.
     */
    public static void main(final String[] args) {

        // Parse the commande line and initialize the arguments of the planner.
        final Properties arguments = TotalOrderSTNPlanner.parseCommandLine(args);
        if (arguments == null) {
            TotalOrderSTNPlanner.printUsage();
            System.exit(0);
        }

        // Create an instance of the TotalOrderSTNPlanner Planner
        final TotalOrderSTNPlanner planner = new TotalOrderSTNPlanner(arguments);

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

        // Encode the problem into compact representation
        final int traceLevel = (Integer) arguments.get(Planner.TRACE_LEVEL);
        factory.setTraceLevel(traceLevel);
        final Problem pb = factory.encode();
        System.out.println("\nencoding problem done successfully ("
                + pb.getActions().size() + " actions, "
                + pb.getMethods().size() + " methods, "
                + pb.getRelevantFluents().size() + " fluents, "
                + pb.getRelevantTasks().size() + " tasks)\n");

        final Plan plan = planner.search(pb);
        if (plan != null) {
            // Print plan information
            System.out.println("found plan as follows:\n\n" + pb.toString(plan));
            System.out.println(String.format("%nplan total cost: %4.2f%n%n", plan.cost()));
        } else {
            System.out.println(String.format(String.format("%nno plan found%n%n")));
        }
    }

    /**
     * Print the usage of the TotalOrderSTNPlanner planner.
     */
    private static void printUsage() {
        final StringBuilder strb = new StringBuilder();
        strb.append("\nusage of TotalOrderSTNPlanner:\n")
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
                if (!new File(args[i + 1]).exists()) return null;
                arguments.put(Planner.DOMAIN, new File(args[i + 1]));
            } else if ("-p".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                if (!new File(args[i + 1]).exists()) return null;
                arguments.put(Planner.PROBLEM, new File(args[i + 1]));
            } else if ("-t".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                final int timeout = Integer.parseInt(args[i + 1]) * 1000;
                if (timeout < 0) return null;
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
