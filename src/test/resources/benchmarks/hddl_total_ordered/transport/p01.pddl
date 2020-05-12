(define (problem p)
 (:domain transport)
 (:objects
  city-loc-0 city-loc-1 city-loc-2 - location
  truck-0 - vehicle
  ;;package-0
  package-1 - package
  capacity-0 capacity-1 - capacity-number
 )
 (:htn
  :ordered-subtasks (and
;;   (deliver package-0 city-loc-0)
   (deliver package-1 city-loc-2)
   )
 )
 (:init
;;  (capacity-predecessor capacity-0 capacity-1)
;;  (road city-loc-0 city-loc-1)
;;  (road city-loc-1 city-loc-0)
;;  (road city-loc-1 city-loc-2)
;;  (road city-loc-2 city-loc-1)
;;  (at package-0 city-loc-1)
;;  (at package-1 city-loc-1)
;;  (at truck-0 city-loc-2)
;;  (capacity truck-0 capacity-1)

  (capacity-predecessor capacity-0 capacity-1)
  (road city-loc-0 city-loc-1)
  (road city-loc-1 city-loc-0)
  (road city-loc-1 city-loc-2)
  (road city-loc-2 city-loc-1)
;;  (at package-0 city-loc-1)
;;  (at package-1 city-loc-1)
;;  (at truck-0 city-loc-2)
;;  (capacity truck-0 capacity-1)

    (at truck-0 city-loc-1)
;;    (at package-0 city-loc-0)
    (capacity truck-0 capacity-1)
    (at package-1 city-loc-1)
;;    (not  (at truck-0 city-loc-1))
;;    (not  (at truck-0 city-loc-2))
;;    (not  (in package-0 truck-0))
;;    (not  (capacity truck-0 capacity-0))
;;   (not  (at package-0 city-loc-1))
 )
)
