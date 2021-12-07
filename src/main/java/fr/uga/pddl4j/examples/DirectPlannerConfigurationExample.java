/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify * it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License * along with PDDL4J.  If not,
 * see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.examples;

import fr.uga.pddl4j.heuristics.state.StateHeuristic;
import fr.uga.pddl4j.planners.LogLevel;
import fr.uga.pddl4j.planners.statespace.HSP;

import java.io.FileNotFoundException;

/**
 * The class is an example. It shows how to create a planner by programming and running it.
 *
 * @author D. Pellier
 * @version 4.0 - 30.11.2021
 */
public class DirectPlannerConfigurationExample {

    /**
     * The main method of the class.
     *
     * @param args the command line arguments. No argument is used.
     */
    public static void main(String[] args) {

        // The path to the benchmarks directory
        final String benchmarks = "src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/";

        // Creates the planner
        HSP planner = new HSP();
        // Sets the domain of the problem to solve
        planner.setDomain(benchmarks + "domain.pddl");
        // Sets the problem to solve
        planner.setProblem(benchmarks + "p01.pddl");
        // Sets the timeout of the search in seconds
        planner.setTimeout(1000);
        // Sets log level
        planner.setLogLevel(LogLevel.INFO);
        // Selects the heuristic to use
        planner.setHeuristic(StateHeuristic.Name.MAX);
        // Sets the weight of the heuristic
        planner.setHeuristicWeight(1.2);

        // Solve and print the result
        try {
            planner.solve();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
