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

package fr.uga.pddl4j.test.encoding;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.encoding.JsonAdapter;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.statespace.hsp.HSP;
import fr.uga.pddl4j.test.Tools;
import fr.uga.pddl4j.util.Plan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Implements the <tt>AdapterPlanJavaJsonTest</tt> of the PDD4L library.
 *
 * @author Cédric Gerard
 * @version 0.1 - 20.07.16
 */
public class JsonAdapterTest {

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
     * The HSP planner reference.
     */
    private HSP planner = null;

    /**
     * Test initialization.
     */
    @Before
    public void initTest() {
        // Creates the planner
        planner = new HSP(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT, STATISTICS, TRACE_LEVEL);
    }

    /**
     * Test the JSON output on gripper p01 problem.
     */
    @Test
    public void test_toStringJ_gripper() {
        final String localTestPath = Tools.BENCH_DIR + File.separator + "ipc1/gripper" + File.separator;

        System.out.println("JsonAdaptater: Test JSON output on " + localTestPath);

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.err.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        final CodedProblem problem = get01Problem(localTestPath);
        Assert.assertFalse(problem == null);

        final Plan plan = getPlan(problem);
        Assert.assertFalse(plan == null);

        final JsonAdapter converter = new JsonAdapter(problem);
        String jsonPlan = converter.toJsonString(plan);

        Assert.assertTrue(jsonPlan.contentEquals(validGripperP01JSON));

    }

    /**
     * Test the JSON file output on gripper p01 problem.
     */
    @Test
    public void test_saveInFile_gripper() {
        final String localTestPath = Tools.BENCH_DIR + File.separator + "ipc1/gripper" + File.separator;

        System.out.println("JsonAdaptater: Test JSON output in file on " + localTestPath);

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.err.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        final CodedProblem problem = get01Problem(localTestPath);
        Assert.assertFalse(problem == null);

        final Plan plan = getPlan(problem);
        Assert.assertFalse(plan == null);

        final JsonAdapter converter = new JsonAdapter(problem);
        final String outputJson = converter.toJsonString(plan);
        final String outputFile = "p01.json";
        converter.saveInFile(outputFile);

        try {
            final Path outputFilePath = Paths.get(outputFile);
            final String fileContent = new String(Files.readAllBytes(outputFilePath), StandardCharsets.UTF_8);
            Assert.assertTrue(fileContent.contentEquals(validGripperP01JSON));
            Assert.assertTrue(fileContent.contentEquals(outputJson));

            Files.delete(outputFilePath);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Get the plan from the first problem of specified path.
     *
     * @param currentTestPath the path where to find the problem
     * @return the plan
     */
    private CodedProblem get01Problem(String currentTestPath) {
        final ProblemFactory factory = new ProblemFactory();
        String currentDomain = currentTestPath + Tools.DOMAIN;
        boolean oneDomainPerProblem = false;
        String problemFile;
        String currentProblem;
        CodedProblem pb = null;

        // Check if there is on domain per problem or a shared domain for all
        if (!new File(currentDomain).exists()) {
            oneDomainPerProblem = true;
        }

        problemFile = "p01" + Tools.PDDL_EXT;
        currentProblem = currentTestPath + problemFile;

        if (oneDomainPerProblem) {
            currentDomain = currentTestPath + problemFile.split(".p")[0] + "-" + Tools.DOMAIN;
        }

        // Parses the PDDL domain and problem description
        try {
            factory.setTraceLevel(TRACE_LEVEL);
            ErrorManager errorManager = factory.parse(new File(currentDomain), new File(currentProblem));
            Assert.assertTrue(errorManager.isEmpty());

            try {
                // Encodes and instantiates the problem in a compact representation
                pb = factory.encode();
            } catch (OutOfMemoryError err) {
                System.err.println("ERR: " + err.getMessage() + " - test aborted");
                return null;
            } catch (IllegalArgumentException iaex) {
                if (iaex.getMessage().equalsIgnoreCase("problem to encode not ADL")) {
                    System.err.println("[" + currentProblem + "]: Not ADL problem!");
                    return null;
                } else {
                    throw iaex;
                }
            }

        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }

        return pb;
    }

    /**
     * Get a plan from a CodedProblem.
     *
     * @param pb the codedProblem to solve
     * @return the Plan object
     */
    private Plan getPlan(CodedProblem pb) {
        Plan plan = null;
        try {
            if (pb.isSolvable()) {
                // Searches for a solution plan
                plan = planner.search(pb);
            } else {
                System.err.println("Problem not solvable.");
            }
        } catch (OutOfMemoryError err) {
            System.err.println("ERR: " + err.getMessage() + " - test aborted");
            return null;
        }

        return plan;
    }

    /**
     * Valid JSON output for gripper p01 problem.
     */
    private static String validGripperP01JSON =
        "{\"Action 1\":{\"Names\":\"pick\",\"Parameters\":[\"ball2\",\"rooma\",\"right\"],"
            + "\"Position\":1,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\",\"(free right)\","
            + "\"(at ball2 rooma)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},"
            + "\"Effect\":{\"Negatives\":[\"(free right)\",\"(at ball2 rooma)\"],\"Positives\":[\"(carry ball2 right)\""
            + "]}}]},\"Action 0\":{\"Names\":\"pick\",\"Parameters\":[\"ball4\",\"rooma\",\"left\"],\"Position\":0,"
            + "\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\",\"(at ball4 rooma)\",\""
            + "(free left)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\""
            + ":{\"Negatives\":[\"(at ball4 rooma)\",\"(free left)\"],\"Positives\":[\"(carry ball4 left)\"]}}]},"
            + "\"Size\":11,\"Action 5\":{\"Names\":\"move\",\"Parameters\":[\"roomb\",\"rooma\"],\"Position\":5,"
            + "\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby roomb)\"]},\"Condition_Expressions\""
            + ":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(at-robby roomb)\"],"
            + "\"Positives\":[\"(at-robby rooma)\"]}}]},\"Type_de_plan\":1,\"Action 4\":{\"Names\":\"drop\","
            + "\"Parameters\":[\"ball4\",\"roomb\",\"left\"],\"Position\":4,\"Preconditions\":{\"Negatives\":[],"
            + "\"Positives\":[\"(at-robby roomb)\",\"(carry ball4 left)\"]},\"Condition_Expressions\":[{\"Condition\""
            + ":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball4 left)\"],\"Positives\""
            + ":[\"(free left)\",\"(at ball4 roomb)\"]}}]},\"Makespan\":11.0,\"Action 3\":{\"Names\":\"drop\","
            + "\"Parameters\":[\"ball2\",\"roomb\",\"right\"],\"Position\":3,\"Preconditions\":{\"Negatives\":[],"
            + "\"Positives\":[\"(at-robby roomb)\",\"(carry ball2 right)\"]},\"Condition_Expressions\":[{\"Condition\""
            + ":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball2 right)\"],\"Positives\""
            + ":[\"(free right)\",\"(at ball2 roomb)\"]}}]},\"Action 2\":{\"Names\":\"move\",\"Parameters\":[\"rooma\","
            + "\"roomb\"],\"Position\":2,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\"]},"
            + "\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\""
            + ":[\"(at-robby rooma)\"],\"Positives\":[\"(at-robby roomb)\"]}}]},\"Action 10\":{\"Names\":\"drop\","
            + "\"Parameters\":[\"ball3\",\"roomb\",\"left\"],\"Position\":10,\"Preconditions\":{\"Negatives\":[],"
            + "\"Positives\":[\"(at-robby roomb)\",\"(carry ball3 left)\"]},\"Condition_Expressions\":[{\"Condition\""
            + ":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball3 left)\"],\"Positives\""
            + ":[\"(free left)\",\"(at ball3 roomb)\"]}}]},\"Action 9\":{\"Names\":\"drop\",\"Parameters\":[\"ball1\","
            + "\"roomb\",\"right\"],\"Position\":9,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\""
            + "(at-robby roomb)\",\"(carry ball1 right)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negatives\""
            + ":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball1 right)\"],\"Positives\":[\"(free right)"
            + "\",\"(at ball1 roomb)\"]}}]},\"Cost\":11.0,\"Action 8\":{\"Names\":\"move\",\"Parameters\":[\"rooma\","
            + "\"roomb\"],\"Position\":8,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\"]},"
            + "\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\""
            + ":[\"(at-robby rooma)\"],\"Positives\":[\"(at-robby roomb)\"]}}]},\"Action 7\":{\"Names\":\"pick\","
            + "\"Parameters\":[\"ball3\",\"rooma\",\"left\"],\"Position\":7,\"Preconditions\":{\"Negatives\":[],"
            + "\"Positives\":[\"(at-robby rooma)\",\"(free left)\",\"(at ball3 rooma)\"]},\"Condition_Expressions\""
            + ":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(free left)\","
            + "\"(at ball3 rooma)\"],\"Positives\":[\"(carry ball3 left)\"]}}]},\"Action 6\":{\"Names\":\"pick\","
            + "\"Parameters\":[\"ball1\",\"rooma\",\"right\"],\"Position\":6,\"Preconditions\":{\"Negatives\":[],"
            + "\"Positives\":[\"(at-robby rooma)\",\"(free right)\",\"(at ball1 rooma)\"]},\"Condition_Expressions\":"
            + "[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(free right)\","
            + "\"(at ball1 rooma)\"],\"Positives\":[\"(carry ball1 right)\"]}}]},\"timeSpecifiers\""
            + ":[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}";

}
