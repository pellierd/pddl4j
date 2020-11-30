; Transport p01-10-city-25nodes-1000size-4degree-100mindistance-3trucks-10packagespercity-2008seed

(define (problem transport-p01-10-city-25nodes-1000size-4degree-100mindistance-3trucks-10packagespercity-2008seed)
 (:domain transport)
 (:objects
  city-loc-1 - location
  city-loc-2 - location
  city-loc-3 - location
  city-loc-4 - location
  city-loc-5 - location
  city-loc-6 - location
  city-loc-7 - location
  city-loc-8 - location
  city-loc-9 - location
  city-loc-10 - location
  city-loc-11 - location
  city-loc-12 - location
  city-loc-13 - location
  city-loc-14 - location
  city-loc-15 - location
  city-loc-16 - location
  city-loc-17 - location
  city-loc-18 - location
  city-loc-19 - location
  city-loc-20 - location
  city-loc-21 - location
  city-loc-22 - location
  city-loc-23 - location
  city-loc-24 - location
  city-loc-25 - location
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
  ; 257,5 -> 6,60
  (road city-loc-4 city-loc-2)
  (= (road-length city-loc-4 city-loc-2) 26)
  (= (fuel-demand city-loc-4 city-loc-2) 52)
  ; 6,60 -> 257,5
  (road city-loc-2 city-loc-4)
  (= (road-length city-loc-2 city-loc-4) 26)
  (= (fuel-demand city-loc-2 city-loc-4) 52)
  ; 559,565 -> 659,497
  (road city-loc-6 city-loc-3)
  (= (road-length city-loc-6 city-loc-3) 13)
  (= (fuel-demand city-loc-6 city-loc-3) 25)
  ; 659,497 -> 559,565
  (road city-loc-3 city-loc-6)
  (= (road-length city-loc-3 city-loc-6) 13)
  (= (fuel-demand city-loc-3 city-loc-6) 25)
  ; 347,149 -> 257,5
  (road city-loc-7 city-loc-4)
  (= (road-length city-loc-7 city-loc-4) 17)
  (= (fuel-demand city-loc-7 city-loc-4) 34)
  ; 257,5 -> 347,149
  (road city-loc-4 city-loc-7)
  (= (road-length city-loc-4 city-loc-7) 17)
  (= (fuel-demand city-loc-4 city-loc-7) 34)
  ; 347,149 -> 245,346
  (road city-loc-7 city-loc-5)
  (= (road-length city-loc-7 city-loc-5) 23)
  (= (fuel-demand city-loc-7 city-loc-5) 45)
  ; 245,346 -> 347,149
  (road city-loc-5 city-loc-7)
  (= (road-length city-loc-5 city-loc-7) 23)
  (= (fuel-demand city-loc-5 city-loc-7) 45)
  ; 336,475 -> 245,346
  (road city-loc-8 city-loc-5)
  (= (road-length city-loc-8 city-loc-5) 16)
  (= (fuel-demand city-loc-8 city-loc-5) 32)
  ; 245,346 -> 336,475
  (road city-loc-5 city-loc-8)
  (= (road-length city-loc-5 city-loc-8) 16)
  (= (fuel-demand city-loc-5 city-loc-8) 32)
  ; 336,475 -> 559,565
  (road city-loc-8 city-loc-6)
  (= (road-length city-loc-8 city-loc-6) 24)
  (= (fuel-demand city-loc-8 city-loc-6) 48)
  ; 559,565 -> 336,475
  (road city-loc-6 city-loc-8)
  (= (road-length city-loc-6 city-loc-8) 24)
  (= (fuel-demand city-loc-6 city-loc-8) 48)
  ; 521,375 -> 659,497
  (road city-loc-10 city-loc-3)
  (= (road-length city-loc-10 city-loc-3) 19)
  (= (fuel-demand city-loc-10 city-loc-3) 37)
  ; 659,497 -> 521,375
  (road city-loc-3 city-loc-10)
  (= (road-length city-loc-3 city-loc-10) 19)
  (= (fuel-demand city-loc-3 city-loc-10) 37)
  ; 521,375 -> 559,565
  (road city-loc-10 city-loc-6)
  (= (road-length city-loc-10 city-loc-6) 20)
  (= (fuel-demand city-loc-10 city-loc-6) 39)
  ; 559,565 -> 521,375
  (road city-loc-6 city-loc-10)
  (= (road-length city-loc-6 city-loc-10) 20)
  (= (fuel-demand city-loc-6 city-loc-10) 39)
  ; 521,375 -> 336,475
  (road city-loc-10 city-loc-8)
  (= (road-length city-loc-10 city-loc-8) 21)
  (= (fuel-demand city-loc-10 city-loc-8) 42)
  ; 336,475 -> 521,375
  (road city-loc-8 city-loc-10)
  (= (road-length city-loc-8 city-loc-10) 21)
  (= (fuel-demand city-loc-8 city-loc-10) 42)
  ; 720,241 -> 659,497
  (road city-loc-12 city-loc-3)
  (= (road-length city-loc-12 city-loc-3) 27)
  (= (fuel-demand city-loc-12 city-loc-3) 53)
  ; 659,497 -> 720,241
  (road city-loc-3 city-loc-12)
  (= (road-length city-loc-3 city-loc-12) 27)
  (= (fuel-demand city-loc-3 city-loc-12) 53)
  ; 720,241 -> 521,375
  (road city-loc-12 city-loc-10)
  (= (road-length city-loc-12 city-loc-10) 24)
  (= (fuel-demand city-loc-12 city-loc-10) 48)
  ; 521,375 -> 720,241
  (road city-loc-10 city-loc-12)
  (= (road-length city-loc-10 city-loc-12) 24)
  (= (fuel-demand city-loc-10 city-loc-12) 48)
  ; 720,241 -> 701,0
  (road city-loc-12 city-loc-11)
  (= (road-length city-loc-12 city-loc-11) 25)
  (= (fuel-demand city-loc-12 city-loc-11) 49)
  ; 701,0 -> 720,241
  (road city-loc-11 city-loc-12)
  (= (road-length city-loc-11 city-loc-12) 25)
  (= (fuel-demand city-loc-11 city-loc-12) 49)
  ; 630,722 -> 748,863
  (road city-loc-13 city-loc-1)
  (= (road-length city-loc-13 city-loc-1) 19)
  (= (fuel-demand city-loc-13 city-loc-1) 37)
  ; 748,863 -> 630,722
  (road city-loc-1 city-loc-13)
  (= (road-length city-loc-1 city-loc-13) 19)
  (= (fuel-demand city-loc-1 city-loc-13) 37)
  ; 630,722 -> 659,497
  (road city-loc-13 city-loc-3)
  (= (road-length city-loc-13 city-loc-3) 23)
  (= (fuel-demand city-loc-13 city-loc-3) 46)
  ; 659,497 -> 630,722
  (road city-loc-3 city-loc-13)
  (= (road-length city-loc-3 city-loc-13) 23)
  (= (fuel-demand city-loc-3 city-loc-13) 46)
  ; 630,722 -> 559,565
  (road city-loc-13 city-loc-6)
  (= (road-length city-loc-13 city-loc-6) 18)
  (= (fuel-demand city-loc-13 city-loc-6) 35)
  ; 559,565 -> 630,722
  (road city-loc-6 city-loc-13)
  (= (road-length city-loc-6 city-loc-13) 18)
  (= (fuel-demand city-loc-6 city-loc-13) 35)
  ; 120,854 -> 170,709
  (road city-loc-14 city-loc-9)
  (= (road-length city-loc-14 city-loc-9) 16)
  (= (fuel-demand city-loc-14 city-loc-9) 31)
  ; 170,709 -> 120,854
  (road city-loc-9 city-loc-14)
  (= (road-length city-loc-9 city-loc-14) 16)
  (= (fuel-demand city-loc-9 city-loc-14) 31)
  ; 377,283 -> 245,346
  (road city-loc-15 city-loc-5)
  (= (road-length city-loc-15 city-loc-5) 15)
  (= (fuel-demand city-loc-15 city-loc-5) 30)
  ; 245,346 -> 377,283
  (road city-loc-5 city-loc-15)
  (= (road-length city-loc-5 city-loc-15) 15)
  (= (fuel-demand city-loc-5 city-loc-15) 30)
  ; 377,283 -> 347,149
  (road city-loc-15 city-loc-7)
  (= (road-length city-loc-15 city-loc-7) 14)
  (= (fuel-demand city-loc-15 city-loc-7) 28)
  ; 347,149 -> 377,283
  (road city-loc-7 city-loc-15)
  (= (road-length city-loc-7 city-loc-15) 14)
  (= (fuel-demand city-loc-7 city-loc-15) 28)
  ; 377,283 -> 336,475
  (road city-loc-15 city-loc-8)
  (= (road-length city-loc-15 city-loc-8) 20)
  (= (fuel-demand city-loc-15 city-loc-8) 40)
  ; 336,475 -> 377,283
  (road city-loc-8 city-loc-15)
  (= (road-length city-loc-8 city-loc-15) 20)
  (= (fuel-demand city-loc-8 city-loc-15) 40)
  ; 377,283 -> 521,375
  (road city-loc-15 city-loc-10)
  (= (road-length city-loc-15 city-loc-10) 18)
  (= (fuel-demand city-loc-15 city-loc-10) 35)
  ; 521,375 -> 377,283
  (road city-loc-10 city-loc-15)
  (= (road-length city-loc-10 city-loc-15) 18)
  (= (fuel-demand city-loc-10 city-loc-15) 35)
  ; 171,545 -> 245,346
  (road city-loc-16 city-loc-5)
  (= (road-length city-loc-16 city-loc-5) 22)
  (= (fuel-demand city-loc-16 city-loc-5) 43)
  ; 245,346 -> 171,545
  (road city-loc-5 city-loc-16)
  (= (road-length city-loc-5 city-loc-16) 22)
  (= (fuel-demand city-loc-5 city-loc-16) 43)
  ; 171,545 -> 336,475
  (road city-loc-16 city-loc-8)
  (= (road-length city-loc-16 city-loc-8) 18)
  (= (fuel-demand city-loc-16 city-loc-8) 36)
  ; 336,475 -> 171,545
  (road city-loc-8 city-loc-16)
  (= (road-length city-loc-8 city-loc-16) 18)
  (= (fuel-demand city-loc-8 city-loc-16) 36)
  ; 171,545 -> 170,709
  (road city-loc-16 city-loc-9)
  (= (road-length city-loc-16 city-loc-9) 17)
  (= (fuel-demand city-loc-16 city-loc-9) 33)
  ; 170,709 -> 171,545
  (road city-loc-9 city-loc-16)
  (= (road-length city-loc-9 city-loc-16) 17)
  (= (fuel-demand city-loc-9 city-loc-16) 33)
  ; 348,607 -> 559,565
  (road city-loc-17 city-loc-6)
  (= (road-length city-loc-17 city-loc-6) 22)
  (= (fuel-demand city-loc-17 city-loc-6) 43)
  ; 559,565 -> 348,607
  (road city-loc-6 city-loc-17)
  (= (road-length city-loc-6 city-loc-17) 22)
  (= (fuel-demand city-loc-6 city-loc-17) 43)
  ; 348,607 -> 336,475
  (road city-loc-17 city-loc-8)
  (= (road-length city-loc-17 city-loc-8) 14)
  (= (fuel-demand city-loc-17 city-loc-8) 27)
  ; 336,475 -> 348,607
  (road city-loc-8 city-loc-17)
  (= (road-length city-loc-8 city-loc-17) 14)
  (= (fuel-demand city-loc-8 city-loc-17) 27)
  ; 348,607 -> 170,709
  (road city-loc-17 city-loc-9)
  (= (road-length city-loc-17 city-loc-9) 21)
  (= (fuel-demand city-loc-17 city-loc-9) 41)
  ; 170,709 -> 348,607
  (road city-loc-9 city-loc-17)
  (= (road-length city-loc-9 city-loc-17) 21)
  (= (fuel-demand city-loc-9 city-loc-17) 41)
  ; 348,607 -> 171,545
  (road city-loc-17 city-loc-16)
  (= (road-length city-loc-17 city-loc-16) 19)
  (= (fuel-demand city-loc-17 city-loc-16) 38)
  ; 171,545 -> 348,607
  (road city-loc-16 city-loc-17)
  (= (road-length city-loc-16 city-loc-17) 19)
  (= (fuel-demand city-loc-16 city-loc-17) 38)
  ; 395,741 -> 559,565
  (road city-loc-18 city-loc-6)
  (= (road-length city-loc-18 city-loc-6) 25)
  (= (fuel-demand city-loc-18 city-loc-6) 49)
  ; 559,565 -> 395,741
  (road city-loc-6 city-loc-18)
  (= (road-length city-loc-6 city-loc-18) 25)
  (= (fuel-demand city-loc-6 city-loc-18) 49)
  ; 395,741 -> 170,709
  (road city-loc-18 city-loc-9)
  (= (road-length city-loc-18 city-loc-9) 23)
  (= (fuel-demand city-loc-18 city-loc-9) 46)
  ; 170,709 -> 395,741
  (road city-loc-9 city-loc-18)
  (= (road-length city-loc-9 city-loc-18) 23)
  (= (fuel-demand city-loc-9 city-loc-18) 46)
  ; 395,741 -> 630,722
  (road city-loc-18 city-loc-13)
  (= (road-length city-loc-18 city-loc-13) 24)
  (= (fuel-demand city-loc-18 city-loc-13) 48)
  ; 630,722 -> 395,741
  (road city-loc-13 city-loc-18)
  (= (road-length city-loc-13 city-loc-18) 24)
  (= (fuel-demand city-loc-13 city-loc-18) 48)
  ; 395,741 -> 348,607
  (road city-loc-18 city-loc-17)
  (= (road-length city-loc-18 city-loc-17) 15)
  (= (fuel-demand city-loc-18 city-loc-17) 29)
  ; 348,607 -> 395,741
  (road city-loc-17 city-loc-18)
  (= (road-length city-loc-17 city-loc-18) 15)
  (= (fuel-demand city-loc-17 city-loc-18) 29)
  ; 71,275 -> 6,60
  (road city-loc-19 city-loc-2)
  (= (road-length city-loc-19 city-loc-2) 23)
  (= (fuel-demand city-loc-19 city-loc-2) 45)
  ; 6,60 -> 71,275
  (road city-loc-2 city-loc-19)
  (= (road-length city-loc-2 city-loc-19) 23)
  (= (fuel-demand city-loc-2 city-loc-19) 45)
  ; 71,275 -> 245,346
  (road city-loc-19 city-loc-5)
  (= (road-length city-loc-19 city-loc-5) 19)
  (= (fuel-demand city-loc-19 city-loc-5) 38)
  ; 245,346 -> 71,275
  (road city-loc-5 city-loc-19)
  (= (road-length city-loc-5 city-loc-19) 19)
  (= (fuel-demand city-loc-5 city-loc-19) 38)
  ; 858,139 -> 701,0
  (road city-loc-20 city-loc-11)
  (= (road-length city-loc-20 city-loc-11) 21)
  (= (fuel-demand city-loc-20 city-loc-11) 42)
  ; 701,0 -> 858,139
  (road city-loc-11 city-loc-20)
  (= (road-length city-loc-11 city-loc-20) 21)
  (= (fuel-demand city-loc-11 city-loc-20) 42)
  ; 858,139 -> 720,241
  (road city-loc-20 city-loc-12)
  (= (road-length city-loc-20 city-loc-12) 18)
  (= (fuel-demand city-loc-20 city-loc-12) 35)
  ; 720,241 -> 858,139
  (road city-loc-12 city-loc-20)
  (= (road-length city-loc-12 city-loc-20) 18)
  (= (fuel-demand city-loc-12 city-loc-20) 35)
  ; 69,508 -> 245,346
  (road city-loc-21 city-loc-5)
  (= (road-length city-loc-21 city-loc-5) 24)
  (= (fuel-demand city-loc-21 city-loc-5) 48)
  ; 245,346 -> 69,508
  (road city-loc-5 city-loc-21)
  (= (road-length city-loc-5 city-loc-21) 24)
  (= (fuel-demand city-loc-5 city-loc-21) 48)
  ; 69,508 -> 336,475
  (road city-loc-21 city-loc-8)
  (= (road-length city-loc-21 city-loc-8) 27)
  (= (fuel-demand city-loc-21 city-loc-8) 54)
  ; 336,475 -> 69,508
  (road city-loc-8 city-loc-21)
  (= (road-length city-loc-8 city-loc-21) 27)
  (= (fuel-demand city-loc-8 city-loc-21) 54)
  ; 69,508 -> 170,709
  (road city-loc-21 city-loc-9)
  (= (road-length city-loc-21 city-loc-9) 23)
  (= (fuel-demand city-loc-21 city-loc-9) 45)
  ; 170,709 -> 69,508
  (road city-loc-9 city-loc-21)
  (= (road-length city-loc-9 city-loc-21) 23)
  (= (fuel-demand city-loc-9 city-loc-21) 45)
  ; 69,508 -> 171,545
  (road city-loc-21 city-loc-16)
  (= (road-length city-loc-21 city-loc-16) 11)
  (= (fuel-demand city-loc-21 city-loc-16) 22)
  ; 171,545 -> 69,508
  (road city-loc-16 city-loc-21)
  (= (road-length city-loc-16 city-loc-21) 11)
  (= (fuel-demand city-loc-16 city-loc-21) 22)
  ; 69,508 -> 71,275
  (road city-loc-21 city-loc-19)
  (= (road-length city-loc-21 city-loc-19) 24)
  (= (fuel-demand city-loc-21 city-loc-19) 47)
  ; 71,275 -> 69,508
  (road city-loc-19 city-loc-21)
  (= (road-length city-loc-19 city-loc-21) 24)
  (= (fuel-demand city-loc-19 city-loc-21) 47)
  ; 203,987 -> 120,854
  (road city-loc-22 city-loc-14)
  (= (road-length city-loc-22 city-loc-14) 16)
  (= (fuel-demand city-loc-22 city-loc-14) 32)
  ; 120,854 -> 203,987
  (road city-loc-14 city-loc-22)
  (= (road-length city-loc-14 city-loc-22) 16)
  (= (fuel-demand city-loc-14 city-loc-22) 32)
  ; 968,863 -> 748,863
  (road city-loc-23 city-loc-1)
  (= (road-length city-loc-23 city-loc-1) 22)
  (= (fuel-demand city-loc-23 city-loc-1) 44)
  ; 748,863 -> 968,863
  (road city-loc-1 city-loc-23)
  (= (road-length city-loc-1 city-loc-23) 22)
  (= (fuel-demand city-loc-1 city-loc-23) 44)
  ; 453,848 -> 630,722
  (road city-loc-24 city-loc-13)
  (= (road-length city-loc-24 city-loc-13) 22)
  (= (fuel-demand city-loc-24 city-loc-13) 44)
  ; 630,722 -> 453,848
  (road city-loc-13 city-loc-24)
  (= (road-length city-loc-13 city-loc-24) 22)
  (= (fuel-demand city-loc-13 city-loc-24) 44)
  ; 453,848 -> 348,607
  (road city-loc-24 city-loc-17)
  (= (road-length city-loc-24 city-loc-17) 27)
  (= (fuel-demand city-loc-24 city-loc-17) 53)
  ; 348,607 -> 453,848
  (road city-loc-17 city-loc-24)
  (= (road-length city-loc-17 city-loc-24) 27)
  (= (fuel-demand city-loc-17 city-loc-24) 53)
  ; 453,848 -> 395,741
  (road city-loc-24 city-loc-18)
  (= (road-length city-loc-24 city-loc-18) 13)
  (= (fuel-demand city-loc-24 city-loc-18) 25)
  ; 395,741 -> 453,848
  (road city-loc-18 city-loc-24)
  (= (road-length city-loc-18 city-loc-24) 13)
  (= (fuel-demand city-loc-18 city-loc-24) 25)
  ; 936,210 -> 720,241
  (road city-loc-25 city-loc-12)
  (= (road-length city-loc-25 city-loc-12) 22)
  (= (fuel-demand city-loc-25 city-loc-12) 44)
  ; 720,241 -> 936,210
  (road city-loc-12 city-loc-25)
  (= (road-length city-loc-12 city-loc-25) 22)
  (= (fuel-demand city-loc-12 city-loc-25) 44)
  ; 936,210 -> 858,139
  (road city-loc-25 city-loc-20)
  (= (road-length city-loc-25 city-loc-20) 11)
  (= (fuel-demand city-loc-25 city-loc-20) 21)
  ; 858,139 -> 936,210
  (road city-loc-20 city-loc-25)
  (= (road-length city-loc-20 city-loc-25) 11)
  (= (fuel-demand city-loc-20 city-loc-25) 21)
  (at package-1 city-loc-5)
  (= (package-size package-1) 43)
  (at package-2 city-loc-16)
  (= (package-size package-2) 72)
  (at package-3 city-loc-13)
  (= (package-size package-3) 44)
  (at package-4 city-loc-23)
  (= (package-size package-4) 35)
  (at package-5 city-loc-17)
  (= (package-size package-5) 24)
  (at package-6 city-loc-15)
  (= (package-size package-6) 91)
  (at package-7 city-loc-12)
  (= (package-size package-7) 74)
  (at package-8 city-loc-17)
  (= (package-size package-8) 41)
  (at package-9 city-loc-10)
  (= (package-size package-9) 95)
  (at package-10 city-loc-24)
  (= (package-size package-10) 74)
  (has-petrol-station city-loc-1)
  (at truck-1 city-loc-13)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 700)
  (= (fuel-max truck-1) 700)
  (at truck-2 city-loc-11)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 700)
  (= (fuel-max truck-2) 700)
  (at truck-3 city-loc-17)
  (ready-loading truck-3)
  (= (capacity truck-3) 100)
  (= (fuel-left truck-3) 700)
  (= (fuel-max truck-3) 700)
 )
 (:goal (and
  (at package-1 city-loc-13)
  (at package-2 city-loc-21)
  (at package-3 city-loc-14)
  (at package-4 city-loc-11)
  (at package-5 city-loc-16)
  (at package-6 city-loc-13)
  (at package-7 city-loc-7)
  (at package-8 city-loc-21)
  (at package-9 city-loc-17)
  (at package-10 city-loc-8)
 ))
 (:metric minimize (total-time))
)
