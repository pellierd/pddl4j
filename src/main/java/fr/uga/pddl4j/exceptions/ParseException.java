package fr.uga.pddl4j.exceptions;

/**
 * Created by Gerard on 04/03/2016.
 * Exception use when parsing issues
 */
public class ParseException extends Exception {

    /**
     * Default constructor with only string message.
     * @param message the error description
     */
    public ParseException(String message) {
        super(message);
    }

    /**
     * Default constructor with string message and the Java Throwable cause.
     * @param message the error description
     * @param cause the cause this trigger the exception
     */
    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
