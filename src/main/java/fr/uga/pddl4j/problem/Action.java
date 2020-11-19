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
 * @author D. Pellier
 * @version 1.1 - 08.04.2010
 */
public class Action extends AbstractOperator {

    /**
     * The list of effects of the action.
     */
    private List<ConditionalEffect> effects;

    /**
     * The cost of the action.
     */
    private double cost;

    /**
     * The duration of the action.
     */
    private double duration;

    /**
     * Creates a new action from an other. This constructor is the copy constructor.
     *
     * @param other the other action.
     */
    public Action(final Action other) {
        super(other);
        this.effects = new ArrayList<>();
        this.effects.addAll(other.getCondEffects().stream().map(ConditionalEffect::new).collect(Collectors.toList()));
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
    }

    /**
     * Creates a new action.
     *
     * @param name          the name of the action.
     * @param arity         the arity of the action.
     * @param preconditions the precondition of the action.
     * @param effects       the effects of the action.
     */
    public Action(final String name, final int arity, final Condition preconditions, final Effect effects) {
        this(name, arity);
        this.setPreconditions(preconditions);
        ConditionalEffect cexp = new ConditionalEffect();
        cexp.setCondition(new Condition());
        cexp.setEffect(effects);
        this.addCondBitEffect(cexp);
    }

    /**
     * Returns the effects of the action.
     *
     * @return the effects of the action.
     */
    public final List<ConditionalEffect> getCondEffects() {
        return this.effects;
    }

    /**
     * Adds a conditional effect to the action.
     *
     * @param effect the conditional effect to add.
     */
    public final void addCondBitEffect(ConditionalEffect effect) {
        this.effects.add(effect);
    }

    /**
     * Returns <code>true</code> if this action is applicable in a specified state.
     *
     * @param state the state.
     * @return <code>true</code> if this action is applicable in a specified state;
     * <code>false</code> otherwise.
     */
    public boolean isApplicable(final State state) {
        return state.satisfy(this.getPreconditions());
    }

    /**
     * Returns the unconditional effects of the action.
     *
     * @return the unconditional effects of the action.
     */
    public Condition getUnconditionalEffects() {
        final Condition ucEffect = new Condition();
        this.effects.stream().filter(cEffect -> cEffect.getCondition().isEmpty()).forEach(cEffect -> {
            final Effect condEff = cEffect.getEffect();
            ucEffect.getPositiveFluents().or(condEff.getPositiveFluents());
            ucEffect.getNegativeFluents().or(condEff.getNegativeFluents());
        });
        return ucEffect;
    }

    /**
     * Returns the duration of the action.
     *
     * @return the duration of the action.
     */
    public final double getDuration() {
        return this.duration;
    }

    /**
     * Sets the duration of the action.
     *
     * @param duration the duration to set.
     */
    public final void setDuration(final double duration) {
        this.duration = duration;
    }

    /**
     * Returns the cost of the action.
     *
     * @return the cost of the action.
     */
    public final double getCost() {
        return this.cost;
    }

    /**
     * Sets the cost of the action.
     *
     * @param cost the cost to set.
     */
    public final void setCost(double cost) {
        this.cost = cost;
    }

}
