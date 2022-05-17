package fr.uga.pddl4j.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractExpression implements Expression {

    /**
     * The type of the node.
     */
    private PDDLConnective connective;

    /**
     * The children expression of this expression.
     */
    private List<Expression> children;

    /**
     * The value associate to this node.
     */
    private Double value;

    /**
     * Creates a new expression from another one. This constructor creates a deep copy.
     *
     * @param other the other expression.
     * @throws NullPointerException if other is null.
     */
    public AbstractExpression(final Expression other) {
        super();
        if (other == null) {
            throw new NullPointerException("other == null");
        }
        this.setConnective(other.getConnective());
        if (other.getChildren() != null) {
            this.children = new ArrayList<>();
            /*this.children.addAll(other.getChildren().stream()
                .map(AbstractExpression::new).collect(Collectors.toList()));

            for (Expression child : this.getChildren()) {
                this.addChild(new E);
            }*/
        } else {
            this.children = new ArrayList<>();
        }
        this.setValue(other.getValue());
    }

    /**
     * Creates a new PDDL expression with a specified connective.
     *
     * @param connective the connective.
     * @throws RuntimeException if the specified connective is null.
     */
    public AbstractExpression(final PDDLConnective connective) {
        super();
        this.connective = connective;
        this.children = new ArrayList<>();
        this.value = null;
    }

    /**
     * Creates a new empty AND expression.
     */
    public AbstractExpression() {
        this(PDDLConnective.AND);
    }

    /**
     * Add a new child expression to this expression.
     *
     * @param exp the child to add
     * @return <code>true</code> if the expression was added; <code>false</code> otherwise
     */
    public final boolean addChild(final Expression exp) {
        return this.children.add(exp);
    }

    /**
     * Returns the list of children of this expression.
     *
     * @return the list of children of this expression.
     */
    public List<Expression> getChildren() {
        return this.children;
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
     * Returns the connective of this expression.
     *
     * @return the connective of this expression.
     */
    public final PDDLConnective getConnective() {
        return this.connective;
    }

    /**
     * Set the value of this expression.
     *
     * @param value the value of this expression.
     */
    public final void setValue(final Double value) {
        this.value = value;
    }

    /**
     * Returns the value of this expression.
     *
     * @return the value of this expression.
     */
    public final Double getValue() {
        return this.value;
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
    /*public void moveNegationInward() {
        assert this.getConnective().equals(PDDLConnective.NOT);

        final Expression child = this.getChildren().get(0);
        switch (child.getConnective()) {
            case FORALL:
                this.setConnective(PDDLConnective.EXISTS);
                //this.assignVariables(child);
                Expression negation = new AbstractExpression(PDDLConnective.NOT);
                negation.addChild(child.getChildren().get(0));
                negation.toNNF();
                this.getChildren().set(0, negation);
                break;
            case EXISTS:
                this.setConnective(PDDLConnective.FORALL);
                //this.assignVariables(child);
                negation = new AbstractExpression(PDDLConnective.NOT);
                negation.addChild(child.getChildren().get(0));
                negation.toNNF();
                this.getChildren().set(0, negation);
                break;
            case AND:
                this.setConnective(PDDLConnective.OR);
                this.getChildren().clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    negation = new AbstractExpression(PDDLConnective.NOT);
                    negation.addChild(child.getChildren().get(i));
                    negation.toNNF();
                    this.getChildren().add(negation);
                }
                break;
            case OR:
                this.setConnective(PDDLConnective.AND);
                this.getChildren().clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    negation = new AbstractExpression(PDDLConnective.NOT);
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
                final Expression notp = new AbstractExpression(PDDLConnective.NOT);
                notp.addChild(child.getChildren().get(0));
                notp.toNNF();
                final Expression notq = new AbstractExpression(PDDLConnective.NOT);
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
    /*public void moveTimeSpecifierInward() {
        assert this.getConnective().equals(PDDLConnective.AT_START)
            || this.getConnective().equals(PDDLConnective.AT_END)
            || this.getConnective().equals(PDDLConnective.OVER_ALL);

        final Expression child = this.getChildren().get(0);
        switch (child.getConnective()) {
            case FORALL:
            case EXISTS:
                Expression timeExp = new AbstractExpression(this.getConnective());
                timeExp.addChild(child.getChildren().get(0));
                timeExp.moveTimeSpecifierInward();
                this.getChildren().set(0, timeExp);
                this.setConnective(child.getConnective());
                //this.assignVariables(child);
                break;
            case AND:
            case OR:
                this.getChildren().clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    timeExp = new AbstractExpression(this.getConnective());
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
    /*public boolean simplify() throws UnexpectedExpressionException {
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
                Expression child = this.getChildren().get(0);
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
                final Expression notp = new AbstractExpression(PDDLConnective.NOT);
                notp.addChild(this.getChildren().get(0));
                this.getChildren().set(0, notp);
                simplified = this.simplify();
                break;
            case AND:
                simplified &= this.removeDuplicateChild(this);
                simplified &= this.removedTautology(this);
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
                simplified &= this.removeDuplicateChild(this);
                simplified &= this.removedTautology(this);
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
                /*if (this.getAtom().get(0).equals(this.getAtom().get(1))) {
                    this.setConnective(PDDLConnective.TRUE);
                    simplified = true;
                }*/
                /*break;
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
     * @param exp the expression to test. The expression must be a conjunction of a disjunction.
     * @return <code>true</code> if the expression was not modified; <code>false</code> otherwise.
     */
    private boolean removeDuplicateChild(Expression exp) {
        assert exp.getConnective().equals(PDDLConnective.AND)
            || exp.getConnective().equals(PDDLConnective.OR);
        boolean modified = false;
        for (int i = 0; i < exp.getChildren().size(); i++) {
            final Expression ei = exp.getChildren().get(i);
            for (int j = i + 1; j < exp.getChildren().size(); j++) {
                final Expression ej = exp.getChildren().get(j);
                if (ei.equals(ej)) {
                    exp.getChildren().remove(j);
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
     * @param exp the expression to test. The expression must be a conjunction of a disjunction.
     * @return <code>true</code> if the expression was not modified; <code>false</code> otherwise.
     */
    /*private boolean removedTautology(Expression exp) {
        assert exp.getConnective().equals(PDDLConnective.AND)
            || exp.getConnective().equals(PDDLConnective.OR);
        boolean modified = false;
        for (int i = 0; i < exp.getChildren().size(); i++) {
            final Expression ei = exp.getChildren().get(i);
            final Expression neg = new PDDLExpression(PDDLConnective.NOT);
            neg.addChild(ei);
            for (int j = i + 1; j < exp.getChildren().size(); j++) {
                final Expression ej = exp.getChildren().get(j);
                if (ej.equals(neg)) {
                    ei.setConnective(PDDLConnective.TRUE);
                    exp.getChildren().remove(j);
                    j--;
                    modified = true;
                }
            }
        }
        return modified;
    }*/

    /**
     * Returns if a specified expression is contains, i.e., is a sub-expression of this expression. More
     * formally, returns <code>true</code> if and only if this expression contains at least one
     * subexpression <code>s</code> such that <code>s.equals(exp)</code>.
     *
     * @param exp the expression to test.
     * @return <code>true</code> if the specified expression <code>exp</code> is a sub-expression of
     *          this expression; <code>false</code> otherwise.
     */
    public final boolean contains(final Expression exp) {
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
    public final boolean remove(final Expression exp) {
        boolean removed = false;
        Iterator<Expression> it = this.getChildren().iterator();
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
                Iterator<Expression> i = this.getChildren().iterator();
                while (!malformed && i.hasNext()) {
                    malformed |= i.next().isMalformedExpression();
                }
                break;
            case EQUAL_ATOM:
                //malformed = this.atom.size() != 2;
                break;
            case FORALL:
            case EXISTS:
                /*malformed = this.variables.isEmpty()
                    || this.getChildren().isEmpty()
                    || this.getChildren().get(0).isMalformedExpression();*/
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
                //malformed = this.getAtom().isEmpty();
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
                //malformed = this.getTaskID() == null;
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
}
