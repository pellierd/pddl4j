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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * This class implements a parsed problem from the PDDL parser.
 *
 * @author D. Pellier
 * @version 1.0 - 28.06.2021
 */
public class ParsedProblem implements PDDLDomain, PDDLProblem {

    /**
     * The name of the domain.
     */
    private PDDLSymbol domainName;

    /**
     * The set of requirements.
     */
    private Set<PDDLRequireKey> requirements;

    /**
     * The list of types declared in the domain.
     */
    private List<PDDLTypedSymbol> types;

    /**
     * The list of constants declared in the domain.
     */
    private List<PDDLTypedSymbol> constants;

    /**
     * The list of predicates used in the domain and the problem.
     */
    private List<PDDLNamedTypedList> predicates;

    /**
     * The list of functions used in the domain and the problem.
     */
    private List<PDDLNamedTypedList> functions;

    /**
     * The list of functions used in the domain and the problem.
     */
    private List<PDDLNamedTypedList> tasks;

    /**
     * The constraints declared in the domain.
     */
    private PDDLExpression constraints;

    /**
     * The list of actions of the domain.
     */
    private List<PDDLAction> actions;

    /**
     * The list of methods of the domain.
     */
    private List<PDDLMethod> methods;

    /**
     * The list of derived predicates of the domain.
     */
    private List<PDDLDerivedPredicate> derivedPredicates;

    /**
     * The problemName of the problem.
     */
    private PDDLSymbol problemName;

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
     * The metric constraints of the problem.
     */
    private PDDLExpression metric;

    /**
     * Creates a new domain.
     */
    private ParsedProblem() {
    }

    /**
     * Creates a new parsed problem with a specific problemName of domain.
     *
     * @param domain the problemName of the domain.
     */
    public ParsedProblem(final PDDLSymbol domain) {
        this();
        // Attributes of a domain
        this.domainName = domain;
        this.requirements = new LinkedHashSet<>();
        this.types = new ArrayList<>();
        this.types.add(new PDDLTypedSymbol(PDDLParser.OBJECT));
        this.constants = new ArrayList<>();
        this.predicates = new ArrayList<>();
        this.functions = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.constraints = null;
        this.actions = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.derivedPredicates = new ArrayList<>();
        // Attributes of a problem
        this.problemName = null;
        this.objects = new ArrayList<>();
        this.initialTaskNetwork = null;
        this.initialFacts = new ArrayList<>();
        this.goal = null;
        this.constraints = null;
        this.metric = null;
    }

    /**
     * Creates a new problem with a specific problem and domain.
     *
     * @param problem the name of the problem.
     * @param domain the name of the domain.
     */
    public ParsedProblem(final PDDLSymbol problem, final PDDLSymbol domain) {
        this(domain);
        this.problemName = problem;
        this.requirements = new LinkedHashSet<>();
        this.objects = new ArrayList<>();
        this.initialTaskNetwork = null;
        this.initialFacts = new ArrayList<>();
        this.goal = null;
        this.constraints = null;
        this.metric = null;
    }

    /**
     * Creates a new parsed problem from a specific domain and problem.
     *
     * @param domain the domain.
     * @param problem the problem.
     */
    public ParsedProblem(final PDDLDomain domain, PDDLProblem problem) {
        this(domain.getDomainName(), problem.getProblemName());
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
     * Returns the problemName of the domain.
     *
     * @return the problemName of the domain.
     */
    public final PDDLSymbol getDomainName() {
        return this.domainName;
    }

    /**
     * Sets a problemName to the domain.
     *
     * @param name the problemName to set.
     */
    public final void setDomainName(final PDDLSymbol name) {
        this.domainName = name;
    }

    /**
     * Returns the set of requirements.
     *
     * @return the set of requirements.
     */
    public final Set<PDDLRequireKey> getRequirements() {
        return this.requirements;
    }

    /**
     * Adds a requirements to the domain.
     *
     * @param requirement the requirement to add.
     * @return <code>true</code> if the requirement was added; <code>false</code> otherwise.
     */
    public final boolean addRequirement(final PDDLRequireKey requirement) {
        return this.requirements.add(requirement);
    }

    /**
     * Returns the parsed types in the domain file.
     *
     * @return the parsed types in the domain file.
     */
    public final List<PDDLTypedSymbol> getTypes() {
        return this.types;
    }

    /**
     * Adds a type to the domain.
     *
     * @param type the type to add.
     * @return <code>true</code> if the type was added; <code>false</code> otherwise.
     */
    public final boolean addType(final PDDLTypedSymbol type) {
        return this.types.add(type);
    }

    /**
     * Returns the parsed constants in the domain file.
     *
     * @return the parsed constants in the domain file.
     */
    public final List<PDDLTypedSymbol> getConstants() {
        return this.constants;
    }

    /**
     * Adds a constant to the domain.
     *
     * @param constant the constant to add.
     * @return <code>true</code> if the constant was added; <code>false</code> otherwise.
     */
    public final boolean addConstant(final PDDLTypedSymbol constant) {
        return this.constants.add(constant);
    }

    /**
     * Returns the parsed predicates in the domain file.
     *
     * @return the parsed predicates in the domain file.
     */
    public final List<PDDLNamedTypedList> getPredicates() {
        return this.predicates;
    }

    /**
     * Adds a predicate to the domain.
     *
     * @param predicate the predicate to add.
     * @return <code>true</code> if the predicate was added; <code>false</code> otherwise.
     * @throws NullPointerException if the specified predicate is null.
     */
    public final boolean addPredicate(final PDDLNamedTypedList predicate) {
        if (predicate == null) {
            throw new NullPointerException();
        }
        return this.predicates.add(predicate);
    }

    /**
     * Returns the parsed functions in the domain file.
     *
     * @return the parsed functions in the domain file.
     */
    public final List<PDDLNamedTypedList> getFunctions() {
        return this.functions;
    }

    /**
     * Adds a function to the domain.
     *
     * @param function the function to add.
     * @return <code>true</code> if the function was added; <code>false</code> otherwise.
     */
    public final boolean addFunction(final PDDLNamedTypedList function) {
        return this.functions.add(function);
    }

    /**
     * Returns the parsed tasks un the domain file.
     *
     * @return the parsed tasks in the domain file.
     */
    public final List<PDDLNamedTypedList> getTasks() {
        return this.tasks;
    }

    /**
     * Adds a task to the domain.
     *
     * @param task the task to add.
     * @return <code>true</code> if the task was added; <code>false</code> otherwise.
     */
    public final boolean addTask(final PDDLNamedTypedList task) {
        return this.tasks.add(task);
    }

    /**
     * Returns the constraints loaded in the domain file.
     *
     * @return the constraints loaded in the domain file or null if the domain has no constraints.
     */
    public final PDDLExpression getConstraints() {
        return this.constraints;
    }

    /**
     * Sets the constraints to the domain.
     *
     * @param constraints the constraint of the domain.
     */
    public final void setConstraints(final PDDLExpression constraints) {
        this.constraints = constraints;
    }

    /**
     * Returns the list of parsed actions.
     *
     * @return the list of parsed actions.
     */
    public final List<PDDLAction> getActions() {
        return this.actions;
    }

    /**
     * Adds an action to the domain.
     *
     * @param action the action to add.
     * @return <code>true</code> if the action was added; <code>false</code> otherwise.
     */
    public final boolean addAction(final PDDLAction action) {
        this.tasks.add(action.toTask());
        return this.actions.add(action);
    }

    /**
     * Returns the list of parsed methods.
     *
     * @return the list of parsed methods.
     */
    public final List<PDDLMethod> getMethods() {
        return this.methods;
    }

    /**
     * Adds a method to the domain.
     *
     * @param method the method to add.
     * @return <code>true</code> if the method was added; <code>false</code> otherwise.
     */
    public final boolean addMethod(final PDDLMethod method) {
        return this.methods.add(method);
    }

    /**
     * Returns the list of parsed derived predicates.
     *
     * @return the list of parsed derived predicates.
     */
    public final List<PDDLDerivedPredicate> getDerivesPredicates() {
        return this.derivedPredicates;
    }

    /**
     * Adds a derived predicate to the domain.
     *
     * @param predicate the derived predicate to add.
     * @return <code>true</code> if the derived predicate was added; <code>false</code> otherwise.
     * @throws NullPointerException if the specified predicate is null.
     */
    public final boolean addDerivedPredicate(final PDDLDerivedPredicate predicate) {
        if (predicate == null) {
            throw new NullPointerException();
        }
        return this.derivedPredicates.add(predicate);
    }

    /**
     * Returns if a specified type symbol was declared.
     *
     * @param type the type symbol.
     * @return <code>true</code> if the specified symbol is a declared type; <code>false</code> otherwise.
     */
    public boolean isDeclaredType(final PDDLSymbol type) {
        return this.types.contains(type);
    }

    /**
     * Returns the type from a specified symbol.
     *
     * @param symbol The symbol.
     * @return the type from a specified symbol or <code>null</code> if no type with this symbol was declared.
     */
    public PDDLTypedSymbol getType(PDDLSymbol symbol) {
        int index = this.types.indexOf(symbol);
        return (index == -1) ? null : this.types.get(index);
    }

    /**
     * Returns if a specified constant symbol was declared.
     *
     * @param constant the constant symbol.
     * @return <code>true</code> if the specified symbol is a declared constant; <code>false</code> otherwise.
     */
    public boolean isDeclaredConstant(final PDDLSymbol constant) {
        return this.types.contains(constant);
    }

    /**
     * Returns the constant from a specified symbol.
     *
     * @param symbol The symbol.
     * @return the constant from a specified symbol or <code>null</code> if no constant with this
     *          symbol was declared.
     */
    public PDDLTypedSymbol getConstant(PDDLSymbol symbol) {
        int index = this.constants.indexOf(symbol);
        return (index == -1) ? null : this.constants.get(index);
    }

    /**
     * Return the problemName of the problem.
     *
     * @return the problemName of the problem.
     */
    public final PDDLSymbol getProblemName() {
        return this.problemName;
    }

    /**
     * Sets the problemName of the problem.
     *
     * @param problemName the problemName to set.
     */
    public final void setProblemName(final PDDLSymbol problemName) {
        this.problemName = problemName;
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
     * Return if this parsed problem is equal to another specified object.
     *
     * @param object the other object.
     * @return <code>true</code> if the specified object is a non <code>null</code> instance of
     *          the class <code>ParsedProblem</code> and has the same problem and domain name;
     *          <code>false</code> otherwise.
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof ParsedProblem) {
            ParsedProblem other = (ParsedProblem) object;
            return this.problemName == null
                ? this.domainName.equals(other.domainName) && other.problemName == null
                : this.domainName.equals(other.domainName) && this.problemName.equals(other.problemName);
        }
        return false;
    }

    /**
     * Returns the hash code value of this parsed problem.
     *
     * @return the hash code value of this  parsed problem..
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.domainName, this.problemName);
    }

    /**
     * Returns if the types of two typed symbol matched, i.e., if the types of the first typed
     * symbol can be viewed as a subtype of the second.
     *
     * @param s1 the first typed symbol.
     * @param s2 the second typed symbol.
     * @return <code>true</code> if the types of the first typed symbol can be viewed as a subtype
     *          of the seconds. <code>false</code> otherwise.
     */
    public boolean isSubType(PDDLTypedSymbol s1, PDDLTypedSymbol s2) {
        List<PDDLSymbol> copy = new LinkedList<>(s1.getTypes());
        copy.retainAll(s2.getTypes());
        boolean isSubType = !copy.isEmpty();
        Iterator<PDDLSymbol> i = s1.getTypes().iterator();
        while (i.hasNext() && !isSubType) {
            PDDLTypedSymbol type = this.getType(i.next());
            LinkedList<PDDLTypedSymbol> stack = new LinkedList<>();
            stack.push(type);
            while (!stack.isEmpty() && !isSubType) {
                PDDLTypedSymbol t = stack.poll();
                copy = new LinkedList<>(t.getTypes());
                copy.retainAll(s2.getTypes());
                isSubType = !copy.isEmpty();
                t.getTypes().stream().filter(s -> !s.equals(PDDLParser.OBJECT))
                    .forEach(s -> stack.push(this.getType(s)));
            }
        }
        return isSubType;
    }

    /**
     * Normalize the domain. This method rename the variables used in the domain and normalize its
     * actions and derived predicates.
     *
     * @see PDDLAction#normalize()
     * @see PDDLDerivedPredicate#normalize()
     */
    public void standardize() {
        // Rename all the variables from the predicates declaration
        for (int i = 0; i < this.getPredicates().size(); i++) {
            this.getPredicates().get(i).renameVariables();
        }
        // Rename all the variables from the functions declaration
        for (int i = 0; i < this.getFunctions().size(); i++) {
            this.getFunctions().get(i).renameVariables();
        }
        // Rename all the variables from the tasks declaration
        for (int i = 0; i < this.getTasks().size(); i++) {
            this.getTasks().get(i).renameVariables();
        }
        // Rename all the variables from the constraints declaration of the domain
        if (this.getConstraints() != null) {
            this.getConstraints().renameVariables();
            this.getConstraints().moveNegationInward();
        }
        // Rename all the variables from the derived predicates
        for (int i = 0; i < this.getDerivesPredicates().size(); i++) {
            this.getDerivesPredicates().get(i).normalize();
        }
        // Rename all the variable from the actions
        for (int i = 0; i < this.getActions().size(); i++) {
            this.getActions().get(i).normalize();
        }
        // Rename all the variable from the methods
        for (int i = 0; i < this.getMethods().size(); i++) {
            this.getMethods().get(i).normalize();
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
     * Returns a string representation of this domain.
     *
     * @return a string representation of this domain.
     */
    public String toString() {
        return this.problemName == null ? this.toPDDLDomainString() :
            this.toPDDLDomainString() + " \n\n" + this.toPDDLProblemString();
    }

    /**
     * Returns a string representation of this domain.
     *
     * @return a string representation of this domain.
     */
    private String toPDDLDomainString() {
        StringBuilder str = new StringBuilder();
        str.append("(define (domain ").append(this.domainName).append(")").append("\n(:requirements");
        for (PDDLRequireKey r : this.requirements) {
            str.append(" ").append(r);
        }
        str.append(")\n");
        if (!this.types.isEmpty()) {
            str.append("(:types ");
            this.types.stream().filter(type -> !type.equals(PDDLParser.OBJECT) && !type.equals(PDDLParser.NUMBER))
                .forEach(type -> str.append("\n  ").append(type));
            str.append("\n)\n");
        }
        if (!this.constants.isEmpty()) {
            str.append("(:constants ");
            for (PDDLTypedSymbol c : this.constants) {
                str.append("\n  ").append(c);
            }
            str.append("\n)\n");
        }
        if (!this.predicates.isEmpty()) {
            str.append("(:predicates ");
            for (PDDLNamedTypedList p : this.predicates) {
                str.append("\n  ").append(p);
            }
            str.append("\n)\n");
        }
        if (!this.functions.isEmpty()) {
            str.append("(:functions ");
            for (PDDLNamedTypedList p : this.functions) {
                str.append("\n  ").append(p);
            }
            str.append("\n  )\n");
        }
        if (!this.tasks.isEmpty()) {
            str.append("(:tasks ");
            for (PDDLNamedTypedList p : this.tasks) {
                str.append("\n  ").append(p);
            }
            str.append("\n  )\n");
        }
        if (this.constraints != null) {
            str.append("(:constraints ").append("  ").append(this.constraints).append(")\n");
        }
        for (PDDLDerivedPredicate dp : this.derivedPredicates) {
            str.append(dp).append("\n");
        }
        for (PDDLAction op : this.actions) {
            str.append(op).append("\n");
        }
        for (PDDLMethod meth : this.methods) {
            str.append(meth).append("\n");
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of this problem.
     *
     * @return a string representation of this problem.
     */
    private String toPDDLProblemString() {
        StringBuilder str = new StringBuilder();
        str.append("(define (problem ").append(this.problemName).append(")").append("\n(:domain ")
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
