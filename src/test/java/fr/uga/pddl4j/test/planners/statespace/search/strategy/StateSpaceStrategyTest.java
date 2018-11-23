package fr.uga.pddl4j.test.planners.statespace.search.strategy;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.heuristics.relaxation.Heuristic;
import fr.uga.pddl4j.planners.statespace.search.strategy.AStar;
import fr.uga.pddl4j.planners.statespace.search.strategy.AStarAnytime;
import fr.uga.pddl4j.planners.statespace.search.strategy.BreadthFirstSearch;
import fr.uga.pddl4j.planners.statespace.search.strategy.DepthFirstSearch;
import fr.uga.pddl4j.planners.statespace.search.strategy.EnforcedHillClimbing;
import fr.uga.pddl4j.planners.statespace.search.strategy.GreedyBestFirstSearch;
import fr.uga.pddl4j.planners.statespace.search.strategy.GreedyBestFirstSearchAnytime;
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
     * The size of Breadth First Search solution.
     */
    private static final double BREADTH_SOLUTION_COST = 11.0;

    /**
     * The size of Depth First Search solution.
     */
    private static final double DEPTH_SOLUTION_COST = 41.0;

    /**
     * The cost of AStar Search Anytime solution.
     */
    private static final double ASTAR_ANYTIME_SOLUTION_COST = 11.0;

    /**
     * The cost of Greedy Best First Search Anytime solution.
     */
    private static final double GREEDY_ANYTIME_SOLUTION_COST = 11.0;

    /**
     * The cost of Hill Climbing Anytime solution.
     */
    private static final double HILL_ANYTIME_SOLUTION_COST = 13.0;

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
     * The size of Breadth First Search solution.
     */
    private static final int BREADTH_SOLUTION_SIZE = 11;

    /**
     * The size of Depth First Search solution.
     */
    private static final int DEPTH_SOLUTION_SIZE = 41;

    /**
     * The size of Astar Search Anytime solution.
     */
    private static final int ASTAR_ANYTIME_SOLUTION_SIZE = 11;

    /**
     * The size of Greedy Best First Search Anytime solution.
     */
    private static final int GREEDY_ANYTIME_SOLUTION_SIZE = 11;

    /**
     * The size of Hill Climbing Anytime solution.
     */
    private static final int HILL_ANYTIME_SOLUTION_SIZE = 13;

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
            codedProblem).size() == ASTAR_SOLUTION_SIZE);
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
            codedProblem).size() == GREEDY_SOLUTION_SIZE);
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
            codedProblem).size() == ENFORCED_SOLUTION_SIZE);
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
            codedProblem).size() == HILL_SOLUTION_SIZE);
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

    /**
     * Method that tests solution node (cost and size) for Breadth First Search search strategy.
     */
    @Test
    public void testBreadthSolutionNode() {
        System.out.println("StateSpaceStrategy: Test solution node from Breadth First Search.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new BreadthFirstSearch(TIMEOUT * 1000);
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

    /**
     * Method that tests solution node (cost and size) for Depth First Search search strategy.
     */
    @Test
    public void testDepthSolutionNode() {
        System.out.println("StateSpaceStrategy: Test solution node from Depth First Search.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new DepthFirstSearch(TIMEOUT * 1000);
        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);
        Assert.assertTrue(solutionNode.getCost() == DEPTH_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == DEPTH_SOLUTION_SIZE);
    }

    /**
     * Method that tests solution plan (cost and size) for Depth First Search search strategy.
     */
    @Test
    public void testDepthPlan() {
        System.out.println("StateSpaceStrategy: Test solution plan from Depth First Search.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new DepthFirstSearch(TIMEOUT * 1000);
        final Plan plan = stateSpaceStrategy.searchPlan(codedProblem);
        Assert.assertTrue(plan.cost() == DEPTH_SOLUTION_COST);
        Assert.assertTrue(plan.size() == DEPTH_SOLUTION_SIZE);
    }

    /**
     * Method that tests solution node (cost and size) for Astar Anytime search strategy.
     */
    @Test
    public void testAstarAnytimeSolutionNode() {
        System.out.println("StateSpaceStrategy: Test solution node from Astar Search Anytime.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new AStarAnytime(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);
        Assert.assertTrue(solutionNode.getCost() == ASTAR_ANYTIME_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == ASTAR_ANYTIME_SOLUTION_COST);
    }

    /**
     * Method that tests solution plan (cost and size) for Astar Anytime search strategy.
     */
    @Test
    public void testAstarAnytimePlan() {
        System.out.println("StateSpaceStrategy: Test solution plan from Astar Search Anytime.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new AStarAnytime(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Plan plan = stateSpaceStrategy.searchPlan(codedProblem);
        Assert.assertTrue(plan.cost() == ASTAR_ANYTIME_SOLUTION_COST);
        Assert.assertTrue(plan.size() == ASTAR_ANYTIME_SOLUTION_SIZE);
    }

    /**
     * Method that tests solution node (cost and size) for Greedy Best First Search Anytime search strategy.
     */
    @Test
    public void testGreedyAnytimeSolutionNode() {
        System.out.println("StateSpaceStrategy: Test solution node from Greedy Best First Search Anytime.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new GreedyBestFirstSearchAnytime(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);
        Assert.assertTrue(solutionNode.getCost() == GREEDY_ANYTIME_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == GREEDY_ANYTIME_SOLUTION_COST);
    }

    /**
     * Method that tests solution plan (cost and size) for Greedy Best First Search Anytime search strategy.
     */
    @Test
    public void testGreedyAnytimePlan() {
        System.out.println("StateSpaceStrategy: Test solution plan from Greedy Best First Search Anytime.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new GreedyBestFirstSearchAnytime(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Plan plan = stateSpaceStrategy.searchPlan(codedProblem);
        Assert.assertTrue(plan.cost() == GREEDY_ANYTIME_SOLUTION_COST);
        Assert.assertTrue(plan.size() == GREEDY_ANYTIME_SOLUTION_SIZE);
    }

    /**
     * Method that tests solution node (cost and size) for Hill Climbing Anytime search strategy.
     */
    @Test
    public void testHillAnytimeSolutionNode() {
        System.out.println("StateSpaceStrategy: Test solution node from Hill Climbing Anytime.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new HillClimbing(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);
        Assert.assertTrue(solutionNode.getCost() == HILL_ANYTIME_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == HILL_ANYTIME_SOLUTION_COST);
    }

    /**
     * Method that tests solution plan (cost and size) for Hill Climbing Anytime search strategy.
     */
    @Test
    public void testHillAnytimePlan() {
        System.out.println("StateSpaceStrategy: Test solution plan from Hill Climbing Anytime.");
        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, problemFile);
        stateSpaceStrategy = new HillClimbing(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        final Plan plan = stateSpaceStrategy.searchPlan(codedProblem);
        Assert.assertTrue(plan.cost() == HILL_ANYTIME_SOLUTION_COST);
        Assert.assertTrue(plan.size() == HILL_ANYTIME_SOLUTION_SIZE);
    }
}
