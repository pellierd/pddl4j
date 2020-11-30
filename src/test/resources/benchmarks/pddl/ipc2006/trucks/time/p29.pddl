(define (problem truck-29)
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
	package30 - package
	package31 - package
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
	(at truck2 l6)
	(at truck3 l6)
	(at truck4 l3)
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
	(at package1 l5)
	(at package2 l5)
	(at package3 l5)
	(at package4 l5)
	(at package5 l5)
	(at package6 l5)
	(at package7 l3)
	(at package8 l3)
	(at package9 l3)
	(at package10 l3)
	(at package11 l3)
	(at package12 l3)
	(at package13 l3)
	(at package14 l3)
	(at package15 l3)
	(at package16 l3)
	(at package17 l3)
	(at package18 l3)
	(at package19 l7)
	(at package20 l7)
	(at package21 l7)
	(at package22 l7)
	(at package23 l7)
	(at package24 l7)
	(at package25 l3)
	(at package26 l3)
	(at package27 l3)
	(at package28 l3)
	(at package29 l3)
	(at package30 l3)
	(at package31 l5)
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
	(= (drive-time l1 l2) 701.0)
	(= (drive-time l1 l3) 553.0)
	(= (drive-time l1 l4) 486.1)
	(= (drive-time l1 l5) 664.4)
	(= (drive-time l1 l6) 649.2)
	(= (drive-time l1 l7) 599.9)
	(= (drive-time l2 l1) 701.0)
	(= (drive-time l2 l3) 413.1)
	(= (drive-time l2 l4) 749.6)
	(= (drive-time l2 l5) 830.9)
	(= (drive-time l2 l6) 606.1)
	(= (drive-time l2 l7) 125.2)
	(= (drive-time l3 l1) 553.0)
	(= (drive-time l3 l2) 413.1)
	(= (drive-time l3 l4) 359.5)
	(= (drive-time l3 l5) 418.0)
	(= (drive-time l3 l6) 202.4)
	(= (drive-time l3 l7) 421.0)
	(= (drive-time l4 l1) 486.1)
	(= (drive-time l4 l2) 749.6)
	(= (drive-time l4 l3) 359.5)
	(= (drive-time l4 l5) 178.6)
	(= (drive-time l4 l6) 275.1)
	(= (drive-time l4 l7) 720.6)
	(= (drive-time l5 l1) 664.4)
	(= (drive-time l5 l2) 830.9)
	(= (drive-time l5 l3) 418.0)
	(= (drive-time l5 l4) 178.6)
	(= (drive-time l5 l6) 248.1)
	(= (drive-time l5 l7) 826.1)
	(= (drive-time l6 l1) 649.2)
	(= (drive-time l6 l2) 606.1)
	(= (drive-time l6 l3) 202.4)
	(= (drive-time l6 l4) 275.1)
	(= (drive-time l6 l5) 248.1)
	(= (drive-time l6 l7) 623.1)
	(= (drive-time l7 l1) 599.9)
	(= (drive-time l7 l2) 125.2)
	(= (drive-time l7 l3) 421.0)
	(= (drive-time l7 l4) 720.6)
	(= (drive-time l7 l5) 826.1)
	(= (drive-time l7 l6) 623.1))

(:goal (and 
	(delivered package1 l7)
	(delivered package2 l7)
	(delivered package3 l2)
	(delivered package4 l7)
	(delivered package5 l2)
	(delivered package6 l1)
	(delivered package7 l4)
	(delivered package8 l7)
	(delivered package9 l1)
	(delivered package10 l4)
	(delivered package11 l2)
	(delivered package12 l2)
	(delivered package13 l6)
	(delivered package14 l1)
	(delivered package15 l4)
	(delivered package16 l4)
	(delivered package17 l4)
	(delivered package18 l1)
	(delivered package19 l3)
	(delivered package20 l1)
	(delivered package21 l1)
	(delivered package22 l5)
	(delivered package23 l4)
	(delivered package24 l2)
	(delivered package25 l4)
	(delivered package26 l4)
	(delivered package27 l5)
	(delivered package28 l6)
	(delivered package29 l4)
	(delivered package30 l7)
	(delivered package31 l4)))

(:metric minimize (total-time))

)
