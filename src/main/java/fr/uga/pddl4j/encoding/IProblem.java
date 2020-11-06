package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.*;
import fr.uga.pddl4j.problem.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pellier on 05/11/2020.
 */
public class IProblem {

    /**
     * The set of requirements.
     */
    private Set<PDDLRequireKey> requirements;

    /**
     *
     */
    public IProblem(PDDLDomain domain, PDDLProblem problem) {
        this.requirements = new LinkedHashSet<>();
        this.requirements.addAll(domain.getRequirements());
        this.requirements.addAll(problem.getRequirements());

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
        for (PDDLAction action : domain.getActions()) {
            this.encodeTypes(action.getParameters());
            this.encodeTypes(action.getPreconditions());
            this.encodeTypes(action.getEffects());
        }
        // Collect the type from the methods
        for (PDDLMethod method: domain.getMethods()) {
            this.encodeTypes(method.getParameters());
            this.encodeTypes(method.getPreconditions());
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
    static void encodeTypes(final PDDLDomain domain) {
        final List<PDDLTypedSymbol> types = domain.getTypes();
        final int nbTypes = types.size();
        Encoder.tableOfTypes = new ArrayList<>(nbTypes);
        Encoder.tableOfDomains = new ArrayList<>(nbTypes);
        for (PDDLTypedSymbol type : types) {
            Encoder.tableOfTypes.add(type.getImage());
            Encoder.tableOfDomains.add(new LinkedHashSet<>());
        }
    }

    /**
     * Encodes all the type from a specified expression.
     *
     * @param exp the expression.
     */
    private void encodeTypes(final PDDLExpression exp) {
        switch (exp.getConnective()) {
            case FORALL:
            case EXISTS:
                this.encodeTypes(exp.getVariables());
                this.encodeTypes(exp.getChildren().get(0));
                break;
            default:
                exp.getChildren().forEach(this::encodeTypes);
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
}
