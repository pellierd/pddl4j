package fr.uga.pddl4j.planners.sat.encodings;

import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.util.BitVector;

/**
 * Default encoding for SAT problems
 * This encoding is based on chapter 7 of "Automated Planning: theory and practice", from Malik Ghallab, Dana Nau and Paolo Traverso, published by Morgan Kaufmann in 2004.
 */
public class DefaultSATEncoding extends AbstractSATEncoding {

    /**
     * Encodes one action of the problem that may be taken at a given state (between states 0 and planLength - 1).
     * The principle is to encode ([action at state i] \implies [precondition at state i]) for all preconditions, and ([action at state i] \implies [effect at state i + 1]) for all effects.
     * @param actionIndex   the index of the action in the list of actions of the instantiated problem
     * @param state         the state where the action is supposed to be chosen
     */
    @Override
    public void encodeAction(int actionIndex, int state) {
        //Precondition
        final BitVector preconditionPositiveFluents = getProblem().getActions().get(actionIndex).getPrecondition().getPositiveFluents();
        final BitVector preconditionNegativeFluents = getProblem().getActions().get(actionIndex).getPrecondition().getNegativeFluents();
        for (int i = 0; i < getProblem().getFluents().size(); i++) {
            if (preconditionPositiveFluents.get(i)) encodeActionImpliesFluent(actionIndex, i, state, state, true);
            if (preconditionNegativeFluents.get(i)) encodeActionImpliesFluent(actionIndex, i, state, state, false);
        }

        //Effects
        for (ConditionalEffect conditionalEffect : getProblem().getActions().get(actionIndex).getConditionalEffects()) {
            final BitVector actionEffectPositiveFluents = conditionalEffect.getEffect().getPositiveFluents();
            final BitVector actionEffectNegativeFluents = conditionalEffect.getEffect().getNegativeFluents();
            for (int i = 0; i < getProblem().getFluents().size(); i++) {
                if (actionEffectPositiveFluents.get(i))
                    encodeActionImpliesFluent(actionIndex, i, state, state + 1, true);
                if (actionEffectNegativeFluents.get(i))
                    encodeActionImpliesFluent(actionIndex, i, state, state + 1, false);
            }
        }
    }

    /**
     * Encodes all axioms necessary to describe the frame of the problem (whose exact nature depends on the specific encoding), at a specific state (between states 0 and planLength - 1)
     * Please see the two methods used as part of this encoding for more details.
     * @param state         the state where the axioms are considered
     */
    @Override
    public void encodeFrameAxioms(int state) {
        encodeExplanatoryFrameAxioms(state);
        encodeCompleteExclusionAxioms(state);
    }

    /**
     * Encodes the fact that "an action changes only fluents that are in its effects", that is, "if a fluent changes, then one of the actions that have that fluent in its effects has been executed". (Malik Ghallab, Dana Nau and Paolo Traverso ; see documentation of class for full reference)
     * This means that we encode    ([not fluent_i] and [fluent_{i + 1}] \implies [disjunction of actions whose positive effects contain fluent_{i + 1}])
     *                              and ([fluent_i] and [not fluent_{i + 1}] \implies [disjunction of actions whose negative effects contain fluent_{i + 1}])
     * That is, in CNF:
     *                              ([fluent_i] or [not fluent_{i + 1}] or [disjunction of actions whose positive effects contain fluent_{i + 1}])
     *                              ([not fluent_i] or [fluent_{i + 1}] or [disjunction of actions whose negative effects contain fluent_{i + 1}])
     * @param state         the state where the action is supposed to be chosen
     */
    private void encodeExplanatoryFrameAxioms(int state) {
        for (int fluentIndex = 0; fluentIndex < getProblem().getFluents().size(); fluentIndex++) {
            addFluent(fluentIndex, state, true);
            addFluent(fluentIndex, state + 1, false);
            for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
                for (ConditionalEffect conditionalEffect : getProblem().getActions().get(actionIndex).getConditionalEffects()) {
                    if (conditionalEffect.getEffect().getPositiveFluents().get(fluentIndex)) {
                        addAction(actionIndex, state, true);
                        break;
                    }
                }
            }
            endClause();

            addFluent(fluentIndex, state, false);
            addFluent(fluentIndex, state + 1, true);
            for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
                for (ConditionalEffect conditionalEffect : getProblem().getActions().get(actionIndex).getConditionalEffects()) {
                    if (conditionalEffect.getEffect().getNegativeFluents().get(fluentIndex)) {
                        addAction(actionIndex, state, true);
                        break;
                    }
                }
            }
            endClause();
        }
    }

    /**
     * Encodes the fact that only one action can be chosen at the specified state, that is, for all distinct actions a and b, ([not a] or [not b]) for this state
     * @param state     the specified state
     */
    private void encodeCompleteExclusionAxioms(int state) {
        for (int actionIndex1 = 0; actionIndex1 < getProblem().getActions().size(); actionIndex1++) {
            for (int actionIndex2 = actionIndex1 + 1; actionIndex2 < getProblem().getActions().size(); actionIndex2++) {
                addAction(actionIndex1, state, false);
                addAction(actionIndex2, state, false);
                endClause();
            }
        }
    }

    /**
     * Encodes [action] \implies [fluent] in a single CNF clause. It is assumed that the clause is empty when called, and it will be empty again at the end of the function.
     *
     * @param actionIndex i, so that the action is the i-th element of Problem.getActions()
     * @param fluentIndex i, so that the fluent is the i-th element of Problem.getFluents()
     * @param actionState the number associated with the state at which the action takes place
     * @param fluentState the number associated with the state at which the fluent is associated
     */
    private void encodeActionImpliesFluent(int actionIndex, int fluentIndex, int actionState, int fluentState, boolean positiveFluent) {
        addAction(actionIndex, actionState, false);
        addFluent(fluentIndex, fluentState, positiveFluent);
        endClause();
    }

}
