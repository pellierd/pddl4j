package fr.uga.pddl4j.test.util;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.hsp.HSP;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.Plan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Implements the <tt>PlanTest</tt> of the PDD4L library.
 * Domain and problem used: Blocksworld domain and p01, p02, p03, p04 problems.
 *
 * @author E. Hermellin
 * @version 0.1 - 19.03.18
 */
public class PlanTest {

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
     * The HSP planner reference.
     */
    private HSP planner = null;

    /**
     * The list of problem files.
     */
    private List<String> problemList = Arrays.asList("src/test/resources/encoding/p01.pddl",
        "src/test/resources/encoding/p02.pddl",
        "src/test/resources/encoding/p03.pddl",
        "src/test/resources/encoding/p04.pddl");

    /**
     * The size of the plans.
     */
    private List<Integer> plansSize = Arrays.asList(6, 10, 6, 12);

    /**
     * The cost of the plans.
     */
    private List<Double> plansCost = Arrays.asList(6.0, 10.0, 6.0, 12.0);

    /**
     * The plan for problem file p01.
     */
    private List<String> planP01 = Arrays.asList("pick-up b", "stack b a", "pick-up c", "stack c b", "pick-up d",
        "stack d c");

    /**
     * The plan for problem file p01.
     */
    private List<String> planP02 = Arrays.asList("unstack b c", "put-down b", "unstack c a", "put-down c",
        "unstack a d", "stack a b", "pick-up c", "stack c a", "pick-up d", "stack d c");

    /**
     * The plan for problem file p01.
     */
    private List<String> planP03 = Arrays.asList("unstack c b", "stack c d", "pick-up b", "stack b c", "pick-up a",
        "stack a b");

    /**
     * The plan for problem file p01.
     */
    private List<String> planP04 = Arrays.asList("unstack c e", "put-down c", "pick-up d", "stack d c", "unstack e b",
        "put-down e", "unstack b a", "stack b d", "pick-up e", "stack e b", "pick-up a", "stack a e");

    /**
     * The operators of the plans.
     */
    private List<List<String>> plansOperators = Arrays.asList(planP01, planP02, planP03, planP04);

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
     * Parse domain and problem files and return the associated coded problem.
     *
     * @return a coded problem from the parsing file
     */
    private CodedProblem generateCodedProblem(String problemFile) {
        try {
            final File domain = new File("src/test/resources/encoding/domain.pddl");
            final File problem = new File(problemFile);
            final ProblemFactory factory = ProblemFactory.getInstance();
            final ErrorManager errorManager = factory.parse(domain, problem);
            if (errorManager.isEmpty()) {
                return factory.encode();
            }
        } catch (IOException ioExcepion) {
            System.err.println(ioExcepion + " test files not found !");
        }
        return null;
    }

    /**
     * Method that test the size of the plans.
     */
    @Test
    public void testPlanSize() {
        int i = 0;
        for (String problemFile : problemList) {
            final Plan plan = planner.search(generateCodedProblem(problemFile));
            if (plan != null) {
                Assert.assertTrue(plan.size() == plansSize.get(i));
            }
            i++;
        }
    }

    /**
     * Method that test the cost of the plans.
     */
    @Test
    public void testPlanCost() {
        int i = 0;
        for (String problemFile : problemList) {
            final Plan plan = planner.search(generateCodedProblem(problemFile));
            if (plan != null) {
                Assert.assertTrue(plan.cost() == plansCost.get(i));
            }
            i++;
        }
    }

    /**
     * Method that test the operators of the plans.
     */
    @Test
    public void testPlans() {
        int i = 0;
        for (String problemFile : problemList) {
            final CodedProblem pb = generateCodedProblem(problemFile);
            if (pb != null) {
                final Plan plan = planner.search(pb);
                int j = 0;
                for (BitOp bitOp : plan.actions()) {
                    Assert.assertTrue(pb.toShortString(bitOp).equals(plansOperators.get(i).get(j)));
                    j++;
                }
            }
            i++;
        }
    }
}
