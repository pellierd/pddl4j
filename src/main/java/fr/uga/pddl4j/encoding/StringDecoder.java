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
            str.append(StringDecoder.toString(action.getDuration(), constants, types, predicates, functions, tasks));
            str.append("\n");
        }
        if (action.isDurative()) {
            str.append("Condition:\n");
        } else {
            str.append("Precondition:\n");
        }
        str.append(StringDecoder.toString(action.getPreconditions(), constants, types, predicates, functions, tasks));
        str.append("\n");
        str.append("Effect:\n");
        str.append(StringDecoder.toString(action.getEffects(), constants, types, predicates, functions, tasks));
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
            case TOTAL_COST_VAR:
                str.append(exp.getConnective().getImage());
                break;
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
                           final List<IntExpression> relevants, List<IntExpression> numericFluents) {
        StringBuilder str = new StringBuilder();
        str.append("Action ");
        str.append(action.getName());
        str.append("\n");
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
        if (!action.getNumericVariables().isEmpty()) {
            str.append("Numeric variables:\n");
            for (NumericVariable var : action.getNumericVariables()) {
                str.append(numericFluents.get(var.getNumericFluents()));
                str.append(" - ");
                str.append(" number : ");
                str.append(var.getValue());
            }
        }
        if (action.isDurative()) {
            str.append("Duration: ");
            str.append(StringDecoder.toString(action.getDurationConstraints(), constants, functions, numericFluents));
            str.append("Condition:\n");
            str.append(StringDecoder.toString(action.getPreconditions(), constants, types, predicates, functions,
                relevants, numericFluents));
            str.append("\n");
        } else {
            str.append("Precondition:\n");
            str.append(StringDecoder.toString(action.getPreconditions(), constants, types, predicates, functions,
                relevants, numericFluents));
            str.append("\n");
        }
        str.append("Effect:\n");
        for (ConditionalEffect condExp : action.getConditionalEffects()) {
            str.append(StringDecoder.toString(condExp, constants, types, predicates, functions, relevants, numericFluents));
            str.append("\n");
        }
        return str.toString();
    }

    /**
     *
     */
    static String toString(final List<NumericConstraint> constraints, final List<String> constants,
            final List<String> functions, final List<IntExpression> numericFluents) {

        final StringBuilder str = new StringBuilder();
        str.append("(and ");
        if (!constraints.isEmpty()) {
            str.append(StringDecoder.toString(constraints.get(0), constants, functions, numericFluents));
            for (int i = 1; i < constraints.size(); i++) {
                str.append("\n  ");
                str.append(StringDecoder.toString(constraints.get(i), constants, functions, numericFluents));
            }
        }
        str.append(")\n");
        return str.toString();
    }

    /**
     *
     * @param constraint
     * @param constants
     * @param functions
     * @param numericFluents
     * @return
     */
    static String toString(final NumericConstraint constraint, final List<String> constants,
            final List<String> functions, final List<IntExpression> numericFluents) {

        final StringBuilder str = new StringBuilder();

        switch (constraint.getTimeSpecifier()) {
            case AT_START:
                str.append("(at start ");
                break;
            case AT_END:
                str.append("(at end ");
                break;
        }

        switch (constraint.getComparator()) {
            case EQUAL:
                str.append("(= ");
                str.append(StringDecoder.toString(constraint.getLeftExpression(), constants, functions, numericFluents));
                str.append(" ");
                str.append(StringDecoder.toString(constraint.getRightExpression(), constants, functions, numericFluents));
                str.append(")");
                break;
            case LESS:
                str.append("(< ");
                str.append(StringDecoder.toString(constraint.getLeftExpression(), constants, functions, numericFluents));
                str.append(" ");
                str.append(StringDecoder.toString(constraint.getRightExpression(), constants, functions, numericFluents));
                str.append(")");
                break;
            case LESS_OR_EQUAL:
                str.append("(<= ");
                str.append(StringDecoder.toString(constraint.getLeftExpression(), constants, functions, numericFluents));
                str.append(" ");
                str.append(StringDecoder.toString(constraint.getRightExpression(), constants, functions, numericFluents));
                str.append(")");
                break;
            case GREATER:
                str.append("(> ");
                str.append(StringDecoder.toString(constraint.getLeftExpression(), constants, functions, numericFluents));
                str.append(" ");
                str.append(StringDecoder.toString(constraint.getRightExpression(), constants, functions, numericFluents));
                str.append(")");
                break;
            case GREATER_OR_EQUAL:
                str.append("(>= ");
                str.append(StringDecoder.toString(constraint.getLeftExpression(), constants, functions, numericFluents));
                str.append(" ");
                str.append(StringDecoder.toString(constraint.getRightExpression(), constants, functions, numericFluents));
                str.append(")");
                break;
        }

        if (constraint.isDurative()) {
            str.append(")");
        }
        return str.toString();
    }

    /**
     *
     * @param exp
     * @param constants
     * @param functions
     * @param numericFluents
     * @return
     */
    static String toString(final ArithmeticExpression exp, final List<String> constants, final List<String> functions,
                           final List<IntExpression> numericFluents) {

        StringBuilder str = new StringBuilder();
        switch (exp.getType()) {
            case NUMBER:
                str.append(exp.getValue());
                break;
            case VARIABLE:
                str.append("(");
                str.append(StringDecoder.toString(numericFluents.get(exp.getNumericFluents()), constants, null, null,
                    functions, null));
                str.append("/");
                str.append(exp.getValue());
                str.append(")");
                break;
            case OPERATOR:
                switch (exp.getArithmeticOperator()) {
                    case PLUS:
                        str.append("(+ ");
                        str.append(StringDecoder.toString(exp.getLeftExpression(), constants, functions, numericFluents));
                        str.append(" ");
                        str.append(StringDecoder.toString(exp.getRightExpression(), constants, functions, numericFluents));
                        str.append(")");
                        break;
                    case MINUS:
                        str.append("(- ");
                        str.append(StringDecoder.toString(exp.getLeftExpression(), constants, functions, numericFluents));
                        str.append(" ");
                        str.append(StringDecoder.toString(exp.getRightExpression(), constants, functions, numericFluents));
                        str.append(")");
                        break;
                    case DIV:
                        str.append("(/ ");
                        str.append(StringDecoder.toString(exp.getLeftExpression(), constants, functions, numericFluents));
                        str.append(" ");
                        str.append(StringDecoder.toString(exp.getRightExpression(), constants, functions, numericFluents));
                        str.append(")");
                        break;
                    case MUL:
                        str.append("(* ");
                        str.append(StringDecoder.toString(exp.getLeftExpression(), constants, functions, numericFluents));
                        str.append(" ");
                        str.append(StringDecoder.toString(exp.getRightExpression(), constants, functions, numericFluents));
                        str.append(")");
                        break;
                    case UMINUS:
                        str.append("(- ");
                        str.append(StringDecoder.toString(exp.getLeftExpression(), constants, functions, numericFluents));
                        str.append(")");
                        break;
                }
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
                           final  List<IntExpression> fluents, final  List<IntExpression> numericFluents,
                           final List<IntExpression> relevantTasks) {
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
        str.append(StringDecoder.toString(method.getPreconditions(), constants, types, predicates, functions,
            fluents, numericFluents));
        str.append("\n");
        str.append(StringDecoder.toString(method.getTaskNetwork(), constants, types, predicates, functions, tasks,
            relevantTasks));
        return str.toString();
    }

    /**
     * Returns a string representation of a goal description.
     *
     * @param gd         the goal description.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param fluents  the table of relevant facts.
     * @param numericFluents the numeric fluents.
     * @return a string representation of the specified expression.
     */
    static String toString(GoalDescription gd, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions,
                           final List<IntExpression> fluents, final List<IntExpression> numericFluents) {
        final StringBuilder str = new StringBuilder("(and");
        if (gd.isDurative()) {
            final BitSet atStart = gd.getPositiveTimedGoalDescription().getAtStartFluents();
            for (int j = atStart.nextSetBit(0); j >= 0; j = atStart.nextSetBit(j + 1)) {
                str.append(" (at start ");
                str.append(StringDecoder.toString(fluents.get(j), constants, types, predicates, functions,
                    new ArrayList<String>()));
                str.append(")\n");
            }
            final BitSet overAll = gd.getPositiveTimedGoalDescription().getOverAllFluents();
            for (int j = overAll.nextSetBit(0); j >= 0; j = overAll.nextSetBit(j + 1)) {
                str.append(" (over all ");
                str.append(StringDecoder.toString(fluents.get(j), constants, types, predicates, functions,
                    new ArrayList<String>()));
                str.append(")\n");
            }
            final BitSet atEnd = gd.getPositiveTimedGoalDescription().getAtEndFluents();
            for (int j = atEnd.nextSetBit(0); j >= 0; j = atEnd.nextSetBit(j + 1)) {
                str.append(" (at end ");
                str.append(StringDecoder.toString(fluents.get(j), constants, types, predicates, functions,
                    new ArrayList<String>()));
                str.append(")\n");
            }
            final BitSet negAtSTart = gd.getNegativeTimedGoalDescription().getAtStartFluents();
            for (int i = negAtSTart.nextSetBit(0); i >= 0; i = negAtSTart.nextSetBit(i + 1)) {
                str.append(" (at start (not ");
                str.append(StringDecoder.toString(fluents.get(i), constants, types, predicates,
                    functions, new ArrayList<String>()));
                str.append("))\n");
            }
            final BitSet negOverAll = gd.getNegativeTimedGoalDescription().getOverAllFluents();
            for (int i = negOverAll.nextSetBit(0); i >= 0; i = negOverAll.nextSetBit(i + 1)) {
                str.append(" (over all (not ");
                str.append(StringDecoder.toString(fluents.get(i), constants, types, predicates,
                    functions, new ArrayList<String>()));
                str.append("))\n");
            }
            final BitSet negAtEnd = gd.getNegativeTimedGoalDescription().getAtEndFluents();
            for (int i = negOverAll.nextSetBit(0); i >= 0; i = negAtEnd.nextSetBit(i + 1)) {
                str.append(" (at end (not ");
                str.append(StringDecoder.toString(fluents.get(i), constants, types, predicates,
                    functions, new ArrayList<String>()));
                str.append("))\n");
            }
        } else {
            final BitSet positive = gd.getPositiveFluents();
            for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
                str.append(" ");
                str.append(StringDecoder.toString(fluents.get(j), constants, types, predicates, functions,
                    new ArrayList<String>()));
                str.append("\n");
            }
            final BitSet negative = gd.getNegativeFluents();
            for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
                str.append(" (not ");
                str.append(StringDecoder.toString(fluents.get(i), constants, types, predicates,
                    functions, new ArrayList<String>()));
                str.append(")\n");
            }
        }

        for (NumericConstraint constraint : gd.getNumericConstraints()) {
            str.append(" ");
            str.append(StringDecoder.toString(constraint, constants, functions, numericFluents));
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
    static String toString(ClosedWorldState bitState, final List<String> constants, final List<String> types,
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
     * @param fluents  the table of relevant facts.
     * @param numericFluents the table of numeric fluents
     * @return a string representation of the specified expression.
     */
    static String toString(ConditionalEffect exp, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions,
                           final List<IntExpression> fluents, final List<IntExpression> numericFluents) {
        StringBuilder str = new StringBuilder();
        if (exp.getCondition().isEmpty()) {
            str.append(StringDecoder.toString(exp.getEffects(), constants, types, predicates, functions, fluents, numericFluents));
        } else {
            str.append("(when ");
            str.append(StringDecoder.toString(exp.getCondition(), constants, types, predicates, functions, fluents, numericFluents));
            str.append("\n");
            str.append(StringDecoder.toString(exp.getEffects(), constants, types, predicates, functions,
                fluents, numericFluents));
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

}
