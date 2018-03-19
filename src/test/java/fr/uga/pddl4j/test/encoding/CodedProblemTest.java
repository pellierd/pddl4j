package fr.uga.pddl4j.test.encoding;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.IntExp;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Implements the <tt>CodedProblemTest</tt> of the PDD4L library.
 * Domain and problem used: Blocksworld domain and p01 problem.
 *
 * @author E. Hermellin
 * @version 0.1 - 16.03.18
 */
public class CodedProblemTest {

    /**
     * The list containing the encoded operators (operator String version).
     */
    private static List<String> opList = Arrays.asList("pick-up d", "pick-up b", "pick-up a", "pick-up c",
        "put-down d", "put-down b", "put-down a", "put-down c", "stack d b", "stack d a", "stack d c", "stack b d",
        "stack b a", "stack b c", "stack a d", "stack a b", "stack a c", "stack c d", "stack c b", "stack c a",
        "unstack d b", "unstack d a", "unstack d c", "unstack b d", "unstack b a", "unstack b c", "unstack a d",
        "unstack a b", "unstack a c", "unstack c d", "unstack c b", "unstack c a");

    /**
     * The list containing the encoded facts (operator String version).
     */
    private static List<String> factList = Arrays.asList("(clear d)", "(ontable d)", "(handempty)", "(holding d)",
        "(clear b)", "(ontable b)", "(holding b)", "(clear a)", "(ontable a)", "(holding a)",
        "(clear c)", "(ontable c)", "(holding c)", "(on d b)", "(on d a)", "(on d c)", "(on b d)", "(on b a)",
        "(on b c)", "(on a d)", "(on a b)", "(on a c)", "(on c d)", "(on c b)", "(on c a)");

    /**
     * The String containing the encoded goal expression (String version).
     */
    private static String goal = "(and (on d c)\n (on b a)\n (on c b)\n)";

    /**
     * The String containing the encoded init expression (String version).
     */
    private static String init = "(and (clear d)\n (ontable d)\n (handempty)\n (clear b)\n (ontable b)\n "
        + "(clear a)\n (ontable a)\n (clear c)\n (ontable c)\n)";

    /**
     * Parse domain and problem files and return the associated coded problem.
     *
     * @return a coded problem from the parsing file
     */
    private CodedProblem generateCodedProblem() {
        try {
            final File domain = new File("src/test/resources/encoding/domain.pddl");
            final File problem = new File("src/test/resources/encoding/p01.pddl");
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
     * Method that test the size of the operator list from a specified coded problem.
     */
    @Test
    public void testCodedProblemOperatorsListSize() {
        final CodedProblem codedProblem = generateCodedProblem();
        if (codedProblem != null) {
            Assert.assertTrue(codedProblem.getOperators().size() == opList.size());
        }
    }

    /**
     * Method that test each operator from a specified coded problem.
     */
    @Test
    public void testCodedProblemOperatorsList() {
        final CodedProblem codedProblem = generateCodedProblem();
        if (codedProblem != null) {
            final List<BitOp> opListCodedProblem = codedProblem.getOperators();
            for (int i = 0; i < opList.size(); i++) {
                Assert.assertTrue(codedProblem.toShortString(opListCodedProblem.get(i)).equals(opList.get(i)));
            }
        }
    }

    /**
     * Method that test the size of the fact list from a specified coded problem.
     */
    @Test
    public void testCodedProblemRelevantFactsSize() {
        final CodedProblem codedProblem = generateCodedProblem();
        if (codedProblem != null) {
            Assert.assertTrue(codedProblem.getRelevantFacts().size() == factList.size());
        }
    }

    /**
     * Method that test each fact from a specified coded problem.
     */
    @Test
    public void testEncodedRelevantFacts() {
        final CodedProblem codedProblem = generateCodedProblem();
        if (codedProblem != null) {
            final List<IntExp> factListCodedProblem = codedProblem.getRelevantFacts();
            for (int i = 0; i < factList.size(); i++) {
                Assert.assertTrue(codedProblem.toString(factListCodedProblem.get(i)).equals(factList.get(i)));
            }
        }
    }

    /**
     * Method that test the goal expression from a specified coded problem.
     */
    @Test
    public void testEncodedGoal() {
        final CodedProblem codedProblem = generateCodedProblem();
        if (codedProblem != null) {
            Assert.assertTrue(codedProblem.toString(codedProblem.getGoal()).equals(goal));
        }
    }

    /**
     * Method that test the init expression from a specified coded problem.
     */
    @Test
    public void testEncodedInit() {
        final CodedProblem codedProblem = generateCodedProblem();
        if (codedProblem != null) {
            Assert.assertTrue(codedProblem.toString(codedProblem.getInit()).equals(init));
        }
    }
}
