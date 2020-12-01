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

package fr.uga.pddl4j.planners.htn.stn.pfd;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.htn.stn.AbstractSTNPlanner;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.State;
import fr.uga.pddl4j.problem.Method;
import fr.uga.pddl4j.problem.ProblemOld;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Properties;

/**
 * This class implement a simple task network planner enable to deal with partial ordered htn representation. The
 * search method is an implementation of the partial order STN procedure describes in the book of Automated Planning of
 * Ghallab and al. page 243.
 *
 * @author D. Pellier
 * @version 1.0 - 15.04.2020
 * @since 4.0
 */
public final class PFDPlanner extends AbstractSTNPlanner {

    /**
     * Creates a new partial order STN planner with the default parameters.
     *
     * @param arguments the arguments of the planner.
     */
    public PFDPlanner(final Properties arguments) {
        super(arguments);
    }

    /**
     * Solves the planning problem and returns the first solution search found. The search method is an implementation
     * of the partial order STN procedure describes in the book of Automated Planning of Ghallab and al. page 243.
     *
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     */
    @Override
    public Plan search(final ProblemOld problem) {
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
                    int traceLevel = (Integer) this.getArguments().get(Planner.TRACE_LEVEL);
                    return super.extractPlan(currentNode, problem);
                }  else {
                    if (this.getTraceLevel() == 10) {
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
                    final List<Integer> relevantOperators = problem.getRelevantOperators().get(taskIndex);
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
     * The main method of the <code>PFDPlanner</code> example. The command line syntax is as
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
     * <code>java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.htn.pfd.PFDPlanner</code><br>
     * <code>  -d src/test/resources/benchmarks/hddl/ipc2020/rover/domain.hddl</code><br>
     * <code>  -p src/test/resources/benchmarks/hddl/ipc2020/rover/pb01.hddl</code><br>
     * </p>
     * @param args the arguments of the command line.
     */
    public static void main(final String[] args) {

        // Parse the commande line and initialize the arguments of the planner.
        final Properties arguments = PFDPlanner.parseCommandLine(args);
        if (arguments == null) {
            PFDPlanner.printUsage();
            System.exit(0);
        }

        // Create an instance of the TFDPlanner Planner
        final PFDPlanner planner = new PFDPlanner(arguments);

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

        if (!errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty()
            || !errorManager.getMessages(Message.Type.LEXICAL_ERROR).isEmpty()) {
            errorManager.printAll();
            System.exit(0);
        }
        System.out.println("\nparsing domain file \"" + domain.getName() + "\" and problem \"" + problem.getName()
            + "\" done successfully");

        // Encode the problem into compact representation
        final int traceLevel = (Integer) arguments.get(Planner.TRACE_LEVEL);
        factory.setTraceLevel(traceLevel - 1);
        long start = System.currentTimeMillis();
        ProblemOld pb =  null;
        try {
            pb = factory.encode();
        } catch (OutOfMemoryError err) {
            System.out.println("Out of memory during problem instantiation !");
            System.exit(0);
        }
        long end = System.currentTimeMillis();
        final double encodingTime = (end - start) / 1000.0;
        System.out.print("\nEncoding ");
        if (pb.isTotallyOrederd()) {
            System.out.print("totally ordered ");
        } else {
            System.out.print("partially ordered ");
        }
        System.out.println("problem done successfully ("
            + pb.getActions().size() + " actions, "
            + pb.getMethods().size() + " methods, "
            + pb.getRelevantFluents().size() + " fluents, "
            + pb.getTasks().size() + " tasks)\n");

        if (pb.isSolvable()) {
            try {
                System.out.println("Searching a solution plan....\n");
                start = System.currentTimeMillis();
                final Plan plan = planner.search(pb);
                end = System.currentTimeMillis();
                final double searchTime = (end - start) / 1000.0;
                if (plan != null) {
                    // Print plan information
                    if (traceLevel == 9) {
                        System.out.println(pb.toString(plan.getHierarchy()));
                    } else {
                        System.out.println("Found plan as follows:\n" + pb.toString(plan));
                    }
                    System.out.println(String.format("Plan total cost      : %4.2f", plan.cost()));
                    System.out.println(String.format("Encoding time        : %4.3fs", encodingTime));
                    System.out.println(String.format("Searching time       : %4.3fs", searchTime));
                    System.out.println(String.format("Total time           : %4.3fs%n", searchTime + encodingTime));

                } else {
                    if (traceLevel == 9) {
                        System.out.println("==>");
                        System.out.println("<==\n");
                    } else {
                        System.out.println(String.format(String.format("\n%nno plan found%n%n")));
                    }
                    System.out.println(String.format("Encoding time        : %4.3fs", encodingTime));
                    System.out.println(String.format("Searching time       : %4.3fs", searchTime));
                    System.out.println(String.format("Total time           : %4.3fs%n", searchTime + encodingTime));
                }
            } catch (OutOfMemoryError err) {
                System.out.println("Out of memory during search !");
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
