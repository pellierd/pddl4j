/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.planners.statespace.search.strategy;

import fr.uga.pddl4j.util.BitState;

/**
 * This class implements a node of the tree search.
 *
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 */
public final class Node extends BitState {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The parent node of this node.
     */
    private Node parent;

    /**
     * The operator apply to reach this node.
     */
    private int operator;

    /**
     * The cost to reach this node from the root node.
     */
    private double cost;

    /**
     * The estimated distance to the goal from this node.
     */
    private double heuristic;

    /**
     * The depth of the node.
     */
    private int depth;

    /**
     * Creates a new node from a specified state.
     *
     * @param state the state.
     */
    public Node(BitState state) {
        super(state);
    }

    /**
     * Creates a new node with a specified state, parent node, operator, cost and heuristic value.
     *
     * @param state     the logical state of the node.
     * @param parent    the parent node of the node.
     * @param operator  the operator applied to reached the node from its parent.
     * @param cost      the cost to reach the node from the root node.
     * @param heuristic the estimated distance to reach the goal from the node.
     */
    public Node(BitState state, Node parent, int operator, double cost, double heuristic) {
        super(state);
        this.parent = parent;
        this.operator = operator;
        this.cost = cost;
        this.heuristic = heuristic;
        this.depth = -1;
    }

    /**
     * Creates a new node with a specified state, parent node, operator, cost, depth and heuristic value.
     *
     * @param state     the logical state of the node.
     * @param parent    the parent node of the node.
     * @param operator  the operator applied to reached the node from its parent.
     * @param cost      the cost to reach the node from the root node.
     * @param depth     the depth of the node.
     * @param heuristic the estimated distance to reach the goal from the node.
     */
    public Node(BitState state, Node parent, int operator, double cost, int depth, double heuristic) {
        super(state);
        this.parent = parent;
        this.operator = operator;
        this.cost = cost;
        this.depth = depth;
        this.heuristic = heuristic;
    }

    /**
     * Returns the operator applied to reach the node.
     *
     * @return the operator applied to reach the node.
     */
    public final int getOperator() {
        return operator;
    }

    /**
     * Sets the operator applied to reach the node.
     *
     * @param operator the operator to set.
     */
    public final void setOperator(int operator) {
        this.operator = operator;
    }


    /**
     * Returns the parent node of the node.
     *
     * @return the parent node.
     */
    public final Node getParent() {
        return parent;
    }


    /**
     * Sets the parent node of the node.
     *
     * @param parent the parent to set.
     */
    public final void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Returns the cost to reach the node from the root node.
     *
     * @return the cost to reach the node from the root node.
     */
    public final double getCost() {
        return cost;
    }

    /**
     * Sets the cost needed to reach the node from the root node.
     *
     * @param cost the cost needed to reach the node from the root nod to set.
     */
    public final void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns the estimated distance to the goal from the node.
     *
     * @return the estimated distance to the goal from the node.
     */
    public final double getHeuristic() {
        return heuristic;
    }

    /**
     * Sets the estimated distance to the goal from the node.
     *
     * @param estimates the estimated distance to the goal from the node to set.
     */
    public final void setHeuristic(double estimates) {
        this.heuristic = estimates;
    }

    /**
     * Returns the depth of this node.
     *
     * @return the depth of this node.
     */
    public int getDepth() {
        return this.depth;
    }

    /**
     * Set the depth of this node.
     *
     * @param depth the depth of this node.
     */
    public void setDepth(final int depth) {
        this.depth = depth;
    }

    /**
     * Returns the value of the heuristic function, i.e.,
     * <code>this.node.getCost() + this.node.getHeuristic()</code>.
     *
     * @param weight the weight of the heuristic.
     * @return the value of the heuristic function, i.e.,
     * <code>this.node.getCost() + this.node.getHeuristic()</code>.
     */
    public final double getValueF(double weight) {
        return weight * this.heuristic + this.cost;
    }

    /**
     * Returns if a node is equal to an other object. The equals method has the same behaviour as the equals method of
     * the class BitState.
     *
     * @param obj the other oject.
     * @return <code>true</code> if the node is equal to the other specified object; <code>false</code> otherwise.
     * @see BitState#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Returns the hash code value of the node. The hashcode method has the same behaviour as the hashcode method of
     * the class BitState.
     *
     * @return the hashcode value for this node.
     * @see BitState#hashCode()
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
