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

import fr.uga.pddl4j.heuristics.graph.PlanningGraphHeuristic;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.statespace.HSP;
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
 * Implements the <tt>HSPTest</tt> of the PDD4L library. The class executes the junit tests with HSP on ADL and STRIPS
 * planning domain of IPC. A bound of 60 seconds is allocated to the search. The plan returns for each test is tested
 * with the KCL-Planning validator: https://github.com/KCL-Planning/VAL.
 *
 * @author C. Gerard
 * @author D. Pellier
 * @version 1.2 - 14.10.20
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
    private static final PlanningGraphHeuristic.Type HEURISTIC_TYPE = PlanningGraphHeuristic.Type.FAST_FORWARD;

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
        this.planner = new HSP(HSPTest.TIMEOUT * 1000, HSPTest.HEURISTIC_TYPE, HSPTest.HEURISTIC_WEIGHT,
            HSPTest.STATISTICS, HSPTest.TRACE_LEVEL);
        Tools.changeVALPerm();
    }

    /**
     * Method that executes tests using IPC 1998 Assembly ADL benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC1998_Assembly_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/assembly/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Grid STRIPS untyped benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC1998_Grid_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/grid/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 gripper ADL benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC1998_Gripper_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/gripper/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Gripper STRIPS benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC1998_Gripper_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/gripper/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Logistics ADL benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC1998_Logistics_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Logistics STRIPS Round1 benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC1998_Logistics_STRIPS_Round1() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round1" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     *  Method that executes tests using IPC 1998 Logistics STRIPS Round2 benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC1998_Logistics_STRIPS_Round2() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round2" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     *  Method that executes tests using IPC 1998 Movie ADL benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC1998_Movie_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Movie STRIPS benchmarks.
     * Ok
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC1998_Movie_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Blocks STRIPS typed benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Blocks_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Blocks STRIPS untyped benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Blocks_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator ADL full typed benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Elevator_ADL_Full_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/adl-full-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator ADL simple typed benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Elevator_ADL_Simple_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/adl-simple-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator STRIPS simple typed benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Elevator_STRIPS_Simple_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator STRIPS simple untyped benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Elevator_STRIPS_Simple_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Freecell STRIPS  typed benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Freecell_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Freecell STRIPS untyped benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Freecell_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Logistics STRIPS typed benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Logistics_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/logistics/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Logistics STRIPS untyped benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Logistics_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/logistics/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Schedule ADL typed benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Schedule_ADL_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/schedule/adl-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Schedule ADL untyped benchmarks.
     * Failure
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2000_Schedule_ADL_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/schedule/adl-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Depots STRIPS automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Depots_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/depots/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Depots STRIPS hand coded benchmarks.
     * Failure: p01
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Depots_STRIPS_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/depots/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Driver Log STRIPS automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Driverlog_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/driverlog/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Driverlog STRIPS hand coded benchmarks.
     * Failure: p01
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Driverlog_STRIPS_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/driverlog/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Freecell STRIPS automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Freecell_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/freecell/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Rovers STRIPS automatic benchmarks.
     * Failure: several plans are not validated
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Rovers_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Rovers STRIPS hand coded benchmarks.
     * Failure: several plans are not validated
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Rovers_STRIPS_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Satellite STRIPS automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Satellite_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Satellite STRIPS hand coded benchmarks.
     * OK to hard in 10 seconds
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Satellite_STRIPS_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Zeno Travel STRIPS automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Zenotravel_STRIPS_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2002 Zenotravel STRIPS hand coded benchmarks.
     * OK to hard in 10 seconds
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2002_Zenotravel_STRIPS_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2004 Airport non temporal ADL benchmarks.
     * Failure: Computing relaxed planning graph
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2004_Airport_Non_Temporal_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/nontemporal-adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2004 Airport non temporal STRIPS benchmarks.
     * Failure: Plans not validated
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2004_Airport_Non_Temporal_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/nontemporal-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2004 Pipesworld no-tankage non temporal STRIPS benchmarks.
     * Failure: Plans not validated
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2004_Pipesworld_No_Tankage_Non_Temporal_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/no-tankage-nontemporal-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2004 Pipesworld tankage non temporal STRIPS benchmarks.
     * Failure: Plans not validated
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2004_Pipesworld_Tankage_Non_Temporal_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/tankage-nontemporal-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2004 Promela Dining Philosophers ADL benchmarks.
     * Failure: type "number" cannot be used as derived type
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2004_Promela_Dining_Philisophers_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/promela-dining-philosophers/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2004 PSR middle compiled ADL benchmarks.
     * Failure: Bugs in method simplify
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_HSP_IPC2004_PSR_middle_compiles_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/psr/middle-compiled-adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.generateValOutputPlans(localTestPath);
        Tools.validatePDDLPlans(localTestPath);
    }

    /**
     * Generate output plan KLC-planning validator formatted.
     *
     * @param currentTestPath the current sub dir to test
     */
    private void generateValOutputPlans(String currentTestPath) {
        Tools.cleanValPlan(currentTestPath);
        final ProblemFactory factory = new ProblemFactory();
        String currentDomain = currentTestPath + Tools.PDDL_DOMAIN;
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

        System.out.println("HSPTest: Test HSP planner on " + currentTestPath);
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
                currentDomain = currentTestPath + problemFile.split(".p")[0] + "-" + Tools.PDDL_DOMAIN;
            }
            // Parses the PDDL domain and problem description
            try {
                factory.setTraceLevel(TRACE_LEVEL);

                ErrorManager errorManager = factory.parse(new File(currentDomain), new File(currentProblem));
                if (!errorManager.isEmpty()) {
                    errorManager.printAll();
                }
                Assert.assertTrue(errorManager.getMessages(Message.Type.LEXICAL_ERROR).isEmpty());
                Assert.assertTrue(errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty());

                Problem pb = null;
                Plan plan = null;
                // Encodes and instantiates the problem in a compact representation
                System.out.println("* Encoding [" + currentProblem + "]" + "...");
                try {
                    pb = factory.encode();
                    if (pb.isSolvable()) {
                        // Searches for a solution plan
                        System.out.println("* Trying to solve [" + currentProblem + "]"
                            + " in " + TIMEOUT + " seconds");
                        plan = planner.search(pb);
                    } else {
                        System.err.println("* PDDLProblem [" + currentProblem + "]" + " not solvable.");
                    }
                    if (plan == null) { // no solution in TIMEOUT computation time
                        System.out.println("* No solution found in " + TIMEOUT + " seconds for " + currentProblem);
                        break;
                    } else if (plan.isEmpty()) { // Empty solution
                        System.out.println("* Empty solution for " + currentProblem);
                    } else { // Save output plan
                        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(currentProblem.substring(0,
                            currentProblem.length() - Tools.PDDL_EXT.length()) + Tools.VAL_EXT))) {
                            bw.write(pb.toString(plan));
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
