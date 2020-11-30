(define (problem pfile12)
(:domain TPP-MetricTimeConstraints)
(:objects
	market1 - market
	depot1 - depot
	truck1 truck2 - truck
	goods1 goods2 goods3 goods4 - goods)

(:init
	(= (price goods1 market1) 49)
	(= (ready-to-load goods1 market1) 0)
	(= (on-sale goods1 market1) 17)
	(= (price goods2 market1) 4)
	(= (ready-to-load goods2 market1) 0)
	(= (on-sale goods2 market1) 5)
	(= (price goods3 market1) 50)
	(= (ready-to-load goods3 market1) 0)
	(= (on-sale goods3 market1) 15)
	(= (price goods4 market1) 30)
	(= (ready-to-load goods4 market1) 0)
	(= (on-sale goods4 market1) 7)
	(connected depot1 market1)
	(connected market1 depot1)
	(= (drive-cost market1 depot1) 369.00)
	(= (drive-cost depot1 market1) 369.00)
	(= (drive-time market1 depot1) 1107.00)
	(= (drive-time depot1 market1) 1107.00)
	(= (loaded goods1 truck1) 0)
	(= (loaded goods2 truck1) 0)
	(= (loaded goods3 truck1) 0)
	(= (loaded goods4 truck1) 0)
	(at truck1 depot1)
	(= (loaded goods1 truck2) 0)
	(= (loaded goods2 truck2) 0)
	(= (loaded goods3 truck2) 0)
	(= (loaded goods4 truck2) 0)
	(at truck2 depot1)
	(= (stored goods1) 0)
	(= (stored goods2) 0)
	(= (stored goods3) 0)
	(= (stored goods4) 0)
	(= (total-cost) 0)
	(= (rebate-rate market1) 0.90)
	(= (bought goods1) 0)
	(= (bought goods2) 0)
	(= (bought goods3) 0)
	(= (bought goods4) 0)
	(= (request goods1) 7)
	(= (request goods2) 4)
	(= (request goods3) 14)
	(= (request goods4) 1))

(:goal (and
	(>= (stored goods1) (request goods1))
	(>= (stored goods2) (request goods2))
	(>= (stored goods3) (request goods3))
	(>= (stored goods4) (request goods4))))

(:constraints (and
	(forall (?m - market ?t - truck) (at-most-once (at ?t ?m)))

	(always (>= (stored goods3) (stored goods1)))

	(sometime-before (> (stored goods4) 0)
			 (>= (stored goods2) (request goods2)))))

(:metric minimize (+ (* 1.8 (total-cost))(total-time)))
)