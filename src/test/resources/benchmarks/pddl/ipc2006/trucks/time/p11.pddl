(define (problem truck-11)
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
	package11 - package
	package12 - package
	package13 - package
	l1 - location
	l2 - location
	l3 - location
	l4 - location
	a1 - truckarea
	a2 - truckarea
	a3 - truckarea)

(:init
	(at truck1 l2)
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
	(at package1 l2)
	(at package2 l2)
	(at package3 l2)
	(at package4 l1)
	(at package5 l1)
	(at package6 l1)
	(at package7 l1)
	(at package8 l1)
	(at package9 l1)
	(at package10 l2)
	(at package11 l2)
	(at package12 l2)
	(at package13 l3)
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
	(= (drive-time l1 l2) 632.5)
	(= (drive-time l1 l3) 24.0)
	(= (drive-time l1 l4) 426.0)
	(= (drive-time l2 l1) 632.5)
	(= (drive-time l2 l3) 655.8)
	(= (drive-time l2 l4) 553.1)
	(= (drive-time l3 l1) 24.0)
	(= (drive-time l3 l2) 655.8)
	(= (drive-time l3 l4) 443.3)
	(= (drive-time l4 l1) 426.0)
	(= (drive-time l4 l2) 553.1)
	(= (drive-time l4 l3) 443.3))

(:goal (and 
	(delivered package1 l4)
	(delivered package2 l3)
	(delivered package3 l1)
	(delivered package4 l3)
	(delivered package5 l2)
	(delivered package6 l4)
	(delivered package7 l3)
	(delivered package8 l2)
	(delivered package9 l4)
	(delivered package10 l4)
	(delivered package11 l1)
	(delivered package12 l4)
	(delivered package13 l2)))

(:metric minimize (total-time))

)
