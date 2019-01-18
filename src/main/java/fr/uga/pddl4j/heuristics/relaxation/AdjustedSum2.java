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
 * This class implement the adjusted sum 2 heuristic. This heuristic improves the adjusted sum
 * heuristic by replacing the computation of the <code>cost(S)</code> by the used the relaxed plan
 * heuristic. Now, we have the following heuristic:
 * <pre>
 * hadjsum2(S) := cost(S) + delta(S)
 * </pre>
 * where
 * <ul>
 * <li> <code>cost(S) := 1 +  cost(S + prec(a) - add(a))</code>
 * <li> <code>delta(S) := lev(S) - max(lev(p))</code> for all <code>p</code> in <code>S</code>
 * </ul>
 * <b>Warning:</b> The adjusted sum heuristic is not admissible.
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 * @see AdjustedSum
 * @see Max
 * @see FastForward
 * @see Sum
 */
public final class AdjustedSum2 extends RelaxedGraphHeuristic {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new <code>AdjustedSum2</code> heuristic for a specified planning problem.
     *
     * @param problem the planning problem.
     * @throws NullPointerException if <code>problem == null</code>.
     */
    public AdjustedSum2(CodedProblem problem) {
        super(problem);
        super.setAdmissible(false);
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
    @Override
    public int estimate(final BitState state, final BitExp goal) {
        super.setGoal(goal);
        final int level = super.expandRelaxedPlanningGraph(state);
        return super.isGoalReachable() ? super.getRelaxedPlanValue() + (level - super.getMaxValue())
            : Integer.MAX_VALUE;
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
