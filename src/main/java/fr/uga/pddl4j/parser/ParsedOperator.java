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

import java.util.List;

/**
 * This interface defines the methods of all planning operators.
 *
 * @author D. Pellier
 * @version 1.0 - 25.03.2020
 */

public interface ParsedOperator extends ParsedObject {

    /**
     * Returns the name of the operator.
     *
     * @return the name of the operator.
     */
    Symbol<String> getName();

    /**
     * Sets a new name to the operator.
     *
     * @param name the name to set.
     */
    void setName(final Symbol<String> name);

    /**
     * Returns the list of parameters of the operator.
     *
     * @return the list of parameters of the operator.
     */
    List<TypedSymbol<String>> getParameters();

    /**
     * Returns the parameter of the operator that has a specified symbol.
     *
     * @param symbol The symbol.
     * @return the parameter of the operator that has a specified symbol or <code>null</code> if the
     *          operator has no such parameter.
     */
    TypedSymbol<String> getParameter(final Symbol<String> symbol);

    /**
     * Returns the task representation of this operator.
     *
     * @return the task representation of this operator.
     */
    NamedTypedList toTask();

    /**
     * Sets a new list of parameters to this operator.
     *
     * @param parameters The list of parameters to set.
     */
    void setParameters(final List<TypedSymbol<String>> parameters);

    /**
     * Returns the goal description that represents the preconditions of the operator.
     *
     * @return The goal description that represents the preconditions of the operator.
     */
    Expression<String> getPreconditions();

    /**
     * Sets new preconditions to the operator.
     *
     * @param preconditions The new goal description that represents the preconditions of the
     *                      operator to set.
     */
    void setPreconditions(final Expression<String> preconditions);

    /**
     * Return the arity of the operator, i.e., the number of parameters of the operator.
     *
     * @return the arity of the operator.
     */
    int getArity();

    /**
     * Returns the duration constraints of the operator. If the return value is null, it means that that the operator is
     * not durative.
     *
     * @return the duration constraints of the operator.
     */
    Expression<String> getDuration();

    /**
     * Sets new duration constraints to the operator.
     *
     * @param duration the duration constraint to set
     */
    void setDuration(final Expression<String> duration);

    /**
     * Returns if this action is durative operator. If the method return <code>false</code>, the accessor
     * <code>getDuration()</code> returns <code>false</code>.
     *
     * @return <code>true</code> if this operator is a durative, <code>false</code> otherwise.
     */
    boolean isDurative();

}
