package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;

import java.util.*;

/**
 * Created by pellier on 02/12/2020.
 */
public abstract class PostInstantiatedProblem extends InstantiatedProblem {

    /**
     * The table that contains the ground inertia.
     */
    private Map<IntExpression, Inertia> tableOfGroundInertia;

    /**
     * The table that contains the ground inertia.
     */
    private Map<IntExpression, Inertia> tableOfNumericGroundInertia;


    public PostInstantiatedProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }

    public void postInstantiate() {
        this.extractGroundInertia();
        this.extractGroundNumericInertia();
        this.simplyActionsWithGroundInertia();
    }


    public Map<IntExpression, Inertia> getTableOfGroundInertia() {
        return tableOfGroundInertia;
    }

    public Map<IntExpression, Inertia> getTableOfNumericGroundInertia() {
        return tableOfNumericGroundInertia;
    }

    /**
     * Do a pass over the effects of a specified list of instantiated actions and update the ground
     * inertia table.
     *
     */
    protected void extractGroundInertia() {
        this.tableOfGroundInertia = new LinkedHashMap<>(Constants.DEFAULT_RELEVANT_FACTS_TABLE_SIZE);
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
                Inertia inertia = this.tableOfGroundInertia.get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                switch (inertia) {
                    case INERTIA:
                        this.tableOfGroundInertia.put(exp, Inertia.NEGATIVE);
                        break;
                    case POSITIVE:
                        this.tableOfGroundInertia.put(exp, Inertia.FLUENT);
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
                    inertia = this.tableOfGroundInertia.get(neg);
                    if (inertia == null) {
                        inertia = Inertia.INERTIA;
                    }
                    switch (inertia) {
                        case INERTIA:
                            this.tableOfGroundInertia.put(neg, Inertia.POSITIVE);
                            break;
                        case NEGATIVE:
                            this.tableOfGroundInertia.put(neg, Inertia.FLUENT);
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
        this.tableOfNumericGroundInertia = new LinkedHashMap<>(Constants.DEFAULT_RELEVANT_FACTS_TABLE_SIZE);
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
                this.getTableOfNumericGroundInertia().put(exp.getChildren().get(0), Inertia.FLUENT);
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
    private void simplyActionsWithGroundInertia() {

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
    private void simplifyWithGroundInertia(final IntExpression exp, final boolean effect) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = Encoder.pb.getTableOfGroundInertia().get(exp);
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
                Inertia inertia = Encoder.pb.getTableOfNumericGroundInertia().get(exp);
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
                System.out.println(Encoder.toString(exp));
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
    }
}
