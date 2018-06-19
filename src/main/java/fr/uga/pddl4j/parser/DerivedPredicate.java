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

package fr.uga.pddl4j.parser;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements a derived predicate of the PDDL 3.0 language.
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public class DerivedPredicate implements Serializable {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The head of the derived predicate.
     */
    private NamedTypedList head;

    /**
     * The body of the derived predicate.
     */
    private Exp body;

    /**
     * Creates a new derived predicate.
     */
    private DerivedPredicate() {
        this.head = null;
        this.body = null;
    }

    /**
     * Creates a new derived predicate with a specific head and body.
     *
     * @param head the head of the derived predicate.
     * @param body the body of the derived predicate.
     */
    public DerivedPredicate(final NamedTypedList head, final Exp body) {
        this();
        if (head == null || body == null) {
            throw new NullPointerException();
        }
        this.head = head;
        this.body = body;
    }

    /**
     * Returns the head of the derived predicate.
     *
     * @return the head of the derived predicate.
     */
    public final NamedTypedList getHead() {
        return this.head;
    }

    /**
     * Sets the head of the derived predicate.
     *
     * @param head the head to set.
     */
    public final void setHead(final NamedTypedList head) {
        if (head == null) {
            throw new NullPointerException();
        }
        this.head = head;
    }

    /**
     * Returns the body of the derived predicate.
     *
     * @return the body of the derived predicate.
     */
    public final Exp getBody() {
        return body;
    }

    /**
     * Sets the body of this derived predicate.
     *
     * @param body the body to set.
     */
    public final void setBody(final Exp body) {
        if (body == null) {
            throw new NullPointerException();
        }
        this.body = body;
    }

    /**
     * Normalizes the derived predicates, i.e, renames the variables contained in the derived
     * predicate and move the negation inward.
     *
     * @see Exp#renameVariables()
     * @see Exp#moveNegationInward()
     */
    public void normalize() {
        // Rename the head of the derived predicate
        final Map<String, String> context = new LinkedHashMap<>();
        final List<TypedSymbol> arguments = this.getHead().getArguments();
        for (int i = 0; i < arguments.size(); i++) {
            final TypedSymbol argument = arguments.get(i);
            final String image = argument.renameVariables(i);
            context.put(image, argument.getImage());
        }
        // Rename the body of the derived predicate
        this.getBody().renameVariables(context);
    }

    /**
     * Returns if this derived predicate is equal to another object.
     *
     * @param obj the other object.
     * @return <code>true</code> if <code>obj</code> is not <code>null</code>, is an instance
     *          of the class <code>DerivedPredicate</code> and has the same head and body;
     *          otherwise it returns <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj.getClass().equals(this.getClass())) {
            final DerivedPredicate other = (DerivedPredicate) obj;
            return ((this.head == null && other.head == null)
                || this.head != null && this.head.equals(other.head))
                && ((this.body == null && other.body == null)
                || this.body != null && this.body.equals(other.body));
        }
        return false;
    }

    /**
     * Returns the hash code value of the derived predicate.
     *
     * @return the hash code value of the derived predicate.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + ((head == null) ? 0 : head.hashCode());
        return result;
    }

    /**
     * Returns a string representation of this derived predicate.
     *
     * @return a string representation of this derived predicate.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "(:derived " + this.head.toString() + " " + this.body.toString() + ")";
    }
}
