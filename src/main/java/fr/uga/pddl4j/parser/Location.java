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

import java.io.Serializable;
import java.util.Objects;

/**
 * This abstract class implements the common methods of all object produced by the parser.
 *
 * @author D. Pellier
 * @version 1.0 - 28.04.2022
 */
public class Location implements Serializable {

    /**
     * The default begin line value.
     */
    public static final int DEFAULT_BEGIN_LINE = -1;

    /**
     * The default end line value.
     */
    public static final int DEFAULT_END_LINE = -1;

    /**
     * The default begin column value.
     */
    public static final int DEFAULT_BEGIN_COLUMN = -1;

    /**
     * The default begin column value.
     */
    public static final int DEFAULT_END_COLUMN = -1;

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
     * Creates new location with the default line and column value.
     *
     * @see Location#DEFAULT_BEGIN_LINE
     * @see Location#DEFAULT_BEGIN_COLUMN
     * @see Location#DEFAULT_END_LINE
     * @see Location#DEFAULT_END_COLUMN
     */
    public Location() {
        this(Location.DEFAULT_BEGIN_LINE, Location.DEFAULT_BEGIN_COLUMN,
            Location.DEFAULT_END_LINE, DEFAULT_END_COLUMN);
    }

    /**
     * Creates a new location from another.
     *
     * @param other the othe location.
     */
    public Location(final Location other) {
        super();
        this.setBeginLine(other.getBeginLine());
        this.setBeginColumn(other.getBeginColumn());
        this.setEndLine(other.getEndLine());
        this.setEndColumn(other.getEndColumn());
    }

    /**
     * Creates a new locatable object with a specified begin line and column and a specified end line and column.
     *
     * @param beginLine the begin line.
     * @param beginColumn the begin column.
     * @param endLine the end line.
     * @param endColumn the end column.
     */
    public Location(final int beginLine, final int beginColumn, final int endLine, final int endColumn) {
        super();
        this.setBeginLine(beginLine);
        this.setBeginColumn(beginColumn);
        this.setEndLine(endLine);
        this.setEndColumn(endColumn);
    }

    /**
     * Creates a parser object from another. This constructor creates a deep copy.
     *
     * @param other the other object to be copied.
     */
    public Location(final AbstractParsedObject other) {
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
     * Returns the end line of the file where this object appears. The return value <code>DEFAULT_EN_LINE</code>
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

    /**
     * Returns if an object location is equal to the location.
     *
     * @return {@code true} if the object is equal to this location, i.e., if it is an object of the class
     *      {@code Location} and it has the same begin and end line and begin and end column; otherwise {@code false}.
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof Location) {
            Location other = (Location) object;
            return Objects.equals(this.getBeginLine(), other.getBeginLine())
                && Objects.equals(this.getBeginColumn(), other.getBeginColumn())
                && Objects.equals(this.getEndLine(), other.getEndLine())
                && Objects.equals(this.getEndColumn(), other.getEndColumn());
        }
        return false;
    }

    /**
     * Returns the has code value of this location.
     *
     * @return the has code value of this location.
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getBeginLine(), this.getBeginColumn(), this.getEndLine(), this.getEndColumn());
    }

    /**
     * Returns a string representation of this location.
     *
     * @return a string representation of this location.
     */
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("[");
        str.append(this.getBeginLine());
        str.append(", ");
        str.append(this.getBeginColumn());
        str.append(", ");
        str.append(this.getEndLine());
        str.append(", ");
        str.append(this.getEndColumn());
        str.append("]");
        return str.toString();
    }
}
