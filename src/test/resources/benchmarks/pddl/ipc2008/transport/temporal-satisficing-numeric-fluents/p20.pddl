; Transport p11-20-two-cities-25nodes-700size-5degree-70mindistance-4trucks-20packages-2008seed

(define (problem transport-p11-20-two-cities-25nodes-700size-5degree-70mindistance-4trucks-20packages-2008seed)
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
  city-1-loc-21 - location
  city-2-loc-21 - location
  city-1-loc-22 - location
  city-2-loc-22 - location
  city-1-loc-23 - location
  city-2-loc-23 - location
  city-1-loc-24 - location
  city-2-loc-24 - location
  city-1-loc-25 - location
  city-2-loc-25 - location
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
  package-17 - package
  package-18 - package
  package-19 - package
  package-20 - package
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
  ; 274,303 -> 319,155
  (road city-1-loc-21 city-1-loc-6)
  (= (road-length city-1-loc-21 city-1-loc-6) 16)
  (= (fuel-demand city-1-loc-21 city-1-loc-6) 31)
  ; 319,155 -> 274,303
  (road city-1-loc-6 city-1-loc-21)
  (= (road-length city-1-loc-6 city-1-loc-21) 16)
  (= (fuel-demand city-1-loc-6 city-1-loc-21) 31)
  ; 274,303 -> 191,297
  (road city-1-loc-21 city-1-loc-9)
  (= (road-length city-1-loc-21 city-1-loc-9) 9)
  (= (fuel-demand city-1-loc-21 city-1-loc-9) 17)
  ; 191,297 -> 274,303
  (road city-1-loc-9 city-1-loc-21)
  (= (road-length city-1-loc-9 city-1-loc-21) 9)
  (= (fuel-demand city-1-loc-9 city-1-loc-21) 17)
  ; 274,303 -> 396,386
  (road city-1-loc-21 city-1-loc-10)
  (= (road-length city-1-loc-21 city-1-loc-10) 15)
  (= (fuel-demand city-1-loc-21 city-1-loc-10) 30)
  ; 396,386 -> 274,303
  (road city-1-loc-10 city-1-loc-21)
  (= (road-length city-1-loc-10 city-1-loc-21) 15)
  (= (fuel-demand city-1-loc-10 city-1-loc-21) 30)
  ; 274,303 -> 121,450
  (road city-1-loc-21 city-1-loc-11)
  (= (road-length city-1-loc-21 city-1-loc-11) 22)
  (= (fuel-demand city-1-loc-21 city-1-loc-11) 43)
  ; 121,450 -> 274,303
  (road city-1-loc-11 city-1-loc-21)
  (= (road-length city-1-loc-11 city-1-loc-21) 22)
  (= (fuel-demand city-1-loc-11 city-1-loc-21) 43)
  ; 274,303 -> 184,397
  (road city-1-loc-21 city-1-loc-15)
  (= (road-length city-1-loc-21 city-1-loc-15) 13)
  (= (fuel-demand city-1-loc-21 city-1-loc-15) 26)
  ; 184,397 -> 274,303
  (road city-1-loc-15 city-1-loc-21)
  (= (road-length city-1-loc-15 city-1-loc-21) 13)
  (= (fuel-demand city-1-loc-15 city-1-loc-21) 26)
  ; 274,303 -> 298,494
  (road city-1-loc-21 city-1-loc-17)
  (= (road-length city-1-loc-21 city-1-loc-17) 20)
  (= (fuel-demand city-1-loc-21 city-1-loc-17) 39)
  ; 298,494 -> 274,303
  (road city-1-loc-17 city-1-loc-21)
  (= (road-length city-1-loc-17 city-1-loc-21) 20)
  (= (fuel-demand city-1-loc-17 city-1-loc-21) 39)
  ; 162,617 -> 121,450
  (road city-1-loc-22 city-1-loc-11)
  (= (road-length city-1-loc-22 city-1-loc-11) 18)
  (= (fuel-demand city-1-loc-22 city-1-loc-11) 35)
  ; 121,450 -> 162,617
  (road city-1-loc-11 city-1-loc-22)
  (= (road-length city-1-loc-11 city-1-loc-22) 18)
  (= (fuel-demand city-1-loc-11 city-1-loc-22) 35)
  ; 162,617 -> 90,554
  (road city-1-loc-22 city-1-loc-16)
  (= (road-length city-1-loc-22 city-1-loc-16) 10)
  (= (fuel-demand city-1-loc-22 city-1-loc-16) 20)
  ; 90,554 -> 162,617
  (road city-1-loc-16 city-1-loc-22)
  (= (road-length city-1-loc-16 city-1-loc-22) 10)
  (= (fuel-demand city-1-loc-16 city-1-loc-22) 20)
  ; 162,617 -> 298,494
  (road city-1-loc-22 city-1-loc-17)
  (= (road-length city-1-loc-22 city-1-loc-17) 19)
  (= (fuel-demand city-1-loc-22 city-1-loc-17) 37)
  ; 298,494 -> 162,617
  (road city-1-loc-17 city-1-loc-22)
  (= (road-length city-1-loc-17 city-1-loc-22) 19)
  (= (fuel-demand city-1-loc-17 city-1-loc-22) 37)
  ; 477,5 -> 269,35
  (road city-1-loc-23 city-1-loc-2)
  (= (road-length city-1-loc-23 city-1-loc-2) 21)
  (= (fuel-demand city-1-loc-23 city-1-loc-2) 42)
  ; 269,35 -> 477,5
  (road city-1-loc-2 city-1-loc-23)
  (= (road-length city-1-loc-2 city-1-loc-23) 21)
  (= (fuel-demand city-1-loc-2 city-1-loc-23) 42)
  ; 477,5 -> 564,12
  (road city-1-loc-23 city-1-loc-19)
  (= (road-length city-1-loc-23 city-1-loc-19) 9)
  (= (fuel-demand city-1-loc-23 city-1-loc-19) 18)
  ; 564,12 -> 477,5
  (road city-1-loc-19 city-1-loc-23)
  (= (road-length city-1-loc-19 city-1-loc-23) 9)
  (= (fuel-demand city-1-loc-19 city-1-loc-23) 18)
  ; 692,320 -> 623,380
  (road city-1-loc-24 city-1-loc-1)
  (= (road-length city-1-loc-24 city-1-loc-1) 10)
  (= (fuel-demand city-1-loc-24 city-1-loc-1) 19)
  ; 623,380 -> 692,320
  (road city-1-loc-1 city-1-loc-24)
  (= (road-length city-1-loc-1 city-1-loc-24) 10)
  (= (fuel-demand city-1-loc-1 city-1-loc-24) 19)
  ; 692,320 -> 523,269
  (road city-1-loc-24 city-1-loc-3)
  (= (road-length city-1-loc-24 city-1-loc-3) 18)
  (= (fuel-demand city-1-loc-24 city-1-loc-3) 36)
  ; 523,269 -> 692,320
  (road city-1-loc-3 city-1-loc-24)
  (= (road-length city-1-loc-3 city-1-loc-24) 18)
  (= (fuel-demand city-1-loc-3 city-1-loc-24) 36)
  ; 692,320 -> 519,379
  (road city-1-loc-24 city-1-loc-7)
  (= (road-length city-1-loc-24 city-1-loc-7) 19)
  (= (fuel-demand city-1-loc-24 city-1-loc-7) 37)
  ; 519,379 -> 692,320
  (road city-1-loc-7 city-1-loc-24)
  (= (road-length city-1-loc-7 city-1-loc-24) 19)
  (= (fuel-demand city-1-loc-7 city-1-loc-24) 37)
  ; 692,320 -> 651,181
  (road city-1-loc-24 city-1-loc-12)
  (= (road-length city-1-loc-24 city-1-loc-12) 15)
  (= (fuel-demand city-1-loc-24 city-1-loc-12) 29)
  ; 651,181 -> 692,320
  (road city-1-loc-12 city-1-loc-24)
  (= (road-length city-1-loc-12 city-1-loc-24) 15)
  (= (fuel-demand city-1-loc-12 city-1-loc-24) 29)
  ; 253,603 -> 395,548
  (road city-1-loc-25 city-1-loc-8)
  (= (road-length city-1-loc-25 city-1-loc-8) 16)
  (= (fuel-demand city-1-loc-25 city-1-loc-8) 31)
  ; 395,548 -> 253,603
  (road city-1-loc-8 city-1-loc-25)
  (= (road-length city-1-loc-8 city-1-loc-25) 16)
  (= (fuel-demand city-1-loc-8 city-1-loc-25) 31)
  ; 253,603 -> 121,450
  (road city-1-loc-25 city-1-loc-11)
  (= (road-length city-1-loc-25 city-1-loc-11) 21)
  (= (fuel-demand city-1-loc-25 city-1-loc-11) 41)
  ; 121,450 -> 253,603
  (road city-1-loc-11 city-1-loc-25)
  (= (road-length city-1-loc-11 city-1-loc-25) 21)
  (= (fuel-demand city-1-loc-11 city-1-loc-25) 41)
  ; 253,603 -> 90,554
  (road city-1-loc-25 city-1-loc-16)
  (= (road-length city-1-loc-25 city-1-loc-16) 17)
  (= (fuel-demand city-1-loc-25 city-1-loc-16) 34)
  ; 90,554 -> 253,603
  (road city-1-loc-16 city-1-loc-25)
  (= (road-length city-1-loc-16 city-1-loc-25) 17)
  (= (fuel-demand city-1-loc-16 city-1-loc-25) 34)
  ; 253,603 -> 298,494
  (road city-1-loc-25 city-1-loc-17)
  (= (road-length city-1-loc-25 city-1-loc-17) 12)
  (= (fuel-demand city-1-loc-25 city-1-loc-17) 24)
  ; 298,494 -> 253,603
  (road city-1-loc-17 city-1-loc-25)
  (= (road-length city-1-loc-17 city-1-loc-25) 12)
  (= (fuel-demand city-1-loc-17 city-1-loc-25) 24)
  ; 253,603 -> 162,617
  (road city-1-loc-25 city-1-loc-22)
  (= (road-length city-1-loc-25 city-1-loc-22) 10)
  (= (fuel-demand city-1-loc-25 city-1-loc-22) 19)
  ; 162,617 -> 253,603
  (road city-1-loc-22 city-1-loc-25)
  (= (road-length city-1-loc-22 city-1-loc-25) 10)
  (= (fuel-demand city-1-loc-22 city-1-loc-25) 19)
  ; 1580,3 -> 1404,42
  (road city-2-loc-4 city-2-loc-2)
  (= (road-length city-2-loc-4 city-2-loc-2) 18)
  (= (fuel-demand city-2-loc-4 city-2-loc-2) 36)
  ; 1404,42 -> 1580,3
  (road city-2-loc-2 city-2-loc-4)
  (= (road-length city-2-loc-2 city-2-loc-4) 18)
  (= (fuel-demand city-2-loc-2 city-2-loc-4) 36)
  ; 1791,395 -> 1861,348
  (road city-2-loc-6 city-2-loc-3)
  (= (road-length city-2-loc-6 city-2-loc-3) 9)
  (= (fuel-demand city-2-loc-6 city-2-loc-3) 17)
  ; 1861,348 -> 1791,395
  (road city-2-loc-3 city-2-loc-6)
  (= (road-length city-2-loc-3 city-2-loc-6) 9)
  (= (fuel-demand city-2-loc-3 city-2-loc-6) 17)
  ; 1642,104 -> 1580,3
  (road city-2-loc-7 city-2-loc-4)
  (= (road-length city-2-loc-7 city-2-loc-4) 12)
  (= (fuel-demand city-2-loc-7 city-2-loc-4) 24)
  ; 1580,3 -> 1642,104
  (road city-2-loc-4 city-2-loc-7)
  (= (road-length city-2-loc-4 city-2-loc-7) 12)
  (= (fuel-demand city-2-loc-4 city-2-loc-7) 24)
  ; 1642,104 -> 1571,242
  (road city-2-loc-7 city-2-loc-5)
  (= (road-length city-2-loc-7 city-2-loc-5) 16)
  (= (fuel-demand city-2-loc-7 city-2-loc-5) 31)
  ; 1571,242 -> 1642,104
  (road city-2-loc-5 city-2-loc-7)
  (= (road-length city-2-loc-5 city-2-loc-7) 16)
  (= (fuel-demand city-2-loc-5 city-2-loc-7) 31)
  ; 1635,332 -> 1571,242
  (road city-2-loc-8 city-2-loc-5)
  (= (road-length city-2-loc-8 city-2-loc-5) 11)
  (= (fuel-demand city-2-loc-8 city-2-loc-5) 22)
  ; 1571,242 -> 1635,332
  (road city-2-loc-5 city-2-loc-8)
  (= (road-length city-2-loc-5 city-2-loc-8) 11)
  (= (fuel-demand city-2-loc-5 city-2-loc-8) 22)
  ; 1635,332 -> 1791,395
  (road city-2-loc-8 city-2-loc-6)
  (= (road-length city-2-loc-8 city-2-loc-6) 17)
  (= (fuel-demand city-2-loc-8 city-2-loc-6) 34)
  ; 1791,395 -> 1635,332
  (road city-2-loc-6 city-2-loc-8)
  (= (road-length city-2-loc-6 city-2-loc-8) 17)
  (= (fuel-demand city-2-loc-6 city-2-loc-8) 34)
  ; 1519,496 -> 1635,332
  (road city-2-loc-9 city-2-loc-8)
  (= (road-length city-2-loc-9 city-2-loc-8) 21)
  (= (fuel-demand city-2-loc-9 city-2-loc-8) 41)
  ; 1635,332 -> 1519,496
  (road city-2-loc-8 city-2-loc-9)
  (= (road-length city-2-loc-8 city-2-loc-9) 21)
  (= (fuel-demand city-2-loc-8 city-2-loc-9) 41)
  ; 1765,262 -> 1861,348
  (road city-2-loc-10 city-2-loc-3)
  (= (road-length city-2-loc-10 city-2-loc-3) 13)
  (= (fuel-demand city-2-loc-10 city-2-loc-3) 26)
  ; 1861,348 -> 1765,262
  (road city-2-loc-3 city-2-loc-10)
  (= (road-length city-2-loc-3 city-2-loc-10) 13)
  (= (fuel-demand city-2-loc-3 city-2-loc-10) 26)
  ; 1765,262 -> 1571,242
  (road city-2-loc-10 city-2-loc-5)
  (= (road-length city-2-loc-10 city-2-loc-5) 20)
  (= (fuel-demand city-2-loc-10 city-2-loc-5) 39)
  ; 1571,242 -> 1765,262
  (road city-2-loc-5 city-2-loc-10)
  (= (road-length city-2-loc-5 city-2-loc-10) 20)
  (= (fuel-demand city-2-loc-5 city-2-loc-10) 39)
  ; 1765,262 -> 1791,395
  (road city-2-loc-10 city-2-loc-6)
  (= (road-length city-2-loc-10 city-2-loc-6) 14)
  (= (fuel-demand city-2-loc-10 city-2-loc-6) 28)
  ; 1791,395 -> 1765,262
  (road city-2-loc-6 city-2-loc-10)
  (= (road-length city-2-loc-6 city-2-loc-10) 14)
  (= (fuel-demand city-2-loc-6 city-2-loc-10) 28)
  ; 1765,262 -> 1642,104
  (road city-2-loc-10 city-2-loc-7)
  (= (road-length city-2-loc-10 city-2-loc-7) 20)
  (= (fuel-demand city-2-loc-10 city-2-loc-7) 40)
  ; 1642,104 -> 1765,262
  (road city-2-loc-7 city-2-loc-10)
  (= (road-length city-2-loc-7 city-2-loc-10) 20)
  (= (fuel-demand city-2-loc-7 city-2-loc-10) 40)
  ; 1765,262 -> 1635,332
  (road city-2-loc-10 city-2-loc-8)
  (= (road-length city-2-loc-10 city-2-loc-8) 15)
  (= (fuel-demand city-2-loc-10 city-2-loc-8) 30)
  ; 1635,332 -> 1765,262
  (road city-2-loc-8 city-2-loc-10)
  (= (road-length city-2-loc-8 city-2-loc-10) 15)
  (= (fuel-demand city-2-loc-8 city-2-loc-10) 30)
  ; 1904,169 -> 1861,348
  (road city-2-loc-12 city-2-loc-3)
  (= (road-length city-2-loc-12 city-2-loc-3) 19)
  (= (fuel-demand city-2-loc-12 city-2-loc-3) 37)
  ; 1861,348 -> 1904,169
  (road city-2-loc-3 city-2-loc-12)
  (= (road-length city-2-loc-3 city-2-loc-12) 19)
  (= (fuel-demand city-2-loc-3 city-2-loc-12) 37)
  ; 1904,169 -> 1765,262
  (road city-2-loc-12 city-2-loc-10)
  (= (road-length city-2-loc-12 city-2-loc-10) 17)
  (= (fuel-demand city-2-loc-12 city-2-loc-10) 34)
  ; 1765,262 -> 1904,169
  (road city-2-loc-10 city-2-loc-12)
  (= (road-length city-2-loc-10 city-2-loc-12) 17)
  (= (fuel-demand city-2-loc-10 city-2-loc-12) 34)
  ; 1904,169 -> 1891,0
  (road city-2-loc-12 city-2-loc-11)
  (= (road-length city-2-loc-12 city-2-loc-11) 17)
  (= (fuel-demand city-2-loc-12 city-2-loc-11) 34)
  ; 1891,0 -> 1904,169
  (road city-2-loc-11 city-2-loc-12)
  (= (road-length city-2-loc-11 city-2-loc-12) 17)
  (= (fuel-demand city-2-loc-11 city-2-loc-12) 34)
  ; 1841,505 -> 1923,604
  (road city-2-loc-13 city-2-loc-1)
  (= (road-length city-2-loc-13 city-2-loc-1) 13)
  (= (fuel-demand city-2-loc-13 city-2-loc-1) 26)
  ; 1923,604 -> 1841,505
  (road city-2-loc-1 city-2-loc-13)
  (= (road-length city-2-loc-1 city-2-loc-13) 13)
  (= (fuel-demand city-2-loc-1 city-2-loc-13) 26)
  ; 1841,505 -> 1861,348
  (road city-2-loc-13 city-2-loc-3)
  (= (road-length city-2-loc-13 city-2-loc-3) 16)
  (= (fuel-demand city-2-loc-13 city-2-loc-3) 32)
  ; 1861,348 -> 1841,505
  (road city-2-loc-3 city-2-loc-13)
  (= (road-length city-2-loc-3 city-2-loc-13) 16)
  (= (fuel-demand city-2-loc-3 city-2-loc-13) 32)
  ; 1841,505 -> 1791,395
  (road city-2-loc-13 city-2-loc-6)
  (= (road-length city-2-loc-13 city-2-loc-6) 13)
  (= (fuel-demand city-2-loc-13 city-2-loc-6) 25)
  ; 1791,395 -> 1841,505
  (road city-2-loc-6 city-2-loc-13)
  (= (road-length city-2-loc-6 city-2-loc-13) 13)
  (= (fuel-demand city-2-loc-6 city-2-loc-13) 25)
  ; 1484,598 -> 1519,496
  (road city-2-loc-14 city-2-loc-9)
  (= (road-length city-2-loc-14 city-2-loc-9) 11)
  (= (fuel-demand city-2-loc-14 city-2-loc-9) 22)
  ; 1519,496 -> 1484,598
  (road city-2-loc-9 city-2-loc-14)
  (= (road-length city-2-loc-9 city-2-loc-14) 11)
  (= (fuel-demand city-2-loc-9 city-2-loc-14) 22)
  ; 1664,198 -> 1580,3
  (road city-2-loc-15 city-2-loc-4)
  (= (road-length city-2-loc-15 city-2-loc-4) 22)
  (= (fuel-demand city-2-loc-15 city-2-loc-4) 43)
  ; 1580,3 -> 1664,198
  (road city-2-loc-4 city-2-loc-15)
  (= (road-length city-2-loc-4 city-2-loc-15) 22)
  (= (fuel-demand city-2-loc-4 city-2-loc-15) 43)
  ; 1664,198 -> 1571,242
  (road city-2-loc-15 city-2-loc-5)
  (= (road-length city-2-loc-15 city-2-loc-5) 11)
  (= (fuel-demand city-2-loc-15 city-2-loc-5) 21)
  ; 1571,242 -> 1664,198
  (road city-2-loc-5 city-2-loc-15)
  (= (road-length city-2-loc-5 city-2-loc-15) 11)
  (= (fuel-demand city-2-loc-5 city-2-loc-15) 21)
  ; 1664,198 -> 1642,104
  (road city-2-loc-15 city-2-loc-7)
  (= (road-length city-2-loc-15 city-2-loc-7) 10)
  (= (fuel-demand city-2-loc-15 city-2-loc-7) 20)
  ; 1642,104 -> 1664,198
  (road city-2-loc-7 city-2-loc-15)
  (= (road-length city-2-loc-7 city-2-loc-15) 10)
  (= (fuel-demand city-2-loc-7 city-2-loc-15) 20)
  ; 1664,198 -> 1635,332
  (road city-2-loc-15 city-2-loc-8)
  (= (road-length city-2-loc-15 city-2-loc-8) 14)
  (= (fuel-demand city-2-loc-15 city-2-loc-8) 28)
  ; 1635,332 -> 1664,198
  (road city-2-loc-8 city-2-loc-15)
  (= (road-length city-2-loc-8 city-2-loc-15) 14)
  (= (fuel-demand city-2-loc-8 city-2-loc-15) 28)
  ; 1664,198 -> 1765,262
  (road city-2-loc-15 city-2-loc-10)
  (= (road-length city-2-loc-15 city-2-loc-10) 12)
  (= (fuel-demand city-2-loc-15 city-2-loc-10) 24)
  ; 1765,262 -> 1664,198
  (road city-2-loc-10 city-2-loc-15)
  (= (road-length city-2-loc-10 city-2-loc-15) 12)
  (= (fuel-demand city-2-loc-10 city-2-loc-15) 24)
  ; 1520,381 -> 1571,242
  (road city-2-loc-16 city-2-loc-5)
  (= (road-length city-2-loc-16 city-2-loc-5) 15)
  (= (fuel-demand city-2-loc-16 city-2-loc-5) 30)
  ; 1571,242 -> 1520,381
  (road city-2-loc-5 city-2-loc-16)
  (= (road-length city-2-loc-5 city-2-loc-16) 15)
  (= (fuel-demand city-2-loc-5 city-2-loc-16) 30)
  ; 1520,381 -> 1635,332
  (road city-2-loc-16 city-2-loc-8)
  (= (road-length city-2-loc-16 city-2-loc-8) 13)
  (= (fuel-demand city-2-loc-16 city-2-loc-8) 25)
  ; 1635,332 -> 1520,381
  (road city-2-loc-8 city-2-loc-16)
  (= (road-length city-2-loc-8 city-2-loc-16) 13)
  (= (fuel-demand city-2-loc-8 city-2-loc-16) 25)
  ; 1520,381 -> 1519,496
  (road city-2-loc-16 city-2-loc-9)
  (= (road-length city-2-loc-16 city-2-loc-9) 12)
  (= (fuel-demand city-2-loc-16 city-2-loc-9) 23)
  ; 1519,496 -> 1520,381
  (road city-2-loc-9 city-2-loc-16)
  (= (road-length city-2-loc-9 city-2-loc-16) 12)
  (= (fuel-demand city-2-loc-9 city-2-loc-16) 23)
  ; 1643,425 -> 1571,242
  (road city-2-loc-17 city-2-loc-5)
  (= (road-length city-2-loc-17 city-2-loc-5) 20)
  (= (fuel-demand city-2-loc-17 city-2-loc-5) 40)
  ; 1571,242 -> 1643,425
  (road city-2-loc-5 city-2-loc-17)
  (= (road-length city-2-loc-5 city-2-loc-17) 20)
  (= (fuel-demand city-2-loc-5 city-2-loc-17) 40)
  ; 1643,425 -> 1791,395
  (road city-2-loc-17 city-2-loc-6)
  (= (road-length city-2-loc-17 city-2-loc-6) 16)
  (= (fuel-demand city-2-loc-17 city-2-loc-6) 31)
  ; 1791,395 -> 1643,425
  (road city-2-loc-6 city-2-loc-17)
  (= (road-length city-2-loc-6 city-2-loc-17) 16)
  (= (fuel-demand city-2-loc-6 city-2-loc-17) 31)
  ; 1643,425 -> 1635,332
  (road city-2-loc-17 city-2-loc-8)
  (= (road-length city-2-loc-17 city-2-loc-8) 10)
  (= (fuel-demand city-2-loc-17 city-2-loc-8) 19)
  ; 1635,332 -> 1643,425
  (road city-2-loc-8 city-2-loc-17)
  (= (road-length city-2-loc-8 city-2-loc-17) 10)
  (= (fuel-demand city-2-loc-8 city-2-loc-17) 19)
  ; 1643,425 -> 1519,496
  (road city-2-loc-17 city-2-loc-9)
  (= (road-length city-2-loc-17 city-2-loc-9) 15)
  (= (fuel-demand city-2-loc-17 city-2-loc-9) 29)
  ; 1519,496 -> 1643,425
  (road city-2-loc-9 city-2-loc-17)
  (= (road-length city-2-loc-9 city-2-loc-17) 15)
  (= (fuel-demand city-2-loc-9 city-2-loc-17) 29)
  ; 1643,425 -> 1765,262
  (road city-2-loc-17 city-2-loc-10)
  (= (road-length city-2-loc-17 city-2-loc-10) 21)
  (= (fuel-demand city-2-loc-17 city-2-loc-10) 41)
  ; 1765,262 -> 1643,425
  (road city-2-loc-10 city-2-loc-17)
  (= (road-length city-2-loc-10 city-2-loc-17) 21)
  (= (fuel-demand city-2-loc-10 city-2-loc-17) 41)
  ; 1643,425 -> 1520,381
  (road city-2-loc-17 city-2-loc-16)
  (= (road-length city-2-loc-17 city-2-loc-16) 14)
  (= (fuel-demand city-2-loc-17 city-2-loc-16) 27)
  ; 1520,381 -> 1643,425
  (road city-2-loc-16 city-2-loc-17)
  (= (road-length city-2-loc-16 city-2-loc-17) 14)
  (= (fuel-demand city-2-loc-16 city-2-loc-17) 27)
  ; 1676,519 -> 1791,395
  (road city-2-loc-18 city-2-loc-6)
  (= (road-length city-2-loc-18 city-2-loc-6) 17)
  (= (fuel-demand city-2-loc-18 city-2-loc-6) 34)
  ; 1791,395 -> 1676,519
  (road city-2-loc-6 city-2-loc-18)
  (= (road-length city-2-loc-6 city-2-loc-18) 17)
  (= (fuel-demand city-2-loc-6 city-2-loc-18) 34)
  ; 1676,519 -> 1635,332
  (road city-2-loc-18 city-2-loc-8)
  (= (road-length city-2-loc-18 city-2-loc-8) 20)
  (= (fuel-demand city-2-loc-18 city-2-loc-8) 39)
  ; 1635,332 -> 1676,519
  (road city-2-loc-8 city-2-loc-18)
  (= (road-length city-2-loc-8 city-2-loc-18) 20)
  (= (fuel-demand city-2-loc-8 city-2-loc-18) 39)
  ; 1676,519 -> 1519,496
  (road city-2-loc-18 city-2-loc-9)
  (= (road-length city-2-loc-18 city-2-loc-9) 16)
  (= (fuel-demand city-2-loc-18 city-2-loc-9) 32)
  ; 1519,496 -> 1676,519
  (road city-2-loc-9 city-2-loc-18)
  (= (road-length city-2-loc-9 city-2-loc-18) 16)
  (= (fuel-demand city-2-loc-9 city-2-loc-18) 32)
  ; 1676,519 -> 1841,505
  (road city-2-loc-18 city-2-loc-13)
  (= (road-length city-2-loc-18 city-2-loc-13) 17)
  (= (fuel-demand city-2-loc-18 city-2-loc-13) 34)
  ; 1841,505 -> 1676,519
  (road city-2-loc-13 city-2-loc-18)
  (= (road-length city-2-loc-13 city-2-loc-18) 17)
  (= (fuel-demand city-2-loc-13 city-2-loc-18) 34)
  ; 1676,519 -> 1484,598
  (road city-2-loc-18 city-2-loc-14)
  (= (road-length city-2-loc-18 city-2-loc-14) 21)
  (= (fuel-demand city-2-loc-18 city-2-loc-14) 42)
  ; 1484,598 -> 1676,519
  (road city-2-loc-14 city-2-loc-18)
  (= (road-length city-2-loc-14 city-2-loc-18) 21)
  (= (fuel-demand city-2-loc-14 city-2-loc-18) 42)
  ; 1676,519 -> 1520,381
  (road city-2-loc-18 city-2-loc-16)
  (= (road-length city-2-loc-18 city-2-loc-16) 21)
  (= (fuel-demand city-2-loc-18 city-2-loc-16) 42)
  ; 1520,381 -> 1676,519
  (road city-2-loc-16 city-2-loc-18)
  (= (road-length city-2-loc-16 city-2-loc-18) 21)
  (= (fuel-demand city-2-loc-16 city-2-loc-18) 42)
  ; 1676,519 -> 1643,425
  (road city-2-loc-18 city-2-loc-17)
  (= (road-length city-2-loc-18 city-2-loc-17) 10)
  (= (fuel-demand city-2-loc-18 city-2-loc-17) 20)
  ; 1643,425 -> 1676,519
  (road city-2-loc-17 city-2-loc-18)
  (= (road-length city-2-loc-17 city-2-loc-18) 10)
  (= (fuel-demand city-2-loc-17 city-2-loc-18) 20)
  ; 1449,192 -> 1404,42
  (road city-2-loc-19 city-2-loc-2)
  (= (road-length city-2-loc-19 city-2-loc-2) 16)
  (= (fuel-demand city-2-loc-19 city-2-loc-2) 32)
  ; 1404,42 -> 1449,192
  (road city-2-loc-2 city-2-loc-19)
  (= (road-length city-2-loc-2 city-2-loc-19) 16)
  (= (fuel-demand city-2-loc-2 city-2-loc-19) 32)
  ; 1449,192 -> 1571,242
  (road city-2-loc-19 city-2-loc-5)
  (= (road-length city-2-loc-19 city-2-loc-5) 14)
  (= (fuel-demand city-2-loc-19 city-2-loc-5) 27)
  ; 1571,242 -> 1449,192
  (road city-2-loc-5 city-2-loc-19)
  (= (road-length city-2-loc-5 city-2-loc-19) 14)
  (= (fuel-demand city-2-loc-5 city-2-loc-19) 27)
  ; 1449,192 -> 1642,104
  (road city-2-loc-19 city-2-loc-7)
  (= (road-length city-2-loc-19 city-2-loc-7) 22)
  (= (fuel-demand city-2-loc-19 city-2-loc-7) 43)
  ; 1642,104 -> 1449,192
  (road city-2-loc-7 city-2-loc-19)
  (= (road-length city-2-loc-7 city-2-loc-19) 22)
  (= (fuel-demand city-2-loc-7 city-2-loc-19) 43)
  ; 1449,192 -> 1520,381
  (road city-2-loc-19 city-2-loc-16)
  (= (road-length city-2-loc-19 city-2-loc-16) 21)
  (= (fuel-demand city-2-loc-19 city-2-loc-16) 41)
  ; 1520,381 -> 1449,192
  (road city-2-loc-16 city-2-loc-19)
  (= (road-length city-2-loc-16 city-2-loc-19) 21)
  (= (fuel-demand city-2-loc-16 city-2-loc-19) 41)
  ; 2000,97 -> 1891,0
  (road city-2-loc-20 city-2-loc-11)
  (= (road-length city-2-loc-20 city-2-loc-11) 15)
  (= (fuel-demand city-2-loc-20 city-2-loc-11) 30)
  ; 1891,0 -> 2000,97
  (road city-2-loc-11 city-2-loc-20)
  (= (road-length city-2-loc-11 city-2-loc-20) 15)
  (= (fuel-demand city-2-loc-11 city-2-loc-20) 30)
  ; 2000,97 -> 1904,169
  (road city-2-loc-20 city-2-loc-12)
  (= (road-length city-2-loc-20 city-2-loc-12) 12)
  (= (fuel-demand city-2-loc-20 city-2-loc-12) 24)
  ; 1904,169 -> 2000,97
  (road city-2-loc-12 city-2-loc-20)
  (= (road-length city-2-loc-12 city-2-loc-20) 12)
  (= (fuel-demand city-2-loc-12 city-2-loc-20) 24)
  ; 1448,355 -> 1571,242
  (road city-2-loc-21 city-2-loc-5)
  (= (road-length city-2-loc-21 city-2-loc-5) 17)
  (= (fuel-demand city-2-loc-21 city-2-loc-5) 34)
  ; 1571,242 -> 1448,355
  (road city-2-loc-5 city-2-loc-21)
  (= (road-length city-2-loc-5 city-2-loc-21) 17)
  (= (fuel-demand city-2-loc-5 city-2-loc-21) 34)
  ; 1448,355 -> 1635,332
  (road city-2-loc-21 city-2-loc-8)
  (= (road-length city-2-loc-21 city-2-loc-8) 19)
  (= (fuel-demand city-2-loc-21 city-2-loc-8) 38)
  ; 1635,332 -> 1448,355
  (road city-2-loc-8 city-2-loc-21)
  (= (road-length city-2-loc-8 city-2-loc-21) 19)
  (= (fuel-demand city-2-loc-8 city-2-loc-21) 38)
  ; 1448,355 -> 1519,496
  (road city-2-loc-21 city-2-loc-9)
  (= (road-length city-2-loc-21 city-2-loc-9) 16)
  (= (fuel-demand city-2-loc-21 city-2-loc-9) 32)
  ; 1519,496 -> 1448,355
  (road city-2-loc-9 city-2-loc-21)
  (= (road-length city-2-loc-9 city-2-loc-21) 16)
  (= (fuel-demand city-2-loc-9 city-2-loc-21) 32)
  ; 1448,355 -> 1520,381
  (road city-2-loc-21 city-2-loc-16)
  (= (road-length city-2-loc-21 city-2-loc-16) 8)
  (= (fuel-demand city-2-loc-21 city-2-loc-16) 16)
  ; 1520,381 -> 1448,355
  (road city-2-loc-16 city-2-loc-21)
  (= (road-length city-2-loc-16 city-2-loc-21) 8)
  (= (fuel-demand city-2-loc-16 city-2-loc-21) 16)
  ; 1448,355 -> 1643,425
  (road city-2-loc-21 city-2-loc-17)
  (= (road-length city-2-loc-21 city-2-loc-17) 21)
  (= (fuel-demand city-2-loc-21 city-2-loc-17) 42)
  ; 1643,425 -> 1448,355
  (road city-2-loc-17 city-2-loc-21)
  (= (road-length city-2-loc-17 city-2-loc-21) 21)
  (= (fuel-demand city-2-loc-17 city-2-loc-21) 42)
  ; 1448,355 -> 1449,192
  (road city-2-loc-21 city-2-loc-19)
  (= (road-length city-2-loc-21 city-2-loc-19) 17)
  (= (fuel-demand city-2-loc-21 city-2-loc-19) 33)
  ; 1449,192 -> 1448,355
  (road city-2-loc-19 city-2-loc-21)
  (= (road-length city-2-loc-19 city-2-loc-21) 17)
  (= (fuel-demand city-2-loc-19 city-2-loc-21) 33)
  ; 1542,691 -> 1519,496
  (road city-2-loc-22 city-2-loc-9)
  (= (road-length city-2-loc-22 city-2-loc-9) 20)
  (= (fuel-demand city-2-loc-22 city-2-loc-9) 40)
  ; 1519,496 -> 1542,691
  (road city-2-loc-9 city-2-loc-22)
  (= (road-length city-2-loc-9 city-2-loc-22) 20)
  (= (fuel-demand city-2-loc-9 city-2-loc-22) 40)
  ; 1542,691 -> 1484,598
  (road city-2-loc-22 city-2-loc-14)
  (= (road-length city-2-loc-22 city-2-loc-14) 11)
  (= (fuel-demand city-2-loc-22 city-2-loc-14) 22)
  ; 1484,598 -> 1542,691
  (road city-2-loc-14 city-2-loc-22)
  (= (road-length city-2-loc-14 city-2-loc-22) 11)
  (= (fuel-demand city-2-loc-14 city-2-loc-22) 22)
  ; 2078,604 -> 1923,604
  (road city-2-loc-23 city-2-loc-1)
  (= (road-length city-2-loc-23 city-2-loc-1) 16)
  (= (fuel-demand city-2-loc-23 city-2-loc-1) 31)
  ; 1923,604 -> 2078,604
  (road city-2-loc-1 city-2-loc-23)
  (= (road-length city-2-loc-1 city-2-loc-23) 16)
  (= (fuel-demand city-2-loc-1 city-2-loc-23) 31)
  ; 1717,594 -> 1923,604
  (road city-2-loc-24 city-2-loc-1)
  (= (road-length city-2-loc-24 city-2-loc-1) 21)
  (= (fuel-demand city-2-loc-24 city-2-loc-1) 42)
  ; 1923,604 -> 1717,594
  (road city-2-loc-1 city-2-loc-24)
  (= (road-length city-2-loc-1 city-2-loc-24) 21)
  (= (fuel-demand city-2-loc-1 city-2-loc-24) 42)
  ; 1717,594 -> 1791,395
  (road city-2-loc-24 city-2-loc-6)
  (= (road-length city-2-loc-24 city-2-loc-6) 22)
  (= (fuel-demand city-2-loc-24 city-2-loc-6) 43)
  ; 1791,395 -> 1717,594
  (road city-2-loc-6 city-2-loc-24)
  (= (road-length city-2-loc-6 city-2-loc-24) 22)
  (= (fuel-demand city-2-loc-6 city-2-loc-24) 43)
  ; 1717,594 -> 1841,505
  (road city-2-loc-24 city-2-loc-13)
  (= (road-length city-2-loc-24 city-2-loc-13) 16)
  (= (fuel-demand city-2-loc-24 city-2-loc-13) 31)
  ; 1841,505 -> 1717,594
  (road city-2-loc-13 city-2-loc-24)
  (= (road-length city-2-loc-13 city-2-loc-24) 16)
  (= (fuel-demand city-2-loc-13 city-2-loc-24) 31)
  ; 1717,594 -> 1643,425
  (road city-2-loc-24 city-2-loc-17)
  (= (road-length city-2-loc-24 city-2-loc-17) 19)
  (= (fuel-demand city-2-loc-24 city-2-loc-17) 37)
  ; 1643,425 -> 1717,594
  (road city-2-loc-17 city-2-loc-24)
  (= (road-length city-2-loc-17 city-2-loc-24) 19)
  (= (fuel-demand city-2-loc-17 city-2-loc-24) 37)
  ; 1717,594 -> 1676,519
  (road city-2-loc-24 city-2-loc-18)
  (= (road-length city-2-loc-24 city-2-loc-18) 9)
  (= (fuel-demand city-2-loc-24 city-2-loc-18) 17)
  ; 1676,519 -> 1717,594
  (road city-2-loc-18 city-2-loc-24)
  (= (road-length city-2-loc-18 city-2-loc-24) 9)
  (= (fuel-demand city-2-loc-18 city-2-loc-24) 17)
  ; 1717,594 -> 1542,691
  (road city-2-loc-24 city-2-loc-22)
  (= (road-length city-2-loc-24 city-2-loc-22) 20)
  (= (fuel-demand city-2-loc-24 city-2-loc-22) 40)
  ; 1542,691 -> 1717,594
  (road city-2-loc-22 city-2-loc-24)
  (= (road-length city-2-loc-22 city-2-loc-24) 20)
  (= (fuel-demand city-2-loc-22 city-2-loc-24) 40)
  ; 2055,147 -> 1904,169
  (road city-2-loc-25 city-2-loc-12)
  (= (road-length city-2-loc-25 city-2-loc-12) 16)
  (= (fuel-demand city-2-loc-25 city-2-loc-12) 31)
  ; 1904,169 -> 2055,147
  (road city-2-loc-12 city-2-loc-25)
  (= (road-length city-2-loc-12 city-2-loc-25) 16)
  (= (fuel-demand city-2-loc-12 city-2-loc-25) 31)
  ; 2055,147 -> 2000,97
  (road city-2-loc-25 city-2-loc-20)
  (= (road-length city-2-loc-25 city-2-loc-20) 8)
  (= (fuel-demand city-2-loc-25 city-2-loc-20) 15)
  ; 2000,97 -> 2055,147
  (road city-2-loc-20 city-2-loc-25)
  (= (road-length city-2-loc-20 city-2-loc-25) 8)
  (= (fuel-demand city-2-loc-20 city-2-loc-25) 15)
  ; 692,320 <-> 1448,355
  (road city-1-loc-24 city-2-loc-21)
  (= (road-length city-1-loc-24 city-2-loc-21) 76)
  (= (fuel-demand city-1-loc-24 city-2-loc-21) 38)
  (road city-2-loc-21 city-1-loc-24)
  (= (road-length city-2-loc-21 city-1-loc-24) 76)
  (= (fuel-demand city-2-loc-21 city-1-loc-24) 38)
  (has-petrol-station city-1-loc-24)
  (has-petrol-station city-2-loc-21)
  (at package-1 city-1-loc-5)
  (= (package-size package-1) 43)
  (at package-2 city-1-loc-16)
  (= (package-size package-2) 72)
  (at package-3 city-1-loc-13)
  (= (package-size package-3) 44)
  (at package-4 city-1-loc-23)
  (= (package-size package-4) 35)
  (at package-5 city-1-loc-17)
  (= (package-size package-5) 24)
  (at package-6 city-1-loc-15)
  (= (package-size package-6) 91)
  (at package-7 city-1-loc-12)
  (= (package-size package-7) 74)
  (at package-8 city-1-loc-17)
  (= (package-size package-8) 41)
  (at package-9 city-1-loc-10)
  (= (package-size package-9) 95)
  (at package-10 city-1-loc-24)
  (= (package-size package-10) 74)
  (at package-11 city-1-loc-13)
  (= (package-size package-11) 44)
  (at package-12 city-1-loc-17)
  (= (package-size package-12) 51)
  (at package-13 city-1-loc-21)
  (= (package-size package-13) 56)
  (at package-14 city-1-loc-11)
  (= (package-size package-14) 61)
  (at package-15 city-1-loc-13)
  (= (package-size package-15) 25)
  (at package-16 city-1-loc-21)
  (= (package-size package-16) 65)
  (at package-17 city-1-loc-8)
  (= (package-size package-17) 51)
  (at package-18 city-1-loc-9)
  (= (package-size package-18) 97)
  (at package-19 city-1-loc-19)
  (= (package-size package-19) 3)
  (at package-20 city-1-loc-12)
  (= (package-size package-20) 20)
  (at truck-1 city-2-loc-12)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 567)
  (= (fuel-max truck-1) 567)
  (at truck-2 city-2-loc-24)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 567)
  (= (fuel-max truck-2) 567)
  (at truck-3 city-2-loc-13)
  (ready-loading truck-3)
  (= (capacity truck-3) 100)
  (= (fuel-left truck-3) 567)
  (= (fuel-max truck-3) 567)
  (at truck-4 city-2-loc-19)
  (ready-loading truck-4)
  (= (capacity truck-4) 100)
  (= (fuel-left truck-4) 567)
  (= (fuel-max truck-4) 567)
 )
 (:goal (and
  (at package-1 city-2-loc-14)
  (at package-2 city-2-loc-7)
  (at package-3 city-2-loc-22)
  (at package-4 city-2-loc-13)
  (at package-5 city-2-loc-10)
  (at package-6 city-2-loc-24)
  (at package-7 city-2-loc-8)
  (at package-8 city-2-loc-18)
  (at package-9 city-2-loc-6)
  (at package-10 city-2-loc-7)
  (at package-11 city-2-loc-3)
  (at package-12 city-2-loc-19)
  (at package-13 city-2-loc-7)
  (at package-14 city-2-loc-6)
  (at package-15 city-2-loc-5)
  (at package-16 city-2-loc-11)
  (at package-17 city-2-loc-1)
  (at package-18 city-2-loc-14)
  (at package-19 city-2-loc-9)
  (at package-20 city-2-loc-10)
 ))
 (:metric minimize (total-time))
)
