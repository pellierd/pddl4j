; Transport p01-10-city-20nodes-1000size-4degree-100mindistance-3trucks-8packagespercity-2008seed

(define (problem transport-p01-10-city-20nodes-1000size-4degree-100mindistance-3trucks-8packagespercity-2008seed)
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
  ; 566,552 -> 748,385
  (road city-loc-10 city-loc-3)
  (= (road-length city-loc-10 city-loc-3) 25)
  (= (fuel-demand city-loc-10 city-loc-3) 50)
  ; 748,385 -> 566,552
  (road city-loc-3 city-loc-10)
  (= (road-length city-loc-3 city-loc-10) 25)
  (= (fuel-demand city-loc-3 city-loc-10) 50)
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
  ; 174,643 -> 273,425
  (road city-loc-11 city-loc-9)
  (= (road-length city-loc-11 city-loc-9) 24)
  (= (fuel-demand city-loc-11 city-loc-9) 48)
  ; 273,425 -> 174,643
  (road city-loc-9 city-loc-11)
  (= (road-length city-loc-9 city-loc-11) 24)
  (= (fuel-demand city-loc-9 city-loc-11) 48)
  ; 930,259 -> 890,543
  (road city-loc-12 city-loc-1)
  (= (road-length city-loc-12 city-loc-1) 29)
  (= (fuel-demand city-loc-12 city-loc-1) 58)
  ; 890,543 -> 930,259
  (road city-loc-1 city-loc-12)
  (= (road-length city-loc-1 city-loc-12) 29)
  (= (fuel-demand city-loc-1 city-loc-12) 58)
  ; 930,259 -> 748,385
  (road city-loc-12 city-loc-3)
  (= (road-length city-loc-12 city-loc-3) 23)
  (= (fuel-demand city-loc-12 city-loc-3) 45)
  ; 748,385 -> 930,259
  (road city-loc-3 city-loc-12)
  (= (road-length city-loc-3 city-loc-12) 23)
  (= (fuel-demand city-loc-3 city-loc-12) 45)
  ; 55,605 -> 273,425
  (road city-loc-13 city-loc-9)
  (= (road-length city-loc-13 city-loc-9) 29)
  (= (fuel-demand city-loc-13 city-loc-9) 57)
  ; 273,425 -> 55,605
  (road city-loc-9 city-loc-13)
  (= (road-length city-loc-9 city-loc-13) 29)
  (= (fuel-demand city-loc-9 city-loc-13) 57)
  ; 55,605 -> 174,643
  (road city-loc-13 city-loc-11)
  (= (road-length city-loc-13 city-loc-11) 13)
  (= (fuel-demand city-loc-13 city-loc-11) 25)
  ; 174,643 -> 55,605
  (road city-loc-11 city-loc-13)
  (= (road-length city-loc-11 city-loc-13) 13)
  (= (fuel-demand city-loc-11 city-loc-13) 25)
  ; 803,858 -> 912,799
  (road city-loc-14 city-loc-4)
  (= (road-length city-loc-14 city-loc-4) 13)
  (= (fuel-demand city-loc-14 city-loc-4) 25)
  ; 912,799 -> 803,858
  (road city-loc-4 city-loc-14)
  (= (road-length city-loc-4 city-loc-14) 13)
  (= (fuel-demand city-loc-4 city-loc-14) 25)
  ; 803,858 -> 977,899
  (road city-loc-14 city-loc-5)
  (= (road-length city-loc-14 city-loc-5) 18)
  (= (fuel-demand city-loc-14 city-loc-5) 36)
  ; 977,899 -> 803,858
  (road city-loc-5 city-loc-14)
  (= (road-length city-loc-5 city-loc-14) 18)
  (= (fuel-demand city-loc-5 city-loc-14) 36)
  ; 803,858 -> 564,783
  (road city-loc-14 city-loc-8)
  (= (road-length city-loc-14 city-loc-8) 25)
  (= (fuel-demand city-loc-14 city-loc-8) 50)
  ; 564,783 -> 803,858
  (road city-loc-8 city-loc-14)
  (= (road-length city-loc-8 city-loc-14) 25)
  (= (fuel-demand city-loc-8 city-loc-14) 50)
  ; 263,567 -> 273,425
  (road city-loc-15 city-loc-9)
  (= (road-length city-loc-15 city-loc-9) 15)
  (= (fuel-demand city-loc-15 city-loc-9) 29)
  ; 273,425 -> 263,567
  (road city-loc-9 city-loc-15)
  (= (road-length city-loc-9 city-loc-15) 15)
  (= (fuel-demand city-loc-9 city-loc-15) 29)
  ; 263,567 -> 174,643
  (road city-loc-15 city-loc-11)
  (= (road-length city-loc-15 city-loc-11) 12)
  (= (fuel-demand city-loc-15 city-loc-11) 24)
  ; 174,643 -> 263,567
  (road city-loc-11 city-loc-15)
  (= (road-length city-loc-11 city-loc-15) 12)
  (= (fuel-demand city-loc-11 city-loc-15) 24)
  ; 263,567 -> 55,605
  (road city-loc-15 city-loc-13)
  (= (road-length city-loc-15 city-loc-13) 22)
  (= (fuel-demand city-loc-15 city-loc-13) 43)
  ; 55,605 -> 263,567
  (road city-loc-13 city-loc-15)
  (= (road-length city-loc-13 city-loc-15) 22)
  (= (fuel-demand city-loc-13 city-loc-15) 43)
  ; 128,791 -> 174,643
  (road city-loc-16 city-loc-11)
  (= (road-length city-loc-16 city-loc-11) 16)
  (= (fuel-demand city-loc-16 city-loc-11) 31)
  ; 174,643 -> 128,791
  (road city-loc-11 city-loc-16)
  (= (road-length city-loc-11 city-loc-16) 16)
  (= (fuel-demand city-loc-11 city-loc-16) 31)
  ; 128,791 -> 55,605
  (road city-loc-16 city-loc-13)
  (= (road-length city-loc-16 city-loc-13) 20)
  (= (fuel-demand city-loc-16 city-loc-13) 40)
  ; 55,605 -> 128,791
  (road city-loc-13 city-loc-16)
  (= (road-length city-loc-13 city-loc-16) 20)
  (= (fuel-demand city-loc-13 city-loc-16) 40)
  ; 128,791 -> 263,567
  (road city-loc-16 city-loc-15)
  (= (road-length city-loc-16 city-loc-15) 27)
  (= (fuel-demand city-loc-16 city-loc-15) 53)
  ; 263,567 -> 128,791
  (road city-loc-15 city-loc-16)
  (= (road-length city-loc-15 city-loc-16) 27)
  (= (fuel-demand city-loc-15 city-loc-16) 53)
  ; 426,706 -> 564,783
  (road city-loc-17 city-loc-8)
  (= (road-length city-loc-17 city-loc-8) 16)
  (= (fuel-demand city-loc-17 city-loc-8) 32)
  ; 564,783 -> 426,706
  (road city-loc-8 city-loc-17)
  (= (road-length city-loc-8 city-loc-17) 16)
  (= (fuel-demand city-loc-8 city-loc-17) 32)
  ; 426,706 -> 566,552
  (road city-loc-17 city-loc-10)
  (= (road-length city-loc-17 city-loc-10) 21)
  (= (fuel-demand city-loc-17 city-loc-10) 42)
  ; 566,552 -> 426,706
  (road city-loc-10 city-loc-17)
  (= (road-length city-loc-10 city-loc-17) 21)
  (= (fuel-demand city-loc-10 city-loc-17) 42)
  ; 426,706 -> 174,643
  (road city-loc-17 city-loc-11)
  (= (road-length city-loc-17 city-loc-11) 26)
  (= (fuel-demand city-loc-17 city-loc-11) 52)
  ; 174,643 -> 426,706
  (road city-loc-11 city-loc-17)
  (= (road-length city-loc-11 city-loc-17) 26)
  (= (fuel-demand city-loc-11 city-loc-17) 52)
  ; 426,706 -> 263,567
  (road city-loc-17 city-loc-15)
  (= (road-length city-loc-17 city-loc-15) 22)
  (= (fuel-demand city-loc-17 city-loc-15) 43)
  ; 263,567 -> 426,706
  (road city-loc-15 city-loc-17)
  (= (road-length city-loc-15 city-loc-17) 22)
  (= (fuel-demand city-loc-15 city-loc-17) 43)
  ; 36,368 -> 273,425
  (road city-loc-18 city-loc-9)
  (= (road-length city-loc-18 city-loc-9) 25)
  (= (fuel-demand city-loc-18 city-loc-9) 49)
  ; 273,425 -> 36,368
  (road city-loc-9 city-loc-18)
  (= (road-length city-loc-9 city-loc-18) 25)
  (= (fuel-demand city-loc-9 city-loc-18) 49)
  ; 36,368 -> 55,605
  (road city-loc-18 city-loc-13)
  (= (road-length city-loc-18 city-loc-13) 24)
  (= (fuel-demand city-loc-18 city-loc-13) 48)
  ; 55,605 -> 36,368
  (road city-loc-13 city-loc-18)
  (= (road-length city-loc-13 city-loc-18) 24)
  (= (fuel-demand city-loc-13 city-loc-18) 48)
  ; 36,368 -> 263,567
  (road city-loc-18 city-loc-15)
  (= (road-length city-loc-18 city-loc-15) 31)
  (= (fuel-demand city-loc-18 city-loc-15) 61)
  ; 263,567 -> 36,368
  (road city-loc-15 city-loc-18)
  (= (road-length city-loc-15 city-loc-18) 31)
  (= (fuel-demand city-loc-15 city-loc-18) 61)
  ; 806,18 -> 930,259
  (road city-loc-19 city-loc-12)
  (= (road-length city-loc-19 city-loc-12) 28)
  (= (fuel-demand city-loc-19 city-loc-12) 55)
  ; 930,259 -> 806,18
  (road city-loc-12 city-loc-19)
  (= (road-length city-loc-12 city-loc-19) 28)
  (= (fuel-demand city-loc-12 city-loc-19) 55)
  ; 138,109 -> 384,50
  (road city-loc-20 city-loc-2)
  (= (road-length city-loc-20 city-loc-2) 26)
  (= (fuel-demand city-loc-20 city-loc-2) 51)
  ; 384,50 -> 138,109
  (road city-loc-2 city-loc-20)
  (= (road-length city-loc-2 city-loc-20) 26)
  (= (fuel-demand city-loc-2 city-loc-20) 51)
  ; 138,109 -> 36,368
  (road city-loc-20 city-loc-18)
  (= (road-length city-loc-20 city-loc-18) 28)
  (= (fuel-demand city-loc-20 city-loc-18) 56)
  ; 36,368 -> 138,109
  (road city-loc-18 city-loc-20)
  (= (road-length city-loc-18 city-loc-20) 28)
  (= (fuel-demand city-loc-18 city-loc-20) 56)
  (at package-1 city-loc-8)
  (= (package-size package-1) 44)
  (at package-2 city-loc-17)
  (= (package-size package-2) 87)
  (at package-3 city-loc-5)
  (= (package-size package-3) 89)
  (at package-4 city-loc-6)
  (= (package-size package-4) 88)
  (at package-5 city-loc-1)
  (= (package-size package-5) 30)
  (at package-6 city-loc-14)
  (= (package-size package-6) 1)
  (at package-7 city-loc-20)
  (= (package-size package-7) 46)
  (at package-8 city-loc-2)
  (= (package-size package-8) 78)
  (has-petrol-station city-loc-1)
  (at truck-1 city-loc-20)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 810)
  (= (fuel-max truck-1) 810)
  (at truck-2 city-loc-5)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 810)
  (= (fuel-max truck-2) 810)
  (at truck-3 city-loc-12)
  (ready-loading truck-3)
  (= (capacity truck-3) 100)
  (= (fuel-left truck-3) 810)
  (= (fuel-max truck-3) 810)
 )
 (:goal (and
  (at package-1 city-loc-16)
  (at package-2 city-loc-2)
  (at package-3 city-loc-4)
  (at package-4 city-loc-8)
  (at package-5 city-loc-18)
  (at package-6 city-loc-15)
  (at package-7 city-loc-18)
  (at package-8 city-loc-1)
 ))
 (:metric minimize (total-time))
)
