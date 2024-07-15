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

import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.util.BitVector;

import java.util.ArrayList;
import java.util.List;

/**
 * An encoding based on simple operator splitting for actions and classical frame axioms.
 * This encoding is based on chapter 7 of "Automated Planning: theory and practice", from Malik Ghallab, Dana Nau
 * and Paolo Traverso, published by Morgan Kaufmann in 2004.
 * Note that this encoding has a number of clauses exponential in the number of ground actions, which makes it quickly
 * unsuitable when problems become slightly complex.
 */
public class SimpleSplittingClassicalSATEncoding extends AbstractSATEncoding {
    /**
     * The maximum parameter of a ground action.
     */
    private int maxParameter = 0;
    /**
     * The maximum number of parameters of a ground action.
     */
    private int maxNumberParameters = 0;

    /**
     * Encodes one action of the problem that may be taken at a given state (between states <code>0</code> and
     * <code>planLength - 1</code>).
     * The principle is to encode <code>([action at state i] \implies [precondition at state i])</code> for all
     * preconditions, and <code>([action at state i] \implies [effect at state i + 1])</code> for all effects.
     * However, all n-ary actions are divided into n unary propositions. For example, <code>move(r1, l1, l2, i)</code>,
     * where <code>i</code> is the state, is considered as equivalent to
     * <code>(move1(r1, i) and move2(l1, i) and move3(l2, i))</code>.
     * @param actionIndex   the index of the action in the list of actions of the instantiated problem
     * @param state         the state where the action is supposed to be chosen
     */
    @Override
    public void encodeAction(int actionIndex, int state) {
        /*
        We first need to get the "space" that we have to let for all actions. We do this only once.
         */
        if (state == 0 && actionIndex == 0) {
            for (Action a : getProblem().getActions()) {
                maxNumberParameters = Math.max(maxNumberParameters, a.getParameters().length);
                for (int i : a.getParameters()) {
                    maxParameter = Math.max(maxParameter, i);
                }
            }
        }

        //We need the index of the *actual* action, not the grounded action, since we want to reuse this
        int actionIndexInParsedProblem = getActionIndexInParsedProblem(actionIndex);

        //Precondition
        final BitVector preconditionPositiveFluents
            = getProblem().getActions().get(actionIndex).getPrecondition().getPositiveFluents();
        final BitVector preconditionNegativeFluents
            = getProblem().getActions().get(actionIndex).getPrecondition().getNegativeFluents();
        for (int i = 0; i < getProblem().getFluents().size(); i++) {
            boolean positive = preconditionPositiveFluents.get(i);
            boolean negative = preconditionNegativeFluents.get(i);
            if (positive || negative) {
                for (int parameterIndex = 0; parameterIndex < getProblem().getActions().get(actionIndex)
                    .getInstantiations().length; parameterIndex++) {
                    int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
                    addAction(getActionAsUnary(actionIndexInParsedProblem, parameter, parameterIndex), state,
                        false);
                }
                if (positive) {
                    addFluent(i, state, true);
                }
                if (negative) {
                    addFluent(i, state, false);
                }
                endClause();
            }
        }

        //Effects
        for (ConditionalEffect conditionalEffect : getProblem().getActions().get(actionIndex).getConditionalEffects()) {
            final BitVector actionEffectPositiveFluents = conditionalEffect.getEffect().getPositiveFluents();
            final BitVector actionEffectNegativeFluents = conditionalEffect.getEffect().getNegativeFluents();
            for (int i = 0; i < getProblem().getFluents().size(); i++) {
                boolean positive = actionEffectPositiveFluents.get(i);
                boolean negative = actionEffectNegativeFluents.get(i);
                if (positive || negative) {
                    for (int parameterIndex = 0; parameterIndex < getProblem().getActions().get(actionIndex)
                        .getInstantiations().length; parameterIndex++) {
                        int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
                        addAction(getActionAsUnary(actionIndexInParsedProblem, parameter, parameterIndex), state,
                            false);
                    }
                    if (positive) {
                        addFluent(i, state + 1, true);
                    }
                    if (negative) {
                        addFluent(i, state + 1, false);
                    }
                    endClause();
                }
            }
        }
    }

    /**
     * Encodes all axioms necessary to describe the frame of the problem (whose exact nature depends on the specific
     * encoding), at a specific state (between states <code>0</code> and <code>planLength - 1</code>).
     * The encoding of these frame axioms is divided into two parts :
     *  - first, for all fluents f and actions a, <code>(f_i and a_i) \implies f_{i + 1}</code>
     *  - second, at least one action is performed : <code>(a_1 or a_2 or ... or a_n)</code>
     * @param state         the state where the axioms are considered
     */
    @Override
    public void encodeFrameAxioms(int state) {
        for (int fluentIndex = 0; fluentIndex < getProblem().getFluents().size(); fluentIndex++) {
            for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
                List<ConditionalEffect> conditionalEffects = getProblem().getActions().get(actionIndex)
                    .getConditionalEffects();
                boolean isAnEffect = false;
                int j = 0;
                //Determining whether or not the fluent is an effect of the action
                while (!isAnEffect && j <= conditionalEffects.size()) {
                    if (conditionalEffects.get(j).getEffect().getPositiveFluents().get(fluentIndex)
                        || conditionalEffects.get(j).getEffect().getNegativeFluents().get(fluentIndex)) {
                        isAnEffect = true;
                    }
                    j++;
                }
                if (!isAnEffect) {
                    //A true fluent remains true
                    addFluent(fluentIndex, state, false);
                    for (int parameterIndex = 0; parameterIndex < getProblem().getActions().get(actionIndex)
                        .getInstantiations().length; parameterIndex++) {
                        int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
                        addAction(getActionAsUnary(getActionIndexInParsedProblem(actionIndex), parameter,
                            parameterIndex), state, false);
                    }
                    addFluent(fluentIndex, state + 1, true);
                    endClause();

                    //A false fluent remains false
                    addFluent(fluentIndex, state, true);
                    for (int parameterIndex = 0; parameterIndex < getProblem().getActions().get(actionIndex)
                        .getInstantiations().length; parameterIndex++) {
                        int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
                        addAction(getActionAsUnary(getActionIndexInParsedProblem(actionIndex), parameter,
                            parameterIndex), state, false);
                    }
                    addFluent(fluentIndex, state + 1, false);
                    endClause();
                }
            }
        }

        /*
            Encodes the fact that there is at least one action taken at this state
            Since an action like move is in fact represented by move1, move2, ..., moven, this is not straightforward:
            a or b may be equivalent to (a1 and a2) or (b1 and b2), which has to be represented by
            (a1 or b1) and (a1 or b2) and (a2 or b1) and (a2 or b2)
         */
        ArrayList<Integer> numberParameters = new ArrayList<>();
        ArrayList<Integer> currentClause = new ArrayList<>();
        int numberClauses = 1;
        for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
            int numberParametersAction = getProblem().getActions().get(actionIndex).getInstantiations().length;
            numberParameters.add(numberParametersAction);
            currentClause.add(0);
            if (numberClauses > Integer.MAX_VALUE / numberParametersAction) {
                /*
                    In this case, there will be an overflow (and it's useless to try to go higher anyway, it will be
                    impossible to compute.
                 */
                throw new RuntimeException("Impossible to encode the problem: too big for this encoding (at state "
                    + state + "). Please try with another encoding.");
            }
            numberClauses *= numberParametersAction;
        }
        for (long i = 0; i < numberClauses; i++) {
            for (int actionIndex = 0; actionIndex < numberParameters.size(); actionIndex++) {
                int parameterIndex = currentClause.get(actionIndex);
                int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
                addAction(getActionAsUnary(getActionIndexInParsedProblem(actionIndex), parameter, parameterIndex),
                    state, true);
            }
            endClause();

            int actionIndex = numberParameters.size() - 1;
            boolean flag = false;
            while (!flag && actionIndex >= 0) {
                if (currentClause.get(actionIndex) < numberParameters.get(actionIndex) - 1) {
                    currentClause.set(actionIndex, currentClause.get(actionIndex) + 1);
                    flag = true;
                } else {
                    currentClause.set(actionIndex, 0);
                }
                actionIndex--;
            }
        }
    }

    /**
     * A method determining, by means of the results of the solver, whether or not an action has been chosen.
     * In this case, since an action is encoded using only several variables, it checks all the corresponding variables
     * have been assigned the value "true" by the solver.
     * @param actionIndex   the index of the action that is to be tested
     * @param state         the state at which the action is to be tested
     * @return              <code>true</code> if the action has been chosen at this specific state, else
     *                      <code>false</code>
     */
    @Override
    protected boolean actionHasBeenChosen(int actionIndex, int state) {
        for (int parameterIndex = 0;
             parameterIndex < getProblem().getActions().get(actionIndex).getInstantiations().length; parameterIndex++) {
            int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
            if (!isTrue(getActionAsUnary(getActionIndexInParsedProblem(actionIndex), parameter, parameterIndex),
                state)) {
                return false;
            }
        }
        return true;
    }

    /**
     * If we want to consider the action <code>move(r1, l1, l2)</code> at state <code>s</code>, encodes, if
     * <code>actionParameter = l1</code>, <code>actionParameterIndex = 1</code>, <code>actionState = s</code>,
     * <code>move1(l1, s)</code>.
     * @param actionIndex               <code>i</code>, so that the action is the <code>i</code>-th element of
     *                                  <code>Problem.getActions()</code>
     * @param actionParameter           the unique parameter of the ground action
     * @param actionParameterIndex      <code>i</code>, so that the parameter is the <code>i</code>-th element of
     *                                  <code>action.getParameters()</code>
     * @return                          the notation of the unary action
     */
    private int getActionAsUnary(int actionIndex, int actionParameter, int actionParameterIndex) {
        return (actionIndex * maxParameter + actionParameter) * maxNumberParameters + actionParameterIndex
            + getProblem().getFluents().size();
    }

    /**
     * Returns the index of the action passed as argument in the list of actions of the parsed problem.
     * @param actionIndex   the index of the action in the list of actions of the problem
     * @return              the index of the action in the list of actions of the parsed problem
     */
    private int getActionIndexInParsedProblem(int actionIndex) {
        String name = getProblem().getActions().get(actionIndex).getName();
        for (int i = 0; i < getProblem().getParsedProblem().getActions().size(); i++) {
            if (getProblem().getParsedProblem().getActions().get(i).getName().toString().equals(name)) {
                return i;
            }
        }
        throw new IllegalStateException("The action of index " + actionIndex + " does not exist in the parsed problem");
    }
}
