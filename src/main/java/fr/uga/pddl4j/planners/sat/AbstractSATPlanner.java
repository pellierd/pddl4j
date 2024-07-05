package fr.uga.pddl4j.planners.sat;

import com.github.liveontologies.ipasir4j.IpasirSolver;
import com.github.liveontologies.ipasir4j.SolverTerminatedException;
import fr.uga.pddl4j.parser.DefaultParsedProblem;
import fr.uga.pddl4j.parser.RequireKey;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.ProblemNotSupportedException;
import fr.uga.pddl4j.planners.sat.encodings.*;
import fr.uga.pddl4j.planners.sat.solvers.MergesatWrapper;
import fr.uga.pddl4j.planners.sat.solvers.PicosatWrapper;
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
public abstract class AbstractSATPlanner extends AbstractPlanner implements SATPlanner {
    /**
     * The configuration property used to specify the SAT encoding
     */
    public static final String SAT_ENCODING_SETTING = "SAT_ENCODING";

    /**
     * The name of the default SAT encoding
     */
    public static final String DEFAULT_SAT_ENCODING_NAME = "DEFAULT";

    /**
     * The name of the chosen SAT encoding
     */
    private String encodingName;

    /**
     * The configuration property used to specify the SAT solver
     */
    public static final String SAT_SOLVER_SETTING = "SAT_SOLVER";

    /**
     * The name of the default SAT solver
     */
    public static final String DEFAULT_SAT_SOLVER_NAME = "MERGESAT";

    /**
     * The name of the chosen SAT solver
     */
    private String solverName;

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
     * @param encodingName  the name of the chosen encoding
     */
    @CommandLine.Option(names = {"-e", "--encoding"}, defaultValue = "DEFAULT",
        paramLabel = "<encoding>", description = "Sets the encoding used to encode the problem into a SAT problem (preset DEFAULT).")
    public void setEncoding(String encodingName) {
        this.encodingName = encodingName;
    }

    /**
     * Sets the solver used by the planner
     * @param solverName    the name of the chosen solver
     */
    @CommandLine.Option(names = {"-s", "--solver"}, defaultValue = "MERGESAT",
        paramLabel = "<solver>", description = "Sets the SAT solver used to solve the problem (preset MERGESAT).")
    public void setSolver(String solverName) {
        this.solverName = solverName;
    }

    /**
     * @return  the name of the encoding used by the planner
     */
    public String getEncodingName() {
        return encodingName;
    }

    /**
     * @return  the name of the solver used by the planner
     */
    public String getSolverName() {
        return solverName;
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
        SATEncoding encoding = getSATEncodingFromName(encodingName);
        IpasirSolver solver = getSATSolverFromName(solverName);
        try {
            return encoding.solve(problem, solver, maxPlanLength);
        } catch (SolverTerminatedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param encodingName                      the name of the encoding
     * @return                                  a new instance of the corresponding encoding
     * @throws ProblemNotSupportedException     if no such encoding exists
     */
    public SATEncoding getSATEncodingFromName(String encodingName) throws ProblemNotSupportedException {
        switch (this.encodingName) {
            case "RE":
            case "REGULAR_EXPLANATORY":
            case "DEFAULT":
                return new RegularExplanatorySATEncoding();
            case "SSC":
            case "SIMPLE_SPLITTING_CLASSICAL":
                return new SimpleSplittingClassicalSATEncoding();
            case "RC":
            case "REGULAR_CLASSICAL":
                return new RegularClassicalSATEncoding();
            case "BC":
            case "BITWISE_CLASSICAL":
                return new BitwiseClassicalSATEncoding();
            default:
                throw new ProblemNotSupportedException("ERROR: Unknown encoding");
        }
    }

    /**
     * @param solverName                        the name of the solver
     * @return                                  a new instance of the corresponding solver
     * @throws ProblemNotSupportedException     if no such solver exists
     */
    public IpasirSolver getSATSolverFromName(String solverName) throws ProblemNotSupportedException {
        switch (this.solverName) {
            case "PICOSAT":
                return PicosatWrapper.createSolver();
            case "MERGESAT":
                return MergesatWrapper.createSolver();
            default:
                throw new ProblemNotSupportedException("ERROR: Unknown solver");
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

    public boolean hasValidSolver() {
        try {
            getSATSolverFromName(solverName);
        } catch (ProblemNotSupportedException e) {
            return false;
        }
        return true;
    }

    public boolean hasValidEncoding() {
        try {
            getSATEncodingFromName(encodingName);
        } catch (ProblemNotSupportedException e) {
            return false;
        }
        return true;
    }

    /**
     * @return  true if the configuration of the planner is valid, else false
     */
    public boolean hasValidConfiguration() {
        return super.hasValidConfiguration()
            && hasValidEncoding()
            && hasValidSolver()
            && maxPlanLength >= 0;
    }

    /**
     * @return  the default configuration of the planner
     */
    public static PlannerConfiguration getDefaultConfiguration() {
        PlannerConfiguration config = Planner.getDefaultConfiguration();
        config.setProperty(SAT_ENCODING_SETTING, DEFAULT_SAT_ENCODING_NAME);
        config.setProperty(SAT_SOLVER_SETTING, DEFAULT_SAT_SOLVER_NAME);
        config.setProperty(MAX_PLAN_LENGTH_SETTING, DEFAULT_MAX_PLAN_LENGTH);
        return config;
    }

    @Override
    public PlannerConfiguration getConfiguration() {
        final PlannerConfiguration config = super.getConfiguration();
        config.setProperty(SAT_ENCODING_SETTING, getEncodingName());
        config.setProperty(SAT_SOLVER_SETTING, getSolverName());
        config.setProperty(MAX_PLAN_LENGTH_SETTING, getMaxPlanLength());
        return config;
    }

    @Override
    public void setConfiguration(final PlannerConfiguration configuration) {
        super.setConfiguration(configuration);

        if (configuration.getProperty(SAT_ENCODING_SETTING) == null) {
            setEncoding(DEFAULT_SAT_ENCODING_NAME);
        }
        else {
            setEncoding(configuration.getProperty(SAT_ENCODING_SETTING));
        }

        if (configuration.getProperty(SAT_SOLVER_SETTING) == null) {
            setSolver(DEFAULT_SAT_SOLVER_NAME);
        }
        else {
            setSolver(configuration.getProperty(SAT_SOLVER_SETTING));
        }

        if (configuration.getProperty(MAX_PLAN_LENGTH_SETTING) == null) {
            setMaxPlanLength(DEFAULT_MAX_PLAN_LENGTH);
        }
        else {
            setMaxPlanLength(Integer.parseInt(configuration.getProperty(MAX_PLAN_LENGTH_SETTING)));
        }
    }
    /**
     * Two SAT planners are supposed equal iff :
     *  - either they are the same object
     *  - or they are instances of the same class, and have the same configuration
     * @param obj   the compared object
     * @return      whether they are the same SAT planner or not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj != null && obj.getClass() == getClass()) {
            AbstractSATPlanner other = (AbstractSATPlanner) obj;
            return other.getConfiguration().equals(getConfiguration());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getConfiguration().hashCode();
    }

    @Override
    public String toString() {
        return "SAT planner of " + getClass() + " with configuration :\n" + getConfiguration();
    }
}
