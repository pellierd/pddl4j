; IPC5 Domain: Pathways Propositional
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain Pathways-Propositional) 
(:requirements :typing :adl)  

(:types level molecule - object
        simple complex - molecule) 

(:constants cdk2p1p2-cycA cdk2p1p2-cycE ERCC1 HDAC1-pRb-E2F13p1-DP12p1 Jun-c-Fos-gERCC1 Mdm2-pRbp1p2 p21-cdk2p1-cycE p21-cdk2p1-cycEp1 p21-cdk2p1p2-cycEp1 p21-cdk46p1p2-cycD p53-DP12p1 p53p1-DP12p1 p68p1p2 pRbp1p2-Jun-c-Fos-gERCC1 Skp2p1-Skp1 Skp2p1-Skp1p1 Skp2-Skp1-cdk2-cycA Skp2-Skp1-cdk2p1p2-cycA Skp2-Skp1p1 Skp2-Skp1p1-cdk2-cycA Skp2-Skp1p1-cdk2p1-cycA Skp2-Skp1p1-cdk2p1p2-cycA Skp2-Skp1p1-cdk2p2-cycA SP1-p107p1-gP  - complex)

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
	     (goal12))


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
	(or (available p68p1p2)
	    (available Skp2-Skp1p1-cdk2-cycA))
 :effect (and (goal1)))

(:action DUMMY-ACTION-2
 :parameters ()
 :precondition
	(or (available Skp2-Skp1p1-cdk2p1p2-cycA)
	    (available Skp2-Skp1p1-cdk2p2-cycA))
 :effect (and (goal2)))

(:action DUMMY-ACTION-3
 :parameters ()
 :precondition
	(or (available Skp2-Skp1p1-cdk2p1-cycA)
	    (available Skp2-Skp1p1))
 :effect (and (goal3)))

(:action DUMMY-ACTION-4
 :parameters ()
 :precondition
	(or (available p53p1-DP12p1)
	    (available Skp2p1-Skp1p1))
 :effect (and (goal4)))

(:action DUMMY-ACTION-5
 :parameters ()
 :precondition
	(or (available p21-cdk2p1p2-cycEp1)
	    (available Skp2p1-Skp1))
 :effect (and (goal5)))

(:action DUMMY-ACTION-6
 :parameters ()
 :precondition
	(or (available p53-DP12p1)
	    (available p21-cdk2p1-cycE))
 :effect (and (goal6)))

(:action DUMMY-ACTION-7
 :parameters ()
 :precondition
	(or (available Skp2-Skp1-cdk2-cycA)
	    (available cdk2p1p2-cycE))
 :effect (and (goal7)))

(:action DUMMY-ACTION-8
 :parameters ()
 :precondition
	(or (available p21-cdk46p1p2-cycD)
	    (available Mdm2-pRbp1p2))
 :effect (and (goal8)))

(:action DUMMY-ACTION-9
 :parameters ()
 :precondition
	(or (available cdk2p1p2-cycA)
	    (available pRbp1p2-Jun-c-Fos-gERCC1))
 :effect (and (goal9)))

(:action DUMMY-ACTION-10
 :parameters ()
 :precondition
	(or (available ERCC1)
	    (available HDAC1-pRb-E2F13p1-DP12p1))
 :effect (and (goal10)))

(:action DUMMY-ACTION-11
 :parameters ()
 :precondition
	(or (available Skp2-Skp1-cdk2p1p2-cycA)
	    (available Jun-c-Fos-gERCC1))
 :effect (and (goal11)))

(:action DUMMY-ACTION-12
 :parameters ()
 :precondition
	(or (available p21-cdk2p1-cycEp1)
	    (available SP1-p107p1-gP))
 :effect (and (goal12)))
)

