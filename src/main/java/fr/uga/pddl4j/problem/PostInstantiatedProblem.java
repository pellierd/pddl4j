/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.problem.operator.Constants;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.IntExpression;
import fr.uga.pddl4j.problem.operator.IntMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class contains all the methods needed to the postinstantiation treatment. In particular, all the methods to
 * simplify actions and methods that cannot be triggered. These simplifications are based on the construction of the
 * planning graph of the problem and on the concept of inertia introduced by J. Koehler.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public abstract class PostInstantiatedProblem extends InstantiatedProblem {

    /**
     * The table that contains the ground inertia.
     */
    private Map<IntExpression, Inertia> groundInertia;

    /**
     * The table that contains the ground inertia.
     */
    private Map<IntExpression, Inertia> numericGroundInertia;

    /**
     * Creates a new problem from a domain and problem.
     *
     * @param problem the problem.
     */
    public PostInstantiatedProblem(final ParsedProblem problem) {
        super(problem);
    }


    /**
     * Return the list of ground inertia of the problem.
     *
     * @return the list of ground inertia of the problem.
     */
    protected Map<IntExpression, Inertia> getGroundInertia() {
        return this.groundInertia;
    }

    /**
     * Return the list of numeric ground inertia of the problem.
     *
     * @return the list of numeric ground inertia of the problem.
     */
    protected Map<IntExpression, Inertia> getGroundNumericInertia() {
        return this.numericGroundInertia;
    }


    /**
     * Do a pass over the effects of a specified list of instantiated actions and update the ground
     * inertia table.
     */
    protected void extractGroundInertia() {
        this.groundInertia = new LinkedHashMap<>(Constants.DEFAULT_RELEVANT_FACTS_TABLE_SIZE);
        for (IntAction a : this.getIntActions()) {
            extractGroundInertia(a.getEffects());
        }
    }

    /**
     * Do a pass over the effects of an instantiated action and update the ground inertia table.
     *
     * @param exp the effect.
     */
    private void extractGroundInertia(final IntExpression exp) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = this.groundInertia.get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                switch (inertia) {
                    case INERTIA:
                        this.groundInertia.put(exp, Inertia.NEGATIVE);
                        break;
                    case POSITIVE:
                        this.groundInertia.put(exp, Inertia.FLUENT);
                        break;
                    default:
                        // do nothing
                }
                break;
            case AND:
            case OR:
                exp.getChildren().forEach(this::extractGroundInertia);
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
                    inertia = this.groundInertia.get(neg);
                    if (inertia == null) {
                        inertia = Inertia.INERTIA;
                    }
                    switch (inertia) {
                        case INERTIA:
                            this.groundInertia.put(neg, Inertia.POSITIVE);
                            break;
                        case NEGATIVE:
                            this.groundInertia.put(neg, Inertia.FLUENT);
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
     * Simplify a specified goal expression based on the ground inertia information.
     */
    protected void simplifyGoalWithGroundInertia() {
        this.simplifyWithGroundInertia(this.getIntGoal(), false);
        this.simplifyWithGroundNumericInertia(this.getIntGoal(), false);
        this.simplify(this.getIntGoal());
    }

    /**
     * Do a pass over the effects of a specified list of instantiated actions and update the ground
     * inertia table.
     */
    protected void extractGroundNumericInertia() {
        this.numericGroundInertia = new LinkedHashMap<>(Constants.DEFAULT_RELEVANT_FACTS_TABLE_SIZE);
        for (IntAction a : this.getIntActions()) {
            this.extractGroundNumericInertia(a.getEffects());
        }
    }

    /**
     * Do a pass over the effects of an instantiated action and update the ground numeric inertia table.
     * A numeric inertia is a function that is never change by any action of the problem.
     * PDDLConnetive checks.
     *
     * @param exp the effect.
     */
    private void extractGroundNumericInertia(final IntExpression exp) {
        switch (exp.getConnective()) {
            case AND:
                exp.getChildren().forEach(this::extractGroundNumericInertia);
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
                this.getGroundNumericInertia().put(exp.getChildren().get(0), Inertia.FLUENT);
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
     * Do a pass over the preconditions and the effects of all the instantiated actions and update the ground inertia
     * table. Then, simplify the actions according to the extracted ground inertia.*
     */
    protected void simplyActionsWithGroundInertia() {

        final List<IntAction> toAdd = new ArrayList<>(this.getIntActions().size());
        final Set<Integer> toRemove = new HashSet<>(this.getIntActions().size());
        int index = 0;
        for (IntAction a : this.getIntActions()) {
            if (a.isDurative()) {
                this.simplifyWithGroundNumericInertia(a.getDuration(), false);
                if (a.getDuration().getConnective().equals(PDDLConnective.FALSE)) {
                    toRemove.add(index);
                    index++;
                    continue;
                }
            }
            this.simplifyWithGroundInertia(a.getPreconditions(), false);
            // ADD to symplified Numeric function
            this.simplifyWithGroundNumericInertia(a.getPreconditions(), false);
            this.simplify(a.getPreconditions());
            if (!a.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                this.simplifyWithGroundInertia(a.getEffects(), true);
                // ADD for numeric fluents
                this.simplifyWithGroundNumericInertia(a.getEffects(), true);
                this.simplify(a.getEffects());
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

        // Simplification for HTN
        /*if (this.relevantActions != null) {
            final Set<IntExpression> primitiveTasksNoMoreReachable = new HashSet<IntExpression>();
            // Update the relevant actions for the tasks
            for (int i = 0; i < this.relevantActions.size(); i++) {
                if (toRemove.contains(this.relevantActions.get(i))) {
                    primitiveTasksNoMoreReachable.add(this.tableOfRelevantPrimitiveTasks.remove(i));
                    this.relevantActions.remove(i);
                    i--;
                } else {
                    this.relevantActions.set(i, i);
                }
            }
        }*/


        this.getIntActions().clear();
        this.getIntActions().addAll(toAdd);
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
     */
    protected void simplifyWithGroundInertia(final IntExpression exp, final boolean effect) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = this.getGroundInertia().get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                // An initial fact, which is a negative ground inertia, is never made FALSE and thus
                // always satisfied in all reachable world states. All its occurrences in the
                // preconditions of actions and in the
                // antecedents of conditional effects can be simplified to TRUE.
                if (!effect && (inertia.equals(Inertia.INERTIA) || inertia.equals(Inertia.NEGATIVE))
                    && this.getIntInitialState().contains(exp)) {
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (!effect
                    && (inertia.equals(Inertia.INERTIA) || inertia.equals(Inertia.POSITIVE))
                    && !this.getIntInitialState().contains(exp)) {
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
                    this.simplifyWithGroundInertia(ei, effect);
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
                    this.simplifyWithGroundInertia(ei, effect);
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
                this.simplifyWithGroundInertia(exp.getChildren().get(0), effect);
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                this.simplifyWithGroundInertia(neg, effect);
                if (!effect) {
                    if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case WHEN:
                this.simplifyWithGroundInertia(exp.getChildren().get(0), false);
                this.simplifyWithGroundInertia(exp.getChildren().get(1), true);
                break;
            case EQUAL_ATOM:
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
                this.simplifyWithGroundInertia(exp.getChildren().get(0), effect);
                this.simplifyWithGroundInertia(exp.getChildren().get(1), effect);
                break;
            case F_EXP_T:
            case F_EXP:
                this.simplifyWithGroundInertia(exp.getChildren().get(0), effect);
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.simplifyWithGroundInertia(exp.getChildren().get(0), effect);
                this.simplifyWithGroundInertia(exp.getChildren().get(1), effect);
                this.simplifyWithGroundInertia(exp.getChildren().get(3), effect);
                break;
            case FN_ATOM:
            case NUMBER:
            case DURATION_ATOM:
            case TIME_VAR:
            case IS_VIOLATED:
            case MINIMIZE:
            case MAXIMIZE:
            case FN_HEAD:
                break;
            default:
                // do nothing
        }
    }


    /**
     * Simplify a specified expression based on the ground inertia information.
     *
     * @param exp    the expression to simply.
     * @param effect a boolean to indicate if the expression is an effect or a precondition.
     */
    private void simplifyWithGroundNumericInertia(final IntExpression exp, final boolean effect) {
        //System.out.println(exp.getConnective() + " " + Encoder.toString(exp));
        switch (exp.getConnective()) {
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    this.simplifyWithGroundNumericInertia(ei, effect);
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
                    this.simplifyWithGroundNumericInertia(ei, effect);
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
                this.simplifyWithGroundNumericInertia(neg, effect);
                if (!effect) {
                    if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case WHEN:
                this.simplifyWithGroundNumericInertia(exp.getChildren().get(0), false);
                this.simplifyWithGroundNumericInertia(exp.getChildren().get(1), true);
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                this.simplifyWithGroundNumericInertia(exp.getChildren().get(1), effect);
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
                this.simplifyWithGroundNumericInertia(op1, effect);
                this.simplifyWithGroundNumericInertia(op2, effect);
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
                        default:
                            throw new UnexpectedExpressionException(this.toString(exp));
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
                this.simplifyWithGroundNumericInertia(op1, effect);
                this.simplifyWithGroundNumericInertia(op2, effect);
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
                        default:
                            throw new UnexpectedExpressionException(this.toString(exp));
                    }
                }
                break;
            case F_EXP:
                IntExpression fexp = exp.getChildren().get(0);
                this.simplifyWithGroundNumericInertia(fexp, effect);
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
                Inertia inertia = this.getGroundNumericInertia().get(exp);
                if (inertia == null) {
                    Double value = this.getIntInitFunctionCost().get(exp);
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
     * Do a pass over the preconditions of all the instantiated methods and update the ground inertia
     * table. Then, simplify the methods according to the extracted ground inertia.
     */
    protected void simplyMethodsWithGroundInertia() {
        final List<IntMethod> toAdd = new ArrayList<>(this.getIntMethods().size());
        final Set<IntExpression> toRemove = new HashSet<>();
        for (IntMethod m : this.getIntMethods()) {
            this.simplifyWithGroundInertia(m.getPreconditions(), false);
            this.simplify(m.getPreconditions());
            if (!m.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                toAdd.add(m);
            } else {
                toRemove.add(m.getTask());
            }
        }
        this.simplyRecursivelyMethodsWithTasksNoMoreReachable(this.getIntMethods(), toRemove);
    }

    /**
     * Simply recursively the methods by removing unreachable tasks.
     *
     * @param methods the list of method to simplify.
     * @param tasks   the set of compound tasks which are no more reachable.
     * @return the list of task no more reachable.
     */
    private void simplyRecursivelyMethodsWithTasksNoMoreReachable(final List<IntMethod> methods,
                                                                  final Set<IntExpression> tasks) {
        while (!tasks.isEmpty()) {
            this.simplyMethodsWithTasksNoMoreReachable(methods, tasks);
        }
    }

    /**
     * Simply the method by removing unreachable tasks.
     *
     * @param methods the list of method to simplify.
     * @param tasks   the set of compound tasks which are no more reachable.
     * @return the list of task no more reachable.
     */
    private void simplyMethodsWithTasksNoMoreReachable(final List<IntMethod> methods,
                                                       final Set<IntExpression> tasks) {
        final Set<IntExpression> tasksNoMoreReachable = new LinkedHashSet<>();
        for (int i = 0; i < methods.size(); i++) {
            final IntMethod method = methods.get(i);
            if (this.isSimplified(method, tasks)) {
                methods.remove(i);
                for (int j = 0; j < this.getRelevantMethods().size(); j++) {
                    final List<Integer> relevant = this.getRelevantMethods().get(j);
                    if (relevant.remove(Integer.valueOf(i))) {
                        //System.out.println("remove " + i);
                        this.updateRelevantMethods(i);
                        // There is no more relevant method for the compound task
                        if (relevant.isEmpty()) {
                            tasksNoMoreReachable.add(this.getRelevantCompundTasks().get(j));
                            this.getRelevantCompundTasks().remove(j);
                            this.getRelevantMethods().remove(j);
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
    private boolean isSimplified(IntMethod method, Set<IntExpression> tasks) {
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
    private void updateRelevantMethods(final int index) {
        for (List<Integer> relevant : this.getRelevantMethods()) {
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
     * Returns a string representation of the internal data structure used during instantiation process.
     *
     * @param data the internal data structure.
     * @return a string representation of the internal data structure used during instantiation process.
     */
    protected String toString(final Data data) {
        final StringBuilder str = new StringBuilder();
        switch (data) {
            case GROUND_INERTIA:
                int i = 0;
                for (Map.Entry<IntExpression, Inertia> e : this.getGroundInertia().entrySet()) {
                    str.append(i);
                    str.append(": ");
                    str.append(this.toString(e.getKey()));
                    str.append(" : ");
                    str.append(e.getValue());
                    str.append(System.lineSeparator());
                    i++;
                }
                break;
            case GROUND_NUMERIC_INERTIA:
                i = 0;
                for (Map.Entry<IntExpression, Inertia> e : this.getGroundNumericInertia().entrySet()) {
                    str.append(i);
                    str.append(": ");
                    str.append(this.toString(e.getKey()));
                    str.append(" : ");
                    str.append(e.getValue());
                    str.append(System.lineSeparator());
                    i++;
                }
                break;
            default:
                return super.toString(data);
        }
        return str.toString();
    }
}
