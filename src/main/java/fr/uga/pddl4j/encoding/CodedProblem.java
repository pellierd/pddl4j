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

package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.operators.Action;
import fr.uga.pddl4j.operators.State;
import fr.uga.pddl4j.operators.ConditionalEffect;
import fr.uga.pddl4j.operators.Method;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.util.ClosedWorldState;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class implements a problem where actions are instantiated and encoded in
 * <code>BitSet</code> representation.
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
public class CodedProblem implements Serializable {

    /**
     * The table of types.
     */
    private List<String> types;

    /**
     * The table of inferred domains based on unary inertia encoding.
     */
    private List<Set<Integer>> inferredDomains;

    /**
     * The domain of associated to the type.
     */
    private List<Set<Integer>> domains;

    /**
     * The table of constants.
     */
    private List<String> constants;

    /**
     * The table of predicates.
     */
    private List<String> predicates;

    /**
     * The table that contains the types of the arguments of the predicates.
     */
    private List<List<Integer>> predicatesSignatures;

    /**
     * The table of the functions.
     */
    private List<String> functions;

    /**
     * The table of tasks.
     */
    private List<String> tasks;

    /**
     * The table that contains the types of the arguments of the tasks.
     */
    private List<List<Integer>> tasksSignatures;


    /**
     * The table that contains the types of the arguments of the functions.
     */
    private List<List<Integer>> functionsSignatures;

    /**
     * The table that defines for each predicates its type of inertia.
     */
    private List<Inertia> inertia;

    /**
     * The table of the relevant facts.
     */
    private List<IntExpression> relevantFacts;

    /**
     * The table of the relevant tasks.
     */
    private List<IntExpression> relevantTasks;

    /**
     * The list of instantiated actions encoded into bit sets.
     */
    private List<Action> actions;

    /**
     * The list of instantiated methods encoded into bit sets.
     */
    private List<Method> methods;

    /**
     * The goal.
     */
    private State goal;

    /**
     * The initial state.
     */
    private State init;

    /**
     * The default constructor with a private package access to prevent instance creation.
     */
    CodedProblem() {
    }

    /**
     * Create a new <code>CodedProblem</code> copy of another.
     *
     * @param other the other <code>CodedProblem</code>;
     */
    public CodedProblem(CodedProblem other) {
        super();
        this.types = new ArrayList<>();
        this.types.addAll(other.types.stream().collect(Collectors.toList()));
        this.domains = new ArrayList<>();
        for (Set<Integer> si : other.domains) {
            final Set<Integer> copy = si.stream().collect(Collectors.toCollection(LinkedHashSet::new));
            this.domains.add(copy);
        }
        this.constants = new ArrayList<>();
        this.constants.addAll(other.constants.stream().collect(Collectors.toList()));
        this.predicates = new ArrayList<>();
        this.predicates.addAll(other.predicates.stream().collect(Collectors.toList()));
        this.predicatesSignatures = new ArrayList<>();
        for (List<Integer> si : other.predicatesSignatures) {
            final List<Integer> copy = si.stream().collect(Collectors.toList());
            this.predicatesSignatures.add(copy);
        }
        this.tasks = new ArrayList<>();
        this.tasks.addAll(other.tasks.stream().collect(Collectors.toList()));
        this.tasksSignatures = new ArrayList<>();
        for (List<Integer> si : other.tasksSignatures) {
            final List<Integer> copy = si.stream().collect(Collectors.toList());
            this.tasksSignatures.add(copy);
        }
        this.functions = new ArrayList<>();
        this.functions.addAll(other.functions.stream().collect(Collectors.toList()));
        this.functionsSignatures = new ArrayList<>();
        for (List<Integer> si : other.functionsSignatures) {
            final List<Integer> copy = si.stream().collect(Collectors.toList());
            this.functionsSignatures.add(copy);
        }
        this.inertia = new ArrayList<>();
        this.inertia.addAll(other.inertia.stream().collect(Collectors.toList()));
        this.relevantFacts = new ArrayList<>();
        this.relevantFacts.addAll(other.relevantFacts.stream().map(IntExpression::new).collect(Collectors.toList()));
        this.relevantTasks = new ArrayList<>();
        this.relevantTasks.addAll(other.relevantTasks.stream().map(IntExpression::new).collect(Collectors.toList()));
        this.actions = new ArrayList<>();
        this.actions.addAll(other.actions.stream().map(Action::new).collect(Collectors.toList()));
        this.methods = new ArrayList<>();
        this.methods.addAll(other.methods.stream().map(Method::new).collect(Collectors.toList()));
        this.goal = new State(other.goal);
        this.init = new State(other.init);
    }

    /**
     * Returns the types table of the problem.
     *
     * @return the types table of the problem.
     */
    public final List<String> getTypes() {
        return this.types;
    }

    /**
     * Sets the table of type of the problem.
     *
     * @param types the table of type to set
     */
    final void setTypes(final List<String> types) {
        this.types = types;
    }

    /**
     * Returns the type inferred. Types are inferred when the key work either is used.
     *
     * @return the inferredDomains
     */
    final List<Set<Integer>> getInferredDomains() {
        return this.inferredDomains;
    }

    /**
     * Sets the inferred domain of the problem.
     *
     * @param inferredDomains the inferredDomains to set.
     */
    final void setInferredDomains(final List<Set<Integer>> inferredDomains) {
        this.inferredDomains = inferredDomains;
    }

    /**
     * Returns the table of domains for each type of the problem.
     *
     * @return the table of domains for each type of the problem.
     */
    public final List<Set<Integer>> getDomains() {
        return this.domains;
    }

    /**
     * Set the domains corresponding at each types of the problem.
     *
     * @param domains the domains to set.
     */
    final void setDomains(final List<Set<Integer>> domains) {
        this.domains = domains;
    }

    /**
     * Returns the constants of the problem.
     *
     * @return the constants of the problem.
     */
    public final List<String> getConstants() {
        return this.constants;
    }

    /**
     * Sets the constants of the problem.
     *
     * @param constants the constants to set
     */
    final void setConstants(final List<String> constants) {
        this.constants = constants;
    }

    /**
     * Returns the predicates of the problem.
     *
     * @return the predicates of the problem.
     */
    public final List<String> getPredicates() {
        return this.predicates;
    }

    /**
     * Sets the predicates of the problem.
     *
     * @param predicates the predicates to set.
     */
    final void setPredicates(final List<String> predicates) {
        this.predicates = predicates;
    }

    /**
     * Returns the signatures of the predicates defined in the problem.
     *
     * @return the signatures of the predicates defined in the problem.
     */
    public final List<List<Integer>> getPredicatesSignatures() {
        return this.predicatesSignatures;
    }

    /**
     * Sets the signatures of the predicates defined in the problem.
     *
     * @param signatures the signatures of the predicates defined in the problem.
     */
    final void setPredicatesSignatures(final List<List<Integer>> signatures) {
        this.predicatesSignatures = signatures;
    }

    /**
     * Sets the tasks of the problem.
     *
     * @param tasks the tasks to set.
     */
    final void setTasks(final List<String> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the tasks of the problem.
     *
     * @return the tasks of the problem.
     */
    public final List<String> getTasks() {
        return this.tasks;
    }

    /**
     * Returns the signatures of the tasks defined in the problem.
     *
     * @return the signatures of the tasks defined in the problem.
     */
    public final List<List<Integer>> getTasksSignatures() {
        return this.tasksSignatures;
    }

    /**
     * Sets the signatures of the tasks defined in the problem.
     *
     * @param signatures the signatures of the tasks defined in the problem.
     */
    final void setTasksSignatures(final List<List<Integer>> signatures) {
        this.tasksSignatures = signatures;
    }

    /**
     * Returns the functions of the problem.
     *
     * @return the functions of the problem.
     */
    final List<String> getFunctions() {
        return this.functions;
    }

    /**
     * Sets the functions of the problem.
     *
     * @param functions the functions to set.
     */
    final void setFunctions(final List<String> functions) {
        this.functions = functions;
    }

    /**
     * Returns the signatures of the functions defined in the problem.
     *
     * @return the signatures of the functions defined in the problem.
     */
    public final List<List<Integer>> getFunctionsSignatures() {
        return this.functionsSignatures;
    }

    /**
     * Sets the signatures of the function defined in the problem.
     *
     * @param signatures the signatures of the function defined in the problem.
     */
    final void setFunctionsSignatures(final List<List<Integer>> signatures) {
        this.functionsSignatures = signatures;
    }

    /**
     * Returns the inertia status of the predicates defined in the problem.
     *
     * @return the inertia status of the predicates defined in the problem.
     */
    public final List<Inertia> getInertia() {
        return this.inertia;
    }

    /**
     * Sets the inertia status of the predicates defined in the problem.
     *
     * @param inertia the inertia to set.
     */
    final void setInertia(final List<Inertia> inertia) {
        this.inertia = inertia;
    }

    /**
     * Returns the list of relevant facts used the problem.
     *
     * @return the list of relevant facts used the problem.
     */
    public final List<IntExpression> getRelevantFacts() {
        return this.relevantFacts;
    }

    /**
     * Sets the list of relevant facts used the problem.
     *
     * @param facts the list of relevant facts to set.
     */
    final void setRelevantFacts(final List<IntExpression> facts) {
        this.relevantFacts = facts;
    }

    /**
     * Returns the list of relevant tasks used the problem.
     *
     * @return the list of relevant tasks used the problem.
     */
    public final List<IntExpression> getRelevantTasks() {
        return this.relevantTasks;
    }

    /**
     * Sets the list of relevant tasks used the problem.
     *
     * @param tasks the list of relevant tasks to set.
     */
    final void setRelevantTasks(final List<IntExpression> tasks) {
        this.relevantTasks = tasks;
    }

    /**
     * Returns the list of instantiated actions of the problem.
     *
     * @return the list of instantiated actions of the problem.
     */
    public final List<Action> getActions() {
        return this.actions;
    }

    /**
     * Sets the list of instantiated actions of the problem.
     *
     * @param actions the list of instantiated actions of the problem.
     */
    final void setActions(final List<Action> actions) {
        this.actions = actions;
    }

    /**
     * Returns the list of instantiated methods of the problem.
     *
     * @return the list of instantiated methods of the problem.
     */
    public final List<Method> getMethods() {
        return this.methods;
    }

    /**
     * Sets the list of instantiated methods of the problem.
     *
     * @param methods the list of instantiated methods of the problem.
     */
    final void setMethods(final List<Method> methods) {
        this.methods = methods;
    }

    /**
     * Returns the goal of the problem or null if the goal can is not reachable.
     *
     * @return the goal of the problem.
     */
    public final State getGoal() {
        return this.goal;
    }

    /**
     * Returns <code>true</code> if this problem is solvable, i.e.,
     * if its goal was not simplified to FALSE during the encoding.
     *
     * @return <code>true</code> if this problem is solvable; <code>false</code>.
     */
    public final boolean isSolvable() {
        return this.goal != null;
    }

    /**
     * Sets the goal of the problem.
     *
     * @param goal the goal to set
     */
    final void setGoal(final State goal) {
        this.goal = goal;
    }

    /**
     * Returns the initial state of the problem.
     *
     * @return the initial state of the problem.
     */
    public final State getInit() {
        return this.init;
    }

    /**
     * Sets the initial state of the problem.
     *
     * @param init the initial state to set.
     */
    final void setInit(final State init) {
        this.init = init;
    }

    /**
     * Returns a short string representation of the specified operator, i.e., only its name and the
     * value of its parameters.
     *
     * @param op the operator.
     * @return a string representation of the specified operator.
     */
    public final String toShortString(final Action op) {
        return StringEncoder.toShortString(op, this.constants);
    }

    /**
     * Returns a string representation of the specified operator.
     *
     * @param op the operator.
     * @return a string representation of the specified operator.
     */
    public final String toString(final Action op) {
        return StringEncoder.toString(op, this.constants, this.types,
            this.predicates, this.functions, this.tasks, this.relevantFacts);
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    public final String toString(final IntExpression exp) {
        return StringEncoder.toString(exp, this.constants, this.types,
            this.predicates, this.functions, this.tasks);
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp the expression.
     * @param sep the string separator used between the predicate symbol and the arguments.
     * @return a string representation of the specified expression.
     */
    public final String toString(final IntExpression exp, final String sep) {
        return StringEncoder.toString(exp, this.constants, this.types,
            this.predicates, this.functions, this.tasks, sep);
    }

    /**
     * Returns a string representation of a bit expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    public final String toString(State exp) {
        return StringEncoder.toString(exp, this.constants, this.types,
            this.predicates, this.functions, this.tasks, this.relevantFacts);
    }

    /**
     * Returns a string representation of a bit state.
     *
     * @param bitState the state.
     * @return a string representation of the specified state.
     */
    public final String toString(ClosedWorldState bitState) {
        return StringEncoder.toString(bitState, this.constants, this.types,
            this.predicates, this.functions, this.tasks, this.relevantFacts);
    }

    /**
     * Returns a string representation of a conditional bit expression.
     *
     * @param exp the conditional expression.
     * @return a string representation of the specified expression.
     */
    public final String toString(ConditionalEffect exp) {
        return StringEncoder.toString(exp, this.constants, this.types,
            this.predicates, this.functions, this.tasks, this.relevantFacts);
    }

    /**
     * Return a string representation of a search.
     *
     * @param plan the search.
     * @return a string representation of the specified search.
     */
    public final String toString(final Plan plan) {
        int max = Integer.MIN_VALUE;
        for (Integer t : plan.timeSpecifiers()) {
            for (Action a : plan.getActionSet(t)) {
                int length = this.toShortString(a).length();
                if (max < length) {
                    max = length;
                }
            }
        }
        final int actionSize = max;
        final int timeSpecifierSize = (int) Math.log10(plan.timeSpecifiers().size()) + 1;

        final StringBuilder str = new StringBuilder();
        plan.timeSpecifiers().forEach(time ->
            plan.getActionSet(time).forEach(a ->
                str.append(String.format("%0" + timeSpecifierSize + "d: (%" + actionSize + "s) [%d]%n",
                    time, this.toShortString(a), ((int) a.getDuration())))));
        return str.toString();
    }

    /**
     * Return a detailed string representation of a search. Not compatible with VAL.
     *
     * @param plan the search.
     * @return a string representation of the specified search.
     */
    public final String toStringCost(final Plan plan) {
        int max = Integer.MIN_VALUE;
        for (Integer t : plan.timeSpecifiers()) {
            for (Action a : plan.getActionSet(t)) {
                int length = this.toShortString(a).length();
                if (max < length) {
                    max = length;
                }
            }
        }
        final int actionSize = max;
        final int timeSpecifierSize = (int) Math.log10(plan.timeSpecifiers().size()) + 1;

        final StringBuilder str = new StringBuilder();
        plan.timeSpecifiers().forEach(time ->
            plan.getActionSet(time).forEach(a ->
                str.append(String.format("%0" + timeSpecifierSize + "d: (%" + actionSize + "s) [%4.2f]%n",
                    time, this.toShortString(a), ((float) a.getCost())))));
        return str.toString();
    }
}
