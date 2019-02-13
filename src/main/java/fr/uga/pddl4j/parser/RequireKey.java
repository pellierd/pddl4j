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
 * This enumeration defines the set of PDDL require key.
 *
 * @author Damien Pellier
 * @version 1.0 - 28.01.2010
 */
public enum RequireKey {
    /**
     * The PDDL :strips requirement.
     */
    STRIPS(":strips"),
    /**
     * The PDDL :typing requirement.
     */
    TYPING(":typing"),
    /**
     * The PDDL :negative-preconditions requirement.
     */
    NEGATIVE_PRECONDITIONS(":negative-preconditions"),
    /**
     * The PDDL :disjunctive-preconditions requirement.
     */
    DISJUNCTIVE_PRECONDITIONS(":disjunctive-preconditions"),
    /**
     * The PDDL :equality requirement.
     */
    EQUALITY(":equality"),
    /**
     * The PDDL :existential-preconditions requirement.
     */
    EXISTENTIAL_PRECONDITIONS(":existential-preconditions"),
    /**
     * The PDDL :universal-preconditions requirement.
     */
    UNIVERSAL_PRECONDITIONS(":universal-preconditions"),
    /**
     * The PDDL :quantified-preconditions requirement.
     */
    QUANTIFIED_PRECONDITIONS(":quantified-preconditions"),
    /**
     * The PDDL :conditional-effects requirement.
     */
    CONDITIONAL_EFFECTS(":conditional-effects"),
    /**
     * The PDDL :fluents requirement (object-fluents + numeric-fluents since PDDL3.1).
     */
    FLUENTS(":fluents"),
    /**
     * The PDDL :numeric-fluents requirement.
     */
    NUMERIC_FLUENTS(":numeric-fluents"),
    /**
     * The PDDL :object-fluents requirement.
     */
    OBJECT_FLUENTS(":object-fluents"),
    /**
     * The PDDL :goal-utilities requirement (since PDDL3.1).
     */
    GOAL_UTILITIES(":goal-utilities"),
    /**
     * The PDDL :action-costs requirement (since PDDL3.1).
     */
    ACTION_COSTS(":action-costs"),
    /**
     * The PDDL :adl requirement.
     */
    ADL(":adl"),
    /**
     * The PDDL :durative-actions requirement.
     */
    DURATIVE_ACTIONS(":durative-actions"),
    /**
     * The PDDL :derived-predicates requirement.
     */
    DERIVED_PREDICATES(":derived-predicates"),
    /**
     * The PDDL :times-initial-literals requirement.
     */
    TIMED_INITIAL_LITERALS(":timed-initial-literals"),
    /**
     * The PDDL :preferences requirement.
     */
    PREFERENCES(":preferences"),
    /**
     * The PDDL :constraints requirement.
     */
    CONSTRAINTS(":constraints"),
    /**
     * The PDDL :continous-effects requirement.
     */
    CONTINOUS_EFFECTS(":continous-effects"),
    /**
     * The PDDL :duration-inequalities requirement.
     */
    DURATION_INEQUALITIES(":duration-inequalities"),
    /**
     * The PDDL :htn requirement.
     */
    HTN(":htn");


    /**
     * The image associate to the require key in the PDDL language.
     */
    private String image;

    /**
     * Create a new require key with a specific image.
     *
     * @param image the image of the require key. The image of the require key must be not null.
     */
    RequireKey(String image) {
        this.image = image;
    }

    /**
     * Returns the image of this require key.
     *
     * @return the image of this require key.
     */
    public String getImage() {
        return this.image;
    }

    /**
     * Returns a string representation of this require key.
     *
     * @return a string representation of this require key.
     */
    @Override
    public String toString() {
        return this.image;
    }
}
