(define (problem DLOG-3-3-7)
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
	package7 - obj
	s0 - location
	s1 - location
	s2 - location
	p1-0 - location
	p2-0 - location
	p2-1 - location
	)
	(:init
	(at driver1 s2)
	(at driver2 s0)
	(at driver3 s1)
	(at truck1 s2)
	(empty truck1)
	(at truck2 s2)
	(empty truck2)
	(at truck3 s2)
	(empty truck3)
	(at package1 s0)
	(at package2 s1)
	(at package3 s0)
	(at package4 s0)
	(at package5 s1)
	(at package6 s2)
	(at package7 s2)
	(path s1 p1-0)
	(path p1-0 s1)
	(path s0 p1-0)
	(path p1-0 s0)
	(= (time-to-walk s1 p1-0) 75)
	(= (time-to-walk p1-0 s1) 75)
	(= (time-to-walk s0 p1-0) 24)
	(= (time-to-walk p1-0 s0) 24)
	(path s2 p2-0)
	(path p2-0 s2)
	(path s0 p2-0)
	(path p2-0 s0)
	(= (time-to-walk s2 p2-0) 77)
	(= (time-to-walk p2-0 s2) 77)
	(= (time-to-walk s0 p2-0) 91)
	(= (time-to-walk p2-0 s0) 91)
	(path s2 p2-1)
	(path p2-1 s2)
	(path s1 p2-1)
	(path p2-1 s1)
	(= (time-to-walk s2 p2-1) 15)
	(= (time-to-walk p2-1 s2) 15)
	(= (time-to-walk s1 p2-1) 17)
	(= (time-to-walk p2-1 s1) 17)
	(link s0 s1)
	(link s1 s0)
	(= (time-to-drive s0 s1) 83)
	(= (time-to-drive s1 s0) 83)
	(link s0 s2)
	(link s2 s0)
	(= (time-to-drive s0 s2) 87)
	(= (time-to-drive s2 s0) 87)
	(link s1 s2)
	(link s2 s1)
	(= (time-to-drive s1 s2) 25)
	(= (time-to-drive s2 s1) 25)
)
	(:goal (and
	(at driver1 s2)
	(at driver2 s0)
	(at truck2 s1)
	(at truck3 s0)
	(at package1 s2)
	(at package2 s0)
	(at package3 s1)
	(at package4 s2)
	(at package5 s1)
	(at package6 s2)
	(at package7 s1)
	))

(:metric minimize (total-time))

)
