/*
 * Copyright (c) 2022 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.problem.time;

import fr.uga.pddl4j.parser.Symbol;
import fr.uga.pddl4j.problem.operator.AbstractOrderingConstraintNetwork;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a simple temporal network. This class is used to deal with temporal constraints in methods.
 *
 * @author D. Pellier
 * @version 1.0 - 09.06.2022
 * @since 4.0
 */
public class TemporalOrderingConstraintNetwork extends AbstractOrderingConstraintNetwork {

    /**
     * The matrix used to the store the temporal network.
     */
    private List<List<TemporalRelation>> network;

    /**
     * Creates a new simple temporal network from another one. This constructor creates a deep copy of the simple
     * temporal network in paramter.
     *
     * @param other the other simple temporal network to use to make the copy.
     */
    public TemporalOrderingConstraintNetwork(final TemporalOrderingConstraintNetwork other) {
        final int size = other.network.size();
        this.network = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<TemporalRelation> list = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                list.add(other.network.get(i).get(j));
            }
            this.network.add(list);
        }
    }

    /**
     * Creates a new empty simple temporal network.
     */
    public TemporalOrderingConstraintNetwork() {
        this(0);
    }

    /**
     * Creates a new simple temporal network with a specified size. The temporal relations between tasks are set to
     * UNIVERSAL.
     *
     * @see TemporalRelation
     * @param size the number of tasks of the simple temporal network.
     */
    public TemporalOrderingConstraintNetwork(int size) {
        int numberOfTimePoints = size * 2;
        this.network = new ArrayList<>(numberOfTimePoints);
        for (int i = 0; i < numberOfTimePoints; i++) {
            List<TemporalRelation> list = new ArrayList<>(size);
            for (int j = 0; j < numberOfTimePoints; j++) {
                list.add(TemporalRelation.UNIVERSAL);
            }
            this.network.add(list);
        }
    }

    /**
     * Returns the temporal relation between two specified task.
     *
     * @param task1 the first task.
     * @param task2 the second task.
     * @return the temporal relation between task1 and task2.
     */
    public TemporalRelation get(int task1, int task2) {
        return this.network.get(task1).get(task2);
    }

    /**
     * Adds an ordering constraints between two specified tasks.
     *
     * @param task1 the first task.
     * @param task2 the second task.
     * @param relation the temporal relation between task1 and task2.
     */
    public void set(int task1, int task2, TemporalRelation relation) {
        this.network.get(task1).set(task2, relation);
        this.network.get(task2).set(task1, relation.symmetric());
    }

    /**
     * Returns if the network is consistent or not.
     *
     * @return if the network is consistent or not.
     */
    @Override
    public boolean isConsistent() {
        for (int k = 0; k < this.network.size(); k++) {
            for (int i = 0; i < this.network.size(); i++) {
                for (int j = i + 1; j < this.network.size(); j++) {
                    if (i != k && j != k) {
                        TemporalRelation cij = this.get(i, j);
                        TemporalRelation cik = this.get(i, k);
                        TemporalRelation ckj = this.get(k, j);
                        TemporalRelation newcij = cij.intersect(cik.compose(ckj));
                        this.set(i, j, newcij);
                        if (newcij.equals(TemporalRelation.EMPTY)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Compute the transitive closure of the relation in O(n^3).
     */
    @Override
    public void transitiveClosure() {
        for (int k = 0; k < this.network.size(); k++) {
            for (int i = 0; i < this.network.size(); i++) {
                for (int j = i + 1; j < this.network.size(); j++) {
                    if (i != k && j != k) {
                        this.set(i, j, this.get(i, j).intersect(this.get(i, k).compose(this.get(k, j))));
                    }
                }
            }
        }
    }

    /**
     * TO DO: NOT IMPLEMENTED
     * Remove a task of the ordering constraints network.
     *
     * @param task the task to removed.
     */
    @Override
    public void removeTask(int task) {
    }

    /**
     * The number of tasks of the simple temporal network.
     *
     * @return number of tasks of the simple temporal network.
     */
    @Override
    public int size() {
        return this.network.size() / 2;
    }

    /**
     * TO DO: NOT IMPLEMENTED
     * Resize the ordering constraints network.
     *
     * @param newSize the new size.
     */
    @Override
    public void resize(int newSize) {
    }



    /**
     * TO DO: NOT IMPLEMENTED
     * Returns <code>true</code> if the simple temporal network is totally ordered.
     *
     * @return <code>true</code> if the simple temporal network is totally ordered.; <code>false</code> otherwise.
     */
    public boolean isTotallyOrdered() {
        return true;
    }

    /**
     * TO DO: NOT IMPLEMENTED
     * Returns the list of tasks with no successors. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no successors.
     */
    public List<Integer> getTasksWithNoSuccessors() {
        return new ArrayList<>();
    }

    /**
     * TO DO: NOT IMPLEMENTED
     * Returns the list of tasks with no predecessors. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no predecessors.
     */
    public List<Integer> getTasksWithNoPredecessors() {
        return new ArrayList<>();
    }

    /**
     * Returns a string representation of the simple temporal network.
     *
     * @return a string representation of the simple temporal network.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.network.size(); i++) {
            for (int j = 0; j < this.network.size(); j++) {
                str.append("(");
                str.append(Symbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(i / 2);
                if (i % 2 == 0) {
                    str.append("_start ");
                } else {
                    str.append("_end ");
                }
                str.append(this.get(i, j));
                str.append(" ");
                str.append(Symbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(j / 2);
                if (j % 2 == 0) {
                    str.append("_start)\n");
                } else {
                    str.append("_end)\n");
                }
            }
        }
        return str.toString();
    }

    /**
     * TO REMOVED.
     *
     * @param args no arguments.
     */
    public static void main(String[] args) {
        TemporalOrderingConstraintNetwork network = new TemporalOrderingConstraintNetwork(6);
        // T0_start < T0_end
        network.set(0, 1, TemporalRelation.LESS);
        // T1_start < T1_end
        network.set(2, 3, TemporalRelation.LESS);
        // T2_start < T2_end
        network.set(4, 5, TemporalRelation.LESS);

        // T0_end < T1_start
        network.set(1, 2, TemporalRelation.LESS);
        // T0_start = T2_start
        network.set(0, 4, TemporalRelation.EQUAL);
        // T2_end < T0_start
        network.set(5, 0, TemporalRelation.LESS);

        // T3_end > T2_start
        //network.set(7, 4, TemporalRelation.GREATER);

        System.out.println(network);

        System.out.println("Consistent ? " + network.isConsistent());
    }

}
