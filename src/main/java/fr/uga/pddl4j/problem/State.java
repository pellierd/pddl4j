package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.util.BitVector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by pellier on 07/11/2020.
 */
public class State extends BitVector implements Serializable {

    /**
     * The numeric variables of the state.
     */
    private List<NumericVariable> variables;

    /**
     * Creates a new state from an other. This constructor creates a deep copy.
     *
     * @param other the state to copy.
     */
    public State(final State other) {
        super();
        this.or(other);
        this.variables = new ArrayList<>();
        this.variables.addAll(other.getNumericVariables().stream().map(NumericVariable::new)
            .collect(Collectors.toList()));
    }

    /**
     * Creates a new state with an empty set of numeric variables.
     */
    public State() {
        super();
        this.variables = new ArrayList<>();
    }

    /**
     * Returns the list of numeric variables of this states.
     *
     * @return  the list of numeric variables of this states.
     */
    public final List<NumericVariable> getNumericVariables () {
        return this.variables;
    }

    /**
     * Sets the list of numeric variables of this state.
     *
     * @param variables the list of numeric variables of this state.
     */
    public final void setNumericVariables(final List<NumericVariable> variables) {
        this.variables = variables;
    }

    /**
     * Applies a conditional effect to this state.
     *
     * @param effect the conditional effect to apply.
     */
    public final void apply(final ConditionalEffect effect) {
        if (this.satisfy(effect.getConditions())) {
            this.apply(effect.getEffect());
        }
    }

    /**
     * Applies a list of conditional effects to this state.
     *
     * @param effects the list of conditional effects to apply.
     */
    public final void apply(final List<ConditionalEffect> effects) {
        effects.stream().forEach(ce -> this.apply(ce.getEffect()));
    }

    /**
     * Returns <code>true</code> if this state satisfy a specified list of conditions.
     *
     * @param conditions the list to be tested.
     * @return <code>true</code> if this state satisfy a specified list of conditions; <code>false</code> otherwise.
     */
    public final boolean satisfy(final List<Condition> conditions) {
        Iterator<Condition> i = conditions.iterator();
        Boolean satisfied = true;
        while (i.hasNext() && satisfied) {
            satisfied = this.satisfy(i.next());
        }
        return satisfied;
    }

    /**
     * Applies a specified effect to this state. In other word, the positive facts of
     * the specified expression are added to this state and the negative ones are delete.
     *
     * @param effect the effect to apply.
     */
    public final void apply(final Effect effect) {
        // Update the logical parte of the state.
        this.andNot(effect.getNegativeFluents());
        this.or(effect.getPositiveFluents());
        // Update the numeric part of the state.
        for (NumericAssignment assigment : effect.getNumericAssignments()) {
            assigment.assign(this.getNumericVariables());
        }
    }


    /**
     * Returns <code>true</code> if this state satisfy a specified state.
     *
     * @param condition the state to be tested.
     * @return <code>true</code> if this state satisfy a specified state; <code>false</code> otherwise.
     */
    public final boolean satisfy(final Condition condition) {
        boolean satisfied = this.include(condition.getPositiveFluents())
            && this.exclude(condition.getNegativeFluents());
        Iterator<NumericConstraint> i = condition.getNumericConstraints().iterator();
        while (i.hasNext() && satisfied) {
            satisfied = i.next().evaluate(this.getNumericVariables());
        }
        return satisfied;
    }

    /**
     * Returns the hash code value of the state.
     *
     * @return the hash code value of the state.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getNumericVariables());
    }

    /**
     * Return if a specified object is equals to this state. The specified object is equal to
     * the state if and only if the object is an instance of the class <code>State</code>
     * and it has the same positive and negative fluents and numeric variables.
     *
     * @param obj the specified object to compared.
     * @return <code>true</code> if the specified object is equal to the state; <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof State) {
            State other = (State) obj;
            return super.equals(other) && this.getNumericVariables().equals(other.getNumericVariables());
        }
        return false;
    }


}
