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

import java.io.Serializable;
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
public class PDDLSymbol implements Serializable {

    /**
     * The name of rename variable.
     */
    public static final String DEFAULT_VARIABLE_SYMBOL = "?X";

    /**
     * The name of rename task tag.
     */
    public static final String DEFAULT_TASK_ID_SYMBOL = "T";

    /**
     * The enumeration used to specified the different types of the symbol.
     */
    public enum Kind {
        /**
         * The predicate symbol.
         */
        PREDICATE,
        /**
         * The type symbol.
         */
        TYPE,
        /**
         * The action symbol.
         */
        ACTION,
        /**
         * The method symbol.
         */
        METHOD,
        /**
         * The task symbol.
         */
        TASK,
        /**
         * The alias symbol.
         */
        ALIAS,
        /**
         * The preference symbol.
         */
        PREFERENCE,
        /**
         * The functor symbol.
         */
        FUNCTOR,
        /**
         * The variable symbol.
         */
        VARIABLE,
        /**
         * The duration variable symbol.
         */
        DURATION_VARIABLE,
        /**
         * The continuous variable symbol.
         */
        CONTINUOUS_VARIABLE,
        /**
         * The constant symbol.
         */
        CONSTANT,
        /**
         * The domain symbol.
         */
        DOMAIN,
        /**
         * The problem symbol.
         */
        PROBLEM,
        /**
         * the task id symbol.
         */
        TASK_ID;
    }

    /**
     * The kind of the symbol.
     */
    private Kind kind;

    /**
     * The image of the symbol.
     */
    private String image;

    /**
     * The begin line of the symbol.
     */
    private int beginLine;

    /**
     * The begin column of the symbol.
     */
    private int beginColumn;

    /**
     * The end line of the symbol.
     */
    private int endLine;

    /**
     * The end column of the symbol.
     */
    private int endColumn;

    /**
     * Creates a symbol from a specified symbol.
     *
     * @param symbol the symbol.
     */
    public PDDLSymbol(final PDDLSymbol symbol) {
        this.kind = symbol.getKind();
        this.image = symbol.getImage();
        this.beginLine = symbol.getBeginLine();
        this.beginColumn = symbol.getBeginColumn();
        this.endLine = symbol.getEndLine();
        this.endColumn = symbol.getEndColumn();
    }

    /**
     * Create a new symbol from a specified token.
     *
     * @param kind  the kind of the symbol.
     * @param token the token.
     */
    public PDDLSymbol(final Kind kind, final Token token) {
        this.kind = kind;
        this.image = token.image.toLowerCase(Locale.ENGLISH);
        this.beginLine = token.beginLine;
        this.beginColumn = token.beginColumn;
        this.endLine = token.endLine;
        this.endColumn = token.endColumn;
    }

    /**
     * Create a symbol with a specified image, line and column.
     *
     * @param kind        the kind of the symbol.
     * @param image       the string image of the symbol.
     * @param beginLine   the begin line of the symbol.
     * @param beginColumn the begin column of the symbol.
     * @param endLine     the end line of the symbol.
     * @param endColumn   the end column of the symbol.
     */
    public PDDLSymbol(final Kind kind, final String image, final int beginLine, final int beginColumn,
                      final int endLine, final int endColumn) {
        this.kind = kind;
        this.image = image.toLowerCase(Locale.ENGLISH);
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    /**
     * Creates a new symbol with a specified image. The line and the column are initialize to
     * <code>-1</code>.
     *
     * @param kind  the kind of the symbol.
     * @param image the string image of the symbol.
     */
    public PDDLSymbol(final Kind kind, final String image) {
        this(kind, image, -1, -1, -1, -1);
    }

    /**
     * Returns the kind of this symbol.
     *
     * @return the kind of this symbol.
     */
    public final Kind getKind() {
        return this.kind;
    }

    /**
     * Sets the kind of this symbol.
     *
     * @param kind the kind of the symbol.
     * @throws NullPointerException of the specified kind is null.
     */
    public final void setKind(final Kind kind) {
        this.kind = kind;
    }

    /**
     * Return the string image of this symbol.
     *
     * @return the string image of this symbol.
     */
    public final String getImage() {
        return this.image;
    }

    /**
     * Sets a new image to this symbol.
     *
     * @param image the new image to set.
     */
    public final void setImage(String image) {
        this.image = image;
    }

    /**
     * Return the begin line of the file where this symbol appear. The return value <code>-1</code>
     * indicates that the attribute was not initialized.
     *
     * @return the begin line of the file where this symbol appear or <code>-1</code> if it was
     *          not initialized.
     */
    public final int getBeginLine() {
        return this.beginLine;
    }

    /**
     * Return the begin column of the file where this symbol appear. The return value <code>-1</code>
     * indicates that the attribute was not initialized.
     *
     * @return the begin column of the file where this symbol appear or <code>-1</code> if it was
     *          not initialized.
     */
    public final int getBeginColumn() {
        return this.beginColumn;
    }

    /**
     * Return the end line of the file where this symbol appear. The return value <code>-1</code>
     * indicates that the attribute was not initialized.
     *
     * @return the end line of the file where this symbol appear or <code>-1</code> if it was
     *          not initialized.
     */
    public final int getEndLine() {
        return this.endLine;
    }

    /**
     * Return the end column of the file where this symbol appear. The return value <code>-1</code>
     * indicates that the attribute was not initialized.
     *
     * @return the end column of the file where this symbol appear or <code>-1</code> if it was
     *          not initialized.
     */
    public final int getEndColumn() {
        return this.endColumn;
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
    public final String renameVariables(final int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        String img = null;
        if (this.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
            img = this.getImage();
            this.setImage(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL + index);
        }
        return img;
    }

    /**
     * Renames the symbol from a specified symbolEncoding. The symbol is renamed if only if this symbol is a
     * variable, otherwise nothing is done.
     *
     * @param context the images of the already renamed variables.
     * @return the old image of the symbol or null if the symbol was not renamed.
     * @throws NullPointerException if context == null.
     */
    public final String renameVariables(final Map<String, String> context) {
        if (context == null) {
            throw new NullPointerException("context == null");
        }
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
    }

    /**
     * Renames the symbol. The symbol is renamed if only if this symbol is contained the map in parameters,
     * otherwise nothing is done.
     *
     * @param context the images of the symbol to renamed .
     * @return the old image of the symbol or null if the symbol was not renamed.
     * @throws NullPointerException if context == null.
     */
    public final String rename(final Map<String, String> context) {
        if (context == null) {
            throw new NullPointerException("context == null");
        }
        final String odlImage = this.getImage();
        final String newImage = context.get(odlImage);
        if (newImage != null) {
            this.setImage(newImage);
            return odlImage;
        }
        return null;
    }

    /**
     * Renames the task ID symbol according to a specific context. The symbol is renamed if only if this symbol is a
     * task ID, otherwise nothing is done.
     *
     * @param context the images of the already renamed task ID.
     * @return the old image of the symbol or null if the symbol was not renamed.
     */
    public final String renameTaskID(final Map<String, String> context) {
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
    }

    /**
     * Return if this symbol is equal to another object.
     *
     * @param object the other object.
     * @return <code>true</code> if this symbol is equal to <code>object</code>, i.e., <code>other</code>
     *          is not null and of kind <code>PDDLSymbol</code> and it has the same image; otherwise return
     *          <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof PDDLSymbol) {
            PDDLSymbol other = (PDDLSymbol) object;
            return this.getImage().equals(other.getImage());
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
        return Objects.hash(this.getImage());
    }

    /**
     * Returns a string representation of this symbol.
     *
     * @return a string representation of this symbol.
     */
    @Override
    public String toString() {
        return this.image;
    }

}
