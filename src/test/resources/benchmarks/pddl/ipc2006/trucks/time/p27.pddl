(define (problem truck-27)
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
	package29 - package
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
	(at truck1 l3)
	(at truck2 l6)
	(at truck3 l4)
	(at truck4 l6)
	(at truck5 l1)
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
	(at package7 l1)
	(at package8 l1)
	(at package9 l1)
	(at package10 l1)
	(at package11 l1)
	(at package12 l1)
	(at package13 l7)
	(at package14 l7)
	(at package15 l7)
	(at package16 l7)
	(at package17 l7)
	(at package18 l7)
	(at package19 l6)
	(at package20 l6)
	(at package21 l6)
	(at package22 l6)
	(at package23 l6)
	(at package24 l6)
	(at package25 l6)
	(at package26 l6)
	(at package27 l6)
	(at package28 l6)
	(at package29 l6)
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
	(= (drive-time l1 l2) 59.1)
	(= (drive-time l1 l3) 423.4)
	(= (drive-time l1 l4) 325.7)
	(= (drive-time l1 l5) 326.5)
	(= (drive-time l1 l6) 264.4)
	(= (drive-time l1 l7) 294.6)
	(= (drive-time l2 l1) 59.1)
	(= (drive-time l2 l3) 434.9)
	(= (drive-time l2 l4) 305.9)
	(= (drive-time l2 l5) 281.3)
	(= (drive-time l2 l6) 320.5)
	(= (drive-time l2 l7) 270.6)
	(= (drive-time l3 l1) 423.4)
	(= (drive-time l3 l2) 434.9)
	(= (drive-time l3 l4) 740.8)
	(= (drive-time l3 l5) 691.4)
	(= (drive-time l3 l6) 380.8)
	(= (drive-time l3 l7) 256.4)
	(= (drive-time l4 l1) 325.7)
	(= (drive-time l4 l2) 305.9)
	(= (drive-time l4 l3) 740.8)
	(= (drive-time l4 l5) 161.6)
	(= (drive-time l4 l6) 545.6)
	(= (drive-time l4 l7) 553.2)
	(= (drive-time l5 l1) 326.5)
	(= (drive-time l5 l2) 281.3)
	(= (drive-time l5 l3) 691.4)
	(= (drive-time l5 l4) 161.6)
	(= (drive-time l5 l6) 585.0)
	(= (drive-time l5 l7) 467.2)
	(= (drive-time l6 l1) 264.4)
	(= (drive-time l6 l2) 320.5)
	(= (drive-time l6 l3) 380.8)
	(= (drive-time l6 l4) 545.6)
	(= (drive-time l6 l5) 585.0)
	(= (drive-time l6 l7) 425.1)
	(= (drive-time l7 l1) 294.6)
	(= (drive-time l7 l2) 270.6)
	(= (drive-time l7 l3) 256.4)
	(= (drive-time l7 l4) 553.2)
	(= (drive-time l7 l5) 467.2)
	(= (drive-time l7 l6) 425.1))

(:goal (and 
	(delivered package1 l6)
	(delivered package2 l2)
	(delivered package3 l6)
	(delivered package4 l6)
	(delivered package5 l4)
	(delivered package6 l5)
	(delivered package7 l7)
	(delivered package8 l3)
	(delivered package9 l7)
	(delivered package10 l5)
	(delivered package11 l6)
	(delivered package12 l3)
	(delivered package13 l2)
	(delivered package14 l1)
	(delivered package15 l4)
	(delivered package16 l4)
	(delivered package17 l6)
	(delivered package18 l2)
	(delivered package19 l4)
	(delivered package20 l5)
	(delivered package21 l2)
	(delivered package22 l1)
	(delivered package23 l5)
	(delivered package24 l3)
	(delivered package25 l2)
	(delivered package26 l1)
	(delivered package27 l1)
	(delivered package28 l3)
	(delivered package29 l5)))

(:metric minimize (total-time))

)
