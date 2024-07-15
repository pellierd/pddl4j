/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.examples.sat;

import com.github.liveontologies.ipasir4j.IpasirSolver;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.ProblemNotSupportedException;
import fr.uga.pddl4j.planners.sat.AbstractSATPlanner;
import fr.uga.pddl4j.planners.sat.encodings.SATEncoding;
import fr.uga.pddl4j.planners.sat.solvers.MergesatWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

/**
 * An example of an implementation of a SAT planner that can be used with the PDDL4J library.
 */
@CommandLine.Command(name = "SATPlannerExample",
    version = "SATPlannerExample 1.0",
    description = "Solves a specified planning problem using a SAT solver.",
    sortOptions = false,
    mixinStandardHelpOptions = true,
    headerHeading = "Usage:%n",
    synopsisHeading = "%n",
    descriptionHeading = "%nDescription:%n%n",
    parameterListHeading = "%nParameters:%n",
    optionListHeading = "%nOptions:%n")
public class SATPlannerExample extends AbstractSATPlanner {
    /**
     * The class logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(SATPlannerExample.class.getName());

    /**
     * Creates a new SAT planner with the default configuration.
     */
    public SATPlannerExample() {
        super();
    }

    /**
     * Creates a new SAT planner with the specified configuration.
     * @param configuration     the configuration of the planner
     */
    public SATPlannerExample(final PlannerConfiguration configuration) {
        super(configuration);
    }

    /**
     * Returns a new instance of the SAT encoding using the encoding name provided as argument.
     * @param encodingName the name of the encoding
     * @return a new instance of the corresponding encoding
     * @throws ProblemNotSupportedException if no such encoding exists
     */
    @Override
    public SATEncoding getSATEncodingFromName(String encodingName) throws ProblemNotSupportedException {
        if (encodingName.equals("EXAMPLE")) {
            return new SATEncodingExample();
        }
        return super.getSATEncodingFromName(encodingName);
    }

    /**
     * Returns a new instance of the SAT solver using the solver name provided as argument.
     * @param solverName the name of the solver
     * @return a new instance of the corresponding solver
     * @throws ProblemNotSupportedException if no such solver exists
     */
    @Override
    public IpasirSolver getSATSolverFromName(String solverName) throws ProblemNotSupportedException {
        if (solverName.equals("MERGESAT")) {
            return MergesatWrapper.createSolver();
        }
        return super.getSATSolverFromName(solverName);
    }

    /**
     * Launches the planner from the command line.
     * For example :
     *      java -cp classes:lib/pddl4j-4.0.0.jar
     *              fr.uga.pddl4j.examples.sat.SATPlannerExample
     *              domain.pddl
     *              problem.pddl
     *              -s MERGESAT
     *              -e DEFAULT
     *              -mpl 1000
     *              -t 10
     * Where :
     *      domain.pddl is the domain PDDL file
     *      problem.pddl is the problem PDDL file
     *      MERGESAT is the SAT solver
     *      DEFAULT is the SAT encoding
     *      1000 is the maximum plan length (maximum number of actions)
     *      10 is the timeout (in seconds)
     * @param args  the arguments of the command line
     */
    public static void main(String[] args) {
        try {
            final SATPlannerExample planner = new SATPlannerExample();
            CommandLine cmd = new CommandLine(planner);
            cmd.execute(args);
        } catch (IllegalArgumentException e) {
            LOGGER.fatal(e.getMessage());
        }
    }
}
