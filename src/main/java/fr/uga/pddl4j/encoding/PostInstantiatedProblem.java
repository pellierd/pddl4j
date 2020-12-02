package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by pellier on 02/12/2020.
 */
public abstract class PostInstantiatedProblem extends InstantiatedProblem {

    /**
     * The table that contains the ground inertia.
     */
    private Map<IntExpression, Inertia> tableOfGroundInertia;

    /**
     * The table that contains the ground inertia.
     */
    private Map<IntExpression, Inertia> tableOfNumericGroundInertia;


    public PostInstantiatedProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }

    public void postInstantiate() {
        this.extractGroundInertia();
        this.extractGroundNumericInertia();
    }


    public Map<IntExpression, Inertia> getTableOfGroundInertia() {
        return tableOfGroundInertia;
    }

    public Map<IntExpression, Inertia> getTableOfNumericGroundInertia() {
        return tableOfNumericGroundInertia;
    }

    /**
     * Do a pass over the effects of a specified list of instantiated actions and update the ground
     * inertia table.
     *
     */
    protected void extractGroundInertia() {
        this.tableOfGroundInertia = new LinkedHashMap<>(Constants.DEFAULT_RELEVANT_FACTS_TABLE_SIZE);
        for (IntAction a : this.getIntActions()) {
            extractGroundInertia(a.getEffects());
        }
    }

    /**
     * Do a pass over the effects of an instantiated action and update the ground inertia table.
     *
     * @param exp the effect.
     */
    private void extractGroundInertia(final IntExpression exp) {
        switch (exp.getConnective()) {
            case ATOM:
                Inertia inertia = this.tableOfGroundInertia.get(exp);
                if (inertia == null) {
                    inertia = Inertia.INERTIA;
                }
                switch (inertia) {
                    case INERTIA:
                        this.tableOfGroundInertia.put(exp, Inertia.NEGATIVE);
                        break;
                    case POSITIVE:
                        this.tableOfGroundInertia.put(exp, Inertia.FLUENT);
                        break;
                    default:
                        // do nothing
                }
                break;
            case AND:
            case OR:
                exp.getChildren().forEach(this::extractGroundInertia);
                break;
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
                extractGroundInertia(exp.getChildren().get(0));
                break;
            case WHEN:
                extractGroundInertia(exp.getChildren().get(1));
                break;
            case NOT:
                final IntExpression neg = exp.getChildren().get(0);
                if (neg.getConnective().equals(PDDLConnective.ATOM)) {
                    inertia = this.tableOfGroundInertia.get(neg);
                    if (inertia == null) {
                        inertia = Inertia.INERTIA;
                    }
                    switch (inertia) {
                        case INERTIA:
                            this.tableOfGroundInertia.put(neg, Inertia.POSITIVE);
                            break;
                        case NEGATIVE:
                            this.tableOfGroundInertia.put(neg, Inertia.FLUENT);
                            break;
                        default:
                            // do nothing
                    }
                }
                break;
            case F_EXP_T:
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
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
            case ALWAYS_WITHIN:
            case HOLD_DURING:
            case TIME_VAR:
            case IS_VIOLATED:
            case NUMBER:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case ALWAYS:
            case OVER_ALL:
            case SOMETIME:
            case AT_MOST_ONCE:
            case F_EXP:
                break;
            default:
                // do nothing
        }
    }

    /**
     * Do a pass over the effects of a specified list of instantiated actions and update the ground
     * inertia table.
     */
    protected void extractGroundNumericInertia() {
        this.tableOfNumericGroundInertia = new LinkedHashMap<>(Constants.DEFAULT_RELEVANT_FACTS_TABLE_SIZE);
        for (IntAction a : this.getIntActions()) {
            this.extractGroundNumericInertia(a.getEffects());
        }
    }

    /**
     * Do a pass over the effects of an instantiated action and update the ground numeric inertia table.
     * A numeric inertia is a function that is never change by any action of the problem.
     * PDDLConnetive checks.
     *
     * @param exp the effect.
     */
    private void extractGroundNumericInertia(final IntExpression exp) {
        switch (exp.getConnective()) {
            case AND:
                exp.getChildren().forEach(this::extractGroundNumericInertia);
                break;
            case WHEN:
                extractGroundNumericInertia(exp.getChildren().get(1));
                break;
            case NOT:
                extractGroundNumericInertia(exp.getChildren().get(0));
                break;
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
                this.getTableOfNumericGroundInertia().put(exp.getChildren().get(0), Inertia.FLUENT);
                break;
            case ATOM:
            case TRUE:
            case FALSE:
                // Do nothing
                break;
            default:
                throw new UnexpectedExpressionException(exp.getConnective().getImage());
        }
    }
}
