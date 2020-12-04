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

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.problem.operator.Constants;
import fr.uga.pddl4j.problem.operator.IntExpression;
import fr.uga.pddl4j.problem.operator.IntAction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class contains all the methods needed to the instantiate the actions of a problem.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public abstract class InstantiatedProblem extends PreInstantiatedProblem {

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
     * @param domain the domain.
     * @param problem the problem.
     */
    public InstantiatedProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
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
    protected Map<IntExpression, Inertia> getNumericGroundInertia() {
        return this.numericGroundInertia;
    }

    /**
     * Instantiates a specified list of actions.
     *
     * @return the list of instantiated actions.
     */
    protected void instantiateActions() {
        final List<IntAction> instActions = new ArrayList<>(Constants.DEFAULT_ACTION_TABLE_SIZE);
        for (IntAction a : this.getIntActions()) {
            // If an action has a parameter with a empty domain the action must be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < a.arity() && toInstantiate) {
                toInstantiate = !this.getDomains().get(a.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (toInstantiate) {
                instActions.addAll(this.instantiate(a));
            }
        }
        this.getIntActions().clear();
        this.getIntActions().addAll(instActions);
    }

    /**
     * Instantiates a specified action.
     *
     * @param action the action to instantiate.
     * @param bound  the bound of actions to instantiate.
     * @return the list of actions instantiated corresponding the specified action.
     */
    private List<IntAction> instantiate(final IntAction action, final int bound) {
        final List<IntAction> instOps = new ArrayList<>(100);
        this.expandQuantifiedExpression(action.getPreconditions(), true);
        this.simplify(action.getPreconditions());
        if (!action.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
            this.expandQuantifiedExpression(action.getEffects(), true);
            this.simplify(action.getEffects());
            if (!action.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                this.instantiate(action, 0, bound, instOps);
            }
        }
        return instOps;
    }

    /**
     * Instantiates a specified action.
     *
     * @param action the action to instantiate.
     * @return the list of actions instantiated corresponding the specified action.
     */
    private List<IntAction> instantiate(final IntAction action) {
        return this.instantiate(action, Integer.MAX_VALUE);
    }


    /**
     * Instantiates a specified action.
     * <p>
     * The assumption is made that different action parameters are instantiated with different
     * constants, i.e., the planner never generates actions like move(a,a) because we consider this
     * as a bad domain representation that should be revised. In fact, in actions with identical
     * constant parameters, all but one of the constants are superfluous and can be skipped from the
     * representation without loss of information. Warning this assumption make the process no-sound.
     * </p>
     *
     * @param action  the action.
     * @param index   the index of the parameter to instantiate.
     * @param bound   the bound of actions to instantiate.
     * @param actions the list of actions already instantiated.
     * @see IntAction
     */
    private void instantiate(final IntAction action, final int index, final int bound,
                                    final List<IntAction> actions) {
        if (bound == actions.size()) {
            return;
        }
        final int arity = action.arity();
        if (index == arity) {
            final IntExpression precond = action.getPreconditions();
            this.simplify(precond);
            if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                final IntExpression effect = action.getEffects();
                this.simplify(effect);
                if (!effect.getConnective().equals(PDDLConnective.FALSE)) {
                    actions.add(action);
                }
            }
        } else {
            final Set<Integer> values = this.getDomains().get(action.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntExpression precond = new IntExpression(action.getPreconditions());
                this.substitute(precond, varIndex, value, true);
                if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntExpression effects = new IntExpression(action.getEffects());
                    this.substitute(effects, varIndex, value, true);
                    if (!effects.getConnective().equals(PDDLConnective.FALSE)) {
                        final IntAction copy = new IntAction(action.getName(), arity);
                        copy.setPreconditions(precond);
                        copy.setEffects(effects);
                        for (int i = 0; i < arity; i++) {
                            copy.setTypeOfParameter(i, action.getTypeOfParameters(i));
                        }
                        for (int i = 0; i < index; i++) {
                            copy.setValueOfParameter(i, action.getValueOfParameter(i));
                        }
                        if (action.isDurative()) {
                            final IntExpression duration = new IntExpression(action.getDuration());
                            this.substitute(duration, varIndex, value, true);
                            copy.setDuration(duration);
                        }
                        copy.setValueOfParameter(index, value);
                        this.instantiate(copy, index + 1, bound, actions);
                    }
                }
            }
        }
    }


    /**
     * Do a pass over the effects of a specified list of instantiated actions and update the ground
     * inertia table.
     *
     */
    protected void extractGroundInertia() {
        this.groundInertia = new LinkedHashMap<>(Constants.DEFAULT_RELEVANT_FACTS_TABLE_SIZE);
        for (IntAction a : this.getIntActions()) {
            extractGroundInertia(a.getEffects());
        }
    }

    /**
     * Instantiate the goal.
     */
    protected void instantiateGoal() {
        // Expand the quantified expression in the goal
        this.expandQuantifiedExpression(this.getIntGoal(), true);
    }

    /**
     * Simplify a specified goal expression based on the ground inertia information.
     *
     */
    protected void simplifyGoalWithGroundInertia() {
        this.simplifyWithGroundInertia(this.getIntGoal(), false);
        this.simplifyWithGroundNumericInertia(this.getIntGoal(), false);
        this.simplify(this.getIntGoal());
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
                this.getNumericGroundInertia().put(exp.getChildren().get(0), Inertia.FLUENT);
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
                    && this.getIntInitPredicates().contains(exp)) {
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (!effect
                    && (inertia.equals(Inertia.INERTIA) || inertia.equals(Inertia.POSITIVE))
                    && !this.getIntInitPredicates().contains(exp)) {
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
                Inertia inertia = this.getNumericGroundInertia().get(exp);
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

}
