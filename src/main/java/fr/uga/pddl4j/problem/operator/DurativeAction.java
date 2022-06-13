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
import fr.uga.pddl4j.problem.numeric.NumericVariable;
import fr.uga.pddl4j.problem.time.TemporalCondition;
import fr.uga.pddl4j.problem.time.TemporalConditionalEffect;
import fr.uga.pddl4j.problem.time.TemporalEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements a compact representation for a durative action.
 *
 * @author D. Pellier
 * @version 1.0 - 03.06.2022
 */
public class DurativeAction extends AbstractDurativeOperator {

    /**
     * The list of effects of the action.
     */
    private List<TemporalConditionalEffect> effects;

    /**
     * The duration of the action.
     */
    private NumericVariable duration;

    /**
     * The duration of the action.
     */
    private List<NumericConstraint> durationConstraints;

    /**
     * Creates a new action from an other. This constructor is the copy constructor.
     *
     * @param other the other action.
     */
    public DurativeAction(final DurativeAction other) {
        super(other);
        this.effects = new ArrayList<>();
        this.effects.addAll(other.getConditionalEffects().stream().map(TemporalConditionalEffect::new)
            .collect(Collectors.toList()));
        if (this.getDurationConstraints() != null) {
            this.durationConstraints.addAll(other.getDurationConstraints().stream().map(NumericConstraint::new)
                .collect(Collectors.toList()));
        }
        if (this.duration != null) {
            this.duration = new NumericVariable(other.duration);
        }
    }

    /**
     * Creates a new action.
     *
     * @param name  the name of the action.
     * @param arity the arity of the action.
     */
    public DurativeAction(final String name, final int arity) {
        super(name, arity);
        this.effects = new ArrayList<>();
        this.duration = new NumericVariable(-2);
        this.duration.setValue(0.0);
        this.durationConstraints = null;
    }

    /**
     * Creates a new action.
     *
     * @param name          the name of the action.
     * @param arity         the arity of the action.
     * @param precondition the precondition of the action.
     * @param effect       the effects of the action.
     */
    public DurativeAction(final String name, final int arity, final TemporalCondition precondition,
            final TemporalEffect effect) {
        this(name, arity);
        this.setPrecondition(precondition);
        this.addConditionalEffect(new TemporalConditionalEffect(effect));
        this.duration = new NumericVariable(-2);
        this.duration.setValue(0.0);
        this.durationConstraints = null;
    }

    /**
     * Returns the effects of the action.
     *
     * @return the effects of the action.
     */
    public final List<TemporalConditionalEffect> getConditionalEffects() {
        return this.effects;
    }

    /**
     * Returns the conditional effects to the action.
     *
     * @param effects the conditional effects of the action.
     */
    public final void setConditionalEffects(List<TemporalConditionalEffect> effects) {
        this.effects = effects;
    }

    /**
     * Adds a conditional effect to the action.
     *
     * @param effect the conditional effect to addValue.
     */
    public final void addConditionalEffect(TemporalConditionalEffect effect) {
        this.effects.add(effect);
    }

    /**
     * Returns the unconditional effect of the action.
     *
     * @return the unconditional effect of the action.
     */
    public final TemporalEffect getUnconditionalEffect() {
        final TemporalEffect uce = new TemporalEffect();
        this.effects.stream().filter(cEffect -> cEffect.getCondition().isEmpty()).forEach(cEffect -> {
            final TemporalEffect te = cEffect.getEffect();
            uce.getAtStartEffect().getPositiveFluents().or(te.getAtStartEffect().getPositiveFluents());
            uce.getAtStartEffect().getNegativeFluents().or(te.getAtStartEffect().getNegativeFluents());
            uce.getAtStartEffect().getNumericAssignments().addAll(te.getAtStartEffect().getNumericAssignments());
            uce.getAtEndEffect().getPositiveFluents().or(te.getAtEndEffect().getPositiveFluents());
            uce.getAtEndEffect().getNegativeFluents().or(te.getAtEndEffect().getNegativeFluents());
            uce.getAtEndEffect().getNumericAssignments().addAll(te.getAtEndEffect().getNumericAssignments());
            uce.getOverallEffect().getPositiveFluents().or(te.getOverallEffect().getPositiveFluents());
            uce.getOverallEffect().getNegativeFluents().or(te.getOverallEffect().getNegativeFluents());
            uce.getOverallEffect().getNumericAssignments().addAll(te.getOverallEffect().getNumericAssignments());
        });
        return uce;
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
