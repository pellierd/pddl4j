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
 * An example of an implementation of a SAT planner that can be used with the PDDL4J library
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
     * The class logger
     */
    private static final Logger LOGGER = LogManager.getLogger(SATPlannerExample.class.getName());

    /**
     * Creates a new SAT planner with the default configuration
     */
    public SATPlannerExample() {
        super();
    }

    /**
     * Creates a new SAT planner with the specified configuration
     * @param configuration     the configuration of the planner
     */
    public SATPlannerExample(final PlannerConfiguration configuration) {
        super(configuration);
    }

    @Override
    public SATEncoding getSATEncodingFromName(String encodingName) throws ProblemNotSupportedException {
        if (encodingName.equals("EXAMPLE")) return new SATEncodingExample();
        return super.getSATEncodingFromName(encodingName);
    }

    @Override
    public IpasirSolver getSATSolverFromName(String solverName) throws ProblemNotSupportedException {
        if (solverName.equals("MERGESAT")) return MergesatWrapper.createSolver();
        return super.getSATSolverFromName(solverName);
    }

    /**
     * Launches the planner from the command line
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
