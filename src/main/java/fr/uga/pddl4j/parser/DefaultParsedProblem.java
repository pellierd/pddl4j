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
 * This class implements a parsed problem. This object is returned by the parser after parsing.
 *
 * @author D. Pellier
 * @version 1.0 - 28.06.2021
 */
public class DefaultParsedProblem implements ParsedDomain, ParsedProblem {

    /**
     * The name of the domain.
     */
    private Symbol<String> domainName;

    /**
     * The set of requirements.
     */
    private Set<RequireKey> requirements;

    /**
     * The list of types declared in the domain.
     */
    private List<TypedSymbol<String>> types;

    /**
     * The list of constants declared in the domain.
     */
    private List<TypedSymbol<String>> constants;

    /**
     * The list of predicates used in the domain and the problem.
     */
    private List<NamedTypedList> predicates;

    /**
     * The list of functions used in the domain and the problem.
     */
    private List<NamedTypedList> functions;

    /**
     * The list of functions used in the domain and the problem.
     */
    private List<NamedTypedList> tasks;

    /**
     * The constraints declared in the domain.
     */
    private Expression<String> constraints;

    /**
     * The list of actions of the domain.
     */
    private List<ParsedAction> actions;

    /**
     * The list of methods of the domain.
     */
    private List<ParsedMethod> methods;

    /**
     * The list of derived predicates of the domain.
     */
    private List<ParsedDerivedPredicate> derivedPredicates;

    /**
     * The problemName of the problem.
     */
    private Symbol<String> problemName;

    /**
     * The list of objects declared in the problem.
     */
    private List<TypedSymbol<String>> objects;

    /**
     * The task network of the problem.
     */
    private ParsedTaskNetwork initialTaskNetwork;

    /**
     * The list of initial facts declared in the problem.
     */
    private List<Expression<String>> initialFacts;

    /**
     * The goal of the problem.
     */
    private Expression<String> goal;


    /**
     * The metric constraints of the problem.
     */
    private Expression<String> metric;

    /**
     * Creates a new domain.
     */
    private DefaultParsedProblem() {
    }

    /**
     * Creates a new parsed problem with a specific problemName of domain.
     *
     * @param domain the problemName of the domain.
     */
    public DefaultParsedProblem(final Symbol<String> domain) {
        this();
        // Attributes of a domain
        this.domainName = domain;
        this.requirements = new LinkedHashSet<>();
        this.types = new ArrayList<>();
        this.types.add(new TypedSymbol<String>(Symbol.OBJECT_TYPE));
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
    public DefaultParsedProblem(final Symbol<String> problem, final Symbol<String> domain) {
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
    public DefaultParsedProblem(final ParsedDomain domain, ParsedProblem problem) {
        this(domain.getDomainName(), problem.getProblemName());
        this.requirements = new LinkedHashSet<>();
        this.requirements.addAll(domain.getRequirements());
        this.requirements.addAll(problem.getRequirements());

        for (TypedSymbol<String> type : domain.getTypes()) {
            this.addType(type);
        }

        for (TypedSymbol<String> constant : domain.getConstants()) {
            this.addConstant(constant);
        }

        for (NamedTypedList predicate : domain.getPredicates()) {
            this.addPredicate(predicate);
        }

        for (NamedTypedList function : domain.getFunctions()) {
            this.addFunction(function);
        }

        for (NamedTypedList task : domain.getTasks()) {
            this.addTask(task);
        }

        this.constraints = domain.getConstraints();

        for (ParsedAction action : domain.getActions()) {
            this.addAction(action);
        }

        for (ParsedMethod method : domain.getMethods()) {
            this.addMethod(method);
        }

        for (ParsedDerivedPredicate derived : domain.getDerivesPredicates()) {
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
    public final Symbol<String> getDomainName() {
        return this.domainName;
    }

    /**
     * Sets a problemName to the domain.
     *
     * @param name the problemName to set.
     */
    public final void setDomainName(final Symbol<String> name) {
        this.domainName = name;
    }

    /**
     * Returns the set of requirements.
     *
     * @return the set of requirements.
     */
    public final Set<RequireKey> getRequirements() {
        return this.requirements;
    }

    /**
     * Adds a requirements to the domain.
     *
     * @param requirement the requirement to add.
     * @return <code>true</code> if the requirement was added; <code>false</code> otherwise.
     */
    public final boolean addRequirement(final RequireKey requirement) {
        return this.requirements.add(requirement);
    }

    /**
     * Returns the parsed types in the domain file.
     *
     * @return the parsed types in the domain file.
     */
    public final List<TypedSymbol<String>> getTypes() {
        return this.types;
    }

    /**
     * Adds a type to the domain.
     *
     * @param type the type to add.
     * @return <code>true</code> if the type was added; <code>false</code> otherwise.
     */
    public final boolean addType(final TypedSymbol<String> type) {
        return this.types.add(type);
    }

    /**
     * Returns the parsed constants in the domain file.
     *
     * @return the parsed constants in the domain file.
     */
    public final List<TypedSymbol<String>> getConstants() {
        return this.constants;
    }

    /**
     * Adds a constant to the domain.
     *
     * @param constant the constant to add.
     * @return <code>true</code> if the constant was added; <code>false</code> otherwise.
     */
    public final boolean addConstant(final TypedSymbol<String> constant) {
        return this.constants.add(constant);
    }

    /**
     * Returns the parsed predicates in the domain file.
     *
     * @return the parsed predicates in the domain file.
     */
    public final List<NamedTypedList> getPredicates() {
        return this.predicates;
    }

    /**
     * Adds a predicate to the domain.
     *
     * @param predicate the predicate to add.
     * @return <code>true</code> if the predicate was added; <code>false</code> otherwise.
     * @throws NullPointerException if the specified predicate is null.
     */
    public final boolean addPredicate(final NamedTypedList predicate) {
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
    public final List<NamedTypedList> getFunctions() {
        return this.functions;
    }

    /**
     * Adds a function to the domain.
     *
     * @param function the function to add.
     * @return <code>true</code> if the function was added; <code>false</code> otherwise.
     */
    public final boolean addFunction(final NamedTypedList function) {
        return this.functions.add(function);
    }

    /**
     * Returns the parsed tasks un the domain file.
     *
     * @return the parsed tasks in the domain file.
     */
    public final List<NamedTypedList> getTasks() {
        return this.tasks;
    }

    /**
     * Adds a task to the domain.
     *
     * @param task the task to add.
     * @return <code>true</code> if the task was added; <code>false</code> otherwise.
     */
    public final boolean addTask(final NamedTypedList task) {
        return this.tasks.add(task);
    }

    /**
     * Returns the constraints loaded in the domain file.
     *
     * @return the constraints loaded in the domain file or null if the domain has no constraints.
     */
    public final Expression<String> getConstraints() {
        return this.constraints;
    }

    /**
     * Sets the constraints to the domain.
     *
     * @param constraints the constraint of the domain.
     */
    public final void setConstraints(final Expression<String> constraints) {
        this.constraints = constraints;
    }

    /**
     * Returns the list of parsed actions.
     *
     * @return the list of parsed actions.
     */
    public final List<ParsedAction> getActions() {
        return this.actions;
    }

    /**
     * Adds an action to the domain.
     *
     * @param action the action to add.
     * @return <code>true</code> if the action was added; <code>false</code> otherwise.
     */
    public final boolean addAction(final ParsedAction action) {
        this.tasks.add(action.toTask());
        return this.actions.add(action);
    }

    /**
     * Returns the list of parsed methods.
     *
     * @return the list of parsed methods.
     */
    public final List<ParsedMethod> getMethods() {
        return this.methods;
    }

    /**
     * Adds a method to the domain.
     *
     * @param method the method to add.
     * @return <code>true</code> if the method was added; <code>false</code> otherwise.
     */
    public final boolean addMethod(final ParsedMethod method) {
        return this.methods.add(method);
    }

    /**
     * Returns the list of parsed derived predicates.
     *
     * @return the list of parsed derived predicates.
     */
    public final List<ParsedDerivedPredicate> getDerivesPredicates() {
        return this.derivedPredicates;
    }

    /**
     * Adds a derived predicate to the domain.
     *
     * @param predicate the derived predicate to add.
     * @return <code>true</code> if the derived predicate was added; <code>false</code> otherwise.
     * @throws NullPointerException if the specified predicate is null.
     */
    public final boolean addDerivedPredicate(final ParsedDerivedPredicate predicate) {
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
    public boolean isDeclaredType(final Symbol<String> type) {
        return this.types.contains(type);
    }

    /**
     * Returns the type from a specified symbol.
     *
     * @param symbol The symbol.
     * @return the type from a specified symbol or <code>null</code> if no type with this symbol was declared.
     */
    public TypedSymbol<String> getType(Symbol<String> symbol) {
        int index = this.types.indexOf(symbol);
        return (index == -1) ? null : this.types.get(index);
    }

    /**
     * Returns if a specified constant symbol was declared.
     *
     * @param constant the constant symbol.
     * @return <code>true</code> if the specified symbol is a declared constant; <code>false</code> otherwise.
     */
    public boolean isDeclaredConstant(final Symbol<String> constant) {
        return this.types.contains(constant);
    }

    /**
     * Returns the constant from a specified symbol.
     *
     * @param symbol The symbol.
     * @return the constant from a specified symbol or <code>null</code> if no constant with this
     *          symbol was declared.
     */
    public TypedSymbol<String> getConstant(Symbol<String> symbol) {
        int index = this.constants.indexOf(symbol);
        return (index == -1) ? null : this.constants.get(index);
    }

    /**
     * Return the problemName of the problem.
     *
     * @return the problemName of the problem.
     */
    public final Symbol<String> getProblemName() {
        return this.problemName;
    }

    /**
     * Sets the problemName of the problem.
     *
     * @param problemName the problemName to set.
     */
    public final void setProblemName(final Symbol<String> problemName) {
        this.problemName = problemName;
    }

    /**
     * Returns the list of objects declared in the problem file.
     *
     * @return the list of objects declared in the problem file.
     */
    public List<TypedSymbol<String>> getObjects() {
        return this.objects;
    }

    /**
     * Adds an object to the problem.
     *
     * @param object the object to add.
     * @return <code>true</code> if the object was added; <code>false</code> otherwise.
     */
    public final boolean addObject(final TypedSymbol<String> object) {
        return this.objects.add(object);
    }

    /**
     * Set the initial task network of the problem.
     *
     * @param network The task network to set.
     */
    public final void setInitialTaskNetwork(final ParsedTaskNetwork network) {
        this.initialTaskNetwork = network;
    }

    /**
     * Returns the task network of the problem.
     *
     * @return the task network of the problem. The task network may null if it is not defined.
     */
    public final ParsedTaskNetwork getInitialTaskNetwork() {
        return this.initialTaskNetwork;
    }

    /**
     * Returns the list of initial facts defined in the problem file.
     *
     * @return the list of initial facts defined in the problem file.
     */
    public List<Expression<String>> getInit() {
        return this.initialFacts;
    }

    /**
     * Adds an initial fact to the problem.
     *
     * @param fact the fact to add.
     * @return <code>true</code> if the fact was added; <code>false</code> otherwise.
     */
    public final boolean addInitialFact(final Expression<String> fact) {
        return this.initialFacts.add(fact);
    }

    /**
     * Returns the list of goal defined in the problem file.
     *
     * @return the list of goal defined in the problem file.
     */
    public Expression<String> getGoal() {
        return this.goal;
    }

    /**
     * Set the goal of this problem.
     *
     * @param goal the goal of this problem.
     */
    public void setGoal(final Expression<String> goal) {
        this.goal = goal;
    }

    /**
     * Returns the metric of the problem or <code>null</code> if the problem has no metric specification.
     *
     * @return the metric of the problem or <code>null</code> if the problem has no metric specification.
     */
    public Expression<String> getMetric() {
        return this.metric;
    }

    /**
     * Sets the metric of the problem.
     *
     * @param metric the metric to set.
     */
    public final void setMetric(final Expression<String> metric) {
        this.metric = metric;
    }

    /**
     * Returns the object from a specified symbol.
     *
     * @param symbol The symbol.
     * @return the object from a specified symbol or <code>null</code> if no object with this symbol was declared.
     */
    public final TypedSymbol<String> getObject(final Symbol<String> symbol) {
        final int index = this.objects.indexOf(symbol);
        return (index == -1) ? null : this.objects.get(index);
    }


    /**
     * Return if this parsed problem is equal to another specified object.
     *
     * @param object the other object.
     * @return <code>true</code> if the specified object is a non <code>null</code> instance of
     *          the class <code>DefaultParsedProblem</code> and has the same problem and domain name;
     *          <code>false</code> otherwise.
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof DefaultParsedProblem) {
            DefaultParsedProblem other = (DefaultParsedProblem) object;
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
    public boolean isSubType(TypedSymbol<String> s1, TypedSymbol<String> s2) {
        List<Symbol<String>> copy = new LinkedList<>(s1.getTypes());
        copy.retainAll(s2.getTypes());
        boolean isSubType = !copy.isEmpty();
        Iterator<Symbol<String>> i = s1.getTypes().iterator();
        while (i.hasNext() && !isSubType) {
            TypedSymbol<String> type = this.getType(i.next());
            LinkedList<TypedSymbol<String>> stack = new LinkedList<>();
            stack.push(type);
            while (!stack.isEmpty() && !isSubType) {
                TypedSymbol<String> t = stack.poll();
                copy = new LinkedList<>(t.getTypes());
                copy.retainAll(s2.getTypes());
                isSubType = !copy.isEmpty();
                t.getTypes().stream().filter(s -> !s.equals(Symbol.OBJECT_TYPE))
                    .forEach(s -> stack.push(this.getType(s)));
            }
        }
        return isSubType;
    }

    /**
     * Normalize the domain. This method rename the variables used in the domain and normalize its
     * actions and derived predicates.
     *
     */
    public void normalize() {
        // Rename all the variables from the predicates declaration
        for (int i = 0; i < this.getPredicates().size(); i++) {
            this.renameVariables(this.getPredicates().get(i));
        }
        // Rename all the variables from the functions declaration
        for (int i = 0; i < this.getFunctions().size(); i++) {
            this.renameVariables(this.getFunctions().get(i));
        }
        // Rename all the variables from the tasks declaration
        for (int i = 0; i < this.getTasks().size(); i++) {
            this.renameVariables(this.getTasks().get(i));
        }
        // Rename all the variables from the constraint declaration of the domain
        if (this.getConstraints() != null) {
            this.renameVariables(this.getConstraints());
            this.getConstraints().toNNF();
        }
        // Rename all the variables from the derived predicates
        for (int i = 0; i < this.getDerivesPredicates().size(); i++) {
            this.normalize(this.getDerivesPredicates().get(i));
        }

        // Rename all the variable from the actions
        for (int i = 0; i < this.getActions().size(); i++) {
            this.normalize(this.getActions().get(i));
        }
        // Rename all the variable from the methods
        for (int i = 0; i < this.getMethods().size(); i++) {
            this.normalize(this.getMethods().get(i));
        }

        // Rename the goal of the problem
        if (this.getGoal() != null) {
            this.renameVariables(this.getGoal());
            this.getGoal().simplify();
            this.getGoal().toNNF();
        }
        // Standardize the initial task network
        if (this.getInitialTaskNetwork() != null) {
            final ParsedTaskNetwork tn = this.getInitialTaskNetwork();
            if (tn.getTasks().getChildren().size() == 1) {
                tn.setTotallyOrdered(true);
            }
            // Rename task id the tasks contained the method.
            final Map<String, String> taskIDCtx = new LinkedHashMap<>();
            this.renameTaskIDs(tn.getTasks(), taskIDCtx);
            // Rename the tag ID used in the ordering constraints of the method
            this.renameTaskIDs(tn.getOrdering(), taskIDCtx);
            // In this case enumerate the orderings constraints in the cas of totally ordered
            if (tn.isTotallyOrdered()) {
                tn.setOrdering(new Expression<String>(Connector.AND));
                for (int i = 1; i < tn.getTasks().getChildren().size(); i++) {
                    Expression<String> c = new Expression<String>(Connector.LESS_ORDERING_CONSTRAINT);
                    c.setArguments(new LinkedList<Symbol<String>>());
                    c.getArguments().add(tn.getTasks().getChildren().get(i - 1).getTaskID());
                    c.getArguments().add(tn.getTasks().getChildren().get(i).getTaskID());
                    tn.getOrdering().addChild(c);
                }
            }
        }
    }

    /**
     * Normalizes the methods. This method renames the parameters of the operator used in its preconditions, its
     * effects and its durative constraints. It also simplifies all the logical expression and converts it into it
     * negative normal form. Not that imply expression are also replace by their disjunctive equivalence.
     *
     * @see Expression#simplify()
     * @see Expression#toNNF() ()
     */
    private final void normalize(ParsedAction action) {
        this.normalize(action, 0);
    }

    /**
     * Normalizes the operators. This method renames the parameters of the operator used in its preconditions, its
     * effects and its durative constraints. It also simplifies all the logical expression and converts it into it
     * negative normal form. Not that imply expression are also replace by their disjunctive equivalence.
     *
     * @param index the index of the first variable, index, i.e., ?Xi.
     * @return the renamed variable.
     * @see Expression#simplify()
     * @see Expression#toNNF() ()
     */
    private Map<String, String> normalize(ParsedAction action, int index) {
        final Map<String, String> context = this.normalizeParameters(action, index);
        // Rename the preconditions
        this.renameVariables(action.getPreconditions(), context);
        action.getPreconditions().simplify();
        action.getPreconditions().toNNF();
        this.renameVariables(action.getEffects(), context);
        action.getEffects().simplify();
        action.getEffects().toNNF();
        // Rename the duration if the operator is a durative action.
        if (action.getDuration() != null) {
            this.renameVariables(action.getDuration(), context);
        }
        return context;
    }

    /**
     * Normalizes the methods. This method renames the parameters of the operator used in its preconditions, its
     * effects and its durative constraints. It also simplifies all the logical expression and converts it into it
     * negative normal form. Not that imply expression are also replace by their disjunctive equivalence.
     *
     * @see Expression#simplify()
     * @see Expression#toNNF() ()
     */
    private final void normalize(ParsedMethod method) {
        this.normalize(method, 0);
    }

    /**
     * Normalizes the operators. This method renames the parameters of the operator used in its preconditions, and its
     * durative constraints. It also simplifies all the logical expression and converts it into it
     * negative normal form. Not that imply expression are also replace by their disjunctive equivalence. More over the
     * method rename the task ID.
     *
     * @param index the index of the first variable, index, i.e., ?Xi.
     * @see Expression#simplify()
     * @see Expression#toNNF()
     */
    private Map<String, String> normalize(ParsedMethod method, int index) {
        // Rename the parameters
        final Map<String, String> varCtx = this.normalizeParameters(method, index);
        // Rename the preconditions
        this.renameVariables(method.getPreconditions(), varCtx);
        method.getPreconditions().simplify();
        method.getPreconditions().toNNF();
        // Rename the variable to carried out task of the method.
        this.renameVariables(method.getTask(), varCtx);
        // Rename variables of the tasks contained the method.
        this.renameVariables(method.getSubTasks(), varCtx);
        if (method.getSubTasks().getChildren().size() == 1) {
            method.setTotallyOrdered(true);
        }
        // Rename task id the tasks contained the method.
        final Map<String, String> taskIDCtx = new LinkedHashMap<>();
        this.renameTaskIDs(method.getSubTasks(), taskIDCtx);
        // Rename the tag ID used in the durations constraints of the method
        if (method.isDurative()) {
            this.renameTaskIDs(method.getDuration(), taskIDCtx);
        }
        // Rename the tag ID used in the ordering constraints of the method
        this.renameTaskIDs(method.getOrdering(), taskIDCtx);
        // In this case enumerate the orderings constraints in the cas of totally ordered
        if (method.isTotallyOrdered()) {
            method.setOrdering(new Expression<String>(Connector.AND));
            for (int j = 1; j < method.getSubTasks().getChildren().size(); j++) {
                Expression<String> c = new Expression<String>(Connector.LESS_ORDERING_CONSTRAINT);
                c.setArguments(new LinkedList<Symbol<String>>());
                c.getArguments().add(method.getSubTasks().getChildren().get(j - 1).getTaskID());
                c.getArguments().add(method.getSubTasks().getChildren().get(j).getTaskID());
                method.getOrdering().addChild(c);
            }
        }
        // Rename the logical constraints
        this.renameVariables(method.getConstraints(), varCtx);
        Expression<String> preconditions = null;
        if (!method.getPreconditions().getConnector().equals(Connector.AND)) {
            preconditions = method.getPreconditions();
        } else {
            preconditions = new Expression<String>(Connector.AND);
            preconditions.addChild(method.getPreconditions());
        }
        Iterator<Expression<String>> i = method.getConstraints().getChildren().iterator();
        while (i.hasNext()) {
            final Expression<String> constraint = i.next();
            switch (constraint.getConnector()) {
                case EQUAL_COMPARISON:
                    preconditions.addChild(constraint);
                    i.remove();
                    break;
                case NOT:
                    if (constraint.getChildren().get(0).equals(Connector.EQUAL_COMPARISON)) {
                        preconditions.addChild(constraint);
                        i.remove();
                    }
                    break;
                default:
            }
        }
        method.setPreconditions(preconditions);
        method.getPreconditions().simplify();
        method.getPreconditions().toNNF();
        return varCtx;
    }

    /**
     * This method renames the variable of the derived predicated and simplifies its body before converting it into
     * negative normal form. Not that imply expression are also replace by their disjunctive equivalence.
     *
     * @see Expression#simplify()
     * @see Expression#toNNF()
     */
    private void normalize(final ParsedDerivedPredicate derivedPredicate) {
        // Rename the head of the derived predicate
        final Map<String, String> context = new LinkedHashMap<>();
        final List<TypedSymbol<String>> arguments = derivedPredicate.getHead().getArguments();
        for (int i = 0; i < arguments.size(); i++) {
            final TypedSymbol<String> argument = arguments.get(i);
            final String image = this.renameVariables(argument, i);
            context.put(image, argument.getValue());
        }
        // Rename the body of the derived predicate
        this.renameVariables(derivedPredicate.getBody(), context);
        derivedPredicate.getBody().simplify();
        derivedPredicate.getBody().toNNF();

    }

    /**
     * Normalizes the operators. This method renames the parameters of the operator used in its preconditions, its
     * effects and its durative constraints. It also simplifies all the logical expression and converts it into it
     * negative normal form. Not that imply expression are also replace by their disjunctive equivalence.
     *
     * @param index the index of the first variable, index, i.e., ?Xi.
     * @return the renamed variable.
     * @see Expression#simplify()
     * @see Expression#toNNF() ()
     */
    private Map<String, String> normalizeParameters(ParsedOperator operator, int index) {
        int i = index;
        // Rename the parameters
        final Map<String, String> context = new LinkedHashMap<>();
        final List<TypedSymbol<String>> parameters = operator.getParameters();
        for (final TypedSymbol<String> params : parameters) {
            final String image = this.renameVariables(params, i);
            context.put(image, params.getValue());
            i++;
        }
        return context;
    }

    /**
     * Renames the variables contained in the expression. The variable renames have the form ?X0,..., ?Xn.
     */
    private void renameVariables(Expression<String> exp) {
        this.renameVariables(exp, new LinkedHashMap<>());
    }

    /**
     * Renames the variables contained in the expression with a specified symbol, i.e., the variable
     * already renamed. The variable renames have the form ?X0, ..., ?Xn.
     *
     * @param context the images of the renamed variable.
     * @throws MalformedExpressionException if this expression is malformed.
     * @see Expression#isMalformedExpression()
     */
    private void renameVariables(final Expression<String> exp, final Map<String, String> context)
            throws MalformedExpressionException {
        if (exp.isMalformedExpression()) {
            throw new MalformedExpressionException("Expression " + exp.getConnector() + " is malformed");
        }
        switch (exp.getConnector()) {
            case ATOM:
            case FN_HEAD:
            case EQUAL_ATOM:
            case TASK:
                for (int i = 0; i < exp.getArguments().size(); i++) {
                    this.renameVariables(exp.getArguments().get(i), context);
                }
                break;
            case AND:
            case OR:
            case NOT:
            case IMPLY:
            case F_EXP_T:
            case EQUAL_COMPARISON:
            case FN_ATOM:
            case WHEN:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case MULTIPLICATION:
            case DIVISION:
            case MINUS:
            case PLUS:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case F_EXP:
            case ALWAYS_CONSTRAINT:
            case SOMETIME_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
            case WITHIN_CONSTRAINT:
            case ALWAYS_WITHIN_CONSTRAINT:
            case HOLD_DURING_CONSTRAINT:
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
                for (int i = 0; i < exp.getChildren().size(); i++) {
                    Expression<String> ei = exp.getChildren().get(i);
                    this.renameVariables(ei, context);
                }
                break;
            case FORALL:
            case EXISTS:
                for (int i = 0; i < exp.getQuantifiedVariables().size(); i++) {
                    final Symbol<String> var = exp.getQuantifiedVariables().get(i);
                    final String image = this.renameVariables(var, context.size() + 1);
                    context.put(image, var.getValue());
                }
                Expression<String> e0 = exp.getChildren().get(0);
                this.renameVariables(e0, context);
                break;
            case IS_VIOLATED:
            case NUMBER:
            case TASK_ID:
            case TIME_VAR:
            case TIMED_LITERAL:
            case TRUE:
            case FALSE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnector().toString());
        }
    }

    /**
     * Renames the symbol from a specified index. The symbol is renamed if only if this symbol is a
     * variable, otherwise nothing is done. After rename operation the variable will have the form
     * <code>?Xn</code> where <code>n</code> is the specified index.
     *
     * @param index the index of the symbol.
     * @return the old image of the symbol or null if the symbol was not renamed.
     * @throws IllegalArgumentException if index is &#60; 0.
     */
    private String renameVariables(final Symbol<String> symbol, final int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        String img = null;
        if (symbol.getType().equals(SymbolType.VARIABLE)) {
            img = symbol.getValue();
            symbol.setValue(Symbol.DEFAULT_VARIABLE_SYMBOL + index);
        }
        return img;
    }

    /**
     * Renames the variable contained in this typed list. For instance, if the nth argument is a
     * variable it will be rename <code>?Xn</code>.
     *
     */
    private void renameVariables(final NamedTypedList list) {
        for (int i = 0; i < list.getArguments().size(); i++) {
            this.renameVariables(list.getArguments().get(i), i);
        }
    }

    /**
     * Renames the symbol from a specified symbolEncoding. The symbol is renamed if only if this symbol is a
     * variable, otherwise nothing is done.
     *
     * @param context the images of the already renamed variables.
     * @return the old image of the symbol or null if the symbol was not renamed.
     * @throws NullPointerException if context == null.
     */
    private String renameVariables(final Symbol<String> symbol, final Map<String, String> context) {
        String img = null;
        if (symbol.getType().equals(SymbolType.VARIABLE)) {
            img = symbol.getValue();
            final String newImage = context.get(img);
            if (newImage != null) {
                symbol.setValue(newImage);
                return img;
            }
        }
        return null;
    }

    /**
     * Renames the task ID symbol according to a specific context. The symbol is renamed if only if this symbol is a
     * task ID, otherwise nothing is done.
     *
     * @paral symbol the task id symbol.
     * @param context the images of the already renamed task ID.
     * @return the old image of the symbol or null if the symbol was not renamed.
     */
    private String renameTaskID(Symbol<String> symbol, final Map<String, String> context) {
        if (symbol.getType().equals(SymbolType.TASK_ID)) {
            String image = symbol.getValue();
            String newImage = context.get(image);
            if (newImage == null) {
                newImage = Symbol.DEFAULT_TASK_ID_SYMBOL + context.size();
                context.put(image, newImage);
            }
            symbol.setValue(newImage);
            return image;
        }
        return null;
    }


    /**
     * Renames the tag of the tasks contained in the expression. The tag tasks renames have the form T0, ..., Tn.
     *
     * @param exp the expression to rename.
     */
    public void renameTaskIDs(Expression<String> exp) {
        this.renameTaskIDs(exp, new LinkedHashMap<>());
    }

    /**
     * Renames the ID of the task contained in the expression with a specified symbol, i.e., the tag tasks
     * already renamed. The ID of the task renames have the form T0, ..., Tn. In HDDL, only and expression are allowed
     * as tasks expression for the moment in method description.
     *
     * @param exp the expression to rename.
     * @param context the images of the renamed ID of the task.
     * @throws MalformedExpressionException if this expression is not an AND expression.
     * @see Expression#isMalformedExpression()
     */
    private void renameTaskIDs(Expression<String> exp, final Map<String, String> context)
            throws MalformedExpressionException {
        if (exp.isMalformedExpression()) {
            throw new MalformedExpressionException("Expression " + exp.getConnector() + " is malformed");
        }
        switch (exp.getConnector()) {
            case TASK:
                // Set a dummy taskID to task if no task taskID was specified
                if (exp.getTaskID() == null) {
                    String newTaskID = new String(Symbol.DEFAULT_TASK_ID_SYMBOL + context.size());
                    Symbol<String> taskID = new Symbol<String>(exp.getSymbol());
                    taskID.setType(SymbolType.TASK_ID);
                    taskID.setValue(newTaskID);
                    exp.setTaskID(taskID);
                    context.put(newTaskID, newTaskID);
                } else {
                    this.renameTaskID(exp.getTaskID(), context);
                }
                break;
            case F_TASK_TIME:
                exp.getArguments().get(0).rename(context);
                break;
            case LESS_ORDERING_CONSTRAINT:
            case LESS_OR_EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case GREATER_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case GREATER_OR_EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
            case EQUAL_ORDERING_CONSTRAINT: // Add method ordering HDDL2.1
                this.renameTaskID(exp.getChildren().get(0).getTaskID(), context);
                this.renameTaskID(exp.getChildren().get(1).getTaskID(), context);
                break;
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
                this.renameTaskID(exp.getChildren().get(0).getTaskID(), context);
                break;
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
                this.renameTaskID(exp.getChildren().get(0).getTaskID(), context);
                this.renameTaskID(exp.getChildren().get(1).getTaskID(), context);
                break;
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
                // do nothing
                break;
            default:
                for (int i = 0; i < exp.getChildren().size(); i++) {
                    Expression<String> ei = exp.getChildren().get(i);
                    this.renameTaskIDs(ei, context);
                }
                break;
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
        for (RequireKey r : this.requirements) {
            str.append(" ").append(r);
        }
        str.append(")\n");
        if (!this.types.isEmpty()) {
            str.append("(:types ");
            this.types.stream().filter(type -> !type.equals(Symbol.OBJECT_TYPE) && !type.equals(Symbol.NUMBER_TYPE))
                .forEach(type -> str.append("\n  ").append(type));
            str.append("\n)\n");
        }
        if (!this.constants.isEmpty()) {
            str.append("(:constants ");
            for (TypedSymbol<String> c : this.constants) {
                str.append("\n  ").append(c);
            }
            str.append("\n)\n");
        }
        if (!this.predicates.isEmpty()) {
            str.append("(:predicates ");
            for (NamedTypedList p : this.predicates) {
                str.append("\n  ").append(p);
            }
            str.append("\n)\n");
        }
        if (!this.functions.isEmpty()) {
            str.append("(:functions ");
            for (NamedTypedList p : this.functions) {
                str.append("\n  ").append(p);
            }
            str.append("\n  )\n");
        }
        if (!this.tasks.isEmpty()) {
            str.append("(:tasks ");
            for (NamedTypedList p : this.tasks) {
                str.append("\n  ").append(p);
            }
            str.append("\n  )\n");
        }
        if (this.constraints != null) {
            str.append("(:constraints ").append("  ").append(this.constraints).append(")\n");
        }
        for (ParsedDerivedPredicate dp : this.derivedPredicates) {
            str.append(dp).append("\n");
        }
        for (ParsedAction op : this.actions) {
            str.append(op).append("\n");
        }
        for (ParsedMethod meth : this.methods) {
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
        for (RequireKey r : this.requirements) {
            str.append(" ").append(r);
        }
        str.append(")\n");
        if (!this.objects.isEmpty()) {
            str.append("(:objects ");
            for (TypedSymbol<String> obj : this.objects) {
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
        for (Expression<String> fact : this.initialFacts) {
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
