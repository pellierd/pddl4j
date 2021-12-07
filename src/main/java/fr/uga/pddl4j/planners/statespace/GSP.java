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

import fr.uga.pddl4j.heuristics.state.StateHeuristic;
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.SearchStrategy;

import fr.uga.pddl4j.problem.ADLProblem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

import java.util.List;

/**
 * This class implements a simple generic planner. It is possible to choose the search strategy and the heuristic to
 * solve a planning.
 *
 * <p>The command line syntax to launch the planner is as follow:</p>
 *
 * <pre>
 * {@code
 * GSP [-hV] [-e="<heuristic>] [-l=<logLevel>]
 *                                [-t=<timeout>] [-w=<weight>] [-s
 *                                [=<strategies>...]]... <domain> <problem>
 *
 * Description:
 *
 * Solves a specified planning problem using a specified search strategy and
 * heuristic.
 *
 * Parameters:
 *       <domain>              The domain file.
 *       <problem>             The problem file.
 *
 * Options:
 *   -l, --log=<logLevel>      Set the level of trace: ALL, DEBUG, INFO, ERROR,
 *                               FATAL, OFF, TRACE (preset INFO).
 *   -t, --timeout=<timeout>   Set the time out of the planner in seconds (
 *                               preset 600s).
 *   -w, --weight=<weight>     Set the weight of the heuristic (preset 1.0).
 *   -e, --heuristic=<heuristic>
 *                             Set the heuristics: AJUSTED_SUM, AJUSTED_SUM2,
 *                               AJUSTED_SUM2M, COMBO, MAX, FAST_FORWARD,
 *                               SET_LEVEL, SUM, SUM_MUTEX (preset: FAST_FORWARD)
 *   -s, --search-strategies[=<strategies>...]
 *                             Set the search strategies: ASTAR,
 *                               ENFORCED_HILL_CLIMBING, BREADTH_FIRST,
 *                               GREEDY_BEST_FIRST, DEPTH_FIRST, HILL_CLIMBING
 *                               (preset: ASTAR)
 *   -h, --help                Show this help message and exit.
 *   -V, --version             Print version information and exit.
 * }
 * </pre>
 *
 * <p>Command line example:</p>
 * <pre>
 * {@code
 *  java -cp build/libs/pddl4j-4.0-all.jar fr.uga.pddl4j.planners.statespace.GSP
 *         src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/domain.pddl
 *         src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/p01.pddl
 *         -s ENFORCED_HILL_CLIMBING ASTAR
 *         -e FAST_FORWARD
 *         -t 1000
 * }
 * </pre>
 *
 *
 * @author E. Hermellin
 * @author D. Pellier
 * @version 3.0 - 28.09.2018
 *
 * @see fr.uga.pddl4j.planners.PlannerConfiguration
 */
@CommandLine.Command(name = "GSP",
    version = "GSP 2.0",
    description = "Solves a specified planning problem using a specified search strategy and heuristic.",
    sortOptions = false,
    mixinStandardHelpOptions = true,
    headerHeading = "Usage:%n",
    synopsisHeading = "%n",
    descriptionHeading = "%nDescription:%n%n",
    parameterListHeading = "%nParameters:%n",
    optionListHeading = "%nOptions:%n")
public final class GSP extends AbstractStateSpacePlanner<ADLProblem> {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(GSP.class.getName());

    /**
     * Creates a new planner with default parameters.
     */
    public GSP() {
        super();
    }

    /**
     * Creates a new planner from a planner configuration.
     *
     * @param configuration the configuration of the planner.
     */
    public GSP(final PlannerConfiguration configuration) {
        super(configuration);
    }

    /**
     * Sets the weight of the heuristic. This method is overrided to add the command line option of the planner.
     *
     * @param weight the weight of the heuristic. The weight must be greater than 0.
     * @throws IllegalArgumentException if the weight is strictly less than 0.
     */
    @CommandLine.Option(names = { "-w", "--weight" }, defaultValue = "1.0", paramLabel = "<weight>",
        description = "Set the weight of the heuristic (preset 1.0).")
    @Override
    public final void setHeuristicWeight(final double weight) {
        super.setHeuristicWeight(weight);
    }

    /**
     * Set the name of heuristic used by the planner to solve a planning problem. This method is overrided to add the
     * command line options of the planner.
     *
     * @param heuristic the name of the heuristic.
     */
    @CommandLine.Option(names = { "-e", "--heuristic" }, defaultValue = "FAST_FORWARD",
        description = "Set the heuristics: AJUSTED_SUM, AJUSTED_SUM2, AJUSTED_SUM2M, COMBO, MAX, FAST_FORWARD, "
            +  "SET_LEVEL, SUM, SUM_MUTEX (preset: FAST_FORWARD)")
    @Override
    public final void setHeuristic(StateHeuristic.Name heuristic)  {
        super.setHeuristic(heuristic);
    }

    /**
     * Set the list of search strategies used by the planner to solve a planning problem.
     *
     * @param strategies the list of serach strategies to used.
     */
    @CommandLine.Option(names = { "-s", "--search-strategies" }, paramLabel = "<strategies>", arity = "0..*",
        defaultValue = "ASTAR", description = "Set the search strategies: ASTAR, ENFORCED_HILL_CLIMBING, "
        + "BREADTH_FIRST, GREEDY_BEST_FIRST, DEPTH_FIRST, HILL_CLIMBING (preset: ASTAR)")
    public final void setSearchStrategies(List<SearchStrategy.Name> strategies)  {
        super.setSearchStrategies(strategies);
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
     * The main method of the <code>GSP</code>.
     *
     * @param args the arguments of the command line.
     */
    public static void main(final String[] args) {
        try {
            final GSP planner = new GSP();
            int exitCode = (int) new CommandLine(planner).execute(args);
            System.exit(exitCode);
        } catch (Throwable e) {
            LOGGER.fatal(e.getMessage());
        }
    }
}
