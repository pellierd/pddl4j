/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.planners;

import fr.uga.pddl4j.plan.Plan;

import java.util.Map;
import java.util.Properties;

/**
 * This class implements a planner configuration. A planner configuration is used to create a planner.
 *
 * <p>To create a planner with a specific configuration use the following example code:</p>
 * <pre>
 * {@code
 *         // The path to the benchmarks directory
 *         final String benchmarks = "src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/";
 *
 *         // Gets the default configuration from the planner
 *         PlannerConfiguration config = HSP.getDefaultConfiguration();
 *         // Sets the domain of the problem to solve
 *         config.setProperty(HSP.DOMAIN_SETTING, benchmarks + "domain.pddl");
 *         // Sets the problem to solve
 *         config.setProperty(HSP.PROBLEM_SETTING, benchmarks + "p01.pddl");
 *         // Sets the timeout allocated to the search.
 *         config.setProperty(HSP.TIME_OUT_SETTING, 1000);
 *         // Sets the log level
 *         config.setProperty(HSP.LOG_LEVEL_SETTING, LogLevel.INFO);
 *         // Sets the heuristic used to search
 *         config.setProperty(HSP.HEURISTIC_SETTING, GoalCostHeuristic.Name.MAX);
 *         // Sets the weight of the heuristic
 *         config.setProperty(HSP.WEIGHT_HEURISTIC_SETTING, 1.2);
 *
 *         // Creates an instance of the HSP planner with the specified configuration
 *         Planner planner = Planner.getInstance(Planner.Name.HSP, config);
 *
 *         // Runs the planner and print the solution
 *         try {
 *             planner.solve();
 *         } catch (FileNotFoundException e) {
 *             e.printStackTrace();
 *         }
 *  }
 * </pre>
 *
 *
 * @author D. Pellier
 * @version 1.0 - 18.06.2020
 * @since 4.0
 */
public class PlannerConfiguration extends Properties {

    /**
     * Creates a configuration from another.
     *
     * @param other the other configuration.
     */
    public PlannerConfiguration(PlannerConfiguration other) {
        super(other);
    }

    /**
     * Creates new default configuration.
     */
    public PlannerConfiguration() {
        super();
        this.setProperty(Planner.DOMAIN_SETTING,  Planner.DEFAULT_DOMAIN);
        this.setProperty(Planner.PROBLEM_SETTING, Planner.DEFAULT_PROBLEM);
        this.setProperty(Planner.TIME_OUT_SETTING, Integer.toString(Planner.DEFAULT_TIME_OUT));
        this.setProperty(Planner.LOG_LEVEL_SETTING, Planner.DEFAULT_LOG_LEVEL.toString());
    }

    /**
     * Sets the value of a specific key properties. This method converts the value object into string for storing by
     * using the method {@code toString()}.
     *
     * @param key the key property name.
     * @param value the value to set.
     * @return the string representation of the previous object linked to the key property, or null is if it did not
     *      have one.
     */
    public String setProperty(final String key, final Object value) {
        Object obj = super.setProperty(key, value.toString());
        return obj == null ? null : obj.toString();
    }

    /**
     * Returns a string representation of this configuration.
     *
     * @return a string representation of this configuration.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Object, Object> e : this.entrySet()) {
            str.append(e.getKey());
            str.append("=");
            str.append(e.getValue());
            str.append("\n");
        }
        return str.toString();
    }
}
