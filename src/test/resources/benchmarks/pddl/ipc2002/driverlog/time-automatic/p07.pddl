(define (problem DLOG-3-3-6)
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
	package6 - obj
	s0 - location
	s1 - location
	s2 - location
	p0-1 - location
	p0-2 - location
	p2-1 - location
	)
	(:init
	(at driver1 s1)
	(at driver2 s2)
	(at driver3 s2)
	(at truck1 s1)
	(empty truck1)
	(at truck2 s1)
	(empty truck2)
	(at truck3 s1)
	(empty truck3)
	(at package1 s0)
	(at package2 s2)
	(at package3 s1)
	(at package4 s1)
	(at package5 s1)
	(at package6 s0)
	(path s0 p0-1)
	(path p0-1 s0)
	(path s1 p0-1)
	(path p0-1 s1)
	(= (time-to-walk s0 p0-1) 1)
	(= (time-to-walk p0-1 s0) 1)
	(= (time-to-walk s1 p0-1) 87)
	(= (time-to-walk p0-1 s1) 87)
	(path s0 p0-2)
	(path p0-2 s0)
	(path s2 p0-2)
	(path p0-2 s2)
	(= (time-to-walk s0 p0-2) 77)
	(= (time-to-walk p0-2 s0) 77)
	(= (time-to-walk s2 p0-2) 29)
	(= (time-to-walk p0-2 s2) 29)
	(path s2 p2-1)
	(path p2-1 s2)
	(path s1 p2-1)
	(path p2-1 s1)
	(= (time-to-walk s2 p2-1) 44)
	(= (time-to-walk p2-1 s2) 44)
	(= (time-to-walk s1 p2-1) 22)
	(= (time-to-walk p2-1 s1) 22)
	(link s1 s0)
	(link s0 s1)
	(= (time-to-drive s1 s0) 76)
	(= (time-to-drive s0 s1) 76)
	(link s1 s2)
	(link s2 s1)
	(= (time-to-drive s1 s2) 92)
	(= (time-to-drive s2 s1) 92)
	(link s2 s0)
	(link s0 s2)
	(= (time-to-drive s2 s0) 34)
	(= (time-to-drive s0 s2) 34)
)
	(:goal (and
	(at driver1 s0)
	(at driver2 s0)
	(at truck1 s1)
	(at truck2 s0)
	(at package1 s0)
	(at package2 s1)
	(at package3 s1)
	(at package4 s2)
	(at package5 s0)
	(at package6 s0)
	))

(:metric minimize (total-time))

)
