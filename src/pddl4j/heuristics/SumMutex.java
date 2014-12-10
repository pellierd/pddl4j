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

package pddl4j.heuristics;

import pddl4j.preprocessing.CodedProblem;
import pddl4j.util.BitExp;
import pddl4j.util.BitState;

/**
 * This class implements the SUM_ID mutex heuristic is an adaptation of the sum heuristic where mutual
 * exclusion are computed. For more details on the sum heuristic see Blai Bonet and Hector Geffner,
 * Planning as Heuristic Search, Artificial Intelligence 129, 2001, Elsevier.
 * <p>
 * <b>Warning:</b> The sum heuristic is not admissible.
 * 
 * @author D. Pellier
 * @version 1.0 - 11.06.2010
 * @see pddl4j.heuristics.GraphHeuristic
 * @see pddl4j.heuristics.Sum
 */
public final class SumMutex extends GraphHeuristic {

	/**
	 * Creates a new <code>SUM_MUTEX</code> heuristic for a specified planning problem.
	 * 
	 * @param problem the planning problem.
	 * @throws NullPointerException if <code>problem == null</code>.
	 */
	public SumMutex(CodedProblem problem) {
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
	 * @param goal the goal expression.
	 * @return the distance to the goal state from the specified state or
	 *         <code>Integer.MAX_VALUE</code> if the goal is unreachable from the specified state.
	 * @throws NullPointerException if <code>state == null</code>.
	 */
	public int estimate(final BitState state, final BitExp goal) throws NullPointerException {
		super.setGoal(goal);
		super.expandPlanningGraph(state);
		return super.isGoalReachable() ? this.getSumValue() : Integer.MAX_VALUE;
	}
}
