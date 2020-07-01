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
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.Method;
import fr.uga.pddl4j.problem.Problem;

import java.io.File;
import java.util.*;

/**
 * This abstract class implements the common methods of all Simple Task Network planners.
 *
 * @author D. Pellier
 * @version 1.0 - 25.06.2020
 * @since 4.0
 */
public abstract class AbstractSTNPlanner extends AbstractPlanner {

    /*
     * The arguments of the planner.
     */
    private Properties arguments;

    /**
     * The cost of each task of the problem.
     */
    private int[] costs;

    /**
     * Creates a new abstract STN planner with the default parameters.
     *
     * @param arguments the arguments of the planner.
     */
    public AbstractSTNPlanner(final Properties arguments) {
        super();
        this.arguments = arguments;
    }

    /**
     * Returns the arguments of the planner.
     *
     * @return the arguments of the planner.
     */
    public Properties getArguments() {
        return this.arguments;
    }

    /**
     * Computes for each tasks of a planning problem the maximum number of primitive tasks needed to accomplish this
     * task.
     *
     * @param problem the planning problem
     */
    private void initTasksCosts(Problem problem) {
        this.costs = new int[problem.getRelevantOperators().size()];
        Arrays.fill(this.costs, -1);
        for (int i = 0; i < problem.getTasks().size(); i++) {
            Set<Integer> closed =  new HashSet<Integer>();
            cost(i, problem, closed);
        }
    }


    /**
     * Computes recursively for a task of a planning problem the maximum number of primitive tasks needed to accomplish
     * this task.
     *
     * @param task the task.
     * @param problem the planning problem.
     * @param closed the set of task already encountered.
     */
    private int cost(int task, Problem problem, Set<Integer> closed) {
        closed.add(task);
        if (this.costs[task] != -1) {
            return this.costs[task];
        } else if (problem.getTasks().get(task).isPrimtive()) {
            this.costs[task] = 1;
            return 1;
        } else {
            List<Integer> relevant = problem.getRelevantOperators().get(task);
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < relevant.size(); i++) {
                Method m = problem.getMethods().get(relevant.get(i));
                int cost = 0;
                for (int s = 0; s < m.getSubTasks().size(); s++) {
                    final int st = m.getSubTasks().get(s);
                    if (!closed.contains(st)) {
                        cost += this.cost(st, problem, closed);
                    }
                }
                if (cost > max) {
                    max = cost;
                }
            }
            this.costs[task] = max;
            return max;
        }
    }

    /**
     * Extract a plan from a solution node for the specified planning problem.
     *
     * @param node    the solution node.
     * @param problem the problem to be solved.
     * @return the solution plan or null is no solution was found.
     */
    protected SequentialPlan extractPlan(final AbstractSTNNode node, final Problem problem) {
        AbstractSTNNode n = node;
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
     * Print the solution in the validator format.
     *
     * @param node    the solution node.
     * @param problem the problem to be solved.
    */

    public void printPlanForValidator(final AbstractSTNNode node, final Problem problem) {

        // Extract the list of tasks and operators from the search solution node.
        final List<Integer> tasks = new LinkedList<>();
        final List<Integer> operators = new LinkedList<>();
        final int nbactions = problem.getActions().size();
        AbstractSTNNode n = node;
        while (n.getParent() != null) {
            final int operator = n.getOperator();
            tasks.add(0, n.getTask());
            if (operator < nbactions) {
                operators.add(0, operator);
            } else {
                operators.add(0, operator - nbactions);
            }
            n = n.getParent();
        }

        // Create the dictionary to rename tasks with new IDs
        final LinkedHashMap<Integer, LinkedList<Integer>>  taskDictionary = new LinkedHashMap<>();
        int index = 0;
        for (Integer t : tasks) {
            LinkedList<Integer> value = taskDictionary.get(t);
            if (value == null) {
                value = new LinkedList<>();
                taskDictionary.put(t, value);
            }
            value.add(index);
            index++;
        }

        // Creates the plan and the decomposition to print
        index = 0;
        StringBuffer plan = new StringBuffer();
        StringBuffer decomposition = new StringBuffer();
        index = 0;
        for (Integer t : tasks) {
            if (problem.getTasks().get(t).isPrimtive()) {
                plan.append(index + " " + problem.toString(problem.getTasks().get(t)) + "\n");
            }  else {
                decomposition.append(index + " " + problem.toString(problem.getTasks().get(t)));
                Method m = problem.getMethods().get(operators.get(index));
                decomposition.append(" -> " + m.getName());
                for (Integer st : m.getSubTasks()) {
                    int task  = taskDictionary.get(st).pop();
                    taskDictionary.get(st).addLast(task);
                    decomposition.append(" " + task);
                }
                decomposition.append("\n");
            }
            index++;
        }
        // Creates the root output
        StringBuffer root = new StringBuffer();
        root.append("root");
        for (Integer t : problem.getInitialTaskNetwork().getTasks()) {
            root.append(" " + taskDictionary.get(t).pop());
        }
        root.append("\n");

        // Finally, print the output solution
        System.out.println("==>");
        System.out.print(plan);
        System.out.print(root);
        System.out.print(decomposition);
        System.out.println("<==\n");

    }

    /**
     * Print the usage of the AbstractSTNPlanner.
     */
    protected static void printUsage() {
        final StringBuilder strb = new StringBuilder();
        strb.append("\nusage of the planner:\n")
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
    protected static Properties parseCommandLine(String[] args) {
        // Get the default arguments from the super class
        final Properties arguments = Planner.getDefaultArguments();
        try {
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
        } catch (Throwable t) {
            AbstractSTNPlanner.printUsage();
            System.exit(0);
        }
        // Return null if the domain or the problem was not specified
        return (arguments.get(Planner.DOMAIN) == null
                || arguments.get(Planner.PROBLEM) == null) ? null : arguments;

    }
}
