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
import fr.uga.pddl4j.planners.statespace.search.EnforcedHillClimbing;
import fr.uga.pddl4j.planners.statespace.search.Node;
import fr.uga.pddl4j.planners.statespace.search.StateSpaceStrategy;

import fr.uga.pddl4j.problem.ADLProblem;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.Objects;

/**
 * This class implements Fast Forward planner based on Enforced Hill Climbing algorithm and AStar search.
 *
 *
 * <p>The command line syntax to launch the planner is as follow:</p>
 *
 * <pre>
 * Usage of FF:
 *
 * OPTIONS   DESCRIPTIONS
 *
 * -o <i>str</i>   the path to the domain
 * -f <i>str</i>   the path to the problem
 * -t <i>num</i>   specifies the maximum CPU-time in seconds (preset: 600)
 * -v <i>level</i> the trace level: ALL, DEBUG, INFO, WARN, ERROR, FATAL, OFF (preset: INFO)
 *
 * </pre>
 *
 * <p>Commande line example:</p>
 * <pre>
 *     java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.statespace.FF
 *        -o src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/domain.pddl
 *        -f src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed//pb01.pddl
 * </pre>
 *
 * @author Samuel Aaron Boyd
 * @author E. Hermellin
 * @author D. Pellier
 * @version 2.0 - 24.01.2018
 *
 * @see fr.uga.pddl4j.planners.PlannerConfiguration
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
    public FF(PlannerConfiguration configuration) {
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

    /**
     * Returns if the planner configuration is valid or not. A configuration is valid is the timeout is greater than 0
     * and the heuristic weight is greater than 0.0.
     *
     * @return <code>true</code> if the configuration is valide <code>false</code> otherwise.
     */
    @Override
    public boolean checkConfiguration() {
        return this.getConfiguration().getTimeout() > 0
            && this.getConfiguration().getHeuristicWeight() > 0.0;
    }


    /**
     * Returns the configuration by default of the planner.
     *
     * @return the configuration by default of the planner.
     */
    public static PlannerConfiguration getDefaultConfiguration() {
        PlannerConfiguration config = new PlannerConfiguration();
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

    /**
     * Instantiates the planning problem from a parsed problem.
     *
     * @param problem the problem to instantiate.
     * @return the instantiated planning problem or null if the problem cannot be instantiated.
     */
    @Override
    public ADLProblem instantiate(final ParsedProblem problem) {
        ADLProblem pb = new ADLProblem(problem);
        pb.instantiate();
        return pb;
    }

    /**
     * The main method of the <code>FF</code> planner. The command line syntax is as follow:
     *
     * <pre>
     * Usage of FF:
     *
     * OPTIONS   DESCRIPTIONS
     *
     * -o <i>str</i>   the path to the domain
     * -f <i>str</i>   the path to the problem
     * -t <i>num</i>   specifies the maximum CPU-time in seconds (preset: 600)
     * -v <i>level</i> the trace level: ALL, DEBUG, INFO, WARN, ERROR, FATAL, OFF (preset: INFO)
     *
     * </pre>
     *
     * <p>Commande line example:</p>
     * <pre>
     *     java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.statespace.FF
     *        -o src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/domain.pddl
     *        -f src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed//pb01.pddl
     * </pre>
     *
     * @param args the arguments of the command line.
     */
    public static void main(String[] args) {
        try {
            final PlannerConfiguration config = new PlannerConfiguration(args, FF.getDefaultConfiguration());
            Planner planner = new FF(config);
            planner.solve();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }  catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
