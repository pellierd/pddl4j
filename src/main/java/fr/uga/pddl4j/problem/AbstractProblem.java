/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.parser.PDDLAction;
import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDerivedPredicate;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLExpression;
import fr.uga.pddl4j.parser.PDDLNamedTypedList;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.parser.PDDLSymbol;
import fr.uga.pddl4j.parser.PDDLTypedSymbol;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;
import fr.uga.pddl4j.problem.operator.AbstractGroundOperator;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.IntExpression;
import fr.uga.pddl4j.problem.operator.IntMethod;

import java.util.ArrayList;
import java.util.HashSet;
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
     * The PDDL domain.
     */
    private PDDLDomain domain;

    /**
     * The PDDL problem.
     */
    private PDDLProblem problem;

    /**
     * The set of accepted PDDL requirements of the problem.
     */
    private Set<PDDLRequireKey> acceptedRequirements;

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
     * The list of actions into int representation.
     */
    private List<IntAction> intActions;

    /**
     * The set of fluents of the initial state of the problem.
     */
    private Set<IntExpression> intInitPredicates;

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
     * The empty constructor to block the default constructor of object.
     */
    private AbstractProblem() {}

    /**
     * Creates a new problem from a domain and problem.
     *
     * @param domain the domain.
     * @param problem the problem.
     */
    public AbstractProblem(final PDDLDomain domain, final PDDLProblem problem) {
        this.domain = domain;
        this.problem = problem;
        this.checkRequirements();
    }

    /**
     * Returns the accepted requirements of the problem.
     *
     * @return the accepted requirements of the problem.
     */
    public final Set<PDDLRequireKey> getAcceptedRequirements() {
        return this.acceptedRequirements;
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
    public final List<String> getTypeSymbols() {
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
    public List<List<Integer>> getPredicateSignatures() {
        return this.predicateSignatures;
    }

    /**
     * Returns the list of task symbols of the problem.
     *
     * @return the list of task symbols of the problem.
     */
    public final List<String> getTaskSymbols() {
        return this.taskSymbols;
    }

    /**
     * Returns the signatures of the task defined in the problem.
     *
     * @return the signatures of the task defined in the problem.
     */
    public final List<List<Integer>> getTaskSignatures() {
        return this.taskSignatures;
    }

    /**
     * Returns the list of function symbols of the problem.
     *
     * @return the list of function symbols of the problem.
     */
    public final List<String> getFunctionSymbols() {
        return this.functionSymbols;
    }

    /**
     * Returns the signatures of the functions defined in the problem.
     *
     * @return the signatures of the functions defined in the problem.
     */
    public final List<List<Integer>> getFunctionSignatures() {
        return this.functionSignatures;
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
    protected Set<IntExpression> getIntInitPredicates() {
        return this.intInitPredicates;
    }

    /**
     * Returns the map that store the value of the numeric fluents in the form of <code>IntExpression</code> of the
     * initial state.
     *
     * @return the map that store the value of the numeric fluents in the form of <code>IntExpression</code> of the
     * initial state.
     * @see IntExpression
     */
    protected Map<IntExpression, Double> getIntInitFunctionCost() {
        return intInitFunctionCost;
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
     * Returns the parsed domain used to create of this problem.
     *
     * @return the parsed domain used to create of this problem.
     */
    protected PDDLDomain getDomain() {
        return this.domain;
    }

    /**
     * Returns the parsed problem used to create this problem.
     *
     * @return the parsed problem used to create this problem.
     */
    protected PDDLProblem getProblem() {
        return this.problem;
    }

    /**
     * Initiates the problem. This method calls in this order the methods init(), preinstantiation(), instantiation()
     * and postinstantiation().
     *
     * @param timeout the time allocated to the instantiation.
     */
    public void instantiate(int timeout) {
        this.init();
        this.preinstantiation();
        this.instantiation();
        this.postinstantiation();
    }


    /**
     * This abstract method must me override by subclass. The init method initializes the
     */
    protected abstract void init ();

    /**
     *
     */
    protected abstract void preinstantiation();

    /**
     *
     */
    protected abstract void instantiation();

    /**
     *
     */
    protected abstract void postinstantiation();



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
     * Collects the list of type symbols form the list declared in the domain. The corresponding domain of values
     * of the type is created. The domain is empty.
     */
    protected void collectTypeInformation() {
        final List<PDDLTypedSymbol> types = this.domain.getTypes();
        final int nbTypes = types.size();
        this.typeSymbols = new ArrayList<>(nbTypes);
        this.domains = new ArrayList<>(nbTypes);
        for (PDDLTypedSymbol type : types) {
            this.typeSymbols.add(type.getImage());
            this.domains.add(new LinkedHashSet<>());
        }
    }

    /**
     * Collects the constants declared in the domain and the problem and initialise the domains of values of each type.
     */
    protected void collectConstantInformation() {
        final List<PDDLTypedSymbol> constants = this.domain.getConstants();
        this.constantSymbols = new ArrayList<>(this.domain.getConstants().size());
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
                types.addAll(this.domain.getType(type).getTypes());
                this.domains.get(it).add(ic);
            }
        }
    }

    /**
     * Collects composite type, i.e., type of the form (either t1 t2), through a specified domain and
     * problem and creates their respective domain. Warning: constants must be collected before using this method. It
     * is necessary to correctly initialized the domain of the either types collected.
     */
    protected void collectEitherTypeInformation() {
        // Collect the types from the predicates declaration
        for (PDDLNamedTypedList predicate : this.domain.getPredicates()) {
            this.collectEitherTypeInformation(predicate.getArguments());
        }
        // Collect the types from the functions declaration
        for (PDDLNamedTypedList function : this.domain.getFunctions()) {
            this.collectEitherTypeInformation(function.getArguments());
        }
        // Collect the types from the constraints declaration of the domain
        if (this.domain.getConstraints() != null) {
            this.collectEitherTypeInformation(this.domain.getConstraints());
        }
        // Collect the types from the derived predicates
        for (PDDLDerivedPredicate axiom : this.domain.getDerivesPredicates()) {
            this.collectEitherTypeInformation(axiom.getHead().getArguments());
            this.collectEitherTypeInformation(axiom.getBody());
        }
        // Collect the type from the actions
        for (PDDLAction op : this.domain.getActions()) {
            this.collectEitherTypeInformation(op.getParameters());
            if (op.getDuration() != null) {
                this.collectEitherTypeInformation(op.getDuration());
            }
            this.collectEitherTypeInformation(op.getPreconditions());
            this.collectEitherTypeInformation(op.getEffects());
        }
        // Collect the types from the constraints declaration of the problem
        if (this.problem.getConstraints() != null) {
            this.collectEitherTypeInformation(this.problem.getConstraints());
        }
        // Collect the types from the goal declaration of the problem
        if (this.problem.getGoal() != null) {
            this.collectEitherTypeInformation(this.problem.getGoal());
        }
    }

    /**
     * Collects the information types from a list of PDDL typed symbols.
     *
     * @param list the list of typed symbol.
     */
    private void collectEitherTypeInformation(final List<PDDLTypedSymbol> list) {
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
     * Collects the either type from a specified expression.
     *
     * @param exp the expression.
     */
    private void collectEitherTypeInformation(final PDDLExpression exp) {
        switch (exp.getConnective()) {
            case AND:
            case OR:
                exp.getChildren().forEach(this::collectEitherTypeInformation);
                break;
            case FORALL:
            case EXISTS:
                this.collectEitherTypeInformation(exp.getVariables());
                this.collectEitherTypeInformation(exp.getChildren().get(0));
                break;
            case WHEN:
                this.collectEitherTypeInformation(exp.getChildren().get(0));
                this.collectEitherTypeInformation(exp.getChildren().get(1));
                break;
            case NOT:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
                this.collectEitherTypeInformation(exp.getChildren().get(0));
                break;
            case HOLD_AFTER:
            case WITHIN:
                this.collectEitherTypeInformation(exp.getChildren().get(1));
                break;
            case ALWAYS_WITHIN:
                this.collectEitherTypeInformation(exp.getChildren().get(1));
                this.collectEitherTypeInformation(exp.getChildren().get(2));
                break;
            case HOLD_DURING:
                this.collectEitherTypeInformation(exp.getChildren().get(2));
                break;
            case IS_VIOLATED:
            case NUMBER:
            case ATOM:
            case FN_HEAD:
            case TIME_VAR:
            case EQUAL:
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
                throw new UnexpectedExpressionException(exp.toString());
        }
    }

    /**
     * Collects predicates information (symbols and signatures) declared in the domain.
     */
    protected void collectPredicateInformation() {
        final List<PDDLNamedTypedList> predicates = this.domain.getPredicates();
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
     * Collects function information (symbols and signatures) declared in the domain.
     */
    protected void collectFunctionInformation() {
        final List<PDDLNamedTypedList> functions = this.domain.getFunctions();
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
     * Collects tasks information (symbols and signatures) declared in the domain.
     */
    protected void collectTaskInformation() {
        final List<PDDLNamedTypedList> tasks = this.domain.getTasks();
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
     * Encodes the actions of the domain into a compact integer representation.
     */
    protected void encodeIntActions() {
        this.intActions = this.domain.getActions().stream().map(this::encodeIntActions).collect(Collectors.toList());
    }

    /**
     * Encodes a specified initial state into its integer representation.
     */
    protected void encodeIntInit() {
        Set<IntExpression> init =  this.problem.getInit().stream().map(this::encodeIntExp)
            .collect(Collectors.toCollection(LinkedHashSet::new));
        this.intInitPredicates = new LinkedHashSet<>();
        this.intInitFunctionCost = new LinkedHashMap<>();
        this.intInitFunctions = new LinkedHashSet<>();
        for (IntExpression exp : init) {
            switch (exp.getConnective()) {
                case FN_ATOM:
                    this.intInitFunctions.add(exp);
                    this.intInitFunctionCost.put(exp.getChildren().get(0), exp.getChildren().get(1).getValue());
                    break;
                case ATOM:
                    this.intInitPredicates.add(exp);
                    break;
                default:
                    throw new UnexpectedExpressionException(exp.getConnective().toString());

            }
        }
    }

    /**
     * Encodes a specified goal into its integer representation.
     **/
    protected void encodeIntGoal() {
        this.intGoal = new IntExpression(PDDLConnective.AND);
        if (this.problem.getGoal() != null) {
            this.intGoal = this.encodeIntExp(this.problem.getGoal());
        }
    }

    /**
     * Encode an operator into its integer representation.
     *
     * @param action the operator to encode.
     * @return encoded operator.
     */
    private IntAction encodeIntActions(final PDDLAction action) {
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
            final IntExpression duration = this.encodeIntExp(action.getDuration(), variables);
            intAction.setDuration(duration);
        }
        // Encode the preconditions of the operator
        final IntExpression preconditions = this.encodeIntExp(action.getPreconditions(), variables);
        intAction.setPreconditions(preconditions);
        // Encode the effects of the operator
        final IntExpression effects = this.encodeIntExp(action.getEffects(), variables);
        intAction.setEffects(effects);
        return intAction;
    }


    /**
     * Encodes an specified expression into its integer representation.
     *
     * @param exp the expression to encode.
     * @return the integer representation of the specified expression.
     */
    private IntExpression encodeIntExp(final PDDLExpression exp) {
        return this.encodeIntExp(exp, new ArrayList<>());
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
            case AND:
            case OR:
                for (int i = 0; i < exp.getChildren().size(); i++) {
                    intExp.getChildren().add(this.encodeIntExp(exp.getChildren().get(i), variables));
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
                    intExp.getChildren().add(this.encodeIntExp(exp.getChildren().get(0), newVariables));
                } else {
                    qvar.remove(0);
                    intExp.getChildren().add(this.encodeIntExp(exp, newVariables));
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
                intExp.getChildren().add(this.encodeIntExp(exp.getChildren().get(0), variables));
                intExp.getChildren().add(this.encodeIntExp(exp.getChildren().get(1), variables));
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
                intExp.getChildren().add(this.encodeIntExp(exp.getChildren().get(0), variables));
                break;
            case NUMBER:
                intExp.setValue(exp.getValue());
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                intExp.getChildren().add(this.encodeIntExp(exp.getChildren().get(0), variables));
                intExp.getChildren().add(this.encodeIntExp(exp.getChildren().get(1), variables));
                intExp.getChildren().add(this.encodeIntExp(exp.getChildren().get(2), variables));
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
    protected String toStringType(final List<PDDLSymbol> types) {
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
            final String type = this.getTypeSymbols().get(action.getTypeOfParameters(i));
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
     * @param method       the method to print.
     * @return a string representation of the specified method.
     */
    protected String toString(final IntMethod method) {
        final StringBuilder str = new StringBuilder();
        str.append("Method ").append(method.getName()).append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < method.arity(); i++) {
            final int index = method.getValueOfParameter(i);
            final String type = this.getTypeSymbols().get(method.getTypeOfParameters(i));
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
     * @param exp        the expression.
     * @return a string representation of the specified expression.
     */
    protected String toString(final IntExpression exp, final String separator) {
        return this.toString(exp, "", separator);
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp        the expression.
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
                str.append("(").append(this.getFunctionSymbols().get(exp.getPredicate()));
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
                str.append(this.getTypeSymbols().get(exp.getType())).append(")\n").append(offsetEx);
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
                str.append("DEFAULT");
                break;
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

}
