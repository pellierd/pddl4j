; woodworking sawing task with 3 parts
; Machines:
;   1 highspeed-saw
;   1 saw
; random seed: 973895

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    highspeed-saw0 - highspeed-saw
    saw0 - saw
    black white - acolour
    cherry oak - awood
    p0 p1 p2 - part
    b0 b1 - board
  )
  (:init
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 7)
    (unused p1)
    (= (goal-size p1) 11)
    (unused p2)
    (= (goal-size p2) 9)
    (= (board-size b0) 9)
    (wood b0 cherry)
    (surface-condition b0 smooth)
    (available b0)
    (= (board-size b1) 18)
    (wood b1 oak)
    (surface-condition b1 rough)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (wood p0 oak)
      (available p1)
      (available p2)
      (wood p2 cherry)
    )
  )
  (:metric minimize (total-time))
)
