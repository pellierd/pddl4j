(define
	(problem pfile28)
	(:domain  domain_htn)
	(:objects
		package_11 - package
		package_9 - package
		package_15 - package
		package_19 - package
		package_2 - package
		package_18 - package
		package_13 - package
		package_17 - package
		package_1 - package
		package_16 - package
		package_3 - package
		package_0 - package
		package_5 - package
		package_6 - package
		package_10 - package
		package_4 - package
		package_12 - package
		package_7 - package
		package_14 - package
		package_8 - package
		capacity_0 - capacity_number
		capacity_1 - capacity_number
		capacity_2 - capacity_number
		city_loc_8 - location
		city_loc_6 - location
		city_loc_15 - location
		city_loc_0 - location
		city_loc_10 - location
		city_loc_2 - location
		city_loc_1 - location
		city_loc_17 - location
		city_loc_16 - location
		city_loc_18 - location
		city_loc_11 - location
		city_loc_5 - location
		city_loc_14 - location
		city_loc_3 - location
		city_loc_19 - location
		city_loc_4 - location
		city_loc_13 - location
		city_loc_12 - location
		city_loc_7 - location
		city_loc_9 - location
		truck_4 - vehicle
		truck_3 - vehicle
		truck_0 - vehicle
		truck_2 - vehicle
		truck_1 - vehicle
	)
	(:htn
		:parameters ()
		:subtasks (and
		 (task0 (deliver package_0 city_loc_0))
		 (task1 (deliver package_1 city_loc_0))
		 (task2 (deliver package_2 city_loc_7))
		 (task3 (deliver package_3 city_loc_2))
		 (task4 (deliver package_4 city_loc_18))
		 (task5 (deliver package_5 city_loc_4))
		 (task6 (deliver package_6 city_loc_16))
		 (task7 (deliver package_7 city_loc_2))
		 (task8 (deliver package_8 city_loc_6))
		 (task9 (deliver package_9 city_loc_15))
		 (task10 (deliver package_10 city_loc_6))
		 (task11 (deliver package_11 city_loc_10))
		 (task12 (deliver package_12 city_loc_0))
		 (task13 (deliver package_13 city_loc_0))
		 (task14 (deliver package_14 city_loc_0))
		 (task15 (deliver package_15 city_loc_13))
		 (task16 (deliver package_16 city_loc_15))
		 (task17 (deliver package_17 city_loc_15))
		 (task18 (deliver package_18 city_loc_7))
		 (task19 (deliver package_19 city_loc_13))
		)
		:ordering (and
			(task13 < task0)
			(task5 < task1)
			(task12 < task2)
			(task6 < task3)
			(task8 < task4)
			(task9 < task5)
			(task2 < task6)
			(task10 < task7)
			(task14 < task8)
			(task17 < task9)
			(task3 < task10)
			(task7 < task11)
			(task15 < task12)
			(task16 < task13)
			(task18 < task14)
			(task0 < task15)
			(task1 < task16)
			(task11 < task18)
			(task4 < task19)
		)
	)
	(:init
		(capacity_predecessor capacity_0 capacity_1)
		(capacity_predecessor capacity_1 capacity_2)
		(road city_loc_0 city_loc_1)
		(road city_loc_0 city_loc_2)
		(road city_loc_0 city_loc_15)
		(road city_loc_1 city_loc_0)
		(road city_loc_1 city_loc_7)
		(road city_loc_1 city_loc_8)
		(road city_loc_2 city_loc_16)
		(road city_loc_2 city_loc_0)
		(road city_loc_2 city_loc_11)
		(road city_loc_3 city_loc_15)
		(road city_loc_4 city_loc_17)
		(road city_loc_4 city_loc_4)
		(road city_loc_4 city_loc_8)
		(road city_loc_4 city_loc_12)
		(road city_loc_5 city_loc_14)
		(road city_loc_6 city_loc_18)
		(road city_loc_6 city_loc_10)
		(road city_loc_7 city_loc_1)
		(road city_loc_7 city_loc_14)
		(road city_loc_8 city_loc_1)
		(road city_loc_8 city_loc_4)
		(road city_loc_8 city_loc_9)
		(road city_loc_8 city_loc_12)
		(road city_loc_9 city_loc_8)
		(road city_loc_9 city_loc_14)
		(road city_loc_10 city_loc_6)
		(road city_loc_11 city_loc_2)
		(road city_loc_12 city_loc_4)
		(road city_loc_12 city_loc_8)
		(road city_loc_13 city_loc_14)
		(road city_loc_14 city_loc_18)
		(road city_loc_14 city_loc_5)
		(road city_loc_14 city_loc_7)
		(road city_loc_14 city_loc_9)
		(road city_loc_14 city_loc_13)
		(road city_loc_15 city_loc_0)
		(road city_loc_15 city_loc_3)
		(road city_loc_16 city_loc_2)
		(road city_loc_17 city_loc_4)
		(road city_loc_18 city_loc_6)
		(road city_loc_18 city_loc_14)
		(at package_0 city_loc_2)
		(at package_1 city_loc_3)
		(at package_2 city_loc_8)
		(at package_3 city_loc_9)
		(at package_4 city_loc_8)
		(at package_5 city_loc_15)
		(at package_6 city_loc_17)
		(at package_7 city_loc_13)
		(at package_8 city_loc_8)
		(at package_9 city_loc_5)
		(at package_10 city_loc_14)
		(at package_11 city_loc_12)
		(at package_12 city_loc_6)
		(at package_13 city_loc_9)
		(at package_14 city_loc_7)
		(at package_15 city_loc_11)
		(at package_16 city_loc_17)
		(at package_17 city_loc_14)
		(at package_18 city_loc_12)
		(at package_19 city_loc_10)
		(at truck_0 city_loc_2)
		(at truck_1 city_loc_10)
		(at truck_2 city_loc_11)
		(at truck_3 city_loc_4)
		(at truck_4 city_loc_6)
		(capacity truck_0 capacity_2)
		(capacity truck_1 capacity_2)
		(capacity truck_2 capacity_2)
		(capacity truck_3 capacity_2)
		(capacity truck_4 capacity_2)
	)
)