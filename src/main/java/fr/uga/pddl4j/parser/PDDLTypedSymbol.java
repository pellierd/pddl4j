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
public final class PDDLTypedSymbol extends PDDLSymbol {

    /**
     * The list of the types of this symbol.
     */
    private List<PDDLSymbol> types;

    /**
     * Creates a typed symbol from a specified typed symbol.
     *
     * @param symbol the symbol.
     * @throws NullPointerException if the specified typed symbol is null.
     */
    public PDDLTypedSymbol(final PDDLTypedSymbol symbol) {
        super(symbol);
        this.types = new ArrayList<>();
        this.types.addAll(symbol.getTypes().stream().map(PDDLSymbol::new).collect(Collectors.toList()));
    }

    /**
     * Creates a new typed symbol from a specified symbol. This symbol is by default of type object. If a
     * typed symbol is created with the specified symbol <code>PDDLParser.OBJECT</code> or
     * <code>PDDLParser.NUMBER</code>, the typed list is creates with an empty list of super types.
     *
     * @param symbol the symbol.
     */
    public PDDLTypedSymbol(final PDDLSymbol symbol) {
        super(symbol.getKind(), symbol.getImage(), symbol.getBeginLine(), symbol.getBeginColumn(), symbol
            .getEndLine(), symbol.getEndColumn());
        this.types = new ArrayList<>();
        if (!symbol.equals(PDDLParser.OBJECT) && !symbol.equals(PDDLParser.NUMBER)) {
            this.types.add(PDDLParser.OBJECT);
        }
    }

    /**
     * Returns the list of types of this typed token.
     *
     * @return the list of types of this typed token.
     */
    public List<PDDLSymbol> getTypes() {
        return this.types;
    }

    /**
     * Adds a type to this typed token.
     *
     * @param type the type to add.
     */
    public void addType(final PDDLSymbol type) {
        if (type == null) {
            throw new NullPointerException();
        }
        if (!type.equals(PDDLParser.OBJECT)) {
            this.types.remove(PDDLParser.OBJECT);
        }
        if (!this.types.contains(type)) {
            this.types.add(type);
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
        if (!this.equals(PDDLParser.OBJECT) && !this.equals(PDDLParser.NUMBER)) {
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
