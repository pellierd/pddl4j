package fr.uga.pddl4j.test.satSolvers;

import fr.uga.pddl4j.examples.SATSolverExample;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IpasirEncodingTest {
    private final ArrayList<List<String>> results = new ArrayList<>();
    private final String examplesPath = "./src/test/java/fr/uga/pddl4j/test/satSolvers/examples/";
    private final Path testOutputPath = Paths.get("testOutput.temp");
    private final String[] expectedResults = new String[]{
        "Satisfiable\nPlan:\nmove(r, loc1, loc2)\n",
        "Satisfiable\nPlan:\nmoveLoc1Loc2(r)\nmoveLoc2Loc3(r)\n",
        "Satisfiable\nPlan:\nloadd-airplane(p1, plane, lhr)\nloadd-airplane(p2, plane, lhr)\nfly-airplane(plane, lhr, cdg)\nunload-airplane(p1, plane, cdg)\nunload-airplane(p2, plane, cdg)\nload-truck(p1, truck, cdg)\nload-truck(p2, truck, cdg)\ndrive-truck(truck, cdg, south, paris)\nunload-truck(p2, truck, south)\ndrive-truck(truck, south, north, paris)\nunload-truck(p1, truck, north)\n",
        "Satisfiable\nPlan:\npickup_tray_on_unit(robot1, stocker, tray1)\nrobot_move(robot1, stocker, conv1)\ndrop_tray_on_conveyor(robot1, conv1, tray1, piece1)\nconveyor_load_tray_in_unit(conv1, unit1, tray1, piece1)\nunit_execute_operation(unit1, op10, op20, tray1)\nunit_execute_operation(unit1, op20, op30, tray1)\nunit_execute_operation(unit1, op30, stop, tray1)\ntray_completed(op30, tray1, unit1)\n"
    };

    @Test
    public void testIpasirEncoding() {
        try {
            for (int i = 0; i < 4; i++) {
                addTest("example" + i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n########## Test results ##########");
        for (int i = 0; i < results.size(); i++) {
            System.out.print("\nExample " + i + ": ");
            StringBuilder result = new StringBuilder();
            for (String s : results.get(i)) {
                System.out.println(s);
                result.append(s).append("\n");
            }
            assertEquals(result.toString(), expectedResults[i]);
        }

        try {
            Files.delete(testOutputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addTest(String testName) throws IOException {
        SATSolverExample.main(new String[]{examplesPath + testName + "/domain.pddl", examplesPath + testName + "/problem.pddl"});
        results.add(Files.readAllLines(testOutputPath));
    }
}
