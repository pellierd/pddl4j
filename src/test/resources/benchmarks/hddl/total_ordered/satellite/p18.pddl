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

(define (problem strips-sat-x-1)

    (:domain satellite)

    (:objects
        satellite0 - satellite
        instrument0 - instrument
        satellite1 - satellite
        instrument1 - instrument
        satellite2 - satellite
        instrument2 - instrument
        satellite3 - satellite
        instrument3 - instrument
        satellite4 - satellite
        instrument4 - instrument
        instrument5 - instrument
        instrument6 - instrument
        thermograph0 - mode
        image1 - mode
        thermograph4 - mode
        thermograph3 - mode
        image2 - mode
        GroundStation2 - direction
        GroundStation0 - direction
        GroundStation3 - direction
        GroundStation1 - direction
        GroundStation4 - direction
        Phenomenon5 - direction
        Phenomenon6 - direction
        Phenomenon7 - direction
        Planet8 - direction
        Star9 - direction
        Star10 - direction
        Phenomenon11 - direction
        Phenomenon12 - direction
        Phenomenon13 - direction
        Star14 - direction
        Planet15 - direction
        Planet16 - direction
        Planet17 - direction
        Phenomenon18 - direction
        Star19 - direction
        Star20 - direction
        Planet21 - direction
        Star22 - direction
        Planet23 - direction
        Star24 - direction
        Planet25 - direction
        Phenomenon26 - direction
        Planet27 - direction
        Phenomenon28 - direction
        Planet29 - direction
        Star30 - direction
        Phenomenon31 - direction
        Star32 - direction
        Planet33 - direction
        Phenomenon34 - direction
        Star35 - direction
        Planet36 - direction
        Star37 - direction
        Phenomenon38 - direction
        Planet39 - direction
        Star40 - direction
        Planet41 - direction
        Phenomenon42 - direction
        Phenomenon43 - direction
        Phenomenon44 - direction
        Planet45 - direction
        Star46 - direction
        Planet47 - direction
        Star48 - direction
        Phenomenon49 - direction
        Phenomenon50 - direction
        Star51 - direction
        Star52 - direction
        Star53 - direction
        Phenomenon54 - direction
        Star55 - direction
        Phenomenon56 - direction
        Star57 - direction
        Phenomenon58 - direction
        Star59 - direction
        Phenomenon60 - direction
        Phenomenon61 - direction
        Phenomenon62 - direction
        Star63 - direction
        Phenomenon64 - direction
        Planet65 - direction
        Planet66 - direction
        Planet67 - direction
        Planet68 - direction
        Star69 - direction
        Phenomenon70 - direction
        Star71 - direction
        Star72 - direction
        Phenomenon73 - direction
        Star74 - direction
        Star75 - direction
        Planet76 - direction
        Planet77 - direction
        Star78 - direction
        Phenomenon79 - direction
        Star80 - direction
        Planet81 - direction
        Planet82 - direction
        Phenomenon83 - direction
        Phenomenon84 - direction
        Planet85 - direction
        Phenomenon86 - direction
        Star87 - direction
        Phenomenon88 - direction
        Planet89 - direction
        Planet90 - direction
        Star91 - direction
        Phenomenon92 - direction
        Planet93 - direction
        Planet94 - direction
        Planet95 - direction
        Planet96 - direction
        Phenomenon97 - direction
        Star98 - direction
        Star99 - direction
        Phenomenon100 - direction
        Phenomenon101 - direction
        Planet102 - direction
        Planet103 - direction
        Phenomenon104 - direction
        Planet105 - direction
        Star106 - direction
        Phenomenon107 - direction
        Star108 - direction
        Planet109 - direction
        Planet110 - direction
        Planet111 - direction
        Planet112 - direction
        Phenomenon113 - direction
        Phenomenon114 - direction
        Phenomenon115 - direction
        Star116 - direction
        Star117 - direction
        Star118 - direction
        Planet119 - direction
        Phenomenon120 - direction
        Planet121 - direction
        Planet122 - direction
        Star123 - direction
        Star124 - direction
        Phenomenon125 - direction
        Planet126 - direction
        Planet127 - direction
        Planet128 - direction
        Phenomenon129 - direction
        Star130 - direction
        Phenomenon131 - direction
        Star132 - direction
        Planet133 - direction
        Phenomenon134 - direction
        Phenomenon135 - direction
        Star136 - direction
        Planet137 - direction
        Planet138 - direction
        Planet139 - direction
        Phenomenon140 - direction
        Phenomenon141 - direction
        Star142 - direction
        Star143 - direction
        Planet144 - direction
        Phenomenon145 - direction
        Phenomenon146 - direction
        Phenomenon147 - direction
        Star148 - direction
        Star149 - direction
        Phenomenon150 - direction
        Planet151 - direction
        Planet152 - direction
        Phenomenon153 - direction
        Star154 - direction
        Planet155 - direction
        Planet156 - direction
        Planet157 - direction
        Planet158 - direction
        Star159 - direction
        Phenomenon160 - direction
        Planet161 - direction
        Phenomenon162 - direction
        Phenomenon163 - direction
        Phenomenon164 - direction
        Planet165 - direction
        Planet166 - direction
        Planet167 - direction
        Star168 - direction
        Phenomenon169 - direction
        Star170 - direction
        Phenomenon171 - direction
        Phenomenon172 - direction
        Planet173 - direction
        Phenomenon174 - direction
        Planet175 - direction
        Star176 - direction
        Phenomenon177 - direction
        Planet178 - direction
        Planet179 - direction
        Planet180 - direction
        Star181 - direction
        Planet182 - direction
        Star183 - direction
        Phenomenon184 - direction
        Star185 - direction
        Star186 - direction
        Phenomenon187 - direction
        Phenomenon188 - direction
        Star189 - direction
        Star190 - direction
        Star191 - direction
        Star192 - direction
        Phenomenon193 - direction
        Star194 - direction
        Star195 - direction
        Planet196 - direction
        Star197 - direction
        Phenomenon198 - direction
        Phenomenon199 - direction
        Phenomenon200 - direction
        Planet201 - direction
        Star202 - direction
        Planet203 - direction
        Phenomenon204 - direction
    )

    (:htn
        :ordered-subtasks (and
            (t1   (do_mission Phenomenon5 image1) )
            (t2   (do_mission Planet8 image2) )
            (t3   (do_mission Star10 thermograph3) )
            (t4   (do_mission Phenomenon13 image1) )
            (t5   (do_mission Star14 thermograph4) )
            (t6   (do_mission Planet15 image2) )
            (t7   (do_mission Planet17 image2) )
            (t8   (do_mission Phenomenon18 image1) )
            (t9   (do_mission Star19 thermograph4) )
            (t10  (do_mission Star20 thermograph4) )
            (t11  (do_mission Star22 thermograph3) )
            (t12  (do_mission Planet23 image1) )
            (t13  (do_mission Phenomenon28 thermograph3) )
            (t14  (do_mission Star30 thermograph3) )
            (t15  (do_mission Phenomenon31 thermograph4) )
            (t16  (do_mission Star32 image2) )
            (t17  (do_mission Planet33 thermograph3) )
            (t18  (do_mission Phenomenon34 image2) )
            (t19  (do_mission Phenomenon38 image2) )
            (t20  (do_mission Planet39 image2) )
            (t21  (do_mission Star40 image2) )
            (t22  (do_mission Planet41 image1) )
            (t23  (do_mission Phenomenon42 thermograph3) )
            (t24  (do_mission Phenomenon43 thermograph3) )
            (t25  (do_mission Phenomenon44 thermograph4) )
            (t26  (do_mission Star46 image1) )
            (t27  (do_mission Planet47 image1) )
            (t28  (do_mission Star48 image1) )
            (t29  (do_mission Phenomenon49 image1) )
            (t30  (do_mission Star52 thermograph3) )
            (t31  (do_mission Star53 thermograph3) )
            (t32  (do_mission Phenomenon54 thermograph3) )
            (t33  (do_mission Star55 image1) )
            (t34  (do_mission Phenomenon56 image2) )
            (t35  (do_mission Star57 image2) )
            (t36  (do_mission Phenomenon58 thermograph3) )
            (t37  (do_mission Star59 thermograph4) )
            (t38  (do_mission Phenomenon61 image2) )
            (t39  (do_mission Star63 image1) )
            (t40  (do_mission Phenomenon64 thermograph3) )
            (t41  (do_mission Planet65 thermograph4) )
            (t42  (do_mission Planet66 thermograph3) )
            (t43  (do_mission Planet67 thermograph3) )
            (t44  (do_mission Star69 thermograph4) )
            (t45  (do_mission Phenomenon70 thermograph3) )
            (t46  (do_mission Star72 image2) )
            (t47  (do_mission Star74 thermograph3) )
            (t48  (do_mission Planet76 thermograph3) )
            (t49  (do_mission Planet77 thermograph3) )
            (t50  (do_mission Star78 thermograph4) )
            (t51  (do_mission Phenomenon79 image1) )
            (t52  (do_mission Planet81 image1) )
            (t53  (do_mission Planet85 image2) )
            (t54  (do_mission Phenomenon86 image2) )
            (t55  (do_mission Star87 thermograph3) )
            (t56  (do_mission Planet90 thermograph4) )
            (t57  (do_mission Planet93 image1) )
            (t58  (do_mission Planet94 image2) )
            (t59  (do_mission Phenomenon97 image2) )
            (t60  (do_mission Star98 thermograph3) )
            (t61  (do_mission Star99 thermograph3) )
            (t62  (do_mission Phenomenon100 thermograph3) )
            (t63  (do_mission Phenomenon101 image1) )
            (t64  (do_mission Planet102 thermograph3) )
            (t65  (do_mission Planet103 thermograph3) )
            (t66  (do_mission Phenomenon104 thermograph3) )
            (t67  (do_mission Planet105 image2) )
            (t68  (do_mission Star106 thermograph3) )
            (t69  (do_mission Star108 thermograph4) )
            (t70  (do_mission Planet109 thermograph3) )
            (t71  (do_mission Planet112 thermograph4) )
            (t72  (do_mission Phenomenon113 image1) )
            (t73  (do_mission Phenomenon114 image2) )
            (t74  (do_mission Phenomenon115 image2) )
            (t75  (do_mission Star118 image2) )
            (t76  (do_mission Planet119 image2) )
            (t77  (do_mission Phenomenon120 thermograph4) )
            (t78  (do_mission Planet121 image2) )
            (t79  (do_mission Planet122 image2) )
            (t80  (do_mission Star123 thermograph4) )
            (t81  (do_mission Star124 thermograph3) )
            (t82  (do_mission Phenomenon125 image2) )
            (t83  (do_mission Planet127 thermograph4) )
            (t84  (do_mission Planet128 image2) )
            (t85  (do_mission Star130 thermograph4) )
            (t86  (do_mission Star132 thermograph3) )
            (t87  (do_mission Planet133 image1) )
            (t88  (do_mission Phenomenon134 image2) )
            (t89  (do_mission Phenomenon135 thermograph4) )
            (t90  (do_mission Star136 image1) )
            (t91  (do_mission Planet137 image2) )
            (t92  (do_mission Planet138 thermograph4) )
            (t93  (do_mission Planet139 image1) )
            (t94  (do_mission Phenomenon140 thermograph3) )
            (t95  (do_mission Star142 thermograph4) )
            (t96  (do_mission Planet144 image2) )
            (t97  (do_mission Phenomenon145 image1) )
            (t98  (do_mission Phenomenon146 thermograph4) )
            (t99  (do_mission Star148 image2) )
            (t100 (do_mission Star149 image1) )
            (t101 (do_mission Phenomenon150 thermograph4) )
            (t102 (do_mission Planet151 image1) )
            (t103 (do_mission Planet152 thermograph3) )
            (t104 (do_mission Phenomenon153 thermograph3) )
            (t105 (do_mission Star154 thermograph3) )
            (t106 (do_mission Planet155 image2) )
            (t107 (do_mission Planet156 image2) )
            (t108 (do_mission Star159 thermograph3) )
            (t109 (do_mission Phenomenon160 thermograph4) )
            (t110 (do_mission Planet161 thermograph3) )
            (t111 (do_mission Phenomenon163 thermograph3) )
            (t112 (do_mission Phenomenon164 thermograph3) )
            (t113 (do_mission Planet165 thermograph3) )
            (t114 (do_mission Planet166 image2) )
            (t115 (do_mission Star168 image1) )
            (t116 (do_mission Phenomenon169 image1) )
            (t117 (do_mission Phenomenon171 image1) )
            (t118 (do_mission Phenomenon172 thermograph4) )
            (t119 (do_mission Planet173 image2) )
            (t120 (do_mission Planet175 image2) )
            (t121 (do_mission Star176 image2) )
            (t122 (do_mission Planet179 thermograph4) )
            (t123 (do_mission Star181 image1) )
            (t124 (do_mission Star183 thermograph4) )
            (t125 (do_mission Star185 thermograph4) )
            (t126 (do_mission Phenomenon187 thermograph3) )
            (t127 (do_mission Phenomenon188 image1) )
            (t128 (do_mission Star189 image1) )
            (t129 (do_mission Star190 image1) )
            (t130 (do_mission Star191 image1) )
            (t131 (do_mission Star192 thermograph4) )
            (t132 (do_mission Phenomenon193 image2) )
            (t133 (do_mission Star194 thermograph4) )
            (t134 (do_mission Phenomenon198 thermograph3) )
            (t135 (do_mission Phenomenon199 thermograph3) )
            (t136 (do_mission Phenomenon200 thermograph4) )
            (t137 (do_mission Planet201 thermograph3) )
            (t138 (do_mission Star202 image2) )
            (t139 (do_mission Planet203 image1) )
            (t140 (do_mission Phenomenon204 image1) )
            (t141 (do_turning satellite2 Phenomenon115) )
         )
    )

    (:init
        (supports instrument0 thermograph3)
        (supports instrument0 image1)
        (calibration_target instrument0 GroundStation4)
        (on_board instrument0 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Star19)
        (supports instrument1 thermograph4)
        (calibration_target instrument1 GroundStation1)
        (on_board instrument1 satellite1)
        (power_avail satellite1)
        (pointing satellite1 Phenomenon200)
        (supports instrument2 image2)
        (calibration_target instrument2 GroundStation0)
        (on_board instrument2 satellite2)
        (power_avail satellite2)
        (pointing satellite2 Planet196)
        (supports instrument3 image2)
        (supports instrument3 image1)
        (supports instrument3 thermograph4)
        (calibration_target instrument3 GroundStation4)
        (on_board instrument3 satellite3)
        (power_avail satellite3)
        (pointing satellite3 Phenomenon86)
        (supports instrument4 thermograph4)
        (calibration_target instrument4 GroundStation3)
        (supports instrument5 image1)
        (supports instrument5 thermograph4)
        (calibration_target instrument5 GroundStation1)
        (supports instrument6 image2)
        (supports instrument6 thermograph3)
        (supports instrument6 thermograph4)
        (calibration_target instrument6 GroundStation4)
        (on_board instrument4 satellite4)
        (on_board instrument5 satellite4)
        (on_board instrument6 satellite4)
        (power_avail satellite4)
        (pointing satellite4 Star142)
    )
)