package fr.uga.pddl4j.test.planners.sat;

import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.sat.AbstractSATPlanner;
import fr.uga.pddl4j.test.Tools;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Implements the <tt>SATTest</tt> of the PDDL4J library.
 */
public class SATTest {
    private static final int TIMEOUT = 10;
    private static final String SAT_ENCODING = "DEFAULT";
    private static final String SAT_SOLVER = "MERGESAT";
    private static final int MAX_PLAN_LENGTH = 1000;
    private PlannerConfiguration config;

    @Before
    public void initTest() {
        config = AbstractSATPlanner.getDefaultConfiguration();
        config.setProperty(AbstractSATPlanner.TIME_OUT_SETTING, TIMEOUT);
        config.setProperty(AbstractSATPlanner.SAT_ENCODING_SETTING, SAT_ENCODING);
        config.setProperty(AbstractSATPlanner.SAT_SOLVER_SETTING, SAT_SOLVER);
        config.setProperty(AbstractSATPlanner.MAX_PLAN_LENGTH_SETTING, MAX_PLAN_LENGTH);
        Tools.changeVALPerm();
    }

    /*
    @Test
    public void simpleSATTest() {
        for (int i = 0; i < 4; i++) {
            final String localTestPath = "src/test/java/fr/uga/pddl4j/test/planners/sat/examples/example" + i + File.separator;
            Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
                Tools.isBenchmarkExist(localTestPath));
            Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, config);
        }
    }

    @Test
    public void encodingToStringTest() {
        final String localTestPath = "src/test/java/fr/uga/pddl4j/test/planners/sat/examples/example0";

        DefaultSATEncoding defaultSATEncoding = new DefaultSATEncoding();
        Parser parser = new Parser();
        DefaultParsedProblem parsedProblem;
        try {
            parsedProblem = parser.parse(localTestPath + "/domain.pddl", localTestPath + "/p01.pddl");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Problem problem = new DefaultProblem(parsedProblem);
        problem.instantiate();
        try {
            defaultSATEncoding.solve(problem, PicosatWrapper.createSolver(), MAX_PLAN_LENGTH);
        } catch (SolverTerminatedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(defaultSATEncoding);
        Assert.assertTrue(defaultSATEncoding.toString().contains("-10 1 0\n-10 -2 0\n-10 5 0\n-15 3 0\n-15 2 0\n-15 -5 0\n-21 3 0"));
    }
    */

    /**
     * Method that executes tests using IPC 1998 gripper ADL benchmarks.
     */
    @Test
    public void test_SAT_IPC1998_Gripper_ADL() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/gripper/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }

    /**
     * Method that executes tests using IPC 1998 Logistics ADL benchmarks.
     */
//    @Test
//    public void test_SAT_IPC1998_Logistics_ADL() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/adl" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 1998 Logistics STRIPS Round1 benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC1998_Logistics_STRIPS_Round1() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round1" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     *  Method that executes tests using IPC 1998 Logistics STRIPS Round2 benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC1998_Logistics_STRIPS_Round2() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round2" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     *  Method that executes tests using IPC 1998 Movie ADL benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC1998_Movie_ADL() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/adl" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 1998 Movie STRIPS benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC1998_Movie_STRIPS() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/strips" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2000 Blocks STRIPS typed benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2000_Blocks_STRIPS_Typed() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-typed" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2000 Blocks STRIPS untyped benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2000_Blocks_STRIPS_Untyped() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-untyped" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2000 Elevator ADL full typed benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2000_Elevator_ADL_Full_Typed() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/adl-full-typed" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2000 Elevator STRIPS simple typed benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2000_Elevator_STRIPS_Simple_Typed() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-typed" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2000 Freecell STRIPS  typed benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2000_Freecell_STRIPS_Typed() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-typed" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2000 Freecell STRIPS untyped benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2000_Freecell_STRIPS_Untyped() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-untyped" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2000 Logistics STRIPS typed benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2000_Logistics_STRIPS_Typed() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/logistics/strips-typed" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2002 Depots STRIPS automatic benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2002_Depots_STRIPS_Automatic() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/depots/strips-automatic" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2002 Driver Log STRIPS automatic benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2002_Driverlog_STRIPS_Automatic() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/driverlog/strips-automatic" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2002 Freecell STRIPS automatic benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2002_Freecell_STRIPS_Automatic() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/freecell/strips-automatic" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2002 Rovers STRIPS automatic benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2002_Rovers_STRIPS_Automatic() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/strips-automatic" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2002 Rovers STRIPS hand coded benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2002_Rovers_STRIPS_Hand_Coded() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/strips-hand-coded" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2002 Satellite STRIPS automatic benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2002_Satellite_STRIPS_Automatic() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/strips-automatic" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2002 Satellite STRIPS hand coded benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2002_Satellite_STRIPS_Hand_Coded() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/strips-hand-coded" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2002 Zeno Travel STRIPS automatic benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2002_Zenotravel_STRIPS_Automatic() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/strips-automatic" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2002 Zenotravel STRIPS hand coded benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2002_Zenotravel_STRIPS_Hand_Coded() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/strips-hand-coded" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2004 Airport non temporal STRIPS benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2004_Airport_Non_Temporal_STRIPS() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/nontemporal-strips" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2004 Pipesworld no-tankage non temporal STRIPS benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2004_Pipesworld_No_Tankage_Non_Temporal_STRIPS() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/no-tankage-nontemporal-strips"
//            + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2004 Pipesworld tankage non temporal STRIPS benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2004_Pipesworld_Tankage_Non_Temporal_STRIPS() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/tankage-nontemporal-strips"
//            + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2004 PSR small STRIPS benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2004_PSR_small_STRIPS() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/psr/small-strips" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2004 Satellite STRIPS benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2004_Satellite_STRIPS() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/satellite/strips" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2006 Openstacks propositional benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2006_Openstacks_Propositional() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/openstacks/propositional" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2006 Openstacks propositional STRIPS benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2006_Openstacks_Propositional_STRIPS() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/openstacks/propositional-strips" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2006 Pathways propositional benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2006_Pathways_Propositional() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/pathways/propositional" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
//
//    /**
//     * Method that executes tests using IPC 2006 Pathways propositional STRIPS benchmarks.
//     */
//    @Test
//    public void test_SAT_IPC2006_Pathways_Propositional_STRIPS() {
//        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/pathways/propositional-strips" + File.separator;
//        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
//            Tools.isBenchmarkExist(localTestPath));
//        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
//    }
}
