
(define (problem p10-net1-b14-g8_dt0_instance)
  (:domain pipesworld_strips)
  (:objects

    	B10 B0 B1 B4 B6 B7 B12 B9 B3 B13 B8 B2 B11 B5 - batch-atom
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
      (deliverable B12)
      (deliverable B9)
      (deliverable B3)
      (deliverable B13)
      (deliverable B8)
      (deliverable B2)
      (deliverable B11)
      (deliverable B5)


    ;; deadlines for goal batches
      ;; Plan delivery time is 8.03
      (at 19.13 (not (deliverable B10)))
      ;; Plan delivery time is 16.07
      (at 16.17 (not (deliverable B0)))
      ;; Plan delivery time is 6.02
      (at 13.12 (not (deliverable B4)))
      ;; Plan delivery time is 10.04
      (at 17.14 (not (deliverable B6)))
      ;; Plan delivery time is 18.08
      (at 18.18 (not (deliverable B12)))
      ;; Plan delivery time is 24.11
      (at 24.21 (not (deliverable B9)))
      ;; Plan delivery time is 20.09
      (at 22.19 (not (deliverable B8)))
      ;; Plan delivery time is 8.03
      (at 18.13 (not (deliverable B5)))

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
    	(is-product B10 oca1)
	(is-product B0 lco)
	(is-product B1 lco)
	(is-product B4 lco)
	(is-product B6 lco)
	(is-product B7 oca1)
	(is-product B12 rat-a)
	(is-product B9 rat-a)
	(is-product B3 lco)
	(is-product B13 rat-a)
	(is-product B8 rat-a)
	(is-product B2 gasoleo)
	(is-product B11 gasoleo)
	(is-product B5 oca1)
	

    ;; Batch-atoms initially located in areas
    	(on B10 A2)
	(on B0 A1)
	(on B1 A2)
	(on B4 A2)
	(on B6 A2)
	(on B12 A3)
	(on B9 A2)
	(on B3 A3)
	(on B13 A2)
	(on B8 A3)
	(on B11 A2)
	(on B5 A2)
	

    ;; Batch-atoms initially located in pipes
    	(first B2 S12)
	(last B2 S12)
	(first B7 S13)
	(last B7 S13)
	
    ;; Unitary pipeline segments
    		(unitary S12)
		(unitary S13)

  )
  (:goal (and
    	(on B10 A3)
	(on B0 A2)
	(on B4 A1)
	(on B6 A1)
	(on B12 A2)
	(on B9 A3)
	(on B8 A2)
	(on B5 A1)
	
  ))

 


(:metric minimize (total-time))

)

