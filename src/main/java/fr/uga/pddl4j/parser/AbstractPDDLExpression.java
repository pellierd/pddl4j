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
import java.util.stream.Collectors;

/**
 * This class defines the method an PDDL expression.
 *
 * @author D. Pellier
 * @version 1.0 - 13.05.2022
 */
public abstract class AbstractPDDLExpression extends AbstractExpression implements ParsedObject {

    /**
     * The parsed objet to deal with multiple inheritance with <code>Expression</code> and <code>ParseObject</code>.
     */
    private AbstractParsedObject parsedObject;

    /**
     * Creates a new expression from another one. This constructor creates a deep copy.
     *
     * @param other the other expression.
     * @throws NullPointerException if other is null.
     */
    public AbstractPDDLExpression(final AbstractPDDLExpression other) {
        super(other);
        this.parsedObject = new AbstractParsedObject();
        this.setBeginLine(other.getBeginLine());
        this.setBeginColumn(other.getBeginColumn());
        this.setEndLine(other.getEndLine());
        this.setEndColumn(other.getEndColumn());
    }

    /**
     * Creates a new PDDL expression with a specified connective.
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

}
