package fr.uga.pddl4j.problem;

/**
 * Created by pellier on 10/11/2020.
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
