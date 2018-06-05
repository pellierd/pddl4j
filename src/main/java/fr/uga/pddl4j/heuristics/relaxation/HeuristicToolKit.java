/*
 * Copyright (c) 2011 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.heuristics.relaxation;

import fr.uga.pddl4j.encoding.CodedProblem;

import java.io.Serializable;

/**
 * This classes implements useful methods to manipulate the heuristics.
 *
 * @author D. Pellier
 * @version 1.0 - 09.02.2011
 * @see Heuristic
 */
public final class HeuristicToolKit implements Serializable {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Private constructor just for prevent user to instantiate this class.
     */
    private HeuristicToolKit() {
    }

    /**
     * Create an heuristic of a specified type.
     *
     * @param type    the type of the heuristic to create.
     * @param problem the problem for which the heuristic is created.
     * @return the heuristic created.
     * @throws NullPointerException if <code>type == null || problem == null</code>.
     */
    public static Heuristic createHeuristic(final Heuristic.Type type, final CodedProblem problem) {
        Heuristic heuristic = null;
        if (type.equals(Heuristic.Type.FAST_FORWARD)) {
            heuristic = new FastForward(problem);
        } else if (type.equals(Heuristic.Type.SUM)) {
            heuristic = new Sum(problem);
        } else if (type.equals(Heuristic.Type.SUM_MUTEX)) {
            heuristic = new SumMutex(problem);
        } else if (type.equals(Heuristic.Type.AJUSTED_SUM)) {
            heuristic = new AdjustedSum(problem);
        } else if (type.equals(Heuristic.Type.AJUSTED_SUM2)) {
            heuristic = new AdjustedSum2(problem);
        } else if (type.equals(Heuristic.Type.AJUSTED_SUM2M)) {
            heuristic = new AjustedSum2M(problem);
        } else if (type.equals(Heuristic.Type.COMBO)) {
            heuristic = new Combo(problem);
        } else if (type.equals(Heuristic.Type.MAX)) {
            heuristic = new Max(problem);
        } else if (type.equals(Heuristic.Type.MIN_COST)) {
            heuristic = new MinCost(problem);
        } else if (type.equals(Heuristic.Type.SET_LEVEL)) {
            heuristic = new SetLevel(problem);
        }
        return heuristic;
    }

}
