(define (domain grounded-STRIPS-OPENSTACKS-SEQUENCEDSTRIPS)
(:requirements
:strips
)
(:predicates
(MACHINE-CONFIGURED-P1)
(MACHINE-CONFIGURED-P2)
(MACHINE-CONFIGURED-P3)
(MACHINE-CONFIGURED-P4)
(MACHINE-CONFIGURED-P5)
(MACHINE-CONFIGURED-P6)
(MACHINE-CONFIGURED-P7)
(MACHINE-CONFIGURED-P8)
(MACHINE-CONFIGURED-P9)
(MACHINE-CONFIGURED-P10)
(STACKS-AVAIL-N1)
(STARTED-O1)
(STARTED-O2)
(STARTED-O3)
(STARTED-O4)
(STARTED-O5)
(STARTED-O6)
(STARTED-O7)
(STARTED-O8)
(STARTED-O9)
(STARTED-O10)
(STACKS-AVAIL-N2)
(MADE-P1)
(MADE-P2)
(MADE-P3)
(MADE-P4)
(MADE-P5)
(MADE-P6)
(MADE-P7)
(MADE-P8)
(MADE-P9)
(MADE-P10)
(SHIPPED-O1)
(STACKS-AVAIL-N3)
(STACKS-AVAIL-N4)
(STACKS-AVAIL-N5)
(STACKS-AVAIL-N6)
(STACKS-AVAIL-N7)
(STACKS-AVAIL-N8)
(STACKS-AVAIL-N9)
(STACKS-AVAIL-N10)
(SHIPPED-O2)
(SHIPPED-O3)
(SHIPPED-O4)
(SHIPPED-O5)
(SHIPPED-O6)
(SHIPPED-O7)
(SHIPPED-O8)
(SHIPPED-O9)
(SHIPPED-O10)
(NOT-MADE-P10)
(NOT-MADE-P9)
(NOT-MADE-P8)
(NOT-MADE-P7)
(NOT-MADE-P6)
(NOT-MADE-P5)
(NOT-MADE-P4)
(NOT-MADE-P3)
(NOT-MADE-P2)
(NOT-MADE-P1)
(WAITING-O10)
(WAITING-O9)
(WAITING-O8)
(WAITING-O7)
(WAITING-O6)
(WAITING-O5)
(WAITING-O4)
(WAITING-O3)
(WAITING-O2)
(WAITING-O1)
(MACHINE-AVAILABLE-)
(STACKS-AVAIL-N0)
)
(:action MAKE-PRODUCT-P10-N10
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N10)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P10-N9
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N9)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P10-N8
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N8)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P10-N7
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N7)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P10-N6
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N6)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P10-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N5)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P10-N4
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N4)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P10-N3
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N3)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P9-N10
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N10)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P9-N9
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N9)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P9-N8
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N8)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P9-N7
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N7)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P9-N6
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N6)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P9-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N5)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P9-N4
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N4)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P9-N3
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N3)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P8-N10
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N10)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P8-N9
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N9)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P8-N8
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N8)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P8-N7
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N7)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P8-N6
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N6)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P8-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N5)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P8-N4
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N4)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P8-N3
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N3)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P7-N10
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N10)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P7-N9
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N9)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P7-N8
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N8)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P7-N7
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N7)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P7-N6
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N6)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P7-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N5)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P7-N4
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N4)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P7-N3
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N3)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P6-N10
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N10)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P6-N9
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N9)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P6-N8
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N8)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P6-N7
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N7)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P6-N6
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N6)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P6-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N5)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P6-N4
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N4)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P6-N3
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N3)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P5-N10
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N10)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P5-N9
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N9)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P5-N8
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N8)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P5-N7
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N7)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P5-N6
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N6)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P5-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N5)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P5-N4
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N4)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P5-N3
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N3)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P4-N10
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N10)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P4-N9
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N9)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P4-N8
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N8)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P4-N7
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N7)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P4-N6
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N6)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P4-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N5)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P4-N4
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N4)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P4-N3
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N3)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P3-N10
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N10)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P3-N9
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N9)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P3-N8
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N8)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P3-N7
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N7)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P3-N6
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N6)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P3-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N5)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P3-N4
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N4)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P3-N3
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N3)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P2-N10
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N10)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P2-N9
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N9)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P2-N8
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N8)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P2-N7
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N7)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P2-N6
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N6)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P2-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N5)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P2-N4
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N4)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P2-N3
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N3)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P1-N10
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N10)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action MAKE-PRODUCT-P1-N9
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N9)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action MAKE-PRODUCT-P1-N8
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N8)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action MAKE-PRODUCT-P1-N7
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N7)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action MAKE-PRODUCT-P1-N6
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N6)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action MAKE-PRODUCT-P1-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N5)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action MAKE-PRODUCT-P1-N4
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N4)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action MAKE-PRODUCT-P1-N3
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N3)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action OPEN-NEW-STACK-N2-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(not (STACKS-AVAIL-N2))
)
)
(:action OPEN-NEW-STACK-N3-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(not (STACKS-AVAIL-N3))
)
)
(:action OPEN-NEW-STACK-N4-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(not (STACKS-AVAIL-N4))
)
)
(:action OPEN-NEW-STACK-N5-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(not (STACKS-AVAIL-N5))
)
)
(:action OPEN-NEW-STACK-N6-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(not (STACKS-AVAIL-N6))
)
)
(:action OPEN-NEW-STACK-N7-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(not (STACKS-AVAIL-N7))
)
)
(:action OPEN-NEW-STACK-N8-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(not (STACKS-AVAIL-N8))
)
)
(:action OPEN-NEW-STACK-N9-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O10-N2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(WAITING-O10)
)
:effect
(and
(STARTED-O10)
(STACKS-AVAIL-N1)
(not (WAITING-O10))
(not (STACKS-AVAIL-N2))
)
)
(:action START-ORDER-O9-N2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(WAITING-O9)
)
:effect
(and
(STARTED-O9)
(STACKS-AVAIL-N1)
(not (WAITING-O9))
(not (STACKS-AVAIL-N2))
)
)
(:action START-ORDER-O8-N2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(WAITING-O8)
)
:effect
(and
(STARTED-O8)
(STACKS-AVAIL-N1)
(not (WAITING-O8))
(not (STACKS-AVAIL-N2))
)
)
(:action START-ORDER-O7-N2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(WAITING-O7)
)
:effect
(and
(STARTED-O7)
(STACKS-AVAIL-N1)
(not (WAITING-O7))
(not (STACKS-AVAIL-N2))
)
)
(:action START-ORDER-O6-N2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(WAITING-O6)
)
:effect
(and
(STARTED-O6)
(STACKS-AVAIL-N1)
(not (WAITING-O6))
(not (STACKS-AVAIL-N2))
)
)
(:action START-ORDER-O5-N2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(WAITING-O5)
)
:effect
(and
(STARTED-O5)
(STACKS-AVAIL-N1)
(not (WAITING-O5))
(not (STACKS-AVAIL-N2))
)
)
(:action START-ORDER-O4-N2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(WAITING-O4)
)
:effect
(and
(STARTED-O4)
(STACKS-AVAIL-N1)
(not (WAITING-O4))
(not (STACKS-AVAIL-N2))
)
)
(:action START-ORDER-O3-N2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(WAITING-O3)
)
:effect
(and
(STARTED-O3)
(STACKS-AVAIL-N1)
(not (WAITING-O3))
(not (STACKS-AVAIL-N2))
)
)
(:action START-ORDER-O2-N2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(WAITING-O2)
)
:effect
(and
(STARTED-O2)
(STACKS-AVAIL-N1)
(not (WAITING-O2))
(not (STACKS-AVAIL-N2))
)
)
(:action START-ORDER-O1-N2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(WAITING-O1)
)
:effect
(and
(STARTED-O1)
(STACKS-AVAIL-N1)
(not (WAITING-O1))
(not (STACKS-AVAIL-N2))
)
)
(:action START-ORDER-O10-N3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(WAITING-O10)
)
:effect
(and
(STARTED-O10)
(STACKS-AVAIL-N2)
(not (WAITING-O10))
(not (STACKS-AVAIL-N3))
)
)
(:action START-ORDER-O9-N3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(WAITING-O9)
)
:effect
(and
(STARTED-O9)
(STACKS-AVAIL-N2)
(not (WAITING-O9))
(not (STACKS-AVAIL-N3))
)
)
(:action START-ORDER-O8-N3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(WAITING-O8)
)
:effect
(and
(STARTED-O8)
(STACKS-AVAIL-N2)
(not (WAITING-O8))
(not (STACKS-AVAIL-N3))
)
)
(:action START-ORDER-O7-N3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(WAITING-O7)
)
:effect
(and
(STARTED-O7)
(STACKS-AVAIL-N2)
(not (WAITING-O7))
(not (STACKS-AVAIL-N3))
)
)
(:action START-ORDER-O6-N3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(WAITING-O6)
)
:effect
(and
(STARTED-O6)
(STACKS-AVAIL-N2)
(not (WAITING-O6))
(not (STACKS-AVAIL-N3))
)
)
(:action START-ORDER-O5-N3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(WAITING-O5)
)
:effect
(and
(STARTED-O5)
(STACKS-AVAIL-N2)
(not (WAITING-O5))
(not (STACKS-AVAIL-N3))
)
)
(:action START-ORDER-O4-N3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(WAITING-O4)
)
:effect
(and
(STARTED-O4)
(STACKS-AVAIL-N2)
(not (WAITING-O4))
(not (STACKS-AVAIL-N3))
)
)
(:action START-ORDER-O3-N3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(WAITING-O3)
)
:effect
(and
(STARTED-O3)
(STACKS-AVAIL-N2)
(not (WAITING-O3))
(not (STACKS-AVAIL-N3))
)
)
(:action START-ORDER-O2-N3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(WAITING-O2)
)
:effect
(and
(STARTED-O2)
(STACKS-AVAIL-N2)
(not (WAITING-O2))
(not (STACKS-AVAIL-N3))
)
)
(:action START-ORDER-O1-N3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(WAITING-O1)
)
:effect
(and
(STARTED-O1)
(STACKS-AVAIL-N2)
(not (WAITING-O1))
(not (STACKS-AVAIL-N3))
)
)
(:action START-ORDER-O10-N4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(WAITING-O10)
)
:effect
(and
(STARTED-O10)
(STACKS-AVAIL-N3)
(not (WAITING-O10))
(not (STACKS-AVAIL-N4))
)
)
(:action START-ORDER-O9-N4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(WAITING-O9)
)
:effect
(and
(STARTED-O9)
(STACKS-AVAIL-N3)
(not (WAITING-O9))
(not (STACKS-AVAIL-N4))
)
)
(:action START-ORDER-O8-N4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(WAITING-O8)
)
:effect
(and
(STARTED-O8)
(STACKS-AVAIL-N3)
(not (WAITING-O8))
(not (STACKS-AVAIL-N4))
)
)
(:action START-ORDER-O7-N4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(WAITING-O7)
)
:effect
(and
(STARTED-O7)
(STACKS-AVAIL-N3)
(not (WAITING-O7))
(not (STACKS-AVAIL-N4))
)
)
(:action START-ORDER-O6-N4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(WAITING-O6)
)
:effect
(and
(STARTED-O6)
(STACKS-AVAIL-N3)
(not (WAITING-O6))
(not (STACKS-AVAIL-N4))
)
)
(:action START-ORDER-O5-N4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(WAITING-O5)
)
:effect
(and
(STARTED-O5)
(STACKS-AVAIL-N3)
(not (WAITING-O5))
(not (STACKS-AVAIL-N4))
)
)
(:action START-ORDER-O4-N4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(WAITING-O4)
)
:effect
(and
(STARTED-O4)
(STACKS-AVAIL-N3)
(not (WAITING-O4))
(not (STACKS-AVAIL-N4))
)
)
(:action START-ORDER-O3-N4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(WAITING-O3)
)
:effect
(and
(STARTED-O3)
(STACKS-AVAIL-N3)
(not (WAITING-O3))
(not (STACKS-AVAIL-N4))
)
)
(:action START-ORDER-O2-N4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(WAITING-O2)
)
:effect
(and
(STARTED-O2)
(STACKS-AVAIL-N3)
(not (WAITING-O2))
(not (STACKS-AVAIL-N4))
)
)
(:action START-ORDER-O1-N4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(WAITING-O1)
)
:effect
(and
(STARTED-O1)
(STACKS-AVAIL-N3)
(not (WAITING-O1))
(not (STACKS-AVAIL-N4))
)
)
(:action START-ORDER-O10-N5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(WAITING-O10)
)
:effect
(and
(STARTED-O10)
(STACKS-AVAIL-N4)
(not (WAITING-O10))
(not (STACKS-AVAIL-N5))
)
)
(:action START-ORDER-O9-N5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(WAITING-O9)
)
:effect
(and
(STARTED-O9)
(STACKS-AVAIL-N4)
(not (WAITING-O9))
(not (STACKS-AVAIL-N5))
)
)
(:action START-ORDER-O8-N5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(WAITING-O8)
)
:effect
(and
(STARTED-O8)
(STACKS-AVAIL-N4)
(not (WAITING-O8))
(not (STACKS-AVAIL-N5))
)
)
(:action START-ORDER-O7-N5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(WAITING-O7)
)
:effect
(and
(STARTED-O7)
(STACKS-AVAIL-N4)
(not (WAITING-O7))
(not (STACKS-AVAIL-N5))
)
)
(:action START-ORDER-O6-N5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(WAITING-O6)
)
:effect
(and
(STARTED-O6)
(STACKS-AVAIL-N4)
(not (WAITING-O6))
(not (STACKS-AVAIL-N5))
)
)
(:action START-ORDER-O5-N5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(WAITING-O5)
)
:effect
(and
(STARTED-O5)
(STACKS-AVAIL-N4)
(not (WAITING-O5))
(not (STACKS-AVAIL-N5))
)
)
(:action START-ORDER-O4-N5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(WAITING-O4)
)
:effect
(and
(STARTED-O4)
(STACKS-AVAIL-N4)
(not (WAITING-O4))
(not (STACKS-AVAIL-N5))
)
)
(:action START-ORDER-O3-N5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(WAITING-O3)
)
:effect
(and
(STARTED-O3)
(STACKS-AVAIL-N4)
(not (WAITING-O3))
(not (STACKS-AVAIL-N5))
)
)
(:action START-ORDER-O2-N5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(WAITING-O2)
)
:effect
(and
(STARTED-O2)
(STACKS-AVAIL-N4)
(not (WAITING-O2))
(not (STACKS-AVAIL-N5))
)
)
(:action START-ORDER-O1-N5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(WAITING-O1)
)
:effect
(and
(STARTED-O1)
(STACKS-AVAIL-N4)
(not (WAITING-O1))
(not (STACKS-AVAIL-N5))
)
)
(:action START-ORDER-O10-N6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(WAITING-O10)
)
:effect
(and
(STARTED-O10)
(STACKS-AVAIL-N5)
(not (WAITING-O10))
(not (STACKS-AVAIL-N6))
)
)
(:action START-ORDER-O9-N6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(WAITING-O9)
)
:effect
(and
(STARTED-O9)
(STACKS-AVAIL-N5)
(not (WAITING-O9))
(not (STACKS-AVAIL-N6))
)
)
(:action START-ORDER-O8-N6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(WAITING-O8)
)
:effect
(and
(STARTED-O8)
(STACKS-AVAIL-N5)
(not (WAITING-O8))
(not (STACKS-AVAIL-N6))
)
)
(:action START-ORDER-O7-N6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(WAITING-O7)
)
:effect
(and
(STARTED-O7)
(STACKS-AVAIL-N5)
(not (WAITING-O7))
(not (STACKS-AVAIL-N6))
)
)
(:action START-ORDER-O6-N6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(WAITING-O6)
)
:effect
(and
(STARTED-O6)
(STACKS-AVAIL-N5)
(not (WAITING-O6))
(not (STACKS-AVAIL-N6))
)
)
(:action START-ORDER-O5-N6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(WAITING-O5)
)
:effect
(and
(STARTED-O5)
(STACKS-AVAIL-N5)
(not (WAITING-O5))
(not (STACKS-AVAIL-N6))
)
)
(:action START-ORDER-O4-N6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(WAITING-O4)
)
:effect
(and
(STARTED-O4)
(STACKS-AVAIL-N5)
(not (WAITING-O4))
(not (STACKS-AVAIL-N6))
)
)
(:action START-ORDER-O3-N6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(WAITING-O3)
)
:effect
(and
(STARTED-O3)
(STACKS-AVAIL-N5)
(not (WAITING-O3))
(not (STACKS-AVAIL-N6))
)
)
(:action START-ORDER-O2-N6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(WAITING-O2)
)
:effect
(and
(STARTED-O2)
(STACKS-AVAIL-N5)
(not (WAITING-O2))
(not (STACKS-AVAIL-N6))
)
)
(:action START-ORDER-O1-N6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(WAITING-O1)
)
:effect
(and
(STARTED-O1)
(STACKS-AVAIL-N5)
(not (WAITING-O1))
(not (STACKS-AVAIL-N6))
)
)
(:action START-ORDER-O10-N7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(WAITING-O10)
)
:effect
(and
(STARTED-O10)
(STACKS-AVAIL-N6)
(not (WAITING-O10))
(not (STACKS-AVAIL-N7))
)
)
(:action START-ORDER-O9-N7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(WAITING-O9)
)
:effect
(and
(STARTED-O9)
(STACKS-AVAIL-N6)
(not (WAITING-O9))
(not (STACKS-AVAIL-N7))
)
)
(:action START-ORDER-O8-N7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(WAITING-O8)
)
:effect
(and
(STARTED-O8)
(STACKS-AVAIL-N6)
(not (WAITING-O8))
(not (STACKS-AVAIL-N7))
)
)
(:action START-ORDER-O7-N7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(WAITING-O7)
)
:effect
(and
(STARTED-O7)
(STACKS-AVAIL-N6)
(not (WAITING-O7))
(not (STACKS-AVAIL-N7))
)
)
(:action START-ORDER-O6-N7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(WAITING-O6)
)
:effect
(and
(STARTED-O6)
(STACKS-AVAIL-N6)
(not (WAITING-O6))
(not (STACKS-AVAIL-N7))
)
)
(:action START-ORDER-O5-N7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(WAITING-O5)
)
:effect
(and
(STARTED-O5)
(STACKS-AVAIL-N6)
(not (WAITING-O5))
(not (STACKS-AVAIL-N7))
)
)
(:action START-ORDER-O4-N7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(WAITING-O4)
)
:effect
(and
(STARTED-O4)
(STACKS-AVAIL-N6)
(not (WAITING-O4))
(not (STACKS-AVAIL-N7))
)
)
(:action START-ORDER-O3-N7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(WAITING-O3)
)
:effect
(and
(STARTED-O3)
(STACKS-AVAIL-N6)
(not (WAITING-O3))
(not (STACKS-AVAIL-N7))
)
)
(:action START-ORDER-O2-N7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(WAITING-O2)
)
:effect
(and
(STARTED-O2)
(STACKS-AVAIL-N6)
(not (WAITING-O2))
(not (STACKS-AVAIL-N7))
)
)
(:action START-ORDER-O1-N7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(WAITING-O1)
)
:effect
(and
(STARTED-O1)
(STACKS-AVAIL-N6)
(not (WAITING-O1))
(not (STACKS-AVAIL-N7))
)
)
(:action START-ORDER-O10-N8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(WAITING-O10)
)
:effect
(and
(STARTED-O10)
(STACKS-AVAIL-N7)
(not (WAITING-O10))
(not (STACKS-AVAIL-N8))
)
)
(:action START-ORDER-O9-N8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(WAITING-O9)
)
:effect
(and
(STARTED-O9)
(STACKS-AVAIL-N7)
(not (WAITING-O9))
(not (STACKS-AVAIL-N8))
)
)
(:action START-ORDER-O8-N8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(WAITING-O8)
)
:effect
(and
(STARTED-O8)
(STACKS-AVAIL-N7)
(not (WAITING-O8))
(not (STACKS-AVAIL-N8))
)
)
(:action START-ORDER-O7-N8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(WAITING-O7)
)
:effect
(and
(STARTED-O7)
(STACKS-AVAIL-N7)
(not (WAITING-O7))
(not (STACKS-AVAIL-N8))
)
)
(:action START-ORDER-O6-N8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(WAITING-O6)
)
:effect
(and
(STARTED-O6)
(STACKS-AVAIL-N7)
(not (WAITING-O6))
(not (STACKS-AVAIL-N8))
)
)
(:action START-ORDER-O5-N8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(WAITING-O5)
)
:effect
(and
(STARTED-O5)
(STACKS-AVAIL-N7)
(not (WAITING-O5))
(not (STACKS-AVAIL-N8))
)
)
(:action START-ORDER-O4-N8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(WAITING-O4)
)
:effect
(and
(STARTED-O4)
(STACKS-AVAIL-N7)
(not (WAITING-O4))
(not (STACKS-AVAIL-N8))
)
)
(:action START-ORDER-O3-N8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(WAITING-O3)
)
:effect
(and
(STARTED-O3)
(STACKS-AVAIL-N7)
(not (WAITING-O3))
(not (STACKS-AVAIL-N8))
)
)
(:action START-ORDER-O2-N8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(WAITING-O2)
)
:effect
(and
(STARTED-O2)
(STACKS-AVAIL-N7)
(not (WAITING-O2))
(not (STACKS-AVAIL-N8))
)
)
(:action START-ORDER-O1-N8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(WAITING-O1)
)
:effect
(and
(STARTED-O1)
(STACKS-AVAIL-N7)
(not (WAITING-O1))
(not (STACKS-AVAIL-N8))
)
)
(:action START-ORDER-O10-N9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(WAITING-O10)
)
:effect
(and
(STARTED-O10)
(STACKS-AVAIL-N8)
(not (WAITING-O10))
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O9-N9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(WAITING-O9)
)
:effect
(and
(STARTED-O9)
(STACKS-AVAIL-N8)
(not (WAITING-O9))
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O8-N9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(WAITING-O8)
)
:effect
(and
(STARTED-O8)
(STACKS-AVAIL-N8)
(not (WAITING-O8))
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O7-N9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(WAITING-O7)
)
:effect
(and
(STARTED-O7)
(STACKS-AVAIL-N8)
(not (WAITING-O7))
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O6-N9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(WAITING-O6)
)
:effect
(and
(STARTED-O6)
(STACKS-AVAIL-N8)
(not (WAITING-O6))
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O5-N9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(WAITING-O5)
)
:effect
(and
(STARTED-O5)
(STACKS-AVAIL-N8)
(not (WAITING-O5))
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O4-N9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(WAITING-O4)
)
:effect
(and
(STARTED-O4)
(STACKS-AVAIL-N8)
(not (WAITING-O4))
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O3-N9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(WAITING-O3)
)
:effect
(and
(STARTED-O3)
(STACKS-AVAIL-N8)
(not (WAITING-O3))
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O2-N9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(WAITING-O2)
)
:effect
(and
(STARTED-O2)
(STACKS-AVAIL-N8)
(not (WAITING-O2))
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O1-N9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(WAITING-O1)
)
:effect
(and
(STARTED-O1)
(STACKS-AVAIL-N8)
(not (WAITING-O1))
(not (STACKS-AVAIL-N9))
)
)
(:action START-ORDER-O10-N10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(WAITING-O10)
)
:effect
(and
(STARTED-O10)
(STACKS-AVAIL-N9)
(not (WAITING-O10))
(not (STACKS-AVAIL-N10))
)
)
(:action START-ORDER-O9-N10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(WAITING-O9)
)
:effect
(and
(STARTED-O9)
(STACKS-AVAIL-N9)
(not (WAITING-O9))
(not (STACKS-AVAIL-N10))
)
)
(:action START-ORDER-O8-N10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(WAITING-O8)
)
:effect
(and
(STARTED-O8)
(STACKS-AVAIL-N9)
(not (WAITING-O8))
(not (STACKS-AVAIL-N10))
)
)
(:action START-ORDER-O7-N10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(WAITING-O7)
)
:effect
(and
(STARTED-O7)
(STACKS-AVAIL-N9)
(not (WAITING-O7))
(not (STACKS-AVAIL-N10))
)
)
(:action START-ORDER-O6-N10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(WAITING-O6)
)
:effect
(and
(STARTED-O6)
(STACKS-AVAIL-N9)
(not (WAITING-O6))
(not (STACKS-AVAIL-N10))
)
)
(:action START-ORDER-O5-N10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(WAITING-O5)
)
:effect
(and
(STARTED-O5)
(STACKS-AVAIL-N9)
(not (WAITING-O5))
(not (STACKS-AVAIL-N10))
)
)
(:action START-ORDER-O4-N10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(WAITING-O4)
)
:effect
(and
(STARTED-O4)
(STACKS-AVAIL-N9)
(not (WAITING-O4))
(not (STACKS-AVAIL-N10))
)
)
(:action START-ORDER-O3-N10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(WAITING-O3)
)
:effect
(and
(STARTED-O3)
(STACKS-AVAIL-N9)
(not (WAITING-O3))
(not (STACKS-AVAIL-N10))
)
)
(:action START-ORDER-O2-N10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(WAITING-O2)
)
:effect
(and
(STARTED-O2)
(STACKS-AVAIL-N9)
(not (WAITING-O2))
(not (STACKS-AVAIL-N10))
)
)
(:action START-ORDER-O1-N10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(WAITING-O1)
)
:effect
(and
(STARTED-O1)
(STACKS-AVAIL-N9)
(not (WAITING-O1))
(not (STACKS-AVAIL-N10))
)
)
(:action SETUP-MACHINE-P10-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P10-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P10-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P10-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P10-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P10-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P10-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P10-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P10-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N10
:parameters ()
:precondition
(and
(STACKS-AVAIL-N10)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N9
:parameters ()
:precondition
(and
(STACKS-AVAIL-N9)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N8
:parameters ()
:precondition
(and
(STACKS-AVAIL-N8)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N7
:parameters ()
:precondition
(and
(STACKS-AVAIL-N7)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N6
:parameters ()
:precondition
(and
(STACKS-AVAIL-N6)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N5
:parameters ()
:precondition
(and
(STACKS-AVAIL-N5)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N4
:parameters ()
:precondition
(and
(STACKS-AVAIL-N4)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N3
:parameters ()
:precondition
(and
(STACKS-AVAIL-N3)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N2)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
(:action SHIP-ORDER-O10-N9-N10
:parameters ()
:precondition
(and
(STARTED-O10)
(MADE-P6)
(MADE-P5)
(MADE-P1)
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(SHIPPED-O10)
(not (STACKS-AVAIL-N9))
(not (STARTED-O10))
)
)
(:action SHIP-ORDER-O10-N8-N9
:parameters ()
:precondition
(and
(STARTED-O10)
(MADE-P6)
(MADE-P5)
(MADE-P1)
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(SHIPPED-O10)
(not (STACKS-AVAIL-N8))
(not (STARTED-O10))
)
)
(:action SHIP-ORDER-O10-N7-N8
:parameters ()
:precondition
(and
(STARTED-O10)
(MADE-P6)
(MADE-P5)
(MADE-P1)
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(SHIPPED-O10)
(not (STACKS-AVAIL-N7))
(not (STARTED-O10))
)
)
(:action SHIP-ORDER-O10-N6-N7
:parameters ()
:precondition
(and
(STARTED-O10)
(MADE-P6)
(MADE-P5)
(MADE-P1)
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(SHIPPED-O10)
(not (STACKS-AVAIL-N6))
(not (STARTED-O10))
)
)
(:action SHIP-ORDER-O10-N5-N6
:parameters ()
:precondition
(and
(STARTED-O10)
(MADE-P6)
(MADE-P5)
(MADE-P1)
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(SHIPPED-O10)
(not (STACKS-AVAIL-N5))
(not (STARTED-O10))
)
)
(:action SHIP-ORDER-O10-N4-N5
:parameters ()
:precondition
(and
(STARTED-O10)
(MADE-P6)
(MADE-P5)
(MADE-P1)
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(SHIPPED-O10)
(not (STACKS-AVAIL-N4))
(not (STARTED-O10))
)
)
(:action SHIP-ORDER-O10-N3-N4
:parameters ()
:precondition
(and
(STARTED-O10)
(MADE-P6)
(MADE-P5)
(MADE-P1)
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(SHIPPED-O10)
(not (STACKS-AVAIL-N3))
(not (STARTED-O10))
)
)
(:action SHIP-ORDER-O10-N2-N3
:parameters ()
:precondition
(and
(STARTED-O10)
(MADE-P6)
(MADE-P5)
(MADE-P1)
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(SHIPPED-O10)
(not (STACKS-AVAIL-N2))
(not (STARTED-O10))
)
)
(:action SHIP-ORDER-O10-N1-N2
:parameters ()
:precondition
(and
(STARTED-O10)
(MADE-P6)
(MADE-P5)
(MADE-P1)
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(SHIPPED-O10)
(not (STACKS-AVAIL-N1))
(not (STARTED-O10))
)
)
(:action SHIP-ORDER-O10-N0-N1
:parameters ()
:precondition
(and
(STARTED-O10)
(MADE-P6)
(MADE-P5)
(MADE-P1)
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(SHIPPED-O10)
(not (STACKS-AVAIL-N0))
(not (STARTED-O10))
)
)
(:action SHIP-ORDER-O9-N9-N10
:parameters ()
:precondition
(and
(STARTED-O9)
(MADE-P9)
(MADE-P7)
(MADE-P4)
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(SHIPPED-O9)
(not (STACKS-AVAIL-N9))
(not (STARTED-O9))
)
)
(:action SHIP-ORDER-O9-N8-N9
:parameters ()
:precondition
(and
(STARTED-O9)
(MADE-P9)
(MADE-P7)
(MADE-P4)
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(SHIPPED-O9)
(not (STACKS-AVAIL-N8))
(not (STARTED-O9))
)
)
(:action SHIP-ORDER-O9-N7-N8
:parameters ()
:precondition
(and
(STARTED-O9)
(MADE-P9)
(MADE-P7)
(MADE-P4)
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(SHIPPED-O9)
(not (STACKS-AVAIL-N7))
(not (STARTED-O9))
)
)
(:action SHIP-ORDER-O9-N6-N7
:parameters ()
:precondition
(and
(STARTED-O9)
(MADE-P9)
(MADE-P7)
(MADE-P4)
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(SHIPPED-O9)
(not (STACKS-AVAIL-N6))
(not (STARTED-O9))
)
)
(:action SHIP-ORDER-O9-N5-N6
:parameters ()
:precondition
(and
(STARTED-O9)
(MADE-P9)
(MADE-P7)
(MADE-P4)
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(SHIPPED-O9)
(not (STACKS-AVAIL-N5))
(not (STARTED-O9))
)
)
(:action SHIP-ORDER-O9-N4-N5
:parameters ()
:precondition
(and
(STARTED-O9)
(MADE-P9)
(MADE-P7)
(MADE-P4)
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(SHIPPED-O9)
(not (STACKS-AVAIL-N4))
(not (STARTED-O9))
)
)
(:action SHIP-ORDER-O9-N3-N4
:parameters ()
:precondition
(and
(STARTED-O9)
(MADE-P9)
(MADE-P7)
(MADE-P4)
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(SHIPPED-O9)
(not (STACKS-AVAIL-N3))
(not (STARTED-O9))
)
)
(:action SHIP-ORDER-O9-N2-N3
:parameters ()
:precondition
(and
(STARTED-O9)
(MADE-P9)
(MADE-P7)
(MADE-P4)
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(SHIPPED-O9)
(not (STACKS-AVAIL-N2))
(not (STARTED-O9))
)
)
(:action SHIP-ORDER-O9-N1-N2
:parameters ()
:precondition
(and
(STARTED-O9)
(MADE-P9)
(MADE-P7)
(MADE-P4)
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(SHIPPED-O9)
(not (STACKS-AVAIL-N1))
(not (STARTED-O9))
)
)
(:action SHIP-ORDER-O9-N0-N1
:parameters ()
:precondition
(and
(STARTED-O9)
(MADE-P9)
(MADE-P7)
(MADE-P4)
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(SHIPPED-O9)
(not (STACKS-AVAIL-N0))
(not (STARTED-O9))
)
)
(:action SHIP-ORDER-O8-N9-N10
:parameters ()
:precondition
(and
(STARTED-O8)
(MADE-P10)
(MADE-P5)
(MADE-P3)
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(SHIPPED-O8)
(not (STACKS-AVAIL-N9))
(not (STARTED-O8))
)
)
(:action SHIP-ORDER-O8-N8-N9
:parameters ()
:precondition
(and
(STARTED-O8)
(MADE-P10)
(MADE-P5)
(MADE-P3)
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(SHIPPED-O8)
(not (STACKS-AVAIL-N8))
(not (STARTED-O8))
)
)
(:action SHIP-ORDER-O8-N7-N8
:parameters ()
:precondition
(and
(STARTED-O8)
(MADE-P10)
(MADE-P5)
(MADE-P3)
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(SHIPPED-O8)
(not (STACKS-AVAIL-N7))
(not (STARTED-O8))
)
)
(:action SHIP-ORDER-O8-N6-N7
:parameters ()
:precondition
(and
(STARTED-O8)
(MADE-P10)
(MADE-P5)
(MADE-P3)
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(SHIPPED-O8)
(not (STACKS-AVAIL-N6))
(not (STARTED-O8))
)
)
(:action SHIP-ORDER-O8-N5-N6
:parameters ()
:precondition
(and
(STARTED-O8)
(MADE-P10)
(MADE-P5)
(MADE-P3)
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(SHIPPED-O8)
(not (STACKS-AVAIL-N5))
(not (STARTED-O8))
)
)
(:action SHIP-ORDER-O8-N4-N5
:parameters ()
:precondition
(and
(STARTED-O8)
(MADE-P10)
(MADE-P5)
(MADE-P3)
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(SHIPPED-O8)
(not (STACKS-AVAIL-N4))
(not (STARTED-O8))
)
)
(:action SHIP-ORDER-O8-N3-N4
:parameters ()
:precondition
(and
(STARTED-O8)
(MADE-P10)
(MADE-P5)
(MADE-P3)
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(SHIPPED-O8)
(not (STACKS-AVAIL-N3))
(not (STARTED-O8))
)
)
(:action SHIP-ORDER-O8-N2-N3
:parameters ()
:precondition
(and
(STARTED-O8)
(MADE-P10)
(MADE-P5)
(MADE-P3)
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(SHIPPED-O8)
(not (STACKS-AVAIL-N2))
(not (STARTED-O8))
)
)
(:action SHIP-ORDER-O8-N1-N2
:parameters ()
:precondition
(and
(STARTED-O8)
(MADE-P10)
(MADE-P5)
(MADE-P3)
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(SHIPPED-O8)
(not (STACKS-AVAIL-N1))
(not (STARTED-O8))
)
)
(:action SHIP-ORDER-O8-N0-N1
:parameters ()
:precondition
(and
(STARTED-O8)
(MADE-P10)
(MADE-P5)
(MADE-P3)
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(SHIPPED-O8)
(not (STACKS-AVAIL-N0))
(not (STARTED-O8))
)
)
(:action SHIP-ORDER-O7-N9-N10
:parameters ()
:precondition
(and
(STARTED-O7)
(MADE-P7)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(SHIPPED-O7)
(not (STACKS-AVAIL-N9))
(not (STARTED-O7))
)
)
(:action SHIP-ORDER-O7-N8-N9
:parameters ()
:precondition
(and
(STARTED-O7)
(MADE-P7)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(SHIPPED-O7)
(not (STACKS-AVAIL-N8))
(not (STARTED-O7))
)
)
(:action SHIP-ORDER-O7-N7-N8
:parameters ()
:precondition
(and
(STARTED-O7)
(MADE-P7)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(SHIPPED-O7)
(not (STACKS-AVAIL-N7))
(not (STARTED-O7))
)
)
(:action SHIP-ORDER-O7-N6-N7
:parameters ()
:precondition
(and
(STARTED-O7)
(MADE-P7)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(SHIPPED-O7)
(not (STACKS-AVAIL-N6))
(not (STARTED-O7))
)
)
(:action SHIP-ORDER-O7-N5-N6
:parameters ()
:precondition
(and
(STARTED-O7)
(MADE-P7)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(SHIPPED-O7)
(not (STACKS-AVAIL-N5))
(not (STARTED-O7))
)
)
(:action SHIP-ORDER-O7-N4-N5
:parameters ()
:precondition
(and
(STARTED-O7)
(MADE-P7)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(SHIPPED-O7)
(not (STACKS-AVAIL-N4))
(not (STARTED-O7))
)
)
(:action SHIP-ORDER-O7-N3-N4
:parameters ()
:precondition
(and
(STARTED-O7)
(MADE-P7)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(SHIPPED-O7)
(not (STACKS-AVAIL-N3))
(not (STARTED-O7))
)
)
(:action SHIP-ORDER-O7-N2-N3
:parameters ()
:precondition
(and
(STARTED-O7)
(MADE-P7)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(SHIPPED-O7)
(not (STACKS-AVAIL-N2))
(not (STARTED-O7))
)
)
(:action SHIP-ORDER-O7-N1-N2
:parameters ()
:precondition
(and
(STARTED-O7)
(MADE-P7)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(SHIPPED-O7)
(not (STACKS-AVAIL-N1))
(not (STARTED-O7))
)
)
(:action SHIP-ORDER-O7-N0-N1
:parameters ()
:precondition
(and
(STARTED-O7)
(MADE-P7)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(SHIPPED-O7)
(not (STACKS-AVAIL-N0))
(not (STARTED-O7))
)
)
(:action SHIP-ORDER-O6-N9-N10
:parameters ()
:precondition
(and
(STARTED-O6)
(MADE-P10)
(MADE-P8)
(MADE-P7)
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(SHIPPED-O6)
(not (STACKS-AVAIL-N9))
(not (STARTED-O6))
)
)
(:action SHIP-ORDER-O6-N8-N9
:parameters ()
:precondition
(and
(STARTED-O6)
(MADE-P10)
(MADE-P8)
(MADE-P7)
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(SHIPPED-O6)
(not (STACKS-AVAIL-N8))
(not (STARTED-O6))
)
)
(:action SHIP-ORDER-O6-N7-N8
:parameters ()
:precondition
(and
(STARTED-O6)
(MADE-P10)
(MADE-P8)
(MADE-P7)
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(SHIPPED-O6)
(not (STACKS-AVAIL-N7))
(not (STARTED-O6))
)
)
(:action SHIP-ORDER-O6-N6-N7
:parameters ()
:precondition
(and
(STARTED-O6)
(MADE-P10)
(MADE-P8)
(MADE-P7)
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(SHIPPED-O6)
(not (STACKS-AVAIL-N6))
(not (STARTED-O6))
)
)
(:action SHIP-ORDER-O6-N5-N6
:parameters ()
:precondition
(and
(STARTED-O6)
(MADE-P10)
(MADE-P8)
(MADE-P7)
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(SHIPPED-O6)
(not (STACKS-AVAIL-N5))
(not (STARTED-O6))
)
)
(:action SHIP-ORDER-O6-N4-N5
:parameters ()
:precondition
(and
(STARTED-O6)
(MADE-P10)
(MADE-P8)
(MADE-P7)
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(SHIPPED-O6)
(not (STACKS-AVAIL-N4))
(not (STARTED-O6))
)
)
(:action SHIP-ORDER-O6-N3-N4
:parameters ()
:precondition
(and
(STARTED-O6)
(MADE-P10)
(MADE-P8)
(MADE-P7)
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(SHIPPED-O6)
(not (STACKS-AVAIL-N3))
(not (STARTED-O6))
)
)
(:action SHIP-ORDER-O6-N2-N3
:parameters ()
:precondition
(and
(STARTED-O6)
(MADE-P10)
(MADE-P8)
(MADE-P7)
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(SHIPPED-O6)
(not (STACKS-AVAIL-N2))
(not (STARTED-O6))
)
)
(:action SHIP-ORDER-O6-N1-N2
:parameters ()
:precondition
(and
(STARTED-O6)
(MADE-P10)
(MADE-P8)
(MADE-P7)
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(SHIPPED-O6)
(not (STACKS-AVAIL-N1))
(not (STARTED-O6))
)
)
(:action SHIP-ORDER-O6-N0-N1
:parameters ()
:precondition
(and
(STARTED-O6)
(MADE-P10)
(MADE-P8)
(MADE-P7)
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(SHIPPED-O6)
(not (STACKS-AVAIL-N0))
(not (STARTED-O6))
)
)
(:action SHIP-ORDER-O5-N9-N10
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P6)
(MADE-P5)
(MADE-P2)
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(SHIPPED-O5)
(not (STACKS-AVAIL-N9))
(not (STARTED-O5))
)
)
(:action SHIP-ORDER-O5-N8-N9
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P6)
(MADE-P5)
(MADE-P2)
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(SHIPPED-O5)
(not (STACKS-AVAIL-N8))
(not (STARTED-O5))
)
)
(:action SHIP-ORDER-O5-N7-N8
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P6)
(MADE-P5)
(MADE-P2)
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(SHIPPED-O5)
(not (STACKS-AVAIL-N7))
(not (STARTED-O5))
)
)
(:action SHIP-ORDER-O5-N6-N7
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P6)
(MADE-P5)
(MADE-P2)
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(SHIPPED-O5)
(not (STACKS-AVAIL-N6))
(not (STARTED-O5))
)
)
(:action SHIP-ORDER-O5-N5-N6
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P6)
(MADE-P5)
(MADE-P2)
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(SHIPPED-O5)
(not (STACKS-AVAIL-N5))
(not (STARTED-O5))
)
)
(:action SHIP-ORDER-O5-N4-N5
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P6)
(MADE-P5)
(MADE-P2)
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(SHIPPED-O5)
(not (STACKS-AVAIL-N4))
(not (STARTED-O5))
)
)
(:action SHIP-ORDER-O5-N3-N4
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P6)
(MADE-P5)
(MADE-P2)
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(SHIPPED-O5)
(not (STACKS-AVAIL-N3))
(not (STARTED-O5))
)
)
(:action SHIP-ORDER-O5-N2-N3
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P6)
(MADE-P5)
(MADE-P2)
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(SHIPPED-O5)
(not (STACKS-AVAIL-N2))
(not (STARTED-O5))
)
)
(:action SHIP-ORDER-O5-N1-N2
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P6)
(MADE-P5)
(MADE-P2)
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(SHIPPED-O5)
(not (STACKS-AVAIL-N1))
(not (STARTED-O5))
)
)
(:action SHIP-ORDER-O5-N0-N1
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P6)
(MADE-P5)
(MADE-P2)
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(SHIPPED-O5)
(not (STACKS-AVAIL-N0))
(not (STARTED-O5))
)
)
(:action SHIP-ORDER-O4-N9-N10
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P10)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(SHIPPED-O4)
(not (STACKS-AVAIL-N9))
(not (STARTED-O4))
)
)
(:action SHIP-ORDER-O4-N8-N9
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P10)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(SHIPPED-O4)
(not (STACKS-AVAIL-N8))
(not (STARTED-O4))
)
)
(:action SHIP-ORDER-O4-N7-N8
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P10)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(SHIPPED-O4)
(not (STACKS-AVAIL-N7))
(not (STARTED-O4))
)
)
(:action SHIP-ORDER-O4-N6-N7
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P10)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(SHIPPED-O4)
(not (STACKS-AVAIL-N6))
(not (STARTED-O4))
)
)
(:action SHIP-ORDER-O4-N5-N6
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P10)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(SHIPPED-O4)
(not (STACKS-AVAIL-N5))
(not (STARTED-O4))
)
)
(:action SHIP-ORDER-O4-N4-N5
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P10)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(SHIPPED-O4)
(not (STACKS-AVAIL-N4))
(not (STARTED-O4))
)
)
(:action SHIP-ORDER-O4-N3-N4
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P10)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(SHIPPED-O4)
(not (STACKS-AVAIL-N3))
(not (STARTED-O4))
)
)
(:action SHIP-ORDER-O4-N2-N3
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P10)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(SHIPPED-O4)
(not (STACKS-AVAIL-N2))
(not (STARTED-O4))
)
)
(:action SHIP-ORDER-O4-N1-N2
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P10)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(SHIPPED-O4)
(not (STACKS-AVAIL-N1))
(not (STARTED-O4))
)
)
(:action SHIP-ORDER-O4-N0-N1
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P10)
(MADE-P4)
(MADE-P3)
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(SHIPPED-O4)
(not (STACKS-AVAIL-N0))
(not (STARTED-O4))
)
)
(:action SHIP-ORDER-O3-N9-N10
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P8)
(MADE-P2)
(MADE-P1)
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(SHIPPED-O3)
(not (STACKS-AVAIL-N9))
(not (STARTED-O3))
)
)
(:action SHIP-ORDER-O3-N8-N9
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P8)
(MADE-P2)
(MADE-P1)
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(SHIPPED-O3)
(not (STACKS-AVAIL-N8))
(not (STARTED-O3))
)
)
(:action SHIP-ORDER-O3-N7-N8
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P8)
(MADE-P2)
(MADE-P1)
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(SHIPPED-O3)
(not (STACKS-AVAIL-N7))
(not (STARTED-O3))
)
)
(:action SHIP-ORDER-O3-N6-N7
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P8)
(MADE-P2)
(MADE-P1)
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(SHIPPED-O3)
(not (STACKS-AVAIL-N6))
(not (STARTED-O3))
)
)
(:action SHIP-ORDER-O3-N5-N6
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P8)
(MADE-P2)
(MADE-P1)
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(SHIPPED-O3)
(not (STACKS-AVAIL-N5))
(not (STARTED-O3))
)
)
(:action SHIP-ORDER-O3-N4-N5
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P8)
(MADE-P2)
(MADE-P1)
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(SHIPPED-O3)
(not (STACKS-AVAIL-N4))
(not (STARTED-O3))
)
)
(:action SHIP-ORDER-O3-N3-N4
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P8)
(MADE-P2)
(MADE-P1)
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(SHIPPED-O3)
(not (STACKS-AVAIL-N3))
(not (STARTED-O3))
)
)
(:action SHIP-ORDER-O3-N2-N3
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P8)
(MADE-P2)
(MADE-P1)
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(SHIPPED-O3)
(not (STACKS-AVAIL-N2))
(not (STARTED-O3))
)
)
(:action SHIP-ORDER-O3-N1-N2
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P8)
(MADE-P2)
(MADE-P1)
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(SHIPPED-O3)
(not (STACKS-AVAIL-N1))
(not (STARTED-O3))
)
)
(:action SHIP-ORDER-O3-N0-N1
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P8)
(MADE-P2)
(MADE-P1)
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(SHIPPED-O3)
(not (STACKS-AVAIL-N0))
(not (STARTED-O3))
)
)
(:action SHIP-ORDER-O2-N9-N10
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P9)
(MADE-P8)
(MADE-P2)
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(SHIPPED-O2)
(not (STACKS-AVAIL-N9))
(not (STARTED-O2))
)
)
(:action SHIP-ORDER-O2-N8-N9
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P9)
(MADE-P8)
(MADE-P2)
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(SHIPPED-O2)
(not (STACKS-AVAIL-N8))
(not (STARTED-O2))
)
)
(:action SHIP-ORDER-O2-N7-N8
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P9)
(MADE-P8)
(MADE-P2)
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(SHIPPED-O2)
(not (STACKS-AVAIL-N7))
(not (STARTED-O2))
)
)
(:action SHIP-ORDER-O2-N6-N7
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P9)
(MADE-P8)
(MADE-P2)
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(SHIPPED-O2)
(not (STACKS-AVAIL-N6))
(not (STARTED-O2))
)
)
(:action SHIP-ORDER-O2-N5-N6
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P9)
(MADE-P8)
(MADE-P2)
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(SHIPPED-O2)
(not (STACKS-AVAIL-N5))
(not (STARTED-O2))
)
)
(:action SHIP-ORDER-O2-N4-N5
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P9)
(MADE-P8)
(MADE-P2)
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(SHIPPED-O2)
(not (STACKS-AVAIL-N4))
(not (STARTED-O2))
)
)
(:action SHIP-ORDER-O2-N3-N4
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P9)
(MADE-P8)
(MADE-P2)
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(SHIPPED-O2)
(not (STACKS-AVAIL-N3))
(not (STARTED-O2))
)
)
(:action SHIP-ORDER-O2-N2-N3
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P9)
(MADE-P8)
(MADE-P2)
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(SHIPPED-O2)
(not (STACKS-AVAIL-N2))
(not (STARTED-O2))
)
)
(:action SHIP-ORDER-O2-N1-N2
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P9)
(MADE-P8)
(MADE-P2)
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(SHIPPED-O2)
(not (STACKS-AVAIL-N1))
(not (STARTED-O2))
)
)
(:action SHIP-ORDER-O2-N0-N1
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P9)
(MADE-P8)
(MADE-P2)
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(SHIPPED-O2)
(not (STACKS-AVAIL-N0))
(not (STARTED-O2))
)
)
(:action SHIP-ORDER-O1-N9-N10
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P9)
(MADE-P6)
(MADE-P1)
(STACKS-AVAIL-N9)
)
:effect
(and
(STACKS-AVAIL-N10)
(SHIPPED-O1)
(not (STACKS-AVAIL-N9))
(not (STARTED-O1))
)
)
(:action SHIP-ORDER-O1-N8-N9
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P9)
(MADE-P6)
(MADE-P1)
(STACKS-AVAIL-N8)
)
:effect
(and
(STACKS-AVAIL-N9)
(SHIPPED-O1)
(not (STACKS-AVAIL-N8))
(not (STARTED-O1))
)
)
(:action SHIP-ORDER-O1-N7-N8
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P9)
(MADE-P6)
(MADE-P1)
(STACKS-AVAIL-N7)
)
:effect
(and
(STACKS-AVAIL-N8)
(SHIPPED-O1)
(not (STACKS-AVAIL-N7))
(not (STARTED-O1))
)
)
(:action SHIP-ORDER-O1-N6-N7
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P9)
(MADE-P6)
(MADE-P1)
(STACKS-AVAIL-N6)
)
:effect
(and
(STACKS-AVAIL-N7)
(SHIPPED-O1)
(not (STACKS-AVAIL-N6))
(not (STARTED-O1))
)
)
(:action SHIP-ORDER-O1-N5-N6
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P9)
(MADE-P6)
(MADE-P1)
(STACKS-AVAIL-N5)
)
:effect
(and
(STACKS-AVAIL-N6)
(SHIPPED-O1)
(not (STACKS-AVAIL-N5))
(not (STARTED-O1))
)
)
(:action SHIP-ORDER-O1-N4-N5
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P9)
(MADE-P6)
(MADE-P1)
(STACKS-AVAIL-N4)
)
:effect
(and
(STACKS-AVAIL-N5)
(SHIPPED-O1)
(not (STACKS-AVAIL-N4))
(not (STARTED-O1))
)
)
(:action SHIP-ORDER-O1-N3-N4
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P9)
(MADE-P6)
(MADE-P1)
(STACKS-AVAIL-N3)
)
:effect
(and
(STACKS-AVAIL-N4)
(SHIPPED-O1)
(not (STACKS-AVAIL-N3))
(not (STARTED-O1))
)
)
(:action SHIP-ORDER-O1-N2-N3
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P9)
(MADE-P6)
(MADE-P1)
(STACKS-AVAIL-N2)
)
:effect
(and
(STACKS-AVAIL-N3)
(SHIPPED-O1)
(not (STACKS-AVAIL-N2))
(not (STARTED-O1))
)
)
(:action SHIP-ORDER-O1-N1-N2
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P9)
(MADE-P6)
(MADE-P1)
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(SHIPPED-O1)
(not (STACKS-AVAIL-N1))
(not (STARTED-O1))
)
)
(:action SHIP-ORDER-O1-N0-N1
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P9)
(MADE-P6)
(MADE-P1)
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(SHIPPED-O1)
(not (STACKS-AVAIL-N0))
(not (STARTED-O1))
)
)
(:action MAKE-PRODUCT-P10-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N2)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P10-N1
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N1)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P10-N0
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P10)
(STARTED-O8)
(STARTED-O6)
(STARTED-O4)
(STACKS-AVAIL-N0)
)
:effect
(and
(MADE-P10)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P10))
(not (MACHINE-CONFIGURED-P10))
)
)
(:action MAKE-PRODUCT-P9-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N2)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P9-N1
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N1)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P9-N0
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P9)
(STARTED-O9)
(STARTED-O2)
(STARTED-O1)
(STACKS-AVAIL-N0)
)
:effect
(and
(MADE-P9)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P9))
(not (MACHINE-CONFIGURED-P9))
)
)
(:action MAKE-PRODUCT-P8-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N2)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P8-N1
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N1)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P8-N0
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P8)
(STARTED-O6)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N0)
)
:effect
(and
(MADE-P8)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P8))
(not (MACHINE-CONFIGURED-P8))
)
)
(:action MAKE-PRODUCT-P7-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N2)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P7-N1
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N1)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P7-N0
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P7)
(STARTED-O9)
(STARTED-O7)
(STARTED-O6)
(STACKS-AVAIL-N0)
)
:effect
(and
(MADE-P7)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P7))
(not (MACHINE-CONFIGURED-P7))
)
)
(:action MAKE-PRODUCT-P6-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N2)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P6-N1
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N1)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P6-N0
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P6)
(STARTED-O10)
(STARTED-O5)
(STARTED-O1)
(STACKS-AVAIL-N0)
)
:effect
(and
(MADE-P6)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P6))
(not (MACHINE-CONFIGURED-P6))
)
)
(:action MAKE-PRODUCT-P5-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N2)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P5-N1
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N1)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P5-N0
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O10)
(STARTED-O8)
(STARTED-O5)
(STACKS-AVAIL-N0)
)
:effect
(and
(MADE-P5)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P5))
(not (MACHINE-CONFIGURED-P5))
)
)
(:action MAKE-PRODUCT-P4-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N2)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P4-N1
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N1)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P4-N0
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O9)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N0)
)
:effect
(and
(MADE-P4)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P4))
(not (MACHINE-CONFIGURED-P4))
)
)
(:action MAKE-PRODUCT-P3-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N2)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P3-N1
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N1)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P3-N0
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O8)
(STARTED-O7)
(STARTED-O4)
(STACKS-AVAIL-N0)
)
:effect
(and
(MADE-P3)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P3))
(not (MACHINE-CONFIGURED-P3))
)
)
(:action MAKE-PRODUCT-P2-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N2)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P2-N1
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N1)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P2-N0
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O5)
(STARTED-O3)
(STARTED-O2)
(STACKS-AVAIL-N0)
)
:effect
(and
(MADE-P2)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P2))
(not (MACHINE-CONFIGURED-P2))
)
)
(:action MAKE-PRODUCT-P1-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N2)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action MAKE-PRODUCT-P1-N1
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N1)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action MAKE-PRODUCT-P1-N0
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O10)
(STARTED-O3)
(STARTED-O1)
(STACKS-AVAIL-N0)
)
:effect
(and
(MADE-P1)
(MACHINE-AVAILABLE-)
(not (NOT-MADE-P1))
(not (MACHINE-CONFIGURED-P1))
)
)
(:action OPEN-NEW-STACK-N1-N2
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
)
:effect
(and
(STACKS-AVAIL-N2)
(not (STACKS-AVAIL-N1))
)
)
(:action START-ORDER-O10-N1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(WAITING-O10)
)
:effect
(and
(STARTED-O10)
(STACKS-AVAIL-N0)
(not (WAITING-O10))
(not (STACKS-AVAIL-N1))
)
)
(:action START-ORDER-O9-N1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(WAITING-O9)
)
:effect
(and
(STARTED-O9)
(STACKS-AVAIL-N0)
(not (WAITING-O9))
(not (STACKS-AVAIL-N1))
)
)
(:action START-ORDER-O8-N1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(WAITING-O8)
)
:effect
(and
(STARTED-O8)
(STACKS-AVAIL-N0)
(not (WAITING-O8))
(not (STACKS-AVAIL-N1))
)
)
(:action START-ORDER-O7-N1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(WAITING-O7)
)
:effect
(and
(STARTED-O7)
(STACKS-AVAIL-N0)
(not (WAITING-O7))
(not (STACKS-AVAIL-N1))
)
)
(:action START-ORDER-O6-N1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(WAITING-O6)
)
:effect
(and
(STARTED-O6)
(STACKS-AVAIL-N0)
(not (WAITING-O6))
(not (STACKS-AVAIL-N1))
)
)
(:action START-ORDER-O5-N1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(WAITING-O5)
)
:effect
(and
(STARTED-O5)
(STACKS-AVAIL-N0)
(not (WAITING-O5))
(not (STACKS-AVAIL-N1))
)
)
(:action START-ORDER-O4-N1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(WAITING-O4)
)
:effect
(and
(STARTED-O4)
(STACKS-AVAIL-N0)
(not (WAITING-O4))
(not (STACKS-AVAIL-N1))
)
)
(:action START-ORDER-O3-N1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(WAITING-O3)
)
:effect
(and
(STARTED-O3)
(STACKS-AVAIL-N0)
(not (WAITING-O3))
(not (STACKS-AVAIL-N1))
)
)
(:action START-ORDER-O2-N1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(WAITING-O2)
)
:effect
(and
(STARTED-O2)
(STACKS-AVAIL-N0)
(not (WAITING-O2))
(not (STACKS-AVAIL-N1))
)
)
(:action START-ORDER-O1-N1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(WAITING-O1)
)
:effect
(and
(STARTED-O1)
(STACKS-AVAIL-N0)
(not (WAITING-O1))
(not (STACKS-AVAIL-N1))
)
)
(:action SETUP-MACHINE-P10-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N1)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
(:action OPEN-NEW-STACK-N0-N1
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
)
:effect
(and
(STACKS-AVAIL-N1)
(not (STACKS-AVAIL-N0))
)
)
(:action SETUP-MACHINE-P10-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
(NOT-MADE-P10)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P10)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P9-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
(NOT-MADE-P9)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P9)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P8-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
(NOT-MADE-P8)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P8)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P7-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
(NOT-MADE-P7)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P7)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P6-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
(NOT-MADE-P6)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P6)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P5-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
(NOT-MADE-P5)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P5)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P4-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
(NOT-MADE-P4)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P4)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P3-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
(NOT-MADE-P3)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P3)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P2-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
(NOT-MADE-P2)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P2)
(not (MACHINE-AVAILABLE-))
)
)
(:action SETUP-MACHINE-P1-N0
:parameters ()
:precondition
(and
(STACKS-AVAIL-N0)
(NOT-MADE-P1)
(MACHINE-AVAILABLE-)
)
:effect
(and
(MACHINE-CONFIGURED-P1)
(not (MACHINE-AVAILABLE-))
)
)
)
