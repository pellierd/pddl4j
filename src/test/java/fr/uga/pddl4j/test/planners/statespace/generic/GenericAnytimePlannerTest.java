/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.test.planners.statespace.generic;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.statespace.generic.GenericAnytimePlanner;
import fr.uga.pddl4j.planners.statespace.search.strategy.AStarAnytime;
import fr.uga.pddl4j.planners.statespace.search.strategy.AbstractStateSpaceStrategyAnytime;
import fr.uga.pddl4j.planners.statespace.search.strategy.GreedyBestFirstSearchAnytime;
import fr.uga.pddl4j.planners.statespace.search.strategy.HillClimbingAnytime;
import fr.uga.pddl4j.test.Tools;
import fr.uga.pddl4j.util.Plan;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Implements the <tt>GenericAnytimePlannerTest</tt> of the PDD4L library. The planner accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 * <p>This class will test the planner on benchmark domain and problem from International planning contest.
 * The goal here is to test the PDDL4J 3.0 plan using all the file used in the competition and
 * KCL-Planning validator: https://github.com/KCL-Planning/VAL</p>
 * <p>Note that IPC benchmark files are note delivered with the source code because of their 3GB size.
 * It suppose benchmark directory is a the root of your project.
 * If no test files are provided all test will pass the validation.</p>
 *
 * @author Emmanuel Hermellin
 * @version 0.1 - 22.11.18
 */
public class GenericAnytimePlannerTest {

    /**
     * Computation timeout.
     */
    private static final int TIMEOUT = 10;

    /**
     * Default Heuristic Type.
     */
    private static final Heuristic.Type HEURISTIC_TYPE = Heuristic.Type.FAST_FORWARD;

    /**
     * Default Heuristic Weight.
     */
    private static final double HEURISTIC_WEIGHT = 1.0;

    /**
     * Default Trace level.
     */
    private static final int TRACE_LEVEL = 0;

    /**
     * Default statistics computation.
     */
    private static final boolean STATISTICS = false;

    /**
     * The FF planner reference.
     */
    private GenericAnytimePlanner planner = null;

    /**
     * Method that executes benchmarks using files on the Generic Anytime planner with Astar Anytime search
     * to test its output plan.
     * IPC1 gripper tests
     */
    @Test
    public void testGenericPlanner_AstarAnytime_gripper() {
        final AbstractStateSpaceStrategyAnytime stateSpaceStrategy = new AStarAnytime(TIMEOUT * 1000,
            HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        planner = new GenericAnytimePlanner(STATISTICS, TRACE_LEVEL, stateSpaceStrategy);
        Tools.changeVALPerm();
        final String localTestPath = Tools.BENCH_DIR + "ipc1"
            + File.separator + "gripper"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath, "Astar Anytime");
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the Generic Anytime planner with GBFS Anytime search
     * to test its output plan.
     * IPC1 gripper tests
     */
    @Test
    public void testGenericPlanner_GbfsAnytime_gripper() {
        final AbstractStateSpaceStrategyAnytime stateSpaceStrategy = new GreedyBestFirstSearchAnytime(TIMEOUT * 1000,
            HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        planner = new GenericAnytimePlanner(STATISTICS, TRACE_LEVEL, stateSpaceStrategy);
        Tools.changeVALPerm();
        final String localTestPath = Tools.BENCH_DIR + "ipc1"
            + File.separator + "gripper"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath, "GBFS Anytime");
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the Generic Anytime planner with HC Anytime search
     * to test its output plan.
     * IPC1 gripper tests
     */
    @Test
    public void testGenericPlanner_HCAnytime_gripper() {
        final AbstractStateSpaceStrategyAnytime stateSpaceStrategy = new HillClimbingAnytime(TIMEOUT * 1000,
            HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        planner = new GenericAnytimePlanner(STATISTICS, TRACE_LEVEL, stateSpaceStrategy);
        Tools.changeVALPerm();
        final String localTestPath = Tools.BENCH_DIR + "ipc1"
            + File.separator + "gripper"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath, "HC Anytime");
        Tools.validatePlans(localTestPath);
    }

    /**
     * Generate output plan KLC-planning validator formatted.
     *
     * @param currentTestPath the current sub dir to test
     */
    private void generateValOutputPlans(String currentTestPath, String strategy) {
        Tools.cleanValPlan(currentTestPath);
        final ProblemFactory factory = new ProblemFactory();
        String currentDomain = currentTestPath + Tools.DOMAIN;
        boolean oneDomainPerProblem = false;
        String problemFile;
        String currentProblem;

        // Counting the number of problem files
        File[] pbFileList = new File(currentTestPath)
            .listFiles((dir, name) -> name.startsWith("p") && name.endsWith(".pddl") && !name.contains("dom"));

        int nbTest = 0;
        if (pbFileList != null) {
            nbTest = pbFileList.length;
        }

        // Check if there is on domain per problem or a shared domain for all
        if (!new File(currentDomain).exists()) {
            oneDomainPerProblem = true;
        }

        System.out.println("GenericPlanner: Test Generic planner on " + currentTestPath + " with " + strategy);
        // Loop around problems in one category
        for (int i = 1; i < nbTest + 1; i++) {
            if (i < 10) {
                problemFile = "p0" + i + Tools.PDDL_EXT;
            } else {
                problemFile = "p" + i + Tools.PDDL_EXT;
            }

            currentProblem = currentTestPath + problemFile;

            if (oneDomainPerProblem) {
                currentDomain = currentTestPath + problemFile.split(".p")[0] + "-" + Tools.DOMAIN;
            }
            // Parses the PDDL domain and problem description
            try {
                factory.setTraceLevel(TRACE_LEVEL);

                ErrorManager errorManager = factory.parse(new File(currentDomain), new File(currentProblem));
                Assert.assertTrue(errorManager.isEmpty());

                CodedProblem pb = null;
                Plan plan = null;
                try {
                    // Encodes and instantiates the problem in a compact representation
                    System.out.println("* Encoding [" + currentProblem + "]" + "...");
                    pb = factory.encode();
                    if (pb.isSolvable()) {
                        // Searches for a solution plan
                        System.out.println("* Trying to solve [" + currentProblem + "]"
                            + " in " + TIMEOUT + " seconds");
                        plan = planner.search(pb);
                    } else {
                        System.err.println("* Problem [" + currentProblem + "]" + " not solvable.");
                    }
                } catch (OutOfMemoryError err) {
                    System.out.println("ERR: " + err.getMessage() + " - test aborted");
                    return;
                } catch (IllegalArgumentException iaex) {
                    if (iaex.getMessage().equalsIgnoreCase("problem to encode not ADL")) {
                        System.err.println("[" + currentProblem + "]: Not ADL problem!");
                    } else {
                        throw iaex;
                    }
                }

                if (plan == null) { // no solution in TIMEOUT computation time
                    System.out.println("* No solution found in " + TIMEOUT + " seconds for " + currentProblem);
                } else if (plan.isEmpty()) { // Empty solution
                    System.out.println("* Empty solution for " + currentProblem);
                } else { // Save output plan
                    try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(currentProblem.substring(0,
                        currentProblem.length() - Tools.PDDL_EXT.length()) + Tools.PLAN_EXT))) {
                        bw.write(pb.toString(plan));
                    }
                    System.out.println("* Solution found for " + currentProblem);
                }

            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
            System.out.println();
        }
    }
}
