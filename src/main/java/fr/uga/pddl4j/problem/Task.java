/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.problem;

/**
 * This class implements a task used in HTN planning.
 *
 * @author D. Pellier
 * @version 1.0 - 28.04.2020
 * @since 4.0
 */
public class Task extends AbstractAtomicFormula {

    /**
     * The flag used to indicate if the task is primitive or not.
     */
    private boolean primtive;

    /**
     * Create a new task from an other one. This constructor make a deep copy of the specified
     * task.
     *
     * @param other the task.
     */
    public Task(final Task other) {
        super(other);
        this.setPrimtive(other.isPrimtive());
    }

    /**
     * Creates a new atomic formula with a specified symbol and list of arguments.
     *
     * @param symbol the symbol of the atomic formula.
     * @param arguments the list of arguments of the atomic formula.
     * @param flag the flag used to indicates that the task is primitive or not.
     */
    public Task(final int symbol, final int[] arguments, final boolean flag) {
        super(symbol, arguments);
        this.setPrimtive(flag);
    }

    /**
     * Returns <code>true</code> if the task is a primitive task.
     *
     * @return <code>true</code> if the task is a primitive task, <code>false</code> otherwise.
     */
    public final boolean isPrimtive() {
        return this.primtive;
    }

    /**
     * Set the boolean flag used to specified if the task is a primitive task to a specified value.
     *
     * @param flag the flag.
     */
    public final void setPrimtive(final boolean flag) {
        this.primtive = flag;
    }
}
