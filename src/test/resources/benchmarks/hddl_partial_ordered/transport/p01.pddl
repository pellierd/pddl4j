(define
	(problem p01)
	(:domain transport)
	(:objects
		package_0 - package
		package_1 - package
		capacity_0 - capacity-number
		capacity_1 - capacity-number
		city_loc_0 - location
		city_loc_1 - location
		city_loc_2 - location
		truck_0 - vehicle
	)
	(:htn
		:subtasks (and
		 (task0 (deliver package_0 city_loc_0))
		 (task1 (deliver package_1 city_loc_2))
		)
		:ordering (and
			(task0 < task1)
		)
	)
	(:init
		(capacity-predecessor capacity_0 capacity_1)
		(road city_loc_0 city_loc_1)
		(road city_loc_1 city_loc_0)
		(road city_loc_1 city_loc_2)
		(road city_loc_2 city_loc_1)
		(at package_0 city_loc_1)
		(at package_1 city_loc_1)
		(at truck_0 city_loc_2)
		(capacity truck_0 capacity_1)
	)
)
