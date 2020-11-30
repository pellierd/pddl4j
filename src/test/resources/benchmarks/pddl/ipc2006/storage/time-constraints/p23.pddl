; Map of the Depots:              
; 000=111     
; 0 * 1*      
;--------     
; 0: depot0 area
; 1: depot1 area
; *: Depot access point
; =: Transit area

(define (problem storage-3)
(:domain Storage-TimeConstraints)
(:objects
	depot0-1-1 depot0-1-2 depot0-1-3 depot0-2-1 depot0-2-3 depot1-1-1 depot1-1-2 depot1-1-3 depot1-2-1 depot1-2-2 container-0-0 container-0-1 container-0-2 - storearea
	hoist0 hoist1 - hoist
	crate0 crate1 crate2 - crate
	container0 - container
	depot0 depot1 - depot
	transit0 - transitarea)

(:init
	(connected depot0-1-1 depot0-2-1)
	(connected depot0-1-1 depot0-1-2)
	(connected depot0-1-2 depot0-1-3)
	(connected depot0-1-2 depot0-1-1)
	(connected depot0-1-3 depot0-2-3)
	(connected depot0-1-3 depot0-1-2)
	(connected depot0-2-1 depot0-1-1)
	(connected depot0-2-3 depot0-1-3)
	(connected depot1-1-1 depot1-2-1)
	(connected depot1-1-1 depot1-1-2)
	(connected depot1-1-2 depot1-2-2)
	(connected depot1-1-2 depot1-1-3)
	(connected depot1-1-2 depot1-1-1)
	(connected depot1-1-3 depot1-1-2)
	(connected depot1-2-1 depot1-1-1)
	(connected depot1-2-1 depot1-2-2)
	(connected depot1-2-2 depot1-1-2)
	(connected depot1-2-2 depot1-2-1)
	(connected transit0 depot0-1-3)
	(connected transit0 depot1-1-1)
	(in depot0-1-1 depot0)
	(in depot0-1-2 depot0)
	(in depot0-1-3 depot0)
	(in depot0-2-1 depot0)
	(in depot0-2-3 depot0)
	(in depot1-1-1 depot1)
	(in depot1-1-2 depot1)
	(in depot1-1-3 depot1)
	(in depot1-2-1 depot1)
	(in depot1-2-2 depot1)
	(on crate0 container-0-0)
	(on crate1 container-0-1)
	(on crate2 container-0-2)
	(in crate0 container0)
	(in crate1 container0)
	(in crate2 container0)
	(in container-0-0 container0)
	(in container-0-1 container0)
	(in container-0-2 container0)
	(connected loadarea container-0-0) 
	(connected container-0-0 loadarea)
	(connected loadarea container-0-1) 
	(connected container-0-1 loadarea)
	(connected loadarea container-0-2) 
	(connected container-0-2 loadarea)  
	(connected depot0-2-3 loadarea)
	(connected loadarea depot0-2-3)
	(connected depot1-2-2 loadarea)
	(connected loadarea depot1-2-2)  
	(clear depot0-1-1)
	(clear depot0-1-2)
	(clear depot0-1-3)
	(clear depot0-2-1)
	(clear depot1-2-2)
	(clear depot1-1-2)
	(clear depot1-1-3)
	(clear depot1-2-1)  
	(at hoist0 depot0-2-3)
	(available hoist0)
	(at hoist1 depot1-1-1)
	(available hoist1)
	(compatible crate0 crate1)
	(compatible crate1 crate0)
	(compatible crate0 crate2)
	(compatible crate2 crate0)
	(compatible crate1 crate2)
	(compatible crate2 crate1))

(:goal (and))

(:constraints (and
	(forall (?c - crate) (at end (exists (?d - depot) (in ?c ?d))))

	(forall (?c - crate) (at-most-once (exists (?h - hoist) (lifting ?h ?c))))

	(sometime-before (exists (?d1 - depot) (in crate0 ?d1))
			 (exists (?d2 - depot) (in crate1 ?d2)))
	(sometime-before (exists (?d1 - depot) (in crate0 ?d1))
			 (exists (?d2 - depot) (in crate2 ?d2)))

	(forall (?c - crate) (within 42 (exists (?d - depot) (in ?c ?d))))

	(forall (?h - hoist) (always-within 3.5 (at ?h loadarea)
					 (exists (?a - storearea ?d - depot) (and (at ?h ?a) (in ?a ?d)))))))

(:metric minimize (total-time))
)
