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

import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.problem.operator.AbstractGroundOperator;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Condition;
import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.problem.operator.Effect;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * This interface describes the interface of all planning problem.
 *
 * @author D. Pellier
 * @version 4.0 - 26.11.2020
 */
public interface Problem extends Serializable {

    /**
     * Returns the PDDL problem of the problem.
     *
     * @return the PDDL problem of the problem.
     */
    ParsedProblem getParsedProblem();

    /**
     * Returns the requirements of the problem.
     *
     * @return the requirements of the problem.
     */
    Set<PDDLRequireKey> getRequirements();

    /**
     * Returns the accepted requirements of the problem.
     *
     * @return the accepted requirements of the problem.
     */
    Set<PDDLRequireKey> getAcceptedRequirements();

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
     * Instantiate the problem.
     *
     * @param level the log level.
     */
    void instantiate(final Level level);

    /**
     * Returns a string representation of a specified operator.
     *
     * @param action     the action.
     * @return a string representation of the specified operator.
     */
    String toString(final Action action);

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
     * @param effect  the conditional effect.
     * @return a string representation of the specified conditional effect.
     */
    String toString(final ConditionalEffect effect);

    /**
     * Returns a short string representation of the specified operator, i.e., its name and its
     * instantiated parameters. This method can be used for actions and methods.
     *
     * @param operator  the operator.
     * @return a string representation of the specified operator.
     */
    String toShortString(final AbstractGroundOperator operator);

}
