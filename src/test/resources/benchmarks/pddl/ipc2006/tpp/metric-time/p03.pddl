(define (problem pfile03)
(:domain TPP-MetricTime)
(:objects
	market1 - market
	depot1 - depot
	truck1 - truck
	goods1 goods2 goods3 - goods)

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
	(connected depot1 market1)
	(connected market1 depot1)
	(= (drive-cost market1 depot1) 219.00)
	(= (drive-cost depot1 market1) 219.00)
	(= (drive-time market1 depot1) 657.00)
	(= (drive-time depot1 market1) 657.00)
	(= (loaded goods1 truck1) 0)
	(= (loaded goods2 truck1) 0)
	(= (loaded goods3 truck1) 0)
	(at truck1 depot1)
	(= (stored goods1) 0)
	(= (stored goods2) 0)
	(= (stored goods3) 0)
	(= (total-cost) 0)
	(= (rebate-rate market1) 0.82)
	(= (bought goods1) 0)
	(= (bought goods2) 0)
	(= (bought goods3) 0)
	(= (request goods1) 13)
	(= (request goods2) 4)
	(= (request goods3) 1))

(:goal (and
	(>= (stored goods1) (request goods1))
	(>= (stored goods2) (request goods2))
	(>= (stored goods3) (request goods3))))

(:metric minimize (+ (* 1.3 (total-cost))(total-time)))
)