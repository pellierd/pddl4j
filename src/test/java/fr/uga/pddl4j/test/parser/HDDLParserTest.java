/*
 * Copyright (c) 2016 by Cedric Gerard <cedric.gerard@yeastlab.fr>.
 *
 * This file is part of PDDL4J library tests.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.test.parser;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.parser.PDDLParser;
import fr.uga.pddl4j.test.Tools;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

/**
 * This class implements the junit test of the pddl parser of the library on HDDL IPC benchmarks. The IPC
 * benchmarks used for testing are available in <code>test/ressources/benchmarks</code> directory.
 *
 *
 * @author D. Pellier
 * @version 1.0 - 19.10.2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HDDLParserTest {

    /**
     * Method that executes tests using IPC 2020 Barman HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_Barman() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/barman" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Childsnack HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_Childsnack() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/childsnack" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Gripper HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_Gripper() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/gripper" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Miconic HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_Miconic() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/miconic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Rover HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_Rover() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/rover" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Satellite HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_Satellite() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/satellite" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Smartphone HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_Smartphone() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/smartphone" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Transport HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_Transport() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/transport" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 UMTranslog HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_UMTranslog() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/umtranslog" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Woodworking HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_Woodworking() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/woodworking" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Zenotravel HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2020_HDDL_Zenotravel() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/zenotravel" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.parse(localTestPath, Tools.HDDL_EXT);
    }

}
