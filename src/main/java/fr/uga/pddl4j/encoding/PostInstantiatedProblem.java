package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.*;

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

    /**
     * The list of relevant methods for a specific task.
     */
    private List<List<Integer>> relevantMethods;

    /**
     * The list of relevant primitive tasks.
     */
    private List<IntExpression> tableOfRelevantPrimitiveTasks;

    /**
     * The list of relevant compund tasks.
     */
    private List<IntExpression> tableOfRelevantCompundTasks;

    /**
     * The list of relevant action for a specific task.
     */
    private List<Integer> relevantActions;

    /**
     * The table of the relevant fluents.
     */
    private List<IntExpression> tableOfRelevantFluents;

    /**
     * The table of the relevant fluents.
     */
    private List<IntExpression> tableOfRelevantNumericFluents;

    public PostInstantiatedProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }

    public void postInstantiate() {
        this.extractGroundInertia();
        this.extractGroundNumericInertia();
        this.simplyActionsWithGroundInertia();
        this.instantiateGoal();
        this.simplifyGoalWithGroundInertia();
        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.instantiateInitialTaskNetwork();
            this.instantiateMethods(this.getIntMethods(), this.getIntInitialTaskNetwork(), this.getIntActions());
            this.simplyMethodsWithGroundInertia();
        }
        this.extractRelevantFacts(this.getIntActions(), this.getIntMethods(), this.getIntInitPredicates());
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.extractRelevantNumericFluents(this.getIntActions(),this.getIntMethods());
        }

    }


    public Map<IntExpression, Inertia> getTableOfGroundInertia() {
        return tableOfGroundInertia;
    }

    public Map<IntExpression, Inertia> getTableOfNumericGroundInertia() {
        return tableOfNumericGroundInertia;
    }

    public List<IntExpression> getTableOfRelevantPrimitiveTasks() {
        return tableOfRelevantPrimitiveTasks;
    }

    public List<IntExpression> getTableOfRelevantCompundTasks() {
        return tableOfRelevantCompundTasks;
    }

    public List<Integer> getRelevantActions() {
        return relevantActions;
    }

    public List<List<Integer>> getRelevantMethods() {
        return relevantMethods;
    }

    public List<IntExpression> getTableOfRelevantFluents() {
        return tableOfRelevantFluents;
    }

    public List<IntExpression> getTableOfRelevantNumericFluents() {
        return tableOfRelevantNumericFluents;
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
                Inertia inertia = this.getTableOfGroundInertia().get(exp);
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
                Inertia inertia = this.getTableOfNumericGroundInertia().get(exp);
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

    protected void instantiateInitialTaskNetwork() {
        final List<IntTaskNetwork> taskNetworks = this.instantiate(this.getIntInitialTaskNetwork());
        if (taskNetworks.size() > 1) {
            IntExpression root = new IntExpression(PDDLConnective.TASK);
            root.setPredicate(this.getTaskSymbols().size());
            this.getTaskSymbols().add("__top");
            this.getCompoundTaskSymbols().add("__top");
            root.setPrimtive(false);
            int index = 0;
            for (IntTaskNetwork tn : taskNetworks) {
                IntMethod method = new IntMethod("__to_method_" + index, tn.arity());
                for (int i = 0; i < tn.arity(); i++) {
                    method.setTypeOfParameter(i, tn.getTypeOfParameters(i));
                }
                for (int i = 0; i < tn.arity(); i++) {
                    method.setValueOfParameter(i, tn.getValueOfParameter(i));
                }
                method.setTask(new IntExpression(root));
                method.setPreconditions(new IntExpression(PDDLConnective.AND));
                method.setTaskNetwork(tn);
                this.getIntMethods().add(method);
                index++;
            }

            // Creates the abstract initial task network
            IntTaskNetwork newTaskNetwork = new IntTaskNetwork();
            newTaskNetwork.getTasks().addChild(new IntExpression(root));
            this.setIntInitialTaskNetwork(newTaskNetwork);
        } else {
            this.setIntInitialTaskNetwork(taskNetworks.get(0));
        }
    }



    /**
     * Instantiates a specified task network.
     *
     * @param network the task network to instantiate.
     * @return the list of task netwok instantiated corresponding the specified network.
     */
    private List<IntTaskNetwork> instantiate(final IntTaskNetwork network) {
        final List<IntTaskNetwork> instNetwork = new ArrayList<>(100);
        this.instantiate(network, 0, instNetwork);
        return instNetwork;
    }

    /**
     * Instantiates a specified task network.
     *
     * @param network  the action.
     * @param index   the index of the parameter to instantiate.
     * @param networks the list of tasknetwork already instantiated.
     * @see IntAction
     */
    private void instantiate(final IntTaskNetwork network, final int index, final List<IntTaskNetwork> networks) {

        final int arity = network.arity();
        if (index == arity) {
            networks.add(network);
        } else {
            final Set<Integer> values = this.getDomains().get(network.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntTaskNetwork copy = new IntTaskNetwork(arity);
                copy.setOrderingConstraints(new IntExpression(network.getOrderingConstraints()));

                final IntExpression tasksCopy = new IntExpression(network.getTasks());
                this.substitute(tasksCopy, varIndex, value, true);
                copy.setTasks(tasksCopy);

                for (int i = 0; i < arity; i++) {
                    copy.setTypeOfParameter(i, network.getTypeOfParameters(i));
                }
                for (int i = 0; i < arity; i++) {
                    copy.setValueOfParameter(i, network.getValueOfParameter(i));
                }

                copy.setValueOfParameter(index, value);
                this.instantiate(copy, index + 1, networks);
            }
        }
    }

    /**
     * Make the instantiation of a list of methods.
     *
     * @param methods             the method to instantiate.
     * @param initialTasksNetwork the initial tasks network.
     * @param actions             the list of action already instantiate.
     */
    protected void instantiateMethods(List<IntMethod> methods, IntTaskNetwork initialTasksNetwork,
                                   List<IntAction> actions) {

        // Init the list of instantiated methods or ground methods
        final List<IntMethod> instMethods = new ArrayList<>(Constants.DEFAULT_METHOD_TABLE_SIZE);

        // Init the set used to store the compound tasks
        final Set<IntExpression> compound = new LinkedHashSet<>();

        // Init the set used to store the primtive tasks
        final Set<IntExpression> primtive = new LinkedHashSet<>();

        // Init the table used to store for each task the list of methods that are relevant
        this.relevantMethods = new ArrayList<List<Integer>>();

        // Init the list of methods to instantiate
        List<IntMethod> meths = new ArrayList<>();
        for (IntMethod m : methods) {
            // If a method has a parameter with a empty domain the method must be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < m.arity() && toInstantiate) {
                toInstantiate = !this.getDomains().get(m.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (toInstantiate) {
                meths.add(m);
            }
        }

        // Filter methods with a parameter with an empty domain
        this.filterMethodWithEmptyDomainParameter(methods);

        // Expand the quantified expression contains in the the method precondition
        this.expandQuantifiedExpressionAndSimplyMethods(meths);

        // Compute the set of primitive task from the action already instantiated
        LinkedHashSet<IntExpression> primitiveTaskSet = this.computePrimitiveTaskSet(actions);

        // TInit the list of pending tasks to decompose
        final LinkedList<IntExpression> tasks = new LinkedList<>();

        // Add the task of the initial task network with the compound tasks
        for (IntExpression subtasks : initialTasksNetwork.getTasks().getChildren()) {
            if (!tasks.contains(subtasks)) {
                if (!subtasks.isPrimtive()) {
                    tasks.add(subtasks);
                    compound.add(subtasks);
                } else {
                    primtive.add(subtasks);
                }
            }
        }

        // Start exploring the task tree
        int indexMethod = 0;
        while (!tasks.isEmpty()) {
            final IntExpression task = tasks.pop();
            final List<IntMethod> relevant = new ArrayList<>();
            final List<Integer> relevantIndex = new ArrayList<>();
            for (IntMethod method : meths) {
                if (method.getTask().getPredicate() == task.getPredicate()
                    && method.getTask().getArguments().length == task.getArguments().length) {
                    final List<IntMethod> instantiated = new ArrayList<>(100);
                    this.instantiate(method, 0, Integer.MAX_VALUE, instantiated, task);
                    for (IntMethod instance : instantiated) {
                        final Iterator<IntExpression> i = instance.getSubTasks().getChildren().iterator();
                        final Set<IntExpression> primitiveSet = new LinkedHashSet<>();
                        final Set<IntExpression> compoundSet = new LinkedHashSet<>();
                        boolean stop = false;
                        while (i.hasNext() && !stop) {
                            final IntExpression subtask = i.next();
                            if (subtask.isPrimtive()) {
                                if (!primitiveTaskSet.contains(subtask)) {
                                    stop = true;
                                } else {
                                    primitiveSet.add(subtask);
                                }
                            } else {
                                if (!compound.contains(subtask)) {
                                    compoundSet.add(subtask);
                                }
                            }
                        }
                        if (!stop) {
                            primtive.addAll(primitiveSet);
                            tasks.addAll(compoundSet);
                            compound.addAll(compoundSet);
                            relevant.add(instance);
                            relevantIndex.add(indexMethod);
                            indexMethod++;
                        }
                    }
                }
            }

            this.relevantMethods.add(relevantIndex);
            instMethods.addAll(relevant);
        }

        // Initialize the table of relevant methods for each compund task and the table of relevant compound tasks
        this.tableOfRelevantCompundTasks = new ArrayList<>(compound.size());
        this.tableOfRelevantCompundTasks.addAll(compound);

        // Initialize the table of relevant actions for each primitive task and the table of relevant primitive tasks
        this.relevantActions = new ArrayList<Integer>(primitiveTaskSet.size());
        this.tableOfRelevantPrimitiveTasks = new ArrayList<>(primitiveTaskSet.size());
        int index = 0;
        Iterator<IntExpression> i = primitiveTaskSet.iterator();
        while (i.hasNext()) {
            // The action at index i can be remove because it not reachable from the initial task network.
            IntExpression primitiveTask = i.next();
            if (!primtive.contains(primitiveTask)) {
                actions.remove(index);
                i.remove();
            } else {
                this.relevantActions.add(index);
                this.tableOfRelevantPrimitiveTasks.add(primitiveTask);
                index++;
            }
        }
        methods.clear();
        methods.addAll(instMethods);
    }

    /**
     * Filter methods with a parameter with a empty domain.
     *
     * @param methods the list of methods to filter.
     */
    private void filterMethodWithEmptyDomainParameter(List<IntMethod> methods) {
        Iterator<IntMethod> it = methods.iterator();
        while (it.hasNext()) {
            final IntMethod method = it.next();
            // If an method has a parameter with a empty domain the method can be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < method.arity() && toInstantiate) {
                toInstantiate = !this.getDomains().get(method.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (!toInstantiate) {
                it.remove();
            }
        }
    }

    /**
     * Expands the quantified expression contained in the preconditions of the methods in parameter and simplify the
     * their precondition. If the preconditions can be simplied to false, the method simplified is removed.
     *
     * @param methods the list of methods to process.
     */
    private void expandQuantifiedExpressionAndSimplyMethods(List<IntMethod> methods) {
        final Iterator<IntMethod> i = methods.iterator();
        while (i.hasNext()) {
            final IntMethod method = i.next();
            this.expandQuantifiedExpression(method.getPreconditions(), true);
            this.simplify(method.getPreconditions());
            if (method.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                i.remove();
            }
        }
    }

    /**
     * Computes the list of possible primitive tasks from the action already instantiated.
     *
     * @param actions the list of actions altready instantiated.
     * @return the list of possible primitive tasks from the action already instantiated.
     */
    private LinkedHashSet<IntExpression> computePrimitiveTaskSet(List<IntAction> actions) {
        LinkedHashSet<IntExpression> tasks = new LinkedHashSet<>();
        for (IntAction a : actions) {
            IntExpression task = new IntExpression(PDDLConnective.TASK);
            task.setPrimtive(true);
            task.setPredicate(this.getTaskSymbols().indexOf(a.getName()));
            task.setArguments(a.getInstantiations());
            tasks.add(task);
        }
        return tasks;

    }

    /**
     * Make the preinstantion of a method based on the argument used in the tasks accomplish by the method.
     *
     * @param method the method to instantiate.
     * @param index  the index of the parameter to instantiate. Initially, the index is set to 0.
     * @param bound  a bound on the number of methods to instantiate.
     * @param task   the tasks that accomplish the method.
     */
    private void instantiate(final IntMethod method, final int index, final int bound,
                                    final List<IntMethod> methods, final IntExpression task) {
        final IntExpression t = method.getTask();
        final IntMethod copy = new IntMethod(method);
        boolean instantiable = true;
        int i = 0;
        while (i < t.getArguments().length && instantiable) {
            final int var = t.getArguments()[i];
            final int cons = task.getArguments()[i];
            final int type = copy.getTypeOfParameters((-var - 1));
            final Set<Integer> domain = this.getDomains().get(type);
            if (domain.contains(cons)) {
                this.substitute(copy.getPreconditions(), var, cons, true);
                this.substitute(copy.getTask(), var, cons, true);
                this.substitute(copy.getSubTasks(), var, cons, true);
                copy.setValueOfParameter((-var - 1), cons);
            } else {
                instantiable = false;
            }
            i++;
        }
        // This case may occur when variables are identical in the tasks
        if (copy.getTask().equals(task) && instantiable) {
            this.instantiate(copy, index, bound, methods);
        }
    }

    /**
     * Instantiates a specified method. This method used brut force.
     * <p>
     * The assumption is made that different method parameters are instantiated with different
     * constants, i.e., the planner never generates methods like move(a,a) because we consider this
     * as a bad domain representation that should be revised. In fact, in methods with identical
     * constant parameters, all but one of the constants are superfluous and can be skipped from the
     * representation without loss of information. Warning this assumption make the process no-sound.
     * </p>
     *
     * @param method  the method.
     * @param index   the index of the parameter to instantiate.
     * @param bound   the bound of methods to instantiate.
     * @param methods the list of methods already instantiated.
     * @see IntMethod
     */
    private void instantiate(final IntMethod method, final int index, final int bound,
                                    final List<IntMethod> methods) {
        if (bound == methods.size()) {
            return;
        }
        final int arity = method.arity();
        if (index == arity) {
            final IntExpression precond = method.getPreconditions();
            this.simplify(precond);
            if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                methods.add(method);
            }
        } else if (method.getValueOfParameter(index) >= 0) {
            this.instantiate(method, index + 1, bound, methods);
        } else {
            final Set<Integer> values = this.getDomains().get(method.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntExpression preconditionCopy = new IntExpression(method.getPreconditions());

                this.substitute(preconditionCopy, varIndex, value, true);
                if (!preconditionCopy.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntMethod copy = new IntMethod(method.getName(), arity);
                    copy.setPreconditions(preconditionCopy);
                    copy.setOrderingConstraints(new IntExpression(method.getOrderingConstraints()));

                    final IntExpression taskCopy = new IntExpression(method.getTask());
                    this.substitute(taskCopy, varIndex, value, true);
                    copy.setTask(taskCopy);

                    final IntExpression subTasksCopy = new IntExpression(method.getSubTasks());
                    this.substitute(subTasksCopy, varIndex, value, true);
                    copy.setSubTasks(subTasksCopy);

                    for (int i = 0; i < arity; i++) {
                        copy.setTypeOfParameter(i, method.getTypeOfParameters(i));
                    }
                    for (int i = 0; i < arity; i++) {
                        copy.setValueOfParameter(i, method.getValueOfParameter(i));
                    }

                    copy.setValueOfParameter(index, value);
                    this.instantiate(copy, index + 1, bound, methods);
                }
            }
        }
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
                    if (relevant.remove(new Integer(i))) {
                        //System.out.println("remove " + i);
                        this.updateRelevantMethods(i);
                        // There is no more relevant method for the compound task
                        if (relevant.isEmpty()) {
                            tasksNoMoreReachable.add(this.getTableOfRelevantCompundTasks().get(j));
                            this.getTableOfRelevantCompundTasks().remove(j);
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
    protected void extractRelevantFacts(final List<IntAction> actions, List<IntMethod> methods,
                                     final Set<IntExpression> init) {
        final Set<IntExpression> facts = new LinkedHashSet<>(10000);
        for (IntAction a : actions) {
            extractRelevantFacts(a.getPreconditions(), facts, init);
            extractRelevantFacts(a.getEffects(), facts, init);
        }
        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            for (IntMethod m : methods) {
                extractRelevantFacts(m.getPreconditions(), facts, init);
            }
        }
        for (IntExpression p : init) {
            Inertia inertia = this.getTableOfGroundInertia().get(p);
            if (inertia == null) {
                inertia = Inertia.INERTIA;
            }
            if (init.contains(p) && !inertia.equals(Inertia.NEGATIVE)) {
                facts.add(p);
            }
        }
        this.tableOfRelevantFluents = new ArrayList<>(facts.size());
        for (IntExpression exp : facts) {
            final IntExpression relevant = new IntExpression(exp);
            this.tableOfRelevantFluents.add(relevant);
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
    private void extractRelevantFacts(final IntExpression exp, final Set<IntExpression> facts,
                                             final Set<IntExpression> init) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = this.getTableOfGroundInertia().get(exp);
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
                    this.extractRelevantFacts(e, facts, init);
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
    protected void extractRelevantNumericFluents(final List<IntAction> actions, List<IntMethod> methods) {
        final Set<IntExpression> fluents = new LinkedHashSet<>(100);
        for (IntAction a : actions) {
            if (a.isDurative()) {
                this.extractRelevantNumericFluents(a.getDuration(), fluents);
            }
            this.extractRelevantNumericFluents(a.getPreconditions(), fluents);
            this.extractRelevantNumericFluents(a.getEffects(), fluents);
        }
        this.tableOfRelevantNumericFluents = new ArrayList<>(fluents.size());
        for (IntExpression exp : fluents) {
            final IntExpression relevant = new IntExpression(exp);
            this.tableOfRelevantNumericFluents.add(relevant);
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
    private void extractRelevantNumericFluents(final IntExpression exp, final Set<IntExpression> fluents) {
        switch (exp.getConnective()) {
            case FN_HEAD:
                fluents.add(exp);
                break;
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    this.extractRelevantNumericFluents(e, fluents);
                }
                break;
            case UMINUS:
            case NOT:
                this.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
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
                this.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                this.extractRelevantNumericFluents(exp.getChildren().get(1), fluents);
                break;
            case F_EXP:
                this.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
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

}
