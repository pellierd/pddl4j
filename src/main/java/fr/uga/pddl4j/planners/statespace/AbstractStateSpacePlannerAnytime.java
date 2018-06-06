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

package fr.uga.pddl4j.planners.statespace;

import fr.uga.pddl4j.planners.statespace.search.strategy.Node;

import java.util.Vector;

public abstract class AbstractStateSpacePlannerAnytime extends AbstractStateSpacePlanner {

    /**
     * The list containing all the solutions found during anytime process.
     */
    private Vector<Node> solutionNodes;

    /**
     * Creates a new planner.
     */
    public AbstractStateSpacePlannerAnytime() {
        super();
        this.setAnytimeState(true);
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
