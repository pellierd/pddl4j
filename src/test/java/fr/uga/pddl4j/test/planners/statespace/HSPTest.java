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

package fr.uga.pddl4j.test.planners.statespace;

import fr.uga.pddl4j.heuristics.state.StateHeuristic;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.statespace.HSP;
import fr.uga.pddl4j.test.Tools;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;

/**
 * Implements the <tt>HSPTest</tt> of the PDD4L library. The class executes the junit tests with HSP on ADL and STRIPS
 * planning domain of IPC. A bound of 60 seconds is allocated to the search. The plan returns for each test is tested
 * with the KCL-Planning validator: https://github.com/KCL-Planning/VAL.
 *
 * @author C. Gerard
 * @author D. Pellier
 * @version 1.3 - 14.10.20
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HSPTest {

    /**
     * Computation timeout.
     */
    private static final int TIMEOUT = 10;

    /**
     * Default Heuristic Type.
     */
    private static final StateHeuristic.Name HEURISTIC = StateHeuristic.Name.FAST_FORWARD;

    /**
     * Default Heuristic Weight.
     */
    private static final double HEURISTIC_WEIGHT = 1.0;

    /**
     * The default planner configuration for the tests.
     */
    private PlannerConfiguration config;

    /**
     * Test initialization.
     */
    @Before
    public void initTest() {
        this.config = HSP.getDefaultConfiguration();
        this.config.setProperty(HSP.TIME_OUT_SETTING, HSPTest.TIMEOUT);
        this.config.setProperty(HSP.HEURISTIC_SETTING, HSPTest.HEURISTIC);
        this.config.setProperty(HSP.WEIGHT_HEURISTIC_SETTING, HSPTest.HEURISTIC_WEIGHT);
        Tools.changeVALPerm();
    }

    /**
     * Method that executes tests using IPC 1998 Assembly ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC1998_Assembly_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/assembly/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 1998 Grid STRIPS untyped benchmarks.
     * FAILURE
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC1998_Grid_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/grid/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 1998 gripper ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC1998_Gripper_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/gripper/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 1998 Gripper STRIPS benchmarks.
     * FAILURE
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC1998_Gripper_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/gripper/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 1998 Logistics ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC1998_Logistics_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 1998 Logistics STRIPS Round1 benchmarks.
     * Test takes fails due to time out > 600s
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC1998_Logistics_STRIPS_Round1() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round1" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     *  Method that executes tests using IPC 1998 Logistics STRIPS Round2 benchmarks.
     * FAILURE
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC1998_Logistics_STRIPS_Round2() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round2" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     *  Method that executes tests using IPC 1998 Movie ADL benchmarks.
     * FAILURE: Unable to deal with negation in the initial state of the problem
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC1998_Movie_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 1998 Movie STRIPS benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC1998_Movie_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Blocks STRIPS typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Blocks_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Blocks STRIPS untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Blocks_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator ADL full typed benchmarks.
     * FAILURE
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Elevator_ADL_Full_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/adl-full-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator ADL simple typed benchmarks.
     * FAILURE
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Elevator_ADL_Simple_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/adl-simple-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator STRIPS simple typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Elevator_STRIPS_Simple_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator STRIPS simple untyped benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Elevator_STRIPS_Simple_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Freecell STRIPS  typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Freecell_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Freecell STRIPS untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Freecell_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Logistics STRIPS typed benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Logistics_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/logistics/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Logistics STRIPS untyped benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Logistics_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/logistics/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Schedule ADL typed benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Schedule_ADL_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/schedule/adl-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Schedule ADL untyped benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2000_Schedule_ADL_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/schedule/adl-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Depots STRIPS automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Depots_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/depots/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Depots STRIPS hand coded benchmarks.
     * Failure: p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Depots_STRIPS_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/depots/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Driver Log STRIPS automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Driverlog_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/driverlog/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Driverlog STRIPS hand coded benchmarks.
     * Failure: p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Driverlog_STRIPS_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/driverlog/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Freecell STRIPS automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Freecell_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/freecell/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Rovers STRIPS automatic benchmarks.
     * Failure: several plans are not validated
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Rovers_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Rovers STRIPS hand coded benchmarks.
     * Failure: several plans are not validated
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Rovers_STRIPS_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Satellite STRIPS automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Satellite_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Satellite STRIPS hand coded benchmarks.
     * OK to hard in 10 seconds
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Satellite_STRIPS_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Zeno Travel STRIPS automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Zenotravel_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2002 Zenotravel STRIPS hand coded benchmarks.
     * OK to hard in 10 seconds
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2002_Zenotravel_STRIPS_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2004 Airport non temporal ADL benchmarks.
     * Failure: Computing relaxed planning graph
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2004_Airport_Non_Temporal_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/nontemporal-adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2004 Airport non temporal STRIPS benchmarks.
     * Failure: Plans not validated
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2004_Airport_Non_Temporal_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/nontemporal-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2004 Pipesworld no-tankage non temporal STRIPS benchmarks.
     * Failure: Plans not validated
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2004_Pipesworld_No_Tankage_Non_Temporal_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/no-tankage-nontemporal-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2004 Pipesworld tankage non temporal STRIPS benchmarks.
     * Failure: Plans not validated
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2004_Pipesworld_Tankage_Non_Temporal_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/tankage-nontemporal-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2004 Promela Dining Philosophers ADL benchmarks.
     * Failure: type "number" cannot be used as derived type
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2004_Promela_Dining_Philisophers_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/promela-dining-philosophers/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2004 PSR middle compiled ADL benchmarks.
     * Failure: Bugs in method simplify
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2004_PSR_middle_compiles_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/psr/middle-compiled-adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2004 PSR small STRIPS benchmarks.
     * Failure: Plan not validated
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2004_PSR_small_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/psr/small-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2004 Satellite STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2004_Satellite_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/satellite/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2006 Openstacks propositional benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2006_Openstacks_Propositional() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/openstacks/propositional" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2006 Openstacks propositional STRIPS benchmarks.
     * Failure: Plans not validated
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2006_Openstacks_Propositional_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/openstacks/propositional-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2006 Pathways propositional benchmarks.
     * Failure: Plans no validated
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2006_Pathways_Propositional() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/pathways/propositional" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

    /**
     * Method that executes tests using IPC 2006 Pathways propositional STRIPS benchmarks.
     * Failure: Plans no validated
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_HSP_IPC2006_Pathways_Propositional_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/pathways/propositional-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.HSP, this.config);
    }

}
