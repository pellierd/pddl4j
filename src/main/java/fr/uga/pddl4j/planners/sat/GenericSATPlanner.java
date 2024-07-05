package fr.uga.pddl4j.planners.sat;

import fr.uga.pddl4j.planners.PlannerConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

/**
 * A class used to create a new SAT planner
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
     * The class logger
     */
    private static final Logger LOGGER = LogManager.getLogger(GenericSATPlanner.class.getName());

    /**
     * Creates a new SAT planner with the default configuration
     */
    public GenericSATPlanner() {
        super();
    }

    /**
     * Creates a new SAT planner with the specified configuration
     * @param configuration     the configuration of the planner
     */
    public GenericSATPlanner(final PlannerConfiguration configuration) {
        super(configuration);
    }

    /**
     * Launches the planner from the command line
     * For example :
     *      java -cp classes:lib/pddl4j-4.0.0.jar
     *              fr.uga.pddl4j.planners.sat.GenericSATPlanner
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
            final GenericSATPlanner planner = new GenericSATPlanner();
            CommandLine cmd = new CommandLine(planner);
            cmd.execute(args);
        } catch (IllegalArgumentException e) {
            LOGGER.fatal(e.getMessage());
        }
    }
}
