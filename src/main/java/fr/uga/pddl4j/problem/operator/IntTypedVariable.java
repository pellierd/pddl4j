package fr.uga.pddl4j.problem.operator;

import java.io.Serializable;
import java.util.Objects;

public class IntTypedVariable implements Serializable  {

    private int variable;

    private int type;

    private IntTypedVariable(){ }

    public IntTypedVariable(final int variable, final int type) {
        super();

    }

    public final void setVariable(final int variable) {
        this.variable = variable;
    }
    public final int getVariable() {
        return this.variable;
    }

    public final void setType(final int type) {
        this.type = type;
    }

    public final int getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object != null && this.getClass().equals(object.getClass())) {
            final IntTypedVariable other = (IntTypedVariable) object;
            return Objects.equals(this.getVariable(), this.getType());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getVariable(), this.getType());
    }

    public String toString() {
        return "[" + this.getVariable() + ", " + this.getType() + "]";
    }
}
