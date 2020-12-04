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

import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Method;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
     * Creates a deep copy of an existing hierarchy.
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

    /**
     * Returns the root tasks of the hierarchy.
     *
     * @return the root tasks of the hierarchy.
     */
    public final List<Integer> getRootTasks() {
        return this.rootTasks;
    }

    /**
     * Returns the list of primitive tasks of the hierarchy and corresponding task IDs.
     *
     * @return the list of primitive tasks of the hierarchy and corresponding task IDs.
     */
    public Map<Integer, Action> getPrimtiveTasks() {
        return this.primtiveTasks;
    }

    /**
     * Returns the list of compound tasks of the hierarchy and corresponding task IDs.
     *
     * @return the list of compound tasks of the hierarchy and corresponding task IDs.
     */
    public Map<Integer, Method> getCounpoudTasks() {
        return this.counpoudTasks;
    }

    /**
     * Returns the decomposition of the compound task. Task IDs are used as key of the map return. Only cooumpund task
     * has a entry in the map.
     *
     * @return the decomposition of the compound task.
     */
    public Map<Integer, List<Integer>> getDecomposition() {
        return this.decomposition;
    }

    /**
     * Returns if a hierarchy is equals to an other object. The method returns <code>true</code> if the other object is
     * an instance of the class hierarchy and has the same root tasks, primitives and compund tasks set and
     * decomposition.
     *
     * @param other the other object to be compared.
     * @return <code>true</code> if this hierarchy is equal to the object in parameter; <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object other) {
        boolean equal = true;
        if (this == other) {
            equal = true;
        } else if (!(other instanceof Hierarchy)) {
            equal = false;
        } else {
            Hierarchy hierarchy = (Hierarchy) other;
            equal = Objects.equals(getRootTasks(), hierarchy.getRootTasks())
                && Objects.equals(getPrimtiveTasks(), hierarchy.getPrimtiveTasks())
                && Objects.equals(getCounpoudTasks(), hierarchy.getCounpoudTasks())
                && Objects.equals(getDecomposition(), hierarchy.getDecomposition());
        }
        return equal;
    }

    /**
     * Returns the hashcode value of this hierarchy.
     *
     * @return the hashcode value of this hierarchy.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRootTasks(), getPrimtiveTasks(), getCounpoudTasks(), getDecomposition());
    }

}
