; woodworking sawing task with 5 parts
; Machines:
;   2 highspeed-saw
;   1 saw
; random seed: 275074

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    highspeed-saw0 highspeed-saw1 - highspeed-saw
    saw0 - saw
    black white red green - acolour
    walnut beech - awood
    p0 p1 p2 p3 p4 - part
    b0 b1 - board
  )
  (:init
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle highspeed-saw1)
    (empty highspeed-saw1)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 5)
    (unused p1)
    (= (goal-size p1) 9)
    (unused p2)
    (= (goal-size p2) 5)
    (unused p3)
    (= (goal-size p3) 8)
    (unused p4)
    (= (goal-size p4) 11)
    (= (board-size b0) 30)
    (wood b0 beech)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 8)
    (wood b1 beech)
    (surface-condition b1 rough)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (available p1)
      (available p2)
      (available p3)
      (available p4)
      (wood p4 beech)
    )
  )
  (:metric minimize (total-time))
)
