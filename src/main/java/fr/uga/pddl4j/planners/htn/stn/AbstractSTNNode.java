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

import java.io.Serializable;

/**
 * This class implements a node for the simple task network planners of the PDDL4J library.
 *
 * @author D. Pellier
 * @version 1.0 - 25.06.2020
 * @since 4.0
 */
public abstract class AbstractSTNNode implements Serializable {

    /**
     * The default operator value.
     */
    public static int DEFAULT_OPERATOR = -1;

    /**
     * The default task value.
     */
    public static int DEFAULT_TASK = -1;

    /**
     * The state that describes the state of the world reached by the search.
     */
    private State state;

    /**
     * The operator used to reach this node.
     */
    private int operator;

    /**
     * The task processed in the node.
     */
    private int task;

    /**
     * The parent node of this node.
     */
    private AbstractSTNNode parent;

    /**
     * Creates a new node from an other. This constructor creates a deep copy of the node in parameters.
     *
     * @param other the node to be copied.
     */
    public AbstractSTNNode(final AbstractSTNNode other) {
        this(new State(other.getState()),
            other.getParent(),
            other.getOperator(),
            other.getTask());
    }

    /**
     * Creates a new empty node with an empty state. The parent node is set to null, the
     * operator to DEFAULT_OPERATOR and the task is set to DEFAULT_TASK.
     */
    public AbstractSTNNode() {
        this(new State(), null, AbstractSTNNode.DEFAULT_OPERATOR, AbstractSTNNode.DEFAULT_TASK);
    }

    /**
     * Creates a new node with a specified state and task network.
     *
     * @param state    state of this node.
     * @param parent   the parent node of the node.
     * @param operator the index of the operator applied to reach the node.
     * @param task     the task processed in this node.
     */
    public AbstractSTNNode(final State state, final AbstractSTNNode parent, final int operator,
                           final int task) {
        super();
        this.setState(state);
        this.setParent(parent);
        this.setOperator(operator);
        this.setTask(task);
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
     * Returns the parente node of this node. By convention, a node with a parent node equals to null is considered as
     * the root node.
     *
     * @return the parent node of this node.
     */
    public final AbstractSTNNode getParent() {
        return parent;
    }

    /**
     * Sets the parent node of this node.
     *
     * @param parent the parent node to set.
     */
    public final void setParent(final AbstractSTNNode parent) {
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
     * Returns the task process in this node.
     *
     * @return the task process in this node.
     */
    public int getTask() {
        return this.task;
    }

    /**
     * Sets the task process in this node.
     *
     * @param task the task process in this node.
     */
    public void setTask(final int task) {
        this.task = task;
    }
}
