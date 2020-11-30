(define (problem CrewPlanning_1crew_3day_80utilization)
(:domain CrewPlanning)
(:objects
	d0 d1 d2 d3 d4 - Day

	c1 - CrewMember
	mcs1 - MedicalState

	spaceshipFilter - FilterState

	rpcm2 rpcm3 - RPCM

	pa1_1 pa1_2 pa1_3 pa1_4 pa1_5 pa1_6 pa2_1 - PayloadAct

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

	(mcs_finished mcs1 d1)
	(mcs_finished mcs1 d2)
	(mcs_finished mcs1 d3)

	(changed spaceshipFilter d2)
	(changed spaceshipFilter d3)

	(done_rpcm rpcm2 d2)
	(done_rpcm rpcm3 d3)

	(payload_act_completed pa1_1 d1)
	(payload_act_completed pa1_2 d1)
	(payload_act_completed pa1_3 d1)
	(payload_act_completed pa1_4 d1)
	(payload_act_completed pa1_5 d1)
	(payload_act_completed pa1_6 d1)
	(payload_act_completed pa2_1 d2)
)
)
(:metric minimize (total-time))
)
