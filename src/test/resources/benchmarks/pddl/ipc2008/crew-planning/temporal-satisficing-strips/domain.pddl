(define (domain CrewPlanning)
(:requirements :typing :durative-actions)
(:types MedicalState FilterState CrewMember PayloadAct Day
          ExerEquipment RPCM - objects)

(:predicates
	(mcs_finished ?ps - MedicalState ?d - Day)

	(changed ?fs - FilterState ?d - Day)
	(available ?c - CrewMember)

	;; Predicates to order actions in CrewPlanner's DailyRoutine HTN schema
	(done_sleep ?c - CrewMember ?d - Day)
	(done_pre_sleep ?c - CrewMember ?d - Day)
	(done_post_sleep ?c - CrewMember ?d - Day)
	(done_dpc ?c - CrewMember ?d - Day)
	(done_meal ?c - CrewMember ?d - Day)
	(done_exercise ?c - CrewMember ?d - Day)
	
	;; Predicates to order actions in RPCM's Perform HTN schema
	(done_remove_sleep_station ?ps - RPCM)
	(done_first_reconfigure_thermal_loop ?ps - RPCM)
	(done_replace_rpcm ?ps - RPCM)
	(done_assemble_sleep_station ?ps - RPCM)
	(done_second_reconfigure_thermal_loop ?ps - RPCM)
	(done_rpcm ?ps - RPCM ?d - Day)

	;; To indicate that a PayloadActivity is done
	(payload_act_done ?pa - PayloadAct)
	(payload_act_completed ?pa - PayloadAct ?d - Day)

	;; Day concept to approximate the temporal constraints on actions/goals
	(next ?d1 ?d2 - Day)
	(currentday ?c - CrewMember ?d - Day)
	(initiated ?d - Day)

	(unused ?e - ExerEquipment)
)


;;
;; Artificial action to enforce each day to be at least 1440 minutes
;; (still can't model so that each day is exactly 1440 minutes)
(:durative-action initialize_day
 :parameters (?d1 ?d2 - Day)
 :duration (= ?duration 1440)
 :condition (and (at start (initiated ?d1))
	         (over all (next ?d1 ?d2)))
 :effect (and (at end (initiated ?d2)))
)


;;
;; Daily routine by CrewPlanner (start the day with "post_sleep")
;;
;; Proper encoding needs to add "clip" actions to concatenate different days

(:durative-action post_sleep
 :parameters (?c - CrewMember ?d1 ?d2 - Day)
 :duration (= ?duration 195)
 :condition (and (at start (done_sleep ?c ?d1))
	        (at start (currentday ?c ?d1))
	        (over all (next ?d1 ?d2))
	        (at start (initiated ?d2)))
 :effect (and (at start (not (currentday ?c ?d1)))
	   (at end (currentday ?c ?d2))
	   (at end (available ?c))
	   (at end (done_post_sleep ?c ?d2)))
)


(:durative-action have_meal
 :parameters (?c - CrewMember ?d - Day)
 :duration (= ?duration 60)
 :condition (and  (at start (available ?c))
	         (at start (done_post_sleep ?c ?d))
	         (over all (currentday ?c ?d)))
 :effect (and (at start (not (available ?c)))
	   (at end (available ?c))
	   (at end (done_meal ?c ?d)))
)


(:durative-action exercise
 :parameters (?c - CrewMember ?d - Day ?e - ExerEquipment)
 :duration (= ?duration 60)
 :condition (and (at start (available ?c))
	        (at start (done_post_sleep ?c ?d))
	        (at start (unused ?e))
	        (over all (currentday ?c ?d)))
 :effect (and (at start (not (available ?c)))
	   (at end (available ?c))
	   (at start (not (unused ?e)))
	   (at end (unused ?e))
	   (at end (done_exercise ?c ?d)))
)



;; Crew member will be available again after the "post-sleep" action
(:durative-action sleep
 :parameters (?c - CrewMember ?d - Day)
 :duration ( = ?duration 600)
 :condition (and (at start (available ?c))
	         (at start (done_exercise ?c ?d))
	         (at start (done_meal ?c ?d))
	         (over all (currentday ?c ?d)))
 :effect (and (at start (not (available ?c)))
	   (at end (done_sleep ?c ?d)))
)


(:durative-action change_filter
 :parameters (?fs - FilterState ?c - CrewMember ?d - Day)
 :duration (= ?duration 60)
 :condition (and (at start (available ?c))
	         (over all (currentday ?c ?d)))
 :effect (and (at start (not (available ?c)))
	   (at end (available ?c))
	   (at end (changed ?fs ?d)))
)

;; Need to do the same thing for "change_filter"
(:durative-action medical_conference
 :parameters (?ps - MedicalState ?c - CrewMember ?d - Day)
 :duration (= ?duration 60)
 :condition (and (at start (available ?c))
	        (over all (currentday ?c ?d)))
 :effect (and (at start (not (available ?c)))
	   (at end (available ?c))
	   (at end (mcs_finished ?ps ?d)))
)



(:durative-action conduct_payload_activity
 :parameters (?pa - PayloadAct ?c - CrewMember)
 :duration (= ?duration 60)
 :condition (and (at start (available ?c)))
 :effect (and (at start (not (available ?c)))
	   (at end (available ?c))
	   (at end (payload_act_done ?pa)))
)


;; This action to set the deadline for completing each payload activity
(:durative-action report_payload_activity_at_deadline
 :parameters (?pa - PayloadAct ?c - CrewMember ?d - Day)
 :duration (= ?duration 1)
 :condition (and (over all (currentday ?c ?d))
	         (at start (payload_act_done ?pa)))
 :effect (and  (at end (payload_act_completed ?pa ?d)))
)



;;
;; RPCM R&R Actions
;;

(:durative-action first_reconfigurate_thermal_loops
 :parameters (?ps - RPCM ?c - CrewMember)
 :duration (= ?duration 60)
 :condition (and (at start (available ?c)))
 :effect (and (at start (not (available ?c)))
	   (at end (available ?c))
	   (at end (done_first_reconfigure_thermal_loop ?ps)))
)


(:durative-action remove_sleep_station
 :parameters (?ps - RPCM ?c - CrewMember)
 :duration (= ?duration 60)
 :condition (and (at start (available ?c)))
 :effect (and (at start (not (available ?c)))
	   (at end (available ?c))
	   (at end (done_remove_sleep_station ?ps)))
)



(:durative-action replace_rpcm
 :parameters (?ps - RPCM ?c - CrewMember)
 :duration (= ?duration 180)
 :condition (and (at start (available ?c))
	         (at start (done_remove_sleep_station ?ps))
	         (at start (done_first_reconfigure_thermal_loop ?ps)))
 :effect (and (at start (not (available ?c)))
	   (at end (available ?c))
	   (at end (done_replace_rpcm ?ps)))
)



(:durative-action assemble_sleep_station
 :parameters (?ps - RPCM ?c - CrewMember)
 :duration (= ?duration 60)
 :condition (and (at start (available ?c))
	         (at start (done_replace_rpcm ?ps)))
 :effect (and (at start (not (available ?c)))
	   (at end (available ?c))
	   (at end (done_assemble_sleep_station ?ps)))
)


(:durative-action second_reconfigurate_thermal_loops
 :parameters (?ps - RPCM ?c - CrewMember)
 :duration (= ?duration 60)
 :condition (and (at start (available ?c))
	         (at start (done_replace_rpcm ?ps)))
 :effect (and (at start (not (available ?c)))
	   (at end (available ?c))
	   (at end (done_second_reconfigure_thermal_loop ?ps)))
)


(:durative-action finish_rpcm
 :parameters (?ps - RPCM ?c - CrewMember ?d - Day)
 :duration (= ?duration 1)
 :condition (and (at start (done_assemble_sleep_station ?ps))
	         (at start (done_second_reconfigure_thermal_loop ?ps))
	         (over all (currentday ?c ?d)))
 :effect (and (at end (done_rpcm ?ps ?d)))
)

)

;; EOF
