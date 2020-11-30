; Transport p11-20-two-cities-18nodes-700size-4degree-70mindistance-4trucks-14packages-2008seed

(define (problem transport-p11-20-two-cities-18nodes-700size-4degree-70mindistance-4trucks-14packages-2008seed)
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
  ; 519,379 -> 638,559
  (road city-1-loc-7 city-1-loc-4)
  (= (road-length city-1-loc-7 city-1-loc-4) 22)
  (= (fuel-demand city-1-loc-7 city-1-loc-4) 44)
  ; 638,559 -> 519,379
  (road city-1-loc-4 city-1-loc-7)
  (= (road-length city-1-loc-4 city-1-loc-7) 22)
  (= (fuel-demand city-1-loc-4 city-1-loc-7) 44)
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
  ; 298,494 -> 90,554
  (road city-1-loc-17 city-1-loc-16)
  (= (road-length city-1-loc-17 city-1-loc-16) 22)
  (= (fuel-demand city-1-loc-17 city-1-loc-16) 44)
  ; 90,554 -> 298,494
  (road city-1-loc-16 city-1-loc-17)
  (= (road-length city-1-loc-16 city-1-loc-17) 22)
  (= (fuel-demand city-1-loc-16 city-1-loc-17) 44)
  ; 25,258 -> 191,297
  (road city-1-loc-18 city-1-loc-9)
  (= (road-length city-1-loc-18 city-1-loc-9) 18)
  (= (fuel-demand city-1-loc-18 city-1-loc-9) 35)
  ; 191,297 -> 25,258
  (road city-1-loc-9 city-1-loc-18)
  (= (road-length city-1-loc-9 city-1-loc-18) 18)
  (= (fuel-demand city-1-loc-9 city-1-loc-18) 35)
  ; 25,258 -> 121,450
  (road city-1-loc-18 city-1-loc-11)
  (= (road-length city-1-loc-18 city-1-loc-11) 22)
  (= (fuel-demand city-1-loc-18 city-1-loc-11) 43)
  ; 121,450 -> 25,258
  (road city-1-loc-11 city-1-loc-18)
  (= (road-length city-1-loc-11 city-1-loc-18) 22)
  (= (fuel-demand city-1-loc-11 city-1-loc-18) 43)
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
  ; 2055,147 -> 2010,44
  (road city-2-loc-4 city-2-loc-1)
  (= (road-length city-2-loc-4 city-2-loc-1) 12)
  (= (fuel-demand city-2-loc-4 city-2-loc-1) 23)
  ; 2010,44 -> 2055,147
  (road city-2-loc-1 city-2-loc-4)
  (= (road-length city-2-loc-1 city-2-loc-4) 12)
  (= (fuel-demand city-2-loc-1 city-2-loc-4) 23)
  ; 1736,304 -> 1830,240
  (road city-2-loc-6 city-2-loc-3)
  (= (road-length city-2-loc-6 city-2-loc-3) 12)
  (= (fuel-demand city-2-loc-6 city-2-loc-3) 23)
  ; 1830,240 -> 1736,304
  (road city-2-loc-3 city-2-loc-6)
  (= (road-length city-2-loc-3 city-2-loc-6) 12)
  (= (fuel-demand city-2-loc-3 city-2-loc-6) 23)
  ; 1736,304 -> 1535,297
  (road city-2-loc-6 city-2-loc-5)
  (= (road-length city-2-loc-6 city-2-loc-5) 21)
  (= (fuel-demand city-2-loc-6 city-2-loc-5) 41)
  ; 1535,297 -> 1736,304
  (road city-2-loc-5 city-2-loc-6)
  (= (road-length city-2-loc-5 city-2-loc-6) 21)
  (= (fuel-demand city-2-loc-5 city-2-loc-6) 41)
  ; 2042,239 -> 2010,44
  (road city-2-loc-7 city-2-loc-1)
  (= (road-length city-2-loc-7 city-2-loc-1) 20)
  (= (fuel-demand city-2-loc-7 city-2-loc-1) 40)
  ; 2010,44 -> 2042,239
  (road city-2-loc-1 city-2-loc-7)
  (= (road-length city-2-loc-1 city-2-loc-7) 20)
  (= (fuel-demand city-2-loc-1 city-2-loc-7) 40)
  ; 2042,239 -> 1830,240
  (road city-2-loc-7 city-2-loc-3)
  (= (road-length city-2-loc-7 city-2-loc-3) 22)
  (= (fuel-demand city-2-loc-7 city-2-loc-3) 43)
  ; 1830,240 -> 2042,239
  (road city-2-loc-3 city-2-loc-7)
  (= (road-length city-2-loc-3 city-2-loc-7) 22)
  (= (fuel-demand city-2-loc-3 city-2-loc-7) 43)
  ; 2042,239 -> 2055,147
  (road city-2-loc-7 city-2-loc-4)
  (= (road-length city-2-loc-7 city-2-loc-4) 10)
  (= (fuel-demand city-2-loc-7 city-2-loc-4) 19)
  ; 2055,147 -> 2042,239
  (road city-2-loc-4 city-2-loc-7)
  (= (road-length city-2-loc-4 city-2-loc-7) 10)
  (= (fuel-demand city-2-loc-4 city-2-loc-7) 19)
  ; 1855,164 -> 2010,44
  (road city-2-loc-8 city-2-loc-1)
  (= (road-length city-2-loc-8 city-2-loc-1) 20)
  (= (fuel-demand city-2-loc-8 city-2-loc-1) 40)
  ; 2010,44 -> 1855,164
  (road city-2-loc-1 city-2-loc-8)
  (= (road-length city-2-loc-1 city-2-loc-8) 20)
  (= (fuel-demand city-2-loc-1 city-2-loc-8) 40)
  ; 1855,164 -> 1830,240
  (road city-2-loc-8 city-2-loc-3)
  (= (road-length city-2-loc-8 city-2-loc-3) 8)
  (= (fuel-demand city-2-loc-8 city-2-loc-3) 16)
  ; 1830,240 -> 1855,164
  (road city-2-loc-3 city-2-loc-8)
  (= (road-length city-2-loc-3 city-2-loc-8) 8)
  (= (fuel-demand city-2-loc-3 city-2-loc-8) 16)
  ; 1855,164 -> 2055,147
  (road city-2-loc-8 city-2-loc-4)
  (= (road-length city-2-loc-8 city-2-loc-4) 21)
  (= (fuel-demand city-2-loc-8 city-2-loc-4) 41)
  ; 2055,147 -> 1855,164
  (road city-2-loc-4 city-2-loc-8)
  (= (road-length city-2-loc-4 city-2-loc-8) 21)
  (= (fuel-demand city-2-loc-4 city-2-loc-8) 41)
  ; 1855,164 -> 1736,304
  (road city-2-loc-8 city-2-loc-6)
  (= (road-length city-2-loc-8 city-2-loc-6) 19)
  (= (fuel-demand city-2-loc-8 city-2-loc-6) 37)
  ; 1736,304 -> 1855,164
  (road city-2-loc-6 city-2-loc-8)
  (= (road-length city-2-loc-6 city-2-loc-8) 19)
  (= (fuel-demand city-2-loc-6 city-2-loc-8) 37)
  ; 1855,164 -> 2042,239
  (road city-2-loc-8 city-2-loc-7)
  (= (road-length city-2-loc-8 city-2-loc-7) 21)
  (= (fuel-demand city-2-loc-8 city-2-loc-7) 41)
  ; 2042,239 -> 1855,164
  (road city-2-loc-7 city-2-loc-8)
  (= (road-length city-2-loc-7 city-2-loc-8) 21)
  (= (fuel-demand city-2-loc-7 city-2-loc-8) 41)
  ; 1792,631 -> 1852,504
  (road city-2-loc-9 city-2-loc-2)
  (= (road-length city-2-loc-9 city-2-loc-2) 14)
  (= (fuel-demand city-2-loc-9 city-2-loc-2) 28)
  ; 1852,504 -> 1792,631
  (road city-2-loc-2 city-2-loc-9)
  (= (road-length city-2-loc-2 city-2-loc-9) 14)
  (= (fuel-demand city-2-loc-2 city-2-loc-9) 28)
  ; 1713,513 -> 1852,504
  (road city-2-loc-10 city-2-loc-2)
  (= (road-length city-2-loc-10 city-2-loc-2) 14)
  (= (fuel-demand city-2-loc-10 city-2-loc-2) 28)
  ; 1852,504 -> 1713,513
  (road city-2-loc-2 city-2-loc-10)
  (= (road-length city-2-loc-2 city-2-loc-10) 14)
  (= (fuel-demand city-2-loc-2 city-2-loc-10) 28)
  ; 1713,513 -> 1736,304
  (road city-2-loc-10 city-2-loc-6)
  (= (road-length city-2-loc-10 city-2-loc-6) 21)
  (= (fuel-demand city-2-loc-10 city-2-loc-6) 42)
  ; 1736,304 -> 1713,513
  (road city-2-loc-6 city-2-loc-10)
  (= (road-length city-2-loc-6 city-2-loc-10) 21)
  (= (fuel-demand city-2-loc-6 city-2-loc-10) 42)
  ; 1713,513 -> 1792,631
  (road city-2-loc-10 city-2-loc-9)
  (= (road-length city-2-loc-10 city-2-loc-9) 15)
  (= (fuel-demand city-2-loc-10 city-2-loc-9) 29)
  ; 1792,631 -> 1713,513
  (road city-2-loc-9 city-2-loc-10)
  (= (road-length city-2-loc-9 city-2-loc-10) 15)
  (= (fuel-demand city-2-loc-9 city-2-loc-10) 29)
  ; 1653,658 -> 1792,631
  (road city-2-loc-11 city-2-loc-9)
  (= (road-length city-2-loc-11 city-2-loc-9) 15)
  (= (fuel-demand city-2-loc-11 city-2-loc-9) 29)
  ; 1792,631 -> 1653,658
  (road city-2-loc-9 city-2-loc-11)
  (= (road-length city-2-loc-9 city-2-loc-11) 15)
  (= (fuel-demand city-2-loc-9 city-2-loc-11) 29)
  ; 1653,658 -> 1713,513
  (road city-2-loc-11 city-2-loc-10)
  (= (road-length city-2-loc-11 city-2-loc-10) 16)
  (= (fuel-demand city-2-loc-11 city-2-loc-10) 32)
  ; 1713,513 -> 1653,658
  (road city-2-loc-10 city-2-loc-11)
  (= (road-length city-2-loc-10 city-2-loc-11) 16)
  (= (fuel-demand city-2-loc-10 city-2-loc-11) 32)
  ; 2059,513 -> 1852,504
  (road city-2-loc-12 city-2-loc-2)
  (= (road-length city-2-loc-12 city-2-loc-2) 21)
  (= (fuel-demand city-2-loc-12 city-2-loc-2) 42)
  ; 1852,504 -> 2059,513
  (road city-2-loc-2 city-2-loc-12)
  (= (road-length city-2-loc-2 city-2-loc-12) 21)
  (= (fuel-demand city-2-loc-2 city-2-loc-12) 42)
  ; 1857,355 -> 1852,504
  (road city-2-loc-13 city-2-loc-2)
  (= (road-length city-2-loc-13 city-2-loc-2) 15)
  (= (fuel-demand city-2-loc-13 city-2-loc-2) 30)
  ; 1852,504 -> 1857,355
  (road city-2-loc-2 city-2-loc-13)
  (= (road-length city-2-loc-2 city-2-loc-13) 15)
  (= (fuel-demand city-2-loc-2 city-2-loc-13) 30)
  ; 1857,355 -> 1830,240
  (road city-2-loc-13 city-2-loc-3)
  (= (road-length city-2-loc-13 city-2-loc-3) 12)
  (= (fuel-demand city-2-loc-13 city-2-loc-3) 24)
  ; 1830,240 -> 1857,355
  (road city-2-loc-3 city-2-loc-13)
  (= (road-length city-2-loc-3 city-2-loc-13) 12)
  (= (fuel-demand city-2-loc-3 city-2-loc-13) 24)
  ; 1857,355 -> 1736,304
  (road city-2-loc-13 city-2-loc-6)
  (= (road-length city-2-loc-13 city-2-loc-6) 14)
  (= (fuel-demand city-2-loc-13 city-2-loc-6) 27)
  ; 1736,304 -> 1857,355
  (road city-2-loc-6 city-2-loc-13)
  (= (road-length city-2-loc-6 city-2-loc-13) 14)
  (= (fuel-demand city-2-loc-6 city-2-loc-13) 27)
  ; 1857,355 -> 2042,239
  (road city-2-loc-13 city-2-loc-7)
  (= (road-length city-2-loc-13 city-2-loc-7) 22)
  (= (fuel-demand city-2-loc-13 city-2-loc-7) 44)
  ; 2042,239 -> 1857,355
  (road city-2-loc-7 city-2-loc-13)
  (= (road-length city-2-loc-7 city-2-loc-13) 22)
  (= (fuel-demand city-2-loc-7 city-2-loc-13) 44)
  ; 1857,355 -> 1855,164
  (road city-2-loc-13 city-2-loc-8)
  (= (road-length city-2-loc-13 city-2-loc-8) 20)
  (= (fuel-demand city-2-loc-13 city-2-loc-8) 39)
  ; 1855,164 -> 1857,355
  (road city-2-loc-8 city-2-loc-13)
  (= (road-length city-2-loc-8 city-2-loc-13) 20)
  (= (fuel-demand city-2-loc-8 city-2-loc-13) 39)
  ; 1857,355 -> 1713,513
  (road city-2-loc-13 city-2-loc-10)
  (= (road-length city-2-loc-13 city-2-loc-10) 22)
  (= (fuel-demand city-2-loc-13 city-2-loc-10) 43)
  ; 1713,513 -> 1857,355
  (road city-2-loc-10 city-2-loc-13)
  (= (road-length city-2-loc-10 city-2-loc-13) 22)
  (= (fuel-demand city-2-loc-10 city-2-loc-13) 43)
  ; 1974,386 -> 1852,504
  (road city-2-loc-14 city-2-loc-2)
  (= (road-length city-2-loc-14 city-2-loc-2) 17)
  (= (fuel-demand city-2-loc-14 city-2-loc-2) 34)
  ; 1852,504 -> 1974,386
  (road city-2-loc-2 city-2-loc-14)
  (= (road-length city-2-loc-2 city-2-loc-14) 17)
  (= (fuel-demand city-2-loc-2 city-2-loc-14) 34)
  ; 1974,386 -> 1830,240
  (road city-2-loc-14 city-2-loc-3)
  (= (road-length city-2-loc-14 city-2-loc-3) 21)
  (= (fuel-demand city-2-loc-14 city-2-loc-3) 41)
  ; 1830,240 -> 1974,386
  (road city-2-loc-3 city-2-loc-14)
  (= (road-length city-2-loc-3 city-2-loc-14) 21)
  (= (fuel-demand city-2-loc-3 city-2-loc-14) 41)
  ; 1974,386 -> 2042,239
  (road city-2-loc-14 city-2-loc-7)
  (= (road-length city-2-loc-14 city-2-loc-7) 17)
  (= (fuel-demand city-2-loc-14 city-2-loc-7) 33)
  ; 2042,239 -> 1974,386
  (road city-2-loc-7 city-2-loc-14)
  (= (road-length city-2-loc-7 city-2-loc-14) 17)
  (= (fuel-demand city-2-loc-7 city-2-loc-14) 33)
  ; 1974,386 -> 2059,513
  (road city-2-loc-14 city-2-loc-12)
  (= (road-length city-2-loc-14 city-2-loc-12) 16)
  (= (fuel-demand city-2-loc-14 city-2-loc-12) 31)
  ; 2059,513 -> 1974,386
  (road city-2-loc-12 city-2-loc-14)
  (= (road-length city-2-loc-12 city-2-loc-14) 16)
  (= (fuel-demand city-2-loc-12 city-2-loc-14) 31)
  ; 1974,386 -> 1857,355
  (road city-2-loc-14 city-2-loc-13)
  (= (road-length city-2-loc-14 city-2-loc-13) 13)
  (= (fuel-demand city-2-loc-14 city-2-loc-13) 25)
  ; 1857,355 -> 1974,386
  (road city-2-loc-13 city-2-loc-14)
  (= (road-length city-2-loc-13 city-2-loc-14) 13)
  (= (fuel-demand city-2-loc-13 city-2-loc-14) 25)
  ; 1706,424 -> 1852,504
  (road city-2-loc-15 city-2-loc-2)
  (= (road-length city-2-loc-15 city-2-loc-2) 17)
  (= (fuel-demand city-2-loc-15 city-2-loc-2) 34)
  ; 1852,504 -> 1706,424
  (road city-2-loc-2 city-2-loc-15)
  (= (road-length city-2-loc-2 city-2-loc-15) 17)
  (= (fuel-demand city-2-loc-2 city-2-loc-15) 34)
  ; 1706,424 -> 1830,240
  (road city-2-loc-15 city-2-loc-3)
  (= (road-length city-2-loc-15 city-2-loc-3) 23)
  (= (fuel-demand city-2-loc-15 city-2-loc-3) 45)
  ; 1830,240 -> 1706,424
  (road city-2-loc-3 city-2-loc-15)
  (= (road-length city-2-loc-3 city-2-loc-15) 23)
  (= (fuel-demand city-2-loc-3 city-2-loc-15) 45)
  ; 1706,424 -> 1535,297
  (road city-2-loc-15 city-2-loc-5)
  (= (road-length city-2-loc-15 city-2-loc-5) 22)
  (= (fuel-demand city-2-loc-15 city-2-loc-5) 43)
  ; 1535,297 -> 1706,424
  (road city-2-loc-5 city-2-loc-15)
  (= (road-length city-2-loc-5 city-2-loc-15) 22)
  (= (fuel-demand city-2-loc-5 city-2-loc-15) 43)
  ; 1706,424 -> 1736,304
  (road city-2-loc-15 city-2-loc-6)
  (= (road-length city-2-loc-15 city-2-loc-6) 13)
  (= (fuel-demand city-2-loc-15 city-2-loc-6) 25)
  ; 1736,304 -> 1706,424
  (road city-2-loc-6 city-2-loc-15)
  (= (road-length city-2-loc-6 city-2-loc-15) 13)
  (= (fuel-demand city-2-loc-6 city-2-loc-15) 25)
  ; 1706,424 -> 1713,513
  (road city-2-loc-15 city-2-loc-10)
  (= (road-length city-2-loc-15 city-2-loc-10) 9)
  (= (fuel-demand city-2-loc-15 city-2-loc-10) 18)
  ; 1713,513 -> 1706,424
  (road city-2-loc-10 city-2-loc-15)
  (= (road-length city-2-loc-10 city-2-loc-15) 9)
  (= (fuel-demand city-2-loc-10 city-2-loc-15) 18)
  ; 1706,424 -> 1857,355
  (road city-2-loc-15 city-2-loc-13)
  (= (road-length city-2-loc-15 city-2-loc-13) 17)
  (= (fuel-demand city-2-loc-15 city-2-loc-13) 34)
  ; 1857,355 -> 1706,424
  (road city-2-loc-13 city-2-loc-15)
  (= (road-length city-2-loc-13 city-2-loc-15) 17)
  (= (fuel-demand city-2-loc-13 city-2-loc-15) 34)
  ; 1748,171 -> 1830,240
  (road city-2-loc-16 city-2-loc-3)
  (= (road-length city-2-loc-16 city-2-loc-3) 11)
  (= (fuel-demand city-2-loc-16 city-2-loc-3) 22)
  ; 1830,240 -> 1748,171
  (road city-2-loc-3 city-2-loc-16)
  (= (road-length city-2-loc-3 city-2-loc-16) 11)
  (= (fuel-demand city-2-loc-3 city-2-loc-16) 22)
  ; 1748,171 -> 1736,304
  (road city-2-loc-16 city-2-loc-6)
  (= (road-length city-2-loc-16 city-2-loc-6) 14)
  (= (fuel-demand city-2-loc-16 city-2-loc-6) 27)
  ; 1736,304 -> 1748,171
  (road city-2-loc-6 city-2-loc-16)
  (= (road-length city-2-loc-6 city-2-loc-16) 14)
  (= (fuel-demand city-2-loc-6 city-2-loc-16) 27)
  ; 1748,171 -> 1855,164
  (road city-2-loc-16 city-2-loc-8)
  (= (road-length city-2-loc-16 city-2-loc-8) 11)
  (= (fuel-demand city-2-loc-16 city-2-loc-8) 22)
  ; 1855,164 -> 1748,171
  (road city-2-loc-8 city-2-loc-16)
  (= (road-length city-2-loc-8 city-2-loc-16) 11)
  (= (fuel-demand city-2-loc-8 city-2-loc-16) 22)
  ; 1748,171 -> 1857,355
  (road city-2-loc-16 city-2-loc-13)
  (= (road-length city-2-loc-16 city-2-loc-13) 22)
  (= (fuel-demand city-2-loc-16 city-2-loc-13) 43)
  ; 1857,355 -> 1748,171
  (road city-2-loc-13 city-2-loc-16)
  (= (road-length city-2-loc-13 city-2-loc-16) 22)
  (= (fuel-demand city-2-loc-13 city-2-loc-16) 43)
  ; 1614,356 -> 1535,297
  (road city-2-loc-17 city-2-loc-5)
  (= (road-length city-2-loc-17 city-2-loc-5) 10)
  (= (fuel-demand city-2-loc-17 city-2-loc-5) 20)
  ; 1535,297 -> 1614,356
  (road city-2-loc-5 city-2-loc-17)
  (= (road-length city-2-loc-5 city-2-loc-17) 10)
  (= (fuel-demand city-2-loc-5 city-2-loc-17) 20)
  ; 1614,356 -> 1736,304
  (road city-2-loc-17 city-2-loc-6)
  (= (road-length city-2-loc-17 city-2-loc-6) 14)
  (= (fuel-demand city-2-loc-17 city-2-loc-6) 27)
  ; 1736,304 -> 1614,356
  (road city-2-loc-6 city-2-loc-17)
  (= (road-length city-2-loc-6 city-2-loc-17) 14)
  (= (fuel-demand city-2-loc-6 city-2-loc-17) 27)
  ; 1614,356 -> 1713,513
  (road city-2-loc-17 city-2-loc-10)
  (= (road-length city-2-loc-17 city-2-loc-10) 19)
  (= (fuel-demand city-2-loc-17 city-2-loc-10) 38)
  ; 1713,513 -> 1614,356
  (road city-2-loc-10 city-2-loc-17)
  (= (road-length city-2-loc-10 city-2-loc-17) 19)
  (= (fuel-demand city-2-loc-10 city-2-loc-17) 38)
  ; 1614,356 -> 1706,424
  (road city-2-loc-17 city-2-loc-15)
  (= (road-length city-2-loc-17 city-2-loc-15) 12)
  (= (fuel-demand city-2-loc-17 city-2-loc-15) 23)
  ; 1706,424 -> 1614,356
  (road city-2-loc-15 city-2-loc-17)
  (= (road-length city-2-loc-15 city-2-loc-17) 12)
  (= (fuel-demand city-2-loc-15 city-2-loc-17) 23)
  ; 1911,16 -> 2010,44
  (road city-2-loc-18 city-2-loc-1)
  (= (road-length city-2-loc-18 city-2-loc-1) 11)
  (= (fuel-demand city-2-loc-18 city-2-loc-1) 21)
  ; 2010,44 -> 1911,16
  (road city-2-loc-1 city-2-loc-18)
  (= (road-length city-2-loc-1 city-2-loc-18) 11)
  (= (fuel-demand city-2-loc-1 city-2-loc-18) 21)
  ; 1911,16 -> 2055,147
  (road city-2-loc-18 city-2-loc-4)
  (= (road-length city-2-loc-18 city-2-loc-4) 20)
  (= (fuel-demand city-2-loc-18 city-2-loc-4) 39)
  ; 2055,147 -> 1911,16
  (road city-2-loc-4 city-2-loc-18)
  (= (road-length city-2-loc-4 city-2-loc-18) 20)
  (= (fuel-demand city-2-loc-4 city-2-loc-18) 39)
  ; 1911,16 -> 1855,164
  (road city-2-loc-18 city-2-loc-8)
  (= (road-length city-2-loc-18 city-2-loc-8) 16)
  (= (fuel-demand city-2-loc-18 city-2-loc-8) 32)
  ; 1855,164 -> 1911,16
  (road city-2-loc-8 city-2-loc-18)
  (= (road-length city-2-loc-8 city-2-loc-18) 16)
  (= (fuel-demand city-2-loc-8 city-2-loc-18) 32)
  ; 651,181 <-> 1535,297
  (road city-1-loc-12 city-2-loc-5)
  (= (road-length city-1-loc-12 city-2-loc-5) 90)
  (= (fuel-demand city-1-loc-12 city-2-loc-5) 45)
  (road city-2-loc-5 city-1-loc-12)
  (= (road-length city-2-loc-5 city-1-loc-12) 90)
  (= (fuel-demand city-2-loc-5 city-1-loc-12) 45)
  (has-petrol-station city-1-loc-12)
  (has-petrol-station city-2-loc-5)
  (at package-1 city-1-loc-9)
  (= (package-size package-1) 20)
  (at package-2 city-1-loc-9)
  (= (package-size package-2) 93)
  (at package-3 city-1-loc-9)
  (= (package-size package-3) 76)
  (at package-4 city-1-loc-10)
  (= (package-size package-4) 28)
  (at package-5 city-1-loc-16)
  (= (package-size package-5) 51)
  (at package-6 city-1-loc-8)
  (= (package-size package-6) 96)
  (at package-7 city-1-loc-6)
  (= (package-size package-7) 71)
  (at package-8 city-1-loc-4)
  (= (package-size package-8) 28)
  (at package-9 city-1-loc-3)
  (= (package-size package-9) 76)
  (at package-10 city-1-loc-5)
  (= (package-size package-10) 22)
  (at package-11 city-1-loc-4)
  (= (package-size package-11) 41)
  (at package-12 city-1-loc-1)
  (= (package-size package-12) 53)
  (at package-13 city-1-loc-7)
  (= (package-size package-13) 40)
  (at package-14 city-1-loc-12)
  (= (package-size package-14) 31)
  (at truck-1 city-2-loc-5)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 668)
  (= (fuel-max truck-1) 668)
  (at truck-2 city-2-loc-15)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 668)
  (= (fuel-max truck-2) 668)
  (at truck-3 city-2-loc-4)
  (ready-loading truck-3)
  (= (capacity truck-3) 100)
  (= (fuel-left truck-3) 668)
  (= (fuel-max truck-3) 668)
  (at truck-4 city-2-loc-17)
  (ready-loading truck-4)
  (= (capacity truck-4) 100)
  (= (fuel-left truck-4) 668)
  (= (fuel-max truck-4) 668)
 )
 (:goal (and
  (at package-1 city-2-loc-14)
  (at package-2 city-2-loc-18)
  (at package-3 city-2-loc-12)
  (at package-4 city-2-loc-17)
  (at package-5 city-2-loc-17)
  (at package-6 city-2-loc-3)
  (at package-7 city-2-loc-3)
  (at package-8 city-2-loc-18)
  (at package-9 city-2-loc-18)
  (at package-10 city-2-loc-3)
  (at package-11 city-2-loc-17)
  (at package-12 city-2-loc-16)
  (at package-13 city-2-loc-15)
  (at package-14 city-2-loc-3)
 ))
 (:metric minimize (total-time))
)
