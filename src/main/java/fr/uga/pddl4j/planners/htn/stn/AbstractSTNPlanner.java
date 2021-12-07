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
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.parser.PDDLParser;
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.plan.Hierarchy;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.htn.AbstractHTNPlanner;
import fr.uga.pddl4j.problem.HTNProblem;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
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
public abstract class AbstractSTNPlanner extends AbstractHTNPlanner<HTNProblem> implements STNPlanner<HTNProblem> {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(AbstractSTNPlanner.class.getName());

    /**
     * The boolean used to indicate that the planner is in an interactive mode.
     */
    private boolean interactive;

    /**
     * The cost of each task of the problem.
     */
    private int[] costs;

    /**
     * Creates a new planner with a default configuration.
     */
    public AbstractSTNPlanner() {
        this(Planner.getDefaultConfiguration());
    }

    /**
     * Creates a new planner with a specific configuration.
     *
     * @param configuration the configuration of the planner.
     */
    public AbstractSTNPlanner(final PlannerConfiguration configuration) {
        super(configuration);
        this.interactive = false;
    }

    /**
     * Returns if the planner is in interactive mode.
     *
     * @return <code>true</code> if the planner is in interactive mode; <code>false</code> otherwise.
     */
    public final boolean isInteractive() {
        return this.interactive;
    }

    /**
     * Sets the planner in the interactive mode.
     *
     * @param interactive the flag to indicate if the planner is in interactive mode or not.
     */
    @CommandLine.Option(names = {"-i", "--interactive"}, description = "Set the planner in interactive mode for debug")
    public final void setInteractive(final boolean interactive) {
        this.interactive = interactive;
    }

    /**
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     * @see PlannerConfiguration
     */
    public static PlannerConfiguration getDefaultConfiguration() {
        PlannerConfiguration config = Planner.getDefaultConfiguration();
        config.setProperty(STNPlanner.INTERACTIVE_MODE_SETTING,
            Boolean.toString(STNPlanner.DEFAULT_INTERACTIVE_MODE));
        return config;
    }

    /**
     * Returns the configuration of the planner.
     *
     * @return the configuration of the planner.
     */
    @Override
    public PlannerConfiguration getConfiguration() {
        final PlannerConfiguration config =  super.getConfiguration();
        config.setProperty(STNPlanner.INTERACTIVE_MODE_SETTING, Boolean.toString(this.isInteractive()));
        return config;
    }

    /**
     * Sets the configuration of the planner. If a planner setting is not defined in the specified configuration, the
     * setting is initialized with its default value.
     *
     * @param configuration the configuration to set.
     */
    @Override
    public void setConfiguration(final PlannerConfiguration configuration) {
        super.setConfiguration(configuration);
        if (configuration.getProperty(STNPlanner.INTERACTIVE_MODE_SETTING) == null) {
            this.setInteractive(STNPlanner.DEFAULT_INTERACTIVE_MODE);
        } else {
            this.setInteractive(Boolean.valueOf(configuration.getProperty(STNPlanner.INTERACTIVE_MODE_SETTING)));
        }
    }

    /**
     * Computes for each task of a planning problem the maximum number of primitive tasks needed to accomplish this
     * task.
     *
     * @param problem the planning problem
     */
    private void initTasksCosts(HTNProblem problem) {
        this.costs = new int[problem.getTaskResolvers().size()];
        Arrays.fill(this.costs, -1);
        for (int i = 0; i < problem.getTasks().size(); i++) {
            Set<Integer> closed = new HashSet<>();
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
    private int cost(int task, HTNProblem problem, Set<Integer> closed) {
        closed.add(task);
        if (this.costs[task] != -1) {
            return this.costs[task];
        } else if (problem.getTasks().get(task).isPrimtive()) {
            this.costs[task] = 1;
            return 1;
        } else {
            List<Integer> relevant = problem.getTaskResolvers().get(task);
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
    protected Plan extractPlan(final AbstractSTNNode node, final HTNProblem problem) {
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
    protected Hierarchy extractHierarchy(final AbstractSTNNode node, final HTNProblem problem) {

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
            // Operator is a method
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
                tmpn.taskSynonym = taskDictionary.get(task).removeFirst();
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
                tmpn.taskSynonym = taskDictionary.get(tmpn.task).removeFirst();
            }
        }

        open.add(top);
        while (!open.isEmpty()) {
            final Node tmpn = open.removeFirst();
            children = tmpn.getChildren();
            open.addAll(0, children);
            if (tmpn.parent == null) {
                for (Node child : children) {
                    hierarchy.getRootTasks().add(child.taskSynonym);
                }
            } else {
                if (!problem.getTasks().get(tmpn.task).isPrimtive()) {
                    hierarchy.getCounpoudTasks().put(tmpn.taskSynonym, tmpn.method);
                    List<Integer> decomposition = new ArrayList<>();
                    hierarchy.getDecomposition().put(tmpn.taskSynonym, decomposition);
                    for (Node child : children) {
                        decomposition.add(child.taskSynonym);
                    }
                }
            }
        }
        return hierarchy;
    }

    /**
     * Search a plan for the current planner configuration.
     *
     * @return the solution plan or null is no solution was found.
     * @throws FileNotFoundException if the domain or the problem file does not exist.
     */
    public Plan solve() throws FileNotFoundException {
        if (!this.hasValidConfiguration()) {
            throw new RuntimeException("Invalid planner configuration");
        }

        // Parses the PDDL domain and problem description
        long begin = System.currentTimeMillis();
        final PDDLParser parser = this.getParser();
        final ParsedProblem parsedProblem = parser.parse(this.getDomain(), this.getProblem());
        ErrorManager errorManager = parser.getErrorManager();
        this.getStatistics().setTimeToParse(System.currentTimeMillis() - begin);
        if (!errorManager.isEmpty()) {
            for (Message m : errorManager.getMessages()) {
                if (LOGGER.isFatalEnabled()
                    && (m.getType().equals(Message.Type.LEXICAL_ERROR)
                    || m.getType().equals(Message.Type.PARSER_ERROR))) {
                    LOGGER.fatal(m.toString());
                } else if (LOGGER.isWarnEnabled()
                    && m.getType().equals(Message.Type.PARSER_WARNING)) {
                    LOGGER.warn(m.toString());
                }
            }
            if (!errorManager.getMessages(Message.Type.LEXICAL_ERROR).isEmpty()
                || errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty()) {
                return null;
            }
        } else if (LOGGER.isInfoEnabled()) {
            StringBuilder strb = new StringBuilder();
            strb.append("\nparsing domain file \"");
            strb.append(this.getDomainFile().getName());
            strb.append("\" done successfully");
            strb.append("\nparsing problem file \"");
            strb.append(this.getProblemFile().getName());
            strb.append("\" done successfully");
            strb.append("\n");
            LOGGER.info(strb);
        }

        // Encodes and instantiates the problem in a compact representation
        begin = System.currentTimeMillis();
        HTNProblem pb = this.instantiate(parsedProblem);
        this.getStatistics().setTimeToEncode(System.currentTimeMillis() - begin);
        //this.getStatistics().setMemoryUsedForProblemRepresentation(MemoryAgent.getDeepSizeOf(pb));
        long end = System.currentTimeMillis();
        final double instantiationTime = (end - begin) / 1000.0;

        // Print instantiation information
        if (LOGGER.isInfoEnabled()) {
            StringBuilder strb = new StringBuilder();
            strb.append("\nEncoding ");
            if (pb.isTotallyOrederd()) {
                strb.append("totally ordered ");
            } else {
                strb.append("partially ordered ");
            }
            strb.append("problem done successfully (");
            strb.append(pb.getActions().size() + " actions, ");
            strb.append(pb.getMethods().size() + " methods, ");
            strb.append(pb.getFluents().size() + " fluents, ");
            strb.append(pb.getTasks().size() + " tasks)\n\n");
            if (!pb.isTotallyOrederd()) {
                strb.append("Unable to solve a problem that isn't totally ordered.\n");
            }
            LOGGER.info(strb);
        }

        // Case where the problem is solvable after instantiation
        if (pb.isSolvable()) {
            Plan plan = null;
            double searchTime = 0.0;
            try {
                LOGGER.info("Searching a solution plan....\n\n");
                begin = System.currentTimeMillis();
                plan = this.solve(pb);
                end = System.currentTimeMillis();
                searchTime = (end - begin) / 1000.0;
            } catch (OutOfMemoryError err) {
                if (LOGGER.isFatalEnabled()) {
                    LOGGER.fatal("Out of memory during search !");
                }
                System.exit(0);
            }
            //System.out.println(pb.toString(plan));
            // Print plan solution
            if (plan != null) {
                if (LOGGER.isInfoEnabled()) {
                    StringBuilder strb = new StringBuilder();
                    strb.append("Found plan as follows:\n");
                    strb.append(pb.toString(plan));
                    //strb.append("\n\n");
                    //strb.append("Plan decomposition as follows ");
                    //strb.append(pb.toString(plan.getHierarchy()));
                    strb.append(String.format("\nPlan total cost      : %4.2f%n", plan.cost()));
                    strb.append(String.format("Encoding time        : %4.3fs%n", instantiationTime));
                    strb.append(String.format("Searching time       : %4.3fs%n", searchTime));
                    strb.append(String.format("Total time           : %4.3fs%n%n", searchTime + instantiationTime));
                    LOGGER.info(strb);
                }
                return plan;
            }
        }

        if (LOGGER.isInfoEnabled()) {
            StringBuilder strb = new StringBuilder();
            strb.append(String.format(String.format("\n%nproblem with no solution plan found%n%n")));
            //strb.append("\n\n");
            //strb.append("Plan decomposition as follows ==> <==");
            strb.append(String.format("Encoding time        : %4.3fs", instantiationTime));
            strb.append(String.format("Searching time       : %4.3fs", 0.0));
            strb.append(String.format("Total time           : %4.3fs%n%n", instantiationTime));
            LOGGER.info(strb);
        }
        return null;
    }

    /**
     * Checks the planner configuration and returns if the configuration is valid. A configuration is valid if the
     * timeout allocated to the search is greter than 0.
     *
     * @return <code>true</code> if the configuration is valide <code>false</code> otherwise.
     */
    @Override
    public boolean hasValidConfiguration() {
        return super.hasValidConfiguration();
    }

    /**
     * Instantiates the planning problem from a parsed problem.
     *
     * @param problem the problem to instantiate.
     * @return the instantiated planning problem or null if the problem cannot be instantiated.
     */
    @Override
    public HTNProblem instantiate(final ParsedProblem problem) {
        final HTNProblem pb = new HTNProblem(problem);
        pb.instantiate();
        return pb;
    }

    /**
     * Wait until a key on keyboard is pressed.
     */
    protected static void waitPressAnyKey() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Node of the task decomposition. This inner class is use to produce the output of the plan in the hierarchical
     * plan validator.
     */
    private class Node {
        private Integer task;
        private Integer taskSynonym;
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
         * @param children the children to add.
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
