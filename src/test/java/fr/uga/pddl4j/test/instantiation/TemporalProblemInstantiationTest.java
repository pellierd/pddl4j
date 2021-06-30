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

package fr.uga.pddl4j.test.instantiation;

import fr.uga.pddl4j.test.Tools;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;

/**
 * The class test the instantiation process for temporal problem on IPC benchmarks. The IPC
 * benchmarks used for testing are available in <code>test/ressources/benchmarks</code> directory.
 *
 * @author D. Pellier
 * @version 1.0 - 20.10.2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TemporalProblemInstantiationTest {

    /**
     * Method that executes tests using IPC 2002 depots time automatic benchmarks.
     * Failure p22
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Depots_Time_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/depots/time-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 depots time hand coded benchmarks.
     * Failure p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Depots_Time_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/depots/time-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 depots time simple automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Depots_Time_Simple_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/depots/time-simple-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 depots time hand coded benchmarks.
     * Failure p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Depots_Time_Simple_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/depots/time-simple-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 driverlog time automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Driverlog_Time_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/driverlog/time-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 driverlog time hand coded benchmarks.
     * Failure p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Driverlog_Time_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/driverlog/time-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 driverlog time simple automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Driverlog_Time_Simple_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/driverlog/time-simple-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 driverlog time hand coded benchmarks.
     * Failure p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Driverlog_Time_Simple_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/driverlog/time-simple-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Rovers time automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Rovers_Time_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/time-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Rover time hand coded benchmarks.
     * Failure p08
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Rovers_Time_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/time-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Rovers time simple automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Rovers_Time_Simple_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/time-simple-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Rovers time hand coded benchmarks.
     * Failure p08
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Rovers_Time_Simple_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/time-simple-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Satellite time automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Satellite_Time_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/time-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Satellite time hand coded benchmarks.
     * Failure: p09
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Satellite_Time_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/time-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Satellite time simple automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Satellite_Time_Simple_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/time-simple-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Satellite time simple hand coded benchmarks.
     * Failure: p09
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Satellite_Time_Simple_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/time-simple-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Zenotravel time automatic benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Zenotravel_Time_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/time-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Zenotravel time hand coded benchmarks.
     * Failure: p20
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Zenotravel_Time_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/time-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Zenotravel time simple automatic coded benchmarks.
     * Failure: p16
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Zenotravel_Time_Simple_Automatic() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/time-simple-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2002 Zenotravel time simple hand coded coded benchmarks.
     * Failure: p10
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2002_Zenotravel_Time_Simple_Hand_Coded() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/time-simple-hand-coded"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 rover time hand coded benchmarks.
     * Failure p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Airport_Temporal_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/temporal-adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 rover time hand coded benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Airport_Temporal_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/temporal-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Airport temporal time windows ADL benchmarks.
     * Failure: Initial Time in problem not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Airport_Temporal_Time_Windows_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/temporal-time-windows-adl"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Airport temporal time windows compiled ADL benchmarks.
     * Failure p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Airport_Temporal_Time_Windows_Compiled_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/temporal-time-windows-compiled-adl"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Airport temporal time windows compiled STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Airport_Temporal_Time_Windows_Compiled_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/temporal-time-windows-compiled-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Airport temporal time windows STRIPS benchmarks.
     * Failure: Initial Time in problem not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Airport_Temporal_Time_Windows_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/temporal-time-windows-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Pipesworld no tankage temporal deadlines compiled STRIPS benchmarks.
     * Failure p10
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Pipesworld_No_Tankage_Temporal_Deadlines_Compiled_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR
            + "ipc2004/pipesworld/no-tankage-temporal-deadlines-compiled-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Pipesworld no tankage temporal deadlines STRIPS benchmarks.
     * Failure: Initial Time in problem not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Pipesworld_No_Tankage_Temporal_Deadlines_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/no-tankage-temporal-deadlines-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Pipesworld no tankage temporal STRIPS benchmarks.
     * Failure: p10
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Pipesworld_No_Tankage_Temporal_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/no-tankage-temporal-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Pipesworld tankage temporal STRIPS benchmarks.
     * Failure: p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Pipesworld_Tankage_Temporal_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/tankage-temporal-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Satellite time STRIPS benchmarks.
     * Failure: p29
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Satellite_Time_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/satellite/time-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Satellite time time windows compiled STRIPS benchmarks.
     * Failure: p29
     * p10 has initial time literal. The timed literal was commented.
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Satellite_Time_Time_Windows_Compiled_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/satellite/time-time-windows-compiled-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 Satellite time time windows STRIPS benchmarks.
     * Failure: Initial Time in problem not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_Satellite_Time_Time_Windows_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/satellite/time-time-windows-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 UMTS flaw temporal STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_UMTS_Flaw_Temporal_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/umts/flaw-temporal-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 UMTS flaw temporal time windows compiled STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_UMTS_Flaw_Temporal_Time_Windows_Compiled_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/umts/flaw-temporal-time-windows-compiled-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 UMTS flaw temporal time windows STRIPS benchmarks.
     * Failure: Initial Time in problem not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_UMTS_Flaw_Temporal_Time_Windows_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/umts/flaw-temporal-time-windows-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 UMTS temporal time windows compiled STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_UMTS_Temporal_Time_Windows_Compiled_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/umts/temporal-time-windows-compiled-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2004 UMTS temporal time windows STRIPS benchmarks.
     * Failure: Initial Time in problem not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2004_UMTS_Temporal_Time_Windows_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/umts/temporal-time-windows-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Openstacks metric time  benchmarks.
     * Failure: p03
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Openstacks_Metric_Time() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/openstacks/metric-time"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Openstacks metric time STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Openstacks_Metric_Time_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/openstacks/metric-time-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Openstacks time benchmarks.
     * Failure: p03
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Openstacks_Time() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/openstacks/time" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Openstacks time STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Openstacks_Time_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/openstacks/time-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Pathways metric time benchmarks.
     * Failure: p04
     * @throws Exception if something went wrong.
     */
    /*Test
    public void test_Instantiation_IPC2006_Pathways_Metric_Time() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/pathways/metric-time" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Pipesworld metric time benchmarks.
     * Failure: p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Pipesworld_Metric_Time() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/pipesworld/metric-time" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Pipesworld metric time constraints benchmarks.
     * Failure: Constraints not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Pipesworld_Metric_Time_Constraints() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/pipesworld/metric-time-constraints"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Rovers metric time benchmarks.
     * Failure: p21
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Rovers_Metric_Time() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/rovers/metric-time" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Storage time benchmarks.
     * Failure: p20
     * @throws Exception if something went wrong.
     */
    /*Test
    public void test_Instantiation_IPC2006_Storage_Time() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/storage/time" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Storage time constraints benchmarks.
     * Failure: Constraints not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Storage_Time_Constraints() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/storage/time-constraints" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 TPP metric time benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_TPP_Metric_Time() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/tpp/metric-time" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 TPP metric time constraints benchmarks.
     * Failure: Constraints not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_TPP_Metric_Time_Constraints() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/tpp/metric-time-constraints" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Trucks time benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Trucks_Time() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/trucks/time" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Trucks time constraints benchmarks.
     * Failure: Constraints not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Trucks_Time_Constraints() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/trucks/time-constraints" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Trucks time constraints timed initial literals benchmarks.
     * Failure: Timed initial literal not supported
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Trucks_Time_Constraints_Timed_Initial_Literals() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/trucks/time-constraints-timed-initial-literals"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2006 Trucks time STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2006_Trucks_Time_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/trucks/time-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Crew-Planing temporal satisficing STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Crew_Planning_Temporal_Satisficing_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/crew-planning/temporal-satisficing-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Elevator temporal satisficing numeric fluents benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Elevator_Temporal_Satisficing_Numeric_Fluents() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/elevator/temporal-satisficing-numeric-fluents"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Elevator temporal satisficing STRIPS benchmarks.
     * Failure: p13
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Elevator_Temporal_Satisficing_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/elevator/temporal-satisficing-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Model-Train temporal satisficing numeric fluents benchmarks.
     * Failure: p07
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Model_Train_Temporal_Satisficing_Numeric_Fluents() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/model-train/temporal-satisficing-numeric-fluents"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Openstacks temporal satisficing ADL benchmarks.
     * Failure: p13
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Openstacks_Temporal_Satisficing_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/openstacks/temporal-satisficing-adl"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Openstacks temporal satisficing ADL numeric fluents benchmarks.
     * Failure: p14
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Openstacks_Temporal_Satisficing_ADL_Numeric_Fluents() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR
            + "ipc2008/openstacks/temporal-satisficing-adl-numeric-fluents" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Openstacks temporal satisficing numeric fluents benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Openstacks_Temporal_Satisficing_Numeric_Fluents() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/openstacks/temporal-satisficing-numeric-fluents"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Openstacks temporal satisficing STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Openstacks_Temporal_Satisficing_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/openstacks/temporal-satisficing-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Parc-Printer temporal satisficing STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Parc_Printer_Temporal_Satisficing_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/parc-printer/temporal-satisficing-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Peg Solitaire temporal satisficing STRIPS benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Peg_Solitaire_Temporal_Satisficing_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/peg-solitaire/temporal-satisficing-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Transport temporal satisficing numeric fluents benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Transport_Temporal_Satisficing_Numeric_Fluents() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/transport/temporal-satisficing-numeric-fluents"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2008 Woodworking temporal satisficing numeric fluents benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Woodworking_Temporal_Satisficing_Numeric_Fluents() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2008/woodworking/temporal-satisficing-numeric-fluents"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Crew-Planing temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Crew_Planning_Temporal_Satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/crew-planning/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Elevator temporal satisficing benchmarks.
     * Failure: p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Elevator_Temporal_Satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/elevator/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Floor-tile temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Floor_Tile_Temporal_Satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/floor-tile/temporal-satisficing" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Match Cellar temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2008_Match_Cellar_Temporal_Satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/match-cellar/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Openstacks temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2011_Openstacks_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/openstacks/temporal-satisficing" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Parc Printer temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2011_Parc_Printer_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/parc-printer/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Parking temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2011_Parking_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/parking/temporal-satisficing" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Peg Solitaire temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2011_Peg_Solitaire_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/peg-solitaire/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Sokoban temporal satisficing benchmarks.
     * Failure: p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2011_Sokoban_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/sokoban/temporal-satisficing" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Temporal Machine Shop temporal satisficing benchmarks.
     * Failure: p18
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2011_Temporal_Machine_Shop_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/temporal-machine-shop/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2011 Turn and Open temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2011_Turn_And_Open_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2011/turn-and-open/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2014 Driver Log temporal satisficing benchmarks.
     * Failure: p05
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2014_Driver_Log_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2014/driver-log/temporal-satisficing" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2014 Floor Tile temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2014_Floor_Tile_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2014/floor-tile/temporal-satisficing" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2014 Map Analyser temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2014_Map_Analyser_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2014/map-analyser/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2014 Match Cellar temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2014_Math_Cellar_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2014/match-cellar/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2014 Parking temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2014_Parking_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2014/parking/temporal-satisficing" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2014 Satellite temporal satisficing benchmarks.
     * Failure: p20
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2014_Satellite_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2014/satellite/temporal-satisficing" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2014 Storage temporal satisficing benchmarks.
     * OK
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2014_Storage_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2014/storage/temporal-satisficing" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2014 Temporal Machine Shop temporal satisficing benchmarks.
     * Failure: p13
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2014_Temporal_Machine_Shop_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2014/temporal-machine-shop/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2014 Road Traffic accident Management temporal satisficing benchmarks.
     * Failure: p01
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2014_Road_Traffic_Accident_Management_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR
            + "ipc2014/road-traffic-accident-management/temporal-satisficing" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2014 Turn and Open temporal satisficing benchmarks.
     * Failure: p17
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2014_Turn_And_Open_Temporal_satisficing() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2014/turn-and-open/temporal-satisficing"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.PDDL_EXT);
    }

}
