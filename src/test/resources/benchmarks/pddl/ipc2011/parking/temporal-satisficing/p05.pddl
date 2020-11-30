(define   (problem parking)
  (:domain parking)
  (:objects
     car_00  car_01  car_02  car_03  car_04  car_05  car_06  car_07  car_08  car_09  car_10  car_11  car_12 - car
     curb_0 curb_1 curb_2 curb_3 curb_4 curb_5 curb_6 curb_7 - curb
  )
  (:init
    (at-curb car_02)
    (at-curb-num car_02 curb_0)
    (behind-car car_08 car_02)
    (car-clear car_08)
    (at-curb car_03)
    (at-curb-num car_03 curb_1)
    (behind-car car_10 car_03)
    (car-clear car_10)
    (at-curb car_01)
    (at-curb-num car_01 curb_2)
    (behind-car car_11 car_01)
    (car-clear car_11)
    (at-curb car_12)
    (at-curb-num car_12 curb_3)
    (behind-car car_07 car_12)
    (car-clear car_07)
    (at-curb car_06)
    (at-curb-num car_06 curb_4)
    (behind-car car_00 car_06)
    (car-clear car_00)
    (at-curb car_09)
    (at-curb-num car_09 curb_5)
    (car-clear car_09)
    (at-curb car_04)
    (at-curb-num car_04 curb_6)
    (car-clear car_04)
    (at-curb car_05)
    (at-curb-num car_05 curb_7)
    (car-clear car_05)
  )
  (:goal
    (and
      (at-curb-num car_00 curb_0)
      (behind-car car_08 car_00)
      (at-curb-num car_01 curb_1)
      (behind-car car_09 car_01)
      (at-curb-num car_02 curb_2)
      (behind-car car_10 car_02)
      (at-curb-num car_03 curb_3)
      (behind-car car_11 car_03)
      (at-curb-num car_04 curb_4)
      (behind-car car_12 car_04)
      (at-curb-num car_05 curb_5)
      (at-curb-num car_06 curb_6)
      (at-curb-num car_07 curb_7)
    )
  )
(:metric minimize (total-time))
)
; =========== INIT =========== 
;  curb_0: car_02 car_08 
;  curb_1: car_03 car_10 
;  curb_2: car_01 car_11 
;  curb_3: car_12 car_07 
;  curb_4: car_06 car_00 
;  curb_5: car_09 
;  curb_6: car_04 
;  curb_7: car_05 
; ========== /INIT =========== 

; =========== GOAL =========== 
;  curb_0: car_00 car_08 
;  curb_1: car_01 car_09 
;  curb_2: car_02 car_10 
;  curb_3: car_03 car_11 
;  curb_4: car_04 car_12 
;  curb_5: car_05 
;  curb_6: car_06 
;  curb_7: car_07 
; =========== /GOAL =========== 
