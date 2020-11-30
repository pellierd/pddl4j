(define (problem truck-6)
(:domain Trucks-Time)
(:objects
	truck1 - truck
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
	a1 - truckarea
	a2 - truckarea)

(:init
	(at truck1 l1)
	(free a1 truck1)
	(free a2 truck1)
	(closer a1 a2)
	(at package1 l2)
	(at package2 l2)
	(at package3 l2)
	(at package4 l2)
	(at package5 l1)
	(at package6 l1)
	(at package7 l3)
	(at package8 l3)
	(connected l1 l2)
	(connected l1 l3)
	(connected l2 l1)
	(connected l2 l3)
	(connected l3 l1)
	(connected l3 l2)
	(= (drive-time l1 l2) 1022.9)
	(= (drive-time l1 l3) 900.5)
	(= (drive-time l2 l1) 1022.9)
	(= (drive-time l2 l3) 227.6)
	(= (drive-time l3 l1) 900.5)
	(= (drive-time l3 l2) 227.6))

(:goal (and 
	(delivered package1 l3)
	(delivered package2 l3)
	(delivered package3 l1)
	(delivered package4 l3)
	(delivered package5 l2)
	(delivered package6 l2)
	(delivered package7 l1)
	(delivered package8 l1)))

(:metric minimize (total-time))

)
