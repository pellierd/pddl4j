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

    private int dummyPredicateCounter = 0;
    private IntExpression createDummyPredicate() {
        this.predicateSymbols.add("^M"+this.dummyPredicateCounter);
        this.dummyPredicateCounter++;
        final IntExpression atom = new IntExpression(PDDLConnective.ATOM);
        atom.setPredicate(this.predicateSymbols.size() - 1);
        return atom;

    }

    private int monitoringActionCounter = 0;

    private IntAction createMonitoringAction() {
        IntAction monitoring = new IntAction("monitoring_action" + this.monitoringActionCounter, 0);
        this.monitoringActionCounter++;
        return monitoring;
    }

    /**
     * Instantiate the problem.
     */
    public void instantiate(int tracelevel) {

        this.traceLevel = tracelevel;
        this.log(1);

        this.collectInertiaInformation();
        this.createPredicatesTables();

        // Infer the type from the unary inertia
        if (!this.requirements.contains(PDDLRequireKey.TYPING)) {
            // Collect the inertia information from the actions of the problem.

            // Infer the type from the unary inertia
            List<Set<Integer>> inferredDomains = this.inferTypesFromInertia();
            // Update action with the inferred types
            this.updateActionWithInferredTypes(inferredDomains);
            this.log(2);
        }

        // HACK for durative action very inefficient
        if (this.requirements.contains(PDDLRequireKey.DURATIVE_ACTIONS)) {
            this.expandTemporalActions();
        }
        for (IntAction a : this.intActions) {
            System.out.println(this.toString(a));
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Instantiate the actions
        System.out.println("Actions instantiation..." + this.intActions.size());
        this.instantiateActions();
        // Extract the ground inertia from the set of instantiated actions
        this.collectGroundInertia();
        // Simplify the actions based in the ground inertia
        System.out.println("Simply actions...");
        this.simplyActionsWithGroundInertia();

        System.out.println("Expand conditional effects..."+this.intActions.size());
        List<IntAction> simplifiedActions = new ArrayList<>();
       /* for (IntAction a : this.intActions) {
            simplifiedActions.addAll(a.expandConditionalEffect(this));
        }
        this.intActions.clear();
        this.intActions.addAll(simplifiedActions);*/

        System.out.println("Expand disjunctive preconditions ...");
        simplifiedActions.clear();
        for (IntAction a : this.intActions) {
            simplifiedActions.addAll(a.expandDisjunctivePrecondition(this));

        }
        this.intActions.clear();
        this.intActions.addAll(simplifiedActions);

        // Expand the quantified expression in the goal
        this.intGoal.expandQuantifiedExpression(this.typeDomains, this);
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
                //a.getEffects().toCNF();
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
            for (final IntAction a : actions) {
                if (a.arity() > 0) {

                    int index = -inertia.getArguments()[0] - 1;

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
                    final IntAction a1 = new IntAction(a);
                    a1.setTypeOfParameter(index, ti);
                    this.replace(a1.getPreconditions(), inertia, PDDLConnective.TRUE, ti, ts);
                    this.replace(a1.getEffects(), inertia, PDDLConnective.TRUE, ti, ts);
                    if (!a1.getPreconditions().getConnective().equals(PDDLConnective.FALSE)
                        && !a1.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                        newActions.add(a1);
                    }

                    final IntAction a2 = new IntAction(a);
                    a2.setTypeOfParameter(index, ts);
                    this.replace(a2.getPreconditions(), inertia, PDDLConnective.FALSE, ti, ts);
                    this.replace(a2.getEffects(), inertia, PDDLConnective.FALSE, ti, ts);

                    if (!a2.getPreconditions().getConnective().equals(PDDLConnective.FALSE)
                        && !a2.getEffects().getConnective().equals(PDDLConnective.FALSE)) {
                        newActions.add(a2);
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
                if (!domains.get(exp.getPredicate()).isEmpty()) {
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
        action.getPreconditions().expandQuantifiedExpression(this.typeDomains, this);
        action.getPreconditions().simplify();
        if (!action.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
            action.getEffects().expandQuantifiedExpression(this.typeDomains, this);
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
                precond.substitute(varIndex, value, this);
                if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntExpression effects = new IntExpression(action.getEffects());
                    effects.substitute(varIndex, value, this);
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
                            duration.substitute(varIndex, value, this);
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
                tasksCopy.substitute(varIndex, value, this);
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
            method.getPreconditions().expandQuantifiedExpression(this.typeDomains, this);
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
                copy.getPreconditions().substitute(var, cons, this);
                copy.getTask().substitute(var, cons, this);
                copy.getSubTasks().substitute(var, cons, this);
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

                preconditionCopy.substitute(varIndex, value, this);
                if (!preconditionCopy.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntMethod copy = new IntMethod(method.getName(), arity);
                    copy.setPreconditions(preconditionCopy);
                    copy.setOrderingConstraints(new IntExpression(method.getOrderingConstraints()));

                    final IntExpression taskCopy = new IntExpression(method.getTask());
                    taskCopy.substitute(varIndex, value, this);
                    copy.setTask(taskCopy);

                    final IntExpression subTasksCopy = new IntExpression(method.getSubTasks());
                    subTasksCopy.substitute(varIndex, value, this);
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
                case FN_ATOM:
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
        return this.toString(expression, "");
    }

    /**
     * Returns a string representation of a expression.
     *
     * @param expression the expression.
     * @param offset  the string offset for the expression alignment.
     * @return a string representation of the specified expression.
     */
    private String toString(final IntExpression expression, final String offset) {
        return this.toString(expression, offset, " ");
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
                String offset = baseOffset + "  ";
                str.append("(");
                str.append(expression.getConnective().getImage());
                str.append(" ");
                if (!expression.getChildren().isEmpty()) {
                    for (int i = 0; i < expression.getChildren().size() - 1; i++) {
                        str.append(this.toString(expression.getChildren().get(i), offset));
                        str.append("\n");
                        str.append(offset);
                    }
                    str.append(this.toString(expression.getChildren()
                        .get(expression.getChildren().size() - 1), offset));
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

    private List<List<IntMatrix>> predicatesTables;
    /**
     * This method creates the predicates predicatesTables used to simplify atomic expression.
     *
     */
    private void createPredicatesTables() {
        final int tableSize = this.constantSymbols.size();
        final int nbPredicate = this.predicateSymbols.size();
        this.predicatesTables = new ArrayList<>(nbPredicate);
        for (final List<Integer> arguments : this.typeOfPredicateArguments) {
            final int arity = arguments.size();
            final int nbTables = (int) Math.pow(2, arity);
            final List<IntMatrix> pTables = new ArrayList<>(nbTables);
            for (int j = 0; j < nbTables; j++) {
                final int dimension = Integer.bitCount(j);
                pTables.add(new IntMatrix(tableSize, dimension));
            }
            this.predicatesTables.add(pTables);
        }

        for (IntExpression fact : this.intInitialState) {
            if (fact.getConnective().equals(PDDLConnective.NOT)) {
                fact = fact.getChildren().get(0);
            }
            if (fact.getConnective().equals(PDDLConnective.ATOM)) {
                final int arity = this.typeOfPredicateArguments.get(fact.getPredicate()).size();
                final List<IntMatrix> pTables = this.predicatesTables.get(fact.getPredicate());
                final int[] set = new int[arity];
                final int[] args = fact.getArguments();
                for (final IntMatrix intMatrix : pTables) {
                    int indexSize = 0;
                    for (int aSet : set) {
                        if (aSet == 1) {
                            indexSize++;
                        }
                    }
                    final int[] index = new int[indexSize];
                    int j = 0;
                    for (int i = 0; i < set.length; i++) {
                        if (set[i] == 1) {
                            index[j] = args[i];
                            j++;
                        }
                    }
                    intMatrix.increment(index);
                    this.incrementMask(set);
                }
            }
        }
    }

    /**
     * Return an integer representation of the specified array of integer. For example, if
     * <code>mask = [0, 1, 1]</code> then the method will return 3.
     *
     * @param mask an array of integer that can only contain 0 or 1.
     * @return the integer representation of the specified array.
     */
    private int toInt(final int[] mask) {
        final int len = mask.length;
        if (len > 0) {
            int res = mask[0];
            for (int i = 1; i < len; i++) {
                res = res << 1 | mask[i];
            }
            return res;
        }
        return 0;
    }

    private int[] incrementMask(final int[] set) {
        boolean overflow = false;
        for (int i = set.length - 1; i >= 0; i--) {
            if (set[i] == 0) {
                set[i] = 1;
                break;
            } else {
                set[i] = 0;
                overflow = i == 0;
            }
        }
        return overflow ? null : set;
    }

    /**
     * This method simplifies an atomic specified expression. Two cased must be considered:
     * <ul>
     * <li>1. If the expression is a positive inertia and the number of unifying ground instances of
     * the specified expression that are contained in the initial state is equal to 0 then the
     * expression is simplified to FALSE.</li>
     * <li>2. If the expression is a negative inertia and then the number of all possible
     * type-consistent ground instances of the specified expression then the expression is
     * simplified to TRUE.
     * </ul>
     *
     * @param exp the atomic expression to simplify.
     */
    public void simplyAtom(final IntExpression exp) {
        if (this.predicatesTables == null) return;
        final int predicate = exp.getPredicate();
        // Compute the mask i.e., the vector used to indicate where the constant are located in the
        // atomic expression.
        int indexSize = 0;
        final int[] args = exp.getArguments();
        final int[] mask = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] >= 0) {
                mask[i] = 1;
                indexSize++;
            }
        }
        // Compute the index to access to the predicates table and compute the product (max) of the
        // tableOfDomains of the non instantiated arguments of the atomic expression.
        int j = 0;
        int max = 1;
        final int[] index = new int[indexSize];
        final List<Integer> predArg = this.typeOfPredicateArguments.get(predicate);
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 0) {
                max *= this.typeDomains.get(predArg.get(i)).size();
            } else {
                index[j] = args[i];
                j++;
            }

        }
        // Get the number of unifying ground instances of the specified expression that are
        // contained in the initial state.
        final int n = this.predicatesTables.get(predicate).get(this.toInt(mask)).get(index);
        // CASE 1: If the expression is a positive inertia and the number of unifying ground
        // instances of the specified expression that are contained in the initial state is equal to
        // 0 then the expression is simplified to FALSE.
        final Inertia inertia = this.inertia.get(predicate);
        if ((inertia.equals(Inertia.POSITIVE) || inertia.equals(Inertia.INERTIA)) && n == 0) {
            exp.setConnective(PDDLConnective.FALSE);
            //System.out.println("ATOM SIMPLY");
        } else if ((inertia.equals(Inertia.NEGATIVE) || inertia.equals(Inertia.INERTIA)) && max == n) {
            // CASE 2: If the expression is a negative inertia and then the number of all possible
            // type-consistent ground instances of the specified expression then the expression is
            // simplified to TRUE.
            exp.setConnective(PDDLConnective.TRUE);
            //System.out.println("ATOM SIMPLY");
        }
    }


    /**
     * Expands the quantified expressions contained in a specified expression.
     */
    private void expandQuantifiedExpression(IntExpression exp, boolean simplifyAtom) {
        simplifyAtom = false;
        switch (exp.getConnective()) {
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    // Remove quantified expression where the domain of the quantified variable is empty
                    if ((ei.getConnective().equals(PDDLConnective.FORALL)
                        || ei.getConnective().equals(PDDLConnective.EXISTS))
                        && this.typeDomains.get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    this.expandQuantifiedExpression(ei, simplifyAtom);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    //if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                    //    exp.setConnective(PDDLConnective.FALSE);
                    //}
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    // Remove quantified expression where the domain of the quantified variable is empty
                    if ((ei.getConnective().equals(PDDLConnective.FORALL)
                        || ei.getConnective().equals(PDDLConnective.EXISTS))
                        && this.typeDomains.get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    this.expandQuantifiedExpression(ei, simplifyAtom);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    //if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                    //    exp.setConnective(PDDLConnective.TRUE);
                    //}
                }
                break;
            case FORALL:
                Set<Integer> constants = this.typeDomains.get(exp.getType());
                IntExpression qExp = exp.getChildren().get(0);
                int var = exp.getVariable();
                exp.setConnective(PDDLConnective.AND);
                exp.getChildren().clear();
                Iterator<Integer> it = constants.iterator();
                while (it.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    int cons = it.next();
                    IntExpression copy = new IntExpression(qExp);
                    this.substitute(copy, var, cons, simplifyAtom);
                    exp.getChildren().add(copy);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    //if (copy.getConnective().equals(PDDLConnective.FALSE)) {
                    //    exp.setConnective(PDDLConnective.FALSE);
                    //}
                }
                this.expandQuantifiedExpression(exp, simplifyAtom);
                break;
            case EXISTS:
                constants = this.typeDomains.get(exp.getType());
                qExp = exp.getChildren().get(0);
                var = exp.getVariable();
                exp.setConnective(PDDLConnective.OR);
                exp.getChildren().clear();
                it = constants.iterator();
                while (it.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    int cons = it.next();
                    IntExpression copy = new IntExpression(qExp);
                    this.substitute(copy, var, cons, simplifyAtom);
                    exp.getChildren().add(copy);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    //if (copy.getConnective().equals(PDDLConnective.TRUE)) {
                    //    exp.setConnective(PDDLConnective.TRUE);
                    //}
                }
                this.expandQuantifiedExpression(exp, simplifyAtom);
                break;

            case AT_START:
            case AT_END:
            case NOT:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
                this.expandQuantifiedExpression(exp.getChildren().get(0), simplifyAtom);
                break;
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case WHEN:
                this.expandQuantifiedExpression(exp.getChildren().get(0), simplifyAtom);
                this.expandQuantifiedExpression(exp.getChildren().get(1), simplifyAtom);
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.expandQuantifiedExpression(exp.getChildren().get(0), simplifyAtom);
                this.expandQuantifiedExpression(exp.getChildren().get(1), simplifyAtom);
                this.expandQuantifiedExpression(exp.getChildren().get(3), simplifyAtom);
                break;
            case ATOM:
                if (simplifyAtom) {
                    this.simplyAtom(exp);
                }
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
     * Substitutes all occurrence of a specified variable into an expression by a constant.
     *
     * @param var  the variable.
     * @param cons the constant.
     */
    private void substitute(IntExpression exp, final int var, final int cons, boolean simplifyAtom) {
        switch (exp.getConnective()) {
            case ATOM:
                boolean updated = false;
                int[] args = exp.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                        updated = true;
                    }
                }
                if (updated && simplifyAtom) {
                    this.simplyAtom(exp);
                }
                break;
            case TASK:
            case FN_HEAD:
                args = exp.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                    }
                }
                break;

            case EQUAL_ATOM:
                args = exp.getArguments();
                // Get and substitute the first argument
                final int arg1 = args[0];
                if (arg1 == var) {
                    args[0] = cons;
                }
                // Get and substitute the second argument
                final int arg2 = args[1];
                if (arg2 == var) {
                    args[1] = cons;
                }
                // The equality is TRUE: arg1 and arg2 are the same variable or the same constant
                if (arg1 == arg2) {
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (arg1 >= 0 && arg2 >= 0) {
                    // The equality is ground and the equality is FALSE because arg1 != arg2
                    exp.setConnective(PDDLConnective.FALSE);
                }
                break;
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    this.substitute(ei, var, cons, simplifyAtom);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        exp.setConnective(PDDLConnective.FALSE);
                    }
                }
                break;
            case OR:
                i = exp.getChildren().iterator();
                while (i.hasNext() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    this.substitute(ei, var, cons, simplifyAtom);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                this.substitute(neg, var, cons, simplifyAtom);
                if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                    exp.setConnective(PDDLConnective.TRUE);
                }
                break;
            case WHEN:
                for (IntExpression ei : exp.getChildren()) {
                    this.substitute(ei, var, cons, simplifyAtom);
                }
                break;
            default:
        }
    }

    /**
     * Extract the subexpression having the timespecifier.
     *
     * Warning the time specidier must be move inward
     */
    private void extract(IntExpression exp, PDDLConnective timeSpecifier) {
        switch (exp.getConnective()) {
            case OR:
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext()) {
                    IntExpression e = i.next();
                    this.extract(e, timeSpecifier);
                    if (e.getConnective().equals(PDDLConnective.AND)
                        && e.getChildren().isEmpty()) {
                        i.remove();
                    }
                }
                break;
            case AT_END:
            case AT_START:
            case OVER_ALL:
                if (!exp.getConnective().equals(timeSpecifier)) {
                    exp.setConnective(PDDLConnective.AND);
                    exp.getChildren().clear();
                } else {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            default:

        }

    }

    /**
     * This method simplify a specified expression. The rules of simplification are as below:
     * <ul>
     * <li> not true eqv false </li>
     * <li> true ^ phi eqv phi </li>
     * <li> false ^ phi eqv false </li>
     * <li> true v phi eqv true </li>
     * <li> false v phi eqv false </li>
     * <li> not false eqv true </li>
     * <li> phi ^ phi eqv phi </li>
     * <li> phi v phi eqv phi </li>
     * <li> phi ^ not phi eqv false </li>
     * <li> phi v not phi eqv true </li>
     * <li> x = x eqv true </li>
     * <li> x = y eqv false </li>
     * </ul>
     *
     */
    private void simplify(IntExpression exp) {
        switch (exp.getConnective()) {
            case ATOM:
                break;
            case FN_HEAD:
                break;
            case EQUAL_ATOM:
                int[] args = exp.getArguments();
                // Get and substitute the first argument
                final int arg1 = args[0];
                // Get and substitute the second argument
                final int arg2 = args[1];
                if (arg1 == arg2) {
                    // The equality is TRUE: arg1 and arg2 are the same variable or the same constant
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (arg1 >= 0 && arg2 >= 0) {
                    // The equality is ground and the equality is FALSE because arg1 != arg2
                    exp.setConnective(PDDLConnective.FALSE);
                }
                break;
            case AND:
                int i = 0;
                while (i < exp.getChildren().size() && exp.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = exp.getChildren().get(i);
                    this.simplify(ei);
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        // If a child expression is FALSE, the whole conjunction becomes FALSE.
                        exp.setConnective(PDDLConnective.FALSE);
                    } else if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        // If a child expression is TRUE, we can remove the child expression.
                        exp.getChildren().remove(i);
                    } else if (ei.getConnective().equals(PDDLConnective.AND)) {
                        // If the child expression to add is a conjunction, we can simplify the expression by
                        exp.getChildren().remove(i); // removing the inner conjunction.
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size() && exp.getConnective().equals(PDDLConnective.AND)) {
                            final IntExpression ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(PDDLConnective.FALSE)) {
                                exp.setConnective(PDDLConnective.FALSE);
                            } else if (!ej.getConnective().equals(PDDLConnective.TRUE)) {
                                exp.getChildren().add(i + added, ej);
                                added++;
                            }
                            j++;
                        }
                        i += added;
                    } else if (ei.getConnective().equals(PDDLConnective.WHEN)) {
                        // Simplification of the conditional expression.
                        final IntExpression antecedent = ei.getChildren().get(0);
                        final IntExpression consequent = ei.getChildren().get(1);
                        // If the antecedent of a conditional effect becomes FALSE , the conditional
                        // effect is removed from the action. In this case, the effect is never applicable
                        // because it requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(PDDLConnective.FALSE)) {
                            exp.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional
                            // effect becomes unconditional.
                            if (consequent.getConnective().equals(PDDLConnective.AND)) {
                                exp.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && exp.getConnective().equals(PDDLConnective.AND)) {

                                    final IntExpression ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(PDDLConnective.FALSE)) {
                                        exp.setConnective(PDDLConnective.FALSE);
                                    } else if (!ej.getConnective().equals(PDDLConnective.TRUE)) {
                                        exp.getChildren().add(i + added, ej);
                                        added++;
                                    }
                                    j++;
                                }
                                i += added;
                            } else {
                                exp.getChildren().set(i, consequent);
                                i++;
                            }
                        } else if (consequent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the consequent of a conditional effect becomes TRUE, the conditional
                            // effect is removed because it does not lead to any state transition.
                            exp.getChildren().remove(i);
                        }   else if (consequent.getConnective().equals(PDDLConnective.FALSE)) {
                            // If the consequent of a conditional effect becomes TRUE, the conditional
                            // effect is removed because it does not lead to any state transition.
                            exp.getChildren().remove(i);
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                }
                // Finally, if the conjunction is empty, the expression becomes TRUE.
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            case OR:
                i = 0;
                while (i < exp.getChildren().size() && exp.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = exp.getChildren().get(i);
                    this.simplify(ei);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        exp.setConnective(PDDLConnective.TRUE);
                    } else if (ei.getConnective().equals(PDDLConnective.OR)) {
                        // If the child expression to addValue is a disjunction, we can simplify the expression by
                        // removing the inner disjunction.
                        exp.getChildren().remove(i);
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size() && exp.getConnective().equals(PDDLConnective.OR)) {
                            final IntExpression ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(PDDLConnective.TRUE)) {
                                exp.setConnective(PDDLConnective.TRUE);
                            } else if (!ej.getConnective().equals(PDDLConnective.FALSE)) {
                                exp.getChildren().add(i + added, ej);
                                added++;
                            }
                            j++;
                        }
                        i += added;
                    } else if (ei.getConnective().equals(PDDLConnective.WHEN)) {
                        // Simplification of the conditional expression.
                        final IntExpression antecedent = ei.getChildren().get(0);
                        final IntExpression consequent = ei.getChildren().get(1);
                        // If the antecedent of a conditional effect becomes FALSE , the conditional effect is
                        // removed from the action. In this case, the effect is never applicable because it
                        // requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(PDDLConnective.FALSE)) {
                            exp.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional effect
                            // becomes unconditional.
                            if (consequent.getConnective().equals(PDDLConnective.OR)) {
                                exp.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && exp.getConnective().equals(PDDLConnective.OR)) {

                                    final IntExpression ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(PDDLConnective.TRUE)) {
                                        exp.setConnective(PDDLConnective.TRUE);
                                    } else if (!ej.getConnective().equals(PDDLConnective.FALSE)) {
                                        exp.getChildren().add(i + added, ej);
                                        added++;
                                    }
                                    j++;
                                }
                                i += added;
                            } else {
                                exp.getChildren().set(i, consequent);
                                i++;
                            }
                        } else if (consequent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the consequent of a conditional effect becomes TRUE, the conditional
                            // effect is removed because it does not lead to any state transition.
                            exp.getChildren().remove(i);
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                }
                // Finally, if the disjunction is empty, the expression becomes TRUE.
                if (exp.getChildren().isEmpty()) {
                    exp.setConnective(PDDLConnective.TRUE);
                } else if (exp.getChildren().size() == 1) {
                    exp.affect(exp.getChildren().get(0));
                } else {
                    final Iterator<IntExpression> it = exp.getChildren().iterator();
                    while (it.hasNext()) {
                        if (it.next().getConnective().equals(PDDLConnective.FALSE)) {
                            it.remove();
                        }
                    }
                    if (exp.getChildren().isEmpty()) {
                        exp.setConnective(PDDLConnective.FALSE);
                    }
                }
                break;
            case FORALL:
            case EXISTS:
            case UMINUS:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
                this.simplify(exp.getChildren().get(0));
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                simplify(neg);
                if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                    exp.setConnective(PDDLConnective.FALSE);
                } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                    exp.setConnective(PDDLConnective.TRUE);
                }
                break;
            case WHEN:
                this.simplify(exp.getChildren().get(0));
                this.simplify(exp.getChildren().get(1));
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
                this.simplify(exp.getChildren().get(0));
                this.simplify(exp.getChildren().get(1));
                break;
            case F_EXP_T:
            case F_EXP:
                if (!exp.getChildren().isEmpty()) {
                    this.simplify(exp.getChildren().get(0));
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.simplify(exp.getChildren().get(0));
                this.simplify(exp.getChildren().get(1));
                this.simplify(exp.getChildren().get(2));
                break;
            case NUMBER:
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
     * Expands the temporal actions.
     */
    private void expandTemporalActions() {
        List<IntAction> expandedActions = new ArrayList<>();

        for (IntAction a : this.intActions) {
            System.out.println("******************************************************");
            System.out.println(this.toString(a));

            this.expandQuantifiedExpression(a.getPreconditions(), true);
            a.getPreconditions().moveTimeSpecifierInward();
            a.getPreconditions().moveNegationInward();

            System.out.println("*** Precondition ***");
            System.out.println(this.toString(a.getPreconditions()));

            final IntExpression startPrecondition = new IntExpression(a.getPreconditions());
            this.extract(startPrecondition, PDDLConnective.AT_START);
            this.simplify(startPrecondition);
            startPrecondition.toDisjunctiveNormalForm(this);

            System.out.println("*** At start precondition ***");
            System.out.println(this.toString(startPrecondition));

            final IntExpression endPrecondition = new IntExpression(a.getPreconditions());
            this.extract(endPrecondition, PDDLConnective.AT_END);
            this.simplify(endPrecondition);
            endPrecondition.toDisjunctiveNormalForm(this);

            System.out.println("*** At end precondition ***");
            System.out.println(this.toString(endPrecondition));

            final IntExpression overAllPrecondition = new IntExpression(a.getPreconditions());
            this.extract(overAllPrecondition, PDDLConnective.OVER_ALL);
            System.out.println("*** Over all precondition AV Simplify ***");
            System.out.println(this.toString(overAllPrecondition));
            this.simplify(overAllPrecondition);
            overAllPrecondition.toDisjunctiveNormalForm(this);

            System.out.println("*** Over all precondition ***");
            System.out.println(this.toString(overAllPrecondition));


            // Expands the quantified expression on the effect of the action
            this.expandQuantifiedExpression(a.getEffects(), true);
            a.getEffects().moveTimeSpecifierInward();
            a.getEffects().moveNegationInward();
            a.getEffects().toConjunctiveNormalForm(this);
            //this.simplify(a.getEffects());

            System.out.println("*** EFFECT ***");
            System.out.println(this.toString(a.getEffects()));

            try {
                System.out.println("Press enter...");
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // The list of monitoring action need to deal with over all condition in conditional effect
            final List<IntAction> monitoringActions = new ArrayList<>();
            // The effect of the start action
            final IntExpression startEffect = new IntExpression(PDDLConnective.AND);
            // The effect of the end action
            final IntExpression endEffect = new IntExpression(PDDLConnective.AND);

            // Iterate over the effect of the action the action to initialize the start and end effect and the list of
            // monitoring actions needed to deal with over all condition in conditional effects.
            // We suppose that the effect is a conjunction of at_start or at_end or when.
            for (IntExpression effect : a.getEffects().getChildren()) {
                //System.out.println("EFFECT : "+ this.toString(effect));
                switch (effect.getConnective()) {
                    case AT_START:
                        startEffect.addChild(effect.getChildren().get(0));
                        break;
                    case AT_END:
                        endEffect.addChild(effect.getChildren().get(0));
                        break;
                    case WHEN:
                        // Extract the start effect condition of the conditional effect
                        final IntExpression ps = new IntExpression(effect.getChildren().get(0));
                        this.extract(ps, PDDLConnective.AT_START);
                        // Extract the end effect condition of the conditional effect
                        final IntExpression pe = new IntExpression(effect.getChildren().get(0));
                        this.extract(pe, PDDLConnective.AT_END);
                        // Extract the overall effect condition of the conditional effect
                        final IntExpression pi = new IntExpression(effect.getChildren().get(0));
                        this.extract(pi, PDDLConnective.OVER_ALL);
                        // Extract the start effect of the conditional effect
                        final IntExpression qs = new IntExpression(effect.getChildren().get(1));
                        this.extract(qs, PDDLConnective.AT_START);
                        // Extract the end effect of the conditional effect
                        final IntExpression qe = new IntExpression(effect.getChildren().get(1));
                        this.extract(qe, PDDLConnective.AT_END);


                        // CASE at start only in condition and at start only in effects
                        // We add the condition of the effect to the start action and the effect to the start action.
                        if (!ps.getChildren().isEmpty()
                                && pe.getChildren().isEmpty()
                                && pi.getChildren().isEmpty()
                                && !qs.getChildren().isEmpty()
                                && qe.getChildren().isEmpty()) {

                            IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            when.addChild(ps);
                            when.addChild(ps);
                            startEffect.addChild(when);
                        }

                        // CASE at end only in condition and at end only in effects
                        // We add the condition of the effect to the end action and the effect to the end action.
                        else if (ps.getChildren().isEmpty()
                                && !pe.getChildren().isEmpty()
                                && pi.getChildren().isEmpty()
                                && qs.getChildren().isEmpty()
                                && !qe.getChildren().isEmpty()) {

                            IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            when.addChild(pe);
                            when.addChild(qe);
                            endEffect.addChild(when);
                        }

                        // CASE at star and possibly at end but no overall in condition and at end in effects
                        else if (!ps.getChildren().isEmpty()
                                && pi.getChildren().isEmpty()
                                && !qe.getChildren().isEmpty()) {

                            // Create the conditional effect for the start action
                            final IntExpression startWhen = new IntExpression(PDDLConnective.WHEN);
                            startWhen.addChild(ps);
                            // Create the dummy predicate to memorize the effect at end
                            final IntExpression mps = this.createDummyPredicate();
                            startWhen.addChild(mps);
                            startEffect.addChild(startWhen);

                            // Create the conditional effect for the end action
                            final IntExpression endWhen = new IntExpression(PDDLConnective.WHEN);
                            if (pe.getChildren().isEmpty()) {
                                endWhen.addChild(mps);
                            } else {
                                final IntExpression and = new IntExpression(PDDLConnective.AND);
                                and.addChild(pe);
                                and.addChild(mps);
                                endWhen.addChild(and);
                            }
                            endWhen.addChild(endEffect);
                            endEffect.addChild(endWhen);
                        }

                        // CASE overall in condition with possibly no at start and no at end and at end in effect
                        // (when (and (at start ps) (over all pi) (at end pe)) (at end q))
                        else if (!pi.getChildren().isEmpty()
                                && qe.getChildren().isEmpty()) {

                            // Create the monitoring action with no precondition but effects of the form
                            // (when (and (Mpi) (not pi)) (not (Mpi)))
                            final IntAction monitoring = this.createMonitoringAction();
                            final IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            IntExpression and = new IntExpression(PDDLConnective.AND);
                            final IntExpression mpi = this.createDummyPredicate();
                            and.addChild(mpi);
                            final IntExpression notPi = new IntExpression(PDDLConnective.NOT);
                            notPi.addChild(pi);
                            notPi.moveNegationInward();
                            and.addChild(notPi);
                            when.addChild(and);
                            final IntExpression notMpi = new IntExpression(PDDLConnective.NOT);
                            notMpi.addChild(mpi);
                            when.addChild(notMpi);
                            monitoring.getEffects().addChild(when);
                            monitoringActions.add(monitoring);

                            // Create the start effect: (when ps (Mps))
                            IntExpression mps = this.createDummyPredicate();
                            if (!ps.getChildren().isEmpty()) {
                                IntExpression startWhen = new IntExpression(PDDLConnective.WHEN);
                                startWhen.addChild(ps);
                                startWhen.addChild(mps);
                                startEffect.addChild(startWhen);
                            } else {
                                startEffect.addChild(mps);
                            }

                            // Create the start effect: (when (and (Mps) (Mpi) pe) q).
                            IntExpression endWhen = new IntExpression(PDDLConnective.WHEN);
                            and = new IntExpression(PDDLConnective.AND);
                            and.addChild(mps);
                            and.addChild(mpi);
                            if (!pe.getChildren().isEmpty()) {
                                and.addChild(pe);
                            }
                            endWhen.addChild(and);
                            endWhen.addChild(qe);
                            endEffect.addChild(endWhen);
                        }
                    default:
                        // Do nothing
                }
            }
            //System.out.println("START PRECOND AVANT  SIM: ");
            //System.out.println(this.toString(startPrecondition));
            //this.simplify(startPrecondition);
            //System.out.println("START PRECOND APRES  SIM: ");
            //System.out.println(this.toString(startPrecondition));
            //start.

            //this.simplify(endPrecondition);
            //this.simplify(overallPrecondition);

            System.out.println("START EFFECT AVANT  SIM: ");
            System.out.println(this.toString(startEffect));
            this.simplify(startEffect);
            //startEffect.toConjunctiveNormalForm(this);
            System.out.println("START EFFECT APRES SIM: ");
            System.out.println(this.toString(startEffect));

            System.out.println("END EFFECT AVANT  SIM: ");
            System.out.println(this.toString(endEffect));
            this.simplify(endEffect);
            //endEffect.toConjunctiveNormalForm(this);
            System.out.println("END EFFECT APRES  SIM: ");
            System.out.println(this.toString(endEffect));

            // Create a start action for each conjunction of the start precondition
            for (IntExpression precondition : startPrecondition.getChildren()) {
                IntAction startAction = new IntAction(a.getName() + "_" + "start", a.arity());
                startAction.setCost(a.getCost());
                startAction.setDuration(new IntExpression(a.getDuration()));
                for (int i = 0; i < a.arity(); i++) {
                    startAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                }
                for (int i = 0; i < a.arity(); i++) {
                    startAction.setValueOfParameter(i, a.getValueOfParameter(i));
                }
                startAction.setPreconditions(new IntExpression(precondition));
                startAction.setEffects(new IntExpression(startEffect));
                expandedActions.add(startAction);

                System.out.println("*"+this.toString(startAction));
                try {
                    System.out.println("Press enter...");
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            for (IntExpression precondition : endPrecondition.getChildren()) {
                IntAction endAction = new IntAction(a.getName() + "_" + "end", a.arity());
                endAction.setCost(a.getCost());
                endAction.setDuration(new IntExpression(a.getDuration()));
                for (int i = 0; i < a.arity(); i++) {
                    endAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                }
                for (int i = 0; i < a.arity(); i++) {
                    endAction.setValueOfParameter(i, a.getValueOfParameter(i));
                }
                endAction.setPreconditions(precondition);
                endAction.setEffects(new IntExpression(endEffect));
                expandedActions.add(endAction);

                System.out.println("*"+this.toString(endAction));
                try {
                    System.out.println("Press enter...");
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.toString(overAllPrecondition));
            for (IntExpression precondition : overAllPrecondition.getChildren()) {
                if (!precondition.getConnective().equals(PDDLConnective.FALSE)) {
                    IntAction invAction = new IntAction(a.getName() + "_" + "inv", a.arity());
                    invAction.setCost(a.getCost());
                    invAction.setDuration(new IntExpression(a.getDuration()));
                    for (int i = 0; i < a.arity(); i++) {
                        invAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                    }
                    for (int i = 0; i < a.arity(); i++) {
                        invAction.setValueOfParameter(i, a.getValueOfParameter(i));
                    }
                    invAction.setPreconditions(precondition);
                    expandedActions.add(invAction);
                    System.out.println("*" + this.toString(invAction));
                    try {
                        System.out.println("Press enter...");
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            // Add the monitoring actions
            for (IntAction m : monitoringActions) {
                expandedActions.add(m);
                /*
                System.out.println(this.toString(m));
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }

        }
        this.intActions.clear();
        this.intActions.addAll(expandedActions);



    }

}
