package fr.uga.pddl4j.examples;

import fr.uga.pddl4j.examples.ipasir4j.IpasirSolver;
import fr.uga.pddl4j.examples.ipasir4j.Picosat;
import fr.uga.pddl4j.examples.ipasir4j.SolverTerminatedException;
import fr.uga.pddl4j.parser.*;

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
                encodeSAT(parsedProblem);
            }
            // This exception could happen if the domain or the problem does not exist
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    public static void encodeSAT(DefaultParsedProblem parsedProblem) {
        //final Problem problem = new DefaultProblem(parsedProblem);
        //problem.instantiate();

        //Initial state
        //final BitVector positiveFluents = problem.getInitialState().getPositiveFluents();

        IpasirSolver solver = Picosat.createSolver();

        solver.add(1);
        solver.add(0);
        try {
            System.out.println(solver.isSatisfiable());
        } catch (SolverTerminatedException e) {
            e.printStackTrace();
        }
    }
}
