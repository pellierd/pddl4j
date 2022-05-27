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

package fr.uga.pddl4j.problem.operator;

import fr.uga.pddl4j.parser.MalformedExpressionException;
import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.Symbol;
import fr.uga.pddl4j.parser.TypedSymbol;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class is used to encode expressions in compact encoding, i.e., with integer representation.
 *
 * @author D. Pellier
 * @version 1.0 - 07.04.2010
 */
public class IntExpression implements Serializable {

    /**
     * The constant used to encode the default variable value.
     */
    public static final Double DEFAULT_VALUE = Double.NaN;

    /**
     * The connective of the expression.
     */
    private PDDLConnective connective;

    /**
     * The integer representation of the symbol of the atomic formula represented by this expression.
     */
    private Symbol<Integer> symbol;

    /**
     * The integer representation of the task ID.
     */
    private Symbol<Integer> taskID;

    /**
     * The list of arguments of the expression. This attribute is used to store the argument of the
     * atomic expression.
     */
    private List<Symbol<Integer>> arguments;

    /**
     * The children of the expression.
     */
    private List<IntExpression> children;

    /**
     * The quantified variable of the expression.
     */
    private List<TypedSymbol<Integer>> quantifiedVariables;

    /**
     * The variable, e.g, ?duration, etc.
     */
    private Symbol<Integer> variable;

    /**
     * The value of the expression. This attribute is used to store value of number expression.
     */
    private Double value;

    /**
     * A flag to indicate if this expression represents a primitive task.
     */
    private boolean isPrimtive;

    /**
     * Creates a new expression from another one. This constructor make a deep copy of the specified
     * expression.
     *
     * @param other the expression.
     */
    public IntExpression(final IntExpression other) {
        this.connective = other.getConnective();
        if (other.getSymbol() != null) {
            this.symbol = new Symbol<>(other.getSymbol());
        }
        if (other.getTaskID() != null) {
            this.taskID = new Symbol<Integer>(other.getTaskID());
        }
        if (other.getArguments() != null) {
            this.arguments = new ArrayList<>();
            this.getArguments().addAll(other.getArguments().stream().map(Symbol::new).collect(Collectors.toList()));
        }
        final List<IntExpression> otherChildren = other.getChildren();
        this.children = new ArrayList<>(otherChildren.size());
        this.children.addAll(otherChildren.stream().map(IntExpression::new).collect(Collectors.toList()));
        if (other.getQuantifiedVariables() != null) {
            this.quantifiedVariables = new ArrayList<>(other.getQuantifiedVariables().size());
            this.getQuantifiedVariables().addAll(other.getQuantifiedVariables().stream().map(TypedSymbol::new).collect(Collectors.toList()));
        }
        if (other.getVariable() != null) {
            this.variable = new Symbol<>(other.getVariable());
        }
        this.value = other.getValue();
        this.isPrimtive = other.isPrimtive();
    }

    /**
     * Creates a new expression with a specified connective.
     *
     * @param connective the connective of the expression.
     */
    public IntExpression(final PDDLConnective connective) {
        this.connective = connective;
        this.symbol = null;
        this.taskID = null;
        this.arguments = null;
        this.children = new ArrayList<>();
        this.quantifiedVariables = new ArrayList<>();
        this.variable = null;
        this.value = IntExpression.DEFAULT_VALUE;
        this.isPrimtive = false;
    }

    /**
     * Returns the connective of the expression.
     *
     * @return the connective of the expression.
     */
    public final PDDLConnective getConnective() {
        return this.connective;
    }

    /**
     * Sets a new connective to this expression.
     *
     * @param connective the new connective to set.
     */
    public final void setConnective(final PDDLConnective connective) {
        this.connective = connective;
    }

    /**
     * Adds a child to this expression.
     *
     * @param child the child expression to add.
     * @return <code>true</code> if the child was added <code>false</code> otherwise.
     */
    public final boolean addChild(final IntExpression child) {
        return this.children.add(child);
    }

    /**
     * Returns the list of children of this expression.
     *
     * @return the list of children of this expression.
     */
    public final List<IntExpression> getChildren() {
        return this.children;
    }

    /**
     * Returns the symbol of the atomic formula represented by this expression.
     *
     * @return the symbol of the atomic formula represented by this expression.
     */
    public final Symbol<Integer> getSymbol() {
        return this.symbol;
    }
    /**
     * Sets a new symbol of the atomic formula represented by this expression.
     *
     * @param symbol the new symbol to set
     */
    public final void setSymbol(Symbol<Integer> symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the task id of this expression.
     *
     * @return the taskID.
     */
    public final Symbol<Integer> getTaskID() {
        return this.taskID;
    }

    /**
     * Sets a new taskID to this expression.
     *
     * @param taskID the new predicate to set.
     */
    public final void setTaskID(final Symbol<Integer> taskID) {
        this.taskID = taskID;
    }

    /**
     * Returns the list of argument of this expression.
     *
     * @return the arguments the list of arguments of this expression.
     */
    public final List<Symbol<Integer>> getArguments() {
        return this.arguments;
    }

    /**
     * Sets the arguments of the expression.
     *
     * @param args the arguments to set.
     */
    public final void setArguments(final List<Symbol<Integer>> args) {
        this.arguments = args;
    }

    /**
     * Returns the variable of the expression.
     *
     * @return the variable of the expression.
     */
    public final Symbol<Integer> getVariable() {
        return this.variable;
    }

    /**
     * Sets the variable of this expression.
     *
     * @param variable the variable of the expression.
     */
    public final void setVariable(final Symbol<Integer> variable) {
        this.variable = variable;
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
     * Sets a new value to the expression.
     *
     * @param value the new value to set
     */
    public final void setValue(Double value) {
        this.value = value;
    }

    /**
     * Returns <code>true</code> if the expression is a primitive task.
     *
     * @return <code>true</code> if the expression is a primitive task, <code>false</code> otherwise.
     */
    public final boolean isPrimtive() {
        return this.isPrimtive;
    }

    /**
     * Sets the boolean flag used to specified if the expression is a primitive task to a specified value.
     *
     * @param flag the flag.
     */
    public final void setPrimtive(final boolean flag) {
        this.isPrimtive = flag;
    }

    /**
     * Returns the list of quantified variable of the expression.
     *
     * @return the list of quantified variable of the expression.
     */
    public final List<TypedSymbol<Integer>> getQuantifiedVariables() {
        return this.quantifiedVariables;
    }

    /**
     * Sets the list of quantified variable of the expression.
     *
     * @param  variables the list of quantified variable of the expression.
     */
    public final void setQuantifiedVariables(final List<TypedSymbol<Integer>> variables) {
        this.quantifiedVariables = variables;
    }

     /**
     * Affects this expression to an other. After affectation this expression and the other are
     * equal. No copy of the content of the other expression is done.
     *
     * @param other expression.
     */
    public final void assign(final IntExpression other) {
        this.setConnective(other.getConnective());
        this.setSymbol(other.getSymbol());
        this.setTaskID(other.getTaskID());
        this.setArguments(other.getArguments());
        this.children = other.getChildren();
        this.setQuantifiedVariables(other.getQuantifiedVariables());
        this.setVariable(other.getVariable());
        this.setValue(other.getValue());
        this.setPrimtive(other.isPrimtive());
    }

    /**
     * Returns if the expression is equal to an other object. The primitive flag and the task id are not used for
     * comparison.
     *
     * @param object the other object.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object != null && object instanceof IntExpression) {
            final IntExpression other = (IntExpression) object;
            return Objects.equals(this.getConnective(), other.getConnective())
                && Objects.equals(this.getSymbol(), other.getSymbol())
                && Objects.equals(this.getArguments(), other.getArguments())
                && Objects.equals(this.getValue(), other.getValue())
                && Objects.equals(this.getQuantifiedVariables(), other.getQuantifiedVariables())
                && Objects.equals(this.getVariable(), other.getVariable())
                && Objects.equals(this.getChildren(), other.getChildren())
                && Objects.equals(this.isPrimtive(), other.isPrimtive());
        }
        return false;
    }

    /**
     * Returns the hash code value of the expression.
     *
     * @return the hash code value of the expression.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getConnective(), this.getSymbol(), this.getArguments(), this.getValue(),
            this.getQuantifiedVariables(), this.getVariable(), this.getChildren(), this.isPrimtive());
    }

    /**
     * Move negation inward the expression.
     */
    /*public void moveNegationInward() {
        switch (this.getConnective()) {
            case NOT:
                IntExpression p = this.getChildren().get(0);
                switch (p.getConnective()) {
                    case FORALL:
                        this.setConnective(PDDLConnective.EXISTS);
                        IntExpression notP = new IntExpression(PDDLConnective.NOT);
                        notP.addChild(p);
                        this.children.set(0, notP);
                        notP.moveNegationInward();
                        break;
                    case EXISTS:
                        this.setConnective(PDDLConnective.FORALL);
                        notP = new IntExpression(PDDLConnective.NOT);
                        notP.addChild(p);
                        this.children.set(0, notP);
                        notP.moveNegationInward();
                        break;
                    case AND:
                        if (this.getChildren().size() > 1) {
                            this.setConnective(PDDLConnective.OR);
                            this.getChildren().clear();
                            for (int i = 0; i < p.getChildren().size(); i++) {
                                IntExpression q = new IntExpression(PDDLConnective.NOT);
                                q.addChild(p.getChildren().get(i));
                                q.moveNegationInward();
                                this.addChild(q);
                            }
                        } else {
                            this.assign(this.getChildren().get(0));
                            this.moveNegationInward();
                        }
                        break;
                    case OR:
                        if (this.getChildren().size() > 1) {
                            this.setConnective(PDDLConnective.AND);
                            this.getChildren().clear();
                            for (int i = 0; i < p.getChildren().size(); i++) {
                                IntExpression q = new IntExpression(PDDLConnective.NOT);
                                q.addChild(p.getChildren().get(i));
                                q.moveNegationInward();
                                this.addChild(q);
                            }
                        } else {
                            this.assign(this.getChildren().get(0));
                            this.moveNegationInward();
                        }
                        break;
                    /*case IMPLY: // ¬(p =>) q = p and ¬q
                        p.expandImply();
                        this.moveNegationInward();
                        break;*/
                    /*case NOT:
                        IntExpression neg = p.getChildren().get(0);
                        this.assign(neg);
                        this.moveNegationInward();
                        break;
                    case AT_START:
                    case AT_END:
                    case OVER_ALL:
                        this.setConnective(p.getConnective());
                        p.setConnective(PDDLConnective.NOT);
                        p.moveNegationInward();
                        break;
                    default:
                        // do nothing
                }
                break;
            /*case IMPLY: // p => q = (¬p) ∨ q
                this.setConnective(PDDLConnective.OR);
                final IntExpression notP = new IntExpression(PDDLConnective.NOT);
                notP.addChild(this.getChildren().get(0));
                notP.moveNegationInward();
                this.getChildren().get(1).moveNegationInward();
                this.getChildren().set(0, notP);
                break;*/
            /*default:
                this.children.forEach(IntExpression::moveNegationInward);
                break;
                // do nothing
        }
    }

    /**
     * Move time specifier inward the expression.
     */
    /* void moveTimeSpecifierInward() {
        switch (this.getConnective()) {
            case AND:
            case OR:
                this.children.forEach(IntExpression::moveTimeSpecifierInward);
                break;
            case NOT:
            case FORALL:
            case EXISTS:
            case ALWAYS_CONSTRAINT:
            case SOMETIME_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
                this.getChildren().get(0).moveTimeSpecifierInward();
                break;
            case WHEN:
            case SOMETIME_AFTER_CONSTRAINT:
            case SOMETIME_BEFORE_CONSTRAINT:
                this.getChildren().get(0).moveTimeSpecifierInward();
                this.getChildren().get(1).moveTimeSpecifierInward();
                break;
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
                this.getChildren().get(1).moveTimeSpecifierInward();
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
                this.getChildren().get(1).moveTimeSpecifierInward();
                this.getChildren().get(2).moveTimeSpecifierInward();
                break;
            case HOLD_DURING_CONSTRAINT:
                this.getChildren().get(3).moveTimeSpecifierInward();
                break;
            /*case IMPLY: // p => q = (¬p) ∨ q
                this.setConnective(PDDLConnective.OR);
                final IntExpression notP = new IntExpression(PDDLConnective.NOT);
                notP.addChild(this.getChildren().get(0));
                notP.moveTimeSpecifierInward();
                this.getChildren().get(1).moveTimeSpecifierInward();
                this.getChildren().set(0, notP);
                break;*/
            /*case AT_START:
            case AT_END:
            case OVER_ALL:
                IntExpression p = this.getChildren().get(0);
                switch (p.getConnective()) {
                    case FORALL:
                        p.setConnective(this.getConnective());
                        this.setConnective(PDDLConnective.FORALL);
                        this.setVariable(p.getVariable());
                        this.setType(p.getType());
                        p.moveTimeSpecifierInward();
                        break;
                    case EXISTS:
                        p.setConnective(this.getConnective());
                        this.setConnective(PDDLConnective.EXISTS);
                        this.setVariable(p.getVariable());
                        this.setType(p.getType());
                        p.moveTimeSpecifierInward();
                        break;
                    case AND:
                        this.getChildren().clear();
                        for (int i = 0; i < p.getChildren().size(); i++) {
                            IntExpression q = new IntExpression(this.getConnective());
                            q.addChild(p.getChildren().get(i));
                            q.moveTimeSpecifierInward();
                            this.addChild(q);
                        }
                        this.setConnective(PDDLConnective.AND);
                        break;
                    case OR:
                        this.getChildren().clear();
                        for (int i = 0; i < p.getChildren().size(); i++) {
                            final IntExpression q = new IntExpression(this.getConnective());
                            q.addChild(p.getChildren().get(i));
                            q.moveTimeSpecifierInward();
                            this.addChild(q);
                        }
                        this.setConnective(PDDLConnective.OR);
                        break;
                    /*case IMPLY:
                        p.expandImply();
                        this.moveTimeSpecifierInward();
                        break;*/
                    /*case NOT:
                        p.setConnective(this.getConnective());
                        this.setConnective(PDDLConnective.NOT);
                        break;
                    case WHEN:
                        final IntExpression timeCondition = new IntExpression(this.getConnective());
                        timeCondition.addChild(p.getChildren().get(0));
                        timeCondition.moveTimeSpecifierInward();
                        final IntExpression timeEffect = new IntExpression(this.getConnective());
                        timeEffect.addChild(p.getChildren().get(1));
                        timeEffect.moveTimeSpecifierInward();
                        this.setConnective(PDDLConnective.WHEN);
                        this.children.clear();
                        this.children.add(timeCondition);
                        this.children.add(timeEffect);
                        break;
                    default:
                        // do nothing
                }
                break;
            default:
                // do nothing
        }
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
        StringBuilder str = new StringBuilder();
        switch (this.connective) {
            case ATOM:
            case FN_HEAD:
                str.append("(");
                str.append(this.getSymbol().getValue());
                if (this.getArguments().size() != 0) {
                    str.append(" ");
                    for (int i = 0; i < this.getArguments().size() - 1; i++) {
                        str.append(this.getArguments().get(i)).append(" ");
                    }
                    str.append(this.getArguments().get(this.getArguments().size() - 1));
                }
                str.append(")");
                break;
            case TASK:
                str.append("(");
                if (this.getTaskID().getValue().equals(IntSymbol.DEFAULT_TASK_ID)) {
                    str.append(this.getTaskID().getValue());
                    str.append(" ");
                }
                if (this.getArguments().size() != 0) {
                    str.append(this.getSymbol().getValue());
                    str.append(" ");
                    for (int i = 0; i < this.getArguments().size() - 1; i++) {
                        str.append(this.getArguments().get(i)).append(" ");
                    }
                    str.append(this.getArguments().get(this.getArguments().size() - 1));
                }
                str.append(")");
                break;
            case EQUAL_ATOM:
                str.append("(");
                str.append(this.getConnective().getImage());
                str.append(" ");
                for (int i = 0; i < this.getArguments().size() - 1; i++) {
                    str.append(this.getArguments().get(i));
                    str.append(" ");
                }
                str.append(this.getArguments().get(this.getArguments().size() - 1)).append(")");
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
                str.append(" (");
                str.append(this.getConnective().getImage());
                str.append(" (");
                if (!this.quantifiedVariables.isEmpty()) {
                    for (int i = 0; i < this.quantifiedVariables.size() - 1; i++) {
                        str.append(this.getQuantifiedVariables().get(i).toString());
                        str.append(" ");
                    }
                    str.append(this.getQuantifiedVariables().get(this.quantifiedVariables.size() - 1).toString());
                    str.append(")");
                }
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
                str.append(this.getChildren().get(0).toString()).append(" ");
                str.append(this.getChildren().get(1).toString());
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
                str.append(this.getTaskID().getValue());
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().toString());

        }
        return str.toString();
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
                this.getChildren().forEach(IntExpression::toNNF);
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
    private void moveNegationInward() {
        assert this.getConnective().equals(PDDLConnective.NOT);

        final IntExpression child = this.getChildren().get(0);
        switch (child.getConnective()) {
            case FORALL:
                this.setConnective(PDDLConnective.EXISTS);
                IntExpression negation = new IntExpression(PDDLConnective.NOT);
                negation.addChild(child.getChildren().get(0));
                negation.toNNF();
                this.children.set(0, negation);
                break;
            case EXISTS:
                this.setConnective(PDDLConnective.FORALL);
                this.setQuantifiedVariables(child.getQuantifiedVariables());
                negation = new IntExpression(PDDLConnective.NOT);
                negation.addChild(child.getChildren().get(0));
                negation.toNNF();
                this.children.set(0, negation);
                break;
            case AND:
                this.setConnective(PDDLConnective.OR);
                this.children.clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    negation = new IntExpression(PDDLConnective.NOT);
                    negation.addChild(child.getChildren().get(i));
                    negation.toNNF();
                    this.children.add(negation);
                }
                break;
            case OR:
                this.setConnective(PDDLConnective.AND);
                this.children.clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    negation = new IntExpression(PDDLConnective.NOT);
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
                final IntExpression notp = new IntExpression(PDDLConnective.NOT);
                notp.addChild(child.getChildren().get(0));
                notp.toNNF();
                final IntExpression notq = new IntExpression(PDDLConnective.NOT);
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
    private void moveTimeSpecifierInward() {
        assert this.getConnective().equals(PDDLConnective.AT_START)
            || this.getConnective().equals(PDDLConnective.AT_END)
            || this.getConnective().equals(PDDLConnective.OVER_ALL);

        final IntExpression child = this.getChildren().get(0);
        switch (child.getConnective()) {
            case FORALL:
            case EXISTS:
                IntExpression timeExp = new IntExpression(this.getConnective());
                timeExp.addChild(child.getChildren().get(0));
                timeExp.moveTimeSpecifierInward();
                this.children.set(0, timeExp);
                this.setConnective(child.getConnective());
                this.setQuantifiedVariables(child.getQuantifiedVariables());
                break;
            case AND:
            case OR:
                this.children.clear();
                for (int i = 0; i < child.getChildren().size(); i++) {
                    timeExp = new IntExpression(this.getConnective());
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
}
