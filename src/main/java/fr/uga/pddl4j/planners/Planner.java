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
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.plan.Plan;

import fr.uga.pddl4j.problem.Problem;
import org.apache.logging.log4j.Level;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
 * This interface defines the main methods of to access a planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public interface Planner<T extends Problem> extends Serializable {

    /**
     * Returns the configuration of the planner.
     *
     * @return the configuration of the planner.
     */
    Configuration getConfiguration();

    /**
     * Sets the configuration of the planner.
     *
     * @param configuration the configuration to set.
     */
    void setConfiguration(Configuration configuration);

    /**
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     * @see Configuration
     */
    static Configuration getDefaultConfiguration() {
        return new Configuration();
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
    ParsedProblem parse(final String domain, final String problem) throws IOException;

    /**
     * Parses the domain and the problem description given ine the planner configuration.
     *
     * @return the problem parsed or null if an error occurred while parsing.
     * @throws FileNotFoundException if the domain or the problem file was not found.
     * @throws IOException if an error occur during parsing.
     */
    ParsedProblem parse() throws IOException;

    /**
     * Returns the parser error manager to get the messages generated while parsing.
     *
     * @return the parser error manger.
     */
    ErrorManager getParserErrorManager();

    /**
     * Instantiates the planning problem from the
     *
     * @return the instantiated planning problem or null if the problem cannot be instantiated.
     */
    T instantiate(ParsedProblem problem);

    /**
     * Search a plan for the specified planning problem.
     *
     * @param problem the problem to be solved. The problem cannot be null.
     * @return the solution plan or null is no solution was found.
     */
    Plan solve(final T problem);

    /**
     * Search a plan for the current planner configuration.
     *
     * @return the solution plan or null is no solution was found.
     */
    Plan solve() throws FileNotFoundException;


    /**
     * Returns the statistics of the planner.
     *
     * @return the statistics of the planner.
     * @see Statistics
     */
    Statistics getStatistics();


}
