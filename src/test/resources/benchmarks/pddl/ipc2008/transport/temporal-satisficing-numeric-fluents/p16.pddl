; Transport p11-20-two-cities-15nodes-700size-4degree-70mindistance-4trucks-12packages-2008seed

(define (problem transport-p11-20-two-cities-15nodes-700size-4degree-70mindistance-4trucks-12packages-2008seed)
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
  city-1-loc-14 - location
  city-2-loc-14 - location
  city-1-loc-15 - location
  city-2-loc-15 - location
  truck-1 - vehicle
  truck-2 - vehicle
  truck-3 - vehicle
  truck-4 - vehicle
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
  package-11 - package
  package-12 - package
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
  ; 562,601 -> 623,380
  (road city-1-loc-14 city-1-loc-1)
  (= (road-length city-1-loc-14 city-1-loc-1) 23)
  (= (fuel-demand city-1-loc-14 city-1-loc-1) 46)
  ; 623,380 -> 562,601
  (road city-1-loc-1 city-1-loc-14)
  (= (road-length city-1-loc-1 city-1-loc-14) 23)
  (= (fuel-demand city-1-loc-1 city-1-loc-14) 46)
  ; 562,601 -> 638,559
  (road city-1-loc-14 city-1-loc-4)
  (= (road-length city-1-loc-14 city-1-loc-4) 9)
  (= (fuel-demand city-1-loc-14 city-1-loc-4) 18)
  ; 638,559 -> 562,601
  (road city-1-loc-4 city-1-loc-14)
  (= (road-length city-1-loc-4 city-1-loc-14) 9)
  (= (fuel-demand city-1-loc-4 city-1-loc-14) 18)
  ; 562,601 -> 684,629
  (road city-1-loc-14 city-1-loc-5)
  (= (road-length city-1-loc-14 city-1-loc-5) 13)
  (= (fuel-demand city-1-loc-14 city-1-loc-5) 25)
  ; 684,629 -> 562,601
  (road city-1-loc-5 city-1-loc-14)
  (= (road-length city-1-loc-5 city-1-loc-14) 13)
  (= (fuel-demand city-1-loc-5 city-1-loc-14) 25)
  ; 562,601 -> 519,379
  (road city-1-loc-14 city-1-loc-7)
  (= (road-length city-1-loc-14 city-1-loc-7) 23)
  (= (fuel-demand city-1-loc-14 city-1-loc-7) 46)
  ; 519,379 -> 562,601
  (road city-1-loc-7 city-1-loc-14)
  (= (road-length city-1-loc-7 city-1-loc-14) 23)
  (= (fuel-demand city-1-loc-7 city-1-loc-14) 46)
  ; 562,601 -> 395,548
  (road city-1-loc-14 city-1-loc-8)
  (= (road-length city-1-loc-14 city-1-loc-8) 18)
  (= (fuel-demand city-1-loc-14 city-1-loc-8) 35)
  ; 395,548 -> 562,601
  (road city-1-loc-8 city-1-loc-14)
  (= (road-length city-1-loc-8 city-1-loc-14) 18)
  (= (fuel-demand city-1-loc-8 city-1-loc-14) 35)
  ; 184,397 -> 191,297
  (road city-1-loc-15 city-1-loc-9)
  (= (road-length city-1-loc-15 city-1-loc-9) 10)
  (= (fuel-demand city-1-loc-15 city-1-loc-9) 20)
  ; 191,297 -> 184,397
  (road city-1-loc-9 city-1-loc-15)
  (= (road-length city-1-loc-9 city-1-loc-15) 10)
  (= (fuel-demand city-1-loc-9 city-1-loc-15) 20)
  ; 184,397 -> 396,386
  (road city-1-loc-15 city-1-loc-10)
  (= (road-length city-1-loc-15 city-1-loc-10) 22)
  (= (fuel-demand city-1-loc-15 city-1-loc-10) 43)
  ; 396,386 -> 184,397
  (road city-1-loc-10 city-1-loc-15)
  (= (road-length city-1-loc-10 city-1-loc-15) 22)
  (= (fuel-demand city-1-loc-10 city-1-loc-15) 43)
  ; 184,397 -> 121,450
  (road city-1-loc-15 city-1-loc-11)
  (= (road-length city-1-loc-15 city-1-loc-11) 9)
  (= (fuel-demand city-1-loc-15 city-1-loc-11) 17)
  ; 121,450 -> 184,397
  (road city-1-loc-11 city-1-loc-15)
  (= (road-length city-1-loc-11 city-1-loc-15) 9)
  (= (fuel-demand city-1-loc-11 city-1-loc-15) 17)
  ; 184,397 -> 39,424
  (road city-1-loc-15 city-1-loc-13)
  (= (road-length city-1-loc-15 city-1-loc-13) 15)
  (= (fuel-demand city-1-loc-15 city-1-loc-13) 30)
  ; 39,424 -> 184,397
  (road city-1-loc-13 city-1-loc-15)
  (= (road-length city-1-loc-13 city-1-loc-15) 15)
  (= (fuel-demand city-1-loc-13 city-1-loc-15) 30)
  ; 1571,242 -> 1580,3
  (road city-2-loc-2 city-2-loc-1)
  (= (road-length city-2-loc-2 city-2-loc-1) 24)
  (= (fuel-demand city-2-loc-2 city-2-loc-1) 48)
  ; 1580,3 -> 1571,242
  (road city-2-loc-1 city-2-loc-2)
  (= (road-length city-2-loc-1 city-2-loc-2) 24)
  (= (fuel-demand city-2-loc-1 city-2-loc-2) 48)
  ; 1642,104 -> 1580,3
  (road city-2-loc-4 city-2-loc-1)
  (= (road-length city-2-loc-4 city-2-loc-1) 12)
  (= (fuel-demand city-2-loc-4 city-2-loc-1) 24)
  ; 1580,3 -> 1642,104
  (road city-2-loc-1 city-2-loc-4)
  (= (road-length city-2-loc-1 city-2-loc-4) 12)
  (= (fuel-demand city-2-loc-1 city-2-loc-4) 24)
  ; 1642,104 -> 1571,242
  (road city-2-loc-4 city-2-loc-2)
  (= (road-length city-2-loc-4 city-2-loc-2) 16)
  (= (fuel-demand city-2-loc-4 city-2-loc-2) 31)
  ; 1571,242 -> 1642,104
  (road city-2-loc-2 city-2-loc-4)
  (= (road-length city-2-loc-2 city-2-loc-4) 16)
  (= (fuel-demand city-2-loc-2 city-2-loc-4) 31)
  ; 1635,332 -> 1571,242
  (road city-2-loc-5 city-2-loc-2)
  (= (road-length city-2-loc-5 city-2-loc-2) 11)
  (= (fuel-demand city-2-loc-5 city-2-loc-2) 22)
  ; 1571,242 -> 1635,332
  (road city-2-loc-2 city-2-loc-5)
  (= (road-length city-2-loc-2 city-2-loc-5) 11)
  (= (fuel-demand city-2-loc-2 city-2-loc-5) 22)
  ; 1635,332 -> 1791,395
  (road city-2-loc-5 city-2-loc-3)
  (= (road-length city-2-loc-5 city-2-loc-3) 17)
  (= (fuel-demand city-2-loc-5 city-2-loc-3) 34)
  ; 1791,395 -> 1635,332
  (road city-2-loc-3 city-2-loc-5)
  (= (road-length city-2-loc-3 city-2-loc-5) 17)
  (= (fuel-demand city-2-loc-3 city-2-loc-5) 34)
  ; 1635,332 -> 1642,104
  (road city-2-loc-5 city-2-loc-4)
  (= (road-length city-2-loc-5 city-2-loc-4) 23)
  (= (fuel-demand city-2-loc-5 city-2-loc-4) 46)
  ; 1642,104 -> 1635,332
  (road city-2-loc-4 city-2-loc-5)
  (= (road-length city-2-loc-4 city-2-loc-5) 23)
  (= (fuel-demand city-2-loc-4 city-2-loc-5) 46)
  ; 1519,496 -> 1635,332
  (road city-2-loc-6 city-2-loc-5)
  (= (road-length city-2-loc-6 city-2-loc-5) 21)
  (= (fuel-demand city-2-loc-6 city-2-loc-5) 41)
  ; 1635,332 -> 1519,496
  (road city-2-loc-5 city-2-loc-6)
  (= (road-length city-2-loc-5 city-2-loc-6) 21)
  (= (fuel-demand city-2-loc-5 city-2-loc-6) 41)
  ; 1765,262 -> 1571,242
  (road city-2-loc-7 city-2-loc-2)
  (= (road-length city-2-loc-7 city-2-loc-2) 20)
  (= (fuel-demand city-2-loc-7 city-2-loc-2) 39)
  ; 1571,242 -> 1765,262
  (road city-2-loc-2 city-2-loc-7)
  (= (road-length city-2-loc-2 city-2-loc-7) 20)
  (= (fuel-demand city-2-loc-2 city-2-loc-7) 39)
  ; 1765,262 -> 1791,395
  (road city-2-loc-7 city-2-loc-3)
  (= (road-length city-2-loc-7 city-2-loc-3) 14)
  (= (fuel-demand city-2-loc-7 city-2-loc-3) 28)
  ; 1791,395 -> 1765,262
  (road city-2-loc-3 city-2-loc-7)
  (= (road-length city-2-loc-3 city-2-loc-7) 14)
  (= (fuel-demand city-2-loc-3 city-2-loc-7) 28)
  ; 1765,262 -> 1642,104
  (road city-2-loc-7 city-2-loc-4)
  (= (road-length city-2-loc-7 city-2-loc-4) 20)
  (= (fuel-demand city-2-loc-7 city-2-loc-4) 40)
  ; 1642,104 -> 1765,262
  (road city-2-loc-4 city-2-loc-7)
  (= (road-length city-2-loc-4 city-2-loc-7) 20)
  (= (fuel-demand city-2-loc-4 city-2-loc-7) 40)
  ; 1765,262 -> 1635,332
  (road city-2-loc-7 city-2-loc-5)
  (= (road-length city-2-loc-7 city-2-loc-5) 15)
  (= (fuel-demand city-2-loc-7 city-2-loc-5) 30)
  ; 1635,332 -> 1765,262
  (road city-2-loc-5 city-2-loc-7)
  (= (road-length city-2-loc-5 city-2-loc-7) 15)
  (= (fuel-demand city-2-loc-5 city-2-loc-7) 30)
  ; 1904,169 -> 1765,262
  (road city-2-loc-9 city-2-loc-7)
  (= (road-length city-2-loc-9 city-2-loc-7) 17)
  (= (fuel-demand city-2-loc-9 city-2-loc-7) 34)
  ; 1765,262 -> 1904,169
  (road city-2-loc-7 city-2-loc-9)
  (= (road-length city-2-loc-7 city-2-loc-9) 17)
  (= (fuel-demand city-2-loc-7 city-2-loc-9) 34)
  ; 1904,169 -> 1891,0
  (road city-2-loc-9 city-2-loc-8)
  (= (road-length city-2-loc-9 city-2-loc-8) 17)
  (= (fuel-demand city-2-loc-9 city-2-loc-8) 34)
  ; 1891,0 -> 1904,169
  (road city-2-loc-8 city-2-loc-9)
  (= (road-length city-2-loc-8 city-2-loc-9) 17)
  (= (fuel-demand city-2-loc-8 city-2-loc-9) 34)
  ; 1841,505 -> 1791,395
  (road city-2-loc-10 city-2-loc-3)
  (= (road-length city-2-loc-10 city-2-loc-3) 13)
  (= (fuel-demand city-2-loc-10 city-2-loc-3) 25)
  ; 1791,395 -> 1841,505
  (road city-2-loc-3 city-2-loc-10)
  (= (road-length city-2-loc-3 city-2-loc-10) 13)
  (= (fuel-demand city-2-loc-3 city-2-loc-10) 25)
  ; 1484,598 -> 1519,496
  (road city-2-loc-11 city-2-loc-6)
  (= (road-length city-2-loc-11 city-2-loc-6) 11)
  (= (fuel-demand city-2-loc-11 city-2-loc-6) 22)
  ; 1519,496 -> 1484,598
  (road city-2-loc-6 city-2-loc-11)
  (= (road-length city-2-loc-6 city-2-loc-11) 11)
  (= (fuel-demand city-2-loc-6 city-2-loc-11) 22)
  ; 1664,198 -> 1580,3
  (road city-2-loc-12 city-2-loc-1)
  (= (road-length city-2-loc-12 city-2-loc-1) 22)
  (= (fuel-demand city-2-loc-12 city-2-loc-1) 43)
  ; 1580,3 -> 1664,198
  (road city-2-loc-1 city-2-loc-12)
  (= (road-length city-2-loc-1 city-2-loc-12) 22)
  (= (fuel-demand city-2-loc-1 city-2-loc-12) 43)
  ; 1664,198 -> 1571,242
  (road city-2-loc-12 city-2-loc-2)
  (= (road-length city-2-loc-12 city-2-loc-2) 11)
  (= (fuel-demand city-2-loc-12 city-2-loc-2) 21)
  ; 1571,242 -> 1664,198
  (road city-2-loc-2 city-2-loc-12)
  (= (road-length city-2-loc-2 city-2-loc-12) 11)
  (= (fuel-demand city-2-loc-2 city-2-loc-12) 21)
  ; 1664,198 -> 1791,395
  (road city-2-loc-12 city-2-loc-3)
  (= (road-length city-2-loc-12 city-2-loc-3) 24)
  (= (fuel-demand city-2-loc-12 city-2-loc-3) 47)
  ; 1791,395 -> 1664,198
  (road city-2-loc-3 city-2-loc-12)
  (= (road-length city-2-loc-3 city-2-loc-12) 24)
  (= (fuel-demand city-2-loc-3 city-2-loc-12) 47)
  ; 1664,198 -> 1642,104
  (road city-2-loc-12 city-2-loc-4)
  (= (road-length city-2-loc-12 city-2-loc-4) 10)
  (= (fuel-demand city-2-loc-12 city-2-loc-4) 20)
  ; 1642,104 -> 1664,198
  (road city-2-loc-4 city-2-loc-12)
  (= (road-length city-2-loc-4 city-2-loc-12) 10)
  (= (fuel-demand city-2-loc-4 city-2-loc-12) 20)
  ; 1664,198 -> 1635,332
  (road city-2-loc-12 city-2-loc-5)
  (= (road-length city-2-loc-12 city-2-loc-5) 14)
  (= (fuel-demand city-2-loc-12 city-2-loc-5) 28)
  ; 1635,332 -> 1664,198
  (road city-2-loc-5 city-2-loc-12)
  (= (road-length city-2-loc-5 city-2-loc-12) 14)
  (= (fuel-demand city-2-loc-5 city-2-loc-12) 28)
  ; 1664,198 -> 1765,262
  (road city-2-loc-12 city-2-loc-7)
  (= (road-length city-2-loc-12 city-2-loc-7) 12)
  (= (fuel-demand city-2-loc-12 city-2-loc-7) 24)
  ; 1765,262 -> 1664,198
  (road city-2-loc-7 city-2-loc-12)
  (= (road-length city-2-loc-7 city-2-loc-12) 12)
  (= (fuel-demand city-2-loc-7 city-2-loc-12) 24)
  ; 1664,198 -> 1904,169
  (road city-2-loc-12 city-2-loc-9)
  (= (road-length city-2-loc-12 city-2-loc-9) 25)
  (= (fuel-demand city-2-loc-12 city-2-loc-9) 49)
  ; 1904,169 -> 1664,198
  (road city-2-loc-9 city-2-loc-12)
  (= (road-length city-2-loc-9 city-2-loc-12) 25)
  (= (fuel-demand city-2-loc-9 city-2-loc-12) 49)
  ; 1520,381 -> 1571,242
  (road city-2-loc-13 city-2-loc-2)
  (= (road-length city-2-loc-13 city-2-loc-2) 15)
  (= (fuel-demand city-2-loc-13 city-2-loc-2) 30)
  ; 1571,242 -> 1520,381
  (road city-2-loc-2 city-2-loc-13)
  (= (road-length city-2-loc-2 city-2-loc-13) 15)
  (= (fuel-demand city-2-loc-2 city-2-loc-13) 30)
  ; 1520,381 -> 1635,332
  (road city-2-loc-13 city-2-loc-5)
  (= (road-length city-2-loc-13 city-2-loc-5) 13)
  (= (fuel-demand city-2-loc-13 city-2-loc-5) 25)
  ; 1635,332 -> 1520,381
  (road city-2-loc-5 city-2-loc-13)
  (= (road-length city-2-loc-5 city-2-loc-13) 13)
  (= (fuel-demand city-2-loc-5 city-2-loc-13) 25)
  ; 1520,381 -> 1519,496
  (road city-2-loc-13 city-2-loc-6)
  (= (road-length city-2-loc-13 city-2-loc-6) 12)
  (= (fuel-demand city-2-loc-13 city-2-loc-6) 23)
  ; 1519,496 -> 1520,381
  (road city-2-loc-6 city-2-loc-13)
  (= (road-length city-2-loc-6 city-2-loc-13) 12)
  (= (fuel-demand city-2-loc-6 city-2-loc-13) 23)
  ; 1520,381 -> 1484,598
  (road city-2-loc-13 city-2-loc-11)
  (= (road-length city-2-loc-13 city-2-loc-11) 22)
  (= (fuel-demand city-2-loc-13 city-2-loc-11) 44)
  ; 1484,598 -> 1520,381
  (road city-2-loc-11 city-2-loc-13)
  (= (road-length city-2-loc-11 city-2-loc-13) 22)
  (= (fuel-demand city-2-loc-11 city-2-loc-13) 44)
  ; 1520,381 -> 1664,198
  (road city-2-loc-13 city-2-loc-12)
  (= (road-length city-2-loc-13 city-2-loc-12) 24)
  (= (fuel-demand city-2-loc-13 city-2-loc-12) 47)
  ; 1664,198 -> 1520,381
  (road city-2-loc-12 city-2-loc-13)
  (= (road-length city-2-loc-12 city-2-loc-13) 24)
  (= (fuel-demand city-2-loc-12 city-2-loc-13) 47)
  ; 1643,425 -> 1571,242
  (road city-2-loc-14 city-2-loc-2)
  (= (road-length city-2-loc-14 city-2-loc-2) 20)
  (= (fuel-demand city-2-loc-14 city-2-loc-2) 40)
  ; 1571,242 -> 1643,425
  (road city-2-loc-2 city-2-loc-14)
  (= (road-length city-2-loc-2 city-2-loc-14) 20)
  (= (fuel-demand city-2-loc-2 city-2-loc-14) 40)
  ; 1643,425 -> 1791,395
  (road city-2-loc-14 city-2-loc-3)
  (= (road-length city-2-loc-14 city-2-loc-3) 16)
  (= (fuel-demand city-2-loc-14 city-2-loc-3) 31)
  ; 1791,395 -> 1643,425
  (road city-2-loc-3 city-2-loc-14)
  (= (road-length city-2-loc-3 city-2-loc-14) 16)
  (= (fuel-demand city-2-loc-3 city-2-loc-14) 31)
  ; 1643,425 -> 1635,332
  (road city-2-loc-14 city-2-loc-5)
  (= (road-length city-2-loc-14 city-2-loc-5) 10)
  (= (fuel-demand city-2-loc-14 city-2-loc-5) 19)
  ; 1635,332 -> 1643,425
  (road city-2-loc-5 city-2-loc-14)
  (= (road-length city-2-loc-5 city-2-loc-14) 10)
  (= (fuel-demand city-2-loc-5 city-2-loc-14) 19)
  ; 1643,425 -> 1519,496
  (road city-2-loc-14 city-2-loc-6)
  (= (road-length city-2-loc-14 city-2-loc-6) 15)
  (= (fuel-demand city-2-loc-14 city-2-loc-6) 29)
  ; 1519,496 -> 1643,425
  (road city-2-loc-6 city-2-loc-14)
  (= (road-length city-2-loc-6 city-2-loc-14) 15)
  (= (fuel-demand city-2-loc-6 city-2-loc-14) 29)
  ; 1643,425 -> 1765,262
  (road city-2-loc-14 city-2-loc-7)
  (= (road-length city-2-loc-14 city-2-loc-7) 21)
  (= (fuel-demand city-2-loc-14 city-2-loc-7) 41)
  ; 1765,262 -> 1643,425
  (road city-2-loc-7 city-2-loc-14)
  (= (road-length city-2-loc-7 city-2-loc-14) 21)
  (= (fuel-demand city-2-loc-7 city-2-loc-14) 41)
  ; 1643,425 -> 1841,505
  (road city-2-loc-14 city-2-loc-10)
  (= (road-length city-2-loc-14 city-2-loc-10) 22)
  (= (fuel-demand city-2-loc-14 city-2-loc-10) 43)
  ; 1841,505 -> 1643,425
  (road city-2-loc-10 city-2-loc-14)
  (= (road-length city-2-loc-10 city-2-loc-14) 22)
  (= (fuel-demand city-2-loc-10 city-2-loc-14) 43)
  ; 1643,425 -> 1484,598
  (road city-2-loc-14 city-2-loc-11)
  (= (road-length city-2-loc-14 city-2-loc-11) 24)
  (= (fuel-demand city-2-loc-14 city-2-loc-11) 47)
  ; 1484,598 -> 1643,425
  (road city-2-loc-11 city-2-loc-14)
  (= (road-length city-2-loc-11 city-2-loc-14) 24)
  (= (fuel-demand city-2-loc-11 city-2-loc-14) 47)
  ; 1643,425 -> 1664,198
  (road city-2-loc-14 city-2-loc-12)
  (= (road-length city-2-loc-14 city-2-loc-12) 23)
  (= (fuel-demand city-2-loc-14 city-2-loc-12) 46)
  ; 1664,198 -> 1643,425
  (road city-2-loc-12 city-2-loc-14)
  (= (road-length city-2-loc-12 city-2-loc-14) 23)
  (= (fuel-demand city-2-loc-12 city-2-loc-14) 46)
  ; 1643,425 -> 1520,381
  (road city-2-loc-14 city-2-loc-13)
  (= (road-length city-2-loc-14 city-2-loc-13) 14)
  (= (fuel-demand city-2-loc-14 city-2-loc-13) 27)
  ; 1520,381 -> 1643,425
  (road city-2-loc-13 city-2-loc-14)
  (= (road-length city-2-loc-13 city-2-loc-14) 14)
  (= (fuel-demand city-2-loc-13 city-2-loc-14) 27)
  ; 1676,519 -> 1791,395
  (road city-2-loc-15 city-2-loc-3)
  (= (road-length city-2-loc-15 city-2-loc-3) 17)
  (= (fuel-demand city-2-loc-15 city-2-loc-3) 34)
  ; 1791,395 -> 1676,519
  (road city-2-loc-3 city-2-loc-15)
  (= (road-length city-2-loc-3 city-2-loc-15) 17)
  (= (fuel-demand city-2-loc-3 city-2-loc-15) 34)
  ; 1676,519 -> 1635,332
  (road city-2-loc-15 city-2-loc-5)
  (= (road-length city-2-loc-15 city-2-loc-5) 20)
  (= (fuel-demand city-2-loc-15 city-2-loc-5) 39)
  ; 1635,332 -> 1676,519
  (road city-2-loc-5 city-2-loc-15)
  (= (road-length city-2-loc-5 city-2-loc-15) 20)
  (= (fuel-demand city-2-loc-5 city-2-loc-15) 39)
  ; 1676,519 -> 1519,496
  (road city-2-loc-15 city-2-loc-6)
  (= (road-length city-2-loc-15 city-2-loc-6) 16)
  (= (fuel-demand city-2-loc-15 city-2-loc-6) 32)
  ; 1519,496 -> 1676,519
  (road city-2-loc-6 city-2-loc-15)
  (= (road-length city-2-loc-6 city-2-loc-15) 16)
  (= (fuel-demand city-2-loc-6 city-2-loc-15) 32)
  ; 1676,519 -> 1841,505
  (road city-2-loc-15 city-2-loc-10)
  (= (road-length city-2-loc-15 city-2-loc-10) 17)
  (= (fuel-demand city-2-loc-15 city-2-loc-10) 34)
  ; 1841,505 -> 1676,519
  (road city-2-loc-10 city-2-loc-15)
  (= (road-length city-2-loc-10 city-2-loc-15) 17)
  (= (fuel-demand city-2-loc-10 city-2-loc-15) 34)
  ; 1676,519 -> 1484,598
  (road city-2-loc-15 city-2-loc-11)
  (= (road-length city-2-loc-15 city-2-loc-11) 21)
  (= (fuel-demand city-2-loc-15 city-2-loc-11) 42)
  ; 1484,598 -> 1676,519
  (road city-2-loc-11 city-2-loc-15)
  (= (road-length city-2-loc-11 city-2-loc-15) 21)
  (= (fuel-demand city-2-loc-11 city-2-loc-15) 42)
  ; 1676,519 -> 1520,381
  (road city-2-loc-15 city-2-loc-13)
  (= (road-length city-2-loc-15 city-2-loc-13) 21)
  (= (fuel-demand city-2-loc-15 city-2-loc-13) 42)
  ; 1520,381 -> 1676,519
  (road city-2-loc-13 city-2-loc-15)
  (= (road-length city-2-loc-13 city-2-loc-15) 21)
  (= (fuel-demand city-2-loc-13 city-2-loc-15) 42)
  ; 1676,519 -> 1643,425
  (road city-2-loc-15 city-2-loc-14)
  (= (road-length city-2-loc-15 city-2-loc-14) 10)
  (= (fuel-demand city-2-loc-15 city-2-loc-14) 20)
  ; 1643,425 -> 1676,519
  (road city-2-loc-14 city-2-loc-15)
  (= (road-length city-2-loc-14 city-2-loc-15) 10)
  (= (fuel-demand city-2-loc-14 city-2-loc-15) 20)
  ; 684,629 <-> 1484,598
  (road city-1-loc-5 city-2-loc-11)
  (= (road-length city-1-loc-5 city-2-loc-11) 81)
  (= (fuel-demand city-1-loc-5 city-2-loc-11) 41)
  (road city-2-loc-11 city-1-loc-5)
  (= (road-length city-2-loc-11 city-1-loc-5) 81)
  (= (fuel-demand city-2-loc-11 city-1-loc-5) 41)
  (has-petrol-station city-1-loc-5)
  (has-petrol-station city-2-loc-11)
  (at package-1 city-1-loc-10)
  (= (package-size package-1) 67)
  (at package-2 city-1-loc-5)
  (= (package-size package-2) 55)
  (at package-3 city-1-loc-6)
  (= (package-size package-3) 25)
  (at package-4 city-1-loc-9)
  (= (package-size package-4) 77)
  (at package-5 city-1-loc-2)
  (= (package-size package-5) 28)
  (at package-6 city-1-loc-13)
  (= (package-size package-6) 14)
  (at package-7 city-1-loc-2)
  (= (package-size package-7) 51)
  (at package-8 city-1-loc-4)
  (= (package-size package-8) 99)
  (at package-9 city-1-loc-5)
  (= (package-size package-9) 63)
  (at package-10 city-1-loc-6)
  (= (package-size package-10) 21)
  (at package-11 city-1-loc-15)
  (= (package-size package-11) 87)
  (at package-12 city-1-loc-9)
  (= (package-size package-12) 61)
  (at truck-1 city-2-loc-6)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 600)
  (= (fuel-max truck-1) 600)
  (at truck-2 city-2-loc-7)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 600)
  (= (fuel-max truck-2) 600)
  (at truck-3 city-2-loc-3)
  (ready-loading truck-3)
  (= (capacity truck-3) 100)
  (= (fuel-left truck-3) 600)
  (= (fuel-max truck-3) 600)
  (at truck-4 city-2-loc-13)
  (ready-loading truck-4)
  (= (capacity truck-4) 100)
  (= (fuel-left truck-4) 600)
  (= (fuel-max truck-4) 600)
 )
 (:goal (and
  (at package-1 city-2-loc-9)
  (at package-2 city-2-loc-12)
  (at package-3 city-2-loc-14)
  (at package-4 city-2-loc-1)
  (at package-5 city-2-loc-5)
  (at package-6 city-2-loc-8)
  (at package-7 city-2-loc-7)
  (at package-8 city-2-loc-13)
  (at package-9 city-2-loc-14)
  (at package-10 city-2-loc-1)
  (at package-11 city-2-loc-10)
  (at package-12 city-2-loc-11)
 ))
 (:metric minimize (total-time))
)
