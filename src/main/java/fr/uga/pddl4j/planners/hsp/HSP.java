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

package fr.uga.pddl4j.planners.hsp;

import fr.uga.pddl4j.encoding.AdapterPlanJavaJson;
import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.exceptions.FileException;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.heuristics.relaxation.HeuristicToolKit;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.Statistics;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.MemoryAgent;
import fr.uga.pddl4j.util.Plan;
import fr.uga.pddl4j.util.SequentialPlan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Properties;


/**
 * This class implements a simple forward planner based on A* algorithm.
 *
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 */
public final class HSP extends AbstractPlanner {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(HSP.class);

    /**
     * The default heuristicType.
     */
    public static final Heuristic.Type DEFAULT_HEURISTIC = Heuristic.Type.FAST_FORWARD;

    /*
     * The default weight of the heuristic.
     */
    public static final double DEFAULT_WEIGHT = 1.0;

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
     * Creates a new HSP planner with the default parameters.
     */
    public HSP() {
        super();
        this.setHeuristicType(HSP.DEFAULT_HEURISTIC);
        this.setWeight(HSP.DEFAULT_WEIGHT);
        this.setSaveState(HSP.DEFAULT_STATISTICS);
    }

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
     * Solves the planning problem and returns the first solution search found.
     *
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     */
    @Override
    public SequentialPlan search(final CodedProblem problem) {
        Objects.requireNonNull(problem);
        final long begin = System.currentTimeMillis();
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(this.getHeuristicType(), problem);
        // Get the initial state from the planning problem
        final BitState init = new BitState(problem.getInit());
        // Initialize the closed list of nodes (store the nodes explored)
        final Map<BitState, Node> closeSet = new HashMap<>();
        final Map<BitState, Node> openSet = new HashMap<>();
        // Initialize the opened list (store the pending node)
        final double currWeight = this.weight;
        // The list stores the node ordered according to the A* (getFValue = g + h) function
        final PriorityQueue<Node> open = new PriorityQueue<>(100, new NodeComparator(currWeight));
        // Creates the root node of the tree search
        final Node root = new Node(init, null, -1, 0, heuristic.estimate(init, problem.getGoal()));
        // Adds the root to the list of pending nodes
        open.add(root);
        openSet.put(init, root);
        SequentialPlan plan = null;

        final int timeout = this.getTimeout() * 1000;
        long time = 0;
        // Start of the search
        while (!open.isEmpty() && plan == null && time < timeout) {
            // Pop the first node in the pending list open
            final Node current = open.poll();
            openSet.remove(current);
            closeSet.put(current, current);
            // If the goal is satisfy in the current node then extract the search and return it
            if (current.satisfy(problem.getGoal())) {
                plan = this.extract(current, problem);
            } else {
                // Try to apply the operators of the problem to this node
                int index = 0;
                for (BitOp op : problem.getOperators()) {
                    // Test if a specified operator is applicable in the current state
                    if (op.isApplicable(current)) {
                        Node state = new Node(current);
                        // Apply the effect of the applicable operator
                        // Test if the condition of the effect is satisfied in the current state
                        // Apply the effect to the successor node
                        op.getCondEffects().stream().filter(ce -> current.satisfy(ce.getCondition())).forEach(ce ->
                            // Apply the effect to the successor node
                            state.apply(ce.getEffects())
                        );
                        final int g = current.getCost() + 1;
                        Node result = openSet.get(state);
                        if (result == null) {
                            result = closeSet.get(state);
                            if (result != null) {
                                if (g < result.getCost()) {
                                    result.setCost(g);
                                    result.setParent(current);
                                    result.setOperator(index);
                                    open.add(result);
                                    openSet.put(result, result);
                                    closeSet.remove(result);
                                }
                            } else {
                                state.setCost(g);
                                state.setParent(current);
                                state.setOperator(index);
                                state.setHeuristic(heuristic.estimate(state, problem.getGoal()));
                                open.add(state);
                                openSet.put(state, state);
                            }
                        } else if (g < result.getCost()) {
                            result.setCost(g);
                            result.setParent(current);
                            result.setOperator(index);
                        }

                    }
                    index++;
                }
            }
            // Compute the searching time
            time = System.currentTimeMillis() - begin;
        }

        if (isSaveState()) {
            this.getStatistics().setTimeToSearch(time);
            this.getStatistics().setMemoryUsedToSearch(MemoryAgent.deepSizeOf(closeSet)
                + MemoryAgent.deepSizeOf(openSet));
        }
        // return the search computed or null if no search was found
        return plan;
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
        while (n.getOperator() != -1) {
            final BitOp op = problem.getOperators().get(n.getOperator());
            plan.add(0, op);
            n = n.getParent();
        }
        return plan;
    }


    /**
     * resolve a problem and get the output plan as a JSON string
     * @param args the arguments of the command line.
     * @return the plan in a JSON format
     */
    public static String resolveAsJsonPlan(String[] args) {
        String jsonPlan = "";
        try {
            // Parse the command line
            final Properties arguments = HSP.parseArguments(args);
            final File domain = (File) arguments.get(HSP.Argument.DOMAIN);
            final File problem = (File) arguments.get(HSP.Argument.PROBLEM);
            final int traceLevel = 0;
            final int timeout = (Integer) arguments.get(Argument.TIMEOUT);
            final Heuristic.Type heuristicType = (Heuristic.Type) arguments.get(Argument.HEURISTIC);
            final double weight = (Double) arguments.get(HSP.Argument.WEIGHT);

            // Creates the planner
            final HSP planner = new HSP();
            planner.setHeuristicType(heuristicType);
            planner.setWeight(weight);
            planner.setTimeOut(timeout);
            planner.setTraceLevel(traceLevel);
            planner.setSaveState(false);


            // Creates the problem factory
            final ProblemFactory factory = new ProblemFactory();
            factory.setTraceLevel(traceLevel);

            // Parses the PDDL domain and problem description
            ErrorManager errorManager = factory.parse(domain, problem);
            if (!errorManager.isEmpty()) {
                errorManager.printAll();
                throw new RuntimeException("Parsing error");
            }

            // Encodes and instantiates the problem in a compact representation
            final CodedProblem pb = factory.encode();
            planner.getStatistics().setNumberOfActions(pb.getOperators().size());
            planner.getStatistics().setNumberOfRelevantFluents(pb.getRelevantFacts().size());

            if (!pb.isSolvable()) {
                StringBuilder strb = new StringBuilder();
                strb.append(String.format("goal can be simplified to FALSE. no search will solve it%n%n"));
                LOGGER.trace(strb);
                throw new RuntimeException("Problem not solvable");
            }

            // Searches for a solution plan
            final Plan plan = planner.search(pb);

            if (plan != null) {
                AdapterPlanJavaJson javaToJson = new AdapterPlanJavaJson(pb);
                jsonPlan = javaToJson.toStringJ(plan);
            }

        } catch (IOException ioExp) {
            LOGGER.error(ioExp);
        } catch (FileException fileEx) {
            LOGGER.error(fileEx);
            throw new RuntimeException("domain or problem files error");
        }

        return jsonPlan;

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
            final Properties arguments = HSP.parseArguments(args);
            final File domain = (File) arguments.get(HSP.Argument.DOMAIN);
            final File problem = (File) arguments.get(HSP.Argument.PROBLEM);
            final int traceLevel = (Integer) arguments.get(HSP.Argument.TRACE_LEVEL);
            final int timeout = (Integer) arguments.get(Argument.TIMEOUT);
            final Heuristic.Type heuristicType = (Heuristic.Type) arguments.get(Argument.HEURISTIC);
            final double weight = (Double) arguments.get(HSP.Argument.WEIGHT);
            final boolean saveStats = (Boolean) arguments.get(Argument.STATISTICS);

            // Creates the planner
            final HSP planner = new HSP();
            planner.setHeuristicType(heuristicType);
            planner.setWeight(weight);
            planner.setTimeOut(timeout);
            planner.setTraceLevel(traceLevel);
            planner.setSaveState(saveStats);


            // Creates the problem factory
            final ProblemFactory factory = new ProblemFactory();
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
            final CodedProblem pb = factory.encode();
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
        HEURISTIC,
        /**
         * The weight of the heuristic.
         */
        WEIGHT,
        /**
         * The global time slot allocated to the search.
         */
        TIMEOUT,
        /**
         * The trace level.
         */
        TRACE_LEVEL,
        /**
         * Generate statistics or not.
         */
        STATISTICS
    }

    /**
     * This method parse the command line and return the arguments.
     *
     * @param args the arguments from the command line.
     * @return The arguments of the planner.
     */
    private static Properties parseArguments(String[] args) throws FileException {
        final Properties arguments = HSP.getDefaultArguments();
        try {
            for (int i = 0; i < args.length; i += 2) {
                if ("-o".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    if (!new File(args[i + 1]).exists()) {
                        LOGGER.trace("operators file does not exist: " + args[i + 1] + "\n");
                    }
                    arguments.put(Argument.DOMAIN, new File(args[i + 1]));
                } else if ("-f".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    if (!new File(args[i + 1]).exists()) {
                        LOGGER.trace("facts file does not exist: " + args[i + 1] + "\n");
                    }
                    arguments.put(Argument.PROBLEM, new File(args[i + 1]));
                } else if ("-t".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int cpu = Integer.parseInt(args[i + 1]) * 1000;
                    if (cpu < 0) {
                        HSP.printUsage();
                    }
                    arguments.put(Argument.TIMEOUT, cpu);
                } else if ("-u".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int heuristic = Integer.parseInt(args[i + 1]);
                    if (heuristic < 0 || heuristic > 8) {
                        HSP.printUsage();
                    }
                    if (heuristic == 0) {
                        arguments.put(Argument.HEURISTIC, Heuristic.Type.FAST_FORWARD);
                    } else if (heuristic == 1) {
                        arguments.put(Argument.HEURISTIC, Heuristic.Type.SUM);
                    } else if (heuristic == 2) {
                        arguments.put(Argument.HEURISTIC, Heuristic.Type.SUM_MUTEX);
                    } else if (heuristic == 3) {
                        arguments.put(Argument.HEURISTIC, Heuristic.Type.AJUSTED_SUM);
                    } else if (heuristic == 4) {
                        arguments.put(Argument.HEURISTIC, Heuristic.Type.AJUSTED_SUM2);
                    } else if (heuristic == 5) {
                        arguments.put(Argument.HEURISTIC, Heuristic.Type.AJUSTED_SUM2M);
                    } else if (heuristic == 6) {
                        arguments.put(Argument.HEURISTIC, Heuristic.Type.COMBO);
                    } else if (heuristic == 7) {
                        arguments.put(Argument.HEURISTIC, Heuristic.Type.MAX);
                    } else {
                        arguments.put(Argument.HEURISTIC, Heuristic.Type.SET_LEVEL);
                    }
                } else if ("-w".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final double weight = Double.parseDouble(args[i + 1]);
                    if (weight < 0) {
                        HSP.printUsage();
                    }
                    arguments.put(Argument.WEIGHT, weight);
                } else if ("-i".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int level = Integer.parseInt(args[i + 1]);
                    if (level < 0) {
                        HSP.printUsage();
                    }
                    arguments.put(Argument.TRACE_LEVEL, level);
                } else if ("-s".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final boolean isStatUsed = Boolean.parseBoolean(args[i + 1]);
                    arguments.put(Argument.STATISTICS, isStatUsed);
                } else {
                    LOGGER.trace("\nUnknown argument for \"" + args[i] + "\" or missing value\n");
                    HSP.printUsage();
                    throw new FileException("Unknown arguments: " + args[i]);
                }
            }
            if (arguments.get(Argument.DOMAIN) == null || arguments.get(Argument.PROBLEM) == null) {
                LOGGER.trace("\nMissing DOMAIN or PROBLEM\n");
                HSP.printUsage();
                throw new FileException("Missing domain or problem");
            }
        } catch (RuntimeException runExp) {
            LOGGER.trace("\nError when parsing arguments\n");
            HSP.printUsage();
            throw runExp;
        }
        return arguments;
    }


    /**
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     */
    private static Properties getDefaultArguments() {
        final Properties options = new Properties();
        options.put(HSP.Argument.HEURISTIC, HSP.DEFAULT_HEURISTIC);
        options.put(HSP.Argument.WEIGHT, HSP.DEFAULT_WEIGHT);
        options.put(HSP.Argument.TIMEOUT, HSP.DEFAULT_TIMEOUT * 1000);
        options.put(HSP.Argument.TRACE_LEVEL, HSP.DEFAULT_TRACE_LEVEL);
        options.put(Argument.STATISTICS, HSP.DEFAULT_STATISTICS);
        return options;
    }

    /**
     * This method print the usage of the command-line planner.
     */
    private static void printUsage() {

        final StringBuilder strb = new StringBuilder();

        strb.append("\nusage of hsp:\n")
            .append("OPTIONS   DESCRIPTIONS\n")
            .append("-o <str>    operator file name\n")
            .append("-f <str>    fact file name\n")
            .append("-w <num>    the weight used in the a star seach (preset: 1)\n")
            .append("-t <num>    specifies the maximum CPU-time in seconds (preset: 300)\n")
            .append("-u <num>    specifies the heuristic to used (preset: 0)\n")
            .append("     0      ff heuristic\n")
            .append("     1      sum heuristic\n")
            .append("     2      sum mutex heuristic\n")
            .append("     3      adjusted sum heuristic\n")
            .append("     4      adjusted sum 2 heuristic\n")
            .append("     5      adjusted sum 2M heuristic\n")
            .append("     6      combo heuristic\n")
            .append("     7      max heuristic\n")
            .append("     8      set-level heuristic\n")
            .append("-i <num>    run-time information level (preset: 1)\n")
            .append("     0      nothing\n")
            .append("     1      info on action number, search and search\n")
            .append("     2      1 + info on problem constants, types and predicates\n")
            .append("     3      1 + 2 + loaded operators, initial and goal state\n")
            .append("     4      1 + predicates and their inertia status\n")
            .append("     5      1 + 4 + goal state and operators with unary inertia encoded\n")
            .append("     6      1 + actions, initial and goal state after expansion of variables\n")
            .append("     7      1 + final domain representation\n")
            .append("     8      line representation:\n")
            .append("               - problem name\n")
            .append("               - number of operators\n")
            .append("               - number of facts\n")
            .append("               - parsing time in seconds\n")
            .append("               - encoding time in seconds\n")
            .append("               - searching time in seconds\n")
            .append("               - total time in seconds\n")
            .append("               - memory used for problem representation in MBytes\n")
            .append("               - memory used for searching in MBytes\n")
            .append("               - total memory used in MBytes\n")
            .append("               - length of the solution plan\n")
            .append("-s <bool>   generate statistics or not (preset: true)\n")
            .append("-h          print this message\n\n");

        LOGGER.trace(strb);
    }

    /**
     * Node comparator class for HSP planner.
     */
    private static class NodeComparator implements Comparator<Node>, Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * The weight of the heuristic use for the comparison.
         */
        private double weight;

        /**
         * Build the Node comparator object base on heuristic weight.
         * @param weight the heuristic weight
         */
        public NodeComparator(double weight) {
            this.weight = weight;
        }

        /*
         * TO DO
         * @param n1
         * @param n2
         * @return
         */
        @Override
        public int compare(final Node n1, final Node n2) {
            return Double.compare(n1.getFValue(weight), n2.getFValue(weight));
        }
    }
}
