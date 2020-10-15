(define (domain logistics-adl)
  (:requirements :adl)
  (:types physobj - object
	  obj vehicle - physobj
	  truck airplane - vehicle
	  location city - object
	  airport - location)
  (:predicates (at ?x - physobj ?l - location)
	       (in ?x - obj ?t - vehicle)
	       (in-city ?l - location ?c - city)
	       (loaded ?x - physobj))   ; ?x is loaded on a vehicle

  (:action load
	     :parameters (?obj - obj ?veh - vehicle ?loc - location)
	     :precondition (and (at ?obj ?loc)
				(at ?veh ?loc)
				(not (loaded ?obj)))
	     :effect (and (in ?obj ?veh)
			  (loaded ?obj)))
  (:action unload
	     :parameters (?obj - obj ?veh - vehicle ?loc - location)
	     :precondition (and (in ?obj ?veh) (at ?veh ?loc))
	     :effect (and (not (in ?obj ?veh))
			  (not (loaded ?obj))))
  (:action drive-truck
	   :parameters (?truck - truck ?loc-from ?loc-to - location
			?city - city)
	     :precondition (and (at ?truck ?loc-from)
				 (in-city ?loc-from ?city)
				 (in-city ?loc-to ?city))
	     :effect  (and (at ?truck ?loc-to)
			    (not (at ?truck ?loc-from))
			    (forall (?x - obj)
				     (when (and (in ?x ?truck))
					    (and (not (at ?x ?loc-from))
						  (at ?x ?loc-to))))))
  (:action fly-airplane
   :parameters (?plane - airplane ?loc-from ?loc-to - airport)
   :precondition (and (at ?plane ?loc-from) )
   :effect  (and (at ?plane ?loc-to)
		      (not (at ?plane ?loc-from))
			      (forall (?x - obj)
				       (when (and (in ?x ?plane))
					      (and (not (at ?x ?loc-from))
						    (at ?x ?loc-to)))))))
