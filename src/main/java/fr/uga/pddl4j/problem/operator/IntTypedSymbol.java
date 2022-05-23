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

package fr.uga.pddl4j.problem.operator;

import fr.uga.pddl4j.parser.TypedSymbol;

import java.util.Objects;

/**
 * This class implements a typed symbol. This class is used to store the quantified variables of the class
 * <code>IntExpression</code>.
 *
 * @author D. Pellier
 * @version 1.0 - 20.05.2022
 */
public class IntTypedSymbol implements TypedSymbol {

    /**
     * The int representation of the variable. The value must be negative.
     */
    private int variable;

    /**
     * the int representation of the type.
     */
    private int type;

    /**
     * The empty constructor. The constructor is private to prevent the inheritance of the empty constraint of the
     * object class.
     */
    private IntTypedSymbol(){ }

    /**
     *  Creates a new typed variable.
     *
     * @param variable the variable. The variable must be less than 0.
     * @param type the type of the variable. The type must be greater or equal to 0.
     */
    public IntTypedSymbol(final int variable, final int type) {
        super();
        this.setVariable(variable);
        this.setType(type);
    }

    /**
     * Creates a deep copy of typed variable.
     *
     * @param other the other typed variable.
     */
    public IntTypedSymbol(final IntTypedSymbol other) {
        this(other.getVariable(), other.getType());
    }

    /**
     * Sets the variable of this typed variable.
     *
     * @param variable the variable to set. The variable must be less than 0.
     * @exception IllegalArgumentException if the <code>variable >= 0</code>.
     */
    public final void setVariable(final int variable) throws IllegalArgumentException {
        if (variable >= 0) throw new IllegalArgumentException("variable >= 0");
        this.variable = variable;
    }

    /**
     * Returns the variable of this typed variable.
     *
     * @return the variable.
     */
    public final int getVariable() {
        return this.variable;
    }

    /**
     * Sets the type of the typed variable.
     *
     * @param type the type of the typed variable. The type must be greater or equal than 0.
     * @exception IllegalArgumentException if the <code>type < 0</code>.
     */
    public final void setType(final int type) throws IllegalArgumentException {
        if (type < 0) throw new IllegalArgumentException("type < 0");
        this.type = type;
    }

    /**
     * Returns the type of the typed variable.
     *
     * @return the type of the typed variable.
     */
    public final int getType() {
        return this.type;
    }

    /**
     * Returns if a object is equal to this typed variable. An object is equal to this typed variable if the object is
     * of class <code>TypedVariable</code> and represents the same variable and has the same type.
     *
     * @param object the object to be compared.
     * @return <code>true</code> if object in parameter is equal to this typed variable, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object != null && this.getClass().equals(object.getClass())) {
            final IntTypedSymbol other = (IntTypedSymbol) object;
            return Objects.equals(this.getVariable(), this.getType());
        }
        return false;
    }

    /**
     * Returns the hash code value of this typed variable.
     *
     * @return the hash code value of this typed variable.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getVariable(), this.getType());
    }

    /**
     * Returns a deep copy of this typed symbol.
     *
     * @return a deep copy of this typed symbol.
     */
    @Override
    public IntTypedSymbol clone() {
        return new IntTypedSymbol(this);
    }

    /**
     * Returns a string representation of this typed variable.
     *
     * @return a string representation of this typed variable.
     */
    public String toString() {
        return "[" + this.getVariable() + ", " + this.getType() + "]";
    }

}
