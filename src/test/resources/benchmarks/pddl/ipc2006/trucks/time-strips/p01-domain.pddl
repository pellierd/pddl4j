(define (domain GROUNDED-TRUCKS-TIME)
(:requirements
:strips
:durative-actions
:numeric-fluents
)
(:predicates
(FOO)
(at_truck1_l3)
(at_truck1_l1)
(delivered_package1_l3)
(delivered_package2_l3)
(delivered_package3_l1)
(in_package1_truck1_a1)
(in_package1_truck1_a2)
(in_package2_truck1_a1)
(in_package2_truck1_a2)
(in_package3_truck1_a1)
(in_package3_truck1_a2)
(at_package1_l1)
(at_package1_l2)
(at_package2_l1)
(at_package2_l2)
(at_package3_l2)
(at_package3_l3)
(delivered_package1_l1)
(delivered_package1_l2)
(delivered_package2_l1)
(delivered_package2_l2)
(delivered_package3_l2)
(delivered_package3_l3)
(free_a2_truck1)
(free_a1_truck1)
(at_package3_l1)
(at_package2_l3)
(at_package1_l3)
(at_truck1_l2)
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
(:durative-action DRIVE_TRUCK1_L3_L1
:parameters ()
:duration (= ?duration 73.099998)
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
:duration (= ?duration 356.799988)
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
(:durative-action DRIVE_TRUCK1_L1_L2
:parameters ()
:duration (= ?duration 406.299988)
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
:duration (= ?duration 73.099998)
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
:duration (= ?duration 406.299988)
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
:duration (= ?duration 356.799988)
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
)
