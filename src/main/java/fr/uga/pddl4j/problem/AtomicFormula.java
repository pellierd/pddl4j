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

import java.io.Serializable;
import java.util.List;

/**
 * This interface describes the interface of every atomic formulas.
 *
 * @author D. Pellier
 * @version 1.0 - 28.04.2020
 * @since 4.0
 */
public interface AtomicFormula extends Serializable {

    /**
     * Returns the symbol of this atomic formula.
     *
     * @return the symbol of this atomic formula.
     */
    int getSymbol();

    /**
     * Sets the symbole of this atomic formula.
     *
     * @param symbol the symbol of the atomic fomula.
     */
    void setSymbol(final int symbol);

    /**
     * Returns the arguments of the atomic formula.
     *
     * @return the arguments of the atomic formula.
     */
    int[] getArguments();

    /**
     * Sets the arguments of the atomic formula.
     *
     * @param arguments the arguments of the atomic formula.
     */
    void setArguments(final int[] arguments);

    /**
     * Returns the arity of this atomic formula, i.e., the number of arguments of the atomic formula.
     *
     * @return the arity of this atomic formula.
     */
    int arity();
}
