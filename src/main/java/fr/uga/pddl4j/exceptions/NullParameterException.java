package fr.uga.pddl4j.exceptions;

/**
 * Created by Gerard on 03/03/2016.
 * Exception use for issues happen when encoding operators
 */
public class NullParameterException extends Exception {

    /**
     * Default constructor with only string message.
     *
     * @param message the error description
     */
    public NullParameterException(String message) {
        super(message);
    }

    /**
     * Default constructor with string message and the Java Throwable cause.
     *
     * @param message the error description
     * @param cause   the cause this trigger the exception
     */
    public NullParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
