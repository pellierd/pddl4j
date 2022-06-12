package fr.uga.pddl4j.problem.operator;

import fr.uga.pddl4j.problem.time.TemporalCondition;

public abstract class AbstractDurativeOperator extends AbstractInstantiatedOperator {

    /**
     * The time condition of the operator.
     */
    private TemporalCondition precondition;

    /**
     * Creates a new operator from an other.
     *
     * @param other the other operator.
     */
    protected AbstractDurativeOperator(final AbstractDurativeOperator other) {
        super(other);
        this.precondition = other.getPrecondition();
    }

    /**
     * Creates a new operator.
     *
     * @param name  the name of the operator.
     * @param arity the arity of the operator.
     */
    protected AbstractDurativeOperator(final String name, final int arity) {
        super(name, arity);
        this.precondition = new TemporalCondition();
    }

    /**
     * Creates a new operator. The length of the parameters and the length of instantiations must be the same.
     *
     * @param name           the name of the operator.
     * @param parameters     the types of the parameters.
     * @param instantiations the values of the parameters.
     * @param preconditions  the precondition of the operator.
     */
    protected AbstractDurativeOperator(final String name, final int[] parameters, final int[] instantiations,
                               final TemporalCondition preconditions) {
        super(name, parameters, instantiations);
        this.precondition = preconditions;
    }

    /**
     * Return the precondition of the operator.
     *
     * @return the precondition of the operator.
     */
    public final TemporalCondition getPrecondition() {
        return this.precondition;
    }

    /**
     * Set the precondition of the operator.
     *
     * @param precondition the precondition to set.
     */
    public final void setPrecondition(final TemporalCondition precondition) {
        this.precondition = precondition;
    }
}