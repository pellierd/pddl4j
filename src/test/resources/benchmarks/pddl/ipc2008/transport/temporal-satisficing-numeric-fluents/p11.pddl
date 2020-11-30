; Transport p11-20-two-cities-3nodes-700size-2degree-70mindistance-2trucks-2packages-2008seed

(define (problem transport-p11-20-two-cities-3nodes-700size-2degree-70mindistance-2trucks-2packages-2008seed)
 (:domain transport)
 (:objects
  city-1-loc-1 - location
  city-2-loc-1 - location
  city-1-loc-2 - location
  city-2-loc-2 - location
  city-1-loc-3 - location
  city-2-loc-3 - location
  truck-1 - vehicle
  truck-2 - vehicle
  package-1 - package
  package-2 - package
 )
 (:init
  ; 523,269 -> 623,380
  (road city-1-loc-3 city-1-loc-1)
  (= (road-length city-1-loc-3 city-1-loc-1) 15)
  (= (fuel-demand city-1-loc-3 city-1-loc-1) 30)
  ; 623,380 -> 523,269
  (road city-1-loc-1 city-1-loc-3)
  (= (road-length city-1-loc-1 city-1-loc-3) 15)
  (= (fuel-demand city-1-loc-1 city-1-loc-3) 30)
  ; 523,269 -> 269,35
  (road city-1-loc-3 city-1-loc-2)
  (= (road-length city-1-loc-3 city-1-loc-2) 35)
  (= (fuel-demand city-1-loc-3 city-1-loc-2) 69)
  ; 269,35 -> 523,269
  (road city-1-loc-2 city-1-loc-3)
  (= (road-length city-1-loc-2 city-1-loc-3) 35)
  (= (fuel-demand city-1-loc-2 city-1-loc-3) 69)
  ; 1795,548 -> 1919,379
  (road city-2-loc-2 city-2-loc-1)
  (= (road-length city-2-loc-2 city-2-loc-1) 21)
  (= (fuel-demand city-2-loc-2 city-2-loc-1) 42)
  ; 1919,379 -> 1795,548
  (road city-2-loc-1 city-2-loc-2)
  (= (road-length city-2-loc-1 city-2-loc-2) 21)
  (= (fuel-demand city-2-loc-1 city-2-loc-2) 42)
  ; 1591,297 -> 1919,379
  (road city-2-loc-3 city-2-loc-1)
  (= (road-length city-2-loc-3 city-2-loc-1) 34)
  (= (fuel-demand city-2-loc-3 city-2-loc-1) 68)
  ; 1919,379 -> 1591,297
  (road city-2-loc-1 city-2-loc-3)
  (= (road-length city-2-loc-1 city-2-loc-3) 34)
  (= (fuel-demand city-2-loc-1 city-2-loc-3) 68)
  ; 1591,297 -> 1795,548
  (road city-2-loc-3 city-2-loc-2)
  (= (road-length city-2-loc-3 city-2-loc-2) 33)
  (= (fuel-demand city-2-loc-3 city-2-loc-2) 65)
  ; 1795,548 -> 1591,297
  (road city-2-loc-2 city-2-loc-3)
  (= (road-length city-2-loc-2 city-2-loc-3) 33)
  (= (fuel-demand city-2-loc-2 city-2-loc-3) 65)
  ; 623,380 <-> 1591,297
  (road city-1-loc-1 city-2-loc-3)
  (= (road-length city-1-loc-1 city-2-loc-3) 98)
  (= (fuel-demand city-1-loc-1 city-2-loc-3) 49)
  (road city-2-loc-3 city-1-loc-1)
  (= (road-length city-2-loc-3 city-1-loc-1) 98)
  (= (fuel-demand city-2-loc-3 city-1-loc-1) 49)
  (has-petrol-station city-1-loc-1)
  (has-petrol-station city-2-loc-3)
  (at package-1 city-1-loc-2)
  (= (package-size package-1) 56)
  (at package-2 city-1-loc-2)
  (= (package-size package-2) 63)
  (at truck-1 city-2-loc-1)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 728)
  (= (fuel-max truck-1) 728)
  (at truck-2 city-2-loc-2)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 728)
  (= (fuel-max truck-2) 728)
 )
 (:goal (and
  (at package-1 city-2-loc-3)
  (at package-2 city-2-loc-3)
 ))
 (:metric minimize (total-time))
)
