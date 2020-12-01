(define (problem Pathways-20)
(:domain Pathways-Propositional)
(:objects
	Wee1 - simple
	SP1 - simple
	Skp2 - simple
	Skp1 - simple
	RPA - simple
	pRbp2 - simple
	pRbp1-E2F4p1-DP12 - simple
	pRb-E2F4p1-DP12 - simple
	pRb - simple
	Plk1 - simple
	pCAF - simple
	p57p1 - simple
	p57 - simple
	p53p1 - simple
	p53 - simple
	p300 - simple
	p27 - simple
	p16 - simple
	p130 - simple
	m1433 - simple
	HDAC1-pRbp1-E2F4-DP12 - simple
	HDAC1-pRbp1-E2F13p1-DP12 - simple
	HDAC1-p130-E2F4p1-DP12 - simple
	HDAC1-p107-E2F4p1-DP12 - simple
	HBP1 - simple
	gE-c - simple
	gE2 - simple
	E2F6 - simple
	E2F4-DP12p1 - simple
	E2F4 - simple
	E2F3 - simple
	E2F13p1-DP12p1 - simple
	E2F13-DP12 - simple
	E2F13 - simple
	E2F1 - simple
	DP12 - simple
	cycH - simple
	cycB - simple
	C-TAK1 - simple
	cks1 - simple
	Chk1 - simple
	CEBP - simple
	cdk7 - simple
	cdk46p3-cycDp1 - simple
	cdk46p1 - simple
	cdk2p1 - simple
	cdk2-cycB - simple
	cdk2 - simple
	cdk1p1p2 - simple
	cdc25C - simple
	c-Abl - simple
	AP2 - simple
	AP2-gE-c - complex
	c-Abl-pRb - complex
	c-Abl-pRbp1 - complex
	c-Abl-pRbp1p2 - complex
	c-Abl-pRbp2 - complex
	cdk1-cks1 - complex
	cdk1-Gadd45 - complex
	cdk1p1-cks1 - complex
	cdk1p1-Gadd45 - complex
	cdk1p1 - complex
	cdk1p1p2-cks1 - complex
	cdk1p1p2-Gadd45 - complex
	cdk1p1p2p3-cks1 - complex
	cdk1p1p2p3-Gadd45 - complex
	cdk1p1p2p3 - complex
	cdk1p1p3-cks1 - complex
	cdk1p1p3-Gadd45 - complex
	cdk1p1p3 - complex
	cdk1 - complex
	cdk1p2-cks1 - complex
	cdk1p2-Gadd45 - complex
	cdk1p2 - complex
	cdk1p2p3-cks1 - complex
	cdk1p1p2p3-cycA - complex
	cdc25Cp1 - complex
	cdk1p1p2p3-cycB - complex
	cdk1p2p3-Gadd45 - complex
	cdk1p2p3 - complex
	cdk1p3-cks1 - complex
	cdk1p1p3-cycA - complex
	cdk1p2p3-cycA - complex
	cdk1p1p3-cycB - complex
	cdk1p2p3-cycB - complex
	cdk1p3-Gadd45 - complex
	cdk1p3 - complex
	cdk2-cks1 - complex
	cdk2-cycA-E2F13 - complex
	cdk2-cycA-E2F13p1 - complex
	cdk2p1-cycB - complex
	cdk2p1-cks1 - complex
	cdk2p1-cycA-E2F13 - complex
	cdk2p1-cycA-E2F13p1 - complex
	cdk2p1p2-cks1 - complex
	cdk2p1p2-cycA-E2F13 - complex
	cdk2p1p2-cycA-E2F13p1 - complex
	cdk2p1p2 - complex
	cdk2p2-cks1 - complex
	cdk2p2-cycA-E2F13 - complex
	cdk2p2-cycA-E2F13p1 - complex
	cdk2p2 - complex
	cdk7-cycH - complex
	cdk7p1-cycH - complex
	CEBP-pRb - complex
	CEBP-pRbp1 - complex
	CEBP-pRbp1p2 - complex
	CEBP-pRbp2 - complex
	c-Myc-AP2 - complex
	E2F13-DP12-gE2 - complex
	E2F1-DP12 - complex
	E2F3-DP12 - complex
	E2F4-DP12-gE2 - complex
	E2F6-DP12-gE2 - complex
	E2F6-DP12 - complex
	HBP1-p130 - complex
	HDAC1-p107-E2F4p1-DP12-gE2 - complex
	HDAC1-p130-E2F4p1-DP12-gE2 - complex
	HDAC1-pRbp1-E2F13p1-DP12-gE2 - complex
	HDAC1-pRbp1-E2F4-DP12-gE2 - complex
	m1433-cdc25Cp1p2 - complex
	cdc25Cp1p2 - complex
	m1433-cdc25Cp2 - complex
	cdc25Cp2 - complex
	Mdm2-E2F13-DP12 - complex
	Mdm2-E2F13p1-DP12p1 - complex
	Mdm2-pRb - complex
	Mdm2-pRbp1 - complex
	Mdm2-pRbp1p2 - complex
	Mdm2-pRbp2 - complex
	p107-E2F4-DP12-gE2 - complex
	p107-E2F4-DP12 - complex
	p107-E2F4-DP12p1-gE2 - complex
	p107-E2F4-DP12p1 - complex
	p130-E2F4-DP12-gE2 - complex
	p130-E2F4-DP12p1-gE2 - complex
	p130-E2F4-DP12p1 - complex
	p16-cdk46p1 - complex
	p16-cdk46p1p2 - complex
	cdk46p1p2 - complex
	p16-cdk7 - complex
	p16-cdk7p1 - complex
	cdk7p1 - complex
	p21-cdk2-cycA - complex
	p21-cdk2-cycEp1 - complex
	p21-cdk2-cycE - complex
	p21-cdk2p1-cycA - complex
	p21-cdk2p1-cycEp1 - complex
	p21-cdk2p1-cycE - complex
	p21-cdk2p1p2-cycA - complex
	p21-cdk2p1p2-cycEp1 - complex
	p21-cdk2p1p2-cycE - complex
	p21-cdk2p2-cycA - complex
	p21-cdk2p2-cycEp1 - complex
	p21-cdk2p2-cycE - complex
	p21-cdk46p1-cycDp1 - complex
	p21-cdk46p1-cycD - complex
	p21-cdk46p1p2-cycDp1 - complex
	p21-cdk46p1p2-cycD - complex
	p21-Gadd45 - complex
	p27-cdk2-cycA - complex
	p27-cdk2-cycEp1 - complex
	p27-cdk2-cycE - complex
	p27-cdk2p1-cycA - complex
	p27-cdk2p1-cycEp1 - complex
	p27-cdk2p1-cycE - complex
	p27-cdk2p1p2-cycA - complex
	p27-cdk2p1p2-cycEp1 - complex
	p27-cdk2p1p2-cycE - complex
	p27-cdk2p2-cycA - complex
	p27-cdk2p2-cycEp1 - complex
	p27-cdk2p2-cycE - complex
	p27-cdk46p1-cycDp1 - complex
	p27-cdk46p1-cycD - complex
	p27-cdk46p1p2-cycDp1 - complex
	p27-cdk46p1p2-cycD - complex
	p27p1-cdk2-cycA - complex
	p27p1-cdk2-cycEp1 - complex
	p27p1-cdk2-cycE - complex
	p27p1-cdk2p1-cycA - complex
	p27p1-cdk2p1-cycEp1 - complex
	p27p1-cdk2p1-cycE - complex
	p27p1-cdk2p1p2-cycA - complex
	p27p1-cdk2p1p2-cycEp1 - complex
	p27p1-cdk2p1p2-cycE - complex
	p27p1-cdk2p2-cycA - complex
	p27p1-cdk2p2-cycEp1 - complex
	p27p1-cdk2p2-cycE - complex
	p27p1-cdk46p1-cycDp1 - complex
	p27p1-cdk46p1-cycD - complex
	p27p1-cdk46p1p2-cycDp1 - complex
	p27p1-cdk46p1p2-cycD - complex
	p27p1 - complex
	p53-DP12p1 - complex
	p53-DP12 - complex
	p53p1-DP12p1 - complex
	DP12p1 - complex
	p53p1-DP12 - complex
	Mdm2 - complex
	p57-cdk2-cycA - complex
	p57-cdk2-cycEp1 - complex
	p57-cdk2-cycE - complex
	p57-cdk2p1-cycA - complex
	p57-cdk2p1-cycEp1 - complex
	p57-cdk2p1-cycE - complex
	p57-cdk2p1p2-cycA - complex
	p57-cdk2p1p2-cycEp1 - complex
	p57-cdk2p1p2-cycE - complex
	p57-cdk2p2-cycA - complex
	p57-cdk2p2-cycEp1 - complex
	p57-cdk2p2-cycE - complex
	p57-cdk46p1-cycDp1 - complex
	p57-cdk46p1-cycD - complex
	p57-cdk46p1p2-cycDp1 - complex
	p57-cdk46p1p2-cycD - complex
	p57p1-cdk46p1-cycDp1 - complex
	p57p1-cdk46p1-cycD - complex
	p57p1-cdk46p1p2-cycDp1 - complex
	p57p1-cdk46p1p2-cycD - complex
	pCAF-p300 - complex
	Gadd45 - complex
	cdk2-cycEp1 - complex
	cdk2-cycE - complex
	cdk2p1-cycEp1 - complex
	cdk2p1-cycE - complex
	cdk2p1p2-cycEp1 - complex
	cdk2p1p2-cycE - complex
	cdk46p1-cycDp1 - complex
	cdk46p1-cycD - complex
	cdk46p1p2-cycDp1 - complex
	cdk46p1p2-cycD - complex
	p21 - complex
	pRb-AP2-gE-c - complex
	pRb-AP2 - complex
	pRb-E2F13-DP12-gE2 - complex
	pRb-E2F13p1-DP12p1-gE2 - complex
	pRb-E2F4-DP12-gE2 - complex
	pRb-E2F4-DP12p1 - complex
	pRb-E2F4p1-DP12-gE2 - complex
	pRbp1-AP2-gE-c - complex
	pRbp1-AP2 - complex
	cdk2p2-cycEp1 - complex
	cdk2p2-cycE - complex
	pRbp1-E2F13-DP12-gE2 - complex
	pRbp1-E2F13p1-DP12p1-gE2 - complex
	pRbp1-E2F4-DP12-gE2 - complex
	pRbp1-E2F4-DP12p1 - complex
	E2F4-DP12 - complex
	pRbp1-E2F4p1-DP12-gE2 - complex
	pRbp1 - complex
	pRbp1p2-AP2-gE-c - complex
	pRbp1p2-AP2 - complex
	Ecadherin - complex
	pRbp2-AP2-gE-c - complex
	pRbp2-AP2 - complex
	pRbp1p2 - complex
	c-Fos - complex
	p130-E2F4-DP12 - complex
	pRb-E2F13-DP12 - complex
	pRb-E2F13p1-DP12p1 - complex
	pRb-E2F4-DP12 - complex
	pRbp1-E2F13-DP12 - complex
	pRbp1-E2F13p1-DP12p1 - complex
	pRbp1-E2F4-DP12 - complex
	RPA-cycA - complex
	Skp2-cdk2-cycA - complex
	Skp2-cdk2p1-cycA - complex
	Skp2-cdk2p1p2-cycA - complex
	Skp2-cdk2p2-cycA - complex
	Skp2p1-Skp1p1 - complex
	Skp2p1-Skp1 - complex
	Skp2p1 - complex
	Skp2-Skp1-cdk2-cycA - complex
	Skp2-Skp1-cdk2p1-cycA - complex
	Skp2-Skp1-cdk2p1p2-cycA - complex
	Skp2-Skp1-cdk2p2-cycA - complex
	Skp2-Skp1p1-cdk2-cycA - complex
	cdk2-cycA - complex
	Skp2-Skp1p1-cdk2p1-cycA - complex
	cdk2p1-cycA - complex
	Skp2-Skp1p1-cdk2p1p2-cycA - complex
	cdk2p1p2-cycA - complex
	Skp2-Skp1p1-cdk2p2-cycA - complex
	cdk2p2-cycA - complex
	Skp2-Skp1p1 - complex
	Skp1p1 - complex
	Skp2-Skp1 - complex
	SP1-E2F13p1 - complex
	E2F13p1 - complex
	SP1-E2F13 - complex
	c-Myc - complex
	cycA - complex
	cycD - complex
	cycDp1 - complex
	cycE - complex
	cycEp1 - complex
	p19ARF - complex
	pol - complex
	SP1-p107p1 - complex
	p107p1 - complex
	SP1-p107 - complex
	p107 - complex
	cdk1p3-cycA - complex
	cdk1p3-cycB - complex
	l0 - level
	l1 - level
	l2 - level
	l3 - level
	l4 - level
	l5 - level
	l6 - level
	l7 - level
	l8 - level
	l9 - level
	l10 - level
	l11 - level
	l12 - level
	l13 - level
	l14 - level
	l15 - level
	l16 - level
	l17 - level
	l18 - level
	l19 - level
	l20 - level
	l21 - level)


(:init
	(possible Wee1)
	(possible SP1)
	(possible Skp2)
	(possible Skp1)
	(possible RPA)
	(possible pRbp2)
	(possible pRbp1-E2F4p1-DP12)
	(possible pRb-E2F4p1-DP12)
	(possible pRb)
	(possible Plk1)
	(possible pCAF)
	(possible p57p1)
	(possible p57)
	(possible p53p1)
	(possible p53)
	(possible p300)
	(possible p27)
	(possible p16)
	(possible p130)
	(possible m1433)
	(possible HDAC1-pRbp1-E2F4-DP12)
	(possible HDAC1-pRbp1-E2F13p1-DP12)
	(possible HDAC1-p130-E2F4p1-DP12)
	(possible HDAC1-p107-E2F4p1-DP12)
	(possible HBP1)
	(possible gE-c)
	(possible gE2)
	(possible E2F6)
	(possible E2F4-DP12p1)
	(possible E2F4)
	(possible E2F3)
	(possible E2F13p1-DP12p1)
	(possible E2F13-DP12)
	(possible E2F13)
	(possible E2F1)
	(possible DP12)
	(possible cycH)
	(possible cycB)
	(possible C-TAK1)
	(possible cks1)
	(possible Chk1)
	(possible CEBP)
	(possible cdk7)
	(possible cdk46p3-cycDp1)
	(possible cdk46p1)
	(possible cdk2p1)
	(possible cdk2-cycB)
	(possible cdk2)
	(possible cdk1p1p2)
	(possible cdc25C)
	(possible c-Abl)
	(possible AP2)
	(association-reaction AP2 gE-c AP2-gE-c)
	(synthesis-reaction AP2-gE-c Ecadherin) 
	(association-reaction c-Abl pRb c-Abl-pRb)
	(association-reaction c-Abl pRbp1 c-Abl-pRbp1)
	(association-reaction c-Abl pRbp1p2 c-Abl-pRbp1p2)
	(association-reaction c-Abl pRbp2 c-Abl-pRbp2)
	(catalyzed-association-reaction cdc25C cdk1p3-cycA cdc25Cp1)
	(catalyzed-association-reaction cdc25C cdk1p3-cycB cdc25Cp1)
	(catalyzed-association-reaction cdc25C Chk1 cdc25Cp2)
	(catalyzed-association-reaction cdc25C C-TAK1 cdc25Cp2)
	(catalyzed-association-reaction cdc25Cp1 Chk1 cdc25Cp1p2)
	(catalyzed-association-reaction cdc25Cp1 C-TAK1 cdc25Cp1p2)
	(catalyzed-association-reaction cdc25Cp2 cdk1p3-cycA cdc25Cp1p2)
	(catalyzed-association-reaction cdc25Cp2 cdk1p3-cycB cdc25Cp1p2)
	(catalyzed-association-reaction cdc25Cp2 Plk1 cdc25Cp1p2)
	(catalyzed-association-reaction cdc25C Plk1 cdc25Cp1)
	(catalyzed-association-reaction cdk1 cdk7-cycH cdk1p3)
	(association-reaction cdk1 cks1 cdk1-cks1)
	(association-reaction cdk1 Gadd45 cdk1-Gadd45)
	(catalyzed-association-reaction cdk1p1 cdc25Cp1 cdk1)
	(catalyzed-association-reaction cdk1p1 cdc25Cp1p2 cdk1)
	(catalyzed-association-reaction cdk1p1 cdk7-cycH cdk1p1p3)
	(association-reaction cdk1p1 cks1 cdk1p1-cks1)
	(association-reaction cdk1p1 Gadd45 cdk1p1-Gadd45)
	(catalyzed-association-reaction cdk1p1p2 cdc25Cp1 cdk1p1)
	(catalyzed-association-reaction cdk1p1p2 cdc25Cp1 cdk1p2)
	(catalyzed-association-reaction cdk1p1p2 cdc25Cp1p2 cdk1p1)
	(catalyzed-association-reaction cdk1p1p2 cdc25Cp1p2 cdk1p2)
	(catalyzed-association-reaction cdk1p1p2 cdk7-cycH cdk1p1p2p3)
	(association-reaction cdk1p1p2 cks1 cdk1p1p2-cks1)
	(association-reaction cdk1p1p2 Gadd45 cdk1p1p2-Gadd45)
	(catalyzed-association-reaction cdk1p1p2p3 cdc25Cp1 cdk1p1p3)
	(catalyzed-association-reaction cdk1p1p2p3 cdc25Cp1 cdk1p2p3)
	(catalyzed-association-reaction cdk1p1p2p3 cdc25Cp1p2 cdk1p1p3)
	(catalyzed-association-reaction cdk1p1p2p3 cdc25Cp1p2 cdk1p2p3)
	(association-reaction cdk1p1p2p3 cks1 cdk1p1p2p3-cks1)
	(catalyzed-association-reaction cdk1p1p2p3-cycA cdc25Cp1 cdk1p1p3-cycA)
	(catalyzed-association-reaction cdk1p1p2p3-cycA cdc25Cp1 cdk1p2p3-cycA)
	(catalyzed-association-reaction cdk1p1p2p3-cycA cdc25Cp1p2 cdk1p1p3-cycA)
	(catalyzed-association-reaction cdk1p1p2p3-cycA cdc25Cp1p2 cdk1p2p3-cycA)
	(association-reaction cdk1p1p2p3 cycA cdk1p1p2p3-cycA)
	(catalyzed-association-reaction cdk1p1p2p3-cycB cdc25Cp1 cdk1p1p3-cycB)
	(catalyzed-association-reaction cdk1p1p2p3-cycB cdc25Cp1 cdk1p2p3-cycB)
	(catalyzed-association-reaction cdk1p1p2p3-cycB cdc25Cp1p2 cdk1p1p3-cycB)
	(catalyzed-association-reaction cdk1p1p2p3-cycB cdc25Cp1p2 cdk1p2p3-cycB)
	(association-reaction cdk1p1p2p3 cycB cdk1p1p2p3-cycB)
	(association-reaction cdk1p1p2p3 Gadd45 cdk1p1p2p3-Gadd45)
	(catalyzed-association-reaction cdk1p1p3 cdc25Cp1 cdk1p3)
	(catalyzed-association-reaction cdk1p1p3 cdc25Cp1p2 cdk1p3)
	(association-reaction cdk1p1p3 cks1 cdk1p1p3-cks1)
	(catalyzed-association-reaction cdk1p1p3-cycA cdc25Cp1 cdk1p3-cycA)
	(catalyzed-association-reaction cdk1p1p3-cycA cdc25Cp1p2 cdk1p3-cycA)
	(association-reaction cdk1p1p3 cycA cdk1p1p3-cycA)
	(catalyzed-association-reaction cdk1p1p3-cycA Wee1 cdk1p1p2p3-cycA)
	(catalyzed-association-reaction cdk1p1p3-cycB cdc25Cp1 cdk1p3-cycB)
	(catalyzed-association-reaction cdk1p1p3-cycB cdc25Cp1p2 cdk1p3-cycB)
	(association-reaction cdk1p1p3 cycB cdk1p1p3-cycB)
	(catalyzed-association-reaction cdk1p1p3-cycB Wee1 cdk1p1p2p3-cycB)
	(association-reaction cdk1p1p3 Gadd45 cdk1p1p3-Gadd45)
	(catalyzed-association-reaction cdk1p2 cdc25Cp1 cdk1)
	(catalyzed-association-reaction cdk1p2 cdc25Cp1p2 cdk1)
	(catalyzed-association-reaction cdk1p2 cdk7-cycH cdk1p2p3)
	(association-reaction cdk1p2 cks1 cdk1p2-cks1)
	(association-reaction cdk1p2 Gadd45 cdk1p2-Gadd45)
	(catalyzed-association-reaction cdk1p2p3 cdc25Cp1 cdk1p3)
	(catalyzed-association-reaction cdk1p2p3 cdc25Cp1p2 cdk1p3)
	(association-reaction cdk1p2p3 cks1 cdk1p2p3-cks1)
	(catalyzed-association-reaction cdk1p2p3-cycA cdc25Cp1 cdk1p3-cycA)
	(catalyzed-association-reaction cdk1p2p3-cycA cdc25Cp1p2 cdk1p3-cycA)
	(association-reaction cdk1p2p3 cycA cdk1p2p3-cycA)
	(catalyzed-association-reaction cdk1p2p3-cycB cdc25Cp1 cdk1p3-cycB)
	(catalyzed-association-reaction cdk1p2p3-cycB cdc25Cp1p2 cdk1p3-cycB)
	(association-reaction cdk1p2p3 cycB cdk1p2p3-cycB)
	(association-reaction cdk1p2p3 Gadd45 cdk1p2p3-Gadd45)
	(association-reaction cdk1p3 cks1 cdk1p3-cks1)
	(association-reaction cdk1p3 cycA cdk1p3-cycA)
	(catalyzed-association-reaction cdk1p3-cycA Wee1 cdk1p2p3-cycA)
	(association-reaction cdk1p3 cycB cdk1p3-cycB)
	(catalyzed-association-reaction cdk1p3-cycB Wee1 cdk1p2p3-cycB)
	(association-reaction cdk1p3 Gadd45 cdk1p3-Gadd45)
	(catalyzed-association-reaction cdk2 cdk7-cycH cdk2p2)
	(association-reaction cdk2 cks1 cdk2-cks1)
	(association-reaction cdk2 cycA cdk2-cycA)
	(catalyzed-association-reaction cdk2-cycA cdk7-cycH cdk2p2-cycA)
	(association-reaction cdk2-cycA E2F13 cdk2-cycA-E2F13)
	(association-reaction cdk2-cycA E2F13p1 cdk2-cycA-E2F13p1)
	(catalyzed-association-reaction cdk2-cycA Wee1 cdk2p1-cycA)
	(catalyzed-association-reaction cdk2-cycB Wee1 cdk2p1-cycB)
	(association-reaction cdk2 cycE cdk2-cycE)
	(catalyzed-association-reaction cdk2-cycE cdk7-cycH cdk2p2-cycE)
	(association-reaction cdk2 cycEp1 cdk2-cycEp1)
	(catalyzed-association-reaction cdk2-cycEp1 cdk7-cycH cdk2p2-cycEp1)
	(catalyzed-association-reaction cdk2p1 cdk7-cycH cdk2p1p2)
	(association-reaction cdk2p1 cks1 cdk2p1-cks1)
	(association-reaction cdk2p1 cycA cdk2p1-cycA)
	(catalyzed-association-reaction cdk2p1-cycA cdk7-cycH cdk2p1p2-cycA)
	(association-reaction cdk2p1-cycA E2F13 cdk2p1-cycA-E2F13)
	(association-reaction cdk2p1-cycA E2F13p1 cdk2p1-cycA-E2F13p1)
	(association-reaction cdk2p1 cycE cdk2p1-cycE)
	(catalyzed-association-reaction cdk2p1-cycE cdk7-cycH cdk2p1p2-cycE)
	(association-reaction cdk2p1 cycEp1 cdk2p1-cycEp1)
	(catalyzed-association-reaction cdk2p1-cycEp1 cdk7-cycH cdk2p1p2-cycEp1)
	(association-reaction cdk2p1p2 cks1 cdk2p1p2-cks1)
	(association-reaction cdk2p1p2 cycA cdk2p1p2-cycA)
	(association-reaction cdk2p1p2-cycA E2F13 cdk2p1p2-cycA-E2F13)
	(association-reaction cdk2p1p2-cycA E2F13p1 cdk2p1p2-cycA-E2F13p1)
	(association-reaction cdk2p1p2 cycE cdk2p1p2-cycE)
	(association-reaction cdk2p1p2 cycEp1 cdk2p1p2-cycEp1)
	(association-reaction cdk2p2 cks1 cdk2p2-cks1)
	(association-reaction cdk2p2 cycA cdk2p2-cycA)
	(association-reaction cdk2p2-cycA E2F13 cdk2p2-cycA-E2F13)
	(association-reaction cdk2p2-cycA E2F13p1 cdk2p2-cycA-E2F13p1)
	(catalyzed-association-reaction cdk2p2-cycA Wee1 cdk2p1p2-cycA)
	(association-reaction cdk2p2 cycE cdk2p2-cycE)
	(association-reaction cdk2p2 cycEp1 cdk2p2-cycEp1)
	(catalyzed-association-reaction cdk46p1 cdk7-cycH cdk46p1p2)
	(association-reaction cdk46p1 cycD cdk46p1-cycD)
	(catalyzed-association-reaction cdk46p1-cycD cdk7-cycH cdk46p1p2-cycD)
	(association-reaction cdk46p1 cycDp1 cdk46p1-cycDp1)
	(catalyzed-association-reaction cdk46p1-cycDp1 cdk7-cycH cdk46p1p2-cycDp1)
	(association-reaction cdk46p1p2 cycD cdk46p1p2-cycD)
	(association-reaction cdk46p1p2 cycDp1 cdk46p1p2-cycDp1)
	(catalyzed-association-reaction cdk7 cdk7-cycH cdk7p1)
	(association-reaction cdk7 cycH cdk7-cycH)
	(catalyzed-association-reaction cdk7-cycH cdk7-cycH cdk7p1-cycH)
	(association-reaction cdk7p1 cycH cdk7p1-cycH)
	(association-reaction CEBP pRb CEBP-pRb)
	(association-reaction CEBP pRbp1 CEBP-pRbp1)
	(association-reaction CEBP pRbp1p2 CEBP-pRbp1p2)
	(association-reaction CEBP pRbp2 CEBP-pRbp2)
	(association-reaction c-Myc AP2 c-Myc-AP2)
	(catalyzed-association-reaction cycA Skp2p1-Skp1 Skp2p1-Skp1)
	(catalyzed-association-reaction cycA Skp2p1-Skp1p1 Skp2p1-Skp1p1)
	(catalyzed-association-reaction cycA Skp2-Skp1 Skp2-Skp1)
	(catalyzed-association-reaction cycA Skp2-Skp1p1 Skp2-Skp1p1)
	(catalyzed-association-reaction cycE cdk2p2-cycE cycEp1)
	(catalyzed-association-reaction cycE cdk2p2-cycEp1 cycEp1)
	(catalyzed-association-reaction DP12 cdk2p2-cycA DP12p1)
	(catalyzed-association-reaction E2F13 cdk2p2-cycA E2F13p1)
	(synthesis-reaction E2F13-DP12-gE2 c-Myc) 
	(synthesis-reaction E2F13-DP12-gE2 cycA) 
	(synthesis-reaction E2F13-DP12-gE2 cycD) 
	(synthesis-reaction E2F13-DP12-gE2 cycDp1) 
	(synthesis-reaction E2F13-DP12-gE2 cycE) 
	(synthesis-reaction E2F13-DP12-gE2 cycEp1) 
	(association-reaction E2F13-DP12 gE2 E2F13-DP12-gE2)
	(synthesis-reaction E2F13-DP12-gE2 p107) 
	(synthesis-reaction E2F13-DP12-gE2 p107p1) 
	(synthesis-reaction E2F13-DP12-gE2 p19ARF) 
	(synthesis-reaction E2F13-DP12-gE2 pol) 
	(association-reaction E2F1 DP12 E2F1-DP12)
	(association-reaction E2F3 DP12 E2F3-DP12)
	(association-reaction E2F4 DP12 E2F4-DP12)
	(synthesis-reaction E2F4-DP12-gE2 c-Myc) 
	(synthesis-reaction E2F4-DP12-gE2 cycA) 
	(synthesis-reaction E2F4-DP12-gE2 cycD) 
	(synthesis-reaction E2F4-DP12-gE2 cycDp1) 
	(synthesis-reaction E2F4-DP12-gE2 cycE) 
	(synthesis-reaction E2F4-DP12-gE2 cycEp1) 
	(association-reaction E2F4-DP12 gE2 E2F4-DP12-gE2)
	(synthesis-reaction E2F4-DP12-gE2 p107) 
	(synthesis-reaction E2F4-DP12-gE2 p107p1) 
	(synthesis-reaction E2F4-DP12-gE2 p19ARF) 
	(synthesis-reaction E2F4-DP12-gE2 pol) 
	(association-reaction E2F6 DP12 E2F6-DP12)
	(association-reaction E2F6-DP12 gE2 E2F6-DP12-gE2)
	(association-reaction HBP1 p130 HBP1-p130)
	(association-reaction HDAC1-p107-E2F4p1-DP12 gE2 HDAC1-p107-E2F4p1-DP12-gE2)
	(association-reaction HDAC1-p130-E2F4p1-DP12 gE2 HDAC1-p130-E2F4p1-DP12-gE2)
	(association-reaction HDAC1-pRbp1-E2F13p1-DP12 gE2 HDAC1-pRbp1-E2F13p1-DP12-gE2)
	(association-reaction HDAC1-pRbp1-E2F4-DP12 gE2 HDAC1-pRbp1-E2F4-DP12-gE2)
	(association-reaction m1433 cdc25Cp1p2 m1433-cdc25Cp1p2)
	(association-reaction m1433 cdc25Cp2 m1433-cdc25Cp2)
	(association-reaction Mdm2 E2F13-DP12 Mdm2-E2F13-DP12)
	(association-reaction Mdm2 E2F13p1-DP12p1 Mdm2-E2F13p1-DP12p1)
	(association-reaction Mdm2 pRb Mdm2-pRb)
	(association-reaction Mdm2 pRbp1 Mdm2-pRbp1)
	(association-reaction Mdm2 pRbp1p2 Mdm2-pRbp1p2)
	(association-reaction Mdm2 pRbp2 Mdm2-pRbp2)
	(association-reaction p107-E2F4-DP12 gE2 p107-E2F4-DP12-gE2)
	(association-reaction p107 E2F4-DP12 p107-E2F4-DP12)
	(association-reaction p107-E2F4-DP12p1 gE2 p107-E2F4-DP12p1-gE2)
	(association-reaction p107 E2F4-DP12p1 p107-E2F4-DP12p1)
	(association-reaction p130-E2F4-DP12 gE2 p130-E2F4-DP12-gE2)
	(association-reaction p130 E2F4-DP12 p130-E2F4-DP12)
	(association-reaction p130-E2F4-DP12p1 gE2 p130-E2F4-DP12p1-gE2)
	(association-reaction p130 E2F4-DP12p1 p130-E2F4-DP12p1)
	(association-reaction p16 cdk46p1 p16-cdk46p1)
	(association-reaction p16 cdk46p1p2 p16-cdk46p1p2)
	(association-reaction p16 cdk7 p16-cdk7)
	(association-reaction p16 cdk7p1 p16-cdk7p1)
	(association-reaction p21 cdk2-cycA p21-cdk2-cycA)
	(association-reaction p21 cdk2-cycEp1 p21-cdk2-cycEp1)
	(association-reaction p21 cdk2-cycE p21-cdk2-cycE)
	(association-reaction p21 cdk2p1-cycA p21-cdk2p1-cycA)
	(association-reaction p21 cdk2p1-cycEp1 p21-cdk2p1-cycEp1)
	(association-reaction p21 cdk2p1-cycE p21-cdk2p1-cycE)
	(association-reaction p21 cdk2p1p2-cycA p21-cdk2p1p2-cycA)
	(association-reaction p21 cdk2p1p2-cycEp1 p21-cdk2p1p2-cycEp1)
	(association-reaction p21 cdk2p1p2-cycE p21-cdk2p1p2-cycE)
	(association-reaction p21 cdk2p2-cycA p21-cdk2p2-cycA)
	(association-reaction p21 cdk2p2-cycEp1 p21-cdk2p2-cycEp1)
	(association-reaction p21 cdk2p2-cycE p21-cdk2p2-cycE)
	(association-reaction p21 cdk46p1-cycDp1 p21-cdk46p1-cycDp1)
	(association-reaction p21 cdk46p1-cycD p21-cdk46p1-cycD)
	(association-reaction p21 cdk46p1p2-cycDp1 p21-cdk46p1p2-cycDp1)
	(association-reaction p21 cdk46p1p2-cycD p21-cdk46p1p2-cycD)
	(association-reaction p21 Gadd45 p21-Gadd45)
	(association-reaction p27 cdk2-cycA p27-cdk2-cycA)
	(association-reaction p27 cdk2-cycEp1 p27-cdk2-cycEp1)
	(association-reaction p27 cdk2-cycE p27-cdk2-cycE)
	(association-reaction p27 cdk2p1-cycA p27-cdk2p1-cycA)
	(association-reaction p27 cdk2p1-cycEp1 p27-cdk2p1-cycEp1)
	(association-reaction p27 cdk2p1-cycE p27-cdk2p1-cycE)
	(association-reaction p27 cdk2p1p2-cycA p27-cdk2p1p2-cycA)
	(association-reaction p27 cdk2p1p2-cycEp1 p27-cdk2p1p2-cycEp1)
	(association-reaction p27 cdk2p1p2-cycE p27-cdk2p1p2-cycE)
	(association-reaction p27 cdk2p2-cycA p27-cdk2p2-cycA)
	(association-reaction p27 cdk2p2-cycEp1 p27-cdk2p2-cycEp1)
	(catalyzed-association-reaction p27 cdk2p2-cycEp1 p27p1)
	(association-reaction p27 cdk2p2-cycE p27-cdk2p2-cycE)
	(catalyzed-association-reaction p27 cdk2p2-cycE p27p1)
	(association-reaction p27 cdk46p1-cycDp1 p27-cdk46p1-cycDp1)
	(association-reaction p27 cdk46p1-cycD p27-cdk46p1-cycD)
	(association-reaction p27 cdk46p1p2-cycDp1 p27-cdk46p1p2-cycDp1)
	(association-reaction p27 cdk46p1p2-cycD p27-cdk46p1p2-cycD)
	(association-reaction p27p1 cdk2-cycA p27p1-cdk2-cycA)
	(association-reaction p27p1 cdk2-cycEp1 p27p1-cdk2-cycEp1)
	(association-reaction p27p1 cdk2-cycE p27p1-cdk2-cycE)
	(association-reaction p27p1 cdk2p1-cycA p27p1-cdk2p1-cycA)
	(association-reaction p27p1 cdk2p1-cycEp1 p27p1-cdk2p1-cycEp1)
	(association-reaction p27p1 cdk2p1-cycE p27p1-cdk2p1-cycE)
	(association-reaction p27p1 cdk2p1p2-cycA p27p1-cdk2p1p2-cycA)
	(association-reaction p27p1 cdk2p1p2-cycEp1 p27p1-cdk2p1p2-cycEp1)
	(association-reaction p27p1 cdk2p1p2-cycE p27p1-cdk2p1p2-cycE)
	(association-reaction p27p1 cdk2p2-cycA p27p1-cdk2p2-cycA)
	(association-reaction p27p1 cdk2p2-cycEp1 p27p1-cdk2p2-cycEp1)
	(association-reaction p27p1 cdk2p2-cycE p27p1-cdk2p2-cycE)
	(association-reaction p27p1 cdk46p1-cycDp1 p27p1-cdk46p1-cycDp1)
	(association-reaction p27p1 cdk46p1-cycD p27p1-cdk46p1-cycD)
	(association-reaction p27p1 cdk46p1p2-cycDp1 p27p1-cdk46p1p2-cycDp1)
	(association-reaction p27p1 cdk46p1p2-cycD p27p1-cdk46p1p2-cycD)
	(synthesis-reaction p53 c-Fos) 
	(association-reaction p53 DP12p1 p53-DP12p1)
	(association-reaction p53 DP12 p53-DP12)
	(synthesis-reaction p53 Gadd45) 
	(synthesis-reaction p53 Mdm2) 
	(synthesis-reaction p53p1 c-Fos) 
	(association-reaction p53p1 DP12p1 p53p1-DP12p1)
	(association-reaction p53p1 DP12 p53p1-DP12)
	(synthesis-reaction p53p1 Gadd45) 
	(synthesis-reaction p53p1 Mdm2) 
	(synthesis-reaction p53p1 p21) 
	(synthesis-reaction p53 p21) 
	(association-reaction p57 cdk2-cycA p57-cdk2-cycA)
	(association-reaction p57 cdk2-cycEp1 p57-cdk2-cycEp1)
	(association-reaction p57 cdk2-cycE p57-cdk2-cycE)
	(association-reaction p57 cdk2p1-cycA p57-cdk2p1-cycA)
	(association-reaction p57 cdk2p1-cycEp1 p57-cdk2p1-cycEp1)
	(association-reaction p57 cdk2p1-cycE p57-cdk2p1-cycE)
	(association-reaction p57 cdk2p1p2-cycA p57-cdk2p1p2-cycA)
	(association-reaction p57 cdk2p1p2-cycEp1 p57-cdk2p1p2-cycEp1)
	(association-reaction p57 cdk2p1p2-cycE p57-cdk2p1p2-cycE)
	(association-reaction p57 cdk2p2-cycA p57-cdk2p2-cycA)
	(association-reaction p57 cdk2p2-cycEp1 p57-cdk2p2-cycEp1)
	(association-reaction p57 cdk2p2-cycE p57-cdk2p2-cycE)
	(association-reaction p57 cdk46p1-cycDp1 p57-cdk46p1-cycDp1)
	(association-reaction p57 cdk46p1-cycD p57-cdk46p1-cycD)
	(association-reaction p57 cdk46p1p2-cycDp1 p57-cdk46p1p2-cycDp1)
	(association-reaction p57 cdk46p1p2-cycD p57-cdk46p1p2-cycD)
	(association-reaction p57p1 cdk46p1-cycDp1 p57p1-cdk46p1-cycDp1)
	(association-reaction p57p1 cdk46p1-cycD p57p1-cdk46p1-cycD)
	(association-reaction p57p1 cdk46p1p2-cycDp1 p57p1-cdk46p1p2-cycDp1)
	(association-reaction p57p1 cdk46p1p2-cycD p57p1-cdk46p1p2-cycD)
	(association-reaction pCAF p300 pCAF-p300)
	(synthesis-reaction pRb-AP2-gE-c Ecadherin) 
	(association-reaction pRb-AP2 gE-c pRb-AP2-gE-c)
	(association-reaction pRb AP2 pRb-AP2)
	(catalyzed-association-reaction pRb cdk46p3-cycDp1 pRbp1)
	(association-reaction pRb-E2F13-DP12 gE2 pRb-E2F13-DP12-gE2)
	(association-reaction pRb E2F13-DP12 pRb-E2F13-DP12)
	(association-reaction pRb-E2F13p1-DP12p1 gE2 pRb-E2F13p1-DP12p1-gE2)
	(association-reaction pRb E2F13p1-DP12p1 pRb-E2F13p1-DP12p1)
	(association-reaction pRb-E2F4-DP12 gE2 pRb-E2F4-DP12-gE2)
	(association-reaction pRb E2F4-DP12p1 pRb-E2F4-DP12p1)
	(association-reaction pRb E2F4-DP12 pRb-E2F4-DP12)
	(association-reaction pRb-E2F4p1-DP12 gE2 pRb-E2F4p1-DP12-gE2)
	(synthesis-reaction pRbp1-AP2-gE-c Ecadherin) 
	(association-reaction pRbp1-AP2 gE-c pRbp1-AP2-gE-c)
	(association-reaction pRbp1 AP2 pRbp1-AP2)
	(catalyzed-association-reaction pRbp1 cdk2p2-cycEp1 pRbp1p2)
	(catalyzed-association-reaction pRbp1 cdk2p2-cycE pRbp1p2)
	(association-reaction pRbp1-E2F13-DP12 gE2 pRbp1-E2F13-DP12-gE2)
	(association-reaction pRbp1 E2F13-DP12 pRbp1-E2F13-DP12)
	(association-reaction pRbp1-E2F13p1-DP12p1 gE2 pRbp1-E2F13p1-DP12p1-gE2)
	(association-reaction pRbp1 E2F13p1-DP12p1 pRbp1-E2F13p1-DP12p1)
	(association-reaction pRbp1-E2F4-DP12 gE2 pRbp1-E2F4-DP12-gE2)
	(association-reaction pRbp1 E2F4-DP12p1 pRbp1-E2F4-DP12p1)
	(association-reaction pRbp1 E2F4-DP12 pRbp1-E2F4-DP12)
	(association-reaction pRbp1-E2F4p1-DP12 gE2 pRbp1-E2F4p1-DP12-gE2)
	(synthesis-reaction pRbp1p2-AP2-gE-c Ecadherin) 
	(association-reaction pRbp1p2-AP2 gE-c pRbp1p2-AP2-gE-c)
	(association-reaction pRbp1p2 AP2 pRbp1p2-AP2)
	(synthesis-reaction pRbp2-AP2-gE-c Ecadherin) 
	(association-reaction pRbp2-AP2 gE-c pRbp2-AP2-gE-c)
	(association-reaction pRbp2 AP2 pRbp2-AP2)
	(catalyzed-association-reaction pRbp2 cdk46p3-cycDp1 pRbp1p2)
	(association-reaction RPA cycA RPA-cycA)
	(catalyzed-association-reaction Skp1 cdk2p2-cycA Skp1p1)
	(association-reaction Skp2 cdk2-cycA Skp2-cdk2-cycA)
	(association-reaction Skp2 cdk2p1-cycA Skp2-cdk2p1-cycA)
	(association-reaction Skp2 cdk2p1p2-cycA Skp2-cdk2p1p2-cycA)
	(association-reaction Skp2 cdk2p2-cycA Skp2-cdk2p2-cycA)
	(catalyzed-association-reaction Skp2 cdk2p2-cycA Skp2p1)
	(association-reaction Skp2p1 Skp1p1 Skp2p1-Skp1p1)
	(association-reaction Skp2p1 Skp1 Skp2p1-Skp1)
	(association-reaction Skp2-Skp1 cdk2-cycA Skp2-Skp1-cdk2-cycA)
	(association-reaction Skp2-Skp1 cdk2p1-cycA Skp2-Skp1-cdk2p1-cycA)
	(association-reaction Skp2-Skp1 cdk2p1p2-cycA Skp2-Skp1-cdk2p1p2-cycA)
	(association-reaction Skp2-Skp1 cdk2p2-cycA Skp2-Skp1-cdk2p2-cycA)
	(association-reaction Skp2-Skp1p1 cdk2-cycA Skp2-Skp1p1-cdk2-cycA)
	(association-reaction Skp2-Skp1p1 cdk2p1-cycA Skp2-Skp1p1-cdk2p1-cycA)
	(association-reaction Skp2-Skp1p1 cdk2p1p2-cycA Skp2-Skp1p1-cdk2p1p2-cycA)
	(association-reaction Skp2-Skp1p1 cdk2p2-cycA Skp2-Skp1p1-cdk2p2-cycA)
	(association-reaction Skp2 Skp1p1 Skp2-Skp1p1)
	(association-reaction Skp2 Skp1 Skp2-Skp1)
	(association-reaction SP1 E2F13p1 SP1-E2F13p1)
	(association-reaction SP1 E2F13 SP1-E2F13)
	(association-reaction SP1 p107p1 SP1-p107p1)
	(association-reaction SP1 p107 SP1-p107)
	(catalyzed-association-reaction Wee1 cdk1p3-cycA Wee1p1)
	(catalyzed-association-reaction Wee1 cdk1p3-cycB Wee1p1)
	(num-subs l0)
	(next l1 l0)
	(next l2 l1)
	(next l3 l2)
	(next l4 l3)
	(next l5 l4)
	(next l6 l5)
	(next l7 l6)
	(next l8 l7)
	(next l9 l8)
	(next l10 l9)
	(next l11 l10)
	(next l12 l11)
	(next l13 l12)
	(next l14 l13)
	(next l15 l14)
	(next l16 l15)
	(next l17 l16)
	(next l18 l17)
	(next l19 l18)
	(next l20 l19)
	(next l21 l20))


(:goal
	(and
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
	(goal27)))

)
