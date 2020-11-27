
(define (problem p26-net3-b16-g7)
  (:domain pipesworld_strips)
  (:objects

    	B10 B14 B4 B6 B15 B13 B8 B2 B11 B5 B0 B1 B7 B9 B12 B3 - batch-atom
	A1 A2 A3 A4 - area
	S12 S13 S34 - pipe
	

  )
  (:init

    ;; speed of pipe segments
    	(= (speed S12) 2)
	(= (speed S13) 2)
	(= (speed S34) 1)

    ;; All pipelines segments are in normal state
    		(normal S12)
		(normal S13)
		(normal S34)

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
	

    ;; Batch-atoms products
    	(is-product B10 oc1b)
	(is-product B14 oca1)
	(is-product B4 rat-a)
	(is-product B6 gasoleo)
	(is-product B15 oc1b)
	(is-product B13 oc1b)
	(is-product B8 oc1b)
	(is-product B2 lco)
	(is-product B11 oc1b)
	(is-product B5 oc1b)
	(is-product B0 oc1b)
	(is-product B1 gasoleo)
	(is-product B7 gasoleo)
	(is-product B9 lco)
	(is-product B12 lco)
	(is-product B3 oc1b)
	

    ;; Batch-atoms initially located in areas
    	(on B10 A4)
	(on B4 A2)
	(on B6 A3)
	(on B13 A2)
	(on B8 A1)
	(on B11 A2)
	(on B5 A3)
	(on B0 A4)
	(on B7 A1)
	(on B12 A4)
	(on B3 A4)
	

    ;; Batch-atoms initially located in pipes
    	(first B2 S12)
	(follow B9 B2)
	(last B9 S12)
	(first B15 S13)
	(follow B14 B15)
	(last B14 S13)
	(first B1 S34)
	(last B1 S34)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)
		(unitary S34)

  )
  (:goal (and
    	(on B15 A1)
	(on B2 A2)
	(on B11 A4)
	(on B5 A4)
	(on B0 A1)
	(on B9 A1)
	(on B3 A2)
	
  ))


(:metric minimize (total-time))

)

