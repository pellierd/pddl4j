/*
 * Copyright (c) 2010-2012 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.parser;

import fr.uga.pddl4j.exceptions.FatalException;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class implements a planning operator parsed.
 * <p>
 * Modifications:
 * </p>
 * <ul>
 * <li> Add method normalize(int i) - 11.12.2012.</li>
 * <li> Add constructor of copy - 11.12.2012.</li>
 * </ul>
 *
 * @author D. Pellier
 * @version 1.1 - 28.01.2010
 */
public class Op implements Serializable {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The name of the operator.
     */
    private Symbol name;

    /**
     * The list of parameters of the operators.
     */
    private List<TypedSymbol> parameters;

    /**
     * The goal description that represents the preconditions of the operator.
     */
    private Exp preconditions;

    /**
     * The goal description that represents the effects of the operator.
     */
    private Exp effects;

    /**
     * The goal description that represents the constraints duration of temporal operator.
     */
    private Exp duration;

    /**
     * Create a new operator.
     */
    private Op() {
        super();
        this.name = null;
        this.parameters = null;
        this.preconditions = null;
        this.effects = null;
        this.duration = null;
    }

    /**
     * Create a new operator from another.
     *
     * @param other the other operator.
     */
    public Op(final Op other) {
        if (other == null) {
            throw new NullPointerException();
        }
        this.name = new Symbol(other.getName());
        this.parameters = new LinkedList<>();
        this.parameters.addAll(other.getParameters().stream().map(TypedSymbol::new).collect(Collectors.toList()));
        this.preconditions = new Exp(other.getPreconditions());
        this.effects = new Exp(other.getEffects());
        if (this.duration != null) {
            this.duration = new Exp(other.getDuration());
        }
    }

    /**
     * Creates operator with a specified name, list of parameters, preconditions and effects.
     *
     * @param name       The name of the operator.
     * @param parameters The list of parameters of the operator.
     * @param preconds   The goal description that represents the preconditions of the operator.
     * @param effects    The goal description that represents the effects of the operator.
     */
    public Op(final Symbol name, final List<TypedSymbol> parameters, final Exp preconds, final Exp effects) {
        this(name, parameters, preconds, effects, null);
    }

    /**
     * Creates operator with a specified name, list of parameters, preconditions and effects.
     *
     * @param name          The name of the operator.
     * @param parameters    The list of parameters of the operator.
     * @param preconditions The goal description that represents the preconditions of the operator.
     * @param effects       The goal description that represents the effects of the operator.
     * @param duration      The goal description that represents the duration constraints of the
     *                      operator.
     * @throws NullPointerException if the specified name, parameters, preconditions or effects are
     *                              null.
     */
    public Op(final Symbol name, final List<TypedSymbol> parameters, final Exp preconditions, final Exp effects,
              final Exp duration) {
        this();
        if (name == null || parameters == null || preconditions == null || effects == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.parameters = parameters;
        this.preconditions = preconditions;
        this.effects = effects;
        this.duration = duration;
    }

    /**
     * Returns the name of the operator.
     *
     * @return the name of the operator.
     */
    public final Symbol getName() {
        return this.name;
    }

    /**
     * Sets a new name to the operator.
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
     * Returns the list of parameters of the operator.
     *
     * @return the list of parameters of the operator.
     */
    public final List<TypedSymbol> getParameters() {
        return this.parameters;
    }

    /**
     * Returns the parameter of the operator that has a specified symbol.
     *
     * @param symbol The symbol.
     * @return the parameter of the operator that has a specified symbol or <code>null</code> if the
     *          operator has no such parameter.
     */
    public final TypedSymbol getParameter(final Symbol symbol) {
        final int index = this.parameters.indexOf(symbol);
        return (index == -1) ? null : this.parameters.get(index);
    }

    /**
     * Sets a new list of parameters to this operator.
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
     * Returns the goal description that represents the preconditions of the operator.
     *
     * @return The goal description that represents the preconditions of the operator.
     */
    public final Exp getPreconditions() {
        return this.preconditions;
    }

    /**
     * Sets new preconditions to the operator.
     *
     * @param preconditions The new goal description that represents the preconditions of the
     *                      operator to set.
     * @throws NullPointerException if the specified preconditions is null.
     */
    public final void setPreconditions(final Exp preconditions) {
        if (preconditions == null) {
            throw new NullPointerException();
        }
        this.preconditions = preconditions;
    }

    /**
     * Returns the goal description that represents the effects of the operator.
     *
     * @return The goal description that represents the effects of the operator.
     */
    public final Exp getEffects() {
        return this.effects;
    }

    /**
     * Sets new effects to the operator.
     *
     * @param effects he new goal description that represents the effects of the operator to set.
     * @throws NullPointerException if the specified effects is null.
     */
    public final void setEffects(final Exp effects) {
        if (effects == null) {
            throw new NullPointerException();
        }
        this.effects = effects;
    }

    /**
     * Returns the goal description that represents the duration constraints of the operator.
     *
     * @return the goal description that represents the duration constraints of the operator.
     */
    public final Exp getDuration() {
        return this.duration;
    }

    /**
     * Sets new duration constraints to the operator.
     *
     * @param duration the duration constraint to set
     */
    public final void setDuration(final Exp duration) {
        this.duration = duration;
    }

    /**
     * Normalizes the operators.
     *
     * @see Exp#renameVariables()
     * @see Exp#moveNegationInward()
     */
    public void normalize() throws FatalException {
        this.normalize(0);
    }

    /**
     * Normalizes the operators.
     *
     * @param index the index of the first variable, index.e., ?Xi.
     * @see Exp#renameVariables()
     * @see Exp#moveNegationInward()
     */
    public void normalize(int index) throws FatalException {
        int i = index;
        // Rename the parameters
        final Map<String, String> context = new LinkedHashMap<>();
        final List<TypedSymbol> parameters = this.getParameters();
        for (final TypedSymbol params : parameters) {
            final String image = params.renameVariables(i);
            context.put(image, params.getImage());
            i++;
        }
        // A hack to remove single atom in precondition
        if (this.preconditions.isLiteral()) {
            Exp atom = this.preconditions;
            this.preconditions = new Exp(Connective.AND);
            this.preconditions.addChild(atom);
        }
        // Rename the preconditions
        this.getPreconditions().renameVariables(context);
        this.getPreconditions().moveNegationInward();
        // Rename the effects
        // A hack to remove single atom in precondition
        if (this.effects.isLiteral()) {
            Exp atom = this.effects;
            this.effects = new Exp(Connective.AND);
            this.effects.addChild(atom);
        }
        this.getEffects().renameVariables(context);
        this.getEffects().moveNegationInward();
        // Rename the duration if the operator is a durative action.
        if (this.getDuration() != null) {
            this.getDuration().renameVariables(context);
        }
    }

    /**
     * Return the arity of the operator, i.e., the number of parameters of the operator.
     *
     * @return the arity of the operator.
     */
    public final int getArity() {
        return this.parameters.size();
    }

    /**
     * Return if this operator is equals to another object.
     *
     * @param object the other object.
     * @return <code>true</code> if <code>object</code> is not <code>null</code>, is an instance of
     *          the class <code>Op</code>, and has the same name; otherwise it returns <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof Op) {
            final Op other = (Op) object;
            return this.name.equals(other.name);
        }
        return false;
    }

    /**
     * Returns the hash code value of the operator.
     *
     * @return the hash code value of the operator.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Returns a PDDL string representation of the operator.
     *
     * @return a string PDDL representation of the operator.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        if (this.duration == null) {
            str.append("(:action ");
        } else {
            str.append("(:durative-action ");
        }
        str.append(this.name.toString()).append("\n").append(":parameters (");
        for (int i = 0; i < this.parameters.size() - 1; i++) {
            str.append(this.parameters.get(i)).append(" ");
        }
        if (!this.parameters.isEmpty()) {
            str.append(this.parameters.get(this.parameters.size() - 1).toString());
        }
        str.append(")");
        if (this.duration != null) {
            str.append("\n:duration ").append("\n  ").append(this.duration.toString()).append("\n:condition ");
        } else {
            str.append("\n:precondition ");
        }
        str.append("\n  ").append(this.preconditions.toString()).append("\n:effect ").append("\n  ")
            .append(this.effects.toString()).append("\n)");
        return str.toString();
    }
}
