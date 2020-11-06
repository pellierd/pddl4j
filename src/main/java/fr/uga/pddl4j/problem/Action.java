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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements a compact representation for action of the planning problem.
 *
 * <p>Revisions:
 * <ul>
 * <li>21.10.2020: change the duration attribute to encode temporal problem.</li>
 * </ul>
 *
 * @author D. Pellier
 * @version 1.2 - 08.04.2010
 */
public class Action extends AbstractOperator {

    /**
     * The list of effects of the action.
     */
    private List<ConditionalEffect> effects;

    /**
     * The cost of the action.
     */
    private NumericVariable cost;

    /**
     * The duration of the action.
     */
    private NumericVariable duration;

    /**
     * The duration of the action.
     */
    private List<NumericConstraint> durationConstraints;

    /**
     * The list of numeric assignments of the operator.
     */
    private List<NumericAssignment> numericAssignments;

    /**
     * Creates a new action from an other. This constructor is the copy constructor.
     *
     * @param other the other action.
     */
    public Action(final Action other) {
        super(other);
        this.effects = new ArrayList<>();
        this.effects.addAll(other.getConditionalEffects().stream().map(ConditionalEffect::new)
            .collect(Collectors.toList()));
        this.numericAssignments.addAll(other.getNumericAssignments().stream().map(NumericAssignment::new)
            .collect(Collectors.toList()));
        if (this.getDurationConstraints() != null) {
            this.durationConstraints.addAll(other.getDurationConstraints().stream().map(NumericConstraint::new)
                .collect(Collectors.toList()));
        }
        this.cost = new NumericVariable(other.cost);
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
    public Action(final String name, final int arity) {
        super(name, arity);
        this.effects = new ArrayList<>();
        this.cost = new NumericVariable(-1);
        this.cost.setValue(1.0);
        this.duration = new NumericVariable(-2);
        this.duration.setValue(0.0);
        this.durationConstraints = null;
        this.numericAssignments = null;
    }

    /**
     * Creates a new action.
     *
     * @param name          the name of the action.
     * @param arity         the arity of the action.
     * @param preconditions the precondition of the action.
     * @param effects       the effects of the action.
     */
    public Action(final String name, final int arity, final State preconditions, final State effects) {
        this(name, arity);
        this.setPreconditions(preconditions);
        ConditionalEffect cexp = new ConditionalEffect();
        cexp.setCondition(new State());
        cexp.setEffects(effects);
        this.addConditionalEffect(cexp);
        this.cost = new NumericVariable(-1);
        this.cost.setValue(1.0);
        this.duration = new NumericVariable(-2);
        this.duration.setValue(0.0);
        this.durationConstraints = null;
        this.numericAssignments = null;
    }

    /**
     * Returns the effects of the action.
     *
     * @return the effects of the action.
     */
    public final List<ConditionalEffect> getConditionalEffects() {
        return this.effects;
    }

    /**
     * Returns the conditional effects to the action.
     *
     * @param effects the conditional effects of the action.
     */
    public final void setConditionalEffects(List<ConditionalEffect> effects) {
        this.effects = effects;
    }

    /**
     * Adds a conditional effect to the action.
     *
     * @param effect the conditional effect to addValue.
     */
    public final void addConditionalEffect(ConditionalEffect effect) {
        this.effects.add(effect);
    }

    /**
     * Returns <code>true</code> if this action is applicable in a specified state.
     *
     * @param state the state.
     * @return <code>true</code> if this action is applicable in a specified state;
     * <code>false</code> otherwise.
     */
    public boolean isApplicable(final ClosedWorldState state) {
        return state.satisfy(this.getPreconditions());
    }

    /**
     * Returns the unconditional effects of the action.
     *
     * @return the unconditional effects of the action.
     */
    public final State getUnconditionalEffects() {
        final State ucEffect = new State();
        this.effects.stream().filter(cEffect -> cEffect.getCondition().isEmpty()).forEach(cEffect -> {
            final State condEff = cEffect.getEffects();
            ucEffect.getPositive().or(condEff.getPositive());
            ucEffect.getNegative().or(condEff.getNegative());
        });
        return ucEffect;
    }

    /**
     * Returns if this action is durative.
     *
     * @return <code>true</code> if this action is durative or <code>false</code> otherwise.
     */
    public final boolean isDurative() {
        return this.durationConstraints != null;
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
     * Returns the cost of the action.
     *
     * @return the cost of the action.
     */
    public final NumericVariable getCost() {
        return this.cost;
    }

    /**
     * Sets the cost of the action.
     *
     * @param cost the cost to set.
     */
    public final void setCost(final NumericVariable cost) {
        this.cost = cost;
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

    /**
     * Returns the list of numeric assignments of this action.
     *
     * @return the list of numeric assignments of this action.
     */
    public final List<NumericAssignment> getNumericAssignments() {
        return this.numericAssignments;
    }

    /**
     * Sets the list of numeric assignments of this action.
     *
     * @param assignments the list of numeric assignments of this action.
     */
    public final void setNumericAssignments(List<NumericAssignment> assignments) {
        this.numericAssignments = assignments;
    }

}
