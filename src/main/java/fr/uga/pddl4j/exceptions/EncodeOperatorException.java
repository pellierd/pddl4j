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

package fr.uga.pddl4j.exceptions;

/**
 * Exception use for issues happen when encoding operators.
 *
 * @author Cedric Gerard
 * @version 1.0 - 01/03/2016
 */
public class EncodeOperatorException extends Exception {

    /**
     * Default constructor with only string message.
     *
     * @param message the error description
     */
    public EncodeOperatorException(String message) {
        super(message);
    }

    /**
     * Default constructor with string message and the Java Throwable cause.
     *
     * @param message the error description
     * @param cause   the cause this trigger the exception
     */
    public EncodeOperatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
