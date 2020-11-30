; Transport p01-10-city-50nodes-1000size-5degree-100mindistance-4trucks-20packagespercity-2008seed

(define (problem transport-p01-10-city-50nodes-1000size-5degree-100mindistance-4trucks-20packagespercity-2008seed)
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
  city-loc-26 - location
  city-loc-27 - location
  city-loc-28 - location
  city-loc-29 - location
  city-loc-30 - location
  city-loc-31 - location
  city-loc-32 - location
  city-loc-33 - location
  city-loc-34 - location
  city-loc-35 - location
  city-loc-36 - location
  city-loc-37 - location
  city-loc-38 - location
  city-loc-39 - location
  city-loc-40 - location
  city-loc-41 - location
  city-loc-42 - location
  city-loc-43 - location
  city-loc-44 - location
  city-loc-45 - location
  city-loc-46 - location
  city-loc-47 - location
  city-loc-48 - location
  city-loc-49 - location
  city-loc-50 - location
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
  ; 748,385 -> 890,543
  (road city-loc-3 city-loc-1)
  (= (road-length city-loc-3 city-loc-1) 22)
  (= (fuel-demand city-loc-3 city-loc-1) 43)
  ; 890,543 -> 748,385
  (road city-loc-1 city-loc-3)
  (= (road-length city-loc-1 city-loc-3) 22)
  (= (fuel-demand city-loc-1 city-loc-3) 43)
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
  ; 566,552 -> 742,542
  (road city-loc-10 city-loc-7)
  (= (road-length city-loc-10 city-loc-7) 18)
  (= (fuel-demand city-loc-10 city-loc-7) 36)
  ; 742,542 -> 566,552
  (road city-loc-7 city-loc-10)
  (= (road-length city-loc-7 city-loc-10) 18)
  (= (fuel-demand city-loc-7 city-loc-10) 36)
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
  ; 426,706 -> 263,567
  (road city-loc-17 city-loc-15)
  (= (road-length city-loc-17 city-loc-15) 22)
  (= (fuel-demand city-loc-17 city-loc-15) 43)
  ; 263,567 -> 426,706
  (road city-loc-15 city-loc-17)
  (= (road-length city-loc-15 city-loc-17) 22)
  (= (fuel-demand city-loc-15 city-loc-17) 43)
  ; 392,433 -> 273,425
  (road city-loc-21 city-loc-9)
  (= (road-length city-loc-21 city-loc-9) 12)
  (= (fuel-demand city-loc-21 city-loc-9) 24)
  ; 273,425 -> 392,433
  (road city-loc-9 city-loc-21)
  (= (road-length city-loc-9 city-loc-21) 12)
  (= (fuel-demand city-loc-9 city-loc-21) 24)
  ; 392,433 -> 566,552
  (road city-loc-21 city-loc-10)
  (= (road-length city-loc-21 city-loc-10) 22)
  (= (fuel-demand city-loc-21 city-loc-10) 43)
  ; 566,552 -> 392,433
  (road city-loc-10 city-loc-21)
  (= (road-length city-loc-10 city-loc-21) 22)
  (= (fuel-demand city-loc-10 city-loc-21) 43)
  ; 392,433 -> 263,567
  (road city-loc-21 city-loc-15)
  (= (road-length city-loc-21 city-loc-15) 19)
  (= (fuel-demand city-loc-21 city-loc-15) 38)
  ; 263,567 -> 392,433
  (road city-loc-15 city-loc-21)
  (= (road-length city-loc-15 city-loc-21) 19)
  (= (fuel-demand city-loc-15 city-loc-21) 38)
  ; 231,881 -> 128,791
  (road city-loc-22 city-loc-16)
  (= (road-length city-loc-22 city-loc-16) 14)
  (= (fuel-demand city-loc-22 city-loc-16) 28)
  ; 128,791 -> 231,881
  (road city-loc-16 city-loc-22)
  (= (road-length city-loc-16 city-loc-22) 14)
  (= (fuel-demand city-loc-16 city-loc-22) 28)
  ; 682,8 -> 806,18
  (road city-loc-23 city-loc-19)
  (= (road-length city-loc-23 city-loc-19) 13)
  (= (fuel-demand city-loc-23 city-loc-19) 25)
  ; 806,18 -> 682,8
  (road city-loc-19 city-loc-23)
  (= (road-length city-loc-19 city-loc-23) 13)
  (= (fuel-demand city-loc-19 city-loc-23) 25)
  ; 989,457 -> 890,543
  (road city-loc-24 city-loc-1)
  (= (road-length city-loc-24 city-loc-1) 14)
  (= (fuel-demand city-loc-24 city-loc-1) 27)
  ; 890,543 -> 989,457
  (road city-loc-1 city-loc-24)
  (= (road-length city-loc-1 city-loc-24) 14)
  (= (fuel-demand city-loc-1 city-loc-24) 27)
  ; 989,457 -> 930,259
  (road city-loc-24 city-loc-12)
  (= (road-length city-loc-24 city-loc-12) 21)
  (= (fuel-demand city-loc-24 city-loc-12) 42)
  ; 930,259 -> 989,457
  (road city-loc-12 city-loc-24)
  (= (road-length city-loc-12 city-loc-24) 21)
  (= (fuel-demand city-loc-12 city-loc-24) 42)
  ; 362,862 -> 426,706
  (road city-loc-25 city-loc-17)
  (= (road-length city-loc-25 city-loc-17) 17)
  (= (fuel-demand city-loc-25 city-loc-17) 34)
  ; 426,706 -> 362,862
  (road city-loc-17 city-loc-25)
  (= (road-length city-loc-17 city-loc-25) 17)
  (= (fuel-demand city-loc-17 city-loc-25) 34)
  ; 362,862 -> 231,881
  (road city-loc-25 city-loc-22)
  (= (road-length city-loc-25 city-loc-22) 14)
  (= (fuel-demand city-loc-25 city-loc-22) 27)
  ; 231,881 -> 362,862
  (road city-loc-22 city-loc-25)
  (= (road-length city-loc-22 city-loc-25) 14)
  (= (fuel-demand city-loc-22 city-loc-25) 27)
  ; 6,60 -> 138,109
  (road city-loc-26 city-loc-20)
  (= (road-length city-loc-26 city-loc-20) 15)
  (= (fuel-demand city-loc-26 city-loc-20) 29)
  ; 138,109 -> 6,60
  (road city-loc-20 city-loc-26)
  (= (road-length city-loc-20 city-loc-26) 15)
  (= (fuel-demand city-loc-20 city-loc-26) 29)
  ; 257,5 -> 384,50
  (road city-loc-27 city-loc-2)
  (= (road-length city-loc-27 city-loc-2) 14)
  (= (fuel-demand city-loc-27 city-loc-2) 27)
  ; 384,50 -> 257,5
  (road city-loc-2 city-loc-27)
  (= (road-length city-loc-2 city-loc-27) 14)
  (= (fuel-demand city-loc-2 city-loc-27) 27)
  ; 257,5 -> 138,109
  (road city-loc-27 city-loc-20)
  (= (road-length city-loc-27 city-loc-20) 16)
  (= (fuel-demand city-loc-27 city-loc-20) 32)
  ; 138,109 -> 257,5
  (road city-loc-20 city-loc-27)
  (= (road-length city-loc-20 city-loc-27) 16)
  (= (fuel-demand city-loc-20 city-loc-27) 32)
  ; 347,149 -> 384,50
  (road city-loc-28 city-loc-2)
  (= (road-length city-loc-28 city-loc-2) 11)
  (= (fuel-demand city-loc-28 city-loc-2) 22)
  ; 384,50 -> 347,149
  (road city-loc-2 city-loc-28)
  (= (road-length city-loc-2 city-loc-28) 11)
  (= (fuel-demand city-loc-2 city-loc-28) 22)
  ; 347,149 -> 456,221
  (road city-loc-28 city-loc-6)
  (= (road-length city-loc-28 city-loc-6) 14)
  (= (fuel-demand city-loc-28 city-loc-6) 27)
  ; 456,221 -> 347,149
  (road city-loc-6 city-loc-28)
  (= (road-length city-loc-6 city-loc-28) 14)
  (= (fuel-demand city-loc-6 city-loc-28) 27)
  ; 347,149 -> 138,109
  (road city-loc-28 city-loc-20)
  (= (road-length city-loc-28 city-loc-20) 22)
  (= (fuel-demand city-loc-28 city-loc-20) 43)
  ; 138,109 -> 347,149
  (road city-loc-20 city-loc-28)
  (= (road-length city-loc-20 city-loc-28) 22)
  (= (fuel-demand city-loc-20 city-loc-28) 43)
  ; 347,149 -> 257,5
  (road city-loc-28 city-loc-27)
  (= (road-length city-loc-28 city-loc-27) 17)
  (= (fuel-demand city-loc-28 city-loc-27) 34)
  ; 257,5 -> 347,149
  (road city-loc-27 city-loc-28)
  (= (road-length city-loc-27 city-loc-28) 17)
  (= (fuel-demand city-loc-27 city-loc-28) 34)
  ; 521,375 -> 456,221
  (road city-loc-29 city-loc-6)
  (= (road-length city-loc-29 city-loc-6) 17)
  (= (fuel-demand city-loc-29 city-loc-6) 34)
  ; 456,221 -> 521,375
  (road city-loc-6 city-loc-29)
  (= (road-length city-loc-6 city-loc-29) 17)
  (= (fuel-demand city-loc-6 city-loc-29) 34)
  ; 521,375 -> 566,552
  (road city-loc-29 city-loc-10)
  (= (road-length city-loc-29 city-loc-10) 19)
  (= (fuel-demand city-loc-29 city-loc-10) 37)
  ; 566,552 -> 521,375
  (road city-loc-10 city-loc-29)
  (= (road-length city-loc-10 city-loc-29) 19)
  (= (fuel-demand city-loc-10 city-loc-29) 37)
  ; 521,375 -> 392,433
  (road city-loc-29 city-loc-21)
  (= (road-length city-loc-29 city-loc-21) 15)
  (= (fuel-demand city-loc-29 city-loc-21) 29)
  ; 392,433 -> 521,375
  (road city-loc-21 city-loc-29)
  (= (road-length city-loc-21 city-loc-29) 15)
  (= (fuel-demand city-loc-21 city-loc-29) 29)
  ; 720,241 -> 748,385
  (road city-loc-30 city-loc-3)
  (= (road-length city-loc-30 city-loc-3) 15)
  (= (fuel-demand city-loc-30 city-loc-3) 30)
  ; 748,385 -> 720,241
  (road city-loc-3 city-loc-30)
  (= (road-length city-loc-3 city-loc-30) 15)
  (= (fuel-demand city-loc-3 city-loc-30) 30)
  ; 720,241 -> 930,259
  (road city-loc-30 city-loc-12)
  (= (road-length city-loc-30 city-loc-12) 22)
  (= (fuel-demand city-loc-30 city-loc-12) 43)
  ; 930,259 -> 720,241
  (road city-loc-12 city-loc-30)
  (= (road-length city-loc-12 city-loc-30) 22)
  (= (fuel-demand city-loc-12 city-loc-30) 43)
  ; 377,283 -> 456,221
  (road city-loc-31 city-loc-6)
  (= (road-length city-loc-31 city-loc-6) 10)
  (= (fuel-demand city-loc-31 city-loc-6) 20)
  ; 456,221 -> 377,283
  (road city-loc-6 city-loc-31)
  (= (road-length city-loc-6 city-loc-31) 10)
  (= (fuel-demand city-loc-6 city-loc-31) 20)
  ; 377,283 -> 273,425
  (road city-loc-31 city-loc-9)
  (= (road-length city-loc-31 city-loc-9) 18)
  (= (fuel-demand city-loc-31 city-loc-9) 36)
  ; 273,425 -> 377,283
  (road city-loc-9 city-loc-31)
  (= (road-length city-loc-9 city-loc-31) 18)
  (= (fuel-demand city-loc-9 city-loc-31) 36)
  ; 377,283 -> 392,433
  (road city-loc-31 city-loc-21)
  (= (road-length city-loc-31 city-loc-21) 16)
  (= (fuel-demand city-loc-31 city-loc-21) 31)
  ; 392,433 -> 377,283
  (road city-loc-21 city-loc-31)
  (= (road-length city-loc-21 city-loc-31) 16)
  (= (fuel-demand city-loc-21 city-loc-31) 31)
  ; 377,283 -> 347,149
  (road city-loc-31 city-loc-28)
  (= (road-length city-loc-31 city-loc-28) 14)
  (= (fuel-demand city-loc-31 city-loc-28) 28)
  ; 347,149 -> 377,283
  (road city-loc-28 city-loc-31)
  (= (road-length city-loc-28 city-loc-31) 14)
  (= (fuel-demand city-loc-28 city-loc-31) 28)
  ; 377,283 -> 521,375
  (road city-loc-31 city-loc-29)
  (= (road-length city-loc-31 city-loc-29) 18)
  (= (fuel-demand city-loc-31 city-loc-29) 35)
  ; 521,375 -> 377,283
  (road city-loc-29 city-loc-31)
  (= (road-length city-loc-29 city-loc-31) 18)
  (= (fuel-demand city-loc-29 city-loc-31) 35)
  ; 643,669 -> 742,542
  (road city-loc-32 city-loc-7)
  (= (road-length city-loc-32 city-loc-7) 17)
  (= (fuel-demand city-loc-32 city-loc-7) 33)
  ; 742,542 -> 643,669
  (road city-loc-7 city-loc-32)
  (= (road-length city-loc-7 city-loc-32) 17)
  (= (fuel-demand city-loc-7 city-loc-32) 33)
  ; 643,669 -> 564,783
  (road city-loc-32 city-loc-8)
  (= (road-length city-loc-32 city-loc-8) 14)
  (= (fuel-demand city-loc-32 city-loc-8) 28)
  ; 564,783 -> 643,669
  (road city-loc-8 city-loc-32)
  (= (road-length city-loc-8 city-loc-32) 14)
  (= (fuel-demand city-loc-8 city-loc-32) 28)
  ; 643,669 -> 566,552
  (road city-loc-32 city-loc-10)
  (= (road-length city-loc-32 city-loc-10) 14)
  (= (fuel-demand city-loc-32 city-loc-10) 28)
  ; 566,552 -> 643,669
  (road city-loc-10 city-loc-32)
  (= (road-length city-loc-10 city-loc-32) 14)
  (= (fuel-demand city-loc-10 city-loc-32) 28)
  ; 858,139 -> 930,259
  (road city-loc-33 city-loc-12)
  (= (road-length city-loc-33 city-loc-12) 14)
  (= (fuel-demand city-loc-33 city-loc-12) 28)
  ; 930,259 -> 858,139
  (road city-loc-12 city-loc-33)
  (= (road-length city-loc-12 city-loc-33) 14)
  (= (fuel-demand city-loc-12 city-loc-33) 28)
  ; 858,139 -> 806,18
  (road city-loc-33 city-loc-19)
  (= (road-length city-loc-33 city-loc-19) 14)
  (= (fuel-demand city-loc-33 city-loc-19) 27)
  ; 806,18 -> 858,139
  (road city-loc-19 city-loc-33)
  (= (road-length city-loc-19 city-loc-33) 14)
  (= (fuel-demand city-loc-19 city-loc-33) 27)
  ; 858,139 -> 720,241
  (road city-loc-33 city-loc-30)
  (= (road-length city-loc-33 city-loc-30) 18)
  (= (fuel-demand city-loc-33 city-loc-30) 35)
  ; 720,241 -> 858,139
  (road city-loc-30 city-loc-33)
  (= (road-length city-loc-30 city-loc-33) 18)
  (= (fuel-demand city-loc-30 city-loc-33) 35)
  ; 203,987 -> 128,791
  (road city-loc-34 city-loc-16)
  (= (road-length city-loc-34 city-loc-16) 21)
  (= (fuel-demand city-loc-34 city-loc-16) 42)
  ; 128,791 -> 203,987
  (road city-loc-16 city-loc-34)
  (= (road-length city-loc-16 city-loc-34) 21)
  (= (fuel-demand city-loc-16 city-loc-34) 42)
  ; 203,987 -> 231,881
  (road city-loc-34 city-loc-22)
  (= (road-length city-loc-34 city-loc-22) 11)
  (= (fuel-demand city-loc-34 city-loc-22) 22)
  ; 231,881 -> 203,987
  (road city-loc-22 city-loc-34)
  (= (road-length city-loc-22 city-loc-34) 11)
  (= (fuel-demand city-loc-22 city-loc-34) 22)
  ; 203,987 -> 362,862
  (road city-loc-34 city-loc-25)
  (= (road-length city-loc-34 city-loc-25) 21)
  (= (fuel-demand city-loc-34 city-loc-25) 41)
  ; 362,862 -> 203,987
  (road city-loc-25 city-loc-34)
  (= (road-length city-loc-25 city-loc-34) 21)
  (= (fuel-demand city-loc-25 city-loc-34) 41)
  ; 560,901 -> 564,783
  (road city-loc-35 city-loc-8)
  (= (road-length city-loc-35 city-loc-8) 12)
  (= (fuel-demand city-loc-35 city-loc-8) 24)
  ; 564,783 -> 560,901
  (road city-loc-8 city-loc-35)
  (= (road-length city-loc-8 city-loc-35) 12)
  (= (fuel-demand city-loc-8 city-loc-35) 24)
  ; 560,901 -> 362,862
  (road city-loc-35 city-loc-25)
  (= (road-length city-loc-35 city-loc-25) 21)
  (= (fuel-demand city-loc-35 city-loc-25) 41)
  ; 362,862 -> 560,901
  (road city-loc-25 city-loc-35)
  (= (road-length city-loc-25 city-loc-35) 21)
  (= (fuel-demand city-loc-25 city-loc-35) 41)
  ; 437,605 -> 566,552
  (road city-loc-36 city-loc-10)
  (= (road-length city-loc-36 city-loc-10) 14)
  (= (fuel-demand city-loc-36 city-loc-10) 28)
  ; 566,552 -> 437,605
  (road city-loc-10 city-loc-36)
  (= (road-length city-loc-10 city-loc-36) 14)
  (= (fuel-demand city-loc-10 city-loc-36) 28)
  ; 437,605 -> 263,567
  (road city-loc-36 city-loc-15)
  (= (road-length city-loc-36 city-loc-15) 18)
  (= (fuel-demand city-loc-36 city-loc-15) 36)
  ; 263,567 -> 437,605
  (road city-loc-15 city-loc-36)
  (= (road-length city-loc-15 city-loc-36) 18)
  (= (fuel-demand city-loc-15 city-loc-36) 36)
  ; 437,605 -> 426,706
  (road city-loc-36 city-loc-17)
  (= (road-length city-loc-36 city-loc-17) 11)
  (= (fuel-demand city-loc-36 city-loc-17) 21)
  ; 426,706 -> 437,605
  (road city-loc-17 city-loc-36)
  (= (road-length city-loc-17 city-loc-36) 11)
  (= (fuel-demand city-loc-17 city-loc-36) 21)
  ; 437,605 -> 392,433
  (road city-loc-36 city-loc-21)
  (= (road-length city-loc-36 city-loc-21) 18)
  (= (fuel-demand city-loc-36 city-loc-21) 36)
  ; 392,433 -> 437,605
  (road city-loc-21 city-loc-36)
  (= (road-length city-loc-21 city-loc-36) 18)
  (= (fuel-demand city-loc-21 city-loc-36) 36)
  ; 806,647 -> 890,543
  (road city-loc-37 city-loc-1)
  (= (road-length city-loc-37 city-loc-1) 14)
  (= (fuel-demand city-loc-37 city-loc-1) 27)
  ; 890,543 -> 806,647
  (road city-loc-1 city-loc-37)
  (= (road-length city-loc-1 city-loc-37) 14)
  (= (fuel-demand city-loc-1 city-loc-37) 27)
  ; 806,647 -> 912,799
  (road city-loc-37 city-loc-4)
  (= (road-length city-loc-37 city-loc-4) 19)
  (= (fuel-demand city-loc-37 city-loc-4) 37)
  ; 912,799 -> 806,647
  (road city-loc-4 city-loc-37)
  (= (road-length city-loc-4 city-loc-37) 19)
  (= (fuel-demand city-loc-4 city-loc-37) 37)
  ; 806,647 -> 742,542
  (road city-loc-37 city-loc-7)
  (= (road-length city-loc-37 city-loc-7) 13)
  (= (fuel-demand city-loc-37 city-loc-7) 25)
  ; 742,542 -> 806,647
  (road city-loc-7 city-loc-37)
  (= (road-length city-loc-7 city-loc-37) 13)
  (= (fuel-demand city-loc-7 city-loc-37) 25)
  ; 806,647 -> 803,858
  (road city-loc-37 city-loc-14)
  (= (road-length city-loc-37 city-loc-14) 22)
  (= (fuel-demand city-loc-37 city-loc-14) 43)
  ; 803,858 -> 806,647
  (road city-loc-14 city-loc-37)
  (= (road-length city-loc-14 city-loc-37) 22)
  (= (fuel-demand city-loc-14 city-loc-37) 43)
  ; 806,647 -> 643,669
  (road city-loc-37 city-loc-32)
  (= (road-length city-loc-37 city-loc-32) 17)
  (= (fuel-demand city-loc-37 city-loc-32) 33)
  ; 643,669 -> 806,647
  (road city-loc-32 city-loc-37)
  (= (road-length city-loc-32 city-loc-37) 17)
  (= (fuel-demand city-loc-32 city-loc-37) 33)
  ; 339,962 -> 231,881
  (road city-loc-38 city-loc-22)
  (= (road-length city-loc-38 city-loc-22) 14)
  (= (fuel-demand city-loc-38 city-loc-22) 27)
  ; 231,881 -> 339,962
  (road city-loc-22 city-loc-38)
  (= (road-length city-loc-22 city-loc-38) 14)
  (= (fuel-demand city-loc-22 city-loc-38) 27)
  ; 339,962 -> 362,862
  (road city-loc-38 city-loc-25)
  (= (road-length city-loc-38 city-loc-25) 11)
  (= (fuel-demand city-loc-38 city-loc-25) 21)
  ; 362,862 -> 339,962
  (road city-loc-25 city-loc-38)
  (= (road-length city-loc-25 city-loc-38) 11)
  (= (fuel-demand city-loc-25 city-loc-38) 21)
  ; 339,962 -> 203,987
  (road city-loc-38 city-loc-34)
  (= (road-length city-loc-38 city-loc-34) 14)
  (= (fuel-demand city-loc-38 city-loc-34) 28)
  ; 203,987 -> 339,962
  (road city-loc-34 city-loc-38)
  (= (road-length city-loc-34 city-loc-38) 14)
  (= (fuel-demand city-loc-34 city-loc-38) 28)
  ; 463,927 -> 564,783
  (road city-loc-39 city-loc-8)
  (= (road-length city-loc-39 city-loc-8) 18)
  (= (fuel-demand city-loc-39 city-loc-8) 36)
  ; 564,783 -> 463,927
  (road city-loc-8 city-loc-39)
  (= (road-length city-loc-8 city-loc-39) 18)
  (= (fuel-demand city-loc-8 city-loc-39) 36)
  ; 463,927 -> 362,862
  (road city-loc-39 city-loc-25)
  (= (road-length city-loc-39 city-loc-25) 12)
  (= (fuel-demand city-loc-39 city-loc-25) 24)
  ; 362,862 -> 463,927
  (road city-loc-25 city-loc-39)
  (= (road-length city-loc-25 city-loc-39) 12)
  (= (fuel-demand city-loc-25 city-loc-39) 24)
  ; 463,927 -> 560,901
  (road city-loc-39 city-loc-35)
  (= (road-length city-loc-39 city-loc-35) 10)
  (= (fuel-demand city-loc-39 city-loc-35) 20)
  ; 560,901 -> 463,927
  (road city-loc-35 city-loc-39)
  (= (road-length city-loc-35 city-loc-39) 10)
  (= (fuel-demand city-loc-35 city-loc-39) 20)
  ; 463,927 -> 339,962
  (road city-loc-39 city-loc-38)
  (= (road-length city-loc-39 city-loc-38) 13)
  (= (fuel-demand city-loc-39 city-loc-38) 26)
  ; 339,962 -> 463,927
  (road city-loc-38 city-loc-39)
  (= (road-length city-loc-38 city-loc-39) 13)
  (= (fuel-demand city-loc-38 city-loc-39) 26)
  ; 281,709 -> 174,643
  (road city-loc-40 city-loc-11)
  (= (road-length city-loc-40 city-loc-11) 13)
  (= (fuel-demand city-loc-40 city-loc-11) 26)
  ; 174,643 -> 281,709
  (road city-loc-11 city-loc-40)
  (= (road-length city-loc-11 city-loc-40) 13)
  (= (fuel-demand city-loc-11 city-loc-40) 26)
  ; 281,709 -> 263,567
  (road city-loc-40 city-loc-15)
  (= (road-length city-loc-40 city-loc-15) 15)
  (= (fuel-demand city-loc-40 city-loc-15) 29)
  ; 263,567 -> 281,709
  (road city-loc-15 city-loc-40)
  (= (road-length city-loc-15 city-loc-40) 15)
  (= (fuel-demand city-loc-15 city-loc-40) 29)
  ; 281,709 -> 128,791
  (road city-loc-40 city-loc-16)
  (= (road-length city-loc-40 city-loc-16) 18)
  (= (fuel-demand city-loc-40 city-loc-16) 35)
  ; 128,791 -> 281,709
  (road city-loc-16 city-loc-40)
  (= (road-length city-loc-16 city-loc-40) 18)
  (= (fuel-demand city-loc-16 city-loc-40) 35)
  ; 281,709 -> 426,706
  (road city-loc-40 city-loc-17)
  (= (road-length city-loc-40 city-loc-17) 15)
  (= (fuel-demand city-loc-40 city-loc-17) 29)
  ; 426,706 -> 281,709
  (road city-loc-17 city-loc-40)
  (= (road-length city-loc-17 city-loc-40) 15)
  (= (fuel-demand city-loc-17 city-loc-40) 29)
  ; 281,709 -> 231,881
  (road city-loc-40 city-loc-22)
  (= (road-length city-loc-40 city-loc-22) 18)
  (= (fuel-demand city-loc-40 city-loc-22) 36)
  ; 231,881 -> 281,709
  (road city-loc-22 city-loc-40)
  (= (road-length city-loc-22 city-loc-40) 18)
  (= (fuel-demand city-loc-22 city-loc-40) 36)
  ; 281,709 -> 362,862
  (road city-loc-40 city-loc-25)
  (= (road-length city-loc-40 city-loc-25) 18)
  (= (fuel-demand city-loc-40 city-loc-25) 35)
  ; 362,862 -> 281,709
  (road city-loc-25 city-loc-40)
  (= (road-length city-loc-25 city-loc-40) 18)
  (= (fuel-demand city-loc-25 city-loc-40) 35)
  ; 281,709 -> 437,605
  (road city-loc-40 city-loc-36)
  (= (road-length city-loc-40 city-loc-36) 19)
  (= (fuel-demand city-loc-40 city-loc-36) 38)
  ; 437,605 -> 281,709
  (road city-loc-36 city-loc-40)
  (= (road-length city-loc-36 city-loc-40) 19)
  (= (fuel-demand city-loc-36 city-loc-40) 38)
  ; 205,275 -> 273,425
  (road city-loc-41 city-loc-9)
  (= (road-length city-loc-41 city-loc-9) 17)
  (= (fuel-demand city-loc-41 city-loc-9) 33)
  ; 273,425 -> 205,275
  (road city-loc-9 city-loc-41)
  (= (road-length city-loc-9 city-loc-41) 17)
  (= (fuel-demand city-loc-9 city-loc-41) 33)
  ; 205,275 -> 36,368
  (road city-loc-41 city-loc-18)
  (= (road-length city-loc-41 city-loc-18) 20)
  (= (fuel-demand city-loc-41 city-loc-18) 39)
  ; 36,368 -> 205,275
  (road city-loc-18 city-loc-41)
  (= (road-length city-loc-18 city-loc-41) 20)
  (= (fuel-demand city-loc-18 city-loc-41) 39)
  ; 205,275 -> 138,109
  (road city-loc-41 city-loc-20)
  (= (road-length city-loc-41 city-loc-20) 18)
  (= (fuel-demand city-loc-41 city-loc-20) 36)
  ; 138,109 -> 205,275
  (road city-loc-20 city-loc-41)
  (= (road-length city-loc-20 city-loc-41) 18)
  (= (fuel-demand city-loc-20 city-loc-41) 36)
  ; 205,275 -> 347,149
  (road city-loc-41 city-loc-28)
  (= (road-length city-loc-41 city-loc-28) 19)
  (= (fuel-demand city-loc-41 city-loc-28) 38)
  ; 347,149 -> 205,275
  (road city-loc-28 city-loc-41)
  (= (road-length city-loc-28 city-loc-41) 19)
  (= (fuel-demand city-loc-28 city-loc-41) 38)
  ; 205,275 -> 377,283
  (road city-loc-41 city-loc-31)
  (= (road-length city-loc-41 city-loc-31) 18)
  (= (fuel-demand city-loc-41 city-loc-31) 35)
  ; 377,283 -> 205,275
  (road city-loc-31 city-loc-41)
  (= (road-length city-loc-31 city-loc-41) 18)
  (= (fuel-demand city-loc-31 city-loc-41) 35)
  ; 612,304 -> 748,385
  (road city-loc-42 city-loc-3)
  (= (road-length city-loc-42 city-loc-3) 16)
  (= (fuel-demand city-loc-42 city-loc-3) 32)
  ; 748,385 -> 612,304
  (road city-loc-3 city-loc-42)
  (= (road-length city-loc-3 city-loc-42) 16)
  (= (fuel-demand city-loc-3 city-loc-42) 32)
  ; 612,304 -> 456,221
  (road city-loc-42 city-loc-6)
  (= (road-length city-loc-42 city-loc-6) 18)
  (= (fuel-demand city-loc-42 city-loc-6) 36)
  ; 456,221 -> 612,304
  (road city-loc-6 city-loc-42)
  (= (road-length city-loc-6 city-loc-42) 18)
  (= (fuel-demand city-loc-6 city-loc-42) 36)
  ; 612,304 -> 521,375
  (road city-loc-42 city-loc-29)
  (= (road-length city-loc-42 city-loc-29) 12)
  (= (fuel-demand city-loc-42 city-loc-29) 23)
  ; 521,375 -> 612,304
  (road city-loc-29 city-loc-42)
  (= (road-length city-loc-29 city-loc-42) 12)
  (= (fuel-demand city-loc-29 city-loc-42) 23)
  ; 612,304 -> 720,241
  (road city-loc-42 city-loc-30)
  (= (road-length city-loc-42 city-loc-30) 13)
  (= (fuel-demand city-loc-42 city-loc-30) 25)
  ; 720,241 -> 612,304
  (road city-loc-30 city-loc-42)
  (= (road-length city-loc-30 city-loc-42) 13)
  (= (fuel-demand city-loc-30 city-loc-42) 25)
  ; 660,909 -> 564,783
  (road city-loc-43 city-loc-8)
  (= (road-length city-loc-43 city-loc-8) 16)
  (= (fuel-demand city-loc-43 city-loc-8) 32)
  ; 564,783 -> 660,909
  (road city-loc-8 city-loc-43)
  (= (road-length city-loc-8 city-loc-43) 16)
  (= (fuel-demand city-loc-8 city-loc-43) 32)
  ; 660,909 -> 803,858
  (road city-loc-43 city-loc-14)
  (= (road-length city-loc-43 city-loc-14) 16)
  (= (fuel-demand city-loc-43 city-loc-14) 31)
  ; 803,858 -> 660,909
  (road city-loc-14 city-loc-43)
  (= (road-length city-loc-14 city-loc-43) 16)
  (= (fuel-demand city-loc-14 city-loc-43) 31)
  ; 660,909 -> 560,901
  (road city-loc-43 city-loc-35)
  (= (road-length city-loc-43 city-loc-35) 10)
  (= (fuel-demand city-loc-43 city-loc-35) 20)
  ; 560,901 -> 660,909
  (road city-loc-35 city-loc-43)
  (= (road-length city-loc-35 city-loc-43) 10)
  (= (fuel-demand city-loc-35 city-loc-43) 20)
  ; 660,909 -> 463,927
  (road city-loc-43 city-loc-39)
  (= (road-length city-loc-43 city-loc-39) 20)
  (= (fuel-demand city-loc-43 city-loc-39) 40)
  ; 463,927 -> 660,909
  (road city-loc-39 city-loc-43)
  (= (road-length city-loc-39 city-loc-43) 20)
  (= (fuel-demand city-loc-39 city-loc-43) 40)
  ; 966,112 -> 930,259
  (road city-loc-44 city-loc-12)
  (= (road-length city-loc-44 city-loc-12) 16)
  (= (fuel-demand city-loc-44 city-loc-12) 31)
  ; 930,259 -> 966,112
  (road city-loc-12 city-loc-44)
  (= (road-length city-loc-12 city-loc-44) 16)
  (= (fuel-demand city-loc-12 city-loc-44) 31)
  ; 966,112 -> 806,18
  (road city-loc-44 city-loc-19)
  (= (road-length city-loc-44 city-loc-19) 19)
  (= (fuel-demand city-loc-44 city-loc-19) 38)
  ; 806,18 -> 966,112
  (road city-loc-19 city-loc-44)
  (= (road-length city-loc-19 city-loc-44) 19)
  (= (fuel-demand city-loc-19 city-loc-44) 38)
  ; 966,112 -> 858,139
  (road city-loc-44 city-loc-33)
  (= (road-length city-loc-44 city-loc-33) 12)
  (= (fuel-demand city-loc-44 city-loc-33) 23)
  ; 858,139 -> 966,112
  (road city-loc-33 city-loc-44)
  (= (road-length city-loc-33 city-loc-44) 12)
  (= (fuel-demand city-loc-33 city-loc-44) 23)
  ; 599,133 -> 456,221
  (road city-loc-45 city-loc-6)
  (= (road-length city-loc-45 city-loc-6) 17)
  (= (fuel-demand city-loc-45 city-loc-6) 34)
  ; 456,221 -> 599,133
  (road city-loc-6 city-loc-45)
  (= (road-length city-loc-6 city-loc-45) 17)
  (= (fuel-demand city-loc-6 city-loc-45) 34)
  ; 599,133 -> 682,8
  (road city-loc-45 city-loc-23)
  (= (road-length city-loc-45 city-loc-23) 15)
  (= (fuel-demand city-loc-45 city-loc-23) 30)
  ; 682,8 -> 599,133
  (road city-loc-23 city-loc-45)
  (= (road-length city-loc-23 city-loc-45) 15)
  (= (fuel-demand city-loc-23 city-loc-45) 30)
  ; 599,133 -> 720,241
  (road city-loc-45 city-loc-30)
  (= (road-length city-loc-45 city-loc-30) 17)
  (= (fuel-demand city-loc-45 city-loc-30) 33)
  ; 720,241 -> 599,133
  (road city-loc-30 city-loc-45)
  (= (road-length city-loc-30 city-loc-45) 17)
  (= (fuel-demand city-loc-30 city-loc-45) 33)
  ; 599,133 -> 612,304
  (road city-loc-45 city-loc-42)
  (= (road-length city-loc-45 city-loc-42) 18)
  (= (fuel-demand city-loc-45 city-loc-42) 35)
  ; 612,304 -> 599,133
  (road city-loc-42 city-loc-45)
  (= (road-length city-loc-42 city-loc-45) 18)
  (= (fuel-demand city-loc-42 city-loc-45) 35)
  ; 720,128 -> 806,18
  (road city-loc-46 city-loc-19)
  (= (road-length city-loc-46 city-loc-19) 14)
  (= (fuel-demand city-loc-46 city-loc-19) 28)
  ; 806,18 -> 720,128
  (road city-loc-19 city-loc-46)
  (= (road-length city-loc-19 city-loc-46) 14)
  (= (fuel-demand city-loc-19 city-loc-46) 28)
  ; 720,128 -> 682,8
  (road city-loc-46 city-loc-23)
  (= (road-length city-loc-46 city-loc-23) 13)
  (= (fuel-demand city-loc-46 city-loc-23) 26)
  ; 682,8 -> 720,128
  (road city-loc-23 city-loc-46)
  (= (road-length city-loc-23 city-loc-46) 13)
  (= (fuel-demand city-loc-23 city-loc-46) 26)
  ; 720,128 -> 720,241
  (road city-loc-46 city-loc-30)
  (= (road-length city-loc-46 city-loc-30) 12)
  (= (fuel-demand city-loc-46 city-loc-30) 23)
  ; 720,241 -> 720,128
  (road city-loc-30 city-loc-46)
  (= (road-length city-loc-30 city-loc-46) 12)
  (= (fuel-demand city-loc-30 city-loc-46) 23)
  ; 720,128 -> 858,139
  (road city-loc-46 city-loc-33)
  (= (road-length city-loc-46 city-loc-33) 14)
  (= (fuel-demand city-loc-46 city-loc-33) 28)
  ; 858,139 -> 720,128
  (road city-loc-33 city-loc-46)
  (= (road-length city-loc-33 city-loc-46) 14)
  (= (fuel-demand city-loc-33 city-loc-46) 28)
  ; 720,128 -> 612,304
  (road city-loc-46 city-loc-42)
  (= (road-length city-loc-46 city-loc-42) 21)
  (= (fuel-demand city-loc-46 city-loc-42) 42)
  ; 612,304 -> 720,128
  (road city-loc-42 city-loc-46)
  (= (road-length city-loc-42 city-loc-46) 21)
  (= (fuel-demand city-loc-42 city-loc-46) 42)
  ; 720,128 -> 599,133
  (road city-loc-46 city-loc-45)
  (= (road-length city-loc-46 city-loc-45) 13)
  (= (fuel-demand city-loc-46 city-loc-45) 25)
  ; 599,133 -> 720,128
  (road city-loc-45 city-loc-46)
  (= (road-length city-loc-45 city-loc-46) 13)
  (= (fuel-demand city-loc-45 city-loc-46) 25)
  ; 520,51 -> 384,50
  (road city-loc-47 city-loc-2)
  (= (road-length city-loc-47 city-loc-2) 14)
  (= (fuel-demand city-loc-47 city-loc-2) 28)
  ; 384,50 -> 520,51
  (road city-loc-2 city-loc-47)
  (= (road-length city-loc-2 city-loc-47) 14)
  (= (fuel-demand city-loc-2 city-loc-47) 28)
  ; 520,51 -> 456,221
  (road city-loc-47 city-loc-6)
  (= (road-length city-loc-47 city-loc-6) 19)
  (= (fuel-demand city-loc-47 city-loc-6) 37)
  ; 456,221 -> 520,51
  (road city-loc-6 city-loc-47)
  (= (road-length city-loc-6 city-loc-47) 19)
  (= (fuel-demand city-loc-6 city-loc-47) 37)
  ; 520,51 -> 682,8
  (road city-loc-47 city-loc-23)
  (= (road-length city-loc-47 city-loc-23) 17)
  (= (fuel-demand city-loc-47 city-loc-23) 34)
  ; 682,8 -> 520,51
  (road city-loc-23 city-loc-47)
  (= (road-length city-loc-23 city-loc-47) 17)
  (= (fuel-demand city-loc-23 city-loc-47) 34)
  ; 520,51 -> 347,149
  (road city-loc-47 city-loc-28)
  (= (road-length city-loc-47 city-loc-28) 20)
  (= (fuel-demand city-loc-47 city-loc-28) 40)
  ; 347,149 -> 520,51
  (road city-loc-28 city-loc-47)
  (= (road-length city-loc-28 city-loc-47) 20)
  (= (fuel-demand city-loc-28 city-loc-47) 40)
  ; 520,51 -> 599,133
  (road city-loc-47 city-loc-45)
  (= (road-length city-loc-47 city-loc-45) 12)
  (= (fuel-demand city-loc-47 city-loc-45) 23)
  ; 599,133 -> 520,51
  (road city-loc-45 city-loc-47)
  (= (road-length city-loc-45 city-loc-47) 12)
  (= (fuel-demand city-loc-45 city-loc-47) 23)
  ; 520,51 -> 720,128
  (road city-loc-47 city-loc-46)
  (= (road-length city-loc-47 city-loc-46) 22)
  (= (fuel-demand city-loc-47 city-loc-46) 43)
  ; 720,128 -> 520,51
  (road city-loc-46 city-loc-47)
  (= (road-length city-loc-46 city-loc-47) 22)
  (= (fuel-demand city-loc-46 city-loc-47) 43)
  ; 144,428 -> 273,425
  (road city-loc-48 city-loc-9)
  (= (road-length city-loc-48 city-loc-9) 13)
  (= (fuel-demand city-loc-48 city-loc-9) 26)
  ; 273,425 -> 144,428
  (road city-loc-9 city-loc-48)
  (= (road-length city-loc-9 city-loc-48) 13)
  (= (fuel-demand city-loc-9 city-loc-48) 26)
  ; 144,428 -> 55,605
  (road city-loc-48 city-loc-13)
  (= (road-length city-loc-48 city-loc-13) 20)
  (= (fuel-demand city-loc-48 city-loc-13) 40)
  ; 55,605 -> 144,428
  (road city-loc-13 city-loc-48)
  (= (road-length city-loc-13 city-loc-48) 20)
  (= (fuel-demand city-loc-13 city-loc-48) 40)
  ; 144,428 -> 263,567
  (road city-loc-48 city-loc-15)
  (= (road-length city-loc-48 city-loc-15) 19)
  (= (fuel-demand city-loc-48 city-loc-15) 37)
  ; 263,567 -> 144,428
  (road city-loc-15 city-loc-48)
  (= (road-length city-loc-15 city-loc-48) 19)
  (= (fuel-demand city-loc-15 city-loc-48) 37)
  ; 144,428 -> 36,368
  (road city-loc-48 city-loc-18)
  (= (road-length city-loc-48 city-loc-18) 13)
  (= (fuel-demand city-loc-48 city-loc-18) 25)
  ; 36,368 -> 144,428
  (road city-loc-18 city-loc-48)
  (= (road-length city-loc-18 city-loc-48) 13)
  (= (fuel-demand city-loc-18 city-loc-48) 25)
  ; 144,428 -> 205,275
  (road city-loc-48 city-loc-41)
  (= (road-length city-loc-48 city-loc-41) 17)
  (= (fuel-demand city-loc-48 city-loc-41) 33)
  ; 205,275 -> 144,428
  (road city-loc-41 city-loc-48)
  (= (road-length city-loc-41 city-loc-48) 17)
  (= (fuel-demand city-loc-41 city-loc-48) 33)
  ; 698,799 -> 912,799
  (road city-loc-49 city-loc-4)
  (= (road-length city-loc-49 city-loc-4) 22)
  (= (fuel-demand city-loc-49 city-loc-4) 43)
  ; 912,799 -> 698,799
  (road city-loc-4 city-loc-49)
  (= (road-length city-loc-4 city-loc-49) 22)
  (= (fuel-demand city-loc-4 city-loc-49) 43)
  ; 698,799 -> 564,783
  (road city-loc-49 city-loc-8)
  (= (road-length city-loc-49 city-loc-8) 14)
  (= (fuel-demand city-loc-49 city-loc-8) 27)
  ; 564,783 -> 698,799
  (road city-loc-8 city-loc-49)
  (= (road-length city-loc-8 city-loc-49) 14)
  (= (fuel-demand city-loc-8 city-loc-49) 27)
  ; 698,799 -> 803,858
  (road city-loc-49 city-loc-14)
  (= (road-length city-loc-49 city-loc-14) 12)
  (= (fuel-demand city-loc-49 city-loc-14) 24)
  ; 803,858 -> 698,799
  (road city-loc-14 city-loc-49)
  (= (road-length city-loc-14 city-loc-49) 12)
  (= (fuel-demand city-loc-14 city-loc-49) 24)
  ; 698,799 -> 643,669
  (road city-loc-49 city-loc-32)
  (= (road-length city-loc-49 city-loc-32) 15)
  (= (fuel-demand city-loc-49 city-loc-32) 29)
  ; 643,669 -> 698,799
  (road city-loc-32 city-loc-49)
  (= (road-length city-loc-32 city-loc-49) 15)
  (= (fuel-demand city-loc-32 city-loc-49) 29)
  ; 698,799 -> 560,901
  (road city-loc-49 city-loc-35)
  (= (road-length city-loc-49 city-loc-35) 18)
  (= (fuel-demand city-loc-49 city-loc-35) 35)
  ; 560,901 -> 698,799
  (road city-loc-35 city-loc-49)
  (= (road-length city-loc-35 city-loc-49) 18)
  (= (fuel-demand city-loc-35 city-loc-49) 35)
  ; 698,799 -> 806,647
  (road city-loc-49 city-loc-37)
  (= (road-length city-loc-49 city-loc-37) 19)
  (= (fuel-demand city-loc-49 city-loc-37) 38)
  ; 806,647 -> 698,799
  (road city-loc-37 city-loc-49)
  (= (road-length city-loc-37 city-loc-49) 19)
  (= (fuel-demand city-loc-37 city-loc-49) 38)
  ; 698,799 -> 660,909
  (road city-loc-49 city-loc-43)
  (= (road-length city-loc-49 city-loc-43) 12)
  (= (fuel-demand city-loc-49 city-loc-43) 24)
  ; 660,909 -> 698,799
  (road city-loc-43 city-loc-49)
  (= (road-length city-loc-43 city-loc-49) 12)
  (= (fuel-demand city-loc-43 city-loc-49) 24)
  ; 842,442 -> 890,543
  (road city-loc-50 city-loc-1)
  (= (road-length city-loc-50 city-loc-1) 12)
  (= (fuel-demand city-loc-50 city-loc-1) 23)
  ; 890,543 -> 842,442
  (road city-loc-1 city-loc-50)
  (= (road-length city-loc-1 city-loc-50) 12)
  (= (fuel-demand city-loc-1 city-loc-50) 23)
  ; 842,442 -> 748,385
  (road city-loc-50 city-loc-3)
  (= (road-length city-loc-50 city-loc-3) 11)
  (= (fuel-demand city-loc-50 city-loc-3) 22)
  ; 748,385 -> 842,442
  (road city-loc-3 city-loc-50)
  (= (road-length city-loc-3 city-loc-50) 11)
  (= (fuel-demand city-loc-3 city-loc-50) 22)
  ; 842,442 -> 742,542
  (road city-loc-50 city-loc-7)
  (= (road-length city-loc-50 city-loc-7) 15)
  (= (fuel-demand city-loc-50 city-loc-7) 29)
  ; 742,542 -> 842,442
  (road city-loc-7 city-loc-50)
  (= (road-length city-loc-7 city-loc-50) 15)
  (= (fuel-demand city-loc-7 city-loc-50) 29)
  ; 842,442 -> 930,259
  (road city-loc-50 city-loc-12)
  (= (road-length city-loc-50 city-loc-12) 21)
  (= (fuel-demand city-loc-50 city-loc-12) 41)
  ; 930,259 -> 842,442
  (road city-loc-12 city-loc-50)
  (= (road-length city-loc-12 city-loc-50) 21)
  (= (fuel-demand city-loc-12 city-loc-50) 41)
  ; 842,442 -> 989,457
  (road city-loc-50 city-loc-24)
  (= (road-length city-loc-50 city-loc-24) 15)
  (= (fuel-demand city-loc-50 city-loc-24) 30)
  ; 989,457 -> 842,442
  (road city-loc-24 city-loc-50)
  (= (road-length city-loc-24 city-loc-50) 15)
  (= (fuel-demand city-loc-24 city-loc-50) 30)
  ; 842,442 -> 806,647
  (road city-loc-50 city-loc-37)
  (= (road-length city-loc-50 city-loc-37) 21)
  (= (fuel-demand city-loc-50 city-loc-37) 42)
  ; 806,647 -> 842,442
  (road city-loc-37 city-loc-50)
  (= (road-length city-loc-37 city-loc-50) 21)
  (= (fuel-demand city-loc-37 city-loc-50) 42)
  (at package-1 city-loc-42)
  (= (package-size package-1) 81)
  (at package-2 city-loc-45)
  (= (package-size package-2) 31)
  (at package-3 city-loc-15)
  (= (package-size package-3) 44)
  (at package-4 city-loc-38)
  (= (package-size package-4) 18)
  (at package-5 city-loc-15)
  (= (package-size package-5) 4)
  (at package-6 city-loc-45)
  (= (package-size package-6) 94)
  (at package-7 city-loc-12)
  (= (package-size package-7) 45)
  (at package-8 city-loc-16)
  (= (package-size package-8) 60)
  (at package-9 city-loc-49)
  (= (package-size package-9) 30)
  (at package-10 city-loc-26)
  (= (package-size package-10) 49)
  (at package-11 city-loc-25)
  (= (package-size package-11) 60)
  (at package-12 city-loc-43)
  (= (package-size package-12) 84)
  (at package-13 city-loc-21)
  (= (package-size package-13) 8)
  (at package-14 city-loc-43)
  (= (package-size package-14) 71)
  (at package-15 city-loc-29)
  (= (package-size package-15) 36)
  (at package-16 city-loc-43)
  (= (package-size package-16) 54)
  (at package-17 city-loc-27)
  (= (package-size package-17) 97)
  (at package-18 city-loc-36)
  (= (package-size package-18) 61)
  (at package-19 city-loc-16)
  (= (package-size package-19) 93)
  (at package-20 city-loc-42)
  (= (package-size package-20) 81)
  (has-petrol-station city-loc-1)
  (at truck-1 city-loc-24)
  (ready-loading truck-1)
  (= (capacity truck-1) 100)
  (= (fuel-left truck-1) 619)
  (= (fuel-max truck-1) 619)
  (at truck-2 city-loc-6)
  (ready-loading truck-2)
  (= (capacity truck-2) 100)
  (= (fuel-left truck-2) 619)
  (= (fuel-max truck-2) 619)
  (at truck-3 city-loc-3)
  (ready-loading truck-3)
  (= (capacity truck-3) 100)
  (= (fuel-left truck-3) 619)
  (= (fuel-max truck-3) 619)
  (at truck-4 city-loc-10)
  (ready-loading truck-4)
  (= (capacity truck-4) 100)
  (= (fuel-left truck-4) 619)
  (= (fuel-max truck-4) 619)
 )
 (:goal (and
  (at package-1 city-loc-31)
  (at package-2 city-loc-18)
  (at package-3 city-loc-1)
  (at package-4 city-loc-27)
  (at package-5 city-loc-46)
  (at package-6 city-loc-12)
  (at package-7 city-loc-21)
  (at package-8 city-loc-14)
  (at package-9 city-loc-13)
  (at package-10 city-loc-43)
  (at package-11 city-loc-3)
  (at package-12 city-loc-9)
  (at package-13 city-loc-32)
  (at package-14 city-loc-37)
  (at package-15 city-loc-3)
  (at package-16 city-loc-40)
  (at package-17 city-loc-21)
  (at package-18 city-loc-28)
  (at package-19 city-loc-37)
  (at package-20 city-loc-41)
 ))
 (:metric minimize (total-time))
)
