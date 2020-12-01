; IPC5 Domain: Pathways Propositional
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain Pathways-Propositional) 
(:requirements :typing :adl)  

(:types level molecule - object
        simple complex - molecule) 

(:constants cdc25A cdk1p1p3-cycB cdk1p2p3-cycA cdk1p3 cdk1p3-cks1 cdk1p3-cycA cdk1p3-cycB cdk2p1-cycE CEBP-pRbp1p2 CEBP-pRbp1p2-gP c-Myc-Max cycDp1 p21-cdk2-cycA p27-cdk2p2-cycA p27p1-cdk2-cycA p27p1-cdk2-cycEp1 p27p1-cdk2p1-cycA p27p1-cdk2p1-cycE p27p1-cdk2p1p2-cycA p27p1-cdk2p1p2-cycE p27p1-cdk2p1p2-cycEp1 p27p1-cdk2p2-cycE pRbp1p2-AP2 pRbp1p2-AP2-gE-c Skp2p1 Skp2p1-Skp1 Skp2-Skp1p1-cdk2-cycA Skp2-Skp1p1-cdk2p1-cycA Skp2-Skp1p1-cdk2p1p2-cycA Skp2-Skp1p1-cdk2p2-cycA SL1p1 Wee1p1  - complex)

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
	     (goal13)
	     (goal14)
	     (goal15)
	     (goal16))


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
	(or (available Skp2-Skp1p1-cdk2p1-cycA)
	    (available Wee1p1))
 :effect (and (goal1)))

(:action DUMMY-ACTION-2
 :parameters ()
 :precondition
	(or (available Skp2p1)
	    (available CEBP-pRbp1p2-gP))
 :effect (and (goal2)))

(:action DUMMY-ACTION-3
 :parameters ()
 :precondition
	(or (available p27p1-cdk2p1-cycE)
	    (available Skp2-Skp1p1-cdk2p2-cycA))
 :effect (and (goal3)))

(:action DUMMY-ACTION-4
 :parameters ()
 :precondition
	(or (available pRbp1p2-AP2-gE-c)
	    (available SL1p1))
 :effect (and (goal4)))

(:action DUMMY-ACTION-5
 :parameters ()
 :precondition
	(or (available Skp2-Skp1p1-cdk2-cycA)
	    (available cdk2p1-cycE))
 :effect (and (goal5)))

(:action DUMMY-ACTION-6
 :parameters ()
 :precondition
	(or (available cdk1p3-cycA)
	    (available cdk1p1p3-cycB))
 :effect (and (goal6)))

(:action DUMMY-ACTION-7
 :parameters ()
 :precondition
	(or (available Skp2p1-Skp1)
	    (available Skp2-Skp1p1-cdk2p1p2-cycA))
 :effect (and (goal7)))

(:action DUMMY-ACTION-8
 :parameters ()
 :precondition
	(or (available cdc25A)
	    (available p27-cdk2p2-cycA))
 :effect (and (goal8)))

(:action DUMMY-ACTION-9
 :parameters ()
 :precondition
	(or (available p27p1-cdk2p1p2-cycA)
	    (available p27p1-cdk2-cycA))
 :effect (and (goal9)))

(:action DUMMY-ACTION-10
 :parameters ()
 :precondition
	(or (available cdk1p3-cycB)
	    (available p27p1-cdk2p1p2-cycE))
 :effect (and (goal10)))

(:action DUMMY-ACTION-11
 :parameters ()
 :precondition
	(or (available p27p1-cdk2p1-cycA)
	    (available cdk1p3-cks1))
 :effect (and (goal11)))

(:action DUMMY-ACTION-12
 :parameters ()
 :precondition
	(or (available cdk1p2p3-cycA)
	    (available p27p1-cdk2-cycEp1))
 :effect (and (goal12)))

(:action DUMMY-ACTION-13
 :parameters ()
 :precondition
	(or (available p27p1-cdk2p2-cycE)
	    (available p27p1-cdk2p1p2-cycEp1))
 :effect (and (goal13)))

(:action DUMMY-ACTION-14
 :parameters ()
 :precondition
	(or (available cdk1p3)
	    (available cycDp1))
 :effect (and (goal14)))

(:action DUMMY-ACTION-15
 :parameters ()
 :precondition
	(or (available CEBP-pRbp1p2)
	    (available p21-cdk2-cycA))
 :effect (and (goal15)))

(:action DUMMY-ACTION-16
 :parameters ()
 :precondition
	(or (available c-Myc-Max)
	    (available pRbp1p2-AP2))
 :effect (and (goal16)))
)

