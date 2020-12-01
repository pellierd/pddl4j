(define (problem Pathways-11)
(:domain Pathways-Propositional)
(:objects
	Wee1 - simple
	SP1 - simple
	Skp2 - simple
	RPA - simple
	Raf1 - simple
	pRbp1-E2F4p1-DP12 - simple
	pRb-E2F4p1-DP12 - simple
	PCNA - simple
	pCAF - simple
	p57 - simple
	p53 - simple
	p300 - simple
	p16 - simple
	p130-E2F5p1-DP12 - simple
	p130-E2F4p1-DP12 - simple
	p130 - simple
	Max - simple
	m1433 - simple
	Jun - simple
	HDAC1-pRbp1-E2F4-DP12 - simple
	HDAC1-pRbp1-E2F13p1-DP12 - simple
	HDAC1-pRbp1-E2F13-DP12 - simple
	HDAC1-p130-E2F5p1-DP12 - simple
	HDAC1-p130-E2F4p1-DP12 - simple
	HDAC1-p107-E2F4p1-DP12 - simple
	HDAC1 - simple
	gP - simple
	gE-c - simple
	gE2 - simple
	E2F6 - simple
	E2F5 - simple
	E2F3 - simple
	E2F2 - simple
	E2F13p1-DP12 - simple
	E2F13-DP12p1 - simple
	E2F13-DP12 - simple
	E2F1 - simple
	DP12 - simple
	C-TAK1 - simple
	cks1 - simple
	Chk1 - simple
	cdk7 - simple
	cdk46p1 - simple
	cdk2p2-cycB - simple
	cdk2 - simple
	cdc25C - simple
	AP2 - simple
	AP2-gE-c - complex
	cdk2-cks1 - complex
	cdk2p1p2-cycB - complex
	c-Myc-AP2 - complex
	c-Myc-Max - complex
	E2F13-DP12-gE2 - complex
	E2F13p1-DP12-gE2 - complex
	E2F1-DP12 - complex
	E2F2-DP12 - complex
	E2F3-DP12 - complex
	E2F5-DP12-gE2 - complex
	E2F6-DP12-gE2 - complex
	E2F6-DP12 - complex
	HDAC1-p107-E2F4p1-DP12-gE2 - complex
	HDAC1-p130-E2F4p1-DP12-gE2 - complex
	HDAC1-p130-E2F5-DP12-gE2 - complex
	HDAC1-p130-E2F5-DP12 - complex
	HDAC1-p130-E2F5p1-DP12-gE2 - complex
	HDAC1-pRb-E2F4p1-DP12 - complex
	HDAC1-pRbp1-E2F13-DP12-gE2 - complex
	HDAC1-pRbp1-E2F13p1-DP12-gE2 - complex
	HDAC1-pRbp1-E2F4-DP12-gE2 - complex
	Jun-c-Fos - complex
	m1433-cdc25Cp2 - complex
	cdc25Cp2 - complex
	Mdm2-E2F13-DP12 - complex
	Mdm2-E2F13-DP12p1 - complex
	Mdm2-E2F13p1-DP12 - complex
	p130-E2F5-DP12-gE2 - complex
	E2F5-DP12 - complex
	p16-cdk46p1 - complex
	p16-cdk7 - complex
	p21-cdk2-cycA - complex
	p21-cdk2-cycEp1 - complex
	p21-cdk2-cycE - complex
	p21-cdk2p1-cycA - complex
	p21-cdk46p1-cycDp1 - complex
	p21-cdk46p1-cycD - complex
	p21-Gadd45 - complex
	p53-DP12 - complex
	Mdm2 - complex
	p57-cdk2-cycA - complex
	p57-cdk2-cycEp1 - complex
	p57-cdk2-cycE - complex
	p57-cdk2p1-cycA - complex
	p57-cdk46p1-cycDp1 - complex
	p57-cdk46p1-cycD - complex
	pCAF-p300 - complex
	PCNA-cycDp1 - complex
	PCNA-cycD - complex
	PCNA-Gadd45 - complex
	Gadd45 - complex
	PCNA-p21-cdk2-cycA - complex
	PCNA-p21-cdk2-cycEp1 - complex
	cdk2-cycEp1 - complex
	PCNA-p21-cdk2-cycE - complex
	cdk2-cycE - complex
	PCNA-p21-cdk2p1-cycA - complex
	PCNA-p21-cdk46p1-cycDp1 - complex
	cdk46p1-cycDp1 - complex
	PCNA-p21-cdk46p1-cycD - complex
	cdk46p1-cycD - complex
	PCNA-p21 - complex
	p21 - complex
	pRb-E2F4p1-DP12-gE2 - complex
	pRbp1-E2F4p1-DP12-gE2 - complex
	Ecadherin - complex
	c-Fos - complex
	Raf1-p130-E2F4p1-DP12-gE2 - complex
	Raf1-p130-E2F4p1-DP12 - complex
	Raf1-p130-E2F5-DP12-gE2 - complex
	Raf1-p130-E2F5-DP12 - complex
	p130-E2F5-DP12 - complex
	Raf1-p130-E2F5p1-DP12-gE2 - complex
	Raf1-p130-E2F5p1-DP12 - complex
	Raf1-pRb-E2F4p1-DP12-gE2 - complex
	Raf1-pRb-E2F4p1-DP12 - complex
	Raf1-pRbp1-E2F4p1-DP12-gE2 - complex
	Raf1-pRbp1-E2F4p1-DP12 - complex
	RPA-cycA - complex
	Skp2-cdk2-cycA - complex
	Skp2-cdk2p1-cycA - complex
	cdk2-cycA - complex
	cdk2p1-cycA - complex
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
	SP1-p107p1-gP - complex
	p107p1 - complex
	SP1-p107 - complex
	p107 - complex
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
	l10 - level)


(:init
	(possible Wee1)
	(possible SP1)
	(possible Skp2)
	(possible RPA)
	(possible Raf1)
	(possible pRbp1-E2F4p1-DP12)
	(possible pRb-E2F4p1-DP12)
	(possible PCNA)
	(possible pCAF)
	(possible p57)
	(possible p53)
	(possible p300)
	(possible p16)
	(possible p130-E2F5p1-DP12)
	(possible p130-E2F4p1-DP12)
	(possible p130)
	(possible Max)
	(possible m1433)
	(possible Jun)
	(possible HDAC1-pRbp1-E2F4-DP12)
	(possible HDAC1-pRbp1-E2F13p1-DP12)
	(possible HDAC1-pRbp1-E2F13-DP12)
	(possible HDAC1-p130-E2F5p1-DP12)
	(possible HDAC1-p130-E2F4p1-DP12)
	(possible HDAC1-p107-E2F4p1-DP12)
	(possible HDAC1)
	(possible gP)
	(possible gE-c)
	(possible gE2)
	(possible E2F6)
	(possible E2F5)
	(possible E2F3)
	(possible E2F2)
	(possible E2F13p1-DP12)
	(possible E2F13-DP12p1)
	(possible E2F13-DP12)
	(possible E2F1)
	(possible DP12)
	(possible C-TAK1)
	(possible cks1)
	(possible Chk1)
	(possible cdk7)
	(possible cdk46p1)
	(possible cdk2p2-cycB)
	(possible cdk2)
	(possible cdc25C)
	(possible AP2)
	(association-reaction AP2 gE-c AP2-gE-c)
	(synthesis-reaction AP2-gE-c Ecadherin) 
	(catalyzed-association-reaction cdc25C Chk1 cdc25Cp2)
	(catalyzed-association-reaction cdc25C C-TAK1 cdc25Cp2)
	(association-reaction cdk2 cks1 cdk2-cks1)
	(association-reaction cdk2 cycA cdk2-cycA)
	(catalyzed-association-reaction cdk2-cycA Wee1 cdk2p1-cycA)
	(association-reaction cdk2 cycE cdk2-cycE)
	(association-reaction cdk2 cycEp1 cdk2-cycEp1)
	(catalyzed-association-reaction cdk2p2-cycB Wee1 cdk2p1p2-cycB)
	(association-reaction cdk46p1 cycD cdk46p1-cycD)
	(association-reaction cdk46p1 cycDp1 cdk46p1-cycDp1)
	(association-reaction c-Myc AP2 c-Myc-AP2)
	(association-reaction c-Myc Max c-Myc-Max)
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
	(association-reaction E2F1 DP12 E2F1-DP12)
	(association-reaction E2F2 DP12 E2F2-DP12)
	(association-reaction E2F3 DP12 E2F3-DP12)
	(association-reaction E2F5 DP12 E2F5-DP12)
	(synthesis-reaction E2F5-DP12-gE2 c-Myc) 
	(synthesis-reaction E2F5-DP12-gE2 cycA) 
	(synthesis-reaction E2F5-DP12-gE2 cycD) 
	(synthesis-reaction E2F5-DP12-gE2 cycDp1) 
	(synthesis-reaction E2F5-DP12-gE2 cycE) 
	(synthesis-reaction E2F5-DP12-gE2 cycEp1) 
	(association-reaction E2F5-DP12 gE2 E2F5-DP12-gE2)
	(synthesis-reaction E2F5-DP12-gE2 p107) 
	(synthesis-reaction E2F5-DP12-gE2 p107p1) 
	(synthesis-reaction E2F5-DP12-gE2 p19ARF) 
	(synthesis-reaction E2F5-DP12-gE2 pol) 
	(association-reaction E2F6 DP12 E2F6-DP12)
	(association-reaction E2F6-DP12 gE2 E2F6-DP12-gE2)
	(association-reaction HDAC1-p107-E2F4p1-DP12 gE2 HDAC1-p107-E2F4p1-DP12-gE2)
	(association-reaction HDAC1-p130-E2F4p1-DP12 gE2 HDAC1-p130-E2F4p1-DP12-gE2)
	(association-reaction HDAC1-p130-E2F5-DP12 gE2 HDAC1-p130-E2F5-DP12-gE2)
	(association-reaction HDAC1 p130-E2F5-DP12 HDAC1-p130-E2F5-DP12)
	(association-reaction HDAC1-p130-E2F5p1-DP12 gE2 HDAC1-p130-E2F5p1-DP12-gE2)
	(association-reaction HDAC1 pRb-E2F4p1-DP12 HDAC1-pRb-E2F4p1-DP12)
	(association-reaction HDAC1-pRbp1-E2F13-DP12 gE2 HDAC1-pRbp1-E2F13-DP12-gE2)
	(association-reaction HDAC1-pRbp1-E2F13p1-DP12 gE2 HDAC1-pRbp1-E2F13p1-DP12-gE2)
	(association-reaction HDAC1-pRbp1-E2F4-DP12 gE2 HDAC1-pRbp1-E2F4-DP12-gE2)
	(association-reaction Jun c-Fos Jun-c-Fos)
	(association-reaction m1433 cdc25Cp2 m1433-cdc25Cp2)
	(association-reaction Mdm2 E2F13-DP12 Mdm2-E2F13-DP12)
	(association-reaction Mdm2 E2F13-DP12p1 Mdm2-E2F13-DP12p1)
	(association-reaction Mdm2 E2F13p1-DP12 Mdm2-E2F13p1-DP12)
	(association-reaction p130-E2F5-DP12 gE2 p130-E2F5-DP12-gE2)
	(association-reaction p130 E2F5-DP12 p130-E2F5-DP12)
	(association-reaction p16 cdk46p1 p16-cdk46p1)
	(association-reaction p16 cdk7 p16-cdk7)
	(association-reaction p21 cdk2-cycA p21-cdk2-cycA)
	(association-reaction p21 cdk2-cycEp1 p21-cdk2-cycEp1)
	(association-reaction p21 cdk2-cycE p21-cdk2-cycE)
	(association-reaction p21 cdk2p1-cycA p21-cdk2p1-cycA)
	(association-reaction p21 cdk46p1-cycDp1 p21-cdk46p1-cycDp1)
	(association-reaction p21 cdk46p1-cycD p21-cdk46p1-cycD)
	(association-reaction p21 Gadd45 p21-Gadd45)
	(synthesis-reaction p53 c-Fos) 
	(association-reaction p53 DP12 p53-DP12)
	(synthesis-reaction p53 Gadd45) 
	(synthesis-reaction p53 Mdm2) 
	(synthesis-reaction p53 p21) 
	(association-reaction p57 cdk2-cycA p57-cdk2-cycA)
	(association-reaction p57 cdk2-cycEp1 p57-cdk2-cycEp1)
	(association-reaction p57 cdk2-cycE p57-cdk2-cycE)
	(association-reaction p57 cdk2p1-cycA p57-cdk2p1-cycA)
	(association-reaction p57 cdk46p1-cycDp1 p57-cdk46p1-cycDp1)
	(association-reaction p57 cdk46p1-cycD p57-cdk46p1-cycD)
	(association-reaction pCAF p300 pCAF-p300)
	(association-reaction PCNA cycDp1 PCNA-cycDp1)
	(association-reaction PCNA cycD PCNA-cycD)
	(association-reaction PCNA Gadd45 PCNA-Gadd45)
	(association-reaction PCNA-p21 cdk2-cycA PCNA-p21-cdk2-cycA)
	(association-reaction PCNA-p21 cdk2-cycEp1 PCNA-p21-cdk2-cycEp1)
	(association-reaction PCNA-p21 cdk2-cycE PCNA-p21-cdk2-cycE)
	(association-reaction PCNA-p21 cdk2p1-cycA PCNA-p21-cdk2p1-cycA)
	(association-reaction PCNA-p21 cdk46p1-cycDp1 PCNA-p21-cdk46p1-cycDp1)
	(association-reaction PCNA-p21 cdk46p1-cycD PCNA-p21-cdk46p1-cycD)
	(association-reaction PCNA p21 PCNA-p21)
	(association-reaction pRb-E2F4p1-DP12 gE2 pRb-E2F4p1-DP12-gE2)
	(association-reaction pRbp1-E2F4p1-DP12 gE2 pRbp1-E2F4p1-DP12-gE2)
	(synthesis-reaction Raf1-p130-E2F4p1-DP12-gE2 c-Myc) 
	(synthesis-reaction Raf1-p130-E2F4p1-DP12-gE2 cycA) 
	(synthesis-reaction Raf1-p130-E2F4p1-DP12-gE2 cycD) 
	(synthesis-reaction Raf1-p130-E2F4p1-DP12-gE2 cycDp1) 
	(synthesis-reaction Raf1-p130-E2F4p1-DP12-gE2 cycE) 
	(synthesis-reaction Raf1-p130-E2F4p1-DP12-gE2 cycEp1) 
	(synthesis-reaction Raf1-p130-E2F4p1-DP12-gE2 p107) 
	(synthesis-reaction Raf1-p130-E2F4p1-DP12-gE2 p107p1) 
	(synthesis-reaction Raf1-p130-E2F4p1-DP12-gE2 p19ARF) 
	(synthesis-reaction Raf1-p130-E2F4p1-DP12-gE2 pol) 
	(association-reaction Raf1-p130-E2F4p1-DP12 gE2 Raf1-p130-E2F4p1-DP12-gE2)
	(association-reaction Raf1 p130-E2F4p1-DP12 Raf1-p130-E2F4p1-DP12)
	(synthesis-reaction Raf1-p130-E2F5-DP12-gE2 c-Myc) 
	(synthesis-reaction Raf1-p130-E2F5-DP12-gE2 cycA) 
	(synthesis-reaction Raf1-p130-E2F5-DP12-gE2 cycD) 
	(synthesis-reaction Raf1-p130-E2F5-DP12-gE2 cycDp1) 
	(synthesis-reaction Raf1-p130-E2F5-DP12-gE2 cycE) 
	(synthesis-reaction Raf1-p130-E2F5-DP12-gE2 cycEp1) 
	(synthesis-reaction Raf1-p130-E2F5-DP12-gE2 p107) 
	(synthesis-reaction Raf1-p130-E2F5-DP12-gE2 p107p1) 
	(synthesis-reaction Raf1-p130-E2F5-DP12-gE2 p19ARF) 
	(synthesis-reaction Raf1-p130-E2F5-DP12-gE2 pol) 
	(association-reaction Raf1-p130-E2F5-DP12 gE2 Raf1-p130-E2F5-DP12-gE2)
	(association-reaction Raf1 p130-E2F5-DP12 Raf1-p130-E2F5-DP12)
	(synthesis-reaction Raf1-p130-E2F5p1-DP12-gE2 c-Myc) 
	(synthesis-reaction Raf1-p130-E2F5p1-DP12-gE2 cycA) 
	(synthesis-reaction Raf1-p130-E2F5p1-DP12-gE2 cycD) 
	(synthesis-reaction Raf1-p130-E2F5p1-DP12-gE2 cycDp1) 
	(synthesis-reaction Raf1-p130-E2F5p1-DP12-gE2 cycE) 
	(synthesis-reaction Raf1-p130-E2F5p1-DP12-gE2 cycEp1) 
	(synthesis-reaction Raf1-p130-E2F5p1-DP12-gE2 p107) 
	(synthesis-reaction Raf1-p130-E2F5p1-DP12-gE2 p107p1) 
	(synthesis-reaction Raf1-p130-E2F5p1-DP12-gE2 p19ARF) 
	(synthesis-reaction Raf1-p130-E2F5p1-DP12-gE2 pol) 
	(association-reaction Raf1-p130-E2F5p1-DP12 gE2 Raf1-p130-E2F5p1-DP12-gE2)
	(association-reaction Raf1 p130-E2F5p1-DP12 Raf1-p130-E2F5p1-DP12)
	(synthesis-reaction Raf1-pRb-E2F4p1-DP12-gE2 c-Myc) 
	(synthesis-reaction Raf1-pRb-E2F4p1-DP12-gE2 cycA) 
	(synthesis-reaction Raf1-pRb-E2F4p1-DP12-gE2 cycD) 
	(synthesis-reaction Raf1-pRb-E2F4p1-DP12-gE2 cycDp1) 
	(synthesis-reaction Raf1-pRb-E2F4p1-DP12-gE2 cycE) 
	(synthesis-reaction Raf1-pRb-E2F4p1-DP12-gE2 cycEp1) 
	(synthesis-reaction Raf1-pRb-E2F4p1-DP12-gE2 p107) 
	(synthesis-reaction Raf1-pRb-E2F4p1-DP12-gE2 p107p1) 
	(synthesis-reaction Raf1-pRb-E2F4p1-DP12-gE2 p19ARF) 
	(synthesis-reaction Raf1-pRb-E2F4p1-DP12-gE2 pol) 
	(association-reaction Raf1-pRb-E2F4p1-DP12 gE2 Raf1-pRb-E2F4p1-DP12-gE2)
	(association-reaction Raf1 pRb-E2F4p1-DP12 Raf1-pRb-E2F4p1-DP12)
	(synthesis-reaction Raf1-pRbp1-E2F4p1-DP12-gE2 c-Myc) 
	(synthesis-reaction Raf1-pRbp1-E2F4p1-DP12-gE2 cycA) 
	(synthesis-reaction Raf1-pRbp1-E2F4p1-DP12-gE2 cycD) 
	(synthesis-reaction Raf1-pRbp1-E2F4p1-DP12-gE2 cycDp1) 
	(synthesis-reaction Raf1-pRbp1-E2F4p1-DP12-gE2 cycE) 
	(synthesis-reaction Raf1-pRbp1-E2F4p1-DP12-gE2 cycEp1) 
	(synthesis-reaction Raf1-pRbp1-E2F4p1-DP12-gE2 p107) 
	(synthesis-reaction Raf1-pRbp1-E2F4p1-DP12-gE2 p107p1) 
	(synthesis-reaction Raf1-pRbp1-E2F4p1-DP12-gE2 p19ARF) 
	(synthesis-reaction Raf1-pRbp1-E2F4p1-DP12-gE2 pol) 
	(association-reaction Raf1-pRbp1-E2F4p1-DP12 gE2 Raf1-pRbp1-E2F4p1-DP12-gE2)
	(association-reaction Raf1 pRbp1-E2F4p1-DP12 Raf1-pRbp1-E2F4p1-DP12)
	(association-reaction RPA cycA RPA-cycA)
	(association-reaction Skp2 cdk2-cycA Skp2-cdk2-cycA)
	(association-reaction Skp2 cdk2p1-cycA Skp2-cdk2p1-cycA)
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
	(next l3 l2)
	(next l4 l3)
	(next l5 l4)
	(next l6 l5)
	(next l7 l6)
	(next l8 l7)
	(next l9 l8)
	(next l10 l9))


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
	(goal15)))

)
