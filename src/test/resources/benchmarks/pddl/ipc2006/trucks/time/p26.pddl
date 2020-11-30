(define (problem truck-26)
(:domain Trucks-Time)
(:objects
	truck1 - truck
	truck2 - truck
	truck3 - truck
	truck4 - truck
	truck5 - truck
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
	package26 - package
	package27 - package
	package28 - package
	l1 - location
	l2 - location
	l3 - location
	l4 - location
	l5 - location
	l6 - location
	l7 - location
	a1 - truckarea
	a2 - truckarea
	a3 - truckarea
	a4 - truckarea
	a5 - truckarea
	a6 - truckarea)

(:init
	(at truck1 l1)
	(at truck2 l1)
	(at truck3 l4)
	(at truck4 l1)
	(at truck5 l3)
	(free a1 truck1)
	(free a2 truck1)
	(free a3 truck1)
	(free a4 truck1)
	(free a5 truck1)
	(free a6 truck1)
	(free a1 truck2)
	(free a2 truck2)
	(free a3 truck2)
	(free a4 truck2)
	(free a5 truck2)
	(free a6 truck2)
	(free a1 truck3)
	(free a2 truck3)
	(free a3 truck3)
	(free a4 truck3)
	(free a5 truck3)
	(free a6 truck3)
	(free a1 truck4)
	(free a2 truck4)
	(free a3 truck4)
	(free a4 truck4)
	(free a5 truck4)
	(free a6 truck4)
	(free a1 truck5)
	(free a2 truck5)
	(free a3 truck5)
	(free a4 truck5)
	(free a5 truck5)
	(free a6 truck5)
	(closer a1 a2)
	(closer a1 a3)
	(closer a1 a4)
	(closer a1 a5)
	(closer a1 a6)
	(closer a2 a3)
	(closer a2 a4)
	(closer a2 a5)
	(closer a2 a6)
	(closer a3 a4)
	(closer a3 a5)
	(closer a3 a6)
	(closer a4 a5)
	(closer a4 a6)
	(closer a5 a6)
	(at package1 l7)
	(at package2 l7)
	(at package3 l7)
	(at package4 l7)
	(at package5 l7)
	(at package6 l7)
	(at package7 l5)
	(at package8 l5)
	(at package9 l5)
	(at package10 l5)
	(at package11 l5)
	(at package12 l5)
	(at package13 l4)
	(at package14 l4)
	(at package15 l4)
	(at package16 l4)
	(at package17 l4)
	(at package18 l4)
	(at package19 l4)
	(at package20 l4)
	(at package21 l4)
	(at package22 l4)
	(at package23 l4)
	(at package24 l4)
	(at package25 l3)
	(at package26 l3)
	(at package27 l3)
	(at package28 l3)
	(connected l1 l2)
	(connected l1 l3)
	(connected l1 l4)
	(connected l1 l5)
	(connected l1 l6)
	(connected l1 l7)
	(connected l2 l1)
	(connected l2 l3)
	(connected l2 l4)
	(connected l2 l5)
	(connected l2 l6)
	(connected l2 l7)
	(connected l3 l1)
	(connected l3 l2)
	(connected l3 l4)
	(connected l3 l5)
	(connected l3 l6)
	(connected l3 l7)
	(connected l4 l1)
	(connected l4 l2)
	(connected l4 l3)
	(connected l4 l5)
	(connected l4 l6)
	(connected l4 l7)
	(connected l5 l1)
	(connected l5 l2)
	(connected l5 l3)
	(connected l5 l4)
	(connected l5 l6)
	(connected l5 l7)
	(connected l6 l1)
	(connected l6 l2)
	(connected l6 l3)
	(connected l6 l4)
	(connected l6 l5)
	(connected l6 l7)
	(connected l7 l1)
	(connected l7 l2)
	(connected l7 l3)
	(connected l7 l4)
	(connected l7 l5)
	(connected l7 l6)
	(= (drive-time l1 l2) 249.7)
	(= (drive-time l1 l3) 676.9)
	(= (drive-time l1 l4) 592.4)
	(= (drive-time l1 l5) 676.4)
	(= (drive-time l1 l6) 312.2)
	(= (drive-time l1 l7) 605.2)
	(= (drive-time l2 l1) 249.7)
	(= (drive-time l2 l3) 666.1)
	(= (drive-time l2 l4) 503.6)
	(= (drive-time l2 l5) 687.9)
	(= (drive-time l2 l6) 444.5)
	(= (drive-time l2 l7) 616.3)
	(= (drive-time l3 l1) 676.9)
	(= (drive-time l3 l2) 666.1)
	(= (drive-time l3 l4) 230.7)
	(= (drive-time l3 l5) 61.3)
	(= (drive-time l3 l6) 423.8)
	(= (drive-time l3 l7) 83.5)
	(= (drive-time l4 l1) 592.4)
	(= (drive-time l4 l2) 503.6)
	(= (drive-time l4 l3) 230.7)
	(= (drive-time l4 l5) 283.6)
	(= (drive-time l4 l6) 441.1)
	(= (drive-time l4 l7) 242.8)
	(= (drive-time l5 l1) 676.4)
	(= (drive-time l5 l2) 687.9)
	(= (drive-time l5 l3) 61.3)
	(= (drive-time l5 l4) 283.6)
	(= (drive-time l5 l6) 404.1)
	(= (drive-time l5 l7) 72.8)
	(= (drive-time l6 l1) 312.2)
	(= (drive-time l6 l2) 444.5)
	(= (drive-time l6 l3) 423.8)
	(= (drive-time l6 l4) 441.1)
	(= (drive-time l6 l5) 404.1)
	(= (drive-time l6 l7) 341.7)
	(= (drive-time l7 l1) 605.2)
	(= (drive-time l7 l2) 616.3)
	(= (drive-time l7 l3) 83.5)
	(= (drive-time l7 l4) 242.8)
	(= (drive-time l7 l5) 72.8)
	(= (drive-time l7 l6) 341.7))

(:goal (and 
	(delivered package1 l1)
	(delivered package2 l4)
	(delivered package3 l5)
	(delivered package4 l3)
	(delivered package5 l5)
	(delivered package6 l1)
	(delivered package7 l4)
	(delivered package8 l3)
	(delivered package9 l2)
	(delivered package10 l2)
	(delivered package11 l6)
	(delivered package12 l1)
	(delivered package13 l7)
	(delivered package14 l2)
	(delivered package15 l2)
	(delivered package16 l7)
	(delivered package17 l1)
	(delivered package18 l3)
	(delivered package19 l5)
	(delivered package20 l6)
	(delivered package21 l2)
	(delivered package22 l6)
	(delivered package23 l2)
	(delivered package24 l6)
	(delivered package25 l6)
	(delivered package26 l6)
	(delivered package27 l5)
	(delivered package28 l4)))

(:metric minimize (total-time))

)
