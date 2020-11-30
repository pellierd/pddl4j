; Transport p11-20-two-cities-10nodes-700size-3degree-70mindistance-3trucks-8packages-2008seed

(define (problem transport-p11-20-two-cities-10nodes-700size-3degree-70mindistance-3trucks-8packages-2008seed)
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
  city-1-loc-9 - location
  city-2-loc-9 - location
  city-1-loc-10 - location
  city-2-loc-10 - location
  truck-1 - vehicle
  truck-2 - vehicle
  truck-3 - vehicle
  package-1 - package
  package-2 - package
  package-3 - package
  package-4 - package
  package-5 - package
  package-6 - package
  package-7 - package
  package-8 - package
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
  ; 191,297 -> 319,155
  (road city-1-loc-9 city-1-loc-6)
  (= (road-length city-1-loc-9 city-1-loc-6) 20)
  (= (fuel-demand city-1-loc-9 city-1-loc-6) 39)
  ; 319,155 -> 191,297
  (road city-1-loc-6 city-1-loc-9)
  (= (road-length city-1-loc-6 city-1-loc-9) 20)
  (= (fuel-demand city-1-loc-6 city-1-loc-9) 39)
  ; 396,386 -> 623,380
  (road city-1-loc-10 city-1-loc-1)
  (= (road-length city-1-loc-10 city-1-loc-1) 23)
  (= (fuel-demand city-1-loc-10 city-1-loc-1) 46)
  ; 623,380 -> 396,386
  (road city-1-loc-1 city-1-loc-10)
  (= (road-length city-1-loc-1 city-1-loc-10) 23)
  (= (fuel-demand city-1-loc-1 city-1-loc-10) 46)
  ; 396,386 -> 523,269
  (road city-1-loc-10 city-1-loc-3)
  (= (road-length city-1-loc-10 city-1-loc-3) 18)
  (= (fuel-demand city-1-loc-10 city-1-loc-3) 35)
  ; 523,269 -> 396,386
  (road city-1-loc-3 city-1-loc-10)
  (= (road-length city-1-loc-3 city-1-loc-10) 18)
  (= (fuel-demand city-1-loc-3 city-1-loc-10) 35)
  ; 396,386 -> 319,155
  (road city-1-loc-10 city-1-loc-6)
  (= (road-length city-1-loc-10 city-1-loc-6) 25)
  (= (fuel-demand city-1-loc-10 city-1-loc-6) 49)
  ; 319,155 -> 396,386
  (road city-1-loc-6 city-1-loc-10)
  (= (road-length city-1-loc-6 city-1-loc-10) 25)
  (= (fuel-demand city-1-loc-6 city-1-loc-10) 49)
  ; 396,386 -> 519,379
  (road city-1-loc-10 city-1-loc-7)
  (= (road-length city-1-loc-10 city-1-loc-7) 13)
  (= (fuel-demand city-1-loc-10 city-1-loc-7) 25)
  ; 519,379 -> 396,386
  (road city-1-loc-7 city-1-loc-10)
  (= (road-length city-1-loc-7 city-1-loc-10) 13)
  (= (fuel-demand city-1-loc-7 city-1-loc-10) 25)
  ; 396,386 -> 395,548
  (road city-1-loc-10 city-1-loc-8)
  (= (road-length city-1-loc-10 city-1-loc-8) 17)
  (= (fuel-demand city-1-loc-10 city-1-loc-8) 33)
  ; 395,548 -> 396,386
  (road city-1-loc-8 city-1-loc-10)
  (= (road-length city-1-loc-8 city-1-loc-10) 17)
  (= (fuel-demand city-1-loc-8 city-1-loc-10) 33)
  ; 396,386 -> 191,297
  (road city-1-loc-10 city-1-loc-9)
  (= (road-length city-1-loc-10 city-1-loc-9) 23)
  (= (fuel-demand city-1-loc-10 city-1-loc-9) 45)
  ; 191,297 -> 396,386
  (road city-1-loc-9 city-1-loc-10)
  (= (road-length city-1-loc-9 city-1-loc-10) 23)
  (= (fuel-demand city-1-loc-9 city-1-loc-10) 45)
  ; 1519,496 -> 1635,332
  (road city-2-loc-2 city-2-loc-1)
  (= (road-length city-2-loc-2 city-2-loc-1) 21)
  (= (fuel-demand city-2-loc-2 city-2-loc-1) 41)
  ; 1635,332 -> 1519,496
  (road city-2-loc-1 city-2-loc-2)
  (= (road-length city-2-loc-1 city-2-loc-2) 21)
  (= (fuel-demand city-2-loc-1 city-2-loc-2) 41)
  ; 1765,262 -> 1635,332
  (road city-2-loc-3 city-2-loc-1)
  (= (road-length city-2-loc-3 city-2-loc-1) 15)
  (= (fuel-demand city-2-loc-3 city-2-loc-1) 30)
  ; 1635,332 -> 1765,262
  (road city-2-loc-1 city-2-loc-3)
  (= (road-length city-2-loc-1 city-2-loc-3) 15)
  (= (fuel-demand city-2-loc-1 city-2-loc-3) 30)
  ; 1621,166 -> 1635,332
  (road city-2-loc-5 city-2-loc-1)
  (= (road-length city-2-loc-5 city-2-loc-1) 17)
  (= (fuel-demand city-2-loc-5 city-2-loc-1) 34)
  ; 1635,332 -> 1621,166
  (road city-2-loc-1 city-2-loc-5)
  (= (road-length city-2-loc-1 city-2-loc-5) 17)
  (= (fuel-demand city-2-loc-1 city-2-loc-5) 34)
  ; 1621,166 -> 1765,262
  (road city-2-loc-5 city-2-loc-3)
  (= (road-length city-2-loc-5 city-2-loc-3) 18)
  (= (fuel-demand city-2-loc-5 city-2-loc-3) 35)
  ; 1765,262 -> 1621,166
  (road city-2-loc-3 city-2-loc-5)
  (= (road-length city-2-loc-3 city-2-loc-5) 18)
  (= (fuel-demand city-2-loc-3 city-2-loc-5) 35)
  ; 1904,169 -> 1765,262
  (road city-2-loc-6 city-2-loc-3)
  (= (road-length city-2-loc-6 city-2-loc-3) 17)
  (= (fuel-demand city-2-loc-6 city-2-loc-3) 34)
  ; 1765,262 -> 1904,169
  (road city-2-loc-3 city-2-loc-6)
  (= (road-length city-2-loc-3 city-2-loc-6) 17)
  (= (fuel-demand city-2-loc-3 city-2-loc-6) 34)
  ; 1904,169 -> 1891,0
  (road city-2-loc-6 city-2-loc-4)
  (= (road-length city-2-loc-6 city-2-loc-4) 17)
  (= (fuel-demand city-2-loc-6 city-2-loc-4) 34)
  ; 1891,0 -> 1904,169
  (road city-2-loc-4 city-2-loc-6)
  (= (road-length city-2-loc-4 city-2-loc-6) 17)
  (= (fuel-demand city-2-loc-4 city-2-loc-6) 34)
  ; 1841,505 -> 1765,262
  (road city-2-loc-7 city-2-loc-3)
  (= (road-length city-2-loc-7 city-2-loc-3) 26)
  (= (fuel-demand city-2-loc-7 city-2-loc-3) 51)
  ; 1765,262 -> 1841,505
  (road city-2-loc-3 city-2-loc-7)
  (= (road-length city-2-loc-3 city-2-loc-7) 26)
  (= (fuel-demand city-2-loc-3 city-2-loc-7) 51)
  ; 1484,598 -> 1519,496
  (road city-2-loc-8 city-2-loc-2)
  (= (road-length city-2-loc-8 city-2-loc-2) 11)
  (= (fuel-demand city-2-loc-8 city-2-loc-2) 22)
  ; 1519,496 -> 1484,598
  (road city-2-loc-2 city-2-loc-8)
  (= (road-length city-2-loc-2 city-2-loc-8) 11)
  (= (fuel-demand city-2-loc-2 city-2-loc-8) 22)
  ; 1520,381 -> 1635,332
  (road city-2-loc-9 city-2-loc-1)
  (= (road-length city-2-loc-9 city-2-loc-1) 13)
  (= (fuel-demand city-2-loc-9 city-2-loc-1) 25)
  ; 1635,332 -> 1520,381
  (road city-2-loc-1 city-2-loc-9)
  (= (road-length city-2-loc-1 city-2-loc-9) 13)
  (= (fuel-demand city-2-loc-1 city-2-loc-9) 25)
  ; 1520,381 -> 1519,496
  (road city-2-loc-9 city-2-loc-2)
  (= (road-length city-2-loc-9 city-2-loc-2) 12)
  (= (fuel-demand city-2-loc-9 city-2-loc-2) 23)
  ; 1519,496 -> 1520,381
  (road city-2-loc-2 city-2-loc-9)
  (= (road-length city-2-loc-2 city-2-loc-9) 12)
  (= (fuel-demand city-2-loc-2 city-2-loc-9) 23)
  ; 1520,381 -> 1621,166
  (road city-2-loc-9 city-2-loc-5)
  (= (road-length city-2-loc-9 city-2-loc-5) 24)
  (= (fuel-demand city-2-loc-9 city-2-loc-5) 48)
  ; 1621,166 -> 1520,381
  (road city-2-loc-5 city-2-loc-9)
  (= (road-length city-2-loc-5 city-2-loc-9) 24)
  (= (fuel-demand city-2-loc-5 city-2-loc-9) 48)
  ; 1520,381 -> 1484,598
  (road city-2-loc-9 city-2-loc-8)
  (= (road-length city-2-loc-9 city-2-loc-8) 22)
  (= (fuel-demand city-2-loc-9 city-2-loc-8) 44)
  ; 1484,598 -> 1520,381
  (road city-2-loc-8 city-2-loc-9)
  (= (road-length city-2-loc-8 city-2-loc-9) 22)
  (= (fuel-demand city-2-loc-8 city-2-loc-9) 44)
  ; 1643,425 -> 1635,332
  (road city-2-loc-10 city-2-loc-1)
  (= (road-length city-2-loc-10 city-2-loc-1) 10)
  (= (fuel-demand city-2-loc-10 city-2-loc-1) 19)
  ; 1635,332 -> 1643,425
  (road city-2-loc-1 city-2-loc-10)
  (= (road-length city-2-loc-1 city-2-loc-10) 10)
  (= (fuel-demand city-2-loc-1 city-2-loc-10) 19)
  ; 1643,425 -> 1519,496
  (road city-2-loc-10 city-2-loc-2)
  (= (road-length city-2-loc-10 city-2-loc-2) 15)
  (= (fuel-demand city-2-loc-10 city-2-loc-2) 29)
  ; 1519,496 -> 1643,425
  (road city-2-loc-2 city-2-loc-10)
  (= (road-length city-2-loc-2 city-2-loc-10) 15)
  (= (fuel-demand city-2-loc-2 city-2-loc-10) 29)
  ; 1643,425 -> 1765,262
  (road city-2-loc-10 city-2-loc-3)
  (= (road-length city-2-loc-10 city-2-loc-3) 21)
  (= (fuel-demand city-2-loc-10 city-2-loc-3) 41)
  ; 1765,262 -> 1643,425
  (road city-2-loc-3 city-2-loc-10)
  (= (road-length city-2-loc-3 city-2-loc-10) 21)
  (= (fuel-demand city-2-loc-3 city-2-loc-10) 41)
  ; 1643,425 -> 1841,505
  (road city-2-loc-10 city-2-loc-7)
  (= (road-length city-2-loc-10 city-2-loc-7) 22)
  (= (fuel-demand city-2-loc-10 city-2-loc-7) 43)
  ; 1841,505 -> 1643,425
  (road city-2-loc-7 city-2-loc-10)
  (= (road-length city-2-loc-7 city-2-loc-10) 22)
  (= (fuel-demand city-2-loc-7 city-2-loc-10) 43)
  ; 1643,425 -> 1484,598
  (road city-2-loc-10 city-2-loc-8)
  (= (road-length city-2-loc-10 city-2-loc-8) 24)
  (= (fuel-demand city-2-loc-10 city-2-loc-8) 47)
  ; 1484,598 -> 1643,425
  (road city-2-loc-8 city-2-loc-10)
  (= (road-length city-2-loc-8 city-2-loc-10) 24)
  (= (fuel-demand city-2-loc-8 city-2-loc-10) 47)
  ; 1643,425 -> 1520,381
  (road city-2-loc-10 city-2-loc-9)
  (= (road-length city-2-loc-10 city-2-loc-9) 14)
  (= (fuel-demand city-2-loc-10 city-2-loc-9) 27)
  ; 1520,381 -> 1643,425
  (road city-2-loc-9 city-2-loc-10)
  (= (road-length city-2-loc-9 city-2-loc-10) 14)
  (= (fuel-demand city-2-loc-9 city-2-loc-10) 27)
  ; 684,629 <-> 1484,598
  (road city-1-loc-5 city-2-loc-8)
  (= (road-length city-1-loc-5 city-2-loc-8) 81)
  (= (fuel-demand city-1-loc-5 city-2-loc-8) 41)
  (road city-2-loc-8 city-1-loc-5)
  (= (road-length city-2-loc-8 city-1-loc-5) 81)
  (= (fuel-demand city-2-loc-8 city-1-loc-5) 41)
  (has-petrol-station city-1-loc-5)
  (has-petrol-station city-2-loc-8)
  (at package-1 city-1-loc-4)
  (= (package-size package-1) 75)
  (at package-2 city-1-loc-7)
  (= (package-size package-2) 67)
  (at package-3 city-1-loc-4)
  (= (package-size package-3) 55)
  (at package-4 city-1-loc-4)
  (= (package-size package-4) 25)
  (at package-5 city-1-loc-6)
  (= (package-size package-5) 77)
  (at package-6 city-1-loc-1)
  (= (package-size package-6) 28)
  (at package-7 city-1-loc-9)
  (= (package-size package-7) 14)
  (at package-8 city-1-loc-1)
  (= (package-size package-8) 51)
  (at truck-1 city-2-loc-3)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 600)
  (= (fuel-max truck-1) 600)
  (at truck-2 city-2-loc-10)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 600)
  (= (fuel-max truck-2) 600)
  (at truck-3 city-2-loc-3)
  (ready-loading truck-3)
  (= (capacity truck-3) 100)
  (= (fuel-left truck-3) 600)
  (= (fuel-max truck-3) 600)
 )
 (:goal (and
  (at package-1 city-2-loc-7)
  (at package-2 city-2-loc-4)
  (at package-3 city-2-loc-3)
  (at package-4 city-2-loc-10)
  (at package-5 city-2-loc-9)
  (at package-6 city-2-loc-6)
  (at package-7 city-2-loc-7)
  (at package-8 city-2-loc-4)
 ))
 (:metric minimize (total-time))
)
