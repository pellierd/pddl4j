package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.problem.numeric.NumericVariable;
import fr.uga.pddl4j.problem.operator.AbstractFluentDescription;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pellier on 07/11/2020.
 */
public class InitialState extends AbstractFluentDescription {

    /**
     * The list numeric variables and their values.
     */
    private List<NumericVariable> numericFluents;

    /**
     * Creates a new initial state from a other initial state.
     *
     * @param other the other initiam state.
     */
    public InitialState(final InitialState other) {
        super(other);
        this.numericFluents = new ArrayList<>();
        this.numericFluents.addAll(other.getNumericFluents().stream().map(NumericVariable::new)
            .collect(Collectors.toList()));
    }

    /**
     * Creates a new empty initial state.
     */
    public InitialState() {
        super();
        this.numericFluents = new ArrayList<>();
    }

    /**
     * Returns the list of numeric fluents of this initial state.
     *
     * @return the list of numeric fluents of this initial state.
     */
    public final List<NumericVariable> getNumericFluents() {
        return this.numericFluents;
    }

    /**
     * Sets the numeric fluents of the initial state.
     *
     * @param fluents the numeric fluents of the state.
     */
    public final void setNumericFluents(List<NumericVariable> fluents) {
        this.numericFluents = fluents;
    }

    /**
     * Adds a numeric fluent to the initial state.
     *
     * @param fluent the fluent to add.
     */
    public void addNumericFluent(NumericVariable fluent) {
        this.numericFluents.add(fluent);
    }

}
