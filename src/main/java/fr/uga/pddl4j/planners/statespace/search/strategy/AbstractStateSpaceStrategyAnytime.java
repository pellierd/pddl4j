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

package fr.uga.pddl4j.planners.statespace.search.strategy;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.util.Plan;

import java.util.Vector;

public abstract class AbstractStateSpaceStrategyAnytime extends AbstractStateSpaceStrategy
    implements StateSpaceStrategyAnytime {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new planner.
     */
    public AbstractStateSpaceStrategyAnytime() {
        super();
    }

    /**
     * Creates a new planner.
     *
     * @param heuristic the heuristicType to use to solve the planning problem.
     * @param timeout   the time out of the planner.
     * @param weight    the weight set to the heuristic.
     */
    public AbstractStateSpaceStrategyAnytime(int timeout, Heuristic.Type heuristic, double weight) {
        super(timeout, heuristic, weight);
    }

    /**
     * Cleans the list containing all the solutions found during anytime process.
     */
    @Override
    public void clearResults() {
        this.solutionNodes.clear();
    }

    /**
     * Returns the list containing all solution nodes found.
     *
     * @return the list containing all solution nodes found.
     */
    @Override
    public Vector<Node> getSolutionNodes() {
        return solutionNodes;
    }

    /**
     * Returns the list of solution plans.
     *
     * @param codedProblem the coded problem.
     * @return a vector containing all the solutions plans or an empty vector.
     */
    @Override
    public Vector<Plan> getSolutionPlans(final CodedProblem codedProblem) {
        final Vector<Plan> plansVector = new Vector<>();
        if (!this.solutionNodes.isEmpty()) {
            for (Node node : this.solutionNodes) {
                plansVector.add(this.extractPlan(node, codedProblem));
            }
        }
        return plansVector;
    }
}
