; Transport p11-20-two-cities-20nodes-700size-4degree-70mindistance-4trucks-16packages-2008seed

(define (problem transport-p11-20-two-cities-20nodes-700size-4degree-70mindistance-4trucks-16packages-2008seed)
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
  city-1-loc-16 - location
  city-2-loc-16 - location
  city-1-loc-17 - location
  city-2-loc-17 - location
  city-1-loc-18 - location
  city-2-loc-18 - location
  city-1-loc-19 - location
  city-2-loc-19 - location
  city-1-loc-20 - location
  city-2-loc-20 - location
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
  package-13 - package
  package-14 - package
  package-15 - package
  package-16 - package
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
  ; 396,386 -> 523,269
  (road city-1-loc-10 city-1-loc-3)
  (= (road-length city-1-loc-10 city-1-loc-3) 18)
  (= (fuel-demand city-1-loc-10 city-1-loc-3) 35)
  ; 523,269 -> 396,386
  (road city-1-loc-3 city-1-loc-10)
  (= (road-length city-1-loc-3 city-1-loc-10) 18)
  (= (fuel-demand city-1-loc-3 city-1-loc-10) 35)
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
  ; 90,554 -> 121,450
  (road city-1-loc-16 city-1-loc-11)
  (= (road-length city-1-loc-16 city-1-loc-11) 11)
  (= (fuel-demand city-1-loc-16 city-1-loc-11) 22)
  ; 121,450 -> 90,554
  (road city-1-loc-11 city-1-loc-16)
  (= (road-length city-1-loc-11 city-1-loc-16) 11)
  (= (fuel-demand city-1-loc-11 city-1-loc-16) 22)
  ; 90,554 -> 39,424
  (road city-1-loc-16 city-1-loc-13)
  (= (road-length city-1-loc-16 city-1-loc-13) 14)
  (= (fuel-demand city-1-loc-16 city-1-loc-13) 28)
  ; 39,424 -> 90,554
  (road city-1-loc-13 city-1-loc-16)
  (= (road-length city-1-loc-13 city-1-loc-16) 14)
  (= (fuel-demand city-1-loc-13 city-1-loc-16) 28)
  ; 90,554 -> 184,397
  (road city-1-loc-16 city-1-loc-15)
  (= (road-length city-1-loc-16 city-1-loc-15) 19)
  (= (fuel-demand city-1-loc-16 city-1-loc-15) 37)
  ; 184,397 -> 90,554
  (road city-1-loc-15 city-1-loc-16)
  (= (road-length city-1-loc-15 city-1-loc-16) 19)
  (= (fuel-demand city-1-loc-15 city-1-loc-16) 37)
  ; 298,494 -> 395,548
  (road city-1-loc-17 city-1-loc-8)
  (= (road-length city-1-loc-17 city-1-loc-8) 12)
  (= (fuel-demand city-1-loc-17 city-1-loc-8) 23)
  ; 395,548 -> 298,494
  (road city-1-loc-8 city-1-loc-17)
  (= (road-length city-1-loc-8 city-1-loc-17) 12)
  (= (fuel-demand city-1-loc-8 city-1-loc-17) 23)
  ; 298,494 -> 396,386
  (road city-1-loc-17 city-1-loc-10)
  (= (road-length city-1-loc-17 city-1-loc-10) 15)
  (= (fuel-demand city-1-loc-17 city-1-loc-10) 30)
  ; 396,386 -> 298,494
  (road city-1-loc-10 city-1-loc-17)
  (= (road-length city-1-loc-10 city-1-loc-17) 15)
  (= (fuel-demand city-1-loc-10 city-1-loc-17) 30)
  ; 298,494 -> 121,450
  (road city-1-loc-17 city-1-loc-11)
  (= (road-length city-1-loc-17 city-1-loc-11) 19)
  (= (fuel-demand city-1-loc-17 city-1-loc-11) 37)
  ; 121,450 -> 298,494
  (road city-1-loc-11 city-1-loc-17)
  (= (road-length city-1-loc-11 city-1-loc-17) 19)
  (= (fuel-demand city-1-loc-11 city-1-loc-17) 37)
  ; 298,494 -> 184,397
  (road city-1-loc-17 city-1-loc-15)
  (= (road-length city-1-loc-17 city-1-loc-15) 15)
  (= (fuel-demand city-1-loc-17 city-1-loc-15) 30)
  ; 184,397 -> 298,494
  (road city-1-loc-15 city-1-loc-17)
  (= (road-length city-1-loc-15 city-1-loc-17) 15)
  (= (fuel-demand city-1-loc-15 city-1-loc-17) 30)
  ; 25,258 -> 191,297
  (road city-1-loc-18 city-1-loc-9)
  (= (road-length city-1-loc-18 city-1-loc-9) 18)
  (= (fuel-demand city-1-loc-18 city-1-loc-9) 35)
  ; 191,297 -> 25,258
  (road city-1-loc-9 city-1-loc-18)
  (= (road-length city-1-loc-9 city-1-loc-18) 18)
  (= (fuel-demand city-1-loc-9 city-1-loc-18) 35)
  ; 25,258 -> 39,424
  (road city-1-loc-18 city-1-loc-13)
  (= (road-length city-1-loc-18 city-1-loc-13) 17)
  (= (fuel-demand city-1-loc-18 city-1-loc-13) 34)
  ; 39,424 -> 25,258
  (road city-1-loc-13 city-1-loc-18)
  (= (road-length city-1-loc-13 city-1-loc-18) 17)
  (= (fuel-demand city-1-loc-13 city-1-loc-18) 34)
  ; 25,258 -> 184,397
  (road city-1-loc-18 city-1-loc-15)
  (= (road-length city-1-loc-18 city-1-loc-15) 22)
  (= (fuel-demand city-1-loc-18 city-1-loc-15) 43)
  ; 184,397 -> 25,258
  (road city-1-loc-15 city-1-loc-18)
  (= (road-length city-1-loc-15 city-1-loc-18) 22)
  (= (fuel-demand city-1-loc-15 city-1-loc-18) 43)
  ; 564,12 -> 651,181
  (road city-1-loc-19 city-1-loc-12)
  (= (road-length city-1-loc-19 city-1-loc-12) 19)
  (= (fuel-demand city-1-loc-19 city-1-loc-12) 38)
  ; 651,181 -> 564,12
  (road city-1-loc-12 city-1-loc-19)
  (= (road-length city-1-loc-12 city-1-loc-19) 19)
  (= (fuel-demand city-1-loc-12 city-1-loc-19) 38)
  ; 96,76 -> 269,35
  (road city-1-loc-20 city-1-loc-2)
  (= (road-length city-1-loc-20 city-1-loc-2) 18)
  (= (fuel-demand city-1-loc-20 city-1-loc-2) 36)
  ; 269,35 -> 96,76
  (road city-1-loc-2 city-1-loc-20)
  (= (road-length city-1-loc-2 city-1-loc-20) 18)
  (= (fuel-demand city-1-loc-2 city-1-loc-20) 36)
  ; 96,76 -> 25,258
  (road city-1-loc-20 city-1-loc-18)
  (= (road-length city-1-loc-20 city-1-loc-18) 20)
  (= (fuel-demand city-1-loc-20 city-1-loc-18) 39)
  ; 25,258 -> 96,76
  (road city-1-loc-18 city-1-loc-20)
  (= (road-length city-1-loc-18 city-1-loc-20) 20)
  (= (fuel-demand city-1-loc-18 city-1-loc-20) 39)
  ; 1440,539 -> 1562,617
  (road city-2-loc-7 city-2-loc-3)
  (= (road-length city-2-loc-7 city-2-loc-3) 15)
  (= (fuel-demand city-2-loc-7 city-2-loc-3) 29)
  ; 1562,617 -> 1440,539
  (road city-2-loc-3 city-2-loc-7)
  (= (road-length city-2-loc-3 city-2-loc-7) 15)
  (= (fuel-demand city-2-loc-3 city-2-loc-7) 29)
  ; 2091,141 -> 2092,320
  (road city-2-loc-8 city-2-loc-6)
  (= (road-length city-2-loc-8 city-2-loc-6) 18)
  (= (fuel-demand city-2-loc-8 city-2-loc-6) 36)
  ; 2092,320 -> 2091,141
  (road city-2-loc-6 city-2-loc-8)
  (= (road-length city-2-loc-6 city-2-loc-8) 18)
  (= (fuel-demand city-2-loc-6 city-2-loc-8) 36)
  ; 1812,528 -> 1989,606
  (road city-2-loc-9 city-2-loc-2)
  (= (road-length city-2-loc-9 city-2-loc-2) 20)
  (= (fuel-demand city-2-loc-9 city-2-loc-2) 39)
  ; 1989,606 -> 1812,528
  (road city-2-loc-2 city-2-loc-9)
  (= (road-length city-2-loc-2 city-2-loc-9) 20)
  (= (fuel-demand city-2-loc-2 city-2-loc-9) 39)
  ; 1437,107 -> 1409,203
  (road city-2-loc-10 city-2-loc-4)
  (= (road-length city-2-loc-10 city-2-loc-4) 10)
  (= (fuel-demand city-2-loc-10 city-2-loc-4) 20)
  ; 1409,203 -> 1437,107
  (road city-2-loc-4 city-2-loc-10)
  (= (road-length city-2-loc-4 city-2-loc-10) 10)
  (= (fuel-demand city-2-loc-4 city-2-loc-10) 20)
  ; 1653,603 -> 1562,617
  (road city-2-loc-11 city-2-loc-3)
  (= (road-length city-2-loc-11 city-2-loc-3) 10)
  (= (fuel-demand city-2-loc-11 city-2-loc-3) 19)
  ; 1562,617 -> 1653,603
  (road city-2-loc-3 city-2-loc-11)
  (= (road-length city-2-loc-3 city-2-loc-11) 10)
  (= (fuel-demand city-2-loc-3 city-2-loc-11) 19)
  ; 1653,603 -> 1812,528
  (road city-2-loc-11 city-2-loc-9)
  (= (road-length city-2-loc-11 city-2-loc-9) 18)
  (= (fuel-demand city-2-loc-11 city-2-loc-9) 36)
  ; 1812,528 -> 1653,603
  (road city-2-loc-9 city-2-loc-11)
  (= (road-length city-2-loc-9 city-2-loc-11) 18)
  (= (fuel-demand city-2-loc-9 city-2-loc-11) 36)
  ; 1404,42 -> 1409,203
  (road city-2-loc-12 city-2-loc-4)
  (= (road-length city-2-loc-12 city-2-loc-4) 17)
  (= (fuel-demand city-2-loc-12 city-2-loc-4) 33)
  ; 1409,203 -> 1404,42
  (road city-2-loc-4 city-2-loc-12)
  (= (road-length city-2-loc-4 city-2-loc-12) 17)
  (= (fuel-demand city-2-loc-4 city-2-loc-12) 33)
  ; 1404,42 -> 1437,107
  (road city-2-loc-12 city-2-loc-10)
  (= (road-length city-2-loc-12 city-2-loc-10) 8)
  (= (fuel-demand city-2-loc-12 city-2-loc-10) 15)
  ; 1437,107 -> 1404,42
  (road city-2-loc-10 city-2-loc-12)
  (= (road-length city-2-loc-10 city-2-loc-12) 8)
  (= (fuel-demand city-2-loc-10 city-2-loc-12) 15)
  ; 1861,348 -> 1674,303
  (road city-2-loc-13 city-2-loc-1)
  (= (road-length city-2-loc-13 city-2-loc-1) 20)
  (= (fuel-demand city-2-loc-13 city-2-loc-1) 39)
  ; 1674,303 -> 1861,348
  (road city-2-loc-1 city-2-loc-13)
  (= (road-length city-2-loc-1 city-2-loc-13) 20)
  (= (fuel-demand city-2-loc-1 city-2-loc-13) 39)
  ; 1861,348 -> 1812,528
  (road city-2-loc-13 city-2-loc-9)
  (= (road-length city-2-loc-13 city-2-loc-9) 19)
  (= (fuel-demand city-2-loc-13 city-2-loc-9) 38)
  ; 1812,528 -> 1861,348
  (road city-2-loc-9 city-2-loc-13)
  (= (road-length city-2-loc-9 city-2-loc-13) 19)
  (= (fuel-demand city-2-loc-9 city-2-loc-13) 38)
  ; 1580,3 -> 1437,107
  (road city-2-loc-14 city-2-loc-10)
  (= (road-length city-2-loc-14 city-2-loc-10) 18)
  (= (fuel-demand city-2-loc-14 city-2-loc-10) 36)
  ; 1437,107 -> 1580,3
  (road city-2-loc-10 city-2-loc-14)
  (= (road-length city-2-loc-10 city-2-loc-14) 18)
  (= (fuel-demand city-2-loc-10 city-2-loc-14) 36)
  ; 1580,3 -> 1404,42
  (road city-2-loc-14 city-2-loc-12)
  (= (road-length city-2-loc-14 city-2-loc-12) 18)
  (= (fuel-demand city-2-loc-14 city-2-loc-12) 36)
  ; 1404,42 -> 1580,3
  (road city-2-loc-12 city-2-loc-14)
  (= (road-length city-2-loc-12 city-2-loc-14) 18)
  (= (fuel-demand city-2-loc-12 city-2-loc-14) 36)
  ; 1571,242 -> 1674,303
  (road city-2-loc-15 city-2-loc-1)
  (= (road-length city-2-loc-15 city-2-loc-1) 12)
  (= (fuel-demand city-2-loc-15 city-2-loc-1) 24)
  ; 1674,303 -> 1571,242
  (road city-2-loc-1 city-2-loc-15)
  (= (road-length city-2-loc-1 city-2-loc-15) 12)
  (= (fuel-demand city-2-loc-1 city-2-loc-15) 24)
  ; 1571,242 -> 1409,203
  (road city-2-loc-15 city-2-loc-4)
  (= (road-length city-2-loc-15 city-2-loc-4) 17)
  (= (fuel-demand city-2-loc-15 city-2-loc-4) 34)
  ; 1409,203 -> 1571,242
  (road city-2-loc-4 city-2-loc-15)
  (= (road-length city-2-loc-4 city-2-loc-15) 17)
  (= (fuel-demand city-2-loc-4 city-2-loc-15) 34)
  ; 1571,242 -> 1437,107
  (road city-2-loc-15 city-2-loc-10)
  (= (road-length city-2-loc-15 city-2-loc-10) 19)
  (= (fuel-demand city-2-loc-15 city-2-loc-10) 38)
  ; 1437,107 -> 1571,242
  (road city-2-loc-10 city-2-loc-15)
  (= (road-length city-2-loc-10 city-2-loc-15) 19)
  (= (fuel-demand city-2-loc-10 city-2-loc-15) 38)
  ; 1791,395 -> 1674,303
  (road city-2-loc-16 city-2-loc-1)
  (= (road-length city-2-loc-16 city-2-loc-1) 15)
  (= (fuel-demand city-2-loc-16 city-2-loc-1) 30)
  ; 1674,303 -> 1791,395
  (road city-2-loc-1 city-2-loc-16)
  (= (road-length city-2-loc-1 city-2-loc-16) 15)
  (= (fuel-demand city-2-loc-1 city-2-loc-16) 30)
  ; 1791,395 -> 1812,528
  (road city-2-loc-16 city-2-loc-9)
  (= (road-length city-2-loc-16 city-2-loc-9) 14)
  (= (fuel-demand city-2-loc-16 city-2-loc-9) 27)
  ; 1812,528 -> 1791,395
  (road city-2-loc-9 city-2-loc-16)
  (= (road-length city-2-loc-9 city-2-loc-16) 14)
  (= (fuel-demand city-2-loc-9 city-2-loc-16) 27)
  ; 1791,395 -> 1861,348
  (road city-2-loc-16 city-2-loc-13)
  (= (road-length city-2-loc-16 city-2-loc-13) 9)
  (= (fuel-demand city-2-loc-16 city-2-loc-13) 17)
  ; 1861,348 -> 1791,395
  (road city-2-loc-13 city-2-loc-16)
  (= (road-length city-2-loc-13 city-2-loc-16) 9)
  (= (fuel-demand city-2-loc-13 city-2-loc-16) 17)
  ; 1642,104 -> 1674,303
  (road city-2-loc-17 city-2-loc-1)
  (= (road-length city-2-loc-17 city-2-loc-1) 21)
  (= (fuel-demand city-2-loc-17 city-2-loc-1) 41)
  ; 1674,303 -> 1642,104
  (road city-2-loc-1 city-2-loc-17)
  (= (road-length city-2-loc-1 city-2-loc-17) 21)
  (= (fuel-demand city-2-loc-1 city-2-loc-17) 41)
  ; 1642,104 -> 1437,107
  (road city-2-loc-17 city-2-loc-10)
  (= (road-length city-2-loc-17 city-2-loc-10) 21)
  (= (fuel-demand city-2-loc-17 city-2-loc-10) 41)
  ; 1437,107 -> 1642,104
  (road city-2-loc-10 city-2-loc-17)
  (= (road-length city-2-loc-10 city-2-loc-17) 21)
  (= (fuel-demand city-2-loc-10 city-2-loc-17) 41)
  ; 1642,104 -> 1580,3
  (road city-2-loc-17 city-2-loc-14)
  (= (road-length city-2-loc-17 city-2-loc-14) 12)
  (= (fuel-demand city-2-loc-17 city-2-loc-14) 24)
  ; 1580,3 -> 1642,104
  (road city-2-loc-14 city-2-loc-17)
  (= (road-length city-2-loc-14 city-2-loc-17) 12)
  (= (fuel-demand city-2-loc-14 city-2-loc-17) 24)
  ; 1642,104 -> 1571,242
  (road city-2-loc-17 city-2-loc-15)
  (= (road-length city-2-loc-17 city-2-loc-15) 16)
  (= (fuel-demand city-2-loc-17 city-2-loc-15) 31)
  ; 1571,242 -> 1642,104
  (road city-2-loc-15 city-2-loc-17)
  (= (road-length city-2-loc-15 city-2-loc-17) 16)
  (= (fuel-demand city-2-loc-15 city-2-loc-17) 31)
  ; 1519,496 -> 1562,617
  (road city-2-loc-18 city-2-loc-3)
  (= (road-length city-2-loc-18 city-2-loc-3) 13)
  (= (fuel-demand city-2-loc-18 city-2-loc-3) 26)
  ; 1562,617 -> 1519,496
  (road city-2-loc-3 city-2-loc-18)
  (= (road-length city-2-loc-3 city-2-loc-18) 13)
  (= (fuel-demand city-2-loc-3 city-2-loc-18) 26)
  ; 1519,496 -> 1440,539
  (road city-2-loc-18 city-2-loc-7)
  (= (road-length city-2-loc-18 city-2-loc-7) 9)
  (= (fuel-demand city-2-loc-18 city-2-loc-7) 18)
  ; 1440,539 -> 1519,496
  (road city-2-loc-7 city-2-loc-18)
  (= (road-length city-2-loc-7 city-2-loc-18) 9)
  (= (fuel-demand city-2-loc-7 city-2-loc-18) 18)
  ; 1519,496 -> 1653,603
  (road city-2-loc-18 city-2-loc-11)
  (= (road-length city-2-loc-18 city-2-loc-11) 18)
  (= (fuel-demand city-2-loc-18 city-2-loc-11) 35)
  ; 1653,603 -> 1519,496
  (road city-2-loc-11 city-2-loc-18)
  (= (road-length city-2-loc-11 city-2-loc-18) 18)
  (= (fuel-demand city-2-loc-11 city-2-loc-18) 35)
  ; 1765,262 -> 1674,303
  (road city-2-loc-19 city-2-loc-1)
  (= (road-length city-2-loc-19 city-2-loc-1) 10)
  (= (fuel-demand city-2-loc-19 city-2-loc-1) 20)
  ; 1674,303 -> 1765,262
  (road city-2-loc-1 city-2-loc-19)
  (= (road-length city-2-loc-1 city-2-loc-19) 10)
  (= (fuel-demand city-2-loc-1 city-2-loc-19) 20)
  ; 1765,262 -> 1861,348
  (road city-2-loc-19 city-2-loc-13)
  (= (road-length city-2-loc-19 city-2-loc-13) 13)
  (= (fuel-demand city-2-loc-19 city-2-loc-13) 26)
  ; 1861,348 -> 1765,262
  (road city-2-loc-13 city-2-loc-19)
  (= (road-length city-2-loc-13 city-2-loc-19) 13)
  (= (fuel-demand city-2-loc-13 city-2-loc-19) 26)
  ; 1765,262 -> 1571,242
  (road city-2-loc-19 city-2-loc-15)
  (= (road-length city-2-loc-19 city-2-loc-15) 20)
  (= (fuel-demand city-2-loc-19 city-2-loc-15) 39)
  ; 1571,242 -> 1765,262
  (road city-2-loc-15 city-2-loc-19)
  (= (road-length city-2-loc-15 city-2-loc-19) 20)
  (= (fuel-demand city-2-loc-15 city-2-loc-19) 39)
  ; 1765,262 -> 1791,395
  (road city-2-loc-19 city-2-loc-16)
  (= (road-length city-2-loc-19 city-2-loc-16) 14)
  (= (fuel-demand city-2-loc-19 city-2-loc-16) 28)
  ; 1791,395 -> 1765,262
  (road city-2-loc-16 city-2-loc-19)
  (= (road-length city-2-loc-16 city-2-loc-19) 14)
  (= (fuel-demand city-2-loc-16 city-2-loc-19) 28)
  ; 1765,262 -> 1642,104
  (road city-2-loc-19 city-2-loc-17)
  (= (road-length city-2-loc-19 city-2-loc-17) 20)
  (= (fuel-demand city-2-loc-19 city-2-loc-17) 40)
  ; 1642,104 -> 1765,262
  (road city-2-loc-17 city-2-loc-19)
  (= (road-length city-2-loc-17 city-2-loc-19) 20)
  (= (fuel-demand city-2-loc-17 city-2-loc-19) 40)
  ; 1904,169 -> 1877,5
  (road city-2-loc-20 city-2-loc-5)
  (= (road-length city-2-loc-20 city-2-loc-5) 17)
  (= (fuel-demand city-2-loc-20 city-2-loc-5) 34)
  ; 1877,5 -> 1904,169
  (road city-2-loc-5 city-2-loc-20)
  (= (road-length city-2-loc-5 city-2-loc-20) 17)
  (= (fuel-demand city-2-loc-5 city-2-loc-20) 34)
  ; 1904,169 -> 2091,141
  (road city-2-loc-20 city-2-loc-8)
  (= (road-length city-2-loc-20 city-2-loc-8) 19)
  (= (fuel-demand city-2-loc-20 city-2-loc-8) 38)
  ; 2091,141 -> 1904,169
  (road city-2-loc-8 city-2-loc-20)
  (= (road-length city-2-loc-8 city-2-loc-20) 19)
  (= (fuel-demand city-2-loc-8 city-2-loc-20) 38)
  ; 1904,169 -> 1861,348
  (road city-2-loc-20 city-2-loc-13)
  (= (road-length city-2-loc-20 city-2-loc-13) 19)
  (= (fuel-demand city-2-loc-20 city-2-loc-13) 37)
  ; 1861,348 -> 1904,169
  (road city-2-loc-13 city-2-loc-20)
  (= (road-length city-2-loc-13 city-2-loc-20) 19)
  (= (fuel-demand city-2-loc-13 city-2-loc-20) 37)
  ; 1904,169 -> 1765,262
  (road city-2-loc-20 city-2-loc-19)
  (= (road-length city-2-loc-20 city-2-loc-19) 17)
  (= (fuel-demand city-2-loc-20 city-2-loc-19) 34)
  ; 1765,262 -> 1904,169
  (road city-2-loc-19 city-2-loc-20)
  (= (road-length city-2-loc-19 city-2-loc-20) 17)
  (= (fuel-demand city-2-loc-19 city-2-loc-20) 34)
  ; 651,181 <-> 1409,203
  (road city-1-loc-12 city-2-loc-4)
  (= (road-length city-1-loc-12 city-2-loc-4) 76)
  (= (fuel-demand city-1-loc-12 city-2-loc-4) 38)
  (road city-2-loc-4 city-1-loc-12)
  (= (road-length city-2-loc-4 city-1-loc-12) 76)
  (= (fuel-demand city-2-loc-4 city-1-loc-12) 38)
  (has-petrol-station city-1-loc-12)
  (has-petrol-station city-2-loc-4)
  (at package-1 city-1-loc-10)
  (= (package-size package-1) 29)
  (at package-2 city-1-loc-5)
  (= (package-size package-2) 67)
  (at package-3 city-1-loc-13)
  (= (package-size package-3) 73)
  (at package-4 city-1-loc-3)
  (= (package-size package-4) 86)
  (at package-5 city-1-loc-8)
  (= (package-size package-5) 29)
  (at package-6 city-1-loc-4)
  (= (package-size package-6) 55)
  (at package-7 city-1-loc-7)
  (= (package-size package-7) 61)
  (at package-8 city-1-loc-8)
  (= (package-size package-8) 75)
  (at package-9 city-1-loc-13)
  (= (package-size package-9) 67)
  (at package-10 city-1-loc-7)
  (= (package-size package-10) 55)
  (at package-11 city-1-loc-8)
  (= (package-size package-11) 25)
  (at package-12 city-1-loc-12)
  (= (package-size package-12) 77)
  (at package-13 city-1-loc-2)
  (= (package-size package-13) 28)
  (at package-14 city-1-loc-18)
  (= (package-size package-14) 14)
  (at package-15 city-1-loc-2)
  (= (package-size package-15) 51)
  (at package-16 city-1-loc-5)
  (= (package-size package-16) 99)
  (at truck-1 city-2-loc-6)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 591)
  (= (fuel-max truck-1) 591)
  (at truck-2 city-2-loc-13)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 591)
  (= (fuel-max truck-2) 591)
  (at truck-3 city-2-loc-8)
  (ready-loading truck-3)
  (= (capacity truck-3) 100)
  (= (fuel-left truck-3) 591)
  (= (fuel-max truck-3) 591)
  (at truck-4 city-2-loc-5)
  (ready-loading truck-4)
  (= (capacity truck-4) 100)
  (= (fuel-left truck-4) 591)
  (= (fuel-max truck-4) 591)
 )
 (:goal (and
  (at package-1 city-2-loc-20)
  (at package-2 city-2-loc-18)
  (at package-3 city-2-loc-12)
  (at package-4 city-2-loc-13)
  (at package-5 city-2-loc-8)
  (at package-6 city-2-loc-10)
  (at package-7 city-2-loc-4)
  (at package-8 city-2-loc-17)
  (at package-9 city-2-loc-11)
  (at package-10 city-2-loc-16)
  (at package-11 city-2-loc-18)
  (at package-12 city-2-loc-2)
  (at package-13 city-2-loc-7)
  (at package-14 city-2-loc-10)
  (at package-15 city-2-loc-10)
  (at package-16 city-2-loc-17)
 ))
 (:metric minimize (total-time))
)
