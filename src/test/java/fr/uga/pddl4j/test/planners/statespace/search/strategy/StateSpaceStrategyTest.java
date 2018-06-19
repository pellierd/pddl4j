package fr.uga.pddl4j.test.planners.statespace.search.strategy;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.planners.statespace.search.strategy.AStar;
import fr.uga.pddl4j.planners.statespace.search.strategy.EnforcedHillClimbing;
import fr.uga.pddl4j.planners.statespace.search.strategy.GreedyBestFirstSearch;
import fr.uga.pddl4j.planners.statespace.search.strategy.HillClimbing;
import fr.uga.pddl4j.planners.statespace.search.strategy.Node;
import fr.uga.pddl4j.planners.statespace.search.strategy.StateSpaceStrategy;
import fr.uga.pddl4j.test.Tools;
import fr.uga.pddl4j.util.Plan;
import org.junit.Assert;
import org.junit.Test;

/**
 * Implements the <tt>StateSpaceStrategyTest</tt> of the PDD4L library.
 * Domain and problem used: Gripper domain and p01 problem.
 *
 * @author E. Hermellin
 * @version 0.1 - 18.06.18
 */
public class StateSpaceStrategyTest {

    /**
     * Computation timeout.
     */
    private static final int TIMEOUT = 60;

    /**
     * Default Heuristic Type.
     */
    private static final Heuristic.Type HEURISTIC_TYPE = Heuristic.Type.FAST_FORWARD;

    /**
     * Default Heuristic Weight.
     */
    private static final double HEURISTIC_WEIGHT = 1.0;

    /**
     * The path to the domain file.
     */
    private String domainFile = "src/test/resources/strategy/domain.pddl";

    /**
     * The path to the problem file.
     */
    private String problemFile = "src/test/resources/strategy/p01.pddl";

    /**
     * The State Space Stragey used to solve planning problem.
     */
    private StateSpaceStrategy stateSpaceStrategy;

    /**
     * The cost of AStar solution.
     */
    private static final double ASTAR_SOLUTION_COST = 11.0;

    /**
     * The cost of Greedy Best First Search solution.
     */
    private static final double GREEDY_SOLUTION_COST = 13.0;

    /**
     * The cost of Enforced Hill Climbing solution.
     */
    private static final double ENFORCED_SOLUTION_COST = 13.0;

    /**
     * The cost of Hill Climbing solution.
     */
    private static final double HILL_SOLUTION_COST = 13.0;

    /**
     * The size of AStar solution.
     */
    private static final int ASTAR_SOLUTION_SIZE = 11;

    /**
     * The size of Greedy Best First Search solution.
     */
    private static final  int GREEDY_SOLUTION_SIZE = 13;

    /**
     * The size of Enforced Hill Climbing solution.
     */
    private static final int ENFORCED_SOLUTION_SIZE = 13;

    /**
     * The size of Hill Climbing solution.
     */
    private static final int HILL_SOLUTION_SIZE = 13;

    /**
     * Method that tests solution node (cost and size) for AStar search strategy.
     */
    @Test
    public void testAstarSolutionNode() {
        System.out.println("StateSpaceStrategy: Test solution node from AStar.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new AStar(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);
        Assert.assertTrue(solutionNode.getCost() == ASTAR_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == ASTAR_SOLUTION_COST);
    }

    /**
     * Method that tests solution plan (cost and size) for AStar search strategy.
     */
    @Test
    public void testAstarPlan() {
        System.out.println("StateSpaceStrategy: Test solution plan from AStar.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new AStar(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Plan plan = stateSpaceStrategy.searchPlan(codedProblem);
        Assert.assertTrue(plan.cost() == ASTAR_SOLUTION_COST);
        Assert.assertTrue(plan.size() == ASTAR_SOLUTION_SIZE);
    }

    /**
     * Method that tests solution node (cost and size) for Greedy Best First Search search strategy.
     */
    @Test
    public void testGreedySolutionNode() {
        System.out.println("StateSpaceStrategy: Test solution node from Greedy Best First Search.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new GreedyBestFirstSearch(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);
        Assert.assertTrue(solutionNode.getCost() == GREEDY_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == GREEDY_SOLUTION_COST);
    }

    /**
     * Method that tests solution plan (cost and size) for Greedy Best First Search search strategy.
     */
    @Test
    public void testGreedyPlan() {
        System.out.println("StateSpaceStrategy: Test solution plan from Greedy Best First Search.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new GreedyBestFirstSearch(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Plan plan = stateSpaceStrategy.searchPlan(codedProblem);
        Assert.assertTrue(plan.cost() == GREEDY_SOLUTION_COST);
        Assert.assertTrue(plan.size() == GREEDY_SOLUTION_SIZE);
    }

    /**
     * Method that tests solution node (cost and size) for Enforced Hill Climbing search strategy.
     */
    @Test
    public void testEnforcedSolutionNode() {
        System.out.println("StateSpaceStrategy: Test solution node from Enforced Hill Climbing.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new EnforcedHillClimbing(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);
        Assert.assertTrue(solutionNode.getCost() == ENFORCED_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == ENFORCED_SOLUTION_COST);
    }

    /**
     * Method that tests solution plan (cost and size) for Enforced Hill Climbing search strategy.
     */
    @Test
    public void testEnforcedPlan() {
        System.out.println("StateSpaceStrategy: Test solution plan from Enforced Hill Climbing.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new EnforcedHillClimbing(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Plan plan = stateSpaceStrategy.searchPlan(codedProblem);
        Assert.assertTrue(plan.cost() == ENFORCED_SOLUTION_COST);
        Assert.assertTrue(plan.size() == ENFORCED_SOLUTION_SIZE);
    }

    /**
     * Method that tests solution node (cost and size) for Hill Climbing search strategy.
     */
    @Test
    public void testHillSolutionNode() {
        System.out.println("StateSpaceStrategy: Test solution node from Hill Climbing.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new HillClimbing(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);
        Assert.assertTrue(solutionNode.getCost() == HILL_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == HILL_SOLUTION_COST);
    }

    /**
     * Method that tests solution plan (cost and size) for Hill Climbing search strategy.
     */
    @Test
    public void testHillPlan() {
        System.out.println("StateSpaceStrategy: Test solution plan from Hill Climbing.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new HillClimbing(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Plan plan = stateSpaceStrategy.searchPlan(codedProblem);
        Assert.assertTrue(plan.cost() == HILL_SOLUTION_COST);
        Assert.assertTrue(plan.size() == HILL_SOLUTION_SIZE);
    }
}
