(define (problem Pathways-02)
(:domain Pathways-Propositional)
(:objects
	p53p1 - simple
	p130 - simple
	Max - simple
	HDAC1-pRbp1-E2F4-DP12 - simple
	HDAC1-pRbp1-E2F13-DP12 - simple
	HDAC1-p130-E2F4p1-DP12 - simple
	HBP1 - simple
	gE2 - simple
	E2F6-DP12p1 - simple
	E2F4-DP12p1 - simple
	E2F13p1-DP12 - simple
	cdk1p1p2 - simple
	cdk1p1p2-Gadd45 - complex
	c-Myc-Max - complex
	E2F13p1-DP12-gE2 - complex
	E2F6-DP12p1-gE2 - complex
	HBP1-p130 - complex
	HDAC1-p130-E2F4p1-DP12-gE2 - complex
	HDAC1-pRbp1-E2F13-DP12-gE2 - complex
	HDAC1-pRbp1-E2F4-DP12-gE2 - complex
	Mdm2-E2F13p1-DP12 - complex
	p107-E2F4-DP12p1 - complex
	p130-E2F4-DP12p1-gE2 - complex
	p130-E2F4-DP12p1 - complex
	p21-Gadd45 - complex
	Mdm2 - complex
	Gadd45 - complex
	p21 - complex
	c-Fos - complex
	c-Myc - complex
	cycA - complex
	cycD - complex
	cycDp1 - complex
	cycE - complex
	cycEp1 - complex
	p19ARF - complex
	pol - complex
	p107p1 - complex
	p107 - complex
	l0 - level
	l1 - level
	l2 - level
	l3 - level)


(:init
	(possible p53p1)
	(possible p130)
	(possible Max)
	(possible HDAC1-pRbp1-E2F4-DP12)
	(possible HDAC1-pRbp1-E2F13-DP12)
	(possible HDAC1-p130-E2F4p1-DP12)
	(possible HBP1)
	(possible gE2)
	(possible E2F6-DP12p1)
	(possible E2F4-DP12p1)
	(possible E2F13p1-DP12)
	(possible cdk1p1p2)
	(association-reaction cdk1p1p2 Gadd45 cdk1p1p2-Gadd45)
	(association-reaction c-Myc Max c-Myc-Max)
	(synthesis-reaction E2F13p1-DP12-gE2 c-Myc) 
	(synthesis-reaction E2F13p1-DP12-gE2 cycA) 
	(synthesis-reaction E2F13p1-DP12-gE2 cycD) 
	(synthesis-reaction E2F13p1-DP12-gE2 cycDp1) 
	(synthesis-reaction E2F13p1-DP12-gE2 cycE) 
	(synthesis-reaction E2F13p1-DP12-gE2 cycEp1) 
	(association-reaction E2F13p1-DP12 gE2 E2F13p1-DP12-gE2)
	(synthesis-reaction E2F13p1-DP12-gE2 p107) 
	(synthesis-reaction E2F13p1-DP12-gE2 p107p1) 
	(synthesis-reaction E2F13p1-DP12-gE2 p19ARF) 
	(synthesis-reaction E2F13p1-DP12-gE2 pol) 
	(association-reaction E2F6-DP12p1 gE2 E2F6-DP12p1-gE2)
	(association-reaction HBP1 p130 HBP1-p130)
	(association-reaction HDAC1-p130-E2F4p1-DP12 gE2 HDAC1-p130-E2F4p1-DP12-gE2)
	(association-reaction HDAC1-pRbp1-E2F13-DP12 gE2 HDAC1-pRbp1-E2F13-DP12-gE2)
	(association-reaction HDAC1-pRbp1-E2F4-DP12 gE2 HDAC1-pRbp1-E2F4-DP12-gE2)
	(association-reaction Mdm2 E2F13p1-DP12 Mdm2-E2F13p1-DP12)
	(association-reaction p107-E2F4-DP12p1 gE2 p107-E2F4-DP12p1-gE2)
	(association-reaction p107 E2F4-DP12p1 p107-E2F4-DP12p1)
	(association-reaction p130-E2F4-DP12p1 gE2 p130-E2F4-DP12p1-gE2)
	(association-reaction p130 E2F4-DP12p1 p130-E2F4-DP12p1)
	(association-reaction p21 Gadd45 p21-Gadd45)
	(synthesis-reaction p53p1 c-Fos) 
	(synthesis-reaction p53p1 Gadd45) 
	(synthesis-reaction p53p1 Mdm2) 
	(synthesis-reaction p53p1 p21) 
	(num-subs l0)
	(next l1 l0)
	(next l2 l1)
	(next l3 l2))


(:goal
	(and
	(goal1)
	(goal2)))

)
