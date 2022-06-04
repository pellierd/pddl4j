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

import fr.uga.pddl4j.problem.operator.Condition;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class implements the time condition used to describe precondition of actions and methods.
 *
 * @author D. Pellier
 * @version 1.0 - 03.06.2022
 * @since 4.0
 * @see Condition
 */
public class TemporalCondition implements Serializable {

    /**
     * The condition used to store the 'at start' condition of the time description.
     */
    private Condition atStart;

    /**
     * The condition used to store the 'at end' condition of the time description.
     */
    private Condition atEnd;

    /**
     * The condition used to store the 'overall' condition of the time description.
     */
    private Condition overall;

    /**
     * Creates a new time condition from another one.
     *
     * @param other the time condition.
     */
    public TemporalCondition(final TemporalCondition other) {
        this.setAtStartCondition(new Condition(other.getAtStartCondition()));
        this.setOverallCondition(new Condition(other.getOverallCondition()));
        this.setAtEndCondition(new Condition(other.getAtEndCondition()));
    }

    /**
     * Creates new empty time condition.
     */
    public TemporalCondition() {
        this(new Condition(), new Condition(), new Condition());
    }

    /**
     * Creates a new time condition from a specified 'at start", 'overall' and 'at end condition.
     *
     * @param atStart the start condition.
     * @param overall the overall condition.
     * @param atEnd the atEnd condition.
     */
    public TemporalCondition(final Condition atStart, final Condition overall, final Condition atEnd) {
        this.setAtStartCondition(atStart);
        this.setOverallCondition(overall);
        this.setAtEndCondition(atEnd);
    }

    /**
     * Returns the at start condition of the time condition.
     *
     * @return the at start condition of the time condition.
     */
    public Condition getAtStartCondition() {
        return this.atStart;
    }

    /**
     * Returns the at end condition of the time condition.
     *
     * @return the at end condition of the time condition.
     */
    public Condition getAtEndCondition() {
        return this.atEnd;
    }

    /**
     * Returns the overall condition of the time condition.
     *
     * @return the overall condition of the time condition.
     */
    public Condition getOverallCondition() {
        return this.overall;
    }

    /**
     * Sets the at start condition of the time condition.
     *
     * @param atStart the at start condition to set.
     */
    public void setAtStartCondition(Condition atStart) {
        this.atStart = atStart;
    }

    /**
     * Sets the at end condition of the time condition.
     *
     * @param atEnd the at end condition to set.
     */
    public void setAtEndCondition(Condition atEnd) {
        this.atEnd = atEnd;
    }

    /**
     * Sets the overall condition of the time condition.
     *
     * @param overall the at end condition to set.
     */
    public void setOverallCondition(Condition overall) {
        this.overall = overall;
    }

    /**
     * Returns if condition is empty, i.e., if the condition has no positive and no negative for at start, at end and
     * overall. Such a condition is always true.
     *
     * @return <code>true</code> if the condition is empty; <code>false</code> otherwise.
     */
    public final boolean isEmpty() {
        return this.getAtStartCondition().isEmpty()
            && this.getOverallCondition().isEmpty()
            && this.getAtEndCondition().isEmpty();
    }

    /**
     * Returns the cardinality of the condition, i.e., the number of fluents defined in the at start, at end and overall
     * conditions.
     *
     * @return the cardinality of the time condition.
     */
    public final int cardinality() {
        return this.getAtStartCondition().cardinality()
            + this.getOverallCondition().cardinality()
            + this.getAtEndCondition().cardinality();
    }

    /**
     * Returns if this time condition is consistent. A time condition is consistent if at start, at end and overall
     * condition are consistent.
     *
     * @return <code>true</code> if this time condition is consistent <code>false</code> otherwise.
     */
    public final boolean isConsistent() {
        return this.getAtStartCondition().isConsistent()
            && this.getOverallCondition().isConsistent()
            && this.getAtEndCondition().isConsistent();
    }


    /**
     * Returns the hash code value of the time condition.
     *
     * @return the hash code value of the time condition.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getAtStartCondition(), this.getOverallCondition(), this.getAtEndCondition());
    }

    /**
     * Return if a specified object is equals to this time condition. The specified object is equal to
     * the time conditiion if and only if the object is an instance of the class <code>TemporalCondition</code>
     * and it has the same at start, at end and overall condition.
     *
     * @param obj the specified object to compared.
     * @return <code>true</code> if the specified object is equal to this time condition; <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof Condition) {
            TemporalCondition other = (TemporalCondition) obj;
            return Objects.equals(this.getAtStartCondition(), other.getAtStartCondition())
                && Objects.equals(this.getOverallCondition(),other.getOverallCondition())
                && Objects.equals(this.getAtEndCondition(), other.getAtEndCondition());
        }
        return false;
    }

    /**
     * Returns a string representation of the precondition.
     *
     * @return a string representation of the precondition.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("** At start condition **\n");
        str.append(this.getAtStartCondition());
        str.append("** Over all condition **\n");
        str.append(this.getOverallCondition());
        str.append("** At end condition **\n");
        str.append(this.getAtEndCondition());
        return str.toString();
    }
}
