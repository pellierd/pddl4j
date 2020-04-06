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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This class implements a planning domain read by the parser.
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public class PDDLDomain implements Serializable {

    /**
     * The name of the domain.
     */
    private PDDLSymbol name;

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
    private List<PDDLAction> ops;

    /**
     * The list of methods of the domain.
     */
    private List<PDDLMethod> meths;

    /**
     * The list of derived predicates of the domain.
     */
    private List<PDDLDerivedPredicate> derivedPredicates;

    /**
     * Creates a new domain.
     */
    private PDDLDomain() {
    }

    /**
     * Creates a new domain with a specific name.
     *
     * @param name the name of the domain.
     */
    public PDDLDomain(final PDDLSymbol name) {
        this();
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.requirements = new LinkedHashSet<>();
        this.types = new ArrayList<>();
        this.types.add(new PDDLTypedSymbol(PDDLParser.OBJECT));
        this.constants = new ArrayList<>();
        this.predicates = new ArrayList<>();
        this.functions = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.constraints = null;
        this.ops = new ArrayList<>();
        this.meths = new ArrayList<>();
        this.derivedPredicates = new ArrayList<>();
    }

    /**
     * Returns the name of the domain.
     *
     * @return the name of the domain.
     */
    public final PDDLSymbol getName() {
        return this.name;
    }

    /**
     * Sets a name to the domain.
     *
     * @param name the name to set.
     */
    public final void setName(final PDDLSymbol name) {
        this.name = name;
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
     * Returns the list of parsed ops.
     *
     * @return the list of parsed ops.
     */
    public final List<PDDLAction> getActions() {
        return this.ops;
    }

    /**
     * Adds an action to the domain.
     *
     * @param action the action to add.
     * @return <code>true</code> if the action was added; <code>false</code> otherwise.
     */
    public final boolean addAction(final PDDLAction action) {
        this.tasks.add(action.toTask());
        return this.ops.add(action);
    }

    /**
     * Returns the list of parsed methods.
     *
     * @return the list of parsed methods.
     */
    public final List<PDDLMethod> getMethods() {
        return this.meths;
    }

    /**
     * Adds a method to the domain.
     *
     * @param method the method to add.
     * @return <code>true</code> if the method was added; <code>false</code> otherwise.
     */
    public final boolean addMethod(final PDDLMethod method) {
        return this.meths.add(method);
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
     * Return if this domain is equal to another specified object.
     *
     * @param object the other object.
     * @return <code>true</code> if the specified object is a non <code>null</code> instance of
     *          the class <code>PlDomain</code> and has the same name; <code>false</code> otherwise.
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof PDDLDomain) {
            PDDLDomain other = (PDDLDomain) object;
            return this.name.equals(other.name);
        }
        return false;
    }

    /**
     * Returns the hash code value of this domain.
     *
     * @return the hash code value of this domain.
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
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
                t.getTypes().stream().filter(s -> !s.equals(PDDLParser.OBJECT)).forEach(s -> stack.push(this.getType(s)));
            }
        }
        return isSubType;
    }

    /**
     * Normalize the domain. This method rename the variables used in the domain and normalize its
     * ops and derived predicates.
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
        // Rename all the variable from the ops
        for (int i = 0; i < this.getActions().size(); i++) {
            this.getActions().get(i).normalize();
        }
        // Rename all the variable from the methods
        for (int i = 0; i < this.getMethods().size(); i++) {
            this.getMethods().get(i).normalize();
        }
    }

    /**
     * Returns a string representation of this domain.
     *
     * @return a string representation of this domain.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("(define (domain ").append(this.name).append(")").append("\n(:requirements");
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
        for (PDDLAction op : this.ops) {
            str.append(op).append("\n");
        }
        for (PDDLMethod meth : this.meths) {
            str.append(meth).append("\n");
        }
        str.append(")");
        return str.toString();
    }
}
