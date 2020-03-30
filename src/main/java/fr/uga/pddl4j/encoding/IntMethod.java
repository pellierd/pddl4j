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

import fr.uga.pddl4j.util.IntExp;

/**
 * This class implements an method. This class is used to store compact representation of method
 * during the instantiation process.
 *
 * @author D. Pellier
 * @version 1.0 - 14.02.2020
 */
final class IntMethod extends AbstractIntOperator {

    /**
     * The task network of the methode.
     */
    private IntTaskNetwork taskNetwork;

    /**
     * Create a new method from a specified method. This constructor create a deep copy of the
     * specified method.
     *
     * @param other the other method.
     */
    public IntMethod(final IntMethod other) {
        super(other);
        this.taskNetwork = other.taskNetwork;
    }

    /**
     * Create a new method with a specified name.
     *
     * @param name  the name of the method.
     * @param arity the arity of the method. The arity must be > 0.
     */
    public IntMethod(final String name, final int arity) {
        super(name, arity);
        this.taskNetwork = new IntTaskNetwork();
    }

    /**
     * Return the tasks of the method.
     *
     * @return the tasks of the method.
     */
    public final IntExp getTasks() {
        return this.taskNetwork.getTasks();
    }

    /**
     * Set the tasks of the method.
     *
     * @param tasks the tasks to set.
     */
    public final void setTasks(final IntExp tasks) {
        this.taskNetwork.setTasks(tasks);
    }

    /**
     * Return the ordering constraints of the method.
     *
     * @return the ordering constraints of the method.
     */
    public final IntExp getOrderingConstraints() {
        return this.taskNetwork.getOrderingConstraints();
    }

    /**
     * Set the new ordering constraints of the method.
     *
     * @param ordering the orderings constraints to set
     */
    public final void setOrderingConstraints(final IntExp ordering) {
        this.taskNetwork.setOrderingConstraints(ordering);
    }

}
