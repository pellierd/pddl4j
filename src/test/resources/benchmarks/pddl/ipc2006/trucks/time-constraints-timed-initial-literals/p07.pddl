(define (problem truck-7)
(:domain Trucks-TimeTIL)
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
	l1 - location
	l2 - location
	l3 - location
	l4 - location
	a1 - truckarea
	a2 - truckarea
	a3 - truckarea)

(:init
	(at truck1 l4)
	(at truck2 l3)
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
	(at package4 l4)
	(at package5 l4)
	(at package6 l4)
	(at package7 l2)
	(at package8 l2)
	(at package9 l2)
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
	(deliverable package1 l1)
	(deliverable package2 l3)
	(deliverable package5 l3)
	(deliverable package6 l2)
	(deliverable package7 l3)
	(deliverable package8 l3)
	(at 1688.6 (not (deliverable package1 l1)))
	(at 1688.6 (not (deliverable package2 l3)))
	(at 1667.6 (not (deliverable package5 l3)))
	(at 1667.6 (not (deliverable package6 l2)))
	(at 3098.5 (not (deliverable package7 l3)))
	(at 3098.5 (not (deliverable package8 l3)))
	(= (drive-time l1 l2) 273.1)
	(= (drive-time l1 l3) 466.2)
	(= (drive-time l1 l4) 294.2)
	(= (drive-time l2 l1) 273.1)
	(= (drive-time l2 l3) 542.4)
	(= (drive-time l2 l4) 329.5)
	(= (drive-time l3 l1) 466.2)
	(= (drive-time l3 l2) 542.4)
	(= (drive-time l3 l4) 213.2)
	(= (drive-time l4 l1) 294.2)
	(= (drive-time l4 l2) 329.5)
	(= (drive-time l4 l3) 213.2))

(:goal (and 
	(delivered package1 l1)
	(delivered package2 l3)
	(at-destination package3 l1)
	(at-destination package4 l1)
	(delivered package5 l3)
	(delivered package6 l2)
	(delivered package7 l3)
	(delivered package8 l3)
	(at-destination package9 l1)))

(:metric minimize (total-time))

)
