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
 * This class implements the heuristics of the fast forward planner. For more about this
 * heuristic see J. Hoffmann, A Heuristic for DOMAIN Independent Planning and its Use in an Enforced
 * Hill-climbing Algorithm, in: Proceedings of the 12th International Symposium on Methodologies for
 * Intelligent Systems, Charlotte, North Carolina, USA, October 2000.
 * <p>
 * The computation of the value returned by the heuristics is based on the extraction of a relaxed
 * plan to the planning graph ignoring negative effects according to the difficulty heuristic. The
 * heuristic value is the number of actions of the relaxed plan extracted. To select an effect
 * according to the unconditional operators difficulty heuristic, the question is, which achiever
 * should be choose when no NOOP is available ? It is certainly a good idea to select an achiever
 * whose preconditions seems to be "easy". From the graph building phase, we can obtain a simple
 * measure for the operators_difficulty of an action's preconditions as follows:
 * </p>
 * <pre>
 * difficulty(o) := SUM_ID(min { i | p is member of the fact layer at time i }) with p in pre(o)
 * </pre>
 * <p>
 * The operators_difficulty of each action can be set when it is first inserted into the graph.
 * During plan extraction, facing a fact for which no NOOP is available, we then simply selected an
 * achieving action with minimal operators_difficulty. This heuristic works well in situation where
 * there are severals ways to achieve one fact. but some ways need less effort than others.
 * </p>
 * <b>Warning:</b> The relaxed plan heuristic is not admissible.
 *
 * @author D. Pellier
 * @version 1.0 - 20.08.2010
 * @see RelaxedGraphHeuristic
 */
public final class FastForward extends RelaxedGraphHeuristic {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new <code>FastForward</code> heuristic for a specified planning problem.
     *
     * @param problem the planning problem.
     * @throws NullPointerException if <code>problem == null</code>.
     */
    public FastForward(CodedProblem problem) {
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
     * @throws NullPointerException if <code>state == null &#38;&#38; goal == null</code>.
     */
    @Override
    public int estimate(final BitState state, final BitExp goal) {
        super.setGoal(goal);
        super.expandRelaxedPlanningGraph(state);
        return super.isGoalReachable() ? super.getRelaxedPlanValue() : Integer.MAX_VALUE;
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
