package fr.uga.pddl4j.planners.sat.encodings;

import com.github.liveontologies.ipasir4j.IpasirSolver;
import com.github.liveontologies.ipasir4j.SolverTerminatedException;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.problem.Problem;

import java.io.Serializable;

/**
 * An interface used for a SAT encoding used by a planner
 */
public interface SATEncoding extends Serializable {
    /**
     * Tries to encode the specified problem into an instance of the specified solver, with a specified maximum plan length
     * @param problem                       the problem a solution of which has to be found
     * @param solver                        the name of the solver used to try solving the problem
     * @param maxPlanLength                 the maximum length of a plan (that is, the maximum number of actions)
     * @return                              a plan that solves the problem, or null if no plan has been found
     * @throws SolverTerminatedException    if the solver has been terminated during the encoding
     */
    Plan solve(Problem problem, IpasirSolver solver, int maxPlanLength) throws SolverTerminatedException;
}
