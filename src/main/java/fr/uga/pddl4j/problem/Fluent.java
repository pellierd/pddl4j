/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
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

/**
 * This class implements a fluent, i.e., a proposition whose truth value changes during planning process.
 *
 * @author D. Pellier
 * @version 1.0 - 28.04.2020
 * @since 4.0
 */
public class Fluent extends AbstractAtomicFormula {

    /**
     * Create a new fluent from an other one. This constructor make a deep copy of the fluent in parameter.
     *
     * @param other the fluent.
     */
    public Fluent(final Fluent other) {
        super(other);
    }

    /**
     * Creates a new fluent with a specified symbol and list of arguments.
     *
     * @param symbol the symbol of the fluent.
     * @param arguments the list of arguments of the fluent.
     */
    public Fluent(final int symbol, final int[] arguments) {
        super(symbol, arguments);
    }

}
