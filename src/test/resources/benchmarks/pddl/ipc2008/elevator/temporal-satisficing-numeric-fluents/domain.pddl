(define (domain elevators-time-numeric)
  (:requirements :typing :durative-actions :numeric-fluents)
  (:types 	elevator - object 
			slow-elevator fast-elevator - elevator
   			passenger - object
          	floor - object
         )

(:predicates 
	(passenger-at ?person - passenger ?floor - floor)
	(boarded ?person - passenger ?lift - elevator)
	(lift-at ?lift - elevator ?floor - floor)
	(reachable-floor ?lift - elevator ?floor - floor)
	(above ?floor1 - floor ?floor2 - floor)
)

(:functions 
            (travel-slow ?f1 - floor ?f2 - floor) - number
            (travel-fast ?f1 - floor ?f2 - floor) - number 
			(passengers ?lift - elevator) - number
			(capacity ?lift - elevator) - number
)

(:durative-action move-up-slow
  :parameters (?lift - slow-elevator ?f1 - floor ?f2 - floor )
  :duration (= ?duration (travel-slow ?f1 ?f2))
  :condition (and (at start (lift-at ?lift ?f1)) (at start (above ?f1 ?f2)) (at start (reachable-floor ?lift ?f2)) )
  :effect (and (at end (lift-at ?lift ?f2)) (at start (not (lift-at ?lift ?f1))) ))

(:durative-action move-down-slow
  :parameters (?lift - slow-elevator ?f1 - floor ?f2 - floor )
  :duration (= ?duration (travel-slow ?f2 ?f1))
  :condition (and (at start (lift-at ?lift ?f1)) (at start (above ?f2 ?f1)) (at start (reachable-floor ?lift ?f2)) )
  :effect (and (at end (lift-at ?lift ?f2)) (at start (not (lift-at ?lift ?f1))) ))

(:durative-action move-up-fast
  :parameters (?lift - fast-elevator ?f1 - floor ?f2 - floor )
  :duration (= ?duration (travel-fast ?f1 ?f2))
  :condition (and (at start (lift-at ?lift ?f1)) (at start (above ?f1 ?f2)) (at start (reachable-floor ?lift ?f2)) )
  :effect (and (at end (lift-at ?lift ?f2)) (at start (not (lift-at ?lift ?f1))) ))

(:durative-action move-down-fast
  :parameters (?lift - fast-elevator ?f1 - floor ?f2 - floor )
  :duration (= ?duration (travel-fast ?f2 ?f1))
  :condition (and (at start (lift-at ?lift ?f1)) (at start (above ?f2 ?f1)) (at start (reachable-floor ?lift ?f2)) )
  :effect (and (at end (lift-at ?lift ?f2)) (at start (not (lift-at ?lift ?f1))) ))

(:durative-action board
  :parameters (?p - passenger ?lift - elevator ?f - floor)
  :duration (= ?duration 1)
  :condition (and  (over all (lift-at ?lift ?f)) (at start (passenger-at ?p ?f))  (at start (< (passengers ?lift) (capacity ?lift))) )
  :effect (and (at start (not (passenger-at ?p ?f))) (at end (boarded ?p ?lift)) (at start (increase (passengers ?lift) 1)) ))

(:durative-action leave 
  :parameters (?p - passenger ?lift - elevator ?f - floor)
  :duration (= ?duration 1)
  :condition (and  (over all (lift-at ?lift ?f)) (at start (boarded ?p ?lift)) )
  :effect (and (at end (passenger-at ?p ?f)) (at start (not (boarded ?p ?lift))) (at end (decrease (passengers ?lift) 1)) ))
  
)
