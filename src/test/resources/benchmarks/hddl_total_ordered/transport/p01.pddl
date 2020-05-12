(define (problem p01)
    (:domain transport)
    (:objects
        city-loc-0 city-loc-1 city-loc-2 - location
        truck-0 - vehicle
        package-0 package-1 - package
        capacity-0 capacity-1 - capacity_number
    )
    (:htn
        :ordered-subtasks (and
            (deliver package-0 city-loc-0)
            (deliver package-1 city-loc-2)
        )
    )
    (:init
        (capacity_predecessor capacity-0 capacity-1)
        (road city-loc-0 city-loc-1)
        (road city-loc-1 city-loc-0)
        (road city-loc-1 city-loc-2)
        (road city-loc-2 city-loc-1)
        (at package-0 city-loc-1)
        (at package-1 city-loc-1)
        (at truck-0 city-loc-2)
        (capacity truck-0 capacity-1)
    )
)
