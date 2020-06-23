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

(define (problem p12)

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
        instrument6 - instrument
        satellite3 - satellite
        instrument7 - instrument
        instrument8 - instrument
        instrument9 - instrument
        satellite4 - satellite
        instrument10 - instrument
        instrument11 - instrument
        instrument12 - instrument
        satellite5 - satellite
        instrument13 - instrument
        satellite6 - satellite
        instrument14 - instrument
        instrument15 - instrument
        instrument16 - instrument
        satellite7 - satellite
        instrument17 - instrument
        instrument18 - instrument
        instrument19 - instrument
        infrared3 - mode
        infrared1 - mode
        thermograph2 - mode
        spectrograph0 - mode
        Star0 - direction
        Star1 - direction
        GroundStation3 - direction
        Star2 - direction
        Planet4 - direction
        Planet5 - direction
        Star6 - direction
        Star7 - direction
        Phenomenon8 - direction
        Star9 - direction
        Star10 - direction
        Planet11 - direction
        Phenomenon12 - direction
        Phenomenon13 - direction
        Phenomenon14 - direction
        Star15 - direction
        Phenomenon16 - direction
        Planet17 - direction
        Planet18 - direction
        Star19 - direction
        Planet20 - direction
        Planet21 - direction
        Planet22 - direction
        Star23 - direction
        Phenomenon24 - direction
        Planet25 - direction
        Star26 - direction
        Star27 - direction
        Phenomenon28 - direction
        Star29 - direction
        Phenomenon30 - direction
        Star31 - direction
        Star32 - direction
        Star33 - direction
        Planet34 - direction
        Phenomenon35 - direction
        Planet36 - direction
        Star37 - direction
        Planet38 - direction
        Star39 - direction
        Star40 - direction
        Planet41 - direction
        Phenomenon42 - direction
        Star43 - direction
        Planet44 - direction
        Phenomenon45 - direction
        Phenomenon46 - direction
        Star47 - direction
        Star48 - direction
        Phenomenon49 - direction
        Star50 - direction
        Phenomenon51 - direction
        Planet52 - direction
        Planet53 - direction
        Planet54 - direction
        Star55 - direction
        Star56 - direction
        Planet57 - direction
        Planet58 - direction
        Planet59 - direction
        Planet60 - direction
        Planet61 - direction
        Phenomenon62 - direction
        Phenomenon63 - direction
        Phenomenon64 - direction
        Planet65 - direction
        Phenomenon66 - direction
        Phenomenon67 - direction
        Phenomenon68 - direction
        Planet69 - direction
        Planet70 - direction
        Phenomenon71 - direction
        Planet72 - direction
        Phenomenon73 - direction
    )

    (:htn
        :ordered-subtasks (and
            (do_mission  Planet4 thermograph2)
            (do_mission  Planet5 spectrograph0)
            (do_mission  Star6 thermograph2)
            (do_mission  Star7 infrared3)
            (do_mission  Phenomenon8 spectrograph0)
            (do_mission  Star9 infrared1)
            (do_mission  Star10 infrared3)
            (do_mission  Planet11 infrared3)
            (do_mission  Phenomenon13 infrared3)
            (do_mission  Phenomenon14 infrared3)
            (do_mission  Star15 thermograph2)
            (do_mission  Phenomenon16 spectrograph0)
            (do_mission  Planet17 infrared1)
            (do_mission  Planet18 infrared3)
            (do_mission  Planet20 spectrograph0)
            (do_mission  Planet21 spectrograph0)
            (do_mission  Planet22 spectrograph0)
            (do_mission  Phenomenon24 infrared1)
            (do_mission  Planet25 spectrograph0)
            (do_mission  Star26 infrared1)
            (do_mission  Star27 infrared3)
            (do_mission  Phenomenon28 spectrograph0)
            (do_mission  Star29 infrared3)
            (do_mission  Phenomenon30 thermograph2)
            (do_mission  Star31 infrared3)
            (do_mission  Star32 infrared1)
            (do_mission  Star33 infrared3)
            (do_mission  Planet34 thermograph2)
            (do_mission  Phenomenon35 spectrograph0)
            (do_mission  Planet36 infrared1)
            (do_mission  Star37 thermograph2)
            (do_mission  Planet38 spectrograph0)
            (do_mission  Star39 infrared1)
            (do_mission  Star40 spectrograph0)
            (do_mission  Planet41 infrared1)
            (do_mission  Phenomenon42 infrared3)
            (do_mission  Star43 infrared1)
            (do_mission  Planet44 spectrograph0)
            (do_mission  Phenomenon45 thermograph2)
            (do_mission  Phenomenon46 infrared1)
            (do_mission  Star47 spectrograph0)
            (do_mission  Star48 infrared3)
            (do_mission  Star50 infrared1)
            (do_mission  Planet52 infrared1)
            (do_mission  Planet53 spectrograph0)
            (do_mission  Planet54 thermograph2)
            (do_mission  Star55 infrared3)
            (do_mission  Star56 infrared3)
            (do_mission  Planet57 infrared3)
            (do_mission  Planet58 spectrograph0)
            (do_mission  Planet59 spectrograph0)
            (do_mission  Planet60 thermograph2)
            (do_mission  Planet61 infrared1)
            (do_mission  Phenomenon63 infrared1)
            (do_mission  Phenomenon64 infrared3)
            (do_mission  Planet65 thermograph2)
            (do_mission  Phenomenon66 infrared3)
            (do_mission  Phenomenon67 infrared3)
            (do_mission  Phenomenon68 infrared3)
            (do_mission  Planet69 thermograph2)
            (do_mission  Planet70 thermograph2)
            (do_mission  Phenomenon71 infrared1)
            (do_mission  Planet72 infrared3)
            (do_mission  Phenomenon73 thermograph2)
            (do_turning satellite3 Planet34)
            (do_turning satellite4 Phenomenon12)
            (do_turning satellite6 Planet41)
            (do_turning satellite7 Star6)
        )
    )

    (:init
        (supports instrument0 infrared1)
        (supports instrument0 infrared3)
        (calibration_target instrument0 Star0)
        (supports instrument1 infrared1)
        (calibration_target instrument1 Star0)
        (on_board instrument0 satellite0)
        (on_board instrument1 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Star33)
        (supports instrument2 infrared1)
        (supports instrument2 spectrograph0)
        (calibration_target instrument2 Star2)
        (supports instrument3 infrared1)
        (supports instrument3 spectrograph0)
        (supports instrument3 thermograph2)
        (calibration_target instrument3 Star2)
        (on_board instrument2 satellite1)
        (on_board instrument3 satellite1)
        (power_avail satellite1)
        (pointing satellite1 Phenomenon13)
        (supports instrument4 thermograph2)
        (supports instrument4 infrared1)
        (calibration_target instrument4 GroundStation3)
        (supports instrument5 spectrograph0)
        (calibration_target instrument5 Star0)
        (supports instrument6 infrared1)
        (supports instrument6 infrared3)
        (supports instrument6 thermograph2)
        (calibration_target instrument6 Star1)
        (on_board instrument4 satellite2)
        (on_board instrument5 satellite2)
        (on_board instrument6 satellite2)
        (power_avail satellite2)
        (pointing satellite2 Star31)
        (supports instrument7 infrared3)
        (supports instrument7 thermograph2)
        (calibration_target instrument7 Star1)
        (supports instrument8 spectrograph0)
        (supports instrument8 infrared1)
        (supports instrument8 infrared3)
        (calibration_target instrument8 Star2)
        (supports instrument9 infrared1)
        (supports instrument9 infrared3)
        (supports instrument9 spectrograph0)
        (calibration_target instrument9 Star1)
        (on_board instrument7 satellite3)
        (on_board instrument8 satellite3)
        (on_board instrument9 satellite3)
        (power_avail satellite3)
        (pointing satellite3 Phenomenon13)
        (supports instrument10 thermograph2)
        (supports instrument10 spectrograph0)
        (calibration_target instrument10 Star2)
        (supports instrument11 thermograph2)
        (supports instrument11 infrared1)
        (supports instrument11 infrared3)
        (calibration_target instrument11 Star1)
        (supports instrument12 spectrograph0)
        (supports instrument12 thermograph2)
        (calibration_target instrument12 GroundStation3)
        (on_board instrument10 satellite4)
        (on_board instrument11 satellite4)
        (on_board instrument12 satellite4)
        (power_avail satellite4)
        (pointing satellite4 Planet38)
        (supports instrument13 spectrograph0)
        (supports instrument13 infrared1)
        (supports instrument13 thermograph2)
        (calibration_target instrument13 GroundStation3)
        (on_board instrument13 satellite5)
        (power_avail satellite5)
        (pointing satellite5 Planet65)
        (supports instrument14 infrared3)
        (supports instrument14 infrared1)
        (calibration_target instrument14 Star1)
        (supports instrument15 infrared3)
        (calibration_target instrument15 GroundStation3)
        (supports instrument16 infrared1)
        (supports instrument16 spectrograph0)
        (supports instrument16 infrared3)
        (calibration_target instrument16 GroundStation3)
        (on_board instrument14 satellite6)
        (on_board instrument15 satellite6)
        (on_board instrument16 satellite6)
        (power_avail satellite6)
        (pointing satellite6 Phenomenon28)
        (supports instrument17 infrared1)
        (supports instrument17 infrared3)
        (calibration_target instrument17 Star2)
        (supports instrument18 spectrograph0)
        (supports instrument18 thermograph2)
        (calibration_target instrument18 Star2)
        (supports instrument19 spectrograph0)
        (supports instrument19 thermograph2)
        (calibration_target instrument19 Star2)
        (on_board instrument17 satellite7)
        (on_board instrument18 satellite7)
        (on_board instrument19 satellite7)
        (power_avail satellite7)
        (pointing satellite7 Planet17)
    )
)
