(define (domain grounded-STRIPS-PSR)
(:requirements
:strips
)
(:predicates
(NOT-CLOSED-CB1)
(UPDATED-CB1)
(NOT-CLOSED-CB2)
(UPDATED-CB2)
(NOT-CLOSED-CB3)
(UPDATED-CB3)
(CLOSED-SD5)
(CLOSED-SD7)
(CLOSED-SD8)
(CLOSED-SD10)
(NOT-CLOSED-SD1)
(NOT-CLOSED-SD2)
(NOT-CLOSED-SD3)
(NOT-CLOSED-SD4)
(NOT-CLOSED-SD6)
(NOT-CLOSED-SD9)
(NOT-CLOSED-SD11)
(NOT-CLOSED-SD12)
(NOT-CLOSED-SD13)
(NOT-CLOSED-SD14)
(NOT-CLOSED-SD15)
(NOT-CLOSED-SD16)
(NOT-CLOSED-SD17)
(NOT-CLOSED-SD18)
(CLOSED-CB3)
(CLOSED-SD18)
(CLOSED-SD17)
(CLOSED-SD16)
(CLOSED-SD15)
(CLOSED-SD14)
(CLOSED-SD13)
(CLOSED-SD12)
(CLOSED-SD11)
(CLOSED-SD9)
(CLOSED-SD6)
(CLOSED-SD4)
(CLOSED-SD3)
(CLOSED-SD2)
(CLOSED-SD1)
(CLOSED-CB2)
(CLOSED-CB1)
(NOT-CLOSED-SD10)
(NOT-CLOSED-SD8)
(NOT-CLOSED-SD7)
(NOT-CLOSED-SD5)
(NOT-UPDATED-CB3)
(NOT-UPDATED-CB2)
(NOT-UPDATED-CB1)
(do-CLOSE_SD15-condeffs)
(do-CLOSE_SD14-condeffs)
(do-CLOSE_SD13-condeffs)
(do-CLOSE_SD10-condeffs)
(do-WAIT_CB3-condeffs)
(do-normal)
(done-0)
(done-1)
)
(:action CLOSE_SD18
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD18)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD18)
(not (NOT-CLOSED-SD18))
)
)
(:action CLOSE_SD17
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD17)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD17)
(not (NOT-CLOSED-SD17))
)
)
(:action CLOSE_SD16
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD16)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD16)
(not (NOT-CLOSED-SD16))
)
)
(:action CLOSE_SD15
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD15)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD15-condeffs)
(CLOSED-SD15)
(not (NOT-CLOSED-SD15))
)
)
(:action CLOSE_SD15-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD15-condeffs)
(CLOSED-SD14)
(CLOSED-SD13)
(CLOSED-CB3)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB3)
(not (CLOSED-CB3))
)
)
(:action CLOSE_SD15-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD15-condeffs)
(NOT-CLOSED-SD14)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD15-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD15-condeffs)
(NOT-CLOSED-SD13)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD15-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD15-condeffs)
(NOT-CLOSED-CB3)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD15-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD15-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD15-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD14
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD14)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD14-condeffs)
(CLOSED-SD14)
(not (NOT-CLOSED-SD14))
)
)
(:action CLOSE_SD14-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD14-condeffs)
(CLOSED-SD15)
(CLOSED-SD13)
(CLOSED-CB3)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB3)
(not (CLOSED-CB3))
)
)
(:action CLOSE_SD14-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD14-condeffs)
(NOT-CLOSED-SD15)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD14-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD14-condeffs)
(NOT-CLOSED-SD13)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD14-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD14-condeffs)
(NOT-CLOSED-CB3)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD14-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD14-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD14-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD13
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD13)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD13-condeffs)
(CLOSED-SD13)
(not (NOT-CLOSED-SD13))
)
)
(:action CLOSE_SD13-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD13-condeffs)
(CLOSED-SD15)
(CLOSED-SD14)
(CLOSED-CB3)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB3)
(not (CLOSED-CB3))
)
)
(:action CLOSE_SD13-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD13-condeffs)
(NOT-CLOSED-SD15)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD13-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD13-condeffs)
(NOT-CLOSED-SD14)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD13-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD13-condeffs)
(NOT-CLOSED-CB3)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD13-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD13-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD13-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD12
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD12)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD12)
(not (NOT-CLOSED-SD12))
)
)
(:action CLOSE_SD11
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD11)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD11)
(not (NOT-CLOSED-SD11))
)
)
(:action CLOSE_SD9
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD9)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD9)
(not (NOT-CLOSED-SD9))
)
)
(:action CLOSE_SD6
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD6)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD6)
(not (NOT-CLOSED-SD6))
)
)
(:action CLOSE_SD4
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD4)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD4)
(not (NOT-CLOSED-SD4))
)
)
(:action CLOSE_SD3
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD3)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD3)
(not (NOT-CLOSED-SD3))
)
)
(:action CLOSE_SD2
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD2)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD2)
(not (NOT-CLOSED-SD2))
)
)
(:action CLOSE_SD1
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD1)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD1)
(not (NOT-CLOSED-SD1))
)
)
(:action CLOSE_CB3
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-CB3)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-CB3)
(NOT-UPDATED-CB3)
(not (NOT-CLOSED-CB3))
(not (UPDATED-CB3))
)
)
(:action CLOSE_CB2
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-CB2)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-CB2)
(NOT-UPDATED-CB2)
(not (NOT-CLOSED-CB2))
(not (UPDATED-CB2))
)
)
(:action CLOSE_CB1
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-CB1)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-CB1)
(NOT-UPDATED-CB1)
(not (NOT-CLOSED-CB1))
(not (UPDATED-CB1))
)
)
(:action OPEN-SD18
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD18)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD18)
(not (CLOSED-SD18))
)
)
(:action OPEN-SD17
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD17)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD17)
(not (CLOSED-SD17))
)
)
(:action OPEN-SD16
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD16)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD16)
(not (CLOSED-SD16))
)
)
(:action OPEN-SD15
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD15)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD15)
(not (CLOSED-SD15))
)
)
(:action OPEN-SD14
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD14)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD14)
(not (CLOSED-SD14))
)
)
(:action OPEN-SD13
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD13)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD13)
(not (CLOSED-SD13))
)
)
(:action OPEN-SD12
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD12)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD12)
(not (CLOSED-SD12))
)
)
(:action OPEN-SD11
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD11)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD11)
(not (CLOSED-SD11))
)
)
(:action OPEN-SD10
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD10)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD10)
(not (CLOSED-SD10))
)
)
(:action OPEN-SD9
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD9)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD9)
(not (CLOSED-SD9))
)
)
(:action OPEN-SD8
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD8)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD8)
(not (CLOSED-SD8))
)
)
(:action OPEN-SD7
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD7)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD7)
(not (CLOSED-SD7))
)
)
(:action OPEN-SD6
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD6)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
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
(UPDATED-CB2)
(UPDATED-CB3)
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
(UPDATED-CB2)
(UPDATED-CB3)
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
(UPDATED-CB2)
(UPDATED-CB3)
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
(UPDATED-CB2)
(UPDATED-CB3)
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
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-SD1)
(not (CLOSED-SD1))
)
)
(:action OPEN-CB3
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-CB3)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-CB3)
(not (CLOSED-CB3))
)
)
(:action OPEN-CB2
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-CB2)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-CB2)
(not (CLOSED-CB2))
)
)
(:action OPEN-CB1
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-CB1)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action CLOSE_SD10
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD10)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD10-condeffs)
(CLOSED-SD10)
(not (NOT-CLOSED-SD10))
)
)
(:action CLOSE_SD10-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD10-condeffs)
(CLOSED-CB3)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB3)
(not (CLOSED-CB3))
)
)
(:action CLOSE_SD10-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD10-condeffs)
(NOT-CLOSED-CB3)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD10-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD10-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD10-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD8
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD8)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD8)
(not (NOT-CLOSED-SD8))
)
)
(:action CLOSE_SD7
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD7)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD7)
(not (NOT-CLOSED-SD7))
)
)
(:action CLOSE_SD5
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD5)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
)
:effect
(and
(CLOSED-SD5)
(not (NOT-CLOSED-SD5))
)
)
(:action WAIT_CB3
:parameters ()
:precondition
(and
(do-normal)
(NOT-UPDATED-CB3)
)
:effect
(and
(not (do-normal))
(do-WAIT_CB3-condeffs)
(UPDATED-CB3)
(not (NOT-UPDATED-CB3))
)
)
(:action WAIT_CB3-condeff0-yes
:parameters ()
:precondition
(and
(do-WAIT_CB3-condeffs)
(CLOSED-SD10)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB3)
(not (CLOSED-CB3))
)
)
(:action WAIT_CB3-condeff0-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB3-condeffs)
(NOT-CLOSED-SD10)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB3-condeff1-yes
:parameters ()
:precondition
(and
(do-WAIT_CB3-condeffs)
(CLOSED-SD15)
(CLOSED-SD14)
(CLOSED-SD13)
)
:effect
(and
(done-1)
(NOT-CLOSED-CB3)
(not (CLOSED-CB3))
)
)
(:action WAIT_CB3-condeff1-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB3-condeffs)
(NOT-CLOSED-SD15)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB3-condeff1-no-1
:parameters ()
:precondition
(and
(do-WAIT_CB3-condeffs)
(NOT-CLOSED-SD14)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB3-condeff1-no-2
:parameters ()
:precondition
(and
(do-WAIT_CB3-condeffs)
(NOT-CLOSED-SD13)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB3-endof-condeffs
:parameters ()
:precondition
(and
(do-WAIT_CB3-condeffs)
(done-0)
(done-1)
)
:effect
(and
(do-normal)
(not (do-WAIT_CB3-condeffs))
(not (done-0))
(not (done-1))
)
)
(:action WAIT_CB2
:parameters ()
:precondition
(and
(do-normal)
(NOT-UPDATED-CB2)
)
:effect
(and
(NOT-CLOSED-CB2)
(UPDATED-CB2)
(not (CLOSED-CB2))
(not (NOT-UPDATED-CB2))
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
(NOT-CLOSED-CB1)
(UPDATED-CB1)
(not (CLOSED-CB1))
(not (NOT-UPDATED-CB1))
)
)
)
