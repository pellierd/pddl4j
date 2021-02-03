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
import fr.uga.pddl4j.parser.PDDLDerivedPredicate;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLExpression;
import fr.uga.pddl4j.parser.PDDLMethod;
import fr.uga.pddl4j.parser.PDDLNamedTypedList;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.PDDLRequireKey;
import fr.uga.pddl4j.parser.PDDLSymbol;
import fr.uga.pddl4j.parser.PDDLTypedSymbol;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
     * The empty constructor to block the default constructor of object.
     */
    private AbstractProblem() {
    }

    /**
     * Creates a new problem from a domain and problem.
     *
     * @param domain  the domain.
     * @param problem the problem.
     */
    public AbstractProblem(final PDDLDomain domain, final PDDLProblem problem) {
        this.domain = domain;
        this.problem = problem;
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
     *
     * @param timeout the time allocated to the instantiation.
     */
    public void instantiate(int timeout) {
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
     * the static properties (Inretia) of the problem in order to prune as soon as possible the actions that can never
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
     * This methods finalize the domain, i.e., it encode the planning problem into it final compact representation using
     * bit set.
     */
    protected abstract void finalization();

    /**
     * Init the list of requirement of the problem.
     *
     * @throws RequirementNotSupportedException if the requirements of the domain and the problem are not supported.
     */
    protected void initRequirements() throws RequirementNotSupportedException {
        this.requirements = new LinkedHashSet<>();
        this.requirements.addAll(this.domain.getRequirements());
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
     * Initializes the constants declared in the domain and the problem and initialise the domains of values of each type.
     */
    protected void initConstants() {
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
     * Initializes the composite type, i.e., type of the form (either t1 t2), through a specified domain and
     * problem and creates their respective domain. Warning: constants must be collected before using this method. It
     * is necessary to correctly initialized the domain of the either types collected.
     */
    protected void initEitherTypes() {
        // Collect the types from the predicates declaration
        for (PDDLNamedTypedList predicate : this.domain.getPredicates()) {
            this.initEitherTypes(predicate.getArguments());
        }
        // Collect the types from the functions declaration
        for (PDDLNamedTypedList function : this.domain.getFunctions()) {
            this.initEitherTypes(function.getArguments());
        }
        // Collect the types from the constraints declaration of the domain
        if (this.domain.getConstraints() != null) {
            this.initEitherTypes(this.domain.getConstraints());
        }
        // Collect the types from the derived predicates
        for (PDDLDerivedPredicate axiom : this.domain.getDerivesPredicates()) {
            this.initEitherTypes(axiom.getHead().getArguments());
            this.initEitherTypes(axiom.getBody());
        }
        // Collect the type from the actions
        for (PDDLAction op : this.domain.getActions()) {
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
     * Initializes the function information (symbols and signatures) declared in the domain.
     */
    protected void initFunctions() {
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
     * Initializes the tasks information (symbols and signatures) declared in the domain.
     */
    protected void initTasks() {
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
     * Initializes the primitive task symbols from the actions of the domain.
     */
    protected void initPrimitiveTaskSymbols() {
        this.primitiveTaskSymbols = new LinkedHashSet<>();
        for (PDDLAction a : this.getDomain().getActions()) {
            this.primitiveTaskSymbols.add(a.getName().getImage());
        }
    }

    /**
     * Initializes the compound task symbols from the methods of the domain.
     */
    protected void initCompundTaskSymbols() {
        this.compoundTaskSymbols = new LinkedHashSet<>();
        for (PDDLMethod m : this.getDomain().getMethods()) {
            this.compoundTaskSymbols.add(m.getTask().getAtom().get(0).getImage());
        }
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

}
