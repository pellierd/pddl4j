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

package fr.uga.pddl4j.planners.hsp;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.search.strategy.AStar;
import fr.uga.pddl4j.planners.search.strategy.Node;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.SequentialPlan;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * This class implements a simple forward planner based on A* algorithm.
 *
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 */
public final class HSP extends AbstractPlanner {

    /**
     * Creates a new HSP planner with the default parameters.
     */
    public HSP() {
        super();
    }

    /**
     * Setup planner.
     */
    public void setupPlanner(Heuristic.Type heuristic, int timeout,
                             double weight, boolean statisticState, int traceLevel) {
        this.setHeuristicType(heuristic);
        this.setTimeOut(timeout);
        this.setWeight(weight);
        this.setSaveState(statisticState);
        this.setTraceLevel(traceLevel);
    }

    /**
     * Solves the planning problem and returns the first solution search found.
     *
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     */
    @Override
    public SequentialPlan search(final CodedProblem problem) {
        final Logger logger = AbstractPlanner.getLogger();
        Objects.requireNonNull(problem);

        logger.trace("* starting A*\n");
        final Node solutionNode = AStar.searchSolutionNode(this, problem);

        if (solutionNode != null) {
            return extract(solutionNode, problem);
        } else {
            return null;
        }
    }

    /**
     * Extracts a search from a specified node.
     *
     * @param node    the node.
     * @param problem the problem.
     * @return the search extracted from the specified node.
     */
    private SequentialPlan extract(final Node node, final CodedProblem problem) {
        Node n = node;
        final SequentialPlan plan = new SequentialPlan();
        while (n.getOperator() != -1) {
            final BitOp op = problem.getOperators().get(n.getOperator());
            plan.add(0, op);
            n = n.getParent();
        }
        return plan;
    }
}
