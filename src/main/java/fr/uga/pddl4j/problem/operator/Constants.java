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
 * This interface defines the constants used during the encoding.
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
public interface Constants {

    /**
     * The default logging level.
     */
    static final int DEFAULT_LOGGING_LEVEL = 1;

    /**
     * The default size of the table of relevant facts.
     */
    static final int DEFAULT_RELEVANT_FACTS_TABLE_SIZE = 1000;

    /**
     * The name of the dummy predicate used to replace the goal when the goal is a disjunction.
     */
    static final String DUMMY_GOAL = "dummy_goal";

    /**
     * The name of the dummy operator that produce the dummy goal.
     */
    static final String DUMMY_OPERATOR = "dummy_operator";

    /**
     * The default size of the actions table.
     */
    static final int DEFAULT_ACTION_TABLE_SIZE = 1000;

    /**
     * The default size of the method table.
     */
    public static final int DEFAULT_METHOD_TABLE_SIZE = 1000;


}
