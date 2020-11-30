(define (problem truck-19)
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
	(at truck2 l4)
	(at truck3 l6)
	(at truck4 l2)
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
	(at package1 l4)
	(at package2 l4)
	(at package3 l4)
	(at package4 l4)
	(at package5 l4)
	(at package6 l5)
	(at package7 l5)
	(at package8 l5)
	(at package9 l5)
	(at package10 l5)
	(at package11 l6)
	(at package12 l6)
	(at package13 l6)
	(at package14 l6)
	(at package15 l6)
	(at package16 l6)
	(at package17 l6)
	(at package18 l6)
	(at package19 l6)
	(at package20 l6)
	(at package21 l6)
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
	(= (drive-time l1 l2) 635.2)
	(= (drive-time l1 l3) 175.6)
	(= (drive-time l1 l4) 906.4)
	(= (drive-time l1 l5) 524.0)
	(= (drive-time l1 l6) 726.5)
	(= (drive-time l2 l1) 635.2)
	(= (drive-time l2 l3) 792.6)
	(= (drive-time l2 l4) 550.2)
	(= (drive-time l2 l5) 516.3)
	(= (drive-time l2 l6) 347.8)
	(= (drive-time l3 l1) 175.6)
	(= (drive-time l3 l2) 792.6)
	(= (drive-time l3 l4) 989.9)
	(= (drive-time l3 l5) 689.7)
	(= (drive-time l3 l6) 832.4)
	(= (drive-time l4 l1) 906.4)
	(= (drive-time l4 l2) 550.2)
	(= (drive-time l4 l3) 989.9)
	(= (drive-time l4 l5) 1035.8)
	(= (drive-time l4 l6) 213.8)
	(= (drive-time l5 l1) 524.0)
	(= (drive-time l5 l2) 516.3)
	(= (drive-time l5 l3) 689.7)
	(= (drive-time l5 l4) 1035.8)
	(= (drive-time l5 l6) 822.0)
	(= (drive-time l6 l1) 726.5)
	(= (drive-time l6 l2) 347.8)
	(= (drive-time l6 l3) 832.4)
	(= (drive-time l6 l4) 213.8)
	(= (drive-time l6 l5) 822.0))

(:goal (and 
	(delivered package1 l2)
	(delivered package2 l3)
	(delivered package3 l3)
	(delivered package4 l2)
	(delivered package5 l1)
	(delivered package6 l3)
	(delivered package7 l4)
	(delivered package8 l4)
	(delivered package9 l3)
	(delivered package10 l6)
	(delivered package11 l3)
	(delivered package12 l5)
	(delivered package13 l5)
	(delivered package14 l3)
	(delivered package15 l3)
	(delivered package16 l5)
	(delivered package17 l5)
	(delivered package18 l2)
	(delivered package19 l3)
	(delivered package20 l5)
	(delivered package21 l2)))

(:metric minimize (total-time))

)
