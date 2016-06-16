package fr.uga.pddl4j.exceptions;

/**
 * Created by Gerard on 04/16/2016.
 * Exception use when parsing issues
 */
public class FileException extends Exception {

    /**
     * Default constructor with only string message.
     * @param message the error description
     */
    public FileException(String message) {
        super(message);
    }

    /**
     * Default constructor with string message and the Java Throwable cause.
     * @param message the error description
     * @param cause the cause this trigger the exception
     */
    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
