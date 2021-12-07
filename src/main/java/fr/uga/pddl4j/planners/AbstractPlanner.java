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
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.problem.Problem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;

import org.openjdk.jol.info.GraphLayout;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
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
     * The path to the domain of the planner.
     */
    private String domain;

    /**
     * The path to the problem of the planner.
     */
    private String problem;

    /**
     * The timeout of the planner in milliseconds.
     */
    private int timeout;

    /**
     * The parser of the planner.
     */
    private PDDLParser parser;

    /**
     * The parsed problem.
     */
    private ParsedProblem parsedProblem;

    /**
     * The instantiated problem.
     */
    private Problem instantiateProblem;

    /**
     * The statistics of the planner.
     */
    private Statistics statistics;

    /**
     * Creates a new planner.
     */
    public AbstractPlanner() {
        super();
        this.setConfiguration(Planner.getDefaultConfiguration());
        this.parser = new PDDLParser();
        this.statistics = new Statistics();
        this.parsedProblem = null;
        this.instantiateProblem = null;
    }

    /**
     * Creates a new planner with a specific configuration.
     *
     * @param configuration the configuration of the planner.
     */
    public AbstractPlanner(PlannerConfiguration configuration) {
        this();
        this.setConfiguration(configuration);
    }

    /**
     * Sets the domain of the planner.
     *
     * @param domain the path to the PDDL domain file.
     */
    @Parameters(index = "0", description = "The domain file.")
    public final void setDomain(final String domain) {
        this.domain = domain;
    }

    /**
     * Returns the path to the PDDL domain file.
     *
     * @return the path to the PDDL domain file of the configuration or null if the domain is not initialized.
     */
    public final String getDomain() {
        return this.domain;
    }

    /**
     * Returns the domain file containing the PDDL domain description.
     *
     * @return the domain file containing the PDDL domain description or null if the domain is not initialized.
     */
    public final File getDomainFile() {
        return this.getDomain() == null ? null : new File(this.getDomain());
    }

    /**
     * Sets the path to the PDDL problem description.
     *
     * @param problem the path to the PDDL problem description.
     */
    @Parameters(index = "1", description = "The problem file.")
    public final void setProblem(final String problem) {
        this.problem = problem;
    }

    /**
     * Returns the path to the PDDL problem description.
     *
     * @return the path to the PDDL problem description or null if the problem is not initialized.
     */
    public final String getProblem() {
        return this.problem;
    }

    /**
     * Returns the problem file containing the PDDL problem description.
     *
     * @return the problem file containing the PDDL problem description or null if the problem is not initialized.
     */
    public final File getProblemFile() {
        return this.getProblem() == null ? null : new File(this.getProblem());
    }

    /**
     * Sets the log level of the planner.
     *
     * @param log the log of the planner.
     * @see java.util.logging.Level
     */
    @Option(names = { "-l", "--log" }, defaultValue = "INFO", converter = LogLevel.class,
        description = "Set the level of trace of the planner: ALL, DEBUG, INFO, ERROR, FATAL, OFF, TRACE "
            + "(preset INFO).")
    public final void setLogLevel(final LogLevel log) {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        org.apache.logging.log4j.core.config.Configuration config = context.getConfiguration();
        LoggerConfig loggerConfig = config.getRootLogger();
        loggerConfig.setLevel(log.getLevel());
        context.updateLoggers();

    }

    /**
     * Returns the log of the planner.
     *
     * @return the trace level declared of the planner.
     * @see java.util.logging.Level
     */
    public final LogLevel getLogLevel() {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        org.apache.logging.log4j.core.config.Configuration config = context.getConfiguration();
        LoggerConfig loggerConfig = config.getRootLogger();
        return new LogLevel(loggerConfig.getLevel());
    }

    /**
     * Sets the timeout of the planner.
     *
     * @param timeout to use by the planner in second. The timeout must greater than 0.
     * @throws IllegalArgumentException if the timeout is strictly less than 0.
     */
    @Option(names = { "-t", "--timeout" }, defaultValue = "600", description = "Set the time out of the planner in "
         + "seconds" + " (preset 600s).")
    public final void setTimeout(int timeout) {
        if (timeout <= 0) {
            throw new IllegalArgumentException("time out must be greater than 0");
        }
        this.timeout = timeout;
    }

    /**
     * Returns the timeout of the planner.
     *
     * @return the timeout of the planner
     */
    public final int getTimeout() {
        return this.timeout;
    }

    /**
     * Parses the domain and the problem description from the specified parameters.
     *
     * @param domain the path to the PDDL domain file.
     * @param problem the path to the PDDL problem file.
     * @return the problem parsed.
     * @throws FileNotFoundException if the domain or the problem file was not found.
     * @throws IOException           if an error occur during parsing.
     */
    public ParsedProblem parse(final String domain, final String problem) throws IOException {
        this.parsedProblem = this.parser.parse(domain, problem);
        return this.parsedProblem;
    }

    /**
     * Parses the domain and the problem description using the configuration of the planner.
     *
     * @return the problem parsed.
     * @throws FileNotFoundException if the domain or the problem file was not found.
     * @throws IOException if an error occur during parsing.
     */
    public ParsedProblem parse() throws IOException {
        this.parsedProblem = this.parser.parse(this.getDomain(), this.getProblem());
        return this.parsedProblem;
    }

    /*
     * Returns the parser error manager to get the messages generated while parsing.
     *
     * @return the parser error manger.
     */
    public ErrorManager getParserErrorManager() {
        return this.parser.getErrorManager();
    }

    /**
     * Checks the planner configuration and returns if the configuration is valid. A configuration is valid if (1) the
     * domain and the problem files exist and can be read and (2) the timeout is greater than 0.
     *
     * @return <code>true</code> if the configuration is valid <code>false</code> otherwise.
     */
    public boolean hasValidConfiguration() {
        return this.getDomainFile().exists() && this.getDomainFile().canRead()
            && this.getProblemFile().exists() && this.getProblemFile().canRead()
            && this.getTimeout() > 0;
    }

    /**
     * Returns the configuration of the planner.
     *
     * @return the configuration of the planner.
     */
    public PlannerConfiguration getConfiguration() {
        final PlannerConfiguration config =  new PlannerConfiguration();
        config.setProperty(Planner.DOMAIN_SETTING, this.getDomain());
        config.setProperty(Planner.PROBLEM_SETTING, this.getProblem());
        config.setProperty(Planner.TIME_OUT_SETTING, Integer.toString(this.getTimeout()));
        config.setProperty(Planner.LOG_LEVEL_SETTING, this.getLogLevel().toString());
        return config;
    }

    /**
     * Sets the configuration of the planner. If a planner setting is not defined in the specified configuration, the
     * setting is initialized with its default value.
     *
     * @param configuration the configuration to set.
     */
    public void setConfiguration(final PlannerConfiguration configuration) {
        if (configuration.getProperty(Planner.DOMAIN_SETTING) == null) {
            this.setDomain(Planner.DEFAULT_DOMAIN);
        } else {
            this.setDomain(configuration.getProperty(Planner.DOMAIN_SETTING));
        }
        if (configuration.getProperty(Planner.PROBLEM_SETTING) == null) {
            this.setProblem(Planner.DEFAULT_PROBLEM);
        } else {
            this.setProblem(configuration.getProperty(Planner.PROBLEM_SETTING));
        }
        if (configuration.getProperty(Planner.TIME_OUT_SETTING) == null) {
            this.setTimeout(Planner.DEFAULT_TIME_OUT);
        } else {
            this.setTimeout(Integer.parseInt(configuration.getProperty(Planner.TIME_OUT_SETTING)));
        }
        if (configuration.getProperty(Planner.LOG_LEVEL_SETTING) == null) {
            this.setLogLevel(Planner.DEFAULT_LOG_LEVEL);
        } else {
            this.setLogLevel(new LogLevel(configuration.getProperty(Planner.LOG_LEVEL_SETTING)));
        }
    }

    /**
     * Returns the parser used by the planner to parse PDDL domain and problem files.
     *
     * @return the parser used by the planner.
     */
    protected PDDLParser getParser() {
        return this.parser;
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
     * Solves the problem as defined by the planner configuration.
     *
     * @return the solution plan found or null is no solution was found.
     * @throws FileNotFoundException domain of problem files does not exist.
     */
    public Plan solve() throws FileNotFoundException {
        if (!this.hasValidConfiguration()) {
            throw new RuntimeException("Invalid planner configuration");
        }

        // Parses the PDDL domain and problem description
        long begin = System.currentTimeMillis();
        final ParsedProblem parsedProblem = this.parser.parse(this.getDomain(), this.getProblem());
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

        T pb = this.instantiate(parsedProblem);
        this.getStatistics().setTimeToEncode(System.currentTimeMillis() - begin);
        this.getStatistics().setMemoryUsedForProblemRepresentation(GraphLayout.parseInstance(pb).totalSize());

        if (pb != null) {

            this.getStatistics().setNumberOfActions(pb.getActions().size());
            this.getStatistics().setNumberOfRelevantFluents(pb.getFluents().size());
            if (LOGGER.isInfoEnabled()) {
                StringBuilder strb = new StringBuilder();
                strb.append("\nproblem instantiation done successfully (");
                strb.append(this.getStatistics().getNumberOfActions());
                strb.append(" actions, ");
                strb.append(this.getStatistics().getNumberOfRelevantFluents());
                strb.append(" fluents)\n\n");
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


                double memoryForProblemInMBytes = Statistics.byteToMByte(
                    this.getStatistics().getMemoryUsedForProblemRepresentation());
                strb.append(String.format("%nmemory used:  %8.2f MBytes for problem representation%n",
                    memoryForProblemInMBytes));
                double memoryUsedToSearchInMBytes = Statistics.byteToMByte(
                    this.getStatistics().getMemoryUsedToSearch());
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

    /**
     * This method contains the code called by the main method of the planner when planner are launched from
     * command line.
     *
     * @return the exit return value of the planner: O if every thing is ok; 1 otherwise.
     */
    @Override
    public Integer call() {
        try {
            this.solve();
        } catch (FileNotFoundException e) {
            LOGGER.fatal(e.getMessage());
            return 1;
        }
        return 0;
    }
}
