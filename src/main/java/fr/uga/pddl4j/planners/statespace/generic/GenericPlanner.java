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

package fr.uga.pddl4j.planners.statespace.generic;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.planners.statespace.AbstractStateSpacePlanner;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.planners.statespace.search.strategy.StateSpaceStrategy;
import fr.uga.pddl4j.util.SequentialPlan;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * This class implements a simple generic planner.
 * This planner is generic, you need to give him a StateSpaceStrategy of your choice to solve the problem.
 *
 * @author E. Hermellin
 * @version 1.0 - 28.09.2018
 */
public final class GenericPlanner extends AbstractStateSpacePlanner {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The search strategy.
     */
    private final StateSpaceStrategy searchStrategy;

    /**
     * Creates a new planner with default parameters.
     *
     * @param searchStrategy the search strategy to use to solve the problem.
     */
    public GenericPlanner(final StateSpaceStrategy searchStrategy) {
        Objects.requireNonNull(searchStrategy);
        this.searchStrategy = searchStrategy;
        this.getStateSpaceStrategies().add(this.searchStrategy);
    }

    /**
     * Creates a new planner with default parameters for search strategy.
     *
     * @param statisticState the statistics generation value.
     * @param traceLevel     the trace level of the planner.
     * @param searchStrategy the search strategy to use to solve the problem.
     */
    public GenericPlanner(final boolean statisticState, final int traceLevel,
                          final StateSpaceStrategy searchStrategy) {
        super(statisticState, traceLevel);
        Objects.requireNonNull(searchStrategy);

        this.searchStrategy = searchStrategy;
        this.getStateSpaceStrategies().add(this.searchStrategy);
    }

    /**
     * Solves the planning problem and returns the first solution search found.
     *
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     */
    @Override
    public SequentialPlan search(final CodedProblem problem) {
        final Logger logger = this.getLogger();
        Objects.requireNonNull(problem);

        logger.trace("* starting search strategy\n");
        final Node solutionNode = this.searchStrategy.searchSolutionNode(problem);
        if (isSaveState()) {
            this.getStatistics().setTimeToSearch(this.searchStrategy.getSearchingTime());
            this.getStatistics().setMemoryUsedToSearch(this.searchStrategy.getMemoryUsed());
        }
        if (solutionNode != null) {
            logger.trace("* search strategy succeeded\n");
            return (SequentialPlan) this.searchStrategy.extractPlan(solutionNode, problem);
        } else {
            logger.trace("* search strategy failed\n");
            return null;
        }
    }
}
