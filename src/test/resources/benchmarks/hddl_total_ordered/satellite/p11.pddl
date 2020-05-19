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

(define (problem p11)

    (:domain satellite)

    (:objects
        satellite0 - satellite
        instrument0 - instrument
        instrument1 - instrument
        satellite1 - satellite
        instrument2 - instrument
        instrument3 - instrument
        satellite2 - satellite
        instrument4 - instrument
        instrument5 - instrument
        satellite3 - satellite
        instrument6 - instrument
        instrument7 - instrument
        satellite4 - satellite
        instrument8 - instrument
        satellite5 - satellite
        instrument9 - instrument
        instrument10 - instrument
        instrument11 - instrument
        satellite6 - satellite
        instrument12 - instrument
        instrument13 - instrument
        instrument14 - instrument
        infrared1 - mode
        thermograph2 - mode
        infrared0 - mode
        Star0 - direction
        Star2 - direction
        GroundStation1 - direction
        Planet3 - direction
        Star4 - direction
        Planet5 - direction
        Star6 - direction
        Star7 - direction
        Phenomenon8 - direction
        Phenomenon9 - direction
        Planet10 - direction
        Planet11 - direction
        Planet12 - direction
        Phenomenon13 - direction
        Phenomenon14 - direction
        Phenomenon15 - direction
        Planet16 - direction
        Star17 - direction
        Planet18 - direction
        Planet19 - direction
        Phenomenon20 - direction
        Planet21 - direction
        Star22 - direction
        Star23 - direction
        Planet24 - direction
        Planet25 - direction
        Phenomenon26 - direction
        Star27 - direction
        Planet28 - direction
        Planet29 - direction
        Star30 - direction
        Star31 - direction
        Planet32 - direction
        Phenomenon33 - direction
        Phenomenon34 - direction
        Star35 - direction
        Planet36 - direction
        Star37 - direction
        Star38 - direction
        Planet39 - direction
        Star40 - direction
        Planet41 - direction
        Planet42 - direction
        Phenomenon43 - direction
        Planet44 - direction
        Phenomenon45 - direction
        Phenomenon46 - direction
        Phenomenon47 - direction
        Planet48 - direction
        Planet49 - direction
        Planet50 - direction
        Phenomenon51 - direction
        Phenomenon52 - direction
        Star53 - direction
        Star54 - direction
        Phenomenon55 - direction
        Planet56 - direction
        Phenomenon57 - direction
        Star58 - direction
        Star59 - direction
        Phenomenon60 - direction
        Phenomenon61 - direction
        Phenomenon62 - direction
        Planet63 - direction
        Planet64 - direction
        Star65 - direction
        Star66 - direction
        Planet67 - direction
        Planet68 - direction
        Phenomenon69 - direction
        Star70 - direction
        Planet71 - direction
        Phenomenon72 - direction
    )

    (:htn
        :ordered-subtasks (and
            (do_mission Planet3 infrared1)
            (do_mission Star4 infrared1)
            (do_mission Planet5 thermograph2)
            (do_mission Star6 infrared1)
            (do_mission Star7 infrared0)
            (do_mission Phenomenon8 thermograph2)
            (do_mission Phenomenon9 infrared0)
            (do_mission Planet10 infrared0)
            (do_mission Planet11 infrared1)
            (do_mission Planet12 thermograph2)
            (do_mission Phenomenon14 infrared0)
            (do_mission Phenomenon15 infrared0)
            (do_mission Planet16 infrared1)
            (do_mission Planet18 infrared0)
            (do_mission Planet19 infrared0)
            (do_mission Phenomenon20 infrared1)
            (do_mission Planet21 infrared0)
            (do_mission Star22 infrared1)
            (do_mission Star23 thermograph2)
            (do_mission Planet24 infrared1)
            (do_mission Planet25 infrared0)
            (do_mission Phenomenon26 thermograph2)
            (do_mission Star27 infrared0)
            (do_mission Planet28 infrared0)
            (do_mission Planet29 infrared0)
            (do_mission Star30 infrared1)
            (do_mission Planet32 thermograph2)
            (do_mission Phenomenon33 infrared0)
            (do_mission Phenomenon34 infrared1)
            (do_mission Star35 thermograph2)
            (do_mission Planet36 infrared0)
            (do_mission Star37 thermograph2)
            (do_mission Star38 thermograph2)
            (do_mission Planet39 infrared1)
            (do_mission Star40 thermograph2)
            (do_mission Planet41 thermograph2)
            (do_mission Planet42 infrared0)
            (do_mission Phenomenon43 thermograph2)
            (do_mission Planet44 infrared1)
            (do_mission Phenomenon45 thermograph2)
            (do_mission Phenomenon46 infrared0)
            (do_mission Phenomenon47 infrared0)
            (do_mission Planet48 thermograph2)
            (do_mission Planet49 thermograph2)
            (do_mission Planet50 thermograph2)
            (do_mission Phenomenon51 thermograph2)
            (do_mission Phenomenon52 infrared1)
            (do_mission Star53 infrared1)
            (do_mission Star54 infrared0)
            (do_mission Phenomenon55 thermograph2)
            (do_mission Planet56 thermograph2)
            (do_mission Phenomenon57 thermograph2)
            (do_mission Star58 infrared1)
            (do_mission Star59 thermograph2)
            (do_mission Phenomenon60 infrared0)
            (do_mission Phenomenon61 thermograph2)
            (do_mission Phenomenon62 infrared0)
            (do_mission Planet63 thermograph2)
            (do_mission Planet64 infrared0)
            (do_mission Star65 infrared1)
            (do_mission Planet67 thermograph2)
            (do_mission Planet68 infrared0)
            (do_mission Phenomenon69 infrared0)
            (do_mission Star70 infrared1)
            (do_mission Planet71 infrared1)
            (do_mission Phenomenon72 infrared0)
            (do_turning satellite0 Planet29)
            (do_turning satellite1 GroundStation1)
            (do_turning satellite5 Phenomenon69)
            (do_turning satellite6 Planet68)
        )
    )

    (:init
        (supports instrument0 infrared0)
        (supports instrument0 thermograph2)
        (supports instrument0 infrared1)
        (calibration_target instrument0 Star2)
        (supports instrument1 infrared0)
        (supports instrument1 infrared1)
        (supports instrument1 thermograph2)
        (calibration_target instrument1 Star0)
        (on_board instrument0 satellite0)
        (on_board instrument1 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Planet21)
        (supports instrument2 thermograph2)
        (supports instrument2 infrared1)
        (supports instrument2 infrared0)
        (calibration_target instrument2 Star0)
        (supports instrument3 thermograph2)
        (supports instrument3 infrared1)
        (calibration_target instrument3 Star0)
        (on_board instrument2 satellite1)
        (on_board instrument3 satellite1)
        (power_avail satellite1)
        (pointing satellite1 Planet10)
        (supports instrument4 infrared1)
        (calibration_target instrument4 Star2)
        (supports instrument5 thermograph2)
        (supports instrument5 infrared0)
        (supports instrument5 infrared1)
        (calibration_target instrument5 Star2)
        (on_board instrument4 satellite2)
        (on_board instrument5 satellite2)
        (power_avail satellite2)
        (pointing satellite2 Star17)
        (supports instrument6 thermograph2)
        (supports instrument6 infrared1)
        (supports instrument6 infrared0)
        (calibration_target instrument6 GroundStation1)
        (supports instrument7 thermograph2)
        (calibration_target instrument7 GroundStation1)
        (on_board instrument6 satellite3)
        (on_board instrument7 satellite3)
        (power_avail satellite3)
        (pointing satellite3 Phenomenon8)
        (supports instrument8 thermograph2)
        (supports instrument8 infrared1)
        (supports instrument8 infrared0)
        (calibration_target instrument8 Star0)
        (on_board instrument8 satellite4)
        (power_avail satellite4)
        (pointing satellite4 Planet24)
        (supports instrument9 infrared0)
        (supports instrument9 infrared1)
        (supports instrument9 thermograph2)
        (calibration_target instrument9 Star0)
        (supports instrument10 infrared1)
        (supports instrument10 infrared0)
        (calibration_target instrument10 Star0)
        (supports instrument11 infrared0)
        (supports instrument11 infrared1)
        (supports instrument11 thermograph2)
        (calibration_target instrument11 GroundStation1)
        (on_board instrument9 satellite5)
        (on_board instrument10 satellite5)
        (on_board instrument11 satellite5)
        (power_avail satellite5)
        (pointing satellite5 Planet5)
        (supports instrument12 infrared0)
        (calibration_target instrument12 GroundStation1)
        (supports instrument13 thermograph2)
        (calibration_target instrument13 Star2)
        (supports instrument14 infrared0)
        (supports instrument14 thermograph2)
        (supports instrument14 infrared1)
        (calibration_target instrument14 GroundStation1)
        (on_board instrument12 satellite6)
        (on_board instrument13 satellite6)
        (on_board instrument14 satellite6)
        (power_avail satellite6)
        (pointing satellite6 Planet24)
    )
)
