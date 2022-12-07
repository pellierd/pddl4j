/*
 * Copyright (c) 2022 by Damien Pellier <Damien.Pellier@imag.fr>.
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
import fr.uga.pddl4j.problem.numeric.NumericVariable;
import fr.uga.pddl4j.problem.time.TemporalCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This abstract class implements the common part of a durative operator.
 *
 * @author D. Pellier
 * @version 1.0 - 07.12.2022
 */
public abstract class AbstractDurativeOperator extends AbstractInstantiatedOperator {

    /**
     * The time condition of the operator.
     */
    private TemporalCondition precondition;

    /**
     * The duration of the action.
     */
    private NumericVariable duration;

    /**
     * The duration of the action.
     */
    private List<NumericConstraint> durationConstraints;

    /**
     * The default duration of the operator (0.0).
     */
    public static NumericVariable DEFAULT_DURATION = new NumericVariable(NumericVariable.DURATION, 0.0);

    /**
     * Creates a new operator from an other.
     *
     * @param other the other operator.
     */
    protected AbstractDurativeOperator(final AbstractDurativeOperator other) {
        super(other);
        this.precondition = other.getPrecondition();
        if (this.getDurationConstraints() != null) {
            this.durationConstraints.addAll(other.getDurationConstraints().stream().map(NumericConstraint::new)
                .collect(Collectors.toList()));
        }
        if (this.duration != null) {
            this.duration = new NumericVariable(other.duration);
        }
    }

    /**
     * Creates a new operator.
     *
     * @param name  the name of the operator.
     * @param arity the arity of the operator.
     */
    protected AbstractDurativeOperator(final String name, final int arity) {
        super(name, arity);
        this.precondition = new TemporalCondition();
        this.setDurationConstraints(new ArrayList<>());
        this.setDuration(AbstractDurativeOperator.DEFAULT_DURATION);
    }

    /**
     * Creates a new operator. The length of the parameters and the length of instantiations must be the same.
     *
     * @param name           the name of the operator.
     * @param parameters     the types of the parameters.
     * @param instantiations the values of the parameters.
     * @param preconditions  the precondition of the operator.
     */
    protected AbstractDurativeOperator(final String name, final int[] parameters, final int[] instantiations,
                               final TemporalCondition preconditions) {
        super(name, parameters, instantiations);
        this.precondition = preconditions;
        this.setDurationConstraints(new ArrayList<>());
        this.setDuration(AbstractDurativeOperator.DEFAULT_DURATION);
    }

    /**
     * Return the precondition of the operator.
     *
     * @return the precondition of the operator.
     */
    public final TemporalCondition getPrecondition() {
        return this.precondition;
    }

    /**
     * Set the precondition of the operator.
     *
     * @param precondition the precondition to set.
     */
    public final void setPrecondition(final TemporalCondition precondition) {
        this.precondition = precondition;
    }

    /**
     * Returns the duration of the action.
     *
     * @return the duration of the action.
     */
    public final List<NumericConstraint> getDurationConstraints() {
        return this.durationConstraints;
    }

    /**
     * Sets the duration of the action.
     *
     * @param constraints the duration to set.
     */
    public final void setDurationConstraints(final List<NumericConstraint> constraints) {
        this.durationConstraints = constraints;
    }

    /**
     * Returns the duration of the action.
     *
     * @return the duration of the action.
     */
    public final NumericVariable getDuration() {
        return this.duration;
    }

    /**
     * Sets the duration of the action.
     *
     * @param duration the duration to set.
     */
    public final void setDuration(final NumericVariable duration) {
        this.duration = duration;
    }
}
