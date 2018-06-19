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

package fr.uga.pddl4j.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * This class implements a sequential plan. Actions in a sequential plan must be consecutive.
 *
 * @author D. Pellier
 * @version 1.0 - 15.03.2016
 * @since 3.0
 */
public class SequentialPlan extends AbstractPlan {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The list used to store the actions contained in the plan.
     */
    private List<BitOp> actions;

    /**
     * Creates a new empty sequential plan.
     *
     * @see AbstractPlan#AbstractPlan()
     */
    public SequentialPlan() {
        super();
        this.actions = new ArrayList<>();
    }

    /**
     * Creates a new sequential plan from an other. This constructor creates a deep copy of the specified plan.
     *
     * @param other the other plan.
     * @see AbstractPlan#AbstractPlan(Plan)
     */
    public SequentialPlan(final Plan other) {
        super(other);
    }

    /**
     * Returns the makespan of the plan. The makespan of a sequential plan is its size.
     *
     * @return the makespan of the plan.
     * @see Plan#size()
     */
    @Override
    public final double makespan() {
        return this.size();
    }

    /**
     * Returns the list of actions contained in the plan ordered depending on their time specifier.
     *
     * @return the ordered set of actions of the plan.
     * @see Plan#actions()
     */
    @Override
    public final List<BitOp> actions() {
        return this.actions;
    }

    /**
     * Returns the set of time specifiers used in this plan.
     *
     * @return the set of time specifiers used in this plan.
     * @see Plan#timeSpecifiers()
     */
    @Override
    public final Set<Integer> timeSpecifiers() {
        final Set<Integer> ts = new LinkedHashSet<>();
        for (int i = 0; i < this.actions.size(); i++) {
            ts.add(i);
        }
        return ts;
    }

    /**
     * Returns the set of actions at a specified time specifier.
     *
     * @param time the time specifier.
     * @return the set of actions at a specified time specifier or null if no actions are scheduled in the plan at the
     *          the time specifier.
     * @see Plan#getActionSet(int)
     */
    @Override
    public final Set<BitOp> getActionSet(final int time) {
        if (this.isTimeSpecifierOutOfBound(time)) {
            return null;
        }
        final Set<BitOp> ts = new HashSet<>();
        ts.add(this.actions.get(time));
        return ts;
    }

    /**
     * Adds an action at a specified time specifier in the plan.
     *
     * @param action the action to add.
     * @param time   the time specifier of the action in the plan.
     * @return <code>true</code> if the action was added; <code>false</code> otherwise.
     * @see Plan#add(int, BitOp)
     */
    @Override
    public final boolean add(final int time, final BitOp action) {
        if (this.isTimeSpecifierOutOfBound(time)) {
            return false;
        }
        this.actions.add(time, action);
        return true;
    }

    /**
     * Removes an action at a specified time specifier of the plan.
     *
     * @param action the action to remove.
     * @param time   the time specifier of the action in the plan to remove.
     * @see Plan#remove(int, BitOp)
     */
    @Override
    public final boolean remove(final int time, final BitOp action) {
        if (!this.contains(time, action)) {
            return false;
        }
        this.actions.remove(time);
        return true;
    }

    /**
     * Removes all the actions at a specified time specifier of the plan.
     *
     * @param time the time specifier of the actions in the plan to remove.
     * @see Plan#remove(int)
     */
    @Override
    public final boolean remove(final int time) {
        if (this.isTimeSpecifierOutOfBound(time)) {
            return false;
        }
        this.actions.remove(time);
        return true;
    }

    /**
     * Returns if an action is contained in the plan at a specified time specifier.
     *
     * @param time   the time specifier.
     * @param action the action.
     * @return <code>true</code> if the specified action is contained in the plan at the specified time specifier;
     * <code>false</code> otherwise.
     * @see Plan#contains(int, BitOp)
     */
    @Override
    public final boolean contains(final int time, final BitOp action) {
        return !this.isTimeSpecifierOutOfBound(time) && this.actions.get(time).equals(action);
    }

    /**
     * Removes all the actions of the plan.
     *
     * @see Plan#clear()
     */
    @Override
    public final void clear() {
        this.actions.clear();
    }

    /**
     * Returns if the plan is equal to an other object. A plan is equal to an other object if the object is an instance
     * of the same class and have the same action at the same time specifier. The equals method uses the equal method of
     * the class BitOp to compare actions.
     *
     * @param obj the object to be compared.
     * @return <code>true</code> if this plan is equal to the specified object; <code>false</code> otherwise.
     * @see BitOp#equals(Object)
     * @see java.lang.Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            final SequentialPlan other = (SequentialPlan) obj;
            return Objects.equals(actions, other.actions);
        }
        return false;
    }

    /**
     * Returns the hash code of this plan.
     *
     * @return the hash code of this plan.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(actions);
    }

    /**
     * Returns if a specified time specifier is invalid. Formally a time specifier is invalid if it is less
     * than 0 or greater than the size of the plan.
     *
     * @param time the time stamp.
     * @return <code>true</code> if the specified time specifier is out of bound; <code>false</code> otherwise.
     */
    protected final boolean isTimeSpecifierOutOfBound(final int time) {
        return time < 0 || time > this.actions.size();
    }
}




