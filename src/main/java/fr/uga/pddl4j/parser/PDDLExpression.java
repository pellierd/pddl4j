/*
 * Copyright (c) 2022 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.parser;

import fr.uga.pddl4j.parser.lexer.Token;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * This class defines the method an PDDL expression.
 *
 * @author D. Pellier
 * @version 1.0 - 13.05.2022
 */
public class PDDLExpression extends Expression<String> {

    /**
     * Creates a new abstract expression from another one. This constructor creates a deep copy.
     *
     * @param other the other expression.
     * @throws NullPointerException if other is null.
     */
    public PDDLExpression(final PDDLExpression other) {
        super(other);
    }

    /**
     * Creates a new abstract PDDL expression with a specified connective.
     *
     * @param connective the connective.
     * @throws RuntimeException if the specified connective is null.
     */
    public PDDLExpression(final PDDLConnective connective) {
        super(connective);
    }

    /**
     * Creates a new empty AND expression.
     */
    public PDDLExpression() {
        this(PDDLConnective.AND);
    }

    /*
     * Return if this expression is equal to another object.
     *
     * @param object the other object.
     * @return <tt>true</tt> if this expression is equal to <tt>object</tt>, i.e., <tt>other</tt> is
     *          not null and is an instance of <tt>PDDLExpression</tt> and it has the same connective, children,
     *          atom, value, preference name, variable, value, taskID and task interval; otherwise return
     *          <tt>false</tt>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof PDDLExpression) {
            PDDLExpression other = (PDDLExpression) obj;
            return getConnective() == other.getConnective()
                && Objects.equals(this.getQuantifiedVariables(), other.getQuantifiedVariables())
                && Objects.equals(this.getSymbol(), other.getSymbol())
                && Objects.equals(this.getArguments(), other.getArguments())
                && Objects.equals(this.getChildren(), other.getChildren())
                && Objects.equals(this.getValue(), other.getValue())
                && Objects.equals(this.getPrefName(), other.getPrefName())
                && Objects.equals(this.getVariable(), other.getVariable())
                && Objects.equals(this.getTaskID(), other.getTaskID());
        }
        return false;
    }

    /**
     * Returns the hash code value of this expression.
     *
     * @return the hash code value of this expression.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getConnective(), this.getQuantifiedVariables(), this.getSymbol(),
            this.getArguments(), this.getChildren(), this.getValue(), this.getPrefName(),
            this.getVariable(), this.getTaskID());
    }



    @Override
    public PDDLExpression clone() {
        return new PDDLExpression();
    }

}
