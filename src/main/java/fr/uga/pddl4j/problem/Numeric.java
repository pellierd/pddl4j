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

package fr.uga.pddl4j.problem;

import java.util.List;

/**
 * This interface describes the interface of all numeric planning problem.
 *
 * @author D. Pellier
 * @version 4.0 - 05.02.2021
 */
public interface Numeric extends Problem {

    /**
     * Returns the list of function symbols of the problem.
     *
     * @return the list of function symbols of the problem.
     */
    List<String> getFunctionSymbols();

    /**
     * Returns the signatures of the functions defined in the problem.
     *
     * @return the signatures of the functions defined in the problem.
     */
    List<List<Integer>> getFunctionSignatures();
}
