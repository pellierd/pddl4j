
(define (problem p15-net2-b14-g4_dt0_instance)
  (:domain pipesworld_strips)
  (:objects

    	B10 B0 B1 B4 B6 B7 B12 B9 B3 B13 B8 B2 B11 B5 - batch-atom
	A1 A2 A3 - area
	S12 S13 - pipe
	

  )
  (:init
      (NN)

    ;; deliverable conds for all batches
      (deliverable B10)
      (deliverable B0)
      (deliverable B1)
      (deliverable B4)
      (deliverable B6)
      (deliverable B7)
      (deliverable B12)
      (deliverable B9)
      (deliverable B3)
      (deliverable B13)
      (deliverable B8)
      (deliverable B2)
      (deliverable B11)
      (deliverable B5)


    ;; deadlines for goal batches
      ;; Plan delivery time is 6.02
      ;; Plan delivery time is 11.04
      ;; Plan delivery time is 10.03
      ;; Plan delivery time is 4.01

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
    	(is-product B10 rat-a)
	(is-product B0 rat-a)
	(is-product B1 oca1)
	(is-product B4 oca1)
	(is-product B6 lco)
	(is-product B7 lco)
	(is-product B12 rat-a)
	(is-product B9 oc1b)
	(is-product B3 rat-a)
	(is-product B13 rat-a)
	(is-product B8 rat-a)
	(is-product B2 oca1)
	(is-product B11 oc1b)
	(is-product B5 rat-a)
	

    ;; Batch-atoms initially located in areas
    	(on B0 A2)
	(on B4 A3)
	(on B6 A3)
	(on B9 A1)
	(on B3 A2)
	(on B13 A3)
	(on B8 A1)
	(on B2 A1)
	(on B11 A2)
	(on B5 A2)
	

    ;; Batch-atoms initially located in pipes
    	(first B10 S12)
	(follow B1 B10)
	(last B1 S12)
	(first B12 S13)
	(follow B7 B12)
	(last B7 S13)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)

  )
  (:goal (and
        (P4)
    	(on B7 A1)
	(on B12 A1)
	(on B3 A3)
	(on B8 A2)
	
  ))

 


(:metric minimize (total-time))

)

