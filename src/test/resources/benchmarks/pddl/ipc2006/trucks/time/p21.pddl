(define (problem truck-21)
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
	(at truck1 l1)
	(at truck2 l4)
	(at truck3 l6)
	(at truck4 l5)
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
	(at package11 l5)
	(at package12 l5)
	(at package13 l5)
	(at package14 l5)
	(at package15 l5)
	(at package16 l1)
	(at package17 l1)
	(at package18 l1)
	(at package19 l1)
	(at package20 l1)
	(at package21 l1)
	(at package22 l1)
	(at package23 l1)
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
	(= (drive-time l1 l2) 513.7)
	(= (drive-time l1 l3) 782.2)
	(= (drive-time l1 l4) 99.0)
	(= (drive-time l1 l5) 553.2)
	(= (drive-time l1 l6) 662.6)
	(= (drive-time l2 l1) 513.7)
	(= (drive-time l2 l3) 512.1)
	(= (drive-time l2 l4) 579.3)
	(= (drive-time l2 l5) 782.5)
	(= (drive-time l2 l6) 520.5)
	(= (drive-time l3 l1) 782.2)
	(= (drive-time l3 l2) 512.1)
	(= (drive-time l3 l4) 879.2)
	(= (drive-time l3 l5) 639.9)
	(= (drive-time l3 l6) 176.8)
	(= (drive-time l4 l1) 99.0)
	(= (drive-time l4 l2) 579.3)
	(= (drive-time l4 l3) 879.2)
	(= (drive-time l4 l5) 630.6)
	(= (drive-time l4 l6) 761.6)
	(= (drive-time l5 l1) 553.2)
	(= (drive-time l5 l2) 782.5)
	(= (drive-time l5 l3) 639.9)
	(= (drive-time l5 l4) 630.6)
	(= (drive-time l5 l6) 463.2)
	(= (drive-time l6 l1) 662.6)
	(= (drive-time l6 l2) 520.5)
	(= (drive-time l6 l3) 176.8)
	(= (drive-time l6 l4) 761.6)
	(= (drive-time l6 l5) 463.2))

(:goal (and 
	(delivered package1 l6)
	(delivered package2 l2)
	(delivered package3 l3)
	(delivered package4 l1)
	(delivered package5 l6)
	(delivered package6 l3)
	(delivered package7 l4)
	(delivered package8 l4)
	(delivered package9 l6)
	(delivered package10 l5)
	(delivered package11 l4)
	(delivered package12 l1)
	(delivered package13 l4)
	(delivered package14 l2)
	(delivered package15 l3)
	(delivered package16 l2)
	(delivered package17 l3)
	(delivered package18 l5)
	(delivered package19 l5)
	(delivered package20 l2)
	(delivered package21 l4)
	(delivered package22 l2)
	(delivered package23 l4)))

(:metric minimize (total-time))

)
