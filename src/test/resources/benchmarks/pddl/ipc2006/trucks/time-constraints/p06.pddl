(define (problem truck-6)
(:domain Trucks-Constraints)
(:objects
	truck1 - truck
	truck2 - truck
	package1 - package
	package2 - package
	package3 - package
	package4 - package
	package5 - package
	package6 - package
	package7 - package
	package8 - package
	l1 - location
	l2 - location
	l3 - location
	l4 - location
	a1 - truckarea
	a2 - truckarea
	a3 - truckarea)

(:init
	(at truck1 l4)
	(at truck2 l2)
	(free a1 truck1)
	(free a2 truck1)
	(free a3 truck1)
	(free a1 truck2)
	(free a2 truck2)
	(free a3 truck2)
	(closer a1 a2)
	(closer a1 a3)
	(closer a2 a3)
	(at package1 l4)
	(at package2 l4)
	(at package3 l4)
	(at package4 l1)
	(at package5 l1)
	(at package6 l1)
	(at package7 l1)
	(at package8 l1)
	(connected l1 l2)
	(connected l1 l3)
	(connected l1 l4)
	(connected l2 l1)
	(connected l2 l3)
	(connected l2 l4)
	(connected l3 l1)
	(connected l3 l2)
	(connected l3 l4)
	(connected l4 l1)
	(connected l4 l2)
	(connected l4 l3)
	(= (drive-time l1 l2) 689.2)
	(= (drive-time l1 l3) 468.0)
	(= (drive-time l1 l4) 438.0)
	(= (drive-time l2 l1) 689.2)
	(= (drive-time l2 l3) 244.9)
	(= (drive-time l2 l4) 920.8)
	(= (drive-time l3 l1) 468.0)
	(= (drive-time l3 l2) 244.9)
	(= (drive-time l3 l4) 677.9)
	(= (drive-time l4 l1) 438.0)
	(= (drive-time l4 l2) 920.8)
	(= (drive-time l4 l3) 677.9))

(:goal (and 
	(delivered package1 l1)
	(delivered package3 l2)
	(delivered package6 l4)))

(:constraints (and
	(within 1240.0 (delivered package2 l2))
	(within 2731.5 (delivered package4 l4))
	(within 2731.5 (delivered package5 l3))
	(within 3258.7 (delivered package7 l3))
	(within 3258.7 (delivered package8 l4))))

(:metric minimize (total-time))

)
