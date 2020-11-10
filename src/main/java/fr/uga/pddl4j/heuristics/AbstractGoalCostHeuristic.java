/*
* Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.heuristics;

import fr.uga.pddl4j.encoding.IProblem;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.Fluent;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.State;

import java.util.List;

/**
 * This abstract class implements the basic methods of goal cost heuristics.
 *
 * @author D. Pellier
 * @version 1.0 - 19.10.2020
 */
public abstract class AbstractGoalCostHeuristic implements GoalCostHeuristic {

    /**
     * The problem adressed by the heuristic.
     */
    private IProblem problem;

    /**
     * The boolean flag used to indicate if the heuristic is admissible.
     */
    private boolean isAdmissible;

    /**
     * Create a new goal cost heuristic for a specified planning problem. By default the heuristic is
     * considered as admissible.
     *
     * @param problem the problem to solve.
     */
    protected AbstractGoalCostHeuristic(final IProblem problem) {
       this.problem = problem;
        this.isAdmissible = true;
    }

    /**
     * Returns <code>true</code> if this heuristic is admissible.
     *
     * @return <code>true</code> if this heuristic is admissible.
     */
    @Override
    public boolean isAdmissible() {
        return this.isAdmissible;
    }

    /**
     * Marks the cost cost heuristic as admissible or not.
     *
     * @param isAdmissible the admissible flag.
     */
    protected final void setAdmissible(boolean isAdmissible) {
        this.isAdmissible = isAdmissible;
    }

    /**
     * Returns the problem addressed by the heuristic.
     *
     * @return the problem addressed by the heuristic.
     */
    public final IProblem getProblem() {
        return this.problem;
    }

}
