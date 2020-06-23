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

(define (problem p03)

    (:domain satellite)

    (:objects
        satellite0 - satellite
        instrument0 - instrument
        instrument1 - instrument
        instrument2 - instrument
        satellite1 - satellite
        instrument3 - instrument
        image1 - mode
        infrared0 - mode
        spectrograph2 - mode
        Star1 - direction
        Star2 - direction
        Star0 - direction
        Star3 - direction
        Star4 - direction
        Phenomenon5 - direction
        Phenomenon6 - direction
        Phenomenon7 - direction
    )

    (:htn
        :ordered-subtasks (and
            (do_mission Star3 infrared0)
            (do_mission Star4 spectrograph2)
            (do_mission Phenomenon5 spectrograph2)
            (do_mission Phenomenon7 spectrograph2)
            (do_turning satellite0 Phenomenon5)
        )
    )

    (:init
        (supports instrument0 spectrograph2)
        (supports instrument0 infrared0)
        (calibration_target instrument0 Star1)
        (supports instrument1 image1)
        (calibration_target instrument1 Star2)
        (supports instrument2 infrared0)
        (supports instrument2 image1)
        (calibration_target instrument2 Star0)
        (on_board instrument0 satellite0)
        (on_board instrument1 satellite0)
        (on_board instrument2 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Star4)
        (supports instrument3 spectrograph2)
        (supports instrument3 infrared0)
        (supports instrument3 image1)
        (calibration_target instrument3 Star0)
        (on_board instrument3 satellite1)
        (power_avail satellite1)
        (pointing satellite1 Star0)
    )
)
