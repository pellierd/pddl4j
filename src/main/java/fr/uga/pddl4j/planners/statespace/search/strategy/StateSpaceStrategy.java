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
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.util.Plan;
import fr.uga.pddl4j.util.SolutionEvent;
import fr.uga.pddl4j.util.SolutionListener;

import java.io.Serializable;
import javax.swing.event.EventListenerList;

/**
 * This interface defines the main methods for search strategies.
 *
 * @author E. Hermellin
 * @version 1.0 - 11.06.2018
 * @since 3.6
 */
public interface StateSpaceStrategy extends Serializable {

    /**
     * The list of SolutionListener.
     */
    EventListenerList solutionListenerList = new EventListenerList();

    /**
     * Returns the heuristicType to use to solve the planning problem.
     *
     * @return the heuristicType to use to solve the planning problem.
     */
    Heuristic.Type getHeuristicType();

    /**
     * Sets the heuristicType to use to solved the problem.
     *
     * @param heuristicType the heuristicType to use to solved the problem. The heuristicType cannot be null.
     */
    void setHeuristicType(final Heuristic.Type heuristicType);

    /**
     * Returns the weight set to the heuristic.
     *
     * @return the weight set to the heuristic.
     */
    double getWeight();

    /**
     * Sets the wight of the heuristic.
     *
     * @param weight the weight of the heuristic. The weight must be positive.
     */
    void setWeight(final double weight);

    /**
     * Sets the time out of the planner.
     *
     * @param timeout the time allocated to the search in second.
     */
    void setTimeOut(final int timeout);

    /**
     * Returns the time out of the planner.
     *
     * @return the time out of the planner, i.e., the time allocated to the search in second.
     */
    int getTimeout();

    /**
     * Returns the time spend to find a solution.
     *
     * @return the time spend to find a solution.
     */
    long getSearchingTime();

    /**
     * Sets the time spend to find a solution.
     *
     * @param searchingTime the time spend to find a solution.
     */
    void setSearchingTime(final long searchingTime);

    /**
     * Returns the amount of memory used for the search.
     *
     * @return the amount of memory used for the search.
     */
    long getMemoryUsed();

    /**
     * Sets the amount of memory used for the search.
     *
     * @param memoryUsed the amount of memory used for the search.
     */
    void setMemoryUsed(final long memoryUsed);

    /**
     * Returns the number of explored nodes.
     *
     * @return the number of explored nodes.
     */
    int getExploredNodes();

    /**
     * Sets the number of explored nodes.
     *
     * @param exploredNodes the number of explored nodes.
     */
    void setExploredNodes(final int exploredNodes);

    /**
     * Returns the number of pending nodes.
     *
     * @return the number of pending nodes.
     */
    int getPendingNodes();

    /**
     * Sets the number of pending nodes.
     *
     * @param pendingNodes the number of pending nodes.
     */
    void setPendingNodes(final int pendingNodes);

    /**
     * Returns the number of created nodes.
     *
     * @return the number of created nodes.
     */
    int getCreatedNodes();

    /**
     * Sets the number of created nodes.
     *
     * @param createdNodes the number of created nodes.
     */
    void setCreatedNodes(final int createdNodes);

    /**
     * Solves the planning problem and returns the first solution node found.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return a solution search or null if it does not exist.
     */
    Node search(final CodedProblem codedProblem);

    /**
     * Search a solution node to a specified domain and problem.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return the solution node or null.
     */
    Node searchSolutionNode(final CodedProblem codedProblem);

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param codedProblem the problem to be solved. The problem cannot be null.
     * @return the solution plan or null.
     */
    Plan searchPlan(final CodedProblem codedProblem);

    /**
     * Extract a plan from a solution node for the specified planning problem.
     *
     * @param solutionNode the solution node.
     * @param codedProblem the problem to be solved.
     * @return the solution plan or null is no solution was found.
     */
    Plan extractPlan(final Node solutionNode, final CodedProblem codedProblem);

    /**
     * Adds SolutionListener to the list of SolutionListener.
     *
     * @param listener the SolutionListener to add.
     */
    void addSolutionListener(SolutionListener listener);

    /**
     * Removes SolutionListener to the list of SolutionListener.
     *
     * @param listener the SolutionListener to remove.
     */
    void removeSolutionListener(SolutionListener listener);

    /**
     * Processes SolutionEvent when one is fired.
     *
     * @param evt the solution event to process.
     */
    void fireSolution(SolutionEvent evt);
}
