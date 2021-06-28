/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.parser;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * This interface defines the methods of a planning problem read by the parser.
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public interface PDDLProblem extends Serializable {

    /**
     * Returns the name of the domain.
     *
     * @return the name of the domain.
     */
    PDDLSymbol getDomainName();

    /**
     * Sets a name to the domain.
     *
     * @param name the name to set.
     */
    void setDomainName(final PDDLSymbol name);

    /**
     * Return the name of the problem.
     *
     * @return the name of the problem.
     */
    PDDLSymbol getProblemName();

    /**
     * Sets the name of the problem.
     *
     * @param name the name to set.
     */
    void setProblemName(final PDDLSymbol name);

    /**
     * Returns the set of requirements.
     *
     * @return the set of requirements.
     */
    Set<PDDLRequireKey> getRequirements();

    /**
     * Adds a requirements to the domain.
     *
     * @param requirement the requirement to add.
     * @return <code>true</code> if the requirement was added; <code>false</code> otherwise.
     */
    boolean addRequirement(final PDDLRequireKey requirement);

    /**
     * Returns the list of objects declared in the problem file.
     *
     * @return the list of objects declared in the problem file.
     */
    List<PDDLTypedSymbol> getObjects();

    /**
     * Adds an object to the problem.
     *
     * @param object the object to add.
     * @return <code>true</code> if the object was added; <code>false</code> otherwise.
     */
    boolean addObject(final PDDLTypedSymbol object);

    /**
     * Set the initial task network of the problem.
     *
     * @param network The task network to set.
     */
    void setInitialTaskNetwork(final PDDLTaskNetwork network);

    /**
     * Returns the task network of the problem.
     *
     * @return the task network of the problem. The task network may null if it is not defined.
     */
    PDDLTaskNetwork getInitialTaskNetwork();

    /**
     * Returns the list of initial facts defined in the problem file.
     *
     * @return the list of initial facts defined in the problem file.
     */
    List<PDDLExpression> getInit();

    /**
     * Adds an initial fact to the problem.
     *
     * @param fact the fact to add.
     * @return <code>true</code> if the fact was added; <code>false</code> otherwise.
     */
    boolean addInitialFact(final PDDLExpression fact);

    /**
     * Returns the list of goal defined in the problem file.
     *
     * @return the list of goal defined in the problem file.
     */
    PDDLExpression getGoal();

    /**
     * Set the goal of this problem.
     *
     * @param goal the goal of this problem.
     */
    void setGoal(final PDDLExpression goal);

    /**
     * Returns the metric of the problem or <code>null</code> if the problem has no metric specification.
     *
     * @return the metric of the problem or <code>null</code> if the problem has no metric specification.
     */
    PDDLExpression getMetric();

    /**
     * Returns the constraints loaded in the domain file.
     *
     * @return the constraints loaded in the domain file or null if the domain has no constraints.
     */
    PDDLExpression getConstraints();

    /**
     * Sets the constraints to the domain.
     *
     * @param constraints the constraint of the domain.
     */
    void setConstraints(final PDDLExpression constraints);

    /**
     * Sets the metric of the problem.
     *
     * @param metric the metric to set.
     */
    void setMetric(final PDDLExpression metric);

    /**
     * Returns the object from a specified symbol.
     *
     * @param symbol The symbol.
     * @return the object from a specified symbol or <code>null</code> if no object with this symbol was declared.
     */
    PDDLTypedSymbol getObject(final PDDLSymbol symbol);

    /**
     * Normalize the problem. This method renames the variables and then move inward the negation of
     * the goal and the constraints of the problem.
     *
     * @see PDDLAction#normalize()
     * @see PDDLDerivedPredicate#normalize()
     */
    void standardize();

    /**
     * Returns a string representation of this problem.
     *
     * @return a string representation of this problem.
     */
    String toString();
}
