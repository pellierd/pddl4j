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

package fr.uga.pddl4j.problem.time;

/**
 * This enumeration defined the temporal relation between tasks.
 *
 * @author D. Pellier
 * @version 1.0 - 12.06.2022
 * @since 4.0
 */
public enum TemporalRelation {

    /**
     * The empty relation, i.e., impossible relation.
     */
    EMPTY(0),
    /**
     * The less relation.
     */
    LESS(1),
    /**
     * The equal relation.
     */
    EQUAL(2),
    /**
     * The greater relation.
     */
    GREATER(3),
    /**
     * The less or equal relation.
     */
    LEQ(4),
    /**
     * The greater or equal relation.
     */
    GEQ(5),
    /**
     * The different relation.
     */
    DIFFERENT(6),
    /**
     * The universal relation, i.e., no temporal constraints.
     */
    UNIVERSAL(7);

    /**
     * The index of the relation.
     */
    private Integer index;

    /**
     * Create a new temporal relation with a specific index.
     *
     * @param index the index of the relation.
     */
    private TemporalRelation(Integer index) {
        this.index = index;
    }

    /**
     * Returns the index of the relation.
     *
     * @return the index of the relation
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * The table that defines the result of the composition of two temporal relations.
     */
    private static TemporalRelation[][] composition = {
        //EMPTY     LESS       EQUAL        GREATER     LEQ         GEQ         DIFF        UNIVERSAL
        {EMPTY,     EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY,     EMPTY},
        {EMPTY,     LESS,       LESS,       UNIVERSAL,  LESS,       UNIVERSAL,  UNIVERSAL, UNIVERSAL},
        {EMPTY,     LESS,       EQUAL,      GREATER,    LEQ,        GEQ,        DIFFERENT, UNIVERSAL},
        {EMPTY,     UNIVERSAL,  GREATER,    GREATER,    UNIVERSAL,  GREATER,    UNIVERSAL, UNIVERSAL},
        {EMPTY,     LESS,       LEQ,        UNIVERSAL,  LEQ,        UNIVERSAL,  UNIVERSAL, UNIVERSAL},
        {EMPTY,     UNIVERSAL,  GEQ,        GREATER,    UNIVERSAL,  GEQ,        UNIVERSAL, UNIVERSAL},
        {EMPTY,     UNIVERSAL,  DIFFERENT,  UNIVERSAL,  UNIVERSAL,  UNIVERSAL,  UNIVERSAL, UNIVERSAL},
        {EMPTY,     UNIVERSAL,  UNIVERSAL,  UNIVERSAL,  UNIVERSAL,  UNIVERSAL,  UNIVERSAL, UNIVERSAL}
    };

    /**
     * The table that defines the result of the intersection of two temporal relations.
     */
    private static TemporalRelation[][] intersection = {
        //EMPTY      LESS       EQUAL       GREATER     LEQ         GEQ         DIFF        UNIVERSAL
        {EMPTY,     EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY},
        {EMPTY,     LESS,       EMPTY,      EMPTY,      LESS,       EMPTY,      LESS,       LESS},
        {EMPTY,     EMPTY,      EQUAL,      EMPTY,      EQUAL,      EQUAL,      EMPTY,      EQUAL},
        {EMPTY,     EMPTY,      EMPTY,      GREATER,    EMPTY,      GREATER,    GREATER,    GREATER},
        {EMPTY,     LESS,       EQUAL,      EMPTY,      LEQ,        EQUAL,      LESS,       LEQ},
        {EMPTY,     EMPTY,      EQUAL,      GREATER,    EQUAL,      GEQ,        GREATER,    GEQ},
        {EMPTY,     LESS,       EMPTY,      GREATER,    LESS,       GREATER,    DIFFERENT,  DIFFERENT},
        {EMPTY,     LESS,       EQUAL,      GREATER,    LEQ,        GEQ,        DIFFERENT,  UNIVERSAL},
    };

    /**
     * The table that defines the symmetric of a temporal relation.
     */
    private static TemporalRelation[] symmetric = {
        EMPTY,     GREATER,      EQUAL,      LESS,      GEQ,      LEQ,      DIFFERENT,      UNIVERSAL
    };

    /**
     * Returns the result of the composition of this temporal relation with another relation.
     *
     * @param relation the other relation.
     * @return of the composition of this temporal relation with specified relation.
     */
    public TemporalRelation compose(final TemporalRelation relation) {
        return TemporalRelation.composition[this.getIndex()][relation.getIndex()];
    }

    /**
     * Returns the result of the intersection of this temporal relation with another relation.
     *
     * @param relation the other relation.
     * @return of the intersection of this temporal relation with specified relation.
     */
    public TemporalRelation intersect(final TemporalRelation relation) {
        return TemporalRelation.intersection[this.getIndex()][relation.getIndex()];
    }

    /**
     * Returns the result of the symetric of this temporal relation.
     *
     * @return of the symmetric of this temporal relation.
     */
    public TemporalRelation symmetric() {
        return TemporalRelation.symmetric[this.getIndex()];
    }
}
