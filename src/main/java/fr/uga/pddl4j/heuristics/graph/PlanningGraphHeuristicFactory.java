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

package fr.uga.pddl4j.heuristics.graph;

import fr.uga.pddl4j.problem.ProblemOld;

import java.io.Serializable;

/**
 * This classes implements useful methods to create planning graph based heuristics.
 *
 * @author D. Pellier
 * @version 1.1 - 09.02.2011
 * @see PlanningGraphHeuristic
 */
public class PlanningGraphHeuristicFactory implements Serializable {

    /**
     * Private constructor just for prevent user to instantiate this class.
     */
    public PlanningGraphHeuristicFactory() {
    }

    /**
     * Create an heuristic of a specified type.
     *
     * @param type    the type of the heuristic to create.
     * @param problem the problem for which the heuristic is created.
     * @return the heuristic created.
     */
    public PlanningGraphHeuristic createRelaxtionHeuristic(final PlanningGraphHeuristic.Type type,
                                                           final ProblemOld problem) {
        PlanningGraphHeuristic heuristic = null;
        switch (type) {
            case FAST_FORWARD:
                heuristic = new FastForward(problem);
                break;
            case SUM:
                heuristic = new Sum(problem);
                break;
            case SUM_MUTEX:
                heuristic = new SumMutex(problem);
                break;
            case AJUSTED_SUM:
                heuristic = new AdjustedSum(problem);
                break;
            case AJUSTED_SUM2:
                heuristic = new AdjustedSum2(problem);
                break;
            case AJUSTED_SUM2M:
                heuristic = new AjustedSum2M(problem);
                break;
            case COMBO:
                heuristic = new Combo(problem);
                break;
            case MAX:
                heuristic = new Max(problem);
                break;
            case MIN_COST:
                heuristic = new MinCost(problem);
                break;
            case SET_LEVEL:
                heuristic = new SetLevel(problem);
                break;
            default:
                break;
        }
        return heuristic;
    }

}
