(define (domain moving_robot)
	(:requirements :strips :typing)

	(:types robot location - object)

	(:predicates (at ?r - robot ?l - location))

	(:action move
		:parameters (?r - robot ?from - location ?to - location)
		:precondition (at ?r ?from)
		:effect (and (not (at ?r ?from)) (at ?r ?to))
	)
)
