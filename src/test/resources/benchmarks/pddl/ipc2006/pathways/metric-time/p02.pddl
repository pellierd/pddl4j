(define (problem Pathways-02)
(:domain Pathways-MetricTime)
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
	p107-E2F4-DP12p1-gE2 - complex
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
	p107 - complex)


(:init
	(possible p53p1)
	(= (available p53p1) 0)
	(possible p130)
	(= (available p130) 0)
	(possible Max)
	(= (available Max) 0)
	(possible HDAC1-pRbp1-E2F4-DP12)
	(= (available HDAC1-pRbp1-E2F4-DP12) 0)
	(possible HDAC1-pRbp1-E2F13-DP12)
	(= (available HDAC1-pRbp1-E2F13-DP12) 0)
	(possible HDAC1-p130-E2F4p1-DP12)
	(= (available HDAC1-p130-E2F4p1-DP12) 0)
	(possible HBP1)
	(= (available HBP1) 0)
	(possible gE2)
	(= (available gE2) 0)
	(possible E2F6-DP12p1)
	(= (available E2F6-DP12p1) 0)
	(possible E2F4-DP12p1)
	(= (available E2F4-DP12p1) 0)
	(possible E2F13p1-DP12)
	(= (available E2F13p1-DP12) 0)
	(possible cdk1p1p2)
	(= (available cdk1p1p2) 0)
	(= (available cdk1p1p2-Gadd45) 0)
	(= (available c-Myc-Max) 0)
	(= (available E2F13p1-DP12-gE2) 0)
	(= (available E2F6-DP12p1-gE2) 0)
	(= (available HBP1-p130) 0)
	(= (available HDAC1-p130-E2F4p1-DP12-gE2) 0)
	(= (available HDAC1-pRbp1-E2F13-DP12-gE2) 0)
	(= (available HDAC1-pRbp1-E2F4-DP12-gE2) 0)
	(= (available Mdm2-E2F13p1-DP12) 0)
	(= (available p107-E2F4-DP12p1-gE2) 0)
	(= (available p107-E2F4-DP12p1) 0)
	(= (available p130-E2F4-DP12p1-gE2) 0)
	(= (available p130-E2F4-DP12p1) 0)
	(= (available p21-Gadd45) 0)
	(= (available Mdm2) 0)
	(= (available Gadd45) 0)
	(= (available p21) 0)
	(= (available c-Fos) 0)
	(= (available c-Myc) 0)
	(= (available cycA) 0)
	(= (available cycD) 0)
	(= (available cycDp1) 0)
	(= (available cycE) 0)
	(= (available cycEp1) 0)
	(= (available p19ARF) 0)
	(= (available pol) 0)
	(= (available p107p1) 0)
	(= (available p107) 0)
	(association-reaction cdk1p1p2 Gadd45 cdk1p1p2-Gadd45)
	(= (need-for-association cdk1p1p2 Gadd45 cdk1p1p2-Gadd45) 2)
	(= (need-for-association Gadd45 cdk1p1p2 cdk1p1p2-Gadd45) 3)
	(= (prod-by-association cdk1p1p2 Gadd45 cdk1p1p2-Gadd45) 4)
	(association-reaction c-Myc Max c-Myc-Max)
	(= (need-for-association c-Myc Max c-Myc-Max) 3)
	(= (need-for-association Max c-Myc c-Myc-Max) 4)
	(= (prod-by-association c-Myc Max c-Myc-Max) 1)
	(synthesis-reaction E2F13p1-DP12-gE2 c-Myc) 
	(= (need-for-synthesis E2F13p1-DP12-gE2 c-Myc) 2)
	(= (prod-by-synthesis E2F13p1-DP12-gE2 c-Myc) 4)
	(synthesis-reaction E2F13p1-DP12-gE2 cycA) 
	(= (need-for-synthesis E2F13p1-DP12-gE2 cycA) 3)
	(= (prod-by-synthesis E2F13p1-DP12-gE2 cycA) 3)
	(synthesis-reaction E2F13p1-DP12-gE2 cycD) 
	(= (need-for-synthesis E2F13p1-DP12-gE2 cycD) 3)
	(= (prod-by-synthesis E2F13p1-DP12-gE2 cycD) 2)
	(synthesis-reaction E2F13p1-DP12-gE2 cycDp1) 
	(= (need-for-synthesis E2F13p1-DP12-gE2 cycDp1) 2)
	(= (prod-by-synthesis E2F13p1-DP12-gE2 cycDp1) 3)
	(synthesis-reaction E2F13p1-DP12-gE2 cycE) 
	(= (need-for-synthesis E2F13p1-DP12-gE2 cycE) 2)
	(= (prod-by-synthesis E2F13p1-DP12-gE2 cycE) 4)
	(synthesis-reaction E2F13p1-DP12-gE2 cycEp1) 
	(= (need-for-synthesis E2F13p1-DP12-gE2 cycEp1) 3)
	(= (prod-by-synthesis E2F13p1-DP12-gE2 cycEp1) 3)
	(association-reaction E2F13p1-DP12 gE2 E2F13p1-DP12-gE2)
	(= (need-for-association E2F13p1-DP12 gE2 E2F13p1-DP12-gE2) 2)
	(= (need-for-association gE2 E2F13p1-DP12 E2F13p1-DP12-gE2) 4)
	(= (prod-by-association E2F13p1-DP12 gE2 E2F13p1-DP12-gE2) 2)
	(synthesis-reaction E2F13p1-DP12-gE2 p107) 
	(= (need-for-synthesis E2F13p1-DP12-gE2 p107) 3)
	(= (prod-by-synthesis E2F13p1-DP12-gE2 p107) 2)
	(synthesis-reaction E2F13p1-DP12-gE2 p107p1) 
	(= (need-for-synthesis E2F13p1-DP12-gE2 p107p1) 3)
	(= (prod-by-synthesis E2F13p1-DP12-gE2 p107p1) 3)
	(synthesis-reaction E2F13p1-DP12-gE2 p19ARF) 
	(= (need-for-synthesis E2F13p1-DP12-gE2 p19ARF) 1)
	(= (prod-by-synthesis E2F13p1-DP12-gE2 p19ARF) 2)
	(synthesis-reaction E2F13p1-DP12-gE2 pol) 
	(= (need-for-synthesis E2F13p1-DP12-gE2 pol) 4)
	(= (prod-by-synthesis E2F13p1-DP12-gE2 pol) 4)
	(association-reaction E2F6-DP12p1 gE2 E2F6-DP12p1-gE2)
	(= (need-for-association E2F6-DP12p1 gE2 E2F6-DP12p1-gE2) 2)
	(= (need-for-association gE2 E2F6-DP12p1 E2F6-DP12p1-gE2) 4)
	(= (prod-by-association E2F6-DP12p1 gE2 E2F6-DP12p1-gE2) 1)
	(association-reaction HBP1 p130 HBP1-p130)
	(= (need-for-association HBP1 p130 HBP1-p130) 4)
	(= (need-for-association p130 HBP1 HBP1-p130) 3)
	(= (prod-by-association HBP1 p130 HBP1-p130) 3)
	(association-reaction HDAC1-p130-E2F4p1-DP12 gE2 HDAC1-p130-E2F4p1-DP12-gE2)
	(= (need-for-association HDAC1-p130-E2F4p1-DP12 gE2 HDAC1-p130-E2F4p1-DP12-gE2) 4)
	(= (need-for-association gE2 HDAC1-p130-E2F4p1-DP12 HDAC1-p130-E2F4p1-DP12-gE2) 3)
	(= (prod-by-association HDAC1-p130-E2F4p1-DP12 gE2 HDAC1-p130-E2F4p1-DP12-gE2) 4)
	(association-reaction HDAC1-pRbp1-E2F13-DP12 gE2 HDAC1-pRbp1-E2F13-DP12-gE2)
	(= (need-for-association HDAC1-pRbp1-E2F13-DP12 gE2 HDAC1-pRbp1-E2F13-DP12-gE2) 3)
	(= (need-for-association gE2 HDAC1-pRbp1-E2F13-DP12 HDAC1-pRbp1-E2F13-DP12-gE2) 1)
	(= (prod-by-association HDAC1-pRbp1-E2F13-DP12 gE2 HDAC1-pRbp1-E2F13-DP12-gE2) 2)
	(association-reaction HDAC1-pRbp1-E2F4-DP12 gE2 HDAC1-pRbp1-E2F4-DP12-gE2)
	(= (need-for-association HDAC1-pRbp1-E2F4-DP12 gE2 HDAC1-pRbp1-E2F4-DP12-gE2) 1)
	(= (need-for-association gE2 HDAC1-pRbp1-E2F4-DP12 HDAC1-pRbp1-E2F4-DP12-gE2) 2)
	(= (prod-by-association HDAC1-pRbp1-E2F4-DP12 gE2 HDAC1-pRbp1-E2F4-DP12-gE2) 3)
	(association-reaction Mdm2 E2F13p1-DP12 Mdm2-E2F13p1-DP12)
	(= (need-for-association Mdm2 E2F13p1-DP12 Mdm2-E2F13p1-DP12) 4)
	(= (need-for-association E2F13p1-DP12 Mdm2 Mdm2-E2F13p1-DP12) 4)
	(= (prod-by-association Mdm2 E2F13p1-DP12 Mdm2-E2F13p1-DP12) 3)
	(association-reaction p107-E2F4-DP12p1 gE2 p107-E2F4-DP12p1-gE2)
	(= (need-for-association p107-E2F4-DP12p1 gE2 p107-E2F4-DP12p1-gE2) 2)
	(= (need-for-association gE2 p107-E2F4-DP12p1 p107-E2F4-DP12p1-gE2) 2)
	(= (prod-by-association p107-E2F4-DP12p1 gE2 p107-E2F4-DP12p1-gE2) 4)
	(association-reaction p107 E2F4-DP12p1 p107-E2F4-DP12p1)
	(= (need-for-association p107 E2F4-DP12p1 p107-E2F4-DP12p1) 2)
	(= (need-for-association E2F4-DP12p1 p107 p107-E2F4-DP12p1) 3)
	(= (prod-by-association p107 E2F4-DP12p1 p107-E2F4-DP12p1) 2)
	(association-reaction p130-E2F4-DP12p1 gE2 p130-E2F4-DP12p1-gE2)
	(= (need-for-association p130-E2F4-DP12p1 gE2 p130-E2F4-DP12p1-gE2) 3)
	(= (need-for-association gE2 p130-E2F4-DP12p1 p130-E2F4-DP12p1-gE2) 1)
	(= (prod-by-association p130-E2F4-DP12p1 gE2 p130-E2F4-DP12p1-gE2) 1)
	(association-reaction p130 E2F4-DP12p1 p130-E2F4-DP12p1)
	(= (need-for-association p130 E2F4-DP12p1 p130-E2F4-DP12p1) 4)
	(= (need-for-association E2F4-DP12p1 p130 p130-E2F4-DP12p1) 2)
	(= (prod-by-association p130 E2F4-DP12p1 p130-E2F4-DP12p1) 4)
	(association-reaction p21 Gadd45 p21-Gadd45)
	(= (need-for-association p21 Gadd45 p21-Gadd45) 3)
	(= (need-for-association Gadd45 p21 p21-Gadd45) 3)
	(= (prod-by-association p21 Gadd45 p21-Gadd45) 3)
	(synthesis-reaction p53p1 c-Fos) 
	(= (need-for-synthesis p53p1 c-Fos) 3)
	(= (prod-by-synthesis p53p1 c-Fos) 3)
	(synthesis-reaction p53p1 Gadd45) 
	(= (need-for-synthesis p53p1 Gadd45) 2)
	(= (prod-by-synthesis p53p1 Gadd45) 2)
	(synthesis-reaction p53p1 Mdm2) 
	(= (need-for-synthesis p53p1 Mdm2) 2)
	(= (prod-by-synthesis p53p1 Mdm2) 4)
	(synthesis-reaction p53p1 p21) 
	(= (need-for-synthesis p53p1 p21) 1)
	(= (prod-by-synthesis p53p1 p21) 4)
	(= (num-subs) 0)
	(= (duration-association-reaction cdk1p1p2 Gadd45 cdk1p1p2-Gadd45) 1.0)
	(= (duration-association-reaction c-Myc Max c-Myc-Max) 1.1)
	(= (duration-synthesis-reaction E2F13p1-DP12-gE2 c-Myc) 3.3)
	(= (duration-synthesis-reaction E2F13p1-DP12-gE2 cycA) 4.0)
	(= (duration-synthesis-reaction E2F13p1-DP12-gE2 cycD) 4.1)
	(= (duration-synthesis-reaction E2F13p1-DP12-gE2 cycDp1) 3.5)
	(= (duration-synthesis-reaction E2F13p1-DP12-gE2 cycE) 4.5)
	(= (duration-synthesis-reaction E2F13p1-DP12-gE2 cycEp1) 4.0)
	(= (duration-association-reaction E2F13p1-DP12 gE2 E2F13p1-DP12-gE2) 0.9)
	(= (duration-synthesis-reaction E2F13p1-DP12-gE2 p107) 3.8)
	(= (duration-synthesis-reaction E2F13p1-DP12-gE2 p107p1) 3.4)
	(= (duration-synthesis-reaction E2F13p1-DP12-gE2 p19ARF) 4.2)
	(= (duration-synthesis-reaction E2F13p1-DP12-gE2 pol) 4.1)
	(= (duration-association-reaction E2F6-DP12p1 gE2 E2F6-DP12p1-gE2) 0.8)
	(= (duration-association-reaction HBP1 p130 HBP1-p130) 0.8)
	(= (duration-association-reaction HDAC1-p130-E2F4p1-DP12 gE2 HDAC1-p130-E2F4p1-DP12-gE2) 0.8)
	(= (duration-association-reaction HDAC1-pRbp1-E2F13-DP12 gE2 HDAC1-pRbp1-E2F13-DP12-gE2) 0.9)
	(= (duration-association-reaction HDAC1-pRbp1-E2F4-DP12 gE2 HDAC1-pRbp1-E2F4-DP12-gE2) 0.8)
	(= (duration-association-reaction Mdm2 E2F13p1-DP12 Mdm2-E2F13p1-DP12) 1.0)
	(= (duration-association-reaction p107-E2F4-DP12p1 gE2 p107-E2F4-DP12p1-gE2) 0.8)
	(= (duration-association-reaction p107 E2F4-DP12p1 p107-E2F4-DP12p1) 0.9)
	(= (duration-association-reaction p130-E2F4-DP12p1 gE2 p130-E2F4-DP12p1-gE2) 0.9)
	(= (duration-association-reaction p130 E2F4-DP12p1 p130-E2F4-DP12p1) 0.9)
	(= (duration-association-reaction p21 Gadd45 p21-Gadd45) 0.9)
	(= (duration-synthesis-reaction p53p1 c-Fos) 4.6)
	(= (duration-synthesis-reaction p53p1 Gadd45) 3.5)
	(= (duration-synthesis-reaction p53p1 Mdm2) 3.5)
	(= (duration-synthesis-reaction p53p1 p21) 3.7))

(:goal
	(and
	(>= (+ (available p107-E2F4-DP12p1-gE2) (available p107-E2F4-DP12p1)) 4)
	(>= (+ (available cycDp1) (available c-Myc-Max)) 3)))


(:metric minimize (+ (* 25 (- (num-subs) 3)) (total-time)))
)
