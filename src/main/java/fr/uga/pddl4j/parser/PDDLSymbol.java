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

import fr.uga.pddl4j.parser.lexer.Token;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;


/**
 * This class implements a symbol parsed by the parser. It can be a predicate, a functor, a
 * constant, a kind, a variable and a preference.
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public class PDDLSymbol extends Symbol<String> implements Locatable {

    /**
     * Creates a symbol from a specified symbol.
     *
     * @param other the symbol.
     */
    public PDDLSymbol(final PDDLSymbol other) {
        super(other);
    }

    /**
     * Create a new symbol from a specified token.
     *
     * @param type  the type of the symbol.
     * @param token the token.
     */
    public PDDLSymbol(final SymbolType type, final Token token) {
        super(type, token.image.toLowerCase(Locale.ENGLISH),
            token.beginLine, token.beginColumn, token.endLine, token.endColumn);
    }

    /**
     * Create a symbol with a specified image, line and column.
     *
     * @param type        the kind of the symbol.
     * @param value       the string image of the symbol.
     * @param beginLine   the begin line of the symbol.
     * @param beginColumn the begin column of the symbol.
     * @param endLine     the end line of the symbol.
     * @param endColumn   the end column of the symbol.
     */
    public PDDLSymbol(final SymbolType type, final String value, final int beginLine, final int beginColumn,
                      final int endLine, final int endColumn) {
        super(type, value, beginLine, beginColumn, endLine, endColumn);
    }

    /**
     * Creates a new symbol with a specified image. The line and the column are initialized to
     * <code>-1</code>.
     *
     * @param type  the kind of the symbol.
     * @param value the string image of the symbol.
     */
    public PDDLSymbol(final SymbolType type, final String value) {
        super(type, value);
    }

    /**
     * Renames the symbol from a specified index. The symbol is renamed if only if this symbol is a
     * variable, otherwise nothing is done. After rename operation the variable will have the form
     * <code>?Xn</code> where <code>n</code> is the specified index.
     *
     * @param index the index of the symbol.
     * @return the old image of the symbol or null if the symbol was not renamed.
     * @throws IllegalArgumentException if index is &#60; 0.
     */
    /*public final String renameVariables(final int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        String img = null;
        if (this.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
            img = this.getImage();
            this.setImage(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL + index);
        }
        return img;
    }*/

    /**
     * Renames the symbol from a specified symbolEncoding. The symbol is renamed if only if this symbol is a
     * variable, otherwise nothing is done.
     *
     * @param context the images of the already renamed variables.
     * @return the old image of the symbol or null if the symbol was not renamed.
     * @throws NullPointerException if context == null.
     */
    /*public final String renameVariables(final Map<String, String> context) {
        String img = null;
        if (this.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
            img = this.getImage();
            final String newImage = context.get(img);
            if (newImage != null) {
                this.setImage(newImage);
                return img;
            }
        }
        return null;
    }*/

    /**
     * Renames the task ID symbol according to a specific context. The symbol is renamed if only if this symbol is a
     * task ID, otherwise nothing is done.
     *
     * @param context the images of the already renamed task ID.
     * @return the old image of the symbol or null if the symbol was not renamed.
     */
    /*public final String renameTaskID(final Map<String, String> context) {
        if (this.getKind().equals(Kind.TASK_ID)) {
            String image = this.getImage();
            String newImage = context.get(image);
            if (newImage == null) {
                newImage = PDDLSymbol.DEFAULT_TASK_ID_SYMBOL + context.size();
                context.put(image, newImage);
            }
            this.setImage(newImage);
            return image;
        }
        return null;
    }*/

    /**
     * Return if this symbol is equal to another object.
     *
     * @param object the other object.
     * @return <code>true</code> if this symbol is equal to <code>object</code>, i.e., <code>other</code>
     *          is not null and of kind <code>PDDLSymbol</code> and it has the same image; otherwise return
     *          <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    /*@Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof PDDLSymbol) {
            PDDLSymbol other = (PDDLSymbol) object;
            return this.getValue().equals(other.getValue());
        }
        return false;
    }

    /**
     * Returns the hash code value of this symbol.
     *
     * @return the hash code value of this symbol.
     * @see java.lang.Object#hashCode()
     */
    /*@Override
    public int hashCode() {
        return Objects.hash(this.getValue());
    }

    /**
     * Returns a string representation of this symbol.
     *
     * @return a string representation of this symbol.
     */
    /*@Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        switch (this.type) {
            case TASK_ID:
                if (this.getTimeSpecifier() != null) {
                    str.append("( ");
                    str.append(this.getTimeSpecifier());
                    str.append(" ");
                    str.append(this.getValue());
                    str.append(")");
                } else {
                    str.append(this.getValue());
                }
                break;
            default:
                str.append(this.getValue());
        }
        return str.toString();
    }*/

    public PDDLSymbol clone() {
        return new PDDLSymbol(this);
    }
}
