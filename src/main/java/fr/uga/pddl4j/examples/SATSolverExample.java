package fr.uga.pddl4j.examples;

import fr.uga.pddl4j.parser.*;
import fr.uga.pddl4j.problem.DefaultProblem;
import fr.uga.pddl4j.problem.Problem;

import java.io.FileWriter;

public class SATSolverExample {

    /**
     * The main method of the class. The first argument must be the path to the PDDL domain description and the second
     * argument the path to the PDDL problem description.
     *
     * @param args the command line arguments.
     */
    public static void main(final String[] args) {
        // Checks the number of arguments from the command line
        if (args.length != 2) {
            System.out.println("Invalid command line");
            return;
        }

        try {
            // Creates an instance of the PDDL parser
            final Parser parser = new Parser();
            // Parses the domain and the problem files.
            final DefaultParsedProblem parsedProblem = parser.parse(args[0], args[1]);
            // Gets the error manager of the parser
            final ErrorManager errorManager = parser.getErrorManager();
            // Checks if the error manager contains errors
            if (!errorManager.isEmpty()) {
                // Prints the errors
                for (Message m : errorManager.getMessages()) {
                    System.out.println(m.toString());
                }
            } else {
                final Problem problem = new DefaultProblem(parsedProblem);
                problem.instantiate();
                SATEncodingIpasir encoding = new SATEncodingIpasir(problem, 60);

                FileWriter fileWriter = new FileWriter("testOutput.temp");
                if (encoding.isSatisfiable()) fileWriter.write("Satisfiable\n");
                else fileWriter.write("Unsatisfiable\n");
                fileWriter.write(encoding.getPlan());
                fileWriter.close();
            }
            // This exception could happen if the domain or the problem does not exist
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
