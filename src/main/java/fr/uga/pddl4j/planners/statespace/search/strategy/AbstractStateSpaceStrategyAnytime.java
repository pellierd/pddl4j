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

import fr.uga.pddl4j.heuristics.relaxation.Heuristic;

import java.util.Vector;

public abstract class AbstractStateSpaceStrategyAnytime extends AbstractStateSpaceStrategy {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The list containing all the solutions found during anytime process.
     */
    private Vector<Node> solutionNodes;

    /**
     * Creates a new planner.
     */
    public AbstractStateSpaceStrategyAnytime() {
        super();
        solutionNodes = new Vector<>();
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
        solutionNodes = new Vector<>();
    }

    /**
     * Returns the list containing all solution nodes found.
     *
     * @return the list containing all solution nodes found.
     */
    public Vector<Node> getSolutionNodes() {
        return solutionNodes;
    }
}
