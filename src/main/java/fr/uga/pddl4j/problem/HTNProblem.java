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
import fr.uga.pddl4j.problem.operator.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;

/**
 * This class contains all the methods needed to manipulate a HTN problems.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public class HTNProblem extends AbstractHTNProblem {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(HTNProblem.class.getName());

    /**
     * Creates a new problem from a domain and problem.
     *
     * @param problem the problem.
     */
    public HTNProblem(final ParsedProblem problem) {
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

        // Collect the tasks information (symbols and signatures)
        this.initTasks();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Tasks declared:\n"
                + this.toString(Data.TASK_SIGNATURES) + "\n");
        }

        // Init the list of primitive task symbols
        this.initPrimitiveTaskSymbols();
        // Init the list of compound task symbols
        this.initCompoundTaskSymbols();

        // Encode the actions of the domain into integer representation
        this.initActions();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions declared:\n\n"
                + this.toString(Data.INT_ACTIONS));
        }

        // Encode the methods of the domain into integer representation
        this.initMethods();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Methods declared:\n\n"
                + this.toString(Data.INT_METHODS));
        }

        // Encode the initial state in integer representation
        this.initInitialState();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initial state declared :\n"
                + this.toString(Data.INT_INITIAL_STATE) + "\n");
        }

        // Encode the initial task network
        this.initInitialTaskNetwork();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initial task network declared:\n"
                + this.toString(Data.INT_INITIAL_TASK_NETWORK) + "\n");
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
     * be triggered and infer of the domain that are not typing.
     */
    @Override
    protected void preinstantiation() {
        this.extractInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Inertia detected:\n"
                + this.toString(Data.INERTIA) + "\n");
        }
        // Create the predicates tables used to count the occurrences of the predicates in the initial state/
        this.createPredicatesTables();
    }

    /**
     * This methods carries out the instantiation of the planning operators and the goal of the problem in to actions.
     */
    @Override
    protected void instantiation() {
        super.instantiation();
    }

    /**
     * This method carries out all the necessary treatment to postinstantiate the problem. In particular, it simplifies
     * the actions instantiated based on static properties based on the initial state information of the problem in
     * order to prune the actions that can never be triggered.
     */
    @Override
    protected void postinstantiation() {
        super.postinstantiation();
        this.instantiateInitialTaskNetwork();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initial tasknetwork instantiated:\n"
                + this.toString(Data.INT_INITIAL_TASK_NETWORK) + "\n");
        }

        this.instantiateMethods();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Methods instantiated:\n\n"
                + this.toString(Data.INT_METHODS));
        }
        this.simplyMethodsWithGroundInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Methods simplified based on ground inertia:\n\n"
                + this.toString(Data.INT_METHODS));
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
        this.initOfMapFluentIndex();
        this.finalizeActions();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions:\n\n"
                + this.toString(Data.ACTIONS) + "\n");
        }
        this.extractRelevantTasks();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Relevant tasks:\n"
                + this.toString(Data.TASKS) + "\n");
        }

        this.initTaskResolvers();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Task resolvers:\n\n"
                + this.toString(Data.TASK_RESOLVERS) + "\n");
        }

        this.initMapOfTaskIndex();
        this.finalizeMethods();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Methods:\n\n"
                + this.toString(Data.METHODS) + "\n");
        }

        this.finalizeInitialState();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initial state:\n"
                + this.toString(Data.INITIAL_STATE) + "\n");
        }

        this.finalizeInitialTaskNetwork();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initial tasknetwork:\n"
                + this.toString(Data.INITIAL_TASK_NETWORK));
        }

        this.finalizeGoal();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Goal:\n"
                + this.toString(Data.GOAL));
        }
    }

    /**
     * Returns <code>true</code> if this problem is solvable. The method returns <code>false</code> if at least
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

        boolean isSolvable = super.isSolvable();
        Iterator<Integer> i = this.getInitialTaskNetwork().getTasks().iterator();
        while (i.hasNext() && isSolvable) {
            isSolvable = i.next() != null;
        }
        return isSolvable;
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
