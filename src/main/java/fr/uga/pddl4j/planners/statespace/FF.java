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
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.Configuration;
import fr.uga.pddl4j.planners.Setting;
import fr.uga.pddl4j.planners.statespace.search.AStar;
import fr.uga.pddl4j.planners.statespace.search.EnforcedHillClimbing;
import fr.uga.pddl4j.planners.statespace.search.Node;
import fr.uga.pddl4j.planners.statespace.search.StateSpaceStrategy;

import fr.uga.pddl4j.problem.ADLProblem;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Set;

/**
 * This class implements Fast Forward planner based on Enforced Hill Climbing Algorithm and
 * Greedy Best First Search.
 *
 * @author Samuel Aaron Boyd
 * @author E. Hermellin
 * @author D. Pellier
 * @version 2.0 - 24.01.2018
 */
public final class FF extends AbstractStateSpacePlanner<ADLProblem> {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(FF.class.getName());

    /**
     * The Enforced Hill Climbing strategy.
     */
    private final StateSpaceStrategy enforcedHillClimbing;

    /**
     * The Greedy Best First Search strategy.
     */
    private final StateSpaceStrategy astar;

    /**
     * Creates a new planner with default parameters.
     */
    public FF() {
        super();
        this.enforcedHillClimbing = new EnforcedHillClimbing();
        this.astar = new AStar();
        this.getStateSpaceStrategies().add(this.enforcedHillClimbing);
        this.getStateSpaceStrategies().add(this.astar);
    }


    /**
     * Creates a new planner.
     *
     * @param configuration the configuration of the planner.
     */
    public FF(Configuration configuration) {
        super(configuration);
        final int timeout = this.getConfiguration().getTimeout();
        final Setting.Heuristic heuristic = this.getConfiguration().getHeuristic();
        final double weight = this.getConfiguration().getHeuristicWeight();
        this.enforcedHillClimbing = new EnforcedHillClimbing(timeout, heuristic, weight);
        this.astar = new AStar(timeout, heuristic, weight);
        this.getStateSpaceStrategies().add(this.enforcedHillClimbing);
        this.getStateSpaceStrategies().add(this.astar);
    }

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @param pb the problem to solve.
     */
    @Override
    public Plan solve(final ADLProblem pb) {
        Objects.requireNonNull(pb);

        LOGGER.info("* starting enforced hill climbing\n");
        Node solutionNode = this.enforcedHillClimbing.searchSolutionNode(pb);

        if (solutionNode != null) {
            LOGGER.info("* enforced hill climbing succeeded\n");
            this.getStatistics().setTimeToSearch(this.enforcedHillClimbing.getSearchingTime());
            this.getStatistics().setMemoryUsedToSearch(this.enforcedHillClimbing.getMemoryUsed());
            return (SequentialPlan) this.enforcedHillClimbing.extractPlan(solutionNode, pb);
        } else {
            LOGGER.info("* enforced hill climbing failed\n");
            LOGGER.info("* starting A* search\n");
            solutionNode = astar.searchSolutionNode(pb);
            this.getStatistics().setTimeToSearch(this.astar.getSearchingTime());
            this.getStatistics().setMemoryUsedToSearch(this.astar.getMemoryUsed());
            if (solutionNode == null) {
                LOGGER.info("* A* search failed\n");
                return null;
            } else {
                LOGGER.info("* A* search succeeded\n");
                return (SequentialPlan) this.astar.extractPlan(solutionNode, pb);
            }
        }
    }

    @Override
    public boolean checkConfiguration() {
        return true;
    }


    public static Configuration getDefaultConfiguration() {
        Configuration config = new Configuration();
        config.setPlanner(Setting.Planner.FF);
        config.setDomain(Setting.DEFAULT_DOMAIN);
        config.setProblem(Setting.DEFAULT_PROBLEM);
        config.setTimeout(Setting.DEFAULT_TIMEOUT);
        config.setHeuristic(Setting.Heuristic.FAST_FORWARD);
        config.setHeuristicWeight(Setting.DEFAULT_HEURISTIC_WEIGHT);
        config.setSearchStrategy(Setting.SearchStrategy.NONE);
        config.setTraceLevel(Level.INFO);
        return config;
    }

    @Override
    public ADLProblem instantiate(final ParsedProblem problem) {
        ADLProblem pb = new ADLProblem(problem);
        pb.instantiate();
        return pb;
    }

    /**
     * The
     * @param args
     */
    public static void main(String[] args) {
        try {
            Configuration config = new Configuration(args, FF.getDefaultConfiguration());
            FF planner = new FF(config);
            planner.solve();
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }
}
