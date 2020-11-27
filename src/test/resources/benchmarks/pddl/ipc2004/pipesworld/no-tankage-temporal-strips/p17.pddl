
(define (problem p17-net2-b16-g5)
  (:domain pipesworld_strips)
  (:objects

    	B10 B14 B4 B6 B15 B13 B8 B2 B11 B5 B0 B1 B7 B9 B12 B3 - batch-atom
	A1 A2 A3 - area
	S12 S13 - pipe
	

  )
  (:init

    ;; speed of pipe segments
    	(= (speed S12) 2)
	(= (speed S13) 2)

    ;; All pipelines segments are in normal state
    		(normal S12)
		(normal S13)

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
	

    ;; Batch-atoms products
    	(is-product B10 oca1)
	(is-product B14 oca1)
	(is-product B4 rat-a)
	(is-product B6 lco)
	(is-product B15 gasoleo)
	(is-product B13 gasoleo)
	(is-product B8 oc1b)
	(is-product B2 lco)
	(is-product B11 lco)
	(is-product B5 oc1b)
	(is-product B0 oc1b)
	(is-product B1 rat-a)
	(is-product B7 oca1)
	(is-product B9 oca1)
	(is-product B12 rat-a)
	(is-product B3 oca1)
	

    ;; Batch-atoms initially located in areas
    	(on B14 A2)
	(on B4 A2)
	(on B6 A1)
	(on B13 A2)
	(on B8 A2)
	(on B2 A3)
	(on B11 A3)
	(on B5 A3)
	(on B0 A1)
	(on B7 A2)
	(on B9 A3)
	(on B12 A2)
	

    ;; Batch-atoms initially located in pipes
    	(first B1 S12)
	(follow B15 B1)
	(last B15 S12)
	(first B10 S13)
	(follow B3 B10)
	(last B3 S13)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)

  )
  (:goal (and
    	(on B10 A3)
	(on B14 A1)
	(on B15 A1)
	(on B0 A2)
	(on B1 A1)
	
  ))


(:metric minimize (total-time))

)

