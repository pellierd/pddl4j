(define
	(problem p24)
	(:domain transport)
	(:objects
		package_11 - package
		package_9 - package
		package_2 - package
		package_13 - package
		package_1 - package
		package_3 - package
		package_0 - package
		package_5 - package
		package_6 - package
		package_10 - package
		package_4 - package
		package_12 - package
		package_7 - package
		package_8 - package
		capacity_0 - capacity_number
		capacity_1 - capacity_number
		capacity_2 - capacity_number
		city_loc_8 - location
		city_loc_6 - location
		city_loc_0 - location
		city_loc_2 - location
		city_loc_1 - location
		city_loc_5 - location
		city_loc_3 - location
		city_loc_4 - location
		city_loc_7 - location
		city_loc_9 - location
		truck_0 - vehicle
		truck_1 - vehicle
		truck_2 - vehicle
		truck_3 - vehicle
	)
	(:htn
		:ordered-subtasks (and
		    (deliver package_12 city_loc_2))
		    (deliver package_1 city_loc_5))
		    (deliver package_5 city_loc_3))
		    (deliver package_13 city_loc_5))
            (deliver package_8 city_loc_8))
            (deliver package_4 city_loc_3))
		    (deliver package_0 city_loc_1))
		    (deliver package_9 city_loc_3))
		    (deliver package_3 city_loc_3))
		    (deliver package_10 city_loc_3))
		    (deliver package_11 city_loc_7))
            (deliver package_2 city_loc_3))
            (deliver package_7 city_loc_0))
            (deliver package_6 city_loc_3))
        )
	)
	(:init
		(capacity_predecessor capacity_0 capacity_1)
		(capacity_predecessor capacity_1 capacity_2)
		(road city_loc_0 city_loc_2)
		(road city_loc_0 city_loc_5)
		(road city_loc_0 city_loc_7)
		(road city_loc_1 city_loc_4)
		(road city_loc_2 city_loc_0)
		(road city_loc_2 city_loc_4)
		(road city_loc_4 city_loc_1)
		(road city_loc_4 city_loc_2)
		(road city_loc_4 city_loc_6)
		(road city_loc_4 city_loc_8)
		(road city_loc_5 city_loc_0)
		(road city_loc_6 city_loc_4)
		(road city_loc_7 city_loc_0)
		(road city_loc_7 city_loc_9)
		(road city_loc_8 city_loc_4)
		(road city_loc_9 city_loc_7)
		(at package_0 city_loc_2)
		(at package_1 city_loc_2)
		(at package_2 city_loc_3)
		(at package_3 city_loc_3)
		(at package_4 city_loc_3)
		(at package_5 city_loc_3)
		(at package_6 city_loc_3)
		(at package_7 city_loc_8)
		(at package_8 city_loc_6)
		(at package_9 city_loc_3)
		(at package_10 city_loc_3)
		(at package_11 city_loc_6)
		(at package_12 city_loc_6)
		(at package_13 city_loc_7)
		(at truck_0 city_loc_8)
		(at truck_1 city_loc_3)
		(at truck_2 city_loc_9)
		(at truck_3 city_loc_4)
		(capacity truck_0 capacity_2)
		(capacity truck_1 capacity_2)
		(capacity truck_2 capacity_2)
		(capacity truck_3 capacity_2)
	)
)
