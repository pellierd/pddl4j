(define (domain openstacks-time-nonADL-nonNegated)
(:requirements :typing :durative-actions)
(:types order product count)
(:constants 
 p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17 p18 p19 p20 p21 p22 p23 p24 p25 p26 p27 p28 p29 p30 p31 p32 - product
 o1 o2 o3 o4 o5 o6 o7 o8 o9 o10 o11 o12 o13 o14 o15 o16 o17 o18 o19 o20 o21 o22 o23 o24 o25 o26 o27 o28 o29 o30 o31 o32 - order
)

(:predicates 
	(includes ?o - order ?p - product)
	(waiting ?o - order)
	(started ?o - order)
	(shipped ?o - order)
	(made ?p - product)
	(not-made ?p - product)
	(stacks-avail ?s - count)
	(next-count ?s ?ns - count)
)

(:durative-action start-order
:parameters (?o - order ?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (waiting ?o))(at start (stacks-avail ?avail))(at start (next-count ?new-avail ?avail)))
:effect (and (at start (not (waiting ?o)))(at end (started ?o))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail)))
)

(:durative-action make-product-p1
:parameters ()
:duration (= ?duration 40)
:condition (and (at start (not-made p1))(at start (started o22)))
:effect (and (at start (not (not-made p1))) (at end (made p1)))
)

(:durative-action make-product-p2
:parameters ()
:duration (= ?duration 70)
:condition (and (at start (not-made p2))(at start (started o9))(at start (started o13))(at start (started o31)))
:effect (and (at start (not (not-made p2))) (at end (made p2)))
)

(:durative-action make-product-p3
:parameters ()
:duration (= ?duration 60)
:condition (and (at start (not-made p3))(at start (started o24)))
:effect (and (at start (not (not-made p3))) (at end (made p3)))
)

(:durative-action make-product-p4
:parameters ()
:duration (= ?duration 40)
:condition (and (at start (not-made p4))(at start (started o3)))
:effect (and (at start (not (not-made p4))) (at end (made p4)))
)

(:durative-action make-product-p5
:parameters ()
:duration (= ?duration 20)
:condition (and (at start (not-made p5))(at start (started o22)))
:effect (and (at start (not (not-made p5))) (at end (made p5)))
)

(:durative-action make-product-p6
:parameters ()
:duration (= ?duration 50)
:condition (and (at start (not-made p6))(at start (started o21)))
:effect (and (at start (not (not-made p6))) (at end (made p6)))
)

(:durative-action make-product-p7
:parameters ()
:duration (= ?duration 100)
:condition (and (at start (not-made p7))(at start (started o20)))
:effect (and (at start (not (not-made p7))) (at end (made p7)))
)

(:durative-action make-product-p8
:parameters ()
:duration (= ?duration 90)
:condition (and (at start (not-made p8))(at start (started o12)))
:effect (and (at start (not (not-made p8))) (at end (made p8)))
)

(:durative-action make-product-p9
:parameters ()
:duration (= ?duration 80)
:condition (and (at start (not-made p9))(at start (started o4))(at start (started o6))(at start (started o31)))
:effect (and (at start (not (not-made p9))) (at end (made p9)))
)

(:durative-action make-product-p10
:parameters ()
:duration (= ?duration 20)
:condition (and (at start (not-made p10))(at start (started o17)))
:effect (and (at start (not (not-made p10))) (at end (made p10)))
)

(:durative-action make-product-p11
:parameters ()
:duration (= ?duration 10)
:condition (and (at start (not-made p11))(at start (started o7)))
:effect (and (at start (not (not-made p11))) (at end (made p11)))
)

(:durative-action make-product-p12
:parameters ()
:duration (= ?duration 70)
:condition (and (at start (not-made p12))(at start (started o9))(at start (started o22)))
:effect (and (at start (not (not-made p12))) (at end (made p12)))
)

(:durative-action make-product-p13
:parameters ()
:duration (= ?duration 40)
:condition (and (at start (not-made p13))(at start (started o6))(at start (started o17))(at start (started o25)))
:effect (and (at start (not (not-made p13))) (at end (made p13)))
)

(:durative-action make-product-p14
:parameters ()
:duration (= ?duration 90)
:condition (and (at start (not-made p14))(at start (started o7))(at start (started o19)))
:effect (and (at start (not (not-made p14))) (at end (made p14)))
)

(:durative-action make-product-p15
:parameters ()
:duration (= ?duration 20)
:condition (and (at start (not-made p15))(at start (started o14)))
:effect (and (at start (not (not-made p15))) (at end (made p15)))
)

(:durative-action make-product-p16
:parameters ()
:duration (= ?duration 50)
:condition (and (at start (not-made p16))(at start (started o16))(at start (started o30))(at start (started o32)))
:effect (and (at start (not (not-made p16))) (at end (made p16)))
)

(:durative-action make-product-p17
:parameters ()
:duration (= ?duration 20)
:condition (and (at start (not-made p17))(at start (started o5))(at start (started o12)))
:effect (and (at start (not (not-made p17))) (at end (made p17)))
)

(:durative-action make-product-p18
:parameters ()
:duration (= ?duration 20)
:condition (and (at start (not-made p18))(at start (started o4)))
:effect (and (at start (not (not-made p18))) (at end (made p18)))
)

(:durative-action make-product-p19
:parameters ()
:duration (= ?duration 80)
:condition (and (at start (not-made p19))(at start (started o5))(at start (started o8)))
:effect (and (at start (not (not-made p19))) (at end (made p19)))
)

(:durative-action make-product-p20
:parameters ()
:duration (= ?duration 90)
:condition (and (at start (not-made p20))(at start (started o2))(at start (started o3)))
:effect (and (at start (not (not-made p20))) (at end (made p20)))
)

(:durative-action make-product-p21
:parameters ()
:duration (= ?duration 100)
:condition (and (at start (not-made p21))(at start (started o23)))
:effect (and (at start (not (not-made p21))) (at end (made p21)))
)

(:durative-action make-product-p22
:parameters ()
:duration (= ?duration 60)
:condition (and (at start (not-made p22))(at start (started o26)))
:effect (and (at start (not (not-made p22))) (at end (made p22)))
)

(:durative-action make-product-p23
:parameters ()
:duration (= ?duration 100)
:condition (and (at start (not-made p23))(at start (started o4)))
:effect (and (at start (not (not-made p23))) (at end (made p23)))
)

(:durative-action make-product-p24
:parameters ()
:duration (= ?duration 40)
:condition (and (at start (not-made p24))(at start (started o10))(at start (started o14)))
:effect (and (at start (not (not-made p24))) (at end (made p24)))
)

(:durative-action make-product-p25
:parameters ()
:duration (= ?duration 90)
:condition (and (at start (not-made p25))(at start (started o11)))
:effect (and (at start (not (not-made p25))) (at end (made p25)))
)

(:durative-action make-product-p26
:parameters ()
:duration (= ?duration 20)
:condition (and (at start (not-made p26))(at start (started o5))(at start (started o15))(at start (started o29)))
:effect (and (at start (not (not-made p26))) (at end (made p26)))
)

(:durative-action make-product-p27
:parameters ()
:duration (= ?duration 50)
:condition (and (at start (not-made p27))(at start (started o17)))
:effect (and (at start (not (not-made p27))) (at end (made p27)))
)

(:durative-action make-product-p28
:parameters ()
:duration (= ?duration 50)
:condition (and (at start (not-made p28))(at start (started o11))(at start (started o28)))
:effect (and (at start (not (not-made p28))) (at end (made p28)))
)

(:durative-action make-product-p29
:parameters ()
:duration (= ?duration 70)
:condition (and (at start (not-made p29))(at start (started o2))(at start (started o14))(at start (started o18)))
:effect (and (at start (not (not-made p29))) (at end (made p29)))
)

(:durative-action make-product-p30
:parameters ()
:duration (= ?duration 10)
:condition (and (at start (not-made p30))(at start (started o1))(at start (started o11))(at start (started o23))(at start (started o27)))
:effect (and (at start (not (not-made p30))) (at end (made p30)))
)

(:durative-action make-product-p31
:parameters ()
:duration (= ?duration 70)
:condition (and (at start (not-made p31))(at start (started o29)))
:effect (and (at start (not (not-made p31))) (at end (made p31)))
)

(:durative-action make-product-p32
:parameters ()
:duration (= ?duration 50)
:condition (and (at start (not-made p32))(at start (started o23))(at start (started o29)))
:effect (and (at start (not (not-made p32))) (at end (made p32)))
)

(:durative-action ship-order-o1
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o1))(at start (made p30))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o1)))(at end (shipped o1))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o2
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o2))(at start (made p20))(at start (made p29))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o2)))(at end (shipped o2))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o3
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o3))(at start (made p4))(at start (made p20))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o3)))(at end (shipped o3))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o4
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o4))(at start (made p9))(at start (made p18))(at start (made p23))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o4)))(at end (shipped o4))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o5
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o5))(at start (made p17))(at start (made p19))(at start (made p26))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o5)))(at end (shipped o5))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o6
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o6))(at start (made p9))(at start (made p13))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o6)))(at end (shipped o6))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o7
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o7))(at start (made p11))(at start (made p14))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o7)))(at end (shipped o7))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o8
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o8))(at start (made p19))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o8)))(at end (shipped o8))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o9
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o9))(at start (made p2))(at start (made p12))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o9)))(at end (shipped o9))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o10
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o10))(at start (made p24))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o10)))(at end (shipped o10))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o11
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o11))(at start (made p25))(at start (made p28))(at start (made p30))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o11)))(at end (shipped o11))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o12
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o12))(at start (made p8))(at start (made p17))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o12)))(at end (shipped o12))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o13
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o13))(at start (made p2))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o13)))(at end (shipped o13))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o14
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o14))(at start (made p15))(at start (made p24))(at start (made p29))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o14)))(at end (shipped o14))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o15
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o15))(at start (made p26))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o15)))(at end (shipped o15))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o16
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o16))(at start (made p16))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o16)))(at end (shipped o16))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o17
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o17))(at start (made p10))(at start (made p13))(at start (made p27))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o17)))(at end (shipped o17))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o18
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o18))(at start (made p29))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o18)))(at end (shipped o18))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o19
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o19))(at start (made p14))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o19)))(at end (shipped o19))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o20
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o20))(at start (made p7))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o20)))(at end (shipped o20))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o21
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o21))(at start (made p6))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o21)))(at end (shipped o21))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o22
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o22))(at start (made p1))(at start (made p5))(at start (made p12))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o22)))(at end (shipped o22))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o23
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o23))(at start (made p21))(at start (made p30))(at start (made p32))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o23)))(at end (shipped o23))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o24
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o24))(at start (made p3))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o24)))(at end (shipped o24))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o25
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o25))(at start (made p13))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o25)))(at end (shipped o25))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o26
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o26))(at start (made p22))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o26)))(at end (shipped o26))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o27
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o27))(at start (made p30))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o27)))(at end (shipped o27))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o28
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o28))(at start (made p28))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o28)))(at end (shipped o28))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o29
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o29))(at start (made p26))(at start (made p31))(at start (made p32))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o29)))(at end (shipped o29))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o30
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o30))(at start (made p16))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o30)))(at end (shipped o30))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o31
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o31))(at start (made p2))(at start (made p9))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o31)))(at end (shipped o31))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o32
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o32))(at start (made p16))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o32)))(at end (shipped o32))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

)

