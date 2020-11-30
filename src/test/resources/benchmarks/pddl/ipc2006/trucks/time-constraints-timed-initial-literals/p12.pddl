(define (problem truck-12)
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
	(at truck2 l1)
	(at truck3 l1)
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
	(at package1 l2)
	(at package2 l2)
	(at package3 l2)
	(at package4 l2)
	(at package5 l1)
	(at package6 l1)
	(at package7 l1)
	(at package8 l1)
	(at package9 l2)
	(at package10 l2)
	(at package11 l2)
	(at package12 l2)
	(at package13 l3)
	(at package14 l3)
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
	(deliverable package2 l4)
	(deliverable package3 l1)
	(deliverable package4 l4)
	(deliverable package5 l5)
	(deliverable package6 l5)
	(deliverable package7 l5)
	(deliverable package10 l3)
	(deliverable package11 l1)
	(deliverable package12 l4)
	(deliverable package13 l2)
	(at 2898.3 (not (deliverable package2 l4)))
	(at 2898.3 (not (deliverable package3 l1)))
	(at 2898.3 (not (deliverable package4 l4)))
	(at 1288.4 (not (deliverable package5 l5)))
	(at 1288.4 (not (deliverable package6 l5)))
	(at 1288.4 (not (deliverable package7 l5)))
	(at 2658.0 (not (deliverable package10 l3)))
	(at 2658.0 (not (deliverable package11 l1)))
	(at 2658.0 (not (deliverable package12 l4)))
	(at 4216.4 (not (deliverable package13 l2)))
	(= (drive-time l1 l2) 149.2)
	(= (drive-time l1 l3) 513.3)
	(= (drive-time l1 l4) 704.9)
	(= (drive-time l1 l5) 681.1)
	(= (drive-time l2 l1) 149.2)
	(= (drive-time l2 l3) 370.9)
	(= (drive-time l2 l4) 621.3)
	(= (drive-time l2 l5) 558.7)
	(= (drive-time l3 l1) 513.3)
	(= (drive-time l3 l2) 370.9)
	(= (drive-time l3 l4) 678.1)
	(= (drive-time l3 l5) 490.2)
	(= (drive-time l4 l1) 704.9)
	(= (drive-time l4 l2) 621.3)
	(= (drive-time l4 l3) 678.1)
	(= (drive-time l4 l5) 237.2)
	(= (drive-time l5 l1) 681.1)
	(= (drive-time l5 l2) 558.7)
	(= (drive-time l5 l3) 490.2)
	(= (drive-time l5 l4) 237.2))

(:goal (and 
	(at-destination package1 l1)
	(delivered package2 l4)
	(delivered package3 l1)
	(delivered package4 l4)
	(delivered package5 l5)
	(delivered package6 l5)
	(delivered package7 l5)
	(at-destination package8 l3)
	(at-destination package9 l5)
	(delivered package10 l3)
	(delivered package11 l1)
	(delivered package12 l4)
	(delivered package13 l2)
	(at-destination package14 l1)))

(:metric minimize (total-time))

)
