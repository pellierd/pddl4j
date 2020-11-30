; IPC5 Domain: Openstacks Time -- minimal makespan version with fixed number of stacks
; Author: Patrik Haslum
; The problem instances for this domain were adapted from the problem
; collection of the 2005 Constraint Modelling Challenge, organized by
; Barbara Smith & Ian Gent (see http://www.dcs.st-and.ac.uk/~ipg/challenge/).

(define (domain openstacks-time)
  (:requirements :typing :adl :numeric-fluents :durative-actions)
  (:types order product count)
  (:predicates (includes ?o - order ?p - product)
	       (waiting ?o - order)
	       (started ?o - order)
	       (shipped ?o - order)
	       (made ?p - product)
	       (stacks-avail ?s - count)
	       (next-count ?s ?ns - count))

  (:functions (make-time ?p - product))

  (:durative-action make-product
    :parameters (?p - product)
    :duration (= ?duration (make-time ?p))
    :condition (and (at start (not (made ?p)))
		    (at start (forall (?o - order)
				 (imply (includes ?o ?p) (started ?o)))))
    :effect (at end (made ?p))
    )

  (:durative-action start-order
    :parameters (?o - order ?avail ?new-avail - count)
    :duration (= ?duration 1)
    :condition (and (at start (waiting ?o))
		    (at start (stacks-avail ?avail))
		    (at start (next-count ?new-avail ?avail)))
    :effect (and (at start (not (waiting ?o)))
		 (at end (started ?o))
		 (at start (not (stacks-avail ?avail)))
		 (at end (stacks-avail ?new-avail)))
    )

  (:durative-action ship-order
    :parameters (?o - order ?avail ?new-avail - count)
    :duration (= ?duration 1)
    :condition (and (at start (started ?o))
		    (at start (forall (?p - product)
				      (imply (includes ?o ?p)
					     (made ?p))))
		    (at start (stacks-avail ?avail))
		    (at start (next-count ?avail ?new-avail)))
    :effect (and (at start (not (started ?o)))
		 (at end (shipped ?o))
		 (at start (not (stacks-avail ?avail)))
		 (at end (stacks-avail ?new-avail)))
    )

  )
