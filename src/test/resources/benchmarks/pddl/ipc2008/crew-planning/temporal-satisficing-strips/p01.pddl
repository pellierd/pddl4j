(define (problem CrewPlanning_1crew_1day_40utilization)
(:domain CrewPlanning)
(:objects
	d0 d1 d2 - Day

	c1 - CrewMember
	mcs1 - MedicalState

	spaceshipFilter - FilterState

	rpcm1 - RPCM

	e1 - ExerEquipment
)

(:init
	(currentday c1 d0)
	(done_sleep c1 d0)
	(available c1)
	(initiated d1)
	(next d0 d1)
	(next d1 d2)
	
	(unused e1)
	)

(:goal
(and
	(done_sleep c1 d1)
	(initiated d2)


	(changed spaceshipFilter d1)

	(done_rpcm rpcm1 d1)

)
)
(:metric minimize (total-time))
)
