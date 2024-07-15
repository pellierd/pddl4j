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
 * Implements the <tt>RegularExplanatorySATTest</tt> of the PDDL4J library.
 */
public class SATTest {
    private static final int TIMEOUT = 10;
    private static final String SAT_ENCODING = "DEFAULT";
    private static final String SAT_SOLVER = "MERGESAT";
    private static final int MAX_PLAN_LENGTH = 1000;
    private PlannerConfiguration config;

    /**
     * Test initialization.
     */
    @Before
    public void initTest() {
        config = AbstractSATPlanner.getDefaultConfiguration();
        config.setProperty(AbstractSATPlanner.TIME_OUT_SETTING, TIMEOUT);
        config.setProperty(AbstractSATPlanner.SAT_ENCODING_SETTING, SAT_ENCODING);
        config.setProperty(AbstractSATPlanner.SAT_SOLVER_SETTING, SAT_SOLVER);
        config.setProperty(AbstractSATPlanner.MAX_PLAN_LENGTH_SETTING, MAX_PLAN_LENGTH);
        Tools.changeVALPerm();
    }

    /**
     * Method that executes tests using IPC 1998 Grid STRIPS untyped benchmarks.
     * FAIL
     * Memory usage too high
     */
    /*
    @Test
    public void test_SAT_IPC1998_Grid_STRIPS_Untyped() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/grid/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 1998 Gripper STRIPS benchmarks.
     * FAIL
     * Too long (at least 3 first tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC1998_Gripper_STRIPS() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/gripper/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 1998 Logistics STRIPS Round1 benchmarks.
     * FAIL
     * ERR: Java heap space - test aborted
     */
    /*
    @Test
    public void test_SAT_IPC1998_Logistics_STRIPS_Round1() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round1" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 1998 Logistics STRIPS Round2 benchmarks.
     * FAIL
     * Too long (at least 2 first problems passing)
     */
    /*
    @Test
    public void test_SAT_IPC1998_Logistics_STRIPS_Round2() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round2" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 1998 Movie STRIPS benchmarks.
     * PASSED
     */
    @Test
    public void test_SAT_IPC1998_Movie_STRIPS() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }

    /**
     * Method that executes tests using IPC 2000 Blocks STRIPS typed benchmarks.
     * FAIL
     * Too long (at least 18 first problems passing)
     */
    /*
    @Test
    public void test_SAT_IPC2000_Blocks_STRIPS_Typed() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2000 Blocks STRIPS untyped benchmarks.
     * FAIL
     * Too long (at least 18 first problems passing)
     */
    /*
    @Test
    public void test_SAT_IPC2000_Blocks_STRIPS_Untyped() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2000 Elevator STRIPS simple typed benchmarks.
     * FAIL
     * Too long (at least 29 first problems passing)
     */
    /*
    @Test
    public void test_SAT_IPC2000_Elevator_STRIPS_Simple_Typed() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2000 Elevator STRIPS simple untyped benchmarks.
     * FAIL
     * Too long (at least 32 first tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC2000_Elevator_STRIPS_Simple_Untyped() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2000 Freecell STRIPS  typed benchmarks.
     * FAIL
     * Too long (and making the computer freeze occasionally due to high memory usage and swapping)
     */
    /*
    @Test
    public void test_SAT_IPC2000_Freecell_STRIPS_Typed() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2000 Freecell STRIPS untyped benchmarks.
     * FAIL
     * Memory use too high (freezing due to swapping)
     */
    /*
    @Test
    public void test_SAT_IPC2000_Freecell_STRIPS_Untyped() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2000 Logistics STRIPS typed benchmarks.
     * FAIL
     * Too long (at least 10 first problems passing)
     */
    /*
    @Test
    public void test_SAT_IPC2000_Logistics_STRIPS_Typed() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/logistics/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2002 Depots STRIPS automatic benchmarks.
     * FAIL
     * Apparently parser error
     */
    /*
    @Test
    public void test_SAT_IPC2002_Depots_STRIPS_Automatic() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/depots/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2002 Driver Log STRIPS automatic benchmarks.
     * FAIL
     * Too long (at least 7 first tests working)
     */
    /*
    @Test
    public void test_SAT_IPC2002_Driverlog_STRIPS_Automatic() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/driverlog/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2002 Freecell STRIPS automatic benchmarks.
     * FAIL
     * Too long (at least first test working)
     */
    /*
    @Test
    public void test_SAT_IPC2002_Freecell_STRIPS_Automatic() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/freecell/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2002 Rovers STRIPS automatic benchmarks.
     * FAIL
     * Apparently parser error
     */
    /*
    @Test
    public void test_SAT_IPC2002_Rovers_STRIPS_Automatic() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2002 Rovers STRIPS hand coded benchmarks.
     * FAIL
     * Apparently parser error
     */
    /*
    @Test
    public void test_SAT_IPC2002_Rovers_STRIPS_Hand_Coded() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/rovers/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2002 Satellite STRIPS automatic benchmarks.
     * FAIL
     * Too long (with PicoSAT)
     * (SIGSEGV inside the C code of MergeSat)
     */
    /*
    @Test
    public void test_SAT_IPC2002_Satellite_STRIPS_Automatic() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2002 Satellite STRIPS hand coded benchmarks.
     * FAIL
     * Memory use too high (freezing due to swapping)
     */
    /*
    @Test
    public void test_SAT_IPC2002_Satellite_STRIPS_Hand_Coded() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/satellite/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2002 Zeno Travel STRIPS automatic benchmarks.
     * FAIL
     * Too long and SIGSEGV inside the code of MergeSat (at least first 8 tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC2002_Zenotravel_STRIPS_Automatic() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/strips-automatic" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2002 Zenotravel STRIPS hand coded benchmarks.
     * FAIL
     * Memory use too high (freezing due to swapping)
     */
    /*
    @Test
    public void test_SAT_IPC2002_Zenotravel_STRIPS_Hand_Coded() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2002/zenotravel/strips-hand-coded" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2004 Airport non temporal STRIPS benchmarks.
     * FAIL
     * Too long (at least first 7 tests passing)
     * (SIGSEGV inside the C code of MergeSat)
     */
    /*
    @Test
    public void test_SAT_IPC2004_Airport_Non_Temporal_STRIPS() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/airport/nontemporal-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2004 Pipesworld no-tankage non temporal STRIPS benchmarks.
     * FAIL
     * Too long (at least 9 first tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC2004_Pipesworld_No_Tankage_Non_Temporal_STRIPS() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/no-tankage-nontemporal-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2004 Pipesworld tankage non temporal STRIPS benchmarks.
     * FAIL
     * ERR: Java heap space - test aborted (6 first tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC2004_Pipesworld_Tankage_Non_Temporal_STRIPS() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/pipesworld/tankage-nontemporal-strips"
            + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2004 PSR small STRIPS benchmarks.
     * FAIL
     * ERR: Java heap space - test aborted (24 first tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC2004_PSR_small_STRIPS() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/psr/small-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2004 Satellite STRIPS benchmarks.
     * FAIL
     * Too long (at least 6 first tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC2004_Satellite_STRIPS() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2004/satellite/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2006 Openstacks propositional benchmarks.
     * FAIL
     * Too long (at least 5 first tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC2006_Openstacks_Propositional() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/openstacks/propositional" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2006 Openstacks propositional STRIPS benchmarks.
     * FAIL
     * Too long (at least 3 first tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC2006_Openstacks_Propositional_STRIPS() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/openstacks/propositional-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2006 Pathways propositional benchmarks.
     * FAIL
     * Too long (at least 4 first tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC2006_Pathways_Propositional() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/pathways/propositional" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */

    /**
     * Method that executes tests using IPC 2006 Pathways propositional STRIPS benchmarks.
     * FAIL
     * Too long (at least 4 first tests passing)
     */
    /*
    @Test
    public void test_SAT_IPC2006_Pathways_Propositional_STRIPS() {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2006/pathways/propositional-strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, this.config);
    }
     */
}
