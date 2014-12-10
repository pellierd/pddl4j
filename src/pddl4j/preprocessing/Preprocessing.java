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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import pddl4j.parser.Connective;
import pddl4j.parser.Domain;
import pddl4j.parser.Problem;
import pddl4j.parser.RequireKey;
import pddl4j.util.BitExp;
import pddl4j.util.BitOp;
import pddl4j.util.CondBitExp;
import pddl4j.util.IntExp;

/**
 * <p>
 * This class implements the pre-processing needed to instantiate and encode planning problem in an
 * efficient manner (see On the Instantiation of ADL Operators Involving Arbitrary First-Order
 * Formulas. Koehler, J. and Hoffmann, J.).
 * <p>
 * Preprocessing starts by generating the code tables, which map strings to unique numbers, i.e., we
 * obtain one number for each predicate name, variable name, and constant name. Internally, all
 * subsequently described operations work over trees of numbers representing the formulas. Now from
 * the generated code tables, the operators, the initial state and the goal are encoded according to
 * the integer code tables. Then, proceeds over the domain and problem description and collects all
 * used relation names. For each relation it checks if it satisfies one of the following
 * definitions:
 * <p>
 * <i>Definition:</i> A relation is a positive inertia iff it does not occur positively in an
 * unconditional effect or the consequent of a conditional effect of an operator.
 * </p>
 * <p>
 * <i>Definition:</i> A relation is a negative inertia iff it does not occur negatively in an
 * unconditional effect or the consequent of a conditional effect of an operator.
 * </p>
 * <p>
 * Relations, which are positive as well as negative inertia, are simply called inertia. Relations,
 * which are neither positive nor negative inertia, are called fluents. The detection of inertia and
 * fluents is easy because in ADL, effects are restricted to conjunctions of literals. Furthermore,
 * this information can be obtained with a single pass over the domain description, which takes
 * almost no time at all.
 * </p>
 * <p>
 * Then, the preprocessing creates the predicates tables to count the number of occurrences of each
 * predicate and instantiate the operators and simplified them. After this first instantiation, the
 * operators are simplifies again with the ground inertia information. So far we have only
 * considered the predicates which are never made true or false by a planning operator. These were
 * used to constrain the instantiation process. Once the set of all actions has been determined, one
 * can similarly define the ground facts that are never made true or false by one of the actions.
 * <p>
 * <i>Definition:</i> A ground fact is a positive ground inertia iff it does not occur positively
 * in an unconditional effect or the consequent of a conditional effect of an action.
 * <p>
 * <i>Definition:</i> A ground fact is a negative ground inertia iff it does not occur negatively
 * in an unconditional effect or the consequent of a conditional effect of an action.
 * </p>
 * <p>
 * An initial fact, which is a negative ground inertia, is never made FALSE and thus always
 * satisfied in all reachable world states. It can be removed from the state description. All its
 * occurrences in the preconditions of actions and in the antecedents of conditional effects can be
 * simplified to TRUE. A fact, which is a positive ground inertia and not contained in the initial
 * state, is never satisfied in any reachable world state. All its occurrences in the preconditions
 * of actions and in the antecedents of conditional effects can be simplified to FALSE. The
 * remaining facts are fluents that, roughly speaking, can possibly change their truth value during
 * the planning process. They are therefore relevant to the representation of the planning problem.
 * </p>
 * <p>
 * Then, preprocessing extracts relevant facts from the instantiated operator. A relevant fact is
 * defines as follow:
 * </p>
 * <p>
 * <i>Definition:</i> A ground fact is relevant if and only if:
 * <ol>
 * <li> it is an initial fact and not a negative ground inertia, or if</li>
 * <li> it is not an initial fact and not a positive ground inertia.</li>
 * </ol>
 * </p>
 * <p>
 * Finally, every operator is normalized, i.e, transform precondition and effects of the operators
 * in disjunctive and conjunctive normal form, before being encoding in a compact bit set
 * representation.
 * </p>
 * <b>Warning:</b> the preprocessing is only implemented for ADL problems.
 * 
 * Revisions:
 * <ul>
 * <li>23.01.2013: add of the case when the goal can be simplified to TRUE. The coded problem 
 * returned contained in that case an empty goal expression (<code>BitExp.isEmpty()</code>). </li>
 * </ul>
 * 
 * @author D. Pellier
 * @version 1.0 - 08.06.2010
 */
public final class Preprocessing {

	/**
	 * The table of types.
	 */
	static List<String> tableOfTypes;

	/**
	 * The table of inferred domains based on unary inertia encoding.
	 */
	static List<Set<Integer>> tableOfInferredDomains;

	/**
	 * The domain of associated to the type.
	 */
	static List<Set<Integer>> tableOfDomains;

	/**
	 * The table of constants.
	 */
	static List<String> tableOfConstants;

	/**
	 * The table of predicates.
	 */
	static List<String> tableOfPredicates;

	/**
	 * The table that contains the types of the arguments of the predicates.
	 */
	static List<List<Integer>> tableOfTypedPredicates;

	/**
	 * The table of the functions.
	 */
	static List<String> tableOfFunctions;

	/**
	 * The table that contains the types of the arguments of the functions.
	 */
	static List<List<Integer>> tableOfTypedFunctions;

	/**
	 * The table that defines for each predicates its type of inertia.
	 */
	static List<Inertia> tableOfInertia;

	/**
	 * The log level of the planner.
	 */
	static int logLevel;

	/**
	 * The table that contains the ground inertia.
	 */
	static Map<IntExp, Inertia> tableOfGroundInertia;

	/**
	 * The list of predicates tables used to count the occurrence of a specified predicate in the
	 * initial state.
	 */
	static List<List<IntMatrix>> predicatesTables;

	/**
	 * The table of the relevant facts.
	 */
	static List<IntExp> tableOfRevelantFacts;

	/**
	 * The list of instantiated operator encoded into bit sets.
	 */
	static List<BitOp> operators;

	/**
	 * The goal.
	 */
	static BitExp goal;
	
	/**
	 * The encoded goal.
	 */
	static List<BitExp> codedGoal;
	

	/**
	 * The initial state.
	 */
	static BitExp init;

	/**
	 * Creates a new planner.
	 */
	private Preprocessing() {
	}

	/**
	 * Returns the log level of the planner.
	 * 
	 * @return the log level of the planner.
	 */
	public static int getLogLevel() {
		return Preprocessing.logLevel;
	}

	/**
	 * Set the log level of the planner. By default:
	 * <ul>
	 * <li> 0 - nothing </li>
	 * <li> 1 - 1 + info on problem constants, types and predicates</li>
	 * <li> 2 - 1 + 2 + loaded operators, initial and goal state</li>
	 * <li> 3 - 1 + predicates and their inertia status</li>
	 * <li> 4 - 1 + 4 + goal state and operators with unary inertia encoded</li>
	 * <li> 5 - 1 + actions, initial and goal state after expansion of variables</li>
	 * <li> 6 - 1 + facts selected as relevant to the problem</li>
	 * <li> 7 - 1 + final domain representation</li>
	 * <li> > 100 - 1 + various debugging information</li>
	 * </ul>
	 * 
	 * @param level the log level of the planner.
	 * @throws IllegalArgumentException if <code>level < 0</code>.
	 */
	public static void setLogLevel(final int level) throws IllegalArgumentException {
		if (level < 0)
			throw new IllegalArgumentException("level < 0");
		Preprocessing.logLevel = level;
	}
	
	/**
	 * Instantiate, simplify and encode the problem in a compact representation. (see On the
	 * Instantiation of ADL Operators Involving Arbitrary First-Order Formulas. Koehler, J. and
	 * Hoffmann, J.):
	 * 
	 * @param domain the domain to encode.
	 * @param problem the problem to encode.
	 * @return the problem encoded.
	 * @throws IllegalArgumentException if the problem to encode is not ADL.
	 */
	public static CodedProblem encode(final Domain domain, final Problem problem)
			throws IllegalArgumentException {

		// Check that the domain and the problem are ADL otherwise the preprocessing is not
		// implemented for the moment.
		Set<RequireKey> adl = new HashSet<RequireKey>();
		adl.add(RequireKey.STRIPS);
		adl.add(RequireKey.TYPING);
		adl.add(RequireKey.EQUALITY);
		adl.add(RequireKey.NEGATIVE_PRECONDITIONS);
		adl.add(RequireKey.DISJUNCTIVE_PRECONDITIONS);
		adl.add(RequireKey.EXISTENTIAL_PRECONDITIONS);
		adl.add(RequireKey.UNIVERSAL_PRECONDITIONS);
		adl.add(RequireKey.QUANTIFIED_PRECONDITIONS);
		adl.add(RequireKey.CONDITIONAL_EFFECTS);

		Set<RequireKey> requirements = new LinkedHashSet<RequireKey>();
		requirements.addAll(domain.getRequirements());
		requirements.addAll(problem.getRequirements());
		for (RequireKey rk : requirements) {
			if (!adl.contains(rk)) {
				throw new IllegalArgumentException("problem to encode not ADL"); 
			}
		}
		
		
		// *****************************************************************************************
		// Step 1: Standardization
		// *****************************************************************************************

		// Standardize the variables symbol contained in the domain
		domain.standardize();
		// Standardize the variables symbol contained in the domain
		problem.standardize();

		// *****************************************************************************************
		// Step 2: Integer encoding
		// *****************************************************************************************

		// Encode the types declared in the domain
		IntEncoding.encodeTypes(domain);
		// Encode the constants declared in the domain and the objects of the problem
		IntEncoding.encodeConstants(domain, problem);
		// Encode the type of the form (either t1 t2...) declared in the domain and the problem
		IntEncoding.encodeEitherTypes(domain, problem);
		// Encode the predicates defined in the domain.
		IntEncoding.encodePredicates(domain);
		// Encode the functions defined in the domain.
		IntEncoding.encodeFunctions(domain);
		// Encode operators in integer representation
		List<IntOp> intOps = IntEncoding.encodeOperators(domain.getOperators());
		// Encode the initial state in integer representation
		final Set<IntExp> intInit = IntEncoding.encodeInit(problem.getInit());
		// Encode the goal in integer representation
		final IntExp intGoal = IntEncoding.encodeGoal(problem.getGoal());
		
		// Just for logging
		if (Preprocessing.logLevel == 1 || Preprocessing.logLevel == 2) {
			Preprocessing.printTableOfConstants();
			System.out.println();
			Preprocessing.printTableOfPredicates();
			System.out.println();
			Preprocessing.printTableOfTypes();
		}

		// Just for logging
		if (Preprocessing.logLevel == 2) {
			System.out.println("\nCoded initial state:");
			System.out.print("(and");
			for (IntExp f : intInit) {
				System.out.print(" ");
				System.out.println(Preprocessing.toString(f));
			}
			System.out.println(")");
			System.out.println("\nCoded goal state:");
			System.out.print("(and");
			for (IntExp g : intGoal.getChildren()) {
				System.out.print(" ");
				System.out.println(Preprocessing.toString(g));
			}
			System.out.println(")");
			System.out.println("\nCoded operators:");
			for (IntOp op : intOps) {
				System.out.println(Preprocessing.toString(op));
				System.out.println();
			}
		}

		// *****************************************************************************************
		// Step 3: PreInstantiation
		// *****************************************************************************************

		// Computed inertia from the encode operators
		PreInstantiation.extractInertia(intOps);
		// Infer the type from the unary inertia
		PreInstantiation.inferTypesFromInertia(intInit);
		// Simply the encoded operators with the inferred types.
		intOps = PreInstantiation.simplifyOperatorsWithInferedTypes(intOps);
		// Create the predicates tables used to count the occurrences of the predicates in the
		// initial state
		PreInstantiation.createPredicatesTables(intInit);

		// Just for logging
		if (Preprocessing.logLevel == 3 || Preprocessing.logLevel == 4) {
			Preprocessing.printTableOfInertia();
		}
		// Just for logging
		if (Preprocessing.logLevel == 4) {
			System.out.print("\n");
			Preprocessing.printTableOfConstants();
			System.out.print("\n");
			Preprocessing.printTableOfTypes();
			System.out.print("\n");
			System.out.println("\nPre-instantiation initial state:");
			System.out.print("(and");
			for (IntExp f : intInit) {
				System.out.print(" ");
				System.out.println(Preprocessing.toString(f));
			}
			System.out.println(")");
			System.out.println("\nPre-instantiation goal state:");
			System.out.print("(and");
			for (IntExp g : intGoal.getChildren()) {
				System.out.print(" ");
				System.out.println(Preprocessing.toString(g));
			}
			System.out.println("\nPre-instantiation operators with infered types (" + intOps.size() +" ops):");
			for (IntOp op : intOps) {
				System.out.println(Preprocessing.toString(op));
			}
		}

		// *****************************************************************************************
		// Step 4: Instantiation
		// *****************************************************************************************

		// Instantiate the operators
		intOps = Instantiation.instantiateOperators(intOps);
		// Expand the quantified expression in the goal
		Instantiation.expandQuantifiedExpression(intGoal);
		// The tables of predicates are no more needed
		Preprocessing.predicatesTables = null;

		// Just for logging
		if (Preprocessing.logLevel == 5) {
			System.out.print("\n");
			Preprocessing.printTableOfConstants();
			System.out.print("\n");
			Preprocessing.printTableOfTypes();
			System.out.print("\n");
			System.out.println("\nPre-instantiation initial state:");
			System.out.print("(and");
			for (IntExp f : intInit) {
				System.out.print(" ");
				System.out.println(Preprocessing.toString(f));
			}
			System.out.println(")");
			System.out.println("\nPre-instantiation goal state:");
			System.out.print("(and");
			for (final IntExp g : intGoal.getChildren()) {
				System.out.print(" ");
				System.out.println(Preprocessing.toString(g));
			}
			System.out.println("\nPre-instantiation operators with infered types (" + intOps.size() +" ops):");
			for (final IntOp op : intOps) {
				System.out.println(Preprocessing.toString(op));
				
			}
		}

		// *****************************************************************************************
		// Step 5: PostInstantiation
		// *****************************************************************************************

		// Extract the ground inertia from the instantiated operators
		PostInstantiation.extractGroundInertia(intOps);
		// Simplify the operators with the ground inertia information previously extracted
		PostInstantiation.simplyOperatorsWithGroundInertia(intOps, intInit);
		// Extract the relevant facts from the simplified and instantiated operators
		PostInstantiation.extractRelevantFacts(intOps, intInit);
		// Simplify the goal with ground inertia information
		PostInstantiation.simplifyGoalWithGroundInertia(intGoal, intInit);
		// The table of ground inertia are no more needed
		Preprocessing.tableOfGroundInertia = null;

		// Just for logging
		if (Preprocessing.logLevel == 6) {
			Preprocessing.printRelevantFactsTable();
		}
		
		// *****************************************************************************************
		// Step 6: Finalization and bit set encoding of the problem
		// *****************************************************************************************

		
		// Create a map of the relevant facts with their index to speedup the bit set encoding of
		// the operators
		final Map<IntExp, Integer> map = new LinkedHashMap<IntExp, Integer>(
				Preprocessing.tableOfRevelantFacts.size());
		int index = 0;
		for (IntExp fact : Preprocessing.tableOfRevelantFacts) {
			map.put(fact, index);
			index++;
		}
		
		// Creates the list of bit operators
		Preprocessing.operators = new ArrayList<BitOp>(Constants.DEFAULT_OPERATORS_TABLE_SIZE);
		// Encode the goal in bit set representation
		if (!intGoal.getChildren().isEmpty()) { // Case where the goal was not already simplify to TRUE
			Preprocessing.goal = BitEncoding.encodeGoal(intGoal, map);
		} else {
			Preprocessing.goal = new BitExp();
		}
		
		// Encode the initial state in bit set representation
		Preprocessing.init = BitEncoding.encodeInit(intInit, map);
		// Encode the operators in bit set representation
		Preprocessing.operators.addAll(0, BitEncoding.encodeOperators(intOps, map));
		// The list of instantiated operators is no more needed.
		intOps = null;
		

		// Just for logging
		if (Preprocessing.logLevel == 7) {
			System.out.println("\nfinal operators:");
			for (BitOp op : Preprocessing.operators) {
				System.out.println(Preprocessing.toString(op));
			}

			System.out.println("\nfinal initial state:");
			System.out.println(Preprocessing.toString(Preprocessing.init));
			
			System.out.println("\nfinal goal state:");
			if (Preprocessing.goal != null && !Preprocessing.goal.isEmpty()) {
				System.out.println(Preprocessing.toString(Preprocessing.goal));
			} else if (Preprocessing.goal.isEmpty()){
				System.out.println("goal can be simplified to TRUE");
			} else {
				System.out.println("goal can be simplified to FALSE");
			}
		
		}

		final CodedProblem codedProblem = new CodedProblem();
		codedProblem.setGoal(Preprocessing.goal);
		codedProblem.setInit(Preprocessing.init);
		codedProblem.setOperators(Preprocessing.operators);
		codedProblem.setConstants(Preprocessing.tableOfConstants);
		codedProblem.setDomains(Preprocessing.tableOfDomains);
		codedProblem.setFunctions(Preprocessing.tableOfFunctions);
		codedProblem.setInertia(Preprocessing.tableOfInertia);
		codedProblem.setInferedDomains(Preprocessing.tableOfInferredDomains);
		codedProblem.setPredicates(Preprocessing.tableOfPredicates);
		codedProblem.setRevelantFacts(Preprocessing.tableOfRevelantFacts);
		codedProblem.setFunctionsSignatures(Preprocessing.tableOfTypedFunctions);
		codedProblem.setPredicatesSignatures(Preprocessing.tableOfTypedPredicates);
		codedProblem.setTypes(Preprocessing.tableOfTypes);
		return codedProblem;

	}

	// *********************************************************************************************
	// Methods for printing the different structures used during preprocessing
	// *********************************************************************************************

	/**
	 * Print the table of types.
	 */
	static void printTableOfTypes() {
		System.out.println("Types table:");
		for (int i = 0; i < Preprocessing.tableOfTypes.size(); i++) {
			System.out.print(i + ": " + Preprocessing.tableOfTypes.get(i) + ":");
			Set<Integer> domain = Preprocessing.tableOfDomains.get(i);
			for (Integer constant : domain) {
				System.out.print(" " + constant);
			}
			System.out.println();
		}
	}

	/**
	 * Print the table of constants.
	 */
	static void printTableOfConstants() {
		System.out.println("Constants table:");
		for (int i = 0; i < Preprocessing.tableOfConstants.size(); i++) {
			System.out.println(i + ": " + Preprocessing.tableOfConstants.get(i));
		}
	}

	/**
	 * Print the table of predicates.
	 */
	static void printTableOfPredicates() {
		System.out.println("Predicates table:");
		for (int i = 0; i < Preprocessing.tableOfPredicates.size(); i++) {
			String predicate = Preprocessing.tableOfPredicates.get(i);
			System.out.print(i + ": " + predicate + " :");
			for (int j = 0; j < Preprocessing.tableOfTypedPredicates.get(i).size(); j++) {
				System.out.print(" "
						+ Preprocessing.tableOfTypes.get(Preprocessing.tableOfTypedPredicates
								.get(i).get(j)));
			}
			System.out.println();
		}
	}

	/**
	 * Print the table of functions.
	 */
	static void printTableOfFunctions() {
		System.out.println("Functions table:");
		for (int i = 0; i < Preprocessing.tableOfFunctions.size(); i++) {
			String predicate = Preprocessing.tableOfFunctions.get(i);
			System.out.print(i + ": " + predicate + ":");
			for (int j = 0; j < Preprocessing.tableOfTypedFunctions.get(i).size(); j++) {
				System.out.print(" "
						+ Preprocessing.tableOfTypes.get(Preprocessing.tableOfTypedFunctions.get(i)
								.get(j)));
			}
			System.out.println();
		}
	}

	/**
	 * Print the table of inertia.
	 */
	static void printTableOfInertia() {
		System.out.println("Inertias table:");
		for (int i = 0; i < Preprocessing.tableOfPredicates.size(); i++) {
			String predicate = Preprocessing.tableOfPredicates.get(i);
			System.out.println(i + ": " + predicate + " : " + Preprocessing.tableOfInertia.get(i));
		}
	}

	/**
	 * Print the relevant facts table.
	 */
	static void printRelevantFactsTable() {
		System.out.println("selected the following facts as relevant:");
		for (int i = 0; i < Preprocessing.tableOfRevelantFacts.size(); i++) {
			System.out.println(i + ": "
					+ Preprocessing.toString(Preprocessing.tableOfRevelantFacts.get(i)));
		}
	}

	/**
	 * Print the goal.
	 */
	static void printGoal() {
		System.out.println("Goal state is:");
		for (BitExp exp : Preprocessing.codedGoal) {
			System.out.println(Preprocessing.toString(exp));
		}
	}
	
	/**
	 * Returns a string representation of the specified operator.
	 * 
	 * @param op the operator to print.
	 * @return a string representation of the specified operator.
	 */
	static String toString(final IntOp op) {
		return StringEncoder.toString(op, Preprocessing.tableOfConstants,
				Preprocessing.tableOfTypes, Preprocessing.tableOfPredicates,
				Preprocessing.tableOfFunctions);
	}
	
	/**
	 * Returns a short string representation of the specified operator, i.e., only its name and the
	 * value of its parameters.
	 * 
	 * @param op the operator.
	 * @return a string representation of the specified operator.
	 */
	static final String toShortString(final IntOp op) {
		return StringEncoder.toShortString(op, Preprocessing.tableOfConstants);
	}
	
	/**
	 * Returns a string representation of the specified operator.
	 * 
	 * @param op the operator to print.
	 * @return a string representation of the specified operator.
	 */
	static String toString(final BitOp op) {
		return StringEncoder.toString(op, Preprocessing.tableOfConstants,
				Preprocessing.tableOfTypes, Preprocessing.tableOfPredicates,
				Preprocessing.tableOfFunctions, Preprocessing.tableOfRevelantFacts);
	}

	/**
	 * Returns a string representation of an expression.
	 * 
	 * @param exp the expression.
	 * @return a string representation of the specified expression.
	 */
	static String toString(final IntExp exp) {
		return StringEncoder.toString(exp, Preprocessing.tableOfConstants,
				Preprocessing.tableOfTypes, Preprocessing.tableOfPredicates,
				Preprocessing.tableOfFunctions);
	}

	/**
	 * Returns a string representation of a bit expression.
	 * 
	 * @param exp the expression.
	 * @return a string representation of the specified expression.
	 */
	static String toString(BitExp exp) {
		return StringEncoder.toString(exp, Preprocessing.tableOfConstants,
				Preprocessing.tableOfTypes, Preprocessing.tableOfPredicates,
				Preprocessing.tableOfFunctions, Preprocessing.tableOfRevelantFacts);
	}

	/**
	 * Returns a string representation of a conditional bit expression.
	 * 
	 * @param exp the conditional expression.
	 * @return a string representation of the specified expression.
	 */
	static String toString(CondBitExp exp) {
			return StringEncoder.toString(exp, Preprocessing.tableOfConstants,
					Preprocessing.tableOfTypes, Preprocessing.tableOfPredicates,
					Preprocessing.tableOfFunctions, Preprocessing.tableOfRevelantFacts);
	}
		
	/**
	 * Print the table of inertia.
	 */
	static void printTableOfGroundInertia() {
		System.out.println("Ground inertia table:");
		for (Entry<IntExp, Inertia> e : Preprocessing.tableOfGroundInertia.entrySet()) {
			System.out.println(Preprocessing.toString(e.getKey()) + ": " + e.getValue());
		}
	}

}
