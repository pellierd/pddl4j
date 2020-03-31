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

package fr.uga.pddl4j.operators;

import fr.uga.pddl4j.encoding.State;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * This class implements a compact representation for action based on <code>BitSet</code>
 * structure.
 *
 * @author D. Pellier
 * @version 1.1 - 08.04.2010
 */
public class Action extends AbstractBitOperator {

    /**
     * The list of effects of the operator.
     */
    private List<CondBitExp> effects;

    /**
     * The cost of the operator.
     */
    private double cost;

    /**
     * The duration of the operator.
     */
    private double duration;

    /**
     * Creates a new operator from an other. This constructor is the copy constructor.
     *
     * @param other the other operator.
     * @throws NullPointerException if <code>other == null</code>.
     */
    public Action(final Action other) {
        super(other);
        this.effects = new ArrayList<>();
        this.effects.addAll(other.getCondEffects().stream().map(CondBitExp::new).collect(Collectors.toList()));
    }

    /**
     * Creates a new operator.
     *
     * @param name  the name of the operator.
     * @param arity the arity of the operator.
     */
    public Action(final String name, final int arity) {
        super(name, arity);
        this.effects = new ArrayList<>();
    }

    /**
     * Creates a new operator.
     *
     * @param name          the name of the operator.
     * @param arity         the arity of the operator.
     * @param preconditions the precondition of the operator.
     * @param effects       the effects of the operator.
     */
    public Action(final String name, final int arity, final BitExp preconditions, final BitExp effects) {
        this(name, arity);
        this.setPreconditions(preconditions);
        CondBitExp cexp = new CondBitExp();
        cexp.setCondition(new BitExp());
        cexp.setEffects(effects);
        this.addCondBitEffect(cexp);
    }

    /**
     * Returns the effects of the operator.
     *
     * @return the effects of the operator.
     */
    public final List<CondBitExp> getCondEffects() {
        return this.effects;
    }

    /**
     * Adds a conditional effect to the operator.
     *
     * @param effect the conditional effect to add.
     */
    public final void addCondBitEffect(CondBitExp effect) {
        this.effects.add(effect);
    }

    /**
     * Returns <code>true</code> if this operators is applicable in a specified state.
     *
     * @param state the state.
     * @return <code>true</code> if this operators is applicable in a specified state;
     * <code>false</code> otherwise.
     * @throws NullPointerException if <code>state == null</code>.
     */
    public boolean isApplicable(final State state) {
        if (state == null) {
            throw new NullPointerException("state == null");
        }
        return state.satisfy(this.getPreconditions());
    }

    /**
     * Returns the unconditional effects of the operator.
     *
     * @return the unconditional effects of the operator.
     */
    public BitExp getUnconditionalEffects() {
        final BitExp ucEffect = new BitExp();
        this.effects.stream().filter(cEffect -> cEffect.getCondition().isEmpty()).forEach(cEffect -> {
            final BitExp condEff = cEffect.getEffects();
            ucEffect.getPositive().or(condEff.getPositive());
            ucEffect.getNegative().or(condEff.getNegative());
        });
        return ucEffect;
    }

    /**
     * Returns the duration of the operator.
     *
     * @return the duration of the operator.
     */
    public final double getDuration() {
        return this.duration;
    }

    /**
     * Sets the duration of the operator.
     *
     * @param duration the duration to set.
     */
    public final void setDuration(final double duration) {
        this.duration = duration;
    }

    /**
     * Returns the cost of the operator.
     *
     * @return the cost of the operator.
     */
    public final double getCost() {
        return this.cost;
    }

    /**
     * Sets the cost of the operator.
     *
     * @param cost the cost to set.
     */
    public final void setCost(double cost) {
        this.cost = cost;
    }

}
