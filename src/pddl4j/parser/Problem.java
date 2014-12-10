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

package pddl4j.parser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * This class implements a planning problem read by the parser.
 * 
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public class Problem implements Serializable {

	/**
	 * The name of the problem.
	 */
	private Symbol name;
	
	/**
	 * The name of the domain.
	 */
	private Symbol domain;
	
	/**
	 * The set of requirements.
	 */
    private Set<RequireKey> requirements;
    
	/**
	 * The list of objects declared in the problem.
	 */
	private List<TypedSymbol> objects;

	/**
	 * The list of initial facts declared in the problem.
	 */
	private List<Exp> initialFacts;
	
	/**
	 * The goal of the problem.
	 */
	private Exp goal;
	
	/**
	 * The constraints declared in the problem.
	 */
	private Exp constraints;
	
	/**
	 * The metric constraints of the problem
	 */
	private Exp metric;
		
	/**
	 * Creates a new problem.
	 */
	private Problem() {
	}
	
	/**
	 * Creates a new problem with a specific name.
	 * 
	 * @param name the name of the problem.
	 * @throws NullPointerException if the specified name is null.
	 */
	public Problem(final Symbol name) throws NullPointerException {
		this();
		if (name == null)
			throw new NullPointerException();
		this.name = name;
		this.requirements = new LinkedHashSet<RequireKey>();
		this.objects = new ArrayList<TypedSymbol>();
		this.initialFacts = new ArrayList<Exp>();
		this.goal = null;
		this.constraints = null;
		this.metric = null;
	}
	
	 /**
	 * Return the name of the problem.
	 * 
	 * @return the name of the problem.
	 */
	 public final Symbol getName() {
	 	return this.name;
	 }
	 
	 /**
	  * Sets the name of the problem.
	  * 
	  * @param name the name to set.
	  * @throws NullPointerException if the specified name is null. 
	  */
	 public final void setName(final Symbol name) throws NullPointerException {
		 if (name == null) throw new NullPointerException();
		 this.name = name;
	 }
	 
	 /**
	  * Returns the name of the domain declared in the problem.
	  * 
	  * @return the name of the domain declared in the problem.
	  */
	 public final Symbol getDomain() { 
		 return this.domain; 
	}
	 
	 /**
	  * Sets the domain of the problem.
	  * 
	  * @param domain the domain to set.
	  * @throws NullPointerException if the specified domain is null. 
	  */
	 public final void setDomain(final Symbol domain) throws NullPointerException {
		 if (domain == null) throw new NullPointerException();
		 this.domain = domain;
	 }
	 
	 /**
	  * Returns the set of requirements.
	  * 
	  * @return the set of requirements.
	  */
	 public Set<RequireKey> getRequirements() {
	 	return this.requirements;
	 }
	
	 /**
	  * Adds a requirement to the problem.
	  * 
	  * @param requirement the requirement to add.
	  * @return <code>true</code> if the requirement was added; <code>false</code> otherwise.
	  * @throws NullPointerException if the specified requirement is null.
	  */
	 public final boolean addRequirement(final RequireKey requirement) throws NullPointerException {
		 if (requirement == null) throw new NullPointerException();
		 return this.requirements.add(requirement);
	 }
	 
	/**
	 * Returns the list of objects declared in the problem file.
	 *
	 * @return the list of objects declared in the problem file.
	 */
	public List<TypedSymbol> getObjects() {
	 	return this.objects;
	}
	 
	/**
	  * Adds an object to the problem.
	  * 
	  * @param object the object to add.
	  * @return <code>true</code> if the object was added; <code>false</code> otherwise.
	  * @throws NullPointerException if the specified object is null.
	  */
	 public final boolean addObject(final TypedSymbol object) throws NullPointerException {
		 if (object == null) throw new NullPointerException();
		 return this.objects.add(object);
	 }
	/**
	 * Returns the list of initial facts defined in the problem file.
	 *
	 * @return the list of initial facts defined in the problem file.
	 */
	public List<Exp> getInit() {
		return this.initialFacts;
	}
	
	/**
	  * Adds an initial fact to the problem.
	  * 
	  * @param fact the fact to add.
	  * @return <code>true</code> if the fact was added; <code>false</code> otherwise.
	  * @throws NullPointerException if the specified fact is null.
	  */
	 public final boolean addInitialFact(final Exp fact) throws NullPointerException {
		 if (fact == null) throw new NullPointerException();
		 return this.initialFacts.add(fact);
	 }
	
	/**
	 * Returns the list of goal defined in the problem file.
	 *
	 * @return the list of goal defined in the problem file.
	 */
	public Exp getGoal() {
		return this.goal;
	}
	
	/**
	  * Sets the goal of the problem.
	  * 
	  * @param goal the goal to set.
	  * @throws NullPointerException if the specified goal is null. 
	  */
	 public final void setGoal(final Exp goal) throws NullPointerException {
		 if (goal == null) throw new NullPointerException();
		 this.goal = goal;
	 }
	 
	/**
	 * Returns the problem constraints loaded or <code>null</code> if the problem has no constraints.
	 * 
	 * @return the problem constraints loaded or <code>null</code> if the problem has no constraints. 
	 */
	public Exp getConstraints() {
		return this.constraints;
	}
	
	/**
	  * Sets the constraints of the problem.
	  * 
	  * @param constraints the constraints to set.
	  */
	 public final void setConstraints(final Exp constraints) {
		 this.constraints = constraints;
	 }
	 
	/**
	 * Returns the metric of the problem or <code>null</code> if the problem has no metric specification.
	 * 
	 * @return the metric of the problem or <code>null</code> if the problem has no metric specification.
	 */
	public Exp getMetric() {
		return this.metric;
	}
	
	/**
	  * Sets the metric of the problem.
	  * 
	  * @param metric the metric to set.
	  */
	 public final void setMetric(final Exp metric) {
		 this.metric = metric;
	 }
	 
	/**
	 * Returns the object from a specified symbol.
	 * 
	 * @param symbol The symbol.
	 * @return the object from a specified symbol or <code>null</code> if no object with this symbol
	 *         was declared.
	 */
	public final TypedSymbol getObject(final Symbol symbol) {
		final int index = this.objects.indexOf(symbol);
		return (index == -1) ? null : this.objects.get(index);
	}
	
	/**
	 * Normalize the problem. This method renames the variables and then move inward the negation of
	 * the goal and the constraints of the problem.
	 * 
	 * @see pddl4j.parser.Op#normalize()
	 * @see pddl4j.parser.DerivedPredicate#normalize()
	 */
	public void standardize() {
		// Rename the constraints of the problem
		if (this.getConstraints() != null) {
			this.getConstraints().renameVariables();
			this.getConstraints().moveNegationInward();
		}
		// Rename the goal of the problem
		this.getGoal().renameVariables();
		this.getGoal().moveNegationInward();
	}
	
	/**
	 * Returns a string representation of this problem.
	 * 
	 * @return a string representation of this problem.
	 */
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("(define (problem ");
		str.append(this.name);
		str.append(")");
		str.append("\n(:domain ");
		str.append(this.domain);
		str.append(")");
		str.append("\n(:requirements");
		for (RequireKey r : this.requirements) {
			str.append(" " + r);
		}
		str.append(")\n");
		if (!this.objects.isEmpty()) {
			str.append("(:objets ");
			for (TypedSymbol obj : this.objects) {
				str.append("\n  " + obj);
			}
			str.append("\n)\n");
		}
		str.append("(:init");
		for (Exp fact : this.initialFacts) {
			str.append("\n  "+ fact);
		}
		str.append("\n)\n");
		str.append("(:goal ");
		str.append("  " + this.goal);
		str.append(")\n");
		if (this.constraints != null) {
			str.append("(:constraints ");
			str.append("  " + this.constraints);
			str.append(")\n");
		}
		if (this.metric != null) {
			str.append("(:metric ");
			str.append("  " + this.metric);
			str.append(")\n");
		}
		str.append(")");
		return str.toString();
	}
}
