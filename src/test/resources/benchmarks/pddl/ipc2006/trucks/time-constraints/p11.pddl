(define (problem truck-11)
(:domain Trucks-Constraints)
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
	(at truck1 l2)
	(at truck2 l3)
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
	(at package9 l5)
	(at package10 l5)
	(at package11 l5)
	(at package12 l5)
	(at package13 l3)
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
	(= (drive-time l1 l2) 647.1)
	(= (drive-time l1 l3) 544.3)
	(= (drive-time l1 l4) 438.0)
	(= (drive-time l1 l5) 210.1)
	(= (drive-time l2 l1) 647.1)
	(= (drive-time l2 l3) 343.3)
	(= (drive-time l2 l4) 467.8)
	(= (drive-time l2 l5) 746.7)
	(= (drive-time l3 l1) 544.3)
	(= (drive-time l3 l2) 343.3)
	(= (drive-time l3 l4) 625.8)
	(= (drive-time l3 l5) 542.4)
	(= (drive-time l4 l1) 438.0)
	(= (drive-time l4 l2) 467.8)
	(= (drive-time l4 l3) 625.8)
	(= (drive-time l4 l5) 636.4)
	(= (drive-time l5 l1) 210.1)
	(= (drive-time l5 l2) 746.7)
	(= (drive-time l5 l3) 542.4)
	(= (drive-time l5 l4) 636.4))

(:goal (and 
	(delivered package2 l5)
	(delivered package9 l1)
	(delivered package10 l2)
	(delivered package11 l4)
	(delivered package12 l4)
	(delivered package13 l1)))

(:constraints (and
	(within 2992.8 (delivered package1 l3))
	(within 2992.8 (delivered package3 l3))
	(within 2992.8 (delivered package4 l5))
	(within 2273.3 (delivered package5 l1))
	(within 2273.3 (delivered package6 l4))
	(within 2273.3 (delivered package7 l1))
	(within 2273.3 (delivered package8 l4))))

(:metric minimize (total-time))

)
