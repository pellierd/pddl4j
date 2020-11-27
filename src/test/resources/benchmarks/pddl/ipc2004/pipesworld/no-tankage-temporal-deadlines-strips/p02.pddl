
(define (problem p02-net1-b6-g4_dt0_instance)
  (:domain pipesworld_strips)
  (:objects

    	B0 B3 B1 B4 B2 B5 - batch-atom
	A1 A2 A3 - area
	S12 S13 - pipe
	

  )
  (:init

    ;; deliverable conds for all batches
      (deliverable B0)
      (deliverable B3)
      (deliverable B1)
      (deliverable B4)
      (deliverable B2)
      (deliverable B5)


    ;; deadlines for goal batches
      ;; Plan delivery time is 8.03
      (at 13.13 (not (deliverable B0)))
      ;; Plan delivery time is 12.05
      (at 23.15 (not (deliverable B4)))
      ;; Plan delivery time is 24.11
      (at 24.21 (not (deliverable B2)))
      ;; Plan delivery time is 22.1
      (at 23.2 (not (deliverable B5)))

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
    	(is-product B0 oc1b)
	(is-product B3 rat-a)
	(is-product B1 lco)
	(is-product B4 lco)
	(is-product B2 gasoleo)
	(is-product B5 oca1)
	

    ;; Batch-atoms initially located in areas
    	(on B0 A1)
	(on B3 A1)
	(on B1 A3)
	(on B2 A1)
	

    ;; Batch-atoms initially located in pipes
    	(first B4 S12)
	(last B4 S12)
	(first B5 S13)
	(last B5 S13)
	
    ;; Unitary pipeline segments
    		(unitary S12)
		(unitary S13)

  )
  (:goal (and
    	(on B0 A2)
	(on B4 A1)
	(on B2 A3)
	(on B5 A2)
	
  ))

 


(:metric minimize (total-time))

)

