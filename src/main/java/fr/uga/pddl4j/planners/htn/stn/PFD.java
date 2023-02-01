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

import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.ProblemNotSupportedException;
import fr.uga.pddl4j.planners.statespace.GSP;
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
 * This class implement a simple task network planner enable to deal with partial ordered htn representation. The
 * search method is an implementation of the partial order STN procedure describes in the book of Automated Planning of
 * Ghallab and al. page 243.
 *
 * <pre>
 * {@code
 * PFD [-hiV] [-l=<logLevel>] [-t=<timeout>] <domain> <problem>
 *
 * Description:
 *
 * Solves a specified planning problem using a Partial-order Forward Decomposition
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
 *     java -cp build/libs/pddl4j-4.0-all.jar fr.uga.pddl4j.planners.htn.stn.PFDPlanner
 *          src/test/resources/benchmarks/hddl/ipc2020/barman/domain.hddl
 *          src/test/resources/benchmarks/hddl/ipc2020/barman/p01.hddl
 * }
 * </pre>
 *
 * @author D. Pellier
 * @version 1.0 - 15.04.2020
 * @since 4.0
 *
 * @see fr.uga.pddl4j.planners.PlannerConfiguration
 */
@CommandLine.Command(name = "PFD",
    version = "PFD 2.0",
    description = "Solves a specified planning problem using a Partial-order Forward Decomposition strategy.",
    sortOptions = false,
    mixinStandardHelpOptions = true,
    headerHeading = "Usage:%n",
    synopsisHeading = "%n",
    descriptionHeading = "%nDescription:%n%n",
    parameterListHeading = "%nParameters:%n",
    optionListHeading = "%nOptions:%n")
public final class  PFD extends AbstractSTNPlanner {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(PFD.class.getName());

    /**
     * Creates a new planner with a default configuration.
     */
    public PFD() {
        super();
    }

    /**
     * Creates a new abstract STN planner with the default configuration.
     *
     * @param configuration the configuration of the planner.
     */
    public PFD(final PlannerConfiguration configuration) {
        super(configuration);
    }

    /**
     * Solves the planning problem and returns the first solution search found. The search method is an implementation
     * of the partial order STN procedure describes in the book of Automated Planning of Ghallab and al. page 243.
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
        // Create the list of pending nodes to explore
        final PriorityQueue<PFDNode> open = new PriorityQueue<>(1000, new Comparator<PFDNode>() {
            public int compare(PFDNode n1, PFDNode n2) {
                return n1.getTaskNetwork().getTasks().size() - n2.getTaskNetwork().getTasks().size();
            }
        });
        // Create the root node of the search space
        final State init = new State(problem.getInitialState());
        final PFDNode root = new PFDNode(init, problem.getInitialTaskNetwork());

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
            final PFDNode currentNode = open.poll();

            if (this.isInteractive()) {
                LOGGER.info("=========> Pop a new node <=========\n");
                LOGGER.info("=> Current state:");
                LOGGER.info(problem.toString(currentNode.getState()));
                LOGGER.info("\n=> Tasks to be executed:");
                LOGGER.info(problem.toString(currentNode.getTaskNetwork()));
                LOGGER.info(currentNode.getTaskNetwork().getOrderingConstraints().toBitString());
            }

            // If the task network has no more task, a solution is found
            if (currentNode.getTaskNetwork().isEmpty()) {
                if (currentNode.getState().satisfy(problem.getGoal())) {
                    return super.extractPlan(currentNode, problem);
                }  else {
                    if (LOGGER.isDebugEnabled()) {
                        Plan p = super.extractPlan(currentNode, problem);
                        LOGGER.debug("Found plan but goal not reached as follows:\n" + problem.toString(p) + "\n");
                    }
                }
            } else {
                // Get the list of tasks of the current node with no predecessors
                currentNode.getTaskNetwork().getOrderingConstraints().transitiveClosure();
                final List<Integer> tasks = currentNode.getTaskNetwork().getTasksWithNoPredecessors();

                // Get the current state of the search
                final State state = currentNode.getState();
                // For each task with no predecessors
                for (Integer task : tasks) {
                    int taskIndex = currentNode.getTaskNetwork().getTasks().get(task);
                    final List<Integer> relevantOperators = problem.getTaskResolvers().get(taskIndex);
                    // Case of primitive tasks
                    if (problem.getTasks().get(taskIndex).isPrimtive()) {
                        for (Integer operator : relevantOperators) {
                            final Action action = problem.getActions().get(operator);
                            if (this.isInteractive()) {
                                LOGGER.info("\n======> Try to decompose primitive tasks "
                                    + problem.toString(problem.getTasks().get(taskIndex)) + " with \n\n"
                                    + problem.toString(action));

                                LOGGER.info("=> Current state:");
                                LOGGER.info(problem.toString(currentNode.getState()));
                            }
                            if (state.satisfy(action.getPrecondition())) {
                                final PFDNode childNode = new PFDNode(currentNode);
                                childNode.setParent(currentNode);
                                childNode.setOperator(operator);
                                childNode.getState().apply(action.getConditionalEffects());
                                childNode.getTaskNetwork().removeTask(task);
                                childNode.setTask(taskIndex);
                                open.add(childNode);
                                if (this.isInteractive()) {
                                    LOGGER.info("=====> Decomposition succeeded push node:");
                                    LOGGER.info(problem.toString(childNode.getState()));
                                    LOGGER.info(problem.toString(problem.getTasks().get(childNode.getTask())));
                                    for (int t : childNode.getTaskNetwork().getTasks()) {
                                        LOGGER.info(problem.toString(problem.getTasks().get(t)));
                                    }
                                    LOGGER.info("=> New state:");
                                    LOGGER.info(problem.toString(childNode.getState()));
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
                    } else { // Case of compund tasks
                        for (Integer operator : relevantOperators) {
                            final Method method = problem.getMethods().get(operator);
                            if (this.isInteractive()) {
                                LOGGER.info("\n======> Try to decompose compound tasks "
                                    + problem.toString(problem.getTasks().get(taskIndex)) + " with\n\n"
                                    + problem.toString(method));
                            }
                            if (state.satisfy(method.getPrecondition())) {
                                final PFDNode childNode = new PFDNode(currentNode);
                                childNode.setParent(currentNode);
                                childNode.setOperator(problem.getActions().size() + operator);
                                childNode.getTaskNetwork().decompose(task, method);
                                childNode.setTask(taskIndex);
                                open.add(childNode);
                                if (this.isInteractive()) {
                                    LOGGER.info("=====> Decomposition succeeded push node:");
                                    LOGGER.info(problem.toString(childNode.getTaskNetwork()));
                                    LOGGER.info(problem.toString(problem.getTasks().get(childNode.getTask())));
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
        }
        return plan;
    }

    /**
     * The main method of the <code>PFD</code> planner.
     *
     * @param args the arguments of the command line.
     */
    public static void main(final String[] args) {
        try {
            final PFD planner = new PFD();
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
