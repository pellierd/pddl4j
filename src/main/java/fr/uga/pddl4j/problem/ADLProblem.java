package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.encoding.*;
import fr.uga.pddl4j.parser.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pellier on 01/12/2020.
 */
public class ADLProblem {

    /**
     *
     */
    public PDDLDomain domain;

    public PDDLProblem problem;

    /**
     * The set of requirements.
     */
    public Set<PDDLRequireKey> requirements;

    /**
     * The table of types.
     */
    public List<String> tableOfTypes;

    /**
     * The domain of associated to the type.
     */
    public List<Set<Integer>> tableOfDomains;

    /**
     * The table of constants.
     */
    public List<String> tableOfConstants;

    /**
     * The table of predicates.
     */
    public List<String> tableOfPredicates;

    /**
     * The table that contains the types of the arguments of the predicates.
     */
    public List<List<Integer>> tableOfTypedPredicates;

    /**
     * The table of the functions.
     */
    public List<String> tableOfFunctions;

    /**
     * The table that contains the types of the arguments of the functions.
     */
    public List<List<Integer>> tableOfTypedFunctions;

    /**
     * The table of tasks.
     */
    public List<String> tableOfTasks;

    /**
     * The table that contains the types of the arguments of the tasks.
     */
    public List<List<Integer>> tableOfTypedTasks;

    /**
     * The set primitive task symbols, i.e., the set of action symbol.
     */
    public Set<String> primitiveTaskSymbols;

    public Map<IntExpression, Double> intInitFunctionCost;

    public IntExpression intGoal;

    public Set<IntExpression> intInitPredicates;
    public IntTaskNetwork intTaskNetwork;
    public List<IntAction> intActions;
    public List<IntMethod> intMethods;

    /**
     * The set compund task symbols, i.e., the set of task symbols used in methods.
     */
    public Set<String> compoundTaskSymbols;

    public ADLProblem(final PDDLDomain domain, final PDDLProblem problem) {
        this.domain = domain;
        this.problem = problem;
        this.checkRequirements();
        this.init();
    }

    protected void init () {
        // Standardize the variables symbol contained in the domain
        this.domain.standardize();
        // Standardize the variables symbol contained in the domain
        this.problem.standardize();
        // Encode the types declared in the domain
        this.encodeTypes(domain);
        // Encode the constants declared in the domain and the objects of the problem
        this.encodeConstants(domain, problem);
        // Encode the type of the form (either t1 t2...) declared in the domain and the problem
        this.encodeEitherTypes(domain, problem);
        // Encode the predicates defined in the domain.
        this.encodePredicates(domain);
        // Encode the functions defined in the domain.
        this.encodeFunctions(domain);
        // Encode the tasks defined in the domain.
        this.encodeTasks(domain);
        // Encode actions in integer representation
        this.intActions = this.encodeActions(domain.getActions());
        // Encode method in integer representation
        this.intMethods = this.encodeMethods(domain.getMethods());

        // Encode the initial state in integer representation
        final Set<IntExpression> intInit = this.encodeInit(problem.getInit());
        // Create Map containing functions and associed cost from encoded initial state
        this.intInitFunctionCost = this.encodeFunctionCostInit(intInit);

        // Create Set containing integer representation of initial state without functions and associed cost
        this.intInitPredicates = this.removeFunctionCost(intInit);

        // Encode the goal in integer representation
        /*this.intGoal =  null;
        if (problem.getGoal() != null) {
            intGoal = this.encodeGoal(problem.getGoal());
        }

        // Encode the initial task network in integer representation
        if (this.requirements.contains(PDDLRequireKey.HIERARCHY)) {
            this.intTaskNetwork = this.encodeInitialTaskNetwork(problem.getInitialTaskNetwork());
        }*/
    }

    /**
     * Check that the domain and the problem are ADL otherwise the encoding is not
     */
    protected void checkRequirements() {
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
        accepted.add(PDDLRequireKey.METHOD_PRECONDITIONS);
        accepted.add(PDDLRequireKey.DURATIVE_ACTIONS);
        accepted.add(PDDLRequireKey.DURATION_INEQUALITIES);
        accepted.add(PDDLRequireKey.NUMERIC_FLUENTS);

        this.requirements = new LinkedHashSet<>();
        this.requirements.addAll(this.domain.getRequirements());
        this.requirements.addAll(this.problem.getRequirements());

        if (!accepted.containsAll(this.requirements)) {
            this.requirements.removeAll(accepted);
            StringBuilder str = new StringBuilder();
            str.append("Requirements not supported:");
            for (PDDLRequireKey requirement : this.requirements) {
                str.append(" ");
                str.append(requirement.getImage());
            }
            throw new IllegalArgumentException(str.toString());
        }
    }
    /**
     * Collects composite type, i.e., type of the form (either t1 t2), through a specified domain and
     * problem and creates their respective domain.
     *
     * @param domain  the domain.
     * @param problem the problem.
     */
    private void encodeEitherTypes(final PDDLDomain domain, final PDDLProblem problem) {
        // Collect the types from the predicates declaration
        for (PDDLNamedTypedList predicate : domain.getPredicates()) {
            this.encodeTypes(predicate.getArguments());
        }
        // Collect the types from the functions declaration
        for (PDDLNamedTypedList function : domain.getFunctions()) {
            this.encodeTypes(function.getArguments());
        }
        // Collect the types from the constraints declaration of the domain
        if (domain.getConstraints() != null) {
            this.encodeTypes(domain.getConstraints());
        }
        // Collect the types from the derived predicates
        for (PDDLDerivedPredicate axiom : domain.getDerivesPredicates()) {
            this.encodeTypes(axiom.getHead().getArguments());
            this.encodeTypes(axiom.getBody());
        }
        // Collect the type from the actions
        for (PDDLAction op : domain.getActions()) {
            this.encodeTypes(op.getParameters());
            if (op.getDuration() != null) {
                this.encodeTypes(op.getDuration());
            }
            this.encodeTypes(op.getPreconditions());
            this.encodeTypes(op.getEffects());
        }
        // Collect the types from the constraints declaration of the problem
        if (problem.getConstraints() != null) {
            this.encodeTypes(problem.getConstraints());
        }
        // Collect the types from the goal declaration of the problem
        if (problem.getGoal() != null) {
            this.encodeTypes(problem.getGoal());
        }

    }

    /**
     * Encodes all the types of a specified domain.
     *
     * @param domain the domain.
     */
    private void encodeTypes(final PDDLDomain domain) {
        final List<PDDLTypedSymbol> types = domain.getTypes();
        final int nbTypes = types.size();
        this.tableOfTypes = new ArrayList<>(nbTypes);
        this.tableOfDomains = new ArrayList<>(nbTypes);
        for (PDDLTypedSymbol type : types) {
            this.tableOfTypes.add(type.getImage());
            this.tableOfDomains.add(new LinkedHashSet<>());
        }
    }

    /**
     * Encoded all the type from a specified list of typed symbols.
     *
     * @param list the list of typed symbol.
     */
    private void encodeTypes(final List<PDDLTypedSymbol> list) {
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
                    int typeIndex = this.tableOfTypes.indexOf(image);
                    final Set<Integer> typeDomain = this.tableOfDomains.get(typeIndex);
                    newTypeDomain.addAll(typeDomain);
                }
                newType = buf.toString();
                int index = this.tableOfTypes.indexOf(newType);
                if (index == -1) {
                    this.tableOfDomains.add(new LinkedHashSet<>(newTypeDomain));
                    this.tableOfTypes.add(newType);
                }
            }
        }
    }

    /**
     * Encodes all the type from a specified expression.
     *
     * @param exp the expression.
     */
    private void encodeTypes(final PDDLExpression exp) {
        switch (exp.getConnective()) {
            case AND:
            case OR:
                exp.getChildren().forEach(this::encodeTypes);
                break;
            case FORALL:
            case EXISTS:
                this.encodeTypes(exp.getVariables());
                this.encodeTypes(exp.getChildren().get(0));
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    this.encodeTypes(exp.getChildren().get(0));
                }
                break;
            case EQUAL:
            case FN_ATOM:
            case WHEN:
            case DURATION_ATOM:
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
                this.encodeTypes(exp.getChildren().get(0));
                this.encodeTypes(exp.getChildren().get(1));
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
                this.encodeTypes(exp.getChildren().get(0));
                break;
            case HOLD_AFTER:
            case WITHIN:
                this.encodeTypes(exp.getChildren().get(1));
                break;
            case ALWAYS_WITHIN:
                this.encodeTypes(exp.getChildren().get(1));
                this.encodeTypes(exp.getChildren().get(2));
                break;
            case HOLD_DURING:
                this.encodeTypes(exp.getChildren().get(2));
                break;
            case IS_VIOLATED:
            case NUMBER:
            case ATOM:
            case FN_HEAD:
            case TIME_VAR:
            default:
                //do nothing
        }
    }

    /**
     * Encodes all the constants of the specified domain and the problem.
     *
     * @param domain  the domain.
     * @param problem the problem.
     */
    private void encodeConstants(final PDDLDomain domain, final PDDLProblem problem) {
        final List<PDDLTypedSymbol> constants = domain.getConstants();
        this.tableOfConstants = new ArrayList<>(domain.getConstants().size());
        constants.addAll(problem.getObjects());
        for (PDDLTypedSymbol constant : constants) {
            int ic = this.tableOfConstants.indexOf(constant.getImage());
            if (ic == -1) {
                ic = this.tableOfConstants.size();
                this.tableOfConstants.add(constant.getImage());
            }
            final LinkedList<PDDLSymbol> types = new LinkedList<>(constant.getTypes());
            while (!types.isEmpty()) {
                PDDLSymbol type = types.poll();
                final int it = this.tableOfTypes.indexOf(type.getImage());
                types.addAll(domain.getType(type).getTypes());
                this.tableOfDomains.get(it).add(ic);
            }
        }
    }

    /**
     * Encodes all the predicates of a specified domain.
     *
     * @param domain the domain.
     */
    private void encodePredicates(final PDDLDomain domain) {
        final List<PDDLNamedTypedList> predicates = domain.getPredicates();
        final int nbPredicates = predicates.size();
        this.tableOfPredicates = new ArrayList<>(nbPredicates);
        this.tableOfTypedPredicates = new ArrayList<>(nbPredicates);
        for (PDDLNamedTypedList predicate : predicates) {
            this.tableOfPredicates.add(predicate.getName().getImage());
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
                    argType.add(this.tableOfTypes.indexOf(image.toString()));
                } else {
                    argType.add(this.tableOfTypes.indexOf(types.get(0).getImage()));
                }
            }
            this.tableOfTypedPredicates.add(argType);
        }
    }

    /**
     * Encodes all the function of a specified domain.
     *
     * @param domain the domain.
     */
    private void encodeFunctions(final PDDLDomain domain) {
        final List<PDDLNamedTypedList> functions = domain.getFunctions();
        this.tableOfFunctions = new ArrayList<>(functions.size());
        this.tableOfTypedFunctions = new ArrayList<>(functions.size());
        for (PDDLNamedTypedList function : functions) {
            this.tableOfFunctions.add(function.getName().getImage());
            List<PDDLTypedSymbol> arguments = function.getArguments();
            List<Integer> argType = new ArrayList<>(arguments.size());
            for (PDDLTypedSymbol argument : arguments) {
                List<PDDLSymbol> types = argument.getTypes();
                if (types.size() > 1) {
                    StringBuilder type = new StringBuilder("either");
                    for (PDDLSymbol type1 : types) {
                        type.append("~").append(type1.getImage());
                    }
                    argType.add(this.tableOfTypes.indexOf(type.toString()));
                } else {
                    argType.add(this.tableOfTypes.indexOf(types.get(0).getImage()));
                }
            }
            this.tableOfTypedFunctions.add(argType);

        }
    }

    /**
     * Encodes all the tasks of a specified domain.
     *
     * @param domain the domain.
     */
    private void encodeTasks(final PDDLDomain domain) {
        final List<PDDLNamedTypedList> tasks = domain.getTasks();
        final int nbTasks = tasks.size();
        this.tableOfTasks = new ArrayList<>(nbTasks);
        this.tableOfTypedTasks = new ArrayList<>(nbTasks);
        for (PDDLNamedTypedList task : tasks) {
            this.tableOfTasks.add(task.getName().getImage());
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
                    argType.add(this.tableOfTypes.indexOf(image.toString()));
                } else {
                    argType.add(this.tableOfTypes.indexOf(types.get(0).getImage()));
                }
            }
            this.tableOfTypedTasks.add(argType);
        }
    }


    /**
     * Encodes a specified list of actions into its integer representation.
     *
     * @param ops the list of actions to encode.
     * @return encoded the list of actions encoded.
     */
    private List<IntAction> encodeActions(final List<PDDLAction> ops) {
        this.primitiveTaskSymbols = new LinkedHashSet<>();
        return ops.stream().map(this::encodeAction).collect(Collectors.toList());
    }

    /**
     * Encodes a specified list of methods into its integer representation.
     *
     * @param meths the list of methods to encode.
     * @return encoded the list of methods encoded.
     */
    private List<IntMethod> encodeMethods(final List<PDDLMethod> meths) {
        this.compoundTaskSymbols = new LinkedHashSet<>();
        return meths.stream().map(this::encodeMethod).collect(Collectors.toList());
    }


    /**
     * Encodes a specified initial state into its integer representation.
     *
     * @param init the initial state to encode.
     * @return the initial state encoded.
     */
    private Set<IntExpression> encodeInit(final List<PDDLExpression> init) {
        return init.stream().map(this::encodeExp).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Encodes functions and costs from initial state into its integer representation.
     *
     * @param init the initial state encoded.
     * @return the encoded functions and costs from initial state.
     */
    static Map<IntExpression, Double> encodeFunctionCostInit(final Set<IntExpression> init) {
        Map<IntExpression, Double> intFunctionCost = new HashMap<>();
        for (IntExpression intExp : init) {
            if (intExp.getConnective().equals(PDDLConnective.FN_ATOM)) {
                intFunctionCost.put(intExp.getChildren().get(0), intExp.getChildren().get(1).getValue());
            }
        }
        return intFunctionCost;
    }
    //TODO make more clean method:
    //init.stream().filter(x -> x.getConnective().getImage().equals("="))
    // .collect(Collectors.toMap(x.getChildren().get(0)));

    /**
     * Removes functions and costs from initial state integer representation.
     *
     * @param init the initial state to encode.
     * @return the initial state encoded without functions and costs.
     */
    private Set<IntExpression> removeFunctionCost(final Set<IntExpression> init) {
        return init.stream().filter(x -> !x.getConnective().getImage().equals("="))
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Encodes a specified goal into its integer representation.
     *
     * @param goal the goal to encode.
     * @return the goal encoded.
     */
    private IntExpression encodeGoal(final PDDLExpression goal) {
        return this.encodeExp(goal);
    }

    /**
     * Encodes a specified task network into its integer representation.
     * Warning logial contraints are not considered for the moment.
     *
     * @param taskNetwork the initial task network to encode.
     * @return the initial task network encoded.
     */
    private IntTaskNetwork encodeInitialTaskNetwork(final PDDLTaskNetwork taskNetwork) {
        // Encode the parameters of the task network
        final int numberOfParameters = taskNetwork.getParameters().size();
        IntTaskNetwork encoded = new IntTaskNetwork(numberOfParameters);
        final List<String> variables = new ArrayList<>(numberOfParameters);
        for (int i = 0; i < numberOfParameters; i++) {
            final PDDLTypedSymbol parameter = taskNetwork.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.tableOfTypes.indexOf(typeImage);
            encoded.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the tasks of the task network
        encoded.setTasks(this.encodeExp(taskNetwork.getTasks(), variables));
        // Encode the ordering constraints of the task network
        IntExpression orderingConstraints = null;
        IntExpression subtasks = encoded.getTasks();
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
                encoded.setTasks(orderedSubtasks);
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
        encoded.setOrderingConstraints(orderingConstraints);
        return encoded;
    }

    /**
     * Encode an operator into its integer representation.
     *
     * @param action the operator to encode.
     * @return encoded operator.
     */
    private IntAction encodeAction(final PDDLAction action) {
        final IntAction intAction = new IntAction(action.getName().getImage(), action.getArity());
        this.primitiveTaskSymbols.add(action.getName().getImage());
        // Encode the parameters of the operator
        final List<String> variables = new ArrayList<>(action.getArity());
        for (int i = 0; i < action.getArity(); i++) {
            final PDDLTypedSymbol parameter = action.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.tableOfTypes.indexOf(typeImage);
            intAction.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the duration of the action
        if (action.isDurative()) {
            final IntExpression duration = this.encodeExp(action.getDuration(), variables);
            intAction.setDuration(duration);
        }
        // Encode the preconditions of the operator
        final IntExpression preconditions = this.encodeExp(action.getPreconditions(), variables);
        intAction.setPreconditions(preconditions);
        // Encode the effects of the operator
        final IntExpression effects = this.encodeExp(action.getEffects(), variables);
        intAction.setEffects(effects);
        return intAction;
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
            final int type = this.tableOfTypes.indexOf(typeImage);
            intMeth.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the task carried out by the method
        final IntExpression task = this.encodeExp(method.getTask(), variables);
        intMeth.setTask(task);
        // Encode the preconditions of the method
        final IntExpression preconditions = this.encodeExp(method.getPreconditions(), variables);
        intMeth.setPreconditions(preconditions);
        // Encode the subtasks of the method
        final IntExpression subtasks = this.encodeExp(method.getSubTasks(), variables);
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
    private IntExpression encodeExp(final PDDLExpression exp) {
        return this.encodeExp(exp, new ArrayList<>());
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
    private IntExpression encodeExp(final PDDLExpression exp,
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
                        args[i] = this.tableOfConstants.indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case FN_HEAD:
                final String functor = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.tableOfFunctions.indexOf(functor));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.tableOfConstants.indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case ATOM:
                final String predicate = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.tableOfPredicates.indexOf(predicate));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.tableOfConstants.indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case TASK:
                final String task = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.tableOfTasks.indexOf(task));
                intExp.setPrimtive(this.primitiveTaskSymbols.contains(task));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.tableOfConstants.indexOf(argument.getImage());
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
                    intExp.getChildren().add(this.encodeExp(exp.getChildren().get(i), variables));
                }
                break;
            case FORALL:
            case EXISTS:
                final List<String> newVariables = new ArrayList<>(variables);
                final List<PDDLTypedSymbol> qvar = exp.getVariables();
                final String type = this.toStringType(qvar.get(0).getTypes());
                int typeIndex = this.tableOfTypes.indexOf(type);
                intExp.setType(typeIndex);
                intExp.setVariable(-variables.size() - 1);
                newVariables.add(qvar.get(0).getImage());
                if (qvar.size() == 1) {
                    intExp.getChildren().add(this.encodeExp(exp.getChildren().get(0), newVariables));
                } else {
                    qvar.remove(0);
                    intExp.getChildren().add(this.encodeExp(exp, newVariables));
                }
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    intExp.getChildren().add(this.encodeExp(exp.getChildren().get(0), variables));
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
                intExp.getChildren().add(this.encodeExp(exp.getChildren().get(0), variables));
                intExp.getChildren().add(this.encodeExp(exp.getChildren().get(1), variables));
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
                intExp.getChildren().add(this.encodeExp(exp.getChildren().get(0), variables));
                break;
            case NUMBER:
                intExp.setValue(exp.getValue());
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                intExp.getChildren().add(this.encodeExp(exp.getChildren().get(0), variables));
                intExp.getChildren().add(this.encodeExp(exp.getChildren().get(1), variables));
                intExp.getChildren().add(this.encodeExp(exp.getChildren().get(2), variables));
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

    public Set<PDDLRequireKey> getRequirements() {
        return requirements;
    }

    public List<String> getTableOfTypes() {
        return tableOfTypes;
    }

    public List<Set<Integer>> getTableOfDomains() {
        return tableOfDomains;
    }

    public List<String> getTableOfConstants() {
        return tableOfConstants;
    }

    public List<String> getTableOfPredicates() {
        return tableOfPredicates;
    }

    public List<List<Integer>> getTableOfTypedPredicates() {
        return tableOfTypedPredicates;
    }

    public List<List<Integer>> getTableOfTypedFunctions() {
        return tableOfTypedFunctions;
    }

    public List<String> getTableOfFunctions() {
        return tableOfFunctions;
    }

    public List<List<Integer>> getTableOfTypedTasks() {
        return tableOfTypedTasks;
    }

    public List<String> getTableOfTasks() {
        return tableOfTasks;
    }

    public List<IntAction> getIntActions() {
        return intActions;
    }

    public Set<String> getPrimitiveTaskSymbols() {
        return primitiveTaskSymbols;
    }

    public List<IntMethod> getIntMethods() {
        return intMethods;
    }

    public Set<String> getCompoundTaskSymbols() {
        return compoundTaskSymbols;
    }

    public Set<IntExpression> getIntInitPredicates() {
        return intInitPredicates;
    }

    public Map<IntExpression, Double> getIntInitFunctionCost() {
        return intInitFunctionCost;
    }
}
