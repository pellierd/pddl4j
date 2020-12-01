; IPC5 Domain: Pathways Propositional
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain Pathways-Propositional) 
(:requirements :typing :adl)  

(:types level molecule - object
        simple complex - molecule) 

(:constants cdk1p3-cycA cdk2-cycA-E2F13 cdk2p2-cycA-E2F13 cdk2p2-cycA-E2F13p1 cdk2p2-cycE cdk46-cycDp1 cdk46p1p2 cycD Mdm2-pRbp2 p16-cdk46p2 p21-cdk2-cycA p21-cdk2-cycE p21-cdk46-cycD p21-cdk46-cycDp1 p21-cdk46p2-cycD p27-cdk2p2-cycA p27-cdk2p2-cycE p27-cdk46p2-cycDp1 p27p1-cdk2-cycEp1 p27p1-cdk2p1-cycA p27p1-cdk2p1-cycE p27p1-cdk2p1p2-cycE p27p1-cdk2p2-cycA p27p1-cdk2p2-cycEp1 p27p1-cdk46p1-cycD p27p1-cdk46p1-cycDp1 p27p1-cdk46p1p2-cycD p27p1-cdk46p1p2-cycDp1 p68p1p2 p68p2 pRbp1-E2F13p1-DP12 pRbp1-Jun-c-Fos Raf1-pRb-E2F13p1-DP12 Raf1-pRbp1-E2F4-DP12-gE2 Skp1p1 Skp2p1 Skp2-Skp1-cdk2p2-cycA Skp2-Skp1p1-cdk2-cycA Skp2-Skp1p1-cdk2p1-cycA Skp2-Skp1p1-cdk2p1p2-cycA Skp2-Skp1p1-cdk2p2-cycA Wee1p1  - complex)

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
	     (goal16)
	     (goal17)
	     (goal18)
	     (goal19)
	     (goal20)
	     (goal21))


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
	(or (available Skp2-Skp1p1-cdk2-cycA)
	    (available Mdm2-pRbp2))
 :effect (and (goal1)))

(:action DUMMY-ACTION-2
 :parameters ()
 :precondition
	(or (available Raf1-pRbp1-E2F4-DP12-gE2)
	    (available p27p1-cdk2p2-cycEp1))
 :effect (and (goal2)))

(:action DUMMY-ACTION-3
 :parameters ()
 :precondition
	(or (available Skp2-Skp1p1-cdk2p2-cycA)
	    (available Skp2-Skp1p1-cdk2p1-cycA))
 :effect (and (goal3)))

(:action DUMMY-ACTION-4
 :parameters ()
 :precondition
	(or (available Skp2-Skp1p1-cdk2p1p2-cycA)
	    (available p27p1-cdk46p1-cycD))
 :effect (and (goal4)))

(:action DUMMY-ACTION-5
 :parameters ()
 :precondition
	(or (available cdk1p3-cycA)
	    (available cycD))
 :effect (and (goal5)))

(:action DUMMY-ACTION-6
 :parameters ()
 :precondition
	(or (available p27-cdk2p2-cycA)
	    (available p27-cdk2p2-cycE))
 :effect (and (goal6)))

(:action DUMMY-ACTION-7
 :parameters ()
 :precondition
	(or (available cdk2p2-cycE)
	    (available p27p1-cdk2p2-cycA))
 :effect (and (goal7)))

(:action DUMMY-ACTION-8
 :parameters ()
 :precondition
	(or (available cdk2p2-cycA-E2F13p1)
	    (available p21-cdk46p2-cycD))
 :effect (and (goal8)))

(:action DUMMY-ACTION-9
 :parameters ()
 :precondition
	(or (available p27p1-cdk46p1p2-cycDp1)
	    (available p27p1-cdk2p1p2-cycE))
 :effect (and (goal9)))

(:action DUMMY-ACTION-10
 :parameters ()
 :precondition
	(or (available p21-cdk2-cycA)
	    (available Wee1p1))
 :effect (and (goal10)))

(:action DUMMY-ACTION-11
 :parameters ()
 :precondition
	(or (available cdk46p1p2)
	    (available p68p2))
 :effect (and (goal11)))

(:action DUMMY-ACTION-12
 :parameters ()
 :precondition
	(or (available p21-cdk2-cycE)
	    (available cdk2-cycA-E2F13))
 :effect (and (goal12)))

(:action DUMMY-ACTION-13
 :parameters ()
 :precondition
	(or (available cdk46-cycDp1)
	    (available p27p1-cdk46p1p2-cycD))
 :effect (and (goal13)))

(:action DUMMY-ACTION-14
 :parameters ()
 :precondition
	(or (available p27-cdk46p2-cycDp1)
	    (available pRbp1-E2F13p1-DP12))
 :effect (and (goal14)))

(:action DUMMY-ACTION-15
 :parameters ()
 :precondition
	(or (available Skp1p1)
	    (available p27p1-cdk46p1-cycDp1))
 :effect (and (goal15)))

(:action DUMMY-ACTION-16
 :parameters ()
 :precondition
	(or (available p21-cdk46-cycD)
	    (available p21-cdk46-cycDp1))
 :effect (and (goal16)))

(:action DUMMY-ACTION-17
 :parameters ()
 :precondition
	(or (available p16-cdk46p2)
	    (available Raf1-pRb-E2F13p1-DP12))
 :effect (and (goal17)))

(:action DUMMY-ACTION-18
 :parameters ()
 :precondition
	(or (available p27p1-cdk2p1-cycE)
	    (available p27p1-cdk2p1-cycA))
 :effect (and (goal18)))

(:action DUMMY-ACTION-19
 :parameters ()
 :precondition
	(or (available p27p1-cdk2-cycEp1)
	    (available pRbp1-Jun-c-Fos))
 :effect (and (goal19)))

(:action DUMMY-ACTION-20
 :parameters ()
 :precondition
	(or (available p68p1p2)
	    (available cdk2p2-cycA-E2F13))
 :effect (and (goal20)))

(:action DUMMY-ACTION-21
 :parameters ()
 :precondition
	(or (available Skp2-Skp1-cdk2p2-cycA)
	    (available Skp2p1))
 :effect (and (goal21)))
)

