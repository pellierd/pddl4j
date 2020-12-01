
(define (problem p11-net2-b10-g2_rt0_instance)
  (:domain pipesworld_strips)
  (:objects

    	B0 B1 B4 B6 B7 B9 B3 B8 B2 B5 - batch-atom
	A1 A2 A3 - area
	S12 S13 - pipe
	TA1-1-lco - tank-slot
	TA1-2-gasoleo TA1-1-gasoleo - tank-slot
	TA1-1-rat-a - tank-slot
	TA2-1-lco - tank-slot
	TA2-2-gasoleo TA2-1-gasoleo - tank-slot
	TA2-1-rat-a - tank-slot
	TA3-1-lco - tank-slot
	TA3-2-gasoleo TA3-1-gasoleo - tank-slot
	TA3-1-rat-a - tank-slot
	

  )
  (:init

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
	

    ;; Specify tank location
    	(tank-slot-product-location TA1-1-lco lco A1)
	(tank-slot-product-location TA1-2-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-1-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-1-rat-a rat-a A1)
	(tank-slot-product-location TA2-1-lco lco A2)
	(tank-slot-product-location TA2-2-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-1-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-1-rat-a rat-a A2)
	(tank-slot-product-location TA3-1-lco lco A3)
	(tank-slot-product-location TA3-2-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-1-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-1-rat-a rat-a A3)
	

    ;; Specify tank maximum capacity
    	

    ;; Specify tank product
    	

    ;; Batch-atoms products
    	(is-product B0 gasoleo)
	(is-product B1 rat-a)
	(is-product B4 gasoleo)
	(is-product B6 gasoleo)
	(is-product B7 gasoleo)
	(is-product B9 lco)
	(is-product B3 lco)
	(is-product B8 gasoleo)
	(is-product B2 rat-a)
	(is-product B5 gasoleo)
	

    ;; Specify tank current volume
    	

    ;; Batch-atoms initially located in areas
    	(on B0 A1)
	(occupied TA1-1-gasoleo)
	
	(on B4 A2)
	(occupied TA2-1-gasoleo)
	
	(on B3 A3)
	(occupied TA3-1-lco)
	
	(on B8 A3)
	(occupied TA3-1-gasoleo)
	
	(on B2 A3)
	(occupied TA3-1-rat-a)
	
	(on B5 A1)
	(occupied TA1-2-gasoleo)
	
	(not-occupied TA1-1-lco)
	(not-occupied TA1-1-rat-a)
	(not-occupied TA2-1-lco)
	(not-occupied TA2-2-gasoleo)
	(not-occupied TA2-1-rat-a)
	(not-occupied TA3-2-gasoleo)
	

    ;; Batch-atoms initially located in pipes
    	(first B9 S12)
	(follow B1 B9)
	(last B1 S12)
	(first B7 S13)
	(follow B6 B7)
	(last B6 S13)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)

  )
  (:goal (and
    	(on B0 A2)
	(on B9 A3)
			(normal S12)
		(normal S13)

  ))
)
