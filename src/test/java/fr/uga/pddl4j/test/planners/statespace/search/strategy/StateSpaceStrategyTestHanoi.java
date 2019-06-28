package fr.uga.pddl4j.test.planners.statespace.search.strategy;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.planners.statespace.search.strategy.BreadthFirstSearch;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.planners.statespace.search.strategy.StateSpaceStrategy;
import fr.uga.pddl4j.test.Tools;
import fr.uga.pddl4j.util.Plan;
import org.junit.Assert;
import org.junit.Test;

/**
 * Implements the <tt>StateSpaceStrategyTest</tt> of the PDD4L library.
 * Domain and problem used: hanoi domain and hanoi-8 problem.
 *
 * @author F. Baierl
 * @version 28.06.19
 */
public class StateSpaceStrategyTestHanoi {


    /**
     * Computation timeout.
     */
    private static final int TIMEOUT = 60;


    /**
     * The path to the domain file.
     */
    private String domainFile = "src/test/resources/strategy/hanoi.pddl";

    /**
     * The path to the problem file.
     */
    private String problemFile = "src/test/resources/strategy/hanoi-8.pddl";

    /**
     * The State Space Stragey used to solve planning problem.
     */
    private StateSpaceStrategy stateSpaceStrategy;


    /**
     * The size of Breadth First Search solution.
     */
    private static final double BREADTH_SOLUTION_COST = 255.0;

    /**
     * The size of Breadth First Search solution.
     */
    private static final int BREADTH_SOLUTION_SIZE = 255;


    /**
     * Method that tests solution node (cost and size) for Breadth First Search search strategy.
     */
    @Test
    public void testBreadthSolutionNode() {
        System.out.println("StateSpaceStrategy: Test solution node from Breadth First Search.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new BreadthFirstSearch(TIMEOUT * 10000);
        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);
        Assert.assertTrue(solutionNode.getCost() == BREADTH_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == BREADTH_SOLUTION_SIZE);
    }

    /**
     * Method that tests solution plan (cost and size) for Breadth First Search search strategy.
     */
    @Test
    public void testBreadthPlan() {
        System.out.println("StateSpaceStrategy: Test solution plan from Breadth First Search.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new BreadthFirstSearch(TIMEOUT * 1000);
        final Plan plan = stateSpaceStrategy.searchPlan(codedProblem);
        Assert.assertTrue(plan.cost() == BREADTH_SOLUTION_COST);
        Assert.assertTrue(plan.size() == BREADTH_SOLUTION_SIZE);

    }
}
