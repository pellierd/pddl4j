package fr.uga.pddl4j.examples;

import fr.uga.pddl4j.examples.ipasir4j.IpasirSolver;
import fr.uga.pddl4j.examples.ipasir4j.Picosat;
import fr.uga.pddl4j.examples.ipasir4j.SolverTerminatedException;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.ConditionalEffect;
import fr.uga.pddl4j.util.BitVector;

public class SATEncodingIpasir {
    //TODO : tester les tests

    //If we have 30 fluents and 10 actions, the fluents will be encoding between 0 and 29, and the actions between 30 and 39
    //So, we will have actionBeginningIndex = 30
    private final int actionBeginningIndex;
    private int numberSteps;
    private final Problem problem;
    private IpasirSolver solver;

    public SATEncodingIpasir(Problem problem, int maxNumberSteps) {
        actionBeginningIndex = problem.getFluents().size();
        this.problem = problem;
        numberSteps = 0;

        while (numberSteps <= maxNumberSteps) {
            this.solver = Picosat.createSolver();
            encodeSAT();
            if (isSatisfiable()) break;
            numberSteps++;
        }
    }

    private void encodeSAT() {
        encodeInitialState();
        encodeGoal();
        encodeActions();
        encodeExplanatoryFrameAxioms();
        encodeCompleteExclusionAxioms();
    }

    public boolean isSatisfiable() {
        try {
            return solver.isSatisfiable();
        } catch (SolverTerminatedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPlan() {
        StringBuilder sb = new StringBuilder();
        sb.append("Plan:\n");
        for (int state = 0; state < numberSteps; state++) {
            for (int actionIndex = 0; actionIndex < problem.getActions().size(); actionIndex++) {
                if (solver.val(ActionDIMACSNotation(actionIndex, state, true)) > 0) {
                    Action action = problem.getActions().get(actionIndex);
                    sb.append(action.getName()).append("(");
                    for (int i = 0; i < action.arity(); i++) {
                        sb.append(problem.getParsedProblem().getConstants().get(action.getInstantiations()[i]).getValue());
                        sb.append(", ");
                    }
                    sb.setLength(sb.length() - 2);
                    sb.append(")\n");
                    break;
                }
            }
        }
        return sb.toString();
    }

    /**
     * Cantor pairing function, potentially negated, for fluents
     * @param fluentIndex   i, so that the fluent is the i-th element of Problem.getFluents()
     * @param state         the number associated with the state
     */
    private int FluentDIMACSNotation(int fluentIndex, int state, boolean positive) {
        return (positive? 1 : -1) * ((fluentIndex + state) * (fluentIndex + state + 1) / 2 + fluentIndex + 1);
    }

    /**
     * Cantor pairing function, potentially negated, for actions
     * @param actionIndex   i, so that the action is the i-th element of Problem.getActions()
     * @param state         the number associated with the state
     */
    private int ActionDIMACSNotation(int actionIndex, int state, boolean positive) {
        actionIndex += actionBeginningIndex;
        return (positive? 1 : -1) * ((actionIndex + state) * (actionIndex + state + 1) / 2 + actionIndex + 1);
    }

    private void encodeInitialState() {
        final BitVector initialPositiveFluents = problem.getInitialState().getPositiveFluents();
        //All fluents not positive are assumed to be negative by default
        for (int i = 0; i < problem.getFluents().size(); i++) {
            solver.add(FluentDIMACSNotation(i, 0, initialPositiveFluents.get(i)));
            solver.add(0);
        }
    }

    private void encodeGoal() {
        final BitVector finalPositiveFluents = problem.getGoal().getPositiveFluents();
        final BitVector finalNegativeFluents = problem.getGoal().getNegativeFluents();
        //Here, we care only about fluents that are explicitly specified
        for (int i = 0; i < problem.getFluents().size(); i++) {
            if (finalPositiveFluents.get(i)) {
                solver.add(FluentDIMACSNotation(i, numberSteps, true));
                solver.add(0);
            }
            if (finalNegativeFluents.get(i)) {
                solver.add(FluentDIMACSNotation(i, numberSteps, false));
                solver.add(0);
            }
        }
    }

    private void encodeActions() {
        //We have to differentiate the different actions that can be taken for each state (i.e. moving at step 0 is different from moving at step 1)
        for (int state = 0; state < numberSteps; state++) {
            //For each action, we want to add [action] \implies [conjunction of all preconditions] and [conjunction of all effects]
            //Since it is in CNF, we will actually add [not action] or [precondition] for all preconditions, and [not action] or [effect] for all effects
            for (int actionIndex = 0; actionIndex < problem.getActions().size(); actionIndex++) {
                //Precondition
                final BitVector preconditionPositiveFluents = problem.getActions().get(actionIndex).getPrecondition().getPositiveFluents();
                final BitVector preconditionNegativeFluents = problem.getActions().get(actionIndex).getPrecondition().getNegativeFluents();
                for (int i = 0; i < problem.getFluents().size(); i++) {
                    if (preconditionPositiveFluents.get(i)) encodeActionImpliesFluent(actionIndex, i, state, state, true);
                    if (preconditionNegativeFluents.get(i)) encodeActionImpliesFluent(actionIndex, i, state, state, false);
                }

                //Effects
                for (ConditionalEffect conditionalEffect : problem.getActions().get(actionIndex).getConditionalEffects()) {
                    final BitVector actionEffectPositiveFluents = conditionalEffect.getEffect().getPositiveFluents();
                    final BitVector actionEffectNegativeFluents = conditionalEffect.getEffect().getNegativeFluents();
                    for (int i = 0; i < problem.getFluents().size(); i++) {
                        if (actionEffectPositiveFluents.get(i)) encodeActionImpliesFluent(actionIndex, i, state, state + 1, true);
                        if (actionEffectNegativeFluents.get(i)) encodeActionImpliesFluent(actionIndex, i, state, state + 1, false);
                    }
                }
            }
        }
    }

    /**
     * Encodes [action] \implies [fluent] in a single CNF clause. It is assumed that the clause is empty when called, and it will be empty again at the end of the function.
     * @param actionIndex   i, so that the action is the i-th element of Problem.getActions()
     * @param fluentIndex   i, so that the fluent is the i-th element of Problem.getFluents()
     * @param actionState   the number associated with the state at which the action takes place
     * @param fluentState   the number associated with the state at which the fluent is associated
     */
    private void encodeActionImpliesFluent(int actionIndex, int fluentIndex, int actionState, int fluentState, boolean positiveFluent) {
        solver.add(ActionDIMACSNotation(actionIndex, actionState, false));
        solver.add(FluentDIMACSNotation(fluentIndex, fluentState, positiveFluent));
        solver.add(0);
    }

    private void encodeExplanatoryFrameAxioms() {
        for (int fluentIndex = 0; fluentIndex < problem.getFluents().size(); fluentIndex++) {
            for (int state = 0; state < numberSteps; state++) {
                //We encode ([not fluent_i] and [fluent_{i + 1}] \implies [disjunction of actions whose positive effects contain fluent_i])
                //and ([fluent_i] and [not fluent_{i + 1}] \implies [disjunction of actions whose negative effects contain fluent_i])
                //
                //That is, in CNF:
                //([fluent_i] or [not fluent_{i + 1}] or [disjunction of actions whose positive effects contain fluent_i])
                //([not fluent_i] or [fluent_{i + 1}] or [disjunction of actions whose negative effects contain fluent_i])
                solver.add(FluentDIMACSNotation(fluentIndex, state, true));
                solver.add(FluentDIMACSNotation(fluentIndex, state + 1, false));
                for (int actionIndex = 0; actionIndex < problem.getActions().size(); actionIndex++) {
                    for (ConditionalEffect conditionalEffect : problem.getActions().get(actionIndex).getConditionalEffects()) {
                        if (conditionalEffect.getEffect().getPositiveFluents().get(fluentIndex)) {
                            solver.add(ActionDIMACSNotation(actionIndex, state, true));
                            break;
                        }
                    }
                }
                solver.add(0);

                solver.add(FluentDIMACSNotation(fluentIndex, state, false));
                solver.add(FluentDIMACSNotation(fluentIndex, state + 1, true));
                for (int actionIndex = 0; actionIndex < problem.getActions().size(); actionIndex++) {
                    for (ConditionalEffect conditionalEffect : problem.getActions().get(actionIndex).getConditionalEffects()) {
                        if (conditionalEffect.getEffect().getNegativeFluents().get(fluentIndex)) {
                            solver.add(ActionDIMACSNotation(actionIndex, state, true));
                            break;
                        }
                    }
                }
                solver.add(0);
            }
        }
    }

    private void encodeCompleteExclusionAxioms() {
        for (int state = 0; state < numberSteps; state++) {
            for (int actionIndex1 = 0; actionIndex1 < problem.getActions().size(); actionIndex1++) {
                for (int actionIndex2 = actionIndex1 + 1; actionIndex2 < problem.getActions().size(); actionIndex2++) {
                    solver.add(ActionDIMACSNotation(actionIndex1, state, false));
                    solver.add(ActionDIMACSNotation(actionIndex2, state, false));
                    solver.add(0);
                }
            }
        }
    }
}
