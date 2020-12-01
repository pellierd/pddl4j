
(define (problem p44-net5-b24-g5_rt0_instance)
  (:domain pipesworld_strips)
  (:objects

    	B10 B21 B17 B14 B22 B4 B6 B15 B19 B20 B13 B8 B2 B11 B5 B0 B1 B18 B7 B12 B9 B3 B23 B16 - batch-atom
	A1 A2 A3 A4 A5 - area
	S12 S13 S34 S23 S15 - pipe
	TA1-1-lco - tank-slot
	TA1-7-gasoleo TA1-6-gasoleo TA1-5-gasoleo TA1-4-gasoleo TA1-3-gasoleo TA1-2-gasoleo TA1-1-gasoleo - tank-slot
	TA1-2-rat-a TA1-1-rat-a - tank-slot
	TA1-3-oca1 TA1-2-oca1 TA1-1-oca1 - tank-slot
	TA1-6-oc1b TA1-5-oc1b TA1-4-oc1b TA1-3-oc1b TA1-2-oc1b TA1-1-oc1b - tank-slot
	TA2-1-lco - tank-slot
	TA2-7-gasoleo TA2-6-gasoleo TA2-5-gasoleo TA2-4-gasoleo TA2-3-gasoleo TA2-2-gasoleo TA2-1-gasoleo - tank-slot
	TA2-2-rat-a TA2-1-rat-a - tank-slot
	TA2-3-oca1 TA2-2-oca1 TA2-1-oca1 - tank-slot
	TA2-6-oc1b TA2-5-oc1b TA2-4-oc1b TA2-3-oc1b TA2-2-oc1b TA2-1-oc1b - tank-slot
	TA3-1-lco - tank-slot
	TA3-7-gasoleo TA3-6-gasoleo TA3-5-gasoleo TA3-4-gasoleo TA3-3-gasoleo TA3-2-gasoleo TA3-1-gasoleo - tank-slot
	TA3-2-rat-a TA3-1-rat-a - tank-slot
	TA3-3-oca1 TA3-2-oca1 TA3-1-oca1 - tank-slot
	TA3-6-oc1b TA3-5-oc1b TA3-4-oc1b TA3-3-oc1b TA3-2-oc1b TA3-1-oc1b - tank-slot
	TA4-1-lco - tank-slot
	TA4-7-gasoleo TA4-6-gasoleo TA4-5-gasoleo TA4-4-gasoleo TA4-3-gasoleo TA4-2-gasoleo TA4-1-gasoleo - tank-slot
	TA4-2-rat-a TA4-1-rat-a - tank-slot
	TA4-3-oca1 TA4-2-oca1 TA4-1-oca1 - tank-slot
	TA4-6-oc1b TA4-5-oc1b TA4-4-oc1b TA4-3-oc1b TA4-2-oc1b TA4-1-oc1b - tank-slot
	TA5-1-lco - tank-slot
	TA5-7-gasoleo TA5-6-gasoleo TA5-5-gasoleo TA5-4-gasoleo TA5-3-gasoleo TA5-2-gasoleo TA5-1-gasoleo - tank-slot
	TA5-2-rat-a TA5-1-rat-a - tank-slot
	TA5-3-oca1 TA5-2-oca1 TA5-1-oca1 - tank-slot
	TA5-6-oc1b TA5-5-oc1b TA5-4-oc1b TA5-3-oc1b TA5-2-oc1b TA5-1-oc1b - tank-slot
	

  )
  (:init

    ;; All pipelines segments are in normal state
    		(normal S12)
		(normal S13)
		(normal S34)
		(normal S23)
		(normal S15)

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
	(connect A2 A3 S23)
	(connect A1 A5 S15)
	

    ;; Specify tank location
    	(tank-slot-product-location TA1-1-lco lco A1)
	(tank-slot-product-location TA1-7-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-6-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-5-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-4-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-3-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-2-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-1-gasoleo gasoleo A1)
	(tank-slot-product-location TA1-2-rat-a rat-a A1)
	(tank-slot-product-location TA1-1-rat-a rat-a A1)
	(tank-slot-product-location TA1-3-oca1 oca1 A1)
	(tank-slot-product-location TA1-2-oca1 oca1 A1)
	(tank-slot-product-location TA1-1-oca1 oca1 A1)
	(tank-slot-product-location TA1-6-oc1b oc1b A1)
	(tank-slot-product-location TA1-5-oc1b oc1b A1)
	(tank-slot-product-location TA1-4-oc1b oc1b A1)
	(tank-slot-product-location TA1-3-oc1b oc1b A1)
	(tank-slot-product-location TA1-2-oc1b oc1b A1)
	(tank-slot-product-location TA1-1-oc1b oc1b A1)
	(tank-slot-product-location TA2-1-lco lco A2)
	(tank-slot-product-location TA2-7-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-6-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-5-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-4-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-3-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-2-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-1-gasoleo gasoleo A2)
	(tank-slot-product-location TA2-2-rat-a rat-a A2)
	(tank-slot-product-location TA2-1-rat-a rat-a A2)
	(tank-slot-product-location TA2-3-oca1 oca1 A2)
	(tank-slot-product-location TA2-2-oca1 oca1 A2)
	(tank-slot-product-location TA2-1-oca1 oca1 A2)
	(tank-slot-product-location TA2-6-oc1b oc1b A2)
	(tank-slot-product-location TA2-5-oc1b oc1b A2)
	(tank-slot-product-location TA2-4-oc1b oc1b A2)
	(tank-slot-product-location TA2-3-oc1b oc1b A2)
	(tank-slot-product-location TA2-2-oc1b oc1b A2)
	(tank-slot-product-location TA2-1-oc1b oc1b A2)
	(tank-slot-product-location TA3-1-lco lco A3)
	(tank-slot-product-location TA3-7-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-6-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-5-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-4-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-3-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-2-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-1-gasoleo gasoleo A3)
	(tank-slot-product-location TA3-2-rat-a rat-a A3)
	(tank-slot-product-location TA3-1-rat-a rat-a A3)
	(tank-slot-product-location TA3-3-oca1 oca1 A3)
	(tank-slot-product-location TA3-2-oca1 oca1 A3)
	(tank-slot-product-location TA3-1-oca1 oca1 A3)
	(tank-slot-product-location TA3-6-oc1b oc1b A3)
	(tank-slot-product-location TA3-5-oc1b oc1b A3)
	(tank-slot-product-location TA3-4-oc1b oc1b A3)
	(tank-slot-product-location TA3-3-oc1b oc1b A3)
	(tank-slot-product-location TA3-2-oc1b oc1b A3)
	(tank-slot-product-location TA3-1-oc1b oc1b A3)
	(tank-slot-product-location TA4-1-lco lco A4)
	(tank-slot-product-location TA4-7-gasoleo gasoleo A4)
	(tank-slot-product-location TA4-6-gasoleo gasoleo A4)
	(tank-slot-product-location TA4-5-gasoleo gasoleo A4)
	(tank-slot-product-location TA4-4-gasoleo gasoleo A4)
	(tank-slot-product-location TA4-3-gasoleo gasoleo A4)
	(tank-slot-product-location TA4-2-gasoleo gasoleo A4)
	(tank-slot-product-location TA4-1-gasoleo gasoleo A4)
	(tank-slot-product-location TA4-2-rat-a rat-a A4)
	(tank-slot-product-location TA4-1-rat-a rat-a A4)
	(tank-slot-product-location TA4-3-oca1 oca1 A4)
	(tank-slot-product-location TA4-2-oca1 oca1 A4)
	(tank-slot-product-location TA4-1-oca1 oca1 A4)
	(tank-slot-product-location TA4-6-oc1b oc1b A4)
	(tank-slot-product-location TA4-5-oc1b oc1b A4)
	(tank-slot-product-location TA4-4-oc1b oc1b A4)
	(tank-slot-product-location TA4-3-oc1b oc1b A4)
	(tank-slot-product-location TA4-2-oc1b oc1b A4)
	(tank-slot-product-location TA4-1-oc1b oc1b A4)
	(tank-slot-product-location TA5-1-lco lco A5)
	(tank-slot-product-location TA5-7-gasoleo gasoleo A5)
	(tank-slot-product-location TA5-6-gasoleo gasoleo A5)
	(tank-slot-product-location TA5-5-gasoleo gasoleo A5)
	(tank-slot-product-location TA5-4-gasoleo gasoleo A5)
	(tank-slot-product-location TA5-3-gasoleo gasoleo A5)
	(tank-slot-product-location TA5-2-gasoleo gasoleo A5)
	(tank-slot-product-location TA5-1-gasoleo gasoleo A5)
	(tank-slot-product-location TA5-2-rat-a rat-a A5)
	(tank-slot-product-location TA5-1-rat-a rat-a A5)
	(tank-slot-product-location TA5-3-oca1 oca1 A5)
	(tank-slot-product-location TA5-2-oca1 oca1 A5)
	(tank-slot-product-location TA5-1-oca1 oca1 A5)
	(tank-slot-product-location TA5-6-oc1b oc1b A5)
	(tank-slot-product-location TA5-5-oc1b oc1b A5)
	(tank-slot-product-location TA5-4-oc1b oc1b A5)
	(tank-slot-product-location TA5-3-oc1b oc1b A5)
	(tank-slot-product-location TA5-2-oc1b oc1b A5)
	(tank-slot-product-location TA5-1-oc1b oc1b A5)
	

    ;; Specify tank maximum capacity
    	

    ;; Specify tank product
    	

    ;; Batch-atoms products
    	(is-product B10 oc1b)
	(is-product B21 oca1)
	(is-product B17 rat-a)
	(is-product B14 gasoleo)
	(is-product B22 oc1b)
	(is-product B4 rat-a)
	(is-product B6 oc1b)
	(is-product B15 oca1)
	(is-product B19 gasoleo)
	(is-product B20 oca1)
	(is-product B13 lco)
	(is-product B8 oc1b)
	(is-product B2 gasoleo)
	(is-product B11 gasoleo)
	(is-product B5 gasoleo)
	(is-product B0 gasoleo)
	(is-product B1 gasoleo)
	(is-product B18 oca1)
	(is-product B7 gasoleo)
	(is-product B12 rat-a)
	(is-product B9 oc1b)
	(is-product B3 oc1b)
	(is-product B23 oc1b)
	(is-product B16 gasoleo)
	

    ;; Specify tank current volume
    	

    ;; Batch-atoms initially located in areas
    	(on B17 A3)
	(occupied TA3-1-rat-a)
	
	(on B15 A3)
	(occupied TA3-1-oca1)
	
	(on B19 A3)
	(occupied TA3-1-gasoleo)
	
	(on B20 A1)
	(occupied TA1-1-oca1)
	
	(on B13 A1)
	(occupied TA1-1-lco)
	
	(on B2 A5)
	(occupied TA5-1-gasoleo)
	
	(on B11 A5)
	(occupied TA5-2-gasoleo)
	
	(on B5 A2)
	(occupied TA2-1-gasoleo)
	
	(on B0 A4)
	(occupied TA4-1-gasoleo)
	
	(on B18 A2)
	(occupied TA2-1-oca1)
	
	(on B7 A3)
	(occupied TA3-2-gasoleo)
	
	(on B23 A2)
	(occupied TA2-1-oc1b)
	
	(not-occupied TA1-1-gasoleo)
	(not-occupied TA1-2-gasoleo)
	(not-occupied TA1-3-gasoleo)
	(not-occupied TA1-4-gasoleo)
	(not-occupied TA1-5-gasoleo)
	(not-occupied TA1-6-gasoleo)
	(not-occupied TA1-7-gasoleo)
	(not-occupied TA1-1-rat-a)
	(not-occupied TA1-2-rat-a)
	(not-occupied TA1-2-oca1)
	(not-occupied TA1-3-oca1)
	(not-occupied TA1-1-oc1b)
	(not-occupied TA1-2-oc1b)
	(not-occupied TA1-3-oc1b)
	(not-occupied TA1-4-oc1b)
	(not-occupied TA1-5-oc1b)
	(not-occupied TA1-6-oc1b)
	(not-occupied TA2-1-lco)
	(not-occupied TA2-2-gasoleo)
	(not-occupied TA2-3-gasoleo)
	(not-occupied TA2-4-gasoleo)
	(not-occupied TA2-5-gasoleo)
	(not-occupied TA2-6-gasoleo)
	(not-occupied TA2-7-gasoleo)
	(not-occupied TA2-1-rat-a)
	(not-occupied TA2-2-rat-a)
	(not-occupied TA2-2-oca1)
	(not-occupied TA2-3-oca1)
	(not-occupied TA2-2-oc1b)
	(not-occupied TA2-3-oc1b)
	(not-occupied TA2-4-oc1b)
	(not-occupied TA2-5-oc1b)
	(not-occupied TA2-6-oc1b)
	(not-occupied TA3-1-lco)
	(not-occupied TA3-3-gasoleo)
	(not-occupied TA3-4-gasoleo)
	(not-occupied TA3-5-gasoleo)
	(not-occupied TA3-6-gasoleo)
	(not-occupied TA3-7-gasoleo)
	(not-occupied TA3-2-rat-a)
	(not-occupied TA3-2-oca1)
	(not-occupied TA3-3-oca1)
	(not-occupied TA3-1-oc1b)
	(not-occupied TA3-2-oc1b)
	(not-occupied TA3-3-oc1b)
	(not-occupied TA3-4-oc1b)
	(not-occupied TA3-5-oc1b)
	(not-occupied TA3-6-oc1b)
	(not-occupied TA4-1-lco)
	(not-occupied TA4-2-gasoleo)
	(not-occupied TA4-3-gasoleo)
	(not-occupied TA4-4-gasoleo)
	(not-occupied TA4-5-gasoleo)
	(not-occupied TA4-6-gasoleo)
	(not-occupied TA4-7-gasoleo)
	(not-occupied TA4-1-rat-a)
	(not-occupied TA4-2-rat-a)
	(not-occupied TA4-1-oca1)
	(not-occupied TA4-2-oca1)
	(not-occupied TA4-3-oca1)
	(not-occupied TA4-1-oc1b)
	(not-occupied TA4-2-oc1b)
	(not-occupied TA4-3-oc1b)
	(not-occupied TA4-4-oc1b)
	(not-occupied TA4-5-oc1b)
	(not-occupied TA4-6-oc1b)
	(not-occupied TA5-1-lco)
	(not-occupied TA5-3-gasoleo)
	(not-occupied TA5-4-gasoleo)
	(not-occupied TA5-5-gasoleo)
	(not-occupied TA5-6-gasoleo)
	(not-occupied TA5-7-gasoleo)
	(not-occupied TA5-1-rat-a)
	(not-occupied TA5-2-rat-a)
	(not-occupied TA5-1-oca1)
	(not-occupied TA5-2-oca1)
	(not-occupied TA5-3-oca1)
	(not-occupied TA5-1-oc1b)
	(not-occupied TA5-2-oc1b)
	(not-occupied TA5-3-oc1b)
	(not-occupied TA5-4-oc1b)
	(not-occupied TA5-5-oc1b)
	(not-occupied TA5-6-oc1b)
	

    ;; Batch-atoms initially located in pipes
    	(first B8 S12)
	(follow B16 B8)
	(last B16 S12)
	(first B4 S13)
	(follow B12 B4)
	(last B12 S13)
	(first B21 S34)
	(last B21 S34)
	(first B10 S23)
	(follow B22 B10)
	(follow B9 B22)
	(last B9 S23)
	(first B1 S15)
	(follow B3 B1)
	(follow B14 B3)
	(follow B6 B14)
	(last B6 S15)
	
    ;; Unitary pipeline segments
    		(not-unitary S12)
		(not-unitary S13)
		(unitary S34)
		(not-unitary S23)
		(not-unitary S15)

  )
  (:goal (and
    	(on B22 A2)
	(on B13 A4)
	(on B8 A2)
	(on B11 A4)
	(on B3 A2)
			(normal S12)
		(normal S13)
		(normal S34)
		(normal S23)
		(normal S15)

  ))
)
