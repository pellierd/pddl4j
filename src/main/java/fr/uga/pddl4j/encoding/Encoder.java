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

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.ConditionalEffect;
import fr.uga.pddl4j.problem.Method;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.TaskNetwork;
import fr.uga.pddl4j.problem.State;
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
 * efficient manner (see On the Instantiation of ADL action and methods involving arbitrary first-order
 * formulas. Koehler, J. and Hoffmann, J.).
 * </p>
 * <p>
 * Encoder starts by generating the code tables, which map strings to unique numbers, i.e., we
 * obtain one number for each predicate name, variable name, and constant name. Internally, all
 * subsequently described operations work over trees of numbers representing the formulas. Now from
 * the generated code tables, the actions, the methids the initial state and the goal are encoded
 * according to the integer code tables. Then, proceeds over the domain and problem description and
 * collects all used relation names. For each relation it checks if it satisfies one of the following
 * definitions:
 * </p>
 * <p>
 * <i>Definition:</i> A relation is a negative inertia iff it does not occur negatively in an
 * unconditional effect or the consequent of a conditional effect of an action.
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
 * predicate and instantiate the actions and simplified them. After this first instantiation, the
 * actions are simplifies again with the ground inertia information. So far we have only
 * considered the predicates which are never made true or false by a planning action. These were
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
 * Then, encoding extracts relevant facts from the instantiated actions. A relevant fact is
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
 * Finally, every action is normalized, i.e, transform precondition and effects of the actions
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
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(Encoder.class);

    /**
     * The set of requirements
     */
    static Set<PDDLRequireKey> requirements;

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
     * The table of tasks.
     */
    static List<String> tableOfTasks;

    /**
     * The table that contains the types of the arguments of the tasks.
     */
    static List<List<Integer>> tableOfTypedTasks;

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
    static Map<IntExpression, Inertia> tableOfGroundInertia;

    /**
     * The list of predicates tables used to count the occurrence of a specified predicate in the
     * initial state.
     */
    static List<List<IntMatrix>> predicatesTables;

    /**
     * The table of the relevant facts.
     */
    static List<IntExpression> tableOfRelevantFacts;

    /**
     * The table of the relevant task.
     */
    static List<IntExpression> tableOfRelevantTasks;

    /**
     * The list of instantiated actions encoded into bit sets.
     */
    static List<Action> actions;

    /**
     * The list of instantiated methods encoded into bit sets.
     */
    static List<Method> methods;

    /**
     * The goal.
     */
    static State goal;

    /**
     * The initial task network.
     */
    static TaskNetwork initialTaskNetwork;

    /**
     * The encoded goal.
     */
    static List<State> codedGoal;


    /**
     * The initial state.
     */
    static State init;

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
     * <li> 2 - 1 + 2 + loaded actions, initial and goal state</li>
     * <li> 3 - 1 + predicates and their inertia status</li>
     * <li> 4 - 1 + 4 + goal state and actions with unary inertia encoded</li>
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
     * Instantiation of ADL action and methid involving arbitrary first-order formulas.
     *
     * @param domain  the domain to encode.
     * @param problem the problem to encode.
     * @return the problem encoded.
     * @throws IllegalArgumentException if the problem to encode is not ADL or ACTION_COSTS or HTN.
     */
    public static Problem encode(final PDDLDomain domain, final PDDLProblem problem) {

        // Check that the domain and the problem are ADL otherwise the encoding is not
        // implemented for the moment.
        Set<PDDLRequireKey> accepted = new HashSet<>();
        accepted.add(PDDLRequireKey.ADL);
        accepted.add(PDDLRequireKey.STRIPS);
        accepted.add(PDDLRequireKey.TYPING);
        accepted.add(PDDLRequireKey.EQUALITY);
        accepted.add(PDDLRequireKey.NEGATIVE_PRECONDITIONS);
        accepted.add(PDDLRequireKey.DISJUNCTIVE_PRECONDITIONS);
        accepted.add(PDDLRequireKey.EXISTENTIAL_PRECONDITIONS);
        accepted.add(PDDLRequireKey.UNIVERSAL_PRECONDITIONS);
        accepted.add(PDDLRequireKey.QUANTIFIED_PRECONDITIONS);
        accepted.add(PDDLRequireKey.CONDITIONAL_EFFECTS);
        accepted.add(PDDLRequireKey.ACTION_COSTS);
        accepted.add(PDDLRequireKey.TOTAL_ORDERED_HTN);
        accepted.add(PDDLRequireKey.PARTIAL_ORDERED_HTN);
        accepted.add(PDDLRequireKey.HTN_METHOD_PRECONDITIONS);

        Encoder.requirements = new LinkedHashSet<>();
        Encoder.requirements.addAll(domain.getRequirements());
        Encoder.requirements.addAll(problem.getRequirements());

        if (!accepted.containsAll(Encoder.requirements)) {
            throw new IllegalArgumentException("only ADL, ACTION_COSTS or HTN problem can be encoded");
        }

        if (Encoder.requirements.contains(PDDLRequireKey.PARTIAL_ORDERED_HTN)
            || Encoder.requirements.contains(PDDLRequireKey.TOTAL_ORDERED_HTN)) {
            Encoder.requirements.add(PDDLRequireKey.HTN);
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
        // Encode the tasks defined in the domain.
        IntEncoding.encodeTasks(domain);
        // Encode actions in integer representation
        List<IntAction> intActions = IntEncoding.encodeActions(domain.getActions());
        // Encode method in integer representation
        List<IntMethod> intMethods = IntEncoding.encodeMethods(domain.getMethods());

        // Encode the initial state in integer representation
        final Set<IntExpression> intInit = IntEncoding.encodeInit(problem.getInit());
        // Create Map containing functions and associed cost from encoded initial state
        final Map<IntExpression, Double> intInitFunctionCost = IntEncoding.encodeFunctionCostInit(intInit);
        // Create Set containing integer representation of initial state without functions and associed cost
        final Set<IntExpression> intInitPredicates = IntEncoding.removeFunctionCost(intInit);

        // Encode the goal in integer representation or the initial task network
        IntExpression intGoal =  null;
        IntTaskNetwork intTaskNetwork = null;
        if (!Encoder.requirements.contains(PDDLRequireKey.HTN)) {
            intGoal = IntEncoding.encodeGoal(problem.getGoal());
        } else {
            intTaskNetwork = IntEncoding.encodeInitialTaskNetwork(problem.getInitialTaskNetwork());
        }

        final StringBuilder stringBuilder = new StringBuilder();

        // Just for logging
        if (Encoder.logLevel == 1 || Encoder.logLevel == 2) {
            Encoder.printTableOfConstants(stringBuilder);
            stringBuilder.append(System.lineSeparator());
            Encoder.printTableOfPredicates(stringBuilder);
            stringBuilder.append(System.lineSeparator());
            if (!Encoder.tableOfFunctions.isEmpty()) {
                Encoder.printTableOfFunctions(stringBuilder);
                stringBuilder.append(System.lineSeparator());
            }
            if (!Encoder.tableOfTasks.isEmpty() && Encoder.requirements.contains(PDDLRequireKey.HTN)) {
                Encoder.printTableOfTasks(stringBuilder);
                stringBuilder.append(System.lineSeparator());
            }
            Encoder.printTableOfTypes(stringBuilder);
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        // Just for logging
        if (Encoder.logLevel == 2) {
            stringBuilder.append("\nCoded initial state:\n").append("(and");
            for (IntExpression f : intInitPredicates) {
                stringBuilder.append(" ").append(Encoder.toString(f)).append("\n");
            }
            if (intGoal != null) {
                stringBuilder.append(")").append("\n\nCoded goal state:\n").append(Encoder.toString(intGoal));
            }
            if (intTaskNetwork != null) {
                stringBuilder.append(")").append("\n\nCoded initial task network:\n")
                    .append(Encoder.toString(intTaskNetwork));
            }
            if (!intActions.isEmpty()) {
                stringBuilder.append(")").append("\n\nCoded actions:\n\n");
                for (IntAction op : intActions) {
                    stringBuilder.append(Encoder.toString(op)).append(System.lineSeparator());
                }
            }
            if (!intMethods.isEmpty()) {
                stringBuilder.append(")").append("\n\nCoded methods:\n\n");
                for (IntMethod meth : intMethods) {
                    stringBuilder.append(Encoder.toString(meth)).append(System.lineSeparator());
                }
            }
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        // *****************************************************************************************
        // Step 3: PreInstantiation
        // *****************************************************************************************

        // Computed inertia from the encode actions
        PreInstantiation.extractInertia(intActions);
        // Infer the type from the unary inertia
        PreInstantiation.inferTypesFromInertia(intInitPredicates);
        // Simply the encoded action with the inferred types.
        intActions = PreInstantiation.simplifyActionsWithInferredTypes(intActions);
        // Simply the encoded methods with the inferred types.
        intMethods = PreInstantiation.simplifyMethodsWithInferredTypes(intMethods);

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
            for (IntExpression f : intInitPredicates) {
                stringBuilder.append(" ").append(Encoder.toString(f)).append("\n");
            }
            if (intGoal != null) {
                stringBuilder.append(")").append("\n\nPre-instantiation goal state:\n").append(Encoder.toString(intGoal));
            }
            if (intTaskNetwork != null) {
                stringBuilder.append(")").append("\n\nPre-instantiation initial task network:\n")
                    .append(Encoder.toString(intTaskNetwork));
            }
            stringBuilder.append("\nPre-instantiation actions with inferred types (").append(intActions.size())
                .append(" actions):\n");
            for (IntAction a : intActions) {
                stringBuilder.append(Encoder.toString(a)).append("\n");
            }
            if (Encoder.requirements.contains(PDDLRequireKey.HTN)) {
                stringBuilder.append("\nPre-instantiation methods with inferred types (").append(intMethods.size())
                    .append(" methods):\n\n");
                for (IntMethod meth : intMethods) {
                    stringBuilder.append(Encoder.toString(meth)).append("\n");
                }
            }
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        // *****************************************************************************************
        // Step 4: Instantiation
        // *****************************************************************************************

        // Instantiate the actions
        intActions = Instantiation.instantiateActions(intActions);
        // Instantiate the methods
        intMethods = Instantiation.instantiateMethods(intMethods);
        // Expand the quantified expression in the goal
        if (intGoal != null) {
            Instantiation.expandQuantifiedExpression(intGoal);
        }
        // The tables of predicates are no more needed
        Encoder.predicatesTables = null;

        // Just for logging
        if (Encoder.logLevel == 5) {
            stringBuilder.append(System.lineSeparator());
            Encoder.printTableOfConstants(stringBuilder);
            stringBuilder.append(System.lineSeparator());
            Encoder.printTableOfTypes(stringBuilder);
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("\nInstantiation initial state:\n").append("(and");
            for (IntExpression f : intInitPredicates) {
                stringBuilder.append(" ").append(Encoder.toString(f)).append("\n");
            }
            if (intGoal != null) {
                stringBuilder.append(")").append("\n\nInstantiation goal state:\n").append("(and");
                for (final IntExpression g : intGoal.getChildren()) {
                    stringBuilder.append(" ").append(Encoder.toString(g));
                }
            }
            if (intTaskNetwork != null) {
                stringBuilder.append(")").append("\n\nInstantiation initial task network:\n")
                    .append(Encoder.toString(intTaskNetwork));
            }
            stringBuilder.append("\n\nInstantiation actions with inferred types (").append(intActions.size())
                .append(" actions):\n\n");
            for (final IntAction op : intActions) {
                stringBuilder.append(Encoder.toString(op)).append("\n");
            }
            if (Encoder.requirements.contains(PDDLRequireKey.HTN)) {
                stringBuilder.append("\nInstantiation methods with inferred types (").append(intMethods.size())
                    .append(" methods):\n\n");
                for (IntMethod meth : intMethods) {
                    stringBuilder.append(Encoder.toString(meth)).append("\n");
                }
            }
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }


        // *****************************************************************************************
        // Step 5: PostInstantiation
        // *****************************************************************************************

        // Extract the ground inertia from the instantiated actions
        PostInstantiation.extractGroundInertia(intActions);
        // Simplify the actions with the ground inertia information previously extracted
        PostInstantiation.simplyActionsWithGroundInertia(intActions, intInitPredicates);
        // Simplify the methods with the ground inertia information previously extracted
        PostInstantiation.simplyMethodsWithGroundInertia(intMethods, intInitPredicates);
        // Extract the relevant facts from the simplified and instantiated actions and methods
        PostInstantiation.extractRelevantFacts(intActions, intMethods, intInitPredicates);
        // Extract the relevant task for the simplified instantiated methods
        PostInstantiation.extractRelevantTasks(intMethods);

        // Simplify the goal with ground inertia information
        if (intGoal != null) {
            PostInstantiation.simplifyGoalWithGroundInertia(intGoal, intInitPredicates);
        }
        // Extract increase and add value to BitOp cost
        PostInstantiation.simplifyIncrease(intActions, intInitFunctionCost);

        // The table of ground inertia are no more needed
        Encoder.tableOfGroundInertia = null;

        // Just for logging
        if (Encoder.logLevel == 6) {
            Encoder.printRelevantFactsTable(stringBuilder);
            if (!Encoder.tableOfRelevantTasks.isEmpty()) {
                stringBuilder.append("\n");
                Encoder.printRelevantTasksTable(stringBuilder);
            }
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        // *****************************************************************************************
        // Step 6: Finalization and bit set encoding of the problem
        // *****************************************************************************************

        // Create a map of the relevant facts with their index to speedup the bit set encoding of the actions
        final Map<IntExpression, Integer> factIndexMap = new LinkedHashMap<>(Encoder.tableOfRelevantFacts.size());
        int index = 0;
        for (IntExpression fact : Encoder.tableOfRelevantFacts) {
            factIndexMap.put(fact, index);
            index++;
        }

        // Create a map of the relevant tasks with their index to speedup the bit set encoding of the methods
        final Map<IntExpression, Integer> taskIndexMap = new LinkedHashMap<>(Encoder.tableOfRelevantTasks.size());
        index = 0;
        for (IntExpression task : Encoder.tableOfRelevantTasks) {
            taskIndexMap.put(task, index);
            index++;
        }

        // Creates the list of actions and methods
        Encoder.actions = new ArrayList<>(Constants.DEFAULT_ACTION_TABLE_SIZE);
        Encoder.methods = new ArrayList<>(Constants.DEFAULT_METHOD_TABLE_SIZE);

        // Encode the goal in bit set representation
        if (intGoal != null && (!intGoal.getChildren().isEmpty() || intGoal.getConnective().equals(PDDLConnective.ATOM))) {
            Encoder.goal = BitEncoding.encodeGoal(intGoal, factIndexMap);
        } else {
            Encoder.goal = new State();
        }

        if (intTaskNetwork != null) {
            Encoder.initialTaskNetwork = BitEncoding.encodeTaskNetwork(intTaskNetwork, taskIndexMap);
        }

        // Encode the initial state in bit set representation
        Encoder.init = BitEncoding.encodeInit(intInitPredicates, factIndexMap);

        // Encode the actions in bit set representation
        Encoder.actions.addAll(0, BitEncoding.encodeActions(intActions, factIndexMap));

        // Encode the methods in bit set representation
        Encoder.methods.addAll(0, BitEncoding.encodeMethods(intMethods, factIndexMap, taskIndexMap));

        // Just for logging
        if (Encoder.logLevel == 7) {
            stringBuilder.append("\nFinal actions:\n");
            for (Action a : Encoder.actions) {
                stringBuilder.append(Encoder.toString(a) + "\n");
            }
            if (Encoder.requirements.contains(PDDLRequireKey.HTN)) {
                stringBuilder.append("\nFinal methods:\n");
                for (Method m : Encoder.methods) {
                    stringBuilder.append(Encoder.toString(m) + "\n");
                }
            }
            stringBuilder.append("Final initial state:\n").append("(and");
            for (IntExpression f : intInitPredicates) {
                stringBuilder.append(" ").append(Encoder.toString(f)).append("\n");
            }


            if (!Encoder.requirements.contains(PDDLRequireKey.HTN)) {
                stringBuilder.append("\nFinal goal state:\n");
                if (Encoder.goal == null) { // Goal null
                    stringBuilder.append("goal can be simplified to FALSE");
                } else if (!Encoder.goal.isEmpty()) { // Goal not Null and not empty
                    stringBuilder.append(Encoder.toString(Encoder.goal));
                } else { // Goal not Null and empty
                    stringBuilder.append("goal can be simplified to TRUE");
                }
            } else {
                stringBuilder.append("Final initial task network state:\n");
                stringBuilder.append(Encoder.toString(Encoder.initialTaskNetwork));
            }
            stringBuilder.append("\n\n");
            LOGGER.trace(stringBuilder);
            stringBuilder.setLength(0);
        }

        final Problem codedProblem = new Problem();
        codedProblem.setGoal(Encoder.goal);
        codedProblem.setInitialState(Encoder.init);
        codedProblem.setInitialTaskNetwork(Encoder.initialTaskNetwork);
        codedProblem.setActions(Encoder.actions);
        codedProblem.setMethods(Encoder.methods);
        codedProblem.setConstants(Encoder.tableOfConstants);
        codedProblem.setDomains(Encoder.tableOfDomains);
        codedProblem.setFunctions(Encoder.tableOfFunctions);
        codedProblem.setTasks(Encoder.tableOfTasks);
        codedProblem.setInertia(Encoder.tableOfInertia);
        codedProblem.setInferredDomains(Encoder.tableOfInferredDomains);
        codedProblem.setPredicates(Encoder.tableOfPredicates);
        codedProblem.setRelevantFluents(Encoder.tableOfRelevantFacts);
        codedProblem.setRelevantTasks(Encoder.tableOfRelevantTasks);
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
     *
     * @param stringBuilder the string builder used to print.
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
     *
     * @param stringBuilder the string builder used to print.
     */
    static void printTableOfConstants(StringBuilder stringBuilder) {
        stringBuilder.append("Constants table:\n");
        for (int i = 0; i < Encoder.tableOfConstants.size(); i++) {
            stringBuilder.append(i).append(": ").append(Encoder.tableOfConstants.get(i)).append("\n");
        }
    }

    /**
     * Print the table of predicates.
     *
     * @param stringBuilder the string builder used to print.
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
     * @param stringBuilder the string builder used to print.
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
     * Print the table of tasks.
     *
     * @param stringBuilder the string builder used to print.
     */
    static void printTableOfTasks(StringBuilder stringBuilder) {
        stringBuilder.append("Tasks table:\n");
        for (int i = 0; i < Encoder.tableOfTasks.size(); i++) {
            String predicate = Encoder.tableOfTasks.get(i);
            stringBuilder.append(i).append(": ").append(predicate).append(" :");
            for (int j = 0; j < Encoder.tableOfTypedTasks.get(i).size(); j++) {
                stringBuilder.append(" ")
                    .append(Encoder.tableOfTypes.get(Encoder.tableOfTypedTasks.get(i).get(j)));
            }
            stringBuilder.append("\n");
        }
    }

    /**
     * Print the table of inertia.
     *
     * @param stringBuilder the string builder used to print.
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
     *
     * @param stringBuilder the string builder used to print.
     */
    static void printRelevantFactsTable(StringBuilder stringBuilder) {
        stringBuilder.append("Relevant facts:\n");
        for (int i = 0; i < Encoder.tableOfRelevantFacts.size(); i++) {
            stringBuilder.append(i).append(": ").append(Encoder.toString(Encoder.tableOfRelevantFacts.get(i)));
            stringBuilder.append("\n");
        }
    }

    /**
     * Print the relevant facts table.
     *
     * @param stringBuilder the string builder used to print.
     */
    static void printRelevantTasksTable(StringBuilder stringBuilder) {
        stringBuilder.append("Relevant tasks:\n");
        for (int i = 0; i < Encoder.tableOfRelevantTasks.size(); i++) {
            stringBuilder.append(i).append(": ").append(Encoder.toString(Encoder.tableOfRelevantTasks.get(i)));
            stringBuilder.append("\n");
        }
    }

    /**
     * Print the goal.
     *
     * @param stringBuilder the string builder used to print.
     */
    static void printGoal(StringBuilder stringBuilder) {
        stringBuilder.append("Goal state is:\n");
        for (State exp : Encoder.codedGoal) {
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
    static String toShortString(final IntAction op) {
        return StringDecoder.toShortString(op, Encoder.tableOfConstants);
    }

    /**
     * Returns a string representation of the specified operator.
     *
     * @param op the operator to print.
     * @return a string representation of the specified operator.
     */
    static String toString(final IntAction op) {
        return StringDecoder.toString(op, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfTasks);
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param meth the method to print.
     * @return a string representation of the specified method.
     */
    static String toString(final IntMethod meth) {
        return StringDecoder.toString(meth, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfTasks);
    }

    /**
     * Returns a string representation of the specified tn.
     *
     * @param tn the method to print.
     * @return a string representation of the specified tn.
     */
    static String toString(final IntTaskNetwork tn) {
        return StringDecoder.toString(tn, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfTasks);
    }

    /**
     * Returns a string representation of the specified action.
     *
     * @param a the action to print.
     * @return a string representation of the specified action.
     */
    static String toString(final Action a) {
        return StringDecoder.toString(a, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfRelevantFacts);
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param m the method to print.
     * @return a string representation of the specified method.
     */
    static String toString(final Method m) {
        return StringDecoder.toString(m, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfTasks,
            Encoder.tableOfRelevantFacts, Encoder.tableOfRelevantTasks);
    }

    /**
     * Returns a string representation of the specified task network.
     *
     * @param taskNetwork the task network to print.
     * @return a string representation of the specified task network.
     */
    static String toString(final TaskNetwork taskNetwork) {
        return StringDecoder.toString(taskNetwork, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfTasks,
            Encoder.tableOfRelevantTasks);
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    static String toString(final IntExpression exp) {
        return StringDecoder.toString(exp, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfTasks);
    }

    /**
     * Returns a string representation of a bit expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    static String toString(State exp) {
        return StringDecoder.toString(exp, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfRelevantFacts);
    }

    /**
     * Returns a string representation of a conditional bit expression.
     *
     * @param exp the conditional expression.
     * @return a string representation of the specified expression.
     */
    static String toString(ConditionalEffect exp) {
        return StringDecoder.toString(exp, Encoder.tableOfConstants,
            Encoder.tableOfTypes, Encoder.tableOfPredicates,
            Encoder.tableOfFunctions, Encoder.tableOfRelevantFacts);
    }

    /**
     * Print the table of inertia.
     */
    static void printTableOfGroundInertia(StringBuilder stringBuilder) {
        stringBuilder.append("Ground inertia table:");
        for (Entry<IntExpression, Inertia> e : Encoder.tableOfGroundInertia.entrySet()) {
            stringBuilder.append(Encoder.toString(e.getKey())).append(": ").append(e.getValue());
        }
    }

}
