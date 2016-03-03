package fr.uga.pddl4j.exceptions;

/**
 * Created by Gerard on 03/03/2016.
 * Exception use to stop pddl4j when fatal error occurred
 */
public class FatalException extends RuntimeException {

    /**
     * Default constructor with only string message.
     * @param message the error description
     */
    public FatalException(String message) {
        super(message);
    }

    /**
     * Default constructor with string message and the Java Throwable cause.
     * @param message the error description
     * @param cause the cause this trigger the exception
     */
    public FatalException(String message, Throwable cause) {
        super(message, cause);
    }
}
