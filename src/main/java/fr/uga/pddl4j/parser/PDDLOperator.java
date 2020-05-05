/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
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

import java.io.Serializable;
import java.util.List;

/**
 * This interface defines the methods of all planning operators.
 *
 * @author D. Pellier
 * @version 1.0 - 25.03.2020
 */

public interface PDDLOperator extends Serializable {

    /**
     * Returns the name of the operator.
     *
     * @return the name of the operator.
     */
    PDDLSymbol getName();

    /**
     * Sets a new name to the operator.
     *
     * @param name the name to set.
     */
    void setName(final PDDLSymbol name);

    /**
     * Returns the list of parameters of the operator.
     *
     * @return the list of parameters of the operator.
     */
    List<PDDLTypedSymbol> getParameters();

    /**
     * Returns the parameter of the operator that has a specified symbol.
     *
     * @param symbol The symbol.
     * @return the parameter of the operator that has a specified symbol or <code>null</code> if the
     *          operator has no such parameter.
     */
    PDDLTypedSymbol getParameter(final PDDLSymbol symbol);

    /**
     * Returns the task representation of this operator.
     *
     * @return the task representation of this operator.
     */
    PDDLNamedTypedList toTask();

    /**
     * Sets a new list of parameters to this operator.
     *
     * @param parameters The list of parameters to set.
     */
    void setParameters(final List<PDDLTypedSymbol> parameters);

    /**
     * Returns the goal description that represents the preconditions of the operator.
     *
     * @return The goal description that represents the preconditions of the operator.
     */
    PDDLExpression getPreconditions();

    /**
     * Sets new preconditions to the operator.
     *
     * @param preconditions The new goal description that represents the preconditions of the
     *                      operator to set.
     */
    void setPreconditions(final PDDLExpression preconditions);

    /**
     * Return the arity of the operator, i.e., the number of parameters of the operator.
     *
     * @return the arity of the operator.
     */
    int getArity();

    /**
     * Normalizes the operators.
     *
     * @see PDDLExpression#renameVariables()
     * @see PDDLExpression#moveNegationInward()
     */
    void normalize();

}
