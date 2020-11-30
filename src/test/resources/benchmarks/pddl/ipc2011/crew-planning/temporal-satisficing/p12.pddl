(define (problem CrewPlanning_2crew_3day_80utilization)
(:domain CrewPlanning)
(:objects
	d0 d1 d2 d3 d4 - Day

	c1 c2 - CrewMember
	mcs1 mcs2 - MedicalState

	spaceshipFilter - FilterState

	pa1_1 pa1_2 pa1_3 pa1_4 pa1_5 pa1_6 pa1_7 pa1_8 pa1_9 pa1_10 pa1_11 pa2_1 pa2_2 pa2_3 pa2_4 pa2_5 pa2_6 pa2_7 pa2_8 pa2_9 pa2_10 pa2_11 pa2_12 pa2_13 pa2_14 pa2_15 pa3_1 pa3_2 pa3_3 pa3_4 pa3_5 pa3_6 pa3_7 pa3_8 pa3_9 pa3_10 pa3_11 pa3_12 pa3_13 pa3_14 pa3_15 - PayloadAct

	e1 e2 - ExerEquipment
)

(:init
	(currentday c1 d0)
	(done_sleep c1 d0)
	(available c1)
	(currentday c2 d0)
	(done_sleep c2 d0)
	(available c2)
	(initiated d1)
	(next d0 d1)
	(next d1 d2)
	(next d2 d3)
	(next d3 d4)
	
	(unused e1)
	(unused e2)
	)

(:goal
(and
	(done_sleep c1 d1)
	(done_sleep c1 d2)
	(done_sleep c1 d3)
	(done_sleep c2 d1)
	(done_sleep c2 d2)
	(done_sleep c2 d3)
	(initiated d4)

	(mcs_finished mcs1 d1)
	(mcs_finished mcs2 d1)
	(mcs_finished mcs2 d2)
	(mcs_finished mcs2 d3)

	(changed spaceshipFilter d1)
	(changed spaceshipFilter d2)
	(changed spaceshipFilter d3)


	(payload_act_completed pa1_1 d1)
	(payload_act_completed pa1_2 d1)
	(payload_act_completed pa1_3 d1)
	(payload_act_completed pa1_4 d1)
	(payload_act_completed pa1_5 d1)
	(payload_act_completed pa1_6 d1)
	(payload_act_completed pa1_7 d1)
	(payload_act_completed pa1_8 d1)
	(payload_act_completed pa1_9 d1)
	(payload_act_completed pa1_10 d1)
	(payload_act_completed pa1_11 d1)
	(payload_act_completed pa2_1 d2)
	(payload_act_completed pa2_2 d2)
	(payload_act_completed pa2_3 d2)
	(payload_act_completed pa2_4 d2)
	(payload_act_completed pa2_5 d2)
	(payload_act_completed pa2_6 d2)
	(payload_act_completed pa2_7 d2)
	(payload_act_completed pa2_8 d2)
	(payload_act_completed pa2_9 d2)
	(payload_act_completed pa2_10 d2)
	(payload_act_completed pa2_11 d2)
	(payload_act_completed pa2_12 d2)
	(payload_act_completed pa2_13 d2)
	(payload_act_completed pa2_14 d2)
	(payload_act_completed pa2_15 d2)
	(payload_act_completed pa3_1 d3)
	(payload_act_completed pa3_2 d3)
	(payload_act_completed pa3_3 d3)
	(payload_act_completed pa3_4 d3)
	(payload_act_completed pa3_5 d3)
	(payload_act_completed pa3_6 d3)
	(payload_act_completed pa3_7 d3)
	(payload_act_completed pa3_8 d3)
	(payload_act_completed pa3_9 d3)
	(payload_act_completed pa3_10 d3)
	(payload_act_completed pa3_11 d3)
	(payload_act_completed pa3_12 d3)
	(payload_act_completed pa3_13 d3)
	(payload_act_completed pa3_14 d3)
	(payload_act_completed pa3_15 d3)
)
)
(:metric minimize (total-time))
)
