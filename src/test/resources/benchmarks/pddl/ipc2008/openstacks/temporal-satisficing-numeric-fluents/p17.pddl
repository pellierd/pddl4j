(define (problem os-time-p21_1)
(:domain openstacks-time-numeric-nonADL-nonNegated)
(:objects 
)

(:init
(= (stacks-in-use) 0)
(= (max-stacks) 18)

(waiting o1)
(includes o1 p1)(includes o1 p21)

(waiting o2)
(includes o2 p7)

(waiting o3)
(includes o3 p3)

(waiting o4)
(includes o4 p18)

(waiting o5)
(includes o5 p5)(includes o5 p9)(includes o5 p19)

(waiting o6)
(includes o6 p17)

(waiting o7)
(includes o7 p12)(includes o7 p15)

(waiting o8)
(includes o8 p6)(includes o8 p13)

(waiting o9)
(includes o9 p2)(includes o9 p12)(includes o9 p16)

(waiting o10)
(includes o10 p5)(includes o10 p9)

(waiting o11)
(includes o11 p8)(includes o11 p14)

(waiting o12)
(includes o12 p11)(includes o12 p12)

(waiting o13)
(includes o13 p17)

(waiting o14)
(includes o14 p12)

(waiting o15)
(includes o15 p8)(includes o15 p9)

(waiting o16)
(includes o16 p17)(includes o16 p18)(includes o16 p20)

(waiting o17)
(includes o17 p10)

(waiting o18)
(includes o18 p8)

(waiting o19)
(includes o19 p4)(includes o19 p17)

(waiting o20)
(includes o20 p18)

(waiting o21)
(includes o21 p13)

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
))

(:metric minimize (total-time))

)

