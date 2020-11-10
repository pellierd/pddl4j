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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class allows to implements the conditional effect of an action.
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
public class ConditionalEffect implements Serializable {

    /**
     * The conditions of the expression.
     */
    private List<Condition> conditions;

    /**
     * The effect associated to the conditions.
     */
    private Effect effect;

    /**
     * Creates a conditional effect from an other. This constructor is the copy constructor.
     *
     * @param other the other conditional bit expression.
     */
    public ConditionalEffect(final ConditionalEffect other) {
        this.conditions = new ArrayList<>();
        this.conditions.addAll(other.getConditions().stream().map(Condition::new)
            .collect(Collectors.toList()));
        this.effect = new Effect(other.getEffect());
    }

    /**
     * Creates a new empty conditional effect.
     */
    public ConditionalEffect() {
        this(new Effect());
    }

    /**
     * Creates a new conditional effect with some specified effect.
     *
     * @param effect the effect.
     */
    public ConditionalEffect(final Effect effect) {
        this(new ArrayList<>(), effect);
    }

    /**
     * Creates a new conditional effect with some specified conditions and effect.
     *
     * @param conditions the conditions.
     * @param effects    the effect.
     */
    public ConditionalEffect(List<Condition> conditions, Effect effects) {
        this.setConditions(conditions);
        this.setEffect(effects);
    }

    /**
     * Returns the conditions of the conditional effect.
     *
     * @return the conditions of the conditional effect.
     */
    public final List<Condition> getConditions() {
        return this.conditions;
    }

    /**
     * Adds a condition to this effect.
     *
     * @param condition the condition to add.
     */
    public final void addCondition(Condition condition) {
        this.conditions.add(condition);
    }

    /**
     * Sets the conditions of the conditional effect.
     *
     * @param conditions the conditions to set.
     */
    public final void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
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
        result = prime * result + conditions.hashCode();
        result = prime * result + effect.hashCode();
        return result;
    }

    /**
     * Returns <code>true</code> if a specified object is equal to this conditional expression. In
     * other words, returns <code>true</code> if the specified object is an instance of the same
     * type as this instance, all of whose members (conditions and effect) are equal to the
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
            return this.conditions.equals(other.conditions) && this.effect.equals(other.effect);
        }
        return false;
    }

}
