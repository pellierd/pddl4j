(define (problem truck-23)
(:domain Trucks-Time)
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
	package21 - package
	package22 - package
	package23 - package
	package24 - package
	package25 - package
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
	(at truck2 l6)
	(at truck3 l5)
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
	(at package1 l5)
	(at package2 l5)
	(at package3 l5)
	(at package4 l5)
	(at package5 l5)
	(at package6 l1)
	(at package7 l1)
	(at package8 l1)
	(at package9 l1)
	(at package10 l1)
	(at package11 l6)
	(at package12 l6)
	(at package13 l6)
	(at package14 l6)
	(at package15 l6)
	(at package16 l2)
	(at package17 l2)
	(at package18 l2)
	(at package19 l2)
	(at package20 l2)
	(at package21 l5)
	(at package22 l5)
	(at package23 l5)
	(at package24 l5)
	(at package25 l5)
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
	(= (drive-time l1 l2) 933.3)
	(= (drive-time l1 l3) 647.0)
	(= (drive-time l1 l4) 965.9)
	(= (drive-time l1 l5) 919.5)
	(= (drive-time l1 l6) 368.6)
	(= (drive-time l2 l1) 933.3)
	(= (drive-time l2 l3) 287.1)
	(= (drive-time l2 l4) 53.2)
	(= (drive-time l2 l5) 845.3)
	(= (drive-time l2 l6) 599.8)
	(= (drive-time l3 l1) 647.0)
	(= (drive-time l3 l2) 287.1)
	(= (drive-time l3 l4) 324.0)
	(= (drive-time l3 l5) 772.4)
	(= (drive-time l3 l6) 332.6)
	(= (drive-time l4 l1) 965.9)
	(= (drive-time l4 l2) 53.2)
	(= (drive-time l4 l3) 324.0)
	(= (drive-time l4 l5) 823.8)
	(= (drive-time l4 l6) 623.8)
	(= (drive-time l5 l1) 919.5)
	(= (drive-time l5 l2) 845.3)
	(= (drive-time l5 l3) 772.4)
	(= (drive-time l5 l4) 823.8)
	(= (drive-time l5 l6) 649.6)
	(= (drive-time l6 l1) 368.6)
	(= (drive-time l6 l2) 599.8)
	(= (drive-time l6 l3) 332.6)
	(= (drive-time l6 l4) 623.8)
	(= (drive-time l6 l5) 649.6))

(:goal (and 
	(delivered package1 l1)
	(delivered package2 l4)
	(delivered package3 l1)
	(delivered package4 l3)
	(delivered package5 l6)
	(delivered package6 l6)
	(delivered package7 l3)
	(delivered package8 l3)
	(delivered package9 l6)
	(delivered package10 l3)
	(delivered package11 l3)
	(delivered package12 l5)
	(delivered package13 l3)
	(delivered package14 l5)
	(delivered package15 l3)
	(delivered package16 l4)
	(delivered package17 l1)
	(delivered package18 l3)
	(delivered package19 l4)
	(delivered package20 l4)
	(delivered package21 l4)
	(delivered package22 l6)
	(delivered package23 l2)
	(delivered package24 l1)
	(delivered package25 l6)))

(:metric minimize (total-time))

)
