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

package fr.uga.pddl4j.test.planners;

import fr.uga.pddl4j.heuristics.relaxation.RelaxationHeuristic;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.statespace.FastForward;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.test.Tools;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Implements the <tt>FastForwardTest</tt> of the PDD4L library. The class executes the junit tests with FastForward on
 * ADL and STRIPS planning domain of IPC. A bound of 60 seconds is allocated to the search. The plan returns for each test is tested
 * with the KCL-Planning validator: https://github.com/KCL-Planning/VAL.
 *
 * @author E. Hermellin
 * @author C. Gerard
 * @author D. Pellier
 * @version 0.1 - 24.01.18
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FastForwardTest {

    /**
     * Computation timeout.
     */
    private static final int TIMEOUT = 5;

    /**
     * Default Heuristic Type.
     */
    private static final RelaxationHeuristic.Type HEURISTIC_TYPE = RelaxationHeuristic.Type.FAST_FORWARD;

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
     * The FastForward planner reference.
     */
    private FastForward planner = null;

    /**
     * Test initialization.
     */
    @Before
    public void initTest() {
        // Creates the planner
        planner = new FastForward(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT, STATISTICS, TRACE_LEVEL);
        Tools.changeVALPerm();
    }

    /**
     * Method that executes tests using IPC 1998 Assembly ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Assembly_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/assembly/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Grid STRIPS untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Grid_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/grid/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 gripper ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Gripper_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/gripper/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Gripper STRIPS benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Gripper_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/gripper/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Logistics ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Logistics_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Logistics STRIPS Round1 benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Logistics_STRIPS_Round1() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round1" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     *  Method that executes tests using IPC 1998 Logistics STRIPS Round2 benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Logistics_STRIPS_Round2() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round2" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     *  Method that executes tests using IPC 1998 Movie ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Movie_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     *  Method that executes tests using IPC 1998 Movie STRIPS benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Movie_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Blocks STRIPS typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Blocks_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Blocks STRIPS untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Blocks_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator ADL full typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Elevator_ADL_Full_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/adl-full-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator ADL simple typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Elevator_ADL_Simple_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/adl-simple-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator STRIPS simple typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Elevator_STRIPS_Simple_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator STRIPS simple untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Elevator_STRIPS_Simple_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Freecell STRIPS  typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Freecell_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Freecell STRIPS untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Freecell_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Logistics STRIPS typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Logistics_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/logistics/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Logistics STRIPS untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Logistics_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/logistics/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Schedule ADL typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Schedule_ADL_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/schedule/adl-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Schedule ADL untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Schedule_ADL_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/schedule/adl-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePlans(localTestPath);
    }

    /**
     * Generate output plan KLC-planning validator formatted.
     *
     * @param currentTestPath the current sub dir to test
     */
    private void generateValOutputPlans(String currentTestPath) {
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

        System.out.println("FastForwardTest: Test FastForward planner on " + currentTestPath);
        // Loop around problems in one category
        for (int i = 1; i < nbTest + 1; i++) {
            if (i < 10) {
                if (nbTest < 100) {
                    problemFile = "p0" + i + Tools.PDDL_EXT;
                } else {
                    problemFile = "p00" + i + Tools.PDDL_EXT;
                }
            } else if (i < 100) {
                if (nbTest < 100) {
                    problemFile = "p" + i + Tools.PDDL_EXT;
                } else {
                    problemFile = "p0" + i + Tools.PDDL_EXT;
                }
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

                Problem pb = null;
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
                        System.err.println("* PDDLProblem [" + currentProblem + "]" + " not solvable.");
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

    /**
     * Valid JSON output for gripper p01 problem.
     */
    private static String validGripperP01JSON =
        "{\"Action 1\":{\"Names\":\"move\",\"Parameters\":[\"rooma\",\"roomb\"],\"Position\":1,\"Preconditions\":"
            + "{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\"]},\"Condition_Expressions\":[{\"Condition\":"
            + "{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(at-robby rooma)\"],\"Positives\":"
            + "[\"(at-robby roomb)\"]}}]},\"Action 0\":{\"Names\":\"pick\",\"Parameters\":[\"ball4\",\"rooma\",\""
            + "left\"],\"Position\":0,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\",\"(at "
            + "ball4 rooma)\",\"(free left)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Posit"
            + "ives\":[]},\"Effect\":{\"Negatives\":[\"(at ball4 rooma)\",\"(free left)\"],\"Positives\":[\"(carry "
            + "ball4 left)\"]}}]},\"Size\":13,\"Action 5\":{\"Names\":\"move\",\"Parameters\":[\"rooma\",\"roomb\"]"
            + ",\"Position\":5,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\"]},\"Conditio"
            + "n_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(at"
            + "-robby rooma)\"],\"Positives\":[\"(at-robby roomb)\"]}}]},\"Action 11\":{\"Names\":\"drop\",\"Parame"
            + "ters\":[\"ball2\",\"roomb\",\"left\"],\"Position\":11,\"Preconditions\":{\"Negatives\":[],\"Positive"
            + "s\":[\"(at-robby roomb)\",\"(carry ball2 left)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negat"
            + "ives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball2 left)\"],\"Positives\":[\"(free "
            + "left)\",\"(at ball2 roomb)\"]}}]},\"Type_de_plan\":1,\"Action 4\":{\"Names\":\"pick\",\"Parameters\":["
            + "\"ball3\",\"rooma\",\"left\"],\"Position\":4,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-"
            + "robby rooma)\",\"(free left)\",\"(at ball3 rooma)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Neg"
            + "atives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(free left)\",\"(at ball3 rooma)\"],\"Posit"
            + "ives\":[\"(carry ball3 left)\"]}}]},\"Action 12\":{\"Names\":\"drop\",\"Parameters\":[\"ball1\",\"roo"
            + "mb\",\"right\"],\"Position\":12,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby roomb"
            + ")\",\"(carry ball1 right)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positive"
            + "s\":[]},\"Effect\":{\"Negatives\":[\"(carry ball1 right)\"],\"Positives\":[\"(free right)\",\"(at "
            + "ball1 roomb)\"]}}]},\"Makespan\":13.0,\"Action 3\":{\"Names\":\"move\",\"Parameters\":[\"roomb\",\"ro"
            + "oma\"],\"Position\":3,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby roomb)\"]},\"Condi"
            + "tion_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(at"
            + "-robby roomb)\"],\"Positives\":[\"(at-robby rooma)\"]}}]},\"Action 2\":{\"Names\":\"drop\",\"Parameter"
            + "s\":[\"ball4\",\"roomb\",\"left\"],\"Position\":2,\"Preconditions\":{\"Negatives\":[],\"Positives\":"
            + "[\"(at-robby roomb)\",\"(carry ball4 left)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negative"
            + "s\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball4 left)\"],\"Positives\":[\"(free "
            + "left)\",\"(at ball4 roomb)\"]}}]},\"Action 10\":{\"Names\":\"move\",\"Parameters\":[\"rooma\",\"room"
            + "b\"],\"Position\":10,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\"]},\"Condi"
            + "tion_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negative"
            + "s\":[\"(at-robby rooma)\"],\"Positives\":[\"(at-robby roomb)\"]}}]},\"Action 9\":{\"Names\":\"pic"
            + "k\",\"Parameters\":[\"ball1\",\"rooma\",\"right\"],\"Position\":9,\"Preconditions\":{\"Negative"
            + "s\":[],\"Positives\":[\"(at-robby rooma)\",\"(free right)\",\"(at ball1 rooma)\"]},\"Condition_Express"
            + "ions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(free righ"
            + "t)\",\"(at ball1 rooma)\"],\"Positives\":[\"(carry ball1 right)\"]}}]},\"Cost\":13.0,\"Action 8\":{\"N"
            + "ames\":\"pick\",\"Parameters\":[\"ball2\",\"rooma\",\"left\"],\"Position\":8,\"Preconditions\":{\"Nega"
            + "tives\":[],\"Positives\":[\"(at-robby rooma)\",\"(free left)\",\"(at ball2 rooma)\"]},\"Condition_Expr"
            + "essions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(free left"
            + ")\",\"(at ball2 rooma)\"],\"Positives\":[\"(carry ball2 left)\"]}}]},\"Action 7\":{\"Names\":\"mo"
            + "ve\",\"Parameters\":[\"roomb\",\"rooma\"],\"Position\":7,\"Preconditions\":{\"Negatives\":[],\"Posit"
            + "ives\":[\"(at-robby roomb)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positiv"
            + "es\":[]},\"Effect\":{\"Negatives\":[\"(at-robby roomb)\"],\"Positives\":[\"(at-robby rooma)\"]}}]},\"A"
            + "ction 6\":{\"Names\":\"drop\",\"Parameters\":[\"ball3\",\"roomb\",\"left\"],\"Position\":6,\"Precondit"
            + "ions\":{\"Negatives\":[],\"Positives\":[\"(at-robby roomb)\",\"(carry ball3 left)\"]},\"Condition_Expre"
            + "ssions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball3"
            + " left)\"],\"Positives\":[\"(free left)\",\"(at ball3 roomb)\"]}}]},\"timeSpecifiers\":[0, 1, 2, 3, 4, "
            + "5, 6, 7, 8, 9, 10, 11, 12]}";
}
