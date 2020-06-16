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

package fr.uga.pddl4j.planners.htn.pfd;

import fr.uga.pddl4j.problem.State;
import fr.uga.pddl4j.problem.TaskNetwork;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class implements a node for the PFDPlanner planner of the PDDL4J library.
 *
 * @author D. Pellier
 * @version 1.0 - 05.05.2020
 * @since 4.0
 */
public class PFDNode implements Serializable {

    /**
     * The state that describes the state of the world reached by the search.
     */
    private State state;

    /**
     * The task network that describes the set of tasks to be accomplished and their constraints that have to be
     * verified.
     */
    private TaskNetwork taskNetwork;

    /**
     * The operator used to reach this node.
     */
    private int operator;

    /**
     * The parent node of this node.
     */
    private PFDNode parent;

    /**
     * Creates a new node from an other. This constructor creates a deep copy of the node in parameters.
     *
     * @param other the node to be copied.
     */
    public PFDNode(final PFDNode other) {
        this(new State(other.getState()), new TaskNetwork(other.getTaskNetwork()), other.getParent(), other.getOperator());
    }

    /**
     * Creates a new empty node with an empty state and an empty task network. The parent node is set to null and the
     * operator to Integer.MAX_VALUE.
     */
    public PFDNode() {
        this(new State(), new TaskNetwork(), null, Integer.MAX_VALUE);
    }

    /**
     * Creates a new node with a specified state and task network.
     *
     * @param state srate of this node.
     * @param taskNetwork the tasknetwork of the node.
     */
    public PFDNode(final State state, final TaskNetwork taskNetwork) {
        this(state, new TaskNetwork(taskNetwork), null, Integer.MAX_VALUE);
    }

    /**
     * Creates a new node with a specified state and task network.
     *
     * @param state srate of this node.
     * @param taskNetwork the task network of the node.
     * @param parent the parent node of the node.
     * @param operator the index of the operator applied to reach the node.
     */
    public PFDNode(final State state, final TaskNetwork taskNetwork, final PFDNode parent, final int operator) {
        super();
        this.setState(state);
        this.setTaskNetwork(taskNetwork);
        this.setParent(parent);
        this.setOperator(operator);
    }

    /**
     * Returns the state of this node. The state describes the state of the world reached by the search.
     *
     * @return the state of this node.
     */
    public final State getState() {
        return this.state;
    }

    /**
     * Sets the state of this node. The state describes the state of the world reached by the search.
     *
     * @param state the state to set.
     */
    public final void setState(final State state) {
        this.state = state;
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
     * Returns the parente node of this node. By convention, a node with a parent node equals to null is considered as
     * the root node.
     *
     * @return the parent node of this node.
     */
    public final PFDNode getParent() {
        return parent;
    }

    /**
     * Sets the parent node of this node.
     *
     * @param parent the parent node to set.
     */
    public final void setParent(final PFDNode parent) {
        this.parent = parent;
    }

    /**
     * Returns the operator applied to reach this node. The operator can be an action or a method. By convention, the
     * operator is represented by its index in the action or method tables of the problem. To dissociate actions and
     * methods, positive indexes are used for actions and negative ones for methods.
     *
     * @return the operator applied to reach this node.
     */
    public final int getOperator() {
        return operator;
    }

    /**
     * Sets the operator applied to reach this node. The operator can be an action or a method. By convention, the
     * operator is represented by its index in the action or method tables of the problem. To dissociate actions and
     * methods, positive indexes are used for actions and negative ones for methods.
     *
     * @param operator the operator applied to reach this node.
     */
    public final void setOperator(int operator) {
        this.operator = operator;
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
