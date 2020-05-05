package test.java.fr.uga.pddl4j.test.encoding;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by pellier on 14/02/2020.
 */
public class HDDLEncoderTest {

    public static void main(String[] args) {

        try {
            final ProblemFactory factory = new ProblemFactory();

            factory.setTraceLevel(7);

            //ErrorManager errorManager = factory.parse(
            //    new File("src/test/resources/parser/hddl/HDDL-Total-Ordered/rover/domain.hddl"),
            //    new File("src/test/resources/parser/hddl/HDDL-Total-Ordered/rover/pb01.hddl"));

            //ErrorManager errorManager = factory.parse(
            //    new File("src/test/resources/parser/hddl/HDDL-Total-Ordered/transport/domain.hddl"),
            //    new File("src/test/resources/parser/hddl/HDDL-Total-Ordered/transport/pb01.hddl"));

            //ErrorManager errorManager = factory.parse(
            //    new File("src/test/resources/parser/hddl/HDDL-Partial-Ordered/rover/domain.hddl"),
            //    new File("src/test/resources/parser/hddl/HDDL-Partial-Ordered/rover/pb01.hddl"));

            ErrorManager errorManager = factory.parse(
                new File("src/test/resources/parser/hddl/HDDL-Partial-Ordered/transport/domain.hddl"),
                new File("src/test/resources/parser/hddl/HDDL-Partial-Ordered/transport/pb01.hddl"));


            if (!errorManager.isEmpty()) {
                errorManager.printAll();
                System.exit(0);
            } else {
                System.out.println("Parsing domain file and problem file done successfully");
                //System.out.println(parser.getDomain());
                //System.out.println(parser.getProblem());

                factory.encode();

            }
        } catch (IOException e) {
            System.out.println("Unexpected error when parsing the PDDL planning problem description.");
            System.exit(0);
        }

    }
}
