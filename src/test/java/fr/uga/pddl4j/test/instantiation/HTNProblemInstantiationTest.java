package fr.uga.pddl4j.test.instantiation;

import fr.uga.pddl4j.test.Tools;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;

/**
 * The class test the instantiation process for HTN problem on IPC benchmarks. The IPC
 * benchmarks used for testing are available in <code>test/ressources/benchmarks</code> directory.
 *
 * @author D. Pellier
 * @version 1.0 - 19.10.20
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HTNProblemInstantiationTest {

    /**
     * Method that executes tests using IPC 2020 Barman HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2020_HDDL_Barman() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/barman" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Childsnack HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_Instantiation_IPC2020_HDDL_Childsnack() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/childsnack" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, HDDLEncoderTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 Gripper HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2020_HDDL_Gripper() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/gripper" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Miconic HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2020_HDDL_Miconic() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/miconic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Rover HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2020_HDDL_Rover() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/rover" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Satellite HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2020_HDDL_Satellite() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/satellite" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Smartphone HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2020_HDDL_Smartphone() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/smartphone" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Transport HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2020_HDDL_Transport() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/transport" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 UMTranslog HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2020_HDDL_UMTranslog() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/umtranslog" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Woodworking HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2020_HDDL_Woodworking() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/woodworking" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.HDDL_EXT);
    }

    /**
     * Method that executes tests using IPC 2020 Zenotravel HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Instantiation_IPC2020_HDDL_Zenotravel() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/zenotravel" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.instantiate(localTestPath, Tools.HDDL_EXT);
    }
}
