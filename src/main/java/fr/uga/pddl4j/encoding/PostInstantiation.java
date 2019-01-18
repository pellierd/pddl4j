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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * This class contains the methods needed for the post instantiation step the encoding. In
 * other words, it contains methods to extract the relevant facts from the instantiated operators
 * and methods to simplify the operator based on ground inertia information.
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
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default constructor with a private access to prevent instance creation.
     */
    private PostInstantiation() {
    }

    /**
     * Extracts the relevant facts from the instantiated operator. A ground fact is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fact and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fact and not a positive ground inertia.</li>
     * </ul>
     *
     * @param operators the list of operators.
     * @param init      the initial state.
     */
    static void extractRelevantFacts(final List<IntOp> operators, final Set<IntExp> init) {
        final Set<IntExp> relevants = new LinkedHashSet<>(10000);
        for (IntOp op : operators) {
            PostInstantiation.extractRelevantFacts(op.getPreconditions(), relevants, init);
            PostInstantiation.extractRelevantFacts(op.getEffects(), relevants, init);
        }
        Encoder.tableOfRelevantFacts = new ArrayList<>(relevants.size());
        for (IntExp exp : relevants) {
            final IntExp relevant = new IntExp(exp);
            Encoder.tableOfRelevantFacts.add(relevant);
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
     * @param exp       the expression.
     * @param relevants the set of relevant facts.
     * @param init      the initial state.
     */
    private static void extractRelevantFacts(final IntExp exp, final Set<IntExp> relevants,
                                             final Set<IntExp> init) {
        switch (exp.getConnective()) {
            case ATOM:
                relevants.add(exp);
                break;
            case FN_HEAD:
                break;
            case EQUAL_ATOM:
                break;
            case AND:
            case OR:
                for (IntExp e : exp.getChildren()) {
                    PostInstantiation.extractRelevantFacts(e, relevants, init);
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
            case NOT:
                PostInstantiation.extractRelevantFacts(exp.getChildren().get(0), relevants, init);
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
                PostInstantiation.extractRelevantFacts(exp.getChildren().get(0), relevants, init);
                PostInstantiation.extractRelevantFacts(exp.getChildren().get(1), relevants, init);
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    PostInstantiation.extractRelevantFacts(exp.getChildren().get(0), relevants, init);
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                PostInstantiation.extractRelevantFacts(exp.getChildren().get(0), relevants, init);
                PostInstantiation.extractRelevantFacts(exp.getChildren().get(1), relevants, init);
                PostInstantiation.extractRelevantFacts(exp.getChildren().get(3), relevants, init);
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
     * This method simplify a specified expression.
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
                // The equality is TRUE: arg1 and arg2 are the same variable or the same constant
                if (arg1 == arg2) {
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
                    PostInstantiation.simplify(ei);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(Connective.FALSE)) {
                        exp.setConnective(Connective.FALSE);
                    } else if (ei.getConnective().equals(Connective.TRUE)) {
                        // If a child expression is TRUE, we can remove the child expression.
                        exp.getChildren().remove(i);
                    } else if (ei.getConnective().equals(Connective.AND)) {
                        // If the child expression to add is a conjunction, we can simplify the expression
                        // by
                        // removing the inner conjunction.
                        exp.getChildren().remove(i);
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size()
                            && exp.getConnective().equals(Connective.AND)) {
                            final IntExp ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(Connective.FALSE)) {
                                exp.setConnective(Connective.FALSE);
                            } else if (ej.getConnective().equals(Connective.TRUE)) {
                                // do nothing
                            } else {
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
                        // effect is removed from the operator. In this case, the effect is never
                        // applicable
                        // because it requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(Connective.FALSE)) {
                            exp.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(Connective.TRUE)) {
                            // Simplification of the conditional expression.
                            if (consequent.getConnective().equals(Connective.AND)) {
                                exp.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && exp.getConnective().equals(Connective.AND)) {
                                    final IntExp ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(Connective.FALSE)) {
                                        exp.setConnective(Connective.FALSE);
                                    } else if (ej.getConnective().equals(Connective.TRUE)) {
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
                    PostInstantiation.simplify(ei);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(Connective.TRUE)) {
                        exp.setConnective(Connective.TRUE);
                    } else if (ei.getConnective().equals(Connective.OR)) {
                        // If the child expression to add is a disjunction, we can simplify the expression
                        // by
                        // removing the inner disjunction.
                        exp.getChildren().remove(i);
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size() && exp.getConnective().equals(Connective.OR)) {
                            final IntExp ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(Connective.TRUE)) {
                                exp.setConnective(Connective.TRUE);
                            } else if (ej.getConnective().equals(Connective.FALSE)) {
                                // do nothing
                            } else {
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
                        // effect is
                        // removed from the operator. In this case, the effect is never applicable
                        // because it
                        // requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(Connective.FALSE)) {
                            exp.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(Connective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional
                            // effect
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
                                    } else if (ej.getConnective().equals(Connective.FALSE)) {
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
                        } else if (consequent.getConnective().equals(Connective.TRUE)) {
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
                PostInstantiation.simplify(exp.getChildren().get(0));
                break;
            case NOT:
                final IntExp neg = exp.getChildren().get(0);
                PostInstantiation.simplify(neg);
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
                PostInstantiation.simplify(exp.getChildren().get(0));
                PostInstantiation.simplify(exp.getChildren().get(1));
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    PostInstantiation.simplify(exp.getChildren().get(0));
                }
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

    // *********************************************************************************************
    // Methods for extracting from the instantiated operators the ground inertia.
    // *********************************************************************************************

    /**
     * Do a pass over the effects of all the instantiated operators and update the ground inertia
     * table. Then, simplify the operators according to the extracted ground inertia.
     *
     * @param operators the list of operators to simplified.
     * @param init      the initial state.
     */
    static void simplyOperatorsWithGroundInertia(final List<IntOp> operators, final Set<IntExp> init) {

        // Then for each instantiated operator try to simplify it.
        final List<IntOp> tmpOps = new ArrayList<>(operators.size());
        for (IntOp op : operators) {
            PostInstantiation.simplifyWithGroundInertia(op.getPreconditions(), false, init);
            PostInstantiation.simplify(op.getPreconditions());
            if (!op.getPreconditions().getConnective().equals(Connective.FALSE)) {
                PostInstantiation.simplifyWithGroundInertia(op.getEffects(), true, init);
                PostInstantiation.simplify(op.getEffects());
                if (!op.getEffects().getConnective().equals(Connective.FALSE)
                    && !op.getEffects().getConnective().equals(Connective.TRUE)) {
                    tmpOps.add(op);
                }
            }
        }
        operators.clear();
        operators.addAll(tmpOps);
    }

    /**
     * Simplify a specified goal expression based on the ground inertia information.
     *
     * @param goal the expression to simply.
     * @param init the initial state.
     */
    static void simplifyGoalWithGroundInertia(final IntExp goal, final Set<IntExp> init) {
        PostInstantiation.simplifyWithGroundInertia(goal, false, init);
        PostInstantiation.simplify(goal);
    }

    /**
     * Simplify a specified expression based on the ground inertia information.
     * <p>
     * <i>Definition:</i> A ground fact is a positive ground inertia iff it does not occur positively in
     * an unconditional effect or the consequent of a conditional effect of an action.
     * </p>
     * <p>
     * <i>Definition:</i> A ground fact is a negative ground inertia iff it does not occur negatively in
     * an unconditional effect or the consequent of a conditional effect of an action.
     * </p>
     * An initial fact, which is a negative ground inertia, is never made FALSE and thus always
     * satisfied in all reachable world states. It can be removed from the state description. All
     * its occurrences in the preconditions of actions and in the antecedents of conditional effects
     * can be simplified to TRUE. A fact, which is a positive ground inertia and not contained in
     * the initial state, is never satisfied in any reachable world state. All its occurrences in
     * the preconditions of actions and in the antecedents of conditional effects can be simplified
     * to FALSE. The remaining facts are fluents that, roughly speaking, can possibly change their
     * truth value during the planning process. They are therefore relevant to the representation of
     * the planning problem.
     *
     * @param exp    the expression to simply.
     * @param effect a boolean to indicate if the expression is an effect or a precondition.
     * @param init   the initial state.
     */
    private static void simplifyWithGroundInertia(final IntExp exp, final boolean effect,
                                                  final Set<IntExp> init) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = Encoder.tableOfGroundInertia.get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                // An initial fact, which is a negative ground inertia, is never made FALSE and thus
                // always satisfied in all reachable world states. All its occurrences in the
                // preconditions of actions and in the
                // antecedents of conditional effects can be simplified to TRUE.
                if (!effect && (inertia.equals(Inertia.INERTIA) || inertia.equals(Inertia.NEGATIVE))
                    && init.contains(exp)) {
                    exp.setConnective(Connective.TRUE);
                } else if (!effect
                    && (inertia.equals(Inertia.INERTIA) || inertia.equals(Inertia.POSITIVE))
                    && !init.contains(exp)) {
                    // If the antecedent of a conditional effect becomes TRUE, the conditional
                    // effect
                    // becomes unconditional.
                    exp.setConnective(Connective.FALSE);
                }
                break;
            case AND:
                Iterator<IntExp> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(Connective.AND)) {
                    final IntExp ei = i.next();
                    PostInstantiation.simplifyWithGroundInertia(ei, effect, init);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(Connective.FALSE)) {
                        exp.setConnective(Connective.FALSE);
                    }
                    if (ei.getConnective().equals(Connective.TRUE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(Connective.OR)) {
                    final IntExp ei = i.next();
                    PostInstantiation.simplifyWithGroundInertia(ei, effect, init);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(Connective.TRUE)) {
                        exp.setConnective(Connective.TRUE);
                    }
                    if (ei.getConnective().equals(Connective.FALSE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
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
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(0), effect, init);
                break;
            case NOT:
                final IntExp neg = exp.getChildren().get(0);
                PostInstantiation.simplifyWithGroundInertia(neg, effect, init);
                if (!effect) {
                    if (neg.getConnective().equals(Connective.TRUE)) {
                        exp.setConnective(Connective.FALSE);
                    } else if (neg.getConnective().equals(Connective.FALSE)) {
                        exp.setConnective(Connective.TRUE);
                    }
                }
                break;
            case WHEN:
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(0), false, init);
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(1), true, init);
                break;
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
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(0), effect, init);
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(1), effect, init);
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(0), effect, init);
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(0), effect, init);
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(1), effect, init);
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(3), effect, init);
                break;
            case FN_ATOM:
            case NUMBER:
            case DURATION_ATOM:
            case TIME_VAR:
            case IS_VIOLATED:
            case MINIMIZE:
            case MAXIMIZE:
            case FN_HEAD:
            case EQUAL_ATOM:
                break;
            default:
                // do nothing
        }
    }

    /**
     * Do a pass over the effects of a specified list of instantiated operator and update the ground
     * inertia table.
     *
     * @param operators the list of instantiated operators.
     */
    static void extractGroundInertia(final List<IntOp> operators) {
        Encoder.tableOfGroundInertia = new LinkedHashMap<>(
            Constants.DEFAULT_RELEVANT_FACTS_TABLE);
        for (IntOp op : operators) {
            PostInstantiation.extractGroundInertia(op.getEffects());
        }

    }

    /**
     * Do a pass over the effects of an instantiated operator and update the ground inertia table.
     *
     * @param exp the effect.
     */
    private static void extractGroundInertia(final IntExp exp) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = Encoder.tableOfGroundInertia.get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                switch (inertia) {
                    case INERTIA:
                        Encoder.tableOfGroundInertia.put(exp, Inertia.NEGATIVE);
                        break;
                    case POSITIVE:
                        Encoder.tableOfGroundInertia.put(exp, Inertia.FLUENT);
                        break;
                    default:
                        // do nothing
                }
                break;
            case AND:
            case OR:
                exp.getChildren().forEach(PostInstantiation::extractGroundInertia);
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
                PostInstantiation.extractGroundInertia(exp.getChildren().get(0));
                break;
            case WHEN:
                PostInstantiation.extractGroundInertia(exp.getChildren().get(1));
                break;
            case NOT:
                final IntExp neg = exp.getChildren().get(0);
                if (neg.getConnective().equals(Connective.ATOM)) {
                    inertia = Encoder.tableOfGroundInertia.get(neg);
                    if (inertia == null) {
                        inertia = Inertia.INERTIA;
                    }
                    switch (inertia) {
                        case INERTIA:
                            Encoder.tableOfGroundInertia.put(neg, Inertia.POSITIVE);
                            break;
                        case NEGATIVE:
                            Encoder.tableOfGroundInertia.put(neg, Inertia.FLUENT);
                            break;
                        default:
                            // do nothing
                    }
                }
                break;
            case F_EXP_T:
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
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case ALWAYS_WITHIN:
            case HOLD_DURING:
            case TIME_VAR:
            case IS_VIOLATED:
            case NUMBER:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case F_EXP:
                break;
            default:
                // do nothing
        }
    }

    /**
     * Extracts "increase" expression and assigns value to the BitOp cost.
     *
     * @param operators       the list of operators.
     * @param functionAndCost functions and associed costs
     */
    static void simplifyIncrease(final List<IntOp> operators, final Map<IntExp, Double> functionAndCost) {
        for (IntOp op : operators) {
            PostInstantiation.simplifyIncreaseAssignCost(op, op.getEffects(), functionAndCost);
        }
    }

    //TODO Deal with WHEN, FORALL etc.

    /**
     * Do a pass over the effects of an instantiated operator and update the ground inertia table.
     *
     * @param exp             the effect.
     * @param functionAndCost functions and associed costs
     */
    private static void simplifyIncreaseAssignCost(final IntOp op,
                                                   final IntExp exp,
                                                   final Map<IntExp, Double> functionAndCost) {
        switch (exp.getConnective()) {
            case ATOM:
                break;
            case AND:
                Iterator<IntExp> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(Connective.AND)) {
                    final IntExp ei = i.next();
                    PostInstantiation.simplifyIncreaseAssignCost(op, ei, functionAndCost);
                    // If a child expression is INCREASE, we remove it
                    if (ei.getConnective().equals(Connective.INCREASE)) {
                        i.remove();
                    }
                }
                break;
            case OR:
                break;
            case FORALL:
                break;
            case EXISTS:
                break;
            case AT_START:
                break;
            case AT_END:
                break;
            case WHEN:
                break;
            case NOT:
                break;
            case F_EXP_T:
                break;
            case EQUAL_ATOM:
                break;
            case FN_HEAD:
                break;
            case FN_ATOM:
                break;
            case DURATION_ATOM:
                break;
            case LESS:
                break;
            case LESS_OR_EQUAL:
                break;
            case EQUAL:
                break;
            case GREATER:
                break;
            case GREATER_OR_EQUAL:
                break;
            case ASSIGN:
                break;
            case INCREASE:
                if (functionAndCost.containsKey(exp.getChildren().get(1))) {
                    op.setCost(functionAndCost.get(exp.getChildren().get(1)));
                } else {
                    op.setCost(exp.getChildren().get(1).getValue());
                }
                break;
            case DECREASE:
                break;
            case SCALE_UP:
                break;
            case SCALE_DOWN:
                break;
            case MUL:
                break;
            case DIV:
                break;
            case MINUS:
                break;
            case PLUS:
                break;
            case SOMETIME_AFTER:
                break;
            case SOMETIME_BEFORE:
                break;
            case WITHIN:
                break;
            case HOLD_AFTER:
                break;
            case ALWAYS_WITHIN:
                break;
            case HOLD_DURING:
                break;
            case TIME_VAR:
                break;
            case IS_VIOLATED:
                break;
            case NUMBER:
                break;
            case MINIMIZE:
                break;
            case MAXIMIZE:
                break;
            case UMINUS:
                break;
            case ALWAYS:
                break;
            case OVER_ALL:
                break;
            case SOMETIME:
                break;
            case AT_MOST_ONCE:
                break;
            case F_EXP:
                break;
            default:
                // do nothing
        }
    }
}
