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

(define (problem p16)

    (:domain satellite)

    (:objects
        satellite0 - satellite
        instrument0 - instrument
        instrument1 - instrument
        instrument2 - instrument
        satellite1 - satellite
        instrument3 - instrument
        instrument4 - instrument
        instrument5 - instrument
        satellite2 - satellite
        instrument6 - instrument
        satellite3 - satellite
        instrument7 - instrument
        satellite4 - satellite
        instrument8 - instrument
        instrument9 - instrument
        satellite5 - satellite
        instrument10 - instrument
        instrument11 - instrument
        satellite6 - satellite
        instrument12 - instrument
        instrument13 - instrument
        satellite7 - satellite
        instrument14 - instrument
        instrument15 - instrument
        satellite8 - satellite
        instrument16 - instrument
        instrument17 - instrument
        satellite9 - satellite
        instrument18 - instrument
        instrument19 - instrument
        instrument20 - instrument
        satellite10 - satellite
        instrument21 - instrument
        satellite11 - satellite
        instrument22 - instrument
        satellite12 - satellite
        instrument23 - instrument
        instrument24 - instrument
        satellite13 - satellite
        instrument25 - instrument
        instrument26 - instrument
        satellite14 - satellite
        instrument27 - instrument
        instrument28 - instrument
        instrument29 - instrument
        infrared3 - mode
        infrared1 - mode
        infrared0 - mode
        spectrograph4 - mode
        thermograph2 - mode
        Star4 - direction
        Star0 - direction
        Star2 - direction
        GroundStation1 - direction
        Star3 - direction
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
        Star25 - direction
        Star26 - direction
        Star27 - direction
        Phenomenon28 - direction
        Star29 - direction
        Planet30 - direction
        Planet31 - direction
        Planet32 - direction
        Star33 - direction
        Star34 - direction
        Star35 - direction
        Star36 - direction
        Phenomenon37 - direction
        Phenomenon38 - direction
        Planet39 - direction
        Planet40 - direction
        Star41 - direction
        Planet42 - direction
        Phenomenon43 - direction
        Phenomenon44 - direction
        Phenomenon45 - direction
        Phenomenon46 - direction
        Planet47 - direction
        Phenomenon48 - direction
        Planet49 - direction
        Phenomenon50 - direction
        Star51 - direction
        Star52 - direction
        Planet53 - direction
        Phenomenon54 - direction
        Star55 - direction
        Phenomenon56 - direction
        Phenomenon57 - direction
        Planet58 - direction
        Planet59 - direction
        Planet60 - direction
        Phenomenon61 - direction
        Planet62 - direction
        Star63 - direction
        Star64 - direction
        Planet65 - direction
        Phenomenon66 - direction
        Star67 - direction
        Star68 - direction
        Star69 - direction
        Star70 - direction
        Star71 - direction
        Planet72 - direction
        Phenomenon73 - direction
        Planet74 - direction
        Star75 - direction
        Star76 - direction
        Planet77 - direction
        Star78 - direction
        Phenomenon79 - direction
        Star80 - direction
        Star81 - direction
        Star82 - direction
        Star83 - direction
        Planet84 - direction
        Star85 - direction
        Planet86 - direction
        Star87 - direction
        Phenomenon88 - direction
        Star89 - direction
        Phenomenon90 - direction
        Planet91 - direction
        Phenomenon92 - direction
        Planet93 - direction
        Phenomenon94 - direction
        Star95 - direction
        Star96 - direction
        Planet97 - direction
        Phenomenon98 - direction
        Phenomenon99 - direction
        Phenomenon100 - direction
        Star101 - direction
        Phenomenon102 - direction
        Planet103 - direction
        Phenomenon104 - direction
        Phenomenon105 - direction
        Phenomenon106 - direction
        Star107 - direction
        Phenomenon108 - direction
        Planet109 - direction
        Star110 - direction
        Phenomenon111 - direction
        Star112 - direction
        Star113 - direction
        Phenomenon114 - direction
        Phenomenon115 - direction
        Star116 - direction
        Star117 - direction
        Star118 - direction
        Phenomenon119 - direction
        Planet120 - direction
        Phenomenon121 - direction
        Phenomenon122 - direction
        Phenomenon123 - direction
        Star124 - direction
        Phenomenon125 - direction
        Phenomenon126 - direction
        Phenomenon127 - direction
        Planet128 - direction
        Planet129 - direction
        Planet130 - direction
        Phenomenon131 - direction
        Planet132 - direction
        Planet133 - direction
        Planet134 - direction
        Planet135 - direction
        Planet136 - direction
        Star137 - direction
        Star138 - direction
        Star139 - direction
        Planet140 - direction
        Planet141 - direction
        Star142 - direction
        Phenomenon143 - direction
        Phenomenon144 - direction
        Planet145 - direction
        Planet146 - direction
        Planet147 - direction
        Phenomenon148 - direction
        Star149 - direction
        Phenomenon150 - direction
        Planet151 - direction
        Phenomenon152 - direction
        Star153 - direction
        Star154 - direction
        Planet155 - direction
        Star156 - direction
        Star157 - direction
        Planet158 - direction
        Planet159 - direction
        Planet160 - direction
        Star161 - direction
        Planet162 - direction
        Planet163 - direction
        Star164 - direction
        Phenomenon165 - direction
        Phenomenon166 - direction
        Star167 - direction
        Star168 - direction
        Star169 - direction
        Star170 - direction
        Planet171 - direction
        Planet172 - direction
        Planet173 - direction
        Phenomenon174 - direction
        Planet175 - direction
        Phenomenon176 - direction
        Phenomenon177 - direction
        Phenomenon178 - direction
        Star179 - direction
        Planet180 - direction
        Planet181 - direction
        Phenomenon182 - direction
        Planet183 - direction
        Planet184 - direction
        Phenomenon185 - direction
        Phenomenon186 - direction
        Phenomenon187 - direction
        Planet188 - direction
        Planet189 - direction
        Planet190 - direction
        Phenomenon191 - direction
        Phenomenon192 - direction
        Star193 - direction
        Planet194 - direction
        Star195 - direction
        Planet196 - direction
        Phenomenon197 - direction
        Phenomenon198 - direction
        Planet199 - direction
        Phenomenon200 - direction
        Phenomenon201 - direction
        Planet202 - direction
        Phenomenon203 - direction
        Star204 - direction
    )

    (:htn
        :ordered-subtasks (and
            (t1   (do_mission  Planet5 infrared0))
            (t2   (do_mission  Phenomenon6 spectrograph4))
            (t3   (do_mission  Star7 infrared0))
            (t4   (do_mission  Planet8 infrared1))
            (t5   (do_mission  Star9 spectrograph4))
            (t6   (do_mission  Planet10 thermograph2))
            (t7   (do_mission  Planet11 infrared3))
            (t8   (do_mission  Phenomenon13 spectrograph4))
            (t9   (do_mission  Star14 thermograph2))
            (t10  (do_mission  Star15 infrared3))
            (t11  (do_mission  Planet16 infrared1))
            (t12  (do_mission  Phenomenon17 spectrograph4))
            (t13  (do_mission  Star18 spectrograph4))
            (t14  (do_mission  Star19 thermograph2))
            (t15  (do_mission  Planet20 thermograph2))
            (t16  (do_mission  Phenomenon21 thermograph2))
            (t17  (do_mission  Star22 infrared1))
            (t18  (do_mission  Star23 spectrograph4))
            (t19  (do_mission  Phenomenon24 infrared0))
            (t20  (do_mission  Star25 infrared3))
            (t21  (do_mission  Star26 infrared0))
            (t22  (do_mission  Star27 infrared1))
            (t23  (do_mission  Phenomenon28 spectrograph4))
            (t24  (do_mission  Star29 infrared1))
            (t25  (do_mission  Planet30 infrared1))
            (t26  (do_mission  Planet31 infrared0))
            (t27  (do_mission  Planet32 thermograph2))
            (t28  (do_mission  Star33 infrared3))
            (t29  (do_mission  Star34 infrared1))
            (t30  (do_mission  Star35 infrared1))
            (t31  (do_mission  Phenomenon37 infrared0))
            (t32  (do_mission  Phenomenon38 thermograph2))
            (t33  (do_mission  Planet39 thermograph2))
            (t34  (do_mission  Planet40 spectrograph4))
            (t35  (do_mission  Star41 infrared0))
            (t36  (do_mission  Planet42 spectrograph4))
            (t37  (do_mission  Phenomenon43 spectrograph4))
            (t38  (do_mission  Phenomenon45 spectrograph4))
            (t39  (do_mission  Phenomenon46 thermograph2))
            (t40  (do_mission  Planet47 infrared0))
            (t41  (do_mission  Phenomenon48 infrared1))
            (t42  (do_mission  Planet49 infrared0))
            (t43  (do_mission  Phenomenon50 infrared0))
            (t44  (do_mission  Star51 infrared1))
            (t45  (do_mission  Star52 infrared3))
            (t46  (do_mission  Planet53 infrared0))
            (t47  (do_mission  Star55 infrared1))
            (t48  (do_mission  Phenomenon56 infrared3))
            (t49  (do_mission  Phenomenon57 spectrograph4))
            (t50  (do_mission  Planet59 infrared0))
            (t51  (do_mission  Planet60 thermograph2))
            (t52  (do_mission  Phenomenon61 infrared0))
            (t53  (do_mission  Planet62 infrared3))
            (t54  (do_mission  Star63 infrared0))
            (t55  (do_mission  Star64 infrared0))
            (t56  (do_mission  Planet65 infrared3))
            (t57  (do_mission  Star67 thermograph2))
            (t58  (do_mission  Star68 infrared1))
            (t59  (do_mission  Star69 spectrograph4))
            (t60  (do_mission  Star70 infrared1))
            (t61  (do_mission  Star71 infrared1))
            (t62  (do_mission  Planet72 spectrograph4))
            (t63  (do_mission  Planet74 infrared1))
            (t64  (do_mission  Star75 infrared0))
            (t65  (do_mission  Star76 infrared0))
            (t66  (do_mission  Planet77 thermograph2))
            (t67  (do_mission  Star78 infrared0))
            (t68  (do_mission  Phenomenon79 infrared3))
            (t69  (do_mission  Star80 infrared0))
            (t70  (do_mission  Star81 infrared0))
            (t71  (do_mission  Star83 infrared0))
            (t72  (do_mission  Planet84 thermograph2))
            (t73  (do_mission  Planet86 infrared1))
            (t74  (do_mission  Star87 infrared3))
            (t75  (do_mission  Phenomenon88 infrared1))
            (t76  (do_mission  Star89 infrared3))
            (t77  (do_mission  Phenomenon90 infrared0))
            (t78  (do_mission  Planet91 spectrograph4))
            (t79  (do_mission  Phenomenon92 spectrograph4))
            (t80  (do_mission  Planet93 infrared1))
            (t81  (do_mission  Phenomenon94 infrared3))
            (t82  (do_mission  Star96 infrared3))
            (t83  (do_mission  Planet97 spectrograph4))
            (t84  (do_mission  Phenomenon98 infrared1))
            (t85  (do_mission  Phenomenon99 infrared3))
            (t86  (do_mission  Phenomenon100 thermograph2))
            (t87  (do_mission  Phenomenon102 spectrograph4))
            (t88  (do_mission  Planet103 infrared3))
            (t89  (do_mission  Phenomenon104 infrared1))
            (t90  (do_mission  Phenomenon106 thermograph2))
            (t91  (do_mission  Phenomenon108 infrared1))
            (t92  (do_mission  Planet109 infrared3))
            (t93  (do_mission  Star110 thermograph2))
            (t94  (do_mission  Phenomenon111 spectrograph4))
            (t95  (do_mission  Star113 spectrograph4))
            (t96  (do_mission  Phenomenon114 infrared0))
            (t97  (do_mission  Phenomenon115 infrared1))
            (t98  (do_mission  Star116 thermograph2))
            (t99  (do_mission  Star117 infrared1))
            (t100 (do_mission  Star118 infrared1))
            (t101 (do_mission  Phenomenon119 infrared1))
            (t102 (do_mission  Planet120 infrared0))
            (t103 (do_mission  Phenomenon121 spectrograph4))
            (t104 (do_mission  Phenomenon122 infrared1))
            (t105 (do_mission  Phenomenon123 infrared1))
            (t106 (do_mission  Star124 infrared3))
            (t107 (do_mission  Phenomenon125 spectrograph4))
            (t108 (do_mission  Phenomenon126 spectrograph4))
            (t109 (do_mission  Phenomenon127 infrared0))
            (t110 (do_mission  Planet128 infrared1))
            (t111 (do_mission  Planet129 thermograph2))
            (t112 (do_mission  Planet130 infrared3))
            (t113 (do_mission  Phenomenon131 infrared3))
            (t114 (do_mission  Planet134 spectrograph4))
            (t115 (do_mission  Planet135 spectrograph4))
            (t116 (do_mission  Planet136 thermograph2))
            (t117 (do_mission  Star137 spectrograph4))
            (t118 (do_mission  Star138 thermograph2))
            (t119 (do_mission  Star139 infrared3))
            (t120 (do_mission  Planet140 infrared0))
            (t121 (do_mission  Planet141 infrared3))
            (t122 (do_mission  Star142 thermograph2))
            (t123 (do_mission  Phenomenon144 infrared0))
            (t124 (do_mission  Planet145 infrared1))
            (t125 (do_mission  Planet146 infrared1))
            (t126 (do_mission  Planet147 infrared3))
            (t127 (do_mission  Star149 infrared3))
            (t128 (do_mission  Phenomenon150 thermograph2))
            (t129 (do_mission  Planet151 infrared0))
            (t130 (do_mission  Phenomenon152 infrared3))
            (t131 (do_mission  Star153 infrared3))
            (t132 (do_mission  Star154 infrared1))
            (t133 (do_mission  Planet155 thermograph2))
            (t134 (do_mission  Star156 infrared0))
            (t135 (do_mission  Star157 thermograph2))
            (t136 (do_mission  Planet158 infrared0))
            (t137 (do_mission  Planet159 thermograph2))
            (t138 (do_mission  Planet160 infrared0))
            (t139 (do_mission  Star161 infrared1))
            (t140 (do_mission  Planet162 thermograph2))
            (t141 (do_mission  Planet163 infrared0))
            (t142 (do_mission  Star164 infrared0))
            (t143 (do_mission  Phenomenon165 infrared3))
            (t144 (do_mission  Phenomenon166 infrared0))
            (t145 (do_mission  Star167 infrared3))
            (t146 (do_mission  Star168 infrared0))
            (t147 (do_mission  Star169 infrared0))
            (t148 (do_mission  Star170 spectrograph4))
            (t149 (do_mission  Planet171 infrared3))
            (t150 (do_mission  Planet172 thermograph2))
            (t151 (do_mission  Phenomenon174 thermograph2))
            (t152 (do_mission  Planet175 thermograph2))
            (t153 (do_mission  Phenomenon176 spectrograph4))
            (t154 (do_mission  Phenomenon177 infrared1))
            (t155 (do_mission  Phenomenon178 infrared1))
            (t156 (do_mission  Star179 spectrograph4))
            (t157 (do_mission  Planet180 spectrograph4))
            (t158 (do_mission  Planet181 spectrograph4))
            (t159 (do_mission  Planet183 infrared1))
            (t160 (do_mission  Planet184 thermograph2))
            (t161 (do_mission  Phenomenon185 infrared1))
            (t162 (do_mission  Phenomenon186 infrared3))
            (t163 (do_mission  Phenomenon187 spectrograph4))
            (t164 (do_mission  Planet188 infrared0))
            (t165 (do_mission  Planet189 thermograph2))
            (t166 (do_mission  Planet190 spectrograph4))
            (t167 (do_mission  Phenomenon191 infrared1))
            (t168 (do_mission  Phenomenon192 infrared1))
            (t169 (do_mission  Star193 infrared3))
            (t170 (do_mission  Planet194 infrared3))
            (t171 (do_mission  Star195 spectrograph4))
            (t172 (do_mission  Planet196 spectrograph4))
            (t173 (do_mission  Phenomenon197 thermograph2))
            (t174 (do_mission  Phenomenon198 infrared1))
            (t175 (do_mission  Planet199 thermograph2))
            (t176 (do_mission  Phenomenon201 spectrograph4))
            (t177 (do_mission  Phenomenon203 infrared0))
            (t178 (do_mission  Star204 thermograph2))
            (t179 (do_turning satellite1 Star68))
            (t180 (do_turning satellite2 Star149))
            (t181 (do_turning satellite9 Phenomenon37))
            (t182 (do_turning satellite13 Phenomenon57))
        )
    )

    (:init
        (supports instrument0 spectrograph4)
        (supports instrument0 infrared0)
        (supports instrument0 thermograph2)
        (calibration_target instrument0 GroundStation1)
        (supports instrument1 spectrograph4)
        (supports instrument1 thermograph2)
        (calibration_target instrument1 Star0)
        (supports instrument2 infrared0)
        (supports instrument2 infrared3)
        (supports instrument2 spectrograph4)
        (calibration_target instrument2 Star4)
        (on_board instrument0 satellite0)
        (on_board instrument1 satellite0)
        (on_board instrument2 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Phenomenon143)
        (supports instrument3 infrared0)
        (calibration_target instrument3 Star4)
        (supports instrument4 spectrograph4)
        (supports instrument4 infrared0)
        (calibration_target instrument4 Star4)
        (supports instrument5 spectrograph4)
        (calibration_target instrument5 GroundStation1)
        (on_board instrument3 satellite1)
        (on_board instrument4 satellite1)
        (on_board instrument5 satellite1)
        (power_avail satellite1)
        (pointing satellite1 Phenomenon38)
        (supports instrument6 infrared3)
        (supports instrument6 thermograph2)
        (calibration_target instrument6 Star4)
        (on_board instrument6 satellite2)
        (power_avail satellite2)
        (pointing satellite2 Phenomenon56)
        (supports instrument7 infrared0)
        (supports instrument7 infrared1)
        (calibration_target instrument7 Star2)
        (on_board instrument7 satellite3)
        (power_avail satellite3)
        (pointing satellite3 Star142)
        (supports instrument8 thermograph2)
        (calibration_target instrument8 Star0)
        (supports instrument9 infrared0)
        (supports instrument9 thermograph2)
        (supports instrument9 spectrograph4)
        (calibration_target instrument9 Star4)
        (on_board instrument8 satellite4)
        (on_board instrument9 satellite4)
        (power_avail satellite4)
        (pointing satellite4 Phenomenon197)
        (supports instrument10 spectrograph4)
        (calibration_target instrument10 Star3)
        (supports instrument11 infrared3)
        (supports instrument11 infrared0)
        (calibration_target instrument11 GroundStation1)
        (on_board instrument10 satellite5)
        (on_board instrument11 satellite5)
        (power_avail satellite5)
        (pointing satellite5 Planet39)
        (supports instrument12 infrared0)
        (calibration_target instrument12 Star4)
        (supports instrument13 spectrograph4)
        (calibration_target instrument13 Star2)
        (on_board instrument12 satellite6)
        (on_board instrument13 satellite6)
        (power_avail satellite6)
        (pointing satellite6 Star0)
        (supports instrument14 spectrograph4)
        (calibration_target instrument14 Star2)
        (supports instrument15 infrared1)
        (supports instrument15 infrared0)
        (supports instrument15 spectrograph4)
        (calibration_target instrument15 Star2)
        (on_board instrument14 satellite7)
        (on_board instrument15 satellite7)
        (power_avail satellite7)
        (pointing satellite7 Phenomenon105)
        (supports instrument16 infrared0)
        (supports instrument16 infrared1)
        (supports instrument16 thermograph2)
        (calibration_target instrument16 Star0)
        (supports instrument17 spectrograph4)
        (supports instrument17 thermograph2)
        (calibration_target instrument17 Star0)
        (on_board instrument16 satellite8)
        (on_board instrument17 satellite8)
        (power_avail satellite8)
        (pointing satellite8 Planet60)
        (supports instrument18 infrared1)
        (calibration_target instrument18 Star2)
        (supports instrument19 infrared0)
        (supports instrument19 thermograph2)
        (supports instrument19 infrared1)
        (calibration_target instrument19 Star0)
        (supports instrument20 infrared1)
        (calibration_target instrument20 GroundStation1)
        (on_board instrument18 satellite9)
        (on_board instrument19 satellite9)
        (on_board instrument20 satellite9)
        (power_avail satellite9)
        (pointing satellite9 Star107)
        (supports instrument21 spectrograph4)
        (calibration_target instrument21 Star4)
        (on_board instrument21 satellite10)
        (power_avail satellite10)
        (pointing satellite10 Planet159)
        (supports instrument22 infrared1)
        (supports instrument22 thermograph2)
        (calibration_target instrument22 Star3)
        (on_board instrument22 satellite11)
        (power_avail satellite11)
        (pointing satellite11 Star12)
        (supports instrument23 infrared3)
        (supports instrument23 infrared1)
        (calibration_target instrument23 Star3)
        (supports instrument24 infrared0)
        (calibration_target instrument24 Star0)
        (on_board instrument23 satellite12)
        (on_board instrument24 satellite12)
        (power_avail satellite12)
        (pointing satellite12 Phenomenon57)
        (supports instrument25 infrared3)
        (supports instrument25 infrared0)
        (supports instrument25 infrared1)
        (calibration_target instrument25 Star0)
        (supports instrument26 infrared0)
        (calibration_target instrument26 Star3)
        (on_board instrument25 satellite13)
        (on_board instrument26 satellite13)
        (power_avail satellite13)
        (pointing satellite13 Planet84)
        (supports instrument27 thermograph2)
        (supports instrument27 spectrograph4)
        (supports instrument27 infrared1)
        (calibration_target instrument27 Star2)
        (supports instrument28 infrared0)
        (calibration_target instrument28 GroundStation1)
        (supports instrument29 thermograph2)
        (supports instrument29 spectrograph4)
        (calibration_target instrument29 Star3)
        (on_board instrument27 satellite14)
        (on_board instrument28 satellite14)
        (on_board instrument29 satellite14)
        (power_avail satellite14)
        (pointing satellite14 Phenomenon197)
    )
)
