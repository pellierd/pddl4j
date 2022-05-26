package fr.uga.pddl4j.parser;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractExpression<T1 extends Symbol, T2 extends TypedSymbol> implements Expression<T1, T2> {

    /**
     * The type of the node.
     */
    private PDDLConnective connective;

    /**
     * The symbol used in the atomic formula. The symbol can be a function symbol a predicate symbol or a task symbol.
     */
    private T1 symbol;

    /**
     * The arguments of the atomic formula of this expression.
     */
    private List<T1> arguments;

    /**
     * only for parsing: the variable in quantifiers.
     */
    private List<T2> quantifiedVariables;

    /**
     * The value associate to this expression.
     */
    private Double value;

    /**
     * The children expression of this expression.
     */
    private List<Expression<T1, T2>> children;

    /**
     * The name of the preference.
     */
    private T1 prefName;

    /**
     * The variable.
     */
    private T1 variable;

    /**
     * The taskID. Use to the alias of a task atom.
     */
    private T1 taskID;

    /**
     * Creates a new expression with a specified connective.
     *
     * @param connective the connective.
     */
    public AbstractExpression(final PDDLConnective connective) {
        super();
        this.setConnective(connective);
        this.setSymbol(null);
        this.setArguments(null);
        this.setQuantifiedVariables(null);
        this.setValue(null);
        this.setVariable(null);
        this.setChildren(new ArrayList<>());
        this.setPrefName(null);
        this.setTaskID(null);
    }

    /**
     * Assigns a specified expression to this expression. After the method call the expression is equals to the
     * expression in parameter. The assignment is swallow, i.e., the assignment does not make a deep copy of the content
     * of the expression in parameter.
     *
     * @param exp the expression to assigned to this expression.
     */
    public void assign(Expression<T1, T2> exp) {
        this.setConnective(exp.getConnective());
        this.setSymbol(exp.getSymbol());
        this.setArguments(exp.getArguments());
        this.setQuantifiedVariables(exp.getQuantifiedVariables());
        this.setValue(exp.getValue());
        this.setVariable(exp.getVariable());
        this.setChildren(exp.getChildren());
        this.setPrefName(exp.getPrefName());
        this.setTaskID(exp.getTaskID());
    }

    /**
     * Returns the connective of this expression.
     *
     * @return the connective of this expression.
     */
    public final PDDLConnective getConnective() {
        return this.connective;
    }

    /**
     * Set the connective of this expression.
     *
     * @param connective the connective.
     */
    public final void setConnective(final PDDLConnective connective) {
        this.connective = connective;
    }

    /**
     * Returns the symbol to this expression. Expression with a symbol are predicate, function or task formula.
     *
     * @return the symbol the new symbol of this expression. If this expression is not ATOM, a FUNCTION or TASK the
     * returned symbol is null.
     */
    public final T1 getSymbol() {
        return this.symbol;
    }

    /**
     * Sets a new symbol to this expression. Expression with a symbol are predicate, function or task formula.
     *
     * @param symbol the new symbol of this expression.
     */
    public final void setSymbol(final T1 symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the arguments of the atomic formula represented by this expression.
     *
     * @return the arguments of the atomic formula represented by this expression.
     */
    public final List<T1> getArguments() {
        return this.arguments;
    }

    /**
     * Sets the argument of the atomic formula represented by this expression.
     *
     * @param arguments the arguments of the atomic formula represented by this expression.
     */
    public final void setArguments(final List<T1> arguments) {
        this.arguments = arguments;
    }

    /**
     * Adds an argument to this expression.
     *
     * @param argument the argument to add.
     */
    public final boolean addArgument(final T1 argument) {
        return this.arguments.add(argument);
    }


    /**
     * Returns the list of quantified variables of this expression.
     *
     * @return the list of quantified variables of this expression.
     */
    public final List<T2> getQuantifiedVariables() {
        return this.quantifiedVariables;
    }

    /**
     * Sets the quantified variables of this expression.
     *
     * @param variables the quantified variables of this expression.
     */
    public final void setQuantifiedVariables(final List<T2> variables) {
        this.quantifiedVariables = variables;
    }

    /**
     * Adds a quantified variable to this expression.
     *
     * @param variable the quantified variable to add.
     */
    public final boolean addQuantifiedVariable(final T2 variable) {
        return this.quantifiedVariables.add(variable);
    }

    /**
     * Returns the numeric value of this parser node.
     *
     * @return the numeric value of this parser node.
     */
    public final Double getValue() {
        return this.value;
    }

    /**
     * Set the numeric value of this expression.
     *
     * @param value the numeric value of this expression.
     */
    public final void setValue(final Double value) {
        this.value = value;
    }

    /**
     * Returns the variable of this expression
     *
     * @return the variable of this expression.
     */
    public final T1 getVariable() {
        return this.symbol;
    }

    /**
     * Sets a new variable to this parser node.
     *
     * @param variable the new variable to set.
     */
    public final void setVariable(final T1 variable) {
        this.variable = variable;
    }

    /**
     * Returns the name of the preference associated to this expression.
     *
     * @return the name of the preference or <code>null</code> if the preference name was not initialized.
     */
    public final T1 getPrefName() {
        return this.prefName;
    }

    /**
     * Sets a name to the preference associated to this expression.
     *
     * @param name the name of the preference to set.
     */
    public final void setPrefName(final T1 name) {
        this.prefName = name;
    }

    /**
     * Returns the taskID associated to this expression. The taskID is only use in HTN planning to make alias of task.
     *
     * @return the taskID associated to this expression.
     */
    public final T1 getTaskID() {
        return this.taskID;
    }

    /**
     * Set the taskID associated to this expression. The taskID is only use in HTN planning to make alias of task.
     *
     * @param taskID the taskID to set.
     */
    public final void setTaskID(T1 taskID) {
        this.taskID = taskID;
    }

    /**
     * Add a new child expression to this expression.
     *
     * @param exp the child to add
     * @return <code>true</code> if the expression was added; <code>false</code> otherwise
     * @throws RuntimeException if the specified node is null
     */
    public final boolean addChild(final Expression<T1, T2> exp) {
        return this.children.add(exp);
    }

    /**
     * Sets the list of children expressions of this expression.
     *
     * @param children the children expression to set.
     */
    public final void setChildren(final List<Expression<T1, T2>> children) {
        this.children = children;
    }

    /**
     * Returns the list of children of this expression.
     *
     * @return the list of children of this expression.
     */
    public List<Expression<T1, T2>> getChildren() {
        return this.children;
    }

    /**
     * Creates a new empty AND expression.
     */
    public AbstractExpression() {
        this(PDDLConnective.AND);
    }

    /**
     * Returns if this expression is a literal. A literal is an atomic formula or a negated atomic
     * formula.
     *
     * @return <code>true</code> if this expression is a literal <code>false</code> otherwise.
     */
    public final boolean isLiteral() {
        return this.getConnective().equals(PDDLConnective.ATOM)
            || (this.getConnective().equals(PDDLConnective.NOT)
            && this.getChildren().size() == 1
            && this.getChildren().get(0).getConnective().equals(PDDLConnective.ATOM));
    }

    /**
     * Sets the expression into negative normal form. After the method call, negation can occurs only before atomic
     * formula and time specifier (at start, at end, overall) can only occur before literal. The method is applicable on
     * expressions containing a goal description, i.e., NOT, AND, OR, WHEN, IMPLY, SOMETIME_AFTER, SOMETIME_BEFORE,
     * FORALL, EXISTS, ALWAYS, AT_MOST_ONCE, WITHIN, HOLD_AFTER, ALWAYS_WITHIN, HOLD_DURING, AT_START, AT_END, OVERALL,
     * ATOM, EQUAL_ATOM, EQUAL, LESS, LESS_OR_EQUAL, GREATER, GREATER_OR_EQUAL, ASSIGN, INCREASE, DECREASE, SCALE_UP,
     * SCALE_DOWN, TRUE and FALSE.
     *
     * @throws MalformedExpressionException if this expression is malformed.
     */
    public void toNNF()  {

        switch (this.getConnective()) {
            case NOT:
                this.moveNegationInward();
                break;
            case AND:
            case OR:
            case WHEN:
            case IMPLY:
            case SOMETIME_AFTER_CONSTRAINT:
            case SOMETIME_BEFORE_CONSTRAINT:
            case FORALL:
            case EXISTS:
            case AT_END_CONSTRAINT:
            case ALWAYS_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
            case ALWAYS_WITHIN_CONSTRAINT:
            case HOLD_DURING_CONSTRAINT:
                this.getChildren().forEach(Expression::toNNF);
                break;
            case AT_START:
            case AT_END:
            case OVER_ALL:
                this.moveTimeSpecifierInward();
                break;
            case ATOM:
            case EQUAL_ATOM:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case TASK_ID:
            case NUMBER:
            case TRUE:
            case FALSE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(this.toString());
        }
    }

    /**
     * Moves the negation inward the expression.
     *
     * @throws UnexpectedExpressionException if the expression is not composed of expressions that are not FORALL,
     *      EXISTS, AND, OR, NOT, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL, EQUAL, ATOM or EQUAL_ATOM.
     */
    public void moveNegationInward() {
        assert this.getConnective().equals(PDDLConnective.NOT);

        final Expression<T1, T2> child = this.getChildren().get(0);
        switch (child.getConnective()) {
            case FORALL:
                this.setConnective(PDDLConnective.EXISTS);
                this.setQuantifiedVariables(child.getQuantifiedVariables());
                Expression<T1, T2> negation = this.getInstance(PDDLConnective.NOT);
                negation.addChild(child.getChildren().get(0));
                negation.toNNF();
                this.getChildren().set(0, negation);
                break;
            case EXISTS:
                this.setConnective(PDDLConnective.FORALL);
                this.setQuantifiedVariables(child.getQuantifiedVariables());
                negation = this.getInstance(PDDLConnective.NOT);
                negation.addChild(child.getChildren().get(0));
                negation.toNNF();
                this.getChildren().set(0, negation);
                break;
            case AND:
                this.setConnective(PDDLConnective.OR);
                this.getChildren().clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    negation = this.getInstance(PDDLConnective.NOT);
                    negation.addChild(child.getChildren().get(i));
                    negation.toNNF();
                    this.getChildren().add(negation);
                }
                break;
            case OR:
                this.setConnective(PDDLConnective.AND);
                this.getChildren().clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    negation = this.getInstance(PDDLConnective.NOT);
                    negation.addChild(child.getChildren().get(i));
                    negation.toNNF();
                    this.getChildren().add(negation);
                }
                break;
            case NOT:
                this.assign(child.getChildren().get(0));
                this.toNNF();
                break;
            case IMPLY: // (not (imply p q)) -> (imply (not p) (not q))
                this.setConnective(PDDLConnective.IMPLY);
                final Expression notp = this.getInstance(PDDLConnective.NOT);
                notp.addChild(child.getChildren().get(0));
                notp.toNNF();
                final Expression notq = this.getInstance(PDDLConnective.NOT);
                notq.addChild(child.getChildren().get(1));
                notq.toNNF();
                this.getChildren().clear();
                this.getChildren().add(notp);
                this.getChildren().add(notq);
                break;
            case AT_START:
            case AT_END:
            case OVER_ALL:
                this.setConnective(child.getConnective());
                child.setConnective(PDDLConnective.NOT);
                break;
            case TRUE:
                this.setConnective(PDDLConnective.FALSE);
                break;
            case FALSE:
                this.setConnective(PDDLConnective.TRUE);
                break;
            case EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case ATOM:
            case EQUAL_ATOM:
                // Do nothing
                break;

            default:
                throw new UnexpectedExpressionException(this.toString());
        }
    }

    /**
     * Move the time specifier inward the expression.
     *
     * @throws UnexpectedExpressionException if the expression is not composed of expressions that are not FORALL,
     *      EXISTS, AND, OR, NOT, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL, EQUAL, ATOM or EQUAL_ATOM.
     */
    public void moveTimeSpecifierInward() {
        assert this.getConnective().equals(PDDLConnective.AT_START)
            || this.getConnective().equals(PDDLConnective.AT_END)
            || this.getConnective().equals(PDDLConnective.OVER_ALL);

        final Expression<T1, T2> child = this.getChildren().get(0);
        switch (child.getConnective()) {
            case FORALL:
            case EXISTS:
                Expression timeExp = this.getInstance(this.getConnective());
                timeExp.addChild(child.getChildren().get(0));
                timeExp.moveTimeSpecifierInward();
                this.getChildren().set(0, timeExp);
                this.setConnective(child.getConnective());
                this.setQuantifiedVariables(child.getQuantifiedVariables());
                break;
            case AND:
            case OR:
                this.getChildren().clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    timeExp = this.getInstance(this.getConnective());
                    timeExp.addChild(child.getChildren().get(i));
                    timeExp.moveTimeSpecifierInward();
                    this.getChildren().add(timeExp);
                }
                this.setConnective(child.getConnective());
                break;
            case NOT:
                child.toNNF();
                if (!child.getConnective().equals(PDDLConnective.NOT)) {
                    this.moveTimeSpecifierInward();
                }
                break;
            case EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case ATOM:
            case EQUAL_ATOM:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(this.toString());
        }
    }

    /**
     * Simplify the expression. This method removes:
     * <ul>
     *   <li>double negation</li>
     *   <li>unnecessary inner conjunctions or disjunctions</li>
     *   <li>equality always true</li>
     *   <li>disjunction or conjunction containing a and not a </li>
     *   <li>unnecessary conditional effect</li>
     *   <li>duplicated expression</li>
     *   </ul>
     *
     * @return <code>true</code> if the expression was simplified; <code>false</code> otherwise.
     * @throws UnexpectedExpressionException if the expression is not composed of expressions that are not FORALL,
     *      EXISTS, AND, OR, NOT, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL, EQUAL, ATOM or EQUAL_ATOM, WHEN, TRUE,
     *      FALSE, HOLD_AFTER_METHOD_CONSTRAINT, HOLD_BEFORE_METHOD_CONSTRAINT, AT_END_METHOD_CONSTRAINT,
     *      AT_START_METHOD_CONSTRAINT, ALWAYS_METHOD_CONSTRAINT, AT_MOST_ONCE_METHOD_CONSTRAINT,
     *      SOMETIME_METHOD_CONSTRAINT, SOMETIME_BEFORE_METHOD_CONSTRAINT, SOMETIME_AFTER_METHOD_CONSTRAINT,
     *      HOLD_BETWEEN_METHOD_CONSTRAINT, HOLD_DURING_METHOD_CONSTRAINT.
     */
    public boolean simplify() throws UnexpectedExpressionException {
        boolean simplified = false;
        switch (this.getConnective()) {
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case AT_END_CONSTRAINT:
            case ALWAYS_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case SOMETIME_CONSTRAINT:
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
                Expression<T1, T2> child = this.getChildren().get(0);
                child.simplify();
                if (child.getConnective().equals(PDDLConnective.TRUE)
                    || child.getConnective().equals(PDDLConnective.FALSE)) {
                    this.setConnective(child.getConnective());
                    simplified = true;
                }
                break;
            case IMPLY:
                // replace imply expression (imply p q) by its equivalent disjunction (or (not p) q)
                this.setConnective(PDDLConnective.OR);
                final Expression notp = this.getInstance(PDDLConnective.NOT);
                notp.addChild(this.getChildren().get(0));
                this.getChildren().set(0, notp);
                simplified = this.simplify();
                break;
            case AND:
                simplified &= this.removeDuplicateChild();
                simplified &= this.removedTautology();
                if (this.getChildren().isEmpty()) {
                    this.setConnective(PDDLConnective.TRUE);
                    simplified = true;
                } else if (this.getChildren().size() == 1) {
                    this.assign(this.getChildren().get(0));
                    this.simplify();
                    simplified = true;
                } else {
                    int i = 0;
                    while (i < this.getChildren().size()
                        && !this.getConnective().equals(PDDLConnective.TRUE)
                        && !this.getConnective().equals(PDDLConnective.FALSE)) {
                        child = this.getChildren().get(i);
                        simplified &= child.simplify();
                        if (child.getConnective().equals(PDDLConnective.FALSE)) {
                            this.setConnective(PDDLConnective.FALSE);
                            simplified = true;
                        } else if (child.getConnective().equals(PDDLConnective.TRUE)) {
                            this.getChildren().remove(i);
                            simplified = true;
                        } else if (child.getConnective().equals(PDDLConnective.AND)) {
                            this.getChildren().remove(i);
                            this.getChildren().addAll(i, child.getChildren());
                            i += child.getChildren().size();
                            simplified = true;
                        } else {
                            i++;
                        }
                    }
                }
                break;
            case OR:
                simplified &= this.removeDuplicateChild();
                simplified &= this.removedTautology();
                if (this.getChildren().isEmpty()) {
                    this.setConnective(PDDLConnective.TRUE);
                    simplified = true;
                } else if (this.getChildren().size() == 1) {
                    this.assign(this.getChildren().get(0));
                    this.simplify();
                    simplified = true;
                } else {
                    int i = 0;
                    while (i < this.getChildren().size()
                        && !this.getConnective().equals(PDDLConnective.TRUE)
                        && !this.getConnective().equals(PDDLConnective.FALSE)) {
                        child = this.getChildren().get(i);
                        simplified &= child.simplify();
                        if (child.getConnective().equals(PDDLConnective.TRUE)) {
                            this.setConnective(PDDLConnective.TRUE);
                            simplified = true;
                        } else if (child.getConnective().equals(PDDLConnective.FALSE)) {
                            this.getChildren().remove(i);
                            simplified = true;
                        } else if (child.getConnective().equals(PDDLConnective.OR)) {
                            this.getChildren().remove(i);
                            this.getChildren().addAll(i, child.getChildren());
                            i += child.getChildren().size();
                            simplified = true;
                        } else {
                            i++;
                        }
                    }
                }
                break;
            case NOT:
                child = this.getChildren().get(0);
                simplified &= child.simplify();
                if (child.getConnective().equals(PDDLConnective.NOT)) {
                    this.assign(child.getChildren().get(0));
                    simplified = true;
                } else if (child.getConnective().equals(PDDLConnective.TRUE)) {
                    this.setConnective(PDDLConnective.FALSE);
                    simplified = true;
                } else if (child.getConnective().equals(PDDLConnective.FALSE)) {
                    this.setConnective(PDDLConnective.TRUE);
                    simplified = true;
                }
                break;
            case WHEN:
                Expression condition = this.getChildren().get(0);
                simplified &= condition.simplify();
                Expression effect = this.getChildren().get(1);
                simplified &= effect.simplify();
                if (condition.getConnective().equals(PDDLConnective.TRUE)) {
                    this.assign(effect);
                    simplified = true;
                } else if (condition.getConnective().equals(PDDLConnective.FALSE)) {
                    this.setConnective(PDDLConnective.TRUE);
                    simplified = true;
                }
                break;
            case EQUAL_ATOM:
                if (this.getArguments().get(0).equals(this.getArguments().get(1))) {
                    this.setConnective(PDDLConnective.TRUE);
                    simplified = true;
                }
                break;
            case SOMETIME_AFTER_CONSTRAINT: // Simplification must be checked with the constraints semantic
            case SOMETIME_BEFORE_CONSTRAINT:
                simplified &= this.getChildren().get(0).simplify();
                simplified &= this.getChildren().get(1).simplify();
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
                simplified &= this.getChildren().get(0).simplify();
                simplified &= this.getChildren().get(1).simplify();
                simplified &= this.getChildren().get(2).simplify();
                break;
            case HOLD_DURING_CONSTRAINT:
                if (this.getChildren().get(0).getValue() > this.getChildren().get(1).getValue()) {
                    this.setConnective(PDDLConnective.FALSE);
                    simplified = true;
                } else {
                    child = this.getChildren().get(0);
                    simplified &= child.simplify();
                    if (child.getConnective().equals(PDDLConnective.TRUE)
                        || child.getConnective().equals(PDDLConnective.FALSE)) {
                        this.setConnective(child.getConnective());
                        simplified = true;
                    }
                }
                break;
            case EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case NUMBER:
            case TASK_ID:
            case ATOM:
            case TRUE:
            case FALSE:
                break;
            default:
                throw new UnexpectedExpressionException(this.toString());
        }
        return simplified;
    }


    /**
     * Removed duplicated child in conjunction and disjunction expressions. The expression in parameter is
     * modified. If a duplicated subexpression is found, the duplicated expression is removed.
     *
     * @return <code>true</code> if the expression was not modified; <code>false</code> otherwise.
     */
    private boolean removeDuplicateChild() {
        assert this.getConnective().equals(PDDLConnective.AND)
            || this.getConnective().equals(PDDLConnective.OR);
        boolean modified = false;
        for (int i = 0; i < this.getChildren().size(); i++) {
            final Expression ei =  this.getChildren().get(i);
            for (int j = i + 1; j < this.getChildren().size(); j++) {
                final Expression ej = this.getChildren().get(j);
                if (ei.equals(ej)) {
                    this.getChildren().remove(j);
                    j--;
                    modified = true;
                }
            }
        }
        return modified;
    }

    /**
     * Removes tautologies of the form (a and not a) in conjunctive and disjunctive expressions. The expression
     * in parameter is modified. If a tautology is detected, the subexpression of the tautology are removed and replaced
     * by a TRUE expression.
     *
     * @return <code>true</code> if the expression was not modified; <code>false</code> otherwise.
     */
    private boolean removedTautology() {
        assert this.getConnective().equals(PDDLConnective.AND)
            || this.getConnective().equals(PDDLConnective.OR);
        boolean modified = false;
        for (int i = 0; i < this.getChildren().size(); i++) {
            final Expression ei = this.getChildren().get(i);
            final Expression neg = this.getInstance(PDDLConnective.NOT);
            neg.addChild(ei);
            for (int j = i + 1; j < this.getChildren().size(); j++) {
                final Expression ej = this.getChildren().get(j);
                if (ej.equals(neg)) {
                    ei.setConnective(PDDLConnective.TRUE);
                    this.getChildren().remove(j);
                    j--;
                    modified = true;
                }
            }
        }
        return modified;
    }

    /**
     * Returns if a specified expression is contains, i.e., is a sub-expression of this expression. More
     * formally, returns <code>true</code> if and only if this expression contains at least one
     * subexpression <code>s</code> such that <code>s.equals(exp)</code>.
     *
     * @param exp the expression to test.
     * @return <code>true</code> if the specified expression <code>exp</code> is a sub-expression of
     *          this expression; <code>false</code> otherwise.
     */
    public final boolean contains(final Expression<T1, T2> exp) {
        for (Expression s : this.getChildren()) {
            if (s.equals(exp) || s.contains(exp)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all the occurrences of a specified expression contained in this expression and
     * returns <code>true</code> if and only if at least one occurrence was removed.
     *
     * @param exp the expression to remove.
     * @return <code>true</code> if the specified expression <code>exp</code> was removed;
     *          <code>false</code> otherwise.
     */
    public final boolean remove(final Expression<T1, T2> exp) {
        boolean removed = false;
        Iterator<Expression<T1, T2>> it = this.getChildren().iterator();
        while (it.hasNext()) {
            Expression s = it.next();
            if (s.equals(exp)) {
                it.remove();
                removed = true;
            } else {
                removed = removed || s.remove(exp);
            }
        }
        return removed;
    }



    /**
     * Returns if this expression is malformed. An expression is considered as well in the following cases:
     * <ul>
     * <li>OR and AND expressions have to have all their child well-formed.</li>
     * <li>EQUAL_ATOM expressions are well-formed if the expression contains an atom of at least two symbols.</li>
     * <li>Quantified expressions (EXISTS, FORALL) is well formed if it has at least one quantified variable and one
     * child expression.</li>
     * <li>IMPLY, WHEN, EQUAL_COMPARISON, LESS_COMPARISON, LESS_OR_EQUAL_COMPARISON, GREATER_COMPARISON,
     * GREATER_OR_EQUAL_COMPARISON, ASSIGN, INCREASE, DECREASE, SCALE_UP, SCALE_DOWN, MULTIPLICATION, DIVISION, MINUS,
     * PLUS, SOMETIME_AFTER_CONSTRAINT, SOMETIME_BEFORE_CONSTRAINT expressions are well-formed if they have to child and
     * both child are well-formed.</li>
     * <li> NOT, UMINUS, AT_START, AT_END, OVER_ALL, MINIMIZE, MAXIMIZE, F_EXP_T, F_EXP, AT_END_METHOD_CONSTRAINT,
     * AT_START_METHOD_CONSTRAINT, ALWAYS_METHOD_CONSTRAINT, AT_MOST_ONCE_METHOD_CONSTRAINT, SOMETIME_METHOD_CONSTRAINT
     * expression are well-formed if they have on child and if it is well-formed.</li>
     * <li>ATOM, TASKS, and F_HEAD expressions without any symbols as arguments are considered as well formed.</li>
     * <li>TIMED_LITERAL, WITHIN_CONSTRAINT, HOLD_AFTER_CONSTRAINT, HOLD_BEFORE_METHOD_CONSTRAINT,
     * HOLD_AFTER_METHOD_CONSTRAINT, SOMETIME_BEFORE_METHOD_CONSTRAINT,
     * SOMETIME_AFTER_METHOD_CONSTRAINT expressions are considered as well-formed if they have well-formed child and a
     * time value.</li>
     * <li>HOLD_DURING_CONSTRAINT, HOLD_BETWEEN_METHOD_CONSTRAINT, HOLD_DURING_METHOD_CONSTRAINT expressions are
     * well-formed if they have two child well-formed and an time interval value.</li>
     * <li>ALWAYS_WITHIN expression must have at least two children to be considered as well formed and time interval
     * value.</li>.
     * <li>NUMBER expressions are considered is they have a value.</li>
     * <li>TIME_VAR, IS_VIOLATED exprssions are always considered as well-formed</li>
     * </ul>
     *
     * @return <code>true</code> if the expression is malformed; <code>false</code> otherwise.
     */
    public boolean isMalformedExpression() {
        boolean malformed = false;
        switch (this.getConnective()) {
            case AND:
            case OR:
                Iterator<Expression<T1, T2>> i = this.getChildren().iterator();
                while (!malformed && i.hasNext()) {
                    malformed |= i.next().isMalformedExpression();
                }
                break;
            case EQUAL_ATOM:
                malformed = this.getArguments().size() != 2;
                break;
            case FORALL:
            case EXISTS:
                malformed = this.getQuantifiedVariables().isEmpty()
                    || this.getChildren().isEmpty()
                    || this.getChildren().get(0).isMalformedExpression();
                break;
            case IMPLY:
            case WHEN:
            case EQUAL_COMPARISON:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MULTIPLICATION:
            case DIVISION:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER_CONSTRAINT:
            case SOMETIME_BEFORE_CONSTRAINT:
                malformed = this.getChildren().size() != 2
                    || this.getChildren().get(0).isMalformedExpression()
                    || this.getChildren().get(1).isMalformedExpression();
                break;
            case NOT:
            case UMINUS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case MINIMIZE:
            case MAXIMIZE:
            case F_EXP_T:
            case F_EXP:
            case AT_END_CONSTRAINT:
            case ALWAYS_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case SOMETIME_CONSTRAINT:
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
                malformed = this.getChildren().size() != 1
                    || this.getChildren().get(0).isMalformedExpression();
                break;
            case ATOM:
            case TASK:
            case FN_HEAD:
                malformed = this.getSymbol() == null;
                break;
            case TIMED_LITERAL:
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
                malformed = this.getChildren().size() != 2
                    || !this.getChildren().get(0).getConnective().equals(PDDLConnective.NUMBER)
                    || this.getChildren().get(1).isMalformedExpression();
                break;
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
                malformed = this.getChildren().size() != 2
                    || !this.getChildren().get(0).getConnective().equals(PDDLConnective.TASK_ID)
                    || this.getChildren().get(1).isMalformedExpression();
                break;
            case HOLD_DURING_CONSTRAINT:
                malformed = this.getChildren().size() != 3
                    || !this.getChildren().get(0).getConnective().equals(PDDLConnective.NUMBER)
                    || !this.getChildren().get(1).getConnective().equals(PDDLConnective.NUMBER)
                    || this.getChildren().get(2).isMalformedExpression();
                break;
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
                malformed = this.getChildren().size() != 3
                    || !this.getChildren().get(0).getConnective().equals(PDDLConnective.TASK_ID)
                    || !this.getChildren().get(1).getConnective().equals(PDDLConnective.TASK_ID)
                    || this.getChildren().get(2).isMalformedExpression();
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
                malformed = this.getChildren().size() != 4
                    || !this.getChildren().get(0).getConnective().equals(PDDLConnective.NUMBER)
                    || !this.getChildren().get(1).getConnective().equals(PDDLConnective.NUMBER)
                    || this.getChildren().get(2).isMalformedExpression()
                    || this.getChildren().get(3).isMalformedExpression();
                break;
            case NUMBER:
                malformed = this.getValue() == null;
                break;
            case TASK_ID:
                malformed = this.getTaskID() == null;
                break;
            case TIME_VAR:
            case IS_VIOLATED:
            case TRUE:
            case FALSE:
                break;
            case LESS_ORDERING_CONSTRAINT:
            case LESS_OR_EQUAL_ORDERING_CONSTRAINT:
            case GREATER_ORDERING_CONSTRAINT:
            case GREATER_OR_EQUAL_ORDERING_CONSTRAINT:
            case EQUAL_ORDERING_CONSTRAINT:
                malformed = this.getChildren().size() != 2
                    && this.getChildren().get(0).getConnective().equals(PDDLConnective.TASK_ID)
                    && this.getChildren().get(0).isMalformedExpression()
                    && this.getChildren().get(1).getConnective().equals(PDDLConnective.TASK_ID)
                    && this.getChildren().get(1).isMalformedExpression();
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().toString());

        }
        return malformed;
    }

    /**
     * Returns a string representation of this node.
     *
     * @return a string representation of this node.
     * @see java.lang.Object#toString
     */
    @Override
    public String toString() {
        return this.toString("");
    }

    /**
     * Returns a string representation of this parser node.
     *
     * @param baseOffset the offset white space from the left used for indentation.
     * @return a string representation of this parser node.
     * @throws MalformedExpressionException if the expression is malformed.
     */
    public String toString(String baseOffset) throws MalformedExpressionException {
        if (this.isMalformedExpression()) {
            throw new MalformedExpressionException("Expression " + this.getConnective() + " is malformed");
        }
        StringBuilder str = new StringBuilder();
        switch (this.getConnective()) {
            case ATOM:
            case FN_HEAD:
                str.append("(");
                str.append(this.getSymbol());
                str.append(" ");
                if (!this.getArguments().isEmpty()) {
                    for (int i = 0; i < this.getArguments().size() - 1; i++) {
                        str.append(this.getArguments().get(i).toString()).append(" ");
                    }
                    str.append(this.getArguments().get(this.getArguments().size() - 1).toString());
                }
                str.append(")");
                break;
            case TASK:
                str.append("(");
                str.append(this.getSymbol());
                str.append(" ");
                if (!this.getArguments().isEmpty()) {
                    if (this.getTaskID() != null) {
                        str.append(this.getTaskID()).append(" (");
                    }
                    for (int i = 0; i < this.getArguments().size() - 1; i++) {
                        str.append(this.getArguments().get(i).toString()).append(" ");
                    }
                    str.append(this.getArguments().get(this.getArguments().size() - 1).toString());
                }
                str.append(")");
                break;
            case EQUAL_ATOM:
                str.append("(")
                    .append(this.getConnective().getImage())
                    .append(" ");
                for (int i = 0; i < this.getArguments().size() - 1; i++) {
                    str.append(this.getArguments().get(i).toString()).append(" ");
                }
                str.append(this.getArguments().get(this.getArguments().size() - 1).toString()).append(")");
                break;
            case AND:
            case OR:
                if (!this.getChildren().isEmpty()) {
                    String offset = baseOffset + "  ";
                    str.append("(").append(this.getConnective().getImage());
                    str.append(" ");
                    for (int i = 0; i < this.getChildren().size() - 1; i++) {
                        str.append(this.getChildren().get(i).toString(offset)).append("\n").append(offset);
                    }
                    str.append(this.getChildren().get(this.getChildren().size() - 1).toString(offset));
                    str.append(")");
                } else {
                    str.append("()");
                }
                break;
            case IMPLY:
                str.append("(");
                str.append(this.getConnective().getImage());
                str.append(" ");
                str.append(this.getChildren().get(0).toString(baseOffset));
                str.append(" ");
                str.append(this.getChildren().get(1).toString(baseOffset));
                str.append(")");
                break;
            case FORALL:
            case EXISTS:
                String off = baseOffset + baseOffset + "  ";
                str.append(" (");
                str.append(this.getConnective().getImage());
                str.append(" (");
                if (!this.getQuantifiedVariables().isEmpty()) {
                    for (int i = 0; i < this.getQuantifiedVariables().size() - 1; i++) {
                        str.append(this.getQuantifiedVariables().get(i).toString());
                        str.append(", ");
                    }
                    str.append(this.getQuantifiedVariables().get(this.getQuantifiedVariables().size() - 1).toString());
                }
                str.append(")\n");
                str.append(off);
                str.append(this.children.get(0).toString(off));
                str.append(")");
                break;
            case NUMBER:
                str.append(this.value);
                break;
            case F_EXP:
                str.append(this.children.get(0).toString(baseOffset));
                break;
            case F_EXP_T:
                if (this.children.isEmpty()) {
                    str.append(this.getVariable());
                } else {
                    str.append("(").append(this.getConnective().getImage()).append(" ")
                        .append(this.getVariable()).append(" ")
                        .append(this.children.get(0).toString(baseOffset));
                }
                break;
            case TIME_VAR:
                str.append(this.getVariable());
                break;
            case FN_ATOM:
            case WHEN:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MULTIPLICATION:
            case DIVISION:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER_CONSTRAINT:
            case SOMETIME_BEFORE_CONSTRAINT:
                str.append("(");
                str.append(this.getConnective().getImage()).append(" ");
                str.append(this.children.get(0).toString(baseOffset)).append(" ");
                str.append(this.children.get(1).toString(baseOffset));
                str.append(")");
                break;
            case LESS_ORDERING_CONSTRAINT:
            case LESS_OR_EQUAL_ORDERING_CONSTRAINT:
            case GREATER_ORDERING_CONSTRAINT:
            case GREATER_OR_EQUAL_ORDERING_CONSTRAINT:
            case EQUAL_ORDERING_CONSTRAINT:
                str.append("(");
                str.append(this.getConnective().getImage()).append(" ");
                str.append(this.arguments.get(0).toString()).append(" ");
                str.append(this.arguments.get(1).toString());
                str.append(")");
                break;
            case NOT:
            case UMINUS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case AT_END_CONSTRAINT:
            case ALWAYS_CONSTRAINT:
            case SOMETIME_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
                str.append("(");
                str.append(this.getConnective().getImage()).append(" ");
                str.append(this.getChildren().get(0).toString(baseOffset));
                str.append(")");
                break;
            case MINIMIZE:
            case MAXIMIZE:
                str.append(this.getConnective().getImage()).append(" ")
                    .append(this.getChildren().get(0).getValue())
                    .append(")");
                break;
            case IS_VIOLATED:
                str.append("(").append(this.getConnective().getImage()).append(")");
                break;
            case TIMED_LITERAL:
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
                str.append("(");
                str.append(this.getConnective().getImage()).append(" ");
                str.append(this.getChildren().get(0).toString()).append(" ");
                str.append(this.getChildren().get(1).toString(baseOffset));
                str.append(")");
                break;
            case HOLD_DURING_CONSTRAINT:
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
                str.append("(");
                str.append(this.getConnective().getImage()).append(" ");
                str.append(this.getChildren().get(0).toString()).append(" ");
                str.append(this.getChildren().get(1).toString()).append(" ");
                str.append(this.getChildren().get(2).toString(baseOffset));
                str.append(")");
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
                str.append("(");
                str.append(this.getConnective().getImage()).append(" ");
                str.append(this.getChildren().get(0).toString()).append(" ");
                str.append(this.getChildren().get(1).toString()).append(" ");
                str.append(this.getChildren().get(2).toString(baseOffset));
                str.append(this.getChildren().get(3).toString(baseOffset));
                str.append(")");
                break;
            case TASK_ID:
                str.append(this.getTaskID().toString());
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().toString());

        }
        return str.toString();
    }


    /**
     * Renames the symbol from a specified index. The symbol is renamed if only if this symbol is a
     * variable, otherwise nothing is done. After rename operation the variable will have the form
     * <code>?Xn</code> where <code>n</code> is the specified index.
     *
     * @param index the index of the symbol.
     * @return the old image of the symbol or null if the symbol was not renamed.
     * @throws IllegalArgumentException if index is &#60; 0.
     */
    public final static String renameVariables(final PDDLSymbol symbol, final int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        String img = null;
        if (symbol.getKind().equals(SymbolType.VARIABLE)) {
            img = symbol.getImage();
            symbol.setImage(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL + index);
        }
        return img;
    }

    /**
     * Renames the variable contained in this typed list. For instance, if the nth argument is a
     * variable it will be rename <code>?Xn</code>.
     *
     */
    public static final void renameVariables(final PDDLNamedTypedList list) {
        for (int i = 0; i < list.getArguments().size(); i++) {
            AbstractExpression.renameVariables(list.getArguments().get(i), i);
        }
    }

    /**
     * Renames the symbol from a specified symbolEncoding. The symbol is renamed if only if this symbol is a
     * variable, otherwise nothing is done.
     *
     * @param context the images of the already renamed variables.
     * @return the old image of the symbol or null if the symbol was not renamed.
     * @throws NullPointerException if context == null.
     */
    public static final String renameVariables(final PDDLSymbol symbol, final Map<String, String> context) {
        String img = null;
        if (symbol.getKind().equals(SymbolType.VARIABLE)) {
            img = symbol.getImage();
            final String newImage = context.get(img);
            if (newImage != null) {
                symbol.setImage(newImage);
                return img;
            }
        }
        return null;
    }

    /**
     * Renames the task ID symbol according to a specific context. The symbol is renamed if only if this symbol is a
     * task ID, otherwise nothing is done.
     *
     * @param context the images of the already renamed task ID.
     * @return the old image of the symbol or null if the symbol was not renamed.
     */
    public final static String renameTaskID(PDDLSymbol symbol, final Map<String, String> context) {
        if (symbol.getKind().equals(SymbolType.TASK_ID)) {
            String image = symbol.getImage();
            String newImage = context.get(image);
            if (newImage == null) {
                newImage = PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + context.size();
                context.put(image, newImage);
            }
            symbol.setImage(newImage);
            return image;
        }
        return null;
    }
}
