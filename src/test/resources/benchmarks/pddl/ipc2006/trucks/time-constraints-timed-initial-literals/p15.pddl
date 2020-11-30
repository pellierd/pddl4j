(define (problem truck-15)
(:domain Trucks-TimeTIL)
(:objects
	truck1 - truck
	truck2 - truck
	truck3 - truck
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
	l1 - location
	l2 - location
	l3 - location
	l4 - location
	l5 - location
	a1 - truckarea
	a2 - truckarea
	a3 - truckarea
	a4 - truckarea)

(:init
	(at truck1 l3)
	(at truck2 l5)
	(at truck3 l3)
	(free a1 truck1)
	(free a2 truck1)
	(free a3 truck1)
	(free a4 truck1)
	(free a1 truck2)
	(free a2 truck2)
	(free a3 truck2)
	(free a4 truck2)
	(free a1 truck3)
	(free a2 truck3)
	(free a3 truck3)
	(free a4 truck3)
	(closer a1 a2)
	(closer a1 a3)
	(closer a1 a4)
	(closer a2 a3)
	(closer a2 a4)
	(closer a3 a4)
	(at package1 l4)
	(at package2 l4)
	(at package3 l4)
	(at package4 l4)
	(at package5 l5)
	(at package6 l5)
	(at package7 l5)
	(at package8 l5)
	(at package9 l3)
	(at package10 l3)
	(at package11 l3)
	(at package12 l3)
	(at package13 l4)
	(at package14 l4)
	(at package15 l4)
	(at package16 l4)
	(at package17 l3)
	(connected l1 l2)
	(connected l1 l3)
	(connected l1 l4)
	(connected l1 l5)
	(connected l2 l1)
	(connected l2 l3)
	(connected l2 l4)
	(connected l2 l5)
	(connected l3 l1)
	(connected l3 l2)
	(connected l3 l4)
	(connected l3 l5)
	(connected l4 l1)
	(connected l4 l2)
	(connected l4 l3)
	(connected l4 l5)
	(connected l5 l1)
	(connected l5 l2)
	(connected l5 l3)
	(connected l5 l4)
	(deliverable package3 l1)
	(deliverable package4 l3)
	(deliverable package7 l2)
	(deliverable package9 l2)
	(deliverable package10 l4)
	(deliverable package12 l1)
	(deliverable package15 l2)
	(deliverable package17 l1)
	(at 2184.0 (not (deliverable package3 l1)))
	(at 2184.0 (not (deliverable package4 l3)))
	(at 1291.6 (not (deliverable package7 l2)))
	(at 828.8 (not (deliverable package9 l2)))
	(at 828.8 (not (deliverable package10 l4)))
	(at 828.8 (not (deliverable package12 l1)))
	(at 3308.5 (not (deliverable package15 l2)))
	(at 2377.3 (not (deliverable package17 l1)))
	(= (drive-time l1 l2) 54.1)
	(= (drive-time l1 l3) 493.5)
	(= (drive-time l1 l4) 114.1)
	(= (drive-time l1 l5) 343.9)
	(= (drive-time l2 l1) 54.1)
	(= (drive-time l2 l3) 495.9)
	(= (drive-time l2 l4) 143.6)
	(= (drive-time l2 l5) 357.9)
	(= (drive-time l3 l1) 493.5)
	(= (drive-time l3 l2) 495.9)
	(= (drive-time l3 l4) 390.9)
	(= (drive-time l3 l5) 169.9)
	(= (drive-time l4 l1) 114.1)
	(= (drive-time l4 l2) 143.6)
	(= (drive-time l4 l3) 390.9)
	(= (drive-time l4 l5) 233.3)
	(= (drive-time l5 l1) 343.9)
	(= (drive-time l5 l2) 357.9)
	(= (drive-time l5 l3) 169.9)
	(= (drive-time l5 l4) 233.3))

(:goal (and 
	(at-destination package1 l1)
	(at-destination package2 l3)
	(delivered package3 l1)
	(delivered package4 l3)
	(at-destination package5 l4)
	(at-destination package6 l3)
	(delivered package7 l2)
	(at-destination package8 l1)
	(delivered package9 l2)
	(delivered package10 l4)
	(at-destination package11 l4)
	(delivered package12 l1)
	(at-destination package13 l5)
	(at-destination package14 l1)
	(delivered package15 l2)
	(at-destination package16 l2)
	(delivered package17 l1)))

(:metric minimize (total-time))

)
