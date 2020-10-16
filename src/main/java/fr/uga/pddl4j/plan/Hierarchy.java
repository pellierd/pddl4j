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
 * This abstract class implements the main methods to manipulate the hierarchical information of a plan.
 *
 * @author D. Pellier
 * @version 1.0 - 16.10.2020
 * @since 4.0
 */
public class Hierarchy implements Serializable {

    /**
     * The list of root task of the hierachy.
     */
    private List<Integer> rootTasks;

    /**
     * The list of primitive tasks of the hierarchy and their task ID.
     */
    private Map<Integer, Action> primtiveTasks;

    /**
     * The list of compound tasks of the hierarchy and their task ID.
     */
    private Map<Integer, Method> counpoudTasks;

    /**
     * The decomposition of each compund tasks into sub-tasks.
     */
    private Map<Integer, List<Integer>> decomposition;

    /**
     * Creates a new empty hierarchy.
     */
    public Hierarchy() {
        super();
        this.rootTasks = new ArrayList<>();
        this.primtiveTasks = new LinkedHashMap<>();
        this.counpoudTasks = new LinkedHashMap<>();
        this.decomposition = new LinkedHashMap<>();
    }

    /**
     * Creates a deep copy of a existing hierarchy.
     *
     * @param other the existing hierarchy.
     */
    public Hierarchy(final Hierarchy other) {
        this();
        for (Integer rootTask : other.getRootTasks()) {
            this.rootTasks.add(rootTask);
        }
        for (Map.Entry<Integer, Action> a : other.getPrimtiveTasks().entrySet()) {
            this.primtiveTasks.put(a.getKey(), new Action(a.getValue()));
        }
        for (Map.Entry<Integer, Method> m : other.getCounpoudTasks().entrySet()) {
            this.counpoudTasks.put(m.getKey(), new Method(m.getValue()));
        }
        for (Map.Entry<Integer, List<Integer>> m : other.getDecomposition().entrySet()) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(m.getValue());
            this.decomposition.put(m.getKey(), copy);
        }
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
