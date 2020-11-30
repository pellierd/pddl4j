(define (problem CrewPlanning_1crew_3day_60utilization)
(:domain CrewPlanning)
(:objects
	d0 d1 d2 d3 d4 - Day

	c1 - CrewMember
	mcs1 - MedicalState

	spaceshipFilter - FilterState

	pa1_1 pa1_2 pa1_3 pa1_4 pa2_1 pa2_2 pa2_3 pa2_4 pa2_5 pa2_6 pa3_1 pa3_2 pa3_3 pa3_4 pa3_5 pa3_6 pa3_7 - PayloadAct

	e1 - ExerEquipment
)

(:init
	(currentday c1 d0)
	(done_sleep c1 d0)
	(available c1)
	(initiated d1)
	(next d0 d1)
	(next d1 d2)
	(next d2 d3)
	(next d3 d4)
	
	(unused e1)
	)

(:goal
(and
	(done_sleep c1 d1)
	(done_sleep c1 d2)
	(done_sleep c1 d3)
	(initiated d4)

	(mcs_finished mcs1 d3)

	(changed spaceshipFilter d1)
	(changed spaceshipFilter d2)
	(changed spaceshipFilter d3)


	(payload_act_completed pa1_1 d1)
	(payload_act_completed pa1_2 d1)
	(payload_act_completed pa1_3 d1)
	(payload_act_completed pa1_4 d1)
	(payload_act_completed pa2_1 d2)
	(payload_act_completed pa2_2 d2)
	(payload_act_completed pa2_3 d2)
	(payload_act_completed pa2_4 d2)
	(payload_act_completed pa2_5 d2)
	(payload_act_completed pa2_6 d2)
	(payload_act_completed pa3_1 d3)
	(payload_act_completed pa3_2 d3)
	(payload_act_completed pa3_3 d3)
	(payload_act_completed pa3_4 d3)
	(payload_act_completed pa3_5 d3)
	(payload_act_completed pa3_6 d3)
	(payload_act_completed pa3_7 d3)
)
)
(:metric minimize (total-time))
)
