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

(define (problem p02)

    (:domain satellite)

    (:objects
        satellite0 - satellite
        instrument0 - instrument
        instrument1 - instrument
        infrared0 - mode
        infrared1 - mode
        image2 - mode
        GroundStation1 - direction
        Star0 - direction
        GroundStation2 - direction
        Planet3 - direction
        Planet4 - direction
        Phenomenon5 - direction
        Phenomenon6 - direction
        Star7 - direction
    )

    (:htn
        :ordered-subtasks (and
            (do_mission Planet3 infrared0)
            (do_mission Planet4 infrared0)
            (do_mission Phenomenon5 image2)
            (do_mission Phenomenon6 infrared0)
            (do_mission Star7 infrared0)
        )
    )

    (:init
        (supports instrument0 infrared1)
        (supports instrument0 infrared0)
        (calibration_target instrument0 Star0)
        (supports instrument1 image2)
        (supports instrument1 infrared1)
        (supports instrument1 infrared0)
        (calibration_target instrument1 GroundStation2)
        (on_board instrument0 satellite0)
        (on_board instrument1 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Planet4)
    )
)
