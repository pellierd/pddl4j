(define (problem truck-3)
(:domain Trucks-TimeTIL)
(:objects
	truck1 - truck
	package1 - package
	package2 - package
	package3 - package
	package4 - package
	package5 - package
	l1 - location
	l2 - location
	l3 - location
	a1 - truckarea
	a2 - truckarea)

(:init
	(at truck1 l2)
	(free a1 truck1)
	(free a2 truck1)
	(closer a1 a2)
	(at package1 l3)
	(at package2 l3)
	(at package3 l2)
	(at package4 l2)
	(at package5 l1)
	(connected l1 l2)
	(connected l1 l3)
	(connected l2 l1)
	(connected l2 l3)
	(connected l3 l1)
	(connected l3 l2)
	(deliverable package2 l2)
	(deliverable package3 l3)
	(deliverable package4 l3)
	(at 616.7 (not (deliverable package2 l2)))
	(at 925.1 (not (deliverable package3 l3)))
	(at 925.1 (not (deliverable package4 l3)))
	(= (drive-time l1 l2) 583.0)
	(= (drive-time l1 l3) 315.5)
	(= (drive-time l2 l1) 583.0)
	(= (drive-time l2 l3) 280.3)
	(= (drive-time l3 l1) 315.5)
	(= (drive-time l3 l2) 280.3))

(:goal (and 
	(at-destination package1 l2)
	(delivered package2 l2)
	(delivered package3 l3)
	(delivered package4 l3)
	(at-destination package5 l3)))

(:metric minimize (total-time))

)
