
(define (problem p50-net5-b30-g8)
  (:domain pipesworld_strips)
  (:objects

    	B10 B21 B17 B14 B27 B22 B4 B28 B6 B15 B19 B29 B20 B13 B8 B2 B11 B24 B5 B0 B1 B25 B18 B7 B12 B9 B3 B26 B23 B16 - batch-atom
	A1 A2 A3 A4 A5 - area
	S12 S13 S34 S23 S15 - pipe
	

  )
  (:init

    ;; speed of pipe segments
    	(= (speed S12) 2)
	(= (speed S13) 2)
	(= (speed S34) 1)
	(= (speed S23) 3)
	(= (speed S15) 4)

    ;; All pipelines segments are in normal state
    		(normal S12)
		(normal S13)
		(normal S34)
		(normal S23)
		(normal S15)

    ;; Interfaces restrictions
    	(may-interface lco lco)
	(may-interface gasoleo gasoleo)
	(may-interface rat-a rat-a)
	(may-interface oca1 oca1)
	(may-interface oc1b oc1b)
	(may-interface lco gasoleo)
	(may-interface gasoleo lco)
	(may-interface lco oca1)
	(may-interface oca1 lco)
	(may-interface lco oc1b)
	(may-interface oc1b lco)
	(may-interface lco rat-a)
	(may-interface rat-a lco)
	(may-interface gasoleo rat-a)
	(may-interface rat-a gasoleo)
	(may-interface gasoleo oca1)
	(may-interface oca1 gasoleo)
	(may-interface gasoleo oc1b)
	(may-interface oc1b gasoleo)
	(may-interface oca1 oc1b)
	(may-interface oc1b oca1)
	

    ;; Network topology definition
    	(connect A1 A2 S12)
	(connect A1 A3 S13)
	(connect A3 A4 S34)
	(connect A2 A3 S23)
	(connect A1 A5 S15)
	

    ;; Batch-atoms products
    	(is-product B10 oca1)
	(is-product B21 oca1)
	(is-product B17 rat-a)
	(is-product B14 gasoleo)
	(is-product B27 oc1b)
	(is-product B22 oc1b)
	(is-product B4 gasoleo)
	(is-product B28 lco)
	(is-product B6 gasoleo)
	(is-product B15 oc1b)
	(is-product B19 gasoleo)
	(is-product B29 oca1)
	(is-product B20 rat-a)
	(is-product B13 rat-a)
	(is-product B8 oca1)
	(is-product B2 rat-a)
	(is-product B11 lco)
	(is-product B24 lco)
	(is-product B5 lco)
	(is-product B0 rat-a)
	(is-product B1 gasoleo)
	(is-product B25 oca1)
	(is-product B18 gasoleo)
	(is-product B7 lco)
	(is-product B12 oca1)
	(is-product B9 rat-a)
	(is-product B3 gasoleo)
	(is-product B26 rat-a)
	(is-product B23 lco)
	(is-product B16 oc1b)
	

    ;; Batch-atoms initially located in areas
    	(on B21 A3)
	(on B17 A2)
	(on B14 A2)
	(on B27 A2)
	(on B22 A5)
	(on B4 A5)
	(on B28 A5)
	(on B6 A3)
	(on B29 A1)
	(on B11 A3)
	(on B24 A5)
	(on B0 A5)
	(on B1 A4)
	(on B25 A1)
	(on B18 A4)
	(on B12 A1)
	(on B23 A5)
	(on B16 A4)
	

    ;; Batch-atoms initially located in pipes
    	(first B7 S12)
	(follow B9 B7)
	(last B9 S12)
	(first B8 S13)
	(follow B3 B8)
	(last B3 S13)
	(first B5 S34)
	(last B5 S34)
	(first B19 S23)
	(follow B13 B19)
	(follow B10 B13)
	(last B10 S23)
	(first B26 S15)
	(follow B2 B26)
	(follow B20 B2)
	(follow B15 B20)
	(last B15 S15)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)
		(unitary S34)
		(not-unitary S23)
		(not-unitary S15)

  )
  (:goal (and
    	(on B17 A3)
	(on B27 A4)
	(on B6 A4)
	(on B20 A2)
	(on B11 A1)
	(on B24 A4)
	(on B18 A3)
	(on B16 A1)
	
  ))


(:metric minimize (total-time))

)

