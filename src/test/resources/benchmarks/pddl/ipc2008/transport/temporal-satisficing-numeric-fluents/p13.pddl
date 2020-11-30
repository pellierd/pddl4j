; Transport p11-20-two-cities-8nodes-700size-3degree-70mindistance-3trucks-6packages-2008seed

(define (problem transport-p11-20-two-cities-8nodes-700size-3degree-70mindistance-3trucks-6packages-2008seed)
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
  city-1-loc-6 - location
  city-2-loc-6 - location
  city-1-loc-7 - location
  city-2-loc-7 - location
  city-1-loc-8 - location
  city-2-loc-8 - location
  truck-1 - vehicle
  truck-2 - vehicle
  truck-3 - vehicle
  package-1 - package
  package-2 - package
  package-3 - package
  package-4 - package
  package-5 - package
  package-6 - package
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
  ; 638,559 -> 623,380
  (road city-1-loc-4 city-1-loc-1)
  (= (road-length city-1-loc-4 city-1-loc-1) 18)
  (= (fuel-demand city-1-loc-4 city-1-loc-1) 36)
  ; 623,380 -> 638,559
  (road city-1-loc-1 city-1-loc-4)
  (= (road-length city-1-loc-1 city-1-loc-4) 18)
  (= (fuel-demand city-1-loc-1 city-1-loc-4) 36)
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
  ; 319,155 -> 269,35
  (road city-1-loc-6 city-1-loc-2)
  (= (road-length city-1-loc-6 city-1-loc-2) 13)
  (= (fuel-demand city-1-loc-6 city-1-loc-2) 26)
  ; 269,35 -> 319,155
  (road city-1-loc-2 city-1-loc-6)
  (= (road-length city-1-loc-2 city-1-loc-6) 13)
  (= (fuel-demand city-1-loc-2 city-1-loc-6) 26)
  ; 319,155 -> 523,269
  (road city-1-loc-6 city-1-loc-3)
  (= (road-length city-1-loc-6 city-1-loc-3) 24)
  (= (fuel-demand city-1-loc-6 city-1-loc-3) 47)
  ; 523,269 -> 319,155
  (road city-1-loc-3 city-1-loc-6)
  (= (road-length city-1-loc-3 city-1-loc-6) 24)
  (= (fuel-demand city-1-loc-3 city-1-loc-6) 47)
  ; 519,379 -> 623,380
  (road city-1-loc-7 city-1-loc-1)
  (= (road-length city-1-loc-7 city-1-loc-1) 11)
  (= (fuel-demand city-1-loc-7 city-1-loc-1) 21)
  ; 623,380 -> 519,379
  (road city-1-loc-1 city-1-loc-7)
  (= (road-length city-1-loc-1 city-1-loc-7) 11)
  (= (fuel-demand city-1-loc-1 city-1-loc-7) 21)
  ; 519,379 -> 523,269
  (road city-1-loc-7 city-1-loc-3)
  (= (road-length city-1-loc-7 city-1-loc-3) 11)
  (= (fuel-demand city-1-loc-7 city-1-loc-3) 22)
  ; 523,269 -> 519,379
  (road city-1-loc-3 city-1-loc-7)
  (= (road-length city-1-loc-3 city-1-loc-7) 11)
  (= (fuel-demand city-1-loc-3 city-1-loc-7) 22)
  ; 519,379 -> 638,559
  (road city-1-loc-7 city-1-loc-4)
  (= (road-length city-1-loc-7 city-1-loc-4) 22)
  (= (fuel-demand city-1-loc-7 city-1-loc-4) 44)
  ; 638,559 -> 519,379
  (road city-1-loc-4 city-1-loc-7)
  (= (road-length city-1-loc-4 city-1-loc-7) 22)
  (= (fuel-demand city-1-loc-4 city-1-loc-7) 44)
  ; 395,548 -> 623,380
  (road city-1-loc-8 city-1-loc-1)
  (= (road-length city-1-loc-8 city-1-loc-1) 29)
  (= (fuel-demand city-1-loc-8 city-1-loc-1) 57)
  ; 623,380 -> 395,548
  (road city-1-loc-1 city-1-loc-8)
  (= (road-length city-1-loc-1 city-1-loc-8) 29)
  (= (fuel-demand city-1-loc-1 city-1-loc-8) 57)
  ; 395,548 -> 638,559
  (road city-1-loc-8 city-1-loc-4)
  (= (road-length city-1-loc-8 city-1-loc-4) 25)
  (= (fuel-demand city-1-loc-8 city-1-loc-4) 49)
  ; 638,559 -> 395,548
  (road city-1-loc-4 city-1-loc-8)
  (= (road-length city-1-loc-4 city-1-loc-8) 25)
  (= (fuel-demand city-1-loc-4 city-1-loc-8) 49)
  ; 395,548 -> 519,379
  (road city-1-loc-8 city-1-loc-7)
  (= (road-length city-1-loc-8 city-1-loc-7) 21)
  (= (fuel-demand city-1-loc-8 city-1-loc-7) 42)
  ; 519,379 -> 395,548
  (road city-1-loc-7 city-1-loc-8)
  (= (road-length city-1-loc-7 city-1-loc-8) 21)
  (= (fuel-demand city-1-loc-7 city-1-loc-8) 42)
  ; 1923,604 -> 1653,603
  (road city-2-loc-2 city-2-loc-1)
  (= (road-length city-2-loc-2 city-2-loc-1) 27)
  (= (fuel-demand city-2-loc-2 city-2-loc-1) 54)
  ; 1653,603 -> 1923,604
  (road city-2-loc-1 city-2-loc-2)
  (= (road-length city-2-loc-1 city-2-loc-2) 27)
  (= (fuel-demand city-2-loc-1 city-2-loc-2) 54)
  ; 1861,348 -> 1923,604
  (road city-2-loc-4 city-2-loc-2)
  (= (road-length city-2-loc-4 city-2-loc-2) 27)
  (= (fuel-demand city-2-loc-4 city-2-loc-2) 53)
  ; 1923,604 -> 1861,348
  (road city-2-loc-2 city-2-loc-4)
  (= (road-length city-2-loc-2 city-2-loc-4) 27)
  (= (fuel-demand city-2-loc-2 city-2-loc-4) 53)
  ; 1580,3 -> 1404,42
  (road city-2-loc-5 city-2-loc-3)
  (= (road-length city-2-loc-5 city-2-loc-3) 18)
  (= (fuel-demand city-2-loc-5 city-2-loc-3) 36)
  ; 1404,42 -> 1580,3
  (road city-2-loc-3 city-2-loc-5)
  (= (road-length city-2-loc-3 city-2-loc-5) 18)
  (= (fuel-demand city-2-loc-3 city-2-loc-5) 36)
  ; 1571,242 -> 1404,42
  (road city-2-loc-6 city-2-loc-3)
  (= (road-length city-2-loc-6 city-2-loc-3) 27)
  (= (fuel-demand city-2-loc-6 city-2-loc-3) 53)
  ; 1404,42 -> 1571,242
  (road city-2-loc-3 city-2-loc-6)
  (= (road-length city-2-loc-3 city-2-loc-6) 27)
  (= (fuel-demand city-2-loc-3 city-2-loc-6) 53)
  ; 1571,242 -> 1580,3
  (road city-2-loc-6 city-2-loc-5)
  (= (road-length city-2-loc-6 city-2-loc-5) 24)
  (= (fuel-demand city-2-loc-6 city-2-loc-5) 48)
  ; 1580,3 -> 1571,242
  (road city-2-loc-5 city-2-loc-6)
  (= (road-length city-2-loc-5 city-2-loc-6) 24)
  (= (fuel-demand city-2-loc-5 city-2-loc-6) 48)
  ; 1791,395 -> 1653,603
  (road city-2-loc-7 city-2-loc-1)
  (= (road-length city-2-loc-7 city-2-loc-1) 25)
  (= (fuel-demand city-2-loc-7 city-2-loc-1) 50)
  ; 1653,603 -> 1791,395
  (road city-2-loc-1 city-2-loc-7)
  (= (road-length city-2-loc-1 city-2-loc-7) 25)
  (= (fuel-demand city-2-loc-1 city-2-loc-7) 50)
  ; 1791,395 -> 1923,604
  (road city-2-loc-7 city-2-loc-2)
  (= (road-length city-2-loc-7 city-2-loc-2) 25)
  (= (fuel-demand city-2-loc-7 city-2-loc-2) 50)
  ; 1923,604 -> 1791,395
  (road city-2-loc-2 city-2-loc-7)
  (= (road-length city-2-loc-2 city-2-loc-7) 25)
  (= (fuel-demand city-2-loc-2 city-2-loc-7) 50)
  ; 1791,395 -> 1861,348
  (road city-2-loc-7 city-2-loc-4)
  (= (road-length city-2-loc-7 city-2-loc-4) 9)
  (= (fuel-demand city-2-loc-7 city-2-loc-4) 17)
  ; 1861,348 -> 1791,395
  (road city-2-loc-4 city-2-loc-7)
  (= (road-length city-2-loc-4 city-2-loc-7) 9)
  (= (fuel-demand city-2-loc-4 city-2-loc-7) 17)
  ; 1791,395 -> 1571,242
  (road city-2-loc-7 city-2-loc-6)
  (= (road-length city-2-loc-7 city-2-loc-6) 27)
  (= (fuel-demand city-2-loc-7 city-2-loc-6) 54)
  ; 1571,242 -> 1791,395
  (road city-2-loc-6 city-2-loc-7)
  (= (road-length city-2-loc-6 city-2-loc-7) 27)
  (= (fuel-demand city-2-loc-6 city-2-loc-7) 54)
  ; 1642,104 -> 1404,42
  (road city-2-loc-8 city-2-loc-3)
  (= (road-length city-2-loc-8 city-2-loc-3) 25)
  (= (fuel-demand city-2-loc-8 city-2-loc-3) 50)
  ; 1404,42 -> 1642,104
  (road city-2-loc-3 city-2-loc-8)
  (= (road-length city-2-loc-3 city-2-loc-8) 25)
  (= (fuel-demand city-2-loc-3 city-2-loc-8) 50)
  ; 1642,104 -> 1580,3
  (road city-2-loc-8 city-2-loc-5)
  (= (road-length city-2-loc-8 city-2-loc-5) 12)
  (= (fuel-demand city-2-loc-8 city-2-loc-5) 24)
  ; 1580,3 -> 1642,104
  (road city-2-loc-5 city-2-loc-8)
  (= (road-length city-2-loc-5 city-2-loc-8) 12)
  (= (fuel-demand city-2-loc-5 city-2-loc-8) 24)
  ; 1642,104 -> 1571,242
  (road city-2-loc-8 city-2-loc-6)
  (= (road-length city-2-loc-8 city-2-loc-6) 16)
  (= (fuel-demand city-2-loc-8 city-2-loc-6) 31)
  ; 1571,242 -> 1642,104
  (road city-2-loc-6 city-2-loc-8)
  (= (road-length city-2-loc-6 city-2-loc-8) 16)
  (= (fuel-demand city-2-loc-6 city-2-loc-8) 31)
  ; 623,380 <-> 1404,42
  (road city-1-loc-1 city-2-loc-3)
  (= (road-length city-1-loc-1 city-2-loc-3) 86)
  (= (fuel-demand city-1-loc-1 city-2-loc-3) 43)
  (road city-2-loc-3 city-1-loc-1)
  (= (road-length city-2-loc-3 city-1-loc-1) 86)
  (= (fuel-demand city-2-loc-3 city-1-loc-1) 43)
  (has-petrol-station city-1-loc-1)
  (has-petrol-station city-2-loc-3)
  (at package-1 city-1-loc-3)
  (= (package-size package-1) 48)
  (at package-2 city-1-loc-2)
  (= (package-size package-2) 71)
  (at package-3 city-1-loc-1)
  (= (package-size package-3) 66)
  (at package-4 city-1-loc-5)
  (= (package-size package-4) 38)
  (at package-5 city-1-loc-6)
  (= (package-size package-5) 1)
  (at package-6 city-1-loc-3)
  (= (package-size package-6) 24)
  (at truck-1 city-2-loc-6)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 638)
  (= (fuel-max truck-1) 638)
  (at truck-2 city-2-loc-2)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 638)
  (= (fuel-max truck-2) 638)
  (at truck-3 city-2-loc-4)
  (ready-loading truck-3)
  (= (capacity truck-3) 100)
  (= (fuel-left truck-3) 638)
  (= (fuel-max truck-3) 638)
 )
 (:goal (and
  (at package-1 city-2-loc-3)
  (at package-2 city-2-loc-2)
  (at package-3 city-2-loc-6)
  (at package-4 city-2-loc-6)
  (at package-5 city-2-loc-6)
  (at package-6 city-2-loc-1)
 ))
 (:metric minimize (total-time))
)
