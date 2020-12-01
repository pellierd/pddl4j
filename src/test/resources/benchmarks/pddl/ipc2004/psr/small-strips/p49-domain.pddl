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
(NOT-CLOSED-CB5)
(UPDATED-CB5)
(NOT-CLOSED-CB6)
(UPDATED-CB6)
(NOT-CLOSED-CB4)
(CLOSED-SD6)
(CLOSED-SD9)
(CLOSED-SD11)
(CLOSED-SD14)
(CLOSED-SD19)
(NOT-CLOSED-SD1)
(NOT-CLOSED-SD2)
(NOT-CLOSED-SD3)
(NOT-CLOSED-SD4)
(NOT-CLOSED-SD5)
(NOT-CLOSED-SD7)
(NOT-CLOSED-SD8)
(NOT-CLOSED-SD10)
(NOT-CLOSED-SD12)
(NOT-CLOSED-SD13)
(NOT-CLOSED-SD15)
(NOT-CLOSED-SD16)
(NOT-CLOSED-SD17)
(NOT-CLOSED-SD18)
(NOT-CLOSED-SD20)
(NOT-CLOSED-SD21)
(NOT-CLOSED-SD22)
(NOT-UPDATED-CB4)
(CLOSED-CB4)
(CLOSED-CB5)
(CLOSED-CB1)
(CLOSED-CB3)
(CLOSED-CB2)
(UPDATED-CB4)
(CLOSED-SD22)
(CLOSED-SD21)
(CLOSED-SD20)
(CLOSED-SD18)
(CLOSED-SD17)
(CLOSED-SD16)
(CLOSED-SD15)
(CLOSED-SD13)
(CLOSED-SD12)
(CLOSED-SD10)
(CLOSED-SD8)
(CLOSED-SD7)
(CLOSED-SD5)
(CLOSED-SD4)
(CLOSED-SD3)
(CLOSED-SD2)
(CLOSED-SD1)
(CLOSED-CB6)
(NOT-CLOSED-SD19)
(NOT-CLOSED-SD14)
(NOT-CLOSED-SD11)
(NOT-CLOSED-SD9)
(NOT-CLOSED-SD6)
(NOT-UPDATED-CB6)
(NOT-UPDATED-CB5)
(NOT-UPDATED-CB3)
(NOT-UPDATED-CB2)
(NOT-UPDATED-CB1)
(do-CLOSE_SD22-condeffs)
(do-CLOSE_SD20-condeffs)
(do-CLOSE_SD18-condeffs)
(do-CLOSE_SD17-condeffs)
(do-CLOSE_SD16-condeffs)
(do-CLOSE_SD15-condeffs)
(do-CLOSE_SD12-condeffs)
(do-CLOSE_SD10-condeffs)
(do-CLOSE_SD8-condeffs)
(do-CLOSE_SD7-condeffs)
(do-CLOSE_SD4-condeffs)
(do-CLOSE_SD3-condeffs)
(do-CLOSE_SD2-condeffs)
(do-CLOSE_SD1-condeffs)
(do-WAIT_CB4-condeffs)
(do-CLOSE_SD19-condeffs)
(do-CLOSE_SD11-condeffs)
(do-CLOSE_SD9-condeffs)
(do-CLOSE_SD6-condeffs)
(do-WAIT_CB5-condeffs)
(do-WAIT_CB3-condeffs)
(do-WAIT_CB2-condeffs)
(do-WAIT_CB1-condeffs)
(do-normal)
(done-0)
(done-1)
(done-2)
)
(:action CLOSE_SD22
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD22)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD22-condeffs)
(CLOSED-SD22)
(not (NOT-CLOSED-SD22))
)
)
(:action CLOSE_SD22-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD22-condeffs)
(CLOSED-SD19)
(CLOSED-SD18)
(CLOSED-SD17)
(CLOSED-CB4)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD22-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD22-condeffs)
(NOT-CLOSED-SD19)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD22-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD22-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD22-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD22-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD22-condeff0-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD22-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD22-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD22-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD22-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD21
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD21)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD21)
(not (NOT-CLOSED-SD21))
)
)
(:action CLOSE_SD20
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD20)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD20-condeffs)
(CLOSED-SD20)
(not (NOT-CLOSED-SD20))
)
)
(:action CLOSE_SD20-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD20-condeffs)
(CLOSED-CB5)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB5)
(not (CLOSED-CB5))
)
)
(:action CLOSE_SD20-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD20-condeffs)
(NOT-CLOSED-CB5)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD20-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD20-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD20-condeffs))
(not (done-0))
)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD18-condeffs)
(CLOSED-SD18)
(not (NOT-CLOSED-SD18))
)
)
(:action CLOSE_SD18-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(CLOSED-SD11)
(CLOSED-SD17)
(CLOSED-CB4)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD18-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-SD11)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD18-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD18-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD18-condeff1-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(CLOSED-SD6)
(CLOSED-SD19)
(CLOSED-SD17)
(CLOSED-CB4)
)
:effect
(and
(done-1)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD18-condeff1-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-SD6)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD18-condeff1-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-SD19)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD18-condeff1-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD18-condeff1-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD18-condeff2-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(CLOSED-SD22)
(CLOSED-SD19)
(CLOSED-SD17)
(CLOSED-CB4)
)
:effect
(and
(done-2)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD18-condeff2-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-SD22)
)
:effect
(and
(done-2)
)
)
(:action CLOSE_SD18-condeff2-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-SD19)
)
:effect
(and
(done-2)
)
)
(:action CLOSE_SD18-condeff2-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-2)
)
)
(:action CLOSE_SD18-condeff2-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-2)
)
)
(:action CLOSE_SD18-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD18-condeffs)
(done-0)
(done-1)
(done-2)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD18-condeffs))
(not (done-0))
(not (done-1))
(not (done-2))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD17-condeffs)
(CLOSED-SD17)
(not (NOT-CLOSED-SD17))
)
)
(:action CLOSE_SD17-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(CLOSED-SD11)
(CLOSED-SD18)
(CLOSED-CB4)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD17-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-SD11)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD17-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD17-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD17-condeff1-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(CLOSED-SD6)
(CLOSED-SD19)
(CLOSED-SD18)
(CLOSED-CB4)
)
:effect
(and
(done-1)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD17-condeff1-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-SD6)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD17-condeff1-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-SD19)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD17-condeff1-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD17-condeff1-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD17-condeff2-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(CLOSED-SD22)
(CLOSED-SD19)
(CLOSED-SD18)
(CLOSED-CB4)
)
:effect
(and
(done-2)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD17-condeff2-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-SD22)
)
:effect
(and
(done-2)
)
)
(:action CLOSE_SD17-condeff2-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-SD19)
)
:effect
(and
(done-2)
)
)
(:action CLOSE_SD17-condeff2-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-2)
)
)
(:action CLOSE_SD17-condeff2-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-2)
)
)
(:action CLOSE_SD17-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD17-condeffs)
(done-0)
(done-1)
(done-2)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD17-condeffs))
(not (done-0))
(not (done-1))
(not (done-2))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD16-condeffs)
(CLOSED-SD16)
(not (NOT-CLOSED-SD16))
)
)
(:action CLOSE_SD16-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD16-condeffs)
(CLOSED-SD9)
(CLOSED-SD8)
(CLOSED-SD7)
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
(:action CLOSE_SD16-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD16-condeffs)
(NOT-CLOSED-SD9)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD16-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD16-condeffs)
(NOT-CLOSED-SD8)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD16-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD16-condeffs)
(NOT-CLOSED-SD7)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD16-condeff0-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD16-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD16-condeff0-no-4
:parameters ()
:precondition
(and
(do-CLOSE_SD16-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD16-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD16-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD16-condeffs))
(not (done-0))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(:action CLOSE_SD13
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD13)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD13)
(not (NOT-CLOSED-SD13))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD12-condeffs)
(CLOSED-SD12)
(not (NOT-CLOSED-SD12))
)
)
(:action CLOSE_SD12-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD12-condeffs)
(CLOSED-CB2)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB2)
(not (CLOSED-CB2))
)
)
(:action CLOSE_SD12-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD12-condeffs)
(NOT-CLOSED-CB2)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD12-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD12-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD12-condeffs))
(not (done-0))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(CLOSED-CB2)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB2)
(not (CLOSED-CB2))
)
)
(:action CLOSE_SD10-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD10-condeffs)
(NOT-CLOSED-CB2)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD8-condeffs)
(CLOSED-SD8)
(not (NOT-CLOSED-SD8))
)
)
(:action CLOSE_SD8-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD8-condeffs)
(CLOSED-SD16)
(CLOSED-SD9)
(CLOSED-SD7)
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
(:action CLOSE_SD8-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD8-condeffs)
(NOT-CLOSED-SD16)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD8-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD8-condeffs)
(NOT-CLOSED-SD9)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD8-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD8-condeffs)
(NOT-CLOSED-SD7)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD8-condeff0-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD8-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD8-condeff0-no-4
:parameters ()
:precondition
(and
(do-CLOSE_SD8-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD8-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD8-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD8-condeffs))
(not (done-0))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD7-condeffs)
(CLOSED-SD7)
(not (NOT-CLOSED-SD7))
)
)
(:action CLOSE_SD7-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD7-condeffs)
(CLOSED-SD16)
(CLOSED-SD9)
(CLOSED-SD8)
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
(:action CLOSE_SD7-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD7-condeffs)
(NOT-CLOSED-SD16)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD7-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD7-condeffs)
(NOT-CLOSED-SD9)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD7-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD7-condeffs)
(NOT-CLOSED-SD8)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD7-condeff0-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD7-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD7-condeff0-no-4
:parameters ()
:precondition
(and
(do-CLOSE_SD7-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD7-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD7-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD7-condeffs))
(not (done-0))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD5)
(not (NOT-CLOSED-SD5))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(CLOSED-SD3)
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
(NOT-CLOSED-SD3)
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
(:action CLOSE_SD3
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD3)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(:action CLOSE_SD3-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD3-condeffs)
(NOT-CLOSED-SD4)
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
(NOT-CLOSED-SD2)
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
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD3-condeff0-no-3
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
(:action CLOSE_SD2
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD2)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(CLOSED-SD4)
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
(NOT-CLOSED-SD4)
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
(NOT-CLOSED-SD3)
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
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD2-condeff0-no-3
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
(:action CLOSE_SD2-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD2-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD2-condeffs))
(not (done-0))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(CLOSED-SD4)
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
(NOT-CLOSED-SD4)
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
(NOT-CLOSED-SD3)
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
(NOT-CLOSED-SD2)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD1-condeff0-no-3
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
(CLOSED-SD16)
(CLOSED-SD9)
(CLOSED-SD8)
(CLOSED-SD7)
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
(NOT-CLOSED-SD16)
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
(NOT-CLOSED-SD9)
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
(NOT-CLOSED-SD8)
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
(NOT-CLOSED-SD7)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD1-condeff1-no-4
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
(:action CLOSE_CB6
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-CB6)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-CB6)
(NOT-UPDATED-CB6)
(not (NOT-CLOSED-CB6))
(not (UPDATED-CB6))
)
)
(:action CLOSE_CB5
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-CB5)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-CB5)
(NOT-UPDATED-CB5)
(not (NOT-CLOSED-CB5))
(not (UPDATED-CB5))
)
)
(:action WAIT_CB4
:parameters ()
:precondition
(and
(do-normal)
(NOT-UPDATED-CB4)
)
:effect
(and
(not (do-normal))
(do-WAIT_CB4-condeffs)
(UPDATED-CB4)
(not (NOT-UPDATED-CB4))
)
)
(:action WAIT_CB4-condeff0-yes
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(CLOSED-SD11)
(CLOSED-SD18)
(CLOSED-SD17)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action WAIT_CB4-condeff0-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD11)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB4-condeff0-no-1
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB4-condeff0-no-2
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB4-condeff1-yes
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(CLOSED-SD6)
(CLOSED-SD19)
(CLOSED-SD18)
(CLOSED-SD17)
)
:effect
(and
(done-1)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action WAIT_CB4-condeff1-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD6)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB4-condeff1-no-1
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD19)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB4-condeff1-no-2
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB4-condeff1-no-3
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB4-condeff2-yes
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(CLOSED-SD22)
(CLOSED-SD19)
(CLOSED-SD18)
(CLOSED-SD17)
)
:effect
(and
(done-2)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action WAIT_CB4-condeff2-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD22)
)
:effect
(and
(done-2)
)
)
(:action WAIT_CB4-condeff2-no-1
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD19)
)
:effect
(and
(done-2)
)
)
(:action WAIT_CB4-condeff2-no-2
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-2)
)
)
(:action WAIT_CB4-condeff2-no-3
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-2)
)
)
(:action WAIT_CB4-endof-condeffs
:parameters ()
:precondition
(and
(do-WAIT_CB4-condeffs)
(done-0)
(done-1)
(done-2)
)
:effect
(and
(do-normal)
(not (do-WAIT_CB4-condeffs))
(not (done-0))
(not (done-1))
(not (done-2))
)
)
(:action CLOSE_CB4
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-CB4)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-CB4)
(NOT-UPDATED-CB4)
(not (NOT-CLOSED-CB4))
(not (UPDATED-CB4))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-CB1)
(NOT-UPDATED-CB1)
(not (NOT-CLOSED-CB1))
(not (UPDATED-CB1))
)
)
(:action OPEN-SD22
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD22)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD22)
(not (CLOSED-SD22))
)
)
(:action OPEN-SD21
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD21)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD21)
(not (CLOSED-SD21))
)
)
(:action OPEN-SD20
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD20)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD20)
(not (CLOSED-SD20))
)
)
(:action OPEN-SD19
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD19)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD19)
(not (CLOSED-SD19))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD1)
(not (CLOSED-SD1))
)
)
(:action OPEN-CB6
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-CB6)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-CB6)
(not (CLOSED-CB6))
)
)
(:action OPEN-CB5
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-CB5)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-CB5)
(not (CLOSED-CB5))
)
)
(:action OPEN-CB4
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-CB4)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-CB1)
(not (CLOSED-CB1))
)
)
(:action CLOSE_SD19
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD19)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD19-condeffs)
(CLOSED-SD19)
(not (NOT-CLOSED-SD19))
)
)
(:action CLOSE_SD19-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(CLOSED-SD6)
(CLOSED-SD18)
(CLOSED-SD17)
(CLOSED-CB4)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD19-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(NOT-CLOSED-SD6)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD19-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD19-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD19-condeff0-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD19-condeff1-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(CLOSED-SD22)
(CLOSED-SD18)
(CLOSED-SD17)
(CLOSED-CB4)
)
:effect
(and
(done-1)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD19-condeff1-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(NOT-CLOSED-SD22)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD19-condeff1-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD19-condeff1-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD19-condeff1-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-1)
)
)
(:action CLOSE_SD19-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD19-condeffs)
(done-0)
(done-1)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD19-condeffs))
(not (done-0))
(not (done-1))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD14)
(not (NOT-CLOSED-SD14))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD11-condeffs)
(CLOSED-SD11)
(not (NOT-CLOSED-SD11))
)
)
(:action CLOSE_SD11-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD11-condeffs)
(CLOSED-SD18)
(CLOSED-SD17)
(CLOSED-CB4)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD11-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD11-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD11-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD11-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD11-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD11-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD11-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD11-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD11-condeffs))
(not (done-0))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD9-condeffs)
(CLOSED-SD9)
(not (NOT-CLOSED-SD9))
)
)
(:action CLOSE_SD9-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD9-condeffs)
(CLOSED-SD16)
(CLOSED-SD8)
(CLOSED-SD7)
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
(:action CLOSE_SD9-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD9-condeffs)
(NOT-CLOSED-SD16)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD9-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD9-condeffs)
(NOT-CLOSED-SD8)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD9-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD9-condeffs)
(NOT-CLOSED-SD7)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD9-condeff0-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD9-condeffs)
(NOT-CLOSED-SD1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD9-condeff0-no-4
:parameters ()
:precondition
(and
(do-CLOSE_SD9-condeffs)
(NOT-CLOSED-CB1)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD9-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD9-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD9-condeffs))
(not (done-0))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(not (do-normal))
(do-CLOSE_SD6-condeffs)
(CLOSED-SD6)
(not (NOT-CLOSED-SD6))
)
)
(:action CLOSE_SD6-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD6-condeffs)
(CLOSED-SD19)
(CLOSED-SD18)
(CLOSED-SD17)
(CLOSED-CB4)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB4)
(not (CLOSED-CB4))
)
)
(:action CLOSE_SD6-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD6-condeffs)
(NOT-CLOSED-SD19)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD6-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD6-condeffs)
(NOT-CLOSED-SD18)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD6-condeff0-no-2
:parameters ()
:precondition
(and
(do-CLOSE_SD6-condeffs)
(NOT-CLOSED-SD17)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD6-condeff0-no-3
:parameters ()
:precondition
(and
(do-CLOSE_SD6-condeffs)
(NOT-CLOSED-CB4)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD6-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD6-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD6-condeffs))
(not (done-0))
)
)
(:action WAIT_CB6
:parameters ()
:precondition
(and
(do-normal)
(NOT-UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-CB6)
(UPDATED-CB6)
(not (CLOSED-CB6))
(not (NOT-UPDATED-CB6))
)
)
(:action WAIT_CB5
:parameters ()
:precondition
(and
(do-normal)
(NOT-UPDATED-CB5)
)
:effect
(and
(not (do-normal))
(do-WAIT_CB5-condeffs)
(UPDATED-CB5)
(not (NOT-UPDATED-CB5))
)
)
(:action WAIT_CB5-condeff0-yes
:parameters ()
:precondition
(and
(do-WAIT_CB5-condeffs)
(CLOSED-SD20)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB5)
(not (CLOSED-CB5))
)
)
(:action WAIT_CB5-condeff0-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB5-condeffs)
(NOT-CLOSED-SD20)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB5-endof-condeffs
:parameters ()
:precondition
(and
(do-WAIT_CB5-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-WAIT_CB5-condeffs))
(not (done-0))
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
(CLOSED-SD15)
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
(NOT-CLOSED-SD15)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB3-endof-condeffs
:parameters ()
:precondition
(and
(do-WAIT_CB3-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-WAIT_CB3-condeffs))
(not (done-0))
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
(not (do-normal))
(do-WAIT_CB2-condeffs)
(UPDATED-CB2)
(not (NOT-UPDATED-CB2))
)
)
(:action WAIT_CB2-condeff0-yes
:parameters ()
:precondition
(and
(do-WAIT_CB2-condeffs)
(CLOSED-SD10)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB2)
(not (CLOSED-CB2))
)
)
(:action WAIT_CB2-condeff0-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB2-condeffs)
(NOT-CLOSED-SD10)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB2-condeff1-yes
:parameters ()
:precondition
(and
(do-WAIT_CB2-condeffs)
(CLOSED-SD12)
)
:effect
(and
(done-1)
(NOT-CLOSED-CB2)
(not (CLOSED-CB2))
)
)
(:action WAIT_CB2-condeff1-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB2-condeffs)
(NOT-CLOSED-SD12)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB2-endof-condeffs
:parameters ()
:precondition
(and
(do-WAIT_CB2-condeffs)
(done-0)
(done-1)
)
:effect
(and
(do-normal)
(not (do-WAIT_CB2-condeffs))
(not (done-0))
(not (done-1))
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
(CLOSED-SD4)
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
(NOT-CLOSED-SD4)
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
(NOT-CLOSED-SD3)
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
(NOT-CLOSED-SD2)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB1-condeff0-no-3
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
(CLOSED-SD16)
(CLOSED-SD9)
(CLOSED-SD8)
(CLOSED-SD7)
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
(NOT-CLOSED-SD16)
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
(NOT-CLOSED-SD9)
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
(NOT-CLOSED-SD8)
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
(NOT-CLOSED-SD7)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB1-condeff1-no-4
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
