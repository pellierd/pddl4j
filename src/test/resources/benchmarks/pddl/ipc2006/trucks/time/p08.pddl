(define (problem truck-8)
(:domain Trucks-Time)
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
	package9 - package
	package10 - package
	l1 - location
	l2 - location
	l3 - location
	l4 - location
	a1 - truckarea
	a2 - truckarea
	a3 - truckarea)

(:init
	(at truck1 l4)
	(at truck2 l4)
	(free a1 truck1)
	(free a2 truck1)
	(free a3 truck1)
	(free a1 truck2)
	(free a2 truck2)
	(free a3 truck2)
	(closer a1 a2)
	(closer a1 a3)
	(closer a2 a3)
	(at package1 l3)
	(at package2 l3)
	(at package3 l3)
	(at package4 l4)
	(at package5 l4)
	(at package6 l4)
	(at package7 l4)
	(at package8 l4)
	(at package9 l4)
	(at package10 l4)
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
	(= (drive-time l1 l2) 712.4)
	(= (drive-time l1 l3) 1034.1)
	(= (drive-time l1 l4) 446.9)
	(= (drive-time l2 l1) 712.4)
	(= (drive-time l2 l3) 355.6)
	(= (drive-time l2 l4) 300.8)
	(= (drive-time l3 l1) 1034.1)
	(= (drive-time l3 l2) 355.6)
	(= (drive-time l3 l4) 654.3)
	(= (drive-time l4 l1) 446.9)
	(= (drive-time l4 l2) 300.8)
	(= (drive-time l4 l3) 654.3))

(:goal (and 
	(delivered package1 l1)
	(delivered package2 l1)
	(delivered package3 l1)
	(delivered package4 l2)
	(delivered package5 l2)
	(delivered package6 l1)
	(delivered package7 l3)
	(delivered package8 l2)
	(delivered package9 l2)
	(delivered package10 l1)))

(:metric minimize (total-time))

)
