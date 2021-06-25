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

import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.Configuration;
import fr.uga.pddl4j.planners.Setting;
import fr.uga.pddl4j.planners.statespace.search.AStar;
import fr.uga.pddl4j.planners.statespace.search.Node;
import fr.uga.pddl4j.planners.statespace.search.StateSpaceStrategy;

import fr.uga.pddl4j.problem.ADLProblem;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * This class implements a simple forward planner based on A* algorithm.
 *
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 */
public final class HSP extends AbstractStateSpacePlanner<ADLProblem> {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(HSP.class.getName());

    /**
     * The A* strategy.
     */
    private final StateSpaceStrategy astar;

    /**
     * Creates a new planner with default parameters.
     */
    public HSP() {
        super();
        this.astar = new AStar();
        this.getStateSpaceStrategies().add(this.astar);
    }

    /**
     * Creates a new planner with a defualt configuration.
     *
     * @param configuration the configuration of the planner.
     */
    public HSP(Configuration configuration) {
        super(configuration);
        final int timeout = this.getConfiguration().getTimeout();
        final Setting.Heuristic heuristic = this.getConfiguration().getHeuristic();
        final double weight = this.getConfiguration().getHeuristicWeight();
        this.astar = new AStar(timeout, heuristic, weight);
        this.getStateSpaceStrategies().add(this.astar);
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

        LOGGER.info("* starting A*\n");
        final Node solutionNode = astar.searchSolutionNode(problem);
        this.getStatistics().setTimeToSearch(astar.getSearchingTime());
        this.getStatistics().setMemoryUsedToSearch(astar.getMemoryUsed());
        if (solutionNode != null) {
            LOGGER.info("* A* succeeded\n");
            return (SequentialPlan) astar.extractPlan(solutionNode, problem);
        } else {
            LOGGER.info("* A* failed\n");
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

    public static Configuration getDefaultConfiguration() {
        Configuration config = new Configuration();
        config.setPlanner(Setting.Planner.HSP);
        config.setDomain(Setting.DEFAULT_DOMAIN);
        config.setProblem(Setting.DEFAULT_PROBLEM);
        config.setTimeout(Setting.DEFAULT_TIMEOUT);
        config.setHeuristic(Setting.Heuristic.FAST_FORWARD);
        config.setHeuristicWeight(Setting.DEFAULT_HEURISTIC_WEIGHT);
        config.setSearchStrategy(Setting.SearchStrategy.ASTAR);
        config.setTraceLevel(Level.INFO);
        return config;
    }

    /**
     * The
     * @param args
     */
    public static void main(String[] args) {
        try {
            Configuration config = new Configuration(args, HSP.getDefaultConfiguration());
            HSP planner = new HSP(config);
            planner.solve();
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }
}
