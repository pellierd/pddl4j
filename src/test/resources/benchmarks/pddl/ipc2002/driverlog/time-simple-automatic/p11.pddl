(define (problem DLOG-2-3-6)
	(:domain driverlog)
	(:objects
	driver1 - driver
	driver2 - driver
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
	s3 - location
	s4 - location
	s5 - location
	s6 - location
	p0-3 - location
	p1-0 - location
	p1-5 - location
	p2-3 - location
	p2-6 - location
	p3-4 - location
	p4-0 - location
	p4-1 - location
	p4-2 - location
	p5-0 - location
	p6-3 - location
	)
	(:init
	(at driver1 s6)
	(at driver2 s0)
	(at truck1 s0)
	(empty truck1)
	(at truck2 s2)
	(empty truck2)
	(at truck3 s2)
	(empty truck3)
	(at package1 s6)
	(at package2 s2)
	(at package3 s3)
	(at package4 s0)
	(at package5 s5)
	(at package6 s5)
	(path s0 p0-3)
	(path p0-3 s0)
	(path s3 p0-3)
	(path p0-3 s3)
	(path s1 p1-0)
	(path p1-0 s1)
	(path s0 p1-0)
	(path p1-0 s0)
	(path s1 p1-5)
	(path p1-5 s1)
	(path s5 p1-5)
	(path p1-5 s5)
	(path s2 p2-3)
	(path p2-3 s2)
	(path s3 p2-3)
	(path p2-3 s3)
	(path s2 p2-6)
	(path p2-6 s2)
	(path s6 p2-6)
	(path p2-6 s6)
	(path s3 p3-4)
	(path p3-4 s3)
	(path s4 p3-4)
	(path p3-4 s4)
	(path s4 p4-0)
	(path p4-0 s4)
	(path s0 p4-0)
	(path p4-0 s0)
	(path s4 p4-1)
	(path p4-1 s4)
	(path s1 p4-1)
	(path p4-1 s1)
	(path s4 p4-2)
	(path p4-2 s4)
	(path s2 p4-2)
	(path p4-2 s2)
	(path s5 p5-0)
	(path p5-0 s5)
	(path s0 p5-0)
	(path p5-0 s0)
	(path s6 p6-3)
	(path p6-3 s6)
	(path s3 p6-3)
	(path p6-3 s3)
	(link s0 s2)
	(link s2 s0)
	(link s0 s5)
	(link s5 s0)
	(link s1 s0)
	(link s0 s1)
	(link s1 s3)
	(link s3 s1)
	(link s1 s4)
	(link s4 s1)
	(link s1 s6)
	(link s6 s1)
	(link s2 s1)
	(link s1 s2)
	(link s2 s4)
	(link s4 s2)
	(link s3 s6)
	(link s6 s3)
	(link s4 s0)
	(link s0 s4)
	(link s5 s1)
	(link s1 s5)
	(link s5 s2)
	(link s2 s5)
	(link s6 s0)
	(link s0 s6)
	(link s6 s2)
	(link s2 s6)
	(link s6 s4)
	(link s4 s6)
	(link s6 s5)
	(link s5 s6)
)
	(:goal (and
	(at driver2 s4)
	(at truck2 s4)
	(at package1 s6)
	(at package2 s3)
	(at package3 s4)
	(at package4 s6)
	(at package5 s1)
	))

(:metric minimize (total-time))

)
