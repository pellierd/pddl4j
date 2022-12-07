/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.planners;

import fr.uga.pddl4j.parser.Expression;

/**
 * A <code>ProblemNotSupportedException</code> is launch to indicate that a problem is not supported by a planner.
 *
 * @author D. Pellier
 * @version 4.0 - 03.02.2021
 */
public class ProblemNotSupportedException extends Exception {

    /**
     * Creates a new ProblemNotSupportedException with a specific message.
     *
     * @param message the message of exception.
     */
    public ProblemNotSupportedException(String message) {
        super(message);
    }
}
