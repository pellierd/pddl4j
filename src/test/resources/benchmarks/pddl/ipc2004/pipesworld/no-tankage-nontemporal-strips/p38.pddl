
(define (problem network4new_all_20_7_instance)
  (:domain pipesworld_strips)
  (:objects

    	B10 B17 B14 B4 B6 B15 B19 B13 B8 B2 B11 B5 B0 B1 B18 B7 B12 B9 B3 B16 - batch-atom
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
	(is-product B17 gasoleo)
	(is-product B14 oc1b)
	(is-product B4 rat-a)
	(is-product B6 oc1b)
	(is-product B15 gasoleo)
	(is-product B19 lco)
	(is-product B13 lco)
	(is-product B8 gasoleo)
	(is-product B2 lco)
	(is-product B11 oca1)
	(is-product B5 oc1b)
	(is-product B0 lco)
	(is-product B1 rat-a)
	(is-product B18 lco)
	(is-product B7 rat-a)
	(is-product B12 oc1b)
	(is-product B9 rat-a)
	(is-product B3 rat-a)
	(is-product B16 oca1)
	

    ;; Batch-atoms initially located in areas
    	(on B17 A3)
	(on B14 A2)
	(on B6 A2)
	(on B15 A3)
	(on B13 A3)
	(on B11 A3)
	(on B0 A4)
	(on B7 A3)
	(on B12 A2)
	(on B9 A2)
	(on B3 A4)
	(on B16 A4)
	

    ;; Batch-atoms initially located in pipes
    	(first B18 S12)
	(follow B8 B18)
	(last B8 S12)
	(first B4 S13)
	(follow B5 B4)
	(last B5 S13)
	(first B10 S34)
	(last B10 S34)
	(first B2 S23)
	(follow B19 B2)
	(follow B1 B19)
	(last B1 S23)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)
		(unitary S34)
		(not-unitary S23)

  )
  (:goal (and
    	(on B10 A3)
	(on B17 A4)
	(on B14 A1)
	(on B6 A3)
	(on B13 A1)
	(on B2 A3)
	(on B5 A3)
	
  ))
)
