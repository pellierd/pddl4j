package fr.uga.pddl4j.problem;
/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.problem.numeric.NumericVariable;

import java.util.HashSet;
import java.util.Set;

/**
 * This class implements a ADL problem.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public class ADLProblem extends PostInstantiatedProblem {

    /**
     * Create a new ADL problem from a domain and problem.
     * @param domain The domain.
     * @param problem The problem.
     */
    public ADLProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }

    /**
     * Returns the list of PDDL requirements accepted by the problem.
     */
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
        accepted.add(PDDLRequireKey.DURATIVE_ACTIONS);
        accepted.add(PDDLRequireKey.DURATION_INEQUALITIES);
        accepted.add(PDDLRequireKey.NUMERIC_FLUENTS);
        return accepted;
    }

    /**
     * This method is called by the constructor.
     */
    protected void init () {

        // Standardize the variables symbol contained in the domain
        this.getDomain().standardize();
        // Standardize the variables symbol contained in the domain
        this.getProblem().standardize();

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
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.initFunctions();
        }
        // Collect the tasks information (symbols and signatures)
        this.initTasks();

        // Encode the actions of the domain into integer representation
        this.encodeIntActions();

        // Encode the methods of the domain into integer representation
        //if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
        //    this.encodeIntMethods();
        //}

        // Encode the initial state in integer representation
        this.encodeIntInit();
        // Encode the goal in integer representation
        this.encodeIntGoal();

        // Encode the initial task network in integer representation
        //if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
        //    this.encodeIntInitialTaskNetwork();
        //}
    }

    protected void preinstantiation() {
        this.extractInertia();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.extractNumericInertia();
        }

        // Infer the type from the unary inertia
        if (!this.getRequirements().contains(PDDLRequireKey.TYPING)) {
            //&&!this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.inferTypesFromInertia();
            this.simplifyActionsWithInferredTypes();
        }
        // Create the predicates tables used to count the occurrences of the predicates in the
        // initial state
        this.createPredicatesTables();

        if (this.getRequirements().contains(PDDLRequireKey.DURATIVE_ACTIONS)) {
            this.expandTemporalActions(this.getIntActions());
        }
    }

    protected void instantiation() {
        this.instantiateActions();

        this.extractGroundInertia();
        this.extractGroundNumericInertia();
        this.simplyActionsWithGroundInertia();
        this.instantiateGoal();
        this.simplifyGoalWithGroundInertia();
        /*if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.instantiateInitialTaskNetwork();
            this.instantiateMethods(this.getIntMethods(), this.getIntInitialTaskNetwork(), this.getIntActions());
            this.simplyMethodsWithGroundInertia();
        }*/

    }


    protected void postinstantiation() {
        this.extractRelevantFacts();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.extractRelevantNumericFluents(this.getIntActions());
        }
        //if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
        //    this.extractRelevantTasks();
        //}

        this.initOfMapFluentIndex();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.initMapOfNumericFluentIndex();
        }

        //if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
        //    this.initRelevantOperators();
        //    this.initMapOfTaskIndex();
        //}

        this.encodeGoal();

        //if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
        //    this.encodeInitialTaskNetwork();
        //    this.encodeMethods();
        //}

        this.encodeInit();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.encodeInitNumericFluent();
        }
        if (this.getRequirements().contains(PDDLRequireKey.DURATIVE_ACTIONS)) {
            NumericVariable duration = new NumericVariable(NumericVariable.DURATION, 0.0);
            this.getInitialState().addNumericFluent(duration);
        }
        this.encodeActions();

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
