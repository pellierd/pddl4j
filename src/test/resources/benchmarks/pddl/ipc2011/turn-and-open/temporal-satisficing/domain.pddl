(define (domain turnandopen-strips)
 (:requirements :strips :typing :durative-actions) 
 (:types room object robot gripper door) 
 (:predicates (at-robby ?r - robot ?x - room)
 	      (at ?o - object ?x - room)
	      (free ?r - robot ?g - gripper)
	      (carry ?r - robot ?o - object ?g - gripper)
	      (connected ?x - room ?y - room ?d - door)
	      (open ?d - door)
	      (closed ?d - door)
	      (doorknob-turned ?d - door ?g - gripper))

   (:durative-action turn-doorknob
       :parameters (?r - robot ?from ?to - room ?d - door ?g - gripper)
       :duration (= ?duration 3)
       :condition  (and  (over all (at-robby ?r ?from))
       		      	 (at start (free ?r ?g))
			 (over all (connected ?from ?to ?d))
			 (at start (closed ?d)))
       :effect (and  
		    (at start (not (free ?r ?g)))
		    (at end (free ?r ?g))
		    (at start (doorknob-turned ?d ?g))
		    (at end (not (doorknob-turned ?d ?g)))))

   (:durative-action open-door
       :parameters (?r - robot ?from ?to - room ?d - door ?g - gripper)
       :duration (= ?duration 2)
       :condition  (and  (over all (at-robby ?r ?from))
       		      	 (over all (connected ?from ?to ?d))
			 (over all (doorknob-turned ?d ?g))
			 (at start (closed ?d)))
       :effect (and (at start (not (closed ?d)))
		    (at end (open ?d))))
	       	    

   (:durative-action move
       :parameters  (?r - robot ?from ?to - room ?d - door)
       :duration (= ?duration 1)
       :condition (and  (at start (at-robby ?r ?from))
       		     	(over all (connected ?from ?to ?d))
			(over all (open ?d)))
       :effect (and  (at end (at-robby ?r ?to))
		     (at start (not (at-robby ?r ?from)))))

   (:durative-action pick
       :parameters (?r - robot ?obj - object ?room - room ?g - gripper)
       :duration (= ?duration 1)
       :condition  (and  (at start (at ?obj ?room))
       		   	 (at start (at-robby ?r ?room))
			 (at start (free ?r ?g)))
       :effect (and (at end (carry ?r ?obj ?g))
		    (at start (not (at ?obj ?room))) 
		    (at start (not (free ?r ?g)))))

   (:durative-action drop
       :parameters (?r - robot ?obj - object ?room - room ?g - gripper)
       :duration (= ?duration 1)
       :condition  (and  (at start (carry ?r ?obj ?g))
       		   	 (at start (at-robby ?r ?room)))
       :effect (and (at end (at ?obj ?room))
		    (at end (free ?r ?g))
		    (at start (not (carry ?r ?obj ?g)))))
)