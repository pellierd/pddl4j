package fr.uga.pddl4j.problem;

/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.parser.ParsedProblem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * This class implements an ADL problem.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public class ADLProblem extends FinalizedProblem {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(ADLProblem.class.getName());

    /**
     * Create a new ADL problem from a domain and problem.
     * @param problem The problem.
     */
    public ADLProblem(final ParsedProblem problem) {
        super(problem);
    }

    /**
     * Returns the list of PDDL requirements accepted by the problem.
     *
     * @return the list of PDDL requirements accepted by the problem.
     */
    @Override
    public Set<PDDLRequireKey> getAcceptedRequirements() {
        Set<PDDLRequireKey> accepted = new HashSet<>();
        accepted.add(PDDLRequireKey.ADL);
        accepted.add(PDDLRequireKey.STRIPS);
        accepted.add(PDDLRequireKey.TYPING);
        accepted.add(PDDLRequireKey.EQUALITY);
        accepted.add(PDDLRequireKey.NEGATIVE_PRECONDITIONS);
        accepted.add(PDDLRequireKey.DISJUNCTIVE_PRECONDITIONS);
        accepted.add(PDDLRequireKey.EXISTENTIAL_PRECONDITIONS);
        accepted.add(PDDLRequireKey.UNIVERSAL_PRECONDITIONS);
        accepted.add(PDDLRequireKey.QUANTIFIED_PRECONDITIONS);
        accepted.add(PDDLRequireKey.CONDITIONAL_EFFECTS);
        return accepted;
    }

    /**
     * This methods initializes the structures needed to the instantiation process from the PDDL domain and problem
     * given in parameters of the constructor of the class. First, it collects the constants, the types, the predicate,
     * the function and the tasks symbols. Then, it encodes the actions, the methods, the goal and the initial tasks
     * network of the problem into compact int representation.
     */
    @Override
    protected void initialization() {

        // Standardize the variables symbol contained in the domain
        this.getParsedProblem().standardize();

        // Collect the requirements of the problem.
        this.initRequirements();

        // Collect the information on the type declared in the domain
        this.initTypes();
        // Collect the constants (symbols and types) declared in the domain
        this.initConstants();
        // Collect the either types of the domain
        this.initEitherTypes();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Types declared:\n"
                + this.toString(Data.TYPES) + "\n");
            LOGGER.debug("Constants declared in the problem:\n"
                + this.toString(Data.CONSTANT_SYMBOLS) + "\n");
        }

        // Collect the predicate information (symbols and signatures)
        this.initPredicates();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Predicates declared:\n"
                + this.toString(Data.PREDICATE_SIGNATURES) + "\n");
        }

        // Encode the actions of the domain into integer representation
        this.initActions();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions declared:\n\n"
                + this.toString(Data.INT_ACTIONS));
        }

        // Encode the initial state in integer representation
        this.initInitialState();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initial state declared :\n"
                + this.toString(Data.INT_INITIAL_STATE) + "\n");
        }

        // Encode the goal in integer representation
        this.initGoal();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Goal declared:\n"
                + this.toString(Data.INT_GOAL) + "\n");
        }
    }

    /**
     * This method carries out all the necessary treatment to preinstantiate the problem. In particular, it calculates
     * the static properties (Inertia) of the problem in order to prune as soon as possible the actions that can never
     * be triggered.
     */
    @Override
    protected void preinstantiation() {
        // Extract the inertia from the list of actions
        this.extractInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Inertia detected:\n"
                + this.toString(Data.INERTIA) + "\n");
        }
        // Infer the type from the unary inertia
        if (!this.getRequirements().contains(PDDLRequireKey.TYPING)) {
            this.inferTypesFromInertia();
            this.simplifyActionsWithInferredTypes();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Actions with inferred types:\n\n"
                    + this.toString(Data.INT_ACTIONS) + "\n");
            }
        }
        // Create the predicates tables used to count the occurrences of the predicates in the
        // initial state
        this.createPredicatesTables();
    }

    /**
     * This methods carries out the instantiation of the planning operators and the goal of the problem in to actions.
     */
    @Override
    protected void instantiation() {
        // Instantiate the actions and the goal
        this.instantiateActions();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions instantiated:\n\n"
                + this.toString(Data.INT_ACTIONS) + "\n");
        }
        this.instantiateGoal();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Goal instantiated:\n"
                + this.toString(Data.INT_GOAL) + "\n");
        }
    }

    /**
     * This method carries out all the necessary treatment to postinstantiate the problem. In particular, it simplifies
     * the actions instantiated based on static properties based on the initial state information of the problem in
     * order to prune the actions that can never be triggered.
     */
    @Override
    protected void postinstantiation() {
        // Extract the ground inertia and simplify the actions and the goal
        this.extractGroundInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Ground inertia detected:\n\n"
                + this.toString(Data.GROUND_INERTIA) + "\n");
        }
        this.simplyActionsWithGroundInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions simplified base on ground inertia detected:\n\n"
                + this.toString(Data.INT_ACTIONS) + "\n");
        }
        this.simplifyGoalWithGroundInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Goal simplified base on ground in‡ertia detected:\n"
                + this.toString(Data.INT_GOAL) + "\n");
        }
    }

    /**
     * This methods finalize the domain, i.e., it encodes the planning problem into it final compact representation
     * using bit set.
     */
    protected void finalization() {
        this.extractRelevantFluents();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Relevant fluents:\n"
                + this.toString(Data.FLUENTS) + "\n");
        }
        this.initOfMapFluentIndex();
        this.finalizeActions();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions:\n\n"
                + this.toString(Data.ACTIONS) + "\n");
        }
        this.finalizeInitialState();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initial state:\n"
                + this.toString(Data.INITIAL_STATE) + "\n");
        }
        this.finalizeGoal();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Goal:\n"
                + this.toString(Data.GOAL) + "\n");
        }

    }

    /**
     * Returns <code>true</code> if this problem is solvable. The method returns <code>false</code> if the goal is
     * simplified to <code>false</code> during the instantiation process, otherwise the method returns
     * <code>true</code>.
     *
     * <p>
     * Warning, it is not because the method returns <code>true</code> that the problem is solvable. It just means that
     * the encoding process can not exclude the fact that the problem is solvable.
     * </p>
     *
     * @return <code>true</code> if this problem is solvable; <code>false</code>.
     */
    public boolean isSolvable() {
        return this.getGoal() != null;
    }


}
