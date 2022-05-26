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
public final class PDDLTypedSymbol extends TypedSymbol<String> {

    /**
     * Creates a typed symbol from a specified typed symbol.
     *
     * @param symbol the symbol.
     * @throws NullPointerException if the specified typed symbol is null.
     */
    public PDDLTypedSymbol(final PDDLTypedSymbol symbol) {
        super(symbol);
    }

    /**
     * Creates a new typed symbol from a specified symbol. This symbol is by default of type object. If a
     * typed symbol is created with the specified symbol <code>PDDLParser.OBJECT</code> or
     * <code>PDDLParser.NUMBER</code>, the typed list is creates with an empty list of super types.
     *
     * @param symbol the symbol.
     */
    public PDDLTypedSymbol(final Symbol<String> symbol) {
        super(symbol);
    }

}
