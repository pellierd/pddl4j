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

/**
 * The enumeration used to specified the different types of the symbol.
 */
public enum SymbolType {
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
    TASK_ID,
}
