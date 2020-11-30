(define   (problem parking)
  (:domain parking)
  (:objects
     car_00  car_01  car_02  car_03  car_04  car_05  car_06  car_07  car_08  car_09  car_10  car_11  car_12  car_13  car_14 - car
     curb_0 curb_1 curb_2 curb_3 curb_4 curb_5 curb_6 curb_7 curb_8 - curb
  )
  (:init
    (at-curb car_03)
    (at-curb-num car_03 curb_0)
    (behind-car car_08 car_03)
    (car-clear car_08)
    (at-curb car_05)
    (at-curb-num car_05 curb_1)
    (behind-car car_09 car_05)
    (car-clear car_09)
    (at-curb car_07)
    (at-curb-num car_07 curb_2)
    (behind-car car_06 car_07)
    (car-clear car_06)
    (at-curb car_02)
    (at-curb-num car_02 curb_3)
    (behind-car car_04 car_02)
    (car-clear car_04)
    (at-curb car_13)
    (at-curb-num car_13 curb_4)
    (behind-car car_14 car_13)
    (car-clear car_14)
    (at-curb car_11)
    (at-curb-num car_11 curb_5)
    (behind-car car_01 car_11)
    (car-clear car_01)
    (at-curb car_12)
    (at-curb-num car_12 curb_6)
    (behind-car car_00 car_12)
    (car-clear car_00)
    (at-curb car_10)
    (at-curb-num car_10 curb_7)
    (car-clear car_10)
    (curb-clear curb_8)
  )
  (:goal
    (and
      (at-curb-num car_00 curb_0)
      (behind-car car_09 car_00)
      (at-curb-num car_01 curb_1)
      (behind-car car_10 car_01)
      (at-curb-num car_02 curb_2)
      (behind-car car_11 car_02)
      (at-curb-num car_03 curb_3)
      (behind-car car_12 car_03)
      (at-curb-num car_04 curb_4)
      (behind-car car_13 car_04)
      (at-curb-num car_05 curb_5)
      (behind-car car_14 car_05)
      (at-curb-num car_06 curb_6)
      (at-curb-num car_07 curb_7)
      (at-curb-num car_08 curb_8)
    )
  )
(:metric minimize (total-time))
)
; =========== INIT =========== 
;  curb_0: car_03 car_08 
;  curb_1: car_05 car_09 
;  curb_2: car_07 car_06 
;  curb_3: car_02 car_04 
;  curb_4: car_13 car_14 
;  curb_5: car_11 car_01 
;  curb_6: car_12 car_00 
;  curb_7: car_10 
;  curb_8: 
; ========== /INIT =========== 

; =========== GOAL =========== 
;  curb_0: car_00 car_09 
;  curb_1: car_01 car_10 
;  curb_2: car_02 car_11 
;  curb_3: car_03 car_12 
;  curb_4: car_04 car_13 
;  curb_5: car_05 car_14 
;  curb_6: car_06 
;  curb_7: car_07 
;  curb_8: car_08 
; =========== /GOAL =========== 
