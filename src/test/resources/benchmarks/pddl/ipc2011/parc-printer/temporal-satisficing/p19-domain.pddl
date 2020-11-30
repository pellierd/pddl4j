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
		Some_Purge_Tray
		fe1_Exit-hw1_LeftEntry
		hw1_RightExit-sys_Entry
		uc1_Entry-hw1_TopLeftExit
		lc1_Entry-hw1_BottomLeftExit
		hw1_TopRightEntry-uc1_Exit
		lc1_Exit-hw1_BottomRightEntry
		uc1_ExitToIME-uime_Entry
		uime_Exit-uc1_EntryFromIME
		lime_Entry-lc1_ExitToIME
		lc1_EntryFromIME-lime_Exit
		sys_OutputTray - location_t

		fe1-FeedMSI-Letter-T0
		fe1-Feed-Letter-T0
		hw1-LeftEntryToTopLeftExit-Letter-T1
		hw1-LeftEntryToBottomLeftExit-Letter-T1
		hw1-TopRightEntryToTopLeftExit-Letter-T1
		hw1-TopRightEntryToTopLeftExit-Letter-T2
		hw1-TopRightEntryToBottomLeftExit-Letter-T1
		hw1-TopRightEntryToBottomLeftExit-Letter-T2
		hw1-BottomRightEntryToTopLeftExit-Letter-T1
		hw1-BottomRightEntryToTopLeftExit-Letter-T2
		hw1-BottomRightEntryToBottomLeftExit-Letter-T1
		hw1-BottomRightEntryToBottomLeftExit-Letter-T2
		hw1-TopRightEntryToRightExit-Letter-T1
		hw1-BottomRightEntryToRightExit-Letter-T1
		uime-Simplex-Letter-T0
		lime-Simplex-Letter-T0
		lime-SimplexMono-Letter-T0 - timepoint_t

		fe1_Nip-RSRC
		hw1_TopLeftNip-RSRC
		hw1_BottomLeftNip-RSRC
		hw1_LeftSplitNip-RSRC
		hw1_RightNip-RSRC
		uime_Drum-RSRC
		lime_Drum-RSRC - resource_t

		fe1-FeedMSI-Letter
		fe1-Feed-Letter
		hw1-LeftEntryToTopLeftExit-Letter
		hw1-LeftEntryToBottomLeftExit-Letter
		hw1-TopRightEntryToTopLeftExit-Letter
		hw1-TopRightEntryToBottomLeftExit-Letter
		hw1-BottomRightEntryToTopLeftExit-Letter
		hw1-BottomRightEntryToBottomLeftExit-Letter
		hw1-TopRightEntryToRightExit-Letter
		hw1-BottomRightEntryToRightExit-Letter
		uime-Simplex-Letter
		lime-Simplex-Letter
		lime-SimplexMono-Letter - action_t
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
		(at start (Available hw1_TopLeftNip-RSRC))
		(at start (Available hw1_BottomLeftNip-RSRC))
		(at start (Available hw1_LeftSplitNip-RSRC))
		(at start (Available hw1_RightNip-RSRC))
		(at start (Available uime_Drum-RSRC))
		(at start (Available lime_Drum-RSRC)))
)
(:durative-action fe1-FeedMSI-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 125)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Some_Feeder_Tray))
		(at start (Available fe1_Nip-RSRC)))
 :effect (and
		(at start (not (Location ?sheet Some_Feeder_Tray)))
		(at start (not (Available fe1_Nip-RSRC)))
		(at start (Hasallrsrcs ?sheet fe1-FeedMSI-Letter))
		(at start (Sideup ?sheet Back))
		(at end (Location ?sheet fe1_Exit-hw1_LeftEntry)))
)
(:durative-action fe1-FeedMSI-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 4499)
 :condition (and
		(at start (Hasallrsrcs ?sheet fe1-FeedMSI-Letter)))
 :effect (and

		(at end (Available fe1_Nip-RSRC))
		(at end (not (Hasallrsrcs ?sheet fe1-FeedMSI-Letter))))
)
(:durative-action fe1-Feed-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 224)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Some_Feeder_Tray))
		(at start (Available fe1_Nip-RSRC)))
 :effect (and
		(at start (not (Location ?sheet Some_Feeder_Tray)))
		(at start (not (Available fe1_Nip-RSRC)))
		(at start (Hasallrsrcs ?sheet fe1-Feed-Letter))
		(at start (Sideup ?sheet Back))
		(at end (Location ?sheet fe1_Exit-hw1_LeftEntry)))
)
(:durative-action fe1-Feed-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 4499)
 :condition (and
		(at start (Hasallrsrcs ?sheet fe1-Feed-Letter)))
 :effect (and

		(at end (Available fe1_Nip-RSRC))
		(at end (not (Hasallrsrcs ?sheet fe1-Feed-Letter))))
)
(:durative-action hw1-LeftEntryToTopLeftExit-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1499)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet fe1_Exit-hw1_LeftEntry)))
 :effect (and
		(at start (not (Location ?sheet fe1_Exit-hw1_LeftEntry)))
		(at end (Timepoint ?sheet hw1-LeftEntryToTopLeftExit-Letter-T1)))
)
(:durative-action hw1-LeftEntryToTopLeftExit-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet hw1-LeftEntryToTopLeftExit-Letter-T1))
		(at start (Available hw1_TopLeftNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-LeftEntryToTopLeftExit-Letter-T1)))
		(at start (not (Available hw1_TopLeftNip-RSRC)))
		(at start (Hasallrsrcs ?sheet hw1-LeftEntryToTopLeftExit-Letter))
		(at end (Location ?sheet uc1_Entry-hw1_TopLeftExit)))
)
(:durative-action hw1-LeftEntryToTopLeftExit-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2259)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-LeftEntryToTopLeftExit-Letter)))
 :effect (and

		(at end (Available hw1_TopLeftNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet hw1-LeftEntryToTopLeftExit-Letter))))
)
(:durative-action hw1-LeftEntryToBottomLeftExit-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1499)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet fe1_Exit-hw1_LeftEntry)))
 :effect (and
		(at start (not (Location ?sheet fe1_Exit-hw1_LeftEntry)))
		(at end (Timepoint ?sheet hw1-LeftEntryToBottomLeftExit-Letter-T1)))
)
(:durative-action hw1-LeftEntryToBottomLeftExit-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet hw1-LeftEntryToBottomLeftExit-Letter-T1))
		(at start (Available hw1_BottomLeftNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-LeftEntryToBottomLeftExit-Letter-T1)))
		(at start (not (Available hw1_BottomLeftNip-RSRC)))
		(at start (Hasallrsrcs ?sheet hw1-LeftEntryToBottomLeftExit-Letter))
		(at end (Location ?sheet lc1_Entry-hw1_BottomLeftExit)))
)
(:durative-action hw1-LeftEntryToBottomLeftExit-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2259)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-LeftEntryToBottomLeftExit-Letter)))
 :effect (and

		(at end (Available hw1_BottomLeftNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet hw1-LeftEntryToBottomLeftExit-Letter))))
)
(:durative-action hw1-TopRightEntryToTopLeftExit-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 7499)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet hw1_TopRightEntry-uc1_Exit)))
 :effect (and
		(at start (not (Location ?sheet hw1_TopRightEntry-uc1_Exit)))
		(at end (Timepoint ?sheet hw1-TopRightEntryToTopLeftExit-Letter-T1)))
)
(:durative-action hw1-TopRightEntryToTopLeftExit-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1500)
 :condition (and
		(at start (Timepoint ?sheet hw1-TopRightEntryToTopLeftExit-Letter-T1))
		(at start (Available hw1_LeftSplitNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-TopRightEntryToTopLeftExit-Letter-T1)))
		(at start (not (Available hw1_LeftSplitNip-RSRC)))
		(at end (Timepoint ?sheet hw1-TopRightEntryToTopLeftExit-Letter-T2)))
)
(:durative-action hw1-TopRightEntryToTopLeftExit-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet hw1-TopRightEntryToTopLeftExit-Letter-T2))
		(at start (Available hw1_TopLeftNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-TopRightEntryToTopLeftExit-Letter-T2)))
		(at start (not (Available hw1_TopLeftNip-RSRC)))
		(at start (Hasallrsrcs ?sheet hw1-TopRightEntryToTopLeftExit-Letter))
		(at end (Location ?sheet uc1_Entry-hw1_TopLeftExit)))
)
(:durative-action hw1-TopRightEntryToTopLeftExit-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 758)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-TopRightEntryToTopLeftExit-Letter)))
 :effect (and

		(at end (Available hw1_LeftSplitNip-RSRC)))
)
(:durative-action hw1-TopRightEntryToTopLeftExit-Letter-4
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2259)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-TopRightEntryToTopLeftExit-Letter)))
 :effect (and

		(at end (Available hw1_TopLeftNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet hw1-TopRightEntryToTopLeftExit-Letter))))
)
(:durative-action hw1-TopRightEntryToBottomLeftExit-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 7499)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet hw1_TopRightEntry-uc1_Exit)))
 :effect (and
		(at start (not (Location ?sheet hw1_TopRightEntry-uc1_Exit)))
		(at end (Timepoint ?sheet hw1-TopRightEntryToBottomLeftExit-Letter-T1)))
)
(:durative-action hw1-TopRightEntryToBottomLeftExit-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1500)
 :condition (and
		(at start (Timepoint ?sheet hw1-TopRightEntryToBottomLeftExit-Letter-T1))
		(at start (Available hw1_LeftSplitNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-TopRightEntryToBottomLeftExit-Letter-T1)))
		(at start (not (Available hw1_LeftSplitNip-RSRC)))
		(at end (Timepoint ?sheet hw1-TopRightEntryToBottomLeftExit-Letter-T2)))
)
(:durative-action hw1-TopRightEntryToBottomLeftExit-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet hw1-TopRightEntryToBottomLeftExit-Letter-T2))
		(at start (Available hw1_BottomLeftNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-TopRightEntryToBottomLeftExit-Letter-T2)))
		(at start (not (Available hw1_BottomLeftNip-RSRC)))
		(at start (Hasallrsrcs ?sheet hw1-TopRightEntryToBottomLeftExit-Letter))
		(at end (Location ?sheet lc1_Entry-hw1_BottomLeftExit)))
)
(:durative-action hw1-TopRightEntryToBottomLeftExit-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 758)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-TopRightEntryToBottomLeftExit-Letter)))
 :effect (and

		(at end (Available hw1_LeftSplitNip-RSRC)))
)
(:durative-action hw1-TopRightEntryToBottomLeftExit-Letter-4
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2259)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-TopRightEntryToBottomLeftExit-Letter)))
 :effect (and

		(at end (Available hw1_BottomLeftNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet hw1-TopRightEntryToBottomLeftExit-Letter))))
)
(:durative-action hw1-BottomRightEntryToTopLeftExit-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 7499)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet lc1_Exit-hw1_BottomRightEntry)))
 :effect (and
		(at start (not (Location ?sheet lc1_Exit-hw1_BottomRightEntry)))
		(at end (Timepoint ?sheet hw1-BottomRightEntryToTopLeftExit-Letter-T1)))
)
(:durative-action hw1-BottomRightEntryToTopLeftExit-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1500)
 :condition (and
		(at start (Timepoint ?sheet hw1-BottomRightEntryToTopLeftExit-Letter-T1))
		(at start (Available hw1_LeftSplitNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-BottomRightEntryToTopLeftExit-Letter-T1)))
		(at start (not (Available hw1_LeftSplitNip-RSRC)))
		(at end (Timepoint ?sheet hw1-BottomRightEntryToTopLeftExit-Letter-T2)))
)
(:durative-action hw1-BottomRightEntryToTopLeftExit-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet hw1-BottomRightEntryToTopLeftExit-Letter-T2))
		(at start (Available hw1_TopLeftNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-BottomRightEntryToTopLeftExit-Letter-T2)))
		(at start (not (Available hw1_TopLeftNip-RSRC)))
		(at start (Hasallrsrcs ?sheet hw1-BottomRightEntryToTopLeftExit-Letter))
		(at end (Location ?sheet uc1_Entry-hw1_TopLeftExit)))
)
(:durative-action hw1-BottomRightEntryToTopLeftExit-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 758)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-BottomRightEntryToTopLeftExit-Letter)))
 :effect (and

		(at end (Available hw1_LeftSplitNip-RSRC)))
)
(:durative-action hw1-BottomRightEntryToTopLeftExit-Letter-4
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2259)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-BottomRightEntryToTopLeftExit-Letter)))
 :effect (and

		(at end (Available hw1_TopLeftNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet hw1-BottomRightEntryToTopLeftExit-Letter))))
)
(:durative-action hw1-BottomRightEntryToBottomLeftExit-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 7499)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet lc1_Exit-hw1_BottomRightEntry)))
 :effect (and
		(at start (not (Location ?sheet lc1_Exit-hw1_BottomRightEntry)))
		(at end (Timepoint ?sheet hw1-BottomRightEntryToBottomLeftExit-Letter-T1)))
)
(:durative-action hw1-BottomRightEntryToBottomLeftExit-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1500)
 :condition (and
		(at start (Timepoint ?sheet hw1-BottomRightEntryToBottomLeftExit-Letter-T1))
		(at start (Available hw1_LeftSplitNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-BottomRightEntryToBottomLeftExit-Letter-T1)))
		(at start (not (Available hw1_LeftSplitNip-RSRC)))
		(at end (Timepoint ?sheet hw1-BottomRightEntryToBottomLeftExit-Letter-T2)))
)
(:durative-action hw1-BottomRightEntryToBottomLeftExit-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet hw1-BottomRightEntryToBottomLeftExit-Letter-T2))
		(at start (Available hw1_BottomLeftNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-BottomRightEntryToBottomLeftExit-Letter-T2)))
		(at start (not (Available hw1_BottomLeftNip-RSRC)))
		(at start (Hasallrsrcs ?sheet hw1-BottomRightEntryToBottomLeftExit-Letter))
		(at end (Location ?sheet lc1_Entry-hw1_BottomLeftExit)))
)
(:durative-action hw1-BottomRightEntryToBottomLeftExit-Letter-3
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 758)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-BottomRightEntryToBottomLeftExit-Letter)))
 :effect (and

		(at end (Available hw1_LeftSplitNip-RSRC)))
)
(:durative-action hw1-BottomRightEntryToBottomLeftExit-Letter-4
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2259)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-BottomRightEntryToBottomLeftExit-Letter)))
 :effect (and

		(at end (Available hw1_BottomLeftNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet hw1-BottomRightEntryToBottomLeftExit-Letter))))
)
(:durative-action hw1-TopRightEntryToRightExit-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1499)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet hw1_TopRightEntry-uc1_Exit)))
 :effect (and
		(at start (not (Location ?sheet hw1_TopRightEntry-uc1_Exit)))
		(at end (Timepoint ?sheet hw1-TopRightEntryToRightExit-Letter-T1)))
)
(:durative-action hw1-TopRightEntryToRightExit-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet hw1-TopRightEntryToRightExit-Letter-T1))
		(at start (Available hw1_RightNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-TopRightEntryToRightExit-Letter-T1)))
		(at start (not (Available hw1_RightNip-RSRC)))
		(at start (Hasallrsrcs ?sheet hw1-TopRightEntryToRightExit-Letter))
		(at end (Location ?sheet hw1_RightExit-sys_Entry)))
)
(:durative-action hw1-TopRightEntryToRightExit-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2259)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-TopRightEntryToRightExit-Letter)))
 :effect (and

		(at end (Available hw1_RightNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet hw1-TopRightEntryToRightExit-Letter))))
)
(:durative-action hw1-BottomRightEntryToRightExit-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1499)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet lc1_Exit-hw1_BottomRightEntry)))
 :effect (and
		(at start (not (Location ?sheet lc1_Exit-hw1_BottomRightEntry)))
		(at end (Timepoint ?sheet hw1-BottomRightEntryToRightExit-Letter-T1)))
)
(:durative-action hw1-BottomRightEntryToRightExit-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet hw1-BottomRightEntryToRightExit-Letter-T1))
		(at start (Available hw1_RightNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet hw1-BottomRightEntryToRightExit-Letter-T1)))
		(at start (not (Available hw1_RightNip-RSRC)))
		(at start (Hasallrsrcs ?sheet hw1-BottomRightEntryToRightExit-Letter))
		(at end (Location ?sheet hw1_RightExit-sys_Entry)))
)
(:durative-action hw1-BottomRightEntryToRightExit-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2259)
 :condition (and
		(at start (Hasallrsrcs ?sheet hw1-BottomRightEntryToRightExit-Letter)))
 :effect (and

		(at end (Available hw1_RightNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet hw1-BottomRightEntryToRightExit-Letter))))
)
(:durative-action uc1-ToIME-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet uc1_Entry-hw1_TopLeftExit)))
 :effect (and
		(at start (not (Location ?sheet uc1_Entry-hw1_TopLeftExit)))
		(at end (Location ?sheet uc1_ExitToIME-uime_Entry)))
)
(:durative-action uc1-InvertToIME-Letter
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 8000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet uc1_Entry-hw1_TopLeftExit))
		(at start (Sideup ?sheet ?face)))
 :effect (and
		(at start (not (Location ?sheet uc1_Entry-hw1_TopLeftExit)))
		(at start (not (Sideup ?sheet ?face)))
		(at end (Location ?sheet uc1_ExitToIME-uime_Entry))
		(at end (Sideup ?sheet ?otherface)))
)
(:durative-action uc1-FromIME-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet uime_Exit-uc1_EntryFromIME)))
 :effect (and
		(at start (not (Location ?sheet uime_Exit-uc1_EntryFromIME)))
		(at end (Location ?sheet hw1_TopRightEntry-uc1_Exit)))
)
(:durative-action uc1-InvertFromIME-Letter
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 8000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet uime_Exit-uc1_EntryFromIME))
		(at start (Sideup ?sheet ?face)))
 :effect (and
		(at start (not (Location ?sheet uime_Exit-uc1_EntryFromIME)))
		(at start (not (Sideup ?sheet ?face)))
		(at end (Location ?sheet hw1_TopRightEntry-uc1_Exit))
		(at end (Sideup ?sheet ?otherface)))
)
(:durative-action uime-Simplex-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 27790)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black))
		(at start (Location ?sheet uc1_ExitToIME-uime_Entry))
		(at start (Notprintedwith ?sheet ?face Black))
		(at start (Available uime_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet uc1_ExitToIME-uime_Entry)))
		(at start (not (Notprintedwith ?sheet ?face Black)))
		(at start (not (Available uime_Drum-RSRC)))
		(at start (Hasallrsrcs ?sheet uime-Simplex-Letter))
		(at end (Location ?sheet uime_Exit-uc1_EntryFromIME))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action uime-Simplex-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 9999)
 :condition (and
		(at start (Hasallrsrcs ?sheet uime-Simplex-Letter)))
 :effect (and

		(at end (Available uime_Drum-RSRC))
		(at end (not (Hasallrsrcs ?sheet uime-Simplex-Letter))))
)
(:durative-action lc1-ToIME-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 4999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet lc1_Entry-hw1_BottomLeftExit)))
 :effect (and
		(at start (not (Location ?sheet lc1_Entry-hw1_BottomLeftExit)))
		(at end (Location ?sheet lime_Entry-lc1_ExitToIME)))
)
(:durative-action lc1-InvertToIME-Letter
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 9999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet lc1_Entry-hw1_BottomLeftExit))
		(at start (Sideup ?sheet ?face)))
 :effect (and
		(at start (not (Location ?sheet lc1_Entry-hw1_BottomLeftExit)))
		(at start (not (Sideup ?sheet ?face)))
		(at end (Location ?sheet lime_Entry-lc1_ExitToIME))
		(at end (Sideup ?sheet ?otherface)))
)
(:durative-action lc1-FromIME-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 4999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet lc1_EntryFromIME-lime_Exit)))
 :effect (and
		(at start (not (Location ?sheet lc1_EntryFromIME-lime_Exit)))
		(at end (Location ?sheet lc1_Exit-hw1_BottomRightEntry)))
)
(:durative-action lc1-InvertFromIME-Letter
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t)
 :duration (= ?duration 9999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Location ?sheet lc1_EntryFromIME-lime_Exit))
		(at start (Sideup ?sheet ?face)))
 :effect (and
		(at start (not (Location ?sheet lc1_EntryFromIME-lime_Exit)))
		(at start (not (Sideup ?sheet ?face)))
		(at end (Location ?sheet lc1_Exit-hw1_BottomRightEntry))
		(at end (Sideup ?sheet ?otherface)))
)
(:durative-action lime-Simplex-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 27790)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Color))
		(at start (Location ?sheet lime_Entry-lc1_ExitToIME))
		(at start (Notprintedwith ?sheet ?face Color))
		(at start (Available lime_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet lime_Entry-lc1_ExitToIME)))
		(at start (not (Notprintedwith ?sheet ?face Color)))
		(at start (not (Available lime_Drum-RSRC)))
		(at start (Hasallrsrcs ?sheet lime-Simplex-Letter))
		(at end (Location ?sheet lc1_EntryFromIME-lime_Exit))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action lime-Simplex-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 9999)
 :condition (and
		(at start (Hasallrsrcs ?sheet lime-Simplex-Letter)))
 :effect (and

		(at end (Available lime_Drum-RSRC))
		(at end (not (Hasallrsrcs ?sheet lime-Simplex-Letter))))
)
(:durative-action lime-SimplexMono-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 27790)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black))
		(at start (Location ?sheet lime_Entry-lc1_ExitToIME))
		(at start (Notprintedwith ?sheet ?face Black))
		(at start (Available lime_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet lime_Entry-lc1_ExitToIME)))
		(at start (not (Notprintedwith ?sheet ?face Black)))
		(at start (not (Available lime_Drum-RSRC)))
		(at start (Hasallrsrcs ?sheet lime-SimplexMono-Letter))
		(at end (Location ?sheet lc1_EntryFromIME-lime_Exit))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action lime-SimplexMono-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 9999)
 :condition (and
		(at start (Hasallrsrcs ?sheet lime-SimplexMono-Letter)))
 :effect (and

		(at end (Available lime_Drum-RSRC))
		(at end (not (Hasallrsrcs ?sheet lime-SimplexMono-Letter))))
)
(:durative-action sys-Stack-Letter
 :parameters ( ?sheet - sheet_t ?prevsheet - sheet_t)
 :duration (= ?duration 1499)
 :condition (and
		(at start (Prevsheet ?sheet ?prevsheet))
		(at start (Location ?prevsheet Some_Finisher_Tray))
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet hw1_RightExit-sys_Entry)))
 :effect (and
		(at start (not (Location ?sheet hw1_RightExit-sys_Entry)))
		(at end (Location ?sheet Some_Finisher_Tray))
		(at end (Stackedin ?sheet sys_OutputTray)))
)
)


