(define (domain elevators-time)
  (:requirements :typing :durative-actions :numeric-fluents)
  (:types 	elevator - object
			slow-elevator fast-elevator - elevator
   			passenger - object
          	count - object
         )

(:predicates
	(passenger-at ?person - passenger ?floor - count)
	(boarded ?person - passenger ?lift - elevator)
	(lift-at ?lift - elevator ?floor - count)
	(reachable-floor ?lift - elevator ?floor - count)
	(above ?floor1 - count ?floor2 - count)
	(passengers ?lift - elevator ?n - count)
	(can-hold ?lift - elevator ?n - count)
	(next ?n1 - count ?n2 - count)
)

(:functions
            (travel-slow ?f1 - count ?f2 - count) - number
            (travel-fast ?f1 - count ?f2 - count) - number
)

(:durative-action move-up-slow
  :parameters (?lift - slow-elevator ?f1 - count ?f2 - count )
  :duration (= ?duration (travel-slow ?f1 ?f2))
  :condition (and (at start (lift-at ?lift ?f1)) (at start (above ?f1 ?f2)) (at start (reachable-floor ?lift ?f2)) )
  :effect (and (at end (lift-at ?lift ?f2)) (at start (not (lift-at ?lift ?f1))) ))

(:durative-action move-down-slow
  :parameters (?lift - slow-elevator ?f1 - count ?f2 - count )
  :duration (= ?duration (travel-slow ?f2 ?f1))
  :condition (and (at start (lift-at ?lift ?f1)) (at start (above ?f2 ?f1)) (at start (reachable-floor ?lift ?f2)) )
  :effect (and (at end (lift-at ?lift ?f2)) (at start (not (lift-at ?lift ?f1))) ))

(:durative-action move-up-fast
  :parameters (?lift - fast-elevator ?f1 - count ?f2 - count )
  :duration (= ?duration (travel-fast ?f1 ?f2))
  :condition (and (at start (lift-at ?lift ?f1)) (at start (above ?f1 ?f2)) (at start (reachable-floor ?lift ?f2)) )
  :effect (and (at end (lift-at ?lift ?f2)) (at start (not (lift-at ?lift ?f1))) ))

(:durative-action move-down-fast
  :parameters (?lift - fast-elevator ?f1 - count ?f2 - count )
  :duration (= ?duration (travel-fast ?f2 ?f1))
  :condition (and (at start (lift-at ?lift ?f1)) (at start (above ?f2 ?f1)) (at start (reachable-floor ?lift ?f2)) )
  :effect (and (at end (lift-at ?lift ?f2)) (at start (not (lift-at ?lift ?f1))) ))

(:durative-action board
  :parameters (?p - passenger ?lift - elevator ?f - count ?n1 - count ?n2 - count)
  :duration (= ?duration 1)
  :condition ( and  (over all (lift-at ?lift ?f)) (at start (passenger-at ?p ?f)) (at start (passengers ?lift ?n1)) (at start (next ?n1 ?n2)) (at start (can-hold ?lift ?n2)) )
  :effect (and (at start (not (passenger-at ?p ?f))) (at end (boarded ?p ?lift)) (at start (not (passengers ?lift ?n1))) (at end (passengers ?lift ?n2)) ))

(:durative-action leave
  :parameters (?p - passenger ?lift - elevator ?f - count ?n1 - count ?n2 - count)
  :duration (= ?duration 1)
  :condition ( and  (over all (lift-at ?lift ?f)) (at start (boarded ?p ?lift)) (at start (passengers ?lift ?n1)) (at start (next ?n2 ?n1)) )
  :effect (and (at end (passenger-at ?p ?f)) (at start (not (boarded ?p ?lift))) (at start (not (passengers ?lift ?n1))) (at end (passengers ?lift ?n2)) ))

)

