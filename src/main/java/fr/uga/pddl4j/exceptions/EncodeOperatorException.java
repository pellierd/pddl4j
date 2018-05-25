package fr.uga.pddl4j.exceptions;

/**
 * Created by Gerard on 01/03/2016.
 * Exception use for issues happen when encoding operators
 */
public class EncodeOperatorException extends Exception {

    /**
     * Default constructor with only string message.
     *
     * @param message the error description
     */
    public EncodeOperatorException(String message) {
        super(message);
    }

    /**
     * Default constructor with string message and the Java Throwable cause.
     *
     * @param message the error description
     * @param cause   the cause this trigger the exception
     */
    public EncodeOperatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
