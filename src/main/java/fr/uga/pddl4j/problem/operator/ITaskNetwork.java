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

import java.io.Serializable;
import java.util.List;

/**
 * This interface defined the common methods to manipulate a tasknetwork.
 *
 * @author D. Pellier
 * @version 1.0 - 12.06.2022
 * @since 4.0
 */
public interface ITaskNetwork extends Serializable {

    /**
     * Returns the condition that must hold before a specific task of the task network.
     *
     * @param task the task.
     * @return the condition that must hold before a task or null if the task is not a task of the task network.
     */
    Condition getBeforeConstraints(int task);

    /**
     * Returns the condition that must hold after a specific task of the task network.
     *
     * @param task the task.
     * @return the condition that must hold after a task or null if the task is not a task of the task network.
     */
    Condition getAfterConstraints(int task);

    /**
     * Returns the condition that must hold between two specific tasks of the task network.
     *
     * @param task1 the first task.
     * @param task2 the second task.
     * @return the condition that must hold between two tasks or null if t1 or t2 task is not a task of the task network.
     */
    Condition getBetweenConstraints(int task1, int task2);

    /**
     * Returns the size of the task network, i.e., its number of tasks.
     *
     * @return the size of the task network.
     */
    int size();

    /**
     * Returns the tasks of the task network.
     *
     * @return the tasks of the task network.
     */
    List<Integer> getTasks();

    /**
     * Sets the tasks of the task network.
     *
     * @param tasks the tasks to set.
     */
    void setTasks(final List<Integer> tasks);

    /**
     * Returns if the task network is empty, i.e., contains not tasks.
     *
     * @return <code>true</code> if the task network is empty, <code>false</code> otherwise.
     */
    boolean isEmpty();

    /**
     * Remove a task for the task network.
     *
     * @param task the index of the task to remove.
     */
    void removeTask(final int task);

    /**
     * Returns <code>true</code> if the task network is totally ordered.
     *
     * @return <code>true</code> if the  task network  is totally ordered; <code>false</code> otherwise.
     */
    boolean isTotallyOrdered();

    /**
     * Returns if this task network has a consistent ordering constraints network.
     *
     * @return <code>true</code> if this task network has a consistent ordering constraints networks, <code>false</code>
     *      otherwise.
     */
     boolean isConsistent();

    /**
     * Returns the list of tasks with no successors. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     *
     * @return the  list of tasks with no successors.
     */
    List<Integer> getTasksWithNosSuccessors();

    /**
     * Returns the list of tasks with no predecessors.  The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no predecessors.
     */
    List<Integer> getTasksWithNoPredecessors();

}
