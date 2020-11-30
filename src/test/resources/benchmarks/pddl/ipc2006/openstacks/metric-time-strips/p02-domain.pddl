(define (domain GROUNDED-OPENSTACKS-COMPLEX)
(:requirements
:strips
:durative-actions
:numeric-fluents
)
(:predicates
(FOO)
(started_o1)
(started_o2)
(started_o3)
(started_o4)
(started_o5)
(started_o6)
(started_o7)
(started_o8)
(started_o9)
(started_o10)
(made_p1)
(made_p2)
(made_p3)
(made_p4)
(made_p5)
(made_p6)
(made_p7)
(made_p8)
(made_p9)
(made_p10)
(shipped_o1)
(shipped_o2)
(shipped_o3)
(shipped_o4)
(shipped_o5)
(shipped_o6)
(shipped_o7)
(shipped_o8)
(shipped_o9)
(shipped_o10)
(not-made_p10)
(not-made_p9)
(not-made_p8)
(not-made_p7)
(not-made_p6)
(not-made_p5)
(not-made_p4)
(not-made_p3)
(not-made_p2)
(not-made_p1)
(waiting_o10)
(waiting_o9)
(waiting_o8)
(waiting_o7)
(waiting_o6)
(waiting_o5)
(waiting_o4)
(waiting_o3)
(waiting_o2)
(waiting_o1)
)
(:functions
(STACKS-IN-USE)
(MAX-IN-USE)
)
(:durative-action SHIP-ORDER_O10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p8))
(at start (made_p3))
(at start (made_p1))
)
:effect
(and
(at end (shipped_o10))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o10)))
)
)
(:durative-action SHIP-ORDER_O9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p10))
(at start (made_p8))
(at start (made_p6))
)
:effect
(and
(at end (shipped_o9))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o9)))
)
)
(:durative-action SHIP-ORDER_O8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p7))
(at start (made_p5))
(at start (made_p4))
)
:effect
(and
(at end (shipped_o8))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o8)))
)
)
(:durative-action SHIP-ORDER_O7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p10))
(at start (made_p7))
(at start (made_p2))
)
:effect
(and
(at end (shipped_o7))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o7)))
)
)
(:durative-action SHIP-ORDER_O6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p6))
(at start (made_p4))
(at start (made_p3))
)
:effect
(and
(at end (shipped_o6))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o6)))
)
)
(:durative-action SHIP-ORDER_O5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p6))
(at start (made_p3))
(at start (made_p1))
)
:effect
(and
(at end (shipped_o5))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o5)))
)
)
(:durative-action SHIP-ORDER_O4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p9))
(at start (made_p7))
(at start (made_p4))
)
:effect
(and
(at end (shipped_o4))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o4)))
)
)
(:durative-action SHIP-ORDER_O3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p10))
(at start (made_p5))
(at start (made_p2))
)
:effect
(and
(at end (shipped_o3))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o3)))
)
)
(:durative-action SHIP-ORDER_O2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p9))
(at start (made_p8))
(at start (made_p5))
)
:effect
(and
(at end (shipped_o2))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o2)))
)
)
(:durative-action SHIP-ORDER_O1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p9))
(at start (made_p2))
(at start (made_p1))
)
:effect
(and
(at end (shipped_o1))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o1)))
)
)
(:durative-action MAKE-PRODUCT_P10
:parameters ()
:duration (= ?duration 70.000000)
:condition
(and
(at start (not-made_p10))
(at start (started_o9))
(at start (started_o7))
(at start (started_o3))
)
:effect
(and
(at end (made_p10))
(at end (not (not-made_p10)))
)
)
(:durative-action MAKE-PRODUCT_P9
:parameters ()
:duration (= ?duration 30.000000)
:condition
(and
(at start (not-made_p9))
(at start (started_o4))
(at start (started_o2))
(at start (started_o1))
)
:effect
(and
(at end (made_p9))
(at end (not (not-made_p9)))
)
)
(:durative-action MAKE-PRODUCT_P8
:parameters ()
:duration (= ?duration 20.000000)
:condition
(and
(at start (not-made_p8))
(at start (started_o10))
(at start (started_o9))
(at start (started_o2))
)
:effect
(and
(at end (made_p8))
(at end (not (not-made_p8)))
)
)
(:durative-action MAKE-PRODUCT_P7
:parameters ()
:duration (= ?duration 80.000000)
:condition
(and
(at start (not-made_p7))
(at start (started_o8))
(at start (started_o7))
(at start (started_o4))
)
:effect
(and
(at end (made_p7))
(at end (not (not-made_p7)))
)
)
(:durative-action MAKE-PRODUCT_P6
:parameters ()
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p6))
(at start (started_o9))
(at start (started_o6))
(at start (started_o5))
)
:effect
(and
(at end (made_p6))
(at end (not (not-made_p6)))
)
)
(:durative-action MAKE-PRODUCT_P5
:parameters ()
:duration (= ?duration 40.000000)
:condition
(and
(at start (not-made_p5))
(at start (started_o8))
(at start (started_o3))
(at start (started_o2))
)
:effect
(and
(at end (made_p5))
(at end (not (not-made_p5)))
)
)
(:durative-action MAKE-PRODUCT_P4
:parameters ()
:duration (= ?duration 90.000000)
:condition
(and
(at start (not-made_p4))
(at start (started_o8))
(at start (started_o6))
(at start (started_o4))
)
:effect
(and
(at end (made_p4))
(at end (not (not-made_p4)))
)
)
(:durative-action MAKE-PRODUCT_P3
:parameters ()
:duration (= ?duration 40.000000)
:condition
(and
(at start (not-made_p3))
(at start (started_o10))
(at start (started_o6))
(at start (started_o5))
)
:effect
(and
(at end (made_p3))
(at end (not (not-made_p3)))
)
)
(:durative-action MAKE-PRODUCT_P2
:parameters ()
:duration (= ?duration 90.000000)
:condition
(and
(at start (not-made_p2))
(at start (started_o7))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p2))
(at end (not (not-made_p2)))
)
)
(:durative-action MAKE-PRODUCT_P1
:parameters ()
:duration (= ?duration 10.000000)
:condition
(and
(at start (not-made_p1))
(at start (started_o10))
(at start (started_o5))
(at start (started_o1))
)
:effect
(and
(at end (made_p1))
(at end (not (not-made_p1)))
)
)
(:durative-action START-ORDER-2_O10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o10))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o10))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o10)))
)
)
(:durative-action START-ORDER-2_O9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o9))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o9))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o9)))
)
)
(:durative-action START-ORDER-2_O8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o8))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o8))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o8)))
)
)
(:durative-action START-ORDER-2_O7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o7))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o7))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o7)))
)
)
(:durative-action START-ORDER-2_O6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o6))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o6))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o6)))
)
)
(:durative-action START-ORDER-2_O5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o5))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o5))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o5)))
)
)
(:durative-action START-ORDER-2_O4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o4))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o4))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o4)))
)
)
(:durative-action START-ORDER-2_O3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o3))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o3))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o3)))
)
)
(:durative-action START-ORDER-2_O2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o2))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o2))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o2)))
)
)
(:durative-action START-ORDER-2_O1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o1))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o1))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o1)))
)
)
(:durative-action START-ORDER-1_O10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o10))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o10))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o10)))
)
)
(:durative-action START-ORDER-1_O9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o9))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o9))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o9)))
)
)
(:durative-action START-ORDER-1_O8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o8))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o8))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o8)))
)
)
(:durative-action START-ORDER-1_O7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o7))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o7))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o7)))
)
)
(:durative-action START-ORDER-1_O6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o6))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o6))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o6)))
)
)
(:durative-action START-ORDER-1_O5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o5))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o5))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o5)))
)
)
(:durative-action START-ORDER-1_O4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o4))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o4))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o4)))
)
)
(:durative-action START-ORDER-1_O3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o3))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o3))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o3)))
)
)
(:durative-action START-ORDER-1_O2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o2))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o2))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o2)))
)
)
(:durative-action START-ORDER-1_O1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o1))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o1))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o1)))
)
)
)
