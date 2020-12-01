; IPC5 Domain: Pathways Propositional
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain Pathways-Propositional) 
(:requirements :typing :adl)  

(:types level molecule - object
        simple complex - molecule) 

(:constants cdc25A cdc25Ap1 cdk2-cycA cdk2-cycA-E2F13p1 cdk2p1-cycA-E2F13p1 cdk2p1p2-cycA-E2F13p1 cdk2p2-cycA cdk2p2-cycA-E2F13 cdk2p2-cycA-E2F13p1 cdk2p2-cycE cdk2p2-cycEp1 cdk46-cycD cdk46p2-cycD CEBP-pRbp1-gP CEBP-pRbp1p2 DMP1p1-cycD DMP1p1-gp19ARF E2F13p1 ERCC1 HDAC1-p107-E2F4-DP12-gE2 p130-E2F4-DP12-gE2 p130-E2F5-DP12-gE2 p21-cdk2-cycA p21-cdk2p2-cycE p21-cdk2p2-cycEp1 p21-cdk46-cycD p21-cdk46-cycDp1 p21-cdk46p1-cycD p21-cdk46p2-cycD p21-cdk46p2-cycDp1 p27-cdk2-cycA p27-cdk2-cycE p27-cdk2p2-cycEp1 p27-cdk46-cycDp1 p27-cdk46p2-cycD p27-cdk46p2-cycDp1 p27p1-cdk2-cycA p27p1-cdk2-cycE p27p1-cdk2-cycEp1 p27p1-cdk2p1-cycA p27p1-cdk2p1-cycE p27p1-cdk2p1-cycEp1 p27p1-cdk2p1p2-cycE p27p1-cdk2p1p2-cycEp1 p27p1-cdk2p2-cycA p27p1-cdk2p2-cycE p27p1-cdk2p2-cycEp1 p27p1-cdk46-cycD p27p1-cdk46p1-cycD p27p1-cdk46p1-cycDp1 p27p1-cdk46p1p2-cycD p27p1-cdk46p1p2-cycDp1 p27p1-cdk46p2-cycD p27p1-cdk46p2-cycDp1 p53-DP12p1 p53p1-DP12p1 p57-cdk2p1-cycA p57-cdk2p1p2-cycA p57-cdk2p2-cycA p57-cdk2p2-cycE p57-cdk46-cycDp1 p57-cdk46p2-cycD p57-cdk46p2-cycDp1 p57p1-cdk46-cycD p57p1-cdk46-cycDp1 p57p1-cdk46p2-cycD p57p1-cdk46p2-cycDp1 PCNA-p21-cdk2-cycE PCNA-p21-cdk2-cycEp1 PCNA-p21-cdk2p2-cycA PCNA-p21-cdk46-cycD PCNA-p21-cdk46-cycDp1 PCNA-p21-cdk46p2-cycD PCNA-p21-cdk46p2-cycDp1 Raf1-cdc25A Raf1-pRbp1-E2F13-DP12p1-gE2 Raf1-pRbp1-E2F4-DP12-gE2 Skp1p1 SP1-E2F13p1 SP1-E2F13p1-gP  - complex)

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
	     (goal21)
	     (goal22)
	     (goal23)
	     (goal24)
	     (goal25)
	     (goal26)
	     (goal27)
	     (goal28)
	     (goal29)
	     (goal30)
	     (goal31)
	     (goal32)
	     (goal33)
	     (goal34)
	     (goal35)
	     (goal36)
	     (goal37)
	     (goal38)
	     (goal39)
	     (goal40))


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
	(or (available p57-cdk2p1p2-cycA)
	    (available SP1-E2F13p1-gP))
 :effect (and (goal1)))

(:action DUMMY-ACTION-2
 :parameters ()
 :precondition
	(or (available p27p1-cdk2-cycA)
	    (available p57p1-cdk46p2-cycD))
 :effect (and (goal2)))

(:action DUMMY-ACTION-3
 :parameters ()
 :precondition
	(or (available cdc25Ap1)
	    (available cdk2p1-cycA-E2F13p1))
 :effect (and (goal3)))

(:action DUMMY-ACTION-4
 :parameters ()
 :precondition
	(or (available p27-cdk2-cycE)
	    (available p27p1-cdk46p2-cycD))
 :effect (and (goal4)))

(:action DUMMY-ACTION-5
 :parameters ()
 :precondition
	(or (available p57-cdk2p2-cycA)
	    (available p21-cdk2p2-cycEp1))
 :effect (and (goal5)))

(:action DUMMY-ACTION-6
 :parameters ()
 :precondition
	(or (available PCNA-p21-cdk46p2-cycD)
	    (available p27p1-cdk2p2-cycEp1))
 :effect (and (goal6)))

(:action DUMMY-ACTION-7
 :parameters ()
 :precondition
	(or (available p57p1-cdk46-cycDp1)
	    (available p57-cdk46p2-cycD))
 :effect (and (goal7)))

(:action DUMMY-ACTION-8
 :parameters ()
 :precondition
	(or (available Raf1-pRbp1-E2F13-DP12p1-gE2)
	    (available p27-cdk46p2-cycDp1))
 :effect (and (goal8)))

(:action DUMMY-ACTION-9
 :parameters ()
 :precondition
	(or (available p57-cdk2p2-cycE)
	    (available E2F13p1))
 :effect (and (goal9)))

(:action DUMMY-ACTION-10
 :parameters ()
 :precondition
	(or (available p21-cdk2-cycA)
	    (available p27-cdk2p2-cycEp1))
 :effect (and (goal10)))

(:action DUMMY-ACTION-11
 :parameters ()
 :precondition
	(or (available cdk2p2-cycA-E2F13)
	    (available p21-cdk46p2-cycD))
 :effect (and (goal11)))

(:action DUMMY-ACTION-12
 :parameters ()
 :precondition
	(or (available cdk2p1p2-cycA-E2F13p1)
	    (available cdk2-cycA))
 :effect (and (goal12)))

(:action DUMMY-ACTION-13
 :parameters ()
 :precondition
	(or (available cdk2p2-cycEp1)
	    (available p57p1-cdk46p2-cycDp1))
 :effect (and (goal13)))

(:action DUMMY-ACTION-14
 :parameters ()
 :precondition
	(or (available Raf1-cdc25A)
	    (available ERCC1))
 :effect (and (goal14)))

(:action DUMMY-ACTION-15
 :parameters ()
 :precondition
	(or (available DMP1p1-gp19ARF)
	    (available p27p1-cdk46p1-cycDp1))
 :effect (and (goal15)))

(:action DUMMY-ACTION-16
 :parameters ()
 :precondition
	(or (available CEBP-pRbp1-gP)
	    (available p21-cdk46-cycD))
 :effect (and (goal16)))

(:action DUMMY-ACTION-17
 :parameters ()
 :precondition
	(or (available HDAC1-p107-E2F4-DP12-gE2)
	    (available p27p1-cdk2p1-cycEp1))
 :effect (and (goal17)))

(:action DUMMY-ACTION-18
 :parameters ()
 :precondition
	(or (available cdk2p2-cycA-E2F13p1)
	    (available p27p1-cdk2p1p2-cycE))
 :effect (and (goal18)))

(:action DUMMY-ACTION-19
 :parameters ()
 :precondition
	(or (available DMP1p1-cycD)
	    (available p27-cdk2-cycA))
 :effect (and (goal19)))

(:action DUMMY-ACTION-20
 :parameters ()
 :precondition
	(or (available cdk2-cycA-E2F13p1)
	    (available p53-DP12p1))
 :effect (and (goal20)))

(:action DUMMY-ACTION-21
 :parameters ()
 :precondition
	(or (available p130-E2F4-DP12-gE2)
	    (available p27p1-cdk2-cycEp1))
 :effect (and (goal21)))

(:action DUMMY-ACTION-22
 :parameters ()
 :precondition
	(or (available PCNA-p21-cdk46-cycDp1)
	    (available p57-cdk46-cycDp1))
 :effect (and (goal22)))

(:action DUMMY-ACTION-23
 :parameters ()
 :precondition
	(or (available p53p1-DP12p1)
	    (available PCNA-p21-cdk46p2-cycDp1))
 :effect (and (goal23)))

(:action DUMMY-ACTION-24
 :parameters ()
 :precondition
	(or (available p21-cdk2p2-cycE)
	    (available cdc25A))
 :effect (and (goal24)))

(:action DUMMY-ACTION-25
 :parameters ()
 :precondition
	(or (available p27p1-cdk2p1-cycA)
	    (available PCNA-p21-cdk2p2-cycA))
 :effect (and (goal25)))

(:action DUMMY-ACTION-26
 :parameters ()
 :precondition
	(or (available p27-cdk46-cycDp1)
	    (available PCNA-p21-cdk2-cycE))
 :effect (and (goal26)))

(:action DUMMY-ACTION-27
 :parameters ()
 :precondition
	(or (available cdk2p2-cycE)
	    (available Raf1-pRbp1-E2F4-DP12-gE2))
 :effect (and (goal27)))

(:action DUMMY-ACTION-28
 :parameters ()
 :precondition
	(or (available p21-cdk46p2-cycDp1)
	    (available p27p1-cdk2p1-cycE))
 :effect (and (goal28)))

(:action DUMMY-ACTION-29
 :parameters ()
 :precondition
	(or (available PCNA-p21-cdk2-cycEp1)
	    (available p130-E2F5-DP12-gE2))
 :effect (and (goal29)))

(:action DUMMY-ACTION-30
 :parameters ()
 :precondition
	(or (available p27p1-cdk46p1p2-cycD)
	    (available cdk46p2-cycD))
 :effect (and (goal30)))

(:action DUMMY-ACTION-31
 :parameters ()
 :precondition
	(or (available p57-cdk46p2-cycDp1)
	    (available p57-cdk2p1-cycA))
 :effect (and (goal31)))

(:action DUMMY-ACTION-32
 :parameters ()
 :precondition
	(or (available p27p1-cdk2-cycE)
	    (available Skp1p1))
 :effect (and (goal32)))

(:action DUMMY-ACTION-33
 :parameters ()
 :precondition
	(or (available p21-cdk46p1-cycD)
	    (available cdk46-cycD))
 :effect (and (goal33)))

(:action DUMMY-ACTION-34
 :parameters ()
 :precondition
	(or (available p27p1-cdk2p2-cycE)
	    (available CEBP-pRbp1p2))
 :effect (and (goal34)))

(:action DUMMY-ACTION-35
 :parameters ()
 :precondition
	(or (available SP1-E2F13p1)
	    (available p27-cdk46p2-cycD))
 :effect (and (goal35)))

(:action DUMMY-ACTION-36
 :parameters ()
 :precondition
	(or (available p27p1-cdk2p1p2-cycEp1)
	    (available p27p1-cdk46p1p2-cycDp1))
 :effect (and (goal36)))

(:action DUMMY-ACTION-37
 :parameters ()
 :precondition
	(or (available p27p1-cdk2p2-cycA)
	    (available p57p1-cdk46-cycD))
 :effect (and (goal37)))

(:action DUMMY-ACTION-38
 :parameters ()
 :precondition
	(or (available p27p1-cdk46p1-cycD)
	    (available cdk2p2-cycA))
 :effect (and (goal38)))

(:action DUMMY-ACTION-39
 :parameters ()
 :precondition
	(or (available PCNA-p21-cdk46-cycD)
	    (available p27p1-cdk46p2-cycDp1))
 :effect (and (goal39)))

(:action DUMMY-ACTION-40
 :parameters ()
 :precondition
	(or (available p27p1-cdk46-cycD)
	    (available p21-cdk46-cycDp1))
 :effect (and (goal40)))
)

