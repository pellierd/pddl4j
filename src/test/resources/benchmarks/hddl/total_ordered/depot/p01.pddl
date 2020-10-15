;;
;; Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
;;
;; This file is part of PDDL4J library.
;;
;; PDDL4J is free software: you can redistribute it and/or modify
;; it under the terms of the GNU General Public License as published by
;; the Free Software Foundation, either version 3 of the License, or
;; (at your option) any later version.
;;
;; PDDL4J is distributed in the hope that it will be useful,
;; but WITHOUT ANY WARRANTY; without even the implied warranty of
;; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
;; GNU General Public License for more details.
;;
;; You should have received a copy of the GNU General Public License
;; along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
;;

(define (problem p01 )

    (:domain depot )

    (:objects
        depot0 - Depot
        distributor0 distributor1 - Distributor
        truck0 truck1 - Truck
        pallet0 pallet1 pallet2 - Pallet
        crate0 crate1 - Crate
        hoist0 hoist1 hoist2 - Hoist
    )

    (:htn
    	:ordered-subtasks (and
    	    (do_put_on crate1 pallet1)
;;    		(do_put_on crate0 pallet2)
        )
    )

    (:init
        (at pallet0 depot0 )
        (clear crate1 )
        (at pallet1 distributor0 )
        (clear crate0 )
        (at pallet2 distributor1 )
        (clear pallet2 )
        (at truck0 distributor1 )
        (at truck1 depot0 )
        (at hoist0 depot0 )
        (available hoist0 )
        (at hoist1 distributor0 )
        (available hoist1 )
        (at hoist2 distributor1 )
        (available hoist2 )
        (at crate0 distributor0 )
        (on crate0 pallet1 )
        (at crate1 depot0 )
        (on crate1 pallet0 )
    )
)
