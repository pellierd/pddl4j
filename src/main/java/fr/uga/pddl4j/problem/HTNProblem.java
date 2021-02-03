package fr.uga.pddl4j.problem;
/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
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
import fr.uga.pddl4j.problem.operator.Method;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * This class contains all the methods needed to manipulate a HTN problem.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public class HTNProblem extends FinalizedProblem {




    /**
     * Creates a new problem from a domain and problem.
     *
     * @param domain the domain.
     * @param problem the problem.
     */
    public HTNProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }






    public void instantiate(int timeout) {
        super.instantiate(timeout);
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
        accepted.add(PDDLRequireKey.HIERARCHY);
        accepted.add(PDDLRequireKey.METHOD_PRECONDITIONS);
        return accepted;
    }

    /**
     * This method is called by the
     */
    protected void initialization() {

        // Standardize the variables symbol contained in the domain
        this.getDomain().standardize();
        // Standardize the variables symbol contained in the domain
        this.getProblem().standardize();

        // Collect the information on the type declared in the domain
        this.initTypes();
        // Collect the constants (symbols and types) declared in the domain
        this.initConstants();
        // Collect the either types of the domain
        this.initEitherTypes();
        // Collect the predicate information (symbols and signatures)
        this.initPredicates();

        // Collect the tasks information (symbols and signatures)
        this.initTasks();

        this.initPrimitiveTaskSymbols();

        this.initCompundTaskSymbols();

        // Encode the actions of the domain into integer representation
        this.encodeIntActions();

        // Encode the methods of the domain into integer representation
        this.encodeIntMethods();

        // Encode the initial state in integer representation
        this.encodeIntInit();
        // Encode the goal in integer representation
        this.encodeIntGoal();

        this.encodeIntInitialTaskNetwork();
    }


    protected void preinstantiation() {
        this.extractInertia();
        // Create the predicates tables used to count the occurrences of the predicates in the
        // initial state
        this.createPredicatesTables();
    }

    protected void instantiation() {
        this.instantiateActions();
        this.instantiateGoal();
    }

    protected void postinstantiation() {
        this.extractGroundInertia();
        this.simplyActionsWithGroundInertia();
        this.simplifyGoalWithGroundInertia();

        this.instantiateInitialTaskNetwork();
        this.instantiateMethods(this.getIntMethods(), this.getIntInitialTaskNetwork(), this.getIntActions());
        this.simplyMethodsWithGroundInertia();


    }

    protected void finalization() {
        this.extractRelevantFacts();
        this.extractRelevantTasks();

        this.initOfMapFluentIndex();

        this.initRelevantOperators();
        this.initMapOfTaskIndex();

        this.finalizeGoal();

        this.encodeInitialTaskNetwork();
        this.encodeMethods();
        this.finalizeInitialState();


        this.finalizeActions();
    }



    /**
     * Returns <code>true</code> if this problem is solvable. In the case of STRIPS planning, the method returns
     * <code>false</code> if the goal is simplified to <code>false</code> during the encoding process, otherwise the
     * method returns <code>true</code>. In the case of HTN planning, the method returns <code>false</code> if at least
     * one of the task of the initial task network is not reachable after the encoding process, i.e., as a task is set
     * to null in the tasks list of the initial task network, otherwise the method returns <code>true</code>.
     * <p>
     * Warning, it is not because the method returns <code>true</code> that the problem is solvable. It just means that
     * the encoding process can not exclude the fact that the problem is solvable.
     * </p>
     *
     * @return <code>true</code> if this problem is solvable; <code>false</code>.
     */
    public final boolean isSolvable() {
        boolean isSovable = true;
        Iterator<Integer> i = this.getInitialTaskNetwork().getTasks().iterator();
        while (i.hasNext() && isSovable) {
            isSovable = i.next() != null;
        }
        return isSovable;
    }

    /**
     * Returns true if the problem is totally ordered. The method returns true if the problem is not hierarchic.
     * A hierarchical problem is totally ordered if and only the subtasks of each method of the problem are totally
     * ordered and the initial task network is totally ordered.
     *
     * @return true if the problem is totally ordered, false otherwise.
     */
    public final boolean isTotallyOrederd() {
        boolean totallyOrdered = true;
        Iterator<Method> i = this.getMethods().iterator();
        while (i.hasNext() && totallyOrdered) {
            Method m = i.next();
            totallyOrdered = m.getTaskNetwork().isTotallyOrdered();
        }
        return totallyOrdered ? this.getInitialTaskNetwork().isTotallyOrdered() : totallyOrdered;
    }


}
