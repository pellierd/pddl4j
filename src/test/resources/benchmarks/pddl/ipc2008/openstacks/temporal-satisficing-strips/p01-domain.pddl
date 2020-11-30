(define (domain openstacks-time-nonADL-nonNegated)
(:requirements :typing :durative-actions)
(:types order product count)
(:constants 
 p1 p2 p3 p4 p5 - product
 o1 o2 o3 o4 o5 - order
)

(:predicates 
	(includes ?o - order ?p - product)
	(waiting ?o - order)
	(started ?o - order)
	(shipped ?o - order)
	(made ?p - product)
	(not-made ?p - product)
	(stacks-avail ?s - count)
	(next-count ?s ?ns - count)
)

(:durative-action start-order
:parameters (?o - order ?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (waiting ?o))(at start (stacks-avail ?avail))(at start (next-count ?new-avail ?avail)))
:effect (and (at start (not (waiting ?o)))(at end (started ?o))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail)))
)

(:durative-action make-product-p1
:parameters ()
:duration (= ?duration 40)
:condition (and (at start (not-made p1))(at start (started o2)))
:effect (and (at start (not (not-made p1))) (at end (made p1)))
)

(:durative-action make-product-p2
:parameters ()
:duration (= ?duration 50)
:condition (and (at start (not-made p2))(at start (started o1))(at start (started o2)))
:effect (and (at start (not (not-made p2))) (at end (made p2)))
)

(:durative-action make-product-p3
:parameters ()
:duration (= ?duration 80)
:condition (and (at start (not-made p3))(at start (started o3))(at start (started o4)))
:effect (and (at start (not (not-made p3))) (at end (made p3)))
)

(:durative-action make-product-p4
:parameters ()
:duration (= ?duration 40)
:condition (and (at start (not-made p4))(at start (started o4)))
:effect (and (at start (not (not-made p4))) (at end (made p4)))
)

(:durative-action make-product-p5
:parameters ()
:duration (= ?duration 10)
:condition (and (at start (not-made p5))(at start (started o5)))
:effect (and (at start (not (not-made p5))) (at end (made p5)))
)

(:durative-action ship-order-o1
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o1))(at start (made p2))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o1)))(at end (shipped o1))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o2
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o2))(at start (made p1))(at start (made p2))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o2)))(at end (shipped o2))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o3
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o3))(at start (made p3))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o3)))(at end (shipped o3))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o4
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o4))(at start (made p3))(at start (made p4))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o4)))(at end (shipped o4))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

(:durative-action ship-order-o5
:parameters (?avail ?new-avail - count)
:duration (= ?duration 1)
:condition (and (at start (started o5))(at start (made p5))(at start (stacks-avail ?avail))(at start (next-count ?avail ?new-avail)))
:effect (and (at start (not (started o5)))(at end (shipped o5))(at start (not (stacks-avail ?avail)))(at end (stacks-avail ?new-avail))))

)

