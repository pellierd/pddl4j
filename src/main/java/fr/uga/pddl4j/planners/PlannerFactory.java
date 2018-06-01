package fr.uga.pddl4j.planners;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.exceptions.FileException;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ff.FF;
import fr.uga.pddl4j.planners.hsp.HSP;
import fr.uga.pddl4j.util.MemoryAgent;
import fr.uga.pddl4j.util.Plan;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * This class defines the main methods to create planner.
 *
 * @author D. Pellier
 * @version 1.0 - 20.06.2017
 * @see Planner
 * @since 3.0
 */
public class PlannerFactory {

    /**
     * An instance of the class.
     */
    private static PlannerFactory instance = new PlannerFactory();

    /**
     * Returns an instance of this class.
     *
     * @return an instance of this class.
     */
    public static PlannerFactory getInstance() {
        return PlannerFactory.instance;
    }

    /**
     * The state to use Memory agent or not.
     */
    private static boolean memoryAgent;

    /**
     * Returns if Memory Agent is used to inspect memory.
     *
     * @return the state of the memory agent.
     */
    public static boolean isMemoryAgent() {
        return memoryAgent;
    }

    /**
     * Sets if Memory Agent is used to inspect memory.
     *
     * @param memoryAgent the state of the memory agent.
     */
    public static void setMemoryAgent(boolean memoryAgent) {
        PlannerFactory.memoryAgent = memoryAgent;
    }

    /**
     * Creates a new PlannerFactory.
     * The constructor is override to
     */
    private PlannerFactory() {
        super();
        PlannerFactory.setMemoryAgent(false);
    }

    /**
     * Returns an instance of the specified planner.
     *
     * @param name the name of the planner.
     * @return an instance of the specified planner.
     * @see fr.uga.pddl4j.planners.Planner.Name
     */
    public Planner getPlanner(final Planner.Name name) {
        Planner planner = null;
        switch (name) {
            case HSP:
                planner = new HSP();
                break;

            case FF:
                planner = new FF();
                break;

            default:
                PlannerFactory.printUsage();
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
            .append("-p <num>    specifies the planner to used (preset: 0)\n")
            .append("     0      HSP planner\n")
            .append("     1      FF planner\n")
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
            .append("-m <bool>   use memory agent (preset: false)\n")
            .append("-h          print this message\n\n");

        return strb;
    }

    /**
     * This method parse the command line and return the arguments.
     *
     * @param args             the arguments from the command line.
     * @param log              the logger to display informations.
     * @param defaultArguments the default arguments to use.
     * @return The arguments of the planner.
     * @throws FileException if files not found
     */
    public static Properties parseArguments(String[] args, Logger log, Properties defaultArguments)
        throws FileException {

        final Properties arguments = defaultArguments;
        try {
            for (int i = 0; i < args.length; i += 2) {
                if ("-p".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int planner = Integer.parseInt(args[i + 1]);
                    if (planner == 0) {
                        arguments.put(AbstractPlanner.Argument.PLANNER, Planner.Name.HSP);
                    } else if (planner == 1) {
                        arguments.put(AbstractPlanner.Argument.PLANNER, Planner.Name.FF);
                    } else {
                        throw (new RuntimeException("Wrong planner argument"));
                    }
                } else if ("-o".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    if (!new File(args[i + 1]).exists()) {
                        log.trace("operators file does not exist: " + args[i + 1] + "\n");
                    }
                    arguments.put(AbstractPlanner.Argument.DOMAIN, new File(args[i + 1]));
                } else if ("-f".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    if (!new File(args[i + 1]).exists()) {
                        log.trace("facts file does not exist: " + args[i + 1] + "\n");
                    }
                    arguments.put(AbstractPlanner.Argument.PROBLEM, new File(args[i + 1]));
                } else if ("-t".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int cpu = Integer.parseInt(args[i + 1]) * 1000;
                    if (cpu < 0) {
                        log.trace(PlannerFactory.printUsage());
                    }
                    arguments.put(AbstractPlanner.Argument.TIMEOUT, cpu);
                } else if ("-u".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int heuristic = Integer.parseInt(args[i + 1]);
                    if (heuristic < 0 || heuristic > 8) {
                        log.trace(PlannerFactory.printUsage());
                    }
                    if (heuristic == 0) {
                        arguments.put(AbstractPlanner.Argument.HEURISTIC, Heuristic.Type.FAST_FORWARD);
                    } else if (heuristic == 1) {
                        arguments.put(AbstractPlanner.Argument.HEURISTIC, Heuristic.Type.SUM);
                    } else if (heuristic == 2) {
                        arguments.put(AbstractPlanner.Argument.HEURISTIC, Heuristic.Type.SUM_MUTEX);
                    } else if (heuristic == 3) {
                        arguments.put(AbstractPlanner.Argument.HEURISTIC, Heuristic.Type.AJUSTED_SUM);
                    } else if (heuristic == 4) {
                        arguments.put(AbstractPlanner.Argument.HEURISTIC, Heuristic.Type.AJUSTED_SUM2);
                    } else if (heuristic == 5) {
                        arguments.put(AbstractPlanner.Argument.HEURISTIC, Heuristic.Type.AJUSTED_SUM2M);
                    } else if (heuristic == 6) {
                        arguments.put(AbstractPlanner.Argument.HEURISTIC, Heuristic.Type.COMBO);
                    } else if (heuristic == 7) {
                        arguments.put(AbstractPlanner.Argument.HEURISTIC, Heuristic.Type.MAX);
                    } else {
                        arguments.put(AbstractPlanner.Argument.HEURISTIC, Heuristic.Type.SET_LEVEL);
                    }
                } else if ("-w".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final double weight = Double.parseDouble(args[i + 1]);
                    if (weight < 0) {
                        log.trace(PlannerFactory.printUsage());
                    }
                    arguments.put(AbstractPlanner.Argument.WEIGHT, weight);
                } else if ("-i".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final int level = Integer.parseInt(args[i + 1]);
                    if (level < 0) {
                        log.trace(PlannerFactory.printUsage());
                    }
                    arguments.put(AbstractPlanner.Argument.TRACE_LEVEL, level);
                } else if ("-m".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    PlannerFactory.setMemoryAgent(Boolean.parseBoolean(args[i + 1]));
                } else if ("-s".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                    final boolean isStatUsed = Boolean.parseBoolean(args[i + 1]);
                    arguments.put(AbstractPlanner.Argument.STATISTICS, isStatUsed);
                } else {
                    log.trace("\nUnknown argument for \"" + args[i] + "\" or missing value\n");
                    log.trace(PlannerFactory.printUsage());
                    throw new FileException("Unknown arguments: " + args[i]);
                }
            }
            if (arguments.get(AbstractPlanner.Argument.DOMAIN) == null
                || arguments.get(AbstractPlanner.Argument.PROBLEM) == null) {

                log.trace("\nMissing DOMAIN or PROBLEM\n");
                log.trace(PlannerFactory.printUsage());
                throw new FileException("Missing domain or problem");
            }
        } catch (RuntimeException runExp) {
            log.trace("\nError when parsing arguments\n");
            log.trace(PlannerFactory.printUsage());
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
     * -u <i>num</i>   specifies the planner to used (preset: 0)
     *      0      HSP planner
     *      1      FF planner
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
     * -m <i>bool</i>   use memory agent (preset: false)
     * -s <i>bool</i>   no statistics (preset: true)
     * -h          print this message
     *
     * </pre>
     *
     * @param args the arguments of the command line.
     */
    public static void main(String[] args) {
        final Logger logger = AbstractPlanner.getLogger();

        try {
            final PlannerFactory plannerFactory = PlannerFactory.getInstance();

            // Parse the command line
            final Properties arguments = PlannerFactory.parseArguments(args,
                logger, AbstractPlanner.getDefaultArguments());

            final File domain = (File) arguments.get(AbstractPlanner.Argument.DOMAIN);
            final File problem = (File) arguments.get(AbstractPlanner.Argument.PROBLEM);
            final int traceLevel = (Integer) arguments.get(AbstractPlanner.Argument.TRACE_LEVEL);
            final int timeout = (Integer) arguments.get(AbstractPlanner.Argument.TIMEOUT);
            final Heuristic.Type heuristicType = (Heuristic.Type) arguments.get(AbstractPlanner.Argument.HEURISTIC);
            final double weight = (Double) arguments.get(AbstractPlanner.Argument.WEIGHT);
            final boolean saveStats = (Boolean) arguments.get(AbstractPlanner.Argument.STATISTICS);

            // Creates the planner
            final Planner planner = plannerFactory.getPlanner((Planner.Name)
                arguments.get(AbstractPlanner.Argument.PLANNER));
            planner.setupPlanner(heuristicType, timeout, weight, saveStats, traceLevel);

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
                logger.trace(strb);
            }

            // Encodes and instantiates the problem in a compact representation
            begin = System.currentTimeMillis();
            final CodedProblem pb = factory.encode();
            if (saveStats) {
                planner.getStatistics().setTimeToEncode(System.currentTimeMillis() - begin);
                if (isMemoryAgent()) {
                    try {
                        planner.getStatistics().setMemoryUsedForProblemRepresentation(MemoryAgent.deepSizeOf(pb));
                    } catch (IllegalStateException ilException) {
                        logger.error(ilException);
                    }
                }
            }

            if (pb != null) {
                planner.getStatistics().setNumberOfActions(pb.getOperators().size());
                planner.getStatistics().setNumberOfRelevantFluents(pb.getRelevantFacts().size());

                if (traceLevel > 0 && traceLevel != 8) {
                    StringBuilder strb = new StringBuilder();
                    strb.append("\nencoding problem done successfully (")
                        .append(planner.getStatistics().getNumberOfActions()).append(" ops, ")
                        .append(planner.getStatistics().getNumberOfRelevantFluents()).append(" facts)\n");
                    logger.trace(strb);
                }

                if (traceLevel > 0 && traceLevel != 8 && !pb.isSolvable()) {
                    StringBuilder strb = new StringBuilder();
                    strb.append(String.format("goal can be simplified to FALSE. no search will solve it%n%n"));
                    logger.trace(strb);
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
                    if (isMemoryAgent()) {
                        memoryUsedToSearchInMBytes = Statistics.byteToMByte(planner.getStatistics()
                            .getMemoryUsedToSearch());
                        memoryForProblemInMBytes =
                            Statistics.byteToMByte(planner.getStatistics().getMemoryUsedForProblemRepresentation());
                        totalMemoryInMBytes = memoryForProblemInMBytes + memoryUsedToSearchInMBytes;
                    }
                }

                if (traceLevel > 0 && traceLevel != 8) {
                    final StringBuilder strb = new StringBuilder();
                    if (plan != null) {
                        strb.append(String.format("%nfound plan as follows:%n%n"));
                        strb.append(pb.toString(plan));
                        strb.append(String.format("%nplan total cost: %4.2f%n%n", plan.cost()));

                    } else {
                        strb.append(String.format("%nno plan found%n%n"));
                    }
                    if (saveStats) {
                        strb.append(String.format("%ntime spent:   %8.2f seconds parsing %n", timeToParseInSeconds));
                        strb.append(String.format("              %8.2f seconds encoding %n", timeToEncodeInSeconds));
                        strb.append(String.format("              %8.2f seconds searching%n", timeToSearchInSeconds));
                        strb.append(String.format("              %8.2f seconds total time%n", totalTimeInSeconds));
                        if (isMemoryAgent()) {
                            strb.append(String.format("%nmemory used:  %8.2f MBytes for problem representation%n",
                                memoryForProblemInMBytes));
                            strb.append(String.format("              %8.2f MBytes for searching%n",
                                memoryUsedToSearchInMBytes));
                            strb.append(String.format("              %8.2f MBytes total%n%n%n", totalMemoryInMBytes));
                        }
                    }
                    logger.trace(strb);
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
                    logger.trace(strb);
                }
            } else {
                logger.trace("encoding problem failed");
            }
        } catch (IOException ioExp) {
            logger.error(ioExp);
        } catch (FileException fileEx) {
            logger.error(fileEx);
            System.exit(1);
        }
    }
}
