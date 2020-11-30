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
     * Extracts the relevant facts from the instantiated actions. A ground fact is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fact and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fact and not a positive ground inertia.</li>
     * </ul>
     *
     * @param actions the list of instantiated actions.
     * @param methods the list of instantiated methods
     * @param init    the initial state.
     */
    static void extractRelevantFacts(final List<IntAction> actions, List<IntMethod> methods,
                                     final Set<IntExpression> init) {
        final Set<IntExpression> facts = new LinkedHashSet<>(10000);
        for (IntAction a : actions) {
            extractRelevantFacts(a.getPreconditions(), facts, init);
            extractRelevantFacts(a.getEffects(), facts, init);
        }
        for (IntMethod m : methods) {
            extractRelevantFacts(m.getPreconditions(), facts, init);
        }
        for (IntExpression p : init) {
            Inertia inertia = Encoder.tableOfGroundInertia.get(p);
            if (inertia == null) {
                inertia = Inertia.INERTIA;
            }
            if (init.contains(p) && !inertia.equals(Inertia.NEGATIVE)) {
                facts.add(p);
            }
        }
        Encoder.tableOfRelevantFluents = new ArrayList<>(facts.size());
        for (IntExpression exp : facts) {
            final IntExpression relevant = new IntExpression(exp);
            Encoder.tableOfRelevantFluents.add(relevant);
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
     * @param facts the set of relevant facts.
     * @param init  the initial state.
     */
    private static void extractRelevantFacts(final IntExpression exp, final Set<IntExpression> facts,
                                             final Set<IntExpression> init) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = Encoder.tableOfGroundInertia.get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                if ((init.contains(exp) && !inertia.equals(Inertia.NEGATIVE))
                    || (!init.contains(exp) && !inertia.equals(Inertia.POSITIVE))) {
                    facts.add(exp);
                }
                break;
            case FN_HEAD:
                break;
            case EQUAL_ATOM:
                break;
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    PostInstantiation.extractRelevantFacts(e, facts, init);
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
                extractRelevantFacts(exp.getChildren().get(0), facts, init);
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
                extractRelevantFacts(exp.getChildren().get(0), facts, init);
                extractRelevantFacts(exp.getChildren().get(1), facts, init);
                break;
            case F_EXP_T:
            case F_EXP:
                if (!exp.getChildren().isEmpty()) {
                    extractRelevantFacts(exp.getChildren().get(0), facts, init);
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                extractRelevantFacts(exp.getChildren().get(0), facts, init);
                extractRelevantFacts(exp.getChildren().get(1), facts, init);
                extractRelevantFacts(exp.getChildren().get(3), facts, init);
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

    // *********************************************************************************************
    // Methods for extracting from the instantiated actions the ground inertia.
    // *********************************************************************************************

    /**
     * Do a pass over the preconditions and the effects of all the instantiated actions and update the ground inertia
     * table. Then, simplify the actions according to the extracted ground inertia.
     *
     * @param actions the list of actions to simplified.
     * @param init    the initial state.
     */
    static void simplyActionsWithGroundInertia(final List<IntAction> actions, final Set<IntExpression> init) {
        //static void simplyActionsWithGroundInertia(final List<IntAction> actions, final List<IntMethod> methods,
        //    final Set<IntExpression> init) {

        final List<IntAction> toAdd = new ArrayList<>(actions.size());
        final Set<Integer> toRemove = new HashSet<>(actions.size());
        int index = 0;
        for (IntAction a : actions) {
            if (a.isDurative()) {
                PostInstantiation.simplifyWithGroundNumericInertia(a.getDuration(), false);
                if (a.getDuration().getConnective().equals(PDDLConnective.FALSE)) {
                    toRemove.add(index);
                    index++;
                    continue;
                }
            }
            PostInstantiation.simplifyWithGroundInertia(a.getPreconditions(), false, init);
            // ADD to symplified Numeric function
            PostInstantiation.simplifyWithGroundNumericInertia(a.getPreconditions(), false);
            PostInstantiation.simplify(a.getPreconditions());
            if (!a.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                PostInstantiation.simplifyWithGroundInertia(a.getEffects(), true, init);
                // ADD for numeric fluents
                PostInstantiation.simplifyWithGroundNumericInertia(a.getEffects(), true);
                PostInstantiation.simplify(a.getEffects());
                if (!a.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                    toAdd.add(a);
                } else {
                    toRemove.add(index);
                }
            } else {
                toRemove.add(index);
            }
            index++;
        }
        //System.out.println("--" +toAdd.size());
        //System.out.println("--" +toRemove.size());
        //System.out.println("--" +actions.size());


        // Simplification for HTN
        if (Encoder.relevantActions != null) {
            final Set<IntExpression> primitiveTasksNoMoreReachable = new HashSet<IntExpression>();
            // Update the relevant actions for the tasks
            for (int i = 0; i < Encoder.relevantActions.size(); i++) {
                if (toRemove.contains(Encoder.relevantActions.get(i))) {
                    primitiveTasksNoMoreReachable.add(Encoder.tableOfRelevantPrimitiveTasks.remove(i));
                    Encoder.relevantActions.remove(i);
                    i--;
                } else {
                    Encoder.relevantActions.set(i, i);
                }
            }
        }

        actions.clear();
        actions.addAll(toAdd);
    }


    /**
     * Simply recursively the methods by removing unreachable tasks.
     *
     * @param methods the list of method to simplify.
     * @param tasks   the set of compound tasks which are no more reachable.
     * @return the list of task no more reachable.
     */
    private static void simplyRecursivelyMethodsWithTasksNoMoreReachable(final List<IntMethod> methods,
                                                                         final Set<IntExpression> tasks) {
        while (!tasks.isEmpty()) {
            PostInstantiation.simplyMethodsWithTasksNoMoreReachable(methods, tasks);
        }
    }

    /**
     * Simply the method by removing unreachable tasks.
     *
     * @param methods the list of method to simplify.
     * @param tasks   the set of compound tasks which are no more reachable.
     * @return the list of task no more reachable.
     */
    private static void simplyMethodsWithTasksNoMoreReachable(final List<IntMethod> methods,
                                                              final Set<IntExpression> tasks) {
        final Set<IntExpression> tasksNoMoreReachable = new LinkedHashSet<>();
        for (int i = 0; i < methods.size(); i++) {
            final IntMethod method = methods.get(i);
            if (PostInstantiation.isSimplified(method, tasks)) {
                methods.remove(i);
                for (int j = 0; j < Encoder.relevantMethods.size(); j++) {
                    final List<Integer> relevant = Encoder.relevantMethods.get(j);
                    if (relevant.remove(new Integer(i))) {
                        //System.out.println("remove " + i);
                        PostInstantiation.updateRelevantMethods(i);
                        // There is no more relevant method for the compound task
                        if (relevant.isEmpty()) {
                            tasksNoMoreReachable.add(Encoder.tableOfRelevantCompundTasks.get(j));
                            Encoder.tableOfRelevantCompundTasks.remove(j);
                            Encoder.relevantMethods.remove(j);
                            //System.out.println("A task is no more reachable");
                            j--;
                        }
                        break;
                    }
                }
                i--;
            }
        }
        tasks.clear();
        tasks.addAll(tasksNoMoreReachable);
    }

    /**
     * Returns if a method can be simplified. A method can be simplified if it is relevant for a task that is no more
     * reachable or has a child that is no more reachable. The set of no more reachable set of tasks is given as
     * parameter of the methods.
     *
     * @param method the method to test.
     * @param tasks  the set of tasks that are no more reachable.
     * @return <code>true</code> if the method is simplified, <code>false</code>
     */
    private static boolean isSimplified(IntMethod method, Set<IntExpression> tasks) {
        boolean isSimplified = true;
        if (!tasks.contains(method.getTask())) {
            final List<IntExpression> subtasks = method.getSubTasks().getChildren();
            final Iterator<IntExpression> i = subtasks.iterator();
            isSimplified = false;
            while (i.hasNext() && !isSimplified) {
                isSimplified = tasks.contains(i.next());
            }
        }
        return isSimplified;
    }

    /**
     * Update the index of the relevant method when a method is removed.
     *
     * @param index the index of the method removed.
     */
    private static void updateRelevantMethods(final int index) {
        for (List<Integer> relevant : Encoder.relevantMethods) {
            int i = 0;
            for (Integer m : relevant) {
                if (m > index) {
                    relevant.set(i, --m);
                }
                i++;
            }

        }
    }

    /**
     * Do a pass over the preconditions of all the instantiated methods and update the ground inertia
     * table. Then, simplify the methods according to the extracted ground inertia.
     *
     * @param methods the list of methods to simplified.
     * @param init    the initial state.
     */
    static void simplyMethodsWithGroundInertia(final List<IntMethod> methods, final Set<IntExpression> init) {
        final List<IntMethod> toAdd = new ArrayList<>(methods.size());
        final Set<IntExpression> toRemove = new HashSet<>();
        for (IntMethod m : methods) {
            PostInstantiation.simplifyWithGroundInertia(m.getPreconditions(), false, init);
            PostInstantiation.simplify(m.getPreconditions());
            if (!m.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                toAdd.add(m);
            } else {
                toRemove.add(m.getTask());
            }
        }
        PostInstantiation.simplyRecursivelyMethodsWithTasksNoMoreReachable(methods, toRemove);
    }

    /**
     * Simplify a specified goal expression based on the ground inertia information.
     *
     * @param goal the expression to simply.
     * @param init the initial state.
     */
    static void simplifyGoalWithGroundInertia(final IntExpression goal, final Set<IntExpression> init) {
        PostInstantiation.simplifyWithGroundInertia(goal, false, init);
        PostInstantiation.simplifyWithGroundNumericInertia(goal, false);
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
    private static void simplifyWithGroundInertia(final IntExpression exp, final boolean effect,
                                                  final Set<IntExpression> init) {
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
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (!effect
                    && (inertia.equals(Inertia.INERTIA) || inertia.equals(Inertia.POSITIVE))
                    && !init.contains(exp)) {
                    // If the antecedent of a conditional effect becomes TRUE, the conditional
                    // effect
                    // becomes unconditional.
                    exp.setConnective(PDDLConnective.FALSE);
                }
                break;
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    PostInstantiation.simplifyWithGroundInertia(ei, effect, init);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    }
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    PostInstantiation.simplifyWithGroundInertia(ei, effect, init);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
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
                final IntExpression neg = exp.getChildren().get(0);
                PostInstantiation.simplifyWithGroundInertia(neg, effect, init);
                if (!effect) {
                    if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.TRUE);
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
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(0), effect, init);
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(1), effect, init);
                break;
            case F_EXP_T:
            case F_EXP:
                PostInstantiation.simplifyWithGroundInertia(exp.getChildren().get(0), effect, init);
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
     * Do a pass over the effects of a specified list of instantiated actions and update the ground
     * inertia table.
     *
     * @param actions the list of instantiated actions.
     */
    static void extractGroundInertia(final List<IntAction> actions) {
        Encoder.tableOfGroundInertia = new LinkedHashMap<>(Constants.DEFAULT_RELEVANT_FACTS_TABLE_SIZE);
        for (IntAction a : actions) {
            extractGroundInertia(a.getEffects());
        }
    }

    /**
     * Do a pass over the effects of an instantiated action and update the ground inertia table.
     *
     * @param exp the effect.
     */
    private static void extractGroundInertia(final IntExpression exp) {
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
                extractGroundInertia(exp.getChildren().get(0));
                break;
            case WHEN:
                extractGroundInertia(exp.getChildren().get(1));
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                if (neg.getConnective().equals(PDDLConnective.ATOM)) {
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
     * Do a pass over the effects of a specified list of instantiated actions and update the ground
     * inertia table.
     *
     * @param actions the list of instantiated actions.
     */
    static void extractGroundNumericInertia(final List<IntAction> actions) {
        Encoder.tableOfNumericGroundInertia = new LinkedHashMap<>(Constants.DEFAULT_RELEVANT_FACTS_TABLE_SIZE);
        for (IntAction a : actions) {
            PostInstantiation.extractGroundNumericInertia(a.getEffects());
        }
    }

    /**
     * Do a pass over the effects of an instantiated action and update the ground numeric inertia table.
     * A numeric inertia is a function that is never change by any action of the problem.
     * PDDLConnetive checks.
     *
     * @param exp the effect.
     */
    private static void extractGroundNumericInertia(final IntExpression exp) {
        switch (exp.getConnective()) {
            case AND:
                exp.getChildren().forEach(PostInstantiation::extractGroundNumericInertia);
                break;
            case WHEN:
                extractGroundNumericInertia(exp.getChildren().get(1));
                break;
            case NOT:
                extractGroundNumericInertia(exp.getChildren().get(0));
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                Encoder.tableOfNumericGroundInertia.put(exp.getChildren().get(0), Inertia.FLUENT);
                break;
            case ATOM:
            case TRUE:
            case FALSE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().getImage());
        }
    }


    /**
     * Simplify a specified expression based on the ground inertia information.
     *
     *
     * @param exp    the expression to simply.
     * @param effect a boolean to indicate if the expression is an effect or a precondition.
     */
    private static void simplifyWithGroundNumericInertia(final IntExpression exp, final boolean effect) {
        //System.out.println(exp.getConnective() + " " + Encoder.toString(exp));
        switch (exp.getConnective()) {
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    PostInstantiation.simplifyWithGroundNumericInertia(ei, effect);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    PostInstantiation.simplifyWithGroundNumericInertia(ei, effect);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    } else if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                PostInstantiation.simplifyWithGroundNumericInertia(neg, effect);
                if (!effect) {
                    if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case WHEN:
                PostInstantiation.simplifyWithGroundNumericInertia(exp.getChildren().get(0), false);
                PostInstantiation.simplifyWithGroundNumericInertia(exp.getChildren().get(1), true);
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                PostInstantiation.simplifyWithGroundNumericInertia(exp.getChildren().get(1), effect);
                if (exp.getChildren().get(1).getConnective().equals(PDDLConnective.FALSE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                    exp.getChildren().clear();
                }
                break;
            case PLUS:
            case MINUS:
            case MUL:
            case DIV:
                IntExpression op1 = exp.getChildren().get(0);
                IntExpression op2 = exp.getChildren().get(1);
                PostInstantiation.simplifyWithGroundNumericInertia(op1, effect);
                PostInstantiation.simplifyWithGroundNumericInertia(op2, effect);
                if (op1.getConnective().equals(PDDLConnective.FALSE)
                    || op2.getConnective().equals(PDDLConnective.FALSE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                    exp.getChildren().clear();
                } else if (op1.getConnective().equals(PDDLConnective.NUMBER)
                        && op2.getConnective().equals(PDDLConnective.NUMBER)) {
                    switch (exp.getConnective()) {
                        case PLUS:
                            exp.setValue(op1.getValue() + op2.getValue());
                            break;
                        case MINUS:
                            exp.setValue(op1.getValue() - op2.getValue());
                            break;
                        case MUL:
                            exp.setValue(op1.getValue() * op2.getValue());
                            break;
                        case DIV:
                            exp.setValue(op1.getValue() / op2.getValue());
                            break;
                    }
                    exp.setConnective(PDDLConnective.NUMBER);

                }
                break;
            case UMINUS:
                op1 = exp.getChildren().get(0);
                if (op1.getConnective().equals(PDDLConnective.NUMBER)) {
                    exp.setConnective(PDDLConnective.NUMBER);
                    exp.setValue(-op1.getValue());
                    exp.getChildren().clear();
                } else if (op1.getConnective().equals(PDDLConnective.FALSE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                    exp.getChildren().clear();
                }
                break;
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
                op1 = exp.getChildren().get(0);
                op2 = exp.getChildren().get(1);
                PostInstantiation.simplifyWithGroundNumericInertia(op1, effect);
                PostInstantiation.simplifyWithGroundNumericInertia(op2, effect);
                if (op1.getConnective().equals(PDDLConnective.FALSE)
                        || op2.getConnective().equals(PDDLConnective.FALSE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                    exp.getChildren().clear();
                } else if (op1.getConnective().equals(PDDLConnective.NUMBER)
                        && op2.getConnective().equals(PDDLConnective.NUMBER)) {
                    switch (exp.getConnective()) {
                        case LESS:
                            if (op1.getValue() < op2.getValue()) {
                                exp.setConnective(PDDLConnective.TRUE);
                            } else {
                                exp.setConnective(PDDLConnective.FALSE);
                            }
                            break;
                        case LESS_OR_EQUAL:
                            if (op1.getValue() <= op2.getValue()) {
                                exp.setConnective(PDDLConnective.TRUE);
                            } else {
                                exp.setConnective(PDDLConnective.FALSE);
                            }
                            break;
                        case GREATER:
                            if (op1.getValue() > op2.getValue()) {
                                exp.setConnective(PDDLConnective.TRUE);
                            } else {
                                exp.setConnective(PDDLConnective.FALSE);
                            }
                            break;
                        case GREATER_OR_EQUAL:
                            if (op1.getValue() >= op2.getValue()) {
                                exp.setConnective(PDDLConnective.TRUE);
                            } else {
                                exp.setConnective(PDDLConnective.FALSE);
                            }
                            break;
                        case EQUAL:
                            if (op1.getValue() == op2.getValue()) {
                                exp.setConnective(PDDLConnective.TRUE);
                            } else {
                                exp.setConnective(PDDLConnective.FALSE);
                            }
                            break;
                    }
                }
                break;
            case F_EXP:
                IntExpression fexp = exp.getChildren().get(0);
                PostInstantiation.simplifyWithGroundNumericInertia(fexp, effect);
                if (fexp.getConnective().equals(PDDLConnective.NUMBER)) {
                    exp.setValue(fexp.getValue());
                    exp.setConnective(PDDLConnective.NUMBER);
                    exp.getChildren().clear();
                } else if (fexp.getConnective().equals(PDDLConnective.FALSE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                    exp.getChildren().clear();
                }
                break;
            case FN_HEAD:
                Inertia inertia = Encoder.tableOfNumericGroundInertia.get(exp);
                if (inertia == null) {
                    Double value = Encoder.intInitFunctionCost.get(exp);
                    // The numeric fluent is never modified and does not appear in the initial state
                    if (value == null) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else {
                        exp.setConnective(PDDLConnective.NUMBER);
                        exp.setValue(value);
                    }
                }
                break;
            case NUMBER:
            case TIME_VAR:
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
     * Extracts "increase" expression and assigns value to the BitOp cost.
     *
     * @param actions         the list of actions.
     * @param functionAndCost functions and associed costs
     */
    static void simplifyIncrease(final List<IntAction> actions, final Map<IntExpression, Double> functionAndCost) {
        for (IntAction a : actions) {
            PostInstantiation.simplifyIncreaseAssignCost(a, a.getEffects(), functionAndCost);
        }
    }

    /**
     * Do a pass over the effects of an instantiated action and update the ground inertia table.
     * Warning this method deal only with AND expression for the moment.
     *
     * @param exp             the effect.
     * @param functionAndCost functions and associed costs
     */
    private static void simplifyIncreaseAssignCost(final IntAction action,
                                                   final IntExpression exp,
                                                   final Map<IntExpression, Double> functionAndCost) {
        switch (exp.getConnective()) {
            case ATOM:
                break;
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    PostInstantiation.simplifyIncreaseAssignCost(action, ei, functionAndCost);
                    // If a child expression is INCREASE, we remove it
                    if (ei.getConnective().equals(PDDLConnective.INCREASE)) {
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
                    action.setCost(functionAndCost.get(exp.getChildren().get(1)));
                } else {
                    action.setCost(exp.getChildren().get(1).getValue());
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
