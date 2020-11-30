; woodworking sawing task with 6 parts
; Machines:
;   2 highspeed-saw
;   1 saw
; random seed: 878768

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    highspeed-saw0 highspeed-saw1 - highspeed-saw
    saw0 - saw
    black white red green - acolour
    pine cherry - awood
    p0 p1 p2 p3 p4 p5 - part
    b0 b1 - board
  )
  (:init
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle highspeed-saw1)
    (empty highspeed-saw1)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 10)
    (unused p1)
    (= (goal-size p1) 6)
    (unused p2)
    (= (goal-size p2) 11)
    (unused p3)
    (= (goal-size p3) 12)
    (unused p4)
    (= (goal-size p4) 10)
    (unused p5)
    (= (goal-size p5) 9)
    (= (board-size b0) 27)
    (wood b0 cherry)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 31)
    (wood b1 pine)
    (surface-condition b1 rough)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (available p1)
      (available p2)
      (wood p2 cherry)
      (available p3)
      (available p4)
      (wood p4 cherry)
      (available p5)
      (wood p5 pine)
    )
  )
  (:metric minimize (total-time))
)
