(define (problem CrewPlanning_1crew_2day_80utilization)
(:domain CrewPlanning)
(:objects
	d0 d1 d2 d3 - Day

	c1 - CrewMember
	mcs1 - MedicalState

	spaceshipFilter - FilterState

	pa1_1 pa1_2 pa1_3 pa1_4 pa1_5 pa1_6 pa2_1 pa2_2 pa2_3 pa2_4 pa2_5 pa2_6 pa2_7 - PayloadAct

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
	
	(unused e1)
	)

(:goal
(and
	(done_sleep c1 d1)
	(done_sleep c1 d2)
	(initiated d3)


	(changed spaceshipFilter d1)
	(changed spaceshipFilter d2)


	(payload_act_completed pa1_1 d1)
	(payload_act_completed pa1_2 d1)
	(payload_act_completed pa1_3 d1)
	(payload_act_completed pa1_4 d1)
	(payload_act_completed pa1_5 d1)
	(payload_act_completed pa1_6 d1)
	(payload_act_completed pa2_1 d2)
	(payload_act_completed pa2_2 d2)
	(payload_act_completed pa2_3 d2)
	(payload_act_completed pa2_4 d2)
	(payload_act_completed pa2_5 d2)
	(payload_act_completed pa2_6 d2)
	(payload_act_completed pa2_7 d2)
)
)
(:metric minimize (total-time))
)
