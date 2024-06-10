package fr.uga.pddl4j.planners.sat.solvers;

import com.github.liveontologies.ipasir4j.IpasirSolver;

/**
 * Defines the available SAT solvers
 */
public enum SATSolver {
    PICOSAT;

    /**
     * Creates a new instance of the solver passed as argument
     * @param solver    the solver of which a new instance is to be created
     * @return          a new instance of this solver
     */
    public static IpasirSolver getNewSolverInstance(SATSolver solver) {
        switch (solver) {
            default:
                return Picosat.createSolver();
        }
    }
}
