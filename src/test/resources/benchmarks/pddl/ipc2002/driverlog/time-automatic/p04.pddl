(define (problem DLOG-3-2-4)
	(:domain driverlog)
	(:objects
	driver1 - driver
	driver2 - driver
	driver3 - driver
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
	p1-0 - location
	p1-2 - location
	p2-1 - location
	)
	(:init
	(at driver1 s1)
	(at driver2 s1)
	(at driver3 s0)
	(at truck1 s1)
	(empty truck1)
	(at truck2 s0)
	(empty truck2)
	(at package1 s2)
	(at package2 s2)
	(at package3 s0)
	(at package4 s1)
	(path s0 p0-1)
	(path p0-1 s0)
	(path s1 p0-1)
	(path p0-1 s1)
	(= (time-to-walk s0 p0-1) 8)
	(= (time-to-walk p0-1 s0) 8)
	(= (time-to-walk s1 p0-1) 99)
	(= (time-to-walk p0-1 s1) 99)
	(path s1 p1-2)
	(path p1-2 s1)
	(path s2 p1-2)
	(path p1-2 s2)
	(= (time-to-walk s1 p1-2) 94)
	(= (time-to-walk p1-2 s1) 94)
	(= (time-to-walk s2 p1-2) 97)
	(= (time-to-walk p1-2 s2) 97)
	(link s0 s2)
	(link s2 s0)
	(= (time-to-drive s0 s2) 56)
	(= (time-to-drive s2 s0) 56)
	(link s1 s0)
	(link s0 s1)
	(= (time-to-drive s1 s0) 43)
	(= (time-to-drive s0 s1) 43)
	(link s2 s1)
	(link s1 s2)
	(= (time-to-drive s2 s1) 37)
	(= (time-to-drive s1 s2) 37)
)
	(:goal (and
	(at driver1 s1)
	(at driver2 s0)
	(at driver3 s1)
	(at truck1 s1)
	(at truck2 s2)
	(at package1 s1)
	(at package2 s2)
	(at package3 s2)
	(at package4 s0)
	))

(:metric minimize (total-time))

)
