package fr.uga.pddl4j.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pellier on 10/11/2020.
 */
public class Goal extends ArrayList<Condition> {

    /**
     * Create a new goal from a list of conditions.
     *
     * @param conditions the list of conditions.
     */
    public Goal(List<Condition> conditions) {
        super(conditions);
    }
}
