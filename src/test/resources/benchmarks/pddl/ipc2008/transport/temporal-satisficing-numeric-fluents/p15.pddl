; Transport p11-20-two-cities-13nodes-700size-4degree-70mindistance-3trucks-10packages-2008seed

(define (problem transport-p11-20-two-cities-13nodes-700size-4degree-70mindistance-3trucks-10packages-2008seed)
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
  city-1-loc-11 - location
  city-2-loc-11 - location
  city-1-loc-12 - location
  city-2-loc-12 - location
  city-1-loc-13 - location
  city-2-loc-13 - location
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
  package-9 - package
  package-10 - package
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
  ; 121,450 -> 191,297
  (road city-1-loc-11 city-1-loc-9)
  (= (road-length city-1-loc-11 city-1-loc-9) 17)
  (= (fuel-demand city-1-loc-11 city-1-loc-9) 34)
  ; 191,297 -> 121,450
  (road city-1-loc-9 city-1-loc-11)
  (= (road-length city-1-loc-9 city-1-loc-11) 17)
  (= (fuel-demand city-1-loc-9 city-1-loc-11) 34)
  ; 651,181 -> 623,380
  (road city-1-loc-12 city-1-loc-1)
  (= (road-length city-1-loc-12 city-1-loc-1) 21)
  (= (fuel-demand city-1-loc-12 city-1-loc-1) 41)
  ; 623,380 -> 651,181
  (road city-1-loc-1 city-1-loc-12)
  (= (road-length city-1-loc-1 city-1-loc-12) 21)
  (= (fuel-demand city-1-loc-1 city-1-loc-12) 41)
  ; 651,181 -> 523,269
  (road city-1-loc-12 city-1-loc-3)
  (= (road-length city-1-loc-12 city-1-loc-3) 16)
  (= (fuel-demand city-1-loc-12 city-1-loc-3) 31)
  ; 523,269 -> 651,181
  (road city-1-loc-3 city-1-loc-12)
  (= (road-length city-1-loc-3 city-1-loc-12) 16)
  (= (fuel-demand city-1-loc-3 city-1-loc-12) 31)
  ; 651,181 -> 519,379
  (road city-1-loc-12 city-1-loc-7)
  (= (road-length city-1-loc-12 city-1-loc-7) 24)
  (= (fuel-demand city-1-loc-12 city-1-loc-7) 48)
  ; 519,379 -> 651,181
  (road city-1-loc-7 city-1-loc-12)
  (= (road-length city-1-loc-7 city-1-loc-12) 24)
  (= (fuel-demand city-1-loc-7 city-1-loc-12) 48)
  ; 39,424 -> 191,297
  (road city-1-loc-13 city-1-loc-9)
  (= (road-length city-1-loc-13 city-1-loc-9) 20)
  (= (fuel-demand city-1-loc-13 city-1-loc-9) 40)
  ; 191,297 -> 39,424
  (road city-1-loc-9 city-1-loc-13)
  (= (road-length city-1-loc-9 city-1-loc-13) 20)
  (= (fuel-demand city-1-loc-9 city-1-loc-13) 40)
  ; 39,424 -> 121,450
  (road city-1-loc-13 city-1-loc-11)
  (= (road-length city-1-loc-13 city-1-loc-11) 9)
  (= (fuel-demand city-1-loc-13 city-1-loc-11) 18)
  ; 121,450 -> 39,424
  (road city-1-loc-11 city-1-loc-13)
  (= (road-length city-1-loc-11 city-1-loc-13) 9)
  (= (fuel-demand city-1-loc-11 city-1-loc-13) 18)
  ; 1743,199 -> 1621,166
  (road city-2-loc-3 city-2-loc-1)
  (= (road-length city-2-loc-3 city-2-loc-1) 13)
  (= (fuel-demand city-2-loc-3 city-2-loc-1) 26)
  ; 1621,166 -> 1743,199
  (road city-2-loc-1 city-2-loc-3)
  (= (road-length city-2-loc-1 city-2-loc-3) 13)
  (= (fuel-demand city-2-loc-1 city-2-loc-3) 26)
  ; 1743,199 -> 1904,169
  (road city-2-loc-3 city-2-loc-2)
  (= (road-length city-2-loc-3 city-2-loc-2) 17)
  (= (fuel-demand city-2-loc-3 city-2-loc-2) 33)
  ; 1904,169 -> 1743,199
  (road city-2-loc-2 city-2-loc-3)
  (= (road-length city-2-loc-2 city-2-loc-3) 17)
  (= (fuel-demand city-2-loc-2 city-2-loc-3) 33)
  ; 1484,598 -> 1540,468
  (road city-2-loc-6 city-2-loc-4)
  (= (road-length city-2-loc-6 city-2-loc-4) 15)
  (= (fuel-demand city-2-loc-6 city-2-loc-4) 29)
  ; 1540,468 -> 1484,598
  (road city-2-loc-4 city-2-loc-6)
  (= (road-length city-2-loc-4 city-2-loc-6) 15)
  (= (fuel-demand city-2-loc-4 city-2-loc-6) 29)
  ; 1520,381 -> 1621,166
  (road city-2-loc-7 city-2-loc-1)
  (= (road-length city-2-loc-7 city-2-loc-1) 24)
  (= (fuel-demand city-2-loc-7 city-2-loc-1) 48)
  ; 1621,166 -> 1520,381
  (road city-2-loc-1 city-2-loc-7)
  (= (road-length city-2-loc-1 city-2-loc-7) 24)
  (= (fuel-demand city-2-loc-1 city-2-loc-7) 48)
  ; 1520,381 -> 1540,468
  (road city-2-loc-7 city-2-loc-4)
  (= (road-length city-2-loc-7 city-2-loc-4) 9)
  (= (fuel-demand city-2-loc-7 city-2-loc-4) 18)
  ; 1540,468 -> 1520,381
  (road city-2-loc-4 city-2-loc-7)
  (= (road-length city-2-loc-4 city-2-loc-7) 9)
  (= (fuel-demand city-2-loc-4 city-2-loc-7) 18)
  ; 1520,381 -> 1484,598
  (road city-2-loc-7 city-2-loc-6)
  (= (road-length city-2-loc-7 city-2-loc-6) 22)
  (= (fuel-demand city-2-loc-7 city-2-loc-6) 44)
  ; 1484,598 -> 1520,381
  (road city-2-loc-6 city-2-loc-7)
  (= (road-length city-2-loc-6 city-2-loc-7) 22)
  (= (fuel-demand city-2-loc-6 city-2-loc-7) 44)
  ; 1643,425 -> 1621,166
  (road city-2-loc-8 city-2-loc-1)
  (= (road-length city-2-loc-8 city-2-loc-1) 26)
  (= (fuel-demand city-2-loc-8 city-2-loc-1) 52)
  ; 1621,166 -> 1643,425
  (road city-2-loc-1 city-2-loc-8)
  (= (road-length city-2-loc-1 city-2-loc-8) 26)
  (= (fuel-demand city-2-loc-1 city-2-loc-8) 52)
  ; 1643,425 -> 1743,199
  (road city-2-loc-8 city-2-loc-3)
  (= (road-length city-2-loc-8 city-2-loc-3) 25)
  (= (fuel-demand city-2-loc-8 city-2-loc-3) 50)
  ; 1743,199 -> 1643,425
  (road city-2-loc-3 city-2-loc-8)
  (= (road-length city-2-loc-3 city-2-loc-8) 25)
  (= (fuel-demand city-2-loc-3 city-2-loc-8) 50)
  ; 1643,425 -> 1540,468
  (road city-2-loc-8 city-2-loc-4)
  (= (road-length city-2-loc-8 city-2-loc-4) 12)
  (= (fuel-demand city-2-loc-8 city-2-loc-4) 23)
  ; 1540,468 -> 1643,425
  (road city-2-loc-4 city-2-loc-8)
  (= (road-length city-2-loc-4 city-2-loc-8) 12)
  (= (fuel-demand city-2-loc-4 city-2-loc-8) 23)
  ; 1643,425 -> 1841,505
  (road city-2-loc-8 city-2-loc-5)
  (= (road-length city-2-loc-8 city-2-loc-5) 22)
  (= (fuel-demand city-2-loc-8 city-2-loc-5) 43)
  ; 1841,505 -> 1643,425
  (road city-2-loc-5 city-2-loc-8)
  (= (road-length city-2-loc-5 city-2-loc-8) 22)
  (= (fuel-demand city-2-loc-5 city-2-loc-8) 43)
  ; 1643,425 -> 1484,598
  (road city-2-loc-8 city-2-loc-6)
  (= (road-length city-2-loc-8 city-2-loc-6) 24)
  (= (fuel-demand city-2-loc-8 city-2-loc-6) 47)
  ; 1484,598 -> 1643,425
  (road city-2-loc-6 city-2-loc-8)
  (= (road-length city-2-loc-6 city-2-loc-8) 24)
  (= (fuel-demand city-2-loc-6 city-2-loc-8) 47)
  ; 1643,425 -> 1520,381
  (road city-2-loc-8 city-2-loc-7)
  (= (road-length city-2-loc-8 city-2-loc-7) 14)
  (= (fuel-demand city-2-loc-8 city-2-loc-7) 27)
  ; 1520,381 -> 1643,425
  (road city-2-loc-7 city-2-loc-8)
  (= (road-length city-2-loc-7 city-2-loc-8) 14)
  (= (fuel-demand city-2-loc-7 city-2-loc-8) 27)
  ; 1676,519 -> 1540,468
  (road city-2-loc-9 city-2-loc-4)
  (= (road-length city-2-loc-9 city-2-loc-4) 15)
  (= (fuel-demand city-2-loc-9 city-2-loc-4) 29)
  ; 1540,468 -> 1676,519
  (road city-2-loc-4 city-2-loc-9)
  (= (road-length city-2-loc-4 city-2-loc-9) 15)
  (= (fuel-demand city-2-loc-4 city-2-loc-9) 29)
  ; 1676,519 -> 1841,505
  (road city-2-loc-9 city-2-loc-5)
  (= (road-length city-2-loc-9 city-2-loc-5) 17)
  (= (fuel-demand city-2-loc-9 city-2-loc-5) 34)
  ; 1841,505 -> 1676,519
  (road city-2-loc-5 city-2-loc-9)
  (= (road-length city-2-loc-5 city-2-loc-9) 17)
  (= (fuel-demand city-2-loc-5 city-2-loc-9) 34)
  ; 1676,519 -> 1484,598
  (road city-2-loc-9 city-2-loc-6)
  (= (road-length city-2-loc-9 city-2-loc-6) 21)
  (= (fuel-demand city-2-loc-9 city-2-loc-6) 42)
  ; 1484,598 -> 1676,519
  (road city-2-loc-6 city-2-loc-9)
  (= (road-length city-2-loc-6 city-2-loc-9) 21)
  (= (fuel-demand city-2-loc-6 city-2-loc-9) 42)
  ; 1676,519 -> 1520,381
  (road city-2-loc-9 city-2-loc-7)
  (= (road-length city-2-loc-9 city-2-loc-7) 21)
  (= (fuel-demand city-2-loc-9 city-2-loc-7) 42)
  ; 1520,381 -> 1676,519
  (road city-2-loc-7 city-2-loc-9)
  (= (road-length city-2-loc-7 city-2-loc-9) 21)
  (= (fuel-demand city-2-loc-7 city-2-loc-9) 42)
  ; 1676,519 -> 1643,425
  (road city-2-loc-9 city-2-loc-8)
  (= (road-length city-2-loc-9 city-2-loc-8) 10)
  (= (fuel-demand city-2-loc-9 city-2-loc-8) 20)
  ; 1643,425 -> 1676,519
  (road city-2-loc-8 city-2-loc-9)
  (= (road-length city-2-loc-8 city-2-loc-9) 10)
  (= (fuel-demand city-2-loc-8 city-2-loc-9) 20)
  ; 1449,192 -> 1621,166
  (road city-2-loc-10 city-2-loc-1)
  (= (road-length city-2-loc-10 city-2-loc-1) 18)
  (= (fuel-demand city-2-loc-10 city-2-loc-1) 35)
  ; 1621,166 -> 1449,192
  (road city-2-loc-1 city-2-loc-10)
  (= (road-length city-2-loc-1 city-2-loc-10) 18)
  (= (fuel-demand city-2-loc-1 city-2-loc-10) 35)
  ; 1449,192 -> 1520,381
  (road city-2-loc-10 city-2-loc-7)
  (= (road-length city-2-loc-10 city-2-loc-7) 21)
  (= (fuel-demand city-2-loc-10 city-2-loc-7) 41)
  ; 1520,381 -> 1449,192
  (road city-2-loc-7 city-2-loc-10)
  (= (road-length city-2-loc-7 city-2-loc-10) 21)
  (= (fuel-demand city-2-loc-7 city-2-loc-10) 41)
  ; 2000,97 -> 1904,169
  (road city-2-loc-11 city-2-loc-2)
  (= (road-length city-2-loc-11 city-2-loc-2) 12)
  (= (fuel-demand city-2-loc-11 city-2-loc-2) 24)
  ; 1904,169 -> 2000,97
  (road city-2-loc-2 city-2-loc-11)
  (= (road-length city-2-loc-2 city-2-loc-11) 12)
  (= (fuel-demand city-2-loc-2 city-2-loc-11) 24)
  ; 1448,355 -> 1621,166
  (road city-2-loc-12 city-2-loc-1)
  (= (road-length city-2-loc-12 city-2-loc-1) 26)
  (= (fuel-demand city-2-loc-12 city-2-loc-1) 52)
  ; 1621,166 -> 1448,355
  (road city-2-loc-1 city-2-loc-12)
  (= (road-length city-2-loc-1 city-2-loc-12) 26)
  (= (fuel-demand city-2-loc-1 city-2-loc-12) 52)
  ; 1448,355 -> 1540,468
  (road city-2-loc-12 city-2-loc-4)
  (= (road-length city-2-loc-12 city-2-loc-4) 15)
  (= (fuel-demand city-2-loc-12 city-2-loc-4) 30)
  ; 1540,468 -> 1448,355
  (road city-2-loc-4 city-2-loc-12)
  (= (road-length city-2-loc-4 city-2-loc-12) 15)
  (= (fuel-demand city-2-loc-4 city-2-loc-12) 30)
  ; 1448,355 -> 1484,598
  (road city-2-loc-12 city-2-loc-6)
  (= (road-length city-2-loc-12 city-2-loc-6) 25)
  (= (fuel-demand city-2-loc-12 city-2-loc-6) 50)
  ; 1484,598 -> 1448,355
  (road city-2-loc-6 city-2-loc-12)
  (= (road-length city-2-loc-6 city-2-loc-12) 25)
  (= (fuel-demand city-2-loc-6 city-2-loc-12) 50)
  ; 1448,355 -> 1520,381
  (road city-2-loc-12 city-2-loc-7)
  (= (road-length city-2-loc-12 city-2-loc-7) 8)
  (= (fuel-demand city-2-loc-12 city-2-loc-7) 16)
  ; 1520,381 -> 1448,355
  (road city-2-loc-7 city-2-loc-12)
  (= (road-length city-2-loc-7 city-2-loc-12) 8)
  (= (fuel-demand city-2-loc-7 city-2-loc-12) 16)
  ; 1448,355 -> 1643,425
  (road city-2-loc-12 city-2-loc-8)
  (= (road-length city-2-loc-12 city-2-loc-8) 21)
  (= (fuel-demand city-2-loc-12 city-2-loc-8) 42)
  ; 1643,425 -> 1448,355
  (road city-2-loc-8 city-2-loc-12)
  (= (road-length city-2-loc-8 city-2-loc-12) 21)
  (= (fuel-demand city-2-loc-8 city-2-loc-12) 42)
  ; 1448,355 -> 1449,192
  (road city-2-loc-12 city-2-loc-10)
  (= (road-length city-2-loc-12 city-2-loc-10) 17)
  (= (fuel-demand city-2-loc-12 city-2-loc-10) 33)
  ; 1449,192 -> 1448,355
  (road city-2-loc-10 city-2-loc-12)
  (= (road-length city-2-loc-10 city-2-loc-12) 17)
  (= (fuel-demand city-2-loc-10 city-2-loc-12) 33)
  ; 1542,691 -> 1540,468
  (road city-2-loc-13 city-2-loc-4)
  (= (road-length city-2-loc-13 city-2-loc-4) 23)
  (= (fuel-demand city-2-loc-13 city-2-loc-4) 45)
  ; 1540,468 -> 1542,691
  (road city-2-loc-4 city-2-loc-13)
  (= (road-length city-2-loc-4 city-2-loc-13) 23)
  (= (fuel-demand city-2-loc-4 city-2-loc-13) 45)
  ; 1542,691 -> 1484,598
  (road city-2-loc-13 city-2-loc-6)
  (= (road-length city-2-loc-13 city-2-loc-6) 11)
  (= (fuel-demand city-2-loc-13 city-2-loc-6) 22)
  ; 1484,598 -> 1542,691
  (road city-2-loc-6 city-2-loc-13)
  (= (road-length city-2-loc-6 city-2-loc-13) 11)
  (= (fuel-demand city-2-loc-6 city-2-loc-13) 22)
  ; 1542,691 -> 1676,519
  (road city-2-loc-13 city-2-loc-9)
  (= (road-length city-2-loc-13 city-2-loc-9) 22)
  (= (fuel-demand city-2-loc-13 city-2-loc-9) 44)
  ; 1676,519 -> 1542,691
  (road city-2-loc-9 city-2-loc-13)
  (= (road-length city-2-loc-9 city-2-loc-13) 22)
  (= (fuel-demand city-2-loc-9 city-2-loc-13) 44)
  ; 651,181 <-> 1449,192
  (road city-1-loc-12 city-2-loc-10)
  (= (road-length city-1-loc-12 city-2-loc-10) 80)
  (= (fuel-demand city-1-loc-12 city-2-loc-10) 40)
  (road city-2-loc-10 city-1-loc-12)
  (= (road-length city-2-loc-10 city-1-loc-12) 80)
  (= (fuel-demand city-2-loc-10 city-1-loc-12) 40)
  (has-petrol-station city-1-loc-12)
  (has-petrol-station city-2-loc-10)
  (at package-1 city-1-loc-4)
  (= (package-size package-1) 63)
  (at package-2 city-1-loc-5)
  (= (package-size package-2) 21)
  (at package-3 city-1-loc-13)
  (= (package-size package-3) 87)
  (at package-4 city-1-loc-8)
  (= (package-size package-4) 61)
  (at package-5 city-1-loc-5)
  (= (package-size package-5) 46)
  (at package-6 city-1-loc-3)
  (= (package-size package-6) 84)
  (at package-7 city-1-loc-8)
  (= (package-size package-7) 77)
  (at package-8 city-1-loc-12)
  (= (package-size package-8) 7)
  (at package-9 city-1-loc-5)
  (= (package-size package-9) 50)
  (at package-10 city-1-loc-6)
  (= (package-size package-10) 85)
  (at truck-1 city-2-loc-12)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 598)
  (= (fuel-max truck-1) 598)
  (at truck-2 city-2-loc-1)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 598)
  (= (fuel-max truck-2) 598)
  (at truck-3 city-2-loc-9)
  (ready-loading truck-3)
  (= (capacity truck-3) 100)
  (= (fuel-left truck-3) 598)
  (= (fuel-max truck-3) 598)
 )
 (:goal (and
  (at package-1 city-2-loc-10)
  (at package-2 city-2-loc-8)
  (at package-3 city-2-loc-5)
  (at package-4 city-2-loc-13)
  (at package-5 city-2-loc-3)
  (at package-6 city-2-loc-3)
  (at package-7 city-2-loc-6)
  (at package-8 city-2-loc-8)
  (at package-9 city-2-loc-10)
  (at package-10 city-2-loc-7)
 ))
 (:metric minimize (total-time))
)
