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
	p0-1 - location
	p1-2 - location
	p1-3 - location
	p3-2 - location
	p3-4 - location
	p4-0 - location
	)
	(:init
	(at driver1 s4)
	(at driver2 s1)
	(at truck1 s2)
	(empty truck1)
	(at truck2 s0)
	(empty truck2)
	(at truck3 s3)
	(empty truck3)
	(at package1 s2)
	(at package2 s1)
	(at package3 s3)
	(at package4 s0)
	(at package5 s1)
	(at package6 s1)
	(path s0 p0-1)
	(path p0-1 s0)
	(path s1 p0-1)
	(path p0-1 s1)
	(= (time-to-walk s0 p0-1) 67)
	(= (time-to-walk p0-1 s0) 67)
	(= (time-to-walk s1 p0-1) 63)
	(= (time-to-walk p0-1 s1) 63)
	(path s1 p1-2)
	(path p1-2 s1)
	(path s2 p1-2)
	(path p1-2 s2)
	(= (time-to-walk s1 p1-2) 69)
	(= (time-to-walk p1-2 s1) 69)
	(= (time-to-walk s2 p1-2) 100)
	(= (time-to-walk p1-2 s2) 100)
	(path s1 p1-3)
	(path p1-3 s1)
	(path s3 p1-3)
	(path p1-3 s3)
	(= (time-to-walk s1 p1-3) 11)
	(= (time-to-walk p1-3 s1) 11)
	(= (time-to-walk s3 p1-3) 41)
	(= (time-to-walk p1-3 s3) 41)
	(path s3 p3-2)
	(path p3-2 s3)
	(path s2 p3-2)
	(path p3-2 s2)
	(= (time-to-walk s3 p3-2) 95)
	(= (time-to-walk p3-2 s3) 95)
	(= (time-to-walk s2 p3-2) 25)
	(= (time-to-walk p3-2 s2) 25)
	(path s3 p3-4)
	(path p3-4 s3)
	(path s4 p3-4)
	(path p3-4 s4)
	(= (time-to-walk s3 p3-4) 20)
	(= (time-to-walk p3-4 s3) 20)
	(= (time-to-walk s4 p3-4) 63)
	(= (time-to-walk p3-4 s4) 63)
	(path s4 p4-0)
	(path p4-0 s4)
	(path s0 p4-0)
	(path p4-0 s0)
	(= (time-to-walk s4 p4-0) 85)
	(= (time-to-walk p4-0 s4) 85)
	(= (time-to-walk s0 p4-0) 22)
	(= (time-to-walk p4-0 s0) 22)
	(link s0 s2)
	(link s2 s0)
	(= (time-to-drive s0 s2) 65)
	(= (time-to-drive s2 s0) 65)
	(link s0 s3)
	(link s3 s0)
	(= (time-to-drive s0 s3) 39)
	(= (time-to-drive s3 s0) 39)
	(link s1 s0)
	(link s0 s1)
	(= (time-to-drive s1 s0) 99)
	(= (time-to-drive s0 s1) 99)
	(link s2 s1)
	(link s1 s2)
	(= (time-to-drive s2 s1) 40)
	(= (time-to-drive s1 s2) 40)
	(link s3 s2)
	(link s2 s3)
	(= (time-to-drive s3 s2) 74)
	(= (time-to-drive s2 s3) 74)
	(link s4 s0)
	(link s0 s4)
	(= (time-to-drive s4 s0) 41)
	(= (time-to-drive s0 s4) 41)
	(link s4 s2)
	(link s2 s4)
	(= (time-to-drive s4 s2) 96)
	(= (time-to-drive s2 s4) 96)
	(link s4 s3)
	(link s3 s4)
	(= (time-to-drive s4 s3) 53)
	(= (time-to-drive s3 s4) 53)
)
	(:goal (and
	(at driver1 s3)
	(at driver2 s4)
	(at truck1 s3)
	(at truck2 s3)
	(at package1 s3)
	(at package2 s2)
	(at package3 s1)
	(at package4 s0)
	(at package5 s1)
	(at package6 s1)
	))

(:metric minimize (total-time))

)
