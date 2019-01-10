/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.  If not, see
 * <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.test.util;

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
import fr.uga.pddl4j.util.SolutionEvent;
import org.junit.Assert;
import org.junit.Test;

/**
 * Implements the <tt>SolutionEventAndListenerTest</tt> of the PDD4L library.
 * Domain and problem used: Gripper domain and p01, p02 problems.
 *
 * @author E. Hermellin
 * @version 0.1 - 10.01.19
 */
public class SolutionEventAndListenerTest {

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
     * The path to the p01 problem file.
     */
    private String p01ProblemFile = "src/test/resources/strategy/p01.pddl";

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
     * The fired SolutionEvent.
     */
    private SolutionEvent firedSolutionEvent = null;

    /**
     * Method that tests solution event (cost and size) for AStar search strategy.
     */
    @Test
    public void testAstarFireSolutionEvent() {
        System.out.println("SolutionEventAndListener: Test fire solution node from AStar.");

        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, p01ProblemFile);
        stateSpaceStrategy = new AStar(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        stateSpaceStrategy.addSolutionListener(e -> firedSolutionEvent = e);

        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);

        Assert.assertTrue(solutionNode.getCost() == ASTAR_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == ASTAR_SOLUTION_SIZE);

        Assert.assertTrue(Math.abs(firedSolutionEvent.getSolutionNode().getCost() - solutionNode.getCost()) < 0.00001);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).size() == stateSpaceStrategy.extractPlan(solutionNode, codedProblem).size());

        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).equals(stateSpaceStrategy.extractPlan(solutionNode, codedProblem)));
    }

    /**
     * Method that tests solution event (cost and size) for BFS search strategy.
     */
    @Test
    public void testBFSFireSolutionEvent() {
        System.out.println("SolutionEventAndListener: Test fire solution node from BFS.");

        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, p01ProblemFile);
        stateSpaceStrategy = new BreadthFirstSearch(TIMEOUT * 1000);
        stateSpaceStrategy.addSolutionListener(e -> firedSolutionEvent = e);

        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);

        Assert.assertTrue(solutionNode.getCost() == BREADTH_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == BREADTH_SOLUTION_SIZE);

        Assert.assertTrue(Math.abs(firedSolutionEvent.getSolutionNode().getCost() - solutionNode.getCost()) < 0.00001);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).size() == stateSpaceStrategy.extractPlan(solutionNode, codedProblem).size());

        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).equals(stateSpaceStrategy.extractPlan(solutionNode, codedProblem)));
    }

    /**
     * Method that tests solution event (cost and size) for DFS search strategy.
     */
    @Test
    public void testDFSFireSolutionEvent() {
        System.out.println("SolutionEventAndListener: Test fire solution node from DFS.");

        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, p01ProblemFile);
        stateSpaceStrategy = new DepthFirstSearch(TIMEOUT * 1000);
        stateSpaceStrategy.addSolutionListener(e -> firedSolutionEvent = e);

        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);

        Assert.assertTrue(solutionNode.getCost() == DEPTH_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == DEPTH_SOLUTION_SIZE);

        Assert.assertTrue(Math.abs(firedSolutionEvent.getSolutionNode().getCost() - solutionNode.getCost()) < 0.00001);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).size() == stateSpaceStrategy.extractPlan(solutionNode, codedProblem).size());

        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).equals(stateSpaceStrategy.extractPlan(solutionNode, codedProblem)));
    }

    /**
     * Method that tests solution event (cost and size) for EHC search strategy.
     */
    @Test
    public void testEHCFireSolutionEvent() {
        System.out.println("SolutionEventAndListener: Test fire solution node from EHC.");

        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, p01ProblemFile);
        stateSpaceStrategy = new EnforcedHillClimbing(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        stateSpaceStrategy.addSolutionListener(e -> firedSolutionEvent = e);

        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);

        Assert.assertTrue(solutionNode.getCost() == ENFORCED_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == ENFORCED_SOLUTION_SIZE);

        Assert.assertTrue(Math.abs(firedSolutionEvent.getSolutionNode().getCost() - solutionNode.getCost()) < 0.00001);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).size() == stateSpaceStrategy.extractPlan(solutionNode, codedProblem).size());

        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).equals(stateSpaceStrategy.extractPlan(solutionNode, codedProblem)));
    }

    /**
     * Method that tests solution event (cost and size) for GBFS search strategy.
     */
    @Test
    public void testGbfsFireSolutionEvent() {
        System.out.println("SolutionEventAndListener: Test fire solution node from GBFS.");

        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, p01ProblemFile);
        stateSpaceStrategy = new GreedyBestFirstSearch(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        stateSpaceStrategy.addSolutionListener(e -> firedSolutionEvent = e);

        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);

        Assert.assertTrue(solutionNode.getCost() == GREEDY_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == GREEDY_SOLUTION_SIZE);

        Assert.assertTrue(Math.abs(firedSolutionEvent.getSolutionNode().getCost() - solutionNode.getCost()) < 0.00001);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).size() == stateSpaceStrategy.extractPlan(solutionNode, codedProblem).size());

        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).equals(stateSpaceStrategy.extractPlan(solutionNode, codedProblem)));
    }

    /**
     * Method that tests solution event (cost and size) for HC search strategy.
     */
    @Test
    public void testHCFireSolutionEvent() {
        System.out.println("SolutionEventAndListener: Test fire solution node from HC.");

        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, p01ProblemFile);
        stateSpaceStrategy = new HillClimbing(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        stateSpaceStrategy.addSolutionListener(e -> firedSolutionEvent = e);

        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);

        Assert.assertTrue(solutionNode.getCost() == HILL_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == HILL_SOLUTION_SIZE);

        Assert.assertTrue(Math.abs(firedSolutionEvent.getSolutionNode().getCost() - solutionNode.getCost()) < 0.00001);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).size() == stateSpaceStrategy.extractPlan(solutionNode, codedProblem).size());

        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).equals(stateSpaceStrategy.extractPlan(solutionNode, codedProblem)));
    }

    /**
     * Method that tests solution event (cost and size) for Astar Anytime search strategy.
     */
    @Test
    public void testAstarAnyFireSolutionEvent() {
        System.out.println("SolutionEventAndListener: Test fire solution node from Astar Anytime.");

        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, p01ProblemFile);
        stateSpaceStrategy = new AStarAnytime(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        stateSpaceStrategy.addSolutionListener(e -> firedSolutionEvent = e);

        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);

        Assert.assertTrue(solutionNode.getCost() == ASTAR_ANYTIME_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == ASTAR_ANYTIME_SOLUTION_SIZE);

        Assert.assertTrue(Math.abs(firedSolutionEvent.getSolutionNode().getCost() - solutionNode.getCost()) < 0.00001);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).size() == stateSpaceStrategy.extractPlan(solutionNode, codedProblem).size());

        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).equals(stateSpaceStrategy.extractPlan(solutionNode, codedProblem)));
    }

    /**
     * Method that tests solution event (cost and size) for GBFS Anytime search strategy.
     */
    @Test
    public void testGbfsAnytimeFireSolutionEvent() {
        System.out.println("SolutionEventAndListener: Test fire solution node from GBFS Anytime.");

        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, p01ProblemFile);
        stateSpaceStrategy = new GreedyBestFirstSearchAnytime(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        stateSpaceStrategy.addSolutionListener(e -> firedSolutionEvent = e);

        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);

        Assert.assertTrue(solutionNode.getCost() == GREEDY_ANYTIME_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == GREEDY_ANYTIME_SOLUTION_SIZE);

        Assert.assertTrue(Math.abs(firedSolutionEvent.getSolutionNode().getCost() - solutionNode.getCost()) < 0.00001);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).size() == stateSpaceStrategy.extractPlan(solutionNode, codedProblem).size());

        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).equals(stateSpaceStrategy.extractPlan(solutionNode, codedProblem)));
    }

    /**
     * Method that tests solution event (cost and size) for HC search strategy.
     */
    @Test
    public void testHCAnytimeFireSolutionEvent() {
        System.out.println("SolutionEventAndListener: Test fire solution node from HC Anytime.");

        final CodedProblem codedProblem = Tools.generateCodedProblem(domainFile, p01ProblemFile);
        stateSpaceStrategy = new HillClimbing(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT);
        stateSpaceStrategy.addSolutionListener(e -> firedSolutionEvent = e);

        final Node solutionNode = stateSpaceStrategy.searchSolutionNode(codedProblem);

        Assert.assertTrue(solutionNode.getCost() == HILL_ANYTIME_SOLUTION_COST);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(solutionNode,
            codedProblem).size() == HILL_ANYTIME_SOLUTION_SIZE);

        Assert.assertTrue(Math.abs(firedSolutionEvent.getSolutionNode().getCost() - solutionNode.getCost()) < 0.00001);
        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).size() == stateSpaceStrategy.extractPlan(solutionNode, codedProblem).size());

        Assert.assertTrue(stateSpaceStrategy.extractPlan(firedSolutionEvent.getSolutionNode(),
            codedProblem).equals(stateSpaceStrategy.extractPlan(solutionNode, codedProblem)));
    }
}
