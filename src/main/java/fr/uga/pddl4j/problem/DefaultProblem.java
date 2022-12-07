package fr.uga.pddl4j.problem;

/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

import fr.uga.pddl4j.parser.DefaultParsedProblem;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Expression;
import fr.uga.pddl4j.parser.Parser;
import fr.uga.pddl4j.parser.RequireKey;
import fr.uga.pddl4j.problem.numeric.NumericVariable;
import fr.uga.pddl4j.problem.operator.DurativeMethod;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.Method;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This class implements a default problem. this class allows to realize the instantiation of a problem before its
 * resolution. For the moment, the instantiation process does not deal with the case of fluent objects.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public class DefaultProblem extends FinalizedProblem {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(DefaultProblem.class.getName());

    /**
     * Create a new default problem from a domain and problem.
     *
     * @param problem The problem.
     */
    public DefaultProblem(final DefaultParsedProblem problem) {
        super(problem);
    }

    /**
     * Returns the list of PDDL requirements accepted by the problem.
     *
     * @return the list of PDDL requirements accepted by the problem.
     */
    @Override
    public Set<RequireKey> getAcceptedRequirements() {
        Set<RequireKey> accepted = new HashSet<>();
        accepted.add(RequireKey.ADL);
        accepted.add(RequireKey.STRIPS);
        accepted.add(RequireKey.TYPING);
        accepted.add(RequireKey.EQUALITY);
        accepted.add(RequireKey.NEGATIVE_PRECONDITIONS);
        accepted.add(RequireKey.DISJUNCTIVE_PRECONDITIONS);
        accepted.add(RequireKey.EXISTENTIAL_PRECONDITIONS);
        accepted.add(RequireKey.UNIVERSAL_PRECONDITIONS);
        accepted.add(RequireKey.QUANTIFIED_PRECONDITIONS);
        accepted.add(RequireKey.CONDITIONAL_EFFECTS);
        accepted.add(RequireKey.NUMERIC_FLUENTS);
        accepted.add(RequireKey.DURATIVE_ACTIONS);
        accepted.add(RequireKey.DURATION_INEQUALITIES);
        accepted.add(RequireKey.HIERARCHY);
        accepted.add(RequireKey.METHOD_PRECONDITIONS);
        accepted.add(RequireKey.TIMED_INITIAL_LITERALS);
        return accepted;
    }

    /**
     * This method initializes the structures needed to the instantiation process from the PDDL domain and problem
     * given in parameters of the constructor of the class. First, it collects the constants, the types, the predicate,
     * the function and the tasks symbols. Then, it encodes the actions, the methods, the goal and the initial tasks
     * network of the problem into compact int representation.
     */
    @Override
    protected void initialization() {

        // Standardize the variables symbol contained in the domain
        this.getParsedProblem().normalize();

        // Collect the requirements of the problem.
        this.initRequirements();

        // Collect the information on the type declared in the domain
        this.initTypes();
        // Collect the constants (symbols and types) declared in the domain
        this.initConstants();
        // Collect the either types of the domain
        this.initEitherTypes();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Types declared:\n"
                + this.toString(Data.TYPES) + "\n");
            LOGGER.debug("Constants declared in the problem:\n"
                + this.toString(Data.CONSTANT_SYMBOLS) + "\n");
        }

        // Collect the predicate information (symbols and signatures)
        this.initPredicates();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Predicates declared:\n"
                + this.toString(Data.PREDICATE_SIGNATURES) + "\n");
        }

        // Collect the function information (symbols and signatures)
        if (this.getRequirements().contains(RequireKey.NUMERIC_FLUENTS)) {
            this.initFunctions();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Functions declared:\n"
                    + this.toString(Data.FUNCTION_SIGNATURES) + "\n");
            }
        }

        if (this.getRequirements().contains(RequireKey.HIERARCHY)) {
            // Collect the task information (symbols and signatures)
            this.initTasks();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Tasks declared:\n"
                    + this.toString(Data.TASK_SIGNATURES) + "\n");
            }

            // Init the list of primitive task symbols
            this.initPrimitiveTaskSymbols();
            // Init the list of compound task symbols
            this.initCompoundTaskSymbols();
        }

        // Encode the actions of the domain into integer representation
        this.initActions();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions declared:\n\n"
                + this.toString(Data.INT_ACTIONS));
        }

        if (this.getRequirements().contains(RequireKey.HIERARCHY)) {
            // Encode the methods of the domain into integer representation
            this.initMethods();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Methods declared:\n\n"
                    + this.toString(Data.INT_METHODS));
            }
        }

        // Encode the initial state in integer representation
        this.initInitialState();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initial state declared :\n"
                + this.toString(Data.INT_INITIAL_STATE) + "\n");
        }

        if (this.getRequirements().contains(RequireKey.HIERARCHY)) {
            // Encode the initial task network
            this.initInitialTaskNetwork();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Initial task network declared:\n"
                    + this.toString(Data.INT_INITIAL_TASK_NETWORK) + "\n");
            }
        }

        // Encode the goal in integer representation
        this.initGoal();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Goal declared:\n"
                + this.toString(Data.INT_GOAL) + "\n");
        }

        // Create the predicates tables used to count the occurrences of the predicates in the
        // initial state
        this.createPredicatesTables();

    }

    /**
     * This method carries out all the necessary treatment to preinstantiate the problem. In particular, it calculates
     * the static properties (Inertia) of the problem in order to prune as soon as possible the actions that can never
     * be triggered.
     */
    @Override
    protected void preinstantiation() {
        // Extract the inertia from the list of actions
        this.extractInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Inertia detected:\n"
                + this.toString(Data.INERTIA) + "\n");
        }

        if (this.getRequirements().contains(RequireKey.NUMERIC_FLUENTS)) {
            this.extractNumericInertia();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Numeric inertia detected:\n"
                    + this.toString(Data.NUMERIC_INERTIA) + "\n");
            }
        }

        // Infer the type from the unary inertia
        if (!this.getRequirements().contains(RequireKey.TYPING)) {
            this.inferTypesFromInertia();
            this.simplifyActionsWithInferredTypes();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Actions with inferred types:\n\n"
                    + this.toString(Data.INT_ACTIONS) + "\n");
            }
        }
    }

    /**
     * This methods carries out the instantiation of the planning operators and the goal of the problem in to actions.
     */
    @Override
    protected void instantiation() {
        // Instantiate the actions and the goal
        this.instantiateActions();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions instantiated:\n\n"
                + this.toString(Data.INT_ACTIONS) + "\n");
        }
        this.instantiateGoal();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Goal instantiated:\n"
                + this.toString(Data.INT_GOAL) + "\n");
        }
    }

    /**
     * This method carries out all the necessary treatment to postinstantiate the problem. In particular, it simplifies
     * the actions instantiated based on static properties based on the initial state information of the problem in
     * order to prune the actions that can never be triggered.
     */
    @Override
    protected void postinstantiation() {
        // Extract the ground inertia and simplify the actions and the goal
        this.extractGroundInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Ground inertia detected:\n\n"
                + this.toString(Data.GROUND_INERTIA) + "\n");
        }
        if (this.getRequirements().contains(RequireKey.NUMERIC_FLUENTS)) {
            this.extractGroundNumericInertia();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Ground numeric inertia detected:\n\n"
                    + this.toString(Data.GROUND_NUMERIC_INERTIA) + "\n");
            }
        }
        this.simplyActionsWithGroundInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Actions simplified base on ground inertia detected:\n\n"
                + this.toString(Data.INT_ACTIONS) + "\n");
        }

        this.simplifyGoalWithGroundInertia();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Goal simplified base on ground inertia detected:\n"
                + this.toString(Data.INT_GOAL) + "\n");
        }

        if (this.getRequirements().contains(RequireKey.HIERARCHY)) {
            this.instantiateInitialTaskNetwork();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Initial task-network instantiated:\n"
                    + this.toString(Data.INT_INITIAL_TASK_NETWORK) + "\n");
            }
            this.instantiateMethods();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Methods instantiated:\n\n"
                    + this.toString(Data.INT_METHODS));
            }
            this.simplyMethodsWithGroundInertia();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Methods simplified based on ground inertia:\n\n"
                    + this.toString(Data.INT_METHODS));
            }
        }
    }

    /**
     * This method finalizes the domain, i.e., it encodes the planning problem into it final compact representation
     * using bit set.
     */
    protected void finalization() {
        this.extractRelevantFluents();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Relevant fluents:\n"
                + this.toString(Data.FLUENTS) + "\n");
        }

        this.initOfMapFluentIndex();

        if (this.getRequirements().contains(RequireKey.NUMERIC_FLUENTS)) {
            this.extractRelevantNumericFluents();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Relevant numeric fluents:\n"
                    + this.toString(Data.NUMERIC_FLUENTS) + "\n");
            }
            this.initMapOfNumericFluentIndex();
        }

        if (this.getRequirements().contains(RequireKey.HIERARCHY)) {
            this.initTaskResolvers();
        }

        this.finalizeActions();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(this.toString(Data.ACTIONS) + "\n");
            if (this.getRequirements().contains(RequireKey.DURATIVE_ACTIONS)) {
                LOGGER.debug(this.toString(Data.DURATIVE_ACTIONS) + "\n");
            }
        }

        if (this.getRequirements().contains(RequireKey.HIERARCHY)) {
            this.extractRelevantTasks();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Relevant tasks:\n"
                    + this.toString(Data.TASKS) + "\n");
            }
            //this.initTaskResolvers();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Task resolvers:\n\n"
                    + this.toString(Data.TASK_RESOLVERS) + "\n");
            }

            this.initMapOfTaskIndex();
            this.finalizeMethods();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(this.toString(Data.METHODS) + "\n");
                if (this.getRequirements().contains(RequireKey.DURATIVE_ACTIONS)) {
                    LOGGER.debug(this.toString(Data.DURATIVE_METHODS) + "\n");
                }
            }
        }

        this.finalizeInitialState();

        if (this.getRequirements().contains(RequireKey.NUMERIC_FLUENTS)) {
            this.finalizeInitialNumericFluent();
            if (this.getRequirements().contains(RequireKey.DURATIVE_ACTIONS)) {
                NumericVariable duration = new NumericVariable(NumericVariable.DURATION, 0.0);
                this.getInitialState().addNumericFluent(duration);
            }
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initial state:\n"
                + this.toString(Data.INITIAL_STATE) + "\n");
        }

        if (this.getRequirements().contains(RequireKey.HIERARCHY)) {
            this.finalizeInitialTaskNetwork();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Initial tasknetwork:\n"
                    + this.toString(Data.INITIAL_TASK_NETWORK));
            }
        }

        this.finalizeGoal();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Goal:\n"
                + this.toString(Data.GOAL) + "\n");
        }

    }

    /**
     * Returns <code>true</code> if this problem is solvable. The method returns <code>false</code> if the goal is
     * simplified to <code>false</code> during the instantiation process, otherwise the method returns
     * <code>true</code>. If the problem is hierarchic, the method checks also that every task in the initial task
     * network has at least a one resolver.
     *
     * <p>
     * Warning, it is not because the method returns <code>true</code> that the problem is solvable. It just means that
     * the encoding process can not exclude the fact that the problem is solvable.
     * </p>
     *
     * @return <code>true</code> if this problem is solvable; <code>false</code>.
     */
    public boolean isSolvable() {
        boolean isSolvable = this.getGoal() != null;
        if (this.getInitialTaskNetwork() != null) {
            Iterator<Integer> i = this.getInitialTaskNetwork().getTasks().iterator();
            while (i.hasNext() && isSolvable) {
                isSolvable = i.next() != null;
            }
        }
        return isSolvable;
    }

    /**
     * Returns true if the problem is totally ordered. The method returns true if the problem is not hierarchical, i.e.,
     * contains no methods durative or not and no no initial task network. A hierarchical problem is totally ordered if
     * and only the subtasks of each method of the problem are totally ordered and the initial task network is totally
     * ordered.
     *
     * @return true if the problem is totally ordered, false otherwise.
     */
    public final boolean isTotallyOrdered() {
        boolean totallyOrdered = true;
        Iterator<Method> it = this.getMethods().iterator();
        while (it.hasNext() && totallyOrdered) {
            totallyOrdered = it.next().getTaskNetwork().isTotallyOrdered();
        }
        Iterator<DurativeMethod> jt = this.getDurativeMethods().iterator();
        while (jt.hasNext() && totallyOrdered) {
            totallyOrdered = jt.next().getTaskNetwork().isTotallyOrdered();
        }
        return totallyOrdered ? this.getInitialTaskNetwork().isTotallyOrdered() : totallyOrdered;
    }


    /**
     * TO DO: Remove.
     *
     * @param args the domain and the problem to instantiate.
     */
    public static void main(String[] args) {

        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        org.apache.logging.log4j.core.config.Configuration config = context.getConfiguration();
        LoggerConfig loggerConfig = config.getRootLogger();
        loggerConfig.setLevel(Level.ALL);
        context.updateLoggers();

        Parser parser = new Parser();
        DefaultParsedProblem parsedProblem = null;
        try {
            System.out.println("Parsing start ...");
            parsedProblem = parser.parse(args[0], args[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ErrorManager errorManager = parser.getErrorManager();
        if (!errorManager.isEmpty()) {
            errorManager.printAll();
        } else {
            System.out.println("Problem parsed with success");
            Problem pb = new DefaultProblem(parsedProblem);
            pb.instantiate();
            if (pb.isSolvable()) {
                System.out.println("Problem solvable");
            } else {
                System.out.println("Problem not solvable");
            }

            for (DurativeMethod m : pb.getDurativeMethods()) {
                pb.toString(m);
            }
        }
    }

}
