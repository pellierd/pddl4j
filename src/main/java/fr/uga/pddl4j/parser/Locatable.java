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
 * This interface defines the methods of all locatable object. A locatable object is an object that have a location in
 * a file. It is used by the parser to indicate the place an parsed object, i.e., symbols, expressions, actions, etc.
 *
 * @author Damien Pellier
 * @version 2.0 - 13.06.2022
 */
public interface Locatable {

    /**
     * Returns the location of the object.
     *
     * @return the location of the object.
     * @see Location
     */
    Location getLocation();

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
