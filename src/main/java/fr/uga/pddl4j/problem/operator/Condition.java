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

import fr.uga.pddl4j.problem.numeric.NumericConstraint;
import fr.uga.pddl4j.util.BitVector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class implements the precondition of the actions or the methods.
 *
 * @author D. Pellier
 * @version 1.0 - 28.10.2020
 * @since 4.0
 * @see FluentDescription
 * @see NumericConstraint
 */
public class Condition extends AbstractFluentDescription {

    /**
     * The list of numeric constraints of this precondition.
     */
    private List<NumericConstraint> constraints;

    /**
     * Creates new effect. By default the effect has no positive and no negative fluents.
     */
    public Condition() {
        this(new BitVector(), new BitVector());
    }

    /**
     * Creates new effect from an other one. This constructor create a deep copy of the object in parameter.
     *
     * @param other the other one.
     */
    public Condition(final Condition other) {
        super(other);
        this.constraints = new ArrayList<>();
        this.constraints.addAll(other.getNumericConstraints().stream().map(NumericConstraint::new)
            .collect(Collectors.toList()));
    }

    /**
     * Creates new effect from a specified positive and negative fluent description and an empty set of
     * numeric constraints.
     *
     * @param positive the positive bit vector of fluent description.
     * @param negative the negative bit vector of fluent description.
     */
    public Condition(final BitVector positive, final BitVector negative) {
        super(positive, negative);
        this.constraints = new ArrayList<>();
    }

    /**
     * Returns the numeric constraints of the precondition.
     *
     * @return the numeric constraints of the precondition.
     */
    public final List<NumericConstraint> getNumericConstraints() {
        return this.constraints;
    }

    /**
     * Sets the numeric constraints of the precondition.
     *
     * @param constraints the numeric constraints of the precondition.
     */
    public final void setNumericConstraints(final List<NumericConstraint> constraints) {
        this.constraints = constraints;
    }

    /**
     * Adds a numeric constraints of the precondition.
     *
     * @param constraint the numeric constraint to add.
     */
    public final void addNumericConstraint(final NumericConstraint constraint) {
        this.constraints.add(constraint);
    }


    /**
     * Returns the hash code value of the precondition.
     *
     * @return the hash code value of the precondition.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getPositiveFluents(), this.getNegativeFluents(), this.getNumericConstraints());
    }

    /**
     * Return if a specified object is equals to this precondition. The specified object is equal to
     * the precondition if and only if the object is an instance of the class <code>Condition</code>
     * and it has the same positive and negative timed fluent description.
     *
     * @param obj the specified object to compared.
     * @return <code>true</code> if the specified object is equal to the precondition; <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof Condition) {
            Condition other = (Condition) obj;
            return this.getPositiveFluents().equals(other.getPositiveFluents())
                && this.getNegativeFluents().equals(other.getNegativeFluents())
                && this.getNumericConstraints().equals(other.getNumericConstraints());
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
        str.append("** Positive fluents **\n");
        str.append(this.getPositiveFluents());
        str.append("** Negative fluents **\n");
        str.append(this.getNegativeFluents());
        str.append("** Numeric constraints **\n");
        for (NumericConstraint constraint : this.getNumericConstraints()) {
            str.append(constraint);
            str.append("\n");
        }
        return str.toString();
    }
}
