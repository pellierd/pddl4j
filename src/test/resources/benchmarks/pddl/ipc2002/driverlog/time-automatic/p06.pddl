(define (problem DLOG-3-3-5)
	(:domain driverlog)
	(:objects
	driver1 - driver
	driver2 - driver
	driver3 - driver
	truck1 - truck
	truck2 - truck
	truck3 - truck
	package1 - obj
	package2 - obj
	package3 - obj
	package4 - obj
	package5 - obj
	s0 - location
	s1 - location
	s2 - location
	p1-2 - location
	p2-0 - location
	)
	(:init
	(at driver1 s2)
	(at driver2 s2)
	(at driver3 s1)
	(at truck1 s0)
	(empty truck1)
	(at truck2 s1)
	(empty truck2)
	(at truck3 s1)
	(empty truck3)
	(at package1 s1)
	(at package2 s1)
	(at package3 s0)
	(at package4 s1)
	(at package5 s1)
	(path s1 p1-2)
	(path p1-2 s1)
	(path s2 p1-2)
	(path p1-2 s2)
	(= (time-to-walk s1 p1-2) 44)
	(= (time-to-walk p1-2 s1) 44)
	(= (time-to-walk s2 p1-2) 29)
	(= (time-to-walk p1-2 s2) 29)
	(path s2 p2-0)
	(path p2-0 s2)
	(path s0 p2-0)
	(path p2-0 s0)
	(= (time-to-walk s2 p2-0) 97)
	(= (time-to-walk p2-0 s2) 97)
	(= (time-to-walk s0 p2-0) 77)
	(= (time-to-walk p2-0 s0) 77)
	(link s0 s1)
	(link s1 s0)
	(= (time-to-drive s0 s1) 93)
	(= (time-to-drive s1 s0) 93)
	(link s0 s2)
	(link s2 s0)
	(= (time-to-drive s0 s2) 19)
	(= (time-to-drive s2 s0) 19)
	(link s2 s1)
	(link s1 s2)
	(= (time-to-drive s2 s1) 90)
	(= (time-to-drive s1 s2) 90)
)
	(:goal (and
	(at driver1 s1)
	(at driver2 s0)
	(at truck1 s0)
	(at truck2 s0)
	(at truck3 s2)
	(at package1 s2)
	(at package2 s1)
	(at package3 s0)
	(at package4 s1)
	(at package5 s1)
	))

(:metric minimize (total-time))

)
