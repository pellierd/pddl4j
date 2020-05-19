(define
	(problem p20)
	(:domain transport)
	(:objects
		package_2 - package
		package_1 - package
		package_3 - package
		package_0 - package
		package_5 - package
		package_4 - package
		capacity_0 - capacity_number
		capacity_1 - capacity_number
		capacity_2 - capacity_number
		capacity_3 - capacity_number
		city_loc_8 - location
		city_loc_6 - location
		city_loc_0 - location
		city_loc_10 - location
		city_loc_2 - location
		city_loc_1 - location
		city_loc_11 - location
		city_loc_5 - location
		city_loc_3 - location
		city_loc_4 - location
		city_loc_13 - location
		city_loc_12 - location
		city_loc_7 - location
		city_loc_9 - location
		truck_0 - vehicle
		truck_1 - vehicle
	)
	(:htn
		:ordered-subtasks (and
		    (deliver package_1 city_loc_13)
		    (deliver package_5 city_loc_1)
		    (deliver package_4 city_loc_1)
		    (deliver package_2 city_loc_2)
		    (deliver package_3 city_loc_13)
		    (deliver package_0 city_loc_2)
        )
	)
	(:init
		(capacity_predecessor capacity_0 capacity_1)
		(capacity_predecessor capacity_1 capacity_2)
		(capacity_predecessor capacity_2 capacity_3)
		(road city_loc_0 city_loc_10)
		(road city_loc_0 city_loc_12)
		(road city_loc_1 city_loc_3)
		(road city_loc_1 city_loc_7)
		(road city_loc_1 city_loc_9)
		(road city_loc_1 city_loc_13)
		(road city_loc_2 city_loc_3)
		(road city_loc_2 city_loc_11)
		(road city_loc_3 city_loc_1)
		(road city_loc_3 city_loc_2)
		(road city_loc_3 city_loc_5)
		(road city_loc_3 city_loc_7)
		(road city_loc_3 city_loc_11)
		(road city_loc_3 city_loc_12)
		(road city_loc_4 city_loc_5)
		(road city_loc_4 city_loc_6)
		(road city_loc_4 city_loc_7)
		(road city_loc_5 city_loc_3)
		(road city_loc_5 city_loc_4)
		(road city_loc_5 city_loc_13)
		(road city_loc_6 city_loc_4)
		(road city_loc_6 city_loc_10)
		(road city_loc_6 city_loc_11)
		(road city_loc_7 city_loc_1)
		(road city_loc_7 city_loc_3)
		(road city_loc_7 city_loc_4)
		(road city_loc_7 city_loc_12)
		(road city_loc_8 city_loc_10)
		(road city_loc_9 city_loc_1)
		(road city_loc_9 city_loc_9)
		(road city_loc_9 city_loc_12)
		(road city_loc_9 city_loc_13)
		(road city_loc_10 city_loc_0)
		(road city_loc_10 city_loc_6)
		(road city_loc_10 city_loc_8)
		(road city_loc_11 city_loc_2)
		(road city_loc_11 city_loc_3)
		(road city_loc_11 city_loc_6)
		(road city_loc_12 city_loc_0)
		(road city_loc_12 city_loc_3)
		(road city_loc_12 city_loc_7)
		(road city_loc_12 city_loc_9)
		(road city_loc_13 city_loc_1)
		(road city_loc_13 city_loc_5)
		(road city_loc_13 city_loc_9)
		(at package_0 city_loc_11)
		(at package_1 city_loc_3)
		(at package_2 city_loc_3)
		(at package_3 city_loc_4)
		(at package_4 city_loc_8)
		(at package_5 city_loc_10)
		(at truck_0 city_loc_4)
		(at truck_1 city_loc_13)
		(capacity truck_0 capacity_3)
		(capacity truck_1 capacity_3)
	)
)
