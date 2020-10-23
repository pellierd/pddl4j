package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.util.BitVector;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class implements a timed goal description, i.e., a triplet a three bit vector to represent fluents that hold
 * respectively at start, at end and over all. This class is used to define action precondition and effect.
 *
 * @author D. Pellier
 * @version 1.0 - 21.10.2020
 * @since 4.0
 */
public class TimedGoalDescription implements Serializable {

    /**
     * The bit vector used to store the fluent that must hold at start.
     */
    private BitVector atStart;

    /**
     * The bit vector used to store the fluent that must hold at end.
     */
    private BitVector atEnd;

    /**
     * The bit vector used to store the fluent that must hold over all.
     */
    private BitVector overAll;

    /**
     * Create a new timed goal description.
     */
    public TimedGoalDescription() {
        this.atStart = new BitVector();
        this.atEnd = new BitVector();
        this.overAll = new BitVector();
    }

    /**
     * Create a new time goal description from on other. This constructor make a deep copy of the timed goal
     * description in parameter.
     *
     * @param other the fluent goal description to copy.
     */
    public TimedGoalDescription(TimedGoalDescription other) {
        this();
        this.atStart.or(other.getAtStartFluents());
        this.atEnd.or(other.getAtEndFluents());
        this.overAll.or(other.getOverAllFluents());
    }

    /**
     * Returns the fluents that must verified at start.
     *
     * @return the fluents that mus be verified at start.
     */
    public final BitVector getAtStartFluents() {
        return this.atStart;
    }

    /**
     * Sets the fluents that must be verified at start.
     *
     * @param atStart the bit vector that represents the fluents that must be verified at start.
     */
    public final void setAtStartFluents(final BitVector atStart) {
        this.atStart = atStart;
    }

    /**
     * Returns the fluents that must verified over all.
     *
     * @return the fluents that mus be verified over all.
     */
    public final BitVector getOverAllFluents() {
        return this.overAll;
    }

    /**
     * Sets the fluents that must be verified over all.
     *
     * @param overAll the bit vector that represents the fluents that must be verified over all.
     */
    public final void setOverAllFluents(final BitVector overAll) {
        this.overAll = overAll;
    }

    /**
     * Returns the fluents that must verified at end.
     *
     * @return the fluents that mus be verified at end.
     */
    public final BitVector getAtEndFluents() {
        return this.atEnd;
    }

    /**
     * Sets the fluents that must be verified at end.
     *
     * @param atEnd the bit vector that represents the fluents that must be verified at end.
     */
    public final void setAtEndFluents(final BitVector atEnd) {
        this.atEnd = atEnd;
    }

    /**
     * Returns if an object is equals to this timed goal description. An object is equal iff the object is an instance
     * of the class <code>TimedGoalDescription</code> and has the same at start, at end and over all bit vector.
     *
     * @param object the object to compared.
     * @return <code>true</code> if the object in parameter is equal to this timed goal description; <code>false</code>
     *      otherwise.
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TimedGoalDescription)) {
            return false;
        }
        TimedGoalDescription other = (TimedGoalDescription) object;
        return Objects.equals(this.getAtStartFluents(), other.getAtStartFluents())
            && Objects.equals(this.getAtEndFluents(), other.getAtEndFluents())
            && Objects.equals(this.getOverAllFluents(), other.getOverAllFluents());
    }

    /*
    * Returns if the timed goal description is empty, i.e., has no at start, at end or over all fluents. Such a timed
    * goal description is always true.
    *
    * @return <code>true</code> if timed goal description is empty; <code>false</code> otherwise.
    */
    public final boolean isEmpty() {
        return this.atStart.isEmpty() && this.atEnd.isEmpty() && this.overAll.isEmpty();
    }

    /**
     * Returns the cardinality of the timed goal description, i.e., the number of fluents true at start, at end and
     * over all in the timed goal description.
     *
     * @return the cardinality of the timed goal description
     */
    public final int cardinality() {
        return this.atStart.cardinality() + this.atEnd.cardinality() + this.overAll.cardinality();
    }

    /**
     * Returns the hascode value of this timed goal description.
     *
     * @return the hascode value of this timed goal description.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getAtStartFluents(), this.getAtEndFluents(), this.getOverAllFluents());
    }

    /**
     * Returns a string representation of this timed goal description.
     *
     * @return a string representation of this timed goal description.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("At START: ");
        str.append(this.getAtStartFluents().toString());
        str.append("\n");
        str.append("At END: ");
        str.append(this.getAtEndFluents().toString());
        str.append("\n");
        str.append("Over ALL: ");
        str.append(this.getOverAllFluents().toString());
        str.append("\n");
        return str.toString();
    }
}
