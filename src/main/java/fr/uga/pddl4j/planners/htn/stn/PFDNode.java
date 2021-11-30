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
import fr.uga.pddl4j.problem.operator.TaskNetwork;

import java.util.Objects;

/**
 * This class implements a node for the PFDPlanner planner of the PDDL4J library.
 *
 * @author D. Pellier
 * @version 1.0 - 05.05.2020
 * @since 4.0
 */
public final class PFDNode extends AbstractSTNNode {

    /**
     * The task network that describes the set of tasks to be accomplished and their constraints that have to be
     * verified.
     */
    private TaskNetwork taskNetwork;

    /**
     * Creates a new node from an other. This constructor creates a deep copy of the node in parameters.
     *
     * @param other the node to be copied.
     */
    public PFDNode(final PFDNode other) {
        super(other);
        this.setTaskNetwork(new TaskNetwork(other.getTaskNetwork()));
    }

    /**
     * Creates a new empty node with an empty state and an empty task network. The parent node is set to null, the
     * operator is set to DEFAULT_OPERATOR and the task is set to DEFAULT_TASK.
     */
    public PFDNode() {
        super();
        this.setTaskNetwork(new TaskNetwork());
    }

    /**
     * Creates a new node with a specified state and task network. The parent node is set to null, the operator is set
     * to DEFAULT_OPERATOR and the task is set to DEFAULT_TASK.
     *
     * @param state       state of this node.
     * @param taskNetwork the task network of the node.
     */
    public PFDNode(final State state, final TaskNetwork taskNetwork) {
        super(state, null, DEFAULT_OPERATOR, DEFAULT_TASK);
        this.setTaskNetwork(taskNetwork);
    }

    /**
     * Creates a new node with a specified state and task network.
     *
     * @param state       srate of this node.
     * @param taskNetwork the task network of the node.
     * @param parent      the parent node of the node.
     * @param operator    the index of the operator applied to reach the node.
     * @param task        the task processed in this node.
     */
    public PFDNode(final State state, final TaskNetwork taskNetwork, final PFDNode parent,
                   final int operator, final int task) {
        super(state, parent, operator, task);
        this.setTaskNetwork(taskNetwork);
    }

    /**
     * Returns the task network of the node. The task network describes the set of tasks to be accomplished
     * and their constraints that have to be verified.
     *
     * @return the task network of the node.
     */
    public final TaskNetwork getTaskNetwork() {
        return this.taskNetwork;
    }

    /**
     * Sets the tasks network of the node. The task network describes the set of tasks to be accomplished
     * and their constraints that have to be verified.
     *
     * @param taskNetwork the task network of the node.
     */
    public final void setTaskNetwork(final TaskNetwork taskNetwork) {
        this.taskNetwork = taskNetwork;
    }

    /**
     * Returns <code>true</code> if a node is equals to an other object. An object is equals to this node if and only
     * if the other object is an instance of <code>PFDNode</code> and have the same task network.
     *
     * @param obj the object to be compared.
     * @return <code>true</code> if a node is equals to an other object, <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof PFDNode) {
            PFDNode other = (PFDNode) obj;
            return this.getState().equals(other.getState()) && this.getTaskNetwork().equals(other.getTaskNetwork());
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
        return Objects.hash(this.getState(), this.getTaskNetwork());
    }
}
