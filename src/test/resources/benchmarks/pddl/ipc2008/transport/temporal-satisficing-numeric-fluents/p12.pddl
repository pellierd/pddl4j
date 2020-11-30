; Transport p11-20-two-cities-5nodes-700size-3degree-70mindistance-2trucks-4packages-2008seed

(define (problem transport-p11-20-two-cities-5nodes-700size-3degree-70mindistance-2trucks-4packages-2008seed)
 (:domain transport)
 (:objects
  city-1-loc-1 - location
  city-2-loc-1 - location
  city-1-loc-2 - location
  city-2-loc-2 - location
  city-1-loc-3 - location
  city-2-loc-3 - location
  city-1-loc-4 - location
  city-2-loc-4 - location
  city-1-loc-5 - location
  city-2-loc-5 - location
  truck-1 - vehicle
  truck-2 - vehicle
  package-1 - package
  package-2 - package
  package-3 - package
  package-4 - package
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
  ; 638,559 -> 623,380
  (road city-1-loc-4 city-1-loc-1)
  (= (road-length city-1-loc-4 city-1-loc-1) 18)
  (= (fuel-demand city-1-loc-4 city-1-loc-1) 36)
  ; 623,380 -> 638,559
  (road city-1-loc-1 city-1-loc-4)
  (= (road-length city-1-loc-1 city-1-loc-4) 18)
  (= (fuel-demand city-1-loc-1 city-1-loc-4) 36)
  ; 638,559 -> 523,269
  (road city-1-loc-4 city-1-loc-3)
  (= (road-length city-1-loc-4 city-1-loc-3) 32)
  (= (fuel-demand city-1-loc-4 city-1-loc-3) 63)
  ; 523,269 -> 638,559
  (road city-1-loc-3 city-1-loc-4)
  (= (road-length city-1-loc-3 city-1-loc-4) 32)
  (= (fuel-demand city-1-loc-3 city-1-loc-4) 63)
  ; 684,629 -> 623,380
  (road city-1-loc-5 city-1-loc-1)
  (= (road-length city-1-loc-5 city-1-loc-1) 26)
  (= (fuel-demand city-1-loc-5 city-1-loc-1) 52)
  ; 623,380 -> 684,629
  (road city-1-loc-1 city-1-loc-5)
  (= (road-length city-1-loc-1 city-1-loc-5) 26)
  (= (fuel-demand city-1-loc-1 city-1-loc-5) 52)
  ; 684,629 -> 638,559
  (road city-1-loc-5 city-1-loc-4)
  (= (road-length city-1-loc-5 city-1-loc-4) 9)
  (= (fuel-demand city-1-loc-5 city-1-loc-4) 17)
  ; 638,559 -> 684,629
  (road city-1-loc-4 city-1-loc-5)
  (= (road-length city-1-loc-4 city-1-loc-5) 9)
  (= (fuel-demand city-1-loc-4 city-1-loc-5) 17)
  ; 1919,379 -> 1719,155
  (road city-2-loc-2 city-2-loc-1)
  (= (road-length city-2-loc-2 city-2-loc-1) 30)
  (= (fuel-demand city-2-loc-2 city-2-loc-1) 60)
  ; 1719,155 -> 1919,379
  (road city-2-loc-1 city-2-loc-2)
  (= (road-length city-2-loc-1 city-2-loc-2) 30)
  (= (fuel-demand city-2-loc-1 city-2-loc-2) 60)
  ; 1795,548 -> 1919,379
  (road city-2-loc-3 city-2-loc-2)
  (= (road-length city-2-loc-3 city-2-loc-2) 21)
  (= (fuel-demand city-2-loc-3 city-2-loc-2) 42)
  ; 1919,379 -> 1795,548
  (road city-2-loc-2 city-2-loc-3)
  (= (road-length city-2-loc-2 city-2-loc-3) 21)
  (= (fuel-demand city-2-loc-2 city-2-loc-3) 42)
  ; 1591,297 -> 1719,155
  (road city-2-loc-4 city-2-loc-1)
  (= (road-length city-2-loc-4 city-2-loc-1) 20)
  (= (fuel-demand city-2-loc-4 city-2-loc-1) 39)
  ; 1719,155 -> 1591,297
  (road city-2-loc-1 city-2-loc-4)
  (= (road-length city-2-loc-1 city-2-loc-4) 20)
  (= (fuel-demand city-2-loc-1 city-2-loc-4) 39)
  ; 1591,297 -> 1919,379
  (road city-2-loc-4 city-2-loc-2)
  (= (road-length city-2-loc-4 city-2-loc-2) 34)
  (= (fuel-demand city-2-loc-4 city-2-loc-2) 68)
  ; 1919,379 -> 1591,297
  (road city-2-loc-2 city-2-loc-4)
  (= (road-length city-2-loc-2 city-2-loc-4) 34)
  (= (fuel-demand city-2-loc-2 city-2-loc-4) 68)
  ; 1591,297 -> 1795,548
  (road city-2-loc-4 city-2-loc-3)
  (= (road-length city-2-loc-4 city-2-loc-3) 33)
  (= (fuel-demand city-2-loc-4 city-2-loc-3) 65)
  ; 1795,548 -> 1591,297
  (road city-2-loc-3 city-2-loc-4)
  (= (road-length city-2-loc-3 city-2-loc-4) 33)
  (= (fuel-demand city-2-loc-3 city-2-loc-4) 65)
  ; 1796,386 -> 1719,155
  (road city-2-loc-5 city-2-loc-1)
  (= (road-length city-2-loc-5 city-2-loc-1) 25)
  (= (fuel-demand city-2-loc-5 city-2-loc-1) 49)
  ; 1719,155 -> 1796,386
  (road city-2-loc-1 city-2-loc-5)
  (= (road-length city-2-loc-1 city-2-loc-5) 25)
  (= (fuel-demand city-2-loc-1 city-2-loc-5) 49)
  ; 1796,386 -> 1919,379
  (road city-2-loc-5 city-2-loc-2)
  (= (road-length city-2-loc-5 city-2-loc-2) 13)
  (= (fuel-demand city-2-loc-5 city-2-loc-2) 25)
  ; 1919,379 -> 1796,386
  (road city-2-loc-2 city-2-loc-5)
  (= (road-length city-2-loc-2 city-2-loc-5) 13)
  (= (fuel-demand city-2-loc-2 city-2-loc-5) 25)
  ; 1796,386 -> 1795,548
  (road city-2-loc-5 city-2-loc-3)
  (= (road-length city-2-loc-5 city-2-loc-3) 17)
  (= (fuel-demand city-2-loc-5 city-2-loc-3) 33)
  ; 1795,548 -> 1796,386
  (road city-2-loc-3 city-2-loc-5)
  (= (road-length city-2-loc-3 city-2-loc-5) 17)
  (= (fuel-demand city-2-loc-3 city-2-loc-5) 33)
  ; 1796,386 -> 1591,297
  (road city-2-loc-5 city-2-loc-4)
  (= (road-length city-2-loc-5 city-2-loc-4) 23)
  (= (fuel-demand city-2-loc-5 city-2-loc-4) 45)
  ; 1591,297 -> 1796,386
  (road city-2-loc-4 city-2-loc-5)
  (= (road-length city-2-loc-4 city-2-loc-5) 23)
  (= (fuel-demand city-2-loc-4 city-2-loc-5) 45)
  ; 684,629 <-> 1591,297
  (road city-1-loc-5 city-2-loc-4)
  (= (road-length city-1-loc-5 city-2-loc-4) 97)
  (= (fuel-demand city-1-loc-5 city-2-loc-4) 49)
  (road city-2-loc-4 city-1-loc-5)
  (= (road-length city-2-loc-4 city-1-loc-5) 97)
  (= (fuel-demand city-2-loc-4 city-1-loc-5) 49)
  (has-petrol-station city-1-loc-5)
  (has-petrol-station city-2-loc-4)
  (at package-1 city-1-loc-4)
  (= (package-size package-1) 63)
  (at package-2 city-1-loc-1)
  (= (package-size package-2) 65)
  (at package-3 city-1-loc-5)
  (= (package-size package-3) 92)
  (at package-4 city-1-loc-5)
  (= (package-size package-4) 26)
  (at truck-1 city-2-loc-1)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 724)
  (= (fuel-max truck-1) 724)
  (at truck-2 city-2-loc-4)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 724)
  (= (fuel-max truck-2) 724)
 )
 (:goal (and
  (at package-1 city-2-loc-5)
  (at package-2 city-2-loc-5)
  (at package-3 city-2-loc-2)
  (at package-4 city-2-loc-3)
 ))
 (:metric minimize (total-time))
)
