(define (problem os-time-p12_1)
(:domain openstacks-time-numeric-nonADL-nonNegated)
(:objects 
)

(:init
(= (stacks-in-use) 0)
(= (max-stacks) 10)

(waiting o1)
(includes o1 p2)

(waiting o2)
(includes o2 p10)(includes o2 p11)

(waiting o3)
(includes o3 p4)

(waiting o4)
(includes o4 p4)

(waiting o5)
(includes o5 p6)(includes o5 p7)(includes o5 p9)

(waiting o6)
(includes o6 p3)(includes o6 p11)

(waiting o7)
(includes o7 p11)

(waiting o8)
(includes o8 p4)(includes o8 p6)

(waiting o9)
(includes o9 p11)

(waiting o10)
(includes o10 p1)(includes o10 p8)

(waiting o11)
(includes o11 p5)(includes o11 p11)(includes o11 p12)

(waiting o12)
(includes o12 p6)

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
))

(:metric minimize (total-time))

)

