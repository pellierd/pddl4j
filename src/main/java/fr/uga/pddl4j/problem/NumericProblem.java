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

import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.PDDLRequireKey;

import java.util.List;
import java.util.Set;

/**
 * This class implements a numeric problem.
 *
 * @author D. Pellier
 * @version 4.0 - 03.02.2021.
 */
public class NumericProblem extends AbstractNumericProblem {

    /**
     * Create a new numeric problem from a domain and problem.
     *
     * @param domain  The domain.
     * @param problem The problem.
     */
    public NumericProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
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
        this.getPDDLDomain().standardize();
        // Standardize the variables symbol contained in the domain
        this.getPDDLProblem().standardize();
        // Initialize the requirements of the problem
        this.initRequirements();
        // Collect the information on the type declared in the domain
        this.initTypes();
        // Collect the constants (symbols and types) declared in the domain
        this.initConstants();
        // Collect the either types of the domain
        this.initEitherTypes();
        // Collect the predicate information (symbols and signatures)
        this.initPredicates();
        // Collect the function information (symbols and signatures)
        this.initFunctions();
        // Encode the actions of the domain into integer representation
        this.initActions();
        // Encode the initial state in integer representation
        this.initInitialState();
        // Encode the goal in integer representation
        this.initGoal();
    }

    /**
     * This method carries out all the necessary treatment to preinstantiate the problem. In particular, it calculates
     * the static properties (Inertia) of the problem in order to prune as soon as possible the actions that can never
     * be triggered and infer of the domain that are not typing.
     */
    @Override
    protected void preinstantiation() {
        this.extractInertia();
        this.extractNumericInertia();
        // Infer the type from the unary inertia
        if (!this.getRequirements().contains(PDDLRequireKey.TYPING)) {
            this.inferTypesFromInertia();
            this.simplifyActionsWithInferredTypes();
        }
        // Create the predicates tables used to count the occurrences of the predicates in the initial state
        this.createPredicatesTables();
    }

    /**
     * This methods carries out the instantiation of the planning operators and the goal of the problem in to actions.
     */
    @Override
    protected void instantiation() {
        this.instantiateActions();
        this.instantiateGoal();
    }

    /**
     * This method carries out all the necessary treatment to postinstantiate the problem. In particular, it simplifies
     * the actions instantiated based on static properties based on the initial state information of the problem in
     * order to prune the actions that can never be triggered.
     */
    @Override
    protected void postinstantiation() {
        this.extractGroundInertia();
        this.extractGroundNumericInertia();
        this.simplyActionsWithGroundInertia();
        this.simplifyGoalWithGroundInertia();
    }

    /**
     * This methods finalize the domain, i.e., it encodes the planning problem into it final compact representation
     * using bit set.
     */
    @Override
    protected void finalization() {
        this.extractRelevantFluents();
        this.extractRelevantNumericFluents(this.getIntActions());
        this.initOfMapFluentIndex();
        this.initMapOfNumericFluentIndex();
        this.finalizeGoal();
        this.finalizeInitialState();
        this.finalizeInitialNumericFluent();
        this.finalizeActions();
    }

}
