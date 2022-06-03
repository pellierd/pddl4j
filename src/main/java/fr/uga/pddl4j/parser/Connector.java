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
 * class <code>Expression</code>.
 *
 * @author D. Pellier
 * @version 1.0 - 28.01.2010
 */
public enum Connector {
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
     * The connective for the imply expressions.
     */
    IMPLY("imply"),
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
    TIME_VAR("?duration"),
    /**
     * The connective for the temporal task time.
     */
    F_TASK_TIME("duration"),
    /**
     * The connective for ground function expression used in initial fact expressions.
     */
    FN_ATOM("="),
    /**
     * The connective for ground function expression used in goal metric expressions.
     */
    FN_HEAD(""),
    /**
     * The connective for the duration literal expressions.
     */
    TIMED_LITERAL("at"),
    /**
     * The connective for the binary comparison expressions less.
     */
    LESS_COMPARISON("<"),
    /**
     * The connective for the binary comparison expressions less or equal.
     */
    LESS_OR_EQUAL_COMPARISON("<="),
    /**
     * The connective for the binary comparison expressions equal.
     */
    EQUAL_COMPARISON("="),
    /**
     * The connective for the binary comparison expressions greater.
     */
    GREATER_COMPARISON(">"),
    /**
     * The connective for the binary comparison expressions greater or equal.
     */
    GREATER_OR_EQUAL_COMPARISON(">="),
    /**
     * The connective for the binary operation expressions multiplication.
     */
    MULTIPLICATION("*"),
    /**
     * The connective for the binary operation expressions division.
     */
    DIVISION("/"),
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
     * The connective for the at end constraint expressions.
     */
    AT_END_CONSTRAINT("at end"),
    /**
     * The connective for the always expressions.
     */
    ALWAYS_CONSTRAINT("always"),
    /**
     * The connective for the sometime expressions.
     */
    SOMETIME_CONSTRAINT("sometimes"),
    /**
     * The connective for the within expressions.
     */
    WITHIN_CONSTRAINT("within"),
    /**
     * The connective for the at most once expressions.
     */
    AT_MOST_ONCE_CONSTRAINT("at-most-once"),
    /**
     * The connective for the sometime after expressions.
     */
    SOMETIME_AFTER_CONSTRAINT("sometime-after"),
    /**
     * The connective for the sometime before expressions.
     */
    SOMETIME_BEFORE_CONSTRAINT("sometime-before"),
    /**
     * The connective for the always within expressions.
     */
    ALWAYS_WITHIN_CONSTRAINT("always-within"),
    /**
     * The connective for the holding during expressions.
     */
    HOLD_DURING_CONSTRAINT("hold-during"),
    /**
     * The connective for the holding after expressions.
     */
    HOLD_AFTER_CONSTRAINT("hold-after"),
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
     * Connector for task used in HDDL fragment.
     */
    TASK(""),
    /**
     * Connector for task id used in HDDL fragment.
     */
    TASK_ID(""),
    /**
     * Connector for time task id used in HDDL fragment.
     */
    TIMED_TASK_ID(""),
    /**
     * Connector for ordering constraints used in HDDL fragment.
     */
    LESS_ORDERING_CONSTRAINT("<"),
    /**
     * Connector for ordering constraints used in HDDL fragment.
     */
    LESS_OR_EQUAL_ORDERING_CONSTRAINT("<="),
    /**
     * Connector for ordering constraints used in HDDL fragment.
     */
    GREATER_ORDERING_CONSTRAINT(">"),
    /**
     * Connector for ordering constraints used in HDDL fragment.
     */
    GREATER_OR_EQUAL_ORDERING_CONSTRAINT(">="),
    /**
     * Connector for ordering constraints used in HDDL fragment.
     */
    EQUAL_ORDERING_CONSTRAINT("="),
    /**
     * Connector for hold before method constraints in HDDL fragment.
     */
    HOLD_BEFORE_METHOD_CONSTRAINT("hold-before"),
    /**
     * Connector for hold after method constraints in HDDL fragment.
     */
    HOLD_AFTER_METHOD_CONSTRAINT("hold-after"),
    /**
     * Connector for hold between method constraints in HDDL fragment.
     */
    HOLD_BETWEEN_METHOD_CONSTRAINT("hold-between"),
    /**
     * Connector for hold during method constraints in HDDL fragment.
     */
    HOLD_DURING_METHOD_CONSTRAINT("hold-during"),
    /**
     * Connector for at end method constraints in HDDL fragment.
     */
    AT_END_METHOD_CONSTRAINT("at-end"),
    /**
     * Connector for at start between method constraints in HDDL fragment.
     */
    AT_START_METHOD_CONSTRAINT("at-start"),
    /**
     * Connector for always method constraints in HDDL fragment.
     */
    ALWAYS_METHOD_CONSTRAINT("always"),
    /**
     * Connector for at most once method constraints in HDDL fragment.
     */
    AT_MOST_ONCE_METHOD_CONSTRAINT("at-most-once"),
    /**
     * Connector for sometime method constraints in HDDL fragment.
     */
    SOMETIME_METHOD_CONSTRAINT("sometime"),
    /**
     * Connector for sometime before method constraints in HDDL fragment.
     */
    SOMETIME_BEFORE_METHOD_CONSTRAINT("sometimes-before"),
    /**
     * Connector for sometime after method constraints in HDDL fragment.
     */
    SOMETIME_AFTER_METHOD_CONSTRAINT("sometimes-after");

    /**
     * The image associate to the connective in the PDDL language.
     */
    private String image;

    /**
     * Create a new connective with a specific image.
     *
     * @param image the image of the connective. The image of the connective must be not null.
     */
    Connector(String image) {
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
