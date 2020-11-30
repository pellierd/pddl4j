(define (problem truck-20)
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
	(at truck1 l6)
	(at truck2 l1)
	(at truck3 l1)
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
	(at package6 l5)
	(at package7 l5)
	(at package8 l5)
	(at package9 l5)
	(at package10 l5)
	(at package11 l1)
	(at package12 l1)
	(at package13 l1)
	(at package14 l1)
	(at package15 l1)
	(at package16 l4)
	(at package17 l4)
	(at package18 l4)
	(at package19 l4)
	(at package20 l4)
	(at package21 l6)
	(at package22 l6)
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
	(= (drive-time l1 l2) 654.9)
	(= (drive-time l1 l3) 815.6)
	(= (drive-time l1 l4) 645.5)
	(= (drive-time l1 l5) 466.8)
	(= (drive-time l1 l6) 573.9)
	(= (drive-time l2 l1) 654.9)
	(= (drive-time l2 l3) 752.2)
	(= (drive-time l2 l4) 60.4)
	(= (drive-time l2 l5) 444.1)
	(= (drive-time l2 l6) 129.8)
	(= (drive-time l3 l1) 815.6)
	(= (drive-time l3 l2) 752.2)
	(= (drive-time l3 l4) 692.4)
	(= (drive-time l3 l5) 397.1)
	(= (drive-time l3 l6) 819.8)
	(= (drive-time l4 l1) 645.5)
	(= (drive-time l4 l2) 60.4)
	(= (drive-time l4 l3) 692.4)
	(= (drive-time l4 l5) 394.8)
	(= (drive-time l4 l6) 171.8)
	(= (drive-time l5 l1) 466.8)
	(= (drive-time l5 l2) 444.1)
	(= (drive-time l5 l3) 397.1)
	(= (drive-time l5 l4) 394.8)
	(= (drive-time l5 l6) 467.4)
	(= (drive-time l6 l1) 573.9)
	(= (drive-time l6 l2) 129.8)
	(= (drive-time l6 l3) 819.8)
	(= (drive-time l6 l4) 171.8)
	(= (drive-time l6 l5) 467.4))

(:goal (and 
	(delivered package1 l4)
	(delivered package2 l1)
	(delivered package3 l3)
	(delivered package4 l4)
	(delivered package5 l4)
	(delivered package6 l1)
	(delivered package7 l2)
	(delivered package8 l4)
	(delivered package9 l1)
	(delivered package10 l3)
	(delivered package11 l3)
	(delivered package12 l2)
	(delivered package13 l3)
	(delivered package14 l6)
	(delivered package15 l5)
	(delivered package16 l6)
	(delivered package17 l1)
	(delivered package18 l6)
	(delivered package19 l1)
	(delivered package20 l2)
	(delivered package21 l3)
	(delivered package22 l4)))

(:metric minimize (total-time))

)
