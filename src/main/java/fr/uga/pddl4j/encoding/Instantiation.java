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

import fr.uga.pddl4j.parser.Connective;
import fr.uga.pddl4j.util.IntExp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This class contains the methods needed to instantiate the operators.
 *
 * @author D. Pellier
 * @version 1.0 - 07.04.2010
 */
final class Instantiation implements Serializable {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default constructor with a private access to prevent instance creation.
     */
    private Instantiation() {
    }

    /**
     * Instantiates a specified list of operators.
     *
     * @param operators the list of operators to instantiate.
     * @return the list of instantiated operators.
     */
    static List<IntOp> instantiateOperators(final List<IntOp> operators) {
        final List<IntOp> instOps = new ArrayList<>(1000);
        for (IntOp op : operators) {
            // If an operator has a parameter with a empty domain the operator must be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < op.getArity() && toInstantiate) {
                toInstantiate = !Encoder.tableOfDomains.get(op.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (toInstantiate) {
                instOps.addAll(Instantiation.instantiate(op));
            }
        }
        return instOps;
    }

    /**
     * Instantiates a specified operator.
     *
     * @param operator the operator to instantiate.
     * @param bound    the bound of actions to instantiate.
     * @return the list of operators instantiated corresponding the specified operator.
     */
    static List<IntOp> instantiate(final IntOp operator, final int bound) {
        final List<IntOp> instOps = new ArrayList<>(100);
        Instantiation.expandQuantifiedExpression(operator.getPreconditions());
        Instantiation.simplify(operator.getPreconditions());
        if (!operator.getPreconditions().getConnective().equals(Connective.FALSE)) {
            Instantiation.expandQuantifiedExpression(operator.getEffects());
            Instantiation.simplify(operator.getEffects());
            if (!operator.getEffects().getConnective().equals(Connective.FALSE)) {
                Instantiation.instantiate(operator, 0, bound, instOps);
            }
        }
        return instOps;
    }

    /**
     * Instantiates a specified operator.
     *
     * @param operator the operator to instantiate.
     * @return the list of operators instantiated corresponding the specified operator.
     */
    static List<IntOp> instantiate(final IntOp operator) {
        return Instantiation.instantiate(operator, Integer.MAX_VALUE);
    }

    /**
     * Instantiates a specified operator.
     * <p>
     * The assumption is made that different operator parameters are instantiated with different
     * constants, i.e., the planner never generates actions like move(a,a) because we consider this
     * as a bad domain representation that should be revised. In fact, in operators with identical
     * constant parameters, all but one of the constants are superfluous and can be skipped from the
     * representation without loss of information.
     * </p>
     *
     * @param op        the operator.
     * @param index     the index of the parameter to instantiate.
     * @param bound     the bound of actions to instantiate.
     * @param operators the list of operators already instantiated.
     * @see IntOp
     */
    private static void instantiate(final IntOp op, final int index, final int bound, final List<IntOp> operators) {
        if (bound == operators.size()) {
            return;
        }
        final int arity = op.getArity();
        if (index == arity) {
            final IntExp precond = op.getPreconditions();
            Instantiation.simplify(precond);
            if (!precond.getConnective().equals(Connective.FALSE)) {
                final IntExp effect = op.getEffects();
                Instantiation.simplify(effect);
                if (!effect.getConnective().equals(Connective.FALSE)) {
                    operators.add(op);
                }
            }
        } else {
            final Set<Integer> values = Encoder.tableOfDomains.get(op.getTypeOfParameters(index));
            for (Integer value : values) {
                if (!op.isAlreadyInstantiatedWith(value)) {
                    final int varIndex = -index - 1;
                    final IntExp precond = new IntExp(op.getPreconditions());
                    Instantiation.substitute(precond, varIndex, value);
                    if (!precond.getConnective().equals(Connective.FALSE)) {
                        final IntExp effects = new IntExp(op.getEffects());
                        Instantiation.substitute(effects, varIndex, value);
                        if (!effects.getConnective().equals(Connective.FALSE)) {
                            final IntOp copy = new IntOp(op.getName(), arity);
                            copy.setPreconditions(precond);
                            copy.setEffects(effects);
                            for (int i = 0; i < arity; i++) {
                                copy.setTypeOfParameter(i, op.getTypeOfParameters(i));
                            }
                            for (int i = 0; i < index; i++) {
                                copy.setValueOfParameter(i, op.getValueOfParameter(i));
                            }
                            copy.setValueOfParameter(index, value);
                            Instantiation.instantiate(copy, index + 1, bound, operators);
                        }
                    }
                }
            }
        }
    }

    /**
     * Expands the quantified expressions contained in a specified expression.
     *
     * @param exp the expression.
     */
    static void expandQuantifiedExpression(final IntExp exp) {
        switch (exp.getConnective()) {
            case AND:
                Iterator<IntExp> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(Connective.AND)) {
                    final IntExp ei = i.next();
                    // Remove quantified expression where the domain of the quantified variable is empty
                    if ((ei.getConnective().equals(Connective.FORALL) || ei.getConnective().equals(Connective.EXISTS))
                        && Encoder.tableOfDomains.get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    Instantiation.expandQuantifiedExpression(ei);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(Connective.FALSE)) {
                        exp.setConnective(Connective.FALSE);
                    }
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(Connective.OR)) {
                    final IntExp ei = i.next();
                    // Remove quantified expression where the domain of the quantified variable is empty
                    if ((ei.getConnective().equals(Connective.FORALL) || ei.getConnective().equals(Connective.EXISTS))
                        && Encoder.tableOfDomains.get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    Instantiation.expandQuantifiedExpression(ei);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    if (ei.getConnective().equals(Connective.TRUE)) {
                        exp.setConnective(Connective.TRUE);
                    }
                }
                break;
            case FORALL:
                Set<Integer> constants = Encoder.tableOfDomains.get(exp.getType());
                IntExp qExp = exp.getChildren().get(0);
                int var = exp.getVariable();
                exp.setConnective(Connective.AND);
                exp.getChildren().clear();
                Iterator<Integer> it = constants.iterator();
                while (it.hasNext() && exp.getConnective().equals(Connective.AND)) {
                    int cons = it.next();
                    IntExp copy = new IntExp(qExp);
                    Instantiation.substitute(copy, var, cons);
                    exp.getChildren().add(copy);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (copy.getConnective().equals(Connective.FALSE)) {
                        exp.setConnective(Connective.FALSE);
                    }
                }
                Instantiation.expandQuantifiedExpression(exp);
                break;
            case EXISTS:
                constants = Encoder.tableOfDomains.get(exp.getType());
                qExp = exp.getChildren().get(0);
                var = exp.getVariable();
                exp.setConnective(Connective.OR);
                exp.getChildren().clear();
                it = constants.iterator();
                while (it.hasNext() && exp.getConnective().equals(Connective.OR)) {
                    int cons = it.next();
                    IntExp copy = new IntExp(qExp);
                    Instantiation.substitute(copy, var, cons);
                    exp.getChildren().add(copy);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    if (copy.getConnective().equals(Connective.TRUE)) {
                        exp.setConnective(Connective.TRUE);
                    }
                }
                Instantiation.expandQuantifiedExpression(exp);
                break;

            case AT_START:
            case AT_END:
            case NOT:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(0));
                break;
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case WHEN:
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(0));
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(1));
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(0));
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(1));
                Instantiation.expandQuantifiedExpression(exp.getChildren().get(3));
                break;
            case ATOM:
                Instantiation.simplyAtom(exp);
                break;
            case EQUAL_ATOM:
            case FN_HEAD:
            case FN_ATOM:
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
            case F_EXP_T:
            case NUMBER:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case F_EXP:
            case TIME_VAR:
            case IS_VIOLATED:
                // do nothing
                break;
            default:
                // do nothing
        }
    }

    /**
     * This method simplify a specified expression. The rules of simplification are as below:
     * <ul>
     * <li> not true eqv false </li>
     * <li> true ^ phi eqv phi </li>
     * <li> false ^ phi eqv false </li>
     * <li> true v phi eqv true </li>
     * <li> false v phi eqv false </li>
     * <li> not false eqv true </li>
     * <li> phi ^ phi eqv phi </li>
     * <li> phi v phi eqv phi </li>
     * <li> phi ^ not phi eqv false </li>
     * <li> phi v not phi eqv true </li>
     * <li> x = x eqv true </li>
     * <li> x = y eqv false </li>
     * </ul>
     *
     * @param exp the expression to simplify.
     */
    private static void simplify(final IntExp exp) {
        switch (exp.getConnective()) {
            case ATOM:
                break;
            case FN_HEAD:
                break;
            case EQUAL_ATOM:
                int[] args = exp.getArguments();
                // Get and substitute the first argument
                final int arg1 = args[0];
                // Get and substitute the second argument
                final int arg2 = args[1];
                if (arg1 == arg2) {
                    // The equality is TRUE: arg1 and arg2 are the same variable or the same constant
                    exp.setConnective(Connective.TRUE);
                } else if (arg1 >= 0 && arg2 >= 0) {
                    // The equality is ground and the equality is FALSE because arg1 != arg2
                    exp.setConnective(Connective.FALSE);
                }
                break;
            case AND:
                int i = 0;
                while (i < exp.getChildren().size() && exp.getConnective().equals(Connective.AND)) {
                    final IntExp ei = exp.getChildren().get(i);
                    Instantiation.simplify(ei);
                    if (ei.getConnective().equals(Connective.FALSE)) {
                        // If a child expression is FALSE, the whole conjunction becomes FALSE.
                        exp.setConnective(Connective.FALSE);
                    } else if (ei.getConnective().equals(Connective.TRUE)) {
                        // If a child expression is TRUE, we can remove the child expression.
                        exp.getChildren().remove(i);
                    } else if (ei.getConnective().equals(Connective.AND)) {
                        // If the child expression to add is a conjunction, we can simplify the expression by
                        exp.getChildren().remove(i); // removing the inner conjunction.
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size() && exp.getConnective().equals(Connective.AND)) {
                            final IntExp ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(Connective.FALSE)) {
                                exp.setConnective(Connective.FALSE);
                            } else if (!ej.getConnective().equals(Connective.TRUE)) {
                                exp.getChildren().add(i + added, ej);
                                added++;
                            }
                            j++;
                        }
                        i += added + 1;
                    } else if (ei.getConnective().equals(Connective.WHEN)) {
                        // Simplification of the conditional expression.
                        final IntExp antecedent = ei.getChildren().get(0);
                        final IntExp consequent = ei.getChildren().get(1);
                        // If the antecedent of a conditional effect becomes FALSE , the conditional
                        // effect is removed from the operator. In this case, the effect is never applicable
                        // because it requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(Connective.FALSE)) {
                            exp.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(Connective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional
                            // effect becomes unconditional.
                            if (consequent.getConnective().equals(Connective.AND)) {
                                exp.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && exp.getConnective().equals(Connective.AND)) {

                                    final IntExp ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(Connective.FALSE)) {
                                        exp.setConnective(Connective.FALSE);
                                    } else if (!ej.getConnective().equals(Connective.TRUE)) {
                                        exp.getChildren().add(i + added, ej);
                                        added++;
                                    }
                                    j++;
                                }
                                i += added + 1;
                            } else {
                                exp.getChildren().set(i, consequent);
                                i++;
                            }
                        } else if (consequent.getConnective().equals(Connective.TRUE)) {
                            // If the consequent of a conditional effect becomes TRUE, the conditional
                            // effect is removed because it does not lead to any state transition.
                            exp.getChildren().remove(i);
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                }
                // Finally, if the conjunction is empty, the expression becomes TRUE.
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(Connective.TRUE);
                } else if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            case OR:
                i = 0;
                while (i < exp.getChildren().size() && exp.getConnective().equals(Connective.OR)) {
                    final IntExp ei = exp.getChildren().get(i);
                    Instantiation.simplify(ei);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(Connective.TRUE)) {
                        exp.setConnective(Connective.TRUE);
                    } else if (ei.getConnective().equals(Connective.OR)) {
                        // If the child expression to add is a disjunction, we can simplify the expression by
                        // removing the inner disjunction.
                        exp.getChildren().remove(i);
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size() && exp.getConnective().equals(Connective.OR)) {
                            final IntExp ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(Connective.TRUE)) {
                                exp.setConnective(Connective.TRUE);
                            } else if (!ej.getConnective().equals(Connective.FALSE)) {
                                exp.getChildren().add(i + added, ej);
                                added++;
                            }
                            j++;
                        }
                        i += added + 1;
                    } else if (ei.getConnective().equals(Connective.WHEN)) {
                        // Simplification of the conditional expression.
                        final IntExp antecedent = ei.getChildren().get(0);
                        final IntExp consequent = ei.getChildren().get(1);
                        // If the antecedent of a conditional effect becomes FALSE , the conditional effect is
                        // removed from the operator. In this case, the effect is never applicable because it
                        // requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(Connective.FALSE)) {
                            exp.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(Connective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional effect
                            // becomes unconditional.
                            if (consequent.getConnective().equals(Connective.OR)) {
                                exp.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && exp.getConnective().equals(Connective.OR)) {

                                    final IntExp ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(Connective.TRUE)) {
                                        exp.setConnective(Connective.TRUE);
                                    } else if (!ej.getConnective().equals(Connective.FALSE)) {
                                        exp.getChildren().add(i + added, ej);
                                        added++;
                                    }
                                    j++;
                                }
                                i += added + 1;
                            } else {
                                exp.getChildren().set(i, consequent);
                                i++;
                            }
                        } else if (consequent.getConnective().equals(Connective.TRUE)) {
                            // If the consequent of a conditional effect becomes TRUE, the conditional
                            // effect is removed because it does not lead to any state transition.
                            exp.getChildren().remove(i);
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                }
                // Finally, if the disjunction is empty, the expression becomes TRUE.
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(Connective.TRUE);
                } else if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                } else {
                    final Iterator<IntExp> it = exp.getChildren().iterator();
                    while (it.hasNext()) {
                        if (it.next().getConnective().equals(Connective.FALSE)) {
                            it.remove();
                        }
                    }
                    if (exp.getChildren().isEmpty()) {
                        exp.setConnective(Connective.FALSE);
                    }
                }
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case UMINUS:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
                Instantiation.simplify(exp.getChildren().get(0));
                break;
            case NOT:
                final IntExp neg = exp.getChildren().get(0);
                Instantiation.simplify(neg);
                if (neg.getConnective().equals(Connective.TRUE)) {
                    exp.setConnective(Connective.FALSE);
                } else if (neg.getConnective().equals(Connective.FALSE)) {
                    exp.setConnective(Connective.TRUE);
                }
                break;
            case WHEN:
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
            case F_EXP:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
                Instantiation.simplify(exp.getChildren().get(0));
                Instantiation.simplify(exp.getChildren().get(1));
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    Instantiation.simplify(exp.getChildren().get(0));
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                Instantiation.simplify(exp.getChildren().get(0));
                Instantiation.simplify(exp.getChildren().get(1));
                Instantiation.simplify(exp.getChildren().get(3));
                break;
            case FN_ATOM:
            case NUMBER:
            case DURATION_ATOM:
            case TIME_VAR:
            case IS_VIOLATED:
            case MINIMIZE:
            case MAXIMIZE:
                break;
            default:
                // do nothing
        }
    }

    /**
     * Substitutes all occurrence of a specified variable into an expression by a constant.
     *
     * @param exp  the expression.
     * @param var  the variable.
     * @param cons the constant.
     */
    private static void substitute(final IntExp exp, final int var, final int cons) {
        switch (exp.getConnective()) {
            case ATOM:
                boolean updated = false;
                int[] args = exp.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                        updated = true;
                    }
                }
                if (updated) {
                    Instantiation.simplyAtom(exp);
                }
                break;
            case FN_HEAD:
                args = exp.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                    }
                }
                break;
            case EQUAL_ATOM:
                args = exp.getArguments();
                // Get and substitute the first argument
                final int arg1 = args[0];
                if (arg1 == var) {
                    args[0] = cons;
                }
                // Get and substitute the second argument
                final int arg2 = args[1];
                if (arg2 == var) {
                    args[1] = cons;
                }
                // The equality is TRUE: arg1 and arg2 are the same variable or the same constant
                if (arg1 == arg2) {
                    exp.setConnective(Connective.TRUE);
                } else if (arg1 >= 0 && arg2 >= 0) {
                    // The equality is ground and the equality is FALSE because arg1 != arg2
                    exp.setConnective(Connective.FALSE);
                }
                break;
            case AND:
                Iterator<IntExp> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(Connective.AND)) {
                    final IntExp ei = i.next();
                    Instantiation.substitute(ei, var, cons);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(Connective.FALSE)) {
                        exp.setConnective(Connective.FALSE);
                    }
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(Connective.OR)) {
                    final IntExp ei = i.next();
                    Instantiation.substitute(ei, var, cons);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(Connective.TRUE)) {
                        exp.setConnective(Connective.TRUE);
                    }
                }
                break;
            case NOT:
                final IntExp neg = exp.getChildren().get(0);
                Instantiation.substitute(neg, var, cons);
                if (neg.getConnective().equals(Connective.TRUE)) {
                    exp.setConnective(Connective.FALSE);
                } else if (neg.getConnective().equals(Connective.FALSE)) {
                    exp.setConnective(Connective.TRUE);
                }
                break;
            case WHEN:
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
            case F_EXP:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
                Instantiation.substitute(exp.getChildren().get(0), var, cons);
                Instantiation.substitute(exp.getChildren().get(1), var, cons);
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case UMINUS:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
                Instantiation.substitute(exp.getChildren().get(0), var, cons);
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    Instantiation.substitute(exp.getChildren().get(0), var, cons);
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                Instantiation.substitute(exp.getChildren().get(0), var, cons);
                Instantiation.substitute(exp.getChildren().get(1), var, cons);
                Instantiation.substitute(exp.getChildren().get(3), var, cons);
                break;
            case FN_ATOM:
            case NUMBER:
            case DURATION_ATOM:
            case TIME_VAR:
            case IS_VIOLATED:
            case MINIMIZE:
            case MAXIMIZE:
                break;
            default:
                // do nothing
        }
    }

    /**
     * This method simplifies an atomic specified expression. Two cased must be considered:
     * <ul>
     * <li>1. If the expression is a positive inertia and the number of unifying ground instances of
     * the specified expression that are contained in the initial state is equal to 0 then the
     * expression is simplified to FALSE.</li>
     * <li>2. If the expression is a negative inertia and then the number of all possible
     * type-consistent ground instances of the specified expression then the expression is
     * simplified to TRUE.
     * </ul>
     *
     * @param exp the atomic expression to simplify.
     */
    private static void simplyAtom(final IntExp exp) {
        final int predicate = exp.getPredicate();
        // Compute the mask i.e., the vector used to indicate where the constant are located in the
        // atomic expression.
        int indexSize = 0;
        final int[] args = exp.getArguments();
        final int[] mask = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] >= 0) {
                mask[i] = 1;
                indexSize++;
            }
        }
        // Compute the index to access to the predicates table and compute the product (max) of the
        // tableOfDomains of the non instantiated arguments of the atomic expression.
        int j = 0;
        int max = 1;
        final int[] index = new int[indexSize];
        final List<Integer> predArg = Encoder.tableOfTypedPredicates.get(predicate);
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 0) {
                max *= Encoder.tableOfDomains.get(predArg.get(i)).size();
            } else {
                index[j] = args[i];
                j++;
            }

        }
        // Get the number of unifying ground instances of the specified expression that are
        // contained in the initial state.
        final int n = Encoder.predicatesTables.get(predicate).get(PreInstantiation.toInt(mask)).get(index);
        // CASE 1: If the expression is a positive inertia and the number of unifying ground
        // instances of the specified expression that are contained in the initial state is equal to
        // 0 then the expression is simplified to FALSE.
        final Inertia inertia = Encoder.tableOfInertia.get(predicate);
        if ((inertia.equals(Inertia.POSITIVE) || inertia.equals(Inertia.INERTIA)) && n == 0) {
            exp.setConnective(Connective.FALSE);
        } else if ((inertia.equals(Inertia.NEGATIVE) || inertia.equals(Inertia.INERTIA)) && max == n) {
            // CASE 2: If the expression is a negative inertia and then the number of all possible
            // type-consistent ground instances of the specified expression then the expression is
            // simplified to TRUE.
            exp.setConnective(Connective.TRUE);
        }
    }

}
