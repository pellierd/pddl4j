(define (problem truck-18)
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
	package19 - package
	package20 - package
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
	(at truck1 l3)
	(at truck2 l4)
	(at truck3 l6)
	(at truck4 l4)
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
	(at package1 l5)
	(at package2 l5)
	(at package3 l5)
	(at package4 l5)
	(at package5 l5)
	(at package6 l5)
	(at package7 l5)
	(at package8 l5)
	(at package9 l5)
	(at package10 l5)
	(at package11 l3)
	(at package12 l3)
	(at package13 l3)
	(at package14 l3)
	(at package15 l3)
	(at package16 l4)
	(at package17 l4)
	(at package18 l4)
	(at package19 l4)
	(at package20 l4)
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
	(= (drive-time l1 l2) 841.8)
	(= (drive-time l1 l3) 872.1)
	(= (drive-time l1 l4) 561.8)
	(= (drive-time l1 l5) 597.2)
	(= (drive-time l1 l6) 745.4)
	(= (drive-time l2 l1) 841.8)
	(= (drive-time l2 l3) 382.8)
	(= (drive-time l2 l4) 375.9)
	(= (drive-time l2 l5) 343.2)
	(= (drive-time l2 l6) 288.5)
	(= (drive-time l3 l1) 872.1)
	(= (drive-time l3 l2) 382.8)
	(= (drive-time l3 l4) 315.7)
	(= (drive-time l3 l5) 619.9)
	(= (drive-time l3 l6) 636.3)
	(= (drive-time l4 l1) 561.8)
	(= (drive-time l4 l2) 375.9)
	(= (drive-time l4 l3) 315.7)
	(= (drive-time l4 l5) 403.1)
	(= (drive-time l4 l6) 486.8)
	(= (drive-time l5 l1) 597.2)
	(= (drive-time l5 l2) 343.2)
	(= (drive-time l5 l3) 619.9)
	(= (drive-time l5 l4) 403.1)
	(= (drive-time l5 l6) 148.2)
	(= (drive-time l6 l1) 745.4)
	(= (drive-time l6 l2) 288.5)
	(= (drive-time l6 l3) 636.3)
	(= (drive-time l6 l4) 486.8)
	(= (drive-time l6 l5) 148.2))

(:goal (and 
	(delivered package1 l2)
	(delivered package2 l1)
	(delivered package6 l6)
	(delivered package8 l6)))

(:constraints (and
	(within 2911.5 (delivered package3 l2))
	(within 2911.5 (delivered package4 l2))
	(within 2911.5 (delivered package5 l2))
	(within 2190.1 (delivered package7 l2))
	(within 2190.1 (delivered package9 l4))
	(within 2190.1 (delivered package10 l2))
	(within 2915.3 (delivered package11 l2))
	(within 2915.3 (delivered package12 l6))
	(within 2915.3 (delivered package13 l6))
	(within 2915.3 (delivered package14 l1))
	(within 2915.3 (delivered package15 l5))
	(within 3127.4 (delivered package16 l5))
	(within 3127.4 (delivered package17 l2))
	(within 3127.4 (delivered package18 l3))
	(within 3127.4 (delivered package19 l1))
	(within 3127.4 (delivered package20 l2))))

(:metric minimize (total-time))

)
