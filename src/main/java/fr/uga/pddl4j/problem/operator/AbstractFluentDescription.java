/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
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

import fr.uga.pddl4j.util.BitVector;

/**
 * This class implements a common methods to manipulate a fluent description.
 *
 * @author D. Pellier
 * @version 1.0 - 07.06.2010
 * @since 4.0
 * @see BitVector
 */
public abstract class AbstractFluentDescription implements FluentDescription {

    /**
     * The time fluent description used to store the positive fluents of the goal description.
     */
    private BitVector positive;

    /**
     * The time fluent description used to store the negative fluents of the goal description.
     */
    private BitVector negative;

    /**
     * Creates a new fluent description. By default the fluent description has no positive and no negative fluents.
     */
    public AbstractFluentDescription() {
        this(new BitVector(), new BitVector());
    }

    /**
     * Creates a new fluent description from an other one. This constructor create a deep copy of the object in
     * parameter.
     *
     * @param other the other one.
     */
    public AbstractFluentDescription(final FluentDescription other) {
        this(new BitVector(other.getPositiveFluents()), new BitVector(other.getNegativeFluents()));
    }

    /**
     * Creates a new fluent description from a specified positive and negative timed fluent description.
     *
     * @param positive the positive bit vector of fluent description.
     * @param negative the positive bit vector of fluent description.
     */
    public AbstractFluentDescription(final BitVector positive, final BitVector negative) {
        this.positive = positive;
        this.negative = negative;
    }

    /**
     * Returns the positive fluents of the fluent description.
     *
     * @return the positive fluents of the goal description.
     */
    public final BitVector getPositiveFluents() {
        return this.positive;
    }

    /**
     * Returns the positive fluents of the fluent description.
     *
     * @return the negative fluents of the goal description.
     */
    public final BitVector getNegativeFluents() {
        return this.negative;
    }

    /**
     * Returns if fluent description is empty, i.e., if the fluent description has no positive and no negative
     * fluent. Such a goal description is always true.
     *
     * @return <code>true</code> if the fluent description is empty; <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return this.positive.isEmpty() && this.negative.isEmpty();
    }

    /**
     * Returns the cardinality of the fluent description, i.e., the number of fluents defined the positive and negative
     * timed fluent description.
     *
     * @return the cardinality of the goal description.
     */
    public final int cardinality() {
        return this.positive.cardinality() + this.negative.cardinality();
    }

    /**
     * Returns if this abstract fluent description is consistent. A fluent description is consistent a fluent is at the
     * same postive and negative.
     *
     * @return <code>true</code> if this abstract fluent description is consistent <code>false</code> otherwise.
     */
    public final boolean isConsistent() {
        return !this.getPositiveFluents().intersects(this.getNegativeFluents());
    }

}
