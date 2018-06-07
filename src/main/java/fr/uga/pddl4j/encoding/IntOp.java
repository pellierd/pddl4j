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

package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.Connective;
import fr.uga.pddl4j.util.AbstractCodedOp;
import fr.uga.pddl4j.util.IntExp;

import java.util.Arrays;

/**
 * This class implements an operator. This class is used to store compact representation of operator
 * during the instantiation process.
 *
 * @author D. Pellier
 * @version 1.0 - 07.04.2010
 */
final class IntOp extends AbstractCodedOp {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The expression that represents the preconditions of the operator.
     */
    private IntExp preconditions;

    /**
     * The expression that represents the effect of the operator.
     */
    private IntExp effects;

    /**
     * Create a new operator from a specified operator. This constructor create a deep copy of the
     * specified operator.
     *
     * @param other the other operator.
     * @throws NullPointerException if other == null.
     */
    public IntOp(final IntOp other) {
        super(other.getName(),
            Arrays.copyOf(other.parameters, other.getArity()),
            Arrays.copyOf(other.instantiations, other.getArity()));
        this.setDummy(other.isDummy());
        this.preconditions = new IntExp(other.getPreconditions());
        this.effects = new IntExp(other.getEffects());
    }

    /**
     * Create a new operator with a specified name.
     *
     * @param name  the name of the operator.
     * @param arity the arity of the operator.
     * @throws NullPointerException     if name == null.
     * @throws IllegalArgumentException if arity < 0.
     */
    public IntOp(final String name, final int arity) {
        super(name, arity);
        if (arity < 0) {
            throw new IllegalArgumentException("arity < 0");
        }
        this.parameters = new int[arity];
        Arrays.fill(this.parameters, -1);
        this.instantiations = new int[arity];
        Arrays.fill(this.instantiations, -1);
        this.preconditions = new IntExp(Connective.OR);
        this.effects = new IntExp(Connective.OR);
    }

    /**
     * Return if the operator is ready instantiate with the specified value.
     *
     * @param value the value.
     * @return <code>true</code> if the operator is ready instantiate with the specified value; <code>false</code>
     *          otherwise.
     */
    public final boolean isAlreadyInstantiatedWith(final int value) {
        int i = 0;
        boolean instantiated = false;
        while (i < this.instantiations.length && !instantiated) {
            if (this.instantiations[i] == value) {
                instantiated = true;
            }
            i++;
        }
        return instantiated;
    }

    /**
     * Return the preconditions of the operator.
     *
     * @return the preconditions of the operator.
     */
    public final IntExp getPreconditions() {
        return this.preconditions;
    }

    /**
     * Set the precondition of the operator.
     *
     * @param preconditions the preconditions to set.
     * @throws NullPointerException if preconditions == null.
     */
    public final void setPreconditions(final IntExp preconditions) {
        if (preconditions == null) {
            throw new NullPointerException("preconditions == null");
        }
        this.preconditions = preconditions;
    }

    /**
     * Return the effects of the operator.
     *
     * @return the effects of the operator.
     */
    public final IntExp getEffects() {
        return this.effects;
    }

    /**
     * Set the new effects of the operator.
     *
     * @param effects the effects to set
     * @throws NullPointerException if preconditions == null.
     */
    public final void setEffects(final IntExp effects) {
        if (effects == null) {
            throw new NullPointerException("effects == null");
        }
        this.effects = effects;
    }

    /**
     * Return if the operator is equal to another object.
     *
     * @param obj the other object.
     * @return <code>true</code> if the specified object is an instance of the class Op and
     *          it has the same name and instantiated parameters; otherwise <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof IntOp) {
            final IntOp other = (IntOp) obj;
            return this.name.equals(other.name) && Arrays.equals(this.instantiations, other.instantiations);
        }
        return false;
    }

    /**
     * Return the hash code value of the operator.
     *
     * @return the hash code value of the operator.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(instantiations);
        result = prime * result + name.hashCode();
        return result;
    }

}
