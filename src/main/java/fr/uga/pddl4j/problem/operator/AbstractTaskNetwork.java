/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
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

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class implements an abstract task network. This class is used to store compact representation of a task network
 * in a planning problem. This is the first level of implementation of the interface <code>TaskNetwork</code>.
 *
 * @author D. Pellier
 * @version 1.0 - 12.06.2022
 * @since 4.0
 */
public abstract class AbstractTaskNetwork implements TaskNetwork {

    /**
     * The array that defined the list of task of the task network. Each task is defined as an integer. The integer
     * indicates the index of the task in the task table of the planning problem.
     */
    private LinkedList<Integer> tasks;

    /**
     * The list of before constraints.
     */
    private Map<Integer, Condition> beforeConstraints;

    /**
     * The list of after constraints.
     */
    private Map<Integer, Condition> afterConstraints;

    /**
     * The list of between constraints.
     */
    private Map<Integer, Map<Integer, Condition>> betweenConstraints;

    /**
     * Create a new task network. The list of task is set to an empty set with no ordering constraints and not totally
     * ordered.
     */
    public AbstractTaskNetwork() {
        super();
        this.tasks = new LinkedList<Integer>();
        this.beforeConstraints = new LinkedHashMap<>();
        this.afterConstraints = new LinkedHashMap<>();
        this.betweenConstraints = new LinkedHashMap<>();
    }

    /**
     * Create a new method from a specified task network. This constructor create a deep copy of the
     * specified task network.
     *
     * @param other the other task network.
     */
    public AbstractTaskNetwork(final AbstractTaskNetwork other) {
        super();
        this.setTasks(new LinkedList<Integer>(other.getTasks()));
        this.beforeConstraints = new LinkedHashMap<>();
        for (Map.Entry<Integer, Condition> e : other.beforeConstraints.entrySet()) {
            this.beforeConstraints.put(e.getKey(), new Condition(e.getValue()));
        }
        this.afterConstraints = new LinkedHashMap<>();
        for (Map.Entry<Integer, Condition> e : other.afterConstraints.entrySet()) {
            this.afterConstraints.put(e.getKey(), new Condition(e.getValue()));
        }
        this.betweenConstraints = new LinkedHashMap<>();
        for (Map.Entry<Integer, Map<Integer, Condition>> ei : other.betweenConstraints.entrySet()) {
            Map<Integer, Condition> map = new LinkedHashMap<>();
            for (Map.Entry<Integer, Condition> ej : ei.getValue().entrySet()) {
                map.put(ej.getKey(), new Condition(ej.getValue()));
            }
            this.betweenConstraints.put(ei.getKey(), map);
        }
    }

    /**
     * Returns the condition that must hold before a specific task of the task network.
     *
     * @param task the task.
     * @return the condition that must hold before a task or null if the task is not a task of the task network.
     */
    public Condition getBeforeConstraints(int task) {
        Condition condition = null;
        if (this.tasks.contains(task)) {
            condition = this.beforeConstraints.get(task);
            if (condition == null) {
                condition = new Condition();
                this.beforeConstraints.put(task, condition);
            }
        }
        return condition;
    }

    /**
     * Returns the before constraints of task network.
     *
     * @return the before constraints of task network.
     */
    protected Map<Integer, Condition> getBeforeConstraints() {
        return this.beforeConstraints;
    }

    /**
     * Returns the condition that must hold after a specific task of the task network.
     *
     * @param task the task.
     * @return the condition that must hold after a task or null if the task is not a task of the task network.
     */
    public Condition getAfterConstraints(int task) {
        Condition condition = null;
        if (this.tasks.contains(task)) {
            condition = this.afterConstraints.get(task);
            if (condition == null) {
                condition = new Condition();
                this.afterConstraints.put(task, condition);
            }
        }
        return condition;
    }

    /**
     * Returns the after constraints of task network.
     *
     * @return the after constraints of task network.
     */
    protected Map<Integer, Condition> getAfterConstraints() {
        return this.afterConstraints;
    }

    /**
     * Returns the condition that must hold between two specific tasks of the task network.
     *
     * @param task1 the first task.
     * @param task2 the second task.
     * @return the condition that must hold between two tasks or null if t1 or t2 task is not a task of the task
     *      network.
     */
    public Condition getBetweenConstraints(int task1, int task2) {
        Condition condition = null;
        if (this.tasks.contains(task1) && this.tasks.contains(task2)) {
            Map<Integer, Condition> map1 = this.betweenConstraints.get(task1);
            if (map1 == null) {
                map1 = new LinkedHashMap<>();
                condition = new Condition();
                map1.put(task2, condition);
                this.betweenConstraints.put(task1, map1);
            } else {
                condition = map1.get(task1);
                if (condition == null) {
                    condition = new Condition();
                    map1.put(task2, condition);
                }
            }
        }
        return condition;
    }

    /**
     * Returns the between constraints of task network.
     *
     * @return the between constraints of task network.
     */
    protected Map<Integer, Map<Integer, Condition>> getBetweenConstraints() {
        return this.betweenConstraints;
    }

    /**
     * Returns the size of the task network, i.e., its number of tasks.
     *
     * @return the size of the task network.
     */
    public final int size() {
        return this.tasks.size();
    }

    /**
     * Returns the tasks of the task network.
     *
     * @return the tasks of the task network.
     */
    public final List<Integer> getTasks() {
        return this.tasks;
    }

    /**
     * Sets the tasks of the task network.
     *
     * @param tasks the tasks to set.
     */
    public final void setTasks(final List<Integer> tasks) {
        this.tasks = new LinkedList<>(tasks);
    }

    /**
     * Returns if the task network is empty, i.e., contains not tasks.
     *
     * @return <code>true</code> if the task network is empty, <code>false</code> otherwise.
     */
    public final boolean isEmpty() {
        return this.tasks.isEmpty();
    }

    /**
     * Remove a task for the task network.
     *
     * @param task the index of the task to remove.
     */
    public void removeTask(final int task) {
        this.tasks.remove(task);
    }

    /**
     * Returns <code>true</code> if this task network is equal to an object. This
     * method returns <code>true</code> if the object is a not null instance
     * of the class <code>AbstactTaskNetwork</code> and both task network have the same
     * set of tasks and before, after and between constraints?
     *
     * @param obj the object to be compared.
     * @return <code>true</code> if this task network is equal to an object;
     * <code>false</code> otherwise.
     */
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof AbstractTaskNetwork) {
            final AbstractTaskNetwork other = (AbstractTaskNetwork) obj;
            return Objects.equals(this.getTasks(), other.getTasks())
                && Objects.equals(this.getBeforeConstraints(), other.getBeforeConstraints())
                && Objects.equals(this.getAfterConstraints(), other.getAfterConstraints())
                && Objects.equals(this.getBetweenConstraints(), other.getBetweenConstraints());
        }
        return false;
    }

    /**
     * Returns a hash code value for this task network. This method is supported
     * for the benefit of hash tables such as those provided by
     * <code>java.util.Hashtable</code>.
     *
     * @return a hash code value for this task network.
     */
    public int hashCode() {
        return Objects.hash(this.getTasks(), this.getBeforeConstraints(), this.getAfterConstraints(),
            this.getBetweenConstraints());
    }
}
