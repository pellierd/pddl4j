(define (problem pfile02)
(:domain TPP-MetricTime)
(:objects
	market1 - market
	depot1 - depot
	truck1 - truck
	goods1 goods2 - goods)

(:init
	(= (price goods1 market1) 49)
	(= (ready-to-load goods1 market1) 0)
	(= (on-sale goods1 market1) 17)
	(= (price goods2 market1) 4)
	(= (ready-to-load goods2 market1) 0)
	(= (on-sale goods2 market1) 5)
	(connected depot1 market1)
	(connected market1 depot1)
	(= (drive-cost market1 depot1) 125.00)
	(= (drive-cost depot1 market1) 125.00)
	(= (drive-time market1 depot1) 375.00)
	(= (drive-time depot1 market1) 375.00)
	(= (loaded goods1 truck1) 0)
	(= (loaded goods2 truck1) 0)
	(at truck1 depot1)
	(= (stored goods1) 0)
	(= (stored goods2) 0)
	(= (total-cost) 0)
	(= (rebate-rate market1) 0.84)
	(= (bought goods1) 0)
	(= (bought goods2) 0)
	(= (request goods1) 10)
	(= (request goods2) 5))

(:goal (and
	(>= (stored goods1) (request goods1))
	(>= (stored goods2) (request goods2))))

(:metric minimize (+ (* 1.3 (total-cost))(total-time)))
)