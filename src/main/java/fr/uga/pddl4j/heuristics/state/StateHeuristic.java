/*
* Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
*
* This file is part of PDDL4J library.
*
* PDDL4J is free software: you can redistribute it and/or modify * it under the terms of the GNU General Public License
* as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
*
* PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
* of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License * along with PDDL4J.  If not,
* see <http://www.gnu.org/licenses/>
*/

package fr.uga.pddl4j.heuristics.state;

import fr.uga.pddl4j.heuristics.Heuristic;
import fr.uga.pddl4j.planners.statespace.search.Node;
import fr.uga.pddl4j.problem.ADLProblem;
import fr.uga.pddl4j.problem.State;
import fr.uga.pddl4j.problem.operator.Condition;

/**
 * This interface defines the methods accessible from all goal cost heuristics. An goal cost heuristic is a function
 * that estimates the remaining distance to the goal. In order to find this estimation an heuristic
 * function tries to solve a relaxed problem.
 * <p>
 * To have an good overview of the planning heuristics developed in this package see D. Bryce and S.
 * Kambhampati. "A Tutorial on Planning Graph Based Reachability Heuristics", 2006.
 * </p>
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
public interface StateHeuristic extends Heuristic {

    /**
     * The name of heuristics.
     */
    public enum Name {
        /**
         * The type for the <code>AdjustedSum</code> heuristic.
         */
        AJUSTED_SUM,
        /**
         * The type for the <code>AdjustedSum2</code> heuristic.
         */
        AJUSTED_SUM2,
        /**
         * The type for the <code>AdjustedSum2M</code> heuristic.
         */
        AJUSTED_SUM2M,
        /**
         * The type for the <code>Combo</code> heuristic.
         */
        COMBO,
        /**
         * The type for the <code>Max</code> heuristic.
         */
        MAX,
        /**
         * The type for the <code>FF</code> heuristic.
         */
        FAST_FORWARD,
        /**
         * The type for the <code>SetLevel</code> heuristic.
         */
        SET_LEVEL,
        /**
         * The type for the <code>Sum</code> heuristic.
         */
        SUM,
        /**
         * The type for the <code>SumMutex</code> heuristic.
         */
        SUM_MUTEX,
    }

    /**
     * Return the estimated distance to the goal to reach the specified state. If the return value is
     * <code>Integer.MAX_VALUE</code>, it means that the goal is unreachable from the specified
     * state.
     *
     * @param state the state from which the distance to the goal must be estimated.
     * @param goal  the goal expression.
     * @return the distance to the goal state from the specified state.
     */
    int estimate(final State state, final Condition goal);

    /**
     * Return the estimated distance to the goal to reach the specified state. If the return value is
     * <code>Integer.MAX_VALUE</code>, it means that the goal is unreachable from the specified
     * state.
     *
     * @param node the ndoe from which the distance to the goal must be estimated.
     * @param goal the goal expression.
     * @return the distance to the goal state from the specified state.
     */
    double estimate(final Node node, final Condition goal);

    /**
     * Returns <code>true</code> if this heuristic is admissible.
     *
     * @return <code>true</code> if this heuristic is admissible.
     */
    boolean isAdmissible();

    /**
     * Create an instance of a goal cost heuristic for a specified problem.
     *
     * @param name    the name of the heuristic to create.
     * @param problem the problem for which the heuristic is created.
     * @return the heuristic created.
     */
    public static StateHeuristic getInstance(final StateHeuristic.Name name, final ADLProblem problem) {
        switch (name) {
            case FAST_FORWARD:
                return new FastForward(problem);
            case SUM:
                return new Sum(problem);
            case SUM_MUTEX:
                return new SumMutex(problem);
            case AJUSTED_SUM:
                return new AdjustedSum(problem);
            case AJUSTED_SUM2:
                return new AdjustedSum2(problem);
            case AJUSTED_SUM2M:
                return new AjustedSum2M(problem);
            case COMBO:
                return new Combo(problem);
            case MAX:
                return new Max(problem);
            case SET_LEVEL:
                return new SetLevel(problem);
            default:
                return null;
        }
    }

}
