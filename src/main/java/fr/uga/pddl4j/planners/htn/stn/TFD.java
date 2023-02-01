/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.  If not, see
 * <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.planners.htn.stn;

import fr.uga.pddl4j.parser.RequireKey;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.ProblemNotSupportedException;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.State;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This class implements the code of a Total-order Forward Decomposition Planner. The search method is an
 * implementation of the total order STN procedure describes in the book of Automated Planning of Ghallab and al.
 * page 239.
 *
 * <p>The command line to launch the planner is as follow:</p>
 *
 * <pre>
 * {@code
 * TFD [-hiV] [-l=<logLevel>] [-t=<timeout>] <domain> <problem>
 *
 * Description:
 *
 * Solves a specified planning problem using a Total-order Forward Decomposition
 * strategy.
 *
 * Parameters:
 *       <domain>              The domain file.
 *       <problem>             The problem file.
 *
 * Options:
 *   -t, --timeout=<timeout>   Set the time out of the planner in seconds (preset
 *                               600s).
 *   -l, --log=<logLevel>      Set the level of trace of the planner: ALL, DEBUG,
 *                               INFO, ERROR, FATAL, OFF, TRACE (preset INFO).
 *   -i, --interactive         Set the planner in interactive mode for debug
 *   -h, --help                Show this help message and exit.
 *   -V, --version             Print version information and exit.
 * }
 * </pre>
 *
 * <p>Commande line example:</p>
 * <pre>
 * {@code
 *     java -cp build/libs/pddl4j-4.0-all.jar fr.uga.pddl4j.planners.htn.stn.TFDPlanner
 *          src/test/resources/benchmarks/hddl/ipc2020/barman/domain.hddl
 *          src/test/resources/benchmarks/hddl/ipc2020/barman/p01.hddl
 *          -t 600
 * }
 * </pre>
 *
 * @author D. Pellier
 * @version 1.0 - 15.04.2020
 * @since 4.0
 *
 * @see fr.uga.pddl4j.planners.PlannerConfiguration
 */
@CommandLine.Command(name = "TFD",
    version = "TFD 2.0",
    description = "Solves a specified planning problem using a Total-order Forward Decomposition strategy.",
    sortOptions = false,
    mixinStandardHelpOptions = true,
    headerHeading = "Usage:%n",
    synopsisHeading = "%n",
    descriptionHeading = "%nDescription:%n%n",
    parameterListHeading = "%nParameters:%n",
    optionListHeading = "%nOptions:%n")
public final class TFD extends AbstractSTNPlanner {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(TFD.class.getName());

    /**
     * Creates a new planner with a default configuration.
     */
    public TFD() {
        super();
    }

    /**
     * Creates a new abstract STN planner with the default configuration.
     *
     * @param configuration the configuration of the planner.
     */
    public TFD(final PlannerConfiguration configuration) {
        super(configuration);
    }

    /**
     * Solves the planning problem and returns the first solution search found. The search method is an implementation
     * of the total order STN procedure describes in the book of Automated Planning of Ghallab and al. page 239. The
     * method can solve only totally ordered problem. If it is not the case, the method returns null.
     *
     * @param problem the problem to be solved.
     * @return a solution search or null if it does not exist.
     * @throws ProblemNotSupportedException if the problem to solve is not supported by the planner.
     */
    @Override
    public Plan solve(final Problem problem) throws ProblemNotSupportedException {
        if (!super.isSupported(problem)) {
            throw new ProblemNotSupportedException("Problem not supported");
        }
        if (!problem.isTotallyOrdered()) {
            throw new ProblemNotSupportedException("Unable to solve a problem that is not totally ordered");
        }

        // Create the list of pending nodes to explore
        final PriorityQueue<TFDNode> open = new PriorityQueue<>(1000, new Comparator<TFDNode>() {
            public int compare(TFDNode n1, TFDNode n2) {
                return n1.getTasks().size() - n2.getTasks().size();
            }
        });
        // Create the root node of the search space
        final State init = new State(problem.getInitialState());
        final TFDNode root = new TFDNode(init, problem.getInitialTaskNetwork().getTasks());

        // Add the root node to the list of the pending nodes to explore.
        open.add(root);

        // Declare the plan used to store the result of the exploration
        Plan plan = null;

        // Get the timeout for searching
        final int timeout = this.getTimeout() * 1000;
        final long start = System.currentTimeMillis();
        long elapsedTime = 0;

        // Start exploring the search space
        while (!open.isEmpty() && plan == null && elapsedTime < timeout) {
            // Get and remove the first node of the pending list of nodes.
            final TFDNode currentNode = open.poll();

            if (this.isInteractive()) {
                LOGGER.info("=========> Pop a new node <=========\n");
                LOGGER.info("=> Current state:");
                LOGGER.info(problem.toString(currentNode.getState()));
                LOGGER.info("\n=> Tasks to be excuted:");
                LOGGER.info(currentNode.getTasks());
                for (int i = 0; i < currentNode.getTasks().size(); i++) {
                    LOGGER.info(problem.toString(problem.getTasks().get(currentNode.getTasks().get(i))));
                }
            }
            // If the task network is empty we've got a solution
            if (currentNode.getTasks().isEmpty()) {
                if (currentNode.getState().satisfy(problem.getGoal())) {
                    return super.extractPlan(currentNode, problem);
                }  else {
                    if (LOGGER.isDebugEnabled()) {
                        Plan p = super.extractPlan(currentNode, problem);
                        LOGGER.debug("Found plan but goal not reached as follows:\n" + problem.toString(p) + "\n");
                    }
                }
            } else {
                // Get and remove the fist task of the task network
                int task = currentNode.popTask();
                // Get the current state of the search
                final State state = currentNode.getState();
                // Get the relevant operators, i.e., action or method that are relevant for this task.
                final List<Integer> relevantOperators = problem.getTaskResolvers().get(task);
                // Case of primitive task
                if (problem.getTasks().get(task).isPrimtive()) {
                    for (Integer operator : relevantOperators) {
                        final Action action = problem.getActions().get(operator);
                        if (this.isInteractive()) {
                            LOGGER.info("\n======> Try to decompose primitive tasks "
                                + problem.toString(problem.getTasks().get(task)) + " with \n\n"
                                + problem.toString(action));
                        }
                        if (state.satisfy(action.getPrecondition())) {
                            final TFDNode childNode = new TFDNode(currentNode);
                            childNode.setParent(currentNode);
                            childNode.setOperator(operator);
                            childNode.getState().apply(action.getConditionalEffects());
                            childNode.setTask(task);
                            open.add(childNode);
                            if (this.isInteractive()) {
                                LOGGER.info("=====> Decomposition succeeded push node:");
                                LOGGER.info(problem.toString(childNode.getState()));
                                for (int t : childNode.getTasks()) {
                                    LOGGER.info(problem.toString(problem.getTasks().get(t)));
                                }
                            }
                        } else {
                            if (this.isInteractive()) {
                                LOGGER.info("=====> Decomposition failed");
                            }
                        }
                        if (this.isInteractive()) {
                            AbstractSTNPlanner.waitPressAnyKey();
                        }
                    }
                } else { // Case of the compound task
                    for (Integer operator : relevantOperators) {
                        final Method method = problem.getMethods().get(operator);
                        if (this.isInteractive()) {
                            LOGGER.info("\n======> Try to decompose compound tasks "
                                + problem.toString(problem.getTasks().get(task)) + " with\n\n"
                                + problem.toString(method));
                        }
                        if (state.satisfy(method.getPrecondition())) {
                            final TFDNode childNode = new TFDNode(currentNode);
                            childNode.setParent(currentNode);
                            childNode.setOperator(problem.getActions().size() + operator);
                            childNode.pushAllTasks(method.getSubTasks());
                            childNode.setTask(task);
                            open.add(childNode);
                            if (this.isInteractive()) {
                                LOGGER.info("=====> Decomposition succeeded push node:");
                                LOGGER.info("=====>\n" + problem.toString(childNode.getState()));
                                LOGGER.info("=====>\n");
                                for (int t : childNode.getTasks()) {
                                    LOGGER.info(problem.toString(problem.getTasks().get(t)));
                                }
                            }
                        } else {
                            if (this.isInteractive()) {
                                LOGGER.info("=====> Decomposition failed");
                            }
                        }
                        if (this.isInteractive()) {
                            AbstractSTNPlanner.waitPressAnyKey();
                        }
                    }
                }
            }
            elapsedTime = System.currentTimeMillis() - start;
        }
        return plan;
    }

    /**
     * The main method of the <code>TFD</code> planner.
     *
     * @param args the arguments of the command line.
     */
    public static void main(final String[] args) {
        try {
            final TFD planner = new TFD();
            CommandLine cmd = new CommandLine(planner);
            int exitCode = (int) cmd.execute(args);
            if (exitCode == 1) {
                LOGGER.fatal(cmd.getUsageMessage());
            }
            System.exit(exitCode);
        } catch (Throwable e) {
            LOGGER.fatal(e.getMessage());
        }
    }
}
