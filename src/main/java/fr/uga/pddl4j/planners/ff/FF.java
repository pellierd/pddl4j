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
import fr.uga.pddl4j.exceptions.FileException;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.heuristics.relaxation.HeuristicToolKit;
import fr.uga.pddl4j.parser.Domain;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Parser;
import fr.uga.pddl4j.parser.Problem;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.CommonPlanner;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.Statistics;
import fr.uga.pddl4j.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * This class implements Fast Forward planner based on Enforced Hill Climbing Algorithm.
 *
 * @author Samuel Aaron Boyd
 * @author E. Hermellin
 * @version 2.0 - 24.01.2018
 */
public final class FF extends AbstractPlanner {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(FF.class);

    /**
     * The default heuristic.
     */
    private static final Heuristic.Type DEFAULT_HEURISTIC = Heuristic.Type.FAST_FORWARD;

    /**
     * The default weight of the heuristic.
     */
    private static final double DEFAULT_WEIGHT = 1.00;






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


    private int nb_states;
    private int max_depth;

    /**
     * The type of heuristics that must use to solve the problem.
     */
    private Heuristic.Type heuristicType;

    /**
     * The weight set to the heuristic.
     */
    private double weight;

    /**
     * Whether statistics are computed or not.
     */
    private boolean saveState;

    /**
     * Returns the heuristicType to use to solve the planning problem.
     *
     * @return the heuristicType to use to solve the planning problem.
     * @see fr.uga.pddl4j.heuristics.relaxation.Heuristic.Type
     */
    public final Heuristic.Type getHeuristicType() {
        return this.heuristicType;
    }

    /**
     * Sets the heuristicType to use to solved the problem.
     *
     * @param heuristicType the heuristicType to use to solved the problem. The heuristicType cannot be null.
     */
    public final void setHeuristicType(final Heuristic.Type heuristicType) {
        Objects.requireNonNull(heuristicType);
        this.heuristicType = heuristicType;
    }

    /**
     * Returns the weight set to the heuristic.
     *
     * @return the weight set to the heuristic.
     */
    public final double getHeuristicWeight() {
        return this.weight;
    }

    /**
     * Sets the wight of the heuristic.
     *
     * @param weight the weight of the heuristic. The weight must be positive.
     */
    public final void setWeight(final double weight) {
        this.weight = weight;
    }

    /**
     * Set the statistics generation value.
     * @param saveState the new statistics computation value
     */
    public void setSaveState(boolean saveState) {
        this.saveState = saveState;
    }

    /**
     * Is statistics generate or not.
     * @return true if statistics are compute and save, false otherwise
     */
    public boolean isSaveState() {
        return saveState;
    }

    /**
     * Creates a new planner.
     *
     */
    public FF() {
        super();
        this.setHeuristicType(FF.DEFAULT_HEURISTIC);
        this.setWeight(FF.DEFAULT_WEIGHT);
        this.setTimeOut(FF.DEFAULT_TIMEOUT);
        this.setSaveState(FF.DEFAULT_STATISTICS);
    }

    /**
     * The main method of the <code>HSP</code> example. The command line syntax is as follow:
     * <p>
     * <pre>
     * usage of HSP:
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
     *      1      info on action number, search and search
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
     *                - parsing time in seconds
     *                - encoding time in seconds
     *                - searching time in seconds
     *                - total time in seconds
     *                - memory used for problem representation in MBytes
     *                - memory used for searching in MBytes
     *                - total memory used in MBytes
     *                - length of the solution plan
     * -s          no statistics
     * -h          print this message
     *
     * </pre>
     * </p>
     *
     * @param args the arguments of the command line.
     */
    public static void main(String[] args) {

        try {
            // Parse the command line
            final Properties arguments = FF.parseArguments(args);
            final File domain = (File) arguments.get(CommonPlanner.Argument.DOMAIN);
            final File problem = (File) arguments.get(CommonPlanner.Argument.PROBLEM);
            final int traceLevel = (Integer) arguments.get(CommonPlanner.Argument.TRACE_LEVEL);
            final int timeout = (Integer) arguments.get(CommonPlanner.Argument.TIMEOUT);
            final Heuristic.Type heuristicType = (Heuristic.Type) arguments.get(CommonPlanner.Argument.HEURISTIC);
            final double weight = (Double) arguments.get(CommonPlanner.Argument.WEIGHT);
            final boolean saveStats = (Boolean) arguments.get(CommonPlanner.Argument.STATISTICS);

            // Creates the planner
            final FF planner = new FF();
            planner.setHeuristicType(heuristicType);
            planner.setWeight(weight);
            planner.setTimeOut(timeout);
            planner.setTraceLevel(traceLevel);
            planner.setSaveState(saveStats);

            // Creates the problem factory
            final ProblemFactory factory = ProblemFactory.getInstance();
            final int factoryTraceLevel = (traceLevel == 8) ? 0 : Math.max(0, traceLevel - 1);
            factory.setTraceLevel(factoryTraceLevel);

            // Parses the PDDL domain and problem description

            long begin = System.currentTimeMillis();
            ErrorManager errorManager = factory.parse(domain, problem);
            if (saveStats) {
                planner.getStatistics().setTimeToParse(System.currentTimeMillis() - begin);
            }
            if (!errorManager.isEmpty()) {
                errorManager.printAll();
                System.exit(0);
            } else if (traceLevel > 0 && traceLevel != 8) {
                StringBuilder strb = new StringBuilder();
                strb.append("\nparsing domain file \"").append(domain.getName()).append("\" done successfully")
                    .append("\nparsing problem file \"").append(problem.getName()).append("\" done successfully")
                    .append("\n");
                LOGGER.trace(strb);
            }

            // Encodes and instantiates the problem in a compact representation
            begin = System.currentTimeMillis();
            CodedProblem pb = factory.encode();
            if (saveStats) {
                planner.getStatistics().setTimeToEncode(System.currentTimeMillis() - begin);
                planner.getStatistics().setMemoryUsedForProblemRepresentation(MemoryAgent.deepSizeOf(pb));
            }
            planner.getStatistics().setNumberOfActions(pb.getOperators().size());
            planner.getStatistics().setNumberOfRelevantFluents(pb.getRelevantFacts().size());

            if (traceLevel > 0 && traceLevel != 8) {
                StringBuilder strb = new StringBuilder();
                strb.append("\nencoding problem done successfully (")
                    .append(planner.getStatistics().getNumberOfActions()).append(" ops, ")
                    .append(planner.getStatistics().getNumberOfRelevantFluents()).append(" facts)\n");
                LOGGER.trace(strb);
            }

            if (traceLevel > 0 && traceLevel != 8 && !pb.isSolvable()) {
                StringBuilder strb = new StringBuilder();
                strb.append(String.format("goal can be simplified to FALSE. no search will solve it%n%n"));
                LOGGER.trace(strb);
                System.exit(0);
            }

            // Searches for a solution plan
            final Plan plan = planner.search(pb);
            System.out.println(pb.toString(plan));

            // Print the results
            final String problemName = problem.getName().substring(0, problem.getName().indexOf('.'));
            final int numberOfActions = planner.getStatistics().getNumberOfActions();
            final int numberOfFluents = planner.getStatistics().getNumberOfRelevantFluents();
            double timeToParseInSeconds = 0.0;
            double timeToEncodeInSeconds = 0.0;
            double timeToSearchInSeconds = 0.0;
            double totalTimeInSeconds = 0.0;
            double memoryForProblemInMBytes = 0.0;
            double memoryUsedToSearchInMBytes = 0.0;
            double totalMemoryInMBytes = 0.0;

            if (saveStats) {
                timeToParseInSeconds = Statistics.millisecondToSecond(planner.getStatistics().getTimeToParse());
                timeToEncodeInSeconds = Statistics.millisecondToSecond(planner.getStatistics().getTimeToEncode());
                timeToSearchInSeconds = Statistics.millisecondToSecond(planner.getStatistics().getTimeToSearch());
                totalTimeInSeconds = timeToParseInSeconds + timeToEncodeInSeconds + timeToSearchInSeconds;
                memoryUsedToSearchInMBytes = Statistics.byteToMByte(planner.getStatistics().getMemoryUsedToSearch());
                memoryForProblemInMBytes =
                    Statistics.byteToMByte(planner.getStatistics().getMemoryUsedForProblemRepresentation());
                totalMemoryInMBytes = memoryForProblemInMBytes + memoryUsedToSearchInMBytes;
            }


            if (traceLevel > 0 && traceLevel != 8) {
                final StringBuilder strb = new StringBuilder();
                if (plan != null) {
                    strb.append(String.format("%nfound plan as follows:%n%n"));
                    strb.append(pb.toString(plan));

                } else {
                    strb.append(String.format("%nno plan found%n%n"));
                }
                if (saveStats) {
                    strb.append(String.format("%ntime spent:   %8.2f seconds parsing %n", timeToParseInSeconds));
                    strb.append(String.format("              %8.2f seconds encoding %n", timeToEncodeInSeconds));
                    strb.append(String.format("              %8.2f seconds searching%n", timeToSearchInSeconds));
                    strb.append(String.format("              %8.2f seconds total time%n", totalTimeInSeconds));
                    strb.append(String.format("%nmemory used:  %8.2f MBytes for problem representation%n",
                        memoryForProblemInMBytes));
                    strb.append(String.format("              %8.2f MBytes for searching%n",
                        memoryUsedToSearchInMBytes));
                    strb.append(String.format("              %8.2f MBytes total%n%n%n", totalMemoryInMBytes));
                }
                LOGGER.trace(strb);
            } else if (traceLevel == 8) {
                final StringBuilder strb = new StringBuilder();
                if (plan != null) {
                    strb.append(String.format("%5s %8d %8d %8.2f %8.2f %8.2f %8.2f %8.2f %8.2f %8.2f %5d%n",
                        problemName,
                        numberOfActions,
                        numberOfFluents,
                        timeToParseInSeconds,
                        timeToEncodeInSeconds,
                        timeToSearchInSeconds,
                        totalTimeInSeconds,
                        memoryForProblemInMBytes,
                        memoryUsedToSearchInMBytes,
                        totalMemoryInMBytes,
                        plan.size()));
                } else {
                    strb.append(String.format("%5s %8d %8d %8.2f %8.2f %8s %8s %8.2f %8s %8s %5s%n",
                        problem.getName(),
                        numberOfActions,
                        numberOfFluents,
                        timeToParseInSeconds,
                        timeToEncodeInSeconds,
                        "--",
                        "--",
                        memoryForProblemInMBytes,
                        "--",
                        "--",
                        "--"));
                }
                LOGGER.trace(strb);
            }
        } catch (IOException ioExp) {
            LOGGER.error(ioExp);
        } catch (FileException fileEx) {
            LOGGER.error(fileEx);
            System.exit(1);
        }
    }

    /**
     * This method parse the command line and return the arguments.
     *
     * @param args the arguments from the command line.
     * @return The arguments of the planner.
     */
    private static Properties parseArguments(String[] args) throws FileException {
        final Properties arguments = FF.getDefaultArguments();
        try {
            for (int i = 0; i < args.length; i += 2) {
                if ("-o".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    if (!new File(args[i + 1]).exists()) {
                        LOGGER.trace("operators file does not exist: " + args[i + 1] + "\n");
                    }
                    arguments.put(CommonPlanner.Argument.DOMAIN, new File(args[i + 1]));
                } else if ("-f".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    if (!new File(args[i + 1]).exists()) {
                        LOGGER.trace("facts file does not exist: " + args[i + 1] + "\n");
                    }
                    arguments.put(CommonPlanner.Argument.PROBLEM, new File(args[i + 1]));
                } else if ("-t".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int cpu = Integer.parseInt(args[i + 1]) * 1000;
                    if (cpu < 0) {
                        LOGGER.trace(CommonPlanner.printUsage());
                    }
                    arguments.put(CommonPlanner.Argument.TIMEOUT, cpu);
                } else if ("-u".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int heuristic = Integer.parseInt(args[i + 1]);
                    if (heuristic < 0 || heuristic > 8) {
                        LOGGER.trace(CommonPlanner.printUsage());
                    }
                    if (heuristic == 0) {
                        arguments.put(CommonPlanner.Argument.HEURISTIC, Heuristic.Type.FAST_FORWARD);
                    } else if (heuristic == 1) {
                        arguments.put(CommonPlanner.Argument.HEURISTIC, Heuristic.Type.SUM);
                    } else if (heuristic == 2) {
                        arguments.put(CommonPlanner.Argument.HEURISTIC, Heuristic.Type.SUM_MUTEX);
                    } else if (heuristic == 3) {
                        arguments.put(CommonPlanner.Argument.HEURISTIC, Heuristic.Type.AJUSTED_SUM);
                    } else if (heuristic == 4) {
                        arguments.put(CommonPlanner.Argument.HEURISTIC, Heuristic.Type.AJUSTED_SUM2);
                    } else if (heuristic == 5) {
                        arguments.put(CommonPlanner.Argument.HEURISTIC, Heuristic.Type.AJUSTED_SUM2M);
                    } else if (heuristic == 6) {
                        arguments.put(CommonPlanner.Argument.HEURISTIC, Heuristic.Type.COMBO);
                    } else if (heuristic == 7) {
                        arguments.put(CommonPlanner.Argument.HEURISTIC, Heuristic.Type.MAX);
                    } else {
                        arguments.put(CommonPlanner.Argument.HEURISTIC, Heuristic.Type.SET_LEVEL);
                    }
                } else if ("-w".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final double weight = Double.parseDouble(args[i + 1]);
                    if (weight < 0) {
                        LOGGER.trace(CommonPlanner.printUsage());
                    }
                    arguments.put(CommonPlanner.Argument.WEIGHT, weight);
                } else if ("-i".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int level = Integer.parseInt(args[i + 1]);
                    if (level < 0) {
                        LOGGER.trace(CommonPlanner.printUsage());
                    }
                    arguments.put(CommonPlanner.Argument.TRACE_LEVEL, level);
                } else if ("-s".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final boolean isStatUsed = Boolean.parseBoolean(args[i + 1]);
                    arguments.put(CommonPlanner.Argument.STATISTICS, isStatUsed);
                } else {
                    LOGGER.trace("\nUnknown argument for \"" + args[i] + "\" or missing value\n");
                    LOGGER.trace(CommonPlanner.printUsage());
                    throw new FileException("Unknown arguments: " + args[i]);
                }
            }
            if (arguments.get(CommonPlanner.Argument.DOMAIN) == null || arguments.get(CommonPlanner.Argument.PROBLEM) == null) {
                LOGGER.trace("\nMissing DOMAIN or PROBLEM\n");
                LOGGER.trace(CommonPlanner.printUsage());
                throw new FileException("Missing domain or problem");
            }
        } catch (RuntimeException runExp) {
            LOGGER.trace("\nError when parsing arguments\n");
            LOGGER.trace(CommonPlanner.printUsage());
            throw runExp;
        }
        return arguments;
    }

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param pb the problem to solve.
     */
    @Override
    public SequentialPlan search(final CodedProblem pb) {
        Objects.requireNonNull(pb);
        Node plan = this.enforced_hill_climbing(pb);
        if (plan == null) {
            LOGGER.trace("Enforced Hill Climb Failed");
        }
        plan = this.greedy_best_first_search(pb);
        if (plan == null) {
            LOGGER.trace("Greedy Best First Search Failed");

        }
        return this.extract(plan, pb);
    }

    private Node enforced_hill_climbing(CodedProblem problem) {
        final long begin = System.currentTimeMillis();
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(this.getHeuristicType(), problem);
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

    /**
     * Extracts a search from a specified node.
     *
     * @param node the node.
     * @param problem the problem.
     * @return the search extracted from the specified node.
     */
    private SequentialPlan extract(final Node node, final CodedProblem problem) {
        Node n = node;
        final SequentialPlan plan = new SequentialPlan();
        while (n.getParent() != null) {
            final BitOp op = problem.getOperators().get(n.getOperator());
            plan.add(0, op);
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
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(this.getHeuristicType(), problem);
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
        final int CPUTime = this.getTimeout();
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
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     */
    private static Properties getDefaultArguments() {
        final Properties options = new Properties();
        options.put(CommonPlanner.Argument.HEURISTIC, FF.DEFAULT_HEURISTIC);
        options.put(CommonPlanner.Argument.WEIGHT, FF.DEFAULT_WEIGHT);
        options.put(CommonPlanner.Argument.TIMEOUT, FF.DEFAULT_TIMEOUT * 1000);
        options.put(CommonPlanner.Argument.TRACE_LEVEL, FF.DEFAULT_TRACE_LEVEL);
        options.put(CommonPlanner.Argument.STATISTICS, FF.DEFAULT_STATISTICS);
        return options;
    }
}
