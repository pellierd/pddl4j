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

import fr.uga.pddl4j.parser.DefaultParsedProblem;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.plan.Plan;

import fr.uga.pddl4j.planners.htn.stn.PFD;
import fr.uga.pddl4j.planners.htn.stn.TFD;
import fr.uga.pddl4j.planners.statespace.FF;
import fr.uga.pddl4j.planners.statespace.GSP;
import fr.uga.pddl4j.planners.statespace.HSP;
import fr.uga.pddl4j.problem.Problem;
import org.apache.logging.log4j.Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * This interface defines the main methods of to access a planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public interface Planner extends Serializable, Callable<Integer> {

    /**
     * The DOMAIN setting used for planner configuration.
     */
    static final String DOMAIN_SETTING = "DOMAIN";

    /**
     * The default value of DOMAIN setting used for planner configuration.
     */
    static final String DEFAULT_DOMAIN = "NONE";

    /**
     * The PROBLEM setting used for planner configuration.
     */
    static final String PROBLEM_SETTING = "PROBLEM";

    /**
     * The default value of PROBLEM setting used for planner configuration.
     */
    static final String DEFAULT_PROBLEM = "NONE";

    /**
     * The TIME_OUT setting used for planner configuration.
     */
    static final String TIME_OUT_SETTING = "TIME_OUT";

    /**
     * The default value of TIME_OUT (in seconds) setting used for planner configuration.
     */
    static final int DEFAULT_TIME_OUT = 600;

    /**
     * The LOG_LEVEL setting used for planner configuration.
     */
    static final String LOG_LEVEL_SETTING = "LOG_LEVEL";

    /**
     * The default value of the LOG_LEVEL setting used for planner configuration.
     */
    static final LogLevel DEFAULT_LOG_LEVEL = new LogLevel(Level.INFO);

    /**
     * The enumeration of the planners.
     */
    enum Name {
        /**
         * The FF (Fast Forward) planner.
         */
        FF,

        /**
         * The GSP (Generic Search Planner).
         */
        GSP,

        /**
         * The HSP (Heuristic Search Planner).
         */
        HSP,

        /**
         * TFD (Total-order Forward Decomposition) planner.
         */
        TFD,

        /**
         * PFD (Partial-order Forward Decomposition) planner.
         */
        PFD,
    }

    /**
     * Sets the domain of the planner.
     *
     * @param domain the path to the PDDL domain file.
     */
    void setDomain(final String domain);

    /**
     * Returns the path to the PDDL domain file.
     *
     * @return the path to the PDDL domain file of the configuration.
     */
    String getDomain();

    /**
     * Returns the domain file containing the PDDL domain description.
     *
     * @return the domain file containing the PDDL domain description.
     */
    File getDomainFile();

    /**
     * Sets the path to the PDDL problem description.
     *
     * @param problem the path to the PDDL problem description.
     */
    void setProblem(final String problem);

    /**
     * Returns the path to the PDDL problem description.
     *
     * @return the path to the PDDL problem description.
     */
    String getProblem();

    /**
     * Returns the problem file containing the PDDL problem description.
     *
     * @return the problem file containing the PDDL problem description.
     */
    File getProblemFile();

    /**
     * Sets the trace level of the planner.
     *
     * @param level the trace level of the planner.
     * @see Level
     */
    void setLogLevel(final LogLevel level);

    /**
     * Returns the trace level of the planner.
     *
     * @return the trace level declared of the planner.
     * @see Level
     */
    LogLevel getLogLevel();

    /**
     * Sets the timeout of the planner.
     *
     * @param timeout to use by the planner in second.
     */
    void setTimeout(int timeout);

    /**
     * Returns the timeout of the planner.
     *
     * @return the timeout of the planner
     */
    int getTimeout();

    /**
     * Returns the configuration of the planner.
     *
     * @return the configuration of the planner.
     */
    PlannerConfiguration getConfiguration();

    /**
     * Sets the configuration of the planner.
     *
     * @param configuration the configuration to set.
     */
    void setConfiguration(PlannerConfiguration configuration);

    /**
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     * @see PlannerConfiguration
     */
    static PlannerConfiguration getDefaultConfiguration() {
        return new PlannerConfiguration();
    }

    /**
     * Parses the domain and the problem description specified in parameters.
     *
     * @param domain the path to the PDDL domain file.
     * @param problem the path to the PDDL problem file.
     * @return the problem parsed or null if an error occurred while parsing.
     * @throws FileNotFoundException if the domain or the problem file was not found.
     * @throws IOException if an error occur during parsing.
     */
    DefaultParsedProblem parse(final String domain, final String problem) throws IOException;

    /**
     * Parses the domain and the problem description given ine the planner configuration.
     *
     * @return the problem parsed or null if an error occurred while parsing.
     * @throws FileNotFoundException if the domain or the problem file was not found.
     * @throws IOException if an error occur during parsing.
     */
    DefaultParsedProblem parse() throws IOException;

    /**
     * Returns the parser error manager to get the messages generated while parsing.
     *
     * @return the parser error manger.
     */
    ErrorManager getParserErrorManager();

    /**
     * Instantiates the planning problem from a parsed problem.
     *
     * @param problem the problem to instantiate.
     * @return the instantiated planning problem or null if the problem cannot be instantiated.
     */
    Problem instantiate(DefaultParsedProblem problem);

    /**
     * Search a plan for the specified planning problem.
     *
     * @param problem the problem to be solved. The problem cannot be null.
     * @return the solution plan or null is no solution was found.
     * @throws ProblemNotSupportedException if the problem to solve is not supported.
     */
    Plan solve(final Problem problem) throws ProblemNotSupportedException;

    /**
     * Search a plan for the current planner configuration.
     *
     * @return the solution plan or null is no solution was found.
     * @throws InvalidConfigurationException if the planner has an invalid configuration to run.
     */
    Plan solve() throws InvalidConfigurationException;

    /**
     * Returns the statistics of the planner.
     *
     * @return the statistics of the planner.
     * @see Statistics
     */
    Statistics getStatistics();

    /**
     * Returns if the planner configuration is valid or not.
     *
     * @return <code>true</code> if the configuration is valide <code>false</code> otherwise.
    */
    boolean hasValidConfiguration();

    /**
     * Returns if a specified problem is supported by the planner.
     *
     * @param problem the problem to test.
     * @return <code>true</code> if the problem is supported <code>false</code> otherwise.
     */
    boolean isSupported(Problem problem);

    /**
     * Create an instance of a planner from a specified configuration.
     *
     * @param name    the name of the planner to create.
     * @param configuration the configuration of the planner.
     * @return the planner created.
     */
    static Planner getInstance(final Planner.Name name, final PlannerConfiguration configuration) {
        switch (name) {
            case FF:
                return new FF(configuration);
            case HSP:
                return new HSP(configuration);
            case GSP:
                return new GSP(configuration);
            case TFD:
                return new TFD(configuration);
            case PFD:
                return new PFD(configuration);
            default:
                return null;
        }
    }
}
