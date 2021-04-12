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

package fr.uga.pddl4j.problem.numeric;

import fr.uga.pddl4j.problem.AbstractAtomicFormula;

/**
 * This class implements a numeric fluent, i.e., a proposition whose numeric value changes during planning process.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2021
 * @since 4.0
 */
public class NumericFluent extends AbstractAtomicFormula {

    /**
     * Create a new numeric fluent from an other one. This constructor make a deep copy of the numeric fluent in
     * parameter.
     *
     * @param other the numeric fluent.
     */
    public NumericFluent(final NumericFluent other) {
        super(other);
    }

    /**
     * Creates a new numeric fluent with a specified symbol and list of arguments.
     *
     * @param symbol the symbol of the numeric fluent.
     * @param arguments the list of arguments of the numeric fluent.
     */
    public NumericFluent(final int symbol, final int[] arguments) {
        super(symbol, arguments);
    }

}
