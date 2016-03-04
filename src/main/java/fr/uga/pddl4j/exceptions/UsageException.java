package fr.uga.pddl4j.exceptions;

/**
 * Created by Gerard on 04/03/2016.
 * Exception use for call that do not respect method contract
 */
public class UsageException extends Exception {

    /**
     * Default constructor with only string message.
     * @param message the error description
     */
    public UsageException(String message) {
        super(message);
    }

    /**
     * Default constructor with string message and the Java Throwable cause.
     * @param message the error description
     * @param cause the cause this trigger the exception
     */
    public UsageException(String message, Throwable cause) {
        super(message, cause);
    }
}
