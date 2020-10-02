package fr.uga.pddl4j.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pellier on 02/10/2020.
 */
public class SquareBitMatrix extends BitMatrix {

    /**
     * Creates a deep copy from an other matrix.
     *
     * @param other The other matrix.
     */
    public SquareBitMatrix(final SquareBitMatrix other) {
        super(other);
    }

    /**
     * Creates a new squared matrix of a specific size.
     *
     * @param size the size of the squared matrix.
     */
    public SquareBitMatrix(final int size) {
        super(size, size);
    }

    /**
     * Compute the transitive closure of the ordering constraints. The computation of the transitive closure is based
     * on Warshall algorithm. The complexity is O(n^3) where n is the number of tasks of the task network.
     */
    public final void transitiveClosure() {
        for (int k = 0; k < this.rows(); k++) {
            for (int i = 0; i < this.rows(); i++) {
                if (this.get(i, k)) {
                    for (int j = 0; j < this.rows(); j++) {
                        if (this.get(k, j)) {
                            this.set(i, j);
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns <code>true</code> if the task network is totally ordered. The return value is computed from the ordering
     * constraints of the task network. A task network with an empty set of constraints is totally ordered.
     *
     * @return <code>true</code> if the task network is totally ordered.
     */
    public final boolean isTotallyOrdered() {
        if (this.rows() < 2) return true;
        BitMatrix matrix = new BitMatrix(this);
        boolean ordered = true;
        //System.out.println("AVANT -------\n" + matrix.toBitString());
        int index = 0;
        while (matrix.rows() > 1 && ordered) {
            List<Integer> tasks = this.getTasksWithNoPredecessors(matrix);
            //System.out.println(tasks.size());
            ordered = tasks.size() == 1;
            if (ordered) {
                matrix.removeRow(tasks.get(0));
                matrix.removeColumn(tasks.get(0));
            }
            //System.out.println(index + " PENDANT ------- \n" + matrix.toBitString());
            index++;
        }
        //System.out.println("ordered=" + ordered);
        return ordered;
    }

    /**
     * Returns the list of tasks with no successors. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     *
     * @return the  list of tasks with no successors.
     */
    public final List<Integer> getTasksWithNosSuccessors() {
        return this.getTasksWithNosSuccessors(this);
    }

    /**
     * Returns the list of tasks with no successors.  The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no successors.
     */
    private final List<Integer> getTasksWithNosSuccessors(BitMatrix matrix) {
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
    public final List<Integer> getTasksWithNoPredecessors() {
        return this.getTasksWithNoPredecessors(this);
    }

    /**
     * Returns the list of tasks with no predecessor. The method works if only if the method
     * <code>transitiveClosure()</code> was previously called.
     *
     * @return the  list of tasks with no predecessor.
     */
    private final List<Integer> getTasksWithNoPredecessors(BitMatrix matrix) {
        final List<Integer> tasks = new LinkedList<>();
        for (int i = 0; i < matrix.columns(); i++) {
            if (matrix.getColumn(i).cardinality() == 0) {
                tasks.add(i);
            }
        }
        return tasks;
    }

    /**
     * Returns if this task network contains cyclic ordering constraints.
     *
     * @return <code>true</code> if the task network contains acyclic ordering constraints, <code>false</code>
     *      otherwise.
     */
    public final boolean isAcyclic() {
        this.transitiveClosure();
        final int size = this.rows();
        boolean acyclic = true;
        int i = 0;
        while (i < size && acyclic) {
            acyclic &= !this.get(i, i);
            i++;
        }
        return acyclic;
    }

}
