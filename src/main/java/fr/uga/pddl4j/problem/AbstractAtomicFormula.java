/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.problem;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class implements an atomic formula.
 *
 * @author D. Pellier
 * @version 1.0 - 28.04.2020
 * @since 4.0
 */
public abstract class AbstractAtomicFormula implements AtomicFormula {

    /**
     * The symbol of the atomic formula.
     */
    private int symbol;

    /**
     * The list of arguments of the atomic formula.
     */
    private int[] arguments;

    /**
     * The default constructor set private to stop the heritage of the default constructor.
     */
    private AbstractAtomicFormula() {
        super();
    }

    /**
     * Creates a new atomic formula from an other formula. This constructor create a deep copy of the formula in
     * parameter.
     *
     * @param other the other atomic formula.
     */
    public AbstractAtomicFormula(final AbstractAtomicFormula other) {
        super();
        this.setSymbol(other.getSymbol());
        if (this.getArguments() != null) {
            this.setArguments(Arrays.copyOf(other.getArguments(), other.getArguments().length));
        }
    }

    /**
     * Creates a new atomic formula with a specified symbol and list of arguments.
     *
     * @param symbol the symbol of the atomic formula.
     * @param arguments the list of arguments of the atomic formula.
     */
    public AbstractAtomicFormula(final int symbol, final int[] arguments) {
        super();
        this.setSymbol(symbol);
        this.setArguments(arguments);
    }

    /**
     * Returns the symbol of this atomic formula.
     *
     * @return the symbol of this atomic formula.
     */
    public final int getSymbol() {
        return this.symbol;
    }

    /**
     * Sets the symbole of this atomic formula.
     *
     * @param symbol the symbol of the atomic fomula.
     */
    public final void setSymbol(final int symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the arguments of the atomic formula.
     *
     * @return the arguments of the atomic formula.
     */
    public final int[] getArguments() {
        return this.arguments;
    }

    /**
     * Sets the arguments of the atomic formula.
     *
     * @param arguments the arguments of the atomic formula.
     */
    public final void setArguments(final int[] arguments) {
        this.arguments = arguments;
    }

    /**
     * Returns the arity of this atomic formula, i.e., the number of arguments of the atomic formula.
     *
     * @return the arity of this atomic formula.
     */
    public final int arity() {
        return this.arguments.length;
    }

    /**
     * Return if a specified object is equals to this atomic formula. The specified object is equal to
     * the atomic formula if and only if the object is an instance of the class <code>AbstractAtomicFormula</code>
     * and it has the same symbol and list of arguments.
     *
     * @param obj the specified object to compared.
     * @return <code>true</code> if the specified object is equal to the atomic formula;
     * <code>false</code> otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof AbstractAtomicFormula) {
            final AbstractAtomicFormula other = (AbstractAtomicFormula) obj;
            return this.symbol == other.symbol
                && Objects.equals(this.arguments, other.arguments);
        }
        return false;
    }

    /**
     * Returns the hash code value of the atomic formula.
     *
     * @return the hash code value of the atomic formula.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.symbol, this.arguments);
    }

    /**
     * Returns a string representation of this atomic formula.
     *
     * @return a string representation of this atomic formula.
     */
    public String toString() {
        final StringBuffer str = new StringBuffer();
        str.append("(");
        str.append(this.symbol);
        for (Integer arg : this.arguments) {
            str.append(" ");
            str.append(arg);
        }
        str.append(")");
        return str.toString();
    }
}
