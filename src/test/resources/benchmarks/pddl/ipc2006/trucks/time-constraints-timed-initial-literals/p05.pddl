(define (problem truck-5)
(:domain Trucks-TimeTIL)
(:objects
	truck1 - truck
	package1 - package
	package2 - package
	package3 - package
	package4 - package
	package5 - package
	package6 - package
	package7 - package
	l1 - location
	l2 - location
	l3 - location
	a1 - truckarea
	a2 - truckarea)

(:init
	(at truck1 l3)
	(free a1 truck1)
	(free a2 truck1)
	(closer a1 a2)
	(at package1 l2)
	(at package2 l2)
	(at package3 l3)
	(at package4 l3)
	(at package5 l2)
	(at package6 l2)
	(at package7 l2)
	(connected l1 l2)
	(connected l1 l3)
	(connected l2 l1)
	(connected l2 l3)
	(connected l3 l1)
	(connected l3 l2)
	(deliverable package2 l1)
	(deliverable package3 l1)
	(deliverable package7 l3)
	(at 992.8 (not (deliverable package2 l1)))
	(at 1866.7 (not (deliverable package3 l1)))
	(at 2878.0 (not (deliverable package7 l3)))
	(= (drive-time l1 l2) 215.3)
	(= (drive-time l1 l3) 289.6)
	(= (drive-time l2 l1) 215.3)
	(= (drive-time l2 l3) 306.5)
	(= (drive-time l3 l1) 289.6)
	(= (drive-time l3 l2) 306.5))

(:goal (and 
	(at-destination package1 l3)
	(delivered package2 l1)
	(delivered package3 l1)
	(at-destination package4 l2)
	(at-destination package5 l3)
	(at-destination package6 l3)
	(delivered package7 l3)))

(:metric minimize (total-time))

)
