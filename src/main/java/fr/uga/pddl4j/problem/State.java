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

import fr.uga.pddl4j.problem.operator.Condition;
import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.problem.operator.Effect;
import fr.uga.pddl4j.util.BitVector;

import java.util.List;

/**
 * This class implements a logical state.
 *
 * @author D. Pellier
 * @version 1.1 - 13.04.2010
 */
public class State extends BitVector {

    /**
     * Creates a new state.
     */
    public State() {
        super();
    }

    /**
     * Creates a new state from a specified state.
     *
     * @param state the state.
     */
    public State(final Condition state) {
        this();
        this.or(state.getPositiveFluents());
        this.andNot(state.getNegativeFluents());
    }

    /**
     * Creates a new state from a specified initial state.
     *
     * @param state the state.
     */
    public State(final InitialState state) {
        this();
        this.or(state.getPositiveFluents());
        this.andNot(state.getNegativeFluents());
    }

    /**
     * Creates a new state from an other state. This constructor is the copy constructor.
     *
     * @param state the other state to copy.
     */
    public State(final State state) {
        this();
        this.or(state);
    }

    /**
     * Applies a specified state to this state. In other word, the positive facts of
     * the specified state are added to this state and the negative ones are delete.
     *
     * @param state the state to apply.
     */
    public final void apply(final Effect state) {
        this.andNot(state.getNegativeFluents());
        this.or(state.getPositiveFluents());
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
     * Applies a conditional effects to this state. In other word, the positive fluent of the specified effects are
     * added to this state and the negative ones are delete. The state is modified if and only if the condition of the
     * conditional effects hold in the state, otherwise the state stay unchanged.
     *
     * @param effects the expression to apply.
     */
    public final void apply(final ConditionalEffect effects) {
        if (this.satisfy(effects.getCondition())) {
            this.apply(effects.getEffect());
        }
    }

    /**
     * Returns <code>true</code> if this state satisfy a specified expression.
     *
     * @param state the state to be tested.
     * @return <code>true</code> if this state satisfy a specified state; <code>false</code> otherwise.
     */
    public final boolean satisfy(final Condition state) {
        return this.include(state.getPositiveFluents()) && this.exclude(state.getNegativeFluents());

    }

}
