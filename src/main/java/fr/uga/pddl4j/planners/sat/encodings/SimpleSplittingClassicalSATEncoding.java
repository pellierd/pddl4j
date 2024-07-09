package fr.uga.pddl4j.planners.sat.encodings;

import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.util.BitVector;

import java.util.ArrayList;

/**
 * An encoding based on simple operator splitting for actions and classical frame axioms
 * This encoding is based on chapter 7 of "Automated Planning: theory and practice", from Malik Ghallab, Dana Nau and Paolo Traverso, published by Morgan Kaufmann in 2004.
 * Note that this encoding has a number of clauses exponential in the number of ground actions, which makes it quickly unsuitable when problems become slightly complex.
 */
public class SimpleSplittingClassicalSATEncoding extends AbstractSATEncoding {
    /**
     * The maximum parameter of a ground action
     */
    private int maxParameter = 0;
    /**
     * The maximum number of parameters of a ground action
     */
    private int maxNumberParameters = 0;

    /**
     * Encodes one action of the problem that may be taken at a given state (between states 0 and planLength - 1).
     * The principle is to encode ([action at state i] \implies [precondition at state i]) for all preconditions, and ([action at state i] \implies [effect at state i + 1]) for all effects.
     * However, all n-ary actions are divided into n unary propositions. For example, move(r1, l1, l2, i), where i is the state, is considered as equivalent to (move1(r1, i) and move2(l1, i) and move3(l2, i)).
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

        int actionIndexInParsedProblem = getActionIndexInParsedProblem(actionIndex);

        //Precondition
        final BitVector preconditionPositiveFluents = getProblem().getActions().get(actionIndex).getPrecondition().getPositiveFluents();
        final BitVector preconditionNegativeFluents = getProblem().getActions().get(actionIndex).getPrecondition().getNegativeFluents();
        for (int i = 0; i < getProblem().getFluents().size(); i++) {
            boolean positive = preconditionPositiveFluents.get(i);
            boolean negative = preconditionNegativeFluents.get(i);
            if (positive || negative) {
                for (int parameterIndex = 0; parameterIndex < getProblem().getActions().get(actionIndex).getInstantiations().length; parameterIndex++) {
                    int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
                    addAction(getActionAsUnary(actionIndexInParsedProblem, parameter, parameterIndex), state, false);
                }
                if (positive) addFluent(i, state, true);
                if (negative) addFluent(i, state, false);
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
                    for (int parameterIndex = 0; parameterIndex < getProblem().getActions().get(actionIndex).getInstantiations().length; parameterIndex++) {
                        int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
                        addAction(getActionAsUnary(actionIndexInParsedProblem, parameter, parameterIndex), state, false);
                    }
                    if (positive) addFluent(i, state + 1, true);
                    if (negative) addFluent(i, state + 1, false);
                    endClause();
                }
            }
        }
    }

    /**
     * Encodes all axioms necessary to describe the frame of the problem (whose exact nature depends on the specific encoding), at a specific state (between states 0 and planLength - 1)
     * The encoding of these frame axioms is divided into two parts :
     *  - first, for all fluents f and actions a, (f_i and a_i) \implies f_{i + 1}
     *  - second, at least one action is performed : (a_1 or a_2 or ... or a_n)
     * @param state         the state where the axioms are considered
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
                    for (int parameterIndex = 0; parameterIndex < getProblem().getActions().get(actionIndex).getInstantiations().length; parameterIndex++) {
                        int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
                        addAction(getActionAsUnary(getActionIndexInParsedProblem(actionIndex), parameter, parameterIndex), state, false);
                    }
                    addFluent(fluentIndex, state + 1, true);
                    endClause();

                    //A false fluent remains false
                    addFluent(fluentIndex, state, true);
                    for (int parameterIndex = 0; parameterIndex < getProblem().getActions().get(actionIndex).getInstantiations().length; parameterIndex++) {
                        int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
                        addAction(getActionAsUnary(getActionIndexInParsedProblem(actionIndex), parameter, parameterIndex), state, false);
                    }
                    addFluent(fluentIndex, state + 1, false);
                    endClause();
                }
            }
        }

        //Since an action like move is in fact represented by move1, move2, ..., moven, this is not straightforward: a or b may be equivalent to (a1 and a2) or (b1 and b2), which has to be represented by (a1 or b1) and (a1 or b2) and (a2 or b1) and (a2 or b2)
        ArrayList<Integer> numberParameters = new ArrayList<>();
        ArrayList<Integer> currentClause = new ArrayList<>();
        int numberClauses = 1;
        for (int actionIndex = 0; actionIndex < getProblem().getActions().size(); actionIndex++) {
            int numberParametersAction = getProblem().getActions().get(actionIndex).getInstantiations().length;
            numberParameters.add(numberParametersAction);
            currentClause.add(0);
            if (numberClauses > Integer.MAX_VALUE/numberParametersAction) { //In this case, there will be an overflow (and it's useless to try to go higher anyway, it will be impossible to compute
                throw new RuntimeException("Impossible to encode the problem: too big for this encoding (at state " + state + "). Please try with another encoding.");
            }
            numberClauses *= numberParametersAction;
        }
        for (long i = 0; i < numberClauses; i++) {
            for (int actionIndex = 0; actionIndex < numberParameters.size(); actionIndex++) {
                int parameterIndex = currentClause.get(actionIndex);
                int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
                addAction(getActionAsUnary(getActionIndexInParsedProblem(actionIndex), parameter, parameterIndex), state, true);
            }
            endClause();

            for (int actionIndex = numberParameters.size() - 1; actionIndex >= 0; actionIndex--) {
                if (currentClause.get(actionIndex) < numberParameters.get(actionIndex) - 1) {
                    currentClause.set(actionIndex, currentClause.get(actionIndex) + 1);
                    break;
                }
                else {
                    currentClause.set(actionIndex, 0);
                }
            }
        }
    }

    @Override
    protected boolean actionHasBeenChosen(int actionIndex, int state) {
        for (int parameterIndex = 0; parameterIndex < getProblem().getActions().get(actionIndex).getInstantiations().length; parameterIndex++) {
            int parameter = getProblem().getActions().get(actionIndex).getInstantiations()[parameterIndex];
            if (!isTrue(getActionAsUnary(getActionIndexInParsedProblem(actionIndex), parameter, parameterIndex), state)) {
                return false;
            }
        }
        return true;
    }

    /**
     * If we want to consider the action move(r1, l1, l2) at state s, encodes, if actionParameter = l1, actionParameterIndex = 1, actionState = s, move1(l1, s)
     * @param actionIndex               i, so that the action is the i-th element of Problem.getActions()
     * @param actionParameter           the unique parameter of the ground action
     * @param actionParameterIndex      i, so that the parameter is the i-th element of action.getParameters()
     * @return                          the notation of the unary action
     */
    private int getActionAsUnary(int actionIndex, int actionParameter, int actionParameterIndex) {
        return (actionIndex*maxParameter + actionParameter)*maxNumberParameters + actionParameterIndex + getProblem().getFluents().size();
    }

    /**
     * @param actionIndex   the index of the action in the list of actions of the problem
     * @return              the index of the action in the list of actions of the parsed problem
     */
    private int getActionIndexInParsedProblem(int actionIndex) {
        String name = getProblem().getActions().get(actionIndex).getName();
        for (int i = 0; i < getProblem().getParsedProblem().getActions().size() ; i++) {
            if (getProblem().getParsedProblem().getActions().get(i).getName().toString().equals(name)) return i;
        }
        throw new IllegalStateException("The action of index " + actionIndex + " does not exist in the parsed problem");
    }
}
