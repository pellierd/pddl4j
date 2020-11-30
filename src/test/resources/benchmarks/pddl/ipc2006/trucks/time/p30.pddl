(define (problem truck-30)
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
	package32 - package
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
	(at truck1 l7)
	(at truck2 l2)
	(at truck3 l2)
	(at truck4 l6)
	(at truck5 l5)
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
	(at package1 l6)
	(at package2 l6)
	(at package3 l6)
	(at package4 l6)
	(at package5 l6)
	(at package6 l6)
	(at package7 l3)
	(at package8 l3)
	(at package9 l3)
	(at package10 l3)
	(at package11 l3)
	(at package12 l3)
	(at package13 l6)
	(at package14 l6)
	(at package15 l6)
	(at package16 l6)
	(at package17 l6)
	(at package18 l6)
	(at package19 l4)
	(at package20 l4)
	(at package21 l4)
	(at package22 l4)
	(at package23 l4)
	(at package24 l4)
	(at package25 l7)
	(at package26 l7)
	(at package27 l7)
	(at package28 l7)
	(at package29 l7)
	(at package30 l7)
	(at package31 l2)
	(at package32 l2)
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
	(= (drive-time l1 l2) 368.6)
	(= (drive-time l1 l3) 931.5)
	(= (drive-time l1 l4) 512.7)
	(= (drive-time l1 l5) 492.7)
	(= (drive-time l1 l6) 622.9)
	(= (drive-time l1 l7) 638.9)
	(= (drive-time l2 l1) 368.6)
	(= (drive-time l2 l3) 674.0)
	(= (drive-time l2 l4) 145.4)
	(= (drive-time l2 l5) 541.1)
	(= (drive-time l2 l6) 263.3)
	(= (drive-time l2 l7) 346.2)
	(= (drive-time l3 l1) 931.5)
	(= (drive-time l3 l2) 674.0)
	(= (drive-time l3 l4) 584.9)
	(= (drive-time l3 l5) 633.8)
	(= (drive-time l3 l6) 660.1)
	(= (drive-time l3 l7) 853.8)
	(= (drive-time l4 l1) 512.7)
	(= (drive-time l4 l2) 145.4)
	(= (drive-time l4 l3) 584.9)
	(= (drive-time l4 l5) 604.0)
	(= (drive-time l4 l6) 152.3)
	(= (drive-time l4 l7) 306.8)
	(= (drive-time l5 l1) 492.7)
	(= (drive-time l5 l2) 541.1)
	(= (drive-time l5 l3) 633.8)
	(= (drive-time l5 l4) 604.0)
	(= (drive-time l5 l6) 756.2)
	(= (drive-time l5 l7) 884.8)
	(= (drive-time l6 l1) 622.9)
	(= (drive-time l6 l2) 263.3)
	(= (drive-time l6 l3) 660.1)
	(= (drive-time l6 l4) 152.3)
	(= (drive-time l6 l5) 756.2)
	(= (drive-time l6 l7) 193.8)
	(= (drive-time l7 l1) 638.9)
	(= (drive-time l7 l2) 346.2)
	(= (drive-time l7 l3) 853.8)
	(= (drive-time l7 l4) 306.8)
	(= (drive-time l7 l5) 884.8)
	(= (drive-time l7 l6) 193.8))

(:goal (and 
	(delivered package1 l7)
	(delivered package2 l4)
	(delivered package3 l1)
	(delivered package4 l5)
	(delivered package5 l5)
	(delivered package6 l7)
	(delivered package7 l4)
	(delivered package8 l5)
	(delivered package9 l2)
	(delivered package10 l7)
	(delivered package11 l7)
	(delivered package12 l5)
	(delivered package13 l1)
	(delivered package14 l5)
	(delivered package15 l2)
	(delivered package16 l7)
	(delivered package17 l7)
	(delivered package18 l7)
	(delivered package19 l3)
	(delivered package20 l1)
	(delivered package21 l7)
	(delivered package22 l6)
	(delivered package23 l1)
	(delivered package24 l1)
	(delivered package25 l1)
	(delivered package26 l4)
	(delivered package27 l5)
	(delivered package28 l3)
	(delivered package29 l5)
	(delivered package30 l6)
	(delivered package31 l4)
	(delivered package32 l5)))

(:metric minimize (total-time))

)
