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

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.planners.statespace.StateSpacePlanner;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.Plan;
import fr.uga.pddl4j.util.SequentialPlan;

import java.util.Objects;

/**
 * This abstract class defines the main methods for search strategies.
 *
 * @author E. Hermellin
 * @version 1.0 - 11.06.2018
 * @since 3.6
 */
public abstract class AbstractStrategy implements Strategy {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The state space planner.
     */
    private StateSpacePlanner stateSpacePlanner;

    /**
     * The coded problem.
     */
    private CodedProblem codedProblem;

    /**
     * Returns the planner associated to the search strategy.
     *
     * @return the planner associated to the search strategy
     */
    @Override
    public StateSpacePlanner getStateSpacePlanner() {
        return stateSpacePlanner;
    }

    /**
     * Sets the planner associated to the search strategy.
     *
     * @param stateSpacePlanner the planner associated to the search strategy.
     */
    @Override
    public void setStateSpacePlanner(StateSpacePlanner stateSpacePlanner) {
        this.stateSpacePlanner = stateSpacePlanner;
    }

    /**
     * Returns the coded problem on which the search strategy is applied.
     *
     * @return the coded problem on which the search strategy is applied
     */
    @Override
    public CodedProblem getCodedProblem() {
        return codedProblem;
    }

    /**
     * Sets the coded problem on which the search strategy is applied.
     *
     * @param codedProblem the coded problem on which the search strategy is applied.
     */
    @Override
    public void setCodedProblem(CodedProblem codedProblem) {
        this.codedProblem = codedProblem;
    }

    /**
     * Create a new search strategy.
     *
     * @param stateSpacePlanner the planner associated to the search strategy
     * @param codedProblem      the coded problem on which the search strategy is applied.
     */
    public AbstractStrategy(StateSpacePlanner stateSpacePlanner, CodedProblem codedProblem) {
        super();
        this.stateSpacePlanner = stateSpacePlanner;
        this.codedProblem = codedProblem;
    }

    /**
     * Search a solution node to a specified domain and problem.
     *
     * @return the solution node or null.
     */
    @Override
    public Node searchSolutionNode() {
        Objects.requireNonNull(this.codedProblem);
        return search(this.stateSpacePlanner, this.codedProblem);
    }

    /**
     * Search a solution plan to a specified domain and problem.
     *
     * @return the solution plan or null.
     */
    @Override
    public Plan searchSolutionPlan() {
        Objects.requireNonNull(codedProblem);
        final Node solutionNode = search(this.stateSpacePlanner, codedProblem);
        if (solutionNode != null) {
            return extract(solutionNode, codedProblem);
        } else {
            return null;
        }
    }

    /**
     * Extract a plan from a solution node for the specified planning problem.
     *
     * @param node    the solution node.
     * @param problem the problem to be solved. The problem cannot be null.
     * @return the solution plan or null is no solution was found.
     */
    @Override
    public SequentialPlan extract(final Node node, final CodedProblem problem) {
        if (node != null) {
            Node n = node;
            final SequentialPlan plan = new SequentialPlan();
            while (n.getParent() != null) {
                final BitOp op = problem.getOperators().get(n.getOperator());
                plan.add(0, op);
                n = n.getParent();
            }
            return plan;
        } else {
            return null;
        }
    }
}
