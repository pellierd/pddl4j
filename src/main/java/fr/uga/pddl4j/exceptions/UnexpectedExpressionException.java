package fr.uga.pddl4j.exceptions;

/**
 * Created by Gerard on 03/03/2016.
 * Exception use for issues with unexpected expression
 */
public class UnexpectedExpressionException extends Exception {

    /**
     * Default constructor with only string message.
     *
     * @param message the error description
     */
    public UnexpectedExpressionException(String message) {
        super(message);
    }

    /**
     * Default constructor with string message and the Java Throwable cause.
     *
     * @param message the error description
     * @param cause   the cause this trigger the exception
     */
    public UnexpectedExpressionException(String message, Throwable cause) {
        super(message, cause);
    }
}
