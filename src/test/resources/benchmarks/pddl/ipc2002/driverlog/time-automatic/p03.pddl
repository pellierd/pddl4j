(define (problem DLOG-2-2-4)
	(:domain driverlog)
	(:objects
	driver1 - driver
	driver2 - driver
	truck1 - truck
	truck2 - truck
	package1 - obj
	package2 - obj
	package3 - obj
	package4 - obj
	s0 - location
	s1 - location
	s2 - location
	p0-1 - location
	p2-0 - location
	p2-1 - location
	)
	(:init
	(at driver1 s1)
	(at driver2 s0)
	(at truck1 s1)
	(empty truck1)
	(at truck2 s2)
	(empty truck2)
	(at package1 s0)
	(at package2 s0)
	(at package3 s1)
	(at package4 s1)
	(path s0 p0-1)
	(path p0-1 s0)
	(path s1 p0-1)
	(path p0-1 s1)
	(= (time-to-walk s0 p0-1) 50)
	(= (time-to-walk p0-1 s0) 50)
	(= (time-to-walk s1 p0-1) 92)
	(= (time-to-walk p0-1 s1) 92)
	(path s2 p2-0)
	(path p2-0 s2)
	(path s0 p2-0)
	(path p2-0 s0)
	(= (time-to-walk s2 p2-0) 73)
	(= (time-to-walk p2-0 s2) 73)
	(= (time-to-walk s0 p2-0) 100)
	(= (time-to-walk p2-0 s0) 100)
	(path s2 p2-1)
	(path p2-1 s2)
	(path s1 p2-1)
	(path p2-1 s1)
	(= (time-to-walk s2 p2-1) 8)
	(= (time-to-walk p2-1 s2) 8)
	(= (time-to-walk s1 p2-1) 71)
	(= (time-to-walk p2-1 s1) 71)
	(link s1 s0)
	(link s0 s1)
	(= (time-to-drive s1 s0) 42)
	(= (time-to-drive s0 s1) 42)
	(link s1 s2)
	(link s2 s1)
	(= (time-to-drive s1 s2) 55)
	(= (time-to-drive s2 s1) 55)
	(link s2 s0)
	(link s0 s2)
	(= (time-to-drive s2 s0) 23)
	(= (time-to-drive s0 s2) 23)
)
	(:goal (and
	(at driver2 s2)
	(at truck1 s1)
	(at truck2 s2)
	(at package1 s1)
	(at package2 s1)
	(at package3 s2)
	))

(:metric minimize (total-time))

)
