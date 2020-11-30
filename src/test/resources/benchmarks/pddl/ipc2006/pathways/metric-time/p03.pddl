(define (problem Pathways-03)
(:domain Pathways-MetricTime)
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
	SP1-p107p1-gP - complex
	SP1-p107p1 - complex
	p107p1 - complex
	SP1-p107 - complex
	p107 - complex)


(:init
	(possible Wee1)
	(= (available Wee1) 0)
	(possible SP1)
	(= (available SP1) 0)
	(possible RPA)
	(= (available RPA) 0)
	(possible pRbp2)
	(= (available pRbp2) 0)
	(possible pRb)
	(= (available pRb) 0)
	(possible p16)
	(= (available p16) 0)
	(possible p130)
	(= (available p130) 0)
	(possible HDAC1)
	(= (available HDAC1) 0)
	(possible gP)
	(= (available gP) 0)
	(possible E2F4-DP12p1)
	(= (available E2F4-DP12p1) 0)
	(possible C-TAK1)
	(= (available C-TAK1) 0)
	(possible cks1)
	(= (available cks1) 0)
	(possible Chk1)
	(= (available Chk1) 0)
	(possible cdk46p3-cycD)
	(= (available cdk46p3-cycD) 0)
	(possible cdk46p1)
	(= (available cdk46p1) 0)
	(possible cdk2p2-cycB)
	(= (available cdk2p2-cycB) 0)
	(possible cdk1p1p2)
	(= (available cdk1p1p2) 0)
	(possible cdc25C)
	(= (available cdc25C) 0)
	(possible AP2)
	(= (available AP2) 0)
	(= (available cdk1p1p2-cks1) 0)
	(= (available cdk2p1p2-cycB) 0)
	(= (available c-Myc-AP2) 0)
	(= (available HDAC1-p107-E2F4-DP12p1) 0)
	(= (available HDAC1-p130-E2F4-DP12p1) 0)
	(= (available cdc25Cp2) 0)
	(= (available p107-E2F4-DP12p1) 0)
	(= (available p130-E2F4-DP12p1) 0)
	(= (available p16-cdk46p1) 0)
	(= (available cdk46p1-cycDp1) 0)
	(= (available cdk46p1-cycD) 0)
	(= (available pRb-AP2) 0)
	(= (available pRb-E2F4-DP12p1) 0)
	(= (available pRbp1-AP2) 0)
	(= (available pRbp1-E2F4-DP12p1) 0)
	(= (available pRbp1) 0)
	(= (available pRbp1p2-AP2) 0)
	(= (available pRbp2-AP2) 0)
	(= (available pRbp1p2) 0)
	(= (available RPA-cycA) 0)
	(= (available c-Myc) 0)
	(= (available cycA) 0)
	(= (available cycD) 0)
	(= (available cycDp1) 0)
	(= (available cycE) 0)
	(= (available cycEp1) 0)
	(= (available p19ARF) 0)
	(= (available pol) 0)
	(= (available SP1-gP) 0)
	(= (available SP1-p107-gP) 0)
	(= (available SP1-p107p1-gP) 0)
	(= (available SP1-p107p1) 0)
	(= (available p107p1) 0)
	(= (available SP1-p107) 0)
	(= (available p107) 0)
	(catalyzed-association-reaction cdc25C Chk1 cdc25Cp2)
	(= (need-for-catalyzed-association cdc25C Chk1 cdc25Cp2) 2)
	(= (need-for-catalyzed-association Chk1 cdc25C cdc25Cp2) 4)
	(= (prod-by-catalyzed-association cdc25C Chk1 cdc25Cp2) 4)
	(catalyzed-association-reaction cdc25C C-TAK1 cdc25Cp2)
	(= (need-for-catalyzed-association cdc25C C-TAK1 cdc25Cp2) 3)
	(= (need-for-catalyzed-association C-TAK1 cdc25C cdc25Cp2) 1)
	(= (prod-by-catalyzed-association cdc25C C-TAK1 cdc25Cp2) 3)
	(association-reaction cdk1p1p2 cks1 cdk1p1p2-cks1)
	(= (need-for-association cdk1p1p2 cks1 cdk1p1p2-cks1) 3)
	(= (need-for-association cks1 cdk1p1p2 cdk1p1p2-cks1) 3)
	(= (prod-by-association cdk1p1p2 cks1 cdk1p1p2-cks1) 2)
	(catalyzed-association-reaction cdk2p2-cycB Wee1 cdk2p1p2-cycB)
	(= (need-for-catalyzed-association cdk2p2-cycB Wee1 cdk2p1p2-cycB) 1)
	(= (need-for-catalyzed-association Wee1 cdk2p2-cycB cdk2p1p2-cycB) 4)
	(= (prod-by-catalyzed-association cdk2p2-cycB Wee1 cdk2p1p2-cycB) 1)
	(association-reaction cdk46p1 cycD cdk46p1-cycD)
	(= (need-for-association cdk46p1 cycD cdk46p1-cycD) 4)
	(= (need-for-association cycD cdk46p1 cdk46p1-cycD) 2)
	(= (prod-by-association cdk46p1 cycD cdk46p1-cycD) 1)
	(association-reaction cdk46p1 cycDp1 cdk46p1-cycDp1)
	(= (need-for-association cdk46p1 cycDp1 cdk46p1-cycDp1) 3)
	(= (need-for-association cycDp1 cdk46p1 cdk46p1-cycDp1) 2)
	(= (prod-by-association cdk46p1 cycDp1 cdk46p1-cycDp1) 4)
	(association-reaction c-Myc AP2 c-Myc-AP2)
	(= (need-for-association c-Myc AP2 c-Myc-AP2) 1)
	(= (need-for-association AP2 c-Myc c-Myc-AP2) 4)
	(= (prod-by-association c-Myc AP2 c-Myc-AP2) 3)
	(association-reaction HDAC1 p107-E2F4-DP12p1 HDAC1-p107-E2F4-DP12p1)
	(= (need-for-association HDAC1 p107-E2F4-DP12p1 HDAC1-p107-E2F4-DP12p1) 3)
	(= (need-for-association p107-E2F4-DP12p1 HDAC1 HDAC1-p107-E2F4-DP12p1) 3)
	(= (prod-by-association HDAC1 p107-E2F4-DP12p1 HDAC1-p107-E2F4-DP12p1) 3)
	(association-reaction HDAC1 p130-E2F4-DP12p1 HDAC1-p130-E2F4-DP12p1)
	(= (need-for-association HDAC1 p130-E2F4-DP12p1 HDAC1-p130-E2F4-DP12p1) 3)
	(= (need-for-association p130-E2F4-DP12p1 HDAC1 HDAC1-p130-E2F4-DP12p1) 4)
	(= (prod-by-association HDAC1 p130-E2F4-DP12p1 HDAC1-p130-E2F4-DP12p1) 4)
	(association-reaction p107 E2F4-DP12p1 p107-E2F4-DP12p1)
	(= (need-for-association p107 E2F4-DP12p1 p107-E2F4-DP12p1) 3)
	(= (need-for-association E2F4-DP12p1 p107 p107-E2F4-DP12p1) 2)
	(= (prod-by-association p107 E2F4-DP12p1 p107-E2F4-DP12p1) 2)
	(association-reaction p130 E2F4-DP12p1 p130-E2F4-DP12p1)
	(= (need-for-association p130 E2F4-DP12p1 p130-E2F4-DP12p1) 2)
	(= (need-for-association E2F4-DP12p1 p130 p130-E2F4-DP12p1) 3)
	(= (prod-by-association p130 E2F4-DP12p1 p130-E2F4-DP12p1) 1)
	(association-reaction p16 cdk46p1 p16-cdk46p1)
	(= (need-for-association p16 cdk46p1 p16-cdk46p1) 1)
	(= (need-for-association cdk46p1 p16 p16-cdk46p1) 1)
	(= (prod-by-association p16 cdk46p1 p16-cdk46p1) 1)
	(association-reaction pRb AP2 pRb-AP2)
	(= (need-for-association pRb AP2 pRb-AP2) 4)
	(= (need-for-association AP2 pRb pRb-AP2) 4)
	(= (prod-by-association pRb AP2 pRb-AP2) 3)
	(catalyzed-association-reaction pRb cdk46p3-cycD pRbp1)
	(= (need-for-catalyzed-association pRb cdk46p3-cycD pRbp1) 1)
	(= (need-for-catalyzed-association cdk46p3-cycD pRb pRbp1) 4)
	(= (prod-by-catalyzed-association pRb cdk46p3-cycD pRbp1) 2)
	(association-reaction pRb E2F4-DP12p1 pRb-E2F4-DP12p1)
	(= (need-for-association pRb E2F4-DP12p1 pRb-E2F4-DP12p1) 1)
	(= (need-for-association E2F4-DP12p1 pRb pRb-E2F4-DP12p1) 3)
	(= (prod-by-association pRb E2F4-DP12p1 pRb-E2F4-DP12p1) 3)
	(association-reaction pRbp1 AP2 pRbp1-AP2)
	(= (need-for-association pRbp1 AP2 pRbp1-AP2) 2)
	(= (need-for-association AP2 pRbp1 pRbp1-AP2) 2)
	(= (prod-by-association pRbp1 AP2 pRbp1-AP2) 4)
	(association-reaction pRbp1 E2F4-DP12p1 pRbp1-E2F4-DP12p1)
	(= (need-for-association pRbp1 E2F4-DP12p1 pRbp1-E2F4-DP12p1) 1)
	(= (need-for-association E2F4-DP12p1 pRbp1 pRbp1-E2F4-DP12p1) 2)
	(= (prod-by-association pRbp1 E2F4-DP12p1 pRbp1-E2F4-DP12p1) 3)
	(association-reaction pRbp1p2 AP2 pRbp1p2-AP2)
	(= (need-for-association pRbp1p2 AP2 pRbp1p2-AP2) 4)
	(= (need-for-association AP2 pRbp1p2 pRbp1p2-AP2) 4)
	(= (prod-by-association pRbp1p2 AP2 pRbp1p2-AP2) 1)
	(association-reaction pRbp2 AP2 pRbp2-AP2)
	(= (need-for-association pRbp2 AP2 pRbp2-AP2) 2)
	(= (need-for-association AP2 pRbp2 pRbp2-AP2) 2)
	(= (prod-by-association pRbp2 AP2 pRbp2-AP2) 4)
	(catalyzed-association-reaction pRbp2 cdk46p3-cycD pRbp1p2)
	(= (need-for-catalyzed-association pRbp2 cdk46p3-cycD pRbp1p2) 1)
	(= (need-for-catalyzed-association cdk46p3-cycD pRbp2 pRbp1p2) 4)
	(= (prod-by-catalyzed-association pRbp2 cdk46p3-cycD pRbp1p2) 1)
	(association-reaction RPA cycA RPA-cycA)
	(= (need-for-association RPA cycA RPA-cycA) 2)
	(= (need-for-association cycA RPA RPA-cycA) 1)
	(= (prod-by-association RPA cycA RPA-cycA) 4)
	(synthesis-reaction SP1-gP c-Myc) 
	(= (need-for-synthesis SP1-gP c-Myc) 2)
	(= (prod-by-synthesis SP1-gP c-Myc) 2)
	(synthesis-reaction SP1-gP cycA) 
	(= (need-for-synthesis SP1-gP cycA) 4)
	(= (prod-by-synthesis SP1-gP cycA) 2)
	(synthesis-reaction SP1-gP cycD) 
	(= (need-for-synthesis SP1-gP cycD) 1)
	(= (prod-by-synthesis SP1-gP cycD) 3)
	(synthesis-reaction SP1-gP cycDp1) 
	(= (need-for-synthesis SP1-gP cycDp1) 4)
	(= (prod-by-synthesis SP1-gP cycDp1) 1)
	(synthesis-reaction SP1-gP cycE) 
	(= (need-for-synthesis SP1-gP cycE) 2)
	(= (prod-by-synthesis SP1-gP cycE) 1)
	(synthesis-reaction SP1-gP cycEp1) 
	(= (need-for-synthesis SP1-gP cycEp1) 2)
	(= (prod-by-synthesis SP1-gP cycEp1) 1)
	(synthesis-reaction SP1-gP p107) 
	(= (need-for-synthesis SP1-gP p107) 3)
	(= (prod-by-synthesis SP1-gP p107) 3)
	(synthesis-reaction SP1-gP p107p1) 
	(= (need-for-synthesis SP1-gP p107p1) 2)
	(= (prod-by-synthesis SP1-gP p107p1) 2)
	(synthesis-reaction SP1-gP p19ARF) 
	(= (need-for-synthesis SP1-gP p19ARF) 3)
	(= (prod-by-synthesis SP1-gP p19ARF) 3)
	(synthesis-reaction SP1-gP pol) 
	(= (need-for-synthesis SP1-gP pol) 4)
	(= (prod-by-synthesis SP1-gP pol) 2)
	(association-reaction SP1 gP SP1-gP)
	(= (need-for-association SP1 gP SP1-gP) 3)
	(= (need-for-association gP SP1 SP1-gP) 4)
	(= (prod-by-association SP1 gP SP1-gP) 3)
	(association-reaction SP1-p107 gP SP1-p107-gP)
	(= (need-for-association SP1-p107 gP SP1-p107-gP) 4)
	(= (need-for-association gP SP1-p107 SP1-p107-gP) 3)
	(= (prod-by-association SP1-p107 gP SP1-p107-gP) 4)
	(association-reaction SP1-p107p1 gP SP1-p107p1-gP)
	(= (need-for-association SP1-p107p1 gP SP1-p107p1-gP) 4)
	(= (need-for-association gP SP1-p107p1 SP1-p107p1-gP) 4)
	(= (prod-by-association SP1-p107p1 gP SP1-p107p1-gP) 1)
	(association-reaction SP1 p107p1 SP1-p107p1)
	(= (need-for-association SP1 p107p1 SP1-p107p1) 4)
	(= (need-for-association p107p1 SP1 SP1-p107p1) 3)
	(= (prod-by-association SP1 p107p1 SP1-p107p1) 3)
	(association-reaction SP1 p107 SP1-p107)
	(= (need-for-association SP1 p107 SP1-p107) 1)
	(= (need-for-association p107 SP1 SP1-p107) 2)
	(= (prod-by-association SP1 p107 SP1-p107) 4)
	(= (num-subs) 0)
	(= (duration-catalyzed-association-reaction cdc25C Chk1 cdc25Cp2) 1.8)
	(= (duration-catalyzed-association-reaction cdc25C C-TAK1 cdc25Cp2) 2.0)
	(= (duration-association-reaction cdk1p1p2 cks1 cdk1p1p2-cks1) 0.9)
	(= (duration-catalyzed-association-reaction cdk2p2-cycB Wee1 cdk2p1p2-cycB) 2.0)
	(= (duration-association-reaction cdk46p1 cycD cdk46p1-cycD) 0.9)
	(= (duration-association-reaction cdk46p1 cycDp1 cdk46p1-cycDp1) 1.0)
	(= (duration-association-reaction c-Myc AP2 c-Myc-AP2) 0.9)
	(= (duration-association-reaction HDAC1 p107-E2F4-DP12p1 HDAC1-p107-E2F4-DP12p1) 0.9)
	(= (duration-association-reaction HDAC1 p130-E2F4-DP12p1 HDAC1-p130-E2F4-DP12p1) 0.8)
	(= (duration-association-reaction p107 E2F4-DP12p1 p107-E2F4-DP12p1) 0.8)
	(= (duration-association-reaction p130 E2F4-DP12p1 p130-E2F4-DP12p1) 1.1)
	(= (duration-association-reaction p16 cdk46p1 p16-cdk46p1) 1.0)
	(= (duration-association-reaction pRb AP2 pRb-AP2) 0.9)
	(= (duration-catalyzed-association-reaction pRb cdk46p3-cycD pRbp1) 1.8)
	(= (duration-association-reaction pRb E2F4-DP12p1 pRb-E2F4-DP12p1) 1.1)
	(= (duration-association-reaction pRbp1 AP2 pRbp1-AP2) 0.9)
	(= (duration-association-reaction pRbp1 E2F4-DP12p1 pRbp1-E2F4-DP12p1) 1.1)
	(= (duration-association-reaction pRbp1p2 AP2 pRbp1p2-AP2) 0.9)
	(= (duration-association-reaction pRbp2 AP2 pRbp2-AP2) 1.0)
	(= (duration-catalyzed-association-reaction pRbp2 cdk46p3-cycD pRbp1p2) 1.8)
	(= (duration-association-reaction RPA cycA RPA-cycA) 1.0)
	(= (duration-synthesis-reaction SP1-gP c-Myc) 3.4)
	(= (duration-synthesis-reaction SP1-gP cycA) 3.8)
	(= (duration-synthesis-reaction SP1-gP cycD) 3.8)
	(= (duration-synthesis-reaction SP1-gP cycDp1) 4.2)
	(= (duration-synthesis-reaction SP1-gP cycE) 4.2)
	(= (duration-synthesis-reaction SP1-gP cycEp1) 3.4)
	(= (duration-synthesis-reaction SP1-gP p107) 3.3)
	(= (duration-synthesis-reaction SP1-gP p107p1) 3.8)
	(= (duration-synthesis-reaction SP1-gP p19ARF) 3.4)
	(= (duration-synthesis-reaction SP1-gP pol) 3.7)
	(= (duration-association-reaction SP1 gP SP1-gP) 0.9)
	(= (duration-association-reaction SP1-p107 gP SP1-p107-gP) 0.8)
	(= (duration-association-reaction SP1-p107p1 gP SP1-p107p1-gP) 0.8)
	(= (duration-association-reaction SP1 p107p1 SP1-p107p1) 1.1)
	(= (duration-association-reaction SP1 p107 SP1-p107) 1.0))

(:goal
	(and
	(>= (+ (available pRbp1-E2F4-DP12p1) (available SP1-p107-gP)) 2)
	(>= (+ (available cycA) (available SP1-p107p1-gP)) 6)
	(>= (+ (available cdk46p1-cycD) (available HDAC1-p107-E2F4-DP12p1)) 6)))


(:metric minimize (+ (* 25 (- (num-subs) 3)) (total-time)))
)
