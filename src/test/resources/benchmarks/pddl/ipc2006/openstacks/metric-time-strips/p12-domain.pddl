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
(started_o11)
(started_o12)
(started_o13)
(started_o14)
(started_o15)
(started_o16)
(started_o17)
(started_o18)
(started_o19)
(started_o20)
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
(made_p11)
(made_p12)
(made_p13)
(made_p14)
(made_p15)
(made_p16)
(made_p17)
(made_p18)
(made_p19)
(made_p20)
(made_p21)
(made_p22)
(made_p23)
(made_p24)
(made_p25)
(made_p26)
(made_p27)
(made_p28)
(made_p29)
(made_p30)
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
(shipped_o11)
(shipped_o12)
(shipped_o13)
(shipped_o14)
(shipped_o15)
(shipped_o16)
(shipped_o17)
(shipped_o18)
(shipped_o19)
(shipped_o20)
(not-made_p30)
(not-made_p29)
(not-made_p28)
(not-made_p27)
(not-made_p26)
(not-made_p25)
(not-made_p24)
(not-made_p23)
(not-made_p22)
(not-made_p21)
(not-made_p20)
(not-made_p19)
(not-made_p18)
(not-made_p17)
(not-made_p16)
(not-made_p15)
(not-made_p14)
(not-made_p13)
(not-made_p12)
(not-made_p11)
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
(waiting_o20)
(waiting_o19)
(waiting_o18)
(waiting_o17)
(waiting_o16)
(waiting_o15)
(waiting_o14)
(waiting_o13)
(waiting_o12)
(waiting_o11)
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
(:durative-action SHIP-ORDER_O20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p28))
(at start (made_p23))
(at start (made_p22))
(at start (made_p21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p18))
(at start (made_p1))
)
:effect
(and
(at end (shipped_o20))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o20)))
)
)
(:durative-action SHIP-ORDER_O19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p28))
(at start (made_p26))
(at start (made_p22))
(at start (made_p20))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
)
:effect
(and
(at end (shipped_o19))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o19)))
)
)
(:durative-action SHIP-ORDER_O18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p26))
(at start (made_p23))
(at start (made_p18))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p7))
(at start (made_p2))
)
:effect
(and
(at end (shipped_o18))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o18)))
)
)
(:durative-action SHIP-ORDER_O17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p30))
(at start (made_p27))
(at start (made_p25))
(at start (made_p11))
(at start (made_p8))
(at start (made_p7))
(at start (made_p6))
(at start (made_p2))
)
:effect
(and
(at end (shipped_o17))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o17)))
)
)
(:durative-action SHIP-ORDER_O16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p20))
(at start (made_p17))
(at start (made_p15))
(at start (made_p14))
(at start (made_p8))
(at start (made_p6))
(at start (made_p2))
)
:effect
(and
(at end (shipped_o16))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o16)))
)
)
(:durative-action SHIP-ORDER_O15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p25))
(at start (made_p24))
(at start (made_p13))
(at start (made_p11))
(at start (made_p8))
(at start (made_p5))
)
:effect
(and
(at end (shipped_o15))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o15)))
)
)
(:durative-action SHIP-ORDER_O14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p22))
(at start (made_p20))
(at start (made_p14))
(at start (made_p10))
(at start (made_p7))
(at start (made_p6))
(at start (made_p3))
(at start (made_p2))
)
:effect
(and
(at end (shipped_o14))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o14)))
)
)
(:durative-action SHIP-ORDER_O13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p28))
(at start (made_p27))
(at start (made_p26))
(at start (made_p20))
(at start (made_p19))
(at start (made_p18))
(at start (made_p10))
(at start (made_p2))
)
:effect
(and
(at end (shipped_o13))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o13)))
)
)
(:durative-action SHIP-ORDER_O12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p30))
(at start (made_p26))
(at start (made_p15))
(at start (made_p14))
(at start (made_p11))
(at start (made_p8))
(at start (made_p7))
(at start (made_p3))
)
:effect
(and
(at end (shipped_o12))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o12)))
)
)
(:durative-action SHIP-ORDER_O11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p25))
(at start (made_p17))
(at start (made_p15))
(at start (made_p14))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
)
:effect
(and
(at end (shipped_o11))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o11)))
)
)
(:durative-action SHIP-ORDER_O10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p18))
(at start (made_p16))
(at start (made_p10))
(at start (made_p9))
(at start (made_p4))
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
(at start (made_p30))
(at start (made_p29))
(at start (made_p25))
(at start (made_p24))
(at start (made_p15))
(at start (made_p13))
(at start (made_p3))
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
(at start (made_p30))
(at start (made_p25))
(at start (made_p17))
(at start (made_p15))
(at start (made_p8))
(at start (made_p5))
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
(at start (made_p30))
(at start (made_p29))
(at start (made_p15))
(at start (made_p14))
(at start (made_p11))
(at start (made_p7))
(at start (made_p5))
(at start (made_p3))
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
(at start (made_p27))
(at start (made_p26))
(at start (made_p22))
(at start (made_p20))
(at start (made_p18))
(at start (made_p14))
(at start (made_p7))
(at start (made_p4))
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
(at start (made_p30))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (made_p8))
(at start (made_p7))
(at start (made_p3))
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
(at start (made_p27))
(at start (made_p26))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p8))
(at start (made_p6))
(at start (made_p3))
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
(at start (made_p29))
(at start (made_p25))
(at start (made_p24))
(at start (made_p15))
(at start (made_p11))
(at start (made_p6))
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
(at start (made_p28))
(at start (made_p27))
(at start (made_p26))
(at start (made_p23))
(at start (made_p22))
(at start (made_p14))
(at start (made_p12))
(at start (made_p2))
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
(at start (made_p29))
(at start (made_p25))
(at start (made_p24))
(at start (made_p15))
(at start (made_p8))
(at start (made_p7))
(at start (made_p6))
(at start (made_p5))
)
:effect
(and
(at end (shipped_o1))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o1)))
)
)
(:durative-action MAKE-PRODUCT_P30
:parameters ()
:duration (= ?duration 160.000000)
:condition
(and
(at start (not-made_p30))
(at start (started_o17))
(at start (started_o16))
(at start (started_o12))
(at start (started_o11))
(at start (started_o9))
(at start (started_o8))
(at start (started_o7))
(at start (started_o5))
)
:effect
(and
(at end (made_p30))
(at end (not (not-made_p30)))
)
)
(:durative-action MAKE-PRODUCT_P29
:parameters ()
:duration (= ?duration 140.000000)
:condition
(and
(at start (not-made_p29))
(at start (started_o9))
(at start (started_o7))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p29))
(at end (not (not-made_p29)))
)
)
(:durative-action MAKE-PRODUCT_P28
:parameters ()
:duration (= ?duration 200.000000)
:condition
(and
(at start (not-made_p28))
(at start (started_o20))
(at start (started_o19))
(at start (started_o13))
(at start (started_o10))
(at start (started_o2))
)
:effect
(and
(at end (made_p28))
(at end (not (not-made_p28)))
)
)
(:durative-action MAKE-PRODUCT_P27
:parameters ()
:duration (= ?duration 180.000000)
:condition
(and
(at start (not-made_p27))
(at start (started_o17))
(at start (started_o13))
(at start (started_o6))
(at start (started_o5))
(at start (started_o4))
(at start (started_o2))
)
:effect
(and
(at end (made_p27))
(at end (not (not-made_p27)))
)
)
(:durative-action MAKE-PRODUCT_P26
:parameters ()
:duration (= ?duration 120.000000)
:condition
(and
(at start (not-made_p26))
(at start (started_o19))
(at start (started_o18))
(at start (started_o13))
(at start (started_o12))
(at start (started_o6))
(at start (started_o4))
(at start (started_o2))
)
:effect
(and
(at end (made_p26))
(at end (not (not-made_p26)))
)
)
(:durative-action MAKE-PRODUCT_P25
:parameters ()
:duration (= ?duration 200.000000)
:condition
(and
(at start (not-made_p25))
(at start (started_o17))
(at start (started_o15))
(at start (started_o11))
(at start (started_o9))
(at start (started_o8))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p25))
(at end (not (not-made_p25)))
)
)
(:durative-action MAKE-PRODUCT_P24
:parameters ()
:duration (= ?duration 80.000000)
:condition
(and
(at start (not-made_p24))
(at start (started_o15))
(at start (started_o9))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p24))
(at end (not (not-made_p24)))
)
)
(:durative-action MAKE-PRODUCT_P23
:parameters ()
:duration (= ?duration 160.000000)
:condition
(and
(at start (not-made_p23))
(at start (started_o20))
(at start (started_o18))
(at start (started_o10))
(at start (started_o5))
(at start (started_o2))
)
:effect
(and
(at end (made_p23))
(at end (not (not-made_p23)))
)
)
(:durative-action MAKE-PRODUCT_P22
:parameters ()
:duration (= ?duration 140.000000)
:condition
(and
(at start (not-made_p22))
(at start (started_o20))
(at start (started_o19))
(at start (started_o14))
(at start (started_o6))
(at start (started_o2))
)
:effect
(and
(at end (made_p22))
(at end (not (not-made_p22)))
)
)
(:durative-action MAKE-PRODUCT_P21
:parameters ()
:duration (= ?duration 200.000000)
:condition
(and
(at start (not-made_p21))
(at start (started_o20))
(at start (started_o10))
)
:effect
(and
(at end (made_p21))
(at end (not (not-made_p21)))
)
)
(:durative-action MAKE-PRODUCT_P20
:parameters ()
:duration (= ?duration 20.000000)
:condition
(and
(at start (not-made_p20))
(at start (started_o20))
(at start (started_o19))
(at start (started_o16))
(at start (started_o14))
(at start (started_o13))
(at start (started_o6))
(at start (started_o5))
)
:effect
(and
(at end (made_p20))
(at end (not (not-made_p20)))
)
)
(:durative-action MAKE-PRODUCT_P19
:parameters ()
:duration (= ?duration 140.000000)
:condition
(and
(at start (not-made_p19))
(at start (started_o20))
(at start (started_o13))
)
:effect
(and
(at end (made_p19))
(at end (not (not-made_p19)))
)
)
(:durative-action MAKE-PRODUCT_P18
:parameters ()
:duration (= ?duration 60.000000)
:condition
(and
(at start (not-made_p18))
(at start (started_o20))
(at start (started_o18))
(at start (started_o13))
(at start (started_o10))
(at start (started_o6))
)
:effect
(and
(at end (made_p18))
(at end (not (not-made_p18)))
)
)
(:durative-action MAKE-PRODUCT_P17
:parameters ()
:duration (= ?duration 40.000000)
:condition
(and
(at start (not-made_p17))
(at start (started_o18))
(at start (started_o16))
(at start (started_o11))
(at start (started_o8))
(at start (started_o5))
(at start (started_o4))
)
:effect
(and
(at end (made_p17))
(at end (not (not-made_p17)))
)
)
(:durative-action MAKE-PRODUCT_P16
:parameters ()
:duration (= ?duration 40.000000)
:condition
(and
(at start (not-made_p16))
(at start (started_o10))
)
:effect
(and
(at end (made_p16))
(at end (not (not-made_p16)))
)
)
(:durative-action MAKE-PRODUCT_P15
:parameters ()
:duration (= ?duration 160.000000)
:condition
(and
(at start (not-made_p15))
(at start (started_o16))
(at start (started_o12))
(at start (started_o11))
(at start (started_o9))
(at start (started_o8))
(at start (started_o7))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p15))
(at end (not (not-made_p15)))
)
)
(:durative-action MAKE-PRODUCT_P14
:parameters ()
:duration (= ?duration 80.000000)
:condition
(and
(at start (not-made_p14))
(at start (started_o18))
(at start (started_o16))
(at start (started_o14))
(at start (started_o12))
(at start (started_o11))
(at start (started_o7))
(at start (started_o6))
(at start (started_o4))
(at start (started_o2))
)
:effect
(and
(at end (made_p14))
(at end (not (not-made_p14)))
)
)
(:durative-action MAKE-PRODUCT_P13
:parameters ()
:duration (= ?duration 180.000000)
:condition
(and
(at start (not-made_p13))
(at start (started_o15))
(at start (started_o9))
)
:effect
(and
(at end (made_p13))
(at end (not (not-made_p13)))
)
)
(:durative-action MAKE-PRODUCT_P12
:parameters ()
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p12))
(at start (started_o19))
(at start (started_o2))
)
:effect
(and
(at end (made_p12))
(at end (not (not-made_p12)))
)
)
(:durative-action MAKE-PRODUCT_P11
:parameters ()
:duration (= ?duration 180.000000)
:condition
(and
(at start (not-made_p11))
(at start (started_o17))
(at start (started_o15))
(at start (started_o12))
(at start (started_o7))
(at start (started_o3))
)
:effect
(and
(at end (made_p11))
(at end (not (not-made_p11)))
)
)
(:durative-action MAKE-PRODUCT_P10
:parameters ()
:duration (= ?duration 140.000000)
:condition
(and
(at start (not-made_p10))
(at start (started_o19))
(at start (started_o18))
(at start (started_o14))
(at start (started_o13))
(at start (started_o10))
(at start (started_o4))
)
:effect
(and
(at end (made_p10))
(at end (not (not-made_p10)))
)
)
(:durative-action MAKE-PRODUCT_P9
:parameters ()
:duration (= ?duration 60.000000)
:condition
(and
(at start (not-made_p9))
(at start (started_o19))
(at start (started_o10))
)
:effect
(and
(at end (made_p9))
(at end (not (not-made_p9)))
)
)
(:durative-action MAKE-PRODUCT_P8
:parameters ()
:duration (= ?duration 40.000000)
:condition
(and
(at start (not-made_p8))
(at start (started_o17))
(at start (started_o16))
(at start (started_o15))
(at start (started_o12))
(at start (started_o11))
(at start (started_o8))
(at start (started_o5))
(at start (started_o4))
(at start (started_o1))
)
:effect
(and
(at end (made_p8))
(at end (not (not-made_p8)))
)
)
(:durative-action MAKE-PRODUCT_P7
:parameters ()
:duration (= ?duration 160.000000)
:condition
(and
(at start (not-made_p7))
(at start (started_o18))
(at start (started_o17))
(at start (started_o14))
(at start (started_o12))
(at start (started_o7))
(at start (started_o6))
(at start (started_o5))
(at start (started_o1))
)
:effect
(and
(at end (made_p7))
(at end (not (not-made_p7)))
)
)
(:durative-action MAKE-PRODUCT_P6
:parameters ()
:duration (= ?duration 200.000000)
:condition
(and
(at start (not-made_p6))
(at start (started_o17))
(at start (started_o16))
(at start (started_o14))
(at start (started_o4))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p6))
(at end (not (not-made_p6)))
)
)
(:durative-action MAKE-PRODUCT_P5
:parameters ()
:duration (= ?duration 80.000000)
:condition
(and
(at start (not-made_p5))
(at start (started_o15))
(at start (started_o11))
(at start (started_o8))
(at start (started_o7))
(at start (started_o1))
)
:effect
(and
(at end (made_p5))
(at end (not (not-made_p5)))
)
)
(:durative-action MAKE-PRODUCT_P4
:parameters ()
:duration (= ?duration 180.000000)
:condition
(and
(at start (not-made_p4))
(at start (started_o10))
(at start (started_o6))
)
:effect
(and
(at end (made_p4))
(at end (not (not-made_p4)))
)
)
(:durative-action MAKE-PRODUCT_P3
:parameters ()
:duration (= ?duration 80.000000)
:condition
(and
(at start (not-made_p3))
(at start (started_o14))
(at start (started_o12))
(at start (started_o9))
(at start (started_o7))
(at start (started_o5))
(at start (started_o4))
)
:effect
(and
(at end (made_p3))
(at end (not (not-made_p3)))
)
)
(:durative-action MAKE-PRODUCT_P2
:parameters ()
:duration (= ?duration 180.000000)
:condition
(and
(at start (not-made_p2))
(at start (started_o18))
(at start (started_o17))
(at start (started_o16))
(at start (started_o14))
(at start (started_o13))
(at start (started_o11))
(at start (started_o2))
)
:effect
(and
(at end (made_p2))
(at end (not (not-made_p2)))
)
)
(:durative-action MAKE-PRODUCT_P1
:parameters ()
:duration (= ?duration 20.000000)
:condition
(and
(at start (not-made_p1))
(at start (started_o20))
(at start (started_o19))
)
:effect
(and
(at end (made_p1))
(at end (not (not-made_p1)))
)
)
(:durative-action START-ORDER-2_O20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o20))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o20))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o20)))
)
)
(:durative-action START-ORDER-2_O19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o19))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o19))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o19)))
)
)
(:durative-action START-ORDER-2_O18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o18))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o18))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o18)))
)
)
(:durative-action START-ORDER-2_O17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o17))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o17))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o17)))
)
)
(:durative-action START-ORDER-2_O16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o16))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o16))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o16)))
)
)
(:durative-action START-ORDER-2_O15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o15))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o15))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o15)))
)
)
(:durative-action START-ORDER-2_O14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o14))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o14))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o14)))
)
)
(:durative-action START-ORDER-2_O13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o13))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o13))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o13)))
)
)
(:durative-action START-ORDER-2_O12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o12))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o12))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o12)))
)
)
(:durative-action START-ORDER-2_O11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o11))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o11))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o11)))
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
(:durative-action START-ORDER-1_O20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o20))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o20))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o20)))
)
)
(:durative-action START-ORDER-1_O19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o19))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o19))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o19)))
)
)
(:durative-action START-ORDER-1_O18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o18))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o18))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o18)))
)
)
(:durative-action START-ORDER-1_O17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o17))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o17))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o17)))
)
)
(:durative-action START-ORDER-1_O16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o16))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o16))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o16)))
)
)
(:durative-action START-ORDER-1_O15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o15))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o15))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o15)))
)
)
(:durative-action START-ORDER-1_O14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o14))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o14))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o14)))
)
)
(:durative-action START-ORDER-1_O13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o13))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o13))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o13)))
)
)
(:durative-action START-ORDER-1_O12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o12))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o12))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o12)))
)
)
(:durative-action START-ORDER-1_O11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o11))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o11))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o11)))
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
