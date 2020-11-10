package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.*;
import fr.uga.pddl4j.plan.Hierarchy;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.problem.*;
import fr.uga.pddl4j.util.BitMatrix;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pellier on 05/11/2020.
 */
public class IProblem {

    /**
     *
     */
    private int traceLevel;

    /**
     * The set of requirements.
     */
    private Set<PDDLRequireKey> requirements;

    /**
     * The list of type symbols.
     */
    private List<String> typeSymbols;

    /**
     * The domains associated to the types.
     */
    private List<Set<Integer>> typeDomains;

    /**
     * The constant symbols.
     */
    private List<String> constantSymbols;

    /**
     * The predicate symbols.
     */
    private List<String> predicateSymbols;

    /**
     * The types of the arguments of the predicates.
     */
    private List<List<Integer>> typeOfPredicateArguments;

    /**
     * The function symbols.
     */
    private List<String> functionSymbols;

    /**
     * The types of the arguments of the functions.
     */
    private List<List<Integer>> typeOfFunctionArguments;

    /**
     * The task symbols.
     */
    private List<String> taskSymbols;

    /**
     * The types of the arguments of the tasks.
     */
    private List<List<Integer>> typeOfTaskArguments;

    /**
     * The list of actions of the problem used for instantiation.
     */
    private List<IntAction> intActions;

    /**
     * The set primitive task symbols, i.e., the set of action symbol.
     */
    private Set<String> primitiveTaskSymbols;

    /**
     * The list of methods of the problem used for instantiation.
     */
    private List<IntMethod> intMethods;

    /**
     * The set compound task symbols, i.e., the set of task symbols used in methods.
     */
    private Set<String> compoundTaskSymbols;

    /**
     * The initial state of the problem.
     */
    private Set<IntExpression> intInitialState;

    /**
     * The goal of the problem.
     */
    private IntExpression intGoal;

    /**
     * The initial task netwok of the problem.
     */
    private IntTaskNetwork intInitialTaskNetwork;

    /**
     * The table that defines for each predicates its type of inertia.
     */
    private List<Inertia> inertia;

    /**
     * The table that contains the ground inertia.
     */
    private Map<IntExpression, Inertia> groundInertia;

    /**
     * The list of relevant methods for a specific task.
     */
    private List<List<Integer>> compundTaskResolvers;

    /**
     * The list of relevant action for a specific task.
     */
    private List<List<Integer>> primtiveTaskResolvers;

    /**
     * The table containing for each relevant task its set of resolvers, i.e., action or methods
     */
    private List<List<Integer>> taskResolvers;

    /**
     * The list of relevant compund tasks.
     */
    private List<IntExpression> relevantCompundTasks;

    /**
     * The list of relevant primitive tasks.
     */
    private List<IntExpression> relevantPrimitiveTasks;

    /**
     * The table of the relevant task.
     */
    private List<Task> relevantTasks;

    /**
     * The table of the relevant fluents.
     */
    private List<Fluent> relevantFluents;

    /*
    * The table of the relevant numeric fluents.
    */
    private List<NumericFluent> relevantNumericFluents;

    /**
     * The table of fluent index used to speedup the final and compact encoding of the problem.
     */
    private Map<IntExpression, Integer> fluenIndex;

    /**
     * The table of numeric fluent index used to speedup the bit encoding.
     */
    private Map<IntExpression, Integer> numericFluentIndex;

    /**
     * The table of task index used to speedup the bit encoding.
     */
    private Map<IntExpression, Integer> taskIndex;

    /**
     * The initial task network.
     */
    private TaskNetwork initialTaskNetwork;

    /**
     * The goal.
     */
    private List<Condition> goal;

    /**
     * The list of instantiated actions encoded into bit sets.
     */
    private List<Action> actions;

    /**
     * The list of instantiated methods encoded into bit sets.
     */
    private List<Method> methods;

    /**
     * The initial state.
     */
    private InitialState initialState;

    private boolean isInstnatiated;

    /**
     *
     */
    public IProblem(PDDLDomain domain, PDDLProblem problem) {
        this.collectRequirementInformation(domain, problem);
        // Collects the information about the types symbols used in the problem.
        this.collectTypeInformation(domain);
        // Collects the information about the constants declared in the domain and the objects of the problem
        this.collectConstantInformation(domain, problem);
        // Collects the information about the type of the form (either t1 t2...) declared in the domain and the problem
        this.collectEitherTypeInformation(domain, problem);
        // Collects the information about the predicates defined in the domain.
        this.collectPredicateInformation(domain);
        // Collects the information about the functions defined in the domain.
        if (this.requirements.contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.collectFunctionInformation(domain);
        }
        // Encode the tasks defined in the domain.
        if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            this.collectTaskInformation(domain);
        }
        // Collects the information about the actions defined in the domain
        this.collectActionInformation(domain);
        if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            // Collects the information about the primitive tasks
            this.collectPrimitiveTaskInformation();
            // Collects the information about the methods and the compound tasks defined in the domain
            this.collectMethodInformation(domain);
        }
        // Collects the information about the initial state
        this.collectInitialStateInformation(problem);
        // Collects the information about the goal of the problem.
        this.collectGoalInformation(problem);

        if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            // Collects the information about the initial tasks network of the problem.
            this.collectInitialTaskNetworkInformation(problem);
        }

        // HACK for durative action very inefficient
        if (this.requirements.contains(PDDLRequireKey.DURATIVE_ACTIONS)) {
            List<IntAction> simplifiedActions = new ArrayList<>();
            for (IntAction a : this.intActions) {
                a.getPreconditions().expandQuantifiedExpression(this.typeDomains);
                a.getEffects().expandQuantifiedExpression(this.typeDomains);
                a.getPreconditions().moveNegationInward();
                a.getPreconditions().moveTimeSpecifierInward();
                a.getEffects().moveTimeSpecifierInward();
                a.getEffects().moveNegationInward();
                // TO DO: UPDATE TO DEAL WHITH CONDITIONAL EFFECT VERY INEFFICIENT
                simplifiedActions.addAll(a.expandConditionalEffect());

            }
            this.intActions.clear();
            this.intActions.addAll(simplifiedActions);

            simplifiedActions.clear();
            for (IntAction a : this.intActions) {
                simplifiedActions.addAll(a.expandDisjunctivePrecondition());
            }
            this.intActions.clear();
            this.intActions.addAll(simplifiedActions);

            simplifiedActions.clear();
            for (IntAction a : this.intActions) {
                simplifiedActions.addAll(a.toSimpleNonTemporalActions());
            }
            this.intActions.clear();
            this.intActions.addAll(simplifiedActions);
        }

    }

    /**
     * Returns the requirements of the problem.
     *
     * @return the set of requirements of the problem.
     */
    public final Set<PDDLRequireKey> getRequirements() {
        return this.requirements;
    }

    /**
     * Returns the list of type symbols of the problem.
     *
     * @return the list of type symbols of the problem.
     */
    public final List<String> getTypeSymbols() {
        return this.typeSymbols;
    }

    /**
     * Returns the domains of values of the types defined in the problem.
     *
     * @return the domains of values of the types defined in the problem.
     */
    public final List<Set<Integer>> getTypeDomains() {
        return this.typeDomains;
    }

    /**
     * Returns the list of constant symbols used in the problem.
     *
     * @return the list of constant symbols used in the problem.
     */
    public final List<String> getConstantSymbols() {
        return this.constantSymbols;
    }

    /**
     * Returns the list of predicate symbols used in the problem.
     *
     * @return the list of predicate symbols used in the problem.
     */
    public final List<String> getPredicateSymbols() {
        return this.predicateSymbols;
    }

    /**
     * Returns the types of the arguments of the predicates.  he list returned at index i corresponds to the types of
     * the arguments of the predicate at the same index in the list of predicate symbols.
     *
     * @return the types of the arguments of the predicates.
     * @see this#getPredicateSymbols()
     */
    public final List<List<Integer>> geTypeOfPredicateArguments() {
        return this.typeOfPredicateArguments;
    }

    /**
     * Returns the list of predicate symbols used in the problem. The method returns is null if the problem is not
     * FLUENT or NUMERIC-FLUENT.
     */
    public List<String> getFunctionSymbols() {
        return this.functionSymbols;
    }

    /**
     * Returns the types of the arguments of the functions. TThe method returns is null if the problem is not FLUENT or
     * NUMERIC-FLUENT. The list returned at index i corresponds to the types of the arguments of the function at the
     * same index in the list of function symbols.
     *
     * @return the types of the arguments of the functions.
     * @see this#getFunctionSymbols()
     */
    public final List<List<Integer>> getTypeOfFunctionArguments() {
        return this.typeOfFunctionArguments;
    }

    /**
     * Returns the list of task symbols. The method returns is null if the problem has not the requirement HIERARCHY.
     *
     * @return the list of task symbols.
     */
    public final List<String> getTaskSymbols() {
        return this.typeSymbols;
    }

    /**
     * Returns the types of the arguments of the tasks. The method returns is null if the problem has not the
     * requirement HIERARCHY. The list returned at index i corresponds to the types of the arguments of the task at the
     * same index in the list or relevant task.
     *
     * @return the types of the arguments of the tasks.
     * @see this#getRelevantTasks()
     */
    public final List<List<Integer>> getTypeOfTaskArguments() {
        return this.typeOfTaskArguments;
    }

    /**
     * Returns the list primitive task symbols, i.e., the set of action symbol. The method returns is null if the
     * problem has not the requirement HIERARCHY.
     *
     * @return the list primitive task symbols, i.e., the set of action symbol.
     */
    public final List<String> getPrimitiveTaskSymbols() {
        return new ArrayList<>(this.primitiveTaskSymbols);
    }

    /**
     * Returns the list compound task symbols. The method returns is null if the problem has not the requirement
     * HIERARCHY.
     *
     * @return the list compound task symbols.
     */
    public final List<String> getCompoundTaskSymbols() {
        return new ArrayList<>(this.compoundTaskSymbols);
    }

    /**
     * Returns for each predicates its type of inertia.
     *
     * @return for each predicates its type of inertia.
     */
    public final List<Inertia> getInertia () {
        return this.inertia;
    }

    /**
     * Returns the resolvers, i.e., the list of actions or methods that resolves the tasks. The resolvers with index
     * i correspond to the task with the same idnex in the list of relevant tasks of the problem.
     * The method returns null if the problem has not the requirement HIERARCHY.
     *
     * @returns the resolvers, i.e., the list of actions or methods that resolve the tasks.
     * @see this#getRelevantTasks()
     */
    public final List<List<Integer>> getTaskResolvers() {
        return this.taskResolvers;
    }

    /**
     * Returns the list of relevant tasks of the problem. The method returns null if the problem has not the requirement
     * HIERARCHY.
     *
     * @returns he list of relevant tasks of the problem.
     */
    public final List<Task> getRelevantTasks() {
        return this.relevantTasks;
    }

    /**
     * Returns the list of relevant fluents of the problem.
     *
     * @returns he list of relevant fluents of the problem.
     */
    public final List<Fluent> getRelevantFluents() {
        return this.relevantFluents;
    }

    /**
     * Returns the list of relevant numeric fluents of the problem. The method returns null if the problem has not the
     * requirement FLUENT or NUMERIC-FLUENT.
     *
     * @returns he list of relevant numeric fluents of the problem.
     */
    public final List<NumericFluent> getRelevantNumericFluents() {
        return this.relevantNumericFluents;
    }

    /**
     * Returns the initial task network of the problem. The method returns null if the problem has not the requirement
     * HIERARCHY.
     *
     * @return the initial task network of the problem.
     */
    public final TaskNetwork getInitialTaskNetwork() {
        return this.initialTaskNetwork;
    }

    /**
     * Returns the goal of the problem in the form of a disjunction of conditions. The method returns null is the goal
     * is not reachable.
     *
     * @return the goal of the problem in the form of a disjunction of conditions.
     */
    public final List<Condition> getGoal() {
        return this.goal;
    }

    /**
     * Returns the list of instantiated actions of the problem. The precondition of the actions are in the form of
     * disjunction and the effect are in the form of conjunction.
     *
     * @return the list of instantiated actions of the problem.
     */
    public final List<Action> getActions() {
        return this.actions;
    }

    /**
     * Returns the list of instantiated methods of the problem. The precondition of the methods are in the form of
     * disjunction.
     *
     * @return the list of instantiated methods of the problem.
     */
    public final List<Method> getMethods() {
        return this.methods;
    }

    /**
     * Returns the initial state of the problem.
     *
     * @return the initial state of the problem.
     */
    public final InitialState getInitialState() {
        return this.initialState;
    }

    /**
     * Returns <code>true</code> if this problem is solvable. In the case of STRIPS planning, the method returns
     * <code>false</code> if the goal is simplified to <code>false</code> during the instantiation process, otherwise the
     * method returns <code>true</code>. In the case of HTN planning, the method returns <code>false</code> if at least
     * one of the task of the initial task network is not reachable after the encoding process, i.e., as a task is set
     * to null in the tasks list of the initial task network, otherwise the method returns <code>true</code>. Finally,
     * the method returns <code>true</code> when the problem while the problem is not instantiated.
     * <p>
     * Warning, it is not because the method returns <code>true</code> that the problem is solvable. It just means that
     * the instantiation process can not exclude the fact that the problem is solvable.
     * </p>
     *
     * @return <code>true</code> if this problem is solvable; <code>false</code>.
     */
    public final boolean isSolvable() {
        if (!this.isInstnatiated) {
            boolean isSovable = true;
            if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                Iterator<Integer> i = this.initialTaskNetwork.getTasks().iterator();
                while (i.hasNext() && isSovable) {
                    isSovable = i.next() != null;
                }
            } else {
                isSovable = this.goal != null;
            }
            return isSovable;
        }
        return true;
    }

    /**
     * Instantiate the problem.
     */
    public void instantiate(int tracelevel) {

        this.traceLevel = tracelevel;
        this.log(1);


        // Infer the type from the unary inertia
        if (!this.requirements.contains(PDDLRequireKey.TYPING)) {
            // Collect the inertia information from the actions of the problem.
            this.collectInertiaInformation();
            // Infer the type from the unary inertia
            List<Set<Integer>> inferredDomains = this.inferTypesFromInertia();
            // Update action with the inferred types
            this.updateActionWithInferredTypes(inferredDomains);
            this.log(2);
        }

        // Instantiate the actions
        this.instantiateActions();
        // Extract the ground inertia from the set of instantiated actions
        this.collectGroundInertia();
        // Simplify the actions based in the ground inertia
        this.simplyActionsWithGroundInertia();
        // Expand the quantified expression in the goal
        this.intGoal.expandQuantifiedExpression(this.typeDomains);
        // Simplify the goal with ground inertia information
        this.simplifyGoalWithGroundInertia();

        if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            // Instantiate the initial task network. Paramaters in task netwok are considered as quantified with exists
            this.instantiateInitialTaskNetwork();
            // Instantiate the methods. The instantiation process require th e
            this.instantiateMethods();
            // Simplify the methods with the ground inertia information previously extracted
            this.simplyMethodsWithGroundInertia();
        }

        this.log(3);

        // Extract the relevant fluents from the simplified and instantiated actions and methods and create the map of
        // the fluent to its index in the table of the relevant fluents.
        this.extractRelevantFluents();
        // Extract the relevant numeric fluent form the simplified and instantiated actions and methods and create the
        // map of numeric fluent to its index in the table of the relevant numeric fluents.
        this.extractRelevantNumericFluents();
        if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            // Extract the releant tasks of the problem
            this.extractRelevantTasks();
        }

        // Encode the goal using bit vector representation in DNF form
        this.finalizeGoal();
        // Encode the initial state
        this.finalizeIntitialState();
        // Encode the actions of the problem
        this.finalizeActions();
        if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            // Encode the initial task network
            this.finalizeInitialTaskNetwork();
            // Encode the methods in bit set representation
            this.finalizeMethods();
        }
        this.log(4);
        this.isInstnatiated = true;

    }


    /**
     * Initialize the requirements of the problem from a specified domain and problem.
     *
     * @param domain  the PDDL domain.
     * @param problem the PDDL problem.
     *
     */
    private void collectRequirementInformation(final PDDLDomain domain, final PDDLProblem problem) {
        this.requirements = new LinkedHashSet<>();
        this.requirements.addAll(domain.getRequirements());
        this.requirements.addAll(problem.getRequirements());

    }

    /**
     * Collects all the types symbols of a specified domain.
     *
     * @param domain the domain.
     */
    private void collectTypeInformation(final PDDLDomain domain) {
        final List<PDDLTypedSymbol> types = domain.getTypes();
        final int nbTypes = types.size();
        this.typeSymbols = new ArrayList<>(nbTypes);
        this.typeDomains = new ArrayList<>(nbTypes);
        for (PDDLTypedSymbol type : types) {
            this.typeSymbols.add(type.getImage());
            this.typeDomains.add(new LinkedHashSet<>());
        }
    }

    /**
     * Collects all the constants of the specified domain and the problem and initialize the domain of each type with
     * the constant collected.
     *
     * @param domain  the domain.
     * @param problem the problem.
     */
    private void collectConstantInformation(final PDDLDomain domain, final PDDLProblem problem) {
        final List<PDDLTypedSymbol> constants = domain.getConstants();
        this.constantSymbols = new ArrayList<>(domain.getConstants().size());
        constants.addAll(problem.getObjects());
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
                types.addAll(domain.getType(type).getTypes());
                this.typeDomains.get(it).add(ic);
            }
        }
    }

    /**
     * Collects composite types, i.e., type of the form (either t1 t2), through a specified domain and
     * problem and creates their respective domain.
     *
     * @param domain  the domain.
     * @param problem the problem.
     */
    private void collectEitherTypeInformation(final PDDLDomain domain, final PDDLProblem problem) {
        // Collect the types from the predicates declaration
        for (PDDLNamedTypedList predicate : domain.getPredicates()) {
            this.collectTypeInformation(predicate.getArguments());
        }
        // Collect the types from the functions declaration
        for (PDDLNamedTypedList function : domain.getFunctions()) {
            this.collectTypeInformation(function.getArguments());
        }
        // Collect the types from the constraints declaration of the domain
        if (domain.getConstraints() != null) {
            this.collectTypeInformation(domain.getConstraints());
        }
        // Collect the types from the derived predicates
        for (PDDLDerivedPredicate axiom : domain.getDerivesPredicates()) {
            this.collectTypeInformation(axiom.getHead().getArguments());
            this.collectTypeInformation(axiom.getBody());
        }
        // Collect the type from the actions
        for (PDDLAction action : domain.getActions()) {
            this.collectTypeInformation(action.getParameters());
            this.collectTypeInformation(action.getPreconditions());
            this.collectTypeInformation(action.getEffects());
        }
        // Collect the type from the methods
        for (PDDLMethod method: domain.getMethods()) {
            this.collectTypeInformation(method.getParameters());
            this.collectTypeInformation(method.getPreconditions());
        }
        // Collect the types from the constraints declaration of the problem
        if (problem.getConstraints() != null) {
            this.collectTypeInformation(problem.getConstraints());
        }
        // Collect the types from the goal declaration of the problem
        if (problem.getGoal() != null) {
            this.collectTypeInformation(problem.getGoal());
        }

    }

    /**
     * Collects all the type symbols from a specified expression.
     *
     * @param exp the expression.
     */
    private void collectTypeInformation(final PDDLExpression exp) {
        switch (exp.getConnective()) {
            case FORALL:
            case EXISTS:
                this.collectTypeInformation(exp.getVariables());
                this.collectTypeInformation(exp.getChildren().get(0));
                break;
            default:
                exp.getChildren().forEach(this::collectTypeInformation);
        }
    }

    /**
     * Collects all the types from a specified list of typed symbols.
     *
     * @param list the list of typed symbol.
     */
    private void collectTypeInformation(final List<PDDLTypedSymbol> list) {
        for (PDDLTypedSymbol symbol : list) {
            final List<PDDLSymbol> types = symbol.getTypes();
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
                    final Set<Integer> typeDomain = this.typeDomains.get(typeIndex);
                    newTypeDomain.addAll(typeDomain);
                }
                newType = buf.toString();
                int index = this.typeSymbols.indexOf(newType);
                if (index == -1) {
                    this.typeDomains.add(new LinkedHashSet<>(newTypeDomain));
                    this.typeSymbols.add(newType);
                }
            }
        }
    }

    /**
     * Collects all the predicates symbols of a specified domain.
     *
     * @param domain the domain.
     */
    private void collectPredicateInformation(final PDDLDomain domain) {
        final List<PDDLNamedTypedList> predicates = domain.getPredicates();
        final int nbPredicates = predicates.size();
        this.predicateSymbols = new ArrayList<>(nbPredicates);
        this.typeOfPredicateArguments = new ArrayList<>(nbPredicates);
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
            this.typeOfPredicateArguments.add(argType);
        }
    }

    /**
     * Collects all the function symbol of a specified domain.
     *
     * @param domain the domain.
     */
    private void collectFunctionInformation(final PDDLDomain domain) {
        final List<PDDLNamedTypedList> functions = domain.getFunctions();
        this.functionSymbols = new ArrayList<>(functions.size());
        this.typeOfFunctionArguments = new ArrayList<>(functions.size());
        for (PDDLNamedTypedList function : functions) {
            this.functionSymbols.add(function.getName().getImage());
            final List<PDDLTypedSymbol> arguments = function.getArguments();
            final List<Integer> argType = new ArrayList<>(arguments.size());
            for (PDDLTypedSymbol argument : arguments) {
                List<PDDLSymbol> types = argument.getTypes();
                if (types.size() > 1) {
                    final StringBuilder type = new StringBuilder("either");
                    for (PDDLSymbol type1 : types) {
                        type.append("~").append(type1.getImage());
                    }
                    argType.add(this.typeSymbols.indexOf(type.toString()));
                } else {
                    argType.add(this.typeSymbols.indexOf(types.get(0).getImage()));
                }
            }
            this.typeOfFunctionArguments.add(argType);

        }
    }

    /**
     * Collects all the tasks symbols of a specified domain.
     *
     * @param domain the domain.
     */
    private void collectTaskInformation(final PDDLDomain domain) {
        final List<PDDLNamedTypedList> tasks = domain.getTasks();
        final int nbTasks = tasks.size();
        this.taskSymbols = new ArrayList<>(nbTasks);
        this.typeOfTaskArguments = new ArrayList<>(nbTasks);
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
            this.typeOfTaskArguments.add(argType);
        }
    }

    /**
     * Collects the list of action from a specified domain.
     *
     * @param domain the domain.
     */
    private void collectActionInformation(final PDDLDomain domain) {
        this.intActions = domain.getActions().stream().map(this::finalizeAction).collect(Collectors.toList());
    }

    /**
     * Encode an action into its integer representation.
     *
     * @param action the action to encode.
     * @return encoded action.
     */
    private IntAction finalizeAction(final PDDLAction action) {
        final IntAction intAction = new IntAction(action.getName().getImage(), action.getArity());
        // Encode the parameters of the operator
        final List<String> variables = new ArrayList<>(action.getArity());
        for (int i = 0; i < action.getArity(); i++) {
            final PDDLTypedSymbol parameter = action.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.typeSymbols.indexOf(typeImage);
            intAction.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the duration of the action
        if (action.isDurative()) {
            final IntExpression duration = this.encodePDDLExpression(action.getDuration(), variables);
            intAction.setDuration(duration);
        }
        // Encode the preconditions of the operator
        final IntExpression preconditions = this.encodePDDLExpression(action.getPreconditions(), variables);
        intAction.setPreconditions(preconditions);
        // Encode the effects of the operator
        final IntExpression effects = this.encodePDDLExpression(action.getEffects(), variables);
        intAction.setEffects(effects);
        return intAction;
    }

    /**
     * Collects the information about the method of the specified domain.
     *
     * @param domain the domain.
     */
    private void collectMethodInformation(final PDDLDomain domain) {
        this.compoundTaskSymbols = new LinkedHashSet<>();
        this.intMethods = domain.getMethods().stream().map(this::encodeMethod).collect(Collectors.toList());
    }

    /**
     * Encode an method into its integer representation.
     *
     * @param method the metho to encode.
     * @return encoded method.
     */
    private IntMethod encodeMethod(final PDDLMethod method) {
        final IntMethod intMeth = new IntMethod(method.getName().getImage(), method.getArity());
        this.compoundTaskSymbols.add(method.getTask().getAtom().get(0).getImage());
        // Encode the parameters of the operator
        final List<String> variables = new ArrayList<>(method.getArity());
        for (int i = 0; i < method.getArity(); i++) {
            final PDDLTypedSymbol parameter = method.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.typeSymbols.indexOf(typeImage);
            intMeth.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the task carried out by the method
        final IntExpression task = this.encodePDDLExpression(method.getTask(), variables);
        intMeth.setTask(task);
        // Encode the preconditions of the method
        final IntExpression preconditions = this.encodePDDLExpression(method.getPreconditions(), variables);
        intMeth.setPreconditions(preconditions);
        // Encode the subtasks of the method
        final IntExpression subtasks = this.encodePDDLExpression(method.getSubTasks(), variables);
        intMeth.setSubTasks(subtasks);
        // Encode the ordering constraints of the method
        IntExpression orderingConstraints = null;
        // Express the total ordering into explicites constraints
        if (method.isTotallyOrdered() && subtasks.getChildren().size() > 1) {
            orderingConstraints = new IntExpression(PDDLConnective.AND);
            for (int i = 0; i < subtasks.getChildren().size() - 1; i++) {
                final IntExpression constraint = new IntExpression(PDDLConnective.LESS_ORDERING_CONSTRAINT);
                final IntExpression t1 = new IntExpression(PDDLConnective.TASK);
                t1.setTaskID(new Integer(i));
                constraint.addChild(t1);
                final IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                t2.setTaskID(new Integer(i + 1));
                constraint.addChild(t2);
                orderingConstraints.addChild(constraint);
            }
        } else {
            final int size = subtasks.getChildren().size();
            final OrderingConstraintSet constraints = new OrderingConstraintSet(size);
            orderingConstraints = this.encodeOrderingConstraints(method.getOrderingConstraints());
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
                    t1.setTaskID(new Integer(i));
                    constraint.addChild(t1);
                    final IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                    t2.setTaskID(new Integer(i + 1));
                    constraint.addChild(t2);
                    orderingConstraints.addChild(constraint);
                }
            }
        }
        intMeth.setOrderingConstraints(orderingConstraints);
        return intMeth;
    }

    /**
     * Encode the ordering constraints of method. The index used to encode a task in the ordering constraints
     * expression returned is the index of the task in the AND expression of the tasks list of a method.
     *
     * @param exp the constraints to encode. The constraints must be an AND expression.
     * @throws UnexpectedExpressionException if the exp in parameter is unexpected. Only AND and
     *      LESS_ORDERING_CONSTRAINTS are expected.
     */
    private IntExpression encodeOrderingConstraints(final PDDLExpression exp) {
        final IntExpression intExp = new IntExpression(exp.getConnective());
        switch (exp.getConnective()) {
            case AND:
                for (int i = 0; i < exp.getChildren().size(); i++) {
                    intExp.addChild(this.encodeOrderingConstraints(exp.getChildren().get(i)));
                }
                break;
            case LESS_ORDERING_CONSTRAINT:
                IntExpression t1 = new IntExpression(PDDLConnective.TASK);
                t1.setTaskID(new Integer(exp.getAtom().get(0).getImage().substring(1)));
                intExp.addChild(t1);
                IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                t2.setTaskID(new Integer(exp.getAtom().get(1).getImage().substring(1)));
                intExp.addChild(t2);
                break;
            default:
                throw new UnexpectedExpressionException("Expression " + exp.getConnective() + " is unexpected.");
        }
        return intExp;
    }

    /**
     * Encodes an specified expression into its integer representation.
     *
     * @param exp the expression to encode.
     * @return the integer representation of the specified expression.
     */
    private IntExpression encodePDDLExpression(final PDDLExpression exp) {
        return this.encodePDDLExpression(exp, new ArrayList<>());
    }

    /**
     * Encodes an specified expression into its integer representation.
     *
     * <p>Notes:
     * <ul>
     * <li>equal predicate used specified value of -1.</li>
     * <li>variables used negative values in [-1,-infinity[.</li>
     * </ul>
     * </p>
     *
     * @param exp       the expression to encode.
     * @param variables the list of variable already encoded.
     * @return the integer representation of the specified expression.
     */
    private IntExpression encodePDDLExpression(final PDDLExpression exp, final List<String> variables) {
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
                        args[i] = this.constantSymbols.indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case FN_HEAD:
                final String functor = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.functionSymbols.indexOf(functor));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.constantSymbols.indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case ATOM:
                final String predicate = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.predicateSymbols.indexOf(predicate));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.constantSymbols.indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case TASK:
                final String task = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.taskSymbols.indexOf(task));
                intExp.setPrimtive(this.primitiveTaskSymbols.contains(task));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.constantSymbols.indexOf(argument.getImage());
                    }
                }
                if (exp.getTaskID() != null) { // TaskID is null the task carried out by a method is encoded
                    intExp.setTaskID(new Integer(exp.getTaskID().getImage().substring(1)));
                }
                intExp.setArguments(args);
                break;
            case AND:
            case OR:
                for (int i = 0; i < exp.getChildren().size(); i++) {
                    intExp.getChildren().add(this.encodePDDLExpression(exp.getChildren().get(i), variables));
                }
                break;
            case FORALL:
            case EXISTS:
                final List<String> newVariables = new ArrayList<>(variables);
                final List<PDDLTypedSymbol> qvar = exp.getVariables();
                final String type = this.toStringType(qvar.get(0).getTypes());
                int typeIndex = this.typeSymbols.indexOf(type);
                intExp.setType(typeIndex);
                intExp.setVariable(-variables.size() - 1);
                newVariables.add(qvar.get(0).getImage());
                if (qvar.size() == 1) {
                    intExp.getChildren().add(this.encodePDDLExpression(exp.getChildren().get(0), newVariables));
                } else {
                    qvar.remove(0);
                    intExp.getChildren().add(this.encodePDDLExpression(exp, newVariables));
                }
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    intExp.getChildren().add(this.encodePDDLExpression(exp.getChildren().get(0), variables));
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
                intExp.getChildren().add(this.encodePDDLExpression(exp.getChildren().get(0), variables));
                intExp.getChildren().add(this.encodePDDLExpression(exp.getChildren().get(1), variables));
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
                intExp.getChildren().add(this.encodePDDLExpression(exp.getChildren().get(0), variables));
                break;
            case NUMBER:
                intExp.setValue(exp.getValue());
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                intExp.getChildren().add(this.encodePDDLExpression(exp.getChildren().get(0), variables));
                intExp.getChildren().add(this.encodePDDLExpression(exp.getChildren().get(1), variables));
                intExp.getChildren().add(this.encodePDDLExpression(exp.getChildren().get(2), variables));
                break;
            case TIME_VAR:
            case IS_VIOLATED:
                // Do nothing
                break;
            default:
                // do nothing
        }
        return intExp;
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

    /**
     * Initialize the list of primitive task symbols used in the domain.
     */
    private void collectPrimitiveTaskInformation() {
        this.primitiveTaskSymbols = new LinkedHashSet<>();
        for (IntAction action : this.intActions) {
            this.primitiveTaskSymbols.add(action.getName());
        }
    }

    /**
     * Collects information about the initial state.
     *
     * @param problem the problem
     */
    private void collectInitialStateInformation(PDDLProblem problem) {
        this.intInitialState = problem.getInit().stream().map(this::encodePDDLExpression)
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Collects information about the goal of the problem.
     *
     * @param problem the problem
     */
    private void collectGoalInformation(final PDDLProblem problem) {
        if (problem.getGoal() != null) {
            this.intGoal = this.encodePDDLExpression(problem.getGoal());
        } else {
            this.intGoal = new IntExpression(PDDLConnective.OR);
        }
    }
    /**
     * Collects the information about the task network of a specified problem.
     *
     * @param problem the problem.
     */
    private void collectInitialTaskNetworkInformation(final PDDLProblem problem) {
        // Encode the parameters of the task network
        final PDDLTaskNetwork taskNetwork = problem.getInitialTaskNetwork();
        final int numberOfParameters = problem.getInitialTaskNetwork().getParameters().size();
        this.intInitialTaskNetwork = new IntTaskNetwork(numberOfParameters);
        final List<String> variables = new ArrayList<>(numberOfParameters);
        for (int i = 0; i < numberOfParameters; i++) {
            final PDDLTypedSymbol parameter = taskNetwork.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.typeSymbols.indexOf(typeImage);
            this.intInitialTaskNetwork.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the tasks of the task network
        this.intInitialTaskNetwork.setTasks(this.encodePDDLExpression(taskNetwork.getTasks(), variables));
        // Encode the ordering constraints of the task network
        IntExpression orderingConstraints = null;
        IntExpression subtasks = this.intInitialTaskNetwork.getTasks();
        if (taskNetwork.isTotallyOrdered() && subtasks.getChildren().size() > 1) {
            orderingConstraints = new IntExpression(PDDLConnective.AND);
            for (int i = 0; i < subtasks.getChildren().size() - 1; i++) {
                final IntExpression constraint = new IntExpression(PDDLConnective.LESS_ORDERING_CONSTRAINT);
                final IntExpression t1 = new IntExpression(PDDLConnective.TASK);
                t1.setTaskID(new Integer(i));
                constraint.addChild(t1);
                final IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                t2.setTaskID(new Integer(i + 1));
                constraint.addChild(t2);
                orderingConstraints.addChild(constraint);
            }
        } else {
            final int size = subtasks.getChildren().size();
            final OrderingConstraintSet constraints = new OrderingConstraintSet(size);
            orderingConstraints = this.encodeOrderingConstraints(taskNetwork.getOrderingConstraints());
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
                    t1.setTaskID(new Integer(i));
                    constraint.addChild(t1);
                    final IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                    t2.setTaskID(new Integer(i + 1));
                    constraint.addChild(t2);
                    orderingConstraints.addChild(constraint);
                }
            }
        }
        this.intInitialTaskNetwork.setOrderingConstraints(orderingConstraints);
    }

    /******************************************************************************************************************/
    /* Methods to deal with inertia
    */

    /**
     * This method proceeds over the actions of the domain and checks for all atom which kind of
     * inertia it is. For each atom it checks if it satisfies one of the following definitions:
     * <p>
     * <i>Definition:</i> A relation is a positive inertia iff it does not occur positively in an
     * unconditional effect or the consequent of a conditional effect of an action.
     * </p>
     * <p>
     * <i>Definition:</i> A relation is a negative inertia iff it does not occur negatively in an
     * unconditional effect or the consequent of a conditional effect of an action.
     * </p>
     * <p>
     * Relations, which are positive as well as negative inertia, are simply called inertia.
     * Relations, which are neither positive nor negative inertia, are called fluents. The detection
     * of inertia and fluents is easy because in ADL, effects are restricted to conjunctions of
     * literals. Furthermore, this information can be obtained with a single pass over the domain
     * description, which takes almost no time at all.
     * </p>
     * <p>
     * Note: before calling this method the domain must be encode into integer and the negation must
     * be move inward the expression.
     * </p>
     *
     */
    private void collectInertiaInformation() {
        final int nbPredicates = this.predicateSymbols.size();
        this.inertia = new ArrayList<>(nbPredicates);
        for (int i = 0; i < nbPredicates; i++) {
            this.inertia.add(Inertia.INERTIA);
        }
        for (final IntAction action : this.intActions) {
            this.collectInertiaInformation(action.getEffects());
        }

    }

    /**
     * Do a pass over the effects of an action and update initialize the inertia of the problem.
     *
     * @param exp the effect.
     */
    private void collectInertiaInformation(final IntExpression exp) {
        switch (exp.getConnective()) {
            case ATOM:
                int predicate = exp.getPredicate();
                switch (this.inertia.get(predicate)) {
                    case INERTIA:
                        this.inertia.set(predicate, Inertia.NEGATIVE);
                        break;
                    case POSITIVE:
                        this.inertia.set(predicate, Inertia.FLUENT);
                        break;
                    default:
                        // do nothing
                }
                break;
            case AND:
            case OR:
                exp.getChildren().forEach(this::collectInertiaInformation);
                break;
            case FORALL:
            case EXISTS:
                this.collectInertiaInformation(exp.getChildren().get(0));
                break;
            case WHEN:
                this.collectInertiaInformation(exp.getChildren().get(1));
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                if (neg.getConnective().equals(PDDLConnective.ATOM)) {
                    predicate = neg.getPredicate();
                    switch (this.inertia.get(predicate)) {
                        case INERTIA:
                            this.inertia.set(predicate, Inertia.POSITIVE);
                            break;
                        case NEGATIVE:
                            this.inertia.set(predicate, Inertia.FLUENT);
                            break;
                        default:
                            // do nothing
                    }
                }
                break;
            default:
                // do nothing
        }
    }

    /**
     * Do a pass over the effects of a specified list of instantiated actions and update the ground
     * inertia table.
     *
     */
    private void collectGroundInertia() {
        this.groundInertia = new LinkedHashMap<>(Constants.DEFAULT_RELEVANT_FACTS_TABLE_SIZE);
        for (IntAction a : this.intActions) {
            this.collectGroundInertia(a.getEffects());
        }
    }

    /**
     * Do a pass over the effects of an instantiated action and update the ground inertia table.
     *
     * @param exp the effect.
     */
    private void collectGroundInertia(final IntExpression exp) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = this.groundInertia.get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                switch (inertia) {
                    case INERTIA:
                        this.groundInertia.put(exp, Inertia.NEGATIVE);
                        break;
                    case POSITIVE:
                        this.groundInertia.put(exp, Inertia.FLUENT);
                        break;
                    default:
                        // do nothing
                }
                break;
            case AND:
            case OR:
                exp.getChildren().forEach(this::collectGroundInertia);
                break;
            case FORALL:
            case EXISTS:
                this.collectGroundInertia(exp.getChildren().get(0));
                break;
            case WHEN:
                this.collectGroundInertia(exp.getChildren().get(1));
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                if (neg.getConnective().equals(PDDLConnective.ATOM)) {
                    inertia = this.groundInertia.get(neg);
                    if (inertia == null) {
                        inertia = Inertia.INERTIA;
                    }
                    switch (inertia) {
                        case INERTIA:
                            this.groundInertia.put(neg, Inertia.POSITIVE);
                            break;
                        case NEGATIVE:
                            this.groundInertia.put(neg, Inertia.FLUENT);
                            break;
                        default:
                            // do nothing
                    }
                }
                break;
            default:
                // do nothing
        }
    }

    /**
     * Do a pass over the preconditions and the effects of all the instantiated actions and update the ground inertia
     * table. Then, simplify the actions according to the extracted ground inertia.
     *
     */
    private void simplyActionsWithGroundInertia() {

        final List<IntAction> toAdd = new ArrayList<>(this.intActions.size());
        final Set<Integer> toRemove = new HashSet<>(this.intActions.size());
        int index = 0;
        for (IntAction a : this.intActions) {
            this.simplifyWithGroundInertia(a.getPreconditions(), false);
            a.getPreconditions().simplify();
            if (!a.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                this.simplifyWithGroundInertia(a.getEffects(), true);
                a.getEffects().simplify();
                if (!a.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                    toAdd.add(a);
                } else {
                    toRemove.add(index);
                }
            } else {
                toRemove.add(index);
            }
            index++;
        }

        this.intActions.clear();
        this.intActions.addAll(toAdd);
    }


    /**
     * Simplify a specified goal expression based on the ground inertia information.
     **/
    private void simplifyGoalWithGroundInertia() {
        this.simplifyWithGroundInertia(this.intGoal, false);
        this.intGoal.simplify();
    }

    /**
     * Simplify a specified expression based on the ground inertia information.
     * <p>
     * <i>Definition:</i> A ground fact is a positive ground inertia iff it does not occur positively in
     * an unconditional effect or the consequent of a conditional effect of an action.
     * </p>
     * <p>
     * <i>Definition:</i> A ground fact is a negative ground inertia iff it does not occur negatively in
     * an unconditional effect or the consequent of a conditional effect of an action.
     * </p>
     * An initial fact, which is a negative ground inertia, is never made FALSE and thus always
     * satisfied in all reachable world states. It can be removed from the state description. All
     * its occurrences in the preconditions of actions and in the antecedents of conditional effects
     * can be simplified to TRUE. A fact, which is a positive ground inertia and not contained in
     * the initial state, is never satisfied in any reachable world state. All its occurrences in
     * the preconditions of actions and in the antecedents of conditional effects can be simplified
     * to FALSE. The remaining facts are fluents that, roughly speaking, can possibly change their
     * truth value during the planning process. They are therefore relevant to the representation of
     * the planning problem.
     *
     * @param exp    the expression to simply.
     * @param effect a boolean to indicate if the expression is an effect or a precondition.
     */
    private void simplifyWithGroundInertia(final IntExpression exp, final boolean effect) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = this.groundInertia.get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                // An initial fact, which is a negative ground inertia, is never made FALSE and thus
                // always satisfied in all reachable world states. All its occurrences in the
                // preconditions of actions and in the
                // antecedents of conditional effects can be simplified to TRUE.
                if (!effect && (inertia.equals(Inertia.INERTIA) || inertia.equals(Inertia.NEGATIVE))
                    && this.intInitialState.contains(exp)) {
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (!effect
                    && (inertia.equals(Inertia.INERTIA) || inertia.equals(Inertia.POSITIVE))
                    && !this.intInitialState.contains(exp)) {
                    // If the antecedent of a conditional effect becomes TRUE, the conditional
                    // effect
                    // becomes unconditional.
                    exp.setConnective(PDDLConnective.FALSE);
                }
                break;
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    this.simplifyWithGroundInertia(ei, effect);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    }
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    this.simplifyWithGroundInertia(ei, effect);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case UMINUS:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
                this.simplifyWithGroundInertia(exp.getChildren().get(0), effect);
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                this.simplifyWithGroundInertia(neg, effect);
                if (!effect) {
                    if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case WHEN:
                this.simplifyWithGroundInertia(exp.getChildren().get(0), false);
                this.simplifyWithGroundInertia(exp.getChildren().get(1), true);
                break;
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
                this.simplifyWithGroundInertia(exp.getChildren().get(0), effect);
                this.simplifyWithGroundInertia(exp.getChildren().get(1), effect);
                break;
            case F_EXP:
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    this.simplifyWithGroundInertia(exp.getChildren().get(0), effect);
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.simplifyWithGroundInertia(exp.getChildren().get(0), effect);
                this.simplifyWithGroundInertia(exp.getChildren().get(1), effect);
                this.simplifyWithGroundInertia(exp.getChildren().get(3), effect);
                break;
            case NUMBER:
            case DURATION_ATOM:
            case TIME_VAR:
            case IS_VIOLATED:
            case MINIMIZE:
            case MAXIMIZE:
            case FN_HEAD:
            case EQUAL_ATOM:
                break;
            default:
                // do nothing
        }
    }

    /******************************************************************************************************************/
    /* Methods to deal with the type inference from inertia
    */

    /**
     * Infer type from unary inertia.
     *
     */
    private List<Set<Integer>> inferTypesFromInertia() {
        List<Set<Integer>> inferredDomains = new ArrayList<>(this.predicateSymbols.size());
        for (int i = 0; i < this.predicateSymbols.size(); i++) {
            final Set<Integer> newTypeDomain = new LinkedHashSet<>();
            if (this.typeOfPredicateArguments.get(i).size() == 1
                && this.inertia.get(i).equals(Inertia.INERTIA)) {
                for (IntExpression fluent : this.intInitialState) {
                    if (fluent.getConnective().equals(PDDLConnective.NOT)) {
                        fluent = fluent.getChildren().get(0);
                    }
                    if (fluent.getPredicate() == i) {
                        newTypeDomain.add(fluent.getArguments()[0]);
                    }
                }
            }
            inferredDomains.add(newTypeDomain);
        }
        return inferredDomains;
    }

    /**
     * Update the actions with the inferred types and update the type symbol of the problem and their domain.
     *
     * @param domains the domains of type inferred.
     * @return the list of simplified actions.
     */
    private void updateActionWithInferredTypes(List<Set<Integer>> domains) {
        final List<IntAction> actions = new LinkedList<>();
        for (final IntAction action : this.intActions) {
            actions.addAll(this.updateActionWithInferredTypes(action, domains));
        }
        this.intActions.clear();
        this.intActions.addAll(actions);
    }

    private List<IntAction> updateActionWithInferredTypes(final IntAction action, List<Set<Integer>> domains) {
        final List<IntExpression> unaryInertia = new ArrayList<>();
        unaryInertia.addAll(this.collectUnaryInertia(action.getPreconditions(), domains));
        unaryInertia.addAll(this.collectUnaryInertia(action.getEffects(), domains));

        List<IntAction> actions = new LinkedList<>();
        actions.add(action);

        if (action.arity() == 0) {
            return actions;
        }

        for (final IntExpression inertia : unaryInertia) {
            final List<IntAction> newActions = new ArrayList<>();
            for (final IntAction o : actions) {
                if (o.arity() > 0) {

                    int index = -inertia.getArguments()[0] - 1;
                    // Hack add for constant in predicate
                    //if (index < 0) {
                    //    break;
                    //}

                    final int dtIndex = action.getTypeOfParameters(index);

                    final String declaredType = this.typeSymbols.get(dtIndex);
                    final int itIndex = inertia.getPredicate();
                    final String inertiaType = this.predicateSymbols.get(itIndex);

                    final String sti = declaredType + "^" + inertiaType;
                    int ti = this.typeSymbols.indexOf(sti);
                    if (ti == -1) {
                        ti = this.typeSymbols.size();
                        this.typeSymbols.add(sti);
                        final Set<Integer> dt1 = new LinkedHashSet<>(this.typeDomains.get(dtIndex));
                        dt1.retainAll(domains.get(itIndex));
                        this.typeDomains.add(dt1);
                    }

                    final String sts = declaredType + "\\" + inertiaType;
                    int ts = this.typeSymbols.indexOf(sts);
                    if (ts == -1) {
                        ts = this.typeSymbols.size();
                        this.typeSymbols.add(sts);
                        final Set<Integer> dt2 = new LinkedHashSet<>(this.typeDomains.get(dtIndex));
                        dt2.removeAll(domains.get(itIndex));
                        this.typeDomains.add(dt2);
                    }
                    final IntAction op1 = new IntAction(o);
                    op1.setTypeOfParameter(index, ti);
                    this.replace(op1.getPreconditions(), inertia, PDDLConnective.TRUE, ti, ts);
                    this.replace(op1.getEffects(), inertia, PDDLConnective.TRUE, ti, ts);
                    if (!op1.getPreconditions().getConnective().equals(PDDLConnective.FALSE)
                        && !op1.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                        newActions.add(op1);
                    }

                    final IntAction op2 = new IntAction(o);
                    op2.setTypeOfParameter(index, ts);
                    this.replace(op2.getPreconditions(), inertia, PDDLConnective.FALSE, ti, ts);
                    this.replace(op2.getEffects(), inertia, PDDLConnective.FALSE, ti, ts);

                    if (!op2.getPreconditions().getConnective().equals(PDDLConnective.FALSE)
                        && !op2.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                        newActions.add(op2);
                    }
                }
            }
            actions.clear();
            actions.addAll(newActions);
        }
        return actions;
    }

    /**
     * Replace all the occurrences of a specified unary inertia contained in the a specified
     * expression by <code>TRUE</code> or <code>FALSE</code>.
     *
     * @param exp        the expression.
     * @param inertia    the unary inertia.
     * @param connective the connective.
     * @param ti         the type intersection.
     * @param ts         the type substract.
     */
    private void replace(final IntExpression exp, final IntExpression inertia, final PDDLConnective connective,
                         final int ti, final int ts) {
        switch (exp.getConnective()) {
            case ATOM:
                if (exp.equals(inertia)) {
                    exp.setConnective(connective);
                }
                break;
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    this.replace(ei, inertia, connective, ti, ts);
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(PDDLConnective.TRUE);
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    this.replace(ei, inertia, connective, ti, ts);
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    } else if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        i.remove();
                    }
                }
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(PDDLConnective.FALSE);
                }
                break;
            case FORALL:
            case EXISTS:
                if (inertia.getArguments()[0] == exp.getVariable()) {
                    final IntExpression ei = new IntExpression(exp);
                    ei.setType(ti);
                    this.replace(ei, inertia, PDDLConnective.TRUE, ti, ts);
                    final IntExpression es = new IntExpression(exp);
                    es.setType(ts);
                    this.replace(es, inertia, PDDLConnective.FALSE, ti, ts);
                    exp.getChildren().clear();
                    if (exp.getConnective().equals(PDDLConnective.FORALL)) {
                        exp.setConnective(PDDLConnective.AND);
                    } else {
                        exp.setConnective(PDDLConnective.OR);
                    }
                    exp.getChildren().add(ei);
                    exp.getChildren().add(es);
                } else {
                    this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                }
                break;
            case NOT:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                if (exp.getChildren().get(0).getConnective().equals(PDDLConnective.TRUE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                } else {
                    exp.setConnective(PDDLConnective.TRUE);
                }
                break;
            case AT_START:
            case AT_END:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case WHEN:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.replace(exp.getChildren().get(0), inertia, connective, ti, ts);
                this.replace(exp.getChildren().get(1), inertia, connective, ti, ts);
                this.replace(exp.getChildren().get(3), inertia, connective, ti, ts);
                break;
            case EQUAL_ATOM:
            case FN_HEAD:
            case FN_ATOM:
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
            case F_EXP_T:
            case NUMBER:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case F_EXP:
            case TIME_VAR:
            case IS_VIOLATED:
                // do nothing
                break;
            default:
                // do nothing
        }
    }

    /**
     * Collect all unary inertia from a specified expression.
     *
     * @param exp the expression.
     * @param domains the domains of the inferred type.
     * @return the list of unary inertia expression collected.
     */
    private List<IntExpression> collectUnaryInertia(final IntExpression exp, List<Set<Integer>> domains) {
        final List<IntExpression> unaryInertia = new ArrayList<>();
        switch (exp.getConnective()) {
            case ATOM:
                if (domains.get(exp.getPredicate()) != null) {
                    unaryInertia.add(exp);
                }
                break;
            case AND:
            case OR:
                for (final IntExpression ei : exp.getChildren()) {
                    unaryInertia.addAll(this.collectUnaryInertia(ei, domains));
                }
                break;
            case FORALL:
            case EXISTS:
                final IntExpression qExp = exp.getChildren().get(0);
                unaryInertia.addAll(this.collectUnaryInertia(qExp, domains));
                break;
            case AT_START:
            case AT_END:
            case NOT:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case WHEN:
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(0), domains));
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(0), domains));
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(1), domains));
                unaryInertia.addAll(this.collectUnaryInertia(exp.getChildren().get(3), domains));
                break;
            case EQUAL_ATOM:
            case FN_HEAD:
            case FN_ATOM:
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
            case F_EXP_T:
            case NUMBER:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case F_EXP:
            case TIME_VAR:
            case IS_VIOLATED:
                // do nothing
                break;
            default:
                // do nothing
        }
        return unaryInertia;
    }

    /******************************************************************************************************************/
    /* Methods for the instantiation of the actions
    */

    /**
     * Instantiates the actions of the problem..
     */
    private void instantiateActions() {
        final List<IntAction> instActions = new ArrayList<>(Constants.DEFAULT_ACTION_TABLE_SIZE);
        for (IntAction action : this.intActions) {
            // If an action has a parameter with a empty domain the action must be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < action.arity() && toInstantiate) {
                toInstantiate = !this.typeDomains.get(action.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (toInstantiate) {
                instActions.addAll(this.instantiate(action));
            }
        }
        this.intActions.clear();
        this.intActions.addAll(instActions);
    }

    /**
     * Instantiates a specified action.
     *
     * @param action the action to instantiate.
     * @param bound  the bound of actions to instantiate.
     * @return the list of actions instantiated corresponding the specified action.
     */
    private List<IntAction> instantiate(final IntAction action, final int bound) {
        final List<IntAction> instAction = new ArrayList<>(100);
        action.getPreconditions().expandQuantifiedExpression(this.typeDomains);
        action.getPreconditions().simplify();
        if (!action.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
            action.getEffects().expandQuantifiedExpression(this.typeDomains);
            action.getEffects().simplify();
            if (!action.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                this.instantiate(action, 0, bound, instAction);
            }
        }
        return instAction;
    }

    /**
     * Instantiates a specified action.
     *
     * @param action the action to instantiate.
     * @return the list of actions instantiated corresponding the specified action.
     */
    private List<IntAction> instantiate(final IntAction action) {
        return this.instantiate(action, Integer.MAX_VALUE);
    }


    /**
     * Instantiates a specified action.
     * <p>
     * The assumption is made that different action parameters are instantiated with different
     * constants, i.e., the planner never generates actions like move(a,a) because we consider this
     * as a bad domain representation that should be revised. In fact, in actions with identical
     * constant parameters, all but one of the constants are superfluous and can be skipped from the
     * representation without loss of information. Warning this assumption make the process no-sound.
     * </p>
     *
     * @param action  the action.
     * @param index   the index of the parameter to instantiate.
     * @param bound   the bound of actions to instantiate.
     * @param actions the list of actions already instantiated.
     * @see IntAction
     */
    private void instantiate(final IntAction action, final int index, final int bound,
                             final List<IntAction> actions) {
        if (bound == actions.size()) {
            return;
        }
        final int arity = action.arity();
        if (index == arity) {
            final IntExpression precond = action.getPreconditions();
            precond.simplify();

            if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                final IntExpression effect = action.getEffects();
                effect.simplify();
                if (!effect.getConnective().equals(PDDLConnective.FALSE)) {
                    if (action.isDurative()) {
                        action.getDuration().toCNF();
                    }
                    actions.add(action);
                }
            }
        } else {
            final Set<Integer> values = this.typeDomains.get(action.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntExpression precond = new IntExpression(action.getPreconditions());
                precond.substitute(varIndex, value);
                if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntExpression effects = new IntExpression(action.getEffects());
                    effects.substitute(varIndex, value);
                    if (!effects.getConnective().equals(PDDLConnective.FALSE)) {
                        final IntAction copy = new IntAction(action.getName(), arity);
                        copy.setPreconditions(precond);
                        copy.setEffects(effects);
                        for (int i = 0; i < arity; i++) {
                            copy.setTypeOfParameter(i, action.getTypeOfParameters(i));
                        }
                        for (int i = 0; i < index; i++) {
                            copy.setValueOfParameter(i, action.getValueOfParameter(i));
                        }
                        if (action.isDurative()) {
                            final IntExpression duration = new IntExpression(action.getDuration());
                            duration.substitute(varIndex, value);
                            copy.setDuration(duration);
                        }
                        copy.setValueOfParameter(index, value);
                        this.instantiate(copy, index + 1, bound, actions);
                    }
                }
            }
        }
    }

    /**
     * Instantiates a specified task network.
     */
    private void instantiateInitialTaskNetwork() {
        final List<IntTaskNetwork> instNetwork = new ArrayList<>(100);
        this.instantiate(this.intInitialTaskNetwork, 0, instNetwork);

        if (instNetwork.size() > 1) {
            IntExpression root = new IntExpression(PDDLConnective.TASK);
            root.setPredicate(this.taskSymbols.size());
            this.taskSymbols.add("__top");
            this.compoundTaskSymbols.add("__top");
            root.setPrimtive(false);
            int index = 0;
            for (IntTaskNetwork tn : instNetwork) {
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
                intMethods.add(method);
                index++;
            }

            // Creates the abstract initial task network
            this.intInitialTaskNetwork = new IntTaskNetwork();
            this.intInitialTaskNetwork.getTasks().addChild(new IntExpression(root));
        } else {
            this.intInitialTaskNetwork = instNetwork.get(0);
        }
    }


    /******************************************************************************************************************/
    /* Methods to instantiate the methods
    */

    /**
     * Instantiates a specified task network.
     *
     * @param network  the action.
     * @param index   the index of the parameter to instantiate.
     * @param networks the list of tasknetwork already instantiated.
     * @see IntAction
     */
    private void instantiate(final IntTaskNetwork network, final int index, final List<IntTaskNetwork> networks) {

        final int arity = network.arity();
        if (index == arity) {
            networks.add(network);
        } else {
            final Set<Integer> values = this.typeDomains.get(network.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntTaskNetwork copy = new IntTaskNetwork(arity);
                copy.setOrderingConstraints(new IntExpression(network.getOrderingConstraints()));

                final IntExpression tasksCopy = new IntExpression(network.getTasks());
                tasksCopy.substitute(varIndex, value);
                copy.setTasks(tasksCopy);

                for (int i = 0; i < arity; i++) {
                    copy.setTypeOfParameter(i, network.getTypeOfParameters(i));
                }
                for (int i = 0; i < arity; i++) {
                    copy.setValueOfParameter(i, network.getValueOfParameter(i));
                }
                copy.setValueOfParameter(index, value);
                this.instantiate(copy, index + 1, networks);
            }
        }
    }

    /**
     * Make the instantiation of a list of methods.
     */
    private void instantiateMethods() {

        // Init the list of instantiated methods or ground methods
        final List<IntMethod> instMethods = new ArrayList<>(Constants.DEFAULT_METHOD_TABLE_SIZE);

        // Init the set used to store the compound tasks
        final Set<IntExpression> compound = new LinkedHashSet<>();

        // Init the set used to store the primtive tasks
        final Set<IntExpression> primtive = new LinkedHashSet<>();

        // Init the table used to store for each task the list of methods that are relevant
        this.compundTaskResolvers = new ArrayList<List<Integer>>();

        // Init the list of methods to instantiate
        List<IntMethod> meths = new ArrayList<>();
        for (IntMethod m : this.intMethods) {
            // If a method has a parameter with a empty domain the method must be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < m.arity() && toInstantiate) {
                toInstantiate = !this.typeDomains.get(m.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (toInstantiate) {
                meths.add(m);
            }
        }

        // Expand the quantified expression contains in the the method precondition
        this.expandQuantifiedExpressionAndSimplyMethods(meths);

        // Compute the set of primitive task from the action already instantiated
        LinkedHashSet<IntExpression> primitiveTaskSet = this.computePrimitiveTaskSet();

        // TInit the list of pending tasks to decompose
        final LinkedList<IntExpression> tasks = new LinkedList<>();

        // Add the task of the initial task network with the compound tasks
        for (IntExpression subtasks : this.intInitialTaskNetwork.getTasks().getChildren()) {
            if (!tasks.contains(subtasks)) {
                if (!subtasks.isPrimtive()) {
                    tasks.add(subtasks);
                    compound.add(subtasks);
                } else {
                    primtive.add(subtasks);
                }
            }
        }

        // Start exploring the task tree
        int indexMethod = 0;
        while (!tasks.isEmpty()) {
            final IntExpression task = tasks.pop();
            final List<IntMethod> relevant = new ArrayList<>();
            final List<Integer> relevantIndex = new ArrayList<>();
            for (IntMethod method : meths) {
                if (method.getTask().getPredicate() == task.getPredicate()
                    && method.getTask().getArguments().length == task.getArguments().length) {
                    final List<IntMethod> instantiated = new ArrayList<>(100);
                    this.instantiate(method, 0, Integer.MAX_VALUE, instantiated, task);
                    for (IntMethod instance : instantiated) {
                        final Iterator<IntExpression> i = instance.getSubTasks().getChildren().iterator();
                        final Set<IntExpression> primitiveSet = new LinkedHashSet<>();
                        final Set<IntExpression> compoundSet = new LinkedHashSet<>();
                        boolean stop = false;
                        while (i.hasNext() && !stop) {
                            final IntExpression subtask = i.next();
                            if (subtask.isPrimtive()) {
                                if (!primitiveTaskSet.contains(subtask)) {
                                    stop = true;
                                } else {
                                    primitiveSet.add(subtask);
                                }
                            } else {
                                if (!compound.contains(subtask)) {
                                    compoundSet.add(subtask);
                                }
                            }
                        }
                        if (!stop) {
                            primtive.addAll(primitiveSet);
                            tasks.addAll(compoundSet);
                            compound.addAll(compoundSet);
                            relevant.add(instance);
                            relevantIndex.add(indexMethod);
                            indexMethod++;
                        }
                    }
                }
            }

            this.compundTaskResolvers.add(relevantIndex);
            instMethods.addAll(relevant);
        }

        // Initialize the table of relevant methods for each compund task and the table of relevant compound tasks
        this.relevantCompundTasks = new ArrayList<>(compound.size());
        this.relevantCompundTasks.addAll(compound);

        // Initialize the table of relevant actions for each primitive task and the table of relevant primitive tasks
        this.primtiveTaskResolvers = new ArrayList<List<Integer>>(primitiveTaskSet.size());
        this.relevantPrimitiveTasks = new ArrayList<>(primitiveTaskSet.size());
        int index = 0;
        Iterator<IntExpression> i = primitiveTaskSet.iterator();
        while (i.hasNext()) {
            // The action at index i can be remove because it not reachable from the initial task network.
            IntExpression primitiveTask = i.next();
            if (!primtive.contains(primitiveTask)) {
                this.intActions.remove(index);
                i.remove();
            } else {
                final List<Integer> relevantList = new ArrayList<>();
                relevantList.add(index);
                this.primtiveTaskResolvers.add(relevantList);
                this.relevantPrimitiveTasks.add(primitiveTask);
                index++;
            }
        }
        this.intMethods.clear();
        this.intMethods.addAll(instMethods);
    }

    /**
     * Expands the quantified expression contained in the preconditions of the methods in parameter and simplify the
     * their precondition. If the preconditions can be simplied to false, the method simplified is removed.
     *
     * @param methods the list of methods to process.
     */
    private void expandQuantifiedExpressionAndSimplyMethods(List<IntMethod> methods) {
        final Iterator<IntMethod> i = methods.iterator();
        while (i.hasNext()) {
            final IntMethod method = i.next();
            method.getPreconditions().expandQuantifiedExpression(this.typeDomains);
            method.getPreconditions().simplify();
            if (method.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                i.remove();
            }
        }
    }

    /**
     * Computes the list of possible primitive tasks from the action already instantiated.
     *
     * @return the list of possible primitive tasks from the action already instantiated.
     */
    private LinkedHashSet<IntExpression> computePrimitiveTaskSet() {
        LinkedHashSet<IntExpression> tasks = new LinkedHashSet<>();
        for (IntAction action : this.intActions) {
            IntExpression task = new IntExpression(PDDLConnective.TASK);
            task.setPrimtive(true);
            task.setPredicate(this.taskSymbols.indexOf(action.getName()));
            task.setArguments(action.getInstantiations());
            tasks.add(task);
        }
        return tasks;

    }

    /**
     * Make the preinstantion of a method based on the argument used in the tasks accomplish by the method.
     *
     * @param method the method to instantiate.
     * @param index  the index of the parameter to instantiate. Initially, the index is set to 0.
     * @param bound  a bound on the number of methods to instantiate.
     * @param task   the tasks that accomplish the method.
     */
    private void instantiate(final IntMethod method, final int index, final int bound,
                             final List<IntMethod> methods, final IntExpression task) {
        final IntExpression t = method.getTask();
        final IntMethod copy = new IntMethod(method);
        boolean instantiable = true;
        int i = 0;
        while (i < t.getArguments().length && instantiable) {
            final int var = t.getArguments()[i];
            final int cons = task.getArguments()[i];
            final int type = copy.getTypeOfParameters((-var - 1));
            final Set<Integer> domain = this.typeDomains.get(type);
            if (domain.contains(cons)) {
                copy.getPreconditions().substitute(var, cons);
                copy.getTask().substitute(var, cons);
                copy.getSubTasks().substitute(var, cons);
                copy.setValueOfParameter((-var - 1), cons);
            } else {
                instantiable = false;
            }
            i++;
        }
        // This case may occur when variables are identical in the tasks
        if (copy.getTask().equals(task) && instantiable) {
            this.instantiate(copy, index, bound, methods);
        }
    }

    /**
     * Instantiates a specified method. This method used brut force.
     * <p>
     * The assumption is made that different method parameters are instantiated with different
     * constants, i.e., the planner never generates methods like move(a,a) because we consider this
     * as a bad domain representation that should be revised. In fact, in methods with identical
     * constant parameters, all but one of the constants are superfluous and can be skipped from the
     * representation without loss of information. Warning this assumption make the process no-sound.
     * </p>
     *
     * @param method  the method.
     * @param index   the index of the parameter to instantiate.
     * @param bound   the bound of methods to instantiate.
     * @param methods the list of methods already instantiated.
     * @see IntMethod
     */
    private void instantiate(final IntMethod method, final int index, final int bound, final List<IntMethod> methods) {
        if (bound == methods.size()) {
            return;
        }
        final int arity = method.arity();
        if (index == arity) {
            final IntExpression precond = method.getPreconditions();
            precond.simplify();
            if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                methods.add(method);
            }
        } else if (method.getValueOfParameter(index) >= 0) {
            this.instantiate(method, index + 1, bound, methods);
        } else {
            final Set<Integer> values = this.typeDomains.get(method.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntExpression preconditionCopy = new IntExpression(method.getPreconditions());

                preconditionCopy.substitute(varIndex, value);
                if (!preconditionCopy.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntMethod copy = new IntMethod(method.getName(), arity);
                    copy.setPreconditions(preconditionCopy);
                    copy.setOrderingConstraints(new IntExpression(method.getOrderingConstraints()));

                    final IntExpression taskCopy = new IntExpression(method.getTask());
                    taskCopy.substitute(varIndex, value);
                    copy.setTask(taskCopy);

                    final IntExpression subTasksCopy = new IntExpression(method.getSubTasks());
                    subTasksCopy.substitute(varIndex, value);
                    copy.setSubTasks(subTasksCopy);

                    for (int i = 0; i < arity; i++) {
                        copy.setTypeOfParameter(i, method.getTypeOfParameters(i));
                    }
                    for (int i = 0; i < arity; i++) {
                        copy.setValueOfParameter(i, method.getValueOfParameter(i));
                    }

                    copy.setValueOfParameter(index, value);
                    this.instantiate(copy, index + 1, bound, methods);
                }
            }
        }
    }

    /**
     * Do a pass over the preconditions of all the instantiated methods and update the ground inertia
     * table. Then, simplify the methods according to the extracted ground inertia.
     *
     */
    private void simplyMethodsWithGroundInertia() {
        final List<IntMethod> toAdd = new ArrayList<>(this.intMethods.size());
        final Set<IntExpression> toRemove = new HashSet<>();
        for (IntMethod m : this.intMethods) {
            this.simplifyWithGroundInertia(m.getPreconditions(), false);
            m.getPreconditions().simplify();
            if (!m.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                toAdd.add(m);
            } else {
                toRemove.add(m.getTask());
            }
        }
        this.simplyRecursivelyMethodsWithTasksNoMoreReachable(toRemove);
    }

    /**
     * Simply recursively the methods by removing unreachable tasks.
     *
     * @param tasks   the set of compound tasks which are no more reachable.
     * @return the list of task no more reachable.
     */
    private void simplyRecursivelyMethodsWithTasksNoMoreReachable(final Set<IntExpression> tasks) {
        while (!tasks.isEmpty()) {
            this.simplyMethodsWithTasksNoMoreReachable(tasks);
        }
    }

    /**
     * Simply the method by removing unreachable tasks.
     *
     * @param tasks   the set of compound tasks which are no more reachable.
     * @return the list of task no more reachable.
     */
    private void simplyMethodsWithTasksNoMoreReachable(final Set<IntExpression> tasks) {
        final Set<IntExpression> tasksNoMoreReachable = new LinkedHashSet<>();
        for (int i = 0; i < this.intMethods.size(); i++) {
            final IntMethod method = this.intMethods.get(i);
            if (this.isSimplified(method, tasks)) {
                this.intMethods.remove(i);
                for (int j = 0; j < this.compundTaskResolvers.size(); j++) {
                    final List<Integer> relevant = this.compundTaskResolvers.get(j);
                    if (relevant.remove(new Integer(i))) {
                        this.updateRelevantMethods(i);
                        // There is no more relevant method for the compound task
                        if (relevant.isEmpty()) {
                            tasksNoMoreReachable.add(this.relevantCompundTasks.get(j));
                            this.relevantCompundTasks.remove(j);
                            this.compundTaskResolvers.remove(j);
                            j--;
                        }
                        break;
                    }
                }
                i--;
            }
        }
        tasks.clear();
        tasks.addAll(tasksNoMoreReachable);
    }

    /**
     * Returns if a method can be simplified. A method can be simplified if it is relevant for a task that is no more
     * reachable or has a child that is no more reachable. The set of no more reachable set of tasks is given as
     * parameter of the methods.
     *
     * @param method the method to test.
     * @param tasks  the set of tasks that are no more reachable.
     * @return <code>true</code> if the method is simplified, <code>false</code>
     */
    private static boolean isSimplified(IntMethod method, Set<IntExpression> tasks) {
        boolean isSimplified = true;
        if (!tasks.contains(method.getTask())) {
            final List<IntExpression> subtasks = method.getSubTasks().getChildren();
            final Iterator<IntExpression> i = subtasks.iterator();
            isSimplified = false;
            while (i.hasNext() && !isSimplified) {
                isSimplified = tasks.contains(i.next());
            }
        }
        return isSimplified;
    }

    /**
     * Update the index of the relevant method when a method is removed.
     *
     * @param index the index of the method removed.
     */
    private void updateRelevantMethods(final int index) {
        for (List<Integer> relevant : this.compundTaskResolvers) {
            int i = 0;
            for (Integer m : relevant) {
                if (m > index) {
                    relevant.set(i, --m);
                }
                i++;
            }

        }
    }

    /******************************************************************************************************************/
    /* Methods to finalise the problem into compact representation
    */

    /**
     * Extracts the relevant facts from the instantiated actions. A ground fact is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fact and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fact and not a positive ground inertia.</li>
     * </ul>
     *
     */
    private void extractRelevantFluents() {
        final Set<IntExpression> fluents = new LinkedHashSet<>(10000);
        for (IntAction action : this.intActions) {
            this.extractRelevantFluents(action.getPreconditions(), fluents);
            this.extractRelevantFluents(action.getEffects(), fluents);
        }
        if (this.requirements.equals(PDDLRequireKey.HIERARCHY)) {
            for (IntMethod method : this.intMethods) {
                this.extractRelevantFluents(method.getPreconditions(), fluents);
            }
        }
        this.relevantFluents = new ArrayList<>(fluents.size());
        this.fluenIndex = new LinkedHashMap<>(fluents.size());
        int index = 0;
        for (IntExpression fluent : fluents) {
            final IntExpression copy = new IntExpression(fluent);
            this.relevantFluents.add(new Fluent(copy.getPredicate(), copy.getArguments()));
            this.fluenIndex.put(copy, index);
            index++;
        }
    }

    /**
     * Extracts the relevant fluents from a specified expression. A ground fluents is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fluent and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fluent and not a positive ground inertia.</li>
     * </ul>
     *
     * @param exp   the expression.
     * @param fluents the set of relevant facts.
     */
    private  void extractRelevantFluents(final IntExpression exp, final Set<IntExpression> fluents) {
        switch (exp.getConnective()) {
            case ATOM:
                fluents.add(exp);
                break;
            case FN_HEAD:
                break;
            case EQUAL_ATOM:
                break;
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    this.extractRelevantFluents(e, fluents);
                }
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case UMINUS:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case NOT:
                this.extractRelevantFluents(exp.getChildren().get(0), fluents);
                break;
            case WHEN:
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
                this.extractRelevantFluents(exp.getChildren().get(0), fluents);
                this.extractRelevantFluents(exp.getChildren().get(1), fluents);
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.extractRelevantFluents(exp.getChildren().get(0), fluents);
                this.extractRelevantFluents(exp.getChildren().get(1), fluents);
                this.extractRelevantFluents(exp.getChildren().get(3), fluents);
                break;
            case NUMBER:
            case F_EXP:
            case F_EXP_T:
            case DURATION_ATOM:
            case TIME_VAR:
            case IS_VIOLATED:
            case MINIMIZE:
            case MAXIMIZE:
                break;
            default:
                // do nothing
        }
    }

    /**
     * Extracts the relevant numeric fluents from the instantiated actions and methods.
     *
     */
    private void extractRelevantNumericFluents() {
        final Set<IntExpression> fluents = new LinkedHashSet<>(10000);
        for (IntAction action : this.intActions) {
            if (action.isDurative()) {
                this.extractRelevantNumericFluents(action.getDuration(), fluents);
            }
            this.extractRelevantNumericFluents(action.getPreconditions(), fluents);
            this.extractRelevantNumericFluents(action.getEffects(), fluents);
        }
        if (this.requirements.equals(PDDLRequireKey.HIERARCHY)) {
            for (IntMethod method : this.intMethods) {
                this.extractRelevantNumericFluents(method.getPreconditions(), fluents);
            }
        }
        this.relevantNumericFluents = new ArrayList<>(fluents.size());
        this.numericFluentIndex = new LinkedHashMap<>(fluents.size());
        int index = 0;
        for (IntExpression fluent : fluents) {
            final IntExpression copy = new IntExpression(fluent);
            this.relevantNumericFluents.add(new NumericFluent(copy.getPredicate(), copy.getArguments()));
            this.numericFluentIndex.put(copy, index);
            index++;
        }
    }

    /**
     * Extracts the relevant numeric fluent from a specified expression.
     *
     * @param exp   the expression.
     * @param fluents the set of relevant fluents extracted.
     */
    void extractRelevantNumericFluents(final IntExpression exp, final Set<IntExpression> fluents) {
        switch (exp.getConnective()) {
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    this.extractRelevantNumericFluents(e, fluents);
                }
                break;

            case FN_HEAD:
            case TIME_VAR:
                fluents.add(exp);
                break;
            case AT_START:
            case AT_END:
            case FORALL:
            case EXISTS:
            case UMINUS:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case F_EXP:
            case F_EXP_T:
            case NOT:
                this.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                break;
            case WHEN:
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
                this.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                this.extractRelevantNumericFluents(exp.getChildren().get(1), fluents);
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.extractRelevantNumericFluents(exp.getChildren().get(0), fluents);
                this.extractRelevantNumericFluents(exp.getChildren().get(1), fluents);
                this.extractRelevantNumericFluents(exp.getChildren().get(3), fluents);
                break;
            case ATOM:
            case EQUAL_ATOM:
            case NUMBER:
            case IS_VIOLATED:
            case MINIMIZE:
            case MAXIMIZE:
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(this.toString(exp));
        }
    }

    /**
     * Extracts the relevant tasks of the problem and the create the map that associate a task to its index in the table
     * of tasks.
     */
    private void extractRelevantTasks() {
        this.relevantTasks = new ArrayList<>();
        int index = 0;
        for (IntExpression task : this.relevantPrimitiveTasks) {
            this.relevantTasks.add(new Task(task.getPredicate(), task.getArguments(), true));
            this.taskIndex.put(task, index);
            index++;
        }
        for (IntExpression task : this.relevantCompundTasks) {
            this.relevantTasks.add(new Task(task.getPredicate(), task.getArguments(), false));
            this.taskIndex.put(task, index);
            index++;
        }
        this.taskResolvers = new ArrayList<List<Integer>>();
        this.taskResolvers.addAll(this.primtiveTaskResolvers);
        this.taskResolvers.addAll(this.compundTaskResolvers);

    }
    /**
     * Encode a specified goal in a disjunction of <code>BitExp</code>. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     *
     * @return a list of <code>BitExp</code> that represents the goal as a disjunction of
     * <code>BitExp</code>.
     */
    private void finalizeGoal() {

        if (!this.intGoal.getConnective().equals(PDDLConnective.FALSE)) {
            this.intGoal.toDNF();
            this.goal = this.encodePrecondition(this.intGoal);
        }
        this.goal = null;

    }

    /**
     *
     * @param exp
     * @return
     */
    private List<Condition> encodePrecondition(final IntExpression exp) {
        final List<Condition> conditions = new ArrayList<>();
        for (IntExpression e : exp.getChildren()) {
            conditions.add(this.encodeCondition(e));
        }
        return conditions;
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @return the expression in bit set representation.
     */
    private Condition encodeCondition(final IntExpression exp) throws UnexpectedExpressionException {

        final Condition condition = new Condition();
        switch (exp.getConnective()) {
            case ATOM:
                condition.getPositiveFluents().set(this.fluenIndex.get(exp));
                break;
            case NOT:
                condition.getNegativeFluents().set(this.fluenIndex.get(exp.getChildren().get(0)));
                break;
            case AND:
                for (IntExpression e : exp.getChildren()) {
                    Condition ce = this.encodeCondition(e);
                    condition.getPositiveFluents().or(ce.getPositiveFluents());
                    condition.getNegativeFluents().or(ce.getNegativeFluents());
                    condition.getNumericConstraints().addAll(ce.getNumericConstraints());
                }
                break;
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
                condition.getNumericConstraints().add(this.encodeNumericConstraint(exp));
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(this.toString(exp));
        }
        return condition;
    }

    /**
     * Encode an specified <code>IntExpression</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExpression</code>.
     * @return the expression in bit set representation.
     */
    private List<NumericConstraint> encodeNumericConstraints(final IntExpression exp)
        throws UnexpectedExpressionException {

        final List<NumericConstraint> constraints = new ArrayList<>();
        switch (exp.getConnective()) {
            case AND:
                for (IntExpression e : exp.getChildren()) {
                    constraints.addAll(this.encodeNumericConstraints(e));
                }
                break;
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
                constraints.add(this.encodeNumericConstraint(exp));
                break;
            case ATOM:
            case NOT:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case TRUE:
                // do nothing
                break;
            default:
                throw new UnexpectedExpressionException(this.toString(exp));
        }
        return constraints;
    }

    /**
     * Encodes a numeric constraint.
     */
    private NumericConstraint encodeNumericConstraint(final IntExpression exp) {

        ArithmeticExpression left = this.encodeArithmeticExpression(exp.getChildren().get(0));
        ArithmeticExpression right = this.encodeArithmeticExpression(exp.getChildren().get(1));
        NumericConstraint constraint = null;
        switch (exp.getConnective()) {
            case EQUAL:
                constraint = new NumericConstraint(NumericConstraint.Comparator.EQUAL, left, right);
                break;
            case LESS:
                constraint = new NumericConstraint(NumericConstraint.Comparator.LESS, left, right);
                break;
            case LESS_OR_EQUAL:
                constraint = new NumericConstraint(NumericConstraint.Comparator.LESS_OR_EQUAL, left, right);
                break;
            case GREATER:
                constraint = new NumericConstraint(NumericConstraint.Comparator.GREATER, left, right);
                break;
            case GREATER_OR_EQUAL:
                constraint = new NumericConstraint(NumericConstraint.Comparator.GREATER_OR_EQUAL, left, right);
                break;
            default:
                throw new UnexpectedExpressionException(this.toString(exp));
        }
        return constraint;
    }

    /**
     * Encodes an arithmetic expression.
     *
     * @param exp the expression to encode.
     */
    private ArithmeticExpression encodeArithmeticExpression(final IntExpression exp) {

        ArithmeticExpression arithmeticExpression;
        ArithmeticExpression left;
        ArithmeticExpression right;
        switch (exp.getConnective()) {
            case PLUS:
                left = this.encodeArithmeticExpression(exp.getChildren().get(0));
                right = this.encodeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.PLUS, left, right);
                break;
            case MINUS:
                left = this.encodeArithmeticExpression(exp.getChildren().get(0));
                right = this.encodeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.MINUS, left, right);
                break;
            case UMINUS:
                left = this.encodeArithmeticExpression(exp.getChildren().get(0));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.UMINUS, left, null);
                break;
            case DIV:
                left = this.encodeArithmeticExpression(exp.getChildren().get(0));
                right = this.encodeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.DIV, left, right);
                break;
            case MUL:
                left = this.encodeArithmeticExpression(exp.getChildren().get(0));
                right = this.encodeArithmeticExpression(exp.getChildren().get(1));
                arithmeticExpression = new ArithmeticExpression(ArithmeticOperator.MUL, left, right);
                break;
            case NUMBER:
                arithmeticExpression = new ArithmeticExpression(exp.getValue());
                break;
            case F_EXP:
                arithmeticExpression = this.encodeArithmeticExpression(exp.getChildren().get(0));
                break;
            case FN_HEAD:
            case TIME_VAR:
                //case TOTAL_COST_VAR:
            case AT_START:
            case AT_END:
                arithmeticExpression = new ArithmeticExpression(this.numericFluentIndex.get(exp));
                break;
            default:
                throw new UnexpectedExpressionException(this.toString(exp));
        }
        return arithmeticExpression;
    }

    /**
     * Finalize the initia task network representation of the problem.
     */
    private void finalizeInitialTaskNetwork() {
        this.initialTaskNetwork = this.encodeTaskNetwork(this.intInitialTaskNetwork);
    }

    /**
     * Encode a specified task network.
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param taskNetwork the tasknetwork to encode.
     * @return a list of <code>BitExp</code> that represents the goal as a disjunction of
     * <code>BitExp</code>.
     */
    private TaskNetwork encodeTaskNetwork(IntTaskNetwork taskNetwork) {
        // We encode first the tasks
        final List<Integer> tasks = new ArrayList<Integer>();
        this.encodeTasks(taskNetwork.getTasks(), tasks);
        // We encode then the ordering constraints
        final OrderingConstraintSet constraints = new OrderingConstraintSet(tasks.size());
        for (IntExpression c : taskNetwork.getOrderingConstraints().getChildren()) {
            constraints.set(c.getChildren().get(0).getTaskID(), c.getChildren().get(1).getTaskID());
        }
        final TaskNetwork tn = new TaskNetwork(tasks, constraints);
        tn.transitiveClosure();
        return tn;
    }

    /**
     * Encode the list of tasks expressed as an IntExpression into a list of integer.
     *
     * @param exp   the list of tasks expressed as an IntExpression.
     * @param tasks the list of task encoded as integer.
     */
    private void encodeTasks(IntExpression exp, List<Integer> tasks) {
        switch (exp.getConnective()) {
            case TASK:
                tasks.add(this.taskIndex.get(exp));
                break;
            case AND:
            case OR:
                for (IntExpression e : exp.getChildren()) {
                    this.encodeTasks(e, tasks);
                }
                break;
            default:
                // Do nothing
        }
    }

    /**
     * Encode a list of specified methods into the final compact representation. The specified
     * maps are used to speed-up the search by mapping the an expression to this index.
     *
     * @return the list of methods encoded into final compact representation.
     */
    private void finalizeMethods() {
        this.methods = new ArrayList<>(this.intMethods.size());
        for (IntMethod method : this.intMethods) {
            method.getPreconditions().toDNF();
            this.methods.add(this.finalizeMethod(method));
        }
    }

    /**
     * Encode a list of specified methods into the final compact representation. The specified
     * maps are used to speed-up the search by mapping the an expression to this index.
     *
     * @param method the list of methods to encode.
     * @return the list of methods encoded into final compact representation.
     */
    private Method finalizeMethod(final IntMethod method) throws UnexpectedExpressionException {

        final int arity = method.arity();
        final Method encoded = new Method(method.getName(), arity);
        // Initialize the parameters of the method
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, method.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, method.getTypeOfParameters(i));
        }

        // Encode the task carried out by the method
        encoded.setTask(this.taskIndex.get(method.getTask()));
        // Encode the preconditions of the method
        encoded.setPreconditions(this.encodePrecondition(method.getPreconditions()));
        // Encode the task network of the method
        encoded.setTaskNetwork(this.encodeTaskNetwork(method.getTaskNetwork()));
        return encoded;
    }

    /**
     * Encode a specified initial state in it <code>BitExp</code> representation. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     */
    private void finalizeIntitialState() {
        this.initialState = new InitialState();
        for (final IntExpression fluent : this.intInitialState) {
            switch (fluent.getConnective()) {
                case ATOM:
                    //System.out.println(Encoder.toString(fluent));
                    Integer index = this.fluenIndex.get(fluent);
                    if (index != null) {
                        this.initialState.getPositiveFluents().set(index);
                    }
                    break;
                case NOT:
                    index = this.fluenIndex.get(fluent.getChildren().get(0));
                    if (index != null) {
                        this.initialState.getPositiveFluents().set(index);
                    }
                    break;
                case EQUAL:
                    IntExpression numeric = fluent.getChildren().get(0);
                    IntExpression number = fluent.getChildren().get(1);
                    this.initialState.addNumericFluent(new NumericVariable(this.numericFluentIndex.get(numeric),
                        number.getValue()));
                    break;
                default:
                    throw new UnexpectedExpressionException(this.toString(fluent));

            }
        }
    }

    /**
     * Encode a list of specified actions into <code>BitSet</code> representation. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @return the list of actions encoded into bit set.
     */
    private void finalizeActions() {
        this.actions = new ArrayList<>(this.intActions.size());
        for (IntAction intAction : this.intActions) {
            intAction.getPreconditions().toDNF();
            intAction.getEffects().toCNF();
            this.actions.add(this.finalizeAction(intAction));
        }
    }

    /**
     * Encodes a specified action.
     *
     * @param action the action to be encoded. The precondition of the action must be a simple conjunction of atomic
     *               formulas
     * @return the action encoded.
     */
    private Action finalizeAction(final IntAction action) {

        final int arity = action.arity();
        final Action encoded = new Action(action.getName(), arity);
        //encoded.setCost(action.getCost());

        // Initialize the parameters of the action
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, action.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, action.getTypeOfParameters(i));
        }


        // Initialize the duration of the action
        if (action.isDurative()) {
            encoded.setDurationConstraints(this.encodeDurationConstraints(action.getDuration()));
        }

        // Initialize the preconditions of the action
        encoded.setPreconditions(this.encodePrecondition(action.getPreconditions()));
        /*System.out.println(Encoder.toString(action));*/
        encoded.setConditionalEffects(this.encodeCondttionalEffects(action.getEffects()));

        return encoded;
    }

    /**
     * Encode the duration constraints of the action. The expression in parameter must be a conjunction of simple
     * numeric constraints.
     *
     * @param exp the expression that represents the duration constraints.
     *
     */
    private List<NumericConstraint> encodeDurationConstraints(final IntExpression exp) {
        final List<NumericConstraint> constraints = new ArrayList<>();
        for (IntExpression constraint: exp.getChildren()) {
            constraints.add(this.encodeNumericConstraint(constraint));
        }
        return constraints;
    }

    /**
     *
     */
    private List<ConditionalEffect> encodeCondttionalEffects(IntExpression exp) {

        List<ConditionalEffect> effects = new ArrayList<>();
        final ConditionalEffect unCondEffects = new ConditionalEffect();
        boolean hasUnConditionalEffects = false;
        for (IntExpression effect : exp.getChildren()) {
            final List<IntExpression> children = effect.getChildren();
            switch (effect.getConnective()) {
                case WHEN:
                    final ConditionalEffect ce = new ConditionalEffect();
                    ce.setConditions(this.encodePrecondition(children.get(0)));
                    ce.setEffect(this.encodeEffect(children.get(1)));
                    effects.add(ce);
                    break;
                case ATOM:
                    unCondEffects.getEffect().getPositiveFluents().set(this.fluenIndex.get(effect));
                    hasUnConditionalEffects = true;
                    break;
                case TRUE:
                    // do nothing
                    break;
                case NOT:
                    unCondEffects.getEffect().getPositiveFluents().set(this.fluenIndex.get(children.get(0)));
                    hasUnConditionalEffects = true;
                    break;
                case ASSIGN:
                case INCREASE:
                case DECREASE:
                case SCALE_DOWN:
                case SCALE_UP:
                    NumericAssignment assignment = this.encodeNumericAssignment(effect);
                    unCondEffects.getEffect().getNumericAssignments().add(assignment);
                    hasUnConditionalEffects = true;
                    break;
                default:
                    throw new UnexpectedExpressionException(this.toString(effect));
            }
        }
        if (hasUnConditionalEffects) {
            effects.add(unCondEffects);
        }
        return effects;
    }

    private Effect encodeEffect(IntExpression exp) throws UnexpectedExpressionException {
        final Effect effect = new Effect();
        switch (exp.getConnective()) {
            case ATOM:
                effect.getPositiveFluents().set(this.fluenIndex.get(exp));
                break;
            case NOT:
                effect.getNegativeFluents().set(this.fluenIndex.get(exp.getChildren().get(0)));
                break;
            case AND:
                for (IntExpression e : exp.getChildren()) {
                    Effect eff = this.encodeEffect(e);
                    eff.getPositiveFluents().or(eff.getPositiveFluents());
                    eff.getNegativeFluents().or(eff.getNegativeFluents());
                    eff.getNumericAssignments().addAll(eff.getNumericAssignments());
                }
                break;
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
            case TRUE:
                // Do nothing
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                effect.getNumericAssignments().add(this.encodeNumericAssignment(exp));
                break;
            default:
                throw new UnexpectedExpressionException(this.toString(exp));
        }
        return effect;


    }

    /**
     * Encodes a numeric assignment.
     */
    private NumericAssignment encodeNumericAssignment(final IntExpression exp) {

        final NumericVariable fluent = new NumericVariable(this.numericFluentIndex.get(exp.getChildren().get(0)));
        final ArithmeticExpression arithmeticExpression = this.encodeArithmeticExpression(exp.getChildren().get(1));
        NumericAssignment assignment = null;
        switch (exp.getConnective()) {
            case ASSIGN:
                assignment = new NumericAssignment(NumericAssignment.Operator.ASSIGN, fluent, arithmeticExpression);
                break;
            case INCREASE:
                assignment = new NumericAssignment(NumericAssignment.Operator.INCREASE, fluent, arithmeticExpression);
                break;
            case DECREASE:
                assignment = new NumericAssignment(NumericAssignment.Operator.DECREASE, fluent, arithmeticExpression);
                break;
            case SCALE_UP:
                assignment = new NumericAssignment(NumericAssignment.Operator.SCALE_UP, fluent, arithmeticExpression);
                break;
            case SCALE_DOWN:
                assignment = new NumericAssignment(NumericAssignment.Operator.SCALE_DOWN, fluent, arithmeticExpression);
                break;
            default:
                throw new UnexpectedExpressionException(this.toString(exp));
        }
        return assignment;
    }


    /******************************************************************************************************************/
    /* Methods to print structures
    */

    /**
     * Returns a string representation of the specified action.
     *
     * @param action the operator to print.
     * @return a string representation of the specified action.
     */
    public String toString(final IntAction action) {
        final StringBuilder str = new StringBuilder();
        str.append("Action ").append(action.getName()).append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < action.arity(); i++) {
            final int index = action.getValueOfParameter(i);
            final String type = typeSymbols.get(action.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i).append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(constantSymbols.get(index));
                str.append(" \n");
            }
        }
        if (action.isDurative()) {
            str.append("Duration:\n");
            str.append(this.toString(action.getDuration()));
            str.append("\nCondition:\n");
        } else {
            str.append("Preconditions:\n");
        }
        str.append(this.toString(action.getPreconditions()));
        str.append("\n");
        str.append("Effects:\n");
        str.append(this.toString(action.getEffects()));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param method the method.
     * @return a string representation of the specified method.
     */
    public String toString(final IntMethod method) {
        final StringBuilder str = new StringBuilder();
        str.append("Method ").append(method.getName()).append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < method.arity(); i++) {
            final int index = method.getValueOfParameter(i);
            final String type = this.typeSymbols.get(method.getTypeOfParameters(i));
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
                str.append(this.constantSymbols.get(index));
                str.append(" \n");
            }
        }
        str.append("Task: ").append(toString(method.getTask()));
        str.append("\n");
        str.append("Preconditions:\n");
        str.append(this.toString(method.getPreconditions()));
        str.append("\n");
        str.append("Subtasks:\n");
        str.append(this.toString(method.getSubTasks()));
        str.append("\n");
        str.append("Ordering:\n");
        str.append(this.toString(method.getOrderingConstraints()));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of the specified task network.
     *
     * @param tasknetwork the task network to print.
     * @return a string representation of the specified method.
     */
    public String toString(final IntTaskNetwork tasknetwork) {
        final StringBuilder str = new StringBuilder();
        str.append("Parameters:\n");
        for (int i = 0; i < tasknetwork.arity(); i++) {
            final int index = tasknetwork.getValueOfParameter(i);
            final String type = this.typeSymbols.get(tasknetwork.getTypeOfParameters(i));
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
                str.append(this.constantSymbols.get(index));
                str.append(" \n");
            }
        }
        str.append("Tasks:\n");
        str.append(toString(tasknetwork.getTasks()));
        str.append("\n");
        str.append("Ordering constraints:\n");
        str.append(toString(tasknetwork.getOrderingConstraints()));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param expression the expression.
     * @return a string representation of the specified expression.
     */
    public String toString(final IntExpression expression) {
        return this.toString(expression, " ");
    }

    /**
     * Returns a string representation of a expression.
     *
     * @param expression the expression.
     * @param separator  the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression.
     */
    private String toString(final IntExpression expression, final String separator) {
        return this.toString(expression, "", separator);
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param expression  the expression.
     * @param baseOffset the offset white space from the left used for indentation.
     * @param separator  the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression node.
     */
    private String toString(final IntExpression expression, String baseOffset, final String separator) {
        final StringBuilder str = new StringBuilder();
        switch (expression.getConnective()) {
            case ATOM:
                str.append("(");
                str.append(this.predicateSymbols.get(expression.getPredicate()));
                int[] args = expression.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" ");
                        str.append(this.constantSymbols.get(index));
                    }
                }
                str.append(")");
                break;
            case FN_HEAD:
                str.append("(");
                str.append(this.functionSymbols.get(expression.getPredicate()));
                args = expression.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" ");
                        str.append(this.constantSymbols.get(index));
                    }
                }
                str.append(")");
                break;
            case TASK:
                str.append("(");
                if (expression.getTaskID() != IntExpression.DEFAULT_TASK_ID) {
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                    str.append(expression.getTaskID());
                    str.append(" (");
                }
                str.append(taskSymbols.get(expression.getPredicate()));
                args = expression.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" ").append(this.constantSymbols.get(index));
                    }
                }
                if (expression.getTaskID() != IntExpression.DEFAULT_TASK_ID) {
                    str.append(")");
                }
                str.append(")");
                break;
            case EQUAL_ATOM:
                str.append("(").append("=");
                args = expression.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" ");
                        str.append(this.constantSymbols.get(index));
                    }
                }
                str.append(")");
                break;
            case AND:
            case OR:
                String offsetOr = baseOffset + "  ";
                str.append("(");
                str.append(expression.getConnective().getImage());
                str.append(" ");
                if (!expression.getChildren().isEmpty()) {
                    for (int i = 0; i < expression.getChildren().size() - 1; i++) {
                        str.append(this.toString(expression.getChildren().get(i), offsetOr));
                        str.append("\n");
                        str.append(offsetOr);
                    }
                    str.append(this.toString(expression.getChildren()
                        .get(expression.getChildren().size() - 1), offsetOr));
                }
                str.append(")");
                break;
            case FORALL:
            case EXISTS:
                str.append(" (").append(expression.getConnective().getImage());
                str.append(" (").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(-expression.getVariable() - 1);
                str.append(" - ");
                String offsetEx = baseOffset + baseOffset + "  ";
                str.append(this.typeSymbols.get(expression.getType()));
                str.append(")\n");
                str.append(offsetEx);
                if (expression.getChildren().size() == 1) {
                    str.append(this.toString(expression.getChildren().get(0), offsetEx));
                }
                str.append(")");
                break;
            case NUMBER:
                str.append(expression.getValue());
                break;
            case F_EXP:
                str.append(this.toString(expression.getChildren().get(0), baseOffset));
                break;
            case F_EXP_T:
            case TRUE:
            case FALSE:
                str.append(expression.getConnective());
                break;
            case TIME_VAR:
                str.append(expression.getConnective().getImage());
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
                str.append(expression.getConnective().getImage());
                str.append(" ");
                str.append(this.toString(expression.getChildren().get(0), baseOffset));
                str.append(" ");
                str.append(this.toString(expression.getChildren().get(1), baseOffset));
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
                str.append(expression.getConnective().getImage());
                str.append(" ");
                str.append(this.toString(expression.getChildren().get(0), baseOffset));
                str.append(")");
                break;
            case IS_VIOLATED:
                str.append("(");
                str.append(expression.getConnective().getImage());
                str.append(")");
                break;
            case LESS_ORDERING_CONSTRAINT:
                str.append("(");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(expression.getChildren().get(0).getTaskID());
                str.append(" ");
                str.append(expression.getConnective().getImage());
                str.append(" ");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(expression.getChildren().get(1).getTaskID());
                str.append(")");
                break;
            default:
                str.append("DEFAULT");
                break;
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a specified action.
     *
     * @param action the action.
     * @return a string representation of the specified action.
     */
    private String toString(final Action action) {
        StringBuilder str = new StringBuilder();
        str.append("Action ");
        str.append(action.getName());
        str.append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < action.arity(); i++) {
            final int index = action.getValueOfParameter(i);
            final String type = typeSymbols.get(action.getTypeOfParameters(i));
            str.append(" ");
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
                str.append(constantSymbols.get(index));
                str.append(" \n");
            }
        }
        if (action.isDurative()) {
            str.append("Duration:\n");
            if (!action.getDurationConstraints().isEmpty()) {
                str.append(this.toString(action.getDurationConstraints().get(0)));
                for (int i = 1; i < action.getDurationConstraints().size(); i++) {
                    str.append("\n  ");
                    str.append(this.toString(action.getDurationConstraints().get(i)));
                }
            }
            str.append("\nCondition:\n");
        } else {
            str.append("Condition:\n");
        }
        if (action.getPreconditions().isEmpty()) {
            str.append("()");
        } else {
            str.append("(or ");
            for (Condition condition : action.getPreconditions()) {
                str.append(this.toString(condition));
                str.append("\n");
            }
            str.deleteCharAt(str.length() - 1);
        }
        str.append(")\nEffect:\n");
        for (ConditionalEffect condExp : action.getConditionalEffects()) {
            str.append(this.toString(condExp));
            str.append("\n");
        }
        return str.toString();
    }


    /**
     * Returns a string representation of a list of conditions.
     *
     * @param conditions the list of conditions.
     * @return a string representation of the specified expression.
     */
    public String toString(List<Condition> conditions) {
        final StringBuilder str = new StringBuilder();
        if (conditions.isEmpty()) {
            str.append("()");
        } else {
            str.append("(or ");
            for (Condition condition : conditions) {
                str.append(this.toString(condition));
                str.append("\n");
            }
            str.deleteCharAt(str.length() - 1);
            str.append(")");
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a condition.
     *
     * @return a string representation of the specified condition.
     */
    public String toString(Condition condition) {
        final StringBuilder str = new StringBuilder();
        if (condition.isEmpty()) {
            str.append("()");
        } else {
            str.append("(and");
            final BitSet positive = condition.getPositiveFluents();
            for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
                str.append(" ");
                str.append(this.toString(this.relevantFluents.get(j)));
                str.append("\n");
            }
            final BitSet negative = condition.getNegativeFluents();
            for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
                str.append(" (not ");
                str.append(this.toString(this.relevantFluents.get(i)));
                str.append(")\n");
            }
            for (NumericConstraint constraint : condition.getNumericConstraints()) {
                str.append(" ");
                str.append(this.toString(constraint));
                str.append("\n");
            }
            str.deleteCharAt(str.length() - 1);
            str.append(")");
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a conditional bit expression.
     *
     * @param ceffect        the conditional expression.
     * @return a string representation of the specified expression.
     */
    public String toString(final ConditionalEffect ceffect) {
        StringBuilder str = new StringBuilder();
        str.append("(when ");
        str.append(this.toString(ceffect.getConditions()));
        str.append("\n");
        str.append(this.toString(ceffect.getEffect()));
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of an effect.
     *
     * @param effect the effect.
     * @return a string representation of the specified expression.
     */
    public String toString(final Effect effect) {
        final StringBuilder str = new StringBuilder();
        if (effect.isEmpty()) {
            str.append("()");
        } else {
            str.append("(and");
            final BitSet positive = effect.getPositiveFluents();
            for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
                str.append(" ");
                str.append(this.toString(this.relevantFluents.get(j)));
                str.append("\n");
            }
            if (!positive.isEmpty()) {
                str.deleteCharAt(str.length() - 1);
            }
            final BitSet negative = effect.getNegativeFluents();
            for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
                str.append(" (not ");
                str.append(this.toString(this.relevantFluents.get(i)));
                str.append(")\n");
            }
            if (!negative.isEmpty()) {
                str.deleteCharAt(str.length() - 1);
            }
            for (NumericAssignment assignment : effect.getNumericAssignments()) {
                str.append(" ");
                str.append(this.toString(assignment));
                str.append("\n");
            }
            if (effect.getNumericAssignments().isEmpty()) {
                str.deleteCharAt(str.length() - 1);
            }
            str.append(")");
        }
        return str.toString();
    }
    /**
     * Returns a string representation of numeric constraints.
     *
     * @param constraint the numeric constraints.
     * @return a string representation of numeric constraints.
     */
    public String toString(final NumericConstraint constraint) {
        final StringBuilder str = new StringBuilder();
        switch (constraint.getComparator()) {
            case EQUAL:
                str.append("(= ");
                str.append(this.toString(constraint.getLeftExpression()));
                str.append(" ");
                str.append(this.toString(constraint.getRightExpression()));
                str.append(")");
                break;
            case LESS:
                str.append("(< ");
                str.append(this.toString(constraint.getLeftExpression()));
                str.append(" ");
                str.append(this.toString(constraint.getRightExpression()));
                str.append(")");
                break;
            case LESS_OR_EQUAL:
                str.append("(<= ");
                str.append(this.toString(constraint.getLeftExpression()));
                str.append(" ");
                str.append(this.toString(constraint.getRightExpression()));
                str.append(")");
                break;
            case GREATER:
                str.append("(> ");
                str.append(this.toString(constraint.getLeftExpression()));
                str.append(" ");
                str.append(this.toString(constraint.getRightExpression()));
                str.append(")");
                break;
            case GREATER_OR_EQUAL:
                str.append("(>= ");
                str.append(this.toString(constraint.getLeftExpression()));
                str.append(" ");
                str.append(this.toString(constraint.getRightExpression()));
                str.append(")");
                break;
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a numeric assignment.
     *
     * @param assignment the numeric assignment.
     * @return a string representation of a numeric assignment.
     */
    public String toString(final NumericAssignment assignment) {
        final StringBuilder str = new StringBuilder();
        switch (assignment.getOperator()) {
            case ASSIGN:
                str.append("(assign ");
                str.append(this.toString(assignment.getLeftExpression()));
                str.append(" ");
                str.append(this.toString(assignment.getRightExpression()));
                str.append(")");
                break;
            case INCREASE:
                str.append("(increase ");
                str.append(this.toString(assignment.getLeftExpression()));
                str.append(" ");
                str.append(this.toString(assignment.getRightExpression()));
                str.append(")");
                break;
            case DECREASE:
                str.append("(decrease ");
                str.append(this.toString(assignment.getLeftExpression()));
                str.append(" ");
                str.append(this.toString(assignment.getRightExpression()));
                str.append(")");
                break;
            case SCALE_UP:
                str.append("(scale-up ");
                str.append(this.toString(assignment.getLeftExpression()));
                str.append(" ");
                str.append(this.toString(assignment.getRightExpression()));
                str.append(")");
                break;
            case SCALE_DOWN:
                str.append("(scale-down ");
                str.append(this.toString(assignment.getLeftExpression()));
                str.append(" ");
                str.append(this.toString(assignment.getRightExpression()));
                str.append(")");
                break;
        }
        return str.toString();
    }

    /**
     * Returns a string representation of an arithmetic expression.
     *
     * @param exp the arithmetic expression.
     * @return a string representation of an arithmetic expression.
     */
    public String toString(final ArithmeticExpression exp) {
        StringBuilder str = new StringBuilder();
        switch (exp.getType()) {
            case NUMBER:
                str.append(exp.getValue());
                break;
            case VARIABLE:
                str.append("(");
                str.append(this.toString(this.relevantNumericFluents.get(exp.getNumericFluents())));
                str.append("/");
                str.append(exp.getValue());
                str.append(")");
                break;
            case OPERATOR:
                switch (exp.getArithmeticOperator()) {
                    case PLUS:
                        str.append("(+ ");
                        str.append(this.toString(exp.getLeftExpression()));
                        str.append(" ");
                        str.append(this.toString(exp.getRightExpression()));
                        str.append(")");
                        break;
                    case MINUS:
                        str.append("(- ");
                        str.append(this.toString(exp.getLeftExpression()));
                        str.append(" ");
                        str.append(this.toString(exp.getRightExpression()));
                        str.append(")");
                        break;
                    case DIV:
                        str.append("(/ ");
                        str.append(this.toString(exp.getLeftExpression()));
                        str.append(" ");
                        str.append(this.toString(exp.getRightExpression()));
                        str.append(")");
                        break;
                    case MUL:
                        str.append("(* ");
                        str.append(this.toString(exp.getLeftExpression()));
                        str.append(" ");
                        str.append(this.toString(exp.getRightExpression()));
                        str.append(")");
                        break;
                    case UMINUS:
                        str.append("(- ");
                        str.append(this.toString(exp.getLeftExpression()));
                        str.append(")");
                        break;
                }
        }
        return str.toString();
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param method the method..
     * @return a string representation of the specified method.
     */
    public String toString(final Method method) {
        final StringBuilder str = new StringBuilder();
        str.append("Method ");
        str.append(method.getName());
        str.append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < method.arity(); i++) {
            final int index = method.getValueOfParameter(i);
            final String type = this.typeSymbols.get(method.getTypeOfParameters(i));
            str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
            str.append(i);
            str.append(" - ");
            str.append(type);
            if (index == -1) {
                str.append(" : ? \n");
            } else {
                str.append(this.constantSymbols.get(index));
                str.append(" \n");
            }
        }
        Task task = this.relevantTasks.get(method.getTask());
        str.append("task: ");
        str.append(this.toString(task));
        str.append("\n");
        str.append("Preconditions:\n");
        str.append("(or ");
        for (Condition condition : method.getPreconditions()) {
            str.append(this.toString(condition));
            str.append("\n");
        }
        str.append(")\n");
        str.append(this.toString(method.getTaskNetwork()));
        return str.toString();
    }

    /**
     * Returns a string representation of the specified task network.
     *
     * @param tasknetwork the task network to print
     * @return a string representation of the specified tasknetwork.
     */
    public String toString(final TaskNetwork tasknetwork) {
        final StringBuilder str = new StringBuilder();
        str.append("Tasks:\n");
        if (tasknetwork.getTasks().isEmpty()) {
            str.append(" ()\n");
        } else {
            for (int i = 0; i < tasknetwork.getTasks().size(); i++) {
                str.append(" ");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(i);
                str.append(": ");
                str.append(this.toString(this.relevantTasks.get(tasknetwork.getTasks().get(i))));
                str.append("\n");
            }
        }
        str.append("Ordering constraints:\n");
        if (tasknetwork.getOrderingConstraints().cardinality() == 0) {
            str.append(" ()");
        } else {
            BitMatrix constraints = tasknetwork.getOrderingConstraints();
            int index = 0;
            for (int r = 0; r < constraints.rows(); r++) {
                BitSet row = constraints.getRow(r);
                for (int c = row.nextSetBit(0); c >= 0; c = row.nextSetBit(c + 1)) {
                    str.append(" C");
                    str.append(index);
                    str.append(": ");
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                    str.append(r);
                    str.append(" ");
                    str.append(PDDLConnective.LESS_ORDERING_CONSTRAINT.getImage());
                    str.append(" ");
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                    str.append(c);
                    str.append("\n");
                    index++;
                }
            }
        }
        return str.toString();
    }

    /**
     * Returns a string representation of an initial state.
     *
     * @return a string representation of the specified initial state.
     */
    public String toString(InitialState initialState) {
        final StringBuilder str = new StringBuilder();
        str.append("(and");
        final BitSet positive = initialState.getPositiveFluents();
        for (int j = positive.nextSetBit(0); j >= 0; j = positive.nextSetBit(j + 1)) {
            str.append(" ");
            str.append(this.toString(this.relevantFluents.get(j)));
            str.append("\n");
        }
        final BitSet negative = initialState.getNegativeFluents();
        for (int i = negative.nextSetBit(0); i >= 0; i = negative.nextSetBit(i + 1)) {
            str.append(" (not ");
            str.append(this.toString(this.relevantFluents.get(i)));
            str.append(")\n");
        }
        for (NumericVariable variable : initialState.getNumericFluents()) {
            str.append(" ");
            str.append(this.toString(variable));
            str.append("\n");
        }
        str.deleteCharAt(str.length() - 1);
        str.append(")");
        return str.toString();
    }

    /**
     * Returns a string representation of a hierarchical decomposition of plan.
     *
     * @param hierarchy the hierarchical decomposition to convert into string represention.
     * @return the string representation of the he hierarchical decomposition in parameter.
     */
    public String toString(final Hierarchy hierarchy) {
        StringBuilder str = new StringBuilder();
        str.append("==>\n");
        for (Map.Entry<Integer, Action> a : hierarchy.getPrimtiveTasks().entrySet()) {
            str.append(a.getKey());
            str.append(" ");
            str.append(this.toShortString(a.getValue()));
            str.append("\n");
        }
        str.append("root");
        for (Integer rootTask : hierarchy.getRootTasks()) {
            str.append(" ");
            str.append(rootTask);
        }
        str.append("\n");
        for (Map.Entry<Integer, Method> m : hierarchy.getCounpoudTasks().entrySet()) {
            str.append(m.getKey());
            str.append(" ");
            str.append(this.toString(this.getRelevantTasks().get(m.getValue().getTask())));
            str.append(" -> ");
            str.append(m.getValue().getName());
            for (Integer t : hierarchy.getDecomposition().get(m.getKey())) {
                str.append(" ");
                str.append(t);
            }
            str.append("\n");
        }
        str.append("<==\n");
        return str.toString();

    }


    /**
     * Returns a short string representation of the specified operator, i.e., its name and its
     * instantiated parameters. This method can be used for actions and methods.
     *
     * @param operator  the operator.
     * @return a string representation of the specified operator.
     */
    public final String toShortString(final AbstractGroundOperator operator) {
        final StringBuilder str = new StringBuilder();
        str.append(operator.getName());
        for (int i = 0; i < operator.arity(); i++) {
            final int index = operator.getValueOfParameter(i);
            if (index == -1) {
                str.append(" ?");
            } else {
                str.append(" ");
                str.append(this.getConstantSymbols().get(index));
            }
        }
        return str.toString();
    }

    /**
     * Return a string representation of a search.
     *
     * @param plan the search.
     * @return a string representation of the specified search.
     */
    public final String toString(final Plan plan) {
        int max = Integer.MIN_VALUE;
        for (Integer t : plan.timeSpecifiers()) {
            for (Action a : plan.getActionSet(t)) {
                int length = this.toShortString(a).length();
                if (max < length) {
                    max = length;
                }
            }
        }
        final int actionSize = max;
        final int timeSpecifierSize = (int) Math.log10(plan.timeSpecifiers().size()) + 1;

        final StringBuilder str = new StringBuilder();
        plan.timeSpecifiers().forEach(time ->
            plan.getActionSet(time).forEach(a ->
                str.append(String.format("%0" + timeSpecifierSize + "d: (%" + actionSize + "s) [%d]%n",
                    time, this.toShortString(a), ((int) a.getDuration().getValue())))));
        return str.toString();
    }

    /**
     * Returns a string representation of a fluent.
     *
     * @param fluent the fluent.
     * @return a string representation of the specified fluent.
     */
    public String toString(final Fluent fluent) {
        return this.toString(fluent, this.predicateSymbols);
    }

    /**
     * Returns a string representation of a task.
     *
     * @param task the task.
     * @return a string representation of the specified task.
     */
    public String toString(final Task task) {
        return this.toString(task, this.taskSymbols);
    }

    /**
     * Returns a string representation of a numeric fluent.
     *
     * @param fluent the numeric fluent..
     * @return a string representation of the specified numeric fluent..
     */
    public String toString(final NumericFluent fluent) {
        return this.toString(fluent, this.functionSymbols);
    }

    /**
     * Returns a string representation of an atomic formula.
     *
     * @param formula the formula.
     * @param symbols the symbols to use.
     * @return a string representation of the specified expression.
     */
    private String toString(final AbstractAtomicFormula formula, final List<String> symbols) {
        final StringBuffer str = new StringBuffer();
        str.append("(");
        str.append(symbols.get(formula.getSymbol()));
        for (Integer arg : formula.getArguments()) {
            str.append(" ");
            str.append(this.constantSymbols.get(arg));
        }
        str.append(")");
        return str.toString();
    }



    /**
     * Returns a string representation of a closed world state.
     *
     * @param state the state.
     * @return a string representation of the specified expression.
     */
    public final String toString(final State state) {
        final StringBuilder str = new StringBuilder("(and");
        for (int i = state.nextSetBit(0); i >= 0; i = state.nextSetBit(i + 1)) {
            str.append(" ");
            str.append(this.toString(this.getRelevantFluents().get(i)));
            str.append("\n");
        }
        for (NumericVariable variable : state.getNumericVariables()) {
            str.append(" ");
            str.append(this.toString(variable));
            str.append("\n");
        }
        str.append(")");
        return str.toString();
    }

    /******************************************************************************************************************/
    /* Methods for logging
    */

    /**
     * This method log the instantiation process.
     */
    private void log(int trace) {

        if (this.traceLevel == trace) {

            StringBuilder str = new StringBuilder();
            switch (trace) {
                case 1:
                    this.printTableOfTypes(str);
                    str.append(System.lineSeparator());
                    this.printTableOfConstants(str);
                    str.append(System.lineSeparator());
                    this.printTableOfPredicates(str);
                    str.append(System.lineSeparator());
                    if (this.requirements.contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
                        this.printTableOfFunctions(str);
                        str.append(System.lineSeparator());
                    }
                    if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                        this.printTableOfTasks(str);
                        str.append(System.lineSeparator());
                    }
                    this.printIntInitialState(str);
                    str.append(System.lineSeparator());
                    this.printIntGoal(str);
                    str.append(System.lineSeparator());
                    if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                        this.printIntInitialState(str);
                        str.append(System.lineSeparator());
                    }
                    this.printIntActions(str);
                    str.append(System.lineSeparator());
                    if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                        this.printIntMethods(str);
                        str.append(System.lineSeparator());
                    }
                    break;
                case 2:
                    this.printTableOfTypes(str);
                    str.append(System.lineSeparator());
                    this.printTableOfConstants(str);
                    str.append(System.lineSeparator());
                    this.printTableOfInertia(str);
                    str.append(System.lineSeparator());
                    this.printIntActions(str);
                    str.append(System.lineSeparator());
                    break;
                case 3:
                    this.printIntActions(str);
                    str.append(System.lineSeparator());
                    if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                        this.printIntMethods(str);
                        str.append(System.lineSeparator());
                        this.printIntInitialTaskNetwork(str);
                        str.append(System.lineSeparator());
                    }
                    this.printIntGoal(str);
                    str.append(System.lineSeparator());
                    break;
                case 4:
                    str.append("\nFinal actions:\n");
                    for (Action action : this.actions) {
                        str.append(this.toString(action));
                        str.append(System.lineSeparator());
                    }

                    if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
                        str.append("\nFinal methods:\n");
                        for (Method method : this.methods) {
                            str.append(this.toString(method));
                            str.append(System.lineSeparator());
                        }
                    }

                    str.append("Final initial state:\n");
                    str.append(this.toString(this.initialState));

                    str.append("\nFinal goal state:\n");
                    if (this.goal == null) {
                        str.append("goal can be simplified to FALSE");
                    } else if (this.goal.isEmpty()) {
                        str.append("goal can be simplified to TRUE");
                    } else {
                        str.append(this.toString(this.goal));
                    }
                    str.append(System.lineSeparator());

                    if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {

                        str.append("Final initial task network:\n");
                        str.append(this.toString(this.initialTaskNetwork));
                        str.append(System.lineSeparator());

                        str.append("\nTable of task resolvers:\n");
                        for (int ti = 0; ti < this.taskResolvers.size(); ti++) {
                            str.append(ti);
                            str.append(": ");
                            str.append(this.toString(this.relevantTasks.get(ti)));
                            str.append(":");
                            final List<Integer> resolvers = this.taskResolvers.get(ti);
                            for (int ri = 0; ri < resolvers.size(); ri++) {
                                str.append(" ");
                                str.append(resolvers.get(ri));
                            }
                            str.append("\n");
                        }
                    }
                    break;
                default:
                    // do nothing
            }

            System.out.print(str.toString());
            str.setLength(0);
        }


    }

    /**
     * Print the table of types.
     *
     * @param str the string builder used to print.
     */
    private void printTableOfTypes(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** TYPE SYMBOLS                                           **\n");
        str.append("************************************************************\n\n");
        for (int i = 0; i < this.typeSymbols.size(); i++) {
            str.append(i).append(": ");
            str.append(this.typeSymbols.get(i));
            str.append(":");
            Set<Integer> domain = this.typeDomains.get(i);
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
    private void printTableOfConstants(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** CONSTANTS SYMBOLS                                      **\n");
        str.append("************************************************************\n\n");
        for (int i = 0; i < this.constantSymbols.size(); i++) {
            str.append(i).append(": ");
            str.append(this.constantSymbols.get(i));
            str.append(System.lineSeparator());
        }
    }

    /**
     * Print the table of predicates.
     *
     * @param str the string builder used to print.
     */
    private void printTableOfPredicates(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** PREDICATES SYMBOLS                                     **\n");
        str.append("************************************************************\n\n");
        for (int i = 0; i < this.predicateSymbols.size(); i++) {
            final String predicate = this.predicateSymbols.get(i);
            str.append(i).append(": ");
            str.append(predicate);
            str.append(" :");
            for (int j = 0; j < this.typeOfPredicateArguments.get(i).size(); j++) {
                str.append(" ");
                str.append(this.typeSymbols.get(this.typeOfPredicateArguments.get(i).get(j)));
            }
            str.append(System.lineSeparator());
        }
    }

    /**
     * Print the table of functions.
     *
     * @param str the string builder used to print.
     */
    private void printTableOfFunctions(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** FUNCTION SYMBOLS                                       **\n");
        str.append("************************************************************\n\n");
        for (int i = 0; i < this.functionSymbols.size(); i++) {
            final String predicate = this.functionSymbols.get(i);
            str.append(i).append(": ");
            str.append(predicate);
            str.append(":");
            for (int j = 0; j < this.typeOfFunctionArguments.get(i).size(); j++) {
                str.append(" ");
                str.append(this.typeSymbols.get(this.typeOfFunctionArguments.get(i).get(j)));
            }
            str.append(System.lineSeparator());
        }
        str.append(System.lineSeparator());
    }

    /**
     * Print the table of tasks.
     *
     * @param str the string builder used to print.
     */
    private void printTableOfTasks(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** TASKS SYMBOLS                                          **\n");
        str.append("************************************************************\n\n");
        for (int i = 0; i < this.taskSymbols.size(); i++) {
            final String predicate = this.taskSymbols.get(i);
            str.append(i);
            str.append(": ");
            str.append(predicate);
            str.append(" :");
            for (int j = 0; j < this.typeOfTaskArguments.get(i).size(); j++) {
                str.append(" ");
                str.append(this.typeSymbols.get(this.typeOfTaskArguments.get(i).get(j)));
            }
            str.append(System.lineSeparator());
        }
        str.append(System.lineSeparator());
    }

    /**
     * Print the int initial state.
     *
     * @param str the str
     */
    private void printIntInitialState(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** INITIAL STATE                                          **\n");
        str.append("************************************************************\n\n(and");
        for (IntExpression literal : this.intInitialState) {
            str.append(" ");
            str.append(this.toString(literal));
            str.append(System.lineSeparator());
        }
    }

    /**
     * Print the int goal state.
     *
     * @param str the str
     */
    private void printIntGoal(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** GOAL                                                   **\n");
        str.append("************************************************************\n\n");
        str.append(this.toString(this.intGoal));
        str.append(System.lineSeparator());
    }

    /**
     * Print the int initial task network.
     *
     * @param str the str
     */
    private void printIntInitialTaskNetwork(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** INITIAL TASK NETWORK                                   **\n");
        str.append("************************************************************\n\n");
        str.append(this.toString(this.intInitialTaskNetwork));
        str.append(System.lineSeparator());
    }

    /**
     * Print the table of int actions.
     *
     * @param str the string builder used to print.
     */
    private void printIntActions(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** ACTIONS                                                **\n");
        str.append("************************************************************\n\n");
        for (IntAction action : this.intActions) {
            str.append(this.toString(action));
            str.append(System.lineSeparator());
        }
    }

    /**
     * Print the table of int methods.
     *
     * @param str the string builder used to print.
     */
    private void printIntMethods(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** METHODS                                                **\n");
        str.append("************************************************************\n\n");
        for (IntMethod method : this.intMethods) {
            str.append(this.toString(method));
            str.append(System.lineSeparator());
        }
    }

    /**
     * Print the table of inertia.
     *
     * @param str the string builder used to print.
     */
    private void printTableOfInertia(StringBuilder str) {
        str.append("************************************************************\n");
        str.append("** INERTIA                                                **\n");
        str.append("************************************************************\n\n");
        for (int i = 0; i < this.predicateSymbols.size(); i++) {
            final String predicate = this.predicateSymbols.get(i);
            str.append(i).append(": ");
            str.append(predicate);
            str.append(" : ");
            str.append(this.inertia.get(i));
            str.append("\n");
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
                && !errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty()) {
                System.out.println(errorManager.getMessages());
                System.exit(0);
            }
            if (!errorManager.getMessages(Message.Type.PARSER_WARNING).isEmpty()) {
                //System.out.println(errorManager.getMessages());
            }

            // Encodes and instantiates the problem in a compact representation

            try {
                System.out.println(" * Encoding [" + problem + "]" + "...");
                final IProblem pb = new IProblem(parser.getDomain(), parser.getProblem());
                pb.instantiate(traceLevel);



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
