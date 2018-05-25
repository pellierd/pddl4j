/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.exceptions;

import fr.uga.pddl4j.parser.Exp;

/**
 * Thrown to indicate that a malformed expression has occurred.
 *
 * @author Damien Pellier
 * @see Exp
 */
public class MalformedExpException extends RuntimeException {

    /**
     * Creates a new malformed expression exception.
     *
     * @see Exception#Exception()
     */
    public MalformedExpException() {
        super();
    }

    /**
     * Creates a new malformed expression exception with a specific message.
     *
     * @param message the message.
     * @see Exception#Exception(String)
     */
    public MalformedExpException(String message) {
        super(message);
    }


}
