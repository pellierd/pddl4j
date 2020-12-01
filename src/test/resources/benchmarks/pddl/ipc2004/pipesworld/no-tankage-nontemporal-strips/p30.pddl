
(define (problem network3new_all_20_8_instance)
  (:domain pipesworld_strips)
  (:objects

    	B10 B17 B14 B4 B6 B15 B19 B13 B8 B2 B11 B5 B0 B1 B18 B7 B12 B9 B3 B16 - batch-atom
	A1 A2 A3 A4 - area
	S12 S13 S34 - pipe
	

  )
  (:init

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
    	(is-product B10 rat-a)
	(is-product B17 rat-a)
	(is-product B14 gasoleo)
	(is-product B4 rat-a)
	(is-product B6 lco)
	(is-product B15 gasoleo)
	(is-product B19 oc1b)
	(is-product B13 oca1)
	(is-product B8 rat-a)
	(is-product B2 oca1)
	(is-product B11 rat-a)
	(is-product B5 lco)
	(is-product B0 gasoleo)
	(is-product B1 rat-a)
	(is-product B18 rat-a)
	(is-product B7 rat-a)
	(is-product B12 oca1)
	(is-product B9 lco)
	(is-product B3 oca1)
	(is-product B16 gasoleo)
	

    ;; Batch-atoms initially located in areas
    	(on B17 A2)
	(on B14 A3)
	(on B4 A3)
	(on B15 A2)
	(on B19 A2)
	(on B13 A4)
	(on B8 A1)
	(on B2 A1)
	(on B11 A2)
	(on B5 A1)
	(on B1 A3)
	(on B7 A3)
	(on B12 A1)
	(on B3 A3)
	(on B16 A3)
	

    ;; Batch-atoms initially located in pipes
    	(first B6 S12)
	(follow B0 B6)
	(last B0 S12)
	(first B18 S13)
	(follow B10 B18)
	(last B10 S13)
	(first B9 S34)
	(last B9 S34)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)
		(unitary S34)

  )
  (:goal (and
    	(on B10 A3)
	(on B4 A1)
	(on B6 A3)
	(on B13 A1)
	(on B2 A2)
	(on B11 A1)
	(on B18 A2)
	(on B12 A4)
	
  ))
)
