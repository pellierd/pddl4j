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

package fr.uga.pddl4j.planners;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.parser.PDDLParser;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.problem.Problem;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This abstract class defines the main methods to access a planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public abstract class AbstractPlanner<T extends Problem> implements Planner<T> {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(AbstractPlanner.class.getName());

    /**
     * The configuration of the planner.
     */
    private Configuration configuration;

    /**
     * The parser of the planner.
     */
    private PDDLParser parser;

    /**
     * The statistics of the planner.
     */
    private Statistics statistics;

    /**
     * Creates a new planner.
     *
     */
    public AbstractPlanner() {
        super();
        this.parser = new PDDLParser();
        this.statistics = new Statistics();
        this.setConfiguration(Planner.getDefaultConfiguration());
    }

    /**
     * Creates a new planner with a specific configuration.
     *
     * @parama config the configuration of the planner.
     *
     */
    public AbstractPlanner(Configuration configuration) {
        this();
        this.setConfiguration(configuration);
    }

    /**
     * Parses the domain and the problem description from the specified parameters.
     *
     * @param domain the path to the PDDL domain file.
     * @param problem the path to the PDDL problem file.
     * @throws FileNotFoundException if the domain or the problem file was not found.
     * @throws IOException           if an error occur during parsing.
     */
    public ErrorManager parse(final String domain, final String problem) throws IOException {
        this.parser.parse(domain, problem);
        return parser.getErrorManager();
    }

    /**
     * Parses the domain and the problem description using the configuration of the planner.
     *
     * @throws FileNotFoundException if the domain or the problem file was not found.
     * @throws IOException if an error occur during parsing.
     */
    public ErrorManager parse() throws IOException {
        this.parser.parse(this.configuration.getDomain(), this.configuration.getProblem());
        return parser.getErrorManager();
    }


    public Configuration getConfiguration() {
        return this.configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
        //this.setTraceLevel(configuration.getTraceLevel());
    }

    protected PDDLParser getParser() {
        return this.parser;
    }

    /**
     * Sets the trace level of the planner.
     *
     //* @param level the trace level of the planner.
     */
    private void setTraceLevel(final Level level) {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        org.apache.logging.log4j.core.config.Configuration config = context.getConfiguration();
        LoggerConfig loggerConfig = config.getRootLogger();
        loggerConfig.setLevel(level);
        context.updateLoggers();
//        System.out.println("LEVEL SET TO " + level +  " " + getLogger().getName());
    }

    /**
     * Returns the statistics of the planner.
     *
     * @return the statistics of the planner or null if no problem was solved.
     * @see Statistics
     */
    @Override
    public final Statistics getStatistics() {
        return this.statistics;
    }


    /**
     * Check the planner configuration
     * @return
     */
    public abstract boolean checkConfiguration();

    public Plan solve() throws FileNotFoundException {
        if (!this.checkConfiguration()) {
            throw new RuntimeException("Invalid planner configuration");
        }

        final Configuration config = this.getConfiguration();
        this.setTraceLevel(config.getTraceLevel());

        // Parses the PDDL domain and problem description
        long begin = System.currentTimeMillis();
        this.parser.parse(config.getDomain(), config.getProblem());
        ErrorManager errorManager = this.parser.getErrorManager();
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
                || !errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty()) {
                return null;
            }
        } else if (LOGGER.isInfoEnabled()) {
            StringBuilder strb = new StringBuilder();
            strb.append("\nparsing domain file \"");
            strb.append(config.getDomainFile().getName());
            strb.append("\" done successfully");
            strb.append("\nparsing problem file \"");
            strb.append(config.getProblemFile().getName());
            strb.append("\" done successfully");
            strb.append("\n");
            LOGGER.info(strb);
        }

        // Encodes and instantiates the problem in a compact representation

        begin = System.currentTimeMillis();

        T pb = this.instantiate();
        this.getStatistics().setTimeToEncode(System.currentTimeMillis() - begin);
        //this.getStatistics().setMemoryUsedForProblemRepresentation(MemoryAgent.getDeepSizeOf(pb));

        if (pb != null) {

            this.getStatistics().setNumberOfActions(pb.getActions().size());
            this.getStatistics().setNumberOfRelevantFluents(pb.getFluents().size());
            if (LOGGER.isInfoEnabled()) {
                StringBuilder strb = new StringBuilder();
                strb.append("\nproblem instantiation done successfully (");
                strb.append(this.getStatistics().getNumberOfActions());
                strb.append(" actions, ");
                strb.append(this.getStatistics().getNumberOfRelevantFluents());
                strb.append(" fluents)\n");
                LOGGER.info(strb);
            }
            if (LOGGER.isInfoEnabled() && !pb.isSolvable()) {
                StringBuilder strb = new StringBuilder();
                strb.append(String.format("goal can be simplified to FALSE. no search will solve it%n%n"));
                LOGGER.info(strb);
            }

            // Searches for a solution plan
            final Plan plan = this.solve(pb);

            if (LOGGER.isInfoEnabled()) {
                final StringBuilder strb = new StringBuilder();
                if (plan != null) {
                    strb.append(String.format("%nfound plan as follows:%n%n"));
                    strb.append(pb.toString(plan));
                } else {
                    strb.append(String.format("%nno plan found%n%n"));
                }
                double timeToParseInSeconds = Statistics.millisecondToSecond(this.getStatistics().getTimeToParse());
                strb.append(String.format("%ntime spent:   %8.2f seconds parsing %n", timeToParseInSeconds));
                double timeToEncodeInSeconds = Statistics.millisecondToSecond(this.getStatistics().getTimeToEncode());
                strb.append(String.format("              %8.2f seconds encoding %n", timeToEncodeInSeconds));
                double timeToSearchInSeconds = Statistics.millisecondToSecond(this.getStatistics().getTimeToSearch());
                strb.append(String.format("              %8.2f seconds searching%n", timeToSearchInSeconds));
                double totalTimeInSeconds = timeToParseInSeconds + timeToEncodeInSeconds + timeToSearchInSeconds;
                strb.append(String.format("              %8.2f seconds total time%n", totalTimeInSeconds));


                double memoryForProblemInMBytes = Statistics.byteToMByte(this.getStatistics().getMemoryUsedForProblemRepresentation());
                strb.append(String.format("%nmemory used:  %8.2f MBytes for problem representation%n",
                    memoryForProblemInMBytes));
                double memoryUsedToSearchInMBytes = Statistics.byteToMByte(this.getStatistics().getMemoryUsedToSearch());
                strb.append(String.format("              %8.2f MBytes for searching%n",
                    memoryUsedToSearchInMBytes));
                double totalMemoryInMBytes = memoryForProblemInMBytes + memoryUsedToSearchInMBytes;
                strb.append(String.format("              %8.2f MBytes total%n%n%n", totalMemoryInMBytes));

                LOGGER.info(strb);
            }
            return plan;
        } else {
            return null;
        }
    }
}
