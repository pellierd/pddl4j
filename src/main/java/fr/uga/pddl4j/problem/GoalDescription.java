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

import fr.uga.pddl4j.encoding.Encoder;
import fr.uga.pddl4j.util.BitVector;

import java.io.Serializable;
import java.util.*;

/**
 * This class implements a goal description. The class goal description is used to represents the preconditions and the
 * effects of the action and the method. The class uses a bit vector representation of the fluents.
 *
 * @author D. Pellier
 * @version 1.0 - 07.06.2010
 * @since 4.0
 * @see BitVector
 * @see TimedGoalDescription
 * @see NumericConstraint
 */
public class GoalDescription implements Serializable {

    /**
     * The time goal description used to store the positive fluents of the goal description.
     */
    private TimedGoalDescription positive;

    /**
     * The time goal description used to store the negative fluents of the goal description.
     */
    private TimedGoalDescription negative;

    /**
     * The list of numeric constraint of this goal description.
     */
    private Set<NumericConstraint> constraints;

    /**
     * Creates a new goal description. By default the goal description has no positive and no negative fluents.
     */
    public GoalDescription() {
        this(new TimedGoalDescription(), new TimedGoalDescription());
    }

    /**
     * Creates a new goal description from an other one. This constructor create a deep copy of the object in parameter.
     *
     * @param other the other one.
     */
    public GoalDescription(final GoalDescription other) {
        this(new TimedGoalDescription(other.getPositiveTimedGoalDescription()),
            new TimedGoalDescription(other.getNegativeTimedGoalDescription()));
    }

    /**
     * Creates a new goal description from a specified positive and negative timed goal description and an empty set of
     * numeric constraints.
     *
     * @param positive the positive timed goal description of goal description.
     * @param negative the positive timed goal description of goal description.
     * @see TimedGoalDescription
     */
    public GoalDescription(final TimedGoalDescription positive, final TimedGoalDescription negative) {
        this.positive = positive;
        this.negative = negative;
        this.constraints = new LinkedHashSet<>();
    }

    /**
     * Returns the positive fluents of the goal description. This method is equivalent of
     * <code>this.getPositiveTimedGoalDescription().getAtStart()</code>.
     *
     * @return the positive fluents of the goal description.
     */
    public final BitVector getPositiveFluents() {
        return this.positive.getAtStartFluents();
    }

    /**
     * Returns the positive fluents of the goal description. This method is equivalent of
     * <code>this.getNegativeTimedGoalDescription().getAtStart()</code>.
     *
     * @return the negative fluents of the goal description.
     */
    public final BitVector getNegativeFluents() {
        return this.negative.getAtStartFluents();
    }

    /**
     * Returns the positive timed goal description of the goal description.
     *
     * @return the positive timed goal description of the goal description.
     */
    public final TimedGoalDescription getPositiveTimedGoalDescription() {
        return this.positive;
    }

    /**
     * Sets the positive timed goal description of the goal description.
     *
     * @param positive the positive timed goal description to set.
     */
    public final void setPositiveTimedGoalDescription(final TimedGoalDescription positive) {
        this.positive = positive;
    }

    /**
     * Returns the negative timed goal description of the goal description.
     *
     * @return the negative timed goal description of the goal description.
     */
    public final TimedGoalDescription getNegativeTimedGoalDescription() {
        return this.negative;
    }

    /**
     * Sets the negative timed goal description of the goal description.
     *
     * @param negative the negative timed goal description to set.
     */
    public final void setNegativeTimedGoalDescription(final TimedGoalDescription negative) {
        this.negative = negative;
    }

    /**
     * Returns the numeric constraints of this goal description.
     *
     * @return the numeric constraints of this goal description.
     */
    public final Set<NumericConstraint> getNumericConstraints() {
        return this.constraints;
    }

    /**
     * Sets the numeric constraints of this goal description.
     *
     * @param constraints the numeric constraints of this goal description.
     */
    public final void setNumericConstraints(final Set<NumericConstraint> constraints) {
        this.constraints = constraints;
    }

    /**
     * Adds a numeric constraints of this goal description.
     *
     * @param constraint the numeric constraint to add.
     */
    public final void addNumericConstraint(final NumericConstraint constraint) {
        this.constraints.add(constraint);
    }

    /**
     * Returns if goal description is empty, i.e., if the goal description has no positive and no negative
     * fluent. Such a goal description is always true.
     *
     * @return <code>true</code> if the goal description is empty; <code>false</code> otherwise.
     */
    public final boolean isEmpty() {
        return this.positive.isEmpty() && this.negative.isEmpty();
    }

    /**
     * Returns the cardinality of the goal description, i.e., the number of fluents defined the positive and negative
     * timed goal description.
     *
     * @return the cardinality of the goal description.
     */
    public final int cardinality() {
        return this.positive.cardinality() + this.negative.cardinality();
    }

    /**
     * Returns if this goal description is durative. A goal description is durative it has fluent wit time specifier
     * (at start, at end, over-all) or have durative numeric constraits.
     *
     * @return <code>true</code> if the goal description is durative.
     */
    public final boolean isDurative() {
        return !this.getPositiveTimedGoalDescription().getOverAllFluents().isEmpty()
            || !this.getPositiveTimedGoalDescription().getAtEndFluents().isEmpty()
            || !this.getNegativeTimedGoalDescription().getOverAllFluents().isEmpty()
            || !this.getNegativeTimedGoalDescription().getAtEndFluents().isEmpty()
            || this.hasDurativeNumericConstraints();
    }

    /**
     * Returns if the goal descriptions has a durative numeric constraints.
     *
     * @return <code>true</code> if the goak description has a durative numeric constraints.
     */
    public final boolean hasDurativeNumericConstraints() {
        boolean durative = false;
        final Iterator<NumericConstraint> i = this.getNumericConstraints().iterator();
        while (i.hasNext() && !durative) {
            final NumericConstraint constraint = i.next();
            durative = constraint.isDurative();
        }
        return durative;
    }

    /**
     * Returns the hash code value of the goal description.
     *
     * @return the hash code value of the goal description.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getPositiveTimedGoalDescription(), this.getNegativeTimedGoalDescription(),
            this.getNumericConstraints());
    }

    /**
     * Return if a specified object is equals to this goal description. The specified object is equal to
     * the goal description if and only if the object is an instance of the class <code>GoalDescription</code>
     * and it has the same positive and negative timed goal description.
     *
     * @param obj the specified object to compared.
     * @return <code>true</code> if the specified object is equal to the goal description;
     * <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof GoalDescription) {
            GoalDescription other = (GoalDescription) obj;
            return this.positive.equals(other.positive)
                && this.negative.equals(other.negative)
                && this.constraints.equals(other.constraints);
        }
        return false;
    }

    /**
     * Returns a string representation of this goal description.
     *
     * @return a string representation of this goal description.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("** Positive fluents **\n");
        str.append(this.getPositiveTimedGoalDescription());
        str.append("** Negative fluents **\n");
        str.append(this.getNegativeTimedGoalDescription());
        str.append("** Numeric constraints **\n");
        for (NumericConstraint constraint : this.getNumericConstraints()) {
            str.append(constraint);
            str.append("\n");
        }
        return str.toString();
    }
}
