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
(define (domain upp)
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
		EndCap_Entry-BlackContainer_Exit
		HtmOverBlack_Entry-EndCap_Exit
		HtmOverBlack_Exit-Down_TopEntry
		ColorContainer_Entry-Down_BottomExit
		ColorContainer_ExitToIME-ColorPrinter_Entry
		ColorPrinter_Exit-ColorContainer_EntryFromIME
		ColorContainer_Exit-Up_BottomEntry
		Down_BottomEntry-ColorFeeder_Exit
		BlackContainer_Entry-BlackFeeder_Exit
		Down_TopExit-HtmOverColor_Entry
		HtmOverColor_Exit-Up_TopEntry
		BlackContainer_ExitToIME-BlackPrinter_Entry
		BlackPrinter_Exit-BlackContainer_EntryFromIME
		Finisher1_Entry-Up_TopExit
		Finisher2_Entry-Finisher1_Exit
		Finisher1_Tray
		Finisher2_Exit
		Finisher2_Tray - location_t

		ColorContainer-ToIME-Letter-T0
		ColorPrinter-Simplex-Letter-T0
		ColorPrinter-SimplexMono-Letter-T0
		ColorFeeder-Feed-Letter-T0
		BlackFeeder-Feed-Letter-T0
		Down-MoveBottom-Letter-T1
		Down-MoveDown-Letter-T1
		BlackPrinter-Simplex-Letter-T0
		BlackPrinter-SimplexAndInvert-Letter-T0
		Up-MoveTop-Letter-T1
		Up-MoveUp-Letter-T1
		Finisher1-Stack-Letter-T0
		Finisher2-Stack-Letter-T0 - timepoint_t

		ColorContainer_Roller-RSRC
		ColorPrinter_Drum-RSRC
		ColorFeeder_ExitNip-RSRC
		BlackFeeder_ExitNip-RSRC
		Down_BottomExitNip-RSRC
		BlackPrinter_Drum-RSRC
		Up_TopExitNip-RSRC
		Finisher1_EntryNip-RSRC
		Finisher2_EntryNip-RSRC - resource_t

		ColorContainer-ToIME-Letter
		ColorPrinter-Simplex-Letter
		ColorPrinter-SimplexMono-Letter
		ColorFeeder-Feed-Letter
		BlackFeeder-Feed-Letter
		Down-MoveBottom-Letter
		Down-MoveDown-Letter
		BlackPrinter-Simplex-Letter
		BlackPrinter-SimplexAndInvert-Letter
		Up-MoveTop-Letter
		Up-MoveUp-Letter
		Finisher1-Stack-Letter
		Finisher2-Stack-Letter - action_t
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
		(at start (Available ColorContainer_Roller-RSRC))
		(at start (Available ColorPrinter_Drum-RSRC))
		(at start (Available ColorFeeder_ExitNip-RSRC))
		(at start (Available BlackFeeder_ExitNip-RSRC))
		(at start (Available Down_BottomExitNip-RSRC))
		(at start (Available BlackPrinter_Drum-RSRC))
		(at start (Available Up_TopExitNip-RSRC))
		(at start (Available Finisher1_EntryNip-RSRC))
		(at start (Available Finisher2_EntryNip-RSRC)))
)
(:durative-action EndCap-Move-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet EndCap_Entry-BlackContainer_Exit)))
 :effect (and
		(at start (not (Location ?sheet EndCap_Entry-BlackContainer_Exit)))
		(at end (Location ?sheet HtmOverBlack_Entry-EndCap_Exit)))
)
(:durative-action HtmOverBlack-Move-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 17999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet HtmOverBlack_Entry-EndCap_Exit)))
 :effect (and
		(at start (not (Location ?sheet HtmOverBlack_Entry-EndCap_Exit)))
		(at end (Location ?sheet HtmOverBlack_Exit-Down_TopEntry)))
)
(:durative-action ColorContainer-ToIME-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 8000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet ColorContainer_Entry-Down_BottomExit))
		(at start (Available ColorContainer_Roller-RSRC)))
 :effect (and
		(at start (not (Location ?sheet ColorContainer_Entry-Down_BottomExit)))
		(at start (not (Available ColorContainer_Roller-RSRC)))
		(at start (Hasallrsrcs ?sheet ColorContainer-ToIME-Letter))
		(at end (Location ?sheet ColorContainer_ExitToIME-ColorPrinter_Entry)))
)
(:durative-action ColorContainer-ToIME-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 9999)
 :condition (and
		(at start (Hasallrsrcs ?sheet ColorContainer-ToIME-Letter)))
 :effect (and

		(at end (Available ColorContainer_Roller-RSRC))
		(at end (not (Hasallrsrcs ?sheet ColorContainer-ToIME-Letter))))
)
(:durative-action ColorContainer-FromIME-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 8000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet ColorPrinter_Exit-ColorContainer_EntryFromIME)))
 :effect (and
		(at start (not (Location ?sheet ColorPrinter_Exit-ColorContainer_EntryFromIME)))
		(at end (Location ?sheet ColorContainer_Exit-Up_BottomEntry)))
)
(:durative-action ColorPrinter-Simplex-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 39040)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Color))
		(at start (Location ?sheet ColorContainer_ExitToIME-ColorPrinter_Entry))
		(at start (Notprintedwith ?sheet ?face Color))
		(at start (Available ColorPrinter_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet ColorContainer_ExitToIME-ColorPrinter_Entry)))
		(at start (not (Notprintedwith ?sheet ?face Color)))
		(at start (not (Available ColorPrinter_Drum-RSRC)))
		(at start (Hasallrsrcs ?sheet ColorPrinter-Simplex-Letter))
		(at end (Location ?sheet ColorPrinter_Exit-ColorContainer_EntryFromIME))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action ColorPrinter-Simplex-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 11999)
 :condition (and
		(at start (Hasallrsrcs ?sheet ColorPrinter-Simplex-Letter)))
 :effect (and

		(at end (Available ColorPrinter_Drum-RSRC))
		(at end (not (Hasallrsrcs ?sheet ColorPrinter-Simplex-Letter))))
)
(:durative-action ColorPrinter-SimplexMono-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 39040)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black))
		(at start (Location ?sheet ColorContainer_ExitToIME-ColorPrinter_Entry))
		(at start (Notprintedwith ?sheet ?face Black))
		(at start (Available ColorPrinter_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet ColorContainer_ExitToIME-ColorPrinter_Entry)))
		(at start (not (Notprintedwith ?sheet ?face Black)))
		(at start (not (Available ColorPrinter_Drum-RSRC)))
		(at start (Hasallrsrcs ?sheet ColorPrinter-SimplexMono-Letter))
		(at end (Location ?sheet ColorPrinter_Exit-ColorContainer_EntryFromIME))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action ColorPrinter-SimplexMono-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 11999)
 :condition (and
		(at start (Hasallrsrcs ?sheet ColorPrinter-SimplexMono-Letter)))
 :effect (and

		(at end (Available ColorPrinter_Drum-RSRC))
		(at end (not (Hasallrsrcs ?sheet ColorPrinter-SimplexMono-Letter))))
)
(:durative-action ColorFeeder-Feed-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 8000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Some_Feeder_Tray))
		(at start (Available ColorFeeder_ExitNip-RSRC)))
 :effect (and
		(at start (not (Location ?sheet Some_Feeder_Tray)))
		(at start (not (Available ColorFeeder_ExitNip-RSRC)))
		(at start (Hasallrsrcs ?sheet ColorFeeder-Feed-Letter))
		(at start (Sideup ?sheet Front))
		(at end (Location ?sheet Down_BottomEntry-ColorFeeder_Exit)))
)
(:durative-action ColorFeeder-Feed-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2158)
 :condition (and
		(at start (Hasallrsrcs ?sheet ColorFeeder-Feed-Letter)))
 :effect (and

		(at end (Available ColorFeeder_ExitNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet ColorFeeder-Feed-Letter))))
)
(:durative-action BlackFeeder-Feed-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 8000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Some_Feeder_Tray))
		(at start (Available BlackFeeder_ExitNip-RSRC)))
 :effect (and
		(at start (not (Location ?sheet Some_Feeder_Tray)))
		(at start (not (Available BlackFeeder_ExitNip-RSRC)))
		(at start (Hasallrsrcs ?sheet BlackFeeder-Feed-Letter))
		(at start (Sideup ?sheet Front))
		(at end (Location ?sheet BlackContainer_Entry-BlackFeeder_Exit)))
)
(:durative-action BlackFeeder-Feed-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2158)
 :condition (and
		(at start (Hasallrsrcs ?sheet BlackFeeder-Feed-Letter)))
 :effect (and

		(at end (Available BlackFeeder_ExitNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet BlackFeeder-Feed-Letter))))
)
(:durative-action Down-MoveTop-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet HtmOverBlack_Exit-Down_TopEntry)))
 :effect (and
		(at start (not (Location ?sheet HtmOverBlack_Exit-Down_TopEntry)))
		(at end (Location ?sheet Down_TopExit-HtmOverColor_Entry)))
)
(:durative-action Down-MoveBottom-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Down_BottomEntry-ColorFeeder_Exit)))
 :effect (and
		(at start (not (Location ?sheet Down_BottomEntry-ColorFeeder_Exit)))
		(at end (Timepoint ?sheet Down-MoveBottom-Letter-T1)))
)
(:durative-action Down-MoveBottom-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet Down-MoveBottom-Letter-T1))
		(at start (Available Down_BottomExitNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet Down-MoveBottom-Letter-T1)))
		(at start (not (Available Down_BottomExitNip-RSRC)))
		(at start (Hasallrsrcs ?sheet Down-MoveBottom-Letter))
		(at end (Location ?sheet ColorContainer_Entry-Down_BottomExit)))
)
(:durative-action Down-MoveBottom-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2458)
 :condition (and
		(at start (Hasallrsrcs ?sheet Down-MoveBottom-Letter)))
 :effect (and

		(at end (Available Down_BottomExitNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet Down-MoveBottom-Letter))))
)
(:durative-action Down-MoveDown-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 9999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet HtmOverBlack_Exit-Down_TopEntry)))
 :effect (and
		(at start (not (Location ?sheet HtmOverBlack_Exit-Down_TopEntry)))
		(at end (Timepoint ?sheet Down-MoveDown-Letter-T1)))
)
(:durative-action Down-MoveDown-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet Down-MoveDown-Letter-T1))
		(at start (Available Down_BottomExitNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet Down-MoveDown-Letter-T1)))
		(at start (not (Available Down_BottomExitNip-RSRC)))
		(at start (Hasallrsrcs ?sheet Down-MoveDown-Letter))
		(at end (Location ?sheet ColorContainer_Entry-Down_BottomExit)))
)
(:durative-action Down-MoveDown-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2458)
 :condition (and
		(at start (Hasallrsrcs ?sheet Down-MoveDown-Letter)))
 :effect (and

		(at end (Available Down_BottomExitNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet Down-MoveDown-Letter))))
)
(:durative-action HtmOverColor-Move-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 9999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Down_TopExit-HtmOverColor_Entry)))
 :effect (and
		(at start (not (Location ?sheet Down_TopExit-HtmOverColor_Entry)))
		(at end (Location ?sheet HtmOverColor_Exit-Up_TopEntry)))
)
(:durative-action BlackContainer-ToIME-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet BlackContainer_Entry-BlackFeeder_Exit)))
 :effect (and
		(at start (not (Location ?sheet BlackContainer_Entry-BlackFeeder_Exit)))
		(at end (Location ?sheet BlackContainer_ExitToIME-BlackPrinter_Entry)))
)
(:durative-action BlackContainer-FromIME-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet BlackPrinter_Exit-BlackContainer_EntryFromIME)))
 :effect (and
		(at start (not (Location ?sheet BlackPrinter_Exit-BlackContainer_EntryFromIME)))
		(at end (Location ?sheet EndCap_Entry-BlackContainer_Exit)))
)
(:durative-action BlackPrinter-Simplex-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?image - image_t)
 :duration (= ?duration 13013)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Sideup ?sheet ?face))
		(at start (Imagecolor ?image Black))
		(at start (Location ?sheet BlackContainer_ExitToIME-BlackPrinter_Entry))
		(at start (Notprintedwith ?sheet ?face Black))
		(at start (Available BlackPrinter_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet BlackContainer_ExitToIME-BlackPrinter_Entry)))
		(at start (not (Notprintedwith ?sheet ?face Black)))
		(at start (not (Available BlackPrinter_Drum-RSRC)))
		(at start (Hasallrsrcs ?sheet BlackPrinter-Simplex-Letter))
		(at end (Location ?sheet BlackPrinter_Exit-BlackContainer_EntryFromIME))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action BlackPrinter-Simplex-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 4000)
 :condition (and
		(at start (Hasallrsrcs ?sheet BlackPrinter-Simplex-Letter)))
 :effect (and

		(at end (Available BlackPrinter_Drum-RSRC))
		(at end (not (Hasallrsrcs ?sheet BlackPrinter-Simplex-Letter))))
)
(:durative-action BlackPrinter-SimplexAndInvert-Letter-0
 :parameters ( ?sheet - sheet_t ?face - side_t ?otherface - side_t ?image - image_t)
 :duration (= ?duration 23013)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Oppositeside ?face ?otherface))
		(at start (Imagecolor ?image Black))
		(at start (Location ?sheet BlackContainer_ExitToIME-BlackPrinter_Entry))
		(at start (Notprintedwith ?sheet ?face Black))
		(at start (Sideup ?sheet ?face))
		(at start (Available BlackPrinter_Drum-RSRC)))
 :effect (and
		(at start (not (Location ?sheet BlackContainer_ExitToIME-BlackPrinter_Entry)))
		(at start (not (Notprintedwith ?sheet ?face Black)))
		(at start (not (Sideup ?sheet ?face)))
		(at start (not (Available BlackPrinter_Drum-RSRC)))
		(at start (Hasallrsrcs ?sheet BlackPrinter-SimplexAndInvert-Letter))
		(at start (Sideup ?sheet ?otherface))
		(at end (Location ?sheet BlackPrinter_Exit-BlackContainer_EntryFromIME))
		(at end (Hasimage ?sheet ?face ?image)))
)
(:durative-action BlackPrinter-SimplexAndInvert-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 4000)
 :condition (and
		(at start (Hasallrsrcs ?sheet BlackPrinter-SimplexAndInvert-Letter)))
 :effect (and

		(at end (Available BlackPrinter_Drum-RSRC))
		(at end (not (Hasallrsrcs ?sheet BlackPrinter-SimplexAndInvert-Letter))))
)
(:durative-action Up-MoveTop-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet HtmOverColor_Exit-Up_TopEntry)))
 :effect (and
		(at start (not (Location ?sheet HtmOverColor_Exit-Up_TopEntry)))
		(at end (Timepoint ?sheet Up-MoveTop-Letter-T1)))
)
(:durative-action Up-MoveTop-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet Up-MoveTop-Letter-T1))
		(at start (Available Up_TopExitNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet Up-MoveTop-Letter-T1)))
		(at start (not (Available Up_TopExitNip-RSRC)))
		(at start (Hasallrsrcs ?sheet Up-MoveTop-Letter))
		(at end (Location ?sheet Finisher1_Entry-Up_TopExit)))
)
(:durative-action Up-MoveTop-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2458)
 :condition (and
		(at start (Hasallrsrcs ?sheet Up-MoveTop-Letter)))
 :effect (and

		(at end (Available Up_TopExitNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet Up-MoveTop-Letter))))
)
(:durative-action Up-MoveUp-Letter-0
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 9999)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet ColorContainer_Exit-Up_BottomEntry)))
 :effect (and
		(at start (not (Location ?sheet ColorContainer_Exit-Up_BottomEntry)))
		(at end (Timepoint ?sheet Up-MoveUp-Letter-T1)))
)
(:durative-action Up-MoveUp-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 1)
 :condition (and
		(at start (Timepoint ?sheet Up-MoveUp-Letter-T1))
		(at start (Available Up_TopExitNip-RSRC)))
 :effect (and
		(at start (not (Timepoint ?sheet Up-MoveUp-Letter-T1)))
		(at start (not (Available Up_TopExitNip-RSRC)))
		(at start (Hasallrsrcs ?sheet Up-MoveUp-Letter))
		(at end (Location ?sheet Finisher1_Entry-Up_TopExit)))
)
(:durative-action Up-MoveUp-Letter-2
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2458)
 :condition (and
		(at start (Hasallrsrcs ?sheet Up-MoveUp-Letter)))
 :effect (and

		(at end (Available Up_TopExitNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet Up-MoveUp-Letter))))
)
(:durative-action Finisher1-PassThrough-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 8000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Finisher1_Entry-Up_TopExit)))
 :effect (and
		(at start (not (Location ?sheet Finisher1_Entry-Up_TopExit)))
		(at end (Location ?sheet Finisher2_Entry-Finisher1_Exit)))
)
(:durative-action Finisher1-Stack-Letter-0
 :parameters ( ?sheet - sheet_t ?prevsheet - sheet_t)
 :duration (= ?duration 8000)
 :condition (and
		(at start (Prevsheet ?sheet ?prevsheet))
		(at start (Location ?prevsheet Some_Finisher_Tray))
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Finisher1_Entry-Up_TopExit))
		(at start (Available Finisher1_EntryNip-RSRC)))
 :effect (and
		(at start (not (Location ?sheet Finisher1_Entry-Up_TopExit)))
		(at start (not (Available Finisher1_EntryNip-RSRC)))
		(at start (Hasallrsrcs ?sheet Finisher1-Stack-Letter))
		(at end (Location ?sheet Some_Finisher_Tray))
		(at end (Stackedin ?sheet Finisher1_Tray)))
)
(:durative-action Finisher1-Stack-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2158)
 :condition (and
		(at start (Hasallrsrcs ?sheet Finisher1-Stack-Letter)))
 :effect (and

		(at end (Available Finisher1_EntryNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet Finisher1-Stack-Letter))))
)
(:durative-action Finisher2-PassThrough-Letter
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 8000)
 :condition (and
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Finisher2_Entry-Finisher1_Exit)))
 :effect (and
		(at start (not (Location ?sheet Finisher2_Entry-Finisher1_Exit)))
		(at end (Location ?sheet Finisher2_Exit)))
)
(:durative-action Finisher2-Stack-Letter-0
 :parameters ( ?sheet - sheet_t ?prevsheet - sheet_t)
 :duration (= ?duration 8000)
 :condition (and
		(at start (Prevsheet ?sheet ?prevsheet))
		(at start (Location ?prevsheet Some_Finisher_Tray))
		(at start (Sheetsize ?sheet Letter))
		(at start (Location ?sheet Finisher2_Entry-Finisher1_Exit))
		(at start (Available Finisher2_EntryNip-RSRC)))
 :effect (and
		(at start (not (Location ?sheet Finisher2_Entry-Finisher1_Exit)))
		(at start (not (Available Finisher2_EntryNip-RSRC)))
		(at start (Hasallrsrcs ?sheet Finisher2-Stack-Letter))
		(at end (Location ?sheet Some_Finisher_Tray))
		(at end (Stackedin ?sheet Finisher2_Tray)))
)
(:durative-action Finisher2-Stack-Letter-1
 :parameters ( ?sheet - sheet_t)
 :duration (= ?duration 2158)
 :condition (and
		(at start (Hasallrsrcs ?sheet Finisher2-Stack-Letter)))
 :effect (and

		(at end (Available Finisher2_EntryNip-RSRC))
		(at end (not (Hasallrsrcs ?sheet Finisher2-Stack-Letter))))
)
)


