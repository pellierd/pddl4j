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

(define (problem p01)

    (:domain satellite)

    (:objects
        satellite0 - satellite
        instrument0 - instrument
        image1 - mode
        spectrograph2 - mode
        thermograph0 - mode
        Star0 - direction
        GroundStation1 - direction
        GroundStation2 - direction
        Phenomenon3 - direction
        Phenomenon4 - direction
        Star5 - direction
        Phenomenon6 - direction
    )

    (:htn
        :ordered-subtasks (and
            (do_mission Phenomenon4 thermograph0)
            (do_mission Star5 thermograph0)
            (do_mission Phenomenon6 thermograph0)
        )
    )

    (:init
        (supports instrument0 thermograph0)
        (calibration_target instrument0 GroundStation2)
        (on_board instrument0 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Phenomenon6)
    )
)
