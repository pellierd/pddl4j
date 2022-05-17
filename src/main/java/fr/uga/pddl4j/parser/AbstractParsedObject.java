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

/**
 * This abstract class implements the common methods of all object produced by the parser.
 *
 * @author D. Pellier
 * @version 1.0 - 28.04.2022
 */
public class AbstractParsedObject implements ParsedObject {

    /**
     * The begin line of the symbol.
     */
    private int beginLine;

    /**
     * The begin column of the symbol.
     */
    private int beginColumn;

    /**
     * The end line of the symbol.
     */
    private int endLine;

    /**
     * The end column of the symbol.
     */
    private int endColumn;

    /**
     * Creates a new locatable object with a specified begin line and column and a specified end line and column.
     *
     * @param beginLine the begin line.
     * @param beginColumn the begin column.
     * @param endLine the end line.
     * @param endColumn the end column.
     */
    public AbstractParsedObject(final int beginLine, final int beginColumn, final int endLine, final int endColumn) {
        super();
        this.setBeginLine(beginLine);
        this.setBeginColumn(beginColumn);
        this.setEndLine(endLine);
        this.setEndColumn(endColumn);
    }

    /**
     * Creates a default object.
     *
     * @see ParsedObject#DEFAULT_BEGIN_LINE
     * @see ParsedObject#DEFAULT_BEGING_COLUMN
     * @see ParsedObject#DEFAULT_END_LINE
     * @see ParsedObject#DEFAULT_END_COLUMN
     */
    public AbstractParsedObject() {
        this(ParsedObject.DEFAULT_BEGIN_LINE, ParsedObject.DEFAULT_BEGING_COLUMN,
            ParsedObject.DEFAULT_END_LINE, ParsedObject.DEFAULT_END_COLUMN);
    }

    /**
     * Creates a parser object from another. This constructor creates a deep copy.
     *
     * @param other the other object to be copied.
     */
    public AbstractParsedObject(final AbstractParsedObject other) {
        this(other.getBeginLine(), other.getBeginColumn(), other.getEndLine(), other.getEndColumn());
    }

    /**
     * Returns the begin line of the file where this object appears. The return value
     * <code>DEFAULT_BEGIN_LIN</code> indicates that the attribute was not initialized.
     *
     * @return the begin line of the file where this object appears or <code>DEFAULT_BEGIN_LINE</code> if it
     *      was not initialized.
     */
    public final int getBeginLine() {
        return this.beginLine;
    }

    /**
     * Sets the begin line of the file where this object appears.
     *
     * @param beginLine the begin line of the object in the file.
     */
    public final void setBeginLine(final int beginLine) {
        this.beginLine = beginLine;
    }

    /**
     * Returns the begin column of the file where this  object appear. The return value
     * <code>DEFAULT_BEGIN_COLUMN</code> indicates that the attribute was not initialized.
     *
     * @return the begin column of the file where this object appears or <code>DEFAULT_BEGIN_COLUMN</code> if
     *      it was not initialized.
     */
    public final int getBeginColumn() {
        return this.beginColumn;
    }

    /**
     * Sets the begin column of the file where this object appears.
     *
     * @param beginColumn the begin column of the file where this object appears.
     */
    public final void setBeginColumn(final int beginColumn) {
        this.beginColumn = beginColumn;
    }

    /**
     * Returns the end line of the file where this  object appears. The return value <code>DEFAULT_EN_LINE</code>
     * indicates that the attribute was not initialized.
     *
     * @return the end line of the file where this object appears or <code>DEFAULT_EN_LINE</code> if it was
     *      not initialized.
     */
    public final int getEndLine() {
        return this.endLine;
    }

    /**
     * Sets the end line of the file where this object appears.
     *
     * @param endLine the end line of the file where this object appeasr.
     */
    public final void setEndLine(final int endLine) {
        this.endLine = endLine;
    }

    /**
     * Returns the end column of the file where this object appears. The return value <code>DEFAULT_END_COLUMN</code>
     * indicates that the attribute was not initialized.
     *
     * @return the end column of the file where this object appears or <code>DEFAULT_END_COLUMN</code> if it
     *      was not initialized.
     */
    public final int getEndColumn() {
        return this.endColumn;
    }

    /**
     * Sets the end column of the file where this object appears.
     *
     * @param endColumn the end column of the file where this object appears.
     */
    public final void setEndColumn(final int endColumn) {
        this.endColumn = endColumn;
    }

    /**
     * Sets the begin line and column of the expression from a specified token.
     *
     * @param begin the first token of the expression.
     */
    public final void setBegin(final Token begin) {
        this.setBeginLine(begin.beginLine);
        this.setBeginColumn(begin.beginColumn);
    }

    /**
     * Sets the end line and column of the expression from a specified token.
     *
     * @param end the last token of the expression.
     */
    public final void setEnd(final Token end) {
        this.setEndLine(end.endLine);
        this.setEndColumn(end.endColumn);
    }
}
