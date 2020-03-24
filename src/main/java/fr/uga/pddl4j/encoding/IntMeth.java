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
 * This class implements an method. This class is used to store compact representation of method
 * during the instantiation process.
 *
 * @author D. Pellier
 * @version 1.0 - 14.02.2020
 */
final class IntMeth extends AbstractCodedOp {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The expression that represents the preconditions of the method.
     */
    private IntExp preconditions;

    /**
     * The expression that represents the list of tasks of the method.
     */
    private IntExp tasks;

    /**
     * The expression that represents the ordering constraints of the method.
     */
    private IntExp orderingConstraints;

    /**
     * Create a new method from a specified method. This constructor create a deep copy of the
     * specified method.
     *
     * @param other the other method.
     * @throws NullPointerException if other == null.
     */
    public IntMeth(final IntMeth other) {
        super(other.getName(),
            Arrays.copyOf(other.parameters, other.getArity()),
            Arrays.copyOf(other.instantiations, other.getArity()));
        this.setDummy(other.isDummy());
        this.preconditions = new IntExp(other.getPreconditions());
        this.tasks = new IntExp(other.getTasks());
        this.orderingConstraints = new IntExp(other.getOrderingConstraints());
    }

    /**
     * Create a new method with a specified name.
     *
     * @param name  the name of the method.
     * @param arity the arity of the method.
     * @throws NullPointerException     if name == null.
     * @throws IllegalArgumentException if arity < 0.
     */
    public IntMeth(final String name, final int arity) {
        super(name, arity);
        if (arity < 0) {
            throw new IllegalArgumentException("arity < 0");
        }
        this.parameters = new int[arity];
        Arrays.fill(this.parameters, -1);
        this.instantiations = new int[arity];
        Arrays.fill(this.instantiations, -1);
        this.preconditions = new IntExp(Connective.OR);
        this.tasks = new IntExp(Connective.AND);
        this.orderingConstraints = new IntExp(Connective.OR);
    }

    /**
     * Return if the method is ready instantiate with the specified value.
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
     * Return the preconditions of the method.
     *
     * @return the preconditions of the method.
     */
    public final IntExp getPreconditions() {
        return this.preconditions;
    }

    /**
     * Set the precondition of the method.
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
     * Return the tasks of the method.
     *
     * @return the tasks of the method.
     */
    public final IntExp getTasks() {
        return this.tasks;
    }

    /**
     * Set the tasks of the method.
     *
     * @param tasks the tasks to set.
     * @throws NullPointerException if preconditions == null.
     */
    public final void setTasks(final IntExp tasks) {
        if (tasks == null) {
            throw new NullPointerException("tasks == null");
        }
        this.tasks = tasks;
    }

    /**
     * Return the ordering constraints of the method.
     *
     * @return the ordering constraints of the method.
     */
    public final IntExp getOrderingConstraints() {
        return this.orderingConstraints;
    }

    /**
     * Set the new ordering constraints of the method.
     *
     * @param ordering the orderings constraints to set
     * @throws NullPointerException if ordering == null.
     */
    public final void setOrderingConstraints(final IntExp ordering) {
        if (ordering == null) {
            throw new NullPointerException("ordering == null");
        }
        this.orderingConstraints = ordering;
    }

    /**
     * Return if the method is equal to another object.
     *
     * @param obj the other object.
     * @return <code>true</code> if the specified object is an instance of the class Method and
     *          it has the same name and instantiated parameters; otherwise <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof IntMeth) {
            final IntMeth other = (IntMeth) obj;
            return this.name.equals(other.name) && Arrays.equals(this.instantiations, other.instantiations);
        }
        return false;
    }

    /**
     * Return the hash code value of the method.
     *
     * @return the hash code value of the method.
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
