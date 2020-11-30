(define   (problem parking)
  (:domain parking)
  (:objects
     car_00  car_01  car_02  car_03  car_04  car_05  car_06  car_07  car_08  car_09  car_10 - car
     curb_0 curb_1 curb_2 curb_3 curb_4 curb_5 curb_6 - curb
  )
  (:init
    (at-curb car_09)
    (at-curb-num car_09 curb_0)
    (behind-car car_07 car_09)
    (car-clear car_07)
    (at-curb car_08)
    (at-curb-num car_08 curb_1)
    (behind-car car_10 car_08)
    (car-clear car_10)
    (at-curb car_03)
    (at-curb-num car_03 curb_2)
    (behind-car car_02 car_03)
    (car-clear car_02)
    (at-curb car_00)
    (at-curb-num car_00 curb_3)
    (behind-car car_01 car_00)
    (car-clear car_01)
    (at-curb car_05)
    (at-curb-num car_05 curb_4)
    (car-clear car_05)
    (at-curb car_04)
    (at-curb-num car_04 curb_5)
    (car-clear car_04)
    (at-curb car_06)
    (at-curb-num car_06 curb_6)
    (car-clear car_06)
  )
  (:goal
    (and
      (at-curb-num car_00 curb_0)
      (behind-car car_07 car_00)
      (at-curb-num car_01 curb_1)
      (behind-car car_08 car_01)
      (at-curb-num car_02 curb_2)
      (behind-car car_09 car_02)
      (at-curb-num car_03 curb_3)
      (behind-car car_10 car_03)
      (at-curb-num car_04 curb_4)
      (at-curb-num car_05 curb_5)
      (at-curb-num car_06 curb_6)
    )
  )
(:metric minimize (total-time))
)
; =========== INIT =========== 
;  curb_0: car_09 car_07 
;  curb_1: car_08 car_10 
;  curb_2: car_03 car_02 
;  curb_3: car_00 car_01 
;  curb_4: car_05 
;  curb_5: car_04 
;  curb_6: car_06 
; ========== /INIT =========== 

; =========== GOAL =========== 
;  curb_0: car_00 car_07 
;  curb_1: car_01 car_08 
;  curb_2: car_02 car_09 
;  curb_3: car_03 car_10 
;  curb_4: car_04 
;  curb_5: car_05 
;  curb_6: car_06 
; =========== /GOAL =========== 
