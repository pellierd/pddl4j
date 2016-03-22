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

/**
 * This abstract class implements the main methods of a plan.
 *
 * @author D. Pellier
 * @version 1.0 - 14.03.2016
 *
 * @since 3.0
 */
public abstract class AbstractPlan implements Plan {

    /**
     * Creates a new empty plan.
     */
    protected AbstractPlan() {
        super();
    }

    /**
     * Creates a new plan from a an other one. The new plan is a deep copy of the specified plan in parameter.
     */
    protected AbstractPlan(final Plan other) {
        this();
        other.timeSpecifiers().forEach(t -> other.getActionSet(t).forEach(a -> this.add(t, new BitOp(a))));
    }

    /**
     * Returns the size of the plan. The size of the plan is its number of actions.
     *
     * @return the size of the plan.
     */
    @Override
    public final int size() {
        return this.timeSpecifiers().stream().mapToInt(t -> this.getActionSet(t).size()).sum();
    }

    /**
     * Returns the cost of the plan. The cost of a plan is the sum of the cost of its actions.
     *
     * @retun the cost of the plan.
     */
    @Override
    public double cost() {
        return this.timeSpecifiers().stream().mapToDouble(t ->
            this.getActionSet(t).stream().mapToDouble(a -> a.getCost()).sum()).sum();
    }

    /**
     * Returns if the plan is empty.
     *
     * @return <code>true</code> if the plan is empty; <code>false</code> otherwise.
     * @see Plan#isEmpty()
     */
    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }
}
