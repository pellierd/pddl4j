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
import fr.uga.pddl4j.util.BitExp;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.IntExp;

import java.util.List;

/**
 * This abstract class implements the basic methods of all heuristics.
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
public abstract class AbstractHeuristic implements Heuristic {

    /**
     * The goal to reached.
     */
    private BitExp goal;

    /**
     * The list of facts of the relaxed problem.
     */
    private List<IntExp> facts;

    /**
     * The lists of operators of the relaxed problem.
     */
    private List<BitOp> operators;

    /**
     * The boolean flag used to indicate if the heuristic is admissible.
     */
    private boolean isAdmissible;

    /**
     * Create a new heuristic for a specified planning problem. By default the heuristic is
     * considered as admissible.
     *
     * @param problem the problem to solve.
     */
    protected AbstractHeuristic(final CodedProblem problem) {
        if (problem == null) {
            throw new NullPointerException("problem == null");
        }
        this.facts = problem.getRelevantFacts();
        this.goal = problem.getGoal();
        this.operators = problem.getOperators();
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
     * Marks the heuristic as admissible or not.
     *
     * @param isAdmissible the admissible flag.
     */
    protected final void setAdmissible(boolean isAdmissible) {
        this.isAdmissible = isAdmissible;
    }

    /**
     * Returns the goal of the relaxed problem to solve in order to compute the heuristic.
     *
     * @return the goal.
     */
    protected final BitExp getGoal() {
        return this.goal;
    }

    /**
     * Set the goal of the the relaxed problem to solve in order to compute the heuristic.
     *
     * @param goal the goal.
     */
    protected void setGoal(final BitExp goal) {
        if (!goal.equals(this.goal)) {
            this.goal = goal;
        }
    }

    /**
     * Returns the relevant facts of the relaxed problem to solve in order to compute the heuristic.
     *
     * @return the relevant facts.
     */
    protected final List<IntExp> getRevelantFacts() {
        return this.facts;
    }

    /**
     * Returns the operators of the relaxed problem to solve in order to compute the heuristic.
     *
     * @return the operators.
     */
    protected final List<BitOp> getOperators() {
        return this.operators;
    }

}
