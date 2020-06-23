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

(define (problem p19)

    (:domain satellite)

    (:objects
        satellite0 - satellite
        instrument0 - instrument
        instrument1 - instrument
        satellite1 - satellite
        instrument2 - instrument
        satellite2 - satellite
        instrument3 - instrument
        satellite3 - satellite
        instrument4 - instrument
        instrument5 - instrument
        instrument6 - instrument
        satellite4 - satellite
        instrument7 - instrument
        instrument8 - instrument
        instrument9 - instrument
        satellite5 - satellite
        instrument10 - instrument
        satellite6 - satellite
        instrument11 - instrument
        instrument12 - instrument
        instrument13 - instrument
        satellite7 - satellite
        instrument14 - instrument
        instrument15 - instrument
        infrared0 - mode
        thermograph3 - mode
        spectrograph2 - mode
        image1 - mode
        thermograph4 - mode
        Star1 - direction
        GroundStation0 - direction
        Star3 - direction
        Star4 - direction
        GroundStation2 - direction
        Phenomenon5 - direction
        Planet6 - direction
        Planet7 - direction
        Star8 - direction
        Phenomenon9 - direction
        Phenomenon10 - direction
        Planet11 - direction
        Star12 - direction
        Star13 - direction
        Planet14 - direction
        Star15 - direction
        Phenomenon16 - direction
        Planet17 - direction
        Star18 - direction
        Star19 - direction
        Planet20 - direction
        Planet21 - direction
        Planet22 - direction
        Planet23 - direction
        Planet24 - direction
        Phenomenon25 - direction
        Planet26 - direction
        Phenomenon27 - direction
        Phenomenon28 - direction
        Planet29 - direction
        Planet30 - direction
        Phenomenon31 - direction
        Planet32 - direction
        Planet33 - direction
        Star34 - direction
        Phenomenon35 - direction
        Phenomenon36 - direction
        Planet37 - direction
        Phenomenon38 - direction
        Star39 - direction
        Planet40 - direction
        Star41 - direction
        Phenomenon42 - direction
        Phenomenon43 - direction
        Planet44 - direction
        Star45 - direction
        Planet46 - direction
        Planet47 - direction
        Star48 - direction
        Planet49 - direction
        Star50 - direction
        Star51 - direction
        Star52 - direction
        Planet53 - direction
        Planet54 - direction
        Phenomenon55 - direction
        Planet56 - direction
        Phenomenon57 - direction
        Phenomenon58 - direction
        Planet59 - direction
        Star60 - direction
        Planet61 - direction
        Star62 - direction
        Star63 - direction
        Star64 - direction
        Phenomenon65 - direction
        Star66 - direction
        Phenomenon67 - direction
        Phenomenon68 - direction
        Star69 - direction
        Planet70 - direction
        Phenomenon71 - direction
        Phenomenon72 - direction
        Star73 - direction
        Phenomenon74 - direction
        Planet75 - direction
        Star76 - direction
        Planet77 - direction
        Planet78 - direction
        Planet79 - direction
        Planet80 - direction
        Planet81 - direction
        Star82 - direction
        Planet83 - direction
        Phenomenon84 - direction
        Planet85 - direction
        Phenomenon86 - direction
        Phenomenon87 - direction
        Planet88 - direction
        Planet89 - direction
        Star90 - direction
        Phenomenon91 - direction
        Planet92 - direction
        Planet93 - direction
        Planet94 - direction
        Star95 - direction
        Phenomenon96 - direction
        Planet97 - direction
        Planet98 - direction
        Planet99 - direction
        Phenomenon100 - direction
        Planet101 - direction
        Star102 - direction
        Star103 - direction
        Phenomenon104 - direction
        Planet105 - direction
        Star106 - direction
        Star107 - direction
        Star108 - direction
        Star109 - direction
        Phenomenon110 - direction
        Star111 - direction
        Star112 - direction
        Star113 - direction
        Star114 - direction
        Phenomenon115 - direction
        Planet116 - direction
        Phenomenon117 - direction
        Planet118 - direction
        Planet119 - direction
        Star120 - direction
        Phenomenon121 - direction
        Planet122 - direction
        Phenomenon123 - direction
        Phenomenon124 - direction
        Planet125 - direction
        Star126 - direction
        Planet127 - direction
        Phenomenon128 - direction
        Star129 - direction
        Star130 - direction
        Phenomenon131 - direction
        Star132 - direction
        Star133 - direction
        Planet134 - direction
        Planet135 - direction
        Star136 - direction
        Phenomenon137 - direction
        Planet138 - direction
        Planet139 - direction
        Phenomenon140 - direction
        Planet141 - direction
        Phenomenon142 - direction
        Planet143 - direction
        Star144 - direction
        Phenomenon145 - direction
        Phenomenon146 - direction
        Phenomenon147 - direction
        Planet148 - direction
        Phenomenon149 - direction
        Planet150 - direction
        Star151 - direction
        Star152 - direction
        Phenomenon153 - direction
        Planet154 - direction
        Star155 - direction
        Star156 - direction
        Phenomenon157 - direction
        Phenomenon158 - direction
        Planet159 - direction
        Planet160 - direction
        Planet161 - direction
        Star162 - direction
        Planet163 - direction
        Planet164 - direction
        Star165 - direction
        Phenomenon166 - direction
        Star167 - direction
        Star168 - direction
        Star169 - direction
        Planet170 - direction
        Planet171 - direction
        Star172 - direction
        Planet173 - direction
        Planet174 - direction
        Phenomenon175 - direction
        Phenomenon176 - direction
        Star177 - direction
        Planet178 - direction
        Planet179 - direction
        Phenomenon180 - direction
        Star181 - direction
        Star182 - direction
        Phenomenon183 - direction
        Star184 - direction
        Star185 - direction
        Phenomenon186 - direction
        Planet187 - direction
        Star188 - direction
        Star189 - direction
        Phenomenon190 - direction
        Planet191 - direction
        Star192 - direction
        Phenomenon193 - direction
        Planet194 - direction
        Phenomenon195 - direction
        Star196 - direction
        Planet197 - direction
        Planet198 - direction
        Planet199 - direction
        Phenomenon200 - direction
        Phenomenon201 - direction
        Star202 - direction
        Phenomenon203 - direction
        Star204 - direction
    )

    (:htn
        :ordered-subtasks (and
            (t1   (do_mission Phenomenon5 spectrograph2) )
            (t2   (do_mission Planet6 spectrograph2) )
            (t3   (do_mission Planet7 infrared0) )
            (t4   (do_mission Phenomenon9 infrared0) )
            (t5   (do_mission Phenomenon10 image1) )
            (t6   (do_mission Planet11 image1) )
            (t7   (do_mission Star12 thermograph3) )
            (t8   (do_mission Star13 thermograph3) )
            (t9   (do_mission Planet14 thermograph4) )
            (t10  (do_mission Star15 thermograph4) )
            (t11  (do_mission Phenomenon16 image1) )
            (t12  (do_mission Planet17 thermograph3) )
            (t13  (do_mission Star18 image1) )
            (t14  (do_mission Planet20 image1) )
            (t15  (do_mission Planet21 infrared0) )
            (t16  (do_mission Planet22 image1) )
            (t17  (do_mission Planet23 thermograph3) )
            (t18  (do_mission Planet24 infrared0) )
            (t19  (do_mission Phenomenon25 thermograph4) )
            (t20  (do_mission Planet26 thermograph4) )
            (t21  (do_mission Phenomenon27 spectrograph2) )
            (t22  (do_mission Phenomenon28 infrared0) )
            (t23  (do_mission Planet29 infrared0) )
            (t24  (do_mission Planet30 thermograph4) )
            (t25  (do_mission Phenomenon31 image1) )
            (t26  (do_mission Planet32 spectrograph2) )
            (t27  (do_mission Planet33 spectrograph2) )
            (t28  (do_mission Star34 thermograph4) )
            (t29  (do_mission Phenomenon35 thermograph3) )
            (t30  (do_mission Phenomenon36 image1) )
            (t31  (do_mission Phenomenon38 image1) )
            (t32  (do_mission Star39 thermograph3) )
            (t33  (do_mission Planet40 thermograph4) )
            (t34  (do_mission Star41 thermograph3) )
            (t35  (do_mission Phenomenon42 infrared0) )
            (t36  (do_mission Phenomenon43 thermograph4) )
            (t37  (do_mission Planet44 infrared0) )
            (t38  (do_mission Planet46 infrared0) )
            (t39  (do_mission Planet47 infrared0) )
            (t40  (do_mission Star48 thermograph4) )
            (t41  (do_mission Planet49 infrared0) )
            (t42  (do_mission Star50 spectrograph2) )
            (t43  (do_mission Star51 spectrograph2) )
            (t44  (do_mission Star52 spectrograph2) )
            (t45  (do_mission Planet53 image1) )
            (t46  (do_mission Planet54 thermograph3) )
            (t47  (do_mission Phenomenon55 thermograph4) )
            (t48  (do_mission Planet56 thermograph3) )
            (t49  (do_mission Phenomenon58 thermograph4) )
            (t50  (do_mission Planet59 thermograph3) )
            (t51  (do_mission Planet61 thermograph4) )
            (t52  (do_mission Star62 thermograph3) )
            (t53  (do_mission Star63 infrared0) )
            (t54  (do_mission Star64 thermograph4) )
            (t55  (do_mission Phenomenon65 infrared0) )
            (t56  (do_mission Star66 thermograph3) )
            (t57  (do_mission Phenomenon67 thermograph3) )
            (t58  (do_mission Phenomenon68 infrared0) )
            (t59  (do_mission Star69 infrared0) )
            (t60  (do_mission Planet70 thermograph3) )
            (t61  (do_mission Phenomenon71 thermograph4) )
            (t62  (do_mission Phenomenon72 thermograph3) )
            (t63  (do_mission Star73 spectrograph2) )
            (t64  (do_mission Planet75 image1) )
            (t65  (do_mission Star76 spectrograph2) )
            (t66  (do_mission Planet77 spectrograph2) )
            (t67  (do_mission Planet78 thermograph4) )
            (t68  (do_mission Planet79 spectrograph2) )
            (t69  (do_mission Planet80 image1) )
            (t70  (do_mission Planet81 thermograph4) )
            (t71  (do_mission Star82 image1) )
            (t72  (do_mission Planet83 infrared0) )
            (t73  (do_mission Phenomenon84 image1) )
            (t74  (do_mission Planet85 thermograph3) )
            (t75  (do_mission Phenomenon86 thermograph3) )
            (t76  (do_mission Phenomenon87 spectrograph2) )
            (t77  (do_mission Planet89 infrared0) )
            (t78  (do_mission Star90 infrared0) )
            (t79  (do_mission Phenomenon91 infrared0) )
            (t80  (do_mission Planet92 infrared0) )
            (t81  (do_mission Planet93 spectrograph2) )
            (t82  (do_mission Planet94 infrared0) )
            (t83  (do_mission Star95 image1) )
            (t84  (do_mission Phenomenon96 infrared0) )
            (t85  (do_mission Planet97 infrared0) )
            (t86  (do_mission Planet98 thermograph4) )
            (t87  (do_mission Planet99 image1) )
            (t88  (do_mission Phenomenon100 infrared0) )
            (t89  (do_mission Planet101 infrared0) )
            (t90  (do_mission Star102 spectrograph2) )
            (t91  (do_mission Star103 thermograph4) )
            (t92  (do_mission Phenomenon104 image1) )
            (t93  (do_mission Planet105 thermograph4) )
            (t94  (do_mission Star106 spectrograph2) )
            (t95  (do_mission Star107 infrared0) )
            (t96  (do_mission Star108 thermograph4) )
            (t97  (do_mission Star109 infrared0) )
            (t98  (do_mission Phenomenon110 spectrograph2) )
            (t99  (do_mission Star111 image1) )
            (t100 (do_mission Star112 thermograph3) )
            (t101 (do_mission Star114 spectrograph2) )
            (t102 (do_mission Phenomenon115 spectrograph2) )
            (t103 (do_mission Planet116 spectrograph2) )
            (t104 (do_mission Phenomenon117 spectrograph2) )
            (t105 (do_mission Planet118 image1) )
            (t106 (do_mission Planet119 thermograph3) )
            (t107 (do_mission Star120 infrared0) )
            (t108 (do_mission Phenomenon121 thermograph3) )
            (t109 (do_mission Planet122 infrared0) )
            (t110 (do_mission Phenomenon123 thermograph3) )
            (t111 (do_mission Phenomenon124 spectrograph2) )
            (t112 (do_mission Planet125 thermograph3) )
            (t113 (do_mission Star126 thermograph3) )
            (t114 (do_mission Planet127 spectrograph2) )
            (t115 (do_mission Phenomenon128 image1) )
            (t116 (do_mission Star129 spectrograph2) )
            (t117 (do_mission Star130 infrared0) )
            (t118 (do_mission Phenomenon131 infrared0) )
            (t119 (do_mission Star132 spectrograph2) )
            (t120 (do_mission Star133 thermograph4) )
            (t121 (do_mission Planet135 image1) )
            (t122 (do_mission Planet138 thermograph3) )
            (t123 (do_mission Planet139 thermograph4) )
            (t124 (do_mission Phenomenon140 infrared0) )
            (t125 (do_mission Planet141 thermograph3) )
            (t126 (do_mission Phenomenon142 spectrograph2) )
            (t127 (do_mission Planet143 thermograph4) )
            (t128 (do_mission Star144 thermograph4) )
            (t129 (do_mission Phenomenon145 image1) )
            (t130 (do_mission Phenomenon146 infrared0) )
            (t131 (do_mission Phenomenon147 spectrograph2) )
            (t132 (do_mission Planet148 spectrograph2) )
            (t133 (do_mission Phenomenon149 thermograph4) )
            (t134 (do_mission Star151 thermograph4) )
            (t135 (do_mission Star152 thermograph3) )
            (t136 (do_mission Phenomenon153 spectrograph2) )
            (t137 (do_mission Planet154 thermograph4) )
            (t138 (do_mission Star155 spectrograph2) )
            (t139 (do_mission Star156 spectrograph2) )
            (t140 (do_mission Phenomenon157 thermograph3) )
            (t141 (do_mission Phenomenon158 spectrograph2) )
            (t142 (do_mission Planet159 infrared0) )
            (t143 (do_mission Planet160 image1) )
            (t144 (do_mission Planet161 image1) )
            (t145 (do_mission Star162 spectrograph2) )
            (t146 (do_mission Planet163 spectrograph2) )
            (t147 (do_mission Planet164 spectrograph2) )
            (t148 (do_mission Star165 infrared0) )
            (t149 (do_mission Phenomenon166 spectrograph2) )
            (t150 (do_mission Star167 image1) )
            (t151 (do_mission Star168 infrared0) )
            (t152 (do_mission Star169 spectrograph2) )
            (t153 (do_mission Planet170 thermograph4) )
            (t154 (do_mission Planet171 spectrograph2) )
            (t155 (do_mission Star172 thermograph4) )
            (t156 (do_mission Planet173 thermograph3) )
            (t157 (do_mission Planet174 thermograph3) )
            (t158 (do_mission Phenomenon175 infrared0) )
            (t159 (do_mission Phenomenon176 spectrograph2) )
            (t160 (do_mission Star177 infrared0) )
            (t161 (do_mission Planet178 spectrograph2) )
            (t162 (do_mission Planet179 spectrograph2) )
            (t163 (do_mission Star181 image1) )
            (t164 (do_mission Star182 thermograph4) )
            (t165 (do_mission Phenomenon183 thermograph3) )
            (t166 (do_mission Star184 spectrograph2) )
            (t167 (do_mission Star185 thermograph3) )
            (t168 (do_mission Phenomenon186 image1) )
            (t169 (do_mission Planet187 infrared0) )
            (t170 (do_mission Star188 image1) )
            (t171 (do_mission Star189 spectrograph2) )
            (t172 (do_mission Phenomenon190 infrared0) )
            (t173 (do_mission Planet191 spectrograph2) )
            (t174 (do_mission Star192 thermograph4) )
            (t175 (do_mission Phenomenon193 thermograph3) )
            (t176 (do_mission Planet194 thermograph4) )
            (t177 (do_mission Phenomenon195 thermograph4) )
            (t178 (do_mission Planet197 infrared0) )
            (t179 (do_mission Planet198 image1) )
            (t180 (do_mission Planet199 spectrograph2) )
            (t181 (do_mission Phenomenon200 spectrograph2) )
            (t182 (do_mission Phenomenon201 thermograph4) )
            (t183 (do_mission Star202 infrared0) )
            (t184 (do_mission Star204 infrared0) )
            (t185 (do_turning satellite1 Star45) )
            (t186 (do_turning satellite2 Planet101) )
            (t187 (do_turning satellite4 Phenomenon183) )
         )
    )

    (:init
        (supports instrument0 thermograph4)
        (supports instrument0 spectrograph2)
        (calibration_target instrument0 Star4)
        (supports instrument1 thermograph3)
        (supports instrument1 thermograph4)
        (supports instrument1 spectrograph2)
        (calibration_target instrument1 Star1)
        (on_board instrument0 satellite0)
        (on_board instrument1 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Phenomenon183)
        (supports instrument2 infrared0)
        (supports instrument2 thermograph4)
        (calibration_target instrument2 Star1)
        (on_board instrument2 satellite1)
        (power_avail satellite1)
        (pointing satellite1 Phenomenon96)
        (supports instrument3 thermograph3)
        (supports instrument3 infrared0)
        (supports instrument3 spectrograph2)
        (calibration_target instrument3 Star1)
        (on_board instrument3 satellite2)
        (power_avail satellite2)
        (pointing satellite2 Phenomenon100)
        (supports instrument4 thermograph4)
        (supports instrument4 spectrograph2)
        (supports instrument4 thermograph3)
        (calibration_target instrument4 Star4)
        (supports instrument5 spectrograph2)
        (calibration_target instrument5 Star3)
        (supports instrument6 spectrograph2)
        (supports instrument6 image1)
        (supports instrument6 infrared0)
        (calibration_target instrument6 Star3)
        (on_board instrument4 satellite3)
        (on_board instrument5 satellite3)
        (on_board instrument6 satellite3)
        (power_avail satellite3)
        (pointing satellite3 Planet179)
        (supports instrument7 thermograph3)
        (supports instrument7 infrared0)
        (supports instrument7 spectrograph2)
        (calibration_target instrument7 GroundStation2)
        (supports instrument8 thermograph4)
        (supports instrument8 thermograph3)
        (calibration_target instrument8 Star4)
        (supports instrument9 infrared0)
        (supports instrument9 thermograph3)
        (supports instrument9 thermograph4)
        (calibration_target instrument9 Star3)
        (on_board instrument7 satellite4)
        (on_board instrument8 satellite4)
        (on_board instrument9 satellite4)
        (power_avail satellite4)
        (pointing satellite4 Planet46)
        (supports instrument10 thermograph4)
        (calibration_target instrument10 GroundStation0)
        (on_board instrument10 satellite5)
        (power_avail satellite5)
        (pointing satellite5 Star106)
        (supports instrument11 spectrograph2)
        (supports instrument11 thermograph4)
        (supports instrument11 thermograph3)
        (calibration_target instrument11 Star3)
        (supports instrument12 thermograph4)
        (supports instrument12 image1)
        (calibration_target instrument12 GroundStation0)
        (supports instrument13 spectrograph2)
        (supports instrument13 thermograph4)
        (calibration_target instrument13 Star3)
        (on_board instrument11 satellite6)
        (on_board instrument12 satellite6)
        (on_board instrument13 satellite6)
        (power_avail satellite6)
        (pointing satellite6 Star95)
        (supports instrument14 spectrograph2)
        (supports instrument14 thermograph3)
        (calibration_target instrument14 Star4)
        (supports instrument15 thermograph4)
        (supports instrument15 image1)
        (calibration_target instrument15 GroundStation2)
        (on_board instrument14 satellite7)
        (on_board instrument15 satellite7)
        (power_avail satellite7)
        (pointing satellite7 Star13)
    )
)
