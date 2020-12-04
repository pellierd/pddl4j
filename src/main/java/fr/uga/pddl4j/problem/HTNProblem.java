package fr.uga.pddl4j.problem;
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

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLExpression;
import fr.uga.pddl4j.parser.PDDLMethod;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.parser.PDDLSymbol;
import fr.uga.pddl4j.parser.PDDLTaskNetwork;
import fr.uga.pddl4j.parser.PDDLTypedSymbol;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.plan.Hierarchy;
import fr.uga.pddl4j.problem.operator.Action;
import fr.uga.pddl4j.problem.operator.Constants;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.IntExpression;
import fr.uga.pddl4j.problem.operator.IntMethod;
import fr.uga.pddl4j.problem.operator.IntTaskNetwork;
import fr.uga.pddl4j.problem.operator.Method;
import fr.uga.pddl4j.problem.operator.OrderingConstraintSet;
import fr.uga.pddl4j.problem.operator.TaskNetwork;
import fr.uga.pddl4j.util.BitMatrix;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * This class contains all the methods needed to manipulate a HTN problem.
 *
 * @author D. Pellier
 * @version 4.0 - 04.12.2020
 */
public class HTNProblem extends PostInstantiatedProblem {

    /**
     * The set primitive task symbols, i.e., the set of action symbol.
     */
    private Set<String> primitiveTaskSymbols;

    /**
     * The set compound task symbols, i.e., the set of task symbols used in methods.
     */
    private Set<String> compoundTaskSymbols;

    /**
     * The list of methods in the
     */
    private List<IntMethod> intMethods;

    /**
     * The initial task network into its integer representation.
     */
    private IntTaskNetwork intInitialTaskNetwork;

    /**
     * Returns the map used to encode the task into integer.
     */
    private Map<IntExpression, Integer> mapOfTasksIndex;

    /**
     * The initial task network.
     */
    private TaskNetwork initialTaskNetwork;

    /**
     * The list containing for each relevant task at a specified the set of resolvers, i.e., action or methods.
     */
    private List<List<Integer>> taskResolvers;

    /**
     * The list of instantiated methods encoded into bit sets.
     */
    private List<Method> methods;

    /**
     * Creates a new problem from a domain and problem.
     *
     * @param domain the domain.
     * @param problem the problem.
     */
    public HTNProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
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
     * Returns the list of primitive task symbols of the problem.
     *
     * @return the list of primitive task symbols of the problem.
     */
    protected Set<String> getPrimitiveTaskSymbols() {
        return this.primitiveTaskSymbols;
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
     * Returns the list of compound tasks symbols of the problem.
     *
     * @return the list of compound tasks symbols of the problem.
     */
    protected Set<String> getCompoundTaskSymbols() {
        return this.compoundTaskSymbols;
    }


    /**
     * Returns the map used to encode the task into integer.
     *
     * @return the map used to encode the task into integer.
     */
    protected Map<IntExpression, Integer> getMapOfTasksIndex() {
        return this.mapOfTasksIndex;
    }

    public List<List<Integer>> getRelevantOperators() {
        return taskResolvers;
    }

    /**
     * Returns the initial task network of the problem.
     *
     * @return the initial task network of the problem.
     */
    public TaskNetwork getInitialTaskNetwork() {
        return initialTaskNetwork;
    }

    /**
     * The list of relevant methods for a specific task.
     */
    private List<List<Integer>> relevantMethods;

    /**
     * The list of relevant primitive tasks.
     */
    private List<IntExpression> tableOfRelevantPrimitiveTasks;

    /**
     * The list of relevant compund tasks.
     */
    private List<IntExpression> tableOfRelevantCompundTasks;

    /**
     * The list of relevant action for a specific task.
     */
    private List<Integer> relevantActions;

    protected List<IntExpression> getTableOfRelevantPrimitiveTasks() {
        return tableOfRelevantPrimitiveTasks;
    }

    protected List<IntExpression> getTableOfRelevantCompundTasks() {
        return tableOfRelevantCompundTasks;
    }

    protected List<Integer> getRelevantActions() {
        return relevantActions;
    }

    protected List<List<Integer>> getRelevantMethods() {
        return relevantMethods;
    }



    /**
     * Returns the list of instantiated methods of the problem.
     * @return
     */
    public List<Method> getMethods() {
        return this.methods;
    }

    /**
     * The list of relevant tasks of the problem.
     */
    private List<Task> relevantTasks;

    /**
     * The list of relevant tasks of the problem.
     */
    public List<Task> getRelevantTasks() {
        return this.relevantTasks;
    }

    public void instantiate(int timeout) {
        super.instantiate(timeout);
    }

    /**
     * This method is called by the constructor.
     */
    protected void init () {

        // Standardize the variables symbol contained in the domain
        this.getDomain().standardize();
        // Standardize the variables symbol contained in the domain
        this.getProblem().standardize();

        // Collect the information on the type declared in the domain
        this.collectTypeInformation();
        // Collect the constants (symbols and types) declared in the domain
        this.collectConstantInformation();
        // Collect the either types of the domain
        this.collectEitherTypeInformation();
        // Collect the predicate information (symbols and signatures)
        this.collectPredicateInformation();

        // Collect the tasks information (symbols and signatures)
        this.collectTaskInformation();

        // Encode the actions of the domain into integer representation
        this.encodeIntActions();
        this.encodePrimitiveTaskSymbols();

        // Encode the methods of the domain into integer representation
        this.encodeIntMethods();

        // Encode the initial state in integer representation
        this.encodeIntInit();
        // Encode the goal in integer representation
        this.encodeIntGoal();

        this.encodeIntInitialTaskNetwork();
    }

    /**
     * Encodes the methods of the domain into a compact integer representation.
     */
    protected void encodeIntMethods() {
        this.compoundTaskSymbols = new LinkedHashSet<>();
        this.intMethods = this.getDomain().getMethods().stream().map(this::encodeIntMethod).collect(Collectors.toList());
    }

    protected void encodePrimitiveTaskSymbols() {
        this.primitiveTaskSymbols = new LinkedHashSet<>();
        for (IntAction a : this.getIntActions()) {
            this.primitiveTaskSymbols.add(a.getName());
        }
    }

    /**
     * Encode an method into its integer representation.
     *
     * @param method the metho to encode.
     * @return encoded method.
     */
    private IntMethod encodeIntMethod(final PDDLMethod method) {
        final IntMethod intMeth = new IntMethod(method.getName().getImage(), method.getArity());
        this.compoundTaskSymbols.add(method.getTask().getAtom().get(0).getImage());
        // Encode the parameters of the operator
        final List<String> variables = new ArrayList<>(method.getArity());
        for (int i = 0; i < method.getArity(); i++) {
            final PDDLTypedSymbol parameter = method.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.getTypeSymbols().indexOf(typeImage);
            intMeth.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the task carried out by the method
        final IntExpression task = this.encodeIntExp(method.getTask(), variables);
        intMeth.setTask(task);
        // Encode the preconditions of the method
        final IntExpression preconditions = this.encodeIntExp(method.getPreconditions(), variables);
        intMeth.setPreconditions(preconditions);
        // Encode the subtasks of the method
        final IntExpression subtasks = this.encodeIntExp(method.getSubTasks(), variables);
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
                throw new UnexpectedExpressionException(exp.toString());
        }
        return intExp;
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
    protected IntExpression encodeIntExp(final PDDLExpression exp,
                                         final List<String> variables) {
        IntExpression intExp;
        switch (exp.getConnective()) {
            case TASK:
                intExp = new IntExpression(exp.getConnective());
                final String task = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.getTaskSymbols().indexOf(task));
                intExp.setPrimtive(this.primitiveTaskSymbols.contains(task));
                int[] args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.getConstantSymbols().indexOf(argument.getImage());
                    }
                }
                if (exp.getTaskID() != null) { // TaskID is null the task carried out by a method is encoded
                    intExp.setTaskID(new Integer(exp.getTaskID().getImage().substring(1)));
                }
                intExp.setArguments(args);
                break;
            default:
                intExp = super.encodeIntExp(exp, variables);
        }
        return intExp;

    }


    /**
     * Encodes a specified task network into its integer representation.
     */
    protected void encodeIntInitialTaskNetwork() {
        // Encode the parameters of the task network
        final PDDLTaskNetwork taskNetwork = this.getProblem().getInitialTaskNetwork();
        final int numberOfParameters = taskNetwork.getParameters().size();
        this.intInitialTaskNetwork = new IntTaskNetwork(numberOfParameters);
        final List<String> variables = new ArrayList<>(numberOfParameters);
        for (int i = 0; i < numberOfParameters; i++) {
            final PDDLTypedSymbol parameter = taskNetwork.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.getTypeSymbols().indexOf(typeImage);
            this.intInitialTaskNetwork.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the tasks of the task network
        this.intInitialTaskNetwork.setTasks(this.encodeIntExp(taskNetwork.getTasks(), variables));
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

    protected void preinstantiation() {
        this.extractInertia();
        // Create the predicates tables used to count the occurrences of the predicates in the
        // initial state
        this.createPredicatesTables();
    }

    protected void instantiation() {
        this.instantiateActions();

        this.extractGroundInertia();
        this.extractGroundNumericInertia();
        this.simplyActionsWithGroundInertia();



        this.instantiateGoal();
        this.simplifyGoalWithGroundInertia();



        this.instantiateInitialTaskNetwork();
        this.instantiateMethods(this.getIntMethods(), this.getIntInitialTaskNetwork(), this.getIntActions());
        this.simplyMethodsWithGroundInertia();

    }

    protected void postinstantiation() {

        this.extractRelevantFacts();
        this.extractRelevantTasks();

        this.initOfMapFluentIndex();

        this.initRelevantOperators();
        this.initMapOfTaskIndex();

        this.encodeGoal();

        this.encodeInitialTaskNetwork();
        this.encodeMethods();
        this.encodeInit();


        this.encodeActions();


    }

    protected void instantiateInitialTaskNetwork() {
        final List<IntTaskNetwork> taskNetworks = this.instantiate(this.getIntInitialTaskNetwork());
        if (taskNetworks.size() > 1) {
            IntExpression root = new IntExpression(PDDLConnective.TASK);
            root.setPredicate(this.getTaskSymbols().size());
            this.getTaskSymbols().add("__top");
            this.getCompoundTaskSymbols().add("__top");
            root.setPrimtive(false);
            int index = 0;
            for (IntTaskNetwork tn : taskNetworks) {
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
                this.getIntMethods().add(method);
                index++;
            }

            // Creates the abstract initial task network
            IntTaskNetwork newTaskNetwork = new IntTaskNetwork();
            newTaskNetwork.getTasks().addChild(new IntExpression(root));
            this.intInitialTaskNetwork = newTaskNetwork;
        } else {
            this.intInitialTaskNetwork = taskNetworks.get(0);
        }
    }

    /**
     * Instantiates a specified task network.
     *
     * @param network the task network to instantiate.
     * @return the list of task netwok instantiated corresponding the specified network.
     */
    private List<IntTaskNetwork> instantiate(final IntTaskNetwork network) {
        final List<IntTaskNetwork> instNetwork = new ArrayList<>(100);
        this.instantiate(network, 0, instNetwork);
        return instNetwork;
    }

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
            final Set<Integer> values = this.getDomains().get(network.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntTaskNetwork copy = new IntTaskNetwork(arity);
                copy.setOrderingConstraints(new IntExpression(network.getOrderingConstraints()));

                final IntExpression tasksCopy = new IntExpression(network.getTasks());
                this.substitute(tasksCopy, varIndex, value, true);
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
     *
     * @param methods             the method to instantiate.
     * @param initialTasksNetwork the initial tasks network.
     * @param actions             the list of action already instantiate.
     */
    protected void instantiateMethods(List<IntMethod> methods, IntTaskNetwork initialTasksNetwork,
                                      List<IntAction> actions) {

        // Init the list of instantiated methods or ground methods
        final List<IntMethod> instMethods = new ArrayList<>(Constants.DEFAULT_METHOD_TABLE_SIZE);

        // Init the set used to store the compound tasks
        final Set<IntExpression> compound = new LinkedHashSet<>();

        // Init the set used to store the primtive tasks
        final Set<IntExpression> primtive = new LinkedHashSet<>();

        // Init the table used to store for each task the list of methods that are relevant
        this.relevantMethods = new ArrayList<List<Integer>>();

        // Init the list of methods to instantiate
        List<IntMethod> meths = new ArrayList<>();
        for (IntMethod m : methods) {
            // If a method has a parameter with a empty domain the method must be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < m.arity() && toInstantiate) {
                toInstantiate = !this.getDomains().get(m.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (toInstantiate) {
                meths.add(m);
            }
        }

        // Filter methods with a parameter with an empty domain
        this.filterMethodWithEmptyDomainParameter(methods);

        // Expand the quantified expression contains in the the method precondition
        this.expandQuantifiedExpressionAndSimplyMethods(meths);

        // Compute the set of primitive task from the action already instantiated
        LinkedHashSet<IntExpression> primitiveTaskSet = this.computePrimitiveTaskSet(actions);

        // TInit the list of pending tasks to decompose
        final LinkedList<IntExpression> tasks = new LinkedList<>();

        // Add the task of the initial task network with the compound tasks
        for (IntExpression subtasks : initialTasksNetwork.getTasks().getChildren()) {
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

            this.relevantMethods.add(relevantIndex);
            instMethods.addAll(relevant);
        }

        // Initialize the table of relevant methods for each compund task and the table of relevant compound tasks
        this.tableOfRelevantCompundTasks = new ArrayList<>(compound.size());
        this.tableOfRelevantCompundTasks.addAll(compound);

        // Initialize the table of relevant actions for each primitive task and the table of relevant primitive tasks
        this.relevantActions = new ArrayList<Integer>(primitiveTaskSet.size());
        this.tableOfRelevantPrimitiveTasks = new ArrayList<>(primitiveTaskSet.size());
        int index = 0;
        Iterator<IntExpression> i = primitiveTaskSet.iterator();
        while (i.hasNext()) {
            // The action at index i can be remove because it not reachable from the initial task network.
            IntExpression primitiveTask = i.next();
            if (!primtive.contains(primitiveTask)) {
                actions.remove(index);
                i.remove();
            } else {
                this.relevantActions.add(index);
                this.tableOfRelevantPrimitiveTasks.add(primitiveTask);
                index++;
            }
        }
        methods.clear();
        methods.addAll(instMethods);
    }

    /**
     * Filter methods with a parameter with a empty domain.
     *
     * @param methods the list of methods to filter.
     */
    private void filterMethodWithEmptyDomainParameter(List<IntMethod> methods) {
        Iterator<IntMethod> it = methods.iterator();
        while (it.hasNext()) {
            final IntMethod method = it.next();
            // If an method has a parameter with a empty domain the method can be removed
            boolean toInstantiate = true;
            int i = 0;
            while (i < method.arity() && toInstantiate) {
                toInstantiate = !this.getDomains().get(method.getTypeOfParameters(i)).isEmpty();
                i++;
            }
            if (!toInstantiate) {
                it.remove();
            }
        }
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
            this.expandQuantifiedExpression(method.getPreconditions(), true);
            this.simplify(method.getPreconditions());
            if (method.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                i.remove();
            }
        }
    }

    /**
     * Computes the list of possible primitive tasks from the action already instantiated.
     *
     * @param actions the list of actions altready instantiated.
     * @return the list of possible primitive tasks from the action already instantiated.
     */
    private LinkedHashSet<IntExpression> computePrimitiveTaskSet(List<IntAction> actions) {
        LinkedHashSet<IntExpression> tasks = new LinkedHashSet<>();
        for (IntAction a : actions) {
            IntExpression task = new IntExpression(PDDLConnective.TASK);
            task.setPrimtive(true);
            task.setPredicate(this.getTaskSymbols().indexOf(a.getName()));
            task.setArguments(a.getInstantiations());
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
            final Set<Integer> domain = this.getDomains().get(type);
            if (domain.contains(cons)) {
                this.substitute(copy.getPreconditions(), var, cons, true);
                this.substitute(copy.getTask(), var, cons, true);
                this.substitute(copy.getSubTasks(), var, cons, true);
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
    private void instantiate(final IntMethod method, final int index, final int bound,
                             final List<IntMethod> methods) {
        if (bound == methods.size()) {
            return;
        }
        final int arity = method.arity();
        if (index == arity) {
            final IntExpression precond = method.getPreconditions();
            this.simplify(precond);
            if (!precond.getConnective().equals(PDDLConnective.FALSE)) {
                methods.add(method);
            }
        } else if (method.getValueOfParameter(index) >= 0) {
            this.instantiate(method, index + 1, bound, methods);
        } else {
            final Set<Integer> values = this.getDomains().get(method.getTypeOfParameters(index));
            for (Integer value : values) {
                final int varIndex = -index - 1;
                final IntExpression preconditionCopy = new IntExpression(method.getPreconditions());

                this.substitute(preconditionCopy, varIndex, value, true);
                if (!preconditionCopy.getConnective().equals(PDDLConnective.FALSE)) {
                    final IntMethod copy = new IntMethod(method.getName(), arity);
                    copy.setPreconditions(preconditionCopy);
                    copy.setOrderingConstraints(new IntExpression(method.getOrderingConstraints()));

                    final IntExpression taskCopy = new IntExpression(method.getTask());
                    this.substitute(taskCopy, varIndex, value, true);
                    copy.setTask(taskCopy);

                    final IntExpression subTasksCopy = new IntExpression(method.getSubTasks());
                    this.substitute(subTasksCopy, varIndex, value, true);
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
     * Simply recursively the methods by removing unreachable tasks.
     *
     * @param methods the list of method to simplify.
     * @param tasks   the set of compound tasks which are no more reachable.
     * @return the list of task no more reachable.
     */
    private void simplyRecursivelyMethodsWithTasksNoMoreReachable(final List<IntMethod> methods,
                                                                  final Set<IntExpression> tasks) {
        while (!tasks.isEmpty()) {
            this.simplyMethodsWithTasksNoMoreReachable(methods, tasks);
        }
    }

    /**
     * Simply the method by removing unreachable tasks.
     *
     * @param methods the list of method to simplify.
     * @param tasks   the set of compound tasks which are no more reachable.
     * @return the list of task no more reachable.
     */
    private void simplyMethodsWithTasksNoMoreReachable(final List<IntMethod> methods,
                                                       final Set<IntExpression> tasks) {
        final Set<IntExpression> tasksNoMoreReachable = new LinkedHashSet<>();
        for (int i = 0; i < methods.size(); i++) {
            final IntMethod method = methods.get(i);
            if (this.isSimplified(method, tasks)) {
                methods.remove(i);
                for (int j = 0; j < this.getRelevantMethods().size(); j++) {
                    final List<Integer> relevant = this.getRelevantMethods().get(j);
                    if (relevant.remove(new Integer(i))) {
                        //System.out.println("remove " + i);
                        this.updateRelevantMethods(i);
                        // There is no more relevant method for the compound task
                        if (relevant.isEmpty()) {
                            tasksNoMoreReachable.add(this.getTableOfRelevantCompundTasks().get(j));
                            this.getTableOfRelevantCompundTasks().remove(j);
                            this.getRelevantMethods().remove(j);
                            //System.out.println("A task is no more reachable");
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
    private boolean isSimplified(IntMethod method, Set<IntExpression> tasks) {
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
        for (List<Integer> relevant : this.getRelevantMethods()) {
            int i = 0;
            for (Integer m : relevant) {
                if (m > index) {
                    relevant.set(i, --m);
                }
                i++;
            }

        }
    }

    /**
     * Do a pass over the preconditions of all the instantiated methods and update the ground inertia
     * table. Then, simplify the methods according to the extracted ground inertia.
     */
    protected void simplyMethodsWithGroundInertia() {
        final List<IntMethod> toAdd = new ArrayList<>(this.getIntMethods().size());
        final Set<IntExpression> toRemove = new HashSet<>();
        for (IntMethod m : this.getIntMethods()) {
            this.simplifyWithGroundInertia(m.getPreconditions(), false);
            this.simplify(m.getPreconditions());
            if (!m.getPreconditions().getConnective().equals(PDDLConnective.FALSE)) {
                toAdd.add(m);
            } else {
                toRemove.add(m.getTask());
            }
        }
        this.simplyRecursivelyMethodsWithTasksNoMoreReachable(this.getIntMethods(), toRemove);
    }





    /**
     * Extracts the relevant facts from the instantiated actions. A ground fact is relevant if and
     * only if:
     * <ul>
     * <li>1. it is an initial fact and not a negative ground inertia, or if</li>
     * <li>2. it is not an initial fact and not a positive ground inertia.</li>
     * </ul>
     *
     */
    protected void extractRelevantFacts() {
        final Set<IntExpression> facts = new LinkedHashSet<>(10000);
        for (IntAction a : this.getIntActions()) {
            extractRelevantFacts(a.getPreconditions(), facts);
            extractRelevantFacts(a.getEffects(), facts);
        }
        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            for (IntMethod m : this.getIntMethods()) {
                extractRelevantFacts(m.getPreconditions(), facts);
            }
        }
        for (IntExpression p : this.getIntInitPredicates()) {
            Inertia inertia = this.getGroundInertia().get(p);
            if (inertia == null) {
                inertia = Inertia.INERTIA;
            }
            if (this.getIntInitPredicates().contains(p) && !inertia.equals(Inertia.NEGATIVE)) {
                facts.add(p);
            }
        }
        this.intExpRelevantFluents = new ArrayList<>(facts.size());
        this.relevantFluents = new ArrayList<>(facts.size());
        for (IntExpression exp : facts) {
            final IntExpression relevant = new IntExpression(exp);
            this.intExpRelevantFluents.add(relevant);
            this.relevantFluents.add(new Fluent(exp.getPredicate(), exp.getArguments()));
        }
    }


    public void extractRelevantTasks() {
        this.relevantTasks = new ArrayList<>();
        for (IntExpression task : this.getTableOfRelevantPrimitiveTasks()) {
            this.relevantTasks.add(new Task(task.getPredicate(), task.getArguments(), true));
        }
        for (IntExpression task : this.getTableOfRelevantCompundTasks()) {
            this.relevantTasks.add(new Task(task.getPredicate(), task.getArguments(), false));
        }
    }

    protected void initMapOfTaskIndex() {
        List<IntExpression> tasks = new ArrayList<>();
        tasks.addAll(this.getTableOfRelevantPrimitiveTasks());
        tasks.addAll(this.getTableOfRelevantCompundTasks());

        // Create a map of the relevant tasks with their index to speedup the bit set encoding of the methods
        this.mapOfTasksIndex = new LinkedHashMap<>(tasks.size());
        int index = 0;
        for (IntExpression task : tasks) {
            this.mapOfTasksIndex.put(task, index);
            index++;
        }
    }

    protected void initRelevantOperators() {
        this.taskResolvers = new ArrayList<>();
        for (Integer a : this.getRelevantActions()) {
            List<Integer> l = new ArrayList<>(1);
            l.add(a);
            this.taskResolvers.add(l);
        }
        this.taskResolvers.addAll(this.getRelevantMethods());
    }

    protected void encodeInitialTaskNetwork() {
        this.initialTaskNetwork = this.encodeTaskNetwork(this.getIntInitialTaskNetwork());
    }

    /**
     * Encode a list of specified methods into the final compact representation. The specified
     * maps are used to speed-up the search by mapping the an expression to this index.
     *
     * @return the list of methods encoded into final compact representation.
     */
    protected void encodeMethods() throws UnexpectedExpressionException {
        this.methods = new ArrayList<>(this.getIntMethods().size());
        final List<Method> addedMethods = new ArrayList<>();
        int methodIndex = this.getRelevantActions().size();
        for (IntMethod intMethod : this.getIntMethods()) {
            List<IntMethod> normalized = this.normalizeMethod(intMethod);
            this.methods.add(this.encodeMethod(normalized.get(0), this.getMapOfFluentIndex(), this.mapOfTasksIndex));
            for (int i  = 1; i < normalized.size(); i++) {
                if (this.getRelevantOperators() != null) {
                    this.getRelevantOperators().get(methodIndex).add(methods.size() + addedMethods.size());
                }
                this.methods.add(this.encodeMethod(normalized.get(i), this.getMapOfFluentIndex(), this.mapOfTasksIndex));
            }
            methodIndex++;
        }
        this.methods.addAll(addedMethods);
    }

    /**
     * Encode a list of specified methods into the final compact representation. The specified
     * maps are used to speed-up the search by mapping the an expression to this index.
     *
     * @param method the list of methods to encode.
     * @param factMap the map that associates at a specified fact its index in the table of relevant fluents.
     * @param taskMap the map that associates at a specified task its index in the table of relevant tasks.
     * @return the list of methods encoded into final compact representation.
     */
    protected Method encodeMethod(final IntMethod method, final Map<IntExpression, Integer> factMap,
                                  final Map<IntExpression, Integer> taskMap) throws UnexpectedExpressionException {

        final int arity = method.arity();
        final Method encoded = new Method(method.getName(), arity);
        // Initialize the parameters of the method
        for (int i = 0; i < arity; i++) {
            encoded.setValueOfParameter(i, method.getValueOfParameter(i));
            encoded.setTypeOfParameter(i, method.getTypeOfParameters(i));
        }
        // Encode the task carried out by the method
        encoded.setTask(taskMap.get(method.getTask()));
        // Encode the preconditions of the method
        encoded.setPrecondition(this.encodeCondition(method.getPreconditions()));
        // Encode the task network of the method
        encoded.setTaskNetwork(this.encodeTaskNetwork(method.getTaskNetwork()));
        return encoded;
    }

    /**
     * Encode a specified task network.
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param taskNetwork the tasknetwork to encode.
     * @return a list of <code>BitExp</code> that represents the goal as a disjunction of
     * <code>BitExp</code>.
     */
    protected TaskNetwork encodeTaskNetwork(IntTaskNetwork taskNetwork) {
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
     * Normalize the methods, i.e, put in disjunctive normal form (DNF) the preconditions. If a method has
     * disjunctive preconditions, a new method is created such all methods after normalization have only conjunctive
     * precondition.
     *
     * @param method the list of methods to normalizeActions.
     */
    private List<IntMethod> normalizeMethod(final IntMethod method) throws UnexpectedExpressionException {
        final List<IntMethod> normalisedMethods = new ArrayList<>();
        final IntExpression precond = method.getPreconditions();
        this.toDNF(precond);
        if (precond.getChildren().size() > 0) {
            for (final IntExpression ei : precond.getChildren()) {
                final String name = method.getName();
                final int arity = method.arity();
                final IntMethod newMethod = new IntMethod(name, arity);
                for (int i = 0; i < arity; i++) {
                    newMethod.setTypeOfParameter(i, method.getTypeOfParameters(i));
                }
                for (int i = 0; i < arity; i++) {
                    newMethod.setValueOfParameter(i, method.getValueOfParameter(i));
                }
                newMethod.setPreconditions(ei);
                newMethod.setTask(new IntExpression(method.getTask()));
                newMethod.setTaskNetwork(new IntTaskNetwork(method.getTaskNetwork()));
                normalisedMethods.add(newMethod);
            }
        } else {
            normalisedMethods.add(method);
        }
        return normalisedMethods;
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
                tasks.add(this.mapOfTasksIndex.get(exp));
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
     * Returns <code>true</code> if this problem is solvable. In the case of STRIPS planning, the method returns
     * <code>false</code> if the goal is simplified to <code>false</code> during the encoding process, otherwise the
     * method returns <code>true</code>. In the case of HTN planning, the method returns <code>false</code> if at least
     * one of the task of the initial task network is not reachable after the encoding process, i.e., as a task is set
     * to null in the tasks list of the initial task network, otherwise the method returns <code>true</code>.
     * <p>
     * Warning, it is not because the method returns <code>true</code> that the problem is solvable. It just means that
     * the encoding process can not exclude the fact that the problem is solvable.
     * </p>
     *
     * @return <code>true</code> if this problem is solvable; <code>false</code>.
     */
    public final boolean isSolvable() {
        boolean isSovable = true;
        Iterator<Integer> i = this.getInitialTaskNetwork().getTasks().iterator();
        while (i.hasNext() && isSovable) {
            isSovable = i.next() != null;
        }
        return isSovable;
    }

    /**
     * Returns true if the problem is totally ordered. The method returns true if the problem is not hierarchic.
     * A hierarchical problem is totally ordered if and only the subtasks of each method of the problem are totally
     * ordered and the initial task network is totally ordered.
     *
     * @return true if the problem is totally ordered, false otherwise.
     */
    public final boolean isTotallyOrederd() {
        boolean totallyOrdered = true;
        Iterator<Method> i = this.getMethods().iterator();
        while (i.hasNext() && totallyOrdered) {
            Method m = i.next();
            totallyOrdered = m.getTaskNetwork().isTotallyOrdered();
        }
        return totallyOrdered ? this.getInitialTaskNetwork().isTotallyOrdered() : totallyOrdered;
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
            final String type = this.getTypeSymbols().get(taskNetwork.getTypeOfParameters(i));
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
     * Returns a string representation of the specified method.
     *
     * @param method the method.
     * @return a string representation of the specified method.
     */
    public final String toString(final Method method) {
        final StringBuilder str = new StringBuilder();
        str.append("Method ");
        str.append(method.getName());
        str.append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < method.arity(); i++) {
            final int index = method.getValueOfParameter(i);
            final String type = this.getTypeSymbols().get(method.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i).append(" - ");
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
        str.append("Task: " + this.toString(this.getRelevantTasks().get(method.getTask())) + "\n");
        str.append("Preconditions:\n");
        str.append(this.toString(method.getPrecondition()));
        str.append("\n");
        str.append(this.toString(method.getTaskNetwork()));
        return str.toString();
    }

    /**
     * Returns a string representation of the specified task network.
     *
     * @param tasknetwork the task network.
     * @return a string representation of the specified task network.
     */
    public final String toString(final TaskNetwork tasknetwork) {
        final StringBuilder str = new StringBuilder();
        str.append("Tasks:\n");
        if (tasknetwork.getTasks().isEmpty()) {
            str.append(" ()\n");
        } else {
            for (int i = 0; i < tasknetwork.getTasks().size(); i++) {
                str.append(" " + PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + i + ": ");
                str.append(this.toString(this.getRelevantTasks().get(tasknetwork.getTasks().get(i))));
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
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + r);
                    str.append(" ");
                    str.append(PDDLConnective.LESS_ORDERING_CONSTRAINT.getImage());
                    str.append(" ");
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + c);
                    str.append("\n");
                    index++;
                }
            }
        }
        return str.toString();
    }

    /**
     * Returns a string representation of a task.
     *
     * @param task the formula.
     * @return a string representation of the specified expression.
     */
    public String toString(final Task task) {
        final StringBuffer str = new StringBuffer();
        str.append("(");
        str.append(this.getTaskSymbols().get(task.getSymbol()));
        for (Integer arg : task.getArguments()) {
            str.append(" ");
            str.append(this.getConstantSymbols().get(arg));
        }
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
}
