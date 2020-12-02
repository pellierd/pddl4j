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

import fr.uga.pddl4j.parser.*;
import fr.uga.pddl4j.problem.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
     * The table of inferred domains based on unary inertia encoding.
     */
    //static List<Set<Integer>> tableOfInferredDomains;

    /**
     * The table that defines for each predicates its type of inertia.
     */
    //static List<Inertia> tableOfNumericInertia;


    /**
     * The log level of the planner.
     */
    static int logLevel;


    /**
     * The table of the relevant fluents.
     */
    //static List<IntExpression> tableOfRelevantFluents;

    /**
     * The table of the relevant fluents.
     */
    //static List<IntExpression> tableOfRelevantNumericFluents;

    /**
     * The table of the relevant task.
     */
    //static List<IntExpression> tableOfRelevantTasks;

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
    static Goal goal;

    /**
     * The initial task network.
     */
    static TaskNetwork initialTaskNetwork;

    /**
     * The encoded goal.
     */
    static List<Goal> codedGoal;

    /**
     * The initial state.
     */
    static InitialState init;


    /**
     * The list of relevant primitive tasks.
     */
    //static List<IntExpression> tableOfRelevantPrimitiveTasks;

    /**
     * The list of relevant compund tasks.
     */
    //static List<IntExpression> tableOfRelevantCompundTasks;

    /**
     * The list of relevant methods for a specific task.
     */
    //static List<List<Integer>> relevantMethods;

    /**
     * The list of relevant action for a specific task.
     */
    //static List<Integer> relevantActions;

    static Map<IntExpression, Double> intInitFunctionCost;

    static ADLProblem pb;
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
    public static ProblemOld encode(final PDDLDomain domain, final PDDLProblem problem) {

        Encoder.pb = new ADLProblem(domain, problem);
        Encoder.pb.instantiate(1000);


        final StringBuilder str = new StringBuilder();


        // *****************************************************************************************
        // Step 6: PostInstantiation
        // *****************************************************************************************

        // Extract the relevant fluents from the simplified and instantiated actions and methods
        //PostInstantiation.extractRelevantFacts(Encoder.pb.getIntActions(), Encoder.pb.getIntMethods(), Encoder.pb.getIntInitPredicates());
        /*if (Encoder.pb.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            PostInstantiation.extractRelevantNumericFluents(Encoder.pb.getIntActions(), Encoder.pb.getIntMethods());
        }*/

        // Create the list of relevant tasks
        /*if (Encoder.pb.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            Encoder.tableOfRelevantTasks = new ArrayList<>();
            Encoder.tableOfRelevantTasks.addAll(pb.getTableOfRelevantPrimitiveTasks());
            Encoder.tableOfRelevantTasks.addAll(pb.getTableOfRelevantCompundTasks());
        }

        // The table of ground inertia are no more needed
        //Encoder.tableOfGroundInertia = null;

        // Just for logging
        if (Encoder.logLevel == 6) {
            Encoder.printRelevantFactsTable(str);
            if (!Encoder.pb.getRelevantTasks().isEmpty()) {
                str.append("\n");
                Encoder.printRelevantTasksTable(str);
            }
            LOGGER.trace(str);
            str.setLength(0);
        }*/

        // *****************************************************************************************
        // Step 7: Bit set encoding of the problem
        // *****************************************************************************************

        // Creates the final list of actions and methods that will be used in the problem
        Encoder.actions = new ArrayList<>(Encoder.pb.getIntActions().size());
        if (Encoder.pb.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            Encoder.methods = new ArrayList<>(Encoder.pb.getIntMethods().size());
        }

        // Create a map of the relevant fluents with their index to speedup the bit set encoding of the actions
        final Map<IntExpression, Integer> fluentIndexMap = new LinkedHashMap<>(Encoder.pb.getTableOfRelevantFluents().size());
        int index = 0;
        for (IntExpression fluent : Encoder.pb.getTableOfRelevantFluents()) {
            fluentIndexMap.put(fluent, index);
            index++;
        }

        final Map<IntExpression, Integer> numericFluentIndexMap = new LinkedHashMap<>(Encoder.pb.getTableOfRelevantFluents().size());
        if (Encoder.pb.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            // Create a map of the relevant numeric fluents with their index to speedup the bit set encoding of the actions
            index = 0;
            for (IntExpression fluent : Encoder.pb.getTableOfRelevantNumericFluents()) {
                numericFluentIndexMap.put(fluent, index);
                index++;
            }
        }

        // Creates the list of relevant operators
        if (Encoder.pb.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            Encoder.tableOfRelevantOperators = new ArrayList<>();
            for (Integer a : Encoder.pb.getRelevantActions()) {
                List<Integer> l = new ArrayList<>(1);
                l.add(a);
                Encoder.tableOfRelevantOperators.add(l);
            }
            Encoder.tableOfRelevantOperators.addAll(Encoder.pb.getRelevantMethods());
        }

        if (Encoder.pb.getIntGoal() != null && (!Encoder.pb.getIntGoal().getChildren().isEmpty()
            || Encoder.pb.getIntGoal().getConnective().equals(PDDLConnective.ATOM))) {
            Encoder.goal = BitEncoding.encodeGoal(Encoder.pb.getIntGoal(), fluentIndexMap, numericFluentIndexMap);
        } else {
            Encoder.goal = new Goal();
        }
        if (Encoder.pb.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            // Create a map of the relevant tasks with their index to speedup the bit set encoding of the methods
            final Map<IntExpression, Integer> taskIndexMap = new LinkedHashMap<>(Encoder.pb.getRelevantTasks().size());
            index = 0;
            for (IntExpression task : Encoder.pb.getRelevantTasks()) {
                taskIndexMap.put(task, index);
                index++;

            }
            // Encode the initial task network
            Encoder.initialTaskNetwork = BitEncoding.encodeTaskNetwork(Encoder.pb.getIntInitialTaskNetwork(), taskIndexMap);
            // Encode the methods in bit set representation
            Encoder.methods.addAll(0, BitEncoding.encodeMethods(Encoder.pb.getIntMethods(), fluentIndexMap, taskIndexMap));
        }

        // Encode the initial state in bit set representation
        Encoder.init = BitEncoding.encodeInit(Encoder.pb.getIntInitPredicates(), fluentIndexMap);
        if (Encoder.pb.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            BitEncoding.encodeInitNumericFluent(Encoder.init, numericFluentIndexMap, Encoder.intInitFunctionCost);
        }
        if (Encoder.pb.getRequirements().contains(PDDLRequireKey.DURATIVE_ACTIONS)) {
            NumericVariable duration = new NumericVariable(NumericVariable.DURATION, 0.0);
            Encoder.init.addNumericFluent(duration);
        }

        // Encode the actions in bit set representation
        Encoder.actions.addAll(0, BitEncoding.encodeActions(Encoder.pb.getIntActions(), fluentIndexMap, numericFluentIndexMap));

        // Just for logging
        if (Encoder.logLevel == 7) {
            str.append("\nFinal actions:\n");
            for (Action a : Encoder.actions) {
                str.append(Encoder.toString(a) + "\n");
            }
            if (Encoder.pb.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
                str.append("\nFinal methods:\n");
                for (Method m : Encoder.methods) {
                    str.append(Encoder.toString(m) + "\n");
                }
            }
            str.append("Final initial state:\n").append("(and");
            for (IntExpression f : Encoder.pb.getIntInitPredicates()) {
                str.append(" ").append(Encoder.toString(f)).append("\n");
            }

            if (Encoder.goal !=  null) {
                str.append("\nFinal goal state:\n");
                if (Encoder.goal == null) { // Goal null
                    str.append("goal can be simplified to FALSE");
                } else if (!Encoder.goal.isEmpty()) { // Goal not Null and not empty
                    str.append(Encoder.toString(Encoder.goal));
                } else { // Goal not Null and empty
                    str.append("goal can be simplified to TRUE");
                }
                str.append("\n\n");
            }
            if (Encoder.pb.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
                str.append("Final initial task network state:\n");
                str.append(Encoder.toString(Encoder.initialTaskNetwork));
            }

            if (Encoder.pb.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
                str.append("\nTable of task resolvers:\n");
                for (int ti = 0; ti < Encoder.tableOfRelevantOperators.size(); ti++) {
                    str.append(ti).append(": ");
                    str.append(Encoder.toString(Encoder.pb.getRelevantTasks().get(ti)));
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


        final ProblemOld codedProblem = new ProblemOld();
        codedProblem.setRequirements(Encoder.pb.getRequirements());
        codedProblem.setGoal(Encoder.goal);
        codedProblem.setInitialState(Encoder.init);
        codedProblem.setInitialTaskNetwork(Encoder.initialTaskNetwork);
        codedProblem.setActions(Encoder.actions);
        codedProblem.setMethods(Encoder.methods);
        codedProblem.setConstantSymbols(Encoder.pb.getConstantSymbols());
        codedProblem.setDomains(Encoder.pb.getDomains());
        codedProblem.setFunctionSymbols(Encoder.pb.getFunctionSymbols());
        codedProblem.setTaskSymbols(Encoder.pb.getTaskSymbols());
        codedProblem.setInertia(Encoder.pb.getTableOfInertia());
        codedProblem.setInferredDomains(Encoder.pb.getTableOfInferredDomains());
        codedProblem.setPredicateSymbols(Encoder.pb.getPredicateSymbols());
        codedProblem.setRelevantFluents(Encoder.pb.getTableOfRelevantFluents().stream().map(
            fluent -> new Fluent(fluent.getPredicate(), fluent.getArguments())).collect(Collectors.toList()));
        if (Encoder.pb.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            codedProblem.setTasks(Encoder.pb.getRelevantTasks().stream().map(
                task -> new Task(task.getPredicate(), task.getArguments(),
                    task.isPrimtive())).collect(Collectors.toList()));
        }
        codedProblem.setTaskResolvers(Encoder.tableOfRelevantOperators);
        codedProblem.setFunctionSignatures(Encoder.pb.getFunctionSignatures());
        codedProblem.setPredicateSignatures(Encoder.pb.getPredicateSignatures());
        codedProblem.setTypeSymbols(Encoder.pb.getTypeSymbols());
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
        for (int i = 0; i < Encoder.pb.getTypeSymbols().size(); i++) {
            str.append(i).append(": ").append(Encoder.pb.getTypeSymbols().get(i)).append(":");
            Set<Integer> domain = Encoder.pb.getDomains().get(i);
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
        for (int i = 0; i < Encoder.pb.getConstantSymbols().size(); i++) {
            str.append(i).append(": ").append(Encoder.pb.getConstantSymbols().get(i)).append("\n");
        }
    }

    /**
     * Print the table of predicates.
     *
     * @param str the string builder used to print.
     */
    static void printTableOfPredicates(StringBuilder str) {
        str.append("Predicates table:\n");
        for (int i = 0; i < Encoder.pb.getPredicateSymbols().size(); i++) {
            String predicate = Encoder.pb.getPredicateSymbols().get(i);
            str.append(i).append(": ").append(predicate).append(" :");
            for (int j = 0; j < Encoder.pb.getPredicateSignatures().get(i).size(); j++) {
                str.append(" ")
                    .append(Encoder.pb.getTypeSymbols().get(Encoder.pb.getPredicateSignatures().get(i).get(j)));
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
        for (int i = 0; i < Encoder.pb.getFunctionSymbols().size(); i++) {
            String predicate = Encoder.pb.getFunctionSymbols().get(i);
            str.append(i).append(": ").append(predicate).append(":");
            for (int j = 0; j < Encoder.pb.getFunctionSignatures().get(i).size(); j++) {
                str.append(" ").append(Encoder.pb.getTypeSymbols().get(Encoder.pb.getFunctionSignatures().get(i).get(j)));
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
        for (int i = 0; i < Encoder.pb.getTaskSymbols().size(); i++) {
            String predicate = Encoder.pb.getTaskSymbols().get(i);
            str.append(i).append(": ").append(predicate).append(" :");
            for (int j = 0; j < Encoder.pb.getTaskSignatures().get(i).size(); j++) {
                str.append(" ")
                    .append(Encoder.pb.getTypeSymbols().get(Encoder.pb.getTaskSignatures().get(i).get(j)));
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
        for (int i = 0; i < Encoder.pb.getPredicateSymbols().size(); i++) {
            String predicate = Encoder.pb.getPredicateSymbols().get(i);
            str.append(i).append(": ").append(predicate).append(" : ").append(Encoder.pb.getTableOfInertia().get(i));
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
        for (int i = 0; i < Encoder.pb.getTableOfRelevantFluents().size(); i++) {
            str.append(i).append(": ").append(Encoder.toString(Encoder.pb.getTableOfRelevantFluents().get(i)));
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
        for (int i = 0; i < Encoder.pb.getRelevantTasks().size(); i++) {
            IntExpression task = Encoder.pb.getRelevantTasks().get(i);
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
        for (Goal exp : Encoder.codedGoal) {
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
        return StringDecoder.toShortString(op, Encoder.pb.getConstantSymbols());
    }

    /**
     * Returns a string representation of the specified operator.
     *
     * @param op the operator to print.
     * @return a string representation of the specified operator.
     */
    static String toString(final IntAction op) {
        return StringDecoder.toString(op, Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(), Encoder.pb.getTaskSymbols());
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param meth the method to print.
     * @return a string representation of the specified method.
     */
    static String toString(final IntMethod meth) {
        return StringDecoder.toString(meth, Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(), Encoder.pb.getTaskSymbols());
    }

    /**
     * Returns a string representation of the specified tn.
     *
     * @param tn the method to print.
     * @return a string representation of the specified tn.
     */
    static String toString(final IntTaskNetwork tn) {
        return StringDecoder.toString(tn, Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(), Encoder.pb.getTaskSymbols());
    }

    /**
     * Returns a string representation of the specified action.
     *
     * @param a the action to print.
     * @return a string representation of the specified action.
     */
    static String toString(final Action a) {
        return StringDecoder.toString(a, Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(), Encoder.pb.getTableOfRelevantFluents());
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param m the method to print.
     * @return a string representation of the specified method.
     */
    static String toString(final Method m) {
        return StringDecoder.toString(m, Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(), Encoder.pb.getTaskSymbols(),
            Encoder.pb.getTableOfRelevantFluents(), Encoder.pb.getRelevantTasks());
    }

    /**
     * Returns a string representation of the specified task network.
     *
     * @param taskNetwork the task network to print.
     * @return a string representation of the specified task network.
     */
    static String toString(final TaskNetwork taskNetwork) {
        return StringDecoder.toString(taskNetwork, Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(), Encoder.pb.getTaskSymbols(),
            Encoder.pb.getRelevantTasks());
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    static String toString(final IntExpression exp) {
        return StringDecoder.toString(exp, Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(), Encoder.pb.getTaskSymbols());
    }

    /**
     * Returns a string representation of a bit expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    static String toString(Condition exp) {
        return StringDecoder.toString(exp, Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(), Encoder.pb.getTableOfRelevantFluents());
    }

    /**
     * Returns a string representation of a bit expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    static String toString(Goal exp) {
        return StringDecoder.toString(exp, Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(), Encoder.pb.getTableOfRelevantFluents());
    }

    /**
     * Returns a string representation of a bit expression.
     *
     * @param state the expression.
     * @return a string representation of the specified expression.
     */
    static String toString(InitialState state) {
        return StringDecoder.toString(state,
            Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(),
            Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(),
            Encoder.pb.getTableOfRelevantFluents(),
            Encoder.pb.getTableOfRelevantNumericFluents(),
            Encoder.pb.getTaskSymbols());
    }

    static String toString(NumericConstraint constraint) {
        return StringDecoder.toString(constraint);
    }

    /**
     * Returns a string representation of a conditional bit expression.
     *
     * @param exp the conditional expression.
     * @return a string representation of the specified expression.
     */
    static String toString(ConditionalEffect exp) {
        return StringDecoder.toString(exp, Encoder.pb.getConstantSymbols(),
            Encoder.pb.getTypeSymbols(), Encoder.pb.getPredicateSymbols(),
            Encoder.pb.getFunctionSymbols(), Encoder.pb.getTableOfRelevantFluents());
    }

    /**
     * Print the table of inertia.
     */
    static void printTableOfGroundInertia(StringBuilder stringBuilder) {
        stringBuilder.append("Ground inertia table:");
        for (Entry<IntExpression, Inertia> e : Encoder.pb.getTableOfGroundInertia().entrySet()) {
            stringBuilder.append(Encoder.toString(e.getKey())).append(": ").append(e.getValue());
        }
    }

    /**
     * This method is used to make quick test to encoder class. Command line example:
     * <ul>
     *     <li>java -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.encoding.Encoder \\
     *     src/test/resources/benchmarks/pddl/ipc2002/depots//time-simple-automatic/domain.pddl\\
     *     src/test/resources/benchmarks/pddl/ipc2002/depots/time-simple-automatic/p01.pddl
     *     </li>
     * </ul>
     *
     * @param args the arguments of the command line (args[0] the path to the domain file and args[1] the path to the
     *             problem file).
     */
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("invalide arguments");
            System.exit(0);
        }

        final String domain = args[0];
        final String problem = args[1];
        final int traceLevel = 3;


        try {
            // Parses the PDDL domain and problem description
            PDDLParser parser = new PDDLParser();
            parser.parse(new File(domain), new File(problem));
            ErrorManager errorManager = parser.getErrorManager();
            if (!errorManager.getMessages(Message.Type.LEXICAL_ERROR).isEmpty()
                || !errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty()) {
                System.out.println(errorManager.getMessages());
                System.exit(0);
            }
            if (!errorManager.getMessages(Message.Type.PARSER_WARNING).isEmpty()) {
                //System.out.println(errorManager.getMessages());
            }
            // Encodes and instantiates the problem in a compact representation

            try {
                System.out.println(" * Encoding [" + problem + "]" + "...");
                ProblemOld pb = Encoder.encode(parser.getDomain(), parser.getProblem());



            } catch (OutOfMemoryError err) {
                System.err.println("ERR: " + err.getMessage() + " - test aborted");
                return;
            } catch (IllegalArgumentException iaex) {
                if (iaex.getMessage().equalsIgnoreCase("type of the problem to encode not ADL")) {
                    System.err.println("[" + problem + "]: Not ADL problem!");
                } else {
                    throw iaex;
                }
            }

        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

}
