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

import fr.uga.pddl4j.parser.Symbol;
import fr.uga.pddl4j.util.BitExp;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.CondBitExp;
import fr.uga.pddl4j.util.IntExp;

import java.io.Serializable;
import java.util.BitSet;
import java.util.List;

/**
 * This class implements the methods needed to convert the compact encoded objects used in the
 * encoding into string representation.
 *
 * @author D. Pellier
 * @version 1.0 - 11.06.2010
 */
final class StringEncoder implements Serializable {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default constructor with a private access to prevent instance creation.
     */
    private StringEncoder() {
    }

    /**
     * Returns a string representation of the specified operator.
     *
     * @param op         the operator to print.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @return a string representation of the specified operator.
     */
    static String toString(final IntOp op, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions) {
        final StringBuilder str = new StringBuilder();
        str.append("Op ").append(op.getName()).append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < op.getArity(); i++) {
            final int index = op.getValueOfParameter(i);
            final String type = types.get(op.getTypeOfParameters(i));
            if (index == -1) {
                str.append(Symbol.DEFAULT_VARIABLE_SYMBOL).append(i).append(" - ").append(type).append(" : ? \n");
            } else {
                str.append(Symbol.DEFAULT_VARIABLE_SYMBOL).append(i).append(" - ").append(type).append(" : ")
                    .append(constants.get(index)).append(" \n");
            }
        }
        str.append("Preconditions:\n").append(toString(op.getPreconditions(), constants, types, predicates, functions))
            .append("\n")
            .append("Effects:\n")
            .append(toString(op.getEffects(), constants, types, predicates, functions))
            .append("\n");
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
     * @return a string representation of the specified expression.
     */
    static String toString(final IntExp exp, final List<String> constants,
                           final List<String> types, final List<String> predicates, final List<String> functions) {
        return StringEncoder.toString(exp, constants, types, predicates, functions, " ");
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp        the expression.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param separator  the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression.
     */
    static String toString(final IntExp exp, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions, final String separator) {
        return StringEncoder.toString(exp, constants, types, predicates, functions, "", separator);
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp        the expression.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param baseOffset the offset white space from the left used for indentation.
     * @param separator  the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression node.
     */
    private static String toString(final IntExp exp, final List<String> constants,
                                   final List<String> types, final List<String> predicates,
                                   final List<String> functions, String baseOffset, final String separator) {
        final StringBuilder str = new StringBuilder();
        switch (exp.getConnective()) {
            case ATOM:
                str.append("(");
                str.append(predicates.get(exp.getPredicate()));
                int[] args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ").append(Symbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
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
                        str.append(" ").append(Symbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
                    } else {
                        str.append(" ").append(constants.get(index));
                    }
                }
                str.append(")");
                break;
            case EQUAL_ATOM:
                str.append("(").append("=");
                args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ").append(Symbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
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
                        str.append(StringEncoder.toString(exp.getChildren().get(i), constants, types, predicates,
                            functions, offsetOr)).append("\n").append(offsetOr);
                    }
                    str.append(StringEncoder.toString(exp.getChildren().get(
                        exp.getChildren().size() - 1), constants, types, predicates, functions, offsetOr));
                }
                str.append(")");
                break;
            case FORALL:
            case EXISTS:
                String offsetEx = baseOffset + baseOffset + "  ";
                str.append(" (").append(exp.getConnective().getImage())
                    .append(" (").append(Symbol.DEFAULT_VARIABLE_SYMBOL).append(-exp.getVariable() - 1).append(" - ")
                    .append(types.get(exp.getType())).append(")\n").append(offsetEx);
                if (exp.getChildren().size() == 1) {
                    str.append(StringEncoder.toString(exp.getChildren().get(0), constants, types, predicates,
                        functions, offsetEx));
                }
                str.append(")");
                break;
            case NUMBER:
                str.append(exp.getValue());
                break;
            case F_EXP:
                str.append(StringEncoder.toString(exp.getChildren().get(0), constants, types, predicates,
                    functions, baseOffset));
                break;
            case F_EXP_T:
            case TRUE:
            case FALSE:
                str.append(exp.getConnective());
                break;
            case TIME_VAR:
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
                str.append(StringEncoder.toString(exp.getChildren().get(0), constants, types, predicates,
                    functions, baseOffset));
                str.append(" ");
                str.append(StringEncoder.toString(exp.getChildren().get(1), constants, types, predicates,
                    functions, baseOffset));
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
                str.append(StringEncoder.toString(exp.getChildren().get(0), constants, types, predicates,
                    functions, baseOffset));
                str.append(")");
                break;
            case IS_VIOLATED:
                str.append("(");
                str.append(exp.getConnective().getImage());
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
     * @param op         the operator.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param relevants  the table of relevant facts.
     * @return a string representation of the specified operator.
     */
    static String toString(final BitOp op, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions, final List<IntExp> relevants) {
        StringBuilder str = new StringBuilder();
        str.append("Op ").append(op.getName()).append("\n").append("Instantiations:\n");
        for (int i = 0; i < op.getArity(); i++) {
            final int index = op.getValueOfParameter(i);
            final String type = types.get(op.getTypeOfParameters(i));
            if (index == -1) {
                str.append(Symbol.DEFAULT_VARIABLE_SYMBOL).append(i).append(" - ").append(type).append(" : ? \n");
            } else {
                str.append(Symbol.DEFAULT_VARIABLE_SYMBOL).append(i).append(" - ").append(type).append(" : ")
                    .append(constants.get(index)).append(" \n");
            }
        }
        str.append("Preconditions:\n").append(StringEncoder.toString(op.getPreconditions(), constants, types,
            predicates, functions, relevants)).append("\n").append("Effects:\n");
        for (CondBitExp condExp : op.getCondEffects()) {
            str.append(StringEncoder.toString(condExp, constants, types, predicates, functions, relevants))
                .append("\n");
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a bit expression.
     *
     * @param exp        the expression.
     * @param constants  the table of constants.
     * @param types      the table of types.
     * @param predicates the table of predicates.
     * @param functions  the table of functions.
     * @param relevants  the table of relevant facts.
     * @return a string representation of the specified expression.
     */
    static String toString(BitExp exp, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions,
                           final List<IntExp> relevants) {
        final StringBuilder str = new StringBuilder("(and");
        final BitSet positive = exp.getPositive();
        for (int i = positive.nextSetBit(0); i >= 0; i = positive.nextSetBit(i + 1)) {
            str.append(" ").append(StringEncoder.toString(relevants.get(i), constants, types, predicates, functions))
                .append("\n");
        }
        final BitSet negative = exp.getNegative();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append(" (not ").append(StringEncoder.toString(relevants.get(i), constants, types, predicates,
                functions)).append(")\n");
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
     * @param relevants  the table of relevant facts.
     * @return a string representation of the specified expression.
     */
    static String toString(BitState bitState, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions,
                           final List<IntExp> relevants) {
        final StringBuilder str = new StringBuilder("(and");
        for (int i = bitState.nextSetBit(0); i >= 0; i = bitState.nextSetBit(i + 1)) {
            str.append(" ").append(StringEncoder.toString(relevants.get(i), constants, types, predicates, functions))
                .append("\n");
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
    static String toString(CondBitExp exp, final List<String> constants, final List<String> types,
                           final List<String> predicates, final List<String> functions,
                           final List<IntExp> relevants) {
        StringBuilder str = new StringBuilder();
        if (exp.getCondition().isEmpty()) {
            str.append(StringEncoder.toString(exp.getEffects(), constants, types, predicates, functions, relevants));
        } else {
            str.append("(when ").append(StringEncoder.toString(exp.getCondition(), constants, types, predicates,
                functions, relevants)).append("\n").append(StringEncoder.toString(exp.getEffects(), constants, types,
                predicates, functions, relevants)).append(")");
        }
        return str.toString();
    }

    /**
     * Returns a short string representation of the specified operator, i.e., its name and its
     * instantiated parameters.
     *
     * @param op        the operator.
     * @param constants the table of constants.
     * @return a string representation of the specified operator.
     */
    static String toShortString(final IntOp op, final List<String> constants) {
        final StringBuilder str = new StringBuilder();
        str.append(op.getName());
        for (int i = 0; i < op.getArity(); i++) {
            final int index = op.getValueOfParameter(i);
            if (index == -1) {
                str.append(" ?");
            } else {
                str.append(" ").append(constants.get(index));
            }
        }
        return str.toString();
    }

    /**
     * Returns a short string representation of the specified operator, i.e., its name and its
     * instantiated parameters.
     *
     * @param op        the operator.
     * @param constants the table of constants.
     * @return a string representation of the specified operator.
     */
    static String toShortString(final BitOp op, final List<String> constants) {
        final StringBuilder str = new StringBuilder();
        str.append(op.getName());
        for (int i = 0; i < op.getArity(); i++) {
            final int index = op.getValueOfParameter(i);
            if (index == -1) {
                str.append(" ?");
            } else {
                str.append(" ").append(constants.get(index));
            }
        }
        return str.toString();
    }

}
