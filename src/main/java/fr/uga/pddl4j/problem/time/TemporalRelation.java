package fr.uga.pddl4j.problem.time;

public enum TemporalRelation {

    EMPTY(0),
    LESS(1),
    EQUAL(2),
    GREATER(3),
    LEQ(4),
    GEQ(5),
    DIFFERENT(6),
    UNIVERSAL(7);

    /**
     * The index of the relation
     */
    private Integer index;

    /**
     * Create a new connective with a specific image.
     *
     * @param index the index of the relation.
     */
    TemporalRelation(Integer index) {
        this.index = index;
    }

    /**
     * Returns the index of the relation.
     *
     * @return the index of the the relation
     */
    public int getIndex() {
        return this.index;
    }

    private static TemporalRelation[][] composition = {
    //  EMPTY       LESS        EQUAL       GREATER     LEQ         GEQ         DIFF        UNIVERSAL
        {EMPTY,     EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY},
        {EMPTY,     LESS,       LESS,       UNIVERSAL,  LESS,       UNIVERSAL,  UNIVERSAL, UNIVERSAL},
        {EMPTY,     LESS,       EQUAL,      GREATER,    LEQ,        GEQ,        DIFFERENT, UNIVERSAL},
        {EMPTY,     UNIVERSAL,  GREATER,    GREATER,    UNIVERSAL,  GREATER,    UNIVERSAL, UNIVERSAL},
        {EMPTY,     LESS,       LEQ,        UNIVERSAL,  LEQ,        UNIVERSAL,  UNIVERSAL, UNIVERSAL},
        {EMPTY,     UNIVERSAL,  GEQ,        GREATER,    UNIVERSAL,  GEQ,        UNIVERSAL, UNIVERSAL},
        {EMPTY,     UNIVERSAL,  DIFFERENT,  UNIVERSAL,  UNIVERSAL,  UNIVERSAL,  UNIVERSAL, UNIVERSAL},
        {EMPTY,     UNIVERSAL,  UNIVERSAL,  UNIVERSAL,  UNIVERSAL,  UNIVERSAL,  UNIVERSAL, UNIVERSAL}
    };

    private static TemporalRelation[][] intersection = {
    //  EMPTY       LESS        EQUAL       GREATER     LEQ         GEQ         DIFF        UNIVERSAL
        {EMPTY,     EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY,      EMPTY},
        {EMPTY,     LESS,       EMPTY,      EMPTY,      LESS,       EMPTY,      LESS,       LESS},
        {EMPTY,     EMPTY,      EQUAL,      EMPTY,      EQUAL,      EQUAL,      EMPTY,      EQUAL},
        {EMPTY,     EMPTY,      EMPTY,      GREATER,    EMPTY,      GREATER,    GREATER,    GREATER},
        {EMPTY,     LESS,       EQUAL,      EMPTY,      LEQ,        EQUAL,      LESS,       LEQ},
        {EMPTY,     EMPTY,      EQUAL,      GREATER,    EQUAL,      GEQ,        GREATER,    GEQ},
        {EMPTY,     LESS,       EMPTY,      GREATER,    LESS,       GREATER,    DIFFERENT,  DIFFERENT},
        {EMPTY,     LESS,       EQUAL,      GREATER,    LEQ,        GEQ,        DIFFERENT,  UNIVERSAL},
    };

    private static TemporalRelation[] symmetric = {
        EMPTY,     GREATER,      EQUAL,      LESS,      GEQ,      LEQ,      DIFFERENT,      UNIVERSAL
    };


    public TemporalRelation compose(TemporalRelation r) {
        return TemporalRelation.composition[this.getIndex()][r.getIndex()];
    }

    public TemporalRelation intersect(TemporalRelation r) {
        return TemporalRelation.intersection[this.getIndex()][r.getIndex()];
    }

    public TemporalRelation symmetric() {
        return TemporalRelation.symmetric[this.getIndex()];
    }
}
