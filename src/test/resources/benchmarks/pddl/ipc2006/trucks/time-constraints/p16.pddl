(define (problem truck-16)
(:domain Trucks-Constraints)
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
	(at truck1 l2)
	(at truck2 l3)
	(at truck3 l2)
	(at truck4 l3)
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
	(at package6 l5)
	(at package7 l5)
	(at package8 l5)
	(at package9 l5)
	(at package10 l5)
	(at package11 l5)
	(at package12 l5)
	(at package13 l5)
	(at package14 l5)
	(at package15 l5)
	(at package16 l3)
	(at package17 l3)
	(at package18 l3)
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
	(= (drive-time l1 l2) 878.5)
	(= (drive-time l1 l3) 247.8)
	(= (drive-time l1 l4) 245.3)
	(= (drive-time l1 l5) 398.4)
	(= (drive-time l1 l6) 430.2)
	(= (drive-time l2 l1) 878.5)
	(= (drive-time l2 l3) 866.5)
	(= (drive-time l2 l4) 634.0)
	(= (drive-time l2 l5) 1181.3)
	(= (drive-time l2 l6) 784.8)
	(= (drive-time l3 l1) 247.8)
	(= (drive-time l3 l2) 866.5)
	(= (drive-time l3 l4) 301.2)
	(= (drive-time l3 l5) 316.2)
	(= (drive-time l3 l6) 203.6)
	(= (drive-time l4 l1) 245.3)
	(= (drive-time l4 l2) 634.0)
	(= (drive-time l4 l3) 301.2)
	(= (drive-time l4 l5) 582.0)
	(= (drive-time l4 l6) 371.1)
	(= (drive-time l5 l1) 398.4)
	(= (drive-time l5 l2) 1181.3)
	(= (drive-time l5 l3) 316.2)
	(= (drive-time l5 l4) 582.0)
	(= (drive-time l5 l6) 466.7)
	(= (drive-time l6 l1) 430.2)
	(= (drive-time l6 l2) 784.8)
	(= (drive-time l6 l3) 203.6)
	(= (drive-time l6 l4) 371.1)
	(= (drive-time l6 l5) 466.7))

(:goal (and 
	(delivered package9 l4)))

(:constraints (and
	(within 3903.8 (delivered package1 l1))
	(within 3903.8 (delivered package2 l5))
	(within 3903.8 (delivered package3 l6))
	(within 3903.8 (delivered package4 l2))
	(within 3903.8 (delivered package5 l6))
	(within 2409.1 (delivered package6 l4))
	(within 2409.1 (delivered package7 l6))
	(within 2409.1 (delivered package8 l1))
	(within 2409.1 (delivered package10 l1))
	(within 2827.7 (delivered package11 l1))
	(within 2827.7 (delivered package12 l3))
	(within 2827.7 (delivered package13 l1))
	(within 2827.7 (delivered package14 l3))
	(within 2827.7 (delivered package15 l1))
	(within 1396.2 (delivered package16 l5))
	(within 1396.2 (delivered package17 l4))
	(within 1396.2 (delivered package18 l6))))

(:metric minimize (total-time))

)
