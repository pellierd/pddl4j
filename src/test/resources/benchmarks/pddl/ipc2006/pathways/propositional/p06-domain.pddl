; IPC5 Domain: Pathways Propositional
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain Pathways-Propositional) 
(:requirements :typing :adl)  

(:types level molecule - object
        simple complex - molecule) 

(:constants cdk2p1-cycA cdk2p1-cycE HDAC1-p107-E2F4-DP12 p57-cdk2p1-cycA p57-cdk2p1-cycE p57-cdk2p1-cycEp1 p57-cdk46p1-cycD p57-cdk46p1-cycDp1 p57p1-cdk46p1-cycD p57p1-cdk46p1-cycDp1 Raf1-pRbp1-E2F13-DP12p1 Raf1-pRbp1-E2F4-DP12 RPA-cycA Skp2-cdk2p1-cycA SP1-p107-gP SP1-p107p1-gP  - complex)

(:predicates 
	     (association-reaction ?x1 ?x2 - molecule ?x3 - complex)
	     (catalyzed-association-reaction ?x1 ?x2 - molecule ?x3 - complex)
	     (synthesis-reaction ?x1 ?x2 - molecule)
             (possible ?x - molecule) 	
	     (available ?x - molecule)
             (chosen ?s - simple)
	     (next ?l1 ?l2 - level)
	     (num-subs ?l - level)
	     (goal1)
	     (goal2)
	     (goal3)
	     (goal4)
	     (goal5)
	     (goal6)
	     (goal7)
	     (goal8))


(:action choose
 :parameters (?x - simple ?l1 ?l2 - level)
 :precondition (and (possible ?x) (not (chosen ?x)) 
		    (num-subs ?l2) (next ?l1 ?l2))
 :effect (and (chosen ?x) (not (num-subs ?l2)) (num-subs ?l1)))

(:action initialize
  :parameters (?x - simple)
  :precondition (and (chosen ?x))
  :effect (and (available ?x)))

(:action associate
 :parameters (?x1 ?x2 - molecule ?x3 - complex)
 :precondition (and (association-reaction ?x1  ?x2  ?x3) 
		    (available ?x1) (available ?x2))
 :effect (and  (not (available ?x1)) (not (available ?x2)) (available ?x3)))

(:action associate-with-catalyze 
 :parameters (?x1 ?x2 - molecule ?x3 - complex)
 :precondition (and (catalyzed-association-reaction ?x1 ?x2 ?x3) 
		    (available ?x1) (available ?x2))
 :effect (and (not (available ?x1)) (available ?x3)))

(:action synthesize
 :parameters (?x1 ?x2 - molecule)
 :precondition (and (synthesis-reaction ?x1 ?x2) (available ?x1))
 :effect (and (available ?x2)))



(:action DUMMY-ACTION-1
 :parameters ()
 :precondition
	(or (available Skp2-cdk2p1-cycA)
	    (available p57-cdk2p1-cycE))
 :effect (and (goal1)))

(:action DUMMY-ACTION-2
 :parameters ()
 :precondition
	(or (available SP1-p107-gP)
	    (available p57p1-cdk46p1-cycDp1))
 :effect (and (goal2)))

(:action DUMMY-ACTION-3
 :parameters ()
 :precondition
	(or (available p57-cdk2p1-cycA)
	    (available Raf1-pRbp1-E2F13-DP12p1))
 :effect (and (goal3)))

(:action DUMMY-ACTION-4
 :parameters ()
 :precondition
	(or (available Raf1-pRbp1-E2F4-DP12)
	    (available HDAC1-p107-E2F4-DP12))
 :effect (and (goal4)))

(:action DUMMY-ACTION-5
 :parameters ()
 :precondition
	(or (available p57-cdk46p1-cycD)
	    (available p57p1-cdk46p1-cycD))
 :effect (and (goal5)))

(:action DUMMY-ACTION-6
 :parameters ()
 :precondition
	(or (available cdk2p1-cycE)
	    (available cdk2p1-cycA))
 :effect (and (goal6)))

(:action DUMMY-ACTION-7
 :parameters ()
 :precondition
	(or (available p57-cdk46p1-cycDp1)
	    (available SP1-p107p1-gP))
 :effect (and (goal7)))

(:action DUMMY-ACTION-8
 :parameters ()
 :precondition
	(or (available p57-cdk2p1-cycEp1)
	    (available RPA-cycA))
 :effect (and (goal8)))
)

