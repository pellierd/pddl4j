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
import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * This class contains the methods needed for the post instantiation step the encoding. In
 * other words, it contains methods to extract the relevant facts from the instantiated actions
 * and methods to simplify the actions and the methods based on ground inertia information.
 * </p>
 * <p>
 * <i>Definition:</i> A ground fact is a positive ground inertia if and only if it does not occur
 * positively in an unconditional effect or the consequent of a conditional effect of an action.
 * </p>
 * <p>
 * <i>Definition:</i> A ground fact is a negative ground inertia if and only if it does not occur
 * negatively in an unconditional effect or the consequent of a conditional effect of an action.
 * </p>
 * An initial fact, which is a negative ground inertia, is never made FALSE and thus always
 * satisfied in all reachable world states. It can be removed from the state description. All its
 * occurrences in the preconditions of actions and in the antecedents of conditional effects can be
 * simplified to TRUE. A fact, which is a positive ground inertia and not contained in the initial
 * state, is never satisfied in any reachable world state. All its occurrences in the preconditions
 * of actions and in the antecedents of conditional effects can be simplified to FALSE. The
 * remaining facts are fluents that, roughly speaking, can possibly change their truth value during
 * the planning process. They are therefore relevant to the representation of the planning problem.
 *
 * @author D. Pellier
 * @version 1.0 - 10.04.2010
 */
final class PostInstantiation implements Serializable {

    /**
     * The default constructor with a private access to prevent instance creation.
     */
    private PostInstantiation() {
    }

    /**
     * Extracts the relevant numeric fluents.
     *
     * @param actions the list of instantiated actions.
     * @param methods the list of instantiated methods
     */
    static void extractRelevantNumericFluents(final List<IntAction> actions, List<IntMethod> methods) {
        final Set<IntExpression> fluents = new LinkedHashSet<>(100);
        for (IntAction a : actions) {
            if (a.isDurative()) {
                extractRelevantNumericFluents(a.getDuration(), fluents);
            }
            extractRelevantNumericFluents(a.getPreconditions(), fluents);
            extractRelevantNumericFluents(a.getEffects(), fluents);
        }
        Encoder.tableOfRelevantNumericFluents = new ArrayList<>(fluents.size());
        for (IntExpression exp : fluents) {
            final IntExpression relevant = new IntExpression(exp);
            Encoder.tableOfRelevantNumericFluents.add(relevant);
        }
    }

    /**
     * Extracts the relevant facts from a specified expression. A ground fact is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fact and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fact and not a positive ground inertia.</li>
     * </ul>
     *
     * @param exp   the expression.
     * @param fluents the set of relevant facts.
     */
    private static void extractRelevantNumericFluents(final IntExpression exp, final Set<IntExpression> fluents) {
        switch (exp.getConnective()) {
            case FN_HEAD:
            fluents.add(exp);
                break;
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    PostInstantiation.extractRelevantNumericFluents(e, fluents);
                }
                break;
            case UMINUS:
            case NOT:
                PostInstantiation.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                break;
            case WHEN:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                PostInstantiation.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                PostInstantiation.extractRelevantNumericFluents(exp.getChildren().get(1), fluents);
                break;
            case F_EXP:
                PostInstantiation.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                break;
            case TIME_VAR:
            case NUMBER:
            case ATOM:
            case TRUE:
            case FALSE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());

        }
    }



    /**
     * Extracts the relevant tasks from the instantiated methods. A ground tasks is relevant if and
     * only if it occurs as a task or a subtask of a instantiated method.
     *
     * @param methods the list of instantiated methods
     */
    static void extractRelevantTasks(List<IntMethod> methods) {
        final Set<IntExpression> tasks = new LinkedHashSet<>(1000);
        for (IntMethod m : methods) {
            tasks.add(m.getTask());
            PostInstantiation.extractRelevantTasks(m.getSubTasks(), tasks);
        }
        Encoder.tableOfRelevantTasks = new ArrayList<>(tasks.size());
        int primitive = 0;
        int compound = 0;
        for (IntExpression task : tasks) {
            final IntExpression copy = new IntExpression(task);
            copy.setTaskID(IntExpression.DEFAULT_TASK_ID);
            Encoder.tableOfRelevantTasks.add(copy);
            if (copy.isPrimtive()) {
                primitive++;
            } else {
                compound++;
            }
        }
    }

    /**
     * Extracts the tasks from a specified expression. A ground task is relevant if and
     * only if it occurs as a subtask of a instantiated method.
     *
     * @param exp   the expression.
     * @param tasks the set of relevant tasks.
     */
    private static void extractRelevantTasks(final IntExpression exp, final Set<IntExpression> tasks) {
        switch (exp.getConnective()) {
            case TASK:
                tasks.add(exp);
                break;
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    PostInstantiation.extractRelevantTasks(e, tasks);
                }
                break;
            default:
                // do nothing
        }
    }

    /**
     * This method simplify a specified expression.
     *
     * @param exp the expression to simplify.
     */
    private static void simplify(final IntExpression exp) {
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
                // The equality is TRUE: arg1 and arg2 are the same variable or the same constant
                if (arg1 == arg2) {
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (arg1 >= 0 && arg2 >= 0) {
                    // The equality is ground and the equality is FALSE because arg1 != arg2
                    exp.setConnective(PDDLConnective.FALSE);
                }
                break;
            case AND:
                int i = 0;
                while (i < exp.getChildren().size() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = exp.getChildren().get(i);
                    PostInstantiation.simplify(ei);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        // If a child expression is TRUE, we can remove the child expression.
                        exp.getChildren().remove(i);
                    } else if (ei.getConnective().equals(PDDLConnective.AND)) {
                        // If the child expression to add is a conjunction, we can simplify the expression
                        // by
                        // removing the inner conjunction.
                        exp.getChildren().remove(i);
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size()
                            && exp.getConnective().equals(PDDLConnective.AND)) {
                            final IntExpression ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(PDDLConnective.FALSE)) {
                                exp.setConnective(PDDLConnective.FALSE);
                            } else if (ej.getConnective().equals(PDDLConnective.TRUE)) {
                                // do nothing
                            } else {
                                exp.getChildren().add(i + added, ej);
                                added++;
                            }
                            j++;
                        }
                        i += added + 1;
                    } else if (ei.getConnective().equals(PDDLConnective.WHEN)) {
                        // Simplification of the conditional expression.
                        final IntExpression antecedent = ei.getChildren().get(0);
                        final IntExpression consequent = ei.getChildren().get(1);
                        // If the antecedent of a conditional effect becomes FALSE , the conditional
                        // effect is removed from the operator. In this case, the effect is never
                        // applicable
                        // because it requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(PDDLConnective.FALSE)) {
                            exp.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(PDDLConnective.TRUE)) {
                            // Simplification of the conditional expression.
                            if (consequent.getConnective().equals(PDDLConnective.AND)) {
                                exp.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && exp.getConnective().equals(PDDLConnective.AND)) {
                                    final IntExpression ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(PDDLConnective.FALSE)) {
                                        exp.setConnective(PDDLConnective.FALSE);
                                    } else if (ej.getConnective().equals(PDDLConnective.TRUE)) {
                                        // do nothing
                                    } else {
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
                        } else if (consequent.getConnective().equals(PDDLConnective.TRUE)) {
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
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            case OR:
                i = 0;
                while (i < exp.getChildren().size() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = exp.getChildren().get(i);
                    PostInstantiation.simplify(ei);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    } else if (ei.getConnective().equals(PDDLConnective.OR)) {
                        // If the child expression to add is a disjunction, we can simplify the expression
                        // by
                        // removing the inner disjunction.
                        exp.getChildren().remove(i);
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size() && exp.getConnective().equals(PDDLConnective.OR)) {
                            final IntExpression ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(PDDLConnective.TRUE)) {
                                exp.setConnective(PDDLConnective.TRUE);
                            } else if (ej.getConnective().equals(PDDLConnective.FALSE)) {
                                // do nothing
                            } else {
                                exp.getChildren().add(i + added, ej);
                                added++;
                            }
                            j++;
                        }
                        i += added + 1;
                    } else if (ei.getConnective().equals(PDDLConnective.WHEN)) {
                        // Simplification of the conditional expression.
                        final IntExpression antecedent = ei.getChildren().get(0);
                        final IntExpression consequent = ei.getChildren().get(1);
                        // If the antecedent of a conditional effect becomes FALSE , the conditional
                        // effect is
                        // removed from the operator. In this case, the effect is never applicable
                        // because it
                        // requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(PDDLConnective.FALSE)) {
                            exp.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional
                            // effect
                            // becomes unconditional.
                            if (consequent.getConnective().equals(PDDLConnective.OR)) {
                                exp.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && exp.getConnective().equals(PDDLConnective.OR)) {
                                    final IntExpression ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(PDDLConnective.TRUE)) {
                                        exp.setConnective(PDDLConnective.TRUE);
                                    } else if (ej.getConnective().equals(PDDLConnective.FALSE)) {
                                        // do nothing
                                    } else {
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
                        } else if (consequent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional
                            // effect
                            // becomes unconditional.
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
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                } else {
                    final Iterator<IntExpression> it = exp.getChildren().iterator();
                    while (it.hasNext()) {
                        if (it.next().getConnective().equals(PDDLConnective.FALSE)) {
                            it.remove();
                        }
                    }
                    if (exp.getChildren().isEmpty()) {
                        exp.setConnective(PDDLConnective.FALSE);
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
                PostInstantiation.simplify(exp.getChildren().get(0));
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                PostInstantiation.simplify(neg);
                if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                    exp.setConnective(PDDLConnective.TRUE);
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
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
                PostInstantiation.simplify(exp.getChildren().get(0));
                PostInstantiation.simplify(exp.getChildren().get(1));
                break;
            case F_EXP_T:
            case F_EXP:
                PostInstantiation.simplify(exp.getChildren().get(0));
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                PostInstantiation.simplify(exp.getChildren().get(0));
                PostInstantiation.simplify(exp.getChildren().get(1));
                PostInstantiation.simplify(exp.getChildren().get(3));
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

}
