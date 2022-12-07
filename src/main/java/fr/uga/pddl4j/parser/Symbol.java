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

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * This class implements the symbols manipulated by the parser and by the instantiation process.
 *
 * @param <T> the type of symbol, i.e., integer of string.
 */
public class Symbol<T> implements Serializable {

    /**
     * The name of rename variable.
     */
    public static final String DEFAULT_VARIABLE_SYMBOL = "?X";

    /**
     * The name of rename task tag.
     */
    public static final String DEFAULT_TASK_ID_SYMBOL = "T";

    /**
     * The default symbol for object type.
     */
    public static final Symbol<String> OBJECT_TYPE = new Symbol<String>(SymbolType.TYPE, "object");

    /**
     * The default symbol for number type.
     */
    public static final Symbol<String> NUMBER_TYPE = new Symbol<String>(SymbolType.TYPE, "number");

    /**
     * The kind of the symbol.
     */
    private SymbolType type;

    /**
     * The value of the symbol.
     */
    private T value;

    /**
     * The location of the symbol.
     */
    private Location location;

    /**
     * Creates a symbol from a specified symbol.
     *
     * @param other the symbol.
     */
    public Symbol(final Symbol<T> other) {
        this(other.getType(), other.getValue());
        if (other.getLocation() != null) {
            this.setLocation(new Location(other.getLocation()));
        }
    }

    /**
     * Create a new symbol from a specified token.
     *
     * @param type  the type of the symbol.
     * @param value the token.
     * @param location the location of the symbol.
     */
    public Symbol(final SymbolType type, final T value, final Location location) {
        super();
        this.setType(type);
        this.setValue(value);
        this.setLocation(location);
    }

    /**
     * Create a symbol with a specified image, line and column.
     *
     * @param type        the type of the symbol.
     * @param value       the value of the symbol.
     * @param beginLine   the begin line of the symbol.
     * @param beginColumn the begin column of the symbol.
     * @param endLine     the end line of the symbol.
     * @param endColumn   the end column of the symbol.
     */
    public Symbol(final SymbolType type, final T value, final int beginLine, final int beginColumn,
                  final int endLine, final int endColumn) {
        this(type, value, new Location(beginLine, beginColumn, endLine, endColumn));
    }

    /**
     * Creates a new symbol with a specified value.
     *
     * @param type  the kind of the symbol.
     * @param value the string image of the symbol.
     */
    public Symbol(final SymbolType type, final T value) {
        this(type, value, null);
    }

    /**
     * Returns the type of this symbol.
     *
     * @return the type of this symbol.
     */
    public final SymbolType getType() {
        return this.type;
    }

    /**
     * Sets the type of this symbol.
     *
     * @param type the type of the symbol.
     */
    public final void setType(final SymbolType type) {
        this.type = type;
    }

    /**
     * Returns the value of the symbol.
     *
     * @return the value of the symbol.
     */
    public final T getValue() {
        return this.value;
    }

    /**
     * Sets the value of the symbol.
     *
     * @param value the value to set.
     */
    public final void setValue(T value) {
        this.value = value;
    }

    /**
     * Return the location of the symbol.
     *
     * @return the location of the symbol.
     */
    public final Location getLocation() {
        return this.location;
    }

    /**
     * Sets the location of the symbol.
     *
     * @param location the location to set.
     */
    public final void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Sets the begin line and column of the expression from a specified token.
     *
     * @param begin the first token of the expression.
     */
    public final void setBegin(final Token begin) {
        if (this.getLocation() == null) {
            this.setLocation(new Location());
        }
        this.getLocation().setBegin(begin);
    }

    /**
     * Sets the end line and column of the expression from a specified token.
     *
     * @param end the last token of the expression.
     */
    public final void setEnd(final Token end) {
        if (this.getLocation() == null) {
            this.setLocation(new Location());
        }
        this.getLocation().setEnd(end);
    }

    /**
     * Return the string image of this symbol.
     *
     * @return the string image of this symbol.
     */
    public final String getImage() {
        return this.getValue().toString();
    }

    /**
     * Renames the symbol. The symbol is renamed if only if this symbol is contained the map in parameters,
     * otherwise nothing is done.
     *
     * @param context the images of the symbol to renamed .
     * @return the old image of the symbol or null if the symbol was not renamed.
     */
    public final T rename(final Map<T, T> context) {
        final T odlValue = this.getValue();
        final T newValue = context.get(odlValue);
        if (newValue != null) {
            this.setValue(newValue);
            return odlValue;
        }
        return null;
    }


    /**
     * Return if this symbol is equal to another object, i.e., if they have the same value.
     *
     * @param object the other object.
     * @return <code>true</code> if this symbol is equal to <code>object</code>, i.e., <code>other</code>
     *          is not null and of type <code>Symbol</code> and it has the same value; otherwise return
     *          <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof Symbol) {
            Symbol other = (Symbol) object;
            return Objects.equals(this.getValue(), other.getValue());
        }
        return false;
    }

    /**
     * Returns the hash code value of this symbol.
     *
     * @return the hash code value of this symbol.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getValue());
    }

    /**
     * Returns a string representation of this symbol.
     *
     * @return a string representation of this symbol.
     */
    @Override
    public String toString() {
        return this.getImage();
    }
}
