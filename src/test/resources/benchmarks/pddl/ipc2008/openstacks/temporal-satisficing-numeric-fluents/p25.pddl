(define (problem os-time-p29_1)
(:domain openstacks-time-numeric-nonADL-nonNegated)
(:objects 
)

(:init
(= (stacks-in-use) 0)
(= (max-stacks) 26)

(waiting o1)
(includes o1 p3)

(waiting o2)
(includes o2 p14)

(waiting o3)
(includes o3 p1)(includes o3 p5)

(waiting o4)
(includes o4 p19)(includes o4 p24)(includes o4 p27)

(waiting o5)
(includes o5 p3)(includes o5 p5)(includes o5 p6)(includes o5 p16)

(waiting o6)
(includes o6 p15)

(waiting o7)
(includes o7 p23)

(waiting o8)
(includes o8 p5)(includes o8 p8)

(waiting o9)
(includes o9 p10)

(waiting o10)
(includes o10 p9)

(waiting o11)
(includes o11 p10)(includes o11 p19)(includes o11 p24)

(waiting o12)
(includes o12 p18)(includes o12 p20)

(waiting o13)
(includes o13 p2)(includes o13 p13)(includes o13 p19)

(waiting o14)
(includes o14 p1)(includes o14 p3)(includes o14 p4)(includes o14 p7)

(waiting o15)
(includes o15 p15)

(waiting o16)
(includes o16 p11)(includes o16 p17)(includes o16 p19)

(waiting o17)
(includes o17 p12)(includes o17 p25)

(waiting o18)
(includes o18 p25)

(waiting o19)
(includes o19 p22)

(waiting o20)
(includes o20 p17)(includes o20 p26)

(waiting o21)
(includes o21 p15)

(waiting o22)
(includes o22 p10)

(waiting o23)
(includes o23 p21)

(waiting o24)
(includes o24 p28)

(waiting o25)
(includes o25 p9)(includes o25 p14)(includes o25 p16)

(waiting o26)
(includes o26 p3)

(waiting o27)
(includes o27 p16)(includes o27 p18)(includes o27 p29)

(waiting o28)
(includes o28 p8)

(waiting o29)
(includes o29 p18)(includes o29 p24)

(not-made p1)
(not-made p2)
(not-made p3)
(not-made p4)
(not-made p5)
(not-made p6)
(not-made p7)
(not-made p8)
(not-made p9)
(not-made p10)
(not-made p11)
(not-made p12)
(not-made p13)
(not-made p14)
(not-made p15)
(not-made p16)
(not-made p17)
(not-made p18)
(not-made p19)
(not-made p20)
(not-made p21)
(not-made p22)
(not-made p23)
(not-made p24)
(not-made p25)
(not-made p26)
(not-made p27)
(not-made p28)
(not-made p29)
)

(:goal
(and
(shipped o1)
(shipped o2)
(shipped o3)
(shipped o4)
(shipped o5)
(shipped o6)
(shipped o7)
(shipped o8)
(shipped o9)
(shipped o10)
(shipped o11)
(shipped o12)
(shipped o13)
(shipped o14)
(shipped o15)
(shipped o16)
(shipped o17)
(shipped o18)
(shipped o19)
(shipped o20)
(shipped o21)
(shipped o22)
(shipped o23)
(shipped o24)
(shipped o25)
(shipped o26)
(shipped o27)
(shipped o28)
(shipped o29)
))

(:metric minimize (total-time))

)

