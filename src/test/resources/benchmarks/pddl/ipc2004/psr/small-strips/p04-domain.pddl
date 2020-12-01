(define (domain grounded-STRIPS-PSR)
(:requirements
:strips
)
(:predicates
(NOT-CLOSED-CB1)
(UPDATED-CB1)
(CLOSED-SD3)
(NOT-CLOSED-SD1)
(NOT-CLOSED-SD2)
(NOT-CLOSED-SD4)
(NOT-CLOSED-SD5)
(NOT-CLOSED-SD6)
(CLOSED-CB1)
(CLOSED-SD6)
(CLOSED-SD5)
(CLOSED-SD4)
(CLOSED-SD2)
(CLOSED-SD1)
(NOT-CLOSED-SD3)
(NOT-UPDATED-CB1)
(do-CLOSE_SD5-condeffs)
(do-CLOSE_SD4-condeffs)
(do-CLOSE_SD2-condeffs)
(do-CLOSE_SD1-condeffs)
(do-CLOSE_SD3-condeffs)
(do-WAIT_CB1-condeffs)
(do-normal)
(done-0)
(done-1)
)
(:action CLOSE_SD6
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD6)
(UPDATED-CB1)
)
:effect
(and
(CLOSED-SD6)
(not (NOT-CLOSED-SD6))
)
)
(:action CLOSE_SD5
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD5)
(UPDATED-CB1)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD5-condeffs)
(CLOSED-SD5)
(not (NOT-CLOSED-SD5))
)
)
(:action CLOSE_SD5-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD5-condeffs)
(CLOSED-SD4)
(CLOSED-SD2)
(CLOSED-SD1)
(CLOSED-CB1)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action CLOSE_SD5-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD5-condeffs)
(NOT-CLOSED-SD4)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD5-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD5-condeffs)
(NOT-CLOSED-SD2)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD5-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD5-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD5-condeff0-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD5-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD5-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD5-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD5-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD4
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD4)
(UPDATED-CB1)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD4-condeffs)
(CLOSED-SD4)
(not (NOT-CLOSED-SD4))
)
)
(:action CLOSE_SD4-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD4-condeffs)
(CLOSED-SD5)
(CLOSED-SD2)
(CLOSED-SD1)
(CLOSED-CB1)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action CLOSE_SD4-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD4-condeffs)
(NOT-CLOSED-SD5)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD4-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD4-condeffs)
(NOT-CLOSED-SD2)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD4-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD4-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD4-condeff0-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD4-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD4-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD4-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD4-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD2
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD2)
(UPDATED-CB1)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD2-condeffs)
(CLOSED-SD2)
(not (NOT-CLOSED-SD2))
)
)
(:action CLOSE_SD2-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(CLOSED-SD3)
(CLOSED-SD1)
(CLOSED-CB1)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action CLOSE_SD2-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(NOT-CLOSED-SD3)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD2-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD2-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD2-condeff1-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(CLOSED-SD5)
(CLOSED-SD4)
(CLOSED-SD1)
(CLOSED-CB1)
)
:effect
(and
(done-1)
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action CLOSE_SD2-condeff1-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(NOT-CLOSED-SD5)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD2-condeff1-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(NOT-CLOSED-SD4)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD2-condeff1-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD2-condeff1-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD2-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(done-0)
(done-1)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD2-condeffs))
(not (done-0))
(not (done-1))
)
)
(:action CLOSE_SD1
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD1)
(UPDATED-CB1)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD1-condeffs)
(CLOSED-SD1)
(not (NOT-CLOSED-SD1))
)
)
(:action CLOSE_SD1-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD1-condeffs)
(CLOSED-SD3)
(CLOSED-SD2)
(CLOSED-CB1)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action CLOSE_SD1-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD1-condeffs)
(NOT-CLOSED-SD3)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD1-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD1-condeffs)
(NOT-CLOSED-SD2)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD1-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD1-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD1-condeff1-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD1-condeffs)
(CLOSED-SD5)
(CLOSED-SD4)
(CLOSED-SD2)
(CLOSED-CB1)
)
:effect
(and
(done-1)
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action CLOSE_SD1-condeff1-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD1-condeffs)
(NOT-CLOSED-SD5)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD1-condeff1-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD1-condeffs)
(NOT-CLOSED-SD4)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD1-condeff1-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD1-condeffs)
(NOT-CLOSED-SD2)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD1-condeff1-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD1-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD1-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD1-condeffs)
(done-0)
(done-1)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD1-condeffs))
(not (done-0))
(not (done-1))
)
)
(:action CLOSE_CB1
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-CB1)
(UPDATED-CB1)
)
:effect
(and
(CLOSED-CB1)
(NOT-UPDATED-CB1)
(not (NOT-CLOSED-CB1))
(not (UPDATED-CB1))
)
)
(:action OPEN-SD6
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD6)
(UPDATED-CB1)
)
:effect
(and
(NOT-CLOSED-SD6)
(not (CLOSED-SD6))
)
)
(:action OPEN-SD5
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD5)
(UPDATED-CB1)
)
:effect
(and
(NOT-CLOSED-SD5)
(not (CLOSED-SD5))
)
)
(:action OPEN-SD4
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD4)
(UPDATED-CB1)
)
:effect
(and
(NOT-CLOSED-SD4)
(not (CLOSED-SD4))
)
)
(:action OPEN-SD3
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD3)
(UPDATED-CB1)
)
:effect
(and
(NOT-CLOSED-SD3)
(not (CLOSED-SD3))
)
)
(:action OPEN-SD2
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD2)
(UPDATED-CB1)
)
:effect
(and
(NOT-CLOSED-SD2)
(not (CLOSED-SD2))
)
)
(:action OPEN-SD1
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD1)
(UPDATED-CB1)
)
:effect
(and
(NOT-CLOSED-SD1)
(not (CLOSED-SD1))
)
)
(:action OPEN-CB1
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-CB1)
(UPDATED-CB1)
)
:effect
(and
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action CLOSE_SD3
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD3)
(UPDATED-CB1)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD3-condeffs)
(CLOSED-SD3)
(not (NOT-CLOSED-SD3))
)
)
(:action CLOSE_SD3-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD3-condeffs)
(CLOSED-SD2)
(CLOSED-SD1)
(CLOSED-CB1)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action CLOSE_SD3-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD3-condeffs)
(NOT-CLOSED-SD2)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD3-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD3-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD3-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD3-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD3-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD3-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD3-condeffs))
(not (done-0))
)
)
(:action WAIT_CB1
:parameters ()
:precondition
(and
(do-normal)
(NOT-UPDATED-CB1)
)
:effect
(and
(not (do-normal))
(do-WAIT_CB1-condeffs)
(UPDATED-CB1)
(not (NOT-UPDATED-CB1))
)
)
(:action WAIT_CB1-condeff0-yes
:parameters ()
:precondition
(and
(do-WAIT_CB1-condeffs)
(CLOSED-SD3)
(CLOSED-SD2)
(CLOSED-SD1)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action WAIT_CB1-condeff0-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB1-condeffs)
(NOT-CLOSED-SD3)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB1-condeff0-no-1
:parameters ()
:precondition
(and
(do-WAIT_CB1-condeffs)
(NOT-CLOSED-SD2)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB1-condeff0-no-2
:parameters ()
:precondition
(and
(do-WAIT_CB1-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB1-condeff1-yes
:parameters ()
:precondition
(and
(do-WAIT_CB1-condeffs)
(CLOSED-SD5)
(CLOSED-SD4)
(CLOSED-SD2)
(CLOSED-SD1)
)
:effect
(and
(done-1)
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action WAIT_CB1-condeff1-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB1-condeffs)
(NOT-CLOSED-SD5)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB1-condeff1-no-1
:parameters ()
:precondition
(and
(do-WAIT_CB1-condeffs)
(NOT-CLOSED-SD4)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB1-condeff1-no-2
:parameters ()
:precondition
(and
(do-WAIT_CB1-condeffs)
(NOT-CLOSED-SD2)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB1-condeff1-no-3
:parameters ()
:precondition
(and
(do-WAIT_CB1-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB1-endof-condeffs
:parameters ()
:precondition
(and
(do-WAIT_CB1-condeffs)
(done-0)
(done-1)
)
:effect
(and
(do-normal)
(not (do-WAIT_CB1-condeffs))
(not (done-0))
(not (done-1))
)
)
)
