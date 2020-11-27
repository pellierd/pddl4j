
(define (problem p08-net1-b12-g7_dt0_instance)
  (:domain pipesworld_strips)
  (:objects

    	B10 B0 B1 B4 B6 B7 B9 B3 B8 B2 B11 B5 - batch-atom
	A1 A2 A3 - area
	S12 S13 - pipe
	

  )
  (:init

    ;; deliverable conds for all batches
      (deliverable B10)
      (deliverable B0)
      (deliverable B1)
      (deliverable B4)
      (deliverable B6)
      (deliverable B7)
      (deliverable B9)
      (deliverable B3)
      (deliverable B8)
      (deliverable B2)
      (deliverable B11)
      (deliverable B5)


    ;; deadlines for goal batches
      ;; Plan delivery time is 14.06
      (at 14.16 (not (deliverable B1)))
      ;; Plan delivery time is 4.01
      (at 12.11 (not (deliverable B4)))
      ;; Plan delivery time is 8.03
      (at 8.13 (not (deliverable B7)))
      ;; Plan delivery time is 16.07
      (at 16.17 (not (deliverable B9)))
      ;; Plan delivery time is 6.02
      (at 13.12 (not (deliverable B3)))
      ;; Plan delivery time is 4.01
      (at 11.11 (not (deliverable B11)))
      ;; Plan delivery time is 6.02
      (at 6.12 (not (deliverable B5)))

    ;; speed of pipe segments
    	(= (speed S12) 1)
	(= (speed S13) 1)

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
    	(is-product B10 gasoleo)
	(is-product B0 lco)
	(is-product B1 oc1b)
	(is-product B4 lco)
	(is-product B6 lco)
	(is-product B7 rat-a)
	(is-product B9 lco)
	(is-product B3 gasoleo)
	(is-product B8 oc1b)
	(is-product B2 rat-a)
	(is-product B11 gasoleo)
	(is-product B5 rat-a)
	

    ;; Batch-atoms initially located in areas
    	(on B10 A1)
	(on B0 A1)
	(on B4 A2)
	(on B6 A3)
	(on B7 A3)
	(on B9 A2)
	(on B3 A3)
	(on B2 A2)
	(on B11 A3)
	(on B5 A2)
	

    ;; Batch-atoms initially located in pipes
    	(first B8 S12)
	(last B8 S12)
	(first B1 S13)
	(last B1 S13)
	
    ;; Unitary pipeline segments
    		(unitary S12)
		(unitary S13)

  )
  (:goal (and
    	(on B1 A2)
	(on B4 A1)
	(on B7 A1)
	(on B9 A1)
	(on B3 A1)
	(on B11 A1)
	(on B5 A1)
	
  ))

 


(:metric minimize (total-time))

)

