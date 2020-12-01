(define (problem Pathways-04)
(:domain Pathways-Propositional)
(:objects
	Wee1 - simple
	SP1 - simple
	RPA - simple
	pRbp2 - simple
	pRbp1-E2F4p1-DP12 - simple
	pRb-E2F4p1-DP12 - simple
	PCNA - simple
	m1433 - simple
	HDAC1-p130-E2F4p1-DP12 - simple
	HDAC1 - simple
	gP - simple
	gE2 - simple
	E2F6-DP12p1 - simple
	E2F4-DP12p1 - simple
	E2F13 - simple
	DMP1 - simple
	C-TAK1 - simple
	CEBP - simple
	cdk2p1 - simple
	cdk2 - simple
	cdc25C - simple
	c-Abl - simple
	c-Abl-pRbp2 - complex
	cdk2-cycA-E2F13 - complex
	cdk2p1-cycA-E2F13 - complex
	CEBP-gP - complex
	CEBP-pRbp2 - complex
	P - complex
	CEBP-pRbp2-gP - complex
	DMP1-cycD - complex
	DMP1-cycDp1 - complex
	E2F6-DP12p1-gE2 - complex
	HDAC1-p107-E2F4-DP12p1 - complex
	HDAC1-p130-E2F4p1-DP12-gE2 - complex
	HDAC1-pRb-E2F4p1-DP12 - complex
	m1433-cdc25Cp2 - complex
	cdc25Cp2 - complex
	p107-E2F4-DP12p1-gE2 - complex
	p107-E2F4-DP12p1 - complex
	PCNA-cycDp1 - complex
	PCNA-cycD - complex
	cdk2-cycEp1 - complex
	cdk2-cycE - complex
	cdk2p1-cycEp1 - complex
	cdk2p1-cycE - complex
	pRb-E2F4p1-DP12-gE2 - complex
	pRbp1-E2F4p1-DP12-gE2 - complex
	RPA-cycA - complex
	cdk2-cycA - complex
	cdk2p1-cycA - complex
	SP1-E2F13-gP - complex
	SP1-E2F13 - complex
	c-Myc - complex
	cycA - complex
	cycD - complex
	cycDp1 - complex
	cycE - complex
	cycEp1 - complex
	p19ARF - complex
	pol - complex
	SP1-gP - complex
	SP1-p107-gP - complex
	SP1-p107p1 - complex
	p107p1 - complex
	SP1-p107 - complex
	p107 - complex
	l0 - level
	l1 - level
	l2 - level
	l3 - level)


(:init
	(possible Wee1)
	(possible SP1)
	(possible RPA)
	(possible pRbp2)
	(possible pRbp1-E2F4p1-DP12)
	(possible pRb-E2F4p1-DP12)
	(possible PCNA)
	(possible m1433)
	(possible HDAC1-p130-E2F4p1-DP12)
	(possible HDAC1)
	(possible gP)
	(possible gE2)
	(possible E2F6-DP12p1)
	(possible E2F4-DP12p1)
	(possible E2F13)
	(possible DMP1)
	(possible C-TAK1)
	(possible CEBP)
	(possible cdk2p1)
	(possible cdk2)
	(possible cdc25C)
	(possible c-Abl)
	(association-reaction c-Abl pRbp2 c-Abl-pRbp2)
	(catalyzed-association-reaction cdc25C C-TAK1 cdc25Cp2)
	(association-reaction cdk2 cycA cdk2-cycA)
	(association-reaction cdk2-cycA E2F13 cdk2-cycA-E2F13)
	(catalyzed-association-reaction cdk2-cycA Wee1 cdk2p1-cycA)
	(association-reaction cdk2 cycE cdk2-cycE)
	(association-reaction cdk2 cycEp1 cdk2-cycEp1)
	(association-reaction cdk2p1 cycA cdk2p1-cycA)
	(association-reaction cdk2p1-cycA E2F13 cdk2p1-cycA-E2F13)
	(association-reaction cdk2p1 cycE cdk2p1-cycE)
	(association-reaction cdk2p1 cycEp1 cdk2p1-cycEp1)
	(association-reaction CEBP gP CEBP-gP)
	(synthesis-reaction CEBP-gP P) 
	(association-reaction CEBP pRbp2 CEBP-pRbp2)
	(association-reaction CEBP-pRbp2 gP CEBP-pRbp2-gP)
	(synthesis-reaction CEBP-pRbp2-gP P) 
	(association-reaction DMP1 cycD DMP1-cycD)
	(association-reaction DMP1 cycDp1 DMP1-cycDp1)
	(association-reaction E2F6-DP12p1 gE2 E2F6-DP12p1-gE2)
	(association-reaction HDAC1 p107-E2F4-DP12p1 HDAC1-p107-E2F4-DP12p1)
	(association-reaction HDAC1-p130-E2F4p1-DP12 gE2 HDAC1-p130-E2F4p1-DP12-gE2)
	(association-reaction HDAC1 pRb-E2F4p1-DP12 HDAC1-pRb-E2F4p1-DP12)
	(association-reaction m1433 cdc25Cp2 m1433-cdc25Cp2)
	(association-reaction p107-E2F4-DP12p1 gE2 p107-E2F4-DP12p1-gE2)
	(association-reaction p107 E2F4-DP12p1 p107-E2F4-DP12p1)
	(association-reaction PCNA cycDp1 PCNA-cycDp1)
	(association-reaction PCNA cycD PCNA-cycD)
	(association-reaction pRb-E2F4p1-DP12 gE2 pRb-E2F4p1-DP12-gE2)
	(association-reaction pRbp1-E2F4p1-DP12 gE2 pRbp1-E2F4p1-DP12-gE2)
	(association-reaction RPA cycA RPA-cycA)
	(synthesis-reaction SP1-E2F13-gP c-Myc) 
	(synthesis-reaction SP1-E2F13-gP cycA) 
	(synthesis-reaction SP1-E2F13-gP cycD) 
	(synthesis-reaction SP1-E2F13-gP cycDp1) 
	(synthesis-reaction SP1-E2F13-gP cycE) 
	(synthesis-reaction SP1-E2F13-gP cycEp1) 
	(synthesis-reaction SP1-E2F13-gP p107) 
	(synthesis-reaction SP1-E2F13-gP p107p1) 
	(synthesis-reaction SP1-E2F13-gP p19ARF) 
	(synthesis-reaction SP1-E2F13-gP pol) 
	(association-reaction SP1-E2F13 gP SP1-E2F13-gP)
	(association-reaction SP1 E2F13 SP1-E2F13)
	(synthesis-reaction SP1-gP c-Myc) 
	(synthesis-reaction SP1-gP cycA) 
	(synthesis-reaction SP1-gP cycD) 
	(synthesis-reaction SP1-gP cycDp1) 
	(synthesis-reaction SP1-gP cycE) 
	(synthesis-reaction SP1-gP cycEp1) 
	(synthesis-reaction SP1-gP p107) 
	(synthesis-reaction SP1-gP p107p1) 
	(synthesis-reaction SP1-gP p19ARF) 
	(synthesis-reaction SP1-gP pol) 
	(association-reaction SP1 gP SP1-gP)
	(association-reaction SP1-p107 gP SP1-p107-gP)
	(association-reaction SP1-p107p1 gP SP1-p107p1-gP)
	(association-reaction SP1 p107p1 SP1-p107p1)
	(association-reaction SP1 p107 SP1-p107)
	(num-subs l0)
	(next l1 l0)
	(next l2 l1)
	(next l3 l2))


(:goal
	(and
	(goal1)
	(goal2)
	(goal3)
	(goal4)))

)
