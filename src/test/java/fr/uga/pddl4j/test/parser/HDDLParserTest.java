package test.java.fr.uga.pddl4j.test.parser;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;


/**
 * Created by pellier on 18/12/2019.
 */
public class HDDLParserTest {

    public void main (String[] args) {

        final ProblemFactory factory = ProblemFactory.getInstance();
        try {
            ErrorManager errorManager  = factory.parse(args[0], args[1]);

            if (!errorManager.isEmpty()) {
                errorManager.printAll();
                System.exit(0);
            } else {
                System.out.println("Parsing domain file and problem file done successfully");
            }

        } catch (IOException e) {
            System.out.println("Unexpected error when parsing the PDDL planning problem description.");
            System.exit(0);
        }

    }
}
