/*
 * Copyright (c) 2022 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.parser.Expression;

/**
 * This interface defines the method that must be implemented by object able to simplify atomic formula. In practice,
 * only a problem is able to simplify an atomic formula based on the inertia principle.
 *
 * @author D. Pellier
 * @version 4.0 - 13.16.2022
 */
public interface AtomicFormulaSimplifier<T> {

    /**
     * Simplify the expression specified. The call of the method with an expression such as the connector is different
     * of ATOM always return {@code false}.
     *
     * @param expression the expression to simplify.
     * @return {@code true} if the expression was simplified; {@code false} otherwise.
     */
    boolean simplify(Expression<T> expression);
}
