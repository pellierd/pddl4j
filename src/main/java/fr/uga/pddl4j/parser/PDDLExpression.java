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

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
     * The task interval used to specified method constraints.
     */
    private PDDLTaskInterval taskInterval;

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
        if (other.getTaskID() != null) {
            this.taskID = new PDDLSymbol(other.getTaskID());
        }
        if (other.getTaskInterval() != null) {
            this.taskInterval = new PDDLTaskInterval(other.getTaskInterval());
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
        this.taskInterval = null;
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
     * @throws NullPointerException if the specified connective is null.
     */
    public void setConnective(final PDDLConnective connective) throws NullPointerException {
        if (connective == null) {
            throw new NullPointerException("PDDLConnective can not be null in setConnective call");
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
     * Set the task interval of this expression. The task interval is only use in HTN planning to define method
     * constraint.
     *
     * @param interval the task interval to set.
     */
    public final void setTaskInterval(PDDLTaskInterval interval) {
        this.taskInterval = interval;
    }

    /**
     * Returns the ask interval of this expression. The task interval is only use in HTN planning to define method
     * constraint.
     *
     * @return the task interval of the expression.
     */
    public final PDDLTaskInterval getTaskInterval() {
        return this.taskInterval;
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
     * Sets the begin line and column of the expression from a specified token.
     *
     * @param begin the first token of the expression.
     */
    public void setBegin(final Token begin) {
        this.setBeginLine(begin.beginLine);
        this.setBeginColumn(begin.beginColumn);
    }

    /**
     * Sets the end line and column of the expression from a specified token.
     *
     * @param end the last token of the expression.
     */
    public void setEnd(final Token end) {
        this.setEndLine(end.endLine);
        this.setEndColumn(end.endColumn);
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
            case HOLD_BETWEEN: // Add constraints HDDL2.1
            case HOLD_DURING: // Add constraints HDDL2.1
                this.atom.get(0).rename(context);
                this.atom.get(1).rename(context);
                break;
            case HOLD_BEFORE: // Add constraints HDDL2.1
            case HOLD_AFTER: // Add constraints HDDL2.1
            case SOMETIME_BEFORE: // Add constraints HDDL2.1
            case SOMETIME_AFTER: // Add constraints HDDL2.1
                this.atom.get(0).rename(context);
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
            case F_EXP_T:
            case EQUAL:
            case FN_ATOM:
            case WHEN:
            case LESS:
            case LESS_OR_EQUAL:
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
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
            case HOLD_AFTER:
            case WITHIN:
            case ALWAYS_WITHIN:
            case F_EXP:
            case HOLD_DURING:
                for (int i = 0; i < this.getChildren().size(); i++) {
                    this.getChildren().get(i).renameVariables(context);
                }
                break;
            case FORALL:
            case EXISTS:
                final Map<String, String> newContext = new LinkedHashMap<>(context);
                for (int i = 0; i < this.getVariables().size(); i++) {
                    final PDDLTypedSymbol var = this.getVariables().get(i);
                    final String image = var.renameVariables(newContext.size() + i);
                    newContext.put(image, var.getImage());
                }
                this.getChildren().get(0).renameVariables(newContext);
                break;
            case IS_VIOLATED:
            case NUMBER:
            case TIME_VAR:
            case DURATION_ATOM:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(this.toString());
        }
    }

    /**
     * Sets the expression into negative normal form.
     *
     * @throws MalformedExpressionException if this expression is malformed.
     */
    //public void toNNF() throws MalformedExpressionException {
    //    this.simplify();
    //    this.toNNF();

    //}
    /**
     * Sets the expression into negative normal form.
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
            case FORALL:
            case EXISTS:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
            case WHEN:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case HOLD_AFTER:
            case WITHIN:
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                //this.getChildren().forEach(PDDLExpression::toNNF);
                for (PDDLExpression c : this.getChildren()) {
                    c.toNNF();
                }
                break;
            case AT_START:
            case AT_END:
            case OVER_ALL:
                this.moveTimeSpecifierInward();
                break;
            case ATOM:
            case FN_HEAD:
            case EQUAL_ATOM:
            case F_EXP:
            case NUMBER:
            case F_EXP_T:
            case TIME_VAR:
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
            case UMINUS:
            case MINIMIZE:
            case MAXIMIZE:
            case IS_VIOLATED:
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
     * EXISTS, AND, OR, NOT, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL, EQUAL, ATOM or EQUAL_ATOM.
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
                this.affect(child.getChildren().get(0));
                this.toNNF();
                break;
            case AT_START:
            case AT_END:
            case OVER_ALL:
                this.setConnective(child.getConnective());
                child.setConnective(PDDLConnective.NOT);
                break;
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case LESS:
            case LESS_OR_EQUAL:
            case ATOM:
            case EQUAL_ATOM:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(this.toString());
        }
    }

    /**
     * Simplify the expression. This method removes the double negation and removes the extra inner conjunctions and
     * disjunctions.
     *
     * @return <code>true</code> if the expression was simplified; <code>false</code> otherwise.
     * @throws UnexpectedExpressionException if the expression is not composed of expressions that are not FORALL,
     * EXISTS, AND, OR, NOT, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL, EQUAL, ATOM or EQUAL_ATOM.
     */
    private void simplify() {
        switch (this.getConnective()) {
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
                PDDLExpression child = this.getChildren().get(0);
                child.simplify();
                if (child.getConnective().equals(PDDLConnective.TRUE)
                    || child.getConnective().equals(PDDLConnective.FALSE)) {
                    this.setConnective(child.getConnective());
                }
                break;
            case AND:
                if (this.getChildren().isEmpty()) {
                    this.setConnective(PDDLConnective.TRUE);
                } else if (this.getChildren().size() == 1) {
                    this.affect(this.getChildren().get(0));
                    this.simplify();
                } else {
                    int i = 0;
                    while (i < this.getChildren().size()
                        && !this.getConnective().equals(PDDLConnective.TRUE)
                        && !this.getConnective().equals(PDDLConnective.FALSE)) {
                        child = this.getChildren().get(i);
                        child.simplify();
                        if (child.getConnective().equals(PDDLConnective.FALSE)) {
                            this.setConnective(PDDLConnective.FALSE);
                        } else if (child.getConnective().equals(PDDLConnective.TRUE)) {
                            this.getChildren().remove(i);
                        } else if (child.getConnective().equals(PDDLConnective.AND)) {
                            this.getChildren().remove(i);
                            this.getChildren().addAll(i, child.getChildren());
                            i += child.getChildren().size();
                        } else {
                            i++;
                        }
                    }
                }
                break;
            case OR:
                if (this.getChildren().isEmpty()) {
                    this.setConnective(PDDLConnective.TRUE);
                } else if (this.getChildren().size() == 1) {
                    this.affect(this.getChildren().get(0));
                    this.simplify();
                } else {
                    int i = 0;
                    while (i < this.getChildren().size()
                        && !this.getConnective().equals(PDDLConnective.TRUE)
                        && !this.getConnective().equals(PDDLConnective.FALSE)) {
                        child = this.getChildren().get(i);
                        child.simplify();
                        if (child.getConnective().equals(PDDLConnective.TRUE)) {
                            this.setConnective(PDDLConnective.TRUE);
                        } else if (child.getConnective().equals(PDDLConnective.FALSE)) {
                            this.getChildren().remove(i);
                        } else if (child.getConnective().equals(PDDLConnective.OR)) {
                            this.getChildren().remove(i);
                            this.getChildren().addAll(i, child.getChildren());
                            i += child.getChildren().size();
                        } else {
                            i++;
                        }
                    }
                }
                break;
            case NOT:
                child = this.getChildren().get(0);
                child.simplify();
                if (child.getConnective().equals(PDDLConnective.NOT)) {
                    this.affect(child.getChildren().get(0));
                } else if (child.getConnective().equals(PDDLConnective.TRUE)) {
                    this.setConnective(PDDLConnective.FALSE);
                } else if (child.getConnective().equals(PDDLConnective.FALSE)) {
                    this.setConnective(PDDLConnective.TRUE);
                }
                break;
            case WHEN:
                PDDLExpression condition = this.getChildren().get(0);
                condition.simplify();
                PDDLExpression effect = this.getChildren().get(1);
                effect.simplify();
                if (condition.getConnective().equals(PDDLConnective.TRUE)) {
                    this.affect(effect);
                } else if (condition.getConnective().equals(PDDLConnective.FALSE)) {
                    this.setConnective(PDDLConnective.TRUE);
                }
                break;
            case EQUAL_ATOM:
                if (this.getAtom().get(0).equals(this.getAtom().get(1))) {
                    this.setConnective(PDDLConnective.TRUE);
                }
                break;
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case LESS:
            case LESS_OR_EQUAL:
            case ATOM:
                break;
            default:
                throw new UnexpectedExpressionException(this.toString());
        }
    }

    /**
     * Make a s
     */
    public void affect(final PDDLExpression exp) {
        this.atom = exp.getAtom();
        this.children = exp.getChildren();
        this.connective = exp.getConnective();
        this.prefName = exp.getPrefName();
        this.value = exp.getValue();
        this.variable = exp.getVariable();
        this.variables = exp.getVariables();
        this.setBeginLine(exp.getBeginLine());
        this.setBeginColumn(exp.getBeginColumn());
        this.setEndLine(exp.getEndLine());
        this.setEndColumn(exp.getEndColumn());
    }

    /**
     * Move the time specifier inward the expression.
     *
     * @throws UnexpectedExpressionException if the expression is not composed of expressions that are not FORALL,
     * EXISTS, AND, OR, NOT, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL, EQUAL, ATOM or EQUAL_ATOM.
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
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case LESS:
            case LESS_OR_EQUAL:
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
     *          atom, value, preference name, variable, value, taskID and task interval; otherwise return <tt>false</tt>.
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
                && Objects.equals(this.getTaskInterval(), other.getTaskInterval());
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
            this.getValue(), this.getPrefName(), this.getVariable(), this.getTaskID(), this.getTaskInterval());
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
                str.append("(")
                    .append(this.getConnective().getImage()).append(" ")
                    .append(this.children.get(0).toString(baseOffset)).append(" ")
                    .append(this.children.get(1).toString(baseOffset))
                    .append(")");
                break;
            case LESS_ORDERING_CONSTRAINT:
            case LESS_OR_EQUAL_ORDERING_CONSTRAINT:
            case GREATER_ORDERING_CONSTRAINT:
            case GREATER_OR_EQUAL_ORDERING_CONSTRAINT:
            case EQUAL_ORDERING_CONSTRAINT:
                str.append("(")
                    .append(this.getConnective().getImage()).append(" ")
                    .append(this.atom.get(0).toString()).append(" ")
                    .append(this.atom.get(1).toString())
                    .append(")");
                break;
            case NOT:
            case UMINUS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
                str.append("(")
                    .append(this.getConnective().getImage()).append(" ")
                    .append(this.getChildren().get(0).toString(baseOffset))
                    .append(")");
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
            case HOLD_AFTER:
            case WITHIN:
                str.append("(")
                    .append(this.getConnective().getImage())
                    .append(" ")
                    .append(this.getChildren().get(0).getValue())
                    .append(" ")
                    .append(this.getChildren().get(1).toString(baseOffset))
                    .append(")");
                break;
            case ALWAYS_WITHIN:
                str.append("(")
                    .append(this.getConnective().getImage()).append(" ")
                    .append(this.getChildren().get(0).getValue()).append(" ")
                    .append(this.getChildren().get(1).toString(baseOffset)).append(" ")
                    .append(this.getChildren().get(2).toString(baseOffset))
                    .append(")");
                break;
            case HOLD_DURING:
                str.append("(")
                    .append(this.getConnective().getImage()).append(" ")
                    .append(this.getChildren().get(0).getValue()).append(" ")
                    .append(this.getChildren().get(1).getValue()).append(" ")
                    .append(this.getChildren().get(2).toString(baseOffset))
                    .append(")");
                break;
            default:
                // Do nothing

        }
        return str.toString();
    }

    /**
     * Returns if this expression is malformed. An expression is considered as well in the following cases:
     * <ul>
     * <li>Empty OR and AND expressions, i.e., without any children, are considered as well formed.</li>
     * <li>Quantified expressions (EXISTS, FORALL) is well formed if it has at least one quantified variable and one
     * child expression.</li>
     * <li>ATOM, TASKS, and F_HEAD expressions without any symbols as arguments are considered as well formed.</li>
     * <li>EQUAL_ATOM expression with two symbols as arguments is considered as well formed.</li>
     * <li>NOT, UMINUS, AT_START, AT_END, OVER_ALL, ALWAYS, SOMETIME, AT_MOST_ONCE, MINIMIZE, MAXIMIZE and F_EXP_T
     * expressions must have at least one child expression to be considered as well formed.</li>
     * <li>FN_ATOM, WHEN, DURATION_ATOM, LESS, LESS_OR_EQUAL, EQUAL, GREATER, GREATER_OR_EQUAL, ASSIGN, INCREASE,
     * DECREASE, SCALE_UP, SCALE_DOWN, MUL, DIV, MINUS, PLUS, SOMETIME_AFTER, SOMETIME_BEFORE, HOLD_AFTER and WITHIN
     * must have at least two children expressions to be considered as well formed.</li>
     * <li>ALWAYS_WITHIN and HOLD_DURING must have at least three children expressions to be considered as well formed.
     * </li>
     * </ul>
     *
     * @return <code>true</code> if the expression is malformed; <code>false</code> otherwise.
     */
    public boolean isMalformedExpression() {
        boolean malformed = false;
        switch (this.connective) {
            case EQUAL_ATOM:
                malformed = this.atom.size() != 2;
                break;
            case FORALL:
            case EXISTS:
                malformed = this.variables.isEmpty() || this.children.isEmpty()
                    && this.children.get(0).isMalformedExpression();
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                malformed = this.children.size() != 3
                    && this.children.get(0).isMalformedExpression()
                    && this.children.get(1).isMalformedExpression()
                    && this.children.get(2).isMalformedExpression();
                break;
            case DURATION_ATOM:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case HOLD_AFTER:
            case LESS_ORDERING_CONSTRAINT:
            case WITHIN:
                malformed = this.atom.size() != 2;
                break;
            case WHEN:
            case EQUAL:
            case LESS:
            case LESS_OR_EQUAL:
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
                malformed = this.children.size() != 2
                    && this.children.get(0).isMalformedExpression()
                    && this.children.get(1).isMalformedExpression();
                break;
            case NOT:
            case UMINUS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
            case MINIMIZE:
            case MAXIMIZE:
            case F_EXP_T:
            case F_EXP:
                malformed = this.children.size() != 1
                    && this.children.get(0).isMalformedExpression();
                break;
            case ATOM:
            case TASK:
            case FN_HEAD:
                malformed = this.getAtom().size() == 0;
                break;
            case TIME_VAR:
            case NUMBER:
            case IS_VIOLATED:
            case AND:
            case OR:
                break;
            default:
                // Do nothing

        }
        return malformed;
    }
}


