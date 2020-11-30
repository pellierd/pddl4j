(define (domain GROUNDED-TRUCKS-TIME)
(:requirements
:strips
:durative-actions
:numeric-fluents
)
(:predicates
(FOO)
(at_truck1_l4)
(at_truck2_l4)
(at_truck1_l3)
(at_truck2_l3)
(at_truck1_l1)
(at_truck2_l1)
(delivered_package1_l2)
(delivered_package2_l2)
(delivered_package3_l2)
(delivered_package4_l1)
(delivered_package5_l1)
(delivered_package6_l1)
(delivered_package7_l1)
(delivered_package8_l1)
(delivered_package9_l1)
(delivered_package10_l2)
(delivered_package11_l2)
(delivered_package12_l2)
(delivered_package13_l3)
(in_package1_truck1_a1)
(in_package1_truck1_a2)
(in_package1_truck1_a3)
(in_package1_truck2_a1)
(in_package1_truck2_a2)
(in_package1_truck2_a3)
(in_package2_truck1_a1)
(in_package2_truck1_a2)
(in_package2_truck1_a3)
(in_package2_truck2_a1)
(in_package2_truck2_a2)
(in_package2_truck2_a3)
(in_package3_truck1_a1)
(in_package3_truck1_a2)
(in_package3_truck1_a3)
(in_package3_truck2_a1)
(in_package3_truck2_a2)
(in_package3_truck2_a3)
(in_package4_truck1_a1)
(in_package4_truck1_a2)
(in_package4_truck1_a3)
(in_package4_truck2_a1)
(in_package4_truck2_a2)
(in_package4_truck2_a3)
(in_package5_truck1_a1)
(in_package5_truck1_a2)
(in_package5_truck1_a3)
(in_package5_truck2_a1)
(in_package5_truck2_a2)
(in_package5_truck2_a3)
(in_package6_truck1_a1)
(in_package6_truck1_a2)
(in_package6_truck1_a3)
(in_package6_truck2_a1)
(in_package6_truck2_a2)
(in_package6_truck2_a3)
(in_package7_truck1_a1)
(in_package7_truck1_a2)
(in_package7_truck1_a3)
(in_package7_truck2_a1)
(in_package7_truck2_a2)
(in_package7_truck2_a3)
(in_package8_truck1_a1)
(in_package8_truck1_a2)
(in_package8_truck1_a3)
(in_package8_truck2_a1)
(in_package8_truck2_a2)
(in_package8_truck2_a3)
(in_package9_truck1_a1)
(in_package9_truck1_a2)
(in_package9_truck1_a3)
(in_package9_truck2_a1)
(in_package9_truck2_a2)
(in_package9_truck2_a3)
(in_package10_truck1_a1)
(in_package10_truck1_a2)
(in_package10_truck1_a3)
(in_package10_truck2_a1)
(in_package10_truck2_a2)
(in_package10_truck2_a3)
(in_package11_truck1_a1)
(in_package11_truck1_a2)
(in_package11_truck1_a3)
(in_package11_truck2_a1)
(in_package11_truck2_a2)
(in_package11_truck2_a3)
(in_package12_truck1_a1)
(in_package12_truck1_a2)
(in_package12_truck1_a3)
(in_package12_truck2_a1)
(in_package12_truck2_a2)
(in_package12_truck2_a3)
(in_package13_truck1_a1)
(in_package13_truck1_a2)
(in_package13_truck1_a3)
(in_package13_truck2_a1)
(in_package13_truck2_a2)
(in_package13_truck2_a3)
(at_package1_l1)
(at_package1_l3)
(at_package1_l4)
(at_package2_l1)
(at_package2_l3)
(at_package2_l4)
(at_package3_l1)
(at_package3_l3)
(at_package3_l4)
(at_package4_l2)
(at_package4_l3)
(at_package4_l4)
(at_package5_l2)
(at_package5_l3)
(at_package5_l4)
(at_package6_l2)
(at_package6_l3)
(at_package6_l4)
(at_package7_l2)
(at_package7_l3)
(at_package7_l4)
(at_package8_l2)
(at_package8_l3)
(at_package8_l4)
(at_package9_l2)
(at_package9_l3)
(at_package9_l4)
(at_package10_l1)
(at_package10_l3)
(at_package10_l4)
(at_package11_l1)
(at_package11_l3)
(at_package11_l4)
(at_package12_l1)
(at_package12_l3)
(at_package12_l4)
(at_package13_l1)
(at_package13_l2)
(at_package13_l4)
(delivered_package1_l1)
(delivered_package1_l3)
(delivered_package1_l4)
(delivered_package2_l1)
(delivered_package2_l3)
(delivered_package2_l4)
(delivered_package3_l1)
(delivered_package3_l3)
(delivered_package3_l4)
(delivered_package4_l2)
(delivered_package4_l3)
(delivered_package4_l4)
(delivered_package5_l2)
(delivered_package5_l3)
(delivered_package5_l4)
(delivered_package6_l2)
(delivered_package6_l3)
(delivered_package6_l4)
(delivered_package7_l2)
(delivered_package7_l3)
(delivered_package7_l4)
(delivered_package8_l2)
(delivered_package8_l3)
(delivered_package8_l4)
(delivered_package9_l2)
(delivered_package9_l3)
(delivered_package9_l4)
(delivered_package10_l1)
(delivered_package10_l3)
(delivered_package10_l4)
(delivered_package11_l1)
(delivered_package11_l3)
(delivered_package11_l4)
(delivered_package12_l1)
(delivered_package12_l3)
(delivered_package12_l4)
(delivered_package13_l1)
(delivered_package13_l2)
(delivered_package13_l4)
(free_a3_truck2)
(free_a2_truck2)
(free_a1_truck2)
(free_a3_truck1)
(free_a2_truck1)
(free_a1_truck1)
(at_package13_l3)
(at_package12_l2)
(at_package11_l2)
(at_package10_l2)
(at_package9_l1)
(at_package8_l1)
(at_package7_l1)
(at_package6_l1)
(at_package5_l1)
(at_package4_l1)
(at_package3_l2)
(at_package2_l2)
(at_package1_l2)
(at_truck2_l2)
(at_truck1_l2)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package13_truck2_a3))
(at start (not (at_package13_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package13_truck2_a3))
(at start (not (at_package13_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package13_truck2_a3))
(at start (not (at_package13_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package13_truck2_a2))
(at start (not (at_package13_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package13_truck2_a2))
(at start (not (at_package13_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package13_truck2_a2))
(at start (not (at_package13_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package13_truck2_a1))
(at start (not (at_package13_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package13_truck2_a1))
(at start (not (at_package13_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package13_truck2_a1))
(at start (not (at_package13_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package13_truck1_a3))
(at start (not (at_package13_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package13_truck1_a3))
(at start (not (at_package13_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package13_truck1_a3))
(at start (not (at_package13_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package13_truck1_a2))
(at start (not (at_package13_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package13_truck1_a2))
(at start (not (at_package13_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package13_truck1_a2))
(at start (not (at_package13_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package13_truck1_a1))
(at start (not (at_package13_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package13_truck1_a1))
(at start (not (at_package13_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package13_truck1_a1))
(at start (not (at_package13_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package12_truck2_a3))
(at start (not (at_package12_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package12_truck2_a3))
(at start (not (at_package12_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package12_truck2_a3))
(at start (not (at_package12_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package12_truck2_a2))
(at start (not (at_package12_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package12_truck2_a2))
(at start (not (at_package12_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package12_truck2_a2))
(at start (not (at_package12_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package12_truck2_a1))
(at start (not (at_package12_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package12_truck2_a1))
(at start (not (at_package12_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package12_truck2_a1))
(at start (not (at_package12_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package12_truck1_a3))
(at start (not (at_package12_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package12_truck1_a3))
(at start (not (at_package12_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package12_truck1_a3))
(at start (not (at_package12_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package12_truck1_a2))
(at start (not (at_package12_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package12_truck1_a2))
(at start (not (at_package12_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package12_truck1_a2))
(at start (not (at_package12_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package12_truck1_a1))
(at start (not (at_package12_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package12_truck1_a1))
(at start (not (at_package12_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package12_truck1_a1))
(at start (not (at_package12_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package11_truck2_a3))
(at start (not (at_package11_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package11_truck2_a3))
(at start (not (at_package11_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package11_truck2_a3))
(at start (not (at_package11_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package11_truck2_a2))
(at start (not (at_package11_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package11_truck2_a2))
(at start (not (at_package11_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package11_truck2_a2))
(at start (not (at_package11_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package11_truck2_a1))
(at start (not (at_package11_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package11_truck2_a1))
(at start (not (at_package11_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package11_truck2_a1))
(at start (not (at_package11_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package11_truck1_a3))
(at start (not (at_package11_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package11_truck1_a3))
(at start (not (at_package11_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package11_truck1_a3))
(at start (not (at_package11_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package11_truck1_a2))
(at start (not (at_package11_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package11_truck1_a2))
(at start (not (at_package11_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package11_truck1_a2))
(at start (not (at_package11_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package11_truck1_a1))
(at start (not (at_package11_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package11_truck1_a1))
(at start (not (at_package11_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package11_truck1_a1))
(at start (not (at_package11_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package10_truck2_a3))
(at start (not (at_package10_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package10_truck2_a3))
(at start (not (at_package10_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package10_truck2_a3))
(at start (not (at_package10_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package10_truck2_a2))
(at start (not (at_package10_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package10_truck2_a2))
(at start (not (at_package10_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package10_truck2_a2))
(at start (not (at_package10_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package10_truck2_a1))
(at start (not (at_package10_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package10_truck2_a1))
(at start (not (at_package10_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package10_truck2_a1))
(at start (not (at_package10_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package10_truck1_a3))
(at start (not (at_package10_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package10_truck1_a3))
(at start (not (at_package10_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package10_truck1_a3))
(at start (not (at_package10_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package10_truck1_a2))
(at start (not (at_package10_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package10_truck1_a2))
(at start (not (at_package10_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package10_truck1_a2))
(at start (not (at_package10_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package10_truck1_a1))
(at start (not (at_package10_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package10_truck1_a1))
(at start (not (at_package10_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package10_truck1_a1))
(at start (not (at_package10_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package9_truck2_a3))
(at start (not (at_package9_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package9_truck2_a3))
(at start (not (at_package9_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package9_truck2_a3))
(at start (not (at_package9_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package9_truck2_a2))
(at start (not (at_package9_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package9_truck2_a2))
(at start (not (at_package9_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package9_truck2_a2))
(at start (not (at_package9_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package9_truck2_a1))
(at start (not (at_package9_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package9_truck2_a1))
(at start (not (at_package9_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package9_truck2_a1))
(at start (not (at_package9_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package9_truck1_a3))
(at start (not (at_package9_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package9_truck1_a3))
(at start (not (at_package9_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package9_truck1_a3))
(at start (not (at_package9_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package9_truck1_a2))
(at start (not (at_package9_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package9_truck1_a2))
(at start (not (at_package9_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package9_truck1_a2))
(at start (not (at_package9_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package9_truck1_a1))
(at start (not (at_package9_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package9_truck1_a1))
(at start (not (at_package9_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package9_truck1_a1))
(at start (not (at_package9_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package8_truck2_a3))
(at start (not (at_package8_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package8_truck2_a3))
(at start (not (at_package8_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package8_truck2_a3))
(at start (not (at_package8_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package8_truck2_a2))
(at start (not (at_package8_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package8_truck2_a2))
(at start (not (at_package8_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package8_truck2_a2))
(at start (not (at_package8_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package8_truck2_a1))
(at start (not (at_package8_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package8_truck2_a1))
(at start (not (at_package8_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package8_truck2_a1))
(at start (not (at_package8_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package8_truck1_a3))
(at start (not (at_package8_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package8_truck1_a3))
(at start (not (at_package8_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package8_truck1_a3))
(at start (not (at_package8_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package8_truck1_a2))
(at start (not (at_package8_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package8_truck1_a2))
(at start (not (at_package8_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package8_truck1_a2))
(at start (not (at_package8_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package8_truck1_a1))
(at start (not (at_package8_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package8_truck1_a1))
(at start (not (at_package8_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package8_truck1_a1))
(at start (not (at_package8_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package7_truck2_a3))
(at start (not (at_package7_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package7_truck2_a3))
(at start (not (at_package7_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package7_truck2_a3))
(at start (not (at_package7_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package7_truck2_a2))
(at start (not (at_package7_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package7_truck2_a2))
(at start (not (at_package7_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package7_truck2_a2))
(at start (not (at_package7_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package7_truck2_a1))
(at start (not (at_package7_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package7_truck2_a1))
(at start (not (at_package7_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package7_truck2_a1))
(at start (not (at_package7_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package7_truck1_a3))
(at start (not (at_package7_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package7_truck1_a3))
(at start (not (at_package7_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package7_truck1_a3))
(at start (not (at_package7_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package7_truck1_a2))
(at start (not (at_package7_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package7_truck1_a2))
(at start (not (at_package7_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package7_truck1_a2))
(at start (not (at_package7_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package7_truck1_a1))
(at start (not (at_package7_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package7_truck1_a1))
(at start (not (at_package7_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package7_truck1_a1))
(at start (not (at_package7_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package6_truck2_a3))
(at start (not (at_package6_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package6_truck2_a3))
(at start (not (at_package6_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package6_truck2_a3))
(at start (not (at_package6_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package6_truck2_a2))
(at start (not (at_package6_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package6_truck2_a2))
(at start (not (at_package6_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package6_truck2_a2))
(at start (not (at_package6_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package6_truck2_a1))
(at start (not (at_package6_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package6_truck2_a1))
(at start (not (at_package6_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package6_truck2_a1))
(at start (not (at_package6_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package6_truck1_a3))
(at start (not (at_package6_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package6_truck1_a3))
(at start (not (at_package6_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package6_truck1_a3))
(at start (not (at_package6_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package6_truck1_a2))
(at start (not (at_package6_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package6_truck1_a2))
(at start (not (at_package6_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package6_truck1_a2))
(at start (not (at_package6_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package6_truck1_a1))
(at start (not (at_package6_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package6_truck1_a1))
(at start (not (at_package6_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package6_truck1_a1))
(at start (not (at_package6_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package5_truck2_a3))
(at start (not (at_package5_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package5_truck2_a3))
(at start (not (at_package5_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package5_truck2_a3))
(at start (not (at_package5_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package5_truck2_a2))
(at start (not (at_package5_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package5_truck2_a2))
(at start (not (at_package5_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package5_truck2_a2))
(at start (not (at_package5_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package5_truck2_a1))
(at start (not (at_package5_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package5_truck2_a1))
(at start (not (at_package5_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package5_truck2_a1))
(at start (not (at_package5_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package5_truck1_a3))
(at start (not (at_package5_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package5_truck1_a3))
(at start (not (at_package5_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package5_truck1_a3))
(at start (not (at_package5_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package5_truck1_a2))
(at start (not (at_package5_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package5_truck1_a2))
(at start (not (at_package5_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package5_truck1_a2))
(at start (not (at_package5_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package5_truck1_a1))
(at start (not (at_package5_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package5_truck1_a1))
(at start (not (at_package5_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package5_truck1_a1))
(at start (not (at_package5_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package4_truck2_a3))
(at start (not (at_package4_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package4_truck2_a3))
(at start (not (at_package4_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package4_truck2_a3))
(at start (not (at_package4_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package4_truck2_a2))
(at start (not (at_package4_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package4_truck2_a2))
(at start (not (at_package4_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package4_truck2_a2))
(at start (not (at_package4_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package4_truck2_a1))
(at start (not (at_package4_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package4_truck2_a1))
(at start (not (at_package4_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package4_truck2_a1))
(at start (not (at_package4_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package4_truck1_a3))
(at start (not (at_package4_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package4_truck1_a3))
(at start (not (at_package4_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package4_truck1_a3))
(at start (not (at_package4_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package4_truck1_a2))
(at start (not (at_package4_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package4_truck1_a2))
(at start (not (at_package4_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package4_truck1_a2))
(at start (not (at_package4_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package4_truck1_a1))
(at start (not (at_package4_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package4_truck1_a1))
(at start (not (at_package4_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package4_truck1_a1))
(at start (not (at_package4_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package3_truck2_a3))
(at start (not (at_package3_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package3_truck2_a3))
(at start (not (at_package3_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package3_truck2_a3))
(at start (not (at_package3_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package3_truck2_a2))
(at start (not (at_package3_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package3_truck2_a2))
(at start (not (at_package3_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package3_truck2_a2))
(at start (not (at_package3_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package3_truck2_a1))
(at start (not (at_package3_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package3_truck2_a1))
(at start (not (at_package3_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package3_truck2_a1))
(at start (not (at_package3_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package3_truck1_a3))
(at start (not (at_package3_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package3_truck1_a3))
(at start (not (at_package3_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package3_truck1_a3))
(at start (not (at_package3_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package3_truck1_a2))
(at start (not (at_package3_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package3_truck1_a2))
(at start (not (at_package3_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package3_truck1_a2))
(at start (not (at_package3_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package3_truck1_a1))
(at start (not (at_package3_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package3_truck1_a1))
(at start (not (at_package3_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package3_truck1_a1))
(at start (not (at_package3_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package2_truck2_a3))
(at start (not (at_package2_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package2_truck2_a3))
(at start (not (at_package2_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package2_truck2_a3))
(at start (not (at_package2_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package2_truck2_a2))
(at start (not (at_package2_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package2_truck2_a2))
(at start (not (at_package2_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package2_truck2_a2))
(at start (not (at_package2_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package2_truck2_a1))
(at start (not (at_package2_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package2_truck2_a1))
(at start (not (at_package2_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package2_truck2_a1))
(at start (not (at_package2_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package2_truck1_a3))
(at start (not (at_package2_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package2_truck1_a3))
(at start (not (at_package2_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package2_truck1_a3))
(at start (not (at_package2_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package2_truck1_a2))
(at start (not (at_package2_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package2_truck1_a2))
(at start (not (at_package2_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package2_truck1_a2))
(at start (not (at_package2_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package2_truck1_a1))
(at start (not (at_package2_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package2_truck1_a1))
(at start (not (at_package2_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package2_truck1_a1))
(at start (not (at_package2_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l4))
(at start (free_a3_truck2))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package1_truck2_a3))
(at start (not (at_package1_l4)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package1_truck2_a3))
(at start (not (at_package1_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package1_truck2_a3))
(at start (not (at_package1_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l4))
(at start (free_a2_truck2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package1_truck2_a2))
(at start (not (at_package1_l4)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package1_truck2_a2))
(at start (not (at_package1_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package1_truck2_a2))
(at start (not (at_package1_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l4))
(at start (free_a1_truck2))
(over all (at_truck2_l4))
)
:effect
(and
(at end (in_package1_truck2_a1))
(at start (not (at_package1_l4)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package1_truck2_a1))
(at start (not (at_package1_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package1_truck2_a1))
(at start (not (at_package1_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l4))
(at start (free_a3_truck1))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package1_truck1_a3))
(at start (not (at_package1_l4)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package1_truck1_a3))
(at start (not (at_package1_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package1_truck1_a3))
(at start (not (at_package1_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l4))
(at start (free_a2_truck1))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package1_truck1_a2))
(at start (not (at_package1_l4)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package1_truck1_a2))
(at start (not (at_package1_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package1_truck1_a2))
(at start (not (at_package1_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l4))
(at start (free_a1_truck1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (in_package1_truck1_a1))
(at start (not (at_package1_l4)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package1_truck1_a1))
(at start (not (at_package1_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package1_truck1_a1))
(at start (not (at_package1_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action DELIVER_PACKAGE13_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package13_l4))
)
:effect
(and
(at end (delivered_package13_l4))
(at end (not (at_package13_l4)))
)
)
(:durative-action DELIVER_PACKAGE13_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package13_l2))
)
:effect
(and
(at end (delivered_package13_l2))
(at end (not (at_package13_l2)))
)
)
(:durative-action DELIVER_PACKAGE13_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package13_l1))
)
:effect
(and
(at end (delivered_package13_l1))
(at end (not (at_package13_l1)))
)
)
(:durative-action DELIVER_PACKAGE12_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package12_l4))
)
:effect
(and
(at end (delivered_package12_l4))
(at end (not (at_package12_l4)))
)
)
(:durative-action DELIVER_PACKAGE12_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package12_l3))
)
:effect
(and
(at end (delivered_package12_l3))
(at end (not (at_package12_l3)))
)
)
(:durative-action DELIVER_PACKAGE12_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package12_l1))
)
:effect
(and
(at end (delivered_package12_l1))
(at end (not (at_package12_l1)))
)
)
(:durative-action DELIVER_PACKAGE11_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package11_l4))
)
:effect
(and
(at end (delivered_package11_l4))
(at end (not (at_package11_l4)))
)
)
(:durative-action DELIVER_PACKAGE11_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package11_l3))
)
:effect
(and
(at end (delivered_package11_l3))
(at end (not (at_package11_l3)))
)
)
(:durative-action DELIVER_PACKAGE11_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package11_l1))
)
:effect
(and
(at end (delivered_package11_l1))
(at end (not (at_package11_l1)))
)
)
(:durative-action DELIVER_PACKAGE10_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package10_l4))
)
:effect
(and
(at end (delivered_package10_l4))
(at end (not (at_package10_l4)))
)
)
(:durative-action DELIVER_PACKAGE10_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package10_l3))
)
:effect
(and
(at end (delivered_package10_l3))
(at end (not (at_package10_l3)))
)
)
(:durative-action DELIVER_PACKAGE10_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package10_l1))
)
:effect
(and
(at end (delivered_package10_l1))
(at end (not (at_package10_l1)))
)
)
(:durative-action DELIVER_PACKAGE9_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package9_l4))
)
:effect
(and
(at end (delivered_package9_l4))
(at end (not (at_package9_l4)))
)
)
(:durative-action DELIVER_PACKAGE9_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package9_l3))
)
:effect
(and
(at end (delivered_package9_l3))
(at end (not (at_package9_l3)))
)
)
(:durative-action DELIVER_PACKAGE9_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package9_l2))
)
:effect
(and
(at end (delivered_package9_l2))
(at end (not (at_package9_l2)))
)
)
(:durative-action DELIVER_PACKAGE8_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package8_l4))
)
:effect
(and
(at end (delivered_package8_l4))
(at end (not (at_package8_l4)))
)
)
(:durative-action DELIVER_PACKAGE8_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package8_l3))
)
:effect
(and
(at end (delivered_package8_l3))
(at end (not (at_package8_l3)))
)
)
(:durative-action DELIVER_PACKAGE8_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package8_l2))
)
:effect
(and
(at end (delivered_package8_l2))
(at end (not (at_package8_l2)))
)
)
(:durative-action DELIVER_PACKAGE7_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package7_l4))
)
:effect
(and
(at end (delivered_package7_l4))
(at end (not (at_package7_l4)))
)
)
(:durative-action DELIVER_PACKAGE7_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package7_l3))
)
:effect
(and
(at end (delivered_package7_l3))
(at end (not (at_package7_l3)))
)
)
(:durative-action DELIVER_PACKAGE7_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package7_l2))
)
:effect
(and
(at end (delivered_package7_l2))
(at end (not (at_package7_l2)))
)
)
(:durative-action DELIVER_PACKAGE6_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package6_l4))
)
:effect
(and
(at end (delivered_package6_l4))
(at end (not (at_package6_l4)))
)
)
(:durative-action DELIVER_PACKAGE6_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package6_l3))
)
:effect
(and
(at end (delivered_package6_l3))
(at end (not (at_package6_l3)))
)
)
(:durative-action DELIVER_PACKAGE6_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package6_l2))
)
:effect
(and
(at end (delivered_package6_l2))
(at end (not (at_package6_l2)))
)
)
(:durative-action DELIVER_PACKAGE5_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package5_l4))
)
:effect
(and
(at end (delivered_package5_l4))
(at end (not (at_package5_l4)))
)
)
(:durative-action DELIVER_PACKAGE5_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package5_l3))
)
:effect
(and
(at end (delivered_package5_l3))
(at end (not (at_package5_l3)))
)
)
(:durative-action DELIVER_PACKAGE5_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package5_l2))
)
:effect
(and
(at end (delivered_package5_l2))
(at end (not (at_package5_l2)))
)
)
(:durative-action DELIVER_PACKAGE4_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package4_l4))
)
:effect
(and
(at end (delivered_package4_l4))
(at end (not (at_package4_l4)))
)
)
(:durative-action DELIVER_PACKAGE4_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package4_l3))
)
:effect
(and
(at end (delivered_package4_l3))
(at end (not (at_package4_l3)))
)
)
(:durative-action DELIVER_PACKAGE4_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package4_l2))
)
:effect
(and
(at end (delivered_package4_l2))
(at end (not (at_package4_l2)))
)
)
(:durative-action DELIVER_PACKAGE3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package3_l4))
)
:effect
(and
(at end (delivered_package3_l4))
(at end (not (at_package3_l4)))
)
)
(:durative-action DELIVER_PACKAGE3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package3_l3))
)
:effect
(and
(at end (delivered_package3_l3))
(at end (not (at_package3_l3)))
)
)
(:durative-action DELIVER_PACKAGE3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package3_l1))
)
:effect
(and
(at end (delivered_package3_l1))
(at end (not (at_package3_l1)))
)
)
(:durative-action DELIVER_PACKAGE2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package2_l4))
)
:effect
(and
(at end (delivered_package2_l4))
(at end (not (at_package2_l4)))
)
)
(:durative-action DELIVER_PACKAGE2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package2_l3))
)
:effect
(and
(at end (delivered_package2_l3))
(at end (not (at_package2_l3)))
)
)
(:durative-action DELIVER_PACKAGE2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package2_l1))
)
:effect
(and
(at end (delivered_package2_l1))
(at end (not (at_package2_l1)))
)
)
(:durative-action DELIVER_PACKAGE1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package1_l4))
)
:effect
(and
(at end (delivered_package1_l4))
(at end (not (at_package1_l4)))
)
)
(:durative-action DELIVER_PACKAGE1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package1_l3))
)
:effect
(and
(at end (delivered_package1_l3))
(at end (not (at_package1_l3)))
)
)
(:durative-action DELIVER_PACKAGE1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package1_l1))
)
:effect
(and
(at end (delivered_package1_l1))
(at end (not (at_package1_l1)))
)
)
(:durative-action DRIVE_TRUCK2_L3_L1
:parameters ()
:duration (= ?duration 24.000000)
:condition
(and
(at start (at_truck2_l3))
)
:effect
(and
(at end (at_truck2_l1))
(at start (not (at_truck2_l3)))
)
)
(:durative-action DRIVE_TRUCK1_L3_L1
:parameters ()
:duration (= ?duration 24.000000)
:condition
(and
(at start (at_truck1_l3))
)
:effect
(and
(at end (at_truck1_l1))
(at start (not (at_truck1_l3)))
)
)
(:durative-action DRIVE_TRUCK2_L3_L2
:parameters ()
:duration (= ?duration 655.799988)
:condition
(and
(at start (at_truck2_l3))
)
:effect
(and
(at end (at_truck2_l2))
(at start (not (at_truck2_l3)))
)
)
(:durative-action DRIVE_TRUCK1_L3_L2
:parameters ()
:duration (= ?duration 655.799988)
:condition
(and
(at start (at_truck1_l3))
)
:effect
(and
(at end (at_truck1_l2))
(at start (not (at_truck1_l3)))
)
)
(:durative-action DRIVE_TRUCK2_L3_L4
:parameters ()
:duration (= ?duration 443.299988)
:condition
(and
(at start (at_truck2_l3))
)
:effect
(and
(at end (at_truck2_l4))
(at start (not (at_truck2_l3)))
)
)
(:durative-action DRIVE_TRUCK1_L3_L4
:parameters ()
:duration (= ?duration 443.299988)
:condition
(and
(at start (at_truck1_l3))
)
:effect
(and
(at end (at_truck1_l4))
(at start (not (at_truck1_l3)))
)
)
(:durative-action DRIVE_TRUCK2_L4_L1
:parameters ()
:duration (= ?duration 426.000000)
:condition
(and
(at start (at_truck2_l4))
)
:effect
(and
(at end (at_truck2_l1))
(at start (not (at_truck2_l4)))
)
)
(:durative-action DRIVE_TRUCK1_L4_L1
:parameters ()
:duration (= ?duration 426.000000)
:condition
(and
(at start (at_truck1_l4))
)
:effect
(and
(at end (at_truck1_l1))
(at start (not (at_truck1_l4)))
)
)
(:durative-action DRIVE_TRUCK2_L4_L2
:parameters ()
:duration (= ?duration 553.099976)
:condition
(and
(at start (at_truck2_l4))
)
:effect
(and
(at end (at_truck2_l2))
(at start (not (at_truck2_l4)))
)
)
(:durative-action DRIVE_TRUCK1_L4_L2
:parameters ()
:duration (= ?duration 553.099976)
:condition
(and
(at start (at_truck1_l4))
)
:effect
(and
(at end (at_truck1_l2))
(at start (not (at_truck1_l4)))
)
)
(:durative-action DRIVE_TRUCK2_L4_L3
:parameters ()
:duration (= ?duration 443.299988)
:condition
(and
(at start (at_truck2_l4))
)
:effect
(and
(at end (at_truck2_l3))
(at start (not (at_truck2_l4)))
)
)
(:durative-action DRIVE_TRUCK1_L4_L3
:parameters ()
:duration (= ?duration 443.299988)
:condition
(and
(at start (at_truck1_l4))
)
:effect
(and
(at end (at_truck1_l3))
(at start (not (at_truck1_l4)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package13_l4))
(at end (free_a3_truck2))
(at start (not (in_package13_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package13_l3))
(at end (free_a3_truck2))
(at start (not (in_package13_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package13_l2))
(at end (free_a3_truck2))
(at start (not (in_package13_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package13_l1))
(at end (free_a3_truck2))
(at start (not (in_package13_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package13_l4))
(at end (free_a2_truck2))
(at start (not (in_package13_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package13_l3))
(at end (free_a2_truck2))
(at start (not (in_package13_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package13_l2))
(at end (free_a2_truck2))
(at start (not (in_package13_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package13_l1))
(at end (free_a2_truck2))
(at start (not (in_package13_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package13_l4))
(at end (free_a1_truck2))
(at start (not (in_package13_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package13_l3))
(at end (free_a1_truck2))
(at start (not (in_package13_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package13_l2))
(at end (free_a1_truck2))
(at start (not (in_package13_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package13_l1))
(at end (free_a1_truck2))
(at start (not (in_package13_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package13_l4))
(at end (free_a3_truck1))
(at start (not (in_package13_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package13_l3))
(at end (free_a3_truck1))
(at start (not (in_package13_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package13_l2))
(at end (free_a3_truck1))
(at start (not (in_package13_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package13_l1))
(at end (free_a3_truck1))
(at start (not (in_package13_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package13_l4))
(at end (free_a2_truck1))
(at start (not (in_package13_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package13_l3))
(at end (free_a2_truck1))
(at start (not (in_package13_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package13_l2))
(at end (free_a2_truck1))
(at start (not (in_package13_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package13_l1))
(at end (free_a2_truck1))
(at start (not (in_package13_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package13_l4))
(at end (free_a1_truck1))
(at start (not (in_package13_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package13_l3))
(at end (free_a1_truck1))
(at start (not (in_package13_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package13_l2))
(at end (free_a1_truck1))
(at start (not (in_package13_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE13_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package13_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package13_l1))
(at end (free_a1_truck1))
(at start (not (in_package13_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package12_l4))
(at end (free_a3_truck2))
(at start (not (in_package12_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package12_l3))
(at end (free_a3_truck2))
(at start (not (in_package12_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package12_l2))
(at end (free_a3_truck2))
(at start (not (in_package12_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package12_l1))
(at end (free_a3_truck2))
(at start (not (in_package12_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package12_l4))
(at end (free_a2_truck2))
(at start (not (in_package12_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package12_l3))
(at end (free_a2_truck2))
(at start (not (in_package12_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package12_l2))
(at end (free_a2_truck2))
(at start (not (in_package12_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package12_l1))
(at end (free_a2_truck2))
(at start (not (in_package12_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package12_l4))
(at end (free_a1_truck2))
(at start (not (in_package12_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package12_l3))
(at end (free_a1_truck2))
(at start (not (in_package12_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package12_l2))
(at end (free_a1_truck2))
(at start (not (in_package12_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package12_l1))
(at end (free_a1_truck2))
(at start (not (in_package12_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package12_l4))
(at end (free_a3_truck1))
(at start (not (in_package12_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package12_l3))
(at end (free_a3_truck1))
(at start (not (in_package12_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package12_l2))
(at end (free_a3_truck1))
(at start (not (in_package12_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package12_l1))
(at end (free_a3_truck1))
(at start (not (in_package12_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package12_l4))
(at end (free_a2_truck1))
(at start (not (in_package12_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package12_l3))
(at end (free_a2_truck1))
(at start (not (in_package12_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package12_l2))
(at end (free_a2_truck1))
(at start (not (in_package12_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package12_l1))
(at end (free_a2_truck1))
(at start (not (in_package12_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package12_l4))
(at end (free_a1_truck1))
(at start (not (in_package12_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package12_l3))
(at end (free_a1_truck1))
(at start (not (in_package12_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package12_l2))
(at end (free_a1_truck1))
(at start (not (in_package12_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE12_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package12_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package12_l1))
(at end (free_a1_truck1))
(at start (not (in_package12_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package11_l4))
(at end (free_a3_truck2))
(at start (not (in_package11_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package11_l3))
(at end (free_a3_truck2))
(at start (not (in_package11_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package11_l2))
(at end (free_a3_truck2))
(at start (not (in_package11_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package11_l1))
(at end (free_a3_truck2))
(at start (not (in_package11_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package11_l4))
(at end (free_a2_truck2))
(at start (not (in_package11_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package11_l3))
(at end (free_a2_truck2))
(at start (not (in_package11_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package11_l2))
(at end (free_a2_truck2))
(at start (not (in_package11_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package11_l1))
(at end (free_a2_truck2))
(at start (not (in_package11_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package11_l4))
(at end (free_a1_truck2))
(at start (not (in_package11_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package11_l3))
(at end (free_a1_truck2))
(at start (not (in_package11_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package11_l2))
(at end (free_a1_truck2))
(at start (not (in_package11_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package11_l1))
(at end (free_a1_truck2))
(at start (not (in_package11_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package11_l4))
(at end (free_a3_truck1))
(at start (not (in_package11_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package11_l3))
(at end (free_a3_truck1))
(at start (not (in_package11_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package11_l2))
(at end (free_a3_truck1))
(at start (not (in_package11_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package11_l1))
(at end (free_a3_truck1))
(at start (not (in_package11_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package11_l4))
(at end (free_a2_truck1))
(at start (not (in_package11_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package11_l3))
(at end (free_a2_truck1))
(at start (not (in_package11_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package11_l2))
(at end (free_a2_truck1))
(at start (not (in_package11_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package11_l1))
(at end (free_a2_truck1))
(at start (not (in_package11_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package11_l4))
(at end (free_a1_truck1))
(at start (not (in_package11_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package11_l3))
(at end (free_a1_truck1))
(at start (not (in_package11_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package11_l2))
(at end (free_a1_truck1))
(at start (not (in_package11_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE11_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package11_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package11_l1))
(at end (free_a1_truck1))
(at start (not (in_package11_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package10_l4))
(at end (free_a3_truck2))
(at start (not (in_package10_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package10_l3))
(at end (free_a3_truck2))
(at start (not (in_package10_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package10_l2))
(at end (free_a3_truck2))
(at start (not (in_package10_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package10_l1))
(at end (free_a3_truck2))
(at start (not (in_package10_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package10_l4))
(at end (free_a2_truck2))
(at start (not (in_package10_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package10_l3))
(at end (free_a2_truck2))
(at start (not (in_package10_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package10_l2))
(at end (free_a2_truck2))
(at start (not (in_package10_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package10_l1))
(at end (free_a2_truck2))
(at start (not (in_package10_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package10_l4))
(at end (free_a1_truck2))
(at start (not (in_package10_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package10_l3))
(at end (free_a1_truck2))
(at start (not (in_package10_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package10_l2))
(at end (free_a1_truck2))
(at start (not (in_package10_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package10_l1))
(at end (free_a1_truck2))
(at start (not (in_package10_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package10_l4))
(at end (free_a3_truck1))
(at start (not (in_package10_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package10_l3))
(at end (free_a3_truck1))
(at start (not (in_package10_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package10_l2))
(at end (free_a3_truck1))
(at start (not (in_package10_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package10_l1))
(at end (free_a3_truck1))
(at start (not (in_package10_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package10_l4))
(at end (free_a2_truck1))
(at start (not (in_package10_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package10_l3))
(at end (free_a2_truck1))
(at start (not (in_package10_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package10_l2))
(at end (free_a2_truck1))
(at start (not (in_package10_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package10_l1))
(at end (free_a2_truck1))
(at start (not (in_package10_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package10_l4))
(at end (free_a1_truck1))
(at start (not (in_package10_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package10_l3))
(at end (free_a1_truck1))
(at start (not (in_package10_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package10_l2))
(at end (free_a1_truck1))
(at start (not (in_package10_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE10_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package10_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package10_l1))
(at end (free_a1_truck1))
(at start (not (in_package10_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package9_l4))
(at end (free_a3_truck2))
(at start (not (in_package9_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package9_l3))
(at end (free_a3_truck2))
(at start (not (in_package9_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package9_l2))
(at end (free_a3_truck2))
(at start (not (in_package9_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package9_l1))
(at end (free_a3_truck2))
(at start (not (in_package9_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package9_l4))
(at end (free_a2_truck2))
(at start (not (in_package9_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package9_l3))
(at end (free_a2_truck2))
(at start (not (in_package9_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package9_l2))
(at end (free_a2_truck2))
(at start (not (in_package9_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package9_l1))
(at end (free_a2_truck2))
(at start (not (in_package9_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package9_l4))
(at end (free_a1_truck2))
(at start (not (in_package9_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package9_l3))
(at end (free_a1_truck2))
(at start (not (in_package9_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package9_l2))
(at end (free_a1_truck2))
(at start (not (in_package9_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package9_l1))
(at end (free_a1_truck2))
(at start (not (in_package9_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package9_l4))
(at end (free_a3_truck1))
(at start (not (in_package9_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package9_l3))
(at end (free_a3_truck1))
(at start (not (in_package9_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package9_l2))
(at end (free_a3_truck1))
(at start (not (in_package9_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package9_l1))
(at end (free_a3_truck1))
(at start (not (in_package9_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package9_l4))
(at end (free_a2_truck1))
(at start (not (in_package9_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package9_l3))
(at end (free_a2_truck1))
(at start (not (in_package9_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package9_l2))
(at end (free_a2_truck1))
(at start (not (in_package9_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package9_l1))
(at end (free_a2_truck1))
(at start (not (in_package9_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package9_l4))
(at end (free_a1_truck1))
(at start (not (in_package9_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package9_l3))
(at end (free_a1_truck1))
(at start (not (in_package9_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package9_l2))
(at end (free_a1_truck1))
(at start (not (in_package9_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE9_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package9_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package9_l1))
(at end (free_a1_truck1))
(at start (not (in_package9_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package8_l4))
(at end (free_a3_truck2))
(at start (not (in_package8_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package8_l3))
(at end (free_a3_truck2))
(at start (not (in_package8_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package8_l2))
(at end (free_a3_truck2))
(at start (not (in_package8_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package8_l1))
(at end (free_a3_truck2))
(at start (not (in_package8_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package8_l4))
(at end (free_a2_truck2))
(at start (not (in_package8_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package8_l3))
(at end (free_a2_truck2))
(at start (not (in_package8_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package8_l2))
(at end (free_a2_truck2))
(at start (not (in_package8_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package8_l1))
(at end (free_a2_truck2))
(at start (not (in_package8_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package8_l4))
(at end (free_a1_truck2))
(at start (not (in_package8_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package8_l3))
(at end (free_a1_truck2))
(at start (not (in_package8_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package8_l2))
(at end (free_a1_truck2))
(at start (not (in_package8_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package8_l1))
(at end (free_a1_truck2))
(at start (not (in_package8_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package8_l4))
(at end (free_a3_truck1))
(at start (not (in_package8_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package8_l3))
(at end (free_a3_truck1))
(at start (not (in_package8_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package8_l2))
(at end (free_a3_truck1))
(at start (not (in_package8_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package8_l1))
(at end (free_a3_truck1))
(at start (not (in_package8_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package8_l4))
(at end (free_a2_truck1))
(at start (not (in_package8_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package8_l3))
(at end (free_a2_truck1))
(at start (not (in_package8_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package8_l2))
(at end (free_a2_truck1))
(at start (not (in_package8_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package8_l1))
(at end (free_a2_truck1))
(at start (not (in_package8_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package8_l4))
(at end (free_a1_truck1))
(at start (not (in_package8_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package8_l3))
(at end (free_a1_truck1))
(at start (not (in_package8_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package8_l2))
(at end (free_a1_truck1))
(at start (not (in_package8_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE8_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package8_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package8_l1))
(at end (free_a1_truck1))
(at start (not (in_package8_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package7_l4))
(at end (free_a3_truck2))
(at start (not (in_package7_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package7_l3))
(at end (free_a3_truck2))
(at start (not (in_package7_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package7_l2))
(at end (free_a3_truck2))
(at start (not (in_package7_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package7_l1))
(at end (free_a3_truck2))
(at start (not (in_package7_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package7_l4))
(at end (free_a2_truck2))
(at start (not (in_package7_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package7_l3))
(at end (free_a2_truck2))
(at start (not (in_package7_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package7_l2))
(at end (free_a2_truck2))
(at start (not (in_package7_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package7_l1))
(at end (free_a2_truck2))
(at start (not (in_package7_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package7_l4))
(at end (free_a1_truck2))
(at start (not (in_package7_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package7_l3))
(at end (free_a1_truck2))
(at start (not (in_package7_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package7_l2))
(at end (free_a1_truck2))
(at start (not (in_package7_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package7_l1))
(at end (free_a1_truck2))
(at start (not (in_package7_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package7_l4))
(at end (free_a3_truck1))
(at start (not (in_package7_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package7_l3))
(at end (free_a3_truck1))
(at start (not (in_package7_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package7_l2))
(at end (free_a3_truck1))
(at start (not (in_package7_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package7_l1))
(at end (free_a3_truck1))
(at start (not (in_package7_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package7_l4))
(at end (free_a2_truck1))
(at start (not (in_package7_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package7_l3))
(at end (free_a2_truck1))
(at start (not (in_package7_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package7_l2))
(at end (free_a2_truck1))
(at start (not (in_package7_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package7_l1))
(at end (free_a2_truck1))
(at start (not (in_package7_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package7_l4))
(at end (free_a1_truck1))
(at start (not (in_package7_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package7_l3))
(at end (free_a1_truck1))
(at start (not (in_package7_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package7_l2))
(at end (free_a1_truck1))
(at start (not (in_package7_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE7_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package7_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package7_l1))
(at end (free_a1_truck1))
(at start (not (in_package7_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package6_l4))
(at end (free_a3_truck2))
(at start (not (in_package6_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package6_l3))
(at end (free_a3_truck2))
(at start (not (in_package6_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package6_l2))
(at end (free_a3_truck2))
(at start (not (in_package6_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package6_l1))
(at end (free_a3_truck2))
(at start (not (in_package6_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package6_l4))
(at end (free_a2_truck2))
(at start (not (in_package6_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package6_l3))
(at end (free_a2_truck2))
(at start (not (in_package6_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package6_l2))
(at end (free_a2_truck2))
(at start (not (in_package6_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package6_l1))
(at end (free_a2_truck2))
(at start (not (in_package6_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package6_l4))
(at end (free_a1_truck2))
(at start (not (in_package6_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package6_l3))
(at end (free_a1_truck2))
(at start (not (in_package6_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package6_l2))
(at end (free_a1_truck2))
(at start (not (in_package6_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package6_l1))
(at end (free_a1_truck2))
(at start (not (in_package6_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package6_l4))
(at end (free_a3_truck1))
(at start (not (in_package6_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package6_l3))
(at end (free_a3_truck1))
(at start (not (in_package6_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package6_l2))
(at end (free_a3_truck1))
(at start (not (in_package6_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package6_l1))
(at end (free_a3_truck1))
(at start (not (in_package6_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package6_l4))
(at end (free_a2_truck1))
(at start (not (in_package6_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package6_l3))
(at end (free_a2_truck1))
(at start (not (in_package6_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package6_l2))
(at end (free_a2_truck1))
(at start (not (in_package6_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package6_l1))
(at end (free_a2_truck1))
(at start (not (in_package6_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package6_l4))
(at end (free_a1_truck1))
(at start (not (in_package6_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package6_l3))
(at end (free_a1_truck1))
(at start (not (in_package6_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package6_l2))
(at end (free_a1_truck1))
(at start (not (in_package6_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE6_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package6_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package6_l1))
(at end (free_a1_truck1))
(at start (not (in_package6_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package5_l4))
(at end (free_a3_truck2))
(at start (not (in_package5_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package5_l3))
(at end (free_a3_truck2))
(at start (not (in_package5_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package5_l2))
(at end (free_a3_truck2))
(at start (not (in_package5_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package5_l1))
(at end (free_a3_truck2))
(at start (not (in_package5_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package5_l4))
(at end (free_a2_truck2))
(at start (not (in_package5_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package5_l3))
(at end (free_a2_truck2))
(at start (not (in_package5_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package5_l2))
(at end (free_a2_truck2))
(at start (not (in_package5_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package5_l1))
(at end (free_a2_truck2))
(at start (not (in_package5_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package5_l4))
(at end (free_a1_truck2))
(at start (not (in_package5_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package5_l3))
(at end (free_a1_truck2))
(at start (not (in_package5_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package5_l2))
(at end (free_a1_truck2))
(at start (not (in_package5_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package5_l1))
(at end (free_a1_truck2))
(at start (not (in_package5_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package5_l4))
(at end (free_a3_truck1))
(at start (not (in_package5_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package5_l3))
(at end (free_a3_truck1))
(at start (not (in_package5_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package5_l2))
(at end (free_a3_truck1))
(at start (not (in_package5_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package5_l1))
(at end (free_a3_truck1))
(at start (not (in_package5_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package5_l4))
(at end (free_a2_truck1))
(at start (not (in_package5_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package5_l3))
(at end (free_a2_truck1))
(at start (not (in_package5_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package5_l2))
(at end (free_a2_truck1))
(at start (not (in_package5_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package5_l1))
(at end (free_a2_truck1))
(at start (not (in_package5_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package5_l4))
(at end (free_a1_truck1))
(at start (not (in_package5_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package5_l3))
(at end (free_a1_truck1))
(at start (not (in_package5_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package5_l2))
(at end (free_a1_truck1))
(at start (not (in_package5_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE5_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package5_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package5_l1))
(at end (free_a1_truck1))
(at start (not (in_package5_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package4_l4))
(at end (free_a3_truck2))
(at start (not (in_package4_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package4_l3))
(at end (free_a3_truck2))
(at start (not (in_package4_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package4_l2))
(at end (free_a3_truck2))
(at start (not (in_package4_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package4_l1))
(at end (free_a3_truck2))
(at start (not (in_package4_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package4_l4))
(at end (free_a2_truck2))
(at start (not (in_package4_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package4_l3))
(at end (free_a2_truck2))
(at start (not (in_package4_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package4_l2))
(at end (free_a2_truck2))
(at start (not (in_package4_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package4_l1))
(at end (free_a2_truck2))
(at start (not (in_package4_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package4_l4))
(at end (free_a1_truck2))
(at start (not (in_package4_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package4_l3))
(at end (free_a1_truck2))
(at start (not (in_package4_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package4_l2))
(at end (free_a1_truck2))
(at start (not (in_package4_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package4_l1))
(at end (free_a1_truck2))
(at start (not (in_package4_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package4_l4))
(at end (free_a3_truck1))
(at start (not (in_package4_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package4_l3))
(at end (free_a3_truck1))
(at start (not (in_package4_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package4_l2))
(at end (free_a3_truck1))
(at start (not (in_package4_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package4_l1))
(at end (free_a3_truck1))
(at start (not (in_package4_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package4_l4))
(at end (free_a2_truck1))
(at start (not (in_package4_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package4_l3))
(at end (free_a2_truck1))
(at start (not (in_package4_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package4_l2))
(at end (free_a2_truck1))
(at start (not (in_package4_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package4_l1))
(at end (free_a2_truck1))
(at start (not (in_package4_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package4_l4))
(at end (free_a1_truck1))
(at start (not (in_package4_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package4_l3))
(at end (free_a1_truck1))
(at start (not (in_package4_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package4_l2))
(at end (free_a1_truck1))
(at start (not (in_package4_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE4_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package4_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package4_l1))
(at end (free_a1_truck1))
(at start (not (in_package4_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package3_l4))
(at end (free_a3_truck2))
(at start (not (in_package3_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package3_l3))
(at end (free_a3_truck2))
(at start (not (in_package3_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package3_l2))
(at end (free_a3_truck2))
(at start (not (in_package3_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package3_l1))
(at end (free_a3_truck2))
(at start (not (in_package3_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package3_l4))
(at end (free_a2_truck2))
(at start (not (in_package3_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package3_l3))
(at end (free_a2_truck2))
(at start (not (in_package3_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package3_l2))
(at end (free_a2_truck2))
(at start (not (in_package3_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package3_l1))
(at end (free_a2_truck2))
(at start (not (in_package3_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package3_l4))
(at end (free_a1_truck2))
(at start (not (in_package3_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package3_l3))
(at end (free_a1_truck2))
(at start (not (in_package3_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package3_l2))
(at end (free_a1_truck2))
(at start (not (in_package3_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package3_l1))
(at end (free_a1_truck2))
(at start (not (in_package3_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package3_l4))
(at end (free_a3_truck1))
(at start (not (in_package3_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package3_l3))
(at end (free_a3_truck1))
(at start (not (in_package3_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package3_l2))
(at end (free_a3_truck1))
(at start (not (in_package3_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package3_l1))
(at end (free_a3_truck1))
(at start (not (in_package3_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package3_l4))
(at end (free_a2_truck1))
(at start (not (in_package3_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package3_l3))
(at end (free_a2_truck1))
(at start (not (in_package3_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package3_l2))
(at end (free_a2_truck1))
(at start (not (in_package3_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package3_l1))
(at end (free_a2_truck1))
(at start (not (in_package3_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package3_l4))
(at end (free_a1_truck1))
(at start (not (in_package3_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package3_l3))
(at end (free_a1_truck1))
(at start (not (in_package3_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package3_l2))
(at end (free_a1_truck1))
(at start (not (in_package3_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE3_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package3_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package3_l1))
(at end (free_a1_truck1))
(at start (not (in_package3_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package2_l4))
(at end (free_a3_truck2))
(at start (not (in_package2_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package2_l3))
(at end (free_a3_truck2))
(at start (not (in_package2_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package2_l2))
(at end (free_a3_truck2))
(at start (not (in_package2_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package2_l1))
(at end (free_a3_truck2))
(at start (not (in_package2_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package2_l4))
(at end (free_a2_truck2))
(at start (not (in_package2_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package2_l3))
(at end (free_a2_truck2))
(at start (not (in_package2_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package2_l2))
(at end (free_a2_truck2))
(at start (not (in_package2_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package2_l1))
(at end (free_a2_truck2))
(at start (not (in_package2_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package2_l4))
(at end (free_a1_truck2))
(at start (not (in_package2_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package2_l3))
(at end (free_a1_truck2))
(at start (not (in_package2_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package2_l2))
(at end (free_a1_truck2))
(at start (not (in_package2_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package2_l1))
(at end (free_a1_truck2))
(at start (not (in_package2_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package2_l4))
(at end (free_a3_truck1))
(at start (not (in_package2_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package2_l3))
(at end (free_a3_truck1))
(at start (not (in_package2_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package2_l2))
(at end (free_a3_truck1))
(at start (not (in_package2_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package2_l1))
(at end (free_a3_truck1))
(at start (not (in_package2_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package2_l4))
(at end (free_a2_truck1))
(at start (not (in_package2_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package2_l3))
(at end (free_a2_truck1))
(at start (not (in_package2_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package2_l2))
(at end (free_a2_truck1))
(at start (not (in_package2_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package2_l1))
(at end (free_a2_truck1))
(at start (not (in_package2_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package2_l4))
(at end (free_a1_truck1))
(at start (not (in_package2_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package2_l3))
(at end (free_a1_truck1))
(at start (not (in_package2_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package2_l2))
(at end (free_a1_truck1))
(at start (not (in_package2_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE2_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package2_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package2_l1))
(at end (free_a1_truck1))
(at start (not (in_package2_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a3))
(over all (at_truck2_l4))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package1_l4))
(at end (free_a3_truck2))
(at start (not (in_package1_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a3))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package1_l3))
(at end (free_a3_truck2))
(at start (not (in_package1_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a3))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package1_l2))
(at end (free_a3_truck2))
(at start (not (in_package1_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a3))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package1_l1))
(at end (free_a3_truck2))
(at start (not (in_package1_truck2_a3)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a2))
(over all (at_truck2_l4))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package1_l4))
(at end (free_a2_truck2))
(at start (not (in_package1_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package1_l3))
(at end (free_a2_truck2))
(at start (not (in_package1_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package1_l2))
(at end (free_a2_truck2))
(at start (not (in_package1_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (at_package1_l1))
(at end (free_a2_truck2))
(at start (not (in_package1_truck2_a2)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a1))
(over all (at_truck2_l4))
)
:effect
(and
(at end (at_package1_l4))
(at end (free_a1_truck2))
(at start (not (in_package1_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a1))
(over all (at_truck2_l3))
)
:effect
(and
(at end (at_package1_l3))
(at end (free_a1_truck2))
(at start (not (in_package1_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a1))
(over all (at_truck2_l2))
)
:effect
(and
(at end (at_package1_l2))
(at end (free_a1_truck2))
(at start (not (in_package1_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck2_a1))
(over all (at_truck2_l1))
)
:effect
(and
(at end (at_package1_l1))
(at end (free_a1_truck2))
(at start (not (in_package1_truck2_a1)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A3_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a3))
(over all (at_truck1_l4))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package1_l4))
(at end (free_a3_truck1))
(at start (not (in_package1_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a3))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package1_l3))
(at end (free_a3_truck1))
(at start (not (in_package1_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a3))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package1_l2))
(at end (free_a3_truck1))
(at start (not (in_package1_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a3))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package1_l1))
(at end (free_a3_truck1))
(at start (not (in_package1_truck1_a3)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A2_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a2))
(over all (at_truck1_l4))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package1_l4))
(at end (free_a2_truck1))
(at start (not (in_package1_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a2))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package1_l3))
(at end (free_a2_truck1))
(at start (not (in_package1_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a2))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package1_l2))
(at end (free_a2_truck1))
(at start (not (in_package1_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a2))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (at_package1_l1))
(at end (free_a2_truck1))
(at start (not (in_package1_truck1_a2)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A1_L4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a1))
(over all (at_truck1_l4))
)
:effect
(and
(at end (at_package1_l4))
(at end (free_a1_truck1))
(at start (not (in_package1_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (at_package1_l3))
(at end (free_a1_truck1))
(at start (not (in_package1_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (at_package1_l2))
(at end (free_a1_truck1))
(at start (not (in_package1_truck1_a1)))
)
)
(:durative-action UNLOAD_PACKAGE1_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (in_package1_truck1_a1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (at_package1_l1))
(at end (free_a1_truck1))
(at start (not (in_package1_truck1_a1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l3))
(at start (free_a3_truck2))
(over all (at_truck2_l3))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package13_truck2_a3))
(at start (not (at_package13_l3)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l3))
(at start (free_a2_truck2))
(over all (at_truck2_l3))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package13_truck2_a2))
(at start (not (at_package13_l3)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK2_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l3))
(at start (free_a1_truck2))
(over all (at_truck2_l3))
)
:effect
(and
(at end (in_package13_truck2_a1))
(at start (not (at_package13_l3)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A3_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l3))
(at start (free_a3_truck1))
(over all (at_truck1_l3))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package13_truck1_a3))
(at start (not (at_package13_l3)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A2_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l3))
(at start (free_a2_truck1))
(over all (at_truck1_l3))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package13_truck1_a2))
(at start (not (at_package13_l3)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE13_TRUCK1_A1_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package13_l3))
(at start (free_a1_truck1))
(over all (at_truck1_l3))
)
:effect
(and
(at end (in_package13_truck1_a1))
(at start (not (at_package13_l3)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package12_truck2_a3))
(at start (not (at_package12_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package12_truck2_a2))
(at start (not (at_package12_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package12_truck2_a1))
(at start (not (at_package12_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package12_truck1_a3))
(at start (not (at_package12_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package12_truck1_a2))
(at start (not (at_package12_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE12_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package12_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package12_truck1_a1))
(at start (not (at_package12_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package11_truck2_a3))
(at start (not (at_package11_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package11_truck2_a2))
(at start (not (at_package11_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package11_truck2_a1))
(at start (not (at_package11_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package11_truck1_a3))
(at start (not (at_package11_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package11_truck1_a2))
(at start (not (at_package11_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE11_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package11_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package11_truck1_a1))
(at start (not (at_package11_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package10_truck2_a3))
(at start (not (at_package10_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package10_truck2_a2))
(at start (not (at_package10_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package10_truck2_a1))
(at start (not (at_package10_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package10_truck1_a3))
(at start (not (at_package10_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package10_truck1_a2))
(at start (not (at_package10_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE10_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package10_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package10_truck1_a1))
(at start (not (at_package10_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package9_truck2_a3))
(at start (not (at_package9_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package9_truck2_a2))
(at start (not (at_package9_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package9_truck2_a1))
(at start (not (at_package9_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package9_truck1_a3))
(at start (not (at_package9_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package9_truck1_a2))
(at start (not (at_package9_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE9_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package9_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package9_truck1_a1))
(at start (not (at_package9_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package8_truck2_a3))
(at start (not (at_package8_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package8_truck2_a2))
(at start (not (at_package8_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package8_truck2_a1))
(at start (not (at_package8_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package8_truck1_a3))
(at start (not (at_package8_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package8_truck1_a2))
(at start (not (at_package8_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE8_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package8_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package8_truck1_a1))
(at start (not (at_package8_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package7_truck2_a3))
(at start (not (at_package7_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package7_truck2_a2))
(at start (not (at_package7_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package7_truck2_a1))
(at start (not (at_package7_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package7_truck1_a3))
(at start (not (at_package7_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package7_truck1_a2))
(at start (not (at_package7_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE7_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package7_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package7_truck1_a1))
(at start (not (at_package7_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package6_truck2_a3))
(at start (not (at_package6_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package6_truck2_a2))
(at start (not (at_package6_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package6_truck2_a1))
(at start (not (at_package6_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package6_truck1_a3))
(at start (not (at_package6_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package6_truck1_a2))
(at start (not (at_package6_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE6_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package6_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package6_truck1_a1))
(at start (not (at_package6_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package5_truck2_a3))
(at start (not (at_package5_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package5_truck2_a2))
(at start (not (at_package5_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package5_truck2_a1))
(at start (not (at_package5_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package5_truck1_a3))
(at start (not (at_package5_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package5_truck1_a2))
(at start (not (at_package5_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE5_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package5_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package5_truck1_a1))
(at start (not (at_package5_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l1))
(at start (free_a3_truck2))
(over all (at_truck2_l1))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package4_truck2_a3))
(at start (not (at_package4_l1)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l1))
(at start (free_a2_truck2))
(over all (at_truck2_l1))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package4_truck2_a2))
(at start (not (at_package4_l1)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK2_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l1))
(at start (free_a1_truck2))
(over all (at_truck2_l1))
)
:effect
(and
(at end (in_package4_truck2_a1))
(at start (not (at_package4_l1)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A3_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l1))
(at start (free_a3_truck1))
(over all (at_truck1_l1))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package4_truck1_a3))
(at start (not (at_package4_l1)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A2_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l1))
(at start (free_a2_truck1))
(over all (at_truck1_l1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package4_truck1_a2))
(at start (not (at_package4_l1)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE4_TRUCK1_A1_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package4_l1))
(at start (free_a1_truck1))
(over all (at_truck1_l1))
)
:effect
(and
(at end (in_package4_truck1_a1))
(at start (not (at_package4_l1)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package3_truck2_a3))
(at start (not (at_package3_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package3_truck2_a2))
(at start (not (at_package3_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package3_truck2_a1))
(at start (not (at_package3_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package3_truck1_a3))
(at start (not (at_package3_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package3_truck1_a2))
(at start (not (at_package3_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE3_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package3_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package3_truck1_a1))
(at start (not (at_package3_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package2_truck2_a3))
(at start (not (at_package2_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package2_truck2_a2))
(at start (not (at_package2_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package2_truck2_a1))
(at start (not (at_package2_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package2_truck1_a3))
(at start (not (at_package2_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package2_truck1_a2))
(at start (not (at_package2_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE2_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package2_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package2_truck1_a1))
(at start (not (at_package2_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l2))
(at start (free_a3_truck2))
(over all (at_truck2_l2))
(over all (free_a2_truck2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package1_truck2_a3))
(at start (not (at_package1_l2)))
(at start (not (free_a3_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l2))
(at start (free_a2_truck2))
(over all (at_truck2_l2))
(over all (free_a1_truck2))
)
:effect
(and
(at end (in_package1_truck2_a2))
(at start (not (at_package1_l2)))
(at start (not (free_a2_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK2_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l2))
(at start (free_a1_truck2))
(over all (at_truck2_l2))
)
:effect
(and
(at end (in_package1_truck2_a1))
(at start (not (at_package1_l2)))
(at start (not (free_a1_truck2)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l2))
(at start (free_a3_truck1))
(over all (at_truck1_l2))
(over all (free_a2_truck1))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package1_truck1_a3))
(at start (not (at_package1_l2)))
(at start (not (free_a3_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l2))
(at start (free_a2_truck1))
(over all (at_truck1_l2))
(over all (free_a1_truck1))
)
:effect
(and
(at end (in_package1_truck1_a2))
(at start (not (at_package1_l2)))
(at start (not (free_a2_truck1)))
)
)
(:durative-action LOAD_PACKAGE1_TRUCK1_A1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (at_package1_l2))
(at start (free_a1_truck1))
(over all (at_truck1_l2))
)
:effect
(and
(at end (in_package1_truck1_a1))
(at start (not (at_package1_l2)))
(at start (not (free_a1_truck1)))
)
)
(:durative-action DELIVER_PACKAGE13_L3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package13_l3))
)
:effect
(and
(at end (delivered_package13_l3))
(at end (not (at_package13_l3)))
)
)
(:durative-action DELIVER_PACKAGE12_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package12_l2))
)
:effect
(and
(at end (delivered_package12_l2))
(at end (not (at_package12_l2)))
)
)
(:durative-action DELIVER_PACKAGE11_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package11_l2))
)
:effect
(and
(at end (delivered_package11_l2))
(at end (not (at_package11_l2)))
)
)
(:durative-action DELIVER_PACKAGE10_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package10_l2))
)
:effect
(and
(at end (delivered_package10_l2))
(at end (not (at_package10_l2)))
)
)
(:durative-action DELIVER_PACKAGE9_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package9_l1))
)
:effect
(and
(at end (delivered_package9_l1))
(at end (not (at_package9_l1)))
)
)
(:durative-action DELIVER_PACKAGE8_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package8_l1))
)
:effect
(and
(at end (delivered_package8_l1))
(at end (not (at_package8_l1)))
)
)
(:durative-action DELIVER_PACKAGE7_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package7_l1))
)
:effect
(and
(at end (delivered_package7_l1))
(at end (not (at_package7_l1)))
)
)
(:durative-action DELIVER_PACKAGE6_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package6_l1))
)
:effect
(and
(at end (delivered_package6_l1))
(at end (not (at_package6_l1)))
)
)
(:durative-action DELIVER_PACKAGE5_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package5_l1))
)
:effect
(and
(at end (delivered_package5_l1))
(at end (not (at_package5_l1)))
)
)
(:durative-action DELIVER_PACKAGE4_L1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package4_l1))
)
:effect
(and
(at end (delivered_package4_l1))
(at end (not (at_package4_l1)))
)
)
(:durative-action DELIVER_PACKAGE3_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package3_l2))
)
:effect
(and
(at end (delivered_package3_l2))
(at end (not (at_package3_l2)))
)
)
(:durative-action DELIVER_PACKAGE2_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package2_l2))
)
:effect
(and
(at end (delivered_package2_l2))
(at end (not (at_package2_l2)))
)
)
(:durative-action DELIVER_PACKAGE1_L2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(over all (at_package1_l2))
)
:effect
(and
(at end (delivered_package1_l2))
(at end (not (at_package1_l2)))
)
)
(:durative-action DRIVE_TRUCK2_L1_L2
:parameters ()
:duration (= ?duration 632.500000)
:condition
(and
(at start (at_truck2_l1))
)
:effect
(and
(at end (at_truck2_l2))
(at start (not (at_truck2_l1)))
)
)
(:durative-action DRIVE_TRUCK1_L1_L2
:parameters ()
:duration (= ?duration 632.500000)
:condition
(and
(at start (at_truck1_l1))
)
:effect
(and
(at end (at_truck1_l2))
(at start (not (at_truck1_l1)))
)
)
(:durative-action DRIVE_TRUCK2_L1_L3
:parameters ()
:duration (= ?duration 24.000000)
:condition
(and
(at start (at_truck2_l1))
)
:effect
(and
(at end (at_truck2_l3))
(at start (not (at_truck2_l1)))
)
)
(:durative-action DRIVE_TRUCK1_L1_L3
:parameters ()
:duration (= ?duration 24.000000)
:condition
(and
(at start (at_truck1_l1))
)
:effect
(and
(at end (at_truck1_l3))
(at start (not (at_truck1_l1)))
)
)
(:durative-action DRIVE_TRUCK2_L1_L4
:parameters ()
:duration (= ?duration 426.000000)
:condition
(and
(at start (at_truck2_l1))
)
:effect
(and
(at end (at_truck2_l4))
(at start (not (at_truck2_l1)))
)
)
(:durative-action DRIVE_TRUCK1_L1_L4
:parameters ()
:duration (= ?duration 426.000000)
:condition
(and
(at start (at_truck1_l1))
)
:effect
(and
(at end (at_truck1_l4))
(at start (not (at_truck1_l1)))
)
)
(:durative-action DRIVE_TRUCK2_L2_L1
:parameters ()
:duration (= ?duration 632.500000)
:condition
(and
(at start (at_truck2_l2))
)
:effect
(and
(at end (at_truck2_l1))
(at start (not (at_truck2_l2)))
)
)
(:durative-action DRIVE_TRUCK1_L2_L1
:parameters ()
:duration (= ?duration 632.500000)
:condition
(and
(at start (at_truck1_l2))
)
:effect
(and
(at end (at_truck1_l1))
(at start (not (at_truck1_l2)))
)
)
(:durative-action DRIVE_TRUCK2_L2_L3
:parameters ()
:duration (= ?duration 655.799988)
:condition
(and
(at start (at_truck2_l2))
)
:effect
(and
(at end (at_truck2_l3))
(at start (not (at_truck2_l2)))
)
)
(:durative-action DRIVE_TRUCK1_L2_L3
:parameters ()
:duration (= ?duration 655.799988)
:condition
(and
(at start (at_truck1_l2))
)
:effect
(and
(at end (at_truck1_l3))
(at start (not (at_truck1_l2)))
)
)
(:durative-action DRIVE_TRUCK2_L2_L4
:parameters ()
:duration (= ?duration 553.099976)
:condition
(and
(at start (at_truck2_l2))
)
:effect
(and
(at end (at_truck2_l4))
(at start (not (at_truck2_l2)))
)
)
(:durative-action DRIVE_TRUCK1_L2_L4
:parameters ()
:duration (= ?duration 553.099976)
:condition
(and
(at start (at_truck1_l2))
)
:effect
(and
(at end (at_truck1_l4))
(at start (not (at_truck1_l2)))
)
)
)
