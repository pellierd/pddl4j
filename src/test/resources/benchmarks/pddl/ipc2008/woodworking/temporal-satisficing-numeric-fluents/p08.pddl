; woodworking sawing task with 10 parts
; Machines:
;   3 highspeed-saw
;   1 saw
; random seed: 616528

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    highspeed-saw0 highspeed-saw1 highspeed-saw2 - highspeed-saw
    saw0 - saw
    black white red green blue mauve - acolour
    beech pine cherry - awood
    p0 p1 p2 p3 p4 p5 p6 p7 p8 p9 - part
    b0 b1 b2 - board
  )
  (:init
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle highspeed-saw1)
    (empty highspeed-saw1)
    (idle highspeed-saw2)
    (empty highspeed-saw2)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 11)
    (unused p1)
    (= (goal-size p1) 10)
    (unused p2)
    (= (goal-size p2) 11)
    (unused p3)
    (= (goal-size p3) 8)
    (unused p4)
    (= (goal-size p4) 8)
    (unused p5)
    (= (goal-size p5) 15)
    (unused p6)
    (= (goal-size p6) 14)
    (unused p7)
    (= (goal-size p7) 9)
    (unused p8)
    (= (goal-size p8) 11)
    (unused p9)
    (= (goal-size p9) 13)
    (= (board-size b0) 46)
    (wood b0 beech)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 19)
    (wood b1 cherry)
    (surface-condition b1 rough)
    (available b1)
    (= (board-size b2) 45)
    (wood b2 pine)
    (surface-condition b2 rough)
    (available b2)
  )
  (:goal
    (and
      (available p0)
      (wood p0 pine)
      (available p1)
      (wood p1 pine)
      (available p2)
      (available p3)
      (wood p3 cherry)
      (available p4)
      (wood p4 beech)
      (available p5)
      (available p6)
      (available p7)
      (available p8)
      (wood p8 cherry)
      (available p9)
      (wood p9 pine)
    )
  )
  (:metric minimize (total-time))
)
