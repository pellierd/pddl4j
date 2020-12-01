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
(NOT-CLOSED-CB4)
(UPDATED-CB4)
(NOT-CLOSED-CB5)
(UPDATED-CB5)
(NOT-CLOSED-CB6)
(UPDATED-CB6)
(CLOSED-SD6)
(CLOSED-SD7)
(CLOSED-SD8)
(CLOSED-SD14)
(CLOSED-SD20)
(CLOSED-SD35)
(NOT-CLOSED-SD1)
(NOT-CLOSED-SD2)
(NOT-CLOSED-SD3)
(NOT-CLOSED-SD4)
(NOT-CLOSED-SD5)
(NOT-CLOSED-SD9)
(NOT-CLOSED-SD10)
(NOT-CLOSED-SD11)
(NOT-CLOSED-SD12)
(NOT-CLOSED-SD13)
(NOT-CLOSED-SD15)
(NOT-CLOSED-SD16)
(NOT-CLOSED-SD17)
(NOT-CLOSED-SD18)
(NOT-CLOSED-SD19)
(NOT-CLOSED-SD21)
(NOT-CLOSED-SD22)
(NOT-CLOSED-SD23)
(NOT-CLOSED-SD24)
(NOT-CLOSED-SD25)
(NOT-CLOSED-SD26)
(NOT-CLOSED-SD27)
(NOT-CLOSED-SD28)
(NOT-CLOSED-SD29)
(NOT-CLOSED-SD30)
(NOT-CLOSED-SD31)
(NOT-CLOSED-SD32)
(NOT-CLOSED-SD33)
(NOT-CLOSED-SD34)
(NOT-CLOSED-SD36)
(NOT-CLOSED-SD37)
(CLOSED-CB6)
(CLOSED-CB5)
(CLOSED-SD37)
(CLOSED-SD36)
(CLOSED-SD34)
(CLOSED-SD33)
(CLOSED-SD32)
(CLOSED-SD31)
(CLOSED-SD30)
(CLOSED-SD29)
(CLOSED-SD28)
(CLOSED-SD27)
(CLOSED-SD26)
(CLOSED-SD25)
(CLOSED-SD24)
(CLOSED-SD23)
(CLOSED-SD22)
(CLOSED-SD21)
(CLOSED-SD19)
(CLOSED-SD18)
(CLOSED-SD17)
(CLOSED-SD16)
(CLOSED-SD15)
(CLOSED-SD13)
(CLOSED-SD12)
(CLOSED-SD11)
(CLOSED-SD10)
(CLOSED-SD9)
(CLOSED-SD5)
(CLOSED-SD4)
(CLOSED-SD3)
(CLOSED-SD2)
(CLOSED-SD1)
(CLOSED-CB4)
(CLOSED-CB3)
(CLOSED-CB2)
(CLOSED-CB1)
(NOT-CLOSED-SD35)
(NOT-CLOSED-SD20)
(NOT-CLOSED-SD14)
(NOT-CLOSED-SD8)
(NOT-CLOSED-SD7)
(NOT-CLOSED-SD6)
(NOT-UPDATED-CB6)
(NOT-UPDATED-CB5)
(NOT-UPDATED-CB4)
(NOT-UPDATED-CB3)
(NOT-UPDATED-CB2)
(NOT-UPDATED-CB1)
(do-CLOSE_SD36-condeffs)
(do-CLOSE_SD30-condeffs)
(do-CLOSE_SD29-condeffs)
(do-CLOSE_SD28-condeffs)
(do-WAIT_CB6-condeffs)
(do-WAIT_CB5-condeffs)
(do-normal)
(done-0)
(done-1)
)
(:action CLOSE_SD37
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD37)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD37)
(not (NOT-CLOSED-SD37))
)
)
(:action CLOSE_SD36
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD36)
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
(do-CLOSE_SD36-condeffs)
(CLOSED-SD36)
(not (NOT-CLOSED-SD36))
)
)
(:action CLOSE_SD36-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD36-condeffs)
(CLOSED-CB6)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB6)
(not (CLOSED-CB6))
)
)
(:action CLOSE_SD36-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD36-condeffs)
(NOT-CLOSED-CB6)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD36-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD36-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD36-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD34
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD34)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD34)
(not (NOT-CLOSED-SD34))
)
)
(:action CLOSE_SD33
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD33)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD33)
(not (NOT-CLOSED-SD33))
)
)
(:action CLOSE_SD32
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD32)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD32)
(not (NOT-CLOSED-SD32))
)
)
(:action CLOSE_SD31
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD31)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD31)
(not (NOT-CLOSED-SD31))
)
)
(:action CLOSE_SD30
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD30)
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
(do-CLOSE_SD30-condeffs)
(CLOSED-SD30)
(not (NOT-CLOSED-SD30))
)
)
(:action CLOSE_SD30-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD30-condeffs)
(CLOSED-SD29)
(CLOSED-CB5)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB5)
(not (CLOSED-CB5))
)
)
(:action CLOSE_SD30-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD30-condeffs)
(NOT-CLOSED-SD29)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD30-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD30-condeffs)
(NOT-CLOSED-CB5)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD30-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD30-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD30-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD29
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD29)
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
(do-CLOSE_SD29-condeffs)
(CLOSED-SD29)
(not (NOT-CLOSED-SD29))
)
)
(:action CLOSE_SD29-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD29-condeffs)
(CLOSED-SD30)
(CLOSED-CB5)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB5)
(not (CLOSED-CB5))
)
)
(:action CLOSE_SD29-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD29-condeffs)
(NOT-CLOSED-SD30)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD29-condeff0-no-1
:parameters ()
:precondition
(and
(do-CLOSE_SD29-condeffs)
(NOT-CLOSED-CB5)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD29-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD29-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD29-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD28
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD28)
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
(do-CLOSE_SD28-condeffs)
(CLOSED-SD28)
(not (NOT-CLOSED-SD28))
)
)
(:action CLOSE_SD28-condeff0-yes
:parameters ()
:precondition
(and
(do-CLOSE_SD28-condeffs)
(CLOSED-CB5)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB5)
(not (CLOSED-CB5))
)
)
(:action CLOSE_SD28-condeff0-no-0
:parameters ()
:precondition
(and
(do-CLOSE_SD28-condeffs)
(NOT-CLOSED-CB5)
)
:effect
(and
(done-0)
)
)
(:action CLOSE_SD28-endof-condeffs
:parameters ()
:precondition
(and
(do-CLOSE_SD28-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-CLOSE_SD28-condeffs))
(not (done-0))
)
)
(:action CLOSE_SD27
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD27)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD27)
(not (NOT-CLOSED-SD27))
)
)
(:action CLOSE_SD26
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD26)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD26)
(not (NOT-CLOSED-SD26))
)
)
(:action CLOSE_SD25
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD25)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD25)
(not (NOT-CLOSED-SD25))
)
)
(:action CLOSE_SD24
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD24)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD24)
(not (NOT-CLOSED-SD24))
)
)
(:action CLOSE_SD23
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD23)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD23)
(not (NOT-CLOSED-SD23))
)
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
(CLOSED-SD22)
(not (NOT-CLOSED-SD22))
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
(CLOSED-SD19)
(not (NOT-CLOSED-SD19))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD15)
(not (NOT-CLOSED-SD15))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD11)
(not (NOT-CLOSED-SD11))
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
(CLOSED-SD10)
(not (NOT-CLOSED-SD10))
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
(CLOSED-SD9)
(not (NOT-CLOSED-SD9))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD1)
(not (NOT-CLOSED-SD1))
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
(:action OPEN-SD37
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD37)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD37)
(not (CLOSED-SD37))
)
)
(:action OPEN-SD36
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD36)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD36)
(not (CLOSED-SD36))
)
)
(:action OPEN-SD35
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD35)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD35)
(not (CLOSED-SD35))
)
)
(:action OPEN-SD34
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD34)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD34)
(not (CLOSED-SD34))
)
)
(:action OPEN-SD33
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD33)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD33)
(not (CLOSED-SD33))
)
)
(:action OPEN-SD32
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD32)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD32)
(not (CLOSED-SD32))
)
)
(:action OPEN-SD31
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD31)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD31)
(not (CLOSED-SD31))
)
)
(:action OPEN-SD30
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD30)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD30)
(not (CLOSED-SD30))
)
)
(:action OPEN-SD29
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD29)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD29)
(not (CLOSED-SD29))
)
)
(:action OPEN-SD28
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD28)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD28)
(not (CLOSED-SD28))
)
)
(:action OPEN-SD27
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD27)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD27)
(not (CLOSED-SD27))
)
)
(:action OPEN-SD26
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD26)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD26)
(not (CLOSED-SD26))
)
)
(:action OPEN-SD25
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD25)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD25)
(not (CLOSED-SD25))
)
)
(:action OPEN-SD24
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD24)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD24)
(not (CLOSED-SD24))
)
)
(:action OPEN-SD23
:parameters ()
:precondition
(and
(do-normal)
(CLOSED-SD23)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(NOT-CLOSED-SD23)
(not (CLOSED-SD23))
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
(:action CLOSE_SD35
:parameters ()
:precondition
(and
(do-normal)
(NOT-CLOSED-SD35)
(UPDATED-CB1)
(UPDATED-CB2)
(UPDATED-CB3)
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD35)
(not (NOT-CLOSED-SD35))
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
(CLOSED-SD20)
(not (NOT-CLOSED-SD20))
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
(UPDATED-CB4)
(UPDATED-CB5)
(UPDATED-CB6)
)
:effect
(and
(CLOSED-SD7)
(not (NOT-CLOSED-SD7))
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
(CLOSED-SD6)
(not (NOT-CLOSED-SD6))
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
(not (do-normal))
(do-WAIT_CB6-condeffs)
(UPDATED-CB6)
(not (NOT-UPDATED-CB6))
)
)
(:action WAIT_CB6-condeff0-yes
:parameters ()
:precondition
(and
(do-WAIT_CB6-condeffs)
(CLOSED-SD36)
)
:effect
(and
(done-0)
(NOT-CLOSED-CB6)
(not (CLOSED-CB6))
)
)
(:action WAIT_CB6-condeff0-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB6-condeffs)
(NOT-CLOSED-SD36)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB6-endof-condeffs
:parameters ()
:precondition
(and
(do-WAIT_CB6-condeffs)
(done-0)
)
:effect
(and
(do-normal)
(not (do-WAIT_CB6-condeffs))
(not (done-0))
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
(CLOSED-SD28)
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
(NOT-CLOSED-SD28)
)
:effect
(and
(done-0)
)
)
(:action WAIT_CB5-condeff1-yes
:parameters ()
:precondition
(and
(do-WAIT_CB5-condeffs)
(CLOSED-SD30)
(CLOSED-SD29)
)
:effect
(and
(done-1)
(NOT-CLOSED-CB5)
(not (CLOSED-CB5))
)
)
(:action WAIT_CB5-condeff1-no-0
:parameters ()
:precondition
(and
(do-WAIT_CB5-condeffs)
(NOT-CLOSED-SD30)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB5-condeff1-no-1
:parameters ()
:precondition
(and
(do-WAIT_CB5-condeffs)
(NOT-CLOSED-SD29)
)
:effect
(and
(done-1)
)
)
(:action WAIT_CB5-endof-condeffs
:parameters ()
:precondition
(and
(do-WAIT_CB5-condeffs)
(done-0)
(done-1)
)
:effect
(and
(do-normal)
(not (do-WAIT_CB5-condeffs))
(not (done-0))
(not (done-1))
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
(NOT-CLOSED-CB4)
(UPDATED-CB4)
(not (CLOSED-CB4))
(not (NOT-UPDATED-CB4))
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
(NOT-CLOSED-CB3)
(UPDATED-CB3)
(not (CLOSED-CB3))
(not (NOT-UPDATED-CB3))
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
