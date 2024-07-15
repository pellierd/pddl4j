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

package fr.uga.pddl4j.examples.sat;

import fr.uga.pddl4j.planners.sat.encodings.AbstractSATEncoding;
import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.util.BitVector;

import java.util.List;

/**
 * An example of an implementation of a SAT encoding that can be used with the PDDL4J library.
 */
public class SATEncodingExample extends AbstractSATEncoding {
    /**
     * Encodes the initial state of the problem, as a series of unary clauses containing each the status
     * (<code>true</code> or <code>false</code>) of a fluent at state <code>0</code>. All fluents are encoded.
     * The encoding of the initial state has to be done once and is persistent.
     */
    @Override
    protected void encodeInitialState() {
        final BitVector initialPositiveFluents = getProblem().getInitialState().getPositiveFluents();
        //All fluents not positive are assumed to be negative by default
        for (int fluentIndex = 0; fluentIndex < getProblem().getFluents().size(); fluentIndex++) {
            addFluent(fluentIndex, 0, initialPositiveFluents.get(fluentIndex));
            endClause();
        }
    }

    /**
     * Encodes the goal of the problem, as a series of unary clauses containing each the status (<code>true</code> or
     * <code>false</code>) of a fluent at state <code>planLength</code> (at the last state).
     * Only fluents specified in the problem are encoded.
     * The encoding of the goal is NOT persistent (it uses the ipasir function <code>assume</code>) and must therefore
     * be done again each time a satisfiability test is done (that is, each time the plan length is increased).
     * @param planLength    the current length of the plan (that is, the current exact number of actions of a
     *                      hypothetical plan)
     */
    @Override
    protected void encodeGoal(int planLength) {
        final BitVector finalPositiveFluents = getProblem().getGoal().getPositiveFluents();
        final BitVector finalNegativeFluents = getProblem().getGoal().getNegativeFluents();
        //Here, we care only about fluents that are explicitly specified
        for (int i = 0; i < getProblem().getFluents().size(); i++) {
            if (finalPositiveFluents.get(i)) {
                assumeFluent(i, planLength, true);
            }
            if (finalNegativeFluents.get(i)) {
                assumeFluent(i, planLength, false);
            }
        }
    }

    /**
     * Encodes one action of the problem that may be taken at a given state (between states <code>0</code> and
     * <code>planLength - 1</code>).
     * The principle is to encode <code>([action at state i] \implies [precondition at state i])</code> for all
     * preconditions, and <code>([action at state i] \implies [effect at state i + 1])</code> for all effects.
     * @param actionIndex   the index of the action in the list of actions of the instantiated problem
     * @param state         the state where the action is supposed to be chosen
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
     * Please see the two methods used as part of this encoding for more details.
     * @param state         the state where the axioms are considered
     */
    @Override
    public void encodeFrameAxioms(int state) {
        encodeExplanatoryFrameAxioms(state);
        encodeCompleteExclusionAxioms(state);
    }

    /**
     * Encodes the fact that "an action changes only fluents that are in its effects", that is, "if a fluent changes,
     * then one of the actions that have that fluent in its effects has been executed". (Malik Ghallab, Dana Nau and
     * Paolo Traverso ; see documentation of class for full reference).
     * This means that we encode    <code>([not fluent_i] and [fluent_{i + 1}] \implies [disjunction of actions whose
     *                              positive effects contain fluent_{i + 1}])
     *                              and ([fluent_i] and [not fluent_{i + 1}] \implies [disjunction of actions whose
     *                              negative effects contain fluent_{i + 1}])</code>
     * That is, in CNF:
     *                              <code>([fluent_i] or [not fluent_{i + 1}] or [disjunction of actions whose positive
     *                              effects contain fluent_{i + 1}])
     *                              ([not fluent_i] or [fluent_{i + 1}] or [disjunction of actions whose negative
     *                              effects contain fluent_{i + 1}])</code>
     * @param state         the state where the action is supposed to be chosen
     */
    private void encodeExplanatoryFrameAxioms(int state) {
        for (int fluentIndex = 0; fluentIndex < getProblem().getFluents().size(); fluentIndex++) {
            addFluent(fluentIndex, state, true);
            addFluent(fluentIndex, state + 1, false);
            for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
                int i = 0;
                boolean inEffect = false;
                List<ConditionalEffect> conditionalEffects = getProblem().getActions().get(actionIndex)
                    .getConditionalEffects();
                ConditionalEffect conditionalEffect;
                //Determining whether or not the fluent is an effect
                while (!inEffect && i < conditionalEffects.size()) {
                    conditionalEffect = conditionalEffects.get(i);
                    if (!conditionalEffect.getEffect().getPositiveFluents().get(fluentIndex)) {
                        inEffect = true;
                        addAction(actionIndex, state, true);
                    }
                    i++;
                }
            }
            endClause();

            addFluent(fluentIndex, state, false);
            addFluent(fluentIndex, state + 1, true);
            for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
                int i = 0;
                boolean inEffect = false;
                List<ConditionalEffect> conditionalEffects = getProblem().getActions().get(actionIndex)
                    .getConditionalEffects();
                ConditionalEffect conditionalEffect;
                //Determining whether or not the fluent is an effect
                while (!inEffect && i < conditionalEffects.size()) {
                    conditionalEffect = conditionalEffects.get(i);
                    if (!conditionalEffect.getEffect().getNegativeFluents().get(fluentIndex)) {
                        inEffect = true;
                        addAction(actionIndex, state, true);
                    }
                    i++;
                }
            }
            endClause();
        }
    }

    /**
     * Encodes the fact that only one action can be chosen at the specified state, that is, for all distinct actions
     * <code>a</code> and <code>b</code>, <code>([not a] or [not b])</code> for this state.
     * @param state     the specified state
     */
    private void encodeCompleteExclusionAxioms(int state) {
        for (int actionIndex1 = 0; actionIndex1 < getProblem().getActions().size(); actionIndex1++) {
            for (int actionIndex2 = actionIndex1 + 1; actionIndex2 < getProblem().getActions().size(); actionIndex2++) {
                //Adds the negative of the action of index actionIndex1 to the current clause
                addAction(actionIndex1, state, false);
                addAction(actionIndex2, state, false);
                endClause();
            }
        }
    }

    /**
     * Encodes <code>[action] \implies [fluent]</code> in a single CNF clause. It is assumed that the clause is empty
     * when called, and it will be empty again at the end of the function.
     *
     * @param actionIndex <code>i</code>, so that the action is the <code>i</code>-th element of
     *                    <code>Problem.getActions()</code>
     * @param fluentIndex <code>i</code>, so that the fluent is the <code>i</code>-th element of
     *                    <code>Problem.getFluents()</code>
     * @param actionState the number associated with the state at which the action takes place
     * @param fluentState the number associated with the state at which the fluent is associated
     */
    private void encodeActionImpliesFluent(int actionIndex, int fluentIndex, int actionState, int fluentState,
                                           boolean positiveFluent) {
        addAction(actionIndex, actionState, false);
        addFluent(fluentIndex, fluentState, positiveFluent);
        endClause();
    }

    /**
     * A method determining, by means of the results of the solver, whether or not an action has been chosen.
     * In this case, since an action is encoded using only one variable (equal to its index), it simply checks that this
     * variable has been assigned the value <code>true</code> by the solver.
     * @param actionIndex   the index of the action that is to be tested
     * @param state         the state at which the action is to be tested
     * @return              <code>true</code> if the action has been chosen at this specific state, else
     *                      <code>false</code>
     */
    @Override
    protected boolean actionHasBeenChosen(int actionIndex, int state) {
        return isTrue(actionIndex, state);
    }
}
