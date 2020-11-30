(define (domain GROUNDED-OPENSTACKS-TIME)
(:requirements
:strips
:durative-actions
:numeric-fluents
)
(:predicates
(FOO)
(started_o1)
(stacks-avail_n27)
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
(started_o21)
(started_o22)
(started_o23)
(started_o24)
(started_o25)
(started_o26)
(started_o27)
(started_o28)
(started_o29)
(started_o30)
(stacks-avail_n26)
(stacks-avail_n25)
(stacks-avail_n24)
(stacks-avail_n23)
(stacks-avail_n22)
(stacks-avail_n21)
(stacks-avail_n20)
(stacks-avail_n19)
(stacks-avail_n18)
(stacks-avail_n17)
(stacks-avail_n16)
(stacks-avail_n15)
(stacks-avail_n14)
(stacks-avail_n13)
(stacks-avail_n12)
(stacks-avail_n11)
(stacks-avail_n10)
(stacks-avail_n9)
(stacks-avail_n8)
(stacks-avail_n7)
(stacks-avail_n6)
(stacks-avail_n5)
(stacks-avail_n4)
(stacks-avail_n3)
(stacks-avail_n2)
(stacks-avail_n1)
(stacks-avail_n0)
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
(shipped_o21)
(shipped_o22)
(shipped_o23)
(shipped_o24)
(shipped_o25)
(shipped_o26)
(shipped_o27)
(shipped_o28)
(shipped_o29)
(shipped_o30)
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
(waiting_o30)
(waiting_o29)
(waiting_o28)
(waiting_o27)
(waiting_o26)
(waiting_o25)
(waiting_o24)
(waiting_o23)
(waiting_o22)
(waiting_o21)
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
(stacks-avail_n28)
)
(:durative-action SHIP-ORDER_O30_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O30_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O30_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O30_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O30_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O30_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O30_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O30_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O30_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O30_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O30_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O30_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O30_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O30_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O30_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O30_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O30_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O30_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O30_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O30_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O30_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O30_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O30_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O30_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O30_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O30_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O30_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O30_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o30))
(at start (made_p18))
(at start (made_p16))
(at start (made_p11))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o30))
(at start (not (started_o30)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O29_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O29_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O29_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O29_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O29_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O29_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O29_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O29_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O29_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O29_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O29_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O29_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O29_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O29_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O29_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O29_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O29_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O29_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O29_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O29_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O29_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O29_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O29_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O29_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O29_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O29_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O29_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O29_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o29))
(at start (made_p29))
(at start (made_p27))
(at start (made_p23))
(at start (made_p20))
(at start (made_p17))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o29))
(at start (not (started_o29)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O28_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O28_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O28_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O28_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O28_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O28_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O28_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O28_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O28_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O28_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O28_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O28_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O28_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O28_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O28_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O28_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O28_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O28_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O28_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O28_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O28_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O28_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O28_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O28_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O28_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O28_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O28_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O28_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o28))
(at start (made_p23))
(at start (made_p21))
(at start (made_p15))
(at start (made_p14))
(at start (made_p12))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o28))
(at start (not (started_o28)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O27_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O27_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O27_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O27_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O27_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O27_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O27_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O27_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O27_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O27_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O27_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O27_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O27_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O27_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O27_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O27_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O27_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O27_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O27_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O27_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O27_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O27_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O27_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O27_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O27_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O27_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O27_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O27_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p22))
(at start (made_p21))
(at start (made_p1))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o27))
(at start (not (started_o27)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O26_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O26_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O26_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O26_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O26_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O26_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O26_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O26_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O26_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O26_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O26_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O26_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O26_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O26_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O26_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O26_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O26_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O26_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O26_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O26_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O26_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O26_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O26_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O26_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O26_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O26_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O26_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O26_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o26))
(at start (made_p23))
(at start (made_p21))
(at start (made_p17))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o26))
(at start (not (started_o26)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O25_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O25_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O25_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O25_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O25_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O25_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O25_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O25_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O25_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O25_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O25_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O25_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O25_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O25_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O25_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O25_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O25_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O25_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O25_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O25_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O25_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O25_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O25_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O25_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O25_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O25_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O25_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O25_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p30))
(at start (made_p17))
(at start (made_p14))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o25))
(at start (not (started_o25)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O24_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O24_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O24_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O24_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O24_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O24_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O24_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O24_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O24_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O24_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O24_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O24_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O24_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O24_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O24_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O24_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O24_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O24_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O24_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O24_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O24_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O24_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O24_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O24_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O24_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O24_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O24_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O24_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p26))
(at start (made_p19))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o24))
(at start (not (started_o24)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O23_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O23_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O23_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O23_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O23_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O23_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O23_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O23_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O23_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O23_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O23_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O23_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O23_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O23_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O23_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O23_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O23_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O23_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O23_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O23_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O23_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O23_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O23_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O23_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O23_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O23_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O23_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O23_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p22))
(at start (made_p13))
(at start (made_p11))
(at start (made_p9))
(at start (made_p7))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o23))
(at start (not (started_o23)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O22_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O22_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O22_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O22_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O22_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O22_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O22_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O22_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O22_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O22_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O22_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O22_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O22_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O22_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O22_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O22_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O22_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O22_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O22_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O22_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O22_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O22_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O22_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O22_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O22_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O22_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O22_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O22_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p19))
(at start (made_p15))
(at start (made_p10))
(at start (made_p9))
(at start (made_p5))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o22))
(at start (not (started_o22)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O21_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O21_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O21_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O21_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O21_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O21_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O21_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O21_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O21_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O21_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O21_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O21_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O21_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O21_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O21_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O21_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O21_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O21_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O21_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O21_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O21_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O21_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O21_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O21_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O21_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O21_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O21_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O21_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p20))
(at start (made_p19))
(at start (made_p11))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o21))
(at start (not (started_o21)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O20_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O20_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O20_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O20_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O20_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O20_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O20_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O20_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O20_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O20_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O20_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O20_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O20_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O20_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O20_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O20_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O20_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O20_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O20_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O20_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O20_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O20_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O20_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O20_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O20_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O20_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O20_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O20_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p24))
(at start (made_p23))
(at start (made_p14))
(at start (made_p12))
(at start (made_p7))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o20))
(at start (not (started_o20)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O19_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O19_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O19_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O19_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O19_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O19_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O19_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O19_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O19_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O19_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O19_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O19_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O19_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O19_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O19_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O19_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O19_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O19_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O19_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O19_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O19_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O19_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O19_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O19_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O19_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O19_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O19_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O19_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o19))
(at start (made_p30))
(at start (made_p26))
(at start (made_p23))
(at start (made_p6))
(at start (made_p4))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o19))
(at start (not (started_o19)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O18_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O18_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O18_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O18_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O18_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O18_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O18_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O18_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O18_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O18_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O18_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O18_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O18_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O18_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O18_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O18_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O18_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O18_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O18_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O18_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O18_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O18_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O18_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O18_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O18_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O18_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O18_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O18_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o18))
(at start (made_p17))
(at start (made_p12))
(at start (made_p10))
(at start (made_p9))
(at start (made_p1))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o18))
(at start (not (started_o18)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O17_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O17_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O17_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O17_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O17_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O17_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O17_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O17_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O17_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O17_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O17_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O17_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O17_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O17_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O17_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O17_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O17_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O17_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O17_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O17_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O17_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O17_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O17_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O17_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O17_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O17_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O17_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O17_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o17))
(at start (made_p29))
(at start (made_p11))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o17))
(at start (not (started_o17)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O16_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O16_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O16_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O16_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O16_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O16_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O16_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O16_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O16_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O16_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O16_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O16_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O16_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O16_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O16_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O16_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O16_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O16_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O16_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O16_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O16_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O16_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O16_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O16_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O16_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O16_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O16_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O16_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o16))
(at start (made_p30))
(at start (made_p26))
(at start (made_p24))
(at start (made_p13))
(at start (made_p3))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o16))
(at start (not (started_o16)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O15_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O15_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O15_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O15_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O15_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O15_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O15_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O15_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O15_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O15_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O15_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O15_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O15_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O15_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O15_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O15_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O15_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O15_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O15_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O15_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O15_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O15_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O15_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O15_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O15_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O15_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O15_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O15_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o15))
(at start (made_p20))
(at start (made_p16))
(at start (made_p12))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o15))
(at start (not (started_o15)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O14_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O14_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O14_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O14_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O14_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O14_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O14_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O14_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O14_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O14_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O14_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O14_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O14_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O14_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O14_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O14_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O14_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O14_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O14_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O14_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O14_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O14_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O14_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O14_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O14_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O14_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O14_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O14_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o14))
(at start (made_p30))
(at start (made_p28))
(at start (made_p18))
(at start (made_p15))
(at start (made_p11))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o14))
(at start (not (started_o14)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O13_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O13_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O13_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O13_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O13_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O13_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O13_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O13_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O13_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O13_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O13_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O13_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O13_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O13_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O13_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O13_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O13_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O13_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O13_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O13_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O13_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O13_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O13_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O13_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O13_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O13_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O13_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O13_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o13))
(at start (made_p24))
(at start (made_p22))
(at start (made_p21))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o13))
(at start (not (started_o13)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O12_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O12_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O12_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O12_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O12_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O12_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O12_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O12_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O12_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O12_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O12_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O12_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O12_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O12_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O12_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O12_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O12_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O12_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O12_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O12_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O12_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O12_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O12_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O12_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O12_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O12_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O12_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O12_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o12))
(at start (made_p28))
(at start (made_p25))
(at start (made_p14))
(at start (made_p6))
(at start (made_p1))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o12))
(at start (not (started_o12)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O11_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O11_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O11_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O11_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O11_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O11_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O11_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O11_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O11_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O11_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O11_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O11_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O11_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O11_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O11_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O11_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O11_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O11_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O11_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O11_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O11_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O11_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O11_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O11_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O11_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O11_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O11_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O11_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o11))
(at start (made_p30))
(at start (made_p27))
(at start (made_p18))
(at start (made_p8))
(at start (made_p7))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o11))
(at start (not (started_o11)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O10_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O10_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O10_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O10_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O10_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O10_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O10_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O10_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O10_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O10_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O10_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O10_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O10_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O10_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O10_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O10_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O10_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O10_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O10_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O10_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O10_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O10_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O10_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O10_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O10_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O10_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O10_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O10_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o10))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p8))
(at start (made_p6))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o10))
(at start (not (started_o10)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O9_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O9_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O9_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O9_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O9_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O9_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O9_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O9_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O9_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O9_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O9_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O9_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O9_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O9_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O9_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O9_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O9_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O9_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O9_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O9_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O9_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O9_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O9_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O9_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O9_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O9_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O9_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O9_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o9))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p19))
(at start (made_p3))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o9))
(at start (not (started_o9)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O8_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O8_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O8_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O8_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O8_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O8_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O8_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O8_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O8_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O8_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O8_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O8_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O8_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O8_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O8_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O8_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O8_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O8_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O8_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O8_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O8_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O8_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O8_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O8_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O8_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O8_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O8_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O8_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o8))
(at start (made_p27))
(at start (made_p24))
(at start (made_p20))
(at start (made_p10))
(at start (made_p2))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o8))
(at start (not (started_o8)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O7_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O7_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O7_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O7_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O7_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O7_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O7_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O7_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O7_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O7_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O7_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O7_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O7_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O7_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O7_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O7_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O7_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O7_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O7_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O7_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O7_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O7_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O7_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O7_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O7_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O7_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O7_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O7_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o7))
(at start (made_p18))
(at start (made_p7))
(at start (made_p6))
(at start (made_p4))
(at start (made_p1))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o7))
(at start (not (started_o7)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O6_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O6_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O6_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O6_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O6_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O6_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O6_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O6_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O6_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O6_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O6_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O6_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O6_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O6_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O6_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O6_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O6_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O6_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O6_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O6_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O6_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O6_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O6_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O6_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O6_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O6_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O6_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O6_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o6))
(at start (made_p26))
(at start (made_p19))
(at start (made_p8))
(at start (made_p5))
(at start (made_p2))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o6))
(at start (not (started_o6)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O5_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O5_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O5_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O5_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O5_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O5_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O5_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O5_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O5_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O5_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O5_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O5_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O5_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O5_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O5_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O5_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O5_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O5_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O5_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O5_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O5_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O5_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O5_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O5_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O5_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O5_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O5_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O5_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o5))
(at start (made_p28))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p1))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o5))
(at start (not (started_o5)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O4_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O4_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O4_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O4_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O4_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O4_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O4_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O4_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O4_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O4_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O4_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O4_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O4_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O4_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O4_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O4_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O4_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O4_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O4_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O4_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O4_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O4_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O4_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O4_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O4_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O4_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O4_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O4_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o4))
(at start (made_p25))
(at start (made_p22))
(at start (made_p20))
(at start (made_p5))
(at start (made_p4))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o4))
(at start (not (started_o4)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O3_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O3_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O3_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O3_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O3_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O3_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O3_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O3_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O3_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O3_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O3_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O3_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O3_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O3_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O3_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O3_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O3_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O3_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O3_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O3_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O3_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O3_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O3_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O3_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O3_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O3_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O3_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O3_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o3))
(at start (made_p29))
(at start (made_p28))
(at start (made_p16))
(at start (made_p4))
(at start (made_p3))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o3))
(at start (not (started_o3)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O2_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O2_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O2_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O2_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O2_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O2_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O2_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O2_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O2_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O2_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O2_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O2_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O2_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O2_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O2_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O2_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O2_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O2_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O2_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O2_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O2_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O2_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O2_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O2_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O2_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O2_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O2_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O2_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o2))
(at start (made_p29))
(at start (made_p18))
(at start (made_p17))
(at start (made_p16))
(at start (made_p8))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o2))
(at start (not (started_o2)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action SHIP-ORDER_O1_N27_N28
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n27))
)
:effect
(and
(at end (stacks-avail_n28))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action SHIP-ORDER_O1_N26_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n26))
)
:effect
(and
(at end (stacks-avail_n27))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action SHIP-ORDER_O1_N25_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n25))
)
:effect
(and
(at end (stacks-avail_n26))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action SHIP-ORDER_O1_N24_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n24))
)
:effect
(and
(at end (stacks-avail_n25))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action SHIP-ORDER_O1_N23_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n23))
)
:effect
(and
(at end (stacks-avail_n24))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action SHIP-ORDER_O1_N22_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n22))
)
:effect
(and
(at end (stacks-avail_n23))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action SHIP-ORDER_O1_N21_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n21))
)
:effect
(and
(at end (stacks-avail_n22))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action SHIP-ORDER_O1_N20_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n20))
)
:effect
(and
(at end (stacks-avail_n21))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action SHIP-ORDER_O1_N19_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n19))
)
:effect
(and
(at end (stacks-avail_n20))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action SHIP-ORDER_O1_N18_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n18))
)
:effect
(and
(at end (stacks-avail_n19))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action SHIP-ORDER_O1_N17_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n17))
)
:effect
(and
(at end (stacks-avail_n18))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action SHIP-ORDER_O1_N16_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n16))
)
:effect
(and
(at end (stacks-avail_n17))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action SHIP-ORDER_O1_N15_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n15))
)
:effect
(and
(at end (stacks-avail_n16))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action SHIP-ORDER_O1_N14_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n14))
)
:effect
(and
(at end (stacks-avail_n15))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action SHIP-ORDER_O1_N13_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n13))
)
:effect
(and
(at end (stacks-avail_n14))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action SHIP-ORDER_O1_N12_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n12))
)
:effect
(and
(at end (stacks-avail_n13))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action SHIP-ORDER_O1_N11_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n11))
)
:effect
(and
(at end (stacks-avail_n12))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action SHIP-ORDER_O1_N10_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n10))
)
:effect
(and
(at end (stacks-avail_n11))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action SHIP-ORDER_O1_N9_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n9))
)
:effect
(and
(at end (stacks-avail_n10))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action SHIP-ORDER_O1_N8_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n8))
)
:effect
(and
(at end (stacks-avail_n9))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action SHIP-ORDER_O1_N7_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n7))
)
:effect
(and
(at end (stacks-avail_n8))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action SHIP-ORDER_O1_N6_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n6))
)
:effect
(and
(at end (stacks-avail_n7))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action SHIP-ORDER_O1_N5_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n5))
)
:effect
(and
(at end (stacks-avail_n6))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action SHIP-ORDER_O1_N4_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n4))
)
:effect
(and
(at end (stacks-avail_n5))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action SHIP-ORDER_O1_N3_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n3))
)
:effect
(and
(at end (stacks-avail_n4))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action SHIP-ORDER_O1_N2_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n2))
)
:effect
(and
(at end (stacks-avail_n3))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action SHIP-ORDER_O1_N1_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n1))
)
:effect
(and
(at end (stacks-avail_n2))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action SHIP-ORDER_O1_N0_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o1))
(at start (made_p28))
(at start (made_p21))
(at start (made_p16))
(at start (made_p15))
(at start (made_p13))
(at start (stacks-avail_n0))
)
:effect
(and
(at end (stacks-avail_n1))
(at end (shipped_o1))
(at start (not (started_o1)))
(at start (not (stacks-avail_n0)))
)
)
(:durative-action MAKE-PRODUCT_P30
:parameters ()
:duration (= ?duration 240.000000)
:condition
(and
(at start (not-made_p30))
(at start (started_o25))
(at start (started_o19))
(at start (started_o16))
(at start (started_o14))
(at start (started_o11))
)
:effect
(and
(at end (made_p30))
(at end (not (not-made_p30)))
)
)
(:durative-action MAKE-PRODUCT_P29
:parameters ()
:duration (= ?duration 210.000000)
:condition
(and
(at start (not-made_p29))
(at start (started_o29))
(at start (started_o17))
(at start (started_o10))
(at start (started_o3))
(at start (started_o2))
)
:effect
(and
(at end (made_p29))
(at end (not (not-made_p29)))
)
)
(:durative-action MAKE-PRODUCT_P28
:parameters ()
:duration (= ?duration 300.000000)
:condition
(and
(at start (not-made_p28))
(at start (started_o14))
(at start (started_o12))
(at start (started_o5))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p28))
(at end (not (not-made_p28)))
)
)
(:durative-action MAKE-PRODUCT_P27
:parameters ()
:duration (= ?duration 270.000000)
:condition
(and
(at start (not-made_p27))
(at start (started_o29))
(at start (started_o11))
(at start (started_o10))
(at start (started_o9))
(at start (started_o8))
)
:effect
(and
(at end (made_p27))
(at end (not (not-made_p27)))
)
)
(:durative-action MAKE-PRODUCT_P26
:parameters ()
:duration (= ?duration 180.000000)
:condition
(and
(at start (not-made_p26))
(at start (started_o27))
(at start (started_o24))
(at start (started_o19))
(at start (started_o16))
(at start (started_o6))
)
:effect
(and
(at end (made_p26))
(at end (not (not-made_p26)))
)
)
(:durative-action MAKE-PRODUCT_P25
:parameters ()
:duration (= ?duration 300.000000)
:condition
(and
(at start (not-made_p25))
(at start (started_o27))
(at start (started_o12))
(at start (started_o10))
(at start (started_o9))
(at start (started_o4))
)
:effect
(and
(at end (made_p25))
(at end (not (not-made_p25)))
)
)
(:durative-action MAKE-PRODUCT_P24
:parameters ()
:duration (= ?duration 120.000000)
:condition
(and
(at start (not-made_p24))
(at start (started_o20))
(at start (started_o16))
(at start (started_o13))
(at start (started_o9))
(at start (started_o8))
)
:effect
(and
(at end (made_p24))
(at end (not (not-made_p24)))
)
)
(:durative-action MAKE-PRODUCT_P23
:parameters ()
:duration (= ?duration 240.000000)
:condition
(and
(at start (not-made_p23))
(at start (started_o29))
(at start (started_o28))
(at start (started_o26))
(at start (started_o20))
(at start (started_o19))
)
:effect
(and
(at end (made_p23))
(at end (not (not-made_p23)))
)
)
(:durative-action MAKE-PRODUCT_P22
:parameters ()
:duration (= ?duration 210.000000)
:condition
(and
(at start (not-made_p22))
(at start (started_o27))
(at start (started_o23))
(at start (started_o13))
(at start (started_o5))
(at start (started_o4))
)
:effect
(and
(at end (made_p22))
(at end (not (not-made_p22)))
)
)
(:durative-action MAKE-PRODUCT_P21
:parameters ()
:duration (= ?duration 300.000000)
:condition
(and
(at start (not-made_p21))
(at start (started_o28))
(at start (started_o27))
(at start (started_o26))
(at start (started_o13))
(at start (started_o1))
)
:effect
(and
(at end (made_p21))
(at end (not (not-made_p21)))
)
)
(:durative-action MAKE-PRODUCT_P20
:parameters ()
:duration (= ?duration 30.000000)
:condition
(and
(at start (not-made_p20))
(at start (started_o29))
(at start (started_o21))
(at start (started_o15))
(at start (started_o8))
(at start (started_o4))
)
:effect
(and
(at end (made_p20))
(at end (not (not-made_p20)))
)
)
(:durative-action MAKE-PRODUCT_P19
:parameters ()
:duration (= ?duration 210.000000)
:condition
(and
(at start (not-made_p19))
(at start (started_o24))
(at start (started_o22))
(at start (started_o21))
(at start (started_o9))
(at start (started_o6))
)
:effect
(and
(at end (made_p19))
(at end (not (not-made_p19)))
)
)
(:durative-action MAKE-PRODUCT_P18
:parameters ()
:duration (= ?duration 90.000000)
:condition
(and
(at start (not-made_p18))
(at start (started_o30))
(at start (started_o14))
(at start (started_o11))
(at start (started_o7))
(at start (started_o2))
)
:effect
(and
(at end (made_p18))
(at end (not (not-made_p18)))
)
)
(:durative-action MAKE-PRODUCT_P17
:parameters ()
:duration (= ?duration 60.000000)
:condition
(and
(at start (not-made_p17))
(at start (started_o29))
(at start (started_o26))
(at start (started_o25))
(at start (started_o18))
(at start (started_o2))
)
:effect
(and
(at end (made_p17))
(at end (not (not-made_p17)))
)
)
(:durative-action MAKE-PRODUCT_P16
:parameters ()
:duration (= ?duration 60.000000)
:condition
(and
(at start (not-made_p16))
(at start (started_o30))
(at start (started_o15))
(at start (started_o3))
(at start (started_o2))
(at start (started_o1))
)
:effect
(and
(at end (made_p16))
(at end (not (not-made_p16)))
)
)
(:durative-action MAKE-PRODUCT_P15
:parameters ()
:duration (= ?duration 240.000000)
:condition
(and
(at start (not-made_p15))
(at start (started_o28))
(at start (started_o26))
(at start (started_o22))
(at start (started_o14))
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
:duration (= ?duration 120.000000)
:condition
(and
(at start (not-made_p14))
(at start (started_o28))
(at start (started_o25))
(at start (started_o20))
(at start (started_o12))
(at start (started_o5))
)
:effect
(and
(at end (made_p14))
(at end (not (not-made_p14)))
)
)
(:durative-action MAKE-PRODUCT_P13
:parameters ()
:duration (= ?duration 270.000000)
:condition
(and
(at start (not-made_p13))
(at start (started_o26))
(at start (started_o23))
(at start (started_o16))
(at start (started_o5))
(at start (started_o1))
)
:effect
(and
(at end (made_p13))
(at end (not (not-made_p13)))
)
)
(:durative-action MAKE-PRODUCT_P12
:parameters ()
:duration (= ?duration 150.000000)
:condition
(and
(at start (not-made_p12))
(at start (started_o28))
(at start (started_o24))
(at start (started_o20))
(at start (started_o18))
(at start (started_o15))
)
:effect
(and
(at end (made_p12))
(at end (not (not-made_p12)))
)
)
(:durative-action MAKE-PRODUCT_P11
:parameters ()
:duration (= ?duration 270.000000)
:condition
(and
(at start (not-made_p11))
(at start (started_o30))
(at start (started_o23))
(at start (started_o21))
(at start (started_o17))
(at start (started_o14))
)
:effect
(and
(at end (made_p11))
(at end (not (not-made_p11)))
)
)
(:durative-action MAKE-PRODUCT_P10
:parameters ()
:duration (= ?duration 210.000000)
:condition
(and
(at start (not-made_p10))
(at start (started_o25))
(at start (started_o24))
(at start (started_o22))
(at start (started_o18))
(at start (started_o8))
)
:effect
(and
(at end (made_p10))
(at end (not (not-made_p10)))
)
)
(:durative-action MAKE-PRODUCT_P9
:parameters ()
:duration (= ?duration 90.000000)
:condition
(and
(at start (not-made_p9))
(at start (started_o25))
(at start (started_o24))
(at start (started_o23))
(at start (started_o22))
(at start (started_o18))
)
:effect
(and
(at end (made_p9))
(at end (not (not-made_p9)))
)
)
(:durative-action MAKE-PRODUCT_P8
:parameters ()
:duration (= ?duration 60.000000)
:condition
(and
(at start (not-made_p8))
(at start (started_o15))
(at start (started_o11))
(at start (started_o10))
(at start (started_o6))
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
:duration (= ?duration 240.000000)
:condition
(and
(at start (not-made_p7))
(at start (started_o23))
(at start (started_o20))
(at start (started_o15))
(at start (started_o11))
(at start (started_o7))
)
:effect
(and
(at end (made_p7))
(at end (not (not-made_p7)))
)
)
(:durative-action MAKE-PRODUCT_P6
:parameters ()
:duration (= ?duration 300.000000)
:condition
(and
(at start (not-made_p6))
(at start (started_o30))
(at start (started_o19))
(at start (started_o12))
(at start (started_o10))
(at start (started_o7))
)
:effect
(and
(at end (made_p6))
(at end (not (not-made_p6)))
)
)
(:durative-action MAKE-PRODUCT_P5
:parameters ()
:duration (= ?duration 120.000000)
:condition
(and
(at start (not-made_p5))
(at start (started_o22))
(at start (started_o17))
(at start (started_o13))
(at start (started_o6))
(at start (started_o4))
)
:effect
(and
(at end (made_p5))
(at end (not (not-made_p5)))
)
)
(:durative-action MAKE-PRODUCT_P4
:parameters ()
:duration (= ?duration 270.000000)
:condition
(and
(at start (not-made_p4))
(at start (started_o30))
(at start (started_o19))
(at start (started_o7))
(at start (started_o4))
(at start (started_o3))
)
:effect
(and
(at end (made_p4))
(at end (not (not-made_p4)))
)
)
(:durative-action MAKE-PRODUCT_P3
:parameters ()
:duration (= ?duration 120.000000)
:condition
(and
(at start (not-made_p3))
(at start (started_o21))
(at start (started_o17))
(at start (started_o16))
(at start (started_o9))
(at start (started_o3))
)
:effect
(and
(at end (made_p3))
(at end (not (not-made_p3)))
)
)
(:durative-action MAKE-PRODUCT_P2
:parameters ()
:duration (= ?duration 270.000000)
:condition
(and
(at start (not-made_p2))
(at start (started_o21))
(at start (started_o17))
(at start (started_o13))
(at start (started_o8))
(at start (started_o6))
)
:effect
(and
(at end (made_p2))
(at end (not (not-made_p2)))
)
)
(:durative-action MAKE-PRODUCT_P1
:parameters ()
:duration (= ?duration 30.000000)
:condition
(and
(at start (not-made_p1))
(at start (started_o27))
(at start (started_o18))
(at start (started_o12))
(at start (started_o7))
(at start (started_o5))
)
:effect
(and
(at end (made_p1))
(at end (not (not-made_p1)))
)
)
(:durative-action START-ORDER_O30_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n0))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O29_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n0))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O28_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n0))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O27_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n0))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O26_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n0))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O25_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n0))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O24_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n0))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O23_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n0))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O22_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n0))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O21_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n0))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O20_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n0))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O19_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n0))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O18_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n0))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O17_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n0))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O16_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n0))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O15_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n0))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O14_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n0))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O13_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n0))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O12_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n0))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O11_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n0))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O10_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n0))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O9_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n0))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O8_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n0))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O7_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n0))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O6_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n0))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O5_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n0))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O4_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n0))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O3_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n0))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O2_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n0))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O1_N1_N0
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n1))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n0))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n1)))
)
)
(:durative-action START-ORDER_O30_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n1))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O29_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n1))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O28_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n1))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O27_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n1))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O26_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n1))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O25_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n1))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O24_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n1))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O23_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n1))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O22_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n1))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O21_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n1))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O20_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n1))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O19_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n1))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O18_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n1))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O17_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n1))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O16_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n1))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O15_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n1))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O14_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n1))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O13_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n1))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O12_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n1))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O11_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n1))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O10_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n1))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O9_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n1))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O8_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n1))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O7_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n1))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O6_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n1))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O5_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n1))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O4_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n1))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O3_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n1))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O2_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n1))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O1_N2_N1
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n2))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n1))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n2)))
)
)
(:durative-action START-ORDER_O30_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n2))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O29_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n2))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O28_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n2))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O27_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n2))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O26_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n2))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O25_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n2))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O24_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n2))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O23_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n2))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O22_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n2))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O21_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n2))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O20_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n2))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O19_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n2))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O18_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n2))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O17_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n2))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O16_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n2))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O15_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n2))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O14_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n2))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O13_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n2))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O12_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n2))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O11_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n2))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O10_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n2))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O9_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n2))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O8_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n2))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O7_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n2))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O6_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n2))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O5_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n2))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O4_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n2))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O3_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n2))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O2_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n2))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O1_N3_N2
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n3))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n2))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n3)))
)
)
(:durative-action START-ORDER_O30_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n3))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O29_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n3))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O28_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n3))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O27_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n3))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O26_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n3))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O25_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n3))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O24_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n3))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O23_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n3))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O22_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n3))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O21_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n3))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O20_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n3))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O19_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n3))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O18_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n3))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O17_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n3))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O16_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n3))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O15_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n3))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O14_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n3))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O13_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n3))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O12_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n3))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O11_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n3))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O10_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n3))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O9_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n3))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O8_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n3))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O7_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n3))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O6_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n3))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O5_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n3))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O4_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n3))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O3_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n3))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O2_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n3))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O1_N4_N3
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n4))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n3))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n4)))
)
)
(:durative-action START-ORDER_O30_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n4))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O29_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n4))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O28_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n4))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O27_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n4))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O26_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n4))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O25_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n4))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O24_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n4))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O23_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n4))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O22_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n4))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O21_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n4))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O20_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n4))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O19_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n4))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O18_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n4))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O17_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n4))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O16_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n4))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O15_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n4))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O14_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n4))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O13_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n4))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O12_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n4))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O11_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n4))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O10_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n4))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O9_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n4))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O8_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n4))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O7_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n4))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O6_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n4))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O5_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n4))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O4_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n4))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O3_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n4))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O2_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n4))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O1_N5_N4
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n5))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n4))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n5)))
)
)
(:durative-action START-ORDER_O30_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n5))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O29_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n5))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O28_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n5))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O27_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n5))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O26_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n5))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O25_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n5))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O24_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n5))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O23_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n5))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O22_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n5))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O21_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n5))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O20_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n5))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O19_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n5))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O18_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n5))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O17_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n5))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O16_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n5))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O15_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n5))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O14_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n5))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O13_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n5))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O12_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n5))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O11_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n5))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O10_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n5))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O9_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n5))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O8_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n5))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O7_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n5))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O6_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n5))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O5_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n5))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O4_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n5))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O3_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n5))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O2_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n5))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O1_N6_N5
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n6))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n5))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n6)))
)
)
(:durative-action START-ORDER_O30_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n6))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O29_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n6))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O28_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n6))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O27_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n6))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O26_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n6))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O25_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n6))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O24_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n6))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O23_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n6))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O22_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n6))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O21_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n6))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O20_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n6))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O19_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n6))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O18_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n6))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O17_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n6))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O16_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n6))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O15_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n6))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O14_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n6))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O13_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n6))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O12_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n6))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O11_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n6))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O10_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n6))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O9_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n6))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O8_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n6))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O7_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n6))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O6_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n6))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O5_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n6))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O4_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n6))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O3_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n6))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O2_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n6))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O1_N7_N6
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n7))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n6))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n7)))
)
)
(:durative-action START-ORDER_O30_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n7))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O29_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n7))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O28_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n7))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O27_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n7))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O26_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n7))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O25_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n7))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O24_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n7))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O23_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n7))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O22_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n7))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O21_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n7))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O20_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n7))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O19_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n7))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O18_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n7))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O17_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n7))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O16_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n7))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O15_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n7))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O14_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n7))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O13_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n7))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O12_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n7))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O11_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n7))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O10_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n7))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O9_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n7))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O8_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n7))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O7_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n7))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O6_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n7))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O5_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n7))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O4_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n7))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O3_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n7))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O2_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n7))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O1_N8_N7
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n8))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n7))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n8)))
)
)
(:durative-action START-ORDER_O30_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n8))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O29_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n8))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O28_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n8))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O27_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n8))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O26_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n8))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O25_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n8))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O24_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n8))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O23_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n8))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O22_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n8))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O21_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n8))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O20_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n8))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O19_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n8))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O18_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n8))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O17_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n8))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O16_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n8))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O15_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n8))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O14_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n8))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O13_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n8))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O12_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n8))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O11_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n8))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O10_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n8))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O9_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n8))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O8_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n8))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O7_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n8))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O6_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n8))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O5_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n8))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O4_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n8))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O3_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n8))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O2_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n8))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O1_N9_N8
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n9))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n8))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n9)))
)
)
(:durative-action START-ORDER_O30_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n9))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O29_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n9))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O28_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n9))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O27_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n9))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O26_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n9))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O25_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n9))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O24_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n9))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O23_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n9))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O22_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n9))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O21_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n9))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O20_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n9))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O19_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n9))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O18_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n9))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O17_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n9))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O16_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n9))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O15_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n9))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O14_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n9))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O13_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n9))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O12_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n9))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O11_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n9))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O10_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n9))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O9_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n9))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O8_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n9))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O7_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n9))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O6_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n9))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O5_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n9))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O4_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n9))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O3_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n9))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O2_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n9))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O1_N10_N9
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n10))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n9))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n10)))
)
)
(:durative-action START-ORDER_O30_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n10))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O29_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n10))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O28_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n10))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O27_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n10))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O26_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n10))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O25_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n10))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O24_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n10))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O23_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n10))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O22_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n10))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O21_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n10))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O20_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n10))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O19_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n10))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O18_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n10))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O17_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n10))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O16_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n10))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O15_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n10))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O14_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n10))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O13_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n10))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O12_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n10))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O11_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n10))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O10_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n10))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O9_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n10))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O8_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n10))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O7_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n10))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O6_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n10))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O5_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n10))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O4_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n10))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O3_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n10))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O2_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n10))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O1_N11_N10
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n11))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n10))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n11)))
)
)
(:durative-action START-ORDER_O30_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n11))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O29_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n11))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O28_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n11))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O27_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n11))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O26_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n11))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O25_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n11))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O24_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n11))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O23_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n11))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O22_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n11))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O21_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n11))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O20_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n11))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O19_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n11))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O18_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n11))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O17_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n11))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O16_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n11))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O15_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n11))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O14_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n11))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O13_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n11))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O12_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n11))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O11_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n11))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O10_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n11))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O9_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n11))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O8_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n11))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O7_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n11))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O6_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n11))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O5_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n11))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O4_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n11))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O3_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n11))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O2_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n11))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O1_N12_N11
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n12))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n11))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n12)))
)
)
(:durative-action START-ORDER_O30_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n12))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O29_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n12))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O28_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n12))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O27_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n12))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O26_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n12))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O25_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n12))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O24_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n12))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O23_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n12))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O22_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n12))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O21_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n12))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O20_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n12))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O19_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n12))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O18_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n12))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O17_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n12))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O16_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n12))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O15_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n12))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O14_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n12))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O13_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n12))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O12_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n12))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O11_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n12))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O10_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n12))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O9_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n12))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O8_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n12))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O7_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n12))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O6_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n12))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O5_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n12))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O4_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n12))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O3_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n12))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O2_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n12))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O1_N13_N12
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n13))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n12))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n13)))
)
)
(:durative-action START-ORDER_O30_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n13))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O29_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n13))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O28_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n13))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O27_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n13))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O26_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n13))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O25_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n13))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O24_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n13))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O23_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n13))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O22_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n13))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O21_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n13))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O20_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n13))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O19_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n13))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O18_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n13))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O17_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n13))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O16_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n13))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O15_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n13))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O14_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n13))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O13_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n13))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O12_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n13))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O11_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n13))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O10_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n13))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O9_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n13))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O8_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n13))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O7_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n13))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O6_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n13))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O5_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n13))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O4_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n13))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O3_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n13))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O2_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n13))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O1_N14_N13
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n14))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n13))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n14)))
)
)
(:durative-action START-ORDER_O30_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n14))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O29_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n14))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O28_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n14))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O27_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n14))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O26_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n14))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O25_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n14))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O24_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n14))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O23_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n14))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O22_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n14))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O21_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n14))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O20_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n14))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O19_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n14))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O18_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n14))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O17_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n14))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O16_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n14))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O15_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n14))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O14_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n14))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O13_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n14))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O12_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n14))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O11_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n14))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O10_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n14))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O9_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n14))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O8_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n14))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O7_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n14))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O6_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n14))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O5_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n14))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O4_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n14))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O3_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n14))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O2_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n14))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O1_N15_N14
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n15))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n14))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n15)))
)
)
(:durative-action START-ORDER_O30_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n15))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O29_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n15))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O28_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n15))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O27_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n15))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O26_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n15))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O25_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n15))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O24_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n15))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O23_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n15))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O22_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n15))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O21_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n15))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O20_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n15))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O19_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n15))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O18_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n15))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O17_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n15))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O16_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n15))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O15_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n15))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O14_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n15))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O13_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n15))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O12_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n15))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O11_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n15))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O10_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n15))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O9_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n15))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O8_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n15))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O7_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n15))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O6_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n15))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O5_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n15))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O4_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n15))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O3_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n15))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O2_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n15))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O1_N16_N15
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n16))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n15))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n16)))
)
)
(:durative-action START-ORDER_O30_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n16))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O29_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n16))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O28_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n16))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O27_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n16))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O26_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n16))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O25_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n16))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O24_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n16))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O23_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n16))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O22_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n16))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O21_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n16))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O20_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n16))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O19_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n16))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O18_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n16))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O17_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n16))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O16_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n16))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O15_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n16))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O14_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n16))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O13_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n16))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O12_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n16))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O11_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n16))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O10_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n16))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O9_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n16))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O8_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n16))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O7_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n16))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O6_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n16))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O5_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n16))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O4_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n16))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O3_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n16))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O2_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n16))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O1_N17_N16
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n17))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n16))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n17)))
)
)
(:durative-action START-ORDER_O30_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n17))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O29_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n17))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O28_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n17))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O27_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n17))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O26_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n17))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O25_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n17))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O24_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n17))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O23_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n17))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O22_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n17))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O21_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n17))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O20_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n17))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O19_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n17))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O18_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n17))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O17_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n17))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O16_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n17))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O15_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n17))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O14_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n17))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O13_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n17))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O12_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n17))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O11_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n17))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O10_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n17))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O9_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n17))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O8_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n17))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O7_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n17))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O6_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n17))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O5_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n17))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O4_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n17))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O3_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n17))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O2_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n17))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O1_N18_N17
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n18))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n17))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n18)))
)
)
(:durative-action START-ORDER_O30_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n18))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O29_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n18))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O28_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n18))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O27_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n18))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O26_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n18))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O25_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n18))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O24_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n18))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O23_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n18))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O22_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n18))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O21_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n18))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O20_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n18))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O19_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n18))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O18_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n18))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O17_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n18))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O16_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n18))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O15_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n18))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O14_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n18))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O13_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n18))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O12_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n18))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O11_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n18))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O10_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n18))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O9_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n18))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O8_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n18))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O7_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n18))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O6_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n18))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O5_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n18))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O4_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n18))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O3_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n18))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O2_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n18))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O1_N19_N18
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n19))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n18))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n19)))
)
)
(:durative-action START-ORDER_O30_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n19))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O29_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n19))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O28_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n19))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O27_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n19))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O26_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n19))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O25_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n19))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O24_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n19))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O23_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n19))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O22_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n19))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O21_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n19))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O20_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n19))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O19_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n19))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O18_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n19))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O17_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n19))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O16_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n19))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O15_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n19))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O14_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n19))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O13_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n19))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O12_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n19))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O11_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n19))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O10_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n19))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O9_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n19))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O8_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n19))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O7_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n19))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O6_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n19))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O5_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n19))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O4_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n19))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O3_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n19))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O2_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n19))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O1_N20_N19
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n20))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n19))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n20)))
)
)
(:durative-action START-ORDER_O30_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n20))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O29_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n20))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O28_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n20))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O27_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n20))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O26_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n20))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O25_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n20))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O24_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n20))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O23_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n20))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O22_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n20))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O21_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n20))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O20_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n20))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O19_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n20))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O18_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n20))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O17_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n20))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O16_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n20))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O15_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n20))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O14_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n20))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O13_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n20))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O12_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n20))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O11_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n20))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O10_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n20))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O9_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n20))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O8_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n20))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O7_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n20))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O6_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n20))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O5_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n20))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O4_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n20))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O3_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n20))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O2_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n20))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O1_N21_N20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n21))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n20))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n21)))
)
)
(:durative-action START-ORDER_O30_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n21))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O29_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n21))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O28_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n21))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O27_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n21))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O26_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n21))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O25_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n21))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O24_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n21))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O23_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n21))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O22_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n21))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O21_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n21))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O20_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n21))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O19_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n21))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O18_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n21))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O17_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n21))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O16_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n21))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O15_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n21))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O14_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n21))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O13_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n21))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O12_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n21))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O11_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n21))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O10_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n21))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O9_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n21))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O8_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n21))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O7_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n21))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O6_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n21))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O5_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n21))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O4_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n21))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O3_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n21))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O2_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n21))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O1_N22_N21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n22))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n21))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n22)))
)
)
(:durative-action START-ORDER_O30_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n22))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O29_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n22))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O28_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n22))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O27_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n22))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O26_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n22))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O25_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n22))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O24_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n22))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O23_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n22))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O22_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n22))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O21_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n22))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O20_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n22))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O19_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n22))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O18_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n22))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O17_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n22))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O16_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n22))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O15_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n22))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O14_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n22))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O13_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n22))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O12_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n22))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O11_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n22))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O10_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n22))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O9_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n22))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O8_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n22))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O7_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n22))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O6_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n22))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O5_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n22))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O4_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n22))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O3_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n22))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O2_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n22))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O1_N23_N22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n23))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n22))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n23)))
)
)
(:durative-action START-ORDER_O30_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n23))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O29_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n23))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O28_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n23))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O27_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n23))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O26_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n23))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O25_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n23))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O24_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n23))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O23_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n23))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O22_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n23))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O21_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n23))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O20_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n23))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O19_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n23))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O18_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n23))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O17_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n23))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O16_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n23))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O15_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n23))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O14_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n23))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O13_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n23))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O12_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n23))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O11_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n23))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O10_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n23))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O9_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n23))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O8_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n23))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O7_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n23))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O6_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n23))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O5_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n23))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O4_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n23))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O3_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n23))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O2_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n23))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O1_N24_N23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n24))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n23))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n24)))
)
)
(:durative-action START-ORDER_O30_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n24))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O29_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n24))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O28_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n24))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O27_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n24))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O26_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n24))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O25_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n24))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O24_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n24))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O23_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n24))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O22_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n24))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O21_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n24))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O20_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n24))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O19_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n24))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O18_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n24))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O17_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n24))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O16_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n24))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O15_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n24))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O14_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n24))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O13_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n24))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O12_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n24))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O11_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n24))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O10_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n24))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O9_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n24))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O8_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n24))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O7_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n24))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O6_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n24))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O5_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n24))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O4_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n24))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O3_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n24))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O2_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n24))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O1_N25_N24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n25))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n24))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n25)))
)
)
(:durative-action START-ORDER_O30_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n25))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O29_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n25))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O28_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n25))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O27_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n25))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O26_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n25))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O25_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n25))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O24_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n25))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O23_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n25))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O22_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n25))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O21_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n25))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O20_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n25))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O19_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n25))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O18_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n25))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O17_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n25))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O16_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n25))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O15_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n25))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O14_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n25))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O13_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n25))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O12_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n25))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O11_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n25))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O10_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n25))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O9_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n25))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O8_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n25))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O7_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n25))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O6_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n25))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O5_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n25))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O4_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n25))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O3_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n25))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O2_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n25))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O1_N26_N25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n26))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n25))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n26)))
)
)
(:durative-action START-ORDER_O30_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n26))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O29_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n26))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O28_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n26))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O27_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n26))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O26_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n26))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O25_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n26))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O24_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n26))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O23_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n26))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O22_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n26))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O21_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n26))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O20_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n26))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O19_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n26))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O18_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n26))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O17_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n26))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O16_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n26))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O15_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n26))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O14_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n26))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O13_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n26))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O12_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n26))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O11_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n26))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O10_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n26))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O9_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n26))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O8_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n26))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O7_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n26))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O6_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n26))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O5_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n26))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O4_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n26))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O3_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n26))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O2_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n26))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O1_N27_N26
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n27))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n26))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n27)))
)
)
(:durative-action START-ORDER_O30_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o30))
)
:effect
(and
(at end (started_o30))
(at end (stacks-avail_n27))
(at start (not (waiting_o30)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O29_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o29))
)
:effect
(and
(at end (started_o29))
(at end (stacks-avail_n27))
(at start (not (waiting_o29)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O28_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o28))
)
:effect
(and
(at end (started_o28))
(at end (stacks-avail_n27))
(at start (not (waiting_o28)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O27_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o27))
)
:effect
(and
(at end (started_o27))
(at end (stacks-avail_n27))
(at start (not (waiting_o27)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O26_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o26))
)
:effect
(and
(at end (started_o26))
(at end (stacks-avail_n27))
(at start (not (waiting_o26)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O25_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o25))
)
:effect
(and
(at end (started_o25))
(at end (stacks-avail_n27))
(at start (not (waiting_o25)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O24_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o24))
)
:effect
(and
(at end (started_o24))
(at end (stacks-avail_n27))
(at start (not (waiting_o24)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O23_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o23))
)
:effect
(and
(at end (started_o23))
(at end (stacks-avail_n27))
(at start (not (waiting_o23)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O22_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o22))
)
:effect
(and
(at end (started_o22))
(at end (stacks-avail_n27))
(at start (not (waiting_o22)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O21_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o21))
)
:effect
(and
(at end (started_o21))
(at end (stacks-avail_n27))
(at start (not (waiting_o21)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O20_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o20))
)
:effect
(and
(at end (started_o20))
(at end (stacks-avail_n27))
(at start (not (waiting_o20)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O19_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o19))
)
:effect
(and
(at end (started_o19))
(at end (stacks-avail_n27))
(at start (not (waiting_o19)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O18_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o18))
)
:effect
(and
(at end (started_o18))
(at end (stacks-avail_n27))
(at start (not (waiting_o18)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O17_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o17))
)
:effect
(and
(at end (started_o17))
(at end (stacks-avail_n27))
(at start (not (waiting_o17)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O16_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o16))
)
:effect
(and
(at end (started_o16))
(at end (stacks-avail_n27))
(at start (not (waiting_o16)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O15_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o15))
)
:effect
(and
(at end (started_o15))
(at end (stacks-avail_n27))
(at start (not (waiting_o15)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O14_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o14))
)
:effect
(and
(at end (started_o14))
(at end (stacks-avail_n27))
(at start (not (waiting_o14)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O13_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o13))
)
:effect
(and
(at end (started_o13))
(at end (stacks-avail_n27))
(at start (not (waiting_o13)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O12_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o12))
)
:effect
(and
(at end (started_o12))
(at end (stacks-avail_n27))
(at start (not (waiting_o12)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O11_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o11))
)
:effect
(and
(at end (started_o11))
(at end (stacks-avail_n27))
(at start (not (waiting_o11)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O10_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o10))
)
:effect
(and
(at end (started_o10))
(at end (stacks-avail_n27))
(at start (not (waiting_o10)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O9_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o9))
)
:effect
(and
(at end (started_o9))
(at end (stacks-avail_n27))
(at start (not (waiting_o9)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O8_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o8))
)
:effect
(and
(at end (started_o8))
(at end (stacks-avail_n27))
(at start (not (waiting_o8)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O7_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o7))
)
:effect
(and
(at end (started_o7))
(at end (stacks-avail_n27))
(at start (not (waiting_o7)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O6_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o6))
)
:effect
(and
(at end (started_o6))
(at end (stacks-avail_n27))
(at start (not (waiting_o6)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O5_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o5))
)
:effect
(and
(at end (started_o5))
(at end (stacks-avail_n27))
(at start (not (waiting_o5)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O4_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o4))
)
:effect
(and
(at end (started_o4))
(at end (stacks-avail_n27))
(at start (not (waiting_o4)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O3_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o3))
)
:effect
(and
(at end (started_o3))
(at end (stacks-avail_n27))
(at start (not (waiting_o3)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O2_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o2))
)
:effect
(and
(at end (started_o2))
(at end (stacks-avail_n27))
(at start (not (waiting_o2)))
(at start (not (stacks-avail_n28)))
)
)
(:durative-action START-ORDER_O1_N28_N27
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (stacks-avail_n28))
(at start (waiting_o1))
)
:effect
(and
(at end (started_o1))
(at end (stacks-avail_n27))
(at start (not (waiting_o1)))
(at start (not (stacks-avail_n28)))
)
)
)
