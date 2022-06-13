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

package fr.uga.pddl4j.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * This interface defines the interface of the typed symbols.
 *
 * @author D. Pellier
 * @version 1.0 - 23.05.2022
 */
public class TypedSymbol<T> extends Symbol<T> {

    /**
     * The list of the types of this symbol.
     */
    private List<Symbol<T>> types;

    /**
     * Creates a typed symbol from a specified typed symbol.
     *
     * @param other the other symbol.
     * @throws NullPointerException if the specified typed symbol is null.
     */
    public TypedSymbol(final TypedSymbol<T> other) {
        super(other);
        this.types = new ArrayList<>();
        this.types.addAll(other.getTypes().stream().map(Symbol<T>::new).collect(Collectors.toList()));
    }

    /**
     * Creates a new typed symbol from a specified symbol. This symbol is by default of type object. If a
     * typed symbol is created with the specified symbol <code>Parser.OBJECT</code> or
     * <code>Parser.NUMBER</code>, the typed list is creates with an empty list of super types.
     *
     * @param type the type of symbol.
     * @param value the value of the symbol.
     */
    public TypedSymbol(final SymbolType type, final T value) {
        this(new Symbol<>(type, value));
    }

    /**
     * Creates a new typed symbol from a specified symbol. This symbol is by default of type object. If a
     * typed symbol is created with the specified symbol <code>Parser.OBJECT</code> or
     * <code>Parser.NUMBER</code>, the typed list is creates with an empty list of super types.
     *
     * @param symbol the symbol.
     */
    public TypedSymbol(final Symbol<T> symbol) {
        super(symbol);
        this.types = new ArrayList<>();
    }

    /**
     * Returns the list of types of this typed token.
     *
     * @return the list of types of this typed token.
     */
    public List<Symbol<T>> getTypes() {
        return this.types;
    }

    /**
     * Adds a type to this typed token.
     *
     * @param type the type to add.
     */
    public void addType(final Symbol<T> type) {
        if (!this.getTypes().contains(type)) {
            this.getTypes().add(type);
        }
    }

    /**
     * Returns a string representation of this typed symbol.
     *
     * @return a string representation of this typed symbol.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        if (!this.getTypes().isEmpty()) {
            str.append(" - ");
            if (this.getTypes().size() == 1) {
                str.append(this.getTypes().get(0).toString().toUpperCase(Locale.ENGLISH));
            } else if (this.getTypes().size() == 2) {
                str.append("(either");
                for (int i = 0; i < this.getTypes().size(); i++) {
                    str.append(" ");
                    str.append(this.getTypes().get(i).toString().toUpperCase(Locale.ENGLISH));
                }
                str.append(")");
            }
        }
        return str.toString();
    }
}
