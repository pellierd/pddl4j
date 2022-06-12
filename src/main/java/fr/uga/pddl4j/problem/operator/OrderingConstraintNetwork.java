/*
 * Copyright (c) 2022 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.problem.operator;

import fr.uga.pddl4j.util.BitVector;

import java.io.Serializable;
import java.util.List;

/**
 * This class implements an orderings constraints network. This class interface is used to deal with ordering
 * constraints in method.
 *
 * @author D. Pellier
 * @version 1.0 - 09.06.2022
 */
public interface OrderingConstraintNetwork extends Serializable {

    /**
     * Returns <code>true</code> if the orderings constraints is totally ordered.
     *
     * @return <code>true</code> if the ordering constraints is totally ordered; <code>false</code> otherwise.
     */
    boolean isTotallyOrdered();

    /**
     * Returns the list of tasks with no successors. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no successors.
     */
    List<Integer> getTasksWithNoSuccessors();

    /**
     * Returns the list of tasks with no predecessors.  The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no predecessors.
     */
    List<Integer> getTasksWithNoPredecessors();

    /**
     * Returns if this ordering constraints is consistent.
     *
     * @return <code>true</code> if the ordering constraints network is consistent, <code>false</code>
     *      otherwise.
     */
    boolean isConsistent();

    /**
     * Compute the transitive closure of the ordering constraints network.
     */
    void transitiveClosure();

    /**
     * Remove a task of the ordering constraints network.
     *
     * @param task the task to removed.
     */
    void removeTask(final int task);

    /**
     * Returns the size of the ordering constraints network, i.e., its number of tasks.
     *
     * @return the size of the ordering constraints network, i.e., its number of tasks.
     */
    int size();

    /**
     * Resize the ordering constraints network.
     *
     * @param newSize the new size.
     */
    void resize(int newSize);

}
