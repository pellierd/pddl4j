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
 * An abstract class defining all general elements used to create new SAT encodings.
 */
public abstract class AbstractSATEncoding implements SATEncoding {
    /**
     * Internal variable used for the translation of actions into DIMACS notation (to add them to a solver).
     * Example :  If we have 30 fluents and 10 actions, the fluents will be encoded between 0 and 29, and the
     * actions between 30 and 39. So, we will have <code>actionBeginningIndex = 30</code>.
     */
    private int actionBeginningIndex;
    /**
     * The last solver instance used to (try to) solve a problem (is <code>null</code> if no solving has been tried
     * yet).
     */
    private IpasirSolver solverInstance;
    /**
     * The last problem this encoding has been used with (is <code>null</code> if no solving has been tried yet).
     */
    private Problem problem;
    /**
     * A set containing all added clauses.
     */
    private HashSet<HashSet<Integer>> addedClauses;
    /**
     * A set containing all assumed clauses.
     */
    private HashSet<Integer> assumedClauses;
    /**
     * A string builder used to get a readable output for debugging (with comments), for added clauses.
     */
    private StringBuilder dimacsDebugStringBuilder;
    /**
     * A string builder used to get a readable output for debugging (with comments), for assumed clauses.
     */
    private StringBuilder dimacsDebugStringBuilderAssumed;
    /**
     * A set containing the clause being currently built.
     */
    private HashSet<Integer> currentClause;
    /**
     * The lenth of the last found plan.
     */
    private int lastPlanLength;

    @Override
    public Plan solve(Problem problem, IpasirSolver solver, int maxPlanLength) throws SolverTerminatedException {
        //Initializing the attributes
        solverInstance = solver;
        this.problem = problem;
        actionBeginningIndex = problem.getFluents().size();
        addedClauses = new HashSet<>();
        assumedClauses = new HashSet<>();
        currentClause = new HashSet<>();
        dimacsDebugStringBuilder = new StringBuilder();
        dimacsDebugStringBuilderAssumed = new StringBuilder();

        //Initial state
        dimacsDebugStringBuilder.append("c Initial state:\n");
        dimacsDebugStringBuilderAssumed.append("c Initial state:\n");
        encodeInitialState();
        for (int planLength = 0; planLength <= maxPlanLength; planLength++) {
            //Goal
            dimacsDebugStringBuilder.append("c Goal (plan length ").append(planLength).append("):\n");
            dimacsDebugStringBuilderAssumed.append("c Goal (plan length ").append(planLength).append("):\n");
            encodeGoal(planLength);
            if (planLength > 0) {
                //Actions
                dimacsDebugStringBuilder.append("c Actions (plan length ").append(planLength).append("):\n");
                dimacsDebugStringBuilderAssumed.append("c Actions (plan length ").append(planLength).append("):\n");
                encodeActions(planLength - 1);

                //Frame axioms
                dimacsDebugStringBuilder.append("c Frame axioms (plan length ").append(planLength).append("):\n");
                dimacsDebugStringBuilderAssumed.append("c Frame axioms (plan length ").append(planLength)
                    .append("):\n");
                encodeFrameAxioms(planLength - 1);
            }

            //Trying to find a solution
            if (solverInstance.isSatisfiable()) {
                lastPlanLength = planLength;
                //Transforming the solution into a plan
                return getPlan(planLength);
            }
            assumedClauses = new HashSet<>(); //Assumed clauses are reinitialized each time;
            currentClause = new HashSet<>(); //It should be void at this point, but just to be sure
            dimacsDebugStringBuilderAssumed = new StringBuilder();
        }
        //If no plan has been found even with the maximum plan length
        return null;
    }

    /**
     * Supposing that the problem has been encoded and that the problem is satisfiable, returns the plan found by the
     * solver.
     * @param planLength        the length of the plan
     * @return                  the plan found by the solver
     */
    protected Plan getPlan(int planLength) {
        final Plan plan = new SequentialPlan();
        for (int state = 0; state < planLength; state++) {
            int actionIndex = 0;
            boolean flag = false;
            //Finding the corresponding action for this state
            while (!flag && actionIndex < problem.getActions().size()) {
                if (actionHasBeenChosen(actionIndex, state)) {
                    Action action = problem.getActions().get(actionIndex);
                    //Adding the action to the plan
                    plan.add(state, action);
                    flag = true;
                }
                actionIndex++;
            }
        }
        return plan;
    }

    /**
     * Encodes a fluent into DIMACS notation, used to add it to the solver, using the Cantor pairing function.
     * @param index         the index of the fluent (or the action)
     * @param state         the state in which the fluent is to be considered
     * @param positive      whether the fluent is negated (<code>false</code>) or not (<code>true</code>)
     * @return              an integer able to be added
     */
    protected int dimacsNotation(int index, int state, boolean positive) {
        return (positive ? 1 : -1) * ((index + state) * (index + state + 1) / 2 + index + 1);
    }

    /**
     * Assumes that a fluent is true or false in some state
     * As it is a wrapper for the ipasir method <code>assume</code>, this assumption will only be considered for the
     * next satisfiability test, that is it will be discarded when the plan length increases.
     * @param fluentIndex   the index of the fluent in the list of fluents of the instantiated problem
     * @param state         the state in which the fluent is to be considered
     * @param positive      whether the fluent is negated (<code>false</code>) or not (<code>true</code>)
     */
    protected void assumeFluent(int fluentIndex, int state, boolean positive) {
        int dimacs = dimacsNotation(fluentIndex, state, positive);
        //Adds the fluent to the solver
        solverInstance.assume(dimacs);
        //Adds the fluent to the internal set of assumed clauses
        assumedClauses.add(dimacs);
        //Updates the debug string builder
        dimacsDebugStringBuilderAssumed.append(dimacs).append(" 0\n");
    }

    /**
     * Assumes that an action is taken or not in some state.
     * As it is a wrapper for the ipasir function <code>assume</code>, this assumption will only be considered for the
     * next satisfiability test, that is it will be discarded when the plan length increases.
     * @param actionIndex   the index of the action in the list of actions of the instantiated problem
     * @param state         the state in which the action is taken
     * @param positive      whether the action is taken (<code>true</code>) or not (<code>false</code>)
     */
    protected void assumeAction(int actionIndex, int state, boolean positive) {
        //Translating the actions (since the first indexes are reserved for the fluents)
        actionIndex += actionBeginningIndex;
        int dimacs = dimacsNotation(actionIndex, state, positive);
        //Adds the action to the solver
        solverInstance.assume(dimacs);
        //Adds the action to the internal set of assumed clauses
        assumedClauses.add(dimacs);
        //Updates the debug string builder
        dimacsDebugStringBuilderAssumed.append(dimacs).append(" 0\n");
    }

    /**
     * Adds a fluent to the current clause.
     * This is a wrapper for the ipasir function <code>add</code>.
     * @param fluentIndex   the index of the fluent in the list of fluents of the instantiated problem
     * @param state         the state in which the fluent is to be considered
     * @param positive      whether the fluent is negated (<code>false</code>) or not (<code>true</code>)
     */
    protected void addFluent(int fluentIndex, int state, boolean positive) {
        int dimacs = dimacsNotation(fluentIndex, state, positive);
        //Adds the fluent to the solver
        solverInstance.add(dimacs);
        //Adds the fluent to the internally stored current clause
        currentClause.add(dimacs);
        //Updates the debug string builder
        dimacsDebugStringBuilder.append(dimacs).append(" ");
    }

    /**
     * Adds an action to the current clause.
     * This is a wrapper for the ipasir function <code>add</code>.
     * @param actionIndex   the index of the action in the list of actions of the instantiated problem
     * @param state         the state in which the action is to be considered
     * @param positive      whether the action is negated (<code>false</code>) or not (<code>true</code>)
     */
    protected void addAction(int actionIndex, int state, boolean positive) {
        //Translating the actions (since the first indexes are reserved for the fluents)
        actionIndex += actionBeginningIndex;
        int dimacs = dimacsNotation(actionIndex, state, positive);
        //Adds the action to the solver
        solverInstance.add(dimacs);
        //Adds the action to the internally stored current clause
        currentClause.add(dimacs);
        //Updates the debug string builder
        dimacsDebugStringBuilder.append(dimacs).append(" ");
    }

    /**
     * Ends the current clause.
     * This is an alias for the ipasir function <code>add</code> with parameter 0
     */
    protected void endClause() {
        //Adds the end of the clause to the solver
        solverInstance.add(0);
        //Adds the current clause to the internal set of added clauses
        addedClauses.add(currentClause);
        currentClause = new HashSet<>();
        //Updates the debug string builder
        dimacsDebugStringBuilder.append(0).append("\n");
    }

    /**
     * Encodes the initial state of the problem, as a series of unary clauses containing each the status
     * (<code>true</code> or <code>false</code>) of a fluent at state 0. All fluents are encoded.
     * The encoding of the initial state has to be done once and is persistent.
     */
    protected void encodeInitialState() {
        final BitVector initialPositiveFluents = problem.getInitialState().getPositiveFluents();
        //All fluents not positive are assumed to be negative by default
        for (int fluentIndex = 0; fluentIndex < problem.getFluents().size(); fluentIndex++) {
            //Adds the fluent to the initial state as true or false, depending on the third argument
            addFluent(fluentIndex, 0, initialPositiveFluents.get(fluentIndex));
            endClause();
        }
    }

    /**
     * Encodes the goal of the problem, as a series of unary clauses containing each the status
     * (<code>true</code> or <code>false</code>) of a fluent at state planLength (at the last state).
     * Only fluents specified in the problem are encoded.
     * The encoding of the goal is NOT persistent (it uses the ipasir function <code>assume</code>) and must therefore
     * be done again each time a satisfiability test is done (that is, each time the plan length is increased).
     * @param planLength    the current length of the plan (that is, the current exact number of actions of a
     *                      hypothetical plan)
     */
    protected void encodeGoal(int planLength) {
        final BitVector finalPositiveFluents = problem.getGoal().getPositiveFluents();
        final BitVector finalNegativeFluents = problem.getGoal().getNegativeFluents();
        //Here, we care only about fluents that are explicitly specified
        for (int i = 0; i < problem.getFluents().size(); i++) {
            if (finalPositiveFluents.get(i)) {
                //Adds the fluent to the goal as true; it is assumed since it must always be at state planLength
                assumeFluent(i, planLength, true);
            }
            if (finalNegativeFluents.get(i)) {
                //Adds the fluent to the goal as false; it is assumed since it must always be at state planLength
                assumeFluent(i, planLength, false);
            }
        }
    }

    /**
     * Encodes all actions of the problem that may be taken at a given state (between states <code>0</code> and
     * <code>planLength - 1</code>).
     * @param state     the state where the actions are supposed to be chosen
     */
    protected void encodeActions(int state) {
        /*
            We have to differentiate the different actions that can be taken for each state (i.e. moving at step 0 is
            different from moving at step 1)
         */
        for (int actionIndex = 0; actionIndex < problem.getActions().size(); actionIndex++) {
            encodeAction(actionIndex, state);
        }
    }

    /**
     * Encodes one action of the problem that may be taken at a given state (between states <code>0</code> and
     * <code>planLength - 1</code>).
     * @param actionIndex   the index of the action in the list of actions of the instantiated problem
     * @param state         the state where the action is supposed to be chosen
     */
    protected abstract void encodeAction(int actionIndex, int state);

    /**
     * Encodes all axioms necessary to describe the frame of the problem (whose exact nature depends on the specific
     * encoding), at a specific state (between states <code>0</code> and <code>planLength - 1</code>).
     * @param state         the state where the axioms are considered
     */
    protected abstract void encodeFrameAxioms(int state);

    /**
     * Returns the last problem encoded by this encoding.
     * @return  the last problem encoded by this encoding
     */
    protected Problem getProblem() {
        return problem;
    }

    /**
     * Returns whether or not the index passed as argument has been solved as true. It is assumed that the problem has
     * already been solved.
     * @param actionindex       the index added using <code>addAction</code>
     * @param state             the state with which the index was added
     * @return                  whether the literal is true or false
     */
    protected boolean isTrue(int actionindex, int state) {
        //Translating the actions (since the first indexes are reserved for the fluents)
        actionindex += actionBeginningIndex;
        int dimacsLiteral = dimacsNotation(actionindex, state, true);
        //Getting the truth value of the variable
        return solverInstance.val(dimacsLiteral) > 0;
    }

    /**
     * A method determining, by means of the results of the solver, whether or not an action has been chosen.
     * The specific implementation of this method depends on the mapping between actions and the exact way an action
     * is encoded. For example, if the action A is encoded using the indexes 2 and 3 that both have to be true for A to
     * be considered as chosen, then this method should return true iff the solver has assigned the value "true" to both
     * the indexes 2 and 3.
     * @param actionIndex   the index of the action that is to be tested
     * @param state         the state at which the action is to be tested
     * @return              <code>true</code> if the action has been chosen at this specific state, else
     *                      <code>false</code>
     */
    protected abstract boolean actionHasBeenChosen(int actionIndex, int state);

    /**
     * Two encodings are supposed equal iff :
     *  - either they are the same object
     *  - or they are instances of the same class, and have the same clauses in their last encoding instance (not
     *  necessarily the same problem or the same solver)
     *  Whether or not a clause was added or assumed is irrelevant if the clause is present in the end for both.
     * @param obj   the compared object
     * @return      whether they are the same encoding or not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            AbstractSATEncoding other = (AbstractSATEncoding) obj;
            //Creating a set containing both added and assumed clauses
            HashSet<HashSet<Integer>> allClauses = new HashSet<>(addedClauses);
            for (Integer i : assumedClauses) {
                allClauses.add(new HashSet<>(i));
            }
            //Creating the same set for the other object
            HashSet<HashSet<Integer>> allClausesOther = new HashSet<>(other.addedClauses);
            for (Integer i : other.assumedClauses) {
                allClausesOther.add(new HashSet<>(i));
            }
            //Comparing the two sets
            return allClauses.equals(allClausesOther);
        }
        return false;
    }

    @Override
    public String toString() {
        if (problem == null) {
            return "c No problem has been encoded yet!";
        }
        return "p cnf " + dimacsNotation(actionBeginningIndex + problem.getActions().size() - 1,
            lastPlanLength - 1, true) + " " + (addedClauses.size() + assumedClauses.size()) + "\n"
            + "c Encoding of " + this.getClass() + "\n"
            + "c ***************\n"
            + "c Added clauses:\n"
            + "c ***************\n"
            + dimacsDebugStringBuilder
            + "c ***************\n"
            + "c Last assumed clauses:\n"
            + "c ***************\n"
            + dimacsDebugStringBuilderAssumed;
    }

    @Override
    public int hashCode() {
        int hash = 21;
        hash = 31 * hash + assumedClauses.hashCode();
        hash = 31 * hash + addedClauses.hashCode();
        return hash;
    }
}
