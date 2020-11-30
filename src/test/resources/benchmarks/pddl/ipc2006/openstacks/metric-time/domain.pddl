; IPC5 Domain: Openstacks MetricTime
; Author: Patrik Haslum
; The problem instances for this domain were adapted from the problem
; collection of the 2005 Constraint Modelling Challenge, organized by
; Barbara Smith & Ian Gent (see http://www.dcs.st-and.ac.uk/~ipg/challenge/).

(define (domain openstacks-complex)
  (:requirements :typing :adl :numeric-fluents :durative-actions)
  (:types order product)
  (:predicates (includes ?o - order ?p - product)
	       (waiting ?o - order)
	       (started ?o - order)
	       (shipped ?o - order)
	       (made ?p - product))

  (:functions (make-time ?p - product)
	      (stacks-in-use)
	      (max-in-use))

  (:durative-action make-product
    :parameters (?p - product)
    :duration (= ?duration (make-time ?p))
    :condition (and (at start (not (made ?p)))
		    (at start (forall (?o - order)
				 (imply (includes ?o ?p) (started ?o)))))
    :effect (at end (made ?p))
    )

  (:durative-action start-order-1
    :parameters (?o - order)
    :duration (= ?duration 1)
    :condition (and (at start (waiting ?o))
		    (at start (< (stacks-in-use) (max-in-use))))
    :effect (and (at start (not (waiting ?o)))
		 (at end (started ?o))
		 (at start (increase (stacks-in-use) 1)))
    )

  (:durative-action start-order-2
    :parameters (?o - order)
    :duration (= ?duration 1)
    :condition (and (at start (waiting ?o))
		    (at start (>= (stacks-in-use) (max-in-use))))
    :effect (and (at start (not (waiting ?o)))
		 (at end (started ?o))
		 (at start (increase (stacks-in-use) 1))
		 (at start (increase (max-in-use) 1)))
    )

  (:durative-action ship-order
    :parameters (?o - order)
    :duration (= ?duration 1)
    :condition (and (at start (started ?o))
		    (at start
			(forall (?p - product)
				(imply (includes ?o ?p) (made ?p)))))
    :effect (and (at start (not (started ?o)))
		 (at end (shipped ?o))
		 (at end (decrease (stacks-in-use) 1)))
    )

  )
