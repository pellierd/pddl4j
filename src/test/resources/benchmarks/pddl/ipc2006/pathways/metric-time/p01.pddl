(define (problem Pathways-01)
(:domain Pathways-MetricTime)
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
	pRbp1p2-AP2 - complex
	pRbp2-AP2 - complex
	pRbp1p2 - complex
	Raf1-p130-E2F5p1-DP12 - complex
	Raf1-pRb-E2F4p1-DP12 - complex
	SP1-E2F13 - complex)


(:init
	(possible SP1)
	(= (available SP1) 0)
	(possible Raf1)
	(= (available Raf1) 0)
	(possible pRbp2)
	(= (available pRbp2) 0)
	(possible pRb-E2F4p1-DP12)
	(= (available pRb-E2F4p1-DP12) 0)
	(possible pCAF)
	(= (available pCAF) 0)
	(possible p300)
	(= (available p300) 0)
	(possible p16)
	(= (available p16) 0)
	(possible p130-E2F5p1-DP12)
	(= (available p130-E2F5p1-DP12) 0)
	(possible E2F13)
	(= (available E2F13) 0)
	(possible DMP1)
	(= (available DMP1) 0)
	(possible Chk1)
	(= (available Chk1) 0)
	(possible cdk7)
	(= (available cdk7) 0)
	(possible cdk46p3-cycDp1)
	(= (available cdk46p3-cycDp1) 0)
	(possible cdk46p3-cycD)
	(= (available cdk46p3-cycD) 0)
	(possible cdc25C)
	(= (available cdc25C) 0)
	(possible AP2)
	(= (available AP2) 0)
	(= (available DMP1p1) 0)
	(= (available cdc25Cp2) 0)
	(= (available p16-cdk7) 0)
	(= (available pCAF-p300) 0)
	(= (available pRbp1p2-AP2) 0)
	(= (available pRbp2-AP2) 0)
	(= (available pRbp1p2) 0)
	(= (available Raf1-p130-E2F5p1-DP12) 0)
	(= (available Raf1-pRb-E2F4p1-DP12) 0)
	(= (available SP1-E2F13) 0)
	(catalyzed-association-reaction cdc25C Chk1 cdc25Cp2)
	(= (need-for-catalyzed-association cdc25C Chk1 cdc25Cp2) 4)
	(= (need-for-catalyzed-association Chk1 cdc25C cdc25Cp2) 3)
	(= (prod-by-catalyzed-association cdc25C Chk1 cdc25Cp2) 1)
	(catalyzed-association-reaction DMP1 cdk46p3-cycD DMP1p1)
	(= (need-for-catalyzed-association DMP1 cdk46p3-cycD DMP1p1) 2)
	(= (need-for-catalyzed-association cdk46p3-cycD DMP1 DMP1p1) 4)
	(= (prod-by-catalyzed-association DMP1 cdk46p3-cycD DMP1p1) 2)
	(catalyzed-association-reaction DMP1 cdk46p3-cycDp1 DMP1p1)
	(= (need-for-catalyzed-association DMP1 cdk46p3-cycDp1 DMP1p1) 4)
	(= (need-for-catalyzed-association cdk46p3-cycDp1 DMP1 DMP1p1) 4)
	(= (prod-by-catalyzed-association DMP1 cdk46p3-cycDp1 DMP1p1) 1)
	(association-reaction p16 cdk7 p16-cdk7)
	(= (need-for-association p16 cdk7 p16-cdk7) 4)
	(= (need-for-association cdk7 p16 p16-cdk7) 3)
	(= (prod-by-association p16 cdk7 p16-cdk7) 4)
	(association-reaction pCAF p300 pCAF-p300)
	(= (need-for-association pCAF p300 pCAF-p300) 3)
	(= (need-for-association p300 pCAF pCAF-p300) 1)
	(= (prod-by-association pCAF p300 pCAF-p300) 3)
	(association-reaction pRbp1p2 AP2 pRbp1p2-AP2)
	(= (need-for-association pRbp1p2 AP2 pRbp1p2-AP2) 4)
	(= (need-for-association AP2 pRbp1p2 pRbp1p2-AP2) 4)
	(= (prod-by-association pRbp1p2 AP2 pRbp1p2-AP2) 4)
	(association-reaction pRbp2 AP2 pRbp2-AP2)
	(= (need-for-association pRbp2 AP2 pRbp2-AP2) 2)
	(= (need-for-association AP2 pRbp2 pRbp2-AP2) 1)
	(= (prod-by-association pRbp2 AP2 pRbp2-AP2) 2)
	(catalyzed-association-reaction pRbp2 cdk46p3-cycDp1 pRbp1p2)
	(= (need-for-catalyzed-association pRbp2 cdk46p3-cycDp1 pRbp1p2) 3)
	(= (need-for-catalyzed-association cdk46p3-cycDp1 pRbp2 pRbp1p2) 3)
	(= (prod-by-catalyzed-association pRbp2 cdk46p3-cycDp1 pRbp1p2) 1)
	(catalyzed-association-reaction pRbp2 cdk46p3-cycD pRbp1p2)
	(= (need-for-catalyzed-association pRbp2 cdk46p3-cycD pRbp1p2) 3)
	(= (need-for-catalyzed-association cdk46p3-cycD pRbp2 pRbp1p2) 2)
	(= (prod-by-catalyzed-association pRbp2 cdk46p3-cycD pRbp1p2) 3)
	(association-reaction Raf1 p130-E2F5p1-DP12 Raf1-p130-E2F5p1-DP12)
	(= (need-for-association Raf1 p130-E2F5p1-DP12 Raf1-p130-E2F5p1-DP12) 2)
	(= (need-for-association p130-E2F5p1-DP12 Raf1 Raf1-p130-E2F5p1-DP12) 3)
	(= (prod-by-association Raf1 p130-E2F5p1-DP12 Raf1-p130-E2F5p1-DP12) 3)
	(association-reaction Raf1 pRb-E2F4p1-DP12 Raf1-pRb-E2F4p1-DP12)
	(= (need-for-association Raf1 pRb-E2F4p1-DP12 Raf1-pRb-E2F4p1-DP12) 4)
	(= (need-for-association pRb-E2F4p1-DP12 Raf1 Raf1-pRb-E2F4p1-DP12) 2)
	(= (prod-by-association Raf1 pRb-E2F4p1-DP12 Raf1-pRb-E2F4p1-DP12) 2)
	(association-reaction SP1 E2F13 SP1-E2F13)
	(= (need-for-association SP1 E2F13 SP1-E2F13) 4)
	(= (need-for-association E2F13 SP1 SP1-E2F13) 3)
	(= (prod-by-association SP1 E2F13 SP1-E2F13) 1)
	(= (num-subs) 0)
	(= (duration-catalyzed-association-reaction cdc25C Chk1 cdc25Cp2) 1.9)
	(= (duration-catalyzed-association-reaction DMP1 cdk46p3-cycD DMP1p1) 2.0)
	(= (duration-catalyzed-association-reaction DMP1 cdk46p3-cycDp1 DMP1p1) 2.3)
	(= (duration-association-reaction p16 cdk7 p16-cdk7) 0.8)
	(= (duration-association-reaction pCAF p300 pCAF-p300) 1.0)
	(= (duration-association-reaction pRbp1p2 AP2 pRbp1p2-AP2) 1.0)
	(= (duration-association-reaction pRbp2 AP2 pRbp2-AP2) 1.0)
	(= (duration-catalyzed-association-reaction pRbp2 cdk46p3-cycDp1 pRbp1p2) 1.7)
	(= (duration-catalyzed-association-reaction pRbp2 cdk46p3-cycD pRbp1p2) 2.2)
	(= (duration-association-reaction Raf1 p130-E2F5p1-DP12 Raf1-p130-E2F5p1-DP12) 1.1)
	(= (duration-association-reaction Raf1 pRb-E2F4p1-DP12 Raf1-pRb-E2F4p1-DP12) 1.1)
	(= (duration-association-reaction SP1 E2F13 SP1-E2F13) 1.1))

(:goal
	(and
	(>= (+ (available pRbp1p2-AP2) (available pCAF-p300)) 4)))


(:metric minimize (+ (* 25 (- (num-subs) 3)) (total-time)))
)
