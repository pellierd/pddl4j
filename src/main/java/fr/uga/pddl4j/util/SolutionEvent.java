/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.  If not, see
 * <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.util;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;

import java.util.EventObject;

/**
 * This class implements a solution event. This event is triggered when a search strategy find a new solution.
 *
 * @author E. Hermellin
 * @version 1.0 - 10.01.2019
 * @since 3.7.3
 */
public class SolutionEvent extends EventObject {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The solution node of the event.
     */
    private Node solutionNode;

    /**
     * The coded problem associated to the solution node.
     */
    private CodedProblem codedProblem;

    /**
     * Create a new SolutionEvent.
     *
     * @param source       the object which create the new event.
     * @param solutionNode the solution node.
     * @param codedProblem the coded problem associated.
     */
    public SolutionEvent(Object source, Node solutionNode, CodedProblem codedProblem) {
        super(source);
        this.solutionNode = solutionNode;
        this.codedProblem = codedProblem;
    }

    /**
     * Returns the solution node of the event.
     *
     * @return the solution node of the event.
     */
    public Node getSolutionNode() {
        return this.solutionNode;
    }

    /**
     * Returns the coded problem associated to the solution node of the event.
     *
     * @return the coded problem associated to the solution node of the event.
     */
    public CodedProblem getCodedProblem() {
        return codedProblem;
    }
}
