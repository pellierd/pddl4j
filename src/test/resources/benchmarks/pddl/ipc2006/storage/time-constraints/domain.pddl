; IPC5 Domain: Storage TimeConstraints
; Authors: Alfonso Gerevini and Alessandro Saetti

(define (domain Storage-TimeConstraints)
(:requirements :typing :adl :durative-actions :constraints)
(:types hoist surface place area - object
	container depot - place
	storearea transitarea - area
	area crate - surface)

(:constants loadarea - transitarea)

(:predicates (clear ?s - storearea)
	     (in ?x - (either storearea crate) ?p - place)
	     (available ?h - hoist)
	     (lifting ?h - hoist ?c - crate)
	     (at ?h - hoist ?a - area)
	     (on ?c - crate ?s - storearea)
	     (connected ?a1 ?a2 - area)
	     (compatible ?c1 ?c2 - crate))

(:constraints (and

	      (forall (?h - hoist)
		 (at end (exists (?d - depot ?s - storearea)
				 (and (at ?h ?s) (in ?s ?d)))))

	      (forall (?h - hoist)
	         (sometime (exists (?c - crate) (lifting ?h ?c))))

	      (forall (?c1 ?c2 - crate ?s1 ?s2 - storearea)
	        (always (imply (and (on ?c1 ?s1) (on ?c2 ?s2)
				    (connected ?s1 ?s2) (not (= ?c1 ?c2)))
		               (compatible ?c1 ?c2))))))

(:durative-action lift
 :parameters (?h - hoist ?c - crate ?a1 - storearea ?a2 - area ?p - place)
 :duration (= ?duration 2)
 :condition (and (at start (available ?h)) (at start (on ?c ?a1))
		 (over all (connected ?a1 ?a2)) (over all (at ?h ?a2))
		 (over all (in ?a1 ?p)))
 :effect (and (at start (not (in ?c ?p))) (at start (not (available ?h)))
	      (at start (lifting ?h ?c)) (at start (not (on ?c ?a1)))
	      (at end (clear ?a1))))

(:durative-action drop
 :parameters (?h - hoist ?c - crate ?a1 - storearea ?a2 - area ?p - place)
 :duration (= ?duration 2)
 :condition (and (at start (clear ?a1)) (over all (lifting ?h ?c))
		 (over all (connected ?a1 ?a2)) (over all (at ?h ?a2))
		 (over all (in ?a1 ?p)))
 :effect (and (at start (not (clear ?a1))) (at end (not (lifting ?h ?c)))
	      (at end (available ?h)) (at end (on ?c ?a1))
	      (at end (in ?c ?p))))

(:durative-action move
 :parameters (?h - hoist ?from ?to - storearea)
 :duration (= ?duration 1)
 :condition (and (at start (at ?h ?from)) (at start (clear ?to))
		 (over all (connected ?from ?to)))
 :effect (and (at start (not (at ?h ?from))) (at start (not (clear ?to)))
	      (at start (clear ?from)) (at end (at ?h ?to))))

(:durative-action go-out
 :parameters (?h - hoist ?from - storearea ?to - transitarea)
 :duration (= ?duration 1)
 :condition (and (at start (at ?h ?from)) (over all (connected ?from ?to)))
 :effect (and (at start (not (at ?h ?from))) (at start (clear ?from))
	      (at end (at ?h ?to))))

(:durative-action go-in
 :parameters (?h - hoist ?from - transitarea ?to - storearea)
 :duration (= ?duration 1)
 :condition (and (at start (at ?h ?from)) (at start (clear ?to))
		 (over all (connected ?from ?to)))
 :effect (and (at start (not (at ?h ?from))) (at start (not (clear ?to)))
	      (at end (at ?h ?to))))
)


