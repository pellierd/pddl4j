package fr.uga.pddl4j.heuristics;

import fr.uga.pddl4j.encoding.IProblem;
import fr.uga.pddl4j.problem.Goal;
import fr.uga.pddl4j.problem.State;

import java.io.Serializable;

/**
 * This interface defines the methods accessible from all goal cost heuristics. An goal cost heuristic is a function
 * that estimates the remaining distance to the goal. In order to find this estimation an heuristic
 * function tries to solve a relaxed problem.
 * <p>
 * To have an good overview of the planning heuristics developed in this package see D. Bryce and S.
 * Kambhampati. "A Tutorial on Planning Graph Based Reachability Heuristics", 2006.
 * </p>
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
public interface GoalCostHeuristic extends Serializable {

    /**
     * Return the estimated distance to the goal to reach the specified state. If the return value is
     * <code>Double.POSITIVE_INFINITY</code>, it means that the goal is unreachable from the specified
     * state.
     *
     * @param state the state from which the distance to the goal must be estimated.
     * @param goal  the goal expression.
     * @return the distance to the goal state from the specified state.
     */
    double estimate(final State state, final Goal goal);

    /**
     * Returns <code>true</code> if this heuristic is admissible.
     *
     * @return <code>true</code> if this heuristic is admissible; <code>false</code> otherwise.
     */
    boolean isAdmissible();

    /**
     * Returns the problem addressed by the heuristic.
     *
     * @return the problem addressed by the heuristic.
     */
    IProblem getProblem();

}
