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
import fr.uga.pddl4j.planners.statespace.hsp.HSP;
import fr.uga.pddl4j.test.Tools;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.Plan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
     * Default Heuristic Type.
     */
    private static final Heuristic.Type HEURISTIC_TYPE = Heuristic.Type.FAST_FORWARD;

    /**
     * Default Heuristic Weight.
     */
    private static final double HEURISTIC_WEIGHT = 1.0;

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
     * The path to the domain file.
     */
    private String domainFile = "src/test/resources/encoding/domain.pddl";

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
        planner = new HSP(TIMEOUT * 1000, HEURISTIC_TYPE, HEURISTIC_WEIGHT, STATISTICS, TRACE_LEVEL);
    }


    /**
     * Method that test the size of the plans.
     */
    @Test
    public void testPlanSize() {
        System.out.println("PlanTest: Test the size of a solution plan (blocksworld).");
        int i = 0;
        for (String problemFile : problemList) {
            final Plan plan = planner.search(Tools.generateCodedProblem(domainFile, problemFile));
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
        System.out.println("PlanTest: Test the cost of a solution plan (blocksworld).");
        int i = 0;
        for (String problemFile : problemList) {
            final Plan plan = planner.search(Tools.generateCodedProblem(domainFile, problemFile));
            if (plan != null) {
                Assert.assertTrue(Math.abs(plan.cost() - plansCost.get(i)) < 0.0000001);
            }
            i++;
        }
    }

    /**
     * Method that test the operators of the plans.
     */
    @Test
    public void testPlans() {
        System.out.println("PlanTest: Test the operators of a solution plan (blocksworld).");
        int i = 0;
        for (String problemFile : problemList) {
            final CodedProblem pb = Tools.generateCodedProblem(domainFile, problemFile);
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
