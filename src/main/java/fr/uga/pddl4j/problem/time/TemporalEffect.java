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

import fr.uga.pddl4j.problem.numeric.NumericAssignment;
import fr.uga.pddl4j.problem.operator.Effect;
import fr.uga.pddl4j.problem.operator.FluentDescription;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class implements the effect of the actions.
 *
 * @author D. Pellier
 * @version 1.0 - 28.10.2020
 * @since 4.0
 * @see FluentDescription
 * @see NumericAssignment
 */
public class TemporalEffect implements Serializable {

    /**
     * The effect used to store the 'at start' effect of the effect.
     */
    private Effect atStart;

    /**
     * The effect used to store the 'at end' effect of the effect.
     */
    private Effect atEnd;

    /**
     * The effect used to store the 'overall' effect of the effect.
     */
    private Effect overall;

    /**
     * Creates new time effect. By default the effect is empty
     */
    public TemporalEffect() {
        this(new Effect(), new Effect(), new Effect());
    }

    /**
     * Creates new effect from an other one. This constructor create a deep copy of the object in parameter.
     *
     * @param other the other one.
     */
    public TemporalEffect(final TemporalEffect other) {
        this(new Effect(other.getAtStartEffect()),
            new Effect(other.getOverallEffect()),
            new Effect(other.getAtEndEffect()));
    }

    /**
     * Creates a new time effect from a specified 'at start", 'overall' and 'at end effect.
     *
     * @param atStart the start effect.
     * @param overall the overall effect.
     * @param atEnd the atEnd effect.
     */
    public TemporalEffect(final Effect atStart, final Effect overall, final Effect atEnd) {
        this.setAtStartEffect(atStart);
        this.setOverallEffect(overall);
        this.setAtEndEffect(atEnd);
    }

    /**
     * Returns the at start effect of the time effect.
     *
     * @return the at start effect of the time effect.
     */
    public Effect getAtStartEffect() {
        return this.atStart;
    }

    /**
     * Returns the at end effect of the time effect.
     *
     * @return the at end effect of the time effect.
     */
    public Effect getAtEndEffect() {
        return this.atEnd;
    }

    /**
     * Returns the overall effect of the time effect.
     *
     * @return the overall effect of the time effect.
     */
    public Effect getOverallEffect() {
        return this.overall;
    }

    /**
     * Sets the at start effect of the time effect.
     *
     * @param atStart the at start effect to set.
     */
    public void setAtStartEffect(Effect atStart) {
        this.atStart = atStart;
    }

    /**
     * Sets the at end effect of the time effect.
     *
     * @param atEnd the at end effect to set.
     */
    public void setAtEndEffect(Effect atEnd) {
        this.atEnd = atEnd;
    }

    /**
     * Sets the overall effect of the time effect.
     *
     * @param overall the at end effect to set.
     */
    public void setOverallEffect(Effect overall) {
        this.overall = overall;
    }


    /**
     * Returns the hash code value of this time effect.
     *
     * @return the hash code value of this time effect.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getAtStartEffect(), this.getAtEndEffect(), this.getOverallEffect());
    }

    /**
     * Return if a specified object is equals to this effect. The specified object is equal to
     * the time effect if and only if the object is an instance of the class <code>TemporalEffect</code>
     * and it has the same positive and negative timed fluent description and the same numeric assignments.
     *
     * @param object the specified object to be compared.
     * @return <code>true</code> if the specified object is equal to this time effect; <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof TemporalEffect) {
            TemporalEffect other = (TemporalEffect) object;
            return Objects.equals(this.getAtStartEffect(), other.getAtStartEffect())
                && Objects.equals(this.getAtEndEffect(), other.getAtEndEffect())
                && Objects.equals(this.getOverallEffect(), other.getOverallEffect());
        }
        return false;
    }

    /**
     * Returns a string representation of this time effect.
     *
     * @return a string representation of this time effect.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("** At start effect **\n");
        str.append(this.getAtStartEffect());
        str.append("** Over all effect **\n");
        str.append(this.getOverallEffect());
        str.append("** At end effect **\n");
        str.append(this.getAtEndEffect());
        return str.toString();
    }
}
