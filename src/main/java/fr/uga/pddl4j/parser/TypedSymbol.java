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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * This class implements a typed symbol.
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public final class TypedSymbol extends Symbol {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The list of the types of this symbol.
     */
    private List<Symbol> types;

    /**
     * Creates a typed symbol from a specified typed symbol.
     *
     * @param symbol the symbol.
     * @throws NullPointerException if the specified typed symbol is null.
     */
    public TypedSymbol(final TypedSymbol symbol) {
        super(symbol);
        this.types = new ArrayList<>();
        this.types.addAll(symbol.getTypes().stream().map(Symbol::new).collect(Collectors.toList()));
    }

    /**
     * Creates a new typed symbol from a specified symbol. This symbol is by default of type object. If a
     * typed symbol is created with the specified symbol <code>Parser.OBJECT</code> or
     * <code>Parser.NUMBER</code>, the typed list is creates with an empty list of super types.
     *
     * @param symbol the symbol.
     */
    public TypedSymbol(final Symbol symbol) {
        super(symbol.getKind(), symbol.getImage(), symbol.getBeginLine(), symbol.getBeginColumn(), symbol
            .getEndLine(), symbol.getEndColumn());
        this.types = new ArrayList<>();
        if (!symbol.equals(Parser.OBJECT) && !symbol.equals(Parser.NUMBER)) {
            this.types.add(Parser.OBJECT);
        }
    }

    /**
     * Returns the list of types of this typed token.
     *
     * @return the list of types of this typed token.
     */
    public List<Symbol> getTypes() {
        return this.types;
    }

    /**
     * Adds a type to this typed token.
     *
     * @param type the type to add.
     */
    public void addType(final Symbol type) {
        if (type == null) {
            throw new NullPointerException();
        }
        if (!type.equals(Parser.OBJECT)) {
            this.types.remove(Parser.OBJECT);
        }
        if (!this.types.contains(type)) {
            this.types.add(type);
        }
    }

    @Override
    public boolean equals(final Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
        if (!this.equals(Parser.OBJECT) && !this.equals(Parser.NUMBER)) {
            str.append(" - ");
            if (this.types.size() == 1) {
                str.append(this.types.get(0).toString().toUpperCase(Locale.ENGLISH));
            } else if (this.types.size() == 2) {
                str.append("(either");
                for (int i = 0; i < this.types.size(); i++) {
                    str.append(" ");
                    str.append(this.types.get(i).toString().toUpperCase(Locale.ENGLISH));
                }
                str.append(")");
            }
        }
        return str.toString();
    }
}
