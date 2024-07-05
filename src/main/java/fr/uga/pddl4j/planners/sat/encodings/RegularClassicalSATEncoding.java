package fr.uga.pddl4j.planners.sat.encodings;

import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.util.BitVector;

import java.util.ArrayList;

/**
 * A SAT encoding based on a "regular" encoding for actions and classical frame axioms
 * This encoding is based on chapter 7 of "Automated Planning: theory and practice", from Malik Ghallab, Dana Nau and Paolo Traverso, published by Morgan Kaufmann in 2004.
 */
public class RegularClassicalSATEncoding extends AbstractSATEncoding {

    /**
     * Encodes one action of the problem that may be taken at a given state (between states 0 and planLength - 1).
     * The principle is to encode ([action at state i] \implies [precondition at state i]) for all preconditions, and ([action at state i] \implies [effect at state i + 1]) for all effects.
     *
     * @param actionIndex the index of the action in the list of actions of the instantiated problem
     * @param state       the state where the action is supposed to be chosen
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
     * The encoding of these frame axioms is divided into two parts :
     * - first, for all fluents f and actions a, (f_i and a_i) \implies f_{i + 1}
     * - second, at least one action is performed : (a_1 or a_2 or ... or a_n)
     *
     * @param state the state where the axioms are considered
     */
    @Override
    public void encodeFrameAxioms(int state) {
        for (int fluentIndex = 0; fluentIndex < getProblem().getFluents().size(); fluentIndex++) {
            for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
                boolean isAnEffect = false;
                for (ConditionalEffect conditionalEffect : getProblem().getActions().get(actionIndex).getConditionalEffects()) {
                    if (conditionalEffect.getEffect().getPositiveFluents().get(fluentIndex)) {
                        isAnEffect = true;
                        break;
                    }
                    if (conditionalEffect.getEffect().getNegativeFluents().get(fluentIndex)) {
                        isAnEffect = true;
                        break;
                    }
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

        for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
            addAction(actionIndex, state, true);
        }
        endClause();
    }

    @Override
    protected boolean actionHasBeenChosen(int actionIndex, int state) {
        return isTrue(actionIndex, state);
    }

    /**
     * Encodes [action] \implies [fluent] in a single CNF clause. It is assumed that the clause is empty when called, and it will be empty again at the end of the function.
     *
     * @param actionIndex       i, so that the action is the i-th element of Problem.getActions()
     * @param fluentIndex       i, so that the fluent is the i-th element of Problem.getFluents()
     * @param actionState       the number associated with the state at which the action takes place
     * @param fluentState       the number associated with the state at which the fluent is associated
     * @param positiveFluent    whether the fluent is negated (false) or not (true)
     */
    private void encodeActionImpliesFluent(int actionIndex, int fluentIndex, int actionState, int fluentState, boolean positiveFluent) {
        addAction(actionIndex, actionState, false);
        addFluent(fluentIndex, fluentState, positiveFluent);
        endClause();
    }
}
