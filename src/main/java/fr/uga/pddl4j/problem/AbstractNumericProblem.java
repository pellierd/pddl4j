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

import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.parser.ParsedProblem;

import java.util.List;
import java.util.Set;

/**
 * This class contains all the methods shared by all numeric problems.
 *
 * @author D. Pellier
 * @version 4.0 - 08.02.2021
 */
public class AbstractNumericProblem extends ADLProblem implements Numeric {

    /**
     * Create a new numeric problem from a domain and problem.
     *
     *
     * @param problem The problem.
     */
    public AbstractNumericProblem(final ParsedProblem problem) {
        super(problem);
    }

    /**
     * Returns the list of PDDL requirements accepted by the problem.
     *
     * @return the list of PDDL requirements accepted by the problem.
     */
    public Set<PDDLRequireKey> getAcceptedRequirements() {
        Set<PDDLRequireKey> accepted = super.getAcceptedRequirements();
        accepted.add(PDDLRequireKey.NUMERIC_FLUENTS);
        return accepted;
    }

    /**
     * Returns the list of function symbols of the problem.
     *
     * @return the list of function symbols of the problem.
     */
    public List<String> getFunctionSymbols() {
        return super.getFunctions();
    }

    /**
     * Returns the signatures of the functions defined in the problem.
     *
     * @return the signatures of the functions defined in the problem.
     */
    public List<List<Integer>> getFunctionSignatures() {
        return super.getFunctionSignatures();
    }

}
