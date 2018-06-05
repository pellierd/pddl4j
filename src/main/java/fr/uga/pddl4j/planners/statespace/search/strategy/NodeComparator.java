/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.planners.statespace.search.strategy;

import java.io.Serializable;
import java.util.Comparator;

/**
 * This class implements a comparator between nodes.
 *
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 */
public class NodeComparator implements Comparator<Node>, Serializable {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The weight of the heuristic use for the comparison.
     */
    private double weight;

    /**
     * Returns the weight of the heuristic use for the comparison.
     *
     * @return the weight of the heuristic use for the comparison.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the heuristic use for the comparison.
     *
     * @param weight the weight of the heuristic use for the comparison.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Build the Node comparator object base on heuristic weight.
     *
     * @param weight the heuristic weight
     */
    public NodeComparator(double weight) {
        this.weight = weight;
    }

    /**
     * Compare two nodes' weight.
     *
     * @param n1 node number 1
     * @param n2 node number 2
     */
    @Override
    public int compare(final Node n1, final Node n2) {
        return Double.compare(n1.getValueF(weight), n2.getValueF(weight));
    }
}
