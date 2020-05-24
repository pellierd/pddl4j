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

(define (domain satellite)

  	(:requirements
  	    :strips
  	    :typing
  	    :total-ordered-htn
  	    :htn-method-preconditions
  	    :negative-preconditions
  	    :equality
  	)

  	(:types satellite direction instrument mode)

 	(:predicates
 	    (on_board ?i - instrument ?s - satellite)
 		(supports ?i - instrument ?m - mode)
 		(pointing ?s - satellite ?d - direction)
 		(power_avail ?s - satellite)
 		(power_on ?i - instrument)
 		(calibrated ?i - instrument)
 		(have_image ?d - direction ?m - mode)
 		(calibration_target ?i - instrument ?d - direction)
 	)

 	(:tasks
        (do_mission ?d - direction ?m - mode)
  	    (do_prepare ?s - satellite ?i - instrument ?d - direction)
  	    (do_switching ?s - satellite ?i - instrument)
        (do_calibration ?s - satellite ?i - instrument ?d - direction)
        (make_power_available ?s - satellite ?i - instrument)
        (do_turning ?s - satellite ?d - direction)
 	)

    (:action turn_to
        :parameters (?s - satellite ?d_new - direction ?d_prev - direction)
        :precondition (and
            (pointing ?s ?d_prev)
            (not (= ?d_new ?d_prev))
        )
        :effect (and
            (pointing ?s ?d_new)
            (not (pointing ?s ?d_prev))
        )
    )

    (:action switch_on
         :parameters (?i - instrument ?s - satellite)
         :precondition (and
            (on_board ?i ?s)
            (power_avail ?s)
         )
        :effect (and
            (power_on ?i)
            (not (calibrated ?i))
            (not (power_avail ?s))
        )
    )

    (:action switch_off
        :parameters (?i - instrument ?s - satellite)
        :precondition (and
            (on_board ?i ?s)
            (power_on ?i)
        )
        :effect (and
            (not (power_on ?i))
            (power_avail ?s)
        )
    )

    (:action calibrate
        :parameters (?s - satellite ?i - instrument ?d - direction)
        :precondition (and
            (on_board ?i ?s)
		    (calibration_target ?i ?d)
            (pointing ?s ?d)
            (power_on ?i)
        )
        :effect (and
            (calibrated ?i)
        )
    )

    (:action take_image
        :parameters (?s - satellite ?d - direction ?i - instrument ?m - mode)
        :precondition (and
            (calibrated ?i)
            (on_board ?i ?s)
            (supports ?i ?m)
            (power_on ?i)
            (pointing ?s ?d)
        )
        :effect (and
            (have_image ?d ?m)
        )
    )

    (:method do_mission_0
  	    :parameters (?s - satellite ?m - mode ?i -instrument ?d - direction)
  	    :task (do_mission ?d ?m)
  	    :precondition ()
  	    :ordered-subtasks (and
  	        (do_prepare ?s ?i ?d)
  			(take_image ?s ?d ?i ?m)
  		)
    )

    (:method do_prepare_0
        :parameters	(?s - satellite ?i - instrument ?d - direction)
        :task (do_prepare ?s ?i ?d)
        :precondition ()
        :ordered-subtasks (and
  		    (do_switching ?s ?i)
  			(do_turning ?s ?d)
  	    )
    )

    (:method do_switching_0
        :parameters	(?s - satellite ?i1 ?i2 - instrument ?d - direction)
        :task (do_switching ?s ?i1)
        :precondition (and
            (on_board ?i1 ?s)
            (on_board ?i2 ?s)
            (not (power_avail ?s))
        )
        :ordered-subtasks (and
            (make_power_available ?s ?i2)
  			(switch_on ?i1 ?s)
  			(do_calibration ?s ?i1 ?d)
  	    )
    )

    (:method do_switching_1
        :parameters	(?s - satellite ?i - instrument ?d - direction)
        :task (do_switching ?s ?i)
        :precondition (and
  		    (on_board ?i ?s)
  		    (power_avail ?s)
  		)
        :ordered-subtasks (and
            (switch_on ?i ?s)
    		(do_calibration ?s ?i ?d)
    	)
    )

    (:method do_switching_2
        :parameters	(?s - satellite ?i - instrument)
        :task (do_switching ?s ?i)
        :precondition (and
  	        (power_on ?i)
  	    )
        :ordered-subtasks ()
    )

    (:method do_calibration_0
        :parameters	(?s - satellite ?i - instrument ?d - direction)
        :task (do_calibration ?s ?i ?d)
        :precondition (and
  		    (not (calibrated ?i))
  		)
  		:ordered-subtasks (and
            (do_prepare ?s ?i ?d)
    		(calibrate ?s ?i ?d)
    	)
    )

    (:method do_calibration_1
        :parameters	(?s - satellite ?i - instrument ?d - direction)
        :task (do_calibration ?s ?i ?d)
        :precondition (and
            (calibrated ?i)
  	    )
  	    :ordered-subtasks ()
    )

    (:method make_power_available_0
        :parameters	(?s - satellite ?i - instrument)
        :task (make_power_available ?s ?i)
        :precondition (and
            (power_on ?i)
            (not (power_avail ?s))
        )
  		:ordered-subtasks (and
  		    (switch_off ?i ?s)
  		)
    )

    (:method do_turning_0
        :parameters	(?s - satellite ?d1 ?d2 - direction)
        :task (do_turning ?s ?d1)
        :precondition (and
            (pointing ?s ?d2)
            (not (pointing ?s ?d1))
        )
  		:ordered-subtasks (and
  		    (turn_to ?s ?d1 ?d2)
        )
    )

    (:method do_turning_1
        :parameters	(?s - satellite ?d - direction)
        :task (do_turning ?s ?d)
        :precondition (and
            (pointing ?s ?d)
        )
  		:ordered-subtasks ()
    )
)

