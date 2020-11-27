
(define (problem p48-net5-b28-g7)
  (:domain pipesworld_strips)
  (:objects

    	B10 B21 B17 B14 B27 B22 B4 B6 B15 B19 B20 B13 B8 B2 B11 B24 B5 B0 B1 B25 B18 B7 B12 B9 B3 B26 B23 B16 - batch-atom
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
    	(is-product B10 rat-a)
	(is-product B21 gasoleo)
	(is-product B17 gasoleo)
	(is-product B14 gasoleo)
	(is-product B27 rat-a)
	(is-product B22 rat-a)
	(is-product B4 rat-a)
	(is-product B6 lco)
	(is-product B15 rat-a)
	(is-product B19 rat-a)
	(is-product B20 rat-a)
	(is-product B13 oca1)
	(is-product B8 lco)
	(is-product B2 gasoleo)
	(is-product B11 lco)
	(is-product B24 oca1)
	(is-product B5 gasoleo)
	(is-product B0 oc1b)
	(is-product B1 oc1b)
	(is-product B25 lco)
	(is-product B18 lco)
	(is-product B7 oca1)
	(is-product B12 oca1)
	(is-product B9 gasoleo)
	(is-product B3 oc1b)
	(is-product B26 rat-a)
	(is-product B23 lco)
	(is-product B16 lco)
	

    ;; Batch-atoms initially located in areas
    	(on B10 A2)
	(on B17 A4)
	(on B14 A5)
	(on B27 A4)
	(on B22 A1)
	(on B4 A5)
	(on B15 A5)
	(on B19 A2)
	(on B8 A4)
	(on B11 A3)
	(on B1 A5)
	(on B25 A1)
	(on B3 A1)
	(on B26 A2)
	(on B23 A4)
	(on B16 A2)
	

    ;; Batch-atoms initially located in pipes
    	(first B5 S12)
	(follow B24 B5)
	(last B24 S12)
	(first B2 S13)
	(follow B0 B2)
	(last B0 S13)
	(first B21 S34)
	(last B21 S34)
	(first B20 S23)
	(follow B7 B20)
	(follow B13 B7)
	(last B13 S23)
	(first B9 S15)
	(follow B6 B9)
	(follow B12 B6)
	(follow B18 B12)
	(last B18 S15)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)
		(unitary S34)
		(not-unitary S23)
		(not-unitary S15)

  )
  (:goal (and
    	(on B17 A2)
	(on B22 A4)
	(on B15 A4)
	(on B13 A3)
	(on B24 A1)
	(on B1 A4)
	(on B23 A2)
	
  ))


(:metric minimize (total-time))

)

