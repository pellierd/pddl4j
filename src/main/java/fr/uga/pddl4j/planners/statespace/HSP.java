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

import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.Setting;
import fr.uga.pddl4j.planners.statespace.search.AStar;
import fr.uga.pddl4j.planners.statespace.search.Node;
import fr.uga.pddl4j.planners.statespace.search.StateSpaceStrategy;

import fr.uga.pddl4j.problem.ADLProblem;
import fr.uga.pddl4j.problem.Problem;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.Objects;

/**
 * This class implements a simple state space planner based on A* algorithm. It is possible to choose the heuristic
 * function used and its weight.
 *
 * <p>The command line syntax to launch the planner is as follow:</p>
 *
 * <pre>
 * Usage of HSP:
 *
 * OPTIONS   DESCRIPTIONS
 *
 * -o <i>str</i>   the path to the domain
 * -f <i>str</i>   the path to the problem
 * -t <i>num</i>   specifies the maximum CPU-time in seconds (preset: 600)
 * -h <i>heuristic</i>  the heuristics: FAST_FORWARD, MAX, SUM, SUM_MUTEX, SET_LEVEL, COMBO, ADJUSTED_SUM,
 *                          ADJUSTED_SUM2, ADJUSTED_SUM2M (preset: FAST_FORWARD)
 * -v <i>level</i> the trace level: ALL, DEBUG, INFO, WARN, ERROR, FATAL, OFF (preset: INFO)
 *
 * </pre>
 *
 * <p>Commande line example:</p>
 * <pre>
 *     java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.statespace.HSP
 *        -o src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/domain.pddl
 *        -f src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed//pb01.pddl
 *        -h FAST_FORWARD
 * </pre>
 *
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 * @see fr.uga.pddl4j.planners.PlannerConfiguration
 * @see fr.uga.pddl4j.planners.Setting.Heuristic
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
     * Creates a new planner with a default configuration.
     *
     * @param configuration the configuration of the planner.
     */
    public HSP(PlannerConfiguration configuration) {
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

    /**
     * Returns if the planner configuration is valid or not. A configuration is valid is the timeout is greater than 0,
     * the heuristic weight is greater than 0.0 and the heuristic to use is set.
     *
     * @return <code>true</code> if the configuration is valide <code>false</code> otherwise.
     */
    @Override
    public boolean checkConfiguration() {
        return this.getConfiguration().getTimeout() > 0
            && this.getConfiguration().getHeuristicWeight() > 0.0
            && !this.getConfiguration().getHeuristic().equals(Setting.Heuristic.NONE);
    }

    /**
     * Returns the configuration by default of the planner.
     *
     * @return the configuration by default of the planner.
     */
    public static PlannerConfiguration getDefaultConfiguration() {
        PlannerConfiguration config = new PlannerConfiguration();
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
     * Instantiates the planning problem from a parsed problem.
     *
     * @param problem the problem to instantiate.
     * @return the instantiated planning problem or null if the problem cannot be instantiated.
     */
    @Override
    public ADLProblem instantiate(ParsedProblem problem) {
        ADLProblem pb = new ADLProblem(problem);
        pb.instantiate();
        return pb;
    }

    /**
     * The main method of the <code>HSP</code> planner. The command line syntax is as follow:
     *
     * <pre>
     * Usage of HSP:
     *
     * OPTIONS   DESCRIPTIONS
     *
     * -o <i>str</i>   the path to the domain
     * -f <i>str</i>   the path to the problem
     * -t <i>num</i>   specifies the maximum CPU-time in seconds (preset: 600)
     * -h <i>heuristic</i>  the heuristics: FAST_FORWARD, MAX, SUM, SUM_MUTEX, SET_LEVEL, COMBO, ADJUSTED_SUM,
     *                          ADJUSTED_SUM2, ADJUSTED_SUM2M (preset: FAST_FORWARD)
     * -v <i>level</i> the trace level: ALL, DEBUG, INFO, WARN, ERROR, FATAL, OFF (preset: INFO)
     *
     * </pre>
     *
     * <p>Commande line example:</p>
     * <pre>
     *     java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.statespace.HSP
     *        -o src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/domain.pddl
     *        -f src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed//pb01.pddl
     *        -h FAST_FORWARD
     * </pre>
     *
     * @param args the arguments of the command line.
     */
    public static void main(String[] args) {
        try {
            final PlannerConfiguration config = new PlannerConfiguration(args, HSP.getDefaultConfiguration());
            HSP planner = new HSP(config);
            //planner.solve();
            ParsedProblem parsedproblem = planner.parse();
            ADLProblem pb = planner.instantiate(parsedproblem);
            planner.solve(pb);
        } catch (IllegalArgumentException e) {
            LOGGER.fatal(e.getMessage());
        }  catch (java.io.IOException e) {
            LOGGER.fatal(e.getMessage());
        }
    }
}
