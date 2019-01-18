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

package fr.uga.pddl4j.heuristics.relaxation;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.util.BitExp;
import fr.uga.pddl4j.util.BitState;

/**
 * This class implements the SUM_ID heuristic. (for more details on this heuristic see Blai Bonet and
 * Hector Geffner, Planning as Heuristic Search, Artificial Intelligence 129, 2001, Elsevier)
 * <p>
 * The principle of this heuristics function <i>h</i> is to resolved a relaxed the planning problem
 * <i>P'</i> in which all delete list are ignored. The cost of achieving an atom <i>p</i> form the
 * state <i>s</i> is noted <i>gs(p)</i>. These estimates can be defined recursively as:
 * </p>
 * <ul>
 * <li> <i>gs(p)</i> = 0, if <i>p</i> is in <i>s</i>,
 * <li> <i>gs(p)</i> = min[1 + <i>gs(Prec(op))]</i> for each <i>op</i> in <i>O(p)</i>, otherwise
 * </ul>
 * <p>where <i>O(p)</i> stands for the actions <i>op</i> that add <i>p</i>, i.e., with <i>p</i> in
 * <i>Add(op)</i>, and <i>gs(Prec(op))</i>, to be defined below, stands for the estimated cost of
 * achieving the preconditions of action <i>op</i> from <i>s</i>. The cost <i>gs(C)</i> of a sets
 * of atoms is defined as the weighted sum of the costs of individual atoms:
 * </p>
 * <ul>
 * <li> <i>hsum(C)</i> = sum <i>gs(r)</i> for all <i>r</i> in <i>C</i> (additive costs)
 * </ul>
 * <p>The heuristic assumes that subgoals are independent. This is not true in general as the
 * achievement of some subgoals can make the achievement of the other subgoals more or less
 * difficult. For this reason, the additive heuristic is not admissible (i.e., it may overestimate
 * the true costs).
 * </p>
 * <b>Warning:</b> The sum heuristic is admissible.
 *
 * @author D. Pellier
 * @version 1.0 - 11.06.2010
 * @see RelaxedGraphHeuristic
 */
public final class Sum extends RelaxedGraphHeuristic {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new <code>SUM_ID</code> heuristic for a specified planning problem.
     *
     * @param problem the planning problem.
     * @throws NullPointerException if <code>problem == null</code>.
     */
    public Sum(final CodedProblem problem) {
        super(problem);
        super.setAdmissible(false);
    }

    /**
     * Return the distance to the goal state from the specified state. If the return value is
     * <code>Integer.MAX_VALUE</code>, it means that the goal is unreachable from the specified
     * state. More precisely, this method returns the level of the planning graph where all the
     * propositions of the goal are reached without any mutex or <code>Integer.MAX_VALUE</code>
     * otherwise.
     *
     * @param state the state from which the distance to the goal must be estimated.
     * @param goal  the goal expression.
     * @return the distance to the goal state from the specified state or
     * <code>Integer.MAX_VALUE</code> if the goal is unreachable from the specified state.
     * @throws NullPointerException if <code>state == null</code>.
     */
    @Override
    public int estimate(final BitState state, final BitExp goal) {
        super.setGoal(goal);
        this.expandRelaxedPlanningGraph(state);
        return super.isGoalReachable() ? super.getSumValue() : Integer.MAX_VALUE;
    }

    /**
     * Return the estimated distance to the goal to reach the specified state. If the return value is
     * <code>DOUBLE.MAX_VALUE</code>, it means that the goal is unreachable from the specified
     * state.
     *
     * @param node the state from which the distance to the goal must be estimated.
     * @param goal the goal expression.
     * @return the distance to the goal state from the specified state.
     */
    @Override
    public double estimate(final Node node, final BitExp goal) {
        return estimate((BitState) node, goal);
    }

}
