/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.planners.htn.stn;

import fr.uga.pddl4j.problem.State;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class implements a node for the TFDPlanner of the PDDL4J library. This class is a simplified version of the
 * class <code>PFDNode</code>. The task network is modeled using a simple task list to speed up searching and optimize
 * memory size.
 *
 * @author D. Pellier
 * @version 1.0 - 15.04.2020
 * @since 4.0
 * @see PFDNode
 */
public class TFDNode extends AbstractSTNNode {

    /**
     * The list of tasks to be accomplished.
     */
    private LinkedList<Integer> tasks;

    /**
     * Creates a new TFDNode from an other. This constructor creates a deep copy of the node in parameters.
     *
     * @param other the node to be copied.
     */
    public TFDNode(final TFDNode other) {
        super(new State(other.getState()), other.getParent(), other.getOperator(), other.getTask());
        this.setTasks(new LinkedList<>(other.getTasks()));
    }

    /**
     * Creates a new empty TFDNode. The parent node is set to null, the operator is set
     * to DEFAULT_OPERATOR and the task is set to DEFAULT_TASK.
     */
    public TFDNode() {
        super(new State(), null, DEFAULT_OPERATOR, DEFAULT_TASK);
        this.setTasks(new LinkedList<>());
    }

    /**
     * Creates a new TFDNode with a specified state and task network. The parent node is set to null, the operator is
     * set to DEFAULT_OPERATOR and the task is set to DEFAULT_TASK.
     *
     * @param state the state of the node.
     * @param tasks the task network of the node.
     */
    public TFDNode(final State state, final List<Integer> tasks) {
        super(state, null, DEFAULT_OPERATOR, DEFAULT_TASK);
        this.setTasks(tasks);
    }

    /**
     * Creates a new TFDNode with a specified state and task network.
     *
     * @param state    the state of the node.
     * @param tasks    the task network of the node.
     * @param parent   the parent of the node.
     * @param operator the index of the operator applied to reach this node.
     * @param task     the task processed in this node.
     */
    public TFDNode(final State state, final List<Integer> tasks, final TFDNode parent, final int operator,
                   final int task) {
        super(state, parent, operator, task);
        this.setTasks(tasks);
    }

    /**
     * Returns the list of tasks the node. The list describes the list of tasks remaining to be accomplished.
     *
     * @return the list of tasks of the node.
     */
    public final List<Integer> getTasks() {
        return this.tasks;
    }

    /**
     * Sets the list of tasks of the node. The list describes the tasks to be accomplished.
     *
     * @param tasks the list of tasks of the node.
     */
    public final void setTasks(final List<Integer> tasks) {
        this.tasks = new LinkedList<Integer>(tasks);
    }

    /**
     * Pops the first task of the node and remove it from the node.
     *
     * @return the first task of contained in the node. If the node has no more tasks, the method returns null;
     */
    public final Integer popTask() {
        return this.tasks.pop();
    }

    /**
     * Pushes a list of tasks at beginning of the task list of the node.
     *
     * @param tasks the list of tasks to push.
     * @return true if the collection was pushed, false otherwise.
     */
    public final boolean pushAllTasks(final List<Integer> tasks) {
        return this.tasks.addAll(0, tasks);
    }

    /**
     * Returns <code>true</code> if a node is equals to an other object. An object is equals to this node if and only
     * if the other object is an instance of <code>TFDNode</code> and have the same state and the same task network.
     *
     * @param obj the object to be compared.
     * @return <code>true</code> if a node is equals to an other object, <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof TFDNode) {
            TFDNode other = (TFDNode) obj;
            return this.getState().equals(other.getState()) && this.getTasks().equals(other.getTasks());
        }
        return false;
    }

    /**
     * Returns the hash code value of the node.
     *
     * @return the hash code value of the node.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(getState(), getTasks());
    }

}
