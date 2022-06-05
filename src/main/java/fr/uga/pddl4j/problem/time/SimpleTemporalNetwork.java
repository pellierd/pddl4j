package fr.uga.pddl4j.problem.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimpleTemporalNetwork implements Serializable {

    private boolean update;

    private List<List<TemporalRelation>> network;


    public SimpleTemporalNetwork(final SimpleTemporalNetwork other) {
        final int size = other.network.size();
        this.network = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<TemporalRelation> list = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                list.add(other.network.get(i).get(j));
            }
            this.network.add(list);
        }
        this.update = other.update;
    }

    public SimpleTemporalNetwork() {
        this(0);
    }

    public SimpleTemporalNetwork(int size) {
        int numberOfTimePoints = size * 2;
        this.network = new ArrayList<>(numberOfTimePoints);
        for (int i = 0; i < numberOfTimePoints; i++) {
            List<TemporalRelation> list = new ArrayList<>(size);
            for (int j = 0; j < numberOfTimePoints; j++) {
                list.add(TemporalRelation.UNIVERSAL);
            }
            this.network.add(list);
        }
        this.update = false;
    }

    public TemporalRelation get(int i, int j) {
        return this.network.get(i).get(j);
    }

    public void set(int i, int j, TemporalRelation relation) {
        this.network.get(i).set(j, relation);
        this.network.get(j).set(i, relation.symmetric());
        this.update = true;
    }


    /**
     * Returns if the network is consistent or not.
     *
     * @return if the network is consistent or not.
     */
    private boolean isConsistent() {
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
     * Compute the transitive closure of the relation.
     */
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
     * The number of tasks of the simple temporal network.
     *
     * @return number of tasks of the simple temporal network.
     */
    public int size() {
        return this.network.size()/2;
    }

    /**
     * Returns a string representation of the simple task network.
     *
     * @return a string representation of the simple task network.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.network.size(); i++) {
            for (int j = 0; j < this.network.size(); j++) {
                str.append("(T");
                str.append(i/2);
                if (i%2 == 0) {
                    str.append("_start ");
                } else {
                    str.append("_end ");
                }
                str.append(this.get(i, j));
                str.append(" ");
                str.append("T");
                str.append(j/2);
                if (j%2 == 0) {
                    str.append("_start)\n");
                } else {
                    str.append("_end)\n");
                }
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {

        SimpleTemporalNetwork network = new SimpleTemporalNetwork(6);
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


    public void removeRow(int task) {
    }

    public void removeColumn(int task) {
    }

    public boolean isTotallyOrdered() {
        return true;
    }

    public boolean isAcyclic() {
        return true;
    }

    public List<Integer> getTasksWithNoSuccessors() {
        return new ArrayList<>();
    }

    public List<Integer> getTasksWithNoPredecessors() {
        return new ArrayList<>();
    }
}
