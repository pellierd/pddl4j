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

import com.github.liveontologies.ipasir4j.IpasirSolver;
import com.github.liveontologies.ipasir4j.SolverTerminatedException;
import fr.uga.pddl4j.parser.DefaultParsedProblem;
import fr.uga.pddl4j.parser.RequireKey;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.ProblemNotSupportedException;
import fr.uga.pddl4j.planners.sat.encodings.BitwiseClassicalSATEncoding;
import fr.uga.pddl4j.planners.sat.encodings.RegularClassicalSATEncoding;
import fr.uga.pddl4j.planners.sat.encodings.RegularExplanatorySATEncoding;
import fr.uga.pddl4j.planners.sat.encodings.SATEncoding;
import fr.uga.pddl4j.planners.sat.encodings.SimpleSplittingClassicalSATEncoding;
import fr.uga.pddl4j.planners.sat.solvers.MergesatWrapper;
import fr.uga.pddl4j.planners.sat.solvers.PicosatWrapper;
import fr.uga.pddl4j.problem.DefaultProblem;
import fr.uga.pddl4j.problem.Problem;
import picocli.CommandLine;

/**
 * An abstract class defining all general elements of SAT planners.
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
     * The name of the chosen SAT encoding.
     */
    private String encodingName;

    /**
     * The name of the chosen SAT solver.
     */
    private String solverName;

    /**
     * The chosen maximum plan length.
     */
    private int maxPlanLength = -1;

    /**
     * Creates a new SAT planner with the default configuration.
     */
    public AbstractSATPlanner() {
        this(AbstractSATPlanner.getDefaultConfiguration());
    }

    /**
     * Creates a new SAT planner with the specified configuration.
     *
     * @param configuration the configuration of the planner
     */
    public AbstractSATPlanner(final PlannerConfiguration configuration) {
        super();
        this.setConfiguration(configuration);
    }

    /**
     * Returns the default configuration of the planner.
     * @return the default configuration of the planner
     */
    public static PlannerConfiguration getDefaultConfiguration() {
        PlannerConfiguration config = Planner.getDefaultConfiguration();
        config.setProperty(SAT_ENCODING_SETTING, DEFAULT_SAT_ENCODING_NAME);
        config.setProperty(SAT_SOLVER_SETTING, DEFAULT_SAT_SOLVER_NAME);
        config.setProperty(MAX_PLAN_LENGTH_SETTING, DEFAULT_MAX_PLAN_LENGTH);
        return config;
    }

    /**
     * Instantiates the planning problem from a parsed problem.
     *
     * @param problem the problem to instantiate.
     * @return the instantiated planning problem or null if the problem cannot be instantiated.
     */
    @Override
    public Problem instantiate(DefaultParsedProblem problem) {
        final Problem pb = new DefaultProblem(problem);
        pb.instantiate();
        return pb;
    }

    /**
     * Sets the encoding used by the planner.
     *
     * @param encodingName the name of the chosen encoding
     */
    @CommandLine.Option(names = {"-e", "--encoding"}, defaultValue = "DEFAULT",
        paramLabel = "<encoding>", description = "Sets the encoding used to encode the problem into a SAT problem"
        + "(preset DEFAULT).")
    public void setEncoding(String encodingName) {
        this.encodingName = encodingName;
    }

    /**
     * Sets the solver used by the planner.
     *
     * @param solverName the name of the chosen solver
     */
    @CommandLine.Option(names = {"-s", "--solver"}, defaultValue = "MERGESAT",
        paramLabel = "<solver>", description = "Sets the SAT solver used to solve the problem (preset MERGESAT).")
    public void setSolver(String solverName) {
        this.solverName = solverName;
    }

    /**
     * Returns the name of the encoding.
     * @return the name of the encoding used by the planner.
     */
    public String getEncodingName() {
        return encodingName;
    }

    /**
     * Returns the name of the solver.
     * @return the name of the solver used by the planner
     */
    public String getSolverName() {
        return solverName;
    }

    /**
     * Returns the maximum length of a plan searched for by the planner.
     * @return the maximum length of a plan searched for by the planner
     */
    public int getMaxPlanLength() {
        return maxPlanLength;
    }

    /**
     * Sets the maximum length of a plan searched for by the planner.
     *
     * @param maxPlanLength the chosen maximum length
     */
    @CommandLine.Option(names = {"-mpl", "--maxPlanLength"}, defaultValue = "1000",
        paramLabel = "<maxPlanLength>", description = "Sets the maximum length of a plan (maximum number of actions),"
        + "after which the search for a solution is aborted.")
    public void setMaxPlanLength(int maxPlanLength) {
        this.maxPlanLength = Math.max(maxPlanLength, 0);
    }

    /**
     * Search a solution plan to a specified domain and problem using A*.
     *
     * @param problem the problem to solve.
     * @return the plan found or null if no plan was found.
     */
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
     * Returns a new instance of the SAT encoding using the encoding name provided as argument.
     * @param encodingName the name of the encoding
     * @return a new instance of the corresponding encoding
     * @throws ProblemNotSupportedException if no such encoding exists
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
     * Returns a new instance of the SAT solver using the solver name provided as argument.
     * @param solverName the name of the solver
     * @return a new instance of the corresponding solver
     * @throws ProblemNotSupportedException if no such solver exists
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

    /**
     * Returns if a specified problem is supported by the planner. Just ADL problem can be solved by this planner.
     *
     * @param problem the problem to test.
     * @return <code>true</code> if the problem is supported <code>false</code> otherwise.
     */
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
     * Returns true if the solver name is valid, else false.
     * @return  true if the solver name is valid, else false
     */
    public boolean hasValidSolver() {
        try {
            getSATSolverFromName(solverName);
        } catch (ProblemNotSupportedException e) {
            return false;
        }
        return true;
    }

    /**
     * Returns <code>true</code> if the encoding name is valid, else <code>false</code>.
     * @return  <code>true</code> if the encoding name is valid, else <code>false</code>
     */
    public boolean hasValidEncoding() {
        try {
            getSATEncodingFromName(encodingName);
        } catch (ProblemNotSupportedException e) {
            return false;
        }
        return true;
    }

    /**
     * Returns <code>true</code> if the configuration of the planner is valid, else <code>false</code>.
     * @return <code>true</code> if the configuration of the planner is valid, else <code>false</code>.
     */
    public boolean hasValidConfiguration() {
        return super.hasValidConfiguration()
            && hasValidEncoding()
            && hasValidSolver()
            && maxPlanLength >= 0;
    }

    /**
     * Returns the configuration of the planner.
     *
     * @return the configuration of the planner.
     */
    @Override
    public PlannerConfiguration getConfiguration() {
        final PlannerConfiguration config = super.getConfiguration();
        config.setProperty(SAT_ENCODING_SETTING, getEncodingName());
        config.setProperty(SAT_SOLVER_SETTING, getSolverName());
        config.setProperty(MAX_PLAN_LENGTH_SETTING, getMaxPlanLength());
        return config;
    }

    /**
     * Sets the configuration of the planner. If a planner setting is not defined in
     * the specified configuration, the setting is initialized with its default value.
     *
     * @param configuration the configuration to set.
     */
    @Override
    public void setConfiguration(final PlannerConfiguration configuration) {
        super.setConfiguration(configuration);

        if (configuration.getProperty(SAT_ENCODING_SETTING) == null) {
            setEncoding(DEFAULT_SAT_ENCODING_NAME);
        } else {
            setEncoding(configuration.getProperty(SAT_ENCODING_SETTING));
        }

        if (configuration.getProperty(SAT_SOLVER_SETTING) == null) {
            setSolver(DEFAULT_SAT_SOLVER_NAME);
        } else {
            setSolver(configuration.getProperty(SAT_SOLVER_SETTING));
        }

        if (configuration.getProperty(MAX_PLAN_LENGTH_SETTING) == null) {
            setMaxPlanLength(DEFAULT_MAX_PLAN_LENGTH);
        } else {
            setMaxPlanLength(Integer.parseInt(configuration.getProperty(MAX_PLAN_LENGTH_SETTING)));
        }
    }

    /**
     * Returns <code>true</code> if the object passed as argument is equal to <code>this</code>, else
     * <code>false</code>.
     * Two SAT planners are supposed equal iff :
     * - either they are the same object
     * - or they are instances of the same class, and have the same configuration
     *
     * @param obj the compared object
     * @return whether they are the same SAT planner or not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
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
