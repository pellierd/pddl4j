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
 * This class implement the adjusted sum 2M heuristic. This heuristic improves the adjusted sum 2
 * heuristic by replacing the computation of the interaction degree of the of the adjusted sum 2
 * heuristic. Now, we have the following heuristic:
 * <pre>
 * hadjsum2M(S) := cost(S) + delta(S)
 * </pre>
 * where
 * <ul>
 * <li> <tt>cost(S) := 1 +  cost(S + prec(a) - add(a))</tt></li>
 * <li> <tt>delta(S) := max(lev({p, q} - max{levl(p), level(q)})</tt>for all <tt>p</tt> in
 * <tt>S</tt></li>
 * </ul>
 * <p>
 * Note that computing <tt>delta(S)</tt> is equivalent to compute the set level heuristic.
 * </p>
 * <b>Warning:</b> The adjusted sum 2M heuristic is not admissible.
 *
 * @author D. Pellier
 * @version 1.0 - 01.09.2010
 * @see AdjustedSum
 * @see Max
 * @see FastForward
 * @see Sum
 */
public final class AjustedSum2M extends RelaxedGraphHeuristic {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The set level heuristic used to compute the delta function, i.e., the interaction degree
     * among propositions of the goal.
     */
    private SetLevel delta;

    /**
     * Creates a new <code>AJUSTED_SUM2M</code> heuristic for a specified planning problem.
     *
     * @param problem the planning problem.
     * @throws NullPointerException if <code>problem == null</code>.
     */
    public AjustedSum2M(CodedProblem problem) {
        super(problem);
        super.setAdmissible(false);
        this.delta = new SetLevel(problem);
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
        // First, we expand the relaxed planing graph to compute the relaxed plan value heuristic
        super.expandRelaxedPlanningGraph(state);
        // Second, we expand the relaxed planning graph with mutex to compute the set level heuristic
        this.delta.expandPlanningGraph(state);
        // If the goal was not reached, it means that the goal is unreachable
        return super.isGoalReachable() ? super.getRelaxedPlanValue()
            + (this.delta.estimate(state, goal) - super.getMaxValue()) : Integer.MAX_VALUE;
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
