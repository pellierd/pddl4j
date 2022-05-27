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

import java.util.List;
import java.util.Map;

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
public class PDDLAction extends PDDLAbstractOperator {

    /**
     * The goal description that represents the effects of the operator.
     */
    private Expression<String> effects;

    /**
     * Create a new operator from another.
     *
     * @param other the other operator.
     */
    public PDDLAction(final PDDLAction other) {
        super(other);
        this.effects = new Expression<String>(other.getEffects());
    }

    /**
     * Creates operator with a specified name, list of parameters, preconditions and effects.
     *
     * @param name       The name of the operator.
     * @param parameters The list of parameters of the operator.
     * @param preconds   The goal description that represents the preconditions of the operator.
     * @param effects    The goal description that represents the effects of the operator.
     */
    public PDDLAction(final Symbol<String> name, final List<TypedSymbol<String>> parameters, final Expression<String> preconds,
                      final Expression<String> effects) {
        this(name, parameters, preconds, effects, null);
    }

    /**
     * Creates operator with a specified name, list of parameters, preconditions and effects.
     *
     * @param name The name of the operator.
     * @param parameters The list of parameters of the operator.
     * @param preconditions The goal description that represents the preconditions of the operator.
     * @param effects The goal description that represents the effects of the operator.
     * @param duration The description that represents the duration constraints of the
     *                      operator.
     * @throws NullPointerException if the specified name, parameters, preconditions or effects are null.
     */
    public PDDLAction(final Symbol<String> name, final List<TypedSymbol<String>> parameters, final Expression<String> preconditions,
                      final Expression<String> effects, final Expression<String> duration) {
        super(name, parameters, preconditions, duration);
        this.effects = effects;
    }


    /**
     * Returns the goal description that represents the effects of the operator.
     *
     * @return The goal description that represents the effects of the operator.
     */
    public final Expression<String> getEffects() {
        return this.effects;
    }

    /**
     * Sets new effects to the operator.
     *
     * @param effects he new goal description that represents the effects of the operator to set.
     * @throws NullPointerException if the specified effects is null.
     */
    public final void setEffects(final Expression<String> effects) {
        this.effects = effects;
    }

    /**
     * Normalizes the operators. This method renames the parameters of the operator used in its preconditions, its
     * effects and its durative constraints. It also simplifies all the logical expression and converts it into it
     * negative normal form. Not that imply expression are also replace by their disjunctive equivalence.
     *
     * @param index the index of the first variable, index, i.e., ?Xi.
     * @return the renamed variable.
     * @see Expression<String>#renameVariables(Expression
     * @see Expression<String>#simplify()
     * @see Expression<String>#toNNF() ()
     */
    protected Map<String, String> normalize(int index) {
        final Map<String, String> context = super.normalize(index);
        Expression.renameVariables(this.getEffects(), context);
        this.getEffects().simplify();
        this.getEffects().toNNF();
        // Rename the duration if the operator is a durative action.
        if (this.getDuration() != null) {
            Expression.renameVariables(this.getDuration(), context);
        }
        return context;
    }

    /**
     * Returns a PDDL string representation of the operator.
     *
     * @return a string PDDL representation of the operator.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        if (!super.isDurative()) {
            str.append("(:action ");
        } else {
            str.append("(:durative-action ");
        }
        str.append(this.getName().toString()).append("\n").append("  :parameters (");
        for (int i = 0; i < this.getParameters().size() - 1; i++) {
            str.append(this.getParameters().get(i)).append(" ");
        }
        if (!this.getParameters().isEmpty()) {
            str.append(this.getParameters().get(this.getParameters().size() - 1).toString());
        }
        str.append(")");
        if (super.isDurative()) {
            str.append("\n  :duration ");
            str.append("\n  ");
            str.append(this.getDuration().toString("  "));
            str.append("\n  :condition ");
        } else {
            str.append("\n  :precondition ");
        }
        str.append("\n  ");
        str.append(this.getPreconditions().toString("  "));
        str.append("\n  :effect ");
        str.append("\n  ");
        str.append(this.effects.toString("  "));
        str.append("\n)");
        return str.toString();
    }
}
