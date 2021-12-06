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

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.parser.PDDLAction;
import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDerivedPredicate;
import fr.uga.pddl4j.parser.PDDLExpression;
import fr.uga.pddl4j.parser.PDDLMethod;
import fr.uga.pddl4j.parser.PDDLNamedTypedList;
import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.parser.PDDLSymbol;
import fr.uga.pddl4j.parser.PDDLTaskNetwork;
import fr.uga.pddl4j.parser.PDDLTypedSymbol;
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.problem.operator.AbstractGroundOperator;
import fr.uga.pddl4j.problem.operator.AbstractIntOperator;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.IntExpression;
import fr.uga.pddl4j.problem.operator.IntMethod;
import fr.uga.pddl4j.problem.operator.IntTaskNetwork;
import fr.uga.pddl4j.problem.operator.OrderingConstraintSet;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class contains all the methods needed to encode the a planning problem into int representation before
 * instantiation.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public abstract class AbstractProblem implements Problem {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(AbstractProblem.class.getName());

    /**
     * The PDDL domain.
     */
    //private PDDLDomain domain;

    /**
     * The PDDL problem.
     */
    private ParsedProblem problem;

    /**
     * The set of requirements of the problem.
     */
    private Set<PDDLRequireKey> requirements;

    /**
     * The type symbols of the problem.
     */
    private List<String> typeSymbols;

    /**
     * The values domain of associated to the type.
     */
    private List<Set<Integer>> domains;

    /**
     * The constant symbols.
     */
    private List<String> constantSymbols;

    /**
     * The predicates symbols.
     */
    private List<String> predicateSymbols;

    /**
     * The typed signature of the predicates.
     */
    private List<List<Integer>> predicateSignatures;

    /**
     * The function symbols.
     */
    private List<String> functionSymbols;

    /**
     * The typed signature of the functions.
     */
    private List<List<Integer>> functionSignatures;

    /**
     * The task symbols.
     */
    private List<String> taskSymbols;

    /**
     * The typed signature of the tasks.
     */
    private List<List<Integer>> taskSignatures;

    /**
     * The set primitive task symbols, i.e., the set of action symbol.
     */
    private Set<String> primitiveTaskSymbols;

    /**
     * The set compound task symbols, i.e., the set of task symbols used in methods.
     */
    private Set<String> compoundTaskSymbols;

    /**
     * The list of actions into int representation.
     */
    private List<IntAction> intActions;

    /**
     * The set of fluents of the initial state of the problem.
     */
    private Set<IntExpression> intInitialState;

    /**
     * The set of numeric fluent of the initial state of the problem.
     */
    private Set<IntExpression> intInitFunctions;

    /**
     * The initial value of the numeric fluent of the initial state.
     */
    private Map<IntExpression, Double> intInitFunctionCost;

    /**
     * The goal representation into in representation.
     */
    private IntExpression intGoal;

    /**
     * The list of methods defined in the problem.
     */
    private List<IntMethod> intMethods;

    /**
     * The initial task network into its integer representation.
     */
    private IntTaskNetwork intInitialTaskNetwork;

    /**
     * The enum used to list the set of internal data structures needed by the instantiation process.
     */
    protected enum Data {
        /**
         * The types and the domain of the type.
         */
        TYPES,
        /**
         * The type symbols.
         */
        TYPE_SYMBOLS,
        /**
         * The constants symbols.
         */
        CONSTANT_SYMBOLS,
        /**
         * The function symbols.
         */
        FUNCTION_SYMBOLS,
        /**
         * The predicate symbols.
         */
        PREDICATE_SYMBOLS,
        /**
         * The primitive task symbols.
         */
        PRIMITIVE_TASKS_SYMBOLS,
        /**
         * The compound task symbols.
         */
        COMPOUND_TASKS_SYMBOLS,
        /**
         * The primitive and the compound task symbols.
         */
        TASKS_SYMBOLS,
        /**
         * The predicate signature (the predicate symbol and the type of each argument).
         */
        PREDICATE_SIGNATURES,
        /**
         * The function signature (the function symbol and the type of each argument).
         */
        FUNCTION_SIGNATURES,
        /**
         * The task signature (the task symbol and the type of each argument).
         */
        TASK_SIGNATURES,
        /**
         * The list of actions in their integer representation.
         */
        INT_ACTIONS,
        /**
         * The list of methods in their integer representation.
         */
        INT_METHODS,
        /**
         * The goal in its integer representation.
         */
        INT_GOAL,
        /**
         * The initial state in its integer representation.
         */
        INT_INITIAL_STATE,
        /**
         * The initial task netwok in its integer representation.
         */
        INT_INITIAL_TASK_NETWORK,
        /**
         * The list of inertia detected.
         */
        INERTIA,
        /**
         * The list of numeric inertia detected.
         */
        NUMERIC_INERTIA,
        /**
         * The list of ground inertia detected.
         */
        GROUND_INERTIA,
        /**
         * The list of ground numeric inertia detected.
         */
        GROUND_NUMERIC_INERTIA,
        /**
         * The list of actions of the instantiated problem.
         */
        ACTIONS,
        /**
         * The list of methods of the instantiated problem.
         */
        METHODS,
        /**
         * The list of relevant fluents of the instantiated problem.
         */
        FLUENTS,
        /**
         * The list of relevant numeric fluents of the instantiated problem.
         */
        NUMERIC_FLUENTS,
        /**
         * The list of relevant tasks of the instantiated problem.
         */
        TASKS,
        /**
         * The list of task resolvers of the instantiated problem.
         */
        TASK_RESOLVERS,
        /**
         * The initial task network the instantiated problem.
         */
        INITIAL_TASK_NETWORK,
        /**
         * The goal of the instantiated problem.
         */
        GOAL,
        /**
         * The initial state the instantiated problem.
         */
        INITIAL_STATE,
    }

    /**
     * The empty constructor to block the default constructor of object.
     */
    private AbstractProblem() {
        super();
    }


    /**
     * Creates a new problem from a domain and problem.
     *
     * @param problem the problem.
     */
    public AbstractProblem(final ParsedProblem problem) {
        this();
        //this.domain = domain;
        this.problem = problem;
    }

    /**
     * Returns the parsed problem used to create this problem.
     *
     * @return the parsed problem used to create this problem.
     */
    public final ParsedProblem getParsedProblem() {
        return this.problem;
    }

    /**
     * Returns the requirements of the problem.
     *
     * @return the requirements of the problem.
     */
    public final Set<PDDLRequireKey> getRequirements() {
        return this.requirements;
    }

    /**
     * Returns the list of the type symbols of the problem.
     *
     * @return the list of the type symbols of the problem.
     */
    public final List<String> getTypes() {
        return this.typeSymbols;
    }

    /**
     * Returns the domains for each type of the problem.
     *
     * @return the domains for each type of the problem.
     */
    public final List<Set<Integer>> getDomains() {
        return this.domains;
    }

    /**
     * Returns the list of constant symbols of the problem.
     *
     * @return the list of constant symbols of the problem.
     */
    public final List<String> getConstantSymbols() {
        return this.constantSymbols;
    }

    /**
     * Returns the list of predicate symbols of the problem.
     *
     * @return the list predicate symbols of the problem.
     */
    public final List<String> getPredicateSymbols() {
        return this.predicateSymbols;
    }

    /**
     * Returns the signatures of the predicates defined in the problem.
     *
     * @return the signatures of the predicates defined in the problem.
     */
    public final List<List<Integer>> getPredicateSignatures() {
        return this.predicateSignatures;
    }

    /**
     * Returns the list of task symbols of the problem.
     *
     * @return the list of task symbols of the problem.
     */
    protected List<String> getTaskSymbols() {
        return this.taskSymbols;
    }

    /**
     * Returns the signatures of the task defined in the problem.
     *
     * @return the signatures of the task defined in the problem.
     */
    protected List<List<Integer>> getTaskSignatures() {
        return this.taskSignatures;
    }

    /**
     * Returns the list of function symbols of the problem.
     *
     * @return the list of function symbols of the problem.
     */
    protected List<String> getFunctions() {
        return this.functionSymbols;
    }

    /**
     * Returns the signatures of the functions defined in the problem.
     *
     * @return the signatures of the functions defined in the problem.
     */
    protected List<List<Integer>> getFunctionSignatures() {
        return this.functionSignatures;
    }

    /**
     * Returns the list of primitive task symbols of the problem.
     *
     * @return the list of primitive task symbols of the problem.
     */
    protected Set<String> getPrimitiveTaskSymbols() {
        return this.primitiveTaskSymbols;
    }

    /**
     * Returns the list of compound tasks symbols of the problem.
     *
     * @return the list of compound tasks symbols of the problem.
     */
    protected Set<String> getCompoundTaskSymbols() {
        return this.compoundTaskSymbols;
    }


    /**
     * Instantiates the problem. This method calls in this order the methods initialization(), preinstantiation(),
     * instantiation(), postinstantiation() and finalization(). This methods must be override in each concrete classe.
     */
    public final void instantiate() {
        this.initialization();
        this.preinstantiation();
        this.instantiation();
        this.postinstantiation();
        this.finalization();
    }

    /**
     * Instantiates the problem. This method calls in this order the methods initialization(), preinstantiation(),
     * instantiation(), postinstantiation() and finalization(). This methods must be override in each concrete classe.
     *
     * @param level the log level.
     */
    public final void instantiate(final Level level) {
        //this.setTraceLevel(level);
        this.initialization();
        this.preinstantiation();
        this.instantiation();
        this.postinstantiation();
        this.finalization();
    }

    /**
     * This methods initializes the structures needed to the instantiation process from the PDDL domain and problem
     * given in parameters of the constructor of the class. First, it collects the constants, the types, the predicate,
     * the function and the tasks symbols. Then, it encodes the actions, the methods, the goal and the initial tasks
     * network of the problem into compact int representation.
     */
    protected abstract void initialization();

    /**
     * This method carries out all the necessary treatment to preinstantiate the problem. In particular, it calculates
     * the static properties (Inertia) of the problem in order to prune as soon as possible the actions that can never
     * be triggered.
     */
    protected abstract void preinstantiation();

    /**
     * This methods carries out the instantiation of the planning operators and the goal of the problem in to actions.
     */
    protected abstract void instantiation();

    /**
     * This method carries out all the necessary treatment to postinstantiate the problem. In particular, it simplifies
     * the actions instantiated based on static properties based on the initial state information of the problem in
     * order to prune the actions that can never be triggered.
     */
    protected abstract void postinstantiation();

    /**
     * This methods finalize the domain, i.e., it encodes the planning problem into it final compact representation
     * using bit set.
     */
    protected abstract void finalization();

    /**
     * Init the list of requirement of the problem.
     *
     * @throws RequirementNotSupportedException if the requirements of the domain and the problem are not supported.
     */
    protected void initRequirements() throws RequirementNotSupportedException {
        this.requirements = new LinkedHashSet<PDDLRequireKey>();
        this.requirements.addAll(this.problem.getRequirements());

        if (!this.getAcceptedRequirements().containsAll(this.requirements)) {
            this.requirements.removeAll(this.getAcceptedRequirements());
            StringBuilder str = new StringBuilder();
            str.append("Requirements not supported:");
            for (PDDLRequireKey requirement : this.requirements) {
                str.append(" ");
                str.append(requirement.getImage());
            }
            throw new RequirementNotSupportedException(str.toString());
        }
    }

    /**
     * Initializes the list of type symbols form the list declared in the domain. The corresponding domain of values
     * of the type is created. The domain is empty.
     */
    protected void initTypes() {
        final List<PDDLTypedSymbol> types = this.problem.getTypes();
        final int nbTypes = types.size();
        this.typeSymbols = new ArrayList<>(nbTypes);
        this.domains = new ArrayList<>(nbTypes);
        for (PDDLTypedSymbol type : types) {
            this.typeSymbols.add(type.getImage());
            this.domains.add(new LinkedHashSet<>());
        }
    }

    /**
     * Initializes the constants declared in the domain and the problem and initialise the domains of values of each
     * type.
     */
    protected void initConstants() {
        final List<PDDLTypedSymbol> constants = this.problem.getConstants();
        this.constantSymbols = new ArrayList<>(this.problem.getConstants().size());
        constants.addAll(this.problem.getObjects());
        for (PDDLTypedSymbol constant : constants) {
            int ic = this.constantSymbols.indexOf(constant.getImage());
            if (ic == -1) {
                ic = this.constantSymbols.size();
                this.constantSymbols.add(constant.getImage());
            }
            final LinkedList<PDDLSymbol> types = new LinkedList<>(constant.getTypes());
            while (!types.isEmpty()) {
                PDDLSymbol type = types.poll();
                final int it = this.typeSymbols.indexOf(type.getImage());
                types.addAll(this.problem.getType(type).getTypes());
                this.domains.get(it).add(ic);
            }
        }
    }

    /**
     * Initializes the composite type, i.e., type of the form (either t1 t2), through a specified domain and
     * problem and creates their respective domain. Warning: constants must be collected before using this method. It
     * is necessary to correctly initialized the domain of the either types collected.
     */
    protected void initEitherTypes() {
        // Collect the types from the predicates declaration
        for (PDDLNamedTypedList predicate : this.problem.getPredicates()) {
            this.initEitherTypes(predicate.getArguments());
        }
        // Collect the types from the functions declaration
        for (PDDLNamedTypedList function : this.problem.getFunctions()) {
            this.initEitherTypes(function.getArguments());
        }
        // Collect the types from the constraints declaration of the domain
        if (this.problem.getConstraints() != null) {
            this.initEitherTypes(this.problem.getConstraints());
        }
        // Collect the types from the derived predicates
        for (PDDLDerivedPredicate axiom : this.problem.getDerivesPredicates()) {
            this.initEitherTypes(axiom.getHead().getArguments());
            this.initEitherTypes(axiom.getBody());
        }
        // Collect the type from the actions
        for (PDDLAction op : this.problem.getActions()) {
            this.initEitherTypes(op.getParameters());
            if (op.getDuration() != null) {
                this.initEitherTypes(op.getDuration());
            }
            this.initEitherTypes(op.getPreconditions());
            this.initEitherTypes(op.getEffects());
        }
        // Collect the types from the constraints declaration of the problem
        if (this.problem.getConstraints() != null) {
            this.initEitherTypes(this.problem.getConstraints());
        }
        // Collect the types from the goal declaration of the problem
        if (this.problem.getGoal() != null) {
            this.initEitherTypes(this.problem.getGoal());
        }
    }

    /**
     * Initializes the information types from a list of PDDL typed symbols.
     *
     * @param list the list of typed symbol.
     */
    private void initEitherTypes(final List<PDDLTypedSymbol> list) {
        for (PDDLTypedSymbol elt : list) {
            final List<PDDLSymbol> types = elt.getTypes();
            if (types.size() > 1) {
                String newType;
                Set<Integer> newTypeDomain = new LinkedHashSet<>();
                StringBuilder buf = new StringBuilder();
                buf.append("either");
                for (PDDLSymbol type : types) {
                    final String image = type.getImage();
                    buf.append("~");
                    buf.append(image);
                    int typeIndex = this.typeSymbols.indexOf(image);
                    final Set<Integer> typeDomain = this.domains.get(typeIndex);
                    newTypeDomain.addAll(typeDomain);
                }
                newType = buf.toString();
                int index = this.typeSymbols.indexOf(newType);
                if (index == -1) {
                    this.domains.add(new LinkedHashSet<>(newTypeDomain));
                    this.typeSymbols.add(newType);
                }
            }
        }
    }

    /**
     * Initializes the either type from a specified expression.
     *
     * @param exp the expression.
     */
    private void initEitherTypes(final PDDLExpression exp) {
        switch (exp.getConnective()) {
            case AND:
            case OR:
                exp.getChildren().forEach(this::initEitherTypes);
                break;
            case FORALL:
            case EXISTS:
                this.initEitherTypes(exp.getVariables());
                this.initEitherTypes(exp.getChildren().get(0));
                break;
            case WHEN:
                this.initEitherTypes(exp.getChildren().get(0));
                this.initEitherTypes(exp.getChildren().get(1));
                break;
            case NOT:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
                this.initEitherTypes(exp.getChildren().get(0));
                break;
            case HOLD_AFTER:
            case WITHIN:
                this.initEitherTypes(exp.getChildren().get(1));
                break;
            case ALWAYS_WITHIN:
                this.initEitherTypes(exp.getChildren().get(1));
                this.initEitherTypes(exp.getChildren().get(2));
                break;
            case HOLD_DURING:
                this.initEitherTypes(exp.getChildren().get(2));
                break;
            case IS_VIOLATED:
            case NUMBER:
            case ATOM:
            case FN_HEAD:
            case TIME_VAR:
            case EQUAL:
            case EQUAL_ATOM:
            case FN_ATOM:
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case UMINUS:
            case F_EXP_T:
            case F_EXP:
            case MINIMIZE:
            case MAXIMIZE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
    }

    /**
     * Initializes the predicates information (symbols and signatures) declared in the domain.
     */
    protected void initPredicates() {
        final List<PDDLNamedTypedList> predicates = this.problem.getPredicates();
        final int nbPredicates = predicates.size();
        this.predicateSymbols = new ArrayList<>(nbPredicates);
        this.predicateSignatures = new ArrayList<>(nbPredicates);
        for (PDDLNamedTypedList predicate : predicates) {
            this.predicateSymbols.add(predicate.getName().getImage());
            final List<PDDLTypedSymbol> arguments = predicate.getArguments();
            final List<Integer> argType = new ArrayList<>(arguments.size());
            for (PDDLTypedSymbol arg : arguments) {
                final List<PDDLSymbol> types = arg.getTypes();
                if (types.size() > 1) {
                    final StringBuilder image = new StringBuilder("either");
                    for (PDDLSymbol type : types) {
                        image.append("~");
                        image.append(type.getImage());
                    }
                    argType.add(this.typeSymbols.indexOf(image.toString()));
                } else {
                    argType.add(this.typeSymbols.indexOf(types.get(0).getImage()));
                }
            }
            this.predicateSignatures.add(argType);
        }
    }

    /**
     * Initializes the function information (symbols and signatures) declared in the domain.
     */
    protected void initFunctions() {
        final List<PDDLNamedTypedList> functions = this.problem.getFunctions();
        this.functionSymbols = new ArrayList<>(functions.size());
        this.functionSignatures = new ArrayList<>(functions.size());
        for (PDDLNamedTypedList function : functions) {
            this.functionSymbols.add(function.getName().getImage());
            List<PDDLTypedSymbol> arguments = function.getArguments();
            List<Integer> argType = new ArrayList<>(arguments.size());
            for (PDDLTypedSymbol argument : arguments) {
                List<PDDLSymbol> types = argument.getTypes();
                if (types.size() > 1) {
                    StringBuilder type = new StringBuilder("either");
                    for (PDDLSymbol type1 : types) {
                        type.append("~").append(type1.getImage());
                    }
                    argType.add(this.typeSymbols.indexOf(type.toString()));
                } else {
                    argType.add(this.typeSymbols.indexOf(types.get(0).getImage()));
                }
            }
            this.functionSignatures.add(argType);
        }
    }

    /**
     * Initializes the tasks information (symbols and signatures) declared in the domain.
     */
    protected void initTasks() {
        final List<PDDLNamedTypedList> tasks = this.problem.getTasks();
        final int nbTasks = tasks.size();
        this.taskSymbols = new ArrayList<>(nbTasks);
        this.taskSignatures = new ArrayList<>(nbTasks);
        for (PDDLNamedTypedList task : tasks) {
            this.taskSymbols.add(task.getName().getImage());
            final List<PDDLTypedSymbol> arguments = task.getArguments();
            final List<Integer> argType = new ArrayList<>(arguments.size());
            for (PDDLTypedSymbol arg : arguments) {
                final List<PDDLSymbol> types = arg.getTypes();
                if (types.size() > 1) {
                    final StringBuilder image = new StringBuilder("either");
                    for (PDDLSymbol type : types) {
                        image.append("~");
                        image.append(type.getImage());
                    }
                    argType.add(this.typeSymbols.indexOf(image.toString()));
                } else {
                    argType.add(this.typeSymbols.indexOf(types.get(0).getImage()));
                }
            }
            this.taskSignatures.add(argType);
        }
    }

    /**
     * Initializes the primitive task symbols from the actions of the domain.
     */
    protected void initPrimitiveTaskSymbols() {
        this.primitiveTaskSymbols = new LinkedHashSet<>();
        for (PDDLAction a : this.getParsedProblem().getActions()) {
            this.primitiveTaskSymbols.add(a.getName().getImage());
        }
    }

    /**
     * Initializes the compound task symbols from the methods of the domain.
     */
    protected void initCompoundTaskSymbols() {
        this.compoundTaskSymbols = new LinkedHashSet<>();
        for (PDDLMethod m : this.getParsedProblem().getMethods()) {
            this.compoundTaskSymbols.add(m.getTask().getAtom().get(0).getImage());
        }
    }

    /**
     * Returns the list of actions under its integer representation of the problem.
     *
     * @return the list of actions under its integer representation of the problem.
     * @see IntAction
     */
    protected List<IntAction> getIntActions() {
        return this.intActions;
    }

    /**
     * Returns the list of fluent in the form of <code>IntExpression</code> of the initial state.
     *
     * @return the list of fluent in the form of <code>IntExpression</code> of the initial state.
     * @see IntExpression
     */
    protected Set<IntExpression> getIntInitialState() {
        return this.intInitialState;
    }

    /**
     * Returns the map that store the value of the numeric fluents in the form of <code>IntExpression</code> of the
     * initial state.
     *
     * @return the map that store the value of the numeric fluents in the form of <code>IntExpression</code> of the
     *      initial state.
     * @see IntExpression
     */
    protected Map<IntExpression, Double> getIntInitFunctionCost() {
        return this.intInitFunctionCost;
    }

    /**
     * Returns the goal of the problem as an <code>IntExpression</code>.
     *
     * @return the goal of the problem as an <code>IntExpression</code>.
     * @see IntExpression
     */
    protected IntExpression getIntGoal() {
        return this.intGoal;
    }

    /**
     * Returns the list of numeric fluents in the form of <code>IntExpression</code> of the initial state.
     *
     * @return the list of numeric fluents in the form of <code>IntExpression</code> of the initial state.
     * @see IntExpression
     */
    protected Set<IntExpression> getIntInitFunctions() {
        return this.intInitFunctions;
    }

    /**
     * Returns the list of methods of the problem into its integer representation.
     *
     * @return the list of methods of the problem into its integer representation.
     */
    protected List<IntMethod> getIntMethods() {
        return this.intMethods;
    }

    /**
     * Returns the initial task network into its integer representation.
     *
     * @return the initial task network into its integer representation.
     */
    protected IntTaskNetwork getIntInitialTaskNetwork() {
        return this.intInitialTaskNetwork;
    }

    /**
     * Sets the integer initial task network of thi problem.
     *
     * @param taskNetwork the task network to set.
     */
    protected final void setIntInitialTaskNetwork(IntTaskNetwork taskNetwork) {
        this.intInitialTaskNetwork = taskNetwork;
    }

    /**
     * Encodes a specified initial state into its integer representation.
     */
    protected void initInitialState() {
        this.intInitialState = new LinkedHashSet<>();
        this.intInitFunctionCost = new LinkedHashMap<>();
        this.intInitFunctions = new LinkedHashSet<>();
        final Set<IntExpression> init =  this.getParsedProblem().getInit().stream().map(this::initExpression)
            .collect(Collectors.toCollection(LinkedHashSet::new));
        for (IntExpression exp : init) {
            switch (exp.getConnective()) {
                case FN_ATOM:
                    this.intInitFunctions.add(exp);
                    this.intInitFunctionCost.put(exp.getChildren().get(0), exp.getChildren().get(1).getValue());
                    break;
                case ATOM:
                    this.intInitialState.add(exp);
                    break;
                default:
                    throw new UnexpectedExpressionException(exp.getConnective().toString());

            }
        }
    }

    /**
     * Encodes a specified goal into its integer representation.
     **/
    protected void initGoal() {
        this.intGoal = new IntExpression(PDDLConnective.AND);
        if (this.getParsedProblem().getGoal() != null) {
            this.intGoal = this.initExpression(this.getParsedProblem().getGoal());
        }
    }

    /**
     * Encodes the actions of the domain into a compact integer representation.
     */
    protected void initActions() {
        this.intActions = this.getParsedProblem().getActions().stream().map(this::initActions)
            .collect(Collectors.toList());
    }

    /**
     * Encode an operator into its integer representation.
     *
     * @param action the operator to encode.
     * @return encoded operator.
     */
    private IntAction initActions(final PDDLAction action) {
        final IntAction intAction = new IntAction(action.getName().getImage(), action.getArity());
        // Encode the parameters of the operator
        final List<String> variables = new ArrayList<>(action.getArity());
        for (int i = 0; i < action.getArity(); i++) {
            final PDDLTypedSymbol parameter = action.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.getTypes().indexOf(typeImage);
            intAction.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the duration of the action
        if (action.isDurative()) {
            final IntExpression duration = this.initExpression(action.getDuration(), variables);
            intAction.setDuration(duration);
        }
        // Encode the preconditions of the operator
        final IntExpression preconditions = this.initExpression(action.getPreconditions(), variables);
        intAction.setPreconditions(preconditions);
        // Encode the effects of the operator
        final IntExpression effects = this.initExpression(action.getEffects(), variables);
        intAction.setEffects(effects);
        return intAction;
    }

    /**
     * Encodes the methods of the domain into a compact integer representation.
     */
    protected void initMethods() {
        this.intMethods = this.getParsedProblem().getMethods().stream()
            .map(this::initMethod).collect(Collectors.toList());
    }

    /**
     * Encode an method into its integer representation.
     *
     * @param method the metho to encode.
     * @return encoded method.
     */
    private IntMethod initMethod(final PDDLMethod method) {
        final IntMethod intMeth = new IntMethod(method.getName().getImage(), method.getArity());
        // Encode the parameters of the operator
        final List<String> variables = new ArrayList<>(method.getArity());
        for (int i = 0; i < method.getArity(); i++) {
            final PDDLTypedSymbol parameter = method.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.getTypes().indexOf(typeImage);
            intMeth.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the task carried out by the method
        final IntExpression task = this.initExpression(method.getTask(), variables);
        intMeth.setTask(task);
        // Encode the preconditions of the method
        final IntExpression preconditions = this.initExpression(method.getPreconditions(), variables);
        intMeth.setPreconditions(preconditions);
        // Encode the subtasks of the method
        final IntExpression subtasks = this.initExpression(method.getSubTasks(), variables);
        intMeth.setSubTasks(subtasks);
        // Encode the ordering constraints of the method
        IntExpression orderingConstraints = null;
        // Express the total ordering into explicites constraints
        if (method.isTotallyOrdered() && subtasks.getChildren().size() > 1) {
            orderingConstraints = new IntExpression(PDDLConnective.AND);
            for (int i = 0; i < subtasks.getChildren().size() - 1; i++) {
                final IntExpression constraint = new IntExpression(PDDLConnective.LESS_ORDERING_CONSTRAINT);
                final IntExpression t1 = new IntExpression(PDDLConnective.TASK);
                t1.setTaskID(i);
                constraint.addChild(t1);
                final IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                t2.setTaskID(i + 1);
                constraint.addChild(t2);
                orderingConstraints.addChild(constraint);
            }
        } else {
            final int size = subtasks.getChildren().size();
            final OrderingConstraintSet constraints = new OrderingConstraintSet(size);
            orderingConstraints = this.initOrderingConstraints(method.getOrderingConstraints());
            for (IntExpression c : orderingConstraints.getChildren()) {
                constraints.set(c.getChildren().get(0).getTaskID(), c.getChildren().get(1).getTaskID());
            }
            if (constraints.isTotallyOrdered() && subtasks.getChildren().size() > 1) {
                IntExpression orderedSubtasks = new IntExpression(PDDLConnective.AND);
                for (int i = 0; i < size; i++) {
                    int subtaskIndex = constraints.getTasksWithNoPredecessors().get(0);
                    constraints.removeRow(subtaskIndex);
                    constraints.removeColumn(subtaskIndex);
                    IntExpression st = subtasks.getChildren().get(subtaskIndex);
                    subtasks.getChildren().remove(subtaskIndex);
                    st.setTaskID(i);
                    orderedSubtasks.addChild(st);
                }
                intMeth.setSubTasks(orderedSubtasks);
                orderingConstraints = new IntExpression(PDDLConnective.AND);
                for (int i = 0; i < orderedSubtasks.getChildren().size() - 1; i++) {
                    final IntExpression constraint = new IntExpression(PDDLConnective.LESS_ORDERING_CONSTRAINT);
                    final IntExpression t1 = new IntExpression(PDDLConnective.TASK);
                    t1.setTaskID(i);
                    constraint.addChild(t1);
                    final IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                    t2.setTaskID(i + 1);
                    constraint.addChild(t2);
                    orderingConstraints.addChild(constraint);
                }
            }
        }
        intMeth.setOrderingConstraints(orderingConstraints);
        return intMeth;
    }

    /**
     * Encodes a specified task network into its integer representation.
     */
    protected void initInitialTaskNetwork() {
        // Encode the parameters of the task network
        final PDDLTaskNetwork taskNetwork = this.getParsedProblem().getInitialTaskNetwork();
        final int numberOfParameters = taskNetwork.getParameters().size();
        this.intInitialTaskNetwork = new IntTaskNetwork(numberOfParameters);
        final List<String> variables = new ArrayList<>(numberOfParameters);
        for (int i = 0; i < numberOfParameters; i++) {
            final PDDLTypedSymbol parameter = taskNetwork.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.getTypes().indexOf(typeImage);
            this.intInitialTaskNetwork.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the tasks of the task network
        this.intInitialTaskNetwork.setTasks(this.initExpression(taskNetwork.getTasks(), variables));
        // Encode the ordering constraints of the task network
        IntExpression orderingConstraints = null;
        IntExpression subtasks = this.intInitialTaskNetwork.getTasks();
        if (taskNetwork.isTotallyOrdered() && subtasks.getChildren().size() > 1) {
            orderingConstraints = new IntExpression(PDDLConnective.AND);
            for (int i = 0; i < subtasks.getChildren().size() - 1; i++) {
                final IntExpression constraint = new IntExpression(PDDLConnective.LESS_ORDERING_CONSTRAINT);
                final IntExpression t1 = new IntExpression(PDDLConnective.TASK);
                t1.setTaskID(i);
                constraint.addChild(t1);
                final IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                t2.setTaskID(i + 1);
                constraint.addChild(t2);
                orderingConstraints.addChild(constraint);
            }
        } else {
            final int size = subtasks.getChildren().size();
            final OrderingConstraintSet constraints = new OrderingConstraintSet(size);
            orderingConstraints = this.initOrderingConstraints(taskNetwork.getOrderingConstraints());
            for (IntExpression c : orderingConstraints.getChildren()) {
                constraints.set(c.getChildren().get(0).getTaskID(), c.getChildren().get(1).getTaskID());
            }
            if (constraints.isTotallyOrdered() && subtasks.getChildren().size() > 1) {
                IntExpression orderedSubtasks = new IntExpression(PDDLConnective.AND);
                for (int i = 0; i < size; i++) {
                    int subtaskIndex = constraints.getTasksWithNoPredecessors().get(0);
                    constraints.removeRow(subtaskIndex);
                    constraints.removeColumn(subtaskIndex);
                    IntExpression st = subtasks.getChildren().get(subtaskIndex);
                    subtasks.getChildren().remove(subtaskIndex);
                    st.setTaskID(i);
                    orderedSubtasks.addChild(st);
                }
                this.intInitialTaskNetwork.setTasks(orderedSubtasks);
                orderingConstraints = new IntExpression(PDDLConnective.AND);
                for (int i = 0; i < orderedSubtasks.getChildren().size() - 1; i++) {
                    final IntExpression constraint = new IntExpression(PDDLConnective.LESS_ORDERING_CONSTRAINT);
                    final IntExpression t1 = new IntExpression(PDDLConnective.TASK);
                    t1.setTaskID(i);
                    constraint.addChild(t1);
                    final IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                    t2.setTaskID(i + 1);
                    constraint.addChild(t2);
                    orderingConstraints.addChild(constraint);
                }
            }
        }
        this.intInitialTaskNetwork.setOrderingConstraints(orderingConstraints);
    }

    /**
     * Encode the ordering constraints of method. The index used to encode a task in the ordering constraints
     * expression returned is the index of the task in the AND expression of the tasks list of a method.
     *
     * @param exp the constraints to encode. The constraints must be an AND expression.
     * @throws UnexpectedExpressionException if the exp in parameter is unexpected. Only AND and
     *      LESS_ORDERING_CONSTRAINTS are expected.
     */
    private IntExpression initOrderingConstraints(final PDDLExpression exp) {
        final IntExpression intExp = new IntExpression(exp.getConnective());
        switch (exp.getConnective()) {
            case AND:
                for (int i = 0; i < exp.getChildren().size(); i++) {
                    intExp.addChild(this.initOrderingConstraints(exp.getChildren().get(i)));
                }
                break;
            case LESS_ORDERING_CONSTRAINT:
                IntExpression t1 = new IntExpression(PDDLConnective.TASK);
                t1.setTaskID(Integer.valueOf(exp.getAtom().get(0).getImage().substring(1)));
                intExp.addChild(t1);
                IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                t2.setTaskID(Integer.valueOf(exp.getAtom().get(1).getImage().substring(1)));
                intExp.addChild(t2);
                break;
            default:
                throw new UnexpectedExpressionException(exp.toString());
        }
        return intExp;
    }

    /**
     * Encodes an specified expression into its integer representation.
     *
     * @param exp the expression to encode.
     * @return the integer representation of the specified expression.
     */
    private IntExpression initExpression(final PDDLExpression exp) {
        return this.initExpression(exp, new ArrayList<>());
    }

    /**
     * Encodes an specified expression into its integer representation.
     *
     * <p>Notes:
     * <ul>
     * <li>equal predicate used specified value of -1.</li>
     * <li>variables used negative values in [-1,-infinity[.</li>
     * </ul>
     *
     * @param exp       the expression to encode.
     * @param variables the list of variable already encoded.
     * @return the integer representation of the specified expression.
     */
    protected IntExpression initExpression(final PDDLExpression exp,
                                           final List<String> variables) {
        final IntExpression intExp = new IntExpression(exp.getConnective());
        switch (exp.getConnective()) {
            case EQUAL_ATOM:
                intExp.setPredicate(IntExpression.EQUAL_PREDICATE);
                int[] args = new int[exp.getAtom().size()];
                for (int i = 0; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i] = this.getConstantSymbols().indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case FN_HEAD:
                final String functor = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.getFunctions().indexOf(functor));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.getConstantSymbols().indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case ATOM:
                final String predicate = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.getPredicateSymbols().indexOf(predicate));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.getConstantSymbols().indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case AND:
            case OR:
                for (int i = 0; i < exp.getChildren().size(); i++) {
                    intExp.getChildren().add(this.initExpression(exp.getChildren().get(i), variables));
                }
                break;
            case FORALL:
            case EXISTS:
                final List<String> newVariables = new ArrayList<>(variables);
                final List<PDDLTypedSymbol> qvar = exp.getVariables();
                final String type = this.toStringType(qvar.get(0).getTypes());
                int typeIndex = this.getTypes().indexOf(type);
                intExp.setType(typeIndex);
                intExp.setVariable(-variables.size() - 1);
                newVariables.add(qvar.get(0).getImage());
                if (qvar.size() == 1) {
                    intExp.getChildren().add(this.initExpression(exp.getChildren().get(0), newVariables));
                } else {
                    qvar.remove(0);
                    intExp.getChildren().add(this.initExpression(exp, newVariables));
                }
                break;
            case FN_ATOM:
            case WHEN:
            case DURATION_ATOM:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
                intExp.getChildren().add(this.initExpression(exp.getChildren().get(0), variables));
                intExp.getChildren().add(this.initExpression(exp.getChildren().get(1), variables));
                break;
            case AT_START:
            case AT_END:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case NOT:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case F_EXP:
            case F_EXP_T:
                intExp.getChildren().add(this.initExpression(exp.getChildren().get(0), variables));
                break;
            case NUMBER:
                intExp.setValue(exp.getValue());
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                intExp.getChildren().add(this.initExpression(exp.getChildren().get(0), variables));
                intExp.getChildren().add(this.initExpression(exp.getChildren().get(1), variables));
                intExp.getChildren().add(this.initExpression(exp.getChildren().get(2), variables));
                break;
            case TIME_VAR:
            case IS_VIOLATED:
                // Do nothing
                break;
            case TASK: // ADD TO DEAL WITH HTN
                final String task = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.getTaskSymbols().indexOf(task));
                intExp.setPrimtive(this.getPrimitiveTaskSymbols().contains(task));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.getConstantSymbols().indexOf(argument.getImage());
                    }
                }
                if (exp.getTaskID() != null) { // TaskID is null the task carried out by a method is encoded
                    intExp.setTaskID(Integer.valueOf(exp.getTaskID().getImage().substring(1)));
                }
                intExp.setArguments(args);
                break;
            default:
                // do nothing
        }
        return intExp;
    }

    /**
     * Returns a string representation of the specified action.
     *
     * @param action         the operator to print.
     * @return a string representation of the specified operator.
     */
    protected String toString(final IntAction action) {
        final StringBuilder str = new StringBuilder();
        str.append("Action ").append(action.getName()).append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < action.arity(); i++) {
            final int index = action.getValueOfParameter(i);
            final String type = this.getTypes().get(action.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(this.getConstantSymbols().get(index)).append(" \n");
            }
        }
        if (action.isDurative()) {
            str.append("Duration:\n");
            str.append(toString(action.getDuration()));
            str.append("\nCondition:\n");
        } else {
            str.append("Preconditions:\n");
        }
        str.append(toString(action.getPreconditions()));
        str.append("\n");
        str.append("Effects:\n");
        str.append(toString(action.getEffects()));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param method the method to print.
     * @return a string representation of the specified method.
     */
    protected String toString(final IntMethod method) {
        final StringBuilder str = new StringBuilder();
        str.append("Method ").append(method.getName()).append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < method.arity(); i++) {
            final int index = method.getValueOfParameter(i);
            final String type = this.getTypes().get(method.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(this.getConstantSymbols().get(index));
                str.append(" \n");
            }
        }
        str.append("Task: ").append(toString(method.getTask()));
        str.append("\n");
        str.append("Preconditions:\n");
        str.append(toString(method.getPreconditions()));
        str.append("\n");
        str.append("Subtasks:\n");
        str.append(toString(method.getSubTasks()));
        str.append("\n");
        str.append("Ordering:\n");
        str.append(toString(method.getOrderingConstraints()));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a  string representation of the specified operator.
     *
     * @param operator  the operator.
     * @return a string representation of the specified operator.
     */
    protected String toString(final AbstractIntOperator operator) {
        final StringBuilder str = new StringBuilder();
        if (operator instanceof IntAction) {
            str.append(this.toString((IntAction) operator));
        } else if (operator instanceof IntMethod) {
            str.append(this.toString((IntMethod) operator));
        }
        return str.toString();
    }

    /**
     * Returns a string representation of the specified task network.
     *
     * @param taskNetwork the task network to print.
     * @return a string representation of the specified method.
     */
    protected String toString(final IntTaskNetwork taskNetwork) {
        final StringBuilder str = new StringBuilder();
        str.append("Parameters:\n");
        for (int i = 0; i < taskNetwork.arity(); i++) {
            final int index = taskNetwork.getValueOfParameter(i);
            final String type = this.getTypes().get(taskNetwork.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(this.getConstantSymbols().get(index));
                str.append(" \n");
            }
        }
        str.append("Tasks:\n");
        str.append(toString(taskNetwork.getTasks()));
        str.append("\n");
        str.append("Ordering constraints:\n");
        str.append(toString(taskNetwork.getOrderingConstraints()));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    protected String toString(final IntExpression exp) {
        return this.toString(exp, " ");
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp the expression.
     * @param separator the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression.
     */
    protected String toString(final IntExpression exp, final String separator) {
        return this.toString(exp, "", separator);
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp the expression.
     * @param baseOffset the offset white space from the left used for indentation.
     * @param separator  the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression node.
     */
    protected String toString(final IntExpression exp, String baseOffset, final String separator) {
        final StringBuilder str = new StringBuilder();
        switch (exp.getConnective()) {
            case ATOM:
                str.append("(");
                str.append(this.getPredicateSymbols().get(exp.getPredicate()));
                int[] args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
                    } else {
                        str.append(" ").append(this.getConstantSymbols().get(index));
                    }
                }
                str.append(")");
                break;
            case FN_HEAD:
                str.append("(").append(this.getFunctions().get(exp.getPredicate()));
                args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
                    } else {
                        str.append(" ").append(this.getConstantSymbols().get(index));
                    }
                }
                str.append(")");
                break;
            case TASK:
                str.append("(");
                if (exp.getTaskID() != IntExpression.DEFAULT_TASK_ID) {
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                    str.append(exp.getTaskID());
                    str.append(" (");
                }
                str.append(this.getTaskSymbols().get(exp.getPredicate()));
                args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
                    } else {
                        str.append(" ").append(this.getConstantSymbols().get(index));
                    }
                }
                if (exp.getTaskID() != IntExpression.DEFAULT_TASK_ID) {
                    str.append(")");
                }
                str.append(")");
                break;
            case EQUAL_ATOM:
                str.append("(").append("=");
                args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(-index - 1);
                    } else {
                        str.append(" ").append(this.getConstantSymbols().get(index));
                    }
                }
                str.append(")");
                break;
            case AND:
            case OR:
                String offsetOr = baseOffset + "  ";
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                if (!exp.getChildren().isEmpty()) {
                    for (int i = 0; i < exp.getChildren().size() - 1; i++) {
                        str.append(toString(exp.getChildren().get(i), offsetOr)).append("\n").append(offsetOr);
                    }
                    str.append(toString(exp.getChildren().get(
                        exp.getChildren().size() - 1), offsetOr));
                }
                str.append(")");
                break;
            case FORALL:
            case EXISTS:
                str.append(" (").append(exp.getConnective().getImage());
                str.append(" (").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(-exp.getVariable() - 1);
                str.append(" - ");
                String offsetEx = baseOffset + baseOffset + "  ";
                str.append(this.getTypes().get(exp.getType())).append(")\n").append(offsetEx);
                if (exp.getChildren().size() == 1) {
                    str.append(toString(exp.getChildren().get(0), offsetEx));
                }
                str.append(")");
                break;
            case NUMBER:
                str.append(exp.getValue());
                break;
            case F_EXP:
                str.append(toString(exp.getChildren().get(0), baseOffset));
                break;
            case F_EXP_T:
            case TRUE:
            case FALSE:
                str.append(exp.getConnective());
                break;
            case TIME_VAR:
                str.append(exp.getConnective().getImage());
                break;
            case FN_ATOM:
            case WHEN:
            case DURATION_ATOM:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                str.append(toString(exp.getChildren().get(0), baseOffset));
                str.append(" ");
                str.append(toString(exp.getChildren().get(1), baseOffset));
                str.append(")");
                break;
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case NOT:
            case ALWAYS:
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                str.append(toString(exp.getChildren().get(0), baseOffset));
                str.append(")");
                break;
            case IS_VIOLATED:
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(")");
                break;
            case LESS_ORDERING_CONSTRAINT:
                str.append("(");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(exp.getChildren().get(0).getTaskID());
                str.append(" ");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(exp.getChildren().get(1).getTaskID());
                str.append(")");
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().toString());
        }
        return str.toString();
    }

    /**
     * Returns a string representation of the internal data structure used during instantiation process.
     *
     * @param data the internal data structure.
     * @return a string representation of the internal data structure used during instantiation process.
     */
    protected String toString(final Data data) {
        final StringBuilder str = new StringBuilder();
        switch (data) {
            case TYPES:
                for (int i = 0; i < this.getTypes().size(); i++) {
                    str.append(i);
                    str.append(": ");
                    str.append(this.getTypes().get(i));
                    str.append(":");
                    Set<Integer> domain = this.getDomains().get(i);
                    for (Integer constant : domain) {
                        str.append(" ");
                        str.append(constant);
                    }
                    str.append(System.lineSeparator());
                }
                break;
            case TYPE_SYMBOLS:
                for (int i = 0; i < this.getTypes().size(); i++) {
                    str.append(i).append(": ");
                    str.append(this.getTypes().get(i));
                    str.append(System.lineSeparator());
                }
                break;
            case CONSTANT_SYMBOLS:
                for (int i = 0; i < this.getConstantSymbols().size(); i++) {
                    str.append(i).append(": ");
                    str.append(this.getConstantSymbols().get(i));
                    str.append(System.lineSeparator());
                }
                break;
            case PREDICATE_SYMBOLS:
                for (int i = 0; i < this.getPredicateSymbols().size(); i++) {
                    str.append(i).append(": ");
                    str.append(this.getPredicateSymbols().get(i));
                    str.append(System.lineSeparator());
                }
                break;
            case FUNCTION_SYMBOLS:
                for (int i = 0; i < this.getFunctions().size(); i++) {
                    str.append(i).append(": ");
                    str.append(this.getFunctions().get(i));
                    str.append(System.lineSeparator());
                }
                break;
            case PRIMITIVE_TASKS_SYMBOLS:
                int index = 0;
                for (String symbol : this.getPrimitiveTaskSymbols()) {
                    str.append(index);
                    str.append(": ");
                    str.append(symbol);
                    str.append(System.lineSeparator());
                }
                break;
            case COMPOUND_TASKS_SYMBOLS:
                index = 0;
                for (String symbol : this.getCompoundTaskSymbols()) {
                    str.append(index);
                    str.append(": ");
                    str.append(symbol);
                    str.append(System.lineSeparator());
                }
                break;
            case TASKS_SYMBOLS:
                index = 0;
                for (String symbol : this.getTaskSymbols()) {
                    str.append(index);
                    str.append(": ");
                    str.append(symbol);
                    str.append(System.lineSeparator());
                }
                break;
            case PREDICATE_SIGNATURES:
                for (int i = 0; i < this.getPredicateSymbols().size(); i++) {
                    String symbol = this.getPredicateSymbols().get(i);
                    str.append(i);
                    str.append(": ");
                    str.append(symbol);
                    str.append(":");
                    for (int j = 0; j < this.getPredicateSignatures().get(i).size(); j++) {
                        str.append(" ");
                        str.append(this.getTypes().get(this.getPredicateSignatures().get(i).get(j)));
                    }
                    str.append(System.lineSeparator());
                }
                break;
            case FUNCTION_SIGNATURES:
                for (int i = 0; i < this.getFunctions().size(); i++) {
                    String symbol = this.getFunctions().get(i);
                    str.append(i);
                    str.append(": ");
                    str.append(symbol);
                    str.append(":");
                    for (int j = 0; j < this.getFunctionSignatures().get(i).size(); j++) {
                        str.append(" ");
                        str.append(this.getTypes().get(this.getFunctionSignatures().get(i).get(j)));
                    }
                    str.append(System.lineSeparator());
                }
                break;
            case TASK_SIGNATURES:
                for (int i = 0; i < this.getTaskSymbols().size(); i++) {
                    String symbol = this.getTaskSymbols().get(i);
                    str.append(i);
                    str.append(": ");
                    str.append(symbol);
                    str.append(":");
                    for (int j = 0; j < this.getTaskSignatures().get(i).size(); j++) {
                        str.append(" ");
                        str.append(this.getTypes().get(this.getTaskSignatures().get(i).get(j)));
                    }
                    str.append(System.lineSeparator());
                }
                break;
            case INT_ACTIONS:
                for (IntAction a : this.getIntActions()) {
                    str.append(this.toString(a));
                    str.append(System.lineSeparator());
                }
                break;
            case INT_METHODS:
                for (IntMethod m : this.getIntMethods()) {
                    str.append(this.toString(m));
                    str.append(System.lineSeparator());
                }
                break;
            case INT_GOAL:
                str.append(this.toString(this.getIntGoal()));
                str.append(System.lineSeparator());
                break;
            case INT_INITIAL_STATE:
                str.append("(and");
                for (IntExpression e : this.getIntInitialState()) {
                    str.append("\n ");
                    str.append(this.toString(e));
                }
                if (this.getIntInitFunctions() != null) {
                    for (IntExpression e : this.getIntInitFunctions()) {
                        str.append("\n ");
                        str.append(this.toString(e));
                    }
                }
                str.append(")\n");
                break;
            case INT_INITIAL_TASK_NETWORK:
                str.append(toString(this.getIntInitialTaskNetwork()));
                str.append(System.lineSeparator());
                break;
            default:
                str.append("");
        }
        return str.toString();
    }

    /**
     * Returns a short string representation of the specified operator, i.e., its name and its
     * instantiated parameters.
     *
     * @param operator  the operator.
     * @param constants the table of constants.
     * @return a string representation of the specified operator.
     */
    public String toShortString(final AbstractGroundOperator operator, final List<String> constants) {
        final StringBuilder str = new StringBuilder();
        str.append(operator.getName());
        for (int i = 0; i < operator.arity(); i++) {
            final int index = operator.getValueOfParameter(i);
            if (index == -1) {
                str.append(" ?");
            } else {
                str.append(" ").append(constants.get(index));
            }
        }
        return str.toString();
    }

    /**
     * Returns the string representation of a list of types.
     *
     * @param types the list of types.
     * @return the string representation of this type.
     */
    private String toStringType(final List<PDDLSymbol> types) {
        final StringBuilder str = new StringBuilder();
        if (types.size() > 1) {
            str.append("either");
            for (PDDLSymbol type : types) {
                str.append("~");
                str.append(type.getImage());
            }
        } else {
            str.append(types.get(0).getImage());
        }
        return str.toString();
    }
}
