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

package fr.uga.pddl4j.problem.operator;

import fr.uga.pddl4j.parser.PDDLConnective;

/**
 * This class implements an action. This class is used to store compact representation of an action
 * during the instantiation process.
 *
 * <p>Revisions:
 * <ul>
 * <li>20.10.2020: change the duration attribute to encode temporal problem.</li>
 * </ul>
 *
 * @author D. Pellier
 * @version 1.1 - 07.04.2010
 */
public final class IntAction extends AbstractIntOperator {

    /**
     * The default cost of an action.
     */
    public static double DEFAULT_COST = 1.0;

    /**
     * The expression that represents the effect of the action.
     */
    private IntExpression effects;

    /**
     * The cost of the action.
     */
    private double cost;

    /**
     * The duration of the action.
     */
    private IntExpression duration;

    /**
     * Create a new action from a specified action. This constructor create a deep copy of the
     * specified action.
     *
     * @param other the other action.
     */
    public IntAction(final IntAction other) {
        super(other);
        this.effects = new IntExpression(other.getEffects());
        this.cost = other.getCost();
        if (other.getDuration() != null) {
            this.duration = new IntExpression(other.getDuration());
        }
    }

    /**
     * Create a new action with a specified name.
     *
     * @param name  the name of the action.
     * @param arity the arity of the action. Arity must be greater than 0.
     */
    public IntAction(final String name, final int arity) {
        super(name, arity);
        this.effects = new IntExpression(PDDLConnective.AND);
        this.cost = IntAction.DEFAULT_COST;
        this.duration = null;
    }

    /**
     * Returns if this action is a durative action.
     *
     * @return <code>true</code> if this action is durative; <code>false</code> otherwise.
     */
    public final boolean isDurative() {
        return this.duration != null;
    }

    /**
     * Returns the duration of the action.
     *
     * @return the duration of the action.
     */
    public final IntExpression getDuration() {
        return this.duration;
    }

    /**
     * Sets the duration of the action.
     *
     * @param duration the duration to set.
     */
    public final void setDuration(final IntExpression duration) {
        this.duration = duration;
    }

    /**
     * Returns the cost of the action.
     *
     * @return the cost of the action.
     */
    public final double getCost() {
        return this.cost;
    }

    /**
     * Sets the cost of the action.
     *
     * @param cost the cost to set.
     */
    public final void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Return the effects of the action.
     *
     * @return the effects of the action.
     */
    public final IntExpression getEffects() {
        return this.effects;
    }

    /**
     * Set the new effects of the action.
     *
     * @param effects the effects to set
     */
    public final void setEffects(final IntExpression effects) {
        this.effects = effects;
    }

}
