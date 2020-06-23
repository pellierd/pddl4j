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

(define (problem p17)

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
        instrument6 - instrument
        instrument7 - instrument
        satellite3 - satellite
        instrument8 - instrument
        instrument9 - instrument
        satellite4 - satellite
        instrument10 - instrument
        instrument11 - instrument
        instrument12 - instrument
        satellite5 - satellite
        instrument13 - instrument
        instrument14 - instrument
        instrument15 - instrument
        satellite6 - satellite
        instrument16 - instrument
        satellite7 - satellite
        instrument17 - instrument
        instrument18 - instrument
        satellite8 - satellite
        instrument19 - instrument
        satellite9 - satellite
        instrument20 - instrument
        instrument21 - instrument
        instrument22 - instrument
        satellite10 - satellite
        instrument23 - instrument
        instrument24 - instrument
        satellite11 - satellite
        instrument25 - instrument
        instrument26 - instrument
        instrument27 - instrument
        satellite12 - satellite
        instrument28 - instrument
        instrument29 - instrument
        instrument30 - instrument
        satellite13 - satellite
        instrument31 - instrument
        instrument32 - instrument
        instrument33 - instrument
        satellite14 - satellite
        instrument34 - instrument
        image4 - mode
        image3 - mode
        thermograph0 - mode
        thermograph1 - mode
        thermograph2 - mode
        Star0 - direction
        GroundStation3 - direction
        GroundStation2 - direction
        Star4 - direction
        Star1 - direction
        Phenomenon5 - direction
        Planet6 - direction
        Planet7 - direction
        Planet8 - direction
        Planet9 - direction
        Planet10 - direction
        Planet11 - direction
        Phenomenon12 - direction
        Planet13 - direction
        Star14 - direction
        Planet15 - direction
        Planet16 - direction
        Planet17 - direction
        Phenomenon18 - direction
        Star19 - direction
        Planet20 - direction
        Star21 - direction
        Star22 - direction
        Planet23 - direction
        Planet24 - direction
        Planet25 - direction
        Star26 - direction
        Phenomenon27 - direction
        Planet28 - direction
        Planet29 - direction
        Phenomenon30 - direction
        Star31 - direction
        Phenomenon32 - direction
        Star33 - direction
        Phenomenon34 - direction
        Phenomenon35 - direction
        Phenomenon36 - direction
        Phenomenon37 - direction
        Planet38 - direction
        Star39 - direction
        Planet40 - direction
        Planet41 - direction
        Phenomenon42 - direction
        Star43 - direction
        Planet44 - direction
        Phenomenon45 - direction
        Phenomenon46 - direction
        Phenomenon47 - direction
        Planet48 - direction
        Planet49 - direction
        Phenomenon50 - direction
        Planet51 - direction
        Planet52 - direction
        Phenomenon53 - direction
        Star54 - direction
        Planet55 - direction
        Star56 - direction
        Star57 - direction
        Phenomenon58 - direction
        Phenomenon59 - direction
        Star60 - direction
        Planet61 - direction
        Planet62 - direction
        Planet63 - direction
        Planet64 - direction
        Phenomenon65 - direction
        Star66 - direction
        Star67 - direction
        Phenomenon68 - direction
        Phenomenon69 - direction
        Planet70 - direction
        Phenomenon71 - direction
        Star72 - direction
        Phenomenon73 - direction
        Planet74 - direction
        Planet75 - direction
        Phenomenon76 - direction
        Planet77 - direction
        Phenomenon78 - direction
        Planet79 - direction
        Planet80 - direction
        Star81 - direction
        Planet82 - direction
        Phenomenon83 - direction
        Star84 - direction
        Phenomenon85 - direction
        Star86 - direction
        Phenomenon87 - direction
        Phenomenon88 - direction
        Star89 - direction
        Phenomenon90 - direction
        Star91 - direction
        Star92 - direction
        Planet93 - direction
        Phenomenon94 - direction
        Star95 - direction
        Phenomenon96 - direction
        Planet97 - direction
        Planet98 - direction
        Phenomenon99 - direction
        Phenomenon100 - direction
        Planet101 - direction
        Planet102 - direction
        Phenomenon103 - direction
        Phenomenon104 - direction
        Phenomenon105 - direction
        Phenomenon106 - direction
        Planet107 - direction
        Phenomenon108 - direction
        Planet109 - direction
        Phenomenon110 - direction
        Planet111 - direction
        Planet112 - direction
        Phenomenon113 - direction
        Planet114 - direction
        Planet115 - direction
        Phenomenon116 - direction
        Phenomenon117 - direction
        Phenomenon118 - direction
        Star119 - direction
        Star120 - direction
        Star121 - direction
        Planet122 - direction
        Planet123 - direction
        Phenomenon124 - direction
        Planet125 - direction
        Planet126 - direction
        Planet127 - direction
        Planet128 - direction
        Star129 - direction
        Phenomenon130 - direction
        Star131 - direction
        Phenomenon132 - direction
        Star133 - direction
        Phenomenon134 - direction
        Planet135 - direction
        Star136 - direction
        Phenomenon137 - direction
        Star138 - direction
        Star139 - direction
        Planet140 - direction
        Planet141 - direction
        Phenomenon142 - direction
        Planet143 - direction
        Planet144 - direction
        Phenomenon145 - direction
        Star146 - direction
        Phenomenon147 - direction
        Planet148 - direction
        Star149 - direction
        Star150 - direction
        Phenomenon151 - direction
        Phenomenon152 - direction
        Planet153 - direction
        Star154 - direction
        Phenomenon155 - direction
        Planet156 - direction
        Phenomenon157 - direction
        Planet158 - direction
        Phenomenon159 - direction
        Phenomenon160 - direction
        Star161 - direction
        Star162 - direction
        Planet163 - direction
        Phenomenon164 - direction
        Phenomenon165 - direction
        Phenomenon166 - direction
        Star167 - direction
        Star168 - direction
        Planet169 - direction
        Phenomenon170 - direction
        Star171 - direction
        Planet172 - direction
        Planet173 - direction
        Planet174 - direction
        Star175 - direction
        Star176 - direction
        Star177 - direction
        Star178 - direction
        Planet179 - direction
        Phenomenon180 - direction
        Star181 - direction
        Planet182 - direction
        Phenomenon183 - direction
        Planet184 - direction
        Phenomenon185 - direction
        Star186 - direction
        Star187 - direction
        Star188 - direction
        Planet189 - direction
        Star190 - direction
        Planet191 - direction
        Star192 - direction
        Phenomenon193 - direction
        Phenomenon194 - direction
        Star195 - direction
        Planet196 - direction
        Star197 - direction
        Planet198 - direction
        Phenomenon199 - direction
        Planet200 - direction
        Phenomenon201 - direction
        Phenomenon202 - direction
        Phenomenon203 - direction
        Star204 - direction
        Planet205 - direction
        Planet206 - direction
        Planet207 - direction
        Star208 - direction
        Phenomenon209 - direction
        Phenomenon210 - direction
        Phenomenon211 - direction
        Star212 - direction
        Phenomenon213 - direction
        Phenomenon214 - direction
        Phenomenon215 - direction
        Phenomenon216 - direction
        Star217 - direction
        Phenomenon218 - direction
        Star219 - direction
        Star220 - direction
        Phenomenon221 - direction
        Phenomenon222 - direction
        Phenomenon223 - direction
        Star224 - direction
        Phenomenon225 - direction
        Phenomenon226 - direction
        Phenomenon227 - direction
        Phenomenon228 - direction
        Planet229 - direction
        Star230 - direction
        Phenomenon231 - direction
        Planet232 - direction
        Phenomenon233 - direction
        Phenomenon234 - direction
        Star235 - direction
        Planet236 - direction
        Phenomenon237 - direction
        Phenomenon238 - direction
        Star239 - direction
        Planet240 - direction
        Phenomenon241 - direction
        Planet242 - direction
        Star243 - direction
        Planet244 - direction
        Planet245 - direction
        Phenomenon246 - direction
        Star247 - direction
        Phenomenon248 - direction
        Phenomenon249 - direction
        Phenomenon250 - direction
        Star251 - direction
        Star252 - direction
        Star253 - direction
        Planet254 - direction
    )

    (:htn
        :ordered-subtasks (and
            (t1   (do_mission  Phenomenon5 thermograph1) )
            (t2   (do_mission  Planet6 image4) )
            (t3   (do_mission  Planet7 image3) )
            (t4   (do_mission  Planet8 image3) )
            (t5   (do_mission  Planet9 thermograph0) )
            (t6   (do_mission  Planet10 thermograph1) )
            (t7   (do_mission  Planet11 thermograph2) )
            (t8   (do_mission  Phenomenon12 image3) )
            (t9   (do_mission  Planet13 thermograph1) )
            (t10  (do_mission  Star14 image3) )
            (t11  (do_mission  Planet15 thermograph0) )
            (t12  (do_mission  Planet16 image3) )
            (t13  (do_mission  Planet17 image4) )
            (t14  (do_mission  Phenomenon18 image3) )
            (t15  (do_mission  Star19 thermograph0) )
            (t16  (do_mission  Star21 thermograph1) )
            (t17  (do_mission  Star22 image4) )
            (t18  (do_mission  Planet23 thermograph1) )
            (t19  (do_mission  Planet24 thermograph2) )
            (t20  (do_mission  Planet25 thermograph1) )
            (t21  (do_mission  Star26 thermograph0) )
            (t22  (do_mission  Phenomenon27 thermograph1) )
            (t23  (do_mission  Planet28 thermograph2) )
            (t24  (do_mission  Planet29 thermograph0) )
            (t25  (do_mission  Star31 thermograph2) )
            (t26  (do_mission  Phenomenon32 thermograph0) )
            (t27  (do_mission  Star33 image3) )
            (t28  (do_mission  Phenomenon35 thermograph1) )
            (t29  (do_mission  Phenomenon36 thermograph2) )
            (t30  (do_mission  Phenomenon37 thermograph2) )
            (t31  (do_mission  Planet38 image3) )
            (t32  (do_mission  Star39 thermograph1) )
            (t33  (do_mission  Planet40 image4) )
            (t34  (do_mission  Phenomenon42 thermograph1) )
            (t35  (do_mission  Star43 image3) )
            (t36  (do_mission  Phenomenon45 thermograph0) )
            (t37  (do_mission  Phenomenon46 thermograph0) )
            (t38  (do_mission  Phenomenon47 thermograph1) )
            (t39  (do_mission  Planet48 image3) )
            (t40  (do_mission  Planet49 image4) )
            (t41  (do_mission  Phenomenon50 image4) )
            (t42  (do_mission  Planet51 thermograph1) )
            (t43  (do_mission  Planet52 thermograph0) )
            (t44  (do_mission  Phenomenon53 image4) )
            (t45  (do_mission  Star54 thermograph2) )
            (t46  (do_mission  Planet55 thermograph0) )
            (t47  (do_mission  Star56 thermograph2) )
            (t48  (do_mission  Star57 thermograph0) )
            (t49  (do_mission  Phenomenon58 thermograph2) )
            (t50  (do_mission  Phenomenon59 image4) )
            (t51  (do_mission  Star60 thermograph2) )
            (t52  (do_mission  Planet61 thermograph2) )
            (t53  (do_mission  Planet62 thermograph0) )
            (t54  (do_mission  Planet63 image4) )
            (t55  (do_mission  Planet64 thermograph2) )
            (t56  (do_mission  Phenomenon65 thermograph2) )
            (t57  (do_mission  Star66 thermograph1) )
            (t58  (do_mission  Star67 thermograph2) )
            (t59  (do_mission  Phenomenon68 thermograph2) )
            (t60  (do_mission  Planet70 thermograph2) )
            (t61  (do_mission  Phenomenon71 thermograph2) )
            (t62  (do_mission  Star72 thermograph1) )
            (t63  (do_mission  Phenomenon73 thermograph0) )
            (t64  (do_mission  Planet74 image3) )
            (t65  (do_mission  Planet75 image4) )
            (t66  (do_mission  Phenomenon76 thermograph0) )
            (t67  (do_mission  Planet77 image4) )
            (t68  (do_mission  Phenomenon78 image4) )
            (t69  (do_mission  Planet79 thermograph2) )
            (t70  (do_mission  Planet80 thermograph2) )
            (t71  (do_mission  Star81 thermograph2) )
            (t72  (do_mission  Planet82 thermograph1) )
            (t73  (do_mission  Phenomenon83 thermograph0) )
            (t74  (do_mission  Star84 image3) )
            (t75  (do_mission  Phenomenon85 image4) )
            (t76  (do_mission  Phenomenon88 thermograph0) )
            (t77  (do_mission  Star89 thermograph2) )
            (t78  (do_mission  Phenomenon90 thermograph0) )
            (t79  (do_mission  Star91 image4) )
            (t80  (do_mission  Star92 thermograph2) )
            (t81  (do_mission  Planet93 image4) )
            (t82  (do_mission  Phenomenon94 thermograph2) )
            (t83  (do_mission  Phenomenon96 image4) )
            (t84  (do_mission  Planet97 thermograph1) )
            (t85  (do_mission  Phenomenon99 thermograph2) )
            (t86  (do_mission  Phenomenon100 thermograph2) )
            (t87  (do_mission  Planet101 image4) )
            (t88  (do_mission  Planet102 thermograph0) )
            (t89  (do_mission  Phenomenon103 thermograph1) )
            (t90  (do_mission  Phenomenon104 image4) )
            (t91  (do_mission  Phenomenon105 image4) )
            (t92  (do_mission  Phenomenon106 thermograph1) )
            (t93  (do_mission  Planet107 image3) )
            (t94  (do_mission  Phenomenon108 thermograph0) )
            (t95  (do_mission  Planet109 image3) )
            (t96  (do_mission  Phenomenon110 thermograph0) )
            (t97  (do_mission  Planet111 thermograph2) )
            (t98  (do_mission  Planet112 thermograph2) )
            (t99  (do_mission  Phenomenon113 image3) )
            (t100 (do_mission  Planet115 thermograph1) )
            (t101 (do_mission  Phenomenon116 thermograph1) )
            (t102 (do_mission  Phenomenon117 thermograph1) )
            (t103 (do_mission  Phenomenon118 thermograph2) )
            (t104 (do_mission  Star119 image4) )
            (t105 (do_mission  Star120 thermograph2) )
            (t106 (do_mission  Star121 image4) )
            (t107 (do_mission  Planet123 image3) )
            (t108 (do_mission  Phenomenon124 thermograph2) )
            (t109 (do_mission  Planet125 image4) )
            (t110 (do_mission  Planet126 thermograph0) )
            (t111 (do_mission  Planet127 thermograph0) )
            (t112 (do_mission  Star129 thermograph0) )
            (t113 (do_mission  Phenomenon130 thermograph0) )
            (t114 (do_mission  Star131 thermograph2) )
            (t115 (do_mission  Phenomenon132 image4) )
            (t116 (do_mission  Star133 thermograph1) )
            (t117 (do_mission  Phenomenon134 thermograph0) )
            (t118 (do_mission  Planet135 image4) )
            (t119 (do_mission  Star136 image3) )
            (t120 (do_mission  Phenomenon137 thermograph1) )
            (t121 (do_mission  Star138 image4) )
            (t122 (do_mission  Star139 thermograph1) )
            (t123 (do_mission  Planet141 thermograph0) )
            (t124 (do_mission  Planet143 thermograph2) )
            (t125 (do_mission  Planet144 image4) )
            (t126 (do_mission  Phenomenon145 thermograph1) )
            (t127 (do_mission  Star146 image4) )
            (t128 (do_mission  Phenomenon147 image4) )
            (t129 (do_mission  Planet148 thermograph2) )
            (t130 (do_mission  Star149 image3) )
            (t131 (do_mission  Star150 thermograph0) )
            (t132 (do_mission  Phenomenon151 thermograph0) )
            (t133 (do_mission  Phenomenon152 thermograph0) )
            (t134 (do_mission  Planet153 image4) )
            (t135 (do_mission  Star154 thermograph1) )
            (t136 (do_mission  Phenomenon155 image3) )
            (t137 (do_mission  Planet156 image3) )
            (t138 (do_mission  Planet158 image3) )
            (t139 (do_mission  Phenomenon159 thermograph1) )
            (t140 (do_mission  Star161 thermograph0) )
            (t141 (do_mission  Star162 image3) )
            (t142 (do_mission  Planet163 thermograph0) )
            (t143 (do_mission  Phenomenon164 thermograph1) )
            (t144 (do_mission  Phenomenon165 thermograph2) )
            (t145 (do_mission  Phenomenon166 thermograph1) )
            (t146 (do_mission  Star167 image4) )
            (t147 (do_mission  Star168 thermograph2) )
            (t148 (do_mission  Planet169 thermograph0) )
            (t149 (do_mission  Phenomenon170 image4) )
            (t150 (do_mission  Star171 thermograph0) )
            (t151 (do_mission  Planet172 image4) )
            (t152 (do_mission  Planet173 thermograph0) )
            (t153 (do_mission  Star175 image3) )
            (t154 (do_mission  Star176 image3) )
            (t155 (do_mission  Star177 image4) )
            (t156 (do_mission  Star178 image3) )
            (t157 (do_mission  Planet179 thermograph0) )
            (t158 (do_mission  Star181 image3) )
            (t159 (do_mission  Planet182 image3) )
            (t160 (do_mission  Phenomenon183 thermograph0) )
            (t161 (do_mission  Planet184 thermograph2) )
            (t162 (do_mission  Phenomenon185 image4) )
            (t163 (do_mission  Star186 image4) )
            (t164 (do_mission  Star187 thermograph0) )
            (t165 (do_mission  Star188 thermograph0) )
            (t166 (do_mission  Planet189 image4) )
            (t167 (do_mission  Star190 thermograph2) )
            (t168 (do_mission  Planet191 thermograph1) )
            (t169 (do_mission  Star192 image4) )
            (t170 (do_mission  Phenomenon193 image3) )
            (t171 (do_mission  Phenomenon194 thermograph2) )
            (t172 (do_mission  Star195 image4) )
            (t173 (do_mission  Planet196 thermograph1) )
            (t174 (do_mission  Star197 thermograph1) )
            (t175 (do_mission  Planet198 thermograph1) )
            (t176 (do_mission  Phenomenon199 thermograph2) )
            (t177 (do_mission  Planet200 thermograph1) )
            (t178 (do_mission  Phenomenon201 thermograph0) )
            (t179 (do_mission  Phenomenon202 thermograph1) )
            (t180 (do_mission  Phenomenon203 thermograph1) )
            (t181 (do_mission  Star204 thermograph1) )
            (t182 (do_mission  Planet205 image4) )
            (t183 (do_mission  Planet206 image4) )
            (t184 (do_mission  Planet207 image3) )
            (t185 (do_mission  Star208 thermograph2) )
            (t186 (do_mission  Phenomenon209 thermograph2) )
            (t187 (do_mission  Phenomenon210 image3) )
            (t188 (do_mission  Phenomenon211 thermograph0) )
            (t189 (do_mission  Star212 thermograph0) )
            (t190 (do_mission  Phenomenon213 thermograph2) )
            (t191 (do_mission  Phenomenon214 thermograph1) )
            (t192 (do_mission  Phenomenon216 thermograph1) )
            (t193 (do_mission  Star217 thermograph0) )
            (t194 (do_mission  Phenomenon218 image3) )
            (t195 (do_mission  Star219 image4) )
            (t196 (do_mission  Star220 thermograph2) )
            (t197 (do_mission  Phenomenon221 image4) )
            (t198 (do_mission  Phenomenon222 image4) )
            (t199 (do_mission  Phenomenon223 thermograph2) )
            (t200 (do_mission  Star224 thermograph2) )
            (t201 (do_mission  Phenomenon225 image4) )
            (t202 (do_mission  Phenomenon226 thermograph2) )
            (t203 (do_mission  Phenomenon227 thermograph1) )
            (t204 (do_mission  Planet229 thermograph1) )
            (t205 (do_mission  Star230 thermograph1) )
            (t206 (do_mission  Phenomenon231 thermograph2) )
            (t207 (do_mission  Phenomenon233 thermograph2) )
            (t208 (do_mission  Phenomenon234 thermograph1) )
            (t209 (do_mission  Star235 image3) )
            (t210 (do_mission  Planet236 image4) )
            (t211 (do_mission  Phenomenon237 thermograph1) )
            (t212 (do_mission  Phenomenon238 thermograph0) )
            (t213 (do_mission  Planet240 image3) )
            (t214 (do_mission  Phenomenon241 image4) )
            (t215 (do_mission  Planet242 image3) )
            (t216 (do_mission  Star243 image3) )
            (t217 (do_mission  Planet244 thermograph0) )
            (t218 (do_mission  Phenomenon246 image4) )
            (t219 (do_mission  Star247 thermograph2) )
            (t220 (do_mission  Phenomenon248 thermograph1) )
            (t221 (do_mission  Phenomenon249 image3) )
            (t222 (do_mission  Phenomenon250 image4) )
            (t223 (do_mission  Star251 thermograph0) )
            (t224 (do_mission  Star252 thermograph2) )
            (t225 (do_mission  Star253 image4) )
            (t226 (do_mission  Planet254 image3) )
            (t227 (do_turning satellite0 Phenomenon83) )
            (t228 (do_turning satellite3 Phenomenon209) )
            (t229 (do_turning satellite4 Star253) )
            (t230 (do_turning satellite9 Phenomenon134) )
            (t231 (do_turning satellite11 Planet28) )
        )
    )

    (:init
        (supports instrument0 thermograph0)
        (calibration_target instrument0 Star0)
        (supports instrument1 image3)
        (supports instrument1 thermograph0)
        (supports instrument1 thermograph1)
        (calibration_target instrument1 Star4)
        (supports instrument2 image3)
        (calibration_target instrument2 Star1)
        (on_board instrument0 satellite0)
        (on_board instrument1 satellite0)
        (on_board instrument2 satellite0)
        (power_avail satellite0)
        (pointing satellite0 Phenomenon103)
        (supports instrument3 thermograph2)
        (calibration_target instrument3 Star0)
        (supports instrument4 thermograph0)
        (supports instrument4 thermograph2)
        (calibration_target instrument4 Star0)
        (on_board instrument3 satellite1)
        (on_board instrument4 satellite1)
        (power_avail satellite1)
        (pointing satellite1 Phenomenon104)
        (supports instrument5 image3)
        (supports instrument5 thermograph2)
        (supports instrument5 thermograph0)
        (calibration_target instrument5 GroundStation2)
        (supports instrument6 thermograph2)
        (supports instrument6 thermograph1)
        (supports instrument6 thermograph0)
        (calibration_target instrument6 Star0)
        (supports instrument7 thermograph0)
        (supports instrument7 image3)
        (calibration_target instrument7 GroundStation3)
        (on_board instrument5 satellite2)
        (on_board instrument6 satellite2)
        (on_board instrument7 satellite2)
        (power_avail satellite2)
        (pointing satellite2 Planet191)
        (supports instrument8 image4)
        (calibration_target instrument8 GroundStation3)
        (supports instrument9 image3)
        (calibration_target instrument9 Star0)
        (on_board instrument8 satellite3)
        (on_board instrument9 satellite3)
        (power_avail satellite3)
        (pointing satellite3 Planet232)
        (supports instrument10 thermograph2)
        (supports instrument10 thermograph0)
        (supports instrument10 thermograph1)
        (calibration_target instrument10 Star1)
        (supports instrument11 image3)
        (calibration_target instrument11 Star1)
        (supports instrument12 thermograph1)
        (supports instrument12 thermograph0)
        (calibration_target instrument12 Star1)
        (on_board instrument10 satellite4)
        (on_board instrument11 satellite4)
        (on_board instrument12 satellite4)
        (power_avail satellite4)
        (pointing satellite4 Phenomenon147)
        (supports instrument13 thermograph0)
        (calibration_target instrument13 GroundStation2)
        (supports instrument14 image4)
        (supports instrument14 thermograph1)
        (supports instrument14 thermograph0)
        (calibration_target instrument14 GroundStation2)
        (supports instrument15 image4)
        (supports instrument15 image3)
        (supports instrument15 thermograph2)
        (calibration_target instrument15 Star1)
        (on_board instrument13 satellite5)
        (on_board instrument14 satellite5)
        (on_board instrument15 satellite5)
        (power_avail satellite5)
        (pointing satellite5 Phenomenon18)
        (supports instrument16 thermograph1)
        (calibration_target instrument16 GroundStation2)
        (on_board instrument16 satellite6)
        (power_avail satellite6)
        (pointing satellite6 Phenomenon37)
        (supports instrument17 thermograph0)
        (supports instrument17 image4)
        (calibration_target instrument17 GroundStation3)
        (supports instrument18 thermograph0)
        (calibration_target instrument18 Star4)
        (on_board instrument17 satellite7)
        (on_board instrument18 satellite7)
        (power_avail satellite7)
        (pointing satellite7 Planet123)
        (supports instrument19 thermograph1)
        (supports instrument19 image3)
        (supports instrument19 thermograph0)
        (calibration_target instrument19 Star4)
        (on_board instrument19 satellite8)
        (power_avail satellite8)
        (pointing satellite8 Planet115)
        (supports instrument20 thermograph2)
        (supports instrument20 image4)
        (calibration_target instrument20 GroundStation2)
        (supports instrument21 image3)
        (supports instrument21 image4)
        (calibration_target instrument21 GroundStation2)
        (supports instrument22 image3)
        (supports instrument22 thermograph2)
        (supports instrument22 thermograph0)
        (calibration_target instrument22 Star4)
        (on_board instrument20 satellite9)
        (on_board instrument21 satellite9)
        (on_board instrument22 satellite9)
        (power_avail satellite9)
        (pointing satellite9 Phenomenon46)
        (supports instrument23 image3)
        (supports instrument23 thermograph0)
        (calibration_target instrument23 Star4)
        (supports instrument24 thermograph1)
        (supports instrument24 thermograph0)
        (supports instrument24 thermograph2)
        (calibration_target instrument24 Star1)
        (on_board instrument23 satellite10)
        (on_board instrument24 satellite10)
        (power_avail satellite10)
        (pointing satellite10 Planet173)
        (supports instrument25 thermograph0)
        (supports instrument25 thermograph2)
        (calibration_target instrument25 Star0)
        (supports instrument26 image3)
        (supports instrument26 image4)
        (calibration_target instrument26 Star0)
        (supports instrument27 thermograph0)
        (supports instrument27 image4)
        (supports instrument27 image3)
        (calibration_target instrument27 Star4)
        (on_board instrument25 satellite11)
        (on_board instrument26 satellite11)
        (on_board instrument27 satellite11)
        (power_avail satellite11)
        (pointing satellite11 Phenomenon116)
        (supports instrument28 image3)
        (supports instrument28 thermograph1)
        (calibration_target instrument28 GroundStation2)
        (supports instrument29 thermograph1)
        (calibration_target instrument29 Star1)
        (supports instrument30 image3)
        (calibration_target instrument30 GroundStation3)
        (on_board instrument28 satellite12)
        (on_board instrument29 satellite12)
        (on_board instrument30 satellite12)
        (power_avail satellite12)
        (pointing satellite12 Planet254)
        (supports instrument31 thermograph0)
        (supports instrument31 image3)
        (calibration_target instrument31 GroundStation3)
        (supports instrument32 thermograph0)
        (calibration_target instrument32 GroundStation2)
        (supports instrument33 thermograph0)
        (supports instrument33 thermograph1)
        (supports instrument33 image3)
        (calibration_target instrument33 Star4)
        (on_board instrument31 satellite13)
        (on_board instrument32 satellite13)
        (on_board instrument33 satellite13)
        (power_avail satellite13)
        (pointing satellite13 Star14)
        (supports instrument34 thermograph2)
        (supports instrument34 thermograph1)
        (calibration_target instrument34 Star1)
        (on_board instrument34 satellite14)
        (power_avail satellite14)
        (pointing satellite14 Phenomenon100)
    )
)
