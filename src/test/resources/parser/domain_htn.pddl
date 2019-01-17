;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; 4 Op-blocks world
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (domain BLOCKS)
  (:requirements :htn :typing)
  (:types block)
  (:predicates (on ?x - block ?y - block)
	       (ontable ?x - block)
	       (clear ?x - block)
	       (handempty)
	       (holding ?x - block)
	       )

  (:action pick-up
	     :parameters (?x - block)
	     :precondition (and (clear ?x) (ontable ?x) (handempty))
	     :effect
	     (and (not (ontable ?x))
		   (not (clear ?x))
		   (not (handempty))
		   (holding ?x)))

  (:method test
         :parameters (?x - block ?y - block)
         :expansion ((pick-up ?x - block)@t1 (put-down ?x)@t2)
         :constraints (
                        (before (t1 t3) t4)
                        (before (t2 t3) (t5))
                        (hold-before t1 ())
                        (hold-after (t2) (and (not (ontable ?x))
                                         		   (not (clear ?x))
                                         		   (not (handempty))
                                         		   (holding ?x)))
                        (hold-between (t1) (t2) (and (clear ?x) (ontable ?x) (handempty)))
                        (hold-during (t1) (t2) (and (clear ?x)))
                        (at start (and (clear ?x) (ontable ?x) (handempty)))
                        (at end (and (not (ontable ?x))
                                           (not (clear ?x))
                                           (not (handempty))
                                           (holding ?x)))
                        (always (and (clear ?x) (ontable ?x) (handempty)))
                        (at-most-once (and (clear ?x) (ontable ?x) (handempty)))
                        (sometime (and (clear ?x) (ontable ?x) (handempty)))
                        (sometime-after (and (clear ?x) (ontable ?x) (handempty)) (and (ontable ?x) (handempty)))
                        (sometime-before (and (clear ?x) (ontable ?x) (handempty)) (and (clear ?x) (handempty)))
                        (always-within t4 (and (clear ?x) (ontable ?x) (handempty)) (and (clear ?x) (handempty)))
                        (within (t2 t3) (and (clear ?x) (ontable ?x) (handempty)))
                      )
  )
)
