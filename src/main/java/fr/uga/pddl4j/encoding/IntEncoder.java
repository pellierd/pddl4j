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
import fr.uga.pddl4j.problem.OrderingConstraintSet;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class implements all the methods needed to encode actions, goal and initial state loaded
 * from the parser in its integer representation.
 *
 * @author D. Pellier
 * @version 1.0 - 08.06.2010
 */
final class IntEncoder implements Serializable {

    /**
     * The encoded problem.
     */
    private IntProblem problem;

    /**
     * Creates a new IntEncoder for a specific domain and problem.
     *
     */
    public IntEncoder() {
        super();
    }

    public IntProblem encode(final PDDLDomain domain, final PDDLProblem problem) {
        this.problem = new IntProblem();
        // Encode the types declared in the domain
        this.encodeTypes(domain);
        // Encode the constants declared in the domain and the objects of the problem
        this.encodeConstants(domain, problem);
        // Encode the type of the form (either t1 t2...) declared in the domain and the problem
        this.encodeEitherTypes(domain, problem);
        // Encode the predicates defined in the domain.
        this.encodePredicates(domain);
        // Encode the functions defined in the domain.
        if (domain.getRequirements().contains(PDDLRequireKey.FLUENTS)
            || domain.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.encodeFunctions(domain);
        }
        // Encode the tasks defined in the domain.
        if (domain.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.encodeTasks(domain);
        }
        // Encode actions in integer representation
        this.encodeActions(domain);
        // Encode methods in integer representation
        if (domain.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.encodeMethods(domain);
        }
        // Encode the initial state in integer representation
        this.encodeInitialState(problem);
        // Encode the goal in integer representation
        this.encodeGoal(problem);
        // Encode the initial task network in integer representation
        if (domain.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.encodeInitialTaskNetwork(problem);
        }
        return this.problem;
    }


    /**
     * Collects composite type, i.e., type of the form (either t1 t2), through a specified domain and
     * problem and creates their respective domain.
     *
     * @param domain the domain to encode.
     * @param problem the problem to encode.
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
        for (PDDLAction action : domain.getActions()) {
            this.encodeTypes(action.getParameters());
            if (action.getDuration() != null) {
                this.encodeTypes(action.getDuration());
            }
            this.encodeTypes(action.getPreconditions());
            this.encodeTypes(action.getEffects());
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
     * @param domain the domain to encode.
     */
    private void encodeTypes(final PDDLDomain domain) {
        final List<PDDLTypedSymbol> types = domain.getTypes();
        for (PDDLTypedSymbol type : types) {
            this.problem.getTypes().add(type.getImage());
            this.problem.getDomains().add(new LinkedHashSet<>());
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
                    int typeIndex = this.problem.getTypes().indexOf(image);
                    final Set<Integer> typeDomain = this.problem.getDomains().get(typeIndex);
                    newTypeDomain.addAll(typeDomain);
                }
                newType = buf.toString();
                int index = this.problem.getTypes().indexOf(newType);
                if (index == -1) {
                    this.problem.getDomains().add(new LinkedHashSet<>(newTypeDomain));
                    this.problem.getTypes().add(newType);
                }
            }
        }
    }

    /**
     * Encodes all the type from a specified expression, i.e., get the type used in the qantified expression.
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
            case NOT:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
                this.encodeTypes(exp.getChildren().get(0));
                break;
            case WHEN:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case IMPLY:
                this.encodeTypes(exp.getChildren().get(0));
                this.encodeTypes(exp.getChildren().get(1));
                break;
            case WITHIN:
            case HOLD_AFTER:
                this.encodeTypes(exp.getChildren().get(1));
                break;
            case ALWAYS_WITHIN:
                this.encodeTypes(exp.getChildren().get(1));
                this.encodeTypes(exp.getChildren().get(2));
                break;
            case HOLD_DURING:
                this.encodeTypes(exp.getChildren().get(3));
            default:
                // do nothing

        }
    }

    /**
     * Encodes all the constants used in the domain and the problem and initialised the the domain of value of each
     * type.
     *
     * @param domain the domain to encode.
     * @param problem the problem to encode.
     */
    private void encodeConstants(final PDDLDomain domain, final PDDLProblem problem) {
        final List<PDDLTypedSymbol> constants = domain.getConstants();
        constants.addAll(problem.getObjects());
        for (PDDLTypedSymbol constant : constants) {
            int ic = this.problem.getConstants().indexOf(constant.getImage());
            if (ic == -1) {
                ic = this.problem.getConstants().size();
                this.problem.getConstants().add(constant.getImage());
            }
            final LinkedList<PDDLSymbol> types = new LinkedList<>(constant.getTypes());
            while (!types.isEmpty()) {
                PDDLSymbol type = types.poll();
                final int it = this.problem.getTypes().indexOf(type.getImage());
                types.addAll(domain.getType(type).getTypes());
                this.problem.getDomains().get(it).add(ic);
            }
        }
    }

    /**
     * Encodes all the predicates used in the domain.
     *
     * @param domain the domain encode.
     */
    private void encodePredicates(final PDDLDomain domain) {
        final List<PDDLNamedTypedList> predicates = domain.getPredicates();
        for (PDDLNamedTypedList predicate : predicates) {
            this.problem.getPredicates().add(predicate.getName().getImage());
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
                    argType.add(this.problem.getTypes().indexOf(image.toString()));
                } else {
                    argType.add(this.problem.getTypes().indexOf(types.get(0).getImage()));
                }
            }
            this.problem.getTypeOfPredicateArguments().add(argType);
        }
    }

    /**
     * Encodes all the function used in the domain.
     *
     * @param domain the domain to encode.
     */
    private void encodeFunctions(final PDDLDomain domain) {
        final List<PDDLNamedTypedList> functions = domain.getFunctions();
        for (PDDLNamedTypedList function : functions) {
            this.problem.getFunctions().add(function.getName().getImage());
            final List<PDDLTypedSymbol> arguments = function.getArguments();
            final List<Integer> argType = new ArrayList<>(arguments.size());
            for (PDDLTypedSymbol argument : arguments) {
                final List<PDDLSymbol> types = argument.getTypes();
                if (types.size() > 1) {
                    StringBuilder type = new StringBuilder("either");
                    for (PDDLSymbol type1 : types) {
                        type.append("~").append(type1.getImage());
                    }
                    argType.add(this.problem.getTypes().indexOf(type.toString()));
                } else {
                    argType.add(this.problem.getTypes().indexOf(types.get(0).getImage()));
                }
            }
            this.problem.getTypeOfFunctionArguments().add(argType);
        }
    }

    /**
     * Encodes all the tasks used in the domain. This method is use only for HDDL domain.
     *
     * @param domain the domain to encode.
     */
    private void encodeTasks(final PDDLDomain domain) {
        final List<PDDLNamedTypedList> tasks = domain.getTasks();
        for (PDDLNamedTypedList task : tasks) {
            this.problem.getTasks().add(task.getName().getImage());
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
                    argType.add(this.problem.getTypes().indexOf(image.toString()));
                } else {
                    argType.add(this.problem.getTypes().indexOf(types.get(0).getImage()));
                }
            }
           this.problem.getTypeOfTaskArguments().add(argType);
        }
    }

    /**
     * Encodes the actions of a specified domain.
     *
     * @param domain the domain to encode.
     */
    private void encodeActions(final PDDLDomain domain) {
        domain.getActions().forEach(this::encodeAction);
    }

    /**
     * Encodes the methods of a specified domain.
     *
     * @param domain the domain to encode.
     */
    private void encodeMethods(final PDDLDomain domain) {
        domain.getMethods().forEach(this::encodeMethod);
    }


    /**
     * Encodes the initial state of a specified problem and extract the initial numeric cost of the function.
     *
     * @param problem the problem.
     */
    private void encodeInitialState(final PDDLProblem problem) {
        final Set<IntExpression> init = problem.getInit().stream().map(this::encodeExp)
            .collect(Collectors.toCollection(LinkedHashSet::new));
        Iterator<IntExpression> i = init.iterator();
        while (i.hasNext()) {
            IntExpression initEl = i.next();
            if (initEl.getConnective().equals(PDDLConnective.EQUAL)) {
                this.problem.getInitalFunctionCosts().put(initEl.getChildren().get(0),
                    initEl.getChildren().get(1).getValue());
                i.remove();
            }
        }
        this.problem.getInitialState().addAll(init);

    }

    /**
     * Encodes the goal of the problem specified.
     *
     * @param problem the problem
     */
    private void encodeGoal(final PDDLProblem problem) {
        if (problem.getGoal() != null) {
            this.problem.setGoal(this.encodeExp(problem.getGoal()));
        } else {
            this.problem.setGoal(new IntExpression(PDDLConnective.AND));
        }
    }

    /**
     * Encodes the inital task network of a specified problem.
     *
     * @param problem the problem.
     */
    private void encodeInitialTaskNetwork(final PDDLProblem problem) {
        PDDLTaskNetwork taskNetwork = problem.getInitialTaskNetwork();
        // Encode the parameters of the task network
        final int numberOfParameters = taskNetwork.getParameters().size();
        IntTaskNetwork encoded = new IntTaskNetwork(numberOfParameters);
        final List<String> variables = new ArrayList<>(numberOfParameters);
        for (int i = 0; i < numberOfParameters; i++) {
            final PDDLTypedSymbol parameter = taskNetwork.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.problem.getTypes().indexOf(typeImage);
            encoded.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the tasks of the task network
        encoded.setTasks(this.encodeExp(taskNetwork.getTasks(), variables));
        // Encode the ordering constraints of the task network
        IntExpression orderingConstraints;
        IntExpression subtasks = encoded.getTasks();
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
                    t1.setTaskID(i);
                    constraint.addChild(t1);
                    final IntExpression t2 = new IntExpression(PDDLConnective.TASK);
                    t2.setTaskID(i + 1);
                    constraint.addChild(t2);
                    orderingConstraints.addChild(constraint);
                }
            }
        }
        encoded.setOrderingConstraints(orderingConstraints);
        this.problem.setInitialTaskNetwork(encoded);
    }

    /**
     * Encode an action into its integer representation and add it to the encoded problem.
     */
    private void encodeAction(final PDDLAction action) {
        final IntAction intAction = new IntAction(action.getName().getImage(), action.getArity());
        this.problem.getPrimitiveTaskSymbols().add(action.getName().getImage());
        // Encode the parameters of the operator
        final List<String> variables = new ArrayList<>(action.getArity());
        for (int i = 0; i < action.getArity(); i++) {
            final PDDLTypedSymbol parameter = action.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.problem.getTypes().indexOf(typeImage);
            intAction.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the preconditions of the action
        final IntExpression preconditions = this.encodeExp(action.getPreconditions(), variables);
        intAction.setPreconditions(preconditions);
        // Encode the effects of the action
        final IntExpression effects = this.encodeExp(action.getEffects(), variables);
        intAction.setEffects(effects);
        this.problem.getActions().add(intAction);
    }

    /**
     * Encode an method into its integer representation and add it to the encoded problem.
     */
    private void encodeMethod(final PDDLMethod method) {
        final IntMethod intMeth = new IntMethod(method.getName().getImage(), method.getArity());
        this.problem.getCompoundTaskSymbols().add(method.getTask().getAtom().get(0).getImage());
        // Encode the parameters of the operator
        final List<String> variables = new ArrayList<>(method.getArity());
        for (int i = 0; i < method.getArity(); i++) {
            final PDDLTypedSymbol parameter = method.getParameters().get(i);
            final String typeImage = this.toStringType(parameter.getTypes());
            final int type = this.problem.getTypes().indexOf(typeImage);
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
        IntExpression orderingConstraints;
        // Express the total ordering into explicit constraints
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
        this.problem.getMethods().add(intMeth);
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
        IntExpression encodedExp = this.encodeExp(exp, new ArrayList<>());
        encodedExp.moveNegationInward();
        encodedExp.moveTimeSpecifierInward();
        return encodedExp;
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
    private IntExpression encodeExp(final PDDLExpression exp, final List<String> variables) {
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
                        args[i] = this.problem.getConstants().indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case FN_HEAD:
                final String functor = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.problem.getFunctions().indexOf(functor));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.problem.getConstants().indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case ATOM:
                final String predicate = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.problem.getPredicates().indexOf(predicate));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.problem.getConstants().indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case TASK:
                final String task = exp.getAtom().get(0).getImage();
                intExp.setPredicate(this.problem.getTasks().indexOf(task));
                intExp.setPrimtive(this.problem.getPrimitiveTaskSymbols().contains(task));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final PDDLSymbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = this.problem.getConstants().indexOf(argument.getImage());
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
                int typeIndex = this.problem.getTypes().indexOf(type);
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
}
