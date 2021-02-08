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
import fr.uga.pddl4j.problem.numeric.NumericVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class implements a temporal problem.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public abstract class AbstractTemporalProblem extends ADLProblem implements Numeric, Temporal {

    /**
     * Create a new temporal problem from a domain and problem.
     * @param domain The domain.
     * @param problem The problem.
     */
    public AbstractTemporalProblem(final PDDLDomain domain, final PDDLProblem problem) {
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
     * Returns the list of function symbols of the problem.
     *
     * @return the list of function symbols of the problem.
     */
    public List<String> getFunctionSymbols() {
        return super.getFunctionSymbols();
    }

    /**
     * Returns the signatures of the functions defined in the problem.
     *
     * @return the signatures of the functions defined in the problem.
     */
    public List<List<Integer>> getFunctionSignatures() {
        return super.getFunctionSignatures();
    }

    /**
     * This method is called to convert durative actions into no durative actions.
     */
    protected abstract void expandDurativeActions();

    /**
     * This method is called by the constructor.
     */
    protected void initialization() {
        // Standardize the variables symbol contained in the domain
        this.getPDDLDomain().standardize();
        // Standardize the variables symbol contained in the domain
        this.getPDDLProblem().standardize();
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
        this.initActions();
        // Encode the initial state in integer representation
        this.initInitialState();
        // Encode the goal in integer representation
        this.initGoal();
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
        // Create the predicates tables used to count the occurrences of the predicates in the initial state.
        this.createPredicatesTables();

        if (this.getRequirements().contains(PDDLRequireKey.DURATIVE_ACTIONS)) {
            this.expandDurativeActions();
        }
    }

    protected void instantiation() {
        this.instantiateActions();
        this.instantiateGoal();
    }


    protected void postinstantiation() {
        this.extractGroundInertia();
        this.extractGroundNumericInertia();
        this.simplyActionsWithGroundInertia();
        this.simplifyGoalWithGroundInertia();
    }

    protected void finalization() {
        this.extractRelevantFluents();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.extractRelevantNumericFluents(this.getIntActions());
        }

        this.initOfMapFluentIndex();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.initMapOfNumericFluentIndex();
        }

        this.finalizeGoal();

        this.finalizeInitialState();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.finalizeInitialNumericFluent();
        }
        if (this.getRequirements().contains(PDDLRequireKey.DURATIVE_ACTIONS)) {
            NumericVariable duration = new NumericVariable(NumericVariable.DURATION, 0.0);
            this.getInitialState().addNumericFluent(duration);
        }
        this.finalizeActions();
    }

}
