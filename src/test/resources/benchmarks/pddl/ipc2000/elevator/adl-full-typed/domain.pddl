(define (domain miconic)
  (:requirements :adl)
  (:types passenger - object
          going_up going_down vip
	  going_nonstop attendant never_alone 
          conflict_A conflict_B - passenger
          floor - object
         )

(:predicates 
(origin ?person - passenger ?floor - floor)
;; entry of ?person is ?floor
;; inertia

(destin ?person - passenger ?floor - floor)
;; exit of ?person is ?floor
;; inertia

(no-access ?person - passenger ?floor - floor)
;; access limitation of ?person on ?floor

(above ?floor1 - floor  ?floor2 - floor)
;; ?floor2 is located above of ?floor1

(boarded ?person - passenger)
;; true if ?person has boarded the lift

(served ?person - passenger)
;; true if ?person has alighted as her destination

(lift-at ?floor - floor)
;; current position of the lift is at ?floor
)


;;stop

(:action
 stop
 :parameters (?f - floor)
 :precondition (and (lift-at ?f)
		    (imply
		     (exists
		      (?p - conflict_A)
		      (or (and (not (served ?p))
			       (origin ?p ?f))
			  (and (boarded ?p)
			       (not (destin ?p ?f)))))
		     (forall 
		      (?q - conflict_B)
		      (and (or (destin ?q ?f)
			       (not (boarded ?q)))
			   (or (served ?q)
			       (not (origin ?q ?f))))))
		    (imply (exists 
			    (?p - conflict_B)
			    (or (and (not (served ?p))
				     (origin ?p ?f))
				(and (boarded ?p)
				     (not (destin ?p ?f)))))
			   (forall 
			    (?q - conflict_A)
			    (and (or (destin ?q ?f)
				     (not (boarded ?q)))
				 (or (served ?q)
				     (not (origin ?q ?f))))))
		    (imply 
                    (exists 
		     (?p - never_alone)
		     (or (and (origin ?p ?f)
			      (not (served ?p)))
			 (and (boarded ?p)
			      (not (destin ?p ?f)))))
		    (exists 
		     (?q - attendant)
		     (or (and (boarded ?q) 
			      (not (destin ?q ?f)))
			 (and (not (served ?q))
			      (origin ?q ?f))))) 
		    (forall 
		     (?p - going_nonstop) 
		     (imply (boarded ?p) (destin ?p ?f))) 
		    (or (forall 
			 (?p - vip) (served ?p))
			(exists 
			 (?p - vip)   
			 (or (origin ?p ?f) (destin ?p ?f))))
                  (forall 
		   (?p - passenger) 
		   (imply 
		    (no-access ?p ?f) (not (boarded ?p))))) 
 :effect (and 
	  (forall (?p - passenger) 
                  (when (and (boarded ?p) 
                             (destin ?p ?f))
                        (and (not (boarded ?p)) 
                             (served  ?p))))
	  (forall (?p - passenger)                
		  (when (and (origin ?p ?f) (not (served ?p)))
			(boarded ?p)))))


;;drive up

(:action up
  :parameters (?f1 - floor ?f2 - floor)
  :precondition (and (lift-at ?f1) (above ?f1 ?f2)  
                     (forall
		      (?p - going_down) (not (boarded ?p))))
  :effect (and (lift-at ?f2) (not (lift-at ?f1))))


;;drive down

(:action down
  :parameters (?f1 - floor ?f2 - floor)
  :precondition (and (lift-at ?f1) (above ?f2 ?f1)
                     (forall
		      (?p - going_up) (not (boarded ?p))))
  :effect (and (lift-at ?f2) (not (lift-at ?f1))))
)



