package fr.uga.pddl4j.planners.sat.encodings;

import com.github.liveontologies.ipasir4j.IpasirSolver;
import com.github.liveontologies.ipasir4j.SolverTerminatedException;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.util.BitVector;

import java.util.HashSet;

/**
 * An abstract class defining all general elements used to create new SAT encodings
 */
public abstract class AbstractSATEncoding implements SATEncoding {
    /**
     * Internal variable used for the translation of actions into DIMACS notation (to add them to a solver)
     * Example :  If we have 30 fluents and 10 actions, the fluents will be encoded between 0 and 29, and the actions between 30 and 39. So, we will have actionBeginningIndex = 30.
     */
    private int actionBeginningIndex;
    /**
     * The last solver instance used to (try to) solve a problem (is null if no solving has been tried yet)
     */
    private IpasirSolver solverInstance;
    /**
     * The last problem this encoding has been used with (is null if no solving has been tried yet)
     */
    private Problem problem;
    /**
     * A set containing all added clauses
     */
    private HashSet<HashSet<Integer>> addedClauses;
    /**
     * A set containing all assumed clauses
     */
    private HashSet<Integer> assumedClauses;
    /**
     * A string builder used to get a readable output for debugging (with comments), for added clauses
     */
    private StringBuilder dimacsDebugStringBuilder;
    /**
     * A string builder used to get a readable output for debugging (with comments), for assumed clauses
     */
    private StringBuilder dimacsDebugStringBuilderAssumed;
    /**
     * A set containing the clause being currently built
     */
    private HashSet<Integer> currentClause;

    @Override
    public Plan solve(Problem problem, IpasirSolver solver, int maxPlanLength) throws SolverTerminatedException {
        solverInstance = solver;
        this.problem = problem;
        actionBeginningIndex = problem.getFluents().size();
        addedClauses = new HashSet<>();
        assumedClauses = new HashSet<>();
        currentClause = new HashSet<>();
        dimacsDebugStringBuilder = new StringBuilder();
        dimacsDebugStringBuilderAssumed = new StringBuilder();

        dimacsDebugStringBuilder.append("c Initial state:\n");
        dimacsDebugStringBuilderAssumed.append("c Initial state:\n");
        encodeInitialState();
        for (int planLength = 0; planLength <= maxPlanLength; planLength++) {
            dimacsDebugStringBuilder.append("c Goal (plan length ").append(planLength).append("):\n");
            dimacsDebugStringBuilderAssumed.append("c Goal (plan length ").append(planLength).append("):\n");
            encodeGoal(planLength);
            if (planLength > 0) {
                dimacsDebugStringBuilder.append("c Actions (plan length ").append(planLength).append("):\n");
                dimacsDebugStringBuilderAssumed.append("c Actions (plan length ").append(planLength).append("):\n");
                encodeActions(planLength - 1);
                dimacsDebugStringBuilder.append("c Frame axioms (plan length ").append(planLength).append("):\n");
                dimacsDebugStringBuilderAssumed.append("c Frame axioms (plan length ").append(planLength).append("):\n");
                encodeFrameAxioms(planLength - 1);
            }

            if (solverInstance.isSatisfiable()) return getPlan(planLength);
            assumedClauses = new HashSet<>(); //Assumed clauses are reinitialized each time;
            currentClause = new HashSet<>(); //It should be void at this point, but just to be sure
            dimacsDebugStringBuilderAssumed = new StringBuilder();
        }
        return null;
    }

    /**
     * Supposing that the problem has been encoded and that the problem is satisfiable, returns the plan found by the solver
     * @param planLength        the length of the plan
     * @return                  the plan found by the solver
     */
    protected Plan getPlan(int planLength) {
        final Plan plan = new SequentialPlan();
        for (int state = 0; state < planLength; state++) {
            for (int actionIndex = 0; actionIndex < problem.getActions().size(); actionIndex++) {
                if (solverInstance.val(DIMACSNotation(actionBeginningIndex + actionIndex, state, true)) > 0) {
                    Action action = problem.getActions().get(actionIndex);
                    plan.add(state, action);
                    break;
                }
            }
        }
        return plan;
    }

    /**
     * Encodes a fluent into DIMACS notation, used to add it to the solver, using the Cantor pairing function
     * @param index         the index of the fluent (or the action) in the list of fluents (respectively the list of actions) of the instantiated problem
     * @param state         the state in which the fluent is to be considered
     * @param positive      whether the fluent is negated (false) or not (true)
     * @return              an integer able to be added
     */
    protected int DIMACSNotation(int index, int state, boolean positive) {
        return (positive? 1 : -1) * ((index + state) * (index + state + 1) / 2 + index + 1);
    }

    /**
     * Assumes that a fluent is true or false in some state
     * As it is a wrapper for the ipasir method "assume", this assumption will only be considered for the next satisfiability test, that is it will be discarded when the plan length increases.
     * @param fluentIndex   the index of the fluent in the list of fluents of the instantiated problem
     * @param state         the state in which the fluent is to be considered
     * @param positive      whether the fluent is negated (false) or not (true)
     */
    protected void assumeFluent(int fluentIndex, int state, boolean positive) {
        int dimacs = DIMACSNotation(fluentIndex, state, positive);
        solverInstance.assume(dimacs);
        assumedClauses.add(dimacs);
        dimacsDebugStringBuilderAssumed.append(dimacs).append("\n");
    }

    /**
     * Assumes that an action is taken or not in some state
     * As it is a wrapper for the ipasir function "assume", this assumption will only be considered for the next satisfiability test, that is it will be discarded when the plan length increases.
     * @param actionIndex   the index of the action in the list of actions of the instantiated problem
     * @param state         the state in which the action is taken
     * @param positive      whether the action is taken (true) or not (false)
     */
    protected void assumeAction(int actionIndex, int state, boolean positive) {
        actionIndex += actionBeginningIndex;
        int dimacs = DIMACSNotation(actionIndex, state, positive);
        solverInstance.assume(dimacs);
        assumedClauses.add(dimacs);
        dimacsDebugStringBuilderAssumed.append(dimacs).append("\n");
    }

    /**
     * Adds a fluent to the current clause
     * This is a wrapper for the ipasir function "add".
     * @param fluentIndex   the index of the fluent in the list of fluents of the instantiated problem
     * @param state         the state in which the fluent is to be considered
     * @param positive      whether the fluent is negated (false) or not (true)
     */
    protected void addFluent(int fluentIndex, int state, boolean positive) {
        int dimacs = DIMACSNotation(fluentIndex, state, positive);
        solverInstance.add(dimacs);
        currentClause.add(dimacs);
        dimacsDebugStringBuilder.append(dimacs).append(" ");
    }

    /**
     * Adds an action to the current clause
     * This is a wrapper for the ipasir function "add".
     * @param actionIndex   the index of the action in the list of actions of the instantiated problem
     * @param state         the state in which the action is to be considered
     * @param positive      whether the action is negated (false) or not (true)
     */
    protected void addAction(int actionIndex, int state, boolean positive) {
        actionIndex += actionBeginningIndex;
        int dimacs = DIMACSNotation(actionIndex, state, positive);
        solverInstance.add(dimacs);
        currentClause.add(dimacs);
        dimacsDebugStringBuilder.append(dimacs).append(" ");
    }

    /**
     * Ends the current clause
     * This is an alias for the ipasir function "add" with parameter 0
     */
    protected void endClause() {
        solverInstance.add(0);
        addedClauses.add(currentClause);
        currentClause = new HashSet<>();
        dimacsDebugStringBuilder.append(0).append("\n");
    }

    /**
     * Encodes the initial state of the problem, as a series of unary clauses containing each the status (true or false) of a fluent at state 0. All fluents are encoded.
     * The encoding of the initial state has to be done once and is persistent.
     */
    protected void encodeInitialState() {
        final BitVector initialPositiveFluents = problem.getInitialState().getPositiveFluents();
        //All fluents not positive are assumed to be negative by default
        for (int fluentIndex = 0; fluentIndex < problem.getFluents().size(); fluentIndex++) {
            addFluent(fluentIndex, 0, initialPositiveFluents.get(fluentIndex));
            endClause();
        }
    }

    /**
     * Encodes the goal of the problem, as a series of unary clauses containing each the status (true or false) of a fluent at state planLength (at the last state). Only fluents specified in the problem are encoded.
     * The encoding of the goal is NOT persistent (it uses the ipasir function "assume") and must therefore be done again each time a satisfiability test is done (that is, each time the plan length is increased).
     * @param planLength    the current length of the plan (that is, the current exact number of actions of a hypothetical plan)
     */
    protected void encodeGoal(int planLength) {
        final BitVector finalPositiveFluents = problem.getGoal().getPositiveFluents();
        final BitVector finalNegativeFluents = problem.getGoal().getNegativeFluents();
        //Here, we care only about fluents that are explicitly specified
        for (int i = 0; i < problem.getFluents().size(); i++) {
            if (finalPositiveFluents.get(i)) {
                assumeFluent(i, planLength, true);
            }
            if (finalNegativeFluents.get(i)) {
                assumeFluent(i, planLength, false);
            }
        }
    }

    /**
     * Encodes all actions of the problem that may be taken at a given state (between states 0 and planLength - 1).
     * @param state     the state where the actions are supposed to be chosen
     */
    protected void encodeActions(int state) {
        //We have to differentiate the different actions that can be taken for each state (i.e. moving at step 0 is different from moving at step 1)
        for (int actionIndex = 0; actionIndex < problem.getActions().size(); actionIndex++) {
            encodeAction(actionIndex, state);
        }
    }

    /**
     * Encodes one action of the problem that may be taken at a given state (between states 0 and planLength - 1).
     * @param actionIndex   the index of the action in the list of actions of the instantiated problem
     * @param state         the state where the action is supposed to be chosen
     */
    protected abstract void encodeAction(int actionIndex, int state);

    /**
     * Encodes all axioms necessary to describe the frame of the problem (whose exact nature depends on the specific encoding), at a specific state (between states 0 and planLength - 1)
     * @param state         the state where the axioms are considered
     */
    protected abstract void encodeFrameAxioms(int state);

    /**
     * @return  the last problem encoded by this encoding
     */
    protected Problem getProblem() {
        return problem;
    }

    /**
     * Two encodings are supposed equal iff :
     *  - either they are the same object
     *  - or they are instances of the same class, and have the same clauses in their last encoding instance (not necessarily the same problem or the same solver)
     *  Whether or not a clause was added or assumed is irrelevant if the clause is present in the end for both.
     * @param obj   the compared object
     * @return      whether they are the same encoding or not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj != null && obj.getClass() == getClass()) {
            AbstractSATEncoding other = (AbstractSATEncoding) obj;
            HashSet<HashSet<Integer>> allClauses = new HashSet<>(addedClauses);
            for (Integer i : assumedClauses) {
                allClauses.add(new HashSet<>(i));
            }
            HashSet<HashSet<Integer>> allClausesOther = new HashSet<>(other.addedClauses);
            for (Integer i : other.assumedClauses) {
                allClausesOther.add(new HashSet<>(i));
            }
            return allClauses.equals(allClausesOther);
        }
        return false;
    }

    @Override
    public String toString() {
        return "c Encoding of " + this.getClass() + ", used with solver of signature " + solverInstance.getSignature() + "\n" +
            "c ***************\n" +
            "c Added clauses:\n" +
            "c ***************\n" +
            dimacsDebugStringBuilder +
            "c ***************\n" +
            "c Last assumed clauses:\n" +
            "c ***************\n" +
            dimacsDebugStringBuilderAssumed;
    }

    @Override
    public int hashCode() {
        int hash = 21;
        hash = 31*hash + assumedClauses.hashCode();
        hash = 31*hash + addedClauses.hashCode();
        return hash;
    }
}
