;;
;; Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
;;
;; This file is part of PDDL4J library.
;;
;; PDDL4J is free software: you can redistribute it and/or modify
;; it under the terms of the GNU General Public License as published by
;; the Free Software Foundation, either version 3 of the License, or
;; (at your option) any later version.
;;
;; PDDL4J is distributed in the hope that it will be useful,
;; but WITHOUT ANY WARRANTY; without even the implied warranty of
;; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
;; GNU General Public License for more details.
;;
;; You should have received a copy of the GNU General Public License
;; along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
;;

(define (domain depot)

    (:requirements
           :strips
          :typing
          :total-ordered-htn
          :htn-method-preconditions
          :negative-preconditions
          :equality
    )

    (:types
        place locatable - object
        depot distributor - place
        truck hoist surface - locatable
        pallet crate - surface
    )

    (:predicates
        (at ?x - locatable ?y - place)
        (on ?x - crate ?y - surface)
        (in ?x - crate ?y - truck)
        (lifting ?x - hoist ?y - crate)
        (available ?x - hoist)
        (clear ?x - surface)
    )

    (:tasks
        (do_put_on ?c - crate ?s - surface)
        (do_clear ?s1 - surface ?p - place)
        (do_get_truck ?t - truck ?p - place)
        (do_lift_crate ?c - crate ?p - place ?h)
        (do_load_truck ?c - crate ?s - surface ?p - place ?t - truck)
        (do_unload_truck ?c - crate ?s - surface ?p - place ?t - truck)
    )

    (:action drive
        :parameters (?x - truck ?y - place ?z - place)
        :precondition (and
            (at ?x ?y)
        )
        :effect (and
            (not (at ?x ?y))
            (at ?x ?z)
        )
    )

    (:action lift
        :parameters (?x - hoist ?y - crate ?z - surface ?p - place)
        :precondition (and
            (at ?x ?p)
            (available ?x)
            (at ?y ?p)
            (on ?y ?z)
            (clear ?y)
        )
        :effect (and
            (not (at ?y ?p))
            (lifting ?x ?y)
            (not (clear ?y))
            (not (available ?x))
            (clear ?z)
            (not (on ?y ?z))
        )
    )

    (:action drop
        :parameters (?x - hoist ?y - crate ?z - surface ?p - place)
        :precondition (and
            (at ?x ?p)
            (at ?z ?p)
            (clear ?z)
            (lifting ?x ?y)
        )
        :effect (and
            (available ?x)
            (not (lifting ?x ?y))
            (at ?y ?p)
            (not (clear ?z))
            (clear ?y)
            (on ?y ?z)
        )
    )

    (:action load
        :parameters (?x - hoist ?y - crate ?z - truck ?p - place)
        :precondition (and
            (at ?x ?p)
            (at ?z ?p)
            (lifting ?x ?y)
        )
        :effect (and
            (not (lifting ?x ?y))
            (in ?y ?z)
            (available ?x)
        )
    )

    (:action unload
        :parameters (?x - hoist ?y - crate ?z - truck ?p - place)
        :precondition (and
            (at ?x ?p)
            (at ?z ?p)
            (available ?x)
            (in ?y ?z)
        )
        :effect (and
            (not (in ?y ?z))
            (not (available ?x))
            (lifting ?x ?y)
        )
    )

    (:method do_put_on_0
        :parameters (?c - crate ?s2 - surface)
        :task (do_put_on ?c ?s2)
        :precondition (and
            ( on ?c ?s2)
        )
        :ordered-subtasks ()
    )

    (:method do_put_on_1
        :parameters (?c - crate ?s2 - surface ?p - place ?h - hoist)
        :task (do_put_on ?c ?s2)
        :precondition (and
            (at ?c ?p)
        )
        :ordered-subtasks (and
            (do_clear ?c ?p)
            (do_clear ?s2 ?p)
            (do_lift_crate ?c ?p ?h)
            (drop ?h ?c ?s2 ?p)
        )
    )

    (:method do_put_on_2
        :parameters (?c - crate ?s2 - surface ?t - truck ?p - place ?h - hoist)
        :task (do_put_on ?c ?s2)
        :precondition (and
            (in ?c ?t)
        )
        :ordered-subtasks (and
            (do_get_truck ?t ?p)
            (do_clear ?s2 ?p)
            (unload ?h ?c ?t ?p)
            (drop ?h ?c ?s2 ?p)
        )
    )

    (:method do_put_on_3
        :parameters (?c - crate ?s1 ?s2 - surface ?p1 ?p2 - place ?t - truck)
        :task (do_put_on ?c ?s2)
        :precondition (and
            (not (= ?p1 ?p2))
            (not (= ?s1 ?s2))
        )
        :ordered-subtasks (and
            (do_load_truck ?c ?s1 ?p1 ?t)
            (drive ?t ?p1 ?p2)
            (do_unload_truck ?c ?s2 ?p2 ?t)
        )
    )

    (:method do_clear_0
        :parameters (?s1 - surface ?p1 - place)
        :task (do_clear ?s1 ?p1)
        :precondition (and
            (clear ?s1)
            (at ?s1 ?p1)
        )
        :ordered-subtasks ()
    )

    (:method do_clear_1
        :parameters (?s1 - surface ?p1 - place ?h1 - hoist ?c - crate ?t - truck)
        :task (do_clear ?s1 ?p1)
        :precondition (and
            (not (clear ?s1))
            (on ?c ?s1 )
            (at ?s1 ?p1)
            (at ?h1 ?p1)
        )
        :ordered-subtasks (and
            (do_clear ?c ?p1)
            (lift ?h1 ?c ?s1 ?p1)
            (do_get_truck ?t ?p1)
            (load ?h1 ?c ?t ?p1)
        )
    )

    (:method do_get_truck_0
        :parameters (?t - truck ?p1 - place)
        :task (do_get_truck ?t ?p1)
        :precondition (and
            (at ?t ?p1)
        )
        :ordered-subtasks ()
    )

    (:method do_get_truck_1
        :parameters (?t - truck ?p1 ?p2 - place)
        :task (do_get_truck ?t ?p1)
        :precondition (and
            (not (at ?t ?p1))
            (not (= ?p1 ?p2))
        )
        :ordered-subtasks (and
            (drive ?t ?p2 ?p1)
        )

    )

    (:method do_lift_crate_0
        :parameters (?c - crate ?p - place ?h - hoist ?t - truck)
        :task (do_lift_crate ?c ?p ?h)
        :precondition (and
            (in ?c ?t)
            (at ?h ?p)
        )
        :ordered-subtasks (and
            (do_get_truck ?t ?p)
            (unload ?h ?c ?t ?p)
        )
    )

    (:method do_lift_crate_1
        :parameters (?c - crate ?p - place ?h - hoist ?s - surface)
        :task (do_lift_crate ?c ?p ?h)
        :precondition (and
            (on ?c ?s)
            (at ?c ?p)
            (at ?s ?p)
            (at ?h ?p)
        )
        :ordered-subtasks (and
            (lift ?h ?c ?s ?p)
        )
    )

    (:method do_load_truck_0
        :parameters (?c - crate ?s - surface ?p - place ?t - truck ?h - hoist)
        :task (do_load_truck ?c ?s ?p ?t)
        :precondition (and
            (at ?c ?p)
            (at ?s ?p)
            (on ?c ?s)
            (at ?h ?p)
        )
        :ordered-subtasks (and
            (do_get_truck ?t ?p)
            (do_clear ?c ?p)
            (lift ?h ?c ?s ?p)
            (load ?h ?c ?t ?p)
        )
    )

    (:method do_unload_truck_1
        :parameters (?c - crate ?s - surface  ?p - place ?t - truck ?h - hoist)
        :task (do_load_truck ?c ?s ?p ?t)
        :precondition (and
            (in ?c ?t)
            (at ?t ?p)
            (at ?h ?p)
            (at ?s ?p)
        )
        :ordered-subtasks (and
            (do_clear ?s ?p)
            (unload ?h ?c ?t ?p)
            (drop ?h ?c ?s ?p)
        )
    )
)
