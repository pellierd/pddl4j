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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * This class is used to to parse in the atomic formula skeleton and atomic function skeleton.
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public class PDDLNamedTypedList implements Serializable {

    /**
     * The name of the typed list.
     */
    private PDDLSymbol name;

    /**
     * The list of arguments.
     */
    private List<PDDLTypedSymbol> arguments;

    /**
     * The list of the types of this name typed list. The list of types is used to encode function type since PDDL 3.1.
     */
    private List<PDDLSymbol> types;

    /**
     * Creates a named typed list from a specified typed list.
     *
     * @param list the list.
     * @throws NullPointerException if the specified typed list is null.
     */
    public PDDLNamedTypedList(final PDDLNamedTypedList list) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        this.name = new PDDLSymbol(list.getName());
        this.arguments = new ArrayList<>();
        this.types = new ArrayList<>();
        this.arguments.addAll(list.getArguments().stream().map(PDDLTypedSymbol::new).collect(Collectors.toList()));
        this.types.addAll(list.types.stream().map(PDDLSymbol::new).collect(Collectors.toList()));
    }

    /**
     * Creates new named typed list with a specified name.
     *
     * @param name the name of the list.
     */
    public PDDLNamedTypedList(final PDDLSymbol name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.arguments = new ArrayList<>();
        this.types = new ArrayList<>();
    }

    /**
     * Returns the name of this typed list.
     *
     * @return the name of this typed list.
     */
    public final PDDLSymbol getName() {
        return this.name;
    }

    /**
     * Sets the name of this typed list.
     *
     * @param name the name to set.
     */
    public final void setName(final PDDLSymbol name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    /**
     * Returns the list of arguments of this list.
     *
     * @return the list of arguments of this list.
     */
    public final List<PDDLTypedSymbol> getArguments() {
        return this.arguments;
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
     * Adds a type to this name type list.
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
     * Return if this named typed list is equal to another object.
     *
     * @param object the other object.
     * @return <code>true</code> if this named typed list is equal to <code>obj</code>, i.e.,
     *          <code>other</code> is not null and of type <code>PDDLNamedTypedList</code> and it has the
     *          same name and the same list of arguments and types; otherwise it returns <code>false</code>.
     * @see java.lang.Object#equals(Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof PDDLNamedTypedList) {
            PDDLNamedTypedList other = (PDDLNamedTypedList) object;
            return other.getName().equals(this.getName())
                && other.arguments.equals(this.arguments)
                && other.types.equals(this.types);
        }
        return false;
    }

    /**
     * Returns the hash code value of this named typed list.
     *
     * @return the hash code value of this named typed list.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.arguments.hashCode() + this.types.hashCode();
    }

    /**
     * Add a new argument at the end of the list.
     *
     * @param arg the argument to add.
     * @return <code>true</code> if the argument was added <code>false</code> otherwise.
     */
    public boolean add(final PDDLTypedSymbol arg) {
        if (arg == null) {
            throw new NullPointerException("arg == null");
        }
        return this.arguments.add(arg);

    }

    /**
     * Renames the variable contained in this typed list. For instance, if the nth argument is a
     * variable it will be rename <code>?Xn</code>.
     *
     * @see PDDLSymbol#renameVariables(int)
     */
    public final void renameVariables() {
        for (int i = 0; i < this.arguments.size(); i++) {
            arguments.get(i).renameVariables(i);
        }
    }

    /**
     * Returns a string representation of this named typed list.
     *
     * @return a string representation of this named typed list.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("(");
        str.append(this.name.toString());
        for (PDDLTypedSymbol argument : this.arguments) {
            str.append(" ").append(argument.toString());
        }
        str.append(")");
        if (!this.types.isEmpty()) {
            str.append(" - ");
            if (this.types.size() == 1) {
                str.append(this.types.get(0).toString().toUpperCase(Locale.ENGLISH));
            } else if (this.types.size() == 2) {
                str.append("(either");
                this.types.stream().filter(type -> !type.equals(PDDLParser.OBJECT))
                    .forEach(type -> str.append(" ").append(type.toString().toUpperCase(Locale.ENGLISH)));
                str.append(")");
            }
        }
        return str.toString();
    }
}
