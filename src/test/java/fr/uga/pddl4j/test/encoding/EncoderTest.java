package fr.uga.pddl4j.test.encoding;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.test.Tools;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Implements the <tt>EncoderTest</tt> of the PDD4L library.
 *
 * @author Cédric Gerard
 * @version 0.1 - 04.07.16
 */
public class EncoderTest {

    /**
     * The path of the benchmarks files.
     */
    private static final String BENCH_DIR = "benchmarks" + File.separator;

    /**
     * PDDL files extension.
     */
    private static final String PDDL_EXT = ".pddl";

    /**
     * The domain file name.
     */
    private static final String DOMAIN = "domain" + PDDL_EXT;

    /**
     * Default Trace level.
     */
    private static final int TRACE_LEVEL = 0;


    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC1 gripper tests
     */
    @Test
    public void testEncode_IPC1_gripper() {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "gripper"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC1 logistics tests
     */
    @Test
    public void testEncode_IPC1_logistics() {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "logistics"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC1 movie tests
     */
    @Test
    public void testEncode_IPC1_movie() {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "movie"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC1 mprime tests
     */
    @Test
    public void testEncode_ICP1_mprime() {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "mprime"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC1 mystery tests
     */
    @Test
    public void testEncode_IPC1_mystery() {
        String localTestPath = BENCH_DIR + "ipc1"
            + File.separator + "mystery"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }


    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC2 blocksworld tests
     */
    @Test
    public void testEncode_IPC2_blocksworld() {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "blocksworld"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC2 elevator tests
     */
    @Test
    public void testEncode_IPC2_elevator() {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "elevator"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC2 freecell tests
     */
    @Test
    public void testEncode_IPC2_freecell() {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "freecell"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC2 schedule tests
     * TODO test running with GC overhead errors
     *
     * @if something went wrong
     */
    //@Test
    public void testEncode_IPC2_schedule() {
        String localTestPath = BENCH_DIR + "ipc2"
            + File.separator + "schedule"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC3 depots tests
     */
    @Test
    public void testEncode_IPC3_depots() {
        String localTestPath = BENCH_DIR + "ipc3"
            + File.separator + "depots"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC3 driverlog tests
     */
    @Test
    public void testEncode_IPC3_driverlog() {
        String localTestPath = BENCH_DIR + "ipc3"
            + File.separator + "driverlog"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC3 rover tests
     */
    @Test
    public void testEncode_IPC3_rover() {
        String localTestPath = BENCH_DIR + "ipc3"
            + File.separator + "rover"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC3 satellite tests
     */
    @Test
    public void testEncode_IPC3_satellite() {
        String localTestPath = BENCH_DIR + "ipc3"
            + File.separator + "satellite"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC3 zenotravel tests
     */
    @Test
    public void testEncode_IPC3_zenotravel() {
        String localTestPath = BENCH_DIR + "ipc3"
            + File.separator + "zenotravel"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC4 airport tests
     */
    @Test
    public void testEncode_IPC4_airport() {
        String localTestPath = BENCH_DIR + "ipc4"
            + File.separator + "airport"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC4 optical-telegraph tests
     */
    @Test
    public void testEncode_IPC4_optical_telegraph() {
        String localTestPath = BENCH_DIR + "ipc4"
            + File.separator + "optical-telegraph"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC4 philosophers tests
     */
    @Test
    public void testEncode_IPC4_philosophers() {
        String localTestPath = BENCH_DIR + "ipc4"
            + File.separator + "philosophers"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC4 pipesworld tests
     */
    @Test
    public void testEncode_IPC4_pipesworld() {
        String localTestPath = BENCH_DIR + "ipc4"
            + File.separator + "pipesworld"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC4 psr tests
     */
    @Test
    public void testEncode_IPC4_psr() {
        String localTestPath = BENCH_DIR + "ipc4"
            + File.separator + "psr"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC5 openstacks tests
     */
    @Test
    public void testEncode_IPC5_openstacks() {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "openstacks"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC5 pathways tests
     */
    @Test
    public void testEncode_IPC5_pathways() {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "pathways"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC5 storage tests
     */
    @Test
    public void testEncode_IPC5_storage() {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "storage"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC5 tpp tests
     */
    @Test
    public void testEncode_IPC5_tpp() {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "tpp"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC5 truck tests
     */
    @Test
    public void testEncode_IPC5_truck() {
        String localTestPath = BENCH_DIR + "ipc5"
            + File.separator + "truck"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC6 pegsol tests
     */
    @Test
    public void testEncode_IPC6_pegsol() {
        String localTestPath = BENCH_DIR + "ipc6"
            + File.separator + "pegsol"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC6 sokoban tests
     */
    @Test
    public void testEncode_IPC6_sokoban() {
        String localTestPath = BENCH_DIR + "ipc6"
            + File.separator + "sokoban"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC6 transport tests
     */
    @Test
    public void testEncode_IPC6_transport() {
        String localTestPath = BENCH_DIR + "ipc6"
            + File.separator + "transport"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC7 barman tests
     */
    @Test
    public void testEncode_IPC7_barman() {
        String localTestPath = BENCH_DIR + "ipc7"
            + File.separator + "barman"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC7 nomystery tests
     */
    @Test
    public void testEncode_IPC7_nomystery() {
        String localTestPath = BENCH_DIR + "ipc7"
            + File.separator + "nomystery"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC7 parking tests
     */
    @Test
    public void testEncode_IPC7_parking() {
        String localTestPath = BENCH_DIR + "ipc7"
            + File.separator + "parking"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC8 childsnack tests
     */
    @Test
    public void testEncode_IPC8_childsnack() {
        String localTestPath = BENCH_DIR + "ipc8"
            + File.separator + "childsnack"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC8 hiking tests
     */
    @Test
    public void testEncode_IPC8_hiking() {
        String localTestPath = BENCH_DIR + "ipc8"
            + File.separator + "hiking"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * IPC8 thoughtful tests
     */
    //@Test TODO to long: 19hours on Jenkins to be completed with Java heap space error
    public void testEncode_IPC8_thoughtful() {
        String localTestPath = BENCH_DIR + "ipc8"
            + File.separator + "thoughtful"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * newTests Depots tests
     */
    @Test
    public void testEncode_newTests_Depots() {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "Depots"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * newTests DriverLog tests
     */
    @Test
    public void testEncode_newTests_DriverLog() {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "DriverLog"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * newTests Freecell tests
     */
    @Test
    public void testEncode_newTests_Freecell() {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "Freecell"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * newTests Rover tests
     */
    @Test
    public void testEncode_newTests_Rover() {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "Rover"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * newTests Satellite tests
     */
    @Test
    public void testEncode_newTests_Satellite() {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "Satellite"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }

    /**
     * Method that executes benchmarks on ADL IPC problem to test encoding.
     * newTests Zenotravel tests
     */
    @Test
    public void testEncode_newTests_Zenotravel() {
        String localTestPath = BENCH_DIR + "newTests"
            + File.separator + "Zenotravel"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        encodeProblems(localTestPath);
    }


    /**
     * Encode problems targeted in currentTestPath directory and check if they are solvable.
     *
     * @param currentTestPath the current directory to test
     */
    private void encodeProblems(String currentTestPath) {
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
                try {
                    // Encodes and instantiates the problem in a compact representation
                    System.out.println("encoding [" + currentProblem + "]" + "...");
                    pb = factory.encode();
                    Assert.assertTrue(pb != null);
                    if (pb.isSolvable()) {
                        System.out.println("Problem encoded and is solvable.");
                    } else {
                        System.out.println("Problem encoded and is  not solvable.");
                    }
                } catch (OutOfMemoryError err) {
                    System.err.println("ERR: " + err.getMessage() + " - test aborted");
                    return;
                } catch (IllegalArgumentException iaex) {
                    if (iaex.getMessage().equalsIgnoreCase("problem to encode not ADL")) {
                        System.err.println("[" + currentProblem + "]: Not ADL problem!");
                    } else {
                        throw iaex;
                    }
                }

            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }
    }

}
