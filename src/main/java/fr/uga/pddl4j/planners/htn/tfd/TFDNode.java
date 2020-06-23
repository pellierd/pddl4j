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

package fr.uga.pddl4j.planners.htn.tfd;

import fr.uga.pddl4j.problem.State;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class implements a node for the TFDPlanner planner of the PDDL4J library.
 *
 * @author D. Pellier
 * @version 1.0 - 15.04.2020
 * @since 4.0
 */
public class TFDNode implements Serializable, Comparable<TFDNode> {

    /**
     * The state that describes the state of the world reached by the search.
     */
    private State state;

    /**
     * The list of tasks to be accomplished.
     */
    private LinkedList<Integer> tasks;

    /**
     * The operator used to reach this node.
     */
    private int operator;

    /**
     * The parent node of this node.
     */
    private TFDNode parent;

    /**
     * Creates a new TFDNode from an other. This constructor creates a deep copy of the node in parameters.
     *
     * @param other the node to be copied.
     */
    public TFDNode(final TFDNode other) {
        this(new State(other.getState()), other.getTasks(), other.getParent(), other.getOperator());
    }

    /**
     * Creates a new exmpty TFDNode. The parent node is set to null and the operator to Interger.MAX_VALUE.
     */
    public TFDNode() {
        this(new State(), new LinkedList<Integer>(), null, Integer.MAX_VALUE);
    }

    /**
     * Creates a new TFDNode with a specified state and task network. The parent node is set to null and the operator to
     * Interger.MAX_VALUE.
     *
     * @param state the state of the node.
     * @param tasks the task network of the node.
     */
    public TFDNode(final State state, final List<Integer> tasks) {
        super();
        this.setState(state);
        this.setTasks(tasks);
        this.setParent(null);
        this.setOperator(Integer.MAX_VALUE);
    }

    /**
     * Creates a new TFDNode with a specified state and task network.
     *
     * @param state the state of the node.
     * @param tasks the task network of the node.
     * @param parent the parent of the node.
     * @param operator the index of the operator applied to reach this node.
     */
    public TFDNode(final State state, final List<Integer> tasks, final TFDNode parent, final int operator) {
        super();
        this.setState(state);
        this.setTasks(tasks);
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
     * Returns the parente node of this node. By convention, a node with a parent node equals to null is considered as
     * the root node.
     *
     * @return the parent node of this node.
     */
    public final TFDNode getParent() {
        return parent;
    }

    /**
     * Sets the parent node of this node.
     *
     * @param parent the parent node to set.
     */
    public final void setParent(TFDNode parent) {
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
     * Compares this node with the specified node for order. Returns a negative integer, zero, or a positive integer as
     * this node is less than, equal to, or greater than the specified node. The comparaison is done using the number of
     * tasks of of the node.
     *
     * @param other the node to be compared.
     * @return a negative integer, zero, or a positive integer as this node is less than, equal to, or greater than the
     *      specified node.
     */
    @Override
    public int compareTo(TFDNode other) {
        return this.getTasks().size() - other.getTasks().size();
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
