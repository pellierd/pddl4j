/*
 * Copyright (c) 2022 by Damien Pellier <Damien.Pellier@imag.fr>.
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

import java.lang.Cloneable;
import java.io.Serializable;
import java.util.List;

/**
 * This interface defined the common methods to manipulate expressions while parsing and grounding process.
 *
 * @author D. Pellier
 * @version 1.0 - 13.05.2022
 */
public interface Expression<T1 extends Symbol, T2 extends TypedSymbol> extends Serializable {

    /**
     * Returns the connective of this expression.
     *
     * @return the connective of this expression.
     */
    PDDLConnective getConnective();

    /**
     * Set the connective of this expression.
     *
     * @param connective the connective.
     */
    void setConnective(final PDDLConnective connective);

    /**
     * Returns the symbol to this expression. Expression with a symbol are predicate, function or task formula.
     *
     * @return the symbol the new symbol of this expression. If this expression is not ATOM, a FUNCTION or TASK the
     * returned symbol is null.
     */
    T1 getSymbol();

    /**
     * Sets a new symbol to this expression. Expression with a symbol are predicate, function or task formula.
     *
     * @param symbol the new symbol of this expression.
     */
    void setSymbol(final T1 symbol);

    /**
     * Returns the arguments of the atomic formula represented by this expression.
     *
     * @return the arguments of the atomic formula represented by this expression.
     */
    List<T1> getArguments();

    /**
     * Sets the argument of the atomic formula represented by this expression.
     *
     * @param arguments the arguments of the atomic formula represented by this expression.
     */
    void setArguments(final List<T1> arguments);

    /**
     * Adds an argument to this expression.
     *
     * @param argument the argument to add.
     */
    boolean addArgument(final T1 argument);

    /**
     * Returns the list of quantified variables of this expression.
     *
     * @return the list of quantified variables of this expression.
     */
    List<T2> getQuantifiedVariables();

    /**
     * Sets the quantified variables of this expression.
     *
     * @param variables the quantified variables of this expression.
     */
    void setQuantifiedVariables(final List<T2> variables);

    /**
     * Adds a quantified variable to this expression.
     *
     * @param variable the quantified variable to add.
     */
    boolean addQuantifiedVariable(final T2 variable);

    /**
     * Returns the numeric value of this parser node.
     *
     * @return the numeric value of this parser node.
     */
    Double getValue();

    /**
     * Set the numeric value of this expression.
     *
     * @param value the numeric value of this expression.
     */
    void setValue(final Double value);

    /**
     * Returns the variable of this expression
     *
     * @return the variable of this expression.
     */
    T1 getVariable();

    /**
     * Sets a new variable to this parser node.
     *
     * @param variable the new variable to set.
     */
    void setVariable(final T1 variable);

    /**
     * Returns the name of the preference associated to this expression.
     *
     * @return the name of the preference or <code>null</code> if the preference name was not initialized.
     */
    T1 getPrefName();

    /**
     * Sets a name to the preference associated to this expression.
     *
     * @param name the name of the preference to set.
     */
    void setPrefName(final T1 name);

    /**
     * Returns the taskID associated to this expression. The taskID is only use in HTN planning to make alias of task.
     *
     * @return the taskID associated to this expression.
     */
    T1 getTaskID();

    /**
     * Set the taskID associated to this expression. The taskID is only use in HTN planning to make alias of task.
     *
     * @param taskID the taskID to set.
     */
    void setTaskID(T1 taskID);

    /**
     * Add a new child expression to this expression.
     *
     * @param exp the child to add
     * @return <code>true</code> if the expression was added; <code>false</code> otherwise
     * @throws RuntimeException if the specified node is null
     */
    boolean addChild(final Expression<T1, T2> exp);

    /**
     * Sets the list of children expressions of this expression.
     *
     * @param children the children expression to set.
     */
    void setChildren(final List<Expression<T1, T2>> children);

    /**
     * Returns the list of children of this expression.
     *
     * @return the list of children of this expression.
     */
    List<Expression<T1, T2>> getChildren();

    /**
     * Returns a deep copy of this expression.
     *
     * @return a deep copy of this expression.
     */
    //Expression<T1, T2> clone();

    /**
     * Returns if this expression is a literal. A literal is an atomic formula or a negated atomic
     * formula.
     *
     * @return <code>true</code> if this expression is a literal <code>false</code> otherwise.
     */
    boolean isLiteral();

    /**
     * Transforms this expression into it negative normal form.
     */
    void toNNF();

    /**
     * Moves the negation inward the expression.
     *
     * @throws UnexpectedExpressionException if the expression is not composed of expressions that are not FORALL,
     *      EXISTS, AND, OR, NOT, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL, EQUAL, ATOM or EQUAL_ATOM.
     */
    void moveNegationInward();

    /**
     * Move the time specifier inward the expression.
     *
     * @throws UnexpectedExpressionException if the expression is not composed of expressions that are not FORALL,
     *      EXISTS, AND, OR, NOT, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL, EQUAL, ATOM or EQUAL_ATOM.
     */
    void moveTimeSpecifierInward();

    /**
     * Returns if a specified expression is contains, i.e., is a sub-expression of this expression. More
     * formally, returns <code>true</code> if and only if this expression contains at least one
     * subexpression <code>s</code> such that <code>s.equals(exp)</code>.
     *
     * @param exp the expression to test.
     * @return <code>true</code> if the specified expression <code>exp</code> is a sub-expression of
     *          this expression; <code>false</code> otherwise.
     */
    boolean contains(final Expression<T1, T2> exp);

    /**
     * Removes all the occurrences of a specified expression contained in this expression and
     * returns <code>true</code> if and only if at least one occurrence was removed.
     *
     * @param exp the expression to remove.
     * @return <code>true</code> if the specified expression <code>exp</code> was removed;
     *          <code>false</code> otherwise.
     */
    boolean remove(final Expression<T1, T2> exp);

    /**
     * Assigns a specified expression to this expression. After the method call the expression is equals to the
     * expression in parameter. The assignment is swallow, i.e., the assignment does not make a deep copy of the content
     * of the expression in parameter.
     *
     * @param exp the expression to assigned to this expression.
     */
    void assign(final Expression<T1, T2> exp);

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
    boolean simplify() throws UnexpectedExpressionException;

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
    boolean isMalformedExpression();

    /**
     * Returns a string representation of this node.
     *
     * @return a string representation of this node.
     * @see java.lang.Object#toString
     */
    String toString();

    /**
     * Returns a string representation of this parser node.
     *
     * @param baseOffset the offset white space from the left used for indentation.
     * @return a string representation of this parser node.
     * @throws MalformedExpressionException if the expression is malformed.
     */
    String toString(String baseOffset);

    /**
     *
     */
    //void assignVariables(Expression exp);

    Expression<T1, T2> getInstance(PDDLConnective connective);
}
