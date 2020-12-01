; IPC5 Domain: Pathways Propositional
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain Pathways-Propositional) 
(:requirements :typing :adl)  

(:types level molecule - object
        simple complex - molecule) 

(:constants cdk1 cdk1-cks1 cdk1-Gadd45 cdk1p1-cks1 cdk1p1p2p3-cycB cdk1p1p2p3-Gadd45 cdk1p1p3-cks1 cdk1p1p3-cycB cdk1p1p3-Gadd45 cdk1p2-cks1 cdk1p2p3 cdk1p2p3-cks1 cdk1p2p3-cycB cdk1p2p3-Gadd45 cdk1p3 cdk1p3-cks1 cdk1p3-cycB cdk1p3-Gadd45 cdk2p2-cks1 CEBP-pRbp1 p16-cdk7p1 pRbp1p2-Jun-c-Fos Raf1-p130-E2F5-DP12 Raf1-pRbp1-E2F13-DP12 SL1p1 Wee1p1  - complex)

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
	     (goal8)
	     (goal9)
	     (goal10)
	     (goal11)
	     (goal12)
	     (goal13))


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
	(or (available cdk1p3-cycB)
	    (available SL1p1))
 :effect (and (goal1)))

(:action DUMMY-ACTION-2
 :parameters ()
 :precondition
	(or (available Wee1p1)
	    (available cdk1p3-Gadd45))
 :effect (and (goal2)))

(:action DUMMY-ACTION-3
 :parameters ()
 :precondition
	(or (available cdk1p3-cks1)
	    (available cdk1p1p3-Gadd45))
 :effect (and (goal3)))

(:action DUMMY-ACTION-4
 :parameters ()
 :precondition
	(or (available cdk1p1-cks1)
	    (available cdk1p1p3-cks1))
 :effect (and (goal4)))

(:action DUMMY-ACTION-5
 :parameters ()
 :precondition
	(or (available cdk1-cks1)
	    (available cdk1p1p3-cycB))
 :effect (and (goal5)))

(:action DUMMY-ACTION-6
 :parameters ()
 :precondition
	(or (available cdk1p1p2p3-cycB)
	    (available Raf1-p130-E2F5-DP12))
 :effect (and (goal6)))

(:action DUMMY-ACTION-7
 :parameters ()
 :precondition
	(or (available cdk1p2p3-cycB)
	    (available cdk1p2p3))
 :effect (and (goal7)))

(:action DUMMY-ACTION-8
 :parameters ()
 :precondition
	(or (available cdk1p3)
	    (available cdk2p2-cks1))
 :effect (and (goal8)))

(:action DUMMY-ACTION-9
 :parameters ()
 :precondition
	(or (available cdk1p1p2p3-Gadd45)
	    (available Raf1-pRbp1-E2F13-DP12))
 :effect (and (goal9)))

(:action DUMMY-ACTION-10
 :parameters ()
 :precondition
	(or (available cdk1p2p3-cks1)
	    (available cdk1p2p3-Gadd45))
 :effect (and (goal10)))

(:action DUMMY-ACTION-11
 :parameters ()
 :precondition
	(or (available cdk1-Gadd45)
	    (available pRbp1p2-Jun-c-Fos))
 :effect (and (goal11)))

(:action DUMMY-ACTION-12
 :parameters ()
 :precondition
	(or (available cdk1p2-cks1)
	    (available cdk1))
 :effect (and (goal12)))

(:action DUMMY-ACTION-13
 :parameters ()
 :precondition
	(or (available CEBP-pRbp1)
	    (available p16-cdk7p1))
 :effect (and (goal13)))
)

