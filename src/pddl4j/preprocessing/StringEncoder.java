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

package pddl4j.preprocessing;

import java.util.BitSet;
import java.util.List;

import pddl4j.parser.Symbol;
import pddl4j.util.BitExp;
import pddl4j.util.BitOp;
import pddl4j.util.CondBitExp;
import pddl4j.util.IntExp;

/**
 * This class implements the methods needed to convert the compact encoded objects used in the
 * preprocessing into string representation.
 * 
 * @author D. Pellier
 * @version 1.0 - 11.06.2010 
 */
final class StringEncoder {

	/**
	 * The default constructor with a private access to prevent instance creation.
	 */
	private StringEncoder() {
	}
	
	/**
	 * Returns a short string representation of the specified operator, i.e., its name and its
	 * instantiated parameters.
	 * 
	 * @param op the operator.
	 * @param constants the table of constants.
	 * @return a string representation of the specified operator.
	 */
	static String toShortString(final IntOp op, final List<String> constants) {
		final StringBuffer str = new StringBuffer();
		str.append(op.getName());
		for (int i = 0; i < op.getArity(); i++) {
			final int index = op.getValueOfParameter(i);
			if (index == -1) {
				str.append(" ?");
			} else {
				str.append(" " + constants.get(index));
			}
		}
		return str.toString();
	}
	
	/**
	 * Returns a string representation of the specified operator.
	 * 
	 * @param op the operator to print.
	 * @param constants the table of constants.
	 * @param types the table of types.
	 * @param predicates the table of predicates.
	 * @param functions the table of functions.
	 * @return a string representation of the specified operator.
	 */
	static String toString(final IntOp op, final List<String> constants, final List<String> types,
			final List<String> predicates, final List<String> functions) {
		final StringBuffer str = new StringBuffer();
		str.append("Op " + op.getName() + "\n");
		str.append("Instantiations:\n");
		for (int i = 0; i < op.getArity(); i++) {
			final int index = op.getValueOfParameter(i);
			final String type = types.get(op.getTypeOfParameters(i));
			if (index == -1) {
				str.append(Symbol.DEFAULT_VARIABLE_SYMBOL + i + " - " + type + " : ? \n");
			} else {
				str.append(Symbol.DEFAULT_VARIABLE_SYMBOL + i + " - " + type + " : " 
						+ constants.get(index) + " " + "\n");
			}
		}
		str.append("Preconditions:\n");
		str.append(StringEncoder.toString(op.getPreconditions(), 
				constants, types, predicates, functions) + "\n");
		str.append("Effects:\n");
		str.append(StringEncoder.toString(op.getEffects(), 
				constants, types, predicates, functions) + "\n");
		return str.toString();
	}

	/**
	 * Returns a string representation of an expression.
	 * 
	 * @param exp the expression.
	 * @param constants the table of constants.
	 * @param types the table of types.
	 * @param predicates the table of predicates.
	 * @param functions the table of functions.
	 * @return a string representation of the specified expression.
	 */
	static String toString(final IntExp exp, final List<String> constants,
			final List<String> types, final List<String> predicates, final List<String> functions) {
		return StringEncoder.toString(exp, constants, types, predicates, functions, " ");
	}

	/**
	 * Returns a string representation of an expression.
	 * 
	 * @param exp the expression.
	 * @param constants the table of constants.
	 * @param types the table of types.
	 * @param predicates the table of predicates.
	 * @param functions the table of functions.
	 * @param separator the string separator between predicate symbol and arguments.
	 * @return a string representation of the specified expression.
	 */
	static String toString(final IntExp exp, final List<String> constants,
			final List<String> types, final List<String> predicates, final List<String> functions, final String separator) {
		return StringEncoder.toString(exp, constants, types, predicates, functions, "", separator);
	}
	
	/**
	 * Returns a string representation of an expression.
	 * 
	 * @param exp the expression.
	 * @param constants the table of constants.
	 * @param types the table of types.
	 * @param predicates the table of predicates.
	 * @param functions the table of functions.
	 * @param offset the offset white space from the left used for indentation.
	 * @param separator the string separator between predicate symbol and arguments.
	 * @return a string representation of the specified expression node.
	 */
	private static String toString(final IntExp exp, final List<String> constants,
			final List<String> types, final List<String> predicates, final List<String> functions,
			String offset, final String separator) {
		final StringBuffer str = new StringBuffer();
		switch (exp.getConnective()) {
		case ATOM:
			str.append("(");
			str.append(predicates.get(exp.getPredicate()));
			int[] args = exp.getArguments();
			for (int i = 0; i < args.length; i++) {
				int index = args[i];
				if (index < 0) {
					str.append(" " + Symbol.DEFAULT_VARIABLE_SYMBOL + (-index - 1));
				} else {
					str.append(" " + constants.get(index));
				}
			}
			str.append(")");
			break;
		case FN_HEAD:
			str.append("(");
			str.append(functions.get(exp.getPredicate()));
			args = exp.getArguments();
			for (int i = 0; i < args.length; i++) {
				int index = args[i];
				if (index < 0) {
					str.append(" " + Symbol.DEFAULT_VARIABLE_SYMBOL + (-index - 1));
				} else {
					str.append(" " + constants.get(index));
				}
			}
			str.append(")");
			break;
		case EQUAL_ATOM:
			str.append("(");
			str.append("=");
			args = exp.getArguments();
			for (int i = 0; i < args.length; i++) {
				int index = args[i];
				if (index < 0) {
					str.append(" " + Symbol.DEFAULT_VARIABLE_SYMBOL + (-index - 1));
				} else {
					str.append(" " + constants.get(index));
				}
			}
			str.append(")");
			break;
		case AND:
		case OR:
			offset += "  ";
			str.append("(");
			str.append(exp.getConnective().getImage());
			str.append(" ");
			if (!exp.getChildren().isEmpty()) {
				for (int i = 0; i < exp.getChildren().size() - 1; i++) {
					str.append(StringEncoder.toString(exp.getChildren().get(i), constants, types, predicates, functions, offset) + "\n"
							+ offset);
				}
				str.append(StringEncoder.toString(exp.getChildren().get(
						exp.getChildren().size() - 1), constants, types, predicates, functions, offset));
			}
			str.append(")");
			offset = offset.substring(0, offset.length() - 2);
			break;
		case FORALL:
		case EXISTS:
			offset += offset + "  ";
			str.append(" (");
			str.append(exp.getConnective().getImage());
			str.append(" (");
			str.append(Symbol.DEFAULT_VARIABLE_SYMBOL + (-exp.getVariable() - 1));
			str.append(" - ");
			str.append(types.get(exp.getType()));
			str.append(")\n" + offset);
			if (exp.getChildren().size() ==  1) {
				str.append(StringEncoder.toString(exp.getChildren().get(0), constants, types, predicates, functions, offset));
			}
			str.append(")");
			offset = offset.substring(0, offset.length() - 2);
			break;
		case NUMBER:
			str.append(exp.getValue());
			break;
		case F_EXP:
			str.append(StringEncoder.toString(exp.getChildren().get(0), constants, types, predicates, functions, offset));
			break;
		case F_EXP_T:
			str.append(exp.getConnective());
			/*
			 * if (this.children.isEmpty()) { str.append(this.getVariable()); } else {
			 * str.append("("); str.append(this.getConnective()); str.append(" ");
			 * str.append(this.getVariable()); str.append(" ");
			 * str.append(this.toString(cn.getChildren().get(0))); }
			 */
			break;
		case TIME_VAR:
			// str.append(cn.getVariable());
			break;
		case TRUE:
		case FALSE:
			str.append(exp.getConnective());
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
			str.append(StringEncoder.toString(exp.getChildren().get(0), constants, types, predicates, functions, offset));
			str.append(" ");
			str.append(StringEncoder.toString(exp.getChildren().get(1), constants, types, predicates, functions, offset));
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
			str.append(StringEncoder.toString(exp.getChildren().get(0), constants, types, predicates, functions, offset));
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
	 * Returns a short string representation of the specified operator, i.e., its name and its
	 * instantiated parameters.
	 * 
	 * @param op the operator.
	 * @param constants the table of constants.
	 * @return a string representation of the specified operator.
	 */
	static String toShortString(final BitOp op, final List<String> constants) {
		final StringBuffer str = new StringBuffer();
		str.append(op.getName());
		for (int i = 0; i < op.getArity(); i++) {
			final int index = op.getValueOfParameter(i);
			if (index == -1) {
				str.append(" ?");
			} else {
				str.append(" " + constants.get(index));
			}
		}
		return str.toString();
	}
	
	/**
	 * Returns a string representation of a specified operator.
	 * 
	 * @param op the operator.
	 * @param constants the table of constants.
	 * @param types the table of types.
	 * @param predicates the table of predicates.
	 * @param functions the table of functions.
	 * @param relevants the table of relevant facts.
	 * @return a string representation of the specified operator.
	 */
	static String toString(final BitOp op, final List<String> constants, final List<String> types,
			final List<String> predicates, final List<String> functions, final List<IntExp> relevants) {
		StringBuffer str = new StringBuffer();
		str.append("Op " + op.getName() + "\n");
		str.append("Instantiations:\n");
		for (int i = 0; i < op.getArity(); i++) {
			final int index = op.getValueOfParameter(i);
			final String type = types.get(op.getTypeOfParameters(i));
			if (index == -1) {
				str.append(Symbol.DEFAULT_VARIABLE_SYMBOL + i + " - " + type + " : ? \n");
			} else {
				str.append(Symbol.DEFAULT_VARIABLE_SYMBOL + i + " - " + type + " : "
						+ constants.get(index) + " " + "\n");
			}
		}
		str.append("Preconditions:\n");
		str.append(StringEncoder.toString(op.getPreconditions(),
				constants, types, predicates, functions, relevants));
		str.append("\n");
		str.append("Effects:\n");
		for (CondBitExp condExp : op.getCondEffects()) {
			str.append(StringEncoder.toString(condExp, 
					constants, types, predicates, functions, relevants));
			str.append("\n");
		}
		return str.toString();
	}

	/**
	 * Returns a string representation of a bit expression.
	 * 
	 * @param exp the expression.
	 * @param constants the table of constants.
	 * @param types the table of types.
	 * @param predicates the table of predicates.
	 * @param functions the table of functions.
	 * @param relevants the table of relevant facts.
	 * @return a string representation of the specified expression.
	 */
	static String toString(BitExp exp, final List<String> constants, final List<String> types,
			final List<String> predicates, final List<String> functions,
			final List<IntExp> relevants) {
		final StringBuffer str = new StringBuffer("(and");
		final BitSet positive = exp.getPositive();
		for (int i = positive.nextSetBit(0); i >= 0; i = positive.nextSetBit(i + 1)) {
			str.append(" ");
			str.append(StringEncoder.toString(relevants.get(i), 
					constants, types,predicates, functions));
			str.append("\n");
		}
		final BitSet negative = exp.getNegative();
		for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
			str.append(" (not ");
			str.append(StringEncoder.toString(relevants.get(i), 
					constants, types, predicates, functions));
			str.append(")\n");
		}
		str.append(")");
		return str.toString();
	}

	/**
	 * Returns a string representation of a conditional bit expression.
	 * 
	 * @param exp the conditional expression.
	 * @param constants the table of constants.
	 * @param types the table of types.
	 * @param predicates the table of predicates.
	 * @param functions the table of functions.
	 * @param relevants the table of relevant facts.
	 * @return a string representation of the specified expression.
	 */
	static String toString(CondBitExp exp, final List<String> constants, final List<String> types,
			final List<String> predicates, final List<String> functions,
			final List<IntExp> relevants) {
		StringBuffer str = new StringBuffer();
		if (exp.getCondition().isEmpty()) {
			str.append(StringEncoder.toString(exp.getEffects(), 
					constants, types, predicates, functions, relevants));
		} else {
			str.append("(when ");
			str.append(StringEncoder.toString(exp.getCondition(),
					constants, types, predicates, functions, relevants));
			str.append("\n");
			str.append(StringEncoder.toString(exp.getEffects(),
					constants, types, predicates, functions, relevants));
			str.append(")");
		}
		return str.toString();
	}
	
}
