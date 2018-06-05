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
 * This class implement the adjusted sum heuristic. This heuristic improves the sum heuristic by
 * accounting for both negative and positive interactions among propositions. Since fully accounting
 * for either type of interaction alone can be as hard as the planning problem itself, we circumvent
 * this difficulty by using a phased approach. Specifically, we ignore one type of subgoal
 * interaction in order to account for the other, and then combine them both together.
 * <p>
 * Let <code>cost(p)</code> denote the cost of achieving a proposition according to the sum
 * heuristic. Note that it is simple to embed the sum heuristic value into the planning graph. We
 * maintain a cost value for each new proposition. We are now interested in estimating the cost
 * <code>cost(S)</code> for achieving a set <code>S = {p1, p2, ..., pn}</code>. Suppose
 * <code>lev(p1) &#60;= lev(p2) &#60;= ... &#60;= lev(pn)</code> where <code>lev(p)</code> is the level
 * where the proposition <code>p</code> appears for the first time the planning graph. Under the
 * assumption that all propositions are independent, we have
 * </p>
 * <pre>
 * code(S) := cost(S - p1) + cost(p1)
 * </pre>
 * <p>
 * Since <code>lev(p1) &#60;= lev(S - p1)</code>, proposition is possibly achieved before the set
 * <code>S - p1</code>. Now, we assume that there are no positive interactions among the
 * propositions, but there may be negative interactions. Therefore, upon achieving
 * <code>S - p1</code> subgoal <code>p1</code> may have been deleted and needs to be achieved
 * again. This information can be extracted from the planning graph as follows. According to the
 * planning graph, set <code>S - p1</code> and <code>S</code> are possibly achieved at level
 * <code>lev(S - p1)</code> and level <code>lev(S)</code>, respectively. If
 * <code>lev(S - p1) \= lev(S)</code> that means there may be some interaction between achieving
 * <code>S - p1 </code> and achieving <code>p1</code> (because the planning graph has to expand
 * up to <code>lev(S)</code> to achieve both <code>S - p1</code> and <code>p1</code>). To
 * take this negative interaction into account, we assign:
 * </p>
 * <pre>
 * cost(S) := cost(S - p1) + cost(p1) + (lev(S) - lev(S - p1))
 * </pre>
 * Applying this formula to <code>S - p1, S - p1 - p2</code> and so one, we derive:
 * <pre>
 * cost(S) := sum(cost(pi) + lev(S) - lev(pn) for all pi in S.
 * </pre>
 * Note that <code>lev(pn) = max(lev(pi))</code> for all <code>pi</code> in <code>S</code> as
 * per our setup. Thus the estimate above is composed of the sum heuristic function
 * <code>hsum = sum(cost(pi))</code> for all <code>pi</code> in <code>S</code> and an
 * additional cost <code>lev(S) := max(level(pi))</code> for all <code>pi</code> in
 * <code>S</code>. This difference is call the interaction degree among proposition in set
 * <code>S</code>.
 * <p>
 * <i>Definition (Interaction degree).</i> The interaction degree among propositions in a set
 * </p>
 * <code>S</code> is
 * <pre>
 * delta(S) := lev(S) - max(lev(p)) for all p in S.
 * </pre>
 * <p>
 * It should be noted that the notion of binary interaction degree is only a special case of the
 * above definition for a set of two propositions. In addition, when there is no negative
 * interaction among subgoals, <code>delta(S) = 0</code>, as expected. We have the following
 * heuristic:
 * </p>
 * <pre>
 * hadjsum(S) := sum(cost(pi)) + delta(S) or all pi in S.
 * </pre>
 * <b>Warning:</b> The adjusted sum heuristic is not admissible.
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 * @see Sum
 * @see Max
 */
public final class AdjustedSum extends RelaxedGraphHeuristic {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new <code>AdjustedSum</code> heuristic for a specified planning problem.
     *
     * @param problem the planning problem.
     * @throws NullPointerException if <code>problem == null</code>.
     */
    public AdjustedSum(CodedProblem problem) {
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
        return super.isGoalReachable() ? super.getSumValue() + (level - super.getMaxValue()) : Integer.MAX_VALUE;
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
