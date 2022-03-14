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

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.parser.ParsedProblem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class implements a numeric problem.
 *
 * @author D. Pellier
 * @version 4.0 - 03.02.2021.
 */
public class NumericProblem extends AbstractNumericProblem {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(NumericProblem.class.getName());

    /**
     * Create a new numeric problem from a domain and problem.
     *
     * @param problem The problem.
     */
    public NumericProblem(final ParsedProblem problem) {
        super(problem);
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
        // Initialize the requirements of the problem
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

        // Collect the function information (symbols and signatures)
        this.initFunctions();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Functions declared:\n"
                + this.toString(Data.FUNCTION_SIGNATURES) + "\n");
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
     * This method carries out all the necessary treatments to preinstantiate the problem. In particular, it calculates
     * the static properties (Inertia) of the problem in order to prune as soon as possible the actions that can never
     * be triggered and infer of the domain that are not typing.
     */
    @Override
    protected void preinstantiation() {
        super.preinstantiation();
        this.extractNumericInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Numeric inertia detected:\n"
                + this.toString(Data.NUMERIC_INERTIA) + "\n");
        }
    }

    /**
     * This methods carries out the instantiation of the planning operators and the goal of the problem in to actions.
     */
    @Override
    protected void instantiation() {
        super.instantiation();
    }

    /**
     * This method carries out all the necessary treatments to postinstantiate the problem. In particular, it simplifies
     * the actions instantiated based on static properties based on the initial state information of the problem in
     * order to prune the actions that can never be triggered.
     */
    @Override
    protected void postinstantiation() {
        this.extractGroundInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Ground inertia detected:\n\n"
                + this.toString(Data.GROUND_INERTIA) + "\n");
        }
        this.extractGroundNumericInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Ground numeric inertia detected:\n\n"
                + this.toString(Data.GROUND_NUMERIC_INERTIA) + "\n");
        }
        this.simplyActionsWithGroundInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions simplified base on ground inertia detected:\n\n"
                + this.toString(Data.INT_ACTIONS) + "\n");
        }
        this.simplifyGoalWithGroundInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Goal simplified base on ground inertia detected:\n"
                + this.toString(Data.INT_GOAL) + "\n");
        }
    }

    /**
     * This methods finalize the domain, i.e., it encodes the planning problem into it final compact representation
     * using bit set.
     */
    @Override
    protected void finalization() {
        this.extractRelevantFluents();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Relevant fluents:\n"
                + this.toString(Data.FLUENTS) + "\n");
        }

        this.extractRelevantNumericFluents();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Relevant numeric fluents:\n"
                + this.toString(Data.NUMERIC_FLUENTS) + "\n");
        }

        this.initOfMapFluentIndex();
        this.initMapOfNumericFluentIndex();

        this.finalizeActions();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions:\n\n"
                + this.toString(Data.ACTIONS) + "\n");
        }

        this.finalizeInitialState();
        this.finalizeInitialNumericFluent();
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


}
