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

package fr.uga.pddl4j.planners.statespace;

import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.statespace.search.Node;
import fr.uga.pddl4j.planners.statespace.search.StateSpaceStrategy;

import fr.uga.pddl4j.problem.ADLProblem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * This class implements a simple generic planner.
 * This planner is generic, you need to give him a StateSpaceStrategy of your choice to solve the problem.
 *
 * @author E. Hermellin
 * @author D. Pellier
 * @version 3.0 - 28.09.2018
 */
public final class GenericPlanner extends AbstractStateSpacePlanner<ADLProblem> {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(GenericPlanner.class.getName());

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
     * @param searchStrategy the search strategy to use to solve the problem.
     */
    public GenericPlanner(final boolean statisticState, final int traceLevel,
                          final StateSpaceStrategy searchStrategy) {
        super();
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
    public Plan solve(final ADLProblem problem) {
        Objects.requireNonNull(problem);

        LOGGER.info("* starting search strategy\n");
        final Node solutionNode = this.searchStrategy.searchSolutionNode(problem);
        this.getStatistics().setTimeToSearch(this.searchStrategy.getSearchingTime());
        this.getStatistics().setMemoryUsedToSearch(this.searchStrategy.getMemoryUsed());
        if (solutionNode != null) {
            LOGGER.info("* search strategy succeeded\n");
            return (SequentialPlan) this.searchStrategy.extractPlan(solutionNode, problem);
        } else {
            LOGGER.info("* search strategy failed\n");
            return null;
        }
    }

    @Override
    public boolean checkConfiguration() {
        return true;
    }

    @Override
    public ADLProblem instantiate() {
        ADLProblem pb = new ADLProblem(this.getParser().getDomain(), this.getParser().getProblem());
        pb.instantiate();
        return pb;
    }

}
