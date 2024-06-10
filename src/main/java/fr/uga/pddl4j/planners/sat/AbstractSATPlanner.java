package fr.uga.pddl4j.planners.sat;

import com.github.liveontologies.ipasir4j.SolverTerminatedException;
import fr.uga.pddl4j.parser.DefaultParsedProblem;
import fr.uga.pddl4j.parser.RequireKey;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.ProblemNotSupportedException;
import fr.uga.pddl4j.planners.sat.encodings.AbstractSATEncoding;
import fr.uga.pddl4j.planners.sat.encodings.DefaultSATEncoding;
import fr.uga.pddl4j.planners.sat.encodings.Encoding;
import fr.uga.pddl4j.planners.sat.solvers.SATSolver;
import fr.uga.pddl4j.problem.DefaultProblem;
import fr.uga.pddl4j.problem.Problem;
import picocli.CommandLine;

/**
 * An abstract class defining all general elements of SAT planners
 */
@CommandLine.Command(name = "AbstractSATPlanner",
    version = "AbstractSATPlanner 1.0",
    description = "Solves a specified planning problem using a SAT solver.",
    sortOptions = false,
    mixinStandardHelpOptions = true,
    headerHeading = "Usage:%n",
    synopsisHeading = "%n",
    descriptionHeading = "%nDescription:%n%n",
    parameterListHeading = "%nParameters:%n",
    optionListHeading = "%nOptions:%n")
public abstract class AbstractSATPlanner extends AbstractPlanner {
    /**
     * The configuration property used to specify the SAT encoding
     */
    public static final String SAT_ENCODING_SETTING = "SAT_ENCODING";

    /**
     * The default SAT encoding
     */
    public static final AbstractSATEncoding.SATEncoding DEFAULT_SAT_ENCODING = AbstractSATEncoding.SATEncoding.DEFAULT;

    /**
     * The chosen SAT encoding
     */
    private AbstractSATEncoding.SATEncoding encoding;

    /**
     * The configuration property used to specify the SAT solver
     */
    public static final String SAT_SOLVER_SETTING = "SAT_SOLVER";

    /**
     * The default SAT solver
     */
    public static final SATSolver DEFAULT_SAT_SOLVER = SATSolver.PICOSAT;

    /**
     * The chosen SAT solver
     */
    private SATSolver solver;

    /**
     * The configuration property used to specify the maximum length of a plan (that is, its number of actions)
     */
    public static final String  MAX_PLAN_LENGTH_SETTING = "MAX_PLAN_LENGTH";

    /**
     * The default maximum plan length
     */
    public static final int DEFAULT_MAX_PLAN_LENGTH = 1000;

    /**
     * The chosen maximum plan length
     */
    private int maxPlanLength = -1;

    /**
     * Creates a new SAT planner with the default configuration
     */
    public AbstractSATPlanner() {
        this(AbstractSATPlanner.getDefaultConfiguration());
    }

    /**
     * Creates a new SAT planner with the specified configuration
     * @param configuration     the configuration of the planner
     */
    public AbstractSATPlanner(final PlannerConfiguration configuration) {
        super();
        this.setConfiguration(configuration);
    }

    @Override
    public Problem instantiate(DefaultParsedProblem problem) {
        final Problem pb = new DefaultProblem(problem);
        pb.instantiate();
        return pb;
    }

    /**
     * Sets the encoding used by the planner
     * @param encoding  the chosen encoding
     */
    @CommandLine.Option(names = {"-e", "--encoding"}, defaultValue = "DEFAULT",
        paramLabel = "<encoding>", description = "Sets the encoding used to encode the problem into a SAT problem (preset DEFAULT).")
    public void setEncoding(AbstractSATEncoding.SATEncoding encoding) {
        this.encoding = encoding;
    }

    /**
     * Sets the solver used by the planner
     * @param solver    the chosen solver
     */
    @CommandLine.Option(names = {"-s", "--solver"}, defaultValue = "PICOSAT",
        paramLabel = "<solver>", description = "Sets the SAT solver used to solve the problem (preset PICOSAT).")
    public void setSolver(SATSolver solver) {
        this.solver = solver;
    }

    /**
     * @return  the encoding used by the planner
     */
    public AbstractSATEncoding.SATEncoding getEncoding() {
        return encoding;
    }

    /**
     * @return  the solver used by the planner
     */
    public SATSolver getSolver() {
        return solver;
    }

    /**
     * @return  the maximum length of a plan searched for by the planner
     */
    public int getMaxPlanLength() {
        return maxPlanLength;
    }

    /**
     * Sets the maximum length of a plan searched for by the planner
     * @param maxPlanLength     the chosen maximum length
     */
    @CommandLine.Option(names = {"-mpl", "--maxPlanLength"}, defaultValue = "1000",
        paramLabel = "<maxPlanLength>", description = "Sets the maximum length of a plan (maximum number of actions), after which the search for a solution is aborted.")
    public void setMaxPlanLength(int maxPlanLength) {
        this.maxPlanLength = Math.max(maxPlanLength, 0);
    }

    @Override
    public Plan solve(Problem problem) throws ProblemNotSupportedException {
        Encoding encoding;
        switch (this.encoding) {
            default:
                encoding = new DefaultSATEncoding();
        }
        try {
            return encoding.solve(problem, solver, maxPlanLength);
        } catch (SolverTerminatedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isSupported(Problem problem) {
        return !(problem.getRequirements().contains(RequireKey.ACTION_COSTS)
            || problem.getRequirements().contains(RequireKey.CONSTRAINTS)
            || problem.getRequirements().contains(RequireKey.CONTINOUS_EFFECTS)
            || problem.getRequirements().contains(RequireKey.DERIVED_PREDICATES)
            || problem.getRequirements().contains(RequireKey.DURATIVE_ACTIONS)
            || problem.getRequirements().contains(RequireKey.DURATION_INEQUALITIES)
            || problem.getRequirements().contains(RequireKey.FLUENTS)
            || problem.getRequirements().contains(RequireKey.GOAL_UTILITIES)
            || problem.getRequirements().contains(RequireKey.METHOD_CONSTRAINTS)
            || problem.getRequirements().contains(RequireKey.NUMERIC_FLUENTS)
            || problem.getRequirements().contains(RequireKey.OBJECT_FLUENTS)
            || problem.getRequirements().contains(RequireKey.PREFERENCES)
            || problem.getRequirements().contains(RequireKey.TIMED_INITIAL_LITERALS)
            || problem.getRequirements().contains(RequireKey.HIERARCHY));
    }

    /**
     * @return  true if the configuration of the planner is valid, else false
     */
    public boolean hasValidConfiguration() {
        return super.hasValidConfiguration()
            && getEncoding() != null
            && getSolver() != null
            && maxPlanLength >= 0;
    }

    /**
     * @return  the default configuration of the planner
     */
    public static PlannerConfiguration getDefaultConfiguration() {
        PlannerConfiguration config = Planner.getDefaultConfiguration();
        config.setProperty(SAT_ENCODING_SETTING, DEFAULT_SAT_ENCODING);
        config.setProperty(SAT_SOLVER_SETTING, DEFAULT_SAT_SOLVER);
        config.setProperty(MAX_PLAN_LENGTH_SETTING, DEFAULT_MAX_PLAN_LENGTH);
        return config;
    }

    @Override
    public PlannerConfiguration getConfiguration() {
        final PlannerConfiguration config = super.getConfiguration();
        config.setProperty(SAT_ENCODING_SETTING, getEncoding());
        config.setProperty(SAT_SOLVER_SETTING, getSolver());
        config.setProperty(MAX_PLAN_LENGTH_SETTING, getMaxPlanLength());
        return config;
    }

    @Override
    public void setConfiguration(final PlannerConfiguration configuration) {
        super.setConfiguration(configuration);

        if (configuration.getProperty(SAT_ENCODING_SETTING) == null) {
            setEncoding(DEFAULT_SAT_ENCODING);
        }
        else {
            setEncoding(AbstractSATEncoding.SATEncoding.valueOf(configuration.getProperty(SAT_ENCODING_SETTING)));
        }

        if (configuration.getProperty(SAT_SOLVER_SETTING) == null) {
            setSolver(DEFAULT_SAT_SOLVER);
        }
        else {
            setSolver(SATSolver.valueOf(configuration.getProperty(SAT_SOLVER_SETTING)));
        }

        if (configuration.getProperty(MAX_PLAN_LENGTH_SETTING) == null) {
            setMaxPlanLength(DEFAULT_MAX_PLAN_LENGTH);
        }
        else {
            setMaxPlanLength(Integer.parseInt(configuration.getProperty(MAX_PLAN_LENGTH_SETTING)));
        }
    }
}
