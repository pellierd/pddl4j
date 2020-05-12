(define
	(problem pfile30)
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
		capacity_3 - capacity_number
		city_loc_24 - location
		city_loc_20 - location
		city_loc_8 - location
		city_loc_6 - location
		city_loc_15 - location
		city_loc_0 - location
		city_loc_10 - location
		city_loc_2 - location
		city_loc_29 - location
		city_loc_23 - location
		city_loc_1 - location
		city_loc_25 - location
		city_loc_27 - location
		city_loc_17 - location
		city_loc_21 - location
		city_loc_16 - location
		city_loc_26 - location
		city_loc_18 - location
		city_loc_11 - location
		city_loc_5 - location
		city_loc_14 - location
		city_loc_3 - location
		city_loc_19 - location
		city_loc_4 - location
		city_loc_13 - location
		city_loc_12 - location
		city_loc_22 - location
		city_loc_28 - location
		city_loc_7 - location
		city_loc_9 - location
		truck_4 - vehicle
		truck_3 - vehicle
		truck_0 - vehicle
		truck_2 - vehicle
		truck_1 - vehicle
		truck_5 - vehicle
	)
	(:htn
		:parameters ()
		:subtasks (and
		 (task0 (deliver package_0 city_loc_4))
		 (task1 (deliver package_1 city_loc_25))
		 (task2 (deliver package_2 city_loc_18))
		 (task3 (deliver package_3 city_loc_24))
		 (task4 (deliver package_4 city_loc_0))
		 (task5 (deliver package_5 city_loc_4))
		 (task6 (deliver package_6 city_loc_24))
		 (task7 (deliver package_7 city_loc_3))
		 (task8 (deliver package_8 city_loc_10))
		 (task9 (deliver package_9 city_loc_10))
		 (task10 (deliver package_10 city_loc_10))
		 (task11 (deliver package_11 city_loc_22))
		 (task12 (deliver package_12 city_loc_28))
		 (task13 (deliver package_13 city_loc_10))
		 (task14 (deliver package_14 city_loc_16))
		 (task15 (deliver package_15 city_loc_20))
		 (task16 (deliver package_16 city_loc_13))
		 (task17 (deliver package_17 city_loc_11))
		 (task18 (deliver package_18 city_loc_11))
		 (task19 (deliver package_19 city_loc_15))
		)
		:ordering (and
			(task3 < task0)
			(task7 < task1)
			(task15 < task2)
			(task9 < task3)
			(task6 < task4)
			(task1 < task5)
			(task17 < task6)
			(task18 < task7)
			(task13 < task8)
			(task16 < task9)
			(task5 < task10)
			(task14 < task11)
			(task0 < task12)
			(task12 < task13)
			(task10 < task15)
			(task19 < task16)
			(task8 < task17)
			(task11 < task18)
			(task2 < task19)
		)
	)
	(:init
		(capacity_predecessor capacity_0 capacity_1)
		(capacity_predecessor capacity_1 capacity_2)
		(capacity_predecessor capacity_2 capacity_3)
		(road city_loc_0 city_loc_16)
		(road city_loc_0 city_loc_2)
		(road city_loc_0 city_loc_20)
		(road city_loc_0 city_loc_22)
		(road city_loc_1 city_loc_29)
		(road city_loc_2 city_loc_0)
		(road city_loc_2 city_loc_5)
		(road city_loc_2 city_loc_7)
		(road city_loc_3 city_loc_3)
		(road city_loc_3 city_loc_21)
		(road city_loc_3 city_loc_7)
		(road city_loc_3 city_loc_26)
		(road city_loc_3 city_loc_13)
		(road city_loc_4 city_loc_4)
		(road city_loc_4 city_loc_5)
		(road city_loc_4 city_loc_7)
		(road city_loc_4 city_loc_25)
		(road city_loc_4 city_loc_14)
		(road city_loc_4 city_loc_15)
		(road city_loc_5 city_loc_2)
		(road city_loc_5 city_loc_18)
		(road city_loc_5 city_loc_19)
		(road city_loc_5 city_loc_4)
		(road city_loc_5 city_loc_15)
		(road city_loc_6 city_loc_8)
		(road city_loc_6 city_loc_24)
		(road city_loc_6 city_loc_26)
		(road city_loc_7 city_loc_2)
		(road city_loc_7 city_loc_19)
		(road city_loc_7 city_loc_3)
		(road city_loc_7 city_loc_20)
		(road city_loc_7 city_loc_4)
		(road city_loc_7 city_loc_12)
		(road city_loc_8 city_loc_16)
		(road city_loc_8 city_loc_6)
		(road city_loc_8 city_loc_24)
		(road city_loc_8 city_loc_26)
		(road city_loc_9 city_loc_21)
		(road city_loc_9 city_loc_26)
		(road city_loc_9 city_loc_11)
		(road city_loc_9 city_loc_13)
		(road city_loc_10 city_loc_27)
		(road city_loc_10 city_loc_29)
		(road city_loc_11 city_loc_20)
		(road city_loc_11 city_loc_22)
		(road city_loc_11 city_loc_9)
		(road city_loc_12 city_loc_7)
		(road city_loc_12 city_loc_28)
		(road city_loc_13 city_loc_3)
		(road city_loc_13 city_loc_20)
		(road city_loc_13 city_loc_9)
		(road city_loc_13 city_loc_26)
		(road city_loc_14 city_loc_18)
		(road city_loc_14 city_loc_4)
		(road city_loc_14 city_loc_21)
		(road city_loc_14 city_loc_26)
		(road city_loc_15 city_loc_4)
		(road city_loc_15 city_loc_5)
		(road city_loc_16 city_loc_0)
		(road city_loc_16 city_loc_17)
		(road city_loc_16 city_loc_22)
		(road city_loc_16 city_loc_8)
		(road city_loc_16 city_loc_28)
		(road city_loc_17 city_loc_16)
		(road city_loc_17 city_loc_19)
		(road city_loc_17 city_loc_20)
		(road city_loc_17 city_loc_26)
		(road city_loc_17 city_loc_27)
		(road city_loc_18 city_loc_20)
		(road city_loc_18 city_loc_5)
		(road city_loc_18 city_loc_23)
		(road city_loc_18 city_loc_26)
		(road city_loc_18 city_loc_14)
		(road city_loc_19 city_loc_17)
		(road city_loc_19 city_loc_19)
		(road city_loc_19 city_loc_5)
		(road city_loc_19 city_loc_7)
		(road city_loc_19 city_loc_25)
		(road city_loc_20 city_loc_0)
		(road city_loc_20 city_loc_17)
		(road city_loc_20 city_loc_18)
		(road city_loc_20 city_loc_7)
		(road city_loc_20 city_loc_11)
		(road city_loc_20 city_loc_13)
		(road city_loc_21 city_loc_3)
		(road city_loc_21 city_loc_24)
		(road city_loc_21 city_loc_9)
		(road city_loc_21 city_loc_26)
		(road city_loc_21 city_loc_14)
		(road city_loc_22 city_loc_16)
		(road city_loc_22 city_loc_0)
		(road city_loc_22 city_loc_27)
		(road city_loc_22 city_loc_11)
		(road city_loc_23 city_loc_18)
		(road city_loc_24 city_loc_21)
		(road city_loc_24 city_loc_6)
		(road city_loc_24 city_loc_8)
		(road city_loc_24 city_loc_25)
		(road city_loc_25 city_loc_19)
		(road city_loc_25 city_loc_4)
		(road city_loc_25 city_loc_24)
		(road city_loc_26 city_loc_17)
		(road city_loc_26 city_loc_18)
		(road city_loc_26 city_loc_3)
		(road city_loc_26 city_loc_21)
		(road city_loc_26 city_loc_6)
		(road city_loc_26 city_loc_8)
		(road city_loc_26 city_loc_9)
		(road city_loc_26 city_loc_13)
		(road city_loc_26 city_loc_14)
		(road city_loc_27 city_loc_17)
		(road city_loc_27 city_loc_22)
		(road city_loc_27 city_loc_10)
		(road city_loc_27 city_loc_27)
		(road city_loc_28 city_loc_16)
		(road city_loc_28 city_loc_12)
		(road city_loc_29 city_loc_1)
		(road city_loc_29 city_loc_10)
		(at package_0 city_loc_11)
		(at package_1 city_loc_20)
		(at package_2 city_loc_14)
		(at package_3 city_loc_26)
		(at package_4 city_loc_7)
		(at package_5 city_loc_8)
		(at package_6 city_loc_7)
		(at package_7 city_loc_27)
		(at package_8 city_loc_3)
		(at package_9 city_loc_24)
		(at package_10 city_loc_12)
		(at package_11 city_loc_0)
		(at package_12 city_loc_16)
		(at package_13 city_loc_24)
		(at package_14 city_loc_23)
		(at package_15 city_loc_12)
		(at package_16 city_loc_18)
		(at package_17 city_loc_29)
		(at package_18 city_loc_2)
		(at package_19 city_loc_4)
		(at truck_0 city_loc_3)
		(at truck_1 city_loc_17)
		(at truck_2 city_loc_13)
		(at truck_3 city_loc_24)
		(at truck_4 city_loc_11)
		(at truck_5 city_loc_1)
		(capacity truck_0 capacity_3)
		(capacity truck_1 capacity_3)
		(capacity truck_2 capacity_3)
		(capacity truck_3 capacity_3)
		(capacity truck_4 capacity_3)
		(capacity truck_5 capacity_3)
	)
)