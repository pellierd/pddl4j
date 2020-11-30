(define (domain GROUNDED-TRUCKS-TIME)
(:requirements
:strips
:durative-actions
:numeric-fluents
)
(:predicates
(FOO)
(at_truck1_l2)
(at_truck1_l1)
(delivered_package1_l2)
(delivered_package2_l2)
(delivered_package3_l3)
(delivered_package4_l3)
(delivered_package5_l2)
(delivered_package6_l2)
(delivered_package7_l2)
(in_package1_truck1_a1)
(in_package1_truck1_a2)
(in_package2_truck1_a1)
(in_package2_truck1_a2)
(in_package3_truck1_a1)
(in_package3_truck1_a2)
(in_package4_truck1_a1)
(in_package4_truck1_a2)
(in_package5_truck1_a1)
(in_package5_truck1_a2)
(in_package6_truck1_a1)
(in_package6_truck1_a2)
(in_package7_truck1_a1)
(in_package7_truck1_a2)
(at_package1_l1)
(at_package1_l3)
(at_package2_l1)
(at_package2_l3)
(at_package3_l1)
(at_package3_l2)
(at_package4_l1)
(at_package4_l2)
(at_package5_l1)
(at_package5_l3)
(at_package6_l1)
(at_package6_l3)
(at_package7_l1)
(at_package7_l3)
(delivered_package1_l1)
(delivered_package1_l3)
(delivered_package2_l1)
(delivered_package2_l3)
(delivered_package3_l1)
(delivered_package3_l2)
(delivered_package4_l1)
(delivered_package4_l2)
(delivered_package5_l1)
(delivered_package5_l3)
(delivered_package6_l1)
(delivered_package6_l3)
(delivered_package7_l1)
(delivered_package7_l3)
(free_a2_truck1)
(free_a1_truck1)
(at_package7_l2)
(at_package6_l2)
(at_package5_l2)
(at_package4_l3)
(at_package3_l3)
(at_package2_l2)
(at_package1_l2)
(at_truck1_l3)
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
(:durative-action DRIVE_TRUCK1_L1_L2
:parameters ()
:duration (= ?duration 215.300003)
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
(:durative-action DRIVE_TRUCK1_L1_L3
:parameters ()
:duration (= ?duration 289.600006)
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
(:durative-action DRIVE_TRUCK1_L2_L1
:parameters ()
:duration (= ?duration 215.300003)
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
(:durative-action DRIVE_TRUCK1_L2_L3
:parameters ()
:duration (= ?duration 306.500000)
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
(:durative-action DRIVE_TRUCK1_L3_L1
:parameters ()
:duration (= ?duration 289.600006)
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
(:durative-action DRIVE_TRUCK1_L3_L2
:parameters ()
:duration (= ?duration 306.500000)
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
)
