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

import fr.uga.pddl4j.exceptions.FatalException;
import fr.uga.pddl4j.exceptions.UnexpectedExpressionException;
import fr.uga.pddl4j.parser.Connective;
import fr.uga.pddl4j.parser.Domain;
import fr.uga.pddl4j.parser.Problem;
import fr.uga.pddl4j.parser.RequireKey;
import fr.uga.pddl4j.util.BitExp;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.CondBitExp;
import fr.uga.pddl4j.util.IntExp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <p>
 * This class implements the pre-processing needed to instantiate and encode planning problem in an
 * efficient manner (see On the Instantiation of ADL Operators Involving Arbitrary First-Order
 * Formulas. Koehler, J. and Hoffmann, J.).
 * </p>
 * <p>
 * Encoder starts by generating the code tables, which map strings to unique numbers, i.e., we
 * obtain one number for each predicate name, variable name, and constant name. Internally, all
 * subsequently described operations work over trees of numbers representing the formulas. Now from
 * the generated code tables, the operators, the initial state and the goal are encoded according to
 * the integer code tables. Then, proceeds over the domain and problem description and collects all
 * used relation names. For each relation it checks if it satisfies one of the following
 * definitions:
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
 * Then, the encoding creates the predicates tables to count the number of occurrences of each
 * predicate and instantiate the operators and simplified them. After this first instantiation, the
 * operators are simplifies again with the ground inertia information. So far we have only
 * considered the predicates which are never made true or false by a planning operator. These were
 * used to constrain the instantiation process. Once the set of all actions has been determined, one
 * can similarly define the ground facts that are never made true or false by one of the actions.
 * </p>
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
 * Then, encoding extracts relevant facts from the instantiated operator. A relevant fact is
 * defines as follow:
 * </p>
 * <p>
 * <i>Definition:</i> A ground fact is relevant if and only if:
 * </p>
 * <ol>
 * <li> it is an initial fact and not a negative ground inertia, or if</li>
 * <li> it is not an initial fact and not a positive ground inertia.</li>
 * </ol>
 * <p>
 * Finally, every operator is normalized, i.e, transform precondition and effects of the operators
 * in disjunctive and conjunctive normal form, before being encoding in a compact bit set
 * representation.
 * </p>
 * <b>Warning:</b> the encoding is only implemented for ADL problems.
 * <p>
 * Revisions:
 * </p>
 * <ul>
 * <li>23.01.2013: add of the case when the goal can be simplified to TRUE. The coded problem
 * returned contained in that case an empty goal expression (<code>BitExp.isEmpty()</code>).</li>
 * <li>25.03.2016: Fix bug when the goal contains only one atom.</li>
 * </ul>
 *
 * @author D. Pellier
 * @version 1.0 - 08.06.2010
 */
public final class Encoder implements Serializable {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(Encoder.class);

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
    static List<IntExp> tableOfRelevantFacts;

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
    private Encoder() {
    }

    /**
     * Returns the log level of the planner.
     *
     * @return the log level of the planner.
     */
    public static int getLogLevel() {
        return Encoder.logLevel;
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
     * <li> 8 - 1 + various debugging information</li>
     * </ul>
     *
     * @param level the log level of the planner.
     * @throws IllegalArgumentException if <code>level &#60; 0</code>.
     */
    public static void setLogLevel(final int level) {
        if (level < 0) {
            throw new IllegalArgumentException("level < 0");
        }
        Encoder.logLevel = level;
    }

    /**
     * Instantiate, simplify and encode the problem in a compact representation. (see On the
     * Instantiation of ADL Operators Involving Arbitrary First-Order Formulas. Koehler, J. and
     * Hoffmann, J.):
     *
     * @param domain  the domain to encode.
     * @param problem the problem to encode.
     * @return the problem encoded.
     * @throws IllegalArgumentException if the problem to encode is not ADL and ACTION_COSTS.
     */
    public static CodedProblem encode(final Domain domain, final Problem problem) throws FatalException {

        // Check that the domain and the problem are ADL otherwise the encoding is not
        // implemented for the moment.
        Set<RequireKey> adl = new HashSet<>();
        adl.add(RequireKey.ADL);
        adl.add(RequireKey.STRIPS);
        adl.add(RequireKey.TYPING);
        adl.add(RequireKey.EQUALITY);
        adl.add(RequireKey.NEGATIVE_PRECONDITIONS);
        adl.add(RequireKey.DISJUNCTIVE_PRECONDITIONS);
        adl.add(RequireKey.EXISTENTIAL_PRECONDITIONS);
        adl.add(RequireKey.UNIVERSAL_PRECONDITIONS);
        adl.add(RequireKey.QUANTIFIED_PRECONDITIONS);
        adl.add(RequireKey.CONDITIONAL_EFFECTS);
        adl.add(RequireKey.ACTION_COSTS);

        Set<RequireKey> requirements = new LinkedHashSet<>();
        requirements.addAll(domain.getRequirements());
        requirements.addAll(problem.getRequirements());
        for (RequireKey rk : requirements) {
            if (!adl.contains(rk)) {
                throw new IllegalArgumentException("problem to encode not ADL and ACTION_COSTS");
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
        // Create Map containing functions and associed cost from encoded initial state
        final Map<IntExp, Double> intInitFunctionCost = IntEncoding.encodeFunctionCostInit(intInit);
        // Create Set containing integer representation of initial state without functions and associed cost
        final Set<IntExp> intInitPredicates = IntEncoding.removeFunctionCost(intInit);

        // Encode the goal in integer representation
        final IntExp intGoal = IntEncoding.encodeGoal(problem.getGoal());

        final StringBuilder stringBuilder = new StringBuilder();

        // Just for logging
        if (Encoder.logLevel == 1 || Encoder.logLevel == 2) {
            Encoder.printTableOfConstants(stringBuilder);
            stringBuilder.append(System.lineSeparator());
            Encoder.printTableOfPredicates(stringBuilder);
            stringBuilder.append(System.lineSeparator());
            Encoder.printTableOfTypes(stringBuilder);
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        // Just for logging
        if (Encoder.logLevel == 2) {
            stringBuilder.append("\nCoded initial state:\n").append("(and");
            for (IntExp f : intInitPredicates) {
                stringBuilder.append(" ").append(Encoder.toString(f));
            }
            stringBuilder.append(")").append("\n\nCoded goal state:\n").append(Encoder.toString(intGoal));
            stringBuilder.append(")").append("\n\nCoded operators:\n\n");
            for (IntOp op : intOps) {
                stringBuilder.append(Encoder.toString(op)).append(System.lineSeparator());
            }
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        // *****************************************************************************************
        // Step 3: PreInstantiation
        // *****************************************************************************************

        // Computed inertia from the encode operators
        PreInstantiation.extractInertia(intOps);
        // Infer the type from the unary inertia
        PreInstantiation.inferTypesFromInertia(intInitPredicates);
        // Simply the encoded operators with the inferred types.
        intOps = PreInstantiation.simplifyOperatorsWithInferedTypes(intOps);
        // Create the predicates tables used to count the occurrences of the predicates in the
        // initial state
        PreInstantiation.createPredicatesTables(intInitPredicates);

        // Just for logging
        if (Encoder.logLevel == 3 || Encoder.logLevel == 4) {
            Encoder.printTableOfInertia(stringBuilder);
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }
        // Just for logging
        if (Encoder.logLevel == 4) {
            stringBuilder.append(System.lineSeparator());
            Encoder.printTableOfConstants(stringBuilder);
            stringBuilder.append(System.lineSeparator());
            Encoder.printTableOfTypes(stringBuilder);
            stringBuilder.append(System.lineSeparator()).append("\nPre-instantiation initial state:\n").append("(and");
            for (IntExp f : intInitPredicates) {
                stringBuilder.append(" ").append(Encoder.toString(f));
            }
            stringBuilder.append(")").append("\n\nPre-instantiation goal state:\n").append(Encoder.toString(intGoal));
            stringBuilder.append("\n\nPre-instantiation operators with infered types (").append(intOps.size())
                .append(" ops):\n");
            for (IntOp op : intOps) {
                stringBuilder.append(Encoder.toString(op));
            }
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        // *****************************************************************************************
        // Step 4: Instantiation
        // *****************************************************************************************

        // Instantiate the operators
        intOps = Instantiation.instantiateOperators(intOps);
        // Expand the quantified expression in the goal
        Instantiation.expandQuantifiedExpression(intGoal);
        // The tables of predicates are no more needed
        Encoder.predicatesTables = null;

        // Just for logging
        if (Encoder.logLevel == 5) {
            stringBuilder.append(System.lineSeparator());
            Encoder.printTableOfConstants(stringBuilder);
            stringBuilder.append(System.lineSeparator());
            Encoder.printTableOfTypes(stringBuilder);
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("\nPre-instantiation initial state:\n").append("(and");
            for (IntExp f : intInitPredicates) {
                stringBuilder.append(" ").append(Encoder.toString(f));
            }
            stringBuilder.append(")").append("\n\nPre-instantiation goal state:\n").append("(and");
            for (final IntExp g : intGoal.getChildren()) {
                stringBuilder.append(" ").append(Encoder.toString(g));
            }
            stringBuilder.append("\n\nPre-instantiation operators with inferred types (").append(intOps.size())
                .append(" ops):\n\n");
            for (final IntOp op : intOps) {
                stringBuilder.append(Encoder.toString(op)).append("\n");
            }
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        // *****************************************************************************************
        // Step 5: PostInstantiation
        // *****************************************************************************************

        // Extract the ground inertia from the instantiated operators
        PostInstantiation.extractGroundInertia(intOps);
        // Simplify the operators with the ground inertia information previously extracted
        PostInstantiation.simplyOperatorsWithGroundInertia(intOps, intInitPredicates);
        // Extract the relevant facts from the simplified and instantiated operators
        PostInstantiation.extractRelevantFacts(intOps, intInitPredicates);
        // Simplify the goal with ground inertia information
        PostInstantiation.simplifyGoalWithGroundInertia(intGoal, intInitPredicates);
        // Extract increase and add value to BitOp cost
        PostInstantiation.simplifyIncrease(intOps, intInitFunctionCost);

        // The table of ground inertia are no more needed
        Encoder.tableOfGroundInertia = null;

        // Just for logging
        if (Encoder.logLevel == 6) {
            Encoder.printRelevantFactsTable(stringBuilder);
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        // *****************************************************************************************
        // Step 6: Finalization and bit set encoding of the problem
        // *****************************************************************************************


        // Create a map of the relevant facts with their index to speedup the bit set encoding of
        // the operators
        final Map<IntExp, Integer> map = new LinkedHashMap<>(Encoder.tableOfRelevantFacts.size());
        int index = 0;
        for (IntExp fact : Encoder.tableOfRelevantFacts) {
            map.put(fact, index);
            index++;
        }

        // Creates the list of bit operators
        Encoder.operators = new ArrayList<>(Constants.DEFAULT_OPERATORS_TABLE_SIZE);
        // Encode the goal in bit set representation
        if (!intGoal.getChildren().isEmpty() || intGoal.getConnective().equals(Connective.ATOM)) {
            try {
                Encoder.goal = BitEncoding.encodeGoal(intGoal, map);
            } catch (UnexpectedExpressionException uee) {
                LOGGER.error("Error with unexpected expression", uee);
                return null;
            }
        } else {
            Encoder.goal = new BitExp();
        }

        // Encode the initial state in bit set representation
        Encoder.init = BitEncoding.encodeInit(intInitPredicates, map);
        // Encode the operators in bit set representation
        try {
            Encoder.operators.addAll(0, BitEncoding.encodeOperators(intOps, map));
        } catch (UnexpectedExpressionException uee) {
            LOGGER.error("Error with unexpected expression", uee);
            return null;
        }

        // Just for logging
        if (Encoder.logLevel == 7) {
            stringBuilder.append("\nfinal operators:");
            for (BitOp op : Encoder.operators) {
                stringBuilder.append(Encoder.toString(op));
            }

            stringBuilder.append("\nfinal initial state:").append(Encoder.toString(Encoder.init))
                .append("\nfinal goal state:");
            if (Encoder.goal == null) { // Goal null
                stringBuilder.append("goal can be simplified to FALSE");
            } else if (!Encoder.goal.isEmpty()) { // Goal not Null and not empty
                stringBuilder.append(Encoder.toString(Encoder.goal));
            } else { // Goal not Null and empty
                stringBuilder.append("goal can be simplified to TRUE");
            }
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        final CodedProblem codedProblem = new CodedProblem();
        codedProblem.setGoal(Encoder.goal);
        codedProblem.setInit(Encoder.init);
        codedProblem.setOperators(Encoder.operators);
        codedProblem.setConstants(Encoder.tableOfConstants);
        codedProblem.setDomains(Encoder.tableOfDomains);
        codedProblem.setFunctions(Encoder.tableOfFunctions);
        codedProblem.setInertia(Encoder.tableOfInertia);
        codedProblem.setInferredDomains(Encoder.tableOfInferredDomains);
        codedProblem.setPredicates(Encoder.tableOfPredicates);
        codedProblem.setRelevantFacts(Encoder.tableOfRelevantFacts);
        codedProblem.setFunctionsSignatures(Encoder.tableOfTypedFunctions);
        codedProblem.setPredicatesSignatures(Encoder.tableOfTypedPredicates);
        codedProblem.setTypes(Encoder.tableOfTypes);
        return codedProblem;

    }

    // *********************************************************************************************
    // Methods for printing the different structures used during encoding
    // *********************************************************************************************

    /**
     * Print the table of types.
     */
    static void printTableOfTypes(StringBuilder stringBuilder) {
        stringBuilder.append("Types table:\n");
        for (int i = 0; i < Encoder.tableOfTypes.size(); i++) {
            stringBuilder.append(i).append(": ").append(Encoder.tableOfTypes.get(i)).append(":");
            Set<Integer> domain = Encoder.tableOfDomains.get(i);
            for (Integer constant : domain) {
                stringBuilder.append(" ").append(constant);
            }
            stringBuilder.append("\n");
        }
    }

    /**
     * Print the table of constants.
     */
    static void printTableOfConstants(StringBuilder stringBuilder) {
        stringBuilder.append("Constants table:\n");
        for (int i = 0; i < Encoder.tableOfConstants.size(); i++) {
            stringBuilder.append(i).append(": ").append(Encoder.tableOfConstants.get(i)).append("\n");
        }
    }

    /**
     * Print the table of predicates.
     */
    static void printTableOfPredicates(StringBuilder stringBuilder) {
        stringBuilder.append("Predicates table:\n");
        for (int i = 0; i < Encoder.tableOfPredicates.size(); i++) {
            String predicate = Encoder.tableOfPredicates.get(i);
            stringBuilder.append(i).append(": ").append(predicate).append(" :");
            for (int j = 0; j < Encoder.tableOfTypedPredicates.get(i).size(); j++) {
                stringBuilder.append(" ")
                    .append(Encoder.tableOfTypes.get(Encoder.tableOfTypedPredicates.get(i).get(j)));
            }
            stringBuilder.append("\n");
        }
    }

    /**
     * Print the table of functions.
     */
    static void printTableOfFunctions(StringBuilder stringBuilder) {
        stringBuilder.append("Functions table:\n");
        for (int i = 0; i < Encoder.tableOfFunctions.size(); i++) {
            String predicate = Encoder.tableOfFunctions.get(i);
            stringBuilder.append(i).append(": ").append(predicate).append(":");
            for (int j = 0; j < Encoder.tableOfTypedFunctions.get(i).size(); j++) {
                stringBuilder.append(" ").append(Encoder.tableOfTypes.get(Encoder.tableOfTypedFunctions.get(i).get(j)));
            }
            stringBuilder.append("\n");
        }
    }

    /**
     * Print the table of inertia.
     */
    static void printTableOfInertia(StringBuilder stringBuilder) {
        stringBuilder.append("Inertias table:\n");
        for (int i = 0; i < Encoder.tableOfPredicates.size(); i++) {
            String predicate = Encoder.tableOfPredicates.get(i);
            stringBuilder.append(i).append(": ").append(predicate).append(" : ").append(Encoder.tableOfInertia.get(i));
            stringBuilder.append("\n");
        }
    }

    /**
     * Print the relevant facts table.
     */
    static void printRelevantFactsTable(StringBuilder stringBuilder) {
        stringBuilder.append("selected the following facts as relevant:\n");
        for (int i = 0; i < Encoder.tableOfRelevantFacts.size(); i++) {
            stringBuilder.append(i).append(": ").append(Encoder.toString(Encoder.tableOfRelevantFacts.get(i)));
            stringBuilder.append("\n");
        }
    }

    /**
     * Print the goal.
     */
    static void printGoal(StringBuilder stringBuilder) {
        stringBuilder.append("Goal state is:\n");
        for (BitExp exp : Encoder.codedGoal) {
            stringBuilder.append(Encoder.toString(exp));
            stringBuilder.append("\n");
        }
    }

    /**
     * Returns a short string representation of the specified operator, i.e., only its name and the
     * value of its parameters.
     *
     * @param op the operator.
     * @return a string representation of the specified operator.
     */
    static String toShortString(final IntOp op) {
        return StringEncoder.toShortString(op, Encoder.tableOfConstants);
    }

    /**
     * Returns a string representation of the specified operator.
     *
     * @param op the operator to print.
     * @return a string representation of the specified operator.
     */
    static String toString(final IntOp op) {
        return StringEncoder.toString(op, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions);
    }

    /**
     * Returns a string representation of the specified operator.
     *
     * @param op the operator to print.
     * @return a string representation of the specified operator.
     */
    static String toString(final BitOp op) {
        return StringEncoder.toString(op, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfRelevantFacts);
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    static String toString(final IntExp exp) {
        return StringEncoder.toString(exp, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions);
    }

    /**
     * Returns a string representation of a bit expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    static String toString(BitExp exp) {
        return StringEncoder.toString(exp, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfRelevantFacts);
    }

    /**
     * Returns a string representation of a conditional bit expression.
     *
     * @param exp the conditional expression.
     * @return a string representation of the specified expression.
     */
    static String toString(CondBitExp exp) {
        return StringEncoder.toString(exp, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfRelevantFacts);
    }

    /**
     * Print the table of inertia.
     */
    static void printTableOfGroundInertia(StringBuilder stringBuilder) {
        stringBuilder.append("Ground inertia table:");
        for (Entry<IntExp, Inertia> e : Encoder.tableOfGroundInertia.entrySet()) {
            stringBuilder.append(Encoder.toString(e.getKey())).append(": ").append(e.getValue());
        }
    }

}
