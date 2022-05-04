/*
 * Copyright (c) 2022 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
  of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.parser;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class defines the methods to manipulate a interval used in PDDL expressions.
 *
 * @author D. Pellier
 * @version 1.0 - 15.03.2022
 */
public class PDDLTimeInterval implements Serializable {

    /**
     * The lower bound.
     */
    private PDDLSymbol lower;

    /**
     * The upper bound.
     */
    private PDDLSymbol upper;

    /**
     * Creates new interval. The constructor is private to prevent use of default constructor.
     */
    private PDDLTimeInterval() {
        super();
    }

    /**
     * Creates new interval.
     *
     * @param lower the lower bound.
     * @param upper the upper bound.
     */
    public PDDLTimeInterval(final PDDLSymbol lower, final PDDLSymbol upper) {
        this.lower = lower;
        this.upper = upper;
    }

    /**
     * Creates new interval from another, i.e., creates a deep copy.
     *
     * @param other the other interval.
     */
    public PDDLTimeInterval(final PDDLTimeInterval other) {
        this(new PDDLSymbol(other.getLowerBound()), new PDDLSymbol(other.getUpperBound()));
    }

    /**
     * Returns the lower bound of the interval.
     *
     * @return the lower bound of the interval.
     */
    public final PDDLSymbol getLowerBound() {
        return this.lower;
    }

    /**
     * Sets the lower bound of the interval.
     *
     * @param bound the lower bound of the interval.
     */
    public void setLowerBound(PDDLSymbol bound) {
        this.lower = bound;
    }

    /**
     * Returns the upper bound of the interval.
     *
     * @return the upper bound of the interval.
     */
    public final PDDLSymbol getUpperBound() {
        return this.upper;
    }

    /**
     * Sets the upper bound of the interval.
     *
     * @param bound the upper bound of the interval.
     */
    public void setUpperBound(PDDLSymbol bound) {
        this.upper = bound;
    }

    /**
     * Returns the hash code value of the interval.
     *
     * @return the hash code value of the interval.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getLowerBound(), this.getUpperBound());
    }

    /**
     * Returns if an object is equal to this interval. An object is equals to this interval, if the object is an
     * instance <code>PDDLInterval</code> and has the same lower and upper bounds.
     *
     * @param object the object to be compared.
     * @returns <code>true</code> if the object in parameter is equal to this interval of <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object instanceof PDDLTimeInterval) {
            final PDDLTimeInterval other = (PDDLTimeInterval) object;
            return other.getLowerBound().equals(this.getLowerBound())
                && other.getUpperBound().equals(this.getUpperBound());
        }
        return false;
    }

    /**
     * Returns if this interval is valid. An interval is valid if it is an internal defined over task id or if it is
     * defined on number the lower bound is less or equal to the upper bound.
     *
     * @return <code>true</code> if the interval is valid; <code>false</code> otherwise.
     */
    public final boolean isValid() {
        return (this.getUpperBound().getKind().equals(PDDLSymbol.Kind.TASK_ID)
            && this.getLowerBound().getKind().equals(PDDLSymbol.Kind.TASK_ID))
            || (this.getUpperBound().getKind().equals(PDDLSymbol.Kind.NUMBER)
            && this.getLowerBound().getKind().equals(PDDLSymbol.Kind.NUMBER)
            && this.getLowerBound().getValue() <= this.getUpperBound().getValue());
    }

    /**
     * Returns a string representation of this interval.
     *
     * @return a string representation of this interval.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append(this.getLowerBound().getImage());
        str.append(" ");
        str.append(this.getUpperBound().getImage());
        return str.toString();
    }
}
