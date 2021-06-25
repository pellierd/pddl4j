/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.  If not, see
 * <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.planners.statespace;

import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.Configuration;
import fr.uga.pddl4j.planners.statespace.search.StateSpaceStrategy;
import fr.uga.pddl4j.problem.ADLProblem;
import fr.uga.pddl4j.problem.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class defines the main methods to access a state based planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public abstract class AbstractStateSpacePlanner<T extends Problem> extends AbstractPlanner<T>
        implements StateSpacePlanner<T> {

    /**
     * The liste of state space strategies used in the planner.
     */
    private List<StateSpaceStrategy> stateSpaceStrategiesList;

    /**
     * Creates a new planner.
     */
    public AbstractStateSpacePlanner() {
        super();
        this.stateSpaceStrategiesList = new ArrayList<>();
    }

    /**
     * Creates a new planner with a specific configuration.
     */
    public AbstractStateSpacePlanner(Configuration configuration) {
        super(configuration);
        this.stateSpaceStrategiesList = new ArrayList<>();
    }

    /**
     * Returns the state space strategies used in the planner.
     *
     * @return the state space strategies used in the planner
     */
    @Override
    public List<StateSpaceStrategy> getStateSpaceStrategies() {
        return this.stateSpaceStrategiesList;
    }


}
