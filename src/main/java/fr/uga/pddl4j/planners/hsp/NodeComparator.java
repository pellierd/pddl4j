package fr.uga.pddl4j.planners.hsp;

import java.io.Serializable;
import java.util.Comparator;

/**
 * This class implements a comparator between nodes.
 *
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 */
public class NodeComparator implements Comparator<Node>, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The weight of the heuristic use for the comparison.
     */
    private double weight;

    /**
     * Build the Node comparator object base on heuristic weight.
     * @param weight the heuristic weight
     */
    public NodeComparator(double weight) {
        this.weight = weight;
    }

    /**
     * Compare two nodes' weight.
     * @param n1 node number 1
     * @param n2 node number 2
     */
    @Override
    public int compare(final Node n1, final Node n2) {
        return Double.compare(n1.getFValue(weight), n2.getFValue(weight));
    }
}
