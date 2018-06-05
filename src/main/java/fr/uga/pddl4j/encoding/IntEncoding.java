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

import fr.uga.pddl4j.parser.DerivedPredicate;
import fr.uga.pddl4j.parser.Domain;
import fr.uga.pddl4j.parser.Exp;
import fr.uga.pddl4j.parser.NamedTypedList;
import fr.uga.pddl4j.parser.Op;
import fr.uga.pddl4j.parser.Problem;
import fr.uga.pddl4j.parser.Symbol;
import fr.uga.pddl4j.parser.TypedSymbol;
import fr.uga.pddl4j.util.IntExp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class implements all the methods needed to encode operators, goal and initial state loaded
 * from the parser in its integer representation.
 *
 * @author D. Pellier
 * @version 1.0 - 08.06.2010
 */
final class IntEncoding implements Serializable {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default constructor with a private access to prevent instance creation.
     */
    private IntEncoding() {
    }

    /**
     * Collects composite type, i.e., type of the form (either t1 t2), through a specified domain and
     * problem and creates their respective domain.
     *
     * @param domain  the domain.
     * @param problem the problem.
     */
    static void encodeEitherTypes(final Domain domain, final Problem problem) {
        // Collect the types from the predicates declaration
        for (NamedTypedList predicate : domain.getPredicates()) {
            IntEncoding.encodeTypes(predicate.getArguments());
        }
        // Collect the types from the functions declaration
        for (NamedTypedList function : domain.getFunctions()) {
            IntEncoding.encodeTypes(function.getArguments());
        }
        // Collect the types from the constraints declaration of the domain
        if (domain.getConstraints() != null) {
            IntEncoding.encodeTypes(domain.getConstraints());
        }
        // Collect the types from the derived predicates
        for (DerivedPredicate axiom : domain.getDerivesPredicates()) {
            IntEncoding.encodeTypes(axiom.getHead().getArguments());
            IntEncoding.encodeTypes(axiom.getBody());
        }
        // Collect the type from the operators
        for (Op op : domain.getOperators()) {
            IntEncoding.encodeTypes(op.getParameters());
            if (op.getDuration() != null) {
                IntEncoding.encodeTypes(op.getDuration());
            }
            IntEncoding.encodeTypes(op.getPreconditions());
            IntEncoding.encodeTypes(op.getEffects());
        }
        // Collect the types from the constraints declaration of the problem
        if (problem.getConstraints() != null) {
            IntEncoding.encodeTypes(problem.getConstraints());
        }
        // Collect the types from the goal declaration of the problem
        IntEncoding.encodeTypes(problem.getGoal());

    }

    /**
     * Encodes all the types of a specified domain.
     *
     * @param domain the domain.
     */
    static void encodeTypes(final Domain domain) {
        final List<TypedSymbol> types = domain.getTypes();
        final int nbTypes = types.size();
        Encoder.tableOfTypes = new ArrayList<>(nbTypes);
        Encoder.tableOfDomains = new ArrayList<>(nbTypes);
        for (TypedSymbol type : types) {
            Encoder.tableOfTypes.add(type.getImage());
            Encoder.tableOfDomains.add(new LinkedHashSet<>());
        }
    }

    /**
     * Encoded all the type from a specified list of typed symbols.
     *
     * @param list the list of typed symbol.
     */
    private static void encodeTypes(final List<TypedSymbol> list) {
        for (TypedSymbol elt : list) {
            final List<Symbol> types = elt.getTypes();
            if (types.size() > 1) {
                String newType;
                Set<Integer> newTypeDomain = new LinkedHashSet<>();
                StringBuilder buf = new StringBuilder();
                buf.append("either");
                for (Symbol type : types) {
                    final String image = type.getImage();
                    buf.append("~");
                    buf.append(image);
                    int typeIndex = Encoder.tableOfTypes.indexOf(image);
                    final Set<Integer> typeDomain = Encoder.tableOfDomains.get(typeIndex);
                    newTypeDomain.addAll(typeDomain);
                }
                newType = buf.toString();
                int index = Encoder.tableOfTypes.indexOf(newType);
                if (index == -1) {
                    Encoder.tableOfDomains.add(new LinkedHashSet<>(newTypeDomain));
                    Encoder.tableOfTypes.add(newType);
                }
            }
        }
    }

    /**
     * Encodes all the type from a specified expression.
     *
     * @param exp the expression.
     */
    private static void encodeTypes(final Exp exp) {
        switch (exp.getConnective()) {
            case AND:
            case OR:
                exp.getChildren().forEach(IntEncoding::encodeTypes);
                break;
            case FORALL:
            case EXISTS:
                IntEncoding.encodeTypes(exp.getVariables());
                IntEncoding.encodeTypes(exp.getChildren().get(0));
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    IntEncoding.encodeTypes(exp.getChildren().get(0));
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
                IntEncoding.encodeTypes(exp.getChildren().get(0));
                IntEncoding.encodeTypes(exp.getChildren().get(1));
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
                IntEncoding.encodeTypes(exp.getChildren().get(0));
                break;
            case HOLD_AFTER:
            case WITHIN:
                IntEncoding.encodeTypes(exp.getChildren().get(1));
                break;
            case ALWAYS_WITHIN:
                IntEncoding.encodeTypes(exp.getChildren().get(1));
                IntEncoding.encodeTypes(exp.getChildren().get(2));
                break;
            case HOLD_DURING:
                IntEncoding.encodeTypes(exp.getChildren().get(2));
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
    static void encodeConstants(final Domain domain, final Problem problem) {
        final List<TypedSymbol> constants = domain.getConstants();
        Encoder.tableOfConstants = new ArrayList<>(domain.getConstants().size());
        constants.addAll(problem.getObjects());
        for (TypedSymbol constant : constants) {
            int ic = Encoder.tableOfConstants.indexOf(constant.getImage());
            if (ic == -1) {
                ic = Encoder.tableOfConstants.size();
                Encoder.tableOfConstants.add(constant.getImage());
            }
            final LinkedList<Symbol> types = new LinkedList<>(constant.getTypes());
            while (!types.isEmpty()) {
                Symbol type = types.poll();
                final int it = Encoder.tableOfTypes.indexOf(type.getImage());
                types.addAll(domain.getType(type).getTypes());
                Encoder.tableOfDomains.get(it).add(ic);
            }
        }
    }

    /**
     * Encodes all the predicates of a specified domain.
     *
     * @param domain the domain.
     */
    static void encodePredicates(final Domain domain) {
        final List<NamedTypedList> predicates = domain.getPredicates();
        final int nbPredicates = predicates.size();
        Encoder.tableOfPredicates = new ArrayList<>(nbPredicates);
        Encoder.tableOfTypedPredicates = new ArrayList<>(nbPredicates);
        for (NamedTypedList predicate : predicates) {
            Encoder.tableOfPredicates.add(predicate.getName().getImage());
            final List<TypedSymbol> arguments = predicate.getArguments();
            final List<Integer> argType = new ArrayList<>(arguments.size());
            for (TypedSymbol arg : arguments) {
                final List<Symbol> types = arg.getTypes();
                if (types.size() > 1) {
                    final StringBuilder image = new StringBuilder("either");
                    for (Symbol type : types) {
                        image.append("~");
                        image.append(type.getImage());
                    }
                    argType.add(Encoder.tableOfTypes.indexOf(image.toString()));
                } else {
                    argType.add(Encoder.tableOfTypes.indexOf(types.get(0).getImage()));
                }
            }
            Encoder.tableOfTypedPredicates.add(argType);
        }
    }

    /**
     * Encodes all the function of a specified domain.
     *
     * @param domain the domain.
     */
    static void encodeFunctions(final Domain domain) {
        final List<NamedTypedList> functions = domain.getFunctions();
        Encoder.tableOfFunctions = new ArrayList<>(functions.size());
        Encoder.tableOfTypedFunctions = new ArrayList<>(functions.size());
        for (NamedTypedList function : functions) {
            Encoder.tableOfFunctions.add(function.getName().getImage());
            List<TypedSymbol> arguments = function.getArguments();
            List<Integer> argType = new ArrayList<>(arguments.size());
            for (TypedSymbol argument : arguments) {
                List<Symbol> types = argument.getTypes();
                if (types.size() > 1) {
                    StringBuilder type = new StringBuilder("either");
                    for (Symbol type1 : types) {
                        type.append("~").append(type1.getImage());
                    }
                    argType.add(Encoder.tableOfTypes.indexOf(type.toString()));
                } else {
                    argType.add(Encoder.tableOfTypes.indexOf(types.get(0).getImage()));
                }
            }
            Encoder.tableOfTypedFunctions.add(argType);

        }
    }

    /**
     * Encodes a specified list of operators into its integer representation.
     *
     * @param ops the list of operators to encode.
     * @return encoded the list of operators encoded.
     */
    static List<IntOp> encodeOperators(final List<Op> ops) {
        return ops.stream().map(IntEncoding::encodeOperator).collect(Collectors.toList());
    }

    /**
     * Encodes a specified initial state into its integer representation.
     *
     * @param init the initial state to encode.
     * @return the initial state encoded.
     */
    static Set<IntExp> encodeInit(final List<Exp> init) {
        return init.stream().map(IntEncoding::encodeExp).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Encodes functions and costs from initial state into its integer representation.
     *
     * @param init the initial state encoded.
     * @return the encoded functions and costs from initial state.
     */
    static Map<IntExp, Double> encodeFunctionCostInit(final Set<IntExp> init) {
        Map<IntExp, Double> intFunctionCost = new HashMap<>();
        for (IntExp intExp : init) {
            if (intExp.getConnective().getImage().equals("=")) {
                intFunctionCost.put(intExp.getChildren().get(0),
                    Double.parseDouble(StringEncoder.toString(intExp.getChildren().get(1),
                        Encoder.tableOfConstants,
                        Encoder.tableOfTypes,
                        Encoder.tableOfPredicates,
                        Encoder.tableOfFunctions, "")));
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
    static Set<IntExp> removeFunctionCost(final Set<IntExp> init) {
        return init.stream().filter(x -> !x.getConnective().getImage().equals("="))
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Encodes a specified goal into its integer representation.
     *
     * @param goal the goal to encode.
     * @return the goal encoded.
     */
    static IntExp encodeGoal(final Exp goal) {
        return IntEncoding.encodeExp(goal);
    }


    /**
     * Encode an operator into its integer representation.
     *
     * @param op the operator to encode.
     * @return encoded operator.
     */
    private static IntOp encodeOperator(final Op op) {
        final IntOp intOp = new IntOp(op.getName().getImage(), op.getArity());
        // Encode the parameters of the operator
        final List<String> variables = new ArrayList<>(op.getArity());
        for (int i = 0; i < op.getArity(); i++) {
            final TypedSymbol parameter = op.getParameters().get(i);
            final String typeImage = IntEncoding.toStringType(parameter.getTypes());
            final int type = Encoder.tableOfTypes.indexOf(typeImage);
            intOp.setTypeOfParameter(i, type);
            variables.add(parameter.getImage());
        }
        // Encode the preconditions of the operator
        final IntExp preconditions = IntEncoding.encodeExp(op.getPreconditions(), variables);
        intOp.setPreconditions(preconditions);
        // Encode the effects of the operator
        final IntExp effects = IntEncoding.encodeExp(op.getEffects(), variables);
        intOp.setEffects(effects);
        return intOp;
    }

    /**
     * Encodes an specified expression into its integer representation.
     *
     * @param exp the expression to encode.
     * @return the integer representation of the specified expression.
     */
    private static IntExp encodeExp(final Exp exp) {
        return IntEncoding.encodeExp(exp, new ArrayList<>());
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
    private static IntExp encodeExp(final Exp exp,
                                    final List<String> variables) {
        final IntExp intExp = new IntExp(exp.getConnective());
        switch (exp.getConnective()) {
            case EQUAL_ATOM:
                intExp.setPredicate(IntExp.EQUAL_PREDICATE);
                int[] args = new int[exp.getAtom().size()];
                for (int i = 0; i < exp.getAtom().size(); i++) {
                    final Symbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(Symbol.Kind.VARIABLE)) {
                        args[i] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i] = Encoder.tableOfConstants.indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case FN_HEAD:
                final String functor = exp.getAtom().get(0).getImage();
                intExp.setPredicate(Encoder.tableOfFunctions.indexOf(functor));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final Symbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(Symbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = Encoder.tableOfConstants.indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case ATOM:
                final String predicate = exp.getAtom().get(0).getImage();
                intExp.setPredicate(Encoder.tableOfPredicates.indexOf(predicate));
                args = new int[exp.getAtom().size() - 1];
                for (int i = 1; i < exp.getAtom().size(); i++) {
                    final Symbol argument = exp.getAtom().get(i);
                    if (argument.getKind().equals(Symbol.Kind.VARIABLE)) {
                        args[i - 1] = -variables.indexOf(argument.getImage()) - 1;
                    } else {
                        args[i - 1] = Encoder.tableOfConstants.indexOf(argument.getImage());
                    }
                }
                intExp.setArguments(args);
                break;
            case AND:
            case OR:
                for (int i = 0; i < exp.getChildren().size(); i++) {
                    intExp.getChildren().add(IntEncoding.encodeExp(exp.getChildren().get(i), variables));
                }
                break;
            case FORALL:
            case EXISTS:
                final List<String> newVariables = new ArrayList<>(variables);
                final List<TypedSymbol> qvar = exp.getVariables();
                final String type = IntEncoding.toStringType(qvar.get(0).getTypes());
                int typeIndex = Encoder.tableOfTypes.indexOf(type);
                intExp.setType(typeIndex);
                intExp.setVariable(-variables.size() - 1);
                newVariables.add(qvar.get(0).getImage());
                if (qvar.size() == 1) {
                    intExp.getChildren().add(IntEncoding.encodeExp(exp.getChildren().get(0), newVariables));
                } else {
                    qvar.remove(0);
                    intExp.getChildren().add(IntEncoding.encodeExp(exp, newVariables));
                }
                break;
            case F_EXP_T:
                if (!exp.getChildren().isEmpty()) {
                    intExp.getChildren().add(IntEncoding.encodeExp(exp.getChildren().get(0), variables));
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
                intExp.getChildren().add(IntEncoding.encodeExp(exp.getChildren().get(0), variables));
                intExp.getChildren().add(IntEncoding.encodeExp(exp.getChildren().get(1), variables));
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
                intExp.getChildren().add(IntEncoding.encodeExp(exp.getChildren().get(0), variables));
                break;
            case NUMBER:
                intExp.setValue(exp.getValue());
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                intExp.getChildren().add(IntEncoding.encodeExp(exp.getChildren().get(0), variables));
                intExp.getChildren().add(IntEncoding.encodeExp(exp.getChildren().get(1), variables));
                intExp.getChildren().add(IntEncoding.encodeExp(exp.getChildren().get(2), variables));
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
    private static String toStringType(final List<Symbol> types) {
        final StringBuilder str = new StringBuilder();
        if (types.size() > 1) {
            str.append("either");
            for (Symbol type : types) {
                str.append("~");
                str.append(type.getImage());
            }
        } else {
            str.append(types.get(0).getImage());
        }
        return str.toString();
    }
}
