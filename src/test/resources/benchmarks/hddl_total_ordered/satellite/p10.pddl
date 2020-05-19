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

(define (problem p10)

    (:domain satellite)

    (:objects
        satellite0 - satellite
        instrument0 - instrument
        satellite1 - satellite
        instrument1 - instrument
        instrument2 - instrument
        satellite2 - satellite
        instrument3 - instrument
        instrument4 - instrument
        instrument5 - instrument
        satellite3 - satellite
        instrument6 - instrument
        instrument7 - instrument
        satellite4 - satellite
        instrument8 - instrument
        instrument9 - instrument
        infrared1 - mode
        image2 - mode
        infrared0 - mode
        Star0 - direction
        GroundStation2 - direction
        GroundStation1 - direction
        Planet3 - direction
        Planet4 - direction
        Phenomenon5 - direction
        Phenomenon6 - direction
        Star7 - direction
        Planet8 - direction
        Planet9 - direction
        Star10 - direction
        Star11 - direction
        Planet12 - direction
        Planet13 - direction
        Phenomenon14 - direction
        Star15 - direction
        Star16 - direction
        Planet17 - direction
        Star18 - direction
        Phenomenon19 - direction
        Phenomenon20 - direction
        Planet21 - direction
        Planet22 - direction
        Phenomenon23 - direction
        Phenomenon24 - direction
        Star25 - direction
        Phenomenon26 - direction
        Phenomenon27 - direction
        Star28 - direction
        Planet29 - direction
        Phenomenon30 - direction
        Phenomenon31 - direction
        Phenomenon32 - direction
        Planet33 - direction
        Planet34 - direction
        Planet35 - direction
        Star36 - direction
        Star37 - direction
        Phenomenon38 - direction
        Planet39 - direction
        Star40 - direction
        Star41 - direction
        Star42 - direction
        Phenomenon43 - direction
        Star44 - direction
        Planet45 - direction
        Planet46 - direction
        Phenomenon47 - direction
        Phenomenon48 - direction
        Planet49 - direction
        Planet50 - direction
        Planet51 - direction
        Phenomenon52 - direction
    )

    (:htn
        :ordered-subtasks (and
            (do_mission Planet3 infrared0)
            (do_mission Planet4 infrared0)
            (do_mission Phenomenon5 image2)
            (do_mission Phenomenon6 infrared0)
            (do_mission Star7 infrared0)
            (do_mission Planet9 infrared0)
            (do_mission Star10 infrared0)
            (do_mission Star11 infrared1)
            (do_mission Planet13 infrared1)
            (do_mission Star18 infrared1)
            (do_mission Phenomenon19 infrared0)
            (do_mission Planet21 image2)
            (do_mission Planet22 image2)
            (do_mission Phenomenon23 infrared1)
            (do_mission Phenomenon24 infrared1)
            (do_mission Star25 image2)
            (do_mission Phenomenon26 infrared1)
            (do_mission Phenomenon27 infrared0)
            (do_mission Star28 infrared1)
            (do_mission Planet29 image2)
            (do_mission Phenomenon30 image2)
            (do_mission Phenomenon31 image2)
            (do_mission Phenomenon32 image2)
            (do_mission Planet33 infrared0)
            (do_mission Planet34 infrared1)
            (do_mission Planet35 image2)
            (do_mission Star36 infrared1)
            (do_mission Star37 infrared1)
            (do_mission Phenomenon38 infrared0)
            (do_mission Planet39 infrared0)
            (do_mission Star40 image2)
            (do_mission Star41 image2)
            (do_mission Star42 infrared0)
            (do_mission Phenomenon43 infrared0)
            (do_mission Star44 image2)
            (do_mission Planet45 image2)
            (do_mission Planet46 image2)
            (do_mission Phenomenon47 infrared0)
            (do_mission Phenomenon48 infrared1)
            (do_mission Planet49 infrared1)
            (do_mission Planet50 infrared0)
            (do_mission Planet51 image2)
            (do_mission Phenomenon52 infrared1)
            (do_turning satellite1 Planet46)
            (do_turning satellite2 Phenomenon48)
        )
    )

    (:init
        (supports instrument0 image2)
        (calibration_target instrument0 GroundStation2)
        (on_board instrument0 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Planet50)
        (supports instrument1 image2)
        (supports instrument1 infrared0)
        (calibration_target instrument1 GroundStation1)
        (supports instrument2 image2)
        (supports instrument2 infrared1)
        (supports instrument2 infrared0)
        (calibration_target instrument2 Star0)
        (on_board instrument1 satellite1)
        (on_board instrument2 satellite1)
        (power_avail satellite1)
        (pointing satellite1 Star7)
        (supports instrument3 infrared1)
        (supports instrument3 image2)
        (supports instrument3 infrared0)
        (calibration_target instrument3 Star0)
        (supports instrument4 infrared1)
        (supports instrument4 infrared0)
        (supports instrument4 image2)
        (calibration_target instrument4 GroundStation2)
        (supports instrument5 infrared1)
        (supports instrument5 image2)
        (calibration_target instrument5 GroundStation2)
        (on_board instrument3 satellite2)
        (on_board instrument4 satellite2)
        (on_board instrument5 satellite2)
        (power_avail satellite2)
        (pointing satellite2 Planet8)
        (supports instrument6 infrared1)
        (supports instrument6 image2)
        (calibration_target instrument6 Star0)
        (supports instrument7 infrared0)
        (calibration_target instrument7 GroundStation1)
        (on_board instrument6 satellite3)
        (on_board instrument7 satellite3)
        (power_avail satellite3)
        (pointing satellite3 Planet12)
        (supports instrument8 image2)
        (calibration_target instrument8 GroundStation2)
        (supports instrument9 infrared0)
        (calibration_target instrument9 GroundStation1)
        (on_board instrument8 satellite4)
        (on_board instrument9 satellite4)
        (power_avail satellite4)
        (pointing satellite4 Planet8)
    )
)
