(define (problem grounded-STRIPS-PSR-S2-N1-L2-F50)
(:domain grounded-STRIPS-PSR)
(:init
(do-normal)
(NOT-UPDATED-CB1)
(CLOSED-SD2)
(CLOSED-SD1)
(CLOSED-CB1)
)
(:goal
(and
(do-normal)
(CLOSED-CB1)
(UPDATED-CB1)
)
)
)
