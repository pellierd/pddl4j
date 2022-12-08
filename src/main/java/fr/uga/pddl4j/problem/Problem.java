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

import fr.uga.pddl4j.parser.DefaultParsedProblem;
import fr.uga.pddl4j.parser.Expression;
import fr.uga.pddl4j.parser.RequireKey;
import fr.uga.pddl4j.parser.Symbol;
import fr.uga.pddl4j.plan.Hierarchy;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.problem.operator.AbstractInstantiatedOperator;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Condition;
import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.problem.operator.DurativeAction;
import fr.uga.pddl4j.problem.operator.DurativeMethod;
import fr.uga.pddl4j.problem.operator.Effect;
import fr.uga.pddl4j.problem.operator.Method;
import fr.uga.pddl4j.problem.operator.TaskNetwork;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This interface describes the interface of all planning problem.
 *
 * @author D. Pellier
 * @version 4.0 - 26.11.2020
 */
public interface Problem extends Serializable, AtomicFormulaSimplifier<Integer> {

    /**
     * Returns the PDDL problem of the problem.
     *
     * @return the PDDL problem of the problem.
     */
    DefaultParsedProblem getParsedProblem();

    /**
     * Returns the requirements of the problem.
     *
     * @return the requirements of the problem.
     */
    Set<RequireKey> getRequirements();

    /**
     * Returns the accepted requirements of the problem.
     *
     * @return the accepted requirements of the problem.
     */
    Set<RequireKey> getAcceptedRequirements();

    /**
     * Returns the list of the type symbols of the problem.
     *
     * @return the list of the type symbols of the problem.
     */
    List<String> getTypes();

    /**
     * Returns the domains for each type of the problem.
     *
     * @return the domains for each type of the problem.
     */
    Map<Integer, Set<Symbol<Integer>>> getDomains();

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
    List<List<Symbol<Integer>>> getPredicateSignatures();

    /**
     * Returns the list of relevant fluents used the problem.
     *
     * @return the list of relevant fluents used the problem.
     */
    List<Fluent> getFluents();

    /**
     * Returns the list of instantiated actions of the problem.
     *
     * @return the list of instantiated actions of the problem.
     */
    List<Action> getActions();

    /**
     * Returns the list of instantiated durative actions of the problem.
     *
     * @return the list of instantiated durative actions of the problem.
     */
    List<DurativeAction> getDurativeActions();

    /**
     * Returns the list of instantiated methods of the problem.
     *
     * @return the list of instantiated methods of the problem.
     */
    List<Method> getMethods();

    /**
     * Returns the list of instantiated methods of the problem.
     *
     * @return the list of instantiated methods of the problem.
     */
    List<DurativeMethod> getDurativeMethods();

    /**
     * The list of relevant tasks of the problem.
     *
     * @return the list of relevant tasks of the problem.
     */
    List<Task> getTasks();

    /**
     * Returns the relevant operators for the tasks of the problem. The method return {@code null} if the problem is
     * not hierarchical.
     * <p>
     *     Warning a task may have many resolvers event primitives tasks.
     * </p>
     * The resolvers returned are indexes of operators. To get the list of resolvers of a specific task {@code t} just
     * write:
     * <pre>{@code
     *     List<Integer> resolvers = problem.getTaskResolvers().get(t)
     * }</pre>
     * Two case must be considered.
     * <ul>
     * <li> If the task {@code t} is primitive, i.e., {@code problem.getTask(t).isPrimtive()}
     * returns true, the list of resolvers contains either indexes of actions either indexes of durative actions.
     * If the index is positive the index represents an action. To get the corresponding action just use
     * {@code problem.getActions(index)}. If the index is negative the index represents a durative action.
     * To get the corresponding durative action just use {@code problem.getDurativeActions(-index - 1)}.</li>
     * <li>Symmetrically, if the task {@code t} is compound, i.e., {@code problem.getTask(t).isCompound()}
     * returns true, the list of resolvers contains either indexes of method either indexes of durative methods.
     * If the index is positive the index represents a method. To get the corresponding method just use
     * {@code problem.getMethods(index)}. If the index is negative the index represents a durative method.
     * To get the corresponding durative method just use {@code problem.getDurativeMethods(-index - 1)}.</li>
     * </ul>
     * @return the relevant operators for a task.
     */
    List<List<Integer>> getTaskResolvers();

    /**
     * Returns the goal of the problem or null if the goal can is not reachable.
     *
     * @return the goal of the problem.
     */
    Condition getGoal();

    /**
     * Returns the initial state of the problem.
     *
     * @return the initial state of the problem.
     */
    InitialState getInitialState();

    /**
     * Returns the initial task network of the problem.
     *
     * @return the initial task network of the problem.
     */
    TaskNetwork getInitialTaskNetwork();

    /**
     * Returns <code>true</code> if this problem is solvable. It is not because the method returns <code>true</code>
     * that the problem is solvable. It just means that instantiation process can not exclude the fact that the problem
     * is solvable.
     *
     * @return <code>true</code> if this problem is solvable; <code>false</code>.
     */
    boolean isSolvable();

    /**
     * Instantiate the problem.
     */
    void instantiate();

    /**
     * Returns a string representation of a specified action.
     *
     * @param action the action.
     * @return a string representation of the specified action.
     */
    String toString(final Action action);

    /**
     * Returns a string representation of a specified durative action.
     *
     * @param action the action.
     * @return a string representation of the specified durative action.
     */
    String toString(final DurativeAction action);

    /**
     * Returns a string representation of a specified method.
     *
     * @param method the method.
     * @return a string representation of the specified method.
     */
    String toString(final Method method);

    /**
     * Returns a string representation of a specified durative method.
     *
     * @param method the method.
     * @return a string representation of the specified durative method.
     */
    String toString(final DurativeMethod method);

    /**
     * Returns a string representation of a specified task.
     *
     * @param task the task.
     * @return a string representation of the specified task.
     */
    String toString(final Task task);

    /**
     * Returns a string representation of a specified task network.
     *
     * @param network the task network..
     * @return a string representation of the specified task network.
     */
    String toString(final TaskNetwork network);

    /**
     * Returns a string representation of a hierarchical decomposition of plan.
     *
     * @param hierarchy the hierarchical decomposition to convert into string represention.
     * @return the string representation of the he hierarchical decomposition in parameter.
     */
    String toString(final Hierarchy hierarchy);

    /**
     * Returns a string representation of a state.
     *
     * @param condition the state.
     * @return a string representation of the state.
     */
    String toString(final Condition condition);

    /**
     * Returns a string representation of a state.
     *
     * @param effect the state.
     * @return a string representation of the state.
     */
    String toString(final Effect effect);

    /**
     * Returns a string representation of a closed world state.
     *
     * @param state the state.
     * @return a string representation of the specified expression.
     */
    String toString(final State state);

    /**
     * Returns a string representation of a initial state.
     *
     * @param state the state.
     * @return a string representation of the specified expression.
     */
    String toString(final InitialState state);

    /**
     * Returns a string representation of a fluent.
     *
     * @param fluent the formula.
     * @return a string representation of the specified expression.
     */
    String toString(final Fluent fluent);

    /**
     * Return a string representation of a search.
     *
     * @param plan the search.
     * @return a string representation of the specified search.
     */
    String toString(final Plan plan);

    /**
     * Returns a string representation of a conditional effect.
     *
     * @param effect the conditional effect.
     * @return a string representation of the specified conditional effect.
     */
    String toString(final ConditionalEffect effect);

    /**
     * Returns a short string representation of the specified operator, i.e., its name and its
     * instantiated parameters. This method can be used for actions and methods.
     *
     * @param operator the operator.
     * @return a string representation of the specified operator.
     */
    String toShortString(final AbstractInstantiatedOperator operator);

    /**
     * Simply an atomic formula based on the inertia and the initial state of the problem. The atomic formula in
     * parameter must be an expression of type ATOM. The simplification can be done with totally or partially
     * instantiated atom. When the atom can be simplified, its connector is modified to TRUE or FALSE.
     *
     * @param atom the atomic formula.
     * @return if the atom can be simplify to TRUE or FALSE.
     */
    boolean simplify(final Expression<Integer> atom);

    /**
     * Returns true if the problem is totally ordered. The method returns true if the problem is not hierarchical, i.e.,
     * contains no methods durative or not and no no initial task network. A hierarchical problem is totally ordered if
     * and only the subtasks of each method of the problem are totally ordered and the initial task network is totally
     * ordered.
     *
     * @return true if the problem is totally ordered, false otherwise.
     */
    boolean isTotallyOrdered();

}
