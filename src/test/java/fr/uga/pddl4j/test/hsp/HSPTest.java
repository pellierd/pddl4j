package fr.uga.pddl4j.test.hsp;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.hsp.HSP;
import fr.uga.pddl4j.test.Tools;
import fr.uga.pddl4j.util.Plan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implements the <tt>HSPTest</tt> of the PDD4L library. The planner accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 *
 * <p>
 * This class will test the planner on benchmark domain and problem from International planning contest.
 * The goal here is to test the PDDL4J 3.0 plan using all the file used in the competition and
 * KCL-Planning validator: https://github.com/KCL-Planning/VAL
 * </p>
 *
 * <p>
 * Note that IPC benchmark files are note delivered with the source code because of their 3GB size.
 * It suppose benchmark directory is a the root of your project.
 * If no test files are provided all test will pass the validation.
 * </p>
 *
 * @author Cédric Gerard
 * @version 0.1 - 23.06.16
 */
public class HSPTest {

    /**
     * The path of the benchmarks files.
     */
    private static final String BENCH_DIR = "benchmarks" + File.separator;

    /**
     * PDDL files extension.
     */
    private static final String PDDL_EXT = ".pddl";

    /**
     * PDDL4J output plan extension for KCL validator format.
     */
    private static final String PLAN_EXT = ".val";

    /**
     * The domain file name.
     */
    private static final String DOMAIN = "domain" + PDDL_EXT;

    /**
     * Computation timeout.
     */
    private static final int TIMEOUT = 3;

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
        planner = new HSP();
        planner.setTimeOut(TIMEOUT);
        planner.setTraceLevel(TRACE_LEVEL);
        planner.setSaveState(STATISTICS);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly adl tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_assembly_adl() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "assembly"
            + File.separator + "adl"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly grid strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_grid_strips_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "grid"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly gripper adl tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_gripper_adl() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "gripper"
            + File.separator + "adl"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly gripper strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_gripper_strips_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "gripper"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly logistics adl tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_logistics_adl() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "logistics"
            + File.separator + "adl"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly logistics strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_logistics_strips_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "logistics"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly logistics strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_logistics_strips_untyped_additional() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "logistics"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator + "additional"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly movie adl tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_movie_adl() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "movie"
            + File.separator + "adl"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly movie strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_movie_strips_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "movie"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly mprime adl tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_mprime_adl() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "mprime"
            + File.separator + "adl"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly mprime strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_mprime_strips_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "mprime"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly mprime strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_mprime_strips_untyped_additional() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "mprime"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator + "additional"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly mystery adl tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_mystery_adl() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "mystery"
            + File.separator + "adl"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 assembly mystery strips typed tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_mystery_strips_typed() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "mystery"
            + File.separator + "strips"
            + File.separator + "typed"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 blocksworld track1 strips typed tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_blocksworld_track1_strips_typed() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "blocksworld"
            + File.separator + "track1"
            + File.separator + "strips"
            + File.separator + "typed"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 blocksworld track1 strips typed tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_blocksworld_track1_strips_typed_additional() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "blocksworld"
            + File.separator + "track1"
            + File.separator + "strips"
            + File.separator + "typed"
            + File.separator + "additional"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 blocksworld track1 strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_blocksworld_track1_strips_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "blocksworld"
            + File.separator + "track1"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 blocksworld track1 strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_blocksworld_track1_strips_untyped_additional() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "blocksworld"
            + File.separator + "track1"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator + "additional"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 blocksworld track2 strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_blocksworld_track2_strips_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "blocksworld"
            + File.separator + "track2"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 blocksworld track2 strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_blocksworld_track2_strips_untyped_additional() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "blocksworld"
            + File.separator + "track2"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator + "additional"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 elevator adl full tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_elevator_adl_full() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "elevator"
            + File.separator + "adl"
            + File.separator + "full"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 elevator adl simple tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_elevator_adl_simple() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "elevator"
            + File.separator + "adl"
            + File.separator + "simple"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 freecell strips typed tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_freecell_strips_typed() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "freecell"
            + File.separator + "strips"
            + File.separator + "typed"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 freecell strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_freecell_strips_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "freecell"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 logistics track1 strips typed tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_logistics2_track1_strips_typed() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "logistics"
            + File.separator + "track1"
            + File.separator + "strips"
            + File.separator + "typed"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 logistics track1 strips typed tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_logistics2_track1_strips_typed_additional() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "logistics"
            + File.separator + "track1"
            + File.separator + "strips"
            + File.separator + "typed"
            + File.separator + "additional"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 logistics track1 strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_logistics2_track1_strips_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "logistics"
            + File.separator + "track1"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 logistics track1 strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_logistics2_track1_strips_untyped_additional() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "logistics"
            + File.separator + "track1"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator + "additional"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 logistics track2 strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_logistics2_track2_strips_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "logistics"
            + File.separator + "track2"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 logistics track2 strips untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_logistics2_track2_strips_untyped_additional() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "logistics"
            + File.separator + "track2"
            + File.separator + "strips"
            + File.separator + "untyped"
            + File.separator + "additional"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 schedule adl typed tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_schedule_adl_typed() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "schedule"
            + File.separator + "adl"
            + File.separator + "typed"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 schedule adl untyped tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_schedule_adl_untyped() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "schedule"
            + File.separator + "adl"
            + File.separator + "untyped"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 schedule strips tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_schedule_strips() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "schedule"
            + File.separator + "strips"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * All IPC3 problem are run
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_IPC3() throws Exception {
        String localTestPath = BENCH_DIR + "ipc3" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC3 test skipped !");
            return;
        }

        ArrayList<String> directories = findSubDir(localTestPath).collect(Collectors.toCollection(ArrayList::new));
        directories.forEach(this::generateValOutputPlans);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * All IPC4 problem are run
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_IPC4() throws Exception {
        String localTestPath = BENCH_DIR + "ipc4" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC3 test skipped !");
            return;
        }

        ArrayList<String> directories = findSubDir(localTestPath).collect(Collectors.toCollection(ArrayList::new));
        directories.forEach(this::generateValOutputPlans);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * All IPC5 problem are run
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_IPC5() throws Exception {
        String localTestPath = BENCH_DIR + "ipc5" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC3 test skipped !");
            return;
        }

        ArrayList<String> directories = findSubDir(localTestPath).collect(Collectors.toCollection(ArrayList::new));
        directories.forEach(this::generateValOutputPlans);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * All IPC6 problem are run
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_IPC6() throws Exception {
        String localTestPath = BENCH_DIR + "ipc6" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC3 test skipped !");
            return;
        }

        ArrayList<String> directories = findSubDir(localTestPath).collect(Collectors.toCollection(ArrayList::new));
        directories.forEach(this::generateValOutputPlans);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * All IPC7 problem are run
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_IPC7() throws Exception {
        String localTestPath = BENCH_DIR + "ipc7" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC3 test skipped !");
            return;
        }

        ArrayList<String> directories = findSubDir(localTestPath).collect(Collectors.toCollection(ArrayList::new));
        directories.forEach(this::generateValOutputPlans);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * All IPC8 problem are run
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_IPC8() throws Exception {
        String localTestPath = BENCH_DIR + "ipc8" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC3 test skipped !");
            return;
        }

        ArrayList<String> directories = findSubDir(localTestPath).collect(Collectors.toCollection(ArrayList::new));
        directories.forEach(this::generateValOutputPlans);
    }

    /**
     * Generate output plan KLC-planning validator formatted.
     *
     * @param currentTestPath the current sub dir to test
     */
    private void generateValOutputPlans(String currentTestPath) {
        cleanValPlan(currentTestPath);
        final ProblemFactory factory = new ProblemFactory();
        String currentDomain = currentTestPath + DOMAIN;
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

        // Loop around problems in one category
        for (int i = 1; i < nbTest + 1; i++) {
            if (i < 10) {
                problemFile = "p0" + i + PDDL_EXT;
            } else {
                problemFile = "p" + i + PDDL_EXT;
            }

            currentProblem = currentTestPath + problemFile;

            if (oneDomainPerProblem) {
                currentDomain = currentTestPath + problemFile.split(".p")[0] + "-" + DOMAIN;
            }

            // Parses the PDDL domain and problem description
            try {
                factory.setTraceLevel(TRACE_LEVEL);
                ErrorManager errorManager = factory.parse(new File(currentDomain), new File(currentProblem));
                Assert.assertTrue(errorManager.isEmpty());

                final CodedProblem pb;
                Plan plan;
                try {
                    // Encodes and instantiates the problem in a compact representation
                    System.out.println("encoding [" + currentProblem + "]" + "...");
                    pb = factory.encode();
                    Assert.assertTrue(pb.isSolvable());
                    // Searches for a solution plan
                    System.out.println("trying to solve [" + currentProblem + "]" + " in " + TIMEOUT + " seconds");
                    plan = planner.search(pb);
                } catch (OutOfMemoryError err) {
                    System.out.println("ERR: " + err.getMessage() + " - test aborted");
                    return;
                }

                if (plan == null) { // no solution in TIMEOUT computation time
                    System.out.println("No solution found in " + TIMEOUT + " seconds for " + currentProblem);
                } else if (plan.isEmpty()) { // Empty solution
                    System.out.println("Empty solution for " + currentProblem);
                } else { // Save output plan
                    try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(currentProblem.substring(0,
                        currentProblem.length() - PDDL_EXT.length()) + PLAN_EXT))) {
                        bw.write(pb.toString(plan));
                    }
                    System.out.println("Solution found for " + currentProblem);
                }

            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }
    }

    /**
     * Find sub directories from a specific path.
     *
     * @param localTestPath the local path where to start discovering sub directories
     * @return all sub directories path as a stream of String
     */
    private Stream<String> findSubDir(String localTestPath) {

        // Go into subdirectories
        Stream<String> results =
            Stream.of(new File(localTestPath).list((dir, name) -> new File(localTestPath + name).isDirectory()))
                .map((subDir) -> localTestPath + subDir + File.separator)
                .flatMap(this::findSubDir);

        // Validate current tests if any and returns errors from all tests that failed
        return Stream.concat(Stream.of(localTestPath), results);
    }

    /**
     * Clean all val formatted plan from the current directory and all its subdirectories.
     * @param localTestPath the current path to clean up
     */
    private void cleanValPlan(String localTestPath) {

        // Go into subdirectories
        Stream<String> results =
            Stream.of(new File(localTestPath).list((dir, name) -> new File(localTestPath + name).isDirectory()))
                .map((subDir) -> localTestPath + subDir + File.separator);

        results.forEach(this::cleanValPlan);

        // Counting the number of val files
        File[] valFileList = new File(localTestPath)
            .listFiles((dir, name) -> name.startsWith("p") && name.endsWith(".val") && !name.contains("dom"));

        if (valFileList != null) {
            String valFile;
            // Loop around problems in one category
            for (int i = 1; i < valFileList.length + 1; i++) {
                if (i < 10) {
                    valFile = "p0" + i + PLAN_EXT;
                } else {
                    valFile = "p" + i + PLAN_EXT;
                }
                try {
                    Files.deleteIfExists(FileSystems.getDefault().getPath(localTestPath, valFile));
                    System.out.println("Deleting " + localTestPath + valFile);
                } catch (IOException ioEx) {
                    ioEx.printStackTrace();
                }
            }
        }
    }

}
