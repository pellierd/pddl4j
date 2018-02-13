package fr.uga.pddl4j.test.planner.ehc;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.encoding.JsonAdapter;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.ehc.EHC;
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
import java.util.stream.Stream;

/**
 * Implements the <tt>EHCTest</tt> of the PDD4L library. The planner accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 * <p>This class will test the planner on benchmark domain and problem from International planning contest.
 * The goal here is to test the PDDL4J 3.0 plan using all the file used in the competition and
 * KCL-Planning validator: https://github.com/KCL-Planning/VAL</p>
 *
 * <p>Note that IPC benchmark files are note delivered with the source code because of their 3GB size.
 * It suppose benchmark directory is a the root of your project.
 * If no test files are provided all test will pass the validation.</p>
 *
 * @author Emmanuel Hermellin
 * @author Cédric Gerard
 * @version 0.1 - 13.02.18
 */
public class EHCTest {

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
    private static final int TIMEOUT = 10;

    /**
     * Default Trace level.
     */
    private static final int TRACE_LEVEL = 0;

    /**
     * Default statistics computation.
     */
    private static final boolean STATISTICS = false;

    /**
     * The FF planner reference.
     */
    private EHC planner = null;


    /**
     * Test initialization.
     */
    @Before
    public void initTest() {
        // Creates the planner
        planner = new EHC();
        planner.setTimeOut(TIMEOUT);
        planner.setTraceLevel(TRACE_LEVEL);
        planner.setSaveState(STATISTICS);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC1 gripper tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC1_gripper() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "gripper"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC1 logistics tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC1_logistics() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "logistics"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC1 movie tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC1_movie() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "movie"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC1 mprime tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_ICP1_mprime() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "mprime"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC1 mystery tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC1_mystery() throws Exception {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "mystery"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC2 blocksworld tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC2_blocksworld() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "blocksworld"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC2 elevator tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC2_elevator() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "elevator"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC2 freecell tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC2_freecell() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "freecell"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC2 schedule tests
     *
     * @throws Exception if something went wrong
     */
    //@Test
    public void testFF_IPC2_schedule() throws Exception {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "schedule"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC3 depots tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC3_depots() throws Exception {
        String localTestPath = BENCH_DIR + "ipc3"
            + File.separator + "depot"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC3 driverlog tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC3_driverlog() throws Exception {
        String localTestPath = BENCH_DIR + "ipc3"
            + File.separator + "driverlog"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC3 rover tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC3_rover() throws Exception {
        String localTestPath = BENCH_DIR + "ipc3"
            + File.separator + "rover"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }


    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC3 satellite tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC3_satellite() throws Exception {
        String localTestPath = BENCH_DIR + "ipc3"
            + File.separator + "satellite"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC3 zenotravel tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC3_zenotravel() throws Exception {
        String localTestPath = BENCH_DIR + "ipc3"
            + File.separator + "zenotravel"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC4 airport tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC4_airport() throws Exception {
        String localTestPath = BENCH_DIR + "ipc4"
            + File.separator + "airport"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC4 optical-telegraph tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC4_optical_telegraph() throws Exception {
        String localTestPath = BENCH_DIR + "ipc4"
            + File.separator + "optical-telegraph"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC4 philosophers tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC4_philosophers() throws Exception {
        String localTestPath = BENCH_DIR + "ipc4"
            + File.separator + "philosophers"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC4 pipeworld tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC4_pipeworld() throws Exception {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "pipeworld"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC4 psr tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC4_psr() throws Exception {
        String localTestPath = BENCH_DIR + "ipc4"
            + File.separator + "psr"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC5 openstacks tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC5_openstacks() throws Exception {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "openstacks"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC5 pathways tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC5_pathways() throws Exception {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "pathways"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC5 storage tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC5_storage() throws Exception {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "storage"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC5 tpp tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC5_tpp() throws Exception {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "tpp"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC5 truck tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC5_truck() throws Exception {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "truck"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC6 pegsol tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC6_pegsol() throws Exception {
        String localTestPath = BENCH_DIR + "ipc6"
            + File.separator + "pegsol"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC6 sokoban tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC6_sokoban() throws Exception {
        String localTestPath = BENCH_DIR + "ipc6"
            + File.separator + "sokoban"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC6 transport tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC6_transport() throws Exception {
        String localTestPath = BENCH_DIR + "ipc6"
            + File.separator + "transport"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC7 barman tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC7_barman() throws Exception {
        String localTestPath = BENCH_DIR + "ipc7"
            + File.separator + "barman"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC7 nomystery tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC7_nomystery() throws Exception {
        String localTestPath = BENCH_DIR + "ipc7"
            + File.separator + "nomystery"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC7 parking tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC7_parking() throws Exception {
        String localTestPath = BENCH_DIR + "ipc7"
            + File.separator + "parking"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC8 childsnack tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC8_childsnack() throws Exception {
        String localTestPath = BENCH_DIR + "ipc8"
            + File.separator + "childsnack"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC8 hiking tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC8_hiking() throws Exception {
        String localTestPath = BENCH_DIR + "ipc8"
            + File.separator + "hiking"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * IPC8 thoughtful tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_IPC8_thoughtful() throws Exception {
        String localTestPath = BENCH_DIR + "ipc8"
            + File.separator + "thoughtful"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * Other Depots tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_newTests_Depots() throws Exception {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "Depots"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * Other DriverLog tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_newTests_DriverLog() throws Exception {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "DriverLog"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * Other Freecell tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_newTests_Freecell() throws Exception {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "Freecell"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * Other Rover tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_newTests_Rover() throws Exception {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "Rover"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * Other Satellite tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_newTests_Satellite() throws Exception {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "Satellite"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the FF planner to test its output plan.
     * Other Zenotravel tests
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_newTests_Zenotravel() throws Exception {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "Zenotravel"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * test the FF JSON output method on Gripper p01 problem.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testFF_json_output_plan() throws Exception {

        final ProblemFactory factory = new ProblemFactory();
        String domainFile = "pddl/gripper/domain.pddl";
        String problemFile = "pddl/gripper/p01.pddl";
        String jsonPlan = "";

        ErrorManager errorManager = factory.parse(new File(domainFile), new File(problemFile));
        Assert.assertTrue(errorManager.isEmpty());

        CodedProblem pb = factory.encode();
        if (pb.isSolvable()) {
            Plan plan = planner.search(pb);
            JsonAdapter toJson = new JsonAdapter(pb);
            jsonPlan = toJson.toJsonString(plan);
        }

        Assert.assertFalse(jsonPlan == null);
        Assert.assertFalse(jsonPlan.contentEquals(""));
        Assert.assertTrue(jsonPlan.contentEquals(validGripperP01JSON));
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
            System.out.println("--");
            // Parses the PDDL domain and problem description
            try {
                factory.setTraceLevel(TRACE_LEVEL);

                ErrorManager errorManager = factory.parse(new File(currentDomain), new File(currentProblem));
                Assert.assertTrue(errorManager.isEmpty());

                CodedProblem pb = null;
                Plan plan = null;
                try {
                    // Encodes and instantiates the problem in a compact representation
                    System.out.println("Encoding [" + currentProblem + "]" + "...");
                    pb = factory.encode();
                    if (pb.isSolvable()) {
                        // Searches for a solution plan
                        System.out.println("Trying to solve [" + currentProblem + "]" + " in " + TIMEOUT + " seconds");
                        plan = planner.search(pb);
                    } else {
                        System.err.println("Problem [" + currentProblem + "]" + " not solvable.");
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
            System.out.println("--");
        }
    }

    /**
     * Clean all val formatted plan from the current directory and all its subdirectories.
     *
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


    // define valid JSON output on problem to check

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
