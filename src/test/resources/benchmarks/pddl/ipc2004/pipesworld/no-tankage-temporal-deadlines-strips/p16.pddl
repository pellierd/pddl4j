
(define (problem p16-net2-b14-g6_dt0_instance)
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
      ;; Plan delivery time is 22.09
      (at 22.19 (not (deliverable B1)))
      ;; Plan delivery time is 23.1
      (at 24.2 (not (deliverable B7)))
      ;; Plan delivery time is 18.08
      (at 21.18 (not (deliverable B12)))
      ;; Plan delivery time is 17.07
      (at 20.17 (not (deliverable B3)))
      ;; Plan delivery time is 8.03
      (at 16.13 (not (deliverable B8)))
      ;; Plan delivery time is 25.11
      (at 25.21 (not (deliverable B2)))

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
    	(on B1 A3)
	(on B7 A1)
	(on B12 A1)
	(on B3 A3)
	(on B8 A2)
	(on B2 A2)
	
  ))

 


(:metric minimize (total-time))

)

