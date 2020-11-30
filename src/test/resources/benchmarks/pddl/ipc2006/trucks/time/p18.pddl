(define (problem truck-18)
(:domain Trucks-Time)
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
	package18 - package
	package19 - package
	package20 - package
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
	(at truck1 l1)
	(at truck2 l1)
	(at truck3 l4)
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
	(at package1 l1)
	(at package2 l1)
	(at package3 l1)
	(at package4 l1)
	(at package5 l3)
	(at package6 l3)
	(at package7 l3)
	(at package8 l3)
	(at package9 l2)
	(at package10 l2)
	(at package11 l2)
	(at package12 l2)
	(at package13 l4)
	(at package14 l4)
	(at package15 l4)
	(at package16 l4)
	(at package17 l3)
	(at package18 l3)
	(at package19 l3)
	(at package20 l3)
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
	(= (drive-time l1 l2) 802.9)
	(= (drive-time l1 l3) 663.2)
	(= (drive-time l1 l4) 700.1)
	(= (drive-time l1 l5) 667.2)
	(= (drive-time l2 l1) 802.9)
	(= (drive-time l2 l3) 309.8)
	(= (drive-time l2 l4) 703.5)
	(= (drive-time l2 l5) 407.7)
	(= (drive-time l3 l1) 663.2)
	(= (drive-time l3 l2) 309.8)
	(= (drive-time l3 l4) 394.1)
	(= (drive-time l3 l5) 100.0)
	(= (drive-time l4 l1) 700.1)
	(= (drive-time l4 l2) 703.5)
	(= (drive-time l4 l3) 394.1)
	(= (drive-time l4 l5) 296.0)
	(= (drive-time l5 l1) 667.2)
	(= (drive-time l5 l2) 407.7)
	(= (drive-time l5 l3) 100.0)
	(= (drive-time l5 l4) 296.0))

(:goal (and 
	(delivered package1 l3)
	(delivered package2 l5)
	(delivered package3 l5)
	(delivered package4 l3)
	(delivered package5 l5)
	(delivered package6 l2)
	(delivered package7 l2)
	(delivered package8 l4)
	(delivered package9 l1)
	(delivered package10 l1)
	(delivered package11 l1)
	(delivered package12 l4)
	(delivered package13 l2)
	(delivered package14 l3)
	(delivered package15 l2)
	(delivered package16 l2)
	(delivered package17 l5)
	(delivered package18 l1)
	(delivered package19 l1)
	(delivered package20 l5)))

(:metric minimize (total-time))

)
