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

package fr.uga.pddl4j.util;

import java.io.Serializable;

/**
 * This class allows to implements a conditional effects of an operator.
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
public class CondBitExp implements Serializable {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The conditions of the expression.
     */
    private BitExp conditions;

    /**
     * The effects associated to the conditions.
     */
    private BitExp effects;

    /**
     * Creates a conditional bit expression from an other. This constructor is the copy constructor.
     *
     * @param other the other conditional bit expression.
     */
    public CondBitExp(final CondBitExp other) {
        if (other == null) {
            throw new NullPointerException("other == null");
        }
        this.conditions = new BitExp(other.getCondition());
        this.effects = new BitExp(other.getEffects());
    }

    /**
     * Creates a new empty conditional expression.
     */
    public CondBitExp() {
        this(new BitExp(), new BitExp());
    }

    /**
     * Creates a new conditional expression with some specified effects.
     *
     * @param effects the effects.
     */
    public CondBitExp(final BitExp effects) {
        this(new BitExp(), effects);
    }

    /**
     * Creates a new conditional expression with some specified conditions and effects.
     *
     * @param conditions the conditions.
     * @param effects    the effects.
     */
    public CondBitExp(BitExp conditions, BitExp effects) {
        this.setEffects(effects);
        this.setCondition(conditions);
    }

    /**
     * Returns the conditions of the conditional expression.
     *
     * @return the conditions of the conditional expression.
     */
    public final BitExp getCondition() {
        return this.conditions;
    }

    /**
     * Sets the conditions of the conditional expression.
     *
     * @param conditions the conditions to set.
     */
    public final void setCondition(BitExp conditions) {
        if (conditions == null) {
            throw new NullPointerException("conditions == null");
        }
        this.conditions = conditions;
    }

    /**
     * Returns the effects of the conditional expression.
     *
     * @return the effects of the conditional expression.
     */
    public final BitExp getEffects() {
        return this.effects;
    }

    /**
     * Sets the effects of the conditional expression.
     *
     * @param effects the effects to set
     * @throws NullPointerException if <code>effects == null</code>.
     */
    public final void setEffects(BitExp effects) {
        if (effects == null) {
            throw new NullPointerException("effects == null");
        }
        this.effects = effects;
    }

    /**
     * Returns the hash code of this conditional expression.
     *
     * @return the hash code of this conditional expression.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + conditions.hashCode();
        result = prime * result + effects.hashCode();
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
        if (obj != null && obj instanceof CondBitExp) {
            CondBitExp other = (CondBitExp) obj;
            return this.conditions.equals(other.conditions) && this.effects.equals(other.effects);
        }
        return false;
    }

}
