; Time: 0.01 seconds
(define (problem GROUNDED-TRUCK-1)
(:domain GROUNDED-TRUCKS-TIME)
(:init
(FOO)
(at_package3_l1)
(at_package2_l3)
(at_package1_l3)
(free_a2_truck1)
(free_a1_truck1)
(at_truck1_l2)
)
(:goal
(and
(delivered_package3_l2)
(delivered_package2_l2)
(delivered_package1_l1)
)
)
(:metric MINIMIZE (TOTAL-TIME))
)