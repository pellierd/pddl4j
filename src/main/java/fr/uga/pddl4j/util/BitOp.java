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

package fr.uga.pddl4j.util;

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
public class BitOp extends AbstractCodedOp {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The preconditions of the operator.
     */
    private BitExp preconditions;

    /**
     * The list of effects of the operator.
     */
    private List<CondBitExp> effects;

    /**
     * Creates a new operator from an other. This constructor is the copy constructor.
     *
     * @param other the other operator.
     * @throws NullPointerException if <code>other == null</code>.
     */
    public BitOp(final BitOp other) {
        super(other);
        this.preconditions = new BitExp(other.getPreconditions());
        this.effects = new ArrayList<>();
        this.effects.addAll(other.getCondEffects().stream().map(CondBitExp::new).collect(Collectors.toList()));
    }

    /**
     * Creates a new operator.
     *
     * @param name  the name of the operator.
     * @param arity the arity of the operator.
     */
    public BitOp(final String name, final int arity) {
        super(name, arity);
        this.preconditions = new BitExp();
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
    public BitOp(final String name, final int arity, final BitExp preconditions, final BitExp effects) {
        this(name, arity);
        this.setPreconditions(preconditions);
        CondBitExp cexp = new CondBitExp();
        cexp.setCondition(new BitExp());
        cexp.setEffects(effects);
        this.addCondBitEffect(cexp);
    }

    /**
     * Sets the preconditions of the operator.
     *
     * @param preconditions the preconditions to set.
     * @throws NullPointerException if <code>preconditions == null</code>.
     */
    public final void setPreconditions(final BitExp preconditions) {
        if (preconditions == null) {
            throw new NullPointerException("preconditions == null");
        }
        this.preconditions = preconditions;
    }

    /**
     * Returns the preconditions of the operator.
     *
     * @return the preconditions of the operator.
     */
    public final BitExp getPreconditions() {
        return this.preconditions;
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
    public boolean isApplicable(final BitState state) {
        if (state == null) {
            throw new NullPointerException("state == null");
        }
        return state.satisfy(this.preconditions);
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

}
