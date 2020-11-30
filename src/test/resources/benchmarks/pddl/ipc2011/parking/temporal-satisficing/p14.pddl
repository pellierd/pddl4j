(define   (problem parking)
  (:domain parking)
  (:objects
     car_00  car_01  car_02  car_03  car_04  car_05  car_06  car_07  car_08  car_09  car_10  car_11  car_12  car_13  car_14  car_15  car_16  car_17 - car
     curb_00 curb_01 curb_02 curb_03 curb_04 curb_05 curb_06 curb_07 curb_08 curb_09 curb_10 - curb
  )
  (:init
    (at-curb car_14)
    (at-curb-num car_14 curb_00)
    (behind-car car_13 car_14)
    (car-clear car_13)
    (at-curb car_00)
    (at-curb-num car_00 curb_01)
    (behind-car car_10 car_00)
    (car-clear car_10)
    (at-curb car_07)
    (at-curb-num car_07 curb_02)
    (behind-car car_04 car_07)
    (car-clear car_04)
    (at-curb car_09)
    (at-curb-num car_09 curb_03)
    (behind-car car_01 car_09)
    (car-clear car_01)
    (at-curb car_06)
    (at-curb-num car_06 curb_04)
    (behind-car car_17 car_06)
    (car-clear car_17)
    (at-curb car_02)
    (at-curb-num car_02 curb_05)
    (behind-car car_11 car_02)
    (car-clear car_11)
    (at-curb car_03)
    (at-curb-num car_03 curb_06)
    (behind-car car_15 car_03)
    (car-clear car_15)
    (at-curb car_05)
    (at-curb-num car_05 curb_07)
    (car-clear car_05)
    (at-curb car_16)
    (at-curb-num car_16 curb_08)
    (car-clear car_16)
    (at-curb car_08)
    (at-curb-num car_08 curb_09)
    (car-clear car_08)
    (at-curb car_12)
    (at-curb-num car_12 curb_10)
    (car-clear car_12)
  )
  (:goal
    (and
      (at-curb-num car_00 curb_00)
      (behind-car car_11 car_00)
      (at-curb-num car_01 curb_01)
      (behind-car car_12 car_01)
      (at-curb-num car_02 curb_02)
      (behind-car car_13 car_02)
      (at-curb-num car_03 curb_03)
      (behind-car car_14 car_03)
      (at-curb-num car_04 curb_04)
      (behind-car car_15 car_04)
      (at-curb-num car_05 curb_05)
      (behind-car car_16 car_05)
      (at-curb-num car_06 curb_06)
      (behind-car car_17 car_06)
      (at-curb-num car_07 curb_07)
      (at-curb-num car_08 curb_08)
      (at-curb-num car_09 curb_09)
      (at-curb-num car_10 curb_10)
    )
  )
(:metric minimize (total-time))
)
; =========== INIT =========== 
;  curb_00: car_14 car_13 
;  curb_01: car_00 car_10 
;  curb_02: car_07 car_04 
;  curb_03: car_09 car_01 
;  curb_04: car_06 car_17 
;  curb_05: car_02 car_11 
;  curb_06: car_03 car_15 
;  curb_07: car_05 
;  curb_08: car_16 
;  curb_09: car_08 
;  curb_10: car_12 
; ========== /INIT =========== 

; =========== GOAL =========== 
;  curb_00: car_00 car_11 
;  curb_01: car_01 car_12 
;  curb_02: car_02 car_13 
;  curb_03: car_03 car_14 
;  curb_04: car_04 car_15 
;  curb_05: car_05 car_16 
;  curb_06: car_06 car_17 
;  curb_07: car_07 
;  curb_08: car_08 
;  curb_09: car_09 
;  curb_10: car_10 
; =========== /GOAL =========== 
