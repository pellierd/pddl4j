package fr.uga.pddl4j.test.instantiation;

import fr.uga.pddl4j.test.Tools;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;

/**
 * Implements the <tt>HDDLEncoderTest</tt> of the PDD4L library. The class implements the test of the encoder on IPC
 * benchmarks.
 *
 * @author D. Pellier
 * @version 1.0 - 19.10.20
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HTNProblemTest {

    /**
     * Default Trace level.
     */
    private static final int TRACE_LEVEL = 0;

    /**
     * Method that executes tests using IPC 2020 Barman HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Encoder_IPC2020_HDDL_Barman() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/barman" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HTNProblemTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 Childsnack HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    /*@Test
    public void test_Encoder_IPC2020_HDDL_Childsnack() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/childsnack" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HDDLEncoderTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 Gripper HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Encoder_IPC2020_HDDL_Gripper() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/gripper" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HTNProblemTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 Miconic HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Encoder_IPC2020_HDDL_Miconic() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/miconic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HTNProblemTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 Rover HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Encoder_IPC2020_HDDL_Rover() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/rover" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HTNProblemTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 Satellite HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Encoder_IPC2020_HDDL_Satellite() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/satellite" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HTNProblemTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 Smartphone HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Encoder_IPC2020_HDDL_Smartphone() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/smartphone" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HTNProblemTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 Transport HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Encoder_IPC2020_HDDL_Transport() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/transport" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HTNProblemTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 UMTranslog HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Encoder_IPC2020_HDDL_UMTranslog() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/umtranslog" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HTNProblemTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 Woodworking HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Encoder_IPC2020_HDDL_Woodworking() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/woodworking" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HTNProblemTest.TRACE_LEVEL);
    }

    /**
     * Method that executes tests using IPC 2020 Zenotravel HDDL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Encoder_IPC2020_HDDL_Zenotravel() throws Exception {
        final String localTestPath = Tools.HDDL_BENCH_DIR + "ipc2020/zenotravel" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.encodeHDDLProblems(localTestPath, HTNProblemTest.TRACE_LEVEL);
    }
}
