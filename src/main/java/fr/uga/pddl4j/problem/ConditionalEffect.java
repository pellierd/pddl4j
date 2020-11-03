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

package fr.uga.pddl4j.problem;

import java.io.Serializable;

/**
 * This class implements the conditional effect of an action.
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 * @see Precondition
 * @see Effect
 */
public class ConditionalEffect implements Serializable {

    /**
     * The condition of the expression.
     */
    private Precondition condition;

    /**
     * The effect associated to the condition.
     */
    private Effect effect;

    /**
     * Creates a conditional effect from an other. This constructor is the copy constructor.
     *
     * @param other the other conditional bit expression.
     */
    public ConditionalEffect(final ConditionalEffect other) {
        if (other == null) {
            throw new NullPointerException("other == null");
        }
        this.condition = new Precondition(other.getCondition());
        this.effect = new Effect(other.getEffect());
    }

    /**
     * Creates a new empty conditional effect.
     */
    public ConditionalEffect() {
        this(new Precondition(), new Effect());
    }

    /**
     * Creates a new conditional effect with some specified effect.
     *
     * @param effect the effect.
     */
    public ConditionalEffect(final Effect effect) {
        this(new Precondition(), effect);
    }

    /**
     * Creates a new conditional effect with some specified condition and effect.
     *
     * @param condition the condition.
     * @param effect the effect.
     */
    public ConditionalEffect(final Precondition condition, final Effect effect) {
        this.setEffect(effect);
        this.setCondition(condition);
    }

    /**
     * Returns the condition of the conditional effect.
     *
     * @return the condition of the conditional effect.
     */
    public final Precondition getCondition() {
        return this.condition;
    }

    /**
     * Sets the condition of the conditional effect.
     *
     * @param condition the condition to set.
     */
    public final void setCondition(Precondition condition) {
        this.condition = condition;
    }

    /**
     * Returns the effect of the conditional effect.
     *
     * @return the effect of the conditional effect.
     */
    public final Effect getEffect() {
        return this.effect;
    }

    /**
     * Sets the effect of the conditional effect.
     *
     * @param effect the effect to set
     */
    public final void setEffect(Effect effect) {
        this.effect = effect;
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
     * type as this instance, all of whose members (condition and effect) are equal to the
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
            return this.condition.equals(other.condition) && this.effect.equals(other.effect);
        }
        return false;
    }

}
