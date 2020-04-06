package fr.uga.pddl4j.test.planners.statespace;

import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.statespace.hsp.HSP;

import java.io.File;
import java.io.IOException;

/**
 * Created by pellier on 02/04/2020.
 */
public class PlannersTest {

    public static void main(String[] args) {

        final ProblemFactory factory = ProblemFactory.getInstance();

        ErrorManager errorManager = null;
        try {
            errorManager = factory.parse(new File("./pddl/blocksworld/domain.pddl"), new File("./pddl/blocksworld/p03.pddl"));
        } catch (IOException e) {
            System.out.println("Unexpected error when parsing the PDDL planning problem description.");
            e.printStackTrace();
            System.exit(0);
        }

        if (!errorManager.isEmpty()) {
            errorManager.printAll();
            System.exit(0);
        } else {
            System.out.println("Parsing domain file and problem file done successfully");
        }
        factory.setTraceLevel(7);
        final Problem pb = factory.encode();

        System.out.println("Encoding problem done successfully ("
            + pb.getActions().size() + " actions, "
            + pb.getRelevantFacts().size() + " fluents).");

        if (!pb.isSolvable()) {
            System.out.println("Goal can be simplified to FALSE. No search will solve it.");
            System.exit(0);
        }

        final HSP planner = new HSP();

        final Plan plan = planner.search(pb);
        if (plan != null) {
            System.out.println("Found plan as follows:");
            System.out.println(pb.toString(plan));
        } else {
            System.out.println("No plan found.");
        }

    }
}
