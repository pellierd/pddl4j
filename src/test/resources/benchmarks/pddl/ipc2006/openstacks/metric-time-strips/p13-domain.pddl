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
(started_o21)
(started_o22)
(started_o23)
(started_o24)
(started_o25)
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
(made_p31)
(made_p32)
(made_p33)
(made_p34)
(made_p35)
(made_p36)
(made_p37)
(made_p38)
(made_p39)
(made_p40)
(made_p41)
(made_p42)
(made_p43)
(made_p44)
(made_p45)
(made_p46)
(made_p47)
(made_p48)
(made_p49)
(made_p50)
(made_p51)
(made_p52)
(made_p53)
(made_p54)
(made_p55)
(made_p56)
(made_p57)
(made_p58)
(made_p59)
(made_p60)
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
(not-made_p60)
(not-made_p59)
(not-made_p58)
(not-made_p57)
(not-made_p56)
(not-made_p55)
(not-made_p54)
(not-made_p53)
(not-made_p52)
(not-made_p51)
(not-made_p50)
(not-made_p49)
(not-made_p48)
(not-made_p47)
(not-made_p46)
(not-made_p45)
(not-made_p44)
(not-made_p43)
(not-made_p42)
(not-made_p41)
(not-made_p40)
(not-made_p39)
(not-made_p38)
(not-made_p37)
(not-made_p36)
(not-made_p35)
(not-made_p34)
(not-made_p33)
(not-made_p32)
(not-made_p31)
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
)
(:functions
(STACKS-IN-USE)
(MAX-IN-USE)
)
(:durative-action SHIP-ORDER_O25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o25))
(at start (made_p56))
(at start (made_p46))
(at start (made_p35))
(at start (made_p28))
(at start (made_p27))
(at start (made_p21))
(at start (made_p19))
(at start (made_p9))
)
:effect
(and
(at end (shipped_o25))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o25)))
)
)
(:durative-action SHIP-ORDER_O24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o24))
(at start (made_p49))
(at start (made_p45))
(at start (made_p32))
(at start (made_p31))
(at start (made_p30))
(at start (made_p28))
(at start (made_p26))
(at start (made_p15))
(at start (made_p11))
)
:effect
(and
(at end (shipped_o24))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o24)))
)
)
(:durative-action SHIP-ORDER_O23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o23))
(at start (made_p55))
(at start (made_p46))
(at start (made_p43))
(at start (made_p35))
(at start (made_p29))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p21))
(at start (made_p4))
)
:effect
(and
(at end (shipped_o23))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o23)))
)
)
(:durative-action SHIP-ORDER_O22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o22))
(at start (made_p38))
(at start (made_p33))
(at start (made_p24))
(at start (made_p23))
(at start (made_p12))
(at start (made_p9))
(at start (made_p8))
(at start (made_p4))
)
:effect
(and
(at end (shipped_o22))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o22)))
)
)
(:durative-action SHIP-ORDER_O21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o21))
(at start (made_p58))
(at start (made_p49))
(at start (made_p45))
(at start (made_p42))
(at start (made_p31))
(at start (made_p30))
(at start (made_p26))
(at start (made_p15))
)
:effect
(and
(at end (shipped_o21))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o21)))
)
)
(:durative-action SHIP-ORDER_O20
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (started_o20))
(at start (made_p57))
(at start (made_p52))
(at start (made_p47))
(at start (made_p37))
(at start (made_p36))
(at start (made_p32))
(at start (made_p22))
(at start (made_p6))
(at start (made_p2))
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
(at start (made_p41))
(at start (made_p40))
(at start (made_p37))
(at start (made_p36))
(at start (made_p32))
(at start (made_p17))
(at start (made_p14))
(at start (made_p5))
(at start (made_p3))
(at start (made_p2))
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
(at start (made_p59))
(at start (made_p46))
(at start (made_p45))
(at start (made_p31))
(at start (made_p26))
(at start (made_p19))
(at start (made_p16))
(at start (made_p11))
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
(at start (made_p43))
(at start (made_p33))
(at start (made_p29))
(at start (made_p24))
(at start (made_p23))
(at start (made_p12))
(at start (made_p8))
(at start (made_p4))
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
(at start (made_p59))
(at start (made_p51))
(at start (made_p49))
(at start (made_p46))
(at start (made_p35))
(at start (made_p31))
(at start (made_p25))
(at start (made_p16))
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
(at start (made_p53))
(at start (made_p38))
(at start (made_p33))
(at start (made_p27))
(at start (made_p24))
(at start (made_p23))
(at start (made_p21))
(at start (made_p9))
(at start (made_p4))
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
(at start (made_p60))
(at start (made_p57))
(at start (made_p44))
(at start (made_p41))
(at start (made_p22))
(at start (made_p14))
(at start (made_p13))
(at start (made_p7))
(at start (made_p6))
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
(at start (made_p58))
(at start (made_p54))
(at start (made_p52))
(at start (made_p50))
(at start (made_p47))
(at start (made_p45))
(at start (made_p41))
(at start (made_p39))
(at start (made_p30))
(at start (made_p22))
(at start (made_p18))
(at start (made_p14))
(at start (made_p13))
(at start (made_p11))
(at start (made_p6))
(at start (made_p3))
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
(at start (made_p56))
(at start (made_p34))
(at start (made_p27))
(at start (made_p24))
(at start (made_p9))
(at start (made_p8))
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
(at start (made_p59))
(at start (made_p58))
(at start (made_p45))
(at start (made_p42))
(at start (made_p30))
(at start (made_p18))
(at start (made_p11))
(at start (made_p5))
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
(at start (made_p56))
(at start (made_p53))
(at start (made_p35))
(at start (made_p33))
(at start (made_p29))
(at start (made_p25))
(at start (made_p24))
(at start (made_p21))
(at start (made_p12))
(at start (made_p9))
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
(at start (made_p57))
(at start (made_p54))
(at start (made_p50))
(at start (made_p47))
(at start (made_p42))
(at start (made_p37))
(at start (made_p36))
(at start (made_p18))
(at start (made_p14))
(at start (made_p6))
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
(at start (made_p53))
(at start (made_p49))
(at start (made_p28))
(at start (made_p27))
(at start (made_p26))
(at start (made_p25))
(at start (made_p19))
(at start (made_p16))
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
(at start (made_p54))
(at start (made_p48))
(at start (made_p47))
(at start (made_p41))
(at start (made_p40))
(at start (made_p17))
(at start (made_p7))
(at start (made_p6))
(at start (made_p2))
(at start (made_p1))
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
(at start (made_p42))
(at start (made_p39))
(at start (made_p30))
(at start (made_p18))
(at start (made_p17))
(at start (made_p15))
(at start (made_p5))
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
(at start (made_p46))
(at start (made_p43))
(at start (made_p35))
(at start (made_p27))
(at start (made_p25))
(at start (made_p24))
(at start (made_p21))
(at start (made_p4))
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
(at start (made_p56))
(at start (made_p53))
(at start (made_p29))
(at start (made_p25))
(at start (made_p23))
(at start (made_p21))
(at start (made_p8))
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
(at start (made_p56))
(at start (made_p53))
(at start (made_p46))
(at start (made_p25))
(at start (made_p21))
(at start (made_p19))
(at start (made_p8))
(at start (made_p4))
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
(at start (made_p59))
(at start (made_p49))
(at start (made_p46))
(at start (made_p28))
(at start (made_p26))
(at start (made_p21))
(at start (made_p20))
(at start (made_p11))
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
(at start (made_p56))
(at start (made_p53))
(at start (made_p51))
(at start (made_p46))
(at start (made_p21))
(at start (made_p19))
(at start (made_p16))
(at start (made_p4))
)
:effect
(and
(at end (shipped_o1))
(at end (DECREASE (STACKS-IN-USE) 1.000000))
(at start (not (started_o1)))
)
)
(:durative-action MAKE-PRODUCT_P60
:parameters ()
:duration (= ?duration 175.000000)
:condition
(and
(at start (not-made_p60))
(at start (started_o14))
)
:effect
(and
(at end (made_p60))
(at end (not (not-made_p60)))
)
)
(:durative-action MAKE-PRODUCT_P59
:parameters ()
:duration (= ?duration 200.000000)
:condition
(and
(at start (not-made_p59))
(at start (started_o18))
(at start (started_o16))
(at start (started_o11))
(at start (started_o2))
)
:effect
(and
(at end (made_p59))
(at end (not (not-made_p59)))
)
)
(:durative-action MAKE-PRODUCT_P58
:parameters ()
:duration (= ?duration 225.000000)
:condition
(and
(at start (not-made_p58))
(at start (started_o21))
(at start (started_o13))
(at start (started_o11))
)
:effect
(and
(at end (made_p58))
(at end (not (not-made_p58)))
)
)
(:durative-action MAKE-PRODUCT_P57
:parameters ()
:duration (= ?duration 25.000000)
:condition
(and
(at start (not-made_p57))
(at start (started_o20))
(at start (started_o14))
(at start (started_o9))
)
:effect
(and
(at end (made_p57))
(at end (not (not-made_p57)))
)
)
(:durative-action MAKE-PRODUCT_P56
:parameters ()
:duration (= ?duration 25.000000)
:condition
(and
(at start (not-made_p56))
(at start (started_o25))
(at start (started_o12))
(at start (started_o10))
(at start (started_o4))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p56))
(at end (not (not-made_p56)))
)
)
(:durative-action MAKE-PRODUCT_P55
:parameters ()
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p55))
(at start (started_o23))
)
:effect
(and
(at end (made_p55))
(at end (not (not-made_p55)))
)
)
(:durative-action MAKE-PRODUCT_P54
:parameters ()
:duration (= ?duration 225.000000)
:condition
(and
(at start (not-made_p54))
(at start (started_o13))
(at start (started_o9))
(at start (started_o7))
)
:effect
(and
(at end (made_p54))
(at end (not (not-made_p54)))
)
)
(:durative-action MAKE-PRODUCT_P53
:parameters ()
:duration (= ?duration 200.000000)
:condition
(and
(at start (not-made_p53))
(at start (started_o15))
(at start (started_o10))
(at start (started_o8))
(at start (started_o4))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p53))
(at end (not (not-made_p53)))
)
)
(:durative-action MAKE-PRODUCT_P52
:parameters ()
:duration (= ?duration 175.000000)
:condition
(and
(at start (not-made_p52))
(at start (started_o20))
(at start (started_o13))
)
:effect
(and
(at end (made_p52))
(at end (not (not-made_p52)))
)
)
(:durative-action MAKE-PRODUCT_P51
:parameters ()
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p51))
(at start (started_o16))
(at start (started_o1))
)
:effect
(and
(at end (made_p51))
(at end (not (not-made_p51)))
)
)
(:durative-action MAKE-PRODUCT_P50
:parameters ()
:duration (= ?duration 50.000000)
:condition
(and
(at start (not-made_p50))
(at start (started_o13))
(at start (started_o9))
)
:effect
(and
(at end (made_p50))
(at end (not (not-made_p50)))
)
)
(:durative-action MAKE-PRODUCT_P49
:parameters ()
:duration (= ?duration 175.000000)
:condition
(and
(at start (not-made_p49))
(at start (started_o24))
(at start (started_o21))
(at start (started_o16))
(at start (started_o8))
(at start (started_o2))
)
:effect
(and
(at end (made_p49))
(at end (not (not-made_p49)))
)
)
(:durative-action MAKE-PRODUCT_P48
:parameters ()
:duration (= ?duration 150.000000)
:condition
(and
(at start (not-made_p48))
(at start (started_o7))
)
:effect
(and
(at end (made_p48))
(at end (not (not-made_p48)))
)
)
(:durative-action MAKE-PRODUCT_P47
:parameters ()
:duration (= ?duration 250.000000)
:condition
(and
(at start (not-made_p47))
(at start (started_o20))
(at start (started_o13))
(at start (started_o9))
(at start (started_o7))
)
:effect
(and
(at end (made_p47))
(at end (not (not-made_p47)))
)
)
(:durative-action MAKE-PRODUCT_P46
:parameters ()
:duration (= ?duration 225.000000)
:condition
(and
(at start (not-made_p46))
(at start (started_o25))
(at start (started_o23))
(at start (started_o18))
(at start (started_o16))
(at start (started_o5))
(at start (started_o3))
(at start (started_o2))
(at start (started_o1))
)
:effect
(and
(at end (made_p46))
(at end (not (not-made_p46)))
)
)
(:durative-action MAKE-PRODUCT_P45
:parameters ()
:duration (= ?duration 50.000000)
:condition
(and
(at start (not-made_p45))
(at start (started_o24))
(at start (started_o21))
(at start (started_o18))
(at start (started_o13))
(at start (started_o11))
)
:effect
(and
(at end (made_p45))
(at end (not (not-made_p45)))
)
)
(:durative-action MAKE-PRODUCT_P44
:parameters ()
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p44))
(at start (started_o14))
)
:effect
(and
(at end (made_p44))
(at end (not (not-made_p44)))
)
)
(:durative-action MAKE-PRODUCT_P43
:parameters ()
:duration (= ?duration 175.000000)
:condition
(and
(at start (not-made_p43))
(at start (started_o23))
(at start (started_o17))
(at start (started_o5))
)
:effect
(and
(at end (made_p43))
(at end (not (not-made_p43)))
)
)
(:durative-action MAKE-PRODUCT_P42
:parameters ()
:duration (= ?duration 75.000000)
:condition
(and
(at start (not-made_p42))
(at start (started_o21))
(at start (started_o11))
(at start (started_o9))
(at start (started_o6))
)
:effect
(and
(at end (made_p42))
(at end (not (not-made_p42)))
)
)
(:durative-action MAKE-PRODUCT_P41
:parameters ()
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p41))
(at start (started_o19))
(at start (started_o14))
(at start (started_o13))
(at start (started_o7))
)
:effect
(and
(at end (made_p41))
(at end (not (not-made_p41)))
)
)
(:durative-action MAKE-PRODUCT_P40
:parameters ()
:duration (= ?duration 175.000000)
:condition
(and
(at start (not-made_p40))
(at start (started_o19))
(at start (started_o7))
)
:effect
(and
(at end (made_p40))
(at end (not (not-made_p40)))
)
)
(:durative-action MAKE-PRODUCT_P39
:parameters ()
:duration (= ?duration 175.000000)
:condition
(and
(at start (not-made_p39))
(at start (started_o13))
(at start (started_o6))
)
:effect
(and
(at end (made_p39))
(at end (not (not-made_p39)))
)
)
(:durative-action MAKE-PRODUCT_P38
:parameters ()
:duration (= ?duration 250.000000)
:condition
(and
(at start (not-made_p38))
(at start (started_o22))
(at start (started_o15))
)
:effect
(and
(at end (made_p38))
(at end (not (not-made_p38)))
)
)
(:durative-action MAKE-PRODUCT_P37
:parameters ()
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p37))
(at start (started_o20))
(at start (started_o19))
(at start (started_o9))
)
:effect
(and
(at end (made_p37))
(at end (not (not-made_p37)))
)
)
(:durative-action MAKE-PRODUCT_P36
:parameters ()
:duration (= ?duration 125.000000)
:condition
(and
(at start (not-made_p36))
(at start (started_o20))
(at start (started_o19))
(at start (started_o9))
)
:effect
(and
(at end (made_p36))
(at end (not (not-made_p36)))
)
)
(:durative-action MAKE-PRODUCT_P35
:parameters ()
:duration (= ?duration 125.000000)
:condition
(and
(at start (not-made_p35))
(at start (started_o25))
(at start (started_o23))
(at start (started_o16))
(at start (started_o10))
(at start (started_o5))
)
:effect
(and
(at end (made_p35))
(at end (not (not-made_p35)))
)
)
(:durative-action MAKE-PRODUCT_P34
:parameters ()
:duration (= ?duration 75.000000)
:condition
(and
(at start (not-made_p34))
(at start (started_o12))
)
:effect
(and
(at end (made_p34))
(at end (not (not-made_p34)))
)
)
(:durative-action MAKE-PRODUCT_P33
:parameters ()
:duration (= ?duration 50.000000)
:condition
(and
(at start (not-made_p33))
(at start (started_o22))
(at start (started_o17))
(at start (started_o15))
(at start (started_o10))
)
:effect
(and
(at end (made_p33))
(at end (not (not-made_p33)))
)
)
(:durative-action MAKE-PRODUCT_P32
:parameters ()
:duration (= ?duration 75.000000)
:condition
(and
(at start (not-made_p32))
(at start (started_o24))
(at start (started_o20))
(at start (started_o19))
)
:effect
(and
(at end (made_p32))
(at end (not (not-made_p32)))
)
)
(:durative-action MAKE-PRODUCT_P31
:parameters ()
:duration (= ?duration 250.000000)
:condition
(and
(at start (not-made_p31))
(at start (started_o24))
(at start (started_o21))
(at start (started_o18))
(at start (started_o16))
)
:effect
(and
(at end (made_p31))
(at end (not (not-made_p31)))
)
)
(:durative-action MAKE-PRODUCT_P30
:parameters ()
:duration (= ?duration 200.000000)
:condition
(and
(at start (not-made_p30))
(at start (started_o24))
(at start (started_o21))
(at start (started_o13))
(at start (started_o11))
(at start (started_o6))
)
:effect
(and
(at end (made_p30))
(at end (not (not-made_p30)))
)
)
(:durative-action MAKE-PRODUCT_P29
:parameters ()
:duration (= ?duration 175.000000)
:condition
(and
(at start (not-made_p29))
(at start (started_o23))
(at start (started_o17))
(at start (started_o10))
(at start (started_o4))
)
:effect
(and
(at end (made_p29))
(at end (not (not-made_p29)))
)
)
(:durative-action MAKE-PRODUCT_P28
:parameters ()
:duration (= ?duration 250.000000)
:condition
(and
(at start (not-made_p28))
(at start (started_o25))
(at start (started_o24))
(at start (started_o8))
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
:duration (= ?duration 225.000000)
:condition
(and
(at start (not-made_p27))
(at start (started_o25))
(at start (started_o23))
(at start (started_o15))
(at start (started_o12))
(at start (started_o8))
(at start (started_o5))
)
:effect
(and
(at end (made_p27))
(at end (not (not-made_p27)))
)
)
(:durative-action MAKE-PRODUCT_P26
:parameters ()
:duration (= ?duration 150.000000)
:condition
(and
(at start (not-made_p26))
(at start (started_o24))
(at start (started_o21))
(at start (started_o18))
(at start (started_o8))
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
:duration (= ?duration 250.000000)
:condition
(and
(at start (not-made_p25))
(at start (started_o23))
(at start (started_o16))
(at start (started_o10))
(at start (started_o8))
(at start (started_o5))
(at start (started_o4))
(at start (started_o3))
)
:effect
(and
(at end (made_p25))
(at end (not (not-made_p25)))
)
)
(:durative-action MAKE-PRODUCT_P24
:parameters ()
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p24))
(at start (started_o23))
(at start (started_o22))
(at start (started_o17))
(at start (started_o15))
(at start (started_o12))
(at start (started_o10))
(at start (started_o5))
)
:effect
(and
(at end (made_p24))
(at end (not (not-made_p24)))
)
)
(:durative-action MAKE-PRODUCT_P23
:parameters ()
:duration (= ?duration 200.000000)
:condition
(and
(at start (not-made_p23))
(at start (started_o22))
(at start (started_o17))
(at start (started_o15))
(at start (started_o4))
)
:effect
(and
(at end (made_p23))
(at end (not (not-made_p23)))
)
)
(:durative-action MAKE-PRODUCT_P22
:parameters ()
:duration (= ?duration 175.000000)
:condition
(and
(at start (not-made_p22))
(at start (started_o20))
(at start (started_o14))
(at start (started_o13))
)
:effect
(and
(at end (made_p22))
(at end (not (not-made_p22)))
)
)
(:durative-action MAKE-PRODUCT_P21
:parameters ()
:duration (= ?duration 250.000000)
:condition
(and
(at start (not-made_p21))
(at start (started_o25))
(at start (started_o23))
(at start (started_o15))
(at start (started_o10))
(at start (started_o5))
(at start (started_o4))
(at start (started_o3))
(at start (started_o2))
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
:duration (= ?duration 25.000000)
:condition
(and
(at start (not-made_p20))
(at start (started_o2))
)
:effect
(and
(at end (made_p20))
(at end (not (not-made_p20)))
)
)
(:durative-action MAKE-PRODUCT_P19
:parameters ()
:duration (= ?duration 175.000000)
:condition
(and
(at start (not-made_p19))
(at start (started_o25))
(at start (started_o18))
(at start (started_o8))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p19))
(at end (not (not-made_p19)))
)
)
(:durative-action MAKE-PRODUCT_P18
:parameters ()
:duration (= ?duration 75.000000)
:condition
(and
(at start (not-made_p18))
(at start (started_o13))
(at start (started_o11))
(at start (started_o9))
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
:duration (= ?duration 50.000000)
:condition
(and
(at start (not-made_p17))
(at start (started_o19))
(at start (started_o7))
(at start (started_o6))
)
:effect
(and
(at end (made_p17))
(at end (not (not-made_p17)))
)
)
(:durative-action MAKE-PRODUCT_P16
:parameters ()
:duration (= ?duration 50.000000)
:condition
(and
(at start (not-made_p16))
(at start (started_o18))
(at start (started_o16))
(at start (started_o8))
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
:duration (= ?duration 200.000000)
:condition
(and
(at start (not-made_p15))
(at start (started_o24))
(at start (started_o21))
(at start (started_o6))
)
:effect
(and
(at end (made_p15))
(at end (not (not-made_p15)))
)
)
(:durative-action MAKE-PRODUCT_P14
:parameters ()
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p14))
(at start (started_o19))
(at start (started_o14))
(at start (started_o13))
(at start (started_o9))
)
:effect
(and
(at end (made_p14))
(at end (not (not-made_p14)))
)
)
(:durative-action MAKE-PRODUCT_P13
:parameters ()
:duration (= ?duration 225.000000)
:condition
(and
(at start (not-made_p13))
(at start (started_o14))
(at start (started_o13))
)
:effect
(and
(at end (made_p13))
(at end (not (not-made_p13)))
)
)
(:durative-action MAKE-PRODUCT_P12
:parameters ()
:duration (= ?duration 125.000000)
:condition
(and
(at start (not-made_p12))
(at start (started_o22))
(at start (started_o17))
(at start (started_o10))
)
:effect
(and
(at end (made_p12))
(at end (not (not-made_p12)))
)
)
(:durative-action MAKE-PRODUCT_P11
:parameters ()
:duration (= ?duration 225.000000)
:condition
(and
(at start (not-made_p11))
(at start (started_o24))
(at start (started_o18))
(at start (started_o13))
(at start (started_o11))
(at start (started_o2))
)
:effect
(and
(at end (made_p11))
(at end (not (not-made_p11)))
)
)
(:durative-action MAKE-PRODUCT_P10
:parameters ()
:duration (= ?duration 175.000000)
:condition
(and
(at start (not-made_p10))
)
:effect
(and
(at end (made_p10))
(at end (not (not-made_p10)))
)
)
(:durative-action MAKE-PRODUCT_P9
:parameters ()
:duration (= ?duration 75.000000)
:condition
(and
(at start (not-made_p9))
(at start (started_o25))
(at start (started_o22))
(at start (started_o15))
(at start (started_o12))
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
:duration (= ?duration 50.000000)
:condition
(and
(at start (not-made_p8))
(at start (started_o22))
(at start (started_o17))
(at start (started_o12))
(at start (started_o4))
(at start (started_o3))
)
:effect
(and
(at end (made_p8))
(at end (not (not-made_p8)))
)
)
(:durative-action MAKE-PRODUCT_P7
:parameters ()
:duration (= ?duration 200.000000)
:condition
(and
(at start (not-made_p7))
(at start (started_o14))
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
:duration (= ?duration 250.000000)
:condition
(and
(at start (not-made_p6))
(at start (started_o20))
(at start (started_o14))
(at start (started_o13))
(at start (started_o9))
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
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p5))
(at start (started_o19))
(at start (started_o11))
(at start (started_o6))
)
:effect
(and
(at end (made_p5))
(at end (not (not-made_p5)))
)
)
(:durative-action MAKE-PRODUCT_P4
:parameters ()
:duration (= ?duration 225.000000)
:condition
(and
(at start (not-made_p4))
(at start (started_o23))
(at start (started_o22))
(at start (started_o17))
(at start (started_o15))
(at start (started_o5))
(at start (started_o4))
(at start (started_o3))
(at start (started_o1))
)
:effect
(and
(at end (made_p4))
(at end (not (not-made_p4)))
)
)
(:durative-action MAKE-PRODUCT_P3
:parameters ()
:duration (= ?duration 100.000000)
:condition
(and
(at start (not-made_p3))
(at start (started_o19))
(at start (started_o13))
(at start (started_o9))
)
:effect
(and
(at end (made_p3))
(at end (not (not-made_p3)))
)
)
(:durative-action MAKE-PRODUCT_P2
:parameters ()
:duration (= ?duration 225.000000)
:condition
(and
(at start (not-made_p2))
(at start (started_o20))
(at start (started_o19))
(at start (started_o14))
(at start (started_o7))
)
:effect
(and
(at end (made_p2))
(at end (not (not-made_p2)))
)
)
(:durative-action MAKE-PRODUCT_P1
:parameters ()
:duration (= ?duration 25.000000)
:condition
(and
(at start (not-made_p1))
(at start (started_o20))
(at start (started_o19))
(at start (started_o7))
)
:effect
(and
(at end (made_p1))
(at end (not (not-made_p1)))
)
)
(:durative-action START-ORDER-2_O25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o25))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o25))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o25)))
)
)
(:durative-action START-ORDER-2_O24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o24))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o24))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o24)))
)
)
(:durative-action START-ORDER-2_O23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o23))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o23))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o23)))
)
)
(:durative-action START-ORDER-2_O22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o22))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o22))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o22)))
)
)
(:durative-action START-ORDER-2_O21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o21))
(at start (>= (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o21))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (INCREASE (MAX-IN-USE) 1.000000))
(at start (not (waiting_o21)))
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
(:durative-action START-ORDER-1_O25
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o25))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o25))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o25)))
)
)
(:durative-action START-ORDER-1_O24
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o24))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o24))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o24)))
)
)
(:durative-action START-ORDER-1_O23
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o23))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o23))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o23)))
)
)
(:durative-action START-ORDER-1_O22
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o22))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o22))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o22)))
)
)
(:durative-action START-ORDER-1_O21
:parameters ()
:duration (= ?duration 1.000000)
:condition
(and
(at start (waiting_o21))
(at start (< (STACKS-IN-USE) (MAX-IN-USE)))
)
:effect
(and
(at end (started_o21))
(at start (INCREASE (STACKS-IN-USE) 1.000000))
(at start (not (waiting_o21)))
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
