; IPC5 Domain: TPP MetricTimeConstraints
; Authors: Alfonso Gerevini and Alessandro Saetti

(define (domain TPP-MetricTimeConstraints)
(:requirements :typing :adl :numeric-fluents :durative-actions :constraints)
(:types depot market - place
	truck goods - locatable)

(:predicates (connected ?p1 ?p2 - place)
	     (at ?t - truck ?p - place))

(:functions (on-sale ?g - goods ?m - market)
	    (ready-to-load ?g -goods ?m - place)
	    (drive-cost ?p1 ?p2 - place)
	    (drive-time ?p1 ?p2 - place)
	    (loaded ?g - goods ?t - truck)
	    (stored ?g - goods)
	    (price ?g - goods ?m - market)
	    (bought ?g - goods)
	    (request ?g - goods)
	    (total-cost)
	    (rebate-rate ?m - market))

(:constraints (and

        (forall (?m - market ?g - goods) (at end (= (ready-to-load ?g ?m) 0)))

        (forall (?t - truck ?g - goods) (at end (= (loaded ?g ?t) 0)))

        (forall (?m - market ?t1 ?t2 - truck)
           (always (imply (and (at ?t1 ?m) (at ?t2 ?m)) (= ?t1 ?t2))))

        (forall (?t - truck)
	   (sometime (exists (?g - goods) (> (loaded ?g ?t) 0))))
))

(:durative-action drive
 :parameters (?t - truck ?from ?to - place)
 :duration (= ?duration (drive-time ?from ?to))
 :condition (and (at start (at ?t ?from)) (over all (connected ?from ?to)))
 :effect (and (at start (not (at ?t ?from))) (at end (at ?t ?to))
	      (at end (increase (total-cost) (drive-cost ?from ?to)))))

(:durative-action load
 :parameters (?g - goods ?t - truck ?m - market)
 :duration (= ?duration (* 1.0 (ready-to-load ?g ?m)))
 :condition (and (at start (> (ready-to-load ?g ?m) 0)) (over all (at ?t ?m)))
 :effect (and (at start (increase (loaded ?g ?t) (ready-to-load ?g ?m)))
	      (at start (assign (ready-to-load ?g ?m) 0))))

(:durative-action unload
 :parameters (?t - truck ?g - goods ?d - depot)
 :duration (= ?duration (* 1.0 (loaded ?g ?t)))
 :condition (and (at start (> (loaded ?g ?t) 0)) (over all (at ?t ?d)))
 :effect (and (at start (increase (stored ?g) (loaded ?g ?t)))
	      (at start (assign (loaded ?g ?t) 0))))

(:durative-action buy-allneeded
 :parameters (?t - truck ?g - goods ?m - market)
 :duration (= ?duration 1.0)
 :condition (and (at start (> (on-sale ?g ?m) (- (request ?g) (bought ?g))))
		 (at start (> (on-sale ?g ?m) 0)) (over all (at ?t ?m)))
 :effect (and (at start (decrease (on-sale ?g ?m)
				  (- (request ?g) (bought ?g))))
	     (at start (increase (ready-to-load ?g ?m)
				 (- (request ?g) (bought ?g))))
	     (at start (increase (total-cost) (* (- (request ?g) (bought ?g))
						 (price ?g ?m))))
	     (at start (assign (bought ?g) (request ?g)))))

(:durative-action buy-all
 :parameters (?t - truck ?g - goods ?m - market)
 :duration (= ?duration 1.0)
 :condition (and (at start (> (on-sale ?g ?m) 0)) (over all (at ?t ?m)))
 :effect (and (at start (assign (on-sale ?g ?m) 0))
	      (at start (increase (ready-to-load ?g ?m) (on-sale ?g ?m)))
	      (at start (increase (total-cost) (* (rebate-rate ?m)
				          (* (on-sale ?g ?m) (price ?g ?m)))))
	      (at start (increase (bought ?g) (on-sale ?g ?m)))))
)
