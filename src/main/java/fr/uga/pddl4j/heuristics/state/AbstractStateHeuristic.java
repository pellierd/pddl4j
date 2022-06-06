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

package fr.uga.pddl4j.heuristics.state;

import fr.uga.pddl4j.heuristics.AbstractHeuristic;
import fr.uga.pddl4j.problem.Fluent;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Condition;

import java.util.List;

/**
 * This abstract class implements the basic methods of goal cost heuristics.
 *
 * @author D. Pellier
 * @version 1.0 - 19.10.2020
 */
public abstract class AbstractStateHeuristic extends AbstractHeuristic implements StateHeuristic {

    /**
     * The goal to reached.
     */
    private Condition goal;

    /**
     * The list of facts of the relaxed problem.
     */
    private List<Fluent> facts;

    /**
     * The lists of actions of the relaxed problem.
     */
    private List<Action> actions;

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
    protected AbstractStateHeuristic(final Problem problem) {
        this.facts = problem.getFluents();
        this.goal = problem.getGoal();
        this.actions = problem.getActions();
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
     * Returns the goal of the problem to solve in order to compute the heuristic.
     *
     * @return the goal.
     */
    protected final Condition getGoal() {
        return this.goal;
    }

    /**
     * Set the goal of the relaxed problem to solve in order to compute the heuristic.
     *
     * @param goal the goal.
     */
    protected void setGoal(final Condition goal) {
        if (!goal.equals(this.goal)) {
            this.goal = goal;
        }
    }

    /**
     * Returns the relevant facts of the relaxed problem to solve in order to compute the heuristic.
     *
     * @return the relevant facts.
     */
    protected final List<Fluent> getRevelantFacts() {
        return this.facts;
    }

    /**
     * Returns the actions of the relaxed problem to solve in order to compute the heuristic.
     *
     * @return the actions.
     */
    protected final List<Action> getActions() {
        return this.actions;
    }

}
