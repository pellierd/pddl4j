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

package fr.uga.pddl4j.problem.time;

import fr.uga.pddl4j.problem.operator.ConditionalEffect;

import java.io.Serializable;

/**
 * This class implements the time conditional effects of an action.
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
public class TemporalConditionalEffect implements Serializable {

    /**
     * The conditions of the expression.
     */
    private TemporalCondition condition;

    /**
     * The effects associated to the conditions.
     */
    private TemporalEffect effect;

    /**
     * Creates a conditional effect from an other. This constructor is the copy constructor.
     *
     * @param other the other conditional bit expression.
     */
    public TemporalConditionalEffect(final TemporalConditionalEffect other) {
        this.condition = new TemporalCondition(other.getCondition());
        this.effect = new TemporalEffect(other.getEffect());
    }

    /**
     * Creates a new empty conditional effect.
     */
    public TemporalConditionalEffect() {
        this(new TemporalCondition(), new TemporalEffect());
    }

    /**
     * Creates a new conditional effect with some specified effects.
     *
     * @param effects the effects.
     */
    public TemporalConditionalEffect(final TemporalEffect effects) {
        this(new TemporalCondition(), effects);
    }

    /**
     * Creates a new conditional effect with some specified conditions and effects.
     *
     * @param condition the conditions.
     * @param effect    the effects.
     */
    public TemporalConditionalEffect(TemporalCondition condition, TemporalEffect effect) {
        this.setEffect(effect);
        this.setCondition(condition);
    }

    /**
     * Returns the conditions of the conditional effect.
     *
     * @return the conditions of the conditional effect.
     */
    public final TemporalCondition getCondition() {
        return this.condition;
    }

    /**
     * Sets the conditions of the conditional effect.
     *
     * @param conditions the conditions to set.
     */
    public final void setCondition(TemporalCondition conditions) {
        this.condition = conditions;
    }

    /**
     * Returns the effects of the conditional effect.
     *
     * @return the effects of the conditional effect.
     */
    public final TemporalEffect getEffect() {
        return this.effect;
    }

    /**
     * Sets the effects of the conditional effect.
     *
     * @param effects the effects to set
     */
    public final void setEffect(TemporalEffect effects) {
        this.effect = effects;
    }

    /**
     * Returns the hash code of this conditional effect.
     *
     * @return the hash code of this conditional effect.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + condition.hashCode();
        result = prime * result + effect.hashCode();
        return result;
    }

    /**
     * Returns <code>true</code> if a specified object is equal to this conditional expression. In
     * other words, returns <code>true</code> if the specified object is an instance of the same
     * type as this instance, all of whose members (conditions and effects) are equal to the
     * corresponding member of this conditional expression.
     *
     * @param obj the reference object with which to compare.
     * @return <code>true</code> if a specified object is equal to this conditional expression;
     * <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof ConditionalEffect) {
            ConditionalEffect other = (ConditionalEffect) obj;
            return this.condition.equals(other.getCondition()) && this.effect.equals(other.getEffect());
        }
        return false;
    }

}
