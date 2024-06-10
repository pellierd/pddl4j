package fr.uga.pddl4j.test.planners.sat;

import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.sat.AbstractSATPlanner;
import fr.uga.pddl4j.planners.sat.solvers.SATSolver;
import fr.uga.pddl4j.planners.sat.encodings.AbstractSATEncoding;
import fr.uga.pddl4j.test.Tools;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class SATTest {
    @Test
    public void simpleSATTest() {
        PlannerConfiguration config = AbstractSATPlanner.getDefaultConfiguration();
        config.setProperty(AbstractSATPlanner.TIME_OUT_SETTING, 10);
        config.setProperty(AbstractSATPlanner.SAT_ENCODING_SETTING, AbstractSATEncoding.SATEncoding.DEFAULT);
        config.setProperty(AbstractSATPlanner.SAT_SOLVER_SETTING, SATSolver.PICOSAT);
        config.setProperty(AbstractSATPlanner.MAX_PLAN_LENGTH_SETTING, 50);
        Tools.changeVALPerm();

        for (int i = 0; i < 4; i++) {
            final String localTestPath = "src/test/java/fr/uga/pddl4j/test/planners/sat/examples/example" + i + File.separator;
            Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
                Tools.isBenchmarkExist(localTestPath));
            Tools.solve(localTestPath, Tools.PDDL_EXT, Planner.Name.SAT, config);
        }
    }
}
