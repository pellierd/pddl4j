(define
	(problem p11)
	(:domain transport)
	(:objects
		package_0 - package
		package_1 - package
		package_2 - package
		package_3 - package
		capacity_0 - capacity_number
		capacity_1 - capacity_number
		capacity_2 - capacity_number
		city_loc_0 - location
		city_loc_1 - location
		city_loc_2 - location
		city_loc_3 - location
		truck_0 - vehicle
		truck_1 - vehicle
	)
	(:htn
		:ordered-subtasks (and
		    (deliver package_1 city_loc_3)
		    (deliver package_0 city_loc_1)
            (deliver package_3 city_loc_2)
		    (deliver package_2 city_loc_3)
		)
	)
	(:init
		(capacity_predecessor capacity_0 capacity_1)
		(capacity_predecessor capacity_1 capacity_2)
		(road city_loc_0 city_loc_1)
		(road city_loc_0 city_loc_3)
		(road city_loc_1 city_loc_0)
		(road city_loc_1 city_loc_2)
		(road city_loc_2 city_loc_1)
		(road city_loc_2 city_loc_2)
		(road city_loc_3 city_loc_0)
		(at package_0 city_loc_2)
		(at package_1 city_loc_2)
		(at package_2 city_loc_0)
		(at package_3 city_loc_0)
		(at truck_0 city_loc_0)
		(at truck_1 city_loc_1)
		(capacity truck_0 capacity_2)
		(capacity truck_1 capacity_2)
	)
)
