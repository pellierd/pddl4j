
(define (problem strips-sat-x-1)
(:domain satellite)
(:requirements :strips :typing :htn :negative-preconditions)

  ;---------------- Facts -----------------------
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

  ;--------------- Initial State -----------------
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

  (:goal
        :tasks  (
                    (tag t1   (do_mission Phenomenon5 spectrograph2) )
                    (tag t2   (do_mission Planet6 spectrograph2) )
                    (tag t3   (do_mission Planet7 infrared0) )
                    (tag t4   (do_mission Phenomenon9 infrared0) ) 
                    (tag t5   (do_mission Phenomenon10 image1) )
                    (tag t6   (do_mission Planet11 image1) )
                    (tag t7   (do_mission Star12 thermograph3) )
                    (tag t8   (do_mission Star13 thermograph3) )
                    (tag t9   (do_mission Planet14 thermograph4) )
                    (tag t10  (do_mission Star15 thermograph4) )
                    (tag t11  (do_mission Phenomenon16 image1) )
                    (tag t12  (do_mission Planet17 thermograph3) )
                    (tag t13  (do_mission Star18 image1) )
                    (tag t14  (do_mission Planet20 image1) )
                    (tag t15  (do_mission Planet21 infrared0) )
                    (tag t16  (do_mission Planet22 image1) )
                    (tag t17  (do_mission Planet23 thermograph3) )
                    (tag t18  (do_mission Planet24 infrared0) )
                    (tag t19  (do_mission Phenomenon25 thermograph4) )
                    (tag t20  (do_mission Planet26 thermograph4) )
                    (tag t21  (do_mission Phenomenon27 spectrograph2) )
                    (tag t22  (do_mission Phenomenon28 infrared0) )
                    (tag t23  (do_mission Planet29 infrared0) )
                    (tag t24  (do_mission Planet30 thermograph4) )
                    (tag t25  (do_mission Phenomenon31 image1) )
                    (tag t26  (do_mission Planet32 spectrograph2) )
                    (tag t27  (do_mission Planet33 spectrograph2) )
                    (tag t28  (do_mission Star34 thermograph4) )
                    (tag t29  (do_mission Phenomenon35 thermograph3) )
                    (tag t30  (do_mission Phenomenon36 image1) )
                    (tag t31  (do_mission Phenomenon38 image1) )
                    (tag t32  (do_mission Star39 thermograph3) )
                    (tag t33  (do_mission Planet40 thermograph4) )
                    (tag t34  (do_mission Star41 thermograph3) )
                    (tag t35  (do_mission Phenomenon42 infrared0) )
                    (tag t36  (do_mission Phenomenon43 thermograph4) )
                    (tag t37  (do_mission Planet44 infrared0) )
                    (tag t38  (do_mission Planet46 infrared0) )
                    (tag t39  (do_mission Planet47 infrared0) )
                    (tag t40  (do_mission Star48 thermograph4) )
                    (tag t41  (do_mission Planet49 infrared0) )
                    (tag t42  (do_mission Star50 spectrograph2) )
                    (tag t43  (do_mission Star51 spectrograph2) )
                    (tag t44  (do_mission Star52 spectrograph2) ) 
                    (tag t45  (do_mission Planet53 image1) )
                    (tag t46  (do_mission Planet54 thermograph3) )
                    (tag t47  (do_mission Phenomenon55 thermograph4) )
                    (tag t48  (do_mission Planet56 thermograph3) )
                    (tag t49  (do_mission Phenomenon58 thermograph4) )
                    (tag t50  (do_mission Planet59 thermograph3) )
                    (tag t51  (do_mission Planet61 thermograph4) )
                    (tag t52  (do_mission Star62 thermograph3) )
                    (tag t53  (do_mission Star63 infrared0) )
                    (tag t54  (do_mission Star64 thermograph4) )
                    (tag t55  (do_mission Phenomenon65 infrared0) )
                    (tag t56  (do_mission Star66 thermograph3) )
                    (tag t57  (do_mission Phenomenon67 thermograph3) )
                    (tag t58  (do_mission Phenomenon68 infrared0) )
                    (tag t59  (do_mission Star69 infrared0) )
                    (tag t60  (do_mission Planet70 thermograph3) )
                    (tag t61  (do_mission Phenomenon71 thermograph4) )
                    (tag t62  (do_mission Phenomenon72 thermograph3) )
                    (tag t63  (do_mission Star73 spectrograph2) )
                    (tag t64  (do_mission Planet75 image1) )
                    (tag t65  (do_mission Star76 spectrograph2) )
                    (tag t66  (do_mission Planet77 spectrograph2) )
                    (tag t67  (do_mission Planet78 thermograph4) )
                    (tag t68  (do_mission Planet79 spectrograph2) )
                    (tag t69  (do_mission Planet80 image1) )
                    (tag t70  (do_mission Planet81 thermograph4) )
                    (tag t71  (do_mission Star82 image1) )
                    (tag t72  (do_mission Planet83 infrared0) )
                    (tag t73  (do_mission Phenomenon84 image1) )
                    (tag t74  (do_mission Planet85 thermograph3) )
                    (tag t75  (do_mission Phenomenon86 thermograph3) )
                    (tag t76  (do_mission Phenomenon87 spectrograph2) )
                    (tag t77  (do_mission Planet89 infrared0) )
                    (tag t78  (do_mission Star90 infrared0) )
                    (tag t79  (do_mission Phenomenon91 infrared0) )
                    (tag t80  (do_mission Planet92 infrared0) )
                    (tag t81  (do_mission Planet93 spectrograph2) )
                    (tag t82  (do_mission Planet94 infrared0) )
                    (tag t83  (do_mission Star95 image1) )
                    (tag t84  (do_mission Phenomenon96 infrared0) ) 
                    (tag t85  (do_mission Planet97 infrared0) )
                    (tag t86  (do_mission Planet98 thermograph4) )
                    (tag t87  (do_mission Planet99 image1) )
                    (tag t88  (do_mission Phenomenon100 infrared0) )
                    (tag t89  (do_mission Planet101 infrared0) )
                    (tag t90  (do_mission Star102 spectrograph2) )
                    (tag t91  (do_mission Star103 thermograph4) )
                    (tag t92  (do_mission Phenomenon104 image1) )
                    (tag t93  (do_mission Planet105 thermograph4) )
                    (tag t94  (do_mission Star106 spectrograph2) )
                    (tag t95  (do_mission Star107 infrared0) )
                    (tag t96  (do_mission Star108 thermograph4) )
                    (tag t97  (do_mission Star109 infrared0) )
                    (tag t98  (do_mission Phenomenon110 spectrograph2) )
                    (tag t99  (do_mission Star111 image1) )
                    (tag t100 (do_mission Star112 thermograph3) )
                    (tag t101 (do_mission Star114 spectrograph2) )
                    (tag t102 (do_mission Phenomenon115 spectrograph2) )
                    (tag t103 (do_mission Planet116 spectrograph2) )
                    (tag t104 (do_mission Phenomenon117 spectrograph2) )
                    (tag t105 (do_mission Planet118 image1) )
                    (tag t106 (do_mission Planet119 thermograph3) )
                    (tag t107 (do_mission Star120 infrared0) )
                    (tag t108 (do_mission Phenomenon121 thermograph3) )
                    (tag t109 (do_mission Planet122 infrared0) )
                    (tag t110 (do_mission Phenomenon123 thermograph3) )
                    (tag t111 (do_mission Phenomenon124 spectrograph2) )
                    (tag t112 (do_mission Planet125 thermograph3) )
                    (tag t113 (do_mission Star126 thermograph3) )
                    (tag t114 (do_mission Planet127 spectrograph2) )
                    (tag t115 (do_mission Phenomenon128 image1) )
                    (tag t116 (do_mission Star129 spectrograph2) )
                    (tag t117 (do_mission Star130 infrared0) )
                    (tag t118 (do_mission Phenomenon131 infrared0) )
                    (tag t119 (do_mission Star132 spectrograph2) )
                    (tag t120 (do_mission Star133 thermograph4) )
                    (tag t121 (do_mission Planet135 image1) )
                    (tag t122 (do_mission Planet138 thermograph3) )
                    (tag t123 (do_mission Planet139 thermograph4) )
                    (tag t124 (do_mission Phenomenon140 infrared0) ) 
                    (tag t125 (do_mission Planet141 thermograph3) )
                    (tag t126 (do_mission Phenomenon142 spectrograph2) )
                    (tag t127 (do_mission Planet143 thermograph4) )
                    (tag t128 (do_mission Star144 thermograph4) )
                    (tag t129 (do_mission Phenomenon145 image1) )
                    (tag t130 (do_mission Phenomenon146 infrared0) )
                    (tag t131 (do_mission Phenomenon147 spectrograph2) )
                    (tag t132 (do_mission Planet148 spectrograph2) )
                    (tag t133 (do_mission Phenomenon149 thermograph4) )
                    (tag t134 (do_mission Star151 thermograph4) )
                    (tag t135 (do_mission Star152 thermograph3) )
                    (tag t136 (do_mission Phenomenon153 spectrograph2) )
                    (tag t137 (do_mission Planet154 thermograph4) )
                    (tag t138 (do_mission Star155 spectrograph2) )
                    (tag t139 (do_mission Star156 spectrograph2) )
                    (tag t140 (do_mission Phenomenon157 thermograph3) )
                    (tag t141 (do_mission Phenomenon158 spectrograph2) )
                    (tag t142 (do_mission Planet159 infrared0) )
                    (tag t143 (do_mission Planet160 image1) )
                    (tag t144 (do_mission Planet161 image1) )
                    (tag t145 (do_mission Star162 spectrograph2) )
                    (tag t146 (do_mission Planet163 spectrograph2) )
                    (tag t147 (do_mission Planet164 spectrograph2) )
                    (tag t148 (do_mission Star165 infrared0) )
                    (tag t149 (do_mission Phenomenon166 spectrograph2) )
                    (tag t150 (do_mission Star167 image1) )
                    (tag t151 (do_mission Star168 infrared0) )
                    (tag t152 (do_mission Star169 spectrograph2) )
                    (tag t153 (do_mission Planet170 thermograph4) )
                    (tag t154 (do_mission Planet171 spectrograph2) )
                    (tag t155 (do_mission Star172 thermograph4) )
                    (tag t156 (do_mission Planet173 thermograph3) )
                    (tag t157 (do_mission Planet174 thermograph3) )
                    (tag t158 (do_mission Phenomenon175 infrared0) )
                    (tag t159 (do_mission Phenomenon176 spectrograph2) )
                    (tag t160 (do_mission Star177 infrared0) )
                    (tag t161 (do_mission Planet178 spectrograph2) )
                    (tag t162 (do_mission Planet179 spectrograph2) )
                    (tag t163 (do_mission Star181 image1) )
                    (tag t164 (do_mission Star182 thermograph4) ) 
                    (tag t165 (do_mission Phenomenon183 thermograph3) )
                    (tag t166 (do_mission Star184 spectrograph2) )
                    (tag t167 (do_mission Star185 thermograph3) )
                    (tag t168 (do_mission Phenomenon186 image1) )
                    (tag t169 (do_mission Planet187 infrared0) )
                    (tag t170 (do_mission Star188 image1) )
                    (tag t171 (do_mission Star189 spectrograph2) )
                    (tag t172 (do_mission Phenomenon190 infrared0) )
                    (tag t173 (do_mission Planet191 spectrograph2) )
                    (tag t174 (do_mission Star192 thermograph4) )
                    (tag t175 (do_mission Phenomenon193 thermograph3) )
                    (tag t176 (do_mission Planet194 thermograph4) )
                    (tag t177 (do_mission Phenomenon195 thermograph4) )
                    (tag t178 (do_mission Planet197 infrared0) )
                    (tag t179 (do_mission Planet198 image1) )
                    (tag t180 (do_mission Planet199 spectrograph2) )
                    (tag t181 (do_mission Phenomenon200 spectrograph2) )
                    (tag t182 (do_mission Phenomenon201 thermograph4) )
                    (tag t183 (do_mission Star202 infrared0) )
                    (tag t184 (do_mission Star204 infrared0) )
                    (tag t185 (do_turning satellite1 Star45) )
                    (tag t186 (do_turning satellite2 Planet101) )
                    (tag t187 (do_turning satellite4 Phenomenon183) )
                )
        :constraints(and
                        (after (and 
                                    (have_image Phenomenon5 spectrograph2)
                                    (have_image Planet6 spectrograph2)
                                    (have_image Planet7 infrared0)
                                    (have_image Phenomenon9 infrared0)
                                    (have_image Phenomenon10 image1)
                                    (have_image Planet11 image1)
                                    (have_image Star12 thermograph3)
                                    (have_image Star13 thermograph3)
                                    (have_image Planet14 thermograph4)
                                    (have_image Star15 thermograph4)
                                    (have_image Phenomenon16 image1)
                                    (have_image Planet17 thermograph3)
                                    (have_image Star18 image1)
                                    (have_image Planet20 image1)
                                    (have_image Planet21 infrared0)
                                    (have_image Planet22 image1)
                                    (have_image Planet23 thermograph3)
                                    (have_image Planet24 infrared0)
                                    (have_image Phenomenon25 thermograph4)
                                    (have_image Planet26 thermograph4)
                                    (have_image Phenomenon27 spectrograph2)
                                    (have_image Phenomenon28 infrared0)
                                    (have_image Planet29 infrared0)
                                    (have_image Planet30 thermograph4)
                                    (have_image Phenomenon31 image1)
                                    (have_image Planet32 spectrograph2)
                                    (have_image Planet33 spectrograph2)
                                    (have_image Star34 thermograph4)
                                    (have_image Phenomenon35 thermograph3)
                                    (have_image Phenomenon36 image1)
                                    (have_image Phenomenon38 image1)
                                    (have_image Star39 thermograph3)
                                    (have_image Planet40 thermograph4)
                                    (have_image Star41 thermograph3)
                                    (have_image Phenomenon42 infrared0)
                                    (have_image Phenomenon43 thermograph4)
                                    (have_image Planet44 infrared0)
                                    (have_image Planet46 infrared0)
                                    (have_image Planet47 infrared0)
                                    (have_image Star48 thermograph4)
                                    (have_image Planet49 infrared0)
                                    (have_image Star50 spectrograph2)
                                    (have_image Star51 spectrograph2)
                                    (have_image Star52 spectrograph2)
                                    (have_image Planet53 image1)
                                    (have_image Planet54 thermograph3)
                                    (have_image Phenomenon55 thermograph4)
                                    (have_image Planet56 thermograph3)
                                    (have_image Phenomenon58 thermograph4)
                                    (have_image Planet59 thermograph3)
                                    (have_image Planet61 thermograph4)
                                    (have_image Star62 thermograph3)
                                    (have_image Star63 infrared0)
                                    (have_image Star64 thermograph4)
                                    (have_image Phenomenon65 infrared0)
                                    (have_image Star66 thermograph3)
                                    (have_image Phenomenon67 thermograph3)
                                    (have_image Phenomenon68 infrared0)
                                    (have_image Star69 infrared0)
                                    (have_image Planet70 thermograph3)
                                    (have_image Phenomenon71 thermograph4)
                                    (have_image Phenomenon72 thermograph3)
                                    (have_image Star73 spectrograph2)
                                    (have_image Planet75 image1)
                                    (have_image Star76 spectrograph2)
                                    (have_image Planet77 spectrograph2)
                                    (have_image Planet78 thermograph4)
                                    (have_image Planet79 spectrograph2)
                                    (have_image Planet80 image1)
                                    (have_image Planet81 thermograph4)
                                    (have_image Star82 image1)
                                    (have_image Planet83 infrared0)
                                    (have_image Phenomenon84 image1)
                                    (have_image Planet85 thermograph3)
                                    (have_image Phenomenon86 thermograph3)
                                    (have_image Phenomenon87 spectrograph2)
                                    (have_image Planet89 infrared0)
                                    (have_image Star90 infrared0)
                                    (have_image Phenomenon91 infrared0)
                                    (have_image Planet92 infrared0)
                                    (have_image Planet93 spectrograph2)
                                    (have_image Planet94 infrared0)
                                    (have_image Star95 image1)
                                    (have_image Phenomenon96 infrared0)
                                    (have_image Planet97 infrared0)
                                    (have_image Planet98 thermograph4)
                                    (have_image Planet99 image1)
                                    (have_image Phenomenon100 infrared0)
                                    (have_image Planet101 infrared0)
                                    (have_image Star102 spectrograph2)
                                    (have_image Star103 thermograph4)
                                    (have_image Phenomenon104 image1)
                                    (have_image Planet105 thermograph4)
                                    (have_image Star106 spectrograph2)
                                    (have_image Star107 infrared0)
                                    (have_image Star108 thermograph4)
                                    (have_image Star109 infrared0)
                                    (have_image Phenomenon110 spectrograph2)
                                    (have_image Star111 image1)
                                    (have_image Star112 thermograph3)
                                    (have_image Star114 spectrograph2)
                                    (have_image Phenomenon115 spectrograph2)
                                    (have_image Planet116 spectrograph2)
                                    (have_image Phenomenon117 spectrograph2)
                                    (have_image Planet118 image1)
                                    (have_image Planet119 thermograph3)
                                    (have_image Star120 infrared0)
                                    (have_image Phenomenon121 thermograph3)
                                    (have_image Planet122 infrared0)
                                    (have_image Phenomenon123 thermograph3)
                                    (have_image Phenomenon124 spectrograph2)
                                    (have_image Planet125 thermograph3)
                                    (have_image Star126 thermograph3)
                                    (have_image Planet127 spectrograph2)
                                    (have_image Phenomenon128 image1)
                                    (have_image Star129 spectrograph2)
                                    (have_image Star130 infrared0)
                                    (have_image Phenomenon131 infrared0)
                                    (have_image Star132 spectrograph2)
                                    (have_image Star133 thermograph4)
                                    (have_image Planet135 image1)
                                    (have_image Planet138 thermograph3)
                                    (have_image Planet139 thermograph4)
                                    (have_image Phenomenon140 infrared0)
                                    (have_image Planet141 thermograph3)
                                    (have_image Phenomenon142 spectrograph2)
                                    (have_image Planet143 thermograph4)
                                    (have_image Star144 thermograph4)
                                    (have_image Phenomenon145 image1)
                                    (have_image Phenomenon146 infrared0)
                                    (have_image Phenomenon147 spectrograph2)
                                    (have_image Planet148 spectrograph2)
                                    (have_image Phenomenon149 thermograph4)
                                    (have_image Star151 thermograph4)
                                    (have_image Star152 thermograph3)
                                    (have_image Phenomenon153 spectrograph2)
                                    (have_image Planet154 thermograph4)
                                    (have_image Star155 spectrograph2)
                                    (have_image Star156 spectrograph2)
                                    (have_image Phenomenon157 thermograph3)
                                    (have_image Phenomenon158 spectrograph2)
                                    (have_image Planet159 infrared0)
                                    (have_image Planet160 image1)
                                    (have_image Planet161 image1)
                                    (have_image Star162 spectrograph2)
                                    (have_image Planet163 spectrograph2)
                                    (have_image Planet164 spectrograph2)
                                    (have_image Star165 infrared0)
                                    (have_image Phenomenon166 spectrograph2)
                                    (have_image Star167 image1)
                                    (have_image Star168 infrared0)
                                    (have_image Star169 spectrograph2)
                                    (have_image Planet170 thermograph4)
                                    (have_image Planet171 spectrograph2)
                                    (have_image Star172 thermograph4)
                                    (have_image Planet173 thermograph3)
                                    (have_image Planet174 thermograph3)
                                    (have_image Phenomenon175 infrared0)
                                    (have_image Phenomenon176 spectrograph2)
                                    (have_image Star177 infrared0)
                                    (have_image Planet178 spectrograph2)
                                    (have_image Planet179 spectrograph2)
                                    (have_image Star181 image1)
                                    (have_image Star182 thermograph4)
                                    (have_image Phenomenon183 thermograph3)
                                    (have_image Star184 spectrograph2)
                                    (have_image Star185 thermograph3)
                                    (have_image Phenomenon186 image1)
                                    (have_image Planet187 infrared0)
                                    (have_image Star188 image1)
                                    (have_image Star189 spectrograph2)
                                    (have_image Phenomenon190 infrared0)
                                    (have_image Planet191 spectrograph2)
                                    (have_image Star192 thermograph4)
                                    (have_image Phenomenon193 thermograph3)
                                    (have_image Planet194 thermograph4)
                                    (have_image Phenomenon195 thermograph4)
                                    (have_image Planet197 infrared0)
                                    (have_image Planet198 image1)
                                    (have_image Planet199 spectrograph2)
                                    (have_image Phenomenon200 spectrograph2)
                                    (have_image Phenomenon201 thermograph4)
                                    (have_image Star202 infrared0)
                                    (have_image Star204 infrared0)
                                    (pointing satellite1 Star45)
                                    (pointing satellite2 Planet101)
                                    (pointing satellite4 Phenomenon183)
                                ) t187)
                    )
)
