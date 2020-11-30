; woodworking sawing task with 8 parts
; Machines:
;   2 highspeed-saw
;   1 saw
; random seed: 296277

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    highspeed-saw0 highspeed-saw1 - highspeed-saw
    saw0 - saw
    black white red green blue mauve - acolour
    pine cherry - awood
    p0 p1 p2 p3 p4 p5 p6 p7 - part
    b0 b1 b2 - board
  )
  (:init
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle highspeed-saw1)
    (empty highspeed-saw1)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 7)
    (unused p1)
    (= (goal-size p1) 6)
    (unused p2)
    (= (goal-size p2) 9)
    (unused p3)
    (= (goal-size p3) 10)
    (unused p4)
    (= (goal-size p4) 5)
    (unused p5)
    (= (goal-size p5) 10)
    (unused p6)
    (= (goal-size p6) 15)
    (unused p7)
    (= (goal-size p7) 14)
    (= (board-size b0) 38)
    (wood b0 cherry)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 10)
    (wood b1 cherry)
    (surface-condition b1 rough)
    (available b1)
    (= (board-size b2) 28)
    (wood b2 pine)
    (surface-condition b2 rough)
    (available b2)
  )
  (:goal
    (and
      (available p0)
      (available p1)
      (wood p1 pine)
      (available p2)
      (wood p2 cherry)
      (available p3)
      (available p4)
      (available p5)
      (available p6)
      (available p7)
      (wood p7 cherry)
    )
  )
  (:metric minimize (total-time))
)
