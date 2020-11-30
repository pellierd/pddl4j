(define (problem os-time-p6_1)
(:domain openstacks-time-nonADL-nonNegated)
(:objects 
n0 n1 n2 n3 n4 n5  - count
)

(:init
(next-count n0 n1) (next-count n1 n2) (next-count n2 n3) (next-count n3 n4) (next-count n4 n5) 
(stacks-avail n5)

(waiting o1)
(includes o1 p4)(includes o1 p6)

(waiting o2)
(includes o2 p4)

(waiting o3)
(includes o3 p5)

(waiting o4)
(includes o4 p2)

(waiting o5)
(includes o5 p1)

(waiting o6)
(includes o6 p3)

(not-made p1)
(not-made p2)
(not-made p3)
(not-made p4)
(not-made p5)
(not-made p6)
)

(:goal
(and
(shipped o1)
(shipped o2)
(shipped o3)
(shipped o4)
(shipped o5)
(shipped o6)
))

(:metric minimize (total-time))

)

