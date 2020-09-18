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
            int max = java.lang.Integer.MIN_VALUE;
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

        final LinkedList<Integer> operators = new LinkedList<>();
        final LinkedList<Method> methods = new LinkedList<>();
        final LinkedList<Integer> tasks = new LinkedList<>();
        final LinkedHashMap<Integer, LinkedList<Integer>> taskDictionary = new LinkedHashMap<>();

        final int nbactions = problem.getActions().size();

        // Extract lists of tasks and operators (actions or methods)
        AbstractSTNNode n = node;
        while (n.getParent() != null) {
            final int operator = n.getOperator();
            final Integer task = n.getTask();
            operators.add(0, operator);
            tasks.add(0, task);
            // Operator is a method
            if (operator >= nbactions) {
                final Method method = problem.getMethods().get(operator - nbactions);
                methods.add(0, method);
            }
            n = n.getParent();
        }
        System.out.println(tasks.toString());
        System.out.println(operators.toString());
        System.out.println(nbactions);

        StringBuffer plan = new StringBuffer();
        //int indexOfActions = 0;
        //int indexOfMethods = 0;
        int indexOfSynonyms = 0;
        for (int i = 0; i < tasks.size(); i++) {
            final Integer operator = operators.get(i);
            final Integer task = tasks.get(i);
            // Rename primitive tasks
            if (operator < nbactions) {
                if (taskDictionary.containsKey(task)) {
                    taskDictionary.get(task).add(indexOfSynonyms);
                } else {
                    final LinkedList<Integer> alias = new LinkedList<Integer>();
                    alias.add(indexOfSynonyms);
                    taskDictionary.put(task, alias);
                }
                // Format plan
                final Action action = problem.getActions().get(operator);
                plan.append(String.format("%d %s%n", indexOfSynonyms, problem.toShortString(action)));
                indexOfSynonyms++;
            } else {
                // Rename abstract tasks
                if (taskDictionary.containsKey(task)) {
                    taskDictionary.get(task).add(indexOfSynonyms++);
                } else {
                    final LinkedList<Integer> alias = new LinkedList<Integer>();
                    alias.add(indexOfSynonyms++);
                    taskDictionary.put(task, alias);
                }
                // Method decomposition cannot be formatted here
                //indexOfMethods++;
            }
        }

        System.out.println(taskDictionary.toString());

        // Builds the decomposition tree
        LinkedList<Node> open = new LinkedList<Node>();
        List<Node> children = new LinkedList<Node>();
        final Node top = new Node(null, null);
        for (Integer task : problem.getInitialTaskNetwork().getTasks()) {
            final Node tmpn = new Node(top, task);
            children.add(tmpn);
        }
        open.addAll(0, children);
        top.addChildren(children);
        children.clear();

        while (!open.isEmpty()) {
            final Node tmpn = open.removeFirst();
            if (!problem.getTasks().get(tmpn.task).isPrimtive()) {
                final Method method = methods.removeFirst();
                final Integer task = method.getTask();
                tmpn.tasksynonym = taskDictionary.get(task).removeFirst();
                tmpn.methodname = method.getName();
                tmpn.taskname = problem.toString(problem.getTasks().get(task));
                final List<Integer> subtasks = method.getSubTasks();
                for (Integer subtask : subtasks) {
                    final Node child = new Node(tmpn, subtask);
                    children.add(child);
                }
                open.addAll(0, children);
                // Dumb method treatment
                if (tmpn.methodname.startsWith("__to_method_")) {
                    // All children of the current node are connected to the node's parent
                    for (Node child : children) {
                        child.parent = tmpn.parent;
                    }
                    // Current node is disconnected of the decomposition tree
                    List<Node> descendants = tmpn.parent.getChildren();
                    List<Node> newList = new LinkedList<Node>();
                    // children must be final in the upcoming lambda
                    final List<Node> fchildren = new LinkedList<Node>(children);
                    Spliterator<Node> iterator = descendants.spliterator();
                    iterator.forEachRemaining(
                        (d) -> {
                            if (d.equals(tmpn)) {
                                newList.addAll(fchildren);
                            } else {
                                newList.add(d);
                            }
                        }
                    );
                    tmpn.parent.children = newList;
                    tmpn.parent = null;
                } else {
                    tmpn.addChildren(children);
                }
                children.clear();
            } else {
                tmpn.tasksynonym = taskDictionary.get(tmpn.task).removeFirst();
            }
        }

        open.add(top);
        final StringBuffer root = new StringBuffer();
        root.append("root");
        final StringBuffer decomposition = new StringBuffer();
        while(!open.isEmpty()) {
            final Node tmpn = open.removeFirst();
            children = tmpn.getChildren();
            open.addAll(0, children);
            if (tmpn.parent == null) {
                for (Node child : children) {
                    root.append(" " + child.tasksynonym);
                }
                root.append("\n");
            } else {
                if (!problem.getTasks().get(tmpn.task).isPrimtive()) {
                    decomposition.append(tmpn.tasksynonym + " " + tmpn.taskname + " -> " + tmpn.methodname);
                    for (Node child : children) {
                        decomposition.append(" " + child.tasksynonym);
                    }
                    decomposition.append("\n");
                }
            }
        }

        // Finally, print the output solution
        System.out.println("==>");
        System.out.print(plan);
        System.out.print(root);
        System.out.print(decomposition);
        System.out.println("<==");

    }

    private int indexOf(int from, int task, List<Integer> tasks) {
        for (int i = from; i < tasks.size(); i++) {
            if (tasks.get(i) == task) {
                return i;
            }
        }
        return -1;
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
                    final int timeout = java.lang.Integer.parseInt(args[i + 1]) * 1000;
                    if (timeout < 0) {
                        return null;
                    }
                    arguments.put(Planner.TIMEOUT, timeout);
                } else if ("-l".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int level = java.lang.Integer.parseInt(args[i + 1]);
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

    // Node of the task decomposition
    public class Node {
        private Integer task;
        private Integer tasksynonym;
        private String taskname;
        private String methodname;
        private Node parent;
        private List<Node> children = new LinkedList<Node>();

        public Node (final Node parent, final Integer task) {
            this.task = task;
            this.parent = parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void addChildren(List<Node> children) {
            this.children.addAll(0, children);
        }

        public String toString() {
            return "Node [task = " + task + ", children = "
                + children + "]";
        }
    }
}
