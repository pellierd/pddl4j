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
import fr.uga.pddl4j.problem.Fluent;
import fr.uga.pddl4j.problem.Method;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.State;
import fr.uga.pddl4j.problem.Task;
import fr.uga.pddl4j.problem.TaskNetwork;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Serializable;
import java.security.spec.ECField;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
 * can similarly define the ground fluents that are never made true or false by one of the actions.
 * </p>
 * <p>
 * <i>Definition:</i> A ground fluent is a negative ground inertia iff it does not occur negatively
 * in an unconditional effect or the consequent of a conditional effect of an action.
 * </p>
 * <p>
 * An initial fluent, which is a negative ground inertia, is never made FALSE and thus always
 * satisfied in all reachable world states. It can be removed from the state description. All its
 * occurrences in the preconditions of actions and in the antecedents of conditional effects can be
 * simplified to TRUE. A fluent, which is a positive ground inertia and not contained in the initial
 * state, is never satisfied in any reachable world state. All its occurrences in the preconditions
 * of actions and in the antecedents of conditional effects can be simplified to FALSE. The
 * remaining fluents are fluents that, roughly speaking, can possibly change their truth value during
 * the planning process. They are therefore relevant to the representation of the planning problem.
 * </p>
 * <p>
 * Then, encoding extracts relevant fluents from the instantiated actions. A relevant fluent is
 * defines as follow:
 * </p>
 * <p>
 * <i>Definition:</i> A ground fluent is relevant if and only if:
 * </p>
 * <ol>
 * <li> it is an initial fluent and not a negative ground inertia, or if</li>
 * <li> it is not an initial fluent and not a positive ground inertia.</li>
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
 * <li>05.05.2020: Add method encoding.</li>
 * </ul>
 *
 * @author D. Pellier
 * @version 1.3 - 08.06.2010
 */
public final class Encoder implements Serializable {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(Encoder.class);

    /**
     * The set of requirements.
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
     * The table of the relevant fluents.
     */
    static List<IntExpression> tableOfRelevantFluents;

    /**
     * The table of the relevant task.
     */
    static List<IntExpression> tableOfRelevantTasks;

    /**
     * The table containing for each relevant task its set of resolvers, i.e., action or methods
     */
    static List<List<Integer>> tableOfRelevantOperators;

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
     * The set primitive task symbols, i.e., the set of action symbol.
     */
    static Set<String> primitiveTaskSymbols;

    /**
     * The set compund task symbols, i.e., the set of task symbols used in methods.
     */
    static Set<String> compoundTaskSymbols;

    /**
     * The list of relevant primitive tasks.
     */
    static List<IntExpression> tableOfRelevantPrimitiveTasks;

    /**
     * The list of relevant compund tasks.
     */
    static List<IntExpression> tableOfRelevantCompundTasks;

    /**
     * The list of relevant methods for a specific task.
     */
    static List<List<Integer>> relevantMethods;

    /**
     * The list of relevant action for a specific task.
     */
    static List<Integer> relevantActions;

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
     * <li> 6 - 1 + fluents selected as relevant to the problem</li>
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
        accepted.add(PDDLRequireKey.HIERARCHY);
        accepted.add(PDDLRequireKey.HTN_METHOD_PREC);

        Encoder.requirements = new LinkedHashSet<>();
        Encoder.requirements.addAll(domain.getRequirements());
        Encoder.requirements.addAll(problem.getRequirements());

        if (!accepted.containsAll(Encoder.requirements)) {
            throw new IllegalArgumentException("only ADL, ACTION_COSTS or HTN problem can be encoded");
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
        if (!Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            intGoal = IntEncoding.encodeGoal(problem.getGoal());
        } else {
            intTaskNetwork = IntEncoding.encodeInitialTaskNetwork(problem.getInitialTaskNetwork());
        }

        final StringBuilder str = new StringBuilder();

        // Just for logging
        if (Encoder.logLevel == 1 || Encoder.logLevel == 2) {
            Encoder.printTableOfConstants(str);
            str.append(System.lineSeparator());
            Encoder.printTableOfPredicates(str);
            str.append(System.lineSeparator());
            if (!Encoder.tableOfFunctions.isEmpty()) {
                Encoder.printTableOfFunctions(str);
                str.append(System.lineSeparator());
            }
            if (!Encoder.tableOfTasks.isEmpty() && Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                Encoder.printTableOfTasks(str);
                str.append(System.lineSeparator());
            }
            Encoder.printTableOfTypes(str);
            LOGGER.trace(str);
            str.setLength(0);
        }

        // Just for logging
        if (Encoder.logLevel == 2) {
            str.append("\nCoded initial state:\n").append("(and");
            for (IntExpression f : intInitPredicates) {
                str.append(" ").append(Encoder.toString(f)).append("\n");
            }
            if (intGoal != null) {
                str.append(")").append("\n\nCoded goal state:\n").append(Encoder.toString(intGoal));
            }
            if (intTaskNetwork != null) {
                str.append(")").append("\n\nCoded initial task network:\n")
                    .append(Encoder.toString(intTaskNetwork));
            }
            if (!intActions.isEmpty()) {
                str.append(")").append("\n\nCoded actions:\n\n");
                for (IntAction op : intActions) {
                    str.append(Encoder.toString(op)).append(System.lineSeparator());
                }
            }
            if (!intMethods.isEmpty()) {
                str.append(")").append("\n\nCoded methods:\n\n");
                for (IntMethod meth : intMethods) {
                    str.append(Encoder.toString(meth)).append(System.lineSeparator());
                }
            }
            LOGGER.trace(str);
            str.setLength(0);
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
            Encoder.printTableOfInertia(str);
            LOGGER.trace(str);
            str.setLength(0);
        }
        // Just for logging
        if (Encoder.logLevel == 4) {
            str.append(System.lineSeparator());
            Encoder.printTableOfConstants(str);
            str.append(System.lineSeparator());
            Encoder.printTableOfTypes(str);
            str.append(System.lineSeparator());
            str.append("\nPre-instantiation initial state:\n");
            str.append("(and");
            for (IntExpression f : intInitPredicates) {
                str.append(" ").append(Encoder.toString(f)).append("\n");
            }
            if (intGoal != null) {
                str.append(")");
                str.append("\n\nPre-instantiation goal state:\n");
                str.append(Encoder.toString(intGoal));
            }
            if (intTaskNetwork != null) {
                str.append(")");
                str.append("\n\nPre-instantiation initial task network:\n");
                str.append(Encoder.toString(intTaskNetwork));
            }
            str.append("\nPre-instantiation actions with inferred types (");
            str.append(intActions.size());
            str.append(" actions):\n");
            for (IntAction a : intActions) {
                str.append(Encoder.toString(a)).append("\n");
            }
            if (Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                str.append("\nPre-instantiation methods with inferred types (");
                str.append(intMethods.size());
                str.append(" methods):\n\n");
                for (IntMethod meth : intMethods) {
                    str.append(Encoder.toString(meth)).append("\n");
                }
            }
            LOGGER.trace(str);
            str.setLength(0);
        }

        // *****************************************************************************************
        // Step 4: Actions instantiation
        // *****************************************************************************************

        // Instantiate the actions
        intActions = Instantiation.instantiateActions(intActions);
        // Extract the ground inertia from the set of instantiated actions
        PostInstantiation.extractGroundInertia(intActions);
        // Simplify the actions based in the ground inertia
        PostInstantiation.simplyActionsWithGroundInertia(intActions, intInitPredicates);
        if (!Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            // Expand the quantified expression in the goal
            Instantiation.expandQuantifiedExpression(intGoal);
            // Simplify the goal with ground inertia information
            PostInstantiation.simplifyGoalWithGroundInertia(intGoal, intInitPredicates);

        }
        // Extract increase and add value to action cost
        PostInstantiation.simplifyIncrease(intActions, intInitFunctionCost);

        // Just for logging
        if (Encoder.logLevel == 5) {
            str.append(System.lineSeparator());
            Encoder.printTableOfConstants(str);
            str.append(System.lineSeparator());
            Encoder.printTableOfTypes(str);
            str.append(System.lineSeparator());
            str.append("\nInstantiation initial state:\n").append("(and");
            for (IntExpression f : intInitPredicates) {
                str.append(" ").append(Encoder.toString(f));
                str.append("\n");
            }
            str.append("\n\nInstantiation actions with inferred types (");
            str.append(intActions.size());
            str.append(" actions):\n\n");
            for (final IntAction op : intActions) {
                str.append(Encoder.toString(op));
                str.append("\n");
            }
            if (!Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                str.append(")");
                str.append("\n\nInstantiation goal state:\n");
                str.append("(and");
                for (final IntExpression g : intGoal.getChildren()) {
                    str.append(" ");
                    str.append(Encoder.toString(g));
                }
            }
            LOGGER.trace(str);
            str.setLength(0);
        }

        // *****************************************************************************************
        // Step 5: Instantiation of the methods
        // *****************************************************************************************

        if (Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {

            List<IntTaskNetwork> initialTaskNetworks = Instantiation.instantiate(intTaskNetwork);
            IntExpression root =  new IntExpression(PDDLConnective.TASK);
            root.setPredicate(Encoder.tableOfTasks.size());
            Encoder.tableOfTasks.add("__top");
            Encoder.compoundTaskSymbols.add("__top");
            root.setPrimtive(false);
            System.out.println(Encoder.toString(root));
            int index = 0;
            for (IntTaskNetwork tn : initialTaskNetworks) {
                IntMethod method = new IntMethod("__to_method_" + index, tn.arity());
                for (int i = 0; i < tn.arity(); i++) {
                    method.setTypeOfParameter(i, tn.getTypeOfParameters(i));
                }
                for (int i = 0; i < tn.arity(); i++) {
                    method.setValueOfParameter(i, tn.getValueOfParameter(i));
                }
                method.setTask(new IntExpression(root));
                method.setPreconditions(new IntExpression(PDDLConnective.AND));
                method.setTaskNetwork(tn);
                System.out.println(Encoder.toString(method));
                intMethods.add(method);
                index++;
            }

            // Creates the abstract initial task network
            intTaskNetwork = new IntTaskNetwork();
            intTaskNetwork.getTasks().addChild(new IntExpression(root));
            System.out.println(Encoder.toString(intTaskNetwork));

            //System.out.println(Encoder.toString(initialTaskNetworks.get(0)));
            intMethods = Instantiation.instantiateMethods(intMethods, intTaskNetwork, intActions);
            // Simplify the methods with the ground inertia information previously extracted
            PostInstantiation.simplyMethodsWithGroundInertia(intMethods, intInitPredicates);
            if (Encoder.logLevel == 5) {
                str.append(System.lineSeparator());
                str.append("\nInstantiation methods with inferred types (");
                str.append(intMethods.size());
                str.append(" methods):\n\n");
                for (IntMethod meth : intMethods) {
                    str.append(Encoder.toString(meth));
                    str.append("\n");
                }
                str.append(")");
                str.append("\n\nInstantiation initial task network:\n");
                str.append(Encoder.toString(intTaskNetwork));
            }
            LOGGER.trace(str);
            str.setLength(0);
        }

        // *****************************************************************************************
        // Step 6: PostInstantiation
        // *****************************************************************************************

        // Extract the relevant fluents from the simplified and instantiated actions and methods
        PostInstantiation.extractRelevantFacts(intActions, intMethods, intInitPredicates);
        // Create the list of relevant tasks
        if (Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            Encoder.tableOfRelevantTasks = new ArrayList<>();
            Encoder.tableOfRelevantTasks.addAll(Encoder.tableOfRelevantPrimitiveTasks);
            Encoder.tableOfRelevantTasks.addAll(Encoder.tableOfRelevantCompundTasks);
        }

        // The table of ground inertia are no more needed
        Encoder.tableOfGroundInertia = null;

        // Just for logging
        if (Encoder.logLevel == 6) {
            Encoder.printRelevantFactsTable(str);
            if (!Encoder.tableOfRelevantTasks.isEmpty()) {
                str.append("\n");
                Encoder.printRelevantTasksTable(str);
            }
            LOGGER.trace(str);
            str.setLength(0);
        }

        // *****************************************************************************************
        // Step 7: Bit set encoding of the problem
        // *****************************************************************************************

        // Creates the final list of actions and methods that will be used in the problem
        Encoder.actions = new ArrayList<>(intActions.size());
        Encoder.methods = new ArrayList<>(intMethods.size());

        // Create a map of the relevant fluents with their index to speedup the bit set encoding of the actions
        final Map<IntExpression, Integer> fluentIndexMap = new LinkedHashMap<>(Encoder.tableOfRelevantFluents.size());
        int index = 0;
        for (IntExpression fluent : Encoder.tableOfRelevantFluents) {
            fluentIndexMap.put(fluent, index);
            index++;
        }

        // Creates the list of relevant operators
        if (Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            Encoder.tableOfRelevantOperators = new ArrayList<>();
            for (Integer a : Encoder.relevantActions) {
                List<Integer> l = new ArrayList<>(1);
                l.add(a);
                Encoder.tableOfRelevantOperators.add(l);
            }
            Encoder.tableOfRelevantOperators.addAll(Encoder.relevantMethods);
        }

        if (!Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            // Encode the goal in bit set representation
            if (!intGoal.getChildren().isEmpty() || intGoal.getConnective().equals(PDDLConnective.ATOM)) {
                Encoder.goal = BitEncoding.encodeGoal(intGoal, fluentIndexMap);
            } else {
                Encoder.goal = new State();
            }
        } else {
            // Create a map of the relevant tasks with their index to speedup the bit set encoding of the methods
            final Map<IntExpression, Integer> taskIndexMap = new LinkedHashMap<>(Encoder.tableOfRelevantTasks.size());
            index = 0;
            for (IntExpression task : Encoder.tableOfRelevantTasks) {
                taskIndexMap.put(task, index);
                index++;
            }
            // Encode the initial task network
            Encoder.initialTaskNetwork = BitEncoding.encodeTaskNetwork(intTaskNetwork, taskIndexMap);
            // Encode the methods in bit set representation
            Encoder.methods.addAll(0, BitEncoding.encodeMethods(intMethods, fluentIndexMap, taskIndexMap));
        }

        // Encode the initial state in bit set representation
        Encoder.init = BitEncoding.encodeInit(intInitPredicates, fluentIndexMap);

        // Encode the actions in bit set representation
        Encoder.actions.addAll(0, BitEncoding.encodeActions(intActions, fluentIndexMap));

        // Just for logging
        if (Encoder.logLevel == 7) {
            str.append("\nFinal actions:\n");
            for (Action a : Encoder.actions) {
                str.append(Encoder.toString(a) + "\n");
            }
            if (Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                str.append("\nFinal methods:\n");
                for (Method m : Encoder.methods) {
                    str.append(Encoder.toString(m) + "\n");
                }
            }
            str.append("Final initial state:\n").append("(and");
            for (IntExpression f : intInitPredicates) {
                str.append(" ").append(Encoder.toString(f)).append("\n");
            }

            if (!Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                str.append("\nFinal goal state:\n");
                if (Encoder.goal == null) { // Goal null
                    str.append("goal can be simplified to FALSE");
                } else if (!Encoder.goal.isEmpty()) { // Goal not Null and not empty
                    str.append(Encoder.toString(Encoder.goal));
                } else { // Goal not Null and empty
                    str.append("goal can be simplified to TRUE");
                }
            } else {
                str.append("Final initial task network state:\n");
                str.append(Encoder.toString(Encoder.initialTaskNetwork));
            }

            if (Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                str.append("\nTable of task resolvers:\n");
                for (int ti = 0; ti < Encoder.tableOfRelevantOperators.size(); ti++) {
                    str.append(ti).append(": ");
                    str.append(Encoder.toString(Encoder.tableOfRelevantTasks.get(ti)));
                    str.append(":");
                    List<Integer> resolvers = Encoder.tableOfRelevantOperators.get(ti);
                    for (int ri = 0; ri < resolvers.size(); ri++) {
                        str.append(" ").append(resolvers.get(ri));
                    }
                    str.append("\n");
                }
            }
            str.append("\n\n");
            LOGGER.trace(str);
            str.setLength(0);
        }


        final Problem codedProblem = new Problem();
        codedProblem.setRequirements(Encoder.requirements);
        codedProblem.setGoal(Encoder.goal);
        codedProblem.setInitialState(Encoder.init);
        codedProblem.setInitialTaskNetwork(Encoder.initialTaskNetwork);
        codedProblem.setActions(Encoder.actions);
        codedProblem.setMethods(Encoder.methods);
        codedProblem.setConstantSymbols(Encoder.tableOfConstants);
        codedProblem.setDomains(Encoder.tableOfDomains);
        codedProblem.setFunctionSymbols(Encoder.tableOfFunctions);
        codedProblem.setTaskSymbols(Encoder.tableOfTasks);
        codedProblem.setInertia(Encoder.tableOfInertia);
        codedProblem.setInferredDomains(Encoder.tableOfInferredDomains);
        codedProblem.setPredicateSymbols(Encoder.tableOfPredicates);
        codedProblem.setRelevantFluents(Encoder.tableOfRelevantFluents.stream().map(
            fluent -> new Fluent(fluent.getPredicate(), fluent.getArguments())).collect(Collectors.toList()));
        if (Encoder.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            codedProblem.setTasks(Encoder.tableOfRelevantTasks.stream().map(
                task -> new Task(task.getPredicate(), task.getArguments(),
                    task.isPrimtive())).collect(Collectors.toList()));
        }
        codedProblem.setTaskResolvers(Encoder.tableOfRelevantOperators);
        codedProblem.setFunctionSignatures(Encoder.tableOfTypedFunctions);
        codedProblem.setPredicateSignatures(Encoder.tableOfTypedPredicates);
        codedProblem.setTypeSymbols(Encoder.tableOfTypes);
        return codedProblem;

    }

    // *********************************************************************************************
    // Methods for printing the different structures used during encoding
    // *********************************************************************************************

    /**
     * Print the table of types.
     *
     * @param str the string builder used to print.
     */
    static void printTableOfTypes(StringBuilder str) {
        str.append("Types table:\n");
        for (int i = 0; i < Encoder.tableOfTypes.size(); i++) {
            str.append(i).append(": ").append(Encoder.tableOfTypes.get(i)).append(":");
            Set<Integer> domain = Encoder.tableOfDomains.get(i);
            for (Integer constant : domain) {
                str.append(" ").append(constant);
            }
            str.append("\n");
        }
    }

    /**
     * Print the table of constants.
     *
     * @param str the string builder used to print.
     */
    static void printTableOfConstants(StringBuilder str) {
        str.append("Constants table:\n");
        for (int i = 0; i < Encoder.tableOfConstants.size(); i++) {
            str.append(i).append(": ").append(Encoder.tableOfConstants.get(i)).append("\n");
        }
    }

    /**
     * Print the table of predicates.
     *
     * @param str the string builder used to print.
     */
    static void printTableOfPredicates(StringBuilder str) {
        str.append("Predicates table:\n");
        for (int i = 0; i < Encoder.tableOfPredicates.size(); i++) {
            String predicate = Encoder.tableOfPredicates.get(i);
            str.append(i).append(": ").append(predicate).append(" :");
            for (int j = 0; j < Encoder.tableOfTypedPredicates.get(i).size(); j++) {
                str.append(" ")
                    .append(Encoder.tableOfTypes.get(Encoder.tableOfTypedPredicates.get(i).get(j)));
            }
            str.append("\n");
        }
    }

    /**
     * Print the table of functions.
     *
     * @param str the string builder used to print.
     */
    static void printTableOfFunctions(StringBuilder str) {
        str.append("Functions table:\n");
        for (int i = 0; i < Encoder.tableOfFunctions.size(); i++) {
            String predicate = Encoder.tableOfFunctions.get(i);
            str.append(i).append(": ").append(predicate).append(":");
            for (int j = 0; j < Encoder.tableOfTypedFunctions.get(i).size(); j++) {
                str.append(" ").append(Encoder.tableOfTypes.get(Encoder.tableOfTypedFunctions.get(i).get(j)));
            }
            str.append("\n");
        }
    }

    /**
     * Print the table of tasks.
     *
     * @param str the string builder used to print.
     */
    static void printTableOfTasks(StringBuilder str) {
        str.append("Tasks table:\n");
        for (int i = 0; i < Encoder.tableOfTasks.size(); i++) {
            String predicate = Encoder.tableOfTasks.get(i);
            str.append(i).append(": ").append(predicate).append(" :");
            for (int j = 0; j < Encoder.tableOfTypedTasks.get(i).size(); j++) {
                str.append(" ")
                    .append(Encoder.tableOfTypes.get(Encoder.tableOfTypedTasks.get(i).get(j)));
            }
            str.append("\n");
        }
    }

    /**
     * Print the table of inertia.
     *
     * @param str the string builder used to print.
     */
    static void printTableOfInertia(StringBuilder str) {
        str.append("Inertias table:\n");
        for (int i = 0; i < Encoder.tableOfPredicates.size(); i++) {
            String predicate = Encoder.tableOfPredicates.get(i);
            str.append(i).append(": ").append(predicate).append(" : ").append(Encoder.tableOfInertia.get(i));
            str.append("\n");
        }
    }

    /**
     * Print the relevant fluents table.
     *
     * @param str the string builder used to print.
     */
    static void printRelevantFactsTable(StringBuilder str) {
        str.append("Relevant fluents:\n");
        for (int i = 0; i < Encoder.tableOfRelevantFluents.size(); i++) {
            str.append(i).append(": ").append(Encoder.toString(Encoder.tableOfRelevantFluents.get(i)));
            str.append("\n");
        }
    }

    /**
     * Print the relevant fluents table.
     *
     * @param str the string builder used to print.
     */
    static void printRelevantTasksTable(StringBuilder str) {
        str.append("Relevant tasks:\n");
        for (int i = 0; i < Encoder.tableOfRelevantTasks.size(); i++) {
            IntExpression task = Encoder.tableOfRelevantTasks.get(i);
            str.append(i).append(": ").append(Encoder.toString(task));
            if (task.isPrimtive()) {
                str.append(" - PRIMITIVE");
            } else {
                str.append(" - COMPOUND");
            }
            str.append("\n");
        }
    }

    /**
     * Print the goal.
     *
     * @param str the string builder used to print.
     */
    static void printGoal(StringBuilder str) {
        str.append("Goal state is:\n");
        for (State exp : Encoder.codedGoal) {
            str.append(Encoder.toString(exp));
            str.append("\n");
        }
    }

    /**
     * Returns a short string representation of the specified operator, i.e., only its name and the
     * value of its parameters.
     *
     * @param op the operator.
     * @return a string representation of the specified operator.
     */
    static String toShortString(final AbstractGroundOperator op) {
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
            Encoder.tableOfFunctions, Encoder.tableOfRelevantFluents);
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
            Encoder.tableOfRelevantFluents, Encoder.tableOfRelevantTasks);
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
            Encoder.tableOfFunctions, Encoder.tableOfRelevantFluents);
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
            Encoder.tableOfFunctions, Encoder.tableOfRelevantFluents);
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
