(define (problem truck-17)
(:domain Trucks-TimeTIL)
(:objects
	truck1 - truck
	truck2 - truck
	truck3 - truck
	truck4 - truck
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
	package14 - package
	package15 - package
	package16 - package
	package17 - package
	package18 - package
	package19 - package
	l1 - location
	l2 - location
	l3 - location
	l4 - location
	l5 - location
	l6 - location
	a1 - truckarea
	a2 - truckarea
	a3 - truckarea
	a4 - truckarea
	a5 - truckarea)

(:init
	(at truck1 l6)
	(at truck2 l4)
	(at truck3 l1)
	(at truck4 l6)
	(free a1 truck1)
	(free a2 truck1)
	(free a3 truck1)
	(free a4 truck1)
	(free a5 truck1)
	(free a1 truck2)
	(free a2 truck2)
	(free a3 truck2)
	(free a4 truck2)
	(free a5 truck2)
	(free a1 truck3)
	(free a2 truck3)
	(free a3 truck3)
	(free a4 truck3)
	(free a5 truck3)
	(free a1 truck4)
	(free a2 truck4)
	(free a3 truck4)
	(free a4 truck4)
	(free a5 truck4)
	(closer a1 a2)
	(closer a1 a3)
	(closer a1 a4)
	(closer a1 a5)
	(closer a2 a3)
	(closer a2 a4)
	(closer a2 a5)
	(closer a3 a4)
	(closer a3 a5)
	(closer a4 a5)
	(at package1 l3)
	(at package2 l3)
	(at package3 l3)
	(at package4 l3)
	(at package5 l3)
	(at package6 l2)
	(at package7 l2)
	(at package8 l2)
	(at package9 l2)
	(at package10 l2)
	(at package11 l5)
	(at package12 l5)
	(at package13 l5)
	(at package14 l5)
	(at package15 l5)
	(at package16 l2)
	(at package17 l2)
	(at package18 l2)
	(at package19 l2)
	(connected l1 l2)
	(connected l1 l3)
	(connected l1 l4)
	(connected l1 l5)
	(connected l1 l6)
	(connected l2 l1)
	(connected l2 l3)
	(connected l2 l4)
	(connected l2 l5)
	(connected l2 l6)
	(connected l3 l1)
	(connected l3 l2)
	(connected l3 l4)
	(connected l3 l5)
	(connected l3 l6)
	(connected l4 l1)
	(connected l4 l2)
	(connected l4 l3)
	(connected l4 l5)
	(connected l4 l6)
	(connected l5 l1)
	(connected l5 l2)
	(connected l5 l3)
	(connected l5 l4)
	(connected l5 l6)
	(connected l6 l1)
	(connected l6 l2)
	(connected l6 l3)
	(connected l6 l4)
	(connected l6 l5)
	(deliverable package1 l4)
	(deliverable package2 l4)
	(deliverable package4 l5)
	(deliverable package5 l5)
	(deliverable package6 l4)
	(deliverable package7 l5)
	(deliverable package8 l4)
	(deliverable package11 l2)
	(deliverable package12 l1)
	(deliverable package13 l2)
	(deliverable package14 l1)
	(deliverable package15 l4)
	(deliverable package17 l6)
	(at 1919.5 (not (deliverable package1 l4)))
	(at 1919.5 (not (deliverable package2 l4)))
	(at 1919.5 (not (deliverable package4 l5)))
	(at 1919.5 (not (deliverable package5 l5)))
	(at 3183.3 (not (deliverable package6 l4)))
	(at 3183.3 (not (deliverable package7 l5)))
	(at 3183.3 (not (deliverable package8 l4)))
	(at 3461.7 (not (deliverable package11 l2)))
	(at 3461.7 (not (deliverable package12 l1)))
	(at 3461.7 (not (deliverable package13 l2)))
	(at 3461.7 (not (deliverable package14 l1)))
	(at 3461.7 (not (deliverable package15 l4)))
	(at 1663.8 (not (deliverable package17 l6)))
	(= (drive-time l1 l2) 624.6)
	(= (drive-time l1 l3) 837.2)
	(= (drive-time l1 l4) 536.4)
	(= (drive-time l1 l5) 248.8)
	(= (drive-time l1 l6) 524.0)
	(= (drive-time l2 l1) 624.6)
	(= (drive-time l2 l3) 269.0)
	(= (drive-time l2 l4) 482.1)
	(= (drive-time l2 l5) 488.0)
	(= (drive-time l2 l6) 364.0)
	(= (drive-time l3 l1) 837.2)
	(= (drive-time l3 l2) 269.0)
	(= (drive-time l3 l4) 505.2)
	(= (drive-time l3 l5) 743.1)
	(= (drive-time l3 l6) 629.6)
	(= (drive-time l4 l1) 536.4)
	(= (drive-time l4 l2) 482.1)
	(= (drive-time l4 l3) 505.2)
	(= (drive-time l4 l5) 610.2)
	(= (drive-time l4 l6) 709.3)
	(= (drive-time l5 l1) 248.8)
	(= (drive-time l5 l2) 488.0)
	(= (drive-time l5 l3) 743.1)
	(= (drive-time l5 l4) 610.2)
	(= (drive-time l5 l6) 283.6)
	(= (drive-time l6 l1) 524.0)
	(= (drive-time l6 l2) 364.0)
	(= (drive-time l6 l3) 629.6)
	(= (drive-time l6 l4) 709.3)
	(= (drive-time l6 l5) 283.6))

(:goal (and 
	(delivered package1 l4)
	(delivered package2 l4)
	(at-destination package3 l4)
	(delivered package4 l5)
	(delivered package5 l5)
	(delivered package6 l4)
	(delivered package7 l5)
	(delivered package8 l4)
	(at-destination package9 l4)
	(at-destination package10 l6)
	(delivered package11 l2)
	(delivered package12 l1)
	(delivered package13 l2)
	(delivered package14 l1)
	(delivered package15 l4)
	(at-destination package16 l1)
	(delivered package17 l6)
	(at-destination package18 l6)
	(at-destination package19 l6)))

(:metric minimize (total-time))

)
