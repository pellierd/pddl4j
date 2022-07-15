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

import fr.uga.pddl4j.parser.Connector;
import fr.uga.pddl4j.parser.Symbol;
import fr.uga.pddl4j.util.BitSet;
import fr.uga.pddl4j.util.BitVector;
import fr.uga.pddl4j.util.SquareBitMatrix;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class implements a set orderings constraints between tasks.
 *
 * @author D. Pellier
 * @version 1.0 - 09.10.2020
 */
public class DefaultOrderingConstraintNetwork extends AbstractOrderingConstraintNetwork {

    /**
     * the bit matrix used to store the ordering constrains.
     */
    private SquareBitMatrix matrix;

    /**
     * Creates a deep copy from an others ordering constraint network.
     *
     * @param other The other ordering constraints.
     */
    public DefaultOrderingConstraintNetwork(final DefaultOrderingConstraintNetwork other) {
        this.matrix = new SquareBitMatrix(other.matrix);
    }

    /**
     * Creates a new ordering constraint network.
     *
     * @param size the number of tasks of ordering constraint network.
     */
    public DefaultOrderingConstraintNetwork(final int size) {
        this.matrix = new SquareBitMatrix(size);
    }

    /**
     * Returns <code>true</code> if the orderings constraints network is totally ordered.
     *
     * @return <code>true</code> if the ordering constraints network is totally ordered; <code>false</code> otherwise.
     */
    @Override
    public final boolean isTotallyOrdered() {
        if (this.matrix.rows() < 2) {
            return true;
        }
        final SquareBitMatrix ordering = new SquareBitMatrix(this.matrix);
        boolean ordered = true;
        int index = 0;
        while (ordering.rows() > 1 && ordered) {
            List<Integer> tasks = this.getTasksWithNoPredecessors(ordering);
            ordered = tasks.size() == 1;
            if (ordered) {
                ordering.removeRow(tasks.get(0));
                ordering.removeColumn(tasks.get(0));
            }
            index++;
        }
        return ordered;
    }

    /**
     * Returns the list of tasks with no successors. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     *
     * @return the list of tasks with no successors.
     */
    @Override
    public final List<Integer> getTasksWithNoSuccessors() {
        return this.getTasksWithNoSuccessors(this.matrix);
    }

    /**
     * Returns the list of tasks with no successors.  The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no successors.
     */
    private final List<Integer> getTasksWithNoSuccessors(SquareBitMatrix matrix) {
        final List<Integer> tasks = new LinkedList<>();
        for (int i = 0; i < matrix.columns(); i++) {
            if (matrix.getRow(i).cardinality() == 0) {
                tasks.add(i);
            }
        }
        return tasks;
    }

    /**
     * Returns the list of tasks with no predecessors.  The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no predecessors.
     */
    @Override
    public List<Integer> getTasksWithNoPredecessors() {
        return this.getTasksWithNoPredecessors(this.matrix);
    }

    /**
     * Returns the list of tasks with no predecessor. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no predecessor.
     */
    private final List<Integer> getTasksWithNoPredecessors(SquareBitMatrix matrix) {
        final List<Integer> tasks = new LinkedList<>();
        for (int i = 0; i < matrix.columns(); i++) {
            if (matrix.getColumn(i).cardinality() == 0) {
                tasks.add(i);
            }
        }
        return tasks;
    }

    /**
     * Returns if this ordering constraint network is consistent .
     *
     * @return <code>true</code> if the ordering constraints network is consistent, <code>false</code>
     *      otherwise.
     */
    @Override
    public final boolean isConsistent() {
        this.transitiveClosure();
        final int size = this.matrix.rows();
        boolean acyclic = true;
        int i = 0;
        while (i < size && acyclic) {
            acyclic &= !this.matrix.get(i, i);
            i++;
        }
        return acyclic;
    }

    /**
     * Compute the transitive closure of the ordering constraints. The computation of the transitive closure is based
     * on Warshall algorithm. The complexity is O(n^3) where n is the number of tasks of the task network.
     *
     * @see SquareBitMatrix
     */
    @Override
    public final void transitiveClosure() {
        this.matrix.transitiveClosure();
    }

    /**
     * Sets an ordering constraints between two specified tasks.
     *
     * @param task1 the first task.
     * @param task2 the second task.
     */
    public void set(int task1, int task2) {
        this.matrix.set(task1, task2);
    }

    /**
     * Removes the ordering constraints between two specified tasks.
     *
     * @param task1 the first task.
     * @param task2 the second task.
     */
    public void clear(int task1, int task2) {
        this.matrix.clear(task1, task1);
    }

    /**
     * Returns a bit vector of the tasks ordered after a specified task.
     *
     * @param task the task.
     * @return a bit vector of the tasks ordered after a specified task.
     */
    public BitVector  getTaskOrderedAfter(int task) {
        return matrix.getRow(task);
    }

    /**
     * Resize the ordering constraints network.
     *
     * @param newSize the new size.
     */
    public void resize(int newSize) {
        matrix.resize(newSize, newSize);
    }

    /**
     * Returns the size of the ordering constraints network, i.e., its number of tasks.
     *
     * @return the size of the ordering constraints network, i.e., its number of tasks.
     */
    public int size() {
        return this.matrix.columns();
    }

    /**
     * Returns a string representation of the ordering constraints network based on bit representation.
     *
     * @return a string representation of the ordering constraints network based on bit representation.
     */
    public String toBitString() {
        return matrix.toBitString();
    }

    /**
     * Remove a task of the ordering constraints network.
     *
     * @param task the task to removed.
     */
    @Override
    public void removeTask(int task) {
        this.matrix.removeRow(task);
        this.matrix.removeColumn(task);
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof DefaultOrderingConstraintNetwork) {
            DefaultOrderingConstraintNetwork other = (DefaultOrderingConstraintNetwork) object;
            this.matrix.transitiveClosure();
            other.matrix.transitiveClosure();
            return Objects.equals(this.matrix, other.matrix);
        }
        return false;
    }

    @Override
    public int hashCode() {
        this.matrix.transitiveClosure();
        return Objects.hash(this.matrix);
    }

    /**
     * Returns a string representation of this ordering constraints.
     *
     * @return a string representation of the ordering constraints.
     */
    public final String toString() {
        final StringBuilder str = new StringBuilder();
        if (this.matrix.cardinality() == 0) {
            str.append(" ()");
        } else {
            int index = 0;
            for (int r = 0; r < this.matrix.rows(); r++) {
                BitSet row = this.matrix.getRow(r);
                for (int c = row.nextSetBit(0); c >= 0; c = row.nextSetBit(c + 1)) {
                    str.append(" C");
                    str.append(index);
                    str.append(": ");
                    str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + r);
                    str.append(" ");
                    str.append(Connector.LESS_ORDERING_CONSTRAINT.getImage());
                    str.append(" ");
                    str.append(Symbol.DEFAULT_TASK_ID_SYMBOL + c);
                    str.append("\n");
                    index++;
                }
            }
            str.setLength(str.length() - 1);
        }
        return str.toString();
    }


}
