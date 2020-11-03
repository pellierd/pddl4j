package fr.uga.pddl4j.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pellier on 28/10/2020.
 */
public class Goal extends Precondition {

    /**
     * The list of numeric variables of the operator.
     */
    private List<NumericVariable> numericVariables;

    /**
     * Creates a new goal. By default the goal has no positive and no negative fluents.
     */
    public Goal() {
        super();
        this.setNumericVariables(new ArrayList<>());

    }

    /**
     * Creates a new goal from an other one. This constructor create a deep copy of the object in
     * parameter.
     *
     * @param other the other one.
     */
    public Goal(final Goal other) {
        super(other);
        this.numericVariables = new ArrayList<>();
        this.numericVariables.addAll(other.getNumericVariables().stream().map(NumericVariable::new)
            .collect(Collectors.toList()));
    }

    /**
     * Creates a new goal from a specified positive and negative timed fluent description.
     *
     * @param positive the positive timed description of fluent description.
     * @param negative the positive timed description of fluent description.
     * @see TimedFluentDescription
     */
    public Goal(final TimedFluentDescription positive, final TimedFluentDescription negative) {
       super(positive, negative);
    }

    /**
     * Returns the numeric variables of this goal.
     *
     * @return the numeric variables of this goal.
     */
    public final List<NumericVariable> getNumericVariables() {
        return this.numericVariables;
    }

    /**
     * Sets the numeric variables of this goal.
     *
     * @param variables the numeric variables of this goal.
     */
    public void setNumericVariables(final List<NumericVariable> variables) {
        this.numericVariables = variables;
    }

}
