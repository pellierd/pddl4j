/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.planners.statespace;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.exceptions.FileException;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.Statistics;
import fr.uga.pddl4j.planners.statespace.ff.FF;
import fr.uga.pddl4j.planners.statespace.ff.FFAnytime;
import fr.uga.pddl4j.planners.statespace.hc.HCAnytime;
import fr.uga.pddl4j.planners.statespace.hsp.HSP;
import fr.uga.pddl4j.util.MemoryAgent;
import fr.uga.pddl4j.util.Plan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/**
 * This class defines the main methods to create state based planner.
 *
 * @author D. Pellier
 * @version 1.0 - 20.06.2017
 * @see Planner
 * @since 3.0
 */
public class StateSpacePlannerFactory implements Serializable {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The logger of the class.
     */
    private static Logger LOGGER = LogManager.getLogger(StateSpacePlannerFactory.class);

    /**
     * An instance of the class.
     */
    private static StateSpacePlannerFactory instance = new StateSpacePlannerFactory();

    /**
     * Returns an instance of this class.
     *
     * @return an instance of this class.
     */
    public static StateSpacePlannerFactory getInstance() {
        return StateSpacePlannerFactory.instance;
    }

    /**
     * Print cost in solution plan.
     */
    private static boolean ACTION_COST = false;

    /**
     * Creates a new StateSpacePlannerFactory.
     */
    private StateSpacePlannerFactory() {
        super();
    }

    /**
     * Returns an instance of the specified state based planner.
     *
     * @param name           the name of the state based planner.
     * @return an instance of the specified planner.
     * @see fr.uga.pddl4j.planners.Planner.Name
     */
    public AbstractStateSpacePlanner getPlanner(final Planner.Name name) {
        AbstractStateSpacePlanner planner = null;
        switch (name) {
            case HSP:
                planner = new HSP();
                break;

            case FF:
                planner = new FF();
                break;

            case FFAnytime:
                planner = new FFAnytime();
                break;

            case HCAnytime:
                planner = new HCAnytime();
                break;

            default:
                LOGGER.trace(StateSpacePlannerFactory.printUsage());
                break;
        }
        return planner;
    }

    /**
     * Returns an instance of the specified state based planner.
     *
     * @param name           the name of the state based planner.
     * @param statisticState the statistics generation value.
     * @param traceLevel     the trace level of the planner.
     * @return an instance of the specified planner.
     * @see fr.uga.pddl4j.planners.Planner.Name
     */
    public AbstractStateSpacePlanner getPlanner(final Planner.Name name, final boolean statisticState,
                                                final int traceLevel) {
        AbstractStateSpacePlanner planner = null;
        switch (name) {
            case HSP:
                planner = new HSP(statisticState, traceLevel);
                break;

            case FF:
                planner = new FF(statisticState, traceLevel);
                break;

            case FFAnytime:
                planner = new FFAnytime(statisticState, traceLevel);
                break;

            case HCAnytime:
                planner = new HCAnytime(statisticState, traceLevel);
                break;

            default:
                LOGGER.trace(StateSpacePlannerFactory.printUsage());
                break;
        }
        return planner;
    }

    /**
     * Returns an instance of the specified state based planner.
     *
     * @param name           the name of the state based planner.
     * @param timeout        the time out of the planner.
     * @param heuristicType  the heuristicType to use to solve the planning problem.
     * @param weight         the weight set to the heuristic.
     * @param statisticState the statistics generation value.
     * @param traceLevel     the trace level of the planner.
     * @return an instance of the specified planner.
     * @see fr.uga.pddl4j.planners.Planner.Name
     */
    public AbstractStateSpacePlanner getPlanner(final Planner.Name name, final int timeout,
                                                final Heuristic.Type heuristicType, final double weight,
                                                final boolean statisticState, final int traceLevel) {
        AbstractStateSpacePlanner planner = null;
        switch (name) {
            case HSP:
                planner = new HSP(timeout, heuristicType, weight, statisticState, traceLevel);
                break;

            case FF:
                planner = new FF(timeout, heuristicType, weight, statisticState, traceLevel);
                break;

            case FFAnytime:
                planner = new FFAnytime(timeout, heuristicType, weight, statisticState, traceLevel);
                break;

            case HCAnytime:
                planner = new HCAnytime(timeout, heuristicType, weight, statisticState, traceLevel);
                break;

            default:
                LOGGER.trace(StateSpacePlannerFactory.printUsage());
                break;
        }
        return planner;
    }

    /**
     * This method print the usage of the command-line planner.
     */
    private static StringBuilder printUsage() {

        final StringBuilder strb = new StringBuilder();

        strb.append("\nusage of PDDL4J:\n")
            .append("OPTIONS   DESCRIPTIONS\n")
            .append("-o <str>    operator file name\n")
            .append("-f <str>    fact file name\n")
            .append("-w <num>    the weight used in the a star seach (preset: 1)\n")
            .append("-t <num>    specifies the maximum CPU-time in seconds (preset: 300)\n")
            .append("-p <num>    specifies the state based planner to use (preset: 0)\n")
            .append("     0      HSP planner\n")
            .append("     1      FF planner\n")
            .append("     2      FF Anytime planner\n")
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
            .append("     9      min cost heuristic\n")
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
            .append("-d <bool>   print cost in solution plan (preset: false)\n")
            .append("-h          print this message\n\n");

        return strb;
    }

    /**
     * This method parse the command line and return the arguments.
     *
     * @param args             the arguments from the command line.
     * @param defaultArguments the default arguments to use.
     * @return The arguments of the planner.
     * @throws FileException if files not found
     */
    public static Properties parseArguments(String[] args, Properties defaultArguments)
        throws FileException {

        final Properties arguments = defaultArguments;
        try {
            for (int i = 0; i < args.length; i += 2) {
                if ("-p".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int planner = Integer.parseInt(args[i + 1]);
                    if (planner == 0) {
                        arguments.put(AbstractStateSpacePlanner.PLANNER, Planner.Name.HSP);
                    } else if (planner == 1) {
                        arguments.put(AbstractStateSpacePlanner.PLANNER, Planner.Name.FF);
                    } else if (planner == 2) {
                        arguments.put(AbstractStateSpacePlanner.PLANNER, Planner.Name.FFAnytime);
                    } else if (planner == 3) {
                        arguments.put(AbstractStateSpacePlanner.PLANNER, Planner.Name.HCAnytime);
                    } else {
                        throw (new RuntimeException("Wrong planner argument"));
                    }
                } else if ("-o".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    if (!new File(args[i + 1]).exists()) {
                        LOGGER.trace("operators file does not exist: " + args[i + 1] + "\n");
                    }
                    arguments.put(AbstractStateSpacePlanner.DOMAIN, new File(args[i + 1]));
                } else if ("-f".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    if (!new File(args[i + 1]).exists()) {
                        LOGGER.trace("facts file does not exist: " + args[i + 1] + "\n");
                    }
                    arguments.put(AbstractStateSpacePlanner.PROBLEM, new File(args[i + 1]));
                } else if ("-t".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int cpu = Integer.parseInt(args[i + 1]) * 1000;
                    if (cpu < 0) {
                        LOGGER.trace(StateSpacePlannerFactory.printUsage());
                    }
                    arguments.put(AbstractStateSpacePlanner.TIMEOUT, cpu);
                } else if ("-u".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int heuristic = Integer.parseInt(args[i + 1]);
                    if (heuristic < 0 || heuristic > 9) {
                        LOGGER.trace(StateSpacePlannerFactory.printUsage());
                    }
                    if (heuristic == 0) {
                        arguments.put(AbstractStateSpacePlanner.HEURISTIC,
                            Heuristic.Type.FAST_FORWARD);
                    } else if (heuristic == 1) {
                        arguments.put(AbstractStateSpacePlanner.HEURISTIC,
                            Heuristic.Type.SUM);
                    } else if (heuristic == 2) {
                        arguments.put(AbstractStateSpacePlanner.HEURISTIC,
                            Heuristic.Type.SUM_MUTEX);
                    } else if (heuristic == 3) {
                        arguments.put(AbstractStateSpacePlanner.HEURISTIC,
                            Heuristic.Type.AJUSTED_SUM);
                    } else if (heuristic == 4) {
                        arguments.put(AbstractStateSpacePlanner.HEURISTIC,
                            Heuristic.Type.AJUSTED_SUM2);
                    } else if (heuristic == 5) {
                        arguments.put(AbstractStateSpacePlanner.HEURISTIC,
                            Heuristic.Type.AJUSTED_SUM2M);
                    } else if (heuristic == 6) {
                        arguments.put(AbstractStateSpacePlanner.HEURISTIC,
                            Heuristic.Type.COMBO);
                    } else if (heuristic == 7) {
                        arguments.put(AbstractStateSpacePlanner.HEURISTIC,
                            Heuristic.Type.MAX);
                    } else if (heuristic == 8) {
                        arguments.put(AbstractStateSpacePlanner.HEURISTIC,
                            Heuristic.Type.SET_LEVEL);
                    } else {
                        arguments.put(AbstractStateSpacePlanner.HEURISTIC,
                            Heuristic.Type.MIN_COST);
                    }
                } else if ("-w".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final double weight = Double.parseDouble(args[i + 1]);
                    if (weight < 0) {
                        LOGGER.trace(StateSpacePlannerFactory.printUsage());
                    }
                    arguments.put(AbstractStateSpacePlanner.WEIGHT, weight);
                } else if ("-i".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int level = Integer.parseInt(args[i + 1]);
                    if (level < 0) {
                        LOGGER.trace(StateSpacePlannerFactory.printUsage());
                    }
                    arguments.put(AbstractStateSpacePlanner.TRACE_LEVEL, level);
                } else if ("-s".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final boolean isStatUsed = Boolean.parseBoolean(args[i + 1]);
                    arguments.put(AbstractStateSpacePlanner.STATISTICS, isStatUsed);
                } else if ("-d".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    ACTION_COST = Boolean.parseBoolean(args[i + 1]);
                } else {
                    LOGGER.trace("\nUnknown argument for \"" + args[i] + "\" or missing value\n");
                    LOGGER.trace(StateSpacePlannerFactory.printUsage());
                    throw new FileException("Unknown arguments: " + args[i]);
                }
            }
            if (arguments.get(AbstractStateSpacePlanner.DOMAIN) == null
                || arguments.get(AbstractStateSpacePlanner.PROBLEM) == null) {

                LOGGER.trace("\nMissing DOMAIN or PROBLEM\n");
                LOGGER.trace(StateSpacePlannerFactory.printUsage());
                throw new FileException("Missing domain or problem");
            }
        } catch (RuntimeException runExp) {
            LOGGER.trace("\nError when parsing arguments\n");
            LOGGER.trace(StateSpacePlannerFactory.printUsage());
            throw runExp;
        }
        return arguments;
    }

    /**
     * The main method of the <code>PDDL4J</code> example. The command line syntax is as follow:
     * <pre>
     * usage of PDDL4J:
     *
     * OPTIONS   DESCRIPTIONS
     *
     * -o <i>str</i>   operator file name
     * -f <i>str</i>   fact file name
     * -w <i>num</i>   the weight used in the a star search (preset: 1)
     * -t <i>num</i>   specifies the maximum CPU-time in seconds (preset: 300)
     * -u <i>num</i>   specifies the state based planner to use (preset: 0)
     *      0      HSP planner
     *      1      FF planner
     *      2      FF Anytime planner
     * -u <i>num</i>   specifies the heuristic to use (preset: 0)
     *      0      ff heuristic
     *      1      sum heuristic
     *      2      sum mutex heuristic
     *      3      adjusted sum heuristic
     *      4      adjusted sum 2 heuristic
     *      5      adjusted sum 2M heuristic
     *      6      combo heuristic
     *      7      max heuristic
     *      8      set-level heuristic
     *      9      min cost heuristic
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
     * -s <i>bool</i>   no statistics (preset: true)
     * -d <i>bool</i>   print cost in solution plan (preset: false)
     * -h          print this message
     *
     * </pre>
     *
     * @param args the arguments of the command line.
     */
    public static void main(String[] args) {
        try {
            final StateSpacePlannerFactory stateSpacePlannerFactory = StateSpacePlannerFactory.getInstance();

            // Parse the command line
            final Properties arguments = StateSpacePlannerFactory.parseArguments(args,
                StateSpacePlanner.getDefaultArguments());

            final Planner.Name plannerName = (Planner.Name) arguments.get(AbstractStateSpacePlanner.PLANNER);
            final File domain = (File) arguments.get(AbstractStateSpacePlanner.DOMAIN);
            final File problem = (File) arguments.get(AbstractStateSpacePlanner.PROBLEM);
            final int traceLevel = (Integer) arguments.get(AbstractStateSpacePlanner.TRACE_LEVEL);
            final int timeout = (Integer) arguments.get(AbstractStateSpacePlanner.TIMEOUT);
            final Heuristic.Type heuristicType = (Heuristic.Type) arguments.get(AbstractStateSpacePlanner.HEURISTIC);
            final double weight = (Double) arguments.get(AbstractStateSpacePlanner.WEIGHT);
            final boolean saveStats = (Boolean) arguments.get(AbstractStateSpacePlanner.STATISTICS);

            // Creates the planner
            final AbstractStateSpacePlanner planner = stateSpacePlannerFactory.getPlanner(plannerName, timeout,
                heuristicType, weight, saveStats, traceLevel);

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
            final CodedProblem pb = factory.encode();
            if (saveStats) {
                planner.getStatistics().setTimeToEncode(System.currentTimeMillis() - begin);
                planner.getStatistics().setMemoryUsedForProblemRepresentation(MemoryAgent.getDeepSizeOf(pb));
            }

            if (pb != null) {
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

                    memoryUsedToSearchInMBytes = Statistics.byteToMByte(planner.getStatistics()
                        .getMemoryUsedToSearch());
                    memoryForProblemInMBytes =
                        Statistics.byteToMByte(planner.getStatistics().getMemoryUsedForProblemRepresentation());
                    totalMemoryInMBytes = memoryForProblemInMBytes + memoryUsedToSearchInMBytes;
                }

                if (traceLevel > 0 && traceLevel != 8) {
                    final StringBuilder strb = new StringBuilder();
                    if (plan != null) {
                        strb.append(String.format("%nfound plan as follows:%n%n"));
                        if (ACTION_COST) {
                            strb.append(pb.toStringCost(plan));
                        } else {
                            strb.append(pb.toString(plan));
                        }

                        strb.append(String.format("%nplan total cost: %4.2f%n%n", plan.cost()));

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
            } else {
                LOGGER.trace("encoding problem failed");
            }
        } catch (IOException ioExp) {
            LOGGER.error(ioExp);
        } catch (FileException fileEx) {
            LOGGER.error(fileEx);
            System.exit(1);
        }
    }
}
