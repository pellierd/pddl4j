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

import fr.uga.pddl4j.parser.lexer.Token;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * This class defines the method an PDDL expression.
 *
 * @author D. Pellier
 * @version 1.0 - 13.05.2022
 */
public class AbstractPDDLExpression extends AbstractExpression<PDDLSymbol, PDDLTypedSymbol> implements ParsedObject {

    /**
     * The parsed objet to deal with multiple inheritance with <code>Expression</code> and <code>ParseObject</code>.
     */
    private AbstractParsedObject parsedObject;

    /**
     * Creates a new abstract expression from another one. This constructor creates a deep copy.
     *
     * @param other the other expression.
     * @throws NullPointerException if other is null.
     */
    public AbstractPDDLExpression(final AbstractPDDLExpression other) {
        super();
        this.setConnective(other.getConnective());
        this.setSymbol(new PDDLSymbol(other.getSymbol()));
        for (PDDLSymbol argument: other.getArguments()) {
            this.addArgument(new PDDLSymbol(argument));
        }
        this.setQuantifiedVariables(new ArrayList<>());
        for (PDDLTypedSymbol variable: other.getQuantifiedVariables()) {
            this.addQuantifiedVariable(new PDDLTypedSymbol(variable));
        }
        this.setVariable(new PDDLSymbol(other.getVariable()));
        this.setPrefName(new PDDLSymbol(other.getPrefName()));
        this.setTaskID(new PDDLSymbol(other.getTaskID()));
        this.setValue(other.getValue());
        this.setChildren(new ArrayList<>());
        for (int i = 0; i < other.getChildren().size(); i++) {
            this.addChild((AbstractPDDLExpression) other.getChildren().get(i));
        }
        this.parsedObject = new AbstractParsedObject();
        this.setBeginLine(other.getBeginLine());
        this.setBeginColumn(other.getBeginColumn());
        this.setEndLine(other.getEndLine());
        this.setEndColumn(other.getEndColumn());

    }

    /**
     * Creates a new abstract PDDL expression with a specified connective.
     *
     * @param connective the connective.
     * @throws RuntimeException if the specified connective is null.
     */
    public AbstractPDDLExpression(final PDDLConnective connective) {
        super(connective);
        this.parsedObject = new AbstractParsedObject();
    }

    /**
     * Creates a new empty AND expression.
     */
    public AbstractPDDLExpression() {
        this(PDDLConnective.AND);
    }

    /**
     * Returns the begin line of the file where this object appear. The return value <code>DEFAULT_BEGIN_LINE</code>
     * indicates that the attribute was not initialized.
     *
     * @return the begin line of the file where this object appear or <code>DEFAULT_BEGIN_LINE</code> if it was
     *          not initialized.
     */
    public final int getBeginLine() {
        return this.parsedObject.getBeginLine();
    }

    /**
     * Sets the begin line of the file where this object appear.
     *
     * @param beginLine the begin line of the object in the file.
     */
    public final void setBeginLine(final int beginLine) {
        this.parsedObject.setBeginLine(beginLine);
    }

    /**
     * Returns the begin column of the file where this object appears. The return value <code>DEFAULT_END_LINE</code>
     * indicates that the attribute was not initialized.
     *
     * @return the begin column of the file where this object appears or <code>DEFAULT_END_LINE</code> if it was
     *          not initialized.
     */
    public final int getBeginColumn() {
        return this.parsedObject.getBeginColumn();
    }

    /**
     * Sets the begin column of the file where this object appears.
     *
     * @param beginColumn the begin column of the file where this object appear.
     */
    public final void setBeginColumn(final int beginColumn) {
        this.parsedObject.setEndColumn(getBeginColumn());
    }

    /**
     * Returns the end line of the file where this object appears. The return value <code>DEFAULT_BEGING_COLUMN</code>
     * indicates that the attribute was not initialized.
     *
     * @return the end line of the file where this object appears or <code>DEFAULT_BEGING_COLUM</code> if it was
     *          not initialized.
     */
    public final int getEndLine() {
        return this.parsedObject.getEndLine();
    }

    /**
     * Sets the end line of the file where this object appears.
     *
     * @param endLine the end line of the file where this object appears.
     */
    public final void setEndLine(final int endLine) {
        this.parsedObject.setEndLine(endLine);
    }

    /**
     * Returns the end column of the file where this object appears. The return value <code>DEFAULT_END_COLUMN</code>
     * indicates that the attribute was not initialized.
     *
     * @return the end column of the file where this object appears or <code>DEFAULT_END_COLUMN</code> if it was
     *          not initialized.
     */
    public final int getEndColumn() {
        return this.parsedObject.getEndColumn();
    }

    /**
     * Sets the end column of the file where this object appears.
     *
     * @param endColumn the end column of the file where this object appears.
     */
    public final void setEndColumn(final int endColumn) {
        this.parsedObject.setEndColumn(endColumn);
    }

    /**
     * Sets the begin line and column of the expression from a specified token.
     *
     * @param begin the first token of the expression.
     */
    public final void setBegin(final Token begin) {
        this.parsedObject.setBegin(begin);
    }

    /**
     * Sets the end line and column of the expression from a specified token.
     *
     * @param end the last token of the expression.
     */
    public final void setEnd(final Token end) {
        this.parsedObject.setEnd(end);
    }

    /**
     * Assigns a specified expression to this expression. After the method call the expression is equals to the
     * expression in parameter. The assignment is swallow, i.e., the assignment does not make a deep copy of the content
     * of the expression in parameter.
     *
     * @param exp the expression to assigned to this expression.
     */
    public void assign(final AbstractPDDLExpression exp) {
        super.assign(exp);
        this.setBeginLine(exp.getBeginLine());
        this.setBeginColumn(exp.getBeginColumn());
        this.setEndLine(exp.getEndLine());
        this.setEndColumn(exp.getEndColumn());
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
                    PDDLSymbol taskID = new PDDLSymbol(this.getSymbol());
                    taskID.setKind(PDDLSymbol.Kind.TASK_ID);
                    taskID.setImage(newTaskID);
                    this.setTaskID(taskID);
                    context.put(newTaskID, newTaskID);
                } else {
                    this.getTaskID().renameTaskID(context);
                }
                break;
            case F_TASK_TIME:
                this.getArguments().get(0).rename(context);
                break;
            case LESS_ORDERING_CONSTRAINT:
            case LESS_OR_EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case GREATER_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case GREATER_OR_EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
                this.getChildren().get(0).getTaskID().renameTaskID(context);
                this.getChildren().get(1).getTaskID().renameTaskID(context);
                break;
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
                this.getChildren().get(0).getTaskID().renameTaskID(context);
                break;
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
                this.getChildren().get(0).getTaskID().renameTaskID(context);
                this.getChildren().get(1).getTaskID().renameTaskID(context);
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
                    AbstractPDDLExpression ei = (AbstractPDDLExpression)  this.getChildren().get(i);
                    ei.renameTaskIDs(context);
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
                for (int i = 0; i < this.getArguments().size(); i++) {
                    this.getArguments().get(i).renameVariables(context);
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
                    AbstractPDDLExpression ei = (AbstractPDDLExpression)  this.getChildren().get(i);
                    ei.renameVariables(context);
                }
                break;
            case FORALL:
            case EXISTS:
                for (int i = 0; i < this.getQuantifiedVariables().size(); i++) {
                    final PDDLSymbol var = this.getQuantifiedVariables().get(i);
                    final String image = var.renameVariables(context.size() + 1);
                    context.put(image, var.getImage());
                }
                AbstractPDDLExpression e0 = (AbstractPDDLExpression)  this.getChildren().get(0);
                e0.renameVariables(context);
                break;
            case IS_VIOLATED:
            case NUMBER:
            case TASK_ID:
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
                && Objects.equals(this.getQuantifiedVariables(), other.getQuantifiedVariables())
                && Objects.equals(this.getSymbol(), other.getSymbol())
                && Objects.equals(this.getArguments(), other.getArguments())
                && Objects.equals(this.getChildren(), other.getChildren())
                && Objects.equals(this.getValue(), other.getValue())
                && Objects.equals(this.getPrefName(), other.getPrefName())
                && Objects.equals(this.getVariable(), other.getVariable())
                && Objects.equals(this.getTaskID(), other.getTaskID());
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
        return Objects.hash(this.getConnective(), this.getQuantifiedVariables(), this.getSymbol(),
            this.getArguments(), this.getChildren(), this.getValue(), this.getPrefName(),
            this.getVariable(), this.getTaskID());
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
                if (this.getTaskID() != null) {
                    taskIDs.add(this.getTaskID());
                }
                break;
            case TASK_ID:
                taskIDs.add(this.getTaskID());
                break;
            case F_TASK_TIME:
                taskIDs.add(this.getArguments().get(0)); // Add constraints HDDL2.1
                break;
            case NOT:
                if (!this.getChildren().get(0).getConnective().equals(PDDLConnective.EQUAL_ATOM)) {
                    throw new UnexpectedExpressionException(this.getConnective().toString());
                }
                break;
            case AND:
            case LESS_ORDERING_CONSTRAINT:
            case LESS_OR_EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case GREATER_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case GREATER_OR_EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case HOLD_BEFORE_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
            case HOLD_AFTER_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
            case SOMETIME_BEFORE_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
            case SOMETIME_AFTER_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
            case HOLD_BETWEEN_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
            case HOLD_DURING_METHOD_CONSTRAINT: // Add method ordering HDDL2.1
                for (int i = 0; i < this.getChildren().size(); i++) {
                    final AbstractPDDLExpression exp = (AbstractPDDLExpression) this.getChildren().get(i);
                    taskIDs.addAll(exp.getTaskIDs());
                }
                break;
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
            case EQUAL_ATOM:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().toString());
        }
        return taskIDs;
    }

    @Override
    public AbstractPDDLExpression clone() {
        return new AbstractPDDLExpression();
    }

    @Override
    public AbstractPDDLExpression getInstance(PDDLConnective connective) {
        return new AbstractPDDLExpression(connective);
    }

}
