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

import fr.uga.pddl4j.plan.Hierarchy;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.Method;
import fr.uga.pddl4j.problem.Problem;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Spliterator;

/**
 * This abstract class implements the common methods of all Simple Task Network planners.
 *
 * @author D. Pellier
 * @author H. Fiorino
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
    protected Plan extractPlan(final AbstractSTNNode node, final Problem problem) {
        AbstractSTNNode n = node;
        final Plan plan = new SequentialPlan();
        while (n.getParent() != null) {
            if (n.getOperator() < problem.getActions().size()) {
                final Action a = problem.getActions().get(n.getOperator());
                plan.add(0, a);
            }

            n = n.getParent();
        }
        plan.setHierarchy(this.extractHierarchy(node, problem));
        return plan;
    }


    /**
     * Extract a hierarchy from a solution node for the specified planning problem.
     *
     * @param node    the solution node.
     * @param problem the problem to be solved.
     * @return the hierarchy of the solution plan.
     */
    protected Hierarchy extractHierarchy(final AbstractSTNNode node, final Problem problem) {

        // Extract hierarchy of the plan
        final LinkedList<Integer> operators = new LinkedList<>();
        final LinkedList<Method> methods = new LinkedList<>();
        final LinkedList<Integer> tasks = new LinkedList<>();
        final LinkedHashMap<Integer, LinkedList<Integer>> taskDictionary = new LinkedHashMap<>();
        final Hierarchy hierarchy = new Hierarchy();
        final int nbactions = problem.getActions().size();

        // Extract lists of tasks and operators (actions or methods)
        AbstractSTNNode n = node;
        while (n.getParent() != null) {
            final int operator = n.getOperator();
            final Integer task = n.getTask();
            operators.add(0, operator);
            tasks.add(0, task);
            // ArithmeticOperator is a method
            if (operator >= nbactions) {
                final Method method = problem.getMethods().get(operator - nbactions);
                methods.add(0, method);
            }
            n = n.getParent();
        }

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
                //plan.append(String.format("%d %s%n", indexOfSynonyms, problem.toShortString(action)));
                hierarchy.getPrimtiveTasks().put(indexOfSynonyms, action);
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
            }
        }

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
                tmpn.method = method;
                final List<Integer> subtasks = method.getSubTasks();
                for (Integer subtask : subtasks) {
                    final Node child = new Node(tmpn, subtask);
                    children.add(child);
                }
                open.addAll(0, children);
                // Dumb method treatment
                if (tmpn.method.getName().startsWith("__to_method_")) {
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
        while (!open.isEmpty()) {
            final Node tmpn = open.removeFirst();
            children = tmpn.getChildren();
            open.addAll(0, children);
            if (tmpn.parent == null) {
                for (Node child : children) {
                    hierarchy.getRootTasks().add(child.tasksynonym);
                }
            } else {
                if (!problem.getTasks().get(tmpn.task).isPrimtive()) {
                    hierarchy.getCounpoudTasks().put(tmpn.tasksynonym, tmpn.method);
                    List<Integer> decomposition = new ArrayList<>();
                    hierarchy.getDecomposition().put(tmpn.tasksynonym, decomposition);
                    for (Node child : children) {
                        decomposition.add(child.tasksynonym);
                    }
                }
            }
        }

        return hierarchy;
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

    /**
     * Node of the task decomposition. This inner class is use to produce the output of the plan in the hierarchical
     * plan validator.
     */
    private class Node {
        private Integer task;
        private Integer tasksynonym;
        private String taskname;
        private String methodname;
        private Method method;
        private Node parent;
        private List<Node> children = new LinkedList<Node>();

        /**
         * Create a new node with a specified parent node and task.
         *
         * @param parent the parent node.
         * @param task the tasks.
         */
        public Node(final Node parent, final Integer task) {
            this.task = task;
            this.parent = parent;
        }

        /**
         * Returns the list of children of the node.
         *
         * @return the list of children of the node.
         */
        public List<Node> getChildren() {
            return this.children;
        }

        /**
         * Adds a list of children to the node.
         *
         * @param children the children to addValue.
         */
        public void addChildren(List<Node> children) {
            this.children.addAll(0, children);
        }

        /**
         * Returns a string of representation of the node.
         *
         * @return the string representation of this node.
         */
        public String toString() {
            return "Node [task = " + task + ", children = "
                + children + "]";
        }
    }
}
