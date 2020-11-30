; Map of the Depots:        
; 000   
; *0    
;----   
; 0: depot0 area
; *: Depot access point
; =: Transit area

(define (problem storage-1)
(:domain Storage-TimeConstraints)
(:objects
	depot0-1-1 depot0-1-2 depot0-1-3 depot0-2-1 depot0-2-2 container-0-0 - storearea
	hoist0 - hoist
	crate0 - crate
	container0 - container
	depot0 - depot)

(:init
	(connected depot0-1-1 depot0-2-1)
	(connected depot0-1-1 depot0-1-2)
	(connected depot0-1-2 depot0-2-2)
	(connected depot0-1-2 depot0-1-3)
	(connected depot0-1-2 depot0-1-1)
	(connected depot0-1-3 depot0-1-2)
	(connected depot0-2-1 depot0-1-1)
	(connected depot0-2-1 depot0-2-2)
	(connected depot0-2-2 depot0-1-2)
	(connected depot0-2-2 depot0-2-1)
	(in depot0-1-1 depot0)
	(in depot0-1-2 depot0)
	(in depot0-1-3 depot0)
	(in depot0-2-1 depot0)
	(in depot0-2-2 depot0)
	(on crate0 container-0-0)
	(in crate0 container0)
	(in container-0-0 container0)
	(connected loadarea container-0-0) 
	(connected container-0-0 loadarea)  
	(connected depot0-2-1 loadarea)
	(connected loadarea depot0-2-1)  
	(clear depot0-1-1)
	(clear depot0-1-2)
	(clear depot0-1-3)
	(clear depot0-2-2)  
	(at hoist0 depot0-2-1)
	(available hoist0))

(:goal (and))

(:constraints (and
	(forall (?c - crate) (at end (exists (?d - depot) (in ?c ?d))))))

(:metric minimize (total-time))
)
