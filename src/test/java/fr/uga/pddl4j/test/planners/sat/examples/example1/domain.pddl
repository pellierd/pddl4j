(define (domain moving_robot)
	(:requirements :strips :typing)

	(:types robot location package - object)

	(:predicates (atLoc1 ?r - robot)
			     (atLoc2 ?r - robot)
				 (atLoc3 ?r - robot)
	)

	(:action moveLoc1Loc2
		:parameters (?r - robot)
		:precondition (atLoc1 ?r)
		:effect (and (not (atLoc1 ?r)) (atLoc2 ?r))
	)

	(:action moveLoc2Loc3
		:parameters (?r - robot)
		:precondition (atLoc2 ?r)
		:effect (and (not (atLoc2 ?r)) (atLoc3 ?r))
	)

)
