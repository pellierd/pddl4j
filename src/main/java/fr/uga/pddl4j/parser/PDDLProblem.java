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

import fr.uga.pddl4j.problem.Problem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class implements a planning problem read by the parser.
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public class PDDLProblem extends PDDLDomain {

    /**
     * The name of the problem.
     */
    private PDDLSymbol name;

    /**
     * The set of requirements.
     */
    private Set<PDDLRequireKey> requirements;

    /**
     * The list of objects declared in the problem.
     */
    private List<PDDLTypedSymbol> objects;

    /**
     * The task network of the problem.
     */
    private PDDLTaskNetwork initialTaskNetwork;

    /**
     * The list of initial facts declared in the problem.
     */
    private List<PDDLExpression> initialFacts;

    /**
     * The goal of the problem.
     */
    private PDDLExpression goal;

    /**
     * The constraints declared in the problem.
     */
    private PDDLExpression constraints;

    /**
     * The metric constraints of the problem.
     */
    private PDDLExpression metric;


    /**
     * Creates a new problem from a specific domain and problem.
     *
     * @param domain the domain.
     * @param problem the problem.
     */
    public PDDLProblem(final PDDLDomain domain, PDDLProblem problem) {
        this(domain.getDomainName(), problem.getName());
        this.requirements = new LinkedHashSet<>();
        this.requirements.addAll(domain.getRequirements());
        this.requirements.addAll(problem.getRequirements());

        for (PDDLTypedSymbol type : domain.getTypes()) {
            this.addType(type);
        }

        for (PDDLTypedSymbol constant : domain.getConstants()) {
            this.addConstant(constant);
        }

        for (PDDLNamedTypedList predicate : domain.getPredicates()) {
            this.addPredicate(predicate);
        }

        for (PDDLNamedTypedList function : domain.getFunctions()) {
            this.addFunction(function);
        }

        for (PDDLNamedTypedList task : domain.getTasks()) {
            this.addTask(task);
        }

        this.constraints = domain.getConstraints();

        for (PDDLAction action : domain.getActions()) {
            this.addAction(action);
        }

        for (PDDLMethod method : domain.getMethods()) {
            this.addMethod(method);
        }

        for (PDDLDerivedPredicate derived : domain.getDerivesPredicates()) {
            this.addDerivedPredicate(derived);
        }

        this.objects = problem.getObjects();
        this.initialTaskNetwork = problem.getInitialTaskNetwork();
        this.initialFacts = problem.getInit();
        this.goal = problem.getGoal();
        this.constraints = problem.getConstraints();
        this.metric = problem.getMetric();
    }

    /**
     * Creates a new problem with a specific name.
     *
     * @param name the name of the problem.
     * @param domain the name of the domain.
     */
    public PDDLProblem(final PDDLSymbol name, final PDDLSymbol domain) {
        super(domain);
        this.name = name;
        this.requirements = new LinkedHashSet<>();
        this.objects = new ArrayList<>();
        this.initialTaskNetwork = null;
        this.initialFacts = new ArrayList<>();
        this.goal = null;
        this.constraints = null;
        this.metric = null;
    }

    /**
     * Return the name of the problem.
     *
     * @return the name of the problem.
     */
    public final PDDLSymbol getName() {
        return this.name;
    }

    /**
     * Sets the name of the problem.
     *
     * @param name the name to set.
     */
    public final void setName(final PDDLSymbol name) {
        this.name = name;
    }

    /**
     * Returns the list of objects declared in the problem file.
     *
     * @return the list of objects declared in the problem file.
     */
    public List<PDDLTypedSymbol> getObjects() {
        return this.objects;
    }

    /**
     * Adds an object to the problem.
     *
     * @param object the object to add.
     * @return <code>true</code> if the object was added; <code>false</code> otherwise.
     */
    public final boolean addObject(final PDDLTypedSymbol object) {
        return this.objects.add(object);
    }

    /**
     * Set the initial task network of the problem.
     *
     * @param network The task network to set.
     */
    public final void setInitialTaskNetwork(final PDDLTaskNetwork network) {
        this.initialTaskNetwork = network;
    }

    /**
     * Returns the task network of the problem.
     *
     * @return the task network of the problem. The task network may null if it is not defined.
     */
    public final PDDLTaskNetwork getInitialTaskNetwork() {
        return this.initialTaskNetwork;
    }

    /**
     * Returns the list of initial facts defined in the problem file.
     *
     * @return the list of initial facts defined in the problem file.
     */
    public List<PDDLExpression> getInit() {
        return this.initialFacts;
    }

    /**
     * Adds an initial fact to the problem.
     *
     * @param fact the fact to add.
     * @return <code>true</code> if the fact was added; <code>false</code> otherwise.
     */
    public final boolean addInitialFact(final PDDLExpression fact) {
        return this.initialFacts.add(fact);
    }

    /**
     * Returns the list of goal defined in the problem file.
     *
     * @return the list of goal defined in the problem file.
     */
    public PDDLExpression getGoal() {
        return this.goal;
    }

    /**
     * Set the goal of this problem.
     *
     * @param goal the goal of this problem.
     */
    public void setGoal(final PDDLExpression goal) {
        this.goal = goal;
    }

    /**
     * Returns the metric of the problem or <code>null</code> if the problem has no metric specification.
     *
     * @return the metric of the problem or <code>null</code> if the problem has no metric specification.
     */
    public PDDLExpression getMetric() {
        return this.metric;
    }

    /**
     * Sets the metric of the problem.
     *
     * @param metric the metric to set.
     */
    public final void setMetric(final PDDLExpression metric) {
        this.metric = metric;
    }

    /**
     * Returns the object from a specified symbol.
     *
     * @param symbol The symbol.
     * @return the object from a specified symbol or <code>null</code> if no object with this symbol was declared.
     */
    public final PDDLTypedSymbol getObject(final PDDLSymbol symbol) {
        final int index = this.objects.indexOf(symbol);
        return (index == -1) ? null : this.objects.get(index);
    }

    /**
     * Normalize the problem. This method renames the variables and then move inward the negation of
     * the goal and the constraints of the problem.
     *
     * @see PDDLAction#normalize()
     * @see PDDLDerivedPredicate#normalize()
     */
    public void standardize() {
        super.standardize();
        // Rename the constraints of the problem
        if (this.getConstraints() != null) {
            this.getConstraints().renameVariables();
            this.getConstraints().moveNegationInward();
        }
        // Rename the goal of the problem
        if (this.getGoal() != null) {
            this.getGoal().renameVariables();
            this.getGoal().moveNegationInward();
        }
        // Standardize the initial task network
        if (this.getInitialTaskNetwork() != null) {
            final PDDLTaskNetwork tn = this.getInitialTaskNetwork();
            if (tn.getTasks().getChildren().size() == 1) {
                tn.setTotallyOrdered(true);
            }
            // Rename task id the tasks contained the method.
            final Map<String, String> taskIDCtx = new LinkedHashMap<>();
            tn.getTasks().renameTaskIDs(taskIDCtx);
            // Rename the tag ID used in the ordering constraints of the method
            tn.getOrderingConstraints().renameTaskIDs(taskIDCtx);
            // In this case enumerate the orderings contraints in the cas of totally ordered
            if (tn.isTotallyOrdered()) {
                tn.setOrderingConstraints(new PDDLExpression(PDDLConnective.AND));
                for (int i = 1; i < tn.getTasks().getChildren().size(); i++) {
                    PDDLExpression c = new PDDLExpression(PDDLConnective.LESS_ORDERING_CONSTRAINT);
                    c.setAtom(new LinkedList<PDDLSymbol>());
                    c.getAtom().add(tn.getTasks().getChildren().get(i - 1).getTaskID());
                    c.getAtom().add(tn.getTasks().getChildren().get(i).getTaskID());
                    tn.getOrderingConstraints().addChild(c);
                }
            }
        }
    }

    /**
     * Returns a string representation of this problem.
     *
     * @return a string representation of this problem.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("(define (problem ").append(this.name).append(")").append("\n(:domain ")
            .append(this.getDomainName()).append(")").append("\n(:requirements");
        for (PDDLRequireKey r : this.requirements) {
            str.append(" ").append(r);
        }
        str.append(")\n");
        if (!this.objects.isEmpty()) {
            str.append("(:objects ");
            for (PDDLTypedSymbol obj : this.objects) {
                str.append("\n  ").append(obj);
            }
            str.append("\n)\n");
        }
        if (this.initialTaskNetwork != null) {
            str.append("(:htn\n");
            str.append(this.initialTaskNetwork.toString());
            str.append("\n)\n");
        }
        str.append("(:initialization");
        for (PDDLExpression fact : this.initialFacts) {
            str.append("\n  ").append(fact);
        }
        str.append("\n)\n");
        if (this.getGoal() != null) {
            str.append("\n)\n").append("(:goal ").append("  ").append(this.goal).append(")\n");
        }
        if (this.constraints != null) {
            str.append("(:constraints ").append("  ").append(this.constraints).append(")\n");
        }
        if (this.metric != null) {
            str.append("(:metric ").append("  ").append(this.metric).append(")\n");
        }
        str.append(")");
        return str.toString();
    }
}
