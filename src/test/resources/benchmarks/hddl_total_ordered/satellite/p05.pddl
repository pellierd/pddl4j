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

(define (problem p05)

    (:domain satellite)

    (:objects
        satellite0 - satellite
        instrument0 - instrument
        instrument1 - instrument
        instrument2 - instrument
        satellite1 - satellite
        instrument3 - instrument
        instrument4 - instrument
        satellite2 - satellite
        instrument5 - instrument
        satellite3 - satellite
        instrument6 - instrument
        satellite4 - satellite
        instrument7 - instrument
        instrument8 - instrument
        instrument9 - instrument
        thermograph2 - mode
        infrared0 - mode
        infrared1 - mode
        spectrograph4 - mode
        infrared3 - mode
        Star0 - direction
        Star3 - direction
        GroundStation1 - direction
        Star2 - direction
        Star4 - direction
        Planet5 - direction
        Phenomenon6 - direction
        Star7 - direction
        Planet8 - direction
        Star9 - direction
        Planet10 - direction
        Planet11 - direction
        Star12 - direction
        Phenomenon13 - direction
        Star14 - direction
        Star15 - direction
        Planet16 - direction
        Phenomenon17 - direction
        Star18 - direction
        Star19 - direction
        Planet20 - direction
        Phenomenon21 - direction
        Star22 - direction
        Star23 - direction
        Phenomenon24 - direction
    )

    (:htn
        :ordered-subtasks (and
            (do_mission Planet5 infrared0)
            (do_mission Phenomenon6 spectrograph4)
            (do_mission Star7 infrared0)
            (do_mission Planet8 infrared1)
            (do_mission Star9 spectrograph4)
            (do_mission Planet10 thermograph2)
            (do_mission Planet11 infrared3)
            (do_mission Phenomenon13 spectrograph4)
            (do_mission Star14 thermograph2)
            (do_mission Star15 infrared3)
            (do_mission Planet16 infrared1)
            (do_mission Phenomenon17 spectrograph4)
            (do_mission Star18 spectrograph4)
            (do_mission Star19 thermograph2)
            (do_mission Planet20 thermograph2)
            (do_mission Phenomenon21 thermograph2)
            (do_mission Star22 infrared1)
            (do_mission Star23 spectrograph4)
            (do_mission Phenomenon24 infrared0)
        )
    )

    (:init
        (supports instrument0 infrared1)
        (supports instrument0 spectrograph4)
        (calibration_target instrument0 Star0)
        (supports instrument1 infrared1)
        (supports instrument1 infrared0)
        (calibration_target instrument1 Star2)
        (supports instrument2 infrared1)
        (supports instrument2 infrared0)
        (calibration_target instrument2 Star3)
        (on_board instrument0 satellite0)
        (on_board instrument1 satellite0)
        (on_board instrument2 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Planet16)
        (supports instrument3 infrared0)
        (supports instrument3 spectrograph4)
        (calibration_target instrument3 Star4)
        (supports instrument4 infrared0)
        (supports instrument4 infrared3)
        (supports instrument4 thermograph2)
        (calibration_target instrument4 Star4)
        (on_board instrument3 satellite1)
        (on_board instrument4 satellite1)
        (power_avail satellite1)
        (pointing satellite1 Star4)
        (supports instrument5 infrared1)
        (calibration_target instrument5 GroundStation1)
        (on_board instrument5 satellite2)
        (power_avail satellite2)
        (pointing satellite2 Star15)
        (supports instrument6 infrared1)
        (calibration_target instrument6 Star4)
        (on_board instrument6 satellite3)
        (power_avail satellite3)
        (pointing satellite3 Phenomenon6)
        (supports instrument7 infrared1)
        (supports instrument7 infrared3)
        (calibration_target instrument7 Star2)
        (supports instrument8 infrared0)
        (supports instrument8 infrared3)
        (supports instrument8 spectrograph4)
        (calibration_target instrument8 Star2)
        (supports instrument9 infrared3)
        (supports instrument9 spectrograph4)
        (supports instrument9 infrared1)
        (calibration_target instrument9 Star4)
        (on_board instrument7 satellite4)
        (on_board instrument8 satellite4)
        (on_board instrument9 satellite4)
        (power_avail satellite4)
        (pointing satellite4 Star14)
    )
)
