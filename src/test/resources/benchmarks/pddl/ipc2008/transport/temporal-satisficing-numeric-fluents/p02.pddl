; Transport p01-10-city-10nodes-1000size-3degree-100mindistance-2trucks-4packagespercity-2008seed

(define (problem transport-p01-10-city-10nodes-1000size-3degree-100mindistance-2trucks-4packagespercity-2008seed)
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
  truck-1 - vehicle
  truck-2 - vehicle
  package-1 - package
  package-2 - package
  package-3 - package
  package-4 - package
 )
 (:init
  ; 748,385 -> 890,543
  (road city-loc-3 city-loc-1)
  (= (road-length city-loc-3 city-loc-1) 22)
  (= (fuel-demand city-loc-3 city-loc-1) 43)
  ; 890,543 -> 748,385
  (road city-loc-1 city-loc-3)
  (= (road-length city-loc-1 city-loc-3) 22)
  (= (fuel-demand city-loc-1 city-loc-3) 43)
  ; 912,799 -> 890,543
  (road city-loc-4 city-loc-1)
  (= (road-length city-loc-4 city-loc-1) 26)
  (= (fuel-demand city-loc-4 city-loc-1) 52)
  ; 890,543 -> 912,799
  (road city-loc-1 city-loc-4)
  (= (road-length city-loc-1 city-loc-4) 26)
  (= (fuel-demand city-loc-1 city-loc-4) 52)
  ; 977,899 -> 890,543
  (road city-loc-5 city-loc-1)
  (= (road-length city-loc-5 city-loc-1) 37)
  (= (fuel-demand city-loc-5 city-loc-1) 74)
  ; 890,543 -> 977,899
  (road city-loc-1 city-loc-5)
  (= (road-length city-loc-1 city-loc-5) 37)
  (= (fuel-demand city-loc-1 city-loc-5) 74)
  ; 977,899 -> 912,799
  (road city-loc-5 city-loc-4)
  (= (road-length city-loc-5 city-loc-4) 12)
  (= (fuel-demand city-loc-5 city-loc-4) 24)
  ; 912,799 -> 977,899
  (road city-loc-4 city-loc-5)
  (= (road-length city-loc-4 city-loc-5) 12)
  (= (fuel-demand city-loc-4 city-loc-5) 24)
  ; 456,221 -> 384,50
  (road city-loc-6 city-loc-2)
  (= (road-length city-loc-6 city-loc-2) 19)
  (= (fuel-demand city-loc-6 city-loc-2) 38)
  ; 384,50 -> 456,221
  (road city-loc-2 city-loc-6)
  (= (road-length city-loc-2 city-loc-6) 19)
  (= (fuel-demand city-loc-2 city-loc-6) 38)
  ; 456,221 -> 748,385
  (road city-loc-6 city-loc-3)
  (= (road-length city-loc-6 city-loc-3) 34)
  (= (fuel-demand city-loc-6 city-loc-3) 67)
  ; 748,385 -> 456,221
  (road city-loc-3 city-loc-6)
  (= (road-length city-loc-3 city-loc-6) 34)
  (= (fuel-demand city-loc-3 city-loc-6) 67)
  ; 742,542 -> 890,543
  (road city-loc-7 city-loc-1)
  (= (road-length city-loc-7 city-loc-1) 15)
  (= (fuel-demand city-loc-7 city-loc-1) 30)
  ; 890,543 -> 742,542
  (road city-loc-1 city-loc-7)
  (= (road-length city-loc-1 city-loc-7) 15)
  (= (fuel-demand city-loc-1 city-loc-7) 30)
  ; 742,542 -> 748,385
  (road city-loc-7 city-loc-3)
  (= (road-length city-loc-7 city-loc-3) 16)
  (= (fuel-demand city-loc-7 city-loc-3) 32)
  ; 748,385 -> 742,542
  (road city-loc-3 city-loc-7)
  (= (road-length city-loc-3 city-loc-7) 16)
  (= (fuel-demand city-loc-3 city-loc-7) 32)
  ; 742,542 -> 912,799
  (road city-loc-7 city-loc-4)
  (= (road-length city-loc-7 city-loc-4) 31)
  (= (fuel-demand city-loc-7 city-loc-4) 62)
  ; 912,799 -> 742,542
  (road city-loc-4 city-loc-7)
  (= (road-length city-loc-4 city-loc-7) 31)
  (= (fuel-demand city-loc-4 city-loc-7) 62)
  ; 564,783 -> 912,799
  (road city-loc-8 city-loc-4)
  (= (road-length city-loc-8 city-loc-4) 35)
  (= (fuel-demand city-loc-8 city-loc-4) 70)
  ; 912,799 -> 564,783
  (road city-loc-4 city-loc-8)
  (= (road-length city-loc-4 city-loc-8) 35)
  (= (fuel-demand city-loc-4 city-loc-8) 70)
  ; 564,783 -> 742,542
  (road city-loc-8 city-loc-7)
  (= (road-length city-loc-8 city-loc-7) 30)
  (= (fuel-demand city-loc-8 city-loc-7) 60)
  ; 742,542 -> 564,783
  (road city-loc-7 city-loc-8)
  (= (road-length city-loc-7 city-loc-8) 30)
  (= (fuel-demand city-loc-7 city-loc-8) 60)
  ; 273,425 -> 456,221
  (road city-loc-9 city-loc-6)
  (= (road-length city-loc-9 city-loc-6) 28)
  (= (fuel-demand city-loc-9 city-loc-6) 55)
  ; 456,221 -> 273,425
  (road city-loc-6 city-loc-9)
  (= (road-length city-loc-6 city-loc-9) 28)
  (= (fuel-demand city-loc-6 city-loc-9) 55)
  ; 566,552 -> 890,543
  (road city-loc-10 city-loc-1)
  (= (road-length city-loc-10 city-loc-1) 33)
  (= (fuel-demand city-loc-10 city-loc-1) 65)
  ; 890,543 -> 566,552
  (road city-loc-1 city-loc-10)
  (= (road-length city-loc-1 city-loc-10) 33)
  (= (fuel-demand city-loc-1 city-loc-10) 65)
  ; 566,552 -> 748,385
  (road city-loc-10 city-loc-3)
  (= (road-length city-loc-10 city-loc-3) 25)
  (= (fuel-demand city-loc-10 city-loc-3) 50)
  ; 748,385 -> 566,552
  (road city-loc-3 city-loc-10)
  (= (road-length city-loc-3 city-loc-10) 25)
  (= (fuel-demand city-loc-3 city-loc-10) 50)
  ; 566,552 -> 456,221
  (road city-loc-10 city-loc-6)
  (= (road-length city-loc-10 city-loc-6) 35)
  (= (fuel-demand city-loc-10 city-loc-6) 70)
  ; 456,221 -> 566,552
  (road city-loc-6 city-loc-10)
  (= (road-length city-loc-6 city-loc-10) 35)
  (= (fuel-demand city-loc-6 city-loc-10) 70)
  ; 566,552 -> 742,542
  (road city-loc-10 city-loc-7)
  (= (road-length city-loc-10 city-loc-7) 18)
  (= (fuel-demand city-loc-10 city-loc-7) 36)
  ; 742,542 -> 566,552
  (road city-loc-7 city-loc-10)
  (= (road-length city-loc-7 city-loc-10) 18)
  (= (fuel-demand city-loc-7 city-loc-10) 36)
  ; 566,552 -> 564,783
  (road city-loc-10 city-loc-8)
  (= (road-length city-loc-10 city-loc-8) 24)
  (= (fuel-demand city-loc-10 city-loc-8) 47)
  ; 564,783 -> 566,552
  (road city-loc-8 city-loc-10)
  (= (road-length city-loc-8 city-loc-10) 24)
  (= (fuel-demand city-loc-8 city-loc-10) 47)
  ; 566,552 -> 273,425
  (road city-loc-10 city-loc-9)
  (= (road-length city-loc-10 city-loc-9) 32)
  (= (fuel-demand city-loc-10 city-loc-9) 64)
  ; 273,425 -> 566,552
  (road city-loc-9 city-loc-10)
  (= (road-length city-loc-9 city-loc-10) 32)
  (= (fuel-demand city-loc-9 city-loc-10) 64)
  (at package-1 city-loc-7)
  (= (package-size package-1) 63)
  (at package-2 city-loc-2)
  (= (package-size package-2) 65)
  (at package-3 city-loc-10)
  (= (package-size package-3) 92)
  (at package-4 city-loc-10)
  (= (package-size package-4) 26)
  (has-petrol-station city-loc-1)
  (at truck-1 city-loc-1)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 441)
  (= (fuel-max truck-1) 441)
  (at truck-2 city-loc-7)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 441)
  (= (fuel-max truck-2) 441)
 )
 (:goal (and
  (at package-1 city-loc-9)
  (at package-2 city-loc-9)
  (at package-3 city-loc-3)
  (at package-4 city-loc-6)
 ))
 (:metric minimize (total-time))
)
