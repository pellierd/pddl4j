
(define (problem p28-net3-b18-g7-t70)
  (:domain pipesworld_strips)
  (:objects

    	B10 B17 B14 B4 B6 B15 B13 B8 B2 B11 B5 B0 B1 B7 B12 B9 B3 B16 - batch-atom
	A1 A2 A3 A4 - area
	S12 S13 S34 - pipe
	TA1-1-lco - tank-slot
	TA1-3-gasoleo TA1-2-gasoleo TA1-1-gasoleo - tank-slot
	TA1-1-rat-a - tank-slot
	TA1-4-oca1 TA1-3-oca1 TA1-2-oca1 TA1-1-oca1 - tank-slot
	TA1-3-oc1b TA1-2-oc1b TA1-1-oc1b - tank-slot
	TA2-1-lco - tank-slot
	TA2-3-gasoleo TA2-2-gasoleo TA2-1-gasoleo - tank-slot
	TA2-1-rat-a - tank-slot
	TA2-4-oca1 TA2-3-oca1 TA2-2-oca1 TA2-1-oca1 - tank-slot
	TA2-3-oc1b TA2-2-oc1b TA2-1-oc1b - tank-slot
	TA3-1-lco - tank-slot
	TA3-3-gasoleo TA3-2-gasoleo TA3-1-gasoleo - tank-slot
	TA3-1-rat-a - tank-slot
	TA3-4-oca1 TA3-3-oca1 TA3-2-oca1 TA3-1-oca1 - tank-slot
	TA3-3-oc1b TA3-2-oc1b TA3-1-oc1b - tank-slot
	TA4-1-lco - tank-slot
	TA4-3-gasoleo TA4-2-gasoleo TA4-1-gasoleo - tank-slot
	TA4-1-rat-a - tank-slot
	TA4-4-oca1 TA4-3-oca1 TA4-2-oca1 TA4-1-oca1 - tank-slot
	TA4-3-oc1b TA4-2-oc1b TA4-1-oc1b - tank-slot
	

  )
  (:init

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
	

    ;; Specify tank location
    	(tank-slot-product-location TA1-1-lco lco A1)
	(tank-slot-product-location TA1-3-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-2-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-1-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-1-rat-a rat-a A1)
	(tank-slot-product-location TA1-4-oca1 oca1 A1)
	(tank-slot-product-location TA1-3-oca1 oca1 A1)
	(tank-slot-product-location TA1-2-oca1 oca1 A1)
	(tank-slot-product-location TA1-1-oca1 oca1 A1)
	(tank-slot-product-location TA1-3-oc1b oc1b A1)
	(tank-slot-product-location TA1-2-oc1b oc1b A1)
	(tank-slot-product-location TA1-1-oc1b oc1b A1)
	(tank-slot-product-location TA2-1-lco lco A2)
	(tank-slot-product-location TA2-3-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-2-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-1-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-1-rat-a rat-a A2)
	(tank-slot-product-location TA2-4-oca1 oca1 A2)
	(tank-slot-product-location TA2-3-oca1 oca1 A2)
	(tank-slot-product-location TA2-2-oca1 oca1 A2)
	(tank-slot-product-location TA2-1-oca1 oca1 A2)
	(tank-slot-product-location TA2-3-oc1b oc1b A2)
	(tank-slot-product-location TA2-2-oc1b oc1b A2)
	(tank-slot-product-location TA2-1-oc1b oc1b A2)
	(tank-slot-product-location TA3-1-lco lco A3)
	(tank-slot-product-location TA3-3-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-2-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-1-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-1-rat-a rat-a A3)
	(tank-slot-product-location TA3-4-oca1 oca1 A3)
	(tank-slot-product-location TA3-3-oca1 oca1 A3)
	(tank-slot-product-location TA3-2-oca1 oca1 A3)
	(tank-slot-product-location TA3-1-oca1 oca1 A3)
	(tank-slot-product-location TA3-3-oc1b oc1b A3)
	(tank-slot-product-location TA3-2-oc1b oc1b A3)
	(tank-slot-product-location TA3-1-oc1b oc1b A3)
	(tank-slot-product-location TA4-1-lco lco A4)
	(tank-slot-product-location TA4-3-gasoleo gasoleo A4)
	(tank-slot-product-location TA4-2-gasoleo gasoleo A4)
	(tank-slot-product-location TA4-1-gasoleo gasoleo A4)
	(tank-slot-product-location TA4-1-rat-a rat-a A4)
	(tank-slot-product-location TA4-4-oca1 oca1 A4)
	(tank-slot-product-location TA4-3-oca1 oca1 A4)
	(tank-slot-product-location TA4-2-oca1 oca1 A4)
	(tank-slot-product-location TA4-1-oca1 oca1 A4)
	(tank-slot-product-location TA4-3-oc1b oc1b A4)
	(tank-slot-product-location TA4-2-oc1b oc1b A4)
	(tank-slot-product-location TA4-1-oc1b oc1b A4)
	

    ;; Specify tank maximum capacity
    	

    ;; Specify tank product
    	

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
	

    ;; Specify tank current volume
    	

    ;; Batch-atoms initially located in areas
    	(on B14 A2)
	(occupied TA2-1-gasoleo)
	
	(on B4 A3)
	(occupied TA3-1-oc1b)
	
	(on B13 A1)
	(occupied TA1-1-oca1)
	
	(on B8 A4)
	(occupied TA4-1-oca1)
	
	(on B2 A4)
	(occupied TA4-1-gasoleo)
	
	(on B11 A4)
	(occupied TA4-2-oca1)
	
	(on B5 A3)
	(occupied TA3-1-lco)
	
	(on B1 A1)
	(occupied TA1-1-oc1b)
	
	(on B7 A1)
	(occupied TA1-2-oca1)
	
	(on B12 A1)
	(occupied TA1-3-oca1)
	
	(on B9 A1)
	(occupied TA1-1-rat-a)
	
	(on B3 A1)
	(occupied TA1-2-oc1b)
	
	(on B16 A3)
	(occupied TA3-1-rat-a)
	
	(not-occupied TA1-1-lco)
	(not-occupied TA1-1-gasoleo)
	(not-occupied TA1-2-gasoleo)
	(not-occupied TA1-3-gasoleo)
	(not-occupied TA1-4-oca1)
	(not-occupied TA1-3-oc1b)
	(not-occupied TA2-1-lco)
	(not-occupied TA2-2-gasoleo)
	(not-occupied TA2-3-gasoleo)
	(not-occupied TA2-1-rat-a)
	(not-occupied TA2-1-oca1)
	(not-occupied TA2-2-oca1)
	(not-occupied TA2-3-oca1)
	(not-occupied TA2-4-oca1)
	(not-occupied TA2-1-oc1b)
	(not-occupied TA2-2-oc1b)
	(not-occupied TA2-3-oc1b)
	(not-occupied TA3-1-gasoleo)
	(not-occupied TA3-2-gasoleo)
	(not-occupied TA3-3-gasoleo)
	(not-occupied TA3-1-oca1)
	(not-occupied TA3-2-oca1)
	(not-occupied TA3-3-oca1)
	(not-occupied TA3-4-oca1)
	(not-occupied TA3-2-oc1b)
	(not-occupied TA3-3-oc1b)
	(not-occupied TA4-1-lco)
	(not-occupied TA4-2-gasoleo)
	(not-occupied TA4-3-gasoleo)
	(not-occupied TA4-1-rat-a)
	(not-occupied TA4-3-oca1)
	(not-occupied TA4-4-oca1)
	(not-occupied TA4-1-oc1b)
	(not-occupied TA4-2-oc1b)
	(not-occupied TA4-3-oc1b)
	

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
    	(on B17 A1)
	(on B4 A2)
	(on B6 A2)
	(on B11 A3)
	(on B1 A2)
	(on B9 A4)
	(on B3 A3)
			(normal S12)
		(normal S13)
		(normal S34)

  ))


(:metric minimize (total-time))

)

