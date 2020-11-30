(define (problem CrewPlanning_1crew_2day_100utilization)
(:domain CrewPlanning)
(:objects
	d0 d1 d2 d3 - Day

	c1 - CrewMember
	mcs1 - MedicalState

	spaceshipFilter - FilterState

	rpcm1 - RPCM

	pa2_1 pa2_2 pa2_3 pa2_4 pa2_5 pa2_6 pa2_7 - PayloadAct

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

	(mcs_finished mcs1 d2)

	(changed spaceshipFilter d1)
	(changed spaceshipFilter d2)

	(done_rpcm rpcm1 d1)

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
