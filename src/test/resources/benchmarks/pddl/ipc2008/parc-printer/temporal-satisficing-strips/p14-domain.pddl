;; PARC's modular printer domain
;; compiled into PDDL by Rong Zhou
;; To report a problem, send email to rzhou@parc.com
;; Papers:
;; 1. Planning for Modular Printers: Beyond Productivity
;;	Minh B. Do, Wheeler Ruml, and Rong Zhou. ICAPS'08
;; 2. On-line Planning and Scheduling: An Application to Controlling Modular Printers
;;	Minh B. Do, Wheeler Ruml, and Rong Zhou. AAAI'08
;; 3. On-line Planning and Scheduling for High-speed Manufacturing
;;	Wheeler Ruml, Minh B. Do, and Markus P.J. Fromherz. ICAPS'05
(define (domain eTipp)
(:requirements :typing :durative-actions)
(:types  size_t location_t side_t color_t image_t timepoint_t resource_t action_t sheet_t)
(:constants
		Letter - size_t

		Black
		Color - color_t

		Front
		Back - side_t

		Some_Feeder_Tray
		Some_Finisher_Tray
		fe1_Exit-im1_FeedEntry
		rh1_Exit-im1_ReturnEntry
		uc1_Entry-im1_TopExit
		im1_BottomExit-lc1_Entry
		ube_Entry-uc1_OffRamp
		uc1_OnRamp-ube_Exit
		uc2_Entry-uc1_Exit
		lbe_Entry-lc1_OffRamp
		lc1_OnRamp-lbe_Exit
		lc1_Exit-lc2_Entry
		rh1_Entry-rh2_Exit
		ure_Entry-uc2_OffRamp
		ure_Exit-uc2_OnRamp
		uc2_Exit-om_TopEntry
		ure_RodanTray1
		ure_RodanTray2
		lre_Entry-lc2_OffRamp
		lc2_OnRamp-lre_Exit
		om_BottomEntry-lc2_Exit
		lre_RodanTray1
		lre_RodanTray2
		om_ReturnExit-rh2_Entry
		om_OutputExit-sys_Entry
		sys_OutputTray - location_t

		fe1-FeedMSI-Letter-T0
		fe1-Feed-Letter-T0
		im1-MoveUpper-Letter-T1
		im1-MoveUpper-Letter-T2
		im1-MoveLower-Letter-T1
		im1-MoveLower-Letter-T2
		im1-LoopUpper-Letter-T1
		im1-LoopUpper-Letter-T2
		im1-LoopLower-Letter-T1
		im1-LoopLower-Letter-T2
		uc1-fMove-Letter-T1
		uc1-fMove-Letter-T2
		uc1-Divert-Letter-T0
		uc1-Merge-Letter-T1
		uc1-MergeInvert-Letter-T1
		ube-Simplex-Letter-T1
		ube-Simplex-Letter-T2
		lc1-fMove-Letter-T1
		lc1-fMove-Letter-T2
		lc1-Divert-Letter-T0
		lc1-Merge-Letter-T1
		lc1-MergeInvert-Letter-T1
		lbe-Simplex-Letter-T1
		lbe-Simplex-Letter-T2
		rh1-ReturnMove-Letter-T0
		uc2-fMove-Letter-T1
		uc2-fMove-Letter-T2
		uc2-Divert-Letter-T0
		uc2-Merge-Letter-T1
		uc2-MergeInvert-Letter-T1
		ure-Simplex-Letter-T1
		ure-SimplexMono-Letter-T1
		lc2-fMove-Letter-T1
		lc2-fMove-Letter-T2
		lc2-Divert-Letter-T0
		lc2-Merge-Letter-T1
		lc2-MergeInvert-Letter-T1
		lre-Simplex-Letter-T1
		lre-SimplexMono-Letter-T1
		rh2-ReturnMove-Letter-T0
		om-UpperOut-Letter-T1
		om-UpperOut-Letter-T2
		om-LowerOut-Letter-T1
		om-LowerOut-Letter-T2
		om-UpperReturn-Letter-T1
		om-UpperReturn-Letter-T2
		om-LowerReturn-Letter-T1
		om-LowerReturn-Letter-T2 - timepoint_t

		fe1_Nip-RSRC
		im1_FeedGate-RSRC
		im1_TopNip-RSRC
		im1_BottomNip-RSRC
		im1_ReturnGate-RSRC
		uc1_InputRoller-RSRC
		uc1_OutputRoller-RSRC
		uc1_Gate-RSRC
		ube_Drum-RSRC
		ube_Output-RSRC
		lc1_InputRoller-RSRC
		lc1_OutputRoller-RSRC
		lc1_Gate-RSRC
		lbe_Drum-RSRC
		lbe_Output-RSRC
		rh1_Roller-RSRC
		uc2_InputRoller-RSRC
		uc2_OutputRoller-RSRC
		uc2_Gate-RSRC
		ure_Drum-RSRC
		ure_Output-RSRC
		lc2_InputRoller-RSRC
		lc2_OutputRoller-RSRC
		lc2_Gate-RSRC
		lre_Drum-RSRC
		lre_Output-RSRC
		rh2_Roller-RSRC
		om_OutputNip-RSRC
		om_TopGate-RSRC
		om_BottomGate-RSRC
		om_ReturnNip-RSRC - resource_t

		fe1-FeedMSI-Letter
		fe1-Feed-Letter
		im1-MoveUpper-Letter
		im1-MoveLower-Letter
		im1-LoopUpper-Letter
		im1-LoopLower-Letter
		uc1-fMove-Letter
		uc1-Divert-Letter
		uc1-Merge-Letter
		uc1-MergeInvert-Letter
		ube-Simplex-Letter
		lc1-fMove-Letter
		lc1-Divert-Letter
		lc1-Merge-Letter
		lc1-MergeInvert-Letter
		lbe-Simplex-Letter
		rh1-ReturnMove-Letter
		uc2-fMove-Letter
		uc2-Divert-Letter
		uc2-Merge-Letter
		uc2-MergeInvert-Letter
		ure-Simplex-Letter
		ure-SimplexMono-Letter
		lc2-fMove-Letter
		lc2-Divert-Letter
		lc2-Merge-Letter
		lc2-MergeInvert-Letter
		lre-Simplex-Letter
		lre-SimplexMono-Letter
		rh2-ReturnMove-Letter
		om-UpperOut-Letter
		om-LowerOut-Letter
		om-UpperReturn-Letter
		om-LowerReturn-Letter - action_t
)
(:predicates
		(Sheetsize ?sheet - sheet_t ?size - size_t)
		(Location ?sheet - sheet_t ?location - location_t)
		(Hasimage ?sheet - sheet_t ?side - side_t ?image - image_t)
		(Sideup ?sheet - sheet_t ?side - side_t)
		(Stackedin ?sheet - sheet_t ?location - location_t)
		(Imagecolor ?image - image_t ?color - color_t)
		(Notprintedwith ?sheet - sheet_t ?side - side_t ?color - color_t)
		(Oppositeside ?side1 - side_t ?side2 - side_t)
		(Timepoint ?sheet - sheet_t ?timepoint - timepoint_t)
		(Hasallrsrcs ?sheet - sheet_t ?action - action_t)
		(Available ?resource - resource_t)
		(Prevsheet ?sheet1 - sheet_t ?sheet2 - sheet_t)
		(Uninitialized)

)
(:durative-action initialize
 :parameters ()
 :duration (= ?duration 1)
 :condition (and
		(at start (Uninitialized)))
 :effect (and
		(at start (not (Uninitialized)))
		(at start (Available fe1_Nip-RSRC))
		(at start (Available im1_FeedGate-RSRC))
		(at start (Available im1_TopNip-RSRC))
		(at start (Available im1_BottomNip-RSRC))
		(at start (Available im1_ReturnGate-RSRC))
		(at start (Available uc1_InputRoller-RSRC))
		(at start (Available uc1_OutputRoller-RSRC))
		(at start (Available uc1_Gate-RSRC))
		(at start (Available ube_Drum-RSRC))
		(at start (Available ube_Output-RSRC))
		(at start (Available lc1_InputRoller-RSRC))
		(at start (Available lc1_OutputRoller-RSRC))
		(at start (Available lc1_Gate-RSRC))
		(at start (Available lbe_Drum-RSRC))
		(at start (Available lbe_Output-RSRC))
		(at start (Available rh1_Roller-RSRC))
		(at start (Available uc2_InputRoller-RSRC))
		(at start (Available uc2_OutputRoller-RSRC))
		(at start (Available uc2_Gate-RSRC))
		(at start (Available ure_Drum-RSRC))
		(at start (Available ure_Output-RSRC))
		(at start (Available lc2_InputRoller-RSRC))
		(at start (Available lc2_OutputRoller-RSRC))
		(at start (Available lc2_Gate-RSRC))
		(at start (Available lre_Drum-RSRC))
		(at start (Available lre_Output-RSRC))
		(at start (Available rh2_Roller-RSRC))
		(at start (Available om_OutputNip-RSRC))
		(at start (Available om_TopGate-RSRC))
		(at start (Available om_BottomGate-RSRC))
		(at start (Available om_ReturnNip-RSRC)))
)
(:durative-action fe1-FeedMSI-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 500)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Some_Feeder_Tray))
		(at start (Available fe1_Nip-RSRC)))
 :effect (and
		(at start (not (Location ?sheet Some_Feeder_Tray)))
		(at start (not (Available fe1_Nip-RSRC)))
		(at start (Hasallrsrcs ?sheet fe1-FeedMSI-Letter))
		(at start (Sideup ?sheet Back))
		(at end (Location ?sheet fe1_Exit-im1_FeedEntry)))
)
(:durative-action fe1-FeedMSI-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 5999)
 :condition (and
		(at start (Hasallrsrcs ?sheet fe1-FeedMSI-Letter)))
 :effect (and

		(at end (Available fe1_Nip-RSRC))
		(at end (not (Hasallrsrcs ?sheet fe1-FeedMSI-Letter))))
)
(:durative-action fe1-Feed-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 899)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Some_Feeder_Tray))
		(at start (Available fe1_Nip-RSRC)))
 :effect (and
		(at start (not (Location ?sheet Some_Feeder_Tray)))
		(at start (not (Available fe1_Nip-RSRC)))
		(at start (Hasallrsrcs ?sheet fe1-Feed-Letter))
		(at start (Sideup ?sheet Back))
		(at end (Location ?sheet fe1_Exit-im1_FeedEntry)))
)
(:durative-action fe1-Feed-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 5999)
 :condition (and
		(at start (Hasallrsrcs ?sheet fe1-Feed-Letter)))
 :effect (and

		(at end (Available fe1_Nip-RSRC))
		(at end (not (Hasallrsrcs ?sheet fe1-Feed-Letter))))
)
(:durative-action im1-MoveUpper-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 502)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet fe1_Exit-im1_FeedEntry))
		(at start (Available im1_FeedGate-RSRC)))
 :effect (and
		(at start (not (Location ?sheet fe1_Exit-im1_FeedEntry)))
		(at start (not (Available im1_FeedGate-RSRC)))
		(at end (Timepoint ?sheet im1-MoveUpper-Letter-T1)))
)
(:durative-action im1-MoveUpper-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 7668)
 :condition (and
		(at start (Timepoint ?sheet im1-MoveUpper-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet im1-MoveUpper-Letter-T1)))
		(at start (Available im1_FeedGate-RSRC))
		(at end (Timepoint ?sheet im1-MoveUpper-Letter-T2)))
)
(:durative-action im1-MoveUpper-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet im1-MoveUpper-Letter-T2))
		(at start (Available im1_TopNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet im1-MoveUpper-Letter-T2)))
		(at start (not (Available im1_TopNip-RSRC)))
		(at start (Hasallrsrcs ?sheet im1-MoveUpper-Letter))
		(at end (Location ?sheet uc1_Entry-im1_TopExit)))
)
(:durative-action im1-MoveUpper-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet im1-MoveUpper-Letter)))
 :effect (and

		(at end (Available im1_TopNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet im1-MoveUpper-Letter))))
)
(:durative-action im1-MoveLower-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 502)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet fe1_Exit-im1_FeedEntry))
		(at start (Available im1_FeedGate-RSRC)))
 :effect (and
		(at start (not (Location ?sheet fe1_Exit-im1_FeedEntry)))
		(at start (not (Available im1_FeedGate-RSRC)))
		(at end (Timepoint ?sheet im1-MoveLower-Letter-T1)))
)
(:durative-action im1-MoveLower-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2585)
 :condition (and
		(at start (Timepoint ?sheet im1-MoveLower-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet im1-MoveLower-Letter-T1)))
		(at start (Available im1_FeedGate-RSRC))
		(at end (Timepoint ?sheet im1-MoveLower-Letter-T2)))
)
(:durative-action im1-MoveLower-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet im1-MoveLower-Letter-T2))
		(at start (Available im1_BottomNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet im1-MoveLower-Letter-T2)))
		(at start (not (Available im1_BottomNip-RSRC)))
		(at start (Hasallrsrcs ?sheet im1-MoveLower-Letter))
		(at end (Location ?sheet im1_BottomExit-lc1_Entry)))
)
(:durative-action im1-MoveLower-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet im1-MoveLower-Letter)))
 :effect (and

		(at end (Available im1_BottomNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet im1-MoveLower-Letter))))
)
(:durative-action im1-LoopUpper-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 502)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet rh1_Exit-im1_ReturnEntry))
		(at start (Available im1_ReturnGate-RSRC)))
 :effect (and
		(at start (not (Location ?sheet rh1_Exit-im1_ReturnEntry)))
		(at start (not (Available im1_ReturnGate-RSRC)))
		(at end (Timepoint ?sheet im1-LoopUpper-Letter-T1)))
)
(:durative-action im1-LoopUpper-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 7662)
 :condition (and
		(at start (Timepoint ?sheet im1-LoopUpper-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet im1-LoopUpper-Letter-T1)))
		(at start (Available im1_ReturnGate-RSRC))
		(at end (Timepoint ?sheet im1-LoopUpper-Letter-T2)))
)
(:durative-action im1-LoopUpper-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet im1-LoopUpper-Letter-T2))
		(at start (Available im1_TopNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet im1-LoopUpper-Letter-T2)))
		(at start (not (Available im1_TopNip-RSRC)))
		(at start (Hasallrsrcs ?sheet im1-LoopUpper-Letter))
		(at end (Location ?sheet uc1_Entry-im1_TopExit)))
)
(:durative-action im1-LoopUpper-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet im1-LoopUpper-Letter)))
 :effect (and

		(at end (Available im1_TopNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet im1-LoopUpper-Letter))))
)
(:durative-action im1-LoopLower-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 502)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet rh1_Exit-im1_ReturnEntry))
		(at start (Available im1_ReturnGate-RSRC)))
 :effect (and
		(at start (not (Location ?sheet rh1_Exit-im1_ReturnEntry)))
		(at start (not (Available im1_ReturnGate-RSRC)))
		(at end (Timepoint ?sheet im1-LoopLower-Letter-T1)))
)
(:durative-action im1-LoopLower-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2629)
 :condition (and
		(at start (Timepoint ?sheet im1-LoopLower-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet im1-LoopLower-Letter-T1)))
		(at start (Available im1_ReturnGate-RSRC))
		(at end (Timepoint ?sheet im1-LoopLower-Letter-T2)))
)
(:durative-action im1-LoopLower-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet im1-LoopLower-Letter-T2))
		(at start (Available im1_BottomNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet im1-LoopLower-Letter-T2)))
		(at start (not (Available im1_BottomNip-RSRC)))
		(at start (Hasallrsrcs ?sheet im1-LoopLower-Letter))
		(at end (Location ?sheet im1_BottomExit-lc1_Entry)))
)
(:durative-action im1-LoopLower-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet im1-LoopLower-Letter)))
 :effect (and

		(at end (Available im1_BottomNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet im1-LoopLower-Letter))))
)
(:durative-action uc1-fMove-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet uc1_Entry-im1_TopExit))
		(at start (Available uc1_InputRoller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet uc1_Entry-im1_TopExit)))
		(at start (not (Available uc1_InputRoller-RSRC)))
		(at end (Timepoint ?sheet uc1-fMove-Letter-T1)))
)
(:durative-action uc1-fMove-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 10488)
 :condition (and
		(at start (Timepoint ?sheet uc1-fMove-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet uc1-fMove-Letter-T1)))
		(at start (Available uc1_InputRoller-RSRC))
		(at end (Timepoint ?sheet uc1-fMove-Letter-T2)))
)
(:durative-action uc1-fMove-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet uc1-fMove-Letter-T2))
		(at start (Available uc1_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet uc1-fMove-Letter-T2)))
		(at start (not (Available uc1_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet uc1-fMove-Letter))
		(at end (Location ?sheet uc2_Entry-uc1_Exit)))
)
(:durative-action uc1-fMove-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet uc1-fMove-Letter)))
 :effect (and

		(at end (Available uc1_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet uc1-fMove-Letter))))
)
(:durative-action uc1-Divert-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 11805)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet uc1_Entry-im1_TopExit))
		(at start (Sideup ?sheet ?face))
		(at start (Available uc1_Gate-RSRC))
		(at start (Available uc1_InputRoller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet uc1_Entry-im1_TopExit)))
		(at start (not (Sideup ?sheet ?face)))
		(at start (not (Available uc1_Gate-RSRC)))
		(at start (not (Available uc1_InputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet uc1-Divert-Letter))
		(at start (Sideup ?sheet ?otherface))
		(at end (Location ?sheet ube_Entry-uc1_OffRamp)))
)
(:durative-action uc1-Divert-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet uc1-Divert-Letter)))
 :effect (and

		(at end (Available uc1_InputRoller-RSRC)))
)
(:durative-action uc1-Divert-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 8999)
 :condition (and
		(at start (Hasallrsrcs ?sheet uc1-Divert-Letter)))
 :effect (and

		(at end (Available uc1_Gate-RSRC))
		(at end (not (Hasallrsrcs ?sheet uc1-Divert-Letter))))
)
(:durative-action uc1-Merge-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 27709)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet uc1_OnRamp-ube_Exit)))
 :effect (and
		(at start (not (Location ?sheet uc1_OnRamp-ube_Exit)))
		(at end (Timepoint ?sheet uc1-Merge-Letter-T1)))
)
(:durative-action uc1-Merge-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet uc1-Merge-Letter-T1))
		(at start (Available uc1_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet uc1-Merge-Letter-T1)))
		(at start (not (Available uc1_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet uc1-Merge-Letter))
		(at end (Location ?sheet uc2_Entry-uc1_Exit)))
)
(:durative-action uc1-Merge-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet uc1-Merge-Letter)))
 :effect (and

		(at end (Available uc1_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet uc1-Merge-Letter))))
)
(:durative-action uc1-MergeInvert-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 28119)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet uc1_OnRamp-ube_Exit))
		(at start (Sideup ?sheet ?face)))
 :effect (and
		(at start (not (Location ?sheet uc1_OnRamp-ube_Exit)))
		(at start (not (Sideup ?sheet ?face)))
		(at start (Sideup ?sheet ?otherface))
		(at end (Timepoint ?sheet uc1-MergeInvert-Letter-T1)))
)
(:durative-action uc1-MergeInvert-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet uc1-MergeInvert-Letter-T1))
		(at start (Available uc1_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet uc1-MergeInvert-Letter-T1)))
		(at start (not (Available uc1_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet uc1-MergeInvert-Letter))
		(at end (Location ?sheet uc2_Entry-uc1_Exit)))
)
(:durative-action uc1-MergeInvert-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet uc1-MergeInvert-Letter)))
 :effect (and

		(at end (Available uc1_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet uc1-MergeInvert-Letter))))
)
(:durative-action ube-Simplex-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 10909)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black))
		(at start (Location ?sheet ube_Entry-uc1_OffRamp))
		(at start (Notprintedwith ?sheet ?face Black))
		(at start (Available ube_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet ube_Entry-uc1_OffRamp)))
		(at start (not (Notprintedwith ?sheet ?face Black)))
		(at start (not (Available ube_Drum-RSRC)))
		(at end (Timepoint ?sheet ube-Simplex-Letter-T1)))
)
(:durative-action ube-Simplex-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 12839)
 :condition (and
		(at start (Timepoint ?sheet ube-Simplex-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet ube-Simplex-Letter-T1)))
		(at start (Available ube_Drum-RSRC))
		(at end (Timepoint ?sheet ube-Simplex-Letter-T2)))
)
(:durative-action ube-Simplex-Letter-2
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet ube-Simplex-Letter-T2))
		(at start (Available ube_Output-RSRC))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black)))
 :effect (and
		(at start (not (Timepoint ?sheet ube-Simplex-Letter-T2)))
		(at start (not (Available ube_Output-RSRC)))
		(at start (Hasallrsrcs ?sheet ube-Simplex-Letter))
		(at end (Location ?sheet uc1_OnRamp-ube_Exit))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action ube-Simplex-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 10910)
 :condition (and
		(at start (Hasallrsrcs ?sheet ube-Simplex-Letter)))
 :effect (and

		(at end (Available ube_Output-RSRC))
		(at end (not (Hasallrsrcs ?sheet ube-Simplex-Letter))))
)
(:durative-action lc1-fMove-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet im1_BottomExit-lc1_Entry))
		(at start (Available lc1_InputRoller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet im1_BottomExit-lc1_Entry)))
		(at start (not (Available lc1_InputRoller-RSRC)))
		(at end (Timepoint ?sheet lc1-fMove-Letter-T1)))
)
(:durative-action lc1-fMove-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 10488)
 :condition (and
		(at start (Timepoint ?sheet lc1-fMove-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet lc1-fMove-Letter-T1)))
		(at start (Available lc1_InputRoller-RSRC))
		(at end (Timepoint ?sheet lc1-fMove-Letter-T2)))
)
(:durative-action lc1-fMove-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet lc1-fMove-Letter-T2))
		(at start (Available lc1_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet lc1-fMove-Letter-T2)))
		(at start (not (Available lc1_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet lc1-fMove-Letter))
		(at end (Location ?sheet lc1_Exit-lc2_Entry)))
)
(:durative-action lc1-fMove-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet lc1-fMove-Letter)))
 :effect (and

		(at end (Available lc1_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet lc1-fMove-Letter))))
)
(:durative-action lc1-Divert-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 11805)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet im1_BottomExit-lc1_Entry))
		(at start (Sideup ?sheet ?face))
		(at start (Available lc1_Gate-RSRC))
		(at start (Available lc1_InputRoller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet im1_BottomExit-lc1_Entry)))
		(at start (not (Sideup ?sheet ?face)))
		(at start (not (Available lc1_Gate-RSRC)))
		(at start (not (Available lc1_InputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet lc1-Divert-Letter))
		(at start (Sideup ?sheet ?otherface))
		(at end (Location ?sheet lbe_Entry-lc1_OffRamp)))
)
(:durative-action lc1-Divert-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet lc1-Divert-Letter)))
 :effect (and

		(at end (Available lc1_InputRoller-RSRC)))
)
(:durative-action lc1-Divert-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 8999)
 :condition (and
		(at start (Hasallrsrcs ?sheet lc1-Divert-Letter)))
 :effect (and

		(at end (Available lc1_Gate-RSRC))
		(at end (not (Hasallrsrcs ?sheet lc1-Divert-Letter))))
)
(:durative-action lc1-Merge-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 27709)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet lc1_OnRamp-lbe_Exit)))
 :effect (and
		(at start (not (Location ?sheet lc1_OnRamp-lbe_Exit)))
		(at end (Timepoint ?sheet lc1-Merge-Letter-T1)))
)
(:durative-action lc1-Merge-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet lc1-Merge-Letter-T1))
		(at start (Available lc1_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet lc1-Merge-Letter-T1)))
		(at start (not (Available lc1_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet lc1-Merge-Letter))
		(at end (Location ?sheet lc1_Exit-lc2_Entry)))
)
(:durative-action lc1-Merge-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet lc1-Merge-Letter)))
 :effect (and

		(at end (Available lc1_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet lc1-Merge-Letter))))
)
(:durative-action lc1-MergeInvert-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 28119)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet lc1_OnRamp-lbe_Exit))
		(at start (Sideup ?sheet ?face)))
 :effect (and
		(at start (not (Location ?sheet lc1_OnRamp-lbe_Exit)))
		(at start (not (Sideup ?sheet ?face)))
		(at start (Sideup ?sheet ?otherface))
		(at end (Timepoint ?sheet lc1-MergeInvert-Letter-T1)))
)
(:durative-action lc1-MergeInvert-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet lc1-MergeInvert-Letter-T1))
		(at start (Available lc1_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet lc1-MergeInvert-Letter-T1)))
		(at start (not (Available lc1_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet lc1-MergeInvert-Letter))
		(at end (Location ?sheet lc1_Exit-lc2_Entry)))
)
(:durative-action lc1-MergeInvert-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet lc1-MergeInvert-Letter)))
 :effect (and

		(at end (Available lc1_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet lc1-MergeInvert-Letter))))
)
(:durative-action lbe-Simplex-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 10909)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black))
		(at start (Location ?sheet lbe_Entry-lc1_OffRamp))
		(at start (Notprintedwith ?sheet ?face Black))
		(at start (Available lbe_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet lbe_Entry-lc1_OffRamp)))
		(at start (not (Notprintedwith ?sheet ?face Black)))
		(at start (not (Available lbe_Drum-RSRC)))
		(at end (Timepoint ?sheet lbe-Simplex-Letter-T1)))
)
(:durative-action lbe-Simplex-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 12839)
 :condition (and
		(at start (Timepoint ?sheet lbe-Simplex-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet lbe-Simplex-Letter-T1)))
		(at start (Available lbe_Drum-RSRC))
		(at end (Timepoint ?sheet lbe-Simplex-Letter-T2)))
)
(:durative-action lbe-Simplex-Letter-2
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet lbe-Simplex-Letter-T2))
		(at start (Available lbe_Output-RSRC))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black)))
 :effect (and
		(at start (not (Timepoint ?sheet lbe-Simplex-Letter-T2)))
		(at start (not (Available lbe_Output-RSRC)))
		(at start (Hasallrsrcs ?sheet lbe-Simplex-Letter))
		(at end (Location ?sheet lc1_OnRamp-lbe_Exit))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action lbe-Simplex-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 10910)
 :condition (and
		(at start (Hasallrsrcs ?sheet lbe-Simplex-Letter)))
 :effect (and

		(at end (Available lbe_Output-RSRC))
		(at end (not (Hasallrsrcs ?sheet lbe-Simplex-Letter))))
)
(:durative-action rh1-ReturnMove-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 10869)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet rh1_Entry-rh2_Exit))
		(at start (Available rh1_Roller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet rh1_Entry-rh2_Exit)))
		(at start (not (Available rh1_Roller-RSRC)))
		(at start (Hasallrsrcs ?sheet rh1-ReturnMove-Letter))
		(at end (Location ?sheet rh1_Exit-im1_ReturnEntry)))
)
(:durative-action rh1-ReturnMove-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet rh1-ReturnMove-Letter)))
 :effect (and

		(at end (Available rh1_Roller-RSRC))
		(at end (not (Hasallrsrcs ?sheet rh1-ReturnMove-Letter))))
)
(:durative-action uc2-fMove-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet uc2_Entry-uc1_Exit))
		(at start (Available uc2_InputRoller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet uc2_Entry-uc1_Exit)))
		(at start (not (Available uc2_InputRoller-RSRC)))
		(at end (Timepoint ?sheet uc2-fMove-Letter-T1)))
)
(:durative-action uc2-fMove-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 10805)
 :condition (and
		(at start (Timepoint ?sheet uc2-fMove-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet uc2-fMove-Letter-T1)))
		(at start (Available uc2_InputRoller-RSRC))
		(at end (Timepoint ?sheet uc2-fMove-Letter-T2)))
)
(:durative-action uc2-fMove-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet uc2-fMove-Letter-T2))
		(at start (Available uc2_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet uc2-fMove-Letter-T2)))
		(at start (not (Available uc2_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet uc2-fMove-Letter))
		(at end (Location ?sheet uc2_Exit-om_TopEntry)))
)
(:durative-action uc2-fMove-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet uc2-fMove-Letter)))
 :effect (and

		(at end (Available uc2_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet uc2-fMove-Letter))))
)
(:durative-action uc2-Divert-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 17452)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet uc2_Entry-uc1_Exit))
		(at start (Sideup ?sheet ?face))
		(at start (Available uc2_Gate-RSRC))
		(at start (Available uc2_InputRoller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet uc2_Entry-uc1_Exit)))
		(at start (not (Sideup ?sheet ?face)))
		(at start (not (Available uc2_Gate-RSRC)))
		(at start (not (Available uc2_InputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet uc2-Divert-Letter))
		(at start (Sideup ?sheet ?otherface))
		(at end (Location ?sheet ure_Entry-uc2_OffRamp)))
)
(:durative-action uc2-Divert-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet uc2-Divert-Letter)))
 :effect (and

		(at end (Available uc2_InputRoller-RSRC)))
)
(:durative-action uc2-Divert-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 13500)
 :condition (and
		(at start (Hasallrsrcs ?sheet uc2-Divert-Letter)))
 :effect (and

		(at end (Available uc2_Gate-RSRC))
		(at end (not (Hasallrsrcs ?sheet uc2-Divert-Letter))))
)
(:durative-action uc2-Merge-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 78919)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet ure_Exit-uc2_OnRamp))
		(at start (Sideup ?sheet ?face)))
 :effect (and
		(at start (not (Location ?sheet ure_Exit-uc2_OnRamp)))
		(at start (not (Sideup ?sheet ?face)))
		(at start (Sideup ?sheet ?otherface))
		(at end (Timepoint ?sheet uc2-Merge-Letter-T1)))
)
(:durative-action uc2-Merge-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet uc2-Merge-Letter-T1))
		(at start (Available uc2_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet uc2-Merge-Letter-T1)))
		(at start (not (Available uc2_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet uc2-Merge-Letter))
		(at end (Location ?sheet uc2_Exit-om_TopEntry)))
)
(:durative-action uc2-Merge-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet uc2-Merge-Letter)))
 :effect (and

		(at end (Available uc2_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet uc2-Merge-Letter))))
)
(:durative-action uc2-MergeInvert-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 78919)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet ure_Exit-uc2_OnRamp)))
 :effect (and
		(at start (not (Location ?sheet ure_Exit-uc2_OnRamp)))
		(at end (Timepoint ?sheet uc2-MergeInvert-Letter-T1)))
)
(:durative-action uc2-MergeInvert-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet uc2-MergeInvert-Letter-T1))
		(at start (Available uc2_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet uc2-MergeInvert-Letter-T1)))
		(at start (not (Available uc2_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet uc2-MergeInvert-Letter))
		(at end (Location ?sheet uc2_Exit-om_TopEntry)))
)
(:durative-action uc2-MergeInvert-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet uc2-MergeInvert-Letter)))
 :effect (and

		(at end (Available uc2_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet uc2-MergeInvert-Letter))))
)
(:durative-action ure-Simplex-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 23749)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Color))
		(at start (Location ?sheet ure_Entry-uc2_OffRamp))
		(at start (Notprintedwith ?sheet ?face Color))
		(at start (Available ure_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet ure_Entry-uc2_OffRamp)))
		(at start (not (Notprintedwith ?sheet ?face Color)))
		(at start (not (Available ure_Drum-RSRC)))
		(at end (Timepoint ?sheet ure-Simplex-Letter-T1)))
)
(:durative-action ure-Simplex-Letter-1
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 3100)
 :condition (and
		(at start (Timepoint ?sheet ure-Simplex-Letter-T1))
		(at start (Available ure_Output-RSRC))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Color)))
 :effect (and
		(at start (not (Timepoint ?sheet ure-Simplex-Letter-T1)))
		(at start (not (Available ure_Output-RSRC)))
		(at start (Hasallrsrcs ?sheet ure-Simplex-Letter))
		(at end (Location ?sheet ure_Exit-uc2_OnRamp))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action ure-Simplex-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 6249)
 :condition (and
		(at start (Hasallrsrcs ?sheet ure-Simplex-Letter)))
 :effect (and

		(at end (Available ure_Drum-RSRC)))
)
(:durative-action ure-Simplex-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 11000)
 :condition (and
		(at start (Hasallrsrcs ?sheet ure-Simplex-Letter)))
 :effect (and

		(at end (Available ure_Output-RSRC))
		(at end (not (Hasallrsrcs ?sheet ure-Simplex-Letter))))
)
(:durative-action ure-SimplexMono-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 23749)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black))
		(at start (Location ?sheet ure_Entry-uc2_OffRamp))
		(at start (Notprintedwith ?sheet ?face Black))
		(at start (Available ure_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet ure_Entry-uc2_OffRamp)))
		(at start (not (Notprintedwith ?sheet ?face Black)))
		(at start (not (Available ure_Drum-RSRC)))
		(at end (Timepoint ?sheet ure-SimplexMono-Letter-T1)))
)
(:durative-action ure-SimplexMono-Letter-1
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 3100)
 :condition (and
		(at start (Timepoint ?sheet ure-SimplexMono-Letter-T1))
		(at start (Available ure_Output-RSRC))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black)))
 :effect (and
		(at start (not (Timepoint ?sheet ure-SimplexMono-Letter-T1)))
		(at start (not (Available ure_Output-RSRC)))
		(at start (Hasallrsrcs ?sheet ure-SimplexMono-Letter))
		(at end (Location ?sheet ure_Exit-uc2_OnRamp))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action ure-SimplexMono-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 6249)
 :condition (and
		(at start (Hasallrsrcs ?sheet ure-SimplexMono-Letter)))
 :effect (and

		(at end (Available ure_Drum-RSRC)))
)
(:durative-action ure-SimplexMono-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 11000)
 :condition (and
		(at start (Hasallrsrcs ?sheet ure-SimplexMono-Letter)))
 :effect (and

		(at end (Available ure_Output-RSRC))
		(at end (not (Hasallrsrcs ?sheet ure-SimplexMono-Letter))))
)
(:durative-action lc2-fMove-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet lc1_Exit-lc2_Entry))
		(at start (Available lc2_InputRoller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet lc1_Exit-lc2_Entry)))
		(at start (not (Available lc2_InputRoller-RSRC)))
		(at end (Timepoint ?sheet lc2-fMove-Letter-T1)))
)
(:durative-action lc2-fMove-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 10805)
 :condition (and
		(at start (Timepoint ?sheet lc2-fMove-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet lc2-fMove-Letter-T1)))
		(at start (Available lc2_InputRoller-RSRC))
		(at end (Timepoint ?sheet lc2-fMove-Letter-T2)))
)
(:durative-action lc2-fMove-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet lc2-fMove-Letter-T2))
		(at start (Available lc2_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet lc2-fMove-Letter-T2)))
		(at start (not (Available lc2_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet lc2-fMove-Letter))
		(at end (Location ?sheet om_BottomEntry-lc2_Exit)))
)
(:durative-action lc2-fMove-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet lc2-fMove-Letter)))
 :effect (and

		(at end (Available lc2_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet lc2-fMove-Letter))))
)
(:durative-action lc2-Divert-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 17452)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet lc1_Exit-lc2_Entry))
		(at start (Sideup ?sheet ?face))
		(at start (Available lc2_Gate-RSRC))
		(at start (Available lc2_InputRoller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet lc1_Exit-lc2_Entry)))
		(at start (not (Sideup ?sheet ?face)))
		(at start (not (Available lc2_Gate-RSRC)))
		(at start (not (Available lc2_InputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet lc2-Divert-Letter))
		(at start (Sideup ?sheet ?otherface))
		(at end (Location ?sheet lre_Entry-lc2_OffRamp)))
)
(:durative-action lc2-Divert-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet lc2-Divert-Letter)))
 :effect (and

		(at end (Available lc2_InputRoller-RSRC)))
)
(:durative-action lc2-Divert-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 13500)
 :condition (and
		(at start (Hasallrsrcs ?sheet lc2-Divert-Letter)))
 :effect (and

		(at end (Available lc2_Gate-RSRC))
		(at end (not (Hasallrsrcs ?sheet lc2-Divert-Letter))))
)
(:durative-action lc2-Merge-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 78919)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet lc2_OnRamp-lre_Exit))
		(at start (Sideup ?sheet ?face)))
 :effect (and
		(at start (not (Location ?sheet lc2_OnRamp-lre_Exit)))
		(at start (not (Sideup ?sheet ?face)))
		(at start (Sideup ?sheet ?otherface))
		(at end (Timepoint ?sheet lc2-Merge-Letter-T1)))
)
(:durative-action lc2-Merge-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet lc2-Merge-Letter-T1))
		(at start (Available lc2_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet lc2-Merge-Letter-T1)))
		(at start (not (Available lc2_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet lc2-Merge-Letter))
		(at end (Location ?sheet om_BottomEntry-lc2_Exit)))
)
(:durative-action lc2-Merge-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet lc2-Merge-Letter)))
 :effect (and

		(at end (Available lc2_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet lc2-Merge-Letter))))
)
(:durative-action lc2-MergeInvert-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 78919)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet lc2_OnRamp-lre_Exit)))
 :effect (and
		(at start (not (Location ?sheet lc2_OnRamp-lre_Exit)))
		(at end (Timepoint ?sheet lc2-MergeInvert-Letter-T1)))
)
(:durative-action lc2-MergeInvert-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet lc2-MergeInvert-Letter-T1))
		(at start (Available lc2_OutputRoller-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet lc2-MergeInvert-Letter-T1)))
		(at start (not (Available lc2_OutputRoller-RSRC)))
		(at start (Hasallrsrcs ?sheet lc2-MergeInvert-Letter))
		(at end (Location ?sheet om_BottomEntry-lc2_Exit)))
)
(:durative-action lc2-MergeInvert-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet lc2-MergeInvert-Letter)))
 :effect (and

		(at end (Available lc2_OutputRoller-RSRC))
		(at end (not (Hasallrsrcs ?sheet lc2-MergeInvert-Letter))))
)
(:durative-action lre-Simplex-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 23749)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Color))
		(at start (Location ?sheet lre_Entry-lc2_OffRamp))
		(at start (Notprintedwith ?sheet ?face Color))
		(at start (Available lre_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet lre_Entry-lc2_OffRamp)))
		(at start (not (Notprintedwith ?sheet ?face Color)))
		(at start (not (Available lre_Drum-RSRC)))
		(at end (Timepoint ?sheet lre-Simplex-Letter-T1)))
)
(:durative-action lre-Simplex-Letter-1
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 3100)
 :condition (and
		(at start (Timepoint ?sheet lre-Simplex-Letter-T1))
		(at start (Available lre_Output-RSRC))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Color)))
 :effect (and
		(at start (not (Timepoint ?sheet lre-Simplex-Letter-T1)))
		(at start (not (Available lre_Output-RSRC)))
		(at start (Hasallrsrcs ?sheet lre-Simplex-Letter))
		(at end (Location ?sheet lc2_OnRamp-lre_Exit))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action lre-Simplex-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 6249)
 :condition (and
		(at start (Hasallrsrcs ?sheet lre-Simplex-Letter)))
 :effect (and

		(at end (Available lre_Drum-RSRC)))
)
(:durative-action lre-Simplex-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 11000)
 :condition (and
		(at start (Hasallrsrcs ?sheet lre-Simplex-Letter)))
 :effect (and

		(at end (Available lre_Output-RSRC))
		(at end (not (Hasallrsrcs ?sheet lre-Simplex-Letter))))
)
(:durative-action lre-SimplexMono-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 23749)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black))
		(at start (Location ?sheet lre_Entry-lc2_OffRamp))
		(at start (Notprintedwith ?sheet ?face Black))
		(at start (Available lre_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet lre_Entry-lc2_OffRamp)))
		(at start (not (Notprintedwith ?sheet ?face Black)))
		(at start (not (Available lre_Drum-RSRC)))
		(at end (Timepoint ?sheet lre-SimplexMono-Letter-T1)))
)
(:durative-action lre-SimplexMono-Letter-1
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 3100)
 :condition (and
		(at start (Timepoint ?sheet lre-SimplexMono-Letter-T1))
		(at start (Available lre_Output-RSRC))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black)))
 :effect (and
		(at start (not (Timepoint ?sheet lre-SimplexMono-Letter-T1)))
		(at start (not (Available lre_Output-RSRC)))
		(at start (Hasallrsrcs ?sheet lre-SimplexMono-Letter))
		(at end (Location ?sheet lc2_OnRamp-lre_Exit))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action lre-SimplexMono-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 6249)
 :condition (and
		(at start (Hasallrsrcs ?sheet lre-SimplexMono-Letter)))
 :effect (and

		(at end (Available lre_Drum-RSRC)))
)
(:durative-action lre-SimplexMono-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 11000)
 :condition (and
		(at start (Hasallrsrcs ?sheet lre-SimplexMono-Letter)))
 :effect (and

		(at end (Available lre_Output-RSRC))
		(at end (not (Hasallrsrcs ?sheet lre-SimplexMono-Letter))))
)
(:durative-action rh2-ReturnMove-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 10869)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet om_ReturnExit-rh2_Entry))
		(at start (Available rh2_Roller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet om_ReturnExit-rh2_Entry)))
		(at start (not (Available rh2_Roller-RSRC)))
		(at start (Hasallrsrcs ?sheet rh2-ReturnMove-Letter))
		(at end (Location ?sheet rh1_Entry-rh2_Exit)))
)
(:durative-action rh2-ReturnMove-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet rh2-ReturnMove-Letter)))
 :effect (and

		(at end (Available rh2_Roller-RSRC))
		(at end (not (Hasallrsrcs ?sheet rh2-ReturnMove-Letter))))
)
(:durative-action om-UpperOut-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 502)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet uc2_Exit-om_TopEntry))
		(at start (Available om_TopGate-RSRC)))
 :effect (and
		(at start (not (Location ?sheet uc2_Exit-om_TopEntry)))
		(at start (not (Available om_TopGate-RSRC)))
		(at end (Timepoint ?sheet om-UpperOut-Letter-T1)))
)
(:durative-action om-UpperOut-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 7535)
 :condition (and
		(at start (Timepoint ?sheet om-UpperOut-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet om-UpperOut-Letter-T1)))
		(at start (Available om_TopGate-RSRC))
		(at end (Timepoint ?sheet om-UpperOut-Letter-T2)))
)
(:durative-action om-UpperOut-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet om-UpperOut-Letter-T2))
		(at start (Available om_OutputNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet om-UpperOut-Letter-T2)))
		(at start (not (Available om_OutputNip-RSRC)))
		(at start (Hasallrsrcs ?sheet om-UpperOut-Letter))
		(at end (Location ?sheet om_OutputExit-sys_Entry)))
)
(:durative-action om-UpperOut-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet om-UpperOut-Letter)))
 :effect (and

		(at end (Available om_OutputNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet om-UpperOut-Letter))))
)
(:durative-action om-LowerOut-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 502)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet om_BottomEntry-lc2_Exit))
		(at start (Available om_BottomGate-RSRC)))
 :effect (and
		(at start (not (Location ?sheet om_BottomEntry-lc2_Exit)))
		(at start (not (Available om_BottomGate-RSRC)))
		(at end (Timepoint ?sheet om-LowerOut-Letter-T1)))
)
(:durative-action om-LowerOut-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2749)
 :condition (and
		(at start (Timepoint ?sheet om-LowerOut-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet om-LowerOut-Letter-T1)))
		(at start (Available om_BottomGate-RSRC))
		(at end (Timepoint ?sheet om-LowerOut-Letter-T2)))
)
(:durative-action om-LowerOut-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet om-LowerOut-Letter-T2))
		(at start (Available om_OutputNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet om-LowerOut-Letter-T2)))
		(at start (not (Available om_OutputNip-RSRC)))
		(at start (Hasallrsrcs ?sheet om-LowerOut-Letter))
		(at end (Location ?sheet om_OutputExit-sys_Entry)))
)
(:durative-action om-LowerOut-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet om-LowerOut-Letter)))
 :effect (and

		(at end (Available om_OutputNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet om-LowerOut-Letter))))
)
(:durative-action om-UpperReturn-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 502)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet uc2_Exit-om_TopEntry))
		(at start (Available om_TopGate-RSRC)))
 :effect (and
		(at start (not (Location ?sheet uc2_Exit-om_TopEntry)))
		(at start (not (Available om_TopGate-RSRC)))
		(at end (Timepoint ?sheet om-UpperReturn-Letter-T1)))
)
(:durative-action om-UpperReturn-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 7841)
 :condition (and
		(at start (Timepoint ?sheet om-UpperReturn-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet om-UpperReturn-Letter-T1)))
		(at start (Available om_TopGate-RSRC))
		(at end (Timepoint ?sheet om-UpperReturn-Letter-T2)))
)
(:durative-action om-UpperReturn-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet om-UpperReturn-Letter-T2))
		(at start (Available om_ReturnNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet om-UpperReturn-Letter-T2)))
		(at start (not (Available om_ReturnNip-RSRC)))
		(at start (Hasallrsrcs ?sheet om-UpperReturn-Letter))
		(at end (Location ?sheet om_ReturnExit-rh2_Entry)))
)
(:durative-action om-UpperReturn-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet om-UpperReturn-Letter)))
 :effect (and

		(at end (Available om_ReturnNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet om-UpperReturn-Letter))))
)
(:durative-action om-LowerReturn-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 502)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet om_BottomEntry-lc2_Exit))
		(at start (Available om_BottomGate-RSRC)))
 :effect (and
		(at start (not (Location ?sheet om_BottomEntry-lc2_Exit)))
		(at start (not (Available om_BottomGate-RSRC)))
		(at end (Timepoint ?sheet om-LowerReturn-Letter-T1)))
)
(:durative-action om-LowerReturn-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2497)
 :condition (and
		(at start (Timepoint ?sheet om-LowerReturn-Letter-T1)))
 :effect (and
		(at start (not (Timepoint ?sheet om-LowerReturn-Letter-T1)))
		(at start (Available om_BottomGate-RSRC))
		(at end (Timepoint ?sheet om-LowerReturn-Letter-T2)))
)
(:durative-action om-LowerReturn-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 569)
 :condition (and
		(at start (Timepoint ?sheet om-LowerReturn-Letter-T2))
		(at start (Available om_ReturnNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet om-LowerReturn-Letter-T2)))
		(at start (not (Available om_ReturnNip-RSRC)))
		(at start (Hasallrsrcs ?sheet om-LowerReturn-Letter))
		(at end (Location ?sheet om_ReturnExit-rh2_Entry)))
)
(:durative-action om-LowerReturn-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 402)
 :condition (and
		(at start (Hasallrsrcs ?sheet om-LowerReturn-Letter)))
 :effect (and

		(at end (Available om_ReturnNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet om-LowerReturn-Letter))))
)
(:durative-action sys-Stack-Letter
 :parameters ( ?sheet - sheet_t ?prevsheet - sheet_t)
 :duration (= ?duration 1499)
 :condition (and
		(at start (Prevsheet ?sheet ?prevsheet))
		(at start (Location ?prevsheet Some_Finisher_Tray))
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet om_OutputExit-sys_Entry)))
 :effect (and
		(at start (not (Location ?sheet om_OutputExit-sys_Entry)))
		(at end (Location ?sheet Some_Finisher_Tray))
		(at end (Stackedin ?sheet sys_OutputTray)))
)
)


