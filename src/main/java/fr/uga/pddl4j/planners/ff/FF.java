/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.planners.ff;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.encoding.Encoder;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.heuristics.relaxation.HeuristicToolKit;
import fr.uga.pddl4j.parser.Domain;
import fr.uga.pddl4j.parser.Parser;
import fr.uga.pddl4j.parser.Problem;
import fr.uga.pddl4j.util.BitExp;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.BitVector;
import fr.uga.pddl4j.util.MemoryAgent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class implements Fast Forward planner based on Enforced Hill Climbing Algorithm.
 *
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 */
public final class FF {

    /**
     * The default heuristic.
     */
    private static final Heuristic.Type DEFAULT_HEURISTIC = Heuristic.Type.FAST_FORWARD;

    /**
     * The default CPU time allocated to the search in seconds.
     */
    private static final int DEFAULT_CPU_TIME = 1000;

    /**
     * The default weight of the heuristic.
     */
    private static final double DEFAULT_WHEIGHT = 1.00;

    /**
     * The default trace level.
     */
    private static final int DEFAULT_TRACE_LEVEL = 1;
    /**
     * The time needed to search a solution plan.
     */
    private long searchingTime;
    /**
     * The time needed to encode the planning problem.
     */
    private long preprocessingTime;
    /**
     * The memory used in bytes to search a solution plan.
     */
    private long searchingMemory;
    /**
     * The memory used in bytes to encode problem.
     */
    private long problemMemory;
    /**
     * The number of node explored.
     */
    private int nbOfExploredNodes;
    /**
     * The arguments of the planner.
     */
    private Properties arguments;
    private int nb_states;
    private int max_depth;

    /**
     * Creates a new planner.
     *
     * @param arguments the arguments of the planner.
     */
    private FF(final Properties arguments) {
        this.arguments = arguments;
    }

    /**
     * The main method of the <code>FF</code> example. The command line syntax is as follow:
     * <p>
     * <pre>
     * usage of FF:
     *
     * OPTIONS   DESCRIPTIONS
     *
     * -o <i>str</i>   operator file name
     * -f <i>str</i>   fact file name
     * -w <i>num</i>   the weight used in the a star search (preset: 1)
     * -t <i>num</i>   specifies the maximum CPU-time in seconds (preset: 300)
     * -u <i>num</i>   specifies the heuristic to used (preset: 0)
     *      0      ff heuristic
     *      1      sum heuristic
     *      2      sum mutex heuristic
     *      3      adjusted sum heuristic
     *      4      adjusted sum 2 heuristic
     *      5      adjusted sum 2M heuristic
     *      6      combo heuristic
     *      7      max heuristic
     *      8      set-level heuristic
     * -i <i>num</i>   run-time information level (preset: 1)
     *      0      nothing
     *      1      info on action number, search and plan
     *      2      1 + info on problem constants, types and predicates
     *      3      1 + 2 + loaded operators, initial and goal state
     *      4      1 + predicates and their inertia status
     *      5      1 + 4 + goal state and operators with unary inertia encoded
     *      6      1 + actions, initial and goal state after expansion of variables
     *      7      1 + final domain representation
     *      8      line representation:
     *                - problem name
     *                - number of operators
     *                - number of facts
     *                - encoding time in seconds
     *                - memory used for problem representation in MBytes
     *                - number of states explored
     *                - searching time in seconds
     *                - memory used for searching in MBytes
     *                - global memory used in MBytes
     *                - solution plan length
     *      > 100  1 + various debugging information
     * -h          print this message
     *
     * </pre>
     * </p>
     *
     * @param args the arguments of the command line.
     */
    public static void main(String[] args) {
        // Parse the command line
        final Properties arguments = FF.parseArguments(args);
        // Create the planner
        FF planner = new FF(arguments);
        // Parse and encode the PDDL file into compact representation
        final CodedProblem problem = planner.parseAndEncode();

        if (problem != null) {
            // Search for a solution and print the result
            planner.search(problem);
        }
    }

    /**
     * This method parse the command line and return the arguments.
     *
     * @param args the arguments from the command line.
     * @return The arguments of the planner.
     */
    private static Properties parseArguments(String[] args) {
        final Properties arguments = FF.getDefaultArguments();
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equalsIgnoreCase("-o") && ((i + 1) < args.length)) {
                    arguments.put(FF.Argument.DOMAIN, args[i + 1]);
                    if (!new File(args[i + 1]).exists()) {
                        System.out.println("operators file does not exist");
                        throw new RuntimeException("operators file does not exist: " + args[i + 1]);
                    }
                    i++;
                } else if (args[i].equalsIgnoreCase("-f") && ((i + 1) < args.length)) {
                    arguments.put(FF.Argument.PROBLEM, args[i + 1]);
                    if (!new File(args[i + 1]).exists()) {
                        System.out.println("facts file does not exist");
                        throw new RuntimeException("facts file does not exist: " + args[i + 1]);
                    }
                    i++;
                } else if (args[i].equalsIgnoreCase("-t") && ((i + 1) < args.length)) {
                    final int cpu = Integer.parseInt(args[i + 1]) * 1000;
                    if (cpu < 0) {
                        FF.printUsage();
                    }
                    i++;
                    arguments.put(FF.Argument.CPU_TIME, cpu);
                } else if (args[i].equalsIgnoreCase("-u") && ((i + 1) < args.length)) {
                    final int heuristic = Integer.parseInt(args[i + 1]);
                    if (heuristic < 0 || heuristic > 8) {
                        FF.printUsage();
                    }
                    if (heuristic == 0) {
                        arguments.put(FF.Argument.HEURISTIC_TYPE, Heuristic.Type.FAST_FORWARD);
                    } else if (heuristic == 1) {
                        arguments.put(FF.Argument.HEURISTIC_TYPE, Heuristic.Type.SUM);
                    } else if (heuristic == 2) {
                        arguments.put(FF.Argument.HEURISTIC_TYPE, Heuristic.Type.SUM_MUTEX);
                    } else if (heuristic == 3) {
                        arguments.put(FF.Argument.HEURISTIC_TYPE, Heuristic.Type.AJUSTED_SUM);
                    } else if (heuristic == 4) {
                        arguments.put(FF.Argument.HEURISTIC_TYPE, Heuristic.Type.AJUSTED_SUM2);
                    } else if (heuristic == 5) {
                        arguments.put(FF.Argument.HEURISTIC_TYPE, Heuristic.Type.AJUSTED_SUM2M);
                    } else if (heuristic == 6) {
                        arguments.put(FF.Argument.HEURISTIC_TYPE, Heuristic.Type.COMBO);
                    } else if (heuristic == 7) {
                        arguments.put(FF.Argument.HEURISTIC_TYPE, Heuristic.Type.MAX);
                    } else {
                        arguments.put(FF.Argument.HEURISTIC_TYPE, Heuristic.Type.SET_LEVEL);
                    }
                    i++;
                } else if (args[i].equalsIgnoreCase("-w") && ((i + 1) < args.length)) {
                    final double weight = Double.valueOf(args[i + 1]);
                    if (weight < 0) {
                        FF.printUsage();
                    }
                    arguments.put(FF.Argument.WEIGHT, weight);
                    i++;
                } else if (args[i].equalsIgnoreCase("-i") && ((i + 1) < args.length)) {
                    final int level = Integer.parseInt(args[i + 1]);
                    if (level < 0) {
                        FF.printUsage();
                    }
                    arguments.put(FF.Argument.TRACE_LEVEL, level);
                    i++;
                } else {
                    FF.printUsage();
                }
            }
            if (arguments.get(FF.Argument.DOMAIN) == null
                || arguments.get(FF.Argument.PROBLEM) == null) {
                FF.printUsage();
            }
        } catch (Throwable throwable) {
            FF.printUsage();
        }
        return arguments;
    }

    /**
     * This method print the usage of the command-line planner.
     */
    private static void printUsage() {
        System.out.println("\nusage of FF:\n");
        System.out.println("OPTIONS   DESCRIPTIONS\n");
        System.out.println("-o <str>    operator file name");
        System.out.println("-f <str>    fact file name");
        System.out.println("-w <num>    the weight used in the a star seach (preset: 1)");
        System.out.println("-t <num>    specifies the maximum CPU-time in seconds (preset: 300)");
        System.out.println("-u <num>    specifies the heuristic to used (preset: 0)");
        System.out.println("     0      ff heuristic");
        System.out.println("     1      sum heuristic");
        System.out.println("     2      sum mutex heuristic");
        System.out.println("     3      adjusted sum heuristic");
        System.out.println("     4      adjusted sum 2 heuristic");
        System.out.println("     5      adjusted sum 2M heuristic");
        System.out.println("     6      combo heuristic");
        System.out.println("     7      max heuristic");
        System.out.println("     8      set-level heuristic");
        System.out.println("-i <num>    run-time information level (preset: 1)");
        System.out.println("     0      nothing");
        System.out.println("     1      info on action number, search and plan");
        System.out.println("     2      1 + info on problem constants, types and predicates");
        System.out.println("     3      1 + 2 + loaded operators, initial and goal state");
        System.out.println("     4      1 + predicates and their inertia status");
        System.out.println("     5      1 + 4 + goal state and operators with unary inertia encoded");
        System.out.println("     6      1 + actions, initial and goal state after expansion of variables");
        System.out.println("     7      1 + final domain representation");
        System.out.println("     8      line representation:");
        System.out.println("               - problem name");
        System.out.println("               - number of operators");
        System.out.println("               - number of facts");
        System.out.println("               - encoding time in seconds");
        System.out.println("               - memory used for problem representation in MBytes");
        System.out.println("               - number of states explored");
        System.out.println("               - searching time in seconds");
        System.out.println("               - memory used for searching in MBytes");
        System.out.println("               - global memory used in MBytes");
        System.out.println("               - solution plan length");
        System.out.println("     > 100  1 + various debugging information");
        System.out.println("-h          print this message\n\n");
    }

    /**
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     */
    private static Properties getDefaultArguments() {
        final Properties options = new Properties();
        options.put(FF.Argument.HEURISTIC_TYPE, FF.DEFAULT_HEURISTIC);
        options.put(FF.Argument.WEIGHT, FF.DEFAULT_WHEIGHT);
        options.put(FF.Argument.CPU_TIME, FF.DEFAULT_CPU_TIME * 1000);
        options.put(FF.Argument.TRACE_LEVEL, FF.DEFAULT_TRACE_LEVEL);
        return options;
    }

    /**
     * This method parses the PDDL files and encodes the corresponding planning problem into a
     * compact representation.
     *
     * @return the encoded problem.
     */
    public CodedProblem parseAndEncode() {
        final Parser parser = new Parser();
        final String ops = (String) this.arguments.get(FF.Argument.DOMAIN);
        final String facts = (String) this.arguments.get(FF.Argument.PROBLEM);
        try {
            parser.parse(ops, facts);
        } catch (FileNotFoundException fnfException) {
        }
        if (!parser.getErrorManager().isEmpty()) {
            parser.getErrorManager().printAll();
            return null;
        }
        final Domain domain = parser.getDomain();
        final Problem problem = parser.getProblem();
        final int traceLevel = (Integer) this.arguments.get(FF.Argument.TRACE_LEVEL);
        if (traceLevel > 0 && traceLevel != 8) {
            System.out.println();
            System.out.println("Parsing domain file \"" + new File(ops).getName()
                + "\" done successfully");
            System.out.println("Parsing problem file \"" + new File(facts).getName()
                + "\" done successfully\n");
        }
        if (traceLevel == 8) {
            Encoder.setLogLevel(0);
        } else {
            Encoder.setLogLevel(Math.max(0, traceLevel - 1));
        }
        long begin = System.currentTimeMillis();
        final CodedProblem pb = Encoder.encode(domain, problem);
        long end = System.currentTimeMillis();
        this.preprocessingTime = end - begin;
        this.problemMemory = MemoryAgent.deepSizeOf(pb);
        return pb;
    }

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param pb the problem to solve.
     */
    public void search(final CodedProblem pb) {
        //final BitExp goal = new BitExp(pb.getGoal());
        Node plan = this.enforced_hill_climbing(pb);
        if (plan == null) {
            System.out.println("Enforced Hill Climb Failed");
        }
        plan = this.greedy_best_first_search(pb);
        if (plan == null) {
            System.out.println("Greedy Best First Search Failed");

        }
        List<String> planz = this.extract(plan, pb);
        // The rest it is just to print the result
        final int traceLevel = (Integer) this.arguments.get(FF.Argument.TRACE_LEVEL);
        if (traceLevel > 0 && traceLevel != 8) {

            if (pb.isSolvable()) {
                if (planz != null) {
                    System.out.printf("%nfound plan as follows:%n%n");
                    for (int i = 0; i < planz.size(); i++) {
                        System.out.printf("time step %4d: %s%n", i, planz.get(i));
                    }
                } else {
                    System.out.printf("%nno plan found%n%n");
                }
            } else {
                System.out.printf("goal can be simplified to FALSE. no plan will solve it%n%n");
            }
            System.out.printf("%ntime spent: %8.2f seconds encoding ("
                + pb.getOperators().size() + " ops, " + pb.getRelevantFacts().size()
                + " facts)%n", (this.preprocessingTime / 1000.0));
            System.out.printf("            %8.2f seconds searching%n",
                (this.searchingTime / 1000.0));
            System.out.printf("            %8.2f seconds total time%n",
                ((this.preprocessingTime + searchingTime) / 1000.0));
            System.out.printf("%n");
            System.out.printf("memory used: %8.2f MBytes for problem representation%n",
                +(this.problemMemory / (1024.0 * 1024.0)));
            System.out.printf("             %8.2f MBytes for searching%n",
                +(this.searchingMemory / (1024.0 * 1024.0)));
            System.out.printf("             %8.2f MBytes total%n",
                +((this.problemMemory + this.searchingMemory) / (1024.0 * 1024.0)));
            System.out.printf("%n%n");
        }
        if (traceLevel == 8) {
            String problem = (String) this.arguments.get(FF.Argument.PROBLEM);
            String[] strArray = problem.split("/");
            String pbFile = strArray[strArray.length - 1];
            String pbName = pbFile.substring(0, pbFile.indexOf("."));
            System.out.printf("%5s %8d %8d %8.2f %8.2f %10d", pbName, pb.getOperators().size(),
                pb.getRelevantFacts().size(), (this.preprocessingTime / 1000.0),
                (this.problemMemory / (1024.0 * 1024.0)), this.nbOfExploredNodes);
            if (planz != null) {
                System.out.printf("%8.2f %8.2f %8.2f %8.2f %5d%n", (this.searchingTime / 1000.0),
                    ((this.preprocessingTime + searchingTime) / 1000.0),
                    (this.searchingMemory / (1024.0 * 1024.0)),
                    ((this.problemMemory + this.searchingMemory) / (1024.0 * 1024.0)),
                    planz.size());
            } else {
                System.out.printf("%8s %8s %8s %8s %5s%n", "-", "-", "-", "-", "-");
            }
        }
    }

    private Node enforced_hill_climbing(CodedProblem problem) {
        final long begin = System.currentTimeMillis();
        final Heuristic.Type type = (Heuristic.Type) this.arguments.get(FF.Argument.HEURISTIC_TYPE);
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(type, problem);
        this.nb_states = 0;
        this.max_depth = 0;
        BitState init = new BitState(problem.getInit());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, problem.getGoal()));
        // Creates the initial state
        final Node s0 = root.clone();
        // Compute the heuristic value of the initial state
        s0.setHeuristic(heuristic.estimate(s0, problem.getGoal()));
        //s0.setHeuristic(heuristic.estimate(initialState, goal));
        // Create the open list of the enforced hill-climbing algorithm
        final LinkedList<Node> open_list = new LinkedList<>();
        // Add the initial state to the open list
        open_list.add(s0);

        // Initialize the best heuristic value to the heuristic value of the initial state
        double best_heuristic = s0.getHeuristicValue();
        // Declare the solution state wit null value
        Node solution = null;
        // The boolean used to indicate that a dead end occurs
        boolean dead_end_free = true;
        BitExp goal = new BitExp(problem.getGoal());
        // The main loop of the enforced hill-climbing algorithm that implements
        // the breadth first search
        while (!open_list.isEmpty() && solution == null && dead_end_free) {
            final Node current_state = open_list.pop();
            //solution_state = this.extract(state, problem);
            final LinkedList<Node> successors = this.getSuccessors(current_state, problem, goal);
            // Update the boolean used to indicate if a dead end is detected

            dead_end_free = !successors.isEmpty();
            // The hill-climbing loop to try to go deeper
            while (!successors.isEmpty() && solution == null) {
                // Pop the first successor state from the list of successors
                final Node successor = successors.pop();
                // Get the heuristic value of this state
                final double heuristic1 = successor.getHeuristicValue();
                if (heuristic1 == 0.0) solution = successor;
                if (heuristic1 < best_heuristic) {
                    successors.clear();
                    open_list.clear();
                    best_heuristic = heuristic1;
                    this.max_depth++;
                }
                // Finally we add the successor to the open list to pursue the
                // bread first search
                open_list.addLast(successor);
                this.nb_states++;
            }
        }

        // Take time to compute the searching time
        long end = System.currentTimeMillis();
        // Compute the searching time
        this.searchingTime = end - begin;

        // Return the solution state of null if no solution was found
        return solution;

    }

    private LinkedList<Node> getSuccessors(Node state, CodedProblem problem, BitExp goal) {
        // Creates an empty list of neighbors

        final LinkedList<Node> successors = new LinkedList<>();
        if (state.getHeuristicValue() == Double.POSITIVE_INFINITY) return successors;
        BitState goalz = new BitState(problem.getGoal());
        final Node previous_goals_reached = state.clone();
        previous_goals_reached.and(goalz);
        // For each helpful actions creates the next states
        final BitVector helpful_actions = new BitVector(state);

        for (int i = helpful_actions.nextSetBit(0); i >= 0; i = helpful_actions.nextSetBit(i + 1)) {
            helpful_actions.get(i);
            BitOp op = problem.getOperators().get(i);
            // Creates the next state
            final Node next_state = new Node(state);

            // Adds the positive effects
            next_state.or(op.getCondEffects().get(0).getEffects().getPositive());
            // Deletes the negative effects
            next_state.andNot(op.getCondEffects().get(0).getEffects().getNegative());

            // Computes the goals reached by applying the current helpful action
            final Node new_goals_reached = next_state.clone();
            new_goals_reached.and(goalz);
            new_goals_reached.andNot(previous_goals_reached);
            double heuristic_value = next_state.getHeuristicValue();
            if (!goalz.intersects(new_goals_reached)) {
                next_state.setHeuristicValue(heuristic_value);
                next_state.setParent(state);
                next_state.setOperator(op.getArity());
                next_state.apply(goal);
                state.addSuccessor(next_state);
                successors.add(next_state);

            }
        }

        return successors;
    }

    private LinkedList<String> extract(final Node initialState, final CodedProblem problem) {
        Node n = initialState;
        final LinkedList<String> plan = new LinkedList<>();
        while (n.getParent() != null) {
            final BitOp op = problem.getOperators().get(n.getOperator());
            plan.addFirst(problem.toShortString(op));
            n = n.getParent();
        }
        return plan;
    }

    /**
     * Solves the planning problem and returns the first solution plan found. This method must be
     * completed.
     *
     * @param problem the coded planning problem to solve.
     * @return a solution plan or null if it does not exist.
     */
    private Node greedy_best_first_search(final CodedProblem problem) {
        final long begin = System.currentTimeMillis();
        final Heuristic.Type type = (Heuristic.Type) this.arguments.get(FF.Argument.HEURISTIC_TYPE);
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(type, problem);
        // Get the initial state from the planning problem
        BitState init = new BitState(problem.getInit());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, problem.getGoal()));
        // Creates the initial state
        final Node s0 = root.clone();

        // Initialize the closed list of nodes (store the nodes explored)
        final Set<Node> closeSet = new HashSet<>();
        final Set<Node> openSet = new HashSet<>();
        // Creates the root node of the tree search
        s0.setDepth(0);
        s0.setHeuristicValue(root.getOperator());
        openSet.add(s0);
        Node solution = null;
        final int CPUTime = (Integer) this.arguments.get(FF.Argument.CPU_TIME);
        // Start of the search
        while (!openSet.isEmpty() && solution == null && this.searchingTime < CPUTime) {
            // Pop the first node in the pending list open
            final Node current = this.pop(openSet);
            if (current.satisfy(problem.getGoal())) {
                solution = current;
            } else {
                closeSet.add(current);
                int index = 0;
                for (BitOp op : problem.getOperators()) {
                    // Test if a specified operator is applicable in the current state
                    if (op.isApplicable(current)) {

                        Node stateAfter = current.clone();
                        stateAfter.or(op.getCondEffects().get(0).getEffects().getPositive());
                        stateAfter.andNot(op.getCondEffects().get(0).getEffects().getNegative());
                        // Apply the effect of the applicable operator
                        if (!closeSet.contains(stateAfter)) {
                            stateAfter.setDepth(current.getDepth() + 1);
                            stateAfter.setHeuristic(heuristic.estimate(stateAfter, problem.getGoal()));
                            stateAfter.setParent(current);
                            stateAfter.setOperator(index);
                            current.addSuccessor(stateAfter);
                            openSet.add(stateAfter);


                        }

                    }
                    index++;
                }
            }
        }
        // Take time to compute the searching time
        long end = System.currentTimeMillis();
        // Compute the searching time
        this.searchingTime = end - begin;

        // Compute the memory used by the search
        this.searchingMemory += MemoryAgent.deepSizeOf(closeSet) + MemoryAgent.deepSizeOf(openSet)
            + MemoryAgent.deepSizeOf(openSet);
        this.searchingMemory += MemoryAgent.deepSizeOf(heuristic);
        this.nbOfExploredNodes = closeSet.size();
        // return the plan computed or null if no plan was found
        return solution;
    }

    private Node pop(Collection<Node> states) {
        Node state = null;
        if (!states.isEmpty()) {
            final Iterator<Node> i = states.iterator();
            state = i.next();
            while (i.hasNext()) {
                final Node next = i.next();
                if (next.getHeuristicValue() < state.getHeuristicValue()) {
                    state = next;
                }
            }
            states.remove(state);
        }
        return state;
    }

    /**
     * The enumeration of the arguments of the planner.
     */
    private enum Argument {
        /**
         * The planning domain.
         */
        DOMAIN,
        /**
         * The planning problem.
         */
        PROBLEM,
        /**
         * The heuristic to use.
         */
        HEURISTIC_TYPE,
        /**
         * The weight of the heuristic.
         */
        WEIGHT,
        /**
         * The global time slot allocated to the search.
         */
        CPU_TIME,
        /**
         * The trace level.
         */
        TRACE_LEVEL
    }


}
