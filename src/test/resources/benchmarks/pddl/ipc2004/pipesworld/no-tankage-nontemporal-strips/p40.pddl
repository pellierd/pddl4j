
(define (problem network4new_all_22_8_instance)
  (:domain pipesworld_strips)
  (:objects

    	B10 B21 B17 B14 B4 B6 B15 B19 B20 B13 B8 B2 B11 B5 B0 B1 B18 B7 B12 B9 B3 B16 - batch-atom
	A1 A2 A3 A4 - area
	S12 S13 S34 S23 - pipe
	

  )
  (:init

    ;; All pipelines segments are in normal state
    		(normal S12)
		(normal S13)
		(normal S34)
		(normal S23)

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
	

    ;; Batch-atoms products
    	(is-product B10 oc1b)
	(is-product B21 lco)
	(is-product B17 oca1)
	(is-product B14 gasoleo)
	(is-product B4 gasoleo)
	(is-product B6 lco)
	(is-product B15 oca1)
	(is-product B19 oc1b)
	(is-product B20 gasoleo)
	(is-product B13 oca1)
	(is-product B8 lco)
	(is-product B2 rat-a)
	(is-product B11 oc1b)
	(is-product B5 oc1b)
	(is-product B0 rat-a)
	(is-product B1 oca1)
	(is-product B18 lco)
	(is-product B7 gasoleo)
	(is-product B12 oca1)
	(is-product B9 lco)
	(is-product B3 oca1)
	(is-product B16 oc1b)
	

    ;; Batch-atoms initially located in areas
    	(on B10 A4)
	(on B17 A4)
	(on B14 A3)
	(on B4 A3)
	(on B6 A4)
	(on B19 A1)
	(on B20 A1)
	(on B13 A4)
	(on B2 A3)
	(on B0 A3)
	(on B1 A2)
	(on B12 A2)
	(on B3 A1)
	(on B16 A4)
	

    ;; Batch-atoms initially located in pipes
    	(first B21 S12)
	(follow B15 B21)
	(last B15 S12)
	(first B7 S13)
	(follow B8 B7)
	(last B8 S13)
	(first B11 S34)
	(last B11 S34)
	(first B18 S23)
	(follow B5 B18)
	(follow B9 B5)
	(last B9 S23)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)
		(unitary S34)
		(not-unitary S23)

  )
  (:goal (and
    	(on B14 A4)
	(on B6 A1)
	(on B15 A2)
	(on B19 A3)
	(on B8 A1)
	(on B18 A4)
	(on B7 A1)
	(on B3 A3)
	
  ))
)
