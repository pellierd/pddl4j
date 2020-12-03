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

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.encoding.AbstractGroundOperator;
import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.plan.Hierarchy;
import fr.uga.pddl4j.plan.Plan;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * This interface describs the interface of all planning problem.
 *
 * @author D. Pellier
 * @version 1.0 - 26.11.2020
 */
public interface Problem extends Serializable {

    /**
     * Returns the requirements of the problem.
     *
     * @return the requirements of the problem.
     */
    Set<PDDLRequireKey> getRequirements();

    /**
     * Returns the list of the type symbols of the problem.
     *
     * @return the list of the type symbols of the problem.
     */
    List<String> getTypeSymbols();

    /**
     * Returns the domains for each type of the problem.
     *
     * @return the domains for each type of the problem.
     */
    List<Set<Integer>> getDomains();

    /**
     * Returns the list of constant symbols of the problem.
     *
     * @return the list of constant symbols of the problem.
     */
    List<String> getConstantSymbols();

    /**
     * Returns the list of predicate symbols of the problem.
     *
     * @return the list predicate symbols of the problem.
     */
    List<String> getPredicateSymbols();

    /**
     * Returns the signatures of the predicates defined in the problem.
     *
     * @return the signatures of the predicates defined in the problem.
     */
    List<List<Integer>> getPredicateSignatures();

    /**
     * Returns the list of task symbols of the problem.
     *
     * @return the list of task symbols of the problem.
     */
    List<String> getTaskSymbols();

    /**
     * Returns the signatures of the task defined in the problem.
     *
     * @return the signatures of the task defined in the problem.
     */
    List<List<Integer>> getTaskSignatures();

    /**
     * Returns the list of function symbols of the problem.
     *
     * @return the list of function symbols of the problem.
     */
    List<String> getFunctionSymbols();

    /**
     * Returns the signatures of the functions defined in the problem.
     *
     * @return the signatures of the functions defined in the problem.
     */
    List<List<Integer>> getFunctionSignatures();

    /**
     * Returns the list of relevant fluents used the problem.
     *
     * @return the list of relevant fluents used the problem.
     */
    //List<Fluent> getRelevantFluents();

    /**
     * Returns the list of relevant operators, i.e., that may achieve it, for each task of the problem. A relevant
     * operator can be a action or method depending if the task is primitive or not.
     *
     * @return the list of relevant operators for the tasks of the problem.
     */
    //List<List<Integer>> getRelevantOperators();

    /**
     * Returns the list of tasks of the problem. The method returns null if the problem is not HTN.
     *
     * @return the list of tasks of the problem.
     */
    //List<Task> getRelevantTasks();

    /**
     * Returns the list of instantiated actions of the problem.
     *
     * @return the list of instantiated actions of the problem.
     */
    //List<Action> getActions();

    /**
     * Returns the list of instantiated methods of the problem. The method returns null if the problem is not HTN.
     *
     * @return the list of instantiated methods of the problem.
     */
    //List<Method> getMethods();

    /**
     * Returns the goal of the problem or null if the goal can is not reachable.
     *
     * @return the goal of the problem.
     */
    //Condition getGoal();

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
    //boolean isSolvable();

    /**
     * Instantiate the problem.
     *
     * @param timeout the time in second allocated to the instantiation.
     */
    void instantiate(final int timeout);
    //void instantiate(long timeout);
    /**
     * Returns the initial state of the problem.
     *
     * @return the initial state of the problem.
     */
    //InitialState getInitialState();

    /**
     * Returns the initial task network. This method returns null if the problem is not a HTN problem.
     *
     * @return the initial task network.
     */
    //TaskNetwork getInitialTaskNetwork();

    /**
     * Returns true if the problem is totally ordered. The method returns true if the problem is not hierarchic.
     * A hierarchical problem is totally ordered if and only the subtasks of each method of the problem are totally
     * ordered and the initial task network is totally ordered.
     *
     * @return true if the problem is totally ordered, false otherwise.
     */
    //boolean isTotallyOrederd();

    /**
     * Returns a string representation of a specified operator.
     *
     * @param action     the action.
     * @return a string representation of the specified operator.
     */
    //String toString(final Action action);

    /**
     * Returns a string representation of the specified method.
     *
     * @param method the method.
     * @return a string representation of the specified method.
     */
    //String toString(final Method method);

    /**
     * Returns a string representation of a state.
     *
     * @param condition the state.
     * @return a string representation of the state.
     */
    //String toString(final Condition condition);

    /**
     * Returns a string representation of a state.
     *
     * @param effect the state.
     * @return a string representation of the state.
     */
    //String toString(final Effect effect);

    /**
     * Returns a string representation of a closed world state.
     *
     * @param state the state.
     * @return a string representation of the specified expression.
     */
    //String toString(final State state);

    /**
     * Returns a string representation of the specified task network.
     *
     * @param tasknetwork the task network.
     * @return a string representation of the specified task network.
     */
    //String toString(final TaskNetwork tasknetwork);

    /**
     * Returns a string representation of a fluent.
     *
     * @param fluent the formula.
     * @return a string representation of the specified expression.
     */
    //String toString(final Fluent fluent);

    /**
     * Returns a string representation of a task.
     *
     * @param task the formula.
     * @return a string representation of the specified expression.
     */
    //String toString(final Task task);

    /**
     * Return a string representation of a search.
     *
     * @param plan the search.
     * @return a string representation of the specified search.
     */
    //String toString(final Plan plan);

    /**
     * Returns a string representation of a conditional effect.
     *
     * @param effect  the conditional effect.
     * @return a string representation of the specified conditional effect.
     */
    //String toString(final ConditionalEffect effect);

    /**
     * Returns a string representation of a hierarchical decomposition of plan.
     *
     * @param hierarchy the hierarchical decomposition to convert into string represention.
     * @return the string representation of the he hierarchical decomposition in parameter.
     */
    //String toString(final Hierarchy hierarchy);

    /**
     * Returns a short string representation of the specified operator, i.e., its name and its
     * instantiated parameters. This method can be used for actions and methods.
     *
     * @param operator  the operator.
     * @return a string representation of the specified operator.
     */
    //String toShortString(final AbstractGroundOperator operator);

}
