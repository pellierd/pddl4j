
(define (problem strips-sat-x-1)
(:domain satellite)
(:requirements :strips :typing :htn :negative-preconditions)

  ;---------------- Facts -----------------------
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
  satellite3 - satellite
  instrument7 - instrument
  satellite4 - satellite
  instrument8 - instrument
  instrument9 - instrument
  instrument10 - instrument
  satellite5 - satellite
  instrument11 - instrument
  satellite6 - satellite
  instrument12 - instrument
  instrument13 - instrument
  satellite7 - satellite
  instrument14 - instrument
  instrument15 - instrument
  instrument16 - instrument
  satellite8 - satellite
  instrument17 - instrument
  instrument18 - instrument
  instrument19 - instrument
  satellite9 - satellite
  instrument20 - instrument
  instrument21 - instrument
  instrument22 - instrument
  image0 - mode
  infrared4 - mode
  thermograph1 - mode
  spectrograph3 - mode
  image2 - mode
  GroundStation4 - direction
  Star2 - direction
  GroundStation0 - direction
  Star3 - direction
  GroundStation1 - direction
  Phenomenon5 - direction
  Planet6 - direction
  Planet7 - direction
  Planet8 - direction
  Phenomenon9 - direction
  Planet10 - direction
  Planet11 - direction
  Star12 - direction
  Star13 - direction
  Star14 - direction
  Star15 - direction
  Star16 - direction
  Phenomenon17 - direction
  Phenomenon18 - direction
  Planet19 - direction
  Star20 - direction
  Planet21 - direction
  Planet22 - direction
  Phenomenon23 - direction
  Star24 - direction
  Planet25 - direction
  Planet26 - direction
  Star27 - direction
  Phenomenon28 - direction
  Planet29 - direction
  Phenomenon30 - direction
  Planet31 - direction
  Star32 - direction
  Phenomenon33 - direction
  Star34 - direction
  Phenomenon35 - direction
  Phenomenon36 - direction
  Phenomenon37 - direction
  Star38 - direction
  Phenomenon39 - direction
  Planet40 - direction
  Planet41 - direction
  Star42 - direction
  Phenomenon43 - direction
  Star44 - direction
  Phenomenon45 - direction
  Phenomenon46 - direction
  Phenomenon47 - direction
  Planet48 - direction
  Planet49 - direction
  Star50 - direction
  Phenomenon51 - direction
  Star52 - direction
  Star53 - direction
  Star54 - direction
  Phenomenon55 - direction
  Star56 - direction
  Phenomenon57 - direction
  Star58 - direction
  Planet59 - direction
  Phenomenon60 - direction
  Phenomenon61 - direction
  Star62 - direction
  Phenomenon63 - direction
  Planet64 - direction
  Phenomenon65 - direction
  Planet66 - direction
  Planet67 - direction
  Phenomenon68 - direction
  Planet69 - direction
  Phenomenon70 - direction
  Planet71 - direction
  Planet72 - direction
  Phenomenon73 - direction
  Phenomenon74 - direction
  Planet75 - direction
  Star76 - direction
  Phenomenon77 - direction
  Phenomenon78 - direction
  Phenomenon79 - direction
  Phenomenon80 - direction
  Planet81 - direction
  Phenomenon82 - direction
  Phenomenon83 - direction
  Planet84 - direction
  Star85 - direction
  Planet86 - direction
  Star87 - direction
  Star88 - direction
  Star89 - direction
  Planet90 - direction
  Star91 - direction
  Planet92 - direction
  Star93 - direction
  Phenomenon94 - direction
  Phenomenon95 - direction
  Phenomenon96 - direction
  Star97 - direction
  Star98 - direction
  Star99 - direction
  Planet100 - direction
  Planet101 - direction
  Phenomenon102 - direction
  Phenomenon103 - direction
  Star104 - direction
  Star105 - direction
  Planet106 - direction
  Star107 - direction
  Planet108 - direction
  Phenomenon109 - direction
  Star110 - direction
  Star111 - direction
  Planet112 - direction
  Phenomenon113 - direction
  Phenomenon114 - direction
  Star115 - direction
  Planet116 - direction
  Planet117 - direction
  Star118 - direction
  Star119 - direction
  Planet120 - direction
  Phenomenon121 - direction
  Phenomenon122 - direction
  Phenomenon123 - direction
  Phenomenon124 - direction
  Phenomenon125 - direction
  Phenomenon126 - direction
  Phenomenon127 - direction
  Planet128 - direction
  Planet129 - direction
  Planet130 - direction
  Planet131 - direction
  Phenomenon132 - direction
  Star133 - direction
  Star134 - direction
  Star135 - direction
  Phenomenon136 - direction
  Planet137 - direction
  Star138 - direction
  Planet139 - direction
  Planet140 - direction
  Phenomenon141 - direction
  Star142 - direction
  Phenomenon143 - direction
  Planet144 - direction
  Planet145 - direction
  Planet146 - direction
  Star147 - direction
  Planet148 - direction
  Planet149 - direction
  Planet150 - direction
  Planet151 - direction
  Planet152 - direction
  Planet153 - direction
  Star154 - direction
  Star155 - direction
  Star156 - direction
  Planet157 - direction
  Star158 - direction
  Planet159 - direction
  Planet160 - direction
  Planet161 - direction
  Phenomenon162 - direction
  Star163 - direction
  Planet164 - direction
  Star165 - direction
  Star166 - direction
  Star167 - direction
  Planet168 - direction
  Planet169 - direction
  Planet170 - direction
  Phenomenon171 - direction
  Phenomenon172 - direction
  Phenomenon173 - direction
  Phenomenon174 - direction
  Planet175 - direction
  Planet176 - direction
  Phenomenon177 - direction
  Phenomenon178 - direction
  Planet179 - direction
  Phenomenon180 - direction
  Star181 - direction
  Planet182 - direction
  Star183 - direction
  Star184 - direction
  Planet185 - direction
  Planet186 - direction
  Star187 - direction
  Planet188 - direction
  Star189 - direction
  Planet190 - direction
  Phenomenon191 - direction
  Planet192 - direction
  Planet193 - direction
  Planet194 - direction
  Phenomenon195 - direction
  Star196 - direction
  Planet197 - direction
  Planet198 - direction
  Phenomenon199 - direction
  Star200 - direction
  Planet201 - direction
  Planet202 - direction
  Phenomenon203 - direction
  Star204 - direction
  )

  ;--------------- Initial State -----------------
  (:init
      (supports instrument0 image0)
  (supports instrument0 image2)
  (calibration_target instrument0 Star3)
  (supports instrument1 image2)
  (supports instrument1 spectrograph3)
  (supports instrument1 thermograph1)
  (calibration_target instrument1 GroundStation4)
  (supports instrument2 thermograph1)
  (calibration_target instrument2 GroundStation0)
  (on_board instrument0 satellite0)
  (on_board instrument1 satellite0)
  (on_board instrument2 satellite0)
  (power_avail satellite0)
  (pointing satellite0 Planet128)
  (supports instrument3 image0)
  (supports instrument3 infrared4)
  (supports instrument3 image2)
  (calibration_target instrument3 GroundStation1)
  (supports instrument4 image2)
  (supports instrument4 infrared4)
  (supports instrument4 thermograph1)
  (calibration_target instrument4 GroundStation0)
  (on_board instrument3 satellite1)
  (on_board instrument4 satellite1)
  (power_avail satellite1)
  (pointing satellite1 Planet149)
  (supports instrument5 spectrograph3)
  (supports instrument5 thermograph1)
  (supports instrument5 infrared4)
  (calibration_target instrument5 GroundStation1)
  (supports instrument6 spectrograph3)
  (calibration_target instrument6 Star2)
  (on_board instrument5 satellite2)
  (on_board instrument6 satellite2)
  (power_avail satellite2)
  (pointing satellite2 Planet144)
  (supports instrument7 image2)
  (calibration_target instrument7 Star2)
  (on_board instrument7 satellite3)
  (power_avail satellite3)
  (pointing satellite3 Star105)
  (supports instrument8 infrared4)
  (calibration_target instrument8 GroundStation0)
  (supports instrument9 spectrograph3)
  (supports instrument9 image0)
  (supports instrument9 infrared4)
  (calibration_target instrument9 GroundStation4)
  (supports instrument10 image0)
  (supports instrument10 spectrograph3)
  (supports instrument10 image2)
  (calibration_target instrument10 GroundStation0)
  (on_board instrument8 satellite4)
  (on_board instrument9 satellite4)
  (on_board instrument10 satellite4)
  (power_avail satellite4)
  (pointing satellite4 Planet137)
  (supports instrument11 spectrograph3)
  (calibration_target instrument11 Star2)
  (on_board instrument11 satellite5)
  (power_avail satellite5)
  (pointing satellite5 Planet31)
  (supports instrument12 infrared4)
  (calibration_target instrument12 GroundStation4)
  (supports instrument13 image2)
  (calibration_target instrument13 Star2)
  (on_board instrument12 satellite6)
  (on_board instrument13 satellite6)
  (power_avail satellite6)
  (pointing satellite6 Planet168)
  (supports instrument14 thermograph1)
  (supports instrument14 image0)
  (calibration_target instrument14 GroundStation0)
  (supports instrument15 infrared4)
  (supports instrument15 image2)
  (supports instrument15 spectrograph3)
  (calibration_target instrument15 GroundStation1)
  (supports instrument16 spectrograph3)
  (supports instrument16 thermograph1)
  (supports instrument16 image0)
  (calibration_target instrument16 GroundStation0)
  (on_board instrument14 satellite7)
  (on_board instrument15 satellite7)
  (on_board instrument16 satellite7)
  (power_avail satellite7)
  (pointing satellite7 Phenomenon79)
  (supports instrument17 spectrograph3)
  (supports instrument17 image0)
  (supports instrument17 thermograph1)
  (calibration_target instrument17 GroundStation1)
  (supports instrument18 infrared4)
  (supports instrument18 thermograph1)
  (supports instrument18 image0)
  (calibration_target instrument18 GroundStation0)
  (supports instrument19 infrared4)
  (supports instrument19 image0)
  (supports instrument19 spectrograph3)
  (calibration_target instrument19 GroundStation0)
  (on_board instrument17 satellite8)
  (on_board instrument18 satellite8)
  (on_board instrument19 satellite8)
  (power_avail satellite8)
  (pointing satellite8 Planet176)
  (supports instrument20 thermograph1)
  (calibration_target instrument20 Star3)
  (supports instrument21 thermograph1)
  (calibration_target instrument21 Star3)
  (supports instrument22 image2)
  (supports instrument22 spectrograph3)
  (calibration_target instrument22 GroundStation1)
  (on_board instrument20 satellite9)
  (on_board instrument21 satellite9)
  (on_board instrument22 satellite9)
  (power_avail satellite9)
  (pointing satellite9 Planet116)
  )

  (:goal
        :tasks  (
                    (tag t1   (do_mission Phenomenon5 thermograph1) )
                    (tag t2   (do_mission Planet6 infrared4) )
                    (tag t3   (do_mission Planet7 image0) )
                    (tag t4   (do_mission Planet8 thermograph1) ) 
                    (tag t5   (do_mission Phenomenon9 image2) )
                    (tag t6   (do_mission Planet10 image0) )
                    (tag t7   (do_mission Planet11 infrared4) )
                    (tag t8   (do_mission Star12 image0) )
                    (tag t9   (do_mission Star13 image0) )
                    (tag t10  (do_mission Star14 thermograph1) )
                    (tag t11  (do_mission Star15 image0) )
                    (tag t12  (do_mission Star16 thermograph1) )
                    (tag t13  (do_mission Phenomenon17 infrared4) )
                    (tag t14  (do_mission Phenomenon18 spectrograph3) )
                    (tag t15  (do_mission Star20 image0) )
                    (tag t16  (do_mission Planet21 thermograph1) )
                    (tag t17  (do_mission Planet22 image2) )
                    (tag t18  (do_mission Phenomenon23 image0) )
                    (tag t19  (do_mission Star24 infrared4) )
                    (tag t20  (do_mission Planet26 infrared4) )
                    (tag t21  (do_mission Star27 image2) )
                    (tag t22  (do_mission Phenomenon28 image2) )
                    (tag t23  (do_mission Planet29 image0) )
                    (tag t24  (do_mission Planet31 spectrograph3) )
                    (tag t25  (do_mission Star32 image0) )
                    (tag t26  (do_mission Phenomenon33 spectrograph3) )
                    (tag t27  (do_mission Star34 image0) )
                    (tag t28  (do_mission Phenomenon35 image2) )
                    (tag t29  (do_mission Phenomenon36 infrared4) )
                    (tag t30  (do_mission Phenomenon37 image2) )
                    (tag t31  (do_mission Star38 thermograph1) )
                    (tag t32  (do_mission Phenomenon39 image2) )
                    (tag t33  (do_mission Planet40 image0) )
                    (tag t34  (do_mission Planet41 thermograph1) )
                    (tag t35  (do_mission Star42 infrared4) )
                    (tag t36  (do_mission Star44 thermograph1) )
                    (tag t37  (do_mission Phenomenon45 thermograph1) )
                    (tag t38  (do_mission Phenomenon46 image0) )
                    (tag t39  (do_mission Planet48 spectrograph3) )
                    (tag t40  (do_mission Planet49 thermograph1) )
                    (tag t41  (do_mission Phenomenon51 infrared4) )
                    (tag t42  (do_mission Star52 infrared4) )
                    (tag t43  (do_mission Star53 image0) )
                    (tag t44  (do_mission Star54 spectrograph3) ) 
                    (tag t45  (do_mission Phenomenon55 image0) )
                    (tag t46  (do_mission Star56 infrared4) )
                    (tag t47  (do_mission Phenomenon57 thermograph1) )
                    (tag t48  (do_mission Star58 thermograph1) )
                    (tag t49  (do_mission Planet59 infrared4) )
                    (tag t50  (do_mission Phenomenon60 infrared4) )
                    (tag t51  (do_mission Phenomenon61 infrared4) )
                    (tag t52  (do_mission Star62 infrared4) )
                    (tag t53  (do_mission Phenomenon63 infrared4) )
                    (tag t54  (do_mission Planet64 image2) )
                    (tag t55  (do_mission Phenomenon65 spectrograph3) )
                    (tag t56  (do_mission Planet67 image2) )
                    (tag t57  (do_mission Phenomenon68 spectrograph3) )
                    (tag t58  (do_mission Phenomenon70 spectrograph3) )
                    (tag t59  (do_mission Planet72 image2) )
                    (tag t60  (do_mission Phenomenon73 image2) )
                    (tag t61  (do_mission Phenomenon74 spectrograph3) )
                    (tag t62  (do_mission Planet75 infrared4) )
                    (tag t63  (do_mission Phenomenon77 image2) )
                    (tag t64  (do_mission Phenomenon78 image0) )
                    (tag t65  (do_mission Phenomenon79 spectrograph3) )
                    (tag t66  (do_mission Phenomenon80 infrared4) )
                    (tag t67  (do_mission Planet81 infrared4) )
                    (tag t68  (do_mission Phenomenon82 infrared4) )
                    (tag t69  (do_mission Phenomenon83 spectrograph3) )
                    (tag t70  (do_mission Planet84 image0) )
                    (tag t71  (do_mission Star85 infrared4) )
                    (tag t72  (do_mission Planet86 thermograph1) )
                    (tag t73  (do_mission Star87 image2) )
                    (tag t74  (do_mission Star88 image0) )
                    (tag t75  (do_mission Star89 infrared4) )
                    (tag t76  (do_mission Planet90 image0) )
                    (tag t77  (do_mission Planet92 image2) )
                    (tag t78  (do_mission Star93 thermograph1) )
                    (tag t79  (do_mission Phenomenon94 image0) )
                    (tag t80  (do_mission Phenomenon96 image0) )
                    (tag t81  (do_mission Star97 infrared4) )
                    (tag t82  (do_mission Star98 image0) )
                    (tag t83  (do_mission Star99 infrared4) )
                    (tag t84  (do_mission Planet100 spectrograph3) ) 
                    (tag t85  (do_mission Planet101 image0) )
                    (tag t86  (do_mission Phenomenon102 spectrograph3) )
                    (tag t87  (do_mission Phenomenon103 thermograph1) )
                    (tag t88  (do_mission Star104 spectrograph3) )
                    (tag t89  (do_mission Star105 image0) )
                    (tag t90  (do_mission Planet106 thermograph1) )
                    (tag t91  (do_mission Star107 image0) )
                    (tag t92  (do_mission Planet108 image2) )
                    (tag t93  (do_mission Phenomenon109 image0) )
                    (tag t94  (do_mission Star110 infrared4) )
                    (tag t95  (do_mission Star111 spectrograph3) )
                    (tag t96  (do_mission Planet112 spectrograph3) )
                    (tag t97  (do_mission Phenomenon113 infrared4) )
                    (tag t98  (do_mission Star115 spectrograph3) )
                    (tag t99  (do_mission Planet116 thermograph1) )
                    (tag t100 (do_mission Planet117 image2) )
                    (tag t101 (do_mission Star118 spectrograph3) )
                    (tag t102 (do_mission Star119 infrared4) )
                    (tag t103 (do_mission Planet120 spectrograph3) )
                    (tag t104 (do_mission Phenomenon121 image0) )
                    (tag t105 (do_mission Phenomenon122 image2) )
                    (tag t106 (do_mission Phenomenon124 image2) )
                    (tag t107 (do_mission Phenomenon125 image0) )
                    (tag t108 (do_mission Phenomenon126 infrared4) )
                    (tag t109 (do_mission Planet128 image0) )
                    (tag t110 (do_mission Planet129 image2) )
                    (tag t111 (do_mission Planet130 thermograph1) )
                    (tag t112 (do_mission Planet131 image2) )
                    (tag t113 (do_mission Phenomenon132 spectrograph3) )
                    (tag t114 (do_mission Star133 spectrograph3) )
                    (tag t115 (do_mission Star134 infrared4) )
                    (tag t116 (do_mission Star135 image2) )
                    (tag t117 (do_mission Phenomenon136 image2) )
                    (tag t118 (do_mission Planet137 infrared4) )
                    (tag t119 (do_mission Star138 image2) )
                    (tag t120 (do_mission Planet139 spectrograph3) )
                    (tag t121 (do_mission Phenomenon141 thermograph1) )
                    (tag t122 (do_mission Star142 thermograph1) )
                    (tag t123 (do_mission Phenomenon143 image2) )
                    (tag t124 (do_mission Planet144 infrared4) ) 
                    (tag t125 (do_mission Planet145 image0) )
                    (tag t126 (do_mission Planet146 thermograph1) )
                    (tag t127 (do_mission Star147 image0) )
                    (tag t128 (do_mission Planet148 infrared4) )
                    (tag t129 (do_mission Planet150 thermograph1) )
                    (tag t130 (do_mission Planet151 image0) )
                    (tag t131 (do_mission Planet152 spectrograph3) )
                    (tag t132 (do_mission Planet153 spectrograph3) )
                    (tag t133 (do_mission Star154 thermograph1) )
                    (tag t134 (do_mission Star155 image2) )
                    (tag t135 (do_mission Star156 image0) )
                    (tag t136 (do_mission Planet157 image2) )
                    (tag t137 (do_mission Star158 image0) )
                    (tag t138 (do_mission Planet159 image0) )
                    (tag t139 (do_mission Planet160 spectrograph3) )
                    (tag t140 (do_mission Planet161 thermograph1) )
                    (tag t141 (do_mission Phenomenon162 spectrograph3) )
                    (tag t142 (do_mission Star163 image2) )
                    (tag t143 (do_mission Star166 image0) )
                    (tag t144 (do_mission Planet168 spectrograph3) )
                    (tag t145 (do_mission Planet169 image2) )
                    (tag t146 (do_mission Planet170 infrared4) )
                    (tag t147 (do_mission Phenomenon171 thermograph1) )
                    (tag t148 (do_mission Phenomenon172 image0) )
                    (tag t149 (do_mission Phenomenon173 image2) )
                    (tag t150 (do_mission Phenomenon174 thermograph1) )
                    (tag t151 (do_mission Planet175 image2) )
                    (tag t152 (do_mission Planet176 spectrograph3) )
                    (tag t153 (do_mission Phenomenon177 infrared4) )
                    (tag t154 (do_mission Phenomenon178 thermograph1) )
                    (tag t155 (do_mission Planet179 infrared4) )
                    (tag t156 (do_mission Star181 thermograph1) )
                    (tag t157 (do_mission Planet182 infrared4) )
                    (tag t158 (do_mission Star183 thermograph1) )
                    (tag t159 (do_mission Planet185 image0) )
                    (tag t160 (do_mission Planet186 image2) )
                    (tag t161 (do_mission Planet188 image0) )
                    (tag t162 (do_mission Star189 thermograph1) )
                    (tag t163 (do_mission Planet190 image0) )
                    (tag t164 (do_mission Phenomenon191 image0) ) 
                    (tag t165 (do_mission Planet192 image0) )
                    (tag t166 (do_mission Planet193 thermograph1) )
                    (tag t167 (do_mission Planet194 thermograph1) )
                    (tag t168 (do_mission Phenomenon195 spectrograph3) )
                    (tag t169 (do_mission Star196 infrared4) )
                    (tag t170 (do_mission Planet198 infrared4) )
                    (tag t171 (do_mission Phenomenon199 image2) )
                    (tag t172 (do_mission Star200 image2) )
                    (tag t173 (do_mission Planet202 image2) )
                    (tag t174 (do_mission Phenomenon203 thermograph1) )
                    (tag t175 (do_mission Star204 infrared4) )
                    (tag t176 (do_turning satellite1 Star142) )
                    (tag t177 (do_turning satellite4 Phenomenon78) )
                    (tag t178 (do_turning satellite7 Planet26) )
                    
                )
        :constraints(and
                        (after (and 
                                    (have_image Phenomenon5 thermograph1)
                                    (have_image Planet6 infrared4)
                                    (have_image Planet7 image0)
                                    (have_image Planet8 thermograph1)
                                    (have_image Phenomenon9 image2)
                                    (have_image Planet10 image0)
                                    (have_image Planet11 infrared4)
                                    (have_image Star12 image0)
                                    (have_image Star13 image0)
                                    (have_image Star14 thermograph1)
                                    (have_image Star15 image0)
                                    (have_image Star16 thermograph1)
                                    (have_image Phenomenon17 infrared4)
                                    (have_image Phenomenon18 spectrograph3)
                                    (have_image Star20 image0)
                                    (have_image Planet21 thermograph1)
                                    (have_image Planet22 image2)
                                    (have_image Phenomenon23 image0)
                                    (have_image Star24 infrared4)
                                    (have_image Planet26 infrared4)
                                    (have_image Star27 image2)
                                    (have_image Phenomenon28 image2)
                                    (have_image Planet29 image0)
                                    (have_image Planet31 spectrograph3)
                                    (have_image Star32 image0)
                                    (have_image Phenomenon33 spectrograph3)
                                    (have_image Star34 image0)
                                    (have_image Phenomenon35 image2)
                                    (have_image Phenomenon36 infrared4)
                                    (have_image Phenomenon37 image2)
                                    (have_image Star38 thermograph1)
                                    (have_image Phenomenon39 image2)
                                    (have_image Planet40 image0)
                                    (have_image Planet41 thermograph1)
                                    (have_image Star42 infrared4)
                                    (have_image Star44 thermograph1)
                                    (have_image Phenomenon45 thermograph1)
                                    (have_image Phenomenon46 image0)
                                    (have_image Planet48 spectrograph3)
                                    (have_image Planet49 thermograph1)
                                    (have_image Phenomenon51 infrared4)
                                    (have_image Star52 infrared4)
                                    (have_image Star53 image0)
                                    (have_image Star54 spectrograph3)
                                    (have_image Phenomenon55 image0)
                                    (have_image Star56 infrared4)
                                    (have_image Phenomenon57 thermograph1)
                                    (have_image Star58 thermograph1)
                                    (have_image Planet59 infrared4)
                                    (have_image Phenomenon60 infrared4)
                                    (have_image Phenomenon61 infrared4)
                                    (have_image Star62 infrared4)
                                    (have_image Phenomenon63 infrared4)
                                    (have_image Planet64 image2)
                                    (have_image Phenomenon65 spectrograph3)
                                    (have_image Planet67 image2)
                                    (have_image Phenomenon68 spectrograph3)
                                    (have_image Phenomenon70 spectrograph3)
                                    (have_image Planet72 image2)
                                    (have_image Phenomenon73 image2)
                                    (have_image Phenomenon74 spectrograph3)
                                    (have_image Planet75 infrared4)
                                    (have_image Phenomenon77 image2)
                                    (have_image Phenomenon78 image0)
                                    (have_image Phenomenon79 spectrograph3)
                                    (have_image Phenomenon80 infrared4)
                                    (have_image Planet81 infrared4)
                                    (have_image Phenomenon82 infrared4)
                                    (have_image Phenomenon83 spectrograph3)
                                    (have_image Planet84 image0)
                                    (have_image Star85 infrared4)
                                    (have_image Planet86 thermograph1)
                                    (have_image Star87 image2)
                                    (have_image Star88 image0)
                                    (have_image Star89 infrared4)
                                    (have_image Planet90 image0)
                                    (have_image Planet92 image2)
                                    (have_image Star93 thermograph1)
                                    (have_image Phenomenon94 image0)
                                    (have_image Phenomenon96 image0)
                                    (have_image Star97 infrared4)
                                    (have_image Star98 image0)
                                    (have_image Star99 infrared4)
                                    (have_image Planet100 spectrograph3)
                                    (have_image Planet101 image0)
                                    (have_image Phenomenon102 spectrograph3)
                                    (have_image Phenomenon103 thermograph1)
                                    (have_image Star104 spectrograph3)
                                    (have_image Star105 image0)
                                    (have_image Planet106 thermograph1)
                                    (have_image Star107 image0)
                                    (have_image Planet108 image2)
                                    (have_image Phenomenon109 image0)
                                    (have_image Star110 infrared4)
                                    (have_image Star111 spectrograph3)
                                    (have_image Planet112 spectrograph3)
                                    (have_image Phenomenon113 infrared4)
                                    (have_image Star115 spectrograph3)
                                    (have_image Planet116 thermograph1)
                                    (have_image Planet117 image2)
                                    (have_image Star118 spectrograph3)
                                    (have_image Star119 infrared4)
                                    (have_image Planet120 spectrograph3)
                                    (have_image Phenomenon121 image0)
                                    (have_image Phenomenon122 image2)
                                    (have_image Phenomenon124 image2)
                                    (have_image Phenomenon125 image0)
                                    (have_image Phenomenon126 infrared4)
                                    (have_image Planet128 image0)
                                    (have_image Planet129 image2)
                                    (have_image Planet130 thermograph1)
                                    (have_image Planet131 image2)
                                    (have_image Phenomenon132 spectrograph3)
                                    (have_image Star133 spectrograph3)
                                    (have_image Star134 infrared4)
                                    (have_image Star135 image2)
                                    (have_image Phenomenon136 image2)
                                    (have_image Planet137 infrared4)
                                    (have_image Star138 image2)
                                    (have_image Planet139 spectrograph3)
                                    (have_image Phenomenon141 thermograph1)
                                    (have_image Star142 thermograph1)
                                    (have_image Phenomenon143 image2)
                                    (have_image Planet144 infrared4)
                                    (have_image Planet145 image0)
                                    (have_image Planet146 thermograph1)
                                    (have_image Star147 image0)
                                    (have_image Planet148 infrared4)
                                    (have_image Planet150 thermograph1)
                                    (have_image Planet151 image0)
                                    (have_image Planet152 spectrograph3)
                                    (have_image Planet153 spectrograph3)
                                    (have_image Star154 thermograph1)
                                    (have_image Star155 image2)
                                    (have_image Star156 image0)
                                    (have_image Planet157 image2)
                                    (have_image Star158 image0)
                                    (have_image Planet159 image0)
                                    (have_image Planet160 spectrograph3)
                                    (have_image Planet161 thermograph1)
                                    (have_image Phenomenon162 spectrograph3)
                                    (have_image Star163 image2)
                                    (have_image Star166 image0)
                                    (have_image Planet168 spectrograph3)
                                    (have_image Planet169 image2)
                                    (have_image Planet170 infrared4)
                                    (have_image Phenomenon171 thermograph1)
                                    (have_image Phenomenon172 image0)
                                    (have_image Phenomenon173 image2)
                                    (have_image Phenomenon174 thermograph1)
                                    (have_image Planet175 image2)
                                    (have_image Planet176 spectrograph3)
                                    (have_image Phenomenon177 infrared4)
                                    (have_image Phenomenon178 thermograph1)
                                    (have_image Planet179 infrared4)
                                    (have_image Star181 thermograph1)
                                    (have_image Planet182 infrared4)
                                    (have_image Star183 thermograph1)
                                    (have_image Planet185 image0)
                                    (have_image Planet186 image2)
                                    (have_image Planet188 image0)
                                    (have_image Star189 thermograph1)
                                    (have_image Planet190 image0)
                                    (have_image Phenomenon191 image0)
                                    (have_image Planet192 image0)
                                    (have_image Planet193 thermograph1)
                                    (have_image Planet194 thermograph1)
                                    (have_image Phenomenon195 spectrograph3)
                                    (have_image Star196 infrared4)
                                    (have_image Planet198 infrared4)
                                    (have_image Phenomenon199 image2)
                                    (have_image Star200 image2)
                                    (have_image Planet202 image2)
                                    (have_image Phenomenon203 thermograph1)
                                    (have_image Star204 infrared4)
                                    (pointing satellite1 Star142)
                                    (pointing satellite4 Phenomenon78)
                                    (pointing satellite7 Planet26)
                                ) t178)
                    )
)
