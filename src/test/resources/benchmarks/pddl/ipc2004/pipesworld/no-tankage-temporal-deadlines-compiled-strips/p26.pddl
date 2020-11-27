
(define (problem p28-net3-b18-g7_dt0_instance)
  (:domain pipesworld_strips)
  (:objects

    	B10 B17 B14 B4 B6 B15 B13 B8 B2 B11 B5 B0 B1 B7 B12 B9 B3 B16 - batch-atom
	A1 A2 A3 A4 - area
	S12 S13 S34 - pipe
	

  )
  (:init
      (NN)

    ;; deliverable conds for all batches
      (deliverable B10)
      (deliverable B17)
      (deliverable B14)
      (deliverable B4)
      (deliverable B6)
      (deliverable B15)
      (deliverable B13)
      (deliverable B8)
      (deliverable B2)
      (deliverable B11)
      (deliverable B5)
      (deliverable B0)
      (deliverable B1)
      (deliverable B7)
      (deliverable B12)
      (deliverable B9)
      (deliverable B3)
      (deliverable B16)


    ;; deadlines for goal batches
      ;; Plan delivery time is 6.01
      ;; Plan delivery time is 7.02
      ;; Plan delivery time is 16.06
      ;; Plan delivery time is 13.04
      ;; Plan delivery time is 6.02
      ;; Plan delivery time is 13.04
      ;; Plan delivery time is 14.04

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
    	(is-product B10 gasoleo)
	(is-product B17 oca1)
	(is-product B14 gasoleo)
	(is-product B4 oc1b)
	(is-product B6 gasoleo)
	(is-product B15 lco)
	(is-product B13 oca1)
	(is-product B8 oca1)
	(is-product B2 gasoleo)
	(is-product B11 oca1)
	(is-product B5 lco)
	(is-product B0 oc1b)
	(is-product B1 oc1b)
	(is-product B7 oca1)
	(is-product B12 oca1)
	(is-product B9 rat-a)
	(is-product B3 oc1b)
	(is-product B16 rat-a)
	

    ;; Batch-atoms initially located in areas
    	(on B14 A2)
	(on B4 A3)
	(on B13 A1)
	(on B8 A4)
	(on B2 A4)
	(on B11 A4)
	(on B5 A3)
	(on B1 A1)
	(on B7 A1)
	(on B12 A1)
	(on B9 A1)
	(on B3 A1)
	(on B16 A3)
	

    ;; Batch-atoms initially located in pipes
    	(first B0 S12)
	(follow B10 B0)
	(last B10 S12)
	(first B15 S13)
	(follow B6 B15)
	(last B6 S13)
	(first B17 S34)
	(last B17 S34)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)
		(unitary S34)

  )
  (:goal (and
        (P5)
    	(on B17 A1)
	(on B4 A2)
	(on B6 A2)
	(on B11 A3)
	(on B1 A2)
	(on B9 A4)
	(on B3 A3)
	
  ))

 


(:metric minimize (total-time))

)

