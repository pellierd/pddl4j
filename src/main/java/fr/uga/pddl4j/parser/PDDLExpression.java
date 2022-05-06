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

package fr.uga.pddl4j.parser;

import fr.uga.pddl4j.parser.lexer.Token;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class implements a parser node used in PDDL expressions.
 * <p>
 * Modifications:
 * </p>
 * <ul>
 * <li>11.12.2012: Add method <code>isLiteral()</code>.</li>
 * <li>29.04.2020: Fix bug in hashcode method. </li>
 * </ul>
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public class PDDLExpression extends AbstractParserObject {

    /**
     * The type of the node.
     */
    private PDDLConnective connective;

    /**
     * only for parsing: the variable in quantifiers.
     */
    private List<PDDLTypedSymbol> variables;

    /**
     * AND, OR, NOT, WHEN &#61;&#62; NULL ALL, EX &#61;&#62; the quantified variable with its type ATOM &#61;&#62;
     * the atom as predicate&#45;&#62;param1&#45;&#62;param2&#45;&#62;...
     */
    private List<PDDLSymbol> atom;

    /**
     * (a) for AND, OR this is the list of sons(a AND b AND c...), (b) for the rest this is the son,
     * e.g. a subtree that is negated (c) for WHEN, the first son is the condition and the next son
     * is the effect
     */
    private List<PDDLExpression> children;

    /**
     * The value associate to this node.
     */
    private Double value;

    /**
     * The name of the preference.
     */
    private PDDLSymbol prefName;

    /**
     * The variable.
     */
    private PDDLSymbol variable;

    /**
     * The taskID. Use to the alias of a task atom.
     */
    private PDDLSymbol taskID;

    /**
     * The time of this expression.
     */
    private PDDLSymbol time;

    /**
     * The time interval of this expression.
     */
    private PDDLTimeInterval timeInterval;

    /**
     * Creates a new PDDL expression from a other one.
     *
     * @param other the other expression.
     * @throws NullPointerException if other is null.
     */
    public PDDLExpression(final PDDLExpression other) {
        super(other);
        if (other == null) {
            throw new NullPointerException("other == null");
        }
        this.connective = other.getConnective();
        if (other.getAtom() != null) {
            this.atom = new ArrayList<>();
            this.atom.addAll(other.getAtom().stream().map(PDDLSymbol::new).collect(Collectors.toList()));
        }
        if (other.getChildren() != null) {
            this.children = new ArrayList<>();
            this.children.addAll(other.getChildren().stream().map(PDDLExpression::new).collect(Collectors.toList()));
        }
        this.prefName = other.getPrefName();
        if (other.getVariables() != null) {
            this.variables = new ArrayList<>();
            this.variables.addAll(other.getVariables().stream().map(PDDLTypedSymbol::new).collect(Collectors.toList()));
        }
        if (other.getVariable() != null) {
            this.variable = new PDDLSymbol(other.getVariable());
        }
        if (other.getTime() != null) {
            this.time = new PDDLSymbol(other.getTime());
        }
        if (other.getTimeInterval() != null) {
            this.timeInterval = new PDDLTimeInterval(other.getTimeInterval());
        }
        this.value = other.getValue();
    }

    /**
     * Creates a new empty AND expression.
     */
    private PDDLExpression() {
        super();
        this.connective = PDDLConnective.AND;
        this.atom = null;
        this.children = new ArrayList<>();
        this.prefName = null;
        this.variables = null;
        this.value = null;
        this.taskID = null;
        this.time = null;
        this.timeInterval = null;
    }

    /**
     * Creates a new PDDL expression with a specified connective.
     *
     * @param connective the connective.
     * @throws RuntimeException if the specified connective is null.
     */
    public PDDLExpression(final PDDLConnective connective) {
        this();
        this.connective = connective;
    }

    /**
     * Attach a new child to this node.
     *
     * @param exp the son to add
     * @return <code>true</code> if the node was added; <code>false</code> otherwise
     * @throws RuntimeException if the specified node is null
     */
    public boolean addChild(final PDDLExpression exp) {
        return this.children.add(exp);
    }

    /**
     * Sets the parse variable of this node, i.e., the var args in quantifiers.
     *
     * @param variables the parse variables.
     */
    public void setVariables(final List<PDDLTypedSymbol> variables) {
        this.variables = variables;
    }

    /**
     * Returns the variable of this parser node.
     *
     * @return the variable of this parser node.
     */
    public final PDDLSymbol getVariable() {
        return this.variable;
    }

    /**
     * Sets a new variable to this parser node.
     *
     * @param variable the new variable to set.
     */
    public void setVariable(final PDDLSymbol variable) {
        this.variable = variable;
    }

    /**
     * Sets the atom of this node.
     *
     * @param atom the atom of this node.
     */
    public final void setAtom(final List<PDDLSymbol> atom) {
        this.atom = atom;
    }

    /**
     * Set the connective of this node.
     *
     * @param connective the connective.
     * @throws IllegalArgumentException if the specified connective is null.
     */
    public void setConnective(final PDDLConnective connective) throws IllegalArgumentException {
        if (connective == null) {
            throw new IllegalArgumentException("PDDLConnective can not be null in setConnective call");
        }
        this.connective = connective;
    }

    /**
     * Set the value of this node.
     *
     * @param value the value of this node.
     */
    public final void setValue(final double value) {
        this.value = value;
    }

    /**
     * Sets a name to the preference.
     *
     * @param name the name of the preference to set.
     */
    public final void setPrefName(final PDDLSymbol name) {
        this.prefName = name;
    }

    /**
     * Returns the list of child of this parser node.
     *
     * @return the list of child of this parser node.
     */
    public final List<PDDLExpression> getChildren() {
        return this.children;
    }

    /**
     * Returns the name of the preference.
     *
     * @return the name of the preference or <code>null</code> if the preference name was not initialized.
     */
    public final PDDLSymbol getPrefName() {
        return this.prefName;
    }

    /**
     * Returns the connective of this parser node.
     *
     * @return the connective of this parser node.
     */
    public final PDDLConnective getConnective() {
        return this.connective;
    }

    /**
     * Returns the list of variables of this parser node. This list of variable is used to store the
     * quantified variable of the PDDL logical expression.
     *
     * @return the list of variables of this parser node.
     */
    public final List<PDDLTypedSymbol> getVariables() {
        return this.variables;
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
     * Returns the atom of this parser node.
     *
     * @return the atom
     */
    public final List<PDDLSymbol> getAtom() {
        return this.atom;
    }

    /**
     * Returns the value of this parser node.
     *
     * @return the value of this parser node.
     */
    public final Double getValue() {
        return this.value;
    }

    /**
     * Returns the taskID of of the task. The taskID is only use in HTN planning to make alias of task.
     *
     * @return the taskID of variables of this parser node.
     */
    public final PDDLSymbol getTaskID() {
        return this.taskID;
    }

    /**
     * Set the taskID of this expression. The taskID is only use in HTN planning to make alias of task.
     *
     * @param taskID the taskID to set.
     */
    public final void setTaskID(PDDLSymbol taskID) {
        this.taskID = taskID;
    }

    /**
     * Set the time of this expression. The time is used in time literal and in PDDL constraints and methods constraints
     * in HDDL.
     *
     * @param time the time to set.
     */
    public final void setTime(PDDLSymbol time) {
        this.time = time;
    }

    /**
     * Returns the time of this expression. The time is used in time literal and in PDDL constraints and methods
     * constraints in HDDL.
     *
     * @return the time to set.
     */
    public final PDDLSymbol getTime() {
        return this.time;
    }

    /**
     * Set the time interval of this expression. The time  interval is in HTN planning to define method
     * constraint and in constraints in PDDL.
     *
     * @param timeInterval the time interval to set.
     */
    public final void setTimeInterval(PDDLTimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    /**
     * Returns the time interval of this expression. The time  interval is in HTN planning to define method
     * constraint and in constraints in PDDL.
     *
     * @return the time interval of the expression.
     */
    public final PDDLTimeInterval getTimeInterval() {
        return this.timeInterval;
    }

    /**
     * Returns if this parser node is a preference.
     *
     * @return <code>true</code> if this parser node is a preference; <code>false</code> otherwise.
     */
    public final boolean isPreference() {
        return this.prefName != null;
    }

    /**
     * Renames the tag of the tasks contained in the expression. The tag tasks renames have the form T0, ..., Tn.
     */
    public void renameTaskIDs() {
        this.renameTaskIDs(new LinkedHashMap<>());
    }

    /**
     * Renames the ID of the task contained in the expression with a specified symbol, i.e., the tag tasks
     * already renamed. The ID of the task renames have the form T0, ..., Tn. In HDDL, only and expression are alowed as
     * tasks expression for the moment in method description.
     *
     * @param context the images of the renamed ID of the task.
     * @throws MalformedExpressionException if this expression is not an AND expression.
     * @see PDDLExpression#isMalformedExpression()
     */
    public void renameTaskIDs(final Map<String, String> context) throws MalformedExpressionException {
        if (this.isMalformedExpression()) {
            throw new MalformedExpressionException("Expression " + this.getConnective() + " is malformed");
        }
        switch (this.getConnective()) {
            case TASK:
                // Set a dummy taskID to task if no task taskID was specified
                if (this.getTaskID() == null) {
                    String newTaskID = new String(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + context.size());
                    PDDLSymbol taskID = new PDDLSymbol(this.getAtom().get(0));
                    taskID.setKind(PDDLSymbol.Kind.TASK_ID);
                    taskID.setImage(newTaskID);
                    this.setTaskID(taskID);
                    context.put(newTaskID, newTaskID);
                } else {
                    this.getTaskID().renameTaskID(context);
                }
                break;
            case F_TASK_TIME:
                this.atom.get(1).rename(context);
                break;
            case LESS_ORDERING_CONSTRAINT:
            case LESS_OR_EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case GREATER_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case GREATER_OR_EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
                this.atom.get(0).renameTaskID(context);
                this.atom.get(1).renameTaskID(context);
                break;
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
                this.getTime().renameTaskID(context);
                break;
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
                this.getTimeInterval().getLowerBound().renameTaskID(context);
                this.getTimeInterval().getUpperBound().renameTaskID(context);
                break;
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
                // do nothing
                break;
            default:
                for (int i = 0; i < this.getChildren().size(); i++) {
                    this.getChildren().get(i).renameTaskIDs(context);
                }
                break;
        }
    }

    /**
     * Renames the variables contained in the expression. The variable renames have the form ?X0,..., ?Xn.
     */
    public void renameVariables() {
        this.renameVariables(new LinkedHashMap<>());
    }

    /**
     * Renames the variables contained in the expression with a specified symbol, i.e., the variable
     * already renamed. The variable renames have the form ?X0, ..., ?Xn.
     *
     * @param context the images of the renamed variable.
     * @throws MalformedExpressionException if this expression is malformed.
     * @see PDDLExpression#isMalformedExpression()
     */
    public void renameVariables(final Map<String, String> context) throws MalformedExpressionException {
        if (this.isMalformedExpression()) {
            throw new MalformedExpressionException("Expression " + this.getConnective() + " is malformed");
        }
        switch (this.getConnective()) {
            case ATOM:
            case FN_HEAD:
            case EQUAL_ATOM:
            case TASK:
                for (int i = 0; i < this.getAtom().size(); i++) {
                    this.getAtom().get(i).renameVariables(context);
                }
                break;
            case AND:
            case OR:
            case NOT:
            case IMPLY:
            case F_EXP_T:
            case EQUAL_COMPARISON:
            case FN_ATOM:
            case WHEN:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case MULTIPLICATION:
            case DIVISION:
            case MINUS:
            case PLUS:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case F_EXP:
            case ALWAYS_CONSTRAINT:
            case SOMETIME_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
            case WITHIN_CONSTRAINT:
            case ALWAYS_WITHIN_CONSTRAINT:
            case HOLD_DURING_CONSTRAINT:
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
                for (int i = 0; i < this.getChildren().size(); i++) {
                    this.getChildren().get(i).renameVariables(context);
                }
                break;
            case FORALL:
            case EXISTS:
                for (int i = 0; i < this.getVariables().size(); i++) {
                    final PDDLTypedSymbol var = this.getVariables().get(i);
                    final String image = var.renameVariables(context.size() + 1);
                    context.put(image, var.getImage());
                }
                this.getChildren().get(0).renameVariables(context);
                break;
            case IS_VIOLATED:
            case NUMBER:
            case TIME_VAR:
            case TIMED_LITERAL:
            case TRUE:
            case FALSE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().toString());
        }
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
    public void toNNF() throws MalformedExpressionException {
        if (this.isMalformedExpression()) {
            throw new MalformedExpressionException(this.toString());
        }
        switch (this.connective) {
            case NOT:
                this.moveNegationInward();
                break;
            case AND:
            case OR:
            case WHEN:
            case IMPLY:
            case SOMETIME_AFTER_CONSTRAINT:
            case SOMETIME_BEFORE_CONSTRAINT:
                this.getChildren().forEach(PDDLExpression::toNNF);
                break;
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
                this.getChildren().get(0).toNNF();
                break;
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
                this.getChildren().get(1).toNNF();
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
                this.getChildren().get(1).toNNF();
                this.getChildren().get(2).toNNF();
                break;
            case HOLD_DURING_CONSTRAINT:
                this.getChildren().get(2).toNNF();
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
    private void moveNegationInward() {
        assert this.getConnective().equals(PDDLConnective.NOT);

        final PDDLExpression child = this.getChildren().get(0);
        switch (child.getConnective()) {
            case FORALL:
                this.setConnective(PDDLConnective.EXISTS);
                PDDLExpression negation = new PDDLExpression(PDDLConnective.NOT);
                negation.addChild(child.getChildren().get(0));
                negation.toNNF();
                this.children.set(0, negation);
                break;
            case EXISTS:
                this.setConnective(PDDLConnective.FORALL);
                this.setVariables(child.getVariables());
                negation = new PDDLExpression(PDDLConnective.NOT);
                negation.addChild(child.getChildren().get(0));
                negation.toNNF();
                this.children.set(0, negation);
                break;
            case AND:
                this.setConnective(PDDLConnective.OR);
                this.children.clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    negation = new PDDLExpression(PDDLConnective.NOT);
                    negation.addChild(child.getChildren().get(i));
                    negation.toNNF();
                    this.children.add(negation);
                }
                break;
            case OR:
                this.setConnective(PDDLConnective.AND);
                this.children.clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    negation = new PDDLExpression(PDDLConnective.NOT);
                    negation.addChild(child.children.get(i));
                    negation.toNNF();
                    this.children.add(negation);
                }
                break;
            case NOT:
                this.assign(child.getChildren().get(0));
                this.toNNF();
                break;
            case IMPLY: // (not (imply p q)) -> (imply (not p) (not q))
                this.setConnective(PDDLConnective.IMPLY);
                final PDDLExpression notp = new PDDLExpression(PDDLConnective.NOT);
                notp.addChild(child.getChildren().get(0));
                notp.toNNF();
                final PDDLExpression notq = new PDDLExpression(PDDLConnective.NOT);
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
                PDDLExpression child = this.getChildren().get(0);
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
                final PDDLExpression notp = new PDDLExpression(PDDLConnective.NOT);
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
                PDDLExpression condition = this.getChildren().get(0);
                simplified &= condition.simplify();
                PDDLExpression effect = this.getChildren().get(1);
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
                if (this.getAtom().get(0).equals(this.getAtom().get(1))) {
                    this.setConnective(PDDLConnective.TRUE);
                    simplified = true;
                }
                break;
            case SOMETIME_AFTER_CONSTRAINT: // Simplification must be checked with the constraints semantic
            case SOMETIME_BEFORE_CONSTRAINT:
            case ALWAYS_WITHIN_CONSTRAINT:
                simplified &= this.getChildren().get(0).simplify();
                simplified &= this.getChildren().get(1).simplify();
                break;
            case HOLD_DURING_CONSTRAINT:
                if (!this.getTimeInterval().isValid()) {
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
    private boolean removeDuplicateChild(PDDLExpression exp) {
        assert exp.getConnective().equals(PDDLConnective.AND)
            || exp.getConnective().equals(PDDLConnective.OR);
        boolean modified = false;
        for (int i = 0; i < exp.getChildren().size(); i++) {
            final PDDLExpression ei = exp.getChildren().get(i);
            for (int j = i + 1; j < exp.getChildren().size(); j++) {
                final PDDLExpression ej = exp.getChildren().get(j);
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
    private boolean removedTautology(PDDLExpression exp) {
        assert exp.getConnective().equals(PDDLConnective.AND)
            || exp.getConnective().equals(PDDLConnective.OR);
        boolean modified = false;
        for (int i = 0; i < exp.getChildren().size(); i++) {
            final PDDLExpression ei = exp.getChildren().get(i);
            final PDDLExpression neg = new PDDLExpression(PDDLConnective.NOT);
            neg.addChild(ei);
            for (int j = i + 1; j < exp.getChildren().size(); j++) {
                final PDDLExpression ej = exp.getChildren().get(j);
                if (ej.equals(neg)) {
                    ei.setConnective(PDDLConnective.TRUE);
                    exp.getChildren().remove(j);
                    j--;
                    modified = true;
                }
            }
        }
        return modified;
    }

    /**
     * Assigns a specified expression to this expression. After the method call the expression is equals to the
     * expression in parameter. The assignment is swallow, i.e., the assignment does not make a deep copy of the content
     * of the expression in parameter.
     *
     * @param exp the expression to assigned to this expression.
     */
    public void assign(final PDDLExpression exp) {
        this.atom = exp.getAtom();
        this.children = exp.getChildren();
        this.connective = exp.getConnective();
        this.prefName = exp.getPrefName();
        this.value = exp.getValue();
        this.variable = exp.getVariable();
        this.variables = exp.getVariables();
        this.taskID = exp.getTaskID();
        this.time = exp.getTime();
        this.timeInterval = exp.getTimeInterval();
        this.setBeginLine(exp.getBeginLine());
        this.setBeginColumn(exp.getBeginColumn());
        this.setEndLine(exp.getEndLine());
        this.setEndColumn(exp.getEndColumn());
    }

    /**
     * Move the time specifier inward the expression.
     *
     * @throws UnexpectedExpressionException if the expression is not composed of expressions that are not FORALL,
     *      EXISTS, AND, OR, NOT, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL, EQUAL, ATOM or EQUAL_ATOM.
     */
    private void moveTimeSpecifierInward() {
        assert this.getConnective().equals(PDDLConnective.AT_START)
            || this.getConnective().equals(PDDLConnective.AT_END)
            || this.getConnective().equals(PDDLConnective.OVER_ALL);

        final PDDLExpression child = this.getChildren().get(0);
        switch (child.getConnective()) {
            case FORALL:
            case EXISTS:
                PDDLExpression timeExp = new PDDLExpression(this.getConnective());
                timeExp.addChild(child.getChildren().get(0));
                timeExp.moveTimeSpecifierInward();
                this.children.set(0, timeExp);
                this.setConnective(child.getConnective());
                this.setVariables(child.getVariables());
                break;
            case AND:
            case OR:
                this.children.clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    timeExp = new PDDLExpression(this.getConnective());
                    timeExp.addChild(child.getChildren().get(i));
                    timeExp.moveTimeSpecifierInward();
                    this.children.add(timeExp);
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

    /*
     * Return if this expression is equal to another object.
     *
     * @param object the other object.
     * @return <tt>true</tt> if this expression is equal to <tt>object</tt>, i.e., <tt>other</tt> is
     *          not null and is an instance of <tt>PDDLExpression</tt> and it has the same connective, children,
     *          atom, value, preference name, variable, value, taskID and task interval; otherwise return
     *          <tt>false</tt>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof PDDLExpression) {
            PDDLExpression other = (PDDLExpression) obj;
            return getConnective() == other.getConnective()
                && Objects.equals(this.getVariables(), other.getVariables())
                && Objects.equals(this.getAtom(), other.getAtom())
                && Objects.equals(this.getChildren(), other.getChildren())
                && Objects.equals(this.getValue(), other.getValue())
                && Objects.equals(this.getPrefName(), other.getPrefName())
                && Objects.equals(this.getVariable(), other.getVariable())
                && Objects.equals(this.getTaskID(), other.getTaskID())
                && Objects.equals(this.getTime(), other.getTime())
                && Objects.equals(this.getTimeInterval(), other.getTimeInterval());
        }
        return false;
    }

    /**
     * Returns the hash code value of this expression.
     *
     * @return the hash code value of this expression.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getConnective(), this.getVariables(), this.getAtom(), this.getChildren(),
            this.getValue(), this.getPrefName(), this.getVariable(), this.getTaskID(), this.getTime(),
            this.getTimeInterval());
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
    public final boolean contains(final PDDLExpression exp) {
        for (PDDLExpression s : this.getChildren()) {
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
    public final boolean remove(final PDDLExpression exp) {
        boolean removed = false;
        Iterator<PDDLExpression> it = this.getChildren().iterator();
        while (it.hasNext()) {
            PDDLExpression s = it.next();
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
     * Returns the set of task IDs contains in this expression.
     *
     * @return the set of task IDs contains in exp.
     * @throws UnexpectedExpressionException if the expression is not a TASK, F_TASK_TIME,
     *      LESS_ORDERING_CONSTRAINT, LESS_OR_EQUAL_ORDERING_CONSTRAINT, GREATER_ORDERING_CONSTRAINT,
     *      GREATER_OR_EQUAL_ORDERING_CONSTRAINT, EQUAL_ORDERING_CONSTRAINT, HOLD_BEFORE_METHOD_CONSTRAINT,
     *      HOLD_AFTER_METHOD_CONSTRAINT, SOMETIME_BEFORE_METHOD_CONSTRAINT, SOMETIME_AFTER_METHOD_CONSTRAINT,
     *      HOLD_BETWEEN_METHOD_CONSTRAINT, HOLD_DURING_METHOD_CONSTRAINT OR AND.
     */
    public Set<PDDLSymbol> getTaskIDs() throws UnexpectedExpressionException {
        Set<PDDLSymbol> taskIDs  = new HashSet<PDDLSymbol>();
        switch (this.getConnective()) {
            case TASK:
                taskIDs.add(this.getTaskID());
                break;
            case F_TASK_TIME:
                taskIDs.add(this.getAtom().get(1)); // Add constraints HDDL2.1
                break;
            case LESS_ORDERING_CONSTRAINT:
            case LESS_OR_EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case GREATER_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case GREATER_OR_EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
                taskIDs.add(this.getAtom().get(0));
                taskIDs.add(this.getAtom().get(1));
                break;
            case HOLD_BEFORE_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
            case HOLD_AFTER_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
            case SOMETIME_BEFORE_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
            case SOMETIME_AFTER_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
                taskIDs.add(this.getTime());
                break;
            case HOLD_BETWEEN_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
            case HOLD_DURING_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
                taskIDs.add(this.getTimeInterval().getLowerBound());
                taskIDs.add(this.getTimeInterval().getUpperBound());
                break;
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
            case EQUAL_ATOM:
                // Do nothing
                break;
            case NOT:
                if (!this.getChildren().get(0).getConnective().equals(PDDLConnective.EQUAL_ATOM)) {
                    throw new UnexpectedExpressionException(this.getConnective().toString());
                }
                break;
            case AND:
                for (PDDLExpression c : this.getChildren()) {
                    taskIDs.addAll(c.getTaskIDs());
                }
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().toString());
        }
        return taskIDs;
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
        switch (this.connective) {
            case ATOM:
            case FN_HEAD:
                str.append("(");
                if (!this.atom.isEmpty()) {
                    for (int i = 0; i < this.atom.size() - 1; i++) {
                        str.append(this.atom.get(i).toString()).append(" ");
                    }
                    str.append(this.atom.get(this.atom.size() - 1).toString());
                }
                str.append(")");
                break;
            case TASK:
                str.append("(");
                if (!this.atom.isEmpty()) {
                    if (this.getTaskID() != null) {
                        str.append(this.getTaskID()).append(" (");
                    }
                    for (int i = 0; i < this.atom.size() - 1; i++) {
                        str.append(this.atom.get(i).toString()).append(" ");
                    }
                    str.append(this.atom.get(this.atom.size() - 1).toString());
                }
                str.append(")");
                break;
            case EQUAL_ATOM:
                str.append("(")
                    .append(this.getConnective().getImage())
                    .append(" ");
                for (int i = 0; i < this.atom.size() - 1; i++) {
                    str.append(this.atom.get(i).toString()).append(" ");
                }
                str.append(this.atom.get(this.atom.size() - 1).toString()).append(")");
                break;
            case AND:
            case OR:
                if (!this.children.isEmpty()) {
                    String offset = baseOffset + "  ";
                    str.append("(").append(this.getConnective().getImage());
                    str.append(" ");
                    for (int i = 0; i < this.children.size() - 1; i++) {
                        str.append(this.children.get(i).toString(offset)).append("\n").append(offset);
                    }
                    str.append(this.children.get(this.children.size() - 1).toString(offset));
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
                str.append(" (").append(this.getConnective().getImage()).append(" (");
                for (int i = 0; i < this.variables.size() - 1; i++) {
                    str.append(this.variables.get(i).toString()).append(", ");
                }
                str.append(this.variables.get(this.variables.size() - 1).toString())
                    .append(")\n")
                    .append(off)
                    .append(this.children.get(0).toString(off))
                    .append(")");
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
                str.append(this.atom.get(0).toString()).append(" ");
                str.append(this.atom.get(1).toString());
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
                str.append(this.getTime()).append(" ");
                str.append(this.getChildren().get(0).toString(baseOffset));
                str.append(")");
                break;
            case HOLD_DURING_CONSTRAINT:
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
                str.append("(");
                str.append(this.getConnective().getImage()).append(" ");
                str.append(this.getTimeInterval().getLowerBound()).append(" ");
                str.append(this.getTimeInterval().getUpperBound()).append(" ");
                str.append(this.getChildren().get(0).toString(baseOffset));
                str.append(")");
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
                str.append("(");
                str.append(this.getConnective().getImage()).append(" ");
                str.append(this.getTimeInterval().getLowerBound()).append(" ");
                str.append(this.getTimeInterval().getUpperBound()).append(" ");
                str.append(this.getChildren().get(0).toString(baseOffset));
                str.append(this.getChildren().get(1).toString(baseOffset));
                str.append(")");
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().toString());

        }
        return str.toString();
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
        switch (this.connective) {
            case AND:
            case OR:
                Iterator<PDDLExpression> i = this.getChildren().iterator();
                while (!malformed && i.hasNext()) {
                    malformed |= i.next().isMalformedExpression();
                }
                break;
            case EQUAL_ATOM:
                malformed = this.atom.size() != 2;
                break;
            case FORALL:
            case EXISTS:
                malformed = this.variables.isEmpty()
                    || this.children.isEmpty()
                    || this.children.get(0).isMalformedExpression();
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
                malformed = this.children.size() != 2
                    || this.children.get(0).isMalformedExpression()
                    || this.children.get(1).isMalformedExpression();
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
                malformed = this.children.size() != 1
                    || this.children.get(0).isMalformedExpression();
                break;
            case ATOM:
            case TASK:
            case FN_HEAD:
                malformed = this.getAtom().isEmpty();
                break;
            case TIMED_LITERAL:
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
                malformed = this.getChildren().size() != 1
                    || this.getTime() == null
                    || this.getChildren().get(0).isMalformedExpression();
                break;
            case HOLD_DURING_CONSTRAINT:
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
                malformed = this.getChildren().size() != 1
                    || this.getTimeInterval() == null
                    || this.getChildren().get(0).isMalformedExpression();
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
                malformed = this.getChildren().size() != 1
                    || this.getTime() == null
                    || this.getChildren().get(0).isMalformedExpression()
                    || this.getChildren().get(1).isMalformedExpression();
                break;
            case NUMBER:
                malformed = this.getValue() == null;
                break;
            case TIME_VAR:
            case IS_VIOLATED:
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().toString());

        }
        return malformed;
    }
}


