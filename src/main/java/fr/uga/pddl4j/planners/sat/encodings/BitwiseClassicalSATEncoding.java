/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.  If not, see
 * <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.planners.sat.encodings;

import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.util.BitVector;

import java.util.ArrayList;
import java.util.List;

/**
 * A SAT encoding based on a "regular" encoding for actions and classical frame axioms.
 * This encoding is based on chapter 7 of "Automated Planning: theory and practice", from Malik Ghallab, Dana Nau and
 * Paolo Traverso, published by Morgan Kaufmann in 2004.
 */
public class BitwiseClassicalSATEncoding extends AbstractSATEncoding {
    private int numberBits;

    /**
     * Encodes one action of the problem that may be taken at a given state (between states <code>0</code> and
     * <code>planLength - 1</code>).
     * The principle is to encode <code>([action at state i] \implies [precondition at state i])</code> for all
     * preconditions, and <code>([action at state i] \implies [effect at state i + 1])</code> for all effects.
     *
     * @param actionIndex the index of the action in the list of actions of the instantiated problem
     * @param state       the state where the action is supposed to be chosen
     */
    @Override
    public void encodeAction(int actionIndex, int state) {
        if (state == 0 && actionIndex == 0) { //Just for initializing
            numberBits = (int) Math.ceil((Math.log(getProblem().getActions().size()) / Math.log(2)));
        }

        //Precondition
        final BitVector preconditionPositiveFluents = getProblem().getActions().get(actionIndex).getPrecondition()
            .getPositiveFluents();
        final BitVector preconditionNegativeFluents = getProblem().getActions().get(actionIndex).getPrecondition()
            .getNegativeFluents();
        for (int i = 0; i < getProblem().getFluents().size(); i++) {
            if (preconditionPositiveFluents.get(i)) {
                encodeActionImpliesFluent(actionIndex, i, state, state, true);
            }
            if (preconditionNegativeFluents.get(i)) {
                encodeActionImpliesFluent(actionIndex, i, state, state, false);
            }
        }

        //Effects
        for (ConditionalEffect conditionalEffect : getProblem().getActions().get(actionIndex).getConditionalEffects()) {
            final BitVector actionEffectPositiveFluents = conditionalEffect.getEffect().getPositiveFluents();
            final BitVector actionEffectNegativeFluents = conditionalEffect.getEffect().getNegativeFluents();
            for (int i = 0; i < getProblem().getFluents().size(); i++) {
                if (actionEffectPositiveFluents.get(i)) {
                    encodeActionImpliesFluent(actionIndex, i, state, state + 1, true);
                }
                if (actionEffectNegativeFluents.get(i)) {
                    encodeActionImpliesFluent(actionIndex, i, state, state + 1, false);
                }
            }
        }
    }

    /**
     * Encodes all axioms necessary to describe the frame of the problem (whose exact nature depends on the specific
     * encoding), at a specific state (between states <code>0</code> and <code>planLength - 1</code>).
     * The encoding of these frame axioms is : for all fluents f and actions a,
     * <code>(f_i and a_i) \implies f_{i + 1}</code>
     *
     * @param state the state where the axioms are considered
     */
    @Override
    public void encodeFrameAxioms(int state) {
        for (int fluentIndex = 0; fluentIndex < getProblem().getFluents().size(); fluentIndex++) {
            for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
                List<ConditionalEffect> conditionalEffects = getProblem().getActions().get(actionIndex)
                    .getConditionalEffects();
                boolean isAnEffect = false;
                int j = 0;
                //Determining whether or not the fluent is an effect (either positive or negative) of the action
                while (!isAnEffect && j <= conditionalEffects.size()) {
                    if (conditionalEffects.get(j).getEffect().getPositiveFluents().get(fluentIndex)
                        || conditionalEffects.get(j).getEffect().getNegativeFluents().get(fluentIndex)) {
                        isAnEffect = true;
                    }
                    j++;
                }
                if (!isAnEffect) {
                    ArrayList<Boolean> bitsEncoding = getBitwiseEncodingOfAction(actionIndex);
                    //A true fluent remains true
                    addFluent(fluentIndex, state, false);
                    for (int i = 0; i < numberBits; i++) {
                        addAction(i, state, !bitsEncoding.get(i));
                    }
                    addFluent(fluentIndex, state + 1, true);
                    endClause();

                    //A false fluent remains false
                    addFluent(fluentIndex, state, true);
                    for (int i = 0; i < numberBits; i++) {
                        addAction(i, state, !bitsEncoding.get(i));
                    }
                    addFluent(fluentIndex, state + 1, false);
                    endClause();
                }
            }
        }

        /*
            Managing sequences of bits corresponding to non-existent actions (for example, if there are 3 actions, there
            is no action with bits 1 and 1, which would correspond to the fourth action)
         */
        for (int nonexistentActionIndex = getProblem().getActions().size(); nonexistentActionIndex
            < (2 << (numberBits - 1)); nonexistentActionIndex++) {
            ArrayList<Boolean> encoding = getBitwiseEncodingOfAction(nonexistentActionIndex);
            for (int bit = 0; bit < numberBits; bit++) {
                addAction(bit, state, !encoding.get(bit));
            }
            endClause();
        }
    }

    /**
     * A method determining, by means of the results of the solver, whether or not an action has been chosen.
     * In this case, since an action is encoded using <code>numberBits</code> bits, it simply checks that all
     * corresponding bits have been assigned the value "true" by the solver.
     * @param actionIndex   the index of the action that is to be tested
     * @param state         the state at which the action is to be tested
     * @return              <code>true</code> if the action has been chosen at this specific state, else
     *                      <code>false</code>
     */
    @Override
    protected boolean actionHasBeenChosen(int actionIndex, int state) {
        ArrayList<Boolean> bitsEncoding = getBitwiseEncodingOfAction(actionIndex);
        for (int bit = 0; bit < numberBits; bit++) {
            if (!bitsEncoding.get(bit).equals(isTrue(bit, state))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Encodes <code>[action] \implies [fluent]</code> in a single CNF clause. It is assumed that the clause is empty
     * when called, and it will be empty again at the end of the function.
     *
     * @param actionIndex       <code>i</code>, so that the action is the <code>i</code>-th element of
     *                          <code>Problem.getActions()</code>
     * @param fluentIndex       <code>i</code>, so that the fluent is the <code>i</code>-th element of
     *                          <code>Problem.getFluents()</code>
     * @param actionState       the number associated with the state at which the action takes place
     * @param fluentState       the number associated with the state at which the fluent is associated
     * @param positiveFluent    whether the fluent is negated (<code>false</code>) or not (<code>true</code>)
     */
    private void encodeActionImpliesFluent(int actionIndex, int fluentIndex, int actionState, int fluentState,
                                           boolean positiveFluent) {
        ArrayList<Boolean> bitsEncoding = getBitwiseEncodingOfAction(actionIndex);
        for (int i = 0; i < numberBits; i++) {
            addAction(i, actionState, !bitsEncoding.get(i));
        }
        addFluent(fluentIndex, fluentState, positiveFluent);
        endClause();
    }

    /**
     * Gets the bitwise encoding of an action.
     * @param actionIndex   the index of the action
     * @return              the bitwise encoding of this action
     */
    private ArrayList<Boolean> getBitwiseEncodingOfAction(int actionIndex) {
        ArrayList<Boolean> encoding = new ArrayList<>();
        for (int i = 0; i < numberBits; i++) {
            encoding.add(((actionIndex >> i) % 2) == 1);
        }
        return encoding;
    }
}
