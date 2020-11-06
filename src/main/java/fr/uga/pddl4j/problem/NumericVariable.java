package fr.uga.pddl4j.problem;

/**
 * Created by pellier on 26/10/2020.
 */
public class NumericVariable extends ArithmeticExpression {

    /**
     * Create a new numeric variable.
     */
    public NumericVariable(int index) {
        super(index);
    }

    /**
     * Create a new numeric variable.
     */
    public NumericVariable(NumericVariable other) {
        super(other);
    }


}
