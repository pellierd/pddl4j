(define (problem pfile01)
(:domain TPP-MetricTime)
(:objects
	market1 - market
	depot1 - depot
	truck1 - truck
	goods1 - goods)

(:init
	(= (price goods1 market1) 49)
	(= (ready-to-load goods1 market1) 0)
	(= (on-sale goods1 market1) 17)
	(connected depot1 market1)
	(connected market1 depot1)
	(= (drive-cost market1 depot1) 450.00)
	(= (drive-cost depot1 market1) 450.00)
	(= (drive-time market1 depot1) 1350.00)
	(= (drive-time depot1 market1) 1350.00)
	(= (loaded goods1 truck1) 0)
	(at truck1 depot1)
	(= (stored goods1) 0)
	(= (total-cost) 0)
	(= (rebate-rate market1) 0.86)
	(= (bought goods1) 0)
	(= (request goods1) 17))

(:goal (and
	(>= (stored goods1) (request goods1))))

(:metric minimize (+ (* 1.9 (total-cost))(total-time)))
)