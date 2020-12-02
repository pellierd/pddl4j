package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.*;

import java.util.*;

/**
 * Created by pellier on 02/12/2020.
 */
public abstract class PreInstantiatedProblem extends IntProblem {

    /**
     * The table that defines for each predicates its type of inertia.
     */
    private List<Inertia> tableOfInertia;

    private List<Inertia> tableOfNumericInertia;

    /**
     * The table of inferred domains based on unary inertia encoding.
     */
    private List<Set<Integer>> tableOfInferredDomains;

    /**
     * The list of predicates tables used to count the occurrence of a specified predicate in the
     * initial state.
     */
    private List<List<IntMatrix>> predicatesTables;


    public PreInstantiatedProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }

    public List<Inertia> getTableOfInertia() {
        return tableOfInertia;
    }

    public List<Inertia> getTableOfNumericInertia() {
        return tableOfNumericInertia;
    }

    public List<Set<Integer>> getTableOfInferredDomains() {
        return tableOfInferredDomains;
    }

    public List<List<IntMatrix>> getPredicatesTables() {
        return predicatesTables;
    }


    public void preInstantiate() {
        this.extractInertia();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.extractNumericInertia();
        }

        // Infer the type from the unary inertia
        if (!this.getRequirements().contains(PDDLRequireKey.TYPING)
            &&!this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
                this.inferTypesFromInertia();
                this.simplifyActionsWithInferredTypes();
        }
        // Create the predicates tables used to count the occurrences of the predicates in the
        // initial state
        this.createPredicatesTables();

        if (this.getRequirements().contains(PDDLRequireKey.DURATIVE_ACTIONS)) {
            this.expandTemporalActions(Encoder.pb.getIntActions());
        }
    }

    public void instantiate() {
        this.preInstantiate();
    }

    protected abstract void postInstantiate();

    /*
     * This method proceeds over the actions of the domain and checks for all atom which kind of
     * inertia it is. For each atom it checks if it satisfies one of the following definitions:
     * <p>
     * <i>Definition:</i> A relation is a positive inertia iff it does not occur positively in an
     * unconditional effect or the consequent of a conditional effect of an action.
     * </p>
     * <p>
     * <i>Definition:</i> A relation is a negative inertia iff it does not occur negatively in an
     * unconditional effect or the consequent of a conditional effect of an action.
     * </p>
     * <p>
     * Relations, which are positive as well as negative inertia, are simply called inertia.
     * Relations, which are neither positive nor negative inertia, are called fluents. The detection
     * of inertia and fluents is easy because in ADL, effects are restricted to conjunctions of
     * literals. Furthermore, this information can be obtained with a single pass over the domain
     * description, which takes almost no time at all.
     * </p>
     * <p>
     * Note: before calling this method the domain must be encode into integer and the negation must
     * be move inward the expression.
     * </p>
     *
     * @param actions the list of actions to simplified.
     */
    protected void extractInertia() {
        final int nbPredicates = this.getPredicateSymbols().size();
        this.tableOfInertia = new ArrayList<>(nbPredicates);
        for (int i = 0; i < nbPredicates; i++) {
            this.tableOfInertia.add(Inertia.INERTIA);
        }
        for (final IntAction action : super.getIntActions()) {
            this.extract(action.getEffects());
        }

    }

    /**
     * Do a pass over the effects of an action and update the inertia table.
     *
     * @param exp the effect.
     */
    private void extract(final IntExpression exp) {
        switch (exp.getConnective()) {
            case ATOM:
                int predicate = exp.getPredicate();
                switch (this.tableOfInertia.get(predicate)) {
                    case INERTIA:
                        this.tableOfInertia.set(predicate, Inertia.NEGATIVE);
                        break;
                    case POSITIVE:
                        this.tableOfInertia.set(predicate, Inertia.FLUENT);
                        break;
                    default:
                        // do nothing
                }
                break;
            case AND:
            case OR:
                exp.getChildren().forEach(this::extract);
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
                this.extract(exp.getChildren().get(0));
                break;
            case WHEN:
                this.extract(exp.getChildren().get(1));
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                if (neg.getConnective().equals(PDDLConnective.ATOM)) {
                    predicate = neg.getPredicate();
                    switch (this.tableOfInertia.get(predicate)) {
                        case INERTIA:
                            this.tableOfInertia.set(predicate, Inertia.POSITIVE);
                            break;
                        case NEGATIVE:
                            this.tableOfInertia.set(predicate, Inertia.FLUENT);
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
            case SOMETIME:
            case AT_MOST_ONCE:
            case F_EXP:
                // do nothing
                break;
            default:
                // do nothing
        }
    }

    /**
     * Extract the numeric inertia from the list of actions. A numeric fluent is a inertia iff it never appears in the
     * effect of an action.
     */
    private void extractNumericInertia() {
        final int nbFunctions = this.getFunctionSymbols().size();
        this.tableOfNumericInertia = new ArrayList<>(nbFunctions);
        for (int i = 0; i < nbFunctions; i++) {
            this.tableOfNumericInertia.add(Inertia.INERTIA);
        }
        for (final IntAction a : super.getIntActions()) {
            this.extractNumericInertia(a.getEffects());
        }

    }

    /**
     * Do a pass over the effects of an action and update the numeric inertia table.
     * A numeric inertia is a function that is never change by any action of the problem.
     *
     * @param exp the effect.
     */
    private void extractNumericInertia(final IntExpression exp) {
        switch (exp.getConnective()) {
            case AND:
                exp.getChildren().forEach(this::extractNumericInertia);
                break;
            case WHEN:
                extractNumericInertia(exp.getChildren().get(1));
                break;
            case NOT:
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
                this.extractNumericInertia(exp.getChildren().get(0));
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                this.tableOfNumericInertia.set(exp.getChildren().get(0).getPredicate(), Inertia.FLUENT);
                break;
            case ATOM:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
    }
    /**
     * Infer type from unary inertia contained in the initial state.
     */
    private void inferTypesFromInertia() {
        this.tableOfInferredDomains = new ArrayList<>(this.getPredicateSymbols().size());
        for (int i = 0; i < this.getPredicateSymbols().size(); i++) {
            if (this.getPredicateSignatures().get(i).size() == 1
                && this.getTableOfInertia().get(i).equals(Inertia.INERTIA)) {
                final Set<Integer> newTypeDomain = new LinkedHashSet<>();
                for (IntExpression fact : this.getIntInitPredicates()) {
                    if (fact.getConnective().equals(PDDLConnective.NOT)) {
                        fact = fact.getChildren().get(0);
                    }
                    if (fact.getPredicate() == i) {
                        newTypeDomain.add(fact.getArguments()[0]);
                    }
                }
                this.tableOfInferredDomains.add(newTypeDomain);
            } else {
                this.tableOfInferredDomains.add(null);
            }
        }
    }

    /**
     * Symplify the actions with the infered types.
     */
    private void simplifyActionsWithInferredTypes() {
        final List<IntAction> actions = new LinkedList<>();
        for (final IntAction action : super.getIntActions()) {
            actions.addAll(this.simplifyActionsWithInferredTypes(action));
        }
        super.getIntActions().clear();
        super.getIntActions().addAll(actions);
    }

    private List<IntAction> simplifyActionsWithInferredTypes(final IntAction action) {
        final List<IntExpression> unaryInertia = new ArrayList<>();
        unaryInertia.addAll(this.collectUnaryInertia(action.getPreconditions()));
        unaryInertia.addAll(this.collectUnaryInertia(action.getEffects()));

        List<IntAction> actions = new LinkedList<>();
        actions.add(action);

        if (action.arity() == 0) {
            return actions;
        }

        for (final IntExpression inertia : unaryInertia) {
            final List<IntAction> newActions = new ArrayList<>();
            for (final IntAction o : actions) {
                if (o.arity() > 0) {

                    int index = -inertia.getArguments()[0] - 1;
                    // Hack add for constant in predicate
                    //if (index < 0) {
                    //    break;
                    //}

                    final int dtIndex = action.getTypeOfParameters(index);

                    final String declaredType = this.getTypeSymbols().get(dtIndex);
                    final int itIndex = inertia.getPredicate();
                    final String inertiaType = this.getPredicateSymbols().get(itIndex);

                    final String sti = declaredType + "^" + inertiaType;
                    int ti = this.getTypeSymbols().indexOf(sti);
                    if (ti == -1) {
                        ti = this.getTypeSymbols().size();
                        this.getTypeSymbols().add(sti);
                        final Set<Integer> dt1 = new LinkedHashSet<>(this.getDomains().get(dtIndex));
                        dt1.retainAll(this.getTableOfInferredDomains().get(itIndex));
                        this.getDomains().add(dt1);
                    }

                    final String sts = declaredType + "\\" + inertiaType;
                    int ts = this.getTypeSymbols().indexOf(sts);
                    if (ts == -1) {
                        ts = this.getTypeSymbols().size();
                        this.getTypeSymbols().add(sts);
                        final Set<Integer> dt2 = new LinkedHashSet<>(this.getDomains().get(dtIndex));
                        dt2.removeAll(this.getTableOfInferredDomains().get(itIndex));
                        this.getDomains().add(dt2);
                    }
                    final IntAction op1 = new IntAction(o);
                    op1.setTypeOfParameter(index, ti);
                    this.replace(op1.getPreconditions(), inertia, PDDLConnective.TRUE, ti, ts);
                    this.replace(op1.getEffects(), inertia, PDDLConnective.TRUE, ti, ts);
                    if (!op1.getPreconditions().getConnective().equals(PDDLConnective.FALSE)
                        && !op1.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                        newActions.add(op1);
                    }

                    final IntAction op2 = new IntAction(o);
                    op2.setTypeOfParameter(index, ts);
                    this.replace(op2.getPreconditions(), inertia, PDDLConnective.FALSE, ti, ts);
                    this.replace(op2.getEffects(), inertia, PDDLConnective.FALSE, ti, ts);

                    if (!op2.getPreconditions().getConnective().equals(PDDLConnective.FALSE)
                        && !op2.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                        newActions.add(op2);
                    }
                }
            }
            actions.clear();
            actions.addAll(newActions);
        }
        return actions;
    }

    /**
     * Replace all the occurrences of a specified unary inertia contained in the a specified
     * expression by <code>TRUE</code> or <code>FALSE</code>.
     *
     * @param exp        the expression.
     * @param inertia    the unary inertia.
     * @param connective the connective.
     * @param ti         the type intersection.
     * @param ts         the type substract.
     */
    private void replace(final IntExpression exp, final IntExpression inertia, final PDDLConnective connective,
                         final int ti, final int ts) {
        switch (exp.getConnective()) {
            case ATOM:
                if (exp.equals(inertia)) {
                    exp.setConnective(connective);
                }
                break;
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    this.replace(ei, inertia, connective, ti, ts);
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(PDDLConnective.TRUE);
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    this.replace(ei, inertia, connective, ti, ts);
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    } else if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(PDDLConnective.FALSE);
                }
                break;
            case FORALL:
            case EXISTS:
                if (inertia.getArguments()[0] == exp.getVariable()) {
                    final IntExpression ei = new IntExpression(exp);
                    ei.setType(ti);
                    this.replace(ei, inertia, PDDLConnective.TRUE, ti, ts);
                    final IntExpression es = new IntExpression(exp);
                    es.setType(ts);
                    this.replace(es, inertia, PDDLConnective.FALSE, ti, ts);
                    exp.getChildren().clear();
                    if (exp.getConnective().equals(PDDLConnective.FORALL)) {
                        exp.setConnective(PDDLConnective.AND);
                    } else {
                        exp.setConnective(PDDLConnective.OR);
                    }
                    exp.getChildren().add(ei);
                    exp.getChildren().add(es);
                } else {
                    this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                }
                break;
            case NOT:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                if (exp.getChildren().get(0).getConnective().equals(PDDLConnective.TRUE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                } else {
                    exp.setConnective(PDDLConnective.TRUE);
                }
                break;
            case AT_START:
            case AT_END:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case WHEN:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                this.replace(exp.getChildren().get(1), inertia, connective, ti, ts);
                this.replace(exp.getChildren().get(3), inertia, connective, ti, ts);
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
     * Collect all unary inertia from a specified expression.
     *
     * @param exp the expression.
     * @return the list of unary inertia expression collected.
     */
    private List<IntExpression> collectUnaryInertia(final IntExpression exp) {
        final List<IntExpression> unaryInertia = new ArrayList<>();
        switch (exp.getConnective()) {
            case ATOM:
                if (this.getTableOfInferredDomains().get(exp.getPredicate()) != null) {
                    unaryInertia.add(exp);
                }
                break;
            case AND:
            case OR:
                for (final IntExpression ei : exp.getChildren()) {
                    unaryInertia.addAll(this.collectUnaryInertia(ei));
                }
                break;
            case FORALL:
            case EXISTS:
                final IntExpression qExp = exp.getChildren().get(0);
                unaryInertia.addAll(this.collectUnaryInertia(qExp));
                break;
            case AT_START:
            case AT_END:
            case NOT:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case WHEN:
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(0)));
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(0)));
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(1)));
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(3)));
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
        return unaryInertia;
    }

    /**
     * This method creates the predicates predicatesTables used to simplify atomic expression.
     */
    private void createPredicatesTables() {
        final int tableSize = this.getConstantSymbols().size();
        final int nbPredicate = this.getPredicateSymbols().size();
        this.predicatesTables = new ArrayList<>(nbPredicate);
        for (final List<Integer> arguments : this.getPredicateSignatures()) {
            final int arity = arguments.size();
            final int nbTables = (int) Math.pow(2, arity);
            final List<IntMatrix> pTables = new ArrayList<>(nbTables);
            for (int j = 0; j < nbTables; j++) {
                final int dimension = Integer.bitCount(j);
                pTables.add(new IntMatrix(tableSize, dimension));
            }
            this.predicatesTables.add(pTables);
        }

        for (IntExpression fact : this.getIntInitPredicates()) {
            if (fact.getConnective().equals(PDDLConnective.NOT)) {
                fact = fact.getChildren().get(0);
            }
            final int arity = this.getPredicateSignatures().get(fact.getPredicate()).size();
            final List<IntMatrix> pTables = this.predicatesTables.get(fact.getPredicate());
            final int[] set = new int[arity];
            final int[] args = fact.getArguments();
            for (final IntMatrix intMatrix : pTables) {
                int indexSize = 0;
                for (int aSet : set) {
                    if (aSet == 1) {
                        indexSize++;
                    }
                }
                final int[] index = new int[indexSize];
                int j = 0;
                for (int i = 0; i < set.length; i++) {
                    if (set[i] == 1) {
                        index[j] = args[i];
                        j++;
                    }
                }
                intMatrix.increment(index);
                this.incrementMask(set);
            }
        }
    }

    /**
     * Return an integer representation of the specified array of integer. For example, if
     * <code>mask = [0, 1, 1]</code> then the method will return 3.
     *
     * @param mask an array of integer that can only contain 0 or 1.
     * @return the integer representation of the specified array.
     */
    protected int toInt(final int[] mask) {
        final int len = mask.length;
        if (len > 0) {
            int res = mask[0];
            for (int i = 1; i < len; i++) {
                res = res << 1 | mask[i];
            }
            return res;
        }
        return 0;
    }

    private int[] incrementMask(final int[] set) {
        boolean overflow = false;
        for (int i = set.length - 1; i >= 0; i--) {
            if (set[i] == 0) {
                set[i] = 1;
                break;
            } else {
                set[i] = 0;
                overflow = i == 0;
            }
        }
        return overflow ? null : set;
    }

    /**
     * Print the predicates tables.
     *
     * @param tables predicates tables.
     */
    void printPredicatesTables(final List<List<IntMatrix>> tables) {
        for (int predicate = 0; predicate < tables.size(); predicate++) {
            final List<IntMatrix> pTables = tables.get(predicate);
            final int arity = this.getPredicateSignatures().get(predicate).size();
            final int[] mask = new int[arity];
            for (int i = 0; i < pTables.size(); i++) {
                this.print(predicate, arity, mask, new int[0], tables);
                this.incrementMask(mask);
            }
        }
    }

    /**
     * Print a specified predicate table.
     *
     * @param predicate the predicate.
     * @param arity     the arity of the predicate.
     * @param mask      the mask that indicate where the constants are.
     * @param index     the index in construction.
     * @param tables    the predicates tables.
     */
    private void print(final int predicate, final int arity, final int[] mask, final int[] index,
                       final List<List<IntMatrix>> tables) {
        if (index.length == arity) {
            final StringBuilder str = new StringBuilder();
            str.append("(");
            str.append(this.getPredicateSymbols().get(predicate));
            int var = 0;
            int realIndexSize = 0;
            for (int anIndex : index) {
                if (anIndex == -1) {
                    str.append(" X").append(var);
                    var++;
                } else {
                    realIndexSize++;
                    str.append(" ").append(this.getConstantSymbols().get(anIndex));
                }
            }
            str.append(")");
            final int[] realIndex = new int[realIndexSize];
            int j = 0;
            for (int anIndex : index) {
                if (anIndex != -1) {
                    realIndex[j] = anIndex;
                    j++;
                }
            }
            final int counter = tables.get(predicate).get(this.toInt(mask)).get(realIndex);
            if (counter != 0) {
                str.append(" : ").append(counter);
            }
        } else if (mask[index.length] == 0) {
            final int[] newIndex = new int[index.length + 1];
            System.arraycopy(index, 0, newIndex, 0, index.length);
            newIndex[index.length] = -1;
            this.print(predicate, arity, mask, newIndex, tables);
        } else {
            for (int i = 0; i < this.getConstantSymbols().size(); i++) {
                final int[] newIndex = new int[index.length + 1];
                System.arraycopy(index, 0, newIndex, 0, index.length);
                newIndex[index.length] = i;
                this.print(predicate, arity, mask, newIndex, tables);
            }
        }
    }

    /**
     * Expands the temporal actions.
     */
    protected void expandTemporalActions(List<IntAction> actions) {
        List<IntAction> expandedActions = new ArrayList<>();

        for (IntAction a : actions) {
            // System.out.println("******************************************************");
            //System.out.println(Encoder.toString(a));

            Instantiation.expandQuantifiedExpression(a.getPreconditions(), false);
            a.getPreconditions().moveTimeSpecifierInward();
            a.getPreconditions().moveNegationInward();

            //System.out.println("*** Precondition ***");
            //System.out.println(Encoder.toString(a.getPreconditions()));

            final IntExpression startPrecondition = new IntExpression(a.getPreconditions());
            this.extract(startPrecondition, PDDLConnective.AT_START);
            //System.out.println("*** At start precondition ***");
            //System.out.println(Encoder.toString(startPrecondition));
            Instantiation.simplify(startPrecondition);
            //System.out.println("*** At start precondition ***");
            //System.out.println(Encoder.toString(startPrecondition));
            BitEncoding.toDNF(startPrecondition);

            //System.out.println("*** At start precondition ***");
            //System.out.println(Encoder.toString(startPrecondition));

            final IntExpression endPrecondition = new IntExpression(a.getPreconditions());
            this.extract(endPrecondition, PDDLConnective.AT_END);
            Instantiation.simplify(endPrecondition);
            BitEncoding.toDNF(endPrecondition);

            //System.out.println("*** At end precondition ***");
            //System.out.println(Encoder.toString(endPrecondition));

            final IntExpression overAllPrecondition = new IntExpression(a.getPreconditions());
            this.extract(overAllPrecondition, PDDLConnective.OVER_ALL);
            //System.out.println("*** Over all precondition AV Simplify ***");
            //System.out.println(Encoder.toString(overAllPrecondition));
            Instantiation.simplify(overAllPrecondition);
            BitEncoding.toDNF(overAllPrecondition);

            //System.out.println("*** Over all precondition ***");
            //System.out.println(Encoder.toString(overAllPrecondition));


            // Expands the quantified expression on the effect of the action
            Instantiation.expandQuantifiedExpression(a.getEffects(), false);
            a.getEffects().moveTimeSpecifierInward();
            a.getEffects().moveNegationInward();
            BitEncoding.toCNF(a.getEffects());
            //this.simplify(a.getEffects());

            //System.out.println("*** EFFECT ***");
            //System.out.println(Encoder.toString(a.getEffects()));

            //try {
            //    System.out.println("Press enter...");
            //    System.in.read();
            //} catch (IOException e) {
            //    e.printStackTrace();
            //}
            // The list of monitoring action need to deal with over all condition in conditional effect
            final List<IntAction> monitoringActions = new ArrayList<>();
            // The effect of the start action
            final IntExpression startEffect = new IntExpression(PDDLConnective.AND);
            // The effect of the end action
            final IntExpression endEffect = new IntExpression(PDDLConnective.AND);

            // Iterate over the effect of the action the action to initialize the start and end effect and the list of
            // monitoring actions needed to deal with over all condition in conditional effects.
            // We suppose that the effect is a conjunction of at_start or at_end or when.
            for (IntExpression effect : a.getEffects().getChildren()) {
                //System.out.println("EFFECT : "+ this.toString(effect));
                switch (effect.getConnective()) {
                    case AT_START:
                        startEffect.addChild(effect.getChildren().get(0));
                        break;
                    case AT_END:
                        endEffect.addChild(effect.getChildren().get(0));
                        break;
                    case WHEN:
                        // Extract the start effect condition of the conditional effect
                        final IntExpression ps = new IntExpression(effect.getChildren().get(0));
                        this.extract(ps, PDDLConnective.AT_START);
                        // Extract the end effect condition of the conditional effect
                        final IntExpression pe = new IntExpression(effect.getChildren().get(0));
                        this.extract(pe, PDDLConnective.AT_END);
                        // Extract the overall effect condition of the conditional effect
                        final IntExpression pi = new IntExpression(effect.getChildren().get(0));
                        this.extract(pi, PDDLConnective.OVER_ALL);
                        // Extract the start effect of the conditional effect
                        final IntExpression qs = new IntExpression(effect.getChildren().get(1));
                        this.extract(qs, PDDLConnective.AT_START);
                        // Extract the end effect of the conditional effect
                        final IntExpression qe = new IntExpression(effect.getChildren().get(1));
                        this.extract(qe, PDDLConnective.AT_END);


                        // CASE at start only in condition and at start only in effects
                        // We add the condition of the effect to the start action and the effect to the start action.
                        if (!ps.getChildren().isEmpty()
                            && pe.getChildren().isEmpty()
                            && pi.getChildren().isEmpty()
                            && !qs.getChildren().isEmpty()
                            && qe.getChildren().isEmpty()) {

                            IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            when.addChild(ps);
                            when.addChild(ps);
                            startEffect.addChild(when);
                        }

                        // CASE at end only in condition and at end only in effects
                        // We add the condition of the effect to the end action and the effect to the end action.
                        else if (ps.getChildren().isEmpty()
                            && !pe.getChildren().isEmpty()
                            && pi.getChildren().isEmpty()
                            && qs.getChildren().isEmpty()
                            && !qe.getChildren().isEmpty()) {

                            IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            when.addChild(pe);
                            when.addChild(qe);
                            endEffect.addChild(when);
                        }

                        // CASE at star and possibly at end but no overall in condition and at end in effects
                        else if (!ps.getChildren().isEmpty()
                            && pi.getChildren().isEmpty()
                            && !qe.getChildren().isEmpty()) {

                            // Create the conditional effect for the start action
                            final IntExpression startWhen = new IntExpression(PDDLConnective.WHEN);
                            startWhen.addChild(ps);
                            // Create the dummy predicate to memorize the effect at end
                            final IntExpression mps = this.createDummyPredicate();
                            startWhen.addChild(mps);
                            startEffect.addChild(startWhen);

                            // Create the conditional effect for the end action
                            final IntExpression endWhen = new IntExpression(PDDLConnective.WHEN);
                            if (pe.getChildren().isEmpty()) {
                                endWhen.addChild(mps);
                            } else {
                                final IntExpression and = new IntExpression(PDDLConnective.AND);
                                and.addChild(pe);
                                and.addChild(mps);
                                endWhen.addChild(and);
                            }
                            endWhen.addChild(endEffect);
                            endEffect.addChild(endWhen);
                        }

                        // CASE overall in condition with possibly no at start and no at end and at end in effect
                        // (when (and (at start ps) (over all pi) (at end pe)) (at end q))
                        else if (!pi.getChildren().isEmpty()
                            && qe.getChildren().isEmpty()) {

                            // Create the monitoring action with no precondition but effects of the form
                            // (when (and (Mpi) (not pi)) (not (Mpi)))
                            final IntAction monitoring = this.createMonitoringAction();
                            final IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            IntExpression and = new IntExpression(PDDLConnective.AND);
                            final IntExpression mpi = this.createDummyPredicate();
                            and.addChild(mpi);
                            final IntExpression notPi = new IntExpression(PDDLConnective.NOT);
                            notPi.addChild(pi);
                            notPi.moveNegationInward();
                            and.addChild(notPi);
                            when.addChild(and);
                            final IntExpression notMpi = new IntExpression(PDDLConnective.NOT);
                            notMpi.addChild(mpi);
                            when.addChild(notMpi);
                            monitoring.getEffects().addChild(when);
                            monitoringActions.add(monitoring);

                            // Create the start effect: (when ps (Mps))
                            IntExpression mps = this.createDummyPredicate();
                            if (!ps.getChildren().isEmpty()) {
                                IntExpression startWhen = new IntExpression(PDDLConnective.WHEN);
                                startWhen.addChild(ps);
                                startWhen.addChild(mps);
                                startEffect.addChild(startWhen);
                            } else {
                                startEffect.addChild(mps);
                            }

                            // Create the start effect: (when (and (Mps) (Mpi) pe) q).
                            IntExpression endWhen = new IntExpression(PDDLConnective.WHEN);
                            and = new IntExpression(PDDLConnective.AND);
                            and.addChild(mps);
                            and.addChild(mpi);
                            if (!pe.getChildren().isEmpty()) {
                                and.addChild(pe);
                            }
                            endWhen.addChild(and);
                            endWhen.addChild(qe);
                            endEffect.addChild(endWhen);
                        }
                    default:
                        // Do nothing
                }
            }
            //System.out.println("START PRECOND AVANT  SIM: ");
            //System.out.println(this.toString(startPrecondition));
            //this.simplify(startPrecondition);
            //System.out.println("START PRECOND APRES  SIM: ");
            //System.out.println(this.toString(startPrecondition));
            //start.

            //this.simplify(endPrecondition);
            //this.simplify(overallPrecondition);

            //System.out.println("START EFFECT AVANT  SIM: ");
            //System.out.println(Encoder.toString(startEffect));
            Instantiation.simplify(startEffect);
            //startEffect.toConjunctiveNormalForm(this);
            //System.out.println("START EFFECT APRES SIM: ");
            //System.out.println(Encoder.toString(startEffect));

            //System.out.println("END EFFECT AVANT  SIM: ");
            //System.out.println(Encoder.toString(endEffect));
            Instantiation.simplify(endEffect);
            //endEffect.toConjunctiveNormalForm(this);
            //System.out.println("END EFFECT APRES  SIM: ");
            //System.out.println(Encoder.toString(endEffect));

            // Create a start action for each conjunction of the start precondition
            for (IntExpression precondition : startPrecondition.getChildren()) {
                IntAction startAction = new IntAction(a.getName() + "_" + "start", a.arity());
                startAction.setCost(a.getCost());
                startAction.setDuration(new IntExpression(a.getDuration()));
                for (int i = 0; i < a.arity(); i++) {
                    startAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                }
                for (int i = 0; i < a.arity(); i++) {
                    startAction.setValueOfParameter(i, a.getValueOfParameter(i));
                }
                startAction.setPreconditions(precondition);
                startAction.setEffects(new IntExpression(startEffect));
                expandedActions.add(startAction);

                //System.out.println("*"+Encoder.toString(startAction));
                //try {
                //    System.out.println("Press enter...");
                //    System.in.read();
                //} catch (IOException e) {
                //    e.printStackTrace();
                //}
            }

            for (IntExpression precondition : endPrecondition.getChildren()) {
                IntAction endAction = new IntAction(a.getName() + "_" + "end", a.arity());
                endAction.setCost(a.getCost());
                endAction.setDuration(new IntExpression(a.getDuration()));
                for (int i = 0; i < a.arity(); i++) {
                    endAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                }
                for (int i = 0; i < a.arity(); i++) {
                    endAction.setValueOfParameter(i, a.getValueOfParameter(i));
                }
                endAction.setPreconditions(precondition);
                endAction.setEffects(new IntExpression(endEffect));
                expandedActions.add(endAction);

                /*System.out.println("*"+Encoder.toString(endAction));
                try {
                    System.out.println("Press enter...");
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
            //System.out.println(Encoder.toString(overAllPrecondition));
            for (IntExpression precondition : overAllPrecondition.getChildren()) {
                if (!precondition.getConnective().equals(PDDLConnective.FALSE)) {
                    IntAction invAction = new IntAction(a.getName() + "_" + "inv", a.arity());
                    invAction.setCost(a.getCost());
                    invAction.setDuration(new IntExpression(a.getDuration()));
                    for (int i = 0; i < a.arity(); i++) {
                        invAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                    }
                    for (int i = 0; i < a.arity(); i++) {
                        invAction.setValueOfParameter(i, a.getValueOfParameter(i));
                    }
                    invAction.setPreconditions(precondition);
                    expandedActions.add(invAction);
                    /*System.out.println("*" + Encoder.toString(invAction));
                    try {
                        System.out.println("Press enter...");
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                }
            }

            // Add the monitoring actions
            for (IntAction m : monitoringActions) {
                expandedActions.add(m);
                /*
                System.out.println(this.toString(m));
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }

        }
        actions.clear();
        actions.addAll(expandedActions);

    }


    /**
     * Extract the subexpression having the timespecifier.
     *
     * Warning the time specidier must be move inward
     */
    private void extract(IntExpression exp, PDDLConnective timeSpecifier) {
        switch (exp.getConnective()) {
            case OR:
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext()) {
                    IntExpression e = i.next();
                    this.extract(e, timeSpecifier);
                    if (e.getConnective().equals(PDDLConnective.AND)
                        && e.getChildren().isEmpty()) {
                        i.remove();
                    }
                }
                break;
            case AT_END:
            case AT_START:
            case OVER_ALL:
                if (!exp.getConnective().equals(timeSpecifier)) {
                    exp.setConnective(PDDLConnective.AND);
                    exp.getChildren().clear();
                } else {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            default:

        }

    }

    private int dummyPredicateCounter = 0;
    private IntExpression createDummyPredicate() {
        Encoder.pb.getPredicateSymbols().add("^M" + this.dummyPredicateCounter);
        this.dummyPredicateCounter++;
        final IntExpression atom = new IntExpression(PDDLConnective.ATOM);
        atom.setPredicate(Encoder.pb.getPredicateSymbols().size() - 1);
        return atom;

    }

    private int monitoringActionCounter = 0;

    private IntAction createMonitoringAction() {
        IntAction monitoring = new IntAction("monitoring_action" + this.monitoringActionCounter, 0);
        this.monitoringActionCounter++;
        return monitoring;
    }

}
