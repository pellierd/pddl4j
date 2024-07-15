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

import java.util.List;

/**
 * A SAT encoding based on a "regular" encoding for actions and classical frame axioms.
 * This encoding is based on chapter 7 of "Automated Planning: theory and practice", from Malik Ghallab, Dana Nau and
 * Paolo Traverso, published by Morgan Kaufmann in 2004.
 */
public class RegularClassicalSATEncoding extends AbstractSATEncoding {

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
     * The encoding of these frame axioms is divided into two parts :
     * - first, for all fluents f and actions a, <code>(f_i and a_i) \implies f_{i + 1}</code>
     * - second, at least one action is performed : <code>(a_1 or a_2 or ... or a_n)</code>
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
                int i = 0;
                //Determining whether or not the fluent is an effect (either positive or negative) of the action
                while (!isAnEffect && i <= conditionalEffects.size()) {
                    if (conditionalEffects.get(i).getEffect().getPositiveFluents().get(fluentIndex)
                        || conditionalEffects.get(i).getEffect().getNegativeFluents().get(fluentIndex)) {
                        isAnEffect = true;
                    }
                    i++;
                }
                if (!isAnEffect) {
                    //A true fluent remains true
                    addFluent(fluentIndex, state, false);
                    addAction(actionIndex, state, false);
                    addFluent(fluentIndex, state + 1, true);
                    endClause();

                    //A false fluent remains false
                    addFluent(fluentIndex, state, true);
                    addAction(actionIndex, state, false);
                    addFluent(fluentIndex, state + 1, false);
                    endClause();
                }
            }
        }

        //At least one action is chosen at each state
        for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
            addAction(actionIndex, state, true);
        }
        endClause();
    }

    /**
     * A method determining, by means of the results of the solver, whether or not an action has been chosen.
     * In this case, since an action is encoded using only one variable (equal to its index), it simply checks that this
     * variable has been assigned the value "true" by the solver.
     * @param actionIndex   the index of the action that is to be tested
     * @param state         the state at which the action is to be tested
     * @return              <code>true</code> if the action has been chosen at this specific state, else
     *                      <code>false</code>
     */
    @Override
    protected boolean actionHasBeenChosen(int actionIndex, int state) {
        return isTrue(actionIndex, state);
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
        addAction(actionIndex, actionState, false);
        addFluent(fluentIndex, fluentState, positiveFluent);
        endClause();
    }
}
