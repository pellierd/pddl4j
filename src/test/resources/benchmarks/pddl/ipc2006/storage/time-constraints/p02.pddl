; Map of the Depots:          
; 0000    
; *00     
;-----    
; 0: depot0 area
; *: Depot access point
; =: Transit area

(define (problem storage-2)
(:domain Storage-TimeConstraints)
(:objects
	depot0-1-1 depot0-1-2 depot0-1-3 depot0-1-4 depot0-2-1 depot0-2-2 depot0-2-3 container-0-0 container-0-1 - storearea
	hoist0 - hoist
	crate0 crate1 - crate
	container0 - container
	depot0 - depot)

(:init
	(connected depot0-1-1 depot0-2-1)
	(connected depot0-1-1 depot0-1-2)
	(connected depot0-1-2 depot0-2-2)
	(connected depot0-1-2 depot0-1-3)
	(connected depot0-1-2 depot0-1-1)
	(connected depot0-1-3 depot0-2-3)
	(connected depot0-1-3 depot0-1-4)
	(connected depot0-1-3 depot0-1-2)
	(connected depot0-1-4 depot0-1-3)
	(connected depot0-2-1 depot0-1-1)
	(connected depot0-2-1 depot0-2-2)
	(connected depot0-2-2 depot0-1-2)
	(connected depot0-2-2 depot0-2-3)
	(connected depot0-2-2 depot0-2-1)
	(connected depot0-2-3 depot0-1-3)
	(connected depot0-2-3 depot0-2-2)
	(in depot0-1-1 depot0)
	(in depot0-1-2 depot0)
	(in depot0-1-3 depot0)
	(in depot0-1-4 depot0)
	(in depot0-2-1 depot0)
	(in depot0-2-2 depot0)
	(in depot0-2-3 depot0)
	(on crate0 container-0-0)
	(on crate1 container-0-1)
	(in crate0 container0)
	(in crate1 container0)
	(in container-0-0 container0)
	(in container-0-1 container0)
	(connected loadarea container-0-0) 
	(connected container-0-0 loadarea)
	(connected loadarea container-0-1) 
	(connected container-0-1 loadarea)  
	(connected depot0-2-1 loadarea)
	(connected loadarea depot0-2-1)  
	(clear depot0-2-3)
	(clear depot0-1-2)
	(clear depot0-1-3)
	(clear depot0-1-4)
	(clear depot0-2-1)
	(clear depot0-2-2)  
	(at hoist0 depot0-1-1)
	(available hoist0)
	(compatible crate0 crate1)
	(compatible crate1 crate0))

(:goal (and))

(:constraints (and
	(forall (?c - crate) (at end (exists (?d - depot) (in ?c ?d))))))

(:metric minimize (total-time))
)
