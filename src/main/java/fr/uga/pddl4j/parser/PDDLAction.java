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
    private PDDLExpression effects;

    /**
     * The goal description that represents the constraints duration of temporal operator.
     */
    private PDDLExpression duration;

    /**
     * Create a new operator from another.
     *
     * @param other the other operator.
     */
    public PDDLAction(final PDDLAction other) {
        super(other);
        this.effects = new PDDLExpression(other.getEffects());
        if (this.duration != null) {
            this.duration = new PDDLExpression(other.getDuration());
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
    public PDDLAction(final PDDLSymbol name, final List<PDDLTypedSymbol> parameters, final PDDLExpression preconds,
                      final PDDLExpression effects) {
        this(name, parameters, preconds, effects, null);
    }

    /**
     * Creates operator with a specified name, list of parameters, preconditions and effects.
     *
     * @param name The name of the operator.
     * @param parameters The list of parameters of the operator.
     * @param preconditions The goal description that represents the preconditions of the operator.
     * @param effects The goal description that represents the effects of the operator.
     * @param duration The goal description that represents the duration constraints of the
     *                      operator.
     * @throws NullPointerException if the specified name, parameters, preconditions or effects are null.
     */
    public PDDLAction(final PDDLSymbol name, final List<PDDLTypedSymbol> parameters, final PDDLExpression preconditions,
                      final PDDLExpression effects, final PDDLExpression duration) {
        super(name, parameters, preconditions);
        this.effects = effects;
        this.duration = duration;
    }


    /**
     * Returns the goal description that represents the effects of the operator.
     *
     * @return The goal description that represents the effects of the operator.
     */
    public final PDDLExpression getEffects() {
        return this.effects;
    }

    /**
     * Sets new effects to the operator.
     *
     * @param effects he new goal description that represents the effects of the operator to set.
     * @throws NullPointerException if the specified effects is null.
     */
    public final void setEffects(final PDDLExpression effects) {

        this.effects = effects;
    }

    /**
     * Returns the goal description that represents the duration constraints of the operator.
     *
     * @return the goal description that represents the duration constraints of the operator.
     */
    public final PDDLExpression getDuration() {
        return this.duration;
    }

    /**
     * Sets new duration constraints to the operator.
     *
     * @param duration the duration constraint to set
     */
    public final void setDuration(final PDDLExpression duration) {
        this.duration = duration;
    }

    /**
     * Returns if this action is durative action.
     *
     * @return <code>true</code> if this action is a durative action, <code>false</code> otherwise.
     */
    public final boolean isDurative() {
        return this.getDuration() != null;
    }

    /**
     * Normalizes the operators.
     *
     * @param index the index of the first variable, index, i.e., ?Xi.
     * @return the renamed variable.
     * @see PDDLExpression#renameVariables()
     * @see PDDLExpression#moveNegationInward()
     */
    protected Map<String, String> normalize(int index) {
        final Map<String, String> context = super.normalize(index);
        // Rename the effects
        // A hack to remove single atom in precondition
        if (this.effects.isLiteral()) {
            PDDLExpression atom = this.effects;
            this.effects = new PDDLExpression(PDDLConnective.AND);
            this.effects.addChild(atom);
        }
        this.getEffects().renameVariables(context);
        this.getEffects().moveNegationInward();
        // Rename the duration if the operator is a durative action.
        if (this.getDuration() != null) {
            this.getDuration().renameVariables(context);
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
        if (this.duration == null) {
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
        if (this.duration != null) {
            str.append("\n  :duration ").append("\n  ").append(this.duration.toString("  ")).append("\n  :condition ");
        } else {
            str.append("\n  :precondition ");
        }
        str.append("\n  ").append(this.getPreconditions().toString("  ")).append("\n  :effect ").append("\n  ")
            .append(this.effects.toString("  ")).append("\n)");
        return str.toString();
    }
}
