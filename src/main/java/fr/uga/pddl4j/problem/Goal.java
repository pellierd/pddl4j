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

import fr.uga.pddl4j.problem.operator.Condition;

/**
 * This class implements a goal, i.e., a set of positives and negative fluents.
 *
 * @author D. Pellier
 * @version 1.0 - 28.04.2020
 * @since 4.0
 */
public class Goal extends Condition {

    /**
     * Create a new goal from a other goal.
     *
     * @param goal the other goal.
     */
    public Goal(Goal goal) {
        super(goal);
    }

    /**
     *  Create a new goal from a other goal.
     *
     * @param condition the other goal.
     */
    public Goal(Condition condition) {
        super(condition);
    }

    /**
     *  Create a new empty goal from a other goal.
     */
    public Goal() {
        super();
    }
}
