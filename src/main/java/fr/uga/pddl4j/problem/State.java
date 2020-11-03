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

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.util.BitVector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class implements a state.
 *
 * @author D. Pellier
 * version 1.2
 */
public class State implements Serializable {

    /**
     * The positive fluents.
     */
    private BitVector positive;

    /**
     * The negative fluents.
     */
    private BitVector negative;

    /**
     * The numeric variables.
     */
    private List<NumericVariable> variables;

    /**
     * The list of positive time stamps.
     */
    private Map<Integer, Double> postiveTimeStamps;

    /**
     * The list of positive time stamps.
     */
    private Map<Integer, Double> negativeTimeStamps;

    private NumericVariable duration;

    /**
     * Creates a deep copy of this specified state in parameter.
     *
     * @param other the state to be copie
     */
    public State(final State other) {
        this.positive = new BitVector(other.getPositiveFluents());
        this.negative = new BitVector(other.getNegativeFluents());
        this.variables = new ArrayList<>();
        this.variables.addAll(other.getNumericVariables().stream().map(NumericVariable::new)
            .collect(Collectors.toList()));
        this.postiveTimeStamps = new LinkedHashMap<>(other.postiveTimeStamps);
        this.negativeTimeStamps = new LinkedHashMap<>(other.negativeTimeStamps);
        this.duration = new NumericVariable(other.duration);


    }

    /**
     * Creates a new empty state.
     */
    public State() {
        this(new BitVector(), new BitVector());
    }

    /**
     * Creates a new state with a specific positive fluents and negative ones and empty list of numeric variables.
     *
     * @param positive the positive fluents of the state.
     * @param negative the negative fluents of the state.
     */
    public State(final BitVector positive, final BitVector negative) {
        this(positive, negative, new ArrayList<>());
    }

    /**
     * Creates a new state with a specific positive fluents and negative ones and numeric variables.
     *
     * @param positive the positive fluents of the state.
     * @param negative the negative fluents of the state.
     * @param variables the numeric variables of the state.
     */
    public State(final BitVector positive, final BitVector negative, final List<NumericVariable> variables) {
        this.setPositiveFluents(positive);
        this.setNegativeFluents(negative);
        this.setNumericVariables(variables);
        this.postiveTimeStamps = new LinkedHashMap<>();
        this.negativeTimeStamps =  new LinkedHashMap<>();
    }

    /**
     * Returns the positive fluents of this state.
     *
     * @return the positive fluents of this state.
     */
    public final BitVector getPositiveFluents() {
        return this.positive;
    }

    /**
     * Sets the positive fluents of this state.
     *
     * @param positive the positive fluents of this state.
     */
    public final void setPositiveFluents(final BitVector positive) {
        this.positive = positive;
    }

    /**
     * Returns the negative fluents of this state.
     *
     * @return the negative fluents of this state.
     */
    public final BitVector getNegativeFluents() {
        return this.negative;
    }

    /**
     * Returns the positive fluents at a specified time stamp.
     *
     * @return the positive fluents at a specified time stamp.
     */
    public BitVector getPositiveFluents(final double timeStamp) {
        final BitVector positive = new BitVector(this.getPositiveFluents());
        for (Map.Entry<Integer, Double> e : this.postiveTimeStamps.entrySet()) {
            if (e.getValue() >= timeStamp) {
                positive.clear(e.getKey());
            }
        }
        return positive;
    }

    /**
     * Returns the negative fluents at a specified time stamp.
     *
     * @return the negative fluents at a specified time stamp.
     */
    public BitVector getNegativeFluents(final double timeStamp) {
        final BitVector negative = new BitVector(this.getPositiveFluents());
        for (Map.Entry<Integer, Double> e : this.negativeTimeStamps.entrySet()) {
            if (e.getValue() >= timeStamp) {
                negative.clear(e.getKey());
            }
        }
        return negative;
    }

    /**
     * Sets the negative fluents of this state.
     *
     * @param negative the negative fluents of this state.
     */
    public final void setNegativeFluents(final BitVector negative) {
        this.negative = negative;
    }

    /**
     * Returns the numeric variables of this state.
     *
     * @return the numeric variables of this state.
     */
    public final List<NumericVariable> getNumericVariables() {
        return this.variables;
    }

    /**
     * Sets the numeric variables of this states.
     *
     * @param variables the numeric variables of this states.
     */
    public final void setNumericVariables(List<NumericVariable> variables) {
        this.variables = variables;
    }

    /**
     * Sets the time stamp value of the specified positive fluent. The time stamp indicates at which time stamp the
     * fluent become true.
     *
     * @param fluent the fluent.
     * @param timeStamp the timeStamp.
     */
    public void setPositiveFluentTimeStamp(final int fluent, final double timeStamp) {
        this.postiveTimeStamps.put(fluent, timeStamp);
    }

    /**
     * Sets the time stamp value of the specified negative fluent. The time stamp indicates at which time stamp the
     * fluent become true.
     *
     * @param fluent the fluent.
     * @param timeStamp the timeStamp.
     */
    public void setNegativeFluentTimeStamp(final int fluent, final double timeStamp) {
        this.negativeTimeStamps.put(fluent, timeStamp);
    }


    /**
     *
     */
    public final void setDuration(Double duration) {
        this.duration.setValue(duration);
    }

    /**
     *
     */
    public final double getDuration() {
        return this.duration.getValue();
    }

    /**
     * Applies a specified action to this state. In other word, the positive facts of
     * the specified state are added to this state and the negative ones are delete.
     *
     * @param action the action to apply.
     */
    public final void apply(final Action action) {

    }

    /**
     * Applies a list of conditional effects to this state.
     *
     * @param effects the list of conditional effects to apply.
     */
    private final void apply(final List<ConditionalEffect> effects) {
        effects.stream().forEach(ce -> this.apply(ce.getEffect()));
    }

    /**
     * Applies a conditional effects to this state. In other word, the positive fluent of the specified effects are
     * added to this state and the negative ones are delete. The state is modified if and only if the condition of the
     * conditional effects hold in the state, otherwise the state stay unchanged.
     *
     * @param effects the expression to apply.
     */
    private final void apply(final ConditionalEffect effects) {
        if (this.satisfy(effects.getCondition())) {
            this.apply(effects.getEffect());
        }
    }

    /**
     * Applies a specified action to this state. In other word, the positive facts of
     * the specified state are added to this state and the negative ones are delete.
     *
     * @param effect the state to apply.
     */
    private final void apply(final Effect effect) {
        this.andNot(effect.getNegativeFluents());
        this.or(effect.getPositiveFluents());
    }

    /**
     * Returns <code>true</code> if this state satisfy a specified expression.
     *
     * @param state the state to be tested.
     * @return <code>true</code> if this state satisfy a specified state; <code>false</code> otherwise.
     */
    private final boolean satisfy(final Precondition precondition, double timeStamp) {
        final BitVector positive = this.getPositiveFluent(timeStamp);
        final BitVector negative = this.getNegativeFluent(timeStamp);
        return positive.include(precondition.getPositiveTimedGoalDescription().getAtStartFluents())
            && positive.include(precondition.getPositiveTimedGoalDescription().getOverAllFluents())
            && negative.include(precondition.getNegativeTimedGoalDescription().getAtStartFluents())
            && negative.include(precondition.getNegativeTimedGoalDescription().getOverAllFluents());


    }


    /**
     * Returns <code>true</code> if this state satisfy a specified expression.
     *
     * @param state the state to be tested.
     * @return <code>true</code> if this state satisfy a specified state; <code>false</code> otherwise.
     */
    private final State apply(final Action action) {
        final BitVector positive = this.getPositiveFluents(this.getDuration());
        final BitVector negative = this.getNegativeFluents(this.getDuration());
        if (positive.include(action.getPreconditions().getPositiveTimedGoalDescription().getAtStartFluents())
            && positive.include(action.getPreconditions().getPositiveTimedGoalDescription().getOverAllFluents())
            && negative.include(action.getPreconditions().getNegativeTimedGoalDescription().getAtStartFluents())
            && negative.include(action.getPreconditions().getNegativeTimedGoalDescription().getOverAllFluents())) {

            // Update the value of the numeric variables of the actions from the value of the state
            for (NumericVariable variable : action.getNumericVariables()) {
                variable.setValue(this.getNumericVariables().get(variable.getNumericFluents()).getValue());
            }
            // Check if the numeric constraints of the precondition hold in the state
            if (this.satisfy(action.getPreconditions().getNumericConstraints())) {
                State state = new State(this);
                action.getConditionalEffects();


            }






        }
        return false;


    }

    /**
     *
     */
    private boolean satisfy(List<NumericConstraint> constraints) {
        boolean evaluation = true;
        Iterator<NumericConstraint> i = constraints.iterator();
        while (i.hasNext() && evaluation) {
            evaluation = i.next().evaluate();
        }
        return evaluation

    }


    /**
     * Returns if this state is equal to an other object. The object is equal to this state if the object is an instance
     * of the class <code>State</code> and has the same positive and negative fluents, the same numeric variable and for
     * each variables the same value.
     *
     * @param object the object to be compared.
     * @return <code>true</code> if the specified object is equal to this state; <code>false</code> otherwise.
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof State)) {
            return false;
        }
        final State state = (State) object;
        boolean equal = Objects.equals(this.getPositiveFluents(), state.getPositiveFluents())
            && Objects.equals(this.getNegativeFluents(), state.getNegativeFluents())
            && Objects.equals(this.getNumericVariables(), state.getNumericVariables())
            && Objects.equals(this.postiveTimeStamps, state.postiveTimeStamps)
            && Objects.equals(this.negativeTimeStamps, state.negativeTimeStamps);
        final Iterator<NumericVariable> i = this.getNumericVariables().iterator();
        final Iterator<NumericVariable> j = state.getNumericVariables().iterator();
        while (i.hasNext() & equal) {
            equal = i.next().getValue() == j.next().getValue();
        }
        return equal;
    }

    /**
     * Returns the hash code the state.
     *
     * @return the hash code the state.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getPositiveFluents().hashCode(), this.getNegativeFluents().hashCode(),
            this.getNumericVariables().hashCode(), this.postiveTimeStamps, this.negativeTimeStamps);
    }


}
