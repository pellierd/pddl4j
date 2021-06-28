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

package fr.uga.pddl4j.test.planners.htn;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.Configuration;
import fr.uga.pddl4j.planners.htn.stn.TFDPlanner;
import fr.uga.pddl4j.problem.HTNProblem;
import fr.uga.pddl4j.test.Tools;

import org.apache.logging.log4j.Level;
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
 * Implements the <tt>TFDPlannerTest</tt> of the PDD4L library. The class executes the junit tests with TFDPlanner on
 * planning domain of IPC. A bound of 60 seconds is allocated to the search. The plan returns for each test is tested
 * with the pandaPiParser.
 *
 * @author D. Pellier
 * @version 1.0 - 16.19.2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TFDPlannerTest {

    /**
     * Computation timeout.
     */
    private static final int TIMEOUT = 10;

    /**
     * Default Trace level.
     */
    private static final Level TRACE_LEVEL = Level.OFF;

    /**
     * The TFDPlanner planner reference.
     */
    private TFDPlanner planner = null;

    /**
     * Test initialization.
     */
    @Before
    public void initTest() {
        Configuration config = TFDPlanner.getDefaultConfiguration();
        config.setTimeout(TFDPlannerTest.TIMEOUT);
        config.setTraceLevel(TFDPlannerTest.TRACE_LEVEL);
        this.planner = new TFDPlanner(config);
        Tools.changeVALPerm();
    }

    /**
     * Method that executes tests using IPC 2020 feature test 1.
     *
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_TFDPlanner_IPC2020_HDDL_Feature_Test1() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/feature-tests/test1" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 feature test 2.
     *
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_TFDPlanner_IPC2020_HDDL_Feature_Test2() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/feature-tests/test2" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 feature test 3.
     *
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_TFDPlanner_IPC2020_HDDL_Feature_Test3() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/feature-tests/test3" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 feature test 4.
     *
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_TFDPlanner_IPC2020_HDDL_Feature_Test4() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/feature-tests/test4" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 feature test 5.
     *
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_TFDPlanner_IPC2020_HDDL_Feature_Test5() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/feature-tests/test5" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 Barman HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_Barman() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/barman" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 Childsnack HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_Childsnack() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/childsnack" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 Gripper HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_Gripper() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/gripper" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 Miconic HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_Miconic() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/miconic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 Rover HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_Rover() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/rover" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 Satellite HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_Satellite() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/satellite" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 Smartphone HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_Smartphone() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/smartphone" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 Transport HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_Transport() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/transport" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 UMTranslog HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_UMTranslog() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/umtranslog" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 Woodworking HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_Woodworking() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/woodworking" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2020 Zenotravel HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_TFDPlanner_IPC2020_HDDL_Zenotravel() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/zenotravel" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validateHDDLPlans(localTestPath);
    }

    /**
     * Generate output plan KLC-planning validator formatted.
     *
     * @param currentTestPath the current sub dir to test
     */
    private void generateValOutputPlans(String currentTestPath) {
        Tools.cleanValPlan(currentTestPath);
        String currentDomain = currentTestPath + Tools.HDDL_DOMAIN;

        String currentProblem;

        // Counting the number of problem files
        File[] pbFileList = new File(currentTestPath)
            .listFiles((dir, name) -> name.startsWith("p") && name.endsWith(Tools.HDDL_EXT) && !name.contains("dom"));

        int nbTest = 0;
        if (pbFileList != null) {
            nbTest = pbFileList.length;
        }

        System.out.println("PFDPlannerTest: Test PFD planner on " + currentTestPath + "\n");
        // Loop around problems in one category
        for (int i = 1; i < nbTest + 1; i++) {
            String problemFile;
            if (i < 10) {
                if (nbTest < 100) {
                    problemFile = "p0" + i + Tools.HDDL_EXT;
                } else {
                    problemFile = "p00" + i + Tools.HDDL_EXT;
                }
            } else if (i < 100) {
                if (nbTest < 100) {
                    problemFile = "p" + i + Tools.HDDL_EXT;
                } else {
                    problemFile = "p0" + i + Tools.HDDL_EXT;
                }
            } else {
                problemFile = "p" + i + Tools.HDDL_EXT;
            }

            currentProblem = currentTestPath + problemFile;

            // Parses the HDDL domain and problem description
            try {
                ParsedProblem parsedProblem = this.planner.parse(currentDomain, currentProblem);
                ErrorManager errorManager = this.planner.getParserErrorManager();
                if (!errorManager.getMessages(Message.Type.LEXICAL_ERROR).isEmpty()) {
                    errorManager.print(Message.Type.LEXICAL_ERROR);
                }
                if (!errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty()) {
                    errorManager.print(Message.Type.PARSER_ERROR);
                }
                Assert.assertTrue(errorManager.getMessages(Message.Type.LEXICAL_ERROR).isEmpty());
                Assert.assertTrue(errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty());

                Plan plan = null;
                // Encodes and instantiates the problem in a compact representation
                System.out.println("* Encoding [" + currentProblem + "]" + "...");
                try {
                    HTNProblem pb = this.planner.instantiate(parsedProblem);
                    if (pb.isSolvable()) {
                        // Searches for a solution plan
                        System.out.println("* Trying to solve [" + currentProblem + "]"
                            + " in " + TIMEOUT + " seconds");
                        plan = this.planner.solve(pb);
                    } else {
                        System.err.println("* HDDLProblem [" + currentProblem + "]" + " not solvable.");
                    }
                    if (plan == null) { // no solution in TIMEOUT computation time
                        System.out.println("* No solution found in " + TIMEOUT + " seconds for " + currentProblem);
                        break;
                    } else if (plan.isEmpty()) { // Empty solution
                        System.out.println("* Empty solution for " + currentProblem);
                    } else { // Save output plan
                        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(currentProblem.substring(0,
                            currentProblem.length() - Tools.HDDL_EXT.length()) + Tools.VAL_EXT))) {
                            bw.write(pb.toString(plan.getHierarchy()));
                        }
                        System.out.println("* Solution found for " + currentProblem);
                    }
                } catch (OutOfMemoryError err) {
                    System.err.println("ERR: " + err.getMessage() + " - test aborted");
                    return;
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            System.out.println();
        }
    }
}
