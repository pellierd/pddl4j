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
 * This interface defined the methods of a planning domain read by the parser.
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public interface ParsedDomain extends Serializable {

    /**
     * Returns the name of the domain.
     *
     * @return the name of the domain.
     */
    Symbol<String> getDomainName();

    /**
     * Sets a name to the domain.
     *
     * @param name the name to set.
     */
    void setDomainName(final Symbol<String> name);

    /**
     * Returns the set of requirements.
     *
     * @return the set of requirements.
     */
    Set<RequireKey> getRequirements();

    /**
     * Adds a requirements to the domain.
     *
     * @param requirement the requirement to add.
     * @return <code>true</code> if the requirement was added; <code>false</code> otherwise.
     */
    boolean addRequirement(final RequireKey requirement);

    /**
     * Returns the parsed types in the domain file.
     *
     * @return the parsed types in the domain file.
     */
    List<TypedSymbol<String>> getTypes();

    /**
     * Adds a type to the domain.
     *
     * @param type the type to add.
     * @return <code>true</code> if the type was added; <code>false</code> otherwise.
     */
    boolean addType(final TypedSymbol<String> type);

    /**
     * Returns the parsed constants in the domain file.
     *
     * @return the parsed constants in the domain file.
     */
    List<TypedSymbol<String>> getConstants();

    /**
     * Adds a constant to the domain.
     *
     * @param constant the constant to add.
     * @return <code>true</code> if the constant was added; <code>false</code> otherwise.
     */
    boolean addConstant(final TypedSymbol<String> constant);

    /**
     * Returns the parsed predicates in the domain file.
     *
     * @return the parsed predicates in the domain file.
     */
    List<NamedTypedList> getPredicates();

    /**
     * Adds a predicate to the domain.
     *
     * @param predicate the predicate to add.
     * @return <code>true</code> if the predicate was added; <code>false</code> otherwise.
     * @throws NullPointerException if the specified predicate is null.
     */
    boolean addPredicate(final NamedTypedList predicate);

    /**
     * Returns the parsed functions in the domain file.
     *
     * @return the parsed functions in the domain file.
     */
    List<NamedTypedList> getFunctions();

    /**
     * Adds a function to the domain.
     *
     * @param function the function to add.
     * @return <code>true</code> if the function was added; <code>false</code> otherwise.
     */
    boolean addFunction(final NamedTypedList function);

    /**
     * Returns the parsed tasks un the domain file.
     *
     * @return the parsed tasks in the domain file.
     */
    List<NamedTypedList> getTasks();

    /**
     * Adds a task to the domain.
     *
     * @param task the task to add.
     * @return <code>true</code> if the task was added; <code>false</code> otherwise.
     */
    boolean addTask(final NamedTypedList task);

    /**
     * Returns the constraints loaded in the domain file.
     *
     * @return the constraints loaded in the domain file or null if the domain has no constraints.
     */
    Expression<String> getConstraints();

    /**
     * Sets the constraints to the domain.
     *
     * @param constraints the constraint of the domain.
     */
    void setConstraints(final Expression<String> constraints);

    /**
     * Returns the list of parsed ops.
     *
     * @return the list of parsed ops.
     */
    List<ParsedAction> getActions();

    /**
     * Adds an action to the domain.
     *
     * @param action the action to add.
     * @return <code>true</code> if the action was added; <code>false</code> otherwise.
     */
    boolean addAction(final ParsedAction action);

    /**
     * Returns the list of parsed methods.
     *
     * @return the list of parsed methods.
     */
    List<ParsedMethod> getMethods();

    /**
     * Adds a method to the domain.
     *
     * @param method the method to add.
     * @return <code>true</code> if the method was added; <code>false</code> otherwise.
     */
    boolean addMethod(final ParsedMethod method);

    /**
     * Returns the list of parsed derived predicates.
     *
     * @return the list of parsed derived predicates.
     */
    List<ParsedDerivedPredicate> getDerivesPredicates();

    /**
     * Adds a derived predicate to the domain.
     *
     * @param predicate the derived predicate to add.
     * @return <code>true</code> if the derived predicate was added; <code>false</code> otherwise.
     * @throws NullPointerException if the specified predicate is null.
     */
    boolean addDerivedPredicate(final ParsedDerivedPredicate predicate);

    /**
     * Returns if a specified type symbol was declared.
     *
     * @param type the type symbol.
     * @return <code>true</code> if the specified symbol is a declared type; <code>false</code> otherwise.
     */
    boolean isDeclaredType(final Symbol<String> type);

    /**
     * Returns the type from a specified symbol.
     *
     * @param symbol The symbol.
     * @return the type from a specified symbol or <code>null</code> if no type with this symbol was declared.
     */
    public TypedSymbol<String> getType(Symbol<String> symbol);

    /**
     * Returns if a specified constant symbol was declared.
     *
     * @param constant the constant symbol.
     * @return <code>true</code> if the specified symbol is a declared constant; <code>false</code> otherwise.
     */
    boolean isDeclaredConstant(final Symbol<String> constant);

    /**
     * Returns the constant from a specified symbol.
     *
     * @param symbol The symbol.
     * @return the constant from a specified symbol or <code>null</code> if no constant with this
     *          symbol was declared.
     */
    TypedSymbol<String> getConstant(Symbol<String> symbol);

    /**
     * Returns if the types of two typed symbol matched, i.e., if the types of the first typed
     * symbol can be viewed as a subtype of the second.
     *
     * @param s1 the first typed symbol.
     * @param s2 the second typed symbol.
     * @return <code>true</code> if the types of the first typed symbol can be viewed as a subtype
     *          of the seconds. <code>false</code> otherwise.
     */
    boolean isSubType(TypedSymbol<String> s1, TypedSymbol<String> s2);

    /**
     * Normalize the domain. This method rename the variables used in the domain and normalize its
     * ops and derived predicates.
     **/
    void normalize();

    /**
     * Returns a string representation of this domain.
     *
     * @return a string representation of this domain.
     */
    @Override
    String toString();
}
