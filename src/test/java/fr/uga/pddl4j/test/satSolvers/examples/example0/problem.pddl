(define (problem p_moving_robot)
	(:domain moving_robot)

	(:objects
		r - robot
		loc1 loc2 - location
	)

	(:init (at r loc1))

	(:goal (at r loc2))
)
