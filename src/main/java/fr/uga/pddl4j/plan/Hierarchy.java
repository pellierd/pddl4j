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
 * You should have received a copy of the GNU General Public License along with PDDL4J.  If not, see
 * <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.plan;


import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.Method;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This abstract class implements the main methods of a hierarchical sequential plan.
 *
 * @author D. Pellier
 * @version 1.0 - 16.10.2020
 * @since 4.0
 */
public class Hierarchy implements Serializable {

    private List<Integer> rootTasks;
    private Map<Integer, Action> primtiveTasks;
    private Map<Integer, Method> counpoudTasks;
    private Map<Integer, List<Integer>> decomposition;

    public Hierarchy() {
        super();
        this.rootTasks = new ArrayList<>();
        this.primtiveTasks = new LinkedHashMap<>();
        this.counpoudTasks = new LinkedHashMap<>();
        this.decomposition = new LinkedHashMap<>();
    }

    public Hierarchy(final Hierarchy other) {
        // TODO

    }

    public List<Integer> getRootTasks() {
        return this.rootTasks;
    }

    public Map<Integer, Action> getPrimtiveTasks() {
        return this.primtiveTasks;
    }

    public Map<Integer, Method> getCounpoudTasks() {
        return this.counpoudTasks;
    }

    public Map<Integer, List<Integer>> getDecomposition() {
        return this.decomposition;
    }


}
