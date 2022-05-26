package fr.uga.pddl4j.parser;

import fr.uga.pddl4j.parser.lexer.Token;

public interface Locatable {

    /**
     * Returns the location of the object.
     */
    Location getLocation();

    /**
     * Sets the begin line and column of the expression from a specified token.
     *
     * @param begin the first token of the expression.
     */
    void setBegin(final Token begin);

    /**
     * Sets the end line and column of the expression from a specified token.
     *
     * @param end the last token of the expression.
     */
    void setEnd(final Token end);
}
