; IPC5 Domain: Trucks Time-TIL
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain Trucks-TimeTIL)
(:requirements :typing :adl :durative-actions :numeric-fluents :timed-initial-literals)
(:types truckarea location locatable - object
        truck package - locatable)

(:predicates (at ?x - locatable ?l - location)
             (in ?p - package ?t - truck ?a - truckarea)
             (connected ?x ?y - location)
             (free ?a - truckarea ?t - truck)
 	     (delivered ?p - package ?l - location)
	     (at-destination ?p - package ?l - location)
 	     (closer ?a1 - truckarea ?a2 - truckarea)
	     (deliverable ?p - package ?l - location))

(:functions (drive-time ?from ?to - location))

(:durative-action load
 :parameters (?p - package ?t - truck ?a1 - truckarea ?l - location)
 :duration (= ?duration 1)
 :condition (and (at start (at ?p ?l)) (at start (free ?a1 ?t))
  		 (at start (forall (?a2 - truckarea)
  			      (imply (closer ?a2 ?a1) (free ?a2 ?t))))
	         (over all (at ?t ?l))
  		 (over all (forall (?a2 - truckarea)
  			      (imply (closer ?a2 ?a1) (free ?a2 ?t)))))
 :effect (and (at start (not (at ?p ?l))) (at start (not (free ?a1 ?t)))
  	 (at end (in ?p ?t ?a1))))

(:durative-action unload
 :parameters (?p - package ?t - truck ?a1 - truckarea ?l - location)
 :duration (= ?duration 1)
 :condition (and (at start (in ?p ?t ?a1))
  		 (at start (forall (?a2 - truckarea)
  			      (imply (closer ?a2 ?a1) (free ?a2 ?t))))
	         (over all (at ?t ?l))
  		 (over all (forall (?a2 - truckarea)
  			      (imply (closer ?a2 ?a1) (free ?a2 ?t)))))
 :effect (and (at start (not (in ?p ?t ?a1))) (at end (free ?a1 ?t))
   	      (at end (at ?p ?l))))

(:durative-action drive
 :parameters (?t - truck ?from ?to - location)
 :duration (= ?duration (drive-time ?from ?to))
 :condition (and (at start (at ?t ?from)) (over all (connected ?from ?to)))
 :effect (and (at start (not (at ?t ?from))) (at end (at ?t ?to))))

(:durative-action deliver-ontime
 :parameters (?p - package ?l - location)
 :duration (= ?duration 1)
 :condition (and (over all (at ?p ?l)) (at end (deliverable ?p ?l)))
 :effect (and (at end (not (at ?p ?l))) (at end (delivered ?p ?l))
	      (at end (at-destination ?p ?l))))

(:durative-action deliver-anytime
 :parameters (?p - package ?l - location)
 :duration (= ?duration 1)
 :condition (and (at start (at ?p ?l)) (over all (at ?p ?l)))
 :effect (and (at end (not (at ?p ?l))) (at end (at-destination ?p ?l))))
)

