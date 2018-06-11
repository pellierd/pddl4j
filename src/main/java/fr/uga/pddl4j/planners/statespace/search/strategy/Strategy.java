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

package fr.uga.pddl4j.planners.statespace.search.strategy;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.planners.statespace.StateSpacePlanner;
import fr.uga.pddl4j.util.Plan;

import java.io.Serializable;

/**
 * This interface defines the main methods for search strategies.
 *
 * @author E. Hermellin
 * @version 1.0 - 11.06.2018
 * @since 3.6
 */
public interface Strategy extends Serializable {

    /**
     * Returns the planner associated to the search strategy.
     *
     * @return the planner associated to the search strategy
     */
    StateSpacePlanner getStateSpacePlanner();

    /**
     * Sets the planner associated to the search strategy.
     *
     * @param stateSpacePlanner the planner associated to the search strategy.
     */
    void setStateSpacePlanner(StateSpacePlanner stateSpacePlanner);

    /**
     * Returns the coded problem on which the search strategy is applied.
     *
     * @return the coded problem on which the search strategy is applied
     */
    CodedProblem getCodedProblem();

    /**
     * Sets the coded problem on which the search strategy is applied.
     *
     * @param codedProblem the coded problem on which the search strategy is applied.
     */
    void setCodedProblem(CodedProblem codedProblem);

    /**
     * Solves the planning problem and returns the first solution node found.
     *
     * @param planner the planner used to solve the problem
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     */
    Node search(final StateSpacePlanner planner, final CodedProblem problem);

    /**
     * Search a solution node to a specified domain and problem.
     *
     * @return the solution node or null.
     */
    Node searchSolutionNode();

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @return the solution plan or null.
     */
    Plan searchSolutionPlan();

    /**
     * Extract a plan from a solution node for the specified planning problem.
     *
     * @param solutionNode the solution node.
     * @param problem      the problem to be solved. The problem cannot be null.
     * @return the solution plan or null is no solution was found.
     */
    Plan extract(final Node solutionNode, final CodedProblem problem);

}
