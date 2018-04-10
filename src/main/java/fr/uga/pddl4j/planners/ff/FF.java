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
import fr.uga.pddl4j.exceptions.FileException;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.heuristics.relaxation.HeuristicToolKit;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.Statistics;
import fr.uga.pddl4j.planners.hc.EHC;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.MemoryAgent;
import fr.uga.pddl4j.util.Plan;
import fr.uga.pddl4j.util.SequentialPlan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

/**
 * This class implements Fast Forward planner based on Enforced Hill Climbing Algorithm and
 * Gready Best First Search.
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
    public static final Heuristic.Type DEFAULT_HEURISTIC = Heuristic.Type.FAST_FORWARD;

    /**
     * The default weight of the heuristic.
     */
    public static final double DEFAULT_WEIGHT = 1.00;

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
     * The time needed to search a solution plan.
     */
    private long searchingTime;

    /**
     * Creates a new planner.
     */
    public FF() {
        super();
        this.setHeuristicType(FF.DEFAULT_HEURISTIC);
        this.setWeight(FF.DEFAULT_WEIGHT);
        this.setTimeOut(FF.DEFAULT_TIMEOUT);
        this.setSaveState(FF.DEFAULT_STATISTICS);
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
            final Properties arguments = AbstractPlanner.parseArguments(args, LOGGER, FF.getDefaultArguments());
            final File domain = (File) arguments.get(AbstractPlanner.Argument.DOMAIN);
            final File problem = (File) arguments.get(AbstractPlanner.Argument.PROBLEM);
            final int traceLevel = (Integer) arguments.get(AbstractPlanner.Argument.TRACE_LEVEL);
            final int timeout = (Integer) arguments.get(AbstractPlanner.Argument.TIMEOUT);
            final Heuristic.Type heuristicType = (Heuristic.Type) arguments.get(AbstractPlanner.Argument.HEURISTIC);
            final double weight = (Double) arguments.get(AbstractPlanner.Argument.WEIGHT);
            final boolean saveStats = (Boolean) arguments.get(AbstractPlanner.Argument.STATISTICS);

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
                    strb.append(String.format("%nplan total cost: %4.2f%n%n", plan.cost()));

                } else {
                    strb.append(String.format("%nno plan found%n"));
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
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     */
    private static Properties getDefaultArguments() {
        final Properties options = new Properties();
        options.put(AbstractPlanner.Argument.HEURISTIC, FF.DEFAULT_HEURISTIC);
        options.put(AbstractPlanner.Argument.WEIGHT, FF.DEFAULT_WEIGHT);
        options.put(AbstractPlanner.Argument.TIMEOUT, FF.DEFAULT_TIMEOUT * 1000);
        options.put(AbstractPlanner.Argument.TRACE_LEVEL, FF.DEFAULT_TRACE_LEVEL);
        options.put(AbstractPlanner.Argument.STATISTICS, FF.DEFAULT_STATISTICS);
        return options;
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
     * Is statistics generate or not.
     *
     * @return true if statistics are compute and save, false otherwise
     */
    public boolean isSaveState() {
        return saveState;
    }

    /**
     * Set the statistics generation value.
     *
     * @param saveState the new statistics computation value
     */
    public void setSaveState(boolean saveState) {
        this.saveState = saveState;
    }

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param pb the problem to solve.
     */
    @Override
    public SequentialPlan search(final CodedProblem pb) {
        Objects.requireNonNull(pb);
        searchingTime = 0;

        final EHC ehc = new EHC(this.getHeuristicType(), this.getHeuristicWeight(),
            this.getTimeout(), this.isSaveState());

        SequentialPlan solutionPlan = ehc.search(pb);

        if (solutionPlan != null) {
            LOGGER.trace("\nstarting enforced hill climbing");
            return solutionPlan;
        } else {
            LOGGER.trace("\nenforced hill climbing failed\n");
            LOGGER.trace("starting greedy best first search\n");
            final Node solutionNode = this.greedyBestFirstSearch(pb);

            if (solutionNode == null) {
                LOGGER.trace("\ngreedy best first search failed\n");
                return null;
            } else {
                return extract(solutionNode, pb);
            }
        }
    }

    /**
     * Extracts a search from a specified node.
     *
     * @param node    the node.
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
     * The greedy best first search algorithm. Solves the planning problem and returns the first solution plan found.
     * This method must be completed.
     *
     * @param problem the coded planning problem to solve.
     * @return a solution plan or null if it does not exist.
     */
    private Node greedyBestFirstSearch(final CodedProblem problem) {
        final long begin = System.currentTimeMillis();
        final Heuristic heuristic = HeuristicToolKit.createHeuristic(this.getHeuristicType(), problem);
        final Set<Node> closeSet = new HashSet<>();
        final Set<Node> openSet = new HashSet<>();
        final int timeout = this.getTimeout() * 1000;
        Node solution = null;

        BitState init = new BitState(problem.getInit());
        Node root = new Node(init, null, 0, 0, heuristic.estimate(init, problem.getGoal()));
        root.setDepth(0);
        openSet.add(root);

        while (!openSet.isEmpty() && solution == null && searchingTime < timeout) {
            // Pop the first node in the pending list open
            final Node current = this.popPriorityNode(openSet);

            if (current.satisfy(problem.getGoal())) {
                solution = current;
            } else {
                closeSet.add(current);
                int index = 0;
                for (BitOp op : problem.getOperators()) {

                    // Test if a specified operator is applicable in the current state
                    if (op.isApplicable(current)) {
                        final BitState nextState = new BitState(current);
                        nextState.or(op.getCondEffects().get(0).getEffects().getPositive());
                        nextState.andNot(op.getCondEffects().get(0).getEffects().getNegative());

                        // Apply the effect of the applicable operator
                        final Node successor = new Node(nextState);
                        successor.setCost(current.getCost() + op.getCost());
                        successor.setHeuristic(heuristic.estimate(nextState, problem.getGoal()));
                        successor.setParent(current);
                        successor.setOperator(index);
                        successor.setDepth(current.getDepth() + 1);
                        openSet.add(successor);
                    }
                    index++;
                }
            }
            // Take time to compute the searching time
            long end = System.currentTimeMillis();
            searchingTime = end - begin;
        }

        if (isSaveState()) {
            // Compute the searching time
            this.getStatistics().setTimeToSearch(searchingTime);
            // Compute the memory used by the search
            this.getStatistics().setMemoryUsedToSearch(MemoryAgent.deepSizeOf(closeSet)
                + MemoryAgent.deepSizeOf(openSet) + MemoryAgent.deepSizeOf(heuristic));
        }

        return solution;
    }

    /**
     * Get a node from a list of nodes.
     *
     * @param states the list of nodes (successors).
     * @return the node from the list.
     */
    private Node popPriorityNode(Collection<Node> states) {
        Node state = null;
        if (!states.isEmpty()) {
            final Iterator<Node> i = states.iterator();
            state = i.next();
            while (i.hasNext()) {
                final Node next = i.next();
                if (next.getHeuristic() < state.getHeuristic()) {
                    state = next;
                }
            }
            states.remove(state);
        }
        return state;
    }
}
