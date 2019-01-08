package fr.uga.pddl4j.parser;

import java.io.Serializable;

public class Method implements Serializable {
    /**
     * The name of the method.
     */
    private Symbol name;

    /**
     * Create a new method.
     */
    private Method() {
        super();
        this.name = null;
    }

    /**
     * Creates method with a specified name.
     *
     * @param name          The name of the method.
     * @throws NullPointerException if the specified name is null.
     */
    public Method(final Symbol name) {
        this();
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    /**
     * Returns the name of the method.
     *
     * @return the name of the method.
     */
    public final Symbol getName() {
        return this.name;
    }

    /**
     * Sets a new name to the method.
     *
     * @param name the name to set.
     */
    public final void setName(final Symbol name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    /**
     * Returns the hash code value of the method.
     *
     * @return the hash code value of the method.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Returns a PDDL string representation of the method.
     *
     * @return a string PDDL representation of the method.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("(:method ");
        str.append(this.name.toString()).append("\n");
        str.append(")");
        return str.toString();
    }
}
