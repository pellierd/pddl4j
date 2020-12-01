(define   (problem parking)
  (:domain parking)
  (:objects
     car_0  car_1  car_2  car_3  car_4  car_5  car_6  car_7  car_8  car_9 - car
     curb_00 curb_01 curb_02 curb_03 curb_04 curb_05 curb_06 curb_07 curb_08 curb_09 curb_10 curb_11 curb_12 curb_13 curb_14 curb_15 - curb
  )
  (:init
    (at-curb car_4)
    (at-curb-num car_4 curb_00)
    (behind-car car_8 car_4)
    (car-clear car_8)
    (at-curb car_2)
    (at-curb-num car_2 curb_01)
    (behind-car car_9 car_2)
    (car-clear car_9)
    (at-curb car_1)
    (at-curb-num car_1 curb_02)
    (behind-car car_0 car_1)
    (car-clear car_0)
    (at-curb car_6)
    (at-curb-num car_6 curb_03)
    (behind-car car_7 car_6)
    (car-clear car_7)
    (at-curb car_5)
    (at-curb-num car_5 curb_04)
    (behind-car car_3 car_5)
    (car-clear car_3)
    (curb-clear curb_05)
    (curb-clear curb_06)
    (curb-clear curb_07)
    (curb-clear curb_08)
    (curb-clear curb_09)
    (curb-clear curb_10)
    (curb-clear curb_11)
    (curb-clear curb_12)
    (curb-clear curb_13)
    (curb-clear curb_14)
    (curb-clear curb_15)
  )
  (:goal
    (and
      (at-curb-num car_0 curb_00)
      (at-curb-num car_1 curb_01)
      (at-curb-num car_2 curb_02)
      (at-curb-num car_3 curb_03)
      (at-curb-num car_4 curb_04)
      (at-curb-num car_5 curb_05)
      (at-curb-num car_6 curb_06)
      (at-curb-num car_7 curb_07)
      (at-curb-num car_8 curb_08)
      (at-curb-num car_9 curb_09)
    )
  )
(:metric minimize (total-time))
)
; =========== INIT =========== 
;  curb_00: car_4 car_8 
;  curb_01: car_2 car_9 
;  curb_02: car_1 car_0 
;  curb_03: car_6 car_7 
;  curb_04: car_5 car_3 
;  curb_05: 
;  curb_06: 
;  curb_07: 
;  curb_08: 
;  curb_09: 
;  curb_10: 
;  curb_11: 
;  curb_12: 
;  curb_13: 
;  curb_14: 
;  curb_15: 
; ========== /INIT =========== 

; =========== GOAL =========== 
;  curb_00: car_0 
;  curb_01: car_1 
;  curb_02: car_2 
;  curb_03: car_3 
;  curb_04: car_4 
;  curb_05: car_5 
;  curb_06: car_6 
;  curb_07: car_7 
;  curb_08: car_8 
;  curb_09: car_9 
;  curb_10: 
;  curb_11: 
;  curb_12: 
;  curb_13: 
;  curb_14: 
;  curb_15: 
; =========== /GOAL =========== 
