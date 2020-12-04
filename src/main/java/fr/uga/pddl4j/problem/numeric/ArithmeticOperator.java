package fr.uga.pddl4j.problem.numeric;

/**
 * This enum defines the arithmetic operators.
 *
 * @author D. Pellier
 * @version 1.0 - 27.10.2020
 * @since 4.0
 */
public enum ArithmeticOperator {

    /**
     * The addition arithmetic operator.
     */
    PLUS("+"),

    /**
     * The binary subtraction arithmetic operator.
     */
    MINUS("-"),

    /**
     * The unary subtraction arithmetic operator.
     */
    UMINUS("-"),

    /**
     * The arithmetic operator of division.
     */
    DIV("/"),

    /**
     * The arithmetic operator of multiplication.
     */
    MUL("*");

    /**
     * The image associate to the time specifier.
     */
    private String image;

    /**
     * Create a new arithmetic operator with a specific image.
     *
     * @param image the image of the arithmetic operator. The image of the arithmetic operator must be not null.
     */
    ArithmeticOperator(final String image) {
        this.image = image;
    }

    /**
     * Returns the image of this arithmetic operator.
     *
     * @return the image of this arithmetic operator.
     */
    public String getImage() {
        return this.image;
    }

}
