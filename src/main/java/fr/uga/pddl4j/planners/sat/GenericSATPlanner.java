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

package fr.uga.pddl4j.planners.sat;

import fr.uga.pddl4j.planners.PlannerConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

/**
 * A class used to create a new SAT planner.
 */
@CommandLine.Command(name = "GenericSATPlanner",
    version = "GenericSATPlanner 1.0",
    description = "Solves a specified planning problem using a SAT solver.",
    sortOptions = false,
    mixinStandardHelpOptions = true,
    headerHeading = "Usage:%n",
    synopsisHeading = "%n",
    descriptionHeading = "%nDescription:%n%n",
    parameterListHeading = "%nParameters:%n",
    optionListHeading = "%nOptions:%n")
public class GenericSATPlanner extends AbstractSATPlanner {
    /**
     * The class logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(GenericSATPlanner.class.getName());

    /**
     * Creates a new SAT planner with the default configuration.
     */
    public GenericSATPlanner() {
        super();
    }

    /**
     * Creates a new SAT planner with the specified configuration.
     * @param configuration     the configuration of the planner
     */
    public GenericSATPlanner(final PlannerConfiguration configuration) {
        super(configuration);
    }

    /**
     * Launches the planner from the command line.
     * For example :
     * <br>
     * <code>
     *      java -cp classes:lib/pddl4j-4.0.0.jar<br>
     *              fr.uga.pddl4j.planners.sat.GenericSATPlanner<br>
     *              domain.pddl<br>
     *              problem.pddl<br>
     *              -s MERGESAT<br>
     *              -e DEFAULT<br>
     *              -mpl 1000<br>
     *              -t 10
     * </code>
     * <br><br>
     * Where :<br>
     *      <code>domain.pddl</code> is the domain PDDL file<br>
     *      <code>problem.pddl</code> is the problem PDDL file<br>
     *      <code>MERGESAT</code> is the SAT solver<br>
     *      <code>DEFAULT</code> is the SAT encoding<br>
     *      <code>1000</code> is the maximum plan length (maximum number of actions)<br>
     *      <code>10</code> is the timeout (in seconds)<br>
     * @param args  the arguments of the command line
     */
    public static void main(String[] args) {
        try {
            final GenericSATPlanner planner = new GenericSATPlanner();
            CommandLine cmd = new CommandLine(planner);
            cmd.execute(args);
        } catch (IllegalArgumentException e) {
            LOGGER.fatal(e.getMessage());
        }
    }
}
