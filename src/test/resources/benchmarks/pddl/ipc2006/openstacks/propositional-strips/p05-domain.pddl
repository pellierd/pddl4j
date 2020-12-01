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
(STACKS-AVAIL-N1)
(STARTED-O1)
(STARTED-O2)
(STARTED-O3)
(STARTED-O4)
(STARTED-O5)
(STACKS-AVAIL-N2)
(MADE-P1)
(MADE-P2)
(MADE-P3)
(MADE-P4)
(MADE-P5)
(SHIPPED-O1)
(STACKS-AVAIL-N3)
(STACKS-AVAIL-N4)
(STACKS-AVAIL-N5)
(SHIPPED-O2)
(SHIPPED-O3)
(SHIPPED-O4)
(SHIPPED-O5)
(NOT-MADE-P5)
(NOT-MADE-P4)
(NOT-MADE-P3)
(NOT-MADE-P2)
(NOT-MADE-P1)
(WAITING-O5)
(WAITING-O4)
(WAITING-O3)
(WAITING-O2)
(WAITING-O1)
(MACHINE-AVAILABLE-)
(STACKS-AVAIL-N0)
)
(:action MAKE-PRODUCT-P5-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O4)
(STARTED-O3)
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
(STARTED-O4)
(STARTED-O3)
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
(STARTED-O4)
(STARTED-O3)
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
(:action MAKE-PRODUCT-P4-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P4)
(STARTED-O5)
(STARTED-O2)
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
(STARTED-O5)
(STARTED-O2)
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
(STARTED-O5)
(STARTED-O2)
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
(:action MAKE-PRODUCT-P3-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P3)
(STARTED-O3)
(STARTED-O2)
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
(STARTED-O3)
(STARTED-O2)
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
(STARTED-O3)
(STARTED-O2)
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
(:action MAKE-PRODUCT-P2-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P2)
(STARTED-O4)
(STARTED-O1)
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
(STARTED-O4)
(STARTED-O1)
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
(STARTED-O4)
(STARTED-O1)
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
(:action MAKE-PRODUCT-P1-N5
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P1)
(STARTED-O5)
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
(STARTED-O5)
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
(STARTED-O5)
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
(:action SHIP-ORDER-O5-N4-N5
:parameters ()
:precondition
(and
(STARTED-O5)
(MADE-P4)
(MADE-P1)
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
(MADE-P4)
(MADE-P1)
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
(MADE-P4)
(MADE-P1)
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
(MADE-P4)
(MADE-P1)
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
(MADE-P4)
(MADE-P1)
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
(:action SHIP-ORDER-O4-N4-N5
:parameters ()
:precondition
(and
(STARTED-O4)
(MADE-P5)
(MADE-P2)
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
(MADE-P5)
(MADE-P2)
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
(MADE-P5)
(MADE-P2)
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
(MADE-P5)
(MADE-P2)
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
(MADE-P5)
(MADE-P2)
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
(:action SHIP-ORDER-O3-N4-N5
:parameters ()
:precondition
(and
(STARTED-O3)
(MADE-P5)
(MADE-P3)
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
(MADE-P5)
(MADE-P3)
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
(MADE-P5)
(MADE-P3)
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
(MADE-P5)
(MADE-P3)
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
(MADE-P5)
(MADE-P3)
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
(:action SHIP-ORDER-O2-N4-N5
:parameters ()
:precondition
(and
(STARTED-O2)
(MADE-P4)
(MADE-P3)
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
(MADE-P4)
(MADE-P3)
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
(MADE-P4)
(MADE-P3)
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
(MADE-P4)
(MADE-P3)
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
(MADE-P4)
(MADE-P3)
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
(:action SHIP-ORDER-O1-N4-N5
:parameters ()
:precondition
(and
(STARTED-O1)
(MADE-P2)
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
(MADE-P2)
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
(MADE-P2)
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
(MADE-P2)
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
(MADE-P2)
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
(:action MAKE-PRODUCT-P5-N2
:parameters ()
:precondition
(and
(MACHINE-CONFIGURED-P5)
(STARTED-O4)
(STARTED-O3)
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
(STARTED-O4)
(STARTED-O3)
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
(STARTED-O4)
(STARTED-O3)
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
(STARTED-O5)
(STARTED-O2)
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
(STARTED-O5)
(STARTED-O2)
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
(STARTED-O5)
(STARTED-O2)
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
(STARTED-O3)
(STARTED-O2)
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
(STARTED-O3)
(STARTED-O2)
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
(STARTED-O3)
(STARTED-O2)
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
(STARTED-O4)
(STARTED-O1)
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
(STARTED-O4)
(STARTED-O1)
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
(STARTED-O4)
(STARTED-O1)
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
(STARTED-O5)
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
(STARTED-O5)
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
(STARTED-O5)
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
