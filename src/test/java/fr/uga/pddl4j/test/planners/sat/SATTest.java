package fr.uga.pddl4j.test.planners.sat;

import com.github.liveontologies.ipasir4j.SolverTerminatedException;
import fr.uga.pddl4j.parser.DefaultParsedProblem;
import fr.uga.pddl4j.parser.Parser;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.sat.AbstractSATPlanner;
import fr.uga.pddl4j.planners.sat.encodings.DefaultSATEncoding;
import fr.uga.pddl4j.planners.sat.solvers.PicosatWrapper;
import fr.uga.pddl4j.problem.DefaultProblem;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.test.Tools;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Implements the <tt>SATTest</tt> of the PDDL4J library.
 */
public class SATTest {
    private static final int TIMEOUT = 10;
    private static final String SAT_ENCODING = "DEFAULT";
    private static final String SAT_SOLVER = "PICOSAT";
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
}
