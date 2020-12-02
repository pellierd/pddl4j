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

package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLSymbol;
import fr.uga.pddl4j.problem.*;
import fr.uga.pddl4j.util.BitMatrix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * This class implements the methods needed to convert the compact encoded objects used in the
 * encoding into string representation.
 *
 * @author D. Pellier
 * @version 1.0 - 11.06.2010
 */
final class StringDecoder implements Serializable {

    /**
     * The default constructor with a private access to prevent instance creation.
     */
    private StringDecoder() {
    }

    /**
     * Returns a string representation of the specified action.
     *
     * @param action         the operator to print.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param tasks     the table of functions.
     * @return a string representation of the specified operator.
     */
    static String toString(final IntAction action, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions, final List<String> tasks) {
        final StringBuilder str = new StringBuilder();
        str.append("Action ").append(action.getName()).append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < action.arity(); i++) {
            final int index = action.getValueOfParameter(i);
            final String type = types.get(action.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i).append(" - ").append(type).append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i).append(" - ").append(type).append(" : ")
                    .append(constants.get(index)).append(" \n");
            }
        }
        if (action.isDurative()) {
            str.append("Duration:\n");
            str.append(toString(action.getDuration(), constants, types, predicates, functions, tasks));
            str.append("\nCondition:\n");
        } else {
            str.append("Preconditions:\n");
        }
        str.append(toString(action.getPreconditions(), constants, types, predicates, functions, tasks));
        str.append("\n");
        str.append("Effects:\n");
        str.append(toString(action.getEffects(), constants, types, predicates, functions, tasks));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param method       the method to print.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param tasks      the table of tasks.
     * @return a string representation of the specified method.
     */
    static String toString(final IntMethod method, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions, final List<String> tasks) {
        final StringBuilder str = new StringBuilder();
        str.append("Method ").append(method.getName()).append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < method.arity(); i++) {
            final int index = method.getValueOfParameter(i);
            final String type = types.get(method.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(constants.get(index));
                str.append(" \n");
            }
        }
        str.append("Task: ").append(toString(method.getTask(), constants, types, predicates, functions, tasks));
        str.append("\n");
        str.append("Preconditions:\n");
        str.append(toString(method.getPreconditions(), constants, types, predicates, functions, tasks));
        str.append("\n");
        str.append("Subtasks:\n");
        str.append(toString(method.getSubTasks(), constants, types, predicates, functions, tasks));
        str.append("\n");
        str.append("Ordering:\n");
        str.append(toString(method.getOrderingConstraints(), constants, types, predicates, functions, tasks));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of the specified task network.
     *
     * @param tn         the task network to print.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param tasks      the table of tasks.
     * @return a string representation of the specified method.
     */
    static String toString(final IntTaskNetwork tn, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions, final List<String> tasks) {
        final StringBuilder str = new StringBuilder();
        str.append("Parameters:\n");
        for (int i = 0; i < tn.arity(); i++) {
            final int index = tn.getValueOfParameter(i);
            final String type = types.get(tn.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(constants.get(index));
                str.append(" \n");
            }
        }
        str.append("Tasks:\n");
        str.append(toString(tn.getTasks(), constants, types, predicates, functions, tasks));
        str.append("\n");
        str.append("Ordering constraints:\n");
        str.append(toString(tn.getOrderingConstraints(), constants, types, predicates, functions, tasks));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of the specified task network.
     *
     * @param tn            the task network to print.
     * @param constants     the table of constants.
     * @param types         the table of types.
     * @param predicates    the table of predicates.
     * @param functions     the table of functions.
     * @param tasks         the table of tasks.
     * @param relevantTasks the table of relevant tasks.
     * @return a string representation of the specified method.
     */
    static String toString(final TaskNetwork tn, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions, final List<String> tasks,
                           final List<IntExpression> relevantTasks) {
        final StringBuilder str = new StringBuilder();
        str.append("Tasks:\n");
        if (tn.getTasks().isEmpty()) {
            str.append(" ()\n");
        } else {
            for (int i = 0; i < tn.getTasks().size(); i++) {
                str.append(" " + PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + i + ": ");
                str.append(StringDecoder.toString(relevantTasks.get(tn.getTasks().get(i)), constants, types, predicates,
                    functions, tasks)).append("\n");
            }
        }
        str.append("Ordering constraints:\n");
        if (tn.getOrderingConstraints().cardinality() == 0) {
            str.append(" ()");
        } else {
            BitMatrix constraints = tn.getOrderingConstraints();
            int index = 0;
            for (int r = 0; r < constraints.rows(); r++) {
                BitSet row = constraints.getRow(r);
                for (int c = row.nextSetBit(0); c >= 0; c = row.nextSetBit(c + 1)) {
                    str.append(" C").append(index).append(": ").append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + r);
                    str.append(" ");
                    str.append(PDDLConnective.LESS_ORDERING_CONSTRAINT.getImage()).append(" ");
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + c).append("\n");
                    index++;
                }
            }
        }
        return str.toString();
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp        the expression.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param tasks      the table of tasks.
     * @return a string representation of the specified expression.
     */
    static String toString(final IntExpression exp, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions, final List<String> tasks) {
        return StringDecoder.toString(exp, constants, types, predicates, functions, tasks, " ");
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp        the expression.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param tasks      the table of tasks.
     * @param separator  the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression.
     */
    static String toString(final IntExpression exp, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions, final List<String> tasks,
                           final String separator) {
        return StringDecoder.toString(exp, constants, types, predicates, functions, tasks, "", separator);
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp        the expression.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param tasks      the table of tasks.
     * @param baseOffset the offset white space from the left used for indentation.
     * @param separator  the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression node.
     */
    private static String toString(final IntExpression exp, final List<String> constants,
                                   final List<String> types, final List<String> predicates,
                                   final List<String> functions, final List<String> tasks,
                                   String baseOffset, final String separator) {
        final StringBuilder str = new StringBuilder();
        switch (exp.getConnective()) {
            case ATOM:
                str.append("(");
                str.append(predicates.get(exp.getPredicate()));
                int[] args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
                    } else {
                        str.append(" ").append(constants.get(index));
                    }
                }
                str.append(")");
                break;
            case FN_HEAD:
                str.append("(").append(functions.get(exp.getPredicate()));
                args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
                    } else {
                        str.append(" ").append(constants.get(index));
                    }
                }
                str.append(")");
                break;
            case TASK:
                str.append("(");
                if (exp.getTaskID() != IntExpression.DEFAULT_TASK_ID) {
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                    str.append(exp.getTaskID());
                    str.append(" (");
                }
                str.append(tasks.get(exp.getPredicate()));
                args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
                    } else {
                        str.append(" ").append(constants.get(index));
                    }
                }
                if (exp.getTaskID() != IntExpression.DEFAULT_TASK_ID) {
                    str.append(")");
                }
                str.append(")");
                break;
            case EQUAL_ATOM:
                str.append("(").append("=");
                args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
                    } else {
                        str.append(" ").append(constants.get(index));
                    }
                }
                str.append(")");
                break;
            case AND:
            case OR:
                String offsetOr = baseOffset + "  ";
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                if (!exp.getChildren().isEmpty()) {
                    for (int i = 0; i < exp.getChildren().size() - 1; i++) {
                        str.append(toString(exp.getChildren().get(i), constants, types, predicates,
                            functions, tasks, offsetOr)).append("\n").append(offsetOr);
                    }
                    str.append(toString(exp.getChildren().get(
                        exp.getChildren().size() - 1), constants, types, predicates, functions, tasks, offsetOr));
                }
                str.append(")");
                break;
            case FORALL:
            case EXISTS:
                str.append(" (").append(exp.getConnective().getImage());
                str.append(" (").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(-exp.getVariable() - 1);
                str.append(" - ");
                String offsetEx = baseOffset + baseOffset + "  ";
                str.append(types.get(exp.getType())).append(")\n").append(offsetEx);
                if (exp.getChildren().size() == 1) {
                    str.append(toString(exp.getChildren().get(0), constants, types, predicates,
                        functions, tasks, offsetEx));
                }
                str.append(")");
                break;
            case NUMBER:
                str.append(exp.getValue());
                break;
            case F_EXP:
                str.append(toString(exp.getChildren().get(0), constants, types, predicates,
                    functions, tasks, baseOffset));
                break;
            case F_EXP_T:
            case TRUE:
            case FALSE:
                str.append(exp.getConnective());
                break;
            case TIME_VAR:
                str.append(exp.getConnective().getImage());
                break;
            case FN_ATOM:
            case WHEN:
            case DURATION_ATOM:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                str.append(toString(exp.getChildren().get(0), constants, types, predicates,
                    functions, tasks, baseOffset));
                str.append(" ");
                str.append(toString(exp.getChildren().get(1), constants, types, predicates,
                    functions, tasks, baseOffset));
                str.append(")");
                break;
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case NOT:
            case ALWAYS:
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                str.append(toString(exp.getChildren().get(0), constants, types, predicates,
                    functions, tasks, baseOffset));
                str.append(")");
                break;
            case IS_VIOLATED:
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(")");
                break;
            case LESS_ORDERING_CONSTRAINT:
                str.append("(");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(exp.getChildren().get(0).getTaskID());
                str.append(" ");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(exp.getChildren().get(1).getTaskID());
                str.append(")");
                break;
            default:
                str.append("DEFAULT");
                break;
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a specified operator.
     *
     * @param action     the action.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param relevants  the table of relevant facts.
     * @return a string representation of the specified operator.
     */
    static String toString(final Action action, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions,
                           final List<IntExpression> relevants) {
        StringBuilder str = new StringBuilder();
        str.append("Action ").append(action.getName()).append("\n").append("Instantiations:\n");
        for (int i = 0; i < action.arity(); i++) {
            final int index = action.getValueOfParameter(i);
            final String type = types.get(action.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i).append(" - ").append(type).append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i).append(" - ").append(type).append(" : ")
                    .append(constants.get(index)).append(" \n");
            }
        }
        if (action.isDurative()) {
            str.append("Duration:");
            for (NumericConstraint constraint : action.getDurationConstraints()) {
                str.append("\n " + StringDecoder.toString(constraint));
            }
            str.append("\nCondition:\n");
        } else {
            str.append("Preconditions:\n");
        }
        str.append(StringDecoder.toString(action.getPrecondition(), constants, types,
            predicates, functions, relevants)).append("\n").append("Effects:\n");
        for (ConditionalEffect condExp : action.getConditionalEffects()) {
            str.append(StringDecoder.toString(condExp, constants, types, predicates, functions, relevants))
                .append("\n");
        }
        return str.toString();
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param method        the method to print.
     * @param constants     the table of constants.
     * @param types         the table of types.
     * @param predicates    the table of predicates.
     * @param functions     the table of functions.
     * @param tasks         the table of tasks.
     * @param relevantTasks the table of relevant tasks.
     * @return a string representation of the specified method.
     */
    static String toString(final Method method, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions, final List<String> tasks,
                           final  List<IntExpression> relevantFacts, final List<IntExpression> relevantTasks) {
        final StringBuilder str = new StringBuilder();
        str.append("Method ").append(method.getName()).append("\n").append("Instantiations:\n");
        for (int i = 0; i < method.arity(); i++) {
            final int index = method.getValueOfParameter(i);
            final String type = types.get(method.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i).append(" - ").append(type).append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i).append(" - ").append(type).append(" : ")
                    .append(constants.get(index)).append(" \n");
            }
        }
        IntExpression task = relevantTasks.get(method.getTask());
        str.append("task: ");
        str.append(StringDecoder.toString(task, constants, types, predicates, functions, tasks));
        str.append("\n");
        str.append("Preconditions:\n");
        str.append(StringDecoder.toString(method.getPrecondition(), constants, types, predicates, functions,
            relevantFacts));
        str.append("\n");
        str.append(StringDecoder.toString(method.getTaskNetwork(), constants, types, predicates, functions, tasks,
            relevantTasks));
        return str.toString();
    }

    /**
     * Returns a string representation of a state.
     *
     * @param state      the state.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param relevants  the table of relevant facts.
     * @return a string representation of the specified expression.
     */
    static String toString(Condition state, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions,
                           final List<IntExpression> relevants) {
        final StringBuilder str = new StringBuilder("(and");
        final BitSet positive = state.getPositiveFluents();
        for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
            str.append(" ").append(StringDecoder.toString(relevants.get(j), constants, types, predicates, functions,
                new ArrayList<String>())).append("\n");
        }
        final BitSet negative = state.getNegativeFluents();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append(" (not ").append(StringDecoder.toString(relevants.get(i), constants, types, predicates,
                functions, new ArrayList<String>())).append(")\n");
        }
        for (NumericConstraint constraint : state.getNumericConstraints()) {
            str.append(" " + StringDecoder.toString(constraint));
            str.append("\n");
        }

        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a state.
     *
     * @param state      the state.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param relevants  the table of relevant facts.
     * @return a string representation of the specified expression.
     */
    static String toString(InitialState state, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions,
                           final List<IntExpression> relevants, final List<IntExpression> numericFluents,
                           final List<String> tasks) {
        final StringBuilder str = new StringBuilder("(and");
        final BitSet positive = state.getPositiveFluents();
        for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
            str.append(" ").append(StringDecoder.toString(relevants.get(j), constants, types, predicates, functions,
                new ArrayList<String>())).append("\n");
        }
        final BitSet negative = state.getNegativeFluents();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append(" (not ").append(StringDecoder.toString(relevants.get(i), constants, types, predicates,
                functions, new ArrayList<String>())).append(")\n");
        }
        for (NumericVariable numeric : state.getNumericFluents()) {
            str.append(" (= ");
            IntExpression exp = numericFluents.get(numeric.getNumericFluents());
            str.append(StringDecoder.toString(exp, constants, types, predicates, functions, tasks));
            str.append(" ");
            str.append(numeric.getValue());
            str.append(")\n");
        }

        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a state.
     *
     * @param effect      the state.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param relevants  the table of relevant facts.
     * @return a string representation of the specified expression.
     */
    static String toString(Effect effect, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions,
                           final List<IntExpression> relevants) {
        final StringBuilder str = new StringBuilder("(and");
        final BitSet positive = effect.getPositiveFluents();
        for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
            str.append(" ").append(StringDecoder.toString(relevants.get(j), constants, types, predicates, functions,
                new ArrayList<String>())).append("\n");
        }
        final BitSet negative = effect.getNegativeFluents();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append(" (not ").append(StringDecoder.toString(relevants.get(i), constants, types, predicates,
                functions, new ArrayList<String>())).append(")\n");
        }
        for (NumericAssignment assignment : effect.getNumericAssignments()) {
            str.append(" " + StringDecoder.toString(assignment));
            str.append("\n");
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a bit state.
     *
     * @param bitState   the state.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param tasks      the table of tasks.
     * @param relevants  the table of relevant facts.
     * @return a string representation of the specified expression.
     */
    static String toString(State bitState, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions, final List<String> tasks,
                           final List<IntExpression> relevants) {
        final StringBuilder str = new StringBuilder("(and");
        for (int i = bitState.nextSetBit(0); i >= 0; i = bitState.nextSetBit(i + 1)) {
            str.append(" ");
            str.append(StringDecoder.toString(relevants.get(i), constants, types, predicates, functions, tasks));
            str.append("\n");
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a conditional bit expression.
     *
     * @param exp        the conditional expression.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param relevants  the table of relevant facts.
     * @return a string representation of the specified expression.
     */
    static String toString(ConditionalEffect exp, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions,
                           final List<IntExpression> relevants) {
        StringBuilder str = new StringBuilder();
        if (exp.getCondition().isEmpty()) {
            str.append(StringDecoder.toString(exp.getEffect(), constants, types, predicates, functions, relevants));
        } else {
            str.append("(when ");
            str.append(StringDecoder.toString(exp.getCondition(), constants, types, predicates, functions, relevants));
            str.append("\n").append(StringDecoder.toString(exp.getEffect(), constants, types, predicates, functions,
                relevants));
            str.append(")");
        }
        return str.toString();
    }

    /**
     * Returns a short string representation of the specified operator, i.e., its name and its
     * instantiated parameters.
     *
     * @param operator  the operator.
     * @param constants the table of constants.
     * @return a string representation of the specified operator.
     */
    static String toShortString(final AbstractGroundOperator operator, final List<String> constants) {
        final StringBuilder str = new StringBuilder();
        str.append(operator.getName());
        for (int i = 0; i < operator.arity(); i++) {
            final int index = operator.getValueOfParameter(i);
            if (index == -1) {
                str.append(" ?");
            } else {
                str.append(" ").append(constants.get(index));
            }
        }
        return str.toString();
    }

    /**
     * Returns a string representation of numeric constraints.
     *
     * @param constraint the numeric constraints.
     * @return a string representation of numeric constraints.
     */
    static String toString(final NumericConstraint constraint) {
        final StringBuilder str = new StringBuilder();
        switch (constraint.getComparator()) {
            case EQUAL:
                str.append("(= ");
                str.append(StringDecoder.toString(constraint.getLeftExpression()));
                str.append(" ");
                str.append(StringDecoder.toString(constraint.getRightExpression()));
                str.append(")");
                break;
            case LESS:
                str.append("(< ");
                str.append(StringDecoder.toString(constraint.getLeftExpression()));
                str.append(" ");
                str.append(StringDecoder.toString(constraint.getRightExpression()));
                str.append(")");
                break;
            case LESS_OR_EQUAL:
                str.append("(<= ");
                str.append(StringDecoder.toString(constraint.getLeftExpression()));
                str.append(" ");
                str.append(StringDecoder.toString(constraint.getRightExpression()));
                str.append(")");
                break;
            case GREATER:
                str.append("(> ");
                str.append(StringDecoder.toString(constraint.getLeftExpression()));
                str.append(" ");
                str.append(StringDecoder.toString(constraint.getRightExpression()));
                str.append(")");
                break;
            case GREATER_OR_EQUAL:
                str.append("(>= ");
                str.append(StringDecoder.toString(constraint.getLeftExpression()));
                str.append(" ");
                str.append(StringDecoder.toString(constraint.getRightExpression()));
                str.append(")");
                break;
        }
        return str.toString();
    }

    /**
     * Returns a string representation of an arithmetic expression.
     *
     * @param exp the arithmetic expression.
     * @return a string representation of an arithmetic expression.
     */
    static String toString(final ArithmeticExpression exp) {
        StringBuilder str = new StringBuilder();
        switch (exp.getType()) {
            case NUMBER:
                str.append(exp.getValue());
                break;
            case VARIABLE:
                str.append("(");
                if (exp.getNumericFluents() == NumericVariable.DURATION) {
                    str.append("?duration");
                } else {
                    str.append(StringDecoder.toString(Encoder.pb.getTableOfRelevantNumericFluents().get(exp.getNumericFluents()),
                        Encoder.pb.getConstantSymbols(), Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
                        Encoder.pb.getFunctionSymbols(), Encoder.pb.getTaskSymbols()));
                }
                str.append("/");
                str.append(exp.getValue());
                str.append(")");
                break;
            case OPERATOR:
                switch (exp.getArithmeticOperator()) {
                    case PLUS:
                        str.append("(+ ");
                        str.append(StringDecoder.toString(exp.getLeftExpression()));
                        str.append(" ");
                        str.append(StringDecoder.toString(exp.getRightExpression()));
                        str.append(")");
                        break;
                    case MINUS:
                        str.append("(- ");
                        str.append(StringDecoder.toString(exp.getLeftExpression()));
                        str.append(" ");
                        str.append(StringDecoder.toString(exp.getRightExpression()));
                        str.append(")");
                        break;
                    case DIV:
                        str.append("(/ ");
                        str.append(StringDecoder.toString(exp.getLeftExpression()));
                        str.append(" ");
                        str.append(StringDecoder.toString(exp.getRightExpression()));
                        str.append(")");
                        break;
                    case MUL:
                        str.append("(* ");
                        str.append(StringDecoder.toString(exp.getLeftExpression()));
                        str.append(" ");
                        str.append(StringDecoder.toString(exp.getRightExpression()));
                        str.append(")");
                        break;
                    case UMINUS:
                        str.append("(- ");
                        str.append(StringDecoder.toString(exp.getLeftExpression()));
                        str.append(")");
                        break;
                }
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a numeric assignment.
     *
     * @param assignment the numeric assignment.
     * @return a string representation of a numeric assignment.
     */
    public static String toString(final NumericAssignment assignment) {
        final StringBuilder str = new StringBuilder();
        switch (assignment.getOperator()) {
            case ASSIGN:
                str.append("(assign ");
                str.append(StringDecoder.toString(assignment.getLeftExpression()));
                str.append(" ");
                str.append(StringDecoder.toString(assignment.getRightExpression()));
                str.append(")");
                break;
            case INCREASE:
                str.append("(increase ");
                str.append(StringDecoder.toString(assignment.getLeftExpression()));
                str.append(" ");
                str.append(StringDecoder.toString(assignment.getRightExpression()));
                str.append(")");
                break;
            case DECREASE:
                str.append("(decrease ");
                str.append(StringDecoder.toString(assignment.getLeftExpression()));
                str.append(" ");
                str.append(StringDecoder.toString(assignment.getRightExpression()));
                str.append(")");
                break;
            case SCALE_UP:
                str.append("(scale-up ");
                str.append(StringDecoder.toString(assignment.getLeftExpression()));
                str.append(" ");
                str.append(StringDecoder.toString(assignment.getRightExpression()));
                str.append(")");
                break;
            case SCALE_DOWN:
                str.append("(scale-down ");
                str.append(StringDecoder.toString(assignment.getLeftExpression()));
                str.append(" ");
                str.append(StringDecoder.toString(assignment.getRightExpression()));
                str.append(")");
                break;
        }
        return str.toString();
    }

}
