
(define (problem network4new_all_16_5_instance)
  (:domain pipesworld_strips)
  (:objects

    	B10 B14 B4 B6 B15 B13 B8 B2 B11 B5 B0 B1 B7 B9 B12 B3 - batch-atom
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
	(is-product B14 rat-a)
	(is-product B4 oc1b)
	(is-product B6 lco)
	(is-product B15 rat-a)
	(is-product B13 rat-a)
	(is-product B8 oc1b)
	(is-product B2 gasoleo)
	(is-product B11 oc1b)
	(is-product B5 lco)
	(is-product B0 oca1)
	(is-product B1 oc1b)
	(is-product B7 rat-a)
	(is-product B9 rat-a)
	(is-product B12 gasoleo)
	(is-product B3 oca1)
	

    ;; Batch-atoms initially located in areas
    	(on B14 A3)
	(on B4 A1)
	(on B6 A2)
	(on B2 A4)
	(on B5 A4)
	(on B9 A3)
	(on B12 A2)
	(on B3 A2)
	

    ;; Batch-atoms initially located in pipes
    	(first B1 S12)
	(follow B15 B1)
	(last B15 S12)
	(first B13 S13)
	(follow B8 B13)
	(last B8 S13)
	(first B0 S34)
	(last B0 S34)
	(first B7 S23)
	(follow B11 B7)
	(follow B10 B11)
	(last B10 S23)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)
		(unitary S34)
		(not-unitary S23)

  )
  (:goal (and
    	(on B6 A4)
	(on B8 A3)
	(on B11 A3)
	(on B1 A3)
	(on B9 A2)
	
  ))
)
