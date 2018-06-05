package fr.uga.pddl4j.planners.statespace;

import fr.uga.pddl4j.planners.statespace.search.strategy.Node;

import java.util.Vector;

public abstract class AbstractStateSpacePlannerAnytime extends AbstractStateSpacePlanner {

    /**
     * The list containing all the solutions found during anytime process.
     */
    private Vector<Node> solutionNodes;

    /**
     * Creates a new planner.
     */
    public AbstractStateSpacePlannerAnytime() {
        super();
        this.setAnytimeState(true);
        solutionNodes = new Vector<>();
    }

    /**
     * Returns the list containing all solution nodes found.
     *
     * @return the list containing all solution nodes found.
     */
    public Vector<Node> getSolutionNodes() {
        return solutionNodes;
    }
}
