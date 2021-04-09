package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.problem.operator.Condition;

/**
 * This class implements a goal, i.e., a set of positives and negative fluents.
 *
 * @author D. Pellier
 * @version 1.0 - 28.04.2020
 * @since 4.0
 */
public class Goal extends Condition {

    /**
     * Create a new goal from a other goal.
     *
     * @param goal the other goal.
     */
    public Goal(Goal goal) {
        super(goal);
    }

    /**
     *  Create a new goal from a other goal.
     *
     * @param condition the other goal.
     */
    public Goal(Condition condition) {
        super(condition);
    }

    /**
     *  Create a new empty goal from a other goal.
     */
    public Goal() {
        super();
    }
}
