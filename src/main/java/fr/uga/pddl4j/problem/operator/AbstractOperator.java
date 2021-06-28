/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.problem.operator;

/**
 * This abstract class implements the common part of an operator (action of method) with bitset representation.
 *
 * @author D. Pellier
 * @version 1.0 - 07.06.2010
 */
public abstract class AbstractOperator extends AbstractGroundOperator {

    /**
     * The precondition of the operator.
     */
    private Condition precondition;

    /**
     * Creates a new operator from an other.
     *
     * @param other the other operator.
     */
    protected AbstractOperator(final AbstractOperator other) {
        super(other);
        this.precondition = other.getPrecondition();
    }

    /**
     * Creates a new operator.
     *
     * @param name  the name of the operator.
     * @param arity the arity of the operator.
     */
    protected AbstractOperator(final String name, final int arity) {
        super(name, arity);
        this.precondition = new Condition();
    }

    /**
     * Creates a new operator. The length of the parameters and the length of instantiations must be the same.
     *
     * @param name           the name of the operator.
     * @param parameters     the types of the parameters.
     * @param instantiations the values of the parameters.
     * @param preconditions  the precondition of the operator.
     */
    protected AbstractOperator(final String name, final int[] parameters, final int[] instantiations,
                               final Condition preconditions) {
        super(name, parameters, instantiations);
        this.precondition = preconditions;
    }

    /**
     * Return the precondition of the operator.
     *
     * @return the precondition of the operator.
     */
    public final Condition getPrecondition() {
        return this.precondition;
    }

    /**
     * Set the precondition of the operator.
     *
     * @param precondition the precondition to set.
     */
    public final void setPrecondition(final Condition precondition) {
        this.precondition = precondition;
    }
}


