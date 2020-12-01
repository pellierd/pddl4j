(define (problem Pathways-03)
(:domain Pathways-Propositional)
(:objects
	Wee1 - simple
	SP1 - simple
	RPA - simple
	pRbp2 - simple
	pRb - simple
	p16 - simple
	p130 - simple
	HDAC1 - simple
	gP - simple
	E2F4-DP12p1 - simple
	C-TAK1 - simple
	cks1 - simple
	Chk1 - simple
	cdk46p3-cycD - simple
	cdk46p1 - simple
	cdk2p2-cycB - simple
	cdk1p1p2 - simple
	cdc25C - simple
	AP2 - simple
	cdk1p1p2-cks1 - complex
	cdk2p1p2-cycB - complex
	c-Myc-AP2 - complex
	HDAC1-p107-E2F4-DP12p1 - complex
	HDAC1-p130-E2F4-DP12p1 - complex
	cdc25Cp2 - complex
	p107-E2F4-DP12p1 - complex
	p130-E2F4-DP12p1 - complex
	p16-cdk46p1 - complex
	cdk46p1-cycDp1 - complex
	cdk46p1-cycD - complex
	pRb-AP2 - complex
	pRb-E2F4-DP12p1 - complex
	pRbp1-AP2 - complex
	pRbp1-E2F4-DP12p1 - complex
	pRbp1 - complex
	pRbp1p2-AP2 - complex
	pRbp2-AP2 - complex
	pRbp1p2 - complex
	RPA-cycA - complex
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
	(possible pRb)
	(possible p16)
	(possible p130)
	(possible HDAC1)
	(possible gP)
	(possible E2F4-DP12p1)
	(possible C-TAK1)
	(possible cks1)
	(possible Chk1)
	(possible cdk46p3-cycD)
	(possible cdk46p1)
	(possible cdk2p2-cycB)
	(possible cdk1p1p2)
	(possible cdc25C)
	(possible AP2)
	(catalyzed-association-reaction cdc25C Chk1 cdc25Cp2)
	(catalyzed-association-reaction cdc25C C-TAK1 cdc25Cp2)
	(association-reaction cdk1p1p2 cks1 cdk1p1p2-cks1)
	(catalyzed-association-reaction cdk2p2-cycB Wee1 cdk2p1p2-cycB)
	(association-reaction cdk46p1 cycD cdk46p1-cycD)
	(association-reaction cdk46p1 cycDp1 cdk46p1-cycDp1)
	(association-reaction c-Myc AP2 c-Myc-AP2)
	(association-reaction HDAC1 p107-E2F4-DP12p1 HDAC1-p107-E2F4-DP12p1)
	(association-reaction HDAC1 p130-E2F4-DP12p1 HDAC1-p130-E2F4-DP12p1)
	(association-reaction p107 E2F4-DP12p1 p107-E2F4-DP12p1)
	(association-reaction p130 E2F4-DP12p1 p130-E2F4-DP12p1)
	(association-reaction p16 cdk46p1 p16-cdk46p1)
	(association-reaction pRb AP2 pRb-AP2)
	(catalyzed-association-reaction pRb cdk46p3-cycD pRbp1)
	(association-reaction pRb E2F4-DP12p1 pRb-E2F4-DP12p1)
	(association-reaction pRbp1 AP2 pRbp1-AP2)
	(association-reaction pRbp1 E2F4-DP12p1 pRbp1-E2F4-DP12p1)
	(association-reaction pRbp1p2 AP2 pRbp1p2-AP2)
	(association-reaction pRbp2 AP2 pRbp2-AP2)
	(catalyzed-association-reaction pRbp2 cdk46p3-cycD pRbp1p2)
	(association-reaction RPA cycA RPA-cycA)
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
	(goal3)))

)
