; IPC5 Domain: Pathways Propositional
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain Pathways-Propositional) 
(:requirements :typing :adl)  

(:types level molecule - object
        simple complex - molecule) 

(:constants cdc25A cdk2-cycE c-Myc-Max cycA Mdm2-E2F13-DP12 p21-cdk2-cycA p21-cdk2-cycE p21-cdk2p1-cycA p21-cdk2p1-cycE p21-cdk46p1-cycD p27-cdk2p1-cycA p27-cdk2p1-cycEp1 p27-cdk46p1-cycDp1 p57-cdk2-cycE p57-cdk2p1-cycA p57-cdk2p1-cycE PCNA-Gadd45 PCNA-p21-cdk2-cycA PCNA-p21-cdk2-cycEp1 PCNA-p21-cdk2p1-cycE PCNA-p21-cdk2p1-cycEp1 pRbp1-Jun-c-Fos  - complex)

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
	     (goal11))


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
	(or (available PCNA-Gadd45)
	    (available cycA))
 :effect (and (goal1)))

(:action DUMMY-ACTION-2
 :parameters ()
 :precondition
	(or (available cdc25A)
	    (available p21-cdk2p1-cycE))
 :effect (and (goal2)))

(:action DUMMY-ACTION-3
 :parameters ()
 :precondition
	(or (available p57-cdk2p1-cycA)
	    (available p27-cdk46p1-cycDp1))
 :effect (and (goal3)))

(:action DUMMY-ACTION-4
 :parameters ()
 :precondition
	(or (available PCNA-p21-cdk2-cycA)
	    (available p57-cdk2p1-cycE))
 :effect (and (goal4)))

(:action DUMMY-ACTION-5
 :parameters ()
 :precondition
	(or (available p27-cdk2p1-cycA)
	    (available PCNA-p21-cdk2p1-cycE))
 :effect (and (goal5)))

(:action DUMMY-ACTION-6
 :parameters ()
 :precondition
	(or (available cdk2-cycE)
	    (available p21-cdk46p1-cycD))
 :effect (and (goal6)))

(:action DUMMY-ACTION-7
 :parameters ()
 :precondition
	(or (available PCNA-p21-cdk2p1-cycEp1)
	    (available c-Myc-Max))
 :effect (and (goal7)))

(:action DUMMY-ACTION-8
 :parameters ()
 :precondition
	(or (available p27-cdk2p1-cycEp1)
	    (available pRbp1-Jun-c-Fos))
 :effect (and (goal8)))

(:action DUMMY-ACTION-9
 :parameters ()
 :precondition
	(or (available Mdm2-E2F13-DP12)
	    (available p57-cdk2-cycE))
 :effect (and (goal9)))

(:action DUMMY-ACTION-10
 :parameters ()
 :precondition
	(or (available p21-cdk2p1-cycA)
	    (available PCNA-p21-cdk2-cycEp1))
 :effect (and (goal10)))

(:action DUMMY-ACTION-11
 :parameters ()
 :precondition
	(or (available p21-cdk2-cycA)
	    (available p21-cdk2-cycE))
 :effect (and (goal11)))
)

