; IPC5 Domain: Pathways MetricTime
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain Pathways-MetricTime)
(:requirements :typing :negative-precondition :numeric-fluents :durative-actions)

(:types level molecule - object
	simple complex - molecule)

(:predicates (association-reaction ?x1 ?x2 - molecule ?x3 - complex)
	     (catalyzed-association-reaction ?x1 ?x2 - molecule ?x3 - complex)
	     (synthesis-reaction ?x1 ?x2 - molecule)
             (possible ?x - molecule)
	     (chosen ?x - simple))

(:functions (available ?x - molecule)
	    (duration-association-reaction ?x1 ?x2 - molecule ?x3 - complex)
	    (duration-catalyzed-association-reaction ?x1 ?x2 - molecule ?x3 - complex)
	    (duration-synthesis-reaction ?x1 ?x2 - molecule)
	    (need-for-association ?x1 ?x2 - molecule ?x3 - complex)
	    (need-for-catalyzed-association ?x1 ?x2 - molecule ?x3 - complex)
	    (need-for-synthesis ?x1 ?x2 - molecule)
	    (prod-by-association ?x1 ?x2 - molecule ?x3 - complex)
	    (prod-by-catalyzed-association ?x1 ?x2 - molecule ?x3 - complex)
	    (prod-by-synthesis ?x1 ?x2 - molecule)
	    (num-subs))

(:durative-action choose
 :parameters (?x - simple)
 :duration (= ?duration 0)
 :condition (and (over all (possible ?x)) (at start (not (chosen ?x))))
 :effect (and (at start (chosen ?x)) (at start (increase (num-subs) 1))))

(:durative-action initialize
 :parameters (?x - simple)
 :duration (= ?duration 0)
 :condition (and (at start (chosen ?x)))
 :effect (and (at end (increase (available ?x) 1))))

(:durative-action associate
 :parameters (?x1 ?x2 - molecule ?x3 - complex)
 :duration (= ?duration (duration-association-reaction ?x1 ?x2 ?x3))
 :condition (and (at start (>= (available ?x1) (need-for-association ?x1 ?x2 ?x3)))
		 (at start (>= (available ?x2) (need-for-association ?x2 ?x1 ?x3)))
		 (over all (association-reaction ?x1  ?x2  ?x3)))
 :effect (and (at start (decrease (available ?x1) (need-for-association ?x1 ?x2 ?x3)))
	      (at start (decrease (available ?x2) (need-for-association ?x2 ?x1 ?x3)))
	      (at end (increase (available ?x3) (prod-by-association ?x1 ?x2 ?x3)))))

(:durative-action associate-with-catalyze
 :parameters (?x1 ?x2 - molecule ?x3 - complex)
 :duration (= ?duration (duration-catalyzed-association-reaction ?x1 ?x2 ?x3))
 :condition (and (at start (>= (available ?x1) (need-for-catalyzed-association ?x1 ?x2 ?x3)))
		 (at start (>= (available ?x2) (need-for-catalyzed-association ?x2 ?x1 ?x3)))
		 (over all (catalyzed-association-reaction ?x1 ?x2 ?x3)))
 :effect (and (at start (decrease (available ?x1) (need-for-catalyzed-association ?x1 ?x2 ?x3)))
	      (at start (decrease (available ?x2) (need-for-catalyzed-association ?x2 ?x1 ?x3)))
	      (at end (increase (available ?x2) (need-for-catalyzed-association ?x2 ?x1 ?x3)))
	      (at end (increase (available ?x3) (prod-by-catalyzed-association ?x1 ?x2 ?x3)))))

(:durative-action synthesize
 :parameters (?x1 ?x2 - molecule)
 :duration (= ?duration (duration-synthesis-reaction ?x1 ?x2))
 :condition (and (at start (>= (available ?x1) (need-for-synthesis ?x1 ?x2)))
		 (over all (synthesis-reaction ?x1 ?x2)))
 :effect (and (at start (decrease (available ?x1) (need-for-synthesis ?x1 ?x2)))
	      (at end (increase (available ?x1) (need-for-synthesis ?x1 ?x2)))
	      (at end (increase (available ?x2) (prod-by-synthesis ?x1 ?x2)))))
)

