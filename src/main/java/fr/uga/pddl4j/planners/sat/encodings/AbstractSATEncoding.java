package fr.uga.pddl4j.planners.sat.encodings;

import com.github.liveontologies.ipasir4j.IpasirSolver;
import com.github.liveontologies.ipasir4j.SolverTerminatedException;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.sat.solvers.SATSolver;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.util.BitVector;

/**
 * An abstract class defining all general elements used to create new SAT encodings
 */
public abstract class AbstractSATEncoding implements Encoding {
    /**
     * Defines the available SAT encodings
     */
    public enum SATEncoding {
        DEFAULT
    }

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

    @Override
    public Plan solve(Problem problem, SATSolver solver, int maxPlanLength) throws SolverTerminatedException {
        solverInstance = SATSolver.getNewSolverInstance(solver);
        this.problem = problem;
        actionBeginningIndex = problem.getFluents().size();

        encodeInitialState();
        for (int planLength = 0; planLength <= maxPlanLength; planLength++) {
            encodeGoal(planLength);
            if (planLength > 0) {
                encodeActions(planLength - 1);
                encodeFrameAxioms(planLength - 1);
            }

            if (solverInstance.isSatisfiable()) return getPlan(planLength);
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
        solverInstance.assume(DIMACSNotation(fluentIndex, state, positive));
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
        solverInstance.assume(DIMACSNotation(actionIndex, state, positive));
    }

    /**
     * Adds a fluent to the current clause
     * This is a wrapper for the ipasir function "add".
     * @param fluentIndex   the index of the fluent in the list of fluents of the instantiated problem
     * @param state         the state in which the fluent is to be considered
     * @param positive      whether the fluent is negated (false) or not (true)
     */
    protected void addFluent(int fluentIndex, int state, boolean positive) {
        solverInstance.add(DIMACSNotation(fluentIndex, state, positive));
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
        solverInstance.add(DIMACSNotation(actionIndex, state, positive));
    }

    /**
     * Ends the current clause
     * This is an alias for the ipasir function "add" with parameter 0
     */
    protected void endClause() {
        solverInstance.add(0);
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
}
