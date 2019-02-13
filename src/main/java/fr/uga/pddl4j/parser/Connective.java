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

/**
 * This enumeration defines the connective that can be used in PDDL expressions implemented by the
 * class <code>Exp</code>.
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public enum Connective {
    /**
     * The connective for an atom, i.e, atomic formula.
     */
    ATOM(""),
    /**
     * The connective for an equal atom.
     */
    EQUAL_ATOM("="),
    /**
     * The connective for the negative expressions.
     */
    NOT("not"),
    /**
     * The connective for the conjunctive expressions.
     */
    AND("and"),
    /**
     * The connective for the disjunctive expressions.
     */
    OR("or"),
    /**
     * The connective for the universal expressions.
     */
    FORALL("forall"),
    /**
     * The connective for the existential expressions.
     */
    EXISTS("exists"),
    /**
     * The connective for the functions.
     */
    F_EXP(""),
    /**
     * The connective for the temporal function.
     */
    F_EXP_T(""),
    /**
     * The connective for the temporal variable.
     */
    TIME_VAR(""),
    /**
     * The connective for ground function expression used in initial fact expressions.
     */
    FN_ATOM("="),
    /**
     * The connective for ground function expression used in goal metric expressions.
     */
    FN_HEAD(""),
    /**
     * The connective for the duration atomic expressions.
     */
    DURATION_ATOM("at"),
    /**
     * The connective for the binary comparison expressions less.
     */
    LESS("<"),
    /**
     * The connective for the binary comparison expressions less or equal.
     */
    LESS_OR_EQUAL("<="),
    /**
     * The connective for the binary comparison expressions equal.
     */
    EQUAL("="),
    /**
     * The connective for the binary comparison expressions greater.
     */
    GREATER(">"),
    /**
     * The connective for the binary comparison expressions greater or equal.
     */
    GREATER_OR_EQUAL(">="),
    /**
     * The connective for the binary operation expressions multiplication.
     */
    MUL("*"),
    /**
     * The connective for the binary operation expressions division.
     */
    DIV("/"),
    /**
     * The connective for the binary operation expressions minus.
     */
    MINUS("-"),
    /**
     * The connective for the unary operation expressions minus.
     */
    UMINUS("-"),
    /**
     * The connective for the binary operation expressions plus.
     */
    PLUS("+"),
    /**
     * The connective for number.
     */
    NUMBER(""),
    /**
     * The connective for the assign expressions.
     */
    ASSIGN("assign"),
    /**
     * The connective for the increase expressions.
     */
    INCREASE("increase"),
    /**
     * The connective for the decrease expressions.
     */
    DECREASE("decrease"),
    /**
     * The connective for the scale up expressions.
     */
    SCALE_UP("scale-up"),
    /**
     * The connective for the scale down expressions.
     */
    SCALE_DOWN("scale-down"),
    /**
     * The connective for the at start temporal expressions.
     */
    AT_START("at start"),
    /**
     * The connective for the at end temporal expressions.
     */
    AT_END("at end"),
    /**
     * The connective for the over all temporal expressions.
     */
    OVER_ALL("over all"),
    /**
     * The connective for the minimize metric expressions.
     */
    MINIMIZE("minimize"),
    /**
     * The connective for the maximize metric expressions.
     */
    MAXIMIZE("maximize"),
    /**
     * The connective for the is violated expressions.
     */
    IS_VIOLATED("is-violated"),
    /**
     * The connective for the conditional expressions.
     */
    WHEN("when"),
    /**
     * The connective for the always expressions.
     */
    ALWAYS("always"),
    /**
     * The connective for the sometime expressions.
     */
    SOMETIME("sometimes"),
    /**
     * The connective for the within expressions.
     */
    WITHIN("within"),
    /**
     * The connective for the at most once expressions.
     */
    AT_MOST_ONCE("at-most-once"),
    /**
     * The connective for the sometime after expressions.
     */
    SOMETIME_AFTER("sometime-after"),
    /**
     * The connective for the sometime before expressions.
     */
    SOMETIME_BEFORE("sometime-before"),
    /**
     * The connective for the always within expressions.
     */
    ALWAYS_WITHIN("always-within"),
    /**
     * The connective for the holding during expressions.
     */
    HOLD_DURING("hold-during"),
    /**
     * The connective for the holding after expressions.
     */
    HOLD_AFTER("hold-after"),
    /**
     * The connective for the after expressions.
     */
    AFTER("after"),
    /**
     * The connective for the function term.
     */
    FUNCTION_TERM(""),
    /**
     * The connective for expression of type TRUE.
     */
    TRUE("true"),
    /**
     * The connective for expression of type FALSE.
     */
    FALSE("false"),
    /**
     * The connective for the hold-before expression.
     */
    HOLD_BEFORE("hold-before"),
    /**
     * The connective for the before expression.
     */
    BEFORE("before"),
    /**
     * The connective for the between expression.
     */
    HOLD_BETWEEN("hold-between"),
    /**
     * Connective for alias set expression.
     */
    ALIAS_SET(""),
    /**
     * Connective for task expression.
     */
    TASK(""),
    /**
     * Connective for expansions (task sets).
     */
    EXPANSION("");

    /**
     * The image associate to the connective in the PDDL language.
     */
    private String image;

    /**
     * Create a new connective with a specific image.
     *
     * @param image the image of the connective. The image of the connective must be not null.
     */
    Connective(String image) {
        this.image = image;
    }

    /**
     * Returns the image of this connective.
     *
     * @return the image of this connective.
     */
    public String getImage() {
        return this.image;
    }

}
