package fr.uga.pddl4j.problem.numeric;

/**
 * Created by pellier on 26/10/2020.
 */
public class NumericVariable extends ArithmeticExpression {

    public static final int DURATION = -1;
    /**
     * Create a new numeric variable.
     */
    public NumericVariable(NumericVariable other) {
        super(other);
    }

    /**
     * Create a new numeric variable.
     *
     * @param index the index of this numeric fluent that represents this variable.
     */
    public NumericVariable(int index) {
        super(index);
    }

    /**
     * Creates a new numeric variable for a specified numeric fluent and value.
     *
     * @param index the index of this numeric fluent that represents this variable.
     * @param value the value of the numeric variable.
     */
    public NumericVariable(final int index, final double value) {
        super(index, value);
    }

}
