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

package pddl4j.preprocessing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import java.util.Set;

import pddl4j.util.BitExp;
import pddl4j.util.BitOp;
import pddl4j.util.CondBitExp;
import pddl4j.util.IntExp;

/**
 * This class implements a problem where operators are instantiated and encoded in
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
	private List<Set<Integer>> inferedDomains;

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
	private List<IntExp> revelantFacts;
	
	/**
	 * The list of instantiated operator encoded into bit sets.
	 */
	private List<BitOp> operators;
	
	/**
	 * The goal.
	 */
	private BitExp goal;

	/**
	 * The initial state.
	 */
	private BitExp init;
	
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
		this.types = new ArrayList<String>();
		for (String str : other.types) {
			this.types.add(new String(str));
		}
		this.domains = new ArrayList<Set<Integer>>();
		for (Set<Integer> si : other.domains) {
			final Set<Integer> copy = new LinkedHashSet<Integer>();
			for (Integer i : si) {
				copy.add(i);
			}
			this.domains.add(copy);
		}
		this.constants = new ArrayList<String>();
		for (String str : other.constants) {
			this.constants.add(new String(str));
		}
		this.predicates = new ArrayList<String>();
		for (String str : other.predicates) {
			this.predicates.add(new String(str));
		}
		this.predicatesSignatures = new ArrayList<List<Integer>>();
		for (List<Integer> si : other.predicatesSignatures) {
			final List<Integer> copy = new ArrayList<Integer>();
			for (Integer i : si) {
				copy.add(i);
			}
			this.predicatesSignatures.add(copy);
		}
		this.functions = new ArrayList<String>();
		for (String str : other.functions) {
			this.functions.add(new String(str));
		}
		this.functionsSignatures = new ArrayList<List<Integer>>();
		for (List<Integer> si : other.functionsSignatures) {
			final List<Integer> copy = new ArrayList<Integer>();
			for (Integer i : si) {
				copy.add(i);
			}
			this.functionsSignatures.add(copy);
		}
		this.inertia = new ArrayList<Inertia>();
		for (Inertia i : other.inertia) {
			this.inertia.add(i);
		}
		this.revelantFacts = new ArrayList<IntExp>();
		for (IntExp exp : other.revelantFacts) {
			this.revelantFacts.add(new IntExp(exp));
		}
		this.operators = new ArrayList<BitOp>();
		for (BitOp exp : other.operators) {
			this.operators.add(new BitOp(exp));
		}
		this.goal = new BitExp(other.goal);
		this.init = new BitExp(other.init);	
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
	 * TO REMOVE
	 * 
	 * @return the inferedDomains
	 */
	final List<Set<Integer>> getInferedDomains() {
		return this.inferedDomains;
	}

	/**
	 * @param inferedDomains the inferedDomains to set
	 */
	final void setInferedDomains(final List<Set<Integer>> inferedDomains) {
		this.inferedDomains = inferedDomains;
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
	public final List<IntExp> getRevelantFacts() {
		return this.revelantFacts;
	}

	/**
	 * Sets the list of relevant facts used the problem.
	 * 
	 * @param relavants the list of relevant facts to set.
	 */
	final void setRevelantFacts(final List<IntExp> relavants) {
		this.revelantFacts = relavants;
	}

	/**
	 * Returns the list of instantiated operators of the problem.
	 * 
	 * @return the list of instantiated operators of the problem.
	 */
	public final List<BitOp> getOperators() {
		return operators;
	}

	/**
	 * Sets the list of instantiated operators of the problem.
	 * 
	 * @param operators the list of instantiated operators of the problem.
	 */
	final void setOperators(final List<BitOp> operators) {
		this.operators = operators;
	}

	/**
	 * Returns the goal of the problem or null if the goal can is not reachable.
	 * 
	 * @return the goal of the problem.
	 */
	public final BitExp getGoal() {
		return this.goal;
	}
	
	/**
	 * Returns <code>true</code> if this problem is solvable, i.e., if its goal was not simplified to FALSE during the preprocessing.
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
	final void setGoal(final BitExp goal) {
		this.goal = goal;
	}

	/**
	 * Returns the initial state of the problem.
	 * 
	 * @return the initial state of the problem.
	 */
	public final BitExp getInit() {
		return this.init;
	}

	/**
	 * Sets the initial state of the problem.
	 * 
	 * @param init the initial state to set.
	 */
	final void setInit(final BitExp init) {
		this.init = init;
	}
	
	/**
	 * Returns a short string representation of the specified operator, i.e., only its name and the
	 * value of its parameters.
	 * 
	 * @param op the operator.
	 * @return a string representation of the specified operator.
	 */
	public final String toShortString(final BitOp op) {
		return StringEncoder.toShortString(op, this.constants);
	}
	
	/**
	 * Returns a string representation of the specified operator.
	 * 
	 * @param op the operator.
	 * @return a string representation of the specified operator.
	 */
	public final String toString(final BitOp op) {
		return StringEncoder.toString(op, this.constants, this.types,
				this.predicates, this.functions, this.revelantFacts);
	}

	/**
	 * Returns a string representation of an expression.
	 * 
	 * @param exp the expression.
	 * @return a string representation of the specified expression.
	 */
	public final String toString(final IntExp exp) {
		return StringEncoder.toString(exp, this.constants, this.types,
				this.predicates, this.functions);
	}

	/**
	 * Returns a string representation of an expression.
	 * 
	 * @param exp the expression.
	 * @param sep the string separator used between the predicate symbol and the arguments.
	 * @return a string representation of the specified expression.
	 */
	public final String toString(final IntExp exp, final String sep) {
		return StringEncoder.toString(exp, this.constants, this.types,
				this.predicates, this.functions, sep);
	}
	
	/**
	 * Returns a string representation of a bit expression.
	 * 
	 * @param exp the expression.
	 * @return a string representation of the specified expression.
	 */
	public final String toString(BitExp exp) {
		return StringEncoder.toString(exp, this.constants, this.types,
				this.predicates, this.functions, this.revelantFacts);
	}

	/**
	 * Returns a string representation of a conditional bit expression.
	 * 
	 * @param exp the conditional expression.
	 * @return a string representation of the specified expression.
	 */
	public final String toString(CondBitExp exp) {
			return StringEncoder.toString(exp, this.constants, this.types,
					this.predicates, this.functions, this.revelantFacts);
	}
}
