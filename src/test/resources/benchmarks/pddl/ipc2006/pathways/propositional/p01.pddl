(define (problem Pathways-01)
(:domain Pathways-Propositional)
(:objects
	SP1 - simple
	Raf1 - simple
	pRbp2 - simple
	pRb-E2F4p1-DP12 - simple
	pCAF - simple
	p300 - simple
	p16 - simple
	p130-E2F5p1-DP12 - simple
	E2F13 - simple
	DMP1 - simple
	Chk1 - simple
	cdk7 - simple
	cdk46p3-cycDp1 - simple
	cdk46p3-cycD - simple
	cdc25C - simple
	AP2 - simple
	DMP1p1 - complex
	cdc25Cp2 - complex
	p16-cdk7 - complex
	pCAF-p300 - complex
	pRbp2-AP2 - complex
	pRbp1p2 - complex
	Raf1-p130-E2F5p1-DP12 - complex
	Raf1-pRb-E2F4p1-DP12 - complex
	SP1-E2F13 - complex
	l0 - level
	l1 - level
	l2 - level
	l3 - level)


(:init
	(possible SP1)
	(possible Raf1)
	(possible pRbp2)
	(possible pRb-E2F4p1-DP12)
	(possible pCAF)
	(possible p300)
	(possible p16)
	(possible p130-E2F5p1-DP12)
	(possible E2F13)
	(possible DMP1)
	(possible Chk1)
	(possible cdk7)
	(possible cdk46p3-cycDp1)
	(possible cdk46p3-cycD)
	(possible cdc25C)
	(possible AP2)
	(catalyzed-association-reaction cdc25C Chk1 cdc25Cp2)
	(catalyzed-association-reaction DMP1 cdk46p3-cycD DMP1p1)
	(catalyzed-association-reaction DMP1 cdk46p3-cycDp1 DMP1p1)
	(association-reaction p16 cdk7 p16-cdk7)
	(association-reaction pCAF p300 pCAF-p300)
	(association-reaction pRbp1p2 AP2 pRbp1p2-AP2)
	(association-reaction pRbp2 AP2 pRbp2-AP2)
	(catalyzed-association-reaction pRbp2 cdk46p3-cycDp1 pRbp1p2)
	(catalyzed-association-reaction pRbp2 cdk46p3-cycD pRbp1p2)
	(association-reaction Raf1 p130-E2F5p1-DP12 Raf1-p130-E2F5p1-DP12)
	(association-reaction Raf1 pRb-E2F4p1-DP12 Raf1-pRb-E2F4p1-DP12)
	(association-reaction SP1 E2F13 SP1-E2F13)
	(num-subs l0)
	(next l1 l0)
	(next l2 l1)
	(next l3 l2))


(:goal
	(and
	(goal1)))

)
