package fr.uga.pddl4j.parser;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Method implements Serializable {
    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;
    /**
     * The name of the method.
     */
    private Symbol name;
    /**
     * The list of parameters of the method.
     */
    private List<TypedSymbol> parameters;
    /**
     * The tasks of the method.
     */
    private Exp tasks;
    /**
     * The constraints of the method.
     */
    private Exp constraints;

    /**
     * Create a new method.
     */
    private Method() {
        super();
        this.name = null;
        this.parameters = null;
        this.tasks = null;
        this.constraints = null;
    }

    /**
     * Create a new method from another.
     *
     * @param other the other method.
     */
    public Method(final Method other) {
        if (other == null) {
            throw new NullPointerException();
        }
        this.name = new Symbol(other.getName());
        this.parameters = new LinkedList<>();
        this.parameters.addAll(other.getParameters().stream().map(TypedSymbol::new).collect(Collectors.toList()));
        this.tasks = new Exp(other.getTasks());
        this.constraints = new Exp(other.getConstraints());
    }

    /**
     * Creates method with a specified name, list of parameters...
     *
     * @param name          The name of the method.
     * @param parameters    The list of the method parameters.
     * @param tasks         The expansion (list of tasks) of the method.
     * @throws NullPointerException if the specified name is null.
     */
    public Method(final Symbol name, final List<TypedSymbol> parameters, Exp tasks, Exp constraints) {
        this();
        if (name == null || parameters == null || tasks == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.parameters = parameters;
        this.tasks = tasks;
        this.constraints = constraints;
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
     * Returns the list of parameters of the method.
     *
     * @return the list of parameters of the method.
     */
    public final List<TypedSymbol> getParameters() {
        return this.parameters;
    }

    /**
     * Returns the parameter of the method that has a specified symbol.
     *
     * @param symbol The symbol.
     * @return the parameter of the method that has a specified symbol or <code>null</code> if the
     *          method has no such parameter.
     */
    public final TypedSymbol getParameter(final Symbol symbol) {
        final int index = this.parameters.indexOf(symbol);
        return (index == -1) ? null : this.parameters.get(index);
    }

    /**
     * Sets a new list of parameters to this method.
     *
     * @param parameters The list of parameters to set.
     * @throws NullPointerException if the specified parameters is null.
     */
    public final void setParameters(final List<TypedSymbol> parameters) {
        if (parameters == null) {
            throw new NullPointerException();
        }
        this.parameters = parameters;
    }

    /**
     * Returns the expansion of the method.
     *
     * @return the method tasks.
     */
    public Exp getTasks() {
        return tasks;
    }

    /**
     *  Sets the expansion of the method.
     *
     *  @param tasks The tasks of the method.
     */
    public void setTasks(Exp tasks) {
        this.tasks = tasks;
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
        str.append(this.name.toString()).append("\n").append("\t:parameters (");
        for (int i = 0; i < this.parameters.size() - 1; i++) {
            str.append(this.parameters.get(i)).append(" ");
        }
        if (!this.parameters.isEmpty()) {
            str.append(this.parameters.get(this.parameters.size() - 1).toString());
        }
        str.append(")\n");
        str.append(")");
        return str.toString();
    }

    /**
     * Returns the method constraints.
     *
     * @return the method constraints.
     */
    public Exp getConstraints() {
        return constraints;
    }

    /**
     * Sets the method constraints.
     *
     * @param constraints The method constraints
     */
    public void setConstraints(Exp constraints) {
        this.constraints = constraints;
    }
}
