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

/**
 * This interface implements the common methods of all object produced by the parser.
 *
 * @author D. Pellier
 * @version 1.0 - 28.04.2022
 */
public interface ParsedObject extends Serializable {

    /**
     * The default begin line value.
     */
    static final int DEFAULT_BEGIN_LINE = -1;

    /**
     * The default end line value.
     */
    static final int DEFAULT_END_LINE = -1;

    /**
     * The default begin column value.
     */
    static final int DEFAULT_BEGING_COLUMN = -1;

    /**
     * The default begin column value.
     */
    static final int DEFAULT_END_COLUMN = -1;

    /**
     * Returns the begin line of the file where this object appear. The return value <code>DEFAULT_BEGIN_LINE</code>
     * indicates that the attribute was not initialized.
     *
     * @return the begin line of the file where this object appear or <code>DEFAULT_BEGIN_LINE</code> if it was
     *          not initialized.
     */
    int getBeginLine();

    /**
     * Sets the begin line of the file where this object appear.
     *
     * @param beginLine the begin line of the object in the file.
     */
    void setBeginLine(final int beginLine);

    /**
     * Returns the begin column of the file where this object appears. The return value <code>DEFAULT_END_LINE</code>
     * indicates that the attribute was not initialized.
     *
     * @return the begin column of the file where this object appears or <code>DEFAULT_END_LINE</code> if it was
     *          not initialized.
     */
    int getBeginColumn();

    /**
     * Sets the begin column of the file where this object appears.
     *
     * @param beginColumn the begin column of the file where this object appear.
     */
    void setBeginColumn(final int beginColumn);

    /**
     * Returns the end line of the file where this object appears. The return value <code>DEFAULT_BEGING_COLUMN</code>
     * indicates that the attribute was not initialized.
     *
     * @return the end line of the file where this object appears or <code>DEFAULT_BEGING_COLUM</code> if it was
     *          not initialized.
     */
    int getEndLine();

    /**
     * Sets the end line of the file where this object appears.
     *
     * @param endLine the end line of the file where this object appears.
     */
    void setEndLine(final int endLine);

    /**
     * Returns the end column of the file where this object appears. The return value <code>DEFAULT_END_COLUMN</code>
     * indicates that the attribute was not initialized.
     *
     * @return the end column of the file where this object appears or <code>DEFAULT_END_COLUMN</code> if it was
     *          not initialized.
     */
    int getEndColumn();

    /**
     * Sets the end column of the file where this object appears.
     *
     * @param endColumn the end column of the file where this object appears.
     */
    void setEndColumn(final int endColumn);

    /**
     * Sets the begin line and column of the expression from a specified token.
     *
     * @param begin the first token of the expression.
     */
    void setBegin(final Token begin);

    /**
     * Sets the end line and column of the expression from a specified token.
     *
     * @param end the last token of the expression.
     */
    void setEnd(final Token end);

}
