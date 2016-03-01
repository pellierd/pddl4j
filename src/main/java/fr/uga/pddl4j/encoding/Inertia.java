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

/**
 * This class implement the concept of inertia. An inertia can be POSTIVE, NEGATIVE, FLUENT or only
 * INERTIA according to the following definitions:
 * <p>
 * Definition 1. A relation is a positive inertia if and only if it does not occur positively in an
 * unconditional effect or the consequent of a conditional effect of an operator.
 * </p>
 * <p>
 * Definition 2. A relation is a negative inertia if and only if it does not occur negatively in an
 * unconditional effect or the consequent of a conditional effect of an operator.
 * </p>
 * The pre-processing proceeds over the domain and problem description and collects all used
 * relation names. For each relation it checks if it satisfies one of the following definitions:
 * Relations, which are positive as well as negative inertia, are simply called inertia.
 * Relations, which are neither positive nor negative inertia, are called fluents. The detection of
 * inertia and fluents is easy because in ADL, effects are restricted to conjunctions of literals.
 * Furthermore, this information can be obtained with a single pass over the domain description,
 * which takes almost no time at all.
 *
 * @author D. Pellier
 * @version 1.0 - 07.04.2010
 */
public enum Inertia {
    /**
     * The positive inertia.
     */
    POSITIVE,
    /**
     * The negative inertia.
     */
    NEGATIVE,
    /**
     * The positive and negative inertia.
     */
    INERTIA,
    /**
     * The inertia which are neither positive nor negative.
     */
    FLUENT
}
