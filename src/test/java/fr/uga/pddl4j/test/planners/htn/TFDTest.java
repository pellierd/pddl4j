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

import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.htn.stn.TFD;
import fr.uga.pddl4j.test.Tools;

import org.apache.logging.log4j.Level;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;

/**
 * Implements the <tt>TFDPlannerTest</tt> of the PDD4L library. The class executes the junit tests with TFDPlanner on
 * planning domain of IPC. A bound of 60 seconds is allocated to the search. The plan returns for each test is tested
 * with the pandaPiParser.
 *
 * @author D. Pellier
 * @version 1.0 - 16.19.2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TFDTest {

    /**
     * Computation timeout.
     */
    private static final int TIMEOUT = 10;

    /**
     * Default Trace level.
     */
    private static final Level LOG_LEVEL = Level.OFF;

    /**
     * The planner configuration used to run the tests.
     */
    private PlannerConfiguration config;

    /**
     * Test initialization.
     */
    @Before
    public void initTest() {
        this.config = TFD.getDefaultConfiguration();
        this.config.setProperty(TFD.TIME_OUT_SETTING, TFDTest.TIMEOUT);
        this.config.setProperty(TFD.LOG_LEVEL_SETTING, TFDTest.LOG_LEVEL);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
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
        Tools.solve(localTestPath, Tools.HDDL_EXT, Planner.Name.TFD, this.config);
    }
}
